/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class Polygon
extends Shape {
    private /* synthetic */ boolean closed;
    private /* synthetic */ boolean allowDups;

    public Polygon(float[] llllllllllllllllIllIllIlIIIlIlII) {
        Polygon llllllllllllllllIllIllIlIIIlIlIl;
        llllllllllllllllIllIllIlIIIlIlIl.allowDups = false;
        llllllllllllllllIllIllIlIIIlIlIl.closed = true;
        int llllllllllllllllIllIllIlIIIlIIll = llllllllllllllllIllIllIlIIIlIlII.length;
        llllllllllllllllIllIllIlIIIlIlIl.points = new float[llllllllllllllllIllIllIlIIIlIIll];
        llllllllllllllllIllIllIlIIIlIlIl.maxX = -1.4E-45f;
        llllllllllllllllIllIllIlIIIlIlIl.maxY = -1.4E-45f;
        llllllllllllllllIllIllIlIIIlIlIl.minX = Float.MAX_VALUE;
        llllllllllllllllIllIllIlIIIlIlIl.minY = Float.MAX_VALUE;
        llllllllllllllllIllIllIlIIIlIlIl.x = Float.MAX_VALUE;
        llllllllllllllllIllIllIlIIIlIlIl.y = Float.MAX_VALUE;
        for (int llllllllllllllllIllIllIlIIIlIllI = 0; llllllllllllllllIllIllIlIIIlIllI < llllllllllllllllIllIllIlIIIlIIll; ++llllllllllllllllIllIllIlIIIlIllI) {
            llllllllllllllllIllIllIlIIIlIlIl.points[llllllllllllllllIllIllIlIIIlIllI] = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
            if (llllllllllllllllIllIllIlIIIlIllI % 2 == 0) {
                if (llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI] > llllllllllllllllIllIllIlIIIlIlIl.maxX) {
                    llllllllllllllllIllIllIlIIIlIlIl.maxX = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
                }
                if (llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI] < llllllllllllllllIllIllIlIIIlIlIl.minX) {
                    llllllllllllllllIllIllIlIIIlIlIl.minX = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
                }
                if (!(llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI] < llllllllllllllllIllIllIlIIIlIlIl.x)) continue;
                llllllllllllllllIllIllIlIIIlIlIl.x = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
                continue;
            }
            if (llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI] > llllllllllllllllIllIllIlIIIlIlIl.maxY) {
                llllllllllllllllIllIllIlIIIlIlIl.maxY = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
            }
            if (llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI] < llllllllllllllllIllIllIlIIIlIlIl.minY) {
                llllllllllllllllIllIllIlIIIlIlIl.minY = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
            }
            if (!(llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI] < llllllllllllllllIllIllIlIIIlIlIl.y)) continue;
            llllllllllllllllIllIllIlIIIlIlIl.y = llllllllllllllllIllIllIlIIIlIlII[llllllllllllllllIllIllIlIIIlIllI];
        }
        llllllllllllllllIllIllIlIIIlIlIl.findCenter();
        llllllllllllllllIllIllIlIIIlIlIl.calculateRadius();
        llllllllllllllllIllIllIlIIIlIlIl.pointsDirty = true;
    }

    @Override
    public Shape transform(Transform llllllllllllllllIllIllIIlllIlIIl) {
        Polygon llllllllllllllllIllIllIIlllIlllI;
        llllllllllllllllIllIllIIlllIlllI.checkPoints();
        Polygon llllllllllllllllIllIllIIlllIllII = new Polygon();
        float[] llllllllllllllllIllIllIIlllIlIll = new float[llllllllllllllllIllIllIIlllIlllI.points.length];
        llllllllllllllllIllIllIIlllIlIIl.transform(llllllllllllllllIllIllIIlllIlllI.points, 0, llllllllllllllllIllIllIIlllIlIll, 0, llllllllllllllllIllIllIIlllIlllI.points.length / 2);
        llllllllllllllllIllIllIIlllIllII.points = llllllllllllllllIllIllIIlllIlIll;
        llllllllllllllllIllIllIIlllIllII.findCenter();
        llllllllllllllllIllIllIIlllIllII.closed = llllllllllllllllIllIllIIlllIlllI.closed;
        return llllllllllllllllIllIllIIlllIllII;
    }

    public void addPoint(float llllllllllllllllIllIllIIllllllII, float llllllllllllllllIllIllIIlllllIll) {
        Polygon llllllllllllllllIllIllIIllllllIl;
        if (llllllllllllllllIllIllIIllllllIl.hasVertex(llllllllllllllllIllIllIIllllllII, llllllllllllllllIllIllIIlllllIll) && !llllllllllllllllIllIllIIllllllIl.allowDups) {
            return;
        }
        ArrayList<Float> llllllllllllllllIllIllIIlllllIlI = new ArrayList<Float>();
        for (int llllllllllllllllIllIllIIllllllll = 0; llllllllllllllllIllIllIIllllllll < llllllllllllllllIllIllIIllllllIl.points.length; ++llllllllllllllllIllIllIIllllllll) {
            llllllllllllllllIllIllIIlllllIlI.add(new Float(llllllllllllllllIllIllIIllllllIl.points[llllllllllllllllIllIllIIllllllll]));
        }
        llllllllllllllllIllIllIIlllllIlI.add(new Float(llllllllllllllllIllIllIIllllllII));
        llllllllllllllllIllIllIIlllllIlI.add(new Float(llllllllllllllllIllIllIIlllllIll));
        int llllllllllllllllIllIllIIlllllIIl = llllllllllllllllIllIllIIlllllIlI.size();
        llllllllllllllllIllIllIIllllllIl.points = new float[llllllllllllllllIllIllIIlllllIIl];
        for (int llllllllllllllllIllIllIIlllllllI = 0; llllllllllllllllIllIllIIlllllllI < llllllllllllllllIllIllIIlllllIIl; ++llllllllllllllllIllIllIIlllllllI) {
            llllllllllllllllIllIllIIllllllIl.points[llllllllllllllllIllIllIIlllllllI] = ((Float)llllllllllllllllIllIllIIlllllIlI.get(llllllllllllllllIllIllIIlllllllI)).floatValue();
        }
        if (llllllllllllllllIllIllIIllllllII > llllllllllllllllIllIllIIllllllIl.maxX) {
            llllllllllllllllIllIllIIllllllIl.maxX = llllllllllllllllIllIllIIllllllII;
        }
        if (llllllllllllllllIllIllIIlllllIll > llllllllllllllllIllIllIIllllllIl.maxY) {
            llllllllllllllllIllIllIIllllllIl.maxY = llllllllllllllllIllIllIIlllllIll;
        }
        if (llllllllllllllllIllIllIIllllllII < llllllllllllllllIllIllIIllllllIl.minX) {
            llllllllllllllllIllIllIIllllllIl.minX = llllllllllllllllIllIllIIllllllII;
        }
        if (llllllllllllllllIllIllIIlllllIll < llllllllllllllllIllIllIIllllllIl.minY) {
            llllllllllllllllIllIllIIllllllIl.minY = llllllllllllllllIllIllIIlllllIll;
        }
        llllllllllllllllIllIllIIllllllIl.findCenter();
        llllllllllllllllIllIllIIllllllIl.calculateRadius();
        llllllllllllllllIllIllIIllllllIl.pointsDirty = true;
    }

    public void setAllowDuplicatePoints(boolean llllllllllllllllIllIllIlIIIIIllI) {
        llllllllllllllllIllIllIlIIIIlIIl.allowDups = llllllllllllllllIllIllIlIIIIIllI;
    }

    public Polygon() {
        Polygon llllllllllllllllIllIllIlIIIIllIl;
        llllllllllllllllIllIllIlIIIIllIl.allowDups = false;
        llllllllllllllllIllIllIlIIIIllIl.closed = true;
        llllllllllllllllIllIllIlIIIIllIl.points = new float[0];
        llllllllllllllllIllIllIlIIIIllIl.maxX = -1.4E-45f;
        llllllllllllllllIllIllIlIIIIllIl.maxY = -1.4E-45f;
        llllllllllllllllIllIllIlIIIIllIl.minX = Float.MAX_VALUE;
        llllllllllllllllIllIllIlIIIIllIl.minY = Float.MAX_VALUE;
    }

    @Override
    protected void createPoints() {
    }

    public void setClosed(boolean llllllllllllllllIllIllIIllIlIIIl) {
        llllllllllllllllIllIllIIllIlIIlI.closed = llllllllllllllllIllIllIIllIlIIIl;
    }

    public Polygon copy() {
        Polygon llllllllllllllllIllIllIIllIIlllI;
        float[] llllllllllllllllIllIllIIllIIllIl = new float[llllllllllllllllIllIllIIllIIlllI.points.length];
        System.arraycopy(llllllllllllllllIllIllIIllIIlllI.points, 0, llllllllllllllllIllIllIIllIIllIl, 0, llllllllllllllllIllIllIIllIIllIl.length);
        return new Polygon(llllllllllllllllIllIllIIllIIllIl);
    }

    @Override
    public void setX(float llllllllllllllllIllIllIIlllIIIll) {
        Polygon llllllllllllllllIllIllIIlllIIIlI;
        super.setX(llllllllllllllllIllIllIIlllIIIll);
        llllllllllllllllIllIllIIlllIIIlI.pointsDirty = false;
    }

    @Override
    public boolean closed() {
        Polygon llllllllllllllllIllIllIIllIllIII;
        return llllllllllllllllIllIllIIllIllIII.closed;
    }

    @Override
    public void setY(float llllllllllllllllIllIllIIllIllIll) {
        Polygon llllllllllllllllIllIllIIllIllllI;
        super.setY(llllllllllllllllIllIllIIllIllIll);
        llllllllllllllllIllIllIIllIllllI.pointsDirty = false;
    }
}

