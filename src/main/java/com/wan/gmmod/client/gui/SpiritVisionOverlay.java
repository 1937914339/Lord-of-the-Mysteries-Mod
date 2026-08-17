package com.wan.gmmod.client.gui;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.client.SpiritVisionClient;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

/**
 * 灵视滤镜（增强 V 键灵视的视觉表现，仅客户端）。
 * <p>
 * 开启灵视时：
 * <ul>
 *   <li>整屏覆上一层暗蓝紫的薄雾，主世界随之变暗——「灵界」与现世的剥离感；</li>
 *   <li>边缘加深的渐隐式暗角，聚焦视野中心；</li>
 *   <li>中央弥漫一抹幽蓝光晕，提示灵体玄光。</li>
 * </ul>
 * 与灵体实体上的 {@code SpiritGlowLayer}（灵体发光 / 灵性浓度区域彩色光晕）
 * 配合，形成完整的灵视滤镜。
 */
@EventBusSubscriber(modid = GuimiMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class SpiritVisionOverlay {
    /** 边缘暗角厚度（像素） */
    private static final int VIGNETTE = 40;
    /** 整体薄雾底色（暗蓝紫，半透明） */
    private static final int MIST = 0x3C140B2A;
    /** 暗角渐隐端颜色 */
    private static final int DARK_EDGE = 0xA60B1226;
    /** 中央幽蓝光晕（近屏幕中心的淡淡亮蓝） */
    private static final int CENTER_GLOW = 0x1E4A7FCC;

    @SubscribeEvent
    public static void registerLayer(RegisterGuiLayersEvent event) {
        event.registerAboveAll(GuimiMod.id("spirit_vision_filter"), SpiritVisionOverlay::render);
    }

    private static void render(GuiGraphics graphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        if (!SpiritVisionClient.isActive() || mc.options.hideGui) {
            return;
        }
        int w = graphics.guiWidth();
        int h = graphics.guiHeight();

        // 全屏薄雾：主世界变暗
        graphics.fill(0, 0, w, h, MIST);
        // 中央幽蓝光晕（垂向渐变，中心亮边缘暗）
        int glow = CENTER_GLOW;
        graphics.fillGradient(w / 4, h / 4, w * 3 / 4, h * 3 / 4, glow, MIST);
        // 四角暗角
        graphics.fillGradient(0, 0, w, VIGNETTE, DARK_EDGE, 0x00000000);
        graphics.fillGradient(0, h - VIGNETTE, w, h, 0x00000000, DARK_EDGE);
        graphics.fillGradient(0, 0, VIGNETTE, h, DARK_EDGE, 0x00000000);
        graphics.fillGradient(w - VIGNETTE, 0, w, h, 0x00000000, DARK_EDGE);
    }
}