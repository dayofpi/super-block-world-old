package com.dayofpi.super_block_world.entity.types;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.google.common.collect.Maps;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class MooMooEntity extends CowEntity {
    public static final Map<Integer, Identifier> TEXTURES;
    private static final Ingredient BREEDING_INGREDIENT;
    private static final TrackedData<Integer> TYPE;
    private static final TrackedData<Boolean> LYING;

    static {
        BREEDING_INGREDIENT = Ingredient.ofItems(Items.WHEAT, BlockList.HORSETAIL);
        TYPE = DataTracker.registerData(MooMooEntity.class, TrackedDataHandlerRegistry.INTEGER);
        LYING = DataTracker.registerData(MooMooEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
            map.put(0, new Identifier(Main.MOD_ID, "textures/entity/moo_moo/vanilla.png"));
            map.put(1, new Identifier(Main.MOD_ID, "textures/entity/moo_moo/casadinho.png"));
            map.put(2, new Identifier(Main.MOD_ID, "textures/entity/moo_moo/chocolate.png"));
        });
    }

    public MooMooEntity(EntityType<? extends MooMooEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.2)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224D);
    }

    public static boolean canSpawn(WorldAccess world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(BlockList.TOADSTOOL_GRASS) && world.isSkyVisible(pos) && world.getBaseLightLevel(pos, 0) > 8;
    }

    public Identifier getTexture() {
        return TEXTURES.getOrDefault(this.getColor(), TEXTURES.get(0));
    }

    public int getColor() {
        return this.dataTracker.get(TYPE);
    }

    public void setColor(int type) {
        if (type < 0 || type > 3) {
            type = 0;
        }
        this.dataTracker.set(TYPE, type);
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

    public MooMooEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        MooMooEntity mooMooEntity = EntityList.MOO_MOO.create(serverWorld);
        if (passiveEntity instanceof MooMooEntity && mooMooEntity != null) {
            mooMooEntity.setColor(((MooMooEntity) passiveEntity).getColor());
        }
        return mooMooEntity;
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setColor(this.random.nextInt(4));
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LYING, false);
        this.dataTracker.startTracking(TYPE, 1);
    }

    public boolean isLying() {
        return this.dataTracker.get(LYING);
    }

    public void setLying(boolean lying) {
        this.dataTracker.set(LYING, lying);
    }

    @Override
    public void tickMovement() {
        if (this.isLying()) {
            if (this.isNavigating() || this.isInLove() || this.touchingWater || !this.isOnGround() || (random.nextInt(100000) == 0))
                this.setLying(false);
        } else if (random.nextInt(10000) == 0) {
            this.setLying(true);
        }
        super.tickMovement();

    }

    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(BlockList.TOADSTOOL_GRASS) ? 10.0F : world.getLightLevel(pos) - 0.5F;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Type", this.getColor());
        nbt.putBoolean("LyingDown", this.isLying());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setColor(nbt.getInt("Type"));
        this.setLying(nbt.getBoolean("LyingDown"));
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
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
