package com.wan.gmmod.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.capability.ModAttachments;
import com.wan.gmmod.common.capability.data.QuestData;
import com.wan.gmmod.content.exp.ExperimentalPathways;
import com.wan.gmmod.content.quest.QuestManager;
import com.wan.gmmod.content.quest.Task;
import com.wan.gmmod.content.quest.TaskRegistry;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.Collection;
import java.util.List;

/**
 * 模组调试 / 管理命令。
 * <p>
 * {@code /guimi max [玩家...]}：将灵性与扮演进度直接拉满（均为 100），
 * 不带参数时作用于命令执行者本人。需要 OP 权限（等级 2）。
 * <p>
 * {@code /guimi demote [玩家...]}：消除途径、贬为凡人（清空序列 / 途径 / 扮演 / 灵性）。
 * <p>
 * {@code /guimi experimental <on|off|reset|status>}：临时开关实验性途径能力
 * （运行时覆盖，reset 恢复跟随配置文件）。
 */
@EventBusSubscriber(modid = GuimiMod.MODID)
public final class ModCommands {

    private ModCommands() {}

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        register(event.getDispatcher());
    }

    private static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("guimi")
                .requires(source -> source.hasPermission(2))
                .then(Commands.literal("max")
                        .executes(ctx -> maxOut(ctx.getSource(),
                                List.of(ctx.getSource().getPlayerOrException())))
                        .then(Commands.argument("targets", EntityArgument.players())
                                .executes(ctx -> maxOut(ctx.getSource(),
                                        EntityArgument.getPlayers(ctx, "targets")))))
                .then(Commands.literal("experimental")
                        .then(Commands.literal("on").executes(ctx -> setExperimental(ctx.getSource(), Boolean.TRUE)))
                        .then(Commands.literal("off").executes(ctx -> setExperimental(ctx.getSource(), Boolean.FALSE)))
                        .then(Commands.literal("reset").executes(ctx -> setExperimental(ctx.getSource(), null)))
                        .then(Commands.literal("status").executes(ctx -> experimentalStatus(ctx.getSource()))))
                .then(Commands.literal("quest")
                        .then(Commands.literal("force")
                                .then(Commands.argument("task", ResourceLocationArgument.id())
                                        .executes(ctx -> forceAccept(ctx.getSource(),
                                                ResourceLocationArgument.getId(ctx, "task")))))
                        .then(Commands.literal("complete")
                                .then(Commands.argument("task", ResourceLocationArgument.id())
                                        .executes(ctx -> forceComplete(ctx.getSource(),
                                                ResourceLocationArgument.getId(ctx, "task")))))
                .then(Commands.literal("reset")
                        .executes(ctx -> resetQuest(ctx.getSource(),
                                List.of(ctx.getSource().getPlayerOrException())))
                        .then(Commands.argument("targets", EntityArgument.players())
                                .executes(ctx -> resetQuest(ctx.getSource(),
                                        EntityArgument.getPlayers(ctx, "targets"))))))
                .then(Commands.literal("demote")
                        .executes(ctx -> demote(ctx.getSource(),
                                List.of(ctx.getSource().getPlayerOrException())))
                        .then(Commands.argument("targets", EntityArgument.players())
                                .executes(ctx -> demote(ctx.getSource(),
                                        EntityArgument.getPlayers(ctx, "targets"))))));
    }

    /** 跳过条件强制接取任务。 */
    private static int forceAccept(CommandSourceStack source, ResourceLocation id) throws CommandSyntaxException {
        Task task = TaskRegistry.get(id);
        if (task == null) {
            source.sendFailure(Component.translatable("command.guimi_mod.quest.not_found", id));
            return 0;
        }
        ServerPlayer player = source.getPlayerOrException();
        QuestManager.accept(player, task);
        return 1;
    }

    /** 跳过进度强制完成任务并发放奖励。 */
    private static int forceComplete(CommandSourceStack source, ResourceLocation id) throws CommandSyntaxException {
        Task task = TaskRegistry.get(id);
        if (task == null) {
            source.sendFailure(Component.translatable("command.guimi_mod.quest.not_found", id));
            return 0;
        }
        ServerPlayer player = source.getPlayerOrException();
        QuestData data = QuestManager.data(player);
        if (!data.hasActive(id.toString())) {
            QuestData withActive = data.withActive(id.toString());
            player.setData(ModAttachments.QUEST_DATA, withActive);
        }
        QuestManager.complete(player, task);
        return 1;
    }

    /** 清空玩家的任务进度 / 追踪 / 完成记录。 */
    private static int resetQuest(CommandSourceStack source, Collection<ServerPlayer> targets) {
        for (ServerPlayer player : targets) {
            player.setData(ModAttachments.QUEST_DATA, QuestData.empty());
        }
        source.sendSuccess(() -> Component.translatable("command.guimi_mod.quest.reset", targets.size()), true);
        return targets.size();
    }

    /** 设置实验性途径能力的运行时开关（null = 恢复跟随配置文件）。 */
    private static int setExperimental(CommandSourceStack source, Boolean value) {
        ExperimentalPathways.setRuntimeOverride(value);
        return experimentalStatus(source);
    }

    /** 查询实验性途径能力当前状态。 */
    private static int experimentalStatus(CommandSourceStack source) {
        boolean enabled = ExperimentalPathways.isEnabled();
        source.sendSuccess(() -> Component.translatable(
                enabled ? "command.guimi_mod.experimental.on" : "command.guimi_mod.experimental.off"), true);
        return enabled ? 1 : 0;
    }

    /** 消除途径，贬为凡人：清空序列等级 / 途径 / 扮演进度与灵性。 */
    private static int demote(CommandSourceStack source, Collection<ServerPlayer> targets) {
        for (ServerPlayer player : targets) {
            // 女巫「性别转换」：离开魔女途径（贬为凡人）时解除女性形态
            if (player.getData(ModAttachments.FEMALE_FORM)) {
                player.setData(ModAttachments.FEMALE_FORM, false);
                com.wan.gmmod.content.witch.FemaleGenderCompat.setFemale(player, false);
            }
            player.setData(ModAttachments.SEQUENCE_LEVEL, 0);
            player.setData(ModAttachments.PATHWAY, "");
            player.setData(ModAttachments.ACTING_SEQUENCE_ID, "");
            player.setData(ModAttachments.ACTING_PROGRESS, 0);
            player.setData(ModAttachments.SPIRITUALITY, 0);
            player.displayClientMessage(
                    Component.translatable("command.guimi_mod.demote.applied"), false);
        }
        source.sendSuccess(() -> Component.translatable(
                "command.guimi_mod.demote.success", targets.size()), true);
        return targets.size();
    }

    /** 将目标玩家的灵性与扮演进度设为满值（灵性拉到当前动态上限）。 */
    private static int maxOut(CommandSourceStack source, Collection<ServerPlayer> targets) {
        for (ServerPlayer player : targets) {
            int max = com.wan.gmmod.content.spirituality.SpiritualityManager.getMax(player);
            // 序列0上限无限时取一个实用的满值
            if (com.wan.gmmod.content.spirituality.SpiritualityManager.isInfinite(max)) {
                max = 10000;
            }
            player.setData(ModAttachments.SPIRITUALITY, max);
            player.setData(ModAttachments.ACTING_PROGRESS, 100);
            player.displayClientMessage(
                    Component.translatable("command.guimi_mod.max.applied"), false);
        }
        source.sendSuccess(() -> Component.translatable(
                "command.guimi_mod.max.success", targets.size()), true);
        return targets.size();
    }
}
