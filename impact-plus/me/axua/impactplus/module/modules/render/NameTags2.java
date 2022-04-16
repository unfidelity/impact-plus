/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.module.modules.render;

import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.MathUtil;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;

public class NameTags2
extends Module {
    public /* synthetic */ Setting.b CustomFont;
    public /* synthetic */ Setting.d scaling;

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIIIIlIIllllIIIII) {
        for (Object llllllllllllllllIIIIlIIllllIIlII : NameTags2.mc.theWorld.playerEntities) {
            NameTags2 llllllllllllllllIIIIlIIllllIIIIl;
            Entity llllllllllllllllIIIIlIIllllIIlIl = (Entity)llllllllllllllllIIIIlIIllllIIlII;
            if (!(llllllllllllllllIIIIlIIllllIIlIl instanceof EntityPlayer) || !llllllllllllllllIIIIlIIllllIIlIl.isEntityAlive()) continue;
            double llllllllllllllllIIIIlIIllllIlIII = llllllllllllllllIIIIlIIllllIIIIl.interpolate(llllllllllllllllIIIIlIIllllIIlIl.lastTickPosX, llllllllllllllllIIIIlIIllllIIlIl.posX, llllllllllllllllIIIIlIIllllIIIII.getPartialTicks()) - NameTags2.mc.getRenderManager().renderPosX;
            double llllllllllllllllIIIIlIIllllIIlll = llllllllllllllllIIIIlIIllllIIIIl.interpolate(llllllllllllllllIIIIlIIllllIIlIl.lastTickPosY, llllllllllllllllIIIIlIIllllIIlIl.posY, llllllllllllllllIIIIlIIllllIIIII.getPartialTicks()) - NameTags2.mc.getRenderManager().renderPosY;
            double llllllllllllllllIIIIlIIllllIIllI = llllllllllllllllIIIIlIIllllIIIIl.interpolate(llllllllllllllllIIIIlIIllllIIlIl.lastTickPosZ, llllllllllllllllIIIIlIIllllIIlIl.posZ, llllllllllllllllIIIIlIIllllIIIII.getPartialTicks()) - NameTags2.mc.getRenderManager().renderPosZ;
            llllllllllllllllIIIIlIIllllIIIIl.renderNameTag((EntityPlayer)llllllllllllllllIIIIlIIllllIIlIl, llllllllllllllllIIIIlIIllllIlIII, llllllllllllllllIIIIlIIllllIIlll, llllllllllllllllIIIIlIIllllIIllI, llllllllllllllllIIIIlIIllllIIIII.getPartialTicks());
        }
    }

    public static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public int getPing(EntityPlayer llllllllllllllllIIIIlIIlIlIlIlII) {
        int llllllllllllllllIIIIlIIlIlIlIlIl = 0;
        try {
            llllllllllllllllIIIIlIIlIlIlIlIl = (int)MathUtil.clamp(mc.getNetHandler().getPlayerInfo(llllllllllllllllIIIIlIIlIlIlIlII.getUniqueID()).getResponseTime(), 0.0f, 300.0f);
        }
        catch (NullPointerException llllllllllllllllIIIIlIIlIlIlIIlI) {
            // empty catch block
        }
        return llllllllllllllllIIIIlIIlIlIlIlIl;
    }

    private double interpolate(double llllllllllllllllIIIIlIIlIlIIIIIl, double llllllllllllllllIIIIlIIlIlIIIIII, float llllllllllllllllIIIIlIIlIIllllll) {
        return llllllllllllllllIIIIlIIlIlIIIIIl + (llllllllllllllllIIIIlIIlIlIIIIII - llllllllllllllllIIIIlIIlIlIIIIIl) * (double)llllllllllllllllIIIIlIIlIIllllll;
    }

    public static void drawBorderedRect(double llllllllllllllllIIIIlIIIlIllIIII, double llllllllllllllllIIIIlIIIlIlllIlI, double llllllllllllllllIIIIlIIIlIlllIII, double llllllllllllllllIIIIlIIIlIllIllI, double llllllllllllllllIIIIlIIIlIllIlII, int llllllllllllllllIIIIlIIIlIllIIlI, int llllllllllllllllIIIIlIIIlIllIIIl) {
        NameTags2.enableGL2D();
        NameTags2.fakeGuiRect(llllllllllllllllIIIIlIIIlIllIIII + llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIlllIlI + llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIlllIII - llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIllIllI - llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIllIIlI);
        NameTags2.fakeGuiRect(llllllllllllllllIIIIlIIIlIllIIII + llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIlllIlI, llllllllllllllllIIIIlIIIlIlllIII - llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIlllIlI + llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIllIIIl);
        NameTags2.fakeGuiRect(llllllllllllllllIIIIlIIIlIllIIII, llllllllllllllllIIIIlIIIlIlllIlI, llllllllllllllllIIIIlIIIlIllIIII + llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIllIllI, llllllllllllllllIIIIlIIIlIllIIIl);
        NameTags2.fakeGuiRect(llllllllllllllllIIIIlIIIlIlllIII - llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIlllIlI, llllllllllllllllIIIIlIIIlIlllIII, llllllllllllllllIIIIlIIIlIllIllI, llllllllllllllllIIIIlIIIlIllIIIl);
        NameTags2.fakeGuiRect(llllllllllllllllIIIIlIIIlIllIIII + llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIllIllI - llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIlllIII - llllllllllllllllIIIIlIIIlIllIlII, llllllllllllllllIIIIlIIIlIllIllI, llllllllllllllllIIIIlIIIlIllIIIl);
        NameTags2.disableGL2D();
    }

    public String getGMText(EntityPlayer llllllllllllllllIIIIlIIlIllIIIll) {
        if (llllllllllllllllIIIIlIIlIllIIIll.func_184812_l_()) {
            return "C";
        }
        if (llllllllllllllllIIIIlIIlIllIIIll.isSpectator()) {
            return "I";
        }
        if (!llllllllllllllllIIIIlIIlIllIIIll.isAllowEdit() && !llllllllllllllllIIIIlIIlIllIIIll.isSpectator()) {
            return "A";
        }
        if (!llllllllllllllllIIIIlIIlIllIIIll.func_184812_l_() && !llllllllllllllllIIIIlIIlIllIIIll.isSpectator() && llllllllllllllllIIIIlIIlIllIIIll.isAllowEdit()) {
            return "S";
        }
        return "";
    }

    public static void fakeGuiRect(double llllllllllllllllIIIIlIIIlllIIlll, double llllllllllllllllIIIIlIIIlllllllI, double llllllllllllllllIIIIlIIIlllIIlII, double llllllllllllllllIIIIlIIIlllIIIlI, int llllllllllllllllIIIIlIIIllllIIll) {
        if (llllllllllllllllIIIIlIIIlllIIlll < llllllllllllllllIIIIlIIIlllIIlII) {
            double llllllllllllllllIIIIlIIlIIIIIlll = llllllllllllllllIIIIlIIIlllIIlll;
            llllllllllllllllIIIIlIIIlllIIlll = llllllllllllllllIIIIlIIIlllIIlII;
            llllllllllllllllIIIIlIIIlllIIlII = llllllllllllllllIIIIlIIlIIIIIlll;
        }
        if (llllllllllllllllIIIIlIIIlllllllI < llllllllllllllllIIIIlIIIlllIIIlI) {
            double llllllllllllllllIIIIlIIlIIIIIlII = llllllllllllllllIIIIlIIIlllllllI;
            llllllllllllllllIIIIlIIIlllllllI = llllllllllllllllIIIIlIIIlllIIIlI;
            llllllllllllllllIIIIlIIIlllIIIlI = llllllllllllllllIIIIlIIlIIIIIlII;
        }
        float llllllllllllllllIIIIlIIIllllIIlI = (float)(llllllllllllllllIIIIlIIIllllIIll >> 24 & 0xFF) / 255.0f;
        float llllllllllllllllIIIIlIIIllllIIIl = (float)(llllllllllllllllIIIIlIIIllllIIll >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIIIlIIIllllIIII = (float)(llllllllllllllllIIIIlIIIllllIIll >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIIIlIIIlllIlllI = (float)(llllllllllllllllIIIIlIIIllllIIll & 0xFF) / 255.0f;
        Tessellator llllllllllllllllIIIIlIIIlllIllII = Tessellator.getInstance();
        BufferBuilder llllllllllllllllIIIIlIIIlllIlIlI = llllllllllllllllIIIIlIIIlllIllII.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)llllllllllllllllIIIIlIIIllllIIIl, (float)llllllllllllllllIIIIlIIIllllIIII, (float)llllllllllllllllIIIIlIIIlllIlllI, (float)llllllllllllllllIIIIlIIIllllIIlI);
        llllllllllllllllIIIIlIIIlllIlIlI.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllllllIIIIlIIIlllIlIlI.pos(llllllllllllllllIIIIlIIIlllIIlll, llllllllllllllllIIIIlIIIlllIIIlI, 0.0).endVertex();
        llllllllllllllllIIIIlIIIlllIlIlI.pos(llllllllllllllllIIIIlIIIlllIIlII, llllllllllllllllIIIIlIIIlllIIIlI, 0.0).endVertex();
        llllllllllllllllIIIIlIIIlllIlIlI.pos(llllllllllllllllIIIIlIIIlllIIlII, llllllllllllllllIIIIlIIIlllllllI, 0.0).endVertex();
        llllllllllllllllIIIIlIIIlllIlIlI.pos(llllllllllllllllIIIIlIIIlllIIlll, llllllllllllllllIIIIlIIIlllllllI, 0.0).endVertex();
        llllllllllllllllIIIIlIIIlllIllII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    private String getname(EntityPlayer llllllllllllllllIIIIlIIllIIIIIlI) {
        NameTags2 llllllllllllllllIIIIlIIllIIIIlII;
        TextFormatting llllllllllllllllIIIIlIIllIIIIIIl;
        String llllllllllllllllIIIIlIIllIIIIIII = llllllllllllllllIIIIlIIllIIIIIlI.getDisplayName().getFormattedText();
        float llllllllllllllllIIIIlIIlIlllllll = llllllllllllllllIIIIlIIllIIIIIlI.getHealth() + llllllllllllllllIIIIlIIllIIIIIlI.getAbsorptionAmount();
        if (llllllllllllllllIIIIlIIlIlllllll <= 0.0f) {
            llllllllllllllllIIIIlIIlIlllllll = 1.0f;
        }
        if (llllllllllllllllIIIIlIIlIlllllll > 18.0f) {
            TextFormatting llllllllllllllllIIIIlIIllIIIlIll = TextFormatting.GREEN;
        } else if (llllllllllllllllIIIIlIIlIlllllll > 16.0f) {
            TextFormatting llllllllllllllllIIIIlIIllIIIlIlI = TextFormatting.DARK_GREEN;
        } else if (llllllllllllllllIIIIlIIlIlllllll > 12.0f) {
            TextFormatting llllllllllllllllIIIIlIIllIIIlIII = TextFormatting.YELLOW;
        } else if (llllllllllllllllIIIIlIIlIlllllll > 8.0f) {
            TextFormatting llllllllllllllllIIIIlIIllIIIIlll = TextFormatting.GOLD;
        } else if (llllllllllllllllIIIIlIIlIlllllll > 5.0f) {
            TextFormatting llllllllllllllllIIIIlIIllIIIIlIl = TextFormatting.RED;
        } else {
            llllllllllllllllIIIIlIIllIIIIIIl = TextFormatting.DARK_RED;
        }
        String llllllllllllllllIIIIlIIlIllllllI = "";
        String llllllllllllllllIIIIlIIlIlllllIl = "";
        llllllllllllllllIIIIlIIlIllllllI = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIlIIlIllllllI).append(" [").append(llllllllllllllllIIIIlIIllIIIIlII.getGMText(llllllllllllllllIIIIlIIllIIIIIlI)).append("]"));
        llllllllllllllllIIIIlIIlIlllllIl = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIlIIlIlllllIl).append(" ").append(llllllllllllllllIIIIlIIllIIIIlII.getPing(llllllllllllllllIIIIlIIllIIIIIlI)).append("ms"));
        float llllllllllllllllIIIIlIIlIlllllII = llllllllllllllllIIIIlIIllIIIIIlI.getHealth() + llllllllllllllllIIIIlIIllIIIIIlI.getAbsorptionAmount();
        int llllllllllllllllIIIIlIIlIllllIll = (int)Math.ceil(llllllllllllllllIIIIlIIlIlllllII);
        if (llllllllllllllllIIIIlIIlIllllIll <= 0) {
            llllllllllllllllIIIIlIIlIllllIll = 1;
        }
        llllllllllllllllIIIIlIIllIIIIIII = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIlIIllIIIIIII).append(llllllllllllllllIIIIlIIlIllllllI).append(llllllllllllllllIIIIlIIlIlllllIl).append(llllllllllllllllIIIIlIIllIIIIIIl).append(" ").append(String.valueOf(llllllllllllllllIIIIlIIlIllllIll)));
        return llllllllllllllllIIIIlIIllIIIIIII;
    }

    public NameTags2() {
        super("NameTags2", Module.Category.RENDER);
        NameTags2 llllllllllllllllIIIIlIIlllllIlIl;
    }

    private void renderNameTag(EntityPlayer llllllllllllllllIIIIlIIlllIIIIII, double llllllllllllllllIIIIlIIllIlIllII, double llllllllllllllllIIIIlIIllIlllllI, double llllllllllllllllIIIIlIIllIlIlIlI, float llllllllllllllllIIIIlIIllIlIlIIl) {
        int llllllllllllllllIIIIlIIllIllIIII;
        NameTags2 llllllllllllllllIIIIlIIlllIIIIlI;
        double llllllllllllllllIIIIlIIllIlllIIl = llllllllllllllllIIIIlIIllIlllllI;
        llllllllllllllllIIIIlIIllIlllIIl += llllllllllllllllIIIIlIIlllIIIIII.isSneaking() ? 0.5 : 0.7;
        Entity llllllllllllllllIIIIlIIllIllIlll = mc.getRenderViewEntity();
        double llllllllllllllllIIIIlIIllIllIlIl = llllllllllllllllIIIIlIIllIllIlll.posX;
        double llllllllllllllllIIIIlIIllIllIIll = llllllllllllllllIIIIlIIllIllIlll.posY;
        double llllllllllllllllIIIIlIIllIllIIlI = llllllllllllllllIIIIlIIllIllIlll.posZ;
        llllllllllllllllIIIIlIIllIllIlll.posX = llllllllllllllllIIIIlIIlllIIIIlI.interpolate(llllllllllllllllIIIIlIIllIllIlll.prevPosX, llllllllllllllllIIIIlIIllIllIlll.posX, llllllllllllllllIIIIlIIllIlIlIIl);
        llllllllllllllllIIIIlIIllIllIlll.posY = llllllllllllllllIIIIlIIlllIIIIlI.interpolate(llllllllllllllllIIIIlIIllIllIlll.prevPosY, llllllllllllllllIIIIlIIllIllIlll.posY, llllllllllllllllIIIIlIIllIlIlIIl);
        llllllllllllllllIIIIlIIllIllIlll.posZ = llllllllllllllllIIIIlIIlllIIIIlI.interpolate(llllllllllllllllIIIIlIIllIllIlll.prevPosZ, llllllllllllllllIIIIlIIllIllIlll.posZ, llllllllllllllllIIIIlIIllIlIlIIl);
        double llllllllllllllllIIIIlIIllIllIIIl = llllllllllllllllIIIIlIIllIllIlll.getDistance(llllllllllllllllIIIIlIIllIlIllII + NameTags2.mc.getRenderManager().viewerPosX, llllllllllllllllIIIIlIIllIlllllI + NameTags2.mc.getRenderManager().viewerPosY, llllllllllllllllIIIIlIIllIlIlIlI + NameTags2.mc.getRenderManager().viewerPosZ);
        if (llllllllllllllllIIIIlIIlllIIIIlI.CustomFont.getValue()) {
            int llllllllllllllllIIIIlIIlllIIIlII = (int)(ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIIIIlIIlllIIIIlI.getname(llllllllllllllllIIIIlIIlllIIIIII)) / 2.0f);
        } else {
            llllllllllllllllIIIIlIIllIllIIII = NameTags2.mc.fontRendererObj.getStringWidth(llllllllllllllllIIIIlIIlllIIIIlI.getname(llllllllllllllllIIIIlIIlllIIIIII)) / 2;
        }
        double llllllllllllllllIIIIlIIllIlIllll = 0.0018 + llllllllllllllllIIIIlIIlllIIIIlI.scaling.getValue() * 0.001 * llllllllllllllllIIIIlIIllIllIIIl;
        if (llllllllllllllllIIIIlIIllIllIIIl <= 8.0) {
            llllllllllllllllIIIIlIIllIlIllll = 0.0245;
        }
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((float)((float)llllllllllllllllIIIIlIIllIlIllII), (float)((float)llllllllllllllllIIIIlIIllIlllIIl + 1.4f), (float)((float)llllllllllllllllIIIIlIIllIlIlIlI));
        GlStateManager.rotate((float)(-NameTags2.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)NameTags2.mc.getRenderManager().playerViewX, (float)(NameTags2.mc.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((double)(-llllllllllllllllIIIIlIIllIlIllll), (double)(-llllllllllllllllIIIIlIIllIlIllll), (double)llllllllllllllllIIIIlIIllIlIllll);
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
        GL11.glDisable((int)2929);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        if (llllllllllllllllIIIIlIIlllIIIIlI.CustomFont.getValue()) {
            NameTags2.drawBorderedRect(-llllllllllllllllIIIIlIIllIllIIII, -ImpactPlus.CustomFont.FONT_HEIGHT, llllllllllllllllIIIIlIIllIllIIII, 0.0, 0.1, new Color(0, 0, 0, 130).getRGB(), new Color(0, 0, 0, 220).getRGB());
        } else {
            NameTags2.drawBorderedRect(-llllllllllllllllIIIIlIIllIllIIII, -NameTags2.mc.fontRendererObj.FONT_HEIGHT, llllllllllllllllIIIIlIIllIllIIII, 0.0, 0.1, new Color(0, 0, 0, 130).getRGB(), new Color(0, 0, 0, 220).getRGB());
        }
        GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glColor4f((float)1.0f, (float)10.0f, (float)1.0f, (float)1.0f);
        if (llllllllllllllllIIIIlIIlllIIIIlI.CustomFont.getValue()) {
            ImpactPlus.CustomFont.drawString(llllllllllllllllIIIIlIIlllIIIIlI.getname(llllllllllllllllIIIIlIIlllIIIIII), -llllllllllllllllIIIIlIIllIllIIII, -ImpactPlus.CustomFont.FONT_HEIGHT - 2, -1);
        } else {
            NameTags2.mc.fontRendererObj.drawString(llllllllllllllllIIIIlIIlllIIIIlI.getname(llllllllllllllllIIIIlIIlllIIIIII), -llllllllllllllllIIIIlIIllIllIIII, -NameTags2.mc.fontRendererObj.FONT_HEIGHT, -1);
        }
        llllllllllllllllIIIIlIIllIllIlll.posX = llllllllllllllllIIIIlIIllIllIlIl;
        llllllllllllllllIIIIlIIllIllIlll.posY = llllllllllllllllIIIIlIIllIllIIll;
        llllllllllllllllIIIIlIIllIllIlll.posZ = llllllllllllllllIIIIlIIllIllIIlI;
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
        GlStateManager.popMatrix();
    }

    @Override
    public void setup() {
        NameTags2 llllllllllllllllIIIIlIIlllllIIIl;
        llllllllllllllllIIIIlIIlllllIIIl.scaling = llllllllllllllllIIIIlIIlllllIIIl.registerD("Scaling", 3.5, 1.0, 5.0);
        llllllllllllllllIIIIlIIlllllIIIl.CustomFont = llllllllllllllllIIIIlIIlllllIIIl.registerB("CustomFont", true);
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }
}

