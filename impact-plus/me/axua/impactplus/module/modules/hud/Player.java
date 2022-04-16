/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Player
extends Module {
    public /* synthetic */ Setting.i Size;
    public static /* synthetic */ Player INSTANCE;

    public Player() {
        super("Player", Module.Category.HUD);
        Player llllllllllllllllIlIlIlIlIIlIlIlI;
        INSTANCE = llllllllllllllllIlIlIlIlIIlIlIlI;
        llllllllllllllllIlIlIlIlIIlIlIlI.setDrawn(false);
    }

    @Override
    public void setup() {
        Player llllllllllllllllIlIlIlIlIIlIIlll;
        llllllllllllllllIlIlIlIlIIlIIlll.Size = llllllllllllllllIlIlIlIlIIlIIlll.registerI("Size", 30, 1, 500);
    }
}

