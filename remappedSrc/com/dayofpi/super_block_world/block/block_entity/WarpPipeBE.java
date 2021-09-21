package com.dayofpi.super_block_world.block.block_entity;

import com.dayofpi.super_block_world.block.registry.BlockEntityList;
import com.dayofpi.super_block_world.block.types.WarpPipeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class WarpPipeBE extends BlockEntity {
    public WarpPipeBE(BlockPos pos, BlockState state) {
        super(BlockEntityList.WARP_PIPE, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbtCompound) {
        super.readNbt(nbtCompound);
        WarpPipeBlock.warpPipeTree.addBlockToChunk(pos.getX()/16, pos.getZ()/16, pos);
    }
}
