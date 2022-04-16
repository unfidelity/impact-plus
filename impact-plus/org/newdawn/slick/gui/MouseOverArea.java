/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class MouseOverArea
extends AbstractComponent {
    private /* synthetic */ Sound mouseOverSound;
    private /* synthetic */ Sound mouseDownSound;
    private /* synthetic */ Image mouseDownImage;
    private static final /* synthetic */ int MOUSE_OVER;
    private /* synthetic */ Color mouseDownColor;
    private /* synthetic */ boolean over;
    private /* synthetic */ boolean mouseUp;
    private /* synthetic */ boolean mouseDown;
    private /* synthetic */ int state;
    private /* synthetic */ Image mouseOverImage;
    private /* synthetic */ Image normalImage;
    private /* synthetic */ Color currentColor;
    private static final /* synthetic */ int NORMAL;
    private /* synthetic */ Color mouseOverColor;
    private /* synthetic */ Color normalColor;
    private /* synthetic */ Shape area;
    private /* synthetic */ Image currentImage;
    private static final /* synthetic */ int MOUSE_DOWN;

    @Override
    public int getY() {
        MouseOverArea lIIIIlIIIIlllIl;
        return (int)lIIIIlIIIIlllIl.area.getY();
    }

    @Override
    public void mouseReleased(int lIIIIIllIlIllII, int lIIIIIllIlIllll, int lIIIIIllIlIlllI) {
        MouseOverArea lIIIIIllIlIllIl;
        lIIIIIllIlIllIl.over = lIIIIIllIlIllIl.area.contains(lIIIIIllIlIllll, lIIIIIllIlIlllI);
        if (lIIIIIllIlIllII == 0) {
            lIIIIIllIlIllIl.mouseDown = false;
        }
    }

    static {
        MOUSE_OVER = 3;
        NORMAL = 1;
        MOUSE_DOWN = 2;
    }

    public MouseOverArea(GUIContext lIIIIlIIlIIlIll, Image lIIIIlIIlIlIIIl, int lIIIIlIIlIlIIII, int lIIIIlIIlIIllll, int lIIIIlIIlIIIlll, int lIIIIlIIlIIIllI) {
        lIIIIlIIlIIllII(lIIIIlIIlIIlIll, lIIIIlIIlIlIIIl, new Rectangle(lIIIIlIIlIlIIII, lIIIIlIIlIIllll, lIIIIlIIlIIIlll, lIIIIlIIlIIIllI));
        MouseOverArea lIIIIlIIlIIllII;
    }

    @Override
    public void setLocation(int lIIIIIllIIlllII, int lIIIIIllIIllIII) {
        MouseOverArea lIIIIIllIIllIlI;
        lIIIIIllIIllIlI.setLocation((float)lIIIIIllIIlllII, (float)lIIIIIllIIllIII);
    }

    public boolean isMouseOver() {
        MouseOverArea lIIIIIllIlIIIlI;
        return lIIIIIllIlIIIlI.over;
    }

    @Override
    public void render(GUIContext lIIIIIlllllIIII, Graphics lIIIIIllllIllll) {
        MouseOverArea lIIIIIlllllIIIl;
        if (lIIIIIlllllIIIl.currentImage != null) {
            int lIIIIIlllllIIll = (int)(lIIIIIlllllIIIl.area.getX() + (float)((lIIIIIlllllIIIl.getWidth() - lIIIIIlllllIIIl.currentImage.getWidth()) / 2));
            int lIIIIIlllllIIlI = (int)(lIIIIIlllllIIIl.area.getY() + (float)((lIIIIIlllllIIIl.getHeight() - lIIIIIlllllIIIl.currentImage.getHeight()) / 2));
            lIIIIIlllllIIIl.currentImage.draw((float)lIIIIIlllllIIll, (float)lIIIIIlllllIIlI, lIIIIIlllllIIIl.currentColor);
        } else {
            lIIIIIllllIllll.setColor(lIIIIIlllllIIIl.currentColor);
            lIIIIIllllIllll.fill(lIIIIIlllllIIIl.area);
        }
        lIIIIIlllllIIIl.updateImage();
    }

    @Override
    public int getWidth() {
        MouseOverArea lIIIIIllIlIIlIl;
        return (int)(lIIIIIllIlIIlIl.area.getMaxX() - lIIIIIllIlIIlIl.area.getX());
    }

    public void setX(float lIIIIlIIIlIlIII) {
        MouseOverArea lIIIIlIIIlIlIIl;
        lIIIIlIIIlIlIIl.area.setX(lIIIIlIIIlIlIII);
    }

    @Override
    public int getX() {
        MouseOverArea lIIIIlIIIlIIIII;
        return (int)lIIIIlIIIlIIIII.area.getX();
    }

    public MouseOverArea(GUIContext lIIIIlIlIIllIll, Image lIIIIlIlIIllIlI, int lIIIIlIlIIllIII, int lIIIIlIlIIlIlll) {
        lIIIIlIlIlIIlIl(lIIIIlIlIIllIll, lIIIIlIlIIllIlI, lIIIIlIlIIllIII, lIIIIlIlIIlIlll, lIIIIlIlIIllIlI.getWidth(), lIIIIlIlIIllIlI.getHeight());
        MouseOverArea lIIIIlIlIlIIlIl;
    }

    public void setNormalColor(Color lIIIIlIIIIlIllI) {
        lIIIIlIIIIllIIl.normalColor = lIIIIlIIIIlIllI;
    }

    public void setMouseDownSound(Sound lIIIIIlllIllllI) {
        lIIIIIlllIlllll.mouseDownSound = lIIIIIlllIllllI;
    }

    public void setMouseDownImage(Image lIIIIIllllllIII) {
        lIIIIIllllllIIl.mouseDownImage = lIIIIIllllllIII;
    }

    @Override
    public int getHeight() {
        MouseOverArea lIIIIIllIlIlIII;
        return (int)(lIIIIIllIlIlIII.area.getMaxY() - lIIIIIllIlIlIII.area.getY());
    }

    public void setLocation(float lIIIIlIIIllIIlI, float lIIIIlIIIlIlllI) {
        MouseOverArea lIIIIlIIIllIIll;
        if (lIIIIlIIIllIIll.area != null) {
            lIIIIlIIIllIIll.area.setX(lIIIIlIIIllIIlI);
            lIIIIlIIIllIIll.area.setY(lIIIIlIIIlIlllI);
        }
    }

    public MouseOverArea(GUIContext lIIIIlIIlllIlIl, Image lIIIIlIIlllIIll, int lIIIIlIIlllIIII, int lIIIIlIIllIIlII, int lIIIIlIIllIIIll, int lIIIIlIIllIllII, ComponentListener lIIIIlIIllIlIll) {
        lIIIIlIIlllIlll(lIIIIlIIlllIlIl, lIIIIlIIlllIIll, lIIIIlIIlllIIII, lIIIIlIIllIIlII, lIIIIlIIllIIIll, lIIIIlIIllIllII);
        MouseOverArea lIIIIlIIlllIlll;
        lIIIIlIIlllIlll.addListener(lIIIIlIIllIlIll);
    }

    public void setMouseDownColor(Color lIIIIlIIIIIlIlI) {
        lIIIIlIIIIIllIl.mouseDownColor = lIIIIlIIIIIlIlI;
    }

    public void setNormalImage(Image lIIIIlIIIIIIllI) {
        lIIIIlIIIIIIlll.normalImage = lIIIIlIIIIIIllI;
    }

    public void setMouseOverColor(Color lIIIIlIIIIlIIII) {
        lIIIIlIIIIlIIll.mouseOverColor = lIIIIlIIIIlIIII;
    }

    public MouseOverArea(GUIContext lIIIIlIllIIIlIl, Image lIIIIlIllIIIlII, int lIIIIlIllIIIIll, int lIIIIlIllIIIIIl, ComponentListener lIIIIlIlIllllll) {
        lIIIIlIllIIllll(lIIIIlIllIIIlIl, lIIIIlIllIIIlII, lIIIIlIllIIIIll, lIIIIlIllIIIIIl, lIIIIlIllIIIlII.getWidth(), lIIIIlIllIIIlII.getHeight());
        MouseOverArea lIIIIlIllIIllll;
        lIIIIlIllIIllll.addListener(lIIIIlIlIllllll);
    }

    @Override
    public void mouseDragged(int lIIIIIlllIIIlIl, int lIIIIIlllIIIlII, int lIIIIIlllIIIIll, int lIIIIIlllIIIlll) {
        MouseOverArea lIIIIIlllIIlIll;
        lIIIIIlllIIlIll.mouseMoved(lIIIIIlllIIIlIl, lIIIIIlllIIIlII, lIIIIIlllIIIIll, lIIIIIlllIIIlll);
    }

    public void setY(float lIIIIlIIIlIIlII) {
        MouseOverArea lIIIIlIIIlIIlIl;
        lIIIIlIIIlIIlIl.area.setY(lIIIIlIIIlIIlII);
    }

    @Override
    public void mouseMoved(int lIIIIIlllIlIlll, int lIIIIIlllIlIllI, int lIIIIIlllIlIIlI, int lIIIIIlllIlIlII) {
        MouseOverArea lIIIIIlllIlIIll;
        lIIIIIlllIlIIll.over = lIIIIIlllIlIIll.area.contains(lIIIIIlllIlIIlI, lIIIIIlllIlIlII);
    }

    private void updateImage() {
        MouseOverArea lIIIIIllllIlIII;
        if (!lIIIIIllllIlIII.over) {
            lIIIIIllllIlIII.currentImage = lIIIIIllllIlIII.normalImage;
            lIIIIIllllIlIII.currentColor = lIIIIIllllIlIII.normalColor;
            lIIIIIllllIlIII.state = 1;
            lIIIIIllllIlIII.mouseUp = false;
        } else {
            if (lIIIIIllllIlIII.mouseDown) {
                if (lIIIIIllllIlIII.state != 2 && lIIIIIllllIlIII.mouseUp) {
                    if (lIIIIIllllIlIII.mouseDownSound != null) {
                        lIIIIIllllIlIII.mouseDownSound.play();
                    }
                    lIIIIIllllIlIII.currentImage = lIIIIIllllIlIII.mouseDownImage;
                    lIIIIIllllIlIII.currentColor = lIIIIIllllIlIII.mouseDownColor;
                    lIIIIIllllIlIII.state = 2;
                    lIIIIIllllIlIII.notifyListeners();
                    lIIIIIllllIlIII.mouseUp = false;
                }
                return;
            }
            lIIIIIllllIlIII.mouseUp = true;
            if (lIIIIIllllIlIII.state != 3) {
                if (lIIIIIllllIlIII.mouseOverSound != null) {
                    lIIIIIllllIlIII.mouseOverSound.play();
                }
                lIIIIIllllIlIII.currentImage = lIIIIIllllIlIII.mouseOverImage;
                lIIIIIllllIlIII.currentColor = lIIIIIllllIlIII.mouseOverColor;
                lIIIIIllllIlIII.state = 3;
            }
        }
        lIIIIIllllIlIII.mouseDown = false;
        lIIIIIllllIlIII.state = 1;
    }

    public void setMouseOverImage(Image lIIIIlIIIIIIIII) {
        lIIIIlIIIIIIIIl.mouseOverImage = lIIIIlIIIIIIIII;
    }

    public void setMouseOverSound(Sound lIIIIIllllIIlII) {
        lIIIIIllllIIlIl.mouseOverSound = lIIIIIllllIIlII;
    }

    @Override
    public void mousePressed(int lIIIIIllIllllII, int lIIIIIllIlllIll, int lIIIIIllIllIllI) {
        MouseOverArea lIIIIIllIlllIIl;
        lIIIIIllIlllIIl.over = lIIIIIllIlllIIl.area.contains(lIIIIIllIlllIll, lIIIIIllIllIllI);
        if (lIIIIIllIllllII == 0) {
            lIIIIIllIlllIIl.mouseDown = true;
        }
    }

    public MouseOverArea(GUIContext lIIIIlIIIllllll, Image lIIIIlIIIlllIIl, Shape lIIIIlIIIllllIl) {
        super(lIIIIlIIIllllll);
        MouseOverArea lIIIIlIIIlllIll;
        lIIIIlIIIlllIll.normalColor = Color.white;
        lIIIIlIIIlllIll.mouseOverColor = Color.white;
        lIIIIlIIIlllIll.mouseDownColor = Color.white;
        lIIIIlIIIlllIll.state = 1;
        lIIIIlIIIlllIll.area = lIIIIlIIIllllIl;
        lIIIIlIIIlllIll.normalImage = lIIIIlIIIlllIIl;
        lIIIIlIIIlllIll.currentImage = lIIIIlIIIlllIIl;
        lIIIIlIIIlllIll.mouseOverImage = lIIIIlIIIlllIIl;
        lIIIIlIIIlllIll.mouseDownImage = lIIIIlIIIlllIIl;
        lIIIIlIIIlllIll.currentColor = lIIIIlIIIlllIll.normalColor;
        lIIIIlIIIlllIll.state = 1;
        Input lIIIIlIIIllllII = lIIIIlIIIllllll.getInput();
        lIIIIlIIIlllIll.over = lIIIIlIIIlllIll.area.contains(lIIIIlIIIllllII.getMouseX(), lIIIIlIIIllllII.getMouseY());
        lIIIIlIIIlllIll.mouseDown = lIIIIlIIIllllII.isMouseButtonDown(0);
        lIIIIlIIIlllIll.updateImage();
    }
}

