/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings$Options
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.client.settings.GameSettings;

public class SetGameOptionEvent
extends ImpactPlusEvent {
    private final /* synthetic */ int value;
    private final /* synthetic */ GameSettings.Options settingOption;

    public int getValue() {
        SetGameOptionEvent lllIIlIIIIllIl;
        return lllIIlIIIIllIl.value;
    }

    public GameSettings.Options getSettingOption() {
        SetGameOptionEvent lllIIlIIIlIIII;
        return lllIIlIIIlIIII.settingOption;
    }

    public SetGameOptionEvent(GameSettings.Options lllIIlIIIlIlll, int lllIIlIIIlIIll) {
        SetGameOptionEvent lllIIlIIIlIlIl;
        lllIIlIIIlIlIl.settingOption = lllIIlIIIlIlll;
        lllIIlIIIlIlIl.value = lllIIlIIIlIIll;
    }
}

