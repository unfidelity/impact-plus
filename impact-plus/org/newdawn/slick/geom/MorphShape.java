/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class MorphShape
extends Shape {
    private /* synthetic */ float offset;
    private /* synthetic */ Shape current;
    private /* synthetic */ ArrayList shapes;
    private /* synthetic */ Shape next;

    public void updateMorphTime(float lllllllllllllllllllIllIllIIlIIII) {
        MorphShape lllllllllllllllllllIllIllIIlIIIl;
        lllllllllllllllllllIllIllIIlIIIl.offset += lllllllllllllllllllIllIllIIlIIII;
        if (lllllllllllllllllllIllIllIIlIIIl.offset < 0.0f) {
            int lllllllllllllllllllIllIllIIlIlll = lllllllllllllllllllIllIllIIlIIIl.shapes.indexOf(lllllllllllllllllllIllIllIIlIIIl.current);
            if (lllllllllllllllllllIllIllIIlIlll < 0) {
                lllllllllllllllllllIllIllIIlIlll = lllllllllllllllllllIllIllIIlIIIl.shapes.size() - 1;
            }
            int lllllllllllllllllllIllIllIIlIllI = lllllllllllllllllllIllIllIIlIIIl.rational(lllllllllllllllllllIllIllIIlIlll + 1);
            lllllllllllllllllllIllIllIIlIIIl.setFrame(lllllllllllllllllllIllIllIIlIlll, lllllllllllllllllllIllIllIIlIllI, lllllllllllllllllllIllIllIIlIIIl.offset);
            lllllllllllllllllllIllIllIIlIIIl.offset += 1.0f;
        } else if (lllllllllllllllllllIllIllIIlIIIl.offset > 1.0f) {
            int lllllllllllllllllllIllIllIIlIlIl = lllllllllllllllllllIllIllIIlIIIl.shapes.indexOf(lllllllllllllllllllIllIllIIlIIIl.next);
            if (lllllllllllllllllllIllIllIIlIlIl < 1) {
                lllllllllllllllllllIllIllIIlIlIl = 0;
            }
            int lllllllllllllllllllIllIllIIlIlII = lllllllllllllllllllIllIllIIlIIIl.rational(lllllllllllllllllllIllIllIIlIlIl + 1);
            lllllllllllllllllllIllIllIIlIIIl.setFrame(lllllllllllllllllllIllIllIIlIlIl, lllllllllllllllllllIllIllIIlIlII, lllllllllllllllllllIllIllIIlIIIl.offset);
            lllllllllllllllllllIllIllIIlIIIl.offset -= 1.0f;
        } else {
            lllllllllllllllllllIllIllIIlIIIl.pointsDirty = true;
        }
    }

    private boolean equalShapes(Shape lllllllllllllllllllIllIllIllIIlI, Shape lllllllllllllllllllIllIllIllIIII) {
        lllllllllllllllllllIllIllIllIIlI.checkPoints();
        lllllllllllllllllllIllIllIllIIII.checkPoints();
        for (int lllllllllllllllllllIllIllIllIlll = 0; lllllllllllllllllllIllIllIllIlll < lllllllllllllllllllIllIllIllIIlI.points.length; ++lllllllllllllllllllIllIllIllIlll) {
            if (lllllllllllllllllllIllIllIllIIlI.points[lllllllllllllllllllIllIllIllIlll] == lllllllllllllllllllIllIllIllIIII.points[lllllllllllllllllllIllIllIllIlll]) continue;
            return false;
        }
        return true;
    }

    public void setMorphTime(float lllllllllllllllllllIllIllIIlllll) {
        MorphShape lllllllllllllllllllIllIllIlIIIII;
        int lllllllllllllllllllIllIllIlIIIll = (int)lllllllllllllllllllIllIllIIlllll;
        int lllllllllllllllllllIllIllIlIIIlI = lllllllllllllllllllIllIllIlIIIll + 1;
        float lllllllllllllllllllIllIllIlIIIIl = lllllllllllllllllllIllIllIIlllll - (float)lllllllllllllllllllIllIllIlIIIll;
        lllllllllllllllllllIllIllIlIIIll = lllllllllllllllllllIllIllIlIIIII.rational(lllllllllllllllllllIllIllIlIIIll);
        lllllllllllllllllllIllIllIlIIIlI = lllllllllllllllllllIllIllIlIIIII.rational(lllllllllllllllllllIllIllIlIIIlI);
        lllllllllllllllllllIllIllIlIIIII.setFrame(lllllllllllllllllllIllIllIlIIIll, lllllllllllllllllllIllIllIlIIIlI, lllllllllllllllllllIllIllIlIIIIl);
    }

    private int rational(int lllllllllllllllllllIllIlIllIlllI) {
        MorphShape lllllllllllllllllllIllIlIllIllII;
        while (lllllllllllllllllllIllIlIllIlllI >= lllllllllllllllllllIllIlIllIllII.shapes.size()) {
            lllllllllllllllllllIllIlIllIlllI -= lllllllllllllllllllIllIlIllIllII.shapes.size();
        }
        while (lllllllllllllllllllIllIlIllIlllI < 0) {
            lllllllllllllllllllIllIlIllIlllI += lllllllllllllllllllIllIlIllIllII.shapes.size();
        }
        return lllllllllllllllllllIllIlIllIlllI;
    }

    @Override
    protected void createPoints() {
        MorphShape lllllllllllllllllllIllIlIlIIlIII;
        if (lllllllllllllllllllIllIlIlIIlIII.current == lllllllllllllllllllIllIlIlIIlIII.next) {
            System.arraycopy(lllllllllllllllllllIllIlIlIIlIII.current.points, 0, lllllllllllllllllllIllIlIlIIlIII.points, 0, lllllllllllllllllllIllIlIlIIlIII.points.length);
            return;
        }
        float[] lllllllllllllllllllIllIlIlIIlIlI = lllllllllllllllllllIllIlIlIIlIII.current.points;
        float[] lllllllllllllllllllIllIlIlIIlIIl = lllllllllllllllllllIllIlIlIIlIII.next.points;
        for (int lllllllllllllllllllIllIlIlIIllII = 0; lllllllllllllllllllIllIlIlIIllII < lllllllllllllllllllIllIlIlIIlIII.points.length; ++lllllllllllllllllllIllIlIlIIllII) {
            lllllllllllllllllllIllIlIlIIlIII.points[lllllllllllllllllllIllIlIlIIllII] = lllllllllllllllllllIllIlIlIIlIlI[lllllllllllllllllllIllIlIlIIllII] * (1.0f - lllllllllllllllllllIllIlIlIIlIII.offset);
            int n = lllllllllllllllllllIllIlIlIIllII;
            lllllllllllllllllllIllIlIlIIlIII.points[n] = lllllllllllllllllllIllIlIlIIlIII.points[n] + lllllllllllllllllllIllIlIlIIlIIl[lllllllllllllllllllIllIlIlIIllII] * lllllllllllllllllllIllIlIlIIlIII.offset;
        }
    }

    public MorphShape(Shape lllllllllllllllllllIllIlllIlIIlI) {
        MorphShape lllllllllllllllllllIllIlllIlIIll;
        lllllllllllllllllllIllIlllIlIIll.shapes = new ArrayList();
        lllllllllllllllllllIllIlllIlIIll.shapes.add(lllllllllllllllllllIllIlllIlIIlI);
        float[] lllllllllllllllllllIllIlllIlIlII = lllllllllllllllllllIllIlllIlIIlI.points;
        lllllllllllllllllllIllIlllIlIIll.points = new float[lllllllllllllllllllIllIlllIlIlII.length];
        lllllllllllllllllllIllIlllIlIIll.current = lllllllllllllllllllIllIlllIlIIlI;
        lllllllllllllllllllIllIlllIlIIll.next = lllllllllllllllllllIllIlllIlIIlI;
    }

    private void setFrame(int lllllllllllllllllllIllIlIllIIlII, int lllllllllllllllllllIllIlIllIIIll, float lllllllllllllllllllIllIlIlIlllII) {
        MorphShape lllllllllllllllllllIllIlIllIIlIl;
        lllllllllllllllllllIllIlIllIIlIl.current = (Shape)lllllllllllllllllllIllIlIllIIlIl.shapes.get(lllllllllllllllllllIllIlIllIIlII);
        lllllllllllllllllllIllIlIllIIlIl.next = (Shape)lllllllllllllllllllIllIlIllIIlIl.shapes.get(lllllllllllllllllllIllIlIllIIIll);
        lllllllllllllllllllIllIlIllIIlIl.offset = lllllllllllllllllllIllIlIlIlllII;
        lllllllllllllllllllIllIlIllIIlIl.pointsDirty = true;
    }

    public void setExternalFrame(Shape lllllllllllllllllllIllIllIIIIllI) {
        MorphShape lllllllllllllllllllIllIllIIIIlII;
        lllllllllllllllllllIllIllIIIIlII.current = lllllllllllllllllllIllIllIIIIllI;
        lllllllllllllllllllIllIllIIIIlII.next = (Shape)lllllllllllllllllllIllIllIIIIlII.shapes.get(0);
        lllllllllllllllllllIllIllIIIIlII.offset = 0.0f;
    }

    @Override
    public Shape transform(Transform lllllllllllllllllllIllIlIIllllIl) {
        MorphShape lllllllllllllllllllIllIlIIlllIll;
        lllllllllllllllllllIllIlIIlllIll.createPoints();
        Polygon lllllllllllllllllllIllIlIIllllII = new Polygon(lllllllllllllllllllIllIlIIlllIll.points);
        return lllllllllllllllllllIllIlIIllllII;
    }

    public void addShape(Shape lllllllllllllllllllIllIlllIIIlIl) {
        MorphShape lllllllllllllllllllIllIlllIIIIll;
        if (lllllllllllllllllllIllIlllIIIlIl.points.length != lllllllllllllllllllIllIlllIIIIll.points.length) {
            throw new RuntimeException("Attempt to morph between two shapes with different vertex counts");
        }
        Shape lllllllllllllllllllIllIlllIIIlII = (Shape)lllllllllllllllllllIllIlllIIIIll.shapes.get(lllllllllllllllllllIllIlllIIIIll.shapes.size() - 1);
        if (lllllllllllllllllllIllIlllIIIIll.equalShapes(lllllllllllllllllllIllIlllIIIlII, lllllllllllllllllllIllIlllIIIlIl)) {
            lllllllllllllllllllIllIlllIIIIll.shapes.add(lllllllllllllllllllIllIlllIIIlII);
        } else {
            lllllllllllllllllllIllIlllIIIIll.shapes.add(lllllllllllllllllllIllIlllIIIlIl);
        }
        if (lllllllllllllllllllIllIlllIIIIll.shapes.size() == 2) {
            lllllllllllllllllllIllIlllIIIIll.next = (Shape)lllllllllllllllllllIllIlllIIIIll.shapes.get(1);
        }
    }
}

