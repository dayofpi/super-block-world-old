package com.dayofpi.super_block_world.blocks.types;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
@SuppressWarnings("deprecation")
public abstract class ReactiveBlock extends Block {
    public ReactiveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos blockPos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(blockPos)) {
            this.activate(world.getBlockState(blockPos), world, blockPos);
        }
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos blockPos, PlayerEntity player) {
        this.activate(state, world, blockPos);
    }

    public void activate(BlockState state, World world, BlockPos blockPos) {}
}
