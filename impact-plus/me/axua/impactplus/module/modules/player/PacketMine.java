/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package me.axua.impactplus.module.modules.player;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.ImpactPlusEvent;
import me.axua.impactplus.event.events.DamageBlockEvent;
import me.axua.impactplus.event.events.EventPlayerMotionUpdate;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PacketMine
extends Module {
    public /* synthetic */ Setting.b rainbow;
    @EventHandler
    private /* synthetic */ Listener<EventPlayerMotionUpdate> OnPlayerUpdate;
    public /* synthetic */ Setting.i w;
    public /* synthetic */ Setting.i alpha;
    /* synthetic */ BlockPos pos2;
    @EventHandler
    private /* synthetic */ Listener<DamageBlockEvent> damageBlock;
    public /* synthetic */ Setting.b render;
    public /* synthetic */ Setting.i blue;
    public /* synthetic */ Setting.i red;
    public /* synthetic */ Setting.i green;

    public BlockPos packetpos() {
        PacketMine llIllllIIIlIll;
        if (llIllllIIIlIll.pos2 == null) {
            return null;
        }
        return llIllllIIIlIll.pos2;
    }

    @Override
    public void onWorldRender(RenderEvent llIllllIIIIllI) {
        PacketMine llIllllIIIIlII;
        if (llIllllIIIIlII.pos2 == null) {
            return;
        }
        IBlockState llIllllIIIIlIl = PacketMine.mc.theWorld.getBlockState(llIllllIIIIlII.pos2);
        if (llIllllIIIIlIl.getBlock() == Blocks.air) {
            llIllllIIIIlII.pos2 = null;
            return;
        }
        if (!llIllllIIIIlII.render.getValue()) {
            return;
        }
        if (llIllllIIIIlII.rainbow.getValue()) {
            Tessellator.prepare(7);
            Tessellator.drawBox(llIllllIIIIlII.pos2, Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), llIllllIIIIlII.alpha.getValue(), 63);
            Tessellator.release();
            ImpactPlusTessellator.prepare(7);
            ImpactPlusTessellator.drawBoundingBoxBlockPos(llIllllIIIIlII.pos2, llIllllIIIIlII.w.getValue(), Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), 255);
        } else {
            Tessellator.prepare(7);
            Tessellator.drawBox(llIllllIIIIlII.pos2, llIllllIIIIlII.red.getValue(), llIllllIIIIlII.green.getValue(), llIllllIIIIlII.blue.getValue(), llIllllIIIIlII.alpha.getValue(), 63);
            Tessellator.release();
            ImpactPlusTessellator.prepare(7);
            ImpactPlusTessellator.drawBoundingBoxBlockPos(llIllllIIIIlII.pos2, llIllllIIIIlII.w.getValue(), llIllllIIIIlII.red.getValue(), llIllllIIIIlII.green.getValue(), llIllllIIIIlII.blue.getValue(), 255);
        }
        ImpactPlusTessellator.release();
    }

    private boolean canBreak(BlockPos llIlllIllllllI) {
        IBlockState llIlllIlllllIl = PacketMine.mc.theWorld.getBlockState(llIlllIllllllI);
        Block llIlllIlllllII = llIlllIlllllIl.getBlock();
        return llIlllIlllllII.getBlockHardness(llIlllIlllllIl, (World)PacketMine.mc.theWorld, llIlllIllllllI) != -1.0f;
    }

    @Override
    public void onDisable() {
        PacketMine llIlllIlllIlII;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llIlllIlllIlII);
    }

    @Override
    public void onEnable() {
        PacketMine llIlllIlllIlll;
        ImpactPlus.EVENT_BUS.subscribe((Object)llIlllIlllIlll);
    }

    @Override
    public void setup() {
        PacketMine llIllllIIIllIl;
        llIllllIIIllIl.render = llIllllIIIllIl.registerB("Render", true);
        llIllllIIIllIl.rainbow = llIllllIIIllIl.registerB("Rainbow", false);
        llIllllIIIllIl.red = llIllllIIIllIl.registerI("Red", 0, 1, 255);
        llIllllIIIllIl.green = llIllllIIIllIl.registerI("Green", 0, 1, 255);
        llIllllIIIllIl.blue = llIllllIIIllIl.registerI("Blue", 255, 1, 255);
        llIllllIIIllIl.alpha = llIllllIIIllIl.registerI("Alpha", 26, 26, 255);
        llIllllIIIllIl.w = llIllllIIIllIl.registerI("Width", 1, 1, 5);
    }

    public PacketMine() {
        super("PacketMine", Module.Category.PLAYER, "PacketMine");
        PacketMine llIllllIIlIIII;
        llIllllIIlIIII.OnPlayerUpdate = new Listener<EventPlayerMotionUpdate>(llIlllIllIlIlI -> {
            if (llIlllIllIlIlI.getEra() != ImpactPlusEvent.Era.PRE) {
                return;
            }
            if (PacketMine.mc.theWorld == null || PacketMine.mc.thePlayer == null) {
                return;
            }
            PacketMine.mc.playerController.blockHitDelay = 0;
        }, new Predicate[0]);
        llIllllIIlIIII.damageBlock = new Listener<DamageBlockEvent>(llIlllIllIllIl -> {
            PacketMine llIlllIlllIIII;
            if (PacketMine.mc.theWorld == null || PacketMine.mc.thePlayer == null) {
                return;
            }
            if (PacketMine.mc.theWorld.getBlockState(llIlllIllIllIl.getPos()).getBlock() == Blocks.portal) {
                return;
            }
            if (llIlllIlllIIII.canBreak(llIlllIllIllIl.getPos()) && llIlllIlllIIII.pos2 == null) {
                llIlllIlllIIII.pos2 = llIlllIllIllIl.getPos();
                PacketMine.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
                PacketMine.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llIlllIllIllIl.getPos(), llIlllIllIllIl.getFacing()));
                PacketMine.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, llIlllIllIllIl.getPos(), llIlllIllIllIl.getFacing()));
            }
        }, new Predicate[0]);
    }
}

