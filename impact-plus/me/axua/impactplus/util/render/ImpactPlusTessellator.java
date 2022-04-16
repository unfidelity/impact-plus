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
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class ImpactPlusTessellator
extends Tessellator {
    public static /* synthetic */ ImpactPlusTessellator INSTANCE;

    public static void drawBoundingBox(AxisAlignedBB llllllllllllllllIIlllIlIllIlIIll, float llllllllllllllllIIlllIlIllIIlIlI, int llllllllllllllllIIlllIlIllIlIIIl, int llllllllllllllllIIlllIlIllIlIIII, int llllllllllllllllIIlllIlIllIIllll, int llllllllllllllllIIlllIlIllIIlllI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIlIllIIlIlI);
        Tessellator llllllllllllllllIIlllIlIllIIllIl = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIlIllIIllII = llllllllllllllllIIlllIlIllIIllIl.getWorldRenderer();
        llllllllllllllllIIlllIlIllIIllII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllIl.draw();
        llllllllllllllllIIlllIlIllIIllII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllIl.draw();
        llllllllllllllllIIlllIlIllIIllII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.minZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.maxX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.minY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllII.pos(llllllllllllllllIIlllIlIllIlIIll.minX, llllllllllllllllIIlllIlIllIlIIll.maxY, llllllllllllllllIIlllIlIllIlIIll.maxZ).color(llllllllllllllllIIlllIlIllIlIIIl, llllllllllllllllIIlllIlIllIlIIII, llllllllllllllllIIlllIlIllIIllll, llllllllllllllllIIlllIlIllIIlllI).endVertex();
        llllllllllllllllIIlllIlIllIIllIl.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawHalfBox(float llllllllllllllllIIllllIIIlIIIIlI, float llllllllllllllllIIllllIIIlIIIIIl, float llllllllllllllllIIllllIIIlIIlIIl, int llllllllllllllllIIllllIIIIllllll, int llllllllllllllllIIllllIIIIlllllI) {
        int llllllllllllllllIIllllIIIlIIIllI = llllllllllllllllIIllllIIIIllllll >>> 24 & 0xFF;
        int llllllllllllllllIIllllIIIlIIIlIl = llllllllllllllllIIllllIIIIllllll >>> 16 & 0xFF;
        int llllllllllllllllIIllllIIIlIIIlII = llllllllllllllllIIllllIIIIllllll >>> 8 & 0xFF;
        int llllllllllllllllIIllllIIIlIIIIll = llllllllllllllllIIllllIIIIllllll & 0xFF;
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIIllllIIIlIIIIlI, llllllllllllllllIIllllIIIlIIIIIl, llllllllllllllllIIllllIIIlIIlIIl, 1.0f, 0.5f, 1.0f, llllllllllllllllIIllllIIIlIIIlIl, llllllllllllllllIIllllIIIlIIIlII, llllllllllllllllIIllllIIIlIIIIll, llllllllllllllllIIllllIIIlIIIllI, llllllllllllllllIIllllIIIIlllllI);
    }

    public static void drawBoxBottom(BlockPos llllllllllllllllIIlllIIllIIlllII, int llllllllllllllllIIlllIIllIIlIlIl) {
        int llllllllllllllllIIlllIIllIIllIlI = llllllllllllllllIIlllIIllIIlIlIl >>> 24 & 0xFF;
        int llllllllllllllllIIlllIIllIIllIIl = llllllllllllllllIIlllIIllIIlIlIl >>> 16 & 0xFF;
        int llllllllllllllllIIlllIIllIIllIII = llllllllllllllllIIlllIIllIIlIlIl >>> 8 & 0xFF;
        int llllllllllllllllIIlllIIllIIlIlll = llllllllllllllllIIlllIIllIIlIlIl & 0xFF;
        ImpactPlusTessellator.drawBoxBottom(llllllllllllllllIIlllIIllIIlllII, llllllllllllllllIIlllIIllIIllIIl, llllllllllllllllIIlllIIllIIllIII, llllllllllllllllIIlllIIllIIlIlll, llllllllllllllllIIlllIIllIIllIlI);
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

    public static void drawhalfBoundingBoxBlockPos(BlockPos llllllllllllllllIIlllIlIIlllIlll, float llllllllllllllllIIlllIlIIlllIllI, int llllllllllllllllIIlllIlIIllIlIII, int llllllllllllllllIIlllIlIIlllIlII, int llllllllllllllllIIlllIlIIlllIIll, int llllllllllllllllIIlllIlIIlllIIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIlIIlllIllI);
        Minecraft llllllllllllllllIIlllIlIIlllIIIl = Minecraft.getMinecraft();
        double llllllllllllllllIIlllIlIIlllIIII = (double)llllllllllllllllIIlllIlIIlllIlll.getX() - llllllllllllllllIIlllIlIIlllIIIl.getRenderManager().viewerPosX;
        double llllllllllllllllIIlllIlIIllIllll = (double)llllllllllllllllIIlllIlIIlllIlll.getY() - llllllllllllllllIIlllIlIIlllIIIl.getRenderManager().viewerPosY;
        double llllllllllllllllIIlllIlIIllIlllI = (double)llllllllllllllllIIlllIlIIlllIlll.getZ() - llllllllllllllllIIlllIlIIlllIIIl.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIIlllIlIIllIllIl = new AxisAlignedBB(llllllllllllllllIIlllIlIIlllIIII, llllllllllllllllIIlllIlIIllIllll, llllllllllllllllIIlllIlIIllIlllI, llllllllllllllllIIlllIlIIlllIIII + 1.0, llllllllllllllllIIlllIlIIllIllll + 0.5, llllllllllllllllIIlllIlIIllIlllI + 1.0);
        Tessellator llllllllllllllllIIlllIlIIllIllII = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIlIIllIlIll = llllllllllllllllIIlllIlIIllIllII.getWorldRenderer();
        llllllllllllllllIIlllIlIIllIlIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIllII.draw();
        llllllllllllllllIIlllIlIIllIlIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIllII.draw();
        llllllllllllllllIIlllIlIIllIlIll.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.minZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.maxX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.minY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIlIll.pos(llllllllllllllllIIlllIlIIllIllIl.minX, llllllllllllllllIIlllIlIIllIllIl.maxY, llllllllllllllllIIlllIlIIllIllIl.maxZ).color(llllllllllllllllIIlllIlIIllIlIII, llllllllllllllllIIlllIlIIlllIlII, llllllllllllllllIIlllIlIIlllIIll, llllllllllllllllIIlllIlIIlllIIlI).endVertex();
        llllllllllllllllIIlllIlIIllIllII.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBoundingBoxBlockPos(BlockPos llllllllllllllllIIlllIlIlIIlIIIl, float llllllllllllllllIIlllIlIlIIlIIII, int llllllllllllllllIIlllIlIlIIIllll, int llllllllllllllllIIlllIlIlIIIlllI, int llllllllllllllllIIlllIlIlIIIllIl, int llllllllllllllllIIlllIlIlIIIllII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIlIlIIlIIII);
        Minecraft llllllllllllllllIIlllIlIlIIllIII = Minecraft.getMinecraft();
        double llllllllllllllllIIlllIlIlIIlIlll = (double)llllllllllllllllIIlllIlIlIIlIIIl.getX() - llllllllllllllllIIlllIlIlIIllIII.getRenderManager().viewerPosX;
        double llllllllllllllllIIlllIlIlIIlIllI = (double)llllllllllllllllIIlllIlIlIIlIIIl.getY() - llllllllllllllllIIlllIlIlIIllIII.getRenderManager().viewerPosY;
        double llllllllllllllllIIlllIlIlIIlIlIl = (double)llllllllllllllllIIlllIlIlIIlIIIl.getZ() - llllllllllllllllIIlllIlIlIIllIII.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIIlllIlIlIIlIlII = new AxisAlignedBB(llllllllllllllllIIlllIlIlIIlIlll, llllllllllllllllIIlllIlIlIIlIllI, llllllllllllllllIIlllIlIlIIlIlIl, llllllllllllllllIIlllIlIlIIlIlll + 1.0, llllllllllllllllIIlllIlIlIIlIllI + 1.0, llllllllllllllllIIlllIlIlIIlIlIl + 1.0);
        Tessellator llllllllllllllllIIlllIlIlIIlIIll = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIlIlIIlIIlI = llllllllllllllllIIlllIlIlIIlIIll.getWorldRenderer();
        llllllllllllllllIIlllIlIlIIlIIlI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIll.draw();
        llllllllllllllllIIlllIlIlIIlIIlI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIll.draw();
        llllllllllllllllIIlllIlIlIIlIIlI.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.minZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.maxX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.minY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIlI.pos(llllllllllllllllIIlllIlIlIIlIlII.minX, llllllllllllllllIIlllIlIlIIlIlII.maxY, llllllllllllllllIIlllIlIlIIlIlII.maxZ).color(llllllllllllllllIIlllIlIlIIIllll, llllllllllllllllIIlllIlIlIIIlllI, llllllllllllllllIIlllIlIlIIIllIl, llllllllllllllllIIlllIlIlIIIllII).endVertex();
        llllllllllllllllIIlllIlIlIIlIIll.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawSmallBox(Vec3d llllllllllllllllIIlllIllIlllIlII, int llllllllllllllllIIlllIllIlllllII, int llllllllllllllllIIlllIllIlllIIIl, int llllllllllllllllIIlllIllIllIllll, int llllllllllllllllIIlllIllIllIllIl, int llllllllllllllllIIlllIllIlllIlIl) {
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), (float)llllllllllllllllIIlllIllIlllIlII.xCoord, (float)llllllllllllllllIIlllIllIlllIlII.yCoord, (float)llllllllllllllllIIlllIllIlllIlII.zCoord, 0.3f, 0.3f, 0.3f, llllllllllllllllIIlllIllIlllllII, llllllllllllllllIIlllIllIlllIIIl, llllllllllllllllIIlllIllIllIllll, llllllllllllllllIIlllIllIllIllIl, llllllllllllllllIIlllIllIlllIlIl);
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIIlllIIlIlIIIlll, double llllllllllllllllIIlllIIlIlIIIIlI, double llllllllllllllllIIlllIIlIlIIIlIl, double llllllllllllllllIIlllIIlIlIIIlII) {
        return new Vec3d((llllllllllllllllIIlllIIlIlIIIlll.posX - llllllllllllllllIIlllIIlIlIIIlll.lastTickPosX) * llllllllllllllllIIlllIIlIlIIIIlI, (llllllllllllllllIIlllIIlIlIIIlll.posY - llllllllllllllllIIlllIIlIlIIIlll.lastTickPosY) * llllllllllllllllIIlllIIlIlIIIlIl, (llllllllllllllllIIlllIIlIlIIIlll.posZ - llllllllllllllllIIlllIIlIlIIIlll.lastTickPosZ) * llllllllllllllllIIlllIIlIlIIIlII);
    }

    public static void drawBox(BlockPos llllllllllllllllIIllllIIIlllIlll, int llllllllllllllllIIllllIIIllIllll, int llllllllllllllllIIllllIIIlllIlIl) {
        int llllllllllllllllIIllllIIIlllIlII = llllllllllllllllIIllllIIIllIllll >>> 24 & 0xFF;
        int llllllllllllllllIIllllIIIlllIIll = llllllllllllllllIIllllIIIllIllll >>> 16 & 0xFF;
        int llllllllllllllllIIllllIIIlllIIlI = llllllllllllllllIIllllIIIllIllll >>> 8 & 0xFF;
        int llllllllllllllllIIllllIIIlllIIIl = llllllllllllllllIIllllIIIllIllll & 0xFF;
        ImpactPlusTessellator.drawBox(llllllllllllllllIIllllIIIlllIlll, llllllllllllllllIIllllIIIlllIIll, llllllllllllllllIIllllIIIlllIIlI, llllllllllllllllIIllllIIIlllIIIl, llllllllllllllllIIllllIIIlllIlII, llllllllllllllllIIllllIIIlllIlIl);
    }

    public static void drawBox(AxisAlignedBB llllllllllllllllIIllllIIlIIIIlIl, int llllllllllllllllIIllllIIlIIIIlII, int llllllllllllllllIIllllIIlIIIIIll) {
        int llllllllllllllllIIllllIIlIIIlIIl = llllllllllllllllIIllllIIlIIIIlII >>> 24 & 0xFF;
        int llllllllllllllllIIllllIIlIIIlIII = llllllllllllllllIIllllIIlIIIIlII >>> 16 & 0xFF;
        int llllllllllllllllIIllllIIlIIIIlll = llllllllllllllllIIllllIIlIIIIlII >>> 8 & 0xFF;
        int llllllllllllllllIIllllIIlIIIIllI = llllllllllllllllIIllllIIlIIIIlII & 0xFF;
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIIllllIIlIIIIlIl, llllllllllllllllIIllllIIlIIIlIII, llllllllllllllllIIllllIIlIIIIlll, llllllllllllllllIIllllIIlIIIIllI, llllllllllllllllIIllllIIlIIIlIIl, llllllllllllllllIIllllIIlIIIIIll);
    }

    public static void drawQuarterBoundingBoxBlockPos(BlockPos llllllllllllllllIIlllIlIIIlIlIIl, float llllllllllllllllIIlllIlIIIlIlIII, int llllllllllllllllIIlllIlIIIlIIlll, int llllllllllllllllIIlllIlIIIIllIIl, int llllllllllllllllIIlllIlIIIIllIII, int llllllllllllllllIIlllIlIIIlIIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIlIIIlIlIII);
        Minecraft llllllllllllllllIIlllIlIIIlIIIll = Minecraft.getMinecraft();
        double llllllllllllllllIIlllIlIIIlIIIlI = (double)llllllllllllllllIIlllIlIIIlIlIIl.getX() - llllllllllllllllIIlllIlIIIlIIIll.getRenderManager().viewerPosX;
        double llllllllllllllllIIlllIlIIIlIIIIl = (double)llllllllllllllllIIlllIlIIIlIlIIl.getY() - llllllllllllllllIIlllIlIIIlIIIll.getRenderManager().viewerPosY;
        double llllllllllllllllIIlllIlIIIlIIIII = (double)llllllllllllllllIIlllIlIIIlIlIIl.getZ() - llllllllllllllllIIlllIlIIIlIIIll.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIIlllIlIIIIlllll = new AxisAlignedBB(llllllllllllllllIIlllIlIIIlIIIlI, llllllllllllllllIIlllIlIIIlIIIIl, llllllllllllllllIIlllIlIIIlIIIII, llllllllllllllllIIlllIlIIIlIIIlI + 1.0, llllllllllllllllIIlllIlIIIlIIIIl + 0.25, llllllllllllllllIIlllIlIIIlIIIII + 1.0);
        Tessellator llllllllllllllllIIlllIlIIIIllllI = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIlIIIIlllIl = llllllllllllllllIIlllIlIIIIllllI.getWorldRenderer();
        llllllllllllllllIIlllIlIIIIlllIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIllllI.draw();
        llllllllllllllllIIlllIlIIIIlllIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIllllI.draw();
        llllllllllllllllIIlllIlIIIIlllIl.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.minZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.maxX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.minY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIlllIl.pos(llllllllllllllllIIlllIlIIIIlllll.minX, llllllllllllllllIIlllIlIIIIlllll.maxY, llllllllllllllllIIlllIlIIIIlllll.maxZ).color(llllllllllllllllIIlllIlIIIlIIlll, llllllllllllllllIIlllIlIIIIllIIl, llllllllllllllllIIlllIlIIIIllIII, llllllllllllllllIIlllIlIIIlIIlII).endVertex();
        llllllllllllllllIIlllIlIIIIllllI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawFullBox(AxisAlignedBB llllllllllllllllIIllllIIllIIIIll, BlockPos llllllllllllllllIIllllIIllIIIIlI, float llllllllllllllllIIllllIIllIIIIIl, int llllllllllllllllIIllllIIllIIllII, int llllllllllllllllIIllllIIllIIlIll) {
        int llllllllllllllllIIllllIIllIIlIIl = llllllllllllllllIIllllIIllIIllII >>> 24 & 0xFF;
        int llllllllllllllllIIllllIIllIIIlll = llllllllllllllllIIllllIIllIIllII >>> 16 & 0xFF;
        int llllllllllllllllIIllllIIllIIIlIl = llllllllllllllllIIllllIIllIIllII >>> 8 & 0xFF;
        int llllllllllllllllIIllllIIllIIIlII = llllllllllllllllIIllllIIllIIllII & 0xFF;
        ImpactPlusTessellator.drawFullBox(llllllllllllllllIIllllIIllIIIIll, llllllllllllllllIIllllIIllIIIIlI, llllllllllllllllIIllllIIllIIIIIl, llllllllllllllllIIllllIIllIIIlll, llllllllllllllllIIllllIIllIIIlIl, llllllllllllllllIIllllIIllIIIlII, llllllllllllllllIIllllIIllIIlIIl, llllllllllllllllIIllllIIllIIlIll);
    }

    public static void drawBoundingBoxBottomBlockPos(BlockPos llllllllllllllllIIlllIIlllllIlIl, float llllllllllllllllIIlllIlIIIIIIIIl, int llllllllllllllllIIlllIlIIIIIIIII, int llllllllllllllllIIlllIIlllllllll, int llllllllllllllllIIlllIIlllllIIIl, int llllllllllllllllIIlllIIlllllIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIlIIIIIIIIl);
        Minecraft llllllllllllllllIIlllIIlllllllII = Minecraft.getMinecraft();
        double llllllllllllllllIIlllIIllllllIll = (double)llllllllllllllllIIlllIIlllllIlIl.getX() - llllllllllllllllIIlllIIlllllllII.getRenderManager().viewerPosX;
        double llllllllllllllllIIlllIIllllllIlI = (double)llllllllllllllllIIlllIIlllllIlIl.getY() - llllllllllllllllIIlllIIlllllllII.getRenderManager().viewerPosY;
        double llllllllllllllllIIlllIIllllllIIl = (double)llllllllllllllllIIlllIIlllllIlIl.getZ() - llllllllllllllllIIlllIIlllllllII.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIIlllIIllllllIII = new AxisAlignedBB(llllllllllllllllIIlllIIllllllIll, llllllllllllllllIIlllIIllllllIlI, llllllllllllllllIIlllIIllllllIIl, llllllllllllllllIIlllIIllllllIll + 1.0, llllllllllllllllIIlllIIllllllIlI + 1.0, llllllllllllllllIIlllIIllllllIIl + 1.0);
        Tessellator llllllllllllllllIIlllIIlllllIlll = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIIlllllIllI = llllllllllllllllIIlllIIlllllIlll.getWorldRenderer();
        llllllllllllllllIIlllIIlllllIllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIIlllllIllI.pos(llllllllllllllllIIlllIIllllllIII.minX, llllllllllllllllIIlllIIllllllIII.minY, llllllllllllllllIIlllIIllllllIII.minZ).color(llllllllllllllllIIlllIlIIIIIIIII, llllllllllllllllIIlllIIlllllllll, llllllllllllllllIIlllIIlllllIIIl, llllllllllllllllIIlllIIlllllIIII).endVertex();
        llllllllllllllllIIlllIIlllllIllI.pos(llllllllllllllllIIlllIIllllllIII.maxX, llllllllllllllllIIlllIIllllllIII.minY, llllllllllllllllIIlllIIllllllIII.minZ).color(llllllllllllllllIIlllIlIIIIIIIII, llllllllllllllllIIlllIIlllllllll, llllllllllllllllIIlllIIlllllIIIl, llllllllllllllllIIlllIIlllllIIII).endVertex();
        llllllllllllllllIIlllIIlllllIllI.pos(llllllllllllllllIIlllIIllllllIII.maxX, llllllllllllllllIIlllIIllllllIII.minY, llllllllllllllllIIlllIIllllllIII.maxZ).color(llllllllllllllllIIlllIlIIIIIIIII, llllllllllllllllIIlllIIlllllllll, llllllllllllllllIIlllIIlllllIIIl, llllllllllllllllIIlllIIlllllIIII).endVertex();
        llllllllllllllllIIlllIIlllllIllI.pos(llllllllllllllllIIlllIIllllllIII.minX, llllllllllllllllIIlllIIllllllIII.minY, llllllllllllllllIIlllIIllllllIII.maxZ).color(llllllllllllllllIIlllIlIIIIIIIII, llllllllllllllllIIlllIIlllllllll, llllllllllllllllIIlllIIlllllIIIl, llllllllllllllllIIlllIIlllllIIII).endVertex();
        llllllllllllllllIIlllIIlllllIllI.pos(llllllllllllllllIIlllIIllllllIII.minX, llllllllllllllllIIlllIIllllllIII.minY, llllllllllllllllIIlllIIllllllIII.minZ).color(llllllllllllllllIIlllIlIIIIIIIII, llllllllllllllllIIlllIIlllllllll, llllllllllllllllIIlllIIlllllIIIl, llllllllllllllllIIlllIIlllllIIII).endVertex();
        llllllllllllllllIIlllIIlllllIlll.draw();
        GL11.glDisable((int)2848);
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

    public static void drawFullBox(AxisAlignedBB llllllllllllllllIIllllIIllllllII, BlockPos llllllllllllllllIIllllIIlllllIlI, float llllllllllllllllIIllllIIlllllIII, int llllllllllllllllIIllllIIlllIlIIl, int llllllllllllllllIIllllIIllllIlIl, int llllllllllllllllIIllllIIllllIIlI, int llllllllllllllllIIllllIIllllIIII) {
        ImpactPlusTessellator.prepare(7);
        ImpactPlusTessellator.drawBox(llllllllllllllllIIllllIIlllllIlI, llllllllllllllllIIllllIIlllIlIIl, llllllllllllllllIIllllIIllllIlIl, llllllllllllllllIIllllIIllllIIlI, llllllllllllllllIIllllIIllllIIII, 63);
        ImpactPlusTessellator.release();
        ImpactPlusTessellator.drawBoundingBox(llllllllllllllllIIllllIIllllllII, llllllllllllllllIIllllIIlllllIII, llllllllllllllllIIllllIIlllIlIIl, llllllllllllllllIIllllIIllllIlIl, llllllllllllllllIIllllIIllllIIlI, 255);
    }

    public static void drawBox(Vec3d llllllllllllllllIIlllIlllllIlllI, int llllllllllllllllIIlllIllllllIIll, int llllllllllllllllIIlllIlllllIllII, int llllllllllllllllIIlllIllllllIIIl, int llllllllllllllllIIlllIlllllIlIlI, int llllllllllllllllIIlllIlllllIllll) {
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), (float)llllllllllllllllIIlllIlllllIlllI.xCoord, (float)llllllllllllllllIIlllIlllllIlllI.yCoord, (float)llllllllllllllllIIlllIlllllIlllI.zCoord, 1.0f, 1.0f, 1.0f, llllllllllllllllIIlllIllllllIIll, llllllllllllllllIIlllIlllllIllII, llllllllllllllllIIlllIllllllIIIl, llllllllllllllllIIlllIlllllIlIlI, llllllllllllllllIIlllIlllllIllll);
    }

    public static void drawTinyBoundingBoxBlockPos(BlockPos llllllllllllllllIIlllIlIIlIlIIII, float llllllllllllllllIIlllIlIIlIIllll, int llllllllllllllllIIlllIlIIlIIIIIl, int llllllllllllllllIIlllIlIIlIIIIII, int llllllllllllllllIIlllIlIIIllllll, int llllllllllllllllIIlllIlIIlIIlIll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIlIIlIIllll);
        Minecraft llllllllllllllllIIlllIlIIlIIlIlI = Minecraft.getMinecraft();
        double llllllllllllllllIIlllIlIIlIIlIIl = (double)llllllllllllllllIIlllIlIIlIlIIII.getX() - llllllllllllllllIIlllIlIIlIIlIlI.getRenderManager().viewerPosX;
        double llllllllllllllllIIlllIlIIlIIlIII = (double)llllllllllllllllIIlllIlIIlIlIIII.getY() - llllllllllllllllIIlllIlIIlIIlIlI.getRenderManager().viewerPosY;
        double llllllllllllllllIIlllIlIIlIIIlll = (double)llllllllllllllllIIlllIlIIlIlIIII.getZ() - llllllllllllllllIIlllIlIIlIIlIlI.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIIlllIlIIlIIIllI = new AxisAlignedBB(llllllllllllllllIIlllIlIIlIIlIIl, llllllllllllllllIIlllIlIIlIIlIII, llllllllllllllllIIlllIlIIlIIIlll, llllllllllllllllIIlllIlIIlIIlIIl + 1.0, llllllllllllllllIIlllIlIIlIIlIII + 0.1, llllllllllllllllIIlllIlIIlIIIlll + 1.0);
        Tessellator llllllllllllllllIIlllIlIIlIIIlIl = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIlIIlIIIlII = llllllllllllllllIIlllIlIIlIIIlIl.getWorldRenderer();
        llllllllllllllllIIlllIlIIlIIIlII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlIl.draw();
        llllllllllllllllIIlllIlIIlIIIlII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlIl.draw();
        llllllllllllllllIIlllIlIIlIIIlII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.minZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.maxX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.minY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlII.pos(llllllllllllllllIIlllIlIIlIIIllI.minX, llllllllllllllllIIlllIlIIlIIIllI.maxY, llllllllllllllllIIlllIlIIlIIIllI.maxZ).color(llllllllllllllllIIlllIlIIlIIIIIl, llllllllllllllllIIlllIlIIlIIIIII, llllllllllllllllIIlllIlIIIllllll, llllllllllllllllIIlllIlIIlIIlIll).endVertex();
        llllllllllllllllIIlllIlIIlIIIlIl.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBox(BufferBuilder llllllllllllllllIIlllIlllIIIllll, AxisAlignedBB llllllllllllllllIIlllIlllIIllIlI, int llllllllllllllllIIlllIlllIIllIII, int llllllllllllllllIIlllIlllIIIllII, int llllllllllllllllIIlllIlllIIIlIll, int llllllllllllllllIIlllIlllIIlIIlI, int llllllllllllllllIIlllIlllIIIlIIl) {
        if ((llllllllllllllllIIlllIlllIIIlIIl & 1) != 0) {
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
        }
        if ((llllllllllllllllIIlllIlllIIIlIIl & 2) != 0) {
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
        }
        if ((llllllllllllllllIIlllIlllIIIlIIl & 4) != 0) {
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
        }
        if ((llllllllllllllllIIlllIlllIIIlIIl & 8) != 0) {
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
        }
        if ((llllllllllllllllIIlllIlllIIIlIIl & 0x10) != 0) {
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.minX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
        }
        if ((llllllllllllllllIIlllIlllIIIlIIl & 0x20) != 0) {
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.minY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.minZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
            llllllllllllllllIIlllIlllIIIllll.pos(llllllllllllllllIIlllIlllIIllIlI.maxX, llllllllllllllllIIlllIlllIIllIlI.maxY, llllllllllllllllIIlllIlllIIllIlI.maxZ).color(llllllllllllllllIIlllIlllIIllIII, llllllllllllllllIIlllIlllIIIllII, llllllllllllllllIIlllIlllIIIlIll, llllllllllllllllIIlllIlllIIlIIlI).endVertex();
        }
    }

    public ImpactPlusTessellator() {
        super(0x200000);
        ImpactPlusTessellator llllllllllllllllIIllllIllIIIIlll;
    }

    public static BufferBuilder getBufferBuilder() {
        return INSTANCE.getWorldRenderer();
    }

    public static void drawBoxWithVec3d(Vec3d llllllllllllllllIIlllIIlIlIlllIl, int llllllllllllllllIIlllIIlIlIlllII, int llllllllllllllllIIlllIIlIlIllIll, int llllllllllllllllIIlllIIlIlIllIlI, int llllllllllllllllIIlllIIlIlIllIIl, int llllllllllllllllIIlllIIlIlIllllI) {
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), (float)llllllllllllllllIIlllIIlIlIlllIl.xCoord, (float)llllllllllllllllIIlllIIlIlIlllIl.yCoord, (float)llllllllllllllllIIlllIIlIlIlllIl.zCoord, 1.0f, 2.0f, 1.0f, llllllllllllllllIIlllIIlIlIlllII, llllllllllllllllIIlllIIlIlIllIll, llllllllllllllllIIlllIIlIlIllIlI, llllllllllllllllIIlllIIlIlIllIIl, llllllllllllllllIIlllIIlIlIllllI);
    }

    public static void drawBox(BlockPos llllllllllllllllIIllllIIIIIllIII, int llllllllllllllllIIllllIIIIIlIIIl, int llllllllllllllllIIllllIIIIIlIIII, int llllllllllllllllIIllllIIIIIIllll, int llllllllllllllllIIllllIIIIIIlllI, int llllllllllllllllIIllllIIIIIlIIll) {
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIIllllIIIIIllIII.getX(), llllllllllllllllIIllllIIIIIllIII.getY(), llllllllllllllllIIllllIIIIIllIII.getZ(), 1.0f, 1.0f, 1.0f, llllllllllllllllIIllllIIIIIlIIIl, llllllllllllllllIIllllIIIIIlIIII, llllllllllllllllIIllllIIIIIIllll, llllllllllllllllIIllllIIIIIIlllI, llllllllllllllllIIllllIIIIIlIIll);
    }

    public static void drawBox(float llllllllllllllllIIllllIIIIlIIlll, float llllllllllllllllIIllllIIIIlIllll, float llllllllllllllllIIllllIIIIlIlllI, int llllllllllllllllIIllllIIIIlIIlII, int llllllllllllllllIIllllIIIIlIllII) {
        int llllllllllllllllIIllllIIIIlIlIll = llllllllllllllllIIllllIIIIlIIlII >>> 24 & 0xFF;
        int llllllllllllllllIIllllIIIIlIlIlI = llllllllllllllllIIllllIIIIlIIlII >>> 16 & 0xFF;
        int llllllllllllllllIIllllIIIIlIlIIl = llllllllllllllllIIllllIIIIlIIlII >>> 8 & 0xFF;
        int llllllllllllllllIIllllIIIIlIlIII = llllllllllllllllIIllllIIIIlIIlII & 0xFF;
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIIllllIIIIlIIlll, llllllllllllllllIIllllIIIIlIllll, llllllllllllllllIIllllIIIIlIlllI, 1.0f, 1.0f, 1.0f, llllllllllllllllIIllllIIIIlIlIlI, llllllllllllllllIIllllIIIIlIlIIl, llllllllllllllllIIllllIIIIlIlIII, llllllllllllllllIIllllIIIIlIlIll, llllllllllllllllIIllllIIIIlIllII);
    }

    public static void drawBoxBottom(BufferBuilder llllllllllllllllIIlllIIllIlIllII, float llllllllllllllllIIlllIIllIllIllI, float llllllllllllllllIIlllIIllIllIlIl, float llllllllllllllllIIlllIIllIlIlIIl, float llllllllllllllllIIlllIIllIllIIll, float llllllllllllllllIIlllIIllIllIIlI, float llllllllllllllllIIlllIIllIllIIIl, int llllllllllllllllIIlllIIllIllIIII, int llllllllllllllllIIlllIIllIlIIlIl, int llllllllllllllllIIlllIIllIlIIlII, int llllllllllllllllIIlllIIllIlIIIll) {
        llllllllllllllllIIlllIIllIlIllII.pos((double)(llllllllllllllllIIlllIIllIllIllI + llllllllllllllllIIlllIIllIllIIll), (double)llllllllllllllllIIlllIIllIllIlIl, (double)llllllllllllllllIIlllIIllIlIlIIl).color(llllllllllllllllIIlllIIllIllIIII, llllllllllllllllIIlllIIllIlIIlIl, llllllllllllllllIIlllIIllIlIIlII, llllllllllllllllIIlllIIllIlIIIll).endVertex();
        llllllllllllllllIIlllIIllIlIllII.pos((double)(llllllllllllllllIIlllIIllIllIllI + llllllllllllllllIIlllIIllIllIIll), (double)llllllllllllllllIIlllIIllIllIlIl, (double)(llllllllllllllllIIlllIIllIlIlIIl + llllllllllllllllIIlllIIllIllIIIl)).color(llllllllllllllllIIlllIIllIllIIII, llllllllllllllllIIlllIIllIlIIlIl, llllllllllllllllIIlllIIllIlIIlII, llllllllllllllllIIlllIIllIlIIIll).endVertex();
        llllllllllllllllIIlllIIllIlIllII.pos((double)llllllllllllllllIIlllIIllIllIllI, (double)llllllllllllllllIIlllIIllIllIlIl, (double)(llllllllllllllllIIlllIIllIlIlIIl + llllllllllllllllIIlllIIllIllIIIl)).color(llllllllllllllllIIlllIIllIllIIII, llllllllllllllllIIlllIIllIlIIlIl, llllllllllllllllIIlllIIllIlIIlII, llllllllllllllllIIlllIIllIlIIIll).endVertex();
        llllllllllllllllIIlllIIllIlIllII.pos((double)llllllllllllllllIIlllIIllIllIllI, (double)llllllllllllllllIIlllIIllIllIlIl, (double)llllllllllllllllIIlllIIllIlIlIIl).color(llllllllllllllllIIlllIIllIllIIII, llllllllllllllllIIlllIIllIlIIlIl, llllllllllllllllIIlllIIllIlIIlII, llllllllllllllllIIlllIIllIlIIIll).endVertex();
    }

    public static void drawHalfBox(BlockPos llllllllllllllllIIllllIIIllIIIlI, int llllllllllllllllIIllllIIIlIllIlI, int llllllllllllllllIIllllIIIllIIIII) {
        int llllllllllllllllIIllllIIIlIlllll = llllllllllllllllIIllllIIIlIllIlI >>> 24 & 0xFF;
        int llllllllllllllllIIllllIIIlIllllI = llllllllllllllllIIllllIIIlIllIlI >>> 16 & 0xFF;
        int llllllllllllllllIIllllIIIlIlllIl = llllllllllllllllIIllllIIIlIllIlI >>> 8 & 0xFF;
        int llllllllllllllllIIllllIIIlIlllII = llllllllllllllllIIllllIIIlIllIlI & 0xFF;
        ImpactPlusTessellator.drawHalfBox(llllllllllllllllIIllllIIIllIIIlI, llllllllllllllllIIllllIIIlIllllI, llllllllllllllllIIllllIIIlIlllIl, llllllllllllllllIIllllIIIlIlllII, llllllllllllllllIIllllIIIlIlllll, llllllllllllllllIIllllIIIllIIIII);
    }

    public static void drawFullBox(AxisAlignedBB llllllllllllllllIIllllIIlIIlllIl, BlockPos llllllllllllllllIIllllIIlIlIlIII, float llllllllllllllllIIllllIIlIlIIllI, int llllllllllllllllIIllllIIlIIllIII, int llllllllllllllllIIllllIIlIlIIIll, int llllllllllllllllIIllllIIlIIlIllI, int llllllllllllllllIIllllIIlIlIIIII, int llllllllllllllllIIllllIIlIIlIlII) {
        ImpactPlusTessellator.prepare(7);
        ImpactPlusTessellator.drawBox(llllllllllllllllIIllllIIlIlIlIII, llllllllllllllllIIllllIIlIIllIII, llllllllllllllllIIllllIIlIlIIIll, llllllllllllllllIIllllIIlIIlIllI, llllllllllllllllIIllllIIlIlIIIII, 63);
        ImpactPlusTessellator.release();
        ImpactPlusTessellator.drawBoundingBox(llllllllllllllllIIllllIIlIIlllIl, llllllllllllllllIIllllIIlIlIIllI, llllllllllllllllIIllllIIlIIllIII, llllllllllllllllIIllllIIlIlIIIll, llllllllllllllllIIllllIIlIIlIllI, llllllllllllllllIIllllIIlIIlIlII);
    }

    public static void drawBox(BufferBuilder llllllllllllllllIIlllIllllIllIIl, float llllllllllllllllIIlllIllllIIllII, float llllllllllllllllIIlllIllllIIlIll, float llllllllllllllllIIlllIllllIlIllI, float llllllllllllllllIIlllIllllIlIlIl, float llllllllllllllllIIlllIllllIIlIII, float llllllllllllllllIIlllIllllIlIIll, int llllllllllllllllIIlllIllllIlIIlI, int llllllllllllllllIIlllIllllIIIlIl, int llllllllllllllllIIlllIllllIlIIII, int llllllllllllllllIIlllIllllIIllll, int llllllllllllllllIIlllIllllIIIIIl) {
        if ((llllllllllllllllIIlllIllllIIIIIl & 1) != 0) {
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)llllllllllllllllIIlllIllllIIlIll, (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)llllllllllllllllIIlllIllllIIlIll, (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)llllllllllllllllIIlllIllllIIlIll, (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)llllllllllllllllIIlllIllllIIlIll, (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
        }
        if ((llllllllllllllllIIlllIllllIIIIIl & 2) != 0) {
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
        }
        if ((llllllllllllllllIIlllIllllIIIIIl & 4) != 0) {
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)llllllllllllllllIIlllIllllIIlIll, (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)llllllllllllllllIIlllIllllIIlIll, (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
        }
        if ((llllllllllllllllIIlllIllllIIIIIl & 8) != 0) {
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)llllllllllllllllIIlllIllllIIlIll, (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)llllllllllllllllIIlllIllllIIlIll, (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
        }
        if ((llllllllllllllllIIlllIllllIIIIIl & 0x10) != 0) {
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)llllllllllllllllIIlllIllllIIlIll, (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)llllllllllllllllIIlllIllllIIlIll, (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)llllllllllllllllIIlllIllllIIllII, (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
        }
        if ((llllllllllllllllIIlllIllllIIIIIl & 0x20) != 0) {
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)llllllllllllllllIIlllIllllIIlIll, (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)llllllllllllllllIIlllIllllIIlIll, (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)llllllllllllllllIIlllIllllIlIllI).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
            llllllllllllllllIIlllIllllIllIIl.pos((double)(llllllllllllllllIIlllIllllIIllII + llllllllllllllllIIlllIllllIlIlIl), (double)(llllllllllllllllIIlllIllllIIlIll + llllllllllllllllIIlllIllllIIlIII), (double)(llllllllllllllllIIlllIllllIlIllI + llllllllllllllllIIlllIllllIlIIll)).color(llllllllllllllllIIlllIllllIlIIlI, llllllllllllllllIIlllIllllIIIlIl, llllllllllllllllIIlllIllllIlIIII, llllllllllllllllIIlllIllllIIllll).endVertex();
        }
    }

    public static Vec3d getInterpolatedPos(Entity llllllllllllllllIIlllIIlIlIlIIll, float llllllllllllllllIIlllIIlIlIlIIlI) {
        return new Vec3d(llllllllllllllllIIlllIIlIlIlIIll.lastTickPosX, llllllllllllllllIIlllIIlIlIlIIll.lastTickPosY, llllllllllllllllIIlllIIlIlIlIIll.lastTickPosZ).add(ImpactPlusTessellator.getInterpolatedAmount(llllllllllllllllIIlllIIlIlIlIIll, llllllllllllllllIIlllIIlIlIlIIlI));
    }

    public static void release() {
        ImpactPlusTessellator.render();
        ImpactPlusTessellator.releaseGL();
    }

    public static void begin(int llllllllllllllllIIllllIlIIllIIll) {
        INSTANCE.getWorldRenderer().begin(llllllllllllllllIIllllIlIIllIIll, DefaultVertexFormats.POSITION_COLOR);
    }

    public static void glBillboardDistanceScaled(float llllllllllllllllIIllllIlIlIIlIll, float llllllllllllllllIIllllIlIlIIIIII, float llllllllllllllllIIllllIlIlIIIlll, EntityPlayer llllllllllllllllIIllllIlIIllllIl, float llllllllllllllllIIllllIlIIlllIll) {
        ImpactPlusTessellator.glBillboard(llllllllllllllllIIllllIlIlIIlIll, llllllllllllllllIIllllIlIlIIIIII, llllllllllllllllIIllllIlIlIIIlll);
        int llllllllllllllllIIllllIlIlIIIlII = (int)llllllllllllllllIIllllIlIIllllIl.getDistance((double)llllllllllllllllIIllllIlIlIIlIll, (double)llllllllllllllllIIllllIlIlIIIIII, (double)llllllllllllllllIIllllIlIlIIIlll);
        float llllllllllllllllIIllllIlIlIIIIll = (float)llllllllllllllllIIllllIlIlIIIlII / 2.0f / (2.0f + (2.0f - llllllllllllllllIIllllIlIIlllIll));
        if (llllllllllllllllIIllllIlIlIIIIll < 1.0f) {
            llllllllllllllllIIllllIlIlIIIIll = 1.0f;
        }
        GlStateManager.scale((float)llllllllllllllllIIllllIlIlIIIIll, (float)llllllllllllllllIIllllIlIlIIIIll, (float)llllllllllllllllIIllllIlIlIIIIll);
    }

    public static void render() {
        INSTANCE.draw();
    }

    public static void glBillboard(float llllllllllllllllIIllllIlIllIIIll, float llllllllllllllllIIllllIlIllIIIIl, float llllllllllllllllIIllllIlIlIlllll) {
        float llllllllllllllllIIllllIlIllIIlIl = 0.02666667f;
        GlStateManager.translate((double)((double)llllllllllllllllIIllllIlIllIIIll - Minecraft.getMinecraft().getRenderManager().renderPosX), (double)((double)llllllllllllllllIIllllIlIllIIIIl - Minecraft.getMinecraft().getRenderManager().renderPosY), (double)((double)llllllllllllllllIIllllIlIlIlllll - Minecraft.getMinecraft().getRenderManager().renderPosZ));
        GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-Minecraft.getMinecraft().thePlayer.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)Minecraft.getMinecraft().thePlayer.rotationPitch, (float)(Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)(-llllllllllllllllIIllllIlIllIIlIl), (float)(-llllllllllllllllIIllllIlIllIIlIl), (float)llllllllllllllllIIllllIlIllIIlIl);
    }

    public static void prepare(int llllllllllllllllIIllllIllIIIIIlI) {
        ImpactPlusTessellator.prepareGL();
        ImpactPlusTessellator.begin(llllllllllllllllIIllllIllIIIIIlI);
    }

    public static void drawBoundingBox2(AxisAlignedBB llllllllllllllllIIlllIlIlIlllIIl, float llllllllllllllllIIlllIlIlIllIIIl, int llllllllllllllllIIlllIlIlIllIIII, int llllllllllllllllIIlllIlIlIllIllI, int llllllllllllllllIIlllIlIlIllIlIl, int llllllllllllllllIIlllIlIlIllIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.func_187441_d((float)llllllllllllllllIIlllIlIlIllIIIl);
        BufferBuilder llllllllllllllllIIlllIlIlIllIIll = INSTANCE.getWorldRenderer();
        llllllllllllllllIIlllIlIlIllIIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.maxZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.minY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.maxX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        llllllllllllllllIIlllIlIlIllIIll.pos(llllllllllllllllIIlllIlIlIlllIIl.minX, llllllllllllllllIIlllIlIlIlllIIl.maxY, llllllllllllllllIIlllIlIlIlllIIl.minZ).color(llllllllllllllllIIlllIlIlIllIIII, llllllllllllllllIIlllIlIlIllIllI, llllllllllllllllIIlllIlIlIllIlIl, llllllllllllllllIIlllIlIlIllIlII).endVertex();
        ImpactPlusTessellator.render();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawHalfBox(BlockPos llllllllllllllllIIllllIIIIIIIllI, int llllllllllllllllIIllllIIIIIIIlIl, int llllllllllllllllIIlllIlllllllllI, int llllllllllllllllIIlllIllllllllIl, int llllllllllllllllIIllllIIIIIIIIlI, int llllllllllllllllIIlllIlllllllIll) {
        ImpactPlusTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIIllllIIIIIIIllI.getX(), llllllllllllllllIIllllIIIIIIIllI.getY(), llllllllllllllllIIllllIIIIIIIllI.getZ(), 1.0f, 0.5f, 1.0f, llllllllllllllllIIllllIIIIIIIlIl, llllllllllllllllIIlllIlllllllllI, llllllllllllllllIIlllIllllllllIl, llllllllllllllllIIllllIIIIIIIIlI, llllllllllllllllIIlllIlllllllIll);
    }

    public static void drawBoxBottom(float llllllllllllllllIIlllIIllIIIIIII, float llllllllllllllllIIlllIIllIIIIlll, float llllllllllllllllIIlllIIllIIIIllI, int llllllllllllllllIIlllIIllIIIIlIl) {
        int llllllllllllllllIIlllIIllIIIIlII = llllllllllllllllIIlllIIllIIIIlIl >>> 24 & 0xFF;
        int llllllllllllllllIIlllIIllIIIIIll = llllllllllllllllIIlllIIllIIIIlIl >>> 16 & 0xFF;
        int llllllllllllllllIIlllIIllIIIIIlI = llllllllllllllllIIlllIIllIIIIlIl >>> 8 & 0xFF;
        int llllllllllllllllIIlllIIllIIIIIIl = llllllllllllllllIIlllIIllIIIIlIl & 0xFF;
        ImpactPlusTessellator.drawBoxBottom(INSTANCE.getWorldRenderer(), llllllllllllllllIIlllIIllIIIIIII, llllllllllllllllIIlllIIllIIIIlll, llllllllllllllllIIlllIIllIIIIllI, 1.0f, 1.0f, 1.0f, llllllllllllllllIIlllIIllIIIIIll, llllllllllllllllIIlllIIllIIIIIlI, llllllllllllllllIIlllIIllIIIIIIl, llllllllllllllllIIlllIIllIIIIlII);
    }

    public static void drawBoundingBoxQuarterBlockPos(BlockPos llllllllllllllllIIlllIIlllIIlllI, float llllllllllllllllIIlllIIlllIllIlI, int llllllllllllllllIIlllIIlllIIllII, int llllllllllllllllIIlllIIlllIllIII, int llllllllllllllllIIlllIIlllIIlIlI, int llllllllllllllllIIlllIIlllIlIllI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIIlllIIlllIllIlI);
        Minecraft llllllllllllllllIIlllIIlllIlIlIl = Minecraft.getMinecraft();
        double llllllllllllllllIIlllIIlllIlIlII = (double)llllllllllllllllIIlllIIlllIIlllI.getX() - llllllllllllllllIIlllIIlllIlIlIl.getRenderManager().viewerPosX;
        double llllllllllllllllIIlllIIlllIlIIll = (double)llllllllllllllllIIlllIIlllIIlllI.getY() - llllllllllllllllIIlllIIlllIlIlIl.getRenderManager().viewerPosY;
        double llllllllllllllllIIlllIIlllIlIIlI = (double)llllllllllllllllIIlllIIlllIIlllI.getZ() - llllllllllllllllIIlllIIlllIlIlIl.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIIlllIIlllIlIIIl = new AxisAlignedBB(llllllllllllllllIIlllIIlllIlIlII, llllllllllllllllIIlllIIlllIlIIll, llllllllllllllllIIlllIIlllIlIIlI, llllllllllllllllIIlllIIlllIlIlII + 1.0, llllllllllllllllIIlllIIlllIlIIll + 1.0, llllllllllllllllIIlllIIlllIlIIlI + 1.0);
        Tessellator llllllllllllllllIIlllIIlllIlIIII = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIlllIIlllIIllll = llllllllllllllllIIlllIIlllIlIIII.getWorldRenderer();
        llllllllllllllllIIlllIIlllIIllll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIIlllIIlllIIllll.pos(llllllllllllllllIIlllIIlllIlIIIl.minX, llllllllllllllllIIlllIIlllIlIIIl.minY, llllllllllllllllIIlllIIlllIlIIIl.minZ).color(llllllllllllllllIIlllIIlllIIllII, llllllllllllllllIIlllIIlllIllIII, llllllllllllllllIIlllIIlllIIlIlI, llllllllllllllllIIlllIIlllIlIllI).endVertex();
        llllllllllllllllIIlllIIlllIIllll.pos(llllllllllllllllIIlllIIlllIlIIIl.maxX, llllllllllllllllIIlllIIlllIlIIIl.minY, llllllllllllllllIIlllIIlllIlIIIl.minZ).color(llllllllllllllllIIlllIIlllIIllII, llllllllllllllllIIlllIIlllIllIII, llllllllllllllllIIlllIIlllIIlIlI, llllllllllllllllIIlllIIlllIlIllI).endVertex();
        llllllllllllllllIIlllIIlllIIllll.pos(llllllllllllllllIIlllIIlllIlIIIl.maxX, llllllllllllllllIIlllIIlllIlIIIl.minY, llllllllllllllllIIlllIIlllIlIIIl.maxZ).color(llllllllllllllllIIlllIIlllIIllII, llllllllllllllllIIlllIIlllIllIII, llllllllllllllllIIlllIIlllIIlIlI, llllllllllllllllIIlllIIlllIlIllI).endVertex();
        llllllllllllllllIIlllIIlllIIllll.pos(llllllllllllllllIIlllIIlllIlIIIl.minX, llllllllllllllllIIlllIIlllIlIIIl.minY, llllllllllllllllIIlllIIlllIlIIIl.maxZ).color(llllllllllllllllIIlllIIlllIIllII, llllllllllllllllIIlllIIlllIllIII, llllllllllllllllIIlllIIlllIIlIlI, llllllllllllllllIIlllIIlllIlIllI).endVertex();
        llllllllllllllllIIlllIIlllIIllll.pos(llllllllllllllllIIlllIIlllIlIIIl.minX, llllllllllllllllIIlllIIlllIlIIIl.minY, llllllllllllllllIIlllIIlllIlIIIl.minZ).color(llllllllllllllllIIlllIIlllIIllII, llllllllllllllllIIlllIIlllIllIII, llllllllllllllllIIlllIIlllIIlIlI, llllllllllllllllIIlllIIlllIlIllI).endVertex();
        llllllllllllllllIIlllIIlllIlIIII.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIIlllIIlIlIIllll, double llllllllllllllllIIlllIIlIlIIlllI) {
        return ImpactPlusTessellator.getInterpolatedAmount(llllllllllllllllIIlllIIlIlIIllll, llllllllllllllllIIlllIIlIlIIlllI, llllllllllllllllIIlllIIlIlIIlllI, llllllllllllllllIIlllIIlIlIIlllI);
    }

    static {
        INSTANCE = new ImpactPlusTessellator();
    }

    public static void drawLines(BufferBuilder llllllllllllllllIIlllIllIIllIIII, float llllllllllllllllIIlllIllIlIIIlll, float llllllllllllllllIIlllIllIlIIIllI, float llllllllllllllllIIlllIllIlIIIIll, float llllllllllllllllIIlllIllIlIIIIlI, float llllllllllllllllIIlllIllIlIIIIIl, float llllllllllllllllIIlllIllIIlIIIlI, int llllllllllllllllIIlllIllIIlllIll, int llllllllllllllllIIlllIllIIlIIIII, int llllllllllllllllIIlllIllIIIlllll, int llllllllllllllllIIlllIllIIIllllI, int llllllllllllllllIIlllIllIIllIIlI) {
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x11) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)llllllllllllllllIIlllIllIlIIIllI, (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)llllllllllllllllIIlllIllIlIIIllI, (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x12) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x21) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)llllllllllllllllIIlllIllIlIIIllI, (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)llllllllllllllllIIlllIllIlIIIllI, (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x22) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 5) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)llllllllllllllllIIlllIllIlIIIllI, (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)llllllllllllllllIIlllIllIlIIIllI, (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 6) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 9) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)llllllllllllllllIIlllIllIlIIIllI, (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)llllllllllllllllIIlllIllIlIIIllI, (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0xA) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x14) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)llllllllllllllllIIlllIllIlIIIllI, (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x24) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)llllllllllllllllIIlllIllIlIIIllI, (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)llllllllllllllllIIlllIllIlIIIIll).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x18) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)llllllllllllllllIIlllIllIlIIIllI, (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)llllllllllllllllIIlllIllIlIIIlll, (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
        if ((llllllllllllllllIIlllIllIIllIIlI & 0x28) != 0) {
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)llllllllllllllllIIlllIllIlIIIllI, (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
            llllllllllllllllIIlllIllIIllIIII.pos((double)(llllllllllllllllIIlllIllIlIIIlll + llllllllllllllllIIlllIllIlIIIIlI), (double)(llllllllllllllllIIlllIllIlIIIllI + llllllllllllllllIIlllIllIlIIIIIl), (double)(llllllllllllllllIIlllIllIlIIIIll + llllllllllllllllIIlllIllIIlIIIlI)).color(llllllllllllllllIIlllIllIIlllIll, llllllllllllllllIIlllIllIIlIIIII, llllllllllllllllIIlllIllIIIlllll, llllllllllllllllIIlllIllIIIllllI).endVertex();
        }
    }

    public static void drawFullBox(AxisAlignedBB llllllllllllllllIIllllIlIIlIlIlI, BlockPos llllllllllllllllIIllllIlIIIlllll, float llllllllllllllllIIllllIlIIlIlIII, int llllllllllllllllIIllllIlIIlIIlll) {
        int llllllllllllllllIIllllIlIIlIIllI = llllllllllllllllIIllllIlIIlIIlll >>> 24 & 0xFF;
        int llllllllllllllllIIllllIlIIlIIlIl = llllllllllllllllIIllllIlIIlIIlll >>> 16 & 0xFF;
        int llllllllllllllllIIllllIlIIlIIlII = llllllllllllllllIIllllIlIIlIIlll >>> 8 & 0xFF;
        int llllllllllllllllIIllllIlIIlIIIlI = llllllllllllllllIIllllIlIIlIIlll & 0xFF;
        ImpactPlusTessellator.drawFullBox(llllllllllllllllIIllllIlIIlIlIlI, llllllllllllllllIIllllIlIIIlllll, llllllllllllllllIIllllIlIIlIlIII, llllllllllllllllIIllllIlIIlIIlIl, llllllllllllllllIIllllIlIIlIIlII, llllllllllllllllIIllllIlIIlIIIlI, llllllllllllllllIIllllIlIIlIIllI);
    }

    public static void drawBoxBottom(BlockPos llllllllllllllllIIlllIIlIllIlllI, int llllllllllllllllIIlllIIlIllIllIl, int llllllllllllllllIIlllIIlIlllIIIl, int llllllllllllllllIIlllIIlIlllIIII, int llllllllllllllllIIlllIIlIllIlIlI) {
        ImpactPlusTessellator.drawBoxBottom(INSTANCE.getWorldRenderer(), llllllllllllllllIIlllIIlIllIlllI.getX(), llllllllllllllllIIlllIIlIllIlllI.getY(), llllllllllllllllIIlllIIlIllIlllI.getZ(), 1.0f, 1.0f, 1.0f, llllllllllllllllIIlllIIlIllIllIl, llllllllllllllllIIlllIIlIlllIIIl, llllllllllllllllIIlllIIlIlllIIII, llllllllllllllllIIlllIIlIllIlIlI);
    }
}

