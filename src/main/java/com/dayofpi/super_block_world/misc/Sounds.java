package com.dayofpi.super_block_world.misc;

import com.dayofpi.super_block_world.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Sounds {
    protected static final Identifier BUZZY_BEETLE_HURT_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.hurt");
    public static final SoundEvent BUZZY_BEETLE_HURT = new SoundEvent(BUZZY_BEETLE_HURT_ID);
    protected static final Identifier BUZZY_BEETLE_DEATH_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.death");
    public static final SoundEvent BUZZY_BEETLE_DEATH = new SoundEvent(BUZZY_BEETLE_DEATH_ID);
    protected static final Identifier BUZZY_BEETLE_DROP_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.drop");
    public static final SoundEvent BUZZY_BEETLE_DROP = new SoundEvent(BUZZY_BEETLE_DROP_ID);
    protected static final Identifier BUZZY_BEETLE_LAND_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.land");
    public static final SoundEvent BUZZY_BEETLE_LAND = new SoundEvent(BUZZY_BEETLE_LAND_ID);
    protected static final Identifier BUZZY_BEETLE_BLOCK_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.block");
    public static final SoundEvent BUZZY_BEETLE_BLOCK = new SoundEvent(BUZZY_BEETLE_BLOCK_ID);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_HURT_ID, BUZZY_BEETLE_HURT);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_DEATH_ID, BUZZY_BEETLE_DEATH);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_DROP_ID, BUZZY_BEETLE_DROP);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_LAND_ID, BUZZY_BEETLE_LAND);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_BLOCK_ID, BUZZY_BEETLE_BLOCK);
    }
}
