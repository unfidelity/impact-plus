/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.font.GlyphVector;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.GlyphPage;
import org.newdawn.slick.font.HieroSettings;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.ResourceLoader;

public class UnicodeFont
implements Font {
    private /* synthetic */ Glyph missingGlyph;
    private static final /* synthetic */ Comparator heightComparator;
    private final /* synthetic */ List effects;
    private /* synthetic */ String ttfFileRef;
    private static final /* synthetic */ SGL GL;
    private static final /* synthetic */ int PAGE_SIZE;
    private /* synthetic */ int spaceWidth;
    private /* synthetic */ int paddingAdvanceY;
    private /* synthetic */ int paddingBottom;
    private static final /* synthetic */ int PAGES;
    private /* synthetic */ int paddingLeft;
    private final /* synthetic */ Glyph[][] glyphs;
    private static final /* synthetic */ int MAX_GLYPH_CODE;
    private /* synthetic */ int leading;
    private /* synthetic */ int paddingTop;
    private /* synthetic */ int paddingRight;
    private /* synthetic */ boolean displayListCaching;
    private /* synthetic */ DisplayList eldestDisplayList;
    private final /* synthetic */ LinkedHashMap displayLists;
    private /* synthetic */ int paddingAdvanceX;
    private /* synthetic */ int baseDisplayListID;
    private /* synthetic */ int ascent;
    private /* synthetic */ java.awt.Font font;
    private final /* synthetic */ List glyphPages;
    private /* synthetic */ int descent;
    private static final /* synthetic */ DisplayList EMPTY_DISPLAY_LIST;
    private /* synthetic */ int glyphPageWidth;
    private static final /* synthetic */ int DISPLAY_LIST_CACHE_SIZE;
    private /* synthetic */ int eldestDisplayListID;
    private /* synthetic */ int glyphPageHeight;
    private final /* synthetic */ List queuedGlyphs;

    public void setPaddingAdvanceX(int lllllllllllllllllIlIlIIllllIIlII) {
        lllllllllllllllllIlIlIIllllIlIIl.paddingAdvanceX = lllllllllllllllllIlIlIIllllIIlII;
    }

    public UnicodeFont(java.awt.Font lllllllllllllllllIlIllIIlIIlIllI, String lllllllllllllllllIlIllIIlIIlIlIl) throws SlickException {
        lllllllllllllllllIlIllIIlIIlIlll(lllllllllllllllllIlIllIIlIIlIllI, new HieroSettings(lllllllllllllllllIlIllIIlIIlIlIl));
        UnicodeFont lllllllllllllllllIlIllIIlIIlIlll;
    }

    public void setPaddingTop(int lllllllllllllllllIlIlIlIIIlIIIll) {
        lllllllllllllllllIlIlIlIIIlIIlII.paddingTop = lllllllllllllllllIlIlIlIIIlIIIll;
    }

    public int getPaddingAdvanceX() {
        UnicodeFont lllllllllllllllllIlIlIIlllllIIIl;
        return lllllllllllllllllIlIlIIlllllIIIl.paddingAdvanceX;
    }

    public void addAsciiGlyphs() {
        UnicodeFont lllllllllllllllllIlIlIlllllllIII;
        lllllllllllllllllIlIlIlllllllIII.addGlyphs(32, 255);
    }

    public int getGlyphPageHeight() {
        UnicodeFont lllllllllllllllllIlIlIIllIllIlll;
        return lllllllllllllllllIlIlIIllIllIlll.glyphPageHeight;
    }

    public void addGlyphs(int lllllllllllllllllIlIllIIIIIlIlll, int lllllllllllllllllIlIllIIIIIlIIll) {
        for (int lllllllllllllllllIlIllIIIIIllIIl = lllllllllllllllllIlIllIIIIIlIlll; lllllllllllllllllIlIllIIIIIllIIl <= lllllllllllllllllIlIllIIIIIlIIll; ++lllllllllllllllllIlIllIIIIIllIIl) {
            UnicodeFont lllllllllllllllllIlIllIIIIIlIlIl;
            lllllllllllllllllIlIllIIIIIlIlIl.addGlyphs(new String(Character.toChars(lllllllllllllllllIlIllIIIIIllIIl)));
        }
    }

    public void setPaddingBottom(int lllllllllllllllllIlIlIlIIIIIIlII) {
        lllllllllllllllllIlIlIlIIIIIIIll.paddingBottom = lllllllllllllllllIlIlIlIIIIIIlII;
    }

    public int getSpaceWidth() {
        UnicodeFont lllllllllllllllllIlIlIlIllIIllII;
        return lllllllllllllllllIlIlIlIllIIllII.spaceWidth;
    }

    public List getEffects() {
        UnicodeFont lllllllllllllllllIlIlIIllIlIllII;
        return lllllllllllllllllIlIlIIllIlIllII.effects;
    }

    public int getPaddingBottom() {
        UnicodeFont lllllllllllllllllIlIlIlIIIIIlIIl;
        return lllllllllllllllllIlIlIlIIIIIlIIl.paddingBottom;
    }

    public java.awt.Font getFont() {
        UnicodeFont lllllllllllllllllIlIlIlIIIlllIIl;
        return lllllllllllllllllIlIlIlIIIlllIIl.font;
    }

    public boolean loadGlyphs(int lllllllllllllllllIlIlIllllIIlIlI) throws SlickException {
        UnicodeFont lllllllllllllllllIlIlIllllIIlIll;
        if (lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs.isEmpty()) {
            return false;
        }
        if (lllllllllllllllllIlIlIllllIIlIll.effects.isEmpty()) {
            throw new IllegalStateException("The UnicodeFont must have at least one effect before any glyphs can be loaded.");
        }
        Iterator lllllllllllllllllIlIlIllllIllIII = lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs.iterator();
        while (lllllllllllllllllIlIlIllllIllIII.hasNext()) {
            Glyph lllllllllllllllllIlIlIllllIlllII = (Glyph)lllllllllllllllllIlIlIllllIllIII.next();
            int lllllllllllllllllIlIlIllllIllIlI = lllllllllllllllllIlIlIllllIlllII.getCodePoint();
            if (lllllllllllllllllIlIlIllllIlllII.getWidth() == 0 || lllllllllllllllllIlIlIllllIllIlI == 32) {
                lllllllllllllllllIlIlIllllIllIII.remove();
                continue;
            }
            if (!lllllllllllllllllIlIlIllllIlllII.isMissing()) continue;
            if (lllllllllllllllllIlIlIllllIIlIll.missingGlyph != null) {
                if (lllllllllllllllllIlIlIllllIlllII == lllllllllllllllllIlIlIllllIIlIll.missingGlyph) continue;
                lllllllllllllllllIlIlIllllIllIII.remove();
                continue;
            }
            lllllllllllllllllIlIlIllllIIlIll.missingGlyph = lllllllllllllllllIlIlIllllIlllII;
        }
        Collections.sort(lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs, heightComparator);
        for (GlyphPage lllllllllllllllllIlIlIllllIlIllI : lllllllllllllllllIlIlIllllIIlIll.glyphPages) {
            if ((lllllllllllllllllIlIlIllllIIlIlI -= lllllllllllllllllIlIlIllllIlIllI.loadGlyphs(lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs, lllllllllllllllllIlIlIllllIIlIlI)) != 0 && !lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs.isEmpty()) continue;
            return true;
        }
        while (!lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs.isEmpty()) {
            GlyphPage lllllllllllllllllIlIlIllllIlIIlI = new GlyphPage(lllllllllllllllllIlIlIllllIIlIll, lllllllllllllllllIlIlIllllIIlIll.glyphPageWidth, lllllllllllllllllIlIlIllllIIlIll.glyphPageHeight);
            lllllllllllllllllIlIlIllllIIlIll.glyphPages.add(lllllllllllllllllIlIlIllllIlIIlI);
            if ((lllllllllllllllllIlIlIllllIIlIlI -= lllllllllllllllllIlIlIllllIlIIlI.loadGlyphs(lllllllllllllllllIlIlIllllIIlIll.queuedGlyphs, lllllllllllllllllIlIlIllllIIlIlI)) != 0) continue;
            return true;
        }
        return true;
    }

    @Override
    public int getHeight(String lllllllllllllllllIlIlIlIIlllIllI) {
        DisplayList lllllllllllllllllIlIlIlIIlllllIl;
        UnicodeFont lllllllllllllllllIlIlIlIIlllIIIl;
        if (lllllllllllllllllIlIlIlIIlllIllI == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (lllllllllllllllllIlIlIlIIlllIllI.length() == 0) {
            return 0;
        }
        if (lllllllllllllllllIlIlIlIIlllIIIl.displayListCaching && (lllllllllllllllllIlIlIlIIlllllIl = (DisplayList)lllllllllllllllllIlIlIlIIlllIIIl.displayLists.get(lllllllllllllllllIlIlIlIIlllIllI)) != null) {
            return lllllllllllllllllIlIlIlIIlllllIl.height;
        }
        char[] lllllllllllllllllIlIlIlIIlllIlIl = lllllllllllllllllIlIlIlIIlllIllI.toCharArray();
        GlyphVector lllllllllllllllllIlIlIlIIlllIlII = lllllllllllllllllIlIlIlIIlllIIIl.font.layoutGlyphVector(GlyphPage.renderContext, lllllllllllllllllIlIlIlIIlllIlIl, 0, lllllllllllllllllIlIlIlIIlllIlIl.length, 0);
        int lllllllllllllllllIlIlIlIIlllIIll = 0;
        int lllllllllllllllllIlIlIlIIlllIIlI = 0;
        int lllllllllllllllllIlIlIlIIllllIII = lllllllllllllllllIlIlIlIIlllIlII.getNumGlyphs();
        for (int lllllllllllllllllIlIlIlIIllllIIl = 0; lllllllllllllllllIlIlIlIIllllIIl < lllllllllllllllllIlIlIlIIllllIII; ++lllllllllllllllllIlIlIlIIllllIIl) {
            int lllllllllllllllllIlIlIlIIlllllII = lllllllllllllllllIlIlIlIIlllIlII.getGlyphCharIndex(lllllllllllllllllIlIlIlIIllllIIl);
            int lllllllllllllllllIlIlIlIIllllIll = lllllllllllllllllIlIlIlIIlllIllI.codePointAt(lllllllllllllllllIlIlIlIIlllllII);
            if (lllllllllllllllllIlIlIlIIllllIll == 32) continue;
            Rectangle lllllllllllllllllIlIlIlIIllllIlI = lllllllllllllllllIlIlIlIIlllIIIl.getGlyphBounds(lllllllllllllllllIlIlIlIIlllIlII, lllllllllllllllllIlIlIlIIllllIIl, lllllllllllllllllIlIlIlIIllllIll);
            lllllllllllllllllIlIlIlIIlllIIlI = Math.max(lllllllllllllllllIlIlIlIIlllIIlI, lllllllllllllllllIlIlIlIIlllIIIl.ascent + lllllllllllllllllIlIlIlIIllllIlI.y + lllllllllllllllllIlIlIlIIllllIlI.height);
            if (lllllllllllllllllIlIlIlIIllllIll != 10) continue;
            ++lllllllllllllllllIlIlIlIIlllIIll;
            lllllllllllllllllIlIlIlIIlllIIlI = 0;
        }
        return lllllllllllllllllIlIlIlIIlllIIll * lllllllllllllllllIlIlIlIIlllIIIl.getLineHeight() + lllllllllllllllllIlIlIlIIlllIIlI;
    }

    private void initializeFont(java.awt.Font lllllllllllllllllIlIllIIIIllIllI, int lllllllllllllllllIlIllIIIIllIlII, boolean lllllllllllllllllIlIllIIIIllIIlI, boolean lllllllllllllllllIlIllIIIIllllll) {
        UnicodeFont lllllllllllllllllIlIllIIIlIIIlII;
        Map<TextAttribute, ?> lllllllllllllllllIlIllIIIIlllllI = lllllllllllllllllIlIllIIIIllIllI.getAttributes();
        lllllllllllllllllIlIllIIIIlllllI.put(TextAttribute.SIZE, new Float(lllllllllllllllllIlIllIIIIllIlII));
        lllllllllllllllllIlIllIIIIlllllI.put(TextAttribute.WEIGHT, lllllllllllllllllIlIllIIIIllIIlI ? TextAttribute.WEIGHT_BOLD : TextAttribute.WEIGHT_REGULAR);
        lllllllllllllllllIlIllIIIIlllllI.put(TextAttribute.POSTURE, lllllllllllllllllIlIllIIIIllllll ? TextAttribute.POSTURE_OBLIQUE : TextAttribute.POSTURE_REGULAR);
        try {
            lllllllllllllllllIlIllIIIIlllllI.put((TextAttribute)TextAttribute.class.getDeclaredField("KERNING").get(null), TextAttribute.class.getDeclaredField("KERNING_ON").get(null));
        }
        catch (Exception lllllllllllllllllIlIllIIIlIIIlIl) {
            // empty catch block
        }
        lllllllllllllllllIlIllIIIlIIIlII.font = lllllllllllllllllIlIllIIIIllIllI.deriveFont(lllllllllllllllllIlIllIIIIlllllI);
        FontMetrics lllllllllllllllllIlIllIIIIllllII = GlyphPage.getScratchGraphics().getFontMetrics(lllllllllllllllllIlIllIIIlIIIlII.font);
        lllllllllllllllllIlIllIIIlIIIlII.ascent = lllllllllllllllllIlIllIIIIllllII.getAscent();
        lllllllllllllllllIlIllIIIlIIIlII.descent = lllllllllllllllllIlIllIIIIllllII.getDescent();
        lllllllllllllllllIlIllIIIlIIIlII.leading = lllllllllllllllllIlIllIIIIllllII.getLeading();
        char[] lllllllllllllllllIlIllIIIIlllIll = " ".toCharArray();
        GlyphVector lllllllllllllllllIlIllIIIIlllIIl = lllllllllllllllllIlIllIIIlIIIlII.font.layoutGlyphVector(GlyphPage.renderContext, lllllllllllllllllIlIllIIIIlllIll, 0, lllllllllllllllllIlIllIIIIlllIll.length, 0);
        lllllllllllllllllIlIllIIIlIIIlII.spaceWidth = lllllllllllllllllIlIllIIIIlllIIl.getGlyphLogicalBounds((int)0).getBounds().width;
    }

    private void loadSettings(HieroSettings lllllllllllllllllIlIllIIIIlIIlll) {
        UnicodeFont lllllllllllllllllIlIllIIIIlIIllI;
        lllllllllllllllllIlIllIIIIlIIllI.paddingTop = lllllllllllllllllIlIllIIIIlIIlll.getPaddingTop();
        lllllllllllllllllIlIllIIIIlIIllI.paddingLeft = lllllllllllllllllIlIllIIIIlIIlll.getPaddingLeft();
        lllllllllllllllllIlIllIIIIlIIllI.paddingBottom = lllllllllllllllllIlIllIIIIlIIlll.getPaddingBottom();
        lllllllllllllllllIlIllIIIIlIIllI.paddingRight = lllllllllllllllllIlIllIIIIlIIlll.getPaddingRight();
        lllllllllllllllllIlIllIIIIlIIllI.paddingAdvanceX = lllllllllllllllllIlIllIIIIlIIlll.getPaddingAdvanceX();
        lllllllllllllllllIlIllIIIIlIIllI.paddingAdvanceY = lllllllllllllllllIlIllIIIIlIIlll.getPaddingAdvanceY();
        lllllllllllllllllIlIllIIIIlIIllI.glyphPageWidth = lllllllllllllllllIlIllIIIIlIIlll.getGlyphPageWidth();
        lllllllllllllllllIlIllIIIIlIIllI.glyphPageHeight = lllllllllllllllllIlIllIIIIlIIlll.getGlyphPageHeight();
        lllllllllllllllllIlIllIIIIlIIllI.effects.addAll(lllllllllllllllllIlIllIIIIlIIlll.getEffects());
    }

    public int getLeading() {
        UnicodeFont lllllllllllllllllIlIlIIlllIIIIll;
        return lllllllllllllllllIlIlIIlllIIIIll.leading;
    }

    public int getGlyphPageWidth() {
        UnicodeFont lllllllllllllllllIlIlIIlllIIIIII;
        return lllllllllllllllllIlIlIIlllIIIIII.glyphPageWidth;
    }

    static {
        DISPLAY_LIST_CACHE_SIZE = 200;
        PAGE_SIZE = 512;
        MAX_GLYPH_CODE = 0x10FFFF;
        PAGES = 2175;
        GL = Renderer.get();
        EMPTY_DISPLAY_LIST = new DisplayList();
        heightComparator = new Comparator(){

            public int compare(Object llllllllllllllllIIIIlIllIIIIIlII, Object llllllllllllllllIIIIlIllIIIIIIIl) {
                return ((Glyph)llllllllllllllllIIIIlIllIIIIIlII).getHeight() - ((Glyph)llllllllllllllllIIIIlIllIIIIIIIl).getHeight();
            }
            {
                1 llllllllllllllllIIIIlIllIIIIlIII;
            }
        };
    }

    @Override
    public int getLineHeight() {
        UnicodeFont lllllllllllllllllIlIlIIlllIIllII;
        return lllllllllllllllllIlIlIIlllIIllII.descent + lllllllllllllllllIlIlIIlllIIllII.ascent + lllllllllllllllllIlIlIIlllIIllII.leading + lllllllllllllllllIlIlIIlllIIllII.paddingTop + lllllllllllllllllIlIlIIlllIIllII.paddingBottom + lllllllllllllllllIlIlIIlllIIllII.paddingAdvanceY;
    }

    public boolean isCaching() {
        UnicodeFont lllllllllllllllllIlIlIIllIlIlIII;
        return lllllllllllllllllIlIlIIllIlIlIII.displayListCaching;
    }

    @Override
    public void drawString(float lllllllllllllllllIlIlIllIIlIlllI, float lllllllllllllllllIlIlIllIIlIllIl, String lllllllllllllllllIlIlIllIIllIIll, Color lllllllllllllllllIlIlIllIIlIlIll, int lllllllllllllllllIlIlIllIIllIIIl, int lllllllllllllllllIlIlIllIIlIlIII) {
        UnicodeFont lllllllllllllllllIlIlIllIIllIllI;
        lllllllllllllllllIlIlIllIIllIllI.drawDisplayList(lllllllllllllllllIlIlIllIIlIlllI, lllllllllllllllllIlIlIllIIlIllIl, lllllllllllllllllIlIlIllIIllIIll, lllllllllllllllllIlIlIllIIlIlIll, lllllllllllllllllIlIlIllIIllIIIl, lllllllllllllllllIlIlIllIIlIlIII);
    }

    public int getPaddingAdvanceY() {
        UnicodeFont lllllllllllllllllIlIlIIlllIlllIl;
        return lllllllllllllllllIlIlIIlllIlllIl.paddingAdvanceY;
    }

    /*
     * Enabled aggressive block sorting
     */
    public DisplayList drawDisplayList(float lllllllllllllllllIlIlIllIllIIlll, float lllllllllllllllllIlIlIllIllIIlIl, String lllllllllllllllllIlIlIllIllllIIl, Color lllllllllllllllllIlIlIllIllIIIlI, int lllllllllllllllllIlIlIllIllIIIII, int lllllllllllllllllIlIlIllIlllIllI) {
        UnicodeFont lllllllllllllllllIlIlIllIllIlIII;
        if (lllllllllllllllllIlIlIllIllllIIl == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (lllllllllllllllllIlIlIllIllllIIl.length() == 0) {
            return EMPTY_DISPLAY_LIST;
        }
        if (lllllllllllllllllIlIlIllIllIIIlI == null) {
            throw new IllegalArgumentException("color cannot be null.");
        }
        lllllllllllllllllIlIlIllIllIIlll -= (float)lllllllllllllllllIlIlIllIllIlIII.paddingLeft;
        lllllllllllllllllIlIlIllIllIIlIl -= (float)lllllllllllllllllIlIlIllIllIlIII.paddingTop;
        String lllllllllllllllllIlIlIllIlllIlIl = lllllllllllllllllIlIlIllIllllIIl.substring(lllllllllllllllllIlIlIllIllIIIII, lllllllllllllllllIlIlIllIlllIllI);
        lllllllllllllllllIlIlIllIllIIIlI.bind();
        TextureImpl.bindNone();
        DisplayList lllllllllllllllllIlIlIllIlllIlII = null;
        if (lllllllllllllllllIlIlIllIllIlIII.displayListCaching && lllllllllllllllllIlIlIllIllIlIII.queuedGlyphs.isEmpty()) {
            if (lllllllllllllllllIlIlIllIllIlIII.baseDisplayListID == -1) {
                lllllllllllllllllIlIlIllIllIlIII.baseDisplayListID = GL.glGenLists(200);
                if (lllllllllllllllllIlIlIllIllIlIII.baseDisplayListID == 0) {
                    lllllllllllllllllIlIlIllIllIlIII.baseDisplayListID = -1;
                    lllllllllllllllllIlIlIllIllIlIII.displayListCaching = false;
                    return new DisplayList();
                }
            }
            if ((lllllllllllllllllIlIlIllIlllIlII = (DisplayList)lllllllllllllllllIlIlIllIllIlIII.displayLists.get(lllllllllllllllllIlIlIllIlllIlIl)) != null) {
                if (!lllllllllllllllllIlIlIllIlllIlII.invalid) {
                    GL.glTranslatef(lllllllllllllllllIlIlIllIllIIlll, lllllllllllllllllIlIlIllIllIIlIl, 0.0f);
                    GL.glCallList(lllllllllllllllllIlIlIllIlllIlII.id);
                    GL.glTranslatef(-lllllllllllllllllIlIlIllIllIIlll, -lllllllllllllllllIlIlIllIllIIlIl, 0.0f);
                    return lllllllllllllllllIlIlIllIlllIlII;
                }
                lllllllllllllllllIlIlIllIlllIlII.invalid = false;
            } else if (lllllllllllllllllIlIlIllIlllIlII == null) {
                lllllllllllllllllIlIlIllIlllIlII = new DisplayList();
                int lllllllllllllllllIlIlIlllIIIIlIl = lllllllllllllllllIlIlIllIllIlIII.displayLists.size();
                lllllllllllllllllIlIlIllIllIlIII.displayLists.put(lllllllllllllllllIlIlIllIlllIlIl, lllllllllllllllllIlIlIllIlllIlII);
                lllllllllllllllllIlIlIllIlllIlII.id = lllllllllllllllllIlIlIlllIIIIlIl < 200 ? lllllllllllllllllIlIlIllIllIlIII.baseDisplayListID + lllllllllllllllllIlIlIlllIIIIlIl : lllllllllllllllllIlIlIllIllIlIII.eldestDisplayListID;
            }
            lllllllllllllllllIlIlIllIllIlIII.displayLists.put(lllllllllllllllllIlIlIllIlllIlIl, lllllllllllllllllIlIlIllIlllIlII);
        }
        GL.glTranslatef(lllllllllllllllllIlIlIllIllIIlll, lllllllllllllllllIlIlIllIllIIlIl, 0.0f);
        if (lllllllllllllllllIlIlIllIlllIlII != null) {
            GL.glNewList(lllllllllllllllllIlIlIllIlllIlII.id, 4865);
        }
        char[] lllllllllllllllllIlIlIllIlllIIll = lllllllllllllllllIlIlIllIllllIIl.substring(0, lllllllllllllllllIlIlIllIlllIllI).toCharArray();
        GlyphVector lllllllllllllllllIlIlIllIlllIIlI = lllllllllllllllllIlIlIllIllIlIII.font.layoutGlyphVector(GlyphPage.renderContext, lllllllllllllllllIlIlIllIlllIIll, 0, lllllllllllllllllIlIlIllIlllIIll.length, 0);
        int lllllllllllllllllIlIlIllIlllIIIl = 0;
        int lllllllllllllllllIlIlIllIlllIIII = 0;
        int lllllllllllllllllIlIlIllIllIllll = 0;
        int lllllllllllllllllIlIlIllIllIlllI = 0;
        int lllllllllllllllllIlIlIllIllIllII = lllllllllllllllllIlIlIllIllIlIII.ascent;
        boolean lllllllllllllllllIlIlIllIllIlIll = false;
        Texture lllllllllllllllllIlIlIllIllIlIIl = null;
        int lllllllllllllllllIlIlIllIlllllIl = lllllllllllllllllIlIlIllIlllIIlI.getNumGlyphs();
        for (int lllllllllllllllllIlIlIllIllllllI = 0; lllllllllllllllllIlIlIllIllllllI < lllllllllllllllllIlIlIllIlllllIl; ++lllllllllllllllllIlIlIllIllllllI) {
            Image lllllllllllllllllIlIlIllIlllllll;
            int lllllllllllllllllIlIlIlllIIIIIll = lllllllllllllllllIlIlIllIlllIIlI.getGlyphCharIndex(lllllllllllllllllIlIlIllIllllllI);
            if (lllllllllllllllllIlIlIlllIIIIIll < lllllllllllllllllIlIlIllIllIIIII) continue;
            if (lllllllllllllllllIlIlIlllIIIIIll > lllllllllllllllllIlIlIllIlllIllI) break;
            int lllllllllllllllllIlIlIlllIIIIIlI = lllllllllllllllllIlIlIllIllllIIl.codePointAt(lllllllllllllllllIlIlIlllIIIIIll);
            Rectangle lllllllllllllllllIlIlIlllIIIIIIl = lllllllllllllllllIlIlIllIllIlIII.getGlyphBounds(lllllllllllllllllIlIlIllIlllIIlI, lllllllllllllllllIlIlIllIllllllI, lllllllllllllllllIlIlIlllIIIIIlI);
            Glyph lllllllllllllllllIlIlIlllIIIIIII = lllllllllllllllllIlIlIllIllIlIII.getGlyph(lllllllllllllllllIlIlIllIlllIIlI.getGlyphCode(lllllllllllllllllIlIlIllIllllllI), lllllllllllllllllIlIlIlllIIIIIlI, lllllllllllllllllIlIlIlllIIIIIIl, lllllllllllllllllIlIlIllIlllIIlI, lllllllllllllllllIlIlIllIllllllI);
            if (lllllllllllllllllIlIlIllIllIlIll && lllllllllllllllllIlIlIlllIIIIIlI != 10) {
                lllllllllllllllllIlIlIllIllIlllI = -lllllllllllllllllIlIlIlllIIIIIIl.x;
                lllllllllllllllllIlIlIllIllIlIll = false;
            }
            if ((lllllllllllllllllIlIlIllIlllllll = lllllllllllllllllIlIlIlllIIIIIII.getImage()) == null && lllllllllllllllllIlIlIllIllIlIII.missingGlyph != null && lllllllllllllllllIlIlIlllIIIIIII.isMissing()) {
                lllllllllllllllllIlIlIllIlllllll = lllllllllllllllllIlIlIllIllIlIII.missingGlyph.getImage();
            }
            if (lllllllllllllllllIlIlIllIlllllll != null) {
                Texture lllllllllllllllllIlIlIlllIIIIlII = lllllllllllllllllIlIlIllIlllllll.getTexture();
                if (lllllllllllllllllIlIlIllIllIlIIl != null && lllllllllllllllllIlIlIllIllIlIIl != lllllllllllllllllIlIlIlllIIIIlII) {
                    GL.glEnd();
                    lllllllllllllllllIlIlIllIllIlIIl = null;
                }
                if (lllllllllllllllllIlIlIllIllIlIIl == null) {
                    lllllllllllllllllIlIlIlllIIIIlII.bind();
                    GL.glBegin(7);
                    lllllllllllllllllIlIlIllIllIlIIl = lllllllllllllllllIlIlIlllIIIIlII;
                }
                lllllllllllllllllIlIlIllIlllllll.drawEmbedded(lllllllllllllllllIlIlIlllIIIIIIl.x + lllllllllllllllllIlIlIllIllIlllI, lllllllllllllllllIlIlIlllIIIIIIl.y + lllllllllllllllllIlIlIllIllIllII, lllllllllllllllllIlIlIllIlllllll.getWidth(), lllllllllllllllllIlIlIllIlllllll.getHeight());
            }
            if (lllllllllllllllllIlIlIllIllllllI >= 0) {
                lllllllllllllllllIlIlIllIllIlllI += lllllllllllllllllIlIlIllIllIlIII.paddingRight + lllllllllllllllllIlIlIllIllIlIII.paddingLeft + lllllllllllllllllIlIlIllIllIlIII.paddingAdvanceX;
            }
            lllllllllllllllllIlIlIllIlllIIIl = Math.max(lllllllllllllllllIlIlIllIlllIIIl, lllllllllllllllllIlIlIlllIIIIIIl.x + lllllllllllllllllIlIlIllIllIlllI + lllllllllllllllllIlIlIlllIIIIIIl.width);
            lllllllllllllllllIlIlIllIlllIIII = Math.max(lllllllllllllllllIlIlIllIlllIIII, lllllllllllllllllIlIlIllIllIlIII.ascent + lllllllllllllllllIlIlIlllIIIIIIl.y + lllllllllllllllllIlIlIlllIIIIIIl.height);
            if (lllllllllllllllllIlIlIlllIIIIIlI != 10) continue;
            lllllllllllllllllIlIlIllIllIlIll = true;
            lllllllllllllllllIlIlIllIllIllII += lllllllllllllllllIlIlIllIllIlIII.getLineHeight();
            ++lllllllllllllllllIlIlIllIllIllll;
            lllllllllllllllllIlIlIllIlllIIII = 0;
        }
        if (lllllllllllllllllIlIlIllIllIlIIl != null) {
            GL.glEnd();
        }
        if (lllllllllllllllllIlIlIllIlllIlII != null) {
            GL.glEndList();
            if (!lllllllllllllllllIlIlIllIllIlIII.queuedGlyphs.isEmpty()) {
                lllllllllllllllllIlIlIllIlllIlII.invalid = true;
            }
        }
        GL.glTranslatef(-lllllllllllllllllIlIlIllIllIIlll, -lllllllllllllllllIlIlIllIllIIlIl, 0.0f);
        if (lllllllllllllllllIlIlIllIlllIlII == null) {
            lllllllllllllllllIlIlIllIlllIlII = new DisplayList();
        }
        lllllllllllllllllIlIlIllIlllIlII.width = (short)lllllllllllllllllIlIlIllIlllIIIl;
        lllllllllllllllllIlIlIllIlllIlII.height = (short)(lllllllllllllllllIlIlIllIllIllll * lllllllllllllllllIlIlIllIllIlIII.getLineHeight() + lllllllllllllllllIlIlIllIlllIIII);
        return lllllllllllllllllIlIlIllIlllIlII;
    }

    public UnicodeFont(java.awt.Font lllllllllllllllllIlIllIIIllIIlIl, int lllllllllllllllllIlIllIIIlIlllll, boolean lllllllllllllllllIlIllIIIllIIIll, boolean lllllllllllllllllIlIllIIIllIIIlI) {
        UnicodeFont lllllllllllllllllIlIllIIIllIIllI;
        lllllllllllllllllIlIllIIIllIIllI.glyphs = new Glyph[2175][];
        lllllllllllllllllIlIllIIIllIIllI.glyphPages = new ArrayList();
        lllllllllllllllllIlIllIIIllIIllI.queuedGlyphs = new ArrayList(256);
        lllllllllllllllllIlIllIIIllIIllI.effects = new ArrayList();
        lllllllllllllllllIlIllIIIllIIllI.glyphPageWidth = 512;
        lllllllllllllllllIlIllIIIllIIllI.glyphPageHeight = 512;
        lllllllllllllllllIlIllIIIllIIllI.displayListCaching = true;
        lllllllllllllllllIlIllIIIllIIllI.baseDisplayListID = -1;
        lllllllllllllllllIlIllIIIllIIllI.displayLists = new LinkedHashMap(200, 1.0f, true){
            {
                2 lllllllllllllllIlllIIlllIllIlIll;
                super(lllllllllllllllIlllIIlllIllIlllI, lllllllllllllllIlllIIlllIllIlIII, lllllllllllllllIlllIIlllIllIllII);
            }

            protected boolean removeEldestEntry(Map.Entry lllllllllllllllIlllIIlllIllIIIlI) {
                2 lllllllllllllllIlllIIlllIllIIIll;
                DisplayList lllllllllllllllIlllIIlllIllIIIIl = (DisplayList)lllllllllllllllIlllIIlllIllIIIlI.getValue();
                if (lllllllllllllllIlllIIlllIllIIIIl != null) {
                    lllllllllllllllIlllIIlllIllIIIll.UnicodeFont.this.eldestDisplayListID = lllllllllllllllIlllIIlllIllIIIIl.id;
                }
                return lllllllllllllllIlllIIlllIllIIIll.size() > 200;
            }
        };
        lllllllllllllllllIlIllIIIllIIllI.initializeFont(lllllllllllllllllIlIllIIIllIIlIl, lllllllllllllllllIlIllIIIlIlllll, lllllllllllllllllIlIllIIIllIIIll, lllllllllllllllllIlIllIIIllIIIlI);
    }

    public String getFontFile() {
        UnicodeFont lllllllllllllllllIlIlIIllIIllIlI;
        if (lllllllllllllllllIlIlIIllIIllIlI.ttfFileRef == null) {
            try {
                Object lllllllllllllllllIlIlIIllIIllllI = Class.forName("sun.font.FontManager").getDeclaredMethod("getFont2D", java.awt.Font.class).invoke(null, lllllllllllllllllIlIlIIllIIllIlI.font);
                Field lllllllllllllllllIlIlIIllIIlllIl = Class.forName("sun.font.PhysicalFont").getDeclaredField("platName");
                lllllllllllllllllIlIlIIllIIlllIl.setAccessible(true);
                lllllllllllllllllIlIlIIllIIllIlI.ttfFileRef = (String)lllllllllllllllllIlIlIIllIIlllIl.get(lllllllllllllllllIlIlIIllIIllllI);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            if (lllllllllllllllllIlIlIIllIIllIlI.ttfFileRef == null) {
                lllllllllllllllllIlIlIIllIIllIlI.ttfFileRef = "";
            }
        }
        if (lllllllllllllllllIlIlIIllIIllIlI.ttfFileRef.length() == 0) {
            return null;
        }
        return lllllllllllllllllIlIlIIllIIllIlI.ttfFileRef;
    }

    public UnicodeFont(String lllllllllllllllllIlIllIIllIIIlIl, HieroSettings lllllllllllllllllIlIllIIllIIlIII) throws SlickException {
        UnicodeFont lllllllllllllllllIlIllIIllIIIllI;
        lllllllllllllllllIlIllIIllIIIllI.glyphs = new Glyph[2175][];
        lllllllllllllllllIlIllIIllIIIllI.glyphPages = new ArrayList();
        lllllllllllllllllIlIllIIllIIIllI.queuedGlyphs = new ArrayList(256);
        lllllllllllllllllIlIllIIllIIIllI.effects = new ArrayList();
        lllllllllllllllllIlIllIIllIIIllI.glyphPageWidth = 512;
        lllllllllllllllllIlIllIIllIIIllI.glyphPageHeight = 512;
        lllllllllllllllllIlIllIIllIIIllI.displayListCaching = true;
        lllllllllllllllllIlIllIIllIIIllI.baseDisplayListID = -1;
        lllllllllllllllllIlIllIIllIIIllI.displayLists = new /* invalid duplicate definition of identical inner class */;
        lllllllllllllllllIlIllIIllIIIllI.ttfFileRef = lllllllllllllllllIlIllIIllIIIlIl;
        java.awt.Font lllllllllllllllllIlIllIIllIIIlll = UnicodeFont.createFont(lllllllllllllllllIlIllIIllIIIlIl);
        lllllllllllllllllIlIllIIllIIIllI.initializeFont(lllllllllllllllllIlIllIIllIIIlll, lllllllllllllllllIlIllIIllIIlIII.getFontSize(), lllllllllllllllllIlIllIIllIIlIII.isBold(), lllllllllllllllllIlIllIIllIIlIII.isItalic());
        lllllllllllllllllIlIllIIllIIIllI.loadSettings(lllllllllllllllllIlIllIIllIIlIII);
    }

    public boolean loadGlyphs() throws SlickException {
        UnicodeFont lllllllllllllllllIlIlIllllllIIlI;
        return lllllllllllllllllIlIlIllllllIIlI.loadGlyphs(-1);
    }

    public void setDisplayListCaching(boolean lllllllllllllllllIlIlIIllIlIIIlI) {
        lllllllllllllllllIlIlIIllIlIIIll.displayListCaching = lllllllllllllllllIlIlIIllIlIIIlI;
    }

    public void clearGlyphs() {
        UnicodeFont lllllllllllllllllIlIlIlllIlllIII;
        for (int lllllllllllllllllIlIlIlllIlllllI = 0; lllllllllllllllllIlIlIlllIlllllI < 2175; ++lllllllllllllllllIlIlIlllIlllllI) {
            lllllllllllllllllIlIlIlllIlllIII.glyphs[lllllllllllllllllIlIlIlllIlllllI] = null;
        }
        for (GlyphPage lllllllllllllllllIlIlIlllIlllIll : lllllllllllllllllIlIlIlllIlllIII.glyphPages) {
            try {
                lllllllllllllllllIlIlIlllIlllIll.getImage().destroy();
            }
            catch (SlickException slickException) {}
        }
        lllllllllllllllllIlIlIlllIlllIII.glyphPages.clear();
        if (lllllllllllllllllIlIlIlllIlllIII.baseDisplayListID != -1) {
            GL.glDeleteLists(lllllllllllllllllIlIlIlllIlllIII.baseDisplayListID, lllllllllllllllllIlIlIlllIlllIII.displayLists.size());
            lllllllllllllllllIlIlIlllIlllIII.baseDisplayListID = -1;
        }
        lllllllllllllllllIlIlIlllIlllIII.queuedGlyphs.clear();
        lllllllllllllllllIlIlIlllIlllIII.missingGlyph = null;
    }

    private Rectangle getGlyphBounds(GlyphVector lllllllllllllllllIlIlIlIllIlIIIl, int lllllllllllllllllIlIlIlIllIlIIII, int lllllllllllllllllIlIlIlIllIIllll) {
        Rectangle lllllllllllllllllIlIlIlIllIlIIll = lllllllllllllllllIlIlIlIllIlIIIl.getGlyphPixelBounds(lllllllllllllllllIlIlIlIllIlIIII, GlyphPage.renderContext, 0.0f, 0.0f);
        if (lllllllllllllllllIlIlIlIllIIllll == 32) {
            UnicodeFont lllllllllllllllllIlIlIlIllIlIlll;
            lllllllllllllllllIlIlIlIllIlIIll.width = lllllllllllllllllIlIlIlIllIlIlll.spaceWidth;
        }
        return lllllllllllllllllIlIlIlIllIlIIll;
    }

    public UnicodeFont(String lllllllllllllllllIlIllIIlllIIllI, String lllllllllllllllllIlIllIIlllIIlIl) throws SlickException {
        lllllllllllllllllIlIllIIlllIlIlI(lllllllllllllllllIlIllIIlllIIllI, new HieroSettings(lllllllllllllllllIlIllIIlllIIlIl));
        UnicodeFont lllllllllllllllllIlIllIIlllIlIlI;
    }

    public void addGlyphs(String lllllllllllllllllIlIllIIIIIIIlII) {
        UnicodeFont lllllllllllllllllIlIllIIIIIIIlIl;
        if (lllllllllllllllllIlIllIIIIIIIlII == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        char[] lllllllllllllllllIlIllIIIIIIIIll = lllllllllllllllllIlIllIIIIIIIlII.toCharArray();
        GlyphVector lllllllllllllllllIlIllIIIIIIIIlI = lllllllllllllllllIlIllIIIIIIIlIl.font.layoutGlyphVector(GlyphPage.renderContext, lllllllllllllllllIlIllIIIIIIIIll, 0, lllllllllllllllllIlIllIIIIIIIIll.length, 0);
        int lllllllllllllllllIlIllIIIIIIIllI = lllllllllllllllllIlIllIIIIIIIIlI.getNumGlyphs();
        for (int lllllllllllllllllIlIllIIIIIIIlll = 0; lllllllllllllllllIlIllIIIIIIIlll < lllllllllllllllllIlIllIIIIIIIllI; ++lllllllllllllllllIlIllIIIIIIIlll) {
            int lllllllllllllllllIlIllIIIIIIlIIl = lllllllllllllllllIlIllIIIIIIIlII.codePointAt(lllllllllllllllllIlIllIIIIIIIIlI.getGlyphCharIndex(lllllllllllllllllIlIllIIIIIIIlll));
            Rectangle lllllllllllllllllIlIllIIIIIIlIII = lllllllllllllllllIlIllIIIIIIIlIl.getGlyphBounds(lllllllllllllllllIlIllIIIIIIIIlI, lllllllllllllllllIlIllIIIIIIIlll, lllllllllllllllllIlIllIIIIIIlIIl);
            lllllllllllllllllIlIllIIIIIIIlIl.getGlyph(lllllllllllllllllIlIllIIIIIIIIlI.getGlyphCode(lllllllllllllllllIlIllIIIIIIIlll), lllllllllllllllllIlIllIIIIIIlIIl, lllllllllllllllllIlIllIIIIIIlIII, lllllllllllllllllIlIllIIIIIIIIlI, lllllllllllllllllIlIllIIIIIIIlll);
        }
    }

    @Override
    public void drawString(float lllllllllllllllllIlIlIllIIIIIlIl, float lllllllllllllllllIlIlIllIIIIlIIl, String lllllllllllllllllIlIlIllIIIIlIII, Color lllllllllllllllllIlIlIllIIIIIIII) {
        UnicodeFont lllllllllllllllllIlIlIllIIIIIllI;
        lllllllllllllllllIlIlIllIIIIIllI.drawString(lllllllllllllllllIlIlIllIIIIIlIl, lllllllllllllllllIlIlIllIIIIlIIl, lllllllllllllllllIlIlIllIIIIlIII, lllllllllllllllllIlIlIllIIIIIIII, 0, lllllllllllllllllIlIlIllIIIIlIII.length());
    }

    public void setGlyphPageHeight(int lllllllllllllllllIlIlIIllIllIIIl) {
        lllllllllllllllllIlIlIIllIllIIlI.glyphPageHeight = lllllllllllllllllIlIlIIllIllIIIl;
    }

    private static java.awt.Font createFont(String lllllllllllllllllIlIllIIllllIIIl) throws SlickException {
        try {
            return java.awt.Font.createFont(0, ResourceLoader.getResourceAsStream(lllllllllllllllllIlIllIIllllIIIl));
        }
        catch (FontFormatException lllllllllllllllllIlIllIIllllIlIl) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Invalid font: ").append(lllllllllllllllllIlIllIIllllIIIl)), lllllllllllllllllIlIllIIllllIlIl);
        }
        catch (IOException lllllllllllllllllIlIllIIllllIlII) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Error reading font: ").append(lllllllllllllllllIlIllIIllllIIIl)), lllllllllllllllllIlIllIIllllIlII);
        }
    }

    public int getDescent() {
        UnicodeFont lllllllllllllllllIlIlIIlllIIIlll;
        return lllllllllllllllllIlIlIIlllIIIlll.descent;
    }

    public void setGlyphPageWidth(int lllllllllllllllllIlIlIIllIllllII) {
        lllllllllllllllllIlIlIIllIlllIll.glyphPageWidth = lllllllllllllllllIlIlIIllIllllII;
    }

    public void setPaddingAdvanceY(int lllllllllllllllllIlIlIIlllIlIlIl) {
        lllllllllllllllllIlIlIIlllIlIlII.paddingAdvanceY = lllllllllllllllllIlIlIIlllIlIlIl;
    }

    public int getPaddingLeft() {
        UnicodeFont lllllllllllllllllIlIlIlIIIIlllIl;
        return lllllllllllllllllIlIlIlIIIIlllIl.paddingLeft;
    }

    public int getPaddingTop() {
        UnicodeFont lllllllllllllllllIlIlIlIIIllIIII;
        return lllllllllllllllllIlIlIlIIIllIIII.paddingTop;
    }

    @Override
    public int getWidth(String lllllllllllllllllIlIlIlIlIIllIIl) {
        DisplayList lllllllllllllllllIlIlIlIlIlIlIlI;
        UnicodeFont lllllllllllllllllIlIlIlIlIIllIll;
        if (lllllllllllllllllIlIlIlIlIIllIIl == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (lllllllllllllllllIlIlIlIlIIllIIl.length() == 0) {
            return 0;
        }
        if (lllllllllllllllllIlIlIlIlIIllIll.displayListCaching && (lllllllllllllllllIlIlIlIlIlIlIlI = (DisplayList)lllllllllllllllllIlIlIlIlIIllIll.displayLists.get(lllllllllllllllllIlIlIlIlIIllIIl)) != null) {
            return lllllllllllllllllIlIlIlIlIlIlIlI.width;
        }
        char[] lllllllllllllllllIlIlIlIlIlIIIIl = lllllllllllllllllIlIlIlIlIIllIIl.toCharArray();
        GlyphVector lllllllllllllllllIlIlIlIlIlIIIII = lllllllllllllllllIlIlIlIlIIllIll.font.layoutGlyphVector(GlyphPage.renderContext, lllllllllllllllllIlIlIlIlIlIIIIl, 0, lllllllllllllllllIlIlIlIlIlIIIIl.length, 0);
        int lllllllllllllllllIlIlIlIlIIlllll = 0;
        int lllllllllllllllllIlIlIlIlIIllllI = 0;
        boolean lllllllllllllllllIlIlIlIlIIlllIl = false;
        int lllllllllllllllllIlIlIlIlIlIIlIl = lllllllllllllllllIlIlIlIlIlIIIII.getNumGlyphs();
        for (int lllllllllllllllllIlIlIlIlIlIIllI = 0; lllllllllllllllllIlIlIlIlIlIIllI < lllllllllllllllllIlIlIlIlIlIIlIl; ++lllllllllllllllllIlIlIlIlIlIIllI) {
            int lllllllllllllllllIlIlIlIlIlIlIIl = lllllllllllllllllIlIlIlIlIlIIIII.getGlyphCharIndex(lllllllllllllllllIlIlIlIlIlIIllI);
            int lllllllllllllllllIlIlIlIlIlIlIII = lllllllllllllllllIlIlIlIlIIllIIl.codePointAt(lllllllllllllllllIlIlIlIlIlIlIIl);
            Rectangle lllllllllllllllllIlIlIlIlIlIIlll = lllllllllllllllllIlIlIlIlIIllIll.getGlyphBounds(lllllllllllllllllIlIlIlIlIlIIIII, lllllllllllllllllIlIlIlIlIlIIllI, lllllllllllllllllIlIlIlIlIlIlIII);
            if (lllllllllllllllllIlIlIlIlIIlllIl && lllllllllllllllllIlIlIlIlIlIlIII != 10) {
                lllllllllllllllllIlIlIlIlIIllllI = -lllllllllllllllllIlIlIlIlIlIIlll.x;
            }
            if (lllllllllllllllllIlIlIlIlIlIIllI > 0) {
                lllllllllllllllllIlIlIlIlIIllllI += lllllllllllllllllIlIlIlIlIIllIll.paddingLeft + lllllllllllllllllIlIlIlIlIIllIll.paddingRight + lllllllllllllllllIlIlIlIlIIllIll.paddingAdvanceX;
            }
            lllllllllllllllllIlIlIlIlIIlllll = Math.max(lllllllllllllllllIlIlIlIlIIlllll, lllllllllllllllllIlIlIlIlIlIIlll.x + lllllllllllllllllIlIlIlIlIIllllI + lllllllllllllllllIlIlIlIlIlIIlll.width);
            if (lllllllllllllllllIlIlIlIlIlIlIII != 10) continue;
            lllllllllllllllllIlIlIlIlIIlllIl = true;
        }
        return lllllllllllllllllIlIlIlIlIIlllll;
    }

    public UnicodeFont(java.awt.Font lllllllllllllllllIlIllIIlIIIIIIl, HieroSettings lllllllllllllllllIlIllIIlIIIIIII) {
        UnicodeFont lllllllllllllllllIlIllIIlIIIIIlI;
        lllllllllllllllllIlIllIIlIIIIIlI.glyphs = new Glyph[2175][];
        lllllllllllllllllIlIllIIlIIIIIlI.glyphPages = new ArrayList();
        lllllllllllllllllIlIllIIlIIIIIlI.queuedGlyphs = new ArrayList(256);
        lllllllllllllllllIlIllIIlIIIIIlI.effects = new ArrayList();
        lllllllllllllllllIlIllIIlIIIIIlI.glyphPageWidth = 512;
        lllllllllllllllllIlIllIIlIIIIIlI.glyphPageHeight = 512;
        lllllllllllllllllIlIllIIlIIIIIlI.displayListCaching = true;
        lllllllllllllllllIlIllIIlIIIIIlI.baseDisplayListID = -1;
        lllllllllllllllllIlIllIIlIIIIIlI.displayLists = new /* invalid duplicate definition of identical inner class */;
        lllllllllllllllllIlIllIIlIIIIIlI.initializeFont(lllllllllllllllllIlIllIIlIIIIIIl, lllllllllllllllllIlIllIIlIIIIIII.getFontSize(), lllllllllllllllllIlIllIIlIIIIIII.isBold(), lllllllllllllllllIlIllIIlIIIIIII.isItalic());
        lllllllllllllllllIlIllIIlIIIIIlI.loadSettings(lllllllllllllllllIlIllIIlIIIIIII);
    }

    public List getGlyphPages() {
        UnicodeFont lllllllllllllllllIlIlIIllIlIllll;
        return lllllllllllllllllIlIlIIllIlIllll.glyphPages;
    }

    public UnicodeFont(String lllllllllllllllllIlIllIIlIlIIlll, int lllllllllllllllllIlIllIIlIlIllll, boolean lllllllllllllllllIlIllIIlIlIllIl, boolean lllllllllllllllllIlIllIIlIlIlIll) throws SlickException {
        UnicodeFont lllllllllllllllllIlIllIIlIlIlIIl;
        lllllllllllllllllIlIllIIlIlIlIIl.glyphs = new Glyph[2175][];
        lllllllllllllllllIlIllIIlIlIlIIl.glyphPages = new ArrayList();
        lllllllllllllllllIlIllIIlIlIlIIl.queuedGlyphs = new ArrayList(256);
        lllllllllllllllllIlIllIIlIlIlIIl.effects = new ArrayList();
        lllllllllllllllllIlIllIIlIlIlIIl.glyphPageWidth = 512;
        lllllllllllllllllIlIllIIlIlIlIIl.glyphPageHeight = 512;
        lllllllllllllllllIlIllIIlIlIlIIl.displayListCaching = true;
        lllllllllllllllllIlIllIIlIlIlIIl.baseDisplayListID = -1;
        lllllllllllllllllIlIllIIlIlIlIIl.displayLists = new /* invalid duplicate definition of identical inner class */;
        lllllllllllllllllIlIllIIlIlIlIIl.ttfFileRef = lllllllllllllllllIlIllIIlIlIIlll;
        lllllllllllllllllIlIllIIlIlIlIIl.initializeFont(UnicodeFont.createFont(lllllllllllllllllIlIllIIlIlIIlll), lllllllllllllllllIlIllIIlIlIllll, lllllllllllllllllIlIllIIlIlIllIl, lllllllllllllllllIlIllIIlIlIlIll);
    }

    public void addNeheGlyphs() {
        UnicodeFont lllllllllllllllllIlIlIllllllIlII;
        lllllllllllllllllIlIlIllllllIlII.addGlyphs(32, 128);
    }

    @Override
    public void drawString(float lllllllllllllllllIlIlIllIIIlllIl, float lllllllllllllllllIlIlIllIIIlIllI, String lllllllllllllllllIlIlIllIIIlIlII) {
        UnicodeFont lllllllllllllllllIlIlIllIIIllllI;
        lllllllllllllllllIlIlIllIIIllllI.drawString(lllllllllllllllllIlIlIllIIIlllIl, lllllllllllllllllIlIlIllIIIlIllI, lllllllllllllllllIlIlIllIIIlIlII, Color.white);
    }

    public int getPaddingRight() {
        UnicodeFont lllllllllllllllllIlIlIlIIIIIIIII;
        return lllllllllllllllllIlIlIlIIIIIIIII.paddingRight;
    }

    public int getAscent() {
        UnicodeFont lllllllllllllllllIlIlIIlllIIlIIl;
        return lllllllllllllllllIlIlIIlllIIlIIl.ascent;
    }

    public void setPaddingLeft(int lllllllllllllllllIlIlIlIIIIIlllI) {
        lllllllllllllllllIlIlIlIIIIlIlIl.paddingLeft = lllllllllllllllllIlIlIlIIIIIlllI;
    }

    public int getYOffset(String lllllllllllllllllIlIlIlIIlIIlIIl) {
        UnicodeFont lllllllllllllllllIlIlIlIIlIlIIlI;
        if (lllllllllllllllllIlIlIlIIlIIlIIl == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        DisplayList lllllllllllllllllIlIlIlIIlIlIIII = null;
        if (lllllllllllllllllIlIlIlIIlIlIIlI.displayListCaching && (lllllllllllllllllIlIlIlIIlIlIIII = (DisplayList)lllllllllllllllllIlIlIlIIlIlIIlI.displayLists.get(lllllllllllllllllIlIlIlIIlIIlIIl)) != null && lllllllllllllllllIlIlIlIIlIlIIII.yOffset != null) {
            return lllllllllllllllllIlIlIlIIlIlIIII.yOffset.intValue();
        }
        int lllllllllllllllllIlIlIlIIlIIllll = lllllllllllllllllIlIlIlIIlIIlIIl.indexOf(10);
        if (lllllllllllllllllIlIlIlIIlIIllll != -1) {
            lllllllllllllllllIlIlIlIIlIIlIIl = lllllllllllllllllIlIlIlIIlIIlIIl.substring(0, lllllllllllllllllIlIlIlIIlIIllll);
        }
        char[] lllllllllllllllllIlIlIlIIlIIlllI = lllllllllllllllllIlIlIlIIlIIlIIl.toCharArray();
        GlyphVector lllllllllllllllllIlIlIlIIlIIllIl = lllllllllllllllllIlIlIlIIlIlIIlI.font.layoutGlyphVector(GlyphPage.renderContext, lllllllllllllllllIlIlIlIIlIIlllI, 0, lllllllllllllllllIlIlIlIIlIIlllI.length, 0);
        int lllllllllllllllllIlIlIlIIlIIllII = lllllllllllllllllIlIlIlIIlIlIIlI.ascent + lllllllllllllllllIlIlIlIIlIIllIl.getPixelBounds(null, (float)0.0f, (float)0.0f).y;
        if (lllllllllllllllllIlIlIlIIlIlIIII != null) {
            lllllllllllllllllIlIlIlIIlIlIIII.yOffset = new Short((short)lllllllllllllllllIlIlIlIIlIIllII);
        }
        return lllllllllllllllllIlIlIlIIlIIllII;
    }

    private Glyph getGlyph(int lllllllllllllllllIlIlIlIlllIIlIl, int lllllllllllllllllIlIlIlIlllIIlII, Rectangle lllllllllllllllllIlIlIlIlllIIIll, GlyphVector lllllllllllllllllIlIlIlIlllIIIlI, int lllllllllllllllllIlIlIlIlllIIIIl) {
        UnicodeFont lllllllllllllllllIlIlIlIlllIIllI;
        if (lllllllllllllllllIlIlIlIlllIIlIl < 0 || lllllllllllllllllIlIlIlIlllIIlIl >= 0x10FFFF) {
            return new Glyph(lllllllllllllllllIlIlIlIlllIIlII, lllllllllllllllllIlIlIlIlllIIIll, lllllllllllllllllIlIlIlIlllIIIlI, lllllllllllllllllIlIlIlIlllIIIIl, lllllllllllllllllIlIlIlIlllIIllI){
                {
                    3 lllIlIIIlIlIIIl;
                    super(lllIlIIIlIlIlll, lllIlIIIlIlIllI, lllIlIIIlIIllII, lllIlIIIlIlIIll, lllIlIIIlIIlIIl);
                }

                @Override
                public boolean isMissing() {
                    return true;
                }
            };
        }
        int lllllllllllllllllIlIlIlIlllIlIlI = lllllllllllllllllIlIlIlIlllIIlIl / 512;
        int lllllllllllllllllIlIlIlIlllIlIIl = lllllllllllllllllIlIlIlIlllIIlIl & 0x1FF;
        Glyph lllllllllllllllllIlIlIlIlllIlIII = null;
        Glyph[] lllllllllllllllllIlIlIlIlllIIlll = lllllllllllllllllIlIlIlIlllIIllI.glyphs[lllllllllllllllllIlIlIlIlllIlIlI];
        if (lllllllllllllllllIlIlIlIlllIIlll != null) {
            lllllllllllllllllIlIlIlIlllIlIII = lllllllllllllllllIlIlIlIlllIIlll[lllllllllllllllllIlIlIlIlllIlIIl];
            if (lllllllllllllllllIlIlIlIlllIlIII != null) {
                return lllllllllllllllllIlIlIlIlllIlIII;
            }
        } else {
            lllllllllllllllllIlIlIlIlllIIllI.glyphs[lllllllllllllllllIlIlIlIlllIlIlI] = new Glyph[512];
            lllllllllllllllllIlIlIlIlllIIlll = lllllllllllllllllIlIlIlIlllIIllI.glyphs[lllllllllllllllllIlIlIlIlllIlIlI];
        }
        lllllllllllllllllIlIlIlIlllIlIII = lllllllllllllllllIlIlIlIlllIIlll[lllllllllllllllllIlIlIlIlllIlIIl] = new Glyph(lllllllllllllllllIlIlIlIlllIIlII, lllllllllllllllllIlIlIlIlllIIIll, lllllllllllllllllIlIlIlIlllIIIlI, lllllllllllllllllIlIlIlIlllIIIIl, lllllllllllllllllIlIlIlIlllIIllI);
        lllllllllllllllllIlIlIlIlllIIllI.queuedGlyphs.add(lllllllllllllllllIlIlIlIlllIlIII);
        return lllllllllllllllllIlIlIlIlllIlIII;
    }

    public void setPaddingRight(int lllllllllllllllllIlIlIIlllllIlIl) {
        lllllllllllllllllIlIlIIllllllIlI.paddingRight = lllllllllllllllllIlIlIIlllllIlIl;
    }

    public void destroy() {
        UnicodeFont lllllllllllllllllIlIlIlllIllIIIl;
        lllllllllllllllllIlIlIlllIllIIIl.clearGlyphs();
    }

    public UnicodeFont(java.awt.Font lllllllllllllllllIlIllIIIlllIlIl) {
        UnicodeFont lllllllllllllllllIlIllIIIlllIlll;
        lllllllllllllllllIlIllIIIlllIlll.glyphs = new Glyph[2175][];
        lllllllllllllllllIlIllIIIlllIlll.glyphPages = new ArrayList();
        lllllllllllllllllIlIllIIIlllIlll.queuedGlyphs = new ArrayList(256);
        lllllllllllllllllIlIllIIIlllIlll.effects = new ArrayList();
        lllllllllllllllllIlIllIIIlllIlll.glyphPageWidth = 512;
        lllllllllllllllllIlIllIIIlllIlll.glyphPageHeight = 512;
        lllllllllllllllllIlIllIIIlllIlll.displayListCaching = true;
        lllllllllllllllllIlIllIIIlllIlll.baseDisplayListID = -1;
        lllllllllllllllllIlIllIIIlllIlll.displayLists = new /* invalid duplicate definition of identical inner class */;
        lllllllllllllllllIlIllIIIlllIlll.initializeFont(lllllllllllllllllIlIllIIIlllIlIl, lllllllllllllllllIlIllIIIlllIlIl.getSize(), lllllllllllllllllIlIllIIIlllIlIl.isBold(), lllllllllllllllllIlIllIIIlllIlIl.isItalic());
    }

    public static class DisplayList {
        public /* synthetic */ Object userData;
        /* synthetic */ int id;
        /* synthetic */ Short yOffset;
        public /* synthetic */ short height;
        /* synthetic */ boolean invalid;
        public /* synthetic */ short width;

        DisplayList() {
            DisplayList lIIllllIlIlllIl;
        }
    }
}

