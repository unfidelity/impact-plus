/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.EnumHand
 */
package me.axua.impactplus.module.modules.render;

import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventRenderUpdateEquippedItem;
import me.axua.impactplus.event.events.RenderModelEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHand;

public class ViewModel
extends Module {
    public /* synthetic */ Setting.d z;
    public /* synthetic */ Setting.d mainhandprogress;
    public /* synthetic */ Setting.d modelsize;
    public /* synthetic */ Setting.i rotatez;
    public /* synthetic */ Setting.d offhandprogress;
    public /* synthetic */ Setting.d y;
    public /* synthetic */ Setting.i rotate;
    public /* synthetic */ Setting.i rotatey;
    @EventHandler
    public /* synthetic */ Listener<EventRenderUpdateEquippedItem> OnUpdateEquippedItem;
    @EventHandler
    public /* synthetic */ Listener<RenderModelEvent> event;
    public /* synthetic */ Setting.b reset;
    public /* synthetic */ Setting.i rotatex;

    @Override
    public void setup() {
        ViewModel lIlIII;
        lIlIII.y = lIlIII.registerD("Y", 0.0, -1.0, 1.0);
        lIlIII.z = lIlIII.registerD("Z", 0.0, -2.0, 1.0);
        lIlIII.mainhandprogress = lIlIII.registerD("MainHandProgress", 1.0, 0.0, 1.0);
        lIlIII.offhandprogress = lIlIII.registerD("OffHandProgress", 1.0, 0.0, 1.0);
        lIlIII.modelsize = lIlIII.registerD("ModelSize", 1.0, 0.0, 5.0);
        lIlIII.rotate = lIlIII.registerI("Rotate", 0, 0, 360);
        lIlIII.rotatex = lIlIII.registerI("RotateX", 0, -50000, 50000);
        lIlIII.rotatey = lIlIII.registerI("RotateY", 0, -50000, 50000);
        lIlIII.rotatez = lIlIII.registerI("RotateZ", 0, -50000, 50000);
        lIlIII.reset = lIlIII.registerB("Reset", false);
    }

    @Override
    public void onUpdate() {
        ViewModel lIIllI;
        if (lIIllI.reset.getValue()) {
            lIIllI.y.setValue(0.0);
            lIIllI.z.setValue(0.0);
            lIIllI.mainhandprogress.setValue(1.0);
            lIIllI.offhandprogress.setValue(1.0);
            lIIllI.modelsize.setValue(1.0);
            lIIllI.rotate.setValue(0);
            lIIllI.rotatex.setValue(0);
            lIIllI.rotatey.setValue(0);
            lIIllI.rotatez.setValue(0);
            lIIllI.reset.setValue(false);
        }
        ViewModel.mc.entityRenderer.itemRenderer.field_187469_f = (float)lIIllI.mainhandprogress.getValue();
        ViewModel.mc.entityRenderer.itemRenderer.field_187471_h = (float)lIIllI.offhandprogress.getValue();
    }

    @Override
    public void onDisable() {
        ViewModel lIIIII;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lIIIII);
    }

    public ViewModel() {
        super("ViewModel", Module.Category.RENDER);
        ViewModel lIIIlIl;
        lIIIlIl.event = new Listener<RenderModelEvent>(llll -> {
            ViewModel llIl;
            GlStateManager.scale((double)llIl.modelsize.getValue(), (double)llIl.modelsize.getValue(), (double)llIl.modelsize.getValue());
            GlStateManager.rotate((float)llIl.rotate.getValue(), (float)llIl.rotatex.getValue(), (float)llIl.rotatey.getValue(), (float)llIl.rotatez.getValue());
        }, new Predicate[0]);
        lIIIlIl.OnUpdateEquippedItem = new Listener<EventRenderUpdateEquippedItem>(llIll -> {
            ViewModel.mc.entityRenderer.itemRenderer.field_187467_d = ViewModel.mc.thePlayer.func_184586_b(EnumHand.MAIN_HAND);
            ViewModel.mc.entityRenderer.itemRenderer.field_187468_e = ViewModel.mc.thePlayer.func_184586_b(EnumHand.OFF_HAND);
        }, new Predicate[0]);
    }

    @Override
    public void onEnable() {
        ViewModel lIIIll;
        ImpactPlus.EVENT_BUS.subscribe((Object)lIIIll);
    }
}

