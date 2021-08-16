package com.dayofpi.super_block_world.entities;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entities.types.BuzzyBeetleEntity;
import com.dayofpi.super_block_world.entities.types.ModBoatEntity;
import com.dayofpi.super_block_world.entities.types.SpikeTopEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityTypes {

    public static final EntityType<ModBoatEntity> MOD_BOAT = FabricEntityTypeBuilder.<ModBoatEntity>create(SpawnGroup.MISC, ModBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    public static final EntityType<BuzzyBeetleEntity> BUZZY_BEETLE = FabricEntityTypeBuilder
            .create(SpawnGroup.MONSTER, BuzzyBeetleEntity::new)
            .dimensions(EntityDimensions.fixed(1.0F, 0.9F)).build();
    public static final EntityType<SpikeTopEntity> SPIKE_TOP = FabricEntityTypeBuilder
            .create(SpawnGroup.MONSTER, SpikeTopEntity::new)
            .dimensions(EntityDimensions.fixed(1.0F, 0.9F)).build();

    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(BUZZY_BEETLE, BuzzyBeetleEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SPIKE_TOP, SpikeTopEntity.createAttributes());
        register("mod_boat", MOD_BOAT);
        register("buzzy_beetle", BUZZY_BEETLE);
        register("spike_top", SPIKE_TOP);

    }

    private static <T extends Entity> void register(String id, EntityType<T> type) {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Main.MOD_ID, id), type);
    }
}