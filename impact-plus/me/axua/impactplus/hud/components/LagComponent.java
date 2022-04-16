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
import me.axua.impactplus.hudgui.HudGui;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Lag;
import me.axua.impactplus.util.MathUtil;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class LagComponent
extends HudComponent<Lag> {
    /* synthetic */ Minecraft mc;
    /* synthetic */ HudColours mod;
    /* synthetic */ int fort;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ Lag mod2;
    /* synthetic */ String text;

    private double timeDifference() {
        LagComponent llllllllllllllllIIIIllllIlIIlIIl;
        return MathUtil.round((double)(System.currentTimeMillis() - llllllllllllllllIIIIllllIlIIlIIl.mod2.bruhserver()) / 1000.0, 1);
    }

    @Override
    public void render() {
        Color llllllllllllllllIIIIllllIlIIlllI;
        LagComponent llllllllllllllllIIIIllllIlIIllll;
        super.render();
        if (llllllllllllllllIIIIllllIlIIllll.mod.rainbow.getValue()) {
            Color llllllllllllllllIIIIllllIlIlIIII = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIIIIllllIlIIlllI = new Color(llllllllllllllllIIIIllllIlIIllll.mod.red.getValue(), llllllllllllllllIIIIllllIlIIllll.mod.green.getValue(), llllllllllllllllIIIIllllIlIIllll.mod.blue.getValue(), 255);
        }
        llllllllllllllllIIIIllllIlIIllll.text = 1000L <= System.currentTimeMillis() - llllllllllllllllIIIIllllIlIIllll.mod2.bruhserver() ? String.valueOf(new StringBuilder().append("Server not responding ").append(ChatFormatting.getByName((String)llllllllllllllllIIIIllllIlIIllll.mod.color.getValue())).append(llllllllllllllllIIIIllllIlIIllll.timeDifference()).append("s")) : (llllllllllllllllIIIIllllIlIIllll.mc.currentScreen instanceof HudGui ? String.valueOf(new StringBuilder().append("Server not responding ").append(ChatFormatting.getByName((String)llllllllllllllllIIIIllllIlIIllll.mod.color.getValue())).append(" X.Xs")) : "");
        llllllllllllllllIIIIllllIlIIllll.fort = llllllllllllllllIIIIllllIlIIllll.y < 1 ? 1 : llllllllllllllllIIIIllllIlIIllll.y;
        if (llllllllllllllllIIIIllllIlIIllll.fort > 355) {
            llllllllllllllllIIIIllllIlIIllll.fort = llllllllllllllllIIIIllllIlIIllll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIIIllllIlIIllll.text, llllllllllllllllIIIIllllIlIIllll.x, llllllllllllllllIIIIllllIlIIllll.y - 2, llllllllllllllllIIIIllllIlIIllll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIIIllllIlIIllll.Rainbow1.GetRainbowColorAt(llllllllllllllllIIIIllllIlIIllll.fort) : llllllllllllllllIIIIllllIlIIlllI.getRGB());
            if (0L <= System.currentTimeMillis() - llllllllllllllllIIIIllllIlIIllll.mod2.bruhserver()) {
                llllllllllllllllIIIIllllIlIIllll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIIIIllllIlIIllll.text) + 2;
            }
        } else {
            llllllllllllllllIIIIllllIlIIllll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIIIIllllIlIIllll.text, (float)llllllllllllllllIIIIllllIlIIllll.x, (float)llllllllllllllllIIIIllllIlIIllll.y, llllllllllllllllIIIIllllIlIIllll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIIIllllIlIIllll.Rainbow1.GetRainbowColorAt(llllllllllllllllIIIIllllIlIIllll.fort) : llllllllllllllllIIIIllllIlIIlllI.getRGB());
            if (0L <= System.currentTimeMillis() - llllllllllllllllIIIIllllIlIIllll.mod2.bruhserver()) {
                llllllllllllllllIIIIllllIlIIllll.width = llllllllllllllllIIIIllllIlIIllll.mc.fontRendererObj.getStringWidth(llllllllllllllllIIIIllllIlIIllll.text);
            }
        }
    }

    public LagComponent() {
        super("Lag", 428, 2, Lag.INSTANCE);
        LagComponent llllllllllllllllIIIIllllIlIlIlII;
        llllllllllllllllIIIIllllIlIlIlII.mc = Minecraft.getMinecraft();
        llllllllllllllllIIIIllllIlIlIlII.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIIIIllllIlIlIlII.mod2 = (Lag)ModuleManager.getModuleByName("Lag");
        llllllllllllllllIIIIllllIlIlIlII.Rainbow1 = Rainbow.getbruh();
    }
}

