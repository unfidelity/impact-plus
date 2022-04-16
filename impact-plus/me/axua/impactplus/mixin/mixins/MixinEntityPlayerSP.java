/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.MoverType
 *  net.minecraft.util.EnumHand
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.ImpactPlusEvent;
import me.axua.impactplus.event.events.EventPlayerMotionUpdate;
import me.axua.impactplus.event.events.EventPlayerSwingArm;
import me.axua.impactplus.event.events.PlayerMoveEvent;
import me.axua.impactplus.event.events.PushOutBlockEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP
extends AbstractClientPlayer {
    @Redirect(method={"move"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/AbstractClientPlayer;move(Lnet/minecraft/entity/MoverType;DDD)V"))
    public void move(AbstractClientPlayer lllllllllllllllllIIIlIIIIIlIIIll, MoverType lllllllllllllllllIIIlIIIIIIlllII, double lllllllllllllllllIIIlIIIIIlIIIIl, double lllllllllllllllllIIIlIIIIIlIIIII, double lllllllllllllllllIIIlIIIIIIllIIl) {
        MixinEntityPlayerSP lllllllllllllllllIIIlIIIIIlIIlII;
        PlayerMoveEvent lllllllllllllllllIIIlIIIIIIllllI = new PlayerMoveEvent(lllllllllllllllllIIIlIIIIIIlllII, lllllllllllllllllIIIlIIIIIlIIIIl, lllllllllllllllllIIIlIIIIIlIIIII, lllllllllllllllllIIIlIIIIIIllIIl);
        ImpactPlus.EVENT_BUS.post(lllllllllllllllllIIIlIIIIIIllllI);
        if (lllllllllllllllllIIIlIIIIIIllllI.isCancelled()) {
            // empty if block
        }
        super.moveEntity(lllllllllllllllllIIIlIIIIIIlllII, lllllllllllllllllIIIlIIIIIIllllI.x, lllllllllllllllllIIIlIIIIIIllllI.y, lllllllllllllllllIIIlIIIIIIllllI.z);
    }

    @Inject(method={"pushOutOfBlocks"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPushOutOfBlocks(double lllllllllllllllllIIIlIIIIIIlIlII, double lllllllllllllllllIIIlIIIIIIlIIll, double lllllllllllllllllIIIlIIIIIIlIIlI, CallbackInfoReturnable<Boolean> lllllllllllllllllIIIlIIIIIIIllll) {
        PushOutBlockEvent lllllllllllllllllIIIlIIIIIIlIIII = new PushOutBlockEvent();
        ImpactPlus.EVENT_BUS.post(lllllllllllllllllIIIlIIIIIIlIIII);
        if (lllllllllllllllllIIIlIIIIIIlIIII.isCancelled()) {
            lllllllllllllllllIIIlIIIIIIIllll.setReturnValue(false);
        }
    }

    public MixinEntityPlayerSP() {
        super(null, null);
        MixinEntityPlayerSP lllllllllllllllllIIIlIIIIlIIIlII;
    }

    @Inject(method={"swingArm"}, at={@At(value="HEAD")}, cancellable=true)
    public void swingArm(EnumHand lllllllllllllllllIIIlIIIIIlIllIl, CallbackInfo lllllllllllllllllIIIlIIIIIlIllll) {
        EventPlayerSwingArm lllllllllllllllllIIIlIIIIIlIlllI = new EventPlayerSwingArm(lllllllllllllllllIIIlIIIIIlIllIl);
        ImpactPlus.EVENT_BUS.post(lllllllllllllllllIIIlIIIIIlIlllI);
        if (lllllllllllllllllIIIlIIIIIlIlllI.isCancelled()) {
            lllllllllllllllllIIIlIIIIIlIllll.cancel();
        }
    }

    @Inject(method={"onUpdateWalkingPlayer"}, at={@At(value="RETURN")}, cancellable=true)
    public void OnPostUpdateWalkingPlayer(CallbackInfo lllllllllllllllllIIIlIIIIIlllIII) {
        EventPlayerMotionUpdate lllllllllllllllllIIIlIIIIIllIlll = new EventPlayerMotionUpdate(ImpactPlusEvent.Era.POST);
        ImpactPlus.EVENT_BUS.post(lllllllllllllllllIIIlIIIIIllIlll);
        if (lllllllllllllllllIIIlIIIIIllIlll.isCancelled()) {
            lllllllllllllllllIIIlIIIIIlllIII.cancel();
        }
    }

    @Inject(method={"onUpdateWalkingPlayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void OnPreUpdateWalkingPlayer(CallbackInfo lllllllllllllllllIIIlIIIIIllllll) {
        EventPlayerMotionUpdate lllllllllllllllllIIIlIIIIIlllllI = new EventPlayerMotionUpdate(ImpactPlusEvent.Era.PRE);
        ImpactPlus.EVENT_BUS.post(lllllllllllllllllIIIlIIIIIlllllI);
        if (lllllllllllllllllIIIlIIIIIlllllI.isCancelled()) {
            lllllllllllllllllIIIlIIIIIllllll.cancel();
        }
    }
}

