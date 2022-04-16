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
import java.text.DecimalFormat;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Coords;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class CoordsComponent
extends HudComponent<Coords> {
    /* synthetic */ Minecraft mc;
    /* synthetic */ HudColours mod;
    /* synthetic */ Coords mod2;
    /* synthetic */ int fort;
    private /* synthetic */ SalRainbowUtil Rainbow1;

    @Override
    public void render() {
        Color llllllllllllllllIlIIIlIlIlllIlIl;
        CoordsComponent llllllllllllllllIlIIIlIlIlllIlII;
        super.render();
        if (llllllllllllllllIlIIIlIlIlllIlII.mod.rainbow.getValue()) {
            Color llllllllllllllllIlIIIlIllIIIlIII = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIlIIIlIlIlllIlIl = new Color(llllllllllllllllIlIIIlIlIlllIlII.mod.red.getValue(), llllllllllllllllIlIIIlIlIlllIlII.mod.green.getValue(), llllllllllllllllIlIIIlIlIlllIlII.mod.blue.getValue(), 255);
        }
        llllllllllllllllIlIIIlIlIlllIlII.fort = llllllllllllllllIlIIIlIlIlllIlII.y < 1 ? 1 : llllllllllllllllIlIIIlIlIlllIlII.y;
        if (llllllllllllllllIlIIIlIlIlllIlII.fort > 355) {
            llllllllllllllllIlIIIlIlIlllIlII.fort = llllllllllllllllIlIIIlIlIlllIlII.y - 355;
        }
        if (llllllllllllllllIlIIIlIlIlllIlII.mod2.Mode.getValue().equalsIgnoreCase("Single")) {
            if (ClickGuiModule.customfont.getValue()) {
                ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetSingle(), llllllllllllllllIlIIIlIlIlllIlII.x, llllllllllllllllIlIIIlIlIlllIlII.y - 2, llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                llllllllllllllllIlIIIlIlIlllIlII.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIlIIIlIlIlllIlII.GetSingle()) + 2;
            } else {
                llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetSingle(), (float)llllllllllllllllIlIIIlIlIlllIlII.x, (float)llllllllllllllllIlIIIlIlIlllIlII.y, llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                llllllllllllllllIlIIIlIlIlllIlII.width = llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.getStringWidth(llllllllllllllllIlIIIlIlIlllIlII.GetSingle());
            }
            llllllllllllllllIlIIIlIlIlllIlII.height = 9;
        } else {
            if (ClickGuiModule.customfont.getValue()) {
                ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetStackx(), llllllllllllllllIlIIIlIlIlllIlII.x, llllllllllllllllIlIIIlIlIlllIlII.y - 2, llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetStacky(), llllllllllllllllIlIIIlIlIlllIlII.x, llllllllllllllllIlIIIlIlIlllIlII.y - 2 + 10, llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort + 10) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetStackz(), llllllllllllllllIlIIIlIlIlllIlII.x, llllllllllllllllIlIIIlIlIlllIlII.y - 2 + 20, llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort + 20) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                double llllllllllllllllIlIIIlIllIIIIllI = ImpactPlus.CustomFont.getStringWidth(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIIlIlIlllIlII.GetStackx()).append(2)));
                double llllllllllllllllIlIIIlIllIIIIlIl = ImpactPlus.CustomFont.getStringWidth(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIIlIlIlllIlII.GetStacky()).append(2)));
                double llllllllllllllllIlIIIlIllIIIIIll = ImpactPlus.CustomFont.getStringWidth(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIIlIlIlllIlII.GetStackz()).append(2)));
                double llllllllllllllllIlIIIlIllIIIIIIl = Math.max(llllllllllllllllIlIIIlIllIIIIllI, llllllllllllllllIlIIIlIllIIIIlIl);
                double llllllllllllllllIlIIIlIlIlllllll = Math.max(llllllllllllllllIlIIIlIllIIIIIll, llllllllllllllllIlIIIlIllIIIIIIl);
                llllllllllllllllIlIIIlIlIlllIlII.width = (int)llllllllllllllllIlIIIlIlIlllllll;
            } else {
                llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetStackx(), (float)llllllllllllllllIlIIIlIlIlllIlII.x, (float)llllllllllllllllIlIIIlIlIlllIlII.y, llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetStacky(), (float)llllllllllllllllIlIIIlIlIlllIlII.x, (float)(llllllllllllllllIlIIIlIlIlllIlII.y + 10), llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort + 10) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIIlIlIlllIlII.GetStackz(), (float)llllllllllllllllIlIIIlIlIlllIlII.x, (float)(llllllllllllllllIlIIIlIlIlllIlII.y + 20), llllllllllllllllIlIIIlIlIlllIlII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIIIlIlIlllIlII.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIIIlIlIlllIlII.fort + 20) : llllllllllllllllIlIIIlIlIlllIlIl.getRGB());
                double llllllllllllllllIlIIIlIlIllllllI = llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.getStringWidth(llllllllllllllllIlIIIlIlIlllIlII.GetStackx());
                double llllllllllllllllIlIIIlIlIlllllIl = llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.getStringWidth(llllllllllllllllIlIIIlIlIlllIlII.GetStacky());
                double llllllllllllllllIlIIIlIlIllllIll = llllllllllllllllIlIIIlIlIlllIlII.mc.fontRendererObj.getStringWidth(llllllllllllllllIlIIIlIlIlllIlII.GetStackz());
                double llllllllllllllllIlIIIlIlIllllIIl = Math.max(llllllllllllllllIlIIIlIlIllllllI, llllllllllllllllIlIIIlIlIlllllIl);
                double llllllllllllllllIlIIIlIlIlllIlll = Math.max(llllllllllllllllIlIIIlIlIllllIll, llllllllllllllllIlIIIlIlIllllIIl);
                llllllllllllllllIlIIIlIlIlllIlII.width = (int)llllllllllllllllIlIIIlIlIlllIlll;
            }
            llllllllllllllllIlIIIlIlIlllIlII.height = 27;
        }
    }

    public CoordsComponent() {
        super("Coords", 2, 478, Coords.INSTANCE);
        CoordsComponent llllllllllllllllIlIIIlIlllIIIlll;
        llllllllllllllllIlIIIlIlllIIIlll.mc = Minecraft.getMinecraft();
        llllllllllllllllIlIIIlIlllIIIlll.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIlIIIlIlllIIIlll.mod2 = (Coords)ModuleManager.getModuleByName("Coords");
        llllllllllllllllIlIIIlIlllIIIlll.Rainbow1 = Rainbow.getbruh();
    }

    private String GetStackz() {
        CoordsComponent llllllllllllllllIlIIIlIIllIIllll;
        DecimalFormat llllllllllllllllIlIIIlIIllIlIlII = new DecimalFormat("0");
        String llllllllllllllllIlIIIlIIllIlIIll = "";
        String llllllllllllllllIlIIIlIIllIlIIIl = llllllllllllllllIlIIIlIIllIlIlII.format(llllllllllllllllIlIIIlIIllIIllll.mc.thePlayer.posZ);
        if (llllllllllllllllIlIIIlIIllIIllll.mc.thePlayer.dimension == -1) {
            String llllllllllllllllIlIIIlIIllIlIlll = llllllllllllllllIlIIIlIIllIlIlII.format(llllllllllllllllIlIIIlIIllIIllll.mc.thePlayer.posZ * 8.0);
            llllllllllllllllIlIIIlIIllIlIIll = String.valueOf(new StringBuilder().append("Z ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIIllIIllll.mod.color.getValue())).append(llllllllllllllllIlIIIlIIllIlIIIl).append(ChatFormatting.RESET).append(" [").append(ChatFormatting.RESET).append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIIllIIllll.mod.color.getValue())).append(llllllllllllllllIlIIIlIIllIlIlll).append(ChatFormatting.RESET).append("]"));
        } else {
            String llllllllllllllllIlIIIlIIllIlIllI = llllllllllllllllIlIIIlIIllIlIlII.format(llllllllllllllllIlIIIlIIllIIllll.mc.thePlayer.posZ / 8.0);
            llllllllllllllllIlIIIlIIllIlIIll = String.valueOf(new StringBuilder().append("Z ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIIllIIllll.mod.color.getValue())).append(llllllllllllllllIlIIIlIIllIlIIIl).append(ChatFormatting.RESET).append(" [").append(ChatFormatting.RESET).append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIIllIIllll.mod.color.getValue())).append(llllllllllllllllIlIIIlIIllIlIllI).append(ChatFormatting.RESET).append("]"));
        }
        return llllllllllllllllIlIIIlIIllIlIIll;
    }

    private String GetSingle() {
        String llllllllllllllllIlIIIlIlIIllIllI;
        CoordsComponent llllllllllllllllIlIIIlIlIIllIlII;
        DecimalFormat llllllllllllllllIlIIIlIlIIlllllI = new DecimalFormat("0");
        String llllllllllllllllIlIIIlIlIIllllII = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posX);
        String llllllllllllllllIlIIIlIlIIlllIlI = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posY);
        String llllllllllllllllIlIIIlIlIIlllIII = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posZ);
        if (llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.dimension == -1) {
            String llllllllllllllllIlIIIlIlIlIIlIlI = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posX * 8.0);
            String llllllllllllllllIlIIIlIlIlIIlIII = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posZ * 8.0);
            String llllllllllllllllIlIIIlIlIlIIIllI = String.valueOf(new StringBuilder().append("XYZ ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIllIlII.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIIllllII).append(", ").append(llllllllllllllllIlIIIlIlIIlllIlI).append(", ").append(llllllllllllllllIlIIIlIlIIlllIII).append(ChatFormatting.RESET).append(" [").append(ChatFormatting.RESET).append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIllIlII.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIlIIlIlI).append(", ").append(llllllllllllllllIlIIIlIlIlIIlIII).append(ChatFormatting.RESET).append("]"));
        } else {
            String llllllllllllllllIlIIIlIlIlIIIlII = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posX / 8.0);
            String llllllllllllllllIlIIIlIlIlIIIIlI = llllllllllllllllIlIIIlIlIIlllllI.format(llllllllllllllllIlIIIlIlIIllIlII.mc.thePlayer.posZ / 8.0);
            llllllllllllllllIlIIIlIlIIllIllI = String.valueOf(new StringBuilder().append("XYZ ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIllIlII.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIIllllII).append(", ").append(llllllllllllllllIlIIIlIlIIlllIlI).append(", ").append(llllllllllllllllIlIIIlIlIIlllIII).append(ChatFormatting.RESET).append(" [").append(ChatFormatting.RESET).append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIllIlII.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIlIIIlII).append(", ").append(llllllllllllllllIlIIIlIlIlIIIIlI).append(ChatFormatting.RESET).append("]"));
        }
        return llllllllllllllllIlIIIlIlIIllIllI;
    }

    private String GetStacky() {
        CoordsComponent llllllllllllllllIlIIIlIIllllIIIl;
        DecimalFormat llllllllllllllllIlIIIlIIllllIlll = new DecimalFormat("0");
        String llllllllllllllllIlIIIlIIllllIlIl = "";
        String llllllllllllllllIlIIIlIIllllIIll = llllllllllllllllIlIIIlIIllllIlll.format(llllllllllllllllIlIIIlIIllllIIIl.mc.thePlayer.posY);
        llllllllllllllllIlIIIlIIllllIlIl = llllllllllllllllIlIIIlIIllllIIIl.mc.thePlayer.dimension == -1 ? String.valueOf(new StringBuilder().append("Y ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIIllllIIIl.mod.color.getValue())).append(llllllllllllllllIlIIIlIIllllIIll)) : String.valueOf(new StringBuilder().append("Y ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIIllllIIIl.mod.color.getValue())).append(llllllllllllllllIlIIIlIIllllIIll));
        return llllllllllllllllIlIIIlIIllllIlIl;
    }

    private String GetStackx() {
        CoordsComponent llllllllllllllllIlIIIlIlIIIlIIlI;
        DecimalFormat llllllllllllllllIlIIIlIlIIIlIIII = new DecimalFormat("0");
        String llllllllllllllllIlIIIlIlIIIIlllI = "";
        String llllllllllllllllIlIIIlIlIIIIllII = llllllllllllllllIlIIIlIlIIIlIIII.format(llllllllllllllllIlIIIlIlIIIlIIlI.mc.thePlayer.posX);
        if (llllllllllllllllIlIIIlIlIIIlIIlI.mc.thePlayer.dimension == -1) {
            String llllllllllllllllIlIIIlIlIIIlIllI = llllllllllllllllIlIIIlIlIIIlIIII.format(llllllllllllllllIlIIIlIlIIIlIIlI.mc.thePlayer.posX * 8.0);
            llllllllllllllllIlIIIlIlIIIIlllI = String.valueOf(new StringBuilder().append("X ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIIlIIlI.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIIIIllII).append(ChatFormatting.RESET).append(" [").append(ChatFormatting.RESET).append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIIlIIlI.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIIIlIllI).append(ChatFormatting.RESET).append("]"));
        } else {
            String llllllllllllllllIlIIIlIlIIIlIlII = llllllllllllllllIlIIIlIlIIIlIIII.format(llllllllllllllllIlIIIlIlIIIlIIlI.mc.thePlayer.posX / 8.0);
            llllllllllllllllIlIIIlIlIIIIlllI = String.valueOf(new StringBuilder().append("X ").append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIIlIIlI.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIIIIllII).append(ChatFormatting.RESET).append(" [").append(ChatFormatting.RESET).append(ChatFormatting.getByName((String)llllllllllllllllIlIIIlIlIIIlIIlI.mod.color.getValue())).append(llllllllllllllllIlIIIlIlIIIlIlII).append(ChatFormatting.RESET).append("]"));
        }
        return llllllllllllllllIlIIIlIlIIIIlllI;
    }
}

