package org.betterx.betterend.util;

import org.betterx.bclib.api.v3.bonemeal.BonemealAPI;
import org.betterx.bclib.api.v3.bonemeal.WaterGrassSpreader;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndTags;
import org.betterx.betterend.registry.features.EndConfiguredBonemealFeature;

public class BonemealPlants {
    public static void init() {
        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.END_MOSS,
                EndConfiguredBonemealFeature.BONEMEAL_END_MOSS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.RUTISCUS,
                EndConfiguredBonemealFeature.BONEMEAL_RUTISCUS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.END_MYCELIUM,
                EndConfiguredBonemealFeature.BONEMEAL_END_MYCELIUM
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.JUNGLE_MOSS,
                EndConfiguredBonemealFeature.BONEMEAL_JUNGLE_MOSS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.SANGNUM,
                EndConfiguredBonemealFeature.BONEMEAL_SANGNUM
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.MOSSY_OBSIDIAN,
                EndConfiguredBonemealFeature.BONEMEAL_MOSSY_OBSIDIAN
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.MOSSY_DRAGON_BONE,
                EndConfiguredBonemealFeature.BONEMEAL_MOSSY_DRAGON_BONE
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.CAVE_MOSS,
                EndConfiguredBonemealFeature.BONEMEAL_CAVE_MOSS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.CHORUS_NYLIUM,
                EndConfiguredBonemealFeature.BONEMEAL_CHORUS_NYLIUM
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.CRYSTAL_MOSS,
                EndConfiguredBonemealFeature.BONEMEAL_CRYSTAL_MOSS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.SHADOW_GRASS,
                EndConfiguredBonemealFeature.BONEMEAL_SHADOW_GRASS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.PINK_MOSS,
                EndConfiguredBonemealFeature.BONEMEAL_PINK_MOSS
        );

        BonemealAPI.INSTANCE.addSpreadableFeatures(
                EndBlocks.AMBER_MOSS,
                EndConfiguredBonemealFeature.BONEMEAL_AMBER_MOSS
        );


        BonemealAPI.INSTANCE.addSpreadableBlocks(
                EndTags.BONEMEAL_TARGET_WATER_GRASS,
                new WaterGrassSpreader(EndTags.BONEMEAL_SOURCE_WATER_GRASS)
        );

        BonemealAPI.INSTANCE.addSpreadableBlocks(
                EndTags.BONEMEAL_TARGET_DRAGON_BONE,
                EndTags.BONEMEAL_SOURCE_DRAGON_BONE
        );
    }
}
