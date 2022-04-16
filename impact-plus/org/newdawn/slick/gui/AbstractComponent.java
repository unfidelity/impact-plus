/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.gui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.util.InputAdapter;

public abstract class AbstractComponent
extends InputAdapter {
    private static /* synthetic */ AbstractComponent currentFocus;
    private /* synthetic */ boolean focus;
    protected /* synthetic */ Input input;
    protected /* synthetic */ GUIContext container;
    protected /* synthetic */ Set listeners;

    public void addListener(ComponentListener lIIIIIIllIIIIll) {
        AbstractComponent lIIIIIIllIIIllI;
        lIIIIIIllIIIllI.listeners.add(lIIIIIIllIIIIll);
    }

    public boolean hasFocus() {
        AbstractComponent lIIIIIIlIlIlllI;
        return lIIIIIIlIlIlllI.focus;
    }

    static {
        currentFocus = null;
    }

    @Override
    public void mouseReleased(int lIIIIIIlIlIIllI, int lIIIIIIlIlIIIlI, int lIIIIIIlIlIIIIl) {
        AbstractComponent lIIIIIIlIlIIIll;
        lIIIIIIlIlIIIll.setFocus(Rectangle.contains(lIIIIIIlIlIIIlI, lIIIIIIlIlIIIIl, lIIIIIIlIlIIIll.getX(), lIIIIIIlIlIIIll.getY(), lIIIIIIlIlIIIll.getWidth(), lIIIIIIlIlIIIll.getHeight()));
    }

    protected void notifyListeners() {
        AbstractComponent lIIIIIIlIlllIII;
        Iterator lIIIIIIlIlllIIl = lIIIIIIlIlllIII.listeners.iterator();
        while (lIIIIIIlIlllIIl.hasNext()) {
            ((ComponentListener)lIIIIIIlIlllIIl.next()).componentActivated(lIIIIIIlIlllIII);
        }
    }

    public abstract int getX();

    public abstract int getHeight();

    public abstract int getY();

    public void removeListener(ComponentListener lIIIIIIlIllllIl) {
        AbstractComponent lIIIIIIllIIIIII;
        lIIIIIIllIIIIII.listeners.remove(lIIIIIIlIllllIl);
    }

    public AbstractComponent(GUIContext lIIIIIIllIIlIIl) {
        AbstractComponent lIIIIIIllIIllII;
        lIIIIIIllIIllII.focus = false;
        lIIIIIIllIIllII.container = lIIIIIIllIIlIIl;
        lIIIIIIllIIllII.listeners = new HashSet();
        lIIIIIIllIIllII.input = lIIIIIIllIIlIIl.getInput();
        lIIIIIIllIIllII.input.addPrimaryListener(lIIIIIIllIIllII);
        lIIIIIIllIIllII.setLocation(0, 0);
    }

    protected void consumeEvent() {
        AbstractComponent lIIIIIIlIlIllII;
        lIIIIIIlIlIllII.input.consumeEvent();
    }

    public abstract void setLocation(int var1, int var2);

    public void setFocus(boolean lIIIIIIlIllIIIl) {
        AbstractComponent lIIIIIIlIllIIlI;
        if (lIIIIIIlIllIIIl) {
            if (currentFocus != null) {
                currentFocus.setFocus(false);
            }
            currentFocus = lIIIIIIlIllIIlI;
        } else if (currentFocus == lIIIIIIlIllIIlI) {
            currentFocus = null;
        }
        lIIIIIIlIllIIlI.focus = lIIIIIIlIllIIIl;
    }

    public abstract int getWidth();

    public abstract void render(GUIContext var1, Graphics var2) throws SlickException;
}

