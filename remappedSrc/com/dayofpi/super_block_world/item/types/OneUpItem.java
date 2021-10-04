package com.dayofpi.super_block_world.item.types;

import com.dayofpi.super_block_world.SoundList;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OneUpItem extends Item {
    public OneUpItem(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.playSound(SoundList.itemOneUp, 1.0F, 1.0F);
        return super.finishUsing(stack, world, user);
    }
}
