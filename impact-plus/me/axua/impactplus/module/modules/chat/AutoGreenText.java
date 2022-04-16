/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
package me.axua.impactplus.module.modules.chat;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

public class AutoGreenText
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> listener;
    /* synthetic */ Setting.b space;

    @Override
    public void onEnable() {
        AutoGreenText lllllllllllllllIllIlllIlIIIllIll;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllIllIlllIlIIIllIll);
    }

    public AutoGreenText() {
        super("AutoGreenText", Module.Category.CHAT, "Cyri");
        AutoGreenText lllllllllllllllIllIlllIlIIlIIIIl;
        lllllllllllllllIllIlllIlIIlIIIIl.listener = new Listener<PacketEvent.Send>(lllllllllllllllIllIlllIlIIIIlIIl -> {
            if (lllllllllllllllIllIlllIlIIIIlIIl.getPacket() instanceof CPacketChatMessage) {
                AutoGreenText lllllllllllllllIllIlllIlIIIIlIlI;
                if (((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).getMessage().startsWith("/") || ((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).getMessage().startsWith(Command.getPrefix()) || ((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).getMessage().startsWith(".") || ((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).getMessage().startsWith("!") || ((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).getMessage().startsWith("#")) {
                    return;
                }
                String lllllllllllllllIllIlllIlIIIIllll = ((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).getMessage();
                String lllllllllllllllIllIlllIlIIIIlllI = "";
                String lllllllllllllllIllIlllIlIIIIllIl = "";
                lllllllllllllllIllIlllIlIIIIlllI = lllllllllllllllIllIlllIlIIIIlIlI.space.getValue() ? "> " : ">";
                lllllllllllllllIllIlllIlIIIIllIl = String.valueOf(new StringBuilder().append(lllllllllllllllIllIlllIlIIIIlllI).append(lllllllllllllllIllIlllIlIIIIllll));
                int lllllllllllllllIllIlllIlIIIIllII = lllllllllllllllIllIlllIlIIIIllIl.length();
                int lllllllllllllllIllIlllIlIIIIlIll = 0;
                if (lllllllllllllllIllIlllIlIIIIllIl.length() > 255) {
                    lllllllllllllllIllIlllIlIIIIlIll = lllllllllllllllIllIlllIlIIIIllII - 255;
                }
                ((CPacketChatMessage)lllllllllllllllIllIlllIlIIIIlIIl.getPacket()).message = lllllllllllllllIllIlllIlIIIIllIl = lllllllllllllllIllIlllIlIIIIllIl.substring(0, lllllllllllllllIllIlllIlIIIIllIl.length() - lllllllllllllllIllIlllIlIIIIlIll);
            }
        }, new Predicate[0]);
    }

    @Override
    public void setup() {
        AutoGreenText lllllllllllllllIllIlllIlIIIllllI;
        lllllllllllllllIllIlllIlIIIllllI.space = lllllllllllllllIllIlllIlIIIllllI.registerB("Space", true);
    }

    @Override
    public void onDisable() {
        AutoGreenText lllllllllllllllIllIlllIlIIIlIlll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllIllIlllIlIIIlIlll);
    }
}

