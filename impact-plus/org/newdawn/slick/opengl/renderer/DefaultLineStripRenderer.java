/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl.renderer;

import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class DefaultLineStripRenderer
implements LineStripRenderer {
    private /* synthetic */ SGL GL;

    @Override
    public void setAntiAlias(boolean lIllIIlIllIllll) {
        DefaultLineStripRenderer lIllIIlIlllIIII;
        if (lIllIIlIllIllll) {
            lIllIIlIlllIIII.GL.glEnable(2848);
        } else {
            lIllIIlIlllIIII.GL.glDisable(2848);
        }
    }

    @Override
    public void start() {
        DefaultLineStripRenderer lIllIIlIllIIlll;
        lIllIIlIllIIlll.GL.glBegin(3);
    }

    @Override
    public void color(float lIllIIlIlIlIllI, float lIllIIlIlIlIIII, float lIllIIlIlIlIlII, float lIllIIlIlIlIIll) {
        DefaultLineStripRenderer lIllIIlIlIlIlll;
        lIllIIlIlIlIlll.GL.glColor4f(lIllIIlIlIlIllI, lIllIIlIlIlIIII, lIllIIlIlIlIlII, lIllIIlIlIlIIll);
    }

    @Override
    public void setWidth(float lIllIIlIllIlIIl) {
        DefaultLineStripRenderer lIllIIlIllIllII;
        lIllIIlIllIllII.GL.glLineWidth(lIllIIlIllIlIIl);
    }

    @Override
    public void setLineCaps(boolean lIllIIlIlIIllII) {
    }

    public DefaultLineStripRenderer() {
        DefaultLineStripRenderer lIllIIlIllllIII;
        lIllIIlIllllIII.GL = Renderer.get();
    }

    @Override
    public void end() {
        DefaultLineStripRenderer lIllIIlIlllIlIl;
        lIllIIlIlllIlIl.GL.glEnd();
    }

    @Override
    public void vertex(float lIllIIlIlIllllI, float lIllIIlIlIlllIl) {
        DefaultLineStripRenderer lIllIIlIlIlllll;
        lIllIIlIlIlllll.GL.glVertex2f(lIllIIlIlIllllI, lIllIIlIlIlllIl);
    }

    @Override
    public boolean applyGLLineFixes() {
        return true;
    }
}

