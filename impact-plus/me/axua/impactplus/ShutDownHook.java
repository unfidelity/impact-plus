/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus;

import me.axua.impactplus.ImpactPlus;

public class ShutDownHook
extends Thread {
    @Override
    public void run() {
        ShutDownHook.saveConfig();
    }

    public ShutDownHook() {
        ShutDownHook lIllllIlllIlIII;
    }

    public static void saveConfig() {
        ImpactPlus.getInstance().configUtils.saveMods();
        ImpactPlus.getInstance().configUtils.saveSettingsList();
        ImpactPlus.getInstance().configUtils.saveBinds();
        ImpactPlus.getInstance().configUtils.saveDrawn();
        ImpactPlus.getInstance().configUtils.saveFriends();
        ImpactPlus.getInstance().configUtils.savePrefix();
        ImpactPlus.getInstance().configUtils.saveRainbow();
        ImpactPlus.getInstance().configUtils.saveHud();
        ImpactPlus.getInstance().configUtils.saveAutoEz();
    }
}

