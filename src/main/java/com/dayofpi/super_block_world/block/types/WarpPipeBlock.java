package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.block_entity.WarpPipeBE;
import com.dayofpi.super_block_world.block.block_entity.WarpPipeTree;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WarpPipeBlock extends WarpPipeBodyBlock implements BlockEntityProvider {

    public static final WarpPipeTree warpPipeTree = new WarpPipeTree();

    public WarpPipeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onBlockAdded(state, world, pos, oldState, notify);
        world.getBlockTickScheduler().schedule(pos, this, 20);
        warpPipeTree.addBlockToChunk(pos.getX()/16, pos.getZ()/16, pos); //Add to list
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        warpPipeTree.addBlockToChunk(pos.getX()/16, pos.getZ()/16, pos); //Add to list

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
        if (state.hasBlockEntity() && !state.isOf(newState.getBlock())) {
            warpPipeTree.removeBlockFromChunk(pos.getX()/16, pos.getZ()/16, pos); //if destroyed, remove from list
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WarpPipeBE(pos, state);
    }

}
