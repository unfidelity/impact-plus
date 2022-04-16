/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class Point
extends Shape {
    @Override
    protected void findCenter() {
        Point llllIIIIlIIlll;
        llllIIIIlIIlll.center = new float[2];
        llllIIIIlIIlll.center[0] = llllIIIIlIIlll.points[0];
        llllIIIIlIIlll.center[1] = llllIIIIlIIlll.points[1];
    }

    @Override
    protected void createPoints() {
        Point llllIIIIlIlIIl;
        llllIIIIlIlIIl.points = new float[2];
        llllIIIIlIlIIl.points[0] = llllIIIIlIlIIl.getX();
        llllIIIIlIlIIl.points[1] = llllIIIIlIlIIl.getY();
        llllIIIIlIlIIl.maxX = llllIIIIlIlIIl.x;
        llllIIIIlIlIIl.maxY = llllIIIIlIlIIl.y;
        llllIIIIlIlIIl.minX = llllIIIIlIlIIl.x;
        llllIIIIlIlIIl.minY = llllIIIIlIlIIl.y;
        llllIIIIlIlIIl.findCenter();
        llllIIIIlIlIIl.calculateRadius();
    }

    @Override
    protected void calculateRadius() {
        llllIIIIlIIIll.boundingCircleRadius = 0.0f;
    }

    @Override
    public Shape transform(Transform llllIIIIllIIII) {
        Point llllIIIIlIlllI;
        float[] llllIIIIlIllll = new float[llllIIIIlIlllI.points.length];
        llllIIIIllIIII.transform(llllIIIIlIlllI.points, 0, llllIIIIlIllll, 0, llllIIIIlIlllI.points.length / 2);
        return new Point(llllIIIIlIlllI.points[0], llllIIIIlIlllI.points[1]);
    }

    public Point(float llllIIIIlllIIl, float llllIIIIllIlIl) {
        Point llllIIIIllIlll;
        llllIIIIllIlll.x = llllIIIIlllIIl;
        llllIIIIllIlll.y = llllIIIIllIlIl;
        llllIIIIllIlll.checkPoints();
    }
}

