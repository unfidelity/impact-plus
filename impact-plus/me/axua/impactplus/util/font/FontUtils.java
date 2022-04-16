/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.util.font;

import me.axua.impactplus.ImpactPlus;
import net.minecraft.client.Minecraft;

public class FontUtils {
    private static final /* synthetic */ Minecraft mc;

    static {
        mc = Minecraft.getMinecraft();
    }

    public static int getStringWidth(boolean lIIlllIllIIIIlI, String lIIlllIlIllllll) {
        if (lIIlllIllIIIIlI) {
            return (int)ImpactPlus.CustomFont.getStringWidth(lIIlllIlIllllll);
        }
        return FontUtils.mc.fontRendererObj.getStringWidth(lIIlllIlIllllll);
    }

    public static int getFontHeight(boolean lIIlllIlIlllIlI, String lIIlllIlIlllIll) {
        if (lIIlllIlIlllIlI) {
            return (int)ImpactPlus.CustomFont.getHeight(lIIlllIlIlllIll);
        }
        return FontUtils.mc.fontRendererObj.FONT_HEIGHT;
    }

    public FontUtils() {
        FontUtils lIIlllIllIlIlIl;
    }

    public static float drawStringWithShadow(boolean lIIlllIllIIlllI, String lIIlllIllIIlIII, int lIIlllIllIIIlll, int lIIlllIllIIlIll, int lIIlllIllIIIlIl) {
        if (lIIlllIllIIlllI) {
            return ImpactPlus.CustomFont.drawStringWithShadow(lIIlllIllIIlIII, lIIlllIllIIIlll, lIIlllIllIIlIll, lIIlllIllIIIlIl);
        }
        return FontUtils.mc.fontRendererObj.drawStringWithShadow(lIIlllIllIIlIII, (float)lIIlllIllIIIlll, (float)lIIlllIllIIlIll, lIIlllIllIIIlIl);
    }
}

