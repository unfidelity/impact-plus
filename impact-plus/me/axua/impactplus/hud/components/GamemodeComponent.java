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
import me.axua.impactplus.module.modules.hud.Gamemode;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class GamemodeComponent
extends HudComponent<Gamemode> {
    /* synthetic */ int fort;
    /* synthetic */ Minecraft mc;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ HudColours mod;

    @Override
    public void render() {
        Color lIllIIIlIlllIIl;
        GamemodeComponent lIllIIIlIlllIlI;
        super.render();
        if (lIllIIIlIlllIlI.mod.rainbow.getValue()) {
            Color lIllIIIlIlllIll = Rainbow.getColorWithOpacity(255);
        } else {
            lIllIIIlIlllIIl = new Color(lIllIIIlIlllIlI.mod.red.getValue(), lIllIIIlIlllIlI.mod.green.getValue(), lIllIIIlIlllIlI.mod.blue.getValue(), 255);
        }
        String lIllIIIlIlllIII = lIllIIIlIlllIlI.mc.playerController.getCurrentGameType().getName();
        String lIllIIIlIllIlll = String.valueOf(new StringBuilder().append(lIllIIIlIlllIII.substring(0, 1).toUpperCase()).append(lIllIIIlIlllIII.substring(1)));
        String lIllIIIlIllIllI = String.valueOf(new StringBuilder().append("Gamemode ").append(ChatFormatting.getByName((String)lIllIIIlIlllIlI.mod.color.getValue())).append(lIllIIIlIllIlll));
        lIllIIIlIlllIlI.fort = lIllIIIlIlllIlI.y < 1 ? 1 : lIllIIIlIlllIlI.y;
        if (lIllIIIlIlllIlI.fort > 355) {
            lIllIIIlIlllIlI.fort = lIllIIIlIlllIlI.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lIllIIIlIllIllI, lIllIIIlIlllIlI.x, lIllIIIlIlllIlI.y - 2, lIllIIIlIlllIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIllIIIlIlllIlI.Rainbow1.GetRainbowColorAt(lIllIIIlIlllIlI.fort) : lIllIIIlIlllIIl.getRGB());
            lIllIIIlIlllIlI.width = (int)ImpactPlus.CustomFont.getStringWidth(lIllIIIlIllIllI) + 2;
        } else {
            lIllIIIlIlllIlI.mc.fontRendererObj.drawStringWithShadow(lIllIIIlIllIllI, (float)lIllIIIlIlllIlI.x, (float)lIllIIIlIlllIlI.y, lIllIIIlIlllIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIllIIIlIlllIlI.Rainbow1.GetRainbowColorAt(lIllIIIlIlllIlI.fort) : lIllIIIlIlllIIl.getRGB());
            lIllIIIlIlllIlI.width = lIllIIIlIlllIlI.mc.fontRendererObj.getStringWidth(lIllIIIlIllIllI);
        }
    }

    public GamemodeComponent() {
        super("Gamemode", 2, 132, Gamemode.INSTANCE);
        GamemodeComponent lIllIIIllIIIIlI;
        lIllIIIllIIIIlI.mc = Minecraft.getMinecraft();
        lIllIIIllIIIIlI.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lIllIIIllIIIIlI.Rainbow1 = Rainbow.getbruh();
    }
}

