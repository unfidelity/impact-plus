/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiIngameMenu
 *  net.minecraft.client.gui.GuiScreen
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.misc.AntiDisconnect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiIngameMenu.class})
public class MixinGuiIngameMenu {
    public MixinGuiIngameMenu() {
        MixinGuiIngameMenu llllllllllllllllIlllllIllIlIllll;
    }

    @Inject(method={"actionPerformed"}, at={@At(value="HEAD")}, cancellable=true)
    public void actionPerformed(GuiButton llllllllllllllllIlllllIlIlIIIIIl, CallbackInfo llllllllllllllllIlllllIlIIlllIll) {
        if (llllllllllllllllIlllllIlIlIIIIIl.id == 1 && ModuleManager.isModuleEnabled("AntiDisconnect")) {
            String llllllllllllllllIlllllIlIlIIllll;
            AntiDisconnect llllllllllllllllIlllllIlIlIlIllI = (AntiDisconnect)ModuleManager.getModuleByName("AntiDisconnect");
            Minecraft llllllllllllllllIlllllIlIlIlIIlI = Minecraft.getMinecraft();
            String string = llllllllllllllllIlllllIlIlIIllll = llllllllllllllllIlllllIlIlIlIIlI.getCurrentServerData() != null ? llllllllllllllllIlllllIlIlIlIIlI.getCurrentServerData().serverIP : "Singleplayer";
            if (llllllllllllllllIlllllIlIlIlIllI.Only2b2t.getValue() && !llllllllllllllllIlllllIlIlIIllll.equalsIgnoreCase("2b2t.org")) {
                return;
            }
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)ImpactPlus.getInstance().antiDisconnect);
            llllllllllllllllIlllllIlIIlllIll.cancel();
        }
    }
}

