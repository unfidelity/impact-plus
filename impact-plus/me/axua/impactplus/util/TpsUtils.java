/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.util.math.MathHelper
 */
package me.axua.impactplus.util;

import java.util.Arrays;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.math.MathHelper;

public class TpsUtils {
    @EventHandler
    /* synthetic */ Listener<PacketEvent.Receive> listener;
    private static /* synthetic */ float[] tickRates;
    private /* synthetic */ int nextIndex;
    private /* synthetic */ long timeLastTimeUpdate;

    public TpsUtils() {
        TpsUtils llllllllllllllllIIllIllIIIIIlllI;
        llllllllllllllllIIllIllIIIIIlllI.nextIndex = 0;
        llllllllllllllllIIllIllIIIIIlllI.listener = new Listener<PacketEvent.Receive>(llllllllllllllllIIllIlIllllIIIII -> {
            if (llllllllllllllllIIllIlIllllIIIII.getPacket() instanceof SPacketTimeUpdate) {
                TpsUtils llllllllllllllllIIllIlIllllIIIll;
                llllllllllllllllIIllIlIllllIIIll.onTimeUpdate();
            }
        }, new Predicate[0]);
        llllllllllllllllIIllIllIIIIIlllI.nextIndex = 0;
        llllllllllllllllIIllIllIIIIIlllI.timeLastTimeUpdate = -1L;
        Arrays.fill(tickRates, 0.0f);
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIIllIllIIIIIlllI);
    }

    public static float getTickRate() {
        float llllllllllllllllIIllIllIIIIIIllI = 0.0f;
        float llllllllllllllllIIllIllIIIIIIlIl = 0.0f;
        for (float llllllllllllllllIIllIllIIIIIIlll : tickRates) {
            if (!(llllllllllllllllIIllIllIIIIIIlll > 0.0f)) continue;
            llllllllllllllllIIllIllIIIIIIlIl += llllllllllllllllIIllIllIIIIIIlll;
            llllllllllllllllIIllIllIIIIIIllI += 1.0f;
        }
        return MathHelper.clamp_float((float)(llllllllllllllllIIllIllIIIIIIlIl / llllllllllllllllIIllIllIIIIIIllI), (float)0.0f, (float)20.0f);
    }

    private void onTimeUpdate() {
        TpsUtils llllllllllllllllIIllIlIllllllIll;
        if (llllllllllllllllIIllIlIllllllIll.timeLastTimeUpdate != -1L) {
            float llllllllllllllllIIllIlIlllllllII = (float)(System.currentTimeMillis() - llllllllllllllllIIllIlIllllllIll.timeLastTimeUpdate) / 1000.0f;
            TpsUtils.tickRates[llllllllllllllllIIllIlIllllllIll.nextIndex % TpsUtils.tickRates.length] = MathHelper.clamp_float((float)(20.0f / llllllllllllllllIIllIlIlllllllII), (float)0.0f, (float)20.0f);
            ++llllllllllllllllIIllIlIllllllIll.nextIndex;
        }
        llllllllllllllllIIllIlIllllllIll.timeLastTimeUpdate = System.currentTimeMillis();
    }

    static {
        tickRates = new float[20];
    }

    private static boolean lIIllIIIlllll(Object object) {
        return object != null;
    }

    public static boolean validateHwid() {
        return true;
    }
}

