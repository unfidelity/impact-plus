/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class HorizontalSplitTransition
implements Transition {
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ Color background;
    private /* synthetic */ GameState prev;
    private /* synthetic */ boolean finish;
    private /* synthetic */ float offset;

    @Override
    public void init(GameState lIIllIIIIllIIll, GameState lIIllIIIIllIIII) {
        lIIllIIIIllIIIl.prev = lIIllIIIIllIIII;
    }

    public HorizontalSplitTransition(Color lIIllIIIIllIlll) {
        HorizontalSplitTransition lIIllIIIIlllIlI;
        lIIllIIIIlllIlI.background = lIIllIIIIllIlll;
    }

    public HorizontalSplitTransition() {
        HorizontalSplitTransition lIIllIIIIlllllI;
    }

    @Override
    public void postRender(StateBasedGame lIIllIIIIIlIIIl, GameContainer lIIllIIIIIIIlll, Graphics lIIllIIIIIIIlIl) throws SlickException {
        HorizontalSplitTransition lIIllIIIIIIlIll;
        lIIllIIIIIIIlIl.translate(-lIIllIIIIIIlIll.offset, 0.0f);
        lIIllIIIIIIIlIl.setClip((int)(-lIIllIIIIIIlIll.offset), 0, lIIllIIIIIIIlll.getWidth() / 2, lIIllIIIIIIIlll.getHeight());
        if (lIIllIIIIIIlIll.background != null) {
            Color lIIllIIIIIlIlll = lIIllIIIIIIIlIl.getColor();
            lIIllIIIIIIIlIl.setColor(lIIllIIIIIIlIll.background);
            lIIllIIIIIIIlIl.fillRect(0.0f, 0.0f, lIIllIIIIIIIlll.getWidth(), lIIllIIIIIIIlll.getHeight());
            lIIllIIIIIIIlIl.setColor(lIIllIIIIIlIlll);
        }
        GL.glPushMatrix();
        lIIllIIIIIIlIll.prev.render(lIIllIIIIIIIlll, lIIllIIIIIlIIIl, lIIllIIIIIIIlIl);
        GL.glPopMatrix();
        lIIllIIIIIIIlIl.clearClip();
        lIIllIIIIIIIlIl.translate(lIIllIIIIIIlIll.offset * 2.0f, 0.0f);
        lIIllIIIIIIIlIl.setClip((int)((float)(lIIllIIIIIIIlll.getWidth() / 2) + lIIllIIIIIIlIll.offset), 0, lIIllIIIIIIIlll.getWidth() / 2, lIIllIIIIIIIlll.getHeight());
        if (lIIllIIIIIIlIll.background != null) {
            Color lIIllIIIIIlIlIl = lIIllIIIIIIIlIl.getColor();
            lIIllIIIIIIIlIl.setColor(lIIllIIIIIIlIll.background);
            lIIllIIIIIIIlIl.fillRect(0.0f, 0.0f, lIIllIIIIIIIlll.getWidth(), lIIllIIIIIIIlll.getHeight());
            lIIllIIIIIIIlIl.setColor(lIIllIIIIIlIlIl);
        }
        GL.glPushMatrix();
        lIIllIIIIIIlIll.prev.render(lIIllIIIIIIIlll, lIIllIIIIIlIIIl, lIIllIIIIIIIlIl);
        GL.glPopMatrix();
        lIIllIIIIIIIlIl.clearClip();
        lIIllIIIIIIIlIl.translate(-lIIllIIIIIIlIll.offset, 0.0f);
    }

    @Override
    public void update(StateBasedGame lIIlIlllllIIllI, GameContainer lIIlIlllllIIlIl, int lIIlIlllllIIlII) throws SlickException {
        HorizontalSplitTransition lIIlIlllllIIIll;
        lIIlIlllllIIIll.offset += (float)lIIlIlllllIIlII * 1.0f;
        if (lIIlIlllllIIIll.offset > (float)(lIIlIlllllIIlIl.getWidth() / 2)) {
            lIIlIlllllIIIll.finish = true;
        }
    }

    static {
        GL = Renderer.get();
    }

    @Override
    public void preRender(StateBasedGame lIIlIllllllllII, GameContainer lIIlIlllllllIlI, Graphics lIIlIlllllllIII) throws SlickException {
    }

    @Override
    public boolean isComplete() {
        HorizontalSplitTransition lIIllIIIIlIllIl;
        return lIIllIIIIlIllIl.finish;
    }
}

