/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 */
package me.axua.impactplus.module.modules.player;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;

public class BuildHeight
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> receiveListener;

    public BuildHeight() {
        super("BuildHeight", Module.Category.PLAYER);
        BuildHeight llllIIIllIIIIl;
        llllIIIllIIIIl.receiveListener = new Listener<PacketEvent.Send>(llllIIIlIlIllI -> {
            if (!(llllIIIlIlIllI.getPacket() instanceof CPacketPlayerTryUseItemOnBlock)) {
                return;
            }
            CPacketPlayerTryUseItemOnBlock llllIIIlIlIlll = (CPacketPlayerTryUseItemOnBlock)llllIIIlIlIllI.getPacket();
            if (llllIIIlIlIlll.func_187023_a().getY() < 255) {
                return;
            }
            if (llllIIIlIlIlll.func_187024_b() != EnumFacing.UP) {
                return;
            }
            BuildHeight.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llllIIIlIlIlll.func_187023_a(), EnumFacing.DOWN, llllIIIlIlIlll.func_187022_c(), llllIIIlIlIlll.func_187026_d(), llllIIIlIlIlll.func_187025_e(), llllIIIlIlIlll.func_187020_f()));
            llllIIIlIlIllI.cancel();
        }, new Predicate[0]);
    }

    @Override
    public void onDisable() {
        BuildHeight llllIIIlIlllII;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllIIIlIlllII);
    }

    @Override
    public void onEnable() {
        BuildHeight llllIIIlIllllI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllIIIlIllllI);
    }
}

