/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class BruhTessellator
extends Tessellator {
    public static /* synthetic */ BruhTessellator INSTANCE;

    public static void drawBoundingBox(AxisAlignedBB lllllIlIlllIIl, float lllllIlIllIIIl, int lllllIlIllIlll) {
        int lllllIlIllIllI = lllllIlIllIlll >>> 24 & 0xFF;
        int lllllIlIllIlIl = lllllIlIllIlll >>> 16 & 0xFF;
        int lllllIlIllIlII = lllllIlIllIlll >>> 8 & 0xFF;
        int lllllIlIllIIll = lllllIlIllIlll & 0xFF;
        BruhTessellator.drawBoundingBox(lllllIlIlllIIl, lllllIlIllIIIl, lllllIlIllIlIl, lllllIlIllIlII, lllllIlIllIIll, lllllIlIllIllI);
    }

    public static void drawBoundingBoxBottom(AxisAlignedBB lllllIIllllIlI, float lllllIIllllIIl, int lllllIIlllIIIl, int lllllIIlllIlll, int lllllIIllIllll, int lllllIIllIlllI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.func_187441_d((float)lllllIIllllIIl);
        BufferBuilder lllllIIlllIlII = INSTANCE.getWorldRenderer();
        lllllIIlllIlII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllIIlllIlII.pos(lllllIIllllIlI.minX, lllllIIllllIlI.minY, lllllIIllllIlI.minZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.minX, lllllIIllllIlI.minY, lllllIIllllIlI.maxZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.maxX, lllllIIllllIlI.minY, lllllIIllllIlI.maxZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.maxX, lllllIIllllIlI.minY, lllllIIllllIlI.minZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.minX, lllllIIllllIlI.minY, lllllIIllllIlI.minZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.minX, lllllIIllllIlI.minY, lllllIIllllIlI.maxZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.maxX, lllllIIllllIlI.minY, lllllIIllllIlI.maxZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        lllllIIlllIlII.pos(lllllIIllllIlI.maxX, lllllIIllllIlI.minY, lllllIIllllIlI.minZ).color(lllllIIlllIIIl, lllllIIlllIlll, lllllIIllIllll, lllllIIllIlllI).endVertex();
        BruhTessellator.render();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBox(BlockPos llllllIllIlIll, int llllllIllIlIlI, int llllllIllIlIIl, int llllllIllIlIII, int llllllIllIIlll, int llllllIlIllllI) {
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllIllIlIll.getX(), llllllIllIlIll.getY(), llllllIllIlIll.getZ(), 1.0f, 1.0f, 1.0f, llllllIllIlIlI, llllllIllIlIIl, llllllIllIlIII, llllllIllIIlll, llllllIlIllllI);
    }

    public static void drawHalfBox(BlockPos lllllllllIlIlI, int llllllllllIlIl, int lllllllllIlIII) {
        int llllllllllIIIl = llllllllllIlIl >>> 24 & 0xFF;
        int lllllllllIllll = llllllllllIlIl >>> 16 & 0xFF;
        int lllllllllIllIl = llllllllllIlIl >>> 8 & 0xFF;
        int lllllllllIlIll = llllllllllIlIl & 0xFF;
        BruhTessellator.drawHalfBox(lllllllllIlIlI, lllllllllIllll, lllllllllIllIl, lllllllllIlIll, llllllllllIIIl, lllllllllIlIII);
    }

    public static void release() {
        BruhTessellator.render();
        BruhTessellator.releaseGL();
    }

    public static void drawBoundingBox(AxisAlignedBB lllllIlIlIIlII, float lllllIlIlIIIll, int lllllIlIIllIll, int lllllIlIIllIlI, int lllllIlIlIIIII, int lllllIlIIllIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.func_187441_d((float)lllllIlIlIIIll);
        BufferBuilder lllllIlIIllllI = INSTANCE.getWorldRenderer();
        lllllIlIIllllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.minY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.minY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.minY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.minY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.minY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.minY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.minY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.maxZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.minY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.maxX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        lllllIlIIllllI.pos(lllllIlIlIIlII.minX, lllllIlIlIIlII.maxY, lllllIlIlIIlII.minZ).color(lllllIlIIllIll, lllllIlIIllIlI, lllllIlIlIIIII, lllllIlIIllIII).endVertex();
        BruhTessellator.render();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    static {
        INSTANCE = new BruhTessellator();
    }

    public static void drawBox(AxisAlignedBB lIIIIIIIIllllII, int lIIIIIIIIlllIlI, int lIIIIIIIIlIlllI) {
        int lIIIIIIIIllIllI = lIIIIIIIIlllIlI >>> 24 & 0xFF;
        int lIIIIIIIIllIlII = lIIIIIIIIlllIlI >>> 16 & 0xFF;
        int lIIIIIIIIllIIlI = lIIIIIIIIlllIlI >>> 8 & 0xFF;
        int lIIIIIIIIllIIIl = lIIIIIIIIlllIlI & 0xFF;
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), lIIIIIIIIllllII, lIIIIIIIIllIlII, lIIIIIIIIllIIlI, lIIIIIIIIllIIIl, lIIIIIIIIllIllI, lIIIIIIIIlIlllI);
    }

    public static void drawBoundingBoxHalf(AxisAlignedBB lllllIIlIllllI, float lllllIIllIIlII, int lllllIIlIlllII) {
        int lllllIIllIIIlI = lllllIIlIlllII >>> 24 & 0xFF;
        int lllllIIllIIIIl = lllllIIlIlllII >>> 16 & 0xFF;
        int lllllIIllIIIII = lllllIIlIlllII >>> 8 & 0xFF;
        int lllllIIlIlllll = lllllIIlIlllII & 0xFF;
        BruhTessellator.drawBoundingBoxHalf(lllllIIlIllllI, lllllIIllIIlII, lllllIIllIIIIl, lllllIIllIIIII, lllllIIlIlllll, lllllIIllIIIlI);
    }

    public static void drawHalfBox(float llllllllIlIlll, float llllllllIIIlIl, float llllllllIIIIll, int llllllllIIIIlI, int llllllllIIIIII) {
        int llllllllIIlllI = llllllllIIIIlI >>> 24 & 0xFF;
        int llllllllIIllII = llllllllIIIIlI >>> 16 & 0xFF;
        int llllllllIIlIlI = llllllllIIIIlI >>> 8 & 0xFF;
        int llllllllIIlIIl = llllllllIIIIlI & 0xFF;
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllIlIlll, llllllllIIIlIl, llllllllIIIIll, 1.0f, 0.5f, 1.0f, llllllllIIllII, llllllllIIlIlI, llllllllIIlIIl, llllllllIIlllI, llllllllIIIIII);
    }

    public static void drawBox(float lllllllIIllIII, float lllllllIIIllIl, float lllllllIIIllII, int lllllllIIIlIlI, int lllllllIIIlIIl) {
        int lllllllIIlIIll = lllllllIIIlIlI >>> 24 & 0xFF;
        int lllllllIIlIIlI = lllllllIIIlIlI >>> 16 & 0xFF;
        int lllllllIIlIIIl = lllllllIIIlIlI >>> 8 & 0xFF;
        int lllllllIIlIIII = lllllllIIIlIlI & 0xFF;
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), lllllllIIllIII, lllllllIIIllIl, lllllllIIIllII, 1.0f, 1.0f, 1.0f, lllllllIIlIIlI, lllllllIIlIIIl, lllllllIIlIIII, lllllllIIlIIll, lllllllIIIlIIl);
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

    public static void drawBox(BufferBuilder llllllIIlIIIll, float llllllIIlIIIlI, float llllllIIlIIIIl, float llllllIIIlIlII, float llllllIIIlIIll, float llllllIIIlIIlI, float llllllIIIlIIIl, int llllllIIIlIIII, int llllllIIIllIll, int llllllIIIllIlI, int llllllIIIIllIl, int llllllIIIIllII) {
        if ((llllllIIIIllII & 1) != 0) {
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)llllllIIlIIIIl, (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)llllllIIlIIIIl, (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)llllllIIlIIIIl, (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)llllllIIlIIIIl, (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
        }
        if ((llllllIIIIllII & 2) != 0) {
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
        }
        if ((llllllIIIIllII & 4) != 0) {
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)llllllIIlIIIIl, (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)llllllIIlIIIIl, (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
        }
        if ((llllllIIIIllII & 8) != 0) {
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)llllllIIlIIIIl, (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)llllllIIlIIIIl, (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
        }
        if ((llllllIIIIllII & 0x10) != 0) {
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)llllllIIlIIIIl, (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)llllllIIlIIIIl, (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)llllllIIlIIIlI, (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
        }
        if ((llllllIIIIllII & 0x20) != 0) {
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)llllllIIlIIIIl, (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)llllllIIlIIIIl, (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)llllllIIIlIlII).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
            llllllIIlIIIll.pos((double)(llllllIIlIIIlI + llllllIIIlIIll), (double)(llllllIIlIIIIl + llllllIIIlIIlI), (double)(llllllIIIlIlII + llllllIIIlIIIl)).color(llllllIIIlIIII, llllllIIIllIll, llllllIIIllIlI, llllllIIIIllIl).endVertex();
        }
    }

    public static void drawHalfBox(BlockPos llllllIlIIlIIl, int llllllIlIIllll, int llllllIlIIIllI, int llllllIlIIllII, int llllllIlIIlIll, int llllllIlIIlIlI) {
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllIlIIlIIl.getX(), llllllIlIIlIIl.getY(), llllllIlIIlIIl.getZ(), 1.0f, 0.5f, 1.0f, llllllIlIIllll, llllllIlIIIllI, llllllIlIIllII, llllllIlIIlIll, llllllIlIIlIlI);
    }

    public BruhTessellator() {
        super(0x200000);
        BruhTessellator lIIIIIIIllIllIl;
    }

    public static void drawBoundingBoxBlockPos(BlockPos lllllIIIlIlIII, float lllllIIIlIIlll, int lllllIIIllIIll, int lllllIIIllIIlI, int lllllIIIlIIlII, int lllllIIIlIIIll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lllllIIIlIIlll);
        Minecraft lllllIIIlIllll = Minecraft.getMinecraft();
        double lllllIIIlIlllI = (double)lllllIIIlIlIII.getX() - lllllIIIlIllll.getRenderManager().viewerPosX;
        double lllllIIIlIllIl = (double)lllllIIIlIlIII.getY() - lllllIIIlIllll.getRenderManager().viewerPosY;
        double lllllIIIlIllII = (double)lllllIIIlIlIII.getZ() - lllllIIIlIllll.getRenderManager().viewerPosZ;
        AxisAlignedBB lllllIIIlIlIll = new AxisAlignedBB(lllllIIIlIlllI, lllllIIIlIllIl, lllllIIIlIllII, lllllIIIlIlllI + 1.0, lllllIIIlIllIl + 1.0, lllllIIIlIllII + 1.0);
        Tessellator lllllIIIlIlIlI = Tessellator.getInstance();
        BufferBuilder lllllIIIlIlIIl = lllllIIIlIlIlI.getWorldRenderer();
        lllllIIIlIlIIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.minY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.minY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.minY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.minY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.minY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIlI.draw();
        lllllIIIlIlIIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIlI.draw();
        lllllIIIlIlIIl.begin(1, DefaultVertexFormats.POSITION_COLOR);
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.minY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.minY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.minZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.minY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.maxX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.minY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIIl.pos(lllllIIIlIlIll.minX, lllllIIIlIlIll.maxY, lllllIIIlIlIll.maxZ).color(lllllIIIllIIll, lllllIIIllIIlI, lllllIIIlIIlII, lllllIIIlIIIll).endVertex();
        lllllIIIlIlIlI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void render() {
        INSTANCE.draw();
    }

    public static void prepare(int lIIIIIIIllIIlll) {
        BruhTessellator.prepareGL();
        BruhTessellator.begin(lIIIIIIIllIIlll);
    }

    public static BufferBuilder getBufferBuilder() {
        return INSTANCE.getWorldRenderer();
    }

    public static void drawBox(BufferBuilder lllllIllllllIl, AxisAlignedBB lllllIllllllII, int lllllIlllllIll, int lllllIlllllIlI, int llllllIIIIIIII, int lllllIlllllIII, int lllllIlllllllI) {
        if ((lllllIlllllllI & 1) != 0) {
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.minY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.minY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.minY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.minY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
        }
        if ((lllllIlllllllI & 2) != 0) {
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.maxY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.maxY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.maxY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.maxY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
        }
        if ((lllllIlllllllI & 4) != 0) {
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.minY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.minY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.maxY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.maxY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
        }
        if ((lllllIlllllllI & 8) != 0) {
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.minY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.minY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.maxY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.maxY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
        }
        if ((lllllIlllllllI & 0x10) != 0) {
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.minY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.minY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.maxY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.minX, lllllIllllllII.maxY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
        }
        if ((lllllIlllllllI & 0x20) != 0) {
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.minY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.minY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.maxY, lllllIllllllII.minZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
            lllllIllllllIl.pos(lllllIllllllII.maxX, lllllIllllllII.maxY, lllllIllllllII.maxZ).color(lllllIlllllIll, lllllIlllllIlI, llllllIIIIIIII, lllllIlllllIII).endVertex();
        }
    }

    public static void drawBox(BlockPos lIIIIIIIIIllIll, int lIIIIIIIIlIIIIl, int lIIIIIIIIIllIIl) {
        int lIIIIIIIIIlllll = lIIIIIIIIlIIIIl >>> 24 & 0xFF;
        int lIIIIIIIIIllllI = lIIIIIIIIlIIIIl >>> 16 & 0xFF;
        int lIIIIIIIIIlllIl = lIIIIIIIIlIIIIl >>> 8 & 0xFF;
        int lIIIIIIIIIlllII = lIIIIIIIIlIIIIl & 0xFF;
        BruhTessellator.drawBox(lIIIIIIIIIllIll, lIIIIIIIIIllllI, lIIIIIIIIIlllIl, lIIIIIIIIIlllII, lIIIIIIIIIlllll, lIIIIIIIIIllIIl);
    }

    public static void drawBoundingBoxBottom(AxisAlignedBB lllllIlIIIllll, float lllllIlIIIlllI, int lllllIlIIIIllI) {
        int lllllIlIIIllII = lllllIlIIIIllI >>> 24 & 0xFF;
        int lllllIlIIIlIll = lllllIlIIIIllI >>> 16 & 0xFF;
        int lllllIlIIIlIlI = lllllIlIIIIllI >>> 8 & 0xFF;
        int lllllIlIIIlIIl = lllllIlIIIIllI & 0xFF;
        BruhTessellator.drawBoundingBoxBottom(lllllIlIIIllll, lllllIlIIIlllI, lllllIlIIIlIll, lllllIlIIIlIlI, lllllIlIIIlIIl, lllllIlIIIllII);
    }

    public static void drawLines(BufferBuilder lllllIllIIllII, float lllllIllIIlIll, float lllllIllIlIllI, float lllllIllIIlIIl, float lllllIllIIlIII, float lllllIllIIIlll, float lllllIllIIIllI, int lllllIllIIIlIl, int lllllIllIlIIII, int lllllIllIIllll, int lllllIllIIlllI, int lllllIllIIIIIl) {
        if ((lllllIllIIIIIl & 0x11) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)lllllIllIlIllI, (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)lllllIllIlIllI, (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x12) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)(lllllIllIlIllI + lllllIllIIIlll), (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)(lllllIllIlIllI + lllllIllIIIlll), (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x21) != 0) {
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)lllllIllIlIllI, (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)lllllIllIlIllI, (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x22) != 0) {
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)(lllllIllIlIllI + lllllIllIIIlll), (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)(lllllIllIlIllI + lllllIllIIIlll), (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 5) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)lllllIllIlIllI, (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)lllllIllIlIllI, (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 6) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)(lllllIllIlIllI + lllllIllIIIlll), (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)(lllllIllIlIllI + lllllIllIIIlll), (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 9) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)lllllIllIlIllI, (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)lllllIllIlIllI, (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0xA) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)(lllllIllIlIllI + lllllIllIIIlll), (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)(lllllIllIlIllI + lllllIllIIIlll), (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x14) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)lllllIllIlIllI, (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)(lllllIllIlIllI + lllllIllIIIlll), (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x24) != 0) {
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)lllllIllIlIllI, (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)(lllllIllIlIllI + lllllIllIIIlll), (double)lllllIllIIlIIl).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x18) != 0) {
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)lllllIllIlIllI, (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)lllllIllIIlIll, (double)(lllllIllIlIllI + lllllIllIIIlll), (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
        if ((lllllIllIIIIIl & 0x28) != 0) {
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)lllllIllIlIllI, (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
            lllllIllIIllII.pos((double)(lllllIllIIlIll + lllllIllIIlIII), (double)(lllllIllIlIllI + lllllIllIIIlll), (double)(lllllIllIIlIIl + lllllIllIIIllI)).color(lllllIllIIIlIl, lllllIllIlIIII, lllllIllIIllll, lllllIllIIlllI).endVertex();
        }
    }

    public static void drawBox(Vec3d llllllIIllIlIl, int llllllIIllIlII, int llllllIIlllIIl, int llllllIIllIIlI, int llllllIIllIlll, int llllllIIllIIII) {
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), (float)llllllIIllIlIl.xCoord, (float)llllllIIllIlIl.yCoord, (float)llllllIIllIlIl.zCoord, 1.0f, 1.0f, 1.0f, llllllIIllIlII, llllllIIlllIIl, llllllIIllIIlI, llllllIIllIlll, llllllIIllIIII);
    }

    public static void drawBoundingBoxHalf(AxisAlignedBB lllllIIlIlIIII, float lllllIIlIIlIII, int lllllIIlIIIlll, int lllllIIlIIIllI, int lllllIIlIIIlIl, int lllllIIlIIlIll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.func_187441_d((float)lllllIIlIIlIII);
        BufferBuilder lllllIIlIIlIlI = INSTANCE.getWorldRenderer();
        lllllIIlIIlIlI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.minY, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.minY, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.minY, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.minY, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.minY, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.minY, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.minY, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.maxZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.minY, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.maxX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        lllllIIlIIlIlI.pos(lllllIIlIlIIII.minX, lllllIIlIlIIII.maxY - 0.5, lllllIIlIlIIII.minZ).color(lllllIIlIIIlll, lllllIIlIIIllI, lllllIIlIIIlIl, lllllIIlIIlIll).endVertex();
        BruhTessellator.render();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
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

    public static void begin(int lIIIIIIIlIllIlI) {
        INSTANCE.getWorldRenderer().begin(lIIIIIIIlIllIlI, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void drawSmallBox(Vec3d lllllIlllIlIlI, int lllllIlllIllll, int lllllIlllIlllI, int lllllIlllIIlll, int lllllIlllIllII, int lllllIlllIlIll) {
        BruhTessellator.drawBox(INSTANCE.getWorldRenderer(), (float)lllllIlllIlIlI.xCoord, (float)lllllIlllIlIlI.yCoord, (float)lllllIlllIlIlI.zCoord, 0.3f, 0.3f, 0.3f, lllllIlllIllll, lllllIlllIlllI, lllllIlllIIlll, lllllIlllIllII, lllllIlllIlIll);
    }
}

