/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventCanCollideCheck;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockLiquid.class})
public class MixinBlockLiquid {
    @Inject(method={"canCollideCheck"}, at={@At(value="HEAD")}, cancellable=true)
    public void canCollideCheck(IBlockState llllllllllllllllIIlIllllIIIIlllI, boolean llllllllllllllllIIlIllllIIIIllIl, CallbackInfoReturnable<Boolean> llllllllllllllllIIlIllllIIIIlIlI) {
        EventCanCollideCheck llllllllllllllllIIlIllllIIIIlIll = new EventCanCollideCheck();
        ImpactPlus.EVENT_BUS.post(llllllllllllllllIIlIllllIIIIlIll);
        llllllllllllllllIIlIllllIIIIlIlI.setReturnValue(llllllllllllllllIIlIllllIIIIlIll.isCancelled());
    }

    public MixinBlockLiquid() {
        MixinBlockLiquid llllllllllllllllIIlIllllIIIlIIlI;
    }
}

