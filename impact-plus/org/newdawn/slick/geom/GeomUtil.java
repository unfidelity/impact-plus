/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import org.newdawn.slick.geom.GeomUtilListener;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

public class GeomUtil {
    public /* synthetic */ GeomUtilListener listener;
    public /* synthetic */ float EPSILON;
    public /* synthetic */ int MAX_POINTS;
    public /* synthetic */ float EDGE_SCALE;

    public Line getLine(Shape lIIIlIlIIllIlll, int lIIIlIlIIllIIII, int lIIIlIlIIllIlIl) {
        float[] lIIIlIlIIllIlII = lIIIlIlIIllIlll.getPoint(lIIIlIlIIllIIII);
        float[] lIIIlIlIIllIIll = lIIIlIlIIllIlll.getPoint(lIIIlIlIIllIlIl);
        Line lIIIlIlIIllIIlI = new Line(lIIIlIlIIllIlII[0], lIIIlIlIIllIlII[1], lIIIlIlIIllIIll[0], lIIIlIlIIllIIll[1]);
        return lIIIlIlIIllIIlI;
    }

    public Line getLine(Shape lIIIlIlIIIllllI, float lIIIlIlIIIlllIl, float lIIIlIlIIIlllII, int lIIIlIlIIIllIll) {
        float[] lIIIlIlIIlIIIII = lIIIlIlIIIllllI.getPoint(lIIIlIlIIIllIll);
        Line lIIIlIlIIIlllll = new Line(lIIIlIlIIIlllIl, lIIIlIlIIIlllII, lIIIlIlIIlIIIII[0], lIIIlIlIIlIIIII[1]);
        return lIIIlIlIIIlllll;
    }

    public Shape[] subtract(Shape lIIIllIIIIIIIlI, Shape lIIIllIIIIIIIIl) {
        GeomUtil lIIIllIIIIIIIll;
        lIIIllIIIIIIIlI = lIIIllIIIIIIIlI.transform(new Transform());
        lIIIllIIIIIIIIl = lIIIllIIIIIIIIl.transform(new Transform());
        int lIIIllIIIIIIlIl = 0;
        for (int lIIIllIIIIIlIll = 0; lIIIllIIIIIlIll < lIIIllIIIIIIIlI.getPointCount(); ++lIIIllIIIIIlIll) {
            if (!lIIIllIIIIIIIIl.contains(lIIIllIIIIIIIlI.getPoint(lIIIllIIIIIlIll)[0], lIIIllIIIIIIIlI.getPoint(lIIIllIIIIIlIll)[1])) continue;
            ++lIIIllIIIIIIlIl;
        }
        if (lIIIllIIIIIIlIl == lIIIllIIIIIIIlI.getPointCount()) {
            return new Shape[0];
        }
        if (!lIIIllIIIIIIIlI.intersects(lIIIllIIIIIIIIl)) {
            return new Shape[]{lIIIllIIIIIIIlI};
        }
        int lIIIllIIIIIIlII = 0;
        for (int lIIIllIIIIIlIlI = 0; lIIIllIIIIIlIlI < lIIIllIIIIIIIIl.getPointCount(); ++lIIIllIIIIIlIlI) {
            if (!lIIIllIIIIIIIlI.contains(lIIIllIIIIIIIIl.getPoint(lIIIllIIIIIlIlI)[0], lIIIllIIIIIIIIl.getPoint(lIIIllIIIIIlIlI)[1]) || lIIIllIIIIIIIll.onPath(lIIIllIIIIIIIlI, lIIIllIIIIIIIIl.getPoint(lIIIllIIIIIlIlI)[0], lIIIllIIIIIIIIl.getPoint(lIIIllIIIIIlIlI)[1])) continue;
            ++lIIIllIIIIIIlII;
        }
        for (int lIIIllIIIIIlIIl = 0; lIIIllIIIIIlIIl < lIIIllIIIIIIIlI.getPointCount(); ++lIIIllIIIIIlIIl) {
            if (!lIIIllIIIIIIIIl.contains(lIIIllIIIIIIIlI.getPoint(lIIIllIIIIIlIIl)[0], lIIIllIIIIIIIlI.getPoint(lIIIllIIIIIlIIl)[1]) || lIIIllIIIIIIIll.onPath(lIIIllIIIIIIIIl, lIIIllIIIIIIIlI.getPoint(lIIIllIIIIIlIIl)[0], lIIIllIIIIIIIlI.getPoint(lIIIllIIIIIlIIl)[1])) continue;
            ++lIIIllIIIIIIlII;
        }
        if (lIIIllIIIIIIlII < 1) {
            return new Shape[]{lIIIllIIIIIIIlI};
        }
        return lIIIllIIIIIIIll.combine(lIIIllIIIIIIIlI, lIIIllIIIIIIIIl, true);
    }

    public HitResult intersect(Shape lIIIlIlIlIIllIl, Line lIIIlIlIlIlIIIl) {
        float lIIIlIlIlIlIIII = Float.MAX_VALUE;
        HitResult lIIIlIlIlIIllll = null;
        for (int lIIIlIlIlIlIlII = 0; lIIIlIlIlIlIlII < lIIIlIlIlIIllIl.getPointCount(); ++lIIIlIlIlIlIlII) {
            float lIIIlIlIlIllIII;
            GeomUtil lIIIlIlIlIlIIll;
            int lIIIlIlIlIlIlll = GeomUtil.rationalPoint(lIIIlIlIlIIllIl, lIIIlIlIlIlIlII + 1);
            Line lIIIlIlIlIlIllI = lIIIlIlIlIlIIll.getLine(lIIIlIlIlIIllIl, lIIIlIlIlIlIlII, lIIIlIlIlIlIlll);
            Vector2f lIIIlIlIlIlIlIl = lIIIlIlIlIlIIIl.intersect(lIIIlIlIlIlIllI, true);
            if (lIIIlIlIlIlIlIl == null || !((lIIIlIlIlIllIII = lIIIlIlIlIlIlIl.distance(lIIIlIlIlIlIIIl.getStart())) < lIIIlIlIlIlIIII) || !(lIIIlIlIlIllIII > lIIIlIlIlIlIIll.EPSILON)) continue;
            lIIIlIlIlIIllll = lIIIlIlIlIlIIll.new HitResult();
            lIIIlIlIlIIllll.pt = lIIIlIlIlIlIlIl;
            lIIIlIlIlIIllll.line = lIIIlIlIlIlIllI;
            lIIIlIlIlIIllll.p1 = lIIIlIlIlIlIlII;
            lIIIlIlIlIIllll.p2 = lIIIlIlIlIlIlll;
            lIIIlIlIlIlIIII = lIIIlIlIlIllIII;
        }
        return lIIIlIlIlIIllll;
    }

    private boolean onPath(Shape lIIIlIllllIlllI, float lIIIlIllllIllIl, float lIIIlIllllIllII) {
        for (int lIIIlIlllllIlII = 0; lIIIlIlllllIlII < lIIIlIllllIlllI.getPointCount() + 1; ++lIIIlIlllllIlII) {
            GeomUtil lIIIlIlllllIIll;
            int lIIIlIlllllIllI = GeomUtil.rationalPoint(lIIIlIllllIlllI, lIIIlIlllllIlII + 1);
            Line lIIIlIlllllIlIl = lIIIlIlllllIIll.getLine(lIIIlIllllIlllI, GeomUtil.rationalPoint(lIIIlIllllIlllI, lIIIlIlllllIlII), lIIIlIlllllIllI);
            Vector2f vector2f = new Vector2f(lIIIlIllllIllIl, lIIIlIllllIllII);
            if (!(lIIIlIlllllIlIl.distance(vector2f) < lIIIlIlllllIIll.EPSILON * 100.0f)) continue;
            return true;
        }
        return false;
    }

    public Shape[] union(Shape lIIIlIlllIlIlII, Shape lIIIlIlllIlIIll) {
        GeomUtil lIIIlIlllIllIlI;
        if (!(lIIIlIlllIlIlII = lIIIlIlllIlIlII.transform(new Transform())).intersects(lIIIlIlllIlIIll = lIIIlIlllIlIIll.transform(new Transform()))) {
            return new Shape[]{lIIIlIlllIlIlII, lIIIlIlllIlIIll};
        }
        boolean lIIIlIlllIlIlll = false;
        int lIIIlIlllIlIllI = 0;
        for (int lIIIlIlllIlllII = 0; lIIIlIlllIlllII < lIIIlIlllIlIlII.getPointCount(); ++lIIIlIlllIlllII) {
            if (lIIIlIlllIlIIll.contains(lIIIlIlllIlIlII.getPoint(lIIIlIlllIlllII)[0], lIIIlIlllIlIlII.getPoint(lIIIlIlllIlllII)[1]) && !lIIIlIlllIlIIll.hasVertex(lIIIlIlllIlIlII.getPoint(lIIIlIlllIlllII)[0], lIIIlIlllIlIlII.getPoint(lIIIlIlllIlllII)[1])) {
                lIIIlIlllIlIlll = true;
                break;
            }
            if (!lIIIlIlllIlIIll.hasVertex(lIIIlIlllIlIlII.getPoint(lIIIlIlllIlllII)[0], lIIIlIlllIlIlII.getPoint(lIIIlIlllIlllII)[1])) continue;
            ++lIIIlIlllIlIllI;
        }
        for (int lIIIlIlllIllIll = 0; lIIIlIlllIllIll < lIIIlIlllIlIIll.getPointCount(); ++lIIIlIlllIllIll) {
            if (!lIIIlIlllIlIlII.contains(lIIIlIlllIlIIll.getPoint(lIIIlIlllIllIll)[0], lIIIlIlllIlIIll.getPoint(lIIIlIlllIllIll)[1]) || lIIIlIlllIlIlII.hasVertex(lIIIlIlllIlIIll.getPoint(lIIIlIlllIllIll)[0], lIIIlIlllIlIIll.getPoint(lIIIlIlllIllIll)[1])) continue;
            lIIIlIlllIlIlll = true;
            break;
        }
        if (!lIIIlIlllIlIlll && lIIIlIlllIlIllI < 2) {
            return new Shape[]{lIIIlIlllIlIlII, lIIIlIlllIlIIll};
        }
        return lIIIlIlllIllIlI.combine(lIIIlIlllIlIlII, lIIIlIlllIlIIll, false);
    }

    public GeomUtil() {
        GeomUtil lIIIllIIIIlIIll;
        lIIIllIIIIlIIll.EPSILON = 1.0E-4f;
        lIIIllIIIIlIIll.EDGE_SCALE = 1.0f;
        lIIIllIIIIlIIll.MAX_POINTS = 10000;
    }

    private Shape combineSingle(Shape lIIIlIlIlllIllI, Shape lIIIlIlIlllIlIl, boolean lIIIlIlIlllIlII, int lIIIlIlIlllIIll) {
        GeomUtil lIIIlIllIIIIlIl;
        Shape lIIIlIllIIIIIII = lIIIlIlIlllIllI;
        Shape lIIIlIlIlllllll = lIIIlIlIlllIlIl;
        int lIIIlIlIllllllI = lIIIlIlIlllIIll;
        int lIIIlIlIlllllIl = 1;
        Polygon lIIIlIlIlllllII = new Polygon();
        boolean lIIIlIlIllllIll = true;
        int lIIIlIlIllllIlI = 0;
        float lIIIlIlIllllIIl = lIIIlIllIIIIIII.getPoint(lIIIlIlIllllllI)[0];
        float lIIIlIlIllllIII = lIIIlIllIIIIIII.getPoint(lIIIlIlIllllllI)[1];
        while (!lIIIlIlIlllllII.hasVertex(lIIIlIlIllllIIl, lIIIlIlIllllIII) || lIIIlIlIllllIll || lIIIlIllIIIIIII != lIIIlIlIlllIllI) {
            Line lIIIlIllIIIIlll;
            HitResult lIIIlIllIIIIllI;
            lIIIlIlIllllIll = false;
            if (++lIIIlIlIllllIlI > lIIIlIllIIIIlIl.MAX_POINTS) break;
            lIIIlIlIlllllII.addPoint(lIIIlIlIllllIIl, lIIIlIlIllllIII);
            if (lIIIlIllIIIIlIl.listener != null) {
                lIIIlIllIIIIlIl.listener.pointUsed(lIIIlIlIllllIIl, lIIIlIlIllllIII);
            }
            if ((lIIIlIllIIIIllI = lIIIlIllIIIIlIl.intersect(lIIIlIlIlllllll, lIIIlIllIIIIlll = lIIIlIllIIIIlIl.getLine(lIIIlIllIIIIIII, lIIIlIlIllllIIl, lIIIlIlIllllIII, GeomUtil.rationalPoint(lIIIlIllIIIIIII, lIIIlIlIllllllI + lIIIlIlIlllllIl)))) != null) {
                Line lIIIlIllIIIlIll = lIIIlIllIIIIllI.line;
                Vector2f lIIIlIllIIIlIlI = lIIIlIllIIIIllI.pt;
                lIIIlIlIllllIIl = lIIIlIllIIIlIlI.x;
                lIIIlIlIllllIII = lIIIlIllIIIlIlI.y;
                if (lIIIlIllIIIIlIl.listener != null) {
                    lIIIlIllIIIIlIl.listener.pointIntersected(lIIIlIlIllllIIl, lIIIlIlIllllIII);
                }
                if (lIIIlIlIlllllll.hasVertex(lIIIlIlIllllIIl, lIIIlIlIllllIII)) {
                    lIIIlIlIllllllI = lIIIlIlIlllllll.indexOf(lIIIlIllIIIlIlI.x, lIIIlIllIIIlIlI.y);
                    lIIIlIlIlllllIl = 1;
                    lIIIlIlIllllIIl = lIIIlIllIIIlIlI.x;
                    lIIIlIlIllllIII = lIIIlIllIIIlIlI.y;
                    Shape lIIIlIllIIIllll = lIIIlIllIIIIIII;
                    lIIIlIllIIIIIII = lIIIlIlIlllllll;
                    lIIIlIlIlllllll = lIIIlIllIIIllll;
                    continue;
                }
                float lIIIlIllIIIlIIl = lIIIlIllIIIlIll.getDX() / lIIIlIllIIIlIll.length();
                float lIIIlIllIIIlIII = lIIIlIllIIIlIll.getDY() / lIIIlIllIIIlIll.length();
                if (lIIIlIllIIIIIII.contains(lIIIlIllIIIlIlI.x + (lIIIlIllIIIlIIl *= lIIIlIllIIIIlIl.EDGE_SCALE), lIIIlIllIIIlIlI.y + (lIIIlIllIIIlIII *= lIIIlIllIIIIlIl.EDGE_SCALE))) {
                    if (lIIIlIlIlllIlII) {
                        if (lIIIlIllIIIIIII == lIIIlIlIlllIlIl) {
                            lIIIlIlIllllllI = lIIIlIllIIIIllI.p2;
                            lIIIlIlIlllllIl = -1;
                        } else {
                            lIIIlIlIllllllI = lIIIlIllIIIIllI.p1;
                            lIIIlIlIlllllIl = 1;
                        }
                    } else if (lIIIlIllIIIIIII == lIIIlIlIlllIllI) {
                        lIIIlIlIllllllI = lIIIlIllIIIIllI.p2;
                        lIIIlIlIlllllIl = -1;
                    } else {
                        lIIIlIlIllllllI = lIIIlIllIIIIllI.p2;
                        lIIIlIlIlllllIl = -1;
                    }
                    Shape lIIIlIllIIIlllI = lIIIlIllIIIIIII;
                    lIIIlIllIIIIIII = lIIIlIlIlllllll;
                    lIIIlIlIlllllll = lIIIlIllIIIlllI;
                    continue;
                }
                if (lIIIlIllIIIIIII.contains(lIIIlIllIIIlIlI.x - lIIIlIllIIIlIIl, lIIIlIllIIIlIlI.y - lIIIlIllIIIlIII)) {
                    if (lIIIlIlIlllIlII) {
                        if (lIIIlIllIIIIIII == lIIIlIlIlllIllI) {
                            lIIIlIlIllllllI = lIIIlIllIIIIllI.p2;
                            lIIIlIlIlllllIl = -1;
                        } else {
                            lIIIlIlIllllllI = lIIIlIllIIIIllI.p1;
                            lIIIlIlIlllllIl = 1;
                        }
                    } else if (lIIIlIllIIIIIII == lIIIlIlIlllIlIl) {
                        lIIIlIlIllllllI = lIIIlIllIIIIllI.p1;
                        lIIIlIlIlllllIl = 1;
                    } else {
                        lIIIlIlIllllllI = lIIIlIllIIIIllI.p1;
                        lIIIlIlIlllllIl = 1;
                    }
                    Shape lIIIlIllIIIllIl = lIIIlIllIIIIIII;
                    lIIIlIllIIIIIII = lIIIlIlIlllllll;
                    lIIIlIlIlllllll = lIIIlIllIIIllIl;
                    continue;
                }
                if (lIIIlIlIlllIlII) break;
                lIIIlIlIllllllI = lIIIlIllIIIIllI.p1;
                lIIIlIlIlllllIl = 1;
                Shape lIIIlIllIIIllII = lIIIlIllIIIIIII;
                lIIIlIllIIIIIII = lIIIlIlIlllllll;
                lIIIlIlIlllllll = lIIIlIllIIIllII;
                lIIIlIlIllllllI = GeomUtil.rationalPoint(lIIIlIllIIIIIII, lIIIlIlIllllllI + lIIIlIlIlllllIl);
                lIIIlIlIllllIIl = lIIIlIllIIIIIII.getPoint(lIIIlIlIllllllI)[0];
                lIIIlIlIllllIII = lIIIlIllIIIIIII.getPoint(lIIIlIlIllllllI)[1];
                continue;
            }
            lIIIlIlIllllllI = GeomUtil.rationalPoint(lIIIlIllIIIIIII, lIIIlIlIllllllI + lIIIlIlIlllllIl);
            lIIIlIlIllllIIl = lIIIlIllIIIIIII.getPoint(lIIIlIlIllllllI)[0];
            lIIIlIlIllllIII = lIIIlIllIIIIIII.getPoint(lIIIlIlIllllllI)[1];
        }
        lIIIlIlIlllllII.addPoint(lIIIlIlIllllIIl, lIIIlIlIllllIII);
        if (lIIIlIllIIIIlIl.listener != null) {
            lIIIlIllIIIIlIl.listener.pointUsed(lIIIlIlIllllIIl, lIIIlIlIllllIII);
        }
        return lIIIlIlIlllllII;
    }

    private Shape[] combine(Shape lIIIlIllIllIlII, Shape lIIIlIllIlIllll, boolean lIIIlIllIllIIlI) {
        GeomUtil lIIIlIllIllIIIl;
        if (lIIIlIllIllIIlI) {
            ArrayList<Shape> lIIIlIllIlllIIl = new ArrayList<Shape>();
            ArrayList<Vector2f> lIIIlIllIlllIII = new ArrayList<Vector2f>();
            for (int lIIIlIlllIIIIIl = 0; lIIIlIlllIIIIIl < lIIIlIllIllIlII.getPointCount(); ++lIIIlIlllIIIIIl) {
                float[] lIIIlIlllIIIIlI = lIIIlIllIllIlII.getPoint(lIIIlIlllIIIIIl);
                if (!lIIIlIllIlIllll.contains(lIIIlIlllIIIIlI[0], lIIIlIlllIIIIlI[1])) continue;
                lIIIlIllIlllIII.add(new Vector2f(lIIIlIlllIIIIlI[0], lIIIlIlllIIIIlI[1]));
                if (lIIIlIllIllIIIl.listener == null) continue;
                lIIIlIllIllIIIl.listener.pointExcluded(lIIIlIlllIIIIlI[0], lIIIlIlllIIIIlI[1]);
            }
            for (int lIIIlIllIlllIlI = 0; lIIIlIllIlllIlI < lIIIlIllIllIlII.getPointCount(); ++lIIIlIllIlllIlI) {
                float[] lIIIlIllIllllII = lIIIlIllIllIlII.getPoint(lIIIlIllIlllIlI);
                Vector2f lIIIlIllIlllIll = new Vector2f(lIIIlIllIllllII[0], lIIIlIllIllllII[1]);
                if (lIIIlIllIlllIII.contains(lIIIlIllIlllIll)) continue;
                Shape lIIIlIllIllllIl = lIIIlIllIllIIIl.combineSingle(lIIIlIllIllIlII, lIIIlIllIlIllll, true, lIIIlIllIlllIlI);
                lIIIlIllIlllIIl.add(lIIIlIllIllllIl);
                for (int lIIIlIllIlllllI = 0; lIIIlIllIlllllI < lIIIlIllIllllIl.getPointCount(); ++lIIIlIllIlllllI) {
                    float[] lIIIlIlllIIIIII = lIIIlIllIllllIl.getPoint(lIIIlIllIlllllI);
                    Vector2f lIIIlIllIllllll = new Vector2f(lIIIlIlllIIIIII[0], lIIIlIlllIIIIII[1]);
                    lIIIlIllIlllIII.add(lIIIlIllIllllll);
                }
            }
            return lIIIlIllIlllIIl.toArray(new Shape[0]);
        }
        for (int lIIIlIllIllIllI = 0; lIIIlIllIllIllI < lIIIlIllIllIlII.getPointCount(); ++lIIIlIllIllIllI) {
            if (lIIIlIllIlIllll.contains(lIIIlIllIllIlII.getPoint(lIIIlIllIllIllI)[0], lIIIlIllIllIlII.getPoint(lIIIlIllIllIllI)[1]) || lIIIlIllIlIllll.hasVertex(lIIIlIllIllIlII.getPoint(lIIIlIllIllIllI)[0], lIIIlIllIllIlII.getPoint(lIIIlIllIllIllI)[1])) continue;
            Shape lIIIlIllIllIlll = lIIIlIllIllIIIl.combineSingle(lIIIlIllIllIlII, lIIIlIllIlIllll, false, lIIIlIllIllIllI);
            return new Shape[]{lIIIlIllIllIlll};
        }
        return new Shape[]{lIIIlIllIlIllll};
    }

    public void setListener(GeomUtilListener lIIIlIllllIIIll) {
        lIIIlIllllIIlII.listener = lIIIlIllllIIIll;
    }

    public static int rationalPoint(Shape lIIIlIlIlIIIIII, int lIIIlIlIIllllll) {
        while (lIIIlIlIIllllll < 0) {
            lIIIlIlIIllllll += lIIIlIlIlIIIIII.getPointCount();
        }
        while (lIIIlIlIIllllll >= lIIIlIlIlIIIIII.getPointCount()) {
            lIIIlIlIIllllll -= lIIIlIlIlIIIIII.getPointCount();
        }
        return lIIIlIlIIllllll;
    }

    public class HitResult {
        public /* synthetic */ Vector2f pt;
        public /* synthetic */ int p1;
        public /* synthetic */ int p2;
        public /* synthetic */ Line line;

        public HitResult() {
            HitResult llllllllllllllllIlIIlIIlIlIllIlI;
        }
    }
}

