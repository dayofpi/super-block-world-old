package com.dayofpi.mixin;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.block.types.WarpPipeBlock;
import com.dayofpi.super_block_world.entity.types.mobs.AbstractBuzzy;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.ModDamageSource;
import com.dayofpi.super_block_world.misc.SoundList;
import com.dayofpi.super_block_world.misc.TagList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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
    private int pipeCooldown;
    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Invoker("getEquippedStack")
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    private boolean isWearingTheBoots() {
        ItemStack feetSlot = this.getEquippedStack(EquipmentSlot.FEET);
        return (feetSlot.isOf(ItemList.JUMP_BOOTS));
    }

    public int getPipeCooldown() {
        return pipeCooldown;
    }

    public void setPipeCooldown(int cooldown) {
        this.pipeCooldown = cooldown;
    }

    public void setSneaking(boolean sneaking) {
        if (sneaking) {
            this.warpToPipe();
        }
        super.setSneaking(sneaking);
    }

    public void warpToPipe() {
        BlockPos currentPos = this.getBlockPos().down();

        if (this.getPipeCooldown() == 0 && world.getBlockState(currentPos).isOf(BlockList.WARP_PIPE)) {
            BlockPos newPos = WarpPipeBlock.warpPipeTree.getNearestBlock(currentPos, world, this.getHeadYaw());
            if (newPos != null) {
                this.setPipeCooldown(10);
                this.requestTeleport(newPos.getX() + 0.5, newPos.getY() + 1.0F, newPos.getZ() + 0.5);
                world.sendEntityStatus(this, (byte) 46);
                if (world.isClient)
                    this.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
            }

        }
    }

    @Inject(at = @At("TAIL"), method = "baseTick")
    void baseTick(CallbackInfo info) {
        if (this.getPipeCooldown() > 0) {
            --this.pipeCooldown;
        }
    }

    @Inject(at = @At("HEAD"), method = "jump", cancellable = true)
    protected void jump(CallbackInfo info) {
        Vec3d vec3d = this.getVelocity();
        BlockPos blockPos = this.getBlockPos();
        if (world.getBlockState(blockPos.down()).isOf(BlockList.TRAMPOLINE)) {
            this.setVelocity(vec3d.x, 1.3, vec3d.z);
            info.cancel();
        }
        if (this.isWearingTheBoots()) {
            this.playSound(SoundList.JUMP, 0.2F, this.getSoundPitch());
        }

    }

    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
    }

    @Inject(at = @At("HEAD"), method = "getJumpVelocity()F", cancellable = true)
    private void getJumpVelocity(CallbackInfoReturnable<Float> info) {
        if (this.isWearingTheBoots()) {
            float jumpHeight = 0.9F;
            if (this.isSneaking()) {
                jumpHeight = 0.6F;
            }
            info.setReturnValue(jumpHeight * this.getJumpVelocityMultiplier());
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "pushAwayFrom")
    public void pushAwayFrom(Entity entity, CallbackInfo info) {
        if (this.isWearingTheBoots() && entity instanceof LivingEntity livingEntity && !livingEntity.isDead()) {
            Vec3d vec3d = this.getVelocity();
            ItemStack helmet = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
            boolean conditions = this.getY() > livingEntity.getY() && this.fallDistance > 0;
            boolean exceptions = helmet.isOf(ItemList.BUZZY_SHELL) || livingEntity.getType().isIn(TagList.IMMUNE_TO_BOOTS);
            if (conditions) {
                if (!exceptions) {
                    entity.damage(ModDamageSource.stomp(world.getClosestEntity(LivingEntity.class, TargetPredicate.createNonAttackable(), livingEntity, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), this.getBoundingBox().expand(0, 1, 0))), 5F);
                    this.playSound(SoundList.STOMP, 1.0F, this.getSoundPitch());
                    this.setVelocity(vec3d.x, 0.5, vec3d.z);
                    if (helmet.isDamageable()) {
                        helmet.damage(2, livingEntity, ((e) -> e.sendEquipmentBreakStatus(EquipmentSlot.HEAD)));
                    }

                } else {
                    this.setVelocity(vec3d.x, 0.5, vec3d.z);
                    this.playSound(SoundList.BOUNCE, 1.0F, 1.0F);
                }
            }
        }
    }



    @Inject(at = @At("HEAD"), method = "damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", cancellable = true)
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> info) {
        ItemStack headSlot = this.getEquippedStack(EquipmentSlot.HEAD);
        if (headSlot.isOf(ItemList.BUZZY_SHELL)) {
            if (source instanceof ProjectileDamageSource && source.getPosition() != null && source.getPosition().y > this.getY() + 1.5 || source.isFallingBlock() || source.getAttacker() != null && source.getAttacker() instanceof AbstractBuzzy && ((AbstractBuzzy) source.getAttacker()).isUpsideDown() && source.getAttacker().fallDistance > 0) {
                this.world.playSound(null, this.getBlockPos(), SoundList.BUZZY_BEETLE_BLOCK, SoundCategory.NEUTRAL, 0.6F, this.randomPitch());
                headSlot.setDamage(headSlot.getDamage() + random.nextInt(2));
                if (headSlot.getDamage() >= headSlot.getMaxDamage()) {
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

    @Inject(at = @At("HEAD"), method = "handleFallDamage(FFLnet/minecraft/entity/damage/DamageSource;)Z", cancellable = true)
    public void handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> info) {
        if (this.isWearingTheBoots()) {
            info.setReturnValue(false);
            info.cancel();
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

