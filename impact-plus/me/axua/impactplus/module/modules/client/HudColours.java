/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.client;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class HudColours
extends Module {
    public /* synthetic */ Setting.mode rainbowmode;
    public /* synthetic */ Setting.b rainbow;
    public /* synthetic */ Setting.mode color;
    public /* synthetic */ Setting.i red;
    public /* synthetic */ Setting.i blue;
    public /* synthetic */ Setting.i green;

    public HudColours() {
        super("HudColours", Module.Category.CLIENT);
        HudColours lIllIllIlIIIIII;
    }

    @Override
    public void onEnable() {
        HudColours lIllIllIIllIlII;
        lIllIllIIllIlII.disable();
    }

    @Override
    public void setup() {
        HudColours lIllIllIIlllIIl;
        ArrayList<String> lIllIllIIlllIll = new ArrayList<String>();
        lIllIllIIlllIll.add("Reset");
        lIllIllIIlllIll.add("White");
        lIllIllIIlllIll.add("Black");
        lIllIllIIlllIll.add("Gray");
        lIllIllIIlllIll.add("Dark_Gray");
        lIllIllIIlllIll.add("Aqua");
        lIllIllIIlllIll.add("Dark_Aqua");
        lIllIllIIlllIll.add("Blue");
        lIllIllIIlllIll.add("Dark_Blue");
        lIllIllIIlllIll.add("Green");
        lIllIllIIlllIll.add("Dark_Green");
        lIllIllIIlllIll.add("Light_Purple");
        lIllIllIIlllIll.add("Dark_Purple");
        lIllIllIIlllIll.add("Red");
        lIllIllIIlllIll.add("Dark_Red");
        lIllIllIIlllIll.add("Yellow");
        lIllIllIIlllIll.add("Gold");
        ArrayList<String> lIllIllIIlllIlI = new ArrayList<String>();
        lIllIllIIlllIlI.add("Bad");
        lIllIllIIlllIlI.add("Good");
        lIllIllIIlllIIl.rainbow = lIllIllIIlllIIl.registerB("Rainbow", true);
        lIllIllIIlllIIl.rainbowmode = lIllIllIIlllIIl.registerMode("RainbowMode", lIllIllIIlllIlI, "Good");
        lIllIllIIlllIIl.red = lIllIllIIlllIIl.registerI("Red", 85, 0, 255);
        lIllIllIIlllIIl.green = lIllIllIIlllIIl.registerI("Green", 0, 0, 255);
        lIllIllIIlllIIl.blue = lIllIllIIlllIIl.registerI("Blue", 255, 0, 255);
        lIllIllIIlllIIl.color = lIllIllIIlllIIl.registerMode("NumberColour", lIllIllIIlllIll, "White");
    }
}

