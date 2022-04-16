/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.states;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class TestState3
extends BasicGameState {
    private /* synthetic */ Font font;
    private /* synthetic */ StateBasedGame game;
    private /* synthetic */ String[] options;
    private /* synthetic */ int selected;
    public static final /* synthetic */ int ID;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void keyReleased(int lIllIlIlIIII, char lIllIlIlIIlI) {
        TestState3 lIllIlIlIlIl;
        if (lIllIlIlIIII == 208) {
            ++lIllIlIlIlIl.selected;
            if (lIllIlIlIlIl.selected >= lIllIlIlIlIl.options.length) {
                lIllIlIlIlIl.selected = 0;
            }
        }
        if (lIllIlIlIIII == 200) {
            --lIllIlIlIlIl.selected;
            if (lIllIlIlIlIl.selected < 0) {
                lIllIlIlIlIl.selected = lIllIlIlIlIl.options.length - 1;
            }
        }
        if (lIllIlIlIIII == 2) {
            lIllIlIlIlIl.game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
        if (lIllIlIlIIII == 3) {
            lIllIlIlIlIl.game.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
    }

    public TestState3() {
        TestState3 lIllIlllIIlI;
        lIllIlllIIlI.options = new String[]{"Start Game", "Credits", "Highscores", "Instructions", "Exit"};
    }

    @Override
    public void init(GameContainer lIllIllIllII, StateBasedGame lIllIllIlIIl) throws SlickException {
        lIllIllIllIl.font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        lIllIllIllIl.game = lIllIllIlIIl;
    }

    @Override
    public void render(GameContainer lIllIllIIIll, StateBasedGame lIllIllIIIlI, Graphics lIllIlIlllll) {
        TestState3 lIllIllIIIII;
        lIllIlIlllll.setFont(lIllIllIIIII.font);
        lIllIlIlllll.setColor(Color.blue);
        lIllIlIlllll.drawString("This is State 3", 200.0f, 50.0f);
        lIllIlIlllll.setColor(Color.white);
        for (int lIllIllIIlIl = 0; lIllIllIIlIl < lIllIllIIIII.options.length; ++lIllIllIIlIl) {
            lIllIlIlllll.drawString(lIllIllIIIII.options[lIllIllIIlIl], 400 - lIllIllIIIII.font.getWidth(lIllIllIIIII.options[lIllIllIIlIl]) / 2, 200 + lIllIllIIlIl * 50);
            if (lIllIllIIIII.selected != lIllIllIIlIl) continue;
            lIllIlIlllll.drawRect(200.0f, 190 + lIllIllIIlIl * 50, 400.0f, 50.0f);
        }
    }

    static {
        ID = 3;
    }

    @Override
    public void update(GameContainer lIllIlIlllII, StateBasedGame lIllIlIllIll, int lIllIlIllIlI) {
    }
}

