/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 */
package me.axua.impactplus.hud.components;

import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.hud.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class PlayerComponent
extends HudComponent<Player> {
    /* synthetic */ Player mod;
    /* synthetic */ Minecraft mc;
    /* synthetic */ float mouseXX;
    /* synthetic */ float mouseYY;

    private void drawEntityOnScreen(int lllllllllllllllllllllllIIlllIIII, int lllllllllllllllllllllllIIllIllll, int lllllllllllllllllllllllIIllIlllI, float lllllllllllllllllllllllIIlllllll, float lllllllllllllllllllllllIIlllllIl, EntityLivingBase lllllllllllllllllllllllIIllIllII) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllllllllllIIlllIIII, (float)lllllllllllllllllllllllIIllIllll, (float)50.0f);
        GlStateManager.scale((float)(-lllllllllllllllllllllllIIllIlllI), (float)lllllllllllllllllllllllIIllIlllI, (float)lllllllllllllllllllllllIIllIlllI);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float lllllllllllllllllllllllIIllllIII = lllllllllllllllllllllllIIllIllII.renderYawOffset;
        float lllllllllllllllllllllllIIlllIllI = lllllllllllllllllllllllIIllIllII.rotationYaw;
        float lllllllllllllllllllllllIIlllIlII = lllllllllllllllllllllllIIllIllII.rotationPitch;
        float lllllllllllllllllllllllIIlllIIll = lllllllllllllllllllllllIIllIllII.prevRotationYawHead;
        float lllllllllllllllllllllllIIlllIIlI = lllllllllllllllllllllllIIllIllII.rotationYawHead;
        GlStateManager.rotate((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-((float)Math.atan(lllllllllllllllllllllllIIlllllIl / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.0f);
        RenderManager lllllllllllllllllllllllIIlllIIIl = Minecraft.getMinecraft().getRenderManager();
        lllllllllllllllllllllllIIlllIIIl.setPlayerViewY(180.0f);
        lllllllllllllllllllllllIIlllIIIl.setRenderShadow(false);
        lllllllllllllllllllllllIIlllIIIl.func_188391_a((Entity)lllllllllllllllllllllllIIllIllII, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        lllllllllllllllllllllllIIlllIIIl.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
    }

    @Override
    public void render() {
        PlayerComponent lllllllllllllllllllllllIlIlIlllI;
        super.render();
        lllllllllllllllllllllllIlIlIlllI.mouseXX = lllllllllllllllllllllllIlIlIlllI.mc.getRenderViewEntity().rotationYaw * -1.0f;
        lllllllllllllllllllllllIlIlIlllI.mouseYY = lllllllllllllllllllllllIlIlIlllI.mc.getRenderViewEntity().rotationPitch * -1.0f;
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        lllllllllllllllllllllllIlIlIlllI.drawEntityOnScreen(lllllllllllllllllllllllIlIlIlllI.x + 20, lllllllllllllllllllllllIlIlIlllI.y + 60, lllllllllllllllllllllllIlIlIlllI.mod.Size.getValue(), lllllllllllllllllllllllIlIlIlllI.mouseXX, lllllllllllllllllllllllIlIlIlllI.mouseYY, (EntityLivingBase)lllllllllllllllllllllllIlIlIlllI.mc.thePlayer);
        lllllllllllllllllllllllIlIlIlllI.width = 40;
        lllllllllllllllllllllllIlIlIlllI.height = 65;
    }

    public PlayerComponent() {
        super("Player", 45, 200, Player.INSTANCE);
        PlayerComponent lllllllllllllllllllllllIlIllllII;
        lllllllllllllllllllllllIlIllllII.mc = Minecraft.getMinecraft();
        lllllllllllllllllllllllIlIllllII.mod = (Player)ModuleManager.getModuleByName("Player");
    }
}

