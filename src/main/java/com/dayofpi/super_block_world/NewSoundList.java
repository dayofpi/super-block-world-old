package com.dayofpi.super_block_world;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NewSoundList {
    public static final SoundEvent BLOCK_WARP_PIPE_TELEPORT = new SoundEvent(new Identifier(Main.MOD_ID, "block.warp_pipe.teleport"));
    public static final SoundEvent BLOCK_DONUT_BLOCK_TRIGGER = new SoundEvent(new Identifier(Main.MOD_ID, "block.donut_block.trigger"));
    public static final SoundEvent BLOCK_SPIKES_RETRACT = new SoundEvent(new Identifier(Main.MOD_ID, "block.spikes.retract"));
    public static final SoundEvent BLOCK_SPIKES_EXTEND = new SoundEvent(new Identifier(Main.MOD_ID, "block.spikes.extend"));
    public static final SoundEvent BLOCK_BOO_LANTERN_HIDE = new SoundEvent(new Identifier(Main.MOD_ID, "block.boo_lantern.hide"));
    public static final SoundEvent BLOCK_BOO_LANTERN_REVEAL = new SoundEvent(new Identifier(Main.MOD_ID, "block.boo_lantern.reveal"));

    public static final SoundEvent ITEM_PROJECTILE_THROW = new SoundEvent(new Identifier(Main.MOD_ID, "item.projectile.throw"));
    public static final SoundEvent ITEM_FIRE_FLOWER_SHOOT = new SoundEvent(new Identifier(Main.MOD_ID, "item.fire_flower.shoot"));

    public static final SoundEvent ENTITY_FIREBALL_BOUNCE = new SoundEvent(new Identifier(Main.MOD_ID, "entity.fireball.bounce"));

    public static final SoundEvent ENTITY_GOOMBA_AMBIENT = new SoundEvent(new Identifier(Main.MOD_ID, "entity.goomba.ambient"));
    public static final SoundEvent ENTITY_GOOMBA_HURT = new SoundEvent(new Identifier(Main.MOD_ID, "entity.goomba.hurt"));
    public static final SoundEvent ENTITY_GOOMBA_DEATH = new SoundEvent(new Identifier(Main.MOD_ID, "entity.goomba.death"));
    public static final SoundEvent ENTITY_GOOMBA_STEP = new SoundEvent(new Identifier(Main.MOD_ID, "entity.goomba.step"));

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.warp_pipe.teleport", BLOCK_WARP_PIPE_TELEPORT);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.donut_block.trigger", BLOCK_DONUT_BLOCK_TRIGGER);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.spikes.retract", BLOCK_SPIKES_RETRACT);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.spikes.extend", BLOCK_SPIKES_EXTEND);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.boo_lantern.hide", BLOCK_BOO_LANTERN_HIDE);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:block.boo_lantern.reveal", BLOCK_BOO_LANTERN_REVEAL);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:item.projectile.throw", ITEM_PROJECTILE_THROW);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:item.fire_flower.shoot", ITEM_FIRE_FLOWER_SHOOT);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:entity.fireball.bounce", ENTITY_FIREBALL_BOUNCE);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:entity.goomba.ambient", ENTITY_GOOMBA_AMBIENT);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:entity.goomba.hurt", ENTITY_GOOMBA_HURT);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:entity.goomba.death", ENTITY_GOOMBA_DEATH);
        Registry.register(Registry.SOUND_EVENT, "super_block_world:entity.goomba.step", ENTITY_GOOMBA_STEP);
    }
}
