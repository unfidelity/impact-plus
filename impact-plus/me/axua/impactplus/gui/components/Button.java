/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.axua.impactplus.gui.components;

import java.awt.Color;
import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.Frame;
import me.axua.impactplus.gui.components.CheckBox;
import me.axua.impactplus.gui.components.DoubleSlider;
import me.axua.impactplus.gui.components.IntSlider;
import me.axua.impactplus.gui.components.Keybind;
import me.axua.impactplus.gui.components.ModeButton;
import me.axua.impactplus.gui.components.StringButton;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class Button
extends Component {
    /* synthetic */ int yy;
    public /* synthetic */ Module mod;
    public /* synthetic */ boolean open;
    /* synthetic */ int xx;
    private /* synthetic */ boolean isHovered;
    private /* synthetic */ int height;
    public /* synthetic */ Frame parent;
    private /* synthetic */ ArrayList<Component> subcomponents;
    public /* synthetic */ int offset;

    public Button(Module lllllllllllllllIllllIlllIIlIlIlI, Frame lllllllllllllllIllllIlllIIlIlIIl, int lllllllllllllllIllllIlllIIlIllIl) {
        Button lllllllllllllllIllllIlllIIllIIII;
        lllllllllllllllIllllIlllIIllIIII.mod = lllllllllllllllIllllIlllIIlIlIlI;
        lllllllllllllllIllllIlllIIllIIII.parent = lllllllllllllllIllllIlllIIlIlIIl;
        lllllllllllllllIllllIlllIIllIIII.offset = lllllllllllllllIllllIlllIIlIllIl;
        lllllllllllllllIllllIlllIIllIIII.subcomponents = new ArrayList();
        lllllllllllllllIllllIlllIIllIIII.open = false;
        lllllllllllllllIllllIlllIIllIIII.height = 11;
        int lllllllllllllllIllllIlllIIlIllII = lllllllllllllllIllllIlllIIlIllIl + 11;
        if (ImpactPlus.getInstance().settingsManager.getSettingsForMod(lllllllllllllllIllllIlllIIlIlIlI) != null && !ImpactPlus.getInstance().settingsManager.getSettingsForMod(lllllllllllllllIllllIlllIIlIlIlI).isEmpty()) {
            block7: for (Setting lllllllllllllllIllllIlllIIllIIIl : ImpactPlus.getInstance().settingsManager.getSettingsForMod(lllllllllllllllIllllIlllIIlIlIlI)) {
                switch (lllllllllllllllIllllIlllIIllIIIl.getType()) {
                    case MODE: {
                        lllllllllllllllIllllIlllIIllIIII.subcomponents.add(new ModeButton((Setting.mode)lllllllllllllllIllllIlllIIllIIIl, lllllllllllllllIllllIlllIIllIIII, lllllllllllllllIllllIlllIIlIlIlI, lllllllllllllllIllllIlllIIlIllII));
                        lllllllllllllllIllllIlllIIlIllII += 11;
                        continue block7;
                    }
                    case STRING: {
                        lllllllllllllllIllllIlllIIllIIII.subcomponents.add(new StringButton((Setting.s)lllllllllllllllIllllIlllIIllIIIl, lllllllllllllllIllllIlllIIllIIII, lllllllllllllllIllllIlllIIlIllII));
                        lllllllllllllllIllllIlllIIlIllII += 11;
                        continue block7;
                    }
                    case BOOLEAN: {
                        lllllllllllllllIllllIlllIIllIIII.subcomponents.add(new CheckBox((Setting.b)lllllllllllllllIllllIlllIIllIIIl, lllllllllllllllIllllIlllIIllIIII, lllllllllllllllIllllIlllIIlIllII));
                        lllllllllllllllIllllIlllIIlIllII += 11;
                        continue block7;
                    }
                    case DOUBLE: {
                        lllllllllllllllIllllIlllIIllIIII.subcomponents.add(new DoubleSlider((Setting.d)lllllllllllllllIllllIlllIIllIIIl, lllllllllllllllIllllIlllIIllIIII, lllllllllllllllIllllIlllIIlIllII));
                        lllllllllllllllIllllIlllIIlIllII += 11;
                        continue block7;
                    }
                    case INT: {
                        lllllllllllllllIllllIlllIIllIIII.subcomponents.add(new IntSlider((Setting.i)lllllllllllllllIllllIlllIIllIIIl, lllllllllllllllIllllIlllIIllIIII, lllllllllllllllIllllIlllIIlIllII));
                        lllllllllllllllIllllIlllIIlIllII += 11;
                        continue block7;
                    }
                }
            }
        }
        lllllllllllllllIllllIlllIIllIIII.subcomponents.add(new Keybind(lllllllllllllllIllllIlllIIllIIII, lllllllllllllllIllllIlllIIlIllII));
    }

    @Override
    public int getHeight() {
        Button lllllllllllllllIllllIlllIIIIIIll;
        if (lllllllllllllllIllllIlllIIIIIIll.open) {
            return 11 * (lllllllllllllllIllllIlllIIIIIIll.subcomponents.size() + 1);
        }
        return 11;
    }

    public boolean isMouseOnButton(int lllllllllllllllIllllIllIllIIIIII, int lllllllllllllllIllllIllIlIllllII) {
        Button lllllllllllllllIllllIllIllIIIIIl;
        return lllllllllllllllIllllIllIllIIIIII > lllllllllllllllIllllIllIllIIIIIl.parent.getX() && lllllllllllllllIllllIllIllIIIIII < lllllllllllllllIllllIllIllIIIIIl.parent.getX() + lllllllllllllllIllllIllIllIIIIIl.parent.getWidth() && lllllllllllllllIllllIllIlIllllII > lllllllllllllllIllllIllIllIIIIIl.parent.getY() + lllllllllllllllIllllIllIllIIIIIl.offset && lllllllllllllllIllllIllIlIllllII < lllllllllllllllIllllIllIllIIIIIl.parent.getY() + 11 + lllllllllllllllIllllIllIllIIIIIl.offset;
    }

    @Override
    public void setOff(int lllllllllllllllIllllIlllIIIllIlI) {
        Button lllllllllllllllIllllIlllIIIllllI;
        lllllllllllllllIllllIlllIIIllllI.offset = lllllllllllllllIllllIlllIIIllIlI;
        int lllllllllllllllIllllIlllIIIlllII = lllllllllllllllIllllIlllIIIllllI.offset + 11;
        for (Component lllllllllllllllIllllIlllIIIlllll : lllllllllllllllIllllIlllIIIllllI.subcomponents) {
            lllllllllllllllIllllIlllIIIlllll.setOff(lllllllllllllllIllllIlllIIIlllII);
            lllllllllllllllIllllIlllIIIlllII += 11;
        }
    }

    @Override
    public void mouseClicked(int lllllllllllllllIllllIllIlllIllII, int lllllllllllllllIllllIllIlllIlIll, int lllllllllllllllIllllIllIlllIIllI) {
        Button lllllllllllllllIllllIllIlllIllIl;
        if (lllllllllllllllIllllIllIlllIllIl.isMouseOnButton(lllllllllllllllIllllIllIlllIllII, lllllllllllllllIllllIllIlllIlIll) && lllllllllllllllIllllIllIlllIIllI == 0) {
            lllllllllllllllIllllIllIlllIllIl.mod.toggle();
        }
        if (lllllllllllllllIllllIllIlllIllIl.isMouseOnButton(lllllllllllllllIllllIllIlllIllII, lllllllllllllllIllllIllIlllIlIll) && lllllllllllllllIllllIllIlllIIllI == 1) {
            lllllllllllllllIllllIllIlllIllIl.open = !lllllllllllllllIllllIllIlllIllIl.open;
            lllllllllllllllIllllIllIlllIllIl.parent.refresh();
        }
        for (Component lllllllllllllllIllllIllIlllIlllI : lllllllllllllllIllllIllIlllIllIl.subcomponents) {
            lllllllllllllllIllllIllIlllIlllI.mouseClicked(lllllllllllllllIllllIllIlllIllII, lllllllllllllllIllllIllIlllIlIll, lllllllllllllllIllllIllIlllIIllI);
        }
    }

    @Override
    public void updateComponent(int lllllllllllllllIllllIllIlllllIll, int lllllllllllllllIllllIllIllllIlll) {
        Button lllllllllllllllIllllIllIllllllII;
        lllllllllllllllIllllIllIllllllII.xx = lllllllllllllllIllllIllIlllllIll + 10;
        lllllllllllllllIllllIllIllllllII.yy = lllllllllllllllIllllIllIllllIlll - 5;
        lllllllllllllllIllllIllIllllllII.isHovered = lllllllllllllllIllllIllIllllllII.isMouseOnButton(lllllllllllllllIllllIllIlllllIll, lllllllllllllllIllllIllIllllIlll);
        if (!lllllllllllllllIllllIllIllllllII.subcomponents.isEmpty()) {
            for (Component lllllllllllllllIllllIllIllllllIl : lllllllllllllllIllllIllIllllllII.subcomponents) {
                lllllllllllllllIllllIllIllllllIl.updateComponent(lllllllllllllllIllllIllIlllllIll, lllllllllllllllIllllIllIllllIlll);
            }
        }
    }

    @Override
    public void mouseReleased(int lllllllllllllllIllllIllIllIllIll, int lllllllllllllllIllllIllIllIllIlI, int lllllllllllllllIllllIllIllIlIlIl) {
        Button lllllllllllllllIllllIllIllIlllII;
        for (Component lllllllllllllllIllllIllIllIlllIl : lllllllllllllllIllllIllIllIlllII.subcomponents) {
            lllllllllllllllIllllIllIllIlllIl.mouseReleased(lllllllllllllllIllllIllIllIllIll, lllllllllllllllIllllIllIllIllIlI, lllllllllllllllIllllIllIllIlIlIl);
        }
    }

    @Override
    public void renderComponent() {
        Button lllllllllllllllIllllIlllIIIIllII;
        Color lllllllllllllllIllllIlllIIIIlIll;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllIllllIlllIIIlIIIl = Rainbow.getColorWithOpacity(130);
        } else {
            lllllllllllllllIllllIlllIIIIlIll = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset + 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + lllllllllllllllIllllIlllIIIIllII.parent.getWidth() - 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + 11 + lllllllllllllllIllllIlllIIIIllII.offset), (int)(lllllllllllllllIllllIlllIIIIllII.isHovered ? (lllllllllllllllIllllIlllIIIIllII.mod.isEnabled() ? lllllllllllllllIllllIlllIIIIlIll.getRGB() : new Color(0, 0, 0, 130).getRGB()) : (lllllllllllllllIllllIlllIIIIllII.mod.isEnabled() ? lllllllllllllllIllllIlllIIIIlIll.getRGB() : new Color(0, 0, 0, 130).getRGB())));
        Gui.drawRect((int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + lllllllllllllllIllllIlllIIIIllII.parent.getWidth() - 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)lllllllllllllllIllllIlllIIIIllII.parent.getX(), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        Gui.drawRect((int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + lllllllllllllllIllllIlllIIIIllII.parent.getWidth() - 1), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getX() + lllllllllllllllIllllIlllIIIIllII.parent.getWidth()), (int)(lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        if (ClickGuiModule.modulealign.getValue().equals("Left")) {
            FontUtils.drawStringWithShadow(true, lllllllllllllllIllllIlllIIIIllII.mod.getName(), lllllllllllllllIllllIlllIIIIllII.parent.getX() + 2, lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset, -1);
        } else {
            ImpactPlus.CustomFont.drawCenteredStringWithShadow(lllllllllllllllIllllIlllIIIIllII.mod.getName(), lllllllllllllllIllllIlllIIIIllII.parent.getX() + 45, lllllllllllllllIllllIlllIIIIllII.parent.getY() + lllllllllllllllIllllIlllIIIIllII.offset, -1);
        }
        if (lllllllllllllllIllllIlllIIIIllII.open) {
            for (Component lllllllllllllllIllllIlllIIIlIIII : lllllllllllllllIllllIlllIIIIllII.subcomponents) {
                lllllllllllllllIllllIlllIIIlIIII.renderComponent();
            }
        }
        if (lllllllllllllllIllllIlllIIIIllII.isHovered && ClickGuiModule.description.getValue()) {
            ScaledResolution lllllllllllllllIllllIlllIIIIllll = new ScaledResolution(lllllllllllllllIllllIlllIIIIllII.mc);
            int lllllllllllllllIllllIlllIIIIlllI = lllllllllllllllIllllIlllIIIIllll.getScaledHeight();
            String lllllllllllllllIllllIlllIIIIllIl = lllllllllllllllIllllIlllIIIIllII.mod.getDescription();
            Gui.drawRect((int)0, (int)(lllllllllllllllIllllIlllIIIIlllI - 11), (int)((int)ImpactPlus.CustomFont.getStringWidth(lllllllllllllllIllllIlllIIIIllIl) + 3), (int)lllllllllllllllIllllIlllIIIIlllI, (int)new Color(0, 0, 0, 130).getRGB());
            ImpactPlus.CustomFont.drawStringWithShadow(lllllllllllllllIllllIlllIIIIllIl, 1.0f, lllllllllllllllIllllIlllIIIIlllI - 11 - 1, -1);
        }
    }

    @Override
    public void keyTyped(char lllllllllllllllIllllIllIllIIlIll, int lllllllllllllllIllllIllIllIIlIlI) {
        Button lllllllllllllllIllllIllIllIIlIIl;
        for (Component lllllllllllllllIllllIllIllIIllIl : lllllllllllllllIllllIllIllIIlIIl.subcomponents) {
            lllllllllllllllIllllIllIllIIllIl.keyTyped(lllllllllllllllIllllIllIllIIlIll, lllllllllllllllIllllIllIllIIlIlI);
        }
    }
}

