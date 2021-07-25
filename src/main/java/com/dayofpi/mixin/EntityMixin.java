package com.dayofpi.mixin;

import com.dayofpi.super_block_world.utility.ModDmgSources;
import com.dayofpi.super_block_world.utility.ModTags;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    float fallDistance = ((EntityExtra)this).getFallDistance();
    boolean firstUpdate = ((EntityExtra)this).getFirstUpdate();
    Object2DoubleMap<Tag<Fluid>> fluidHeight = ((EntityExtra) this).getFluidHeight();

    public boolean isInLava() {
        return !this.firstUpdate && this.fluidHeight.getDouble(FluidTags.LAVA) > 0.0D;
    }

    @Inject(at=@At("TAIL"), method="baseTick")
    public void baseTick(CallbackInfo info) {
        if (!firstUpdate && ((EntityExtra) this).getWorld().getFluidState(((EntityExtra)this).getBlockPos()).isIn(ModTags.POISON)) {
            ((EntityExtra)this).invokeDamage(ModDmgSources.POISON, 5.0F);
        }

        if (this.isInLava()) {
            this.fallDistance *= 0.5F;
            if ((fluidHeight.getDouble(ModTags.TRUE_LAVA) > 0.0D)) {
                ((EntityExtra)this).invokeSetOnFireFromLava();
            }
        }
    }
}