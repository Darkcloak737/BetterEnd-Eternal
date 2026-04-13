package org.betterx.betterend.item;

import org.betterx.betterend.item.material.EndArmorTier;
import org.betterx.betterend.registry.EndAttributes;
import org.betterx.wover.complex.api.equipment.ArmorSlot;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class CrystaliteHelmet extends CrystaliteArmor {
    private static Properties defaultSettings() {
        return EndArmorItem.createDefaultEndArmorSettings(
                ArmorSlot.HELMET_SLOT, EndArmorTier.CRYSTALITE,
                EndArmorItem.startAttributeBuilder(
                        ArmorSlot.HELMET_SLOT,
                        EndArmorTier.CRYSTALITE
                ).add(
                        EndAttributes.BLINDNESS_RESISTANCE,
                        new AttributeModifier(
                                EndArmorItem.BASE_BLINDNESS_RESISTANCE,
                                1.0,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.HEAD
                ).build()
        );
    }

    public CrystaliteHelmet() {
        super(Type.HELMET, defaultSettings());
    }
}
