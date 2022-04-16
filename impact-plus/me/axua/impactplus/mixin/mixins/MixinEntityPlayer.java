/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PlayerTravelEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityPlayer.class}, priority=0x7FFFFFFF)
public abstract class MixinEntityPlayer
extends EntityLivingBase {
    public MixinEntityPlayer(World lllllllllllllllllIlIIIllIIllllII) {
        super(lllllllllllllllllIlIIIllIIllllII);
        MixinEntityPlayer lllllllllllllllllIlIIIllIlIIIIII;
    }

    @Inject(method={"travel"}, at={@At(value="HEAD")}, cancellable=true)
    public void travel(float lllllllllllllllllIlIIIllIIlIllll, float lllllllllllllllllIlIIIllIIlIllII, float lllllllllllllllllIlIIIllIIlIlIlI, CallbackInfo lllllllllllllllllIlIIIllIIlIlIIl) {
        PlayerTravelEvent lllllllllllllllllIlIIIllIIlIlIII = new PlayerTravelEvent();
        ImpactPlus.EVENT_BUS.post(lllllllllllllllllIlIIIllIIlIlIII);
        if (lllllllllllllllllIlIIIllIIlIlIII.isCancelled()) {
            MixinEntityPlayer lllllllllllllllllIlIIIllIIlIIlll;
            lllllllllllllllllIlIIIllIIlIIlll.moveEntity(MoverType.SELF, lllllllllllllllllIlIIIllIIlIIlll.motionX, lllllllllllllllllIlIIIllIIlIIlll.motionY, lllllllllllllllllIlIIIllIIlIIlll.motionZ);
            lllllllllllllllllIlIIIllIIlIlIIl.cancel();
        }
    }
}

