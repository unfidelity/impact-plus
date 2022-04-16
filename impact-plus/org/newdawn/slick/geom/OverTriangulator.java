/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Triangulator;

public class OverTriangulator
implements Triangulator {
    private /* synthetic */ float[][] triangles;

    @Override
    public float[] getTrianglePoint(int lllllllllllllllllIIIIlllllIllIII, int lllllllllllllllllIIIIlllllIlIlll) {
        OverTriangulator lllllllllllllllllIIIIlllllIlllIl;
        float[] lllllllllllllllllIIIIlllllIllIlI = lllllllllllllllllIIIIlllllIlllIl.triangles[lllllllllllllllllIIIIlllllIllIII * 3 + lllllllllllllllllIIIIlllllIlIlll];
        return new float[]{lllllllllllllllllIIIIlllllIllIlI[0], lllllllllllllllllIIIIlllllIllIlI[1]};
    }

    @Override
    public void addPolyPoint(float lllllllllllllllllIIIIllllllIIllI, float lllllllllllllllllIIIIllllllIIlIl) {
    }

    @Override
    public boolean triangulate() {
        return true;
    }

    public OverTriangulator(Triangulator lllllllllllllllllIIIIlllllllIIll) {
        OverTriangulator lllllllllllllllllIIIIlllllllIIIl;
        lllllllllllllllllIIIIlllllllIIIl.triangles = new float[lllllllllllllllllIIIIlllllllIIll.getTriangleCount() * 6 * 3][2];
        int lllllllllllllllllIIIIlllllllIIlI = 0;
        for (int lllllllllllllllllIIIIlllllllIlIl = 0; lllllllllllllllllIIIIlllllllIlIl < lllllllllllllllllIIIIlllllllIIll.getTriangleCount(); ++lllllllllllllllllIIIIlllllllIlIl) {
            float lllllllllllllllllIIIIlllllllIlll = 0.0f;
            float lllllllllllllllllIIIIlllllllIllI = 0.0f;
            for (int lllllllllllllllllIIIlIIIIIIIIIII = 0; lllllllllllllllllIIIlIIIIIIIIIII < 3; ++lllllllllllllllllIIIlIIIIIIIIIII) {
                float[] lllllllllllllllllIIIlIIIIIIIIIIl = lllllllllllllllllIIIIlllllllIIll.getTrianglePoint(lllllllllllllllllIIIIlllllllIlIl, lllllllllllllllllIIIlIIIIIIIIIII);
                lllllllllllllllllIIIIlllllllIlll += lllllllllllllllllIIIlIIIIIIIIIIl[0];
                lllllllllllllllllIIIIlllllllIllI += lllllllllllllllllIIIlIIIIIIIIIIl[1];
            }
            lllllllllllllllllIIIIlllllllIlll /= 3.0f;
            lllllllllllllllllIIIIlllllllIllI /= 3.0f;
            for (int lllllllllllllllllIIIIlllllllllII = 0; lllllllllllllllllIIIIlllllllllII < 3; ++lllllllllllllllllIIIIlllllllllII) {
                int lllllllllllllllllIIIIlllllllllll = lllllllllllllllllIIIIlllllllllII + 1;
                if (lllllllllllllllllIIIIlllllllllll > 2) {
                    lllllllllllllllllIIIIlllllllllll = 0;
                }
                float[] lllllllllllllllllIIIIllllllllllI = lllllllllllllllllIIIIlllllllIIll.getTrianglePoint(lllllllllllllllllIIIIlllllllIlIl, lllllllllllllllllIIIIlllllllllII);
                float[] lllllllllllllllllIIIIlllllllllIl = lllllllllllllllllIIIIlllllllIIll.getTrianglePoint(lllllllllllllllllIIIIlllllllIlIl, lllllllllllllllllIIIIlllllllllll);
                lllllllllllllllllIIIIllllllllllI[0] = (lllllllllllllllllIIIIllllllllllI[0] + lllllllllllllllllIIIIlllllllllIl[0]) / 2.0f;
                lllllllllllllllllIIIIllllllllllI[1] = (lllllllllllllllllIIIIllllllllllI[1] + lllllllllllllllllIIIIlllllllllIl[1]) / 2.0f;
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 0][0] = lllllllllllllllllIIIIlllllllIlll;
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 0][1] = lllllllllllllllllIIIIlllllllIllI;
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 1][0] = lllllllllllllllllIIIIllllllllllI[0];
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 1][1] = lllllllllllllllllIIIIllllllllllI[1];
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 2][0] = lllllllllllllllllIIIIlllllllllIl[0];
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 2][1] = lllllllllllllllllIIIIlllllllllIl[1];
                ++lllllllllllllllllIIIIlllllllIIlI;
            }
            for (int lllllllllllllllllIIIIllllllllIII = 0; lllllllllllllllllIIIIllllllllIII < 3; ++lllllllllllllllllIIIIllllllllIII) {
                int lllllllllllllllllIIIIllllllllIll = lllllllllllllllllIIIIllllllllIII + 1;
                if (lllllllllllllllllIIIIllllllllIll > 2) {
                    lllllllllllllllllIIIIllllllllIll = 0;
                }
                float[] lllllllllllllllllIIIIllllllllIlI = lllllllllllllllllIIIIlllllllIIll.getTrianglePoint(lllllllllllllllllIIIIlllllllIlIl, lllllllllllllllllIIIIllllllllIII);
                float[] lllllllllllllllllIIIIllllllllIIl = lllllllllllllllllIIIIlllllllIIll.getTrianglePoint(lllllllllllllllllIIIIlllllllIlIl, lllllllllllllllllIIIIllllllllIll);
                lllllllllllllllllIIIIllllllllIIl[0] = (lllllllllllllllllIIIIllllllllIlI[0] + lllllllllllllllllIIIIllllllllIIl[0]) / 2.0f;
                lllllllllllllllllIIIIllllllllIIl[1] = (lllllllllllllllllIIIIllllllllIlI[1] + lllllllllllllllllIIIIllllllllIIl[1]) / 2.0f;
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 0][0] = lllllllllllllllllIIIIlllllllIlll;
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 0][1] = lllllllllllllllllIIIIlllllllIllI;
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 1][0] = lllllllllllllllllIIIIllllllllIlI[0];
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 1][1] = lllllllllllllllllIIIIllllllllIlI[1];
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 2][0] = lllllllllllllllllIIIIllllllllIIl[0];
                lllllllllllllllllIIIIlllllllIIIl.triangles[lllllllllllllllllIIIIlllllllIIlI * 3 + 2][1] = lllllllllllllllllIIIIllllllllIIl[1];
                ++lllllllllllllllllIIIIlllllllIIlI;
            }
        }
    }

    @Override
    public void startHole() {
    }

    @Override
    public int getTriangleCount() {
        OverTriangulator lllllllllllllllllIIIIllllllIIIlI;
        return lllllllllllllllllIIIIllllllIIIlI.triangles.length / 3;
    }
}

