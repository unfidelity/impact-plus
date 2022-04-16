/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.player;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventCanCollideCheck;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class LiquidInteract
extends Module {
    @EventHandler
    private /* synthetic */ Listener<EventCanCollideCheck> CanCollide;

    @Override
    public void onDisable() {
        LiquidInteract lllllllllllllllIllIlllIllllllIll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllIllIlllIllllllIll);
    }

    public LiquidInteract() {
        super("LiquidInteract", Module.Category.PLAYER, "LiquidInteract");
        LiquidInteract lllllllllllllllIllIllllIIIIIIIIl;
        lllllllllllllllIllIllllIIIIIIIIl.CanCollide = new Listener<EventCanCollideCheck>(lllllllllllllllIllIlllIlllllIlIl -> lllllllllllllllIllIlllIlllllIlIl.cancel(), new Predicate[0]);
    }

    @Override
    public void onEnable() {
        LiquidInteract lllllllllllllllIllIlllIlllllllIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllIllIlllIlllllllIl);
    }
}

