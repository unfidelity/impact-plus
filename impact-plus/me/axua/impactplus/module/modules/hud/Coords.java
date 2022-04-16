/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Coords
extends Module {
    public static /* synthetic */ Coords INSTANCE;
    public /* synthetic */ Setting.mode Mode;

    @Override
    public void setup() {
        Coords llllllllllllllllIlllIlIIIIlIlIll;
        ArrayList<String> llllllllllllllllIlllIlIIIIlIllII = new ArrayList<String>();
        llllllllllllllllIlllIlIIIIlIllII.add("Stacked");
        llllllllllllllllIlllIlIIIIlIllII.add("Single");
        llllllllllllllllIlllIlIIIIlIlIll.Mode = llllllllllllllllIlllIlIIIIlIlIll.registerMode("Mode", llllllllllllllllIlllIlIIIIlIllII, "Stacked");
    }

    public Coords() {
        super("Coords", Module.Category.HUD);
        Coords llllllllllllllllIlllIlIIIIllIIIl;
        INSTANCE = llllllllllllllllIlllIlIIIIllIIIl;
        llllllllllllllllIlllIlIIIIllIIIl.setDrawn(false);
    }
}

