/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Welcome
extends Module {
    public static /* synthetic */ Welcome INSTANCE;
    public /* synthetic */ Setting.mode Mode;

    @Override
    public void setup() {
        Welcome llllllllllllllllIIlIlIlIlIIIlIIl;
        ArrayList<String> llllllllllllllllIIlIlIlIlIIIlIlI = new ArrayList<String>();
        llllllllllllllllIIlIlIlIlIIIlIlI.add("Welcome1");
        llllllllllllllllIIlIlIlIlIIIlIlI.add("Welcome2");
        llllllllllllllllIIlIlIlIlIIIlIlI.add("Hello1");
        llllllllllllllllIIlIlIlIlIIIlIlI.add("Hello2");
        llllllllllllllllIIlIlIlIlIIIlIIl.Mode = llllllllllllllllIIlIlIlIlIIIlIIl.registerMode("Mode", llllllllllllllllIIlIlIlIlIIIlIlI, "Welcome1");
    }

    public Welcome() {
        super("Welcome", Module.Category.HUD);
        Welcome llllllllllllllllIIlIlIlIlIIIlllI;
        INSTANCE = llllllllllllllllIIlIlIlIlIIIlllI;
        llllllllllllllllIIlIlIlIlIIIlllI.setDrawn(false);
    }
}

