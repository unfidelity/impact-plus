/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package me.axua.impactplus.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class BlockInteractionHelper {
    private static final /* synthetic */ Minecraft mc;
    public static final /* synthetic */ List<Block> blackList;
    public static final /* synthetic */ List<Block> shulkerList;

    private static PlayerControllerMP getPlayerController() {
        return Minecraft.getMinecraft().playerController;
    }

    public static boolean canBeClicked(BlockPos llllIIIllIIlIIl) {
        return BlockInteractionHelper.getBlock(llllIIIllIIlIIl).canCollideCheck(BlockInteractionHelper.getState(llllIIIllIIlIIl), false);
    }

    public static void faceVectorPacketInstant(Vec3d llllIIIllIllIII) {
        float[] llllIIIllIlIlll = BlockInteractionHelper.getLegitRotations(llllIIIllIllIII);
        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(llllIIIllIlIlll[0], llllIIIllIlIlll[1], Minecraft.getMinecraft().thePlayer.onGround));
    }

    public static ValidResult valid(BlockPos llllIIIIlllIlII) {
        if (!BlockInteractionHelper.mc.theWorld.checkNoEntityCollision(new AxisAlignedBB(llllIIIIlllIlII))) {
            return ValidResult.NoEntityCollision;
        }
        IBlockState llllIIIIlllIlIl = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIlllIlII);
        if (llllIIIIlllIlIl.getBlock() == Blocks.air) {
            BlockPos[] llllIIIIlllIlll;
            for (BlockPos llllIIIIllllIII : llllIIIIlllIlll = new BlockPos[]{llllIIIIlllIlII.north(), llllIIIIlllIlII.south(), llllIIIIlllIlII.east(), llllIIIIlllIlII.west(), llllIIIIlllIlII.up(), llllIIIIlllIlII.down()}) {
                IBlockState llllIIIIllllIIl = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIllllIII);
                if (llllIIIIllllIIl.getBlock() == Blocks.air) continue;
                for (EnumFacing llllIIIIllllIlI : EnumFacing.values()) {
                    BlockPos llllIIIIllllIll = llllIIIIlllIlII.offset(llllIIIIllllIlI);
                    boolean llllIIIIllIIlll = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIllllIll).getBlock() == Blocks.water;
                }
            }
            return ValidResult.NoNeighbors;
        }
        return ValidResult.AlreadyBlockThere;
    }

    public static float[] getLegitRotations(Vec3d llllIIIlllIIIlI) {
        Vec3d llllIIIlllIlIIl = BlockInteractionHelper.getEyesPos();
        double llllIIIlllIlIII = llllIIIlllIIIlI.xCoord - llllIIIlllIlIIl.xCoord;
        double llllIIIlllIIlll = llllIIIlllIIIlI.yCoord - llllIIIlllIlIIl.yCoord;
        double llllIIIlllIIllI = llllIIIlllIIIlI.zCoord - llllIIIlllIlIIl.zCoord;
        double llllIIIlllIIlIl = Math.sqrt(llllIIIlllIlIII * llllIIIlllIlIII + llllIIIlllIIllI * llllIIIlllIIllI);
        float llllIIIlllIIlII = (float)Math.toDegrees(Math.atan2(llllIIIlllIIllI, llllIIIlllIlIII)) - 90.0f;
        float llllIIIlllIIIll = (float)(-Math.toDegrees(Math.atan2(llllIIIlllIIlll, llllIIIlllIIlIl)));
        return new float[]{Minecraft.getMinecraft().thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float((float)(llllIIIlllIIlII - Minecraft.getMinecraft().thePlayer.rotationYaw)), Minecraft.getMinecraft().thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float((float)(llllIIIlllIIIll - Minecraft.getMinecraft().thePlayer.rotationPitch))};
    }

    public static boolean hasNeighbour(BlockPos llllIIIlIlllIlI) {
        for (EnumFacing llllIIIlIlllIll : EnumFacing.values()) {
            BlockPos llllIIIlIllllII = llllIIIlIlllIlI.offset(llllIIIlIlllIll);
            if (Minecraft.getMinecraft().theWorld.getBlockState(llllIIIlIllllII).func_185904_a().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static List<BlockPos> getSphere(BlockPos llllIIIlIIlIlll, float llllIIIlIIlIllI, int llllIIIlIIlllll, boolean llllIIIlIIllllI, boolean llllIIIlIIlIIll, int llllIIIlIIlllII) {
        ArrayList<BlockPos> llllIIIlIIllIll = new ArrayList<BlockPos>();
        int llllIIIlIIllIlI = llllIIIlIIlIlll.getX();
        int llllIIIlIIllIIl = llllIIIlIIlIlll.getY();
        int llllIIIlIIllIII = llllIIIlIIlIlll.getZ();
        int llllIIIlIlIIIlI = llllIIIlIIllIlI - (int)llllIIIlIIlIllI;
        while ((float)llllIIIlIlIIIlI <= (float)llllIIIlIIllIlI + llllIIIlIIlIllI) {
            int llllIIIlIlIIIll = llllIIIlIIllIII - (int)llllIIIlIIlIllI;
            while ((float)llllIIIlIlIIIll <= (float)llllIIIlIIllIII + llllIIIlIIlIllI) {
                int llllIIIlIlIIlII = llllIIIlIIlIIll ? llllIIIlIIllIIl - (int)llllIIIlIIlIllI : llllIIIlIIllIIl;
                while (true) {
                    float f = llllIIIlIlIIlII;
                    float f2 = llllIIIlIIlIIll ? (float)llllIIIlIIllIIl + llllIIIlIIlIllI : (float)(llllIIIlIIllIIl + llllIIIlIIlllll);
                    if (!(f < f2)) break;
                    double llllIIIlIlIIlIl = (llllIIIlIIllIlI - llllIIIlIlIIIlI) * (llllIIIlIIllIlI - llllIIIlIlIIIlI) + (llllIIIlIIllIII - llllIIIlIlIIIll) * (llllIIIlIIllIII - llllIIIlIlIIIll) + (llllIIIlIIlIIll ? (llllIIIlIIllIIl - llllIIIlIlIIlII) * (llllIIIlIIllIIl - llllIIIlIlIIlII) : 0);
                    if (!(!(llllIIIlIlIIlIl < (double)(llllIIIlIIlIllI * llllIIIlIIlIllI)) || llllIIIlIIllllI && llllIIIlIlIIlIl < (double)((llllIIIlIIlIllI - 1.0f) * (llllIIIlIIlIllI - 1.0f)))) {
                        llllIIIlIIllIll.add(new BlockPos(llllIIIlIlIIIlI, llllIIIlIlIIlII + llllIIIlIIlllII, llllIIIlIlIIIll));
                    }
                    ++llllIIIlIlIIlII;
                }
                ++llllIIIlIlIIIll;
            }
            ++llllIIIlIlIIIlI;
        }
        return llllIIIlIIllIll;
    }

    private static IBlockState getState(BlockPos llllIIIllIIIIll) {
        return Minecraft.getMinecraft().theWorld.getBlockState(llllIIIllIIIIll);
    }

    private static Block getBlock(BlockPos llllIIIllIIIlll) {
        return BlockInteractionHelper.getState(llllIIIllIIIlll).getBlock();
    }

    private static Vec3d getEyesPos() {
        return new Vec3d(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight(), Minecraft.getMinecraft().thePlayer.posZ);
    }

    public static boolean IsLiquidOrAir(BlockPos llllIIIIllIIIlI) {
        IBlockState llllIIIIllIIIll = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIllIIIlI);
        return llllIIIIllIIIll.getBlock() == Blocks.water || llllIIIIllIIIll.getBlock() == Blocks.lava || llllIIIIllIIIll.getBlock() == Blocks.air;
    }

    public static PlaceResult place(BlockPos llllIIIIIllllIl, float llllIIIIlIIIlII, boolean llllIIIIlIIIIll, boolean llllIIIIIlllIlI) {
        IBlockState llllIIIIlIIIIIl = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIIllllIl);
        boolean llllIIIIlIIIIII = llllIIIIlIIIIIl.func_185904_a().isReplaceable();
        boolean llllIIIIIllllll = llllIIIIlIIIIIl.getBlock() instanceof BlockSlab;
        if (!llllIIIIlIIIIII && !llllIIIIIllllll) {
            return PlaceResult.NotReplaceable;
        }
        if (llllIIIIIlllIlI && llllIIIIIllllll && !llllIIIIlIIIIIl.func_185917_h()) {
            return PlaceResult.CantPlace;
        }
        Vec3d llllIIIIIlllllI = new Vec3d(BlockInteractionHelper.mc.thePlayer.posX, BlockInteractionHelper.mc.thePlayer.posY + (double)BlockInteractionHelper.mc.thePlayer.getEyeHeight(), BlockInteractionHelper.mc.thePlayer.posZ);
        for (EnumFacing llllIIIIlIIIllI : EnumFacing.values()) {
            EnumActionResult llllIIIIlIIlIll;
            Vec3d llllIIIIlIIlIlI;
            boolean llllIIIIlIIIlll;
            BlockPos llllIIIIlIIlIIl = llllIIIIIllllIl.offset(llllIIIIlIIIllI);
            EnumFacing llllIIIIlIIlIII = llllIIIIlIIIllI.getOpposite();
            boolean bl = llllIIIIlIIIlll = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIlIIlIIl).getBlock() == Blocks.water;
            if (!BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIlIIlIIl).getBlock().canCollideCheck(BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIlIIlIIl), false) || !(llllIIIIIlllllI.distanceTo(llllIIIIlIIlIlI = new Vec3d((Vec3i)llllIIIIlIIlIIl).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllIIIIlIIlIII.getDirectionVec()).func_186678_a(0.5))) <= (double)llllIIIIlIIIlII)) continue;
            Block llllIIIIlIIllIl = BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIlIIlIIl).getBlock();
            boolean llllIIIIlIIllII = llllIIIIlIIllIl.onBlockActivated((World)BlockInteractionHelper.mc.theWorld, llllIIIIIllllIl, BlockInteractionHelper.mc.theWorld.getBlockState(llllIIIIIllllIl), (EntityPlayer)BlockInteractionHelper.mc.thePlayer, EnumHand.MAIN_HAND, llllIIIIlIIIllI, 0.0f, 0.0f, 0.0f);
            if (blackList.contains(llllIIIIlIIllIl) || shulkerList.contains(llllIIIIlIIllIl) || llllIIIIlIIllII) {
                BlockInteractionHelper.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)BlockInteractionHelper.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (llllIIIIlIIIIll) {
                BlockInteractionHelper.faceVectorPacketInstant(llllIIIIlIIlIlI);
            }
            if ((llllIIIIlIIlIll = BlockInteractionHelper.mc.playerController.func_187099_a(BlockInteractionHelper.mc.thePlayer, BlockInteractionHelper.mc.theWorld, llllIIIIlIIlIIl, llllIIIIlIIlIII, llllIIIIlIIlIlI, EnumHand.MAIN_HAND)) == EnumActionResult.FAIL) continue;
            BlockInteractionHelper.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            if (llllIIIIlIIllII) {
                BlockInteractionHelper.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)BlockInteractionHelper.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            return PlaceResult.Placed;
        }
        return PlaceResult.CantPlace;
    }

    public BlockInteractionHelper() {
        BlockInteractionHelper llllIIlIIllllIl;
    }

    private static void processRightClickBlock(BlockPos llllIIIllIIlllI, EnumFacing llllIIIllIlIIII, Vec3d llllIIIllIIllII) {
        BlockInteractionHelper.getPlayerController().func_187099_a(Minecraft.getMinecraft().thePlayer, BlockInteractionHelper.mc.theWorld, llllIIIllIIlllI, llllIIIllIlIIII, llllIIIllIIllII, EnumHand.MAIN_HAND);
    }

    static {
        blackList = Arrays.asList(Blocks.ender_chest, Blocks.chest, Blocks.trapped_chest, Blocks.crafting_table, Blocks.anvil, Blocks.brewing_stand, Blocks.hopper, Blocks.dropper, Blocks.dispenser, Blocks.trapdoor, Blocks.enchanting_table);
        shulkerList = Arrays.asList(Blocks.field_190977_dl, Blocks.field_190978_dm, Blocks.field_190979_dn, Blocks.field_190980_do, Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA);
        mc = Minecraft.getMinecraft();
    }

    public static void placeBlockScaffold(BlockPos llllIIlIIIIlIIl) {
        Vec3d llllIIlIIIIlIII = new Vec3d(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight(), Minecraft.getMinecraft().thePlayer.posZ);
        for (EnumFacing llllIIlIIIIlIlI : EnumFacing.values()) {
            Vec3d llllIIlIIIIlIll;
            BlockPos llllIIlIIIIllIl = llllIIlIIIIlIIl.offset(llllIIlIIIIlIlI);
            EnumFacing llllIIlIIIIllII = llllIIlIIIIlIlI.getOpposite();
            if (!BlockInteractionHelper.canBeClicked(llllIIlIIIIllIl) || llllIIlIIIIlIII.squareDistanceTo(llllIIlIIIIlIll = new Vec3d((Vec3i)llllIIlIIIIllIl).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllIIlIIIIllII.getDirectionVec()).func_186678_a(0.5))) > 18.0625) continue;
            BlockInteractionHelper.faceVectorPacketInstant(llllIIlIIIIlIll);
            BlockInteractionHelper.processRightClickBlock(llllIIlIIIIllIl, llllIIlIIIIllII, llllIIlIIIIlIll);
            Minecraft.getMinecraft().thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            BlockInteractionHelper.mc.rightClickDelayTimer = 4;
            return;
        }
    }

    public static enum ValidResult {
        NoEntityCollision,
        AlreadyBlockThere,
        NoNeighbors,
        Ok;


        private ValidResult() {
            ValidResult llllllllllllllllIlIIIllIllIlIIll;
        }
    }

    public static enum PlaceResult {
        NotReplaceable,
        Neighbors,
        CantPlace,
        Placed;


        private PlaceResult() {
            PlaceResult llllllllllllllllllllIIIIllIlIIlI;
        }
    }
}

