package com.dayofpi.super_block_world.item.types;

import com.dayofpi.super_block_world.NewSoundList;
import com.dayofpi.super_block_world.entity.types.projectiles.TurnipEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TurnipItem extends Item {
   public TurnipItem(Settings settings) {
      super(settings);
   }

   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      ItemStack itemStack = user.getStackInHand(hand);
      world.playSound(null, user.getX(), user.getY(), user.getZ(), NewSoundList.ITEM_PROJECTILE_THROW, SoundCategory.NEUTRAL, 0.5F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
      user.getItemCooldownManager().set(this, 5);
      if (!world.isClient) {
         TurnipEntity turnipEntity = new TurnipEntity(world, user);
         turnipEntity.setItem(itemStack);
         turnipEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
         world.spawnEntity(turnipEntity);
      }

      user.incrementStat(Stats.USED.getOrCreateStat(this));
      if (!user.getAbilities().creativeMode) {
         itemStack.decrement(1);
      }

      return TypedActionResult.success(itemStack, world.isClient());
   }
}
