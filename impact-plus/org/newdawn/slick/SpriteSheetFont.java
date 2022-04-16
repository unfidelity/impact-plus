/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.UnsupportedEncodingException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.Log;

public class SpriteSheetFont
implements Font {
    private /* synthetic */ int charHeight;
    private /* synthetic */ char startingCharacter;
    private /* synthetic */ int charWidth;
    private /* synthetic */ SpriteSheet font;
    private /* synthetic */ int numChars;
    private /* synthetic */ int horizontalCount;

    @Override
    public void drawString(float llllllllllllllllllIlIIlIllllIIlI, float llllllllllllllllllIlIIlIllllIIII, String llllllllllllllllllIlIIlIlllIIlII, Color llllllllllllllllllIlIIlIlllIIIlI) {
        SpriteSheetFont llllllllllllllllllIlIIlIllllIlII;
        llllllllllllllllllIlIIlIllllIlII.drawString(llllllllllllllllllIlIIlIllllIIlI, llllllllllllllllllIlIIlIllllIIII, llllllllllllllllllIlIIlIlllIIlII, llllllllllllllllllIlIIlIlllIIIlI, 0, llllllllllllllllllIlIIlIlllIIlII.length() - 1);
    }

    public SpriteSheetFont(SpriteSheet llllllllllllllllllIlIIllIIlIlIII, char llllllllllllllllllIlIIllIIlIIIll) {
        SpriteSheetFont llllllllllllllllllIlIIllIIlIIlIl;
        llllllllllllllllllIlIIllIIlIIlIl.font = llllllllllllllllllIlIIllIIlIlIII;
        llllllllllllllllllIlIIllIIlIIlIl.startingCharacter = llllllllllllllllllIlIIllIIlIIIll;
        llllllllllllllllllIlIIllIIlIIlIl.horizontalCount = llllllllllllllllllIlIIllIIlIlIII.getHorizontalCount();
        int llllllllllllllllllIlIIllIIlIIllI = llllllllllllllllllIlIIllIIlIlIII.getVerticalCount();
        llllllllllllllllllIlIIllIIlIIlIl.charWidth = llllllllllllllllllIlIIllIIlIlIII.getWidth() / llllllllllllllllllIlIIllIIlIIlIl.horizontalCount;
        llllllllllllllllllIlIIllIIlIIlIl.charHeight = llllllllllllllllllIlIIllIIlIlIII.getHeight() / llllllllllllllllllIlIIllIIlIIllI;
        llllllllllllllllllIlIIllIIlIIlIl.numChars = llllllllllllllllllIlIIllIIlIIlIl.horizontalCount * llllllllllllllllllIlIIllIIlIIllI;
    }

    @Override
    public void drawString(float llllllllllllllllllIlIIllIIIIlIll, float llllllllllllllllllIlIIllIIIlIIIl, String llllllllllllllllllIlIIllIIIIllll) {
        SpriteSheetFont llllllllllllllllllIlIIllIIIlIlII;
        llllllllllllllllllIlIIllIIIlIlII.drawString(llllllllllllllllllIlIIllIIIIlIll, llllllllllllllllllIlIIllIIIlIIIl, llllllllllllllllllIlIIllIIIIllll, Color.white);
    }

    @Override
    public void drawString(float llllllllllllllllllIlIIlIlIlIIllI, float llllllllllllllllllIlIIlIlIlIllII, String llllllllllllllllllIlIIlIlIlIIlII, Color llllllllllllllllllIlIIlIlIlIIIll, int llllllllllllllllllIlIIlIlIlIIIlI, int llllllllllllllllllIlIIlIlIlIIIIl) {
        try {
            byte[] llllllllllllllllllIlIIlIlIllIIII = llllllllllllllllllIlIIlIlIlIIlII.getBytes("US-ASCII");
            for (int llllllllllllllllllIlIIlIlIllIIIl = 0; llllllllllllllllllIlIIlIlIllIIIl < llllllllllllllllllIlIIlIlIllIIII.length; ++llllllllllllllllllIlIIlIlIllIIIl) {
                SpriteSheetFont llllllllllllllllllIlIIlIlIlIIlll;
                int llllllllllllllllllIlIIlIlIllIIlI = llllllllllllllllllIlIIlIlIllIIII[llllllllllllllllllIlIIlIlIllIIIl] - llllllllllllllllllIlIIlIlIlIIlll.startingCharacter;
                if (llllllllllllllllllIlIIlIlIllIIlI >= llllllllllllllllllIlIIlIlIlIIlll.numChars) continue;
                int llllllllllllllllllIlIIlIlIllIlII = llllllllllllllllllIlIIlIlIllIIlI % llllllllllllllllllIlIIlIlIlIIlll.horizontalCount;
                int llllllllllllllllllIlIIlIlIllIIll = llllllllllllllllllIlIIlIlIllIIlI / llllllllllllllllllIlIIlIlIlIIlll.horizontalCount;
                if (llllllllllllllllllIlIIlIlIllIIIl < llllllllllllllllllIlIIlIlIlIIIlI || llllllllllllllllllIlIIlIlIllIIIl > llllllllllllllllllIlIIlIlIlIIIIl) continue;
                llllllllllllllllllIlIIlIlIlIIlll.font.getSprite(llllllllllllllllllIlIIlIlIllIlII, llllllllllllllllllIlIIlIlIllIIll).draw(llllllllllllllllllIlIIlIlIlIIllI + (float)(llllllllllllllllllIlIIlIlIllIIIl * llllllllllllllllllIlIIlIlIlIIlll.charWidth), llllllllllllllllllIlIIlIlIlIllII, llllllllllllllllllIlIIlIlIlIIIll);
            }
        }
        catch (UnsupportedEncodingException llllllllllllllllllIlIIlIlIlIllll) {
            Log.error(llllllllllllllllllIlIIlIlIlIllll);
        }
    }

    @Override
    public int getLineHeight() {
        SpriteSheetFont llllllllllllllllllIlIIlIlIIIIlII;
        return llllllllllllllllllIlIIlIlIIIIlII.charHeight;
    }

    @Override
    public int getWidth(String llllllllllllllllllIlIIlIlIIIllll) {
        SpriteSheetFont llllllllllllllllllIlIIlIlIIlIIIl;
        return llllllllllllllllllIlIIlIlIIlIIIl.charWidth * llllllllllllllllllIlIIlIlIIIllll.length();
    }

    @Override
    public int getHeight(String llllllllllllllllllIlIIlIlIIllIIl) {
        SpriteSheetFont llllllllllllllllllIlIIlIlIIllIII;
        return llllllllllllllllllIlIIlIlIIllIII.charHeight;
    }
}

