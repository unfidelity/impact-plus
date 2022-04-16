/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.layers.LayerArmorBase
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.inventory.EntityEquipmentSlot
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.render.ArmorEnchantColour;
import me.axua.impactplus.module.modules.render.NoRender;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LayerArmorBase.class}, priority=999999999)
public class MixinLayerArmorBase {
    @Inject(method={"renderArmorLayer"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderArmorLayer(EntityLivingBase llllllllllllllllIIllIlIlIIIllIII, float llllllllllllllllIIllIlIlIIIlIlll, float llllllllllllllllIIllIlIlIIIlIllI, float llllllllllllllllIIllIlIlIIIlIlIl, float llllllllllllllllIIllIlIlIIIlIlII, float llllllllllllllllIIllIlIlIIIlIIll, float llllllllllllllllIIllIlIlIIIlIIlI, float llllllllllllllllIIllIlIlIIIlIIIl, EntityEquipmentSlot llllllllllllllllIIllIlIlIIIlIIII, CallbackInfo llllllllllllllllIIllIlIlIIIIllll) {
        NoRender llllllllllllllllIIllIlIlIIIIlllI = (NoRender)ModuleManager.getModuleByName("NoRender");
        if (llllllllllllllllIIllIlIlIIIIlllI.isEnabled() && llllllllllllllllIIllIlIlIIIIlllI.armor.getValue()) {
            llllllllllllllllIIllIlIlIIIIllll.cancel();
        }
    }

    @Redirect(method={"renderEnchantedGlint"}, at=@At(value="INVOKE", target="net/minecraft/client/renderer/GlStateManager.color(FFFF)V"))
    private static void renderEnchantedGlint(float llllllllllllllllIIllIlIlIIlIIIII, float llllllllllllllllIIllIlIlIIlIIlII, float llllllllllllllllIIllIlIlIIIllllI, float llllllllllllllllIIllIlIlIIlIIIlI) {
        ArmorEnchantColour llllllllllllllllIIllIlIlIIlIIIIl = (ArmorEnchantColour)ModuleManager.getModuleByName("ArmorEnchantColour");
        if (ModuleManager.isModuleEnabled("ArmorEnchantColour")) {
            llllllllllllllllIIllIlIlIIlIIIII = (float)llllllllllllllllIIllIlIlIIlIIIIl.r.getValue();
            llllllllllllllllIIllIlIlIIlIIlII = (float)llllllllllllllllIIllIlIlIIlIIIIl.g.getValue();
            llllllllllllllllIIllIlIlIIIllllI = (float)llllllllllllllllIIllIlIlIIlIIIIl.b.getValue();
            llllllllllllllllIIllIlIlIIlIIIlI = 255.0f;
        }
        GlStateManager.color((float)llllllllllllllllIIllIlIlIIlIIIII, (float)llllllllllllllllIIllIlIlIIlIIlII, (float)llllllllllllllllIIllIlIlIIIllllI, (float)llllllllllllllllIIllIlIlIIlIIIlI);
    }

    public MixinLayerArmorBase() {
        MixinLayerArmorBase llllllllllllllllIIllIlIlIIlIllII;
    }
}

