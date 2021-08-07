package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.common.blockentity.ModSignBE;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static BlockEntityType<ModSignBE> MOD_SIGN;

    public static void registerBlockEntities() {
        MOD_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "mod_sign"), FabricBlockEntityTypeBuilder.create(ModSignBE::new, ModBlocks.AMANITA_SIGN, ModBlocks.AMANITA_WALL_SIGN).build());
    }
}
