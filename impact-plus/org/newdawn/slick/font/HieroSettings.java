/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.font.effects.ConfigurableEffect;
import org.newdawn.slick.util.ResourceLoader;

public class HieroSettings {
    private /* synthetic */ int paddingAdvanceX;
    private /* synthetic */ int fontSize;
    private /* synthetic */ boolean bold;
    private /* synthetic */ boolean italic;
    private /* synthetic */ int paddingAdvanceY;
    private /* synthetic */ int paddingBottom;
    private final /* synthetic */ List effects;
    private /* synthetic */ int paddingRight;
    private /* synthetic */ int glyphPageWidth;
    private /* synthetic */ int paddingTop;
    private /* synthetic */ int glyphPageHeight;
    private /* synthetic */ int paddingLeft;

    public int getPaddingAdvanceY() {
        HieroSettings lIIllIlIIlIIIlI;
        return lIIllIlIIlIIIlI.paddingAdvanceY;
    }

    public int getGlyphPageHeight() {
        HieroSettings lIIllIlIIIIlIll;
        return lIIllIlIIIIlIll.glyphPageHeight;
    }

    public void setGlyphPageHeight(int lIIllIlIIIIIIlI) {
        lIIllIlIIIIIIll.glyphPageHeight = lIIllIlIIIIIIlI;
    }

    public HieroSettings() {
        HieroSettings lIIllIlIlllllIl;
        lIIllIlIlllllIl.fontSize = 12;
        lIIllIlIlllllIl.bold = false;
        lIIllIlIlllllIl.italic = false;
        lIIllIlIlllllIl.glyphPageWidth = 512;
        lIIllIlIlllllIl.glyphPageHeight = 512;
        lIIllIlIlllllIl.effects = new ArrayList();
    }

    public void save(File lIIllIIllIlIIlI) throws IOException {
        HieroSettings lIIllIIllIlIllI;
        PrintStream lIIllIIllIlIlII = new PrintStream(new FileOutputStream(lIIllIIllIlIIlI));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("font.size=").append(lIIllIIllIlIllI.fontSize)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("font.bold=").append(lIIllIIllIlIllI.bold)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("font.italic=").append(lIIllIIllIlIllI.italic)));
        lIIllIIllIlIlII.println();
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("pad.top=").append(lIIllIIllIlIllI.paddingTop)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("pad.right=").append(lIIllIIllIlIllI.paddingRight)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("pad.bottom=").append(lIIllIIllIlIllI.paddingBottom)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("pad.left=").append(lIIllIIllIlIllI.paddingLeft)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("pad.advance.x=").append(lIIllIIllIlIllI.paddingAdvanceX)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("pad.advance.y=").append(lIIllIIllIlIllI.paddingAdvanceY)));
        lIIllIIllIlIlII.println();
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("glyph.page.width=").append(lIIllIIllIlIllI.glyphPageWidth)));
        lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("glyph.page.height=").append(lIIllIIllIlIllI.glyphPageHeight)));
        lIIllIIllIlIlII.println();
        for (ConfigurableEffect lIIllIIllIllIII : lIIllIIllIlIllI.effects) {
            lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("effect.class=").append(lIIllIIllIllIII.getClass().getName())));
            for (ConfigurableEffect.Value lIIllIIllIllIlI : lIIllIIllIllIII.getValues()) {
                lIIllIIllIlIlII.println(String.valueOf(new StringBuilder().append("effect.").append(lIIllIIllIllIlI.getName()).append("=").append(lIIllIIllIllIlI.getString())));
            }
            lIIllIIllIlIlII.println();
        }
        lIIllIIllIlIlII.close();
    }

    public int getPaddingBottom() {
        HieroSettings lIIllIlIlIIIIII;
        return lIIllIlIlIIIIII.paddingBottom;
    }

    public boolean isItalic() {
        HieroSettings lIIllIIlllIllII;
        return lIIllIIlllIllII.italic;
    }

    public void setPaddingTop(int lIIllIlIlIIlIll) {
        lIIllIlIlIIlllI.paddingTop = lIIllIlIlIIlIll;
    }

    public int getPaddingLeft() {
        HieroSettings lIIllIlIlIIlIII;
        return lIIllIlIlIIlIII.paddingLeft;
    }

    public void setFontSize(int lIIllIIlllllIIl) {
        lIIllIIlllllIII.fontSize = lIIllIIlllllIIl;
    }

    public int getFontSize() {
        HieroSettings lIIllIIlllllllI;
        return lIIllIIlllllllI.fontSize;
    }

    public int getPaddingRight() {
        HieroSettings lIIllIlIIllIIll;
        return lIIllIlIIllIIll.paddingRight;
    }

    public void setItalic(boolean lIIllIIlllIIlIl) {
        lIIllIIlllIIllI.italic = lIIllIIlllIIlIl;
    }

    public int getGlyphPageWidth() {
        HieroSettings lIIllIlIIIllIIl;
        return lIIllIlIIIllIIl.glyphPageWidth;
    }

    public void setPaddingRight(int lIIllIlIIlIllIl) {
        lIIllIlIIlIlllI.paddingRight = lIIllIlIIlIllIl;
    }

    public void setGlyphPageWidth(int lIIllIlIIIlIlII) {
        lIIllIlIIIlIlIl.glyphPageWidth = lIIllIlIIIlIlII;
    }

    public HieroSettings(String lIIllIlIlllIlll) throws SlickException {
        lIIllIlIllllIII(ResourceLoader.getResourceAsStream(lIIllIlIlllIlll));
        HieroSettings lIIllIlIllllIII;
    }

    public int getPaddingTop() {
        HieroSettings lIIllIlIlIlIIIl;
        return lIIllIlIlIlIIIl.paddingTop;
    }

    public boolean isBold() {
        HieroSettings lIIllIIllllIlIl;
        return lIIllIIllllIlIl.bold;
    }

    public int getPaddingAdvanceX() {
        HieroSettings lIIllIlIIlIlIlI;
        return lIIllIlIIlIlIlI.paddingAdvanceX;
    }

    public HieroSettings(InputStream lIIllIlIlIlllIl) throws SlickException {
        HieroSettings lIIllIlIllIIIII;
        lIIllIlIllIIIII.fontSize = 12;
        lIIllIlIllIIIII.bold = false;
        lIIllIlIllIIIII.italic = false;
        lIIllIlIllIIIII.glyphPageWidth = 512;
        lIIllIlIllIIIII.glyphPageHeight = 512;
        lIIllIlIllIIIII.effects = new ArrayList();
        try {
            String lIIllIlIllIIllI;
            BufferedReader lIIllIlIllIIIlI = new BufferedReader(new InputStreamReader(lIIllIlIlIlllIl));
            while ((lIIllIlIllIIllI = lIIllIlIllIIIlI.readLine()) != null) {
                if ((lIIllIlIllIIllI = lIIllIlIllIIllI.trim()).length() == 0) continue;
                String[] lIIllIlIllIIlIl = lIIllIlIllIIllI.split("=", 2);
                String lIIllIlIllIIlII = lIIllIlIllIIlIl[0].trim();
                String lIIllIlIllIIIll = lIIllIlIllIIlIl[1];
                if (lIIllIlIllIIlII.equals("font.size")) {
                    lIIllIlIllIIIII.fontSize = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("font.bold")) {
                    lIIllIlIllIIIII.bold = Boolean.valueOf(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("font.italic")) {
                    lIIllIlIllIIIII.italic = Boolean.valueOf(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("pad.top")) {
                    lIIllIlIllIIIII.paddingTop = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("pad.right")) {
                    lIIllIlIllIIIII.paddingRight = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("pad.bottom")) {
                    lIIllIlIllIIIII.paddingBottom = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("pad.left")) {
                    lIIllIlIllIIIII.paddingLeft = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("pad.advance.x")) {
                    lIIllIlIllIIIII.paddingAdvanceX = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("pad.advance.y")) {
                    lIIllIlIllIIIII.paddingAdvanceY = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("glyph.page.width")) {
                    lIIllIlIllIIIII.glyphPageWidth = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("glyph.page.height")) {
                    lIIllIlIllIIIII.glyphPageHeight = Integer.parseInt(lIIllIlIllIIIll);
                    continue;
                }
                if (lIIllIlIllIIlII.equals("effect.class")) {
                    try {
                        lIIllIlIllIIIII.effects.add(Class.forName(lIIllIlIllIIIll).newInstance());
                        continue;
                    }
                    catch (Exception lIIllIlIllIlIll) {
                        throw new SlickException(String.valueOf(new StringBuilder().append("Unable to create effect instance: ").append(lIIllIlIllIIIll)), lIIllIlIllIlIll);
                    }
                }
                if (!lIIllIlIllIIlII.startsWith("effect.")) continue;
                lIIllIlIllIIlII = lIIllIlIllIIlII.substring(7);
                ConfigurableEffect lIIllIlIllIlIII = (ConfigurableEffect)lIIllIlIllIIIII.effects.get(lIIllIlIllIIIII.effects.size() - 1);
                List lIIllIlIllIIlll = lIIllIlIllIlIII.getValues();
                for (ConfigurableEffect.Value lIIllIlIllIlIlI : lIIllIlIllIIlll) {
                    if (!lIIllIlIllIlIlI.getName().equals(lIIllIlIllIIlII)) continue;
                    lIIllIlIllIlIlI.setString(lIIllIlIllIIIll);
                    break;
                }
                lIIllIlIllIlIII.setValues(lIIllIlIllIIlll);
            }
            lIIllIlIllIIIlI.close();
        }
        catch (Exception lIIllIlIllIIIIl) {
            throw new SlickException("Unable to load Hiero font file", lIIllIlIllIIIIl);
        }
    }

    public void setPaddingAdvanceY(int lIIllIlIIIlllIl) {
        lIIllIlIIIllllI.paddingAdvanceY = lIIllIlIIIlllIl;
    }

    public void setBold(boolean lIIllIIlllIlllI) {
        lIIllIIllllIIIl.bold = lIIllIIlllIlllI;
    }

    public List getEffects() {
        HieroSettings lIIllIIlllIIIll;
        return lIIllIIlllIIIll.effects;
    }

    public void setPaddingAdvanceX(int lIIllIlIIlIIlII) {
        lIIllIlIIlIIlIl.paddingAdvanceX = lIIllIlIIlIIlII;
    }

    public void setPaddingBottom(int lIIllIlIIlllIlI) {
        lIIllIlIIlllIll.paddingBottom = lIIllIlIIlllIlI;
    }

    public void setPaddingLeft(int lIIllIlIlIIIlII) {
        lIIllIlIlIIIlIl.paddingLeft = lIIllIlIlIIIlII;
    }
}

