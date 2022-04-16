/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;

public class SettingManager {
    private /* synthetic */ List<Setting> settings;

    public void addSetting(Setting llIIIllIIlIIl) {
        SettingManager llIIIllIIllII;
        llIIIllIIllII.settings.add(llIIIllIIlIIl);
    }

    public Setting getSettingByNameAndMod(String llIIIllIIIIIl, Module llIIIllIIIIll) {
        SettingManager llIIIllIIIlIl;
        return llIIIllIIIlIl.settings.stream().filter(llIIIlIlIlIII -> llIIIlIlIlIII.getParent().equals(llIIIllIIIIll)).filter(llIIIlIllIIII -> llIIIlIllIIII.getName().equalsIgnoreCase(llIIIllIIIIIl)).findFirst().orElse(null);
    }

    public SettingManager() {
        SettingManager llIIIllIlIIll;
        llIIIllIlIIll.settings = new ArrayList<Setting>();
    }

    public List<Setting> getSettings() {
        SettingManager llIIIllIlIIII;
        return llIIIllIlIIII.settings;
    }

    public List<Setting> getSettingsForMod(Module llIIIlIlllIlI) {
        SettingManager llIIIlIlllIll;
        return llIIIlIlllIll.settings.stream().filter(llIIIlIllIlII -> llIIIlIllIlII.getParent().equals(llIIIlIlllIlI)).collect(Collectors.toList());
    }
}

