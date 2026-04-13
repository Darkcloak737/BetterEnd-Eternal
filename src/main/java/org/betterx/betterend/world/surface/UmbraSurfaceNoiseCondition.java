package org.betterx.betterend.world.surface;

import org.betterx.bclib.util.MHelper;
import org.betterx.betterend.noise.OpenSimplexNoise;
import org.betterx.wover.surface.api.conditions.SurfaceRulesContext;
import org.betterx.wover.surface.api.noise.NumericProvider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

/**
 * Noise source that returns a value in [0, 4]
 */
public class UmbraSurfaceNoiseCondition implements NumericProvider {
    public static final UmbraSurfaceNoiseCondition DEFAULT = new UmbraSurfaceNoiseCondition();
    public static final MapCodec<UmbraSurfaceNoiseCondition> CODEC = Codec.BYTE.fieldOf("umbra_srf")
                                                                               .xmap((obj) -> DEFAULT, obj -> (byte) 0);

    private static final OpenSimplexNoise NOISE = new OpenSimplexNoise(1512);

    @Override
    public int getNumber(SurfaceRulesContext context) {
        final int x = context.getBlockX();
        final int z = context.getBlockZ();
        return getDepth(x, z);
    }

    public static int getDepth(int x, int z) {
        final double value = NOISE.eval(x * 0.03, z * 0.03) + NOISE.eval(
                x * 0.1,
                z * 0.1
        ) * 0.3 + MHelper.randRange(
                -0.1,
                0.1,
                MHelper.RANDOM_SOURCE
        );
        if (value > 0.4) return 0;
        if (value > 0.15) return 1;
        if (value > -0.15) return 2;
        if (value > -0.4) return 3;
        return 4;
    }

    @Override
    public MapCodec<? extends NumericProvider> pcodec() {
        return CODEC;
    }
}
