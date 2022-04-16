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
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import net.minecraft.client.gui.Gui;

public class StringButton
extends Component {
    private /* synthetic */ int offset;
    private /* synthetic */ Button parent;
    private /* synthetic */ Setting.s op;

    @Override
    public void renderComponent() {
        StringButton lllllllllllllllllllIllIIIllIIlll;
        Gui.drawRect((int)lllllllllllllllllllIllIIIllIIlll.parent.parent.getX(), (int)(lllllllllllllllllllIllIIIllIIlll.parent.parent.getY() + lllllllllllllllllllIllIIIllIIlll.offset + 1), (int)(lllllllllllllllllllIllIIIllIIlll.parent.parent.getX() + lllllllllllllllllllIllIIIllIIlll.parent.parent.getWidth()), (int)(lllllllllllllllllllIllIIIllIIlll.parent.parent.getY() + lllllllllllllllllllIllIIIllIIlll.offset + 11), (int)new Color(30, 30, 30, 150).getRGB());
        Gui.drawRect((int)lllllllllllllllllllIllIIIllIIlll.parent.parent.getX(), (int)(lllllllllllllllllllIllIIIllIIlll.parent.parent.getY() + lllllllllllllllllllIllIIIllIIlll.offset), (int)(lllllllllllllllllllIllIIIllIIlll.parent.parent.getX() + lllllllllllllllllllIllIIIllIIlll.parent.parent.getWidth()), (int)(lllllllllllllllllllIllIIIllIIlll.parent.parent.getY() + lllllllllllllllllllIllIIIllIIlll.offset + 1), (int)new Color(30, 30, 30, 150).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(lllllllllllllllllllIllIIIllIIlll.op.getName()).append(" ").append(ChatFormatting.GRAY).append("-set")), lllllllllllllllllllIllIIIllIIlll.parent.parent.getX() + 2, lllllllllllllllllllIllIIIllIIlll.parent.parent.getY() + lllllllllllllllllllIllIIIllIIlll.offset, -1);
    }

    @Override
    public void setOff(int lllllllllllllllllllIllIIIllIIIll) {
        lllllllllllllllllllIllIIIllIIIlI.offset = lllllllllllllllllllIllIIIllIIIll;
    }

    public StringButton(Setting.s lllllllllllllllllllIllIIIlllIIII, Button lllllllllllllllllllIllIIIllIlIll, int lllllllllllllllllllIllIIIllIlllI) {
        StringButton lllllllllllllllllllIllIIIllIllIl;
        lllllllllllllllllllIllIIIllIllIl.op = lllllllllllllllllllIllIIIlllIIII;
        lllllllllllllllllllIllIIIllIllIl.parent = lllllllllllllllllllIllIIIllIlIll;
        lllllllllllllllllllIllIIIllIllIl.offset = lllllllllllllllllllIllIIIllIlllI;
    }
}

