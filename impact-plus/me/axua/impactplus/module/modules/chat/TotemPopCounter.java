/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.world.World
 */
package me.axua.impactplus.module.modules.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.EntityUseTotemEvent;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TotemPopCounter
extends Module {
    private /* synthetic */ HashMap<String, Integer> playerList;
    @EventHandler
    public /* synthetic */ Listener<PacketEvent.Receive> popListener;
    /* synthetic */ Setting.b countSelf;
    @EventHandler
    public /* synthetic */ Listener<EntityUseTotemEvent> listListener;
    /* synthetic */ Setting.mode Announce;
    private /* synthetic */ boolean isDead;

    private boolean isSelf(String llllllllllllllllIlIIlllIlIIllIIl) {
        return llllllllllllllllIlIIlllIlIIllIIl.equalsIgnoreCase(TotemPopCounter.mc.thePlayer.getName());
    }

    @Override
    public void onEnable() {
        TotemPopCounter llllllllllllllllIlIIlllIIllIlllI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIlIIlllIIllIlllI);
    }

    private String grammar(String llllllllllllllllIlIIlllIlIIIIIIl) {
        TotemPopCounter llllllllllllllllIlIIlllIlIIIIlII;
        if (llllllllllllllllIlIIlllIlIIIIlII.isSelf(llllllllllllllllIlIIlllIlIIIIIIl)) {
            return "my";
        }
        return "their";
    }

    private String formatName2(String llllllllllllllllIlIIlllIlIIIlIII) {
        TotemPopCounter llllllllllllllllIlIIlllIlIIIllII;
        String llllllllllllllllIlIIlllIlIIIlIlI = "";
        if (llllllllllllllllIlIIlllIlIIIllII.isSelf(llllllllllllllllIlIIlllIlIIIlIII)) {
            llllllllllllllllIlIIlllIlIIIlIlI = "";
            llllllllllllllllIlIIlllIlIIIlIII = "I";
        }
        if (llllllllllllllllIlIIlllIlIIIllII.Announce.getValue().equalsIgnoreCase("Public")) {
            return String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIlIIIlIlI).append(llllllllllllllllIlIIlllIlIIIlIII));
        }
        return String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIlIIIlIlI).append(ChatFormatting.DARK_AQUA).append(llllllllllllllllIlIIlllIlIIIlIII).append(TextFormatting.DARK_RED));
    }

    private boolean selfCheck(String llllllllllllllllIlIIlllIlIIlllIl) {
        TotemPopCounter llllllllllllllllIlIIlllIlIIllllI;
        if (llllllllllllllllIlIIlllIlIIllllI.isDead) {
            return false;
        }
        if (llllllllllllllllIlIIlllIlIIllllI.countSelf.getValue() && llllllllllllllllIlIIlllIlIIlllIl.equalsIgnoreCase(TotemPopCounter.mc.thePlayer.getName())) {
            return true;
        }
        return llllllllllllllllIlIIlllIlIIllllI.countSelf.getValue() || !llllllllllllllllIlIIlllIlIIlllIl.equalsIgnoreCase(TotemPopCounter.mc.thePlayer.getName());
    }

    private String formatNumber(int llllllllllllllllIlIIlllIIllllIIl) {
        TotemPopCounter llllllllllllllllIlIIlllIIllllIII;
        if (llllllllllllllllIlIIlllIIllllIII.Announce.getValue().equalsIgnoreCase("Public")) {
            return String.valueOf(new StringBuilder().append("").append(llllllllllllllllIlIIlllIIllllIIl));
        }
        return String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("").append(llllllllllllllllIlIIlllIIllllIIl));
    }

    private String formatName(String llllllllllllllllIlIIlllIlIIlIIIl) {
        TotemPopCounter llllllllllllllllIlIIlllIlIIlIIlI;
        String llllllllllllllllIlIIlllIlIIlIIll = "";
        if (llllllllllllllllIlIIlllIlIIlIIlI.isSelf(llllllllllllllllIlIIlllIlIIlIIIl)) {
            llllllllllllllllIlIIlllIlIIlIIll = "";
            llllllllllllllllIlIIlllIlIIlIIIl = "I";
        }
        if (llllllllllllllllIlIIlllIlIIlIIlI.Announce.getValue().equalsIgnoreCase("Public")) {
            return String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIlIIlIIll).append(llllllllllllllllIlIIlllIlIIlIIIl));
        }
        return String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIlIIlIIll).append(ChatFormatting.DARK_AQUA).append(llllllllllllllllIlIIlllIlIIlIIIl).append(TextFormatting.DARK_RED));
    }

    public int getpoppedfagezkys(String llllllllllllllllIlIIlllIlIlIlIll) {
        TotemPopCounter llllllllllllllllIlIIlllIlIlIllII;
        if (llllllllllllllllIlIIlllIlIlIllII.playerList.containsKey(llllllllllllllllIlIIlllIlIlIlIll)) {
            return llllllllllllllllIlIIlllIlIlIllII.playerList.get(llllllllllllllllIlIIlllIlIlIlIll);
        }
        return 9999;
    }

    private String ending() {
        return "";
    }

    public TotemPopCounter() {
        super("TotemPopCounter", Module.Category.CHAT, "Fixed!");
        TotemPopCounter llllllllllllllllIlIIlllIlIllIlll;
        llllllllllllllllIlIIlllIlIllIlll.playerList = new HashMap();
        llllllllllllllllIlIIlllIlIllIlll.isDead = false;
        llllllllllllllllIlIIlllIlIllIlll.listListener = new Listener<EntityUseTotemEvent>(llllllllllllllllIlIIlllIIlIllIIl -> {
            TotemPopCounter llllllllllllllllIlIIlllIIlIllIII;
            if (llllllllllllllllIlIIlllIIlIllIII.playerList == null) {
                llllllllllllllllIlIIlllIIlIllIII.playerList = new HashMap();
            }
            if (llllllllllllllllIlIIlllIIlIllIII.playerList.get(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName()) == null) {
                llllllllllllllllIlIIlllIIlIllIII.playerList.put(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName(), 1);
                llllllllllllllllIlIIlllIIlIllIII.sendMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIIlIllIII.formatName2(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName())).append(" popped ").append(llllllllllllllllIlIIlllIIlIllIII.formatNumber(1)).append(" totem").append(llllllllllllllllIlIIlllIIlIllIII.ending())));
            } else if (llllllllllllllllIlIIlllIIlIllIII.playerList.get(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName()) != null) {
                int llllllllllllllllIlIIlllIIlIllIll = llllllllllllllllIlIIlllIIlIllIII.playerList.get(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName());
                llllllllllllllllIlIIlllIIlIllIII.playerList.put(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName(), ++llllllllllllllllIlIIlllIIlIllIll);
                llllllllllllllllIlIIlllIIlIllIII.sendMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIIlIllIII.formatName2(llllllllllllllllIlIIlllIIlIllIIl.getEntity().getName())).append(" popped ").append(llllllllllllllllIlIIlllIIlIllIII.formatNumber(llllllllllllllllIlIIlllIIlIllIll)).append(" totems").append(llllllllllllllllIlIIlllIIlIllIII.ending())));
            }
        }, new Predicate[0]);
        llllllllllllllllIlIIlllIlIllIlll.popListener = new Listener<PacketEvent.Receive>(llllllllllllllllIlIIlllIIllIIIIl -> {
            Entity llllllllllllllllIlIIlllIIllIIllI;
            TotemPopCounter llllllllllllllllIlIIlllIIllIIlII;
            SPacketEntityStatus llllllllllllllllIlIIlllIIllIIlIl;
            if (TotemPopCounter.mc.thePlayer == null) {
                return;
            }
            if (llllllllllllllllIlIIlllIIllIIIIl.getPacket() instanceof SPacketEntityStatus && (llllllllllllllllIlIIlllIIllIIlIl = (SPacketEntityStatus)llllllllllllllllIlIIlllIIllIIIIl.getPacket()).getOpCode() == 35 && llllllllllllllllIlIIlllIIllIIlII.selfCheck((llllllllllllllllIlIIlllIIllIIllI = llllllllllllllllIlIIlllIIllIIlIl.getEntity((World)TotemPopCounter.mc.theWorld)).getName())) {
                ImpactPlus.EVENT_BUS.post(new EntityUseTotemEvent(llllllllllllllllIlIIlllIIllIIllI));
            }
        }, new Predicate[0]);
    }

    @Override
    public void setup() {
        TotemPopCounter llllllllllllllllIlIIlllIlIllIIlI;
        ArrayList<String> llllllllllllllllIlIIlllIlIllIIll = new ArrayList<String>();
        llllllllllllllllIlIIlllIlIllIIll.add("Client");
        llllllllllllllllIlIIlllIlIllIIll.add("Public");
        llllllllllllllllIlIIlllIlIllIIlI.countSelf = llllllllllllllllIlIIlllIlIllIIlI.registerB("CountSelf", true);
        llllllllllllllllIlIIlllIlIllIIlI.Announce = llllllllllllllllIlIIlllIlIllIIlI.registerMode("Mode", llllllllllllllllIlIIlllIlIllIIll, "Client");
    }

    private void sendMessage(String llllllllllllllllIlIIlllIIlllIIll) {
        TotemPopCounter llllllllllllllllIlIIlllIIlllIlII;
        if (llllllllllllllllIlIIlllIIlllIlII.Announce.getValue().equalsIgnoreCase("Public")) {
            TotemPopCounter.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketChatMessage(llllllllllllllllIlIIlllIIlllIIll));
        } else {
            Command.sendClientMessage(llllllllllllllllIlIIlllIIlllIIll);
        }
    }

    @Override
    public void onUpdate() {
        TotemPopCounter llllllllllllllllIlIIlllIlIlIIllI;
        if (!llllllllllllllllIlIIlllIlIlIIllI.isDead && 0.0f >= TotemPopCounter.mc.thePlayer.getHealth()) {
            llllllllllllllllIlIIlllIlIlIIllI.isDead = true;
            llllllllllllllllIlIIlllIlIlIIllI.playerList.clear();
            return;
        }
        if (llllllllllllllllIlIIlllIlIlIIllI.isDead && 0.0f < TotemPopCounter.mc.thePlayer.getHealth()) {
            llllllllllllllllIlIIlllIlIlIIllI.isDead = false;
        }
        for (EntityPlayer llllllllllllllllIlIIlllIlIlIIlll : TotemPopCounter.mc.theWorld.playerEntities) {
            if (!(0.0f >= llllllllllllllllIlIIlllIlIlIIlll.getHealth()) || !llllllllllllllllIlIIlllIlIlIIllI.selfCheck(llllllllllllllllIlIIlllIlIlIIlll.getName()) || !llllllllllllllllIlIIlllIlIlIIllI.playerList.containsKey(llllllllllllllllIlIIlllIlIlIIlll.getName())) continue;
            llllllllllllllllIlIIlllIlIlIIllI.sendMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlllIlIlIIllI.formatName(llllllllllllllllIlIIlllIlIlIIlll.getName())).append(" died after popping ").append(llllllllllllllllIlIIlllIlIlIIllI.formatNumber(llllllllllllllllIlIIlllIlIlIIllI.playerList.get(llllllllllllllllIlIIlllIlIlIIlll.getName()))).append(" totems").append(llllllllllllllllIlIIlllIlIlIIllI.ending())));
            llllllllllllllllIlIIlllIlIlIIllI.playerList.remove(llllllllllllllllIlIIlllIlIlIIlll.getName(), llllllllllllllllIlIIlllIlIlIIllI.playerList.get(llllllllllllllllIlIIlllIlIlIIlll.getName()));
        }
    }

    @Override
    public void onDisable() {
        TotemPopCounter llllllllllllllllIlIIlllIIllIlIll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIlIIlllIIllIlIll);
    }

    private boolean isPublic() {
        TotemPopCounter llllllllllllllllIlIIlllIIlllllIl;
        return llllllllllllllllIlIIlllIIlllllIl.Announce.getValue().equalsIgnoreCase("Public");
    }
}

