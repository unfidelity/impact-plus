/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Welcome;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class WelcomeComponent
extends HudComponent<Welcome> {
    /* synthetic */ Minecraft mc;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ Welcome mod2;
    /* synthetic */ int fort;
    /* synthetic */ HudColours mod;

    public WelcomeComponent() {
        super("Welcome", 2, 12, Welcome.INSTANCE);
        WelcomeComponent llllllllllllllllIIlllIlllllIIlll;
        llllllllllllllllIIlllIlllllIIlll.mc = Minecraft.getMinecraft();
        llllllllllllllllIIlllIlllllIIlll.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIIlllIlllllIIlll.mod2 = (Welcome)ModuleManager.getModuleByName("Welcome");
        llllllllllllllllIIlllIlllllIIlll.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color llllllllllllllllIIlllIlllIllllII;
        WelcomeComponent llllllllllllllllIIlllIlllIlllIlI;
        super.render();
        if (llllllllllllllllIIlllIlllIlllIlI.mod.rainbow.getValue()) {
            Color llllllllllllllllIIlllIlllIlllllI = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIIlllIlllIllllII = new Color(llllllllllllllllIIlllIlllIlllIlI.mod.red.getValue(), llllllllllllllllIIlllIlllIlllIlI.mod.green.getValue(), llllllllllllllllIIlllIlllIlllIlI.mod.blue.getValue(), 255);
        }
        String llllllllllllllllIIlllIlllIlllIll = "";
        if (llllllllllllllllIIlllIlllIlllIlI.mod2.Mode.getValue().equalsIgnoreCase("Welcome1")) {
            llllllllllllllllIIlllIlllIlllIll = String.valueOf(new StringBuilder().append("Welcome, ").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIlllIlllIlI.mod.color.getValue())).append(llllllllllllllllIIlllIlllIlllIlI.mc.thePlayer.getName()));
        }
        if (llllllllllllllllIIlllIlllIlllIlI.mod2.Mode.getValue().equalsIgnoreCase("Welcome2")) {
            llllllllllllllllIIlllIlllIlllIll = String.valueOf(new StringBuilder().append("Welcome, ").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIlllIlllIlI.mod.color.getValue())).append(llllllllllllllllIIlllIlllIlllIlI.mc.thePlayer.getName()).append(ChatFormatting.RESET).append(" ^_^"));
        }
        if (llllllllllllllllIIlllIlllIlllIlI.mod2.Mode.getValue().equalsIgnoreCase("Hello1")) {
            llllllllllllllllIIlllIlllIlllIll = String.valueOf(new StringBuilder().append("Hello ").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIlllIlllIlI.mod.color.getValue())).append(llllllllllllllllIIlllIlllIlllIlI.mc.thePlayer.getName()));
        }
        if (llllllllllllllllIIlllIlllIlllIlI.mod2.Mode.getValue().equalsIgnoreCase("Hello2")) {
            llllllllllllllllIIlllIlllIlllIll = String.valueOf(new StringBuilder().append("Hello ").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIlllIlllIlI.mod.color.getValue())).append(llllllllllllllllIIlllIlllIlllIlI.mc.thePlayer.getName()).append(ChatFormatting.RESET).append(" ^_^"));
        }
        llllllllllllllllIIlllIlllIlllIlI.fort = llllllllllllllllIIlllIlllIlllIlI.y < 1 ? 1 : llllllllllllllllIIlllIlllIlllIlI.y;
        if (llllllllllllllllIIlllIlllIlllIlI.fort > 355) {
            llllllllllllllllIIlllIlllIlllIlI.fort = llllllllllllllllIIlllIlllIlllIlI.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIlllIlllIlllIll, llllllllllllllllIIlllIlllIlllIlI.x, llllllllllllllllIIlllIlllIlllIlI.y - 2, llllllllllllllllIIlllIlllIlllIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlllIlllIlllIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlllIlllIlllIlI.fort) : llllllllllllllllIIlllIlllIllllII.getRGB());
            llllllllllllllllIIlllIlllIlllIlI.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIIlllIlllIlllIll) + 2;
        } else {
            llllllllllllllllIIlllIlllIlllIlI.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIIlllIlllIlllIll, (float)llllllllllllllllIIlllIlllIlllIlI.x, (float)llllllllllllllllIIlllIlllIlllIlI.y, llllllllllllllllIIlllIlllIlllIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlllIlllIlllIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlllIlllIlllIlI.fort) : llllllllllllllllIIlllIlllIllllII.getRGB());
            llllllllllllllllIIlllIlllIlllIlI.width = llllllllllllllllIIlllIlllIlllIlI.mc.fontRendererObj.getStringWidth(llllllllllllllllIIlllIlllIlllIll);
        }
    }
}

