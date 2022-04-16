/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

public class Curve
extends Shape {
    private /* synthetic */ Vector2f p1;
    private /* synthetic */ Vector2f c2;
    private /* synthetic */ int segments;
    private /* synthetic */ Vector2f p2;
    private /* synthetic */ Vector2f c1;

    public Curve(Vector2f lllllllllllllllIllllIllIIllIIlII, Vector2f lllllllllllllllIllllIllIIlIllllI, Vector2f lllllllllllllllIllllIllIIllIIIlI, Vector2f lllllllllllllllIllllIllIIlIlllII) {
        lllllllllllllllIllllIllIIllIIIII(lllllllllllllllIllllIllIIllIIlII, lllllllllllllllIllllIllIIlIllllI, lllllllllllllllIllllIllIIllIIIlI, lllllllllllllllIllllIllIIlIlllII, 20);
        Curve lllllllllllllllIllllIllIIllIIIII;
    }

    @Override
    protected void createPoints() {
        Curve lllllllllllllllIllllIllIIIIIlllI;
        float lllllllllllllllIllllIllIIIIIllIl = 1.0f / (float)lllllllllllllllIllllIllIIIIIlllI.segments;
        lllllllllllllllIllllIllIIIIIlllI.points = new float[(lllllllllllllllIllllIllIIIIIlllI.segments + 1) * 2];
        for (int lllllllllllllllIllllIllIIIIIllll = 0; lllllllllllllllIllllIllIIIIIllll < lllllllllllllllIllllIllIIIIIlllI.segments + 1; ++lllllllllllllllIllllIllIIIIIllll) {
            float lllllllllllllllIllllIllIIIIlIIIl = (float)lllllllllllllllIllllIllIIIIIllll * lllllllllllllllIllllIllIIIIIllIl;
            Vector2f lllllllllllllllIllllIllIIIIlIIII = lllllllllllllllIllllIllIIIIIlllI.pointAt(lllllllllllllllIllllIllIIIIlIIIl);
            lllllllllllllllIllllIllIIIIIlllI.points[lllllllllllllllIllllIllIIIIIllll * 2] = lllllllllllllllIllllIllIIIIlIIII.x;
            lllllllllllllllIllllIllIIIIIlllI.points[lllllllllllllllIllllIllIIIIIllll * 2 + 1] = lllllllllllllllIllllIllIIIIlIIII.y;
        }
    }

    @Override
    public Shape transform(Transform lllllllllllllllIllllIlIllllIlIlI) {
        Curve lllllllllllllllIllllIlIllllIlIll;
        float[] lllllllllllllllIllllIlIllllIlIIl = new float[8];
        float[] lllllllllllllllIllllIlIllllIlIII = new float[8];
        lllllllllllllllIllllIlIllllIlIIl[0] = lllllllllllllllIllllIlIllllIlIll.p1.x;
        lllllllllllllllIllllIlIllllIlIIl[1] = lllllllllllllllIllllIlIllllIlIll.p1.y;
        lllllllllllllllIllllIlIllllIlIIl[2] = lllllllllllllllIllllIlIllllIlIll.c1.x;
        lllllllllllllllIllllIlIllllIlIIl[3] = lllllllllllllllIllllIlIllllIlIll.c1.y;
        lllllllllllllllIllllIlIllllIlIIl[4] = lllllllllllllllIllllIlIllllIlIll.c2.x;
        lllllllllllllllIllllIlIllllIlIIl[5] = lllllllllllllllIllllIlIllllIlIll.c2.y;
        lllllllllllllllIllllIlIllllIlIIl[6] = lllllllllllllllIllllIlIllllIlIll.p2.x;
        lllllllllllllllIllllIlIllllIlIIl[7] = lllllllllllllllIllllIlIllllIlIll.p2.y;
        lllllllllllllllIllllIlIllllIlIlI.transform(lllllllllllllllIllllIlIllllIlIIl, 0, lllllllllllllllIllllIlIllllIlIII, 0, 4);
        return new Curve(new Vector2f(lllllllllllllllIllllIlIllllIlIII[0], lllllllllllllllIllllIlIllllIlIII[1]), new Vector2f(lllllllllllllllIllllIlIllllIlIII[2], lllllllllllllllIllllIlIllllIlIII[3]), new Vector2f(lllllllllllllllIllllIlIllllIlIII[4], lllllllllllllllIllllIlIllllIlIII[5]), new Vector2f(lllllllllllllllIllllIlIllllIlIII[6], lllllllllllllllIllllIlIllllIlIII[7]));
    }

    public Vector2f pointAt(float lllllllllllllllIllllIllIIIlllllI) {
        Curve lllllllllllllllIllllIllIIIllllll;
        float lllllllllllllllIllllIllIIIllllIl = 1.0f - lllllllllllllllIllllIllIIIlllllI;
        float lllllllllllllllIllllIllIIIllllII = lllllllllllllllIllllIllIIIlllllI;
        float lllllllllllllllIllllIllIIIlllIll = lllllllllllllllIllllIllIIIllllIl * lllllllllllllllIllllIllIIIllllIl * lllllllllllllllIllllIllIIIllllIl;
        float lllllllllllllllIllllIllIIIlllIlI = 3.0f * lllllllllllllllIllllIllIIIllllIl * lllllllllllllllIllllIllIIIllllIl * lllllllllllllllIllllIllIIIllllII;
        float lllllllllllllllIllllIllIIIlllIIl = 3.0f * lllllllllllllllIllllIllIIIllllIl * lllllllllllllllIllllIllIIIllllII * lllllllllllllllIllllIllIIIllllII;
        float lllllllllllllllIllllIllIIIlllIII = lllllllllllllllIllllIllIIIllllII * lllllllllllllllIllllIllIIIllllII * lllllllllllllllIllllIllIIIllllII;
        float lllllllllllllllIllllIllIIIllIlll = lllllllllllllllIllllIllIIIllllll.p1.x * lllllllllllllllIllllIllIIIlllIll + lllllllllllllllIllllIllIIIllllll.c1.x * lllllllllllllllIllllIllIIIlllIlI + lllllllllllllllIllllIllIIIllllll.c2.x * lllllllllllllllIllllIllIIIlllIIl + lllllllllllllllIllllIllIIIllllll.p2.x * lllllllllllllllIllllIllIIIlllIII;
        float lllllllllllllllIllllIllIIIllIllI = lllllllllllllllIllllIllIIIllllll.p1.y * lllllllllllllllIllllIllIIIlllIll + lllllllllllllllIllllIllIIIllllll.c1.y * lllllllllllllllIllllIllIIIlllIlI + lllllllllllllllIllllIllIIIllllll.c2.y * lllllllllllllllIllllIllIIIlllIIl + lllllllllllllllIllllIllIIIllllll.p2.y * lllllllllllllllIllllIllIIIlllIII;
        return new Vector2f(lllllllllllllllIllllIllIIIllIlll, lllllllllllllllIllllIllIIIllIllI);
    }

    @Override
    public boolean closed() {
        return false;
    }

    public Curve(Vector2f lllllllllllllllIllllIllIIlIlIlII, Vector2f lllllllllllllllIllllIllIIlIlIIll, Vector2f lllllllllllllllIllllIllIIlIIllII, Vector2f lllllllllllllllIllllIllIIlIIlIll, int lllllllllllllllIllllIllIIlIIlIlI) {
        Curve lllllllllllllllIllllIllIIlIIllll;
        lllllllllllllllIllllIllIIlIIllll.p1 = new Vector2f(lllllllllllllllIllllIllIIlIlIlII);
        lllllllllllllllIllllIllIIlIIllll.c1 = new Vector2f(lllllllllllllllIllllIllIIlIlIIll);
        lllllllllllllllIllllIllIIlIIllll.c2 = new Vector2f(lllllllllllllllIllllIllIIlIIllII);
        lllllllllllllllIllllIllIIlIIllll.p2 = new Vector2f(lllllllllllllllIllllIllIIlIIlIll);
        lllllllllllllllIllllIllIIlIIllll.segments = lllllllllllllllIllllIllIIlIIlIlI;
        lllllllllllllllIllllIllIIlIIllll.pointsDirty = true;
    }
}

