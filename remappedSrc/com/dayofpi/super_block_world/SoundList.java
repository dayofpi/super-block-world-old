package com.dayofpi.super_block_world;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundList {

    // Identifiers
    protected static final Identifier ITEM_IN_ID = new Identifier(Main.MOD_ID, "block.item_in");
    protected static final Identifier ITEM_OUT_ID = new Identifier(Main.MOD_ID, "block.item_out");
    protected static final Identifier COIN_ID = new Identifier(Main.MOD_ID, "block.coin");
    protected static final Identifier PLUCK_ID = new Identifier(Main.MOD_ID, "block.pluck");
    protected static final Identifier TRAMPOLINE_ID = new Identifier(Main.MOD_ID, "block.trampoline");
    protected static final Identifier POWERED_TRAMPOLINE_ID = new Identifier(Main.MOD_ID, "block.powered_trampoline");
    protected static final Identifier block_booLantern_Off_ID = new Identifier(Main.MOD_ID, "block.boo_lantern.off");
    protected static final Identifier block_booLantern_On_ID = new Identifier(Main.MOD_ID, "block.boo_lantern.on");
    protected static final Identifier ONE_UP_ID = new Identifier(Main.MOD_ID, "item.one_up");
    protected static final Identifier BREAK_ID = new Identifier(Main.MOD_ID, "item.break");
    protected static final Identifier JUMP_ID = new Identifier(Main.MOD_ID, "item.jump");
    protected static final Identifier STOMP_ID = new Identifier(Main.MOD_ID, "item.stomp");
    protected static final Identifier BOUNCE_ID = new Identifier(Main.MOD_ID, "item.bounce");
    protected static final Identifier MOO_MOO_IDLE_ID = new Identifier(Main.MOD_ID, "entity.moo_moo.idle");
    protected static final Identifier MOO_MOO_HURT_ID = new Identifier(Main.MOD_ID, "entity.moo_moo.hurt");
    protected static final Identifier MOO_MOO_DEATH_ID = new Identifier(Main.MOD_ID, "entity.moo_moo.death");
    protected static final Identifier MOO_MOO_STEP_ID = new Identifier(Main.MOD_ID, "entity.moo_moo.step");

    protected static final Identifier GOOMBA_AMBIENT_ID = new Identifier(Main.MOD_ID, "entity.goomba.idle");
    protected static final Identifier GOOMBA_HURT_ID = new Identifier(Main.MOD_ID, "entity.goomba.hurt");
    protected static final Identifier GOOMBA_DEATH_ID = new Identifier(Main.MOD_ID, "entity.goomba.death");

    protected static final Identifier BOO_AMBIENT_ID = new Identifier(Main.MOD_ID, "entity.boo.ambient");
    protected static final Identifier BOO_HURT_ID = new Identifier(Main.MOD_ID, "entity.boo.hurt");
    protected static final Identifier BOO_DEATH_ID = new Identifier(Main.MOD_ID, "entity.boo.death");
    protected static final Identifier BOO_LAUGH_ID = new Identifier(Main.MOD_ID, "entity.boo.laugh");
    protected static final Identifier BOO_SHY_ID = new Identifier(Main.MOD_ID, "entity.boo.shy");

    protected static final Identifier BUZZY_BEETLE_HURT_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.hurt");
    protected static final Identifier BUZZY_BEETLE_DEATH_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.death");
    protected static final Identifier BUZZY_BEETLE_DROP_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.drop");
    protected static final Identifier BUZZY_BEETLE_LAND_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.land");
    protected static final Identifier BUZZY_BEETLE_BLOCK_ID = new Identifier(Main.MOD_ID, "entity.buzzy_beetle.block");

    // Events
    public static final SoundEvent blockItemIn = new SoundEvent(ITEM_IN_ID);
    public static final SoundEvent blockItemOut = new SoundEvent(ITEM_OUT_ID);
    public static final SoundEvent blockCoin = new SoundEvent(COIN_ID);
    public static final SoundEvent blockPluck = new SoundEvent(PLUCK_ID);
    public static final SoundEvent blockTrampoline = new SoundEvent(TRAMPOLINE_ID);
    public static final SoundEvent blockPoweredTrampoline = new SoundEvent(POWERED_TRAMPOLINE_ID);
    public static final SoundEvent block_booLantern_Off = new SoundEvent(block_booLantern_Off_ID);
    public static final SoundEvent block_booLantern_On = new SoundEvent(block_booLantern_On_ID);
    public static final SoundEvent itemOneUp = new SoundEvent(ONE_UP_ID);
    public static final SoundEvent BREAK = new SoundEvent(BREAK_ID);
    public static final SoundEvent jumpBoots_jump = new SoundEvent(JUMP_ID);
    public static final SoundEvent jumpBoots_stomp = new SoundEvent(STOMP_ID);
    public static final SoundEvent item_jumpBoots_bounce = new SoundEvent(BOUNCE_ID);
    public static final SoundEvent mooMooAmbient = new SoundEvent(MOO_MOO_IDLE_ID);
    public static final SoundEvent mooMooHurt = new SoundEvent(MOO_MOO_HURT_ID);
    public static final SoundEvent mooMooDeath = new SoundEvent(MOO_MOO_DEATH_ID);
    public static final SoundEvent mooMooStep = new SoundEvent(MOO_MOO_STEP_ID);

    public static final SoundEvent goombaAmbient = new SoundEvent(GOOMBA_AMBIENT_ID);
    public static final SoundEvent goombaHurt = new SoundEvent(GOOMBA_HURT_ID);
    public static final SoundEvent goombaDeath = new SoundEvent(GOOMBA_DEATH_ID);

    public static final SoundEvent booAmbient = new SoundEvent(BOO_AMBIENT_ID);
    public static final SoundEvent booHurt = new SoundEvent(BOO_HURT_ID);
    public static final SoundEvent booDeath = new SoundEvent(BOO_DEATH_ID);
    public static final SoundEvent booShy = new SoundEvent(BOO_SHY_ID);
    public static final SoundEvent booLaugh = new SoundEvent(BOO_LAUGH_ID);
    public static final SoundEvent buzzyHurt = new SoundEvent(BUZZY_BEETLE_HURT_ID);
    public static final SoundEvent buzzyDeath = new SoundEvent(BUZZY_BEETLE_DEATH_ID);
    public static final SoundEvent buzzyDrop = new SoundEvent(BUZZY_BEETLE_DROP_ID);
    public static final SoundEvent buzzyLand = new SoundEvent(BUZZY_BEETLE_LAND_ID);
    public static final SoundEvent buzzyBlock = new SoundEvent(BUZZY_BEETLE_BLOCK_ID);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, ITEM_IN_ID, blockItemIn);
        Registry.register(Registry.SOUND_EVENT, ITEM_OUT_ID, blockItemOut);
        Registry.register(Registry.SOUND_EVENT, COIN_ID, blockCoin);
        Registry.register(Registry.SOUND_EVENT, PLUCK_ID, blockPluck);
        Registry.register(Registry.SOUND_EVENT, TRAMPOLINE_ID, blockTrampoline);
        Registry.register(Registry.SOUND_EVENT, POWERED_TRAMPOLINE_ID, blockPoweredTrampoline);
        Registry.register(Registry.SOUND_EVENT, block_booLantern_Off_ID, block_booLantern_Off);
        Registry.register(Registry.SOUND_EVENT, block_booLantern_On_ID, block_booLantern_On);
        Registry.register(Registry.SOUND_EVENT, ONE_UP_ID, itemOneUp);
        Registry.register(Registry.SOUND_EVENT, BREAK_ID, BREAK);
        Registry.register(Registry.SOUND_EVENT, JUMP_ID, jumpBoots_jump);
        Registry.register(Registry.SOUND_EVENT, STOMP_ID, jumpBoots_stomp);
        Registry.register(Registry.SOUND_EVENT, BOUNCE_ID, item_jumpBoots_bounce);
        Registry.register(Registry.SOUND_EVENT, MOO_MOO_IDLE_ID, mooMooAmbient);
        Registry.register(Registry.SOUND_EVENT, MOO_MOO_HURT_ID, mooMooHurt);
        Registry.register(Registry.SOUND_EVENT, MOO_MOO_DEATH_ID, mooMooDeath);
        Registry.register(Registry.SOUND_EVENT, MOO_MOO_STEP_ID, mooMooStep);
        Registry.register(Registry.SOUND_EVENT, GOOMBA_AMBIENT_ID, goombaAmbient);
        Registry.register(Registry.SOUND_EVENT, GOOMBA_HURT_ID, goombaHurt);
        Registry.register(Registry.SOUND_EVENT, GOOMBA_DEATH_ID, goombaDeath);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_HURT_ID, buzzyHurt);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_DEATH_ID, buzzyDeath);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_DROP_ID, buzzyDrop);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_LAND_ID, buzzyLand);
        Registry.register(Registry.SOUND_EVENT, BUZZY_BEETLE_BLOCK_ID, buzzyBlock);
    }
}
