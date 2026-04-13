package org.betterx.betterend.item;

import org.betterx.betterend.effects.EndStatusEffects;
import org.betterx.betterend.interfaces.MobEffectApplier;
import org.betterx.betterend.item.material.EndArmorTier;
import org.betterx.wover.complex.api.equipment.ArmorSlot;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CrystaliteChestplate extends CrystaliteArmor implements MobEffectApplier {
    private static Properties defaultSettings() {
        return EndArmorItem.createDefaultEndArmorSettings(
                ArmorSlot.CHESTPLATE_SLOT, EndArmorTier.CRYSTALITE,
                EndArmorItem.startAttributeBuilder(
                        ArmorSlot.CHESTPLATE_SLOT,
                        EndArmorTier.CRYSTALITE
                ).build()
        );
    }

    public CrystaliteChestplate() {
        super(Type.CHESTPLATE, defaultSettings());
    }

    @Override
    public void applyEffect(LivingEntity owner) {
        owner.addEffect(new MobEffectInstance(EndStatusEffects.CRYSTALITE_DIG_SPEED));
    }

    @Override
    public void appendHoverText(
            ItemStack itemStack,
            TooltipContext tooltipContext,
            List<Component> lines,
            TooltipFlag tooltipFlag
    ) {
        super.appendHoverText(itemStack, tooltipContext, lines, tooltipFlag);
        lines.add(1, Component.empty());
        lines.add(2, CHEST_DESC);
    }
}
