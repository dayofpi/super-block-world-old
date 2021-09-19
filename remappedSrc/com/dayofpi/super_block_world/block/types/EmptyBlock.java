package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.block.block_entity.QuestionBlockBE;
import com.dayofpi.super_block_world.misc.SoundList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class EmptyBlock  extends Block {
    public EmptyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isEmpty()) {
            world.setBlockState(blockPos, BlockList.QUESTION_BLOCK.getDefaultState(), 2);
            if (world.getBlockEntity(blockPos) instanceof QuestionBlockBE blockEntity) {
                blockEntity.setStack(0, itemStack.copy());
                blockEntity.markDirty();
                if (!player.isCreative()) {
                    player.getStackInHand(hand).setCount(0);
                }
            }
            world.playSound(null, blockPos, SoundList.ITEM_IN, SoundCategory.NEUTRAL, 2.0F, 1.0F);
            ParticleUtil.spawnParticle(world, blockPos, ParticleTypes.WAX_ON, UniformIntProvider.create(3, 5));
            return ActionResult.success(world.isClient);
        } else return ActionResult.PASS;
    }
}
