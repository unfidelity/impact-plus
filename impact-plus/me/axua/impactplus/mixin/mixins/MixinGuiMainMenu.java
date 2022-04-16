/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiScreen
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiMainMenu.class})
public class MixinGuiMainMenu
extends GuiScreen {
    @Shadow
    private /* synthetic */ String splashText;

    public MixinGuiMainMenu() {
        MixinGuiMainMenu lllllllIIlIllII;
    }

    @Inject(method={"drawScreen"}, at={@At(value="TAIL")}, cancellable=true)
    public void drawText(CallbackInfo lllllllIIlIlIIl) {
        ImpactPlus.CustomFont.drawStringWithShadow("Impact+ 1.2.9", 2.0f, 0.0f, -11184641);
    }

    @Inject(method={"Lnet/minecraft/client/gui/GuiMainMenu;<init>()V"}, at={@At(value="RETURN")})
    public void postConstructor(CallbackInfo lllllllIIlIIllI) {
        lllllllIIlIIlIl.splashText = "Axua owns me and all";
    }
}

