/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class RotateTransition
implements Transition {
    private /* synthetic */ float scale;
    private /* synthetic */ boolean finish;
    private /* synthetic */ Color background;
    private /* synthetic */ GameState prev;
    private /* synthetic */ float ang;

    public RotateTransition(Color lllllllllllllllIlllIllIllIlIlIII) {
        RotateTransition lllllllllllllllIlllIllIllIlIIllI;
        lllllllllllllllIlllIllIllIlIIllI.scale = 1.0f;
        lllllllllllllllIlllIllIllIlIIllI.background = lllllllllllllllIlllIllIllIlIlIII;
    }

    @Override
    public void init(GameState lllllllllllllllIlllIllIllIIlllll, GameState lllllllllllllllIlllIllIllIIllllI) {
        lllllllllllllllIlllIllIllIIlllIl.prev = lllllllllllllllIlllIllIllIIllllI;
    }

    @Override
    public void update(StateBasedGame lllllllllllllllIlllIllIlIllIIllI, GameContainer lllllllllllllllIlllIllIlIllIIlII, int lllllllllllllllIlllIllIlIllIIIlI) throws SlickException {
        RotateTransition lllllllllllllllIlllIllIlIllIlIII;
        lllllllllllllllIlllIllIlIllIlIII.ang += (float)lllllllllllllllIlllIllIlIllIIIlI * 0.5f;
        if (lllllllllllllllIlllIllIlIllIlIII.ang > 500.0f) {
            lllllllllllllllIlllIllIlIllIlIII.finish = true;
        }
        lllllllllllllllIlllIllIlIllIlIII.scale -= (float)lllllllllllllllIlllIllIlIllIIIlI * 0.001f;
        if (lllllllllllllllIlllIllIlIllIlIII.scale < 0.0f) {
            lllllllllllllllIlllIllIlIllIlIII.scale = 0.0f;
        }
    }

    @Override
    public void postRender(StateBasedGame lllllllllllllllIlllIllIlIllllllI, GameContainer lllllllllllllllIlllIllIlIlllllII, Graphics lllllllllllllllIlllIllIlIllllIll) throws SlickException {
        RotateTransition lllllllllllllllIlllIllIlIllllIlI;
        lllllllllllllllIlllIllIlIllllIll.translate(lllllllllllllllIlllIllIlIlllllII.getWidth() / 2, lllllllllllllllIlllIllIlIlllllII.getHeight() / 2);
        lllllllllllllllIlllIllIlIllllIll.scale(lllllllllllllllIlllIllIlIllllIlI.scale, lllllllllllllllIlllIllIlIllllIlI.scale);
        lllllllllllllllIlllIllIlIllllIll.rotate(0.0f, 0.0f, lllllllllllllllIlllIllIlIllllIlI.ang);
        lllllllllllllllIlllIllIlIllllIll.translate(-lllllllllllllllIlllIllIlIlllllII.getWidth() / 2, -lllllllllllllllIlllIllIlIlllllII.getHeight() / 2);
        if (lllllllllllllllIlllIllIlIllllIlI.background != null) {
            Color lllllllllllllllIlllIllIllIIIIIlI = lllllllllllllllIlllIllIlIllllIll.getColor();
            lllllllllllllllIlllIllIlIllllIll.setColor(lllllllllllllllIlllIllIlIllllIlI.background);
            lllllllllllllllIlllIllIlIllllIll.fillRect(0.0f, 0.0f, lllllllllllllllIlllIllIlIlllllII.getWidth(), lllllllllllllllIlllIllIlIlllllII.getHeight());
            lllllllllllllllIlllIllIlIllllIll.setColor(lllllllllllllllIlllIllIllIIIIIlI);
        }
        lllllllllllllllIlllIllIlIllllIlI.prev.render(lllllllllllllllIlllIllIlIlllllII, lllllllllllllllIlllIllIlIllllllI, lllllllllllllllIlllIllIlIllllIll);
        lllllllllllllllIlllIllIlIllllIll.translate(lllllllllllllllIlllIllIlIlllllII.getWidth() / 2, lllllllllllllllIlllIllIlIlllllII.getHeight() / 2);
        lllllllllllllllIlllIllIlIllllIll.rotate(0.0f, 0.0f, -lllllllllllllllIlllIllIlIllllIlI.ang);
        lllllllllllllllIlllIllIlIllllIll.scale(1.0f / lllllllllllllllIlllIllIlIllllIlI.scale, 1.0f / lllllllllllllllIlllIllIlIllllIlI.scale);
        lllllllllllllllIlllIllIlIllllIll.translate(-lllllllllllllllIlllIllIlIlllllII.getWidth() / 2, -lllllllllllllllIlllIllIlIlllllII.getHeight() / 2);
    }

    @Override
    public boolean isComplete() {
        RotateTransition lllllllllllllllIlllIllIllIIllIlI;
        return lllllllllllllllIlllIllIllIIllIlI.finish;
    }

    public RotateTransition() {
        RotateTransition lllllllllllllllIlllIllIllIllIIlI;
        lllllllllllllllIlllIllIllIllIIlI.scale = 1.0f;
    }

    @Override
    public void preRender(StateBasedGame lllllllllllllllIlllIllIlIlllIlII, GameContainer lllllllllllllllIlllIllIlIlllIIll, Graphics lllllllllllllllIlllIllIlIlllIIlI) throws SlickException {
    }
}

