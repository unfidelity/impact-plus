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

public class VerticalSplitTransition
implements Transition {
    private /* synthetic */ boolean finish;
    private /* synthetic */ float offset;
    private /* synthetic */ Color background;
    private /* synthetic */ GameState prev;
    protected static /* synthetic */ SGL GL;

    @Override
    public void postRender(StateBasedGame lllllllllllllllIlllllIlIIIllIIII, GameContainer lllllllllllllllIlllllIlIIIlIllIl, Graphics lllllllllllllllIlllllIlIIIlIlIlI) throws SlickException {
        VerticalSplitTransition lllllllllllllllIlllllIlIIIllIIll;
        lllllllllllllllIlllllIlIIIlIlIlI.translate(0.0f, -lllllllllllllllIlllllIlIIIllIIll.offset);
        lllllllllllllllIlllllIlIIIlIlIlI.setClip(0, (int)(-lllllllllllllllIlllllIlIIIllIIll.offset), lllllllllllllllIlllllIlIIIlIllIl.getWidth(), lllllllllllllllIlllllIlIIIlIllIl.getHeight() / 2);
        if (lllllllllllllllIlllllIlIIIllIIll.background != null) {
            Color lllllllllllllllIlllllIlIIIlllIII = lllllllllllllllIlllllIlIIIlIlIlI.getColor();
            lllllllllllllllIlllllIlIIIlIlIlI.setColor(lllllllllllllllIlllllIlIIIllIIll.background);
            lllllllllllllllIlllllIlIIIlIlIlI.fillRect(0.0f, 0.0f, lllllllllllllllIlllllIlIIIlIllIl.getWidth(), lllllllllllllllIlllllIlIIIlIllIl.getHeight());
            lllllllllllllllIlllllIlIIIlIlIlI.setColor(lllllllllllllllIlllllIlIIIlllIII);
        }
        GL.glPushMatrix();
        lllllllllllllllIlllllIlIIIllIIll.prev.render(lllllllllllllllIlllllIlIIIlIllIl, lllllllllllllllIlllllIlIIIllIIII, lllllllllllllllIlllllIlIIIlIlIlI);
        GL.glPopMatrix();
        lllllllllllllllIlllllIlIIIlIlIlI.clearClip();
        lllllllllllllllIlllllIlIIIlIlIlI.resetTransform();
        lllllllllllllllIlllllIlIIIlIlIlI.translate(0.0f, lllllllllllllllIlllllIlIIIllIIll.offset);
        lllllllllllllllIlllllIlIIIlIlIlI.setClip(0, (int)((float)(lllllllllllllllIlllllIlIIIlIllIl.getHeight() / 2) + lllllllllllllllIlllllIlIIIllIIll.offset), lllllllllllllllIlllllIlIIIlIllIl.getWidth(), lllllllllllllllIlllllIlIIIlIllIl.getHeight() / 2);
        if (lllllllllllllllIlllllIlIIIllIIll.background != null) {
            Color lllllllllllllllIlllllIlIIIllIllI = lllllllllllllllIlllllIlIIIlIlIlI.getColor();
            lllllllllllllllIlllllIlIIIlIlIlI.setColor(lllllllllllllllIlllllIlIIIllIIll.background);
            lllllllllllllllIlllllIlIIIlIlIlI.fillRect(0.0f, 0.0f, lllllllllllllllIlllllIlIIIlIllIl.getWidth(), lllllllllllllllIlllllIlIIIlIllIl.getHeight());
            lllllllllllllllIlllllIlIIIlIlIlI.setColor(lllllllllllllllIlllllIlIIIllIllI);
        }
        GL.glPushMatrix();
        lllllllllllllllIlllllIlIIIllIIll.prev.render(lllllllllllllllIlllllIlIIIlIllIl, lllllllllllllllIlllllIlIIIllIIII, lllllllllllllllIlllllIlIIIlIlIlI);
        GL.glPopMatrix();
        lllllllllllllllIlllllIlIIIlIlIlI.clearClip();
        lllllllllllllllIlllllIlIIIlIlIlI.translate(0.0f, -lllllllllllllllIlllllIlIIIllIIll.offset);
    }

    @Override
    public boolean isComplete() {
        VerticalSplitTransition lllllllllllllllIlllllIlIIlIllIII;
        return lllllllllllllllIlllllIlIIlIllIII.finish;
    }

    @Override
    public void preRender(StateBasedGame lllllllllllllllIlllllIlIIIIllIll, GameContainer lllllllllllllllIlllllIlIIIIllIIl, Graphics lllllllllllllllIlllllIlIIIIlIlll) throws SlickException {
    }

    @Override
    public void init(GameState lllllllllllllllIlllllIlIIllIIIII, GameState lllllllllllllllIlllllIlIIlIllIlI) {
        lllllllllllllllIlllllIlIIllIIIlI.prev = lllllllllllllllIlllllIlIIlIllIlI;
    }

    static {
        GL = Renderer.get();
    }

    public VerticalSplitTransition(Color lllllllllllllllIlllllIlIIllIllll) {
        VerticalSplitTransition lllllllllllllllIlllllIlIIllIllIl;
        lllllllllllllllIlllllIlIIllIllIl.background = lllllllllllllllIlllllIlIIllIllll;
    }

    @Override
    public void update(StateBasedGame lllllllllllllllIlllllIIllllllllI, GameContainer lllllllllllllllIlllllIIlllllllIl, int lllllllllllllllIlllllIIllllllIll) throws SlickException {
        VerticalSplitTransition lllllllllllllllIlllllIIllllllIIl;
        lllllllllllllllIlllllIIllllllIIl.offset += (float)lllllllllllllllIlllllIIllllllIll * 1.0f;
        if (lllllllllllllllIlllllIIllllllIIl.offset > (float)(lllllllllllllllIlllllIIlllllllIl.getHeight() / 2)) {
            lllllllllllllllIlllllIIllllllIIl.finish = true;
        }
    }

    public VerticalSplitTransition() {
        VerticalSplitTransition lllllllllllllllIlllllIlIlIIIIIII;
    }
}

