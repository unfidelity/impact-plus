/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.Vec3d;

public class RenderEvent
extends ImpactPlusEvent {
    private final /* synthetic */ Vec3d renderPos;
    private final /* synthetic */ float partialTicks;
    private final /* synthetic */ Tessellator tessellator;

    public BufferBuilder getBuffer() {
        RenderEvent llIIIlIIIlllIlI;
        return llIIIlIIIlllIlI.tessellator.getWorldRenderer();
    }

    public void setTranslation(Vec3d llIIIlIIIIIlIll) {
        RenderEvent llIIIlIIIIIllIl;
        llIIIlIIIIIllIl.getBuffer().setTranslation(-llIIIlIIIIIlIll.xCoord, -llIIIlIIIIIlIll.yCoord, -llIIIlIIIIIlIll.zCoord);
    }

    public Tessellator getTessellator() {
        RenderEvent llIIIlIIIllllIl;
        return llIIIlIIIllllIl.tessellator;
    }

    public RenderEvent(Tessellator llIIIlIIlIIIlIl, Vec3d llIIIlIIlIIIlII, float llIIIlIIIllllll) {
        RenderEvent llIIIlIIlIIIIlI;
        llIIIlIIlIIIIlI.tessellator = llIIIlIIlIIIlIl;
        llIIIlIIlIIIIlI.renderPos = llIIIlIIlIIIlII;
        llIIIlIIlIIIIlI.partialTicks = llIIIlIIIllllll;
    }

    public Vec3d getRenderPos() {
        RenderEvent llIIIlIIIlIlIll;
        return llIIIlIIIlIlIll.renderPos;
    }

    public void resetTranslation() {
        RenderEvent llIIIIllllllIlI;
        llIIIIllllllIlI.setTranslation(llIIIIllllllIlI.renderPos);
    }

    @Override
    public float getPartialTicks() {
        RenderEvent llIIIIlllllIIIl;
        return llIIIIlllllIIIl.partialTicks;
    }
}

