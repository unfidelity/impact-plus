/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAnvil
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.block.BlockPressurePlate
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.module.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.setting.Setting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AutoAnvil
extends Module {
    /* synthetic */ Setting.b ghosthand;
    /* synthetic */ Setting.b rotate;
    /* synthetic */ Setting.i bpt;
    /* synthetic */ Setting.i delay;
    /* synthetic */ Setting.i range;
    /* synthetic */ int blocksPlaced;

    private boolean shouldPlace(BlockPos lllllllllllllllIllIllllIIIlllIII) {
        AutoAnvil lllllllllllllllIllIllllIIIllllll;
        List lllllllllllllllIllIllllIIIllllIl = AutoAnvil.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(lllllllllllllllIllIllllIIIlllIII)).stream().filter(lllllllllllllllIllIllllIIIlIlllI -> !(lllllllllllllllIllIllllIIIlIlllI instanceof EntityItem)).filter(lllllllllllllllIllIllllIIIllIIlI -> !(lllllllllllllllIllIllllIIIllIIlI instanceof EntityXPOrb)).collect(Collectors.toList());
        boolean lllllllllllllllIllIllllIIIllllII = lllllllllllllllIllIllllIIIllllIl.isEmpty();
        boolean lllllllllllllllIllIllllIIIlllIll = AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIllllIIIlllIII).func_185904_a().isReplaceable();
        boolean lllllllllllllllIllIllllIIIlllIlI = lllllllllllllllIllIllllIIIllllll.blocksPlaced < lllllllllllllllIllIllllIIIllllll.bpt.getValue();
        return lllllllllllllllIllIllllIIIllllII && lllllllllllllllIllIllllIIIlllIll && lllllllllllllllIllIllllIIIlllIlI;
    }

    public AutoAnvil() {
        super("AutoAnvil", Module.Category.COMBAT);
        AutoAnvil lllllllllllllllIllIllllIIlIlIIII;
    }

    @Override
    public void onEnable() {
        if (AutoAnvil.mc.thePlayer == null) {
            AutoAnvil lllllllllllllllIllIllllIIlIIIlll;
            lllllllllllllllIllIllllIIlIIIlll.disable();
        }
    }

    @Override
    public void setup() {
        AutoAnvil lllllllllllllllIllIllllIIlIIllII;
        lllllllllllllllIllIllllIIlIIllII.ghosthand = lllllllllllllllIllIllllIIlIIllII.registerB("GhostHand", true);
        lllllllllllllllIllIllllIIlIIllII.rotate = lllllllllllllllIllIllllIIlIIllII.registerB("Rotate", true);
        lllllllllllllllIllIllllIIlIIllII.delay = lllllllllllllllIllIllllIIlIIllII.registerI("Delay", 12, 1, 20);
        lllllllllllllllIllIllllIIlIIllII.range = lllllllllllllllIllIllllIIlIIllII.registerI("Range", 6, 1, 10);
        lllllllllllllllIllIllllIIlIIllII.bpt = lllllllllllllllIllIllllIIlIIllII.registerI("BlocksPerTick", 8, 1, 15);
    }

    @Override
    public void onUpdate() {
        AutoAnvil lllllllllllllllIllIllllIIlIIlIlI;
        AutoAnvil.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllIllIlllIlIllIllIl -> lllllllllllllllIllIlllIlIllIllIl instanceof EntityPlayer).filter(lllllllllllllllIllIlllIlIlllIIII -> {
            AutoAnvil lllllllllllllllIllIlllIlIlllIIll;
            return AutoAnvil.mc.thePlayer.getDistanceToEntity(lllllllllllllllIllIlllIlIlllIIII) <= (float)lllllllllllllllIllIlllIlIlllIIll.range.getValue();
        }).filter(lllllllllllllllIllIlllIlIlllIllI -> lllllllllllllllIllIlllIlIlllIllI != AutoAnvil.mc.thePlayer).filter(lllllllllllllllIllIlllIlIllllIlI -> !Friends.isFriend(lllllllllllllllIllIlllIlIllllIlI.getName())).sorted(Comparator.comparing(lllllllllllllllIllIlllIlIlllllII -> Float.valueOf(AutoAnvil.mc.thePlayer.getDistanceToEntity(lllllllllllllllIllIlllIlIlllllII)))).forEach(lllllllllllllllIllIlllIllIIllllI -> {
            AutoAnvil lllllllllllllllIllIlllIllIllllII;
            int lllllllllllllllIllIlllIllIlllIlI = (int)lllllllllllllllIllIlllIllIIllllI.posX;
            int lllllllllllllllIllIlllIllIlllIIl = (int)lllllllllllllllIllIlllIllIIllllI.posY;
            int lllllllllllllllIllIlllIllIlllIII = (int)lllllllllllllllIllIlllIllIIllllI.posZ;
            int lllllllllllllllIllIlllIllIllIlll = (int)AutoAnvil.mc.thePlayer.posX;
            int lllllllllllllllIllIlllIllIllIllI = (int)AutoAnvil.mc.thePlayer.posY;
            int lllllllllllllllIllIlllIllIllIlIl = (int)AutoAnvil.mc.thePlayer.posZ;
            if (lllllllllllllllIllIlllIllIlllIlI == lllllllllllllllIllIlllIllIllIlll && lllllllllllllllIllIlllIllIlllIIl == lllllllllllllllIllIlllIllIllIllI && lllllllllllllllIllIlllIllIlllIII == lllllllllllllllIllIlllIllIllIlIl) {
                return;
            }
            Vec3d lllllllllllllllIllIlllIllIllIlII = Surround.getInterpolatedPos(lllllllllllllllIllIlllIllIIllllI, mc.func_184121_ak());
            BlockPos lllllllllllllllIllIlllIllIllIIll = new BlockPos(lllllllllllllllIllIlllIllIllIlII);
            BlockPos lllllllllllllllIllIlllIllIllIIlI = lllllllllllllllIllIlllIllIllIIll.add(0, -1, 0);
            BlockPos lllllllllllllllIllIlllIllIllIIIl = lllllllllllllllIllIlllIllIllIIll.add(1, -1, 0);
            BlockPos lllllllllllllllIllIlllIllIllIIII = lllllllllllllllIllIlllIllIllIIll.add(-1, -1, 0);
            BlockPos lllllllllllllllIllIlllIllIlIllll = lllllllllllllllIllIlllIllIllIIll.add(0, -1, 1);
            BlockPos lllllllllllllllIllIlllIllIlIlllI = lllllllllllllllIllIlllIllIllIIll.add(0, -1, -1);
            BlockPos lllllllllllllllIllIlllIllIlIllIl = lllllllllllllllIllIlllIllIllIIll.add(1, 0, 0);
            BlockPos lllllllllllllllIllIlllIllIlIllII = lllllllllllllllIllIlllIllIllIIll.add(-1, 0, 0);
            BlockPos lllllllllllllllIllIlllIllIlIlIll = lllllllllllllllIllIlllIllIllIIll.add(0, 0, 1);
            BlockPos lllllllllllllllIllIlllIllIlIlIlI = lllllllllllllllIllIlllIllIllIIll.add(0, 0, -1);
            BlockPos lllllllllllllllIllIlllIllIlIlIIl = lllllllllllllllIllIlllIllIllIIll.add(1, 1, 0);
            BlockPos lllllllllllllllIllIlllIllIlIlIII = lllllllllllllllIllIlllIllIllIIll.add(-1, 1, 0);
            BlockPos lllllllllllllllIllIlllIllIlIIlll = lllllllllllllllIllIlllIllIllIIll.add(0, 1, 1);
            BlockPos lllllllllllllllIllIlllIllIlIIllI = lllllllllllllllIllIlllIllIllIIll.add(0, 1, -1);
            BlockPos lllllllllllllllIllIlllIllIlIIlIl = lllllllllllllllIllIlllIllIllIIll.add(1, 2, 0);
            BlockPos lllllllllllllllIllIlllIllIlIIlII = lllllllllllllllIllIlllIllIllIIll.add(-1, 2, 0);
            BlockPos lllllllllllllllIllIlllIllIlIIIll = lllllllllllllllIllIlllIllIllIIll.add(0, 2, 1);
            BlockPos lllllllllllllllIllIlllIllIlIIIlI = lllllllllllllllIllIlllIllIllIIll.add(0, 2, -1);
            int lllllllllllllllIllIlllIllIlIIIIl = -1;
            for (int lllllllllllllllIllIlllIlllIIIlll = 0; lllllllllllllllIllIlllIlllIIIlll < 9; ++lllllllllllllllIllIlllIlllIIIlll) {
                Block lllllllllllllllIllIlllIlllIIlIII;
                ItemStack lllllllllllllllIllIlllIlllIIlIIl = AutoAnvil.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllIllIlllIlllIIIlll);
                if (lllllllllllllllIllIlllIlllIIlIIl == ItemStack.field_190927_a || !(lllllllllllllllIllIlllIlllIIlIIl.getItem() instanceof ItemBlock) || !((lllllllllllllllIllIlllIlllIIlIII = ((ItemBlock)lllllllllllllllIllIlllIlllIIlIIl.getItem()).getBlock()) instanceof BlockObsidian) && !(lllllllllllllllIllIlllIlllIIlIII instanceof BlockEnderChest)) continue;
                lllllllllllllllIllIlllIllIlIIIIl = lllllllllllllllIllIlllIlllIIIlll;
                break;
            }
            if (lllllllllllllllIllIlllIllIlIIIIl == -1) {
                return;
            }
            int lllllllllllllllIllIlllIllIlIIIII = AutoAnvil.mc.thePlayer.inventory.currentItem;
            AutoAnvil.mc.thePlayer.inventory.currentItem = lllllllllllllllIllIlllIllIlIIIIl;
            lllllllllllllllIllIlllIllIllllII.blocksPlaced = 0;
            if (lllllllllllllllIllIlllIllIllllII.blocksPlaced > lllllllllllllllIllIlllIllIllllII.bpt.getValue()) {
                lllllllllllllllIllIlllIllIllllII.blocksPlaced = 0;
                return;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIllIIlI)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIllIIlI, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIllIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIllIIIl, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIllIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIllIIII, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIllIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIllll, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIllIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIlllI, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIllIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIllIl, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIllII)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIllII, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIlIll)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIlIll, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIlIlI)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIlIlI, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIlIIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIlIIl, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIlIII)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIlIII, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIIlll)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIIlll, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIIllI)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIIllI, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIIlIl)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIIlIl, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIIlII)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIIlII, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIIIll)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIIIll, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            if (lllllllllllllllIllIlllIllIllllII.shouldPlace(lllllllllllllllIllIlllIllIlIIIlI)) {
                Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIlIIIlI, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                ++lllllllllllllllIllIlllIllIllllII.blocksPlaced;
            }
            AutoAnvil.mc.thePlayer.inventory.currentItem = lllllllllllllllIllIlllIllIlIIIII;
            if (AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIllIl).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIllII).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIlIll).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIlIlI).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIlIIl).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIlIII).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIIlll).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIIllI).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIIlIl).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIIIlI).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIIIll).getBlock() != Blocks.air && AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIlIIIlI).getBlock() != Blocks.air) {
                if (!(AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIllIIll).getBlock() instanceof BlockPressurePlate)) {
                    int lllllllllllllllIllIlllIlllIIIIll = -1;
                    for (int lllllllllllllllIllIlllIlllIIIlII = 0; lllllllllllllllIllIlllIlllIIIlII < 9; ++lllllllllllllllIllIlllIlllIIIlII) {
                        Block lllllllllllllllIllIlllIlllIIIlIl;
                        ItemStack lllllllllllllllIllIlllIlllIIIllI = AutoAnvil.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllIllIlllIlllIIIlII);
                        if (lllllllllllllllIllIlllIlllIIIllI == ItemStack.field_190927_a || !(lllllllllllllllIllIlllIlllIIIllI.getItem() instanceof ItemBlock) || !((lllllllllllllllIllIlllIlllIIIlIl = ((ItemBlock)lllllllllllllllIllIlllIlllIIIllI.getItem()).getBlock()) instanceof BlockPressurePlate)) continue;
                        lllllllllllllllIllIlllIlllIIIIll = lllllllllllllllIllIlllIlllIIIlII;
                        break;
                    }
                    if (lllllllllllllllIllIlllIlllIIIIll == -1) {
                        Command.sendClientMessage("No pressure plate in hotbar");
                        lllllllllllllllIllIlllIllIllllII.disable();
                        return;
                    }
                    int lllllllllllllllIllIlllIlllIIIIlI = AutoAnvil.mc.thePlayer.inventory.currentItem;
                    AutoAnvil.mc.thePlayer.inventory.currentItem = lllllllllllllllIllIlllIlllIIIIll;
                    AutoAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoAnvil.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
                    Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIllIIll, lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                    AutoAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoAnvil.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
                    AutoAnvil.mc.thePlayer.inventory.currentItem = lllllllllllllllIllIlllIlllIIIIlI;
                }
                if (AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIllIIll.up().up()).getBlock() instanceof BlockAnvil) {
                    return;
                }
                if (AutoAnvil.mc.theWorld.getBlockState(lllllllllllllllIllIlllIllIllIIll).getBlock() instanceof BlockPressurePlate) {
                    int lllllllllllllllIllIlllIllIlllllI = -1;
                    for (int lllllllllllllllIllIlllIllIllllll = 0; lllllllllllllllIllIlllIllIllllll < 9; ++lllllllllllllllIllIlllIllIllllll) {
                        Block lllllllllllllllIllIlllIlllIIIIII;
                        ItemStack lllllllllllllllIllIlllIlllIIIIIl = AutoAnvil.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllIllIlllIllIllllll);
                        if (lllllllllllllllIllIlllIlllIIIIIl == ItemStack.field_190927_a || !(lllllllllllllllIllIlllIlllIIIIIl.getItem() instanceof ItemBlock) || !((lllllllllllllllIllIlllIlllIIIIII = ((ItemBlock)lllllllllllllllIllIlllIlllIIIIIl.getItem()).getBlock()) instanceof BlockAnvil)) continue;
                        lllllllllllllllIllIlllIllIlllllI = lllllllllllllllIllIlllIllIllllll;
                        break;
                    }
                    if (lllllllllllllllIllIlllIllIlllllI == -1) {
                        Command.sendClientMessage("No anvil in hotbar");
                        lllllllllllllllIllIlllIllIllllII.disable();
                        return;
                    }
                    int lllllllllllllllIllIlllIllIllllIl = AutoAnvil.mc.thePlayer.inventory.currentItem;
                    AutoAnvil.mc.thePlayer.inventory.currentItem = lllllllllllllllIllIlllIllIlllllI;
                    AutoAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoAnvil.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
                    AutoAnvil.mc.rightClickDelayTimer = 0;
                    Surround.placeBlockScaffold(lllllllllllllllIllIlllIllIllIIll.up().up(), lllllllllllllllIllIlllIllIllllII.rotate.getValue());
                    AutoAnvil.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoAnvil.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
                    AutoAnvil.mc.thePlayer.inventory.currentItem = lllllllllllllllIllIlllIllIllllIl;
                }
            }
        });
    }
}

