package com.dayofpi.super_block_world.entity.types;

import com.dayofpi.super_block_world.item.registry.ItemList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;

public abstract class AbstractShellEntity extends Entity {
    public AbstractShellEntity(EntityType<?> type, World world) {
        super(type, world);
        this.inanimate = true;
    }

    public ItemStack getPickBlockStack() {
        return new ItemStack(this.asItem());
    }

    public void tick() {
        super.tick();
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0D, -0.04D, 0.0D));
        }

        this.move(MovementType.SELF, this.getVelocity());
        this.checkBlockCollision();
        List<Entity> list = this.world.getOtherEntities(this, this.getBoundingBox().expand(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntityPredicates.canBePushedBy(this));
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                this.pushAwayFrom(entity);
            }
        }
    }

    public Item asItem() {
        return ItemList.BUZZY_SHELL;
    }

    public boolean collidesWith(Entity other) {
        return canCollide(this, other);
    }

    public static boolean canCollide(Entity entity, Entity other) {
        return (other.isCollidable() || other.isPushable()) && !entity.isConnectedThroughVehicle(other);
    }

    public boolean collides() {
        return !this.isRemoved();
    }

    public boolean isCollidable() {
        return true;
    }

    public boolean isPushable() {
        return true;
    }

    public void pushAwayFrom(Entity entity) {
        super.pushAwayFrom(entity);
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.world.isClient && !this.isRemoved()) {
            this.emitGameEvent(GameEvent.ENTITY_DAMAGED, source.getAttacker());
            if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                this.dropItem(this.asItem());
            }
            this.discard();
            return true;
        } else return true;
    }
}
