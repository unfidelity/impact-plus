/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.MoverType
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.entity.MoverType;

public class PlayerMoveEvent
extends ImpactPlusEvent {
    public /* synthetic */ double z;
    public /* synthetic */ double y;
    public /* synthetic */ double x;
    /* synthetic */ MoverType type;

    public double getZ() {
        PlayerMoveEvent lllllIllIIIIIll;
        return lllllIllIIIIIll.z;
    }

    public void setZ(double lllllIlIlllIIlI) {
        lllllIlIlllIIIl.z = lllllIlIlllIIlI;
    }

    public double getX() {
        PlayerMoveEvent lllllIllIIIlIII;
        return lllllIllIIIlIII.x;
    }

    public void setY(double lllllIlIlllIllI) {
        lllllIlIllllIIl.y = lllllIlIlllIllI;
    }

    public MoverType getType() {
        PlayerMoveEvent lllllIllIIIllII;
        return lllllIllIIIllII.type;
    }

    public void setX(double lllllIlIlllllII) {
        lllllIlIlllllll.x = lllllIlIlllllII;
    }

    public double getY() {
        PlayerMoveEvent lllllIllIIIIllI;
        return lllllIllIIIIllI.y;
    }

    public PlayerMoveEvent(MoverType lllllIllIIlIllI, double lllllIllIIlIIII, double lllllIllIIIllll, double lllllIllIIlIIll) {
        PlayerMoveEvent lllllIllIIlIIlI;
        lllllIllIIlIIlI.type = lllllIllIIlIllI;
        lllllIllIIlIIlI.x = lllllIllIIlIIII;
        lllllIllIIlIIlI.y = lllllIllIIIllll;
        lllllIllIIlIIlI.z = lllllIllIIlIIll;
    }
}

