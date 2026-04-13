package org.betterx.betterend.registry.features;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndFeatures;
import org.betterx.betterend.world.features.terrain.SulphuricLakeFeature;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureKey;
import org.betterx.wover.feature.api.configured.ConfiguredFeatureManager;
import org.betterx.wover.feature.api.configured.configurators.WithConfiguration;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class EndConfiguredLakeFeature {
    public static final ConfiguredFeatureKey<WithConfiguration<SulphuricLakeFeature, NoneFeatureConfiguration>> SULPHURIC_LAKE = ConfiguredFeatureManager
            .configuration(BetterEnd.C.mk("sulphuric_lake"), EndFeatures.SULPHURIC_LAKE_FEATURE);
}
