/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class BoxRender {
    private static /* synthetic */ Minecraft mc;

    public static void glCleanup() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void glSetup() {
        GL11.glPushMatrix();
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glLineWidth((float)2.0f);
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public static void drawFilledBlockBox(AxisAlignedBB lllllllllllllllllllIIIIIllIIllll, float lllllllllllllllllllIIIIIllIIlllI, float lllllllllllllllllllIIIIIllIIllIl, float lllllllllllllllllllIIIIIllIIllII, float lllllllllllllllllllIIIIIllIIlIll) {
        try {
            double lllllllllllllllllllIIIIIllIlIIlI = BoxRender.mc.getRenderManager().viewerPosX;
            double lllllllllllllllllllIIIIIllIlIIIl = BoxRender.mc.getRenderManager().viewerPosY;
            double lllllllllllllllllllIIIIIllIlIIII = BoxRender.mc.getRenderManager().viewerPosZ;
            BoxRender.glSetup();
            lllllllllllllllllllIIIIIllIIllll = new AxisAlignedBB(lllllllllllllllllllIIIIIllIIllll.minX - lllllllllllllllllllIIIIIllIlIIlI, lllllllllllllllllllIIIIIllIIllll.minY - lllllllllllllllllllIIIIIllIlIIIl, lllllllllllllllllllIIIIIllIIllll.minZ - lllllllllllllllllllIIIIIllIlIIII, lllllllllllllllllllIIIIIllIIllll.maxX - lllllllllllllllllllIIIIIllIlIIlI, lllllllllllllllllllIIIIIllIIllll.maxY - lllllllllllllllllllIIIIIllIlIIIl, lllllllllllllllllllIIIIIllIIllll.maxZ - lllllllllllllllllllIIIIIllIlIIII);
            RenderGlobal.func_189696_b((AxisAlignedBB)lllllllllllllllllllIIIIIllIIllll, (float)lllllllllllllllllllIIIIIllIIlllI, (float)lllllllllllllllllllIIIIIllIIllIl, (float)lllllllllllllllllllIIIIIllIIllII, (float)lllllllllllllllllllIIIIIllIIlIll);
            RenderGlobal.func_189697_a((AxisAlignedBB)lllllllllllllllllllIIIIIllIIllll, (float)lllllllllllllllllllIIIIIllIIlllI, (float)lllllllllllllllllllIIIIIllIIllIl, (float)lllllllllllllllllllIIIIIllIIllII, (float)(lllllllllllllllllllIIIIIllIIlIll * 1.5f));
            BoxRender.glCleanup();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public BoxRender() {
        BoxRender lllllllllllllllllllIIIIIllIlllII;
    }
}

