package com.dayofpi.super_block_world.block.types;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class AmethystOreBlock extends Block {
    public AmethystOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            double d = (double) pos.getX() + random.nextDouble() * 2;
            double e = (double) pos.getY() + random.nextDouble() * 2;
            double f = (double) pos.getZ() + random.nextDouble() * 2;
            world.addParticle(ParticleTypes.GLOW, d, e, f , 0.0D, 0.0D, 0.0D);
        }
    }
}
