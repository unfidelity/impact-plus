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
import me.axua.impactplus.module.modules.hud.Ping;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class PingComponent
extends HudComponent<Ping> {
    /* synthetic */ int fort;
    /* synthetic */ Ping mod2;
    /* synthetic */ Minecraft mc;
    /* synthetic */ HudColours mod;
    private /* synthetic */ SalRainbowUtil Rainbow1;

    @Override
    public void render() {
        Color lIllIlIIlIlIII;
        PingComponent lIllIlIIlIIllI;
        super.render();
        if (lIllIlIIlIIllI.mod.rainbow.getValue()) {
            Color lIllIlIIlIlIlI = Rainbow.getColorWithOpacity(255);
        } else {
            lIllIlIIlIlIII = new Color(lIllIlIIlIIllI.mod.red.getValue(), lIllIlIIlIIllI.mod.green.getValue(), lIllIlIIlIIllI.mod.blue.getValue(), 255);
        }
        String lIllIlIIlIIlll = String.valueOf(new StringBuilder().append("Ping ").append(ChatFormatting.getByName((String)lIllIlIIlIIllI.mod.color.getValue())).append(lIllIlIIlIIllI.mod2.getPing()).append("ms"));
        lIllIlIIlIIllI.fort = lIllIlIIlIIllI.y < 1 ? 1 : lIllIlIIlIIllI.y;
        if (lIllIlIIlIIllI.fort > 355) {
            lIllIlIIlIIllI.fort = lIllIlIIlIIllI.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lIllIlIIlIIlll, lIllIlIIlIIllI.x, lIllIlIIlIIllI.y - 2, lIllIlIIlIIllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIllIlIIlIIllI.Rainbow1.GetRainbowColorAt(lIllIlIIlIIllI.fort) : lIllIlIIlIlIII.getRGB());
            lIllIlIIlIIllI.width = (int)ImpactPlus.CustomFont.getStringWidth(lIllIlIIlIIlll) + 2;
        } else {
            lIllIlIIlIIllI.mc.fontRendererObj.drawStringWithShadow(lIllIlIIlIIlll, (float)lIllIlIIlIIllI.x, (float)lIllIlIIlIIllI.y, lIllIlIIlIIllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIllIlIIlIIllI.Rainbow1.GetRainbowColorAt(lIllIlIIlIIllI.fort) : lIllIlIIlIlIII.getRGB());
            lIllIlIIlIIllI.width = lIllIlIIlIIllI.mc.fontRendererObj.getStringWidth(lIllIlIIlIIlll);
        }
    }

    public PingComponent() {
        super("Ping", 2, 62, Ping.INSTANCE);
        PingComponent lIllIlIIlIllll;
        lIllIlIIlIllll.mc = Minecraft.getMinecraft();
        lIllIlIIlIllll.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lIllIlIIlIllll.mod2 = (Ping)ModuleManager.getModuleByName("Ping");
        lIllIlIIlIllll.Rainbow1 = Rainbow.getbruh();
    }
}

