/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.util.rainbow;

import java.awt.Color;

public class ColorUtil {
    private /* synthetic */ float m_Alpha;
    public /* synthetic */ Color m_BaseColor;
    private /* synthetic */ float[] m_HSB;

    public float GetLightness() {
        ColorUtil lllllllllllllllllIIIllIIlIIllIIl;
        return lllllllllllllllllIIIllIIlIIllIIl.m_HSB[2];
    }

    public Color GetColorWithBrightness(float lllllllllllllllllIIIllIIlIlIIIlI) {
        ColorUtil lllllllllllllllllIIIllIIlIlIIlIl;
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIlIlIIlIl.m_HSB[0], lllllllllllllllllIIIllIIlIlIIlIl.m_HSB[1], lllllllllllllllllIIIllIIlIlIIIlI, lllllllllllllllllIIIllIIlIlIIlIl.m_Alpha);
    }

    private static float FutureClientColorCalculation(float lllllllllllllllllIIIllIIIIIllllI, float lllllllllllllllllIIIllIIIIIlllIl, float lllllllllllllllllIIIllIIIIIlllll) {
        if (lllllllllllllllllIIIllIIIIIlllll < 0.0f) {
            lllllllllllllllllIIIllIIIIIlllll += 1.0f;
        }
        if (lllllllllllllllllIIIllIIIIIlllll > 1.0f) {
            lllllllllllllllllIIIllIIIIIlllll -= 1.0f;
        }
        if (6.0f * lllllllllllllllllIIIllIIIIIlllll < 1.0f) {
            return lllllllllllllllllIIIllIIIIIllllI + (lllllllllllllllllIIIllIIIIIlllIl - lllllllllllllllllIIIllIIIIIllllI) * 6.0f * lllllllllllllllllIIIllIIIIIlllll;
        }
        if (2.0f * lllllllllllllllllIIIllIIIIIlllll < 1.0f) {
            return lllllllllllllllllIIIllIIIIIlllIl;
        }
        if (3.0f * lllllllllllllllllIIIllIIIIIlllll < 2.0f) {
            return lllllllllllllllllIIIllIIIIIllllI + (lllllllllllllllllIIIllIIIIIlllIl - lllllllllllllllllIIIllIIIIIllllI) * 6.0f * (0.6666667f - lllllllllllllllllIIIllIIIIIlllll);
        }
        return lllllllllllllllllIIIllIIIIIllllI;
    }

    public static Color GetColorWithHSBArray(float[] lllllllllllllllllIIIllIIIlIlIIll) {
        return ColorUtil.GetRainbowColorFromArray(lllllllllllllllllIIIllIIIlIlIIll, 1.0f);
    }

    public ColorUtil(float lllllllllllllllllIIIllIIllIIIllI, float lllllllllllllllllIIIllIIlIlllllI, float lllllllllllllllllIIIllIIlIllllIl, float lllllllllllllllllIIIllIIllIIIIll) {
        ColorUtil lllllllllllllllllIIIllIIllIIIlll;
        int lllllllllllllllllIIIllIIllIIIIlI = 3;
        float[] lllllllllllllllllIIIllIIllIIIIIl = new float[]{lllllllllllllllllIIIllIIllIIIllI, lllllllllllllllllIIIllIIlIlllllI, lllllllllllllllllIIIllIIlIllllIl};
        lllllllllllllllllIIIllIIllIIIlll.m_HSB = lllllllllllllllllIIIllIIllIIIIIl;
        lllllllllllllllllIIIllIIllIIIlll.m_Alpha = lllllllllllllllllIIIllIIllIIIIll;
        lllllllllllllllllIIIllIIllIIIlll.m_BaseColor = ColorUtil.GetRainbowColorFromArray(lllllllllllllllllIIIllIIllIIIlll.m_HSB, lllllllllllllllllIIIllIIllIIIIll);
    }

    public float GetHue() {
        ColorUtil lllllllllllllllllIIIllIIlIlIIIII;
        return lllllllllllllllllIIIllIIlIlIIIII.m_HSB[0];
    }

    public static Color GetRainbowColorFromArray(float[] lllllllllllllllllIIIllIIIlIlIllI, float lllllllllllllllllIIIllIIIlIlIlIl) {
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIIlIlIllI[0], lllllllllllllllllIIIllIIIlIlIllI[1], lllllllllllllllllIIIllIIIlIlIllI[2], lllllllllllllllllIIIllIIIlIlIlIl);
    }

    public ColorUtil(Color lllllllllllllllllIIIllIIlllIlIlI) {
        ColorUtil lllllllllllllllllIIIllIIlllIllIl;
        lllllllllllllllllIIIllIIlllIllIl.m_BaseColor = lllllllllllllllllIIIllIIlllIlIlI;
        lllllllllllllllllIIIllIIlllIllIl.m_HSB = ColorUtil.GenerateHSB(lllllllllllllllllIIIllIIlllIlIlI);
        lllllllllllllllllIIIllIIlllIllIl.m_Alpha = (float)lllllllllllllllllIIIllIIlllIlIlI.getAlpha() / 255.0f;
    }

    public Color GetColorWithHue(float lllllllllllllllllIIIllIIlIIlIIII) {
        ColorUtil lllllllllllllllllIIIllIIlIIlIIIl;
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIlIIlIIII, lllllllllllllllllIIIllIIlIIlIIIl.m_HSB[1], lllllllllllllllllIIIllIIlIIlIIIl.m_HSB[2], lllllllllllllllllIIIllIIlIIlIIIl.m_Alpha);
    }

    public Color GetColorWithModifiedHue() {
        ColorUtil lllllllllllllllllIIIllIIIlIlllII;
        return ColorUtil.ColorRainbowWithDefaultAlpha((lllllllllllllllllIIIllIIIlIlllII.m_HSB[0] + 180.0f) % 360.0f, lllllllllllllllllIIIllIIIlIlllII.m_HSB[1], lllllllllllllllllIIIllIIIlIlllII.m_HSB[2]);
    }

    public Color GetColorWithSaturation(float lllllllllllllllllIIIllIIlIIIllII) {
        ColorUtil lllllllllllllllllIIIllIIlIIIllIl;
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIlIIIllIl.m_HSB[0], lllllllllllllllllIIIllIIlIIIllII, lllllllllllllllllIIIllIIlIIIllIl.m_HSB[2], lllllllllllllllllIIIllIIlIIIllIl.m_Alpha);
    }

    public Color GetColorWithLightnessMax(float lllllllllllllllllIIIllIIlIllIIll) {
        ColorUtil lllllllllllllllllIIIllIIlIllIIlI;
        lllllllllllllllllIIIllIIlIllIIll = (100.0f - lllllllllllllllllIIIllIIlIllIIll) / 100.0f;
        lllllllllllllllllIIIllIIlIllIIll = Math.max(0.0f, lllllllllllllllllIIIllIIlIllIIlI.m_HSB[2] * lllllllllllllllllIIIllIIlIllIIll);
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIlIllIIlI.m_HSB[0], lllllllllllllllllIIIllIIlIllIIlI.m_HSB[1], lllllllllllllllllIIIllIIlIllIIll, lllllllllllllllllIIIllIIlIllIIlI.m_Alpha);
    }

    public String toString() {
        ColorUtil lllllllllllllllllIIIllIIlIlllIII;
        return String.valueOf(new StringBuilder().insert(0, "HSLColor[h=").append(lllllllllllllllllIIIllIIlIlllIII.m_HSB[0]).append(",s=").append(lllllllllllllllllIIIllIIlIlllIII.m_HSB[1]).append(",l=").append(lllllllllllllllllIIIllIIlIlllIII.m_HSB[2]).append(",alpha=").append(lllllllllllllllllIIIllIIlIlllIII.m_Alpha).append("]"));
    }

    public ColorUtil(float lllllllllllllllllIIIllIIlllIIIII, float lllllllllllllllllIIIllIIlllIIIll, float lllllllllllllllllIIIllIIllIllllI) {
        lllllllllllllllllIIIllIIlllIIlIl(lllllllllllllllllIIIllIIlllIIIII, lllllllllllllllllIIIllIIlllIIIll, lllllllllllllllllIIIllIIllIllllI, 1.0f);
        ColorUtil lllllllllllllllllIIIllIIlllIIlIl;
    }

    public static Color ColorRainbowWithDefaultAlpha(float lllllllllllllllllIIIllIIIIIlIIlI, float lllllllllllllllllIIIllIIIIIlIIII, float lllllllllllllllllIIIllIIIIIIlllI) {
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIIIIlIIlI, lllllllllllllllllIIIllIIIIIlIIII, lllllllllllllllllIIIllIIIIIIlllI, 1.0f);
    }

    public float GetAlpha() {
        ColorUtil lllllllllllllllllIIIllIIlIlIlIII;
        return lllllllllllllllllIIIllIIlIlIlIII.m_Alpha;
    }

    public static float[] GenerateHSB(Color lllllllllllllllllIIIllIIIllIlIlI) {
        float lllllllllllllllllIIIllIIIllIlIll;
        float lllllllllllllllllIIIllIIIllIllIl;
        float[] lllllllllllllllllIIIllIIIlllIlII = lllllllllllllllllIIIllIIIllIlIlI.getRGBColorComponents(null);
        float lllllllllllllllllIIIllIIIlllIIll = lllllllllllllllllIIIllIIIlllIlII[0];
        float lllllllllllllllllIIIllIIIlllIIlI = lllllllllllllllllIIIllIIIlllIlII[1];
        float lllllllllllllllllIIIllIIIlllIIIl = lllllllllllllllllIIIllIIIlllIlII[2];
        float lllllllllllllllllIIIllIIIlllIIII = Math.min(lllllllllllllllllIIIllIIIlllIIll, Math.min(lllllllllllllllllIIIllIIIlllIIlI, lllllllllllllllllIIIllIIIlllIIIl));
        float lllllllllllllllllIIIllIIIllIllll = Math.max(lllllllllllllllllIIIllIIIlllIIll, Math.max(lllllllllllllllllIIIllIIIlllIIlI, lllllllllllllllllIIIllIIIlllIIIl));
        float lllllllllllllllllIIIllIIIllIlllI = 0.0f;
        if (lllllllllllllllllIIIllIIIllIllll == lllllllllllllllllIIIllIIIlllIIII) {
            lllllllllllllllllIIIllIIIllIlllI = 0.0f;
            float lllllllllllllllllIIIllIIIlllllII = lllllllllllllllllIIIllIIIllIllll;
        } else if (lllllllllllllllllIIIllIIIllIllll == lllllllllllllllllIIIllIIIlllIIll) {
            lllllllllllllllllIIIllIIIllIlllI = (60.0f * (lllllllllllllllllIIIllIIIlllIIlI - lllllllllllllllllIIIllIIIlllIIIl) / (lllllllllllllllllIIIllIIIllIllll - lllllllllllllllllIIIllIIIlllIIII) + 360.0f) % 360.0f;
            float lllllllllllllllllIIIllIIIllllIll = lllllllllllllllllIIIllIIIllIllll;
        } else if (lllllllllllllllllIIIllIIIllIllll == lllllllllllllllllIIIllIIIlllIIlI) {
            lllllllllllllllllIIIllIIIllIlllI = 60.0f * (lllllllllllllllllIIIllIIIlllIIIl - lllllllllllllllllIIIllIIIlllIIll) / (lllllllllllllllllIIIllIIIllIllll - lllllllllllllllllIIIllIIIlllIIII) + 120.0f;
            float lllllllllllllllllIIIllIIIllllIlI = lllllllllllllllllIIIllIIIllIllll;
        } else {
            if (lllllllllllllllllIIIllIIIllIllll == lllllllllllllllllIIIllIIIlllIIIl) {
                lllllllllllllllllIIIllIIIllIlllI = 60.0f * (lllllllllllllllllIIIllIIIlllIIll - lllllllllllllllllIIIllIIIlllIIlI) / (lllllllllllllllllIIIllIIIllIllll - lllllllllllllllllIIIllIIIlllIIII) + 240.0f;
            }
            lllllllllllllllllIIIllIIIllIllIl = lllllllllllllllllIIIllIIIllIllll;
        }
        void lllllllllllllllllIIIllIIIllIllII = (lllllllllllllllllIIIllIIIllIllIl + lllllllllllllllllIIIllIIIlllIIII) / 2.0f;
        if (lllllllllllllllllIIIllIIIllIllll == lllllllllllllllllIIIllIIIlllIIII) {
            float lllllllllllllllllIIIllIIIllllIIl = 0.0f;
        } else {
            float lllllllllllllllllIIIllIIIlllIlll = Math.min((float)lllllllllllllllllIIIllIIIllIllII, 0.5f);
            float lllllllllllllllllIIIllIIIlllIllI = lllllllllllllllllIIIllIIIllIllll;
            if (lllllllllllllllllIIIllIIIlllIlll <= 0.0f) {
                float lllllllllllllllllIIIllIIIllllIII = (lllllllllllllllllIIIllIIIlllIllI - lllllllllllllllllIIIllIIIlllIIII) / (lllllllllllllllllIIIllIIIllIllll + lllllllllllllllllIIIllIIIlllIIII);
            } else {
                lllllllllllllllllIIIllIIIllIlIll = (lllllllllllllllllIIIllIIIlllIllI - lllllllllllllllllIIIllIIIlllIIII) / (2.0f - lllllllllllllllllIIIllIIIllIllll - lllllllllllllllllIIIllIIIlllIIII);
            }
        }
        return new float[]{lllllllllllllllllIIIllIIIllIlllI, lllllllllllllllllIIIllIIIllIlIll * 100.0f, lllllllllllllllllIIIllIIIllIllII * 100.0f};
    }

    public static String GenerateMCColorString(String lllllllllllllllllIIIllIIIIllllIl) {
        int lllllllllllllllllIIIllIIIIlllIII;
        int lllllllllllllllllIIIllIIIIllllII = 113;
        int lllllllllllllllllIIIllIIIIlllIll = 24;
        int lllllllllllllllllIIIllIIIIlllIlI = lllllllllllllllllIIIllIIIIllllIl.length();
        char[] lllllllllllllllllIIIllIIIIlllIIl = new char[lllllllllllllllllIIIllIIIIlllIlI];
        int lllllllllllllllllIIIllIIIIllIlll = lllllllllllllllllIIIllIIIIlllIII = lllllllllllllllllIIIllIIIIlllIlI - 1;
        char[] lllllllllllllllllIIIllIIIIllIllI = lllllllllllllllllIIIllIIIIlllIIl;
        int lllllllllllllllllIIIllIIIIllIlIl = 24;
        int lllllllllllllllllIIIllIIIIllIlII = 113;
        while (lllllllllllllllllIIIllIIIIllIlll >= 0) {
            char[] lllllllllllllllllIIIllIIIlIIIIlI = lllllllllllllllllIIIllIIIIllIllI;
            int lllllllllllllllllIIIllIIIlIIIIIl = lllllllllllllllllIIIllIIIIlllIII--;
            char lllllllllllllllllIIIllIIIlIIIIII = lllllllllllllllllIIIllIIIIllllIl.charAt(lllllllllllllllllIIIllIIIlIIIIIl);
            lllllllllllllllllIIIllIIIlIIIIlI[lllllllllllllllllIIIllIIIlIIIIIl] = (char)(lllllllllllllllllIIIllIIIlIIIIII ^ 0x71);
            if (lllllllllllllllllIIIllIIIIlllIII < 0) break;
            char[] lllllllllllllllllIIIllIIIIllllll = lllllllllllllllllIIIllIIIIllIllI;
            int lllllllllllllllllIIIllIIIIlllllI = lllllllllllllllllIIIllIIIIlllIII--;
            lllllllllllllllllIIIllIIIIllllll[lllllllllllllllllIIIllIIIIlllllI] = (char)(lllllllllllllllllIIIllIIIIllllIl.charAt(lllllllllllllllllIIIllIIIIlllllI) ^ 0x18);
            lllllllllllllllllIIIllIIIIllIlll = lllllllllllllllllIIIllIIIIlllIII;
        }
        return new String(lllllllllllllllllIIIllIIIIllIllI);
    }

    public ColorUtil(float[] lllllllllllllllllIIIllIIllIlIIII, float lllllllllllllllllIIIllIIllIIllll) {
        ColorUtil lllllllllllllllllIIIllIIllIlIIIl;
        lllllllllllllllllIIIllIIllIlIIIl.m_HSB = lllllllllllllllllIIIllIIllIlIIII;
        lllllllllllllllllIIIllIIllIlIIIl.m_Alpha = lllllllllllllllllIIIllIIllIIllll;
        lllllllllllllllllIIIllIIllIlIIIl.m_BaseColor = ColorUtil.GetRainbowColorFromArray(lllllllllllllllllIIIllIIllIlIIII, lllllllllllllllllIIIllIIllIIllll);
    }

    public float GetSaturation() {
        ColorUtil lllllllllllllllllIIIllIIlIIlllIl;
        return lllllllllllllllllIIIllIIlIIlllIl.m_HSB[1];
    }

    public Color GetColorWithLightnessMin(float lllllllllllllllllIIIllIIlIlIlIll) {
        ColorUtil lllllllllllllllllIIIllIIlIlIllII;
        lllllllllllllllllIIIllIIlIlIlIll = (100.0f + lllllllllllllllllIIIllIIlIlIlIll) / 100.0f;
        lllllllllllllllllIIIllIIlIlIlIll = Math.min(100.0f, lllllllllllllllllIIIllIIlIlIllII.m_HSB[2] * lllllllllllllllllIIIllIIlIlIlIll);
        return ColorUtil.GetRainbowColor(lllllllllllllllllIIIllIIlIlIllII.m_HSB[0], lllllllllllllllllIIIllIIlIlIllII.m_HSB[1], lllllllllllllllllIIIllIIlIlIlIll, lllllllllllllllllIIIllIIlIlIllII.m_Alpha);
    }

    public static Color GetRainbowColor(float lllllllllllllllllIIIlIlllllIlIII, float lllllllllllllllllIIIlIlllllIIlll, float lllllllllllllllllIIIlIlllllIllIl, float lllllllllllllllllIIIlIlllllIIlIl) {
        float lllllllllllllllllIIIlIlllllIlIll;
        if (lllllllllllllllllIIIlIlllllIIlll < 0.0f || lllllllllllllllllIIIlIlllllIIlll > 100.0f) {
            throw new IllegalArgumentException("Color parameter outside of expected range - Saturation");
        }
        if (lllllllllllllllllIIIlIlllllIllIl < 0.0f || lllllllllllllllllIIIlIlllllIllIl > 100.0f) {
            throw new IllegalArgumentException("Color parameter outside of expected range - Lightness");
        }
        if (lllllllllllllllllIIIlIlllllIIlIl < 0.0f || lllllllllllllllllIIIlIlllllIIlIl > 1.0f) {
            throw new IllegalArgumentException("Color parameter outside of expected range - Alpha");
        }
        lllllllllllllllllIIIlIlllllIlIII %= 360.0f;
        lllllllllllllllllIIIlIlllllIlIII /= 360.0f;
        lllllllllllllllllIIIlIlllllIIlll /= 100.0f;
        if ((double)(lllllllllllllllllIIIlIlllllIllIl /= 100.0f) < 0.0) {
            float lllllllllllllllllIIIlIllllllIIII = lllllllllllllllllIIIlIlllllIllIl * (1.0f + lllllllllllllllllIIIlIlllllIIlll);
        } else {
            lllllllllllllllllIIIlIlllllIlIll = lllllllllllllllllIIIlIlllllIllIl + lllllllllllllllllIIIlIlllllIIlll - lllllllllllllllllIIIlIlllllIIlll * lllllllllllllllllIIIlIlllllIllIl;
        }
        lllllllllllllllllIIIlIlllllIIlll = 2.0f * lllllllllllllllllIIIlIlllllIllIl - lllllllllllllllllIIIlIlllllIlIll;
        lllllllllllllllllIIIlIlllllIllIl = Math.max(0.0f, ColorUtil.FutureClientColorCalculation(lllllllllllllllllIIIlIlllllIIlll, lllllllllllllllllIIIlIlllllIlIll, lllllllllllllllllIIIlIlllllIlIII + 0.33333334f));
        float lllllllllllllllllIIIlIlllllIlIlI = Math.max(0.0f, ColorUtil.FutureClientColorCalculation(lllllllllllllllllIIIlIlllllIIlll, lllllllllllllllllIIIlIlllllIlIll, lllllllllllllllllIIIlIlllllIlIII));
        lllllllllllllllllIIIlIlllllIIlll = Math.max(0.0f, ColorUtil.FutureClientColorCalculation(lllllllllllllllllIIIlIlllllIIlll, lllllllllllllllllIIIlIlllllIlIll, lllllllllllllllllIIIlIlllllIlIII - 0.33333334f));
        lllllllllllllllllIIIlIlllllIllIl = Math.min(lllllllllllllllllIIIlIlllllIllIl, 1.0f);
        float lllllllllllllllllIIIlIlllllIlIIl = Math.min(lllllllllllllllllIIIlIlllllIlIlI, 1.0f);
        lllllllllllllllllIIIlIlllllIIlll = Math.min(lllllllllllllllllIIIlIlllllIIlll, 1.0f);
        return new Color(lllllllllllllllllIIIlIlllllIllIl, lllllllllllllllllIIIlIlllllIlIIl, lllllllllllllllllIIIlIlllllIIlll, lllllllllllllllllIIIlIlllllIIlIl);
    }

    public ColorUtil(float[] lllllllllllllllllIIIllIIllIllIlI) {
        lllllllllllllllllIIIllIIllIllIIl(lllllllllllllllllIIIllIIllIllIlI, 1.0f);
        ColorUtil lllllllllllllllllIIIllIIllIllIIl;
    }

    public Color GetLocalColor() {
        ColorUtil lllllllllllllllllIIIllIIlIIlIlll;
        return lllllllllllllllllIIIllIIlIIlIlll.m_BaseColor;
    }
}

