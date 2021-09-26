package com.dayofpi.mixin;

import com.dayofpi.super_block_world.misc.TagList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PathAwareEntity.class)
public abstract class MixinPathAware extends MobEntity {
    public final SwimGoal swimGoal = new SwimGoal(this);

    protected MixinPathAware(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tickMovement() {
        // This makes it so mobs that are immune to poison can swim in it
        super.tickMovement();
        boolean bl = this.getType().isIn(TagList.POISON_IMMUNE);
        boolean bl2 = this.updateMovementInFluid(TagList.POISON, 0.014D);
        if (bl) {
            if (bl2) {
                this.goalSelector.add(1, this.swimGoal);
            } else this.goalSelector.remove(this.swimGoal);
        }
    }
}

