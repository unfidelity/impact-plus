/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class SelectTransition
implements Transition {
    private /* synthetic */ float xp1;
    private /* synthetic */ Color background;
    private /* synthetic */ boolean moveBackDone;
    private /* synthetic */ float yp2;
    private /* synthetic */ float xp2;
    private /* synthetic */ float yp1;
    private /* synthetic */ boolean init;
    private /* synthetic */ int pause;
    private /* synthetic */ boolean finish;
    private /* synthetic */ GameState prev;
    private /* synthetic */ float scale1;
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ float scale2;

    public SelectTransition() {
        SelectTransition lllllllllllllllllIlIllIlllllIIII;
        lllllllllllllllllIlIllIlllllIIII.scale1 = 1.0f;
        lllllllllllllllllIlIllIlllllIIII.xp1 = 0.0f;
        lllllllllllllllllIlIllIlllllIIII.yp1 = 0.0f;
        lllllllllllllllllIlIllIlllllIIII.scale2 = 0.4f;
        lllllllllllllllllIlIllIlllllIIII.xp2 = 0.0f;
        lllllllllllllllllIlIllIlllllIIII.yp2 = 0.0f;
        lllllllllllllllllIlIllIlllllIIII.init = false;
        lllllllllllllllllIlIllIlllllIIII.moveBackDone = false;
        lllllllllllllllllIlIllIlllllIIII.pause = 300;
    }

    @Override
    public void init(GameState lllllllllllllllllIlIllIlllIlIlII, GameState lllllllllllllllllIlIllIlllIlIIlI) {
        lllllllllllllllllIlIllIlllIlIllI.prev = lllllllllllllllllIlIllIlllIlIIlI;
    }

    @Override
    public void preRender(StateBasedGame lllllllllllllllllIlIllIlIlllIlII, GameContainer lllllllllllllllllIlIllIlIllllIlI, Graphics lllllllllllllllllIlIllIlIlllIIII) throws SlickException {
        SelectTransition lllllllllllllllllIlIllIlIlllIllI;
        if (lllllllllllllllllIlIllIlIlllIllI.moveBackDone) {
            lllllllllllllllllIlIllIlIlllIIII.translate(lllllllllllllllllIlIllIlIlllIllI.xp1, lllllllllllllllllIlIllIlIlllIllI.yp1);
            lllllllllllllllllIlIllIlIlllIIII.scale(lllllllllllllllllIlIllIlIlllIllI.scale1, lllllllllllllllllIlIllIlIlllIllI.scale1);
            lllllllllllllllllIlIllIlIlllIIII.setClip((int)lllllllllllllllllIlIllIlIlllIllI.xp1, (int)lllllllllllllllllIlIllIlIlllIllI.yp1, (int)(lllllllllllllllllIlIllIlIlllIllI.scale1 * (float)lllllllllllllllllIlIllIlIllllIlI.getWidth()), (int)(lllllllllllllllllIlIllIlIlllIllI.scale1 * (float)lllllllllllllllllIlIllIlIllllIlI.getHeight()));
            lllllllllllllllllIlIllIlIlllIllI.prev.render(lllllllllllllllllIlIllIlIllllIlI, lllllllllllllllllIlIllIlIlllIlII, lllllllllllllllllIlIllIlIlllIIII);
            lllllllllllllllllIlIllIlIlllIIII.resetTransform();
            lllllllllllllllllIlIllIlIlllIIII.clearClip();
        }
        lllllllllllllllllIlIllIlIlllIIII.translate(lllllllllllllllllIlIllIlIlllIllI.xp2, lllllllllllllllllIlIllIlIlllIllI.yp2);
        lllllllllllllllllIlIllIlIlllIIII.scale(lllllllllllllllllIlIllIlIlllIllI.scale2, lllllllllllllllllIlIllIlIlllIllI.scale2);
        lllllllllllllllllIlIllIlIlllIIII.setClip((int)lllllllllllllllllIlIllIlIlllIllI.xp2, (int)lllllllllllllllllIlIllIlIlllIllI.yp2, (int)(lllllllllllllllllIlIllIlIlllIllI.scale2 * (float)lllllllllllllllllIlIllIlIllllIlI.getWidth()), (int)(lllllllllllllllllIlIllIlIlllIllI.scale2 * (float)lllllllllllllllllIlIllIlIllllIlI.getHeight()));
    }

    @Override
    public void postRender(StateBasedGame lllllllllllllllllIlIllIllIIlllIl, GameContainer lllllllllllllllllIlIllIllIIllIll, Graphics lllllllllllllllllIlIllIllIlIIIII) throws SlickException {
        SelectTransition lllllllllllllllllIlIllIllIlIIllI;
        lllllllllllllllllIlIllIllIlIIIII.resetTransform();
        if (!lllllllllllllllllIlIllIllIlIIllI.moveBackDone) {
            lllllllllllllllllIlIllIllIlIIIII.translate(lllllllllllllllllIlIllIllIlIIllI.xp1, lllllllllllllllllIlIllIllIlIIllI.yp1);
            lllllllllllllllllIlIllIllIlIIIII.scale(lllllllllllllllllIlIllIllIlIIllI.scale1, lllllllllllllllllIlIllIllIlIIllI.scale1);
            lllllllllllllllllIlIllIllIlIIIII.setClip((int)lllllllllllllllllIlIllIllIlIIllI.xp1, (int)lllllllllllllllllIlIllIllIlIIllI.yp1, (int)(lllllllllllllllllIlIllIllIlIIllI.scale1 * (float)lllllllllllllllllIlIllIllIIllIll.getWidth()), (int)(lllllllllllllllllIlIllIllIlIIllI.scale1 * (float)lllllllllllllllllIlIllIllIIllIll.getHeight()));
            lllllllllllllllllIlIllIllIlIIllI.prev.render(lllllllllllllllllIlIllIllIIllIll, lllllllllllllllllIlIllIllIIlllIl, lllllllllllllllllIlIllIllIlIIIII);
            lllllllllllllllllIlIllIllIlIIIII.resetTransform();
            lllllllllllllllllIlIllIllIlIIIII.clearClip();
        }
    }

    static {
        GL = Renderer.get();
    }

    @Override
    public boolean isComplete() {
        SelectTransition lllllllllllllllllIlIllIlllIIIlII;
        return lllllllllllllllllIlIllIlllIIIlII.finish;
    }

    public SelectTransition(Color lllllllllllllllllIlIllIllllIlIIl) {
        SelectTransition lllllllllllllllllIlIllIllllIlIll;
        lllllllllllllllllIlIllIllllIlIll.scale1 = 1.0f;
        lllllllllllllllllIlIllIllllIlIll.xp1 = 0.0f;
        lllllllllllllllllIlIllIllllIlIll.yp1 = 0.0f;
        lllllllllllllllllIlIllIllllIlIll.scale2 = 0.4f;
        lllllllllllllllllIlIllIllllIlIll.xp2 = 0.0f;
        lllllllllllllllllIlIllIllllIlIll.yp2 = 0.0f;
        lllllllllllllllllIlIllIllllIlIll.init = false;
        lllllllllllllllllIlIllIllllIlIll.moveBackDone = false;
        lllllllllllllllllIlIllIllllIlIll.pause = 300;
        lllllllllllllllllIlIllIllllIlIll.background = lllllllllllllllllIlIllIllllIlIIl;
    }

    @Override
    public void update(StateBasedGame lllllllllllllllllIlIllIlIIllIlII, GameContainer lllllllllllllllllIlIllIlIIllIIll, int lllllllllllllllllIlIllIlIIllIIlI) throws SlickException {
        SelectTransition lllllllllllllllllIlIllIlIIllIlIl;
        if (!lllllllllllllllllIlIllIlIIllIlIl.init) {
            lllllllllllllllllIlIllIlIIllIlIl.init = true;
            lllllllllllllllllIlIllIlIIllIlIl.xp2 = lllllllllllllllllIlIllIlIIllIIll.getWidth() / 2 + 50;
            lllllllllllllllllIlIllIlIIllIlIl.yp2 = lllllllllllllllllIlIllIlIIllIIll.getHeight() / 4;
        }
        if (!lllllllllllllllllIlIllIlIIllIlIl.moveBackDone) {
            if (lllllllllllllllllIlIllIlIIllIlIl.scale1 > 0.4f) {
                lllllllllllllllllIlIllIlIIllIlIl.scale1 -= (float)lllllllllllllllllIlIllIlIIllIIlI * 0.002f;
                if (lllllllllllllllllIlIllIlIIllIlIl.scale1 <= 0.4f) {
                    lllllllllllllllllIlIllIlIIllIlIl.scale1 = 0.4f;
                }
                lllllllllllllllllIlIllIlIIllIlIl.xp1 += (float)lllllllllllllllllIlIllIlIIllIIlI * 0.3f;
                if (lllllllllllllllllIlIllIlIIllIlIl.xp1 > 50.0f) {
                    lllllllllllllllllIlIllIlIIllIlIl.xp1 = 50.0f;
                }
                lllllllllllllllllIlIllIlIIllIlIl.yp1 += (float)lllllllllllllllllIlIllIlIIllIIlI * 0.5f;
                if (lllllllllllllllllIlIllIlIIllIlIl.yp1 > (float)(lllllllllllllllllIlIllIlIIllIIll.getHeight() / 4)) {
                    lllllllllllllllllIlIllIlIIllIlIl.yp1 = lllllllllllllllllIlIllIlIIllIIll.getHeight() / 4;
                }
            } else {
                lllllllllllllllllIlIllIlIIllIlIl.moveBackDone = true;
            }
        } else {
            lllllllllllllllllIlIllIlIIllIlIl.pause -= lllllllllllllllllIlIllIlIIllIIlI;
            if (lllllllllllllllllIlIllIlIIllIlIl.pause > 0) {
                return;
            }
            if (lllllllllllllllllIlIllIlIIllIlIl.scale2 < 1.0f) {
                lllllllllllllllllIlIllIlIIllIlIl.scale2 += (float)lllllllllllllllllIlIllIlIIllIIlI * 0.002f;
                if (lllllllllllllllllIlIllIlIIllIlIl.scale2 >= 1.0f) {
                    lllllllllllllllllIlIllIlIIllIlIl.scale2 = 1.0f;
                }
                lllllllllllllllllIlIllIlIIllIlIl.xp2 -= (float)lllllllllllllllllIlIllIlIIllIIlI * 1.5f;
                if (lllllllllllllllllIlIllIlIIllIlIl.xp2 < 0.0f) {
                    lllllllllllllllllIlIllIlIIllIlIl.xp2 = 0.0f;
                }
                lllllllllllllllllIlIllIlIIllIlIl.yp2 -= (float)lllllllllllllllllIlIllIlIIllIIlI * 0.5f;
                if (lllllllllllllllllIlIllIlIIllIlIl.yp2 < 0.0f) {
                    lllllllllllllllllIlIllIlIIllIlIl.yp2 = 0.0f;
                }
            } else {
                lllllllllllllllllIlIllIlIIllIlIl.finish = true;
            }
        }
    }
}

