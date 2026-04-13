package org.betterx.betterend.interfaces.survives;

import org.betterx.bclib.interfaces.SurvivesOnTags;
import org.betterx.wover.tag.api.predefined.CommonBlockTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.List;

public interface SurvivesOnEndStoneOrTrees extends SurvivesOnTags {
    List<TagKey<Block>> TAGS = List.of(CommonBlockTags.END_STONES, BlockTags.LEAVES, BlockTags.LOGS);

    @Override
    default List<TagKey<Block>> getSurvivableTags() {
        return TAGS;
    }
}
