package com.dayofpi.super_block_world.block.types.template;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.TagList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class ModFluidBlock extends FluidBlock {
    public ModFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return true;
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (this.receiveNeighborFluids(world, pos)) {
            world.getFluidTickScheduler().schedule(pos, state.getFluidState().getFluid(), this.fluid.getTickRate(world));
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (this.receiveNeighborFluids(world, pos)) {
            world.getFluidTickScheduler().schedule(pos, state.getFluidState().getFluid(), this.fluid.getTickRate(world));
        }
    }

    private boolean receiveNeighborFluids(World world, BlockPos pos) {
        if (this.fluid.isIn(TagList.POISON)) {
            for (Direction ignored : field_34006) {
                BlockPos blockPos = pos.add(1, 1, 1);
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER) && !world.getFluidState(blockPos).isIn(TagList.POISON)) {
                    Block block = Blocks.AIR;
                    world.setBlockState(blockPos, block.getDefaultState());
                    playExtinguishEvent(world, pos);
                    return false;
                }

                if (world.getFluidState(blockPos).isIn(FluidTags.LAVA)) {
                    Block block = BlockList.VANILLATE_CRUMBLE;
                    world.setBlockState(pos, block.getDefaultState());
                    this.playExtinguishEvent(world, pos);
                    return false;
                }
            }
        }
        return true;
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(1501, pos, 0);
    }
}
