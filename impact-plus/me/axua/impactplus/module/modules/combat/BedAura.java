/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.tileentity.TileEntityBed
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.BlockInteractionHelper;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class BedAura
extends Module {
    /* synthetic */ int Posidmid;
    /* synthetic */ boolean negxcheck;
    /* synthetic */ BlockPos mid;
    /* synthetic */ int Posidnegx;
    private /* synthetic */ BlockPos render2;
    /* synthetic */ double nearnegz;
    /* synthetic */ BlockPos negx;
    /* synthetic */ boolean negzcheck;
    /* synthetic */ int Posidnegz;
    /* synthetic */ int remove;
    /* synthetic */ BlockPos posz;
    /* synthetic */ Setting.b ghosthand;
    /* synthetic */ Setting.b renders;
    /* synthetic */ boolean poszcheck;
    /* synthetic */ double nearposx;
    /* synthetic */ float bruhyaw;
    /* synthetic */ BlockPos playerPos;
    /* synthetic */ double nearposz;
    /* synthetic */ Setting.i SlotTooRefill;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> packetSendListener;
    /* synthetic */ Setting.i range;
    /* synthetic */ int Posidposx;
    /* synthetic */ Setting.i delay;
    private /* synthetic */ ArrayList<BlockPos> friendpos;
    /* synthetic */ Setting.b rainbow;
    /* synthetic */ Setting.i espB;
    /* synthetic */ Setting.i espG;
    /* synthetic */ BlockPos negz;
    /* synthetic */ double nearnegx;
    /* synthetic */ Setting.i espR;
    /* synthetic */ BlockPos posx;
    /* synthetic */ boolean posxcheck;
    /* synthetic */ int Posidposz;
    private /* synthetic */ BlockPos render;

    @Override
    public void setup() {
        BedAura llllllllllllllllIlIlllIllIllIllI;
        llllllllllllllllIlIlllIllIllIllI.ghosthand = llllllllllllllllIlIlllIllIllIllI.registerB("GhostHand", true);
        llllllllllllllllIlIlllIllIllIllI.renders = llllllllllllllllIlIlllIllIllIllI.registerB("Render", true);
        llllllllllllllllIlIlllIllIllIllI.rainbow = llllllllllllllllIlIlllIllIllIllI.registerB("Rainbow", true);
        llllllllllllllllIlIlllIllIllIllI.espR = llllllllllllllllIlIlllIllIllIllI.registerI("Red", 255, 0, 255);
        llllllllllllllllIlIlllIllIllIllI.espG = llllllllllllllllIlIlllIllIllIllI.registerI("Green", 0, 0, 255);
        llllllllllllllllIlIlllIllIllIllI.espB = llllllllllllllllIlIlllIllIllIllI.registerI("Blue", 0, 0, 255);
        llllllllllllllllIlIlllIllIllIllI.delay = llllllllllllllllIlIlllIllIllIllI.registerI("Delay", 12, 1, 20);
        llllllllllllllllIlIlllIllIllIllI.range = llllllllllllllllIlIlllIllIllIllI.registerI("Range", 6, 1, 10);
        llllllllllllllllIlIlllIllIllIllI.SlotTooRefill = llllllllllllllllIlIlllIllIllIllI.registerI("SlotTooRefill", 0, 0, 8);
    }

    @Override
    public void onEnable() {
        BedAura llllllllllllllllIlIlllIllIllIIll;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIlIlllIllIllIIll);
        if (BedAura.mc.thePlayer == null) {
            llllllllllllllllIlIlllIllIllIIll.disable();
        }
        llllllllllllllllIlIlllIllIllIIll.remove = 1;
        llllllllllllllllIlIlllIllIllIIll.render2 = null;
        llllllllllllllllIlIlllIllIllIIll.render = null;
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIlIlllIllIIIIIll, double llllllllllllllllIlIlllIllIIIIllI, double llllllllllllllllIlIlllIllIIIIIIl, double llllllllllllllllIlIlllIllIIIIlII) {
        return new Vec3d((llllllllllllllllIlIlllIllIIIIIll.posX - llllllllllllllllIlIlllIllIIIIIll.lastTickPosX) * llllllllllllllllIlIlllIllIIIIllI, (llllllllllllllllIlIlllIllIIIIIll.posY - llllllllllllllllIlIlllIllIIIIIll.lastTickPosY) * llllllllllllllllIlIlllIllIIIIIIl, (llllllllllllllllIlIlllIllIIIIIll.posZ - llllllllllllllllIlIlllIllIIIIIll.lastTickPosZ) * llllllllllllllllIlIlllIllIIIIlII);
    }

    private void placeBlock(BlockPos llllllllllllllllIlIlllIlIllllIIl, EnumFacing llllllllllllllllIlIlllIlIlllIIll) {
        BlockPos llllllllllllllllIlIlllIlIlllIlll = llllllllllllllllIlIlllIlIllllIIl.offset(llllllllllllllllIlIlllIlIlllIIll);
        EnumFacing llllllllllllllllIlIlllIlIlllIllI = llllllllllllllllIlIlllIlIlllIIll.getOpposite();
        Vec3d llllllllllllllllIlIlllIlIlllIlIl = new Vec3d((Vec3i)llllllllllllllllIlIlllIlIlllIlll).addVector(0.5, 0.5, 0.5).add(new Vec3d(llllllllllllllllIlIlllIlIlllIllI.getDirectionVec()).func_186678_a(0.5));
        BlockInteractionHelper.faceVectorPacketInstant(llllllllllllllllIlIlllIlIlllIlIl);
        BedAura.mc.playerController.func_187099_a(BedAura.mc.thePlayer, BedAura.mc.theWorld, llllllllllllllllIlIlllIlIlllIlll, llllllllllllllllIlIlllIlIlllIllI, llllllllllllllllIlIlllIlIlllIlIl, EnumHand.MAIN_HAND);
        BedAura.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
    }

    public static Vec3d getInterpolatedAmount(Entity llllllllllllllllIlIlllIllIIIllIl, double llllllllllllllllIlIlllIllIIIlllI) {
        return BedAura.getInterpolatedAmount(llllllllllllllllIlIlllIllIIIllIl, llllllllllllllllIlIlllIllIIIlllI, llllllllllllllllIlIlllIllIIIlllI, llllllllllllllllIlIlllIllIIIlllI);
    }

    @Override
    public void onDisable() {
        BedAura llllllllllllllllIlIlllIlIllIlllI;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIlIlllIlIllIlllI);
        llllllllllllllllIlIlllIlIllIlllI.remove = 1;
        llllllllllllllllIlIlllIlIllIlllI.render2 = null;
        llllllllllllllllIlIlllIlIllIlllI.render = null;
    }

    public void update() {
        BedAura llllllllllllllllIlIlllIllIlIllIl;
        if (llllllllllllllllIlIlllIllIlIllIl.friendpos == null) {
            llllllllllllllllIlIlllIllIlIllIl.friendpos = new ArrayList();
        } else {
            llllllllllllllllIlIlllIllIlIllIl.friendpos.clear();
        }
        BedAura.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIlllIIllllIlII -> llllllllllllllllIlIlllIIllllIlII instanceof EntityPlayer).filter(llllllllllllllllIlIlllIIllllIllI -> llllllllllllllllIlIlllIIllllIllI != BedAura.mc.thePlayer).filter(llllllllllllllllIlIlllIIlllllIIl -> Friends.isFriend(llllllllllllllllIlIlllIIlllllIIl.getName())).filter(llllllllllllllllIlIlllIIllllllIl -> !llllllllllllllllIlIlllIIllllllIl.isDead).filter(llllllllllllllllIlIlllIlIIIIIIII -> !(((EntityPlayer)llllllllllllllllIlIlllIlIIIIIIII).getHealth() + ((EntityPlayer)llllllllllllllllIlIlllIlIIIIIIII).getAbsorptionAmount() <= 0.0f)).forEach(llllllllllllllllIlIlllIlIIIIlIII -> {
            BedAura llllllllllllllllIlIlllIlIIIIIlIl;
            Vec3d llllllllllllllllIlIlllIlIIIIIllI = BedAura.getInterpolatedPos(llllllllllllllllIlIlllIlIIIIlIII, mc.func_184121_ak());
            BlockPos llllllllllllllllIlIlllIlIIIIIlll = new BlockPos(llllllllllllllllIlIlllIlIIIIIllI);
            llllllllllllllllIlIlllIlIIIIIlIl.friendpos.add(llllllllllllllllIlIlllIlIIIIIlll);
        });
        BedAura.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIlllIlIIIIlllI -> llllllllllllllllIlIlllIlIIIIlllI instanceof EntityPlayer).filter(llllllllllllllllIlIlllIlIIIlIIIl -> {
            BedAura llllllllllllllllIlIlllIlIIIlIlII;
            return BedAura.mc.thePlayer.getDistanceToEntity(llllllllllllllllIlIlllIlIIIlIIIl) <= (float)llllllllllllllllIlIlllIlIIIlIlII.range.getValue();
        }).filter(llllllllllllllllIlIlllIlIIIllIII -> llllllllllllllllIlIlllIlIIIllIII != BedAura.mc.thePlayer).filter(llllllllllllllllIlIlllIlIIIllIlI -> !Friends.isFriend(llllllllllllllllIlIlllIlIIIllIlI.getName())).filter(llllllllllllllllIlIlllIlIIIlllIl -> !llllllllllllllllIlIlllIlIIIlllIl.isDead).filter(llllllllllllllllIlIlllIlIIlIIIII -> !(((EntityPlayer)llllllllllllllllIlIlllIlIIlIIIII).getHealth() + ((EntityPlayer)llllllllllllllllIlIlllIlIIlIIIII).getAbsorptionAmount() <= 0.0f)).sorted(Comparator.comparing(llllllllllllllllIlIlllIlIIlIIlII -> Float.valueOf(BedAura.mc.thePlayer.getDistanceToEntity(llllllllllllllllIlIlllIlIIlIIlII)))).forEach(llllllllllllllllIlIlllIlIIllIIll -> {
            double llllllllllllllllIlIlllIlIIllIllI;
            double llllllllllllllllIlIlllIlIIllIlll;
            double llllllllllllllllIlIlllIlIIllIlIl;
            BedAura llllllllllllllllIlIlllIlIIllIlII;
            llllllllllllllllIlIlllIlIIllIlII.remove = 0;
            llllllllllllllllIlIlllIlIIllIlII.render = null;
            llllllllllllllllIlIlllIlIIllIlII.render2 = null;
            int llllllllllllllllIlIlllIlIlIIIIII = (int)llllllllllllllllIlIlllIlIIllIIll.posX;
            int llllllllllllllllIlIlllIlIIllllll = (int)llllllllllllllllIlIlllIlIIllIIll.posY;
            int llllllllllllllllIlIlllIlIIlllllI = (int)llllllllllllllllIlIlllIlIIllIIll.posZ;
            int llllllllllllllllIlIlllIlIIllllIl = (int)BedAura.mc.thePlayer.posX;
            int llllllllllllllllIlIlllIlIIllllII = (int)BedAura.mc.thePlayer.posY;
            int llllllllllllllllIlIlllIlIIlllIll = (int)BedAura.mc.thePlayer.posZ;
            if (llllllllllllllllIlIlllIlIlIIIIII == llllllllllllllllIlIlllIlIIllllIl && llllllllllllllllIlIlllIlIIllllll == llllllllllllllllIlIlllIlIIllllII && llllllllllllllllIlIlllIlIIlllllI == llllllllllllllllIlIlllIlIIlllIll) {
                return;
            }
            Vec3d llllllllllllllllIlIlllIlIIlllIlI = BedAura.getInterpolatedPos(llllllllllllllllIlIlllIlIIllIIll, mc.func_184121_ak());
            llllllllllllllllIlIlllIlIIllIlII.playerPos = new BlockPos(llllllllllllllllIlIlllIlIIlllIlI);
            llllllllllllllllIlIlllIlIIllIlII.mid = llllllllllllllllIlIlllIlIIllIlII.playerPos.add(0, 1, 0);
            llllllllllllllllIlIlllIlIIllIlII.posx = llllllllllllllllIlIlllIlIIllIlII.playerPos.add(1, 1, 0);
            llllllllllllllllIlIlllIlIIllIlII.negx = llllllllllllllllIlIlllIlIIllIlII.playerPos.add(-1, 1, 0);
            llllllllllllllllIlIlllIlIIllIlII.posz = llllllllllllllllIlIlllIlIIllIlII.playerPos.add(0, 1, 1);
            llllllllllllllllIlIlllIlIIllIlII.negz = llllllllllllllllIlIlllIlIIllIlII.playerPos.add(0, 1, -1);
            if (!llllllllllllllllIlIlllIlIIllIlII.isfaceblocked(llllllllllllllllIlIlllIlIIllIlII.mid)) {
                return;
            }
            if (llllllllllllllllIlIlllIlIIllIlII.friendpos.contains(llllllllllllllllIlIlllIlIIllIlII.playerPos)) {
                return;
            }
            int llllllllllllllllIlIlllIlIIlllIIl = BedAura.mc.thePlayer.inventory.currentItem;
            int llllllllllllllllIlIlllIlIIlllIII = -1;
            for (int llllllllllllllllIlIlllIlIlIIIllI = 0; llllllllllllllllIlIlllIlIlIIIllI < 9; ++llllllllllllllllIlIlllIlIlIIIllI) {
                ItemStack llllllllllllllllIlIlllIlIlIIIlll = BedAura.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIlIlllIlIlIIIllI);
                if (llllllllllllllllIlIlllIlIlIIIlll.getItem() != Items.bed) continue;
                llllllllllllllllIlIlllIlIIlllIII = llllllllllllllllIlIlllIlIlIIIllI;
            }
            if (llllllllllllllllIlIlllIlIIlllIII == -1) {
                ItemStack llllllllllllllllIlIlllIlIlIIIIll = BedAura.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIlIlllIlIIllIlII.SlotTooRefill.getValue());
                if (llllllllllllllllIlIlllIlIlIIIIll.getItem() == Items.bed) {
                    llllllllllllllllIlIlllIlIIlllIII = llllllllllllllllIlIlllIlIIllIlII.SlotTooRefill.getValue();
                } else {
                    for (int llllllllllllllllIlIlllIlIlIIIlII = 9; llllllllllllllllIlIlllIlIlIIIlII < 36; ++llllllllllllllllIlIlllIlIlIIIlII) {
                        ItemStack llllllllllllllllIlIlllIlIlIIIlIl = BedAura.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIlIlllIlIlIIIlII);
                        if (llllllllllllllllIlIlllIlIlIIIlIl.getItem() != Items.bed) continue;
                        BedAura.mc.playerController.func_187098_a(0, llllllllllllllllIlIlllIlIlIIIlII, llllllllllllllllIlIlllIlIIllIlII.SlotTooRefill.getValue(), ClickType.SWAP, (EntityPlayer)BedAura.mc.thePlayer);
                        llllllllllllllllIlIlllIlIIlllIII = llllllllllllllllIlIlllIlIIllIlII.SlotTooRefill.getValue();
                    }
                }
            }
            if (llllllllllllllllIlIlllIlIIlllIII == -1) {
                return;
            }
            llllllllllllllllIlIlllIlIIllIlII.posxcheck = llllllllllllllllIlIlllIlIIllIlII.canPlaceBed(llllllllllllllllIlIlllIlIIllIlII.posx);
            llllllllllllllllIlIlllIlIIllIlII.negxcheck = llllllllllllllllIlIlllIlIIllIlII.canPlaceBed(llllllllllllllllIlIlllIlIIllIlII.negx);
            llllllllllllllllIlIlllIlIIllIlII.poszcheck = llllllllllllllllIlIlllIlIIllIlII.canPlaceBed(llllllllllllllllIlIlllIlIIllIlII.posz);
            llllllllllllllllIlIlllIlIIllIlII.negzcheck = llllllllllllllllIlIlllIlIIllIlII.canPlaceBed(llllllllllllllllIlIlllIlIIllIlII.negz);
            llllllllllllllllIlIlllIlIIllIlII.nearposx = BedAura.mc.thePlayer.getDistanceSq(llllllllllllllllIlIlllIlIIllIlII.posx);
            llllllllllllllllIlIlllIlIIllIlII.nearnegx = BedAura.mc.thePlayer.getDistanceSq(llllllllllllllllIlIlllIlIIllIlII.negx);
            llllllllllllllllIlIlllIlIIllIlII.nearposz = BedAura.mc.thePlayer.getDistanceSq(llllllllllllllllIlIlllIlIIllIlII.posz);
            llllllllllllllllIlIlllIlIIllIlII.nearnegz = BedAura.mc.thePlayer.getDistanceSq(llllllllllllllllIlIlllIlIIllIlII.negz);
            if (!llllllllllllllllIlIlllIlIIllIlII.posxcheck) {
                llllllllllllllllIlIlllIlIIllIlII.nearposx = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.negxcheck) {
                llllllllllllllllIlIlllIlIIllIlII.nearnegx = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.poszcheck) {
                llllllllllllllllIlIlllIlIIllIlII.nearposz = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.negzcheck) {
                llllllllllllllllIlIlllIlIIllIlII.nearnegz = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.isEntitiesEmpty(llllllllllllllllIlIlllIlIIllIlII.posx)) {
                llllllllllllllllIlIlllIlIIllIlII.nearposx = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.isEntitiesEmpty(llllllllllllllllIlIlllIlIIllIlII.negx)) {
                llllllllllllllllIlIlllIlIIllIlII.nearnegx = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.isEntitiesEmpty(llllllllllllllllIlIlllIlIIllIlII.posz)) {
                llllllllllllllllIlIlllIlIIllIlII.nearposz = 9.99999999E8;
            }
            if (!llllllllllllllllIlIlllIlIIllIlII.isEntitiesEmpty(llllllllllllllllIlIlllIlIIllIlII.negz)) {
                llllllllllllllllIlIlllIlIIllIlII.nearnegz = 9.99999999E8;
            }
            if ((llllllllllllllllIlIlllIlIIllIlIl = Math.min(llllllllllllllllIlIlllIlIIllIlll = Math.min(llllllllllllllllIlIlllIlIIllIlII.nearposx, llllllllllllllllIlIlllIlIIllIlII.nearnegx), llllllllllllllllIlIlllIlIIllIllI = Math.min(llllllllllllllllIlIlllIlIIllIlII.nearposz, llllllllllllllllIlIlllIlIIllIlII.nearnegz))) == 9.99999999E8) {
                return;
            }
            BedAura.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)BedAura.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            if (llllllllllllllllIlIlllIlIIllIlIl == llllllllllllllllIlIlllIlIIllIlII.nearposx) {
                llllllllllllllllIlIlllIlIIllIlII.bruhyaw = 90.0f;
                BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIII;
                llllllllllllllllIlIlllIlIIllIlII.placeBlock(new BlockPos((Vec3i)llllllllllllllllIlIlllIlIIllIlII.posx), EnumFacing.DOWN);
                if (llllllllllllllllIlIlllIlIIllIlII.ghosthand.getValue()) {
                    BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIIl;
                }
                llllllllllllllllIlIlllIlIIllIlII.render = llllllllllllllllIlIlllIlIIllIlII.posx;
                llllllllllllllllIlIlllIlIIllIlII.render2 = llllllllllllllllIlIlllIlIIllIlII.mid;
                llllllllllllllllIlIlllIlIIllIlII.remove = 1;
            }
            if (llllllllllllllllIlIlllIlIIllIlIl == llllllllllllllllIlIlllIlIIllIlII.nearnegx) {
                llllllllllllllllIlIlllIlIIllIlII.bruhyaw = 270.0f;
                BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIII;
                llllllllllllllllIlIlllIlIIllIlII.placeBlock(new BlockPos((Vec3i)llllllllllllllllIlIlllIlIIllIlII.negx), EnumFacing.DOWN);
                if (llllllllllllllllIlIlllIlIIllIlII.ghosthand.getValue()) {
                    BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIIl;
                }
                llllllllllllllllIlIlllIlIIllIlII.render = llllllllllllllllIlIlllIlIIllIlII.negx;
                llllllllllllllllIlIlllIlIIllIlII.render2 = llllllllllllllllIlIlllIlIIllIlII.mid;
                llllllllllllllllIlIlllIlIIllIlII.remove = 1;
            }
            if (llllllllllllllllIlIlllIlIIllIlIl == llllllllllllllllIlIlllIlIIllIlII.nearposz) {
                llllllllllllllllIlIlllIlIIllIlII.bruhyaw = 180.0f;
                BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIII;
                llllllllllllllllIlIlllIlIIllIlII.placeBlock(new BlockPos((Vec3i)llllllllllllllllIlIlllIlIIllIlII.posz), EnumFacing.DOWN);
                if (llllllllllllllllIlIlllIlIIllIlII.ghosthand.getValue()) {
                    BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIIl;
                }
                llllllllllllllllIlIlllIlIIllIlII.render = llllllllllllllllIlIlllIlIIllIlII.posz;
                llllllllllllllllIlIlllIlIIllIlII.render2 = llllllllllllllllIlIlllIlIIllIlII.mid;
                llllllllllllllllIlIlllIlIIllIlII.remove = 1;
            }
            if (llllllllllllllllIlIlllIlIIllIlIl == llllllllllllllllIlIlllIlIIllIlII.nearnegz) {
                llllllllllllllllIlIlllIlIIllIlII.bruhyaw = 0.0f;
                BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIII;
                llllllllllllllllIlIlllIlIIllIlII.placeBlock(new BlockPos((Vec3i)llllllllllllllllIlIlllIlIIllIlII.negz), EnumFacing.DOWN);
                if (llllllllllllllllIlIlllIlIIllIlII.ghosthand.getValue()) {
                    BedAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIlIlllIlIIlllIIl;
                }
                llllllllllllllllIlIlllIlIIllIlII.render = llllllllllllllllIlIlllIlIIllIlII.negz;
                llllllllllllllllIlIlllIlIIllIlII.render2 = llllllllllllllllIlIlllIlIIllIlII.mid;
                llllllllllllllllIlIlllIlIIllIlII.remove = 1;
            }
            BedAura.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)BedAura.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
        });
    }

    @Override
    public void onUpdate() {
        BedAura llllllllllllllllIlIlllIllIllIIIl;
        if (BedAura.mc.thePlayer.dimension == 0) {
            llllllllllllllllIlIlllIllIllIIIl.disable();
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_RED).append("You cannot use bed aura in the Overworld!!")));
            return;
        }
        if (BedAura.mc.thePlayer.ticksExisted % llllllllllllllllIlIlllIllIllIIIl.delay.getValue() == 0) {
            llllllllllllllllIlIlllIllIllIIIl.update();
        }
        BedAura.mc.theWorld.loadedTileEntityList.stream().filter(llllllllllllllllIlIlllIIlllIIIIl -> llllllllllllllllIlIlllIIlllIIIIl instanceof TileEntityBed).filter(llllllllllllllllIlIlllIIlllIIllI -> {
            BedAura llllllllllllllllIlIlllIIlllIIlIl;
            return BedAura.mc.thePlayer.getDistance((double)llllllllllllllllIlIlllIIlllIIllI.getPos().getX(), (double)llllllllllllllllIlIlllIIlllIIllI.getPos().getY(), (double)llllllllllllllllIlIlllIIlllIIllI.getPos().getZ()) <= (double)llllllllllllllllIlIlllIIlllIIlIl.range.getValue();
        }).sorted(Comparator.comparing(llllllllllllllllIlIlllIIlllIlIll -> BedAura.mc.thePlayer.getDistance((double)llllllllllllllllIlIlllIIlllIlIll.getPos().getX(), (double)llllllllllllllllIlIlllIIlllIlIll.getPos().getY(), (double)llllllllllllllllIlIlllIIlllIlIll.getPos().getZ()))).forEach(llllllllllllllllIlIlllIIlllIllll -> {
            BedAura.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llllllllllllllllIlIlllIIlllIllll.getPos(), EnumFacing.DOWN, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            llllllllllllllllIlIlllIIllllIIII.render2 = null;
            llllllllllllllllIlIlllIIllllIIII.render = null;
        });
    }

    public static Vec3d getInterpolatedPos(Entity llllllllllllllllIlIlllIllIIlIIll, float llllllllllllllllIlIlllIllIIlIlII) {
        return new Vec3d(llllllllllllllllIlIlllIllIIlIIll.lastTickPosX, llllllllllllllllIlIlllIllIIlIIll.lastTickPosY, llllllllllllllllIlIlllIllIIlIIll.lastTickPosZ).add(BedAura.getInterpolatedAmount(llllllllllllllllIlIlllIllIIlIIll, llllllllllllllllIlIlllIllIIlIlII));
    }

    private boolean canPlaceBed(BlockPos llllllllllllllllIlIlllIllIIlllIl) {
        if (BedAura.mc.theWorld.getBlockState(llllllllllllllllIlIlllIllIIlllIl).getBlock() == Blocks.air) {
            return true;
        }
        if (BedAura.mc.theWorld.getBlockState(llllllllllllllllIlIlllIllIIlllIl).getBlock() == Blocks.lava) {
            return true;
        }
        return BedAura.mc.theWorld.getBlockState(llllllllllllllllIlIlllIllIIlllIl).getBlock() == Blocks.flowing_lava;
    }

    private boolean isEntitiesEmpty(BlockPos llllllllllllllllIlIlllIlIllIIlll) {
        List llllllllllllllllIlIlllIlIllIlIII = BedAura.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llllllllllllllllIlIlllIlIllIIlll)).stream().filter(llllllllllllllllIlIlllIlIllIIIII -> !(llllllllllllllllIlIlllIlIllIIIII instanceof EntityItem)).filter(llllllllllllllllIlIlllIlIllIIlII -> !(llllllllllllllllIlIlllIlIllIIlII instanceof EntityXPOrb)).collect(Collectors.toList());
        return llllllllllllllllIlIlllIlIllIlIII.isEmpty();
    }

    private boolean isfaceblocked(BlockPos llllllllllllllllIlIlllIllIIllIII) {
        if (BedAura.mc.theWorld.getBlockState(llllllllllllllllIlIlllIllIIllIII).getBlock() == Blocks.air) {
            return true;
        }
        if (BedAura.mc.theWorld.getBlockState(llllllllllllllllIlIlllIllIIllIII).getBlock() == Blocks.lava) {
            return true;
        }
        return BedAura.mc.theWorld.getBlockState(llllllllllllllllIlIlllIllIIllIII).getBlock() == Blocks.flowing_lava;
    }

    public BedAura() {
        super("BedAura", Module.Category.COMBAT, "Attacks nearby players with beds");
        BedAura llllllllllllllllIlIlllIllIlllIIl;
        llllllllllllllllIlIlllIllIlllIIl.packetSendListener = new Listener<PacketEvent.Send>(llllllllllllllllIlIlllIlIlIllIll -> {
            BedAura llllllllllllllllIlIlllIlIlIllIIl;
            Packet llllllllllllllllIlIlllIlIlIllIlI = llllllllllllllllIlIlllIlIlIllIll.getPacket();
            if (llllllllllllllllIlIlllIlIlIllIlI instanceof CPacketPlayer && llllllllllllllllIlIlllIlIlIllIIl.remove == 0) {
                ((CPacketPlayer)llllllllllllllllIlIlllIlIlIllIlI).yaw = llllllllllllllllIlIlllIlIlIllIIl.bruhyaw;
            }
        }, new Predicate[0]);
    }

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIlIlllIllIlIIlII) {
        BedAura llllllllllllllllIlIlllIllIlIIIll;
        if (llllllllllllllllIlIlllIllIlIIIll.render != null && llllllllllllllllIlIlllIllIlIIIll.renders.getValue()) {
            ImpactPlusTessellator.prepare(7);
            if (llllllllllllllllIlIlllIllIlIIIll.rainbow.getValue()) {
                int llllllllllllllllIlIlllIllIlIlIII = Rainbow.getColor().getRed();
                int llllllllllllllllIlIlllIllIlIIlll = Rainbow.getColor().getGreen();
                int llllllllllllllllIlIlllIllIlIIllI = Rainbow.getColor().getBlue();
                ImpactPlusTessellator.drawhalfBoundingBoxBlockPos(llllllllllllllllIlIlllIllIlIIIll.render, 3.0f, llllllllllllllllIlIlllIllIlIlIII, llllllllllllllllIlIlllIllIlIIlll, llllllllllllllllIlIlllIllIlIIllI, 255);
                ImpactPlusTessellator.drawhalfBoundingBoxBlockPos(llllllllllllllllIlIlllIllIlIIIll.render2, 3.0f, llllllllllllllllIlIlllIllIlIlIII, llllllllllllllllIlIlllIllIlIIlll, llllllllllllllllIlIlllIllIlIIllI, 255);
            } else {
                ImpactPlusTessellator.drawhalfBoundingBoxBlockPos(llllllllllllllllIlIlllIllIlIIIll.render, 3.0f, llllllllllllllllIlIlllIllIlIIIll.espR.getValue(), llllllllllllllllIlIlllIllIlIIIll.espG.getValue(), llllllllllllllllIlIlllIllIlIIIll.espB.getValue(), 255);
                ImpactPlusTessellator.drawhalfBoundingBoxBlockPos(llllllllllllllllIlIlllIllIlIIIll.render2, 3.0f, llllllllllllllllIlIlllIllIlIIIll.espR.getValue(), llllllllllllllllIlIlllIllIlIIIll.espG.getValue(), llllllllllllllllIlIlllIllIlIIIll.espB.getValue(), 255);
            }
            ImpactPlusTessellator.release();
        }
    }
}

