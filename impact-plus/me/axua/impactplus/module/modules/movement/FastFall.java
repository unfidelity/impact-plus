/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.movement;

import me.axua.impactplus.module.Module;

public class FastFall
extends Module {
    @Override
    public void onUpdate() {
        if (FastFall.mc.thePlayer.onGround) {
            FastFall.mc.thePlayer.motionY -= 1.0;
        }
    }

    public FastFall() {
        super("FastFall", Module.Category.MOVEMENT, "Makes you fall down faster");
        FastFall llllllllllllllllIIllllIlllIIIlII;
    }
}

