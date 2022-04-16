/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state;

import java.util.HashMap;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.Transition;

public abstract class StateBasedGame
implements Game,
InputListener {
    private /* synthetic */ GameState currentState;
    private /* synthetic */ GameState nextState;
    private /* synthetic */ GameContainer container;
    private /* synthetic */ Transition leaveTransition;
    private /* synthetic */ HashMap states;
    private /* synthetic */ Transition enterTransition;
    private /* synthetic */ String title;

    @Override
    public void controllerLeftPressed(int lllllllllllllllllIIIIIIlIlIIIlll) {
        StateBasedGame lllllllllllllllllIIIIIIlIlIIlIlI;
        if (lllllllllllllllllIIIIIIlIlIIlIlI.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIlIIlIlI.currentState.controllerLeftPressed(lllllllllllllllllIIIIIIlIlIIIlll);
    }

    @Override
    public void controllerDownPressed(int lllllllllllllllllIIIIIIlIlIlIlll) {
        StateBasedGame lllllllllllllllllIIIIIIlIlIlllIl;
        if (lllllllllllllllllIIIIIIlIlIlllIl.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIlIlllIl.currentState.controllerDownPressed(lllllllllllllllllIIIIIIlIlIlIlll);
    }

    @Override
    public void keyPressed(int lllllllllllllllllIIIIIIIllllllIl, char lllllllllllllllllIIIIIIlIIIIIIII) {
        StateBasedGame lllllllllllllllllIIIIIIlIIIIIIll;
        if (lllllllllllllllllIIIIIIlIIIIIIll.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIIIIIIll.currentState.keyPressed(lllllllllllllllllIIIIIIIllllllIl, lllllllllllllllllIIIIIIlIIIIIIII);
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void controllerUpPressed(int lllllllllllllllllIIIIIIlIIIlIIll) {
        StateBasedGame lllllllllllllllllIIIIIIlIIIlIlIl;
        if (lllllllllllllllllIIIIIIlIIIlIlIl.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIIIlIlIl.currentState.controllerUpPressed(lllllllllllllllllIIIIIIlIIIlIIll);
    }

    @Override
    public void mouseClicked(int lllllllllllllllllIIIIIIIlIlllIIl, int lllllllllllllllllIIIIIIIlIllllIl, int lllllllllllllllllIIIIIIIlIllllII, int lllllllllllllllllIIIIIIIlIllIllI) {
        StateBasedGame lllllllllllllllllIIIIIIIlIllllll;
        if (lllllllllllllllllIIIIIIIlIllllll.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIlIllllll.currentState.mouseClicked(lllllllllllllllllIIIIIIIlIlllIIl, lllllllllllllllllIIIIIIIlIllllIl, lllllllllllllllllIIIIIIIlIllllII, lllllllllllllllllIIIIIIIlIllIllI);
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void setInput(Input lllllllllllllllllIIIIIlIIIlIlIIl) {
    }

    @Override
    public boolean isAcceptingInput() {
        StateBasedGame lllllllllllllllllIIIIIIIlIIlllII;
        if (lllllllllllllllllIIIIIIIlIIlllII.transitioning()) {
            return false;
        }
        return lllllllllllllllllIIIIIIIlIIlllII.currentState.isAcceptingInput();
    }

    public GameState getState(int lllllllllllllllllIIIIIlIIIIlIIIl) {
        StateBasedGame lllllllllllllllllIIIIIlIIIIlIIll;
        return (GameState)lllllllllllllllllIIIIIlIIIIlIIll.states.get(new Integer(lllllllllllllllllIIIIIlIIIIlIIIl));
    }

    public void enterState(int lllllllllllllllllIIIIIIlllllIlII, Transition lllllllllllllllllIIIIIIlllllIIlI, Transition lllllllllllllllllIIIIIIllllIlIlI) {
        StateBasedGame lllllllllllllllllIIIIIIlllllIlll;
        if (lllllllllllllllllIIIIIIlllllIIlI == null) {
            lllllllllllllllllIIIIIIlllllIIlI = new EmptyTransition();
        }
        if (lllllllllllllllllIIIIIIllllIlIlI == null) {
            lllllllllllllllllIIIIIIllllIlIlI = new EmptyTransition();
        }
        lllllllllllllllllIIIIIIlllllIlll.leaveTransition = lllllllllllllllllIIIIIIlllllIIlI;
        lllllllllllllllllIIIIIIlllllIlll.enterTransition = lllllllllllllllllIIIIIIllllIlIlI;
        lllllllllllllllllIIIIIIlllllIlll.nextState = lllllllllllllllllIIIIIIlllllIlll.getState(lllllllllllllllllIIIIIIlllllIlII);
        if (lllllllllllllllllIIIIIIlllllIlll.nextState == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("No game state registered with the ID: ").append(lllllllllllllllllIIIIIIlllllIlII)));
        }
        lllllllllllllllllIIIIIIlllllIlll.leaveTransition.init(lllllllllllllllllIIIIIIlllllIlll.currentState, lllllllllllllllllIIIIIIlllllIlll.nextState);
    }

    @Override
    public void controllerRightReleased(int lllllllllllllllllIIIIIIlIIIllllI) {
        StateBasedGame lllllllllllllllllIIIIIIlIIIlllll;
        if (lllllllllllllllllIIIIIIlIIIlllll.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIIIlllll.currentState.controllerRightReleased(lllllllllllllllllIIIIIIlIIIllllI);
    }

    @Override
    public void controllerUpReleased(int lllllllllllllllllIIIIIIlIIIIllll) {
        StateBasedGame lllllllllllllllllIIIIIIlIIIlIIII;
        if (lllllllllllllllllIIIIIIlIIIlIIII.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIIIlIIII.currentState.controllerUpReleased(lllllllllllllllllIIIIIIlIIIIllll);
    }

    public GameState getCurrentState() {
        StateBasedGame lllllllllllllllllIIIIIlIIIlIllIl;
        return lllllllllllllllllIIIIIlIIIlIllIl.currentState;
    }

    protected void postRenderState(GameContainer lllllllllllllllllIIIIIIlllIIlIlI, Graphics lllllllllllllllllIIIIIIlllIIlIIl) throws SlickException {
    }

    public abstract void initStatesList(GameContainer var1) throws SlickException;

    @Override
    public void mouseReleased(int lllllllllllllllllIIIIIIIlIlIIIII, int lllllllllllllllllIIIIIIIlIIlllll, int lllllllllllllllllIIIIIIIlIlIIIlI) {
        StateBasedGame lllllllllllllllllIIIIIIIlIlIIlIl;
        if (lllllllllllllllllIIIIIIIlIlIIlIl.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIlIlIIlIl.currentState.mouseReleased(lllllllllllllllllIIIIIIIlIlIIIII, lllllllllllllllllIIIIIIIlIIlllll, lllllllllllllllllIIIIIIIlIlIIIlI);
    }

    @Override
    public void controllerRightPressed(int lllllllllllllllllIIIIIIlIIlIIlll) {
        StateBasedGame lllllllllllllllllIIIIIIlIIllIIIl;
        if (lllllllllllllllllIIIIIIlIIllIIIl.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIIllIIIl.currentState.controllerRightPressed(lllllllllllllllllIIIIIIlIIlIIlll);
    }

    @Override
    public void controllerButtonReleased(int lllllllllllllllllIIIIIIlIllIlIIl, int lllllllllllllllllIIIIIIlIllIIlIl) {
        StateBasedGame lllllllllllllllllIIIIIIlIllIlIlI;
        if (lllllllllllllllllIIIIIIlIllIlIlI.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIllIlIlI.currentState.controllerButtonReleased(lllllllllllllllllIIIIIIlIllIlIIl, lllllllllllllllllIIIIIIlIllIIlIl);
    }

    @Override
    public void mousePressed(int lllllllllllllllllIIIIIIIlIllIIII, int lllllllllllllllllIIIIIIIlIlIllll, int lllllllllllllllllIIIIIIIlIlIlIlI) {
        StateBasedGame lllllllllllllllllIIIIIIIlIllIIIl;
        if (lllllllllllllllllIIIIIIIlIllIIIl.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIlIllIIIl.currentState.mousePressed(lllllllllllllllllIIIIIIIlIllIIII, lllllllllllllllllIIIIIIIlIlIllll, lllllllllllllllllIIIIIIIlIlIlIlI);
    }

    protected void postUpdateState(GameContainer lllllllllllllllllIIIIIIllIlIIllI, int lllllllllllllllllIIIIIIllIlIIlIl) throws SlickException {
    }

    @Override
    public void controllerButtonPressed(int lllllllllllllllllIIIIIIlIllllllI, int lllllllllllllllllIIIIIIlIllllIll) {
        StateBasedGame lllllllllllllllllIIIIIIlIllllIlI;
        if (lllllllllllllllllIIIIIIlIllllIlI.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIllllIlI.currentState.controllerButtonPressed(lllllllllllllllllIIIIIIlIllllllI, lllllllllllllllllIIIIIIlIllllIll);
    }

    @Override
    public void controllerLeftReleased(int lllllllllllllllllIIIIIIlIIlllIlI) {
        StateBasedGame lllllllllllllllllIIIIIIlIIlllIll;
        if (lllllllllllllllllIIIIIIlIIlllIll.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIIlllIll.currentState.controllerLeftReleased(lllllllllllllllllIIIIIIlIIlllIlI);
    }

    @Override
    public final void update(GameContainer lllllllllllllllllIIIIIIllIllIlIl, int lllllllllllllllllIIIIIIllIlIllIl) throws SlickException {
        StateBasedGame lllllllllllllllllIIIIIIllIllIlll;
        lllllllllllllllllIIIIIIllIllIlll.preUpdateState(lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIlIllIl);
        if (lllllllllllllllllIIIIIIllIllIlll.leaveTransition != null) {
            lllllllllllllllllIIIIIIllIllIlll.leaveTransition.update(lllllllllllllllllIIIIIIllIllIlll, lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIlIllIl);
            if (lllllllllllllllllIIIIIIllIllIlll.leaveTransition.isComplete()) {
                lllllllllllllllllIIIIIIllIllIlll.currentState.leave(lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIllIlll);
                GameState lllllllllllllllllIIIIIIllIlllIIl = lllllllllllllllllIIIIIIllIllIlll.currentState;
                lllllllllllllllllIIIIIIllIllIlll.currentState = lllllllllllllllllIIIIIIllIllIlll.nextState;
                lllllllllllllllllIIIIIIllIllIlll.nextState = null;
                lllllllllllllllllIIIIIIllIllIlll.leaveTransition = null;
                lllllllllllllllllIIIIIIllIllIlll.currentState.enter(lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIllIlll);
                if (lllllllllllllllllIIIIIIllIllIlll.enterTransition != null) {
                    lllllllllllllllllIIIIIIllIllIlll.enterTransition.init(lllllllllllllllllIIIIIIllIllIlll.currentState, lllllllllllllllllIIIIIIllIlllIIl);
                }
            } else {
                return;
            }
        }
        if (lllllllllllllllllIIIIIIllIllIlll.enterTransition != null) {
            lllllllllllllllllIIIIIIllIllIlll.enterTransition.update(lllllllllllllllllIIIIIIllIllIlll, lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIlIllIl);
            if (lllllllllllllllllIIIIIIllIllIlll.enterTransition.isComplete()) {
                lllllllllllllllllIIIIIIllIllIlll.enterTransition = null;
            } else {
                return;
            }
        }
        lllllllllllllllllIIIIIIllIllIlll.currentState.update(lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIllIlll, lllllllllllllllllIIIIIIllIlIllIl);
        lllllllllllllllllIIIIIIllIllIlll.postUpdateState(lllllllllllllllllIIIIIIllIllIlIl, lllllllllllllllllIIIIIIllIlIllIl);
    }

    public void enterState(int lllllllllllllllllIIIIIlIIIIIlIII) {
        StateBasedGame lllllllllllllllllIIIIIlIIIIIlIlI;
        lllllllllllllllllIIIIIlIIIIIlIlI.enterState(lllllllllllllllllIIIIIlIIIIIlIII, new EmptyTransition(), new EmptyTransition());
    }

    public int getCurrentStateID() {
        StateBasedGame lllllllllllllllllIIIIIlIIIlllIII;
        return lllllllllllllllllIIIIIlIIIlllIII.currentState.getID();
    }

    @Override
    public void mouseDragged(int lllllllllllllllllIIIIIIIllIIllll, int lllllllllllllllllIIIIIIIllIIlllI, int lllllllllllllllllIIIIIIIllIIIllI, int lllllllllllllllllIIIIIIIllIIIlIl) {
        StateBasedGame lllllllllllllllllIIIIIIIllIIlIlI;
        if (lllllllllllllllllIIIIIIIllIIlIlI.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIllIIlIlI.currentState.mouseDragged(lllllllllllllllllIIIIIIIllIIllll, lllllllllllllllllIIIIIIIllIIlllI, lllllllllllllllllIIIIIIIllIIIllI, lllllllllllllllllIIIIIIIllIIIlIl);
    }

    @Override
    public boolean closeRequested() {
        return true;
    }

    private boolean transitioning() {
        StateBasedGame lllllllllllllllllIIIIIIllIlIIIIl;
        return lllllllllllllllllIIIIIIllIlIIIIl.leaveTransition != null || lllllllllllllllllIIIIIIllIlIIIIl.enterTransition != null;
    }

    @Override
    public final void render(GameContainer lllllllllllllllllIIIIIIlllIlIIII, Graphics lllllllllllllllllIIIIIIlllIlIIlI) throws SlickException {
        StateBasedGame lllllllllllllllllIIIIIIlllIlIlII;
        lllllllllllllllllIIIIIIlllIlIlII.preRenderState(lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIIlI);
        if (lllllllllllllllllIIIIIIlllIlIlII.leaveTransition != null) {
            lllllllllllllllllIIIIIIlllIlIlII.leaveTransition.preRender(lllllllllllllllllIIIIIIlllIlIlII, lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIIlI);
        } else if (lllllllllllllllllIIIIIIlllIlIlII.enterTransition != null) {
            lllllllllllllllllIIIIIIlllIlIlII.enterTransition.preRender(lllllllllllllllllIIIIIIlllIlIlII, lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIIlI);
        }
        lllllllllllllllllIIIIIIlllIlIlII.currentState.render(lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIlII, lllllllllllllllllIIIIIIlllIlIIlI);
        if (lllllllllllllllllIIIIIIlllIlIlII.leaveTransition != null) {
            lllllllllllllllllIIIIIIlllIlIlII.leaveTransition.postRender(lllllllllllllllllIIIIIIlllIlIlII, lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIIlI);
        } else if (lllllllllllllllllIIIIIIlllIlIlII.enterTransition != null) {
            lllllllllllllllllIIIIIIlllIlIlII.enterTransition.postRender(lllllllllllllllllIIIIIIlllIlIlII, lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIIlI);
        }
        lllllllllllllllllIIIIIIlllIlIlII.postRenderState(lllllllllllllllllIIIIIIlllIlIIII, lllllllllllllllllIIIIIIlllIlIIlI);
    }

    @Override
    public void keyReleased(int lllllllllllllllllIIIIIIIllllIIIl, char lllllllllllllllllIIIIIIIllllIIll) {
        StateBasedGame lllllllllllllllllIIIIIIIllllIIlI;
        if (lllllllllllllllllIIIIIIIllllIIlI.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIllllIIlI.currentState.keyReleased(lllllllllllllllllIIIIIIIllllIIIl, lllllllllllllllllIIIIIIIllllIIll);
    }

    public void addState(GameState lllllllllllllllllIIIIIlIIIIlllII) {
        StateBasedGame lllllllllllllllllIIIIIlIIIIllllI;
        lllllllllllllllllIIIIIlIIIIllllI.states.put(new Integer(lllllllllllllllllIIIIIlIIIIlllII.getID()), lllllllllllllllllIIIIIlIIIIlllII);
        if (lllllllllllllllllIIIIIlIIIIllllI.currentState.getID() == -1) {
            lllllllllllllllllIIIIIlIIIIllllI.currentState = lllllllllllllllllIIIIIlIIIIlllII;
        }
    }

    protected void preRenderState(GameContainer lllllllllllllllllIIIIIIlllIIllIl, Graphics lllllllllllllllllIIIIIIlllIIllII) throws SlickException {
    }

    public GameContainer getContainer() {
        StateBasedGame lllllllllllllllllIIIIIIllIIlIIIl;
        return lllllllllllllllllIIIIIIllIIlIIIl.container;
    }

    public StateBasedGame(String lllllllllllllllllIIIIIlIIlIIIIIl) {
        StateBasedGame lllllllllllllllllIIIIIlIIlIIllIl;
        lllllllllllllllllIIIIIlIIlIIllIl.states = new HashMap();
        lllllllllllllllllIIIIIlIIlIIllIl.title = lllllllllllllllllIIIIIlIIlIIIIIl;
        lllllllllllllllllIIIIIlIIlIIllIl.currentState = new BasicGameState(){

            @Override
            public void update(GameContainer llllIlIIllIIIll, StateBasedGame llllIlIIllIIIlI, int llllIlIIllIIIIl) throws SlickException {
            }
            {
                1 llllIlIlIIIIIII;
            }

            public void render(StateBasedGame llllIlIIllIIllI, Graphics llllIlIIllIIlIl) throws SlickException {
            }

            @Override
            public void init(GameContainer llllIlIIllIlIIl, StateBasedGame llllIlIIllIlIII) throws SlickException {
            }

            @Override
            public int getID() {
                return -1;
            }

            @Override
            public void render(GameContainer llllIlIIlIlllll, StateBasedGame llllIlIIlIllllI, Graphics llllIlIIlIlllIl) throws SlickException {
            }
        };
    }

    public int getStateCount() {
        StateBasedGame lllllllllllllllllIIIIIlIIIllllII;
        return lllllllllllllllllIIIIIlIIIllllII.states.keySet().size();
    }

    @Override
    public void mouseWheelMoved(int lllllllllllllllllIIIIIIIlIIlIlII) {
        StateBasedGame lllllllllllllllllIIIIIIIlIIlIlll;
        if (lllllllllllllllllIIIIIIIlIIlIlll.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIlIIlIlll.currentState.mouseWheelMoved(lllllllllllllllllIIIIIIIlIIlIlII);
    }

    @Override
    public String getTitle() {
        StateBasedGame lllllllllllllllllIIIIIIllIIlIlII;
        return lllllllllllllllllIIIIIIllIIlIlII.title;
    }

    @Override
    public void mouseMoved(int lllllllllllllllllIIIIIIIlllIIlll, int lllllllllllllllllIIIIIIIllIllllI, int lllllllllllllllllIIIIIIIllIlllIl, int lllllllllllllllllIIIIIIIllIlllII) {
        StateBasedGame lllllllllllllllllIIIIIIIlllIlIIl;
        if (lllllllllllllllllIIIIIIIlllIlIIl.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIIlllIlIIl.currentState.mouseMoved(lllllllllllllllllIIIIIIIlllIIlll, lllllllllllllllllIIIIIIIllIllllI, lllllllllllllllllIIIIIIIllIlllIl, lllllllllllllllllIIIIIIIllIlllII);
    }

    protected void preUpdateState(GameContainer lllllllllllllllllIIIIIIllIlIlIIl, int lllllllllllllllllIIIIIIllIlIlIII) throws SlickException {
    }

    @Override
    public void controllerDownReleased(int lllllllllllllllllIIIIIIlIlIIllIl) {
        StateBasedGame lllllllllllllllllIIIIIIlIlIIlllI;
        if (lllllllllllllllllIIIIIIlIlIIlllI.transitioning()) {
            return;
        }
        lllllllllllllllllIIIIIIlIlIIlllI.currentState.controllerDownReleased(lllllllllllllllllIIIIIIlIlIIllIl);
    }

    @Override
    public final void init(GameContainer lllllllllllllllllIIIIIIlllIllIlI) throws SlickException {
        StateBasedGame lllllllllllllllllIIIIIIlllIllllI;
        lllllllllllllllllIIIIIIlllIllllI.container = lllllllllllllllllIIIIIIlllIllIlI;
        lllllllllllllllllIIIIIIlllIllllI.initStatesList(lllllllllllllllllIIIIIIlllIllIlI);
        for (GameState lllllllllllllllllIIIIIIlllIlllll : lllllllllllllllllIIIIIIlllIllllI.states.values()) {
            lllllllllllllllllIIIIIIlllIlllll.init(lllllllllllllllllIIIIIIlllIllIlI, lllllllllllllllllIIIIIIlllIllllI);
        }
        if (lllllllllllllllllIIIIIIlllIllllI.currentState != null) {
            lllllllllllllllllIIIIIIlllIllllI.currentState.enter(lllllllllllllllllIIIIIIlllIllIlI, lllllllllllllllllIIIIIIlllIllllI);
        }
    }
}

