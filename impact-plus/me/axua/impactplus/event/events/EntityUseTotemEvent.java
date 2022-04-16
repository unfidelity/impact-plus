/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.entity.Entity;

public class EntityUseTotemEvent
extends ImpactPlusEvent {
    private /* synthetic */ Entity entity;

    public EntityUseTotemEvent(Entity llllllllllllllllIlllIIllllIIIIIl) {
        EntityUseTotemEvent llllllllllllllllIlllIIllllIIIIlI;
        llllllllllllllllIlllIIllllIIIIlI.entity = llllllllllllllllIlllIIllllIIIIIl;
    }

    public Entity getEntity() {
        EntityUseTotemEvent llllllllllllllllIlllIIlllIllllII;
        return llllllllllllllllIlllIIlllIllllII.entity;
    }
}

