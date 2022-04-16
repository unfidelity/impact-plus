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
public class PacketSendEvent
extends Event {
    private final /* synthetic */ Packet packet;

    public final Packet getPacket() {
        PacketSendEvent llllIIllllllIll;
        return llllIIllllllIll.packet;
    }

    public PacketSendEvent(Packet llllIIlllllllll) {
        PacketSendEvent llllIIllllllllI;
        llllIIllllllllI.packet = llllIIlllllllll;
    }

    public static class Post
    extends PacketSendEvent {
        public Post(Packet lllllllllllllllllIIIIllIIIIIIlll) {
            super(lllllllllllllllllIIIIllIIIIIIlll);
            Post lllllllllllllllllIIIIllIIIIIlIII;
        }
    }
}

