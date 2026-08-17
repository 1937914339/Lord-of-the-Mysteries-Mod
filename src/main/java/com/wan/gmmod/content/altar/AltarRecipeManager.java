package com.wan.gmmod.content.altar;

import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 祭台配方注册表：集中存储所有祭台合成配方。
 * <p>
 * 通过 {@link #register(AltarRecipe)} 追加配方，{@link #init()} 在通用初始化阶段注册内置配方。
 */
public final class AltarRecipeManager {

    private static final List<AltarRecipe> RECIPES = new ArrayList<>();

    private AltarRecipeManager() {}

    /** 追加一条配方。 */
    public static void register(AltarRecipe recipe) {
        RECIPES.add(recipe);
    }

    /**
     * 依据祭台上材料匹配配方，返回首个满足的配方；无匹配返回 {@code null}。
     */
    public static AltarRecipe findMatch(Map<Item, Integer> available) {
        for (AltarRecipe recipe : RECIPES) {
            if (recipe.matches(available)) {
                return recipe;
            }
        }
        return null;
    }

    /** 注册内置祭台配方。幂等：重复调用会先清空既有配方。 */
    public static void init() {
        RECIPES.clear();

        // 小丑 / 魔术师 / 无面人 / 秘偶大师魔药均已迁至炼药系统（BrewingRecipeManager）。
        // 祭台拥有独立的仪式合成系统：需在灵性之墙内、祭台周围摆放蜡烛x3才能合成。
        // 在此处追加仪式专属配方。
    }
}
