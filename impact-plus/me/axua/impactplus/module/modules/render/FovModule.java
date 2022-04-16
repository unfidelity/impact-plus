/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.render;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class FovModule
extends Module {
    /* synthetic */ Setting.i fov;

    public FovModule() {
        super("FOV", Module.Category.RENDER, "Changes your fov");
        FovModule llllllllllllllllIIIIlllIIllIIlIl;
        llllllllllllllllIIIIlllIIllIIlIl.fov = llllllllllllllllIIIIlllIIllIIlIl.registerI("Value", 140, 0, 180);
        llllllllllllllllIIIIlllIIllIIlIl.setDrawn(false);
    }

    @Override
    public void onUpdate() {
        FovModule llllllllllllllllIIIIlllIIllIIIIl;
        FovModule.mc.gameSettings.fovSetting = llllllllllllllllIIIIlllIIllIIIIl.fov.getValue();
    }
}

