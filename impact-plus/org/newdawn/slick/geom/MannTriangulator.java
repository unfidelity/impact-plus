/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.geom.Triangulator;
import org.newdawn.slick.geom.Vector2f;

public class MannTriangulator
implements Triangulator {
    private /* synthetic */ Point nextFreePoint;
    protected /* synthetic */ PointBag contour;
    private /* synthetic */ List triangles;
    protected /* synthetic */ PointBag holes;
    private /* synthetic */ PointBag nextFreePointBag;
    private static final /* synthetic */ double EPSILON = 1.0E-5;

    public MannTriangulator() {
        MannTriangulator llllllllllllllllllllIlllIllIIlll;
        llllllllllllllllllllIlllIllIIlll.triangles = new ArrayList();
        llllllllllllllllllllIlllIllIIlll.contour = llllllllllllllllllllIlllIllIIlll.getPointBag();
    }

    private PointBag getPointBag() {
        MannTriangulator llllllllllllllllllllIllIlllIIlIl;
        PointBag llllllllllllllllllllIllIlllIIllI = llllllllllllllllllllIllIlllIIlIl.nextFreePointBag;
        if (llllllllllllllllllllIllIlllIIllI != null) {
            llllllllllllllllllllIllIlllIIlIl.nextFreePointBag = llllllllllllllllllllIllIlllIIllI.next;
            llllllllllllllllllllIllIlllIIllI.next = null;
            return llllllllllllllllllllIllIlllIIllI;
        }
        return llllllllllllllllllllIllIlllIIlIl.new PointBag();
    }

    @Override
    public boolean triangulate() {
        MannTriangulator llllllllllllllllllllIllIllIIIIII;
        Vector2f[] llllllllllllllllllllIllIlIllllll = llllllllllllllllllllIllIllIIIIII.triangulate(new Vector2f[0]);
        for (int llllllllllllllllllllIllIllIIIIIl = 0; llllllllllllllllllllIllIllIIIIIl < llllllllllllllllllllIllIlIllllll.length && llllllllllllllllllllIllIlIllllll[llllllllllllllllllllIllIllIIIIIl] != null; ++llllllllllllllllllllIllIllIIIIIl) {
            llllllllllllllllllllIllIllIIIIII.triangles.add(llllllllllllllllllllIllIlIllllll[llllllllllllllllllllIllIllIIIIIl]);
        }
        return true;
    }

    private PointBag freePointBag(PointBag llllllllllllllllllllIllIllIllllI) {
        MannTriangulator llllllllllllllllllllIllIllIlllII;
        PointBag llllllllllllllllllllIllIllIlllIl = llllllllllllllllllllIllIllIllllI.next;
        llllllllllllllllllllIllIllIllllI.clear();
        llllllllllllllllllllIllIllIllllI.next = llllllllllllllllllllIllIllIlllII.nextFreePointBag;
        llllllllllllllllllllIllIllIlllII.nextFreePointBag = llllllllllllllllllllIllIllIllllI;
        return llllllllllllllllllllIllIllIlllIl;
    }

    private void freePoint(Point llllllllllllllllllllIllIllIIllIl) {
        MannTriangulator llllllllllllllllllllIllIllIIlllI;
        llllllllllllllllllllIllIllIIllIl.next = llllllllllllllllllllIllIllIIlllI.nextFreePoint;
        llllllllllllllllllllIllIllIIlllI.nextFreePoint = llllllllllllllllllllIllIllIIllIl;
    }

    @Override
    public int getTriangleCount() {
        MannTriangulator llllllllllllllllllllIllIlIlllIlI;
        return llllllllllllllllllllIllIlIlllIlI.triangles.size() / 3;
    }

    @Override
    public float[] getTrianglePoint(int llllllllllllllllllllIllIlIllIIll, int llllllllllllllllllllIllIlIllIIlI) {
        MannTriangulator llllllllllllllllllllIllIlIllIIII;
        Vector2f llllllllllllllllllllIllIlIllIIIl = (Vector2f)llllllllllllllllllllIllIlIllIIII.triangles.get(llllllllllllllllllllIllIlIllIIll * 3 + llllllllllllllllllllIllIlIllIIlI);
        return new float[]{llllllllllllllllllllIllIlIllIIIl.x, llllllllllllllllllllIllIlIllIIIl.y};
    }

    private void freePoints(Point llllllllllllllllllllIllIllIIIlll) {
        MannTriangulator llllllllllllllllllllIllIllIIIllI;
        llllllllllllllllllllIllIllIIIlll.prev.next = llllllllllllllllllllIllIllIIIllI.nextFreePoint;
        llllllllllllllllllllIllIllIIIlll.prev = null;
        llllllllllllllllllllIllIllIIIllI.nextFreePoint = llllllllllllllllllllIllIllIIIlll;
    }

    public void reset() {
        MannTriangulator llllllllllllllllllllIlllIlIlllII;
        while (llllllllllllllllllllIlllIlIlllII.holes != null) {
            llllllllllllllllllllIlllIlIlllII.holes = llllllllllllllllllllIlllIlIlllII.freePointBag(llllllllllllllllllllIlllIlIlllII.holes);
        }
        llllllllllllllllllllIlllIlIlllII.contour.clear();
        llllllllllllllllllllIlllIlIlllII.holes = null;
    }

    @Override
    public void startHole() {
        MannTriangulator llllllllllllllllllllIlllIlIIllll;
        PointBag llllllllllllllllllllIlllIlIlIIII = llllllllllllllllllllIlllIlIIllll.getPointBag();
        llllllllllllllllllllIlllIlIlIIII.next = llllllllllllllllllllIlllIlIIllll.holes;
        llllllllllllllllllllIlllIlIIllll.holes = llllllllllllllllllllIlllIlIlIIII;
    }

    private void addPoint(Vector2f llllllllllllllllllllIlllIIllIlII) {
        MannTriangulator llllllllllllllllllllIlllIIllIlll;
        if (llllllllllllllllllllIlllIIllIlll.holes == null) {
            Point llllllllllllllllllllIlllIIlllIIl = llllllllllllllllllllIlllIIllIlll.getPoint(llllllllllllllllllllIlllIIllIlII);
            llllllllllllllllllllIlllIIllIlll.contour.add(llllllllllllllllllllIlllIIlllIIl);
        } else {
            Point llllllllllllllllllllIlllIIlllIII = llllllllllllllllllllIlllIIllIlll.getPoint(llllllllllllllllllllIlllIIllIlII);
            llllllllllllllllllllIlllIIllIlll.holes.add(llllllllllllllllllllIlllIIlllIII);
        }
    }

    private Vector2f[] triangulate(Vector2f[] llllllllllllllllllllIllIllllllII) {
        Point llllllllllllllllllllIlllIIIIIIIl;
        MannTriangulator llllllllllllllllllllIllIllllllIl;
        llllllllllllllllllllIllIllllllIl.contour.computeAngles();
        PointBag llllllllllllllllllllIlllIIIIlIll = llllllllllllllllllllIllIllllllIl.holes;
        while (llllllllllllllllllllIlllIIIIlIll != null) {
            llllllllllllllllllllIlllIIIIlIll.computeAngles();
            llllllllllllllllllllIlllIIIIlIll = llllllllllllllllllllIlllIIIIlIll.next;
        }
        while (llllllllllllllllllllIllIllllllIl.holes != null) {
            Point llllllllllllllllllllIlllIIIIIlIl = llllllllllllllllllllIllIllllllIl.holes.first;
            block2: do {
                if (!(llllllllllllllllllllIlllIIIIIlIl.angle <= 0.0)) continue;
                Point llllllllllllllllllllIlllIIIIIllI = llllllllllllllllllllIllIllllllIl.contour.first;
                do {
                    if (!llllllllllllllllllllIlllIIIIIlIl.isInfront(llllllllllllllllllllIlllIIIIIllI) || !llllllllllllllllllllIlllIIIIIllI.isInfront(llllllllllllllllllllIlllIIIIIlIl) || llllllllllllllllllllIllIllllllIl.contour.doesIntersectSegment(llllllllllllllllllllIlllIIIIIlIl.pt, llllllllllllllllllllIlllIIIIIllI.pt)) continue;
                    PointBag llllllllllllllllllllIlllIIIIlIIl = llllllllllllllllllllIllIllllllIl.holes;
                    while (!llllllllllllllllllllIlllIIIIlIIl.doesIntersectSegment(llllllllllllllllllllIlllIIIIIlIl.pt, llllllllllllllllllllIlllIIIIIllI.pt)) {
                        llllllllllllllllllllIlllIIIIlIIl = llllllllllllllllllllIlllIIIIlIIl.next;
                        if (llllllllllllllllllllIlllIIIIlIIl != null) continue;
                        Point llllllllllllllllllllIlllIIIIlIII = llllllllllllllllllllIllIllllllIl.getPoint(llllllllllllllllllllIlllIIIIIllI.pt);
                        llllllllllllllllllllIlllIIIIIllI.insertAfter(llllllllllllllllllllIlllIIIIlIII);
                        Point llllllllllllllllllllIlllIIIIIlll = llllllllllllllllllllIllIllllllIl.getPoint(llllllllllllllllllllIlllIIIIIlIl.pt);
                        llllllllllllllllllllIlllIIIIIlIl.insertBefore(llllllllllllllllllllIlllIIIIIlll);
                        llllllllllllllllllllIlllIIIIIllI.next = llllllllllllllllllllIlllIIIIIlIl;
                        llllllllllllllllllllIlllIIIIIlIl.prev = llllllllllllllllllllIlllIIIIIllI;
                        llllllllllllllllllllIlllIIIIIlll.next = llllllllllllllllllllIlllIIIIlIII;
                        llllllllllllllllllllIlllIIIIlIII.prev = llllllllllllllllllllIlllIIIIIlll;
                        llllllllllllllllllllIlllIIIIIllI.computeAngle();
                        llllllllllllllllllllIlllIIIIIlIl.computeAngle();
                        llllllllllllllllllllIlllIIIIlIII.computeAngle();
                        llllllllllllllllllllIlllIIIIIlll.computeAngle();
                        llllllllllllllllllllIllIllllllIl.holes.first = null;
                        break block2;
                    }
                } while ((llllllllllllllllllllIlllIIIIIllI = llllllllllllllllllllIlllIIIIIllI.next) != llllllllllllllllllllIllIllllllIl.contour.first);
            } while ((llllllllllllllllllllIlllIIIIIlIl = llllllllllllllllllllIlllIIIIIlIl.next) != llllllllllllllllllllIllIllllllIl.holes.first);
            llllllllllllllllllllIllIllllllIl.holes = llllllllllllllllllllIllIllllllIl.freePointBag(llllllllllllllllllllIllIllllllIl.holes);
        }
        int llllllllllllllllllllIllIlllllIll = llllllllllllllllllllIllIllllllIl.contour.countPoints() - 2;
        int llllllllllllllllllllIllIlllllIIl = llllllllllllllllllllIllIlllllIll * 3 + 1;
        if (llllllllllllllllllllIllIllllllII.length < llllllllllllllllllllIllIlllllIIl) {
            llllllllllllllllllllIllIllllllII = (Vector2f[])Array.newInstance(llllllllllllllllllllIllIllllllII.getClass().getComponentType(), llllllllllllllllllllIllIlllllIIl);
        }
        int llllllllllllllllllllIllIllllIlll = 0;
        while ((llllllllllllllllllllIlllIIIIIIIl = llllllllllllllllllllIllIllllllIl.contour.first) != null && llllllllllllllllllllIlllIIIIIIIl.next != llllllllllllllllllllIlllIIIIIIIl.prev) {
            do {
                if (!(llllllllllllllllllllIlllIIIIIIIl.angle > 0.0)) continue;
                Point llllllllllllllllllllIlllIIIIIlII = llllllllllllllllllllIlllIIIIIIIl.prev;
                Point llllllllllllllllllllIlllIIIIIIll = llllllllllllllllllllIlllIIIIIIIl.next;
                if (llllllllllllllllllllIlllIIIIIIll.next != llllllllllllllllllllIlllIIIIIlII && (!llllllllllllllllllllIlllIIIIIlII.isInfront(llllllllllllllllllllIlllIIIIIIll) || !llllllllllllllllllllIlllIIIIIIll.isInfront(llllllllllllllllllllIlllIIIIIlII)) || llllllllllllllllllllIllIllllllIl.contour.doesIntersectSegment(llllllllllllllllllllIlllIIIIIlII.pt, llllllllllllllllllllIlllIIIIIIll.pt)) continue;
                llllllllllllllllllllIllIllllllII[llllllllllllllllllllIllIllllIlll++] = llllllllllllllllllllIlllIIIIIIIl.pt;
                llllllllllllllllllllIllIllllllII[llllllllllllllllllllIllIllllIlll++] = llllllllllllllllllllIlllIIIIIIll.pt;
                llllllllllllllllllllIllIllllllII[llllllllllllllllllllIllIllllIlll++] = llllllllllllllllllllIlllIIIIIlII.pt;
                break;
            } while ((llllllllllllllllllllIlllIIIIIIIl = llllllllllllllllllllIlllIIIIIIIl.next) != llllllllllllllllllllIllIllllllIl.contour.first);
            Point llllllllllllllllllllIlllIIIIIIII = llllllllllllllllllllIlllIIIIIIIl.prev;
            Point llllllllllllllllllllIllIllllllll = llllllllllllllllllllIlllIIIIIIIl.next;
            llllllllllllllllllllIllIllllllIl.contour.first = llllllllllllllllllllIlllIIIIIIII;
            llllllllllllllllllllIlllIIIIIIIl.unlink();
            llllllllllllllllllllIllIllllllIl.freePoint(llllllllllllllllllllIlllIIIIIIIl);
            llllllllllllllllllllIllIllllllll.computeAngle();
            llllllllllllllllllllIlllIIIIIIII.computeAngle();
        }
        llllllllllllllllllllIllIllllllII[llllllllllllllllllllIllIllllIlll] = null;
        llllllllllllllllllllIllIllllllIl.contour.clear();
        return llllllllllllllllllllIllIllllllII;
    }

    @Override
    public void addPolyPoint(float llllllllllllllllllllIlllIllIIIlI, float llllllllllllllllllllIlllIlIllllI) {
        MannTriangulator llllllllllllllllllllIlllIllIIIII;
        llllllllllllllllllllIlllIllIIIII.addPoint(new Vector2f(llllllllllllllllllllIlllIllIIIlI, llllllllllllllllllllIlllIlIllllI));
    }

    private Point getPoint(Vector2f llllllllllllllllllllIllIllIlIIlI) {
        MannTriangulator llllllllllllllllllllIllIllIlIIll;
        Point llllllllllllllllllllIllIllIlIlII = llllllllllllllllllllIllIllIlIIll.nextFreePoint;
        if (llllllllllllllllllllIllIllIlIlII != null) {
            llllllllllllllllllllIllIllIlIIll.nextFreePoint = llllllllllllllllllllIllIllIlIlII.next;
            llllllllllllllllllllIllIllIlIlII.next = null;
            llllllllllllllllllllIllIllIlIlII.prev = null;
            llllllllllllllllllllIllIllIlIlII.pt = llllllllllllllllllllIllIllIlIIlI;
            return llllllllllllllllllllIllIllIlIlII;
        }
        return new Point(llllllllllllllllllllIllIllIlIIlI);
    }

    protected class PointBag
    implements Serializable {
        protected /* synthetic */ Point first;
        protected /* synthetic */ PointBag next;

        public void add(Point llllllllllllllllIlIlIIIIlIlIllll) {
            PointBag llllllllllllllllIlIlIIIIlIllIIlI;
            if (llllllllllllllllIlIlIIIIlIllIIlI.first != null) {
                llllllllllllllllIlIlIIIIlIllIIlI.first.insertBefore(llllllllllllllllIlIlIIIIlIlIllll);
            } else {
                llllllllllllllllIlIlIIIIlIllIIlI.first = llllllllllllllllIlIlIIIIlIlIllll;
                llllllllllllllllIlIlIIIIlIlIllll.next = llllllllllllllllIlIlIIIIlIlIllll;
                llllllllllllllllIlIlIIIIlIlIllll.prev = llllllllllllllllIlIlIIIIlIlIllll;
            }
        }

        protected PointBag() {
            PointBag llllllllllllllllIlIlIIIIlIlllIIl;
        }

        public void computeAngles() {
            PointBag llllllllllllllllIlIlIIIIlIlIlIlI;
            if (llllllllllllllllIlIlIIIIlIlIlIlI.first == null) {
                return;
            }
            Point llllllllllllllllIlIlIIIIlIlIlIll = llllllllllllllllIlIlIIIIlIlIlIlI.first;
            do {
                llllllllllllllllIlIlIIIIlIlIlIll.computeAngle();
            } while ((llllllllllllllllIlIlIIIIlIlIlIll = llllllllllllllllIlIlIIIIlIlIlIll.next) != llllllllllllllllIlIlIIIIlIlIlIlI.first);
        }

        public int countPoints() {
            PointBag llllllllllllllllIlIlIIIIIllllIII;
            if (llllllllllllllllIlIlIIIIIllllIII.first == null) {
                return 0;
            }
            int llllllllllllllllIlIlIIIIIllllIlI = 0;
            Point llllllllllllllllIlIlIIIIIllllIIl = llllllllllllllllIlIlIIIIIllllIII.first;
            do {
                ++llllllllllllllllIlIlIIIIIllllIlI;
            } while ((llllllllllllllllIlIlIIIIIllllIIl = llllllllllllllllIlIlIIIIIllllIIl.next) != llllllllllllllllIlIlIIIIIllllIII.first);
            return llllllllllllllllIlIlIIIIIllllIlI;
        }

        public void clear() {
            PointBag llllllllllllllllIlIlIIIIlIllIlIl;
            if (llllllllllllllllIlIlIIIIlIllIlIl.first != null) {
                llllllllllllllllIlIlIIIIlIllIlIl.MannTriangulator.this.freePoints(llllllllllllllllIlIlIIIIlIllIlIl.first);
                llllllllllllllllIlIlIIIIlIllIlIl.first = null;
            }
        }

        public boolean contains(Vector2f llllllllllllllllIlIlIIIIIlllIIII) {
            PointBag llllllllllllllllIlIlIIIIIlllIIll;
            if (llllllllllllllllIlIlIIIIIlllIIll.first == null) {
                return false;
            }
            if (llllllllllllllllIlIlIIIIIlllIIll.first.prev.pt.equals(llllllllllllllllIlIlIIIIIlllIIII)) {
                return true;
            }
            return llllllllllllllllIlIlIIIIIlllIIll.first.pt.equals(llllllllllllllllIlIlIIIIIlllIIII);
        }

        public boolean doesIntersectSegment(Vector2f llllllllllllllllIlIlIIIIlIIlIIII, Vector2f llllllllllllllllIlIlIIIIlIIIlIlI) {
            PointBag llllllllllllllllIlIlIIIIlIIIllII;
            double llllllllllllllllIlIlIIIIlIIIlllI = llllllllllllllllIlIlIIIIlIIIlIlI.x - llllllllllllllllIlIlIIIIlIIlIIII.x;
            double llllllllllllllllIlIlIIIIlIIIllIl = llllllllllllllllIlIlIIIIlIIIlIlI.y - llllllllllllllllIlIlIIIIlIIlIIII.y;
            Point llllllllllllllllIlIlIIIIlIIlIIlI = llllllllllllllllIlIlIIIIlIIIllII.first;
            while (true) {
                double llllllllllllllllIlIlIIIIlIIlIllI;
                double llllllllllllllllIlIlIIIIlIIlIlIl;
                double llllllllllllllllIlIlIIIIlIIlIlII;
                Point llllllllllllllllIlIlIIIIlIIlIIll = llllllllllllllllIlIlIIIIlIIlIIlI.next;
                if (llllllllllllllllIlIlIIIIlIIlIIlI.pt != llllllllllllllllIlIlIIIIlIIlIIII && llllllllllllllllIlIlIIIIlIIlIIll.pt != llllllllllllllllIlIlIIIIlIIlIIII && llllllllllllllllIlIlIIIIlIIlIIlI.pt != llllllllllllllllIlIlIIIIlIIIlIlI && llllllllllllllllIlIlIIIIlIIlIIll.pt != llllllllllllllllIlIlIIIIlIIIlIlI && Math.abs(llllllllllllllllIlIlIIIIlIIlIlII = llllllllllllllllIlIlIIIIlIIIlllI * (llllllllllllllllIlIlIIIIlIIlIlIl = (double)(llllllllllllllllIlIlIIIIlIIlIIll.pt.y - llllllllllllllllIlIlIIIIlIIlIIlI.pt.y)) - llllllllllllllllIlIlIIIIlIIIllIl * (llllllllllllllllIlIlIIIIlIIlIllI = (double)(llllllllllllllllIlIlIIIIlIIlIIll.pt.x - llllllllllllllllIlIlIIIIlIIlIIlI.pt.x))) > 1.0E-5) {
                    double llllllllllllllllIlIlIIIIlIIllIlI = llllllllllllllllIlIlIIIIlIIlIIlI.pt.x - llllllllllllllllIlIlIIIIlIIlIIII.x;
                    double llllllllllllllllIlIlIIIIlIIllIIl = llllllllllllllllIlIlIIIIlIIlIIlI.pt.y - llllllllllllllllIlIlIIIIlIIlIIII.y;
                    double llllllllllllllllIlIlIIIIlIIllIII = (llllllllllllllllIlIlIIIIlIIlIlIl * llllllllllllllllIlIlIIIIlIIllIlI - llllllllllllllllIlIlIIIIlIIlIllI * llllllllllllllllIlIlIIIIlIIllIIl) / llllllllllllllllIlIlIIIIlIIlIlII;
                    double llllllllllllllllIlIlIIIIlIIlIlll = (llllllllllllllllIlIlIIIIlIIIllIl * llllllllllllllllIlIlIIIIlIIllIlI - llllllllllllllllIlIlIIIIlIIIlllI * llllllllllllllllIlIlIIIIlIIllIIl) / llllllllllllllllIlIlIIIIlIIlIlII;
                    if (llllllllllllllllIlIlIIIIlIIllIII >= 0.0 && llllllllllllllllIlIlIIIIlIIllIII <= 1.0 && llllllllllllllllIlIlIIIIlIIlIlll >= 0.0 && llllllllllllllllIlIlIIIIlIIlIlll <= 1.0) {
                        return true;
                    }
                }
                if (llllllllllllllllIlIlIIIIlIIlIIll == llllllllllllllllIlIlIIIIlIIIllII.first) {
                    return false;
                }
                llllllllllllllllIlIlIIIIlIIlIIlI = llllllllllllllllIlIlIIIIlIIlIIll;
            }
        }
    }

    private static class Point
    implements Serializable {
        protected /* synthetic */ Vector2f pt;
        protected /* synthetic */ double angle;
        protected /* synthetic */ double ny;
        protected /* synthetic */ double nx;
        protected /* synthetic */ Point next;
        protected /* synthetic */ Point prev;
        protected /* synthetic */ double dist;

        public void insertAfter(Point lllllllllllllllllIlIIIIIlIlIllll) {
            Point lllllllllllllllllIlIIIIIlIllIIlI;
            lllllllllllllllllIlIIIIIlIllIIlI.next.prev = lllllllllllllllllIlIIIIIlIlIllll;
            lllllllllllllllllIlIIIIIlIlIllll.prev = lllllllllllllllllIlIIIIIlIllIIlI;
            lllllllllllllllllIlIIIIIlIlIllll.next = lllllllllllllllllIlIIIIIlIllIIlI.next;
            lllllllllllllllllIlIIIIIlIllIIlI.next = lllllllllllllllllIlIIIIIlIlIllll;
        }

        public void unlink() {
            Point lllllllllllllllllIlIIIIIlIllllII;
            lllllllllllllllllIlIIIIIlIllllII.prev.next = lllllllllllllllllIlIIIIIlIllllII.next;
            lllllllllllllllllIlIIIIIlIllllII.next.prev = lllllllllllllllllIlIIIIIlIllllII.prev;
            lllllllllllllllllIlIIIIIlIllllII.next = null;
            lllllllllllllllllIlIIIIIlIllllII.prev = null;
        }

        public boolean isInfront(Point lllllllllllllllllIlIIIIIIlIlIIII) {
            Point lllllllllllllllllIlIIIIIIlIlIIlI;
            return lllllllllllllllllIlIIIIIIlIlIIlI.isInfront(lllllllllllllllllIlIIIIIIlIlIIII.pt.x - lllllllllllllllllIlIIIIIIlIlIIlI.pt.x, lllllllllllllllllIlIIIIIIlIlIIII.pt.y - lllllllllllllllllIlIIIIIIlIlIIlI.pt.y);
        }

        public void computeAngle() {
            Point lllllllllllllllllIlIIIIIlIIllllI;
            if (lllllllllllllllllIlIIIIIlIIllllI.prev.pt.equals(lllllllllllllllllIlIIIIIlIIllllI.pt)) {
                lllllllllllllllllIlIIIIIlIIllllI.pt.x += 0.01f;
            }
            double lllllllllllllllllIlIIIIIlIIlllIl = lllllllllllllllllIlIIIIIlIIllllI.pt.x - lllllllllllllllllIlIIIIIlIIllllI.prev.pt.x;
            double lllllllllllllllllIlIIIIIlIIlllII = lllllllllllllllllIlIIIIIlIIllllI.pt.y - lllllllllllllllllIlIIIIIlIIllllI.prev.pt.y;
            double lllllllllllllllllIlIIIIIlIIllIll = lllllllllllllllllIlIIIIIlIIllllI.hypot(lllllllllllllllllIlIIIIIlIIlllIl, lllllllllllllllllIlIIIIIlIIlllII);
            lllllllllllllllllIlIIIIIlIIlllIl /= lllllllllllllllllIlIIIIIlIIllIll;
            lllllllllllllllllIlIIIIIlIIlllII /= lllllllllllllllllIlIIIIIlIIllIll;
            if (lllllllllllllllllIlIIIIIlIIllllI.next.pt.equals(lllllllllllllllllIlIIIIIlIIllllI.pt)) {
                lllllllllllllllllIlIIIIIlIIllllI.pt.y += 0.01f;
            }
            double lllllllllllllllllIlIIIIIlIIllIlI = lllllllllllllllllIlIIIIIlIIllllI.next.pt.x - lllllllllllllllllIlIIIIIlIIllllI.pt.x;
            double lllllllllllllllllIlIIIIIlIIllIIl = lllllllllllllllllIlIIIIIlIIllllI.next.pt.y - lllllllllllllllllIlIIIIIlIIllllI.pt.y;
            double lllllllllllllllllIlIIIIIlIIllIII = lllllllllllllllllIlIIIIIlIIllllI.hypot(lllllllllllllllllIlIIIIIlIIllIlI, lllllllllllllllllIlIIIIIlIIllIIl);
            double lllllllllllllllllIlIIIIIlIIlIlll = -lllllllllllllllllIlIIIIIlIIlllII;
            double lllllllllllllllllIlIIIIIlIIlIllI = lllllllllllllllllIlIIIIIlIIlllIl;
            lllllllllllllllllIlIIIIIlIIllllI.nx = (lllllllllllllllllIlIIIIIlIIlIlll - (lllllllllllllllllIlIIIIIlIIllIIl /= lllllllllllllllllIlIIIIIlIIllIII)) * 0.5;
            lllllllllllllllllIlIIIIIlIIllllI.ny = (lllllllllllllllllIlIIIIIlIIlIllI + (lllllllllllllllllIlIIIIIlIIllIlI /= lllllllllllllllllIlIIIIIlIIllIII)) * 0.5;
            if (lllllllllllllllllIlIIIIIlIIllllI.nx * lllllllllllllllllIlIIIIIlIIllllI.nx + lllllllllllllllllIlIIIIIlIIllllI.ny * lllllllllllllllllIlIIIIIlIIllllI.ny < 1.0E-5) {
                lllllllllllllllllIlIIIIIlIIllllI.nx = lllllllllllllllllIlIIIIIlIIlllIl;
                lllllllllllllllllIlIIIIIlIIllllI.ny = lllllllllllllllllIlIIIIIlIIllIIl;
                lllllllllllllllllIlIIIIIlIIllllI.angle = 1.0;
                if (lllllllllllllllllIlIIIIIlIIlllIl * lllllllllllllllllIlIIIIIlIIllIlI + lllllllllllllllllIlIIIIIlIIlllII * lllllllllllllllllIlIIIIIlIIllIIl > 0.0) {
                    lllllllllllllllllIlIIIIIlIIllllI.nx = -lllllllllllllllllIlIIIIIlIIlllIl;
                    lllllllllllllllllIlIIIIIlIIllllI.ny = -lllllllllllllllllIlIIIIIlIIlllII;
                }
            } else {
                lllllllllllllllllIlIIIIIlIIllllI.angle = lllllllllllllllllIlIIIIIlIIllllI.nx * lllllllllllllllllIlIIIIIlIIllIlI + lllllllllllllllllIlIIIIIlIIllllI.ny * lllllllllllllllllIlIIIIIlIIllIIl;
            }
        }

        public boolean isInfront(double lllllllllllllllllIlIIIIIIllIIIII, double lllllllllllllllllIlIIIIIIllIIlll) {
            Point lllllllllllllllllIlIIIIIIllIlIIl;
            boolean lllllllllllllllllIlIIIIIIllIIlIl = (double)(lllllllllllllllllIlIIIIIIllIlIIl.prev.pt.y - lllllllllllllllllIlIIIIIIllIlIIl.pt.y) * lllllllllllllllllIlIIIIIIllIIIII + (double)(lllllllllllllllllIlIIIIIIllIlIIl.pt.x - lllllllllllllllllIlIIIIIIllIlIIl.prev.pt.x) * lllllllllllllllllIlIIIIIIllIIlll >= 0.0;
            boolean lllllllllllllllllIlIIIIIIllIIIll = (double)(lllllllllllllllllIlIIIIIIllIlIIl.pt.y - lllllllllllllllllIlIIIIIIllIlIIl.next.pt.y) * lllllllllllllllllIlIIIIIIllIIIII + (double)(lllllllllllllllllIlIIIIIIllIlIIl.next.pt.x - lllllllllllllllllIlIIIIIIllIlIIl.pt.x) * lllllllllllllllllIlIIIIIIllIIlll >= 0.0;
            return lllllllllllllllllIlIIIIIIllIlIIl.angle < 0.0 ? lllllllllllllllllIlIIIIIIllIIlIl | lllllllllllllllllIlIIIIIIllIIIll : lllllllllllllllllIlIIIIIIllIIlIl & lllllllllllllllllIlIIIIIIllIIIll;
        }

        public Point(Vector2f lllllllllllllllllIlIIIIIlIlllllI) {
            Point lllllllllllllllllIlIIIIIllIIIIIl;
            lllllllllllllllllIlIIIIIllIIIIIl.pt = lllllllllllllllllIlIIIIIlIlllllI;
        }

        public void insertBefore(Point lllllllllllllllllIlIIIIIlIllIlll) {
            Point lllllllllllllllllIlIIIIIlIlllIII;
            lllllllllllllllllIlIIIIIlIlllIII.prev.next = lllllllllllllllllIlIIIIIlIllIlll;
            lllllllllllllllllIlIIIIIlIllIlll.prev = lllllllllllllllllIlIIIIIlIlllIII.prev;
            lllllllllllllllllIlIIIIIlIllIlll.next = lllllllllllllllllIlIIIIIlIlllIII;
            lllllllllllllllllIlIIIIIlIlllIII.prev = lllllllllllllllllIlIIIIIlIllIlll;
        }

        private double hypot(double lllllllllllllllllIlIIIIIlIlIlIll, double lllllllllllllllllIlIIIIIlIlIlIlI) {
            return Math.sqrt(lllllllllllllllllIlIIIIIlIlIlIll * lllllllllllllllllIlIIIIIlIlIlIll + lllllllllllllllllIlIIIIIlIlIlIlI * lllllllllllllllllIlIIIIIlIlIlIlI);
        }

        public double getAngle(Point lllllllllllllllllIlIIIIIlIIIIIIl) {
            Point lllllllllllllllllIlIIIIIlIIIIlll;
            double lllllllllllllllllIlIIIIIlIIIIlIl = lllllllllllllllllIlIIIIIlIIIIIIl.pt.x - lllllllllllllllllIlIIIIIlIIIIlll.pt.x;
            double lllllllllllllllllIlIIIIIlIIIIlII = lllllllllllllllllIlIIIIIlIIIIIIl.pt.y - lllllllllllllllllIlIIIIIlIIIIlll.pt.y;
            double lllllllllllllllllIlIIIIIlIIIIIll = lllllllllllllllllIlIIIIIlIIIIlll.hypot(lllllllllllllllllIlIIIIIlIIIIlIl, lllllllllllllllllIlIIIIIlIIIIlII);
            return (lllllllllllllllllIlIIIIIlIIIIlll.nx * lllllllllllllllllIlIIIIIlIIIIlIl + lllllllllllllllllIlIIIIIlIIIIlll.ny * lllllllllllllllllIlIIIIIlIIIIlII) / lllllllllllllllllIlIIIIIlIIIIIll;
        }

        public boolean isConcave() {
            Point lllllllllllllllllIlIIIIIIlllllII;
            return lllllllllllllllllIlIIIIIIlllllII.angle < 0.0;
        }
    }
}

