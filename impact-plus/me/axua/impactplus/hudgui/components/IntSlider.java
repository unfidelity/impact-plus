/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.hudgui.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.components.Button;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;

public class IntSlider
extends Component {
    private /* synthetic */ boolean dragging;
    private /* synthetic */ double renderWidth;
    private /* synthetic */ int offset;
    private /* synthetic */ Button parent;
    private /* synthetic */ int x;
    private /* synthetic */ Setting.i set;
    private /* synthetic */ int y;
    private /* synthetic */ boolean hovered;

    public boolean isMouseOnButtonD(int llllllllllllllllIlllIIIlIlIIlllI, int llllllllllllllllIlllIIIlIlIIllIl) {
        IntSlider llllllllllllllllIlllIIIlIlIIllll;
        return llllllllllllllllIlllIIIlIlIIlllI > llllllllllllllllIlllIIIlIlIIllll.x && llllllllllllllllIlllIIIlIlIIlllI < llllllllllllllllIlllIIIlIlIIllll.x + (llllllllllllllllIlllIIIlIlIIllll.parent.parent.getWidth() / 2 + 1) && llllllllllllllllIlllIIIlIlIIllIl > llllllllllllllllIlllIIIlIlIIllll.y && llllllllllllllllIlllIIIlIlIIllIl < llllllllllllllllIlllIIIlIlIIllll.y + 11;
    }

    @Override
    public void renderComponent() {
        IntSlider llllllllllllllllIlllIIIllIlIlIII;
        Color llllllllllllllllIlllIIIllIlIlIll;
        if (ClickGuiModule.rainbow.getValue()) {
            Color llllllllllllllllIlllIIIllIlIllIl = Rainbow.getColorWithOpacity(130);
        } else {
            llllllllllllllllIlllIIIllIlIlIll = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        int llllllllllllllllIlllIIIllIlIlIlI = (int)((double)llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + llllllllllllllllIlllIIIllIlIlIII.renderWidth);
        Gui.drawRect((int)(llllllllllllllllIlllIIIllIlIlIlI + 4), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 1), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + llllllllllllllllIlllIIIllIlIlIII.parent.parent.getWidth() - 1), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 11), (int)(llllllllllllllllIlllIIIllIlIlIII.hovered ? new Color(0, 0, 0, 145).getRGB() : new Color(0, 0, 0, 120).getRGB()));
        Gui.drawRect((int)llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX(), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + 2), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + 2), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + 4), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + llllllllllllllllIlllIIIllIlIlIII.parent.parent.getWidth() - 1), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + llllllllllllllllIlllIIIllIlIlIII.parent.parent.getWidth()), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        int llllllllllllllllIlllIIIllIlIlIIl = llllllllllllllllIlllIIIllIlIlIII.set.getValue() / llllllllllllllllIlllIIIllIlIlIII.set.getMax() * llllllllllllllllIlllIIIllIlIlIII.parent.parent.getWidth();
        Gui.drawRect((int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + 4), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 1), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + (int)llllllllllllllllIlllIIIllIlIlIII.renderWidth + 4), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 11), (int)(llllllllllllllllIlllIIIllIlIlIII.hovered ? llllllllllllllllIlllIIIllIlIlIll.getRGB() : llllllllllllllllIlllIIIllIlIlIll.getRGB()));
        Gui.drawRect((int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + 4), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + llllllllllllllllIlllIIIllIlIlIII.parent.parent.getWidth() - 1), (int)(llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(llllllllllllllllIlllIIIllIlIlIII.set.getName()).append(" ").append(ChatFormatting.GRAY).append(llllllllllllllllIlllIIIllIlIlIII.set.getValue())), llllllllllllllllIlllIIIllIlIlIII.parent.parent.getX() + 7, llllllllllllllllIlllIIIllIlIlIII.parent.parent.getY() + llllllllllllllllIlllIIIllIlIlIII.offset, -1);
    }

    private static double roundToPlace(double llllllllllllllllIlllIIIlIllIlIIl, int llllllllllllllllIlllIIIlIllIllIl) {
        if (llllllllllllllllIlllIIIlIllIllIl < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal llllllllllllllllIlllIIIlIllIlIll = new BigDecimal(llllllllllllllllIlllIIIlIllIlIIl);
        llllllllllllllllIlllIIIlIllIlIll = llllllllllllllllIlllIIIlIllIlIll.setScale(llllllllllllllllIlllIIIlIllIllIl, RoundingMode.HALF_UP);
        return llllllllllllllllIlllIIIlIllIlIll.doubleValue();
    }

    @Override
    public void mouseClicked(int llllllllllllllllIlllIIIlIlIllIll, int llllllllllllllllIlllIIIlIlIllIlI, int llllllllllllllllIlllIIIlIlIlllIl) {
        IntSlider llllllllllllllllIlllIIIlIllIIIII;
        if (llllllllllllllllIlllIIIlIllIIIII.isMouseOnButtonD(llllllllllllllllIlllIIIlIlIllIll, llllllllllllllllIlllIIIlIlIllIlI) && llllllllllllllllIlllIIIlIlIlllIl == 0 && llllllllllllllllIlllIIIlIllIIIII.parent.open) {
            llllllllllllllllIlllIIIlIllIIIII.dragging = true;
        }
        if (llllllllllllllllIlllIIIlIllIIIII.isMouseOnButtonI(llllllllllllllllIlllIIIlIlIllIll, llllllllllllllllIlllIIIlIlIllIlI) && llllllllllllllllIlllIIIlIlIlllIl == 0 && llllllllllllllllIlllIIIlIllIIIII.parent.open) {
            llllllllllllllllIlllIIIlIllIIIII.dragging = true;
        }
    }

    public boolean isMouseOnButtonI(int llllllllllllllllIlllIIIlIlIIIIlI, int llllllllllllllllIlllIIIlIlIIIlII) {
        IntSlider llllllllllllllllIlllIIIlIlIIIIll;
        return llllllllllllllllIlllIIIlIlIIIIlI > llllllllllllllllIlllIIIlIlIIIIll.x + llllllllllllllllIlllIIIlIlIIIIll.parent.parent.getWidth() / 2 && llllllllllllllllIlllIIIlIlIIIIlI < llllllllllllllllIlllIIIlIlIIIIll.x + llllllllllllllllIlllIIIlIlIIIIll.parent.parent.getWidth() && llllllllllllllllIlllIIIlIlIIIlII > llllllllllllllllIlllIIIlIlIIIIll.y && llllllllllllllllIlllIIIlIlIIIlII < llllllllllllllllIlllIIIlIlIIIIll.y + 11;
    }

    @Override
    public void setOff(int llllllllllllllllIlllIIIllIIllllI) {
        llllllllllllllllIlllIIIllIIlllIl.offset = llllllllllllllllIlllIIIllIIllllI;
    }

    @Override
    public void updateComponent(int llllllllllllllllIlllIIIllIIIIlIl, int llllllllllllllllIlllIIIllIIIIlII) {
        IntSlider llllllllllllllllIlllIIIllIIIIIII;
        llllllllllllllllIlllIIIllIIIIIII.hovered = llllllllllllllllIlllIIIllIIIIIII.isMouseOnButtonD(llllllllllllllllIlllIIIllIIIIlIl, llllllllllllllllIlllIIIllIIIIlII) || llllllllllllllllIlllIIIllIIIIIII.isMouseOnButtonI(llllllllllllllllIlllIIIllIIIIlIl, llllllllllllllllIlllIIIllIIIIlII);
        llllllllllllllllIlllIIIllIIIIIII.y = llllllllllllllllIlllIIIllIIIIIII.parent.parent.getY() + llllllllllllllllIlllIIIllIIIIIII.offset;
        llllllllllllllllIlllIIIllIIIIIII.x = llllllllllllllllIlllIIIllIIIIIII.parent.parent.getX() + 4;
        double llllllllllllllllIlllIIIllIIIIIll = Math.min(85, Math.max(0, llllllllllllllllIlllIIIllIIIIlIl - llllllllllllllllIlllIIIllIIIIIII.x));
        int llllllllllllllllIlllIIIllIIIIIlI = llllllllllllllllIlllIIIllIIIIIII.set.getMin();
        int llllllllllllllllIlllIIIllIIIIIIl = llllllllllllllllIlllIIIllIIIIIII.set.getMax();
        llllllllllllllllIlllIIIllIIIIIII.renderWidth = 85 * (llllllllllllllllIlllIIIllIIIIIII.set.getValue() - llllllllllllllllIlllIIIllIIIIIlI) / (llllllllllllllllIlllIIIllIIIIIIl - llllllllllllllllIlllIIIllIIIIIlI);
        if (llllllllllllllllIlllIIIllIIIIIII.dragging) {
            if (llllllllllllllllIlllIIIllIIIIIll == 0.0) {
                llllllllllllllllIlllIIIllIIIIIII.set.setValue(llllllllllllllllIlllIIIllIIIIIII.set.getMin());
            } else {
                int llllllllllllllllIlllIIIllIIIlIIl = (int)IntSlider.roundToPlace(llllllllllllllllIlllIIIllIIIIIll / 85.0 * (double)(llllllllllllllllIlllIIIllIIIIIIl - llllllllllllllllIlllIIIllIIIIIlI) + (double)llllllllllllllllIlllIIIllIIIIIlI, 2);
                llllllllllllllllIlllIIIllIIIIIII.set.setValue(llllllllllllllllIlllIIIllIIIlIIl);
            }
        }
    }

    public IntSlider(Setting.i llllllllllllllllIlllIIIllIllIlII, Button llllllllllllllllIlllIIIllIllIIll, int llllllllllllllllIlllIIIllIllIIlI) {
        IntSlider llllllllllllllllIlllIIIllIlllIIl;
        llllllllllllllllIlllIIIllIlllIIl.dragging = false;
        llllllllllllllllIlllIIIllIlllIIl.set = llllllllllllllllIlllIIIllIllIlII;
        llllllllllllllllIlllIIIllIlllIIl.parent = llllllllllllllllIlllIIIllIllIIll;
        llllllllllllllllIlllIIIllIlllIIl.x = llllllllllllllllIlllIIIllIllIIll.parent.getX() + llllllllllllllllIlllIIIllIllIIll.parent.getWidth();
        llllllllllllllllIlllIIIllIlllIIl.y = llllllllllllllllIlllIIIllIllIIll.parent.getY() + llllllllllllllllIlllIIIllIllIIll.offset;
        llllllllllllllllIlllIIIllIlllIIl.offset = llllllllllllllllIlllIIIllIllIIlI;
    }

    @Override
    public void mouseReleased(int llllllllllllllllIlllIIIlIlIlIllI, int llllllllllllllllIlllIIIlIlIlIlIl, int llllllllllllllllIlllIIIlIlIlIlII) {
        llllllllllllllllIlllIIIlIlIlIIll.dragging = false;
    }
}

