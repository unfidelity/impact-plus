/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
package me.axua.impactplus.module.modules.movement;

import me.axua.impactplus.module.Module;
import net.minecraft.util.math.MathHelper;

public class Strafe
extends Module {
    /* synthetic */ int forward;
    /* synthetic */ int waitCounter;

    @Override
    public void onUpdate() {
        boolean lllllllllllllllllIIIIllllIIIIIll;
        boolean bl = lllllllllllllllllIIIIllllIIIIIll = Math.abs(Strafe.mc.thePlayer.rotationYawHead - Strafe.mc.thePlayer.rotationYaw) < 90.0f;
        if (Strafe.mc.thePlayer.field_191988_bg != 0.0f) {
            Strafe lllllllllllllllllIIIIllllIIIIllI;
            if (!Strafe.mc.thePlayer.isSprinting()) {
                Strafe.mc.thePlayer.setSprinting(true);
            }
            float lllllllllllllllllIIIIllllIIIIlll = Strafe.mc.thePlayer.rotationYaw;
            if (Strafe.mc.thePlayer.field_191988_bg > 0.0f) {
                if (Strafe.mc.thePlayer.movementInput.moveStrafe != 0.0f) {
                    lllllllllllllllllIIIIllllIIIIlll += Strafe.mc.thePlayer.movementInput.moveStrafe > 0.0f ? -45.0f : 45.0f;
                }
                lllllllllllllllllIIIIllllIIIIllI.forward = 1;
                Strafe.mc.thePlayer.field_191988_bg = 1.0f;
                Strafe.mc.thePlayer.moveStrafing = 0.0f;
            } else if (Strafe.mc.thePlayer.field_191988_bg < 0.0f) {
                if (Strafe.mc.thePlayer.movementInput.moveStrafe != 0.0f) {
                    lllllllllllllllllIIIIllllIIIIlll += Strafe.mc.thePlayer.movementInput.moveStrafe > 0.0f ? 45.0f : -45.0f;
                }
                lllllllllllllllllIIIIllllIIIIllI.forward = -1;
                Strafe.mc.thePlayer.field_191988_bg = -1.0f;
                Strafe.mc.thePlayer.moveStrafing = 0.0f;
            }
            if (Strafe.mc.thePlayer.onGround) {
                Strafe.mc.thePlayer.setJumping(false);
                if (lllllllllllllllllIIIIllllIIIIllI.waitCounter < 1) {
                    ++lllllllllllllllllIIIIllllIIIIllI.waitCounter;
                    return;
                }
                lllllllllllllllllIIIIllllIIIIllI.waitCounter = 0;
                float lllllllllllllllllIIIIllllIIIlllI = (float)Math.toRadians(lllllllllllllllllIIIIllllIIIIlll);
                Strafe.mc.thePlayer.motionY = 0.405;
                Strafe.mc.thePlayer.motionX -= (double)(MathHelper.sin((float)lllllllllllllllllIIIIllllIIIlllI) * 0.1f) * (double)lllllllllllllllllIIIIllllIIIIllI.forward;
                Strafe.mc.thePlayer.motionZ += (double)(MathHelper.cos((float)lllllllllllllllllIIIIllllIIIlllI) * 0.1f) * (double)lllllllllllllllllIIIIllllIIIIllI.forward;
            } else {
                double lllllllllllllllllIIIIllllIIIlIlI;
                if (lllllllllllllllllIIIIllllIIIIllI.waitCounter < 1) {
                    ++lllllllllllllllllIIIIllllIIIIllI.waitCounter;
                    return;
                }
                lllllllllllllllllIIIIllllIIIIllI.waitCounter = 0;
                double lllllllllllllllllIIIIllllIIIlIll = Math.sqrt(Strafe.mc.thePlayer.motionX * Strafe.mc.thePlayer.motionX + Strafe.mc.thePlayer.motionZ * Strafe.mc.thePlayer.motionZ);
                double d2 = lllllllllllllllllIIIIllllIIIlIlI = lllllllllllllllllIIIIllllIIIIIll ? 1.0064 : 1.001;
                if (Strafe.mc.thePlayer.motionY < 0.0) {
                    lllllllllllllllllIIIIllllIIIlIlI = 1.0;
                }
                double lllllllllllllllllIIIIllllIIIlIII = Math.toRadians(lllllllllllllllllIIIIllllIIIIlll);
                Strafe.mc.thePlayer.motionX = -Math.sin(lllllllllllllllllIIIIllllIIIlIII) * lllllllllllllllllIIIIllllIIIlIlI * lllllllllllllllllIIIIllllIIIlIll * (double)lllllllllllllllllIIIIllllIIIIllI.forward;
                Strafe.mc.thePlayer.motionZ = Math.cos(lllllllllllllllllIIIIllllIIIlIII) * lllllllllllllllllIIIIllllIIIlIlI * lllllllllllllllllIIIIllllIIIlIll * (double)lllllllllllllllllIIIIllllIIIIllI.forward;
            }
        }
    }

    public Strafe() {
        super("Strafe", Module.Category.MOVEMENT, "Cyri");
        Strafe lllllllllllllllllIIIIllllIlIlIIl;
        lllllllllllllllllIIIIllllIlIlIIl.forward = 1;
    }
}

