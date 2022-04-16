/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.axua.impactplus.module.modules.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PlayerJoinEvent;
import me.axua.impactplus.event.events.PlayerLeaveEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class Welcomer
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PlayerJoinEvent> listener1;
    @EventHandler
    private /* synthetic */ Listener<PlayerLeaveEvent> listener2;
    /* synthetic */ Setting.b publicS;
    /* synthetic */ String names;

    public Welcomer() {
        super("Join/Leave", Module.Category.CHAT, "Sends a message when someone joins the server");
        Welcomer llllllllllllllllIlIIlIIIllllIIll;
        llllllllllllllllIlIIlIIIllllIIll.names = "";
        llllllllllllllllIlIIlIIIllllIIll.listener1 = new Listener<PlayerJoinEvent>(llllllllllllllllIlIIlIIIlllIIIIl -> {
            Welcomer llllllllllllllllIlIIlIIIlllIIlII;
            if (llllllllllllllllIlIIlIIIlllIIlII.publicS.getValue()) {
                Welcomer.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlIIIlllIIIIl.getName()).append(" joined the game")));
            } else {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlIIIlllIIIIl.getName()).append(ChatFormatting.GREEN).append(" joined").append(ChatFormatting.RESET).append(" the game")));
            }
        }, new Predicate[0]);
        llllllllllllllllIlIIlIIIllllIIll.listener2 = new Listener<PlayerLeaveEvent>(llllllllllllllllIlIIlIIIlllIIlll -> {
            Welcomer llllllllllllllllIlIIlIIIlllIlIII;
            if (llllllllllllllllIlIIlIIIlllIlIII.names.equals(llllllllllllllllIlIIlIIIlllIIlll.getName())) {
                return;
            }
            if (llllllllllllllllIlIIlIIIlllIlIII.publicS.getValue()) {
                Welcomer.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlIIIlllIIlll.getName()).append(" left the game")));
            } else {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlIIIlllIIlll.getName()).append(ChatFormatting.RED).append(" left").append(ChatFormatting.RESET).append(" the game")));
            }
            llllllllllllllllIlIIlIIIlllIlIII.names = llllllllllllllllIlIIlIIIlllIIlll.getName();
        }, new Predicate[0]);
        llllllllllllllllIlIIlIIIllllIIll.publicS = llllllllllllllllIlIIlIIIllllIIll.registerB("Public", false);
    }

    @Override
    public void onDisable() {
        Welcomer llllllllllllllllIlIIlIIIlllIllIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIlIIlIIIlllIllIl);
    }

    @Override
    public void onEnable() {
        Welcomer llllllllllllllllIlIIlIIIllllIIIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIlIIlIIIllllIIIl);
    }
}

