/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class ScalableGame
implements Game {
    private /* synthetic */ GameContainer container;
    private /* synthetic */ float normalHeight;
    private /* synthetic */ float normalWidth;
    private /* synthetic */ int targetHeight;
    private /* synthetic */ Game held;
    private /* synthetic */ int targetWidth;
    private /* synthetic */ boolean maintainAspect;
    private static /* synthetic */ SGL GL;

    @Override
    public void update(GameContainer llllllllllllllllIlllIIIIllIllIIl, int llllllllllllllllIlllIIIIllIllIII) throws SlickException {
        ScalableGame llllllllllllllllIlllIIIIllIllIlI;
        if (llllllllllllllllIlllIIIIllIllIlI.targetHeight != llllllllllllllllIlllIIIIllIllIIl.getHeight() || llllllllllllllllIlllIIIIllIllIlI.targetWidth != llllllllllllllllIlllIIIIllIllIIl.getWidth()) {
            llllllllllllllllIlllIIIIllIllIlI.recalculateScale();
        }
        llllllllllllllllIlllIIIIllIllIlI.held.update(llllllllllllllllIlllIIIIllIllIIl, llllllllllllllllIlllIIIIllIllIII);
    }

    @Override
    public void init(GameContainer llllllllllllllllIlllIIIIllllIIll) throws SlickException {
        ScalableGame llllllllllllllllIlllIIIIllllIlII;
        llllllllllllllllIlllIIIIllllIlII.container = llllllllllllllllIlllIIIIllllIIll;
        llllllllllllllllIlllIIIIllllIlII.recalculateScale();
        llllllllllllllllIlllIIIIllllIlII.held.init(llllllllllllllllIlllIIIIllllIIll);
    }

    @Override
    public boolean closeRequested() {
        ScalableGame llllllllllllllllIlllIIIIllIIIIIl;
        return llllllllllllllllIlllIIIIllIIIIIl.held.closeRequested();
    }

    @Override
    public String getTitle() {
        ScalableGame llllllllllllllllIlllIIIIlIlllllI;
        return llllllllllllllllIlllIIIIlIlllllI.held.getTitle();
    }

    static {
        GL = Renderer.get();
    }

    public ScalableGame(Game llllllllllllllllIlllIIIlIIIlIIlI, int llllllllllllllllIlllIIIlIIIIlIIl, int llllllllllllllllIlllIIIlIIIIlIII) {
        llllllllllllllllIlllIIIlIIIlIlII(llllllllllllllllIlllIIIlIIIlIIlI, llllllllllllllllIlllIIIlIIIIlIIl, llllllllllllllllIlllIIIlIIIIlIII, false);
        ScalableGame llllllllllllllllIlllIIIlIIIlIlII;
    }

    public ScalableGame(Game llllllllllllllllIlllIIIlIIIIIIIl, int llllllllllllllllIlllIIIlIIIIIIII, int llllllllllllllllIlllIIIIlllllIlI, boolean llllllllllllllllIlllIIIIlllllllI) {
        ScalableGame llllllllllllllllIlllIIIlIIIIIIlI;
        llllllllllllllllIlllIIIlIIIIIIlI.held = llllllllllllllllIlllIIIlIIIIIIIl;
        llllllllllllllllIlllIIIlIIIIIIlI.normalWidth = llllllllllllllllIlllIIIlIIIIIIII;
        llllllllllllllllIlllIIIlIIIIIIlI.normalHeight = llllllllllllllllIlllIIIIlllllIlI;
        llllllllllllllllIlllIIIlIIIIIIlI.maintainAspect = llllllllllllllllIlllIIIIlllllllI;
    }

    @Override
    public final void render(GameContainer llllllllllllllllIlllIIIIllIIlllI, Graphics llllllllllllllllIlllIIIIllIIllIl) throws SlickException {
        ScalableGame llllllllllllllllIlllIIIIllIIlIlI;
        int llllllllllllllllIlllIIIIllIIllII = 0;
        int llllllllllllllllIlllIIIIllIIlIll = 0;
        if (llllllllllllllllIlllIIIIllIIlIlI.targetHeight < llllllllllllllllIlllIIIIllIIlllI.getHeight()) {
            llllllllllllllllIlllIIIIllIIllII = (llllllllllllllllIlllIIIIllIIlllI.getHeight() - llllllllllllllllIlllIIIIllIIlIlI.targetHeight) / 2;
        }
        if (llllllllllllllllIlllIIIIllIIlIlI.targetWidth < llllllllllllllllIlllIIIIllIIlllI.getWidth()) {
            llllllllllllllllIlllIIIIllIIlIll = (llllllllllllllllIlllIIIIllIIlllI.getWidth() - llllllllllllllllIlllIIIIllIIlIlI.targetWidth) / 2;
        }
        SlickCallable.enterSafeBlock();
        llllllllllllllllIlllIIIIllIIllIl.setClip(llllllllllllllllIlllIIIIllIIlIll, llllllllllllllllIlllIIIIllIIllII, llllllllllllllllIlllIIIIllIIlIlI.targetWidth, llllllllllllllllIlllIIIIllIIlIlI.targetHeight);
        GL.glTranslatef(llllllllllllllllIlllIIIIllIIlIll, llllllllllllllllIlllIIIIllIIllII, 0.0f);
        llllllllllllllllIlllIIIIllIIllIl.scale((float)llllllllllllllllIlllIIIIllIIlIlI.targetWidth / llllllllllllllllIlllIIIIllIIlIlI.normalWidth, (float)llllllllllllllllIlllIIIIllIIlIlI.targetHeight / llllllllllllllllIlllIIIIllIIlIlI.normalHeight);
        GL.glPushMatrix();
        llllllllllllllllIlllIIIIllIIlIlI.held.render(llllllllllllllllIlllIIIIllIIlllI, llllllllllllllllIlllIIIIllIIllIl);
        GL.glPopMatrix();
        llllllllllllllllIlllIIIIllIIllIl.clearClip();
        SlickCallable.leaveSafeBlock();
        llllllllllllllllIlllIIIIllIIlIlI.renderOverlay(llllllllllllllllIlllIIIIllIIlllI, llllllllllllllllIlllIIIIllIIllIl);
    }

    protected void renderOverlay(GameContainer llllllllllllllllIlllIIIIllIIIlII, Graphics llllllllllllllllIlllIIIIllIIIIll) {
    }

    public void recalculateScale() throws SlickException {
        ScalableGame llllllllllllllllIlllIIIIlllIIIll;
        llllllllllllllllIlllIIIIlllIIIll.targetWidth = llllllllllllllllIlllIIIIlllIIIll.container.getWidth();
        llllllllllllllllIlllIIIIlllIIIll.targetHeight = llllllllllllllllIlllIIIIlllIIIll.container.getHeight();
        if (llllllllllllllllIlllIIIIlllIIIll.maintainAspect) {
            boolean llllllllllllllllIlllIIIIlllIlIlI = (double)(llllllllllllllllIlllIIIIlllIIIll.normalWidth / llllllllllllllllIlllIIIIlllIIIll.normalHeight) > 1.6;
            boolean llllllllllllllllIlllIIIIlllIlIIl = (double)((float)llllllllllllllllIlllIIIIlllIIIll.targetWidth / (float)llllllllllllllllIlllIIIIlllIIIll.targetHeight) > 1.6;
            float llllllllllllllllIlllIIIIlllIlIII = (float)llllllllllllllllIlllIIIIlllIIIll.targetWidth / llllllllllllllllIlllIIIIlllIIIll.normalWidth;
            float llllllllllllllllIlllIIIIlllIIlll = (float)llllllllllllllllIlllIIIIlllIIIll.targetHeight / llllllllllllllllIlllIIIIlllIIIll.normalHeight;
            if (llllllllllllllllIlllIIIIlllIlIlI & llllllllllllllllIlllIIIIlllIlIIl) {
                float llllllllllllllllIlllIIIIlllIllII = llllllllllllllllIlllIIIIlllIlIII < llllllllllllllllIlllIIIIlllIIlll ? llllllllllllllllIlllIIIIlllIlIII : llllllllllllllllIlllIIIIlllIIlll;
                llllllllllllllllIlllIIIIlllIIIll.targetWidth = (int)(llllllllllllllllIlllIIIIlllIIIll.normalWidth * llllllllllllllllIlllIIIIlllIllII);
                llllllllllllllllIlllIIIIlllIIIll.targetHeight = (int)(llllllllllllllllIlllIIIIlllIIIll.normalHeight * llllllllllllllllIlllIIIIlllIllII);
            } else if (llllllllllllllllIlllIIIIlllIlIlI & !llllllllllllllllIlllIIIIlllIlIIl) {
                llllllllllllllllIlllIIIIlllIIIll.targetWidth = (int)(llllllllllllllllIlllIIIIlllIIIll.normalWidth * llllllllllllllllIlllIIIIlllIlIII);
                llllllllllllllllIlllIIIIlllIIIll.targetHeight = (int)(llllllllllllllllIlllIIIIlllIIIll.normalHeight * llllllllllllllllIlllIIIIlllIlIII);
            } else if (!llllllllllllllllIlllIIIIlllIlIlI & llllllllllllllllIlllIIIIlllIlIIl) {
                llllllllllllllllIlllIIIIlllIIIll.targetWidth = (int)(llllllllllllllllIlllIIIIlllIIIll.normalWidth * llllllllllllllllIlllIIIIlllIIlll);
                llllllllllllllllIlllIIIIlllIIIll.targetHeight = (int)(llllllllllllllllIlllIIIIlllIIIll.normalHeight * llllllllllllllllIlllIIIIlllIIlll);
            } else {
                float llllllllllllllllIlllIIIIlllIlIll = llllllllllllllllIlllIIIIlllIlIII < llllllllllllllllIlllIIIIlllIIlll ? llllllllllllllllIlllIIIIlllIlIII : llllllllllllllllIlllIIIIlllIIlll;
                llllllllllllllllIlllIIIIlllIIIll.targetWidth = (int)(llllllllllllllllIlllIIIIlllIIIll.normalWidth * llllllllllllllllIlllIIIIlllIlIll);
                llllllllllllllllIlllIIIIlllIIIll.targetHeight = (int)(llllllllllllllllIlllIIIIlllIIIll.normalHeight * llllllllllllllllIlllIIIIlllIlIll);
            }
        }
        if (llllllllllllllllIlllIIIIlllIIIll.held instanceof InputListener) {
            llllllllllllllllIlllIIIIlllIIIll.container.getInput().addListener((InputListener)((Object)llllllllllllllllIlllIIIIlllIIIll.held));
        }
        llllllllllllllllIlllIIIIlllIIIll.container.getInput().setScale(llllllllllllllllIlllIIIIlllIIIll.normalWidth / (float)llllllllllllllllIlllIIIIlllIIIll.targetWidth, llllllllllllllllIlllIIIIlllIIIll.normalHeight / (float)llllllllllllllllIlllIIIIlllIIIll.targetHeight);
        int llllllllllllllllIlllIIIIlllIIlIl = 0;
        int llllllllllllllllIlllIIIIlllIIlII = 0;
        if (llllllllllllllllIlllIIIIlllIIIll.targetHeight < llllllllllllllllIlllIIIIlllIIIll.container.getHeight()) {
            llllllllllllllllIlllIIIIlllIIlIl = (llllllllllllllllIlllIIIIlllIIIll.container.getHeight() - llllllllllllllllIlllIIIIlllIIIll.targetHeight) / 2;
        }
        if (llllllllllllllllIlllIIIIlllIIIll.targetWidth < llllllllllllllllIlllIIIIlllIIIll.container.getWidth()) {
            llllllllllllllllIlllIIIIlllIIlII = (llllllllllllllllIlllIIIIlllIIIll.container.getWidth() - llllllllllllllllIlllIIIIlllIIIll.targetWidth) / 2;
        }
        llllllllllllllllIlllIIIIlllIIIll.container.getInput().setOffset((float)(-llllllllllllllllIlllIIIIlllIIlII) / ((float)llllllllllllllllIlllIIIIlllIIIll.targetWidth / llllllllllllllllIlllIIIIlllIIIll.normalWidth), (float)(-llllllllllllllllIlllIIIIlllIIlIl) / ((float)llllllllllllllllIlllIIIIlllIIIll.targetHeight / llllllllllllllllIlllIIIIlllIIIll.normalHeight));
    }
}

