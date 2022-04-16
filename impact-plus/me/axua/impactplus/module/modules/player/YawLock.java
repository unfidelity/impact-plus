/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.player;

import me.axua.impactplus.module.Module;

public class YawLock
extends Module {
    /* synthetic */ float yaw;

    public YawLock() {
        super("YawLock", Module.Category.PLAYER, "Lock Yaw");
        YawLock llllllllllllllllIlllIIlIlIllllIl;
        llllllllllllllllIlllIIlIlIllllIl.yaw = 0.0f;
    }

    @Override
    public void onEnable() {
        llllllllllllllllIlllIIlIlIlllIlI.yaw = YawLock.mc.thePlayer.rotationYaw;
    }

    @Override
    public void onLivingEvent() {
        YawLock llllllllllllllllIlllIIlIlIllIlll;
        YawLock.mc.thePlayer.rotationYaw = llllllllllllllllIlllIIlIlIllIlll.yaw;
    }
}

