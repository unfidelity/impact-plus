/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.render.SkyColour;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={RenderGlobal.class})
public class MixinRenderGlobal {
    @Redirect(method={"renderSky(FI)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;getSkyColor(Lnet/minecraft/entity/Entity;F)Lnet/minecraft/util/math/Vec3d;"))
    public Vec3d getSkyColorRedirect(WorldClient llllIIlIlIIlIIl, Entity llllIIlIlIIIlIl, float llllIIlIlIIIlII) {
        SkyColour llllIIlIlIIIllI = (SkyColour)ModuleManager.getModuleByName("SkyColour");
        if (ModuleManager.isModuleEnabled("SkyColour")) {
            int llllIIlIlIIlllI = Minecraft.getMinecraft().thePlayer.dimension;
            float llllIIlIlIIllIl = 0.0f;
            float llllIIlIlIIllII = 0.0f;
            float llllIIlIlIIlIll = 0.0f;
            if (llllIIlIlIIlllI == 0) {
                llllIIlIlIIllIl = (float)llllIIlIlIIIllI.owred.getValue();
                llllIIlIlIIllII = (float)llllIIlIlIIIllI.owgreen.getValue();
                llllIIlIlIIlIll = (float)llllIIlIlIIIllI.owblue.getValue();
            } else if (llllIIlIlIIlllI == -1) {
                llllIIlIlIIllIl = (float)llllIIlIlIIIllI.netherred.getValue();
                llllIIlIlIIllII = (float)llllIIlIlIIIllI.nethergreen.getValue();
                llllIIlIlIIlIll = (float)llllIIlIlIIIllI.netherblue.getValue();
            } else if (llllIIlIlIIlllI == 1) {
                llllIIlIlIIllIl = 0.0f;
                llllIIlIlIIllII = 0.0f;
                llllIIlIlIIlIll = 0.0f;
            }
            return new Vec3d((double)llllIIlIlIIllIl, (double)llllIIlIlIIllII, (double)llllIIlIlIIlIll);
        }
        return Minecraft.getMinecraft().theWorld.getSkyColor(llllIIlIlIIIlIl, llllIIlIlIIIlII);
    }

    public MixinRenderGlobal() {
        MixinRenderGlobal llllIIlIlIlIllI;
    }
}

