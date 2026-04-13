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

public class CrystaliteBoots extends CrystaliteArmor implements MobEffectApplier {
    private static Properties defaultSettings() {
        return EndArmorItem.createDefaultEndArmorSettings(
                ArmorSlot.BOOTS_SLOT, EndArmorTier.CRYSTALITE,
                EndArmorItem.startAttributeBuilder(
                        ArmorSlot.BOOTS_SLOT,
                        EndArmorTier.CRYSTALITE
                ).build()
        );
    }

    public CrystaliteBoots() {
        super(Type.BOOTS, defaultSettings());
    }

    @Override
    public void applyEffect(LivingEntity owner) {
        if ((owner.tickCount & 63) == 0) {
            owner.addEffect(new MobEffectInstance(EndStatusEffects.CRYSTALITE_MOVE_SPEED));
        }
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
        lines.add(2, BOOTS_DESC);
    }
}
