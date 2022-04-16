/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockDoublePlant
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 */
package me.axua.impactplus.module.modules.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class LawnMower
extends Module {
    public /* synthetic */ Setting.i range;

    public static double GetDistance(double lIIllIlIllllII, double lIIllIlIlIlIIl, double lIIllIlIlIIlll, double lIIllIlIlllIII, double lIIllIlIllIllI, double lIIllIlIlIIIIl) {
        double lIIllIlIllIIlI = lIIllIlIllllII - lIIllIlIlllIII;
        double lIIllIlIllIIIl = lIIllIlIlIlIIl - lIIllIlIllIllI;
        double lIIllIlIlIllll = lIIllIlIlIIlll - lIIllIlIlIIIIl;
        return MathHelper.sqrt_double((double)(lIIllIlIllIIlI * lIIllIlIllIIlI + lIIllIlIllIIIl * lIIllIlIllIIIl + lIIllIlIlIllll * lIIllIlIlIllll));
    }

    public static double[] calculateLookAt(double lIIllIIllIlIll, double lIIllIIlllIlII, double lIIllIIlllIIll, EntityPlayer lIIllIIllIIlll) {
        double lIIllIIlllIIIl = lIIllIIllIIlll.posX - lIIllIIllIlIll;
        double lIIllIIlllIIII = lIIllIIllIIlll.posY - lIIllIIlllIlII;
        double lIIllIIllIllll = lIIllIIllIIlll.posZ - lIIllIIlllIIll;
        double lIIllIIllIlllI = Math.sqrt(lIIllIIlllIIIl * lIIllIIlllIIIl + lIIllIIlllIIII * lIIllIIlllIIII + lIIllIIllIllll * lIIllIIllIllll);
        double lIIllIIllIllIl = Math.asin(lIIllIIlllIIII /= lIIllIIllIlllI);
        double lIIllIIllIllII = Math.atan2(lIIllIIllIllll /= lIIllIIllIlllI, lIIllIIlllIIIl /= lIIllIIllIlllI);
        lIIllIIllIllIl = lIIllIIllIllIl * 180.0 / Math.PI;
        lIIllIIllIllII = lIIllIIllIllII * 180.0 / Math.PI;
        return new double[]{lIIllIIllIllII += 90.0, lIIllIIllIllIl};
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(LawnMower.mc.thePlayer.posX), Math.floor(LawnMower.mc.thePlayer.posY), Math.floor(LawnMower.mc.thePlayer.posZ));
    }

    public LawnMower() {
        super("LawnMower", Module.Category.MISC);
        LawnMower lIIlllIlllIIll;
    }

    private boolean IsValidBlockPos(BlockPos lIIllIlllIIIIl) {
        IBlockState lIIllIllIlllll = LawnMower.mc.theWorld.getBlockState(lIIllIlllIIIIl);
        return lIIllIllIlllll.getBlock() instanceof BlockTallGrass || lIIllIllIlllll.getBlock() instanceof BlockDoublePlant || lIIllIllIlllll.getBlock() instanceof BlockFlower;
    }

    @Override
    public void setup() {
        LawnMower lIIlllIllIIlll;
        lIIlllIllIIlll.range = lIIlllIllIIlll.registerI("Range", 5, 1, 10);
    }

    public static void PacketFacePitchAndYaw(float lIIllIIIIIIlll, float lIIllIIIIIllIl) {
        boolean lIIllIIIIIlIIl;
        boolean lIIllIIIIIlIll = LawnMower.mc.thePlayer.isSprinting();
        if (lIIllIIIIIlIll != LawnMower.mc.thePlayer.serverSprintState) {
            if (lIIllIIIIIlIll) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)LawnMower.mc.thePlayer, CPacketEntityAction.Action.START_SPRINTING));
            } else {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)LawnMower.mc.thePlayer, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            LawnMower.mc.thePlayer.serverSprintState = lIIllIIIIIlIll;
        }
        if ((lIIllIIIIIlIIl = LawnMower.mc.thePlayer.isSneaking()) != LawnMower.mc.thePlayer.serverSneakState) {
            if (lIIllIIIIIlIIl) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)LawnMower.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            } else {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)LawnMower.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            LawnMower.mc.thePlayer.serverSneakState = lIIllIIIIIlIIl;
        }
        if (mc.getRenderViewEntity() == LawnMower.mc.thePlayer) {
            boolean lIIllIIIIlIIIl;
            float lIIllIIIIlllll = lIIllIIIIIIlll;
            float lIIllIIIIlllIl = lIIllIIIIIllIl;
            AxisAlignedBB lIIllIIIIlllII = LawnMower.mc.thePlayer.getEntityBoundingBox();
            double lIIllIIIIllIlI = LawnMower.mc.thePlayer.posX - LawnMower.mc.thePlayer.lastReportedPosX;
            double lIIllIIIIllIIl = lIIllIIIIlllII.minY - LawnMower.mc.thePlayer.lastReportedPosY;
            double lIIllIIIIlIlll = LawnMower.mc.thePlayer.posZ - LawnMower.mc.thePlayer.lastReportedPosZ;
            double lIIllIIIIlIllI = lIIllIIIIlllIl - LawnMower.mc.thePlayer.lastReportedYaw;
            double lIIllIIIIlIlII = lIIllIIIIlllll - LawnMower.mc.thePlayer.lastReportedPitch;
            ++LawnMower.mc.thePlayer.positionUpdateTicks;
            boolean lIIllIIIIlIIll = lIIllIIIIllIlI * lIIllIIIIllIlI + lIIllIIIIllIIl * lIIllIIIIllIIl + lIIllIIIIlIlll * lIIllIIIIlIlll > 9.0E-4 || LawnMower.mc.thePlayer.positionUpdateTicks >= 20;
            boolean bl = lIIllIIIIlIIIl = lIIllIIIIlIllI != 0.0 || lIIllIIIIlIlII != 0.0;
            if (LawnMower.mc.thePlayer.func_184218_aH()) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.PositionRotation(LawnMower.mc.thePlayer.motionX, -999.0, LawnMower.mc.thePlayer.motionZ, lIIllIIIIlllIl, lIIllIIIIlllll, LawnMower.mc.thePlayer.onGround));
                lIIllIIIIlIIll = false;
            } else if (lIIllIIIIlIIll && lIIllIIIIlIIIl) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.PositionRotation(LawnMower.mc.thePlayer.posX, lIIllIIIIlllII.minY, LawnMower.mc.thePlayer.posZ, lIIllIIIIlllIl, lIIllIIIIlllll, LawnMower.mc.thePlayer.onGround));
            } else if (lIIllIIIIlIIll) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(LawnMower.mc.thePlayer.posX, lIIllIIIIlllII.minY, LawnMower.mc.thePlayer.posZ, LawnMower.mc.thePlayer.onGround));
            } else if (lIIllIIIIlIIIl) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(lIIllIIIIlllIl, lIIllIIIIlllll, LawnMower.mc.thePlayer.onGround));
            } else if (LawnMower.mc.thePlayer.field_184841_cd != LawnMower.mc.thePlayer.onGround) {
                LawnMower.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer(LawnMower.mc.thePlayer.onGround));
            }
            if (lIIllIIIIlIIll) {
                LawnMower.mc.thePlayer.lastReportedPosX = LawnMower.mc.thePlayer.posX;
                LawnMower.mc.thePlayer.lastReportedPosY = lIIllIIIIlllII.minY;
                LawnMower.mc.thePlayer.lastReportedPosZ = LawnMower.mc.thePlayer.posZ;
                LawnMower.mc.thePlayer.positionUpdateTicks = 0;
            }
            if (lIIllIIIIlIIIl) {
                LawnMower.mc.thePlayer.lastReportedYaw = lIIllIIIIlllIl;
                LawnMower.mc.thePlayer.lastReportedPitch = lIIllIIIIlllll;
            }
            LawnMower.mc.thePlayer.field_184841_cd = LawnMower.mc.thePlayer.onGround;
            LawnMower.mc.thePlayer.field_189811_cr = LawnMower.mc.thePlayer.mc.gameSettings.field_189989_R;
        }
    }

    public List<BlockPos> getSphere(BlockPos lIIlllIIIIIIIl, float lIIlllIIIIIIII, int lIIlllIIIIlIIl, boolean lIIlllIIIIlIII, boolean lIIlllIIIIIlll, int lIIllIllllllII) {
        ArrayList<BlockPos> lIIlllIIIIIlIl = new ArrayList<BlockPos>();
        int lIIlllIIIIIlII = lIIlllIIIIIIIl.getX();
        int lIIlllIIIIIIll = lIIlllIIIIIIIl.getY();
        int lIIlllIIIIIIlI = lIIlllIIIIIIIl.getZ();
        int lIIlllIIIIllIl = lIIlllIIIIIlII - (int)lIIlllIIIIIIII;
        while ((float)lIIlllIIIIllIl <= (float)lIIlllIIIIIlII + lIIlllIIIIIIII) {
            int lIIlllIIIIlllI = lIIlllIIIIIIlI - (int)lIIlllIIIIIIII;
            while ((float)lIIlllIIIIlllI <= (float)lIIlllIIIIIIlI + lIIlllIIIIIIII) {
                int lIIlllIIIIllll = lIIlllIIIIIlll ? lIIlllIIIIIIll - (int)lIIlllIIIIIIII : lIIlllIIIIIIll;
                while (true) {
                    float f = lIIlllIIIIllll;
                    float f2 = lIIlllIIIIIlll ? (float)lIIlllIIIIIIll + lIIlllIIIIIIII : (float)(lIIlllIIIIIIll + lIIlllIIIIlIIl);
                    if (!(f < f2)) break;
                    double lIIlllIIIlIIII = (lIIlllIIIIIlII - lIIlllIIIIllIl) * (lIIlllIIIIIlII - lIIlllIIIIllIl) + (lIIlllIIIIIIlI - lIIlllIIIIlllI) * (lIIlllIIIIIIlI - lIIlllIIIIlllI) + (lIIlllIIIIIlll ? (lIIlllIIIIIIll - lIIlllIIIIllll) * (lIIlllIIIIIIll - lIIlllIIIIllll) : 0);
                    if (!(!(lIIlllIIIlIIII < (double)(lIIlllIIIIIIII * lIIlllIIIIIIII)) || lIIlllIIIIlIII && lIIlllIIIlIIII < (double)((lIIlllIIIIIIII - 1.0f) * (lIIlllIIIIIIII - 1.0f)))) {
                        BlockPos lIIlllIIIlIIIl = new BlockPos(lIIlllIIIIllIl, lIIlllIIIIllll + lIIllIllllllII, lIIlllIIIIlllI);
                        lIIlllIIIIIlIl.add(lIIlllIIIlIIIl);
                    }
                    ++lIIlllIIIIllll;
                }
                ++lIIlllIIIIlllI;
            }
            ++lIIlllIIIIllIl;
        }
        return lIIlllIIIIIlIl;
    }

    public static double GetDistanceOfEntityToBlock(Entity lIIllIlIIllIIl, BlockPos lIIllIlIIllIII) {
        return LawnMower.GetDistance(lIIllIlIIllIIl.posX, lIIllIlIIllIIl.posY, lIIllIlIIllIIl.posZ, lIIllIlIIllIII.getX(), lIIllIlIIllIII.getY(), lIIllIlIIllIII.getZ());
    }

    @Override
    public void onUpdate() {
        LawnMower lIIlllIlIIIIll;
        BlockPos lIIlllIlIIIlIl = lIIlllIlIIIIll.getSphere(LawnMower.getPlayerPos(), lIIlllIlIIIIll.range.getValue(), lIIlllIlIIIIll.range.getValue(), false, true, 0).stream().filter(lIIlIllllIIlIl -> {
            LawnMower lIIlIllllIlIIl;
            return lIIlIllllIlIIl.IsValidBlockPos((BlockPos)lIIlIllllIIlIl);
        }).min(Comparator.comparing(lIIlIlllllIlIl -> LawnMower.GetDistanceOfEntityToBlock((Entity)LawnMower.mc.thePlayer, lIIlIlllllIlIl))).orElse(null);
        if (lIIlllIlIIIlIl != null) {
            double[] lIIlllIlIIlIIl = LawnMower.calculateLookAt((double)lIIlllIlIIIlIl.getX() + 0.5, (double)lIIlllIlIIIlIl.getY() - 0.5, (double)lIIlllIlIIIlIl.getZ() + 0.5, (EntityPlayer)LawnMower.mc.thePlayer);
            LawnMower.PacketFacePitchAndYaw((float)lIIlllIlIIlIIl[1], (float)lIIlllIlIIlIIl[0]);
            LawnMower.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            LawnMower.mc.playerController.clickBlock(lIIlllIlIIIlIl, EnumFacing.UP);
        }
    }
}

