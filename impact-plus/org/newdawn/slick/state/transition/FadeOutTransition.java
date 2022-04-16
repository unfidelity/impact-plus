/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class FadeOutTransition
implements Transition {
    private /* synthetic */ Color color;
    private /* synthetic */ int fadeTime;

    @Override
    public void init(GameState llllllllllllllllIlllIIIIIllllIIl, GameState llllllllllllllllIlllIIIIIllllIII) {
    }

    @Override
    public void update(StateBasedGame llllllllllllllllIlllIIIIlIIIIIll, GameContainer llllllllllllllllIlllIIIIlIIIIIlI, int llllllllllllllllIlllIIIIlIIIIIIl) {
        FadeOutTransition llllllllllllllllIlllIIIIlIIIIlII;
        llllllllllllllllIlllIIIIlIIIIlII.color.a += (float)llllllllllllllllIlllIIIIlIIIIIIl * (1.0f / (float)llllllllllllllllIlllIIIIlIIIIlII.fadeTime);
        if (llllllllllllllllIlllIIIIlIIIIlII.color.a > 1.0f) {
            llllllllllllllllIlllIIIIlIIIIlII.color.a = 1.0f;
        }
    }

    @Override
    public void preRender(StateBasedGame llllllllllllllllIlllIIIIIlllllIl, GameContainer llllllllllllllllIlllIIIIIlllllII, Graphics llllllllllllllllIlllIIIIIllllIll) {
    }

    public FadeOutTransition(Color llllllllllllllllIlllIIIIlIlIIIII) {
        llllllllllllllllIlllIIIIlIlIIIIl(llllllllllllllllIlllIIIIlIlIIIII, 500);
        FadeOutTransition llllllllllllllllIlllIIIIlIlIIIIl;
    }

    @Override
    public boolean isComplete() {
        FadeOutTransition llllllllllllllllIlllIIIIlIIlIlII;
        return llllllllllllllllIlllIIIIlIIlIlII.color.a >= 1.0f;
    }

    public FadeOutTransition() {
        llllllllllllllllIlllIIIIlIlIIlll(Color.black, 500);
        FadeOutTransition llllllllllllllllIlllIIIIlIlIIlll;
    }

    public FadeOutTransition(Color llllllllllllllllIlllIIIIlIIllIll, int llllllllllllllllIlllIIIIlIIlIlll) {
        FadeOutTransition llllllllllllllllIlllIIIIlIIllIIl;
        llllllllllllllllIlllIIIIlIIllIIl.color = new Color(llllllllllllllllIlllIIIIlIIllIll);
        llllllllllllllllIlllIIIIlIIllIIl.color.a = 0.0f;
        llllllllllllllllIlllIIIIlIIllIIl.fadeTime = llllllllllllllllIlllIIIIlIIlIlll;
    }

    @Override
    public void postRender(StateBasedGame llllllllllllllllIlllIIIIlIIIlllI, GameContainer llllllllllllllllIlllIIIIlIIIllIl, Graphics llllllllllllllllIlllIIIIlIIIllII) {
        FadeOutTransition llllllllllllllllIlllIIIIlIIIlIlI;
        Color llllllllllllllllIlllIIIIlIIIlIll = llllllllllllllllIlllIIIIlIIIllII.getColor();
        llllllllllllllllIlllIIIIlIIIllII.setColor(llllllllllllllllIlllIIIIlIIIlIlI.color);
        llllllllllllllllIlllIIIIlIIIllII.fillRect(0.0f, 0.0f, llllllllllllllllIlllIIIIlIIIllIl.getWidth() * 2, llllllllllllllllIlllIIIIlIIIllIl.getHeight() * 2);
        llllllllllllllllIlllIIIIlIIIllII.setColor(llllllllllllllllIlllIIIIlIIIlIll);
    }
}

