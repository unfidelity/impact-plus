/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.hudgui.components;

import java.awt.Color;
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.components.Button;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;

public class CheckBox
extends Component {
    private /* synthetic */ Setting.b op;
    private /* synthetic */ int offset;
    private /* synthetic */ int y;
    private /* synthetic */ int x;
    private /* synthetic */ Button parent;
    private /* synthetic */ boolean hovered;

    public CheckBox(Setting.b llllllllllllllllIllIllIIlIIlllll, Button llllllllllllllllIllIllIIlIlIIIlI, int llllllllllllllllIllIllIIlIIlllIl) {
        CheckBox llllllllllllllllIllIllIIlIlIIIII;
        llllllllllllllllIllIllIIlIlIIIII.op = llllllllllllllllIllIllIIlIIlllll;
        llllllllllllllllIllIllIIlIlIIIII.parent = llllllllllllllllIllIllIIlIlIIIlI;
        llllllllllllllllIllIllIIlIlIIIII.x = llllllllllllllllIllIllIIlIlIIIlI.parent.getX() + llllllllllllllllIllIllIIlIlIIIlI.parent.getWidth();
        llllllllllllllllIllIllIIlIlIIIII.y = llllllllllllllllIllIllIIlIlIIIlI.parent.getY() + llllllllllllllllIllIllIIlIlIIIlI.offset;
        llllllllllllllllIllIllIIlIlIIIII.offset = llllllllllllllllIllIllIIlIIlllIl;
    }

    @Override
    public void updateComponent(int llllllllllllllllIllIllIIlIIIlIII, int llllllllllllllllIllIllIIlIIIlIlI) {
        CheckBox llllllllllllllllIllIllIIlIIIlIIl;
        llllllllllllllllIllIllIIlIIIlIIl.hovered = llllllllllllllllIllIllIIlIIIlIIl.isMouseOnButton(llllllllllllllllIllIllIIlIIIlIII, llllllllllllllllIllIllIIlIIIlIlI);
        llllllllllllllllIllIllIIlIIIlIIl.y = llllllllllllllllIllIllIIlIIIlIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIIlIIl.offset;
        llllllllllllllllIllIllIIlIIIlIIl.x = llllllllllllllllIllIllIIlIIIlIIl.parent.parent.getX();
    }

    @Override
    public void mouseClicked(int llllllllllllllllIllIllIIIlllllIl, int llllllllllllllllIllIllIIlIIIIIII, int llllllllllllllllIllIllIIIllllIll) {
        CheckBox llllllllllllllllIllIllIIIllllllI;
        if (llllllllllllllllIllIllIIIllllllI.isMouseOnButton(llllllllllllllllIllIllIIIlllllIl, llllllllllllllllIllIllIIlIIIIIII) && llllllllllllllllIllIllIIIllllIll == 0 && llllllllllllllllIllIllIIIllllllI.parent.open) {
            llllllllllllllllIllIllIIIllllllI.op.setValue(!llllllllllllllllIllIllIIIllllllI.op.getValue());
        }
    }

    @Override
    public void renderComponent() {
        CheckBox llllllllllllllllIllIllIIlIIllIIl;
        Color llllllllllllllllIllIllIIlIIllIII;
        if (ClickGuiModule.rainbow.getValue()) {
            Color llllllllllllllllIllIllIIlIIllIlI = Rainbow.getColorWithOpacity(130);
        } else {
            llllllllllllllllIllIllIIlIIllIII = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 4), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 1), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + llllllllllllllllIllIllIIlIIllIIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 11), (int)new Color(0, 0, 0, 130).getRGB());
        Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 4), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + llllllllllllllllIllIllIIlIIllIIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX(), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 2), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 2), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 4), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + llllllllllllllllIllIllIIlIIllIIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + llllllllllllllllIllIllIIlIIllIIl.parent.parent.getWidth()), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        if (!llllllllllllllllIllIllIIlIIllIIl.op.getValue()) {
            Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 7), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 3), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 13), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 9), (int)llllllllllllllllIllIllIIlIIllIII.getRGB());
            Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 8), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 4), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 12), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 8), (int)new Color(-922812416).getRGB());
        } else {
            Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 7), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 3), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 13), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 9), (int)llllllllllllllllIllIllIIlIIllIII.getRGB());
            Gui.drawRect((int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 8), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 4), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 12), (int)(llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset + 8), (int)new Color(-939458816).getRGB());
        }
        FontUtils.drawStringWithShadow(true, llllllllllllllllIllIllIIlIIllIIl.op.getName(), llllllllllllllllIllIllIIlIIllIIl.parent.parent.getX() + 16, llllllllllllllllIllIllIIlIIllIIl.parent.parent.getY() + llllllllllllllllIllIllIIlIIllIIl.offset, -1);
    }

    @Override
    public void setOff(int llllllllllllllllIllIllIIlIIlIIlI) {
        llllllllllllllllIllIllIIlIIlIIIl.offset = llllllllllllllllIllIllIIlIIlIIlI;
    }

    public boolean isMouseOnButton(int llllllllllllllllIllIllIIIlllIIll, int llllllllllllllllIllIllIIIlllIIIl) {
        CheckBox llllllllllllllllIllIllIIIlllIlll;
        return llllllllllllllllIllIllIIIlllIIll > llllllllllllllllIllIllIIIlllIlll.x && llllllllllllllllIllIllIIIlllIIll < llllllllllllllllIllIllIIIlllIlll.x + 88 && llllllllllllllllIllIllIIIlllIIIl > llllllllllllllllIllIllIIIlllIlll.y && llllllllllllllllIllIllIIIlllIIIl < llllllllllllllllIllIllIIIlllIlll.y + 11;
    }
}

