/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package org.newdawn.slick.opengl.renderer;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.renderer.ImmediateModeOGLRenderer;

public class VAOGLRenderer
extends ImmediateModeOGLRenderer {
    public static final /* synthetic */ int NONE;
    private /* synthetic */ float[] texs;
    public static final /* synthetic */ int MAX_VERTS;
    private /* synthetic */ int vertIndex;
    private /* synthetic */ float[] cols;
    private /* synthetic */ FloatBuffer vertices;
    private /* synthetic */ int currentType;
    private static final /* synthetic */ int TOLERANCE;
    private /* synthetic */ float[] verts;
    private /* synthetic */ FloatBuffer textures;
    private /* synthetic */ FloatBuffer colors;
    private /* synthetic */ int listMode;
    private /* synthetic */ float[] tex;
    private /* synthetic */ float[] color;

    @Override
    public void glDisable(int llllllllllllllllIlIIlIlIIIllIIII) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIllIIll;
        llllllllllllllllIlIIlIlIIIllIIll.applyBuffer();
        super.glDisable(llllllllllllllllIlIIlIlIIIllIIII);
    }

    @Override
    public void glPushMatrix() {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIIllIIl;
        llllllllllllllllIlIIlIlIIIIllIIl.applyBuffer();
        super.glPushMatrix();
    }

    @Override
    public void glCallList(int llllllllllllllllIlIIlIlIIlIlIlII) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIlIlIlIl;
        llllllllllllllllIlIIlIlIIlIlIlIl.applyBuffer();
        super.glCallList(llllllllllllllllIlIIlIlIIlIlIlII);
    }

    @Override
    public void glTranslatef(float llllllllllllllllIlIIlIIlllIlllII, float llllllllllllllllIlIIlIIlllIlIlll, float llllllllllllllllIlIIlIIlllIllIlI) {
        VAOGLRenderer llllllllllllllllIlIIlIIlllIllIIl;
        llllllllllllllllIlIIlIIlllIllIIl.applyBuffer();
        super.glTranslatef(llllllllllllllllIlIIlIIlllIlllII, llllllllllllllllIlIIlIIlllIlIlll, llllllllllllllllIlIIlIIlllIllIlI);
    }

    @Override
    public void glBegin(int llllllllllllllllIlIIlIlIlIlIIllI) {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIlIlIIl;
        if (llllllllllllllllIlIIlIlIlIlIlIIl.listMode > 0) {
            super.glBegin(llllllllllllllllIlIIlIlIlIlIIllI);
            return;
        }
        if (llllllllllllllllIlIIlIlIlIlIlIIl.currentType != llllllllllllllllIlIIlIlIlIlIIllI) {
            llllllllllllllllIlIIlIlIlIlIlIIl.applyBuffer();
            llllllllllllllllIlIIlIlIlIlIlIIl.currentType = llllllllllllllllIlIIlIlIlIlIIllI;
        }
    }

    @Override
    public void glBlendFunc(int llllllllllllllllIlIIlIlIIlIllIll, int llllllllllllllllIlIIlIlIIlIlllIl) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIlIlllll;
        llllllllllllllllIlIIlIlIIlIlllll.applyBuffer();
        super.glBlendFunc(llllllllllllllllIlIIlIlIIlIllIll, llllllllllllllllIlIIlIlIIlIlllIl);
    }

    @Override
    public void initDisplay(int llllllllllllllllIlIIlIlIlIllllll, int llllllllllllllllIlIIlIlIlIlllIll) {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIllllIl;
        super.initDisplay(llllllllllllllllIlIIlIlIlIllllll, llllllllllllllllIlIIlIlIlIlllIll);
        llllllllllllllllIlIIlIlIlIllllIl.startBuffer();
        GL11.glEnableClientState((int)32884);
        GL11.glEnableClientState((int)32888);
        GL11.glEnableClientState((int)32886);
    }

    public VAOGLRenderer() {
        VAOGLRenderer llllllllllllllllIlIIlIlIllIIIlIl;
        llllllllllllllllIlIIlIlIllIIIlIl.currentType = -1;
        llllllllllllllllIlIIlIlIllIIIlIl.color = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        llllllllllllllllIlIIlIlIllIIIlIl.tex = new float[]{0.0f, 0.0f};
        llllllllllllllllIlIIlIlIllIIIlIl.verts = new float[15000];
        llllllllllllllllIlIIlIlIllIIIlIl.cols = new float[20000];
        llllllllllllllllIlIIlIlIllIIIlIl.texs = new float[15000];
        llllllllllllllllIlIIlIlIllIIIlIl.vertices = BufferUtils.createFloatBuffer((int)15000);
        llllllllllllllllIlIIlIlIllIIIlIl.colors = BufferUtils.createFloatBuffer((int)20000);
        llllllllllllllllIlIIlIlIllIIIlIl.textures = BufferUtils.createFloatBuffer((int)10000);
        llllllllllllllllIlIIlIlIllIIIlIl.listMode = 0;
    }

    @Override
    public void glRotatef(float llllllllllllllllIlIIlIlIIIIlIIIl, float llllllllllllllllIlIIlIlIIIIlIIII, float llllllllllllllllIlIIlIlIIIIIllll, float llllllllllllllllIlIIlIlIIIIIlIIl) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIIlIIlI;
        llllllllllllllllIlIIlIlIIIIlIIlI.applyBuffer();
        super.glRotatef(llllllllllllllllIlIIlIlIIIIlIIIl, llllllllllllllllIlIIlIlIIIIlIIII, llllllllllllllllIlIIlIlIIIIIllll, llllllllllllllllIlIIlIlIIIIIlIIl);
    }

    @Override
    public void glNewList(int llllllllllllllllIlIIlIIlllIIlllI, int llllllllllllllllIlIIlIIlllIIllIl) {
        VAOGLRenderer llllllllllllllllIlIIlIIlllIIllll;
        ++llllllllllllllllIlIIlIIlllIIllll.listMode;
        super.glNewList(llllllllllllllllIlIIlIIlllIIlllI, llllllllllllllllIlIIlIIlllIIllIl);
    }

    static {
        MAX_VERTS = 5000;
        TOLERANCE = 20;
        NONE = -1;
    }

    @Override
    public void glColor4f(float llllllllllllllllIlIIlIlIlIIllIlI, float llllllllllllllllIlIIlIlIlIIllIIl, float llllllllllllllllIlIIlIlIlIIlllIl, float llllllllllllllllIlIIlIlIlIIlIlll) {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIIllIll;
        llllllllllllllllIlIIlIlIlIIllIll.color[0] = llllllllllllllllIlIIlIlIlIIllIlI;
        llllllllllllllllIlIIlIlIlIIllIll.color[1] = llllllllllllllllIlIIlIlIlIIllIIl;
        llllllllllllllllIlIIlIlIlIIllIll.color[2] = llllllllllllllllIlIIlIlIlIIlllIl;
        llllllllllllllllIlIIlIlIlIIllIll.color[3] = llllllllllllllllIlIIlIlIlIIlIlll *= llllllllllllllllIlIIlIlIlIIllIll.alphaScale;
        if (llllllllllllllllIlIIlIlIlIIllIll.listMode > 0) {
            super.glColor4f(llllllllllllllllIlIIlIlIlIIllIlI, llllllllllllllllIlIIlIlIlIIllIIl, llllllllllllllllIlIIlIlIlIIlllIl, llllllllllllllllIlIIlIlIlIIlIlll);
            return;
        }
    }

    @Override
    public void glEndList() {
        VAOGLRenderer llllllllllllllllIlIIlIIlllIlIIll;
        --llllllllllllllllIlIIlIIlllIlIIll.listMode;
        super.glEndList();
    }

    private void startBuffer() {
        llllllllllllllllIlIIlIlIlIlllIIl.vertIndex = 0;
    }

    @Override
    public void glTexCoord2f(float llllllllllllllllIlIIlIlIlIIIllll, float llllllllllllllllIlIIlIlIlIIIlIll) {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIIIllIl;
        if (llllllllllllllllIlIIlIlIlIIIllIl.listMode > 0) {
            super.glTexCoord2f(llllllllllllllllIlIIlIlIlIIIllll, llllllllllllllllIlIIlIlIlIIIlIll);
            return;
        }
        llllllllllllllllIlIIlIlIlIIIllIl.tex[0] = llllllllllllllllIlIIlIlIlIIIllll;
        llllllllllllllllIlIIlIlIlIIIllIl.tex[1] = llllllllllllllllIlIIlIlIlIIIlIll;
    }

    private boolean isSplittable(int llllllllllllllllIlIIlIlIIllIllll, int llllllllllllllllIlIIlIlIIllIlllI) {
        switch (llllllllllllllllIlIIlIlIIllIlllI) {
            case 7: {
                return llllllllllllllllIlIIlIlIIllIllll % 4 == 0;
            }
            case 4: {
                return llllllllllllllllIlIIlIlIIllIllll % 3 == 0;
            }
            case 6913: {
                return llllllllllllllllIlIIlIlIIllIllll % 2 == 0;
            }
        }
        return false;
    }

    @Override
    public void glLoadMatrix(FloatBuffer llllllllllllllllIlIIlIIlllIIIIll) {
        VAOGLRenderer llllllllllllllllIlIIlIIlllIIIlII;
        llllllllllllllllIlIIlIIlllIIIlII.flushBuffer();
        super.glLoadMatrix(llllllllllllllllIlIIlIIlllIIIIll);
    }

    private void applyBuffer() {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIlIllll;
        if (llllllllllllllllIlIIlIlIlIlIllll.listMode > 0) {
            return;
        }
        if (llllllllllllllllIlIIlIlIlIlIllll.vertIndex != 0) {
            llllllllllllllllIlIIlIlIlIlIllll.flushBuffer();
            llllllllllllllllIlIIlIlIlIlIllll.startBuffer();
        }
        super.glColor4f(llllllllllllllllIlIIlIlIlIlIllll.color[0], llllllllllllllllIlIIlIlIlIlIllll.color[1], llllllllllllllllIlIIlIlIlIlIllll.color[2], llllllllllllllllIlIIlIlIlIlIllll.color[3]);
    }

    private void flushBuffer() {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIllIIll;
        if (llllllllllllllllIlIIlIlIlIllIIll.vertIndex == 0) {
            return;
        }
        if (llllllllllllllllIlIIlIlIlIllIIll.currentType == -1) {
            return;
        }
        if (llllllllllllllllIlIIlIlIlIllIIll.vertIndex < 20) {
            GL11.glBegin((int)llllllllllllllllIlIIlIlIlIllIIll.currentType);
            for (int llllllllllllllllIlIIlIlIlIllIlIl = 0; llllllllllllllllIlIIlIlIlIllIlIl < llllllllllllllllIlIIlIlIlIllIIll.vertIndex; ++llllllllllllllllIlIIlIlIlIllIlIl) {
                GL11.glColor4f((float)llllllllllllllllIlIIlIlIlIllIIll.cols[llllllllllllllllIlIIlIlIlIllIlIl * 4 + 0], (float)llllllllllllllllIlIIlIlIlIllIIll.cols[llllllllllllllllIlIIlIlIlIllIlIl * 4 + 1], (float)llllllllllllllllIlIIlIlIlIllIIll.cols[llllllllllllllllIlIIlIlIlIllIlIl * 4 + 2], (float)llllllllllllllllIlIIlIlIlIllIIll.cols[llllllllllllllllIlIIlIlIlIllIlIl * 4 + 3]);
                GL11.glTexCoord2f((float)llllllllllllllllIlIIlIlIlIllIIll.texs[llllllllllllllllIlIIlIlIlIllIlIl * 2 + 0], (float)llllllllllllllllIlIIlIlIlIllIIll.texs[llllllllllllllllIlIIlIlIlIllIlIl * 2 + 1]);
                GL11.glVertex3f((float)llllllllllllllllIlIIlIlIlIllIIll.verts[llllllllllllllllIlIIlIlIlIllIlIl * 3 + 0], (float)llllllllllllllllIlIIlIlIlIllIIll.verts[llllllllllllllllIlIIlIlIlIllIlIl * 3 + 1], (float)llllllllllllllllIlIIlIlIlIllIIll.verts[llllllllllllllllIlIIlIlIlIllIlIl * 3 + 2]);
            }
            GL11.glEnd();
            llllllllllllllllIlIIlIlIlIllIIll.currentType = -1;
            return;
        }
        llllllllllllllllIlIIlIlIlIllIIll.vertices.clear();
        llllllllllllllllIlIIlIlIlIllIIll.colors.clear();
        llllllllllllllllIlIIlIlIlIllIIll.textures.clear();
        llllllllllllllllIlIIlIlIlIllIIll.vertices.put(llllllllllllllllIlIIlIlIlIllIIll.verts, 0, llllllllllllllllIlIIlIlIlIllIIll.vertIndex * 3);
        llllllllllllllllIlIIlIlIlIllIIll.colors.put(llllllllllllllllIlIIlIlIlIllIIll.cols, 0, llllllllllllllllIlIIlIlIlIllIIll.vertIndex * 4);
        llllllllllllllllIlIIlIlIlIllIIll.textures.put(llllllllllllllllIlIIlIlIlIllIIll.texs, 0, llllllllllllllllIlIIlIlIlIllIIll.vertIndex * 2);
        llllllllllllllllIlIIlIlIlIllIIll.vertices.flip();
        llllllllllllllllIlIIlIlIlIllIIll.colors.flip();
        llllllllllllllllIlIIlIlIlIllIIll.textures.flip();
        GL11.glVertexPointer((int)3, (int)0, (FloatBuffer)llllllllllllllllIlIIlIlIlIllIIll.vertices);
        GL11.glColorPointer((int)4, (int)0, (FloatBuffer)llllllllllllllllIlIIlIlIlIllIIll.colors);
        GL11.glTexCoordPointer((int)2, (int)0, (FloatBuffer)llllllllllllllllIlIIlIlIlIllIIll.textures);
        GL11.glDrawArrays((int)llllllllllllllllIlIIlIlIlIllIIll.currentType, (int)0, (int)llllllllllllllllIlIIlIlIlIllIIll.vertIndex);
        llllllllllllllllIlIIlIlIlIllIIll.currentType = -1;
    }

    @Override
    public void glClipPlane(int llllllllllllllllIlIIlIlIIlIIIllI, DoubleBuffer llllllllllllllllIlIIlIlIIlIIlIII) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIlIIlIlI;
        llllllllllllllllIlIIlIlIIlIIlIlI.applyBuffer();
        super.glClipPlane(llllllllllllllllIlIIlIlIIlIIIllI, llllllllllllllllIlIIlIlIIlIIlIII);
    }

    @Override
    public void glClear(int llllllllllllllllIlIIlIlIIlIIlllI) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIlIlIIIl;
        llllllllllllllllIlIIlIlIIlIlIIIl.applyBuffer();
        super.glClear(llllllllllllllllIlIIlIlIIlIIlllI);
    }

    @Override
    public void glScalef(float llllllllllllllllIlIIlIIlllllllll, float llllllllllllllllIlIIlIIllllllllI, float llllllllllllllllIlIIlIIlllllllIl) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIIIIIII;
        llllllllllllllllIlIIlIlIIIIIIIII.applyBuffer();
        super.glScalef(llllllllllllllllIlIIlIIlllllllll, llllllllllllllllIlIIlIIllllllllI, llllllllllllllllIlIIlIIlllllllIl);
    }

    @Override
    public void glEnd() {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIIlIlIl;
        if (llllllllllllllllIlIIlIlIlIIlIlIl.listMode > 0) {
            super.glEnd();
            return;
        }
    }

    @Override
    public void flush() {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIlIllII;
        super.flush();
        llllllllllllllllIlIIlIlIlIlIllII.applyBuffer();
    }

    @Override
    public void glBindTexture(int llllllllllllllllIlIIlIlIIllIIlll, int llllllllllllllllIlIIlIlIIllIIllI) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIllIIlIl;
        llllllllllllllllIlIIlIlIIllIIlIl.applyBuffer();
        super.glBindTexture(llllllllllllllllIlIIlIlIIllIIlll, llllllllllllllllIlIIlIlIIllIIllI);
    }

    @Override
    public float[] getCurrentColor() {
        VAOGLRenderer llllllllllllllllIlIIlIIlllIIIlll;
        return llllllllllllllllIlIIlIIlllIIIlll.color;
    }

    @Override
    public void glLineWidth(float llllllllllllllllIlIIlIlIIIlIIllI) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIlIIlll;
        llllllllllllllllIlIIlIlIIIlIIlll.applyBuffer();
        super.glLineWidth(llllllllllllllllIlIIlIlIIIlIIllI);
    }

    @Override
    public void glPopMatrix() {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIIlllII;
        llllllllllllllllIlIIlIlIIIIlllII.applyBuffer();
        super.glPopMatrix();
    }

    @Override
    public void glVertex2f(float llllllllllllllllIlIIlIlIlIIIIIll, float llllllllllllllllIlIIlIlIlIIIIIlI) {
        VAOGLRenderer llllllllllllllllIlIIlIlIlIIIIlll;
        if (llllllllllllllllIlIIlIlIlIIIIlll.listMode > 0) {
            super.glVertex2f(llllllllllllllllIlIIlIlIlIIIIIll, llllllllllllllllIlIIlIlIlIIIIIlI);
            return;
        }
        llllllllllllllllIlIIlIlIlIIIIlll.glVertex3f(llllllllllllllllIlIIlIlIlIIIIIll, llllllllllllllllIlIIlIlIlIIIIIlI, 0.0f);
    }

    @Override
    public void glEnable(int llllllllllllllllIlIIlIlIIIlIllII) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIlIllIl;
        llllllllllllllllIlIIlIlIIIlIllIl.applyBuffer();
        super.glEnable(llllllllllllllllIlIIlIlIIIlIllII);
    }

    @Override
    public void glPointSize(float llllllllllllllllIlIIlIlIIIlIIIII) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIlIIIIl;
        llllllllllllllllIlIIlIlIIIlIIIIl.applyBuffer();
        super.glPointSize(llllllllllllllllIlIIlIlIIIlIIIII);
    }

    @Override
    public void glScissor(int llllllllllllllllIlIIlIIlllllIIIl, int llllllllllllllllIlIIlIIlllllIlIl, int llllllllllllllllIlIIlIIllllIllll, int llllllllllllllllIlIIlIIlllllIIll) {
        VAOGLRenderer llllllllllllllllIlIIlIIlllllIlll;
        llllllllllllllllIlIIlIIlllllIlll.applyBuffer();
        super.glScissor(llllllllllllllllIlIIlIIlllllIIIl, llllllllllllllllIlIIlIIlllllIlIl, llllllllllllllllIlIIlIIllllIllll, llllllllllllllllIlIIlIIlllllIIll);
    }

    @Override
    public void glColorMask(boolean llllllllllllllllIlIIlIlIIIlllllI, boolean llllllllllllllllIlIIlIlIIIllllIl, boolean llllllllllllllllIlIIlIlIIIllllII, boolean llllllllllllllllIlIIlIlIIIllIllI) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIIllllll;
        llllllllllllllllIlIIlIlIIIllllll.applyBuffer();
        super.glColorMask(llllllllllllllllIlIIlIlIIIlllllI, llllllllllllllllIlIIlIlIIIllllIl, llllllllllllllllIlIIlIlIIIllllII, llllllllllllllllIlIIlIlIIIllIllI);
    }

    @Override
    public void glTexEnvi(int llllllllllllllllIlIIlIIllllIIlII, int llllllllllllllllIlIIlIIllllIIIll, int llllllllllllllllIlIIlIIllllIIIlI) {
        VAOGLRenderer llllllllllllllllIlIIlIIllllIIlIl;
        llllllllllllllllIlIIlIIllllIIlIl.applyBuffer();
        super.glTexEnvi(llllllllllllllllIlIIlIIllllIIlII, llllllllllllllllIlIIlIIllllIIIll, llllllllllllllllIlIIlIIllllIIIlI);
    }

    @Override
    public void glVertex3f(float llllllllllllllllIlIIlIlIIlllIllI, float llllllllllllllllIlIIlIlIIlllIlIl, float llllllllllllllllIlIIlIlIIllllIII) {
        VAOGLRenderer llllllllllllllllIlIIlIlIIlllIlll;
        if (llllllllllllllllIlIIlIlIIlllIlll.listMode > 0) {
            super.glVertex3f(llllllllllllllllIlIIlIlIIlllIllI, llllllllllllllllIlIIlIlIIlllIlIl, llllllllllllllllIlIIlIlIIllllIII);
            return;
        }
        llllllllllllllllIlIIlIlIIlllIlll.verts[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 3 + 0] = llllllllllllllllIlIIlIlIIlllIllI;
        llllllllllllllllIlIIlIlIIlllIlll.verts[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 3 + 1] = llllllllllllllllIlIIlIlIIlllIlIl;
        llllllllllllllllIlIIlIlIIlllIlll.verts[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 3 + 2] = llllllllllllllllIlIIlIlIIllllIII;
        llllllllllllllllIlIIlIlIIlllIlll.cols[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 4 + 0] = llllllllllllllllIlIIlIlIIlllIlll.color[0];
        llllllllllllllllIlIIlIlIIlllIlll.cols[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 4 + 1] = llllllllllllllllIlIIlIlIIlllIlll.color[1];
        llllllllllllllllIlIIlIlIIlllIlll.cols[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 4 + 2] = llllllllllllllllIlIIlIlIIlllIlll.color[2];
        llllllllllllllllIlIIlIlIIlllIlll.cols[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 4 + 3] = llllllllllllllllIlIIlIlIIlllIlll.color[3];
        llllllllllllllllIlIIlIlIIlllIlll.texs[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 2 + 0] = llllllllllllllllIlIIlIlIIlllIlll.tex[0];
        llllllllllllllllIlIIlIlIIlllIlll.texs[llllllllllllllllIlIIlIlIIlllIlll.vertIndex * 2 + 1] = llllllllllllllllIlIIlIlIIlllIlll.tex[1];
        ++llllllllllllllllIlIIlIlIIlllIlll.vertIndex;
        if (llllllllllllllllIlIIlIlIIlllIlll.vertIndex > 4950 && llllllllllllllllIlIIlIlIIlllIlll.isSplittable(llllllllllllllllIlIIlIlIIlllIlll.vertIndex, llllllllllllllllIlIIlIlIIlllIlll.currentType)) {
            int llllllllllllllllIlIIlIlIIlllllII = llllllllllllllllIlIIlIlIIlllIlll.currentType;
            llllllllllllllllIlIIlIlIIlllIlll.applyBuffer();
            llllllllllllllllIlIIlIlIIlllIlll.currentType = llllllllllllllllIlIIlIlIIlllllII;
        }
    }
}

