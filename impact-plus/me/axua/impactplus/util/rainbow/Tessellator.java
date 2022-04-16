/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.util.rainbow;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class Tessellator
extends net.minecraft.client.renderer.Tessellator {
    public static /* synthetic */ Tessellator INSTANCE;

    public Tessellator() {
        super(0x200000);
        Tessellator lllllllllllllllllIlIIllIlIIlIIII;
    }

    public static void render() {
        INSTANCE.draw();
    }

    public static void prepareGL() {
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.func_187441_d((float)1.5f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void prepare(int lllllllllllllllllIlIIllIlIIIlllI) {
        Tessellator.prepareGL();
        Tessellator.begin(lllllllllllllllllIlIIllIlIIIlllI);
    }

    public static void drawQuarterBox(BlockPos lllllllllllllllllIlIIllIIIllIIll, int lllllllllllllllllIlIIllIIIlIlIll, int lllllllllllllllllIlIIllIIIlIlIlI, int lllllllllllllllllIlIIllIIIlIlIIl, int lllllllllllllllllIlIIllIIIlIlIII, int lllllllllllllllllIlIIllIIIlIIlll) {
        Tessellator.drawBox(INSTANCE.getWorldRenderer(), lllllllllllllllllIlIIllIIIllIIll.getX(), lllllllllllllllllIlIIllIIIllIIll.getY(), lllllllllllllllllIlIIllIIIllIIll.getZ(), 1.0f, 0.25f, 1.0f, lllllllllllllllllIlIIllIIIlIlIll, lllllllllllllllllIlIIllIIIlIlIlI, lllllllllllllllllIlIIllIIIlIlIIl, lllllllllllllllllIlIIllIIIlIlIII, lllllllllllllllllIlIIllIIIlIIlll);
    }

    public static void drawTinyBox(BlockPos lllllllllllllllllIlIIllIIlIIIlll, int lllllllllllllllllIlIIllIIlIIllII, int lllllllllllllllllIlIIllIIlIIlIll, int lllllllllllllllllIlIIllIIlIIlIlI, int lllllllllllllllllIlIIllIIlIIlIIl, int lllllllllllllllllIlIIllIIlIIlIII) {
        Tessellator.drawBox(INSTANCE.getWorldRenderer(), lllllllllllllllllIlIIllIIlIIIlll.getX(), lllllllllllllllllIlIIllIIlIIIlll.getY(), lllllllllllllllllIlIIllIIlIIIlll.getZ(), 1.0f, 0.1f, 1.0f, lllllllllllllllllIlIIllIIlIIllII, lllllllllllllllllIlIIllIIlIIlIll, lllllllllllllllllIlIIllIIlIIlIlI, lllllllllllllllllIlIIllIIlIIlIIl, lllllllllllllllllIlIIllIIlIIlIII);
    }

    public static void drawBox(BufferBuilder lllllllllllllllllIlIIlIllllIIllI, float lllllllllllllllllIlIIlIlllllIIIl, float lllllllllllllllllIlIIlIlllllIIII, float lllllllllllllllllIlIIlIllllIllll, float lllllllllllllllllIlIIlIllllIlllI, float lllllllllllllllllIlIIlIllllIIIIl, float lllllllllllllllllIlIIlIllllIIIII, int lllllllllllllllllIlIIlIllllIlIll, int lllllllllllllllllIlIIlIlllIllllI, int lllllllllllllllllIlIIlIlllIlllIl, int lllllllllllllllllIlIIlIllllIlIII, int lllllllllllllllllIlIIlIllllIIlll) {
        if ((lllllllllllllllllIlIIlIllllIIlll & 1) != 0) {
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)lllllllllllllllllIlIIlIlllllIIII, (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)lllllllllllllllllIlIIlIlllllIIII, (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)lllllllllllllllllIlIIlIlllllIIII, (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)lllllllllllllllllIlIIlIlllllIIII, (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
        }
        if ((lllllllllllllllllIlIIlIllllIIlll & 2) != 0) {
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
        }
        if ((lllllllllllllllllIlIIlIllllIIlll & 4) != 0) {
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)lllllllllllllllllIlIIlIlllllIIII, (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)lllllllllllllllllIlIIlIlllllIIII, (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
        }
        if ((lllllllllllllllllIlIIlIllllIIlll & 8) != 0) {
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)lllllllllllllllllIlIIlIlllllIIII, (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)lllllllllllllllllIlIIlIlllllIIII, (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
        }
        if ((lllllllllllllllllIlIIlIllllIIlll & 0x10) != 0) {
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)lllllllllllllllllIlIIlIlllllIIII, (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)lllllllllllllllllIlIIlIlllllIIII, (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)lllllllllllllllllIlIIlIlllllIIIl, (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
        }
        if ((lllllllllllllllllIlIIlIllllIIlll & 0x20) != 0) {
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)lllllllllllllllllIlIIlIlllllIIII, (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)lllllllllllllllllIlIIlIlllllIIII, (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)lllllllllllllllllIlIIlIllllIllll).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
            lllllllllllllllllIlIIlIllllIIllI.pos((double)(lllllllllllllllllIlIIlIlllllIIIl + lllllllllllllllllIlIIlIllllIlllI), (double)(lllllllllllllllllIlIIlIlllllIIII + lllllllllllllllllIlIIlIllllIIIIl), (double)(lllllllllllllllllIlIIlIllllIllll + lllllllllllllllllIlIIlIllllIIIII)).color(lllllllllllllllllIlIIlIllllIlIll, lllllllllllllllllIlIIlIlllIllllI, lllllllllllllllllIlIIlIlllIlllIl, lllllllllllllllllIlIIlIllllIlIII).endVertex();
        }
    }

    public static void drawBox(BlockPos lllllllllllllllllIlIIllIIlllllIl, int lllllllllllllllllIlIIllIIlllIllI, int lllllllllllllllllIlIIllIIlllIlIl, int lllllllllllllllllIlIIllIIlllIlII, int lllllllllllllllllIlIIllIIlllIIll, int lllllllllllllllllIlIIllIIlllIIlI) {
        Tessellator.drawBox(INSTANCE.getWorldRenderer(), lllllllllllllllllIlIIllIIlllllIl.getX(), lllllllllllllllllIlIIllIIlllllIl.getY(), lllllllllllllllllIlIIllIIlllllIl.getZ(), 1.0f, 1.0f, 1.0f, lllllllllllllllllIlIIllIIlllIllI, lllllllllllllllllIlIIllIIlllIlIl, lllllllllllllllllIlIIllIIlllIlII, lllllllllllllllllIlIIllIIlllIIll, lllllllllllllllllIlIIllIIlllIIlI);
    }

    static {
        INSTANCE = new Tessellator();
    }

    public static void releaseGL() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void drawHalfBox(BlockPos lllllllllllllllllIlIIllIIlIlllll, int lllllllllllllllllIlIIllIIllIIlII, int lllllllllllllllllIlIIllIIlIlllII, int lllllllllllllllllIlIIllIIlIllIll, int lllllllllllllllllIlIIllIIlIllIIl, int lllllllllllllllllIlIIllIIlIlIlll) {
        Tessellator.drawBox(INSTANCE.getWorldRenderer(), lllllllllllllllllIlIIllIIlIlllll.getX(), lllllllllllllllllIlIIllIIlIlllll.getY(), lllllllllllllllllIlIIllIIlIlllll.getZ(), 1.0f, 0.5f, 1.0f, lllllllllllllllllIlIIllIIllIIlII, lllllllllllllllllIlIIllIIlIlllII, lllllllllllllllllIlIIllIIlIllIll, lllllllllllllllllIlIIllIIlIllIIl, lllllllllllllllllIlIIllIIlIlIlll);
    }

    public static void begin(int lllllllllllllllllIlIIllIlIIIlIIl) {
        INSTANCE.getWorldRenderer().begin(lllllllllllllllllIlIIllIlIIIlIIl, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void release() {
        Tessellator.render();
        Tessellator.releaseGL();
    }
}

