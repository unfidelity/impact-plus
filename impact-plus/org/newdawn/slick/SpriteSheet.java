/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class SpriteSheet
extends Image {
    private /* synthetic */ Image[][] subImages;
    private /* synthetic */ int margin;
    private /* synthetic */ int th;
    private /* synthetic */ int spacing;
    private /* synthetic */ int tw;
    private /* synthetic */ Image target;

    public SpriteSheet(String llllllllllllllllIIIIlIlIlIllIIll, int llllllllllllllllIIIIlIlIlIllIIlI, int llllllllllllllllIIIIlIlIlIllIIIl) throws SlickException {
        llllllllllllllllIIIIlIlIlIllIlII(llllllllllllllllIIIIlIlIlIllIIll, llllllllllllllllIIIIlIlIlIllIIlI, llllllllllllllllIIIIlIlIlIllIIIl, null);
        SpriteSheet llllllllllllllllIIIIlIlIlIllIlII;
    }

    @Override
    public void endUse() {
        SpriteSheet llllllllllllllllIIIIlIlIIlIIIlII;
        if (llllllllllllllllIIIIlIlIIlIIIlII.target == llllllllllllllllIIIIlIlIIlIIIlII) {
            super.endUse();
            return;
        }
        llllllllllllllllIIIIlIlIIlIIIlII.target.endUse();
    }

    @Override
    protected void initImpl() {
        SpriteSheet llllllllllllllllIIIIlIlIIlllIlIl;
        if (llllllllllllllllIIIIlIlIIlllIlIl.subImages != null) {
            return;
        }
        int llllllllllllllllIIIIlIlIIlllIlII = (llllllllllllllllIIIIlIlIIlllIlIl.getWidth() - llllllllllllllllIIIIlIlIIlllIlIl.margin * 2 - llllllllllllllllIIIIlIlIIlllIlIl.tw) / (llllllllllllllllIIIIlIlIIlllIlIl.tw + llllllllllllllllIIIIlIlIIlllIlIl.spacing) + 1;
        int llllllllllllllllIIIIlIlIIlllIIll = (llllllllllllllllIIIIlIlIIlllIlIl.getHeight() - llllllllllllllllIIIIlIlIIlllIlIl.margin * 2 - llllllllllllllllIIIIlIlIIlllIlIl.th) / (llllllllllllllllIIIIlIlIIlllIlIl.th + llllllllllllllllIIIIlIlIIlllIlIl.spacing) + 1;
        if ((llllllllllllllllIIIIlIlIIlllIlIl.getHeight() - llllllllllllllllIIIIlIlIIlllIlIl.th) % (llllllllllllllllIIIIlIlIIlllIlIl.th + llllllllllllllllIIIIlIlIIlllIlIl.spacing) != 0) {
            ++llllllllllllllllIIIIlIlIIlllIIll;
        }
        llllllllllllllllIIIIlIlIIlllIlIl.subImages = new Image[llllllllllllllllIIIIlIlIIlllIlII][llllllllllllllllIIIIlIlIIlllIIll];
        for (int llllllllllllllllIIIIlIlIIlllIllI = 0; llllllllllllllllIIIIlIlIIlllIllI < llllllllllllllllIIIIlIlIIlllIlII; ++llllllllllllllllIIIIlIlIIlllIllI) {
            for (int llllllllllllllllIIIIlIlIIlllIlll = 0; llllllllllllllllIIIIlIlIIlllIlll < llllllllllllllllIIIIlIlIIlllIIll; ++llllllllllllllllIIIIlIlIIlllIlll) {
                llllllllllllllllIIIIlIlIIlllIlIl.subImages[llllllllllllllllIIIIlIlIIlllIllI][llllllllllllllllIIIIlIlIIlllIlll] = llllllllllllllllIIIIlIlIIlllIlIl.getSprite(llllllllllllllllIIIIlIlIIlllIllI, llllllllllllllllIIIIlIlIIlllIlll);
            }
        }
    }

    public int getHorizontalCount() {
        SpriteSheet llllllllllllllllIIIIlIlIIlIllIIl;
        llllllllllllllllIIIIlIlIIlIllIIl.target.init();
        llllllllllllllllIIIIlIlIIlIllIIl.initImpl();
        return llllllllllllllllIIIIlIlIIlIllIIl.subImages.length;
    }

    public SpriteSheet(String llllllllllllllllIIIIlIlIlIIlIIII, int llllllllllllllllIIIIlIlIlIIIllll, int llllllllllllllllIIIIlIlIlIIlIlII, Color llllllllllllllllIIIIlIlIlIIlIIll, int llllllllllllllllIIIIlIlIlIIlIIlI) throws SlickException {
        super(llllllllllllllllIIIIlIlIlIIlIIII, false, 2, llllllllllllllllIIIIlIlIlIIlIIll);
        SpriteSheet llllllllllllllllIIIIlIlIlIIlIIIl;
        llllllllllllllllIIIIlIlIlIIlIIIl.margin = 0;
        llllllllllllllllIIIIlIlIlIIlIIIl.target = llllllllllllllllIIIIlIlIlIIlIIIl;
        llllllllllllllllIIIIlIlIlIIlIIIl.tw = llllllllllllllllIIIIlIlIlIIIllll;
        llllllllllllllllIIIIlIlIlIIlIIIl.th = llllllllllllllllIIIIlIlIlIIlIlII;
        llllllllllllllllIIIIlIlIlIIlIIIl.spacing = llllllllllllllllIIIIlIlIlIIlIIlI;
    }

    public void renderInUse(int llllllllllllllllIIIIlIlIIlIIllll, int llllllllllllllllIIIIlIlIIlIIlllI, int llllllllllllllllIIIIlIlIIlIIlIII, int llllllllllllllllIIIIlIlIIlIIIlll) {
        SpriteSheet llllllllllllllllIIIIlIlIIlIlIIII;
        llllllllllllllllIIIIlIlIIlIlIIII.subImages[llllllllllllllllIIIIlIlIIlIIlIII][llllllllllllllllIIIIlIlIIlIIIlll].drawEmbedded(llllllllllllllllIIIIlIlIIlIIllll, llllllllllllllllIIIIlIlIIlIIlllI, llllllllllllllllIIIIlIlIIlIlIIII.tw, llllllllllllllllIIIIlIlIIlIlIIII.th);
    }

    public SpriteSheet(Image llllllllllllllllIIIIlIlIlllIIIIl, int llllllllllllllllIIIIlIlIllIllIlI, int llllllllllllllllIIIIlIlIllIllIIl, int llllllllllllllllIIIIlIlIllIllllI, int llllllllllllllllIIIIlIlIllIlllIl) {
        super(llllllllllllllllIIIIlIlIlllIIIIl);
        SpriteSheet llllllllllllllllIIIIlIlIllIlllII;
        llllllllllllllllIIIIlIlIllIlllII.margin = 0;
        llllllllllllllllIIIIlIlIllIlllII.target = llllllllllllllllIIIIlIlIlllIIIIl;
        llllllllllllllllIIIIlIlIllIlllII.tw = llllllllllllllllIIIIlIlIllIllIlI;
        llllllllllllllllIIIIlIlIllIlllII.th = llllllllllllllllIIIIlIlIllIllIIl;
        llllllllllllllllIIIIlIlIllIlllII.spacing = llllllllllllllllIIIIlIlIllIllllI;
        llllllllllllllllIIIIlIlIllIlllII.margin = llllllllllllllllIIIIlIlIllIlllIl;
        llllllllllllllllIIIIlIlIllIlllII.initImpl();
    }

    public Image getSprite(int llllllllllllllllIIIIlIlIIllIIIII, int llllllllllllllllIIIIlIlIIlIlllII) {
        SpriteSheet llllllllllllllllIIIIlIlIIllIIIIl;
        llllllllllllllllIIIIlIlIIllIIIIl.target.init();
        llllllllllllllllIIIIlIlIIllIIIIl.initImpl();
        if (llllllllllllllllIIIIlIlIIllIIIII < 0 || llllllllllllllllIIIIlIlIIllIIIII >= llllllllllllllllIIIIlIlIIllIIIIl.subImages.length) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("SubImage out of sheet bounds: ").append(llllllllllllllllIIIIlIlIIllIIIII).append(",").append(llllllllllllllllIIIIlIlIIlIlllII)));
        }
        if (llllllllllllllllIIIIlIlIIlIlllII < 0 || llllllllllllllllIIIIlIlIIlIlllII >= llllllllllllllllIIIIlIlIIllIIIIl.subImages[0].length) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("SubImage out of sheet bounds: ").append(llllllllllllllllIIIIlIlIIllIIIII).append(",").append(llllllllllllllllIIIIlIlIIlIlllII)));
        }
        return llllllllllllllllIIIIlIlIIllIIIIl.target.getSubImage(llllllllllllllllIIIIlIlIIllIIIII * (llllllllllllllllIIIIlIlIIllIIIIl.tw + llllllllllllllllIIIIlIlIIllIIIIl.spacing) + llllllllllllllllIIIIlIlIIllIIIIl.margin, llllllllllllllllIIIIlIlIIlIlllII * (llllllllllllllllIIIIlIlIIllIIIIl.th + llllllllllllllllIIIIlIlIIllIIIIl.spacing) + llllllllllllllllIIIIlIlIIllIIIIl.margin, llllllllllllllllIIIIlIlIIllIIIIl.tw, llllllllllllllllIIIIlIlIIllIIIIl.th);
    }

    public SpriteSheet(String llllllllllllllllIIIIlIlIlIlIIllI, int llllllllllllllllIIIIlIlIlIlIIlIl, int llllllllllllllllIIIIlIlIlIlIIlII, Color llllllllllllllllIIIIlIlIlIIllllI) throws SlickException {
        llllllllllllllllIIIIlIlIlIlIIIlI(llllllllllllllllIIIIlIlIlIlIIllI, llllllllllllllllIIIIlIlIlIlIIlIl, llllllllllllllllIIIIlIlIlIlIIlII, llllllllllllllllIIIIlIlIlIIllllI, 0);
        SpriteSheet llllllllllllllllIIIIlIlIlIlIIIlI;
    }

    public SpriteSheet(String llllllllllllllllIIIIlIlIlIIIIIII, InputStream llllllllllllllllIIIIlIlIlIIIIlII, int llllllllllllllllIIIIlIlIIllllllI, int llllllllllllllllIIIIlIlIlIIIIIlI) throws SlickException {
        super(llllllllllllllllIIIIlIlIlIIIIlII, llllllllllllllllIIIIlIlIlIIIIIII, false);
        SpriteSheet llllllllllllllllIIIIlIlIlIIIIllI;
        llllllllllllllllIIIIlIlIlIIIIllI.margin = 0;
        llllllllllllllllIIIIlIlIlIIIIllI.target = llllllllllllllllIIIIlIlIlIIIIllI;
        llllllllllllllllIIIIlIlIlIIIIllI.tw = llllllllllllllllIIIIlIlIIllllllI;
        llllllllllllllllIIIIlIlIlIIIIllI.th = llllllllllllllllIIIIlIlIlIIIIIlI;
    }

    public SpriteSheet(Image llllllllllllllllIIIIlIlIlllIlIll, int llllllllllllllllIIIIlIlIlllIlllI, int llllllllllllllllIIIIlIlIlllIlIIl) {
        super(llllllllllllllllIIIIlIlIlllIlIll);
        SpriteSheet llllllllllllllllIIIIlIlIlllIllII;
        llllllllllllllllIIIIlIlIlllIllII.margin = 0;
        llllllllllllllllIIIIlIlIlllIllII.target = llllllllllllllllIIIIlIlIlllIlIll;
        llllllllllllllllIIIIlIlIlllIllII.tw = llllllllllllllllIIIIlIlIlllIlllI;
        llllllllllllllllIIIIlIlIlllIllII.th = llllllllllllllllIIIIlIlIlllIlIIl;
        llllllllllllllllIIIIlIlIlllIllII.initImpl();
    }

    public Image getSubImage(int llllllllllllllllIIIIlIlIIllIIllI, int llllllllllllllllIIIIlIlIIllIIlIl) {
        SpriteSheet llllllllllllllllIIIIlIlIIllIIlll;
        llllllllllllllllIIIIlIlIIllIIlll.init();
        if (llllllllllllllllIIIIlIlIIllIIllI < 0 || llllllllllllllllIIIIlIlIIllIIllI >= llllllllllllllllIIIIlIlIIllIIlll.subImages.length) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("SubImage out of sheet bounds: ").append(llllllllllllllllIIIIlIlIIllIIllI).append(",").append(llllllllllllllllIIIIlIlIIllIIlIl)));
        }
        if (llllllllllllllllIIIIlIlIIllIIlIl < 0 || llllllllllllllllIIIIlIlIIllIIlIl >= llllllllllllllllIIIIlIlIIllIIlll.subImages[0].length) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("SubImage out of sheet bounds: ").append(llllllllllllllllIIIIlIlIIllIIllI).append(",").append(llllllllllllllllIIIIlIlIIllIIlIl)));
        }
        return llllllllllllllllIIIIlIlIIllIIlll.subImages[llllllllllllllllIIIIlIlIIllIIllI][llllllllllllllllIIIIlIlIIllIIlIl];
    }

    @Override
    public void setTexture(Texture llllllllllllllllIIIIlIlIIIllllIl) {
        SpriteSheet llllllllllllllllIIIIlIlIIIlllllI;
        if (llllllllllllllllIIIIlIlIIIlllllI.target == llllllllllllllllIIIIlIlIIIlllllI) {
            super.setTexture(llllllllllllllllIIIIlIlIIIllllIl);
            return;
        }
        llllllllllllllllIIIIlIlIIIlllllI.target.setTexture(llllllllllllllllIIIIlIlIIIllllIl);
    }

    public SpriteSheet(URL llllllllllllllllIIIIlIlIlllllIll, int llllllllllllllllIIIIlIlIllllIllI, int llllllllllllllllIIIIlIlIlllllIIl) throws SlickException, IOException {
        llllllllllllllllIIIIlIlIlllllIII(new Image(llllllllllllllllIIIIlIlIlllllIll.openStream(), llllllllllllllllIIIIlIlIlllllIll.toString(), false), llllllllllllllllIIIIlIlIllllIllI, llllllllllllllllIIIIlIlIlllllIIl);
        SpriteSheet llllllllllllllllIIIIlIlIlllllIII;
    }

    public SpriteSheet(String llllllllllllllllIIIIlIlIllIIIIIl, int llllllllllllllllIIIIlIlIllIIIIII, int llllllllllllllllIIIIlIlIlIllllll, int llllllllllllllllIIIIlIlIlIlllllI) throws SlickException {
        llllllllllllllllIIIIlIlIlIllllIl(llllllllllllllllIIIIlIlIllIIIIIl, llllllllllllllllIIIIlIlIllIIIIII, llllllllllllllllIIIIlIlIlIllllll, null, llllllllllllllllIIIIlIlIlIlllllI);
        SpriteSheet llllllllllllllllIIIIlIlIlIllllIl;
    }

    public SpriteSheet(Image llllllllllllllllIIIIlIlIllIlIIII, int llllllllllllllllIIIIlIlIllIIlIlI, int llllllllllllllllIIIIlIlIllIIlIIl, int llllllllllllllllIIIIlIlIllIIllIl) {
        llllllllllllllllIIIIlIlIllIIllII(llllllllllllllllIIIIlIlIllIlIIII, llllllllllllllllIIIIlIlIllIIlIlI, llllllllllllllllIIIIlIlIllIIlIIl, llllllllllllllllIIIIlIlIllIIllIl, 0);
        SpriteSheet llllllllllllllllIIIIlIlIllIIllII;
    }

    @Override
    public void startUse() {
        SpriteSheet llllllllllllllllIIIIlIlIIlIIIIlI;
        if (llllllllllllllllIIIIlIlIIlIIIIlI.target == llllllllllllllllIIIIlIlIIlIIIIlI) {
            super.startUse();
            return;
        }
        llllllllllllllllIIIIlIlIIlIIIIlI.target.startUse();
    }

    public int getVerticalCount() {
        SpriteSheet llllllllllllllllIIIIlIlIIlIlIlll;
        llllllllllllllllIIIIlIlIIlIlIlll.target.init();
        llllllllllllllllIIIIlIlIIlIlIlll.initImpl();
        return llllllllllllllllIIIIlIlIIlIlIlll.subImages[0].length;
    }
}

