/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.Gui
 *  org.lwjgl.input.Keyboard
 */
package me.axua.impactplus.hudgui.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.components.Button;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

public class Keybind
extends Component {
    private /* synthetic */ boolean hovered;
    private /* synthetic */ boolean binding;
    private /* synthetic */ int y;
    private /* synthetic */ int offset;
    private /* synthetic */ Button parent;
    private /* synthetic */ int x;

    public boolean isMouseOnButton(int llllllllllllllllIIIIlIIlIlIIIlII, int llllllllllllllllIIIIlIIlIlIIlIII) {
        Keybind llllllllllllllllIIIIlIIlIlIIIllI;
        return llllllllllllllllIIIIlIIlIlIIIlII > llllllllllllllllIIIIlIIlIlIIIllI.x && llllllllllllllllIIIIlIIlIlIIIlII < llllllllllllllllIIIIlIIlIlIIIllI.x + 88 && llllllllllllllllIIIIlIIlIlIIlIII > llllllllllllllllIIIIlIIlIlIIIllI.y && llllllllllllllllIIIIlIIlIlIIlIII < llllllllllllllllIIIIlIIlIlIIIllI.y + 11;
    }

    @Override
    public void mouseClicked(int llllllllllllllllIIIIlIIlIllIlllI, int llllllllllllllllIIIIlIIlIllIllII, int llllllllllllllllIIIIlIIlIllIlIlI) {
        Keybind llllllllllllllllIIIIlIIlIllIlIIl;
        if (llllllllllllllllIIIIlIIlIllIlIIl.isMouseOnButton(llllllllllllllllIIIIlIIlIllIlllI, llllllllllllllllIIIIlIIlIllIllII) && llllllllllllllllIIIIlIIlIllIlIlI == 0 && llllllllllllllllIIIIlIIlIllIlIIl.parent.open) {
            llllllllllllllllIIIIlIIlIllIlIIl.binding = !llllllllllllllllIIIIlIIlIllIlIIl.binding;
        }
    }

    public Keybind(Button llllllllllllllllIIIIlIIlllIIIIll, int llllllllllllllllIIIIlIIlllIIIIIl) {
        Keybind llllllllllllllllIIIIlIIlllIIlIll;
        llllllllllllllllIIIIlIIlllIIlIll.parent = llllllllllllllllIIIIlIIlllIIIIll;
        llllllllllllllllIIIIlIIlllIIlIll.x = llllllllllllllllIIIIlIIlllIIIIll.parent.getX() + llllllllllllllllIIIIlIIlllIIIIll.parent.getWidth();
        llllllllllllllllIIIIlIIlllIIlIll.y = llllllllllllllllIIIIlIIlllIIIIll.parent.getY() + llllllllllllllllIIIIlIIlllIIIIll.offset;
        llllllllllllllllIIIIlIIlllIIlIll.offset = llllllllllllllllIIIIlIIlllIIIIIl;
    }

    @Override
    public void setOff(int llllllllllllllllIIIIlIIllIllIllI) {
        llllllllllllllllIIIIlIIllIlllIII.offset = llllllllllllllllIIIIlIIllIllIllI;
    }

    @Override
    public void updateComponent(int llllllllllllllllIIIIlIIllIIIIllI, int llllllllllllllllIIIIlIIllIIIllII) {
        Keybind llllllllllllllllIIIIlIIllIIIllll;
        llllllllllllllllIIIIlIIllIIIllll.hovered = llllllllllllllllIIIIlIIllIIIllll.isMouseOnButton(llllllllllllllllIIIIlIIllIIIIllI, llllllllllllllllIIIIlIIllIIIllII);
        llllllllllllllllIIIIlIIllIIIllll.y = llllllllllllllllIIIIlIIllIIIllll.parent.parent.getY() + llllllllllllllllIIIIlIIllIIIllll.offset;
        llllllllllllllllIIIIlIIllIIIllll.x = llllllllllllllllIIIIlIIllIIIllll.parent.parent.getX();
    }

    @Override
    public void renderComponent() {
        Keybind llllllllllllllllIIIIlIIllIIlllIl;
        if (ClickGuiModule.rainbow.getValue()) {
            Color llllllllllllllllIIIIlIIllIIllllI = Rainbow.getColorWithOpacity(130);
        } else {
            Color llllllllllllllllIIIIlIIllIIlllII = new Color(ClickGuiModule.red.getValue(), ClickGuiModule.green.getValue(), ClickGuiModule.blue.getValue(), 130);
        }
        Gui.drawRect((int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + 4), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset + 1), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset + 11), (int)new Color(0, 0, 0, 130).getRGB());
        Gui.drawRect((int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + 4), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset + 1), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX(), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + 2), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + 2), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + 4), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset + 11), (int)new Color(0, 0, 0, 70).getRGB());
        Gui.drawRect((int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getWidth() - 1), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getWidth()), (int)(llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset + 11), (int)new Color(0, 0, 0, 80).getRGB());
        FontUtils.drawStringWithShadow(true, llllllllllllllllIIIIlIIllIIlllIl.binding ? "Press a key..." : String.valueOf(new StringBuilder().append("Keybind ").append(ChatFormatting.GRAY).append(Keyboard.getKeyName((int)llllllllllllllllIIIIlIIllIIlllIl.parent.mod.getBind()))), llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getX() + 7, llllllllllllllllIIIIlIIllIIlllIl.parent.parent.getY() + llllllllllllllllIIIIlIIllIIlllIl.offset, -1);
    }

    @Override
    public void keyTyped(char llllllllllllllllIIIIlIIlIlIllllI, int llllllllllllllllIIIIlIIlIlIllIlI) {
        Keybind llllllllllllllllIIIIlIIlIlIlllll;
        if (llllllllllllllllIIIIlIIlIlIlllll.binding) {
            if (llllllllllllllllIIIIlIIlIlIllIlI == 211) {
                llllllllllllllllIIIIlIIlIlIlllll.parent.mod.setBind(0);
            } else {
                llllllllllllllllIIIIlIIlIlIlllll.parent.mod.setBind(llllllllllllllllIIIIlIIlIlIllIlI);
            }
            llllllllllllllllIIIIlIIlIlIlllll.binding = false;
        }
    }
}

