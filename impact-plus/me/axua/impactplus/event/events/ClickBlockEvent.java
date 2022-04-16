/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.ImpactPlus;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class ClickBlockEvent
extends ImpactPlus {
    private final /* synthetic */ EnumFacing facing;
    private final /* synthetic */ BlockPos pos;

    public ClickBlockEvent(BlockPos llllllllllllllllIIIIIllIlIlIIlII, EnumFacing llllllllllllllllIIIIIllIlIlIIIll) {
        ClickBlockEvent llllllllllllllllIIIIIllIlIlIIlIl;
        llllllllllllllllIIIIIllIlIlIIlIl.pos = llllllllllllllllIIIIIllIlIlIIlII;
        llllllllllllllllIIIIIllIlIlIIlIl.facing = llllllllllllllllIIIIIllIlIlIIIll;
    }

    public EnumFacing getFacing() {
        ClickBlockEvent llllllllllllllllIIIIIllIlIIllllI;
        return llllllllllllllllIIIIIllIlIIllllI.facing;
    }

    public BlockPos getPos() {
        ClickBlockEvent llllllllllllllllIIIIIllIlIlIIIIl;
        return llllllllllllllllIIIIIllIlIlIIIIl.pos;
    }
}

