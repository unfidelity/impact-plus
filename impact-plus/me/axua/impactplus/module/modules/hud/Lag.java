/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.hud;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Lag
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> recvListener;
    public static /* synthetic */ Lag INSTANCE;
    private /* synthetic */ long serverLastUpdated;

    @Override
    public void onEnable() {
        Lag llIIlllIlIllIlI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llIIlllIlIllIlI);
    }

    public long bruhserver() {
        Lag llIIlllIlIlllII;
        return llIIlllIlIlllII.serverLastUpdated;
    }

    public Lag() {
        super("Lag", Module.Category.HUD);
        Lag llIIlllIlIlllll;
        llIIlllIlIlllll.recvListener = new Listener<PacketEvent.Receive>(llIIlllIlIlIIll -> {
            llIIlllIlIlIlII.serverLastUpdated = System.currentTimeMillis();
        }, new Predicate[0]);
        INSTANCE = llIIlllIlIlllll;
        llIIlllIlIlllll.setDrawn(false);
    }

    @Override
    public void onDisable() {
        Lag llIIlllIlIlIlll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llIIlllIlIlIlll);
    }
}

