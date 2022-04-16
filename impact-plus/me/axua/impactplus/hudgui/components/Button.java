/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.axua.impactplus.hudgui.components;

import java.awt.Color;
import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.Frame;
import me.axua.impactplus.hudgui.components.CheckBox;
import me.axua.impactplus.hudgui.components.DoubleSlider;
import me.axua.impactplus.hudgui.components.IntSlider;
import me.axua.impactplus.hudgui.components.ModeButton;
import me.axua.impactplus.hudgui.components.StringButton;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class Button
extends Component {
    public /* synthetic */ int offset;
    public /* synthetic */ boolean open;
    private /* synthetic */ int height;
    private /* synthetic */ ArrayList<Component> subcomponents;
    public /* synthetic */ Frame parent;
    public /* synthetic */ Module mod;
    private /* synthetic */ boolean isHovered;
    /* synthetic */ int yy;
    /* synthetic */ int xx;

    @Override
    public int getHeight() {
        Button llllllllllllllllllIIIIIlIlIlIlIl;
        if (llllllllllllllllllIIIIIlIlIlIlIl.open) {
            return 11 * (llllllllllllllllllIIIIIlIlIlIlIl.subcomponents.size() + 1);
        }
        return 11;
    }

    @Override
    public void mouseClicked(int llllllllllllllllllIIIIIlIIllllIl, int llllllllllllllllllIIIIIlIIllllII, int llllllllllllllllllIIIIIlIIllIlll) {
        Button llllllllllllllllllIIIIIlIIlllllI;
        if (llllllllllllllllllIIIIIlIIlllllI.isMouseOnButton(llllllllllllllllllIIIIIlIIllllIl, llllllllllllllllllIIIIIlIIllllII) && llllllllllllllllllIIIIIlIIllIlll == 0) {
            llllllllllllllllllIIIIIlIIlllllI.mod.toggle();
        }
        if (llllllllllllllllllIIIIIlIIlllllI.isMouseOnButton(llllllllllllllllllIIIIIlIIllllIl, llllllllllllllllllIIIIIlIIllllII) && llllllllllllllllllIIIIIlIIllIlll == 1) {
            llllllllllllllllllIIIIIlIIlllllI.open = !llllllllllllllllllIIIIIlIIlllllI.open;
            llllllllllllllllllIIIIIlIIlllllI.parent.refresh();
        }
        for (Component llllllllllllllllllIIIIIlIIllllll : llllllllllllllllllIIIIIlIIlllllI.subcomponents) {
            llllllllllllllllllIIIIIlIIllllll.mouseClicked(llllllllllllllllllIIIIIlIIllllIl, llllllllllllllllllIIIIIlIIllllII, llllllllllllllllllIIIIIlIIllIlll);
        }
    }

    public boolean isMouseOnButton(int llllllllllllllllllIIIIIlIIIIlllI, int llllllllllllllllllIIIIIlIIIlIIII) {
        Button llllllllllllllllllIIIIIlIIIIllll;
        return llllllllllllllllllIIIIIlIIIIlllI > llllllllllllllllllIIIIIlIIIIllll.parent.getX() && llllllllllllllllllIIIIIlIIIIlllI < llllllllllllllllllIIIIIlIIIIllll.parent.getX() + llllllllllllllllllIIIIIlIIIIllll.parent.getWidth() && llllllllllllllllllIIIIIlIIIlIIII > llllllllllllllllllIIIIIlIIIIllll.parent.getY() + llllllllllllllllllIIIIIlIIIIllll.offset && llllllllllllllllllIIIIIlIIIlIIII < llllllllllllllllllIIIIIlIIIIllll.parent.getY() + 11 + llllllllllllllllllIIIIIlIIIIllll.offset;
    }

    @Override
    public void mouseReleased(int llllllllllllllllllIIIIIlIIlIllII, int llllllllllllllllllIIIIIlIIlIlIll, int llllllllllllllllllIIIIIlIIlIlIlI) {
        Button llllllllllllllllllIIIIIlIIlIlIIl;
        for (Component llllllllllllllllllIIIIIlIIlIlllI : llllllllllllllllllIIIIIlIIlIlIIl.subcomponents) {
            llllllllllllllllllIIIIIlIIlIlllI.mouseReleased(llllllllllllllllllIIIIIlIIlIllII, llllllllllllllllllIIIIIlIIlIlIll, llllllllllllllllllIIIIIlIIlIlIlI);
        }
    }

    public Button(Module llllllllllllllllllIIIIIlIllllIll, Frame llllllllllllllllllIIIIIlIlllllll, int llllllllllllllllllIIIIIlIllllIIl) {
        Button llllllllllllllllllIIIIIllIIIIIIl;
        llllllllllllllllllIIIIIllIIIIIIl.mod = llllllllllllllllllIIIIIlIllllIll;
        llllllllllllllllllIIIIIllIIIIIIl.parent = llllllllllllllllllIIIIIlIlllllll;
        llllllllllllllllllIIIIIllIIIIIIl.offset = llllllllllllllllllIIIIIlIllllIIl;
        llllllllllllllllllIIIIIllIIIIIIl.subcomponents = new ArrayList();
        llllllllllllllllllIIIIIllIIIIIIl.open = false;
        llllllllllllllllllIIIIIllIIIIIIl.height = 11;
        int llllllllllllllllllIIIIIlIlllllIl = llllllllllllllllllIIIIIlIllllIIl + 11;
        if (ImpactPlus.getInstance().settingsManager.getSettingsForMod(llllllllllllllllllIIIIIlIllllIll) != null && !ImpactPlus.getInstance().settingsManager.getSettingsForMod(llllllllllllllllllIIIIIlIllllIll).isEmpty()) {
            block7: for (Setting llllllllllllllllllIIIIIllIIIIIlI : ImpactPlus.getInstance().settingsManager.getSettingsForMod(llllllllllllllllllIIIIIlIllllIll)) {
                switch (llllllllllllllllllIIIIIllIIIIIlI.getType()) {
                    case MODE: {
                        llllllllllllllllllIIIIIllIIIIIIl.subcomponents.add(new ModeButton((Setting.mode)llllllllllllllllllIIIIIllIIIIIlI, llllllllllllllllllIIIIIllIIIIIIl, llllllllllllllllllIIIIIlIllllIll, llllllllllllllllllIIIIIlIlllllIl));
                        llllllllllllllllllIIIIIlIlllllIl += 11;
                        continue block7;
                    }
                    case STRING: {
                        llllllllllllllllllIIIIIllIIIIIIl.subcomponents.add(new StringButton((Setting.s)llllllllllllllllllIIIIIllIIIIIlI, llllllllllllllllllIIIIIllIIIIIIl, llllllllllllllllllIIIIIlIlllllIl));
                        llllllllllllllllllIIIIIlIlllllIl += 11;
                        continue block7;
                    }
                    case BOOLEAN: {
                        llllllllllllllllllIIIIIllIIIIIIl.subcomponents.add(new CheckBox((Setting.b)llllllllllllllllllIIIIIllIIIIIlI, llllllllllllllllllIIIIIllIIIIIIl, llllllllllllllllllIIIIIlIlllllIl));
                        llllllllllllllllllIIIIIlIlllllIl += 11;
                        continue block7;
                    }
                    case DOUBLE: {
                        llllllllllllllllllIIIIIllIIIIIIl.subcomponents.add(new DoubleSlider((Setting.d)llllllllllllllllllIIIIIllIIIIIlI, llllllllllllllllllIIIIIllIIIIIIl, llllllllllllllllllIIIIIlIlllllIl));
                        llllllllllllllllllIIIIIlIlllllIl += 11;
                        continue block7;
                    }
                    case INT: {
                        llllllllllllllllllIIIIIllIIIIIIl.subcomponents.add(new IntSlider((Setting.i)llllllllllllllllllIIIIIllIIIIIlI, llllllllllllllllllIIIIIllIIIIIIl, llllllllllllllllllIIIIIlIlllllIl));
                        llllllllllllllllllIIIIIlIlllllIl += 11;
                        continue block7;
                    }
                }
            }
        }
    }

    @Override
    public void renderComponent() {
        Button llllllllllllllllllIIIIIlIlIlllIl;
        Color llllllllllllllllllIIIIIlIlIlllII;
        if (ClickGuiModule.rainbow.getValue()) {
            Color llllllllllllllllllIIIIIlIllIIIlI = Rainbow.getColorWithOpacity(130);
        } else {
            llllllllllllllllllIIIIIlIlIlllII = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset + 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + llllllllllllllllllIIIIIlIlIlllIl.parent.getWidth() - 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + 11 + llllllllllllllllllIIIIIlIlIlllIl.offset), (int)(llllllllllllllllllIIIIIlIlIlllIl.isHovered ? (llllllllllllllllllIIIIIlIlIlllIl.mod.isEnabled() ? llllllllllllllllllIIIIIlIlIlllII.getRGB() : new Color(0, 0, 0, 130).getRGB()) : (llllllllllllllllllIIIIIlIlIlllIl.mod.isEnabled() ? llllllllllllllllllIIIIIlIlIlllII.getRGB() : new Color(0, 0, 0, 130).getRGB())));
        Gui.drawRect((int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + llllllllllllllllllIIIIIlIlIlllIl.parent.getWidth() - 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)llllllllllllllllllIIIIIlIlIlllIl.parent.getX(), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        Gui.drawRect((int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + llllllllllllllllllIIIIIlIlIlllIl.parent.getWidth() - 1), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + llllllllllllllllllIIIIIlIlIlllIl.parent.getWidth()), (int)(llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        if (ClickGuiModule.modulealign.getValue().equals("Left")) {
            FontUtils.drawStringWithShadow(true, llllllllllllllllllIIIIIlIlIlllIl.mod.getName(), llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + 2, llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset, -1);
        } else {
            ImpactPlus.CustomFont.drawCenteredStringWithShadow(llllllllllllllllllIIIIIlIlIlllIl.mod.getName(), llllllllllllllllllIIIIIlIlIlllIl.parent.getX() + 45, llllllllllllllllllIIIIIlIlIlllIl.parent.getY() + llllllllllllllllllIIIIIlIlIlllIl.offset, -1);
        }
        if (llllllllllllllllllIIIIIlIlIlllIl.open) {
            for (Component llllllllllllllllllIIIIIlIllIIIIl : llllllllllllllllllIIIIIlIlIlllIl.subcomponents) {
                llllllllllllllllllIIIIIlIllIIIIl.renderComponent();
            }
        }
        if (llllllllllllllllllIIIIIlIlIlllIl.isHovered && ClickGuiModule.description.getValue()) {
            ScaledResolution llllllllllllllllllIIIIIlIllIIIII = new ScaledResolution(llllllllllllllllllIIIIIlIlIlllIl.mc);
            int llllllllllllllllllIIIIIlIlIlllll = llllllllllllllllllIIIIIlIllIIIII.getScaledHeight();
            String llllllllllllllllllIIIIIlIlIllllI = llllllllllllllllllIIIIIlIlIlllIl.mod.getDescription();
            Gui.drawRect((int)0, (int)(llllllllllllllllllIIIIIlIlIlllll - 11), (int)((int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllllIIIIIlIlIllllI) + 3), (int)llllllllllllllllllIIIIIlIlIlllll, (int)new Color(0, 0, 0, 130).getRGB());
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllllIIIIIlIlIllllI, 1.0f, llllllllllllllllllIIIIIlIlIlllll - 11 - 1, -1);
        }
    }

    @Override
    public void setOff(int llllllllllllllllllIIIIIlIllIlllI) {
        Button llllllllllllllllllIIIIIlIllIllII;
        llllllllllllllllllIIIIIlIllIllII.offset = llllllllllllllllllIIIIIlIllIlllI;
        int llllllllllllllllllIIIIIlIllIllIl = llllllllllllllllllIIIIIlIllIllII.offset + 11;
        for (Component llllllllllllllllllIIIIIlIlllIIII : llllllllllllllllllIIIIIlIllIllII.subcomponents) {
            llllllllllllllllllIIIIIlIlllIIII.setOff(llllllllllllllllllIIIIIlIllIllIl);
            llllllllllllllllllIIIIIlIllIllIl += 11;
        }
    }

    @Override
    public void keyTyped(char llllllllllllllllllIIIIIlIIIlllII, int llllllllllllllllllIIIIIlIIIllIII) {
        Button llllllllllllllllllIIIIIlIIIllIlI;
        for (Component llllllllllllllllllIIIIIlIIIllllI : llllllllllllllllllIIIIIlIIIllIlI.subcomponents) {
            llllllllllllllllllIIIIIlIIIllllI.keyTyped(llllllllllllllllllIIIIIlIIIlllII, llllllllllllllllllIIIIIlIIIllIII);
        }
    }

    @Override
    public void updateComponent(int llllllllllllllllllIIIIIlIlIIlIIl, int llllllllllllllllllIIIIIlIlIIlIll) {
        Button llllllllllllllllllIIIIIlIlIIlIlI;
        llllllllllllllllllIIIIIlIlIIlIlI.xx = llllllllllllllllllIIIIIlIlIIlIIl + 10;
        llllllllllllllllllIIIIIlIlIIlIlI.yy = llllllllllllllllllIIIIIlIlIIlIll - 5;
        llllllllllllllllllIIIIIlIlIIlIlI.isHovered = llllllllllllllllllIIIIIlIlIIlIlI.isMouseOnButton(llllllllllllllllllIIIIIlIlIIlIIl, llllllllllllllllllIIIIIlIlIIlIll);
        if (!llllllllllllllllllIIIIIlIlIIlIlI.subcomponents.isEmpty()) {
            for (Component llllllllllllllllllIIIIIlIlIIlllI : llllllllllllllllllIIIIIlIlIIlIlI.subcomponents) {
                llllllllllllllllllIIIIIlIlIIlllI.updateComponent(llllllllllllllllllIIIIIlIlIIlIIl, llllllllllllllllllIIIIIlIlIIlIll);
            }
        }
    }
}

