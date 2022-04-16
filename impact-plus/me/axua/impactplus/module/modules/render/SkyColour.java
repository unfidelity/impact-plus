/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.render;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class SkyColour
extends Module {
    public /* synthetic */ Setting.d netherblue;
    public /* synthetic */ Setting.d owblue;
    public /* synthetic */ Setting.d owgreen;
    public /* synthetic */ Setting.d owred;
    public /* synthetic */ Setting.d nethergreen;
    public /* synthetic */ Setting.d netherred;

    @Override
    public void setup() {
        SkyColour llllllllllllllllIIlllllllIIlIIlI;
        llllllllllllllllIIlllllllIIlIIlI.owred = llllllllllllllllIIlllllllIIlIIlI.registerD("OWRed", 0.0, 0.0, 1.0);
        llllllllllllllllIIlllllllIIlIIlI.owgreen = llllllllllllllllIIlllllllIIlIIlI.registerD("OWGreen", 0.0, 0.0, 1.0);
        llllllllllllllllIIlllllllIIlIIlI.owblue = llllllllllllllllIIlllllllIIlIIlI.registerD("OWBlue", 0.0, 0.0, 1.0);
        llllllllllllllllIIlllllllIIlIIlI.netherred = llllllllllllllllIIlllllllIIlIIlI.registerD("NetherRed", 0.0, 0.0, 1.0);
        llllllllllllllllIIlllllllIIlIIlI.nethergreen = llllllllllllllllIIlllllllIIlIIlI.registerD("NetherGreen", 0.0, 0.0, 1.0);
        llllllllllllllllIIlllllllIIlIIlI.netherblue = llllllllllllllllIIlllllllIIlIIlI.registerD("NetherBlue", 0.0, 0.0, 1.0);
    }

    public SkyColour() {
        super("SkyColour", Module.Category.RENDER);
        SkyColour llllllllllllllllIIlllllllIIlIlIl;
    }
}

