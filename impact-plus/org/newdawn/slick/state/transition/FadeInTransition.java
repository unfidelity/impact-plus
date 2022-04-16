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

public class FadeInTransition
implements Transition {
    private /* synthetic */ int fadeTime;
    private /* synthetic */ Color color;

    @Override
    public void preRender(StateBasedGame llIlIlllIllllII, GameContainer llIlIlllIlllIll, Graphics llIlIlllIlllIIl) {
    }

    public FadeInTransition() {
        llIllIIIIIIlIII(Color.black, 500);
        FadeInTransition llIllIIIIIIlIII;
    }

    @Override
    public void init(GameState llIlIlllIllIlII, GameState llIlIlllIllIIll) {
    }

    public FadeInTransition(Color llIlIlllllllIll) {
        llIlIlllllllIlI(llIlIlllllllIll, 500);
        FadeInTransition llIlIlllllllIlI;
    }

    @Override
    public void update(StateBasedGame llIlIllllIIIlII, GameContainer llIlIllllIIIIll, int llIlIlllIlllllI) {
        FadeInTransition llIlIllllIIIIII;
        llIlIllllIIIIII.color.a -= (float)llIlIlllIlllllI * (1.0f / (float)llIlIllllIIIIII.fadeTime);
        if (llIlIllllIIIIII.color.a < 0.0f) {
            llIlIllllIIIIII.color.a = 0.0f;
        }
    }

    public FadeInTransition(Color llIlIlllllIlIll, int llIlIlllllIllIl) {
        FadeInTransition llIlIlllllIllII;
        llIlIlllllIllII.fadeTime = 500;
        llIlIlllllIllII.color = new Color(llIlIlllllIlIll);
        llIlIlllllIllII.color.a = 1.0f;
        llIlIlllllIllII.fadeTime = llIlIlllllIllIl;
    }

    @Override
    public boolean isComplete() {
        FadeInTransition llIlIlllllIlIII;
        return llIlIlllllIlIII.color.a <= 0.0f;
    }

    @Override
    public void postRender(StateBasedGame llIlIllllIlllII, GameContainer llIlIllllIlIIlI, Graphics llIlIllllIlIIII) {
        FadeInTransition llIlIllllIlIlII;
        Color llIlIllllIlIllI = llIlIllllIlIIII.getColor();
        llIlIllllIlIIII.setColor(llIlIllllIlIlII.color);
        llIlIllllIlIIII.fillRect(0.0f, 0.0f, llIlIllllIlIIlI.getWidth() * 2, llIlIllllIlIIlI.getHeight() * 2);
        llIlIllllIlIIII.setColor(llIlIllllIlIllI);
    }
}

