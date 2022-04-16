/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.state.transition;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;
import org.newdawn.slick.util.MaskUtil;

public class BlobbyTransition
implements Transition {
    private /* synthetic */ boolean finish;
    private /* synthetic */ Color background;
    private /* synthetic */ int blobCount;
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ int timer;
    private /* synthetic */ ArrayList blobs;
    private /* synthetic */ GameState prev;

    @Override
    public void update(StateBasedGame llllllllllllllllIlIllIIllIIllIll, GameContainer llllllllllllllllIlIllIIllIIlIlll, int llllllllllllllllIlIllIIllIIllIIl) throws SlickException {
        BlobbyTransition llllllllllllllllIlIllIIllIIllIII;
        if (llllllllllllllllIlIllIIllIIllIII.blobs.size() == 0) {
            for (int llllllllllllllllIlIllIIllIIllllI = 0; llllllllllllllllIlIllIIllIIllllI < llllllllllllllllIlIllIIllIIllIII.blobCount; ++llllllllllllllllIlIllIIllIIllllI) {
                llllllllllllllllIlIllIIllIIllIII.blobs.add(llllllllllllllllIlIllIIllIIllIII.new Blob(llllllllllllllllIlIllIIllIIlIlll));
            }
        }
        for (int llllllllllllllllIlIllIIllIIlllIl = 0; llllllllllllllllIlIllIIllIIlllIl < llllllllllllllllIlIllIIllIIllIII.blobs.size(); ++llllllllllllllllIlIllIIllIIlllIl) {
            ((Blob)llllllllllllllllIlIllIIllIIllIII.blobs.get(llllllllllllllllIlIllIIllIIlllIl)).update(llllllllllllllllIlIllIIllIIllIIl);
        }
        llllllllllllllllIlIllIIllIIllIII.timer -= llllllllllllllllIlIllIIllIIllIIl;
        if (llllllllllllllllIlIllIIllIIllIII.timer < 0) {
            llllllllllllllllIlIllIIllIIllIII.finish = true;
        }
    }

    public BlobbyTransition(Color llllllllllllllllIlIllIIlllIIlIIl) {
        BlobbyTransition llllllllllllllllIlIllIIlllIIlllI;
        llllllllllllllllIlIllIIlllIIlllI.blobs = new ArrayList();
        llllllllllllllllIlIllIIlllIIlllI.timer = 1000;
        llllllllllllllllIlIllIIlllIIlllI.blobCount = 10;
        llllllllllllllllIlIllIIlllIIlllI.background = llllllllllllllllIlIllIIlllIIlIIl;
    }

    @Override
    public void init(GameState llllllllllllllllIlIllIIlllIIIIII, GameState llllllllllllllllIlIllIIllIllllII) {
        llllllllllllllllIlIllIIlllIIIIll.prev = llllllllllllllllIlIllIIllIllllII;
    }

    @Override
    public void postRender(StateBasedGame llllllllllllllllIlIllIIllIllIlIl, GameContainer llllllllllllllllIlIllIIllIllIlII, Graphics llllllllllllllllIlIllIIllIllIIll) throws SlickException {
        MaskUtil.resetMask();
    }

    @Override
    public void preRender(StateBasedGame llllllllllllllllIlIllIIllIlIIllI, GameContainer llllllllllllllllIlIllIIllIlIlIIl, Graphics llllllllllllllllIlIllIIllIlIlIII) throws SlickException {
        BlobbyTransition llllllllllllllllIlIllIIllIlIlIll;
        llllllllllllllllIlIllIIllIlIlIll.prev.render(llllllllllllllllIlIllIIllIlIlIIl, llllllllllllllllIlIllIIllIlIIllI, llllllllllllllllIlIllIIllIlIlIII);
        MaskUtil.defineMask();
        for (int llllllllllllllllIlIllIIllIlIllIl = 0; llllllllllllllllIlIllIIllIlIllIl < llllllllllllllllIlIllIIllIlIlIll.blobs.size(); ++llllllllllllllllIlIllIIllIlIllIl) {
            ((Blob)llllllllllllllllIlIllIIllIlIlIll.blobs.get(llllllllllllllllIlIllIIllIlIllIl)).render(llllllllllllllllIlIllIIllIlIlIII);
        }
        MaskUtil.finishDefineMask();
        MaskUtil.drawOnMask();
        if (llllllllllllllllIlIllIIllIlIlIll.background != null) {
            Color llllllllllllllllIlIllIIllIlIllII = llllllllllllllllIlIllIIllIlIlIII.getColor();
            llllllllllllllllIlIllIIllIlIlIII.setColor(llllllllllllllllIlIllIIllIlIlIll.background);
            llllllllllllllllIlIllIIllIlIlIII.fillRect(0.0f, 0.0f, llllllllllllllllIlIllIIllIlIlIIl.getWidth(), llllllllllllllllIlIllIIllIlIlIIl.getHeight());
            llllllllllllllllIlIllIIllIlIlIII.setColor(llllllllllllllllIlIllIIllIlIllII);
        }
    }

    public BlobbyTransition() {
        BlobbyTransition llllllllllllllllIlIllIIlllIlIIll;
        llllllllllllllllIlIllIIlllIlIIll.blobs = new ArrayList();
        llllllllllllllllIlIllIIlllIlIIll.timer = 1000;
        llllllllllllllllIlIllIIlllIlIIll.blobCount = 10;
    }

    @Override
    public boolean isComplete() {
        BlobbyTransition llllllllllllllllIlIllIIllIlllIIl;
        return llllllllllllllllIlIllIIllIlllIIl.finish;
    }

    static {
        GL = Renderer.get();
    }

    private class Blob {
        private /* synthetic */ float growSpeed;
        private /* synthetic */ float y;
        private /* synthetic */ float x;
        private /* synthetic */ float rad;

        public void update(int lIlIlIIIIIl) {
            Blob lIlIlIIIIll;
            lIlIlIIIIll.rad += lIlIlIIIIll.growSpeed * (float)lIlIlIIIIIl * 0.4f;
        }

        public Blob(GameContainer lIlIlIIllIl) {
            Blob lIlIlIIllII;
            lIlIlIIllII.x = (float)(Math.random() * (double)lIlIlIIllIl.getWidth());
            lIlIlIIllII.y = (float)(Math.random() * (double)lIlIlIIllIl.getWidth());
            lIlIlIIllII.growSpeed = (float)(1.0 + Math.random() * 1.0);
        }

        public void render(Graphics lIlIIllIIIl) {
            Blob lIlIIllIIlI;
            lIlIIllIIIl.fillOval(lIlIIllIIlI.x - lIlIIllIIlI.rad, lIlIIllIIlI.y - lIlIIllIIlI.rad, lIlIIllIIlI.rad * 2.0f, lIlIIllIIlI.rad * 2.0f);
        }
    }
}

