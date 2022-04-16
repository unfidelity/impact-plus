/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.fills;

import org.newdawn.slick.Color;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class GradientFill
implements ShapeFill {
    private /* synthetic */ Color startCol;
    private /* synthetic */ boolean local;
    private /* synthetic */ Vector2f start;
    private /* synthetic */ Vector2f none;
    private /* synthetic */ Vector2f end;
    private /* synthetic */ Color endCol;

    public Vector2f getStart() {
        GradientFill llllllllllllllllllllIIlllIIlIllI;
        return llllllllllllllllllllIIlllIIlIllI.start;
    }

    public Color colorAt(float llllllllllllllllllllIIlIllIIlllI, float llllllllllllllllllllIIlIllIIllIl) {
        float llllllllllllllllllllIIlIllIIlIlI;
        float llllllllllllllllllllIIlIllIIlIII;
        GradientFill llllllllllllllllllllIIlIlIllllll;
        float llllllllllllllllllllIIlIllIIlIll = llllllllllllllllllllIIlIlIllllll.end.getX() - llllllllllllllllllllIIlIlIllllll.start.getX();
        float llllllllllllllllllllIIlIllIIIlll = llllllllllllllllllllIIlIllIIlIll;
        float llllllllllllllllllllIIlIllIIIlIl = llllllllllllllllllllIIlIllIIIlll * llllllllllllllllllllIIlIllIIlIll - (llllllllllllllllllllIIlIllIIlIII = -(llllllllllllllllllllIIlIllIIlIlI = llllllllllllllllllllIIlIlIllllll.end.getY() - llllllllllllllllllllIIlIlIllllll.start.getY())) * llllllllllllllllllllIIlIllIIlIlI;
        if (llllllllllllllllllllIIlIllIIIlIl == 0.0f) {
            return Color.black;
        }
        float llllllllllllllllllllIIlIllIIIlII = llllllllllllllllllllIIlIllIIlIII * (llllllllllllllllllllIIlIlIllllll.start.getY() - llllllllllllllllllllIIlIllIIllIl) - llllllllllllllllllllIIlIllIIIlll * (llllllllllllllllllllIIlIlIllllll.start.getX() - llllllllllllllllllllIIlIllIIlllI);
        llllllllllllllllllllIIlIllIIIlII /= llllllllllllllllllllIIlIllIIIlIl;
        float llllllllllllllllllllIIlIllIIIIll = llllllllllllllllllllIIlIllIIlIll * (llllllllllllllllllllIIlIlIllllll.start.getY() - llllllllllllllllllllIIlIllIIllIl) - llllllllllllllllllllIIlIllIIlIlI * (llllllllllllllllllllIIlIlIllllll.start.getX() - llllllllllllllllllllIIlIllIIlllI);
        llllllllllllllllllllIIlIllIIIIll /= llllllllllllllllllllIIlIllIIIlIl;
        float llllllllllllllllllllIIlIllIIIIlI = llllllllllllllllllllIIlIllIIIlII;
        if (llllllllllllllllllllIIlIllIIIIlI < 0.0f) {
            llllllllllllllllllllIIlIllIIIIlI = 0.0f;
        }
        if (llllllllllllllllllllIIlIllIIIIlI > 1.0f) {
            llllllllllllllllllllIIlIllIIIIlI = 1.0f;
        }
        float llllllllllllllllllllIIlIllIIIIIl = 1.0f - llllllllllllllllllllIIlIllIIIIlI;
        Color llllllllllllllllllllIIlIllIIIIII = new Color(1, 1, 1, 1);
        llllllllllllllllllllIIlIllIIIIII.r = llllllllllllllllllllIIlIllIIIIlI * llllllllllllllllllllIIlIlIllllll.endCol.r + llllllllllllllllllllIIlIllIIIIIl * llllllllllllllllllllIIlIlIllllll.startCol.r;
        llllllllllllllllllllIIlIllIIIIII.b = llllllllllllllllllllIIlIllIIIIlI * llllllllllllllllllllIIlIlIllllll.endCol.b + llllllllllllllllllllIIlIllIIIIIl * llllllllllllllllllllIIlIlIllllll.startCol.b;
        llllllllllllllllllllIIlIllIIIIII.g = llllllllllllllllllllIIlIllIIIIlI * llllllllllllllllllllIIlIlIllllll.endCol.g + llllllllllllllllllllIIlIllIIIIIl * llllllllllllllllllllIIlIlIllllll.startCol.g;
        llllllllllllllllllllIIlIllIIIIII.a = llllllllllllllllllllIIlIllIIIIlI * llllllllllllllllllllIIlIlIllllll.endCol.a + llllllllllllllllllllIIlIllIIIIIl * llllllllllllllllllllIIlIlIllllll.startCol.a;
        return llllllllllllllllllllIIlIllIIIIII;
    }

    public void setStart(float llllllllllllllllllllIIllIlIlIIII, float llllllllllllllllllllIIllIlIIlllI) {
        GradientFill llllllllllllllllllllIIllIlIlIIIl;
        llllllllllllllllllllIIllIlIlIIIl.setStart(new Vector2f(llllllllllllllllllllIIllIlIlIIII, llllllllllllllllllllIIllIlIIlllI));
    }

    public void setStartColor(Color llllllllllllllllllllIIllIIlIIIII) {
        llllllllllllllllllllIIllIIlIIIIl.startCol = new Color(llllllllllllllllllllIIllIIlIIIII);
    }

    public void setLocal(boolean llllllllllllllllllllIIlllIIllllI) {
        llllllllllllllllllllIIlllIlIIIlI.local = llllllllllllllllllllIIlllIIllllI;
    }

    public GradientFill(float llllllllllllllllllllIlIIIIIlIlII, float llllllllllllllllllllIlIIIIIlIIll, Color llllllllllllllllllllIlIIIIIIlIll, float llllllllllllllllllllIlIIIIIlIIIl, float llllllllllllllllllllIlIIIIIlIIII, Color llllllllllllllllllllIlIIIIIIllll) {
        llllllllllllllllllllIlIIIIIIlllI(llllllllllllllllllllIlIIIIIlIlII, llllllllllllllllllllIlIIIIIlIIll, llllllllllllllllllllIlIIIIIIlIll, llllllllllllllllllllIlIIIIIlIIIl, llllllllllllllllllllIlIIIIIlIIII, llllllllllllllllllllIlIIIIIIllll, false);
        GradientFill llllllllllllllllllllIlIIIIIIlllI;
    }

    public void setEnd(Vector2f llllllllllllllllllllIIllIIlIlIll) {
        llllllllllllllllllllIIllIIlIllII.end = new Vector2f(llllllllllllllllllllIIllIIlIlIll);
    }

    public Color getEndColor() {
        GradientFill llllllllllllllllllllIIllIlllIllI;
        return llllllllllllllllllllIIllIlllIllI.endCol;
    }

    public GradientFill getInvertedCopy() {
        GradientFill llllllllllllllllllllIIlllIlIlIII;
        return new GradientFill(llllllllllllllllllllIIlllIlIlIII.start, llllllllllllllllllllIIlllIlIlIII.endCol, llllllllllllllllllllIIlllIlIlIII.end, llllllllllllllllllllIIlllIlIlIII.startCol, llllllllllllllllllllIIlllIlIlIII.local);
    }

    public Vector2f getEnd() {
        GradientFill llllllllllllllllllllIIlllIIIlIIl;
        return llllllllllllllllllllIIlllIIIlIIl.end;
    }

    public Color getStartColor() {
        GradientFill llllllllllllllllllllIIlllIIIIIlI;
        return llllllllllllllllllllIIlllIIIIIlI.startCol;
    }

    @Override
    public Color colorAt(Shape llllllllllllllllllllIIllIIIIIIll, float llllllllllllllllllllIIllIIIIIlll, float llllllllllllllllllllIIlIllllllll) {
        GradientFill llllllllllllllllllllIIllIIIIIlII;
        if (llllllllllllllllllllIIllIIIIIlII.local) {
            return llllllllllllllllllllIIllIIIIIlII.colorAt(llllllllllllllllllllIIllIIIIIlll - llllllllllllllllllllIIllIIIIIIll.getCenterX(), llllllllllllllllllllIIlIllllllll - llllllllllllllllllllIIllIIIIIIll.getCenterY());
        }
        return llllllllllllllllllllIIllIIIIIlII.colorAt(llllllllllllllllllllIIllIIIIIlll, llllllllllllllllllllIIlIllllllll);
    }

    public void setStart(Vector2f llllllllllllllllllllIIllIIlllIlI) {
        llllllllllllllllllllIIllIIlllIll.start = new Vector2f(llllllllllllllllllllIIllIIlllIlI);
    }

    public void setEndColor(Color llllllllllllllllllllIIllIIIllIlI) {
        llllllllllllllllllllIIllIIIlllIl.endCol = new Color(llllllllllllllllllllIIllIIIllIlI);
    }

    public GradientFill(float llllllllllllllllllllIIlllllIIIlI, float llllllllllllllllllllIIlllllIIIIl, Color llllllllllllllllllllIIllllIlllll, float llllllllllllllllllllIIlllllIlIII, float llllllllllllllllllllIIllllIllIll, Color llllllllllllllllllllIIlllllIIllI, boolean llllllllllllllllllllIIllllIllIIl) {
        llllllllllllllllllllIIlllllIIIll(new Vector2f(llllllllllllllllllllIIlllllIIIlI, llllllllllllllllllllIIlllllIIIIl), llllllllllllllllllllIIllllIlllll, new Vector2f(llllllllllllllllllllIIlllllIlIII, llllllllllllllllllllIIllllIllIll), llllllllllllllllllllIIlllllIIllI, llllllllllllllllllllIIllllIllIIl);
        GradientFill llllllllllllllllllllIIlllllIIIll;
    }

    @Override
    public Vector2f getOffsetAt(Shape llllllllllllllllllllIIlIlIlIllll, float llllllllllllllllllllIIlIlIlIllIl, float llllllllllllllllllllIIlIlIlIlIlI) {
        GradientFill llllllllllllllllllllIIlIlIllIIII;
        return llllllllllllllllllllIIlIlIllIIII.none;
    }

    public void setEnd(float llllllllllllllllllllIIllIIllIIII, float llllllllllllllllllllIIllIIlIllll) {
        GradientFill llllllllllllllllllllIIllIIllIlII;
        llllllllllllllllllllIIllIIllIlII.setEnd(new Vector2f(llllllllllllllllllllIIllIIllIIII, llllllllllllllllllllIIllIIlIllll));
    }

    public GradientFill(Vector2f llllllllllllllllllllIIllllIIIIII, Color llllllllllllllllllllIIlllIlllllI, Vector2f llllllllllllllllllllIIlllIllIIlI, Color llllllllllllllllllllIIlllIllIIIl, boolean llllllllllllllllllllIIlllIllIllI) {
        GradientFill llllllllllllllllllllIIlllIllIlIl;
        llllllllllllllllllllIIlllIllIlIl.none = new Vector2f(0.0f, 0.0f);
        llllllllllllllllllllIIlllIllIlIl.local = false;
        llllllllllllllllllllIIlllIllIlIl.start = new Vector2f(llllllllllllllllllllIIllllIIIIII);
        llllllllllllllllllllIIlllIllIlIl.end = new Vector2f(llllllllllllllllllllIIlllIllIIlI);
        llllllllllllllllllllIIlllIllIlIl.startCol = new Color(llllllllllllllllllllIIlllIlllllI);
        llllllllllllllllllllIIlllIllIlIl.endCol = new Color(llllllllllllllllllllIIlllIllIIIl);
        llllllllllllllllllllIIlllIllIlIl.local = llllllllllllllllllllIIlllIllIllI;
    }
}

