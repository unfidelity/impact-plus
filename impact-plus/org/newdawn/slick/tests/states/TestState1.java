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
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.CrossStateTransition;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class TestState1
extends BasicGameState {
    private /* synthetic */ Font font;
    private /* synthetic */ StateBasedGame game;
    public static final /* synthetic */ int ID;

    @Override
    public void update(GameContainer llllllllllllllllllIIlllIllIIIlll, StateBasedGame llllllllllllllllllIIlllIllIIIllI, int llllllllllllllllllIIlllIllIIIlIl) {
    }

    static {
        ID = 1;
    }

    @Override
    public void keyReleased(int llllllllllllllllllIIlllIlIlllIII, char llllllllllllllllllIIlllIlIlllIlI) {
        TestState1 llllllllllllllllllIIlllIlIlllIIl;
        if (llllllllllllllllllIIlllIlIlllIII == 3) {
            GameState llllllllllllllllllIIlllIlIllllll = llllllllllllllllllIIlllIlIlllIIl.game.getState(2);
            final long llllllllllllllllllIIlllIlIlllllI = System.currentTimeMillis();
            CrossStateTransition llllllllllllllllllIIlllIlIllllIl = new CrossStateTransition(llllllllllllllllllIIlllIlIllllll){
                {
                    1 llllllllllllllllllIIllllIIIIlllI;
                    super(llllllllllllllllllIIllllIIIlIIII);
                }

                @Override
                public void init(GameState llllllllllllllllllIIlllIllllIlII, GameState llllllllllllllllllIIlllIllllIIll) {
                }

                @Override
                public boolean isComplete() {
                    1 llllllllllllllllllIIlllIlllllIlI;
                    return System.currentTimeMillis() - llllllllllllllllllIIlllIlllllIlI.llllllllllllllllllIIlllIlIlllllI > 2000L;
                }
            };
            llllllllllllllllllIIlllIlIlllIIl.game.enterState(2, llllllllllllllllllIIlllIlIllllIl, new EmptyTransition());
        }
        if (llllllllllllllllllIIlllIlIlllIII == 4) {
            llllllllllllllllllIIlllIlIlllIIl.game.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
    }

    @Override
    public void render(GameContainer llllllllllllllllllIIlllIllIIllIl, StateBasedGame llllllllllllllllllIIlllIllIIllII, Graphics llllllllllllllllllIIlllIllIIlIll) {
        TestState1 llllllllllllllllllIIlllIllIIlIlI;
        llllllllllllllllllIIlllIllIIlIll.setFont(llllllllllllllllllIIlllIllIIlIlI.font);
        llllllllllllllllllIIlllIllIIlIll.setColor(Color.white);
        llllllllllllllllllIIlllIllIIlIll.drawString("State Based Game Test", 100.0f, 100.0f);
        llllllllllllllllllIIlllIllIIlIll.drawString("Numbers 1-3 will switch between states.", 150.0f, 300.0f);
        llllllllllllllllllIIlllIllIIlIll.setColor(Color.red);
        llllllllllllllllllIIlllIllIIlIll.drawString("This is State 1", 200.0f, 50.0f);
    }

    @Override
    public void init(GameContainer llllllllllllllllllIIlllIllIlIlII, StateBasedGame llllllllllllllllllIIlllIllIlIIIl) throws SlickException {
        llllllllllllllllllIIlllIllIlIIlI.game = llllllllllllllllllIIlllIllIlIIIl;
        llllllllllllllllllIIlllIllIlIIlI.font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
    }

    @Override
    public int getID() {
        return 1;
    }

    public TestState1() {
        TestState1 llllllllllllllllllIIlllIllIllIIl;
    }
}

