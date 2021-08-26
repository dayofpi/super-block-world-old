package com.dayofpi.super_block_world.world.feature.types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public class CustomMineshaftFeatureConfig implements FeatureConfig {
    public static final Codec<CustomMineshaftFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((mineshaftFeatureConfig) -> {
            return mineshaftFeatureConfig.probability;
        }), CustomMineshaftFeature.Type.CODEC.fieldOf("type").forGetter((mineshaftFeatureConfig) -> {
            return mineshaftFeatureConfig.type;
        })).apply(instance, CustomMineshaftFeatureConfig::new);
    });
    public final float probability;
    public final CustomMineshaftFeature.Type type;

    public CustomMineshaftFeatureConfig(float probability, CustomMineshaftFeature.Type type) {
        this.probability = probability;
        this.type = type;
    }
}