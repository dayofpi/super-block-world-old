package com.dayofpi.super_block_world.utility;

import com.dayofpi.super_block_world.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static Identifier block_WATER_EVAPORATE_ID = new Identifier(Main.MOD_ID, "block.water.evaporate");
    public static final SoundEvent block_WATER_EVAPORATE = new SoundEvent(block_WATER_EVAPORATE_ID);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, block_WATER_EVAPORATE_ID, block_WATER_EVAPORATE);
    }
}
