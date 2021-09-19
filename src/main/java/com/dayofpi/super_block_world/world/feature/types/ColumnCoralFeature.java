package com.dayofpi.super_block_world.world.feature.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class ColumnCoralFeature extends Feature<DefaultFeatureConfig> {
   public ColumnCoralFeature(Codec<DefaultFeatureConfig> codec) {
      super(codec);
   }

   public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
      int i = 0;
      StructureWorldAccess structureWorldAccess = context.getWorld();
      BlockPos blockPos = context.getOrigin();
      Random random = context.getRandom();
      int j = structureWorldAccess.getTopY(Heightmap.Type.OCEAN_FLOOR, blockPos.getX(), blockPos.getZ());
      BlockPos blockPos2 = new BlockPos(blockPos.getX(), j, blockPos.getZ());
      if (structureWorldAccess.getBlockState(blockPos2).isOf(Blocks.WATER)) {
         BlockState blockState = BlockList.STRAWBERRY_CORAL.getDefaultState();
         BlockState blockState2 = BlockList.STRAWBERRY_CORAL.getDefaultState();
         int k = 1 + random.nextInt(10);

         for(int l = 0; l <= k; ++l) {
            if (structureWorldAccess.getBlockState(blockPos2).isOf(Blocks.WATER) && structureWorldAccess.getBlockState(blockPos2.up()).isOf(Blocks.WATER) && blockState2.canPlaceAt(structureWorldAccess, blockPos2)) {
               if (l == k) {
                  structureWorldAccess.setBlockState(blockPos2, blockState, Block.NOTIFY_LISTENERS);
                  ++i;
               } else {
                  structureWorldAccess.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
               }
            } else if (l > 0) {
               BlockPos blockPos3 = blockPos2.down();
               if (blockState.canPlaceAt(structureWorldAccess, blockPos3)) {
                  structureWorldAccess.setBlockState(blockPos3, blockState, Block.NOTIFY_LISTENERS);
                  ++i;
               }
               break;
            }

            blockPos2 = blockPos2.up();
         }
      }

      return i > 0;
   }
}
