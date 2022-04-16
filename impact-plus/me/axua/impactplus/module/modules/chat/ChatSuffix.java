/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
package me.axua.impactplus.module.modules.chat;

import java.util.ArrayList;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

public class ChatSuffix
extends Module {
    /* synthetic */ Setting.mode format;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> listener;

    @Override
    public void onDisable() {
        ChatSuffix llllIIlll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllIIlll);
    }

    @Override
    public void onEnable() {
        ChatSuffix llllIlIlI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllIlIlI);
    }

    @Override
    public void setup() {
        ChatSuffix llllIllIl;
        ArrayList<String> llllIlllI = new ArrayList<String>();
        llllIlllI.add("Impact+");
        llllIlllI.add("Meme");
        llllIllIl.format = llllIllIl.registerMode("Suffix", llllIlllI, "Impact+");
    }

    public ChatSuffix() {
        super("ChatSuffix", Module.Category.CHAT, "Adds a suffix to your messages");
        ChatSuffix lllllIIll;
        lllllIIll.listener = new Listener<PacketEvent.Send>(lllIlIIII -> {
            if (lllIlIIII.getPacket() instanceof CPacketChatMessage) {
                ChatSuffix lllIlIIll;
                if (((CPacketChatMessage)lllIlIIII.getPacket()).getMessage().startsWith("/") || ((CPacketChatMessage)lllIlIIII.getPacket()).getMessage().startsWith(Command.getPrefix()) || ((CPacketChatMessage)lllIlIIII.getPacket()).getMessage().startsWith(".") || ((CPacketChatMessage)lllIlIIII.getPacket()).getMessage().startsWith("!") || ((CPacketChatMessage)lllIlIIII.getPacket()).getMessage().startsWith("#")) {
                    return;
                }
                String lllIllIII = ((CPacketChatMessage)lllIlIIII.getPacket()).getMessage();
                String lllIlIlll = "";
                if (ChatSuffix.mc.thePlayer.getName().equalsIgnoreCase("f4cts") || ChatSuffix.mc.thePlayer.getName().equalsIgnoreCase("w_j") || ChatSuffix.mc.thePlayer.getName().equalsIgnoreCase("uu7") || ChatSuffix.mc.thePlayer.getName().equalsIgnoreCase("CheatinAndHackin")) {
                    if (lllIlIIll.format.getValue().equalsIgnoreCase("Impact+")) {
                        lllIlIlll = " \uff5c \u1d00\u029f\u026a\u1d07\u0274 \u029c\u1d00\u1d04\u1d0b";
                    }
                } else if (lllIlIIll.format.getValue().equalsIgnoreCase("Impact+")) {
                    lllIlIlll = " \u0274\u1d07\u1d21 \u026a\u1d0d\u1d18\u1d00\u1d04\u1d1b\u208a";
                }
                if (lllIlIIll.format.getValue().equalsIgnoreCase("Meme")) {
                    lllIlIlll = " \u00bb \u0274\u1d07\u0299\u1d1c\u029f\u1d00 \u1d5f\u1d43\u1d38\u1d34\u1d43\u1d9c\u1d37 \u00bb \u026a\u1d0d\u1d00\u1d18\u1d04\u1d1b\u208a \u00bb \u028c\u0433\u1d07\u0455+ \u00ab \u1d0b\u1d00\u1d0d\u026a \u0299\u029f\u1d1c\u1d07 \u1d0f\u0274 \u1d1b\u1d0f\u1d18 \u00bb \u02e2\u207f\u1d52\u02b7\u23d0 \u041d\u03b5\u13ae\u043d\u15e9\u03b5\u0455\u01ad\u03c5\u0455 \u00bb \u0299\u1d00\u1d04\u1d0b\u1d05\u1d0f\u1d0f\u0280\u1d07\u1d05 | \u1d0d\u1d07\u1d0f\u1d21 \u00bb \u1d1c\u0274\u026a\u1d04\u1d0f\u0280\u0274\u0262\u1d0f\u1d05.\u0262\u0262 ~~ \ua731\u1d07\u1d18\u1d18\u1d1c\u1d0b\u1d1c | \u029c\u1d1c\u1d22\u1d1c\u0274\u026a\u0262\u0280\u1d07\u1d07\u0274.\u0262\u0262\u2122 \u00bb \u0299\u1d00\u1d04\u1d0b\u1d04\u029f\u026a\u1d07\u0274\u1d1b\u2122 \u00bb \u0274\u1d0f\u1d1c \u029f\u1d07\u1d00\u1d0b \u262f \u23d0 \u0493\u1d0f\u0280\u0262\u1d07\u0280\u1d00\u1d1b \u2661 | \u04e8B\u039bM\u039b \u1103\u1102I\u03a3\u041f\u01ac - \u1d07\u029f\u1d07\u1d0d\u1d07\u0274\u1d1b\u1d00\u0280\ua731.\u1d04\u1d0f\u1d0d \u300b\u1d0f\ua731\u026a\u0280\u026a\ua731 | W\u00d4\u00d4K\u00cf\u00ca \u00c7L\u00ee\u00eb\u00d1T\u2122 {\u0280\u1d00\u026a\u1d0f\u0274\u1d0b\u1d07\u1d0b} \u30c3 \uff32\uff10\uff10\uff34 \uff5c \u0280\u1d1c\u029c\u1d00\u1d0d\u1d00 | \u1d05\u1d0f\u1d1b\u0493\u1d00\u0262.\u026a\u0274\u2122 >> \u1d00\u0280\u026a\u0455\u1d1b\u1d0f\u026a\u0455 \u02b3\u1d58\u02e2\u02b0\u1d49\u02b3\u02b0\u1d43\u1d9c\u1d4f";
                }
                String lllIlIllI = String.valueOf(new StringBuilder().append(lllIllIII).append(lllIlIlll));
                int lllIlIlIl = lllIlIllI.length();
                int lllIlIlII = 0;
                if (lllIlIllI.length() > 255) {
                    lllIlIlII = lllIlIlIl - 255;
                }
                ((CPacketChatMessage)lllIlIIII.getPacket()).message = lllIlIllI = lllIlIllI.substring(0, lllIlIllI.length() - lllIlIlII);
            }
        }, new Predicate[0]);
    }
}

