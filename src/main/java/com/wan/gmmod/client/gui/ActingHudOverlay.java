package com.wan.gmmod.client.gui;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.capability.ModAttachments;
import com.wan.gmmod.content.sequences.Sequences;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import java.util.EnumMap;
import java.util.Map;

/**
 * 左上角统一状态 HUD。
 * <p>
 * 由一张大底图 + 可切换的途径徽章 + 动态绘制的文字组成：
 * <ul>
 *     <li>底图：{@code assets/guimi_mod/textures/gui/hud/hud_base.png}
 *     （尺寸 {@value #BASE_WIDTH}x{@value #BASE_HEIGHT}，左侧预留徽章位，右侧预留四行文字位，由用户提供）；</li>
 *     <li>徽章：{@code assets/guimi_mod/textures/gui/hud/badge_{途径key}.png}
 *     （尺寸 {@value #BADGE_SIZE}x{@value #BADGE_SIZE}，如 badge_fool.png，由用户提供）。
 *     未成为非凡者时徽章位留空（不绘制任何徽章）；</li>
 *     <li>文字（代码动态绘制，从上到下）：序列名称与途径、灵性、污染、扮演进度。</li>
 * </ul>
 */
@EventBusSubscriber(modid = GuimiMod.MODID, value = Dist.CLIENT)
public class ActingHudOverlay {

    /** HUD 底图（一张大图片，包含边框、徽章底座与文字底纹） */
    private static final ResourceLocation HUD_BASE = GuimiMod.id("textures/gui/hud/hud_base.png");

    /** 底图绘制尺寸（同时也是 PNG 的像素尺寸） */
    private static final int BASE_WIDTH = 160;
    private static final int BASE_HEIGHT = 68;
    /** HUD 在屏幕左上角的位置 */
    private static final int HUD_X = 4;
    private static final int HUD_Y = 4;

    /** 徽章绘制尺寸（同时也是 PNG 的像素尺寸）与其在底图内的偏移 */
    private static final int BADGE_SIZE = 48;
    private static final int BADGE_OFFSET_X = 8;
    private static final int BADGE_OFFSET_Y = 10;

    /** 文字区在底图内的偏移与行距 */
    private static final int TEXT_OFFSET_X = 62;
    private static final int TEXT_OFFSET_Y = 9;
    private static final int LINE_HEIGHT = 13;

    /** 途径 -> 徽章贴图（badge_{key}.png），启动时一次性构建 */
    private static final Map<Sequences.Pathway, ResourceLocation> BADGES = new EnumMap<>(Sequences.Pathway.class);

    static {
        for (Sequences.Pathway pathway : Sequences.Pathway.values()) {
            BADGES.put(pathway, GuimiMod.id("textures/gui/hud/badge_" + pathway.getKey() + ".png"));
        }
    }

    @SubscribeEvent
    public static void registerLayer(RegisterGuiLayersEvent event) {
        event.registerAboveAll(GuimiMod.id("acting_hud"), ActingHudOverlay::render);
    }

    private static void render(GuiGraphics graphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.options.hideGui || com.wan.gmmod.client.HudClientState.isHidden()) return;

        int seq = player.getData(ModAttachments.SEQUENCE_LEVEL);
        Sequences.Pathway pathway = Sequences.fromKey(player.getData(ModAttachments.PATHWAY));

        // 1. 底图：一张大图片整体绘制
        graphics.blit(HUD_BASE, HUD_X, HUD_Y, 0, 0, BASE_WIDTH, BASE_HEIGHT, BASE_WIDTH, BASE_HEIGHT);

        // 2. 徽章：按当前途径切换贴图；未成为非凡者（无途径）时留空
        boolean beyonder = seq > 0 && pathway != null;
        if (beyonder) {
            graphics.blit(BADGES.get(pathway), HUD_X + BADGE_OFFSET_X, HUD_Y + BADGE_OFFSET_Y,
                    0, 0, BADGE_SIZE, BADGE_SIZE, BADGE_SIZE, BADGE_SIZE);
        }

        // 3. 动态文字：从上到下依次为 序列名称途径 / 灵性 / 污染 / 扮演进度
        int spirituality = player.getData(ModAttachments.SPIRITUALITY);
        int pollution = player.getData(ModAttachments.POLLUTION);
        int acting = player.getData(ModAttachments.ACTING_PROGRESS);

        String title = beyonder
                ? "序列" + seq + " " + pathway.getSequenceName(seq) + " · " + pathway.getDisplayName()
                : "凡人";

        int textX = HUD_X + TEXT_OFFSET_X;
        int textY = HUD_Y + TEXT_OFFSET_Y;
        // 灵性显示为 当前/上限，上限随序列成长（序列0显示为∞）
        int maxSpirituality = com.wan.gmmod.content.spirituality.SpiritualityManager.getMax(player);
        String spiritText = "灵性: " + spirituality + "/"
                + (com.wan.gmmod.content.spirituality.SpiritualityManager.isInfinite(maxSpirituality)
                        ? "∞" : maxSpirituality);
        graphics.drawString(mc.font, Component.literal(title), textX, textY, 0xFFD700);
        graphics.drawString(mc.font, Component.literal(spiritText), textX, textY + LINE_HEIGHT, 0x00BFFF);
        graphics.drawString(mc.font, Component.literal("污染: " + pollution), textX, textY + LINE_HEIGHT * 2, 0xFF6347);
        graphics.drawString(mc.font, Component.literal("扮演: " + acting + "%"), textX, textY + LINE_HEIGHT * 3, 0xDA70D6);
    }
}
