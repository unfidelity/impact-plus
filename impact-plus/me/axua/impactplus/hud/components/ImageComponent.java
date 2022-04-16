/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.hud.components;

import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.hud.Image;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ImageComponent
extends HudComponent<Image> {
    private static final /* synthetic */ ResourceLocation haikewl;
    /* synthetic */ Minecraft mc;
    private static final /* synthetic */ ResourceLocation clown;
    private static final /* synthetic */ ResourceLocation bed;
    /* synthetic */ Image mod;
    private static final /* synthetic */ ResourceLocation fortnite;
    private static final /* synthetic */ ResourceLocation brownman;

    public void drawFortnite(int lIlIllllIlIlII, int lIlIllllIlIIII) {
        ImageComponent lIlIllllIlIIlI;
        GlStateManager.enableAlpha();
        if (lIlIllllIlIIlI.mod.Image.getValue().equalsIgnoreCase("Haikewl")) {
            lIlIllllIlIIlI.mc.getTextureManager().bindTexture(haikewl);
        } else if (lIlIllllIlIIlI.mod.Image.getValue().equalsIgnoreCase("fortnite")) {
            lIlIllllIlIIlI.mc.getTextureManager().bindTexture(fortnite);
        } else if (lIlIllllIlIIlI.mod.Image.getValue().equalsIgnoreCase("clown")) {
            lIlIllllIlIIlI.mc.getTextureManager().bindTexture(clown);
        } else if (lIlIllllIlIIlI.mod.Image.getValue().equalsIgnoreCase("bed")) {
            lIlIllllIlIIlI.mc.getTextureManager().bindTexture(bed);
        } else {
            lIlIllllIlIIlI.mc.getTextureManager().bindTexture(brownman);
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        Gui.drawScaledCustomSizeModalRect((int)lIlIllllIlIlII, (int)lIlIllllIlIIII, (float)0.0f, (float)0.0f, (int)1000, (int)1000, (int)lIlIllllIlIIlI.mod.width.getValue(), (int)lIlIllllIlIIlI.mod.height.getValue(), (float)1000.0f, (float)1000.0f);
        GL11.glPopMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.clear((int)256);
    }

    static {
        haikewl = new ResourceLocation("minecraft:haikewl.jpg");
        brownman = new ResourceLocation("minecraft:brownman.png");
        fortnite = new ResourceLocation("minecraft:fortnite.png");
        bed = new ResourceLocation("minecraft:bed.png");
        clown = new ResourceLocation("minecraft:clown.jpg");
    }

    public ImageComponent() {
        super("Image", 100, 100, Image.INSTANCE);
        ImageComponent lIlIlllllIIlIl;
        lIlIlllllIIlIl.mc = Minecraft.getMinecraft();
        lIlIlllllIIlIl.mod = (Image)ModuleManager.getModuleByName("Image");
    }

    @Override
    public void render() {
        ImageComponent lIlIllllIllIlI;
        super.render();
        lIlIllllIllIlI.drawFortnite(lIlIllllIllIlI.x, lIlIllllIllIlI.y);
        lIlIllllIllIlI.height = lIlIllllIllIlI.mod.height.getValue();
        lIlIllllIllIlI.width = lIlIllllIllIlI.mod.width.getValue();
    }
}

