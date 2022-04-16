/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.effects.Effect;
import org.newdawn.slick.font.effects.EffectUtil;

public class FilterEffect
implements Effect {
    private /* synthetic */ BufferedImageOp filter;

    public FilterEffect(BufferedImageOp llIlIIIllIlIlIl) {
        FilterEffect llIlIIIllIllIII;
        llIlIIIllIllIII.filter = llIlIIIllIlIlIl;
    }

    public FilterEffect() {
        FilterEffect llIlIIIllIlllII;
    }

    @Override
    public void draw(BufferedImage llIlIIIllIIlIlI, Graphics2D llIlIIIllIIllll, UnicodeFont llIlIIIllIIlllI, Glyph llIlIIIllIIllIl) {
        FilterEffect llIlIIIllIlIIIl;
        BufferedImage llIlIIIllIIllII = EffectUtil.getScratchImage();
        llIlIIIllIlIIIl.filter.filter(llIlIIIllIIlIlI, llIlIIIllIIllII);
        llIlIIIllIIlIlI.getGraphics().drawImage(llIlIIIllIIllII, 0, 0, null);
    }

    public void setFilter(BufferedImageOp llIlIIIllIIIIlI) {
        llIlIIIllIIIIIl.filter = llIlIIIllIIIIlI;
    }

    public BufferedImageOp getFilter() {
        FilterEffect llIlIIIllIIIlll;
        return llIlIIIllIIIlll.filter;
    }
}

