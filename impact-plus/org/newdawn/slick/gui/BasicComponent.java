/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public abstract class BasicComponent
extends AbstractComponent {
    protected /* synthetic */ int height;
    protected /* synthetic */ int width;
    protected /* synthetic */ int y;
    protected /* synthetic */ int x;

    public BasicComponent(GUIContext llIIlIlIllIllII) {
        super(llIIlIlIllIllII);
        BasicComponent llIIlIlIllIllll;
    }

    @Override
    public int getWidth() {
        BasicComponent llIIlIlIllIIIII;
        return llIIlIlIllIIIII.width;
    }

    @Override
    public void setLocation(int llIIlIlIlIIllII, int llIIlIlIlIIlIll) {
        llIIlIlIlIIlIlI.x = llIIlIlIlIIllII;
        llIIlIlIlIIlIlI.y = llIIlIlIlIIlIll;
    }

    @Override
    public int getX() {
        BasicComponent llIIlIlIlIlllIl;
        return llIIlIlIlIlllIl.x;
    }

    @Override
    public int getHeight() {
        BasicComponent llIIlIlIllIIlll;
        return llIIlIlIllIIlll.height;
    }

    @Override
    public void render(GUIContext llIIlIlIlIlIlIl, Graphics llIIlIlIlIlIIIl) throws SlickException {
        BasicComponent llIIlIlIlIlIIll;
        llIIlIlIlIlIIll.renderImpl(llIIlIlIlIlIlIl, llIIlIlIlIlIIIl);
    }

    @Override
    public int getY() {
        BasicComponent llIIlIlIlIllIlI;
        return llIIlIlIlIllIlI.y;
    }

    public abstract void renderImpl(GUIContext var1, Graphics var2);
}

