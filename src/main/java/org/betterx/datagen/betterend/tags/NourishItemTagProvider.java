package org.betterx.datagen.betterend.tags;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndItems;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.TagManager;
import org.betterx.wover.tag.api.event.context.ItemTagBootstrapContext;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class NourishItemTagProvider extends WoverTagProvider.ForItems {
    public NourishItemTagProvider(ModCore modCore) {
        super(BetterEnd.NOURISH);
    }

    @Override
    public void prepareTags(ItemTagBootstrapContext context) {
        TagKey<Item> fats = TagManager.ITEMS.makeTag(BetterEnd.NOURISH, "fats");
        TagKey<Item> fruit = TagManager.ITEMS.makeTag(BetterEnd.NOURISH, "fruit");
        TagKey<Item> protein = TagManager.ITEMS.makeTag(BetterEnd.NOURISH, "protein");
        TagKey<Item> sweets = TagManager.ITEMS.makeTag(BetterEnd.NOURISH, "sweets");


        context.add(fats, EndItems.END_FISH_RAW, EndItems.END_FISH_COOKED);
        context.add(
                fruit,
                EndItems.SHADOW_BERRY_RAW,
                EndItems.SHADOW_BERRY_COOKED,
                EndItems.BLOSSOM_BERRY,
                EndItems.SHADOW_BERRY_JELLY,
                EndItems.SWEET_BERRY_JELLY,
                EndItems.BLOSSOM_BERRY_JELLY,
                EndItems.AMBER_ROOT_RAW,
                EndItems.CHORUS_MUSHROOM_RAW,
                EndItems.CHORUS_MUSHROOM_COOKED,
                EndItems.BOLUX_MUSHROOM_COOKED
        );
        context.add(
                protein,
                EndItems.END_FISH_RAW,
                EndItems.END_FISH_COOKED,
                EndItems.CHORUS_MUSHROOM_COOKED,
                EndItems.BOLUX_MUSHROOM_COOKED,
                EndItems.CAVE_PUMPKIN_PIE
        );
        context.add(
                sweets,
                EndItems.SHADOW_BERRY_JELLY,
                EndItems.SWEET_BERRY_JELLY,
                EndItems.BLOSSOM_BERRY_JELLY,
                EndItems.CAVE_PUMPKIN_PIE
        );
    }
}
