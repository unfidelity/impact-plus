/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import org.newdawn.slick.geom.Triangulator;

public class BasicTriangulator
implements Triangulator {
    private /* synthetic */ boolean tried;
    private static final /* synthetic */ float EPSILON = 1.0E-10f;
    private /* synthetic */ PointList poly;
    private /* synthetic */ PointList tris;

    public float[] getPolyPoint(int llllllllllllllllllIlIIlllIIIllII) {
        BasicTriangulator llllllllllllllllllIlIIlllIIIlIll;
        return new float[]{llllllllllllllllllIlIIlllIIIlIll.poly.get(llllllllllllllllllIlIIlllIIIllII).x, llllllllllllllllllIlIIlllIIIlIll.poly.get(llllllllllllllllllIlIIlllIIIllII).y};
    }

    @Override
    public int getTriangleCount() {
        BasicTriangulator llllllllllllllllllIlIIllIllllIII;
        if (!llllllllllllllllllIlIIllIllllIII.tried) {
            throw new RuntimeException("Call triangulate() before accessing triangles");
        }
        return llllllllllllllllllIlIIllIllllIII.tris.size() / 3;
    }

    @Override
    public float[] getTrianglePoint(int llllllllllllllllllIlIIllIlllIIll, int llllllllllllllllllIlIIllIlllIIlI) {
        BasicTriangulator llllllllllllllllllIlIIllIlllIIIl;
        if (!llllllllllllllllllIlIIllIlllIIIl.tried) {
            throw new RuntimeException("Call triangulate() before accessing triangles");
        }
        return llllllllllllllllllIlIIllIlllIIIl.tris.get(llllllllllllllllllIlIIllIlllIIll * 3 + llllllllllllllllllIlIIllIlllIIlI).toArray();
    }

    @Override
    public boolean triangulate() {
        BasicTriangulator llllllllllllllllllIlIIlllIIIIlll;
        llllllllllllllllllIlIIlllIIIIlll.tried = true;
        boolean llllllllllllllllllIlIIlllIIIIllI = llllllllllllllllllIlIIlllIIIIlll.process(llllllllllllllllllIlIIlllIIIIlll.poly, llllllllllllllllllIlIIlllIIIIlll.tris);
        return llllllllllllllllllIlIIlllIIIIllI;
    }

    @Override
    public void addPolyPoint(float llllllllllllllllllIlIIlllIllIIlI, float llllllllllllllllllIlIIlllIlIlIII) {
        BasicTriangulator llllllllllllllllllIlIIlllIlIllII;
        Point llllllllllllllllllIlIIlllIlIlllI = llllllllllllllllllIlIIlllIlIllII.new Point(llllllllllllllllllIlIIlllIllIIlI, llllllllllllllllllIlIIlllIlIlIII);
        if (!llllllllllllllllllIlIIlllIlIllII.poly.contains(llllllllllllllllllIlIIlllIlIlllI)) {
            llllllllllllllllllIlIIlllIlIllII.poly.add(llllllllllllllllllIlIIlllIlIlllI);
        }
    }

    private boolean snip(PointList llllllllllllllllllIlIIlIIllllIll, int llllllllllllllllllIlIIlIIllIllII, int llllllllllllllllllIlIIlIIllllIIl, int llllllllllllllllllIlIIlIIllIlIlI, int llllllllllllllllllIlIIlIIllIlIIl, int[] llllllllllllllllllIlIIlIIllIlIII) {
        float llllllllllllllllllIlIIlIIlllIlII = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIllIllII]).getX();
        float llllllllllllllllllIlIIlIIlllIIll = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIllIllII]).getY();
        float llllllllllllllllllIlIIlIIlllIIlI = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIllllIIl]).getX();
        float llllllllllllllllllIlIIlIIlllIIIl = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIllllIIl]).getY();
        float llllllllllllllllllIlIIlIIlllIIII = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIllIlIlI]).getX();
        float llllllllllllllllllIlIIlIIllIllll = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIllIlIlI]).getY();
        if (1.0E-10f > (llllllllllllllllllIlIIlIIlllIIlI - llllllllllllllllllIlIIlIIlllIlII) * (llllllllllllllllllIlIIlIIllIllll - llllllllllllllllllIlIIlIIlllIIll) - (llllllllllllllllllIlIIlIIlllIIIl - llllllllllllllllllIlIIlIIlllIIll) * (llllllllllllllllllIlIIlIIlllIIII - llllllllllllllllllIlIIlIIlllIlII)) {
            return false;
        }
        for (int llllllllllllllllllIlIIlIIlllIlIl = 0; llllllllllllllllllIlIIlIIlllIlIl < llllllllllllllllllIlIIlIIllIlIIl; ++llllllllllllllllllIlIIlIIlllIlIl) {
            float llllllllllllllllllIlIIlIIlllllIl;
            float llllllllllllllllllIlIIlIIllllllI;
            BasicTriangulator llllllllllllllllllIlIIlIIllIlllI;
            if (llllllllllllllllllIlIIlIIlllIlIl == llllllllllllllllllIlIIlIIllIllII || llllllllllllllllllIlIIlIIlllIlIl == llllllllllllllllllIlIIlIIllllIIl || llllllllllllllllllIlIIlIIlllIlIl == llllllllllllllllllIlIIlIIllIlIlI || !llllllllllllllllllIlIIlIIllIlllI.insideTriangle(llllllllllllllllllIlIIlIIlllIlII, llllllllllllllllllIlIIlIIlllIIll, llllllllllllllllllIlIIlIIlllIIlI, llllllllllllllllllIlIIlIIlllIIIl, llllllllllllllllllIlIIlIIlllIIII, llllllllllllllllllIlIIlIIllIllll, llllllllllllllllllIlIIlIIllllllI = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIlllIlIl]).getX(), llllllllllllllllllIlIIlIIlllllIl = llllllllllllllllllIlIIlIIllllIll.get(llllllllllllllllllIlIIlIIllIlIII[llllllllllllllllllIlIIlIIlllIlIl]).getY())) continue;
            return false;
        }
        return true;
    }

    public int getPolyPointCount() {
        BasicTriangulator llllllllllllllllllIlIIlllIIllIlI;
        return llllllllllllllllllIlIIlllIIllIlI.poly.size();
    }

    private float area(PointList llllllllllllllllllIlIIllIlIlIIII) {
        int llllllllllllllllllIlIIllIlIIllll = llllllllllllllllllIlIIllIlIlIIII.size();
        float llllllllllllllllllIlIIllIlIIllIl = 0.0f;
        int llllllllllllllllllIlIIllIlIlIIll = llllllllllllllllllIlIIllIlIIllll - 1;
        int llllllllllllllllllIlIIllIlIlIIlI = 0;
        while (llllllllllllllllllIlIIllIlIlIIlI < llllllllllllllllllIlIIllIlIIllll) {
            Point llllllllllllllllllIlIIllIlIlIlll = llllllllllllllllllIlIIllIlIlIIII.get(llllllllllllllllllIlIIllIlIlIIll);
            Point llllllllllllllllllIlIIllIlIlIlII = llllllllllllllllllIlIIllIlIlIIII.get(llllllllllllllllllIlIIllIlIlIIlI);
            llllllllllllllllllIlIIllIlIIllIl += llllllllllllllllllIlIIllIlIlIlll.getX() * llllllllllllllllllIlIIllIlIlIlII.getY() - llllllllllllllllllIlIIllIlIlIlII.getX() * llllllllllllllllllIlIIllIlIlIlll.getY();
            llllllllllllllllllIlIIllIlIlIIll = llllllllllllllllllIlIIllIlIlIIlI++;
        }
        return llllllllllllllllllIlIIllIlIIllIl * 0.5f;
    }

    @Override
    public void startHole() {
    }

    private boolean process(PointList llllllllllllllllllIlIIlIIIlIIIlI, PointList llllllllllllllllllIlIIlIIIlIlIII) {
        BasicTriangulator llllllllllllllllllIlIIlIIIlIlIlI;
        llllllllllllllllllIlIIlIIIlIlIII.clear();
        int llllllllllllllllllIlIIlIIIlIIlll = llllllllllllllllllIlIIlIIIlIIIlI.size();
        if (llllllllllllllllllIlIIlIIIlIIlll < 3) {
            return false;
        }
        int[] llllllllllllllllllIlIIlIIIlIIllI = new int[llllllllllllllllllIlIIlIIIlIIlll];
        if (0.0f < llllllllllllllllllIlIIlIIIlIlIlI.area(llllllllllllllllllIlIIlIIIlIIIlI)) {
            for (int llllllllllllllllllIlIIlIIIllIlIl = 0; llllllllllllllllllIlIIlIIIllIlIl < llllllllllllllllllIlIIlIIIlIIlll; ++llllllllllllllllllIlIIlIIIllIlIl) {
                llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIllIlIl] = llllllllllllllllllIlIIlIIIllIlIl;
            }
        } else {
            for (int llllllllllllllllllIlIIlIIIllIlII = 0; llllllllllllllllllIlIIlIIIllIlII < llllllllllllllllllIlIIlIIIlIIlll; ++llllllllllllllllllIlIIlIIIllIlII) {
                llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIllIlII] = llllllllllllllllllIlIIlIIIlIIlll - 1 - llllllllllllllllllIlIIlIIIllIlII;
            }
        }
        int llllllllllllllllllIlIIlIIIlIIlIl = llllllllllllllllllIlIIlIIIlIIlll;
        int llllllllllllllllllIlIIlIIIlIIlII = 2 * llllllllllllllllllIlIIlIIIlIIlIl;
        int llllllllllllllllllIlIIlIIIlIllII = 0;
        int llllllllllllllllllIlIIlIIIlIlIll = llllllllllllllllllIlIIlIIIlIIlIl - 1;
        while (llllllllllllllllllIlIIlIIIlIIlIl > 2) {
            int llllllllllllllllllIlIIlIIIlIllIl;
            if (0 >= llllllllllllllllllIlIIlIIIlIIlII--) {
                return false;
            }
            int llllllllllllllllllIlIIlIIIlIlllI = llllllllllllllllllIlIIlIIIlIlIll;
            if (llllllllllllllllllIlIIlIIIlIIlIl <= llllllllllllllllllIlIIlIIIlIlllI) {
                llllllllllllllllllIlIIlIIIlIlllI = 0;
            }
            if (llllllllllllllllllIlIIlIIIlIIlIl <= (llllllllllllllllllIlIIlIIIlIlIll = llllllllllllllllllIlIIlIIIlIlllI + 1)) {
                llllllllllllllllllIlIIlIIIlIlIll = 0;
            }
            if (llllllllllllllllllIlIIlIIIlIIlIl <= (llllllllllllllllllIlIIlIIIlIllIl = llllllllllllllllllIlIIlIIIlIlIll + 1)) {
                llllllllllllllllllIlIIlIIIlIllIl = 0;
            }
            if (!llllllllllllllllllIlIIlIIIlIlIlI.snip(llllllllllllllllllIlIIlIIIlIIIlI, llllllllllllllllllIlIIlIIIlIlllI, llllllllllllllllllIlIIlIIIlIlIll, llllllllllllllllllIlIIlIIIlIllIl, llllllllllllllllllIlIIlIIIlIIlIl, llllllllllllllllllIlIIlIIIlIIllI)) continue;
            int llllllllllllllllllIlIIlIIIllIIll = llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIlIlllI];
            int llllllllllllllllllIlIIlIIIllIIlI = llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIlIlIll];
            int llllllllllllllllllIlIIlIIIllIIIl = llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIlIllIl];
            llllllllllllllllllIlIIlIIIlIlIII.add(llllllllllllllllllIlIIlIIIlIIIlI.get(llllllllllllllllllIlIIlIIIllIIll));
            llllllllllllllllllIlIIlIIIlIlIII.add(llllllllllllllllllIlIIlIIIlIIIlI.get(llllllllllllllllllIlIIlIIIllIIlI));
            llllllllllllllllllIlIIlIIIlIlIII.add(llllllllllllllllllIlIIlIIIlIIIlI.get(llllllllllllllllllIlIIlIIIllIIIl));
            ++llllllllllllllllllIlIIlIIIlIllII;
            int llllllllllllllllllIlIIlIIIllIIII = llllllllllllllllllIlIIlIIIlIlIll;
            for (int llllllllllllllllllIlIIlIIIlIllll = llllllllllllllllllIlIIlIIIlIlIll + 1; llllllllllllllllllIlIIlIIIlIllll < llllllllllllllllllIlIIlIIIlIIlIl; ++llllllllllllllllllIlIIlIIIlIllll) {
                llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIllIIII] = llllllllllllllllllIlIIlIIIlIIllI[llllllllllllllllllIlIIlIIIlIllll];
                ++llllllllllllllllllIlIIlIIIllIIII;
            }
            llllllllllllllllllIlIIlIIIlIIlII = 2 * --llllllllllllllllllIlIIlIIIlIIlIl;
        }
        return true;
    }

    private boolean insideTriangle(float llllllllllllllllllIlIIlIllIlIlll, float llllllllllllllllllIlIIlIllIlIllI, float llllllllllllllllllIlIIlIllllIllI, float llllllllllllllllllIlIIlIllllIlIl, float llllllllllllllllllIlIIlIllIlIIll, float llllllllllllllllllIlIIlIllllIIIl, float llllllllllllllllllIlIIlIllIlIIIl, float llllllllllllllllllIlIIlIlllIllIl) {
        float llllllllllllllllllIlIIlIlllIlIll = llllllllllllllllllIlIIlIllIlIIll - llllllllllllllllllIlIIlIllllIllI;
        float llllllllllllllllllIlIIlIlllIlIIl = llllllllllllllllllIlIIlIllllIIIl - llllllllllllllllllIlIIlIllllIlIl;
        float llllllllllllllllllIlIIlIlllIIlll = llllllllllllllllllIlIIlIllIlIlll - llllllllllllllllllIlIIlIllIlIIll;
        float llllllllllllllllllIlIIlIlllIIlIl = llllllllllllllllllIlIIlIllIlIllI - llllllllllllllllllIlIIlIllllIIIl;
        float llllllllllllllllllIlIIlIlllIIIll = llllllllllllllllllIlIIlIllllIllI - llllllllllllllllllIlIIlIllIlIlll;
        float llllllllllllllllllIlIIlIlllIIIIl = llllllllllllllllllIlIIlIllllIlIl - llllllllllllllllllIlIIlIllIlIllI;
        float llllllllllllllllllIlIIlIlllIIIII = llllllllllllllllllIlIIlIllIlIIIl - llllllllllllllllllIlIIlIllIlIlll;
        float llllllllllllllllllIlIIlIllIlllll = llllllllllllllllllIlIIlIlllIllIl - llllllllllllllllllIlIIlIllIlIllI;
        float llllllllllllllllllIlIIlIllIllllI = llllllllllllllllllIlIIlIllIlIIIl - llllllllllllllllllIlIIlIllllIllI;
        float llllllllllllllllllIlIIlIllIlllIl = llllllllllllllllllIlIIlIlllIllIl - llllllllllllllllllIlIIlIllllIlIl;
        float llllllllllllllllllIlIIlIllIlllII = llllllllllllllllllIlIIlIllIlIIIl - llllllllllllllllllIlIIlIllIlIIll;
        float llllllllllllllllllIlIIlIllIllIll = llllllllllllllllllIlIIlIlllIllIl - llllllllllllllllllIlIIlIllllIIIl;
        float llllllllllllllllllIlIIlIllIllIII = llllllllllllllllllIlIIlIlllIlIll * llllllllllllllllllIlIIlIllIlllIl - llllllllllllllllllIlIIlIlllIlIIl * llllllllllllllllllIlIIlIllIllllI;
        float llllllllllllllllllIlIIlIllIllIlI = llllllllllllllllllIlIIlIlllIIIll * llllllllllllllllllIlIIlIllIlllll - llllllllllllllllllIlIIlIlllIIIIl * llllllllllllllllllIlIIlIlllIIIII;
        float llllllllllllllllllIlIIlIllIllIIl = llllllllllllllllllIlIIlIlllIIlll * llllllllllllllllllIlIIlIllIllIll - llllllllllllllllllIlIIlIlllIIlIl * llllllllllllllllllIlIIlIllIlllII;
        return llllllllllllllllllIlIIlIllIllIII >= 0.0f && llllllllllllllllllIlIIlIllIllIIl >= 0.0f && llllllllllllllllllIlIIlIllIllIlI >= 0.0f;
    }

    public BasicTriangulator() {
        BasicTriangulator llllllllllllllllllIlIIllllIIIllI;
        llllllllllllllllllIlIIllllIIIllI.poly = llllllllllllllllllIlIIllllIIIllI.new PointList();
        llllllllllllllllllIlIIllllIIIllI.tris = llllllllllllllllllIlIIllllIIIllI.new PointList();
    }

    private class PointList {
        private /* synthetic */ ArrayList points;

        public void add(Point llllllllllllllllIIlIlllIlllllIlI) {
            PointList llllllllllllllllIIlIlllIlllllIIl;
            llllllllllllllllIIlIlllIlllllIIl.points.add(llllllllllllllllIIlIlllIlllllIlI);
        }

        public PointList() {
            PointList llllllllllllllllIIlIllllIIIIIlIl;
            llllllllllllllllIIlIllllIIIIIlIl.points = new ArrayList();
        }

        public int size() {
            PointList llllllllllllllllIIlIlllIlllIllll;
            return llllllllllllllllIIlIlllIlllIllll.points.size();
        }

        public void clear() {
            PointList llllllllllllllllIIlIlllIlllIIlll;
            llllllllllllllllIIlIlllIlllIIlll.points.clear();
        }

        public boolean contains(Point llllllllllllllllIIlIlllIlllllllI) {
            PointList llllllllllllllllIIlIllllIIIIIIIl;
            return llllllllllllllllIIlIllllIIIIIIIl.points.contains(llllllllllllllllIIlIlllIlllllllI);
        }

        public Point get(int llllllllllllllllIIlIlllIlllIlIIl) {
            PointList llllllllllllllllIIlIlllIlllIlIlI;
            return (Point)llllllllllllllllIIlIlllIlllIlIlI.points.get(llllllllllllllllIIlIlllIlllIlIIl);
        }

        public void remove(Point llllllllllllllllIIlIlllIllllIIlI) {
            PointList llllllllllllllllIIlIlllIllllIIll;
            llllllllllllllllIIlIlllIllllIIll.points.remove(llllllllllllllllIIlIlllIllllIIlI);
        }
    }

    private class Point {
        private /* synthetic */ float x;
        private /* synthetic */ float y;
        private /* synthetic */ float[] array;

        public int hashCode() {
            Point lIIIIIIlIIIIIlI;
            return (int)(lIIIIIIlIIIIIlI.x * lIIIIIIlIIIIIlI.y * 31.0f);
        }

        public Point(float lIIIIIIlIIlIIll, float lIIIIIIlIIlIIlI) {
            Point lIIIIIIlIIlIlII;
            lIIIIIIlIIlIlII.x = lIIIIIIlIIlIIll;
            lIIIIIIlIIlIlII.y = lIIIIIIlIIlIIlI;
            lIIIIIIlIIlIlII.array = new float[]{lIIIIIIlIIlIIll, lIIIIIIlIIlIIlI};
        }

        public float[] toArray() {
            Point lIIIIIIlIIIIllI;
            return lIIIIIIlIIIIllI.array;
        }

        public boolean equals(Object lIIIIIIIlllllII) {
            if (lIIIIIIIlllllII instanceof Point) {
                Point lIIIIIIIlllllIl;
                Point lIIIIIIIllllllI = (Point)lIIIIIIIlllllII;
                return lIIIIIIIllllllI.x == lIIIIIIIlllllIl.x && lIIIIIIIllllllI.y == lIIIIIIIlllllIl.y;
            }
            return false;
        }

        public float getX() {
            Point lIIIIIIlIIIllII;
            return lIIIIIIlIIIllII.x;
        }

        public float getY() {
            Point lIIIIIIlIIIlIIl;
            return lIIIIIIlIIIlIIl.y;
        }
    }
}

