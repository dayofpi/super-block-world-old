package com.dayofpi.mixin;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.types.mobs.AbstractBuzzy;
import com.dayofpi.super_block_world.item.registry.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(FallingBlockEntity.class)
public abstract class MixinFallingBlockEntity extends Entity  {
    public MixinFallingBlockEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Accessor("block")
    abstract BlockState block();

    @Inject(at=@At("HEAD"), method = "tick", cancellable = true)
    public void tick(CallbackInfo info) {
        Box boundingBox = this.getBoundingBox().offset(0, -0.7, 0).contract(0.2, 0.5, 0.2);
        List<Entity> list = this.world.getOtherEntities(this, boundingBox);

        for (Entity entity : list) {
            if (entity instanceof LivingEntity livingEntity && !block().isAir() && !block().isOf(BlockList.DONUT_BLOCK)) {
                ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
                if (livingEntity instanceof  AbstractBuzzy || itemStack.isOf(ItemList.BUZZY_SHELL) && livingEntity.getY() < this.getY()) {
                    Vec3d vec3d = this.getVelocity();
                    this.setVelocity(vec3d.x, 0.0D, vec3d.z);
                    this.setPos(this.getX(), livingEntity.getBoundingBox().maxY, this.getZ());
                }
            }
        }
    }

    @Override
    public boolean isCollidable() {
        return this.block().isOf(BlockList.DONUT_BLOCK);
    }
}
