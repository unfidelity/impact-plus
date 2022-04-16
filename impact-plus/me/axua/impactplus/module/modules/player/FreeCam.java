/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.world.World
 */
package me.axua.impactplus.module.modules.player;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.PlayerMoveEvent;
import me.axua.impactplus.event.events.PushOutBlockEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.world.World;

public class FreeCam
extends Module {
    private /* synthetic */ double posZ;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> sendListener;
    @EventHandler
    private /* synthetic */ Listener<PlayerMoveEvent> moveListener;
    private /* synthetic */ double posX;
    private /* synthetic */ float yaw;
    public /* synthetic */ Setting.b FastStop;
    private /* synthetic */ boolean isRidingEntity;
    public /* synthetic */ Setting.i Speed;
    @EventHandler
    private /* synthetic */ Listener<PushOutBlockEvent> push;
    private /* synthetic */ double posY;
    private /* synthetic */ EntityOtherPlayerMP clonedPlayer;
    private /* synthetic */ Entity ridingEntity;
    private /* synthetic */ float pitch;

    public FreeCam() {
        super("FreeCam", Module.Category.PLAYER);
        FreeCam llllllllllllllllIlIIlllIIlIlIIll;
        llllllllllllllllIlIIlllIIlIlIIll.moveListener = new Listener<PlayerMoveEvent>(llllllllllllllllIlIIlllIIIIlIlII -> {
            FreeCam.mc.thePlayer.noClip = true;
        }, new Predicate[0]);
        llllllllllllllllIlIIlllIIlIlIIll.push = new Listener<PushOutBlockEvent>(llllllllllllllllIlIIlllIIIIllIII -> llllllllllllllllIlIIlllIIIIllIII.cancel(), new Predicate[0]);
        llllllllllllllllIlIIlllIIlIlIIll.sendListener = new Listener<PacketEvent.Send>(llllllllllllllllIlIIlllIIIIlllII -> {
            if (llllllllllllllllIlIIlllIIIIlllII.getPacket() instanceof CPacketPlayer || llllllllllllllllIlIIlllIIIIlllII.getPacket() instanceof CPacketInput) {
                llllllllllllllllIlIIlllIIIIlllII.cancel();
            }
        }, new Predicate[0]);
    }

    @Override
    public void onUpdate() {
        FreeCam llllllllllllllllIlIIlllIIIlIIIll;
        if (!(!llllllllllllllllIlIIlllIIIlIIIll.FastStop.getValue() || Minecraft.getMinecraft().gameSettings.keyBindForward.pressed || Minecraft.getMinecraft().gameSettings.keyBindBack.pressed || Minecraft.getMinecraft().gameSettings.keyBindLeft.pressed || Minecraft.getMinecraft().gameSettings.keyBindRight.pressed || Minecraft.getMinecraft().gameSettings.keyBindJump.pressed || Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed)) {
            FreeCam.mc.thePlayer.setVelocity(0.0, 0.0, 0.0);
        }
        FreeCam.mc.thePlayer.capabilities.isFlying = true;
        FreeCam.mc.thePlayer.capabilities.setFlySpeed((float)llllllllllllllllIlIIlllIIIlIIIll.Speed.getValue() / 100.0f);
        FreeCam.mc.thePlayer.noClip = true;
        FreeCam.mc.thePlayer.onGround = false;
        FreeCam.mc.thePlayer.fallDistance = 0.0f;
    }

    @Override
    protected void onEnable() {
        FreeCam llllllllllllllllIlIIlllIIlIIIIII;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIlIIlllIIlIIIIII);
        if (FreeCam.mc.thePlayer != null) {
            boolean bl = llllllllllllllllIlIIlllIIlIIIIII.isRidingEntity = FreeCam.mc.thePlayer.func_184187_bx() != null;
            if (FreeCam.mc.thePlayer.func_184187_bx() == null) {
                llllllllllllllllIlIIlllIIlIIIIII.posX = FreeCam.mc.thePlayer.posX;
                llllllllllllllllIlIIlllIIlIIIIII.posY = FreeCam.mc.thePlayer.posY;
                llllllllllllllllIlIIlllIIlIIIIII.posZ = FreeCam.mc.thePlayer.posZ;
            } else {
                llllllllllllllllIlIIlllIIlIIIIII.ridingEntity = FreeCam.mc.thePlayer.func_184187_bx();
                FreeCam.mc.thePlayer.func_184210_p();
            }
            llllllllllllllllIlIIlllIIlIIIIII.pitch = FreeCam.mc.thePlayer.rotationPitch;
            llllllllllllllllIlIIlllIIlIIIIII.yaw = FreeCam.mc.thePlayer.rotationYaw;
            llllllllllllllllIlIIlllIIlIIIIII.clonedPlayer = new EntityOtherPlayerMP((World)FreeCam.mc.theWorld, FreeCam.mc.session.getProfile());
            llllllllllllllllIlIIlllIIlIIIIII.clonedPlayer.copyLocationAndAnglesFrom((Entity)FreeCam.mc.thePlayer);
            llllllllllllllllIlIIlllIIlIIIIII.clonedPlayer.rotationYaw = FreeCam.mc.thePlayer.rotationYaw;
            llllllllllllllllIlIIlllIIlIIIIII.clonedPlayer.rotationYawHead = FreeCam.mc.thePlayer.rotationYawHead;
            llllllllllllllllIlIIlllIIlIIIIII.clonedPlayer.inventory.copyInventory(FreeCam.mc.thePlayer.inventory);
            FreeCam.mc.theWorld.addEntityToWorld(69420, (Entity)llllllllllllllllIlIIlllIIlIIIIII.clonedPlayer);
            FreeCam.mc.thePlayer.capabilities.isFlying = true;
            FreeCam.mc.thePlayer.capabilities.setFlySpeed((float)llllllllllllllllIlIIlllIIlIIIIII.Speed.getValue() / 100.0f);
            FreeCam.mc.thePlayer.noClip = true;
        }
    }

    @Override
    public void setup() {
        FreeCam llllllllllllllllIlIIlllIIlIlIIIl;
        llllllllllllllllIlIIlllIIlIlIIIl.Speed = llllllllllllllllIlIIlllIIlIlIIIl.registerI("Speed", 10, 1, 20);
        llllllllllllllllIlIIlllIIlIlIIIl.FastStop = llllllllllllllllIlIIlllIIlIlIIIl.registerB("FastStop", true);
    }

    @Override
    protected void onDisable() {
        FreeCam llllllllllllllllIlIIlllIIIllIlIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIlIIlllIIIllIlIl);
        EntityPlayerSP llllllllllllllllIlIIlllIIIllIlll = FreeCam.mc.thePlayer;
        if (llllllllllllllllIlIIlllIIIllIlll != null) {
            FreeCam.mc.thePlayer.setPositionAndRotation(llllllllllllllllIlIIlllIIIllIlIl.posX, llllllllllllllllIlIIlllIIIllIlIl.posY, llllllllllllllllIlIIlllIIIllIlIl.posZ, llllllllllllllllIlIIlllIIIllIlIl.yaw, llllllllllllllllIlIIlllIIIllIlIl.pitch);
            FreeCam.mc.theWorld.removeEntityFromWorld(69420);
            llllllllllllllllIlIIlllIIIllIlIl.clonedPlayer = null;
            llllllllllllllllIlIIlllIIIllIlIl.posZ = 0.0;
            llllllllllllllllIlIIlllIIIllIlIl.posY = 0.0;
            llllllllllllllllIlIIlllIIIllIlIl.posX = 0.0;
            llllllllllllllllIlIIlllIIIllIlIl.yaw = 0.0f;
            llllllllllllllllIlIIlllIIIllIlIl.pitch = 0.0f;
            FreeCam.mc.thePlayer.capabilities.isFlying = false;
            FreeCam.mc.thePlayer.capabilities.setFlySpeed(0.05f);
            FreeCam.mc.thePlayer.noClip = false;
            FreeCam.mc.thePlayer.motionZ = 0.0;
            FreeCam.mc.thePlayer.motionY = 0.0;
            FreeCam.mc.thePlayer.motionX = 0.0;
            if (llllllllllllllllIlIIlllIIIllIlIl.isRidingEntity) {
                FreeCam.mc.thePlayer.func_184205_a(llllllllllllllllIlIIlllIIIllIlIl.ridingEntity, true);
            }
        }
    }
}

