package com.dayofpi.super_block_world.world;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.block.types.MushroomBlock;
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
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class FeatureList {
    public static final ConfiguredFeature<TreeFeatureConfig, ?> AMANITA = Feature.TREE.configure((new TreeFeatureConfig.Builder(
            BlockStateProvider.of(States.AMANITA_LOG), new StraightTrunkPlacer(3, 2, 1),
            BlockStateProvider.of(States.AMANITA_LEAVES),
            BlockStateProvider.of(States.AMANITA_SAPLING), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().dirtProvider(BlockStateProvider.of(BlockList.TOADSTOOL_GRASS.getDefaultState())).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> AMANITA_FRUITS = Feature.TREE.configure((new TreeFeatureConfig.Builder(
            BlockStateProvider.of(States.AMANITA_LOG), new StraightTrunkPlacer(3, 2, 1),
            new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(States.AMANITA_LEAVES, 3).add(States.FRUITING_AMANITA_LEAVES, 1).build()),
            BlockStateProvider.of(States.AMANITA_SAPLING), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().dirtProvider(BlockStateProvider.of(BlockList.TOADSTOOL_GRASS.getDefaultState())).build());


    public static final ConfiguredFeature<?, ?> HUGE_RED_MUSHROOM_FLAT = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.RED_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_YELLOW_MUSHROOM_THIN = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.YELLOW_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_YELLOW_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.YELLOW_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_GREEN_MUSHROOM_THIN = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.GREEN_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_GREEN_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.GREEN_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_PINK_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.PINK_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_PURPLE_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.PURPLE_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_ORANGE_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.of(States.ORANGE_MUSHROOM_CAP), BlockStateProvider.of(States.MUSHROOM_STEM), 4));

    public static void registerFeatures() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "amanita"), AMANITA);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "amanita_fruits"), AMANITA_FRUITS);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_red_mushroom_flat"), HUGE_RED_MUSHROOM_FLAT);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_yellow_mushroom_thin"), HUGE_YELLOW_MUSHROOM_THIN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_yellow_mushroom"), HUGE_YELLOW_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_green_mushroom_thin"), HUGE_GREEN_MUSHROOM_THIN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_green_mushroom"), HUGE_GREEN_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_pink_mushroom"), HUGE_PINK_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_purple_mushroom"), HUGE_PURPLE_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_orange_mushroom"), HUGE_ORANGE_MUSHROOM);
        ReplacementFeatureList.replaceFeatures();
    }

    public static final class States {
        private static final BlockState RED_MUSHROOM_CAP = BlockList.RED_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState YELLOW_MUSHROOM_CAP = BlockList.YELLOW_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState GREEN_MUSHROOM_CAP = BlockList.GREEN_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState PINK_MUSHROOM_CAP = BlockList.PINK_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState PURPLE_MUSHROOM_CAP = BlockList.PURPLE_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState ORANGE_MUSHROOM_CAP = BlockList.ORANGE_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState MUSHROOM_STEM = BlockList.MUSHROOM_STEM.getDefaultState();
        private static final BlockState AMANITA_LEAVES = BlockList.AMANITA_LEAVES.getDefaultState();
        private static final BlockState FRUITING_AMANITA_LEAVES = BlockList.FRUITING_AMANITA_LEAVES.getDefaultState();
        private static final BlockState AMANITA_SAPLING = BlockList.AMANITA_SAPLING.getDefaultState();
        private static final BlockState AMANITA_LOG = BlockList.AMANITA_LOG.getDefaultState();
    }
}
