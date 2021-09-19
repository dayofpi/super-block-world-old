package com.dayofpi.super_block_world.world;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.block.types.MushroomBlock;
import com.dayofpi.super_block_world.world.feature.types.ColumnCoralFeature;
import com.dayofpi.super_block_world.world.feature.types.CustomLakeFeature;
import com.dayofpi.super_block_world.world.feature.types.CustomUnderwaterDiskFeature;
import com.dayofpi.super_block_world.world.feature.types.SuperRandomPatchFeature;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.class_6577;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ReplacementFeatureList {
    public static final Feature<SingleStateFeatureConfig> LAKE = new CustomLakeFeature(SingleStateFeatureConfig.CODEC);
    public static final Feature<class_6577> DISK = new CustomUnderwaterDiskFeature(class_6577.field_34698);
    public static final Feature<DefaultFeatureConfig> COLUMN_CORAL = new ColumnCoralFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<RandomPatchFeatureConfig> RANDOM_PATCH = new SuperRandomPatchFeature(RandomPatchFeatureConfig.CODEC);

    public static final ConfiguredFeature<?, ?> HUGE_BROWN_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.method_38433(States.BROWN_MUSHROOM_CAP), BlockStateProvider.method_38433(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_RED_MUSHROOM = Feature.HUGE_RED_MUSHROOM.configure(new HugeMushroomFeatureConfig(BlockStateProvider.method_38433(States.RED_MUSHROOM_CAP), BlockStateProvider.method_38433(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_BROWN = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(HUGE_BROWN_MUSHROOM.withChance(0.025F), HUGE_RED_MUSHROOM.withChance(0.05F), ConfiguredFeatures.DARK_OAK.withChance(0.6666667F), ConfiguredFeatures.BIRCH.withChance(0.2F), ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.OAK)).decorate(Heightmaps.DARK_OAK_TREE_HEIGHTMAP);
    public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_RED = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(HUGE_RED_MUSHROOM.withChance(0.025F), HUGE_BROWN_MUSHROOM.withChance(0.05F), ConfiguredFeatures.DARK_OAK.withChance(0.6666667F), ConfiguredFeatures.BIRCH.withChance(0.2F), ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.OAK)).decorate(Heightmaps.DARK_OAK_TREE_HEIGHTMAP);
    public static final ConfiguredFeature<?, ?> MUSHROOM_FIELD_VEGETATION = Feature.RANDOM_BOOLEAN_SELECTOR.configure(new RandomBooleanFeatureConfig(() -> HUGE_RED_MUSHROOM, () -> HUGE_BROWN_MUSHROOM)).decorate(Heightmaps.SQUARE_HEIGHTMAP);

    public static void addMushroomFieldsFeatures(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, MUSHROOM_FIELD_VEGETATION);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_TAIGA);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_TAIGA);
    }

    public static void replaceFeatures() {
        Registry.register(Registry.FEATURE, new Identifier(Main.MOD_ID, "lake"), LAKE);
        Registry.register(Registry.FEATURE, new Identifier(Main.MOD_ID, "disk"), DISK);
        Registry.register(Registry.FEATURE, new Identifier(Main.MOD_ID, "column_coral"), COLUMN_CORAL);
        Registry.register(Registry.FEATURE, new Identifier(Main.MOD_ID, "random_patch"), RANDOM_PATCH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_brown_mushroom"), HUGE_BROWN_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_red_mushroom"), HUGE_RED_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "dark_forest_vegetation_brown"), DARK_FOREST_VEGETATION_BROWN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "dark_forest_vegetation_red"), DARK_FOREST_VEGETATION_RED);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "mushroom_field_vegetation"), MUSHROOM_FIELD_VEGETATION);
    }

    public static final class States {
        private static final BlockState BROWN_MUSHROOM_CAP = BlockList.BROWN_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState RED_MUSHROOM_CAP = BlockList.RED_MUSHROOM_CAP.getDefaultState().with(MushroomBlock.DOWN, false);
        private static final BlockState MUSHROOM_STEM = BlockList.MUSHROOM_STEM.getDefaultState();
    }

    public static final class Heightmaps {
        public static final ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
        public static final ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP_OCEAN_FLOOR = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR));
        public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP = HEIGHTMAP.spreadHorizontally();
        public static final ConfiguredDecorator<?> HEIGHTMAP_OCEAN_FLOOR_NO_WATER = HEIGHTMAP_OCEAN_FLOOR.decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(0)));
        public static final ConfiguredDecorator<?> DARK_OAK_TREE_HEIGHTMAP = HEIGHTMAP_OCEAN_FLOOR_NO_WATER.decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));
    }
}
