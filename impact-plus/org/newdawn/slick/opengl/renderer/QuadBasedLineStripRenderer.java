/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl.renderer;

import org.newdawn.slick.opengl.renderer.DefaultLineStripRenderer;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class QuadBasedLineStripRenderer
implements LineStripRenderer {
    private /* synthetic */ int pts;
    private /* synthetic */ boolean renderHalf;
    private /* synthetic */ SGL GL;
    private /* synthetic */ boolean lineCaps;
    private /* synthetic */ float[] points;
    private /* synthetic */ DefaultLineStripRenderer def;
    public static /* synthetic */ int MAX_POINTS;
    private /* synthetic */ float width;
    private /* synthetic */ int cpt;
    private /* synthetic */ float[] colours;
    private /* synthetic */ boolean antialias;

    @Override
    public void setLineCaps(boolean llllllllllllllllllIlIlIIlIIllIlI) {
        llllllllllllllllllIlIlIIlIIlllIl.lineCaps = llllllllllllllllllIlIlIIlIIllIlI;
    }

    @Override
    public void start() {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIlIIlIlll;
        if (llllllllllllllllllIlIlIIlIIlIlll.width == 1.0f) {
            llllllllllllllllllIlIlIIlIIlIlll.def.start();
            return;
        }
        llllllllllllllllllIlIlIIlIIlIlll.pts = 0;
        llllllllllllllllllIlIlIIlIIlIlll.cpt = 0;
        llllllllllllllllllIlIlIIlIIlIlll.GL.flush();
        float[] llllllllllllllllllIlIlIIlIIlIllI = llllllllllllllllllIlIlIIlIIlIlll.GL.getCurrentColor();
        llllllllllllllllllIlIlIIlIIlIlll.color(llllllllllllllllllIlIlIIlIIlIllI[0], llllllllllllllllllIlIlIIlIIlIllI[1], llllllllllllllllllIlIlIIlIIlIllI[2], llllllllllllllllllIlIlIIlIIlIllI[3]);
    }

    @Override
    public void setWidth(float llllllllllllllllllIlIlIIlIIIIIIl) {
        llllllllllllllllllIlIlIIlIIIIIII.width = llllllllllllllllllIlIlIIlIIIIIIl;
    }

    static {
        MAX_POINTS = 10000;
    }

    public void renderLines(float[] llllllllllllllllllIlIlIIIlllIlII, int llllllllllllllllllIlIlIIIlllIIll) {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIIlllIIlI;
        if (llllllllllllllllllIlIlIIIlllIIlI.antialias) {
            llllllllllllllllllIlIlIIIlllIIlI.GL.glEnable(2881);
            llllllllllllllllllIlIlIIIlllIIlI.renderLinesImpl(llllllllllllllllllIlIlIIIlllIlII, llllllllllllllllllIlIlIIIlllIIll, llllllllllllllllllIlIlIIIlllIIlI.width + 1.0f);
        }
        llllllllllllllllllIlIlIIIlllIIlI.GL.glDisable(2881);
        llllllllllllllllllIlIlIIIlllIIlI.renderLinesImpl(llllllllllllllllllIlIlIIIlllIlII, llllllllllllllllllIlIlIIIlllIIll, llllllllllllllllllIlIlIIIlllIIlI.width);
        if (llllllllllllllllllIlIlIIIlllIIlI.antialias) {
            llllllllllllllllllIlIlIIIlllIIlI.GL.glEnable(2881);
        }
    }

    @Override
    public void end() {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIlIIlIIIl;
        if (llllllllllllllllllIlIlIIlIIlIIIl.width == 1.0f) {
            llllllllllllllllllIlIlIIlIIlIIIl.def.end();
            return;
        }
        llllllllllllllllllIlIlIIlIIlIIIl.renderLines(llllllllllllllllllIlIlIIlIIlIIIl.points, llllllllllllllllllIlIlIIlIIlIIIl.pts);
    }

    @Override
    public void vertex(float llllllllllllllllllIlIlIIlIIIIlll, float llllllllllllllllllIlIlIIlIIIIllI) {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIlIIIlIII;
        if (llllllllllllllllllIlIlIIlIIIlIII.width == 1.0f) {
            llllllllllllllllllIlIlIIlIIIlIII.def.vertex(llllllllllllllllllIlIlIIlIIIIlll, llllllllllllllllllIlIlIIlIIIIllI);
            return;
        }
        llllllllllllllllllIlIlIIlIIIlIII.points[llllllllllllllllllIlIlIIlIIIlIII.pts * 2] = llllllllllllllllllIlIlIIlIIIIlll;
        llllllllllllllllllIlIlIIlIIIlIII.points[llllllllllllllllllIlIlIIlIIIlIII.pts * 2 + 1] = llllllllllllllllllIlIlIIlIIIIllI;
        ++llllllllllllllllllIlIlIIlIIIlIII.pts;
        int llllllllllllllllllIlIlIIlIIIlIIl = llllllllllllllllllIlIlIIlIIIlIII.pts - 1;
        llllllllllllllllllIlIlIIlIIIlIII.color(llllllllllllllllllIlIlIIlIIIlIII.colours[llllllllllllllllllIlIlIIlIIIlIIl * 4], llllllllllllllllllIlIlIIlIIIlIII.colours[llllllllllllllllllIlIlIIlIIIlIIl * 4 + 1], llllllllllllllllllIlIlIIlIIIlIII.colours[llllllllllllllllllIlIlIIlIIIlIIl * 4 + 2], llllllllllllllllllIlIlIIlIIIlIII.colours[llllllllllllllllllIlIlIIlIIIlIIl * 4 + 3]);
    }

    public QuadBasedLineStripRenderer() {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIlIlIIIIl;
        llllllllllllllllllIlIlIIlIlIIIIl.GL = Renderer.get();
        llllllllllllllllllIlIlIIlIlIIIIl.width = 1.0f;
        llllllllllllllllllIlIlIIlIlIIIIl.def = new DefaultLineStripRenderer();
        llllllllllllllllllIlIlIIlIlIIIIl.lineCaps = false;
        llllllllllllllllllIlIlIIlIlIIIIl.points = new float[MAX_POINTS * 2];
        llllllllllllllllllIlIlIIlIlIIIIl.colours = new float[MAX_POINTS * 4];
    }

    public void renderLinesImpl(float[] llllllllllllllllllIlIlIIIIllIlIl, int llllllllllllllllllIlIlIIIIllIlII, float llllllllllllllllllIlIlIIIIllllIl) {
        float llllllllllllllllllIlIlIIIIllIlll;
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIIIllIllI;
        float llllllllllllllllllIlIlIIIIllllII = llllllllllllllllllIlIlIIIIllllIl / 2.0f;
        float llllllllllllllllllIlIlIIIIlllIll = 0.0f;
        float llllllllllllllllllIlIlIIIIlllIlI = 0.0f;
        float llllllllllllllllllIlIlIIIIlllIIl = 0.0f;
        float llllllllllllllllllIlIlIIIIlllIII = 0.0f;
        llllllllllllllllllIlIlIIIIllIllI.GL.glBegin(7);
        for (int llllllllllllllllllIlIlIIIlIIlIll = 0; llllllllllllllllllIlIlIIIlIIlIll < llllllllllllllllllIlIlIIIIllIlII + 1; ++llllllllllllllllllIlIlIIIlIIlIll) {
            int llllllllllllllllllIlIlIIIlIllIII = llllllllllllllllllIlIlIIIlIIlIll;
            int llllllllllllllllllIlIlIIIlIlIlll = llllllllllllllllllIlIlIIIlIIlIll + 1;
            int llllllllllllllllllIlIlIIIlIlIllI = llllllllllllllllllIlIlIIIlIIlIll - 1;
            if (llllllllllllllllllIlIlIIIlIlIllI < 0) {
                llllllllllllllllllIlIlIIIlIlIllI += llllllllllllllllllIlIlIIIIllIlII;
            }
            if (llllllllllllllllllIlIlIIIlIlIlll >= llllllllllllllllllIlIlIIIIllIlII) {
                llllllllllllllllllIlIlIIIlIlIlll -= llllllllllllllllllIlIlIIIIllIlII;
            }
            if (llllllllllllllllllIlIlIIIlIllIII >= llllllllllllllllllIlIlIIIIllIlII) {
                llllllllllllllllllIlIlIIIlIllIII -= llllllllllllllllllIlIlIIIIllIlII;
            }
            float llllllllllllllllllIlIlIIIlIlIlIl = llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIlIllIII * 2];
            float llllllllllllllllllIlIlIIIlIlIlII = llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIlIllIII * 2 + 1];
            float llllllllllllllllllIlIlIIIlIlIIll = llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIlIlIlll * 2];
            float llllllllllllllllllIlIlIIIlIlIIlI = llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIlIlIlll * 2 + 1];
            float llllllllllllllllllIlIlIIIlIlIIIl = llllllllllllllllllIlIlIIIlIlIIll - llllllllllllllllllIlIlIIIlIlIlIl;
            float llllllllllllllllllIlIlIIIlIlIIII = llllllllllllllllllIlIlIIIlIlIIlI - llllllllllllllllllIlIlIIIlIlIlII;
            if (llllllllllllllllllIlIlIIIlIlIIIl == 0.0f && llllllllllllllllllIlIlIIIlIlIIII == 0.0f) continue;
            float llllllllllllllllllIlIlIIIlIIllll = llllllllllllllllllIlIlIIIlIlIIIl * llllllllllllllllllIlIlIIIlIlIIIl + llllllllllllllllllIlIlIIIlIlIIII * llllllllllllllllllIlIlIIIlIlIIII;
            float llllllllllllllllllIlIlIIIlIIlllI = (float)Math.sqrt(llllllllllllllllllIlIlIIIlIIllll);
            llllllllllllllllllIlIlIIIlIlIIIl *= llllllllllllllllllIlIlIIIIllllII;
            llllllllllllllllllIlIlIIIlIlIIII *= llllllllllllllllllIlIlIIIIllllII;
            float llllllllllllllllllIlIlIIIlIIllIl = llllllllllllllllllIlIlIIIlIlIIII /= llllllllllllllllllIlIlIIIlIIlllI;
            float llllllllllllllllllIlIlIIIlIIllII = -(llllllllllllllllllIlIlIIIlIlIIIl /= llllllllllllllllllIlIlIIIlIIlllI);
            if (llllllllllllllllllIlIlIIIlIIlIll != 0) {
                llllllllllllllllllIlIlIIIIllIllI.bindColor(llllllllllllllllllIlIlIIIlIlIllI);
                llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIIlllIll, llllllllllllllllllIlIlIIIIlllIlI, 0.0f);
                llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIIlllIIl, llllllllllllllllllIlIlIIIIlllIII, 0.0f);
                llllllllllllllllllIlIlIIIIllIllI.bindColor(llllllllllllllllllIlIlIIIlIllIII);
                llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIlIlIlIl + llllllllllllllllllIlIlIIIlIIllIl, llllllllllllllllllIlIlIIIlIlIlII + llllllllllllllllllIlIlIIIlIIllII, 0.0f);
                llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIlIlIlIl - llllllllllllllllllIlIlIIIlIIllIl, llllllllllllllllllIlIlIIIlIlIlII - llllllllllllllllllIlIlIIIlIIllII, 0.0f);
            }
            llllllllllllllllllIlIlIIIIlllIll = llllllllllllllllllIlIlIIIlIlIIll - llllllllllllllllllIlIlIIIlIIllIl;
            llllllllllllllllllIlIlIIIIlllIlI = llllllllllllllllllIlIlIIIlIlIIlI - llllllllllllllllllIlIlIIIlIIllII;
            llllllllllllllllllIlIlIIIIlllIIl = llllllllllllllllllIlIlIIIlIlIIll + llllllllllllllllllIlIlIIIlIIllIl;
            llllllllllllllllllIlIlIIIIlllIII = llllllllllllllllllIlIlIIIlIlIIlI + llllllllllllllllllIlIlIIIlIIllII;
            if (llllllllllllllllllIlIlIIIlIIlIll >= llllllllllllllllllIlIlIIIIllIlII - 1) continue;
            llllllllllllllllllIlIlIIIIllIllI.bindColor(llllllllllllllllllIlIlIIIlIllIII);
            llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIlIlIlIl + llllllllllllllllllIlIlIIIlIIllIl, llllllllllllllllllIlIlIIIlIlIlII + llllllllllllllllllIlIlIIIlIIllII, 0.0f);
            llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIlIlIlIl - llllllllllllllllllIlIlIIIlIIllIl, llllllllllllllllllIlIlIIIlIlIlII - llllllllllllllllllIlIlIIIlIIllII, 0.0f);
            llllllllllllllllllIlIlIIIIllIllI.bindColor(llllllllllllllllllIlIlIIIlIlIlll);
            llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIlIlIIll - llllllllllllllllllIlIlIIIlIIllIl, llllllllllllllllllIlIlIIIlIlIIlI - llllllllllllllllllIlIlIIIlIIllII, 0.0f);
            llllllllllllllllllIlIlIIIIllIllI.GL.glVertex3f(llllllllllllllllllIlIlIIIlIlIIll + llllllllllllllllllIlIlIIIlIIllIl, llllllllllllllllllIlIlIIIlIlIIlI + llllllllllllllllllIlIlIIIlIIllII, 0.0f);
        }
        llllllllllllllllllIlIlIIIIllIllI.GL.glEnd();
        float f = llllllllllllllllllIlIlIIIIllIlll = llllllllllllllllllIlIlIIIIllllII <= 12.5f ? 5.0f : 180.0f / (float)Math.ceil((double)llllllllllllllllllIlIlIIIIllllII / 2.5);
        if (llllllllllllllllllIlIlIIIIllIllI.lineCaps) {
            float llllllllllllllllllIlIlIIIlIIlIII = llllllllllllllllllIlIlIIIIllIlIl[2] - llllllllllllllllllIlIlIIIIllIlIl[0];
            float llllllllllllllllllIlIlIIIlIIIlll = llllllllllllllllllIlIlIIIIllIlIl[3] - llllllllllllllllllIlIlIIIIllIlIl[1];
            float llllllllllllllllllIlIlIIIlIIIllI = (float)Math.toDegrees(Math.atan2(llllllllllllllllllIlIlIIIlIIIlll, llllllllllllllllllIlIlIIIlIIlIII)) + 90.0f;
            if (llllllllllllllllllIlIlIIIlIIlIII != 0.0f || llllllllllllllllllIlIlIIIlIIIlll != 0.0f) {
                llllllllllllllllllIlIlIIIIllIllI.GL.glBegin(6);
                llllllllllllllllllIlIlIIIIllIllI.bindColor(0);
                llllllllllllllllllIlIlIIIIllIllI.GL.glVertex2f(llllllllllllllllllIlIlIIIIllIlIl[0], llllllllllllllllllIlIlIIIIllIlIl[1]);
                int llllllllllllllllllIlIlIIIlIIlIIl = 0;
                while ((float)llllllllllllllllllIlIlIIIlIIlIIl < 180.0f + llllllllllllllllllIlIlIIIIllIlll) {
                    float llllllllllllllllllIlIlIIIlIIlIlI = (float)Math.toRadians(llllllllllllllllllIlIlIIIlIIIllI + (float)llllllllllllllllllIlIlIIIlIIlIIl);
                    llllllllllllllllllIlIlIIIIllIllI.GL.glVertex2f(llllllllllllllllllIlIlIIIIllIlIl[0] + (float)(Math.cos(llllllllllllllllllIlIlIIIlIIlIlI) * (double)llllllllllllllllllIlIlIIIIllllII), llllllllllllllllllIlIlIIIIllIlIl[1] + (float)(Math.sin(llllllllllllllllllIlIlIIIlIIlIlI) * (double)llllllllllllllllllIlIlIIIIllllII));
                    llllllllllllllllllIlIlIIIlIIlIIl = (int)((float)llllllllllllllllllIlIlIIIlIIlIIl + llllllllllllllllllIlIlIIIIllIlll);
                }
                llllllllllllllllllIlIlIIIIllIllI.GL.glEnd();
            }
        }
        if (llllllllllllllllllIlIlIIIIllIllI.lineCaps) {
            float llllllllllllllllllIlIlIIIlIIIIll = llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 2] - llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 4];
            float llllllllllllllllllIlIlIIIlIIIIlI = llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 1] - llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 3];
            float llllllllllllllllllIlIlIIIlIIIIIl = (float)Math.toDegrees(Math.atan2(llllllllllllllllllIlIlIIIlIIIIlI, llllllllllllllllllIlIlIIIlIIIIll)) - 90.0f;
            if (llllllllllllllllllIlIlIIIlIIIIll != 0.0f || llllllllllllllllllIlIlIIIlIIIIlI != 0.0f) {
                llllllllllllllllllIlIlIIIIllIllI.GL.glBegin(6);
                llllllllllllllllllIlIlIIIIllIllI.bindColor(llllllllllllllllllIlIlIIIIllIlII - 1);
                llllllllllllllllllIlIlIIIIllIllI.GL.glVertex2f(llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 2], llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 1]);
                int llllllllllllllllllIlIlIIIlIIIlII = 0;
                while ((float)llllllllllllllllllIlIlIIIlIIIlII < 180.0f + llllllllllllllllllIlIlIIIIllIlll) {
                    float llllllllllllllllllIlIlIIIlIIIlIl = (float)Math.toRadians(llllllllllllllllllIlIlIIIlIIIIIl + (float)llllllllllllllllllIlIlIIIlIIIlII);
                    llllllllllllllllllIlIlIIIIllIllI.GL.glVertex2f(llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 2] + (float)(Math.cos(llllllllllllllllllIlIlIIIlIIIlIl) * (double)llllllllllllllllllIlIlIIIIllllII), llllllllllllllllllIlIlIIIIllIlIl[llllllllllllllllllIlIlIIIIllIlII * 2 - 1] + (float)(Math.sin(llllllllllllllllllIlIlIIIlIIIlIl) * (double)llllllllllllllllllIlIlIIIIllllII));
                    llllllllllllllllllIlIlIIIlIIIlII = (int)((float)llllllllllllllllllIlIlIIIlIIIlII + llllllllllllllllllIlIlIIIIllIlll);
                }
                llllllllllllllllllIlIlIIIIllIllI.GL.glEnd();
            }
        }
    }

    @Override
    public boolean applyGLLineFixes() {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIIIIIlIII;
        if (llllllllllllllllllIlIlIIIIIIlIII.width == 1.0f) {
            return llllllllllllllllllIlIlIIIIIIlIII.def.applyGLLineFixes();
        }
        return llllllllllllllllllIlIlIIIIIIlIII.def.applyGLLineFixes();
    }

    private void bindColor(int llllllllllllllllllIlIlIIIIIlllII) {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIIIIllIll;
        if (llllllllllllllllllIlIlIIIIIlllII < llllllllllllllllllIlIlIIIIIllIll.cpt) {
            if (llllllllllllllllllIlIlIIIIIllIll.renderHalf) {
                llllllllllllllllllIlIlIIIIIllIll.GL.glColor4f(llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4] * 0.5f, llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4 + 1] * 0.5f, llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4 + 2] * 0.5f, llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4 + 3] * 0.5f);
            } else {
                llllllllllllllllllIlIlIIIIIllIll.GL.glColor4f(llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4], llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4 + 1], llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4 + 2], llllllllllllllllllIlIlIIIIIllIll.colours[llllllllllllllllllIlIlIIIIIlllII * 4 + 3]);
            }
        }
    }

    @Override
    public void color(float llllllllllllllllllIlIlIIIIIIlllI, float llllllllllllllllllIlIlIIIIIlIIlI, float llllllllllllllllllIlIlIIIIIIllII, float llllllllllllllllllIlIlIIIIIIlIll) {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIIIIIllll;
        if (llllllllllllllllllIlIlIIIIIIllll.width == 1.0f) {
            llllllllllllllllllIlIlIIIIIIllll.def.color(llllllllllllllllllIlIlIIIIIIlllI, llllllllllllllllllIlIlIIIIIlIIlI, llllllllllllllllllIlIlIIIIIIllII, llllllllllllllllllIlIlIIIIIIlIll);
            return;
        }
        llllllllllllllllllIlIlIIIIIIllll.colours[llllllllllllllllllIlIlIIIIIIllll.pts * 4] = llllllllllllllllllIlIlIIIIIIlllI;
        llllllllllllllllllIlIlIIIIIIllll.colours[llllllllllllllllllIlIlIIIIIIllll.pts * 4 + 1] = llllllllllllllllllIlIlIIIIIlIIlI;
        llllllllllllllllllIlIlIIIIIIllll.colours[llllllllllllllllllIlIlIIIIIIllll.pts * 4 + 2] = llllllllllllllllllIlIlIIIIIIllII;
        llllllllllllllllllIlIlIIIIIIllll.colours[llllllllllllllllllIlIlIIIIIIllll.pts * 4 + 3] = llllllllllllllllllIlIlIIIIIIlIll;
        ++llllllllllllllllllIlIlIIIIIIllll.cpt;
    }

    @Override
    public void setAntiAlias(boolean llllllllllllllllllIlIlIIIllllIIl) {
        QuadBasedLineStripRenderer llllllllllllllllllIlIlIIIlllllII;
        llllllllllllllllllIlIlIIIlllllII.def.setAntiAlias(llllllllllllllllllIlIlIIIllllIIl);
        llllllllllllllllllIlIlIIIlllllII.antialias = llllllllllllllllllIlIlIIIllllIIl;
    }
}

