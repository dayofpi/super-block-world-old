package com.dayofpi.super_block_world.core.registry;

import com.dayofpi.super_block_world.core.Main;
import com.dayofpi.super_block_world.common.block.blockentity.ModSignBE;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static BlockEntityType<ModSignBE> MOD_SIGN;

    public static void registerBlockEntities() {
        MOD_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "mod_sign"), FabricBlockEntityTypeBuilder.create(ModSignBE::new, BlockReg.AMANITA_SIGN, BlockReg.AMANITA_WALL_SIGN).build());
    }
}
