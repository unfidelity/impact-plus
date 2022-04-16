/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.io.Serializable;
import org.newdawn.slick.geom.GeomUtil;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.NeatTriangulator;
import org.newdawn.slick.geom.OverTriangulator;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Triangulator;
import org.newdawn.slick.geom.Vector2f;

public abstract class Shape
implements Serializable {
    protected /* synthetic */ float maxY;
    protected /* synthetic */ float minX;
    protected /* synthetic */ boolean pointsDirty;
    protected /* synthetic */ float[] points;
    protected /* synthetic */ float minY;
    protected /* synthetic */ boolean trianglesDirty;
    protected transient /* synthetic */ Triangulator tris;
    protected /* synthetic */ float y;
    protected /* synthetic */ float[] center;
    protected /* synthetic */ float boundingCircleRadius;
    protected /* synthetic */ float x;
    protected /* synthetic */ float maxX;

    public float getBoundingCircleRadius() {
        Shape llllllllllllllllIIIIllIIlllIIIlI;
        llllllllllllllllIIIIllIIlllIIIlI.checkPoints();
        return llllllllllllllllIIIIllIIlllIIIlI.boundingCircleRadius;
    }

    public void setCenterX(float llllllllllllllllIIIIllIlIIIIIlll) {
        Shape llllllllllllllllIIIIllIlIIIIIlIl;
        if (llllllllllllllllIIIIllIlIIIIIlIl.points == null || llllllllllllllllIIIIllIlIIIIIlIl.center == null) {
            llllllllllllllllIIIIllIlIIIIIlIl.checkPoints();
        }
        float llllllllllllllllIIIIllIlIIIIIllI = llllllllllllllllIIIIllIlIIIIIlll - llllllllllllllllIIIIllIlIIIIIlIl.getCenterX();
        llllllllllllllllIIIIllIlIIIIIlIl.setX(llllllllllllllllIIIIllIlIIIIIlIl.x + llllllllllllllllIIIIllIlIIIIIllI);
    }

    public boolean contains(Shape llllllllllllllllIIIIllIIIlllIlIl) {
        Shape llllllllllllllllIIIIllIIIlllIllI;
        if (llllllllllllllllIIIIllIIIlllIlIl.intersects(llllllllllllllllIIIIllIIIlllIllI)) {
            return false;
        }
        for (int llllllllllllllllIIIIllIIIlllllII = 0; llllllllllllllllIIIIllIIIlllllII < llllllllllllllllIIIIllIIIlllIlIl.getPointCount(); ++llllllllllllllllIIIIllIIIlllllII) {
            float[] llllllllllllllllIIIIllIIIllllllI = llllllllllllllllIIIIllIIIlllIlIl.getPoint(llllllllllllllllIIIIllIIIlllllII);
            if (llllllllllllllllIIIIllIIIlllIllI.contains(llllllllllllllllIIIIllIIIllllllI[0], llllllllllllllllIIIIllIIIllllllI[1])) continue;
            return false;
        }
        return true;
    }

    public Vector2f getLocation() {
        Shape llllllllllllllllIIIIllIlIIIlllII;
        return new Vector2f(llllllllllllllllIIIIllIlIIIlllII.getX(), llllllllllllllllIIIIllIlIIIlllII.getY());
    }

    public float[] getCenter() {
        Shape llllllllllllllllIIIIllIIlllIIIII;
        llllllllllllllllIIIIllIIlllIIIII.checkPoints();
        return llllllllllllllllIIIIllIIlllIIIII.center;
    }

    protected abstract void createPoints();

    public float getCenterY() {
        Shape llllllllllllllllIIIIllIlIIIIIIII;
        llllllllllllllllIIIIllIlIIIIIIII.checkPoints();
        return llllllllllllllllIIIIllIlIIIIIIII.center[1];
    }

    public float getMaxX() {
        Shape llllllllllllllllIIIIllIIlllIlllI;
        llllllllllllllllIIIIllIIlllIlllI.checkPoints();
        return llllllllllllllllIIIIllIIlllIlllI.maxX;
    }

    public float[] getPoints() {
        Shape llllllllllllllllIIIIllIIllIlllIl;
        llllllllllllllllIIIIllIIllIlllIl.checkPoints();
        return llllllllllllllllIIIIllIIllIlllIl.points;
    }

    public void preCache() {
        Shape llllllllllllllllIIIIlIlllIIIlllI;
        llllllllllllllllIIIIlIlllIIIlllI.checkPoints();
        llllllllllllllllIIIIlIlllIIIlllI.getTriangles();
    }

    protected void calculateRadius() {
        Shape llllllllllllllllIIIIlIlllIlllIII;
        llllllllllllllllIIIIlIlllIlllIII.boundingCircleRadius = 0.0f;
        for (int llllllllllllllllIIIIlIlllIlllIIl = 0; llllllllllllllllIIIIlIlllIlllIIl < llllllllllllllllIIIIlIlllIlllIII.points.length; llllllllllllllllIIIIlIlllIlllIIl += 2) {
            float llllllllllllllllIIIIlIlllIlllIlI = (llllllllllllllllIIIIlIlllIlllIII.points[llllllllllllllllIIIIlIlllIlllIIl] - llllllllllllllllIIIIlIlllIlllIII.center[0]) * (llllllllllllllllIIIIlIlllIlllIII.points[llllllllllllllllIIIIlIlllIlllIIl] - llllllllllllllllIIIIlIlllIlllIII.center[0]) + (llllllllllllllllIIIIlIlllIlllIII.points[llllllllllllllllIIIIlIlllIlllIIl + 1] - llllllllllllllllIIIIlIlllIlllIII.center[1]) * (llllllllllllllllIIIIlIlllIlllIII.points[llllllllllllllllIIIIlIlllIlllIIl + 1] - llllllllllllllllIIIIlIlllIlllIII.center[1]);
            llllllllllllllllIIIIlIlllIlllIII.boundingCircleRadius = llllllllllllllllIIIIlIlllIlllIII.boundingCircleRadius > llllllllllllllllIIIIlIlllIlllIlI ? llllllllllllllllIIIIlIlllIlllIII.boundingCircleRadius : llllllllllllllllIIIIlIlllIlllIlI;
        }
        llllllllllllllllIIIIlIlllIlllIII.boundingCircleRadius = (float)Math.sqrt(llllllllllllllllIIIIlIlllIlllIII.boundingCircleRadius);
    }

    public float getMinX() {
        Shape llllllllllllllllIIIIllIIlllIlIIl;
        llllllllllllllllIIIIllIIlllIlIIl.checkPoints();
        return llllllllllllllllIIIIllIIlllIlIIl.minX;
    }

    public void setLocation(float llllllllllllllllIIIIllIlIllIIIlI, float llllllllllllllllIIIIllIlIllIIIIl) {
        Shape llllllllllllllllIIIIllIlIllIIIll;
        llllllllllllllllIIIIllIlIllIIIll.setX(llllllllllllllllIIIIllIlIllIIIlI);
        llllllllllllllllIIIIllIlIllIIIll.setY(llllllllllllllllIIIIllIlIllIIIIl);
    }

    protected void findCenter() {
        Shape llllllllllllllllIIIIlIllllIIIIlI;
        llllllllllllllllIIIIlIllllIIIIlI.center = new float[]{0.0f, 0.0f};
        int llllllllllllllllIIIIlIllllIIIIIl = llllllllllllllllIIIIlIllllIIIIlI.points.length;
        for (int llllllllllllllllIIIIlIllllIIIIll = 0; llllllllllllllllIIIIlIllllIIIIll < llllllllllllllllIIIIlIllllIIIIIl; llllllllllllllllIIIIlIllllIIIIll += 2) {
            llllllllllllllllIIIIlIllllIIIIlI.center[0] = llllllllllllllllIIIIlIllllIIIIlI.center[0] + llllllllllllllllIIIIlIllllIIIIlI.points[llllllllllllllllIIIIlIllllIIIIll];
            llllllllllllllllIIIIlIllllIIIIlI.center[1] = llllllllllllllllIIIIlIllllIIIIlI.center[1] + llllllllllllllllIIIIlIllllIIIIlI.points[llllllllllllllllIIIIlIllllIIIIll + 1];
        }
        llllllllllllllllIIIIlIllllIIIIlI.center[0] = llllllllllllllllIIIIlIllllIIIIlI.center[0] / (float)(llllllllllllllllIIIIlIllllIIIIIl / 2);
        llllllllllllllllIIIIlIllllIIIIlI.center[1] = llllllllllllllllIIIIlIllllIIIIlI.center[1] / (float)(llllllllllllllllIIIIlIllllIIIIIl / 2);
    }

    public float getMaxY() {
        Shape llllllllllllllllIIIIllIIlllIlIll;
        llllllllllllllllIIIIllIIlllIlIll.checkPoints();
        return llllllllllllllllIIIIllIIlllIlIll.maxY;
    }

    public void setY(float llllllllllllllllIIIIllIlIIlIlllI) {
        Shape llllllllllllllllIIIIllIlIIlIllII;
        if (llllllllllllllllIIIIllIlIIlIlllI != llllllllllllllllIIIIllIlIIlIllII.y) {
            float llllllllllllllllIIIIllIlIIllIIlI = llllllllllllllllIIIIllIlIIlIlllI - llllllllllllllllIIIIllIlIIlIllII.y;
            llllllllllllllllIIIIllIlIIlIllII.y = llllllllllllllllIIIIllIlIIlIlllI;
            if (llllllllllllllllIIIIllIlIIlIllII.points == null || llllllllllllllllIIIIllIlIIlIllII.center == null) {
                llllllllllllllllIIIIllIlIIlIllII.checkPoints();
            }
            for (int llllllllllllllllIIIIllIlIIllIlII = 0; llllllllllllllllIIIIllIlIIllIlII < llllllllllllllllIIIIllIlIIlIllII.points.length / 2; ++llllllllllllllllIIIIllIlIIllIlII) {
                int n = llllllllllllllllIIIIllIlIIllIlII * 2 + 1;
                llllllllllllllllIIIIllIlIIlIllII.points[n] = llllllllllllllllIIIIllIlIIlIllII.points[n] + llllllllllllllllIIIIllIlIIllIIlI;
            }
            llllllllllllllllIIIIllIlIIlIllII.center[1] = llllllllllllllllIIIIllIlIIlIllII.center[1] + llllllllllllllllIIIIllIlIIllIIlI;
            llllllllllllllllIIIIllIlIIlIlllI += llllllllllllllllIIIIllIlIIllIIlI;
            llllllllllllllllIIIIllIlIIlIllII.maxY += llllllllllllllllIIIIllIlIIllIIlI;
            llllllllllllllllIIIIllIlIIlIllII.minY += llllllllllllllllIIIIllIlIIllIIlI;
            llllllllllllllllIIIIllIlIIlIllII.trianglesDirty = true;
        }
    }

    protected void calculateTriangles() {
        Shape llllllllllllllllIIIIlIlllIlIIlII;
        if (!llllllllllllllllIIIIlIlllIlIIlII.trianglesDirty && llllllllllllllllIIIIlIlllIlIIlII.tris != null) {
            return;
        }
        if (llllllllllllllllIIIIlIlllIlIIlII.points.length >= 6) {
            boolean llllllllllllllllIIIIlIlllIlIIllI = true;
            float llllllllllllllllIIIIlIlllIlIIlIl = 0.0f;
            for (int llllllllllllllllIIIIlIlllIlIlIII = 0; llllllllllllllllIIIIlIlllIlIlIII < llllllllllllllllIIIIlIlllIlIIlII.points.length / 2 - 1; ++llllllllllllllllIIIIlIlllIlIlIII) {
                float llllllllllllllllIIIIlIlllIlIllII = llllllllllllllllIIIIlIlllIlIIlII.points[llllllllllllllllIIIIlIlllIlIlIII * 2];
                float llllllllllllllllIIIIlIlllIlIlIll = llllllllllllllllIIIIlIlllIlIIlII.points[llllllllllllllllIIIIlIlllIlIlIII * 2 + 1];
                float llllllllllllllllIIIIlIlllIlIlIlI = llllllllllllllllIIIIlIlllIlIIlII.points[llllllllllllllllIIIIlIlllIlIlIII * 2 + 2];
                float llllllllllllllllIIIIlIlllIlIlIIl = llllllllllllllllIIIIlIlllIlIIlII.points[llllllllllllllllIIIIlIlllIlIlIII * 2 + 3];
                llllllllllllllllIIIIlIlllIlIIlIl += llllllllllllllllIIIIlIlllIlIllII * llllllllllllllllIIIIlIlllIlIlIIl - llllllllllllllllIIIIlIlllIlIlIll * llllllllllllllllIIIIlIlllIlIlIlI;
            }
            llllllllllllllllIIIIlIlllIlIIllI = (llllllllllllllllIIIIlIlllIlIIlIl /= 2.0f) > 0.0f;
            llllllllllllllllIIIIlIlllIlIIlII.tris = new NeatTriangulator();
            for (int llllllllllllllllIIIIlIlllIlIIlll = 0; llllllllllllllllIIIIlIlllIlIIlll < llllllllllllllllIIIIlIlllIlIIlII.points.length; llllllllllllllllIIIIlIlllIlIIlll += 2) {
                llllllllllllllllIIIIlIlllIlIIlII.tris.addPolyPoint(llllllllllllllllIIIIlIlllIlIIlII.points[llllllllllllllllIIIIlIlllIlIIlll], llllllllllllllllIIIIlIlllIlIIlII.points[llllllllllllllllIIIIlIlllIlIIlll + 1]);
            }
            llllllllllllllllIIIIlIlllIlIIlII.tris.triangulate();
        }
        llllllllllllllllIIIIlIlllIlIIlII.trianglesDirty = false;
    }

    public int indexOf(float llllllllllllllllIIIIllIIIIlIllIl, float llllllllllllllllIIIIllIIIIlIlIIl) {
        Shape llllllllllllllllIIIIllIIIIlIlllI;
        for (int llllllllllllllllIIIIllIIIIlIllll = 0; llllllllllllllllIIIIllIIIIlIllll < llllllllllllllllIIIIllIIIIlIlllI.points.length; llllllllllllllllIIIIllIIIIlIllll += 2) {
            if (llllllllllllllllIIIIllIIIIlIlllI.points[llllllllllllllllIIIIllIIIIlIllll] != llllllllllllllllIIIIllIIIIlIllIl || llllllllllllllllIIIIllIIIIlIlllI.points[llllllllllllllllIIIIllIIIIlIllll + 1] != llllllllllllllllIIIIllIIIIlIlIIl) continue;
            return llllllllllllllllIIIIllIIIIlIllll / 2;
        }
        return -1;
    }

    public boolean hasVertex(float llllllllllllllllIIIIlIllllIIllII, float llllllllllllllllIIIIlIllllIIlIII) {
        Shape llllllllllllllllIIIIlIllllIIllIl;
        if (llllllllllllllllIIIIlIllllIIllIl.points.length == 0) {
            return false;
        }
        llllllllllllllllIIIIlIllllIIllIl.checkPoints();
        for (int llllllllllllllllIIIIlIllllIIlllI = 0; llllllllllllllllIIIIlIllllIIlllI < llllllllllllllllIIIIlIllllIIllIl.points.length; llllllllllllllllIIIIlIllllIIlllI += 2) {
            if (llllllllllllllllIIIIlIllllIIllIl.points[llllllllllllllllIIIIlIllllIIlllI] != llllllllllllllllIIIIlIllllIIllII || llllllllllllllllIIIIlIllllIIllIl.points[llllllllllllllllIIIIlIllllIIlllI + 1] != llllllllllllllllIIIIlIllllIIlIII) continue;
            return true;
        }
        return false;
    }

    public Shape[] union(Shape llllllllllllllllIIIIlIllIllIIIIl) {
        Shape llllllllllllllllIIIIlIllIllIIIII;
        return new GeomUtil().union(llllllllllllllllIIIIlIllIllIIIII, llllllllllllllllIIIIlIllIllIIIIl);
    }

    public Shape() {
        Shape llllllllllllllllIIIIllIlIlllIIlI;
        llllllllllllllllIIIIllIlIlllIIlI.pointsDirty = true;
    }

    public boolean includes(float llllllllllllllllIIIIllIIIIllllIl, float llllllllllllllllIIIIllIIIlIIIIll) {
        Shape llllllllllllllllIIIIllIIIlIIIlIl;
        if (llllllllllllllllIIIIllIIIlIIIlIl.points.length == 0) {
            return false;
        }
        llllllllllllllllIIIIllIIIlIIIlIl.checkPoints();
        Line llllllllllllllllIIIIllIIIlIIIIIl = new Line(0.0f, 0.0f, 0.0f, 0.0f);
        Vector2f llllllllllllllllIIIIllIIIIllllll = new Vector2f(llllllllllllllllIIIIllIIIIllllIl, llllllllllllllllIIIIllIIIlIIIIll);
        for (int llllllllllllllllIIIIllIIIlIIIllI = 0; llllllllllllllllIIIIllIIIlIIIllI < llllllllllllllllIIIIllIIIlIIIlIl.points.length; llllllllllllllllIIIIllIIIlIIIllI += 2) {
            int llllllllllllllllIIIIllIIIlIIlIII = llllllllllllllllIIIIllIIIlIIIllI + 2;
            if (llllllllllllllllIIIIllIIIlIIlIII >= llllllllllllllllIIIIllIIIlIIIlIl.points.length) {
                llllllllllllllllIIIIllIIIlIIlIII = 0;
            }
            llllllllllllllllIIIIllIIIlIIIIIl.set(llllllllllllllllIIIIllIIIlIIIlIl.points[llllllllllllllllIIIIllIIIlIIIllI], llllllllllllllllIIIIllIIIlIIIlIl.points[llllllllllllllllIIIIllIIIlIIIllI + 1], llllllllllllllllIIIIllIIIlIIIlIl.points[llllllllllllllllIIIIllIIIlIIlIII], llllllllllllllllIIIIllIIIlIIIlIl.points[llllllllllllllllIIIIllIIIlIIlIII + 1]);
            if (!llllllllllllllllIIIIllIIIlIIIIIl.on(llllllllllllllllIIIIllIIIIllllll)) continue;
            return true;
        }
        return false;
    }

    public float[] getPoint(int llllllllllllllllIIIIllIIllIIIllI) {
        Shape llllllllllllllllIIIIllIIllIIlllI;
        llllllllllllllllIIIIllIIllIIlllI.checkPoints();
        float[] llllllllllllllllIIIIllIIllIIlIlI = new float[]{llllllllllllllllIIIIllIIllIIlllI.points[llllllllllllllllIIIIllIIllIIIllI * 2], llllllllllllllllIIIIllIIllIIlllI.points[llllllllllllllllIIIIllIIllIIIllI * 2 + 1]};
        return llllllllllllllllIIIIllIIllIIlIlI;
    }

    public float getHeight() {
        Shape llllllllllllllllIIIIlIllIlIllIlI;
        return llllllllllllllllIIIIlIllIlIllIlI.maxY - llllllllllllllllIIIIlIllIlIllIlI.minY;
    }

    public boolean intersects(Shape llllllllllllllllIIIIlIlllllIIlIl) {
        Shape llllllllllllllllIIIIlIlllllIIllI;
        llllllllllllllllIIIIlIlllllIIllI.checkPoints();
        boolean llllllllllllllllIIIIlIlllllIIlII = false;
        float[] llllllllllllllllIIIIlIlllllIIIll = llllllllllllllllIIIIlIlllllIIllI.getPoints();
        float[] llllllllllllllllIIIIlIlllllIIIlI = llllllllllllllllIIIIlIlllllIIlIl.getPoints();
        int llllllllllllllllIIIIlIlllllIIIIl = llllllllllllllllIIIIlIlllllIIIll.length;
        int llllllllllllllllIIIIlIlllllIIIII = llllllllllllllllIIIIlIlllllIIIlI.length;
        if (!llllllllllllllllIIIIlIlllllIIllI.closed()) {
            llllllllllllllllIIIIlIlllllIIIIl -= 2;
        }
        if (!llllllllllllllllIIIIlIlllllIIlIl.closed()) {
            llllllllllllllllIIIIlIlllllIIIII -= 2;
        }
        for (int llllllllllllllllIIIIlIlllllIIlll = 0; llllllllllllllllIIIIlIlllllIIlll < llllllllllllllllIIIIlIlllllIIIIl; llllllllllllllllIIIIlIlllllIIlll += 2) {
            int llllllllllllllllIIIIlIlllllIlIII = llllllllllllllllIIIIlIlllllIIlll + 2;
            if (llllllllllllllllIIIIlIlllllIlIII >= llllllllllllllllIIIIlIlllllIIIll.length) {
                llllllllllllllllIIIIlIlllllIlIII = 0;
            }
            for (int llllllllllllllllIIIIlIlllllIlIIl = 0; llllllllllllllllIIIIlIlllllIlIIl < llllllllllllllllIIIIlIlllllIIIII; llllllllllllllllIIIIlIlllllIlIIl += 2) {
                int llllllllllllllllIIIIlIlllllIllII = llllllllllllllllIIIIlIlllllIlIIl + 2;
                if (llllllllllllllllIIIIlIlllllIllII >= llllllllllllllllIIIIlIlllllIIIlI.length) {
                    llllllllllllllllIIIIlIlllllIllII = 0;
                }
                double llllllllllllllllIIIIlIlllllIlIll = ((double)(llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIlIII] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll]) * (double)(llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl + 1] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll + 1]) - (double)((llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIlIII + 1] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll + 1]) * (llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll]))) / (double)((llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIlIII + 1] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll + 1]) * (llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIllII] - llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl]) - (llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIlIII] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll]) * (llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIllII + 1] - llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl + 1]));
                double llllllllllllllllIIIIlIlllllIlIlI = ((double)(llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIllII] - llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl]) * (double)(llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl + 1] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll + 1]) - (double)((llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIllII + 1] - llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl + 1]) * (llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll]))) / (double)((llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIlIII + 1] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll + 1]) * (llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIllII] - llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl]) - (llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIlIII] - llllllllllllllllIIIIlIlllllIIIll[llllllllllllllllIIIIlIlllllIIlll]) * (llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIllII + 1] - llllllllllllllllIIIIlIlllllIIIlI[llllllllllllllllIIIIlIlllllIlIIl + 1]));
                if (!(llllllllllllllllIIIIlIlllllIlIll >= 0.0) || !(llllllllllllllllIIIIlIlllllIlIll <= 1.0) || !(llllllllllllllllIIIIlIlllllIlIlI >= 0.0) || !(llllllllllllllllIIIIlIlllllIlIlI <= 1.0)) continue;
                llllllllllllllllIIIIlIlllllIIlII = true;
                break;
            }
            if (llllllllllllllllIIIIlIlllllIIlII) break;
        }
        return llllllllllllllllIIIIlIlllllIIlII;
    }

    public Triangulator getTriangles() {
        Shape llllllllllllllllIIIIlIlllIIlIllI;
        llllllllllllllllIIIIlIlllIIlIllI.checkPoints();
        llllllllllllllllIIIIlIlllIIlIllI.calculateTriangles();
        return llllllllllllllllIIIIlIlllIIlIllI.tris;
    }

    public void setCenterY(float llllllllllllllllIIIIllIIlllllIlI) {
        Shape llllllllllllllllIIIIllIIllllllII;
        if (llllllllllllllllIIIIllIIllllllII.points == null || llllllllllllllllIIIIllIIllllllII.center == null) {
            llllllllllllllllIIIIllIIllllllII.checkPoints();
        }
        float llllllllllllllllIIIIllIIlllllIII = llllllllllllllllIIIIllIIlllllIlI - llllllllllllllllIIIIllIIllllllII.getCenterY();
        llllllllllllllllIIIIllIIllllllII.setY(llllllllllllllllIIIIllIIllllllII.y + llllllllllllllllIIIIllIIlllllIII);
    }

    public int getPointCount() {
        Shape llllllllllllllllIIIIllIIllIllIIl;
        llllllllllllllllIIIIllIIllIllIIl.checkPoints();
        return llllllllllllllllIIIIllIIllIllIIl.points.length / 2;
    }

    protected final void checkPoints() {
        Shape llllllllllllllllIIIIlIlllIIlIIIl;
        if (llllllllllllllllIIIIlIlllIIlIIIl.pointsDirty) {
            llllllllllllllllIIIIlIlllIIlIIIl.createPoints();
            llllllllllllllllIIIIlIlllIIlIIIl.findCenter();
            llllllllllllllllIIIIlIlllIIlIIIl.calculateRadius();
            if (llllllllllllllllIIIIlIlllIIlIIIl.points.length > 0) {
                llllllllllllllllIIIIlIlllIIlIIIl.maxX = llllllllllllllllIIIIlIlllIIlIIIl.points[0];
                llllllllllllllllIIIIlIlllIIlIIIl.maxY = llllllllllllllllIIIIlIlllIIlIIIl.points[1];
                llllllllllllllllIIIIlIlllIIlIIIl.minX = llllllllllllllllIIIIlIlllIIlIIIl.points[0];
                llllllllllllllllIIIIlIlllIIlIIIl.minY = llllllllllllllllIIIIlIlllIIlIIIl.points[1];
                for (int llllllllllllllllIIIIlIlllIIlIIll = 0; llllllllllllllllIIIIlIlllIIlIIll < llllllllllllllllIIIIlIlllIIlIIIl.points.length / 2; ++llllllllllllllllIIIIlIlllIIlIIll) {
                    llllllllllllllllIIIIlIlllIIlIIIl.maxX = Math.max(llllllllllllllllIIIIlIlllIIlIIIl.points[llllllllllllllllIIIIlIlllIIlIIll * 2], llllllllllllllllIIIIlIlllIIlIIIl.maxX);
                    llllllllllllllllIIIIlIlllIIlIIIl.maxY = Math.max(llllllllllllllllIIIIlIlllIIlIIIl.points[llllllllllllllllIIIIlIlllIIlIIll * 2 + 1], llllllllllllllllIIIIlIlllIIlIIIl.maxY);
                    llllllllllllllllIIIIlIlllIIlIIIl.minX = Math.min(llllllllllllllllIIIIlIlllIIlIIIl.points[llllllllllllllllIIIIlIlllIIlIIll * 2], llllllllllllllllIIIIlIlllIIlIIIl.minX);
                    llllllllllllllllIIIIlIlllIIlIIIl.minY = Math.min(llllllllllllllllIIIIlIlllIIlIIIl.points[llllllllllllllllIIIIlIlllIIlIIll * 2 + 1], llllllllllllllllIIIIlIlllIIlIIIl.minY);
                }
            }
            llllllllllllllllIIIIlIlllIIlIIIl.pointsDirty = false;
            llllllllllllllllIIIIlIlllIIlIIIl.trianglesDirty = true;
        }
    }

    public float getCenterX() {
        Shape llllllllllllllllIIIIllIlIIIIllII;
        llllllllllllllllIIIIllIlIIIIllII.checkPoints();
        return llllllllllllllllIIIIllIlIIIIllII.center[0];
    }

    public Shape[] subtract(Shape llllllllllllllllIIIIlIllIllIIlIl) {
        Shape llllllllllllllllIIIIlIllIllIlIII;
        return new GeomUtil().subtract(llllllllllllllllIIIIlIllIllIlIII, llllllllllllllllIIIIlIllIllIIlIl);
    }

    public abstract Shape transform(Transform var1);

    public float[] getNormal(int llllllllllllllllIIIIllIIlIIllIll) {
        Shape llllllllllllllllIIIIllIIlIllIIII;
        float[] llllllllllllllllIIIIllIIlIlIllIl = llllllllllllllllIIIIllIIlIllIIII.getPoint(llllllllllllllllIIIIllIIlIIllIll);
        float[] llllllllllllllllIIIIllIIlIlIlIll = llllllllllllllllIIIIllIIlIllIIII.getPoint(llllllllllllllllIIIIllIIlIIllIll - 1 < 0 ? llllllllllllllllIIIIllIIlIllIIII.getPointCount() - 1 : llllllllllllllllIIIIllIIlIIllIll - 1);
        float[] llllllllllllllllIIIIllIIlIlIlIIl = llllllllllllllllIIIIllIIlIllIIII.getPoint(llllllllllllllllIIIIllIIlIIllIll + 1 >= llllllllllllllllIIIIllIIlIllIIII.getPointCount() ? 0 : llllllllllllllllIIIIllIIlIIllIll + 1);
        float[] llllllllllllllllIIIIllIIlIlIIlll = llllllllllllllllIIIIllIIlIllIIII.getNormal(llllllllllllllllIIIIllIIlIlIlIll, llllllllllllllllIIIIllIIlIlIllIl);
        float[] llllllllllllllllIIIIllIIlIlIIlIl = llllllllllllllllIIIIllIIlIllIIII.getNormal(llllllllllllllllIIIIllIIlIlIllIl, llllllllllllllllIIIIllIIlIlIlIIl);
        if (llllllllllllllllIIIIllIIlIIllIll == 0 && !llllllllllllllllIIIIllIIlIllIIII.closed()) {
            return llllllllllllllllIIIIllIIlIlIIlIl;
        }
        if (llllllllllllllllIIIIllIIlIIllIll == llllllllllllllllIIIIllIIlIllIIII.getPointCount() - 1 && !llllllllllllllllIIIIllIIlIllIIII.closed()) {
            return llllllllllllllllIIIIllIIlIlIIlll;
        }
        float llllllllllllllllIIIIllIIlIlIIIll = (llllllllllllllllIIIIllIIlIlIIlll[0] + llllllllllllllllIIIIllIIlIlIIlIl[0]) / 2.0f;
        float llllllllllllllllIIIIllIIlIlIIIIl = (llllllllllllllllIIIIllIIlIlIIlll[1] + llllllllllllllllIIIIllIIlIlIIlIl[1]) / 2.0f;
        float llllllllllllllllIIIIllIIlIIlllll = (float)Math.sqrt(llllllllllllllllIIIIllIIlIlIIIll * llllllllllllllllIIIIllIIlIlIIIll + llllllllllllllllIIIIllIIlIlIIIIl * llllllllllllllllIIIIllIIlIlIIIIl);
        return new float[]{llllllllllllllllIIIIllIIlIlIIIll / llllllllllllllllIIIIllIIlIIlllll, llllllllllllllllIIIIllIIlIlIIIIl / llllllllllllllllIIIIllIIlIIlllll};
    }

    public void setLocation(Vector2f llllllllllllllllIIIIllIlIIIlIIlI) {
        Shape llllllllllllllllIIIIllIlIIIlIlll;
        llllllllllllllllIIIIllIlIIIlIlll.setX(llllllllllllllllIIIIllIlIIIlIIlI.x);
        llllllllllllllllIIIIllIlIIIlIlll.setY(llllllllllllllllIIIIllIlIIIlIIlI.y);
    }

    public void increaseTriangulation() {
        Shape llllllllllllllllIIIIlIlllIIllIlI;
        llllllllllllllllIIIIlIlllIIllIlI.checkPoints();
        llllllllllllllllIIIIlIlllIIllIlI.calculateTriangles();
        llllllllllllllllIIIIlIlllIIllIlI.tris = new OverTriangulator(llllllllllllllllIIIIlIlllIIllIlI.tris);
    }

    public boolean contains(float llllllllllllllllIIIIllIIIIIIIllI, float llllllllllllllllIIIIllIIIIIIIlIl) {
        Shape llllllllllllllllIIIIllIIIIIIIlll;
        llllllllllllllllIIIIllIIIIIIIlll.checkPoints();
        if (llllllllllllllllIIIIllIIIIIIIlll.points.length == 0) {
            return false;
        }
        boolean llllllllllllllllIIIIllIIIIIIlIll = false;
        int llllllllllllllllIIIIllIIIIIIlIII = llllllllllllllllIIIIllIIIIIIIlll.points.length;
        float llllllllllllllllIIIIllIIIIIIlIlI = llllllllllllllllIIIIllIIIIIIIlll.points[llllllllllllllllIIIIllIIIIIIlIII - 2];
        float llllllllllllllllIIIIllIIIIIIlIIl = llllllllllllllllIIIIllIIIIIIIlll.points[llllllllllllllllIIIIllIIIIIIlIII - 1];
        for (int llllllllllllllllIIIIllIIIIIIllll = 0; llllllllllllllllIIIIllIIIIIIllll < llllllllllllllllIIIIllIIIIIIlIII; llllllllllllllllIIIIllIIIIIIllll += 2) {
            float llllllllllllllllIIIIllIIIIIlIIII;
            float llllllllllllllllIIIIllIIIIIlIIlI;
            float llllllllllllllllIIIIllIIIIIlIIIl;
            float llllllllllllllllIIIIllIIIIIlIIll;
            float llllllllllllllllIIIIllIIIIIlIlIl = llllllllllllllllIIIIllIIIIIIIlll.points[llllllllllllllllIIIIllIIIIIIllll];
            float llllllllllllllllIIIIllIIIIIlIlII = llllllllllllllllIIIIllIIIIIIIlll.points[llllllllllllllllIIIIllIIIIIIllll + 1];
            if (llllllllllllllllIIIIllIIIIIlIlIl > llllllllllllllllIIIIllIIIIIIlIlI) {
                float llllllllllllllllIIIIllIIIIIllIIl = llllllllllllllllIIIIllIIIIIIlIlI;
                float llllllllllllllllIIIIllIIIIIlIlll = llllllllllllllllIIIIllIIIIIlIlIl;
                float llllllllllllllllIIIIllIIIIIllIII = llllllllllllllllIIIIllIIIIIIlIIl;
                float llllllllllllllllIIIIllIIIIIlIllI = llllllllllllllllIIIIllIIIIIlIlII;
            } else {
                llllllllllllllllIIIIllIIIIIlIIll = llllllllllllllllIIIIllIIIIIlIlIl;
                llllllllllllllllIIIIllIIIIIlIIIl = llllllllllllllllIIIIllIIIIIIlIlI;
                llllllllllllllllIIIIllIIIIIlIIlI = llllllllllllllllIIIIllIIIIIlIlII;
                llllllllllllllllIIIIllIIIIIlIIII = llllllllllllllllIIIIllIIIIIIlIIl;
            }
            if (llllllllllllllllIIIIllIIIIIlIlIl < llllllllllllllllIIIIllIIIIIIIllI == llllllllllllllllIIIIllIIIIIIIllI <= llllllllllllllllIIIIllIIIIIIlIlI && ((double)llllllllllllllllIIIIllIIIIIIIlIl - (double)llllllllllllllllIIIIllIIIIIlIIlI) * (double)(llllllllllllllllIIIIllIIIIIlIIIl - llllllllllllllllIIIIllIIIIIlIIll) < ((double)llllllllllllllllIIIIllIIIIIlIIII - (double)llllllllllllllllIIIIllIIIIIlIIlI) * (double)(llllllllllllllllIIIIllIIIIIIIllI - llllllllllllllllIIIIllIIIIIlIIll)) {
                llllllllllllllllIIIIllIIIIIIlIll = !llllllllllllllllIIIIllIIIIIIlIll;
            }
            llllllllllllllllIIIIllIIIIIIlIlI = llllllllllllllllIIIIllIIIIIlIlIl;
            llllllllllllllllIIIIllIIIIIIlIIl = llllllllllllllllIIIIllIIIIIlIlII;
        }
        return llllllllllllllllIIIIllIIIIIIlIll;
    }

    public float getWidth() {
        Shape llllllllllllllllIIIIlIllIlIlllIl;
        return llllllllllllllllIIIIlIllIlIlllIl.maxX - llllllllllllllllIIIIlIllIlIlllIl.minX;
    }

    private float[] getNormal(float[] llllllllllllllllIIIIllIIIlIllIlI, float[] llllllllllllllllIIIIllIIIllIIIII) {
        float llllllllllllllllIIIIllIIIlIllllI = llllllllllllllllIIIIllIIIlIllIlI[0] - llllllllllllllllIIIIllIIIllIIIII[0];
        float llllllllllllllllIIIIllIIIlIlllII = llllllllllllllllIIIIllIIIlIllIlI[1] - llllllllllllllllIIIIllIIIllIIIII[1];
        float llllllllllllllllIIIIllIIIlIllIll = (float)Math.sqrt(llllllllllllllllIIIIllIIIlIllllI * llllllllllllllllIIIIllIIIlIllllI + llllllllllllllllIIIIllIIIlIlllII * llllllllllllllllIIIIllIIIlIlllII);
        return new float[]{-(llllllllllllllllIIIIllIIIlIlllII /= llllllllllllllllIIIIllIIIlIllIll), llllllllllllllllIIIIllIIIlIllllI /= llllllllllllllllIIIIllIIIlIllIll};
    }

    public float getX() {
        Shape llllllllllllllllIIIIllIlIlIllllI;
        return llllllllllllllllIIIIllIlIlIllllI.x;
    }

    public float getMinY() {
        Shape llllllllllllllllIIIIllIIlllIIlIl;
        llllllllllllllllIIIIllIIlllIIlIl.checkPoints();
        return llllllllllllllllIIIIllIIlllIIlIl.minY;
    }

    public Shape prune() {
        Shape llllllllllllllllIIIIlIllIlllIlIl;
        Polygon llllllllllllllllIIIIlIllIlllIllI = new Polygon();
        for (int llllllllllllllllIIIIlIllIllllIII = 0; llllllllllllllllIIIIlIllIllllIII < llllllllllllllllIIIIlIllIlllIlIl.getPointCount(); ++llllllllllllllllIIIIlIllIllllIII) {
            float llllllllllllllllIIIIlIllIllllIIl;
            float llllllllllllllllIIIIlIllIllllIlI;
            int llllllllllllllllIIIIlIlllIIIIIII = llllllllllllllllIIIIlIllIllllIII + 1 >= llllllllllllllllIIIIlIllIlllIlIl.getPointCount() ? 0 : llllllllllllllllIIIIlIllIllllIII + 1;
            int llllllllllllllllIIIIlIllIlllllll = llllllllllllllllIIIIlIllIllllIII - 1 < 0 ? llllllllllllllllIIIIlIllIlllIlIl.getPointCount() - 1 : llllllllllllllllIIIIlIllIllllIII - 1;
            float llllllllllllllllIIIIlIllIllllllI = llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIllllIII)[0] - llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIlllllll)[0];
            float llllllllllllllllIIIIlIllIlllllIl = llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIllllIII)[1] - llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIlllllll)[1];
            float llllllllllllllllIIIIlIllIlllllII = llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIlllIIIIIII)[0] - llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIllllIII)[0];
            float llllllllllllllllIIIIlIllIllllIll = llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIlllIIIIIII)[1] - llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIllllIII)[1];
            if ((llllllllllllllllIIIIlIllIllllllI /= (llllllllllllllllIIIIlIllIllllIlI = (float)Math.sqrt(llllllllllllllllIIIIlIllIllllllI * llllllllllllllllIIIIlIllIllllllI + llllllllllllllllIIIIlIllIlllllIl * llllllllllllllllIIIIlIllIlllllIl))) == (llllllllllllllllIIIIlIllIlllllII /= (llllllllllllllllIIIIlIllIllllIIl = (float)Math.sqrt(llllllllllllllllIIIIlIllIlllllII * llllllllllllllllIIIIlIllIlllllII + llllllllllllllllIIIIlIllIllllIll * llllllllllllllllIIIIlIllIllllIll))) && (llllllllllllllllIIIIlIllIlllllIl /= llllllllllllllllIIIIlIllIllllIlI) == (llllllllllllllllIIIIlIllIllllIll /= llllllllllllllllIIIIlIllIllllIIl)) continue;
            llllllllllllllllIIIIlIllIlllIllI.addPoint(llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIllllIII)[0], llllllllllllllllIIIIlIllIlllIlIl.getPoint(llllllllllllllllIIIIlIllIllllIII)[1]);
        }
        return llllllllllllllllIIIIlIllIlllIllI;
    }

    public float getY() {
        Shape llllllllllllllllIIIIllIlIIlIIIII;
        return llllllllllllllllIIIIllIlIIlIIIII.y;
    }

    public boolean closed() {
        return true;
    }

    public void setX(float llllllllllllllllIIIIllIlIlIIIlIl) {
        Shape llllllllllllllllIIIIllIlIlIIlIII;
        if (llllllllllllllllIIIIllIlIlIIIlIl != llllllllllllllllIIIIllIlIlIIlIII.x) {
            float llllllllllllllllIIIIllIlIlIIlIIl = llllllllllllllllIIIIllIlIlIIIlIl - llllllllllllllllIIIIllIlIlIIlIII.x;
            llllllllllllllllIIIIllIlIlIIlIII.x = llllllllllllllllIIIIllIlIlIIIlIl;
            if (llllllllllllllllIIIIllIlIlIIlIII.points == null || llllllllllllllllIIIIllIlIlIIlIII.center == null) {
                llllllllllllllllIIIIllIlIlIIlIII.checkPoints();
            }
            for (int llllllllllllllllIIIIllIlIlIIlIlI = 0; llllllllllllllllIIIIllIlIlIIlIlI < llllllllllllllllIIIIllIlIlIIlIII.points.length / 2; ++llllllllllllllllIIIIllIlIlIIlIlI) {
                int n = llllllllllllllllIIIIllIlIlIIlIlI * 2;
                llllllllllllllllIIIIllIlIlIIlIII.points[n] = llllllllllllllllIIIIllIlIlIIlIII.points[n] + llllllllllllllllIIIIllIlIlIIlIIl;
            }
            llllllllllllllllIIIIllIlIlIIlIII.center[0] = llllllllllllllllIIIIllIlIlIIlIII.center[0] + llllllllllllllllIIIIllIlIlIIlIIl;
            llllllllllllllllIIIIllIlIlIIIlIl += llllllllllllllllIIIIllIlIlIIlIIl;
            llllllllllllllllIIIIllIlIlIIlIII.maxX += llllllllllllllllIIIIllIlIlIIlIIl;
            llllllllllllllllIIIIllIlIlIIlIII.minX += llllllllllllllllIIIIllIlIlIIlIIl;
            llllllllllllllllIIIIllIlIlIIlIII.trianglesDirty = true;
        }
    }
}

