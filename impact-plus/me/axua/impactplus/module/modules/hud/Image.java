/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class Image
extends Module {
    public /* synthetic */ Setting.i height;
    public static /* synthetic */ Image INSTANCE;
    public /* synthetic */ Setting.i width;
    public /* synthetic */ Setting.mode Image;

    @Override
    public void setup() {
        Image lIllllIIIlIlIIl;
        ArrayList<String> lIllllIIIlIlIlI = new ArrayList<String>();
        lIllllIIIlIlIlI.add("Haikewl");
        lIllllIIIlIlIlI.add("Brownman");
        lIllllIIIlIlIlI.add("Fortnite");
        lIllllIIIlIlIlI.add("Clown");
        lIllllIIIlIlIlI.add("Bed");
        lIllllIIIlIlIIl.Image = lIllllIIIlIlIIl.registerMode("Image", lIllllIIIlIlIlI, "Brownman");
        lIllllIIIlIlIIl.width = lIllllIIIlIlIIl.registerI("Width", 30, 1, 500);
        lIllllIIIlIlIIl.height = lIllllIIIlIlIIl.registerI("Height", 30, 1, 500);
    }

    public Image() {
        super("Image", Module.Category.HUD);
        Image lIllllIIIllIlIl;
        INSTANCE = lIllllIIIllIlIl;
        lIllllIIIllIlIl.setDrawn(false);
    }
}

