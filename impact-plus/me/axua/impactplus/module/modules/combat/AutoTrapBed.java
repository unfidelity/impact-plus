/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.BlockInteractionHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class AutoTrapBed
extends Module {
    /* synthetic */ int blocksPlaced;
    private /* synthetic */ Setting.b ec;
    private /* synthetic */ Setting.i bpt;
    private /* synthetic */ Setting.i range;

    public static Vec3d getInterpolatedPos(Entity llllllllllllllllIllIlIIIIIIlIllI, float llllllllllllllllIllIlIIIIIIlIlIl) {
        return new Vec3d(llllllllllllllllIllIlIIIIIIlIllI.lastTickPosX, llllllllllllllllIllIlIIIIIIlIllI.lastTickPosY, llllllllllllllllIllIlIIIIIIlIllI.lastTickPosZ).add(AutoTrapBed.getInterpolatedAmount(llllllllllllllllIllIlIIIIIIlIllI, llllllllllllllllIllIlIIIIIIlIlIl));
    }

    @Override
    public void setup() {
        AutoTrapBed llllllllllllllllIllIlIIIIlIlIIlI;
        llllllllllllllllIllIlIIIIlIlIIlI.ec = llllllllllllllllIllIlIIIIlIlIIlI.registerB("UseEchests", false);
        llllllllllllllllIllIlIIIIlIlIIlI.range = llllllllllllllllIllIlIIIIlIlIIlI.registerI("Range", 5, 0, 10);
        llllllllllllllllIllIlIIIIlIlIIlI.bpt = llllllllllllllllIllIlIIIIlIlIIlI.registerI("BlocksPerTick", 8, 1, 15);
    }

    @Override
    public void onUpdate() {
        AutoTrapBed llllllllllllllllIllIlIIIIIlllllI;
        AutoTrapBed.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIllIIlllIllIIlll -> llllllllllllllllIllIIlllIllIIlll instanceof EntityPlayer).filter(llllllllllllllllIllIIlllIllIllII -> {
            AutoTrapBed llllllllllllllllIllIIlllIllIllIl;
            return AutoTrapBed.mc.thePlayer.getDistanceToEntity(llllllllllllllllIllIIlllIllIllII) <= (float)llllllllllllllllIllIIlllIllIllIl.range.getValue();
        }).filter(llllllllllllllllIllIIlllIlllIIIl -> llllllllllllllllIllIIlllIlllIIIl != AutoTrapBed.mc.thePlayer).filter(llllllllllllllllIllIIlllIlllIIll -> !Friends.isFriend(llllllllllllllllIllIIlllIlllIIll.getName())).sorted(Comparator.comparing(llllllllllllllllIllIIlllIlllIlll -> Float.valueOf(AutoTrapBed.mc.thePlayer.getDistanceToEntity(llllllllllllllllIllIIlllIlllIlll)))).forEach(llllllllllllllllIllIIllllIIlIlll -> {
            AutoTrapBed llllllllllllllllIllIIllllIIllIII;
            Vec3d llllllllllllllllIllIIllllIIlIllI = AutoTrapBed.getInterpolatedPos(llllllllllllllllIllIIllllIIlIlll, mc.func_184121_ak());
            BlockPos llllllllllllllllIllIIllllIIlIlIl = new BlockPos(llllllllllllllllIllIIllllIIlIllI);
            BlockPos llllllllllllllllIllIIllllIIlIlII = llllllllllllllllIllIIllllIIlIlIl.add(1, 0, 0);
            BlockPos llllllllllllllllIllIIllllIIlIIll = llllllllllllllllIllIIllllIIlIlIl.add(-1, 0, 0);
            BlockPos llllllllllllllllIllIIllllIIlIIlI = llllllllllllllllIllIIllllIIlIlIl.add(0, 0, 1);
            BlockPos llllllllllllllllIllIIllllIIlIIIl = llllllllllllllllIllIIllllIIlIlIl.add(0, 0, -1);
            BlockPos llllllllllllllllIllIIllllIIIlIll = llllllllllllllllIllIIllllIIlIlIl.add(0, 1, 0);
            int llllllllllllllllIllIIllllIIIlIIl = -1;
            for (int llllllllllllllllIllIIllllIIllIIl = 0; llllllllllllllllIllIIllllIIllIIl < 9; ++llllllllllllllllIllIIllllIIllIIl) {
                ItemStack llllllllllllllllIllIIllllIIllIll = AutoTrapBed.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIllIIllllIIllIIl);
                if (llllllllllllllllIllIIllllIIllIll == ItemStack.field_190927_a || !(llllllllllllllllIllIIllllIIllIll.getItem() instanceof ItemBlock)) continue;
                Block llllllllllllllllIllIIllllIIllIlI = ((ItemBlock)llllllllllllllllIllIIllllIIllIll.getItem()).getBlock();
                if (!llllllllllllllllIllIIllllIIllIII.ec.getValue() ? !(llllllllllllllllIllIIllllIIllIlI instanceof BlockObsidian) : !(llllllllllllllllIllIIllllIIllIlI instanceof BlockObsidian) && !(llllllllllllllllIllIIllllIIllIlI instanceof BlockEnderChest)) continue;
                llllllllllllllllIllIIllllIIIlIIl = llllllllllllllllIllIIllllIIllIIl;
                break;
            }
            if (llllllllllllllllIllIIllllIIIlIIl == -1) {
                return;
            }
            int llllllllllllllllIllIIllllIIIlIII = AutoTrapBed.mc.thePlayer.inventory.currentItem;
            AutoTrapBed.mc.thePlayer.inventory.currentItem = llllllllllllllllIllIIllllIIIlIIl;
            llllllllllllllllIllIIllllIIllIII.blocksPlaced = 0;
            if (llllllllllllllllIllIIllllIIllIII.blocksPlaced > llllllllllllllllIllIIllllIIllIII.bpt.getValue()) {
                llllllllllllllllIllIIllllIIllIII.blocksPlaced = 0;
                return;
            }
            if (llllllllllllllllIllIIllllIIllIII.shouldPlace(llllllllllllllllIllIIllllIIlIlII)) {
                Surround.placeBlockScaffold(llllllllllllllllIllIIllllIIlIlII, false);
                ++llllllllllllllllIllIIllllIIllIII.blocksPlaced;
            }
            if (llllllllllllllllIllIIllllIIllIII.shouldPlace(llllllllllllllllIllIIllllIIlIIll)) {
                Surround.placeBlockScaffold(llllllllllllllllIllIIllllIIlIIll, false);
                ++llllllllllllllllIllIIllllIIllIII.blocksPlaced;
            }
            if (llllllllllllllllIllIIllllIIllIII.shouldPlace(llllllllllllllllIllIIllllIIlIIlI)) {
                Surround.placeBlockScaffold(llllllllllllllllIllIIllllIIlIIlI, false);
                ++llllllllllllllllIllIIllllIIllIII.blocksPlaced;
            }
            if (llllllllllllllllIllIIllllIIllIII.shouldPlace(llllllllllllllllIllIIllllIIlIIIl)) {
                Surround.placeBlockScaffold(llllllllllllllllIllIIllllIIlIIIl, false);
                ++llllllllllllllllIllIIllllIIllIII.blocksPlaced;
            }
            if (llllllllllllllllIllIIllllIIllIII.shouldPlace(llllllllllllllllIllIIllllIIIlIll.up()) && AutoTrapBed.mc.theWorld.getBlockState(llllllllllllllllIllIIllllIIIlIll.up()).getBlock() == Blocks.air) {
                llllllllllllllllIllIIllllIIllIII.placeBlock(llllllllllllllllIllIIllllIIIlIll, EnumFacing.UP);
                ++llllllllllllllllIllIIllllIIllIII.blocksPlaced;
            }
            AutoTrapBed.mc.thePlayer.inventory.currentItem = llllllllllllllllIllIIllllIIIlIII;
        });
    }

    private boolean shouldPlace(BlockPos llllllllllllllllIllIlIIIIIlIIIll) {
        AutoTrapBed llllllllllllllllIllIlIIIIIlIIlII;
        List llllllllllllllllIllIlIIIIIlIIIlI = AutoTrapBed.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llllllllllllllllIllIlIIIIIlIIIll)).stream().filter(llllllllllllllllIllIIlllllIIlIll -> !(llllllllllllllllIllIIlllllIIlIll instanceof EntityItem)).filter(llllllllllllllllIllIIlllllIIllll -> !(llllllllllllllllIllIIlllllIIllll instanceof EntityXPOrb)).collect(Collectors.toList());
        boolean llllllllllllllllIllIlIIIIIlIIIIl = llllllllllllllllIllIlIIIIIlIIIlI.isEmpty();
        boolean llllllllllllllllIllIlIIIIIlIIIII = AutoTrapBed.mc.theWorld.getBlockState(llllllllllllllllIllIlIIIIIlIIIll).func_185904_a().isReplaceable();
        boolean llllllllllllllllIllIlIIIIIIlllll = llllllllllllllllIllIlIIIIIlIIlII.blocksPlaced < llllllllllllllllIllIlIIIIIlIIlII.bpt.getValue();
        return llllllllllllllllIllIlIIIIIlIIIIl && llllllllllllllllIllIlIIIIIlIIIII && llllllllllllllllIllIlIIIIIIlllll;
    }

    private void placeBlock(BlockPos llllllllllllllllIllIIllllllIIlIl, EnumFacing llllllllllllllllIllIIlllllIlIllI) {
        BlockPos llllllllllllllllIllIIlllllIlllIl = llllllllllllllllIllIIllllllIIlIl.offset(llllllllllllllllIllIIlllllIlIllI);
        EnumFacing llllllllllllllllIllIIlllllIllIll = llllllllllllllllIllIIlllllIlIllI.getOpposite();
        Vec3d llllllllllllllllIllIIlllllIllIlI = new Vec3d((Vec3i)llllllllllllllllIllIIlllllIlllIl).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllllllllllllllIllIIlllllIllIll.getDirectionVec()).func_186678_a(0.5));
        BlockInteractionHelper.faceVectorPacketInstant(llllllllllllllllIllIIlllllIllIlI);
        AutoTrapBed.mc.playerController.func_187099_a(AutoTrapBed.mc.thePlayer, AutoTrapBed.mc.theWorld, llllllllllllllllIllIIlllllIlllIl, llllllllllllllllIllIIlllllIllIll, llllllllllllllllIllIIlllllIllIlI, EnumHand.MAIN_HAND);
        AutoTrapBed.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
    }

    public AutoTrapBed() {
        super("AutoTrapBed", Module.Category.COMBAT, "Fortnite");
        AutoTrapBed llllllllllllllllIllIlIIIIllIIllI;
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIllIIllllllllllI, double llllllllllllllllIllIIlllllllllIl, double llllllllllllllllIllIIlllllllllII, double llllllllllllllllIllIIlllllllIlII) {
        return new Vec3d((llllllllllllllllIllIIllllllllllI.posX - llllllllllllllllIllIIllllllllllI.lastTickPosX) * llllllllllllllllIllIIlllllllllIl, (llllllllllllllllIllIIllllllllllI.posY - llllllllllllllllIllIIllllllllllI.lastTickPosY) * llllllllllllllllIllIIlllllllllII, (llllllllllllllllIllIIllllllllllI.posZ - llllllllllllllllIllIIllllllllllI.lastTickPosZ) * llllllllllllllllIllIIlllllllIlII);
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIllIlIIIIIIIlIlI, double llllllllllllllllIllIlIIIIIIIllIl) {
        return AutoTrapBed.getInterpolatedAmount(llllllllllllllllIllIlIIIIIIIlIlI, llllllllllllllllIllIlIIIIIIIllIl, llllllllllllllllIllIlIIIIIIIllIl, llllllllllllllllIllIlIIIIIIIllIl);
    }
}

