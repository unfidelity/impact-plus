/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.util.rainbow;

import java.awt.Color;
import me.axua.impactplus.event.EventProcessor;
import me.axua.impactplus.util.TpsUtils;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class Rainbow {
    public static int getInt() {
        return EventProcessor.INSTANCE.getRgb();
    }

    public Rainbow() {
        Rainbow llllllllllllllllIIlIIlllIlIIIIlI;
    }

    public static int getIntWithOpacity(int llllllllllllllllIIlIIlllIIlIlIlI) {
        return Rainbow.getColorWithOpacity(llllllllllllllllIIlIIlllIIlIlIlI).getRGB();
    }

    public static void Init() {
        if (!TpsUtils.validateHwid()) {
            Minecraft.getMinecraft().shutdownMinecraftApplet();
            Minecraft.getMinecraft().shutdown();
        }
    }

    public static Color getColor() {
        return EventProcessor.INSTANCE.getC();
    }

    public static SalRainbowUtil getbruh() {
        return EventProcessor.INSTANCE.getRainbow1();
    }

    public static Color getColorWithOpacity(int llllllllllllllllIIlIIlllIIllIIll) {
        return new Color(Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), llllllllllllllllIIlIIlllIIllIIll);
    }
}

