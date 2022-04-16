/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.effects.ConfigurableEffect;
import org.newdawn.slick.font.effects.EffectUtil;

public class ColorEffect
implements ConfigurableEffect {
    private /* synthetic */ Color color;

    public Color getColor() {
        ColorEffect lllllllllllllllllIIlllllIIllllIl;
        return lllllllllllllllllIIlllllIIllllIl.color;
    }

    public String toString() {
        return "Color";
    }

    @Override
    public List getValues() {
        ColorEffect lllllllllllllllllIIlllllIIllIIll;
        ArrayList<ConfigurableEffect.Value> lllllllllllllllllIIlllllIIllIIlI = new ArrayList<ConfigurableEffect.Value>();
        lllllllllllllllllIIlllllIIllIIlI.add(EffectUtil.colorValue("Color", lllllllllllllllllIIlllllIIllIIll.color));
        return lllllllllllllllllIIlllllIIllIIlI;
    }

    @Override
    public void setValues(List lllllllllllllllllIIlllllIIlIIllI) {
        for (ConfigurableEffect.Value lllllllllllllllllIIlllllIIlIlIll : lllllllllllllllllIIlllllIIlIIllI) {
            ColorEffect lllllllllllllllllIIlllllIIlIlIIl;
            if (!lllllllllllllllllIIlllllIIlIlIll.getName().equals("Color")) continue;
            lllllllllllllllllIIlllllIIlIlIIl.setColor((Color)lllllllllllllllllIIlllllIIlIlIll.getObject());
        }
    }

    public void setColor(Color lllllllllllllllllIIlllllIIlllIIl) {
        if (lllllllllllllllllIIlllllIIlllIIl == null) {
            throw new IllegalArgumentException("color cannot be null.");
        }
        lllllllllllllllllIIlllllIIlllIlI.color = lllllllllllllllllIIlllllIIlllIIl;
    }

    public ColorEffect(Color lllllllllllllllllIIlllllIlIIllIl) {
        ColorEffect lllllllllllllllllIIlllllIlIIlllI;
        lllllllllllllllllIIlllllIlIIlllI.color = Color.white;
        lllllllllllllllllIIlllllIlIIlllI.color = lllllllllllllllllIIlllllIlIIllIl;
    }

    @Override
    public void draw(BufferedImage lllllllllllllllllIIlllllIlIIIllI, Graphics2D lllllllllllllllllIIlllllIlIIIlIl, UnicodeFont lllllllllllllllllIIlllllIlIIIlII, Glyph lllllllllllllllllIIlllllIlIIIIll) {
        ColorEffect lllllllllllllllllIIlllllIlIIIIlI;
        lllllllllllllllllIIlllllIlIIIlIl.setColor(lllllllllllllllllIIlllllIlIIIIlI.color);
        lllllllllllllllllIIlllllIlIIIlIl.fill(lllllllllllllllllIIlllllIlIIIIll.getShape());
    }

    public ColorEffect() {
        ColorEffect lllllllllllllllllIIlllllIlIlIIIl;
        lllllllllllllllllIIlllllIlIlIIIl.color = Color.white;
    }
}

