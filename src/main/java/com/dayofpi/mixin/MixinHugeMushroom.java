package com.dayofpi.mixin;

import com.dayofpi.super_block_world.block.registry.BlockList;
import net.minecraft.block.BlockState;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(HugeMushroomFeature.class)
public abstract class MixinHugeMushroom {
    @Inject(at=@At("HEAD"), method = "getHeight(Ljava/util/Random;)I", cancellable = true)
    protected void getHeight(Random random, CallbackInfoReturnable<Integer> info) {
        int i = random.nextInt(3) + 4;
        if (random.nextInt(12) == 0) {
            i *= 2;
        } else if (random.nextInt(20) == 0) {
            i *= 3;
        }

        info.setReturnValue(i);
        info.cancel();
    }

    @Invoker("getCapSize")
    abstract int getCapSize(int i, int j, int capSize, int y);


    @Inject(at=@At("HEAD"), method = "canGenerate(Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;ILnet/minecraft/util/math/BlockPos$Mutable;Lnet/minecraft/world/gen/feature/HugeMushroomFeatureConfig;)Z", cancellable = true)
    protected void canGenerate(WorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, CallbackInfoReturnable<Boolean> info) {
        int i = pos.getY();
        if (i >= world.getBottomY() + 1 && i + height + 1 < world.getTopY()) {
            BlockState blockState = world.getBlockState(pos.down());
            if (!blockState.isIn(BlockTags.DIRT) && !blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
                info.setReturnValue(false);
            } else {
                for(int j = 0; j <= height; ++j) {
                    int k = this.getCapSize(-1, -1, config.foliageRadius, j);

                    for(int l = -k; l <= k; ++l) {
                        for(int m = -k; m <= k; ++m) {
                            BlockState blockState2 = world.getBlockState(mutable.set(pos, l, j, m));
                            if (!blockState2.isAir() && !blockState2.isIn(BlockTags.LEAVES) && !blockState.isOf(BlockList.VANILLATE)) {
                                info.setReturnValue(false);
                            }
                        }
                    }
                }
                info.setReturnValue(true);
            }
        } else {
            info.setReturnValue(false);
        }
    }
}
