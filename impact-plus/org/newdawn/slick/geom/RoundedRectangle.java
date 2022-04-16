/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.util.FastTrig;

public class RoundedRectangle
extends Rectangle {
    private /* synthetic */ int segmentCount;
    public static final /* synthetic */ int BOTTOM_LEFT;
    public static final /* synthetic */ int TOP_RIGHT;
    public static final /* synthetic */ int ALL;
    public static final /* synthetic */ int BOTTOM_RIGHT;
    private /* synthetic */ int cornerFlags;
    public static final /* synthetic */ int TOP_LEFT;
    private static final /* synthetic */ int DEFAULT_SEGMENT_COUNT;
    private /* synthetic */ float cornerRadius;

    @Override
    public void setHeight(float lllllllllllllllllIIIIIIlllllIIll) {
        RoundedRectangle lllllllllllllllllIIIIIIlllllIlIl;
        if (lllllllllllllllllIIIIIIlllllIlIl.height != lllllllllllllllllIIIIIIlllllIIll) {
            lllllllllllllllllIIIIIIlllllIlIl.height = lllllllllllllllllIIIIIIlllllIIll;
            lllllllllllllllllIIIIIIlllllIlIl.pointsDirty = true;
        }
    }

    @Override
    public float getHeight() {
        RoundedRectangle lllllllllllllllllIIIIIlIIIIIIIII;
        return lllllllllllllllllIIIIIlIIIIIIIII.height;
    }

    public RoundedRectangle(float lllllllllllllllllIIIIIlIIIIlllll, float lllllllllllllllllIIIIIlIIIIlllIl, float lllllllllllllllllIIIIIlIIIlIllII, float lllllllllllllllllIIIIIlIIIlIlIII, float lllllllllllllllllIIIIIlIIIIllIIl, int lllllllllllllllllIIIIIlIIIlIIlII, int lllllllllllllllllIIIIIlIIIlIIIlI) {
        super(lllllllllllllllllIIIIIlIIIIlllll, lllllllllllllllllIIIIIlIIIIlllIl, lllllllllllllllllIIIIIlIIIlIllII, lllllllllllllllllIIIIIlIIIlIlIII);
        RoundedRectangle lllllllllllllllllIIIIIlIIIllIIII;
        if (lllllllllllllllllIIIIIlIIIIllIIl < 0.0f) {
            throw new IllegalArgumentException("corner radius must be >= 0");
        }
        lllllllllllllllllIIIIIlIIIllIIII.x = lllllllllllllllllIIIIIlIIIIlllll;
        lllllllllllllllllIIIIIlIIIllIIII.y = lllllllllllllllllIIIIIlIIIIlllIl;
        lllllllllllllllllIIIIIlIIIllIIII.width = lllllllllllllllllIIIIIlIIIlIllII;
        lllllllllllllllllIIIIIlIIIllIIII.height = lllllllllllllllllIIIIIlIIIlIlIII;
        lllllllllllllllllIIIIIlIIIllIIII.cornerRadius = lllllllllllllllllIIIIIlIIIIllIIl;
        lllllllllllllllllIIIIIlIIIllIIII.segmentCount = lllllllllllllllllIIIIIlIIIlIIlII;
        lllllllllllllllllIIIIIlIIIllIIII.pointsDirty = true;
        lllllllllllllllllIIIIIlIIIllIIII.cornerFlags = lllllllllllllllllIIIIIlIIIlIIIlI;
    }

    public RoundedRectangle(float lllllllllllllllllIIIIIlIIllIIIII, float lllllllllllllllllIIIIIlIIllIIlIl, float lllllllllllllllllIIIIIlIIllIIlII, float lllllllllllllllllIIIIIlIIllIIIll, float lllllllllllllllllIIIIIlIIllIIIlI) {
        lllllllllllllllllIIIIIlIIllIIlll(lllllllllllllllllIIIIIlIIllIIIII, lllllllllllllllllIIIIIlIIllIIlIl, lllllllllllllllllIIIIIlIIllIIlII, lllllllllllllllllIIIIIlIIllIIIll, lllllllllllllllllIIIIIlIIllIIIlI, 25);
        RoundedRectangle lllllllllllllllllIIIIIlIIllIIlll;
    }

    public float getCornerRadius() {
        RoundedRectangle lllllllllllllllllIIIIIlIIIIlIIlI;
        return lllllllllllllllllIIIIIlIIIIlIIlI.cornerRadius;
    }

    public RoundedRectangle(float lllllllllllllllllIIIIIlIIlIIlIII, float lllllllllllllllllIIIIIlIIlIlIIlI, float lllllllllllllllllIIIIIlIIlIlIIIl, float lllllllllllllllllIIIIIlIIlIIIlII, float lllllllllllllllllIIIIIlIIlIIllII, int lllllllllllllllllIIIIIlIIlIIIIlI) {
        lllllllllllllllllIIIIIlIIlIIlIIl(lllllllllllllllllIIIIIlIIlIIlIII, lllllllllllllllllIIIIIlIIlIlIIlI, lllllllllllllllllIIIIIlIIlIlIIIl, lllllllllllllllllIIIIIlIIlIIIlII, lllllllllllllllllIIIIIlIIlIIllII, lllllllllllllllllIIIIIlIIlIIIIlI, 15);
        RoundedRectangle lllllllllllllllllIIIIIlIIlIIlIIl;
    }

    @Override
    public Shape transform(Transform lllllllllllllllllIIIIIIlIlIlllII) {
        RoundedRectangle lllllllllllllllllIIIIIIlIlIlIllI;
        lllllllllllllllllIIIIIIlIlIlIllI.checkPoints();
        Polygon lllllllllllllllllIIIIIIlIlIllIlI = new Polygon();
        float[] lllllllllllllllllIIIIIIlIlIllIII = new float[lllllllllllllllllIIIIIIlIlIlIllI.points.length];
        lllllllllllllllllIIIIIIlIlIlllII.transform(lllllllllllllllllIIIIIIlIlIlIllI.points, 0, lllllllllllllllllIIIIIIlIlIllIII, 0, lllllllllllllllllIIIIIIlIlIlIllI.points.length / 2);
        lllllllllllllllllIIIIIIlIlIllIlI.points = lllllllllllllllllIIIIIIlIlIllIII;
        lllllllllllllllllIIIIIIlIlIllIlI.findCenter();
        return lllllllllllllllllIIIIIIlIlIllIlI;
    }

    public void setCornerRadius(float lllllllllllllllllIIIIIlIIIIIIlIl) {
        RoundedRectangle lllllllllllllllllIIIIIlIIIIIIlll;
        if (lllllllllllllllllIIIIIlIIIIIIlIl >= 0.0f && lllllllllllllllllIIIIIlIIIIIIlIl != lllllllllllllllllIIIIIlIIIIIIlll.cornerRadius) {
            lllllllllllllllllIIIIIlIIIIIIlll.cornerRadius = lllllllllllllllllIIIIIlIIIIIIlIl;
            lllllllllllllllllIIIIIlIIIIIIlll.pointsDirty = true;
        }
    }

    static {
        TOP_LEFT = 1;
        BOTTOM_RIGHT = 4;
        DEFAULT_SEGMENT_COUNT = 25;
        ALL = 15;
        TOP_RIGHT = 2;
        BOTTOM_LEFT = 8;
    }

    @Override
    public void setWidth(float lllllllllllllllllIIIIIIllllIIllI) {
        RoundedRectangle lllllllllllllllllIIIIIIllllIIlIl;
        if (lllllllllllllllllIIIIIIllllIIllI != lllllllllllllllllIIIIIIllllIIlIl.width) {
            lllllllllllllllllIIIIIIllllIIlIl.width = lllllllllllllllllIIIIIIllllIIllI;
            lllllllllllllllllIIIIIIllllIIlIl.pointsDirty = true;
        }
    }

    private List createPoints(int lllllllllllllllllIIIIIIllIIIlIlI, float lllllllllllllllllIIIIIIllIIIlIII, float lllllllllllllllllIIIIIIlIllllIIl, float lllllllllllllllllIIIIIIllIIIIlIl, float lllllllllllllllllIIIIIIlIlllIlIl, float lllllllllllllllllIIIIIIllIIIIIlI) {
        ArrayList<Float> lllllllllllllllllIIIIIIllIIIIIIl = new ArrayList<Float>();
        int lllllllllllllllllIIIIIIllIIIIIII = 360 / lllllllllllllllllIIIIIIllIIIlIlI;
        for (float lllllllllllllllllIIIIIIllIIIllII = lllllllllllllllllIIIIIIlIlllIlIl; lllllllllllllllllIIIIIIllIIIllII <= lllllllllllllllllIIIIIIllIIIIIlI + (float)lllllllllllllllllIIIIIIllIIIIIII; lllllllllllllllllIIIIIIllIIIllII += (float)lllllllllllllllllIIIIIIllIIIIIII) {
            float lllllllllllllllllIIIIIIllIIlIIII = lllllllllllllllllIIIIIIllIIIllII;
            if (lllllllllllllllllIIIIIIllIIlIIII > lllllllllllllllllIIIIIIllIIIIIlI) {
                lllllllllllllllllIIIIIIllIIlIIII = lllllllllllllllllIIIIIIllIIIIIlI;
            }
            float lllllllllllllllllIIIIIIllIIIlllI = (float)((double)lllllllllllllllllIIIIIIlIllllIIl + FastTrig.cos(Math.toRadians(lllllllllllllllllIIIIIIllIIlIIII)) * (double)lllllllllllllllllIIIIIIllIIIlIII);
            float lllllllllllllllllIIIIIIllIIIllIl = (float)((double)lllllllllllllllllIIIIIIllIIIIlIl + FastTrig.sin(Math.toRadians(lllllllllllllllllIIIIIIllIIlIIII)) * (double)lllllllllllllllllIIIIIIllIIIlIII);
            lllllllllllllllllIIIIIIllIIIIIIl.add(new Float(lllllllllllllllllIIIIIIllIIIlllI));
            lllllllllllllllllIIIIIIllIIIIIIl.add(new Float(lllllllllllllllllIIIIIIllIIIllIl));
        }
        return lllllllllllllllllIIIIIIllIIIIIIl;
    }

    @Override
    protected void createPoints() {
        RoundedRectangle lllllllllllllllllIIIIIIllIllIllI;
        lllllllllllllllllIIIIIIllIllIllI.maxX = lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIllIllI.width;
        lllllllllllllllllIIIIIIllIllIllI.maxY = lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIllIllI.height;
        lllllllllllllllllIIIIIIllIllIllI.minX = lllllllllllllllllIIIIIIllIllIllI.x;
        lllllllllllllllllIIIIIIllIllIllI.minY = lllllllllllllllllIIIIIIllIllIllI.y;
        float lllllllllllllllllIIIIIIllIlllIlI = lllllllllllllllllIIIIIIllIllIllI.width - 1.0f;
        float lllllllllllllllllIIIIIIllIlllIII = lllllllllllllllllIIIIIIllIllIllI.height - 1.0f;
        if (lllllllllllllllllIIIIIIllIllIllI.cornerRadius == 0.0f) {
            lllllllllllllllllIIIIIIllIllIllI.points = new float[8];
            lllllllllllllllllIIIIIIllIllIllI.points[0] = lllllllllllllllllIIIIIIllIllIllI.x;
            lllllllllllllllllIIIIIIllIllIllI.points[1] = lllllllllllllllllIIIIIIllIllIllI.y;
            lllllllllllllllllIIIIIIllIllIllI.points[2] = lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIlllIlI;
            lllllllllllllllllIIIIIIllIllIllI.points[3] = lllllllllllllllllIIIIIIllIllIllI.y;
            lllllllllllllllllIIIIIIllIllIllI.points[4] = lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIlllIlI;
            lllllllllllllllllIIIIIIllIllIllI.points[5] = lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIlllIII;
            lllllllllllllllllIIIIIIllIllIllI.points[6] = lllllllllllllllllIIIIIIllIllIllI.x;
            lllllllllllllllllIIIIIIllIllIllI.points[7] = lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIlllIII;
        } else {
            float lllllllllllllllllIIIIIIlllIIIIIl = lllllllllllllllllIIIIIIllIllIllI.cornerRadius * 2.0f;
            if (lllllllllllllllllIIIIIIlllIIIIIl > lllllllllllllllllIIIIIIllIlllIlI) {
                lllllllllllllllllIIIIIIlllIIIIIl = lllllllllllllllllIIIIIIllIlllIlI;
                lllllllllllllllllIIIIIIllIllIllI.cornerRadius = lllllllllllllllllIIIIIIlllIIIIIl / 2.0f;
            }
            if (lllllllllllllllllIIIIIIlllIIIIIl > lllllllllllllllllIIIIIIllIlllIII) {
                lllllllllllllllllIIIIIIlllIIIIIl = lllllllllllllllllIIIIIIllIlllIII;
                lllllllllllllllllIIIIIIllIllIllI.cornerRadius = lllllllllllllllllIIIIIIlllIIIIIl / 2.0f;
            }
            ArrayList<Float> lllllllllllllllllIIIIIIlllIIIIII = new ArrayList<Float>();
            if ((lllllllllllllllllIIIIIIllIllIllI.cornerFlags & 1) != 0) {
                lllllllllllllllllIIIIIIlllIIIIII.addAll(lllllllllllllllllIIIIIIllIllIllI.createPoints(lllllllllllllllllIIIIIIllIllIllI.segmentCount, lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIllIllI.cornerRadius, 180.0f, 270.0f));
            } else {
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.x));
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.y));
            }
            if ((lllllllllllllllllIIIIIIllIllIllI.cornerFlags & 2) != 0) {
                lllllllllllllllllIIIIIIlllIIIIII.addAll(lllllllllllllllllIIIIIIllIllIllI.createPoints(lllllllllllllllllIIIIIIllIllIllI.segmentCount, lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIlllIlI - lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIllIllI.cornerRadius, 270.0f, 360.0f));
            } else {
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIlllIlI));
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.y));
            }
            if ((lllllllllllllllllIIIIIIllIllIllI.cornerFlags & 4) != 0) {
                lllllllllllllllllIIIIIIlllIIIIII.addAll(lllllllllllllllllIIIIIIllIllIllI.createPoints(lllllllllllllllllIIIIIIllIllIllI.segmentCount, lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIlllIlI - lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIlllIII - lllllllllllllllllIIIIIIllIllIllI.cornerRadius, 0.0f, 90.0f));
            } else {
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIlllIlI));
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIlllIII));
            }
            if ((lllllllllllllllllIIIIIIllIllIllI.cornerFlags & 8) != 0) {
                lllllllllllllllllIIIIIIlllIIIIII.addAll(lllllllllllllllllIIIIIIllIllIllI.createPoints(lllllllllllllllllIIIIIIllIllIllI.segmentCount, lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.x + lllllllllllllllllIIIIIIllIllIllI.cornerRadius, lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIlllIII - lllllllllllllllllIIIIIIllIllIllI.cornerRadius, 90.0f, 180.0f));
            } else {
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.x));
                lllllllllllllllllIIIIIIlllIIIIII.add(new Float(lllllllllllllllllIIIIIIllIllIllI.y + lllllllllllllllllIIIIIIllIlllIII));
            }
            lllllllllllllllllIIIIIIllIllIllI.points = new float[lllllllllllllllllIIIIIIlllIIIIII.size()];
            for (int lllllllllllllllllIIIIIIlllIIIIlI = 0; lllllllllllllllllIIIIIIlllIIIIlI < lllllllllllllllllIIIIIIlllIIIIII.size(); ++lllllllllllllllllIIIIIIlllIIIIlI) {
                lllllllllllllllllIIIIIIllIllIllI.points[lllllllllllllllllIIIIIIlllIIIIlI] = ((Float)lllllllllllllllllIIIIIIlllIIIIII.get(lllllllllllllllllIIIIIIlllIIIIlI)).floatValue();
            }
        }
        lllllllllllllllllIIIIIIllIllIllI.findCenter();
        lllllllllllllllllIIIIIIllIllIllI.calculateRadius();
    }

    @Override
    public float getWidth() {
        RoundedRectangle lllllllllllllllllIIIIIIllllIllII;
        return lllllllllllllllllIIIIIIllllIllII.width;
    }
}

