package com.dayofpi.super_block_world.entity.types.mobs;

import com.dayofpi.super_block_world.TagList;
import com.dayofpi.super_block_world.item.registry.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@SuppressWarnings("deprecation")
public class RottenMushroomEntity extends HostileEntity {
    static final Predicate<ItemEntity> POWER_UP_FILTER;

    static {
        POWER_UP_FILTER = (item) -> !item.cannotPickup() && item.isAlive() && item.getStack().isOf(ItemList.ONE_UP);
    }

    public RottenMushroomEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static boolean canSpawn(ServerWorldAccess world, BlockPos pos, Random random) {
        boolean isDirt = world.getBlockState(pos.down()).isIn(BlockTags.DIRT);
        boolean isPoison = world.getFluidState(pos).isIn(TagList.POISON);
        return isDirt && isSpawnDark(world, pos, random) || isPoison && world.isSkyVisible(pos);
    }

    public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            int i = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
            return i <= random.nextInt(8);
        }
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

    public void tick() {
        super.tick();
        if (this.isAlive()) {
            List<ItemEntity> list = RottenMushroomEntity.this.world.getEntitiesByClass(ItemEntity.class, this.getBoundingBox(), POWER_UP_FILTER);
            if (!list.isEmpty()) {
                list.forEach(entity -> entity.setStack(new ItemStack(ItemList.POISON_MUSHROOM)));
                list.forEach(entity -> entity.playSound(SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, 1.0F, 1.0F));
            }
        }
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
