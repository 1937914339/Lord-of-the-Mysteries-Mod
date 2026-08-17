package com.wan.gmmod.client;

import com.wan.gmmod.common.capability.ModAttachments;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

/**
 * 灵视状态的客户端只读助手（仅客户端）。
 * <p>
 * 供灵体实体渲染器在 {@code shouldRender} 中读取本地玩家的灵视开关
 * （{@link ModAttachments#SPIRIT_VISION}，已通过附件同步到客户端），
 * 从而决定是否渲染灵体（{@code SpiritBeing}）。
 */
public final class SpiritVisionClient {
    private SpiritVisionClient() {
    }

    /**
     * 本地玩家是否已开启灵视。玩家为空时返回 {@code false}。
     */
    public static boolean isActive() {
        Player player = Minecraft.getInstance().player;
        return player != null && player.getData(ModAttachments.SPIRIT_VISION);
    }
}
