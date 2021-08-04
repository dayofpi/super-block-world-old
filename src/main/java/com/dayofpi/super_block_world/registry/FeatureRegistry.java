package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.common.blocks.MushroomCap;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class FeatureRegistry {
    public static final ConfiguredFeature<?, ?> HUGE_YELLOW_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.YELLOW_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_YELLOW_MUSHROOM_WIDE = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.YELLOW_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 3));
    public static final ConfiguredFeature<?, ?> HUGE_GREEN_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.GREEN_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 2));
    public static final ConfiguredFeature<?, ?> HUGE_GREEN_MUSHROOM_WIDE = Feature.HUGE_BROWN_MUSHROOM.configure(new HugeMushroomFeatureConfig(new SimpleBlockStateProvider(States.GREEN_MUSHROOM_CAP), new SimpleBlockStateProvider(States.MUSHROOM_STEM), 3));

    public static void registerFeatures() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_yellow_mushroom"), HUGE_YELLOW_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_yellow_mushroom_wide"), HUGE_YELLOW_MUSHROOM_WIDE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_green_mushroom"), HUGE_GREEN_MUSHROOM);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.MOD_ID, "huge_green_mushroom_wide"), HUGE_GREEN_MUSHROOM_WIDE);
    }

    public static final class States {
        private static final BlockState YELLOW_MUSHROOM_CAP = BlockRegistry.YELLOW_MUSHROOM_CAP.getDefaultState().with(MushroomCap.DOWN, false);
        private static final BlockState GREEN_MUSHROOM_CAP = BlockRegistry.GREEN_MUSHROOM_CAP.getDefaultState().with(MushroomCap.DOWN, false);
        private static final BlockState MUSHROOM_STEM = BlockRegistry.MUSHROOM_STEM.getDefaultState();
    }
}
