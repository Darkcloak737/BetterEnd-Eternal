package org.betterx.datagen.betterend.worldgen;

import org.betterx.betterend.integration.byg.biomes.BYGBiomes;
import org.betterx.betterend.integration.byg.biomes.NightshadeRedwoods;
import org.betterx.betterend.integration.byg.biomes.OldBulbisGardens;
import org.betterx.wover.biome.api.builder.BiomeBootstrapContext;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.multi.WoverBiomeProvider;
import org.betterx.wover.tag.api.predefined.CommonBiomeTags;

import org.jetbrains.annotations.NotNull;

public class BYGBiomeProvider extends WoverBiomeProvider {
    public BYGBiomeProvider(@NotNull ModCore modCore) {
        super(modCore);
    }

    @Override
    protected void bootstrap(BiomeBootstrapContext context) {
        BYGBiomes.OLD_BULBIS_GARDENS.bootstrap(context, new OldBulbisGardens(), CommonBiomeTags.IS_END_LAND).register();
        BYGBiomes.NIGHTSHADE_REDWOODS
                .bootstrap(context, new NightshadeRedwoods(), CommonBiomeTags.IS_END_LAND)
                .register();
    }
}
