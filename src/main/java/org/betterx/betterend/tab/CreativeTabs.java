package org.betterx.betterend.tab;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.HashSet;
import java.util.Set;

public class CreativeTabs {
    private static final Set<ItemLike> ADDED_ITEMS = new HashSet<>();

    public static final CreativeModeTab ITEMS_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(BetterEnd.MOD_ID, "items"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.betterend.items"))
                    .icon(() -> new ItemStack(EndItems.ETERNAL_CRYSTAL))
                    .displayItems((parameters, output) -> {
                        ADDED_ITEMS.clear();

                        // 1. VIP Items at the top
                        safeAccept(output, EndItems.ETERNAL_CRYSTAL);

                        // 2. Smart Categories (It groups and alphabetizes these)
                        addItemsByKeyword(output, "ingot", "gem", "dust", "shard", "crystal", "petal", "membrane", "matrix"); // Materials
                        addItemsByKeyword(output, "helmet", "chestplate", "leggings", "boots", "elytra"); // Armor
                        addItemsByKeyword(output, "sword", "pickaxe", "axe", "shovel", "hoe", "hammer"); // Tools
                        addItemsByKeyword(output, "raw", "cooked", "berry", "jelly", "juice", "pie", "fish"); // Food
                        addItemsByKeyword(output, "music_disc"); // Music

                        // 3. Catch-all for anything else missed
                        addAllRemaining(output, BuiltInRegistries.ITEM);
                    })
                    .build()
    );

    public static final CreativeModeTab BLOCKS_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(BetterEnd.MOD_ID, "blocks"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.betterend.blocks"))
                    .icon(() -> new ItemStack(EndBlocks.END_MYCELIUM))
                    .displayItems((parameters, output) -> {
                        ADDED_ITEMS.clear();

                        // 1. VIP Blocks
                        safeAccept(output, EndBlocks.END_MYCELIUM);

                        // 2. Smart Categories
                        addBlocksByKeyword(output, "ore"); // Ores
                        addBlocksByKeyword(output, "_block", "obsidian", "brimstone"); // Raw Building Blocks
                        addBlocksByKeyword(output, "nylium", "moss", "dirt", "dust", "path"); // Ground Cover
                        addBlocksByKeyword(output, "log", "bark", "planks"); // Wood Basics
                        addBlocksByKeyword(output, "stairs", "slab", "wall", "fence", "door", "trapdoor", "button", "pressure_plate"); // Architecture
                        addBlocksByKeyword(output, "lantern", "chandelier", "bulb", "lamp"); // Lighting
                        addBlocksByKeyword(output, "pedestal", "forge", "smelter", "anvil", "obelisk"); // Functional/Workstations
                        addBlocksByKeyword(output, "ice", "snow"); // Cold blocks

                        // 3. Catch-all
                        addAllRemaining(output, BuiltInRegistries.BLOCK);
                    })
                    .build()
    );

    public static final CreativeModeTab NATURE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(BetterEnd.MOD_ID, "nature"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.betterend.nature"))
                    .icon(() -> new ItemStack(EndBlocks.TENANEA_FLOWERS))
                    .displayItems((parameters, output) -> {
                        ADDED_ITEMS.clear();

                        // 1. Smart Categories
                        addBlocksByKeyword(output, "sapling"); // Trees start here
                        addBlocksByKeyword(output, "leaves", "cap", "fur", "hymenophore"); // Tree/Mushroom tops
                        addBlocksByKeyword(output, "seed", "spore"); // Plant starters
                        addBlocksByKeyword(output, "flower", "fern", "grass", "vine", "moss", "plant", "root"); // Flora
                    })
                    .build()
    );

    public static void register() {
    }

    // --- SMART SORTING HELPERS BELOW ---

    private static void safeAccept(CreativeModeTab.Output output, ItemLike item) {
        if (item != null && item.asItem() != Items.AIR && !ADDED_ITEMS.contains(item.asItem())) {
            output.accept(item);
            ADDED_ITEMS.add(item.asItem());
        }
    }

    private static void addItemsByKeyword(CreativeModeTab.Output output, String... keywords) {
        BuiltInRegistries.ITEM.entrySet().stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(BetterEnd.MOD_ID))
                .filter(entry -> matchesKeyword(entry.getKey().location().getPath(), keywords))
                .sorted((e1, e2) -> e1.getKey().location().getPath().compareTo(e2.getKey().location().getPath()))
                .forEach(entry -> safeAccept(output, entry.getValue()));
    }

    private static void addBlocksByKeyword(CreativeModeTab.Output output, String... keywords) {
        BuiltInRegistries.BLOCK.entrySet().stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(BetterEnd.MOD_ID))
                .filter(entry -> matchesKeyword(entry.getKey().location().getPath(), keywords))
                .sorted((e1, e2) -> e1.getKey().location().getPath().compareTo(e2.getKey().location().getPath()))
                .forEach(entry -> safeAccept(output, entry.getValue()));
    }

    private static void addAllRemaining(CreativeModeTab.Output output, Registry<?> registry) {
        registry.entrySet().stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(BetterEnd.MOD_ID))
                .sorted((e1, e2) -> e1.getKey().location().getPath().compareTo(e2.getKey().location().getPath()))
                .forEach(entry -> safeAccept(output, (ItemLike) entry.getValue()));
    }

    private static boolean matchesKeyword(String path, String[] keywords) {
        for (String kw : keywords) {
            if (path.contains(kw)) return true;
        }
        return false;
    }
}