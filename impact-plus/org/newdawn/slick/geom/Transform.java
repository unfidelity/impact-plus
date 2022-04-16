/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.FastTrig;

public class Transform {
    private /* synthetic */ float[] matrixPosition;

    public Vector2f transform(Vector2f lllllllllllllllllIlIllIllIIIlIIl) {
        Transform lllllllllllllllllIlIllIllIIIlIlI;
        float[] lllllllllllllllllIlIllIllIIIlIII = new float[]{lllllllllllllllllIlIllIllIIIlIIl.x, lllllllllllllllllIlIllIllIIIlIIl.y};
        float[] lllllllllllllllllIlIllIllIIIIlll = new float[2];
        lllllllllllllllllIlIllIllIIIlIlI.transform(lllllllllllllllllIlIllIllIIIlIII, 0, lllllllllllllllllIlIllIllIIIIlll, 0, 1);
        return new Vector2f(lllllllllllllllllIlIllIllIIIIlll[0], lllllllllllllllllIlIllIllIIIIlll[1]);
    }

    public Transform concatenate(Transform lllllllllllllllllIlIllIlllIllllI) {
        Transform lllllllllllllllllIlIllIlllIlIIIl;
        float[] lllllllllllllllllIlIllIlllIlllII = new float[9];
        float lllllllllllllllllIlIllIlllIllIll = lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[0] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[0] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[1] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[3];
        float lllllllllllllllllIlIllIlllIllIIl = lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[0] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[1] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[1] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[4];
        float lllllllllllllllllIlIllIlllIllIII = lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[0] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[2] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[1] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[5] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[2];
        float lllllllllllllllllIlIllIlllIlIlll = lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[3] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[0] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[4] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[3];
        float lllllllllllllllllIlIllIlllIlIlIl = lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[3] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[1] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[4] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[4];
        float lllllllllllllllllIlIllIlllIlIIll = lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[3] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[2] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[4] * lllllllllllllllllIlIllIlllIllllI.matrixPosition[5] + lllllllllllllllllIlIllIlllIlIIIl.matrixPosition[5];
        lllllllllllllllllIlIllIlllIlllII[0] = lllllllllllllllllIlIllIlllIllIll;
        lllllllllllllllllIlIllIlllIlllII[1] = lllllllllllllllllIlIllIlllIllIIl;
        lllllllllllllllllIlIllIlllIlllII[2] = lllllllllllllllllIlIllIlllIllIII;
        lllllllllllllllllIlIllIlllIlllII[3] = lllllllllllllllllIlIllIlllIlIlll;
        lllllllllllllllllIlIllIlllIlllII[4] = lllllllllllllllllIlIllIlllIlIlIl;
        lllllllllllllllllIlIllIlllIlllII[5] = lllllllllllllllllIlIllIlllIlIIll;
        lllllllllllllllllIlIllIlllIlIIIl.matrixPosition = lllllllllllllllllIlIllIlllIlllII;
        return lllllllllllllllllIlIllIlllIlIIIl;
    }

    public String toString() {
        Transform lllllllllllllllllIlIllIllIllllll;
        String lllllllllllllllllIlIllIlllIIIIII = String.valueOf(new StringBuilder().append("Transform[[").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[0]).append(",").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[1]).append(",").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[2]).append("][").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[3]).append(",").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[4]).append(",").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[5]).append("][").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[6]).append(",").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[7]).append(",").append(lllllllllllllllllIlIllIllIllllll.matrixPosition[8]).append("]]"));
        return lllllllllllllllllIlIllIlllIIIIII.toString();
    }

    public float[] getMatrixPosition() {
        Transform lllllllllllllllllIlIllIllIlllIll;
        return lllllllllllllllllIlIllIllIlllIll.matrixPosition;
    }

    public Transform(Transform lllllllllllllllllIlIlllIIIllIIll) {
        Transform lllllllllllllllllIlIlllIIIllIlII;
        lllllllllllllllllIlIlllIIIllIlII.matrixPosition = new float[9];
        for (int lllllllllllllllllIlIlllIIIllIlll = 0; lllllllllllllllllIlIlllIIIllIlll < 9; ++lllllllllllllllllIlIlllIIIllIlll) {
            lllllllllllllllllIlIlllIIIllIlII.matrixPosition[lllllllllllllllllIlIlllIIIllIlll] = lllllllllllllllllIlIlllIIIllIIll.matrixPosition[lllllllllllllllllIlIlllIIIllIlll];
        }
    }

    public Transform() {
        Transform lllllllllllllllllIlIlllIIIlllIll;
        lllllllllllllllllIlIlllIIIlllIll.matrixPosition = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public Transform(Transform lllllllllllllllllIlIlllIIIlIlIlI, Transform lllllllllllllllllIlIlllIIIlIlIIl) {
        lllllllllllllllllIlIlllIIIlIlllI(lllllllllllllllllIlIlllIIIlIlIlI);
        Transform lllllllllllllllllIlIlllIIIlIlllI;
        lllllllllllllllllIlIlllIIIlIlllI.concatenate(lllllllllllllllllIlIlllIIIlIlIIl);
    }

    public void transform(float[] lllllllllllllllllIlIlllIIIIIIIII, int lllllllllllllllllIlIllIlllllllll, float[] lllllllllllllllllIlIllIllllllllI, int lllllllllllllllllIlIllIlllllllIl, int lllllllllllllllllIlIllIlllllIlIl) {
        float[] lllllllllllllllllIlIllIllllllIll = lllllllllllllllllIlIlllIIIIIIIII == lllllllllllllllllIlIllIllllllllI ? new float[lllllllllllllllllIlIllIlllllIlIl * 2] : lllllllllllllllllIlIllIllllllllI;
        for (int lllllllllllllllllIlIlllIIIIIIIll = 0; lllllllllllllllllIlIlllIIIIIIIll < lllllllllllllllllIlIllIlllllIlIl * 2; lllllllllllllllllIlIlllIIIIIIIll += 2) {
            for (int lllllllllllllllllIlIlllIIIIIIlII = 0; lllllllllllllllllIlIlllIIIIIIlII < 6; lllllllllllllllllIlIlllIIIIIIlII += 3) {
                Transform lllllllllllllllllIlIllIllllllIlI;
                lllllllllllllllllIlIllIllllllIll[lllllllllllllllllIlIlllIIIIIIIll + lllllllllllllllllIlIlllIIIIIIlII / 3] = lllllllllllllllllIlIlllIIIIIIIII[lllllllllllllllllIlIlllIIIIIIIll + lllllllllllllllllIlIllIlllllllll] * lllllllllllllllllIlIllIllllllIlI.matrixPosition[lllllllllllllllllIlIlllIIIIIIlII] + lllllllllllllllllIlIlllIIIIIIIII[lllllllllllllllllIlIlllIIIIIIIll + lllllllllllllllllIlIllIlllllllll + 1] * lllllllllllllllllIlIllIllllllIlI.matrixPosition[lllllllllllllllllIlIlllIIIIIIlII + 1] + 1.0f * lllllllllllllllllIlIllIllllllIlI.matrixPosition[lllllllllllllllllIlIlllIIIIIIlII + 2];
            }
        }
        if (lllllllllllllllllIlIlllIIIIIIIII == lllllllllllllllllIlIllIllllllllI) {
            for (int lllllllllllllllllIlIlllIIIIIIIlI = 0; lllllllllllllllllIlIlllIIIIIIIlI < lllllllllllllllllIlIllIlllllIlIl * 2; lllllllllllllllllIlIlllIIIIIIIlI += 2) {
                lllllllllllllllllIlIllIllllllllI[lllllllllllllllllIlIlllIIIIIIIlI + lllllllllllllllllIlIllIlllllllIl] = lllllllllllllllllIlIllIllllllIll[lllllllllllllllllIlIlllIIIIIIIlI];
                lllllllllllllllllIlIllIllllllllI[lllllllllllllllllIlIlllIIIIIIIlI + lllllllllllllllllIlIllIlllllllIl + 1] = lllllllllllllllllIlIllIllllllIll[lllllllllllllllllIlIlllIIIIIIIlI + 1];
            }
        }
    }

    public static Transform createRotateTransform(float lllllllllllllllllIlIllIllIlIIlll, float lllllllllllllllllIlIllIllIlIllIl, float lllllllllllllllllIlIllIllIlIllII) {
        Transform lllllllllllllllllIlIllIllIlIlIll = Transform.createRotateTransform(lllllllllllllllllIlIllIllIlIIlll);
        float lllllllllllllllllIlIllIllIlIlIIl = lllllllllllllllllIlIllIllIlIlIll.matrixPosition[3];
        float lllllllllllllllllIlIllIllIlIlIII = 1.0f - lllllllllllllllllIlIllIllIlIlIll.matrixPosition[4];
        lllllllllllllllllIlIllIllIlIlIll.matrixPosition[2] = lllllllllllllllllIlIllIllIlIllIl * lllllllllllllllllIlIllIllIlIlIII + lllllllllllllllllIlIllIllIlIllII * lllllllllllllllllIlIllIllIlIlIIl;
        lllllllllllllllllIlIllIllIlIlIll.matrixPosition[5] = lllllllllllllllllIlIllIllIlIllII * lllllllllllllllllIlIllIllIlIlIII - lllllllllllllllllIlIllIllIlIllIl * lllllllllllllllllIlIllIllIlIlIIl;
        return lllllllllllllllllIlIllIllIlIlIll;
    }

    public static Transform createTranslateTransform(float lllllllllllllllllIlIllIllIIllIII, float lllllllllllllllllIlIllIllIIlIlIl) {
        return new Transform(1.0f, 0.0f, lllllllllllllllllIlIllIllIIllIII, 0.0f, 1.0f, lllllllllllllllllIlIllIllIIlIlIl);
    }

    public Transform(float[] lllllllllllllllllIlIlllIIIlIIIll) {
        Transform lllllllllllllllllIlIlllIIIlIIllI;
        if (lllllllllllllllllIlIlllIIIlIIIll.length != 6) {
            throw new RuntimeException("The parameter must be a float array of length 6.");
        }
        lllllllllllllllllIlIlllIIIlIIllI.matrixPosition = new float[]{lllllllllllllllllIlIlllIIIlIIIll[0], lllllllllllllllllIlIlllIIIlIIIll[1], lllllllllllllllllIlIlllIIIlIIIll[2], lllllllllllllllllIlIlllIIIlIIIll[3], lllllllllllllllllIlIlllIIIlIIIll[4], lllllllllllllllllIlIlllIIIlIIIll[5], 0.0f, 0.0f, 1.0f};
    }

    public static Transform createScaleTransform(float lllllllllllllllllIlIllIllIIlIIII, float lllllllllllllllllIlIllIllIIIllll) {
        return new Transform(lllllllllllllllllIlIllIllIIlIIII, 0.0f, 0.0f, 0.0f, lllllllllllllllllIlIllIllIIIllll, 0.0f);
    }

    public Transform(float lllllllllllllllllIlIlllIIIIllIlI, float lllllllllllllllllIlIlllIIIIlIIlI, float lllllllllllllllllIlIlllIIIIlIIIl, float lllllllllllllllllIlIlllIIIIlIlll, float lllllllllllllllllIlIlllIIIIIllll, float lllllllllllllllllIlIlllIIIIIlllI) {
        Transform lllllllllllllllllIlIlllIIIIlIlII;
        lllllllllllllllllIlIlllIIIIlIlII.matrixPosition = new float[]{lllllllllllllllllIlIlllIIIIllIlI, lllllllllllllllllIlIlllIIIIlIIlI, lllllllllllllllllIlIlllIIIIlIIIl, lllllllllllllllllIlIlllIIIIlIlll, lllllllllllllllllIlIlllIIIIIllll, lllllllllllllllllIlIlllIIIIIlllI, 0.0f, 0.0f, 1.0f};
    }

    public static Transform createRotateTransform(float lllllllllllllllllIlIllIllIlllIII) {
        return new Transform((float)FastTrig.cos(lllllllllllllllllIlIllIllIlllIII), -((float)FastTrig.sin(lllllllllllllllllIlIllIllIlllIII)), 0.0f, (float)FastTrig.sin(lllllllllllllllllIlIllIllIlllIII), (float)FastTrig.cos(lllllllllllllllllIlIllIllIlllIII), 0.0f);
    }
}

