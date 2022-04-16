/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 */
package me.axua.impactplus.module.modules.movement;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class EcmeFlight
extends Module {
    private /* synthetic */ boolean flyTick;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> sendListener;

    @Override
    public void onUpdate() {
        float llllllllllllllllIlIlIIIIIlIIIIII = 5.0f;
        EcmeFlight.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(EcmeFlight.mc.thePlayer.posX, EcmeFlight.mc.thePlayer.posY - 0.06, EcmeFlight.mc.thePlayer.posZ, false));
        EcmeFlight.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(EcmeFlight.mc.thePlayer.posX, EcmeFlight.mc.thePlayer.posY + 0.06, EcmeFlight.mc.thePlayer.posZ, true));
        if (Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) {
            EcmeFlight.mc.thePlayer.jump();
        } else if (Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) {
            EcmeFlight.mc.thePlayer.setPosition(EcmeFlight.mc.thePlayer.posX, EcmeFlight.mc.thePlayer.posY - (double)(llllllllllllllllIlIlIIIIIlIIIIII / 10.0f), EcmeFlight.mc.thePlayer.posZ);
        }
    }

    @Override
    public void onDisable() {
        EcmeFlight llllllllllllllllIlIlIIIIIlIIIlII;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIlIlIIIIIlIIIlII);
        if (!EcmeFlight.mc.thePlayer.capabilities.isCreativeMode) {
            EcmeFlight.mc.thePlayer.capabilities.allowFlying = false;
        }
        EcmeFlight.mc.thePlayer.capabilities.isFlying = false;
    }

    @Override
    public void onEnable() {
        EcmeFlight llllllllllllllllIlIlIIIIIIllllIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIlIlIIIIIIllllIl);
    }

    public EcmeFlight() {
        super("EcmeFlight", Module.Category.MOVEMENT);
        EcmeFlight llllllllllllllllIlIlIIIIIlIIIlll;
        llllllllllllllllIlIlIIIIIlIIIlll.flyTick = false;
        llllllllllllllllIlIlIIIIIlIIIlll.sendListener = new Listener<PacketEvent.Send>(llllllllllllllllIlIlIIIIIIlllIIl -> {
            EcmeFlight llllllllllllllllIlIlIIIIIIlllIII;
            llllllllllllllllIlIlIIIIIIlllIII.flyTick = !llllllllllllllllIlIlIIIIIIlllIII.flyTick;
        }, new Predicate[0]);
    }
}

