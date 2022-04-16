/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.item.EntityFallingBlock
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.network.play.server.SPacketMaps
 *  net.minecraft.network.play.server.SPacketUpdateBossInfo
 *  net.minecraftforge.client.event.RenderBlockOverlayEvent
 *  net.minecraftforge.client.event.RenderBlockOverlayEvent$OverlayType
 */
package me.axua.impactplus.module.modules.render;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventRenderSign;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;

public class NoRender
extends Module {
    public /* synthetic */ Setting.b maps;
    public /* synthetic */ Setting.b fire;
    public /* synthetic */ Setting.b withers;
    public /* synthetic */ Setting.b hurtCam;
    @EventHandler
    public /* synthetic */ Listener<PacketEvent.Receive> receiveListener;
    public /* synthetic */ Setting.b fallingblocks;
    @EventHandler
    public /* synthetic */ Listener<RenderBlockOverlayEvent> blockOverlayEventListener;
    public /* synthetic */ Setting.b nausea;
    public /* synthetic */ Setting.b clearBkg;
    public /* synthetic */ Setting.b explosion;
    public /* synthetic */ Setting.b armor;
    public /* synthetic */ Setting.b nobackground;
    public /* synthetic */ Setting.b blind;
    public /* synthetic */ Setting.b sign;
    @EventHandler
    private /* synthetic */ Listener<EventRenderSign> OnRenderSign;
    public /* synthetic */ Setting.b bossinfo;

    @Override
    public void onEnable() {
        NoRender lllllllllllllllIllIllIIIIllIllll;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllIllIllIIIIllIllll);
    }

    public NoRender() {
        super("NoRender", Module.Category.RENDER, "Prevents rendering some things");
        NoRender lllllllllllllllIllIllIIIIllllIII;
        lllllllllllllllIllIllIIIIllllIII.blockOverlayEventListener = new Listener<RenderBlockOverlayEvent>(lllllllllllllllIllIllIIIIlIllIIl -> {
            NoRender lllllllllllllllIllIllIIIIlIllIII;
            if (lllllllllllllllIllIllIIIIlIllIII.fire.getValue() && lllllllllllllllIllIllIIIIlIllIIl.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE) {
                lllllllllllllllIllIllIIIIlIllIIl.setCanceled(true);
            }
        }, new Predicate[0]);
        lllllllllllllllIllIllIIIIllllIII.receiveListener = new Listener<PacketEvent.Receive>(lllllllllllllllIllIllIIIIllIIIIl -> {
            NoRender lllllllllllllllIllIllIIIIlIlllll;
            Packet lllllllllllllllIllIllIIIIllIIIII = lllllllllllllllIllIllIIIIllIIIIl.getPacket();
            if (lllllllllllllllIllIllIIIIllIIIII instanceof SPacketMaps && lllllllllllllllIllIllIIIIlIlllll.maps.getValue() || lllllllllllllllIllIllIIIIllIIIII instanceof SPacketUpdateBossInfo && lllllllllllllllIllIllIIIIlIlllll.bossinfo.getValue() || lllllllllllllllIllIllIIIIllIIIII instanceof SPacketExplosion && lllllllllllllllIllIllIIIIlIlllll.explosion.getValue()) {
                lllllllllllllllIllIllIIIIllIIIIl.cancel();
            }
        }, new Predicate[0]);
        lllllllllllllllIllIllIIIIllllIII.OnRenderSign = new Listener<EventRenderSign>(lllllllllllllllIllIllIIIIllIlIII -> {
            NoRender lllllllllllllllIllIllIIIIllIIlll;
            if (lllllllllllllllIllIllIIIIllIIlll.sign.getValue()) {
                lllllllllllllllIllIllIIIIllIlIII.cancel();
            }
        }, new Predicate[0]);
    }

    @Override
    public void onDisable() {
        NoRender lllllllllllllllIllIllIIIIllIllIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllIllIllIIIIllIllIl);
    }

    @Override
    public void onUpdate() {
        NoRender lllllllllllllllIllIllIIIIlllIIll;
        if (lllllllllllllllIllIllIIIIlllIIll.blind.getValue() && NoRender.mc.thePlayer.isPotionActive(MobEffects.blindness)) {
            NoRender.mc.thePlayer.func_184589_d(MobEffects.blindness);
        }
        if (lllllllllllllllIllIllIIIIlllIIll.nausea.getValue() && NoRender.mc.thePlayer.isPotionActive(MobEffects.confusion)) {
            NoRender.mc.thePlayer.func_184589_d(MobEffects.confusion);
        }
        if (lllllllllllllllIllIllIIIIlllIIll.fallingblocks.getValue()) {
            NoRender.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllIllIllIIIIlIIlIll -> lllllllllllllllIllIllIIIIlIIlIll instanceof EntityFallingBlock).forEach(lllllllllllllllIllIllIIIIlIIllll -> NoRender.mc.theWorld.removeEntity(lllllllllllllllIllIllIIIIlIIllll));
        }
        if (lllllllllllllllIllIllIIIIlllIIll.withers.getValue()) {
            NoRender.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllIllIllIIIIlIlIIlI -> lllllllllllllllIllIllIIIIlIlIIlI instanceof EntityWither).forEach(lllllllllllllllIllIllIIIIlIlIlII -> NoRender.mc.theWorld.removeEntity(lllllllllllllllIllIllIIIIlIlIlII));
        }
    }

    @Override
    public void setup() {
        NoRender lllllllllllllllIllIllIIIIlllIlIl;
        lllllllllllllllIllIllIIIIlllIlIl.armor = lllllllllllllllIllIllIIIIlllIlIl.registerB("Armor", false);
        lllllllllllllllIllIllIIIIlllIlIl.fire = lllllllllllllllIllIllIIIIlllIlIl.registerB("Fire", false);
        lllllllllllllllIllIllIIIIlllIlIl.blind = lllllllllllllllIllIllIIIIlllIlIl.registerB("Blindness", false);
        lllllllllllllllIllIllIIIIlllIlIl.nausea = lllllllllllllllIllIllIIIIlllIlIl.registerB("Nausea", false);
        lllllllllllllllIllIllIIIIlllIlIl.hurtCam = lllllllllllllllIllIllIIIIlllIlIl.registerB("HurtCam", false);
        lllllllllllllllIllIllIIIIlllIlIl.explosion = lllllllllllllllIllIllIIIIlllIlIl.registerB("Explosion", false);
        lllllllllllllllIllIllIIIIlllIlIl.bossinfo = lllllllllllllllIllIllIIIIlllIlIl.registerB("BossInfo", false);
        lllllllllllllllIllIllIIIIlllIlIl.maps = lllllllllllllllIllIllIIIIlllIlIl.registerB("Maps", false);
        lllllllllllllllIllIllIIIIlllIlIl.sign = lllllllllllllllIllIllIIIIlllIlIl.registerB("Sign", false);
        lllllllllllllllIllIllIIIIlllIlIl.fallingblocks = lllllllllllllllIllIllIIIIlllIlIl.registerB("FallingBlocks", false);
        lllllllllllllllIllIllIIIIlllIlIl.withers = lllllllllllllllIllIllIIIIlllIlIl.registerB("Withers", false);
        lllllllllllllllIllIllIIIIlllIlIl.nobackground = lllllllllllllllIllIllIIIIlllIlIl.registerB("NoBackground", false);
        lllllllllllllllIllIllIIIIlllIlIl.clearBkg = lllllllllllllllIllIllIIIIlllIlIl.registerB("ClearChat", false);
    }
}

