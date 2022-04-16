/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.util.FastTrig;

public class Ellipse
extends Shape {
    private /* synthetic */ float radius2;
    private /* synthetic */ int segmentCount;
    private /* synthetic */ float radius1;
    protected static final /* synthetic */ int DEFAULT_SEGMENT_COUNT;

    @Override
    protected void findCenter() {
        Ellipse llllllllllllllllIIllllIIllIIlIII;
        llllllllllllllllIIllllIIllIIlIII.center = new float[2];
        llllllllllllllllIIllllIIllIIlIII.center[0] = llllllllllllllllIIllllIIllIIlIII.x + llllllllllllllllIIllllIIllIIlIII.radius1;
        llllllllllllllllIIllllIIllIIlIII.center[1] = llllllllllllllllIIllllIIllIIlIII.y + llllllllllllllllIIllllIIllIIlIII.radius2;
    }

    public void setRadii(float llllllllllllllllIIllllIlIllIIlII, float llllllllllllllllIIllllIlIlIlllII) {
        Ellipse llllllllllllllllIIllllIlIllIIllI;
        llllllllllllllllIIllllIlIllIIllI.setRadius1(llllllllllllllllIIllllIlIllIIlII);
        llllllllllllllllIIllllIlIllIIllI.setRadius2(llllllllllllllllIIllllIlIlIlllII);
    }

    public void setRadius2(float llllllllllllllllIIllllIlIIlllIlI) {
        Ellipse llllllllllllllllIIllllIlIIlllIII;
        if (llllllllllllllllIIllllIlIIlllIlI != llllllllllllllllIIllllIlIIlllIII.radius2) {
            llllllllllllllllIIllllIlIIlllIII.radius2 = llllllllllllllllIIllllIlIIlllIlI;
            llllllllllllllllIIllllIlIIlllIII.pointsDirty = true;
        }
    }

    @Override
    protected void createPoints() {
        Ellipse llllllllllllllllIIllllIlIIIIIlll;
        ArrayList<Float> llllllllllllllllIIllllIlIIIIIlIl = new ArrayList<Float>();
        llllllllllllllllIIllllIlIIIIIlll.maxX = -1.4E-45f;
        llllllllllllllllIIllllIlIIIIIlll.maxY = -1.4E-45f;
        llllllllllllllllIIllllIlIIIIIlll.minX = Float.MAX_VALUE;
        llllllllllllllllIIllllIlIIIIIlll.minY = Float.MAX_VALUE;
        float llllllllllllllllIIllllIlIIIIIlII = 0.0f;
        float llllllllllllllllIIllllIlIIIIIIlI = 359.0f;
        float llllllllllllllllIIllllIlIIIIIIII = llllllllllllllllIIllllIlIIIIIlll.x + llllllllllllllllIIllllIlIIIIIlll.radius1;
        float llllllllllllllllIIllllIIlllllllI = llllllllllllllllIIllllIlIIIIIlll.y + llllllllllllllllIIllllIlIIIIIlll.radius2;
        int llllllllllllllllIIllllIIllllllIl = 360 / llllllllllllllllIIllllIlIIIIIlll.segmentCount;
        for (float llllllllllllllllIIllllIlIIIIlIll = llllllllllllllllIIllllIlIIIIIlII; llllllllllllllllIIllllIlIIIIlIll <= llllllllllllllllIIllllIlIIIIIIlI + (float)llllllllllllllllIIllllIIllllllIl; llllllllllllllllIIllllIlIIIIlIll += (float)llllllllllllllllIIllllIIllllllIl) {
            float llllllllllllllllIIllllIlIIIIllll = llllllllllllllllIIllllIlIIIIlIll;
            if (llllllllllllllllIIllllIlIIIIllll > llllllllllllllllIIllllIlIIIIIIlI) {
                llllllllllllllllIIllllIlIIIIllll = llllllllllllllllIIllllIlIIIIIIlI;
            }
            float llllllllllllllllIIllllIlIIIIlllI = (float)((double)llllllllllllllllIIllllIlIIIIIIII + FastTrig.cos(Math.toRadians(llllllllllllllllIIllllIlIIIIllll)) * (double)llllllllllllllllIIllllIlIIIIIlll.radius1);
            float llllllllllllllllIIllllIlIIIIllIl = (float)((double)llllllllllllllllIIllllIIlllllllI + FastTrig.sin(Math.toRadians(llllllllllllllllIIllllIlIIIIllll)) * (double)llllllllllllllllIIllllIlIIIIIlll.radius2);
            if (llllllllllllllllIIllllIlIIIIlllI > llllllllllllllllIIllllIlIIIIIlll.maxX) {
                llllllllllllllllIIllllIlIIIIIlll.maxX = llllllllllllllllIIllllIlIIIIlllI;
            }
            if (llllllllllllllllIIllllIlIIIIllIl > llllllllllllllllIIllllIlIIIIIlll.maxY) {
                llllllllllllllllIIllllIlIIIIIlll.maxY = llllllllllllllllIIllllIlIIIIllIl;
            }
            if (llllllllllllllllIIllllIlIIIIlllI < llllllllllllllllIIllllIlIIIIIlll.minX) {
                llllllllllllllllIIllllIlIIIIIlll.minX = llllllllllllllllIIllllIlIIIIlllI;
            }
            if (llllllllllllllllIIllllIlIIIIllIl < llllllllllllllllIIllllIlIIIIIlll.minY) {
                llllllllllllllllIIllllIlIIIIIlll.minY = llllllllllllllllIIllllIlIIIIllIl;
            }
            llllllllllllllllIIllllIlIIIIIlIl.add(new Float(llllllllllllllllIIllllIlIIIIlllI));
            llllllllllllllllIIllllIlIIIIIlIl.add(new Float(llllllllllllllllIIllllIlIIIIllIl));
        }
        llllllllllllllllIIllllIlIIIIIlll.points = new float[llllllllllllllllIIllllIlIIIIIlIl.size()];
        for (int llllllllllllllllIIllllIlIIIIlIIl = 0; llllllllllllllllIIllllIlIIIIlIIl < llllllllllllllllIIllllIlIIIIIlll.points.length; ++llllllllllllllllIIllllIlIIIIlIIl) {
            llllllllllllllllIIllllIlIIIIIlll.points[llllllllllllllllIIllllIlIIIIlIIl] = ((Float)llllllllllllllllIIllllIlIIIIIlIl.get(llllllllllllllllIIllllIlIIIIlIIl)).floatValue();
        }
    }

    public float getRadius2() {
        Ellipse llllllllllllllllIIllllIlIlIIlIII;
        return llllllllllllllllIIllllIlIlIIlIII.radius2;
    }

    static {
        DEFAULT_SEGMENT_COUNT = 50;
    }

    @Override
    public Shape transform(Transform llllllllllllllllIIllllIIllIlllIl) {
        Ellipse llllllllllllllllIIllllIIllIlIlll;
        llllllllllllllllIIllllIIllIlIlll.checkPoints();
        Polygon llllllllllllllllIIllllIIllIllIll = new Polygon();
        float[] llllllllllllllllIIllllIIllIllIIl = new float[llllllllllllllllIIllllIIllIlIlll.points.length];
        llllllllllllllllIIllllIIllIlllIl.transform(llllllllllllllllIIllllIIllIlIlll.points, 0, llllllllllllllllIIllllIIllIllIIl, 0, llllllllllllllllIIllllIIllIlIlll.points.length / 2);
        llllllllllllllllIIllllIIllIllIll.points = llllllllllllllllIIllllIIllIllIIl;
        llllllllllllllllIIllllIIllIllIll.checkPoints();
        return llllllllllllllllIIllllIIllIllIll;
    }

    public Ellipse(float llllllllllllllllIIllllIllIIlIIII, float llllllllllllllllIIllllIllIIIlIIl, float llllllllllllllllIIllllIllIIIlllI, float llllllllllllllllIIllllIllIIIllIl) {
        llllllllllllllllIIllllIllIIIllII(llllllllllllllllIIllllIllIIlIIII, llllllllllllllllIIllllIllIIIlIIl, llllllllllllllllIIllllIllIIIlllI, llllllllllllllllIIllllIllIIIllIl, 50);
        Ellipse llllllllllllllllIIllllIllIIIllII;
    }

    public float getRadius1() {
        Ellipse llllllllllllllllIIllllIlIlIllIIl;
        return llllllllllllllllIIllllIlIlIllIIl.radius1;
    }

    @Override
    protected void calculateRadius() {
        Ellipse llllllllllllllllIIllllIIlIllllII;
        llllllllllllllllIIllllIIlIllllII.boundingCircleRadius = llllllllllllllllIIllllIIlIllllII.radius1 > llllllllllllllllIIllllIIlIllllII.radius2 ? llllllllllllllllIIllllIIlIllllII.radius1 : llllllllllllllllIIllllIIlIllllII.radius2;
    }

    public Ellipse(float llllllllllllllllIIllllIlIllllIlI, float llllllllllllllllIIllllIlIlllIIll, float llllllllllllllllIIllllIlIlllIIlI, float llllllllllllllllIIllllIlIlllIIIl, int llllllllllllllllIIllllIlIlllIllI) {
        Ellipse llllllllllllllllIIllllIlIllllIll;
        llllllllllllllllIIllllIlIllllIll.x = llllllllllllllllIIllllIlIllllIlI - llllllllllllllllIIllllIlIlllIIlI;
        llllllllllllllllIIllllIlIllllIll.y = llllllllllllllllIIllllIlIlllIIll - llllllllllllllllIIllllIlIlllIIIl;
        llllllllllllllllIIllllIlIllllIll.radius1 = llllllllllllllllIIllllIlIlllIIlI;
        llllllllllllllllIIllllIlIllllIll.radius2 = llllllllllllllllIIllllIlIlllIIIl;
        llllllllllllllllIIllllIlIllllIll.segmentCount = llllllllllllllllIIllllIlIlllIllI;
        llllllllllllllllIIllllIlIllllIll.checkPoints();
    }

    public void setRadius1(float llllllllllllllllIIllllIlIlIIlllI) {
        Ellipse llllllllllllllllIIllllIlIlIlIIll;
        if (llllllllllllllllIIllllIlIlIIlllI != llllllllllllllllIIllllIlIlIlIIll.radius1) {
            llllllllllllllllIIllllIlIlIlIIll.radius1 = llllllllllllllllIIllllIlIlIIlllI;
            llllllllllllllllIIllllIlIlIlIIll.pointsDirty = true;
        }
    }
}

