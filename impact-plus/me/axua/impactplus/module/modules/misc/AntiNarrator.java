/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.GameSettings$Options
 */
package me.axua.impactplus.module.modules.misc;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.SetGameOptionEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.settings.GameSettings;

public class AntiNarrator
extends Module {
    @EventHandler
    private /* synthetic */ Listener<SetGameOptionEvent> onSetGameOption;

    public AntiNarrator() {
        super("AntiNarrator", Module.Category.MISC, "AntiNarrator");
        AntiNarrator lllllllllllllllIllIlllIIIIlIllII;
        lllllllllllllllIllIlllIIIIlIllII.onSetGameOption = new Listener<SetGameOptionEvent>(lllllllllllllllIllIlllIIIIlIIIll -> {
            if (lllllllllllllllIllIlllIIIIlIIIll.getSettingOption() == GameSettings.Options.NARRATOR) {
                lllllllllllllllIllIlllIIIIlIIIll.cancel();
            }
        }, new Predicate[0]);
    }

    @Override
    public void onDisable() {
        AntiNarrator lllllllllllllllIllIlllIIIIlIIllI;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllIllIlllIIIIlIIllI);
    }

    @Override
    public void onEnable() {
        AntiNarrator lllllllllllllllIllIlllIIIIlIlIIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllIllIlllIIIIlIlIIl);
    }
}

