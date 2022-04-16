/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.GameSettings$Options
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.SetGameOptionEvent;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GameSettings.class})
public class MixinGameSettings {
    public MixinGameSettings() {
        MixinGameSettings llllllllllllllllllllIlIlIllIIIII;
    }

    @Inject(method={"setOptionValue"}, at={@At(value="HEAD")}, cancellable=true)
    public void setOptionValue(GameSettings.Options llllllllllllllllllllIlIlIlIlIlIl, int llllllllllllllllllllIlIlIlIlIlII, CallbackInfo llllllllllllllllllllIlIlIlIlIlll) {
        SetGameOptionEvent llllllllllllllllllllIlIlIlIlIllI = new SetGameOptionEvent(llllllllllllllllllllIlIlIlIlIlIl, llllllllllllllllllllIlIlIlIlIlII);
        ImpactPlus.EVENT_BUS.post(llllllllllllllllllllIlIlIlIlIllI);
        if (llllllllllllllllllllIlIlIlIlIllI.isCancelled()) {
            llllllllllllllllllllIlIlIlIlIlll.cancel();
        }
    }
}

