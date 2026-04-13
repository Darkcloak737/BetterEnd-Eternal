package org.betterx.betterend.blocks.entities;

import org.betterx.betterend.registry.EndBlockEntities;
import org.betterx.betterend.rituals.EternalRitual;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EternalPedestalEntity extends PedestalBlockEntity {
    private EternalRitual linkedRitual;

    public EternalPedestalEntity(BlockPos blockPos, BlockState blockState) {
        super(EndBlockEntities.ETERNAL_PEDESTAL, blockPos, blockState);
    }

    public boolean hasRitual() {
        return linkedRitual != null;
    }

    public void linkRitual(EternalRitual ritual) {
        this.linkedRitual = ritual;
    }

    public EternalRitual getRitual() {
        return linkedRitual;
    }

    @Override
    public void setLevel(Level level) {
        super.setLevel(level);
        if (hasRitual()) {
            linkedRitual.setWorld(level);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        if (hasRitual()) {
            tag.put("ritual", linkedRitual.toTag(new CompoundTag()));
        }
        super.saveAdditional(tag, provider);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        if (tag.contains("ritual")) {
            linkedRitual = new EternalRitual(level);
            linkedRitual.fromTag(tag.getCompound("ritual"));
        }
        super.loadAdditional(tag, provider);
    }
}
