/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.RenderModelEvent;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderItem.class})
public abstract class MixinRenderItem {
    @Inject(method={"renderItemModel"}, at={@At(value="HEAD")}, cancellable=true)
    public void onRenderModel(ItemStack llllllllllllllllIllIIIIlIlllIIIl, IBakedModel llllllllllllllllIllIIIIlIlllIIII, ItemCameraTransforms.TransformType llllllllllllllllIllIIIIlIllIllll, boolean llllllllllllllllIllIIIIlIllIlllI, CallbackInfo llllllllllllllllIllIIIIlIllIllII) {
        RenderModelEvent llllllllllllllllIllIIIIlIllIlIll = new RenderModelEvent();
        ImpactPlus.EVENT_BUS.post(llllllllllllllllIllIIIIlIllIlIll);
    }

    public MixinRenderItem() {
        MixinRenderItem llllllllllllllllIllIIIIlIlllIlIl;
    }
}

