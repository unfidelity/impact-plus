/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.event;

import me.axua.impactplus.util.Wrapper;
import me.zero.alpine.type.Cancellable;

public class ImpactPlusEvent
extends Cancellable {
    private final /* synthetic */ float partialTicks;
    private /* synthetic */ Era era;

    public ImpactPlusEvent() {
        ImpactPlusEvent lllIllllIllIl;
        lllIllllIllIl.era = Era.PRE;
        lllIllllIllIl.partialTicks = Wrapper.getMinecraft().func_184121_ak();
    }

    public float getPartialTicks() {
        ImpactPlusEvent lllIllllIIlll;
        return lllIllllIIlll.partialTicks;
    }

    public Era getEra() {
        ImpactPlusEvent lllIllllIlIIl;
        return lllIllllIlIIl.era;
    }

    public static enum Era {
        PRE,
        PERI,
        POST;


        private Era() {
            Era lIllllIlllIIIII;
        }
    }
}

