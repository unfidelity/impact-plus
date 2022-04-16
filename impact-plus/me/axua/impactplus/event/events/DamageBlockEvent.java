/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class DamageBlockEvent
extends ImpactPlusEvent {
    private final /* synthetic */ BlockPos pos;
    private final /* synthetic */ EnumFacing facing;

    public EnumFacing getFacing() {
        DamageBlockEvent llllllllllllllllIlIlllIlllIlIllI;
        return llllllllllllllllIlIlllIlllIlIllI.facing;
    }

    public BlockPos getPos() {
        DamageBlockEvent llllllllllllllllIlIlllIlllIlllll;
        return llllllllllllllllIlIlllIlllIlllll.pos;
    }

    public DamageBlockEvent(BlockPos llllllllllllllllIlIlllIllllIlIIl, EnumFacing llllllllllllllllIlIlllIllllIlIII) {
        DamageBlockEvent llllllllllllllllIlIlllIllllIlIlI;
        llllllllllllllllIlIlllIllllIlIlI.pos = llllllllllllllllIlIlllIllllIlIIl;
        llllllllllllllllIlIlllIllllIlIlI.facing = llllllllllllllllIlIlllIllllIlIII;
    }
}

