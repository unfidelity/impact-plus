/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Totems
extends Module {
    public /* synthetic */ Setting.mode Mode;
    public static /* synthetic */ Totems INSTANCE;

    @Override
    public void setup() {
        Totems llllllllllllllllIIllIlIIlllIlIll;
        ArrayList<String> llllllllllllllllIIllIlIIlllIlllI = new ArrayList<String>();
        llllllllllllllllIIllIlIIlllIlllI.add("Text");
        llllllllllllllllIIllIlIIlllIlllI.add("Item");
        llllllllllllllllIIllIlIIlllIlIll.Mode = llllllllllllllllIIllIlIIlllIlIll.registerMode("Mode", llllllllllllllllIIllIlIIlllIlllI, "Text");
    }

    public Totems() {
        super("Totems", Module.Category.HUD);
        Totems llllllllllllllllIIllIlIIllllllIl;
        INSTANCE = llllllllllllllllIIllIlIIllllllIl;
        llllllllllllllllIIllIlIIllllllIl.setDrawn(false);
    }
}

