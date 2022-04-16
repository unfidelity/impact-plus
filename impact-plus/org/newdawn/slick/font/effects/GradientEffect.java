/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.effects.ConfigurableEffect;
import org.newdawn.slick.font.effects.EffectUtil;

public class GradientEffect
implements ConfigurableEffect {
    private /* synthetic */ boolean cyclic;
    private /* synthetic */ Color topColor;
    private /* synthetic */ Color bottomColor;
    private /* synthetic */ int offset;
    private /* synthetic */ float scale;

    public boolean isCyclic() {
        GradientEffect llIIllllIIlIII;
        return llIIllllIIlIII.cyclic;
    }

    @Override
    public List getValues() {
        GradientEffect llIIlllIllllIl;
        ArrayList<ConfigurableEffect.Value> llIIlllIllllII = new ArrayList<ConfigurableEffect.Value>();
        llIIlllIllllII.add(EffectUtil.colorValue("Top color", llIIlllIllllIl.topColor));
        llIIlllIllllII.add(EffectUtil.colorValue("Bottom color", llIIlllIllllIl.bottomColor));
        llIIlllIllllII.add(EffectUtil.intValue("Offset", llIIlllIllllIl.offset, "This setting allows you to move the gradient up or down. The gradient is normally centered on the glyph."));
        llIIlllIllllII.add(EffectUtil.floatValue("Scale", llIIlllIllllIl.scale, 0.0f, 1.0f, "This setting allows you to change the height of the gradient by apercentage. The gradient is normally the height of most glyphs in the font."));
        llIIlllIllllII.add(EffectUtil.booleanValue("Cyclic", llIIlllIllllIl.cyclic, "If this setting is checked, the gradient will repeat."));
        return llIIlllIllllII;
    }

    public Color getBottomColor() {
        GradientEffect llIIlllllIIIll;
        return llIIlllllIIIll.bottomColor;
    }

    public Color getTopColor() {
        GradientEffect llIIlllllIllII;
        return llIIlllllIllII.topColor;
    }

    public void setBottomColor(Color llIIllllIlllII) {
        llIIllllIlllll.bottomColor = llIIllllIlllII;
    }

    public void setOffset(int llIIllllIlIIll) {
        llIIllllIlIlII.offset = llIIllllIlIIll;
    }

    public GradientEffect(Color llIlIIIIIIIllI, Color llIlIIIIIIIlIl, float llIlIIIIIIlIII) {
        GradientEffect llIlIIIIIIIlll;
        llIlIIIIIIIlll.topColor = Color.cyan;
        llIlIIIIIIIlll.bottomColor = Color.blue;
        llIlIIIIIIIlll.offset = 0;
        llIlIIIIIIIlll.scale = 1.0f;
        llIlIIIIIIIlll.topColor = llIlIIIIIIIllI;
        llIlIIIIIIIlll.bottomColor = llIlIIIIIIIlIl;
        llIlIIIIIIIlll.scale = llIlIIIIIIlIII;
    }

    public int getOffset() {
        GradientEffect llIIllllIllIIl;
        return llIIllllIllIIl.offset;
    }

    public GradientEffect() {
        GradientEffect llIlIIIIIlIIII;
        llIlIIIIIlIIII.topColor = Color.cyan;
        llIlIIIIIlIIII.bottomColor = Color.blue;
        llIlIIIIIlIIII.offset = 0;
        llIlIIIIIlIIII.scale = 1.0f;
    }

    public void setScale(float llIIllllIIllII) {
        llIIllllIIllIl.scale = llIIllllIIllII;
    }

    @Override
    public void draw(BufferedImage llIIlllllllIll, Graphics2D llIIllllllIIll, UnicodeFont llIIlllllllIIl, Glyph llIIlllllllIII) {
        GradientEffect llIIllllllIlII;
        int llIIllllllIlll = llIIlllllllIIl.getAscent();
        float llIIllllllIllI = (float)llIIllllllIlll * llIIllllllIlII.scale;
        float llIIllllllIlIl = (float)(-llIIlllllllIII.getYOffset() + llIIlllllllIIl.getDescent() + llIIllllllIlII.offset + llIIllllllIlll / 2) - llIIllllllIllI / 2.0f;
        llIIllllllIIll.setPaint(new GradientPaint(0.0f, llIIllllllIlIl, llIIllllllIlII.topColor, 0.0f, llIIllllllIlIl + llIIllllllIllI, llIIllllllIlII.bottomColor, llIIllllllIlII.cyclic));
        llIIllllllIIll.fill(llIIlllllllIII.getShape());
    }

    public float getScale() {
        GradientEffect llIIllllIlIIIl;
        return llIIllllIlIIIl.scale;
    }

    public void setCyclic(boolean llIIllllIIIIll) {
        llIIllllIIIIlI.cyclic = llIIllllIIIIll;
    }

    @Override
    public void setValues(List llIIlllIllIIlI) {
        for (ConfigurableEffect.Value llIIlllIllIlIl : llIIlllIllIIlI) {
            if (llIIlllIllIlIl.getName().equals("Top color")) {
                llIIlllIllIIll.topColor = (Color)llIIlllIllIlIl.getObject();
                continue;
            }
            if (llIIlllIllIlIl.getName().equals("Bottom color")) {
                llIIlllIllIIll.bottomColor = (Color)llIIlllIllIlIl.getObject();
                continue;
            }
            if (llIIlllIllIlIl.getName().equals("Offset")) {
                llIIlllIllIIll.offset = (Integer)llIIlllIllIlIl.getObject();
                continue;
            }
            if (llIIlllIllIlIl.getName().equals("Scale")) {
                llIIlllIllIIll.scale = ((Float)llIIlllIllIlIl.getObject()).floatValue();
                continue;
            }
            if (!llIIlllIllIlIl.getName().equals("Cyclic")) continue;
            llIIlllIllIIll.cyclic = (Boolean)llIIlllIllIlIl.getObject();
        }
    }

    public String toString() {
        return "Gradient";
    }

    public void setTopColor(Color llIIlllllIIlll) {
        llIIlllllIIllI.topColor = llIIlllllIIlll;
    }
}

