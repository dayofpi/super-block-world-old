package com.dayofpi.super_block_world.misc.worldgen.features;

import com.dayofpi.super_block_world.misc.worldgen.FeatureReg;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AmanitaTree extends SaplingGenerator {
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return random.nextInt(6) == 2 ? FeatureReg.AMANITA_FRUITS : FeatureReg.AMANITA;
    }
}
