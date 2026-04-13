package org.betterx.betterend.blocks;

import org.betterx.betterend.blocks.basis.PottableFeatureSapling;
import org.betterx.betterend.interfaces.survives.SurvivesOnMossOrDust;
import org.betterx.betterend.registry.features.EndConfiguredVegetation;
import org.betterx.betterend.world.features.trees.LacugroveFeature;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LacugroveSaplingBlock extends PottableFeatureSapling<LacugroveFeature, NoneFeatureConfiguration> implements SurvivesOnMossOrDust {
    public LacugroveSaplingBlock() {
        super((level, pos, state, rnd) -> EndConfiguredVegetation.LACUGROVE.placeInWorld(level, pos, rnd));
    }
}
