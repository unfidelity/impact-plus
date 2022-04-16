/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import me.axua.impactplus.module.Module;

public class Ping
extends Module {
    public static /* synthetic */ Ping INSTANCE;

    public int getPing() {
        int lllllllllllllllIlllIIlIIIIllIIlI = -1;
        lllllllllllllllIlllIIlIIIIllIIlI = Ping.mc.thePlayer == null || mc.getNetHandler() == null || mc.getNetHandler().getPlayerInfo(Ping.mc.thePlayer.getName()) == null ? -1 : mc.getNetHandler().getPlayerInfo(Ping.mc.thePlayer.getName()).getResponseTime();
        return lllllllllllllllIlllIIlIIIIllIIlI;
    }

    public Ping() {
        super("Ping", Module.Category.HUD);
        Ping lllllllllllllllIlllIIlIIIIllIlIl;
        INSTANCE = lllllllllllllllIlllIIlIIIIllIlIl;
        lllllllllllllllIlllIIlIIIIllIlIl.setDrawn(false);
    }
}

