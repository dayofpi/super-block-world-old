package com.dayofpi.super_block_world.entity.types.mobs;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public abstract class AbstractCeilingTroop extends AbstractTroop {
    private static final TrackedData<Boolean> UPSIDE_DOWN;

    static {
        UPSIDE_DOWN = DataTracker.registerData(AbstractBuzzy.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    protected AbstractCeilingTroop(EntityType<? extends AbstractTroop> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(UPSIDE_DOWN, false);
    }

    public boolean isOnCeiling(BlockPos pos) {
        if (!this.isBaby()) {
            return world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos, Direction.DOWN) && !this.hasVehicle();
        }  else return world.getStatesInBox(this.getBoundingBox().offset(0.0D, 0.0D, 0.5D)).anyMatch(BlockState::isOpaque);

    }

    public boolean isUpsideDown() {
        return this.dataTracker.get(UPSIDE_DOWN);
    }

    public void setUpsideDown(boolean upsideDown) {
        this.dataTracker.set(UPSIDE_DOWN, upsideDown);
    }
}
