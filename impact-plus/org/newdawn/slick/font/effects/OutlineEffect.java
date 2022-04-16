/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.effects.ConfigurableEffect;
import org.newdawn.slick.font.effects.EffectUtil;

public class OutlineEffect
implements ConfigurableEffect {
    private /* synthetic */ int join;
    private /* synthetic */ Stroke stroke;
    private /* synthetic */ Color color;
    private /* synthetic */ float width;

    @Override
    public void setValues(List llllIlIllIIlllI) {
        for (ConfigurableEffect.Value llllIlIllIlIIll : llllIlIllIIlllI) {
            if (llllIlIllIlIIll.getName().equals("Color")) {
                llllIlIllIIllll.color = (Color)llllIlIllIlIIll.getObject();
                continue;
            }
            if (llllIlIllIlIIll.getName().equals("Width")) {
                llllIlIllIIllll.width = ((Float)llllIlIllIlIIll.getObject()).floatValue();
                continue;
            }
            if (!llllIlIllIlIIll.getName().equals("Join")) continue;
            llllIlIllIIllll.join = Integer.parseInt((String)llllIlIllIlIIll.getObject());
        }
    }

    public Stroke getStroke() {
        OutlineEffect llllIlIlllIlIll;
        if (llllIlIlllIlIll.stroke == null) {
            return new BasicStroke(llllIlIlllIlIll.width, 2, llllIlIlllIlIll.join);
        }
        return llllIlIlllIlIll.stroke;
    }

    public OutlineEffect(int llllIllIIIlIIlI, Color llllIllIIIIlllI) {
        OutlineEffect llllIllIIIlIIll;
        llllIllIIIlIIll.width = 2.0f;
        llllIllIIIlIIll.color = Color.black;
        llllIllIIIlIIll.join = 2;
        llllIllIIIlIIll.width = llllIllIIIlIIlI;
        llllIllIIIlIIll.color = llllIllIIIIlllI;
    }

    public void setWidth(int llllIlIlllllIlI) {
        llllIlIlllllIll.width = llllIlIlllllIlI;
    }

    public float getWidth() {
        OutlineEffect llllIllIIIIIIIl;
        return llllIllIIIIIIIl.width;
    }

    public String toString() {
        return "Outline";
    }

    public void setJoin(int llllIlIlllIIIIl) {
        llllIlIlllIIIII.join = llllIlIlllIIIIl;
    }

    public Color getColor() {
        OutlineEffect llllIlIlllllIII;
        return llllIlIlllllIII.color;
    }

    public int getJoin() {
        OutlineEffect llllIlIlllIllll;
        return llllIlIlllIllll.join;
    }

    public OutlineEffect() {
        OutlineEffect llllIllIIIllIII;
        llllIllIIIllIII.width = 2.0f;
        llllIllIIIllIII.color = Color.black;
        llllIllIIIllIII.join = 2;
    }

    @Override
    public void draw(BufferedImage llllIllIIIIlIIl, Graphics2D llllIllIIIIlIII, UnicodeFont llllIllIIIIIlll, Glyph llllIllIIIIIIll) {
        OutlineEffect llllIllIIIIIlIl;
        llllIllIIIIlIII = (Graphics2D)llllIllIIIIlIII.create();
        if (llllIllIIIIIlIl.stroke != null) {
            llllIllIIIIlIII.setStroke(llllIllIIIIIlIl.stroke);
        } else {
            llllIllIIIIlIII.setStroke(llllIllIIIIIlIl.getStroke());
        }
        llllIllIIIIlIII.setColor(llllIllIIIIIlIl.color);
        llllIllIIIIlIII.draw(llllIllIIIIIIll.getShape());
        llllIllIIIIlIII.dispose();
    }

    @Override
    public List getValues() {
        OutlineEffect llllIlIllIllIIl;
        ArrayList<ConfigurableEffect.Value> llllIlIllIllIlI = new ArrayList<ConfigurableEffect.Value>();
        llllIlIllIllIlI.add(EffectUtil.colorValue("Color", llllIlIllIllIIl.color));
        llllIlIllIllIlI.add(EffectUtil.floatValue("Width", llllIlIllIllIIl.width, 0.1f, 999.0f, "This setting controls the width of the outline. The glyphs will need padding so the outline doesn't get clipped."));
        llllIlIllIllIlI.add(EffectUtil.optionValue("Join", String.valueOf(llllIlIllIllIIl.join), new String[][]{{"Bevel", "2"}, {"Miter", "0"}, {"Round", "1"}}, "This setting defines how the corners of the outline are drawn. This is usually only noticeable at large outline widths."));
        return llllIlIllIllIlI;
    }

    public void setColor(Color llllIlIllllIIll) {
        llllIlIllllIIlI.color = llllIlIllllIIll;
    }

    public void setStroke(Stroke llllIlIlllIIlIl) {
        llllIlIlllIIllI.stroke = llllIlIlllIIlIl;
    }
}

