package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.SoundList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings("deprecation")
public class TrampolineBlock extends FallingBlock implements Waterloggable {
    protected static final BooleanProperty WATERLOGGED;
    public TrampolineBlock(Settings settings) {
        super(settings);
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0F, DamageSource.FALL);
        }

    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        this.bounce(entity);
    }

    protected void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        World world = entity.world;
        BlockPos blockPos = entity.getLandingPos();
        if (world.isClient && entity instanceof PlayerEntity clientPlayer) {
            if (((ClientPlayerEntity)clientPlayer).input.jumping) {
                ParticleUtil.spawnParticle(world, blockPos, ParticleTypes.WAX_ON, UniformIntProvider.create(2, 3));
                world.playSound(clientPlayer, blockPos, SoundList.POWERED_TRAMPOLINE, SoundCategory.BLOCKS, 1.0F, this.getSoundPitch(entity));
            } else world.playSound(clientPlayer, blockPos, SoundList.TRAMPOLINE, SoundCategory.BLOCKS, 1.5F, this.getSoundPitch(entity));
        } else if (!entity.isPlayer()) world.playSound(null, blockPos, SoundList.TRAMPOLINE, SoundCategory.BLOCKS, 1.0F, this.getSoundPitch(entity) * 1.2F);

        entity.setVelocity(vec3d.x, 0.9, vec3d.z);

    }

    public float getSoundPitch(Entity entity) {
        Random random = new Random();
        if (entity instanceof LivingEntity livingEntity && livingEntity.isBaby()) {
            return (random.nextFloat() - random.nextFloat()) * 0.2F + 1.5F;
        } else return (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return this.getDefaultState().with(WATERLOGGED, bl);
    }
}
