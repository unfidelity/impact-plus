/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.module.modules.player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.ImpactPlusEvent;
import me.axua.impactplus.event.events.EventPlayerMotionUpdate;
import me.axua.impactplus.event.events.EventRenderLayers;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.BlockInteractionHelper;
import me.axua.impactplus.util.MathUtil;
import me.axua.impactplus.util.Pair;
import me.axua.impactplus.util.Timer;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AutoBuilder
extends Module {
    private /* synthetic */ ICamera camera;
    @EventHandler
    private /* synthetic */ Listener<EventPlayerMotionUpdate> OnPlayerUpdate;
    public /* synthetic */ Setting.i w;
    public /* synthetic */ Setting.d Delay;
    public /* synthetic */ Setting.i blue;
    private /* synthetic */ boolean SentPacket;
    private /* synthetic */ float PitchHead;
    private /* synthetic */ Timer timer;
    public /* synthetic */ Setting.i BlocksPerTick;
    /* synthetic */ ArrayList<BlockPos> l_Array;
    public /* synthetic */ Setting.b rainbow;
    public /* synthetic */ Setting.b Rotate;
    public /* synthetic */ Setting.i alpha;
    public /* synthetic */ Setting.i red;
    @EventHandler
    private /* synthetic */ Listener<EventRenderLayers> OnRender;
    public /* synthetic */ Setting.mode Mode;
    public /* synthetic */ Setting.b render;
    private /* synthetic */ Vec3d Center;
    public /* synthetic */ Setting.i green;

    private boolean slotEqualsBlock(int llllllllllllllllIIlIIlIIllllllIl, Block llllllllllllllllIIlIIlIIlllllllI) {
        if (AutoBuilder.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIIlIIllllllIl).getItem() instanceof ItemBlock) {
            ItemBlock llllllllllllllllIIlIIlIlIIIIIIIl = (ItemBlock)AutoBuilder.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIIlIIllllllIl).getItem();
            return llllllllllllllllIIlIIlIlIIIIIIIl.getBlock() == llllllllllllllllIIlIIlIIlllllllI;
        }
        return false;
    }

    public String getMetaData() {
        AutoBuilder llllllllllllllllIIlIIlIlIlIlIlll;
        return llllllllllllllllIIlIIlIlIlIlIlll.Mode.getValue();
    }

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIIlIIlIlIIIIlIlI) {
        AutoBuilder llllllllllllllllIIlIIlIlIIIIlIll;
        if (llllllllllllllllIIlIIlIlIIIIlIll.render.getValue()) {
            for (BlockPos llllllllllllllllIIlIIlIlIIIIllll : llllllllllllllllIIlIIlIlIIIIlIll.l_Array) {
                IBlockState llllllllllllllllIIlIIlIlIIIIlllI = AutoBuilder.mc.theWorld.getBlockState(llllllllllllllllIIlIIlIlIIIIllll);
                if (llllllllllllllllIIlIIlIlIIIIlllI != null && llllllllllllllllIIlIIlIlIIIIlllI.getBlock() != Blocks.air && llllllllllllllllIIlIIlIlIIIIlllI.getBlock() != Blocks.water) continue;
                AxisAlignedBB llllllllllllllllIIlIIlIlIIIIllIl = new AxisAlignedBB((double)llllllllllllllllIIlIIlIlIIIIllll.getX() - AutoBuilder.mc.getRenderManager().viewerPosX, (double)llllllllllllllllIIlIIlIlIIIIllll.getY() - AutoBuilder.mc.getRenderManager().viewerPosY, (double)llllllllllllllllIIlIIlIlIIIIllll.getZ() - AutoBuilder.mc.getRenderManager().viewerPosZ, (double)(llllllllllllllllIIlIIlIlIIIIllll.getX() + 1) - AutoBuilder.mc.getRenderManager().viewerPosX, (double)(llllllllllllllllIIlIIlIlIIIIllll.getY() + 1) - AutoBuilder.mc.getRenderManager().viewerPosY, (double)(llllllllllllllllIIlIIlIlIIIIllll.getZ() + 1) - AutoBuilder.mc.getRenderManager().viewerPosZ);
                llllllllllllllllIIlIIlIlIIIIlIll.camera.setPosition(AutoBuilder.mc.getRenderViewEntity().posX, AutoBuilder.mc.getRenderViewEntity().posY, AutoBuilder.mc.getRenderViewEntity().posZ);
                if (!llllllllllllllllIIlIIlIlIIIIlIll.camera.isBoundingBoxInFrustum(new AxisAlignedBB(llllllllllllllllIIlIIlIlIIIIllIl.minX + AutoBuilder.mc.getRenderManager().viewerPosX, llllllllllllllllIIlIIlIlIIIIllIl.minY + AutoBuilder.mc.getRenderManager().viewerPosY, llllllllllllllllIIlIIlIlIIIIllIl.minZ + AutoBuilder.mc.getRenderManager().viewerPosZ, llllllllllllllllIIlIIlIlIIIIllIl.maxX + AutoBuilder.mc.getRenderManager().viewerPosX, llllllllllllllllIIlIIlIlIIIIllIl.maxY + AutoBuilder.mc.getRenderManager().viewerPosY, llllllllllllllllIIlIIlIlIIIIllIl.maxZ + AutoBuilder.mc.getRenderManager().viewerPosZ))) continue;
                if (llllllllllllllllIIlIIlIlIIIIlIll.rainbow.getValue()) {
                    Tessellator.prepare(7);
                    Tessellator.drawBox(llllllllllllllllIIlIIlIlIIIIllll, Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), llllllllllllllllIIlIIlIlIIIIlIll.alpha.getValue(), 63);
                    Tessellator.release();
                    ImpactPlusTessellator.prepare(7);
                    ImpactPlusTessellator.drawBoundingBox(llllllllllllllllIIlIIlIlIIIIllIl, llllllllllllllllIIlIIlIlIIIIlIll.w.getValue(), Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), 255);
                } else {
                    Tessellator.prepare(7);
                    Tessellator.drawBox(llllllllllllllllIIlIIlIlIIIIllll, llllllllllllllllIIlIIlIlIIIIlIll.red.getValue(), llllllllllllllllIIlIIlIlIIIIlIll.green.getValue(), llllllllllllllllIIlIIlIlIIIIlIll.blue.getValue(), llllllllllllllllIIlIIlIlIIIIlIll.alpha.getValue(), 63);
                    Tessellator.release();
                    ImpactPlusTessellator.prepare(7);
                    ImpactPlusTessellator.drawBoundingBox(llllllllllllllllIIlIIlIlIIIIllIl, llllllllllllllllIIlIIlIlIIIIlIll.w.getValue(), llllllllllllllllIIlIIlIlIIIIlIll.red.getValue(), llllllllllllllllIIlIIlIlIIIIlIll.green.getValue(), llllllllllllllllIIlIIlIlIIIIlIll.blue.getValue(), 255);
                }
                ImpactPlusTessellator.release();
            }
        }
    }

    @Override
    public void setup() {
        AutoBuilder llllllllllllllllIIlIIlIlIlIlllll;
        ArrayList<String> llllllllllllllllIIlIIlIlIlIllllI = new ArrayList<String>();
        llllllllllllllllIIlIIlIlIlIllllI.add("Portal");
        llllllllllllllllIIlIIlIlIlIllllI.add("Flat");
        llllllllllllllllIIlIIlIlIlIllllI.add("Highway");
        llllllllllllllllIIlIIlIlIlIllllI.add("Wall");
        llllllllllllllllIIlIIlIlIlIllllI.add("NomadHut");
        llllllllllllllllIIlIIlIlIlIllllI.add("PP");
        llllllllllllllllIIlIIlIlIlIllllI.add("Stairs");
        llllllllllllllllIIlIIlIlIlIllllI.add("BedrockFiller");
        llllllllllllllllIIlIIlIlIlIllllI.add("BedTrap");
        llllllllllllllllIIlIIlIlIlIlllll.render = llllllllllllllllIIlIIlIlIlIlllll.registerB("Render", true);
        llllllllllllllllIIlIIlIlIlIlllll.rainbow = llllllllllllllllIIlIIlIlIlIlllll.registerB("Rainbow", true);
        llllllllllllllllIIlIIlIlIlIlllll.red = llllllllllllllllIIlIIlIlIlIlllll.registerI("Red", 80, 1, 255);
        llllllllllllllllIIlIIlIlIlIlllll.green = llllllllllllllllIIlIIlIlIlIlllll.registerI("Green", 80, 1, 255);
        llllllllllllllllIIlIIlIlIlIlllll.blue = llllllllllllllllIIlIIlIlIlIlllll.registerI("Blue", 255, 1, 255);
        llllllllllllllllIIlIIlIlIlIlllll.alpha = llllllllllllllllIIlIIlIlIlIlllll.registerI("Alpha", 26, 26, 255);
        llllllllllllllllIIlIIlIlIlIlllll.w = llllllllllllllllIIlIIlIlIlIlllll.registerI("Width", 1, 1, 5);
        llllllllllllllllIIlIIlIlIlIlllll.Mode = llllllllllllllllIIlIIlIlIlIlllll.registerMode("Mode", llllllllllllllllIIlIIlIlIlIllllI, "Portal");
        llllllllllllllllIIlIIlIlIlIlllll.Rotate = llllllllllllllllIIlIIlIlIlIlllll.registerB("Rotate", true);
        llllllllllllllllIIlIIlIlIlIlllll.BlocksPerTick = llllllllllllllllIIlIIlIlIlIlllll.registerI("BlocksPerTick", 1, 1, 10);
        llllllllllllllllIIlIIlIlIlIlllll.Delay = llllllllllllllllIIlIIlIlIlIlllll.registerD("Delay", 0.0, 0.0, 1.0);
    }

    private Block getBlock(int llllllllllllllllIIlIIlIlIIlIIIII, int llllllllllllllllIIlIIlIlIIIlllll, int llllllllllllllllIIlIIlIlIIIllllI) {
        BlockPos llllllllllllllllIIlIIlIlIIIlllIl = new BlockPos(llllllllllllllllIIlIIlIlIIlIIIII, llllllllllllllllIIlIIlIlIIIlllll, llllllllllllllllIIlIIlIlIIIllllI);
        IBlockState llllllllllllllllIIlIIlIlIIIlllII = AutoBuilder.mc.theWorld.getBlockState(llllllllllllllllIIlIIlIlIIIlllIl);
        Block llllllllllllllllIIlIIlIlIIIllIll = llllllllllllllllIIlIIlIlIIIlllII.getBlock();
        return llllllllllllllllIIlIIlIlIIIllIll;
    }

    public AutoBuilder() {
        super("AutoBuilder", Module.Category.PLAYER, "AutoBuilder");
        AutoBuilder llllllllllllllllIIlIIlIlIllIIIlI;
        llllllllllllllllIIlIIlIlIllIIIlI.Center = Vec3d.field_186680_a;
        llllllllllllllllIIlIIlIlIllIIIlI.camera = new Frustum();
        llllllllllllllllIIlIIlIlIllIIIlI.timer = new Timer();
        llllllllllllllllIIlIIlIlIllIIIlI.PitchHead = 0.0f;
        llllllllllllllllIIlIIlIlIllIIIlI.SentPacket = false;
        llllllllllllllllIIlIIlIlIllIIIlI.l_Array = new ArrayList();
        llllllllllllllllIIlIIlIlIllIIIlI.OnRender = new Listener<EventRenderLayers>(llllllllllllllllIIlIIlIIlIIIlIlI -> {
            if (llllllllllllllllIIlIIlIIlIIIlIlI.getEntityLivingBase() == AutoBuilder.mc.thePlayer) {
                AutoBuilder llllllllllllllllIIlIIlIIlIIIlIll;
                llllllllllllllllIIlIIlIIlIIIlIlI.SetHeadPitch(llllllllllllllllIIlIIlIIlIIIlIll.PitchHead == -420.0f ? AutoBuilder.mc.thePlayer.rotationPitch : llllllllllllllllIIlIIlIIlIIIlIll.PitchHead);
            }
        }, new Predicate[0]);
        llllllllllllllllIIlIIlIlIllIIIlI.OnPlayerUpdate = new Listener<EventPlayerMotionUpdate>(llllllllllllllllIIlIIlIIlIllIlIl -> {
            boolean llllllllllllllllIIlIIlIIlIlIlIII;
            AutoBuilder llllllllllllllllIIlIIlIIlIlIIlll;
            if (llllllllllllllllIIlIIlIIlIllIlIl.getEra() != ImpactPlusEvent.Era.PRE) {
                return;
            }
            if (!llllllllllllllllIIlIIlIIlIlIIlll.timer.passed(llllllllllllllllIIlIIlIIlIlIIlll.Delay.getValue() * 1000.0)) {
                return;
            }
            llllllllllllllllIIlIIlIIlIlIIlll.timer.reset();
            Vec3d llllllllllllllllIIlIIlIIlIllIlII = MathUtil.interpolateEntity((Entity)AutoBuilder.mc.thePlayer, mc.func_184121_ak());
            BlockPos llllllllllllllllIIlIIlIIlIllIIll = new BlockPos(llllllllllllllllIIlIIlIIlIllIlII.xCoord, llllllllllllllllIIlIIlIIlIllIlII.yCoord + 0.5, llllllllllllllllIIlIIlIIlIllIlII.zCoord);
            BlockPos llllllllllllllllIIlIIlIIlIllIIlI = new BlockPos(llllllllllllllllIIlIIlIIlIllIlII.xCoord, llllllllllllllllIIlIIlIIlIllIlII.yCoord, llllllllllllllllIIlIIlIIlIllIlII.zCoord).north().north();
            llllllllllllllllIIlIIlIIlIlIIlll.l_Array.clear();
            Pair<Integer, Block> llllllllllllllllIIlIIlIIlIllIIIl = llllllllllllllllIIlIIlIIlIlIIlll.findStackHotbar();
            int llllllllllllllllIIlIIlIIlIllIIII = -1;
            double llllllllllllllllIIlIIlIIlIlIllll = llllllllllllllllIIlIIlIIlIllIlII.yCoord - (double)llllllllllllllllIIlIIlIIlIllIIll.getY();
            if (llllllllllllllllIIlIIlIIlIllIIIl != null) {
                llllllllllllllllIIlIIlIIlIllIIII = llllllllllllllllIIlIIlIIlIllIIIl.getKey();
                if (llllllllllllllllIIlIIlIIlIllIIIl.getValue() instanceof BlockSlab && llllllllllllllllIIlIIlIIlIlIllll == 0.5) {
                    llllllllllllllllIIlIIlIIlIllIIll = new BlockPos(llllllllllllllllIIlIIlIIlIllIlII.xCoord, llllllllllllllllIIlIIlIIlIllIlII.yCoord + 0.5, llllllllllllllllIIlIIlIIlIllIlII.zCoord);
                    llllllllllllllllIIlIIlIIlIllIIlI = new BlockPos(llllllllllllllllIIlIIlIIlIllIlII.xCoord, llllllllllllllllIIlIIlIIlIllIlII.yCoord + 1.0, llllllllllllllllIIlIIlIIlIllIlII.zCoord).north().north();
                }
            }
            Entity llllllllllllllllIIlIIlIIlIlIlllI = mc.getRenderViewEntity();
            EnumFacing llllllllllllllllIIlIIlIIlIlIllIl = llllllllllllllllIIlIIlIIlIlIlllI.getHorizontalFacing();
            String llllllllllllllllIIlIIlIIlIlIllII = "";
            switch (llllllllllllllllIIlIIlIIlIlIllIl) {
                case NORTH: {
                    llllllllllllllllIIlIIlIIlIlIllII = "North";
                    break;
                }
                case SOUTH: {
                    llllllllllllllllIIlIIlIIlIlIllII = "South";
                    break;
                }
                case WEST: {
                    llllllllllllllllIIlIIlIIlIlIllII = "West";
                    break;
                }
                case EAST: {
                    llllllllllllllllIIlIIlIIlIlIllII = "East";
                    break;
                }
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("SourceBlocks")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.clear();
                List<BlockPos> llllllllllllllllIIlIIlIIllIlIIIl = llllllllllllllllIIlIIlIIlIlIIlll.getSphere(AutoBuilder.getPlayerPos(), 5.0f, 5, false, true, 0);
                for (BlockPos llllllllllllllllIIlIIlIIllIlIIlI : llllllllllllllllIIlIIlIIllIlIIIl) {
                    int llllllllllllllllIIlIIlIIllIlIIll = Block.getIdFromBlock((Block)llllllllllllllllIIlIIlIIlIlIIlll.getBlock(llllllllllllllllIIlIIlIIllIlIIlI.getX(), llllllllllllllllIIlIIlIIllIlIIlI.getY(), llllllllllllllllIIlIIlIIllIlIIlI.getZ()));
                    if (llllllllllllllllIIlIIlIIllIlIIll != 10) continue;
                    llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIllIlIIlI);
                }
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("BedTrap") && llllllllllllllllIIlIIlIIlIlIllII.equals("North")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().south().west().north().east().east().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().north().north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().north().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().north().north().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().north().east().east().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().north().north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().north().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().north().north().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().west().north().east().east().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north().north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north().north().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().north().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().west().north().east().east().north().north().north().north());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("BedTrap") && llllllllllllllllIIlIIlIIlIlIllII.equals("South")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().north().west().south().east().east().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().south().south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().south().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().south().south().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().south().east().east().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().south().south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().south().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().south().south().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().west().south().east().east().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south().south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south().south().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().south().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().west().south().east().east().south().south().south().south());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("BedTrap") && llllllllllllllllIIlIIlIIlIlIllII.equals("West")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().south().west().west().west().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().west().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().east().west().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().west().west().west().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().west().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().west().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().south().west().west().west().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().west().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().west().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().south().west().west().west().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().west().west().west().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().west().west().west().west().west().north());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("BedTrap") && llllllllllllllllIIlIIlIIlIlIllII.equals("East")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().south().east().east().east().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().east().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().west().east().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().east().east().east().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().east().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().east().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().south().east().east().east().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().east().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().east().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().south().east().east().east().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().east().east().east().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().east().east().east().east().east().north());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Stairs") && llllllllllllllllIIlIIlIIlIlIllII.equals("North")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Stairs") && llllllllllllllllIIlIIlIIlIlIllII.equals("South")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Stairs") && llllllllllllllllIIlIIlIIlIlIllII.equals("West")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Stairs") && llllllllllllllllIIlIIlIIlIlIllII.equals("East")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("PP") && llllllllllllllllIIlIIlIIlIlIllII.equals("North")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().up().up().up().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("PP") && llllllllllllllllIIlIIlIIlIlIllII.equals("South")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().up().up().up().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("PP") && llllllllllllllllIIlIIlIIlIlIllII.equals("West")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().up().up().up().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("PP") && llllllllllllllllIIlIIlIIlIlIllII.equals("East")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().up().up().up().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Portal") && llllllllllllllllIIlIIlIIlIlIllII.equals("North")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west().west().west().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west().west().west().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west().west().west().down().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east().up().up().up().up().west().west().west().down().down().down().down());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Portal") && llllllllllllllllIIlIIlIIlIlIllII.equals("South")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east().east().east().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east().east().east().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east().east().east().down().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west().up().up().up().up().east().east().east().down().down().down().down());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Portal") && llllllllllllllllIIlIIlIIlIlIllII.equals("West")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south().south().south().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south().south().south().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south().south().south().down().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north().up().up().up().up().south().south().south().down().down().down().down());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Portal") && llllllllllllllllIIlIIlIIlIlIllII.equals("East")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north().north().north().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north().north().north().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north().north().north().down().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south().up().up().up().up().north().north().north().down().down().down().down());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Wall") && llllllllllllllllIIlIIlIIlIlIllII.equals("North")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().north().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().north().north().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().north().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().north().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().north().north().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().north().north().west().west().west());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Wall") && llllllllllllllllIIlIIlIIlIlIllII.equals("South")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.south().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().south().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().south().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().south().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().south().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().south().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().south().south().east().east().east());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Wall") && llllllllllllllllIIlIIlIIlIlIllII.equals("West")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.west().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().west().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().west().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().west().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().west().west().south().south().south());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Wall") && llllllllllllllllIIlIIlIIlIlIllII.equals("East")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.east().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().east().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().east().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().east().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().east().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().east().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.up().up().east().east().north().north().north());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Highway") && llllllllllllllllIIlIIlIIlIlIllII.equals("North")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().east().east().east().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().north().west().west().west().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Highway") && llllllllllllllllIIlIIlIIlIlIllII.equals("South")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().east().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().west().west().west().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().south().east().east().east().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Highway") && llllllllllllllllIIlIIlIIlIlIllII.equals("West")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().north().north().north().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().west().south().south().south().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Highway") && llllllllllllllllIIlIIlIIlIlIllII.equals("East")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().south().south().south().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().east().north().north().north().up());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("NomadHut")) {
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().west());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up().up());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up().up().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up().up().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up().up().north().north().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up().up().north().north().down().down());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().west().west().west().north().up().up().north().north().down().down().south());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().west().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().west().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().north().north().north());
                llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.north().north().west().up().up().east().east().down().down().east().south().up().up().south().south().down().down().south().west().up().up().up().west().west().north().north().north());
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Flat")) {
                for (int llllllllllllllllIIlIIlIIllIIllll = -3; llllllllllllllllIIlIIlIIllIIllll <= 3; ++llllllllllllllllIIlIIlIIllIIllll) {
                    for (int llllllllllllllllIIlIIlIIllIlIIII = -3; llllllllllllllllIIlIIlIIllIlIIII <= 3; ++llllllllllllllllIIlIIlIIllIlIIII) {
                        llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().add(llllllllllllllllIIlIIlIIllIIllll, 0, llllllllllllllllIIlIIlIIllIlIIII));
                    }
                }
            }
            if (llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("BedrockFiller")) {
                for (int llllllllllllllllIIlIIlIIllIIllIl = -3; llllllllllllllllIIlIIlIIllIIllIl <= 3; ++llllllllllllllllIIlIIlIIllIIllIl) {
                    for (int llllllllllllllllIIlIIlIIllIIlllI = -3; llllllllllllllllIIlIIlIIllIIlllI <= 3; ++llllllllllllllllIIlIIlIIllIIlllI) {
                        llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().down().down().add(llllllllllllllllIIlIIlIIllIIllIl, 0, llllllllllllllllIIlIIlIIllIIlllI));
                    }
                }
                for (int llllllllllllllllIIlIIlIIllIIlIll = -3; llllllllllllllllIIlIIlIIllIIlIll <= 3; ++llllllllllllllllIIlIIlIIllIIlIll) {
                    for (int llllllllllllllllIIlIIlIIllIIllII = -3; llllllllllllllllIIlIIlIIllIIllII <= 3; ++llllllllllllllllIIlIIlIIllIIllII) {
                        llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().down().add(llllllllllllllllIIlIIlIIllIIlIll, 0, llllllllllllllllIIlIIlIIllIIllII));
                    }
                }
                for (int llllllllllllllllIIlIIlIIllIIlIIl = -3; llllllllllllllllIIlIIlIIllIIlIIl <= 3; ++llllllllllllllllIIlIIlIIllIIlIIl) {
                    for (int llllllllllllllllIIlIIlIIllIIlIlI = -3; llllllllllllllllIIlIIlIIllIIlIlI <= 3; ++llllllllllllllllIIlIIlIIllIIlIlI) {
                        llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().down().add(llllllllllllllllIIlIIlIIllIIlIIl, 0, llllllllllllllllIIlIIlIIllIIlIlI));
                    }
                }
                for (int llllllllllllllllIIlIIlIIllIIIlll = -3; llllllllllllllllIIlIIlIIllIIIlll <= 3; ++llllllllllllllllIIlIIlIIllIIIlll) {
                    for (int llllllllllllllllIIlIIlIIllIIlIII = -3; llllllllllllllllIIlIIlIIllIIlIII <= 3; ++llllllllllllllllIIlIIlIIllIIlIII) {
                        llllllllllllllllIIlIIlIIlIlIIlll.l_Array.add(llllllllllllllllIIlIIlIIlIllIIll.down().add(llllllllllllllllIIlIIlIIllIIIlll, 0, llllllllllllllllIIlIIlIIllIIlIII));
                    }
                }
            }
            boolean llllllllllllllllIIlIIlIIlIlIlIll = false;
            float[] llllllllllllllllIIlIIlIIlIlIlIlI = null;
            if (llllllllllllllllIIlIIlIIlIllIIII != -1 && AutoBuilder.mc.thePlayer.onGround) {
                int llllllllllllllllIIlIIlIIllIIIIll = AutoBuilder.mc.thePlayer.inventory.currentItem;
                AutoBuilder.mc.thePlayer.inventory.currentItem = llllllllllllllllIIlIIlIIlIllIIII;
                AutoBuilder.mc.playerController.updateController();
                int llllllllllllllllIIlIIlIIllIIIlII = llllllllllllllllIIlIIlIIlIlIIlll.BlocksPerTick.getValue();
                for (BlockPos llllllllllllllllIIlIIlIIllIIIlIl : llllllllllllllllIIlIIlIIlIlIIlll.l_Array) {
                    BlockInteractionHelper.PlaceResult llllllllllllllllIIlIIlIIllIIIllI = BlockInteractionHelper.place(llllllllllllllllIIlIIlIIllIIIlIl, 5.0f, false, llllllllllllllllIIlIIlIIlIlIllll == -0.5);
                    if (llllllllllllllllIIlIIlIIllIIIllI != BlockInteractionHelper.PlaceResult.Placed) continue;
                    llllllllllllllllIIlIIlIIlIlIlIll = true;
                    llllllllllllllllIIlIIlIIlIlIlIlI = BlockInteractionHelper.getLegitRotations(new Vec3d((double)llllllllllllllllIIlIIlIIllIIIlIl.getX(), (double)llllllllllllllllIIlIIlIIllIIIlIl.getY(), (double)llllllllllllllllIIlIIlIIllIIIlIl.getZ()));
                    if (--llllllllllllllllIIlIIlIIllIIIlII > 0) continue;
                    break;
                }
                if (!llllllllllllllllIIlIIlIIlIlIIlll.slotEqualsBlock(llllllllllllllllIIlIIlIIllIIIIll, llllllllllllllllIIlIIlIIlIllIIIl.getValue())) {
                    AutoBuilder.mc.thePlayer.inventory.currentItem = llllllllllllllllIIlIIlIIllIIIIll;
                }
                AutoBuilder.mc.playerController.updateController();
            }
            if (!llllllllllllllllIIlIIlIIlIlIlIll && llllllllllllllllIIlIIlIIlIlIIlll.Mode.getValue().equals("Portal")) {
                if (AutoBuilder.mc.theWorld.getBlockState(llllllllllllllllIIlIIlIIlIlIIlll.l_Array.get(0).up()).getBlock() == Blocks.portal) {
                    return;
                }
                for (int llllllllllllllllIIlIIlIIllIIIIIl = 0; llllllllllllllllIIlIIlIIllIIIIIl < 9; ++llllllllllllllllIIlIIlIIllIIIIIl) {
                    ItemStack llllllllllllllllIIlIIlIIllIIIIlI = AutoBuilder.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIIlIIllIIIIIl);
                    if (llllllllllllllllIIlIIlIIllIIIIlI.func_190926_b() || llllllllllllllllIIlIIlIIllIIIIlI.getItem() != Items.flint_and_steel) continue;
                    AutoBuilder.mc.thePlayer.inventory.currentItem = llllllllllllllllIIlIIlIIllIIIIIl;
                    AutoBuilder.mc.playerController.updateController();
                    break;
                }
                if (llllllllllllllllIIlIIlIIlIlIIlll.SentPacket) {
                    mc.getNetHandler().addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llllllllllllllllIIlIIlIIlIlIIlll.l_Array.get(0), EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                }
                llllllllllllllllIIlIIlIIlIlIlIlI = BlockInteractionHelper.getLegitRotations(new Vec3d((double)llllllllllllllllIIlIIlIIlIlIIlll.l_Array.get(0).getX(), (double)llllllllllllllllIIlIIlIIlIlIIlll.l_Array.get(0).getY(), (double)llllllllllllllllIIlIIlIIlIlIIlll.l_Array.get(0).getZ()));
                llllllllllllllllIIlIIlIIlIlIlIll = true;
            }
            if (!llllllllllllllllIIlIIlIIlIlIIlll.Rotate.getValue() || !llllllllllllllllIIlIIlIIlIlIlIll || llllllllllllllllIIlIIlIIlIlIlIlI == null) {
                llllllllllllllllIIlIIlIIlIlIIlll.PitchHead = -420.0f;
                llllllllllllllllIIlIIlIIlIlIIlll.SentPacket = false;
                return;
            }
            llllllllllllllllIIlIIlIIlIllIlIl.cancel();
            boolean llllllllllllllllIIlIIlIIlIlIlIIl = AutoBuilder.mc.thePlayer.isSprinting();
            if (llllllllllllllllIIlIIlIIlIlIlIIl != AutoBuilder.mc.thePlayer.serverSprintState) {
                if (llllllllllllllllIIlIIlIIlIlIlIIl) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoBuilder.mc.thePlayer, CPacketEntityAction.Action.START_SPRINTING));
                } else {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoBuilder.mc.thePlayer, CPacketEntityAction.Action.STOP_SPRINTING));
                }
                AutoBuilder.mc.thePlayer.serverSprintState = llllllllllllllllIIlIIlIIlIlIlIIl;
            }
            if ((llllllllllllllllIIlIIlIIlIlIlIII = AutoBuilder.mc.thePlayer.isSneaking()) != AutoBuilder.mc.thePlayer.serverSneakState) {
                if (llllllllllllllllIIlIIlIIlIlIlIII) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoBuilder.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
                } else {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)AutoBuilder.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                AutoBuilder.mc.thePlayer.serverSneakState = llllllllllllllllIIlIIlIIlIlIlIII;
            }
            if (mc.getRenderViewEntity() == AutoBuilder.mc.thePlayer) {
                boolean llllllllllllllllIIlIIlIIlIllIlll;
                void llllllllllllllllIIlIIlIIllIIIIII = llllllllllllllllIIlIIlIIlIlIlIlI[1];
                void llllllllllllllllIIlIIlIIlIllllll = llllllllllllllllIIlIIlIIlIlIlIlI[0];
                AutoBuilder.mc.thePlayer.rotationYawHead = llllllllllllllllIIlIIlIIlIllllll;
                llllllllllllllllIIlIIlIIlIlIIlll.PitchHead = llllllllllllllllIIlIIlIIllIIIIII;
                AxisAlignedBB llllllllllllllllIIlIIlIIlIlllllI = AutoBuilder.mc.thePlayer.getEntityBoundingBox();
                double llllllllllllllllIIlIIlIIlIllllIl = AutoBuilder.mc.thePlayer.posX - AutoBuilder.mc.thePlayer.lastReportedPosX;
                double llllllllllllllllIIlIIlIIlIllllII = llllllllllllllllIIlIIlIIlIlllllI.minY - AutoBuilder.mc.thePlayer.lastReportedPosY;
                double llllllllllllllllIIlIIlIIlIlllIll = AutoBuilder.mc.thePlayer.posZ - AutoBuilder.mc.thePlayer.lastReportedPosZ;
                double llllllllllllllllIIlIIlIIlIlllIlI = (double)(llllllllllllllllIIlIIlIIlIllllll - AutoBuilder.mc.thePlayer.lastReportedYaw);
                double llllllllllllllllIIlIIlIIlIlllIIl = (double)(llllllllllllllllIIlIIlIIllIIIIII - AutoBuilder.mc.thePlayer.lastReportedPitch);
                ++AutoBuilder.mc.thePlayer.positionUpdateTicks;
                boolean llllllllllllllllIIlIIlIIlIlllIII = llllllllllllllllIIlIIlIIlIllllIl * llllllllllllllllIIlIIlIIlIllllIl + llllllllllllllllIIlIIlIIlIllllII * llllllllllllllllIIlIIlIIlIllllII + llllllllllllllllIIlIIlIIlIlllIll * llllllllllllllllIIlIIlIIlIlllIll > 9.0E-4 || AutoBuilder.mc.thePlayer.positionUpdateTicks >= 20;
                boolean bl = llllllllllllllllIIlIIlIIlIllIlll = llllllllllllllllIIlIIlIIlIlllIlI != 0.0 || llllllllllllllllIIlIIlIIlIlllIIl != 0.0;
                if (AutoBuilder.mc.thePlayer.func_184218_aH()) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.PositionRotation(AutoBuilder.mc.thePlayer.motionX, -999.0, AutoBuilder.mc.thePlayer.motionZ, (float)llllllllllllllllIIlIIlIIlIllllll, (float)llllllllllllllllIIlIIlIIllIIIIII, AutoBuilder.mc.thePlayer.onGround));
                    llllllllllllllllIIlIIlIIlIlllIII = false;
                } else if (llllllllllllllllIIlIIlIIlIlllIII && llllllllllllllllIIlIIlIIlIllIlll) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.PositionRotation(AutoBuilder.mc.thePlayer.posX, llllllllllllllllIIlIIlIIlIlllllI.minY, AutoBuilder.mc.thePlayer.posZ, (float)llllllllllllllllIIlIIlIIlIllllll, (float)llllllllllllllllIIlIIlIIllIIIIII, AutoBuilder.mc.thePlayer.onGround));
                } else if (llllllllllllllllIIlIIlIIlIlllIII) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(AutoBuilder.mc.thePlayer.posX, llllllllllllllllIIlIIlIIlIlllllI.minY, AutoBuilder.mc.thePlayer.posZ, AutoBuilder.mc.thePlayer.onGround));
                } else if (llllllllllllllllIIlIIlIIlIllIlll) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation((float)llllllllllllllllIIlIIlIIlIllllll, (float)llllllllllllllllIIlIIlIIllIIIIII, AutoBuilder.mc.thePlayer.onGround));
                } else if (AutoBuilder.mc.thePlayer.field_184841_cd != AutoBuilder.mc.thePlayer.onGround) {
                    AutoBuilder.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer(AutoBuilder.mc.thePlayer.onGround));
                }
                if (llllllllllllllllIIlIIlIIlIlllIII) {
                    AutoBuilder.mc.thePlayer.lastReportedPosX = AutoBuilder.mc.thePlayer.posX;
                    AutoBuilder.mc.thePlayer.lastReportedPosY = llllllllllllllllIIlIIlIIlIlllllI.minY;
                    AutoBuilder.mc.thePlayer.lastReportedPosZ = AutoBuilder.mc.thePlayer.posZ;
                    AutoBuilder.mc.thePlayer.positionUpdateTicks = 0;
                }
                if (llllllllllllllllIIlIIlIIlIllIlll) {
                    AutoBuilder.mc.thePlayer.lastReportedYaw = llllllllllllllllIIlIIlIIlIllllll;
                    AutoBuilder.mc.thePlayer.lastReportedPitch = llllllllllllllllIIlIIlIIllIIIIII;
                }
                llllllllllllllllIIlIIlIIlIlIIlll.SentPacket = true;
                AutoBuilder.mc.thePlayer.field_184841_cd = AutoBuilder.mc.thePlayer.onGround;
                AutoBuilder.mc.thePlayer.field_189811_cr = AutoBuilder.mc.thePlayer.mc.gameSettings.field_189989_R;
            }
        }, new Predicate[0]);
    }

    private Pair<Integer, Block> findStackHotbar() {
        if (AutoBuilder.mc.thePlayer.func_184614_ca().getItem() instanceof ItemBlock) {
            return new Pair<Integer, Block>(AutoBuilder.mc.thePlayer.inventory.currentItem, ((ItemBlock)AutoBuilder.mc.thePlayer.func_184614_ca().getItem()).getBlock());
        }
        for (int llllllllllllllllIIlIIlIIllllIlIl = 0; llllllllllllllllIIlIIlIIllllIlIl < 9; ++llllllllllllllllIIlIIlIIllllIlIl) {
            ItemStack llllllllllllllllIIlIIlIIllllIllI = Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIIlIIllllIlIl);
            if (!(llllllllllllllllIIlIIlIIllllIllI.getItem() instanceof ItemBlock)) continue;
            ItemBlock llllllllllllllllIIlIIlIIllllIlll = (ItemBlock)llllllllllllllllIIlIIlIIllllIllI.getItem();
            return new Pair<Integer, Block>(llllllllllllllllIIlIIlIIllllIlIl, llllllllllllllllIIlIIlIIllllIlll.getBlock());
        }
        return null;
    }

    @Override
    protected void onDisable() {
        AutoBuilder llllllllllllllllIIlIIlIIlllIllll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIIlIIlIIlllIllll);
    }

    public List<BlockPos> getSphere(BlockPos llllllllllllllllIIlIIlIlIlIIIIII, float llllllllllllllllIIlIIlIlIIllllll, int llllllllllllllllIIlIIlIlIIllIlII, boolean llllllllllllllllIIlIIlIlIIllllIl, boolean llllllllllllllllIIlIIlIlIIllllII, int llllllllllllllllIIlIIlIlIIllIIIl) {
        ArrayList<BlockPos> llllllllllllllllIIlIIlIlIIlllIlI = new ArrayList<BlockPos>();
        int llllllllllllllllIIlIIlIlIIlllIIl = llllllllllllllllIIlIIlIlIlIIIIII.getX();
        int llllllllllllllllIIlIIlIlIIlllIII = llllllllllllllllIIlIIlIlIlIIIIII.getY();
        int llllllllllllllllIIlIIlIlIIllIlll = llllllllllllllllIIlIIlIlIlIIIIII.getZ();
        int llllllllllllllllIIlIIlIlIlIIIIlI = llllllllllllllllIIlIIlIlIIlllIIl - (int)llllllllllllllllIIlIIlIlIIllllll;
        while ((float)llllllllllllllllIIlIIlIlIlIIIIlI <= (float)llllllllllllllllIIlIIlIlIIlllIIl + llllllllllllllllIIlIIlIlIIllllll) {
            int llllllllllllllllIIlIIlIlIlIIIIll = llllllllllllllllIIlIIlIlIIllIlll - (int)llllllllllllllllIIlIIlIlIIllllll;
            while ((float)llllllllllllllllIIlIIlIlIlIIIIll <= (float)llllllllllllllllIIlIIlIlIIllIlll + llllllllllllllllIIlIIlIlIIllllll) {
                int llllllllllllllllIIlIIlIlIlIIIlII = llllllllllllllllIIlIIlIlIIllllII ? llllllllllllllllIIlIIlIlIIlllIII - (int)llllllllllllllllIIlIIlIlIIllllll : llllllllllllllllIIlIIlIlIIlllIII;
                while (true) {
                    float f = llllllllllllllllIIlIIlIlIlIIIlII;
                    float f2 = llllllllllllllllIIlIIlIlIIllllII ? (float)llllllllllllllllIIlIIlIlIIlllIII + llllllllllllllllIIlIIlIlIIllllll : (float)(llllllllllllllllIIlIIlIlIIlllIII + llllllllllllllllIIlIIlIlIIllIlII);
                    if (!(f < f2)) break;
                    double llllllllllllllllIIlIIlIlIlIIIlIl = (llllllllllllllllIIlIIlIlIIlllIIl - llllllllllllllllIIlIIlIlIlIIIIlI) * (llllllllllllllllIIlIIlIlIIlllIIl - llllllllllllllllIIlIIlIlIlIIIIlI) + (llllllllllllllllIIlIIlIlIIllIlll - llllllllllllllllIIlIIlIlIlIIIIll) * (llllllllllllllllIIlIIlIlIIllIlll - llllllllllllllllIIlIIlIlIlIIIIll) + (llllllllllllllllIIlIIlIlIIllllII ? (llllllllllllllllIIlIIlIlIIlllIII - llllllllllllllllIIlIIlIlIlIIIlII) * (llllllllllllllllIIlIIlIlIIlllIII - llllllllllllllllIIlIIlIlIlIIIlII) : 0);
                    if (!(!(llllllllllllllllIIlIIlIlIlIIIlIl < (double)(llllllllllllllllIIlIIlIlIIllllll * llllllllllllllllIIlIIlIlIIllllll)) || llllllllllllllllIIlIIlIlIIllllIl && llllllllllllllllIIlIIlIlIlIIIlIl < (double)((llllllllllllllllIIlIIlIlIIllllll - 1.0f) * (llllllllllllllllIIlIIlIlIIllllll - 1.0f)))) {
                        BlockPos llllllllllllllllIIlIIlIlIlIIIllI = new BlockPos(llllllllllllllllIIlIIlIlIlIIIIlI, llllllllllllllllIIlIIlIlIlIIIlII + llllllllllllllllIIlIIlIlIIllIIIl, llllllllllllllllIIlIIlIlIlIIIIll);
                        llllllllllllllllIIlIIlIlIIlllIlI.add(llllllllllllllllIIlIIlIlIlIIIllI);
                    }
                    ++llllllllllllllllIIlIIlIlIlIIIlII;
                }
                ++llllllllllllllllIIlIIlIlIlIIIIll;
            }
            ++llllllllllllllllIIlIIlIlIlIIIIlI;
        }
        return llllllllllllllllIIlIIlIlIIlllIlI;
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(AutoBuilder.mc.thePlayer.posX), Math.floor(AutoBuilder.mc.thePlayer.posY), Math.floor(AutoBuilder.mc.thePlayer.posZ));
    }

    @Override
    public void onEnable() {
        AutoBuilder llllllllllllllllIIlIIlIlIlIllIlI;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIIlIIlIlIlIllIlI);
        super.onEnable();
        if (AutoBuilder.mc.thePlayer == null) {
            llllllllllllllllIIlIIlIlIlIllIlI.toggle();
            return;
        }
        llllllllllllllllIIlIIlIlIlIllIlI.timer.reset();
    }

    public static class ColourConverter {
        public ColourConverter() {
            ColourConverter llllllllllllllllIIlIlllllIIIIIlI;
        }

        public static int rgbToInt(int llllllllllllllllIIlIllllIllllIII, int llllllllllllllllIIlIllllIlllIlll, int llllllllllllllllIIlIllllIllllIlI, int llllllllllllllllIIlIllllIlllIlIl) {
            return llllllllllllllllIIlIllllIllllIII << 16 | llllllllllllllllIIlIllllIlllIlll << 8 | llllllllllllllllIIlIllllIllllIlI | llllllllllllllllIIlIllllIlllIlIl << 24;
        }
    }
}

