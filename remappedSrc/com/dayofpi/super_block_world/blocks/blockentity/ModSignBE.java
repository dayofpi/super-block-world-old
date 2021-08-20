package com.dayofpi.super_block_world.block.block_entity;

import com.dayofpi.super_block_world.block.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModSignBE extends SignBlockEntity {

    public ModSignBE(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntities.MOD_SIGN;
    }
}
