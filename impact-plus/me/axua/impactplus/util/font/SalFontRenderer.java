/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.StringUtils
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.util.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.axua.impactplus.util.font.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class SalFontRenderer {
    private /* synthetic */ String name;
    private /* synthetic */ int prevScaleFactor;
    private /* synthetic */ UnicodeFont unicodeFont;
    public final /* synthetic */ int FONT_HEIGHT = 9;
    private static final /* synthetic */ Pattern COLOR_CODE_PATTERN;
    private /* synthetic */ float size;
    private final /* synthetic */ int[] colorCodes;
    private final /* synthetic */ Map<String, Float> cachedStringWidth;
    private /* synthetic */ float antiAliasingFactor;

    public static Font getFontByName(String llllllllllllllllIIlIlllIllIIIlII) throws FontFormatException, IOException {
        return SalFontRenderer.getFontFromInput("/assets/font/font.ttf");
    }

    public float getWidth(String llllllllllllllllIIlIlllIIIIlllIl) {
        SalFontRenderer llllllllllllllllIIlIlllIIIIlllII;
        if (llllllllllllllllIIlIlllIIIIlllII.cachedStringWidth.size() > 1000) {
            llllllllllllllllIIlIlllIIIIlllII.cachedStringWidth.clear();
        }
        return llllllllllllllllIIlIlllIIIIlllII.cachedStringWidth.computeIfAbsent(llllllllllllllllIIlIlllIIIIlllIl, llllllllllllllllIIlIllIllIIllllI -> {
            SalFontRenderer llllllllllllllllIIlIllIllIIlllIl;
            return Float.valueOf((float)llllllllllllllllIIlIllIllIIlllIl.unicodeFont.getWidth(ChatColor.stripColor(llllllllllllllllIIlIlllIIIIlllIl)) / llllllllllllllllIIlIllIllIIlllIl.antiAliasingFactor);
        }).floatValue();
    }

    public List<String> splitString(String llllllllllllllllIIlIllIllllIlllI, int llllllllllllllllIIlIllIllllIllIl) {
        ArrayList<String> llllllllllllllllIIlIllIllllIllII = new ArrayList<String>();
        String[] llllllllllllllllIIlIllIllllIlIll = llllllllllllllllIIlIllIllllIlllI.split(" ");
        StringBuilder llllllllllllllllIIlIllIllllIlIlI = new StringBuilder();
        for (String llllllllllllllllIIlIllIlllllIIII : llllllllllllllllIIlIllIllllIlIll) {
            SalFontRenderer llllllllllllllllIIlIllIllllIllll;
            String llllllllllllllllIIlIllIlllllIIIl = String.valueOf(new StringBuilder().append((Object)llllllllllllllllIIlIllIllllIlIlI).append(" ").append(llllllllllllllllIIlIllIlllllIIII));
            if (llllllllllllllllIIlIllIllllIllll.getWidth(llllllllllllllllIIlIllIlllllIIIl) >= (float)llllllllllllllllIIlIllIllllIllIl) {
                llllllllllllllllIIlIllIllllIllII.add(String.valueOf(llllllllllllllllIIlIllIllllIlIlI));
                llllllllllllllllIIlIllIllllIlIlI = new StringBuilder();
            }
            llllllllllllllllIIlIllIllllIlIlI.append(llllllllllllllllIIlIllIlllllIIII).append(" ");
        }
        llllllllllllllllIIlIllIllllIllII.add(String.valueOf(llllllllllllllllIIlIllIllllIlIlI));
        return llllllllllllllllIIlIllIllllIllII;
    }

    public SalFontRenderer(String llllllllllllllllIIlIlllIllIIlIll, int llllllllllllllllIIlIlllIllIIlIlI, int llllllllllllllllIIlIlllIllIIlIIl) {
        llllllllllllllllIIlIlllIllIIllII(new Font(llllllllllllllllIIlIlllIllIIlIll, llllllllllllllllIIlIlllIllIIlIlI, llllllllllllllllIIlIlllIllIIlIIl));
        SalFontRenderer llllllllllllllllIIlIlllIllIIllII;
    }

    public void drawCenteredTextScaled(String llllllllllllllllIIlIlllIIIllIlII, int llllllllllllllllIIlIlllIIIllIIll, int llllllllllllllllIIlIlllIIIllIIlI, int llllllllllllllllIIlIlllIIIllIlll, double llllllllllllllllIIlIlllIIIllIllI) {
        SalFontRenderer llllllllllllllllIIlIlllIIIlllIll;
        GL11.glPushMatrix();
        GL11.glTranslated((double)llllllllllllllllIIlIlllIIIllIIll, (double)llllllllllllllllIIlIlllIIIllIIlI, (double)0.0);
        GL11.glScaled((double)llllllllllllllllIIlIlllIIIllIllI, (double)llllllllllllllllIIlIlllIIIllIllI, (double)llllllllllllllllIIlIlllIIIllIllI);
        llllllllllllllllIIlIlllIIIlllIll.drawCenteredString(llllllllllllllllIIlIlllIIIllIlII, 0.0f, 0.0f, llllllllllllllllIIlIlllIIIllIlll);
        GL11.glPopMatrix();
    }

    public String trimStringToWidth(String llllllllllllllllIIlIllIlllIIlllI, int llllllllllllllllIIlIllIlllIIllIl) {
        SalFontRenderer llllllllllllllllIIlIllIlllIIllII;
        return llllllllllllllllIIlIllIlllIIllII.trimStringToWidth(llllllllllllllllIIlIllIlllIIlllI, llllllllllllllllIIlIllIlllIIllIl, false);
    }

    public int drawStringWithShadow(String llllllllllllllllIIlIlllIIlIlIlII, float llllllllllllllllIIlIlllIIlIlIIll, float llllllllllllllllIIlIlllIIlIlIlll, int llllllllllllllllIIlIlllIIlIlIIIl) {
        SalFontRenderer llllllllllllllllIIlIlllIIlIllIlI;
        if (llllllllllllllllIIlIlllIIlIlIlII == null || llllllllllllllllIIlIlllIIlIlIlII == "") {
            return 0;
        }
        llllllllllllllllIIlIlllIIlIllIlI.drawString(StringUtils.stripControlCodes((String)llllllllllllllllIIlIlllIIlIlIlII), llllllllllllllllIIlIlllIIlIlIIll + 0.5f, llllllllllllllllIIlIlllIIlIlIlll + 0.5f, 0);
        return llllllllllllllllIIlIlllIIlIllIlI.drawString(llllllllllllllllIIlIlllIIlIlIlII, llllllllllllllllIIlIlllIIlIlIIll, llllllllllllllllIIlIlllIIlIlIlll, llllllllllllllllIIlIlllIIlIlIIIl);
    }

    public void drawCenteredStringWithShadow(String llllllllllllllllIIlIlllIIIlIIlII, float llllllllllllllllIIlIlllIIIlIlIII, float llllllllllllllllIIlIlllIIIlIIIlI, int llllllllllllllllIIlIlllIIIlIIllI) {
        SalFontRenderer llllllllllllllllIIlIlllIIIlIlIlI;
        llllllllllllllllIIlIlllIIIlIlIlI.drawCenteredString(StringUtils.stripControlCodes((String)llllllllllllllllIIlIlllIIIlIIlII), llllllllllllllllIIlIlllIIIlIlIII + 0.5f, llllllllllllllllIIlIlllIIIlIIIlI + 0.5f, 0);
        llllllllllllllllIIlIlllIIIlIlIlI.drawCenteredString(llllllllllllllllIIlIlllIIIlIIlII, llllllllllllllllIIlIlllIIIlIlIII, llllllllllllllllIIlIlllIIIlIIIlI, llllllllllllllllIIlIlllIIIlIIllI);
    }

    public int drawString(String llllllllllllllllIIlIlllIIllllIIl, float llllllllllllllllIIlIlllIIllllIII, float llllllllllllllllIIlIlllIIlllIlll, int llllllllllllllllIIlIlllIlIIIIlIl) {
        SalFontRenderer llllllllllllllllIIlIlllIlIIIlIIl;
        if (llllllllllllllllIIlIlllIIllllIIl == null) {
            return 0;
        }
        ScaledResolution llllllllllllllllIIlIlllIlIIIIlII = new ScaledResolution(Minecraft.getMinecraft());
        try {
            if (llllllllllllllllIIlIlllIlIIIIlII.getScaleFactor() != llllllllllllllllIIlIlllIlIIIlIIl.prevScaleFactor) {
                llllllllllllllllIIlIlllIlIIIlIIl.prevScaleFactor = llllllllllllllllIIlIlllIlIIIIlII.getScaleFactor();
                llllllllllllllllIIlIlllIlIIIlIIl.unicodeFont = new UnicodeFont(SalFontRenderer.getFontByName(llllllllllllllllIIlIlllIlIIIlIIl.name).deriveFont(llllllllllllllllIIlIlllIlIIIlIIl.size * (float)llllllllllllllllIIlIlllIlIIIlIIl.prevScaleFactor / 2.0f));
                llllllllllllllllIIlIlllIlIIIlIIl.unicodeFont.addAsciiGlyphs();
                llllllllllllllllIIlIlllIlIIIlIIl.unicodeFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
                llllllllllllllllIIlIlllIlIIIlIIl.unicodeFont.loadGlyphs();
            }
        }
        catch (FontFormatException | IOException | SlickException llllllllllllllllIIlIlllIlIIlIIII) {
            llllllllllllllllIIlIlllIlIIlIIII.printStackTrace();
        }
        llllllllllllllllIIlIlllIlIIIlIIl.antiAliasingFactor = llllllllllllllllIIlIlllIlIIIIlII.getScaleFactor();
        GL11.glPushMatrix();
        GlStateManager.scale((float)(1.0f / llllllllllllllllIIlIlllIlIIIlIIl.antiAliasingFactor), (float)(1.0f / llllllllllllllllIIlIlllIlIIIlIIl.antiAliasingFactor), (float)(1.0f / llllllllllllllllIIlIlllIlIIIlIIl.antiAliasingFactor));
        llllllllllllllllIIlIlllIIlllIlll *= llllllllllllllllIIlIlllIlIIIlIIl.antiAliasingFactor;
        float llllllllllllllllIIlIlllIlIIIIIll = llllllllllllllllIIlIlllIIllllIII *= llllllllllllllllIIlIlllIlIIIlIIl.antiAliasingFactor;
        float llllllllllllllllIIlIlllIlIIIIIlI = (float)(llllllllllllllllIIlIlllIlIIIIlIl >> 16 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIlllIlIIIIIIl = (float)(llllllllllllllllIIlIlllIlIIIIlIl >> 8 & 0xFF) / 255.0f;
        float llllllllllllllllIIlIlllIlIIIIIII = (float)(llllllllllllllllIIlIlllIlIIIIlIl & 0xFF) / 255.0f;
        float llllllllllllllllIIlIlllIIlllllll = (float)(llllllllllllllllIIlIlllIlIIIIlIl >> 24 & 0xFF) / 255.0f;
        GlStateManager.color((float)llllllllllllllllIIlIlllIlIIIIIlI, (float)llllllllllllllllIIlIlllIlIIIIIIl, (float)llllllllllllllllIIlIlllIlIIIIIII, (float)llllllllllllllllIIlIlllIIlllllll);
        int llllllllllllllllIIlIlllIIllllllI = llllllllllllllllIIlIlllIlIIIIlIl;
        char[] llllllllllllllllIIlIlllIIlllllIl = llllllllllllllllIIlIlllIIllllIIl.toCharArray();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.blendFunc((int)770, (int)771);
        String[] llllllllllllllllIIlIlllIIlllllII = COLOR_CODE_PATTERN.split(llllllllllllllllIIlIlllIIllllIIl);
        int llllllllllllllllIIlIlllIIllllIll = 0;
        for (String llllllllllllllllIIlIlllIlIIIlIlI : llllllllllllllllIIlIlllIIlllllII) {
            char llllllllllllllllIIlIlllIlIIIlIll;
            for (String llllllllllllllllIIlIlllIlIIIlllI : llllllllllllllllIIlIlllIlIIIlIlI.split("\n")) {
                for (String llllllllllllllllIIlIlllIlIIIllll : llllllllllllllllIIlIlllIlIIIlllI.split("\r")) {
                    llllllllllllllllIIlIlllIlIIIlIIl.unicodeFont.drawString(llllllllllllllllIIlIlllIIllllIII, llllllllllllllllIIlIlllIIlllIlll, llllllllllllllllIIlIlllIlIIIllll, new Color(llllllllllllllllIIlIlllIIllllllI));
                    llllllllllllllllIIlIlllIIllllIII += (float)llllllllllllllllIIlIlllIlIIIlIIl.unicodeFont.getWidth(llllllllllllllllIIlIlllIlIIIllll);
                    if ((llllllllllllllllIIlIlllIIllllIll += llllllllllllllllIIlIlllIlIIIllll.length()) >= llllllllllllllllIIlIlllIIlllllIl.length || llllllllllllllllIIlIlllIIlllllIl[llllllllllllllllIIlIlllIIllllIll] != '\r') continue;
                    llllllllllllllllIIlIlllIIllllIII = llllllllllllllllIIlIlllIlIIIIIll;
                    ++llllllllllllllllIIlIlllIIllllIll;
                }
                if (llllllllllllllllIIlIlllIIllllIll >= llllllllllllllllIIlIlllIIlllllIl.length || llllllllllllllllIIlIlllIIlllllIl[llllllllllllllllIIlIlllIIllllIll] != '\n') continue;
                llllllllllllllllIIlIlllIIllllIII = llllllllllllllllIIlIlllIlIIIIIll;
                llllllllllllllllIIlIlllIIlllIlll += llllllllllllllllIIlIlllIlIIIlIIl.getHeight(llllllllllllllllIIlIlllIlIIIlllI) * 2.0f;
                ++llllllllllllllllIIlIlllIIllllIll;
            }
            if (llllllllllllllllIIlIlllIIllllIll >= llllllllllllllllIIlIlllIIlllllIl.length || (llllllllllllllllIIlIlllIlIIIlIll = llllllllllllllllIIlIlllIIlllllIl[llllllllllllllllIIlIlllIIllllIll]) != '\u00a7') continue;
            char llllllllllllllllIIlIlllIlIIIllIl = llllllllllllllllIIlIlllIIlllllIl[llllllllllllllllIIlIlllIIllllIll + 1];
            int llllllllllllllllIIlIlllIlIIIllII = "0123456789abcdef".indexOf(llllllllllllllllIIlIlllIlIIIllIl);
            if (llllllllllllllllIIlIlllIlIIIllII < 0) {
                if (llllllllllllllllIIlIlllIlIIIllIl == 'r') {
                    llllllllllllllllIIlIlllIIllllllI = llllllllllllllllIIlIlllIlIIIIlIl;
                }
            } else {
                llllllllllllllllIIlIlllIIllllllI = llllllllllllllllIIlIlllIlIIIlIIl.colorCodes[llllllllllllllllIIlIlllIlIIIllII];
            }
            llllllllllllllllIIlIlllIIllllIll += 2;
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.bindTexture((int)0);
        GlStateManager.popMatrix();
        return (int)llllllllllllllllIIlIlllIlIIIlIIl.getWidth(llllllllllllllllIIlIlllIIllllIIl);
    }

    public float getCharWidth(char llllllllllllllllIIlIlllIIIIlIlll) {
        SalFontRenderer llllllllllllllllIIlIlllIIIIlIllI;
        return llllllllllllllllIIlIlllIIIIlIllI.unicodeFont.getWidth(String.valueOf(llllllllllllllllIIlIlllIIIIlIlll));
    }

    public float getStringHeight(String llllllllllllllllIIlIllIlllIlIlIl) {
        SalFontRenderer llllllllllllllllIIlIllIlllIlIlII;
        return llllllllllllllllIIlIllIlllIlIlII.getHeight(llllllllllllllllIIlIllIlllIlIlIl);
    }

    public float getHeight(String llllllllllllllllIIlIlllIIIIIllll) {
        SalFontRenderer llllllllllllllllIIlIlllIIIIlIIlI;
        return (float)llllllllllllllllIIlIlllIIIIlIIlI.unicodeFont.getHeight(llllllllllllllllIIlIlllIIIIIllll) / 2.0f;
    }

    public SalFontRenderer(Font llllllllllllllllIIlIlllIllIlIIll) {
        llllllllllllllllIIlIlllIllIlIIlI(llllllllllllllllIIlIlllIllIlIIll.getFontName(), llllllllllllllllIIlIlllIllIlIIll.getSize());
        SalFontRenderer llllllllllllllllIIlIlllIllIlIIlI;
    }

    public void drawStringScaled(String llllllllllllllllIIlIlllIlIllIllI, int llllllllllllllllIIlIlllIlIllIlIl, int llllllllllllllllIIlIlllIlIlIlllI, int llllllllllllllllIIlIlllIlIllIIll, double llllllllllllllllIIlIlllIlIlIllII) {
        SalFontRenderer llllllllllllllllIIlIlllIlIllIIIl;
        GL11.glPushMatrix();
        GL11.glTranslated((double)llllllllllllllllIIlIlllIlIllIlIl, (double)llllllllllllllllIIlIlllIlIlIlllI, (double)0.0);
        GL11.glScaled((double)llllllllllllllllIIlIlllIlIlIllII, (double)llllllllllllllllIIlIlllIlIlIllII, (double)llllllllllllllllIIlIlllIlIlIllII);
        llllllllllllllllIIlIlllIlIllIIIl.drawString(llllllllllllllllIIlIlllIlIllIllI, 0.0f, 0.0f, llllllllllllllllIIlIlllIlIllIIll);
        GL11.glPopMatrix();
    }

    static {
        COLOR_CODE_PATTERN = Pattern.compile("\u00a7[0123456789abcdefklmnor]");
    }

    public UnicodeFont getFont() {
        SalFontRenderer llllllllllllllllIIlIlllIIIIIllIl;
        return llllllllllllllllIIlIlllIIIIIllIl.unicodeFont;
    }

    public void drawSplitString(ArrayList<String> llllllllllllllllIIlIlllIIIIIIlIl, int llllllllllllllllIIlIlllIIIIIIlII, int llllllllllllllllIIlIlllIIIIIIIll, int llllllllllllllllIIlIllIlllllllIl) {
        SalFontRenderer llllllllllllllllIIlIlllIIIIIIIIl;
        llllllllllllllllIIlIlllIIIIIIIIl.drawString(String.join((CharSequence)"\n\r", llllllllllllllllIIlIlllIIIIIIlIl), llllllllllllllllIIlIlllIIIIIIlII, llllllllllllllllIIlIlllIIIIIIIll, llllllllllllllllIIlIllIlllllllIl);
    }

    public float getStringWidth(String llllllllllllllllIIlIllIlllIllIll) {
        SalFontRenderer llllllllllllllllIIlIllIlllIlllII;
        return llllllllllllllllIIlIllIlllIlllII.unicodeFont.getWidth(ChatColor.stripColor(llllllllllllllllIIlIllIlllIllIll)) / 2;
    }

    public String trimStringToWidth(String llllllllllllllllIIlIllIllIlllIII, int llllllllllllllllIIlIllIllIlIllIl, boolean llllllllllllllllIIlIllIllIllIllI) {
        StringBuilder llllllllllllllllIIlIllIllIllIlIl = new StringBuilder();
        int llllllllllllllllIIlIllIllIllIlII = 0;
        int llllllllllllllllIIlIllIllIllIIll = llllllllllllllllIIlIllIllIllIllI ? llllllllllllllllIIlIllIllIlllIII.length() - 1 : 0;
        int llllllllllllllllIIlIllIllIllIIlI = llllllllllllllllIIlIllIllIllIllI ? -1 : 1;
        boolean llllllllllllllllIIlIllIllIllIIIl = false;
        boolean llllllllllllllllIIlIllIllIllIIII = false;
        for (int llllllllllllllllIIlIllIllIlllIlI = llllllllllllllllIIlIllIllIllIIll; llllllllllllllllIIlIllIllIlllIlI >= 0 && llllllllllllllllIIlIllIllIlllIlI < llllllllllllllllIIlIllIllIlllIII.length() && llllllllllllllllIIlIllIllIllIlII < llllllllllllllllIIlIllIllIlIllIl; llllllllllllllllIIlIllIllIlllIlI += llllllllllllllllIIlIllIllIllIIlI) {
            SalFontRenderer llllllllllllllllIIlIllIllIlllIIl;
            char llllllllllllllllIIlIllIllIllllII = llllllllllllllllIIlIllIllIlllIII.charAt(llllllllllllllllIIlIllIllIlllIlI);
            float llllllllllllllllIIlIllIllIlllIll = llllllllllllllllIIlIllIllIlllIIl.getWidth(llllllllllllllllIIlIllIllIlllIII);
            if (llllllllllllllllIIlIllIllIllIIIl) {
                llllllllllllllllIIlIllIllIllIIIl = false;
                if (llllllllllllllllIIlIllIllIllllII != 'l' && llllllllllllllllIIlIllIllIllllII != 'L') {
                    if (llllllllllllllllIIlIllIllIllllII == 'r' || llllllllllllllllIIlIllIllIllllII == 'R') {
                        llllllllllllllllIIlIllIllIllIIII = false;
                    }
                } else {
                    llllllllllllllllIIlIllIllIllIIII = true;
                }
            } else if (llllllllllllllllIIlIllIllIlllIll < 0.0f) {
                llllllllllllllllIIlIllIllIllIIIl = true;
            } else {
                llllllllllllllllIIlIllIllIllIlII = (int)((float)llllllllllllllllIIlIllIllIllIlII + llllllllllllllllIIlIllIllIlllIll);
                if (llllllllllllllllIIlIllIllIllIIII) {
                    ++llllllllllllllllIIlIllIllIllIlII;
                }
            }
            if (llllllllllllllllIIlIllIllIllIlII > llllllllllllllllIIlIllIllIlIllIl) break;
            if (llllllllllllllllIIlIllIllIllIllI) {
                llllllllllllllllIIlIllIllIllIlIl.insert(0, llllllllllllllllIIlIllIllIllllII);
                continue;
            }
            llllllllllllllllIIlIllIllIllIlIl.append(llllllllllllllllIIlIllIllIllllII);
        }
        return String.valueOf(llllllllllllllllIIlIllIllIllIlIl);
    }

    public static Font getFontFromInput(String llllllllllllllllIIlIlllIlIllllll) throws IOException, FontFormatException {
        InputStream llllllllllllllllIIlIlllIllIIIIII = SalFontRenderer.class.getResourceAsStream(llllllllllllllllIIlIlllIlIllllll);
        System.out.println(llllllllllllllllIIlIlllIlIllllll);
        System.out.println(llllllllllllllllIIlIlllIllIIIIII.toString());
        return Font.createFont(0, llllllllllllllllIIlIlllIllIIIIII);
    }

    public SalFontRenderer(String llllllllllllllllIIlIlllIllIllIlI, float llllllllllllllllIIlIlllIllIllIIl) {
        SalFontRenderer llllllllllllllllIIlIlllIllIllIll;
        llllllllllllllllIIlIlllIllIllIll.FONT_HEIGHT = 9;
        llllllllllllllllIIlIlllIllIllIll.colorCodes = new int[]{0, 170, 43520, 43690, 0xAA0000, 0xAA00AA, 0xFFAA00, 0xAAAAAA, 0x555555, 0x5555FF, 0x55FF55, 0x55FFFF, 0xFF5555, 0xFF55FF, 0xFFFF55, 0xFFFFFF};
        llllllllllllllllIIlIlllIllIllIll.cachedStringWidth = new HashMap<String, Float>();
        llllllllllllllllIIlIlllIllIllIll.prevScaleFactor = new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor();
        llllllllllllllllIIlIlllIllIllIll.name = llllllllllllllllIIlIlllIllIllIlI;
        llllllllllllllllIIlIlllIllIllIll.size = llllllllllllllllIIlIlllIllIllIIl;
        ScaledResolution llllllllllllllllIIlIlllIllIlllII = new ScaledResolution(Minecraft.getMinecraft());
        try {
            llllllllllllllllIIlIlllIllIllIll.prevScaleFactor = llllllllllllllllIIlIlllIllIlllII.getScaleFactor();
            llllllllllllllllIIlIlllIllIllIll.unicodeFont = new UnicodeFont(SalFontRenderer.getFontByName(llllllllllllllllIIlIlllIllIllIlI).deriveFont(llllllllllllllllIIlIlllIllIllIIl * (float)llllllllllllllllIIlIlllIllIllIll.prevScaleFactor / 2.0f));
            llllllllllllllllIIlIlllIllIllIll.unicodeFont.addAsciiGlyphs();
            llllllllllllllllIIlIlllIllIllIll.unicodeFont.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
            llllllllllllllllIIlIlllIllIllIll.unicodeFont.loadGlyphs();
        }
        catch (FontFormatException | IOException | SlickException llllllllllllllllIIlIlllIlllIIIII) {
            llllllllllllllllIIlIlllIlllIIIII.printStackTrace();
        }
        llllllllllllllllIIlIlllIllIllIll.antiAliasingFactor = llllllllllllllllIIlIlllIllIlllII.getScaleFactor();
    }

    public void drawCenteredString(String llllllllllllllllIIlIlllIIlIIlIlI, float llllllllllllllllIIlIlllIIlIIIlII, float llllllllllllllllIIlIlllIIlIIlIII, int llllllllllllllllIIlIlllIIlIIIlll) {
        SalFontRenderer llllllllllllllllIIlIlllIIlIIIllI;
        llllllllllllllllIIlIlllIIlIIIllI.drawString(llllllllllllllllIIlIlllIIlIIlIlI, llllllllllllllllIIlIlllIIlIIIlII - (float)((int)llllllllllllllllIIlIlllIIlIIIllI.getWidth(llllllllllllllllIIlIlllIIlIIlIlI) >> 1), llllllllllllllllIIlIlllIIlIIlIII, llllllllllllllllIIlIlllIIlIIIlll);
    }
}

