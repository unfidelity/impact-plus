/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 */
package me.axua.impactplus.module.modules.player;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

public class AntiForceLook
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> ReceiveListener;

    @Override
    public void onEnable() {
        AntiForceLook lllIIIlIIIIllll;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllIIIlIIIIllll);
    }

    public AntiForceLook() {
        super("AntiForceLook", Module.Category.PLAYER, "stops server forcing you to look in a direction");
        AntiForceLook lllIIIlIIIlIIlI;
        lllIIIlIIIlIIlI.ReceiveListener = new Listener<PacketEvent.Receive>(lllIIIlIIIIIllI -> {
            if (AntiForceLook.mc.thePlayer == null) {
                return;
            }
            if (lllIIIlIIIIIllI.getPacket() instanceof SPacketPlayerPosLook) {
                SPacketPlayerPosLook lllIIIlIIIIlIII = (SPacketPlayerPosLook)lllIIIlIIIIIllI.getPacket();
                lllIIIlIIIIlIII.yaw = AntiForceLook.mc.thePlayer.rotationYaw;
                lllIIIlIIIIlIII.pitch = AntiForceLook.mc.thePlayer.rotationPitch;
            }
        }, new Predicate[0]);
    }

    @Override
    public void onDisable() {
        AntiForceLook lllIIIlIIIIlIll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllIIIlIIIIlIll);
    }
}

