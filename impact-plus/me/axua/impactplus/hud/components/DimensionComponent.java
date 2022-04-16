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
import me.axua.impactplus.module.modules.hud.Dimension;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class DimensionComponent
extends HudComponent<Dimension> {
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ int fort;
    /* synthetic */ HudColours mod;
    /* synthetic */ Minecraft mc;

    public DimensionComponent() {
        super("Dimension", 2, 122, Dimension.INSTANCE);
        DimensionComponent llllllllllllllllIlIlIIllllIlIIIl;
        llllllllllllllllIlIlIIllllIlIIIl.mc = Minecraft.getMinecraft();
        llllllllllllllllIlIlIIllllIlIIIl.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIlIlIIllllIlIIIl.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color llllllllllllllllIlIlIIllllIIlIlI;
        DimensionComponent llllllllllllllllIlIlIIllllIIlIll;
        super.render();
        if (llllllllllllllllIlIlIIllllIIlIll.mod.rainbow.getValue()) {
            Color llllllllllllllllIlIlIIllllIIllII = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIlIlIIllllIIlIlI = new Color(llllllllllllllllIlIlIIllllIIlIll.mod.red.getValue(), llllllllllllllllIlIlIIllllIIlIll.mod.green.getValue(), llllllllllllllllIlIlIIllllIIlIll.mod.blue.getValue(), 255);
        }
        int llllllllllllllllIlIlIIllllIIlIIl = llllllllllllllllIlIlIIllllIIlIll.mc.thePlayer.dimension;
        String llllllllllllllllIlIlIIllllIIlIII = "";
        if (llllllllllllllllIlIlIIllllIIlIIl == 0) {
            llllllllllllllllIlIlIIllllIIlIII = String.valueOf(new StringBuilder().append("Dimension ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlIIllllIIlIll.mod.color.getValue())).append("Overworld"));
        } else if (llllllllllllllllIlIlIIllllIIlIIl == -1) {
            llllllllllllllllIlIlIIllllIIlIII = String.valueOf(new StringBuilder().append("Dimension ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlIIllllIIlIll.mod.color.getValue())).append("Nether"));
        } else if (llllllllllllllllIlIlIIllllIIlIIl == 1) {
            llllllllllllllllIlIlIIllllIIlIII = String.valueOf(new StringBuilder().append("Dimension ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlIIllllIIlIll.mod.color.getValue())).append("End"));
        }
        llllllllllllllllIlIlIIllllIIlIll.fort = llllllllllllllllIlIlIIllllIIlIll.y < 1 ? 1 : llllllllllllllllIlIlIIllllIIlIll.y;
        if (llllllllllllllllIlIlIIllllIIlIll.fort > 355) {
            llllllllllllllllIlIlIIllllIIlIll.fort = llllllllllllllllIlIlIIllllIIlIll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIlIlIIllllIIlIII, llllllllllllllllIlIlIIllllIIlIll.x, llllllllllllllllIlIlIIllllIIlIll.y - 2, llllllllllllllllIlIlIIllllIIlIll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlIIllllIIlIll.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlIIllllIIlIll.fort) : llllllllllllllllIlIlIIllllIIlIlI.getRGB());
            llllllllllllllllIlIlIIllllIIlIll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIlIlIIllllIIlIII) + 2;
        } else {
            llllllllllllllllIlIlIIllllIIlIll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIlIIllllIIlIII, (float)llllllllllllllllIlIlIIllllIIlIll.x, (float)llllllllllllllllIlIlIIllllIIlIll.y, llllllllllllllllIlIlIIllllIIlIll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlIIllllIIlIll.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlIIllllIIlIll.fort) : llllllllllllllllIlIlIIllllIIlIlI.getRGB());
            llllllllllllllllIlIlIIllllIIlIll.width = llllllllllllllllIlIlIIllllIIlIll.mc.fontRendererObj.getStringWidth(llllllllllllllllIlIlIIllllIIlIII);
        }
    }
}

