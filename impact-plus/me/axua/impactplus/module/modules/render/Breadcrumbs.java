/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.module.modules.render;

import java.util.LinkedList;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Tessellator;
import org.lwjgl.opengl.GL11;

public class Breadcrumbs
extends Module {
    private final /* synthetic */ LinkedList<double[]> positions;
    public /* synthetic */ Setting.d g;
    public /* synthetic */ Setting.d b;
    public /* synthetic */ Setting.i thickness;
    public /* synthetic */ Setting.d r;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onDisable() {
        Breadcrumbs llllllllllllllllIlIllIIIlIllllll;
        LinkedList<double[]> llllllllllllllllIlIllIIIlIllllIl = llllllllllllllllIlIllIIIlIllllll.positions;
        synchronized (llllllllllllllllIlIllIIIlIllllIl) {
            llllllllllllllllIlIllIIIlIllllll.positions.clear();
        }
        super.onDisable();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onUpdate() {
        Breadcrumbs llllllllllllllllIlIllIIIllIIllIl;
        LinkedList<double[]> llllllllllllllllIlIllIIIllIIlIll = llllllllllllllllIlIllIIIllIIllIl.positions;
        synchronized (llllllllllllllllIlIllIIIllIIlIll) {
            llllllllllllllllIlIllIIIllIIllIl.positions.add(new double[]{Breadcrumbs.mc.thePlayer.posX, Breadcrumbs.mc.thePlayer.getEntityBoundingBox().minY, Breadcrumbs.mc.thePlayer.posZ});
        }
    }

    @Override
    public void setup() {
        Breadcrumbs llllllllllllllllIlIllIIIllIlIIlI;
        llllllllllllllllIlIllIIIllIlIIlI.thickness = llllllllllllllllIlIllIIIllIlIIlI.registerI("Thickness", 3, 1, 5);
        llllllllllllllllIlIllIIIllIlIIlI.r = llllllllllllllllIlIllIIIllIlIIlI.registerD("Red", 0.0, 0.0, 1.0);
        llllllllllllllllIlIllIIIllIlIIlI.g = llllllllllllllllIlIllIIIllIlIIlI.registerD("Green", 1.0, 0.0, 1.0);
        llllllllllllllllIlIllIIIllIlIIlI.b = llllllllllllllllIlIllIIIllIlIIlI.registerD("Blue", 1.0, 0.0, 1.0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIlIllIIIlIlIlllI) {
        Breadcrumbs llllllllllllllllIlIllIIIlIlIllll;
        GL11.glLineWidth((float)llllllllllllllllIlIllIIIlIlIllll.thickness.getValue());
        LinkedList<double[]> llllllllllllllllIlIllIIIlIlIllII = llllllllllllllllIlIllIIIlIlIllll.positions;
        synchronized (llllllllllllllllIlIllIIIlIlIllII) {
            GL11.glPushMatrix();
            GL11.glDisable((int)3553);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            GL11.glDisable((int)2929);
            Breadcrumbs.mc.entityRenderer.disableLightmap();
            GL11.glBegin((int)3);
            GL11.glColor3d((double)llllllllllllllllIlIllIIIlIlIllll.r.getValue(), (double)llllllllllllllllIlIllIIIlIlIllll.g.getValue(), (double)llllllllllllllllIlIllIIIlIlIllll.b.getValue());
            double llllllllllllllllIlIllIIIlIllIIlI = Breadcrumbs.mc.getRenderManager().viewerPosX;
            double llllllllllllllllIlIllIIIlIllIIIl = Breadcrumbs.mc.getRenderManager().viewerPosY;
            double llllllllllllllllIlIllIIIlIllIIII = Breadcrumbs.mc.getRenderManager().viewerPosZ;
            for (double[] llllllllllllllllIlIllIIIlIllIIll : llllllllllllllllIlIllIIIlIlIllll.positions) {
                GL11.glVertex3d((double)(llllllllllllllllIlIllIIIlIllIIll[0] - llllllllllllllllIlIllIIIlIllIIlI), (double)(llllllllllllllllIlIllIIIlIllIIll[1] - llllllllllllllllIlIllIIIlIllIIIl), (double)(llllllllllllllllIlIllIIIlIllIIll[2] - llllllllllllllllIlIllIIIlIllIIII));
            }
            GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)1.0);
            GL11.glEnd();
            GL11.glEnable((int)2929);
            GL11.glDisable((int)2848);
            GL11.glEnable((int)3553);
            GL11.glPopMatrix();
        }
        Tessellator.prepare(7);
        Tessellator.release();
    }

    public Breadcrumbs() {
        super("Breadcrumbs", Module.Category.RENDER);
        Breadcrumbs llllllllllllllllIlIllIIIllIlIlII;
        llllllllllllllllIlIllIIIllIlIlII.positions = new LinkedList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEnable() {
        Breadcrumbs llllllllllllllllIlIllIIIllIIIlIl;
        if (Breadcrumbs.mc.thePlayer == null) {
            return;
        }
        LinkedList<double[]> llllllllllllllllIlIllIIIllIIIlII = llllllllllllllllIlIllIIIllIIIlIl.positions;
        synchronized (llllllllllllllllIlIllIIIllIIIlII) {
            llllllllllllllllIlIllIIIllIIIlIl.positions.add(new double[]{Breadcrumbs.mc.thePlayer.posX, Breadcrumbs.mc.thePlayer.getEntityBoundingBox().minY + (double)(Breadcrumbs.mc.thePlayer.getEyeHeight() * 0.5f), Breadcrumbs.mc.thePlayer.posZ});
            llllllllllllllllIlIllIIIllIIIlIl.positions.add(new double[]{Breadcrumbs.mc.thePlayer.posX, Breadcrumbs.mc.thePlayer.getEntityBoundingBox().minY, Breadcrumbs.mc.thePlayer.posZ});
        }
        super.onEnable();
    }
}

