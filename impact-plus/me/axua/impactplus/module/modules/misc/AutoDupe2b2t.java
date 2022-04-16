/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockButton
 *  net.minecraft.block.properties.IProperty
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityMinecart
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.server.SPacketBlockChange
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraftforge.fml.common.FMLCommonHandler
 */
package me.axua.impactplus.module.modules.misc;

import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.misc.Notifications;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.BlockButton;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class AutoDupe2b2t
extends Module {
    public /* synthetic */ Setting.d minecartX;
    public /* synthetic */ BlockPos pastPos;
    public /* synthetic */ int step;
    public /* synthetic */ int player;
    public /* synthetic */ Setting.d storeItemsButtonY;
    /* synthetic */ EntityPlayer reloaderPlayer;
    public /* synthetic */ Setting.s reloaderPlayername;
    public /* synthetic */ Setting.s duperPlayername;
    public /* synthetic */ Setting.d donkeyX;
    public /* synthetic */ boolean unloadQueued;
    public /* synthetic */ Setting.d returnMinecartX;
    public /* synthetic */ Setting.d storeItemsButtonX;
    public /* synthetic */ Setting.d startZ;
    public /* synthetic */ int previousCartid;
    public /* synthetic */ Setting.i wait_seconds;
    public /* synthetic */ Setting.d startY;
    public /* synthetic */ boolean buttonQueued;
    public /* synthetic */ Setting.d returnMinecartZ;
    public /* synthetic */ Setting.mode direction;
    public /* synthetic */ Setting.d minecartZ;
    public /* synthetic */ int dupe;
    public /* synthetic */ Setting.d donkeyY;
    public /* synthetic */ int mountWaitTime;
    public /* synthetic */ boolean reloadQueued;
    public /* synthetic */ Setting.d unloadY;
    public /* synthetic */ Setting.d startX;
    public /* synthetic */ Setting.d unloadX;
    public /* synthetic */ Setting.d returnMinecartY;
    public /* synthetic */ Setting.d storeItemsButtonZ;
    /* synthetic */ EntityPlayer duperPlayer;
    public /* synthetic */ Setting.d unloadZ;
    public /* synthetic */ long startTime;
    public /* synthetic */ Setting.d minecartY;
    public /* synthetic */ Setting.d donkeyZ;
    public /* synthetic */ int waited;
    public /* synthetic */ boolean waitingForMount;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> recvListener;

    public void mountEntity(Entity llllllllllllllllIIlIIIIlIIlIllll) {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIIllIIII;
        EntityPlayerSP llllllllllllllllIIlIIIIlIIlIlllI = Minecraft.getMinecraft().thePlayer;
        if (!llllllllllllllllIIlIIIIlIIllIIII.waitingForMount && llllllllllllllllIIlIIIIlIIlIlllI.getDistanceSqToEntity(llllllllllllllllIIlIIIIlIIlIllll) < 25.0) {
            Minecraft.getMinecraft().playerController.func_187097_a((EntityPlayer)llllllllllllllllIIlIIIIlIIlIlllI, llllllllllllllllIIlIIIIlIIlIllll, EnumHand.MAIN_HAND);
            llllllllllllllllIIlIIIIlIIllIIII.waitingForMount = true;
        }
    }

    @Override
    public void onUpdate() {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIllIIlll;
        Minecraft llllllllllllllllIIlIIIIlIllIIllI = Minecraft.getMinecraft();
        EntityPlayerSP llllllllllllllllIIlIIIIlIllIIlIl = llllllllllllllllIIlIIIIlIllIIllI.thePlayer;
        WorldClient llllllllllllllllIIlIIIIlIllIIlII = llllllllllllllllIIlIIIIlIllIIllI.theWorld;
        if (llllllllllllllllIIlIIIIlIllIIlIl == null || llllllllllllllllIIlIIIIlIllIIlII == null) {
            return;
        }
        if (llllllllllllllllIIlIIIIlIllIIlIl.getDisplayName().toString().contains(llllllllllllllllIIlIIIIlIllIIlll.duperPlayername.getValue())) {
            llllllllllllllllIIlIIIIlIllIIlll.player = 1;
            if (llllllllllllllllIIlIIIIlIllIIlIl.dimension == 1 && llllllllllllllllIIlIIIIlIllIIlIl.isSpectator()) {
                llllllllllllllllIIlIIIIlIllIIlll.startTime = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() % 1000L == 0L) {
                try {
                    if (FMLCommonHandler.instance().getMinecraftServerInstance().func_184103_al().getPlayerByUsername(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayername.getValue()) == null) {
                        llllllllllllllllIIlIIIIlIllIIlll.startTime = System.currentTimeMillis();
                    }
                }
                catch (Exception llllllllllllllllIIlIIIIlIllllIIl) {
                    llllllllllllllllIIlIIIIlIllllIIl.printStackTrace();
                }
            }
        } else if (llllllllllllllllIIlIIIIlIllIIlIl.getDisplayName().toString().contains(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayername.getValue())) {
            llllllllllllllllIIlIIIIlIllIIlll.player = 2;
        }
        if (llllllllllllllllIIlIIIIlIllIIlll.step != 0 && llllllllllllllllIIlIIIIlIllIIlll.player == 1 && (System.currentTimeMillis() - llllllllllllllllIIlIIIIlIllIIlll.startTime) / 1000L > 220L) {
            try {
                Notifications.sendNotification("[auto] 220 seconds without success. disabling the module.", TrayIcon.MessageType.INFO);
            }
            catch (Exception llllllllllllllllIIlIIIIlIllllIII) {
                llllllllllllllllIIlIIIIlIllllIII.printStackTrace();
            }
            ModuleManager.getModuleByName("AutoDupe").toggle();
            Command.sendClientMessage("Disabled autodupe due to no successful dupe in 220 seconds.");
            return;
        }
        llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayer = llllllllllllllllIIlIIIIlIllIIlII.getPlayerEntityByName(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayername.getValue());
        llllllllllllllllIIlIIIIlIllIIlll.duperPlayer = llllllllllllllllIIlIIIIlIllIIlII.getPlayerEntityByName(llllllllllllllllIIlIIIIlIllIIlll.duperPlayername.getValue());
        Vec3d llllllllllllllllIIlIIIIlIllIIIll = new Vec3d(Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.minecartX.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.minecartY.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.minecartZ.getValue()).doubleValue());
        Vec3d llllllllllllllllIIlIIIIlIllIIIlI = new Vec3d(Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.donkeyX.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.donkeyY.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.donkeyZ.getValue()).doubleValue());
        EnumFacing llllllllllllllllIIlIIIIlIllIIIIl = EnumFacing.byName((String)llllllllllllllllIIlIIIIlIllIIlll.direction.getValue().toString());
        if (llllllllllllllllIIlIIIIlIllIIlll.player == 1) {
            if (llllllllllllllllIIlIIIIlIllIIlll.mountWaitTime > 2) {
                llllllllllllllllIIlIIIIlIllIIlll.waitingForMount = false;
            }
            if (llllllllllllllllIIlIIIIlIllIIlll.waitingForMount) {
                ++llllllllllllllllIIlIIIIlIllIIlll.mountWaitTime;
                return;
            }
            llllllllllllllllIIlIIIIlIllIIlll.mountWaitTime = 0;
            if (llllllllllllllllIIlIIIIlIllIIlll.step == 0) {
                llllllllllllllllIIlIIIIlIllIIlll.startTime = System.currentTimeMillis();
                if (!ModuleManager.isModuleEnabled("Freecam")) {
                    ModuleManager.getModuleByName("Freecam").toggle();
                }
                llllllllllllllllIIlIIIIlIllIIlll.step = 1;
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 1) {
                if (llllllllllllllllIIlIIIIlIllIIlIl.func_184218_aH() && llllllllllllllllIIlIIIIlIllIIlIl.func_184187_bx() instanceof EntityMinecart) {
                    llllllllllllllllIIlIIIIlIllIIlll.step = 2;
                }
                for (Entity llllllllllllllllIIlIIIIlIlllIlll : llllllllllllllllIIlIIIIlIllIIlII.loadedEntityList) {
                    if (!(llllllllllllllllIIlIIIIlIlllIlll.getDistanceSq(llllllllllllllllIIlIIIIlIllIIIll.xCoord, llllllllllllllllIIlIIIIlIllIIIll.yCoord, llllllllllllllllIIlIIIIlIllIIIll.zCoord) < 1.0) || !(llllllllllllllllIIlIIIIlIlllIlll instanceof EntityMinecart)) continue;
                    llllllllllllllllIIlIIIIlIllIIlll.mountEntity(llllllllllllllllIIlIIIIlIlllIlll);
                    break;
                }
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 2) {
                BlockPos llllllllllllllllIIlIIIIlIlllIlII = new BlockPos(llllllllllllllllIIlIIIIlIllIIlIl.getPositionVector()).offset(llllllllllllllllIIlIIIIlIllIIIIl, 3);
                for (Entity llllllllllllllllIIlIIIIlIlllIlIl : llllllllllllllllIIlIIIIlIllIIlII.loadedEntityList) {
                    if (llllllllllllllllIIlIIIIlIlllIlIl.getEntityId() == llllllllllllllllIIlIIIIlIllIIlll.previousCartid || !(llllllllllllllllIIlIIIIlIlllIlIl.getDistanceSq((double)llllllllllllllllIIlIIIIlIlllIlII.getX(), (double)llllllllllllllllIIlIIIIlIlllIlII.getY(), (double)llllllllllllllllIIlIIIIlIlllIlII.getZ()) < 4.0) || !(llllllllllllllllIIlIIIIlIlllIlIl instanceof EntityMinecart)) continue;
                    try {
                        llllllllllllllllIIlIIIIlIllIIlll.previousCartid = Objects.requireNonNull(llllllllllllllllIIlIIIIlIllIIllI.thePlayer.func_184187_bx()).getEntityId();
                    }
                    catch (Exception llllllllllllllllIIlIIIIlIlllIllI) {
                        llllllllllllllllIIlIIIIlIlllIllI.printStackTrace();
                    }
                    llllllllllllllllIIlIIIIlIllIIlll.mountEntity(llllllllllllllllIIlIIIIlIlllIlIl);
                    break;
                }
                if (llllllllllllllllIIlIIIIlIllIIlIl.getDistanceSq(llllllllllllllllIIlIIIIlIllIIIlI.xCoord, llllllllllllllllIIlIIIIlIllIIIlI.yCoord, llllllllllllllllIIlIIIIlIllIIIlI.zCoord) < 25.0) {
                    llllllllllllllllIIlIIIIlIllIIlll.step = 3;
                    llllllllllllllllIIlIIIIlIllIIlll.previousCartid = 0;
                }
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 3) {
                if (llllllllllllllllIIlIIIIlIllIIlIl.getDistanceSq(llllllllllllllllIIlIIIIlIllIIIlI.xCoord, llllllllllllllllIIlIIIIlIllIIIlI.yCoord, llllllllllllllllIIlIIIIlIllIIIlI.zCoord) > 25.0) {
                    llllllllllllllllIIlIIIIlIllIIlll.step = 2;
                }
                if (llllllllllllllllIIlIIIIlIllIIlIl.func_184218_aH() && llllllllllllllllIIlIIIIlIllIIlIl.func_184187_bx() instanceof AbstractHorse) {
                    llllllllllllllllIIlIIIIlIllIIlll.step = 4;
                    return;
                }
                Entity llllllllllllllllIIlIIIIlIlllIIll = llllllllllllllllIIlIIIIlIllIIllI.theWorld.loadedEntityList.stream().filter(llllllllllllllllIIlIIIIIllllIIIl -> llllllllllllllllIIlIIIIIllllIIIl instanceof EntityDonkey).min(Comparator.comparing(llllllllllllllllIIlIIIIIllllIllI -> Float.valueOf(llllllllllllllllIIlIIIIIllllIlll.thePlayer.getDistanceToEntity(llllllllllllllllIIlIIIIIllllIllI)))).orElse(null);
                if (llllllllllllllllIIlIIIIlIlllIIll != null) {
                    llllllllllllllllIIlIIIIlIllIIlll.mountEntity(llllllllllllllllIIlIIIIlIlllIIll);
                }
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 4) {
                if (llllllllllllllllIIlIIIIlIllIIlII.loadedEntityList.contains(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayer)) {
                    llllllllllllllllIIlIIIIlIllIIlIl.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayername.getValue()).append(" 1")));
                }
                llllllllllllllllIIlIIIIlIllIIlll.waited = 0;
                llllllllllllllllIIlIIIIlIllIIlll.step = 5;
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 5) {
                if (!llllllllllllllllIIlIIIIlIllIIlll.waitTicks(Integer.valueOf(llllllllllllllllIIlIIIIlIllIIlll.wait_seconds.getValue()) * 20)) {
                    return;
                }
                llllllllllllllllIIlIIIIlIllIIlll.waited = 0;
                if (llllllllllllllllIIlIIIIlIllIIlII.loadedEntityList.contains(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayer) && llllllllllllllllIIlIIIIlIllIIlIl.getDistanceSqToEntity((Entity)llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayer) <= 121.0) {
                    llllllllllllllllIIlIIIIlIllIIlll.step = 6;
                }
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 6) {
                if (ModuleManager.isModuleEnabled("Freecam")) {
                    ModuleManager.getModuleByName("Freecam").toggle();
                }
                if (!llllllllllllllllIIlIIIIlIllIIlll.waitTicks(20)) {
                    return;
                }
                llllllllllllllllIIlIIIIlIllIIlll.waited = 0;
                int llllllllllllllllIIlIIIIlIlllIIII = 0;
                for (Entity llllllllllllllllIIlIIIIlIlllIIlI : llllllllllllllllIIlIIIIlIllIIlII.loadedEntityList) {
                    if (!(llllllllllllllllIIlIIIIlIlllIIlI instanceof EntityDonkey)) continue;
                    ++llllllllllllllllIIlIIIIlIlllIIII;
                }
                if (llllllllllllllllIIlIIIIlIlllIIII < 3) {
                    try {
                        Notifications.sendNotification("Error.", TrayIcon.MessageType.ERROR);
                    }
                    catch (Exception llllllllllllllllIIlIIIIlIlllIIIl) {
                        llllllllllllllllIIlIIIIlIlllIIIl.printStackTrace();
                    }
                    Command.sendClientMessage("[ERROR] Less than 3 donkeys found.");
                    ModuleManager.getModuleByName("AutoDupe").disable();
                    return;
                }
                llllllllllllllllIIlIIIIlIllIIlIl.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIlIIIIlIllIIlll.reloaderPlayername.getValue()).append(" a")));
                llllllllllllllllIIlIIIIlIllIIlll.step = 7;
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 8) {
                if (llllllllllllllllIIlIIIIlIllIIlIl.func_184218_aH()) {
                    if (llllllllllllllllIIlIIIIlIllIIlIl.func_184187_bx() instanceof EntityMinecart) {
                        llllllllllllllllIIlIIIIlIllIIlll.step = 9;
                    } else {
                        llllllllllllllllIIlIIIIlIllIIllI.getNetHandler().addToSendQueue((Packet)new CPacketEntityAction((Entity)llllllllllllllllIIlIIIIlIllIIlIl, CPacketEntityAction.Action.START_SNEAKING));
                    }
                } else {
                    llllllllllllllllIIlIIIIlIllIIllI.getNetHandler().addToSendQueue((Packet)new CPacketEntityAction((Entity)llllllllllllllllIIlIIIIlIllIIlIl, CPacketEntityAction.Action.STOP_SNEAKING));
                }
                double llllllllllllllllIIlIIIIlIllIlllI = llllllllllllllllIIlIIIIlIllIIlll.returnMinecartX.getValue();
                double llllllllllllllllIIlIIIIlIllIllIl = llllllllllllllllIIlIIIIlIllIIlll.returnMinecartY.getValue();
                double llllllllllllllllIIlIIIIlIllIllII = llllllllllllllllIIlIIIIlIllIIlll.returnMinecartZ.getValue();
                llllllllllllllllIIlIIIIlIllIIlll.lookAtPos(llllllllllllllllIIlIIIIlIllIlllI, llllllllllllllllIIlIIIIlIllIllIl, llllllllllllllllIIlIIIIlIllIllII);
                if (llllllllllllllllIIlIIIIlIllIIlIl.getDistanceSq(llllllllllllllllIIlIIIIlIllIlllI, llllllllllllllllIIlIIIIlIllIllIl, llllllllllllllllIIlIIIIlIllIllII) < 6.25) {
                    for (Entity llllllllllllllllIIlIIIIlIllIllll : llllllllllllllllIIlIIIIlIllIIlII.loadedEntityList) {
                        if (!(llllllllllllllllIIlIIIIlIllIllll.getDistanceSq(llllllllllllllllIIlIIIIlIllIlllI, llllllllllllllllIIlIIIIlIllIllIl, llllllllllllllllIIlIIIIlIllIllII) < 1.0) || !(llllllllllllllllIIlIIIIlIllIllll instanceof EntityMinecart)) continue;
                        llllllllllllllllIIlIIIIlIllIIlll.mountEntity(llllllllllllllllIIlIIIIlIllIllll);
                        break;
                    }
                } else if (llllllllllllllllIIlIIIIlIllIIlIl.onGround) {
                    llllllllllllllllIIlIIIIlIllIIlIl.func_191958_b(0.0f, 0.0f, 1.0f, 0.098f);
                }
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 9) {
                if (!llllllllllllllllIIlIIIIlIllIIlIl.func_184218_aH() && llllllllllllllllIIlIIIIlIllIIlIl.onGround) {
                    Vec3d llllllllllllllllIIlIIIIlIllIlIll = new Vec3d(Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.startX.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.startY.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIllIIlll.startZ.getValue()).doubleValue());
                    if (llllllllllllllllIIlIIIIlIllIIlIl.getPositionVector().squareDistanceTo(llllllllllllllllIIlIIIIlIllIlIll) < 16.0) {
                        llllllllllllllllIIlIIIIlIllIIlll.step = 10;
                    }
                }
            } else if (llllllllllllllllIIlIIIIlIllIIlll.step == 10) {
                double llllllllllllllllIIlIIIIlIllIlIlI = llllllllllllllllIIlIIIIlIllIIlll.startX.getValue();
                double llllllllllllllllIIlIIIIlIllIlIIl = llllllllllllllllIIlIIIIlIllIIlll.startY.getValue();
                double llllllllllllllllIIlIIIIlIllIlIII = llllllllllllllllIIlIIIIlIllIIlll.startZ.getValue();
                llllllllllllllllIIlIIIIlIllIIlll.lookAtPos(llllllllllllllllIIlIIIIlIllIlIlI, llllllllllllllllIIlIIIIlIllIlIIl, llllllllllllllllIIlIIIIlIllIlIII);
                if (llllllllllllllllIIlIIIIlIllIIlIl.getDistanceSq(llllllllllllllllIIlIIIIlIllIlIlI, llllllllllllllllIIlIIIIlIllIlIIl, llllllllllllllllIIlIIIIlIllIlIII) < 2.0) {
                    llllllllllllllllIIlIIIIlIllIIlll.onEnable();
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append("Dupe #").append(llllllllllllllllIIlIIIIlIllIIlll.dupe).append(" took ").append((System.currentTimeMillis() - llllllllllllllllIIlIIIIlIllIIlll.startTime) / 1000L).append("seconds")));
                    ++llllllllllllllllIIlIIIIlIllIIlll.dupe;
                } else if (llllllllllllllllIIlIIIIlIllIIlIl.onGround) {
                    llllllllllllllllIIlIIIIlIllIIlIl.func_191958_b(0.0f, 0.0f, 1.0f, 0.098f);
                }
            }
        } else if (llllllllllllllllIIlIIIIlIllIIlll.player == 2) {
            if (llllllllllllllllIIlIIIIlIllIIlll.unloadQueued) {
                llllllllllllllllIIlIIIIlIllIIlll.unloadChunks();
            } else if (llllllllllllllllIIlIIIIlIllIIlll.reloadQueued) {
                llllllllllllllllIIlIIIIlIllIIlll.reloadChunks();
            } else if (llllllllllllllllIIlIIIIlIllIIlll.buttonQueued) {
                llllllllllllllllIIlIIIIlIllIIlll.tryPressButton();
            }
        }
    }

    @Override
    public String getHudInfo() {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIIlIlIIl;
        return String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIIIlIIlIlIIl.getName()).append("[Step ").append(llllllllllllllllIIlIIIIlIIlIlIIl.step).append("]"));
    }

    public void unloadChunks() {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIIIlIIII;
        llllllllllllllllIIlIIIIlIIIlIIII.autoWalk("BACKWARDS");
        if (!llllllllllllllllIIlIIIIlIIIlIIII.waitTicks(20)) {
            return;
        }
        llllllllllllllllIIlIIIIlIIIlIIII.waited = 0;
        if (AutoDupe2b2t.mc.thePlayer.getDistanceSq(Double.valueOf(llllllllllllllllIIlIIIIlIIIlIIII.unloadX.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIIIlIIII.unloadY.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIIIlIIII.unloadZ.getValue()).doubleValue()) > 4.0 && AutoDupe2b2t.mc.thePlayer.getDistanceSq(llllllllllllllllIIlIIIIlIIIlIIII.pastPos) > 1.0) {
            llllllllllllllllIIlIIIIlIIIlIIII.pastPos = AutoDupe2b2t.mc.thePlayer.getPosition();
            return;
        }
        llllllllllllllllIIlIIIIlIIIlIIII.autoWalk("off");
        llllllllllllllllIIlIIIIlIIIlIIII.reloadQueued = true;
        llllllllllllllllIIlIIIIlIIIlIIII.unloadQueued = false;
    }

    @Override
    public void onDisable() {
        if (ModuleManager.isModuleEnabled("Freecam")) {
            ModuleManager.getModuleByName("Freecam").toggle();
        }
        if (ModuleManager.isModuleEnabled("AutoWalk")) {
            ModuleManager.getModuleByName("AutoWalk").toggle();
        }
    }

    public void tryPressButton() {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIIlIIIII;
        double llllllllllllllllIIlIIIIlIIIlllll = llllllllllllllllIIlIIIIlIIlIIIII.storeItemsButtonX.getValue();
        double llllllllllllllllIIlIIIIlIIIllllI = llllllllllllllllIIlIIIIlIIlIIIII.storeItemsButtonY.getValue();
        double llllllllllllllllIIlIIIIlIIIlllIl = llllllllllllllllIIlIIIIlIIlIIIII.storeItemsButtonZ.getValue();
        BlockPos llllllllllllllllIIlIIIIlIIIlllII = new BlockPos(llllllllllllllllIIlIIIIlIIIlllll, llllllllllllllllIIlIIIIlIIIllllI, llllllllllllllllIIlIIIIlIIIlllIl);
        EnumFacing llllllllllllllllIIlIIIIlIIIllIll = EnumFacing.DOWN;
        Minecraft llllllllllllllllIIlIIIIlIIIllIlI = Minecraft.getMinecraft();
        llllllllllllllllIIlIIIIlIIlIIIII.lookAtPos(llllllllllllllllIIlIIIIlIIIlllll, llllllllllllllllIIlIIIIlIIIllllI - 0.7, llllllllllllllllIIlIIIIlIIIlllIl);
        llllllllllllllllIIlIIIIlIIIllIlI.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
        llllllllllllllllIIlIIIIlIIIllIlI.playerController.func_187099_a(llllllllllllllllIIlIIIIlIIIllIlI.thePlayer, llllllllllllllllIIlIIIIlIIIllIlI.theWorld, llllllllllllllllIIlIIIIlIIIlllII, llllllllllllllllIIlIIIIlIIIllIll, llllllllllllllllIIlIIIIlIIIllIlI.objectMouseOver.hitVec, EnumHand.MAIN_HAND);
    }

    public void reloadChunks() {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIIIIllIl;
        if (llllllllllllllllIIlIIIIlIIIIllIl.waited < Integer.valueOf(llllllllllllllllIIlIIIIlIIIIllIl.wait_seconds.getValue()) * 20) {
            ++llllllllllllllllIIlIIIIlIIIIllIl.waited;
            return;
        }
        if (AutoDupe2b2t.mc.theWorld.loadedEntityList.contains(AutoDupe2b2t.mc.theWorld.getPlayerEntityByName(llllllllllllllllIIlIIIIlIIIIllIl.duperPlayername.getValue()))) {
            Command.sendClientMessage("[ERROR] Unload failed. if this keeps happening then increase Unload Wait Time.");
            llllllllllllllllIIlIIIIlIIIIllIl.unloadQueued = true;
            llllllllllllllllIIlIIIIlIIIIllIl.reloadQueued = false;
            llllllllllllllllIIlIIIIlIIIIllIl.waited = -100;
            return;
        }
        llllllllllllllllIIlIIIIlIIIIllIl.autoWalk("FORWARD");
        if (AutoDupe2b2t.mc.thePlayer.getDistanceSq(Double.valueOf(llllllllllllllllIIlIIIIlIIIIllIl.returnMinecartX.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIIIIllIl.returnMinecartY.getValue()).doubleValue(), Double.valueOf(llllllllllllllllIIlIIIIlIIIIllIl.returnMinecartZ.getValue()).doubleValue()) > 25.0) {
            return;
        }
        llllllllllllllllIIlIIIIlIIIIllIl.reloadQueued = false;
        llllllllllllllllIIlIIIIlIIIIllIl.waited = 0;
        llllllllllllllllIIlIIIIlIIIIllIl.autoWalk("off");
        Command.sendClientMessage("AutoWalk Disabled");
    }

    @Override
    public void onEnable() {
        AutoDupe2b2t llllllllllllllllIIlIIIIllIIIlIlI;
        llllllllllllllllIIlIIIIllIIIlIlI.step = 0;
        llllllllllllllllIIlIIIIllIIIlIlI.waited = 0;
        llllllllllllllllIIlIIIIllIIIlIlI.mountWaitTime = 0;
        llllllllllllllllIIlIIIIllIIIlIlI.waitingForMount = false;
        llllllllllllllllIIlIIIIllIIIlIlI.buttonQueued = false;
        llllllllllllllllIIlIIIIllIIIlIlI.unloadQueued = false;
        llllllllllllllllIIlIIIIllIIIlIlI.reloadQueued = false;
        llllllllllllllllIIlIIIIllIIIlIlI.previousCartid = 0;
        if (llllllllllllllllIIlIIIIllIIIlIlI.reloaderPlayername.getValue().equalsIgnoreCase(llllllllllllllllIIlIIIIllIIIlIlI.duperPlayername.getValue())) {
            Command.sendClientMessage("[Error] duper and reloader username should not be equal in configuration. Disabling AutoDuper.\n Please setup correctly using \".autodupe duper\" on duper account or \".autodupe reloader\" on reloader account.");
            ModuleManager.getModuleByName("AutoDupe").disable();
        }
    }

    @Override
    public void setup() {
        AutoDupe2b2t llllllllllllllllIIlIIIIllIIIllll;
        ArrayList<String> llllllllllllllllIIlIIIIllIIIlllI = new ArrayList<String>();
        llllllllllllllllIIlIIIIllIIIlllI.add("north");
        llllllllllllllllIIlIIIIllIIIlllI.add("south");
        llllllllllllllllIIlIIIIllIIIlllI.add("east");
        llllllllllllllllIIlIIIIllIIIlllI.add("west");
        llllllllllllllllIIlIIIIllIIIllll.direction = llllllllllllllllIIlIIIIllIIIllll.registerMode("Direction", llllllllllllllllIIlIIIIllIIIlllI, "north");
        llllllllllllllllIIlIIIIllIIIllll.wait_seconds = llllllllllllllllIIlIIIIllIIIllll.registerI("UnloadWaitTime", 10, 3, 60);
        llllllllllllllllIIlIIIIllIIIllll.startX = llllllllllllllllIIlIIIIllIIIllll.registerD("startX", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.startY = llllllllllllllllIIlIIIIllIIIllll.registerD("startY", 0.0, 0.0, 256.0);
        llllllllllllllllIIlIIIIllIIIllll.startZ = llllllllllllllllIIlIIIIllIIIllll.registerD("startZ", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.donkeyX = llllllllllllllllIIlIIIIllIIIllll.registerD("donkeyX", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.donkeyY = llllllllllllllllIIlIIIIllIIIllll.registerD("donkeyY", 0.0, 0.0, 256.0);
        llllllllllllllllIIlIIIIllIIIllll.donkeyZ = llllllllllllllllIIlIIIIllIIIllll.registerD("donkeyZ", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.minecartX = llllllllllllllllIIlIIIIllIIIllll.registerD("minecartX", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.minecartY = llllllllllllllllIIlIIIIllIIIllll.registerD("minecartY", 0.0, 0.0, 256.0);
        llllllllllllllllIIlIIIIllIIIllll.minecartZ = llllllllllllllllIIlIIIIllIIIllll.registerD("minecartZ", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.storeItemsButtonX = llllllllllllllllIIlIIIIllIIIllll.registerD("storeItemsButtonX", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.storeItemsButtonY = llllllllllllllllIIlIIIIllIIIllll.registerD("storeItemsButtonY", 0.0, 0.0, 256.0);
        llllllllllllllllIIlIIIIllIIIllll.storeItemsButtonZ = llllllllllllllllIIlIIIIllIIIllll.registerD("storeItemsButtonZ", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.returnMinecartX = llllllllllllllllIIlIIIIllIIIllll.registerD("returnMinecartX", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.returnMinecartY = llllllllllllllllIIlIIIIllIIIllll.registerD("returnMinecartY", 0.0, 0.0, 256.0);
        llllllllllllllllIIlIIIIllIIIllll.returnMinecartZ = llllllllllllllllIIlIIIIllIIIllll.registerD("returnMinecartZ", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.unloadX = llllllllllllllllIIlIIIIllIIIllll.registerD("unloadX", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.unloadY = llllllllllllllllIIlIIIIllIIIllll.registerD("unloadY", 0.0, 0.0, 256.0);
        llllllllllllllllIIlIIIIllIIIllll.unloadZ = llllllllllllllllIIlIIIIllIIIllll.registerD("unloadZ", 0.0, 0.0, 3.0E7);
        llllllllllllllllIIlIIIIllIIIllll.reloaderPlayername = llllllllllllllllIIlIIIIllIIIllll.registerS("reloaderPlayername", "");
        llllllllllllllllIIlIIIIllIIIllll.duperPlayername = llllllllllllllllIIlIIIIllIIIllll.registerS("duperPlayername", "");
        llllllllllllllllIIlIIIIllIIIllll.waitingForMount = false;
        llllllllllllllllIIlIIIIllIIIllll.mountWaitTime = 0;
        llllllllllllllllIIlIIIIllIIIllll.dupe = 1;
        llllllllllllllllIIlIIIIllIIIllll.startTime = 0L;
        llllllllllllllllIIlIIIIllIIIllll.previousCartid = 0;
        llllllllllllllllIIlIIIIllIIIllll.buttonQueued = false;
        llllllllllllllllIIlIIIIllIIIllll.unloadQueued = false;
        llllllllllllllllIIlIIIIllIIIllll.reloadQueued = false;
        llllllllllllllllIIlIIIIllIIIllll.pastPos = new BlockPos(0.0, 0.0, 0.0);
    }

    public boolean waitTicks(int llllllllllllllllIIlIIIIIllllllII) {
        AutoDupe2b2t llllllllllllllllIIlIIIIIllllllIl;
        if (llllllllllllllllIIlIIIIIllllllIl.waited < llllllllllllllllIIlIIIIIllllllII) {
            ++llllllllllllllllIIlIIIIIllllllIl.waited;
            return false;
        }
        return true;
    }

    public AutoDupe2b2t() {
        super("AutoDupe2b2t", Module.Category.MISC, "AutoDupe2b2t");
        AutoDupe2b2t llllllllllllllllIIlIIIIllIlIllII;
        llllllllllllllllIIlIIIIllIlIllII.recvListener = new Listener<PacketEvent.Receive>(llllllllllllllllIIlIIIIIllIllIIl -> {
            AutoDupe2b2t llllllllllllllllIIlIIIIIllIllIlI;
            if (AutoDupe2b2t.mc.thePlayer == null) {
                return;
            }
            if (llllllllllllllllIIlIIIIIllIllIIl.getPacket() instanceof SPacketChat) {
                SPacketChat llllllllllllllllIIlIIIIIlllIIlll = (SPacketChat)llllllllllllllllIIlIIIIIllIllIIl.getPacket();
                String llllllllllllllllIIlIIIIIlllIIllI = llllllllllllllllIIlIIIIIlllIIlll.getChatComponent().getUnformattedText();
                if (llllllllllllllllIIlIIIIIlllIIllI.startsWith("<") || llllllllllllllllIIlIIIIIlllIIllI.startsWith("[")) {
                    return;
                }
                String[] llllllllllllllllIIlIIIIIlllIIlIl = llllllllllllllllIIlIIIIIlllIIllI.split(": ");
                if (llllllllllllllllIIlIIIIIlllIIlIl.length < 2) {
                    return;
                }
                String llllllllllllllllIIlIIIIIlllIIlII = llllllllllllllllIIlIIIIIlllIIlIl[1];
                if (llllllllllllllllIIlIIIIIllIllIlI.player == 1 && llllllllllllllllIIlIIIIIlllIIllI.contains(String.valueOf(new StringBuilder().append("to ").append(llllllllllllllllIIlIIIIIllIllIlI.reloaderPlayername.getValue()))) && llllllllllllllllIIlIIIIIlllIIlII.equals("a")) {
                    Objects.requireNonNull(mc.getNetHandler()).getNetworkManager().closeChannel((ITextComponent)new TextComponentString("[AutoDupe] Quitting and waiting for AutoReconnect."));
                    llllllllllllllllIIlIIIIIllIllIlI.step = 8;
                } else if (llllllllllllllllIIlIIIIIllIllIlI.player == 2 && llllllllllllllllIIlIIIIIlllIIllI.contains("whispers") && llllllllllllllllIIlIIIIIlllIIllI.contains(llllllllllllllllIIlIIIIIllIllIlI.duperPlayername.getValue()) && llllllllllllllllIIlIIIIIlllIIlII.equals("a")) {
                    llllllllllllllllIIlIIIIIllIllIlI.buttonQueued = true;
                } else if (llllllllllllllllIIlIIIIIllIllIlI.player == 2 && llllllllllllllllIIlIIIIIlllIIllI.contains("whispers") && llllllllllllllllIIlIIIIIlllIIllI.contains(llllllllllllllllIIlIIIIIllIllIlI.duperPlayername.getValue()) && llllllllllllllllIIlIIIIIlllIIlII.equals("1")) {
                    llllllllllllllllIIlIIIIIllIllIlI.unloadQueued = true;
                    Command.sendClientMessage("Unloading.");
                }
            } else if (llllllllllllllllIIlIIIIIllIllIIl.getPacket() instanceof SPacketSetPassengers) {
                SPacketSetPassengers llllllllllllllllIIlIIIIIlllIIIlI = (SPacketSetPassengers)llllllllllllllllIIlIIIIIllIllIIl.getPacket();
                for (int llllllllllllllllIIlIIIIIlllIIIll : llllllllllllllllIIlIIIIIlllIIIlI.func_186971_a()) {
                    if (llllllllllllllllIIlIIIIIlllIIIll != Minecraft.getMinecraft().thePlayer.getEntityId()) continue;
                    llllllllllllllllIIlIIIIIllIllIlI.waitingForMount = false;
                    break;
                }
            } else if (llllllllllllllllIIlIIIIIllIllIIl.getPacket() instanceof SPacketBlockChange) {
                SPacketBlockChange llllllllllllllllIIlIIIIIlllIIIIl = (SPacketBlockChange)llllllllllllllllIIlIIIIIllIllIIl.getPacket();
                double llllllllllllllllIIlIIIIIlllIIIII = llllllllllllllllIIlIIIIIllIllIlI.storeItemsButtonX.getValue();
                double llllllllllllllllIIlIIIIIllIlllll = llllllllllllllllIIlIIIIIllIllIlI.storeItemsButtonY.getValue();
                double llllllllllllllllIIlIIIIIllIllllI = llllllllllllllllIIlIIIIIllIllIlI.storeItemsButtonZ.getValue();
                BlockPos llllllllllllllllIIlIIIIIllIlllIl = new BlockPos(llllllllllllllllIIlIIIIIlllIIIII, llllllllllllllllIIlIIIIIllIlllll, llllllllllllllllIIlIIIIIllIllllI);
                if (llllllllllllllllIIlIIIIIlllIIIIl.getBlockPosition().equals((Object)llllllllllllllllIIlIIIIIllIlllIl) && (llllllllllllllllIIlIIIIIlllIIIIl.blockState.getBlock() == Blocks.stone_button || llllllllllllllllIIlIIIIIlllIIIIl.blockState.getBlock() == Blocks.wooden_button && ((Boolean)llllllllllllllllIIlIIIIIlllIIIIl.blockState.getValue((IProperty)BlockButton.POWERED)).booleanValue())) {
                    llllllllllllllllIIlIIIIIllIllIlI.buttonQueued = false;
                }
            }
        }, new Predicate[0]);
    }

    private void lookAtPos(double llllllllllllllllIIlIIIIlIIllllII, Double llllllllllllllllIIlIIIIlIIlllIll, double llllllllllllllllIIlIIIIlIIlllIlI) {
        EntityPlayerSP llllllllllllllllIIlIIIIlIlIIIlII = Minecraft.getMinecraft().thePlayer;
        double llllllllllllllllIIlIIIIlIlIIIIll = llllllllllllllllIIlIIIIlIIllllII - llllllllllllllllIIlIIIIlIlIIIlII.posX;
        double llllllllllllllllIIlIIIIlIlIIIIlI = llllllllllllllllIIlIIIIlIIlllIlI - llllllllllllllllIIlIIIIlIlIIIlII.posZ;
        float llllllllllllllllIIlIIIIlIlIIIIIl = (float)(MathHelper.atan2((double)llllllllllllllllIIlIIIIlIlIIIIlI, (double)llllllllllllllllIIlIIIIlIlIIIIll) * 57.29577951308232) - 90.0f;
        double llllllllllllllllIIlIIIIlIlIIIIII = llllllllllllllllIIlIIIIlIIlllIll - llllllllllllllllIIlIIIIlIlIIIlII.posY;
        double llllllllllllllllIIlIIIIlIIllllll = MathHelper.sqrt_double((double)(llllllllllllllllIIlIIIIlIlIIIIll * llllllllllllllllIIlIIIIlIlIIIIll + llllllllllllllllIIlIIIIlIlIIIIII * llllllllllllllllIIlIIIIlIlIIIIII + llllllllllllllllIIlIIIIlIlIIIIlI * llllllllllllllllIIlIIIIlIlIIIIlI));
        float llllllllllllllllIIlIIIIlIIlllllI = -((float)(Math.asin(llllllllllllllllIIlIIIIlIlIIIIII / llllllllllllllllIIlIIIIlIIllllll) * 180.0 / Math.PI));
        llllllllllllllllIIlIIIIlIlIIIlII.rotationYaw += MathHelper.wrapAngleTo180_float((float)(llllllllllllllllIIlIIIIlIlIIIIIl - llllllllllllllllIIlIIIIlIlIIIlII.rotationYaw));
        llllllllllllllllIIlIIIIlIlIIIlII.rotationPitch = MathHelper.wrapAngleTo180_float((float)llllllllllllllllIIlIIIIlIIlllllI);
    }

    public void autoWalk(String llllllllllllllllIIlIIIIlIIIIIIll) {
        AutoDupe2b2t llllllllllllllllIIlIIIIlIIIIIlII;
        String llllllllllllllllIIlIIIIlIIIIIlIl = llllllllllllllllIIlIIIIlIIIIIlII.direction.getValue();
        if (llllllllllllllllIIlIIIIlIIIIIIll.equals("BACKWARDS")) {
            switch (llllllllllllllllIIlIIIIlIIIIIlIl) {
                case "south": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = -180.0f;
                    break;
                }
                case "north": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = 0.0f;
                    break;
                }
                case "east": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = 90.0f;
                    break;
                }
                case "west": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = -90.0f;
                }
            }
        } else {
            switch (llllllllllllllllIIlIIIIlIIIIIlIl) {
                case "south": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = 0.0f;
                    break;
                }
                case "north": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = -180.0f;
                    break;
                }
                case "east": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = -90.0f;
                    break;
                }
                case "west": {
                    AutoDupe2b2t.mc.thePlayer.rotationYaw = 90.0f;
                }
            }
        }
    }

    public static enum Directions {
        north,
        south,
        east,
        west;


        private Directions() {
            Directions llllllllllllllllIIlIllIIIlllIIlI;
        }
    }
}

