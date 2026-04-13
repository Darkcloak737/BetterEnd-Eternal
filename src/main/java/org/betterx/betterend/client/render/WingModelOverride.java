package org.betterx.betterend.client.render;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public interface WingModelOverride<T extends LivingEntity> {
    ResourceLocation wingTextureOverride(T livingEntity);
}
