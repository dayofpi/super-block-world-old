package com.dayofpi.super_block_world.world.feature.types;

import com.mojang.serialization.Codec;
import net.minecraft.class_6577;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CustomUnderwaterDiskFeature extends CustomDiskFeature {
    public CustomUnderwaterDiskFeature(Codec<class_6577> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<class_6577> context) {
        return context.getWorld().getFluidState(context.getOrigin()).isIn(FluidTags.WATER) && super.generate(context);
    }
}
