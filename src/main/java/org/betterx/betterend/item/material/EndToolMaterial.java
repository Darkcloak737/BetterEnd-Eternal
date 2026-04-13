package org.betterx.betterend.item.material;

import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;
import org.betterx.betterend.registry.EndTags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public enum EndToolMaterial implements Tier {
    THALLASIUM(Tiers.IRON.getIncorrectBlocksForDrops(), 2, 320, 7.0F, 1.5F, 12, () -> EndBlocks.THALLASIUM.ingot),
    TERMINITE(Tiers.DIAMOND.getIncorrectBlocksForDrops(), 3, 1230, 8.5F, 3.0F, 14, () -> EndBlocks.TERMINITE.ingot),
    AETERNIUM(EndTags.INCORRECT_FOR_AETERNIUM_TOOL, 5, 2196, 10.0F, 4.5F, 18, () -> EndItems.AETERNIUM_INGOT);

    private final int uses;
    private final float speed;
    private final int level;
    private final int enchantibility;
    private final float damage;
    private final Supplier<ItemLike> reapair;
    public final TagKey<Block> incorrectBlocksForDrops;

    EndToolMaterial(
            TagKey<Block> incorrectBlocksForDrops,
            int level,
            int uses,
            float speed,
            float damage,
            int enchantibility,
            Supplier<ItemLike> reapair
    ) {

        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.level = level;
        this.enchantibility = enchantibility;
        this.damage = damage;
        this.reapair = reapair;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantibility;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.of(reapair.get());
    }

}
