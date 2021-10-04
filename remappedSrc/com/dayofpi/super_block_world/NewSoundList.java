package com.dayofpi.super_block_world;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NewSoundList {
    public static final SoundEvent BLOCK_WARP_PIPE_TELEPORT = new SoundEvent(new Identifier(Main.MOD_ID, "block.warp_pipe.teleport"));
    public static final SoundEvent BLOCK_BOO_LANTERN_HIDE = new SoundEvent(new Identifier(Main.MOD_ID, "block.boo_lantern.hide"));
    public static final SoundEvent BLOCK_BOO_LANTERN_REVEAL = new SoundEvent(new Identifier(Main.MOD_ID, "block.boo_lantern.reveal"));

    public static final SoundEvent ITEM_PROJECTILE_THROW = new SoundEvent(new Identifier(Main.MOD_ID, "item.projectile.throw"));

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.warp_pipe.teleport", BLOCK_WARP_PIPE_TELEPORT);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.boo_lantern.hide", BLOCK_BOO_LANTERN_HIDE);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.boo_lantern.reveal", BLOCK_BOO_LANTERN_REVEAL);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:item.projectile.throw", ITEM_PROJECTILE_THROW);
    }
}
