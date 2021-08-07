package com.dayofpi.mixin.entity;

import com.dayofpi.super_block_world.common.utility.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PathAwareEntity.class)
public abstract class PathAwareEntityMixin extends MobEntity {
    public final SwimGoal swimGoal = new SwimGoal(this);
    protected PathAwareEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        boolean bl = this.getType().isIn(ModTags.POISON_IMMUNE);
        boolean bl2 = this.updateMovementInFluid(ModTags.POISON, 0.014D);
        if (bl) {
            if (bl2) {
                this.goalSelector.add(1, this.swimGoal);
            } else this.goalSelector.remove(this.swimGoal);
        }
    }
}

