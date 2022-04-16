/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.world.World
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 */
package me.axua.impactplus.module.modules.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class AutoEz
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> sendListener;
    static /* synthetic */ List<String> AutoEzMessages;
    @EventHandler
    private /* synthetic */ Listener<LivingDeathEvent> livingDeathEventListener;
    public static /* synthetic */ AutoEz INSTANCE;
    private /* synthetic */ ConcurrentHashMap targetedPlayers;
    /* synthetic */ int index;

    @Override
    public void onUpdate() {
        AutoEz lIIIIlIllllIII;
        if (lIIIIlIllllIII.targetedPlayers == null) {
            lIIIIlIllllIII.targetedPlayers = new ConcurrentHashMap();
        }
        for (Entity lIIIIlIllllIll : AutoEz.mc.theWorld.getLoadedEntityList()) {
            String lIIIIlIlllllIl;
            EntityPlayer lIIIIlIlllllII;
            if (!(lIIIIlIllllIll instanceof EntityPlayer) || !((lIIIIlIlllllII = (EntityPlayer)lIIIIlIllllIll).getHealth() <= 0.0f) || !lIIIIlIllllIII.shouldAnnounce(lIIIIlIlllllIl = lIIIIlIlllllII.getName())) continue;
            lIIIIlIllllIII.doAnnounce(lIIIIlIlllllIl);
            break;
        }
        lIIIIlIllllIII.targetedPlayers.forEach((lIIIIlIlIlIIll, lIIIIlIlIIllll) -> {
            AutoEz lIIIIlIlIlIIIl;
            if ((Integer)lIIIIlIlIIllll <= 0) {
                lIIIIlIlIlIIIl.targetedPlayers.remove(lIIIIlIlIlIIll);
            } else {
                lIIIIlIlIlIIIl.targetedPlayers.put(lIIIIlIlIlIIll, (Integer)lIIIIlIlIIllll - 1);
            }
        });
    }

    private boolean shouldAnnounce(String lIIIIlIlllIIII) {
        AutoEz lIIIIlIlllIIIl;
        return lIIIIlIlllIIIl.targetedPlayers.containsKey(lIIIIlIlllIIII);
    }

    @Override
    public void onDisable() {
        AutoEz lIIIIllIIIIlll;
        lIIIIllIIIIlll.targetedPlayers = null;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lIIIIllIIIIlll);
    }

    @Override
    public void onEnable() {
        AutoEz lIIIIllIIIllII;
        lIIIIllIIIllII.targetedPlayers = new ConcurrentHashMap();
        ImpactPlus.EVENT_BUS.subscribe((Object)lIIIIllIIIllII);
    }

    public static List<String> getAutoEzMessages() {
        return AutoEzMessages;
    }

    private void doAnnounce(String lIIIIlIllIIIll) {
        String lIIIIlIllIIllI;
        AutoEz lIIIIlIllIIlII;
        lIIIIlIllIIlII.targetedPlayers.remove(lIIIIlIllIIIll);
        if (lIIIIlIllIIlII.index >= AutoEzMessages.size() - 1) {
            lIIIIlIllIIlII.index = -1;
        }
        ++lIIIIlIllIIlII.index;
        if (AutoEzMessages.size() > 0) {
            String lIIIIlIllIlIIl = AutoEzMessages.get(lIIIIlIllIIlII.index);
        } else {
            lIIIIlIllIIllI = "Ez";
        }
        String lIIIIlIllIIlIl = lIIIIlIllIIllI.replaceAll("\u00e0\u00b8\u00a2\u00e0\u00b8\u2021", "").replace("{name}", lIIIIlIllIIIll);
        if (lIIIIlIllIIlIl.length() > 255) {
            lIIIIlIllIIlIl = lIIIIlIllIIlIl.substring(0, 255);
        }
        AutoEz.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketChatMessage(lIIIIlIllIIlIl));
    }

    public static void addAutoEzMessage(String lIIIIlIlIllIII) {
        AutoEzMessages.add(lIIIIlIlIllIII);
    }

    static {
        AutoEzMessages = new ArrayList<String>();
    }

    public AutoEz() {
        super("AutoEz", Module.Category.CHAT, "Sends a message in chat when you kill someone");
        AutoEz lIIIIllIIlIIIl;
        lIIIIllIIlIIIl.targetedPlayers = null;
        lIIIIllIIlIIIl.index = -1;
        lIIIIllIIlIIIl.sendListener = new Listener<PacketEvent.Send>(lIIIIlIIlllIII -> {
            if (AutoEz.mc.thePlayer != null) {
                Entity lIIIIlIIlllIll;
                CPacketUseEntity lIIIIlIIlllIlI;
                AutoEz lIIIIlIIllIlll;
                if (lIIIIlIIllIlll.targetedPlayers == null) {
                    lIIIIlIIllIlll.targetedPlayers = new ConcurrentHashMap();
                }
                if (lIIIIlIIlllIII.getPacket() instanceof CPacketUseEntity && (lIIIIlIIlllIlI = (CPacketUseEntity)lIIIIlIIlllIII.getPacket()).getAction().equals((Object)CPacketUseEntity.Action.ATTACK) && (lIIIIlIIlllIll = lIIIIlIIlllIlI.getEntityFromWorld((World)AutoEz.mc.theWorld)) instanceof EntityPlayer) {
                    lIIIIlIIllIlll.addTargetedPlayer(lIIIIlIIlllIll.getName());
                }
            }
        }, new Predicate[0]);
        lIIIIllIIlIIIl.livingDeathEventListener = new Listener<LivingDeathEvent>(lIIIIlIlIIIIll -> {
            if (AutoEz.mc.thePlayer != null) {
                String lIIIIlIlIIlIIl;
                EntityPlayer lIIIIlIlIIlIII;
                EntityLivingBase lIIIIlIlIIIlll;
                AutoEz lIIIIlIlIIIllI;
                if (lIIIIlIlIIIllI.targetedPlayers == null) {
                    lIIIIlIlIIIllI.targetedPlayers = new ConcurrentHashMap();
                }
                if ((lIIIIlIlIIIlll = lIIIIlIlIIIIll.getEntityLiving()) != null && lIIIIlIlIIIlll instanceof EntityPlayer && (lIIIIlIlIIlIII = (EntityPlayer)lIIIIlIlIIIlll).getHealth() <= 0.0f && lIIIIlIlIIIllI.shouldAnnounce(lIIIIlIlIIlIIl = lIIIIlIlIIlIII.getName())) {
                    lIIIIlIlIIIllI.doAnnounce(lIIIIlIlIIlIIl);
                }
            }
        }, new Predicate[0]);
        INSTANCE = lIIIIllIIlIIIl;
    }

    public void addTargetedPlayer(String lIIIIlIlIlllIl) {
        if (!Objects.equals(lIIIIlIlIlllIl, AutoEz.mc.thePlayer.getName())) {
            AutoEz lIIIIlIlIllllI;
            if (lIIIIlIlIllllI.targetedPlayers == null) {
                lIIIIlIlIllllI.targetedPlayers = new ConcurrentHashMap();
            }
            lIIIIlIlIllllI.targetedPlayers.put(lIIIIlIlIlllIl, 20);
        }
    }
}

