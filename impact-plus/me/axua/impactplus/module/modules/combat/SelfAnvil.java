/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.combat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.BlockInteractionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class SelfAnvil
extends Module {
    /* synthetic */ Setting.b center;
    private /* synthetic */ List<Block> whiteList;
    /* synthetic */ boolean wasinair;
    /* synthetic */ Setting.mode centermode;
    private /* synthetic */ Vec3d Center;

    @Override
    public void onUpdate() {
        SelfAnvil llllllllllllllllllIIIIlIIllllIlI;
        if (!llllllllllllllllllIIIIlIIllllIlI.isEnabled() || SelfAnvil.mc.thePlayer == null) {
            return;
        }
    }

    @Override
    public void onEnable() {
        SelfAnvil llllllllllllllllllIIIIlIIllIIIIl;
        llllllllllllllllllIIIIlIIllIIIIl.Center = llllllllllllllllllIIIIlIIllIIIIl.GetCenter(SelfAnvil.mc.thePlayer.posX, SelfAnvil.mc.thePlayer.posY, SelfAnvil.mc.thePlayer.posZ);
        if (llllllllllllllllllIIIIlIIllIIIIl.Center != Vec3d.field_186680_a && llllllllllllllllllIIIIlIIllIIIIl.centermode.getValue().equalsIgnoreCase("NCP") && llllllllllllllllllIIIIlIIllIIIIl.center.getValue()) {
            double llllllllllllllllllIIIIlIIllIllIl = Math.abs(llllllllllllllllllIIIIlIIllIIIIl.Center.xCoord - SelfAnvil.mc.thePlayer.posX);
            double llllllllllllllllllIIIIlIIllIllII = Math.abs(llllllllllllllllllIIIIlIIllIIIIl.Center.zCoord - SelfAnvil.mc.thePlayer.posZ);
            if (llllllllllllllllllIIIIlIIllIllIl <= 0.1 && llllllllllllllllllIIIIlIIllIllII <= 0.1) {
                llllllllllllllllllIIIIlIIllIIIIl.Center = Vec3d.field_186680_a;
            } else {
                double llllllllllllllllllIIIIlIIllIllll = llllllllllllllllllIIIIlIIllIIIIl.Center.xCoord - SelfAnvil.mc.thePlayer.posX;
                double llllllllllllllllllIIIIlIIllIlllI = llllllllllllllllllIIIIlIIllIIIIl.Center.zCoord - SelfAnvil.mc.thePlayer.posZ;
                SelfAnvil.mc.thePlayer.motionX = llllllllllllllllllIIIIlIIllIllll / 2.0;
                SelfAnvil.mc.thePlayer.motionZ = llllllllllllllllllIIIIlIIllIlllI / 2.0;
            }
        } else if (llllllllllllllllllIIIIlIIllIIIIl.center.getValue()) {
            SelfAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(llllllllllllllllllIIIIlIIllIIIIl.Center.xCoord, llllllllllllllllllIIIIlIIllIIIIl.Center.yCoord, llllllllllllllllllIIIIlIIllIIIIl.Center.zCoord, true));
            SelfAnvil.mc.thePlayer.setPosition(llllllllllllllllllIIIIlIIllIIIIl.Center.xCoord, llllllllllllllllllIIIIlIIllIIIIl.Center.yCoord, llllllllllllllllllIIIIlIIllIIIIl.Center.zCoord);
        }
        llllllllllllllllllIIIIlIIllIIIIl.wasinair = !SelfAnvil.mc.thePlayer.onGround;
        Vec3d llllllllllllllllllIIIIlIIllIIlll = Surround.getInterpolatedPos((Entity)SelfAnvil.mc.thePlayer, 0.0f);
        BlockPos llllllllllllllllllIIIIlIIllIIllI = new BlockPos(llllllllllllllllllIIIIlIIllIIlll);
        BlockPos llllllllllllllllllIIIIlIIllIIlIl = llllllllllllllllllIIIIlIIllIIllI.add(0, 1, 0);
        BlockPos llllllllllllllllllIIIIlIIllIIlII = llllllllllllllllllIIIIlIIllIIllI.add(0, 2, 0);
        if (SelfAnvil.mc.theWorld.getBlockState(llllllllllllllllllIIIIlIIllIIlII).getBlock() != Blocks.air) {
            Command.sendClientMessage("Cannot place anvil!");
            llllllllllllllllllIIIIlIIllIIIIl.disable();
            return;
        }
        int llllllllllllllllllIIIIlIIllIIIll = SelfAnvil.mc.thePlayer.inventory.currentItem;
        int llllllllllllllllllIIIIlIIllIIIlI = -1;
        for (int llllllllllllllllllIIIIlIIllIlIIl = 0; llllllllllllllllllIIIIlIIllIlIIl < 9; ++llllllllllllllllllIIIIlIIllIlIIl) {
            Block llllllllllllllllllIIIIlIIllIlIlI;
            ItemStack llllllllllllllllllIIIIlIIllIlIll = SelfAnvil.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllllIIIIlIIllIlIIl);
            if (llllllllllllllllllIIIIlIIllIlIll == ItemStack.field_190927_a || !(llllllllllllllllllIIIIlIIllIlIll.getItem() instanceof ItemBlock) || !llllllllllllllllllIIIIlIIllIIIIl.whiteList.contains(llllllllllllllllllIIIIlIIllIlIlI = ((ItemBlock)llllllllllllllllllIIIIlIIllIlIll.getItem()).getBlock())) continue;
            llllllllllllllllllIIIIlIIllIIIlI = llllllllllllllllllIIIIlIIllIlIIl;
            break;
        }
        if (llllllllllllllllllIIIIlIIllIIIlI == -1) {
            Command.sendClientMessage("No anvils in hotbar");
            llllllllllllllllllIIIIlIIllIIIIl.disable();
            return;
        }
        SelfAnvil.mc.thePlayer.inventory.currentItem = llllllllllllllllllIIIIlIIllIIIlI;
        SelfAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)SelfAnvil.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
        llllllllllllllllllIIIIlIIllIIIIl.placeBlock(new BlockPos((Vec3i)llllllllllllllllllIIIIlIIllIIlIl), EnumFacing.UP);
        SelfAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)SelfAnvil.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
        SelfAnvil.mc.thePlayer.inventory.currentItem = llllllllllllllllllIIIIlIIllIIIll;
        llllllllllllllllllIIIIlIIllIIIIl.disable();
    }

    @Override
    public void setup() {
        SelfAnvil llllllllllllllllllIIIIlIlIIlIIIl;
        ArrayList<String> llllllllllllllllllIIIIlIlIIlIIlI = new ArrayList<String>();
        llllllllllllllllllIIIIlIlIIlIIlI.add("TP");
        llllllllllllllllllIIIIlIlIIlIIlI.add("NCP");
        llllllllllllllllllIIIIlIlIIlIIIl.center = llllllllllllllllllIIIIlIlIIlIIIl.registerB("Center", true);
        llllllllllllllllllIIIIlIlIIlIIIl.centermode = llllllllllllllllllIIIIlIlIIlIIIl.registerMode("CenterMode", llllllllllllllllllIIIIlIlIIlIIlI, "NCP");
    }

    private void placeBlock(BlockPos llllllllllllllllllIIIIlIIlIIllII, EnumFacing llllllllllllllllllIIIIlIIlIlIIII) {
        BlockPos llllllllllllllllllIIIIlIIlIIllll = llllllllllllllllllIIIIlIIlIIllII.offset(llllllllllllllllllIIIIlIIlIlIIII);
        EnumFacing llllllllllllllllllIIIIlIIlIIlllI = llllllllllllllllllIIIIlIIlIlIIII.getOpposite();
        Vec3d llllllllllllllllllIIIIlIIlIIllIl = new Vec3d((Vec3i)llllllllllllllllllIIIIlIIlIIllll).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllllllllllllllllIIIIlIIlIIlllI.getDirectionVec()).func_186678_a(0.5));
        BlockInteractionHelper.faceVectorPacketInstant(llllllllllllllllllIIIIlIIlIIllIl);
        SelfAnvil.mc.playerController.func_187099_a(SelfAnvil.mc.thePlayer, SelfAnvil.mc.theWorld, llllllllllllllllllIIIIlIIlIIllll, llllllllllllllllllIIIIlIIlIIlllI, llllllllllllllllllIIIIlIIlIIllIl, EnumHand.MAIN_HAND);
        SelfAnvil.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
    }

    public Vec3d GetCenter(double llllllllllllllllllIIIIlIlIIIIIlI, double llllllllllllllllllIIIIlIlIIIIlll, double llllllllllllllllllIIIIlIlIIIIIII) {
        double llllllllllllllllllIIIIlIlIIIIlIl = Math.floor(llllllllllllllllllIIIIlIlIIIIIlI) + 0.5;
        double llllllllllllllllllIIIIlIlIIIIlII = Math.floor(llllllllllllllllllIIIIlIlIIIIlll);
        double llllllllllllllllllIIIIlIlIIIIIll = Math.floor(llllllllllllllllllIIIIlIlIIIIIII) + 0.5;
        return new Vec3d(llllllllllllllllllIIIIlIlIIIIlIl, llllllllllllllllllIIIIlIlIIIIlII, llllllllllllllllllIIIIlIlIIIIIll);
    }

    public SelfAnvil() {
        super("SelfAnvil", Module.Category.COMBAT);
        SelfAnvil llllllllllllllllllIIIIlIlIIlIlll;
        llllllllllllllllllIIIIlIlIIlIlll.wasinair = false;
        llllllllllllllllllIIIIlIlIIlIlll.Center = Vec3d.field_186680_a;
        llllllllllllllllllIIIIlIlIIlIlll.whiteList = Arrays.asList(Blocks.anvil);
    }
}

