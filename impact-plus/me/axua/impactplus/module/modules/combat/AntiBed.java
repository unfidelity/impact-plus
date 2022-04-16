/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
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
package me.axua.impactplus.module.modules.combat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.BlockInteractionHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
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

public class AntiBed
extends Module {
    /* synthetic */ boolean placehead;
    /* synthetic */ Setting.b rotate;
    /* synthetic */ boolean placeface;
    private /* synthetic */ List<Block> whiteList;

    public static Vec3d getInterpolatedPos(Entity llllllllllllllllIIIllIIIIlllIllI, float llllllllllllllllIIIllIIIIlllIlll) {
        return new Vec3d(llllllllllllllllIIIllIIIIlllIllI.lastTickPosX, llllllllllllllllIIIllIIIIlllIllI.lastTickPosY, llllllllllllllllIIIllIIIIlllIllI.lastTickPosZ).add(AntiBed.getInterpolatedAmount(llllllllllllllllIIIllIIIIlllIllI, llllllllllllllllIIIllIIIIlllIlll));
    }

    private void placeBlock(BlockPos llllllllllllllllIIIlIlllllllIllI, EnumFacing llllllllllllllllIIIlIlllllllIlIl) {
        BlockPos llllllllllllllllIIIlIllllllllIIl = llllllllllllllllIIIlIlllllllIllI.offset(llllllllllllllllIIIlIlllllllIlIl);
        EnumFacing llllllllllllllllIIIlIllllllllIII = llllllllllllllllIIIlIlllllllIlIl.getOpposite();
        Vec3d llllllllllllllllIIIlIlllllllIlll = new Vec3d((Vec3i)llllllllllllllllIIIlIllllllllIIl).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllllllllllllllIIIlIllllllllIII.getDirectionVec()).func_186678_a(0.5));
        BlockInteractionHelper.faceVectorPacketInstant(llllllllllllllllIIIlIlllllllIlll);
        AntiBed.mc.playerController.func_187099_a(AntiBed.mc.thePlayer, AntiBed.mc.theWorld, llllllllllllllllIIIlIllllllllIIl, llllllllllllllllIIIlIllllllllIII, llllllllllllllllIIIlIlllllllIlll, EnumHand.MAIN_HAND);
        AntiBed.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
    }

    @Override
    public void setup() {
        AntiBed llllllllllllllllIIIllIIlIIlIIIII;
        llllllllllllllllIIIllIIlIIlIIIII.rotate = llllllllllllllllIIIllIIlIIlIIIII.registerB("Rotate", true);
    }

    private boolean isEntitiesEmpty(BlockPos llllllllllllllllIIIllIIIIIIIIIll) {
        List llllllllllllllllIIIllIIIIIIIIlII = AntiBed.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llllllllllllllllIIIllIIIIIIIIIll)).stream().filter(llllllllllllllllIIIlIllllllIllIl -> !(llllllllllllllllIIIlIllllllIllIl instanceof EntityItem)).filter(llllllllllllllllIIIlIllllllIllll -> !(llllllllllllllllIIIlIllllllIllll instanceof EntityXPOrb)).collect(Collectors.toList());
        return llllllllllllllllIIIllIIIIIIIIlII.isEmpty();
    }

    private static PlayerControllerMP getPlayerController() {
        return AntiBed.mc.playerController;
    }

    public static boolean placeBlockScaffold(BlockPos llllllllllllllllIIIllIIIIlIlIIIl, boolean llllllllllllllllIIIllIIIIlIlIIII) {
        Vec3d llllllllllllllllIIIllIIIIlIlIIlI = new Vec3d(AntiBed.mc.thePlayer.posX, AntiBed.mc.thePlayer.posY + (double)AntiBed.mc.thePlayer.getEyeHeight(), AntiBed.mc.thePlayer.posZ);
        for (EnumFacing llllllllllllllllIIIllIIIIlIlIlIl : EnumFacing.values()) {
            BlockPos llllllllllllllllIIIllIIIIlIllIII = llllllllllllllllIIIllIIIIlIlIIIl.offset(llllllllllllllllIIIllIIIIlIlIlIl);
            EnumFacing llllllllllllllllIIIllIIIIlIlIlll = llllllllllllllllIIIllIIIIlIlIlIl.getOpposite();
            if (!AntiBed.canBeClicked(llllllllllllllllIIIllIIIIlIllIII)) continue;
            Vec3d llllllllllllllllIIIllIIIIlIlIllI = new Vec3d((Vec3i)llllllllllllllllIIIllIIIIlIllIII).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllllllllllllllIIIllIIIIlIlIlll.getDirectionVec()).func_186678_a(0.5));
            if (llllllllllllllllIIIllIIIIlIlIIII) {
                AntiBed.faceVectorPacketInstant(llllllllllllllllIIIllIIIIlIlIllI);
            }
            AntiBed.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AntiBed.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            AntiBed.processRightClickBlock(llllllllllllllllIIIllIIIIlIllIII, llllllllllllllllIIIllIIIIlIlIlll, llllllllllllllllIIIllIIIIlIlIllI);
            AntiBed.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            AntiBed.mc.rightClickDelayTimer = 0;
            AntiBed.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AntiBed.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            return true;
        }
        return false;
    }

    public static Block getBlock(BlockPos llllllllllllllllIIIllIIIIIlllIlI) {
        return AntiBed.getState(llllllllllllllllIIIllIIIIIlllIlI).getBlock();
    }

    public AntiBed() {
        super("AntiBed", Module.Category.COMBAT, "AntiBed");
        AntiBed llllllllllllllllIIIllIIlIIlIlIII;
        llllllllllllllllIIIllIIlIIlIlIII.whiteList = Arrays.asList(Blocks.obsidian);
    }

    public static Vec3d getEyesPos() {
        return new Vec3d(AntiBed.mc.thePlayer.posX, AntiBed.mc.thePlayer.posY + (double)AntiBed.mc.thePlayer.getEyeHeight(), AntiBed.mc.thePlayer.posZ);
    }

    @Override
    public void onLivingEvent() {
        AntiBed llllllllllllllllIIIllIIIllIlIlll;
        if (AntiBed.mc.thePlayer.dimension == 0) {
            return;
        }
        Vec3d llllllllllllllllIIIllIIIlllIlIII = AntiBed.getInterpolatedPos((Entity)AntiBed.mc.thePlayer, 0.0f);
        BlockPos llllllllllllllllIIIllIIIlllIIlll = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).north();
        BlockPos llllllllllllllllIIIllIIIlllIIllI = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).south();
        BlockPos llllllllllllllllIIIllIIIlllIIlIl = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).west();
        BlockPos llllllllllllllllIIIllIIIlllIIlII = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).east();
        IBlockState llllllllllllllllIIIllIIIlllIIIll = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlllIIlll);
        IBlockState llllllllllllllllIIIllIIIlllIIIlI = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlllIIllI);
        IBlockState llllllllllllllllIIIllIIIlllIIIIl = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlllIIlIl);
        IBlockState llllllllllllllllIIIllIIIlllIIIII = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlllIIlII);
        if (llllllllllllllllIIIllIIIlllIIIll.getBlock() == Blocks.air || llllllllllllllllIIIllIIIlllIIIlI.getBlock() == Blocks.air || llllllllllllllllIIIllIIIlllIIIIl.getBlock() == Blocks.air || llllllllllllllllIIIllIIIlllIIIII.getBlock() == Blocks.air) {
            llllllllllllllllIIIllIIIllIlIlll.placeface = false;
            llllllllllllllllIIIllIIIllIlIlll.placehead = false;
            return;
        }
        BlockPos llllllllllllllllIIIllIIIllIlllll = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().north();
        BlockPos llllllllllllllllIIIllIIIllIllllI = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().south();
        BlockPos llllllllllllllllIIIllIIIllIlllIl = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().west();
        BlockPos llllllllllllllllIIIllIIIllIlllII = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().east();
        IBlockState llllllllllllllllIIIllIIIllIllIll = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIllIlllll);
        IBlockState llllllllllllllllIIIllIIIllIllIlI = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIllIllllI);
        IBlockState llllllllllllllllIIIllIIIllIllIIl = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIllIlllIl);
        IBlockState llllllllllllllllIIIllIIIllIllIII = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIllIlllII);
        if (llllllllllllllllIIIllIIIllIllIll.getBlock() == Blocks.bed || llllllllllllllllIIIllIIIllIllIlI.getBlock() == Blocks.bed || llllllllllllllllIIIllIIIllIllIIl.getBlock() == Blocks.bed || llllllllllllllllIIIllIIIllIllIII.getBlock() == Blocks.bed) {
            llllllllllllllllIIIllIIIllIlIlll.placeface = true;
        }
        if (llllllllllllllllIIIllIIIllIlIlll.placeface) {
            BlockPos llllllllllllllllIIIllIIIllllIIIl = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().up().north();
            BlockPos llllllllllllllllIIIllIIIllllIIII = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().up().south();
            BlockPos llllllllllllllllIIIllIIIlllIllll = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().up().west();
            BlockPos llllllllllllllllIIIllIIIlllIlllI = new BlockPos(llllllllllllllllIIIllIIIlllIlIII).up().up().east();
            IBlockState llllllllllllllllIIIllIIIlllIllIl = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIllllIIIl);
            IBlockState llllllllllllllllIIIllIIIlllIllII = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIllllIIII);
            IBlockState llllllllllllllllIIIllIIIlllIlIll = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlllIllll);
            IBlockState llllllllllllllllIIIllIIIlllIlIlI = AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlllIlllI);
            if (llllllllllllllllIIIllIIIlllIllIl.getBlock() == Blocks.bed || llllllllllllllllIIIllIIIlllIllII.getBlock() == Blocks.bed || llllllllllllllllIIIllIIIlllIlIll.getBlock() == Blocks.bed || llllllllllllllllIIIllIIIlllIlIlI.getBlock() == Blocks.bed) {
                llllllllllllllllIIIllIIIllIlIlll.placehead = true;
            }
            return;
        }
        AntiBed.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIIIlIlllllIlIlll -> llllllllllllllllIIIlIlllllIlIlll instanceof EntityPlayer).filter(llllllllllllllllIIIlIlllllIllIll -> llllllllllllllllIIIlIlllllIllIll != AntiBed.mc.thePlayer).filter(llllllllllllllllIIIlIlllllIllllI -> !Friends.isFriend(llllllllllllllllIIIlIlllllIllllI.getName())).forEach(llllllllllllllllIIIlIllllllIIIlI -> {
            ItemStack llllllllllllllllIIIlIllllllIIlIl = ((EntityPlayer)llllllllllllllllIIIlIllllllIIIlI).func_184614_ca();
            ItemStack llllllllllllllllIIIlIllllllIIlII = ((EntityPlayer)llllllllllllllllIIIlIllllllIIIlI).func_184592_cb();
            if (AntiBed.mc.thePlayer.getDistanceToEntity(llllllllllllllllIIIlIllllllIIIlI) < 10.0f && llllllllllllllllIIIlIllllllIIlIl.getItem() == Items.bed || llllllllllllllllIIIlIllllllIIlII.getItem() == Items.bed) {
                llllllllllllllllIIIlIllllllIIlll.placeface = true;
            }
        });
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIIIllIIIIlllIIlI, double llllllllllllllllIIIllIIIIllIllll) {
        return AntiBed.getInterpolatedAmount(llllllllllllllllIIIllIIIIlllIIlI, llllllllllllllllIIIllIIIIllIllll, llllllllllllllllIIIllIIIIllIllll, llllllllllllllllIIIllIIIIllIllll);
    }

    public static void faceVectorPacketInstant(Vec3d llllllllllllllllIIIllIIIIIllIIll) {
        float[] llllllllllllllllIIIllIIIIIllIIlI = AntiBed.getNeededRotations2(llllllllllllllllIIIllIIIIIllIIll);
        AntiBed.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(llllllllllllllllIIIllIIIIIllIIlI[0], llllllllllllllllIIIllIIIIIllIIlI[1], AntiBed.mc.thePlayer.onGround));
    }

    public static void processRightClickBlock(BlockPos llllllllllllllllIIIllIIIIlIIIIIl, EnumFacing llllllllllllllllIIIllIIIIlIIIIII, Vec3d llllllllllllllllIIIllIIIIIllllll) {
        AntiBed.getPlayerController().func_187099_a(AntiBed.mc.thePlayer, AntiBed.mc.theWorld, llllllllllllllllIIIllIIIIlIIIIIl, llllllllllllllllIIIllIIIIlIIIIII, llllllllllllllllIIIllIIIIIllllll, EnumHand.MAIN_HAND);
    }

    public static IBlockState getState(BlockPos llllllllllllllllIIIllIIIIIllIlll) {
        return AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIIIllIlll);
    }

    public static boolean canBeClicked(BlockPos llllllllllllllllIIIllIIIIlIIIlIl) {
        return AntiBed.getBlock(llllllllllllllllIIIllIIIIlIIIlIl).canCollideCheck(AntiBed.getState(llllllllllllllllIIIllIIIIlIIIlIl), false);
    }

    @Override
    public void onUpdate() {
        int llllllllllllllllIIIllIIIlIIllllI;
        BlockPos llllllllllllllllIIIllIIIlIlIIIII;
        BlockPos llllllllllllllllIIIllIIIlIlIIIIl;
        BlockPos llllllllllllllllIIIllIIIlIlIIIlI;
        BlockPos llllllllllllllllIIIllIIIlIlIIIll;
        AntiBed llllllllllllllllIIIllIIIlIIlllIl;
        block19: {
            block18: {
                block17: {
                    block16: {
                        if (!AntiBed.mc.thePlayer.onGround && !AntiBed.mc.thePlayer.field_184841_cd) {
                            llllllllllllllllIIIllIIIlIIlllIl.placeface = false;
                            llllllllllllllllIIIllIIIlIIlllIl.placehead = false;
                            return;
                        }
                        if (!llllllllllllllllIIIllIIIlIIlllIl.placeface) {
                            return;
                        }
                        Vec3d llllllllllllllllIIIllIIIlIlIIlII = AntiBed.getInterpolatedPos((Entity)AntiBed.mc.thePlayer, 0.0f);
                        llllllllllllllllIIIllIIIlIlIIIll = new BlockPos(llllllllllllllllIIIllIIIlIlIIlII).north().up();
                        llllllllllllllllIIIllIIIlIlIIIlI = new BlockPos(llllllllllllllllIIIllIIIlIlIIlII).south().up();
                        llllllllllllllllIIIllIIIlIlIIIIl = new BlockPos(llllllllllllllllIIIllIIIlIlIIlII).east().up();
                        llllllllllllllllIIIllIIIlIlIIIII = new BlockPos(llllllllllllllllIIIllIIIlIlIIlII).west().up();
                        int llllllllllllllllIIIllIIIlIIlllll = -1;
                        for (int llllllllllllllllIIIllIIIlIlIlllI = 0; llllllllllllllllIIIllIIIlIlIlllI < 9; ++llllllllllllllllIIIllIIIlIlIlllI) {
                            Block llllllllllllllllIIIllIIIlIlIllll;
                            ItemStack llllllllllllllllIIIllIIIlIllIIII = AntiBed.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIIllIIIlIlIlllI);
                            if (llllllllllllllllIIIllIIIlIllIIII == ItemStack.field_190927_a || !(llllllllllllllllIIIllIIIlIllIIII.getItem() instanceof ItemBlock) || !llllllllllllllllIIIllIIIlIIlllIl.whiteList.contains(llllllllllllllllIIIllIIIlIlIllll = ((ItemBlock)llllllllllllllllIIIllIIIlIllIIII.getItem()).getBlock())) continue;
                            llllllllllllllllIIIllIIIlIIlllll = llllllllllllllllIIIllIIIlIlIlllI;
                            break;
                        }
                        if (llllllllllllllllIIIllIIIlIIlllll == -1) {
                            return;
                        }
                        llllllllllllllllIIIllIIIlIIllllI = AntiBed.mc.thePlayer.inventory.currentItem;
                        AntiBed.mc.thePlayer.inventory.currentItem = llllllllllllllllIIIllIIIlIIlllll;
                        if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIIIll)) {
                            for (EnumFacing llllllllllllllllIIIllIIIlIlIllII : EnumFacing.values()) {
                                BlockPos llllllllllllllllIIIllIIIlIlIllIl = llllllllllllllllIIIllIIIlIlIIIll.offset(llllllllllllllllIIIllIIIlIlIllII);
                                if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIllIl)) continue;
                                llllllllllllllllIIIllIIIlIlIIIll = llllllllllllllllIIIllIIIlIlIllIl;
                                break block16;
                            }
                            return;
                        }
                    }
                    if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIIIlI)) {
                        for (EnumFacing llllllllllllllllIIIllIIIlIlIlIlI : EnumFacing.values()) {
                            BlockPos llllllllllllllllIIIllIIIlIlIlIll = llllllllllllllllIIIllIIIlIlIIIlI.offset(llllllllllllllllIIIllIIIlIlIlIlI);
                            if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIlIll)) continue;
                            llllllllllllllllIIIllIIIlIlIIIlI = llllllllllllllllIIIllIIIlIlIlIll;
                            break block17;
                        }
                        return;
                    }
                }
                if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIIIIl)) {
                    for (EnumFacing llllllllllllllllIIIllIIIlIlIlIII : EnumFacing.values()) {
                        BlockPos llllllllllllllllIIIllIIIlIlIlIIl = llllllllllllllllIIIllIIIlIlIIIIl.offset(llllllllllllllllIIIllIIIlIlIlIII);
                        if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIlIIl)) continue;
                        llllllllllllllllIIIllIIIlIlIIIIl = llllllllllllllllIIIllIIIlIlIlIIl;
                        break block18;
                    }
                    return;
                }
            }
            if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIIIII)) {
                for (EnumFacing llllllllllllllllIIIllIIIlIlIIllI : EnumFacing.values()) {
                    BlockPos llllllllllllllllIIIllIIIlIlIIlll = llllllllllllllllIIIllIIIlIlIIIII.offset(llllllllllllllllIIIllIIIlIlIIllI);
                    if (!AntiBed.hasNeighbour(llllllllllllllllIIIllIIIlIlIIlll)) continue;
                    llllllllllllllllIIIllIIIlIlIIIII = llllllllllllllllIIIllIIIlIlIIlll;
                    break block19;
                }
                return;
            }
        }
        if (AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlIlIIIll).func_185904_a().isReplaceable() && llllllllllllllllIIIllIIIlIIlllIl.isEntitiesEmpty(llllllllllllllllIIIllIIIlIlIIIll)) {
            AntiBed.placeBlockScaffold(llllllllllllllllIIIllIIIlIlIIIll, llllllllllllllllIIIllIIIlIIlllIl.rotate.getValue());
        }
        if (AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlIlIIIlI).func_185904_a().isReplaceable() && llllllllllllllllIIIllIIIlIIlllIl.isEntitiesEmpty(llllllllllllllllIIIllIIIlIlIIIlI)) {
            AntiBed.placeBlockScaffold(llllllllllllllllIIIllIIIlIlIIIlI, llllllllllllllllIIIllIIIlIIlllIl.rotate.getValue());
        }
        if (AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlIlIIIIl).func_185904_a().isReplaceable() && llllllllllllllllIIIllIIIlIIlllIl.isEntitiesEmpty(llllllllllllllllIIIllIIIlIlIIIIl)) {
            AntiBed.placeBlockScaffold(llllllllllllllllIIIllIIIlIlIIIIl, llllllllllllllllIIIllIIIlIIlllIl.rotate.getValue());
        }
        if (AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlIlIIIII).func_185904_a().isReplaceable() && llllllllllllllllIIIllIIIlIIlllIl.isEntitiesEmpty(llllllllllllllllIIIllIIIlIlIIIII)) {
            AntiBed.placeBlockScaffold(llllllllllllllllIIIllIIIlIlIIIII, llllllllllllllllIIIllIIIlIIlllIl.rotate.getValue());
        }
        AntiBed.mc.thePlayer.inventory.currentItem = llllllllllllllllIIIllIIIlIIllllI;
        llllllllllllllllIIIllIIIlIIlllIl.headonupdate();
    }

    public static boolean hasNeighbour(BlockPos llllllllllllllllIIIllIIIIIIIlllI) {
        for (EnumFacing llllllllllllllllIIIllIIIIIIlIIII : EnumFacing.values()) {
            BlockPos llllllllllllllllIIIllIIIIIIlIIIl = llllllllllllllllIIIllIIIIIIIlllI.offset(llllllllllllllllIIIllIIIIIIlIIII);
            if (AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIIIIlIIIl).func_185904_a().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIIIllIIIIllIIllI, double llllllllllllllllIIIllIIIIllIlIIl, double llllllllllllllllIIIllIIIIllIIlII, double llllllllllllllllIIIllIIIIllIIlll) {
        return new Vec3d((llllllllllllllllIIIllIIIIllIIllI.posX - llllllllllllllllIIIllIIIIllIIllI.lastTickPosX) * llllllllllllllllIIIllIIIIllIlIIl, (llllllllllllllllIIIllIIIIllIIllI.posY - llllllllllllllllIIIllIIIIllIIllI.lastTickPosY) * llllllllllllllllIIIllIIIIllIIlII, (llllllllllllllllIIIllIIIIllIIllI.posZ - llllllllllllllllIIIllIIIIllIIllI.lastTickPosZ) * llllllllllllllllIIIllIIIIllIIlll);
    }

    public void headonupdate() {
        AntiBed llllllllllllllllIIIllIIIlIIIIIIl;
        if (!llllllllllllllllIIIllIIIlIIIIIIl.placehead) {
            return;
        }
        Vec3d llllllllllllllllIIIllIIIlIIIIlIl = AntiBed.getInterpolatedPos((Entity)AntiBed.mc.thePlayer, 0.0f);
        BlockPos llllllllllllllllIIIllIIIlIIIIlII = new BlockPos(llllllllllllllllIIIllIIIlIIIIlIl).up();
        int llllllllllllllllIIIllIIIlIIIIIll = -1;
        for (int llllllllllllllllIIIllIIIlIIIIlll = 0; llllllllllllllllIIIllIIIlIIIIlll < 9; ++llllllllllllllllIIIllIIIlIIIIlll) {
            Block llllllllllllllllIIIllIIIlIIIlIII;
            ItemStack llllllllllllllllIIIllIIIlIIIlIIl = AntiBed.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIIllIIIlIIIIlll);
            if (llllllllllllllllIIIllIIIlIIIlIIl == ItemStack.field_190927_a || !(llllllllllllllllIIIllIIIlIIIlIIl.getItem() instanceof ItemBlock) || !llllllllllllllllIIIllIIIlIIIIIIl.whiteList.contains(llllllllllllllllIIIllIIIlIIIlIII = ((ItemBlock)llllllllllllllllIIIllIIIlIIIlIIl.getItem()).getBlock())) continue;
            llllllllllllllllIIIllIIIlIIIIIll = llllllllllllllllIIIllIIIlIIIIlll;
            break;
        }
        if (llllllllllllllllIIIllIIIlIIIIIll == -1) {
            return;
        }
        int llllllllllllllllIIIllIIIlIIIIIlI = AntiBed.mc.thePlayer.inventory.currentItem;
        AntiBed.mc.thePlayer.inventory.currentItem = llllllllllllllllIIIllIIIlIIIIIll;
        AntiBed.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AntiBed.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
        if (AntiBed.mc.theWorld.getBlockState(llllllllllllllllIIIllIIIlIIIIlII.up()).func_185904_a().isReplaceable() && llllllllllllllllIIIllIIIlIIIIIIl.isEntitiesEmpty(llllllllllllllllIIIllIIIlIIIIlII.up())) {
            llllllllllllllllIIIllIIIlIIIIIIl.placeBlock(new BlockPos((Vec3i)llllllllllllllllIIIllIIIlIIIIlII), EnumFacing.UP);
        }
        AntiBed.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AntiBed.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
        AntiBed.mc.thePlayer.inventory.currentItem = llllllllllllllllIIIllIIIlIIIIIlI;
    }

    private static float[] getNeededRotations2(Vec3d llllllllllllllllIIIllIIIIIIlllll) {
        Vec3d llllllllllllllllIIIllIIIIIlIIllI = AntiBed.getEyesPos();
        double llllllllllllllllIIIllIIIIIlIIlIl = llllllllllllllllIIIllIIIIIIlllll.xCoord - llllllllllllllllIIIllIIIIIlIIllI.xCoord;
        double llllllllllllllllIIIllIIIIIlIIlII = llllllllllllllllIIIllIIIIIIlllll.yCoord - llllllllllllllllIIIllIIIIIlIIllI.yCoord;
        double llllllllllllllllIIIllIIIIIlIIIll = llllllllllllllllIIIllIIIIIIlllll.zCoord - llllllllllllllllIIIllIIIIIlIIllI.zCoord;
        double llllllllllllllllIIIllIIIIIlIIIlI = Math.sqrt(llllllllllllllllIIIllIIIIIlIIlIl * llllllllllllllllIIIllIIIIIlIIlIl + llllllllllllllllIIIllIIIIIlIIIll * llllllllllllllllIIIllIIIIIlIIIll);
        float llllllllllllllllIIIllIIIIIlIIIIl = (float)Math.toDegrees(Math.atan2(llllllllllllllllIIIllIIIIIlIIIll, llllllllllllllllIIIllIIIIIlIIlIl)) - 90.0f;
        float llllllllllllllllIIIllIIIIIlIIIII = (float)(-Math.toDegrees(Math.atan2(llllllllllllllllIIIllIIIIIlIIlII, llllllllllllllllIIIllIIIIIlIIIlI)));
        return new float[]{AntiBed.mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIIIllIIIIIlIIIIl - AntiBed.mc.thePlayer.rotationYaw)), AntiBed.mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIIIllIIIIIlIIIII - AntiBed.mc.thePlayer.rotationPitch))};
    }
}

