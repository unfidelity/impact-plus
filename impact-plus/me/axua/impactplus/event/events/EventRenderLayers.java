/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.entity.EntityLivingBase
 */
package me.axua.impactplus.event.events;

import me.zero.alpine.type.Cancellable;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class EventRenderLayers
extends Cancellable {
    private final /* synthetic */ EntityLivingBase entityLivingBase;
    private /* synthetic */ float HeadPitch;
    private final /* synthetic */ LayerRenderer layerRenderer;

    public EventRenderLayers(EntityLivingBase llIIIIlIIlIlIlI, LayerRenderer llIIIIlIIlIlIIl, float llIIIIlIIlIlIII) {
        EventRenderLayers llIIIIlIIlIIlll;
        llIIIIlIIlIIlll.entityLivingBase = llIIIIlIIlIlIlI;
        llIIIIlIIlIIlll.layerRenderer = llIIIIlIIlIlIIl;
        llIIIIlIIlIIlll.HeadPitch = llIIIIlIIlIlIII;
    }

    public float GetHeadPitch() {
        EventRenderLayers llIIIIlIIIllIll;
        return llIIIIlIIIllIll.HeadPitch;
    }

    public EntityLivingBase getEntityLivingBase() {
        EventRenderLayers llIIIIlIIlIIIlI;
        return llIIIIlIIlIIIlI.entityLivingBase;
    }

    public void SetHeadPitch(float llIIIIlIIIlIlll) {
        llIIIIlIIIlIllI.HeadPitch = llIIIIlIIIlIlll;
    }

    public LayerRenderer getLayerRenderer() {
        EventRenderLayers llIIIIlIIIlllll;
        return llIIIIlIIIlllll.layerRenderer;
    }
}

