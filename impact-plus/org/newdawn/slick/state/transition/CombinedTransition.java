/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class CombinedTransition
implements Transition {
    private /* synthetic */ ArrayList transitions;

    @Override
    public void init(GameState llllllllllllllllIIlllllIIlllIlII, GameState llllllllllllllllIIlllllIIlllIIII) {
        for (int llllllllllllllllIIlllllIIlllIllI = llllllllllllllllIIlllllIIlllIlIl.transitions.size() - 1; llllllllllllllllIIlllllIIlllIllI >= 0; --llllllllllllllllIIlllllIIlllIllI) {
            CombinedTransition llllllllllllllllIIlllllIIlllIlIl;
            ((Transition)llllllllllllllllIIlllllIIlllIlIl.transitions.get(llllllllllllllllIIlllllIIlllIllI)).init(llllllllllllllllIIlllllIIlllIlII, llllllllllllllllIIlllllIIlllIIII);
        }
    }

    public void addTransition(Transition llllllllllllllllIIlllllIlIllIIll) {
        CombinedTransition llllllllllllllllIIlllllIlIllIlII;
        llllllllllllllllIIlllllIlIllIlII.transitions.add(llllllllllllllllIIlllllIlIllIIll);
    }

    @Override
    public boolean isComplete() {
        CombinedTransition llllllllllllllllIIlllllIlIlIllII;
        for (int llllllllllllllllIIlllllIlIlIlllI = 0; llllllllllllllllIIlllllIlIlIlllI < llllllllllllllllIIlllllIlIlIllII.transitions.size(); ++llllllllllllllllIIlllllIlIlIlllI) {
            if (((Transition)llllllllllllllllIIlllllIlIlIllII.transitions.get(llllllllllllllllIIlllllIlIlIlllI)).isComplete()) continue;
            return false;
        }
        return true;
    }

    @Override
    public void postRender(StateBasedGame llllllllllllllllIIlllllIlIIlllll, GameContainer llllllllllllllllIIlllllIlIIllllI, Graphics llllllllllllllllIIlllllIlIIlllIl) throws SlickException {
        for (int llllllllllllllllIIlllllIlIlIIlIl = llllllllllllllllIIlllllIlIlIIlII.transitions.size() - 1; llllllllllllllllIIlllllIlIlIIlIl >= 0; --llllllllllllllllIIlllllIlIlIIlIl) {
            CombinedTransition llllllllllllllllIIlllllIlIlIIlII;
            ((Transition)llllllllllllllllIIlllllIlIlIIlII.transitions.get(llllllllllllllllIIlllllIlIlIIlIl)).postRender(llllllllllllllllIIlllllIlIIlllll, llllllllllllllllIIlllllIlIIllllI, llllllllllllllllIIlllllIlIIlllIl);
        }
    }

    @Override
    public void update(StateBasedGame llllllllllllllllIIlllllIlIIIIIll, GameContainer llllllllllllllllIIlllllIlIIIIIlI, int llllllllllllllllIIlllllIIlllllIl) throws SlickException {
        CombinedTransition llllllllllllllllIIlllllIlIIIIIII;
        for (int llllllllllllllllIIlllllIlIIIIlIl = 0; llllllllllllllllIIlllllIlIIIIlIl < llllllllllllllllIIlllllIlIIIIIII.transitions.size(); ++llllllllllllllllIIlllllIlIIIIlIl) {
            Transition llllllllllllllllIIlllllIlIIIIllI = (Transition)llllllllllllllllIIlllllIlIIIIIII.transitions.get(llllllllllllllllIIlllllIlIIIIlIl);
            if (llllllllllllllllIIlllllIlIIIIllI.isComplete()) continue;
            llllllllllllllllIIlllllIlIIIIllI.update(llllllllllllllllIIlllllIlIIIIIll, llllllllllllllllIIlllllIlIIIIIlI, llllllllllllllllIIlllllIIlllllIl);
        }
    }

    @Override
    public void preRender(StateBasedGame llllllllllllllllIIlllllIlIIlIIII, GameContainer llllllllllllllllIIlllllIlIIIllll, Graphics llllllllllllllllIIlllllIlIIIlllI) throws SlickException {
        CombinedTransition llllllllllllllllIIlllllIlIIlIlIl;
        for (int llllllllllllllllIIlllllIlIIlIllI = 0; llllllllllllllllIIlllllIlIIlIllI < llllllllllllllllIIlllllIlIIlIlIl.transitions.size(); ++llllllllllllllllIIlllllIlIIlIllI) {
            ((Transition)llllllllllllllllIIlllllIlIIlIlIl.transitions.get(llllllllllllllllIIlllllIlIIlIllI)).postRender(llllllllllllllllIIlllllIlIIlIIII, llllllllllllllllIIlllllIlIIIllll, llllllllllllllllIIlllllIlIIIlllI);
        }
    }

    public CombinedTransition() {
        CombinedTransition llllllllllllllllIIlllllIlIllIlll;
        llllllllllllllllIIlllllIlIllIlll.transitions = new ArrayList();
    }
}

