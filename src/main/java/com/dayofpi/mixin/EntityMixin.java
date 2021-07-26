package com.dayofpi.mixin;

import com.dayofpi.super_block_world.utility.ModDmgSources;
import com.dayofpi.super_block_world.utility.ModTags;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    float fallDistance = ((EntityExtra)this).accessFalLDistance();
    final boolean firstUpdate = ((EntityExtra)this).accessFirstUpdate();

    @Inject(at=@At("TAIL"), method="baseTick")
    public void baseTick(CallbackInfo info) {
        if (!firstUpdate && ((EntityExtra) this).accessWorld().getFluidState(((EntityExtra)this).accessBlockPos()).isIn(ModTags.POISON)) {
            ((EntityExtra)this).invokeDamage(ModDmgSources.POISON, 5.0F);
            this.fallDistance *= 0.5F;
            ((EntityExtra)this).invokeUpdateMovementInFluid(ModTags.POISON, 0.007D);
        }
    }
}