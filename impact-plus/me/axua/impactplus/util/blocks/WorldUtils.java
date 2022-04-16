/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.util.blocks;

import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class WorldUtils {
    private static /* synthetic */ Minecraft mc;
    public static /* synthetic */ List<Block> rightclickableBlocks;
    public static /* synthetic */ List<Block> emptyBlocks;

    public static void openBlock(BlockPos llllllllllllllllIllIIIllIlIIIIIl) {
        for (EnumFacing llllllllllllllllIllIIIllIlIIIIll : EnumFacing.values()) {
            Block llllllllllllllllIllIIIllIlIIIlII = WorldUtils.mc.theWorld.getBlockState(llllllllllllllllIllIIIllIlIIIIIl.offset(llllllllllllllllIllIIIllIlIIIIll)).getBlock();
            if (!emptyBlocks.contains(llllllllllllllllIllIIIllIlIIIlII)) continue;
            WorldUtils.mc.playerController.func_187099_a(WorldUtils.mc.thePlayer, WorldUtils.mc.theWorld, llllllllllllllllIllIIIllIlIIIIIl, llllllllllllllllIllIIIllIlIIIIll.getOpposite(), new Vec3d((Vec3i)llllllllllllllllIllIIIllIlIIIIIl), EnumHand.MAIN_HAND);
            return;
        }
    }

    public static EnumFacing getClosestFacing(BlockPos llllllllllllllllIllIIIlIlllIIllI) {
        return EnumFacing.DOWN;
    }

    public static boolean isBlockEmpty(BlockPos llllllllllllllllIllIIIlIlllllIII) {
        if (!emptyBlocks.contains(WorldUtils.mc.theWorld.getBlockState(llllllllllllllllIllIIIlIlllllIII).getBlock())) {
            return false;
        }
        AxisAlignedBB llllllllllllllllIllIIIlIllllIlll = new AxisAlignedBB(llllllllllllllllIllIIIlIlllllIII);
        for (Entity llllllllllllllllIllIIIlIlllllIIl : WorldUtils.mc.theWorld.loadedEntityList) {
            if (!(llllllllllllllllIllIIIlIlllllIIl instanceof EntityLivingBase) || !llllllllllllllllIllIIIlIllllIlll.intersectsWith(llllllllllllllllIllIIIlIlllllIIl.getEntityBoundingBox())) continue;
            return false;
        }
        return true;
    }

    public static boolean canPlaceBlock(BlockPos llllllllllllllllIllIIIlIlllIllII) {
        if (!WorldUtils.isBlockEmpty(llllllllllllllllIllIIIlIlllIllII)) {
            return false;
        }
        for (EnumFacing llllllllllllllllIllIIIlIlllIllIl : EnumFacing.values()) {
            if (emptyBlocks.contains(WorldUtils.mc.theWorld.getBlockState(llllllllllllllllIllIIIlIlllIllII.offset(llllllllllllllllIllIIIlIlllIllIl)).getBlock())) continue;
            Vec3d vec3d = new Vec3d((double)llllllllllllllllIllIIIlIlllIllII.getX() + 0.5 + (double)llllllllllllllllIllIIIlIlllIllIl.getFrontOffsetX() * 0.5, (double)llllllllllllllllIllIIIlIlllIllII.getY() + 0.5 + (double)llllllllllllllllIllIIIlIlllIllIl.getFrontOffsetY() * 0.5, (double)llllllllllllllllIllIIIlIlllIllII.getZ() + 0.5 + (double)llllllllllllllllIllIIIlIlllIllIl.getFrontOffsetZ() * 0.5);
            if (!(WorldUtils.mc.thePlayer.getPositionEyes(mc.func_184121_ak()).distanceTo(vec3d) <= 4.25)) continue;
            return true;
        }
        return false;
    }

    public static void rotatePacket(double llllllllllllllllIllIIIlIlIlIllII, double llllllllllllllllIllIIIlIlIlIlIlI, double llllllllllllllllIllIIIlIlIlIlIII) {
        double llllllllllllllllIllIIIlIlIlIIllI = llllllllllllllllIllIIIlIlIlIllII - WorldUtils.mc.thePlayer.posX;
        double llllllllllllllllIllIIIlIlIlIIlIl = llllllllllllllllIllIIIlIlIlIlIlI - (WorldUtils.mc.thePlayer.posY + (double)WorldUtils.mc.thePlayer.getEyeHeight());
        double llllllllllllllllIllIIIlIlIIllllI = llllllllllllllllIllIIIlIlIlIlIII - WorldUtils.mc.thePlayer.posZ;
        double llllllllllllllllIllIIIlIlIIlllII = Math.sqrt(llllllllllllllllIllIIIlIlIlIIllI * llllllllllllllllIllIIIlIlIlIIllI + llllllllllllllllIllIIIlIlIIllllI * llllllllllllllllIllIIIlIlIIllllI);
        float llllllllllllllllIllIIIlIlIIllIll = (float)Math.toDegrees(Math.atan2(llllllllllllllllIllIIIlIlIIllllI, llllllllllllllllIllIIIlIlIlIIllI)) - 90.0f;
        float llllllllllllllllIllIIIlIlIIllIIl = (float)(-Math.toDegrees(Math.atan2(llllllllllllllllIllIIIlIlIlIIlIl, llllllllllllllllIllIIIlIlIIlllII)));
        WorldUtils.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(llllllllllllllllIllIIIlIlIIllIll, llllllllllllllllIllIIIlIlIIllIIl, WorldUtils.mc.thePlayer.onGround));
    }

    static {
        mc = Minecraft.getMinecraft();
        emptyBlocks = Arrays.asList(Blocks.air, Blocks.flowing_lava, Blocks.lava, Blocks.flowing_water, Blocks.water, Blocks.vine, Blocks.snow_layer, Blocks.tallgrass, Blocks.fire);
        rightclickableBlocks = Arrays.asList(Blocks.chest, Blocks.trapped_chest, Blocks.ender_chest, Blocks.field_190977_dl, Blocks.field_190978_dm, Blocks.field_190979_dn, Blocks.field_190980_do, Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA, Blocks.anvil, Blocks.wooden_button, Blocks.stone_button, Blocks.unpowered_comparator, Blocks.unpowered_repeater, Blocks.powered_repeater, Blocks.powered_comparator, Blocks.oak_fence_gate, Blocks.spruce_fence_gate, Blocks.birch_fence_gate, Blocks.jungle_fence_gate, Blocks.dark_oak_fence_gate, Blocks.acacia_fence_gate, Blocks.brewing_stand, Blocks.dispenser, Blocks.dropper, Blocks.lever, Blocks.noteblock, Blocks.jukebox, Blocks.beacon, Blocks.bed, Blocks.furnace, Blocks.oak_door, Blocks.spruce_door, Blocks.birch_door, Blocks.jungle_door, Blocks.acacia_door, Blocks.dark_oak_door, Blocks.cake, Blocks.enchanting_table, Blocks.dragon_egg, Blocks.hopper, Blocks.field_185776_dc, Blocks.command_block, Blocks.field_185777_dd, Blocks.crafting_table);
    }

    public WorldUtils() {
        WorldUtils llllllllllllllllIllIIIllIlIlIlll;
    }

    public static void rotateClient(double llllllllllllllllIllIIIlIllIllIlI, double llllllllllllllllIllIIIlIllIIllII, double llllllllllllllllIllIIIlIllIllIII) {
        double llllllllllllllllIllIIIlIllIlIlll = llllllllllllllllIllIIIlIllIllIlI - WorldUtils.mc.thePlayer.posX;
        double llllllllllllllllIllIIIlIllIlIllI = llllllllllllllllIllIIIlIllIIllII - (WorldUtils.mc.thePlayer.posY + (double)WorldUtils.mc.thePlayer.getEyeHeight());
        double llllllllllllllllIllIIIlIllIlIlIl = llllllllllllllllIllIIIlIllIllIII - WorldUtils.mc.thePlayer.posZ;
        double llllllllllllllllIllIIIlIllIlIlII = Math.sqrt(llllllllllllllllIllIIIlIllIlIlll * llllllllllllllllIllIIIlIllIlIlll + llllllllllllllllIllIIIlIllIlIlIl * llllllllllllllllIllIIIlIllIlIlIl);
        float llllllllllllllllIllIIIlIllIlIIll = (float)Math.toDegrees(Math.atan2(llllllllllllllllIllIIIlIllIlIlIl, llllllllllllllllIllIIIlIllIlIlll)) - 90.0f;
        float llllllllllllllllIllIIIlIllIlIIlI = (float)(-Math.toDegrees(Math.atan2(llllllllllllllllIllIIIlIllIlIllI, llllllllllllllllIllIIIlIllIlIlII)));
        EntityPlayerSP llllllllllllllllIllIIIlIllIlIIIl = WorldUtils.mc.thePlayer;
        llllllllllllllllIllIIIlIllIlIIIl.rotationYaw += MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIllIIIlIllIlIIll - WorldUtils.mc.thePlayer.rotationYaw));
        EntityPlayerSP llllllllllllllllIllIIIlIllIlIIII = WorldUtils.mc.thePlayer;
        llllllllllllllllIllIIIlIllIlIIII.rotationPitch += MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIllIIIlIllIlIIlI - WorldUtils.mc.thePlayer.rotationPitch));
    }

    public static boolean placeBlock(BlockPos llllllllllllllllIllIIIllIIIIlIIl, int llllllllllllllllIllIIIllIIIIlIII, boolean llllllllllllllllIllIIIllIIIIIlll, boolean llllllllllllllllIllIIIllIIIIlIll) {
        if (!WorldUtils.isBlockEmpty(llllllllllllllllIllIIIllIIIIlIIl)) {
            return false;
        }
        int llllllllllllllllIllIIIllIIIIlIlI = -1;
        if (llllllllllllllllIllIIIllIIIIlIII != WorldUtils.mc.thePlayer.inventory.currentItem) {
            llllllllllllllllIllIIIllIIIIlIlI = WorldUtils.mc.thePlayer.inventory.currentItem;
            WorldUtils.mc.thePlayer.inventory.currentItem = llllllllllllllllIllIIIllIIIIlIII;
        }
        for (EnumFacing llllllllllllllllIllIIIllIIIIllll : EnumFacing.values()) {
            Block llllllllllllllllIllIIIllIIIlIIll = WorldUtils.mc.theWorld.getBlockState(llllllllllllllllIllIIIllIIIIlIIl.offset(llllllllllllllllIllIIIllIIIIllll)).getBlock();
            Vec3d llllllllllllllllIllIIIllIIIlIIIl = new Vec3d((double)llllllllllllllllIllIIIllIIIIlIIl.getX() + 0.5 + (double)llllllllllllllllIllIIIllIIIIllll.getFrontOffsetX() * 0.5, (double)llllllllllllllllIllIIIllIIIIlIIl.getY() + 0.5 + (double)llllllllllllllllIllIIIllIIIIllll.getFrontOffsetY() * 0.5, (double)llllllllllllllllIllIIIllIIIIlIIl.getZ() + 0.5 + (double)llllllllllllllllIllIIIllIIIIllll.getFrontOffsetZ() * 0.5);
            if (emptyBlocks.contains(llllllllllllllllIllIIIllIIIlIIll) || !(WorldUtils.mc.thePlayer.getPositionEyes(mc.func_184121_ak()).distanceTo(llllllllllllllllIllIIIllIIIlIIIl) <= 4.25)) continue;
            float[] llllllllllllllllIllIIIllIIIlIlII = new float[]{WorldUtils.mc.thePlayer.rotationYaw, WorldUtils.mc.thePlayer.rotationPitch};
            if (llllllllllllllllIllIIIllIIIIIlll) {
                WorldUtils.rotatePacket(llllllllllllllllIllIIIllIIIlIIIl.xCoord, llllllllllllllllIllIIIllIIIlIIIl.yCoord, llllllllllllllllIllIIIllIIIlIIIl.zCoord);
            }
            if (rightclickableBlocks.contains(llllllllllllllllIllIIIllIIIlIIll)) {
                WorldUtils.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)WorldUtils.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            }
            WorldUtils.mc.playerController.func_187099_a(WorldUtils.mc.thePlayer, WorldUtils.mc.theWorld, llllllllllllllllIllIIIllIIIIlIIl.offset(llllllllllllllllIllIIIllIIIIllll), llllllllllllllllIllIIIllIIIIllll.getOpposite(), new Vec3d((Vec3i)llllllllllllllllIllIIIllIIIIlIIl), EnumHand.MAIN_HAND);
            if (rightclickableBlocks.contains(llllllllllllllllIllIIIllIIIlIIll)) {
                WorldUtils.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)WorldUtils.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (llllllllllllllllIllIIIllIIIIlIll) {
                WorldUtils.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(llllllllllllllllIllIIIllIIIlIlII[0], llllllllllllllllIllIIIllIIIlIlII[1], WorldUtils.mc.thePlayer.onGround));
            }
            if (llllllllllllllllIllIIIllIIIIlIlI != -1) {
                WorldUtils.mc.thePlayer.inventory.currentItem = llllllllllllllllIllIIIllIIIIlIlI;
            }
            return true;
        }
        return false;
    }
}

