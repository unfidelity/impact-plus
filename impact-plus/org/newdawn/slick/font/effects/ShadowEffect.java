/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.effects.ConfigurableEffect;
import org.newdawn.slick.font.effects.Effect;
import org.newdawn.slick.font.effects.EffectUtil;
import org.newdawn.slick.font.effects.OutlineEffect;

public class ShadowEffect
implements ConfigurableEffect {
    public static final /* synthetic */ int NUM_KERNELS;
    private /* synthetic */ float xDistance;
    private /* synthetic */ int blurPasses;
    private /* synthetic */ Color color;
    public static final /* synthetic */ float[][] GAUSSIAN_BLUR_KERNELS;
    private /* synthetic */ int blurKernelSize;
    private /* synthetic */ float opacity;
    private /* synthetic */ float yDistance;

    public void setColor(Color lIlllIlIlIIlI) {
        lIlllIlIlIlIl.color = lIlllIlIlIIlI;
    }

    public void setOpacity(float lIlllIIIIlIll) {
        lIlllIIIIlllI.opacity = lIlllIIIIlIll;
    }

    public ShadowEffect() {
        ShadowEffect lIllllIlIIIIl;
        lIllllIlIIIIl.color = Color.black;
        lIllllIlIIIIl.opacity = 0.6f;
        lIllllIlIIIIl.xDistance = 2.0f;
        lIllllIlIIIIl.yDistance = 2.0f;
        lIllllIlIIIIl.blurKernelSize = 0;
        lIllllIlIIIIl.blurPasses = 1;
    }

    private void blur(BufferedImage lIlllIllIllII) {
        ShadowEffect lIlllIllIIlII;
        float[] lIlllIllIlIll = GAUSSIAN_BLUR_KERNELS[lIlllIllIIlII.blurKernelSize - 1];
        Kernel lIlllIllIlIlI = new Kernel(lIlllIllIlIll.length, 1, lIlllIllIlIll);
        Kernel lIlllIllIlIIl = new Kernel(1, lIlllIllIlIll.length, lIlllIllIlIll);
        RenderingHints lIlllIllIlIII = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        ConvolveOp lIlllIllIIlll = new ConvolveOp(lIlllIllIlIlI, 1, lIlllIllIlIII);
        ConvolveOp lIlllIllIIllI = new ConvolveOp(lIlllIllIlIIl, 1, lIlllIllIlIII);
        BufferedImage lIlllIllIIlIl = EffectUtil.getScratchImage();
        for (int lIlllIllIlllI = 0; lIlllIllIlllI < lIlllIllIIlII.blurPasses; ++lIlllIllIlllI) {
            lIlllIllIIlll.filter(lIlllIllIllII, lIlllIllIIlIl);
            lIlllIllIIllI.filter(lIlllIllIIlIl, lIlllIllIllII);
        }
    }

    public float getYDistance() {
        ShadowEffect lIlllIlIIIllI;
        return lIlllIlIIIllI.yDistance;
    }

    public float getOpacity() {
        ShadowEffect lIlllIIIlIIlI;
        return lIlllIIIlIIlI.opacity;
    }

    public float getXDistance() {
        ShadowEffect lIlllIlIIllll;
        return lIlllIlIIllll.xDistance;
    }

    @Override
    public List getValues() {
        ShadowEffect lIllIllllIlII;
        ArrayList<ConfigurableEffect.Value> lIllIllllIIll = new ArrayList<ConfigurableEffect.Value>();
        lIllIllllIIll.add(EffectUtil.colorValue("Color", lIllIllllIlII.color));
        lIllIllllIIll.add(EffectUtil.floatValue("Opacity", lIllIllllIlII.opacity, 0.0f, 1.0f, "This setting sets the translucency of the shadow."));
        lIllIllllIIll.add(EffectUtil.floatValue("X distance", lIllIllllIlII.xDistance, Float.MIN_VALUE, Float.MAX_VALUE, "This setting is the amount of pixels to offset the shadow on the x axis. The glyphs will need padding so the shadow doesn't get clipped."));
        lIllIllllIIll.add(EffectUtil.floatValue("Y distance", lIllIllllIlII.yDistance, Float.MIN_VALUE, Float.MAX_VALUE, "This setting is the amount of pixels to offset the shadow on the y axis. The glyphs will need padding so the shadow doesn't get clipped."));
        ArrayList<String[]> lIllIllllIIlI = new ArrayList<String[]>();
        lIllIllllIIlI.add(new String[]{"None", "0"});
        for (int lIllIllllIlIl = 2; lIllIllllIlIl < 16; ++lIllIllllIlIl) {
            lIllIllllIIlI.add(new String[]{String.valueOf(lIllIllllIlIl)});
        }
        String[][] lIllIllllIIIl = (String[][])lIllIllllIIlI.toArray((T[])new String[lIllIllllIIlI.size()][]);
        lIllIllllIIll.add(EffectUtil.optionValue("Blur kernel size", String.valueOf(lIllIllllIlII.blurKernelSize), lIllIllllIIIl, "This setting controls how many neighboring pixels are used to blur the shadow. Set to \"None\" for no blur."));
        lIllIllllIIll.add(EffectUtil.intValue("Blur passes", lIllIllllIlII.blurPasses, "The setting is the number of times to apply a blur to the shadow. Set to \"0\" for no blur."));
        return lIllIllllIIll;
    }

    public void setYDistance(float lIlllIIllIllI) {
        lIlllIIllIlII.yDistance = lIlllIIllIllI;
    }

    public void setBlurPasses(int lIlllIIIlIlII) {
        lIlllIIIlIlIl.blurPasses = lIlllIIIlIlII;
    }

    public String toString() {
        return "Shadow";
    }

    private static float[][] generatePascalsTriangle(int lIllIlIlIIIll) {
        if (lIllIlIlIIIll < 2) {
            lIllIlIlIIIll = 2;
        }
        float[][] lIllIlIlIIlII = new float[lIllIlIlIIIll][];
        lIllIlIlIIlII[0] = new float[1];
        lIllIlIlIIlII[1] = new float[2];
        lIllIlIlIIlII[0][0] = 1.0f;
        lIllIlIlIIlII[1][0] = 1.0f;
        lIllIlIlIIlII[1][1] = 1.0f;
        for (int lIllIlIlIIllI = 2; lIllIlIlIIllI < lIllIlIlIIIll; ++lIllIlIlIIllI) {
            lIllIlIlIIlII[lIllIlIlIIllI] = new float[lIllIlIlIIllI + 1];
            lIllIlIlIIlII[lIllIlIlIIllI][0] = 1.0f;
            lIllIlIlIIlII[lIllIlIlIIllI][lIllIlIlIIllI] = 1.0f;
            for (int lIllIlIlIIlll = 1; lIllIlIlIIlll < lIllIlIlIIlII[lIllIlIlIIllI].length - 1; ++lIllIlIlIIlll) {
                lIllIlIlIIlII[lIllIlIlIIllI][lIllIlIlIIlll] = lIllIlIlIIlII[lIllIlIlIIllI - 1][lIllIlIlIIlll - 1] + lIllIlIlIIlII[lIllIlIlIIllI - 1][lIllIlIlIIlll];
            }
        }
        return lIllIlIlIIlII;
    }

    private static float[][] generateGaussianBlurKernels(int lIllIllIlIlII) {
        float[][] lIllIllIlIIll = ShadowEffect.generatePascalsTriangle(lIllIllIlIlII);
        float[][] lIllIllIlIIlI = new float[lIllIllIlIIll.length][];
        for (int lIllIllIlIlIl = 0; lIllIllIlIlIl < lIllIllIlIIlI.length; ++lIllIllIlIlIl) {
            float lIllIllIlIlll = 0.0f;
            lIllIllIlIIlI[lIllIllIlIlIl] = new float[lIllIllIlIIll[lIllIllIlIlIl].length];
            for (int lIllIllIllIIl = 0; lIllIllIllIIl < lIllIllIlIIll[lIllIllIlIlIl].length; ++lIllIllIllIIl) {
                lIllIllIlIlll += lIllIllIlIIll[lIllIllIlIlIl][lIllIllIllIIl];
            }
            float lIllIllIlIllI = 1.0f / lIllIllIlIlll;
            for (int lIllIllIllIII = 0; lIllIllIllIII < lIllIllIlIIll[lIllIllIlIlIl].length; ++lIllIllIllIII) {
                lIllIllIlIIlI[lIllIllIlIlIl][lIllIllIllIII] = lIllIllIlIllI * lIllIllIlIIll[lIllIllIlIlIl][lIllIllIllIII];
            }
        }
        return lIllIllIlIIlI;
    }

    public void setBlurKernelSize(int lIlllIIIlllll) {
        lIlllIIlIIIII.blurKernelSize = lIlllIIIlllll;
    }

    public Color getColor() {
        ShadowEffect lIlllIlIllIII;
        return lIlllIlIllIII.color;
    }

    static {
        NUM_KERNELS = 16;
        GAUSSIAN_BLUR_KERNELS = ShadowEffect.generateGaussianBlurKernels(16);
    }

    public void setXDistance(float lIlllIlIIlIll) {
        lIlllIlIIllII.xDistance = lIlllIlIIlIll;
    }

    public ShadowEffect(Color lIllllIIlIlII, int lIllllIIllIII, int lIllllIIlIlll, float lIllllIIlIIIl) {
        ShadowEffect lIllllIIlIlIl;
        lIllllIIlIlIl.color = Color.black;
        lIllllIIlIlIl.opacity = 0.6f;
        lIllllIIlIlIl.xDistance = 2.0f;
        lIllllIIlIlIl.yDistance = 2.0f;
        lIllllIIlIlIl.blurKernelSize = 0;
        lIllllIIlIlIl.blurPasses = 1;
        lIllllIIlIlIl.color = lIllllIIlIlII;
        lIllllIIlIlIl.xDistance = lIllllIIllIII;
        lIllllIIlIlIl.yDistance = lIllllIIlIlll;
        lIllllIIlIlIl.opacity = lIllllIIlIIIl;
    }

    @Override
    public void setValues(List lIllIlllIIIll) {
        for (ConfigurableEffect.Value lIllIlllIlIII : lIllIlllIIIll) {
            if (lIllIlllIlIII.getName().equals("Color")) {
                lIllIlllIIllI.color = (Color)lIllIlllIlIII.getObject();
                continue;
            }
            if (lIllIlllIlIII.getName().equals("Opacity")) {
                lIllIlllIIllI.opacity = ((Float)lIllIlllIlIII.getObject()).floatValue();
                continue;
            }
            if (lIllIlllIlIII.getName().equals("X distance")) {
                lIllIlllIIllI.xDistance = ((Float)lIllIlllIlIII.getObject()).floatValue();
                continue;
            }
            if (lIllIlllIlIII.getName().equals("Y distance")) {
                lIllIlllIIllI.yDistance = ((Float)lIllIlllIlIII.getObject()).floatValue();
                continue;
            }
            if (lIllIlllIlIII.getName().equals("Blur kernel size")) {
                lIllIlllIIllI.blurKernelSize = Integer.parseInt((String)lIllIlllIlIII.getObject());
                continue;
            }
            if (!lIllIlllIlIII.getName().equals("Blur passes")) continue;
            lIllIlllIIllI.blurPasses = (Integer)lIllIlllIlIII.getObject();
        }
    }

    public int getBlurPasses() {
        ShadowEffect lIlllIIIllIlI;
        return lIlllIIIllIlI.blurPasses;
    }

    @Override
    public void draw(BufferedImage lIlllIlllllll, Graphics2D lIlllIllllllI, UnicodeFont lIlllIlllllIl, Glyph lIllllIIIIIIl) {
        ShadowEffect lIllllIIIIIII;
        lIlllIllllllI = (Graphics2D)lIlllIllllllI.create();
        lIlllIllllllI.translate(lIllllIIIIIII.xDistance, lIllllIIIIIII.yDistance);
        lIlllIllllllI.setColor(new Color(lIllllIIIIIII.color.getRed(), lIllllIIIIIII.color.getGreen(), lIllllIIIIIII.color.getBlue(), Math.round(lIllllIIIIIII.opacity * 255.0f)));
        lIlllIllllllI.fill(lIllllIIIIIIl.getShape());
        for (Effect lIllllIIIIlll : lIlllIlllllIl.getEffects()) {
            if (!(lIllllIIIIlll instanceof OutlineEffect)) continue;
            Composite lIllllIIIlIII = lIlllIllllllI.getComposite();
            lIlllIllllllI.setComposite(AlphaComposite.Src);
            lIlllIllllllI.setStroke(((OutlineEffect)lIllllIIIIlll).getStroke());
            lIlllIllllllI.draw(lIllllIIIIIIl.getShape());
            lIlllIllllllI.setComposite(lIllllIIIlIII);
            break;
        }
        lIlllIllllllI.dispose();
        if (lIllllIIIIIII.blurKernelSize > 1 && lIllllIIIIIII.blurKernelSize < 16 && lIllllIIIIIII.blurPasses > 0) {
            lIllllIIIIIII.blur(lIlllIlllllll);
        }
    }

    public int getBlurKernelSize() {
        ShadowEffect lIlllIIlIlllI;
        return lIlllIIlIlllI.blurKernelSize;
    }
}

