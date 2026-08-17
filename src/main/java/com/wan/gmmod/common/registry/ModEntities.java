package com.wan.gmmod.common.registry;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.content.entities.AirBulletEntity;
import com.wan.gmmod.content.entities.BlackFlameEntity;
import com.wan.gmmod.content.entities.BulletEntity;
import com.wan.gmmod.content.entities.IceSpearEntity;
import com.wan.gmmod.content.entities.FireRavenEntity;
import com.wan.gmmod.content.entities.FlameOrbEntity;
import com.wan.gmmod.content.entities.FlameSpearEntity;
import com.wan.gmmod.content.entities.FlameTrapEntity;
import com.wan.gmmod.content.entities.FlyingCardEntity;
import com.wan.gmmod.content.entities.MermaidEntity;
import com.wan.gmmod.content.entities.NunEntity;
import com.wan.gmmod.content.entities.PaperFigurineEntity;
import com.wan.gmmod.content.entities.PriestEntity;
import com.wan.gmmod.content.entities.ShadowCreatureEntity;
import com.wan.gmmod.content.entities.SpiritEntity;
import com.wan.gmmod.content.entities.WraithEntity;
import com.wan.gmmod.content.entities.WolfmanEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, GuimiMod.MODID);

    public static final Supplier<EntityType<SpiritEntity>> SPIRIT = ENTITIES.register("spirit",
            () -> EntityType.Builder.of(SpiritEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.8f)
                    .build("spirit"));

    // 怨灵：主动攻击玩家的灵体怪物（GeckoLib 动画实体）
    public static final Supplier<EntityType<WraithEntity>> WRAITH = ENTITIES.register("wraith",
            () -> EntityType.Builder.of(WraithEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.9f)
                    .build("wraith"));

    // 修女：温和的中立居民（GeckoLib 动画实体），在村庄 / 平原自然生成
    public static final Supplier<EntityType<NunEntity>> NUN = ENTITIES.register("nun",
            () -> EntityType.Builder.<NunEntity>of(NunEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.9f)
                    .build("nun"));

    // 神父：温和的中立居民（GeckoLib 动画实体），在村庄 / 平原自然生成
    public static final Supplier<EntityType<PriestEntity>> PRIEST = ENTITIES.register("priest",
            () -> EntityType.Builder.<PriestEntity>of(PriestEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.9f)
                    .build("priest"));

    // 美人鱼：海洋生物群系低概率生成的水生生物（GeckoLib 动画实体），
    // 周期性演唱「美人鱼的歌声」，为秘偶大师晋升仪式提供环境条件
    public static final Supplier<EntityType<MermaidEntity>> MERMAID = ENTITIES.register("mermaid",
            () -> EntityType.Builder.of(MermaidEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.6f, 1.8f)
                    .build("mermaid"));

    // 飞牌：小丑「飞牌」能力的弹射物
    public static final Supplier<EntityType<FlyingCardEntity>> FLYING_CARD = ENTITIES.register("flying_card",
            () -> EntityType.Builder.<FlyingCardEntity>of(FlyingCardEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("flying_card"));

    // 空气弹：魔术师 / 无面人「空气弹」能力的无形弹射物
    public static final Supplier<EntityType<AirBulletEntity>> AIR_BULLET = ENTITIES.register("air_bullet",
            () -> EntityType.Builder.<AirBulletEntity>of(AirBulletEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("air_bullet"));

    // 子弹：丧钟发射的弹射物，外观与效果由装填的子弹物品决定
    public static final Supplier<EntityType<BulletEntity>> BULLET = ENTITIES.register("bullet",
            () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("bullet"));

    // 纸人：纸人替身能力的静态锚点实体
    public static final Supplier<EntityType<PaperFigurineEntity>> PAPER_FIGURINE = ENTITIES.register("paper_figurine",
            () -> EntityType.Builder.of(PaperFigurineEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.6f)
                    .clientTrackingRange(8)
                    .build("paper_figurine"));

    // 黑焰：女巫「操控黑焰」的弹射物，仅对有灵性的目标有效
    public static final Supplier<EntityType<BlackFlameEntity>> BLACK_FLAME = ENTITIES.register("black_flame",
            () -> EntityType.Builder.<BlackFlameEntity>of(BlackFlameEntity::new, MobCategory.MISC)
                    .sized(0.3f, 0.3f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("black_flame"));

    // 冰晶长枪：欢愉魔女「冰霜强化」的投掷物
    public static final Supplier<EntityType<IceSpearEntity>> ICE_SPEAR = ENTITIES.register("ice_spear",
            () -> EntityType.Builder.<IceSpearEntity>of(IceSpearEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("ice_spear"));

    // 火球：纵火家「火球术」「巨大火球」的弹射物
    public static final Supplier<EntityType<FlameOrbEntity>> FLAME_ORB = ENTITIES.register("flame_orb",
            () -> EntityType.Builder.<FlameOrbEntity>of(FlameOrbEntity::new, MobCategory.MISC)
                    .sized(0.3f, 0.3f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("flame_orb"));

    // 火鸦：纵火家「火鸦术」召唤的追踪火焰
    public static final Supplier<EntityType<FireRavenEntity>> FIRE_RAVEN = ENTITIES.register("fire_raven",
            () -> EntityType.Builder.<FireRavenEntity>of(FireRavenEntity::new, MobCategory.MISC)
                    .sized(0.35f, 0.35f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("fire_raven"));

    // 炽白之枪：纵火家「炽白之枪」投掷的穿透长枪
    public static final Supplier<EntityType<FlameSpearEntity>> FLAME_SPEAR = ENTITIES.register("flame_spear",
            () -> EntityType.Builder.<FlameSpearEntity>of(FlameSpearEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("flame_spear"));

// 火焰陷阱：纵火家「延时爆炸」放置的陷阱
    public static final Supplier<EntityType<FlameTrapEntity>> FLAME_TRAP = ENTITIES.register("flame_trap",
            () -> EntityType.Builder.<FlameTrapEntity>of(FlameTrapEntity::new, MobCategory.MISC)
                    .sized(0.4f, 0.4f)
                    .clientTrackingRange(8)
                    .updateInterval(10)
                    .build("flame_trap"));

    // 阴影生物：倒吊人「序列 7 隐修士」召唤阴影生物技能的暗影兽（GeckoLib 动画实体）
    public static final Supplier<EntityType<ShadowCreatureEntity>> SHADOW_CREATURE =
            ENTITIES.register("shadow_creature",
                    () -> EntityType.Builder.<ShadowCreatureEntity>of(ShadowCreatureEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .clientTrackingRange(8)
                            .build("shadow_creature"));

    // 狼人：被缚者「序列 7 狼人」对应的敌对生物（GeckoLib 动画实体），夜晚自然生成
    public static final Supplier<EntityType<WolfmanEntity>> WOLFMAN =
            ENTITIES.register("wolfman",
                    () -> EntityType.Builder.<WolfmanEntity>of(WolfmanEntity::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .clientTrackingRange(8)
                            .build("wolfman"));

}
