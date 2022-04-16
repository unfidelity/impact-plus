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
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.components.Button;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;

public class ModeButton
extends Component {
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int modeIndex;
    private /* synthetic */ int y;
    private /* synthetic */ int offset;
    private /* synthetic */ Module mod;
    private /* synthetic */ Setting.mode set;
    private /* synthetic */ int x;
    private /* synthetic */ Button parent;

    public ModeButton(Setting.mode lllllllllllllllllIllIIlIlIllIIIl, Button lllllllllllllllllIllIIlIlIlIIlll, Module lllllllllllllllllIllIIlIlIlIlllI, int lllllllllllllllllIllIIlIlIlIIIlI) {
        ModeButton lllllllllllllllllIllIIlIlIllIIlI;
        lllllllllllllllllIllIIlIlIllIIlI.set = lllllllllllllllllIllIIlIlIllIIIl;
        lllllllllllllllllIllIIlIlIllIIlI.parent = lllllllllllllllllIllIIlIlIlIIlll;
        lllllllllllllllllIllIIlIlIllIIlI.mod = lllllllllllllllllIllIIlIlIlIlllI;
        lllllllllllllllllIllIIlIlIllIIlI.x = lllllllllllllllllIllIIlIlIlIIlll.parent.getX() + lllllllllllllllllIllIIlIlIlIIlll.parent.getWidth();
        lllllllllllllllllIllIIlIlIllIIlI.y = lllllllllllllllllIllIIlIlIlIIlll.parent.getY() + lllllllllllllllllIllIIlIlIlIIlll.offset;
        lllllllllllllllllIllIIlIlIllIIlI.offset = lllllllllllllllllIllIIlIlIlIIIlI;
        lllllllllllllllllIllIIlIlIllIIlI.modeIndex = 0;
    }

    @Override
    public void mouseClicked(int lllllllllllllllllIllIIlIIIlIlllI, int lllllllllllllllllIllIIlIIIllIIll, int lllllllllllllllllIllIIlIIIllIIlI) {
        ModeButton lllllllllllllllllIllIIlIIIllIIII;
        if (lllllllllllllllllIllIIlIIIllIIII.isMouseOnButton(lllllllllllllllllIllIIlIIIlIlllI, lllllllllllllllllIllIIlIIIllIIll) && lllllllllllllllllIllIIlIIIllIIlI == 0 && lllllllllllllllllIllIIlIIIllIIII.parent.open) {
            int lllllllllllllllllIllIIlIIIlllIII = lllllllllllllllllIllIIlIIIllIIII.set.getModes().size() - 1;
            ++lllllllllllllllllIllIIlIIIllIIII.modeIndex;
            if (lllllllllllllllllIllIIlIIIllIIII.modeIndex > lllllllllllllllllIllIIlIIIlllIII) {
                lllllllllllllllllIllIIlIIIllIIII.modeIndex = 0;
            }
            lllllllllllllllllIllIIlIIIllIIII.set.setValue(lllllllllllllllllIllIIlIIIllIIII.set.getModes().get(lllllllllllllllllIllIIlIIIllIIII.modeIndex));
        }
        if (lllllllllllllllllIllIIlIIIllIIII.isMouseOnButton(lllllllllllllllllIllIIlIIIlIlllI, lllllllllllllllllIllIIlIIIllIIll) && lllllllllllllllllIllIIlIIIllIIlI == 1 && lllllllllllllllllIllIIlIIIllIIII.parent.open) {
            boolean lllllllllllllllllIllIIlIIIllIlll = false;
            --lllllllllllllllllIllIIlIIIllIIII.modeIndex;
            if (lllllllllllllllllIllIIlIIIllIIII.modeIndex < 0) {
                lllllllllllllllllIllIIlIIIllIIII.modeIndex = lllllllllllllllllIllIIlIIIllIIII.set.getModes().size() - 1;
            }
            lllllllllllllllllIllIIlIIIllIIII.set.setValue(lllllllllllllllllIllIIlIIIllIIII.set.getModes().get(lllllllllllllllllIllIIlIIIllIIII.modeIndex));
        }
    }

    @Override
    public void setOff(int lllllllllllllllllIllIIlIlIIlIIII) {
        lllllllllllllllllIllIIlIlIIIlllI.offset = lllllllllllllllllIllIIlIlIIlIIII;
    }

    @Override
    public void updateComponent(int lllllllllllllllllIllIIlIIlIIllII, int lllllllllllllllllIllIIlIIlIIlllI) {
        ModeButton lllllllllllllllllIllIIlIIlIIllIl;
        lllllllllllllllllIllIIlIIlIIllIl.hovered = lllllllllllllllllIllIIlIIlIIllIl.isMouseOnButton(lllllllllllllllllIllIIlIIlIIllII, lllllllllllllllllIllIIlIIlIIlllI);
        lllllllllllllllllIllIIlIIlIIllIl.y = lllllllllllllllllIllIIlIIlIIllIl.parent.parent.getY() + lllllllllllllllllIllIIlIIlIIllIl.offset;
        lllllllllllllllllIllIIlIIlIIllIl.x = lllllllllllllllllIllIIlIIlIIllIl.parent.parent.getX();
    }

    public boolean isMouseOnButton(int lllllllllllllllllIllIIlIIIIllIll, int lllllllllllllllllIllIIlIIIIlllll) {
        ModeButton lllllllllllllllllIllIIlIIIIlllIl;
        return lllllllllllllllllIllIIlIIIIllIll > lllllllllllllllllIllIIlIIIIlllIl.x && lllllllllllllllllIllIIlIIIIllIll < lllllllllllllllllIllIIlIIIIlllIl.x + 88 && lllllllllllllllllIllIIlIIIIlllll > lllllllllllllllllIllIIlIIIIlllIl.y && lllllllllllllllllIllIIlIIIIlllll < lllllllllllllllllIllIIlIIIIlllIl.y + 11;
    }

    @Override
    public void renderComponent() {
        ModeButton lllllllllllllllllIllIIlIIllIIIII;
        if (ClickGuiModule.rainbow.getValue()) {
            Color lllllllllllllllllIllIIlIIllIIllI = Rainbow.getColorWithOpacity(130);
        } else {
            Color lllllllllllllllllIllIIlIIllIIIlI = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + 4), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset + 1), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + lllllllllllllllllIllIIlIIllIIIII.parent.parent.getWidth() - 1), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset + 11), (int)new Color(0, 0, 0, 130).getRGB());
        Gui.drawRect((int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + 4), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + lllllllllllllllllIllIIlIIllIIIII.parent.parent.getWidth() - 1), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX(), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + 2), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + 2), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + 4), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + lllllllllllllllllIllIIlIIllIIIII.parent.parent.getWidth() - 1), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + lllllllllllllllllIllIIlIIllIIIII.parent.parent.getWidth()), (int)(lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(lllllllllllllllllIllIIlIIllIIIII.set.getName()).append(" ").append(ChatFormatting.GRAY).append(lllllllllllllllllIllIIlIIllIIIII.set.getValue())), lllllllllllllllllIllIIlIIllIIIII.parent.parent.getX() + 7, lllllllllllllllllIllIIlIIllIIIII.parent.parent.getY() + lllllllllllllllllIllIIlIIllIIIII.offset, -1);
    }
}

