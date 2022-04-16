/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

public class Line
extends Shape {
    private /* synthetic */ Vector2f end;
    private /* synthetic */ boolean outerEdge;
    private /* synthetic */ Vector2f vec;
    private /* synthetic */ Vector2f other;
    private /* synthetic */ boolean innerEdge;
    private /* synthetic */ Vector2f v2;
    private /* synthetic */ Vector2f closest;
    private /* synthetic */ Vector2f start;
    private /* synthetic */ Vector2f loc;
    private /* synthetic */ Vector2f v;
    private /* synthetic */ Vector2f proj;
    private /* synthetic */ float lenSquared;

    public Vector2f intersect(Line lllllllllllllllllIlIIlllIIIIlIIl, boolean lllllllllllllllllIlIIlllIIIIllII) {
        Line lllllllllllllllllIlIIlllIIIIlllI;
        Vector2f lllllllllllllllllIlIIlllIIIIlIll = new Vector2f();
        if (!lllllllllllllllllIlIIlllIIIIlllI.intersect(lllllllllllllllllIlIIlllIIIIlIIl, lllllllllllllllllIlIIlllIIIIllII, lllllllllllllllllIlIIlllIIIIlIll)) {
            return null;
        }
        return lllllllllllllllllIlIIlllIIIIlIll;
    }

    public Vector2f getStart() {
        Line lllllllllllllllllIlIIlllIlllllII;
        return lllllllllllllllllIlIIlllIlllllII.start;
    }

    public float distanceSquared(Vector2f lllllllllllllllllIlIIlllIIlIllII) {
        Line lllllllllllllllllIlIIlllIIlIllIl;
        lllllllllllllllllIlIIlllIIlIllIl.getClosestPoint(lllllllllllllllllIlIIlllIIlIllII, lllllllllllllllllIlIIlllIIlIllIl.closest);
        lllllllllllllllllIlIIlllIIlIllIl.closest.sub(lllllllllllllllllIlIIlllIIlIllII);
        float lllllllllllllllllIlIIlllIIlIlIll = lllllllllllllllllIlIIlllIIlIllIl.closest.lengthSquared();
        return lllllllllllllllllIlIIlllIIlIlIll;
    }

    public float distance(Vector2f lllllllllllllllllIlIIlllIIllIlll) {
        Line lllllllllllllllllIlIIlllIIlllIlI;
        return (float)Math.sqrt(lllllllllllllllllIlIIlllIIlllIlI.distanceSquared(lllllllllllllllllIlIIlllIIllIlll));
    }

    public boolean intersect(Line lllllllllllllllllIlIIllIllllIlll, boolean lllllllllllllllllIlIIllIllllIllI, Vector2f lllllllllllllllllIlIIllIlllIIlll) {
        Line lllllllllllllllllIlIIllIlllllIII;
        float lllllllllllllllllIlIIllIllllIlII = lllllllllllllllllIlIIllIlllllIII.end.getX() - lllllllllllllllllIlIIllIlllllIII.start.getX();
        float lllllllllllllllllIlIIllIllllIIll = lllllllllllllllllIlIIllIllllIlll.end.getX() - lllllllllllllllllIlIIllIllllIlll.start.getX();
        float lllllllllllllllllIlIIllIllllIIlI = lllllllllllllllllIlIIllIlllllIII.end.getY() - lllllllllllllllllIlIIllIlllllIII.start.getY();
        float lllllllllllllllllIlIIllIllllIIIl = lllllllllllllllllIlIIllIllllIlll.end.getY() - lllllllllllllllllIlIIllIllllIlll.start.getY();
        float lllllllllllllllllIlIIllIllllIIII = lllllllllllllllllIlIIllIllllIIIl * lllllllllllllllllIlIIllIllllIlII - lllllllllllllllllIlIIllIllllIIll * lllllllllllllllllIlIIllIllllIIlI;
        if (lllllllllllllllllIlIIllIllllIIII == 0.0f) {
            return false;
        }
        float lllllllllllllllllIlIIllIlllIllll = lllllllllllllllllIlIIllIllllIIll * (lllllllllllllllllIlIIllIlllllIII.start.getY() - lllllllllllllllllIlIIllIllllIlll.start.getY()) - lllllllllllllllllIlIIllIllllIIIl * (lllllllllllllllllIlIIllIlllllIII.start.getX() - lllllllllllllllllIlIIllIllllIlll.start.getX());
        lllllllllllllllllIlIIllIlllIllll /= lllllllllllllllllIlIIllIllllIIII;
        float lllllllllllllllllIlIIllIlllIlllI = lllllllllllllllllIlIIllIllllIlII * (lllllllllllllllllIlIIllIlllllIII.start.getY() - lllllllllllllllllIlIIllIllllIlll.start.getY()) - lllllllllllllllllIlIIllIllllIIlI * (lllllllllllllllllIlIIllIlllllIII.start.getX() - lllllllllllllllllIlIIllIllllIlll.start.getX());
        lllllllllllllllllIlIIllIlllIlllI /= lllllllllllllllllIlIIllIllllIIII;
        if (lllllllllllllllllIlIIllIllllIllI && (lllllllllllllllllIlIIllIlllIllll < 0.0f || lllllllllllllllllIlIIllIlllIllll > 1.0f || lllllllllllllllllIlIIllIlllIlllI < 0.0f || lllllllllllllllllIlIIllIlllIlllI > 1.0f)) {
            return false;
        }
        float lllllllllllllllllIlIIllIlllIllIl = lllllllllllllllllIlIIllIlllIllll;
        float lllllllllllllllllIlIIllIlllIllII = lllllllllllllllllIlIIllIlllllIII.start.getX() + lllllllllllllllllIlIIllIlllIllIl * (lllllllllllllllllIlIIllIlllllIII.end.getX() - lllllllllllllllllIlIIllIlllllIII.start.getX());
        float lllllllllllllllllIlIIllIlllIlIll = lllllllllllllllllIlIIllIlllllIII.start.getY() + lllllllllllllllllIlIIllIlllIllIl * (lllllllllllllllllIlIIllIlllllIII.end.getY() - lllllllllllllllllIlIIllIlllllIII.start.getY());
        lllllllllllllllllIlIIllIlllIIlll.set(lllllllllllllllllIlIIllIlllIllII, lllllllllllllllllIlIIllIlllIlIll);
        return true;
    }

    @Override
    public boolean intersects(Shape lllllllllllllllllIlIIllIllIIllII) {
        Line lllllllllllllllllIlIIllIllIIlIll;
        if (lllllllllllllllllIlIIllIllIIllII instanceof Circle) {
            return lllllllllllllllllIlIIllIllIIllII.intersects(lllllllllllllllllIlIIllIllIIlIll);
        }
        return super.intersects(lllllllllllllllllIlIIllIllIIllII);
    }

    public void set(Vector2f lllllllllllllllllIlIIlllIllIlIll, Vector2f lllllllllllllllllIlIIlllIllIlIlI) {
        Line lllllllllllllllllIlIIlllIllIllII;
        lllllllllllllllllIlIIlllIllIllII.pointsDirty = true;
        if (lllllllllllllllllIlIIlllIllIllII.start == null) {
            lllllllllllllllllIlIIlllIllIllII.start = new Vector2f();
        }
        lllllllllllllllllIlIIlllIllIllII.start.set(lllllllllllllllllIlIIlllIllIlIll);
        if (lllllllllllllllllIlIIlllIllIllII.end == null) {
            lllllllllllllllllIlIIlllIllIllII.end = new Vector2f();
        }
        lllllllllllllllllIlIIlllIllIllII.end.set(lllllllllllllllllIlIIlllIllIlIlI);
        lllllllllllllllllIlIIlllIllIllII.vec = new Vector2f(lllllllllllllllllIlIIlllIllIlIlI);
        lllllllllllllllllIlIIlllIllIllII.vec.sub(lllllllllllllllllIlIIlllIllIlIll);
        lllllllllllllllllIlIIlllIllIllII.lenSquared = lllllllllllllllllIlIIlllIllIllII.vec.lengthSquared();
    }

    public String toString() {
        Line lllllllllllllllllIlIIlllIIIllIlI;
        return String.valueOf(new StringBuilder().append("[Line ").append(lllllllllllllllllIlIIlllIIIllIlI.start).append(",").append(lllllllllllllllllIlIIlllIIIllIlI.end).append("]"));
    }

    public boolean on(Vector2f lllllllllllllllllIlIIlllIIllIIIl) {
        Line lllllllllllllllllIlIIlllIIllIIlI;
        lllllllllllllllllIlIIlllIIllIIlI.getClosestPoint(lllllllllllllllllIlIIlllIIllIIIl, lllllllllllllllllIlIIlllIIllIIlI.closest);
        return lllllllllllllllllIlIIlllIIllIIIl.equals(lllllllllllllllllIlIIlllIIllIIlI.closest);
    }

    public Line(float lllllllllllllllllIlIIllllIllllIl, float lllllllllllllllllIlIIllllIlllIIl) {
        lllllllllllllllllIlIIllllIlllllI(lllllllllllllllllIlIIllllIllllIl, lllllllllllllllllIlIIllllIlllIIl, true, true);
        Line lllllllllllllllllIlIIllllIlllllI;
    }

    public Line(float[] lllllllllllllllllIlIIllllIIlIlIl, float[] lllllllllllllllllIlIIllllIIlIlII) {
        Line lllllllllllllllllIlIIllllIIlIIll;
        lllllllllllllllllIlIIllllIIlIIll.loc = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIlIIll.v = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIlIIll.v2 = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIlIIll.proj = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIlIIll.closest = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIlIIll.other = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIlIIll.outerEdge = true;
        lllllllllllllllllIlIIllllIIlIIll.innerEdge = true;
        lllllllllllllllllIlIIllllIIlIIll.set(lllllllllllllllllIlIIllllIIlIlIl, lllllllllllllllllIlIIllllIIlIlII);
    }

    public Line(float lllllllllllllllllIlIIlllllIIlIII, float lllllllllllllllllIlIIlllllIIIIlI, boolean lllllllllllllllllIlIIlllllIIIllI, boolean lllllllllllllllllIlIIlllllIIIlIl) {
        lllllllllllllllllIlIIlllllIIlIIl(0.0f, 0.0f, lllllllllllllllllIlIIlllllIIlIII, lllllllllllllllllIlIIlllllIIIIlI);
        Line lllllllllllllllllIlIIlllllIIlIIl;
    }

    public float length() {
        Line lllllllllllllllllIlIIlllIlllIlll;
        return lllllllllllllllllIlIIlllIlllIlll.vec.length();
    }

    public Line(Vector2f lllllllllllllllllIlIIllllIIIlIIl, Vector2f lllllllllllllllllIlIIllllIIIlIII) {
        Line lllllllllllllllllIlIIllllIIIllIl;
        lllllllllllllllllIlIIllllIIIllIl.loc = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIIllIl.v = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIIllIl.v2 = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIIllIl.proj = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIIllIl.closest = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIIllIl.other = new Vector2f(0.0f, 0.0f);
        lllllllllllllllllIlIIllllIIIllIl.outerEdge = true;
        lllllllllllllllllIlIIllllIIIllIl.innerEdge = true;
        lllllllllllllllllIlIIllllIIIllIl.set(lllllllllllllllllIlIIllllIIIlIIl, lllllllllllllllllIlIIllllIIIlIII);
    }

    public float getX1() {
        Line lllllllllllllllllIlIIlllIlIIIllI;
        return lllllllllllllllllIlIIlllIlIIIllI.start.getX();
    }

    @Override
    protected void createPoints() {
        Line lllllllllllllllllIlIIllIllIllIll;
        lllllllllllllllllIlIIllIllIllIll.points = new float[4];
        lllllllllllllllllIlIIllIllIllIll.points[0] = lllllllllllllllllIlIIllIllIllIll.getX1();
        lllllllllllllllllIlIIllIllIllIll.points[1] = lllllllllllllllllIlIIllIllIllIll.getY1();
        lllllllllllllllllIlIIllIllIllIll.points[2] = lllllllllllllllllIlIIllIllIllIll.getX2();
        lllllllllllllllllIlIIllIllIllIll.points[3] = lllllllllllllllllIlIIllIllIllIll.getY2();
    }

    public float getX2() {
        Line lllllllllllllllllIlIIlllIlIIIIII;
        return lllllllllllllllllIlIIlllIlIIIIII.end.getX();
    }

    public float getDY() {
        Line lllllllllllllllllIlIIlllIlIIllll;
        return lllllllllllllllllIlIIlllIlIIllll.end.getY() - lllllllllllllllllIlIIlllIlIIllll.start.getY();
    }

    @Override
    public Shape transform(Transform lllllllllllllllllIlIIllIllIlIIlI) {
        Line lllllllllllllllllIlIIllIllIlIllI;
        float[] lllllllllllllllllIlIIllIllIlIlII = new float[4];
        lllllllllllllllllIlIIllIllIlIllI.createPoints();
        lllllllllllllllllIlIIllIllIlIIlI.transform(lllllllllllllllllIlIIllIllIlIllI.points, 0, lllllllllllllllllIlIIllIllIlIlII, 0, 2);
        return new Line(lllllllllllllllllIlIIllIllIlIlII[0], lllllllllllllllllIlIIllIllIlIlII[1], lllllllllllllllllIlIIllIllIlIlII[2], lllllllllllllllllIlIIllIllIlIlII[3]);
    }

    public void set(float lllllllllllllllllIlIIlllIllIIIIl, float lllllllllllllllllIlIIlllIlIllIIl, float lllllllllllllllllIlIIlllIlIlllll, float lllllllllllllllllIlIIlllIlIllllI) {
        Line lllllllllllllllllIlIIlllIllIIIlI;
        lllllllllllllllllIlIIlllIllIIIlI.pointsDirty = true;
        lllllllllllllllllIlIIlllIllIIIlI.start.set(lllllllllllllllllIlIIlllIllIIIIl, lllllllllllllllllIlIIlllIlIllIIl);
        lllllllllllllllllIlIIlllIllIIIlI.end.set(lllllllllllllllllIlIIlllIlIlllll, lllllllllllllllllIlIIlllIlIllllI);
        float lllllllllllllllllIlIIlllIlIlllIl = lllllllllllllllllIlIIlllIlIlllll - lllllllllllllllllIlIIlllIllIIIIl;
        float lllllllllllllllllIlIIlllIlIlllII = lllllllllllllllllIlIIlllIlIllllI - lllllllllllllllllIlIIlllIlIllIIl;
        lllllllllllllllllIlIIlllIllIIIlI.vec.set(lllllllllllllllllIlIIlllIlIlllIl, lllllllllllllllllIlIIlllIlIlllII);
        lllllllllllllllllIlIIlllIllIIIlI.lenSquared = lllllllllllllllllIlIIlllIlIlllIl * lllllllllllllllllIlIIlllIlIlllIl + lllllllllllllllllIlIIlllIlIlllII * lllllllllllllllllIlIIlllIlIlllII;
    }

    public Vector2f intersect(Line lllllllllllllllllIlIIlllIIIlIIll) {
        Line lllllllllllllllllIlIIlllIIIlIllI;
        return lllllllllllllllllIlIIlllIIIlIllI.intersect(lllllllllllllllllIlIIlllIIIlIIll, false);
    }

    public float getY1() {
        Line lllllllllllllllllIlIIlllIlIIIIll;
        return lllllllllllllllllIlIIlllIlIIIIll.start.getY();
    }

    @Override
    public boolean closed() {
        return false;
    }

    public Line(float lllllllllllllllllIlIIllllIlIllIl, float lllllllllllllllllIlIIllllIlIllII, float lllllllllllllllllIlIIllllIllIIII, float lllllllllllllllllIlIIllllIlIlIlI) {
        lllllllllllllllllIlIIllllIlIlllI(new Vector2f(lllllllllllllllllIlIIllllIlIllIl, lllllllllllllllllIlIIllllIlIllII), new Vector2f(lllllllllllllllllIlIIllllIllIIII, lllllllllllllllllIlIIllllIlIlIlI));
        Line lllllllllllllllllIlIIllllIlIlllI;
    }

    public float lengthSquared() {
        Line lllllllllllllllllIlIIlllIlllIIll;
        return lllllllllllllllllIlIIlllIlllIIll.vec.lengthSquared();
    }

    public float getDX() {
        Line lllllllllllllllllIlIIlllIlIlIIlI;
        return lllllllllllllllllIlIIlllIlIlIIlI.end.getX() - lllllllllllllllllIlIIlllIlIlIIlI.start.getX();
    }

    public Vector2f getEnd() {
        Line lllllllllllllllllIlIIlllIllllIlI;
        return lllllllllllllllllIlIIlllIllllIlI.end;
    }

    public Line(float lllllllllllllllllIlIIllllIlIIIll, float lllllllllllllllllIlIIllllIIlllII, float lllllllllllllllllIlIIllllIIllIll, float lllllllllllllllllIlIIllllIlIIIII, boolean lllllllllllllllllIlIIllllIIlllll) {
        lllllllllllllllllIlIIllllIlIIlII(new Vector2f(lllllllllllllllllIlIIllllIlIIIll, lllllllllllllllllIlIIllllIIlllII), new Vector2f(lllllllllllllllllIlIIllllIlIIIll + lllllllllllllllllIlIIllllIIllIll, lllllllllllllllllIlIIllllIIlllII + lllllllllllllllllIlIIllllIlIIIII));
        Line lllllllllllllllllIlIIllllIlIIlII;
    }

    @Override
    public float getX() {
        Line lllllllllllllllllIlIIlllIlIIllII;
        return lllllllllllllllllIlIIlllIlIIllII.getX1();
    }

    public void getClosestPoint(Vector2f lllllllllllllllllIlIIlllIIIllllI, Vector2f lllllllllllllllllIlIIlllIIIlllIl) {
        Line lllllllllllllllllIlIIlllIIlIIIll;
        lllllllllllllllllIlIIlllIIlIIIll.loc.set(lllllllllllllllllIlIIlllIIIllllI);
        lllllllllllllllllIlIIlllIIlIIIll.loc.sub(lllllllllllllllllIlIIlllIIlIIIll.start);
        float lllllllllllllllllIlIIlllIIlIIIII = lllllllllllllllllIlIIlllIIlIIIll.vec.dot(lllllllllllllllllIlIIlllIIlIIIll.loc);
        lllllllllllllllllIlIIlllIIlIIIII /= lllllllllllllllllIlIIlllIIlIIIll.vec.lengthSquared();
        if (lllllllllllllllllIlIIlllIIlIIIII < 0.0f) {
            lllllllllllllllllIlIIlllIIIlllIl.set(lllllllllllllllllIlIIlllIIlIIIll.start);
            return;
        }
        if (lllllllllllllllllIlIIlllIIlIIIII > 1.0f) {
            lllllllllllllllllIlIIlllIIIlllIl.set(lllllllllllllllllIlIIlllIIlIIIll.end);
            return;
        }
        lllllllllllllllllIlIIlllIIIlllIl.x = lllllllllllllllllIlIIlllIIlIIIll.start.getX() + lllllllllllllllllIlIIlllIIlIIIII * lllllllllllllllllIlIIlllIIlIIIll.vec.getX();
        lllllllllllllllllIlIIlllIIIlllIl.y = lllllllllllllllllIlIIlllIIlIIIll.start.getY() + lllllllllllllllllIlIIlllIIlIIIII * lllllllllllllllllIlIIlllIIlIIIll.vec.getY();
    }

    public void set(float[] lllllllllllllllllIlIIllllIIIIIll, float[] lllllllllllllllllIlIIlllIlllllll) {
        Line lllllllllllllllllIlIIllllIIIIlII;
        lllllllllllllllllIlIIllllIIIIlII.set(lllllllllllllllllIlIIllllIIIIIll[0], lllllllllllllllllIlIIllllIIIIIll[1], lllllllllllllllllIlIIlllIlllllll[0], lllllllllllllllllIlIIlllIlllllll[1]);
    }

    @Override
    public float getY() {
        Line lllllllllllllllllIlIIlllIlIIlIIl;
        return lllllllllllllllllIlIIlllIlIIlIIl.getY1();
    }

    public float getY2() {
        Line lllllllllllllllllIlIIlllIIlllllI;
        return lllllllllllllllllIlIIlllIIlllllI.end.getY();
    }
}

