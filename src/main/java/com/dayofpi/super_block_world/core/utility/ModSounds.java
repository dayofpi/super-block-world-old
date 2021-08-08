package com.dayofpi.super_block_world.core.utility;

import com.dayofpi.super_block_world.core.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static final Identifier POISON_BURN_ID = new Identifier(Main.MOD_ID, "block.poison.burn");

    public static final SoundEvent POISON_BURN = new SoundEvent(POISON_BURN_ID);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, POISON_BURN_ID, POISON_BURN);
    }
}
