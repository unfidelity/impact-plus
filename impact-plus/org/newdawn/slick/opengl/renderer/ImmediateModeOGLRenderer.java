/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.EXTSecondaryColor
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 */
package org.newdawn.slick.opengl.renderer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.EXTSecondaryColor;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.opengl.renderer.SGL;

public class ImmediateModeOGLRenderer
implements SGL {
    private /* synthetic */ int height;
    private /* synthetic */ int width;
    protected /* synthetic */ float alphaScale;
    private /* synthetic */ float[] current;

    @Override
    public void glTexParameteri(int llllllllllllllllIlllllIlIIllllIl, int llllllllllllllllIlllllIlIIllllII, int llllllllllllllllIlllllIlIIlllIlI) {
        GL11.glTexParameteri((int)llllllllllllllllIlllllIlIIllllIl, (int)llllllllllllllllIlllllIlIIllllII, (int)llllllllllllllllIlllllIlIIlllIlI);
    }

    @Override
    public void glSecondaryColor3ubEXT(byte llllllllllllllllIlllllIIIIlIlllI, byte llllllllllllllllIlllllIIIIlIllIl, byte llllllllllllllllIlllllIIIIlIIllI) {
        EXTSecondaryColor.glSecondaryColor3ubEXT((byte)llllllllllllllllIlllllIIIIlIlllI, (byte)llllllllllllllllIlllllIIIIlIllIl, (byte)llllllllllllllllIlllllIIIIlIIllI);
    }

    @Override
    public void glTexSubImage2D(int llllllllllllllllIlllllIIIlIlIlIl, int llllllllllllllllIlllllIIIlIlIlII, int llllllllllllllllIlllllIIIlIlllII, int llllllllllllllllIlllllIIIlIllIll, int llllllllllllllllIlllllIIIlIlIIIl, int llllllllllllllllIlllllIIIlIlIIII, int llllllllllllllllIlllllIIIlIllIII, int llllllllllllllllIlllllIIIlIlIlll, ByteBuffer llllllllllllllllIlllllIIIlIIllIl) {
        GL11.glTexSubImage2D((int)llllllllllllllllIlllllIIIlIlIlIl, (int)llllllllllllllllIlllllIIIlIlIlII, (int)llllllllllllllllIlllllIIIlIlllII, (int)llllllllllllllllIlllllIIIlIllIll, (int)llllllllllllllllIlllllIIIlIlIIIl, (int)llllllllllllllllIlllllIIIlIlIIII, (int)llllllllllllllllIlllllIIIlIllIII, (int)llllllllllllllllIlllllIIIlIlIlll, (ByteBuffer)llllllllllllllllIlllllIIIlIIllIl);
    }

    @Override
    public void glDeleteLists(int llllllllllllllllIlllllIlIIIlIlII, int llllllllllllllllIlllllIlIIIlIIIl) {
        GL11.glDeleteLists((int)llllllllllllllllIlllllIlIIIlIlII, (int)llllllllllllllllIlllllIlIIIlIIIl);
    }

    @Override
    public void glGetError() {
        GL11.glGetError();
    }

    @Override
    public void enterOrtho(int llllllllllllllllIlllllllllIIllll, int llllllllllllllllIlllllllllIIIlll) {
        ImmediateModeOGLRenderer llllllllllllllllIlllllllllIIlIIl;
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)llllllllllllllllIlllllllllIIlIIl.width, (double)llllllllllllllllIlllllllllIIlIIl.height, (double)0.0, (double)1.0, (double)-1.0);
        GL11.glMatrixMode((int)5888);
        GL11.glTranslatef((float)((llllllllllllllllIlllllllllIIlIIl.width - llllllllllllllllIlllllllllIIllll) / 2), (float)((llllllllllllllllIlllllllllIIlIIl.height - llllllllllllllllIlllllllllIIIlll) / 2), (float)0.0f);
    }

    @Override
    public void glClearColor(float llllllllllllllllIllllllllIIIIIlI, float llllllllllllllllIllllllllIIIIIII, float llllllllllllllllIlllllllIlllllll, float llllllllllllllllIlllllllIllllllI) {
        GL11.glClearColor((float)llllllllllllllllIllllllllIIIIIlI, (float)llllllllllllllllIllllllllIIIIIII, (float)llllllllllllllllIlllllllIlllllll, (float)llllllllllllllllIlllllllIllllllI);
    }

    @Override
    public void glTexImage2D(int llllllllllllllllIlllllIIIlllIlll, int llllllllllllllllIlllllIIIlllllll, int llllllllllllllllIlllllIIIlllIlIl, int llllllllllllllllIlllllIIIlllllIl, int llllllllllllllllIlllllIIIlllllII, int llllllllllllllllIlllllIIIllllIll, int llllllllllllllllIlllllIIIllllIlI, int llllllllllllllllIlllllIIIlllIIII, ByteBuffer llllllllllllllllIlllllIIIllIllll) {
        GL11.glTexImage2D((int)llllllllllllllllIlllllIIIlllIlll, (int)llllllllllllllllIlllllIIIlllllll, (int)llllllllllllllllIlllllIIIlllIlIl, (int)llllllllllllllllIlllllIIIlllllIl, (int)llllllllllllllllIlllllIIIlllllII, (int)llllllllllllllllIlllllIIIllllIll, (int)llllllllllllllllIlllllIIIllllIlI, (int)llllllllllllllllIlllllIIIlllIIII, (ByteBuffer)llllllllllllllllIlllllIIIllIllll);
    }

    @Override
    public void glCallList(int llllllllllllllllIllllllllIlIIIll) {
        GL11.glCallList((int)llllllllllllllllIllllllllIlIIIll);
    }

    @Override
    public void glCopyTexImage2D(int llllllllllllllllIlllllllIIlllIII, int llllllllllllllllIlllllllIIllIllI, int llllllllllllllllIlllllllIIllIlIl, int llllllllllllllllIlllllllIIlIlIII, int llllllllllllllllIlllllllIIllIIlI, int llllllllllllllllIlllllllIIllIIII, int llllllllllllllllIlllllllIIlIllll, int llllllllllllllllIlllllllIIlIlllI) {
        GL11.glCopyTexImage2D((int)llllllllllllllllIlllllllIIlllIII, (int)llllllllllllllllIlllllllIIllIllI, (int)llllllllllllllllIlllllllIIllIlIl, (int)llllllllllllllllIlllllllIIlIlIII, (int)llllllllllllllllIlllllllIIllIIlI, (int)llllllllllllllllIlllllllIIllIIII, (int)llllllllllllllllIlllllllIIlIllll, (int)llllllllllllllllIlllllllIIlIlllI);
    }

    @Override
    public void glBlendFunc(int llllllllllllllllIllllllllIlIlIlI, int llllllllllllllllIllllllllIlIlIll) {
        GL11.glBlendFunc((int)llllllllllllllllIllllllllIlIlIlI, (int)llllllllllllllllIllllllllIlIlIll);
    }

    @Override
    public void glLoadMatrix(FloatBuffer llllllllllllllllIlllllIIllIlIIll) {
        GL11.glLoadMatrix((FloatBuffer)llllllllllllllllIlllllIIllIlIIll);
    }

    @Override
    public void glTranslatef(float llllllllllllllllIlllllIllIlIIlIl, float llllllllllllllllIlllllIllIlIIlII, float llllllllllllllllIlllllIllIlIIllI) {
        GL11.glTranslatef((float)llllllllllllllllIlllllIllIlIIlIl, (float)llllllllllllllllIlllllIllIlIIlII, (float)llllllllllllllllIlllllIllIlIIllI);
    }

    @Override
    public void glClearDepth(float llllllllllllllllIlllllIlIIIIllII) {
        GL11.glClearDepth((double)llllllllllllllllIlllllIlIIIIllII);
    }

    @Override
    public void glGetFloat(int llllllllllllllllIllllllIllIlIlII, FloatBuffer llllllllllllllllIllllllIllIIllII) {
        GL11.glGetFloat((int)llllllllllllllllIllllllIllIlIlII, (FloatBuffer)llllllllllllllllIllllllIllIIllII);
    }

    @Override
    public float[] getCurrentColor() {
        ImmediateModeOGLRenderer llllllllllllllllIlllllIlIIlIIlII;
        return llllllllllllllllIlllllIlIIlIIlII.current;
    }

    @Override
    public void glBindTexture(int llllllllllllllllIllllllllIllIIll, int llllllllllllllllIllllllllIllIIIl) {
        GL11.glBindTexture((int)llllllllllllllllIllllllllIllIIll, (int)llllllllllllllllIllllllllIllIIIl);
    }

    @Override
    public void glDisable(int llllllllllllllllIlllllllIIIIIllI) {
        GL11.glDisable((int)llllllllllllllllIlllllllIIIIIllI);
    }

    public ImmediateModeOGLRenderer() {
        ImmediateModeOGLRenderer llllllllllllllllIlllllllllllIIIl;
        llllllllllllllllIlllllllllllIIIl.current = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        llllllllllllllllIlllllllllllIIIl.alphaScale = 1.0f;
    }

    @Override
    public void glDepthFunc(int llllllllllllllllIlllllIlIIIIIIlI) {
        GL11.glDepthFunc((int)llllllllllllllllIlllllIlIIIIIIlI);
    }

    @Override
    public void glGenTextures(IntBuffer llllllllllllllllIlllllIIlIlllllI) {
        GL11.glGenTextures((IntBuffer)llllllllllllllllIlllllIIlIlllllI);
    }

    @Override
    public int glGenLists(int llllllllllllllllIllllllIlllIIIlI) {
        return GL11.glGenLists((int)llllllllllllllllIllllllIlllIIIlI);
    }

    @Override
    public void glReadPixels(int llllllllllllllllIllllllIIIIlllll, int llllllllllllllllIllllllIIIlIIlll, int llllllllllllllllIllllllIIIIllIll, int llllllllllllllllIllllllIIIIllIIl, int llllllllllllllllIllllllIIIIllIII, int llllllllllllllllIllllllIIIIlIlll, ByteBuffer llllllllllllllllIllllllIIIlIIIII) {
        GL11.glReadPixels((int)llllllllllllllllIllllllIIIIlllll, (int)llllllllllllllllIllllllIIIlIIlll, (int)llllllllllllllllIllllllIIIIllIll, (int)llllllllllllllllIllllllIIIIllIIl, (int)llllllllllllllllIllllllIIIIllIII, (int)llllllllllllllllIllllllIIIIlIlll, (ByteBuffer)llllllllllllllllIllllllIIIlIIIII);
    }

    @Override
    public void glLineWidth(float llllllllllllllllIllllllIIllllllI) {
        GL11.glLineWidth((float)llllllllllllllllIllllllIIllllllI);
    }

    @Override
    public void initDisplay(int llllllllllllllllIllllllllllIIIll, int llllllllllllllllIlllllllllIllIlI) {
        llllllllllllllllIllllllllllIIlIl.width = llllllllllllllllIllllllllllIIIll;
        llllllllllllllllIllllllllllIIlIl.height = llllllllllllllllIlllllllllIllIlI;
        String llllllllllllllllIlllllllllIlllll = GL11.glGetString((int)7939);
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7425);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glClearDepth((double)1.0);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glViewport((int)0, (int)0, (int)llllllllllllllllIllllllllllIIIll, (int)llllllllllllllllIlllllllllIllIlI);
        GL11.glMatrixMode((int)5888);
    }

    @Override
    public void flush() {
    }

    @Override
    public void glPopMatrix() {
        GL11.glPopMatrix();
    }

    @Override
    public void glTexEnvi(int llllllllllllllllIlllllIllIllIIll, int llllllllllllllllIlllllIllIllIIlI, int llllllllllllllllIlllllIllIllIIIl) {
        GL11.glTexEnvi((int)llllllllllllllllIlllllIllIllIIll, (int)llllllllllllllllIlllllIllIllIIlI, (int)llllllllllllllllIlllllIllIllIIIl);
    }

    @Override
    public void glDepthMask(boolean llllllllllllllllIlllllIIllllIlll) {
        GL11.glDepthMask((boolean)llllllllllllllllIlllllIIllllIlll);
    }

    @Override
    public void glScissor(int llllllllllllllllIlllllIlllllIIIl, int llllllllllllllllIlllllIllllIIlIl, int llllllllllllllllIlllllIllllIlIll, int llllllllllllllllIlllllIllllIlIII) {
        GL11.glScissor((int)llllllllllllllllIlllllIlllllIIIl, (int)llllllllllllllllIlllllIllllIIlIl, (int)llllllllllllllllIlllllIllllIlIll, (int)llllllllllllllllIlllllIllllIlIII);
    }

    @Override
    public void glVertex2f(float llllllllllllllllIlllllIllIIlIIlI, float llllllllllllllllIlllllIllIIlIIII) {
        GL11.glVertex2f((float)llllllllllllllllIlllllIllIIlIIlI, (float)llllllllllllllllIlllllIllIIlIIII);
    }

    @Override
    public void glGetTexImage(int llllllllllllllllIllllllIlIIIllll, int llllllllllllllllIllllllIlIIIllIl, int llllllllllllllllIllllllIlIIIlIll, int llllllllllllllllIllllllIlIIIlIlI, ByteBuffer llllllllllllllllIllllllIlIIlIIIl) {
        GL11.glGetTexImage((int)llllllllllllllllIllllllIlIIIllll, (int)llllllllllllllllIllllllIlIIIllIl, (int)llllllllllllllllIllllllIlIIIlIll, (int)llllllllllllllllIllllllIlIIIlIlI, (ByteBuffer)llllllllllllllllIllllllIlIIlIIIl);
    }

    @Override
    public void glScalef(float llllllllllllllllIlllllIlllllllll, float llllllllllllllllIlllllIllllllllI, float llllllllllllllllIllllllIIIIIIIII) {
        GL11.glScalef((float)llllllllllllllllIlllllIlllllllll, (float)llllllllllllllllIlllllIllllllllI, (float)llllllllllllllllIllllllIIIIIIIII);
    }

    @Override
    public void glRotatef(float llllllllllllllllIllllllIIIIIlIlI, float llllllllllllllllIllllllIIIIIlIIl, float llllllllllllllllIllllllIIIIIllII, float llllllllllllllllIllllllIIIIIlIll) {
        GL11.glRotatef((float)llllllllllllllllIllllllIIIIIlIlI, (float)llllllllllllllllIllllllIIIIIlIIl, (float)llllllllllllllllIllllllIIIIIllII, (float)llllllllllllllllIllllllIIIIIlIll);
    }

    @Override
    public void glPointSize(float llllllllllllllllIllllllIIlIllIIl) {
        GL11.glPointSize((float)llllllllllllllllIllllllIIlIllIIl);
    }

    @Override
    public void glEnable(int llllllllllllllllIllllllIlllIllIl) {
        GL11.glEnable((int)llllllllllllllllIllllllIlllIllIl);
    }

    @Override
    public void glClear(int llllllllllllllllIllllllllIIllIlI) {
        GL11.glClear((int)llllllllllllllllIllllllllIIllIlI);
    }

    @Override
    public void glTexCoord2f(float llllllllllllllllIlllllIlllIlIIlI, float llllllllllllllllIlllllIlllIlIIIl) {
        GL11.glTexCoord2f((float)llllllllllllllllIlllllIlllIlIIlI, (float)llllllllllllllllIlllllIlllIlIIIl);
    }

    @Override
    public void glColorMask(boolean llllllllllllllllIlllllllIlIIIlIl, boolean llllllllllllllllIlllllllIlIIlIll, boolean llllllllllllllllIlllllllIlIIlIIl, boolean llllllllllllllllIlllllllIlIIIlll) {
        GL11.glColorMask((boolean)llllllllllllllllIlllllllIlIIIlIl, (boolean)llllllllllllllllIlllllllIlIIlIll, (boolean)llllllllllllllllIlllllllIlIIlIIl, (boolean)llllllllllllllllIlllllllIlIIIlll);
    }

    @Override
    public void glEndList() {
        GL11.glEndList();
    }

    @Override
    public void glClipPlane(int llllllllllllllllIlllllllIlllIIlI, DoubleBuffer llllllllllllllllIlllllllIlllIIIl) {
        GL11.glClipPlane((int)llllllllllllllllIlllllllIlllIIlI, (DoubleBuffer)llllllllllllllllIlllllllIlllIIIl);
    }

    @Override
    public void glDeleteTextures(IntBuffer llllllllllllllllIlllllllIIIlIIll) {
        GL11.glDeleteTextures((IntBuffer)llllllllllllllllIlllllllIIIlIIll);
    }

    @Override
    public void glNewList(int llllllllllllllllIllllllIIllIIIll, int llllllllllllllllIllllllIIllIIIIl) {
        GL11.glNewList((int)llllllllllllllllIllllllIIllIIIll, (int)llllllllllllllllIllllllIIllIIIIl);
    }

    @Override
    public boolean canSecondaryColor() {
        return GLContext.getCapabilities().GL_EXT_secondary_color;
    }

    @Override
    public void glColor4f(float llllllllllllllllIlllllllIllIIIIl, float llllllllllllllllIlllllllIlIlIlll, float llllllllllllllllIlllllllIlIlIllI, float llllllllllllllllIlllllllIlIllIll) {
        ImmediateModeOGLRenderer llllllllllllllllIlllllllIlIllIIl;
        llllllllllllllllIlllllllIlIllIIl.current[0] = llllllllllllllllIlllllllIllIIIIl;
        llllllllllllllllIlllllllIlIllIIl.current[1] = llllllllllllllllIlllllllIlIlIlll;
        llllllllllllllllIlllllllIlIllIIl.current[2] = llllllllllllllllIlllllllIlIlIllI;
        llllllllllllllllIlllllllIlIllIIl.current[3] = llllllllllllllllIlllllllIlIllIll *= llllllllllllllllIlllllllIlIllIIl.alphaScale;
        GL11.glColor4f((float)llllllllllllllllIlllllllIllIIIIl, (float)llllllllllllllllIlllllllIlIlIlll, (float)llllllllllllllllIlllllllIlIlIllI, (float)llllllllllllllllIlllllllIlIllIll);
    }

    @Override
    public void setGlobalAlphaScale(float llllllllllllllllIlllllIIlllIIlIl) {
        llllllllllllllllIlllllIIlllIIllI.alphaScale = llllllllllllllllIlllllIIlllIIlIl;
    }

    @Override
    public void glGetInteger(int llllllllllllllllIllllllIlIlllllI, IntBuffer llllllllllllllllIllllllIlIllIlIl) {
        GL11.glGetInteger((int)llllllllllllllllIllllllIlIlllllI, (IntBuffer)llllllllllllllllIllllllIlIllIlIl);
    }

    @Override
    public void glVertex3f(float llllllllllllllllIlllllIlIllIIIIl, float llllllllllllllllIlllllIlIlIlllII, float llllllllllllllllIlllllIlIllIIlII) {
        GL11.glVertex3f((float)llllllllllllllllIlllllIlIllIIIIl, (float)llllllllllllllllIlllllIlIlIlllII, (float)llllllllllllllllIlllllIlIllIIlII);
    }

    @Override
    public void glLoadIdentity() {
        GL11.glLoadIdentity();
    }

    @Override
    public void glPushMatrix() {
        GL11.glPushMatrix();
    }

    @Override
    public void glEnd() {
        GL11.glEnd();
    }

    @Override
    public boolean canTextureMirrorClamp() {
        return GLContext.getCapabilities().GL_EXT_texture_mirror_clamp;
    }

    @Override
    public void glBegin(int llllllllllllllllIlllllllllIIIIll) {
        GL11.glBegin((int)llllllllllllllllIlllllllllIIIIll);
    }
}

