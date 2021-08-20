package com.dayofpi.super_block_world.world.feature.generators;

import com.dayofpi.mixin.BlockPlacerTypeMixin;
import com.dayofpi.super_block_world.block.types.HorsetailBlock;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.placer.BlockPlacer;
import net.minecraft.world.gen.placer.BlockPlacerType;

import java.util.Random;

public class HorsetailBlockPlacer extends BlockPlacer {
    public static final HorsetailBlockPlacer INSTANCE = new HorsetailBlockPlacer();

    public static final Codec<HorsetailBlockPlacer> CODEC = Codec.unit(() -> INSTANCE);


    protected BlockPlacerType<?> getType() {
        return BlockPlacerTypeMixin.HORSETAIL_PLACER;
    }

    public void generate(WorldAccess world, BlockPos pos, BlockState state, Random random) {
        HorsetailBlock.placeAt(world, state, pos, 2);
    }
}
