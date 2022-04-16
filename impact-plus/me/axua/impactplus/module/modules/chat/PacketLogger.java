/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 */
package me.axua.impactplus.module.modules.chat;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;

public class PacketLogger
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> SendListener;

    public PacketLogger() {
        super("PacketLogger", Module.Category.CHAT, "PacketLogger");
        PacketLogger llllllllllllllllIllIIIlIIIIIIlIl;
        llllllllllllllllIllIIIlIIIIIIlIl.SendListener = new Listener<PacketEvent.Send>(llllllllllllllllIllIIIIllllllIlI -> {
            if (PacketLogger.mc.thePlayer == null) {
                return;
            }
            Command.sendClientMessage(llllllllllllllllIllIIIIllllllIlI.getPacket().getClass().getSimpleName());
            if (llllllllllllllllIllIIIIllllllIlI.getPacket() instanceof CPacketPlayerTryUseItem) {
                CPacketPlayerTryUseItem llllllllllllllllIllIIIIllllllIll = (CPacketPlayerTryUseItem)llllllllllllllllIllIIIIllllllIlI.getPacket();
                Command.sendClientMessage(llllllllllllllllIllIIIIllllllIll.toString());
            }
        }, new Predicate[0]);
    }

    @Override
    public void onEnable() {
        PacketLogger llllllllllllllllIllIIIlIIIIIIIlI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIllIIIlIIIIIIIlI);
    }

    @Override
    public void onDisable() {
        PacketLogger llllllllllllllllIllIIIIllllllllI;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIllIIIIllllllllI);
    }
}

