package com.dayofpi.mixin;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.types.AbstractBuzzy;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.SoundList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {
    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Invoker("getEquippedStack")
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(at = @At("HEAD"), method = "jump", cancellable = true)
    protected void jump(CallbackInfo info) {
        Vec3d vec3d = this.getVelocity();
        BlockPos blockPos = this.getBlockPos();
        if (world.getBlockState(blockPos.down()).isOf(BlockList.TRAMPOLINE)) {
            this.setVelocity(vec3d.x, 1.3, vec3d.z);
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", cancellable = true)
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> info) {
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isOf(ItemList.BUZZY_SHELL)) {
            if (source instanceof ProjectileDamageSource && source.getPosition() != null && source.getPosition().y > this.getY() + 1.5 || source.isFallingBlock() || source.getAttacker() != null && source.getAttacker() instanceof AbstractBuzzy && ((AbstractBuzzy) source.getAttacker()).isUpsideDown() && source.getAttacker().fallDistance > 0) {
                this.world.playSound(null, this.getBlockPos(), SoundList.BUZZY_BEETLE_BLOCK, SoundCategory.NEUTRAL, 0.6F, this.randomPitch());
                itemStack.setDamage(itemStack.getDamage() + random.nextInt(2));
                if (itemStack.getDamage() >= itemStack.getMaxDamage()) {
                    this.sendEquipmentBreakStatus(EquipmentSlot.HEAD);
                    this.equipStack(EquipmentSlot.HEAD, ItemStack.EMPTY);
                }
                if (source instanceof ProjectileDamageSource projectileDamageSource) {
                    if (projectileDamageSource.getSource() != null)
                    projectileDamageSource.getSource().addVelocity(0.0D, 2.0D, 0.0D);
                }
                info.setReturnValue(false);
                info.cancel();
            }
        }
    }

    public void sendEquipmentBreakStatus(EquipmentSlot slot) {
        this.world.sendEntityStatus(this, getEquipmentBreakStatus(slot));
    }

    private static byte getEquipmentBreakStatus(EquipmentSlot slot) {
        switch(slot) {
            case OFFHAND:
                return 48;
            case HEAD:
                return 49;
            case CHEST:
                return 50;
            case FEET:
                return 52;
            case LEGS:
                return 51;
            default:
                return 47;
        }
    }

    public float randomPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
    }
}

