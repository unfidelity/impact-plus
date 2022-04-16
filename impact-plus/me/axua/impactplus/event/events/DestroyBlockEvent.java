/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.util.math.BlockPos;

public class DestroyBlockEvent
extends ImpactPlusEvent {
    /* synthetic */ BlockPos pos;

    public BlockPos getBlockPos() {
        DestroyBlockEvent llIIIIlllIIlIlI;
        return llIIIIlllIIlIlI.pos;
    }

    public DestroyBlockEvent(BlockPos llIIIIlllIIlllI) {
        DestroyBlockEvent llIIIIlllIIllll;
        llIIIIlllIIllll.pos = llIIIIlllIIlllI;
    }
}

