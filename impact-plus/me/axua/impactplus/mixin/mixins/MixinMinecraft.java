/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.GuiScreenDisplayedEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class}, priority=9999)
public class MixinMinecraft {
    @Shadow
    public /* synthetic */ PlayerControllerMP playerController;
    @Shadow
    public /* synthetic */ EntityPlayerSP thePlayer;

    public MixinMinecraft() {
        MixinMinecraft llllllllllllllllllIIIlIIllIllllI;
    }

    @Inject(method={"displayGuiScreen"}, at={@At(value="HEAD")})
    private void displayGuiScreen(GuiScreen llllllllllllllllllIIIlIIllIIllIl, CallbackInfo llllllllllllllllllIIIlIIllIIllII) {
        GuiScreenDisplayedEvent llllllllllllllllllIIIlIIllIIlIll = new GuiScreenDisplayedEvent(llllllllllllllllllIIIlIIllIIllIl);
        ImpactPlus.EVENT_BUS.post(llllllllllllllllllIIIlIIllIIlIll);
    }
}

