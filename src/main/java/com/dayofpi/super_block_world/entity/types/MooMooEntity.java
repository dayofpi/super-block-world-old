package com.dayofpi.super_block_world.entity.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class MooMooEntity extends CowEntity {
    private static final Ingredient BREEDING_INGREDIENT;
    private static final TrackedData<Boolean> LYING;


    static {
        BREEDING_INGREDIENT = Ingredient.ofItems(Items.WHEAT, BlockList.HORSETAIL);
        LYING = DataTracker.registerData(MooMooEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    public MooMooEntity(EntityType<? extends MooMooEntity> entityType, World world) {
        super(entityType, world);
    }

    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(BlockList.TOADSTOOL_GRASS) ? 10.0F : world.getBrightness(pos) - 0.5F;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.2)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224D);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.0D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, BREEDING_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(5, new MooMooWanderGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(6, new LookAtEntityGoal(this, AnimalEntity.class, 3.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LYING, false);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.isLying()) {
            if (this.touchingWater || !this.isOnGround() || this.isNavigating() || (random.nextInt(100000) == 0))
                this.setLying(false);
        } else if (random.nextInt(10000) == 0 && this.getVelocity().x == 0 && this.getVelocity().z == 0) {
            this.setLying(true);
        }
    }

    public boolean isLying() {
        return this.dataTracker.get(LYING);
    }

    public void setLying(boolean lying) {
        this.dataTracker.set(LYING, lying);
    }


    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    public MooMooEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityList.MOO_MOO.create(serverWorld);
    }

    public static boolean canSpawn(WorldAccess world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(BlockList.TOADSTOOL_GRASS) && world.isSkyVisible(pos) && world.getBaseLightLevel(pos, 0) > 8;
    }

    public float getSoundPitch() {
        return super.getSoundPitch() - 0.1F;
    }

    static class MooMooWanderGoal extends WanderAroundFarGoal {
        private final MooMooEntity mooMooEntity;

        public MooMooWanderGoal(MooMooEntity pathAwareEntity, double d) {
            super(pathAwareEntity, d);
            this.mooMooEntity = pathAwareEntity;
        }

        public boolean canStart() {
            if (mooMooEntity.isLying()) {
                return false;
            } else return super.canStart();
        }

        public boolean shouldContinue() {
            if (mooMooEntity.isLying()) {
                return false;
            } else return super.shouldContinue();
        }
    }
}
