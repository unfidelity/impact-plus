/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.GlyphMetrics;
import java.awt.font.GlyphVector;
import org.newdawn.slick.Image;
import org.newdawn.slick.UnicodeFont;

public class Glyph {
    private /* synthetic */ short height;
    private /* synthetic */ short yOffset;
    private /* synthetic */ boolean isMissing;
    private /* synthetic */ Image image;
    private /* synthetic */ int codePoint;
    private /* synthetic */ short width;
    private /* synthetic */ Shape shape;

    public void setImage(Image llllllllllllllllIlIllIlIIIIIIlII) {
        llllllllllllllllIlIllIlIIIIIlIlI.image = llllllllllllllllIlIllIlIIIIIIlII;
    }

    public int getCodePoint() {
        Glyph llllllllllllllllIlIllIlIIIllIlll;
        return llllllllllllllllIlIllIlIIIllIlll.codePoint;
    }

    public int getYOffset() {
        Glyph llllllllllllllllIlIllIIllllllIll;
        return llllllllllllllllIlIllIIllllllIll.yOffset;
    }

    public int getHeight() {
        Glyph llllllllllllllllIlIllIlIIIlIIIll;
        return llllllllllllllllIlIllIlIIIlIIIll.height;
    }

    public Image getImage() {
        Glyph llllllllllllllllIlIllIlIIIIIllIl;
        return llllllllllllllllIlIllIlIIIIIllIl.image;
    }

    public boolean isMissing() {
        Glyph llllllllllllllllIlIllIlIIIllIIlI;
        return llllllllllllllllIlIllIlIIIllIIlI.isMissing;
    }

    public int getWidth() {
        Glyph llllllllllllllllIlIllIlIIIlIlIlI;
        return llllllllllllllllIlIllIlIIIlIlIlI.width;
    }

    public void setShape(Shape llllllllllllllllIlIllIlIIIIlIIIl) {
        llllllllllllllllIlIllIlIIIIlIIll.shape = llllllllllllllllIlIllIlIIIIlIIIl;
    }

    public Shape getShape() {
        Glyph llllllllllllllllIlIllIlIIIIlllIl;
        return llllllllllllllllIlIllIlIIIIlllIl.shape;
    }

    public Glyph(int llllllllllllllllIlIllIlIIlIllllI, Rectangle llllllllllllllllIlIllIlIIlIlllIl, GlyphVector llllllllllllllllIlIllIlIIlIIllII, int llllllllllllllllIlIllIlIIlIllIll, UnicodeFont llllllllllllllllIlIllIlIIlIllIlI) {
        int llllllllllllllllIlIllIlIIlIlIlll;
        Glyph llllllllllllllllIlIllIlIIlIlllll;
        llllllllllllllllIlIllIlIIlIlllll.codePoint = llllllllllllllllIlIllIlIIlIllllI;
        GlyphMetrics llllllllllllllllIlIllIlIIlIllIIl = llllllllllllllllIlIllIlIIlIIllII.getGlyphMetrics(llllllllllllllllIlIllIlIIlIllIll);
        int llllllllllllllllIlIllIlIIlIllIII = (int)llllllllllllllllIlIllIlIIlIllIIl.getLSB();
        if (llllllllllllllllIlIllIlIIlIllIII > 0) {
            llllllllllllllllIlIllIlIIlIllIII = 0;
        }
        if ((llllllllllllllllIlIllIlIIlIlIlll = (int)llllllllllllllllIlIllIlIIlIllIIl.getRSB()) > 0) {
            llllllllllllllllIlIllIlIIlIlIlll = 0;
        }
        int llllllllllllllllIlIllIlIIlIlIllI = llllllllllllllllIlIllIlIIlIlllIl.width - llllllllllllllllIlIllIlIIlIllIII - llllllllllllllllIlIllIlIIlIlIlll;
        int llllllllllllllllIlIllIlIIlIlIlII = llllllllllllllllIlIllIlIIlIlllIl.height;
        if (llllllllllllllllIlIllIlIIlIlIllI > 0 && llllllllllllllllIlIllIlIIlIlIlII > 0) {
            int llllllllllllllllIlIllIlIIllIlIlI = llllllllllllllllIlIllIlIIlIllIlI.getPaddingTop();
            int llllllllllllllllIlIllIlIIllIlIIl = llllllllllllllllIlIllIlIIlIllIlI.getPaddingRight();
            int llllllllllllllllIlIllIlIIllIIlIl = llllllllllllllllIlIllIlIIlIllIlI.getPaddingBottom();
            int llllllllllllllllIlIllIlIIllIIIll = llllllllllllllllIlIllIlIIlIllIlI.getPaddingLeft();
            int llllllllllllllllIlIllIlIIllIIIIl = 1;
            llllllllllllllllIlIllIlIIlIlllll.width = (short)(llllllllllllllllIlIllIlIIlIlIllI + llllllllllllllllIlIllIlIIllIIIll + llllllllllllllllIlIllIlIIllIlIIl + llllllllllllllllIlIllIlIIllIIIIl);
            llllllllllllllllIlIllIlIIlIlllll.height = (short)(llllllllllllllllIlIllIlIIlIlIlII + llllllllllllllllIlIllIlIIllIlIlI + llllllllllllllllIlIllIlIIllIIlIl + llllllllllllllllIlIllIlIIllIIIIl);
            llllllllllllllllIlIllIlIIlIlllll.yOffset = (short)(llllllllllllllllIlIllIlIIlIllIlI.getAscent() + llllllllllllllllIlIllIlIIlIlllIl.y - llllllllllllllllIlIllIlIIllIlIlI);
        }
        llllllllllllllllIlIllIlIIlIlllll.shape = llllllllllllllllIlIllIlIIlIIllII.getGlyphOutline(llllllllllllllllIlIllIlIIlIllIll, -llllllllllllllllIlIllIlIIlIlllIl.x + llllllllllllllllIlIllIlIIlIllIlI.getPaddingLeft(), -llllllllllllllllIlIllIlIIlIlllIl.y + llllllllllllllllIlIllIlIIlIllIlI.getPaddingTop());
        llllllllllllllllIlIllIlIIlIlllll.isMissing = !llllllllllllllllIlIllIlIIlIllIlI.getFont().canDisplay((char)llllllllllllllllIlIllIlIIlIllllI);
    }
}

