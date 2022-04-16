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

public class EmptyTransition
implements Transition {
    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public void postRender(StateBasedGame lllllllllllllllllllIlllIIIlllIII, GameContainer lllllllllllllllllllIlllIIIllIlll, Graphics lllllllllllllllllllIlllIIIllIllI) throws SlickException {
    }

    @Override
    public void preRender(StateBasedGame lllllllllllllllllllIlllIIIllIlII, GameContainer lllllllllllllllllllIlllIIIllIIll, Graphics lllllllllllllllllllIlllIIIllIIlI) throws SlickException {
    }

    public EmptyTransition() {
        EmptyTransition lllllllllllllllllllIlllIIIlllIll;
    }

    @Override
    public void init(GameState lllllllllllllllllllIlllIIIlIllII, GameState lllllllllllllllllllIlllIIIlIlIll) {
    }

    @Override
    public void update(StateBasedGame lllllllllllllllllllIlllIIIllIIII, GameContainer lllllllllllllllllllIlllIIIlIllll, int lllllllllllllllllllIlllIIIlIlllI) throws SlickException {
    }
}

