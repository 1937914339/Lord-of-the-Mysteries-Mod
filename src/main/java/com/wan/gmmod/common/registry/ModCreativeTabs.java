package com.wan.gmmod.common.registry;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.item.CharacteristicItem;
import com.wan.gmmod.content.sequences.Sequences;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    // 注意：创造标签页注册表是 Registries.CREATIVE_MODE_TAB，不是 ITEM
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GuimiMod.MODID);

    public static final Supplier<CreativeModeTab> GUIMI_TAB = TABS.register("guimi_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.guimi_mod.guimi_tab"))
                    .icon(() -> new ItemStack(ModItems.SEER_POTION.get()))
                    .displayItems((params, output) -> {
                        // 在这里添加所有属于本模组的物品

                        output.accept(ModItems.SEER_POTION.get());
                        output.accept(ModItems.TOP_HAT.get());
                        output.accept(ModItems.WAND.get());
                        output.accept(ModItems.PENDULUM.get());
                        output.accept(ModItems.VEST.get());
                        output.accept(ModItems.BLACK_VEST.get());
                        output.accept(ModItems.LONG_PANTS.get());
                        output.accept(ModItems.BLACK_SHOES.get());
                        output.accept(ModItems.WRAITH_SPAWN_EGG.get());
                        output.accept(ModItems.MERMAID_SPAWN_EGG.get());
                        output.accept(ModItems.NUN_SPAWN_EGG.get());
                        output.accept(ModItems.PRIEST_SPAWN_EGG.get());
                        output.accept(ModItems.WOLFMAN_SPAWN_EGG.get());
                        output.accept(ModItems.SEALED_ARTIFACT.get());
                        output.accept(ModItems.MAGIC_ARTIFACT.get());
                        // 仪式 / 武器
                        output.accept(ModItems.RITUAL_DAGGER.get());
                        output.accept(ModItems.SILENCE_GUN.get());
                        // 灵性钓竿
                        output.accept(ModItems.SPIRIT_ROD.get());
                        // 纸人（纸人替身能力锚点）
                        output.accept(ModItems.PAPER_FIGURINE.get());
                        // 纸牌（小丑「飞牌」专属弹药）
                        output.accept(ModItems.PAPER_CARD.get());
                        // 子弹
                        output.accept(ModItems.BULLET.get());
                        output.accept(ModItems.DEPRIVATION_BULLET.get());
                        output.accept(ModItems.PARASITIC_BULLET.get());
                        output.accept(ModItems.SPIRIT_CONTROL_BULLET.get());
                        output.accept(ModItems.DECEPTION_BULLET.get());
                        output.accept(ModItems.EXORCISM_BULLET.get());
                        output.accept(ModItems.PURIFICATION_BULLET.get());
                        // 魔药
                        output.accept(ModItems.CLOWN_POTION.get());
                        output.accept(ModItems.MAGICIAN_POTION.get());
                        output.accept(ModItems.FACELESS_POTION.get());
                        output.accept(ModItems.MARIONETTIST_POTION.get());
                        // 炼药材料
                        output.accept(ModItems.STAR_CRYSTAL.get());
                        output.accept(ModItems.LAVA_OCTOPUS_BLOOD.get());
                        output.accept(ModItems.PURIFIED_WATER.get());
                        output.accept(ModItems.GOLD_MINT_LEAF.get());
                        output.accept(ModItems.AGRIMONY.get());
                        output.accept(ModItems.BLACK_EDGED_SUNFLOWER.get());
                        output.accept(ModItems.BLACK_MANDRAGORA.get());
                        output.accept(ModItems.GOLDEN_CLOAK_GRASS.get());
                        output.accept(ModItems.MANDRAGORA.get());
                        output.accept(ModItems.PSYCHEDELIC_GRASS.get());
                        output.accept(ModItems.MIST_TREANT_ROOT.get());
                        output.accept(ModItems.MIST_TREANT_JUICE.get());
                        output.accept(ModItems.THOUSAND_FACED_HUNTER_BLOOD.get());
                        output.accept(ModItems.THOUSAND_FACED_HUNTER_PITUITARY.get());
                        output.accept(ModItems.FACE_ROSE.get());
                        output.accept(ModItems.HORNACIS_GOAT_HORN_CRYSTAL.get());
                        output.accept(ModItems.DEEP_SEA_NAGA_HAIR.get());
                        output.accept(ModItems.WATER_SHAPE_GEM.get());
                        output.accept(ModItems.EVIL_PANTHER_SPINAL_FLUID.get());
                        output.accept(ModItems.ANCIENT_WRAITH_DUST.get());
                        output.accept(ModItems.SIX_WINGED_GARGOYLE_CORE_CRYSTAL.get());
                        output.accept(ModItems.SONIA_GOLDEN_SPRING_WATER.get());
                        output.accept(ModItems.DRAGON_PATTERN_TREE_BARK.get());
                        output.accept(ModItems.ANCIENT_WRAITH_RESIDUAL_SPIRITUALITY.get());
                        output.accept(ModItems.SIX_WINGED_GARGOYLE_EYE.get());
                        // 植物方块
                        output.accept(ModItems.GOLD_MINT.get());
                        output.accept(ModItems.NIGHT_FRAGRANCE.get());
                        output.accept(ModItems.DRAGON_BLOOD_GRASS.get());
                        output.accept(ModItems.POISON_HEMLOCK.get());
                        // 祭台
                        output.accept(ModItems.ALTAR.get());
                        // 魔女途径
                        output.accept(ModItems.MIRROR.get());
                        output.accept(ModItems.MIRROR_BROKEN.get());
                        output.accept(ModItems.ASSASSIN_POTION.get());
                        output.accept(ModItems.INSTIGATOR_POTION.get());
                        output.accept(ModItems.WITCH_POTION.get());
                        output.accept(ModItems.JOYFUL_WITCH_POTION.get());
                        // 战争之红途径
                        output.accept(ModItems.HEMOSTATIC_SALVE.get());
                        output.accept(ModItems.BASIC_POISON.get());
                        output.accept(ModItems.FLAME_WEAPON.get());
                        output.accept(ModItems.HUNTER_POTION.get());
                        output.accept(ModItems.PROVOKER_POTION.get());
                        output.accept(ModItems.PYROMANIAC_POTION.get());
                        output.accept(ModItems.CONSPIRER_POTION.get());
                        // 倒吊人途径
                        output.accept(ModItems.MYSTIC_PRAYER_POTION.get());
                        output.accept(ModItems.LISTENER_POTION.get());
                        output.accept(ModItems.HERMIT_POTION.get());
                        output.accept(ModItems.ROSE_BISHOP_POTION.get());
                        // 空想家途径
                        output.accept(ModItems.SPECTATOR_POTION.get());
                        output.accept(ModItems.MIND_READER_POTION.get());
                        output.accept(ModItems.PSYCHOLOGIST_POTION.get());
                        output.accept(ModItems.HYPNOTIST_POTION.get());
                        // 暴君途径
                        output.accept(ModItems.SAILOR_POTION.get());
                        output.accept(ModItems.WRATHFUL_POTION.get());
                        output.accept(ModItems.NAVIGATOR_POTION.get());
                        output.accept(ModItems.WIND_FAVORED_POTION.get());
                        // 太阳途径
                        output.accept(ModItems.PRAISER_POTION.get());
                        output.accept(ModItems.LIGHT_SEEKER_POTION.get());
                        output.accept(ModItems.SUN_PRIEST_POTION.get());
                        output.accept(ModItems.NOTARY_POTION.get());
                        // 白塔途径
                        output.accept(ModItems.READER_POTION.get());
                        output.accept(ModItems.REASONING_STUDENT_POTION.get());
                        output.accept(ModItems.KNOWLEDGE_GUARDIAN_POTION.get());
                        output.accept(ModItems.ERUDITE_POTION.get());
                        // 黄昏巨人途径
                        output.accept(ModItems.WARRIOR_POTION.get());
                        output.accept(ModItems.FIGHTER_POTION.get());
                        output.accept(ModItems.WEAPON_MASTER_POTION.get());
                        output.accept(ModItems.DAWN_KNIGHT_POTION.get());
                        // 黑暗途径
                        output.accept(ModItems.SLEEPLESS_POTION.get());
                        output.accept(ModItems.MIDNIGHT_POET_POTION.get());
                        output.accept(ModItems.NIGHTMARE_POTION.get());
                        output.accept(ModItems.REQUIEM_POTION.get());
                        // 死神途径
                        output.accept(ModItems.CORPSE_COLLECTOR_POTION.get());
                        output.accept(ModItems.GRAVEDIGGER_POTION.get());
                        output.accept(ModItems.SPIRIT_MEDIUM_POTION.get());
                        output.accept(ModItems.NECROMANCER_POTION.get());
                        // 实验途径魔药
                        output.accept(ModItems.ERROR_9_POTION.get());
                        output.accept(ModItems.ERROR_8_POTION.get());
                        output.accept(ModItems.ERROR_7_POTION.get());
                        output.accept(ModItems.ERROR_6_POTION.get());
                        output.accept(ModItems.DOOR_9_POTION.get());
                        output.accept(ModItems.DOOR_8_POTION.get());
                        output.accept(ModItems.DOOR_7_POTION.get());
                        output.accept(ModItems.DOOR_6_POTION.get());
                        output.accept(ModItems.BLANK_TALISMAN.get());
                        output.accept(ModItems.PARAGON_9_POTION.get());
                        output.accept(ModItems.PARAGON_8_POTION.get());
                        output.accept(ModItems.PARAGON_7_POTION.get());
                        output.accept(ModItems.PARAGON_6_POTION.get());
                        output.accept(ModItems.HERMIT_9_POTION.get());
                        output.accept(ModItems.HERMIT_8_POTION.get());
                        output.accept(ModItems.HERMIT_7_POTION.get());
                        output.accept(ModItems.HERMIT_6_POTION.get());
                        output.accept(ModItems.MOON_9_POTION.get());
                        output.accept(ModItems.MOON_8_POTION.get());
                        output.accept(ModItems.MOON_7_POTION.get());
                        output.accept(ModItems.MOON_6_POTION.get());
                        output.accept(ModItems.MOTHER_9_POTION.get());
                        output.accept(ModItems.MOTHER_8_POTION.get());
                        output.accept(ModItems.MOTHER_7_POTION.get());
                        output.accept(ModItems.MOTHER_6_POTION.get());
                        output.accept(ModItems.ABYSS_9_POTION.get());
                        output.accept(ModItems.ABYSS_8_POTION.get());
                        output.accept(ModItems.ABYSS_7_POTION.get());
                        output.accept(ModItems.ABYSS_6_POTION.get());
                        output.accept(ModItems.CHAINED_9_POTION.get());
                        output.accept(ModItems.CHAINED_8_POTION.get());
                        output.accept(ModItems.CHAINED_7_POTION.get());
                        output.accept(ModItems.CHAINED_6_POTION.get());
                        output.accept(ModItems.JUSTICE_9_POTION.get());
                        output.accept(ModItems.JUSTICE_8_POTION.get());
                        output.accept(ModItems.JUSTICE_7_POTION.get());
                        output.accept(ModItems.JUSTICE_6_POTION.get());
                        output.accept(ModItems.BLACK_EMPEROR_9_POTION.get());
                        output.accept(ModItems.BLACK_EMPEROR_8_POTION.get());
                        output.accept(ModItems.BLACK_EMPEROR_7_POTION.get());
                        output.accept(ModItems.BLACK_EMPEROR_6_POTION.get());
                        output.accept(ModItems.WHEEL_9_POTION.get());
                        output.accept(ModItems.WHEEL_8_POTION.get());
                        output.accept(ModItems.WHEEL_7_POTION.get());
                        output.accept(ModItems.WHEEL_6_POTION.get());
                        // 黎明骑士装备
                        output.accept(ModItems.DAWN_SWORD.get());
                        output.accept(ModItems.DAWN_ARMOR.get());
                        output.accept(ModItems.MAGMA_SWORD.get());
                    })
                    .build()
    );

    /** 非凡特性专属标签页（各途径 / 序列的特性物品）。 */
    public static final Supplier<CreativeModeTab> CHARACTERISTIC_TAB = TABS.register("guimi_characteristics_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.guimi_mod.guimi_characteristics"))
                    .icon(() -> new ItemStack(ModItems.CHARACTERISTIC.get()))
                    .displayItems((params, output) -> {
                        // 门途径序列 9 → 1 非凡特性（各有专属图标 door_seq_*）
                        for (int lvl = 9; lvl >= 1; lvl--) {
                            output.accept(CharacteristicItem.create(Sequences.Pathway.DOOR, lvl));
                        }
                        // 无数据默认特性 + 已实装的其他途径特性物品
                        output.accept(ModItems.CHARACTERISTIC.get());
                        output.accept(ModItems.FACELESS_CHARACTERISTIC.get());
                        output.accept(ModItems.MARIONETTIST_CHARACTERISTIC.get());
                        output.accept(ModItems.HUMAN_SKIN_SHADOW_CHARACTERISTIC.get());
                    })
                    .build()
    );
}