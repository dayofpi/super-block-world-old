package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.common.utility.items.ModBoatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<ModBoatEntity> MOD_BOAT = FabricEntityTypeBuilder.<ModBoatEntity>create(SpawnGroup.MISC, ModBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();

    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Main.MOD_ID, "mod_boat"), MOD_BOAT);
    }
}
