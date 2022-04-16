/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.io.Serializable;
import org.newdawn.slick.util.FastTrig;

public strictfp class Vector2f
implements Serializable {
    public /* synthetic */ float x;
    private static final /* synthetic */ long serialVersionUID = 1339934L;
    public /* synthetic */ float y;

    public Vector2f sub(double llIIlIIIlIllIll) {
        Vector2f llIIlIIIlIlllII;
        llIIlIIIlIlllII.setTheta(llIIlIIIlIlllII.getTheta() - llIIlIIIlIllIll);
        return llIIlIIIlIlllII;
    }

    public Vector2f add(Vector2f llIIlIIIIIlIllI) {
        Vector2f llIIlIIIIIlIlll;
        llIIlIIIIIlIlll.x += llIIlIIIIIlIllI.getX();
        llIIlIIIIIlIlll.y += llIIlIIIIIlIllI.getY();
        return llIIlIIIIIlIlll;
    }

    public void projectOntoUnit(Vector2f llIIIllllllIIlI, Vector2f llIIIlllllIllIl) {
        Vector2f llIIIllllllIIll;
        float llIIIllllllIIII = llIIIllllllIIlI.dot(llIIIllllllIIll);
        llIIIlllllIllIl.x = llIIIllllllIIII * llIIIllllllIIlI.getX();
        llIIIlllllIllIl.y = llIIIllllllIIII * llIIIllllllIIlI.getY();
    }

    public Vector2f sub(Vector2f llIIlIIIIIlIIII) {
        Vector2f llIIlIIIIIlIIll;
        llIIlIIIIIlIIll.x -= llIIlIIIIIlIIII.getX();
        llIIlIIIIIlIIll.y -= llIIlIIIIIlIIII.getY();
        return llIIlIIIIIlIIll;
    }

    public float getY() {
        Vector2f llIIlIIIlIIllll;
        return llIIlIIIlIIllll.y;
    }

    public Vector2f getPerpendicular() {
        Vector2f llIIlIIIIlIlIIl;
        return new Vector2f(-llIIlIIIIlIlIIl.y, llIIlIIIIlIlIIl.x);
    }

    public Vector2f(float[] llIIlIIIllllIll) {
        Vector2f llIIlIIIllllIlI;
        llIIlIIIllllIlI.x = llIIlIIIllllIll[0];
        llIIlIIIllllIlI.y = llIIlIIIllllIll[1];
    }

    public Vector2f(float llIIlIIIlIIIlII, float llIIlIIIlIIIIII) {
        Vector2f llIIlIIIlIIIlIl;
        llIIlIIIlIIIlIl.x = llIIlIIIlIIIlII;
        llIIlIIIlIIIlIl.y = llIIlIIIlIIIIII;
    }

    public float length() {
        Vector2f llIIIlllllllIII;
        return (float)Math.sqrt(llIIIlllllllIII.lengthSquared());
    }

    public Vector2f(double llIIlIIIlllIIll) {
        Vector2f llIIlIIIlllIlII;
        llIIlIIIlllIlII.x = 1.0f;
        llIIlIIIlllIlII.y = 0.0f;
        llIIlIIIlllIlII.setTheta(llIIlIIIlllIIll);
    }

    public Vector2f negateLocal() {
        Vector2f llIIlIIIIIlllIl;
        llIIlIIIIIlllIl.x = -llIIlIIIIIlllIl.x;
        llIIlIIIIIlllIl.y = -llIIlIIIIIlllIl.y;
        return llIIlIIIIIlllIl;
    }

    public Vector2f negate() {
        Vector2f llIIlIIIIlIIIII;
        return new Vector2f(-llIIlIIIIlIIIII.x, -llIIlIIIIlIIIII.y);
    }

    public Vector2f scale(float llIIlIIIIIIllII) {
        Vector2f llIIlIIIIIIllIl;
        llIIlIIIIIIllIl.x *= llIIlIIIIIIllII;
        llIIlIIIIIIllIl.y *= llIIlIIIIIIllII;
        return llIIlIIIIIIllIl;
    }

    public Vector2f copy() {
        Vector2f llIIIlllllIlIIl;
        return new Vector2f(llIIIlllllIlIIl.x, llIIIlllllIlIIl.y);
    }

    public String toString() {
        Vector2f llIIIlllllIIllI;
        return String.valueOf(new StringBuilder().append("[Vector2f ").append(llIIIlllllIIllI.x).append(",").append(llIIIlllllIIllI.y).append(" (").append(llIIIlllllIIllI.length()).append(")]"));
    }

    public Vector2f set(float[] llIIlIIIIlIIlII) {
        Vector2f llIIlIIIIlIIIll;
        return llIIlIIIIlIIIll.set(llIIlIIIIlIIlII[0], llIIlIIIIlIIlII[1]);
    }

    public float distance(Vector2f llIIIlllllIIIlI) {
        Vector2f llIIIlllllIIIIl;
        return (float)Math.sqrt(llIIIlllllIIIIl.distanceSquared(llIIIlllllIIIlI));
    }

    public Vector2f(Vector2f llIIlIIIlIIlIll) {
        llIIlIIIlIIlIlI(llIIlIIIlIIlIll.getX(), llIIlIIIlIIlIll.getY());
        Vector2f llIIlIIIlIIlIlI;
    }

    public Vector2f() {
        Vector2f llIIlIIIlllllll;
    }

    public void setTheta(double llIIlIIIllIllIl) {
        Vector2f llIIlIIIllIlIlI;
        if (llIIlIIIllIllIl < -360.0 || llIIlIIIllIllIl > 360.0) {
            llIIlIIIllIllIl %= 360.0;
        }
        if (llIIlIIIllIllIl < 0.0) {
            llIIlIIIllIllIl = 360.0 + llIIlIIIllIllIl;
        }
        double llIIlIIIllIllII = llIIlIIIllIlIlI.getTheta();
        if (llIIlIIIllIllIl < -360.0 || llIIlIIIllIllIl > 360.0) {
            llIIlIIIllIllII %= 360.0;
        }
        if (llIIlIIIllIllIl < 0.0) {
            llIIlIIIllIllII = 360.0 + llIIlIIIllIllII;
        }
        float llIIlIIIllIlIll = llIIlIIIllIlIlI.length();
        llIIlIIIllIlIlI.x = llIIlIIIllIlIll * (float)FastTrig.cos(StrictMath.toRadians(llIIlIIIllIllIl));
        llIIlIIIllIlIlI.y = llIIlIIIllIlIll * (float)FastTrig.sin(StrictMath.toRadians(llIIlIIIllIllIl));
    }

    public Vector2f normalise() {
        Vector2f llIIlIIIIIIIlll;
        float llIIlIIIIIIIllI = llIIlIIIIIIIlll.length();
        if (llIIlIIIIIIIllI == 0.0f) {
            return llIIlIIIIIIIlll;
        }
        llIIlIIIIIIIlll.x /= llIIlIIIIIIIllI;
        llIIlIIIIIIIlll.y /= llIIlIIIIIIIllI;
        return llIIlIIIIIIIlll;
    }

    public float getX() {
        Vector2f llIIlIIIlIlIIlI;
        return llIIlIIIlIlIIlI.x;
    }

    public void set(Vector2f llIIlIIIIllllII) {
        Vector2f llIIlIIIIlllIll;
        llIIlIIIIlllIll.set(llIIlIIIIllllII.getX(), llIIlIIIIllllII.getY());
    }

    public int hashCode() {
        Vector2f llIIIllllIlIIIl;
        return 997 * (int)llIIIllllIlIIIl.x ^ 991 * (int)llIIIllllIlIIIl.y;
    }

    public Vector2f getNormal() {
        Vector2f llIIlIIIIIIIIIl;
        Vector2f llIIlIIIIIIIIII = llIIlIIIIIIIIIl.copy();
        llIIlIIIIIIIIII.normalise();
        return llIIlIIIIIIIIII;
    }

    public float distanceSquared(Vector2f llIIIllllIlIllI) {
        Vector2f llIIIllllIllIll;
        float llIIIllllIllIIl = llIIIllllIlIllI.getX() - llIIIllllIllIll.getX();
        float llIIIllllIllIII = llIIIllllIlIllI.getY() - llIIIllllIllIll.getY();
        return llIIIllllIllIIl * llIIIllllIllIIl + llIIIllllIllIII * llIIIllllIllIII;
    }

    public double getTheta() {
        Vector2f llIIlIIIlIllIII;
        double llIIlIIIlIlIlll = StrictMath.toDegrees(StrictMath.atan2(llIIlIIIlIllIII.y, llIIlIIIlIllIII.x));
        if (llIIlIIIlIlIlll < -360.0 || llIIlIIIlIlIlll > 360.0) {
            llIIlIIIlIlIlll %= 360.0;
        }
        if (llIIlIIIlIlIlll < 0.0) {
            llIIlIIIlIlIlll = 360.0 + llIIlIIIlIlIlll;
        }
        return llIIlIIIlIlIlll;
    }

    public float lengthSquared() {
        Vector2f llIIIllllllllII;
        return llIIIllllllllII.x * llIIIllllllllII.x + llIIIllllllllII.y * llIIIllllllllII.y;
    }

    public boolean equals(Object llIIIllllIIlIll) {
        if (llIIIllllIIlIll instanceof Vector2f) {
            Vector2f llIIIllllIIlIlI;
            Vector2f llIIIllllIIllIl = (Vector2f)llIIIllllIIlIll;
            return llIIIllllIIllIl.x == llIIIllllIIlIlI.x && llIIIllllIIllIl.y == llIIIllllIIlIlI.y;
        }
        return false;
    }

    public Vector2f set(float llIIlIIIIlIllII, float llIIlIIIIlIlIll) {
        Vector2f llIIlIIIIlIllIl;
        llIIlIIIIlIllIl.x = llIIlIIIIlIllII;
        llIIlIIIIlIllIl.y = llIIlIIIIlIlIll;
        return llIIlIIIIlIllIl;
    }

    public float dot(Vector2f llIIlIIIIllIlII) {
        Vector2f llIIlIIIIllIlll;
        return llIIlIIIIllIlll.x * llIIlIIIIllIlII.getX() + llIIlIIIIllIlll.y * llIIlIIIIllIlII.getY();
    }

    public Vector2f add(double llIIlIIIllIIIIl) {
        Vector2f llIIlIIIllIIlII;
        llIIlIIIllIIlII.setTheta(llIIlIIIllIIlII.getTheta() + llIIlIIIllIIIIl);
        return llIIlIIIllIIlII;
    }
}

