package org.betterx.betterend.world.generator;

import net.minecraft.util.Mth;

import com.google.gson.JsonObject;

public class LayerOptions {
    public final float distance;
    public final float scale;
    private final float rawCoverage;
    public final float coverage;
    public final float averageHeight;
    public final float heightVariation;
    public final float minY;
    public final float maxY;
    public final long centerDist;
    public final boolean hasCentralIsland;

    public LayerOptions(
            float distance,
            float scale,
            float averageHeight,
            float heightVariation,
            boolean hasCentral
    ) {
        this.distance = distance;
        this.scale = scale;
        this.averageHeight = averageHeight;
        this.heightVariation = heightVariation;
        this.rawCoverage = 0.5f;
        this.coverage = clampCoverage(0.5f);
        this.hasCentralIsland = hasCentral;

        this.minY = this.averageHeight - this.heightVariation;
        this.maxY = this.averageHeight + this.heightVariation;
        this.centerDist = Mth.floor(1000 / this.distance);
    }

    public LayerOptions(
            JsonObject config
    ) {
        this.distance = clampDistance(config.get("distance").getAsFloat());
        this.scale = clampScale(config.get("scale").getAsFloat());
        this.averageHeight = clampAverageHeight(config.get("average_height").getAsFloat());
        this.heightVariation = clampVariation(config.get("height_variation").getAsFloat());
        this.rawCoverage = config.get("coverage").getAsFloat();
        this.coverage = clampCoverage(this.rawCoverage);
        this.hasCentralIsland = config.get("contains_central_island").getAsBoolean();

        this.minY = this.averageHeight - this.heightVariation;
        this.maxY = this.averageHeight + this.heightVariation;
        this.centerDist = Mth.floor(1000 / this.distance);

    }

    private float clampDistance(float value) {
        return Mth.clamp(value, 1, 8192);
    }

    private float clampScale(float value) {
        return Mth.clamp(value, 0.1F, 1024);
    }

    private float clampCoverage(float value) {
        return 0.9999F - Mth.clamp(value, 0, 1) * 2;
    }

    private float clampAverageHeight(float value) {
        return Mth.clamp(value, 0, 1.0f);
    }

    private float clampVariation(float value) {
        return Mth.clamp(value, 0, 1.0f);
    }

    public JsonObject toJson() {
        JsonObject obj = new JsonObject();
        obj.addProperty("distance", clampDistance(this.distance));
        obj.addProperty("scale", clampScale(this.scale));
        obj.addProperty("average_height", clampAverageHeight(this.averageHeight));
        obj.addProperty("height_variation", clampVariation(this.heightVariation));
        obj.addProperty("coverage", this.rawCoverage);
        obj.addProperty("contains_central_island", this.hasCentralIsland);
        return obj;
    }
}
