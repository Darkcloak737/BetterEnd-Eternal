package org.betterx.betterend.registry.features;

import org.betterx.betterend.BetterEnd;
import org.betterx.wover.feature.api.placed.PlacedConfiguredFeatureKey;
import org.betterx.wover.feature.api.placed.PlacedFeatureKey;
import org.betterx.wover.feature.api.placed.PlacedFeatureManager;

import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class EndLakeFeatures {
    public static final PlacedFeatureKey END_LAKE = PlacedFeatureManager
            .createKey(BetterEnd.C.mk("end_lake"))
            .setDecoration(Decoration.LAKES);

    public static final PlacedFeatureKey END_LAKE_NORMAL = PlacedFeatureManager
            .createKey(BetterEnd.C.mk("end_lake_normal"))
            .setDecoration(Decoration.LAKES);

    public static final PlacedFeatureKey END_LAKE_RARE = PlacedFeatureManager
            .createKey(BetterEnd.C.mk("end_lake_rare"))
            .setDecoration(Decoration.LAKES);

    public static final PlacedFeatureKey DESERT_LAKE = PlacedFeatureManager
            .createKey(BetterEnd.C.mk("desert_lake"))
            .setDecoration(Decoration.LAKES);

    public static final PlacedConfiguredFeatureKey SULPHURIC_LAKE = PlacedFeatureManager
            .createKey(EndConfiguredLakeFeature.SULPHURIC_LAKE)
            .setDecoration(Decoration.LAKES);
}
