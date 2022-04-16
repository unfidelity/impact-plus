/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.tileentity.TileEntitySignRenderer
 *  net.minecraft.tileentity.TileEntitySign
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventRenderSign;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.tileentity.TileEntitySign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TileEntitySignRenderer.class})
public class MixinTileEntitySignRenderer {
    public MixinTileEntitySignRenderer() {
        MixinTileEntitySignRenderer llllIlIIlllllII;
    }

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    public void render(TileEntitySign llllIlIIllllIII, double llllIlIIlllIlll, double llllIlIIlllIllI, double llllIlIIlllIlIl, float llllIlIIlllIlII, int llllIlIIlllIIll, float llllIlIIlllIIlI, CallbackInfo llllIlIIlllIIIl) {
        EventRenderSign llllIlIIlllIIII = new EventRenderSign();
        ImpactPlus.EVENT_BUS.post(llllIlIIlllIIII);
        if (llllIlIIlllIIII.isCancelled()) {
            llllIlIIlllIIIl.cancel();
        }
    }
}

