package com.dayofpi.mixin.mushroom_revamp;

import com.dayofpi.super_block_world.world.ReplacementFeatureList;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DefaultBiomeCreator.class)
public class MixinBiomeCreator {

    @Invoker("getSkyColor")
    static int invokeGetSkyColor(float temperature) {
        throw new AssertionError();
    }

    // Replace natural huge mushrooms with the mod ones
    @Inject(at = @At("HEAD"), method = "createDarkForest(Z)Lnet/minecraft/world/biome/Biome;", cancellable = true)
    public static void createDarkForest(boolean red, CallbackInfoReturnable<Biome> info) {
        SpawnSettings.Builder $$1 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals($$1);
        DefaultBiomeFeatures.addBatsAndMonsters($$1);
        net.minecraft.world.biome.GenerationSettings.Builder $$2 = (new net.minecraft.world.biome.GenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.addLandCarvers($$2);
        DefaultBiomeFeatures.addDefaultLakes($$2);
        DefaultBiomeFeatures.addAmethystGeodes($$2);
        DefaultBiomeFeatures.addDungeons($$2);
        $$2.feature(GenerationStep.Feature.VEGETAL_DECORATION, red ? ReplacementFeatureList.DARK_FOREST_VEGETATION_RED : ReplacementFeatureList.DARK_FOREST_VEGETATION_BROWN);
        DefaultBiomeFeatures.addForestFlowers($$2);
        DefaultBiomeFeatures.addMineables($$2);
        DefaultBiomeFeatures.addDefaultOres($$2);
        DefaultBiomeFeatures.addDefaultDisks($$2);
        DefaultBiomeFeatures.addDefaultFlowers($$2);
        DefaultBiomeFeatures.addForestGrass($$2);
        DefaultBiomeFeatures.addDefaultMushrooms($$2);
        DefaultBiomeFeatures.addDefaultVegetation($$2);
        DefaultBiomeFeatures.addSprings($$2);
        DefaultBiomeFeatures.addFrozenTopLayer($$2);
        info.setReturnValue((new net.minecraft.world.biome.Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST).temperature(0.7F).downfall(0.8F).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(invokeGetSkyColor(0.7F)).grassColorModifier(BiomeEffects.GrassColorModifier.DARK_FOREST).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings($$1.build()).generationSettings($$2.build()).build());
        info.cancel();
    }

    @Inject(at = @At("HEAD"), method = "createMushroomFields()Lnet/minecraft/world/biome/Biome;", cancellable = true)
    private static void createMushroomFields(CallbackInfoReturnable<Biome> info) {
        SpawnSettings.Builder $$0 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addMushroomMobs($$0);
        net.minecraft.world.biome.GenerationSettings.Builder $$1 = (new net.minecraft.world.biome.GenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.MYCELIUM);
        DefaultBiomeFeatures.addLandCarvers($$1);
        DefaultBiomeFeatures.addDefaultLakes($$1);
        DefaultBiomeFeatures.addAmethystGeodes($$1);
        DefaultBiomeFeatures.addDungeons($$1);
        DefaultBiomeFeatures.addMineables($$1);
        DefaultBiomeFeatures.addDefaultOres($$1);
        DefaultBiomeFeatures.addDefaultDisks($$1);
        DefaultBiomeFeatures.addMushroomFieldsFeatures($$1);
        DefaultBiomeFeatures.addDefaultMushrooms($$1);
        DefaultBiomeFeatures.addDefaultVegetation($$1);
        DefaultBiomeFeatures.addSprings($$1);
        DefaultBiomeFeatures.addFrozenTopLayer($$1);
        info.setReturnValue((new net.minecraft.world.biome.Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.MUSHROOM).temperature(0.9F).downfall(1.0F).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(invokeGetSkyColor(0.9F)).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings($$0.build()).generationSettings($$1.build()).build());
    }
}