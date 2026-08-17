package com.wan.gmmod.content.altar;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.function.Supplier;

/**
 * 祭台配方：材料放置在祭台上，空手右键触发合成。
 *
 * @param ingredients 材料物品 → 所需最小数量
 * @param result      合成产物提供器
 */
public record AltarRecipe(Map<Item, Integer> ingredients, Supplier<ItemStack> result) {

    /**
     * 判断祭台上可用材料是否满足本配方。
     */
    public boolean matches(Map<Item, Integer> available) {
        for (Map.Entry<Item, Integer> entry : ingredients.entrySet()) {
            if (available.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    /** 产出一份新的成品堆叠。 */
    public ItemStack createResult() {
        return result.get();
    }
}
