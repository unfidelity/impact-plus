/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.TexCoordGenerator;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.svg.Gradient;

public class RadialGradientFill
implements TexCoordGenerator {
    private /* synthetic */ float radius;
    private /* synthetic */ Gradient gradient;
    private /* synthetic */ Shape shape;
    private /* synthetic */ Vector2f centre;

    @Override
    public Vector2f getCoordFor(float lllllllllIIllll, float lllllllllIIlllI) {
        RadialGradientFill lllllllllIIlIll;
        float lllllllllIIllIl = lllllllllIIlIll.centre.distance(new Vector2f(lllllllllIIllll, lllllllllIIlllI));
        if ((lllllllllIIllIl /= lllllllllIIlIll.radius) > 0.99f) {
            lllllllllIIllIl = 0.99f;
        }
        return new Vector2f(lllllllllIIllIl, 0.0f);
    }

    public RadialGradientFill(Shape llllllllllIIlII, Transform llllllllllIIIll, Gradient llllllllllIIIlI) {
        RadialGradientFill llllllllllIIlIl;
        llllllllllIIlIl.gradient = llllllllllIIIlI;
        llllllllllIIlIl.radius = llllllllllIIIlI.getR();
        float llllllllllIIIIl = llllllllllIIIlI.getX1();
        float llllllllllIIIII = llllllllllIIIlI.getY1();
        float[] lllllllllIlllll = new float[]{llllllllllIIIIl, llllllllllIIIII};
        llllllllllIIIlI.getTransform().transform(lllllllllIlllll, 0, lllllllllIlllll, 0, 1);
        llllllllllIIIll.transform(lllllllllIlllll, 0, lllllllllIlllll, 0, 1);
        float[] lllllllllIllllI = new float[]{llllllllllIIIIl, llllllllllIIIII - llllllllllIIlIl.radius};
        llllllllllIIIlI.getTransform().transform(lllllllllIllllI, 0, lllllllllIllllI, 0, 1);
        llllllllllIIIll.transform(lllllllllIllllI, 0, lllllllllIllllI, 0, 1);
        llllllllllIIlIl.centre = new Vector2f(lllllllllIlllll[0], lllllllllIlllll[1]);
        Vector2f lllllllllIlllIl = new Vector2f(lllllllllIllllI[0], lllllllllIllllI[1]);
        llllllllllIIlIl.radius = lllllllllIlllIl.distance(llllllllllIIlIl.centre);
    }
}

