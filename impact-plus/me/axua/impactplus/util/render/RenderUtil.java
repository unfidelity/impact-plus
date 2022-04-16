/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.util.render;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public final class RenderUtil {
    private static final /* synthetic */ FloatBuffer PROJECTION;
    private static final /* synthetic */ FloatBuffer MODELVIEW;
    private static final /* synthetic */ IntBuffer VIEWPORT;

    public static void updateModelViewProjectionMatrix() {
        GL11.glGetFloat((int)2982, (FloatBuffer)MODELVIEW);
        GL11.glGetFloat((int)2983, (FloatBuffer)PROJECTION);
        GL11.glGetInteger((int)2978, (IntBuffer)VIEWPORT);
        ScaledResolution lllllllllllllllllllIIllllllIIIlI = new ScaledResolution(Minecraft.getMinecraft());
    }

    public static void drawOutlineRect(float lllllllllllllllllllIIlllIIlIlIII, float lllllllllllllllllllIIlllIIlIIIIl, float lllllllllllllllllllIIlllIIlIIIII, float lllllllllllllllllllIIlllIIIlllll, float lllllllllllllllllllIIlllIIlIIlII, int lllllllllllllllllllIIlllIIIlllII) {
        RenderUtil.drawRect(lllllllllllllllllllIIlllIIlIlIII, lllllllllllllllllllIIlllIIlIIIIl, lllllllllllllllllllIIlllIIlIlIII - lllllllllllllllllllIIlllIIlIIlII, lllllllllllllllllllIIlllIIIlllll, lllllllllllllllllllIIlllIIIlllII);
        RenderUtil.drawRect(lllllllllllllllllllIIlllIIlIIIII + lllllllllllllllllllIIlllIIlIIlII, lllllllllllllllllllIIlllIIlIIIIl, lllllllllllllllllllIIlllIIlIIIII, lllllllllllllllllllIIlllIIIlllll, lllllllllllllllllllIIlllIIIlllII);
        RenderUtil.drawRect(lllllllllllllllllllIIlllIIlIlIII, lllllllllllllllllllIIlllIIlIIIIl, lllllllllllllllllllIIlllIIlIIIII, lllllllllllllllllllIIlllIIlIIIIl - lllllllllllllllllllIIlllIIlIIlII, lllllllllllllllllllIIlllIIIlllII);
        RenderUtil.drawRect(lllllllllllllllllllIIlllIIlIlIII, lllllllllllllllllllIIlllIIIlllll + lllllllllllllllllllIIlllIIlIIlII, lllllllllllllllllllIIlllIIlIIIII, lllllllllllllllllllIIlllIIIlllll, lllllllllllllllllllIIlllIIIlllII);
    }

    public static void glBillboard(float lllllllllllllllllllIIlIllIlIIIlI, float lllllllllllllllllllIIlIllIlIIIII, float lllllllllllllllllllIIlIllIlIIllI) {
        float lllllllllllllllllllIIlIllIlIIlII = 0.02666667f;
        GlStateManager.translate((double)((double)lllllllllllllllllllIIlIllIlIIIlI - Minecraft.getMinecraft().getRenderManager().renderPosX), (double)((double)lllllllllllllllllllIIlIllIlIIIII - Minecraft.getMinecraft().getRenderManager().renderPosY), (double)((double)lllllllllllllllllllIIlIllIlIIllI - Minecraft.getMinecraft().getRenderManager().renderPosZ));
        GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-Minecraft.getMinecraft().thePlayer.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)Minecraft.getMinecraft().thePlayer.rotationPitch, (float)(Minecraft.getMinecraft().gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)(-lllllllllllllllllllIIlIllIlIIlII), (float)(-lllllllllllllllllllIIlIllIlIIlII), (float)lllllllllllllllllllIIlIllIlIIlII);
    }

    public static void drawPlane(AxisAlignedBB lllllllllllllllllllIIlIllllllIIl, int lllllllllllllllllllIIlIllllllIII) {
        float lllllllllllllllllllIIlIlllllIlll = (float)(lllllllllllllllllllIIlIllllllIII >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlIlllllIllI = (float)(lllllllllllllllllllIIlIllllllIII >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlIlllllIlIl = (float)(lllllllllllllllllllIIlIllllllIII >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlIlllllIlII = (float)(lllllllllllllllllllIIlIllllllIII & 0xFF) / 255.0f;
        double lllllllllllllllllllIIlIlllllIIll = lllllllllllllllllllIIlIllllllIIl.minX;
        double lllllllllllllllllllIIlIlllllIIlI = lllllllllllllllllllIIlIllllllIIl.minY;
        double lllllllllllllllllllIIlIlllllIIIl = lllllllllllllllllllIIlIllllllIIl.minZ;
        double lllllllllllllllllllIIlIlllllIIII = lllllllllllllllllllIIlIllllllIIl.maxX;
        double lllllllllllllllllllIIlIllllIllll = lllllllllllllllllllIIlIllllllIIl.maxY;
        double lllllllllllllllllllIIlIllllIlllI = lllllllllllllllllllIIlIllllllIIl.maxZ;
        Tessellator lllllllllllllllllllIIlIllllIllIl = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIlIllllIllII = lllllllllllllllllllIIlIllllIllIl.getWorldRenderer();
        lllllllllllllllllllIIlIllllIllII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIlIllllIllII.pos(lllllllllllllllllllIIlIlllllIIll, lllllllllllllllllllIIlIlllllIIlI, lllllllllllllllllllIIlIlllllIIIl).color(lllllllllllllllllllIIlIlllllIllI, lllllllllllllllllllIIlIlllllIlIl, lllllllllllllllllllIIlIlllllIlII, lllllllllllllllllllIIlIlllllIlll).endVertex();
        lllllllllllllllllllIIlIllllIllII.pos(lllllllllllllllllllIIlIlllllIIII, lllllllllllllllllllIIlIlllllIIlI, lllllllllllllllllllIIlIllllIlllI).color(lllllllllllllllllllIIlIlllllIllI, lllllllllllllllllllIIlIlllllIlIl, lllllllllllllllllllIIlIlllllIlII, lllllllllllllllllllIIlIlllllIlll).endVertex();
        lllllllllllllllllllIIlIllllIllII.pos(lllllllllllllllllllIIlIlllllIIll, lllllllllllllllllllIIlIlllllIIlI, lllllllllllllllllllIIlIllllIlllI).color(lllllllllllllllllllIIlIlllllIllI, lllllllllllllllllllIIlIlllllIlIl, lllllllllllllllllllIIlIlllllIlII, 0.0f).endVertex();
        lllllllllllllllllllIIlIllllIllII.pos(lllllllllllllllllllIIlIllllIlllI, lllllllllllllllllllIIlIlllllIIlI, lllllllllllllllllllIIlIlllllIIIl).color(lllllllllllllllllllIIlIlllllIllI, lllllllllllllllllllIIlIlllllIlIl, lllllllllllllllllllIIlIlllllIlII, lllllllllllllllllllIIlIlllllIlll).endVertex();
        lllllllllllllllllllIIlIllllIllIl.draw();
    }

    public static void drawTexture(float lllllllllllllllllllIIlIlIllIllII, float lllllllllllllllllllIIlIlIllIlIll, float lllllllllllllllllllIIlIlIlllIlII, float lllllllllllllllllllIIlIlIlllIIll, float lllllllllllllllllllIIlIlIlllIIlI, float lllllllllllllllllllIIlIlIlllIIIl) {
        float lllllllllllllllllllIIlIlIlllIIII = 0.00390625f;
        float lllllllllllllllllllIIlIlIllIllll = 0.00390625f;
        Tessellator lllllllllllllllllllIIlIlIllIlllI = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIlIlIllIllIl = lllllllllllllllllllIIlIlIllIlllI.getWorldRenderer();
        lllllllllllllllllllIIlIlIllIllIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllllllllIIlIlIllIllIl.pos((double)lllllllllllllllllllIIlIlIllIllII, (double)(lllllllllllllllllllIIlIlIllIlIll + lllllllllllllllllllIIlIlIlllIIIl), 0.0).func_187315_a((double)(lllllllllllllllllllIIlIlIlllIlII * lllllllllllllllllllIIlIlIlllIIII), (double)((lllllllllllllllllllIIlIlIlllIIll + lllllllllllllllllllIIlIlIlllIIIl) * lllllllllllllllllllIIlIlIllIllll)).endVertex();
        lllllllllllllllllllIIlIlIllIllIl.pos((double)(lllllllllllllllllllIIlIlIllIllII + lllllllllllllllllllIIlIlIlllIIlI), (double)(lllllllllllllllllllIIlIlIllIlIll + lllllllllllllllllllIIlIlIlllIIIl), 0.0).func_187315_a((double)((lllllllllllllllllllIIlIlIlllIlII + lllllllllllllllllllIIlIlIlllIIlI) * lllllllllllllllllllIIlIlIlllIIII), (double)((lllllllllllllllllllIIlIlIlllIIll + lllllllllllllllllllIIlIlIlllIIIl) * lllllllllllllllllllIIlIlIllIllll)).endVertex();
        lllllllllllllllllllIIlIlIllIllIl.pos((double)(lllllllllllllllllllIIlIlIllIllII + lllllllllllllllllllIIlIlIlllIIlI), (double)lllllllllllllllllllIIlIlIllIlIll, 0.0).func_187315_a((double)((lllllllllllllllllllIIlIlIlllIlII + lllllllllllllllllllIIlIlIlllIIlI) * lllllllllllllllllllIIlIlIlllIIII), (double)(lllllllllllllllllllIIlIlIlllIIll * lllllllllllllllllllIIlIlIllIllll)).endVertex();
        lllllllllllllllllllIIlIlIllIllIl.pos((double)lllllllllllllllllllIIlIlIllIllII, (double)lllllllllllllllllllIIlIlIllIlIll, 0.0).func_187315_a((double)(lllllllllllllllllllIIlIlIlllIlII * lllllllllllllllllllIIlIlIlllIIII), (double)(lllllllllllllllllllIIlIlIlllIIll * lllllllllllllllllllIIlIlIllIllll)).endVertex();
        lllllllllllllllllllIIlIlIllIlllI.draw();
    }

    public static void drawPlane(double lllllllllllllllllllIIllIIlllllIl, double lllllllllllllllllllIIllIIlllllII, double lllllllllllllllllllIIllIIlllIlIl, AxisAlignedBB lllllllllllllllllllIIllIIllllIlI, float lllllllllllllllllllIIllIIlllIIll, int lllllllllllllllllllIIllIIlllIIlI) {
        GL11.glPushMatrix();
        GL11.glTranslated((double)lllllllllllllllllllIIllIIlllllIl, (double)lllllllllllllllllllIIllIIlllllII, (double)lllllllllllllllllllIIllIIlllIlIl);
        RenderUtil.drawPlane(lllllllllllllllllllIIllIIllllIlI, lllllllllllllllllllIIllIIlllIIll, lllllllllllllllllllIIllIIlllIIlI);
        GL11.glPopMatrix();
    }

    public static void drawLine3D(float lllllllllllllllllllIIllIllIIllII, float lllllllllllllllllllIIllIllIIlIll, float lllllllllllllllllllIIllIlIllllII, float lllllllllllllllllllIIllIlIlllIll, float lllllllllllllllllllIIllIlIlllIlI, float lllllllllllllllllllIIllIllIIIlll, float lllllllllllllllllllIIllIllIIIllI, int lllllllllllllllllllIIllIllIIIlIl) {
        float lllllllllllllllllllIIllIllIIIlII = (float)(lllllllllllllllllllIIllIllIIIlIl >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIllIIIIll = (float)(lllllllllllllllllllIIllIllIIIlIl >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIllIIIIlI = (float)(lllllllllllllllllllIIllIllIIIlIl & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIllIIIIIl = (float)(lllllllllllllllllllIIllIllIIIlIl >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)lllllllllllllllllllIIllIllIIIllI);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.disableDepth();
        GL11.glEnable((int)34383);
        Tessellator lllllllllllllllllllIIllIllIIIIII = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIllIlIllllll = lllllllllllllllllllIIllIllIIIIII.getWorldRenderer();
        lllllllllllllllllllIIllIlIllllll.begin(1, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIllIlIllllll.pos((double)lllllllllllllllllllIIllIllIIllII, (double)lllllllllllllllllllIIllIllIIlIll, (double)lllllllllllllllllllIIllIlIllllII).color(lllllllllllllllllllIIllIllIIIlII, lllllllllllllllllllIIllIllIIIIll, lllllllllllllllllllIIllIllIIIIlI, lllllllllllllllllllIIllIllIIIIIl).endVertex();
        lllllllllllllllllllIIllIlIllllll.pos((double)lllllllllllllllllllIIllIlIlllIll, (double)lllllllllllllllllllIIllIlIlllIlI, (double)lllllllllllllllllllIIllIllIIIlll).color(lllllllllllllllllllIIllIllIIIlII, lllllllllllllllllllIIllIllIIIIll, lllllllllllllllllllIIllIllIIIIlI, lllllllllllllllllllIIllIllIIIIIl).endVertex();
        lllllllllllllllllllIIllIllIIIIII.draw();
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.enableDepth();
        GL11.glDisable((int)34383);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public static void drawFilledBox(AxisAlignedBB lllllllllllllllllllIIlIlllIlIlIl, int lllllllllllllllllllIIlIlllIIllII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        float lllllllllllllllllllIIlIlllIlIIll = (float)(lllllllllllllllllllIIlIlllIIllII >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlIlllIlIIlI = (float)(lllllllllllllllllllIIlIlllIIllII >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlIlllIlIIIl = (float)(lllllllllllllllllllIIlIlllIIllII >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlIlllIlIIII = (float)(lllllllllllllllllllIIlIlllIIllII & 0xFF) / 255.0f;
        Tessellator lllllllllllllllllllIIlIlllIIllll = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIlIlllIIlllI = lllllllllllllllllllIIlIlllIIllll.getWorldRenderer();
        lllllllllllllllllllIIlIlllIIlllI.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.maxX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.minY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.maxZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIlllI.pos(lllllllllllllllllllIIlIlllIlIlIl.minX, lllllllllllllllllllIIlIlllIlIlIl.maxY, lllllllllllllllllllIIlIlllIlIlIl.minZ).color(lllllllllllllllllllIIlIlllIlIIlI, lllllllllllllllllllIIlIlllIlIIIl, lllllllllllllllllllIIlIlllIlIIII, lllllllllllllllllllIIlIlllIlIIll).endVertex();
        lllllllllllllllllllIIlIlllIIllll.draw();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void drawTriangle(float lllllllllllllllllllIIlllIlIllIII, float lllllllllllllllllllIIlllIlIlIlll, float lllllllllllllllllllIIlllIlIIllIl, float lllllllllllllllllllIIlllIlIlIlIl, int lllllllllllllllllllIIlllIlIIlIll) {
        GL11.glTranslated((double)lllllllllllllllllllIIlllIlIllIII, (double)lllllllllllllllllllIIlllIlIlIlll, (double)0.0);
        GL11.glRotatef((float)(180.0f + lllllllllllllllllllIIlllIlIlIlIl), (float)0.0f, (float)0.0f, (float)1.0f);
        float lllllllllllllllllllIIlllIlIlIIll = (float)(lllllllllllllllllllIIlllIlIIlIll >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlllIlIlIIlI = (float)(lllllllllllllllllllIIlllIlIIlIll >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlllIlIlIIIl = (float)(lllllllllllllllllllIIlllIlIIlIll >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlllIlIlIIII = (float)(lllllllllllllllllllIIlllIlIIlIll & 0xFF) / 255.0f;
        GL11.glColor4f((float)lllllllllllllllllllIIlllIlIlIIlI, (float)lllllllllllllllllllIIlllIlIlIIIl, (float)lllllllllllllllllllIIlllIlIlIIII, (float)lllllllllllllllllllIIlllIlIlIIll);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glLineWidth((float)1.0f);
        GL11.glBegin((int)6);
        GL11.glVertex2d((double)0.0, (double)(1.0f * lllllllllllllllllllIIlllIlIIllIl));
        GL11.glVertex2d((double)(1.0f * lllllllllllllllllllIIlllIlIIllIl), (double)(-(1.0f * lllllllllllllllllllIIlllIlIIllIl)));
        GL11.glVertex2d((double)(-(1.0f * lllllllllllllllllllIIlllIlIIllIl)), (double)(-(1.0f * lllllllllllllllllllIIlllIlIIllIl)));
        GL11.glEnd();
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glRotatef((float)(-180.0f - lllllllllllllllllllIIlllIlIlIlIl), (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslated((double)(-lllllllllllllllllllIIlllIlIllIII), (double)(-lllllllllllllllllllIIlllIlIlIlll), (double)0.0);
    }

    static {
        VIEWPORT = GLAllocation.createDirectIntBuffer((int)16);
        MODELVIEW = GLAllocation.createDirectFloatBuffer((int)16);
        PROJECTION = GLAllocation.createDirectFloatBuffer((int)16);
    }

    public static void drawBoundingBox(AxisAlignedBB lllllllllllllllllllIIllIlIlIIIII, float lllllllllllllllllllIIllIlIlIIlll, float lllllllllllllllllllIIllIlIlIIllI, float lllllllllllllllllllIIllIlIlIIlIl, float lllllllllllllllllllIIllIlIlIIlII, float lllllllllllllllllllIIllIlIIllIll) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)lllllllllllllllllllIIllIlIlIIlll);
        Tessellator lllllllllllllllllllIIllIlIlIIIlI = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIllIlIlIIIIl = lllllllllllllllllllIIllIlIlIIIlI.getWorldRenderer();
        lllllllllllllllllllIIllIlIlIIIIl.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, 0.0f).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, 0.0f).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.minX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, 0.0f).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.maxZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.maxY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, 0.0f).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, lllllllllllllllllllIIllIlIIllIll).endVertex();
        lllllllllllllllllllIIllIlIlIIIIl.pos(lllllllllllllllllllIIllIlIlIIIII.maxX, lllllllllllllllllllIIllIlIlIIIII.minY, lllllllllllllllllllIIllIlIlIIIII.minZ).color(lllllllllllllllllllIIllIlIlIIllI, lllllllllllllllllllIIllIlIlIIlIl, lllllllllllllllllllIIllIlIlIIlII, 0.0f).endVertex();
        lllllllllllllllllllIIllIlIlIIIlI.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public RenderUtil() {
        RenderUtil lllllllllllllllllllIIllllllIIlII;
    }

    public static void drawGradientRect(int lllllllllllllllllllIIllllIlIlIIl, int lllllllllllllllllllIIllllIIIlIll, int lllllllllllllllllllIIllllIIIlIII, int lllllllllllllllllllIIllllIIIIllI, int lllllllllllllllllllIIllllIIIIlII, int lllllllllllllllllllIIllllIlIIIIl) {
        float lllllllllllllllllllIIllllIIlllll = (float)(lllllllllllllllllllIIllllIIIIlII >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIllllI = (float)(lllllllllllllllllllIIllllIIIIlII >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIlllII = (float)(lllllllllllllllllllIIllllIIIIlII >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIllIlI = (float)(lllllllllllllllllllIIllllIIIIlII & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIllIII = (float)(lllllllllllllllllllIIllllIlIIIIl >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIlIllI = (float)(lllllllllllllllllllIIllllIlIIIIl >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIlIlII = (float)(lllllllllllllllllllIIllllIlIIIIl >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllllIIlIIlI = (float)(lllllllllllllllllllIIllllIlIIIIl & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator lllllllllllllllllllIIllllIIlIIII = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIllllIIIllll = lllllllllllllllllllIIllllIIlIIII.getWorldRenderer();
        lllllllllllllllllllIIllllIIIllll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIllllIIIllll.pos((double)lllllllllllllllllllIIllllIIIlIII, (double)lllllllllllllllllllIIllllIIIlIll, 300.0).color(lllllllllllllllllllIIllllIIllllI, lllllllllllllllllllIIllllIIlllII, lllllllllllllllllllIIllllIIllIlI, lllllllllllllllllllIIllllIIlllll).endVertex();
        lllllllllllllllllllIIllllIIIllll.pos((double)lllllllllllllllllllIIllllIlIlIIl, (double)lllllllllllllllllllIIllllIIIlIll, 300.0).color(lllllllllllllllllllIIllllIIllllI, lllllllllllllllllllIIllllIIlllII, lllllllllllllllllllIIllllIIllIlI, lllllllllllllllllllIIllllIIlllll).endVertex();
        lllllllllllllllllllIIllllIIIllll.pos((double)lllllllllllllllllllIIllllIlIlIIl, (double)lllllllllllllllllllIIllllIIIIllI, 300.0).color(lllllllllllllllllllIIllllIIlIllI, lllllllllllllllllllIIllllIIlIlII, lllllllllllllllllllIIllllIIlIIlI, lllllllllllllllllllIIllllIIllIII).endVertex();
        lllllllllllllllllllIIllllIIIllll.pos((double)lllllllllllllllllllIIllllIIIlIII, (double)lllllllllllllllllllIIllllIIIIllI, 300.0).color(lllllllllllllllllllIIllllIIlIllI, lllllllllllllllllllIIllllIIlIlII, lllllllllllllllllllIIllllIIlIIlI, lllllllllllllllllllIIllllIIllIII).endVertex();
        lllllllllllllllllllIIllllIIlIIII.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static void drawPlane(AxisAlignedBB lllllllllllllllllllIIllIIIIIllIl, float lllllllllllllllllllIIllIIIIIlIIl, int lllllllllllllllllllIIllIIIIIlIII) {
        GlStateManager.pushMatrix();
        GlStateManager.func_187441_d((float)lllllllllllllllllllIIllIIIIIlIIl);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        RenderUtil.drawPlane(lllllllllllllllllllIIllIIIIIllIl, lllllllllllllllllllIIllIIIIIlIII);
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void glScissor(float lllllllllllllllllllIIlIllIlllIIl, float lllllllllllllllllllIIlIllIllllll, float lllllllllllllllllllIIlIllIllIllI, float lllllllllllllllllllIIlIllIllllII, ScaledResolution lllllllllllllllllllIIlIllIlllIlI) {
        GL11.glScissor((int)((int)(lllllllllllllllllllIIlIllIlllIIl * (float)lllllllllllllllllllIIlIllIlllIlI.getScaleFactor())), (int)((int)((float)Minecraft.getMinecraft().displayHeight - lllllllllllllllllllIIlIllIllllII * (float)lllllllllllllllllllIIlIllIlllIlI.getScaleFactor())), (int)((int)((lllllllllllllllllllIIlIllIllIllI - lllllllllllllllllllIIlIllIlllIIl) * (float)lllllllllllllllllllIIlIllIlllIlI.getScaleFactor())), (int)((int)((lllllllllllllllllllIIlIllIllllII - lllllllllllllllllllIIlIllIllllll) * (float)lllllllllllllllllllIIlIllIlllIlI.getScaleFactor())));
    }

    public static void drawTexture(float lllllllllllllllllllIIlIlIlIIlIIl, float lllllllllllllllllllIIlIlIlIIlIII, float lllllllllllllllllllIIlIlIlIIIllI, float lllllllllllllllllllIIlIlIIlllIII, float lllllllllllllllllllIIlIlIlIIIIll, float lllllllllllllllllllIIlIlIIllIlII, float lllllllllllllllllllIIlIlIlIIIIII, float lllllllllllllllllllIIlIlIIllllll) {
        Tessellator lllllllllllllllllllIIlIlIIlllllI = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIlIlIIllllIl = lllllllllllllllllllIIlIlIIlllllI.getWorldRenderer();
        lllllllllllllllllllIIlIlIIllllIl.begin(4, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllllllllIIlIlIIllllIl.pos((double)(lllllllllllllllllllIIlIlIlIIlIIl + lllllllllllllllllllIIlIlIlIIIllI), (double)lllllllllllllllllllIIlIlIlIIlIII, 0.0).func_187315_a((double)lllllllllllllllllllIIlIlIlIIIIII, (double)lllllllllllllllllllIIlIlIIllIlII).endVertex();
        lllllllllllllllllllIIlIlIIllllIl.pos((double)lllllllllllllllllllIIlIlIlIIlIIl, (double)lllllllllllllllllllIIlIlIlIIlIII, 0.0).func_187315_a((double)lllllllllllllllllllIIlIlIlIIIIll, (double)lllllllllllllllllllIIlIlIIllIlII).endVertex();
        lllllllllllllllllllIIlIlIIllllIl.pos((double)lllllllllllllllllllIIlIlIlIIlIIl, (double)(lllllllllllllllllllIIlIlIlIIlIII + lllllllllllllllllllIIlIlIIlllIII), 0.0).func_187315_a((double)lllllllllllllllllllIIlIlIlIIIIll, (double)lllllllllllllllllllIIlIlIIllllll).endVertex();
        lllllllllllllllllllIIlIlIIllllIl.pos((double)lllllllllllllllllllIIlIlIlIIlIIl, (double)(lllllllllllllllllllIIlIlIlIIlIII + lllllllllllllllllllIIlIlIIlllIII), 0.0).func_187315_a((double)lllllllllllllllllllIIlIlIlIIIIll, (double)lllllllllllllllllllIIlIlIIllllll).endVertex();
        lllllllllllllllllllIIlIlIIllllIl.pos((double)(lllllllllllllllllllIIlIlIlIIlIIl + lllllllllllllllllllIIlIlIlIIIllI), (double)(lllllllllllllllllllIIlIlIlIIlIII + lllllllllllllllllllIIlIlIIlllIII), 0.0).func_187315_a((double)lllllllllllllllllllIIlIlIlIIIIII, (double)lllllllllllllllllllIIlIlIIllllll).endVertex();
        lllllllllllllllllllIIlIlIIllllIl.pos((double)(lllllllllllllllllllIIlIlIlIIlIIl + lllllllllllllllllllIIlIlIlIIIllI), (double)lllllllllllllllllllIIlIlIlIIlIII, 0.0).func_187315_a((double)lllllllllllllllllllIIlIlIlIIIIII, (double)lllllllllllllllllllIIlIlIIllIlII).endVertex();
        lllllllllllllllllllIIlIlIIlllllI.draw();
    }

    public static void drawLine(float lllllllllllllllllllIIllIlllIIllI, float lllllllllllllllllllIIllIllllIIIl, float lllllllllllllllllllIIllIllllIIII, float lllllllllllllllllllIIllIlllIllll, float lllllllllllllllllllIIllIlllIIIlI, int lllllllllllllllllllIIllIlllIIIIl) {
        float lllllllllllllllllllIIllIlllIllII = (float)(lllllllllllllllllllIIllIlllIIIIl >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIlllIlIll = (float)(lllllllllllllllllllIIllIlllIIIIl >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIlllIlIlI = (float)(lllllllllllllllllllIIllIlllIIIIl & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIlllIlIIl = (float)(lllllllllllllllllllIIllIlllIIIIl >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)lllllllllllllllllllIIllIlllIIIlI);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        Tessellator lllllllllllllllllllIIllIlllIlIII = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIllIlllIIlll = lllllllllllllllllllIIllIlllIlIII.getWorldRenderer();
        lllllllllllllllllllIIllIlllIIlll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIllIlllIIlll.pos((double)lllllllllllllllllllIIllIlllIIllI, (double)lllllllllllllllllllIIllIllllIIIl, 0.0).color(lllllllllllllllllllIIllIlllIllII, lllllllllllllllllllIIllIlllIlIll, lllllllllllllllllllIIllIlllIlIlI, lllllllllllllllllllIIllIlllIlIIl).endVertex();
        lllllllllllllllllllIIllIlllIIlll.pos((double)lllllllllllllllllllIIllIllllIIII, (double)lllllllllllllllllllIIllIlllIllll, 0.0).color(lllllllllllllllllllIIllIlllIllII, lllllllllllllllllllIIllIlllIlIll, lllllllllllllllllllIIllIlllIlIlI, lllllllllllllllllllIIllIlllIlIIl).endVertex();
        lllllllllllllllllllIIllIlllIlIII.draw();
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public static void drawBoundingBox(AxisAlignedBB lllllllllllllllllllIIllIlIIlIIIl, float lllllllllllllllllllIIllIlIIIlIIl, int lllllllllllllllllllIIllIlIIIllll) {
        float lllllllllllllllllllIIllIlIIIlllI = (float)(lllllllllllllllllllIIllIlIIIllll >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIlIIIllIl = (float)(lllllllllllllllllllIIllIlIIIllll >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIlIIIllII = (float)(lllllllllllllllllllIIllIlIIIllll >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIllIlIIIlIll = (float)(lllllllllllllllllllIIllIlIIIllll & 0xFF) / 255.0f;
        RenderUtil.drawBoundingBox(lllllllllllllllllllIIllIlIIlIIIl, lllllllllllllllllllIIllIlIIIlIIl, lllllllllllllllllllIIllIlIIIllIl, lllllllllllllllllllIIllIlIIIllII, lllllllllllllllllllIIllIlIIIlIll, lllllllllllllllllllIIllIlIIIlllI);
    }

    public static void glBillboardDistanceScaled(float lllllllllllllllllllIIlIllIIIlllI, float lllllllllllllllllllIIlIllIIIIllI, float lllllllllllllllllllIIlIllIIIIlIl, EntityPlayer lllllllllllllllllllIIlIllIIIIlII, float lllllllllllllllllllIIlIllIIIlIlI) {
        RenderUtil.glBillboard(lllllllllllllllllllIIlIllIIIlllI, lllllllllllllllllllIIlIllIIIIllI, lllllllllllllllllllIIlIllIIIIlIl);
        int lllllllllllllllllllIIlIllIIIlIIl = (int)lllllllllllllllllllIIlIllIIIIlII.getDistance((double)lllllllllllllllllllIIlIllIIIlllI, (double)lllllllllllllllllllIIlIllIIIIllI, (double)lllllllllllllllllllIIlIllIIIIlIl);
        float lllllllllllllllllllIIlIllIIIlIII = (float)lllllllllllllllllllIIlIllIIIlIIl / 2.0f / (2.0f + (2.0f - lllllllllllllllllllIIlIllIIIlIlI));
        if (lllllllllllllllllllIIlIllIIIlIII < 1.0f) {
            lllllllllllllllllllIIlIllIIIlIII = 1.0f;
        }
        GlStateManager.scale((float)lllllllllllllllllllIIlIllIIIlIII, (float)lllllllllllllllllllIIlIllIIIlIII, (float)lllllllllllllllllllIIlIllIIIlIII);
    }

    public static void drawRect(float lllllllllllllllllllIIlllllIlIlIl, float lllllllllllllllllllIIlllllIIlIIl, float lllllllllllllllllllIIlllllIlIIll, float lllllllllllllllllllIIlllllIlIIlI, int lllllllllllllllllllIIlllllIlIIIl) {
        float lllllllllllllllllllIIlllllIlIIII = (float)(lllllllllllllllllllIIlllllIlIIIl >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlllllIIllll = (float)(lllllllllllllllllllIIlllllIlIIIl >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlllllIIlllI = (float)(lllllllllllllllllllIIlllllIlIIIl >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllllIIlllllIIllIl = (float)(lllllllllllllllllllIIlllllIlIIIl & 0xFF) / 255.0f;
        Tessellator lllllllllllllllllllIIlllllIIllII = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllllIIlllllIIlIll = lllllllllllllllllllIIlllllIIllII.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        lllllllllllllllllllIIlllllIIlIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllllllIIlllllIIlIll.pos((double)lllllllllllllllllllIIlllllIlIlIl, (double)lllllllllllllllllllIIlllllIlIIlI, 0.0).color(lllllllllllllllllllIIlllllIIllll, lllllllllllllllllllIIlllllIIlllI, lllllllllllllllllllIIlllllIIllIl, lllllllllllllllllllIIlllllIlIIII).endVertex();
        lllllllllllllllllllIIlllllIIlIll.pos((double)lllllllllllllllllllIIlllllIlIIll, (double)lllllllllllllllllllIIlllllIlIIlI, 0.0).color(lllllllllllllllllllIIlllllIIllll, lllllllllllllllllllIIlllllIIlllI, lllllllllllllllllllIIlllllIIllIl, lllllllllllllllllllIIlllllIlIIII).endVertex();
        lllllllllllllllllllIIlllllIIlIll.pos((double)lllllllllllllllllllIIlllllIlIIll, (double)lllllllllllllllllllIIlllllIIlIIl, 0.0).color(lllllllllllllllllllIIlllllIIllll, lllllllllllllllllllIIlllllIIlllI, lllllllllllllllllllIIlllllIIllIl, lllllllllllllllllllIIlllllIlIIII).endVertex();
        lllllllllllllllllllIIlllllIIlIll.pos((double)lllllllllllllllllllIIlllllIlIlIl, (double)lllllllllllllllllllIIlllllIIlIIl, 0.0).color(lllllllllllllllllllIIlllllIIllll, lllllllllllllllllllIIlllllIIlllI, lllllllllllllllllllIIlllllIIllIl, lllllllllllllllllllIIlllllIlIIII).endVertex();
        lllllllllllllllllllIIlllllIIllII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}

