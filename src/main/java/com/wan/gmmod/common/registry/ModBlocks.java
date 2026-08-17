package com.wan.gmmod.common.registry;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.block.GuimiPlantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(GuimiMod.MODID);

    // 示例方块（无功能）
    public static final DeferredBlock<Block> SPIRIT_STONE =
            BLOCKS.register("spirit_stone",
                    () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    // ===== 主世界自然生成的草本植物（十字形模型，用于炼制魔药）=====

    /** 金薄荷：破坏掉落「金薄荷叶子」。 */
    public static final DeferredBlock<GuimiPlantBlock> GOLD_MINT =
            BLOCKS.register("gold_mint", () -> new GuimiPlantBlock(plantProperties()));

    /** 夜香草：破坏掉落自身。 */
    public static final DeferredBlock<GuimiPlantBlock> NIGHT_FRAGRANCE =
            BLOCKS.register("night_fragrance", () -> new GuimiPlantBlock(plantProperties()));

    /** 龙血草：破坏掉落自身。 */
    public static final DeferredBlock<GuimiPlantBlock> DRAGON_BLOOD_GRASS =
            BLOCKS.register("dragon_blood_grass", () -> new GuimiPlantBlock(plantProperties()));

    /** 毒堇：破坏掉落自身。 */
    public static final DeferredBlock<GuimiPlantBlock> POISON_HEMLOCK =
            BLOCKS.register("poison_hemlock", () -> new GuimiPlantBlock(plantProperties()));

    // ===== 仪式方块 =====

    /** 祭台：仪式系统核心方块，右键放置材料合成魔药，支持冥想交互。 */
    public static final DeferredBlock<Block> ALTAR =
            BLOCKS.register("altar",
                    () -> new com.wan.gmmod.common.block.AltarBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.DEEPSLATE)
                                    .strength(3.0F, 6.0F)
                                    .sound(SoundType.DEEPSLATE)
                                    .requiresCorrectToolForDrops()));

    /** 花草类通用方块属性：无碰撞、瞬间破坏、草声、XZ 随机偏移、活塞可摧毁。 */
    private static BlockBehaviour.Properties plantProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY);
    }
}
