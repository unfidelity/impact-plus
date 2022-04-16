/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.hud.components;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class ArrayListComponent
extends HudComponent<me.axua.impactplus.module.modules.hud.ArrayList> {
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ int modcount;
    /* synthetic */ int mods;
    /* synthetic */ ArrayList<Integer> array;
    /* synthetic */ HudColours mod;
    /* synthetic */ Minecraft mc;
    /* synthetic */ int upoffset;
    /* synthetic */ me.axua.impactplus.module.modules.hud.ArrayList mod2;
    /* synthetic */ int offsetfinal;
    /* synthetic */ int offset;
    /* synthetic */ int upoffsetfinal;
    /* synthetic */ ArrayList<Integer> customarray;

    public int getwidthcustom() {
        ArrayListComponent llllllllllllllllIllIlIlIllIllllI;
        return llllllllllllllllIllIlIlIllIllllI.customarray.get(llllllllllllllllIllIlIlIllIllllI.customarray.size() - 1) + 1;
    }

    public int getwidth() {
        ArrayListComponent llllllllllllllllIllIlIlIllllIIII;
        return llllllllllllllllIllIlIlIllllIIII.array.get(llllllllllllllllIllIlIlIllllIIII.array.size() - 1);
    }

    public int getheight() {
        ArrayListComponent llllllllllllllllIllIlIlIllIIlllI;
        llllllllllllllllIllIlIlIllIIlllI.mods = 0;
        ModuleManager.getModules().stream().filter(Module::isEnabled).filter(Module::isDrawn).sorted(Comparator.comparing(llllllllllllllllIllIlIlIlIlIllII -> {
            ArrayListComponent llllllllllllllllIllIlIlIlIlIllIl;
            return Float.valueOf(ClickGuiModule.customfont.getValue() ? ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIlIlIllII.getName()) * -1.0f : (float)(llllllllllllllllIllIlIlIlIlIllIl.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIlIlIllII.getName()) * -1));
        })).forEach(llllllllllllllllIllIlIlIlIllllll -> {
            ArrayListComponent llllllllllllllllIllIlIlIllIIIIIl;
            ++llllllllllllllllIllIlIlIllIIIIIl.mods;
        });
        int llllllllllllllllIllIlIlIllIlIIII = llllllllllllllllIllIlIlIllIIlllI.mods;
        return llllllllllllllllIllIlIlIllIlIIII * 9;
    }

    @Override
    public void render() {
        Color llllllllllllllllIllIlIlIlllllIIl;
        ArrayListComponent llllllllllllllllIllIlIlIlllllIll;
        super.render();
        if (llllllllllllllllIllIlIlIlllllIll.mod.rainbow.getValue()) {
            Color llllllllllllllllIllIlIlIlllllllI = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIllIlIlIlllllIIl = new Color(llllllllllllllllIllIlIlIlllllIll.mod.red.getValue(), llllllllllllllllIllIlIlIlllllIll.mod.green.getValue(), llllllllllllllllIllIlIlIlllllIll.mod.blue.getValue(), 255);
        }
        llllllllllllllllIllIlIlIlllllIll.modcount = 0;
        llllllllllllllllIllIlIlIlllllIll.mods = 0;
        llllllllllllllllIllIlIlIlllllIll.offset = 0;
        llllllllllllllllIllIlIlIlllllIll.upoffset = 0;
        ModuleManager.getModules().stream().filter(Module::isEnabled).filter(Module::isDrawn).sorted(Comparator.comparing(llllllllllllllllIllIlIlIIIIIIlll -> {
            ArrayListComponent llllllllllllllllIllIlIlIIIIIlIII;
            return Float.valueOf(ClickGuiModule.customfont.getValue() ? -ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIIIIlll.getName()) * -1.0f : (float)(-llllllllllllllllIllIlIlIIIIIlIII.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIIIIIIlll.getName()) * -1));
        })).forEach(llllllllllllllllIllIlIlIIIIlIlll -> {
            ArrayListComponent llllllllllllllllIllIlIlIIIIlIllI;
            llllllllllllllllIllIlIlIIIIlIllI.customarray.add((int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIIlIlll.getName()));
            llllllllllllllllIllIlIlIIIIlIllI.array.add(llllllllllllllllIllIlIlIIIIlIllI.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIIIIlIlll.getName()));
        });
        ModuleManager.getModules().stream().filter(Module::isEnabled).filter(Module::isDrawn).sorted(Comparator.comparing(llllllllllllllllIllIlIlIIIIlllll -> {
            ArrayListComponent llllllllllllllllIllIlIlIIIlIIIII;
            return Float.valueOf(ClickGuiModule.customfont.getValue() ? ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIIlllll.getName()) * -1.0f : (float)(llllllllllllllllIllIlIlIIIlIIIII.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIIIIlllll.getName()) * -1));
        })).forEach(llllllllllllllllIllIlIlIIIlIllII -> {
            ArrayListComponent llllllllllllllllIllIlIlIIIlIlllI;
            if (ClickGuiModule.customfont.getValue()) {
                int llllllllllllllllIllIlIlIIIllIlIl = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName());
                llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal = llllllllllllllllIllIlIlIIIlIlllI.upoffset + llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight();
                llllllllllllllllIllIlIlIIIlIlllI.offsetfinal = llllllllllllllllIllIlIlIIIlIlllI.offset + llllllllllllllllIllIlIlIIIlIlllI.y;
                if (llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal < 1) {
                    llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal = 1;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.offsetfinal < 1) {
                    llllllllllllllllIllIlIlIIIlIlllI.offsetfinal = 1;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal > 355) {
                    llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal = llllllllllllllllIllIlIlIIIlIlllI.upoffset + llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 355;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.offsetfinal > 355) {
                    llllllllllllllllIllIlIlIIIlIlllI.offsetfinal = llllllllllllllllIllIlIlIIIlIlllI.offset + llllllllllllllllIllIlIlIIIlIlllI.y - 355;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.mod2.sortUp.getValue()) {
                    if (llllllllllllllllIllIlIlIIIlIlllI.mod2.right.getValue()) {
                        if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                            Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) + llllllllllllllllIllIlIlIIIllIlIl + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                            Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                        }
                        ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), (float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName()), llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 - llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2, llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                    } else {
                        if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                            Gui.drawRect((int)llllllllllllllllIllIlIlIIIlIlllI.x, (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIlIl + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                            Gui.drawRect((int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIlIl + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIlIl + 3), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                        }
                        ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), llllllllllllllllIllIlIlIIIlIlllI.x, llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2, llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                    }
                } else if (llllllllllllllllIllIlIlIIIlIlllI.mod2.right.getValue()) {
                    if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                        Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) + llllllllllllllllIllIlIlIIIllIlIl + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                        Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                    }
                    ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), (float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName()), llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2, llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                } else {
                    if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                        Gui.drawRect((int)llllllllllllllllIllIlIlIIIlIlllI.x, (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIlIl + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                        Gui.drawRect((int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIlIl + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIlIl + 3), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                    }
                    ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), llllllllllllllllIllIlIlIIIlIlllI.x, llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2, llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                }
                llllllllllllllllIllIlIlIIIlIlllI.width = llllllllllllllllIllIlIlIIIlIlllI.customarray.get(llllllllllllllllIllIlIlIIIlIlllI.customarray.size() - 1) + 1;
                llllllllllllllllIllIlIlIIIlIlllI.height = 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9;
                ++llllllllllllllllIllIlIlIIIlIlllI.modcount;
                llllllllllllllllIllIlIlIIIlIlllI.offset += 9;
                llllllllllllllllIllIlIlIIIlIlllI.upoffset -= 9;
            } else {
                int llllllllllllllllIllIlIlIIIllIIll = llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName());
                llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal = llllllllllllllllIllIlIlIIIlIlllI.upoffset + llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight();
                llllllllllllllllIllIlIlIIIlIlllI.offsetfinal = llllllllllllllllIllIlIlIIIlIlllI.offset + llllllllllllllllIllIlIlIIIlIlllI.y;
                if (llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal < 1) {
                    llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal = 1;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.offsetfinal < 1) {
                    llllllllllllllllIllIlIlIIIlIlllI.offsetfinal = 1;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal > 355) {
                    llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal = llllllllllllllllIllIlIlIIIlIlllI.upoffset + llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 355;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.offsetfinal > 355) {
                    llllllllllllllllIllIlIlIIIlIlllI.offsetfinal = llllllllllllllllIllIlIlIIIlIlllI.offset + llllllllllllllllIllIlIlIIIlIlllI.y - 355;
                }
                if (llllllllllllllllIllIlIlIIIlIlllI.mod2.sortUp.getValue()) {
                    if (llllllllllllllllIllIlIlIIIlIlllI.mod2.right.getValue()) {
                        if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                            Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) + llllllllllllllllIllIlIlIIIllIIll + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                            Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                        }
                        llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), (float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidth() - llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())), (float)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 - llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                    } else {
                        if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                            Gui.drawRect((int)llllllllllllllllIllIlIlIIIlIlllI.x, (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIIll + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                            Gui.drawRect((int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIIll + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIIll + 3), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                        }
                        llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), (float)llllllllllllllllIllIlIlIIIlIlllI.x, (float)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.getheight() - 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * -9), llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.upoffsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                    }
                } else if (llllllllllllllllIllIlIlIIIlIlllI.mod2.right.getValue()) {
                    if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                        Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) + llllllllllllllllIllIlIlIIIllIIll + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                        Gui.drawRect((int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 1), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)((int)((float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidthcustom() - 1) - ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())) - 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                    }
                    llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), (float)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIlIlllI.getwidth() - llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIlIIIlIllII.getName())), (float)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                } else {
                    if (llllllllllllllllIllIlIlIIIlIlllI.mod2.rects.getValue()) {
                        Gui.drawRect((int)llllllllllllllllIllIlIlIIIlIlllI.x, (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIIll + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)new Color(0, 0, 0, 130).getRGB());
                        Gui.drawRect((int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIIll + 2), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), (int)(llllllllllllllllIllIlIlIIIlIlllI.x + llllllllllllllllIllIlIlIIIllIIll + 3), (int)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9 - 2 + 11), (int)(llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB()));
                    }
                    llllllllllllllllIllIlIlIIIlIlllI.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIllIlIlIIIlIllII.getName(), (float)llllllllllllllllIllIlIlIIIlIlllI.x, (float)(llllllllllllllllIllIlIlIIIlIlllI.y + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9), llllllllllllllllIllIlIlIIIlIlllI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIlIIIlIlllI.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIlIIIlIlllI.offsetfinal) : llllllllllllllllIllIlIlIlllllIIl.getRGB());
                }
                llllllllllllllllIllIlIlIIIlIlllI.width = llllllllllllllllIllIlIlIIIlIlllI.array.get(llllllllllllllllIllIlIlIIIlIlllI.array.size() - 1);
                llllllllllllllllIllIlIlIIIlIlllI.height = 9 + llllllllllllllllIllIlIlIIIlIlllI.modcount * 9;
                ++llllllllllllllllIllIlIlIIIlIlllI.modcount;
                llllllllllllllllIllIlIlIIIlIlllI.offset += 9;
                llllllllllllllllIllIlIlIIIlIlllI.upoffset -= 9;
            }
        });
    }

    public ArrayListComponent() {
        super("ArrayList", 2, 280, me.axua.impactplus.module.modules.hud.ArrayList.INSTANCE);
        ArrayListComponent llllllllllllllllIllIlIllIIIllIII;
        llllllllllllllllIllIlIllIIIllIII.mc = Minecraft.getMinecraft();
        llllllllllllllllIllIlIllIIIllIII.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIllIlIllIIIllIII.mod2 = (me.axua.impactplus.module.modules.hud.ArrayList)ModuleManager.getModuleByName("ArrayList");
        llllllllllllllllIllIlIllIIIllIII.Rainbow1 = Rainbow.getbruh();
        llllllllllllllllIllIlIllIIIllIII.customarray = new ArrayList();
        llllllllllllllllIllIlIllIIIllIII.array = new ArrayList();
    }
}

