/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.input.Keyboard
 */
package me.axua.impactplus.gui.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.components.Button;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

public class Keybind
extends Component {
    private /* synthetic */ boolean binding;
    private /* synthetic */ boolean hovered;
    private /* synthetic */ Button parent;
    private /* synthetic */ int y;
    private /* synthetic */ int offset;
    private /* synthetic */ int x;

    @Override
    public void setOff(int llllllIllllllII) {
        llllllIllllllIl.offset = llllllIllllllII;
    }

    @Override
    public void updateComponent(int llllllIllllIIII, int llllllIlllIllll) {
        Keybind llllllIlllIlllI;
        llllllIlllIlllI.hovered = llllllIlllIlllI.isMouseOnButton(llllllIllllIIII, llllllIlllIllll);
        llllllIlllIlllI.y = llllllIlllIlllI.parent.parent.getY() + llllllIlllIlllI.offset;
        llllllIlllIlllI.x = llllllIlllIlllI.parent.parent.getX();
    }

    @Override
    public void renderComponent() {
        Keybind llllllIlllllIII;
        if (ClickGuiModule.rainbow.getValue()) {
            Color llllllIlllllIIl = Rainbow.getColorWithOpacity(130);
        } else {
            Color llllllIllllIlll = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(llllllIlllllIII.parent.parent.getX() + 4), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset + 1), (int)(llllllIlllllIII.parent.parent.getX() + llllllIlllllIII.parent.parent.getWidth() - 1), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset + 11), (int)new Color(0, 0, 0, 130).getRGB());
        Gui.drawRect((int)(llllllIlllllIII.parent.parent.getX() + 4), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset), (int)(llllllIlllllIII.parent.parent.getX() + llllllIlllllIII.parent.parent.getWidth() - 1), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)llllllIlllllIII.parent.parent.getX(), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset), (int)(llllllIlllllIII.parent.parent.getX() + 2), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllIlllllIII.parent.parent.getX() + 2), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset), (int)(llllllIlllllIII.parent.parent.getX() + 4), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllIlllllIII.parent.parent.getX() + llllllIlllllIII.parent.parent.getWidth() - 1), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset), (int)(llllllIlllllIII.parent.parent.getX() + llllllIlllllIII.parent.parent.getWidth()), (int)(llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        FontUtils.drawStringWithShadow(true, llllllIlllllIII.binding ? "Press a key..." : String.valueOf(new StringBuilder().append("Keybind ").append(ChatFormatting.GRAY).append(Keyboard.getKeyName((int)llllllIlllllIII.parent.mod.getBind()))), llllllIlllllIII.parent.parent.getX() + 7, llllllIlllllIII.parent.parent.getY() + llllllIlllllIII.offset, -1);
    }

    public boolean isMouseOnButton(int llllllIllIIlIll, int llllllIllIIIlll) {
        Keybind llllllIllIIlIIl;
        return llllllIllIIlIll > llllllIllIIlIIl.x && llllllIllIIlIll < llllllIllIIlIIl.x + 88 && llllllIllIIIlll > llllllIllIIlIIl.y && llllllIllIIIlll < llllllIllIIlIIl.y + 11;
    }

    public Keybind(Button lllllllIIIIIIll, int lllllllIIIIIlIl) {
        Keybind lllllllIIIIIlII;
        lllllllIIIIIlII.parent = lllllllIIIIIIll;
        lllllllIIIIIlII.x = lllllllIIIIIIll.parent.getX() + lllllllIIIIIIll.parent.getWidth();
        lllllllIIIIIlII.y = lllllllIIIIIIll.parent.getY() + lllllllIIIIIIll.offset;
        lllllllIIIIIlII.offset = lllllllIIIIIlIl;
    }

    @Override
    public void keyTyped(char llllllIllIlIIll, int llllllIllIlIIII) {
        Keybind llllllIllIlIlII;
        if (llllllIllIlIlII.binding) {
            llllllIllIlIlII.parent.mod.setBind(llllllIllIlIIII);
            llllllIllIlIlII.binding = false;
        }
    }

    @Override
    public void mouseClicked(int llllllIllIlllII, int llllllIllIllIll, int llllllIllIllllI) {
        Keybind llllllIllIlllIl;
        if (llllllIllIlllIl.isMouseOnButton(llllllIllIlllII, llllllIllIllIll) && llllllIllIllllI == 1 && llllllIllIlllIl.parent.open && llllllIllIlllIl.binding) {
            llllllIllIlllIl.parent.mod.setBind(0);
            boolean bl = llllllIllIlllIl.binding = !llllllIllIlllIl.binding;
        }
        if (llllllIllIlllIl.isMouseOnButton(llllllIllIlllII, llllllIllIllIll) && llllllIllIllllI == 0 && llllllIllIlllIl.parent.open) {
            llllllIllIlllIl.binding = !llllllIllIlllIl.binding;
        }
    }
}

