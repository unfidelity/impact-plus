/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.misc;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class AntiDisconnect
extends Module {
    public /* synthetic */ Setting.b Only2b2t;
    public /* synthetic */ Setting.i Count;

    public AntiDisconnect() {
        super("AntiDisconnect", Module.Category.MISC, "AntiDisconnect");
        AntiDisconnect lllllllllllllllIlllIlIlllIIlIIII;
    }

    @Override
    public void setup() {
        AntiDisconnect lllllllllllllllIlllIlIlllIIIlllI;
        lllllllllllllllIlllIlIlllIIIlllI.Count = lllllllllllllllIlllIlIlllIIIlllI.registerI("DisconnectCount ", 5, 2, 10);
        lllllllllllllllIlllIlIlllIIIlllI.Only2b2t = lllllllllllllllIlllIlIlllIIIlllI.registerB("Only2b2t", false);
    }
}

