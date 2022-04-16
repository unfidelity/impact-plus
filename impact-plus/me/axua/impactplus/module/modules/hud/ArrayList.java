/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class ArrayList
extends Module {
    public static /* synthetic */ ArrayList INSTANCE;
    public /* synthetic */ Setting.b rects;
    public /* synthetic */ Setting.b sortUp;
    public /* synthetic */ Setting.b right;

    @Override
    public void setup() {
        ArrayList llllllllllllllllIIIlllIllIlllIII;
        llllllllllllllllIIIlllIllIlllIII.sortUp = llllllllllllllllIIIlllIllIlllIII.registerB("SortUp", false);
        llllllllllllllllIIIlllIllIlllIII.right = llllllllllllllllIIIlllIllIlllIII.registerB("RightAlign", false);
        llllllllllllllllIIIlllIllIlllIII.rects = llllllllllllllllIIIlllIllIlllIII.registerB("Rects", true);
    }

    public ArrayList() {
        super("ArrayList", Module.Category.HUD);
        ArrayList llllllllllllllllIIIlllIlllIIIIII;
        INSTANCE = llllllllllllllllIIIlllIlllIIIIII;
        llllllllllllllllIIIlllIlllIIIIII.setDrawn(false);
    }
}

