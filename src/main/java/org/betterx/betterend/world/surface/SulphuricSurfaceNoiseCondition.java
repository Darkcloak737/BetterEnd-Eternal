package org.betterx.betterend.world.surface;

import org.betterx.bclib.util.MHelper;
import org.betterx.betterend.noise.OpenSimplexNoise;
import org.betterx.wover.surface.api.conditions.SurfaceRulesContext;
import org.betterx.wover.surface.api.noise.NumericProvider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

/**
 * Noise source that returns a value in [0, 3]
 */
public class SulphuricSurfaceNoiseCondition implements NumericProvider {
    public static final SulphuricSurfaceNoiseCondition DEFAULT = new SulphuricSurfaceNoiseCondition();
    public static final MapCodec<SulphuricSurfaceNoiseCondition> CODEC = Codec.BYTE.fieldOf("sulphuric_surf")
                                                                                   .xmap((obj) -> DEFAULT, obj -> (byte) 0);

    private static final OpenSimplexNoise NOISE = new OpenSimplexNoise(5123);

    @Override
    public int getNumber(SurfaceRulesContext context) {
        final int x = context.getBlockX();
        final int z = context.getBlockZ();
        final double value = NOISE.eval(x * 0.03, z * 0.03) + NOISE.eval(
                x * 0.1,
                z * 0.1
        ) * 0.3 + MHelper.randRange(
                -0.1,
                0.1,
                MHelper.RANDOM_SOURCE
        );
        if (value < -0.6) return 0;
        if (value < -0.3) return 1;
        if (value < 0.5) return 2;
        return 3;
    }

    @Override
    public MapCodec<? extends NumericProvider> pcodec() {
        return CODEC;
    }

}
