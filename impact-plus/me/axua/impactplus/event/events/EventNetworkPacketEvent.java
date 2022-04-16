/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.network.Packet;

public class EventNetworkPacketEvent
extends ImpactPlusEvent {
    public /* synthetic */ Packet m_Packet;

    public EventNetworkPacketEvent(Packet lIlllIlIIIIIllI) {
        EventNetworkPacketEvent lIlllIlIIIIlIIl;
        lIlllIlIIIIlIIl.m_Packet = lIlllIlIIIIIllI;
    }

    public Packet getPacket() {
        EventNetworkPacketEvent lIlllIIlllllllI;
        return lIlllIIlllllllI.m_Packet;
    }

    public Packet GetPacket() {
        EventNetworkPacketEvent lIlllIlIIIIIlII;
        return lIlllIlIIIIIlII.m_Packet;
    }
}

