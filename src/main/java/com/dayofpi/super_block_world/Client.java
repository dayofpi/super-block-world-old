package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.client.BlockRendering;
import com.dayofpi.super_block_world.client.FluidRendering;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRendering.setRenderLayers();
        FluidRendering.renderFluids();
    }
}
