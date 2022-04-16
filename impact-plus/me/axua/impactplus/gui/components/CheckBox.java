/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.gui.components;

import java.awt.Color;
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.components.Button;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;

public class CheckBox
extends Component {
    private /* synthetic */ Setting.b op;
    private /* synthetic */ int y;
    private /* synthetic */ Button parent;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ int x;
    private /* synthetic */ int offset;

    @Override
    public void updateComponent(int llllllllllllllllIIllIlllIlIIllIl, int llllllllllllllllIIllIlllIlIIlIIl) {
        CheckBox llllllllllllllllIIllIlllIlIIlllI;
        llllllllllllllllIIllIlllIlIIlllI.hovered = llllllllllllllllIIllIlllIlIIlllI.isMouseOnButton(llllllllllllllllIIllIlllIlIIllIl, llllllllllllllllIIllIlllIlIIlIIl);
        llllllllllllllllIIllIlllIlIIlllI.y = llllllllllllllllIIllIlllIlIIlllI.parent.parent.getY() + llllllllllllllllIIllIlllIlIIlllI.offset;
        llllllllllllllllIIllIlllIlIIlllI.x = llllllllllllllllIIllIlllIlIIlllI.parent.parent.getX();
    }

    public CheckBox(Setting.b llllllllllllllllIIllIlllIllIIIIl, Button llllllllllllllllIIllIlllIllIIIII, int llllllllllllllllIIllIlllIlIlllll) {
        CheckBox llllllllllllllllIIllIlllIllIIllI;
        llllllllllllllllIIllIlllIllIIllI.op = llllllllllllllllIIllIlllIllIIIIl;
        llllllllllllllllIIllIlllIllIIllI.parent = llllllllllllllllIIllIlllIllIIIII;
        llllllllllllllllIIllIlllIllIIllI.x = llllllllllllllllIIllIlllIllIIIII.parent.getX() + llllllllllllllllIIllIlllIllIIIII.parent.getWidth();
        llllllllllllllllIIllIlllIllIIllI.y = llllllllllllllllIIllIlllIllIIIII.parent.getY() + llllllllllllllllIIllIlllIllIIIII.offset;
        llllllllllllllllIIllIlllIllIIllI.offset = llllllllllllllllIIllIlllIlIlllll;
    }

    public boolean isMouseOnButton(int llllllllllllllllIIllIlllIIllIlIl, int llllllllllllllllIIllIlllIIllIlII) {
        CheckBox llllllllllllllllIIllIlllIIllIllI;
        return llllllllllllllllIIllIlllIIllIlIl > llllllllllllllllIIllIlllIIllIllI.x && llllllllllllllllIIllIlllIIllIlIl < llllllllllllllllIIllIlllIIllIllI.x + 88 && llllllllllllllllIIllIlllIIllIlII > llllllllllllllllIIllIlllIIllIllI.y && llllllllllllllllIIllIlllIIllIlII < llllllllllllllllIIllIlllIIllIllI.y + 11;
    }

    @Override
    public void renderComponent() {
        CheckBox llllllllllllllllIIllIlllIlIllIIl;
        Color llllllllllllllllIIllIlllIlIllIlI;
        if (ClickGuiModule.rainbow.getValue()) {
            Color llllllllllllllllIIllIlllIlIlllII = Rainbow.getColorWithOpacity(130);
        } else {
            llllllllllllllllIIllIlllIlIllIlI = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 4), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 1), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + llllllllllllllllIIllIlllIlIllIIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 11), (int)new Color(0, 0, 0, 130).getRGB());
        Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 4), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + llllllllllllllllIIllIlllIlIllIIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX(), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 2), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 2), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 4), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + llllllllllllllllIIllIlllIlIllIIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + llllllllllllllllIIllIlllIlIllIIl.parent.parent.getWidth()), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        if (!llllllllllllllllIIllIlllIlIllIIl.op.getValue()) {
            Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 7), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 3), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 13), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 9), (int)llllllllllllllllIIllIlllIlIllIlI.getRGB());
            Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 8), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 4), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 12), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 8), (int)new Color(-922812416).getRGB());
        } else {
            Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 7), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 3), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 13), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 9), (int)llllllllllllllllIIllIlllIlIllIlI.getRGB());
            Gui.drawRect((int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 8), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 4), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 12), (int)(llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset + 8), (int)new Color(-939458816).getRGB());
        }
        FontUtils.drawStringWithShadow(true, llllllllllllllllIIllIlllIlIllIIl.op.getName(), llllllllllllllllIIllIlllIlIllIIl.parent.parent.getX() + 16, llllllllllllllllIIllIlllIlIllIIl.parent.parent.getY() + llllllllllllllllIIllIlllIlIllIIl.offset, -1);
    }

    @Override
    public void mouseClicked(int llllllllllllllllIIllIlllIlIIIIll, int llllllllllllllllIIllIlllIIlllllI, int llllllllllllllllIIllIlllIlIIIIIl) {
        CheckBox llllllllllllllllIIllIlllIlIIIlII;
        if (llllllllllllllllIIllIlllIlIIIlII.isMouseOnButton(llllllllllllllllIIllIlllIlIIIIll, llllllllllllllllIIllIlllIIlllllI) && llllllllllllllllIIllIlllIlIIIIIl == 0 && llllllllllllllllIIllIlllIlIIIlII.parent.open) {
            llllllllllllllllIIllIlllIlIIIlII.op.setValue(!llllllllllllllllIIllIlllIlIIIlII.op.getValue());
        }
    }

    @Override
    public void setOff(int llllllllllllllllIIllIlllIlIlIlII) {
        llllllllllllllllIIllIlllIlIlIIll.offset = llllllllllllllllIIllIlllIlIlIlII;
    }
}

