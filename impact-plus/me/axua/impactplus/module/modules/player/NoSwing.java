/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumHand
 */
package me.axua.impactplus.module.modules.player;

import java.util.ArrayList;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventPlayerSwingArm;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;

public class NoSwing
extends Module {
    @EventHandler
    private /* synthetic */ Listener<EventPlayerSwingArm> PlayerSwingArm;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> sendListener;
    /* synthetic */ Setting.mode Mode;

    public NoSwing() {
        super("NoSwing", Module.Category.PLAYER, "NoSwing");
        NoSwing lllllllllllllllIllIlIlllllIllIIl;
        lllllllllllllllIllIlIlllllIllIIl.sendListener = new Listener<PacketEvent.Send>(lllllllllllllllIllIlIlllllIIIIIl -> {
            NoSwing lllllllllllllllIllIlIlllllIIIIlI;
            if (lllllllllllllllIllIlIlllllIIIIIl.getPacket() instanceof CPacketAnimation && lllllllllllllllIllIlIlllllIIIIlI.Mode.getValue().equalsIgnoreCase("Packet")) {
                lllllllllllllllIllIlIlllllIIIIIl.cancel();
            }
        }, new Predicate[0]);
        lllllllllllllllIllIlIlllllIllIIl.PlayerSwingArm = new Listener<EventPlayerSwingArm>(lllllllllllllllIllIlIlllllIIIlll -> {
            NoSwing lllllllllllllllIllIlIlllllIIlIII;
            if (lllllllllllllllIllIlIlllllIIlIII.Mode.getValue().equalsIgnoreCase("Full")) {
                lllllllllllllllIllIlIlllllIIIlll.cancel();
            } else if (lllllllllllllllIllIlIlllllIIlIII.Mode.getValue().equalsIgnoreCase("Offhand")) {
                lllllllllllllllIllIlIlllllIIIlll.Hand = EnumHand.OFF_HAND;
            }
        }, new Predicate[0]);
    }

    @Override
    public void setup() {
        NoSwing lllllllllllllllIllIlIlllllIlIllI;
        ArrayList<String> lllllllllllllllIllIlIlllllIlIlIl = new ArrayList<String>();
        lllllllllllllllIllIlIlllllIlIlIl.add("Full");
        lllllllllllllllIllIlIlllllIlIlIl.add("Packet");
        lllllllllllllllIllIlIlllllIlIlIl.add("Offhand");
        lllllllllllllllIllIlIlllllIlIllI.Mode = lllllllllllllllIllIlIlllllIlIllI.registerMode("Mode", lllllllllllllllIllIlIlllllIlIlIl, "Packet");
    }

    @Override
    public void onEnable() {
        NoSwing lllllllllllllllIllIlIlllllIlIIIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllIllIlIlllllIlIIIl);
    }

    @Override
    public void onDisable() {
        NoSwing lllllllllllllllIllIlIlllllIIllIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllIllIlIlllllIIllIl);
    }
}

