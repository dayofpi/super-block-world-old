package com.dayofpi.super_block_world.entity.types.projectiles;

import com.dayofpi.super_block_world.Client;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.SpawnPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerEntity extends ThrownItemEntity {
    public HammerEntity(EntityType<? extends HammerEntity> entityType, World world) {
        super(entityType, world);
    }

    public HammerEntity(World world, LivingEntity owner) {
        super(EntityList.HAMMER, owner, world);
    }

    public HammerEntity(World world, double x, double y, double z) {
        super(EntityList.TURNIP, x, y, z, world); // null will be changed later
    }

    protected Item getDefaultItem() {
        return ItemList.HAMMER;
    }

    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    private ParticleEffect getParticleParameters() {
        return new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack());
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
                if (world.getBlockState(blockPos).getBlock().getHardness() <= 1.2F) {
                    world.breakBlock(blockPos, true);
                }
                if (world.getBlockState(blockPos.up()).getBlock().getHardness() == 0.0F) {
                    world.breakBlock(blockPos.up(), true);
                }
            }
            this.world.sendEntityStatus(this, (byte) 3);
            this.discard();
        }

    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 6);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return SpawnPacket.create(this, Client.PacketID);
    }

    protected float getGravity() {
        return 0.1F;
    }
}
