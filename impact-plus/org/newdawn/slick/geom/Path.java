/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.util.ArrayList;
import org.newdawn.slick.geom.Curve;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

public class Path
extends Shape {
    private /* synthetic */ float cx;
    private /* synthetic */ ArrayList localPoints;
    private /* synthetic */ ArrayList holes;
    private /* synthetic */ float cy;
    private /* synthetic */ ArrayList hole;
    private /* synthetic */ boolean closed;

    public Path(float llllllllllllllllllIlIIllllllIIII, float llllllllllllllllllIlIIllllllIIlI) {
        Path llllllllllllllllllIlIIllllllIIIl;
        llllllllllllllllllIlIIllllllIIIl.localPoints = new ArrayList();
        llllllllllllllllllIlIIllllllIIIl.holes = new ArrayList();
        llllllllllllllllllIlIIllllllIIIl.localPoints.add(new float[]{llllllllllllllllllIlIIllllllIIII, llllllllllllllllllIlIIllllllIIlI});
        llllllllllllllllllIlIIllllllIIIl.cx = llllllllllllllllllIlIIllllllIIII;
        llllllllllllllllllIlIIllllllIIIl.cy = llllllllllllllllllIlIIllllllIIlI;
        llllllllllllllllllIlIIllllllIIIl.pointsDirty = true;
    }

    private ArrayList transform(ArrayList llllllllllllllllllIlIIllIlIIIIII, Transform llllllllllllllllllIlIIllIlIIIlll) {
        float[] llllllllllllllllllIlIIllIlIIIlIl = new float[llllllllllllllllllIlIIllIlIIIIII.size() * 2];
        float[] llllllllllllllllllIlIIllIlIIIlII = new float[llllllllllllllllllIlIIllIlIIIIII.size() * 2];
        for (int llllllllllllllllllIlIIllIlIIlllI = 0; llllllllllllllllllIlIIllIlIIlllI < llllllllllllllllllIlIIllIlIIIIII.size(); ++llllllllllllllllllIlIIllIlIIlllI) {
            llllllllllllllllllIlIIllIlIIIlIl[llllllllllllllllllIlIIllIlIIlllI * 2] = ((float[])llllllllllllllllllIlIIllIlIIIIII.get(llllllllllllllllllIlIIllIlIIlllI))[0];
            llllllllllllllllllIlIIllIlIIIlIl[llllllllllllllllllIlIIllIlIIlllI * 2 + 1] = ((float[])llllllllllllllllllIlIIllIlIIIIII.get(llllllllllllllllllIlIIllIlIIlllI))[1];
        }
        llllllllllllllllllIlIIllIlIIIlll.transform(llllllllllllllllllIlIIllIlIIIlIl, 0, llllllllllllllllllIlIIllIlIIIlII, 0, llllllllllllllllllIlIIllIlIIIIII.size());
        ArrayList<float[]> llllllllllllllllllIlIIllIlIIIIlI = new ArrayList<float[]>();
        for (int llllllllllllllllllIlIIllIlIIllII = 0; llllllllllllllllllIlIIllIlIIllII < llllllllllllllllllIlIIllIlIIIIII.size(); ++llllllllllllllllllIlIIllIlIIllII) {
            llllllllllllllllllIlIIllIlIIIIlI.add(new float[]{llllllllllllllllllIlIIllIlIIIlII[llllllllllllllllllIlIIllIlIIllII * 2], llllllllllllllllllIlIIllIlIIIlII[llllllllllllllllllIlIIllIlIIllII * 2 + 1]});
        }
        return llllllllllllllllllIlIIllIlIIIIlI;
    }

    @Override
    public Shape transform(Transform llllllllllllllllllIlIIllIllIlIII) {
        Path llllllllllllllllllIlIIllIllIlIIl;
        Path llllllllllllllllllIlIIllIllIIlll = new Path(llllllllllllllllllIlIIllIllIlIIl.cx, llllllllllllllllllIlIIllIllIlIIl.cy);
        llllllllllllllllllIlIIllIllIIlll.localPoints = llllllllllllllllllIlIIllIllIlIIl.transform(llllllllllllllllllIlIIllIllIlIIl.localPoints, llllllllllllllllllIlIIllIllIlIII);
        for (int llllllllllllllllllIlIIllIllIlIlI = 0; llllllllllllllllllIlIIllIllIlIlI < llllllllllllllllllIlIIllIllIlIIl.holes.size(); ++llllllllllllllllllIlIIllIllIlIlI) {
            llllllllllllllllllIlIIllIllIIlll.holes.add(llllllllllllllllllIlIIllIllIlIIl.transform((ArrayList)llllllllllllllllllIlIIllIllIlIIl.holes.get(llllllllllllllllllIlIIllIllIlIlI), llllllllllllllllllIlIIllIllIlIII));
        }
        llllllllllllllllllIlIIllIllIIlll.closed = llllllllllllllllllIlIIllIllIlIIl.closed;
        return llllllllllllllllllIlIIllIllIIlll;
    }

    @Override
    protected void createPoints() {
        Path llllllllllllllllllIlIIllIlllllII;
        llllllllllllllllllIlIIllIlllllII.points = new float[llllllllllllllllllIlIIllIlllllII.localPoints.size() * 2];
        for (int llllllllllllllllllIlIIllIlllllll = 0; llllllllllllllllllIlIIllIlllllll < llllllllllllllllllIlIIllIlllllII.localPoints.size(); ++llllllllllllllllllIlIIllIlllllll) {
            float[] llllllllllllllllllIlIIlllIIIIIII = (float[])llllllllllllllllllIlIIllIlllllII.localPoints.get(llllllllllllllllllIlIIllIlllllll);
            llllllllllllllllllIlIIllIlllllII.points[llllllllllllllllllIlIIllIlllllll * 2] = llllllllllllllllllIlIIlllIIIIIII[0];
            llllllllllllllllllIlIIllIlllllII.points[llllllllllllllllllIlIIllIlllllll * 2 + 1] = llllllllllllllllllIlIIlllIIIIIII[1];
        }
    }

    public void curveTo(float llllllllllllllllllIlIIllllIlIlIl, float llllllllllllllllllIlIIllllIIllIl, float llllllllllllllllllIlIIllllIlIIll, float llllllllllllllllllIlIIllllIIlIll, float llllllllllllllllllIlIIllllIIlIlI, float llllllllllllllllllIlIIllllIlIIII) {
        Path llllllllllllllllllIlIIllllIlIllI;
        llllllllllllllllllIlIIllllIlIllI.curveTo(llllllllllllllllllIlIIllllIlIlIl, llllllllllllllllllIlIIllllIIllIl, llllllllllllllllllIlIIllllIlIIll, llllllllllllllllllIlIIllllIIlIll, llllllllllllllllllIlIIllllIIlIlI, llllllllllllllllllIlIIllllIlIIII, 10);
    }

    public void curveTo(float llllllllllllllllllIlIIlllIlIlIll, float llllllllllllllllllIlIIlllIlIlIIl, float llllllllllllllllllIlIIlllIIllIIl, float llllllllllllllllllIlIIlllIlIIlIl, float llllllllllllllllllIlIIlllIIlIlll, float llllllllllllllllllIlIIlllIlIIIll, int llllllllllllllllllIlIIlllIlIIIlI) {
        Path llllllllllllllllllIlIIlllIlIllIl;
        if (llllllllllllllllllIlIIlllIlIllIl.cx == llllllllllllllllllIlIIlllIlIlIll && llllllllllllllllllIlIIlllIlIllIl.cy == llllllllllllllllllIlIIlllIlIlIIl) {
            return;
        }
        Curve llllllllllllllllllIlIIlllIlIIIIl = new Curve(new Vector2f(llllllllllllllllllIlIIlllIlIllIl.cx, llllllllllllllllllIlIIlllIlIllIl.cy), new Vector2f(llllllllllllllllllIlIIlllIIllIIl, llllllllllllllllllIlIIlllIlIIlIl), new Vector2f(llllllllllllllllllIlIIlllIIlIlll, llllllllllllllllllIlIIlllIlIIIll), new Vector2f(llllllllllllllllllIlIIlllIlIlIll, llllllllllllllllllIlIIlllIlIlIIl));
        float llllllllllllllllllIlIIlllIlIIIII = 1.0f / (float)llllllllllllllllllIlIIlllIlIIIlI;
        for (int llllllllllllllllllIlIIlllIlIllll = 1; llllllllllllllllllIlIIlllIlIllll < llllllllllllllllllIlIIlllIlIIIlI + 1; ++llllllllllllllllllIlIIlllIlIllll) {
            float llllllllllllllllllIlIIlllIllIIll = (float)llllllllllllllllllIlIIlllIlIllll * llllllllllllllllllIlIIlllIlIIIII;
            Vector2f llllllllllllllllllIlIIlllIllIIIl = llllllllllllllllllIlIIlllIlIIIIl.pointAt(llllllllllllllllllIlIIlllIllIIll);
            if (llllllllllllllllllIlIIlllIlIllIl.hole != null) {
                llllllllllllllllllIlIIlllIlIllIl.hole.add(new float[]{llllllllllllllllllIlIIlllIllIIIl.x, llllllllllllllllllIlIIlllIllIIIl.y});
            } else {
                llllllllllllllllllIlIIlllIlIllIl.localPoints.add(new float[]{llllllllllllllllllIlIIlllIllIIIl.x, llllllllllllllllllIlIIlllIllIIIl.y});
            }
            llllllllllllllllllIlIIlllIlIllIl.cx = llllllllllllllllllIlIIlllIllIIIl.x;
            llllllllllllllllllIlIIlllIlIllIl.cy = llllllllllllllllllIlIIlllIllIIIl.y;
        }
        llllllllllllllllllIlIIlllIlIllIl.pointsDirty = true;
    }

    public void startHole(float llllllllllllllllllIlIIlllllIllII, float llllllllllllllllllIlIIlllllIlIll) {
        Path llllllllllllllllllIlIIlllllIlIlI;
        llllllllllllllllllIlIIlllllIlIlI.hole = new ArrayList();
        llllllllllllllllllIlIIlllllIlIlI.holes.add(llllllllllllllllllIlIIlllllIlIlI.hole);
    }

    public void lineTo(float llllllllllllllllllIlIIlllllIIlIl, float llllllllllllllllllIlIIlllllIIlII) {
        Path llllllllllllllllllIlIIlllllIIIll;
        if (llllllllllllllllllIlIIlllllIIIll.hole != null) {
            llllllllllllllllllIlIIlllllIIIll.hole.add(new float[]{llllllllllllllllllIlIIlllllIIlIl, llllllllllllllllllIlIIlllllIIlII});
        } else {
            llllllllllllllllllIlIIlllllIIIll.localPoints.add(new float[]{llllllllllllllllllIlIIlllllIIlIl, llllllllllllllllllIlIIlllllIIlII});
        }
        llllllllllllllllllIlIIlllllIIIll.cx = llllllllllllllllllIlIIlllllIIlIl;
        llllllllllllllllllIlIIlllllIIIll.cy = llllllllllllllllllIlIIlllllIIlII;
        llllllllllllllllllIlIIlllllIIIll.pointsDirty = true;
    }

    public void close() {
        llllllllllllllllllIlIIllllIllllI.closed = true;
    }

    @Override
    public boolean closed() {
        Path llllllllllllllllllIlIIllIIllIlll;
        return llllllllllllllllllIlIIllIIllIlll.closed;
    }
}

