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
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.util.render;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

public class KamiTessellator
extends Tessellator {
    public static /* synthetic */ KamiTessellator INSTANCE;

    public static void drawBox(float llllllllllllllllIllIIlIIIlIlllll, float llllllllllllllllIllIIlIIIlIllllI, float llllllllllllllllIllIIlIIIlIlllIl, int llllllllllllllllIllIIlIIIlIlllII, int llllllllllllllllIllIIlIIIlIllIll) {
        int llllllllllllllllIllIIlIIIllIIIll = llllllllllllllllIllIIlIIIlIlllII >>> 24 & 0xFF;
        int llllllllllllllllIllIIlIIIllIIIlI = llllllllllllllllIllIIlIIIlIlllII >>> 16 & 0xFF;
        int llllllllllllllllIllIIlIIIllIIIIl = llllllllllllllllIllIIlIIIlIlllII >>> 8 & 0xFF;
        int llllllllllllllllIllIIlIIIllIIIII = llllllllllllllllIllIIlIIIlIlllII & 0xFF;
        KamiTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIllIIlIIIlIlllll, llllllllllllllllIllIIlIIIlIllllI, llllllllllllllllIllIIlIIIlIlllIl, 1.0f, 1.0f, 1.0f, llllllllllllllllIllIIlIIIllIIIlI, llllllllllllllllIllIIlIIIllIIIIl, llllllllllllllllIllIIlIIIllIIIII, llllllllllllllllIllIIlIIIllIIIll, llllllllllllllllIllIIlIIIlIllIll);
    }

    public static void prepare(int llllllllllllllllIllIIlIIlIIIlIlI) {
        KamiTessellator.prepareGL();
        KamiTessellator.begin(llllllllllllllllIllIIlIIlIIIlIlI);
    }

    public static void drawBoundingBoxBlockPos(BlockPos llllllllllllllllIllIIIlllIIIllll, float llllllllllllllllIllIIIlllIIIlllI, int llllllllllllllllIllIIIlllIIllIlI, int llllllllllllllllIllIIIlllIIIllII, int llllllllllllllllIllIIIlllIIIlIll, int llllllllllllllllIllIIIlllIIlIlll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIllIIIlllIIIlllI);
        Minecraft llllllllllllllllIllIIIlllIIlIllI = Minecraft.getMinecraft();
        double llllllllllllllllIllIIIlllIIlIlIl = (double)llllllllllllllllIllIIIlllIIIllll.getX() - llllllllllllllllIllIIIlllIIlIllI.getRenderManager().viewerPosX;
        double llllllllllllllllIllIIIlllIIlIlII = (double)llllllllllllllllIllIIIlllIIIllll.getY() - llllllllllllllllIllIIIlllIIlIllI.getRenderManager().viewerPosY;
        double llllllllllllllllIllIIIlllIIlIIll = (double)llllllllllllllllIllIIIlllIIIllll.getZ() - llllllllllllllllIllIIIlllIIlIllI.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIllIIIlllIIlIIlI = new AxisAlignedBB(llllllllllllllllIllIIIlllIIlIlIl, llllllllllllllllIllIIIlllIIlIlII, llllllllllllllllIllIIIlllIIlIIll, llllllllllllllllIllIIIlllIIlIlIl + 1.0, llllllllllllllllIllIIIlllIIlIlII + 1.0, llllllllllllllllIllIIIlllIIlIIll + 1.0);
        Tessellator llllllllllllllllIllIIIlllIIlIIIl = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIllIIIlllIIlIIII = llllllllllllllllIllIIIlllIIlIIIl.getWorldRenderer();
        llllllllllllllllIllIIIlllIIlIIII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIIl.draw();
        llllllllllllllllIllIIIlllIIlIIII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIIl.draw();
        llllllllllllllllIllIIIlllIIlIIII.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.minZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.maxX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.minY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIII.pos(llllllllllllllllIllIIIlllIIlIIlI.minX, llllllllllllllllIllIIIlllIIlIIlI.maxY, llllllllllllllllIllIIIlllIIlIIlI.maxZ).color(llllllllllllllllIllIIIlllIIllIlI, llllllllllllllllIllIIIlllIIIllII, llllllllllllllllIllIIIlllIIIlIll, llllllllllllllllIllIIIlllIIlIlll).endVertex();
        llllllllllllllllIllIIIlllIIlIIIl.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawBox(BlockPos llllllllllllllllIllIIlIIIlIIlIlI, int llllllllllllllllIllIIlIIIlIIllll, int llllllllllllllllIllIIlIIIlIIlIII, int llllllllllllllllIllIIlIIIlIIllIl, int llllllllllllllllIllIIlIIIlIIIllI, int llllllllllllllllIllIIlIIIlIIlIll) {
        KamiTessellator.drawBox(INSTANCE.getWorldRenderer(), llllllllllllllllIllIIlIIIlIIlIlI.getX(), llllllllllllllllIllIIlIIIlIIlIlI.getY(), llllllllllllllllIllIIlIIIlIIlIlI.getZ(), 1.0f, 1.0f, 1.0f, llllllllllllllllIllIIlIIIlIIllll, llllllllllllllllIllIIlIIIlIIlIII, llllllllllllllllIllIIlIIIlIIllIl, llllllllllllllllIllIIlIIIlIIIllI, llllllllllllllllIllIIlIIIlIIlIll);
    }

    public static void drawBoundingBox(AxisAlignedBB llllllllllllllllIllIIIlllIlllIIl, float llllllllllllllllIllIIIlllIlllIII, int llllllllllllllllIllIIIlllIllIlll, int llllllllllllllllIllIIIlllIllIllI, int llllllllllllllllIllIIIlllIlIllIl, int llllllllllllllllIllIIIlllIllIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIllIIIlllIlllIII);
        Tessellator llllllllllllllllIllIIIlllIllIIll = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIllIIIlllIllIIlI = llllllllllllllllIllIIIlllIllIIll.getWorldRenderer();
        llllllllllllllllIllIIIlllIllIIlI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIll.draw();
        llllllllllllllllIllIIIlllIllIIlI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIll.draw();
        llllllllllllllllIllIIIlllIllIIlI.begin(1, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.minZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.maxX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.minY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIlI.pos(llllllllllllllllIllIIIlllIlllIIl.minX, llllllllllllllllIllIIIlllIlllIIl.maxY, llllllllllllllllIllIIIlllIlllIIl.maxZ).color(llllllllllllllllIllIIIlllIllIlll, llllllllllllllllIllIIIlllIllIllI, llllllllllllllllIllIIIlllIlIllIl, llllllllllllllllIllIIIlllIllIlII).endVertex();
        llllllllllllllllIllIIIlllIllIIll.draw();
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

    static {
        INSTANCE = new KamiTessellator();
    }

    public static void drawBox(float llllllllllllllllIllIIlIIIIlllIIl, float llllllllllllllllIllIIlIIIIlIllIl, float llllllllllllllllIllIIlIIIIllIlll, float llllllllllllllllIllIIlIIIIllIllI, float llllllllllllllllIllIIlIIIIlIlIlI, float llllllllllllllllIllIIlIIIIlIlIIl, int llllllllllllllllIllIIlIIIIllIIll, int llllllllllllllllIllIIlIIIIllIIlI, int llllllllllllllllIllIIlIIIIlIIllI, int llllllllllllllllIllIIlIIIIlIIlIl, int llllllllllllllllIllIIlIIIIlIIlII) {
        KamiTessellator.drawBox(KamiTessellator.getBufferBuilder(), llllllllllllllllIllIIlIIIIlllIIl, llllllllllllllllIllIIlIIIIlIllIl, llllllllllllllllIllIIlIIIIllIlll, llllllllllllllllIllIIlIIIIllIllI, llllllllllllllllIllIIlIIIIlIlIlI, llllllllllllllllIllIIlIIIIlIlIIl, llllllllllllllllIllIIlIIIIllIIll, llllllllllllllllIllIIlIIIIllIIlI, llllllllllllllllIllIIlIIIIlIIllI, llllllllllllllllIllIIlIIIIlIIlIl, llllllllllllllllIllIIlIIIIlIIlII);
    }

    public static void release() {
        KamiTessellator.render();
        KamiTessellator.releaseGL();
    }

    public static BufferBuilder getBufferBuilder() {
        return INSTANCE.getWorldRenderer();
    }

    public static void drawLines(BufferBuilder llllllllllllllllIllIIIlllllIIlll, float llllllllllllllllIllIIIllllllIIlI, float llllllllllllllllIllIIIlllllIIlIl, float llllllllllllllllIllIIIllllllIIII, float llllllllllllllllIllIIIlllllIIIll, float llllllllllllllllIllIIIlllllIIIlI, float llllllllllllllllIllIIIlllllIIIIl, int llllllllllllllllIllIIIlllllIIIII, int llllllllllllllllIllIIIlllllIlIll, int llllllllllllllllIllIIIllllIllllI, int llllllllllllllllIllIIIllllIlllII, int llllllllllllllllIllIIIlllllIlIII) {
        if ((llllllllllllllllIllIIIlllllIlIII & 0x11) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)llllllllllllllllIllIIIlllllIIlIl, (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)llllllllllllllllIllIIIlllllIIlIl, (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x12) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x21) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)llllllllllllllllIllIIIlllllIIlIl, (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)llllllllllllllllIllIIIlllllIIlIl, (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x22) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 5) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)llllllllllllllllIllIIIlllllIIlIl, (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)llllllllllllllllIllIIIlllllIIlIl, (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 6) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 9) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)llllllllllllllllIllIIIlllllIIlIl, (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)llllllllllllllllIllIIIlllllIIlIl, (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0xA) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x14) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)llllllllllllllllIllIIIlllllIIlIl, (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x24) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)llllllllllllllllIllIIIlllllIIlIl, (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)llllllllllllllllIllIIIllllllIIII).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x18) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)llllllllllllllllIllIIIlllllIIlIl, (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)llllllllllllllllIllIIIllllllIIlI, (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
        if ((llllllllllllllllIllIIIlllllIlIII & 0x28) != 0) {
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)llllllllllllllllIllIIIlllllIIlIl, (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
            llllllllllllllllIllIIIlllllIIlll.pos((double)(llllllllllllllllIllIIIllllllIIlI + llllllllllllllllIllIIIlllllIIIll), (double)(llllllllllllllllIllIIIlllllIIlIl + llllllllllllllllIllIIIlllllIIIlI), (double)(llllllllllllllllIllIIIllllllIIII + llllllllllllllllIllIIIlllllIIIIl)).color(llllllllllllllllIllIIIlllllIIIII, llllllllllllllllIllIIIlllllIlIll, llllllllllllllllIllIIIllllIllllI, llllllllllllllllIllIIIllllIlllII).endVertex();
        }
    }

    public static void drawBox(BufferBuilder llllllllllllllllIllIIlIIIIIlIlll, float llllllllllllllllIllIIlIIIIIlIllI, float llllllllllllllllIllIIlIIIIIlIlIl, float llllllllllllllllIllIIlIIIIIIlIII, float llllllllllllllllIllIIlIIIIIlIIll, float llllllllllllllllIllIIlIIIIIIIllI, float llllllllllllllllIllIIlIIIIIIIlIl, int llllllllllllllllIllIIlIIIIIIIlII, int llllllllllllllllIllIIlIIIIIIllll, int llllllllllllllllIllIIlIIIIIIIIlI, int llllllllllllllllIllIIlIIIIIIllIl, int llllllllllllllllIllIIlIIIIIIIIII) {
        if ((llllllllllllllllIllIIlIIIIIIIIII & 1) != 0) {
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
        }
        if ((llllllllllllllllIllIIlIIIIIIIIII & 2) != 0) {
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
        }
        if ((llllllllllllllllIllIIlIIIIIIIIII & 4) != 0) {
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
        }
        if ((llllllllllllllllIllIIlIIIIIIIIII & 8) != 0) {
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
        }
        if ((llllllllllllllllIllIIlIIIIIIIIII & 0x10) != 0) {
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)llllllllllllllllIllIIlIIIIIlIllI, (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
        }
        if ((llllllllllllllllIllIIlIIIIIIIIII & 0x20) != 0) {
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)llllllllllllllllIllIIlIIIIIlIlIl, (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)llllllllllllllllIllIIlIIIIIIlIII).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
            llllllllllllllllIllIIlIIIIIlIlll.pos((double)(llllllllllllllllIllIIlIIIIIlIllI + llllllllllllllllIllIIlIIIIIlIIll), (double)(llllllllllllllllIllIIlIIIIIlIlIl + llllllllllllllllIllIIlIIIIIIIllI), (double)(llllllllllllllllIllIIlIIIIIIlIII + llllllllllllllllIllIIlIIIIIIIlIl)).color(llllllllllllllllIllIIlIIIIIIIlII, llllllllllllllllIllIIlIIIIIIllll, llllllllllllllllIllIIlIIIIIIIIlI, llllllllllllllllIllIIlIIIIIIllIl).endVertex();
        }
    }

    public static void drawBoundingBoxBottomBlockPos(BlockPos llllllllllllllllIllIIIllIllIlIII, float llllllllllllllllIllIIIllIlllIlII, int llllllllllllllllIllIIIllIllIIllI, int llllllllllllllllIllIIIllIllIIlIl, int llllllllllllllllIllIIIllIlllIIIl, int llllllllllllllllIllIIIllIlllIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)llllllllllllllllIllIIIllIlllIlII);
        Minecraft llllllllllllllllIllIIIllIllIllll = Minecraft.getMinecraft();
        double llllllllllllllllIllIIIllIllIlllI = (double)llllllllllllllllIllIIIllIllIlIII.getX() - llllllllllllllllIllIIIllIllIllll.getRenderManager().viewerPosX;
        double llllllllllllllllIllIIIllIllIllIl = (double)llllllllllllllllIllIIIllIllIlIII.getY() - llllllllllllllllIllIIIllIllIllll.getRenderManager().viewerPosY;
        double llllllllllllllllIllIIIllIllIllII = (double)llllllllllllllllIllIIIllIllIlIII.getZ() - llllllllllllllllIllIIIllIllIllll.getRenderManager().viewerPosZ;
        AxisAlignedBB llllllllllllllllIllIIIllIllIlIll = new AxisAlignedBB(llllllllllllllllIllIIIllIllIlllI, llllllllllllllllIllIIIllIllIllIl, llllllllllllllllIllIIIllIllIllII, llllllllllllllllIllIIIllIllIlllI + 1.0, llllllllllllllllIllIIIllIllIllIl + 1.0, llllllllllllllllIllIIIllIllIllII + 1.0);
        Tessellator llllllllllllllllIllIIIllIllIlIlI = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIllIIIllIllIlIIl = llllllllllllllllIllIIIllIllIlIlI.getWorldRenderer();
        llllllllllllllllIllIIIllIllIlIIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllllllIllIIIllIllIlIIl.pos(llllllllllllllllIllIIIllIllIlIll.minX, llllllllllllllllIllIIIllIllIlIll.minY, llllllllllllllllIllIIIllIllIlIll.minZ).color(llllllllllllllllIllIIIllIllIIllI, llllllllllllllllIllIIIllIllIIlIl, llllllllllllllllIllIIIllIlllIIIl, llllllllllllllllIllIIIllIlllIIII).endVertex();
        llllllllllllllllIllIIIllIllIlIIl.pos(llllllllllllllllIllIIIllIllIlIll.maxX, llllllllllllllllIllIIIllIllIlIll.minY, llllllllllllllllIllIIIllIllIlIll.minZ).color(llllllllllllllllIllIIIllIllIIllI, llllllllllllllllIllIIIllIllIIlIl, llllllllllllllllIllIIIllIlllIIIl, llllllllllllllllIllIIIllIlllIIII).endVertex();
        llllllllllllllllIllIIIllIllIlIIl.pos(llllllllllllllllIllIIIllIllIlIll.maxX, llllllllllllllllIllIIIllIllIlIll.minY, llllllllllllllllIllIIIllIllIlIll.maxZ).color(llllllllllllllllIllIIIllIllIIllI, llllllllllllllllIllIIIllIllIIlIl, llllllllllllllllIllIIIllIlllIIIl, llllllllllllllllIllIIIllIlllIIII).endVertex();
        llllllllllllllllIllIIIllIllIlIIl.pos(llllllllllllllllIllIIIllIllIlIll.minX, llllllllllllllllIllIIIllIllIlIll.minY, llllllllllllllllIllIIIllIllIlIll.maxZ).color(llllllllllllllllIllIIIllIllIIllI, llllllllllllllllIllIIIllIllIIlIl, llllllllllllllllIllIIIllIlllIIIl, llllllllllllllllIllIIIllIlllIIII).endVertex();
        llllllllllllllllIllIIIllIllIlIIl.pos(llllllllllllllllIllIIIllIllIlIll.minX, llllllllllllllllIllIIIllIllIlIll.minY, llllllllllllllllIllIIIllIllIlIll.minZ).color(llllllllllllllllIllIIIllIllIIllI, llllllllllllllllIllIIIllIllIIlIl, llllllllllllllllIllIIIllIlllIIIl, llllllllllllllllIllIIIllIlllIIII).endVertex();
        llllllllllllllllIllIIIllIllIlIlI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void begin(int llllllllllllllllIllIIlIIlIIIlIII) {
        INSTANCE.getWorldRenderer().begin(llllllllllllllllIllIIlIIlIIIlIII, DefaultVertexFormats.POSITION_COLOR);
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

    public static void drawBox(BlockPos llllllllllllllllIllIIlIIIlllllll, int llllllllllllllllIllIIlIIIlllIlll, int llllllllllllllllIllIIlIIIlllIllI) {
        int llllllllllllllllIllIIlIIIlllllII = llllllllllllllllIllIIlIIIlllIlll >>> 24 & 0xFF;
        int llllllllllllllllIllIIlIIIllllIll = llllllllllllllllIllIIlIIIlllIlll >>> 16 & 0xFF;
        int llllllllllllllllIllIIlIIIllllIlI = llllllllllllllllIllIIlIIIlllIlll >>> 8 & 0xFF;
        int llllllllllllllllIllIIlIIIllllIIl = llllllllllllllllIllIIlIIIlllIlll & 0xFF;
        KamiTessellator.drawBox(llllllllllllllllIllIIlIIIlllllll, llllllllllllllllIllIIlIIIllllIll, llllllllllllllllIllIIlIIIllllIlI, llllllllllllllllIllIIlIIIllllIIl, llllllllllllllllIllIIlIIIlllllII, llllllllllllllllIllIIlIIIlllIllI);
    }

    private KamiTessellator() {
        super(0x200000);
        KamiTessellator llllllllllllllllIllIIlIIlIIIllIl;
    }

    public static void releaseGL() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public static final class GeometryMasks {
        public static final /* synthetic */ HashMap<EnumFacing, Integer> FACEMAP;

        public GeometryMasks() {
            GeometryMasks llIIllIllIIIIll;
        }

        static {
            FACEMAP = new HashMap();
            FACEMAP.put(EnumFacing.DOWN, 1);
            FACEMAP.put(EnumFacing.WEST, 16);
            FACEMAP.put(EnumFacing.NORTH, 4);
            FACEMAP.put(EnumFacing.SOUTH, 8);
            FACEMAP.put(EnumFacing.EAST, 32);
            FACEMAP.put(EnumFacing.UP, 2);
        }

        public static final class Quad {
            public static final /* synthetic */ int EAST;
            public static final /* synthetic */ int NORTH;
            public static final /* synthetic */ int SOUTH;
            public static final /* synthetic */ int DOWN;
            public static final /* synthetic */ int ALL;
            public static final /* synthetic */ int UP;
            public static final /* synthetic */ int WEST;

            public Quad() {
                Quad llllllllllllllllIllIllIIlIllllII;
            }

            static {
                ALL = 63;
                UP = 2;
                NORTH = 4;
                EAST = 32;
                SOUTH = 8;
                DOWN = 1;
                WEST = 16;
            }
        }

        public static final class Line {
            public static final /* synthetic */ int UP_WEST;
            public static final /* synthetic */ int ALL;
            public static final /* synthetic */ int SOUTH_WEST;
            public static final /* synthetic */ int UP_NORTH;
            public static final /* synthetic */ int UP_SOUTH;
            public static final /* synthetic */ int DOWN_SOUTH;
            public static final /* synthetic */ int SOUTH_EAST;
            public static final /* synthetic */ int DOWN_WEST;
            public static final /* synthetic */ int NORTH_EAST;
            public static final /* synthetic */ int DOWN_EAST;
            public static final /* synthetic */ int NORTH_WEST;
            public static final /* synthetic */ int UP_EAST;
            public static final /* synthetic */ int DOWN_NORTH;

            static {
                UP_WEST = 18;
                DOWN_SOUTH = 9;
                SOUTH_EAST = 40;
                UP_NORTH = 6;
                NORTH_WEST = 20;
                DOWN_EAST = 33;
                SOUTH_WEST = 24;
                UP_EAST = 34;
                DOWN_NORTH = 5;
                UP_SOUTH = 10;
                DOWN_WEST = 17;
                ALL = 63;
                NORTH_EAST = 36;
            }

            public Line() {
                Line llllllllllllllllllIlllIIlIlllllI;
            }
        }
    }
}

