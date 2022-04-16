/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.lwjgl.input.Mouse
 */
package me.axua.impactplus.module.modules.combat;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.lwjgl.input.Mouse;

public class FeetExp
extends Module {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> packetSendListener;
    /* synthetic */ int lol;

    public FeetExp() {
        super("FeetExp", Module.Category.COMBAT, "Fortnite");
        FeetExp lllllllllllllllllIIlIIIllllIllII;
        lllllllllllllllllIIlIIIllllIllII.packetSendListener = new Listener<PacketEvent.Send>(lllllllllllllllllIIlIIIlllIlIllI -> {
            FeetExp lllllllllllllllllIIlIIIlllIlIlll;
            Packet lllllllllllllllllIIlIIIlllIllIII = lllllllllllllllllIIlIIIlllIlIllI.getPacket();
            if (lllllllllllllllllIIlIIIlllIllIII instanceof CPacketPlayer && lllllllllllllllllIIlIIIlllIlIlll.lol == 1) {
                ((CPacketPlayer)lllllllllllllllllIIlIIIlllIllIII).pitch = 90.0f;
            }
        }, new Predicate[0]);
    }

    @Override
    public void onEnable() {
        FeetExp lllllllllllllllllIIlIIIllllIIIIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllllIIlIIIllllIIIIl);
    }

    @Override
    public void onDisable() {
        FeetExp lllllllllllllllllIIlIIIlllIllllI;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllllIIlIIIlllIllllI);
    }

    @Override
    public void onUpdate() {
        ItemStack lllllllllllllllllIIlIIIllllIIllI = FeetExp.mc.thePlayer.func_184614_ca();
        lllllllllllllllllIIlIIIllllIIlll.lol = lllllllllllllllllIIlIIIllllIIllI.getItem() == Items.experience_bottle && Mouse.isButtonDown((int)1) ? 1 : 0;
    }
}

