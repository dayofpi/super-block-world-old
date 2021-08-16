package com.dayofpi.super_block_world.blocks.types.template;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModFallingBlock extends FallingBlock {
    public ModFallingBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return 12636090; // Fix this
    }

}
