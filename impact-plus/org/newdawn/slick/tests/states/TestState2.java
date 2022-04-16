/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.states;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class TestState2
extends BasicGameState {
    private /* synthetic */ StateBasedGame game;
    public static final /* synthetic */ int ID;
    private /* synthetic */ float ang;
    private /* synthetic */ Image image;
    private /* synthetic */ Font font;

    public TestState2() {
        TestState2 lllllllllllllllllIIIIlIIIlIIlIII;
    }

    @Override
    public void render(GameContainer lllllllllllllllllIIIIlIIIIIllllI, StateBasedGame lllllllllllllllllIIIIlIIIIIllIll, Graphics lllllllllllllllllIIIIlIIIIIlIlIl) {
        TestState2 lllllllllllllllllIIIIlIIIIIlIlll;
        lllllllllllllllllIIIIlIIIIIlIlIl.setFont(lllllllllllllllllIIIIlIIIIIlIlll.font);
        lllllllllllllllllIIIIlIIIIIlIlIl.setColor(Color.green);
        lllllllllllllllllIIIIlIIIIIlIlIl.drawString("This is State 2", 200.0f, 50.0f);
        lllllllllllllllllIIIIlIIIIIlIlIl.rotate(400.0f, 300.0f, lllllllllllllllllIIIIlIIIIIlIlll.ang);
        lllllllllllllllllIIIIlIIIIIlIlIl.drawImage(lllllllllllllllllIIIIlIIIIIlIlll.image, 400 - lllllllllllllllllIIIIlIIIIIlIlll.image.getWidth() / 2, 300 - lllllllllllllllllIIIIlIIIIIlIlll.image.getHeight() / 2);
    }

    @Override
    public void update(GameContainer lllllllllllllllllIIIIlIIIIIIlIlI, StateBasedGame lllllllllllllllllIIIIlIIIIIIlIIl, int lllllllllllllllllIIIIlIIIIIIlIII) {
        lllllllllllllllllIIIIlIIIIIIllII.ang += (float)lllllllllllllllllIIIIlIIIIIIlIII * 0.1f;
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void keyReleased(int lllllllllllllllllIIIIlIIIIIIIIlI, char lllllllllllllllllIIIIlIIIIIIIIIl) {
        TestState2 lllllllllllllllllIIIIlIIIIIIIIII;
        if (lllllllllllllllllIIIIlIIIIIIIIlI == 2) {
            lllllllllllllllllIIIIlIIIIIIIIII.game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        if (lllllllllllllllllIIIIlIIIIIIIIlI == 4) {
            lllllllllllllllllIIIIlIIIIIIIIII.game.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
    }

    @Override
    public void init(GameContainer lllllllllllllllllIIIIlIIIIllIlIl, StateBasedGame lllllllllllllllllIIIIlIIIIllIIII) throws SlickException {
        lllllllllllllllllIIIIlIIIIllIlll.game = lllllllllllllllllIIIIlIIIIllIIII;
        lllllllllllllllllIIIIlIIIIllIlll.font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        lllllllllllllllllIIIIlIIIIllIlll.image = new Image("testdata/logo.tga");
    }

    static {
        ID = 2;
    }
}

