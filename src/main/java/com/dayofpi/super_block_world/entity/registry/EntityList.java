package com.dayofpi.super_block_world.entity.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.types.*;
import com.dayofpi.super_block_world.entity.types.mobs.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityList {

    public static final EntityType<TurnipEntity> TURNIP = FabricEntityTypeBuilder.<TurnipEntity>create(SpawnGroup.MISC, TurnipEntity::new).dimensions(EntityDimensions.fixed(0.8F, 0.8F)).trackRangeBlocks(4).trackedUpdateRate(10).build();
    public static final EntityType<HammerEntity> HAMMER = FabricEntityTypeBuilder.<HammerEntity>create(SpawnGroup.MISC, HammerEntity::new).dimensions(EntityDimensions.fixed(0.8F, 0.8F)).trackRangeBlocks(4).trackedUpdateRate(10).build();
    public static final EntityType<BombEntity> BOMB = FabricEntityTypeBuilder.<BombEntity>create(SpawnGroup.MISC, BombEntity::new).dimensions(EntityDimensions.fixed(0.8F, 0.8F)).trackRangeBlocks(4).trackedUpdateRate(10).build();

    public static final EntityType<ModBoatEntity> MOD_BOAT = FabricEntityTypeBuilder.<ModBoatEntity>create(SpawnGroup.MISC, ModBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    public static final EntityType<BuzzyShellEntity> BUZZY_SHELL = FabricEntityTypeBuilder.create(SpawnGroup.MISC, BuzzyShellEntity::new).dimensions(EntityDimensions.fixed(1.0F, 0.8F)).build();

    public static final EntityType<MooMooEntity> MOO_MOO = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MooMooEntity::new)
            .dimensions(EntityDimensions.changing(1.2F, 1.2F)).build();

    public static final EntityType<BuzzyBeetleEntity> BUZZY_BEETLE = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BuzzyBeetleEntity::new)
            .dimensions(EntityDimensions.changing(1.2F, 0.9F)).build();

    public static final EntityType<SpikeTopEntity> SPIKE_TOP = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SpikeTopEntity::new)
            .dimensions(EntityDimensions.fixed(1.2F, 0.9F)).build();

    public static final EntityType<NipperPlantEntity> NIPPER_PLANT = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, NipperPlantEntity::new)
            .dimensions(EntityDimensions.fixed(0.4F, 0.4F)).build();

    public static final EntityType<StingbyEntity> STINGBY = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StingbyEntity::new)
            .dimensions(EntityDimensions.fixed(0.8F, 0.8F)).build();

    public static final EntityType<RottenMushroomEntity> ROTTEN_MUSHROOM = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RottenMushroomEntity::new)
            .dimensions(EntityDimensions.fixed(0.6F, 0.65F)).fireImmune().build();

    public static void registerEntities() {
        register("turnip", TURNIP);
        register("hammer", HAMMER);
        register("bomb", BOMB);
        register("mod_boat", MOD_BOAT);
        register("buzzy_shell", BUZZY_SHELL);
        register("moo_moo", MOO_MOO);
        register("buzzy_beetle", BUZZY_BEETLE);
        register("spike_top", SPIKE_TOP);
        register("nipper_plant", NIPPER_PLANT);
        register("stingby", STINGBY);
        register("rotten_mushroom", ROTTEN_MUSHROOM);
        FabricDefaultAttributeRegistry.register(MOO_MOO, MooMooEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BUZZY_BEETLE, BuzzyBeetleEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SPIKE_TOP, SpikeTopEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NIPPER_PLANT, NipperPlantEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(STINGBY, StingbyEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ROTTEN_MUSHROOM, RottenMushroomEntity.createAttributes());
    }

    private static <T extends Entity> void register(String id, EntityType<T> type) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Main.MOD_ID, id), type);
    }
}