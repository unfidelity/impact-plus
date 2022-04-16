/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.util.math.MathHelper
 */
package me.axua.impactplus.module.modules.movement;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.PlayerTravelEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.Wrapper;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.MathHelper;

public class ElytraFly
extends Module {
    public static /* synthetic */ boolean flyUp;
    /* synthetic */ Setting.d sinkSpeed;
    /* synthetic */ Setting.i downSpeed;
    /* synthetic */ Setting.b hover;
    /* synthetic */ double speednigger;
    /* synthetic */ Setting.d speedend;
    /* synthetic */ Setting.d speedow;
    /* synthetic */ Setting.d speednether;
    @EventHandler
    private /* synthetic */ Listener<PlayerTravelEvent> playerTravelListener;
    /* synthetic */ Setting.b setecme;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> sendListener;
    /* synthetic */ Setting.b AutoOpen;
    public static /* synthetic */ boolean autoFly;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> recvListener;
    /* synthetic */ Setting.b set2b2t;
    private /* synthetic */ double hoverTarget;
    private /* synthetic */ boolean hoverState;
    public /* synthetic */ float packetYaw;

    @Override
    public void onUpdate() {
        ElytraFly lllllllllllllllllIIllllIIlIlIIll;
        if (lllllllllllllllllIIllllIIlIlIIll.set2b2t.getValue()) {
            lllllllllllllllllIIllllIIlIlIIll.hover.setValue(false);
            lllllllllllllllllIIllllIIlIlIIll.AutoOpen.setValue(true);
            lllllllllllllllllIIllllIIlIlIIll.speedow.setValue(1.8);
            lllllllllllllllllIIllllIIlIlIIll.speedend.setValue(1.8);
            lllllllllllllllllIIllllIIlIlIIll.speednether.setValue(1.8);
            lllllllllllllllllIIllllIIlIlIIll.downSpeed.setValue(2);
            lllllllllllllllllIIllllIIlIlIIll.sinkSpeed.setValue(0.001);
            lllllllllllllllllIIllllIIlIlIIll.set2b2t.setValue(false);
        }
        if (lllllllllllllllllIIllllIIlIlIIll.setecme.getValue()) {
            lllllllllllllllllIIllllIIlIlIIll.hover.setValue(false);
            lllllllllllllllllIIllllIIlIlIIll.AutoOpen.setValue(true);
            lllllllllllllllllIIllllIIlIlIIll.speedow.setValue(2.499999);
            lllllllllllllllllIIllllIIlIlIIll.speedend.setValue(2.499999);
            lllllllllllllllllIIllllIIlIlIIll.speednether.setValue(4.999999);
            lllllllllllllllllIIllllIIlIlIIll.downSpeed.setValue(2);
            lllllllllllllllllIIllllIIlIlIIll.sinkSpeed.setValue(0.0);
            lllllllllllllllllIIllllIIlIlIIll.setecme.setValue(false);
        }
        lllllllllllllllllIIllllIIlIlIIll.speednigger = 0.0;
        if (ElytraFly.mc.thePlayer.dimension == -1) {
            lllllllllllllllllIIllllIIlIlIIll.speednigger = lllllllllllllllllIIllllIIlIlIIll.speednether.getValue();
        } else if (ElytraFly.mc.thePlayer.dimension == 0) {
            lllllllllllllllllIIllllIIlIlIIll.speednigger = lllllllllllllllllIIllllIIlIlIIll.speedow.getValue();
        } else if (ElytraFly.mc.thePlayer.dimension == 1) {
            lllllllllllllllllIIllllIIlIlIIll.speednigger = lllllllllllllllllIIllllIIlIlIIll.speedend.getValue();
        }
    }

    @Override
    protected void onEnable() {
        ElytraFly lllllllllllllllllIIllllIIlIIllll;
        lllllllllllllllllIIllllIIlIIllll.hoverTarget = -1.0;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllllIIllllIIlIIllll);
    }

    static {
        flyUp = false;
        autoFly = false;
    }

    @Override
    public void setup() {
        ElytraFly lllllllllllllllllIIllllIIlIlIlIl;
        lllllllllllllllllIIllllIIlIlIlIl.hover = lllllllllllllllllIIllllIIlIlIlIl.registerB("Hover", true);
        lllllllllllllllllIIllllIIlIlIlIl.AutoOpen = lllllllllllllllllIIllllIIlIlIlIl.registerB("AutoOpen", true);
        lllllllllllllllllIIllllIIlIlIlIl.speedow = lllllllllllllllllIIllllIIlIlIlIl.registerD("SpeedOW", 1.8, 0.0, 20.0);
        lllllllllllllllllIIllllIIlIlIlIl.speednether = lllllllllllllllllIIllllIIlIlIlIl.registerD("SpeedNether", 1.8, 0.0, 20.0);
        lllllllllllllllllIIllllIIlIlIlIl.speedend = lllllllllllllllllIIllllIIlIlIlIl.registerD("SpeedEnd", 1.8, 0.0, 20.0);
        lllllllllllllllllIIllllIIlIlIlIl.downSpeed = lllllllllllllllllIIllllIIlIlIlIl.registerI("DownSpeed", 2, 0, 10);
        lllllllllllllllllIIllllIIlIlIlIl.sinkSpeed = lllllllllllllllllIIllllIIlIlIlIl.registerD("SinkSpeed", 0.001, 0.0, 20.0);
        lllllllllllllllllIIllllIIlIlIlIl.set2b2t = lllllllllllllllllIIllllIIlIlIlIl.registerB("Set2b2t", false);
        lllllllllllllllllIIllllIIlIlIlIl.setecme = lllllllllllllllllIIllllIIlIlIlIl.registerB("Setecme", false);
        lllllllllllllllllIIllllIIlIlIlIl.hoverTarget = -1.0;
        lllllllllllllllllIIllllIIlIlIlIl.hoverState = false;
        lllllllllllllllllIIllllIIlIlIlIl.packetYaw = 0.0f;
    }

    public ElytraFly() {
        super("ElytraFly", Module.Category.MOVEMENT);
        ElytraFly lllllllllllllllllIIllllIIlIllIII;
        lllllllllllllllllIIllllIIlIllIII.sendListener = new Listener<PacketEvent.Send>(lllllllllllllllllIIllllIIIIIllII -> {
            CPacketEntityAction lllllllllllllllllIIllllIIIIlIIII;
            if (ElytraFly.mc.thePlayer == null) {
                return;
            }
            if (lllllllllllllllllIIllllIIIIIllII.getPacket() instanceof CPacketPlayer) {
                ElytraFly lllllllllllllllllIIllllIIIIIllll;
                if (!ElytraFly.mc.thePlayer.func_184613_cA()) {
                    return;
                }
                CPacketPlayer lllllllllllllllllIIllllIIIIlIIIl = (CPacketPlayer)lllllllllllllllllIIllllIIIIIllII.getPacket();
                lllllllllllllllllIIllllIIIIlIIIl.pitch = 0.0f;
                lllllllllllllllllIIllllIIIIlIIIl.yaw = lllllllllllllllllIIllllIIIIIllll.packetYaw;
            }
            if (lllllllllllllllllIIllllIIIIIllII.getPacket() instanceof CPacketEntityAction && (lllllllllllllllllIIllllIIIIlIIII = (CPacketEntityAction)lllllllllllllllllIIllllIIIIIllII.getPacket()).getAction() == CPacketEntityAction.Action.START_FALL_FLYING) {
                lllllllllllllllllIIllllIIIIIllll.hoverTarget = ElytraFly.mc.thePlayer.posY + 0.35;
            }
        }, new Predicate[0]);
        lllllllllllllllllIIllllIIlIllIII.recvListener = new Listener<PacketEvent.Receive>(lllllllllllllllllIIllllIIIIlIlll -> {
            if (ElytraFly.mc.thePlayer == null || !ElytraFly.mc.thePlayer.func_184613_cA()) {
                return;
            }
            if (lllllllllllllllllIIllllIIIIlIlll.getPacket() instanceof SPacketPlayerPosLook) {
                SPacketPlayerPosLook lllllllllllllllllIIllllIIIIllIII = (SPacketPlayerPosLook)lllllllllllllllllIIllllIIIIlIlll.getPacket();
                lllllllllllllllllIIllllIIIIllIII.pitch = ElytraFly.mc.thePlayer.rotationPitch;
            }
        }, new Predicate[0]);
        lllllllllllllllllIIllllIIlIllIII.playerTravelListener = new Listener<PlayerTravelEvent>(lllllllllllllllllIIllllIIIllIlll -> {
            boolean lllllllllllllllllIIllllIIIlIlIll;
            ElytraFly lllllllllllllllllIIllllIIIlllIII;
            if (ElytraFly.mc.thePlayer == null) {
                return;
            }
            if (!ElytraFly.mc.thePlayer.func_184613_cA()) {
                if (lllllllllllllllllIIllllIIIlllIII.AutoOpen.getValue() && !ElytraFly.mc.thePlayer.onGround && ElytraFly.mc.thePlayer.motionY < -0.04) {
                    CPacketEntityAction lllllllllllllllllIIllllIIIlllIll = new CPacketEntityAction((Entity)ElytraFly.mc.thePlayer, CPacketEntityAction.Action.START_FALL_FLYING);
                    Wrapper.getPlayer().sendQueue.addToSendQueue((Packet)lllllllllllllllllIIllllIIIlllIll);
                    ElytraFly.mc.timer.field_194149_e = 200.0f;
                    lllllllllllllllllIIllllIIIllIlll.cancel();
                    return;
                }
                return;
            }
            ElytraFly.mc.timer.field_194149_e = 50.0f;
            if (lllllllllllllllllIIllllIIIlllIII.hoverTarget < 0.0) {
                lllllllllllllllllIIllllIIIlllIII.hoverTarget = ElytraFly.mc.thePlayer.posY;
            }
            boolean lllllllllllllllllIIllllIIIllIllI = ElytraFly.mc.gameSettings.keyBindForward.isKeyDown();
            boolean lllllllllllllllllIIllllIIIllIlIl = ElytraFly.mc.gameSettings.keyBindBack.isKeyDown();
            boolean lllllllllllllllllIIllllIIIllIlII = ElytraFly.mc.gameSettings.keyBindLeft.isKeyDown();
            boolean lllllllllllllllllIIllllIIIllIIll = ElytraFly.mc.gameSettings.keyBindRight.isKeyDown();
            boolean lllllllllllllllllIIllllIIIllIIlI = ElytraFly.mc.gameSettings.keyBindJump.isKeyDown();
            boolean lllllllllllllllllIIllllIIIllIIIl = ElytraFly.mc.gameSettings.keyBindSneak.isKeyDown();
            float lllllllllllllllllIIllllIIIllIIII = lllllllllllllllllIIllllIIIllIllI ? 1.0f : -1.0f;
            float lllllllllllllllllIIllllIIIlIllll = ElytraFly.mc.thePlayer.rotationYaw;
            if (lllllllllllllllllIIllllIIIllIlII && (lllllllllllllllllIIllllIIIllIllI || lllllllllllllllllIIllllIIIllIlIl)) {
                lllllllllllllllllIIllllIIIlIllll -= 40.0f * lllllllllllllllllIIllllIIIllIIII;
            } else if (lllllllllllllllllIIllllIIIllIIll && (lllllllllllllllllIIllllIIIllIllI || lllllllllllllllllIIllllIIIllIlIl)) {
                lllllllllllllllllIIllllIIIlIllll += 40.0f * lllllllllllllllllIIllllIIIllIIII;
            } else if (lllllllllllllllllIIllllIIIllIlII) {
                lllllllllllllllllIIllllIIIlIllll -= 90.0f;
            } else if (lllllllllllllllllIIllllIIIllIIll) {
                lllllllllllllllllIIllllIIIlIllll += 90.0f;
            }
            if (lllllllllllllllllIIllllIIIllIlIl) {
                lllllllllllllllllIIllllIIIlIllll -= 180.0f;
            }
            lllllllllllllllllIIllllIIIlllIII.packetYaw = lllllllllllllllllIIllllIIIlIllll;
            float lllllllllllllllllIIllllIIIlIlllI = (float)Math.toRadians(lllllllllllllllllIIllllIIIlIllll);
            float lllllllllllllllllIIllllIIIlIllIl = (float)Math.toRadians(ElytraFly.mc.thePlayer.rotationPitch);
            double lllllllllllllllllIIllllIIIlIllII = Math.sqrt(ElytraFly.mc.thePlayer.motionX * ElytraFly.mc.thePlayer.motionX + ElytraFly.mc.thePlayer.motionZ * ElytraFly.mc.thePlayer.motionZ);
            lllllllllllllllllIIllllIIIlllIII.hoverState = lllllllllllllllllIIllllIIIlllIII.hoverState ? ElytraFly.mc.thePlayer.posY < lllllllllllllllllIIllllIIIlllIII.hoverTarget + 0.1 : ElytraFly.mc.thePlayer.posY < lllllllllllllllllIIllllIIIlllIII.hoverTarget + 0.0;
            boolean bl = lllllllllllllllllIIllllIIIlIlIll = lllllllllllllllllIIllllIIIlllIII.hoverState && lllllllllllllllllIIllllIIIlllIII.hover.getValue();
            if (lllllllllllllllllIIllllIIIllIIlI || lllllllllllllllllIIllllIIIllIllI || lllllllllllllllllIIllllIIIllIlIl || lllllllllllllllllIIllllIIIllIlII || lllllllllllllllllIIllllIIIllIIll || autoFly || ModuleManager.isModuleEnabled("AutoWalk")) {
                if ((lllllllllllllllllIIllllIIIllIIlI || lllllllllllllllllIIllllIIIlIlIll || flyUp) && lllllllllllllllllIIllllIIIlIllII > 1.0) {
                    if (ElytraFly.mc.thePlayer.motionX == 0.0 && ElytraFly.mc.thePlayer.motionZ == 0.0) {
                        ElytraFly.mc.thePlayer.motionY = lllllllllllllllllIIllllIIIlllIII.downSpeed.getValue();
                    } else {
                        double lllllllllllllllllIIllllIIIlllIlI = 1.0;
                        double lllllllllllllllllIIllllIIIlllIIl = lllllllllllllllllIIllllIIIlIllII * 0.2 * 0.04;
                        ElytraFly.mc.thePlayer.motionY += lllllllllllllllllIIllllIIIlllIIl * 3.2;
                        ElytraFly.mc.thePlayer.motionX -= (double)(-MathHelper.sin((float)lllllllllllllllllIIllllIIIlIlllI)) * lllllllllllllllllIIllllIIIlllIIl / lllllllllllllllllIIllllIIIlllIlI;
                        ElytraFly.mc.thePlayer.motionZ -= (double)MathHelper.cos((float)lllllllllllllllllIIllllIIIlIlllI) * lllllllllllllllllIIllllIIIlllIIl / lllllllllllllllllIIllllIIIlllIlI;
                        if (lllllllllllllllllIIllllIIIlllIlI > 0.0) {
                            ElytraFly.mc.thePlayer.motionX += ((double)(-MathHelper.sin((float)lllllllllllllllllIIllllIIIlIlllI)) / lllllllllllllllllIIllllIIIlllIlI * lllllllllllllllllIIllllIIIlIllII - ElytraFly.mc.thePlayer.motionX) * 0.3;
                            ElytraFly.mc.thePlayer.motionZ += ((double)MathHelper.cos((float)lllllllllllllllllIIllllIIIlIlllI) / lllllllllllllllllIIllllIIIlllIlI * lllllllllllllllllIIllllIIIlIllII - ElytraFly.mc.thePlayer.motionZ) * 0.3;
                        }
                        ElytraFly.mc.thePlayer.motionX *= (double)0.99f;
                        ElytraFly.mc.thePlayer.motionY *= (double)0.98f;
                        ElytraFly.mc.thePlayer.motionZ *= (double)0.99f;
                    }
                } else {
                    ElytraFly.mc.thePlayer.motionX = (double)(-MathHelper.sin((float)lllllllllllllllllIIllllIIIlIlllI)) * lllllllllllllllllIIllllIIIlllIII.speednigger;
                    ElytraFly.mc.thePlayer.motionY = -lllllllllllllllllIIllllIIIlllIII.sinkSpeed.getValue();
                    ElytraFly.mc.thePlayer.motionZ = (double)MathHelper.cos((float)lllllllllllllllllIIllllIIIlIlllI) * lllllllllllllllllIIllllIIIlllIII.speednigger;
                }
            } else {
                ElytraFly.mc.thePlayer.motionX = 0.0;
                ElytraFly.mc.thePlayer.motionY = 0.0;
                ElytraFly.mc.thePlayer.motionZ = 0.0;
            }
            if (lllllllllllllllllIIllllIIIllIIIl) {
                ElytraFly.mc.thePlayer.motionY = -lllllllllllllllllIIllllIIIlllIII.downSpeed.getValue();
            }
            if (lllllllllllllllllIIllllIIIllIIlI || lllllllllllllllllIIllllIIIllIIIl) {
                lllllllllllllllllIIllllIIIlllIII.hoverTarget = ElytraFly.mc.thePlayer.posY;
            }
            lllllllllllllllllIIllllIIIllIlll.cancel();
        }, new Predicate[0]);
    }

    @Override
    protected void onDisable() {
        ElytraFly lllllllllllllllllIIllllIIlIIllII;
        ElytraFly.mc.timer.field_194149_e = 50.0f;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllllIIllllIIlIIllII);
    }
}

