package com.wan.gmmod.content.spirituality;

import com.wan.gmmod.common.capability.ModAttachments;
import com.wan.gmmod.content.abilities.Ability;
import com.wan.gmmod.content.abilities.SkillManager;
import net.minecraft.world.entity.player.Player;

/**
 * 灵性上限成长系统。
 * <p>
 * 基础公式：灵性上限 = 序列基础值 + 途径加成 + 冥想修炼加成
 * <ul>
 *     <li>序列基础值：序列9=100，序列8=120，序列7=150，序列6=200，序列5=300，
 *     序列4=500（半神质变），序列3=600，序列2=1000（天使质变），序列1=2000，序列0=无限；</li>
 *     <li>途径加成：由已解锁的灵性扩展类能力提供（如隐者「灵性扩展」+20、门「灵性提升」+30）；</li>
 *     <li>冥想修炼加成：累计冥想恢复周期折算，封顶 {@value #TRAINING_BONUS_CAP} 点。</li>
 * </ul>
 * 上限不落盘存储而是实时计算，晋升 / 解锁能力后立即生效。
 */
public final class SpiritualityManager {

    /** 序列0的「无限」上限哨兵值 */
    public static final int INFINITE = Integer.MAX_VALUE;

    /** 各序列等级的基础灵性上限，索引 = 序列等级（index0 = 序列0 = 无限，index9 = 序列9） */
    private static final int[] BASE_BY_LEVEL = {
            INFINITE, 2000, 1000, 600, 500, 300, 200, 150, 120, 100
    };

    /** 每累计多少个冥想恢复周期（2 秒/周期）折算 1 点上限加成 */
    private static final int TRAINING_CYCLES_PER_POINT = 30;
    /** 冥想修炼加成封顶 */
    private static final int TRAINING_BONUS_CAP = 50;

    private SpiritualityManager() {}

    /** 玩家当前灵性上限（两端通用，依赖已同步的附件）。 */
    public static int getMax(Player player) {
        int level = player.getData(ModAttachments.SEQUENCE_LEVEL);
        if (level <= 0) {
            // 未就职：保留默认值作为兜底
            return ModAttachments.DEFAULT_SPIRITUALITY;
        }
        int base = BASE_BY_LEVEL[Math.min(level, BASE_BY_LEVEL.length - 1)];
        if (base == INFINITE) {
            // 序列0：无限，不再叠加任何加成
            return INFINITE;
        }
        return base + pathwayBonus(player) + meditationBonus(player);
    }

    /** 上限是否为「无限」（序列0）。 */
    public static boolean isInfinite(int max) {
        return max == INFINITE;
    }

    /** 途径加成：由已解锁的灵性扩展类能力提供。 */
    private static int pathwayBonus(Player player) {
        int bonus = 0;
        for (Ability ability : SkillManager.getUnlockedAbilities(player)) {
            String path = ability.getId().getPath();
            if ("her_spirit_expand".equals(path)) {
                bonus += 20; // 隐者·格斗学者「灵性扩展」：灵性上限 +20
            } else if ("door_spirit_boost".equals(path)) {
                bonus += 30; // 门·记录官「灵性提升」：灵性上限 +30
            }
        }
        return bonus;
    }

    /** 冥想修炼加成：累计冥想周期越多上限越高，封顶 {@value #TRAINING_BONUS_CAP} 点。 */
    private static int meditationBonus(Player player) {
        int cycles = player.getData(ModAttachments.MEDITATION_TRAINING);
        return Math.min(TRAINING_BONUS_CAP, cycles / TRAINING_CYCLES_PER_POINT);
    }

    /** 冥想每完成一个恢复周期调用一次：累计修炼进度（服务端）。 */
    public static void addTrainingCycle(Player player) {
        int cycles = player.getData(ModAttachments.MEDITATION_TRAINING);
        // 达到加成封顶后不再累计，避免数值无意义增长
        if (cycles < TRAINING_BONUS_CAP * TRAINING_CYCLES_PER_POINT) {
            player.setData(ModAttachments.MEDITATION_TRAINING, cycles + 1);
        }
    }
}
