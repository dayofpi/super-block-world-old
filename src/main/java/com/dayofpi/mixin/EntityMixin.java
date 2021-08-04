package com.dayofpi.mixin;

import com.dayofpi.super_block_world.utility.ModDmgSources;
import com.dayofpi.super_block_world.utility.ModTags;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(Entity.class)
public abstract class EntityMixin {
    private final Random random = new Random();
    protected boolean touchingPoison;
    public boolean isTouchingPoison() {
        return this.touchingPoison;
    }

    @Inject(at=@At("TAIL"), method = "baseTick")
        void baseTick(CallbackInfo info) {
        if (this.isTouchingPoison()) {
            if (!((EntityI)this).aType().isIn(ModTags.POISON_IMMUNE)) {
                if (((EntityI)this).iDamage(ModDmgSources.POISON, 4.0F)) {
                    ((EntityI) this).aWorld().playSound(null, ((EntityI) this).aBlockPos(), SoundEvents.ENTITY_GENERIC_BURN, ((EntityI) this).iGetSoundCategory(), 0.4F, 2.0F + this.random.nextFloat() * 0.4F);
                }
                ((EntityI)this).iDamage(ModDmgSources.POISON, 4.0F);
            }
        }
    }

    @Inject(at=@At("HEAD"), method = "onSwimmingStart", cancellable = true)
    public void onSwimmingStart(CallbackInfo info) {
        if (((EntityI)this).iUpdateMovementInFluid(ModTags.POISON, 0.014D)) {
            // Do not show water splash particles
            info.cancel();
        }
    }

    @Inject(at=@At("HEAD"), method = "checkWaterState")
    void checkWaterState(CallbackInfo info) {
        this.touchingPoison = ((EntityI) this).iUpdateMovementInFluid(ModTags.POISON, 0.014D);
    }
}

