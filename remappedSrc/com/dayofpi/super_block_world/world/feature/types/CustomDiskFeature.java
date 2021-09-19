package com.dayofpi.super_block_world.world.feature.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.class_6577;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Iterator;

public class CustomDiskFeature extends Feature<class_6577> {
   public CustomDiskFeature(Codec<class_6577> codec) {
      super(codec);
   }

   public boolean generate(FeatureContext<class_6577> context) {
      class_6577 diskFeatureConfig = context.getConfig();
      BlockPos blockPos = context.getOrigin();
      StructureWorldAccess structureWorldAccess = context.getWorld();
      boolean bl = false;
      int i = blockPos.getY();
      int j = i + diskFeatureConfig.comp_82();
      int k = i - diskFeatureConfig.comp_82() - 1;
      boolean bl2 = diskFeatureConfig.comp_80().getBlock() instanceof FallingBlock;
      int l = diskFeatureConfig.comp_81().get(context.getRandom());

      for(int m = blockPos.getX() - l; m <= blockPos.getX() + l; ++m) {
         for(int n = blockPos.getZ() - l; n <= blockPos.getZ() + l; ++n) {
            int o = m - blockPos.getX();
            int p = n - blockPos.getZ();
            if (o * o + p * p <= l * l) {
               boolean bl3 = false;

               for(int q = j; q >= k; --q) {
                  BlockPos blockPos2 = new BlockPos(m, q, n);
                  BlockState blockState = structureWorldAccess.getBlockState(blockPos2);
                  Block block = blockState.getBlock();
                  boolean bl4 = false;
                  if (q > k) {
                     Iterator var21 = diskFeatureConfig.comp_83().iterator();

                     while(var21.hasNext()) {
                        BlockState blockState2 = (BlockState)var21.next();
                        if (blockState2.isOf(block)) {
                           structureWorldAccess.setBlockState(blockPos2, diskFeatureConfig.comp_80(), Block.NOTIFY_LISTENERS);
                           this.markBlocksAboveForPostProcessing(structureWorldAccess, blockPos2);
                           bl = true;
                           bl4 = true;
                           break;
                        }
                     }
                  }

                  if (bl2 && bl3 && blockState.isAir()) {
                     BlockState blockState3 = BlockList.TOADSTONE.getDefaultState();
                     structureWorldAccess.setBlockState(new BlockPos(m, q + 1, n), blockState3, Block.NOTIFY_LISTENERS);
                  }

                  bl3 = bl4;
               }
            }
         }
      }

      return bl;
   }
}
