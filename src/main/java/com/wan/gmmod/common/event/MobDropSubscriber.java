package com.wan.gmmod.common.event;

import com.wan.gmmod.GuimiMod;
import com.wan.gmmod.common.registry.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

/**
 * 生物掉落注入：为原版章鱼（含发光鱿鱼）追加「拉瓦章鱼血液」掉落，作为占卜家魔药主料。
 */
@EventBusSubscriber(modid = GuimiMod.MODID)
public class MobDropSubscriber {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide() || !(entity instanceof Squid)) {
            return;
        }
        int count = 1 + entity.level().random.nextInt(2); // 1~2 份
        ItemStack blood = new ItemStack(ModItems.LAVA_OCTOPUS_BLOOD.get(), count);
        event.getDrops().add(new ItemEntity(entity.level(),
                entity.getX(), entity.getY(), entity.getZ(), blood));
    }
}
