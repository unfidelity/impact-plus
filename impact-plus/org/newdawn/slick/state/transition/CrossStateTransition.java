/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public abstract class CrossStateTransition
implements Transition {
    private /* synthetic */ GameState secondState;

    public void postRenderSecondState(StateBasedGame llllllllllllllllllIIlIlIlIIlIIII, GameContainer llllllllllllllllllIIlIlIlIIIllll, Graphics llllllllllllllllllIIlIlIlIIIlllI) throws SlickException {
    }

    @Override
    public void update(StateBasedGame llllllllllllllllllIIlIlIlIlIIIII, GameContainer llllllllllllllllllIIlIlIlIIlllll, int llllllllllllllllllIIlIlIlIIllllI) throws SlickException {
    }

    @Override
    public abstract boolean isComplete();

    public void preRenderFirstState(StateBasedGame llllllllllllllllllIIlIlIlIIllIll, GameContainer llllllllllllllllllIIlIlIlIIllIIl, Graphics llllllllllllllllllIIlIlIlIIllIII) throws SlickException {
    }

    public void preRenderSecondState(StateBasedGame llllllllllllllllllIIlIlIlIIlIlIl, GameContainer llllllllllllllllllIIlIlIlIIlIIll, Graphics llllllllllllllllllIIlIlIlIIlIIlI) throws SlickException {
    }

    @Override
    public void postRender(StateBasedGame llllllllllllllllllIIlIlIllIIlIII, GameContainer llllllllllllllllllIIlIlIllIIIllI, Graphics llllllllllllllllllIIlIlIllIIIlII) throws SlickException {
        CrossStateTransition llllllllllllllllllIIlIlIllIIlIlI;
        llllllllllllllllllIIlIlIllIIlIlI.preRenderSecondState(llllllllllllllllllIIlIlIllIIlIII, llllllllllllllllllIIlIlIllIIIllI, llllllllllllllllllIIlIlIllIIIlII);
        llllllllllllllllllIIlIlIllIIlIlI.secondState.render(llllllllllllllllllIIlIlIllIIIllI, llllllllllllllllllIIlIlIllIIlIII, llllllllllllllllllIIlIlIllIIIlII);
        llllllllllllllllllIIlIlIllIIlIlI.postRenderSecondState(llllllllllllllllllIIlIlIllIIlIII, llllllllllllllllllIIlIlIllIIIllI, llllllllllllllllllIIlIlIllIIIlII);
    }

    public CrossStateTransition(GameState llllllllllllllllllIIlIlIlllIIIll) {
        CrossStateTransition llllllllllllllllllIIlIlIlllIIlIl;
        llllllllllllllllllIIlIlIlllIIlIl.secondState = llllllllllllllllllIIlIlIlllIIIll;
    }

    @Override
    public void preRender(StateBasedGame llllllllllllllllllIIlIlIlIlIIlIl, GameContainer llllllllllllllllllIIlIlIlIlIIlII, Graphics llllllllllllllllllIIlIlIlIlIlIIl) throws SlickException {
        CrossStateTransition llllllllllllllllllIIlIlIlIlIIlll;
        llllllllllllllllllIIlIlIlIlIIlll.preRenderFirstState(llllllllllllllllllIIlIlIlIlIIlIl, llllllllllllllllllIIlIlIlIlIIlII, llllllllllllllllllIIlIlIlIlIlIIl);
    }
}

