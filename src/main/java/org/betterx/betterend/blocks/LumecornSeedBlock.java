package org.betterx.betterend.blocks;

import org.betterx.bclib.behaviours.BehaviourBuilders;
import org.betterx.bclib.behaviours.interfaces.BehaviourSeed;
import org.betterx.betterend.blocks.basis.EndPlantWithAgeBlock;
import org.betterx.betterend.interfaces.survives.SurvivesOnEndMoss;
import org.betterx.betterend.registry.features.EndConfiguredVegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class LumecornSeedBlock extends EndPlantWithAgeBlock implements BehaviourSeed, SurvivesOnEndMoss {

    public LumecornSeedBlock() {
        super(BehaviourBuilders.createSeed(MapColor.COLOR_LIGHT_BLUE));
    }

    @Override
    public void growAdult(WorldGenLevel world, RandomSource random, BlockPos pos) {
        EndConfiguredVegetation.LUMECORN.placeInWorld(world, pos, random);
    }

    @Override
    public boolean isTerrain(BlockState state) {
        return SurvivesOnEndMoss.super.isTerrain(state);
    }
}
