/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public strictfp class Circle
extends Ellipse {
    public /* synthetic */ float radius;

    @Override
    public float getCenterX() {
        Circle lIlllllIIIIlll;
        return lIlllllIIIIlll.getX() + lIlllllIIIIlll.radius;
    }

    private boolean intersects(Line lIllllIIIIlIIl) {
        Vector2f lIllllIIIlIIII;
        Circle lIllllIIIIlIlI;
        Vector2f lIllllIIIlIIll = new Vector2f(lIllllIIIIlIIl.getX1(), lIllllIIIIlIIl.getY1());
        Vector2f lIllllIIIlIIlI = new Vector2f(lIllllIIIIlIIl.getX2(), lIllllIIIIlIIl.getY2());
        Vector2f lIllllIIIlIIIl = new Vector2f(lIllllIIIIlIlI.getCenterX(), lIllllIIIIlIlI.getCenterY());
        Vector2f lIllllIIIIllll = lIllllIIIlIIlI.copy().sub(lIllllIIIlIIll);
        Vector2f lIllllIIIIlllI = lIllllIIIlIIIl.copy().sub(lIllllIIIlIIll);
        float lIllllIIIIllIl = lIllllIIIIllll.length();
        float lIllllIIIIllII = lIllllIIIIlllI.dot(lIllllIIIIllll) / lIllllIIIIllIl;
        if (lIllllIIIIllII < 0.0f) {
            Vector2f lIllllIIIllIII = lIllllIIIlIIll;
        } else if (lIllllIIIIllII > lIllllIIIIllIl) {
            Vector2f lIllllIIIlIlll = lIllllIIIlIIlI;
        } else {
            Vector2f lIllllIIIlIllI = lIllllIIIIllll.copy().scale(lIllllIIIIllII / lIllllIIIIllIl);
            lIllllIIIlIIII = lIllllIIIlIIll.copy().add(lIllllIIIlIllI);
        }
        boolean lIllllIIIIlIll = lIllllIIIlIIIl.copy().sub(lIllllIIIlIIII).lengthSquared() <= lIllllIIIIlIlI.getRadius() * lIllllIIIIlIlI.getRadius();
        return lIllllIIIIlIll;
    }

    @Override
    public float[] getCenter() {
        Circle lIlllllIIIIIIl;
        return new float[]{lIlllllIIIIIIl.getCenterX(), lIlllllIIIIIIl.getCenterY()};
    }

    @Override
    protected void calculateRadius() {
        Circle lIllllIlIIllII;
        lIllllIlIIllII.boundingCircleRadius = lIllllIlIIllII.radius;
    }

    @Override
    protected void findCenter() {
        Circle lIllllIlIIlllI;
        lIllllIlIIlllI.center = new float[2];
        lIllllIlIIlllI.center[0] = lIllllIlIIlllI.x + lIllllIlIIlllI.radius;
        lIllllIlIIlllI.center[1] = lIllllIlIIlllI.y + lIllllIlIIlllI.radius;
    }

    @Override
    public boolean intersects(Shape lIllllIllIlIlI) {
        Circle lIllllIllIlIll;
        if (lIllllIllIlIlI instanceof Circle) {
            float lIllllIllIlllI;
            Circle lIllllIlllIIIl = (Circle)lIllllIllIlIlI;
            float lIllllIlllIIII = lIllllIllIlIll.getRadius() + lIllllIlllIIIl.getRadius();
            if (Math.abs(lIllllIlllIIIl.getCenterX() - lIllllIllIlIll.getCenterX()) > lIllllIlllIIII) {
                return false;
            }
            if (Math.abs(lIllllIlllIIIl.getCenterY() - lIllllIllIlIll.getCenterY()) > lIllllIlllIIII) {
                return false;
            }
            float lIllllIllIllll = Math.abs(lIllllIlllIIIl.getCenterX() - lIllllIllIlIll.getCenterX());
            return (lIllllIlllIIII *= lIllllIlllIIII) >= lIllllIllIllll * lIllllIllIllll + (lIllllIllIlllI = Math.abs(lIllllIlllIIIl.getCenterY() - lIllllIllIlIll.getCenterY())) * lIllllIllIlllI;
        }
        if (lIllllIllIlIlI instanceof Rectangle) {
            return lIllllIllIlIll.intersects((Rectangle)lIllllIllIlIlI);
        }
        return super.intersects(lIllllIllIlIlI);
    }

    @Override
    public float getCenterY() {
        Circle lIlllllIIIIlIl;
        return lIlllllIIIIlIl.getY() + lIlllllIIIIlIl.radius;
    }

    public void setRadius(float lIllllIlllllIl) {
        Circle lIllllIlllllII;
        if (lIllllIlllllIl != lIllllIlllllII.radius) {
            lIllllIlllllII.pointsDirty = true;
            lIllllIlllllII.radius = lIllllIlllllIl;
            lIllllIlllllII.setRadii(lIllllIlllllIl, lIllllIlllllIl);
        }
    }

    public float getRadius() {
        Circle lIllllIllllIIl;
        return lIllllIllllIIl.radius;
    }

    public Circle(float lIlllllIIllIll, float lIlllllIIllIlI, float lIlllllIIllIIl) {
        lIlllllIIlllII(lIlllllIIllIll, lIlllllIIllIlI, lIlllllIIllIIl, 50);
        Circle lIlllllIIlllII;
    }

    public Circle(float lIlllllIIIllIl, float lIlllllIIIllII, float lIlllllIIIlIll, int lIlllllIIIllll) {
        super(lIlllllIIIllIl, lIlllllIIIllII, lIlllllIIIlIll, lIlllllIIIlIll, lIlllllIIIllll);
        Circle lIlllllIIlIIll;
        lIlllllIIlIIll.x = lIlllllIIIllIl - lIlllllIIIlIll;
        lIlllllIIlIIll.y = lIlllllIIIllII - lIlllllIIIlIll;
        lIlllllIIlIIll.radius = lIlllllIIIlIll;
        lIlllllIIlIIll.boundingCircleRadius = lIlllllIIIlIll;
    }

    @Override
    public boolean contains(float lIllllIlIlllll, float lIllllIlIllIIl) {
        float lIllllIlIlllII;
        Circle lIllllIllIIIII;
        float lIllllIlIlllIl = lIllllIlIlllll - lIllllIllIIIII.getCenterX();
        return lIllllIlIlllIl * lIllllIlIlllIl + (lIllllIlIlllII = lIllllIlIllIIl - lIllllIllIIIII.getCenterY()) * lIllllIlIlllII < lIllllIllIIIII.getRadius() * lIllllIllIIIII.getRadius();
    }

    private boolean intersects(Rectangle lIllllIIlIllll) {
        Circle lIllllIIllIIII;
        Rectangle lIllllIIlllIIl = lIllllIIlIllll;
        Circle lIllllIIlllIII = lIllllIIllIIII;
        if (lIllllIIlllIIl.contains(lIllllIIllIIII.x + lIllllIIllIIII.radius, lIllllIIllIIII.y + lIllllIIllIIII.radius)) {
            return true;
        }
        float lIllllIIllIlll = lIllllIIlllIIl.getX();
        float lIllllIIllIllI = lIllllIIlllIIl.getY();
        float lIllllIIllIlIl = lIllllIIlllIIl.getX() + lIllllIIlllIIl.getWidth();
        float lIllllIIllIlII = lIllllIIlllIIl.getY() + lIllllIIlllIIl.getHeight();
        Line[] lIllllIIllIIll = new Line[]{new Line(lIllllIIllIlll, lIllllIIllIllI, lIllllIIllIlIl, lIllllIIllIllI), new Line(lIllllIIllIlIl, lIllllIIllIllI, lIllllIIllIlIl, lIllllIIllIlII), new Line(lIllllIIllIlIl, lIllllIIllIlII, lIllllIIllIlll, lIllllIIllIlII), new Line(lIllllIIllIlll, lIllllIIllIlII, lIllllIIllIlll, lIllllIIllIllI)};
        float lIllllIIllIIlI = lIllllIIlllIII.getRadius() * lIllllIIlllIII.getRadius();
        Vector2f lIllllIIllIIIl = new Vector2f(lIllllIIlllIII.getCenterX(), lIllllIIlllIII.getCenterY());
        for (int lIllllIIllllII = 0; lIllllIIllllII < 4; ++lIllllIIllllII) {
            float lIllllIIllllIl = lIllllIIllIIll[lIllllIIllllII].distanceSquared(lIllllIIllIIIl);
            if (!(lIllllIIllllIl < lIllllIIllIIlI)) continue;
            return true;
        }
        return false;
    }

    private boolean contains(Line lIllllIlIlIIIl) {
        Circle lIllllIlIlIIlI;
        return lIllllIlIlIIlI.contains(lIllllIlIlIIIl.getX1(), lIllllIlIlIIIl.getY1()) && lIllllIlIlIIlI.contains(lIllllIlIlIIIl.getX2(), lIllllIlIlIIIl.getY2());
    }
}

