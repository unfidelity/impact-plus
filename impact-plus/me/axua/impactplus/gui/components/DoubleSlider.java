/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.gui.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.components.Button;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;

public class DoubleSlider
extends Component {
    private /* synthetic */ Button parent;
    private /* synthetic */ int y;
    private /* synthetic */ int x;
    private /* synthetic */ Setting.d set;
    private /* synthetic */ double renderWidth;
    private /* synthetic */ boolean dragging;
    private /* synthetic */ int offset;
    private /* synthetic */ boolean hovered;

    public DoubleSlider(Setting.d lllllllllllllllIlllllllIlIIlIlll, Button lllllllllllllllIlllllllIlIIlIllI, int lllllllllllllllIlllllllIlIIlIlIl) {
        DoubleSlider lllllllllllllllIlllllllIlIIlIlII;
        lllllllllllllllIlllllllIlIIlIlII.dragging = false;
        lllllllllllllllIlllllllIlIIlIlII.set = lllllllllllllllIlllllllIlIIlIlll;
        lllllllllllllllIlllllllIlIIlIlII.parent = lllllllllllllllIlllllllIlIIlIllI;
        lllllllllllllllIlllllllIlIIlIlII.x = lllllllllllllllIlllllllIlIIlIllI.parent.getX() + lllllllllllllllIlllllllIlIIlIllI.parent.getWidth();
        lllllllllllllllIlllllllIlIIlIlII.y = lllllllllllllllIlllllllIlIIlIllI.parent.getY() + lllllllllllllllIlllllllIlIIlIllI.offset;
        lllllllllllllllIlllllllIlIIlIlII.offset = lllllllllllllllIlllllllIlIIlIlIl;
    }

    public boolean isMouseOnButtonI(int lllllllllllllllIlllllllIIlIIIIII, int lllllllllllllllIlllllllIIIllllII) {
        DoubleSlider lllllllllllllllIlllllllIIIlllllI;
        return lllllllllllllllIlllllllIIlIIIIII > lllllllllllllllIlllllllIIIlllllI.x + lllllllllllllllIlllllllIIIlllllI.parent.parent.getWidth() / 2 && lllllllllllllllIlllllllIIlIIIIII < lllllllllllllllIlllllllIIIlllllI.x + lllllllllllllllIlllllllIIIlllllI.parent.parent.getWidth() && lllllllllllllllIlllllllIIIllllII > lllllllllllllllIlllllllIIIlllllI.y && lllllllllllllllIlllllllIIIllllII < lllllllllllllllIlllllllIIIlllllI.y + 11;
    }

    @Override
    public void renderComponent() {
        DoubleSlider lllllllllllllllIlllllllIlIIIlIll;
        Color lllllllllllllllIlllllllIlIIIlIlI;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllIlllllllIlIIIllII = Rainbow.getColorWithOpacity(130);
        } else {
            lllllllllllllllIlllllllIlIIIlIlI = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        int lllllllllllllllIlllllllIlIIIlIIl = (int)((double)lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + lllllllllllllllIlllllllIlIIIlIll.renderWidth);
        Gui.drawRect((int)(lllllllllllllllIlllllllIlIIIlIIl + 4), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 1), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + lllllllllllllllIlllllllIlIIIlIll.parent.parent.getWidth() - 1), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 11), (int)(lllllllllllllllIlllllllIlIIIlIll.hovered ? new Color(0, 0, 0, 160).getRGB() : new Color(0, 0, 0, 120).getRGB()));
        Gui.drawRect((int)lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX(), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + 2), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + 2), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + 4), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + lllllllllllllllIlllllllIlIIIlIll.parent.parent.getWidth() - 1), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + lllllllllllllllIlllllllIlIIIlIll.parent.parent.getWidth()), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        double lllllllllllllllIlllllllIlIIIlIII = lllllllllllllllIlllllllIlIIIlIll.set.getValue() / lllllllllllllllIlllllllIlIIIlIll.set.getMax() * (double)lllllllllllllllIlllllllIlIIIlIll.parent.parent.getWidth();
        Gui.drawRect((int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + 4), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 1), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + (int)lllllllllllllllIlllllllIlIIIlIll.renderWidth + 4), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 11), (int)(lllllllllllllllIlllllllIlIIIlIll.hovered ? lllllllllllllllIlllllllIlIIIlIlI.getRGB() : lllllllllllllllIlllllllIlIIIlIlI.getRGB()));
        Gui.drawRect((int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + 4), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + lllllllllllllllIlllllllIlIIIlIll.parent.parent.getWidth() - 1), (int)(lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(lllllllllllllllIlllllllIlIIIlIll.set.getName()).append(" ").append(ChatFormatting.GRAY).append(lllllllllllllllIlllllllIlIIIlIll.set.getValue())), lllllllllllllllIlllllllIlIIIlIll.parent.parent.getX() + 7, lllllllllllllllIlllllllIlIIIlIll.parent.parent.getY() + lllllllllllllllIlllllllIlIIIlIll.offset, -1);
    }

    @Override
    public void setOff(int lllllllllllllllIlllllllIIllllllI) {
        lllllllllllllllIlllllllIlIIIIIIl.offset = lllllllllllllllIlllllllIIllllllI;
    }

    @Override
    public void mouseClicked(int lllllllllllllllIlllllllIIlIllIlI, int lllllllllllllllIlllllllIIlIlIlIl, int lllllllllllllllIlllllllIIlIlIlII) {
        DoubleSlider lllllllllllllllIlllllllIIlIlIlll;
        if (lllllllllllllllIlllllllIIlIlIlll.isMouseOnButtonD(lllllllllllllllIlllllllIIlIllIlI, lllllllllllllllIlllllllIIlIlIlIl) && lllllllllllllllIlllllllIIlIlIlII == 0 && lllllllllllllllIlllllllIIlIlIlll.parent.open) {
            lllllllllllllllIlllllllIIlIlIlll.dragging = true;
        }
        if (lllllllllllllllIlllllllIIlIlIlll.isMouseOnButtonI(lllllllllllllllIlllllllIIlIllIlI, lllllllllllllllIlllllllIIlIlIlIl) && lllllllllllllllIlllllllIIlIlIlII == 0 && lllllllllllllllIlllllllIIlIlIlll.parent.open) {
            lllllllllllllllIlllllllIIlIlIlll.dragging = true;
        }
    }

    public boolean isMouseOnButtonD(int lllllllllllllllIlllllllIIlIIIllI, int lllllllllllllllIlllllllIIlIIlIII) {
        DoubleSlider lllllllllllllllIlllllllIIlIIlIlI;
        return lllllllllllllllIlllllllIIlIIIllI > lllllllllllllllIlllllllIIlIIlIlI.x && lllllllllllllllIlllllllIIlIIIllI < lllllllllllllllIlllllllIIlIIlIlI.x + (lllllllllllllllIlllllllIIlIIlIlI.parent.parent.getWidth() / 2 + 1) && lllllllllllllllIlllllllIIlIIlIII > lllllllllllllllIlllllllIIlIIlIlI.y && lllllllllllllllIlllllllIIlIIlIII < lllllllllllllllIlllllllIIlIIlIlI.y + 11;
    }

    @Override
    public void mouseReleased(int lllllllllllllllIlllllllIIlIlIIIl, int lllllllllllllllIlllllllIIlIlIIII, int lllllllllllllllIlllllllIIlIIllll) {
        lllllllllllllllIlllllllIIlIIlllI.dragging = false;
    }

    private static double roundToPlace(double lllllllllllllllIlllllllIIllIIlIl, int lllllllllllllllIlllllllIIllIIlII) {
        if (lllllllllllllllIlllllllIIllIIlII < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllllIlllllllIIllIIIll = new BigDecimal(lllllllllllllllIlllllllIIllIIlIl);
        lllllllllllllllIlllllllIIllIIIll = lllllllllllllllIlllllllIIllIIIll.setScale(lllllllllllllllIlllllllIIllIIlII, RoundingMode.HALF_UP);
        return lllllllllllllllIlllllllIIllIIIll.doubleValue();
    }

    @Override
    public void updateComponent(int lllllllllllllllIlllllllIIllIlllI, int lllllllllllllllIlllllllIIlllIIll) {
        DoubleSlider lllllllllllllllIlllllllIIllIllll;
        lllllllllllllllIlllllllIIllIllll.hovered = lllllllllllllllIlllllllIIllIllll.isMouseOnButtonD(lllllllllllllllIlllllllIIllIlllI, lllllllllllllllIlllllllIIlllIIll) || lllllllllllllllIlllllllIIllIllll.isMouseOnButtonI(lllllllllllllllIlllllllIIllIlllI, lllllllllllllllIlllllllIIlllIIll);
        lllllllllllllllIlllllllIIllIllll.y = lllllllllllllllIlllllllIIllIllll.parent.parent.getY() + lllllllllllllllIlllllllIIllIllll.offset;
        lllllllllllllllIlllllllIIllIllll.x = lllllllllllllllIlllllllIIllIllll.parent.parent.getX() + 4;
        double lllllllllllllllIlllllllIIlllIIlI = Math.min(85, Math.max(0, lllllllllllllllIlllllllIIllIlllI - lllllllllllllllIlllllllIIllIllll.x));
        double lllllllllllllllIlllllllIIlllIIIl = lllllllllllllllIlllllllIIllIllll.set.getMin();
        double lllllllllllllllIlllllllIIlllIIII = lllllllllllllllIlllllllIIllIllll.set.getMax();
        lllllllllllllllIlllllllIIllIllll.renderWidth = 85.0 * (lllllllllllllllIlllllllIIllIllll.set.getValue() - lllllllllllllllIlllllllIIlllIIIl) / (lllllllllllllllIlllllllIIlllIIII - lllllllllllllllIlllllllIIlllIIIl);
        if (lllllllllllllllIlllllllIIllIllll.dragging) {
            if (lllllllllllllllIlllllllIIlllIIlI == 0.0) {
                lllllllllllllllIlllllllIIllIllll.set.setValue(lllllllllllllllIlllllllIIllIllll.set.getMin());
            } else {
                double lllllllllllllllIlllllllIIlllIllI = DoubleSlider.roundToPlace(lllllllllllllllIlllllllIIlllIIlI / 85.0 * (lllllllllllllllIlllllllIIlllIIII - lllllllllllllllIlllllllIIlllIIIl) + lllllllllllllllIlllllllIIlllIIIl, 2);
                lllllllllllllllIlllllllIIllIllll.set.setValue(lllllllllllllllIlllllllIIlllIllI);
            }
        }
    }
}

