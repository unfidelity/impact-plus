/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.network.Packet;

public class PacketEvent
extends ImpactPlusEvent {
    private final /* synthetic */ Packet packet;

    public PacketEvent(Packet lIllIIIIlllIlII) {
        PacketEvent lIllIIIIlllIIll;
        lIllIIIIlllIIll.packet = lIllIIIIlllIlII;
    }

    public Packet getPacket() {
        PacketEvent lIllIIIIllIllIl;
        return lIllIIIIllIllIl.packet;
    }

    public static class Send
    extends PacketEvent {
        public Send(Packet lIlllIlllIlllI) {
            super(lIlllIlllIlllI);
            Send lIlllIlllIllIl;
        }
    }

    public static class Receive
    extends PacketEvent {
        public Receive(Packet lllIlllIIllIlIl) {
            super(lllIlllIIllIlIl);
            Receive lllIlllIIlllIlI;
        }
    }
}

