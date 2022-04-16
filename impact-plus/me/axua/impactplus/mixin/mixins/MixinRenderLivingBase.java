/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.EntityLivingBase
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.module.ModuleManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderLivingBase.class})
public abstract class MixinRenderLivingBase<T extends EntityLivingBase>
extends Render<T> {
    public MixinRenderLivingBase(RenderManager lllllllllllllllllllIIIIIlIlIllII, ModelBase lllllllllllllllllllIIIIIlIlIlIll, float lllllllllllllllllllIIIIIlIlIlIlI) {
        super(lllllllllllllllllllIIIIIlIlIllII);
        MixinRenderLivingBase lllllllllllllllllllIIIIIlIlIlIIl;
    }

    @Inject(method={"doRender"}, at={@At(value="HEAD")})
    public void doRenderPre(T lllllllllllllllllllIIIIIlIIllllI, double lllllllllllllllllllIIIIIlIlIIlII, double lllllllllllllllllllIIIIIlIlIIIll, double lllllllllllllllllllIIIIIlIlIIIlI, float lllllllllllllllllllIIIIIlIlIIIIl, float lllllllllllllllllllIIIIIlIlIIIII, CallbackInfo lllllllllllllllllllIIIIIlIIlllll) {
        if (ModuleManager.isModuleEnabled("Chams") && lllllllllllllllllllIIIIIlIIllllI != null) {
            GL11.glEnable((int)32823);
            GL11.glPolygonOffset((float)1.0f, (float)-1100000.0f);
        }
    }

    @Inject(method={"doRender"}, at={@At(value="RETURN")})
    public void doRenderPost(T lllllllllllllllllllIIIIIlIIllIll, double lllllllllllllllllllIIIIIlIIllIlI, double lllllllllllllllllllIIIIIlIIllIIl, double lllllllllllllllllllIIIIIlIIllIII, float lllllllllllllllllllIIIIIlIIlIlll, float lllllllllllllllllllIIIIIlIIlIllI, CallbackInfo lllllllllllllllllllIIIIIlIIlIlIl) {
        if (ModuleManager.isModuleEnabled("Chams") && lllllllllllllllllllIIIIIlIIllIll != null) {
            GL11.glPolygonOffset((float)1.0f, (float)1000000.0f);
            GL11.glDisable((int)32823);
        }
    }
}

