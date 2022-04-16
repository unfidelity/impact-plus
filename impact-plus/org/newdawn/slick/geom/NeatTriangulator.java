/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.geom.Triangulator;

public class NeatTriangulator
implements Triangulator {
    private /* synthetic */ Triangle[] triangles;
    private /* synthetic */ int numEdges;
    private /* synthetic */ int[] V;
    private /* synthetic */ float[] pointsY;
    private /* synthetic */ Edge[] edges;
    private /* synthetic */ int numPoints;
    private /* synthetic */ float offset;
    private /* synthetic */ float[] pointsX;
    private /* synthetic */ int numTriangles;
    static final /* synthetic */ float EPSILON = 1.0E-6f;

    private static float rho(float lllllllllllllllllllIlIIlllIlIlII, float lllllllllllllllllllIlIIlllIlIIll, float lllllllllllllllllllIlIIlllIlIIlI, float lllllllllllllllllllIlIIlllIlIIIl, float lllllllllllllllllllIlIIlllIlllIl, float lllllllllllllllllllIlIIlllIlllII) {
        float lllllllllllllllllllIlIIlllIllIll = lllllllllllllllllllIlIIlllIlllIl - lllllllllllllllllllIlIIlllIlIIlI;
        float lllllllllllllllllllIlIIlllIlIlll = lllllllllllllllllllIlIIlllIlIIll - lllllllllllllllllllIlIIlllIlllII;
        float lllllllllllllllllllIlIIlllIllIlI = lllllllllllllllllllIlIIlllIlllII - lllllllllllllllllllIlIIlllIlIIIl;
        float lllllllllllllllllllIlIIlllIllIII = lllllllllllllllllllIlIIlllIlIlII - lllllllllllllllllllIlIIlllIlllIl;
        float lllllllllllllllllllIlIIlllIlIlIl = lllllllllllllllllllIlIIlllIllIll * lllllllllllllllllllIlIIlllIlIlll - lllllllllllllllllllIlIIlllIllIlI * lllllllllllllllllllIlIIlllIllIII;
        if (lllllllllllllllllllIlIIlllIlIlIl > 0.0f) {
            if (lllllllllllllllllllIlIIlllIlIlIl < 1.0E-6f) {
                lllllllllllllllllllIlIIlllIlIlIl = 1.0E-6f;
            }
            float lllllllllllllllllllIlIIllllIlllI = lllllllllllllllllllIlIIlllIllIll * lllllllllllllllllllIlIIlllIllIll;
            float lllllllllllllllllllIlIIllllIllII = lllllllllllllllllllIlIIlllIllIlI * lllllllllllllllllllIlIIlllIllIlI;
            float lllllllllllllllllllIlIIllllIlIlI = lllllllllllllllllllIlIIlllIllIII * lllllllllllllllllllIlIIlllIllIII;
            float lllllllllllllllllllIlIIllllIlIII = lllllllllllllllllllIlIIlllIlIlll * lllllllllllllllllllIlIIlllIlIlll;
            float lllllllllllllllllllIlIIllllIIlll = lllllllllllllllllllIlIIlllIlIIlI - lllllllllllllllllllIlIIlllIlIlII;
            float lllllllllllllllllllIlIIllllIIllI = lllllllllllllllllllIlIIlllIlIIIl - lllllllllllllllllllIlIIlllIlIIll;
            float lllllllllllllllllllIlIIllllIIlIl = lllllllllllllllllllIlIIllllIIlll * lllllllllllllllllllIlIIllllIIlll;
            float lllllllllllllllllllIlIIllllIIlII = lllllllllllllllllllIlIIllllIIllI * lllllllllllllllllllIlIIllllIIllI;
            return (lllllllllllllllllllIlIIllllIlllI + lllllllllllllllllllIlIIllllIllII) * (lllllllllllllllllllIlIIllllIlIlI + lllllllllllllllllllIlIIllllIlIII) * (lllllllllllllllllllIlIIllllIIlIl + lllllllllllllllllllIlIIllllIIlII) / (lllllllllllllllllllIlIIlllIlIlIl * lllllllllllllllllllIlIIlllIlIlIl);
        }
        return -1.0f;
    }

    void markSuspect(int lllllllllllllllllllIlIlIIIllIllI, int lllllllllllllllllllIlIlIIIllIlIl, boolean lllllllllllllllllllIlIlIIIllIlII) throws InternalException {
        NeatTriangulator lllllllllllllllllllIlIlIIIllIIlI;
        int lllllllllllllllllllIlIlIIIllIIll = lllllllllllllllllllIlIlIIIllIIlI.findEdge(lllllllllllllllllllIlIlIIIllIllI, lllllllllllllllllllIlIlIIIllIlIl);
        if (0 > lllllllllllllllllllIlIlIIIllIIll) {
            throw lllllllllllllllllllIlIlIIIllIIlI.new InternalException("Attempt to mark unknown edge");
        }
        lllllllllllllllllllIlIlIIIllIIlI.edges[lllllllllllllllllllIlIlIIIllIIll].suspect = lllllllllllllllllllIlIlIIIllIlII;
    }

    @Override
    public float[] getTrianglePoint(int lllllllllllllllllllIlIIIIlIIlIII, int lllllllllllllllllllIlIIIIlIIIlll) {
        NeatTriangulator lllllllllllllllllllIlIIIIlIIIlII;
        float lllllllllllllllllllIlIIIIlIIIllI = lllllllllllllllllllIlIIIIlIIIlII.pointsX[lllllllllllllllllllIlIIIIlIIIlII.triangles[lllllllllllllllllllIlIIIIlIIlIII].v[lllllllllllllllllllIlIIIIlIIIlll]];
        float lllllllllllllllllllIlIIIIlIIIlIl = lllllllllllllllllllIlIIIIlIIIlII.pointsY[lllllllllllllllllllIlIIIIlIIIlII.triangles[lllllllllllllllllllIlIIIIlIIlIII].v[lllllllllllllllllllIlIIIIlIIIlll]];
        return new float[]{lllllllllllllllllllIlIIIIlIIIllI, lllllllllllllllllllIlIIIIlIIIlIl};
    }

    private static boolean insideTriangle(float lllllllllllllllllllIlIIllIIllllI, float lllllllllllllllllllIlIIllIIlllII, float lllllllllllllllllllIlIIllIIllIlI, float lllllllllllllllllllIlIIllIIIIIII, float lllllllllllllllllllIlIIllIIlIllI, float lllllllllllllllllllIlIIllIIlIlIl, float lllllllllllllllllllIlIIlIlllllIl, float lllllllllllllllllllIlIIlIlllllII) {
        float lllllllllllllllllllIlIIllIIlIIlI = lllllllllllllllllllIlIIllIIlIllI - lllllllllllllllllllIlIIllIIllIlI;
        float lllllllllllllllllllIlIIllIIlIIIl = lllllllllllllllllllIlIIllIIlIlIl - lllllllllllllllllllIlIIllIIIIIII;
        float lllllllllllllllllllIlIIllIIlIIII = lllllllllllllllllllIlIIllIIllllI - lllllllllllllllllllIlIIllIIlIllI;
        float lllllllllllllllllllIlIIllIIIllll = lllllllllllllllllllIlIIllIIlllII - lllllllllllllllllllIlIIllIIlIlIl;
        float lllllllllllllllllllIlIIllIIIlllI = lllllllllllllllllllIlIIllIIllIlI - lllllllllllllllllllIlIIllIIllllI;
        float lllllllllllllllllllIlIIllIIIllIl = lllllllllllllllllllIlIIllIIIIIII - lllllllllllllllllllIlIIllIIlllII;
        float lllllllllllllllllllIlIIllIIIllII = lllllllllllllllllllIlIIlIlllllIl - lllllllllllllllllllIlIIllIIllllI;
        float lllllllllllllllllllIlIIllIIIlIll = lllllllllllllllllllIlIIlIlllllII - lllllllllllllllllllIlIIllIIlllII;
        float lllllllllllllllllllIlIIllIIIlIlI = lllllllllllllllllllIlIIlIlllllIl - lllllllllllllllllllIlIIllIIllIlI;
        float lllllllllllllllllllIlIIllIIIlIIl = lllllllllllllllllllIlIIlIlllllII - lllllllllllllllllllIlIIllIIIIIII;
        float lllllllllllllllllllIlIIllIIIlIII = lllllllllllllllllllIlIIlIlllllIl - lllllllllllllllllllIlIIllIIlIllI;
        float lllllllllllllllllllIlIIllIIIIlll = lllllllllllllllllllIlIIlIlllllII - lllllllllllllllllllIlIIllIIlIlIl;
        float lllllllllllllllllllIlIIllIIIIllI = lllllllllllllllllllIlIIllIIlIIlI * lllllllllllllllllllIlIIllIIIlIIl - lllllllllllllllllllIlIIllIIlIIIl * lllllllllllllllllllIlIIllIIIlIlI;
        float lllllllllllllllllllIlIIllIIIIlIl = lllllllllllllllllllIlIIllIIIlllI * lllllllllllllllllllIlIIllIIIlIll - lllllllllllllllllllIlIIllIIIllIl * lllllllllllllllllllIlIIllIIIllII;
        float lllllllllllllllllllIlIIllIIIIlII = lllllllllllllllllllIlIIllIIlIIII * lllllllllllllllllllIlIIllIIIIlll - lllllllllllllllllllIlIIllIIIllll * lllllllllllllllllllIlIIllIIIlIII;
        return (double)lllllllllllllllllllIlIIllIIIIllI >= 0.0 && (double)lllllllllllllllllllIlIIllIIIIlII >= 0.0 && (double)lllllllllllllllllllIlIIllIIIIlIl >= 0.0;
    }

    public void clear() {
        lllllllllllllllllllIlIlIllIIllll.numPoints = 0;
        lllllllllllllllllllIlIlIllIIllll.numEdges = 0;
        lllllllllllllllllllIlIlIllIIllll.numTriangles = 0;
    }

    private void addEdge(int lllllllllllllllllllIlIlIIlllIIll, int lllllllllllllllllllIlIlIIllIlIII, int lllllllllllllllllllIlIlIIlllIIIl) {
        int lllllllllllllllllllIlIlIIllIlIll;
        int lllllllllllllllllllIlIlIIllIllII;
        int lllllllllllllllllllIlIlIIllIlllI;
        int lllllllllllllllllllIlIlIIllIllll;
        NeatTriangulator lllllllllllllllllllIlIlIIllIlIlI;
        int lllllllllllllllllllIlIlIIlllIIII = lllllllllllllllllllIlIlIIllIlIlI.findEdge(lllllllllllllllllllIlIlIIlllIIll, lllllllllllllllllllIlIlIIllIlIII);
        if (lllllllllllllllllllIlIlIIlllIIII < 0) {
            if (lllllllllllllllllllIlIlIIllIlIlI.numEdges == lllllllllllllllllllIlIlIIllIlIlI.edges.length) {
                Edge[] lllllllllllllllllllIlIlIIllllIlI = new Edge[lllllllllllllllllllIlIlIIllIlIlI.edges.length * 2];
                System.arraycopy(lllllllllllllllllllIlIlIIllIlIlI.edges, 0, lllllllllllllllllllIlIlIIllllIlI, 0, lllllllllllllllllllIlIlIIllIlIlI.numEdges);
                lllllllllllllllllllIlIlIIllIlIlI.edges = lllllllllllllllllllIlIlIIllllIlI;
            }
            int lllllllllllllllllllIlIlIIllllIIl = -1;
            int lllllllllllllllllllIlIlIIllllIII = -1;
            lllllllllllllllllllIlIlIIlllIIII = lllllllllllllllllllIlIlIIllIlIlI.numEdges++;
            Edge lllllllllllllllllllIlIlIIlllIlll = lllllllllllllllllllIlIlIIllIlIlI.edges[lllllllllllllllllllIlIlIIlllIIII] = lllllllllllllllllllIlIlIIllIlIlI.new Edge();
        } else {
            Edge lllllllllllllllllllIlIlIIllIllIl = lllllllllllllllllllIlIlIIllIlIlI.edges[lllllllllllllllllllIlIlIIlllIIII];
            lllllllllllllllllllIlIlIIllIllll = lllllllllllllllllllIlIlIIllIllIl.t0;
            lllllllllllllllllllIlIlIIllIlllI = lllllllllllllllllllIlIlIIllIllIl.t1;
        }
        if (lllllllllllllllllllIlIlIIlllIIll < lllllllllllllllllllIlIlIIllIlIII) {
            int lllllllllllllllllllIlIlIIlllIllI = lllllllllllllllllllIlIlIIlllIIll;
            int lllllllllllllllllllIlIlIIlllIlIl = lllllllllllllllllllIlIlIIllIlIII;
            lllllllllllllllllllIlIlIIllIllll = lllllllllllllllllllIlIlIIlllIIIl;
        } else {
            lllllllllllllllllllIlIlIIllIllII = lllllllllllllllllllIlIlIIllIlIII;
            lllllllllllllllllllIlIlIIllIlIll = lllllllllllllllllllIlIlIIlllIIll;
            lllllllllllllllllllIlIlIIllIlllI = lllllllllllllllllllIlIlIIlllIIIl;
        }
        lllllllllllllllllllIlIlIIllIllIl.v0 = lllllllllllllllllllIlIlIIllIllII;
        lllllllllllllllllllIlIlIIllIllIl.v1 = lllllllllllllllllllIlIlIIllIlIll;
        lllllllllllllllllllIlIlIIllIllIl.t0 = lllllllllllllllllllIlIlIIllIllll;
        lllllllllllllllllllIlIlIIllIllIl.t1 = lllllllllllllllllllIlIlIIllIlllI;
        lllllllllllllllllllIlIlIIllIllIl.suspect = true;
    }

    private void optimize() throws InternalException {
        NeatTriangulator lllllllllllllllllllIlIIIIllllIIl;
        Edge lllllllllllllllllllIlIIIlIIIllII;
        while ((lllllllllllllllllllIlIIIlIIIllII = lllllllllllllllllllIlIIIIllllIIl.chooseSuspect()) != null) {
            int lllllllllllllllllllIlIIIlIIIlIll = lllllllllllllllllllIlIIIlIIIllII.v0;
            int lllllllllllllllllllIlIIIlIIIlIlI = lllllllllllllllllllIlIIIlIIIllII.v1;
            int lllllllllllllllllllIlIIIlIIIlIIl = lllllllllllllllllllIlIIIlIIIllII.t0;
            int lllllllllllllllllllIlIIIlIIIlIII = lllllllllllllllllllIlIIIlIIIllII.t1;
            int lllllllllllllllllllIlIIIlIIIIlll = -1;
            int lllllllllllllllllllIlIIIlIIIIllI = -1;
            for (int lllllllllllllllllllIlIIIlIIIllll = 0; lllllllllllllllllllIlIIIlIIIllll < 3; ++lllllllllllllllllllIlIIIlIIIllll) {
                int lllllllllllllllllllIlIIIlIIlIIII = lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIIl].v[lllllllllllllllllllIlIIIlIIIllll];
                if (lllllllllllllllllllIlIIIlIIIlIll == lllllllllllllllllllIlIIIlIIlIIII || lllllllllllllllllllIlIIIlIIIlIlI == lllllllllllllllllllIlIIIlIIlIIII) continue;
                lllllllllllllllllllIlIIIlIIIIllI = lllllllllllllllllllIlIIIlIIlIIII;
                break;
            }
            for (int lllllllllllllllllllIlIIIlIIIllIl = 0; lllllllllllllllllllIlIIIlIIIllIl < 3; ++lllllllllllllllllllIlIIIlIIIllIl) {
                int lllllllllllllllllllIlIIIlIIIlllI = lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIII].v[lllllllllllllllllllIlIIIlIIIllIl];
                if (lllllllllllllllllllIlIIIlIIIlIll == lllllllllllllllllllIlIIIlIIIlllI || lllllllllllllllllllIlIIIlIIIlIlI == lllllllllllllllllllIlIIIlIIIlllI) continue;
                lllllllllllllllllllIlIIIlIIIIlll = lllllllllllllllllllIlIIIlIIIlllI;
                break;
            }
            if (-1 == lllllllllllllllllllIlIIIlIIIIlll || -1 == lllllllllllllllllllIlIIIlIIIIllI) {
                throw lllllllllllllllllllIlIIIIllllIIl.new InternalException("can't find quad");
            }
            float lllllllllllllllllllIlIIIlIIIIlIl = lllllllllllllllllllIlIIIIllllIIl.pointsX[lllllllllllllllllllIlIIIlIIIlIll];
            float lllllllllllllllllllIlIIIlIIIIlII = lllllllllllllllllllIlIIIIllllIIl.pointsY[lllllllllllllllllllIlIIIlIIIlIll];
            float lllllllllllllllllllIlIIIlIIIIIll = lllllllllllllllllllIlIIIIllllIIl.pointsX[lllllllllllllllllllIlIIIlIIIIlll];
            float lllllllllllllllllllIlIIIlIIIIIlI = lllllllllllllllllllIlIIIIllllIIl.pointsY[lllllllllllllllllllIlIIIlIIIIlll];
            float lllllllllllllllllllIlIIIlIIIIIIl = lllllllllllllllllllIlIIIIllllIIl.pointsX[lllllllllllllllllllIlIIIlIIIlIlI];
            float lllllllllllllllllllIlIIIlIIIIIII = lllllllllllllllllllIlIIIIllllIIl.pointsY[lllllllllllllllllllIlIIIlIIIlIlI];
            float lllllllllllllllllllIlIIIIlllllll = lllllllllllllllllllIlIIIIllllIIl.pointsX[lllllllllllllllllllIlIIIlIIIIllI];
            float lllllllllllllllllllIlIIIIllllllI = lllllllllllllllllllIlIIIIllllIIl.pointsY[lllllllllllllllllllIlIIIlIIIIllI];
            float lllllllllllllllllllIlIIIIlllllIl = NeatTriangulator.rho(lllllllllllllllllllIlIIIlIIIIlIl, lllllllllllllllllllIlIIIlIIIIlII, lllllllllllllllllllIlIIIlIIIIIll, lllllllllllllllllllIlIIIlIIIIIlI, lllllllllllllllllllIlIIIlIIIIIIl, lllllllllllllllllllIlIIIlIIIIIII);
            float lllllllllllllllllllIlIIIIlllllII = NeatTriangulator.rho(lllllllllllllllllllIlIIIlIIIIlIl, lllllllllllllllllllIlIIIlIIIIlII, lllllllllllllllllllIlIIIlIIIIIIl, lllllllllllllllllllIlIIIlIIIIIII, lllllllllllllllllllIlIIIIlllllll, lllllllllllllllllllIlIIIIllllllI);
            float lllllllllllllllllllIlIIIIllllIll = NeatTriangulator.rho(lllllllllllllllllllIlIIIlIIIIIll, lllllllllllllllllllIlIIIlIIIIIlI, lllllllllllllllllllIlIIIlIIIIIIl, lllllllllllllllllllIlIIIlIIIIIII, lllllllllllllllllllIlIIIIlllllll, lllllllllllllllllllIlIIIIllllllI);
            float lllllllllllllllllllIlIIIIllllIlI = NeatTriangulator.rho(lllllllllllllllllllIlIIIlIIIIIll, lllllllllllllllllllIlIIIlIIIIIlI, lllllllllllllllllllIlIIIIlllllll, lllllllllllllllllllIlIIIIllllllI, lllllllllllllllllllIlIIIlIIIIlIl, lllllllllllllllllllIlIIIlIIIIlII);
            if (0.0f > lllllllllllllllllllIlIIIIlllllIl || 0.0f > lllllllllllllllllllIlIIIIlllllII) {
                throw lllllllllllllllllllIlIIIIllllIIl.new InternalException("original triangles backwards");
            }
            if (!(0.0f <= lllllllllllllllllllIlIIIIllllIll) || !(0.0f <= lllllllllllllllllllIlIIIIllllIlI)) continue;
            if (lllllllllllllllllllIlIIIIlllllIl > lllllllllllllllllllIlIIIIlllllII) {
                lllllllllllllllllllIlIIIIlllllIl = lllllllllllllllllllIlIIIIlllllII;
            }
            if (lllllllllllllllllllIlIIIIllllIll > lllllllllllllllllllIlIIIIllllIlI) {
                lllllllllllllllllllIlIIIIllllIll = lllllllllllllllllllIlIIIIllllIlI;
            }
            if (!(lllllllllllllllllllIlIIIIlllllIl > lllllllllllllllllllIlIIIIllllIll)) continue;
            lllllllllllllllllllIlIIIIllllIIl.deleteEdge(lllllllllllllllllllIlIIIlIIIlIll, lllllllllllllllllllIlIIIlIIIlIlI);
            lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIIl].v[0] = lllllllllllllllllllIlIIIlIIIIlll;
            lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIIl].v[1] = lllllllllllllllllllIlIIIlIIIlIlI;
            lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIIl].v[2] = lllllllllllllllllllIlIIIlIIIIllI;
            lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIII].v[0] = lllllllllllllllllllIlIIIlIIIIlll;
            lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIII].v[1] = lllllllllllllllllllIlIIIlIIIIllI;
            lllllllllllllllllllIlIIIIllllIIl.triangles[lllllllllllllllllllIlIIIlIIIlIII].v[2] = lllllllllllllllllllIlIIIlIIIlIll;
            lllllllllllllllllllIlIIIIllllIIl.addEdge(lllllllllllllllllllIlIIIlIIIIlll, lllllllllllllllllllIlIIIlIIIlIlI, lllllllllllllllllllIlIIIlIIIlIIl);
            lllllllllllllllllllIlIIIIllllIIl.addEdge(lllllllllllllllllllIlIIIlIIIlIlI, lllllllllllllllllllIlIIIlIIIIllI, lllllllllllllllllllIlIIIlIIIlIIl);
            lllllllllllllllllllIlIIIIllllIIl.addEdge(lllllllllllllllllllIlIIIlIIIIllI, lllllllllllllllllllIlIIIlIIIIlll, lllllllllllllllllllIlIIIlIIIlIIl);
            lllllllllllllllllllIlIIIIllllIIl.addEdge(lllllllllllllllllllIlIIIlIIIIllI, lllllllllllllllllllIlIIIlIIIlIll, lllllllllllllllllllIlIIIlIIIlIII);
            lllllllllllllllllllIlIIIIllllIIl.addEdge(lllllllllllllllllllIlIIIlIIIlIll, lllllllllllllllllllIlIIIlIIIIlll, lllllllllllllllllllIlIIIlIIIlIII);
            lllllllllllllllllllIlIIIIllllIIl.addEdge(lllllllllllllllllllIlIIIlIIIIlll, lllllllllllllllllllIlIIIlIIIIllI, lllllllllllllllllllIlIIIlIIIlIII);
            lllllllllllllllllllIlIIIIllllIIl.markSuspect(lllllllllllllllllllIlIIIlIIIIlll, lllllllllllllllllllIlIIIlIIIIllI, false);
        }
    }

    @Override
    public void addPolyPoint(float lllllllllllllllllllIlIIIIlIlIlII, float lllllllllllllllllllIlIIIIlIlIIll) {
        NeatTriangulator lllllllllllllllllllIlIIIIlIllIII;
        for (int lllllllllllllllllllIlIIIIlIllIlI = 0; lllllllllllllllllllIlIIIIlIllIlI < lllllllllllllllllllIlIIIIlIllIII.numPoints; ++lllllllllllllllllllIlIIIIlIllIlI) {
            if (lllllllllllllllllllIlIIIIlIllIII.pointsX[lllllllllllllllllllIlIIIIlIllIlI] != lllllllllllllllllllIlIIIIlIlIlII || lllllllllllllllllllIlIIIIlIllIII.pointsY[lllllllllllllllllllIlIIIIlIllIlI] != lllllllllllllllllllIlIIIIlIlIIll) continue;
            lllllllllllllllllllIlIIIIlIlIIll += lllllllllllllllllllIlIIIIlIllIII.offset;
            lllllllllllllllllllIlIIIIlIllIII.offset += 1.0E-6f;
        }
        if (lllllllllllllllllllIlIIIIlIllIII.numPoints == lllllllllllllllllllIlIIIIlIllIII.pointsX.length) {
            float[] lllllllllllllllllllIlIIIIlIllIIl = new float[lllllllllllllllllllIlIIIIlIllIII.numPoints * 2];
            System.arraycopy(lllllllllllllllllllIlIIIIlIllIII.pointsX, 0, lllllllllllllllllllIlIIIIlIllIIl, 0, lllllllllllllllllllIlIIIIlIllIII.numPoints);
            lllllllllllllllllllIlIIIIlIllIII.pointsX = lllllllllllllllllllIlIIIIlIllIIl;
            lllllllllllllllllllIlIIIIlIllIIl = new float[lllllllllllllllllllIlIIIIlIllIII.numPoints * 2];
            System.arraycopy(lllllllllllllllllllIlIIIIlIllIII.pointsY, 0, lllllllllllllllllllIlIIIIlIllIIl, 0, lllllllllllllllllllIlIIIIlIllIII.numPoints);
            lllllllllllllllllllIlIIIIlIllIII.pointsY = lllllllllllllllllllIlIIIIlIllIIl;
        }
        lllllllllllllllllllIlIIIIlIllIII.pointsX[lllllllllllllllllllIlIIIIlIllIII.numPoints] = lllllllllllllllllllIlIIIIlIlIlII;
        lllllllllllllllllllIlIIIIlIllIII.pointsY[lllllllllllllllllllIlIIIIlIllIII.numPoints] = lllllllllllllllllllIlIIIIlIlIIll;
        ++lllllllllllllllllllIlIIIIlIllIII.numPoints;
    }

    private Edge chooseSuspect() {
        NeatTriangulator lllllllllllllllllllIlIlIIIIllIlI;
        for (int lllllllllllllllllllIlIlIIIIlllII = 0; lllllllllllllllllllIlIlIIIIlllII < lllllllllllllllllllIlIlIIIIllIlI.numEdges; ++lllllllllllllllllllIlIlIIIIlllII) {
            Edge lllllllllllllllllllIlIlIIIIlllIl = lllllllllllllllllllIlIlIIIIllIlI.edges[lllllllllllllllllllIlIlIIIIlllII];
            if (!lllllllllllllllllllIlIlIIIIlllIl.suspect) continue;
            lllllllllllllllllllIlIlIIIIlllIl.suspect = false;
            if (lllllllllllllllllllIlIlIIIIlllIl.t0 < 0 || lllllllllllllllllllIlIlIIIIlllIl.t1 < 0) continue;
            return lllllllllllllllllllIlIlIIIIlllIl;
        }
        return null;
    }

    private boolean snip(int lllllllllllllllllllIlIIlIIllllII, int lllllllllllllllllllIlIIlIIlllIll, int lllllllllllllllllllIlIIlIIlllIlI, int lllllllllllllllllllIlIIlIIlllIIl) {
        NeatTriangulator lllllllllllllllllllIlIIlIlIIlIII;
        float lllllllllllllllllllIlIIlIlIIIIIl = lllllllllllllllllllIlIIlIlIIlIII.pointsX[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIIlllIll]];
        float lllllllllllllllllllIlIIlIlIIIIll = lllllllllllllllllllIlIIlIlIIlIII.pointsX[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIIllllII]];
        float lllllllllllllllllllIlIIlIIlllllI = lllllllllllllllllllIlIIlIlIIlIII.pointsY[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIIlllIlI]];
        float lllllllllllllllllllIlIIlIlIIIIlI = lllllllllllllllllllIlIIlIlIIlIII.pointsY[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIIllllII]];
        float lllllllllllllllllllIlIIlIlIIIIII = lllllllllllllllllllIlIIlIlIIlIII.pointsY[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIIlllIll]];
        float lllllllllllllllllllIlIIlIIllllll = lllllllllllllllllllIlIIlIlIIlIII.pointsX[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIIlllIlI]];
        if (1.0E-6f > (lllllllllllllllllllIlIIlIlIIIIIl - lllllllllllllllllllIlIIlIlIIIIll) * (lllllllllllllllllllIlIIlIIlllllI - lllllllllllllllllllIlIIlIlIIIIlI) - (lllllllllllllllllllIlIIlIlIIIIII - lllllllllllllllllllIlIIlIlIIIIlI) * (lllllllllllllllllllIlIIlIIllllll - lllllllllllllllllllIlIIlIlIIIIll)) {
            return false;
        }
        for (int lllllllllllllllllllIlIIlIlIIlIIl = 0; lllllllllllllllllllIlIIlIlIIlIIl < lllllllllllllllllllIlIIlIIlllIIl; ++lllllllllllllllllllIlIIlIlIIlIIl) {
            float lllllllllllllllllllIlIIlIlIIlIlI;
            float lllllllllllllllllllIlIIlIlIIlIll;
            if (lllllllllllllllllllIlIIlIlIIlIIl == lllllllllllllllllllIlIIlIIllllII || lllllllllllllllllllIlIIlIlIIlIIl == lllllllllllllllllllIlIIlIIlllIll || lllllllllllllllllllIlIIlIlIIlIIl == lllllllllllllllllllIlIIlIIlllIlI || !NeatTriangulator.insideTriangle(lllllllllllllllllllIlIIlIlIIIIll, lllllllllllllllllllIlIIlIlIIIIlI, lllllllllllllllllllIlIIlIlIIIIIl, lllllllllllllllllllIlIIlIlIIIIII, lllllllllllllllllllIlIIlIIllllll, lllllllllllllllllllIlIIlIIlllllI, lllllllllllllllllllIlIIlIlIIlIll = lllllllllllllllllllIlIIlIlIIlIII.pointsX[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIlIIlIIl]], lllllllllllllllllllIlIIlIlIIlIlI = lllllllllllllllllllIlIIlIlIIlIII.pointsY[lllllllllllllllllllIlIIlIlIIlIII.V[lllllllllllllllllllIlIIlIlIIlIIl]])) continue;
            return false;
        }
        return true;
    }

    public NeatTriangulator() {
        NeatTriangulator lllllllllllllllllllIlIlIllIlIlIl;
        lllllllllllllllllllIlIlIllIlIlIl.offset = 1.0E-6f;
        lllllllllllllllllllIlIlIllIlIlIl.pointsX = new float[100];
        lllllllllllllllllllIlIlIllIlIlIl.pointsY = new float[100];
        lllllllllllllllllllIlIlIllIlIlIl.numPoints = 0;
        lllllllllllllllllllIlIlIllIlIlIl.edges = new Edge[100];
        lllllllllllllllllllIlIlIllIlIlIl.numEdges = 0;
        lllllllllllllllllllIlIlIllIlIlIl.triangles = new Triangle[100];
        lllllllllllllllllllIlIlIllIlIlIl.numTriangles = 0;
    }

    public void basicTriangulation() throws InternalException {
        NeatTriangulator lllllllllllllllllllIlIIIllIIllIl;
        int lllllllllllllllllllIlIIIllIIllII = lllllllllllllllllllIlIIIllIIllIl.numPoints;
        if (lllllllllllllllllllIlIIIllIIllII < 3) {
            return;
        }
        lllllllllllllllllllIlIIIllIIllIl.numEdges = 0;
        lllllllllllllllllllIlIIIllIIllIl.numTriangles = 0;
        lllllllllllllllllllIlIIIllIIllIl.V = new int[lllllllllllllllllllIlIIIllIIllII];
        if (0.0 < (double)lllllllllllllllllllIlIIIllIIllIl.area()) {
            for (int lllllllllllllllllllIlIIIllIlIlll = 0; lllllllllllllllllllIlIIIllIlIlll < lllllllllllllllllllIlIIIllIIllII; ++lllllllllllllllllllIlIIIllIlIlll) {
                lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIlIlll] = lllllllllllllllllllIlIIIllIlIlll;
            }
        } else {
            for (int lllllllllllllllllllIlIIIllIlIllI = 0; lllllllllllllllllllIlIIIllIlIllI < lllllllllllllllllllIlIIIllIIllII; ++lllllllllllllllllllIlIIIllIlIllI) {
                lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIlIllI] = lllllllllllllllllllIlIIIllIIllIl.numPoints - 1 - lllllllllllllllllllIlIIIllIlIllI;
            }
        }
        int lllllllllllllllllllIlIIIllIIlIll = 2 * lllllllllllllllllllIlIIIllIIllII;
        int lllllllllllllllllllIlIIIllIIlIlI = lllllllllllllllllllIlIIIllIIllII - 1;
        while (lllllllllllllllllllIlIIIllIIllII > 2) {
            int lllllllllllllllllllIlIIIllIIlllI;
            if (0 >= lllllllllllllllllllIlIIIllIIlIll--) {
                throw lllllllllllllllllllIlIIIllIIllIl.new InternalException("Bad polygon");
            }
            int lllllllllllllllllllIlIIIllIIllll = lllllllllllllllllllIlIIIllIIlIlI;
            if (lllllllllllllllllllIlIIIllIIllII <= lllllllllllllllllllIlIIIllIIllll) {
                lllllllllllllllllllIlIIIllIIllll = 0;
            }
            if (lllllllllllllllllllIlIIIllIIllII <= (lllllllllllllllllllIlIIIllIIlIlI = lllllllllllllllllllIlIIIllIIllll + 1)) {
                lllllllllllllllllllIlIIIllIIlIlI = 0;
            }
            if (lllllllllllllllllllIlIIIllIIllII <= (lllllllllllllllllllIlIIIllIIlllI = lllllllllllllllllllIlIIIllIIlIlI + 1)) {
                lllllllllllllllllllIlIIIllIIlllI = 0;
            }
            if (!lllllllllllllllllllIlIIIllIIllIl.snip(lllllllllllllllllllIlIIIllIIllll, lllllllllllllllllllIlIIIllIIlIlI, lllllllllllllllllllIlIIIllIIlllI, lllllllllllllllllllIlIIIllIIllII)) continue;
            int lllllllllllllllllllIlIIIllIlIIll = lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIIllll];
            int lllllllllllllllllllIlIIIllIlIIlI = lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIIlIlI];
            int lllllllllllllllllllIlIIIllIlIIIl = lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIIlllI];
            if (lllllllllllllllllllIlIIIllIIllIl.numTriangles == lllllllllllllllllllIlIIIllIIllIl.triangles.length) {
                Triangle[] lllllllllllllllllllIlIIIllIlIlIl = new Triangle[lllllllllllllllllllIlIIIllIIllIl.triangles.length * 2];
                System.arraycopy(lllllllllllllllllllIlIIIllIIllIl.triangles, 0, lllllllllllllllllllIlIIIllIlIlIl, 0, lllllllllllllllllllIlIIIllIIllIl.numTriangles);
                lllllllllllllllllllIlIIIllIIllIl.triangles = lllllllllllllllllllIlIIIllIlIlIl;
            }
            lllllllllllllllllllIlIIIllIIllIl.triangles[lllllllllllllllllllIlIIIllIIllIl.numTriangles] = lllllllllllllllllllIlIIIllIIllIl.new Triangle(lllllllllllllllllllIlIIIllIlIIll, lllllllllllllllllllIlIIIllIlIIlI, lllllllllllllllllllIlIIIllIlIIIl);
            lllllllllllllllllllIlIIIllIIllIl.addEdge(lllllllllllllllllllIlIIIllIlIIll, lllllllllllllllllllIlIIIllIlIIlI, lllllllllllllllllllIlIIIllIIllIl.numTriangles);
            lllllllllllllllllllIlIIIllIIllIl.addEdge(lllllllllllllllllllIlIIIllIlIIlI, lllllllllllllllllllIlIIIllIlIIIl, lllllllllllllllllllIlIIIllIIllIl.numTriangles);
            lllllllllllllllllllIlIIIllIIllIl.addEdge(lllllllllllllllllllIlIIIllIlIIIl, lllllllllllllllllllIlIIIllIlIIll, lllllllllllllllllllIlIIIllIIllIl.numTriangles);
            ++lllllllllllllllllllIlIIIllIIllIl.numTriangles;
            int lllllllllllllllllllIlIIIllIlIIII = lllllllllllllllllllIlIIIllIIlIlI;
            for (int lllllllllllllllllllIlIIIllIlIlII = lllllllllllllllllllIlIIIllIIlIlI + 1; lllllllllllllllllllIlIIIllIlIlII < lllllllllllllllllllIlIIIllIIllII; ++lllllllllllllllllllIlIIIllIlIlII) {
                lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIlIIII] = lllllllllllllllllllIlIIIllIIllIl.V[lllllllllllllllllllIlIIIllIlIlII];
                ++lllllllllllllllllllIlIIIllIlIIII;
            }
            lllllllllllllllllllIlIIIllIIlIll = 2 * --lllllllllllllllllllIlIIIllIIllII;
        }
        lllllllllllllllllllIlIIIllIIllIl.V = null;
    }

    private float area() {
        NeatTriangulator lllllllllllllllllllIlIIlIIIlllll;
        float lllllllllllllllllllIlIIlIIlIIIlI = 0.0f;
        int lllllllllllllllllllIlIIlIIlIIIIl = lllllllllllllllllllIlIIlIIIlllll.numPoints - 1;
        int lllllllllllllllllllIlIIlIIlIIlII = 0;
        while (lllllllllllllllllllIlIIlIIlIIlII < lllllllllllllllllllIlIIlIIIlllll.numPoints) {
            lllllllllllllllllllIlIIlIIlIIIlI += lllllllllllllllllllIlIIlIIIlllll.pointsX[lllllllllllllllllllIlIIlIIlIIIIl] * lllllllllllllllllllIlIIlIIIlllll.pointsY[lllllllllllllllllllIlIIlIIlIIlII] - lllllllllllllllllllIlIIlIIIlllll.pointsY[lllllllllllllllllllIlIIlIIlIIIIl] * lllllllllllllllllllIlIIlIIIlllll.pointsX[lllllllllllllllllllIlIIlIIlIIlII];
            lllllllllllllllllllIlIIlIIlIIIIl = lllllllllllllllllllIlIIlIIlIIlII++;
        }
        return lllllllllllllllllllIlIIlIIlIIIlI * 0.5f;
    }

    @Override
    public int getTriangleCount() {
        NeatTriangulator lllllllllllllllllllIlIIIIlIIllll;
        return lllllllllllllllllllIlIIIIlIIllll.numTriangles;
    }

    @Override
    public boolean triangulate() {
        try {
            NeatTriangulator lllllllllllllllllllIlIIIIllIIIIl;
            lllllllllllllllllllIlIIIIllIIIIl.basicTriangulation();
            return true;
        }
        catch (InternalException lllllllllllllllllllIlIIIIllIIIlI) {
            lllllllllllllllllllIlIIIIllIIIIl.numEdges = 0;
            return false;
        }
    }

    private int findEdge(int lllllllllllllllllllIlIlIlIlIllll, int lllllllllllllllllllIlIlIlIlIlIIl) {
        NeatTriangulator lllllllllllllllllllIlIlIlIlIlIll;
        int lllllllllllllllllllIlIlIlIlIllII;
        int lllllllllllllllllllIlIlIlIlIllIl;
        if (lllllllllllllllllllIlIlIlIlIllll < lllllllllllllllllllIlIlIlIlIlIIl) {
            int lllllllllllllllllllIlIlIlIllIIll = lllllllllllllllllllIlIlIlIlIllll;
            int lllllllllllllllllllIlIlIlIllIIlI = lllllllllllllllllllIlIlIlIlIlIIl;
        } else {
            lllllllllllllllllllIlIlIlIlIllIl = lllllllllllllllllllIlIlIlIlIlIIl;
            lllllllllllllllllllIlIlIlIlIllII = lllllllllllllllllllIlIlIlIlIllll;
        }
        for (int lllllllllllllllllllIlIlIlIllIIIl = 0; lllllllllllllllllllIlIlIlIllIIIl < lllllllllllllllllllIlIlIlIlIlIll.numEdges; ++lllllllllllllllllllIlIlIlIllIIIl) {
            if (lllllllllllllllllllIlIlIlIlIlIll.edges[lllllllllllllllllllIlIlIlIllIIIl].v0 != lllllllllllllllllllIlIlIlIlIllIl || lllllllllllllllllllIlIlIlIlIlIll.edges[lllllllllllllllllllIlIlIlIllIIIl].v1 != lllllllllllllllllllIlIlIlIlIllII) continue;
            return lllllllllllllllllllIlIlIlIllIIIl;
        }
        return -1;
    }

    @Override
    public void startHole() {
    }

    private void deleteEdge(int lllllllllllllllllllIlIlIIlIlIlII, int lllllllllllllllllllIlIlIIlIlIIlI) throws InternalException {
        NeatTriangulator lllllllllllllllllllIlIlIIlIlIllI;
        int lllllllllllllllllllIlIlIIlIllIIl = lllllllllllllllllllIlIlIIlIlIllI.findEdge(lllllllllllllllllllIlIlIIlIlIlII, lllllllllllllllllllIlIlIIlIlIIlI);
        if (0 > lllllllllllllllllllIlIlIIlIllIIl) {
            throw lllllllllllllllllllIlIlIIlIlIllI.new InternalException("Attempt to delete unknown edge");
        }
        lllllllllllllllllllIlIlIIlIlIllI.edges[lllllllllllllllllllIlIlIIlIllIIl] = lllllllllllllllllllIlIlIIlIlIllI.edges[--lllllllllllllllllllIlIlIIlIlIllI.numEdges];
    }

    class Triangle {
        /* synthetic */ int[] v;

        Triangle(int lllllllllllllllIlllIIIIIIIIlIlIl, int lllllllllllllllIlllIIIIIIIIIllll, int lllllllllllllllIlllIIIIIIIIlIIll) {
            Triangle lllllllllllllllIlllIIIIIIIIlIIlI;
            lllllllllllllllIlllIIIIIIIIlIIlI.v = new int[3];
            lllllllllllllllIlllIIIIIIIIlIIlI.v[0] = lllllllllllllllIlllIIIIIIIIlIlIl;
            lllllllllllllllIlllIIIIIIIIlIIlI.v[1] = lllllllllllllllIlllIIIIIIIIIllll;
            lllllllllllllllIlllIIIIIIIIlIIlI.v[2] = lllllllllllllllIlllIIIIIIIIlIIll;
        }
    }

    class InternalException
    extends Exception {
        public InternalException(String lIIlIIlllIIlIIl) {
            InternalException lIIlIIlllIIllIl;
            super(lIIlIIlllIIlIIl);
        }
    }

    class Edge {
        /* synthetic */ int v0;
        /* synthetic */ int t1;
        /* synthetic */ int t0;
        /* synthetic */ int v1;
        /* synthetic */ boolean suspect;

        Edge() {
            Edge lllllllllllllllllIIllllllllIIlII;
            lllllllllllllllllIIllllllllIIlII.v0 = -1;
            lllllllllllllllllIIllllllllIIlII.v1 = -1;
            lllllllllllllllllIIllllllllIIlII.t0 = -1;
            lllllllllllllllllIIllllllllIIlII.t1 = -1;
        }
    }
}

