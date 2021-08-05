package com.dayofpi.super_block_world.worldgen;

import com.dayofpi.super_block_world.registry.FeatureRegistry;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AmanitaGenerator extends SaplingGenerator {
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return random.nextInt(6) == 2 ? FeatureRegistry.AMANITA_FRUITS : FeatureRegistry.AMANITA;
    }
}
