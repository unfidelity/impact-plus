/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class BasicGameState
implements GameState {
    @Override
    public void controllerDownReleased(int lllllllllllllllllllIlllIIllIllll) {
    }

    @Override
    public void leave(GameContainer lllllllllllllllllllIlllIIlIIIIIl, StateBasedGame lllllllllllllllllllIlllIIlIIIIII) throws SlickException {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void mousePressed(int lllllllllllllllllllIlllIIlIIllII, int lllllllllllllllllllIlllIIlIIlIll, int lllllllllllllllllllIlllIIlIIlIlI) {
    }

    @Override
    public void controllerUpReleased(int lllllllllllllllllllIlllIIllIIIll) {
    }

    @Override
    public void keyPressed(int lllllllllllllllllllIlllIIllIIIIl, char lllllllllllllllllllIlllIIllIIIII) {
    }

    @Override
    public void enter(GameContainer lllllllllllllllllllIlllIIlIIIlII, StateBasedGame lllllllllllllllllllIlllIIlIIIIll) throws SlickException {
    }

    @Override
    public void mouseWheelMoved(int lllllllllllllllllllIlllIIIlllllI) {
    }

    @Override
    public void controllerButtonPressed(int lllllllllllllllllllIlllIIlllIlll, int lllllllllllllllllllIlllIIlllIllI) {
    }

    @Override
    public void keyReleased(int lllllllllllllllllllIlllIIlIllllI, char lllllllllllllllllllIlllIIlIlllIl) {
    }

    @Override
    public void controllerRightReleased(int lllllllllllllllllllIlllIIllIIlll) {
    }

    @Override
    public void controllerLeftReleased(int lllllllllllllllllllIlllIIllIlIll) {
    }

    @Override
    public void controllerRightPressed(int lllllllllllllllllllIlllIIllIlIIl) {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void mouseDragged(int lllllllllllllllllllIlllIIlIlIllI, int lllllllllllllllllllIlllIIlIlIlIl, int lllllllllllllllllllIlllIIlIlIlII, int lllllllllllllllllllIlllIIlIlIIll) {
    }

    @Override
    public void controllerDownPressed(int lllllllllllllllllllIlllIIlllIIIl) {
    }

    @Override
    public void mouseReleased(int lllllllllllllllllllIlllIIlIIlIII, int lllllllllllllllllllIlllIIlIIIlll, int lllllllllllllllllllIlllIIlIIIllI) {
    }

    @Override
    public void controllerButtonReleased(int lllllllllllllllllllIlllIIlllIlII, int lllllllllllllllllllIlllIIlllIIll) {
    }

    @Override
    public void setInput(Input lllllllllllllllllllIlllIIllllIlI) {
    }

    public BasicGameState() {
        BasicGameState lllllllllllllllllllIlllIIllllllI;
    }

    @Override
    public abstract int getID();

    @Override
    public void mouseClicked(int lllllllllllllllllllIlllIIlIlIIIl, int lllllllllllllllllllIlllIIlIlIIII, int lllllllllllllllllllIlllIIlIIllll, int lllllllllllllllllllIlllIIlIIlllI) {
    }

    @Override
    public void controllerLeftPressed(int lllllllllllllllllllIlllIIllIllIl) {
    }

    @Override
    public void controllerUpPressed(int lllllllllllllllllllIlllIIllIIlIl) {
    }

    @Override
    public void mouseMoved(int lllllllllllllllllllIlllIIlIllIll, int lllllllllllllllllllIlllIIlIllIlI, int lllllllllllllllllllIlllIIlIllIIl, int lllllllllllllllllllIlllIIlIllIII) {
    }
}

