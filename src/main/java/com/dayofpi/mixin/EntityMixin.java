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
    final boolean firstUpdate = ((EntityExtra)this).accessFirstUpdate();

    @Inject(at=@At("TAIL"), method = "baseTick")
    public void baseTick(CallbackInfo info) {
        if (!firstUpdate && ((EntityExtra)this).world().getFluidState(((EntityExtra) this).blockPos()).isIn(ModTags.POISON)) {
            // Deal damage
            ((EntityExtra)this).invokeDamage(ModDmgSources.POISON, 5.0F);
        }
    }

    @Inject(at=@At("HEAD"), method = "onSwimmingStart", cancellable = true)
    public void onSwimmingStart(CallbackInfo info) {
        if (!firstUpdate && ((EntityExtra)this).world().getFluidState(((EntityExtra) this).blockPos()).isIn(ModTags.POISON)) {
            // Do not show water splash particles
            info.cancel();
        }
    }
}