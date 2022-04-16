/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.NonGeometricData;

public class Figure {
    private /* synthetic */ Transform transform;
    public static final /* synthetic */ int ELLIPSE;
    private /* synthetic */ int type;
    private /* synthetic */ Shape shape;
    public static final /* synthetic */ int POLYGON;
    public static final /* synthetic */ int PATH;
    public static final /* synthetic */ int RECTANGLE;
    private /* synthetic */ NonGeometricData data;
    public static final /* synthetic */ int LINE;

    public Figure(int lIIlllIIlIllllI, Shape lIIlllIIllIIIlI, NonGeometricData lIIlllIIllIIIIl, Transform lIIlllIIlIllIll) {
        Figure lIIlllIIlIlllll;
        lIIlllIIlIlllll.shape = lIIlllIIllIIIlI;
        lIIlllIIlIlllll.data = lIIlllIIllIIIIl;
        lIIlllIIlIlllll.type = lIIlllIIlIllllI;
        lIIlllIIlIlllll.transform = lIIlllIIlIllIll;
    }

    public Shape getShape() {
        Figure lIIlllIIlIIIIII;
        return lIIlllIIlIIIIII.shape;
    }

    public int getType() {
        Figure lIIlllIIlIIlIII;
        return lIIlllIIlIIlIII.type;
    }

    static {
        ELLIPSE = 1;
        PATH = 4;
        LINE = 2;
        RECTANGLE = 3;
        POLYGON = 5;
    }

    public NonGeometricData getData() {
        Figure lIIlllIIIlllIIl;
        return lIIlllIIIlllIIl.data;
    }

    public Transform getTransform() {
        Figure lIIlllIIlIlIlII;
        return lIIlllIIlIlIlII.transform;
    }
}

