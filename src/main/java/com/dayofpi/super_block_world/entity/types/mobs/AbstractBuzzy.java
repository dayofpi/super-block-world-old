package com.dayofpi.super_block_world.entity.types.mobs;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.misc.ModDamageSource;
import com.dayofpi.super_block_world.misc.SoundList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Random;
import java.util.UUID;

public abstract class AbstractBuzzy extends AbstractCeilingTroop {
    private static final TrackedData<Boolean> HIDING;
    private static final EntityAttributeModifier COVERED_ARMOR_BONUS;

    static {
        HIDING = DataTracker.registerData(AbstractBuzzy.class, TrackedDataHandlerRegistry.BOOLEAN);
        COVERED_ARMOR_BONUS = new EntityAttributeModifier(UUID.randomUUID(), "Covered armor bonus", 10.0D, EntityAttributeModifier.Operation.ADDITION);
    }

    public AbstractBuzzy(EntityType<? extends AbstractBuzzy> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    public void initGoals() {
        this.goalSelector.add(4, new EscapeSunlightGoal(this, 1.0D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.7D));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.targetSelector.add(1, new SwimGoal(this));
    }

    protected void updateGoalControls() {
        if (this.isHiding()) {
            this.goalSelector.setControlEnabled(Goal.Control.MOVE, false);
        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HIDING, false);
    }

    public static boolean canSpawn(ServerWorldAccess world, BlockPos pos, Random random) {
        boolean floorValid = checkValidBlock(world.getBlockState(pos.down()));
        boolean ceilingValid = checkValidBlock(world.getBlockState(pos.up()));
        boolean spawnUnderground = AbstractTroop.isSpawnDark(world, pos, random) && !world.isSkyVisible(pos) && (floorValid || ceilingValid);
        boolean spawnSurface = AbstractTroop.isSpawnDark(world, pos, random) && world.getBlockState(pos.down()).isOf(BlockList.TOADSTONE);
        return spawnSurface || spawnUnderground;
    }

    static boolean checkValidBlock(BlockState state) {
        return state.isOf(BlockList.VANILLATE) || state.isOf(BlockList.GLOOMSTONE);
    }
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundList.BUZZY_BEETLE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundList.BUZZY_BEETLE_DEATH;
    }

    private SoundEvent getDropSound() {
        return SoundList.BUZZY_BEETLE_DROP;
    }

    protected SoundEvent getLandingSound() {
        return SoundList.BUZZY_BEETLE_LAND;
    }

    public void doLandingEffects(float fallDistance, float damageMultiplier) {
        int i = this.computeFallDamage(fallDistance, damageMultiplier);
        if (i > 0) {
            this.world.getOtherEntities(this, this.getBoundingBox().expand(3, 0, 3), EntityPredicates.EXCEPT_SPECTATOR).forEach((entity) -> entity.damage(ModDamageSource.mobDrop(this), i + 1));
            this.playSound(this.getLandingSound(), this.getSoundVolume(), this.getSoundPitch());
            ((ServerWorld) this.world).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
        }
        if (fallDistance > 0.0F) { this.setUpsideDown(false); }
    }

    private SoundEvent getBlockingSound() {
        return SoundList.BUZZY_BEETLE_BLOCK;
    }

    public boolean isHiding() {
        return this.dataTracker.get(HIDING);
    }

    public void setHiding(boolean hiding) {
        this.dataTracker.set(HIDING, hiding);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        EntityAttributeInstance entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);

        if (this.isHiding()) {
            if (!entityAttributeInstance.hasModifier(COVERED_ARMOR_BONUS)) {
                entityAttributeInstance.addTemporaryModifier(COVERED_ARMOR_BONUS);
            } else if (entityAttributeInstance.hasModifier(COVERED_ARMOR_BONUS)) {
                entityAttributeInstance.removeModifier(COVERED_ARMOR_BONUS);
            }
        }

        BlockPos blockPos = this.getBlockPos();
        BlockPos floor = this.getBlockPos().down();

        boolean blockBelow = world.getBlockState(floor).isSideSolidFullSquare(world, floor, Direction.UP);
        boolean playerBelow = world.getClosestEntity(PlayerEntity.class, TargetPredicate.createNonAttackable(), this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().expand(0, 40, 0).offset(0, -40, 0)) != null;
        /* This code only runs if there is a ceiling above
        If there is no player or block under it (since the block would keep it from falling anyways),
        its Y velocity is set to 0. If it does detect a player and there is no block below,
        it plays a sound and no longer runs the velocity command. */
        if (this.isOnCeiling(blockPos)) {
            if (!playerBelow && !blockBelow) {
                this.setVelocity(this.getVelocity().multiply(1.0F, 0.0F, 1.0F));
            } else if (playerBelow && !blockBelow)
                this.playSound(this.getDropSound(), 1.0F, this.getSoundPitch());
        }

        if (this.isOnCeiling(blockPos)) {
            this.setUpsideDown(true);
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source instanceof ProjectileDamageSource || source.isFallingBlock() || source instanceof ModDamageSource && ((ModDamageSource)source).isFallingMob()) {
            this.playSound(this.getBlockingSound(), this.getSoundVolume(), this.getSoundPitch());
            return false;
        } else if (source instanceof ModDamageSource && ((ModDamageSource)source).isStomp()) {
            this.setHiding(true);
            return super.damage(source, amount);
        } else {
            return super.damage(source, amount);
        }
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        if (this.isUpsideDown()) {
            if (!this.world.isClient()) {
                this.doLandingEffects(fallDistance, damageMultiplier);
            }
            return false;
        }
        else return super.handleFallDamage(fallDistance, damageMultiplier, damageSource);
    }
}