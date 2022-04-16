/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;

public class FontUtils {
    public FontUtils() {
        FontUtils llllllllllllllllllIIllIlIIlllllI;
    }

    private static int calculateWidthOfJustifiedSpaceInPixels(Font llllllllllllllllllIIllIIllIIllll, String llllllllllllllllllIIllIIllIIlllI, int llllllllllllllllllIIllIIllIIllIl) {
        int llllllllllllllllllIIllIIllIIllII = 0;
        int llllllllllllllllllIIllIIllIIlIll = 0;
        while (llllllllllllllllllIIllIIllIIlIll < llllllllllllllllllIIllIIllIIlllI.length()) {
            if (llllllllllllllllllIIllIIllIIlllI.charAt(llllllllllllllllllIIllIIllIIlIll++) != ' ') continue;
            ++llllllllllllllllllIIllIIllIIllII;
        }
        if (llllllllllllllllllIIllIIllIIllII > 0) {
            llllllllllllllllllIIllIIllIIllII = (llllllllllllllllllIIllIIllIIllIl + llllllllllllllllllIIllIIllIIllll.getWidth(" ") * llllllllllllllllllIIllIIllIIllII) / llllllllllllllllllIIllIIllIIllII;
        }
        return llllllllllllllllllIIllIIllIIllII;
    }

    public static void drawRight(Font llllllllllllllllllIIllIIllllIlIl, String llllllllllllllllllIIllIIlllllIlI, int llllllllllllllllllIIllIIlllllIIl, int llllllllllllllllllIIllIIlllllIII, int llllllllllllllllllIIllIIllllIlll, Color llllllllllllllllllIIllIIllllIllI) {
        FontUtils.drawString(llllllllllllllllllIIllIIllllIlIl, llllllllllllllllllIIllIIlllllIlI, 3, llllllllllllllllllIIllIIlllllIIl, llllllllllllllllllIIllIIlllllIII, llllllllllllllllllIIllIIllllIlll, llllllllllllllllllIIllIIllllIllI);
    }

    private static int drawJustifiedSpaceSeparatedSubstrings(Font llllllllllllllllllIIllIIlIllIIll, String llllllllllllllllllIIllIIlIllIIlI, int llllllllllllllllllIIllIIlIlllIIl, int llllllllllllllllllIIllIIlIlllIII, int llllllllllllllllllIIllIIlIllIlll) {
        int llllllllllllllllllIIllIIlIllIllI = 0;
        int llllllllllllllllllIIllIIlIllIlIl = 0;
        int llllllllllllllllllIIllIIlIllIlII = llllllllllllllllllIIllIIlIlllIIl;
        while (llllllllllllllllllIIllIIlIllIllI < llllllllllllllllllIIllIIlIllIIlI.length()) {
            llllllllllllllllllIIllIIlIllIlIl = llllllllllllllllllIIllIIlIllIIlI.indexOf(32, llllllllllllllllllIIllIIlIllIllI);
            if (llllllllllllllllllIIllIIlIllIlIl == -1) {
                llllllllllllllllllIIllIIlIllIlIl = llllllllllllllllllIIllIIlIllIIlI.length();
            }
            String llllllllllllllllllIIllIIlIllllII = llllllllllllllllllIIllIIlIllIIlI.substring(llllllllllllllllllIIllIIlIllIllI, llllllllllllllllllIIllIIlIllIlIl);
            llllllllllllllllllIIllIIlIllIIll.drawString(llllllllllllllllllIIllIIlIllIlII, llllllllllllllllllIIllIIlIlllIII, llllllllllllllllllIIllIIlIllllII);
            llllllllllllllllllIIllIIlIllIlII += llllllllllllllllllIIllIIlIllIIll.getWidth(llllllllllllllllllIIllIIlIllllII) + llllllllllllllllllIIllIIlIllIlll;
            llllllllllllllllllIIllIIlIllIllI = llllllllllllllllllIIllIIlIllIlIl + 1;
        }
        return llllllllllllllllllIIllIIlIllIlII;
    }

    public static void drawLeft(Font llllllllllllllllllIIllIlIIllIlIl, String llllllllllllllllllIIllIlIIlllIII, int llllllllllllllllllIIllIlIIllIIll, int llllllllllllllllllIIllIlIIllIllI) {
        FontUtils.drawString(llllllllllllllllllIIllIlIIllIlIl, llllllllllllllllllIIllIlIIlllIII, 1, llllllllllllllllllIIllIlIIllIIll, llllllllllllllllllIIllIlIIllIllI, 0, Color.white);
    }

    public static void drawRight(Font llllllllllllllllllIIllIlIIIIlIll, String llllllllllllllllllIIllIlIIIIlIlI, int llllllllllllllllllIIllIlIIIIlIIl, int llllllllllllllllllIIllIlIIIIlIII, int llllllllllllllllllIIllIlIIIIIlll) {
        FontUtils.drawString(llllllllllllllllllIIllIlIIIIlIll, llllllllllllllllllIIllIlIIIIlIlI, 3, llllllllllllllllllIIllIlIIIIlIIl, llllllllllllllllllIIllIlIIIIlIII, llllllllllllllllllIIllIlIIIIIlll, Color.white);
    }

    public static final int drawString(Font llllllllllllllllllIIllIIllIlllIl, String llllllllllllllllllIIllIIlllIIlII, int llllllllllllllllllIIllIIlllIIIll, int llllllllllllllllllIIllIIlllIIIlI, int llllllllllllllllllIIllIIllIllIIl, int llllllllllllllllllIIllIIlllIIIII, Color llllllllllllllllllIIllIIllIlllll) {
        int llllllllllllllllllIIllIIllIllllI = 0;
        if (llllllllllllllllllIIllIIlllIIIll == 1) {
            llllllllllllllllllIIllIIllIlllIl.drawString(llllllllllllllllllIIllIIlllIIIlI, llllllllllllllllllIIllIIllIllIIl, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIllIlllll);
        } else if (llllllllllllllllllIIllIIlllIIIll == 2) {
            llllllllllllllllllIIllIIllIlllIl.drawString(llllllllllllllllllIIllIIlllIIIlI + llllllllllllllllllIIllIIlllIIIII / 2 - llllllllllllllllllIIllIIllIlllIl.getWidth(llllllllllllllllllIIllIIlllIIlII) / 2, llllllllllllllllllIIllIIllIllIIl, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIllIlllll);
        } else if (llllllllllllllllllIIllIIlllIIIll == 3) {
            llllllllllllllllllIIllIIllIlllIl.drawString(llllllllllllllllllIIllIIlllIIIlI + llllllllllllllllllIIllIIlllIIIII - llllllllllllllllllIIllIIllIlllIl.getWidth(llllllllllllllllllIIllIIlllIIlII), llllllllllllllllllIIllIIllIllIIl, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIllIlllll);
        } else if (llllllllllllllllllIIllIIlllIIIll == 4) {
            int llllllllllllllllllIIllIIlllIIllI = llllllllllllllllllIIllIIlllIIIII - llllllllllllllllllIIllIIllIlllIl.getWidth(llllllllllllllllllIIllIIlllIIlII);
            if (llllllllllllllllllIIllIIlllIIllI <= 0) {
                llllllllllllllllllIIllIIllIlllIl.drawString(llllllllllllllllllIIllIIlllIIIlI, llllllllllllllllllIIllIIllIllIIl, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIllIlllll);
            }
            return FontUtils.drawJustifiedSpaceSeparatedSubstrings(llllllllllllllllllIIllIIllIlllIl, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIlllIIIlI, llllllllllllllllllIIllIIllIllIIl, FontUtils.calculateWidthOfJustifiedSpaceInPixels(llllllllllllllllllIIllIIllIlllIl, llllllllllllllllllIIllIIlllIIlII, llllllllllllllllllIIllIIlllIIllI));
        }
        return llllllllllllllllllIIllIIllIllllI;
    }

    public static void drawCenter(Font llllllllllllllllllIIllIlIIIlllII, String llllllllllllllllllIIllIlIIIlIlIl, int llllllllllllllllllIIllIlIIIllIlI, int llllllllllllllllllIIllIlIIIllIIl, int llllllllllllllllllIIllIlIIIlIIlI, Color llllllllllllllllllIIllIlIIIlIIIl) {
        FontUtils.drawString(llllllllllllllllllIIllIlIIIlllII, llllllllllllllllllIIllIlIIIlIlIl, 2, llllllllllllllllllIIllIlIIIllIlI, llllllllllllllllllIIllIlIIIllIIl, llllllllllllllllllIIllIlIIIlIIlI, llllllllllllllllllIIllIlIIIlIIIl);
    }

    public static void drawCenter(Font llllllllllllllllllIIllIlIIlIIlll, String llllllllllllllllllIIllIlIIlIlIll, int llllllllllllllllllIIllIlIIlIlIlI, int llllllllllllllllllIIllIlIIlIlIIl, int llllllllllllllllllIIllIlIIlIIIll) {
        FontUtils.drawString(llllllllllllllllllIIllIlIIlIIlll, llllllllllllllllllIIllIlIIlIlIll, 2, llllllllllllllllllIIllIlIIlIlIlI, llllllllllllllllllIIllIlIIlIlIIl, llllllllllllllllllIIllIlIIlIIIll, Color.white);
    }

    public class Alignment {
        public static final /* synthetic */ int LEFT;
        public static final /* synthetic */ int CENTER;
        public static final /* synthetic */ int JUSTIFY;
        public static final /* synthetic */ int RIGHT;

        public Alignment() {
            Alignment llllllllllllllllIIlllllIlllIIllI;
        }

        static {
            LEFT = 1;
            RIGHT = 3;
            JUSTIFY = 4;
            CENTER = 2;
        }
    }
}

