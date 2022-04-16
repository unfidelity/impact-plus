/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;

public abstract class BasicGame
implements InputListener,
Game {
    protected /* synthetic */ boolean[] controllerDown;
    private /* synthetic */ String title;
    protected /* synthetic */ boolean[][] controllerButton;
    private static final /* synthetic */ int MAX_CONTROLLER_BUTTONS;
    protected /* synthetic */ boolean[] controllerLeft;
    protected /* synthetic */ boolean[] controllerUp;
    private static final /* synthetic */ int MAX_CONTROLLERS;
    protected /* synthetic */ boolean[] controllerRight;

    @Override
    public void controllerDownReleased(int llllllllIIIIlII) {
        llllllllIIIIlll.controllerDown[llllllllIIIIlII] = false;
    }

    @Override
    public void controllerRightReleased(int lllllllIllIllII) {
        lllllllIllIllIl.controllerRight[lllllllIllIllII] = false;
    }

    @Override
    public void keyPressed(int llllllllIlllIIl, char llllllllIlllIII) {
    }

    @Override
    public void controllerButtonPressed(int llllllllIIllIlI, int llllllllIIllIIl) {
        llllllllIIllllI.controllerButton[llllllllIIllIlI][llllllllIIllIIl] = true;
    }

    @Override
    public void controllerUpReleased(int lllllllIlIllllI) {
        lllllllIllIIIIl.controllerUp[lllllllIlIllllI] = false;
    }

    @Override
    public void controllerButtonReleased(int llllllllIIlIlII, int llllllllIIlIIll) {
        llllllllIIlIIlI.controllerButton[llllllllIIlIlII][llllllllIIlIIll] = false;
    }

    static {
        MAX_CONTROLLER_BUTTONS = 100;
        MAX_CONTROLLERS = 20;
    }

    @Override
    public void controllerLeftReleased(int lllllllIllllIII) {
        lllllllIlllIlll.controllerLeft[lllllllIllllIII] = false;
    }

    @Override
    public void mouseDragged(int llllllllIlIlllI, int llllllllIlIllIl, int llllllllIlIllII, int llllllllIlIlIll) {
    }

    @Override
    public void keyReleased(int llllllllIllIllI, char llllllllIllIlIl) {
    }

    @Override
    public String getTitle() {
        BasicGame llllllllIlllIll;
        return llllllllIlllIll.title;
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void mouseClicked(int llllllllIlIlIIl, int llllllllIlIlIII, int llllllllIlIIlll, int llllllllIlIIllI) {
    }

    @Override
    public void mouseReleased(int lllllllIlIlllII, int lllllllIlIllIll, int lllllllIlIllIlI) {
    }

    public BasicGame(String lllllllllIIIlIl) {
        BasicGame lllllllllIIIlII;
        lllllllllIIIlII.controllerLeft = new boolean[20];
        lllllllllIIIlII.controllerRight = new boolean[20];
        lllllllllIIIlII.controllerUp = new boolean[20];
        lllllllllIIIlII.controllerDown = new boolean[20];
        lllllllllIIIlII.controllerButton = new boolean[20][100];
        lllllllllIIIlII.title = lllllllllIIIlIl;
    }

    @Override
    public void controllerDownPressed(int llllllllIIIlIlI) {
        llllllllIIIlIll.controllerDown[llllllllIIIlIlI] = true;
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void mouseWheelMoved(int lllllllIlIllIII) {
    }

    @Override
    public void mouseMoved(int llllllllIllIIll, int llllllllIllIIlI, int llllllllIllIIIl, int llllllllIllIIII) {
    }

    @Override
    public void controllerUpPressed(int lllllllIllIIlII) {
        lllllllIllIIlIl.controllerUp[lllllllIllIIlII] = true;
    }

    @Override
    public void mousePressed(int llllllllIlIIlII, int llllllllIlIIIll, int llllllllIlIIIlI) {
    }

    @Override
    public void setInput(Input llllllllIllllll) {
    }

    @Override
    public boolean closeRequested() {
        return true;
    }

    @Override
    public void controllerRightPressed(int lllllllIlllIIlI) {
        lllllllIlllIIIl.controllerRight[lllllllIlllIIlI] = true;
    }

    @Override
    public abstract void update(GameContainer var1, int var2) throws SlickException;

    @Override
    public void controllerLeftPressed(int lllllllIlllllII) {
        lllllllIlllllIl.controllerLeft[lllllllIlllllII] = true;
    }

    @Override
    public abstract void init(GameContainer var1) throws SlickException;

    @Override
    public void inputEnded() {
    }
}

