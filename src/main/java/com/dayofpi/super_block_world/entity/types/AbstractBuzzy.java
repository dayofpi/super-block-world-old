package com.dayofpi.super_block_world.entity.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.misc.DamageSources;
import com.dayofpi.super_block_world.misc.SoundList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class AbstractBuzzy extends AbstractTroop {
    private static final TrackedData<Boolean> UPSIDE_DOWN;

    static {
        UPSIDE_DOWN = DataTracker.registerData(AbstractBuzzy.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    public AbstractBuzzy(EntityType<? extends AbstractBuzzy> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D);
    }

    public static boolean canSpawn(ServerWorldAccess world, BlockPos pos, Random random) {
        boolean bool1 = isFloorValid(world.getBlockState(pos.down()));
        boolean bool2 = isFloorValid(world.getBlockState(pos.up()));
        boolean spawnUnderground = AbstractTroop.isSpawnDark(world, pos, random) && !world.isSkyVisible(pos) && (bool1 || bool2);
        boolean spawnSurface = AbstractTroop.isSpawnDark(world, pos, random) && world.getBlockState(pos.down()).isOf(BlockList.TOADSTONE);
        return spawnSurface || spawnUnderground;
    }

    private static boolean isFloorValid(BlockState state) {
        return state.isOf(BlockList.VANILLATE) || state.isOf(BlockList.VANILLATE_CRUMBLE) || state.isOf(BlockList.TOPPED_VANILLATE);
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundList.BUZZY_BEETLE_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundList.BUZZY_BEETLE_DEATH;
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(2, new AvoidSunlightGoal(this));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.targetSelector.add(1, new SwimGoal(this));
    }

    @Override
    public void tickMovement() {
        boolean isBlockBelow = world.getBlockState(this.getBlockPos().down()).isSideSolidFullSquare(world, this.getBlockPos().down(), Direction.UP);
        boolean isPlayerBelow = world.getClosestEntity(PlayerEntity.class, TargetPredicate.createNonAttackable(), this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().expand(0, 40, 0).offset(0, -40, 0)) != null;
        /* This code only runs if there is a ceiling above
        If there is no player or block under it (since the block would keep it from falling anyways),
        its Y velocity is set to 0. If it does detect a player and there is no block below,
        it plays a sound and no longer runs the velocity command. */
        if (this.isOnCeiling(this.getBlockPos().up())) {
            if (!isPlayerBelow && !isBlockBelow) {
                this.setVelocity(this.getVelocity().x, 0, this.getVelocity().y);
            } else if (isPlayerBelow && !isBlockBelow)
                world.playSound(null, this.getBlockPos(), SoundList.BUZZY_BEETLE_DROP, SoundCategory.NEUTRAL, 1.0F, this.getSoundPitch());
        }

        super.tickMovement();
        if (this.isOnCeiling(this.getBlockPos().up())) {
            this.setUpsideDown(true);
        }
    }

    public boolean isOnCeiling(BlockPos pos) {
        if (!this.isBaby()) {
            return world.getBlockState(pos).isSideSolidFullSquare(world, pos, Direction.DOWN) && !this.hasVehicle();
        }  else return world.getStatesInBox(this.getBoundingBox().offset(0.0D, 0.0D, 0.5D)).anyMatch(BlockState::isOpaque);

    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source instanceof ProjectileDamageSource || source.isFallingBlock() || source.getAttacker() != null && source.getAttacker() instanceof AbstractBuzzy) {
            this.world.playSound(null, this.getBlockPos(), SoundList.BUZZY_BEETLE_BLOCK, SoundCategory.NEUTRAL, 1.0F, this.getSoundPitch());
            return false;
        } else {
            return super.damage(source, amount);
        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(UPSIDE_DOWN, false);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        if (entityData == null) {
            entityData = new AbstractBuzzy.BuzzyData(0.5F);
            if (world.getRandom().nextFloat() < 0.2F * difficulty.getClampedLocalDifficulty()) {
                ((AbstractBuzzy.BuzzyData)entityData).setEffect();
            }
        }

        if (entityData instanceof AbstractBuzzy.BuzzyData) {
            StatusEffect statusEffect = ((AbstractBuzzy.BuzzyData)entityData).effect;
            if (statusEffect != null) {
                this.addStatusEffect(new StatusEffectInstance(statusEffect, Integer.MAX_VALUE, 1));
            }
        }
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

        @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        if (this.isUpsideDown()) {
            if (!this.world.isClient()) {
                int i = this.computeFallDamage(fallDistance, damageMultiplier);
                if (i > 0) {
                    this.world.getOtherEntities(this, this.getBoundingBox().expand(3, 0, 3), EntityPredicates.EXCEPT_SPECTATOR).forEach((entity) -> entity.damage(DamageSources.mobDrop(this), i + 1));
                    this.world.playSound(null, this.getBlockPos(), SoundList.BUZZY_BEETLE_LAND, SoundCategory.NEUTRAL, 3.0F, this.getSoundPitch());
                    ((ServerWorld) this.world).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }
                if (fallDistance > 0.0F) {
                    this.setUpsideDown(false);
                }
            }
            return false;
        } else return super.handleFallDamage(fallDistance, damageMultiplier, damageSource);
    }

    public boolean isUpsideDown() {
        return this.dataTracker.get(UPSIDE_DOWN);
    }

    public void setUpsideDown(boolean upsideDown) {
        this.dataTracker.set(UPSIDE_DOWN, upsideDown);
    }

    public static class BuzzyData extends PassiveData implements EntityData {
        public StatusEffect effect;

        public BuzzyData(float babyChance) {
            super(babyChance);
        }

        public void setEffect() {
            this.effect = StatusEffects.SPEED;
        }
    }
}