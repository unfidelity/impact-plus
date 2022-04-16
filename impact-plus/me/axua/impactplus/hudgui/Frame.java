/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.hudgui;

import java.awt.Color;
import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.components.Button;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class Frame {
    public /* synthetic */ ArrayList<Component> components;
    private /* synthetic */ int y;
    private /* synthetic */ boolean isDragging;
    public /* synthetic */ int dragY;
    /* synthetic */ boolean font;
    public /* synthetic */ int dragX;
    /* synthetic */ ClickGuiModule mod;
    private /* synthetic */ boolean open;
    public /* synthetic */ Module.Category category;
    private /* synthetic */ int barHeight;
    private /* synthetic */ int x;
    private /* synthetic */ int width;
    private /* synthetic */ int height;

    public int getWidth() {
        Frame lIIIIIlIIlIIIll;
        return lIIIIIlIIlIIIll.width;
    }

    public int getY() {
        Frame lIIIIIlIIlIIllI;
        return lIIIIIlIIlIIllI.y;
    }

    public void updatePosition(int lIIIIIlIIIllIll, int lIIIIIlIIIllIlI) {
        Frame lIIIIIlIIIlllII;
        if (lIIIIIlIIIlllII.isDragging) {
            lIIIIIlIIIlllII.setX(lIIIIIlIIIllIll - lIIIIIlIIIlllII.dragX);
            lIIIIIlIIIlllII.setY(lIIIIIlIIIllIlI - lIIIIIlIIIlllII.dragY);
        }
    }

    public ArrayList<Component> getComponents() {
        Frame lIIIIIlIllllIlI;
        return lIIIIIlIllllIlI.components;
    }

    public boolean isOpen() {
        Frame lIIIIIlIlIlIllI;
        return lIIIIIlIlIlIllI.open;
    }

    public void renderFrame(FontRenderer lIIIIIlIlIIIIII) {
        Frame lIIIIIlIIllllII;
        Color lIIIIIlIIllllll;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lIIIIIlIlIIIlII = Rainbow.getColorWithOpacity(130);
        } else {
            lIIIIIlIIllllll = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)lIIIIIlIIllllII.x, (int)lIIIIIlIIllllII.y, (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width), (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.barHeight), (int)lIIIIIlIIllllll.getRGB());
        if (lIIIIIlIIllllII.open) {
            Gui.drawRect((int)(lIIIIIlIIllllII.x - 1), (int)(lIIIIIlIIllllII.y - 1), (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width + 1), (int)lIIIIIlIIllllII.y, (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)(lIIIIIlIIllllII.x - 1), (int)lIIIIIlIIllllII.y, (int)lIIIIIlIIllllII.x, (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.height + 2), (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)lIIIIIlIIllllII.x, (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.height + 1), (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width + 1), (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.height + 2), (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width), (int)lIIIIIlIIllllII.y, (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width + 1), (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.height + 1), (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)lIIIIIlIIllllII.x, (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.height), (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width), (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.height + 1), (int)new Color(0, 0, 0, 70).getRGB());
        } else {
            Gui.drawRect((int)(lIIIIIlIIllllII.x - 1), (int)(lIIIIIlIIllllII.y - 1), (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width + 1), (int)lIIIIIlIIllllII.y, (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)(lIIIIIlIIllllII.x - 1), (int)lIIIIIlIIllllII.y, (int)lIIIIIlIIllllII.x, (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.barHeight + 1), (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)lIIIIIlIIllllII.x, (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.barHeight), (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width + 1), (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.barHeight + 1), (int)lIIIIIlIIllllll.getRGB());
            Gui.drawRect((int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width), (int)lIIIIIlIIllllII.y, (int)(lIIIIIlIIllllII.x + lIIIIIlIIllllII.width + 1), (int)(lIIIIIlIIllllII.y + lIIIIIlIIllllII.barHeight), (int)lIIIIIlIIllllll.getRGB());
        }
        int lIIIIIlIIlllllI = 0;
        String lIIIIIlIIllllIl = "";
        if (lIIIIIlIIllllII.open && !lIIIIIlIIllllII.components.isEmpty()) {
            for (Component lIIIIIlIlIIIIll : lIIIIIlIIllllII.components) {
                lIIIIIlIlIIIIll.renderComponent();
            }
        }
        if (!lIIIIIlIIllllII.components.isEmpty()) {
            for (Component lIIIIIlIlIIIIlI : lIIIIIlIIllllII.components) {
                ++lIIIIIlIIlllllI;
            }
        }
        if (ClickGuiModule.shownumbers.getValue()) {
            if (lIIIIIlIIllllII.category.name().equals("HUD")) {
                lIIIIIlIIllllIl = String.valueOf(new StringBuilder().append("Hud (").append(lIIIIIlIIlllllI).append(")"));
            }
            if (ClickGuiModule.titlealign.getValue().equals("Left")) {
                ImpactPlus.CustomFont.drawStringWithShadow(lIIIIIlIIllllIl, lIIIIIlIIllllII.x + 2, lIIIIIlIIllllII.y - 1, -1);
            } else {
                ImpactPlus.CustomFont.drawCenteredStringWithShadow(lIIIIIlIIllllIl, lIIIIIlIIllllII.x + lIIIIIlIIllllII.width / 2, lIIIIIlIIllllII.y - 1, -1);
            }
        } else {
            if (lIIIIIlIIllllII.category.name().equals("HUD")) {
                lIIIIIlIIllllIl = "Hud";
            }
            if (ClickGuiModule.titlealign.getValue().equals("Left")) {
                ImpactPlus.CustomFont.drawStringWithShadow(lIIIIIlIIllllIl, lIIIIIlIIllllII.x + 2, lIIIIIlIIllllII.y - 1, -1);
            } else {
                ImpactPlus.CustomFont.drawCenteredStringWithShadow(lIIIIIlIIllllIl, lIIIIIlIIllllII.x + lIIIIIlIIllllII.width / 2, lIIIIIlIIllllII.y - 1, -1);
            }
        }
    }

    public void setOpen(boolean lIIIIIlIlIIllIl) {
        lIIIIIlIlIIlllI.open = lIIIIIlIlIIllIl;
    }

    public Frame(Module.Category lIIIIIllIIIIlII) {
        Frame lIIIIIllIIIIlIl;
        lIIIIIllIIIIlIl.mod = (ClickGuiModule)ModuleManager.getModuleByName("ClickGuiModule");
        lIIIIIllIIIIlIl.components = new ArrayList();
        lIIIIIllIIIIlIl.category = lIIIIIllIIIIlII;
        lIIIIIllIIIIlIl.width = 90;
        lIIIIIllIIIIlIl.x = 5;
        lIIIIIllIIIIlIl.y = 5;
        lIIIIIllIIIIlIl.barHeight = 11;
        lIIIIIllIIIIlIl.dragX = 0;
        lIIIIIllIIIIlIl.open = true;
        lIIIIIllIIIIlIl.isDragging = false;
        int lIIIIIllIIIIIll = lIIIIIllIIIIlIl.barHeight;
        for (Module lIIIIIllIIIIllI : ModuleManager.getModulesInCategory(lIIIIIllIIIIlII)) {
            Button lIIIIIllIIIIlll = new Button(lIIIIIllIIIIllI, lIIIIIllIIIIlIl, lIIIIIllIIIIIll);
            lIIIIIllIIIIlIl.components.add(lIIIIIllIIIIlll);
            lIIIIIllIIIIIll += 5;
        }
        lIIIIIllIIIIlIl.refresh();
    }

    public void refresh() {
        Frame lIIIIIlIIllIIIl;
        int lIIIIIlIIllIIII = lIIIIIlIIllIIIl.barHeight;
        for (Component lIIIIIlIIllIIlI : lIIIIIlIIllIIIl.components) {
            lIIIIIlIIllIIlI.setOff(lIIIIIlIIllIIII);
            lIIIIIlIIllIIII += lIIIIIlIIllIIlI.getHeight();
        }
        lIIIIIlIIllIIIl.height = lIIIIIlIIllIIII;
    }

    public int getX() {
        Frame lIIIIIlIIlIlIlI;
        return lIIIIIlIIlIlIlI.x;
    }

    public void setX(int lIIIIIlIlllIlII) {
        lIIIIIlIlllIlll.x = lIIIIIlIlllIlII;
    }

    public boolean isWithinHeader(int lIIIIIlIIIlIlIl, int lIIIIIlIIIlIlII) {
        Frame lIIIIIlIIIlIIll;
        return lIIIIIlIIIlIlIl >= lIIIIIlIIIlIIll.x && lIIIIIlIIIlIlIl <= lIIIIIlIIIlIIll.x + lIIIIIlIIIlIIll.width && lIIIIIlIIIlIlII >= lIIIIIlIIIlIIll.y && lIIIIIlIIIlIlII <= lIIIIIlIIIlIIll.y + lIIIIIlIIIlIIll.barHeight;
    }

    public void setDrag(boolean lIIIIIlIlIlllIl) {
        lIIIIIlIlIllllI.isDragging = lIIIIIlIlIlllIl;
    }

    public void setY(int lIIIIIlIllIlIII) {
        lIIIIIlIllIlIll.y = lIIIIIlIllIlIII;
    }
}

