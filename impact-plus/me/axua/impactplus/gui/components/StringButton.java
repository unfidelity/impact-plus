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
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.font.FontUtils;
import net.minecraft.client.gui.Gui;

public class StringButton
extends Component {
    private /* synthetic */ Button parent;
    private /* synthetic */ int offset;
    private /* synthetic */ Setting.s op;

    public StringButton(Setting.s llIIlIlIlI, Button llIIlIllIl, int llIIlIllII) {
        StringButton llIIlIllll;
        llIIlIllll.op = llIIlIlIlI;
        llIIlIllll.parent = llIIlIllIl;
        llIIlIllll.offset = llIIlIllII;
    }

    @Override
    public void renderComponent() {
        StringButton llIIIlllII;
        Gui.drawRect((int)llIIIlllII.parent.parent.getX(), (int)(llIIIlllII.parent.parent.getY() + llIIIlllII.offset + 1), (int)(llIIIlllII.parent.parent.getX() + llIIIlllII.parent.parent.getWidth()), (int)(llIIIlllII.parent.parent.getY() + llIIIlllII.offset + 11), (int)new Color(30, 30, 30, 150).getRGB());
        Gui.drawRect((int)llIIIlllII.parent.parent.getX(), (int)(llIIIlllII.parent.parent.getY() + llIIIlllII.offset), (int)(llIIIlllII.parent.parent.getX() + llIIIlllII.parent.parent.getWidth()), (int)(llIIIlllII.parent.parent.getY() + llIIIlllII.offset + 1), (int)new Color(30, 30, 30, 150).getRGB());
        FontUtils.drawStringWithShadow(true, String.valueOf(new StringBuilder().append(llIIIlllII.op.getName()).append(" ").append(ChatFormatting.GRAY).append("-set")), llIIIlllII.parent.parent.getX() + 2, llIIIlllII.parent.parent.getY() + llIIIlllII.offset, -1);
    }

    @Override
    public void setOff(int llIIIIllll) {
        llIIIlIIII.offset = llIIIIllll;
    }
}

