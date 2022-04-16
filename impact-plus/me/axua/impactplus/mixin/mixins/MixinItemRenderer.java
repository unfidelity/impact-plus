/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.ItemRenderer
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.EventRenderUpdateEquippedItem;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.render.ViewModel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ItemRenderer.class})
public class MixinItemRenderer {
    @Inject(method={"updateEquippedItem"}, at={@At(value="HEAD")}, cancellable=true)
    public void updateEquippedItem(CallbackInfo llllllllllllllllIlIlIIlIlIlIlIII) {
        EventRenderUpdateEquippedItem llllllllllllllllIlIlIIlIlIlIIlll = new EventRenderUpdateEquippedItem();
        ImpactPlus.EVENT_BUS.post(llllllllllllllllIlIlIIlIlIlIIlll);
        if (llllllllllllllllIlIlIIlIlIlIIlll.isCancelled()) {
            llllllllllllllllIlIlIIlIlIlIlIII.cancel();
        }
    }

    @Inject(method={"renderItemInFirstPerson"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderItemInFirstPerson(CallbackInfo llllllllllllllllIlIlIIlIlIlIlllI) {
        ViewModel llllllllllllllllIlIlIIlIlIlIllIl = (ViewModel)ModuleManager.getModuleByName("ViewModel");
        if (llllllllllllllllIlIlIIlIlIlIllIl.isEnabled()) {
            GlStateManager.translate((double)0.0, (double)llllllllllllllllIlIlIIlIlIlIllIl.y.getValue(), (double)llllllllllllllllIlIlIIlIlIlIllIl.z.getValue());
        }
    }

    public MixinItemRenderer() {
        MixinItemRenderer llllllllllllllllIlIlIIlIlIllIIlI;
    }
}

