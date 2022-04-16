/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class BrownmanClient
extends Module {
    public static /* synthetic */ BrownmanClient INSTANCE;
    public /* synthetic */ Setting.mode Mode;

    @Override
    public void setup() {
        BrownmanClient llIIIIIIlIIIl;
        ArrayList<String> llIIIIIIlIIII = new ArrayList<String>();
        llIIIIIIlIIII.add("2019");
        llIIIIIIlIIII.add("2020");
        llIIIIIIlIIIl.Mode = llIIIIIIlIIIl.registerMode("Version", llIIIIIIlIIII, "2020");
    }

    public BrownmanClient() {
        super("BrownmanClient", Module.Category.HUD);
        BrownmanClient llIIIIIIlIllI;
        INSTANCE = llIIIIIIlIllI;
        llIIIIIIlIllI.setDrawn(false);
    }
}

