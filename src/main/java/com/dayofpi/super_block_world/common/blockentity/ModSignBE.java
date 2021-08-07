package com.dayofpi.super_block_world.common.blockentity;

import com.dayofpi.super_block_world.registry.ModBlockEntities;
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
        return ModBlockEntities.MOD_SIGN;
    }
}
