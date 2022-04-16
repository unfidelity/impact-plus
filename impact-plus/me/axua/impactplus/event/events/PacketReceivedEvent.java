/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraftforge.fml.common.eventhandler.Cancelable
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.axua.impactplus.event.events;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class PacketReceivedEvent
extends Event {
    private final /* synthetic */ Packet packet;

    public PacketReceivedEvent(Packet llllllllllllllllIIlllllIIllIIIIl) {
        PacketReceivedEvent llllllllllllllllIIlllllIIllIIlII;
        llllllllllllllllIIlllllIIllIIlII.packet = llllllllllllllllIIlllllIIllIIIIl;
    }

    public final Packet getPacket() {
        PacketReceivedEvent llllllllllllllllIIlllllIIlIllllI;
        return llllllllllllllllIIlllllIIlIllllI.packet;
    }

    public static class Post
    extends PacketReceivedEvent {
        public Post(Packet llllllllllllllllIIIlIllllIIIIlII) {
            super(llllllllllllllllIIIlIllllIIIIlII);
            Post llllllllllllllllIIIlIllllIIIIIll;
        }
    }
}

