/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.opengl.GLUtils;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.BufferedImageUtil;

public class TrueTypeFont
implements Font {
    private /* synthetic */ IntObject[] charArray;
    private /* synthetic */ int textureWidth;
    private /* synthetic */ int fontSize;
    private /* synthetic */ java.awt.Font font;
    private /* synthetic */ FontMetrics fontMetrics;
    private static final /* synthetic */ SGL GL;
    private /* synthetic */ boolean antiAlias;
    private /* synthetic */ Texture fontTexture;
    private /* synthetic */ int textureHeight;
    private /* synthetic */ int fontHeight;
    private /* synthetic */ Map customChars;

    @Override
    public int getLineHeight() {
        TrueTypeFont llllllllllllllllIlIlIllIIIIlIIII;
        return llllllllllllllllIlIlIllIIIIlIIII.fontHeight;
    }

    static {
        GL = Renderer.get();
    }

    @Override
    public int getHeight(String llllllllllllllllIlIlIllIIIIlIlII) {
        TrueTypeFont llllllllllllllllIlIlIllIIIIlIlIl;
        return llllllllllllllllIlIlIllIIIIlIlIl.fontHeight;
    }

    @Override
    public void drawString(float llllllllllllllllIlIlIlIlllIllIlI, float llllllllllllllllIlIlIlIlllIlIlIl, String llllllllllllllllIlIlIlIlllIllIII) {
        TrueTypeFont llllllllllllllllIlIlIlIlllIlIlll;
        llllllllllllllllIlIlIlIlllIlIlll.drawString(llllllllllllllllIlIlIlIlllIllIlI, llllllllllllllllIlIlIlIlllIlIlIl, llllllllllllllllIlIlIlIlllIllIII, Color.white);
    }

    @Override
    public int getWidth(String llllllllllllllllIlIlIllIIIlIIIll) {
        int llllllllllllllllIlIlIllIIIlIIIlI = 0;
        IntObject llllllllllllllllIlIlIllIIIlIIIIl = null;
        char llllllllllllllllIlIlIllIIIlIIIII = '\u0000';
        for (int llllllllllllllllIlIlIllIIIlIIlIl = 0; llllllllllllllllIlIlIllIIIlIIlIl < llllllllllllllllIlIlIllIIIlIIIll.length(); ++llllllllllllllllIlIlIllIIIlIIlIl) {
            TrueTypeFont llllllllllllllllIlIlIllIIIIlllll;
            llllllllllllllllIlIlIllIIIlIIIII = llllllllllllllllIlIlIllIIIlIIIll.charAt(llllllllllllllllIlIlIllIIIlIIlIl);
            llllllllllllllllIlIlIllIIIlIIIIl = llllllllllllllllIlIlIllIIIlIIIII < '\u0100' ? llllllllllllllllIlIlIllIIIIlllll.charArray[llllllllllllllllIlIlIllIIIlIIIII] : (IntObject)llllllllllllllllIlIlIllIIIIlllll.customChars.get(new Character(llllllllllllllllIlIlIllIIIlIIIII));
            if (llllllllllllllllIlIlIllIIIlIIIIl == null) continue;
            llllllllllllllllIlIlIllIIIlIIIlI += llllllllllllllllIlIlIllIIIlIIIIl.width;
        }
        return llllllllllllllllIlIlIllIIIlIIIlI;
    }

    private void createSet(char[] llllllllllllllllIlIlIllIlIIllIlI) {
        if (llllllllllllllllIlIlIllIlIIllIlI != null && llllllllllllllllIlIlIllIlIIllIlI.length > 0) {
            llllllllllllllllIlIlIllIlIIlllIl.textureWidth *= 2;
        }
        try {
            TrueTypeFont llllllllllllllllIlIlIllIlIIlllIl;
            BufferedImage llllllllllllllllIlIlIllIlIlIIllI = new BufferedImage(llllllllllllllllIlIlIllIlIIlllIl.textureWidth, llllllllllllllllIlIlIllIlIIlllIl.textureHeight, 2);
            Graphics2D llllllllllllllllIlIlIllIlIlIIlII = (Graphics2D)llllllllllllllllIlIlIllIlIlIIllI.getGraphics();
            llllllllllllllllIlIlIllIlIlIIlII.setColor(new java.awt.Color(255, 255, 255, 1));
            llllllllllllllllIlIlIllIlIlIIlII.fillRect(0, 0, llllllllllllllllIlIlIllIlIIlllIl.textureWidth, llllllllllllllllIlIlIllIlIIlllIl.textureHeight);
            int llllllllllllllllIlIlIllIlIlIIIlI = 0;
            int llllllllllllllllIlIlIllIlIlIIIIl = 0;
            int llllllllllllllllIlIlIllIlIlIIIII = 0;
            int llllllllllllllllIlIlIllIlIIlllll = llllllllllllllllIlIlIllIlIIllIlI != null ? llllllllllllllllIlIlIllIlIIllIlI.length : 0;
            for (int llllllllllllllllIlIlIllIlIlIIlll = 0; llllllllllllllllIlIlIllIlIlIIlll < 256 + llllllllllllllllIlIlIllIlIIlllll; ++llllllllllllllllIlIlIllIlIlIIlll) {
                char llllllllllllllllIlIlIllIlIlIllII = llllllllllllllllIlIlIllIlIlIIlll < 256 ? (char)llllllllllllllllIlIlIllIlIlIIlll : llllllllllllllllIlIlIllIlIIllIlI[llllllllllllllllIlIlIllIlIlIIlll - 256];
                BufferedImage llllllllllllllllIlIlIllIlIlIlIlI = llllllllllllllllIlIlIllIlIIlllIl.getFontImage(llllllllllllllllIlIlIllIlIlIllII);
                IntObject llllllllllllllllIlIlIllIlIlIlIII = llllllllllllllllIlIlIllIlIIlllIl.new IntObject();
                llllllllllllllllIlIlIllIlIlIlIII.width = llllllllllllllllIlIlIllIlIlIlIlI.getWidth();
                llllllllllllllllIlIlIllIlIlIlIII.height = llllllllllllllllIlIlIllIlIlIlIlI.getHeight();
                if (llllllllllllllllIlIlIllIlIlIIIIl + llllllllllllllllIlIlIllIlIlIlIII.width >= llllllllllllllllIlIlIllIlIIlllIl.textureWidth) {
                    llllllllllllllllIlIlIllIlIlIIIIl = 0;
                    llllllllllllllllIlIlIllIlIlIIIII += llllllllllllllllIlIlIllIlIlIIIlI;
                    llllllllllllllllIlIlIllIlIlIIIlI = 0;
                }
                llllllllllllllllIlIlIllIlIlIlIII.storedX = llllllllllllllllIlIlIllIlIlIIIIl;
                llllllllllllllllIlIlIllIlIlIlIII.storedY = llllllllllllllllIlIlIllIlIlIIIII;
                if (llllllllllllllllIlIlIllIlIlIlIII.height > llllllllllllllllIlIlIllIlIIlllIl.fontHeight) {
                    llllllllllllllllIlIlIllIlIIlllIl.fontHeight = llllllllllllllllIlIlIllIlIlIlIII.height;
                }
                if (llllllllllllllllIlIlIllIlIlIlIII.height > llllllllllllllllIlIlIllIlIlIIIlI) {
                    llllllllllllllllIlIlIllIlIlIIIlI = llllllllllllllllIlIlIllIlIlIlIII.height;
                }
                llllllllllllllllIlIlIllIlIlIIlII.drawImage((Image)llllllllllllllllIlIlIllIlIlIlIlI, llllllllllllllllIlIlIllIlIlIIIIl, llllllllllllllllIlIlIllIlIlIIIII, null);
                llllllllllllllllIlIlIllIlIlIIIIl += llllllllllllllllIlIlIllIlIlIlIII.width;
                if (llllllllllllllllIlIlIllIlIlIIlll < 256) {
                    llllllllllllllllIlIlIllIlIIlllIl.charArray[llllllllllllllllIlIlIllIlIlIIlll] = llllllllllllllllIlIlIllIlIlIlIII;
                } else {
                    llllllllllllllllIlIlIllIlIIlllIl.customChars.put(new Character(llllllllllllllllIlIlIllIlIlIllII), llllllllllllllllIlIlIllIlIlIlIII);
                }
                llllllllllllllllIlIlIllIlIlIlIlI = null;
            }
            llllllllllllllllIlIlIllIlIIlllIl.fontTexture = BufferedImageUtil.getTexture(llllllllllllllllIlIlIllIlIIlllIl.font.toString(), llllllllllllllllIlIlIllIlIlIIllI);
        }
        catch (IOException llllllllllllllllIlIlIllIlIIllllI) {
            System.err.println("Failed to create font.");
            llllllllllllllllIlIlIllIlIIllllI.printStackTrace();
        }
    }

    @Override
    public void drawString(float llllllllllllllllIlIlIlIllllIlIIl, float llllllllllllllllIlIlIlIlllllIIIl, String llllllllllllllllIlIlIlIllllIIlll, Color llllllllllllllllIlIlIlIllllIIllI, int llllllllllllllllIlIlIlIllllIlllI, int llllllllllllllllIlIlIlIllllIIlII) {
        TrueTypeFont llllllllllllllllIlIlIlIlllllIIll;
        llllllllllllllllIlIlIlIllllIIllI.bind();
        llllllllllllllllIlIlIlIlllllIIll.fontTexture.bind();
        IntObject llllllllllllllllIlIlIlIllllIllII = null;
        GL.glBegin(7);
        int llllllllllllllllIlIlIlIllllIlIll = 0;
        for (int llllllllllllllllIlIlIlIlllllIlII = 0; llllllllllllllllIlIlIlIlllllIlII < llllllllllllllllIlIlIlIllllIIlll.length(); ++llllllllllllllllIlIlIlIlllllIlII) {
            char llllllllllllllllIlIlIlIlllllIlIl = llllllllllllllllIlIlIlIllllIIlll.charAt(llllllllllllllllIlIlIlIlllllIlII);
            llllllllllllllllIlIlIlIllllIllII = llllllllllllllllIlIlIlIlllllIlIl < '\u0100' ? llllllllllllllllIlIlIlIlllllIIll.charArray[llllllllllllllllIlIlIlIlllllIlIl] : (IntObject)llllllllllllllllIlIlIlIlllllIIll.customChars.get(new Character(llllllllllllllllIlIlIlIlllllIlIl));
            if (llllllllllllllllIlIlIlIllllIllII == null) continue;
            if (llllllllllllllllIlIlIlIlllllIlII >= llllllllllllllllIlIlIlIllllIlllI || llllllllllllllllIlIlIlIlllllIlII <= llllllllllllllllIlIlIlIllllIIlII) {
                llllllllllllllllIlIlIlIlllllIIll.drawQuad(llllllllllllllllIlIlIlIllllIlIIl + (float)llllllllllllllllIlIlIlIllllIlIll, llllllllllllllllIlIlIlIlllllIIIl, llllllllllllllllIlIlIlIllllIlIIl + (float)llllllllllllllllIlIlIlIllllIlIll + (float)llllllllllllllllIlIlIlIllllIllII.width, llllllllllllllllIlIlIlIlllllIIIl + (float)llllllllllllllllIlIlIlIllllIllII.height, llllllllllllllllIlIlIlIllllIllII.storedX, llllllllllllllllIlIlIlIllllIllII.storedY, llllllllllllllllIlIlIlIllllIllII.storedX + llllllllllllllllIlIlIlIllllIllII.width, llllllllllllllllIlIlIlIllllIllII.storedY + llllllllllllllllIlIlIlIllllIllII.height);
            }
            llllllllllllllllIlIlIlIllllIlIll += llllllllllllllllIlIlIlIllllIllII.width;
        }
        GL.glEnd();
    }

    public TrueTypeFont(java.awt.Font llllllllllllllllIlIlIlllIIIIIIlI, boolean llllllllllllllllIlIlIlllIIIIIlIl, char[] llllllllllllllllIlIlIlllIIIIIlII) {
        TrueTypeFont llllllllllllllllIlIlIlllIIIIIlll;
        llllllllllllllllIlIlIlllIIIIIlll.charArray = new IntObject[256];
        llllllllllllllllIlIlIlllIIIIIlll.customChars = new HashMap();
        llllllllllllllllIlIlIlllIIIIIlll.fontSize = 0;
        llllllllllllllllIlIlIlllIIIIIlll.fontHeight = 0;
        llllllllllllllllIlIlIlllIIIIIlll.textureWidth = 512;
        llllllllllllllllIlIlIlllIIIIIlll.textureHeight = 512;
        GLUtils.checkGLContext();
        llllllllllllllllIlIlIlllIIIIIlll.font = llllllllllllllllIlIlIlllIIIIIIlI;
        llllllllllllllllIlIlIlllIIIIIlll.fontSize = llllllllllllllllIlIlIlllIIIIIIlI.getSize();
        llllllllllllllllIlIlIlllIIIIIlll.antiAlias = llllllllllllllllIlIlIlllIIIIIlIl;
        llllllllllllllllIlIlIlllIIIIIlll.createSet(llllllllllllllllIlIlIlllIIIIIlII);
    }

    public TrueTypeFont(java.awt.Font llllllllllllllllIlIlIllIlllllIll, boolean llllllllllllllllIlIlIllIllllIlll) {
        llllllllllllllllIlIlIllIllllllII(llllllllllllllllIlIlIllIlllllIll, llllllllllllllllIlIlIllIllllIlll, null);
        TrueTypeFont llllllllllllllllIlIlIllIllllllII;
    }

    private void drawQuad(float llllllllllllllllIlIlIllIIIllllII, float llllllllllllllllIlIlIllIIlIlIllI, float llllllllllllllllIlIlIllIIlIlIlII, float llllllllllllllllIlIlIllIIlIIllll, float llllllllllllllllIlIlIllIIIllIlll, float llllllllllllllllIlIlIllIIlIIllIl, float llllllllllllllllIlIlIllIIIllIlIl, float llllllllllllllllIlIlIllIIlIIlIlI) {
        TrueTypeFont llllllllllllllllIlIlIllIIIlllllI;
        float llllllllllllllllIlIlIllIIlIIlIII = llllllllllllllllIlIlIllIIlIlIlII - llllllllllllllllIlIlIllIIIllllII;
        float llllllllllllllllIlIlIllIIlIIIllI = llllllllllllllllIlIlIllIIlIIllll - llllllllllllllllIlIlIllIIlIlIllI;
        float llllllllllllllllIlIlIllIIlIIIlIl = llllllllllllllllIlIlIllIIIllIlll / (float)llllllllllllllllIlIlIllIIIlllllI.textureWidth;
        float llllllllllllllllIlIlIllIIlIIIlII = llllllllllllllllIlIlIllIIlIIllIl / (float)llllllllllllllllIlIlIllIIIlllllI.textureHeight;
        float llllllllllllllllIlIlIllIIlIIIIll = llllllllllllllllIlIlIllIIIllIlIl - llllllllllllllllIlIlIllIIIllIlll;
        float llllllllllllllllIlIlIllIIlIIIIlI = llllllllllllllllIlIlIllIIlIIlIlI - llllllllllllllllIlIlIllIIlIIllIl;
        float llllllllllllllllIlIlIllIIlIIIIIl = llllllllllllllllIlIlIllIIlIIIIll / (float)llllllllllllllllIlIlIllIIIlllllI.textureWidth;
        float llllllllllllllllIlIlIllIIlIIIIII = llllllllllllllllIlIlIllIIlIIIIlI / (float)llllllllllllllllIlIlIllIIIlllllI.textureHeight;
        GL.glTexCoord2f(llllllllllllllllIlIlIllIIlIIIlIl, llllllllllllllllIlIlIllIIlIIIlII);
        GL.glVertex2f(llllllllllllllllIlIlIllIIIllllII, llllllllllllllllIlIlIllIIlIlIllI);
        GL.glTexCoord2f(llllllllllllllllIlIlIllIIlIIIlIl, llllllllllllllllIlIlIllIIlIIIlII + llllllllllllllllIlIlIllIIlIIIIII);
        GL.glVertex2f(llllllllllllllllIlIlIllIIIllllII, llllllllllllllllIlIlIllIIlIlIllI + llllllllllllllllIlIlIllIIlIIIllI);
        GL.glTexCoord2f(llllllllllllllllIlIlIllIIlIIIlIl + llllllllllllllllIlIlIllIIlIIIIIl, llllllllllllllllIlIlIllIIlIIIlII + llllllllllllllllIlIlIllIIlIIIIII);
        GL.glVertex2f(llllllllllllllllIlIlIllIIIllllII + llllllllllllllllIlIlIllIIlIIlIII, llllllllllllllllIlIlIllIIlIlIllI + llllllllllllllllIlIlIllIIlIIIllI);
        GL.glTexCoord2f(llllllllllllllllIlIlIllIIlIIIlIl + llllllllllllllllIlIlIllIIlIIIIIl, llllllllllllllllIlIlIllIIlIIIlII);
        GL.glVertex2f(llllllllllllllllIlIlIllIIIllllII + llllllllllllllllIlIlIllIIlIIlIII, llllllllllllllllIlIlIllIIlIlIllI);
    }

    @Override
    public void drawString(float llllllllllllllllIlIlIllIIIIIlIIl, float llllllllllllllllIlIlIllIIIIIlIII, String llllllllllllllllIlIlIllIIIIIIIlI, Color llllllllllllllllIlIlIllIIIIIIllI) {
        TrueTypeFont llllllllllllllllIlIlIllIIIIIIlIl;
        llllllllllllllllIlIlIllIIIIIIlIl.drawString(llllllllllllllllIlIlIllIIIIIlIIl, llllllllllllllllIlIlIllIIIIIlIII, llllllllllllllllIlIlIllIIIIIIIlI, llllllllllllllllIlIlIllIIIIIIllI, 0, llllllllllllllllIlIlIllIIIIIIIlI.length() - 1);
    }

    public int getHeight() {
        TrueTypeFont llllllllllllllllIlIlIllIIIIllIII;
        return llllllllllllllllIlIlIllIIIIllIII.fontHeight;
    }

    private BufferedImage getFontImage(char llllllllllllllllIlIlIllIlllIlIll) {
        int llllllllllllllllIlIlIllIlllIIlll;
        TrueTypeFont llllllllllllllllIlIlIllIlllIIIlI;
        BufferedImage llllllllllllllllIlIlIllIlllIlIlI = new BufferedImage(1, 1, 2);
        Graphics2D llllllllllllllllIlIlIllIlllIlIIl = (Graphics2D)llllllllllllllllIlIlIllIlllIlIlI.getGraphics();
        if (llllllllllllllllIlIlIllIlllIIIlI.antiAlias) {
            llllllllllllllllIlIlIllIlllIlIIl.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        llllllllllllllllIlIlIllIlllIlIIl.setFont(llllllllllllllllIlIlIllIlllIIIlI.font);
        llllllllllllllllIlIlIllIlllIIIlI.fontMetrics = llllllllllllllllIlIlIllIlllIlIIl.getFontMetrics();
        int llllllllllllllllIlIlIllIlllIlIII = llllllllllllllllIlIlIllIlllIIIlI.fontMetrics.charWidth(llllllllllllllllIlIlIllIlllIlIll);
        if (llllllllllllllllIlIlIllIlllIlIII <= 0) {
            llllllllllllllllIlIlIllIlllIlIII = 1;
        }
        if ((llllllllllllllllIlIlIllIlllIIlll = llllllllllllllllIlIlIllIlllIIIlI.fontMetrics.getHeight()) <= 0) {
            llllllllllllllllIlIlIllIlllIIlll = llllllllllllllllIlIlIllIlllIIIlI.fontSize;
        }
        BufferedImage llllllllllllllllIlIlIllIlllIIllI = new BufferedImage(llllllllllllllllIlIlIllIlllIlIII, llllllllllllllllIlIlIllIlllIIlll, 2);
        Graphics2D llllllllllllllllIlIlIllIlllIIlIl = (Graphics2D)llllllllllllllllIlIlIllIlllIIllI.getGraphics();
        if (llllllllllllllllIlIlIllIlllIIIlI.antiAlias) {
            llllllllllllllllIlIlIllIlllIIlIl.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        llllllllllllllllIlIlIllIlllIIlIl.setFont(llllllllllllllllIlIlIllIlllIIIlI.font);
        llllllllllllllllIlIlIllIlllIIlIl.setColor(java.awt.Color.WHITE);
        int llllllllllllllllIlIlIllIlllIIlII = 0;
        int llllllllllllllllIlIlIllIlllIIIll = 0;
        llllllllllllllllIlIlIllIlllIIlIl.drawString(String.valueOf(llllllllllllllllIlIlIllIlllIlIll), llllllllllllllllIlIlIllIlllIIlII, llllllllllllllllIlIlIllIlllIIIll + llllllllllllllllIlIlIllIlllIIIlI.fontMetrics.getAscent());
        return llllllllllllllllIlIlIllIlllIIllI;
    }

    private class IntObject {
        public /* synthetic */ int storedX;
        public /* synthetic */ int storedY;
        public /* synthetic */ int height;
        public /* synthetic */ int width;

        private IntObject() {
            IntObject llIIIlIlIlIlIII;
        }
    }
}

