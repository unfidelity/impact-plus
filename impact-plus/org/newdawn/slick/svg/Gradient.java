/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.Diagram;

public class Gradient {
    private /* synthetic */ Image image;
    private /* synthetic */ boolean radial;
    private /* synthetic */ float x1;
    private /* synthetic */ float y2;
    private /* synthetic */ ArrayList steps;
    private /* synthetic */ float x2;
    private /* synthetic */ float r;
    private /* synthetic */ String ref;
    private /* synthetic */ String name;
    private /* synthetic */ Transform transform;
    private /* synthetic */ float y1;

    public float getX1() {
        Gradient llllllllllllllllIIlIIllIIIIIIIIl;
        return llllllllllllllllIIlIIllIIIIIIIIl.x1;
    }

    public void addStep(float llllllllllllllllIIlIIlIlllIIllII, Color llllllllllllllllIIlIIlIlllIIlIlI) {
        Gradient llllllllllllllllIIlIIlIlllIIlllI;
        llllllllllllllllIIlIIlIlllIIlllI.steps.add(llllllllllllllllIIlIIlIlllIIlllI.new Step(llllllllllllllllIIlIIlIlllIIllII, llllllllllllllllIIlIIlIlllIIlIlI));
    }

    public void setTransform(Transform llllllllllllllllIIlIIllIIlIlIIlI) {
        llllllllllllllllIIlIIllIIlIlIIll.transform = llllllllllllllllIIlIIllIIlIlIIlI;
    }

    public void setY1(float llllllllllllllllIIlIIllIIIIIlllI) {
        llllllllllllllllIIlIIllIIIIIllll.y1 = llllllllllllllllIIlIIllIIIIIlllI;
    }

    public Transform getTransform() {
        Gradient llllllllllllllllIIlIIllIIlIIllll;
        return llllllllllllllllIIlIIllIIlIIllll.transform;
    }

    public Color getColorAt(float llllllllllllllllIIlIIlIllIIllIII) {
        Gradient llllllllllllllllIIlIIlIllIIllIlI;
        if (llllllllllllllllIIlIIlIllIIllIII <= 0.0f) {
            return ((Step)llllllllllllllllIIlIIlIllIIllIlI.steps.get((int)0)).col;
        }
        if (llllllllllllllllIIlIIlIllIIllIII > 1.0f) {
            return ((Step)llllllllllllllllIIlIIlIllIIllIlI.steps.get((int)(llllllllllllllllIIlIIlIllIIllIlI.steps.size() - 1))).col;
        }
        for (int llllllllllllllllIIlIIlIllIIllllI = 1; llllllllllllllllIIlIIlIllIIllllI < llllllllllllllllIIlIIlIllIIllIlI.steps.size(); ++llllllllllllllllIIlIIlIllIIllllI) {
            Step llllllllllllllllIIlIIlIllIlIIIlI = (Step)llllllllllllllllIIlIIlIllIIllIlI.steps.get(llllllllllllllllIIlIIlIllIIllllI - 1);
            Step llllllllllllllllIIlIIlIllIlIIIII = (Step)llllllllllllllllIIlIIlIllIIllIlI.steps.get(llllllllllllllllIIlIIlIllIIllllI);
            if (!(llllllllllllllllIIlIIlIllIIllIII <= llllllllllllllllIIlIIlIllIlIIIII.location)) continue;
            float llllllllllllllllIIlIIlIllIlIIlll = llllllllllllllllIIlIIlIllIlIIIII.location - llllllllllllllllIIlIIlIllIlIIIlI.location;
            float llllllllllllllllIIlIIlIllIlIIllI = (llllllllllllllllIIlIIlIllIIllIII -= llllllllllllllllIIlIIlIllIlIIIlI.location) / llllllllllllllllIIlIIlIllIlIIlll;
            Color llllllllllllllllIIlIIlIllIlIIlII = new Color(1, 1, 1, 1);
            llllllllllllllllIIlIIlIllIlIIlII.a = llllllllllllllllIIlIIlIllIlIIIlI.col.a * (1.0f - llllllllllllllllIIlIIlIllIlIIllI) + llllllllllllllllIIlIIlIllIlIIIII.col.a * llllllllllllllllIIlIIlIllIlIIllI;
            llllllllllllllllIIlIIlIllIlIIlII.r = llllllllllllllllIIlIIlIllIlIIIlI.col.r * (1.0f - llllllllllllllllIIlIIlIllIlIIllI) + llllllllllllllllIIlIIlIllIlIIIII.col.r * llllllllllllllllIIlIIlIllIlIIllI;
            llllllllllllllllIIlIIlIllIlIIlII.g = llllllllllllllllIIlIIlIllIlIIIlI.col.g * (1.0f - llllllllllllllllIIlIIlIllIlIIllI) + llllllllllllllllIIlIIlIllIlIIIII.col.g * llllllllllllllllIIlIIlIllIlIIllI;
            llllllllllllllllIIlIIlIllIlIIlII.b = llllllllllllllllIIlIIlIllIlIIIlI.col.b * (1.0f - llllllllllllllllIIlIIlIllIlIIllI) + llllllllllllllllIIlIIlIllIlIIIII.col.b * llllllllllllllllIIlIIlIllIlIIllI;
            return llllllllllllllllIIlIIlIllIlIIlII;
        }
        return Color.black;
    }

    public Gradient(String llllllllllllllllIIlIIllIIlIlllll, boolean llllllllllllllllIIlIIllIIlIllIll) {
        Gradient llllllllllllllllIIlIIllIIllIIIII;
        llllllllllllllllIIlIIllIIllIIIII.steps = new ArrayList();
        llllllllllllllllIIlIIllIIllIIIII.name = llllllllllllllllIIlIIllIIlIlllll;
        llllllllllllllllIIlIIllIIllIIIII.radial = llllllllllllllllIIlIIllIIlIllIll;
    }

    public void setR(float llllllllllllllllIIlIIllIIIlIIlIl) {
        llllllllllllllllIIlIIllIIIlIlIII.r = llllllllllllllllIIlIIllIIIlIIlIl;
    }

    public float getY2() {
        Gradient llllllllllllllllIIlIIlIlllIlllll;
        return llllllllllllllllIIlIIlIlllIlllll.y2;
    }

    public boolean isRadial() {
        Gradient llllllllllllllllIIlIIllIIlIllIII;
        return llllllllllllllllIIlIIllIIlIllIII.radial;
    }

    public void setX2(float llllllllllllllllIIlIIllIIIIlIlIl) {
        llllllllllllllllIIlIIllIIIIllIIl.x2 = llllllllllllllllIIlIIllIIIIlIlIl;
    }

    public void genImage() {
        Gradient llllllllllllllllIIlIIllIIIllIIll;
        if (llllllllllllllllIIlIIllIIIllIIll.image == null) {
            ImageBuffer llllllllllllllllIIlIIllIIIllIlII = new ImageBuffer(128, 16);
            for (int llllllllllllllllIIlIIllIIIllIlIl = 0; llllllllllllllllIIlIIllIIIllIlIl < 128; ++llllllllllllllllIIlIIllIIIllIlIl) {
                Color llllllllllllllllIIlIIllIIIllIllI = llllllllllllllllIIlIIllIIIllIIll.getColorAt((float)llllllllllllllllIIlIIllIIIllIlIl / 128.0f);
                for (int llllllllllllllllIIlIIllIIIllIlll = 0; llllllllllllllllIIlIIllIIIllIlll < 16; ++llllllllllllllllIIlIIllIIIllIlll) {
                    llllllllllllllllIIlIIllIIIllIlII.setRGBA(llllllllllllllllIIlIIllIIIllIlIl, llllllllllllllllIIlIIllIIIllIlll, llllllllllllllllIIlIIllIIIllIllI.getRedByte(), llllllllllllllllIIlIIllIIIllIllI.getGreenByte(), llllllllllllllllIIlIIllIIIllIllI.getBlueByte(), llllllllllllllllIIlIIllIIIllIllI.getAlphaByte());
                }
            }
            llllllllllllllllIIlIIllIIIllIIll.image = llllllllllllllllIIlIIllIIIllIlII.getImage();
        }
    }

    public float getR() {
        Gradient llllllllllllllllIIlIIllIIIIIIllI;
        return llllllllllllllllIIlIIllIIIIIIllI.r;
    }

    public void setX1(float llllllllllllllllIIlIIllIIIlIIIIl) {
        llllllllllllllllIIlIIllIIIlIIIlI.x1 = llllllllllllllllIIlIIllIIIlIIIIl;
    }

    public float getX2() {
        Gradient llllllllllllllllIIlIIlIlllllIlIl;
        return llllllllllllllllIIlIIlIlllllIlIl.x2;
    }

    public void reference(String llllllllllllllllIIlIIllIIlIIlIIl) {
        llllllllllllllllIIlIIllIIlIIlIlI.ref = llllllllllllllllIIlIIllIIlIIlIIl;
    }

    public void setY2(float llllllllllllllllIIlIIllIIIIIlIlI) {
        llllllllllllllllIIlIIllIIIIIlIll.y2 = llllllllllllllllIIlIIllIIIIIlIlI;
    }

    public Image getImage() {
        Gradient llllllllllllllllIIlIIllIIIlIlIll;
        llllllllllllllllIIlIIllIIIlIlIll.genImage();
        return llllllllllllllllIIlIIllIIIlIlIll.image;
    }

    public void resolve(Diagram llllllllllllllllIIlIIllIIIllllll) {
        Gradient llllllllllllllllIIlIIllIIlIIIIll;
        if (llllllllllllllllIIlIIllIIlIIIIll.ref == null) {
            return;
        }
        Gradient llllllllllllllllIIlIIllIIlIIIIIl = llllllllllllllllIIlIIllIIIllllll.getGradient(llllllllllllllllIIlIIllIIlIIIIll.ref);
        for (int llllllllllllllllIIlIIllIIlIIIlII = 0; llllllllllllllllIIlIIllIIlIIIlII < llllllllllllllllIIlIIllIIlIIIIIl.steps.size(); ++llllllllllllllllIIlIIllIIlIIIlII) {
            llllllllllllllllIIlIIllIIlIIIIll.steps.add(llllllllllllllllIIlIIllIIlIIIIIl.steps.get(llllllllllllllllIIlIIllIIlIIIlII));
        }
    }

    public float getY1() {
        Gradient llllllllllllllllIIlIIlIllllIlIII;
        return llllllllllllllllIIlIIlIllllIlIII.y1;
    }

    private class Step {
        /* synthetic */ float location;
        /* synthetic */ Color col;

        public Step(float lIlIlIllllllIII, Color lIlIlIlllllIIll) {
            Step lIlIlIlllllIllI;
            lIlIlIlllllIllI.location = lIlIlIllllllIII;
            lIlIlIlllllIllI.col = lIlIlIlllllIIll;
        }
    }
}

