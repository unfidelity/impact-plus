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
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.components.Button;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;

public class ModeButton
extends Component {
    private /* synthetic */ int offset;
    private /* synthetic */ int y;
    private /* synthetic */ Setting.mode set;
    private /* synthetic */ Module mod;
    private /* synthetic */ Button parent;
    private /* synthetic */ int modeIndex;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int x;

    public boolean isMouseOnButton(int lllllllllllllllllIllIIIIIIlIIllI, int lllllllllllllllllIllIIIIIIIlllIl) {
        ModeButton lllllllllllllllllIllIIIIIIlIlIII;
        return lllllllllllllllllIllIIIIIIlIIllI > lllllllllllllllllIllIIIIIIlIlIII.x && lllllllllllllllllIllIIIIIIlIIllI < lllllllllllllllllIllIIIIIIlIlIII.x + 88 && lllllllllllllllllIllIIIIIIIlllIl > lllllllllllllllllIllIIIIIIlIlIII.y && lllllllllllllllllIllIIIIIIIlllIl < lllllllllllllllllIllIIIIIIlIlIII.y + 11;
    }

    @Override
    public void setOff(int lllllllllllllllllIllIIIIlIlIllII) {
        lllllllllllllllllIllIIIIlIlIllIl.offset = lllllllllllllllllIllIIIIlIlIllII;
    }

    @Override
    public void renderComponent() {
        ModeButton lllllllllllllllllIllIIIIIllllIII;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllllIllIIIIIllllIll = Rainbow.getColorWithOpacity(130);
        } else {
            Color lllllllllllllllllIllIIIIIllllIIl = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + 4), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset + 1), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + lllllllllllllllllIllIIIIIllllIII.parent.parent.getWidth() - 1), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset + 11), (int)new Color(0, 0, 0, 130).getRGB());
        Gui.drawRect((int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + 4), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + lllllllllllllllllIllIIIIIllllIII.parent.parent.getWidth() - 1), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)lllllllllllllllllIllIIIIIllllIII.parent.parent.getX(), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + 2), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + 2), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + 4), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + lllllllllllllllllIllIIIIIllllIII.parent.parent.getWidth() - 1), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + lllllllllllllllllIllIIIIIllllIII.parent.parent.getWidth()), (int)(lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(lllllllllllllllllIllIIIIIllllIII.set.getName()).append(" ").append(ChatFormatting.GRAY).append(lllllllllllllllllIllIIIIIllllIII.set.getValue())), lllllllllllllllllIllIIIIIllllIII.parent.parent.getX() + 7, lllllllllllllllllIllIIIIIllllIII.parent.parent.getY() + lllllllllllllllllIllIIIIIllllIII.offset, -1);
    }

    public ModeButton(Setting.mode lllllllllllllllllIllIIIIlIllIlIl, Button lllllllllllllllllIllIIIIlIlllIIl, Module lllllllllllllllllIllIIIIlIllIIll, int lllllllllllllllllIllIIIIlIllIlll) {
        ModeButton lllllllllllllllllIllIIIIlIllIllI;
        lllllllllllllllllIllIIIIlIllIllI.set = lllllllllllllllllIllIIIIlIllIlIl;
        lllllllllllllllllIllIIIIlIllIllI.parent = lllllllllllllllllIllIIIIlIlllIIl;
        lllllllllllllllllIllIIIIlIllIllI.mod = lllllllllllllllllIllIIIIlIllIIll;
        lllllllllllllllllIllIIIIlIllIllI.x = lllllllllllllllllIllIIIIlIlllIIl.parent.getX() + lllllllllllllllllIllIIIIlIlllIIl.parent.getWidth();
        lllllllllllllllllIllIIIIlIllIllI.y = lllllllllllllllllIllIIIIlIlllIIl.parent.getY() + lllllllllllllllllIllIIIIlIlllIIl.offset;
        lllllllllllllllllIllIIIIlIllIllI.offset = lllllllllllllllllIllIIIIlIllIlll;
        lllllllllllllllllIllIIIIlIllIllI.modeIndex = 0;
    }

    @Override
    public void updateComponent(int lllllllllllllllllIllIIIIIllIIIll, int lllllllllllllllllIllIIIIIllIIIII) {
        ModeButton lllllllllllllllllIllIIIIIllIIlIl;
        lllllllllllllllllIllIIIIIllIIlIl.hovered = lllllllllllllllllIllIIIIIllIIlIl.isMouseOnButton(lllllllllllllllllIllIIIIIllIIIll, lllllllllllllllllIllIIIIIllIIIII);
        lllllllllllllllllIllIIIIIllIIlIl.y = lllllllllllllllllIllIIIIIllIIlIl.parent.parent.getY() + lllllllllllllllllIllIIIIIllIIlIl.offset;
        lllllllllllllllllIllIIIIIllIIlIl.x = lllllllllllllllllIllIIIIIllIIlIl.parent.parent.getX();
    }

    @Override
    public void mouseClicked(int lllllllllllllllllIllIIIIIIllIlll, int lllllllllllllllllIllIIIIIIllIllI, int lllllllllllllllllIllIIIIIIlllIIl) {
        ModeButton lllllllllllllllllIllIIIIIIllllII;
        if (lllllllllllllllllIllIIIIIIllllII.isMouseOnButton(lllllllllllllllllIllIIIIIIllIlll, lllllllllllllllllIllIIIIIIllIllI) && lllllllllllllllllIllIIIIIIlllIIl == 0 && lllllllllllllllllIllIIIIIIllllII.parent.open) {
            int lllllllllllllllllIllIIIIIIlllllI = lllllllllllllllllIllIIIIIIllllII.set.getModes().size() - 1;
            ++lllllllllllllllllIllIIIIIIllllII.modeIndex;
            if (lllllllllllllllllIllIIIIIIllllII.modeIndex > lllllllllllllllllIllIIIIIIlllllI) {
                lllllllllllllllllIllIIIIIIllllII.modeIndex = 0;
            }
            lllllllllllllllllIllIIIIIIllllII.set.setValue(lllllllllllllllllIllIIIIIIllllII.set.getModes().get(lllllllllllllllllIllIIIIIIllllII.modeIndex));
        }
        if (lllllllllllllllllIllIIIIIIllllII.isMouseOnButton(lllllllllllllllllIllIIIIIIllIlll, lllllllllllllllllIllIIIIIIllIllI) && lllllllllllllllllIllIIIIIIlllIIl == 1 && lllllllllllllllllIllIIIIIIllllII.parent.open) {
            boolean lllllllllllllllllIllIIIIIIllllIl = false;
            --lllllllllllllllllIllIIIIIIllllII.modeIndex;
            if (lllllllllllllllllIllIIIIIIllllII.modeIndex < 0) {
                lllllllllllllllllIllIIIIIIllllII.modeIndex = lllllllllllllllllIllIIIIIIllllII.set.getModes().size() - 1;
            }
            lllllllllllllllllIllIIIIIIllllII.set.setValue(lllllllllllllllllIllIIIIIIllllII.set.getModes().get(lllllllllllllllllIllIIIIIIllllII.modeIndex));
        }
    }
}

