package org.betterx.betterend.mixin.common.portal;

import org.betterx.betterend.portal.TravelingEntity;

import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(Entity.class)
public class EntityMixin implements TravelingEntity {

//    private final TravelerState be_travelerState = TravelerState.init((net.minecraft.world.entity.Entity) (Object) this);
//
//    public TravelerState be_getTravelerState() {
//        return be_travelerState;
//    }
//
//    @Inject(method = "handleNetherPortal", at = @At("HEAD"))
//    void be_handleNetherPortal(CallbackInfo ci) {
//        if (be_travelerState != null) be_travelerState.portalTick();
//    }
//
//    @Inject(method = "findDimensionEntryPoint", at = @At("HEAD"), cancellable = true)
//    void be_findDimensionEntryPoint(ServerLevel serverLevel, CallbackInfoReturnable<PortalInfo> cir) {
////        if (be_travelerState != null) {
////            PortalInfo pi = be_travelerState.findDimensionEntryPoint(serverLevel);
////            if (pi != null) cir.setReturnValue(pi);
////        }
//    }
}
