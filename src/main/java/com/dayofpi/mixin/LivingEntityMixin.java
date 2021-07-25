package com.dayofpi.mixin;

import com.dayofpi.super_block_world.utility.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    boolean isInPoison() {
        boolean firstUpdate = ((EntityExtra)this).getFirstUpdate();
        return (!firstUpdate && ((EntityExtra) this).getFluidHeight().getDouble(ModTags.POISON) > 0.0D);
    }

    double swimHeightMethod() {
        return ((EntityExtra)this).getStandingEyeHeight() < 0.4D ? 0.0D : 0.4D;
    }

    public Vec3d mixin_26317(double d, boolean bl, Vec3d vec3d) {
        if (!((EntityExtra)this).getHasNoGravity() && !((EntityExtra)this).getIsSprinting()) {
            double f;
            if (bl && Math.abs(vec3d.y - 0.005D) >= 0.003D && Math.abs(vec3d.y - d / 16.0D) < 0.003D) {
                f = -0.003D;
            } else {
                f = vec3d.y - d / 16.0D;
            }

            return new Vec3d(vec3d.x, f, vec3d.z);
        } else {
            return vec3d;
        }
    }

        @Inject(at=@At("HEAD"), method="travel(Lnet/net/minecraft/util/math/Vec3d;)Z", cancellable = true)
        public void travel(Vec3d movementInput, CallbackInfo info) {
            FluidState fluidState = ((EntityExtra) this).getWorld().getFluidState(((EntityExtra) this).getBlockPos());

            if (this.isInPoison() && ((LivingEntityExtra)this).getShouldSwimInFluids() && !((LivingEntityExtra)this).getCanWalkOnFluid(fluidState.getFluid())) {
                boolean bl = ((EntityExtra)this).getVelocity().y <= 0.0D;

                ((EntityExtra) this).getUpdateVelocity(0.02F, movementInput);
                ((EntityExtra) this).getMove(MovementType.SELF, ((EntityExtra) this).getVelocity());
                Vec3d vec3d4;
                if (((EntityExtra) this).getFluidHeight().getDouble(ModTags.POISON) <= this.swimHeightMethod()) {
                    ((EntityExtra) this).getSetVelocity(((EntityExtra) this).getVelocity().multiply(0.5D, 0.800000011920929D, 0.5D));
                    vec3d4 = (this.mixin_26317(0.08D, bl, ((EntityExtra) this).getVelocity()));
                    ((EntityExtra) this).getSetVelocity(vec3d4);
            }
        }
    }
}
