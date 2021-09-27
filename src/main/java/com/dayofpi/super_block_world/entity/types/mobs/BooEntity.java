package com.dayofpi.super_block_world.entity.types.mobs;

import com.dayofpi.super_block_world.SoundList;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class BooEntity extends AbstractGhost implements Flutterer {
    private static final TrackedData<Boolean> HIDING;
    private static final TrackedData<Boolean> DABBING;

    public BooEntity(EntityType<? extends BooEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, true);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return EnemyEntity.createEnemyAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.65D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new AvoidSunlightGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new BooWanderAroundGoal());
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    public boolean isDabbing() {
        return this.dataTracker.get(DABBING);
    }
    public void setDabbing(boolean dabbing) {
        this.dataTracker.set(DABBING, dabbing);
    }

    public void setHiding(boolean pretending) {
        this.dataTracker.set(HIDING, pretending);
    }
    public boolean isHiding() {
        return this.dataTracker.get(HIDING);
    }

    protected boolean shouldSwimInFluids() {
        return false;
    }
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.5F;
    }
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HIDING, false);
        this.dataTracker.startTracking(DABBING, false);
    }

    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setDabbing(world.getRandom().nextDouble() < 0.02D);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Dab", this.isDabbing());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setDabbing(nbt.getBoolean("Dab"));
    }

    public boolean tryAttack(Entity target) {
    this.playSound(SoundList.BOO_LAUGH, 1.0F, getSoundPitch());
    return super.tryAttack(target);
    }

    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
    }

    public SoundEvent getAmbientSound() {
        return this.isHiding() ? SoundList.BOO_SHY : SoundList.BOO_AMBIENT;
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundList.BOO_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundList.BOO_DEATH;
    }

    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    protected void updateGoalControls() {
        if (this.isHiding()) {
            this.goalSelector.setControlEnabled(Goal.Control.LOOK, false);
        } else super.updateGoalControls();
    }

    public void tickMovement() {
        super.tickMovement();
        LivingEntity target = this.getTarget();
        if (this.isAlive()) {
            if (((target instanceof PlayerEntity))) {
                this.setHiding(this.isPlayerStaring((PlayerEntity) target));
            }
        }
    }

    boolean isPlayerStaring(PlayerEntity player) {
        final float f = world.getLightLevel(LightType.BLOCK, this.getBlockPos());
        ItemStack itemStack = player.getInventory().armor.get(3);
        if (itemStack.isOf(Blocks.CARVED_PUMPKIN.asItem()) || f > lightLimit) {
            return false;
        } else {
            Vec3d vec3d = player.getRotationVec(1.0F).normalize();
            Vec3d vec3d2 = new Vec3d(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(), this.getZ() - player.getZ());
            double d = vec3d2.length();
            vec3d2 = vec3d2.normalize();
            double e = vec3d.dotProduct(vec3d2);
            return e > 1.0D - 0.055D / d && player.canSee(this);
        }
    }

    static {
        HIDING = DataTracker.registerData(BooEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        DABBING = DataTracker.registerData(BooEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    class BooWanderAroundGoal extends Goal {
        BooWanderAroundGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            return BooEntity.this.navigation.isIdle() && BooEntity.this.random.nextInt(10) == 0;
        }

        public boolean shouldContinue() {
            return BooEntity.this.navigation.isFollowingPath();
        }
        public void start() {
            Vec3d vec3d = this.getRandomLocation();
            if (vec3d != null) {
                BooEntity.this.navigation.startMovingAlong(BooEntity.this.navigation.findPathTo(new BlockPos(vec3d), 1), 0.4D);
            }
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d vec3d4 = AboveGroundTargeting.find(BooEntity.this, 8, 7, BooEntity.this.getX(), BooEntity.this.getZ(), 1.5707964F, 3, 1);
            return vec3d4 != null ? vec3d4 : NoPenaltySolidTargeting.find(BooEntity.this, 8, 4, -2, BooEntity.this.getX(), BooEntity.this.getZ(), 1.5707963705062866D);
        }
    }
}
