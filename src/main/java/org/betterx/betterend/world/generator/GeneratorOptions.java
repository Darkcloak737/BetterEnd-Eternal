package org.betterx.betterend.world.generator;

import org.betterx.betterend.config.Configs;

import net.minecraft.core.BlockPos;

import org.jetbrains.annotations.Nullable;

public class GeneratorOptions {
    private static int biomeSizeCaves;
    private static boolean hasPortal;
    private static boolean hasPillars;
    private static boolean hasDragonFights;
    private static boolean changeChorusPlant;
    private static boolean newGenerator;
    private static boolean generateCentralIsland;
    private static boolean generateObsidianPlatform;
    private static int endCityFailChance;
    public static LayerOptions bigOptions;
    public static LayerOptions mediumOptions;
    public static LayerOptions smallOptions;
    private static boolean changeSpawn;
    private static BlockPos spawn;
    private static boolean replacePortal;
    private static boolean replacePillars;
    private static boolean directSpikeHeight;

    public static void init() {
//        Configs.GENERATOR_CONFIG.getAllValues().forEach(
//                v -> {
//                    v.notifyAfterChange(GeneratorOptions::updatedValue);
//                }
//        );
        updatedValue(null);
    }

    private static void updatedValue(@Nullable Object o) {
        biomeSizeCaves = Configs.GENERATOR_CONFIG.biomeSizeCaves.getClamped();
        hasPortal = Configs.GENERATOR_CONFIG.hasPortal.get();
        hasPillars = Configs.GENERATOR_CONFIG.hasPillars.get();
        hasDragonFights = Configs.GENERATOR_CONFIG.hasDragonFights.get();
        changeChorusPlant = Configs.GENERATOR_CONFIG.changeChorusPlant.get();
        newGenerator = Configs.GENERATOR_CONFIG.newGenerator.get();
        generateCentralIsland = Configs.GENERATOR_CONFIG.generateCentralIsland.get();
        endCityFailChance = Configs.GENERATOR_CONFIG.endCityFailChance.get();
        generateObsidianPlatform = Configs.GENERATOR_CONFIG.generateObsidianPlatform.get();

        bigOptions = Configs.GENERATOR_CONFIG.bigOptions.get();
        mediumOptions = Configs.GENERATOR_CONFIG.mediumOptions.get();
        smallOptions = Configs.GENERATOR_CONFIG.smallOptions.get();

        changeSpawn = Configs.GENERATOR_CONFIG.changeSpawn.get();
        spawn = Configs.GENERATOR_CONFIG.spawn.get();
        replacePortal = Configs.GENERATOR_CONFIG.replacePortal.get();
        replacePillars = Configs.GENERATOR_CONFIG.replacePillars.get();
    }

    public static int getBiomeSizeCaves() {
        return biomeSizeCaves;
    }

    public static boolean hasPortal() {
        return hasPortal;
    }

    public static boolean hasPillars() {
        return hasPillars;
    }

    public static boolean hasDragonFights() {
        return hasDragonFights;
    }

    public static boolean changeChorusPlant() {
        return changeChorusPlant;
    }

    public static boolean useNewGenerator() {
        return newGenerator;
    }


    public static boolean generateObsidianPlatform() {
        return generateObsidianPlatform;
    }

    public static int getEndCityFailChance() {
        return endCityFailChance;
    }

    public static boolean changeSpawn() {
        return changeSpawn;
    }

    public static BlockPos getSpawn() {
        return spawn;
    }

    public static boolean replacePortal() {
        return replacePortal;
    }

    public static boolean replacePillars() {
        return replacePillars;
    }


    public static void setDirectSpikeHeight() {
        directSpikeHeight = true;
    }

    public static boolean isDirectSpikeHeight() {
        boolean height = directSpikeHeight;
        directSpikeHeight = false;
        return height;
    }

    public static boolean hasCentralIsland() {
        return generateCentralIsland;
    }


}
