package com.wan.gmmod.common.network.packet;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.capability.ModAttachments;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record UseAbilityPacket(int dummy) implements CustomPacketPayload {
    public static final Type<UseAbilityPacket> TYPE = new Type<>(GuimiMod.id("use_ability"));
    public static final StreamCodec<FriendlyByteBuf, UseAbilityPacket> STREAM_CODEC =
            StreamCodec.unit(new UseAbilityPacket(0));

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(UseAbilityPacket msg, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            // 检查玩家是否有灵性值
            int spirituality = player.getData(ModAttachments.SPIRITUALITY);
            if (spirituality < 10) {
                player.sendSystemMessage(Component.translatable("ability.guimi_mod.seer_divination.no_spirituality"));
                return;
            }
            // 消耗灵性
            player.setData(ModAttachments.SPIRITUALITY, spirituality - 10);
            int acting = player.getData(ModAttachments.ACTING_PROGRESS);
            player.setData(ModAttachments.ACTING_PROGRESS, Math.min(100, acting + 2));
            player.sendSystemMessage(Component.translatable("ability.guimi_mod.seer_divination.use"));
        });
    }
}