package com.dayofpi.super_block_world.entity.types.mobs;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Random;

@SuppressWarnings("deprecation")
public class RottenMushroomEntity extends HostileEntity {
    public RottenMushroomEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static boolean canSpawn(ServerWorldAccess world, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.DIRT) && isSpawnDark(world, pos, random);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.5F;
    }

    protected void initGoals() {
        this.goalSelector.add(3, new AvoidSunlightGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.targetSelector.add(2, new RevengeGoal(this));
    }

    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target)) {
            if (target instanceof LivingEntity) {
                int i = 0;
                if (this.world.getDifficulty() == Difficulty.NORMAL) {
                    i = 7;
                } else if (this.world.getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }
                if (i > 0) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, i * 20, 0));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return 0.5F - world.getBrightness(pos);
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_ZOMBIE_STEP;
    }

}
