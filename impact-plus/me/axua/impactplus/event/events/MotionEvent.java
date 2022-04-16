/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;

public class MotionEvent
extends ImpactPlusEvent {
    private /* synthetic */ double y;
    private /* synthetic */ double x;
    private /* synthetic */ double z;

    public double getY() {
        MotionEvent lllllllllllllllIllIllllIIllIIIIl;
        return lllllllllllllllIllIllllIIllIIIIl.y;
    }

    public double getZ() {
        MotionEvent lllllllllllllllIllIllllIIlIllIIl;
        return lllllllllllllllIllIllllIIlIllIIl.z;
    }

    public MotionEvent(double lllllllllllllllIllIllllIIlllIIll, double lllllllllllllllIllIllllIIlllIIlI, double lllllllllllllllIllIllllIIllIllIl) {
        MotionEvent lllllllllllllllIllIllllIIlllIlII;
        lllllllllllllllIllIllllIIlllIlII.x = lllllllllllllllIllIllllIIlllIIll;
        lllllllllllllllIllIllllIIlllIlII.y = lllllllllllllllIllIllllIIlllIIlI;
        lllllllllllllllIllIllllIIlllIlII.z = lllllllllllllllIllIllllIIllIllIl;
    }

    public void setY(double lllllllllllllllIllIllllIIlIllIll) {
        lllllllllllllllIllIllllIIlIlllII.y = lllllllllllllllIllIllllIIlIllIll;
    }

    public void setZ(double lllllllllllllllIllIllllIIlIlIlII) {
        lllllllllllllllIllIllllIIlIlIlIl.z = lllllllllllllllIllIllllIIlIlIlII;
    }

    public double getX() {
        MotionEvent lllllllllllllllIllIllllIIllIlIlI;
        return lllllllllllllllIllIllllIIllIlIlI.x;
    }

    public void setX(double lllllllllllllllIllIllllIIllIIlII) {
        lllllllllllllllIllIllllIIllIIlIl.x = lllllllllllllllIllIllllIIllIIlII;
    }
}

