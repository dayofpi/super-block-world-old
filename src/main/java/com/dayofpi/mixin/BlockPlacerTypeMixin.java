package com.dayofpi.mixin;

import com.dayofpi.super_block_world.world.feature.generators.HorsetailBlockPlacer;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.placer.BlockPlacer;
import net.minecraft.world.gen.placer.BlockPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockPlacerType.class)
public class BlockPlacerTypeMixin {
    @Invoker("register")
    private static <P extends BlockPlacer> BlockPlacerType<P> register(String id, Codec<P> codec) {
        throw new AssertionError();
    }

    static {
        HorsetailBlockPlacer.HORSETAIL_PLACER = register("horsetail_placer", HorsetailBlockPlacer.CODEC);
    }
}
