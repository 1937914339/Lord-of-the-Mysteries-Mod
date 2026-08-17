package com.wan.gmmod.content.brewing;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.function.Supplier;

/**
 * 炼药锅配方：以纯水为基底，向锅中投入若干材料后搅拌合成魔药。
 * <p>
 * {@code ingredients} 描述所需的物品及最小数量；{@code result} 惰性提供产物（每次合成返回新实例）。
 *
 * @param ingredients 材料物品 → 所需最小数量
 * @param result      合成产物提供器
 */
public record BrewingRecipe(Map<Item, Integer> ingredients, Supplier<ItemStack> result) {

    /**
     * 判断锅内可用材料是否满足本配方（每种材料数量均达到要求）。
     *
     * @param available 锅内材料物品 → 现有数量
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
