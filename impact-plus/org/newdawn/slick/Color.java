/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.Serializable;
import java.nio.FloatBuffer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class Color
implements Serializable {
    public /* synthetic */ float b;
    public static final /* synthetic */ Color transparent;
    protected transient /* synthetic */ SGL GL;
    public static final /* synthetic */ Color lightGray;
    public static final /* synthetic */ Color white;
    public static final /* synthetic */ Color blue;
    public static final /* synthetic */ Color gray;
    public static final /* synthetic */ Color pink;
    public static final /* synthetic */ Color cyan;
    public /* synthetic */ float a;
    private static final /* synthetic */ long serialVersionUID = 1393939L;
    public /* synthetic */ float g;
    public static final /* synthetic */ Color magenta;
    public static final /* synthetic */ Color orange;
    public static final /* synthetic */ Color red;
    public static final /* synthetic */ Color green;
    public static final /* synthetic */ Color black;
    public static final /* synthetic */ Color yellow;
    public /* synthetic */ float r;
    public static final /* synthetic */ Color darkGray;

    public void add(Color lllllllllllllllllIlIIIllllIIlIIl) {
        lllllllllllllllllIlIIIllllIIlIlI.r += lllllllllllllllllIlIIIllllIIlIIl.r;
        lllllllllllllllllIlIIIllllIIlIlI.g += lllllllllllllllllIlIIIllllIIlIIl.g;
        lllllllllllllllllIlIIIllllIIlIlI.b += lllllllllllllllllIlIIIllllIIlIIl.b;
        lllllllllllllllllIlIIIllllIIlIlI.a += lllllllllllllllllIlIIIllllIIlIIl.a;
    }

    public String toString() {
        Color lllllllllllllllllIlIIlIIIIIIIlII;
        return String.valueOf(new StringBuilder().append("Color (").append(lllllllllllllllllIlIIlIIIIIIIlII.r).append(",").append(lllllllllllllllllIlIIlIIIIIIIlII.g).append(",").append(lllllllllllllllllIlIIlIIIIIIIlII.b).append(",").append(lllllllllllllllllIlIIlIIIIIIIlII.a).append(")"));
    }

    public Color(Color lllllllllllllllllIlIIlIIlIIIlIll) {
        Color lllllllllllllllllIlIIlIIlIIIllIl;
        lllllllllllllllllIlIIlIIlIIIllIl.GL = Renderer.get();
        lllllllllllllllllIlIIlIIlIIIllIl.a = 1.0f;
        lllllllllllllllllIlIIlIIlIIIllIl.r = lllllllllllllllllIlIIlIIlIIIlIll.r;
        lllllllllllllllllIlIIlIIlIIIllIl.g = lllllllllllllllllIlIIlIIlIIIlIll.g;
        lllllllllllllllllIlIIlIIlIIIllIl.b = lllllllllllllllllIlIIlIIlIIIlIll.b;
        lllllllllllllllllIlIIlIIlIIIllIl.a = lllllllllllllllllIlIIlIIlIIIlIll.a;
    }

    public Color(float lllllllllllllllllIlIIlIIIlIIlIII, float lllllllllllllllllIlIIlIIIlIIIlll, float lllllllllllllllllIlIIlIIIlIIIllI, float lllllllllllllllllIlIIlIIIlIIIlIl) {
        Color lllllllllllllllllIlIIlIIIlIIlllI;
        lllllllllllllllllIlIIlIIIlIIlllI.GL = Renderer.get();
        lllllllllllllllllIlIIlIIIlIIlllI.a = 1.0f;
        lllllllllllllllllIlIIlIIIlIIlllI.r = Math.min(lllllllllllllllllIlIIlIIIlIIlIII, 1.0f);
        lllllllllllllllllIlIIlIIIlIIlllI.g = Math.min(lllllllllllllllllIlIIlIIIlIIIlll, 1.0f);
        lllllllllllllllllIlIIlIIIlIIlllI.b = Math.min(lllllllllllllllllIlIIlIIIlIIIllI, 1.0f);
        lllllllllllllllllIlIIlIIIlIIlllI.a = Math.min(lllllllllllllllllIlIIlIIIlIIIlIl, 1.0f);
    }

    public Color(int lllllllllllllllllIlIIlIIIIlIIIlI) {
        Color lllllllllllllllllIlIIlIIIIlIIIll;
        lllllllllllllllllIlIIlIIIIlIIIll.GL = Renderer.get();
        lllllllllllllllllIlIIlIIIIlIIIll.a = 1.0f;
        int lllllllllllllllllIlIIlIIIIlIIIIl = (lllllllllllllllllIlIIlIIIIlIIIlI & 0xFF0000) >> 16;
        int lllllllllllllllllIlIIlIIIIlIIIII = (lllllllllllllllllIlIIlIIIIlIIIlI & 0xFF00) >> 8;
        int lllllllllllllllllIlIIlIIIIIlllll = lllllllllllllllllIlIIlIIIIlIIIlI & 0xFF;
        int lllllllllllllllllIlIIlIIIIIllllI = (lllllllllllllllllIlIIlIIIIlIIIlI & 0xFF000000) >> 24;
        if (lllllllllllllllllIlIIlIIIIIllllI < 0) {
            lllllllllllllllllIlIIlIIIIIllllI += 256;
        }
        if (lllllllllllllllllIlIIlIIIIIllllI == 0) {
            lllllllllllllllllIlIIlIIIIIllllI = 255;
        }
        lllllllllllllllllIlIIlIIIIlIIIll.r = (float)lllllllllllllllllIlIIlIIIIlIIIIl / 255.0f;
        lllllllllllllllllIlIIlIIIIlIIIll.g = (float)lllllllllllllllllIlIIlIIIIlIIIII / 255.0f;
        lllllllllllllllllIlIIlIIIIlIIIll.b = (float)lllllllllllllllllIlIIlIIIIIlllll / 255.0f;
        lllllllllllllllllIlIIlIIIIlIIIll.a = (float)lllllllllllllllllIlIIlIIIIIllllI / 255.0f;
    }

    public Color(FloatBuffer lllllllllllllllllIlIIlIIIllllIlI) {
        Color lllllllllllllllllIlIIlIIIllllIll;
        lllllllllllllllllIlIIlIIIllllIll.GL = Renderer.get();
        lllllllllllllllllIlIIlIIIllllIll.a = 1.0f;
        lllllllllllllllllIlIIlIIIllllIll.r = lllllllllllllllllIlIIlIIIllllIlI.get();
        lllllllllllllllllIlIIlIIIllllIll.g = lllllllllllllllllIlIIlIIIllllIlI.get();
        lllllllllllllllllIlIIlIIIllllIll.b = lllllllllllllllllIlIIlIIIllllIlI.get();
        lllllllllllllllllIlIIlIIIllllIll.a = lllllllllllllllllIlIIlIIIllllIlI.get();
    }

    static {
        transparent = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        white = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        yellow = new Color(1.0f, 1.0f, 0.0f, 1.0f);
        red = new Color(1.0f, 0.0f, 0.0f, 1.0f);
        blue = new Color(0.0f, 0.0f, 1.0f, 1.0f);
        green = new Color(0.0f, 1.0f, 0.0f, 1.0f);
        black = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        gray = new Color(0.5f, 0.5f, 0.5f, 1.0f);
        cyan = new Color(0.0f, 1.0f, 1.0f, 1.0f);
        darkGray = new Color(0.3f, 0.3f, 0.3f, 1.0f);
        lightGray = new Color(0.7f, 0.7f, 0.7f, 1.0f);
        pink = new Color(255, 175, 175, 255);
        orange = new Color(255, 200, 0, 255);
        magenta = new Color(255, 0, 255, 255);
    }

    public int getAlpha() {
        Color lllllllllllllllllIlIIIlllllIlIIl;
        return (int)(lllllllllllllllllIlIIIlllllIlIIl.a * 255.0f);
    }

    public boolean equals(Object lllllllllllllllllIlIIlIIIIIIlIIl) {
        if (lllllllllllllllllIlIIlIIIIIIlIIl instanceof Color) {
            Color lllllllllllllllllIlIIlIIIIIIlIII;
            Color lllllllllllllllllIlIIlIIIIIIlIll = (Color)lllllllllllllllllIlIIlIIIIIIlIIl;
            return lllllllllllllllllIlIIlIIIIIIlIll.r == lllllllllllllllllIlIIlIIIIIIlIII.r && lllllllllllllllllIlIIlIIIIIIlIll.g == lllllllllllllllllIlIIlIIIIIIlIII.g && lllllllllllllllllIlIIlIIIIIIlIll.b == lllllllllllllllllIlIIlIIIIIIlIII.b && lllllllllllllllllIlIIlIIIIIIlIll.a == lllllllllllllllllIlIIlIIIIIIlIII.a;
        }
        return false;
    }

    public Color darker(float lllllllllllllllllIlIIIlllllllIII) {
        Color lllllllllllllllllIlIIIlllllllIIl;
        lllllllllllllllllIlIIIlllllllIII = 1.0f - lllllllllllllllllIlIIIlllllllIII;
        Color lllllllllllllllllIlIIIlllllllIlI = new Color(lllllllllllllllllIlIIIlllllllIIl.r * lllllllllllllllllIlIIIlllllllIII, lllllllllllllllllIlIIIlllllllIIl.g * lllllllllllllllllIlIIIlllllllIII, lllllllllllllllllIlIIIlllllllIIl.b * lllllllllllllllllIlIIIlllllllIII, lllllllllllllllllIlIIIlllllllIIl.a);
        return lllllllllllllllllIlIIIlllllllIlI;
    }

    public int getAlphaByte() {
        Color lllllllllllllllllIlIIIllllIlllII;
        return (int)(lllllllllllllllllIlIIIllllIlllII.a * 255.0f);
    }

    public Color brighter() {
        Color lllllllllllllllllIlIIIllllllIlIl;
        return lllllllllllllllllIlIIIllllllIlIl.brighter(0.2f);
    }

    public int getBlueByte() {
        Color lllllllllllllllllIlIIIllllIlllll;
        return (int)(lllllllllllllllllIlIIIllllIlllll.b * 255.0f);
    }

    public static Color decode(String lllllllllllllllllIlIIlIIIIIlIlIl) {
        return new Color(Integer.decode(lllllllllllllllllIlIIlIIIIIlIlIl));
    }

    public Color multiply(Color lllllllllllllllllIlIIIllllIIllIl) {
        Color lllllllllllllllllIlIIIllllIlIIII;
        return new Color(lllllllllllllllllIlIIIllllIlIIII.r * lllllllllllllllllIlIIIllllIIllIl.r, lllllllllllllllllIlIIIllllIlIIII.g * lllllllllllllllllIlIIIllllIIllIl.g, lllllllllllllllllIlIIIllllIlIIII.b * lllllllllllllllllIlIIIllllIIllIl.b, lllllllllllllllllIlIIIllllIlIIII.a * lllllllllllllllllIlIIIllllIIllIl.a);
    }

    public int getRedByte() {
        Color lllllllllllllllllIlIIIlllllIIllI;
        return (int)(lllllllllllllllllIlIIIlllllIIllI.r * 255.0f);
    }

    public void scale(float lllllllllllllllllIlIIIllllIIIIIl) {
        lllllllllllllllllIlIIIllllIIIIlI.r *= lllllllllllllllllIlIIIllllIIIIIl;
        lllllllllllllllllIlIIIllllIIIIlI.g *= lllllllllllllllllIlIIIllllIIIIIl;
        lllllllllllllllllIlIIIllllIIIIlI.b *= lllllllllllllllllIlIIIllllIIIIIl;
        lllllllllllllllllIlIIIllllIIIIlI.a *= lllllllllllllllllIlIIIllllIIIIIl;
    }

    public Color darker() {
        Color lllllllllllllllllIlIIlIIIIIIIIII;
        return lllllllllllllllllIlIIlIIIIIIIIII.darker(0.5f);
    }

    public int getGreenByte() {
        Color lllllllllllllllllIlIIIlllllIIIlI;
        return (int)(lllllllllllllllllIlIIIlllllIIIlI.g * 255.0f);
    }

    public Color(float lllllllllllllllllIlIIlIIIllIlIll, float lllllllllllllllllIlIIlIIIllIlIIl, float lllllllllllllllllIlIIlIIIllIIIIl) {
        Color lllllllllllllllllIlIIlIIIllIllIl;
        lllllllllllllllllIlIIlIIIllIllIl.GL = Renderer.get();
        lllllllllllllllllIlIIlIIIllIllIl.a = 1.0f;
        lllllllllllllllllIlIIlIIIllIllIl.r = lllllllllllllllllIlIIlIIIllIlIll;
        lllllllllllllllllIlIIlIIIllIllIl.g = lllllllllllllllllIlIIlIIIllIlIIl;
        lllllllllllllllllIlIIlIIIllIllIl.b = lllllllllllllllllIlIIlIIIllIIIIl;
        lllllllllllllllllIlIIlIIIllIllIl.a = 1.0f;
    }

    public Color(int lllllllllllllllllIlIIlIIIIlllIll, int lllllllllllllllllIlIIlIIIIlllIlI, int lllllllllllllllllIlIIlIIIIlllIIl) {
        Color lllllllllllllllllIlIIlIIIIllllII;
        lllllllllllllllllIlIIlIIIIllllII.GL = Renderer.get();
        lllllllllllllllllIlIIlIIIIllllII.a = 1.0f;
        lllllllllllllllllIlIIlIIIIllllII.r = (float)lllllllllllllllllIlIIlIIIIlllIll / 255.0f;
        lllllllllllllllllIlIIlIIIIllllII.g = (float)lllllllllllllllllIlIIlIIIIlllIlI / 255.0f;
        lllllllllllllllllIlIIlIIIIllllII.b = (float)lllllllllllllllllIlIIlIIIIlllIIl / 255.0f;
        lllllllllllllllllIlIIlIIIIllllII.a = 1.0f;
    }

    public Color scaleCopy(float lllllllllllllllllIlIIIlllIllIIll) {
        Color lllllllllllllllllIlIIIlllIllIlII;
        Color lllllllllllllllllIlIIIlllIllIIlI = new Color(lllllllllllllllllIlIIIlllIllIlII.r, lllllllllllllllllIlIIIlllIllIlII.g, lllllllllllllllllIlIIIlllIllIlII.b, lllllllllllllllllIlIIIlllIllIlII.a);
        lllllllllllllllllIlIIIlllIllIIlI.r *= lllllllllllllllllIlIIIlllIllIIll;
        lllllllllllllllllIlIIIlllIllIIlI.g *= lllllllllllllllllIlIIIlllIllIIll;
        lllllllllllllllllIlIIIlllIllIIlI.b *= lllllllllllllllllIlIIIlllIllIIll;
        lllllllllllllllllIlIIIlllIllIIlI.a *= lllllllllllllllllIlIIIlllIllIIll;
        return lllllllllllllllllIlIIIlllIllIIlI;
    }

    public int hashCode() {
        Color lllllllllllllllllIlIIlIIIIIlIIII;
        return (int)(lllllllllllllllllIlIIlIIIIIlIIII.r + lllllllllllllllllIlIIlIIIIIlIIII.g + lllllllllllllllllIlIIlIIIIIlIIII.b + lllllllllllllllllIlIIlIIIIIlIIII.a) * 255;
    }

    public int getGreen() {
        Color lllllllllllllllllIlIIIlllllIllll;
        return (int)(lllllllllllllllllIlIIIlllllIllll.g * 255.0f);
    }

    public Color addToCopy(Color lllllllllllllllllIlIIIlllIlllIIl) {
        Color lllllllllllllllllIlIIIlllIlllIlI;
        Color lllllllllllllllllIlIIIlllIlllIll = new Color(lllllllllllllllllIlIIIlllIlllIlI.r, lllllllllllllllllIlIIIlllIlllIlI.g, lllllllllllllllllIlIIIlllIlllIlI.b, lllllllllllllllllIlIIIlllIlllIlI.a);
        lllllllllllllllllIlIIIlllIlllIll.r += lllllllllllllllllIlIIIlllIlllIIl.r;
        lllllllllllllllllIlIIIlllIlllIll.g += lllllllllllllllllIlIIIlllIlllIIl.g;
        lllllllllllllllllIlIIIlllIlllIll.b += lllllllllllllllllIlIIIlllIlllIIl.b;
        lllllllllllllllllIlIIIlllIlllIll.a += lllllllllllllllllIlIIIlllIlllIIl.a;
        return lllllllllllllllllIlIIIlllIlllIll;
    }

    public void bind() {
        Color lllllllllllllllllIlIIlIIIIIlIIll;
        lllllllllllllllllIlIIlIIIIIlIIll.GL.glColor4f(lllllllllllllllllIlIIlIIIIIlIIll.r, lllllllllllllllllIlIIlIIIIIlIIll.g, lllllllllllllllllIlIIlIIIIIlIIll.b, lllllllllllllllllIlIIlIIIIIlIIll.a);
    }

    public Color(int lllllllllllllllllIlIIlIIIIllIIlI, int lllllllllllllllllIlIIlIIIIllIIIl, int lllllllllllllllllIlIIlIIIIllIIII, int lllllllllllllllllIlIIlIIIIlIllll) {
        Color lllllllllllllllllIlIIlIIIIllIIll;
        lllllllllllllllllIlIIlIIIIllIIll.GL = Renderer.get();
        lllllllllllllllllIlIIlIIIIllIIll.a = 1.0f;
        lllllllllllllllllIlIIlIIIIllIIll.r = (float)lllllllllllllllllIlIIlIIIIllIIlI / 255.0f;
        lllllllllllllllllIlIIlIIIIllIIll.g = (float)lllllllllllllllllIlIIlIIIIllIIIl / 255.0f;
        lllllllllllllllllIlIIlIIIIllIIll.b = (float)lllllllllllllllllIlIIlIIIIllIIII / 255.0f;
        lllllllllllllllllIlIIlIIIIllIIll.a = (float)lllllllllllllllllIlIIlIIIIlIllll / 255.0f;
    }

    public Color brighter(float lllllllllllllllllIlIIIllllIlIlII) {
        Color lllllllllllllllllIlIIIllllIllIII;
        Color lllllllllllllllllIlIIIllllIlIllI = new Color(lllllllllllllllllIlIIIllllIllIII.r * (lllllllllllllllllIlIIIllllIlIlII += 1.0f), lllllllllllllllllIlIIIllllIllIII.g * lllllllllllllllllIlIIIllllIlIlII, lllllllllllllllllIlIIIllllIllIII.b * lllllllllllllllllIlIIIllllIlIlII, lllllllllllllllllIlIIIllllIllIII.a);
        return lllllllllllllllllIlIIIllllIlIllI;
    }

    public int getRed() {
        Color lllllllllllllllllIlIIIllllllIIIl;
        return (int)(lllllllllllllllllIlIIIllllllIIIl.r * 255.0f);
    }

    public int getBlue() {
        Color lllllllllllllllllIlIIIlllllIlIll;
        return (int)(lllllllllllllllllIlIIIlllllIlIll.b * 255.0f);
    }
}

