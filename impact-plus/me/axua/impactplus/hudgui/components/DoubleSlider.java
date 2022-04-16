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

public class DoubleSlider
extends Component {
    private /* synthetic */ int x;
    private /* synthetic */ Setting.d set;
    private /* synthetic */ double renderWidth;
    private /* synthetic */ Button parent;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int offset;
    private /* synthetic */ boolean dragging;
    private /* synthetic */ int y;

    @Override
    public void mouseReleased(int lllllllllllllllIlllIIIIlIIlIllII, int lllllllllllllllIlllIIIIlIIlIlIll, int lllllllllllllllIlllIIIIlIIlIlIlI) {
        lllllllllllllllIlllIIIIlIIlIlIIl.dragging = false;
    }

    @Override
    public void setOff(int lllllllllllllllIlllIIIIlIlIllIIl) {
        lllllllllllllllIlllIIIIlIlIllIlI.offset = lllllllllllllllIlllIIIIlIlIllIIl;
    }

    public boolean isMouseOnButtonD(int lllllllllllllllIlllIIIIlIIIlIllI, int lllllllllllllllIlllIIIIlIIIlIlII) {
        DoubleSlider lllllllllllllllIlllIIIIlIIIlIIll;
        return lllllllllllllllIlllIIIIlIIIlIllI > lllllllllllllllIlllIIIIlIIIlIIll.x && lllllllllllllllIlllIIIIlIIIlIllI < lllllllllllllllIlllIIIIlIIIlIIll.x + (lllllllllllllllIlllIIIIlIIIlIIll.parent.parent.getWidth() / 2 + 1) && lllllllllllllllIlllIIIIlIIIlIlII > lllllllllllllllIlllIIIIlIIIlIIll.y && lllllllllllllllIlllIIIIlIIIlIlII < lllllllllllllllIlllIIIIlIIIlIIll.y + 11;
    }

    public boolean isMouseOnButtonI(int lllllllllllllllIlllIIIIlIIIIIlIl, int lllllllllllllllIlllIIIIlIIIIIIlI) {
        DoubleSlider lllllllllllllllIlllIIIIlIIIIlIII;
        return lllllllllllllllIlllIIIIlIIIIIlIl > lllllllllllllllIlllIIIIlIIIIlIII.x + lllllllllllllllIlllIIIIlIIIIlIII.parent.parent.getWidth() / 2 && lllllllllllllllIlllIIIIlIIIIIlIl < lllllllllllllllIlllIIIIlIIIIlIII.x + lllllllllllllllIlllIIIIlIIIIlIII.parent.parent.getWidth() && lllllllllllllllIlllIIIIlIIIIIIlI > lllllllllllllllIlllIIIIlIIIIlIII.y && lllllllllllllllIlllIIIIlIIIIIIlI < lllllllllllllllIlllIIIIlIIIIlIII.y + 11;
    }

    public DoubleSlider(Setting.d lllllllllllllllIlllIIIlIIlIIlllI, Button lllllllllllllllIlllIIIlIIlIIllIl, int lllllllllllllllIlllIIIlIIlIlIIII) {
        DoubleSlider lllllllllllllllIlllIIIlIIlIlIIll;
        lllllllllllllllIlllIIIlIIlIlIIll.dragging = false;
        lllllllllllllllIlllIIIlIIlIlIIll.set = lllllllllllllllIlllIIIlIIlIIlllI;
        lllllllllllllllIlllIIIlIIlIlIIll.parent = lllllllllllllllIlllIIIlIIlIIllIl;
        lllllllllllllllIlllIIIlIIlIlIIll.x = lllllllllllllllIlllIIIlIIlIIllIl.parent.getX() + lllllllllllllllIlllIIIlIIlIIllIl.parent.getWidth();
        lllllllllllllllIlllIIIlIIlIlIIll.y = lllllllllllllllIlllIIIlIIlIIllIl.parent.getY() + lllllllllllllllIlllIIIlIIlIIllIl.offset;
        lllllllllllllllIlllIIIlIIlIlIIll.offset = lllllllllllllllIlllIIIlIIlIlIIII;
    }

    private static double roundToPlace(double lllllllllllllllIlllIIIIlIlIIIIII, int lllllllllllllllIlllIIIIlIIllllll) {
        if (lllllllllllllllIlllIIIIlIIllllll < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllllIlllIIIIlIIlllllI = new BigDecimal(lllllllllllllllIlllIIIIlIlIIIIII);
        lllllllllllllllIlllIIIIlIIlllllI = lllllllllllllllIlllIIIIlIIlllllI.setScale(lllllllllllllllIlllIIIIlIIllllll, RoundingMode.HALF_UP);
        return lllllllllllllllIlllIIIIlIIlllllI.doubleValue();
    }

    @Override
    public void updateComponent(int lllllllllllllllIlllIIIIlIlIIllll, int lllllllllllllllIlllIIIIlIlIIlIII) {
        DoubleSlider lllllllllllllllIlllIIIIlIlIlIIII;
        lllllllllllllllIlllIIIIlIlIlIIII.hovered = lllllllllllllllIlllIIIIlIlIlIIII.isMouseOnButtonD(lllllllllllllllIlllIIIIlIlIIllll, lllllllllllllllIlllIIIIlIlIIlIII) || lllllllllllllllIlllIIIIlIlIlIIII.isMouseOnButtonI(lllllllllllllllIlllIIIIlIlIIllll, lllllllllllllllIlllIIIIlIlIIlIII);
        lllllllllllllllIlllIIIIlIlIlIIII.y = lllllllllllllllIlllIIIIlIlIlIIII.parent.parent.getY() + lllllllllllllllIlllIIIIlIlIlIIII.offset;
        lllllllllllllllIlllIIIIlIlIlIIII.x = lllllllllllllllIlllIIIIlIlIlIIII.parent.parent.getX() + 4;
        double lllllllllllllllIlllIIIIlIlIIllIl = Math.min(85, Math.max(0, lllllllllllllllIlllIIIIlIlIIllll - lllllllllllllllIlllIIIIlIlIlIIII.x));
        double lllllllllllllllIlllIIIIlIlIIllII = lllllllllllllllIlllIIIIlIlIlIIII.set.getMin();
        double lllllllllllllllIlllIIIIlIlIIlIll = lllllllllllllllIlllIIIIlIlIlIIII.set.getMax();
        lllllllllllllllIlllIIIIlIlIlIIII.renderWidth = 85.0 * (lllllllllllllllIlllIIIIlIlIlIIII.set.getValue() - lllllllllllllllIlllIIIIlIlIIllII) / (lllllllllllllllIlllIIIIlIlIIlIll - lllllllllllllllIlllIIIIlIlIIllII);
        if (lllllllllllllllIlllIIIIlIlIlIIII.dragging) {
            if (lllllllllllllllIlllIIIIlIlIIllIl == 0.0) {
                lllllllllllllllIlllIIIIlIlIlIIII.set.setValue(lllllllllllllllIlllIIIIlIlIlIIII.set.getMin());
            } else {
                double lllllllllllllllIlllIIIIlIlIlIIIl = DoubleSlider.roundToPlace(lllllllllllllllIlllIIIIlIlIIllIl / 85.0 * (lllllllllllllllIlllIIIIlIlIIlIll - lllllllllllllllIlllIIIIlIlIIllII) + lllllllllllllllIlllIIIIlIlIIllII, 2);
                lllllllllllllllIlllIIIIlIlIlIIII.set.setValue(lllllllllllllllIlllIIIIlIlIlIIIl);
            }
        }
    }

    @Override
    public void renderComponent() {
        DoubleSlider lllllllllllllllIlllIIIIlIllIIllI;
        Color lllllllllllllllIlllIIIIlIllIIlIl;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllIlllIIIIlIllIIlll = Rainbow.getColorWithOpacity(130);
        } else {
            lllllllllllllllIlllIIIIlIllIIlIl = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        int lllllllllllllllIlllIIIIlIllIIlII = (int)((double)lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + lllllllllllllllIlllIIIIlIllIIllI.renderWidth);
        Gui.drawRect((int)(lllllllllllllllIlllIIIIlIllIIlII + 4), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 1), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getWidth() - 1), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 11), (int)(lllllllllllllllIlllIIIIlIllIIllI.hovered ? new Color(0, 0, 0, 160).getRGB() : new Color(0, 0, 0, 120).getRGB()));
        Gui.drawRect((int)lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX(), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + 2), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + 2), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + 4), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getWidth() - 1), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getWidth()), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        double lllllllllllllllIlllIIIIlIllIIIll = lllllllllllllllIlllIIIIlIllIIllI.set.getValue() / lllllllllllllllIlllIIIIlIllIIllI.set.getMax() * (double)lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getWidth();
        Gui.drawRect((int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + 4), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 1), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + (int)lllllllllllllllIlllIIIIlIllIIllI.renderWidth + 4), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 11), (int)(lllllllllllllllIlllIIIIlIllIIllI.hovered ? lllllllllllllllIlllIIIIlIllIIlIl.getRGB() : lllllllllllllllIlllIIIIlIllIIlIl.getRGB()));
        Gui.drawRect((int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + 4), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getWidth() - 1), (int)(lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(lllllllllllllllIlllIIIIlIllIIllI.set.getName()).append(" ").append(ChatFormatting.GRAY).append(lllllllllllllllIlllIIIIlIllIIllI.set.getValue())), lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getX() + 7, lllllllllllllllIlllIIIIlIllIIllI.parent.parent.getY() + lllllllllllllllIlllIIIIlIllIIllI.offset, -1);
    }

    @Override
    public void mouseClicked(int lllllllllllllllIlllIIIIlIIllIlIl, int lllllllllllllllIlllIIIIlIIllIlII, int lllllllllllllllIlllIIIIlIIllIIll) {
        DoubleSlider lllllllllllllllIlllIIIIlIIllIllI;
        if (lllllllllllllllIlllIIIIlIIllIllI.isMouseOnButtonD(lllllllllllllllIlllIIIIlIIllIlIl, lllllllllllllllIlllIIIIlIIllIlII) && lllllllllllllllIlllIIIIlIIllIIll == 0 && lllllllllllllllIlllIIIIlIIllIllI.parent.open) {
            lllllllllllllllIlllIIIIlIIllIllI.dragging = true;
        }
        if (lllllllllllllllIlllIIIIlIIllIllI.isMouseOnButtonI(lllllllllllllllIlllIIIIlIIllIlIl, lllllllllllllllIlllIIIIlIIllIlII) && lllllllllllllllIlllIIIIlIIllIIll == 0 && lllllllllllllllIlllIIIIlIIllIllI.parent.open) {
            lllllllllllllllIlllIIIIlIIllIllI.dragging = true;
        }
    }
}

