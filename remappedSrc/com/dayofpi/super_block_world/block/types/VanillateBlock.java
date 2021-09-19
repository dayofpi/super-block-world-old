package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.misc.TagList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Random;

@SuppressWarnings("deprecation")
public class VanillateBlock extends Block {
    public VanillateBlock(Settings settings) {
        super(settings);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        FluidState fluidState = world.getFluidState(pos.up());
        if (direction == Direction.UP && fluidState.isIn(FluidTags.LAVA) && !fluidState.isIn(TagList.POISON)) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        FluidState fluidState = world.getFluidState(pos.up());
        if (fluidState.isIn(FluidTags.LAVA) && !fluidState.isIn(TagList.POISON)) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        }}

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, BlockList.TOPPED_VANILLATE.getDefaultState(), world, pos));
    }

}
