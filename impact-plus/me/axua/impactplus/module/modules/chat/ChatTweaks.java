/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraftforge.client.event.ClientChatReceivedEvent
 */
package me.axua.impactplus.module.modules.chat;

import java.awt.TrayIcon;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.misc.Notifications;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatTweaks
extends Module {
    /* synthetic */ Setting.b nameHighlight;
    /* synthetic */ Setting.b friendHighlight;
    /* synthetic */ Setting.b ImpactPlusMessages;
    public /* synthetic */ Setting.b InfiniteChatLength;
    /* synthetic */ Setting.b notif;
    @EventHandler
    private /* synthetic */ Listener<ClientChatReceivedEvent> chatReceivedEventListener;

    @Override
    public void onEnable() {
        ChatTweaks lIllIlIlIllIIll;
        ImpactPlus.EVENT_BUS.subscribe((Object)lIllIlIlIllIIll);
    }

    @Override
    public void onDisable() {
        ChatTweaks lIllIlIlIllIIII;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lIllIlIlIllIIII);
    }

    @Override
    public void setup() {
        ChatTweaks lIllIlIlIllIllI;
        lIllIlIlIllIllI.InfiniteChatLength = lIllIlIlIllIllI.registerB("InfiniteChatLength", true);
        lIllIlIlIllIllI.notif = lIllIlIlIllIllI.registerB("Notifications", false);
        lIllIlIlIllIllI.nameHighlight = lIllIlIlIllIllI.registerB("NameHighlight", false);
        lIllIlIlIllIllI.friendHighlight = lIllIlIlIllIllI.registerB("FriendHighlight", false);
        lIllIlIlIllIllI.ImpactPlusMessages = lIllIlIlIllIllI.registerB("ImpactPlusMessages", false);
    }

    public ChatTweaks() {
        super("ChatTweaks", Module.Category.CHAT);
        ChatTweaks lIllIlIlIlllIII;
        lIllIlIlIlllIII.chatReceivedEventListener = new Listener<ClientChatReceivedEvent>(lIllIlIlIIlllIl -> {
            ChatTweaks lIllIlIlIIlllII;
            if (ChatTweaks.mc.thePlayer == null) {
                return;
            }
            if (lIllIlIlIIlllII.friendHighlight.getValue()) {
                Friends.getFriends().forEach(lIllIlIlIIIllll -> {
                    if (lIllIlIlIIlllIl.getMessage().getUnformattedText().contains(String.valueOf(new StringBuilder().append("<").append(lIllIlIlIIIllll.getName()).append(">")))) {
                        lIllIlIlIIlllIl.getMessage().setChatStyle(lIllIlIlIIlllIl.getMessage().getChatStyle().setColor(TextFormatting.AQUA));
                    }
                });
            }
            if (lIllIlIlIIlllII.nameHighlight.getValue() && !lIllIlIlIIlllIl.getMessage().getUnformattedText().contains(String.valueOf(new StringBuilder().append("<").append(ChatTweaks.mc.thePlayer.getName()).append(">"))) && lIllIlIlIIlllIl.getMessage().getUnformattedText().contains(ChatTweaks.mc.thePlayer.getName())) {
                lIllIlIlIIlllIl.getMessage().setChatStyle(lIllIlIlIIlllIl.getMessage().getChatStyle().setColor(TextFormatting.GOLD));
                lIllIlIlIIlllIl.getMessage().setChatStyle(lIllIlIlIIlllIl.getMessage().getChatStyle().setBold(Boolean.valueOf(true)));
                if (lIllIlIlIIlllII.notif.getValue()) {
                    String lIllIlIlIlIIllI = lIllIlIlIIlllIl.getMessage().getUnformattedText();
                    Notifications.sendNotification(String.valueOf(new StringBuilder().append("New chat mention: ").append(lIllIlIlIlIIllI)), TrayIcon.MessageType.INFO);
                }
            }
            if (lIllIlIlIIlllII.ImpactPlusMessages.getValue() && !lIllIlIlIIlllIl.getMessage().getUnformattedText().contains(String.valueOf(new StringBuilder().append("<").append(ChatTweaks.mc.thePlayer.getName()).append(">"))) && !lIllIlIlIIlllIl.getMessage().getUnformattedText().toLowerCase().contains("<impactplus>") && (lIllIlIlIIlllIl.getMessage().getUnformattedText().toLowerCase().contains("impact plus") || lIllIlIlIIlllIl.getMessage().getUnformattedText().toLowerCase().contains("impactplus") || lIllIlIlIIlllIl.getMessage().getUnformattedText().toLowerCase().contains("impact+") || lIllIlIlIIlllIl.getMessage().getUnformattedText().toLowerCase().contains("impact +"))) {
                String lIllIlIlIIlllll = lIllIlIlIIlllIl.getMessage().getUnformattedText();
                lIllIlIlIIlllIl.getMessage().setChatStyle(lIllIlIlIIlllIl.getMessage().getChatStyle().setColor(TextFormatting.DARK_PURPLE));
                try {
                    String lIllIlIlIlIIlIl = "";
                    if (mc.getCurrentServerData() == null) {
                        lIllIlIlIlIIlIl = "ERROR";
                    }
                    if (mc.getCurrentServerData() != null && !ChatTweaks.mc.getCurrentServerData().serverIP.equals("")) {
                        lIllIlIlIlIIlIl = ChatTweaks.mc.getCurrentServerData().serverIP;
                    }
                    if (mc.isIntegratedServerRunning()) {
                        lIllIlIlIlIIlIl = "Singleplayer";
                    }
                    BufferedWriter lIllIlIlIlIIlII = new BufferedWriter(new FileWriter("ImpactPlus\\ImpactPlusMentions.txt", true));
                    String lIllIlIlIlIIIll = "";
                    Calendar lIllIlIlIlIIIlI = Calendar.getInstance();
                    SimpleDateFormat lIllIlIlIlIIIIl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    lIllIlIlIlIIIll = String.valueOf(new StringBuilder().append(lIllIlIlIlIIIll).append("[").append(lIllIlIlIlIIIIl.format(lIllIlIlIlIIIlI.getTime())).append("] | ").append(lIllIlIlIlIIlIl).append(" | ").append(lIllIlIlIIlllll));
                    lIllIlIlIlIIlII.write(lIllIlIlIlIIIll);
                    lIllIlIlIlIIlII.newLine();
                    lIllIlIlIlIIlII.close();
                }
                catch (IOException lIllIlIlIlIIIII) {
                    lIllIlIlIlIIIII.printStackTrace();
                }
            }
        }, new Predicate[0]);
    }
}

