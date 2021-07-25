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
    @Inject(at=@At("TAIL"), method="tick")
    public void tick(CallbackInfo info) {
        ((EntityExtra)this).getUpdateMovementInFluid(ModTags.POISON, 0.0023333333333333335D);
        boolean firstUpdate = ((EntityExtra)this).getFirstUpdate();
        if (!firstUpdate && ((EntityExtra) this).getWorld().getFluidState(((EntityExtra)this).getBlockPos()).isIn(ModTags.POISON)) {
            ((EntityExtra)this).invokeDamage(ModDmgSources.POISON, 5.0F);
        }
    }
}