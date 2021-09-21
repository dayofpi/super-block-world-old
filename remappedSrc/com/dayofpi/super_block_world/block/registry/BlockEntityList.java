package com.dayofpi.super_block_world.block.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.block_entity.ModSignBE;
import com.dayofpi.super_block_world.block.block_entity.QuestionBlockBE;
import com.dayofpi.super_block_world.block.block_entity.WarpPipeBE;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityList {

    public static BlockEntityType<ModSignBE> MOD_SIGN;
    public static BlockEntityType<QuestionBlockBE> QUESTION_BLOCK;
    public static BlockEntityType<WarpPipeBE> WARP_PIPE;

    public static void registerBlockEntities() {
        MOD_SIGN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "mod_sign"), FabricBlockEntityTypeBuilder.create(ModSignBE::new, BlockList.AMANITA_SIGN, BlockList.AMANITA_WALL_SIGN).build());
        QUESTION_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "question_block"), FabricBlockEntityTypeBuilder.create(QuestionBlockBE::new, BlockList.QUESTION_BLOCK).build());
        WARP_PIPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MOD_ID, "warp_pipe"), FabricBlockEntityTypeBuilder.create(WarpPipeBE::new, BlockList.WARP_PIPE).build());
    }
}
