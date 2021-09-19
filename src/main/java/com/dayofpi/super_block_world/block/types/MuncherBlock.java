package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.misc.ModDamageSource;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class MuncherBlock extends PlantBlock {
    public MuncherBlock(Settings $$0) {
        super($$0);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (!world.isClient) {
                entity.damage(ModDamageSource.MUNCHER, 2.0F);
            }

        }
    }
}
