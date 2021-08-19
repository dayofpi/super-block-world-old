package com.dayofpi.super_block_world.items.types;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class ShellItem extends ArmorItem {
    public ShellItem(ArmorMaterial material, EntityType entityType, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
}
