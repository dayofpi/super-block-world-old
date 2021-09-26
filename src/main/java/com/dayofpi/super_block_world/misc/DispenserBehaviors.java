package com.dayofpi.super_block_world.misc;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.types.projectiles.HammerEntity;
import com.dayofpi.super_block_world.entity.types.projectiles.TurnipEntity;
import com.dayofpi.super_block_world.item.registry.ItemList;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.*;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DispenserBehaviors {
    public static void addDispenserBehaviors() {
        DispenserBehavior dispenserBehavior = new ItemDispenserBehavior() {
            private final ItemDispenserBehavior fallbackBehavior = new ItemDispenserBehavior();

            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                FluidModificationItem fluidModificationItem = (FluidModificationItem) stack.getItem();
                BlockPos blockPos = pointer.getPos().offset(pointer.getBlockState().get(DispenserBlock.FACING));
                World world = pointer.getWorld();
                if (fluidModificationItem.placeFluid(null, world, blockPos, null)) {
                    fluidModificationItem.onEmptied(null, world, stack, blockPos);
                    return new ItemStack(Items.BUCKET);
                } else return this.fallbackBehavior.dispense(pointer, stack);

            }
        };

        DispenserBlock.registerBehavior(Items.FLINT_AND_STEEL, new FallibleItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                World world = pointer.getWorld();
                this.setSuccess(true);
                Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
                BlockPos blockPos = pointer.getPos().offset(direction);
                BlockState blockState = world.getBlockState(blockPos);
                if (AbstractFireBlock.canPlaceAt(world, blockPos, direction)) {
                    world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
                    world.emitGameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                } else if (blockState.isOf(BlockList.STONE_TORCH) && !blockState.get(Properties.LIT)) {
                    world.setBlockState(blockPos, blockState.with(Properties.LIT, true));
                    world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, blockPos);
                }

                if (this.isSuccess() && stack.damage(1, world.random, null)) {
                    stack.setCount(0);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(ItemList.TURNIP, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new TurnipEntity(world, position.getX(), position.getY(), position.getZ()), (turnipEntity) -> turnipEntity.setItem(stack));
            }
        });

        DispenserBlock.registerBehavior(ItemList.HAMMER, new ProjectileDispenserBehavior() {
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new HammerEntity(world, position.getX(), position.getY(), position.getZ()), (hammerEntity) -> hammerEntity.setItem(stack));
            }
        });

        DispenserBlock.registerBehavior(ItemList.POISON_BUCKET, dispenserBehavior);
        DispenserBlock.registerBehavior(ItemList.AMANITA_BOAT, new BoatDispenserBehavior(EnumBoats.AMANITA));
        DispenserBlock.registerBehavior(BlockList.DONUT_BLOCK.asItem(), new BlockPlacementDispenserBehavior());
        DispenserBlock.registerBehavior(BlockList.TRAMPOLINE.asItem(), new BlockPlacementDispenserBehavior());
    }
}
