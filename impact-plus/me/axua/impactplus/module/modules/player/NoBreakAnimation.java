/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.module.modules.player;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class NoBreakAnimation
extends Module {
    private /* synthetic */ BlockPos lastPos;
    private /* synthetic */ EnumFacing lastFacing;
    private /* synthetic */ boolean isMining;
    @EventHandler
    public /* synthetic */ Listener<PacketEvent.Send> listener;

    private void setMiningInfo(BlockPos llIIllIlIllIlIl, EnumFacing llIIllIlIllIlII) {
        llIIllIlIllIllI.lastPos = llIIllIlIllIlIl;
        llIIllIlIllIllI.lastFacing = llIIllIlIllIlII;
    }

    public NoBreakAnimation() {
        super("NoBreakAnimation", Module.Category.PLAYER, "NoBreakAnimation");
        NoBreakAnimation llIIllIllIIIIIl;
        llIIllIllIIIIIl.isMining = false;
        llIIllIllIIIIIl.lastPos = null;
        llIIllIllIIIIIl.lastFacing = null;
        llIIllIllIIIIIl.listener = new Listener<PacketEvent.Send>(llIIllIlIlIIIlI -> {
            if (llIIllIlIlIIIlI.getPacket() instanceof CPacketPlayerDigging) {
                NoBreakAnimation llIIllIlIlIIIll;
                CPacketPlayerDigging llIIllIlIlIIlII = (CPacketPlayerDigging)llIIllIlIlIIIlI.getPacket();
                for (Entity llIIllIlIlIIlIl : NoBreakAnimation.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llIIllIlIlIIlII.getPosition()))) {
                    if (llIIllIlIlIIlIl instanceof EntityEnderCrystal) {
                        llIIllIlIlIIIll.resetMining();
                        return;
                    }
                    if (!(llIIllIlIlIIlIl instanceof EntityLivingBase)) continue;
                    llIIllIlIlIIIll.resetMining();
                    return;
                }
                if (llIIllIlIlIIlII.getStatus().equals((Object)CPacketPlayerDigging.Action.START_DESTROY_BLOCK)) {
                    llIIllIlIlIIIll.isMining = true;
                    llIIllIlIlIIIll.setMiningInfo(llIIllIlIlIIlII.getPosition(), llIIllIlIlIIlII.getFacing());
                }
                if (llIIllIlIlIIlII.getStatus().equals((Object)CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK)) {
                    llIIllIlIlIIIll.resetMining();
                }
            }
        }, new Predicate[0]);
    }

    public void resetMining() {
        llIIllIlIllIIIl.isMining = false;
        llIIllIlIllIIIl.lastPos = null;
        llIIllIlIllIIIl.lastFacing = null;
    }

    @Override
    public void onDisable() {
        NoBreakAnimation llIIllIlIlIlIll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llIIllIlIlIlIll);
    }

    @Override
    public void onEnable() {
        NoBreakAnimation llIIllIlIlIlllI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llIIllIlIlIlllI);
    }

    @Override
    public void onUpdate() {
        NoBreakAnimation llIIllIlIllllIl;
        if (!NoBreakAnimation.mc.gameSettings.keyBindAttack.isKeyDown()) {
            llIIllIlIllllIl.resetMining();
            return;
        }
        if (llIIllIlIllllIl.isMining && llIIllIlIllllIl.lastPos != null && llIIllIlIllllIl.lastFacing != null) {
            NoBreakAnimation.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, llIIllIlIllllIl.lastPos, llIIllIlIllllIl.lastFacing));
        }
    }
}

