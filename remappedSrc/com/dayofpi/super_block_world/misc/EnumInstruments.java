package com.dayofpi.super_block_world.misc;

import net.minecraft.block.enums.Instrument;

public class EnumInstruments {
    static {
        Instrument.values(); // Ensure class is loaded before the variant is accessed
    }

    public static Instrument BLING;
}
