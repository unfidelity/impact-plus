/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemBow
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.module.modules.combat;

import me.axua.impactplus.module.Module;
import net.minecraft.item.ItemBow;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.math.BlockPos;

public class FastBow
extends Module {
    public FastBow() {
        super("FastBow", Module.Category.COMBAT, "Spams your bow");
        FastBow llllllllllllllllIIIlIllllIIIIIII;
    }

    @Override
    public void onUpdate() {
        if (FastBow.mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemBow && FastBow.mc.thePlayer.func_184587_cr() && FastBow.mc.thePlayer.func_184612_cw() >= 3) {
            FastBow.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, FastBow.mc.thePlayer.getHorizontalFacing()));
            FastBow.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItem(FastBow.mc.thePlayer.func_184600_cs()));
            FastBow.mc.thePlayer.func_184597_cx();
        }
    }
}

