package com.wan.gmmod.client.gui;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.capability.ModAttachments;
import com.wan.gmmod.content.sequences.Sequences;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

/**
 * 左上角状态 HUD。
 * <p>
 * 无面板的紧凑排版，配「神秘符文」花纹装饰（像素级绘制，不依赖贴图）：
 * <ul>
 *     <li>左侧贯穿金线（封印标尺）+ 两端轴头；</li>
 *     <li>标题前八角星符；</li>
 *     <li>标题下横幅花纹线，中央镶嵌菱形；</li>
 *     <li>底部一排对称符文菱形链；</li>
 *     <li>三条细进度栏，两端配金点。</li>
 * </ul>
 * 全部装饰为 1~3 像素细线与小符文，不遮挡视野。
 */
@EventBusSubscriber(modid = GuimiMod.MODID, value = Dist.CLIENT)
public class ActingHudOverlay {

    private static final int HUD_X = 4;
    private static final int HUD_Y = 4;

    /** 进度栏：标签列宽 + 条宽 */
    private static final int LABEL_W = 30;
    private static final int BAR_W = 86;

    /** 配色（金 / 暗红 / 墨蓝，诡秘之主风格） */
    private static final int GOLD = 0xFFC9A45C;
    private static final int TITLE_COLOR = 0xFFE8C96A;
    private static final int MORTAL_COLOR = 0xFF9A958C;
    private static final int LABEL_COLOR = 0xFFD8CFC0;

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
        boolean beyonder = seq > 0 && pathway != null;

        String title = beyonder
                ? "序列" + seq + " " + pathway.getSequenceName(seq) + " · " + pathway.getDisplayName()
                : "凡人";

        int spirituality = player.getData(ModAttachments.SPIRITUALITY);
        int pollution = player.getData(ModAttachments.POLLUTION);
        int acting = player.getData(ModAttachments.ACTING_PROGRESS);
        int maxSpirituality = com.wan.gmmod.content.spirituality.SpiritualityManager.getMax(player);
        boolean infiniteSpirit = com.wan.gmmod.content.spirituality.SpiritualityManager.isInfinite(maxSpirituality);
        int maxPollution = ModAttachments.MAX_POLLUTION;

        int x = HUD_X, y = HUD_Y;
        int cx = x + 6;
        int hw = LABEL_W + BAR_W;

        // 左侧贯穿金线（封印标尺）+ 两端轴头
        graphics.fill(x, y + 2, x + 1, y + 52, 0x88C9A45C);
        graphics.fill(x - 1, y + 1, x + 2, y + 4, GOLD);
        graphics.fill(x - 1, y + 50, x + 2, y + 53, GOLD);

        // 标题行：八角星符 + 标题
        star8(graphics, x + 5, y);
        graphics.drawString(mc.font, Component.literal(title), x + 13, y + 1, beyonder ? TITLE_COLOR : MORTAL_COLOR);

        // 标题下横幅花纹线：两端金点 + 中央菱形
        graphics.fill(cx, y + 10, cx + hw, y + 11, 0x55C9A45C);
        graphics.fill(cx, y + 9, cx + 1, y + 12, GOLD);
        graphics.fill(cx + hw - 1, y + 9, cx + hw, y + 12, GOLD);
        gem(graphics, cx + hw / 2, y + 10, 0x88E8C96A);

        bar(graphics, mc, cx, y + 14, "灵性",
                spirituality + "/" + (infiniteSpirit ? "∞" : maxSpirituality),
                spirituality, maxSpirituality, infiniteSpirit, 0xFFC9A45C);
        bar(graphics, mc, cx, y + 27, "污染",
                String.valueOf(pollution), pollution, maxPollution, false, 0xFFB03030);
        bar(graphics, mc, cx, y + 40, "扮演",
                acting + "%", acting, 100, false, 0xFF5AC8E8);

        // 底部符文菱形链（中央对称）
        int center = cx + hw / 2;
        for (int i = -2; i <= 2; i++) {
            gem(graphics, center + i * 16, y + 51, 0xAAE8C96A);
        }
    }

    /** 单行进度栏：标签 + 细进度条 + 数值（同行），进度条两端配金点。 */
    private static void bar(GuiGraphics graphics, Minecraft mc, int x, int y, String label,
                            String value, int cur, int max, boolean full, int fillColor) {
        graphics.drawString(mc.font, Component.literal(label), x, y, LABEL_COLOR);
        int bx = x + LABEL_W;
        int by = y + 4;
        graphics.drawString(mc.font, Component.literal(value), bx + BAR_W - mc.font.width(value), y, fillColor);
        graphics.fill(bx, by, bx + BAR_W, by + 2, 0x55000000);
        int fill = full || max <= 0 ? BAR_W : Math.max(0, Math.min(BAR_W, (int) Math.round((double) cur / max * BAR_W)));
        if (fill > 0) graphics.fill(bx, by, bx + fill, by + 2, fillColor);
        graphics.fill(bx, by, bx + 1, by + 2, 0x55FFFFFF);
        graphics.fill(bx + BAR_W - 1, by, bx + BAR_W, by + 2, 0x55FFFFFF);
        // 进度条两端金点
        graphics.fill(bx - 2, by, bx, by + 2, GOLD);
        graphics.fill(bx + BAR_W, by, bx + BAR_W + 2, by + 2, GOLD);
    }

    /** 3×3 小菱形符文。 */
    private static void gem(GuiGraphics g, int cx, int cy, int color) {
        g.fill(cx, cy - 1, cx + 1, cy, color);
        g.fill(cx - 1, cy, cx + 2, cy + 1, color);
        g.fill(cx, cy + 1, cx + 1, cy + 2, color);
    }

    /** 5×5 八角星符。 */
    private static void star8(GuiGraphics g, int x, int y) {
        g.fill(x + 2, y, x + 3, y + 1, GOLD);
        g.fill(x, y + 2, x + 1, y + 3, GOLD);
        g.fill(x + 4, y + 2, x + 5, y + 3, GOLD);
        g.fill(x + 2, y + 4, x + 3, y + 5, GOLD);
        g.fill(x + 2, y + 2, x + 3, y + 3, GOLD);
        g.fill(x, y, x + 1, y + 1, 0xAAE8C96A);
        g.fill(x + 4, y, x + 5, y + 1, 0xAAE8C96A);
        g.fill(x, y + 4, x + 1, y + 5, 0xAAE8C96A);
        g.fill(x + 4, y + 4, x + 5, y + 5, 0xAAE8C96A);
    }
}