/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

public class Rectangle
extends Shape {
    protected /* synthetic */ float width;
    protected /* synthetic */ float height;

    public Rectangle(float llllllllllllllllIIIlIIIlIIIlIlIl, float llllllllllllllllIIIlIIIlIIIlIlII, float llllllllllllllllIIIlIIIlIIIllIII, float llllllllllllllllIIIlIIIlIIIlIIlI) {
        Rectangle llllllllllllllllIIIlIIIlIIIlIllI;
        llllllllllllllllIIIlIIIlIIIlIllI.x = llllllllllllllllIIIlIIIlIIIlIlIl;
        llllllllllllllllIIIlIIIlIIIlIllI.y = llllllllllllllllIIIlIIIlIIIlIlII;
        llllllllllllllllIIIlIIIlIIIlIllI.width = llllllllllllllllIIIlIIIlIIIllIII;
        llllllllllllllllIIIlIIIlIIIlIllI.height = llllllllllllllllIIIlIIIlIIIlIIlI;
        llllllllllllllllIIIlIIIlIIIlIllI.maxX = llllllllllllllllIIIlIIIlIIIlIlIl + llllllllllllllllIIIlIIIlIIIllIII;
        llllllllllllllllIIIlIIIlIIIlIllI.maxY = llllllllllllllllIIIlIIIlIIIlIlII + llllllllllllllllIIIlIIIlIIIlIIlI;
        llllllllllllllllIIIlIIIlIIIlIllI.checkPoints();
    }

    @Override
    public float getWidth() {
        Rectangle llllllllllllllllIIIlIIIIlllIlIIl;
        return llllllllllllllllIIIlIIIIlllIlIIl.width;
    }

    public void setBounds(float llllllllllllllllIIIlIIIIllllIlll, float llllllllllllllllIIIlIIIIllllIllI, float llllllllllllllllIIIlIIIIlllllIlI, float llllllllllllllllIIIlIIIIllllIlII) {
        Rectangle llllllllllllllllIIIlIIIIlllllIII;
        llllllllllllllllIIIlIIIIlllllIII.setX(llllllllllllllllIIIlIIIIllllIlll);
        llllllllllllllllIIIlIIIIlllllIII.setY(llllllllllllllllIIIlIIIIllllIllI);
        llllllllllllllllIIIlIIIIlllllIII.setSize(llllllllllllllllIIIlIIIIlllllIlI, llllllllllllllllIIIlIIIIllllIlII);
    }

    public void scaleGrow(float llllllllllllllllIIIlIIIIllIlIlII, float llllllllllllllllIIIlIIIIllIlIIll) {
        Rectangle llllllllllllllllIIIlIIIIllIllIII;
        llllllllllllllllIIIlIIIIllIllIII.grow(llllllllllllllllIIIlIIIIllIllIII.getWidth() * (llllllllllllllllIIIlIIIIllIlIlII - 1.0f), llllllllllllllllIIIlIIIIllIllIII.getHeight() * (llllllllllllllllIIIlIIIIllIlIIll - 1.0f));
    }

    @Override
    protected void createPoints() {
        Rectangle llllllllllllllllIIIlIIIIlIlllIlI;
        float llllllllllllllllIIIlIIIIlIlllIIl = llllllllllllllllIIIlIIIIlIlllIlI.width;
        float llllllllllllllllIIIlIIIIlIlllIII = llllllllllllllllIIIlIIIIlIlllIlI.height;
        llllllllllllllllIIIlIIIIlIlllIlI.points = new float[8];
        llllllllllllllllIIIlIIIIlIlllIlI.points[0] = llllllllllllllllIIIlIIIIlIlllIlI.x;
        llllllllllllllllIIIlIIIIlIlllIlI.points[1] = llllllllllllllllIIIlIIIIlIlllIlI.y;
        llllllllllllllllIIIlIIIIlIlllIlI.points[2] = llllllllllllllllIIIlIIIIlIlllIlI.x + llllllllllllllllIIIlIIIIlIlllIIl;
        llllllllllllllllIIIlIIIIlIlllIlI.points[3] = llllllllllllllllIIIlIIIIlIlllIlI.y;
        llllllllllllllllIIIlIIIIlIlllIlI.points[4] = llllllllllllllllIIIlIIIIlIlllIlI.x + llllllllllllllllIIIlIIIIlIlllIIl;
        llllllllllllllllIIIlIIIIlIlllIlI.points[5] = llllllllllllllllIIIlIIIIlIlllIlI.y + llllllllllllllllIIIlIIIIlIlllIII;
        llllllllllllllllIIIlIIIIlIlllIlI.points[6] = llllllllllllllllIIIlIIIIlIlllIlI.x;
        llllllllllllllllIIIlIIIIlIlllIlI.points[7] = llllllllllllllllIIIlIIIIlIlllIlI.y + llllllllllllllllIIIlIIIIlIlllIII;
        llllllllllllllllIIIlIIIIlIlllIlI.maxX = llllllllllllllllIIIlIIIIlIlllIlI.points[2];
        llllllllllllllllIIIlIIIIlIlllIlI.maxY = llllllllllllllllIIIlIIIIlIlllIlI.points[5];
        llllllllllllllllIIIlIIIIlIlllIlI.minX = llllllllllllllllIIIlIIIIlIlllIlI.points[0];
        llllllllllllllllIIIlIIIIlIlllIlI.minY = llllllllllllllllIIIlIIIIlIlllIlI.points[1];
        llllllllllllllllIIIlIIIIlIlllIlI.findCenter();
        llllllllllllllllIIIlIIIIlIlllIlI.calculateRadius();
    }

    public static boolean contains(float llllllllllllllllIIIlIIIIlIlIIlIl, float llllllllllllllllIIIlIIIIlIlIIlII, float llllllllllllllllIIIlIIIIlIIlllIl, float llllllllllllllllIIIlIIIIlIIlllII, float llllllllllllllllIIIlIIIIlIIllIll, float llllllllllllllllIIIlIIIIlIIllIlI) {
        return llllllllllllllllIIIlIIIIlIlIIlIl >= llllllllllllllllIIIlIIIIlIIlllIl && llllllllllllllllIIIlIIIIlIlIIlII >= llllllllllllllllIIIlIIIIlIIlllII && llllllllllllllllIIIlIIIIlIlIIlIl <= llllllllllllllllIIIlIIIIlIIlllIl + llllllllllllllllIIIlIIIIlIIllIll && llllllllllllllllIIIlIIIIlIlIIlII <= llllllllllllllllIIIlIIIIlIIlllII + llllllllllllllllIIIlIIIIlIIllIlI;
    }

    public void setSize(float llllllllllllllllIIIlIIIIlllIllII, float llllllllllllllllIIIlIIIIlllIlllI) {
        Rectangle llllllllllllllllIIIlIIIIlllIllIl;
        llllllllllllllllIIIlIIIIlllIllIl.setWidth(llllllllllllllllIIIlIIIIlllIllII);
        llllllllllllllllIIIlIIIIlllIllIl.setHeight(llllllllllllllllIIIlIIIIlllIlllI);
    }

    @Override
    public Shape transform(Transform llllllllllllllllIIIlIIIIlIIlIIII) {
        Rectangle llllllllllllllllIIIlIIIIlIIlIIIl;
        llllllllllllllllIIIlIIIIlIIlIIIl.checkPoints();
        Polygon llllllllllllllllIIIlIIIIlIIlIIll = new Polygon();
        float[] llllllllllllllllIIIlIIIIlIIlIIlI = new float[llllllllllllllllIIIlIIIIlIIlIIIl.points.length];
        llllllllllllllllIIIlIIIIlIIlIIII.transform(llllllllllllllllIIIlIIIIlIIlIIIl.points, 0, llllllllllllllllIIIlIIIIlIIlIIlI, 0, llllllllllllllllIIIlIIIIlIIlIIIl.points.length / 2);
        llllllllllllllllIIIlIIIIlIIlIIll.points = llllllllllllllllIIIlIIIIlIIlIIlI;
        llllllllllllllllIIIlIIIIlIIlIIll.findCenter();
        llllllllllllllllIIIlIIIIlIIlIIll.checkPoints();
        return llllllllllllllllIIIlIIIIlIIlIIll;
    }

    @Override
    public boolean intersects(Shape llllllllllllllllIIIlIIIIllIIIIIl) {
        Rectangle llllllllllllllllIIIlIIIIllIIIIII;
        if (llllllllllllllllIIIlIIIIllIIIIIl instanceof Rectangle) {
            Rectangle llllllllllllllllIIIlIIIIllIIIIll = (Rectangle)llllllllllllllllIIIlIIIIllIIIIIl;
            if (llllllllllllllllIIIlIIIIllIIIIII.x > llllllllllllllllIIIlIIIIllIIIIll.x + llllllllllllllllIIIlIIIIllIIIIll.width || llllllllllllllllIIIlIIIIllIIIIII.x + llllllllllllllllIIIlIIIIllIIIIII.width < llllllllllllllllIIIlIIIIllIIIIll.x) {
                return false;
            }
            return !(llllllllllllllllIIIlIIIIllIIIIII.y > llllllllllllllllIIIlIIIIllIIIIll.y + llllllllllllllllIIIlIIIIllIIIIll.height) && !(llllllllllllllllIIIlIIIIllIIIIII.y + llllllllllllllllIIIlIIIIllIIIIII.height < llllllllllllllllIIIlIIIIllIIIIll.y);
        }
        if (llllllllllllllllIIIlIIIIllIIIIIl instanceof Circle) {
            return llllllllllllllllIIIlIIIIllIIIIII.intersects((Circle)llllllllllllllllIIIlIIIIllIIIIIl);
        }
        return super.intersects(llllllllllllllllIIIlIIIIllIIIIIl);
    }

    private boolean intersects(Circle llllllllllllllllIIIlIIIIlIllIIIl) {
        Rectangle llllllllllllllllIIIlIIIIlIllIIII;
        return llllllllllllllllIIIlIIIIlIllIIIl.intersects((Shape)llllllllllllllllIIIlIIIIlIllIIII);
    }

    public void setBounds(Rectangle llllllllllllllllIIIlIIIlIIIIIIll) {
        Rectangle llllllllllllllllIIIlIIIlIIIIIllI;
        llllllllllllllllIIIlIIIlIIIIIllI.setBounds(llllllllllllllllIIIlIIIlIIIIIIll.getX(), llllllllllllllllIIIlIIIlIIIIIIll.getY(), llllllllllllllllIIIlIIIlIIIIIIll.getWidth(), llllllllllllllllIIIlIIIlIIIIIIll.getHeight());
    }

    @Override
    public float getHeight() {
        Rectangle llllllllllllllllIIIlIIIIlllIIlIl;
        return llllllllllllllllIIIlIIIIlllIIlIl.height;
    }

    @Override
    public boolean contains(float llllllllllllllllIIIlIIIlIIIIllIl, float llllllllllllllllIIIlIIIlIIIIllII) {
        Rectangle llllllllllllllllIIIlIIIlIIIIlllI;
        llllllllllllllllIIIlIIIlIIIIlllI.checkPoints();
        if (llllllllllllllllIIIlIIIlIIIIllIl <= llllllllllllllllIIIlIIIlIIIIlllI.getX()) {
            return false;
        }
        if (llllllllllllllllIIIlIIIlIIIIllII <= llllllllllllllllIIIlIIIlIIIIlllI.getY()) {
            return false;
        }
        if (llllllllllllllllIIIlIIIlIIIIllIl >= llllllllllllllllIIIlIIIlIIIIlllI.maxX) {
            return false;
        }
        return !(llllllllllllllllIIIlIIIlIIIIllII >= llllllllllllllllIIIlIIIlIIIIlllI.maxY);
    }

    public void setHeight(float llllllllllllllllIIIlIIIIllIIIlll) {
        Rectangle llllllllllllllllIIIlIIIIllIIlIII;
        if (llllllllllllllllIIIlIIIIllIIIlll != llllllllllllllllIIIlIIIIllIIlIII.height) {
            llllllllllllllllIIIlIIIIllIIlIII.pointsDirty = true;
            llllllllllllllllIIIlIIIIllIIlIII.height = llllllllllllllllIIIlIIIIllIIIlll;
            llllllllllllllllIIIlIIIIllIIlIII.maxY = llllllllllllllllIIIlIIIIllIIlIII.y + llllllllllllllllIIIlIIIIllIIIlll;
        }
    }

    public void grow(float llllllllllllllllIIIlIIIIlllIIIII, float llllllllllllllllIIIlIIIIllIlllll) {
        Rectangle llllllllllllllllIIIlIIIIlllIIIIl;
        llllllllllllllllIIIlIIIIlllIIIIl.setX(llllllllllllllllIIIlIIIIlllIIIIl.getX() - llllllllllllllllIIIlIIIIlllIIIII);
        llllllllllllllllIIIlIIIIlllIIIIl.setY(llllllllllllllllIIIlIIIIlllIIIIl.getY() - llllllllllllllllIIIlIIIIllIlllll);
        llllllllllllllllIIIlIIIIlllIIIIl.setWidth(llllllllllllllllIIIlIIIIlllIIIIl.getWidth() + llllllllllllllllIIIlIIIIlllIIIII * 2.0f);
        llllllllllllllllIIIlIIIIlllIIIIl.setHeight(llllllllllllllllIIIlIIIIlllIIIIl.getHeight() + llllllllllllllllIIIlIIIIllIlllll * 2.0f);
    }

    public String toString() {
        Rectangle llllllllllllllllIIIlIIIIlIlIllIl;
        return String.valueOf(new StringBuilder().append("[Rectangle ").append(llllllllllllllllIIIlIIIIlIlIllIl.width).append("x").append(llllllllllllllllIIIlIIIIlIlIllIl.height).append("]"));
    }

    public void setWidth(float llllllllllllllllIIIlIIIIllIIllll) {
        Rectangle llllllllllllllllIIIlIIIIllIlIIII;
        if (llllllllllllllllIIIlIIIIllIIllll != llllllllllllllllIIIlIIIIllIlIIII.width) {
            llllllllllllllllIIIlIIIIllIlIIII.pointsDirty = true;
            llllllllllllllllIIIlIIIIllIlIIII.width = llllllllllllllllIIIlIIIIllIIllll;
            llllllllllllllllIIIlIIIIllIlIIII.maxX = llllllllllllllllIIIlIIIIllIlIIII.x + llllllllllllllllIIIlIIIIllIIllll;
        }
    }
}

