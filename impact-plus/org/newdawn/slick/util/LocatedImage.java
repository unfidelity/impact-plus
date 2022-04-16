/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class LocatedImage {
    private /* synthetic */ float width;
    private /* synthetic */ float height;
    private /* synthetic */ Color filter;
    private /* synthetic */ int x;
    private /* synthetic */ int y;
    private /* synthetic */ Image image;

    public float getHeight() {
        LocatedImage lllllllllllllllllIllIIIlIlIIlIIl;
        return lllllllllllllllllIllIIIlIlIIlIIl.height;
    }

    public LocatedImage(Image lllllllllllllllllIllIIIlIlIIlllI, int lllllllllllllllllIllIIIlIlIIllIl, int lllllllllllllllllIllIIIlIlIlIIII) {
        LocatedImage lllllllllllllllllIllIIIlIlIIllll;
        lllllllllllllllllIllIIIlIlIIllll.filter = Color.white;
        lllllllllllllllllIllIIIlIlIIllll.image = lllllllllllllllllIllIIIlIlIIlllI;
        lllllllllllllllllIllIIIlIlIIllll.x = lllllllllllllllllIllIIIlIlIIllIl;
        lllllllllllllllllIllIIIlIlIIllll.y = lllllllllllllllllIllIIIlIlIlIIII;
        lllllllllllllllllIllIIIlIlIIllll.width = lllllllllllllllllIllIIIlIlIIlllI.getWidth();
        lllllllllllllllllIllIIIlIlIIllll.height = lllllllllllllllllIllIIIlIlIIlllI.getHeight();
    }

    public void setWidth(float lllllllllllllllllIllIIIlIIlllIlI) {
        lllllllllllllllllIllIIIlIIlllIll.width = lllllllllllllllllIllIIIlIIlllIlI;
    }

    public Color getColor() {
        LocatedImage lllllllllllllllllIllIIIlIIllIIlI;
        return lllllllllllllllllIllIIIlIIllIIlI.filter;
    }

    public float getWidth() {
        LocatedImage lllllllllllllllllIllIIIlIlIIIllI;
        return lllllllllllllllllIllIIIlIlIIIllI.width;
    }

    public int getY() {
        LocatedImage lllllllllllllllllIllIIIlIIlIIIII;
        return lllllllllllllllllIllIIIlIIlIIIII.y;
    }

    public void setY(int lllllllllllllllllIllIIIlIIlIIlll) {
        lllllllllllllllllIllIIIlIIlIIllI.y = lllllllllllllllllIllIIIlIIlIIlll;
    }

    public void setColor(Color lllllllllllllllllIllIIIlIIllIlII) {
        lllllllllllllllllIllIIIlIIllIlll.filter = lllllllllllllllllIllIIIlIIllIlII;
    }

    public int getX() {
        LocatedImage lllllllllllllllllIllIIIlIIlIIIlI;
        return lllllllllllllllllIllIIIlIIlIIIlI.x;
    }

    public void setX(int lllllllllllllllllIllIIIlIIlIllIl) {
        lllllllllllllllllIllIIIlIIlIlllI.x = lllllllllllllllllIllIIIlIIlIllIl;
    }

    public void setHeight(float lllllllllllllllllIllIIIlIlIIIIII) {
        lllllllllllllllllIllIIIlIlIIIIll.height = lllllllllllllllllIllIIIlIlIIIIII;
    }

    public void draw() {
        LocatedImage lllllllllllllllllIllIIIlIIIlllIl;
        lllllllllllllllllIllIIIlIIIlllIl.image.draw(lllllllllllllllllIllIIIlIIIlllIl.x, lllllllllllllllllIllIIIlIIIlllIl.y, lllllllllllllllllIllIIIlIIIlllIl.width, lllllllllllllllllIllIIIlIIIlllIl.height, lllllllllllllllllIllIIIlIIIlllIl.filter);
    }
}

