package com.wan.gmmod.content.brewing;

import com.wan.gmmod.common.registry.ModBlocks;
import com.wan.gmmod.common.registry.ModItems;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 炼药锅配方注册表：集中存储所有魔药配方，供炼药事件在搅拌完成时匹配。
 * <p>
 * 通过 {@link #register(BrewingRecipe)} 追加配方，{@link #init()} 在通用初始化阶段
 * 注册内置配方（此时物品已完成注册）。配方按注册顺序匹配，返回首个满足的配方。
 */
public final class BrewingRecipeManager {

    private static final List<BrewingRecipe> RECIPES = new ArrayList<>();

    private BrewingRecipeManager() {
    }

    /** 追加一条配方。 */
    public static void register(BrewingRecipe recipe) {
        RECIPES.add(recipe);
    }

    /**
     * 依据锅内材料匹配配方，返回首个满足的配方；无匹配返回 {@code null}。
     *
     * @param available 锅内材料物品 → 现有数量
     */
    public static BrewingRecipe findMatch(Map<net.minecraft.world.item.Item, Integer> available) {
        for (BrewingRecipe recipe : RECIPES) {
            if (recipe.matches(available)) {
                return recipe;
            }
        }
        return null;
    }

    /** 注册内置配方。幂等：重复调用会先清空既有配方，避免重复注册。 */
    public static void init() {
        RECIPES.clear();

        // 占卜家魔药：纯水为基底，投入以下材料后木棍搅拌三次合成。
        Map<net.minecraft.world.item.Item, Integer> seerIngredients = new LinkedHashMap<>();
        seerIngredients.put(ModItems.LAVA_OCTOPUS_BLOOD.get(), 1);
        seerIngredients.put(ModItems.STAR_CRYSTAL.get(), 3);
        seerIngredients.put(ModBlocks.NIGHT_FRAGRANCE.get().asItem(), 5);
        seerIngredients.put(ModItems.GOLD_MINT_LEAF.get(), 7);
        seerIngredients.put(ModBlocks.DRAGON_BLOOD_GRASS.get().asItem(), 3);
        seerIngredients.put(ModBlocks.POISON_HEMLOCK.get().asItem(), 2);

        register(new BrewingRecipe(seerIngredients,
                () -> new ItemStack(ModItems.SEER_POTION.get())));

        // 序列8 - 小丑魔药：独角结晶x1 + 人脸玫瑰x1 + 曼陀罗x5 + 黑边太阳花x5 + 金斗蓬草x1 + 毒堇x3
        Map<net.minecraft.world.item.Item, Integer> clownIngredients = new LinkedHashMap<>();
        clownIngredients.put(ModItems.HORNACIS_GOAT_HORN_CRYSTAL.get(), 1);
        clownIngredients.put(ModItems.FACE_ROSE.get(), 1);
        clownIngredients.put(ModItems.MANDRAGORA.get(), 5);
        clownIngredients.put(ModItems.BLACK_EDGED_SUNFLOWER.get(), 5);
        clownIngredients.put(ModItems.GOLDEN_CLOAK_GRASS.get(), 1);
        clownIngredients.put(ModBlocks.POISON_HEMLOCK.get().asItem(), 3);

        register(new BrewingRecipe(clownIngredients,
                () -> new ItemStack(ModItems.CLOWN_POTION.get())));

        // 序列7 - 魔术师魔药：迷雾树人根茎x1 + 邪纹黑豹脊髓液x1 + 迷雾树人汁液x1 + 水形宝石x3 + 迷幻草x4
        Map<net.minecraft.world.item.Item, Integer> magicianIngredients = new LinkedHashMap<>();
        magicianIngredients.put(ModItems.MIST_TREANT_ROOT.get(), 1);
        magicianIngredients.put(ModItems.EVIL_PANTHER_SPINAL_FLUID.get(), 1);
        magicianIngredients.put(ModItems.MIST_TREANT_JUICE.get(), 1);
        magicianIngredients.put(ModItems.WATER_SHAPE_GEM.get(), 3);
        magicianIngredients.put(ModItems.PSYCHEDELIC_GRASS.get(), 4);

        register(new BrewingRecipe(magicianIngredients,
                () -> new ItemStack(ModItems.MAGICIAN_POTION.get())));

        // 序列6 - 无面人魔药（自祭台仪式迁入炼药系统）：
        // 千面狩猎者血液x1 + 脑垂体x1 + 人皮幽影特性x1 + 黑色曼陀罗x3 + 龙牙草x2
        Map<net.minecraft.world.item.Item, Integer> facelessIngredients = new LinkedHashMap<>();
        facelessIngredients.put(ModItems.THOUSAND_FACED_HUNTER_BLOOD.get(), 1);
        facelessIngredients.put(ModItems.THOUSAND_FACED_HUNTER_PITUITARY.get(), 1);
        facelessIngredients.put(ModItems.HUMAN_SKIN_SHADOW_CHARACTERISTIC.get(), 1);
        facelessIngredients.put(ModItems.BLACK_MANDRAGORA.get(), 3);
        facelessIngredients.put(ModItems.AGRIMONY.get(), 2);

        register(new BrewingRecipe(facelessIngredients,
                () -> new ItemStack(ModItems.FACELESS_POTION.get())));

        // 序列5 - 秘偶大师魔药：古老怨灵的粉尘x1 + 六翼石像鬼的核心结晶x1 +
        // 苏尼亚岛金色泉的泉水x1 + 龙纹树的树皮x1 + 古老怨灵的残余灵性x1 + 六翼石像鬼的眼睛x1
        Map<net.minecraft.world.item.Item, Integer> marionettistIngredients = new LinkedHashMap<>();
        marionettistIngredients.put(ModItems.ANCIENT_WRAITH_DUST.get(), 1);
        marionettistIngredients.put(ModItems.SIX_WINGED_GARGOYLE_CORE_CRYSTAL.get(), 1);
        marionettistIngredients.put(ModItems.SONIA_GOLDEN_SPRING_WATER.get(), 1);
        marionettistIngredients.put(ModItems.DRAGON_PATTERN_TREE_BARK.get(), 1);
        marionettistIngredients.put(ModItems.ANCIENT_WRAITH_RESIDUAL_SPIRITUALITY.get(), 1);
        marionettistIngredients.put(ModItems.SIX_WINGED_GARGOYLE_EYE.get(), 1);

        register(new BrewingRecipe(marionettistIngredients,
                () -> new ItemStack(ModItems.MARIONETTIST_POTION.get())));

        // ===== 战争之红途径 =====

        // 序列9 - 猎人魔药：蜘蛛眼x2 + 骨头x3 + 甜浆果x5 + 毒堇x2
        Map<net.minecraft.world.item.Item, Integer> hunterIngredients = new LinkedHashMap<>();
        hunterIngredients.put(net.minecraft.world.item.Items.SPIDER_EYE, 2);
        hunterIngredients.put(net.minecraft.world.item.Items.BONE, 3);
        hunterIngredients.put(net.minecraft.world.item.Items.SWEET_BERRIES, 5);
        hunterIngredients.put(ModBlocks.POISON_HEMLOCK.get().asItem(), 2);

        register(new BrewingRecipe(hunterIngredients,
                () -> new ItemStack(ModItems.HUNTER_POTION.get())));

        // 序列8 - 挑衅者魔药：火药x3 + 腐肉x5 + 龙血草x2
        Map<net.minecraft.world.item.Item, Integer> provokerIngredients = new LinkedHashMap<>();
        provokerIngredients.put(net.minecraft.world.item.Items.GUNPOWDER, 3);
        provokerIngredients.put(net.minecraft.world.item.Items.ROTTEN_FLESH, 5);
        provokerIngredients.put(ModBlocks.DRAGON_BLOOD_GRASS.get().asItem(), 2);

        register(new BrewingRecipe(provokerIngredients,
                () -> new ItemStack(ModItems.PROVOKER_POTION.get())));

        // 序列7 - 纵火家魔药：烈焰粉x4 + 岩浆膏x2 + 拉瓦章鱼血液x1 + 金薄荷叶子x3
        Map<net.minecraft.world.item.Item, Integer> pyromaniacIngredients = new LinkedHashMap<>();
        pyromaniacIngredients.put(net.minecraft.world.item.Items.BLAZE_POWDER, 4);
        pyromaniacIngredients.put(net.minecraft.world.item.Items.MAGMA_CREAM, 2);
        pyromaniacIngredients.put(ModItems.LAVA_OCTOPUS_BLOOD.get(), 1);
        pyromaniacIngredients.put(ModItems.GOLD_MINT_LEAF.get(), 3);

        register(new BrewingRecipe(pyromaniacIngredients,
                () -> new ItemStack(ModItems.PYROMANIAC_POTION.get())));

        // 序列6 - 阴谋家魔药：恶魂之泪 x1 + 烈焰棒x2 + 夜香草x3 + 绿宝石x2
        Map<net.minecraft.world.item.Item, Integer> conspirerIngredients = new LinkedHashMap<>();
        conspirerIngredients.put(net.minecraft.world.item.Items.GHAST_TEAR, 1);
        conspirerIngredients.put(net.minecraft.world.item.Items.BLAZE_ROD, 2);
        conspirerIngredients.put(ModBlocks.NIGHT_FRAGRANCE.get().asItem(), 3);
        conspirerIngredients.put(net.minecraft.world.item.Items.EMERALD, 2);

        register(new BrewingRecipe(conspirerIngredients,
                () -> new ItemStack(ModItems.CONSPIRER_POTION.get())));
    }
}
