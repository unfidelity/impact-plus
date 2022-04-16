/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraft.client.gui.GuiScreen
 */
package me.axua.impactplus.mixin.mixins;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiGameOver.class})
public class MixinGuiGameOver
extends GuiScreen {
    @Inject(method={"drawScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void drawScreen(int lllllllllllllllllIIIlIlllIIllIII, int lllllllllllllllllIIIlIlllIIlIlll, float lllllllllllllllllIIIlIlllIIlIllI, CallbackInfo lllllllllllllllllIIIlIlllIIlIlIl) {
    }

    public MixinGuiGameOver() {
        MixinGuiGameOver lllllllllllllllllIIIlIlllIIlllll;
    }

    @Inject(method={"initGui"}, at={@At(value="TAIL")}, cancellable=true)
    public void initGui(CallbackInfo lllllllllllllllllIIIlIlllIIlllIl) {
    }

    @Inject(method={"actionPerformed"}, at={@At(value="HEAD")}, cancellable=true)
    public void actionPerformed(GuiButton lllllllllllllllllIIIlIlllIIllIll, CallbackInfo lllllllllllllllllIIIlIlllIIllIlI) {
    }
}

