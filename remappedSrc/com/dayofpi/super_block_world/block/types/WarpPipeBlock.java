package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.block_entity.WarpPipeBE;
import com.dayofpi.super_block_world.block.block_entity.WarpPipeTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WarpPipeBlock extends WarpPipeBodyBlock implements BlockEntityProvider {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public static final WarpPipeTree warpPipeTree = new WarpPipeTree();

    public WarpPipeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onBlockAdded(state, world, pos, oldState, notify);
        warpPipeTree.addBlockToChunk(pos.getX()/16, pos.getZ()/16, pos); //Add to list
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
