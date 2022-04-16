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
import me.axua.impactplus.module.modules.hud.Watermark;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class WatermarkComponent
extends HudComponent<Watermark> {
    /* synthetic */ int fort;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ HudColours mod;
    /* synthetic */ Minecraft mc;

    public WatermarkComponent() {
        super("Watermark", 2, 2, Watermark.INSTANCE);
        WatermarkComponent lIlllIllIIIIIlI;
        lIlllIllIIIIIlI.mc = Minecraft.getMinecraft();
        lIlllIllIIIIIlI.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lIlllIllIIIIIlI.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color lIlllIlIllllIll;
        WatermarkComponent lIlllIlIllllIIl;
        super.render();
        if (lIlllIlIllllIIl.mod.rainbow.getValue()) {
            Color lIlllIlIlllllIl = Rainbow.getColorWithOpacity(255);
        } else {
            lIlllIlIllllIll = new Color(lIlllIlIllllIIl.mod.red.getValue(), lIlllIlIllllIIl.mod.green.getValue(), lIlllIlIllllIIl.mod.blue.getValue(), 255);
        }
        String lIlllIlIllllIlI = String.valueOf(new StringBuilder().append("Impact+").append(ChatFormatting.getByName((String)lIlllIlIllllIIl.mod.color.getValue())).append(" 1.2.9"));
        lIlllIlIllllIIl.fort = lIlllIlIllllIIl.y < 1 ? 1 : lIlllIlIllllIIl.y;
        if (lIlllIlIllllIIl.fort > 355) {
            lIlllIlIllllIIl.fort = lIlllIlIllllIIl.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lIlllIlIllllIlI, lIlllIlIllllIIl.x, lIlllIlIllllIIl.y - 2, lIlllIlIllllIIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIlllIlIllllIIl.Rainbow1.GetRainbowColorAt(lIlllIlIllllIIl.fort) : lIlllIlIllllIll.getRGB());
            lIlllIlIllllIIl.width = (int)ImpactPlus.CustomFont.getStringWidth(lIlllIlIllllIlI) + 2;
        } else {
            lIlllIlIllllIIl.mc.fontRendererObj.drawStringWithShadow(lIlllIlIllllIlI, (float)lIlllIlIllllIIl.x, (float)lIlllIlIllllIIl.y, lIlllIlIllllIIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIlllIlIllllIIl.Rainbow1.GetRainbowColorAt(lIlllIlIllllIIl.fort) : lIlllIlIllllIll.getRGB());
            lIlllIlIllllIIl.width = lIlllIlIllllIIl.mc.fontRendererObj.getStringWidth(lIlllIlIllllIlI);
        }
    }
}

