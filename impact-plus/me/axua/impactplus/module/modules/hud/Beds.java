/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Beds
extends Module {
    public static /* synthetic */ Beds INSTANCE;
    public /* synthetic */ Setting.mode Mode;

    @Override
    public void setup() {
        Beds llIIllIllllIIII;
        ArrayList<String> llIIllIllllIIIl = new ArrayList<String>();
        llIIllIllllIIIl.add("Text");
        llIIllIllllIIIl.add("Item");
        llIIllIllllIIII.Mode = llIIllIllllIIII.registerMode("Mode", llIIllIllllIIIl, "Text");
    }

    public Beds() {
        super("Beds", Module.Category.HUD);
        Beds llIIllIllllIllI;
        INSTANCE = llIIllIllllIllI;
        llIIllIllllIllI.setDrawn(false);
    }
}

