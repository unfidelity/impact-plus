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
 *  net.minecraft.network.play.client.CPacketPlayer$Position
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.combat.SelfAnvil;
import me.axua.impactplus.setting.Setting;
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

public class Surround
extends Module {
    /* synthetic */ Setting.b rotate;
    /* synthetic */ Setting.b jump;
    /* synthetic */ boolean placeface;
    private /* synthetic */ Vec3d Center;
    /* synthetic */ Setting.b sneak;
    /* synthetic */ Setting.b center;
    /* synthetic */ boolean wasinair;
    private /* synthetic */ List<Block> whiteList;
    /* synthetic */ Setting.mode centermode;
    /* synthetic */ Setting.b anvil;

    public static void faceVectorPacketInstant(Vec3d llllllllllllllllIlIIIIIlllllllIl) {
        float[] llllllllllllllllIlIIIIIlllllllII = Surround.getNeededRotations2(llllllllllllllllIlIIIIIlllllllIl);
        Surround.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(llllllllllllllllIlIIIIIlllllllII[0], llllllllllllllllIlIIIIIlllllllII[1], Surround.mc.thePlayer.onGround));
    }

    public Surround() {
        super("Surround", Module.Category.COMBAT, "Attacks nearby players");
        Surround llllllllllllllllIlIIIIlIllIIIlII;
        llllllllllllllllIlIIIIlIllIIIlII.whiteList = Arrays.asList(Blocks.obsidian);
        llllllllllllllllIlIIIIlIllIIIlII.wasinair = false;
        llllllllllllllllIlIIIIlIllIIIlII.Center = Vec3d.field_186680_a;
    }

    @Override
    public void onEnable() {
        Surround llllllllllllllllIlIIIIlIlIIlllll;
        if (llllllllllllllllIlIIIIlIlIIlllll.anvil.getValue()) {
            SelfAnvil llllllllllllllllIlIIIIlIlIlIIlII = (SelfAnvil)ModuleManager.getModuleByName("SelfAnvil");
            llllllllllllllllIlIIIIlIlIlIIlII.enable();
        }
        llllllllllllllllIlIIIIlIlIIlllll.placeface = false;
        llllllllllllllllIlIIIIlIlIIlllll.Center = llllllllllllllllIlIIIIlIlIIlllll.GetCenter(Surround.mc.thePlayer.posX, Surround.mc.thePlayer.posY, Surround.mc.thePlayer.posZ);
        if (llllllllllllllllIlIIIIlIlIIlllll.Center != Vec3d.field_186680_a && llllllllllllllllIlIIIIlIlIIlllll.centermode.getValue().equalsIgnoreCase("NCP") && llllllllllllllllIlIIIIlIlIIlllll.center.getValue()) {
            double llllllllllllllllIlIIIIlIlIlIIIIl = Math.abs(llllllllllllllllIlIIIIlIlIIlllll.Center.xCoord - Surround.mc.thePlayer.posX);
            double llllllllllllllllIlIIIIlIlIlIIIII = Math.abs(llllllllllllllllIlIIIIlIlIIlllll.Center.zCoord - Surround.mc.thePlayer.posZ);
            if (llllllllllllllllIlIIIIlIlIlIIIIl <= 0.1 && llllllllllllllllIlIIIIlIlIlIIIII <= 0.1) {
                llllllllllllllllIlIIIIlIlIIlllll.Center = Vec3d.field_186680_a;
            } else {
                double llllllllllllllllIlIIIIlIlIlIIIll = llllllllllllllllIlIIIIlIlIIlllll.Center.xCoord - Surround.mc.thePlayer.posX;
                double llllllllllllllllIlIIIIlIlIlIIIlI = llllllllllllllllIlIIIIlIlIIlllll.Center.zCoord - Surround.mc.thePlayer.posZ;
                Surround.mc.thePlayer.motionX = llllllllllllllllIlIIIIlIlIlIIIll / 2.0;
                Surround.mc.thePlayer.motionZ = llllllllllllllllIlIIIIlIlIlIIIlI / 2.0;
            }
        } else if (llllllllllllllllIlIIIIlIlIIlllll.center.getValue()) {
            Surround.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(llllllllllllllllIlIIIIlIlIIlllll.Center.xCoord, llllllllllllllllIlIIIIlIlIIlllll.Center.yCoord, llllllllllllllllIlIIIIlIlIIlllll.Center.zCoord, true));
            Surround.mc.thePlayer.setPosition(llllllllllllllllIlIIIIlIlIIlllll.Center.xCoord, llllllllllllllllIlIIIIlIlIIlllll.Center.yCoord, llllllllllllllllIlIIIIlIlIIlllll.Center.zCoord);
        }
        llllllllllllllllIlIIIIlIlIIlllll.wasinair = !Surround.mc.thePlayer.onGround;
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIlIIIIIlllIllIIl, double llllllllllllllllIlIIIIIlllIlIllI) {
        return Surround.getInterpolatedAmount(llllllllllllllllIlIIIIIlllIllIIl, llllllllllllllllIlIIIIIlllIlIllI, llllllllllllllllIlIIIIIlllIlIllI, llllllllllllllllIlIIIIIlllIlIllI);
    }

    public Vec3d GetCenter(double llllllllllllllllIlIIIIlIlIlIllll, double llllllllllllllllIlIIIIlIlIlIlllI, double llllllllllllllllIlIIIIlIlIllIIll) {
        double llllllllllllllllIlIIIIlIlIllIIlI = Math.floor(llllllllllllllllIlIIIIlIlIlIllll) + 0.5;
        double llllllllllllllllIlIIIIlIlIllIIIl = Math.floor(llllllllllllllllIlIIIIlIlIlIlllI);
        double llllllllllllllllIlIIIIlIlIllIIII = Math.floor(llllllllllllllllIlIIIIlIlIllIIll) + 0.5;
        return new Vec3d(llllllllllllllllIlIIIIlIlIllIIlI, llllllllllllllllIlIIIIlIlIllIIIl, llllllllllllllllIlIIIIlIlIllIIII);
    }

    public static IBlockState getState(BlockPos llllllllllllllllIlIIIIlIIIIIIllI) {
        return Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIIIIIllI);
    }

    public static Block getBlock(BlockPos llllllllllllllllIlIIIIlIIIIIIlII) {
        return Surround.getState(llllllllllllllllIlIIIIlIIIIIIlII).getBlock();
    }

    @Override
    public void setup() {
        Surround llllllllllllllllIlIIIIlIlIlllllI;
        ArrayList<String> llllllllllllllllIlIIIIlIlIllllll = new ArrayList<String>();
        llllllllllllllllIlIIIIlIlIllllll.add("TP");
        llllllllllllllllIlIIIIlIlIllllll.add("NCP");
        llllllllllllllllIlIIIIlIlIlllllI.sneak = llllllllllllllllIlIIIIlIlIlllllI.registerB("SneakOnly", false);
        llllllllllllllllIlIIIIlIlIlllllI.jump = llllllllllllllllIlIIIIlIlIlllllI.registerB("JumpCheck", true);
        llllllllllllllllIlIIIIlIlIlllllI.center = llllllllllllllllIlIIIIlIlIlllllI.registerB("Center", true);
        llllllllllllllllIlIIIIlIlIlllllI.rotate = llllllllllllllllIlIIIIlIlIlllllI.registerB("Rotate", true);
        llllllllllllllllIlIIIIlIlIlllllI.anvil = llllllllllllllllIlIIIIlIlIlllllI.registerB("AutoSelfAnvil", false);
        llllllllllllllllIlIIIIlIlIlllllI.centermode = llllllllllllllllIlIIIIlIlIlllllI.registerMode("CenterMode", llllllllllllllllIlIIIIlIlIllllll, "NCP");
    }

    @Override
    public void onUpdate() {
        int llllllllllllllllIlIIIIlIIlIIIlIl;
        BlockPos llllllllllllllllIlIIIIlIIlIIlIll;
        BlockPos llllllllllllllllIlIIIIlIIlIIllII;
        BlockPos llllllllllllllllIlIIIIlIIlIIllIl;
        BlockPos llllllllllllllllIlIIIIlIIlIIlllI;
        Surround llllllllllllllllIlIIIIlIIlIlIIII;
        block21: {
            block20: {
                block19: {
                    block18: {
                        if (llllllllllllllllIlIIIIlIIlIlIIII.sneak.getValue() && !Surround.mc.gameSettings.keyBindSneak.isKeyDown()) {
                            return;
                        }
                        if (!llllllllllllllllIlIIIIlIIlIlIIII.isEnabled() || Surround.mc.thePlayer == null) {
                            return;
                        }
                        if (llllllllllllllllIlIIIIlIIlIlIIII.jump.getValue() && !Surround.mc.thePlayer.onGround && !Surround.mc.thePlayer.field_184841_cd && !llllllllllllllllIlIIIIlIIlIlIIII.wasinair) {
                            llllllllllllllllIlIIIIlIIlIlIIII.disable();
                        }
                        if (llllllllllllllllIlIIIIlIIlIlIIII.wasinair) {
                            llllllllllllllllIlIIIIlIIlIlIIII.wasinair = !Surround.mc.thePlayer.onGround;
                        }
                        Vec3d llllllllllllllllIlIIIIlIIlIIllll = Surround.getInterpolatedPos((Entity)Surround.mc.thePlayer, 0.0f);
                        llllllllllllllllIlIIIIlIIlIIlllI = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).north();
                        llllllllllllllllIlIIIIlIIlIIllIl = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).south();
                        llllllllllllllllIlIIIIlIIlIIllII = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).east();
                        llllllllllllllllIlIIIIlIIlIIlIll = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).west();
                        BlockPos llllllllllllllllIlIIIIlIIlIIlIlI = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).north().up();
                        BlockPos llllllllllllllllIlIIIIlIIlIIlIIl = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).south().up();
                        BlockPos llllllllllllllllIlIIIIlIIlIIlIII = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).east().up();
                        BlockPos llllllllllllllllIlIIIIlIIlIIIlll = new BlockPos(llllllllllllllllIlIIIIlIIlIIllll).west().up();
                        int llllllllllllllllIlIIIIlIIlIIIllI = -1;
                        for (int llllllllllllllllIlIIIIlIIlIllIIl = 0; llllllllllllllllIlIIIIlIIlIllIIl < 9; ++llllllllllllllllIlIIIIlIIlIllIIl) {
                            Block llllllllllllllllIlIIIIlIIlIllIlI;
                            ItemStack llllllllllllllllIlIIIIlIIlIllIll = Surround.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIlIIIIlIIlIllIIl);
                            if (llllllllllllllllIlIIIIlIIlIllIll == ItemStack.field_190927_a || !(llllllllllllllllIlIIIIlIIlIllIll.getItem() instanceof ItemBlock) || !llllllllllllllllIlIIIIlIIlIlIIII.whiteList.contains(llllllllllllllllIlIIIIlIIlIllIlI = ((ItemBlock)llllllllllllllllIlIIIIlIIlIllIll.getItem()).getBlock())) continue;
                            llllllllllllllllIlIIIIlIIlIIIllI = llllllllllllllllIlIIIIlIIlIllIIl;
                            break;
                        }
                        if (llllllllllllllllIlIIIIlIIlIIIllI == -1) {
                            return;
                        }
                        llllllllllllllllIlIIIIlIIlIIIlIl = Surround.mc.thePlayer.inventory.currentItem;
                        Surround.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIIIIlIIlIIIllI;
                        if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIIlllI)) {
                            for (EnumFacing llllllllllllllllIlIIIIlIIlIlIlll : EnumFacing.values()) {
                                BlockPos llllllllllllllllIlIIIIlIIlIllIII = llllllllllllllllIlIIIIlIIlIIlllI.offset(llllllllllllllllIlIIIIlIIlIlIlll);
                                if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIllIII)) continue;
                                llllllllllllllllIlIIIIlIIlIIlllI = llllllllllllllllIlIIIIlIIlIllIII;
                                break block18;
                            }
                            return;
                        }
                    }
                    if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIIllIl)) {
                        for (EnumFacing llllllllllllllllIlIIIIlIIlIlIlIl : EnumFacing.values()) {
                            BlockPos llllllllllllllllIlIIIIlIIlIlIllI = llllllllllllllllIlIIIIlIIlIIllIl.offset(llllllllllllllllIlIIIIlIIlIlIlIl);
                            if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIlIllI)) continue;
                            llllllllllllllllIlIIIIlIIlIIllIl = llllllllllllllllIlIIIIlIIlIlIllI;
                            break block19;
                        }
                        return;
                    }
                }
                if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIIllII)) {
                    for (EnumFacing llllllllllllllllIlIIIIlIIlIlIIll : EnumFacing.values()) {
                        BlockPos llllllllllllllllIlIIIIlIIlIlIlII = llllllllllllllllIlIIIIlIIlIIllII.offset(llllllllllllllllIlIIIIlIIlIlIIll);
                        if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIlIlII)) continue;
                        llllllllllllllllIlIIIIlIIlIIllII = llllllllllllllllIlIIIIlIIlIlIlII;
                        break block20;
                    }
                    return;
                }
            }
            if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIIlIll)) {
                for (EnumFacing llllllllllllllllIlIIIIlIIlIlIIIl : EnumFacing.values()) {
                    BlockPos llllllllllllllllIlIIIIlIIlIlIIlI = llllllllllllllllIlIIIIlIIlIIlIll.offset(llllllllllllllllIlIIIIlIIlIlIIIl);
                    if (!Surround.hasNeighbour(llllllllllllllllIlIIIIlIIlIlIIlI)) continue;
                    llllllllllllllllIlIIIIlIIlIIlIll = llllllllllllllllIlIIIIlIIlIlIIlI;
                    break block21;
                }
                return;
            }
        }
        if (Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIlIIlllI).func_185904_a().isReplaceable() && llllllllllllllllIlIIIIlIIlIlIIII.isEntitiesEmpty(llllllllllllllllIlIIIIlIIlIIlllI)) {
            Surround.placeBlockScaffold(llllllllllllllllIlIIIIlIIlIIlllI, llllllllllllllllIlIIIIlIIlIlIIII.rotate.getValue());
        }
        if (Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIlIIllIl).func_185904_a().isReplaceable() && llllllllllllllllIlIIIIlIIlIlIIII.isEntitiesEmpty(llllllllllllllllIlIIIIlIIlIIllIl)) {
            Surround.placeBlockScaffold(llllllllllllllllIlIIIIlIIlIIllIl, llllllllllllllllIlIIIIlIIlIlIIII.rotate.getValue());
        }
        if (Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIlIIllII).func_185904_a().isReplaceable() && llllllllllllllllIlIIIIlIIlIlIIII.isEntitiesEmpty(llllllllllllllllIlIIIIlIIlIIllII)) {
            Surround.placeBlockScaffold(llllllllllllllllIlIIIIlIIlIIllII, llllllllllllllllIlIIIIlIIlIlIIII.rotate.getValue());
        }
        if (Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIlIIlIll).func_185904_a().isReplaceable() && llllllllllllllllIlIIIIlIIlIlIIII.isEntitiesEmpty(llllllllllllllllIlIIIIlIIlIIlIll)) {
            Surround.placeBlockScaffold(llllllllllllllllIlIIIIlIIlIIlIll, llllllllllllllllIlIIIIlIIlIlIIII.rotate.getValue());
        }
        Surround.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIIIIlIIlIIIlIl;
    }

    public static Vec3d getEyesPos() {
        return new Vec3d(Surround.mc.thePlayer.posX, Surround.mc.thePlayer.posY + (double)Surround.mc.thePlayer.getEyeHeight(), Surround.mc.thePlayer.posZ);
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIlIIIIIlllIIllIl, double llllllllllllllllIlIIIIIlllIIllII, double llllllllllllllllIlIIIIIlllIIlIll, double llllllllllllllllIlIIIIIlllIIlIlI) {
        return new Vec3d((llllllllllllllllIlIIIIIlllIIllIl.posX - llllllllllllllllIlIIIIIlllIIllIl.lastTickPosX) * llllllllllllllllIlIIIIIlllIIllII, (llllllllllllllllIlIIIIIlllIIllIl.posY - llllllllllllllllIlIIIIIlllIIllIl.lastTickPosY) * llllllllllllllllIlIIIIIlllIIlIll, (llllllllllllllllIlIIIIIlllIIllIl.posZ - llllllllllllllllIlIIIIIlllIIllIl.lastTickPosZ) * llllllllllllllllIlIIIIIlllIIlIlI);
    }

    public static boolean canBeClicked(BlockPos llllllllllllllllIlIIIIlIIIIIIIIl) {
        return Surround.getBlock(llllllllllllllllIlIIIIlIIIIIIIIl).canCollideCheck(Surround.getState(llllllllllllllllIlIIIIlIIIIIIIIl), false);
    }

    @Override
    public void onLivingEvent() {
        Surround llllllllllllllllIlIIIIlIIlllIllI;
        Vec3d llllllllllllllllIlIIIIlIIlllllll = Surround.getInterpolatedPos((Entity)Surround.mc.thePlayer, 0.0f);
        BlockPos llllllllllllllllIlIIIIlIIllllllI = new BlockPos(llllllllllllllllIlIIIIlIIlllllll).up().north();
        BlockPos llllllllllllllllIlIIIIlIIlllllIl = new BlockPos(llllllllllllllllIlIIIIlIIlllllll).up().south();
        BlockPos llllllllllllllllIlIIIIlIIlllllII = new BlockPos(llllllllllllllllIlIIIIlIIlllllll).up().west();
        BlockPos llllllllllllllllIlIIIIlIIllllIll = new BlockPos(llllllllllllllllIlIIIIlIIlllllll).up().east();
        IBlockState llllllllllllllllIlIIIIlIIllllIlI = Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIllllllI);
        IBlockState llllllllllllllllIlIIIIlIIllllIIl = Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIlllllIl);
        IBlockState llllllllllllllllIlIIIIlIIllllIII = Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIlllllII);
        IBlockState llllllllllllllllIlIIIIlIIlllIlll = Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIIllllIll);
        if (llllllllllllllllIlIIIIlIIllllIlI.getBlock() == Blocks.bed || llllllllllllllllIlIIIIlIIllllIIl.getBlock() == Blocks.bed || llllllllllllllllIlIIIIlIIllllIII.getBlock() == Blocks.bed || llllllllllllllllIlIIIIlIIlllIlll.getBlock() == Blocks.bed) {
            llllllllllllllllIlIIIIlIIlllIllI.placeface = true;
        }
        if (llllllllllllllllIlIIIIlIIlllIllI.placeface) {
            return;
        }
        Surround.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIIIIIllIllIIII -> llllllllllllllllIlIIIIIllIllIIII instanceof EntityPlayer).filter(llllllllllllllllIlIIIIIllIllIIlI -> llllllllllllllllIlIIIIIllIllIIlI != Surround.mc.thePlayer).filter(llllllllllllllllIlIIIIIllIllIllI -> !Friends.isFriend(llllllllllllllllIlIIIIIllIllIllI.getName())).forEach(llllllllllllllllIlIIIIIllIlllIlI -> {
            ItemStack llllllllllllllllIlIIIIIllIllllIl = ((EntityPlayer)llllllllllllllllIlIIIIIllIlllIlI).func_184614_ca();
            ItemStack llllllllllllllllIlIIIIIllIllllII = ((EntityPlayer)llllllllllllllllIlIIIIIllIlllIlI).func_184592_cb();
            if (Surround.mc.thePlayer.getDistanceToEntity(llllllllllllllllIlIIIIIllIlllIlI) < 10.0f && llllllllllllllllIlIIIIIllIllllIl.getItem() == Items.bed || llllllllllllllllIlIIIIIllIllllII.getItem() == Items.bed) {
                llllllllllllllllIlIIIIIllIlllIll.placeface = true;
            }
        });
    }

    private static PlayerControllerMP getPlayerController() {
        return Surround.mc.playerController;
    }

    public static boolean hasNeighbour(BlockPos llllllllllllllllIlIIIIlIlIIlIIII) {
        for (EnumFacing llllllllllllllllIlIIIIlIlIIlIIlI : EnumFacing.values()) {
            BlockPos llllllllllllllllIlIIIIlIlIIlIIll = llllllllllllllllIlIIIIlIlIIlIIII.offset(llllllllllllllllIlIIIIlIlIIlIIlI);
            if (Surround.mc.theWorld.getBlockState(llllllllllllllllIlIIIIlIlIIlIIll).func_185904_a().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static Vec3d getInterpolatedPos(Entity llllllllllllllllIlIIIIIlllIlllIl, float llllllllllllllllIlIIIIIlllIlllII) {
        return new Vec3d(llllllllllllllllIlIIIIIlllIlllIl.lastTickPosX, llllllllllllllllIlIIIIIlllIlllIl.lastTickPosY, llllllllllllllllIlIIIIIlllIlllIl.lastTickPosZ).add(Surround.getInterpolatedAmount(llllllllllllllllIlIIIIIlllIlllIl, llllllllllllllllIlIIIIIlllIlllII));
    }

    private boolean isEntitiesEmpty(BlockPos llllllllllllllllIlIIIIlIIIlIlllI) {
        List llllllllllllllllIlIIIIlIIIlIllll = Surround.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llllllllllllllllIlIIIIlIIIlIlllI)).stream().filter(llllllllllllllllIlIIIIIlllIIIlII -> !(llllllllllllllllIlIIIIIlllIIIlII instanceof EntityItem)).filter(llllllllllllllllIlIIIIIlllIIlIII -> !(llllllllllllllllIlIIIIIlllIIlIII instanceof EntityXPOrb)).collect(Collectors.toList());
        return llllllllllllllllIlIIIIlIIIlIllll.isEmpty();
    }

    public static void processRightClickBlock(BlockPos llllllllllllllllIlIIIIlIIIIIlIll, EnumFacing llllllllllllllllIlIIIIlIIIIIlIlI, Vec3d llllllllllllllllIlIIIIlIIIIIllII) {
        Surround.getPlayerController().func_187099_a(Surround.mc.thePlayer, Surround.mc.theWorld, llllllllllllllllIlIIIIlIIIIIlIll, llllllllllllllllIlIIIIlIIIIIlIlI, llllllllllllllllIlIIIIlIIIIIllII, EnumHand.MAIN_HAND);
    }

    public static boolean placeBlockScaffold(BlockPos llllllllllllllllIlIIIIlIIIIllIll, boolean llllllllllllllllIlIIIIlIIIIlllIl) {
        Vec3d llllllllllllllllIlIIIIlIIIIlllII = new Vec3d(Surround.mc.thePlayer.posX, Surround.mc.thePlayer.posY + (double)Surround.mc.thePlayer.getEyeHeight(), Surround.mc.thePlayer.posZ);
        for (EnumFacing llllllllllllllllIlIIIIlIIIIlllll : EnumFacing.values()) {
            BlockPos llllllllllllllllIlIIIIlIIIlIIIlI = llllllllllllllllIlIIIIlIIIIllIll.offset(llllllllllllllllIlIIIIlIIIIlllll);
            EnumFacing llllllllllllllllIlIIIIlIIIlIIIIl = llllllllllllllllIlIIIIlIIIIlllll.getOpposite();
            if (!Surround.canBeClicked(llllllllllllllllIlIIIIlIIIlIIIlI)) continue;
            Vec3d llllllllllllllllIlIIIIlIIIlIIIII = new Vec3d((Vec3i)llllllllllllllllIlIIIIlIIIlIIIlI).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllllllllllllllIlIIIIlIIIlIIIIl.getDirectionVec()).func_186678_a(0.5));
            if (llllllllllllllllIlIIIIlIIIIlllIl) {
                Surround.faceVectorPacketInstant(llllllllllllllllIlIIIIlIIIlIIIII);
            }
            Surround.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)Surround.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            Surround.processRightClickBlock(llllllllllllllllIlIIIIlIIIlIIIlI, llllllllllllllllIlIIIIlIIIlIIIIl, llllllllllllllllIlIIIIlIIIlIIIII);
            Surround.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            Surround.mc.rightClickDelayTimer = 0;
            Surround.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)Surround.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            return true;
        }
        return false;
    }

    private static float[] getNeededRotations2(Vec3d llllllllllllllllIlIIIIIlllllIIIl) {
        Vec3d llllllllllllllllIlIIIIIlllllIIII = Surround.getEyesPos();
        double llllllllllllllllIlIIIIIllllIllll = llllllllllllllllIlIIIIIlllllIIIl.xCoord - llllllllllllllllIlIIIIIlllllIIII.xCoord;
        double llllllllllllllllIlIIIIIllllIlllI = llllllllllllllllIlIIIIIlllllIIIl.yCoord - llllllllllllllllIlIIIIIlllllIIII.yCoord;
        double llllllllllllllllIlIIIIIllllIllIl = llllllllllllllllIlIIIIIlllllIIIl.zCoord - llllllllllllllllIlIIIIIlllllIIII.zCoord;
        double llllllllllllllllIlIIIIIllllIllII = Math.sqrt(llllllllllllllllIlIIIIIllllIllll * llllllllllllllllIlIIIIIllllIllll + llllllllllllllllIlIIIIIllllIllIl * llllllllllllllllIlIIIIIllllIllIl);
        float llllllllllllllllIlIIIIIllllIlIll = (float)Math.toDegrees(Math.atan2(llllllllllllllllIlIIIIIllllIllIl, llllllllllllllllIlIIIIIllllIllll)) - 90.0f;
        float llllllllllllllllIlIIIIIllllIlIlI = (float)(-Math.toDegrees(Math.atan2(llllllllllllllllIlIIIIIllllIlllI, llllllllllllllllIlIIIIIllllIllII)));
        return new float[]{Surround.mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIlIIIIIllllIlIll - Surround.mc.thePlayer.rotationYaw)), Surround.mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIlIIIIIllllIlIlI - Surround.mc.thePlayer.rotationPitch))};
    }
}

