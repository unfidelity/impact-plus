/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.render;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class ArmorEnchantColour
extends Module {
    public /* synthetic */ Setting.d b;
    public /* synthetic */ Setting.d g;
    public /* synthetic */ Setting.d r;

    public ArmorEnchantColour() {
        super("ArmorEnchantColour", Module.Category.RENDER);
        ArmorEnchantColour llllllllllllllllIlIIlIIlIllllIlI;
    }

    @Override
    public void setup() {
        ArmorEnchantColour llllllllllllllllIlIIlIIlIlllIlll;
        llllllllllllllllIlIIlIIlIlllIlll.r = llllllllllllllllIlIIlIIlIlllIlll.registerD("Red", 0.0, 0.0, 1.0);
        llllllllllllllllIlIIlIIlIlllIlll.g = llllllllllllllllIlIIlIIlIlllIlll.registerD("Green", 0.0, 0.0, 1.0);
        llllllllllllllllIlIIlIIlIlllIlll.b = llllllllllllllllIlIIlIIlIlllIlll.registerD("Blue", 1.0, 0.0, 1.0);
    }
}

