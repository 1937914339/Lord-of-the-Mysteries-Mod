package com.wan.gmmod.common.registry;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.item.BasicPoisonItem;
import com.wan.gmmod.common.item.BlankTalismanItem;
import com.wan.gmmod.common.item.BlackShoesItem;
import com.wan.gmmod.common.item.BlackVestItem;
import com.wan.gmmod.common.item.CharacteristicItem;
import com.wan.gmmod.common.item.ChargedFireballItem;
import com.wan.gmmod.common.item.DawnArmorItem;
import com.wan.gmmod.common.item.DawnSwordItem;
import com.wan.gmmod.common.item.MagmaSwordItem;
import com.wan.gmmod.common.item.DemonFormItem;
import com.wan.gmmod.common.item.FlameWeaponItem;
import com.wan.gmmod.common.item.GuimiArmorItem;
import com.wan.gmmod.common.item.HemostaticSalveItem;
import com.wan.gmmod.common.item.SealedArtifactItem;
import com.wan.gmmod.common.item.SeerPotionItem;
import com.wan.gmmod.common.item.LongPantsItem;
import com.wan.gmmod.common.item.MagicArtifactItem;
import com.wan.gmmod.common.item.MirrorItem;
import com.wan.gmmod.common.item.PendulumItem;
import com.wan.gmmod.common.item.SpiritRodItem;
import com.wan.gmmod.common.item.VestItem;
import com.wan.gmmod.common.item.WandItem;
import com.wan.gmmod.common.item.WolfmanFormItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // 创建一个 DeferredRegister 用于物品
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(GuimiMod.MODID);


    public static final DeferredItem<SeerPotionItem> SEER_POTION =
           ITEMS.register("seer_potion",
                    () -> new SeerPotionItem(new Item.Properties(),
                            GuimiMod.id("fool_9")));

    public static final DeferredItem<GuimiArmorItem> TOP_HAT =
            ITEMS.register("top_hat",
                    () -> new GuimiArmorItem(ModArmorMaterials.TOP_HAT, ArmorItem.Type.HELMET,
                            new Item.Properties().stacksTo(1)));

    public static final DeferredItem<WandItem> WAND =
            ITEMS.register("wand",
                    () -> new WandItem(new Item.Properties().stacksTo(1)));

    /**
     * 黄水晶灵摆，右键使用时通过网络包驱动客户端动画与玩家手臂旋转，
     * 使用 GeckoLib 渲染 3D 模型
     */
    public static final DeferredItem<PendulumItem> PENDULUM =
            ITEMS.register("pendulum",
                    () -> new PendulumItem(new Item.Properties().stacksTo(1)));

    /**
     * 马甲盔甲，装填于胸甲槽，使用 GeckoLib 渲染 3D 模型
     */
    public static final DeferredItem<VestItem> VEST =
            ITEMS.register("vest",
                    () -> new VestItem(ModArmorMaterials.VEST, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().stacksTo(1)));

    /**
     * 黑色长裤盔甲，装填于护腿槽，使用 GeckoLib 渲染 3D 模型
     */
    public static final DeferredItem<LongPantsItem> LONG_PANTS =
            ITEMS.register("long_pants",
                    () -> new LongPantsItem(ModArmorMaterials.LONG_PANTS, ArmorItem.Type.LEGGINGS,
                            new Item.Properties().stacksTo(1)));

    /**
     * 黑皮鞋盔甲，装填于靴子槽，使用 GeckoLib 渲染 3D 模型
     */
    public static final DeferredItem<BlackShoesItem> BLACK_SHOES =
            ITEMS.register("black_shoes",
                    () -> new BlackShoesItem(ModArmorMaterials.BLACK_SHOES, ArmorItem.Type.BOOTS,
                            new Item.Properties().stacksTo(1)));

    /**
     * 黑色马甲（白衬）盔甲，装填于胸甲槽，使用 GeckoLib 渲染 3D 模型
     */
    public static final DeferredItem<BlackVestItem> BLACK_VEST =
            ITEMS.register("black_vest",
                    () -> new BlackVestItem(ModArmorMaterials.BLACK_VEST, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().stacksTo(1)));

    /**
     * 怨灵刷怪蛋
     */
    public static final DeferredItem<DeferredSpawnEggItem> WRAITH_SPAWN_EGG =
            ITEMS.register("wraith_spawn_egg",
                    () -> new DeferredSpawnEggItem(ModEntities.WRAITH,
                            0x3a2a4d, 0x8a6fb0, new Item.Properties()));

    /**
     * 美人鱼刷怪蛋
     */
    public static final DeferredItem<DeferredSpawnEggItem> MERMAID_SPAWN_EGG =
            ITEMS.register("mermaid_spawn_egg",
                    () -> new DeferredSpawnEggItem(ModEntities.MERMAID,
                            0x1f6f8b, 0xf2c14e, new Item.Properties()));

    /**
     * 修女刷怪蛋
     */
    public static final DeferredItem<DeferredSpawnEggItem> NUN_SPAWN_EGG =
            ITEMS.register("nun_spawn_egg",
                    () -> new DeferredSpawnEggItem(ModEntities.NUN,
                            0x2b2f3d, 0x9aa4b8, new Item.Properties()));

    /**
     * 神父刷怪蛋
     */
    public static final DeferredItem<DeferredSpawnEggItem> PRIEST_SPAWN_EGG =
            ITEMS.register("priest_spawn_egg",
                    () -> new DeferredSpawnEggItem(ModEntities.PRIEST,
                            0xe6e8eb, 0x5a6472, new Item.Properties()));

    /** 狼人刷怪蛋 */
    public static final DeferredItem<DeferredSpawnEggItem> WOLFMAN_SPAWN_EGG =
            ITEMS.register("wolfman_spawn_egg",
                    () -> new DeferredSpawnEggItem(ModEntities.WOLFMAN,
                            0x3d3024, 0x8a7355, new Item.Properties()));

    /**
     * 非凡特性物品：所有途径 / 等级共用，靠数据组件区分。参见 {@link CharacteristicItem}。
     */
    public static final DeferredItem<CharacteristicItem> CHARACTERISTIC =
            ITEMS.register("characteristic",
                    () -> new CharacteristicItem(new Item.Properties()));

    /**
     * 封印物物品：锻造台将「特性 + 耐久装备」锻造成封印物，或非凡生物死亡时
     * 与附近物品融合而成。携带途径对应的正面效果与「封印侵蚀」代价。
     * 所有途径 / 等级 / 基底共用，靠数据组件区分。参见 {@link SealedArtifactItem}。
     */
    public static final DeferredItem<SealedArtifactItem> SEALED_ARTIFACT =
            ITEMS.register("sealed_artifact",
                    () -> new SealedArtifactItem(new Item.Properties()));

    /**
     * 神奇物品：将非凡特性「植入」基础物品后形成的超凡物品，携带途径对应的正面
     * 能力与负面代价，且效果具有随机性（生成时掷定变体）。右键触发各自能力。
     * 所有途径 / 等级 / 基底共用，靠数据组件区分。参见 {@link MagicArtifactItem}。
     */
    public static final DeferredItem<MagicArtifactItem> MAGIC_ARTIFACT =
            ITEMS.register("magic_artifact",
                    () -> new MagicArtifactItem(new Item.Properties()));

    // ===== 炼药材料 =====

    /** 星水晶：占卜家魔药配方材料。 */
    public static final DeferredItem<Item> STAR_CRYSTAL =
            ITEMS.register("star_crystal", () -> new Item(new Item.Properties()));

    /** 拉瓦章鱼血液：由原版章鱼掉落，占卜家魔药主料。 */
    public static final DeferredItem<Item> LAVA_OCTOPUS_BLOOD =
            ITEMS.register("lava_octopus_blood", () -> new Item(new Item.Properties()));

    /** 净水（纯水）：水瓶在熔炉烧炼而成，是炼药锅的基底介质。 */
    public static final DeferredItem<Item> PURIFIED_WATER =
            ITEMS.register("purified_water", () -> new Item(new Item.Properties()));

    /** 金薄荷叶子：由金薄荷植物破坏掉落。 */
    public static final DeferredItem<Item> GOLD_MINT_LEAF =
            ITEMS.register("gold_mint_leaf", () -> new Item(new Item.Properties()));

    // ===== 仪式 / 武器 =====

    /** 仪式匕首：激活灵性之墙的必要工具。 */
    public static final DeferredItem<Item> RITUAL_DAGGER =
            ITEMS.register("ritual_dagger",
                    () -> new com.wan.gmmod.common.item.RitualDaggerItem(new Item.Properties().stacksTo(1)));

    /** 丧钟（原名寂灭）：带换弹动画的火器武器，弹药为各类子弹。 */
    public static final DeferredItem<Item> SILENCE_GUN =
            ITEMS.register("silence_gun",
                    () -> new com.wan.gmmod.common.item.SilenceGunItem(new Item.Properties().stacksTo(1).durability(512)));

    /** 纸人：右键地面放置纸人实体，作为「纸人替身」能力的交换锚点。 */
    public static final DeferredItem<Item> PAPER_FIGURINE =
            ITEMS.register("paper_figurine",
                    () -> new com.wan.gmmod.common.item.PaperFigurineItem(new Item.Properties()));

    /** 纸牌：小丑「飞牌」能力的专属弹药，与原版纸通用（优先消耗纸牌）。 */
    public static final DeferredItem<Item> PAPER_CARD =
            ITEMS.register("paper_card", () -> new Item(new Item.Properties()));

    // ===== 子弹类 =====

    /** 普通子弹（基础弹药）。 */
    public static final DeferredItem<Item> BULLET =
            ITEMS.register("bullet", () -> new Item(new Item.Properties()));

    /** 剥夺子弹：命中后剥夺目标一项增益效果。 */
    public static final DeferredItem<Item> DEPRIVATION_BULLET =
            ITEMS.register("deprivation_bullet", () -> new Item(new Item.Properties()));

    /** 寄生子弹：命中后对目标施加寄生效果。 */
    public static final DeferredItem<Item> PARASITIC_BULLET =
            ITEMS.register("parasitic_bullet", () -> new Item(new Item.Properties()));

    /** 控灵子弹：命中灵体时造成额外伤害。 */
    public static final DeferredItem<Item> SPIRIT_CONTROL_BULLET =
            ITEMS.register("spirit_control_bullet", () -> new Item(new Item.Properties()));

    /** 欺瞒子弹：命中后使目标短暂迷惑。 */
    public static final DeferredItem<Item> DECEPTION_BULLET =
            ITEMS.register("deception_bullet", () -> new Item(new Item.Properties()));

    /** 驱邪子弹：对不死生物和灵体造成额外伤害。 */
    public static final DeferredItem<Item> EXORCISM_BULLET =
            ITEMS.register("exorcism_bullet", () -> new Item(new Item.Properties()));

    /** 净化子弹：命中后清除目标负面灵性状态。 */
    public static final DeferredItem<Item> PURIFICATION_BULLET =
            ITEMS.register("purification_bullet", () -> new Item(new Item.Properties()));

    // ===== 魔药 =====

    /** 序列8 - 小丑魔药。 */
    public static final DeferredItem<SeerPotionItem> CLOWN_POTION =
            ITEMS.register("clown_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("fool_8")));

    /** 序列7 - 魔术师魔药。 */
    public static final DeferredItem<SeerPotionItem> MAGICIAN_POTION =
            ITEMS.register("magician_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("fool_7")));

    /** 序列6 - 无面人魔药（炼药系统合成，饮用后正常晋升）。 */
    public static final DeferredItem<SeerPotionItem> FACELESS_POTION =
            ITEMS.register("faceless_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("fool_6")));

    /**
     * 序列5 - 秘偶大师魔药：高序列魔药，服用需满足「美人鱼的歌声」晋升仪式条件，
     * 否则失控。见 {@link com.wan.gmmod.content.ritual.PromotionRitualManager}。
     */
    public static final DeferredItem<Item> MARIONETTIST_POTION =
            ITEMS.register("marionettist_potion",
                    () -> new com.wan.gmmod.common.item.RitualAdvanceItem(new Item.Properties(),
                            GuimiMod.id("fool_5")));

    /** 秘偶大师非凡特性：可作为魔药的替代品右键触发同样的晋升仪式。 */
    public static final DeferredItem<Item> MARIONETTIST_CHARACTERISTIC =
            ITEMS.register("marionettist_characteristic",
                    () -> new com.wan.gmmod.common.item.RitualAdvanceItem(
                            new Item.Properties().fireResistant(), GuimiMod.id("fool_5")));

    /** 无面人非凡特性。 */
    public static final DeferredItem<Item> FACELESS_CHARACTERISTIC =
            ITEMS.register("faceless_characteristic",
                    () -> new Item(new Item.Properties().fireResistant()));

    // ===== 炼药 / 仪式材料 =====

    /** 龙牙草。 */
    public static final DeferredItem<Item> AGRIMONY =
            ITEMS.register("agrimony", () -> new Item(new Item.Properties()));

    /** 黑边太阳花。 */
    public static final DeferredItem<Item> BLACK_EDGED_SUNFLOWER =
            ITEMS.register("black_edged_sunflower", () -> new Item(new Item.Properties()));

    /** 黑色曼陀罗。 */
    public static final DeferredItem<Item> BLACK_MANDRAGORA =
            ITEMS.register("black_mandragora", () -> new Item(new Item.Properties()));

    /** 金斗蓬草。 */
    public static final DeferredItem<Item> GOLDEN_CLOAK_GRASS =
            ITEMS.register("golden_cloak_grass", () -> new Item(new Item.Properties()));

    /** 曼陀罗。 */
    public static final DeferredItem<Item> MANDRAGORA =
            ITEMS.register("mandragora", () -> new Item(new Item.Properties()));

    /** 迷幻草。 */
    public static final DeferredItem<Item> PSYCHEDELIC_GRASS =
            ITEMS.register("psychedelic_grass", () -> new Item(new Item.Properties()));

    /** 迷雾树人的真实根茎。 */
    public static final DeferredItem<Item> MIST_TREANT_ROOT =
            ITEMS.register("mist_treant_root", () -> new Item(new Item.Properties()));

    /** 迷雾树人的汁液。 */
    public static final DeferredItem<Item> MIST_TREANT_JUICE =
            ITEMS.register("mist_treant_juice", () -> new Item(new Item.Properties()));

    /** 千面狩猎者的血液。 */
    public static final DeferredItem<Item> THOUSAND_FACED_HUNTER_BLOOD =
            ITEMS.register("thousand_faced_hunter_blood", () -> new Item(new Item.Properties()));

    /** 千面狩猎者异变的脑垂体。 */
    public static final DeferredItem<Item> THOUSAND_FACED_HUNTER_PITUITARY =
            ITEMS.register("thousand_faced_hunter_pituitary", () -> new Item(new Item.Properties()));

    /** 人脸玫瑰。 */
    public static final DeferredItem<Item> FACE_ROSE =
            ITEMS.register("face_rose", () -> new Item(new Item.Properties()));

    /** 人皮幽影特性。 */
    public static final DeferredItem<Item> HUMAN_SKIN_SHADOW_CHARACTERISTIC =
            ITEMS.register("human_skin_shadow_characteristic", () -> new Item(new Item.Properties()));

    /** 成年的霍纳奇斯灰山羊独角结晶。 */
    public static final DeferredItem<Item> HORNACIS_GOAT_HORN_CRYSTAL =
            ITEMS.register("hornacis_goat_horn_crystal", () -> new Item(new Item.Properties()));

    /** 深海娜迦头发。 */
    public static final DeferredItem<Item> DEEP_SEA_NAGA_HAIR =
            ITEMS.register("deep_sea_naga_hair", () -> new Item(new Item.Properties()));

    /** 水形宝石。 */
    public static final DeferredItem<Item> WATER_SHAPE_GEM =
            ITEMS.register("water_shape_gem", () -> new Item(new Item.Properties()));

    /** 邪纹黑豹的脊髓液。 */
    public static final DeferredItem<Item> EVIL_PANTHER_SPINAL_FLUID =
            ITEMS.register("evil_panther_spinal_fluid", () -> new Item(new Item.Properties()));

    // ===== 序列5「秘偶大师」炼药材料 =====

    /** 古老怨灵的粉尘。 */
    public static final DeferredItem<Item> ANCIENT_WRAITH_DUST =
            ITEMS.register("ancient_wraith_dust", () -> new Item(new Item.Properties()));

    /** 六翼石像鬼的核心结晶。 */
    public static final DeferredItem<Item> SIX_WINGED_GARGOYLE_CORE_CRYSTAL =
            ITEMS.register("six_winged_gargoyle_core_crystal", () -> new Item(new Item.Properties()));

    /** 苏尼亚岛金色泉的泉水。 */
    public static final DeferredItem<Item> SONIA_GOLDEN_SPRING_WATER =
            ITEMS.register("sonia_golden_spring_water", () -> new Item(new Item.Properties()));

    /** 龙纹树的树皮。 */
    public static final DeferredItem<Item> DRAGON_PATTERN_TREE_BARK =
            ITEMS.register("dragon_pattern_tree_bark", () -> new Item(new Item.Properties()));

    /** 古老怨灵的残余灵性。 */
    public static final DeferredItem<Item> ANCIENT_WRAITH_RESIDUAL_SPIRITUALITY =
            ITEMS.register("ancient_wraith_residual_spirituality", () -> new Item(new Item.Properties()));

    /** 六翼石像鬼的眼睛。 */
    public static final DeferredItem<Item> SIX_WINGED_GARGOYLE_EYE =
            ITEMS.register("six_winged_gargoyle_eye", () -> new Item(new Item.Properties()));

    // ===== 植物方块物品（BlockItem）=====

    public static final DeferredItem<BlockItem> GOLD_MINT =
            ITEMS.register("gold_mint",
                    () -> new BlockItem(ModBlocks.GOLD_MINT.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> NIGHT_FRAGRANCE =
            ITEMS.register("night_fragrance",
                    () -> new BlockItem(ModBlocks.NIGHT_FRAGRANCE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> DRAGON_BLOOD_GRASS =
            ITEMS.register("dragon_blood_grass",
                    () -> new BlockItem(ModBlocks.DRAGON_BLOOD_GRASS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POISON_HEMLOCK =
            ITEMS.register("poison_hemlock",
                    () -> new BlockItem(ModBlocks.POISON_HEMLOCK.get(), new Item.Properties()));

    // ===== 祭台方块物品 =====

    public static final DeferredItem<BlockItem> ALTAR =
            ITEMS.register("altar",
                    () -> new BlockItem(ModBlocks.ALTAR.get(), new Item.Properties()));

    // ===== 魔女途径（刺客 / 教唆者 / 女巫 / 欢愉魔女）=====

    /** 镜子：女巫「魔镜占卜」入口 + 潜行右键绑定「镜子替身」锚点。 */
    public static final DeferredItem<MirrorItem> MIRROR =
            ITEMS.register("mirror",
                    () -> new MirrorItem(new Item.Properties().stacksTo(1)));

    /** 破碎的镜子：镜子碎裂后的残片，作为收集品/魔女途径素材。 */
    public static final DeferredItem<Item> MIRROR_BROKEN =
            ITEMS.register("mirror_broken",
                    () -> new Item(new Item.Properties().stacksTo(16)));

    /** 灵性钓竿：灵界钓鱼专用，夜晚垂钓有概率从守恒池抽出低序列非凡特性。 */
    public static final DeferredItem<SpiritRodItem> SPIRIT_ROD =
            ITEMS.register("spirit_rod",
                    () -> new SpiritRodItem(new Item.Properties().durability(384)));

    /** 序列9 - 刺客魔药。 */
    public static final DeferredItem<SeerPotionItem> ASSASSIN_POTION =
            ITEMS.register("assassin_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("witch_9")));

    /** 序列8 - 教唆者魔药。 */
    public static final DeferredItem<SeerPotionItem> INSTIGATOR_POTION =
            ITEMS.register("instigator_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("witch_8")));

    /** 序列7 - 女巫魔药。 */
    public static final DeferredItem<SeerPotionItem> WITCH_POTION =
            ITEMS.register("witch_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("witch_7")));

    /** 序列6 - 欢愉魔女魔药。 */
    public static final DeferredItem<SeerPotionItem> JOYFUL_WITCH_POTION =
            ITEMS.register("joyful_witch_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("witch_6")));

    // ===== 战争之红途径（猎人 / 挑衅者 / 纵火家 / 阴谋家）=====

    /** 止血药膏：猎人「野外知识」产物，右键瞬间恢复 2 颗心。 */
    public static final DeferredItem<HemostaticSalveItem> HEMOSTATIC_SALVE =
            ITEMS.register("hemostatic_salve",
                    () -> new HemostaticSalveItem(new Item.Properties()));

    /** 基础毒药：猎人「野外知识」产物，涂抹武器使近战附带中毒 5 秒。 */
    public static final DeferredItem<BasicPoisonItem> BASIC_POISON =
            ITEMS.register("basic_poison",
                    () -> new BasicPoisonItem(new Item.Properties()));

    /** 火焰武器：纵火家「火焰武器」凝聚的临时武器（剑 / 鞭 / 马刀）。 */
    public static final DeferredItem<FlameWeaponItem> FLAME_WEAPON =
            ITEMS.register("flame_weapon",
                    () -> new FlameWeaponItem(new Item.Properties().stacksTo(1)));

    // ===== 火焰弹体外观物品（仅供投射物渲染使用自定义纹理，不进创造页）=====

    /** 凝聚火球：「火球术」蓄力时握于手中右键释放，兼作弹体纹理载体。 */
    public static final DeferredItem<Item> FLAME_ORB_ITEM =
            ITEMS.register("flame_orb",
                    () -> new ChargedFireballItem(new Item.Properties().stacksTo(1), false));

    /** 巨大凝聚火球：「巨大火球」蓄力时握于手中右键释放，兼作弹体纹理载体。 */
    public static final DeferredItem<Item> GIANT_FLAME_ORB_ITEM =
            ITEMS.register("giant_flame_orb",
                    () -> new ChargedFireballItem(new Item.Properties().stacksTo(1), true));

    /** 火鸦外观：「火鸦术」弹体纹理载体。 */
    public static final DeferredItem<Item> FIRE_RAVEN_ITEM =
            ITEMS.register("fire_raven", () -> new Item(new Item.Properties()));

    /** 炽白之枪外观：「炽白之枪」弹体纹理载体。 */
    public static final DeferredItem<Item> FLAME_SPEAR_ITEM =
            ITEMS.register("flame_spear", () -> new Item(new Item.Properties()));

    // ===== 魔女途径弹体外观物品（仅投射物渲染用，不进创造页）=====

    /** 黑焰外观：「操控黑焰」弹体的可见载体（黑色火焰贴图）。 */
    public static final DeferredItem<Item> BLACK_FLAME_ITEM =
            ITEMS.register("black_flame", () -> new Item(new Item.Properties()));

    /** 冰晶长枪外观：投掷时可看到冰晶长枪纹理发射出去。 */
    public static final DeferredItem<Item> ICE_SPEAR_ITEM =
            ITEMS.register("ice_spear", () -> new Item(new Item.Properties()));

    /** 序列9 - 猎人魔药。 */
    public static final DeferredItem<SeerPotionItem> HUNTER_POTION =
            ITEMS.register("hunter_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("war_9")));

    /** 序列8 - 挑衅者魔药。 */
    public static final DeferredItem<SeerPotionItem> PROVOKER_POTION =
            ITEMS.register("provoker_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("war_8")));

    /** 序列7 - 纵火家魔药。 */
    public static final DeferredItem<SeerPotionItem> PYROMANIAC_POTION =
            ITEMS.register("pyromaniac_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("war_7")));

    /** 序列6 - 阴谋家魔药。 */
    public static final DeferredItem<SeerPotionItem> CONSPIRER_POTION =
            ITEMS.register("conspirer_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("war_6")));

    // ===== 倒吊人途径（秘祈人 / 倾听者 / 隐修士 / 蔷薇主教）=====

    /** 序列9 - 秘祈人魔药。 */
    public static final DeferredItem<SeerPotionItem> MYSTIC_PRAYER_POTION =
            ITEMS.register("mystic_prayer_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hanged_man_9")));

    /** 序列8 - 倾听者魔药。 */
    public static final DeferredItem<SeerPotionItem> LISTENER_POTION =
            ITEMS.register("listener_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hanged_man_8")));

    /** 序列7 - 隐修士魔药。 */
    public static final DeferredItem<SeerPotionItem> HERMIT_POTION =
            ITEMS.register("hermit_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hanged_man_7")));

    /** 序列6 - 蔷薇主教魔药。 */
    public static final DeferredItem<SeerPotionItem> ROSE_BISHOP_POTION =
            ITEMS.register("rose_bishop_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hanged_man_6")));

    // ===== 空想家途径（观众 / 读心者 / 心理医生 / 催眠师）=====

    /** 序列9 - 观众魔药。 */
    public static final DeferredItem<SeerPotionItem> SPECTATOR_POTION =
            ITEMS.register("spectator_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("visionary_9")));

    /** 序列8 - 读心者魔药。 */
    public static final DeferredItem<SeerPotionItem> MIND_READER_POTION =
            ITEMS.register("mind_reader_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("visionary_8")));

    /** 序列7 - 心理医生魔药。 */
    public static final DeferredItem<SeerPotionItem> PSYCHOLOGIST_POTION =
            ITEMS.register("psychologist_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("visionary_7")));

    /** 序列6 - 催眠师魔药。 */
    public static final DeferredItem<SeerPotionItem> HYPNOTIST_POTION =
            ITEMS.register("hypnotist_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("visionary_6")));

    // ===== 暴君途径（水手 / 暴怒之民 / 航海家 / 风眷者）=====

    /** 序列9 - 水手魔药。 */
    public static final DeferredItem<SeerPotionItem> SAILOR_POTION =
            ITEMS.register("sailor_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("tyrant_9")));

    /** 序列8 - 暴怒之民魔药。 */
    public static final DeferredItem<SeerPotionItem> WRATHFUL_POTION =
            ITEMS.register("wrathful_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("tyrant_8")));

    /** 序列7 - 航海家魔药。 */
    public static final DeferredItem<SeerPotionItem> NAVIGATOR_POTION =
            ITEMS.register("navigator_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("tyrant_7")));

    /** 序列6 - 风眷者魔药。 */
    public static final DeferredItem<SeerPotionItem> WIND_FAVORED_POTION =
            ITEMS.register("wind_favored_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("tyrant_6")));

    // ===== 太阳途径（歌颂者 / 祈光人 / 太阳神官 / 公证人）=====

    /** 序列9 - 歌颂者魔药。 */
    public static final DeferredItem<SeerPotionItem> PRAISER_POTION =
            ITEMS.register("praiser_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("sun_9")));

    /** 序列8 - 祈光人魔药。 */
    public static final DeferredItem<SeerPotionItem> LIGHT_SEEKER_POTION =
            ITEMS.register("light_seeker_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("sun_8")));

    /** 序列7 - 太阳神官魔药。 */
    public static final DeferredItem<SeerPotionItem> SUN_PRIEST_POTION =
            ITEMS.register("sun_priest_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("sun_7")));

    /** 序列6 - 公证人魔药。 */
    public static final DeferredItem<SeerPotionItem> NOTARY_POTION =
            ITEMS.register("notary_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("sun_6")));

    // ===== 白塔途径（阅读者 / 推理学员 / 守知者 / 博学者）=====

    /** 序列9 - 阅读者魔药。 */
    public static final DeferredItem<SeerPotionItem> READER_POTION =
            ITEMS.register("reader_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("white_tower_9")));

    /** 序列8 - 推理学员魔药。 */
    public static final DeferredItem<SeerPotionItem> REASONING_STUDENT_POTION =
            ITEMS.register("reasoning_student_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("white_tower_8")));

    /** 序列7 - 守知者魔药。 */
    public static final DeferredItem<SeerPotionItem> KNOWLEDGE_GUARDIAN_POTION =
            ITEMS.register("knowledge_guardian_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("white_tower_7")));

    /** 序列6 - 博学者魔药。 */
    public static final DeferredItem<SeerPotionItem> ERUDITE_POTION =
            ITEMS.register("erudite_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("white_tower_6")));

    // ===== 黄昏巨人途径（战士 / 格斗家 / 武器大师 / 黎明骑士）=====

    /** 序列9 - 战士魔药。 */
    public static final DeferredItem<SeerPotionItem> WARRIOR_POTION =
            ITEMS.register("warrior_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("giant_9")));

    /** 序列8 - 格斗家魔药。 */
    public static final DeferredItem<SeerPotionItem> FIGHTER_POTION =
            ITEMS.register("fighter_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("giant_8")));

    /** 序列7 - 武器大师魔药。 */
    public static final DeferredItem<SeerPotionItem> WEAPON_MASTER_POTION =
            ITEMS.register("weapon_master_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("giant_7")));

    /** 序列6 - 黎明骑士魔药。 */
    public static final DeferredItem<SeerPotionItem> DAWN_KNIGHT_POTION =
            ITEMS.register("dawn_knight_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("giant_6")));

    // ===== 黑暗途径（不眠者 / 午夜诗人 / 梦魇 / 安魂师）=====

    /** 序列9 - 不眠者魔药。 */
    public static final DeferredItem<SeerPotionItem> SLEEPLESS_POTION =
            ITEMS.register("sleepless_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("darkness_9")));

    /** 序列8 - 午夜诗人魔药。 */
    public static final DeferredItem<SeerPotionItem> MIDNIGHT_POET_POTION =
            ITEMS.register("midnight_poet_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("darkness_8")));

    /** 序列7 - 梦魇魔药。 */
    public static final DeferredItem<SeerPotionItem> NIGHTMARE_POTION =
            ITEMS.register("nightmare_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("darkness_7")));

    /** 序列6 - 安魂师魔药。 */
    public static final DeferredItem<SeerPotionItem> REQUIEM_POTION =
            ITEMS.register("requiem_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("darkness_6")));

    // ===== 死神途径（收尸人 / 掘墓人 / 通灵者 / 死灵导师）=====

    /** 序列9 - 收尸人魔药。 */
    public static final DeferredItem<SeerPotionItem> CORPSE_COLLECTOR_POTION =
            ITEMS.register("corpse_collector_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("death_9")));

    /** 序列8 - 掘墓人魔药。 */
    public static final DeferredItem<SeerPotionItem> GRAVEDIGGER_POTION =
            ITEMS.register("gravedigger_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("death_8")));

    /** 序列7 - 通灵者魔药。 */
    public static final DeferredItem<SeerPotionItem> SPIRIT_MEDIUM_POTION =
            ITEMS.register("spirit_medium_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("death_7")));

    /** 序列6 - 死灵导师魔药。 */
    public static final DeferredItem<SeerPotionItem> NECROMANCER_POTION =
            ITEMS.register("necromancer_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("death_6")));

    // ===== 黎明骑士（黄昏巨人途径）装备 =====

    /** 晨曦之剑：手持 3D 模型武器。 */
    public static final DeferredItem<DawnSwordItem> DAWN_SWORD =
            ITEMS.register("dawn_sword",
                    () -> new DawnSwordItem(new Item.Properties()));

    /** 岩浆之剑：深渊·序列6"恶魔"的标志性武器，手持 3D 模型。 */
    public static final DeferredItem<MagmaSwordItem> MAGMA_SWORD =
            ITEMS.register("magma_sword",
                    () -> new MagmaSwordItem(new Item.Properties()));

    /** 黎明铠甲：胸甲槽 3D 模型盔甲。 */
    public static final DeferredItem<DawnArmorItem> DAWN_ARMOR =
            ITEMS.register("dawn_armor",
                    () -> new DawnArmorItem(ModArmorMaterials.DAWN, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().stacksTo(1)));

    /** 狼人化变身（隐藏物品，仅作变身叠加模型的渲染载体）。 */
    public static final DeferredItem<WolfmanFormItem> WOLFMAN_FORM =
            ITEMS.register("wolfman_form",
                    () -> new WolfmanFormItem(ModArmorMaterials.DAWN, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().stacksTo(1)));

    /** 恶魔化变身（隐藏物品，仅作变身全身模型的渲染载体）。 */
    public static final DeferredItem<DemonFormItem> DEMON_FORM =
            ITEMS.register("demon_form",
                    () -> new DemonFormItem(ModArmorMaterials.DAWN, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().stacksTo(1)));

    // ===== 实验途径魔药（错误 / 门 / 完美者 / 隐者 / 月亮 / 母亲 / 深渊 / 被缚者 / 审判者 / 黑皇帝 / 命运之轮）=====

    // 错误途径
    public static final DeferredItem<SeerPotionItem> ERROR_9_POTION =
            ITEMS.register("error_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("error_9")));
    public static final DeferredItem<SeerPotionItem> ERROR_8_POTION =
            ITEMS.register("error_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("error_8")));
    public static final DeferredItem<SeerPotionItem> ERROR_7_POTION =
            ITEMS.register("error_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("error_7")));
    public static final DeferredItem<SeerPotionItem> ERROR_6_POTION =
            ITEMS.register("error_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("error_6")));

    // 门途径
    public static final DeferredItem<SeerPotionItem> DOOR_9_POTION =
            ITEMS.register("door_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("door_9")));
    public static final DeferredItem<SeerPotionItem> DOOR_8_POTION =
            ITEMS.register("door_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("door_8")));
    public static final DeferredItem<SeerPotionItem> DOOR_7_POTION =
            ITEMS.register("door_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("door_7")));
    public static final DeferredItem<SeerPotionItem> DOOR_6_POTION =
            ITEMS.register("door_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("door_6")));

    /** 空白符咒：门途径书写符咒的基础载体（素材 / 收藏品）。 */
    public static final DeferredItem<BlankTalismanItem> BLANK_TALISMAN =
            ITEMS.register("blank_talisman",
                    () -> new BlankTalismanItem(new Item.Properties().stacksTo(16)));

    // 完美者途径
    public static final DeferredItem<SeerPotionItem> PARAGON_9_POTION =
            ITEMS.register("paragon_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("paragon_9")));
    public static final DeferredItem<SeerPotionItem> PARAGON_8_POTION =
            ITEMS.register("paragon_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("paragon_8")));
    public static final DeferredItem<SeerPotionItem> PARAGON_7_POTION =
            ITEMS.register("paragon_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("paragon_7")));
    public static final DeferredItem<SeerPotionItem> PARAGON_6_POTION =
            ITEMS.register("paragon_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("paragon_6")));

    // 隐者途径
    public static final DeferredItem<SeerPotionItem> HERMIT_9_POTION =
            ITEMS.register("hermit_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hermit_9")));
    public static final DeferredItem<SeerPotionItem> HERMIT_8_POTION =
            ITEMS.register("hermit_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hermit_8")));
    public static final DeferredItem<SeerPotionItem> HERMIT_7_POTION =
            ITEMS.register("hermit_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hermit_7")));
    public static final DeferredItem<SeerPotionItem> HERMIT_6_POTION =
            ITEMS.register("hermit_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("hermit_6")));

    // 月亮途径
    public static final DeferredItem<SeerPotionItem> MOON_9_POTION =
            ITEMS.register("moon_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("moon_9")));
    public static final DeferredItem<SeerPotionItem> MOON_8_POTION =
            ITEMS.register("moon_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("moon_8")));
    public static final DeferredItem<SeerPotionItem> MOON_7_POTION =
            ITEMS.register("moon_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("moon_7")));
    public static final DeferredItem<SeerPotionItem> MOON_6_POTION =
            ITEMS.register("moon_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("moon_6")));

    // 母亲途径
    public static final DeferredItem<SeerPotionItem> MOTHER_9_POTION =
            ITEMS.register("mother_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("mother_9")));
    public static final DeferredItem<SeerPotionItem> MOTHER_8_POTION =
            ITEMS.register("mother_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("mother_8")));
    public static final DeferredItem<SeerPotionItem> MOTHER_7_POTION =
            ITEMS.register("mother_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("mother_7")));
    public static final DeferredItem<SeerPotionItem> MOTHER_6_POTION =
            ITEMS.register("mother_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("mother_6")));

    // 深渊途径
    public static final DeferredItem<SeerPotionItem> ABYSS_9_POTION =
            ITEMS.register("abyss_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("abyss_9")));
    public static final DeferredItem<SeerPotionItem> ABYSS_8_POTION =
            ITEMS.register("abyss_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("abyss_8")));
    public static final DeferredItem<SeerPotionItem> ABYSS_7_POTION =
            ITEMS.register("abyss_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("abyss_7")));
    public static final DeferredItem<SeerPotionItem> ABYSS_6_POTION =
            ITEMS.register("abyss_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("abyss_6")));

    // 被缚者途径
    public static final DeferredItem<SeerPotionItem> CHAINED_9_POTION =
            ITEMS.register("chained_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("chained_9")));
    public static final DeferredItem<SeerPotionItem> CHAINED_8_POTION =
            ITEMS.register("chained_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("chained_8")));
    public static final DeferredItem<SeerPotionItem> CHAINED_7_POTION =
            ITEMS.register("chained_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("chained_7")));
    public static final DeferredItem<SeerPotionItem> CHAINED_6_POTION =
            ITEMS.register("chained_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("chained_6")));

    // 审判者途径
    public static final DeferredItem<SeerPotionItem> JUSTICE_9_POTION =
            ITEMS.register("justice_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("justice_9")));
    public static final DeferredItem<SeerPotionItem> JUSTICE_8_POTION =
            ITEMS.register("justice_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("justice_8")));
    public static final DeferredItem<SeerPotionItem> JUSTICE_7_POTION =
            ITEMS.register("justice_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("justice_7")));
    public static final DeferredItem<SeerPotionItem> JUSTICE_6_POTION =
            ITEMS.register("justice_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("justice_6")));

    // 黑皇帝途径
    public static final DeferredItem<SeerPotionItem> BLACK_EMPEROR_9_POTION =
            ITEMS.register("black_emperor_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("black_emperor_9")));
    public static final DeferredItem<SeerPotionItem> BLACK_EMPEROR_8_POTION =
            ITEMS.register("black_emperor_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("black_emperor_8")));
    public static final DeferredItem<SeerPotionItem> BLACK_EMPEROR_7_POTION =
            ITEMS.register("black_emperor_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("black_emperor_7")));
    public static final DeferredItem<SeerPotionItem> BLACK_EMPEROR_6_POTION =
            ITEMS.register("black_emperor_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("black_emperor_6")));

    // 命运之轮途径
    public static final DeferredItem<SeerPotionItem> WHEEL_9_POTION =
            ITEMS.register("wheel_9_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("wheel_9")));
    public static final DeferredItem<SeerPotionItem> WHEEL_8_POTION =
            ITEMS.register("wheel_8_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("wheel_8")));
    public static final DeferredItem<SeerPotionItem> WHEEL_7_POTION =
            ITEMS.register("wheel_7_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("wheel_7")));
    public static final DeferredItem<SeerPotionItem> WHEEL_6_POTION =
            ITEMS.register("wheel_6_potion",
                    () -> new SeerPotionItem(new Item.Properties(), GuimiMod.id("wheel_6")));
}
