package com.dayofpi.super_block_world.entity.types;

import com.dayofpi.super_block_world.Client;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.SpawnPacket;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BombEntity extends ThrownItemEntity {
   public BombEntity(EntityType<? extends BombEntity> entityType, World world) {
      super(entityType, world);
   }

   public BombEntity(World world, LivingEntity owner) {
      super(EntityList.BOMB, owner, world);
   }

   protected Item getDefaultItem() {
      return ItemList.BOMB;
   }

   @Override
   public Packet<?> createSpawnPacket() {
      return SpawnPacket.create(this, Client.PacketID);
   }

   private ParticleEffect getParticleParameters() {
      return new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack());
   }

   public void handleStatus(byte status) {
      if (status == 3) {
         ParticleEffect particleEffect = this.getParticleParameters();

         for(int i = 0; i < 8; ++i) {
            this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
         }
      }

   }

   protected void onCollision(HitResult hitResult) {
      super.onCollision(hitResult);
      if (!this.world.isClient) {
         if (hitResult.getType() == HitResult.Type.BLOCK || hitResult.getType() == HitResult.Type.ENTITY) {
            world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, Explosion.DestructionType.BREAK);
            this.world.sendEntityStatus(this, (byte) 3);
            this.discard();
         }
      }

   }
   protected float getGravity() {
      return 0.08F;
   }
}
