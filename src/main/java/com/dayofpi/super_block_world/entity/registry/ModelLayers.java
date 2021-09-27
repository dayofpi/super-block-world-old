package com.dayofpi.super_block_world.entity.registry;


import com.dayofpi.super_block_world.Main;
import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class ModelLayers {
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
    public static final EntityModelLayer MOD_BOAT = registerMain("boat");
    public static final EntityModelLayer BUZZY_SHELL = registerMain("buzzy_shell");
    public static final EntityModelLayer MOO_MOO = registerMain("moo_moo");
    public static final EntityModelLayer GOOMBA = registerMain("goomba");
    public static final EntityModelLayer BOO = registerMain("boo");
    public static final EntityModelLayer BUZZY_BEETLE = registerMain("buzzy_beetle");
    public static final EntityModelLayer BUZZY_BEETLE_SADDLE = registerMain("buzzy_beetle_saddle");
    public static final EntityModelLayer NIPPER_PLANT = registerMain("nipper_plant");
    public static final EntityModelLayer STINGBY = registerMain("stingby");
    public static final EntityModelLayer ROTTEN_MUSHROOM = registerMain("rotten_mushroom");


    // Setup
    private static EntityModelLayer registerMain(String id) {
        return register(id, "main");
    }

    private static EntityModelLayer register(String id, String layer) {
        EntityModelLayer entityModelLayer = create(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
        } else {
            return entityModelLayer;
        }
    }

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(new Identifier(Main.MOD_ID, id), layer);
    }

    public static Stream<EntityModelLayer> getLayers() {
        return LAYERS.stream();
    }
}