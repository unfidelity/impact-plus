/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Closest
extends Module {
    public /* synthetic */ Setting.b ExcludeFriends;
    public static /* synthetic */ Closest INSTANCE;

    @Override
    public void setup() {
        Closest lIIlIIllIl;
        lIIlIIllIl.ExcludeFriends = lIIlIIllIl.registerB("ExcludeFriends", false);
    }

    public Closest() {
        super("Closest", Module.Category.HUD);
        Closest lIIlIlIIll;
        INSTANCE = lIIlIlIIll;
        lIIlIlIIll.setDrawn(false);
    }
}

