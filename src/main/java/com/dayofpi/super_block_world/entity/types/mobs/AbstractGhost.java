package com.dayofpi.super_block_world.entity.types.mobs;

import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.entity.types.GhostEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Random;

public class AbstractGhost extends EnemyEntity {
    final static int lightLimit = 10;

    public AbstractGhost(EntityType<? extends AbstractGhost> entityType, World world) {
        super(entityType, world);
    }

    public static boolean canSpawn(ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return isSpawnDark(world, pos, random) && world.isSkyVisible(pos) || (spawnReason == SpawnReason.STRUCTURE);
    }

    public void tickMovement(){
        super.tickMovement();
        if (this.isAlive()) {
            final float f = world.getLightLevel(LightType.BLOCK, this.getBlockPos());
            if (f > lightLimit) {
                this.damage(DamageSource.MAGIC, 2.0F);
            }
        }
    }

    public void onDeath(DamageSource source) {
        if (!world.isClient) {
            GhostEntity ghostEntity = new GhostEntity(EntityList.GHOST, world, this.getX(), this.getY(), this.getZ());
            world.spawnEntity(ghostEntity);
        }
        super.onDeath(source);
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    public boolean isInAir() {
        return !this.onGround;
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }

    protected void swimUpward(Tag<Fluid> fluid) {
        this.setVelocity(this.getVelocity().add(0.0D, 0.01D, 0.0D));
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
    }
}
