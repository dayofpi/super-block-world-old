package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.entity.types.AbstractShellEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
@SuppressWarnings("deprecation")
public abstract class ReactiveBlock extends Block {
    public ReactiveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos blockPos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(blockPos)) {
            this.activate(world.getBlockState(blockPos), world, blockPos);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0.0D, 0.5D, 0.0D, 16.0D, 16.5D, 16.0D);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos blockPos, PlayerEntity player) {
        this.activate(state, world, blockPos);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos blockPos, Entity entity) {
        boolean bool1 = entity.getY() < blockPos.getY();
        boolean bool2 = entity instanceof AbstractShellEntity && entity.getY() == blockPos.getY();
        if (bool1 || bool2) {
            this.activate(state, world, blockPos);
        }
    }

    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        this.activate(state, world, hit.getBlockPos());
    }

    public void activate(BlockState state, World world, BlockPos blockPos) {}
}
