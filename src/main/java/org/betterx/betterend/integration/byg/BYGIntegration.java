package org.betterx.betterend.integration.byg;

import org.betterx.bclib.integration.ModIntegration;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.integration.EndBiomeIntegration;
import org.betterx.betterend.integration.byg.biomes.BYGBiomes;
import org.betterx.betterend.integration.byg.features.BYGFeatures;

public class BYGIntegration extends ModIntegration implements EndBiomeIntegration {
    public BYGIntegration() {
        super(BetterEnd.BYG);
    }

    @Override
    public void init() {
        BYGBlocks.register();
        BYGFeatures.register();
        BYGBiomes.register();
    }

    @Override
    public void initDatagen() {
        BYGBlocks.register();
        BYGFeatures.register();
        BYGBiomes.register();
    }

    @Override
    public void addBiomes() {
        BYGBiomes.addBiomes();
    }
}
