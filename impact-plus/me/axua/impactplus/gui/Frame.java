/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.gui;

import java.awt.Color;
import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.components.Button;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class Frame {
    public /* synthetic */ int dragX;
    public /* synthetic */ Module.Category category;
    private /* synthetic */ int width;
    private /* synthetic */ int barHeight;
    public /* synthetic */ int dragY;
    private /* synthetic */ int height;
    private /* synthetic */ boolean open;
    private /* synthetic */ int x;
    public /* synthetic */ ArrayList<Component> components;
    private /* synthetic */ int y;
    /* synthetic */ boolean font;
    /* synthetic */ ClickGuiModule mod;
    private /* synthetic */ boolean isDragging;

    public boolean isWithinHeader(int lllllllllllllllIlllIlllIlIllIIIl, int lllllllllllllllIlllIlllIlIllIIII) {
        Frame lllllllllllllllIlllIlllIlIllIIlI;
        return lllllllllllllllIlllIlllIlIllIIIl >= lllllllllllllllIlllIlllIlIllIIlI.x && lllllllllllllllIlllIlllIlIllIIIl <= lllllllllllllllIlllIlllIlIllIIlI.x + lllllllllllllllIlllIlllIlIllIIlI.width && lllllllllllllllIlllIlllIlIllIIII >= lllllllllllllllIlllIlllIlIllIIlI.y && lllllllllllllllIlllIlllIlIllIIII <= lllllllllllllllIlllIlllIlIllIIlI.y + lllllllllllllllIlllIlllIlIllIIlI.barHeight;
    }

    public int getWidth() {
        Frame lllllllllllllllIlllIlllIllIIIIII;
        return lllllllllllllllIlllIlllIllIIIIII.width;
    }

    public Frame(Module.Category lllllllllllllllIlllIllllIIIIlIIl) {
        Frame lllllllllllllllIlllIllllIIIlIIII;
        lllllllllllllllIlllIllllIIIlIIII.mod = (ClickGuiModule)ModuleManager.getModuleByName("ClickGuiModule");
        lllllllllllllllIlllIllllIIIlIIII.components = new ArrayList();
        lllllllllllllllIlllIllllIIIlIIII.category = lllllllllllllllIlllIllllIIIIlIIl;
        lllllllllllllllIlllIllllIIIlIIII.width = 90;
        lllllllllllllllIlllIllllIIIlIIII.x = 5;
        lllllllllllllllIlllIllllIIIlIIII.y = 5;
        lllllllllllllllIlllIllllIIIlIIII.barHeight = 11;
        lllllllllllllllIlllIllllIIIlIIII.dragX = 0;
        lllllllllllllllIlllIllllIIIlIIII.open = true;
        lllllllllllllllIlllIllllIIIlIIII.isDragging = false;
        int lllllllllllllllIlllIllllIIIIllII = lllllllllllllllIlllIllllIIIlIIII.barHeight;
        for (Module lllllllllllllllIlllIllllIIIlIIIl : ModuleManager.getModulesInCategory(lllllllllllllllIlllIllllIIIIlIIl)) {
            Button lllllllllllllllIlllIllllIIIlIIll = new Button(lllllllllllllllIlllIllllIIIlIIIl, lllllllllllllllIlllIllllIIIlIIII, lllllllllllllllIlllIllllIIIIllII);
            lllllllllllllllIlllIllllIIIlIIII.components.add(lllllllllllllllIlllIllllIIIlIIll);
            lllllllllllllllIlllIllllIIIIllII += 5;
        }
        lllllllllllllllIlllIllllIIIlIIII.refresh();
    }

    public int getY() {
        Frame lllllllllllllllIlllIlllIllIIIIll;
        return lllllllllllllllIlllIlllIllIIIIll.y;
    }

    public int getX() {
        Frame lllllllllllllllIlllIlllIllIIIllI;
        return lllllllllllllllIlllIlllIllIIIllI.x;
    }

    public void renderFrame(FontRenderer lllllllllllllllIlllIlllIllIlllII) {
        Frame lllllllllllllllIlllIlllIllIlllIl;
        Color lllllllllllllllIlllIlllIllIllIll;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllIlllIlllIlllIIIII = Rainbow.getColorWithOpacity(130);
        } else {
            lllllllllllllllIlllIlllIllIllIll = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)lllllllllllllllIlllIlllIllIlllIl.x, (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width), (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.barHeight), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
        if (lllllllllllllllIlllIlllIllIlllIl.open) {
            Gui.drawRect((int)(lllllllllllllllIlllIlllIllIlllIl.x - 1), (int)(lllllllllllllllIlllIlllIllIlllIl.y - 1), (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width + 1), (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)(lllllllllllllllIlllIlllIllIlllIl.x - 1), (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)lllllllllllllllIlllIlllIllIlllIl.x, (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.height + 2), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)lllllllllllllllIlllIlllIllIlllIl.x, (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.height + 1), (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width + 1), (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.height + 2), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width), (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width + 1), (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.height + 1), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)lllllllllllllllIlllIlllIllIlllIl.x, (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.height), (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width), (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.height + 1), (int)new Color(0, 0, 0, 70).getRGB());
        } else {
            Gui.drawRect((int)(lllllllllllllllIlllIlllIllIlllIl.x - 1), (int)(lllllllllllllllIlllIlllIllIlllIl.y - 1), (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width + 1), (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)(lllllllllllllllIlllIlllIllIlllIl.x - 1), (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)lllllllllllllllIlllIlllIllIlllIl.x, (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.barHeight + 1), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)lllllllllllllllIlllIlllIllIlllIl.x, (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.barHeight), (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width + 1), (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.barHeight + 1), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
            Gui.drawRect((int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width), (int)lllllllllllllllIlllIlllIllIlllIl.y, (int)(lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width + 1), (int)(lllllllllllllllIlllIlllIllIlllIl.y + lllllllllllllllIlllIlllIllIlllIl.barHeight), (int)lllllllllllllllIlllIlllIllIllIll.getRGB());
        }
        int lllllllllllllllIlllIlllIllIllIlI = 0;
        String lllllllllllllllIlllIlllIllIllIIl = "";
        if (lllllllllllllllIlllIlllIllIlllIl.open && !lllllllllllllllIlllIlllIllIlllIl.components.isEmpty()) {
            for (Component lllllllllllllllIlllIlllIllIlllll : lllllllllllllllIlllIlllIllIlllIl.components) {
                lllllllllllllllIlllIlllIllIlllll.renderComponent();
            }
        }
        if (!lllllllllllllllIlllIlllIllIlllIl.components.isEmpty()) {
            for (Component lllllllllllllllIlllIlllIllIllllI : lllllllllllllllIlllIlllIllIlllIl.components) {
                ++lllllllllllllllIlllIlllIllIllIlI;
            }
        }
        if (ClickGuiModule.shownumbers.getValue()) {
            if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("COMBAT")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Combat (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("PLAYER")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Player (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("MOVEMENT")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Movement (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("MISC")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Miscellaneous (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("CHAT")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Chat (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("RENDER")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Render (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("CLIENT")) {
                lllllllllllllllIlllIlllIllIllIIl = String.valueOf(new StringBuilder().append("Client (").append(lllllllllllllllIlllIlllIllIllIlI).append(")"));
            }
            if (ClickGuiModule.titlealign.getValue().equals("Left")) {
                ImpactPlus.CustomFont.drawStringWithShadow(lllllllllllllllIlllIlllIllIllIIl, lllllllllllllllIlllIlllIllIlllIl.x + 2, lllllllllllllllIlllIlllIllIlllIl.y - 1, -1);
            } else {
                ImpactPlus.CustomFont.drawCenteredStringWithShadow(lllllllllllllllIlllIlllIllIllIIl, lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width / 2, lllllllllllllllIlllIlllIllIlllIl.y - 1, -1);
            }
        } else {
            if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("COMBAT")) {
                lllllllllllllllIlllIlllIllIllIIl = "Combat";
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("PLAYER")) {
                lllllllllllllllIlllIlllIllIllIIl = "Player";
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("MOVEMENT")) {
                lllllllllllllllIlllIlllIllIllIIl = "Movement";
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("MISC")) {
                lllllllllllllllIlllIlllIllIllIIl = "Miscellaneous";
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("CHAT")) {
                lllllllllllllllIlllIlllIllIllIIl = "Chat";
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("RENDER")) {
                lllllllllllllllIlllIlllIllIllIIl = "Render";
            } else if (lllllllllllllllIlllIlllIllIlllIl.category.name().equals("CLIENT")) {
                lllllllllllllllIlllIlllIllIllIIl = "Client";
            }
            if (ClickGuiModule.titlealign.getValue().equals("Left")) {
                ImpactPlus.CustomFont.drawStringWithShadow(lllllllllllllllIlllIlllIllIllIIl, lllllllllllllllIlllIlllIllIlllIl.x + 2, lllllllllllllllIlllIlllIllIlllIl.y - 1, -1);
            } else {
                ImpactPlus.CustomFont.drawCenteredStringWithShadow(lllllllllllllllIlllIlllIllIllIIl, lllllllllllllllIlllIlllIllIlllIl.x + lllllllllllllllIlllIlllIllIlllIl.width / 2, lllllllllllllllIlllIlllIllIlllIl.y - 1, -1);
            }
        }
    }

    public void setOpen(boolean lllllllllllllllIlllIlllIlllIIlll) {
        lllllllllllllllIlllIlllIlllIlIII.open = lllllllllllllllIlllIlllIlllIIlll;
    }

    public ArrayList<Component> getComponents() {
        Frame lllllllllllllllIlllIllllIIIIIIlI;
        return lllllllllllllllIlllIllllIIIIIIlI.components;
    }

    public boolean isOpen() {
        Frame lllllllllllllllIlllIlllIlllIlllI;
        return lllllllllllllllIlllIlllIlllIlllI.open;
    }

    public void updatePosition(int lllllllllllllllIlllIlllIlIlllIlI, int lllllllllllllllIlllIlllIlIlllIIl) {
        Frame lllllllllllllllIlllIlllIlIlllIII;
        if (lllllllllllllllIlllIlllIlIlllIII.isDragging) {
            lllllllllllllllIlllIlllIlIlllIII.setX(lllllllllllllllIlllIlllIlIlllIlI - lllllllllllllllIlllIlllIlIlllIII.dragX);
            lllllllllllllllIlllIlllIlIlllIII.setY(lllllllllllllllIlllIlllIlIlllIIl - lllllllllllllllIlllIlllIlIlllIII.dragY);
        }
    }

    public void setDrag(boolean lllllllllllllllIlllIlllIllllIIlI) {
        lllllllllllllllIlllIlllIllllIIll.isDragging = lllllllllllllllIlllIlllIllllIIlI;
    }

    public void setX(int lllllllllllllllIlllIlllIlllllllI) {
        lllllllllllllllIlllIlllIllllllIl.x = lllllllllllllllIlllIlllIlllllllI;
    }

    public void setY(int lllllllllllllllIlllIlllIlllllIII) {
        lllllllllllllllIlllIlllIllllIlll.y = lllllllllllllllIlllIlllIlllllIII;
    }

    public void refresh() {
        Frame lllllllllllllllIlllIlllIllIIlIll;
        int lllllllllllllllIlllIlllIllIIllII = lllllllllllllllIlllIlllIllIIlIll.barHeight;
        for (Component lllllllllllllllIlllIlllIllIIlllI : lllllllllllllllIlllIlllIllIIlIll.components) {
            lllllllllllllllIlllIlllIllIIlllI.setOff(lllllllllllllllIlllIlllIllIIllII);
            lllllllllllllllIlllIlllIllIIllII += lllllllllllllllIlllIlllIllIIlllI.getHeight();
        }
        lllllllllllllllIlllIlllIllIIlIll.height = lllllllllllllllIlllIlllIllIIllII;
    }
}

