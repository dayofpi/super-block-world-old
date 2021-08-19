package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.blocks.BlockTypes;
import com.dayofpi.super_block_world.entities.EntityTypes;
import com.dayofpi.super_block_world.items.ItemTypes;
import com.dayofpi.super_block_world.misc.Sounds;
import com.dayofpi.super_block_world.misc.Tags;
import com.dayofpi.super_block_world.misc.fluids.PoisonFluid;
import com.dayofpi.super_block_world.misc.worldgen.FeatureReg;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.BlockPlacementDispenserBehavior;
import net.minecraft.block.dispenser.BoatDispenserBehavior;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class Main implements ModInitializer {
    // Mod ID
    public static final String MOD_ID = "super_block_world";
    // Item group
    public static final ItemGroup BLOCK_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "block_group"), () -> new ItemStack(BlockTypes.QUESTION_BLOCK));
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "item_group"), () -> new ItemStack(ItemTypes.SUPER_MUSHROOM));

    public static final FlowableFluid STILL_POISON = new PoisonFluid.Still();
    public static final FlowableFluid FLOWING_POISON = new PoisonFluid.Flowing();


    public static final DamageSource POISON = new DamageSource("poison") {
    };

    public static DamageSource mobDrop(LivingEntity attacker) {
        return new EntityDamageSource("mob_drop", attacker);
    }

    public static DamageSource spikyMob(LivingEntity attacker) {
        return new EntityDamageSource("spiky_mob", attacker);
    }

    @Override
    public void onInitialize() {
        BlockTypes.registerBlocks();
        ItemTypes.registerItems();
        CustomPortalApiRegistry.addPortal(BlockTypes.WARP_FRAME, PortalIgnitionSource.ItemUseSource(ItemTypes.POWER_STAR), new Identifier(MOD_ID, "mushroom_kingdom"), 230, 200, 224);
        EntityTypes.registerEntities();
        FeatureReg.registerFeatures();
        Tags.registerTags();
        Sounds.registerSounds();
        registerFluids();
        addDispenserBehaviors();

    }

    public static void registerFluids() {
        Registry.register(Registry.FLUID, new Identifier(MOD_ID, "poison"), STILL_POISON);
        Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_poison"), FLOWING_POISON);
    }

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
        DispenserBlock.registerBehavior(ItemTypes.POISON_BUCKET, dispenserBehavior);
        DispenserBlock.registerBehavior(ItemTypes.AMANITA_BOAT, new BoatDispenserBehavior(BoatEntity.Type.OAK));
        DispenserBlock.registerBehavior(BlockTypes.DONUT_BLOCK.asItem(), new BlockPlacementDispenserBehavior());
    }
}
