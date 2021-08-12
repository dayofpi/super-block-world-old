package com.dayofpi.super_block_world.blocks;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.blocks.blockentity.ModSignBE;
import com.dayofpi.super_block_world.blocks.blockentity.QuestionBlockBE;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static BlockEntityType<ModSignBE> MOD_SIGN;
    public static BlockEntityType<QuestionBlockBE> QUESTION_BLOCK;

    public static void registerBlockEntities() {
        MOD_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "mod_sign"), FabricBlockEntityTypeBuilder.create(ModSignBE::new, BlockTypes.AMANITA_SIGN, BlockTypes.AMANITA_WALL_SIGN).build());
        QUESTION_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "question_block"), FabricBlockEntityTypeBuilder.create(QuestionBlockBE::new, BlockTypes.QUESTION_BLOCK).build());
    }
}
