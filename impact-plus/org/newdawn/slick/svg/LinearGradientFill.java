/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.TexCoordGenerator;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.svg.Gradient;

public class LinearGradientFill
implements TexCoordGenerator {
    private /* synthetic */ Vector2f start;
    private /* synthetic */ Vector2f end;
    private /* synthetic */ Gradient gradient;
    private /* synthetic */ Line line;
    private /* synthetic */ Shape shape;

    @Override
    public Vector2f getCoordFor(float llllllllllllllllIllIIllIIlIIlIlI, float llllllllllllllllIllIIllIIlIIlIIl) {
        LinearGradientFill llllllllllllllllIllIIllIIlIIlIll;
        Vector2f llllllllllllllllIllIIllIIlIIllIl = new Vector2f();
        llllllllllllllllIllIIllIIlIIlIll.line.getClosestPoint(new Vector2f(llllllllllllllllIllIIllIIlIIlIlI, llllllllllllllllIllIIllIIlIIlIIl), llllllllllllllllIllIIllIIlIIllIl);
        float llllllllllllllllIllIIllIIlIIllII = llllllllllllllllIllIIllIIlIIllIl.distance(llllllllllllllllIllIIllIIlIIlIll.start);
        return new Vector2f(llllllllllllllllIllIIllIIlIIllII /= llllllllllllllllIllIIllIIlIIlIll.line.length(), 0.0f);
    }

    public LinearGradientFill(Shape llllllllllllllllIllIIllIIllIlIll, Transform llllllllllllllllIllIIllIIllIlIlI, Gradient llllllllllllllllIllIIllIIlIllllI) {
        LinearGradientFill llllllllllllllllIllIIllIIllIIIII;
        llllllllllllllllIllIIllIIllIIIII.gradient = llllllllllllllllIllIIllIIlIllllI;
        float llllllllllllllllIllIIllIIllIlIII = llllllllllllllllIllIIllIIlIllllI.getX1();
        float llllllllllllllllIllIIllIIllIIlll = llllllllllllllllIllIIllIIlIllllI.getY1();
        float llllllllllllllllIllIIllIIllIIllI = llllllllllllllllIllIIllIIlIllllI.getX2();
        float llllllllllllllllIllIIllIIllIIlIl = llllllllllllllllIllIIllIIlIllllI.getY2();
        float llllllllllllllllIllIIllIIllIIlII = llllllllllllllllIllIIllIIllIIlIl - llllllllllllllllIllIIllIIllIIlll;
        float llllllllllllllllIllIIllIIllIIIll = llllllllllllllllIllIIllIIllIIllI - llllllllllllllllIllIIllIIllIlIII;
        float[] llllllllllllllllIllIIllIIllIIIlI = new float[]{llllllllllllllllIllIIllIIllIlIII, llllllllllllllllIllIIllIIllIIlll + llllllllllllllllIllIIllIIllIIlII / 2.0f};
        llllllllllllllllIllIIllIIlIllllI.getTransform().transform(llllllllllllllllIllIIllIIllIIIlI, 0, llllllllllllllllIllIIllIIllIIIlI, 0, 1);
        llllllllllllllllIllIIllIIllIlIlI.transform(llllllllllllllllIllIIllIIllIIIlI, 0, llllllllllllllllIllIIllIIllIIIlI, 0, 1);
        float[] llllllllllllllllIllIIllIIllIIIIl = new float[]{llllllllllllllllIllIIllIIllIlIII + llllllllllllllllIllIIllIIllIIIll, llllllllllllllllIllIIllIIllIIlll + llllllllllllllllIllIIllIIllIIlII / 2.0f};
        llllllllllllllllIllIIllIIlIllllI.getTransform().transform(llllllllllllllllIllIIllIIllIIIIl, 0, llllllllllllllllIllIIllIIllIIIIl, 0, 1);
        llllllllllllllllIllIIllIIllIlIlI.transform(llllllllllllllllIllIIllIIllIIIIl, 0, llllllllllllllllIllIIllIIllIIIIl, 0, 1);
        llllllllllllllllIllIIllIIllIIIII.start = new Vector2f(llllllllllllllllIllIIllIIllIIIlI[0], llllllllllllllllIllIIllIIllIIIlI[1]);
        llllllllllllllllIllIIllIIllIIIII.end = new Vector2f(llllllllllllllllIllIIllIIllIIIIl[0], llllllllllllllllIllIIllIIllIIIIl[1]);
        llllllllllllllllIllIIllIIllIIIII.line = new Line(llllllllllllllllIllIIllIIllIIIII.start, llllllllllllllllIllIIllIIllIIIII.end);
    }
}

