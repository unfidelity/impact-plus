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

public class IntSlider
extends Component {
    private /* synthetic */ int x;
    private /* synthetic */ Button parent;
    private /* synthetic */ double renderWidth;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int y;
    private /* synthetic */ int offset;
    private /* synthetic */ Setting.i set;
    private /* synthetic */ boolean dragging;

    public IntSlider(Setting.i lllllllllllllllllllIlIIllIlIIIlI, Button lllllllllllllllllllIlIIllIlIIIII, int lllllllllllllllllllIlIIllIIlIlll) {
        IntSlider lllllllllllllllllllIlIIllIlIIIll;
        lllllllllllllllllllIlIIllIlIIIll.dragging = false;
        lllllllllllllllllllIlIIllIlIIIll.set = lllllllllllllllllllIlIIllIlIIIlI;
        lllllllllllllllllllIlIIllIlIIIll.parent = lllllllllllllllllllIlIIllIlIIIII;
        lllllllllllllllllllIlIIllIlIIIll.x = lllllllllllllllllllIlIIllIlIIIII.parent.getX() + lllllllllllllllllllIlIIllIlIIIII.parent.getWidth();
        lllllllllllllllllllIlIIllIlIIIll.y = lllllllllllllllllllIlIIllIlIIIII.parent.getY() + lllllllllllllllllllIlIIllIlIIIII.offset;
        lllllllllllllllllllIlIIllIlIIIll.offset = lllllllllllllllllllIlIIllIIlIlll;
    }

    private static double roundToPlace(double lllllllllllllllllllIlIIlIIIIllII, int lllllllllllllllllllIlIIlIIIIlIII) {
        if (lllllllllllllllllllIlIIlIIIIlIII < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllllllllIlIIlIIIIlIlI = new BigDecimal(lllllllllllllllllllIlIIlIIIIllII);
        lllllllllllllllllllIlIIlIIIIlIlI = lllllllllllllllllllIlIIlIIIIlIlI.setScale(lllllllllllllllllllIlIIlIIIIlIII, RoundingMode.HALF_UP);
        return lllllllllllllllllllIlIIlIIIIlIlI.doubleValue();
    }

    @Override
    public void mouseClicked(int lllllllllllllllllllIlIIIllllllIl, int lllllllllllllllllllIlIIIllllllII, int lllllllllllllllllllIlIIIllllllll) {
        IntSlider lllllllllllllllllllIlIIlIIIIIIlI;
        if (lllllllllllllllllllIlIIlIIIIIIlI.isMouseOnButtonD(lllllllllllllllllllIlIIIllllllIl, lllllllllllllllllllIlIIIllllllII) && lllllllllllllllllllIlIIIllllllll == 0 && lllllllllllllllllllIlIIlIIIIIIlI.parent.open) {
            lllllllllllllllllllIlIIlIIIIIIlI.dragging = true;
        }
        if (lllllllllllllllllllIlIIlIIIIIIlI.isMouseOnButtonI(lllllllllllllllllllIlIIIllllllIl, lllllllllllllllllllIlIIIllllllII) && lllllllllllllllllllIlIIIllllllll == 0 && lllllllllllllllllllIlIIlIIIIIIlI.parent.open) {
            lllllllllllllllllllIlIIlIIIIIIlI.dragging = true;
        }
    }

    @Override
    public void setOff(int lllllllllllllllllllIlIIlIlIIllIl) {
        lllllllllllllllllllIlIIlIlIIlllI.offset = lllllllllllllllllllIlIIlIlIIllIl;
    }

    @Override
    public void mouseReleased(int lllllllllllllllllllIlIIIlllllIII, int lllllllllllllllllllIlIIIllllIlll, int lllllllllllllllllllIlIIIllllIllI) {
        lllllllllllllllllllIlIIIllllIlIl.dragging = false;
    }

    public boolean isMouseOnButtonD(int lllllllllllllllllllIlIIIlllIllIl, int lllllllllllllllllllIlIIIlllIllll) {
        IntSlider lllllllllllllllllllIlIIIllllIIIl;
        return lllllllllllllllllllIlIIIlllIllIl > lllllllllllllllllllIlIIIllllIIIl.x && lllllllllllllllllllIlIIIlllIllIl < lllllllllllllllllllIlIIIllllIIIl.x + (lllllllllllllllllllIlIIIllllIIIl.parent.parent.getWidth() / 2 + 1) && lllllllllllllllllllIlIIIlllIllll > lllllllllllllllllllIlIIIllllIIIl.y && lllllllllllllllllllIlIIIlllIllll < lllllllllllllllllllIlIIIllllIIIl.y + 11;
    }

    @Override
    public void renderComponent() {
        IntSlider lllllllllllllllllllIlIIlIllIIlll;
        Color lllllllllllllllllllIlIIlIllIIllI;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllllllIlIIlIllIlIII = Rainbow.getColorWithOpacity(130);
        } else {
            lllllllllllllllllllIlIIlIllIIllI = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        int lllllllllllllllllllIlIIlIllIIlII = (int)((double)lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + lllllllllllllllllllIlIIlIllIIlll.renderWidth);
        Gui.drawRect((int)(lllllllllllllllllllIlIIlIllIIlII + 4), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 1), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + lllllllllllllllllllIlIIlIllIIlll.parent.parent.getWidth() - 1), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 11), (int)(lllllllllllllllllllIlIIlIllIIlll.hovered ? new Color(0, 0, 0, 145).getRGB() : new Color(0, 0, 0, 120).getRGB()));
        Gui.drawRect((int)lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX(), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + 2), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + 2), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + 4), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + lllllllllllllllllllIlIIlIllIIlll.parent.parent.getWidth() - 1), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + lllllllllllllllllllIlIIlIllIIlll.parent.parent.getWidth()), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        int lllllllllllllllllllIlIIlIllIIIll = lllllllllllllllllllIlIIlIllIIlll.set.getValue() / lllllllllllllllllllIlIIlIllIIlll.set.getMax() * lllllllllllllllllllIlIIlIllIIlll.parent.parent.getWidth();
        Gui.drawRect((int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + 4), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 1), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + (int)lllllllllllllllllllIlIIlIllIIlll.renderWidth + 4), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 11), (int)(lllllllllllllllllllIlIIlIllIIlll.hovered ? lllllllllllllllllllIlIIlIllIIllI.getRGB() : lllllllllllllllllllIlIIlIllIIllI.getRGB()));
        Gui.drawRect((int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + 4), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + lllllllllllllllllllIlIIlIllIIlll.parent.parent.getWidth() - 1), (int)(lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(lllllllllllllllllllIlIIlIllIIlll.set.getName()).append(" ").append(ChatFormatting.GRAY).append(lllllllllllllllllllIlIIlIllIIlll.set.getValue())), lllllllllllllllllllIlIIlIllIIlll.parent.parent.getX() + 7, lllllllllllllllllllIlIIlIllIIlll.parent.parent.getY() + lllllllllllllllllllIlIIlIllIIlll.offset, -1);
    }

    public boolean isMouseOnButtonI(int lllllllllllllllllllIlIIIlllIIIIl, int lllllllllllllllllllIlIIIlllIIlII) {
        IntSlider lllllllllllllllllllIlIIIlllIIlll;
        return lllllllllllllllllllIlIIIlllIIIIl > lllllllllllllllllllIlIIIlllIIlll.x + lllllllllllllllllllIlIIIlllIIlll.parent.parent.getWidth() / 2 && lllllllllllllllllllIlIIIlllIIIIl < lllllllllllllllllllIlIIIlllIIlll.x + lllllllllllllllllllIlIIIlllIIlll.parent.parent.getWidth() && lllllllllllllllllllIlIIIlllIIlII > lllllllllllllllllllIlIIIlllIIlll.y && lllllllllllllllllllIlIIIlllIIlII < lllllllllllllllllllIlIIIlllIIlll.y + 11;
    }

    @Override
    public void updateComponent(int lllllllllllllllllllIlIIlIIIlIlIl, int lllllllllllllllllllIlIIlIIIlllII) {
        IntSlider lllllllllllllllllllIlIIlIIlIIIII;
        lllllllllllllllllllIlIIlIIlIIIII.hovered = lllllllllllllllllllIlIIlIIlIIIII.isMouseOnButtonD(lllllllllllllllllllIlIIlIIIlIlIl, lllllllllllllllllllIlIIlIIIlllII) || lllllllllllllllllllIlIIlIIlIIIII.isMouseOnButtonI(lllllllllllllllllllIlIIlIIIlIlIl, lllllllllllllllllllIlIIlIIIlllII);
        lllllllllllllllllllIlIIlIIlIIIII.y = lllllllllllllllllllIlIIlIIlIIIII.parent.parent.getY() + lllllllllllllllllllIlIIlIIlIIIII.offset;
        lllllllllllllllllllIlIIlIIlIIIII.x = lllllllllllllllllllIlIIlIIlIIIII.parent.parent.getX() + 4;
        double lllllllllllllllllllIlIIlIIIllIlI = Math.min(85, Math.max(0, lllllllllllllllllllIlIIlIIIlIlIl - lllllllllllllllllllIlIIlIIlIIIII.x));
        int lllllllllllllllllllIlIIlIIIllIII = lllllllllllllllllllIlIIlIIlIIIII.set.getMin();
        int lllllllllllllllllllIlIIlIIIlIlll = lllllllllllllllllllIlIIlIIlIIIII.set.getMax();
        lllllllllllllllllllIlIIlIIlIIIII.renderWidth = 85 * (lllllllllllllllllllIlIIlIIlIIIII.set.getValue() - lllllllllllllllllllIlIIlIIIllIII) / (lllllllllllllllllllIlIIlIIIlIlll - lllllllllllllllllllIlIIlIIIllIII);
        if (lllllllllllllllllllIlIIlIIlIIIII.dragging) {
            if (lllllllllllllllllllIlIIlIIIllIlI == 0.0) {
                lllllllllllllllllllIlIIlIIlIIIII.set.setValue(lllllllllllllllllllIlIIlIIlIIIII.set.getMin());
            } else {
                int lllllllllllllllllllIlIIlIIlIIIlI = (int)IntSlider.roundToPlace(lllllllllllllllllllIlIIlIIIllIlI / 85.0 * (double)(lllllllllllllllllllIlIIlIIIlIlll - lllllllllllllllllllIlIIlIIIllIII) + (double)lllllllllllllllllllIlIIlIIIllIII, 2);
                lllllllllllllllllllIlIIlIIlIIIII.set.setValue(lllllllllllllllllllIlIIlIIlIIIlI);
            }
        }
    }
}

