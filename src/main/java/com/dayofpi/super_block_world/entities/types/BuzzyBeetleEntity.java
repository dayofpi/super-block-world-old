package com.dayofpi.super_block_world.entities.types;

import com.dayofpi.super_block_world.blocks.BlockTypes;
import com.dayofpi.super_block_world.entities.EntityTypes;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BuzzyBeetleEntity extends AbstractBuzzyBeetle {
    public BuzzyBeetleEntity(EntityType<? extends BuzzyBeetleEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, Ingredient.ofItems(BlockTypes.GREEN_MUSHROOM), false));
        super.initGoals();
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(BlockTypes.GREEN_MUSHROOM.asItem());
    }

    @Override
    public double getMountedHeightOffset() {
        double d = 0.4D;
        if (this.isUpsideDown()) {
            d = -2D;
        }
        return super.getMountedHeightOffset() + d;
    }

    @Override
    public BuzzyBeetleEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        if (passiveEntity != null) {
            passiveEntity.setPersistent();
        }
        return EntityTypes.BUZZY_BEETLE.create(serverWorld);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        if (this.isBaby()) {
            return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        } else {
            if (this.random.nextInt(20) == 0 && !this.isOnCeiling(this.getBlockPos().up())) {
                BuzzyBeetleEntity passiveEntity = EntityTypes.BUZZY_BEETLE.create(world.toServerWorld());
                if (passiveEntity != null) {
                    passiveEntity.setBreedingAge(-24000);
                    entityData = this.initializeRider(world, difficulty, passiveEntity);
                }
            } else {
                entityData = new PassiveEntity.PassiveData(0.5F);
            }
        }
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    private EntityData initializeRider(ServerWorldAccess world, LocalDifficulty difficulty, MobEntity rider) {
        rider.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
        rider.initialize(world, difficulty, SpawnReason.JOCKEY, null, null);
        rider.startRiding(this, true);
        return new PassiveEntity.PassiveData(0.0F);
    }
}
