package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.common.blocks.MushroomCap;
import com.dayofpi.super_block_world.registry.blocks.PlantRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class FeatureRegistry {
    public static final ConfiguredFeature<TreeFeatureConfig, ?> AMANITA = Feature.TREE.configure((new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(States.AMANITA_LOG), new StraightTrunkPlacer(3, 2, 1),
            new SimpleBlockStateProvider(States.AMANITA_LEAVES),
            new SimpleBlockStateProvider(States.AMANITA_SAPLING), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().dirtProvider(new SimpleBlockStateProvider(BlockRegistry.TOADSTOOL_GRASS.getDefaultState())).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> AMANITA_FRUITS = Feature.TREE.configure((new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(States.AMANITA_LOG), new StraightTrunkPlacer(3, 2, 1),
            new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(States.AMANITA_LEAVES, 3).add(States.FRUITING_AMANITA_LEAVES, 1).build()),
            new SimpleBlockStateProvider(States.AMANITA_SAPLING), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().dirtProvider(new SimpleBlockStateProvider(BlockRegistry.TOADSTOOL_GRASS.getDefaultState())).build());


    public static final ConfiguredFeature<?, ?> HUGE_YELLOW_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.YELLOW_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_YELLOW_MUSHROOM_WIDE = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.YELLOW_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_GREEN_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.GREEN_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_GREEN_MUSHROOM_WIDE = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.GREEN_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 3));

    public static void registerFeatures() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "amanita"), AMANITA);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "amanita_fruits"), AMANITA_FRUITS);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_yellow_mushroom"), HUGE_YELLOW_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_yellow_mushroom_wide"), HUGE_YELLOW_MUSHROOM_WIDE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_green_mushroom"), HUGE_GREEN_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_green_mushroom_wide"), HUGE_GREEN_MUSHROOM_WIDE);
    }

    public static final class States {
        private static final BlockState YELLOW_MUSHROOM_CAP = BlockRegistry.YELLOW_MUSHROOM_CAP.getDefaultState().with(MushroomCap.DOWN, false);
        private static final BlockState GREEN_MUSHROOM_CAP = BlockRegistry.GREEN_MUSHROOM_CAP.getDefaultState().with(MushroomCap.DOWN, false);
        private static final BlockState MUSHROOM_STEM = BlockRegistry.MUSHROOM_STEM.getDefaultState();
        private static final BlockState AMANITA_LEAVES = BlockRegistry.AMANITA_LEAVES.getDefaultState();
        private static final BlockState FRUITING_AMANITA_LEAVES = BlockRegistry.FRUITING_AMANITA_LEAVES.getDefaultState();
        private static final BlockState AMANITA_SAPLING = PlantRegistry.AMANITA_SAPLING.getDefaultState();
        private static final BlockState AMANITA_LOG = BlockRegistry.AMANITA_LOG.getDefaultState();
    }
}
