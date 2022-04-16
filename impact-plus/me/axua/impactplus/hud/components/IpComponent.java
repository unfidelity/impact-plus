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
import me.axua.impactplus.module.modules.hud.Ip;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class IpComponent
extends HudComponent<Ip> {
    /* synthetic */ int fort;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ HudColours mod;
    /* synthetic */ Minecraft mc;

    @Override
    public void render() {
        Color lllllllllllllllllIIllllllIIllIII;
        IpComponent lllllllllllllllllIIllllllIIlIlIl;
        super.render();
        if (lllllllllllllllllIIllllllIIlIlIl.mod.rainbow.getValue()) {
            Color lllllllllllllllllIIllllllIIllIlI = Rainbow.getColorWithOpacity(255);
        } else {
            lllllllllllllllllIIllllllIIllIII = new Color(lllllllllllllllllIIllllllIIlIlIl.mod.red.getValue(), lllllllllllllllllIIllllllIIlIlIl.mod.green.getValue(), lllllllllllllllllIIllllllIIlIlIl.mod.blue.getValue(), 255);
        }
        String lllllllllllllllllIIllllllIIlIlll = lllllllllllllllllIIllllllIIlIlIl.mc.getCurrentServerData() != null ? lllllllllllllllllIIllllllIIlIlIl.mc.getCurrentServerData().serverIP : "Singleplayer";
        String lllllllllllllllllIIllllllIIlIllI = String.valueOf(new StringBuilder().append("Ip ").append(ChatFormatting.getByName((String)lllllllllllllllllIIllllllIIlIlIl.mod.color.getValue())).append(lllllllllllllllllIIllllllIIlIlll));
        lllllllllllllllllIIllllllIIlIlIl.fort = lllllllllllllllllIIllllllIIlIlIl.y < 1 ? 1 : lllllllllllllllllIIllllllIIlIlIl.y;
        if (lllllllllllllllllIIllllllIIlIlIl.fort > 355) {
            lllllllllllllllllIIllllllIIlIlIl.fort = lllllllllllllllllIIllllllIIlIlIl.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lllllllllllllllllIIllllllIIlIllI, lllllllllllllllllIIllllllIIlIlIl.x, lllllllllllllllllIIllllllIIlIlIl.y - 2, lllllllllllllllllIIllllllIIlIlIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllllllllllllllllIIllllllIIlIlIl.Rainbow1.GetRainbowColorAt(lllllllllllllllllIIllllllIIlIlIl.fort) : lllllllllllllllllIIllllllIIllIII.getRGB());
            lllllllllllllllllIIllllllIIlIlIl.width = (int)ImpactPlus.CustomFont.getStringWidth(lllllllllllllllllIIllllllIIlIllI) + 2;
        } else {
            lllllllllllllllllIIllllllIIlIlIl.mc.fontRendererObj.drawStringWithShadow(lllllllllllllllllIIllllllIIlIllI, (float)lllllllllllllllllIIllllllIIlIlIl.x, (float)lllllllllllllllllIIllllllIIlIlIl.y, lllllllllllllllllIIllllllIIlIlIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllllllllllllllllIIllllllIIlIlIl.Rainbow1.GetRainbowColorAt(lllllllllllllllllIIllllllIIlIlIl.fort) : lllllllllllllllllIIllllllIIllIII.getRGB());
            lllllllllllllllllIIllllllIIlIlIl.width = lllllllllllllllllIIllllllIIlIlIl.mc.fontRendererObj.getStringWidth(lllllllllllllllllIIllllllIIlIllI);
        }
    }

    public IpComponent() {
        super("Ip", 2, 102, Ip.INSTANCE);
        IpComponent lllllllllllllllllIIllllllIlIIIII;
        lllllllllllllllllIIllllllIlIIIII.mc = Minecraft.getMinecraft();
        lllllllllllllllllIIllllllIlIIIII.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lllllllllllllllllIIllllllIlIIIII.Rainbow1 = Rainbow.getbruh();
    }
}

