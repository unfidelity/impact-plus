/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.entity.RenderPlayer
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.module.ModuleManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderPlayer.class}, priority=0x7FFFFFFF)
public class MixinRenderPlayer {
    public MixinRenderPlayer() {
        MixinRenderPlayer lllIIlllIllllII;
    }

    @Inject(method={"renderEntityName"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderLivingLabel(AbstractClientPlayer lllIIlllIllIIII, double lllIIlllIlIllll, double lllIIlllIlIlllI, double lllIIlllIlIllIl, String lllIIlllIlIllII, double lllIIlllIlIlIll, CallbackInfo lllIIlllIlIlIlI) {
        if (ModuleManager.isModuleEnabled("NameTags")) {
            lllIIlllIlIlIlI.cancel();
        }
    }
}

