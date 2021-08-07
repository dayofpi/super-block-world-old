package com.dayofpi.super_block_world.common.block;

import com.dayofpi.super_block_world.registry.ModBlocks;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings("deprecation")
public class ToadstoolSoil extends Block implements Fertilizable {
    public ToadstoolSoil(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        for(int i = 0; i < 4; ++i) {
            BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
            if (world.getBlockState(blockPos).isOf(ModBlocks.TOADSTOOL_SOIL)) {
                world.setBlockState(pos, ModBlocks.TOADSTOOL_GRASS.getDefaultState(), 2);
                world.setBlockState(blockPos, ModBlocks.TOADSTOOL_GRASS.getDefaultState(), 2);
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isIn(FabricToolTags.HOES))
        {
            world.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, ModBlocks.TOADSTOOL_FARMLAND.getDefaultState(), 2);
            return ActionResult.success(world.isClient);
        } else if (itemStack.isIn(FabricToolTags.SHOVELS)) {
            world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, ModBlocks.TOADSTOOL_PATH.getDefaultState(), 2);
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }
}
