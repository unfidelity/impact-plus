/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.hud;

import java.awt.Color;
import me.axua.impactplus.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class HudComponent<T extends Module> {
    protected /* synthetic */ int y;
    protected final /* synthetic */ T module;
    protected /* synthetic */ int width;
    protected /* synthetic */ int height;
    private /* synthetic */ int dragY;
    /* synthetic */ Minecraft mc;
    private final /* synthetic */ String name;
    private /* synthetic */ boolean dragging;
    private /* synthetic */ int dragX;
    protected /* synthetic */ int x;

    public void setX(int lllllllllllllllllIlIllllIlIlllll) {
        lllllllllllllllllIlIllllIlIllllI.x = lllllllllllllllllIlIllllIlIlllll;
    }

    public int getY() {
        HudComponent lllllllllllllllllIlIllllIlIllIlI;
        return lllllllllllllllllIlIllllIlIllIlI.y;
    }

    public String getName() {
        HudComponent lllllllllllllllllIlIllllIllIIlll;
        return lllllllllllllllllIlIllllIllIIlll.name;
    }

    public void onGuiClosed() {
        lllllllllllllllllIlIllllIllllllI.dragging = false;
    }

    public void renderInGui(int lllllllllllllllllIlIllllllIlllll, int lllllllllllllllllIlIlllllllIIIIl) {
        HudComponent lllllllllllllllllIlIlllllllIIIII;
        if (lllllllllllllllllIlIlllllllIIIII.isInvisible()) {
            return;
        }
        if (lllllllllllllllllIlIlllllllIIIII.dragging) {
            lllllllllllllllllIlIlllllllIIIII.x = lllllllllllllllllIlIlllllllIIIII.dragX + lllllllllllllllllIlIllllllIlllll;
            lllllllllllllllllIlIlllllllIIIII.y = lllllllllllllllllIlIlllllllIIIII.dragY + lllllllllllllllllIlIlllllllIIIIl;
        }
        Gui.drawRect((int)lllllllllllllllllIlIlllllllIIIII.x, (int)lllllllllllllllllIlIlllllllIIIII.y, (int)(lllllllllllllllllIlIlllllllIIIII.x + lllllllllllllllllIlIlllllllIIIII.width), (int)(lllllllllllllllllIlIlllllllIIIII.y + lllllllllllllllllIlIlllllllIIIII.height), (int)new Color(0, 0, 0, 130).getRGB());
        lllllllllllllllllIlIlllllllIIIII.render();
    }

    public void mouseClicked(int lllllllllllllllllIlIlllllIlIIIlI, int lllllllllllllllllIlIlllllIlIIIIl, int lllllllllllllllllIlIlllllIlIIlII) {
        HudComponent lllllllllllllllllIlIlllllIlIIlll;
        if (lllllllllllllllllIlIlllllIlIIlll.isInvisible()) {
            return;
        }
        if (lllllllllllllllllIlIlllllIlIIlll.width < 0) {
            if (lllllllllllllllllIlIlllllIlIIlII == 0 && lllllllllllllllllIlIlllllIlIIIlI < lllllllllllllllllIlIlllllIlIIlll.x && lllllllllllllllllIlIlllllIlIIIlI > lllllllllllllllllIlIlllllIlIIlll.x + lllllllllllllllllIlIlllllIlIIlll.width && lllllllllllllllllIlIlllllIlIIIIl > lllllllllllllllllIlIlllllIlIIlll.y && lllllllllllllllllIlIlllllIlIIIIl < lllllllllllllllllIlIlllllIlIIlll.y + lllllllllllllllllIlIlllllIlIIlll.height) {
                lllllllllllllllllIlIlllllIlIIlll.dragX = lllllllllllllllllIlIlllllIlIIlll.x - lllllllllllllllllIlIlllllIlIIIlI;
                lllllllllllllllllIlIlllllIlIIlll.dragY = lllllllllllllllllIlIlllllIlIIlll.y - lllllllllllllllllIlIlllllIlIIIIl;
                lllllllllllllllllIlIlllllIlIIlll.dragging = true;
            }
        } else if (lllllllllllllllllIlIlllllIlIIlII == 0 && lllllllllllllllllIlIlllllIlIIIlI > lllllllllllllllllIlIlllllIlIIlll.x && lllllllllllllllllIlIlllllIlIIIlI < lllllllllllllllllIlIlllllIlIIlll.x + lllllllllllllllllIlIlllllIlIIlll.width && lllllllllllllllllIlIlllllIlIIIIl > lllllllllllllllllIlIlllllIlIIlll.y && lllllllllllllllllIlIlllllIlIIIIl < lllllllllllllllllIlIlllllIlIIlll.y + lllllllllllllllllIlIlllllIlIIlll.height) {
            lllllllllllllllllIlIlllllIlIIlll.dragX = lllllllllllllllllIlIlllllIlIIlll.x - lllllllllllllllllIlIlllllIlIIIlI;
            lllllllllllllllllIlIlllllIlIIlll.dragY = lllllllllllllllllIlIlllllIlIIlll.y - lllllllllllllllllIlIlllllIlIIIIl;
            lllllllllllllllllIlIlllllIlIIlll.dragging = true;
        }
    }

    public void mouseReleased(int lllllllllllllllllIlIlllllIIIlIll, int lllllllllllllllllIlIlllllIIIlIlI, int lllllllllllllllllIlIlllllIIIlIIl) {
        HudComponent lllllllllllllllllIlIlllllIIIllII;
        if (lllllllllllllllllIlIlllllIIIllII.isInvisible()) {
            return;
        }
        if (lllllllllllllllllIlIlllllIIIlIIl == 0) {
            lllllllllllllllllIlIlllllIIIllII.dragging = false;
        }
    }

    public void render() {
        HudComponent lllllllllllllllllIlIllllllIlllII;
        if (lllllllllllllllllIlIllllllIlllII.mc.thePlayer != null) {
            // empty if block
        }
    }

    public HudComponent(String lllllllllllllllllIllIIIIIIIIIlIl, int lllllllllllllllllIllIIIIIIIIllIl, int lllllllllllllllllIllIIIIIIIIlIll, T lllllllllllllllllIllIIIIIIIIlIIl) {
        HudComponent lllllllllllllllllIllIIIIIIIIIlll;
        lllllllllllllllllIllIIIIIIIIIlll.mc = Minecraft.getMinecraft();
        lllllllllllllllllIllIIIIIIIIIlll.width = 10;
        lllllllllllllllllIllIIIIIIIIIlll.height = lllllllllllllllllIllIIIIIIIIIlll.mc.fontRendererObj.FONT_HEIGHT;
        lllllllllllllllllIllIIIIIIIIIlll.dragging = false;
        lllllllllllllllllIllIIIIIIIIIlll.dragX = 0;
        lllllllllllllllllIllIIIIIIIIIlll.dragY = 0;
        lllllllllllllllllIllIIIIIIIIIlll.name = lllllllllllllllllIllIIIIIIIIIlIl;
        lllllllllllllllllIllIIIIIIIIIlll.x = lllllllllllllllllIllIIIIIIIIllIl;
        lllllllllllllllllIllIIIIIIIIIlll.y = lllllllllllllllllIllIIIIIIIIlIll;
        lllllllllllllllllIllIIIIIIIIIlll.module = lllllllllllllllllIllIIIIIIIIlIIl;
    }

    public boolean isInvisible() {
        HudComponent lllllllllllllllllIlIllllIlllIIll;
        return !((Module)lllllllllllllllllIlIllllIlllIIll.module).isEnabled();
    }

    public int getX() {
        HudComponent lllllllllllllllllIlIllllIllIIlII;
        return lllllllllllllllllIlIllllIllIIlII.x;
    }

    public void setY(int lllllllllllllllllIlIllllIlIlIIlI) {
        lllllllllllllllllIlIllllIlIlIlII.y = lllllllllllllllllIlIllllIlIlIIlI;
    }
}

