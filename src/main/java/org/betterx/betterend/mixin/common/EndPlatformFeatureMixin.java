package org.betterx.betterend.mixin.common;

import org.betterx.betterend.world.generator.TerrainGenerator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.feature.EndPlatformFeature;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndPlatformFeature.class)
public class EndPlatformFeatureMixin {
    @Inject(method = "createEndPlatform", at = @At("HEAD"), cancellable = true)
    private static void be_createEndSpawnPlatform(
            ServerLevelAccessor serverLevelAccessor,
            BlockPos blockPos,
            boolean bl,
            CallbackInfo info
    ) {
        TerrainGenerator.makeObsidianPlatform(serverLevelAccessor, info);
    }
}
