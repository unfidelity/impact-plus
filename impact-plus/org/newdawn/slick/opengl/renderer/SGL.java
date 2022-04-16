/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl.renderer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface SGL {
    public static final /* synthetic */ int GL_POLYGON_SMOOTH;
    public static final /* synthetic */ int GL_CLIP_PLANE0;
    public static final /* synthetic */ int GL_ONE_MINUS_DST_ALPHA;
    public static final /* synthetic */ int GL_LINE_WIDTH;
    public static final /* synthetic */ int GL_LINE_SMOOTH;
    public static final /* synthetic */ int GL_DST_ALPHA;
    public static final /* synthetic */ int GL_TEXTURE_2D;
    public static final /* synthetic */ int GL_RGBA;
    public static final /* synthetic */ int GL_EQUAL;
    public static final /* synthetic */ int GL_CLIP_PLANE3;
    public static final /* synthetic */ int GL_SCISSOR_TEST;
    public static final /* synthetic */ int GL_TRIANGLE_FAN;
    public static final /* synthetic */ int GL_POINT_SMOOTH;
    public static final /* synthetic */ int GL_DEPTH_TEST;
    public static final /* synthetic */ int GL_CLIP_PLANE2;
    public static final /* synthetic */ int GL_MAX_TEXTURE_SIZE;
    public static final /* synthetic */ int GL_COMPILE;
    public static final /* synthetic */ int GL_SRC_ALPHA;
    public static final /* synthetic */ int GL_TRIANGLES;
    public static final /* synthetic */ int GL_ONE_MINUS_SRC_ALPHA;
    public static final /* synthetic */ int GL_CLAMP;
    public static final /* synthetic */ int GL_COMPILE_AND_EXECUTE;
    public static final /* synthetic */ int GL_BGRA;
    public static final /* synthetic */ int GL_RGBA8;
    public static final /* synthetic */ int GL_NEAREST;
    public static final /* synthetic */ int GL_ONE;
    public static final /* synthetic */ int GL_SRC_COLOR;
    public static final /* synthetic */ int GL_LINE_STRIP;
    public static final /* synthetic */ int GL_COLOR_CLEAR_VALUE;
    public static final /* synthetic */ int GL_TEXTURE_ENV_MODE;
    public static final /* synthetic */ int GL_MODULATE;
    public static final /* synthetic */ int GL_TEXTURE_ENV;
    public static final /* synthetic */ int GL_RGB;
    public static final /* synthetic */ int GL_TEXTURE_WRAP_S;
    public static final /* synthetic */ int GL_QUADS;
    public static final /* synthetic */ int GL_CLIP_PLANE1;
    public static final /* synthetic */ int GL_POINTS;
    public static final /* synthetic */ int GL_LINEAR;
    public static final /* synthetic */ int GL_BLEND;
    public static final /* synthetic */ int GL_UNSIGNED_BYTE;
    public static final /* synthetic */ int GL_DEPTH_BUFFER_BIT;
    public static final /* synthetic */ int GL_TEXTURE_MAG_FILTER;
    public static final /* synthetic */ int GL_ALWAYS;
    public static final /* synthetic */ int GL_NOTEQUAL;
    public static final /* synthetic */ int GL_COLOR_BUFFER_BIT;
    public static final /* synthetic */ int GL_RGBA16;
    public static final /* synthetic */ int GL_TEXTURE_WRAP_T;
    public static final /* synthetic */ int GL_MIRROR_CLAMP_TO_EDGE_EXT;
    public static final /* synthetic */ int GL_MODELVIEW_MATRIX;
    public static final /* synthetic */ int GL_LINES;
    public static final /* synthetic */ int GL_ONE_MINUS_SRC_COLOR;
    public static final /* synthetic */ int GL_COLOR_SUM_EXT;
    public static final /* synthetic */ int GL_TEXTURE_MIN_FILTER;

    public void glSecondaryColor3ubEXT(byte var1, byte var2, byte var3);

    public void glGetInteger(int var1, IntBuffer var2);

    public void glPopMatrix();

    public void glClearDepth(float var1);

    public void glDeleteLists(int var1, int var2);

    public void flush();

    public void glScissor(int var1, int var2, int var3, int var4);

    public float[] getCurrentColor();

    public void glTexCoord2f(float var1, float var2);

    public void glVertex2f(float var1, float var2);

    public boolean canSecondaryColor();

    public void glGenTextures(IntBuffer var1);

    public void glEnd();

    public void glClear(int var1);

    public void glEndList();

    public void glGetTexImage(int var1, int var2, int var3, int var4, ByteBuffer var5);

    public void glTranslatef(float var1, float var2, float var3);

    public void glTexImage2D(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, ByteBuffer var9);

    static {
        GL_LINE_WIDTH = 2849;
        GL_RGBA16 = 32859;
        GL_ONE = 1;
        GL_CLIP_PLANE1 = 12289;
        GL_COLOR_BUFFER_BIT = 16384;
        GL_TRIANGLES = 4;
        GL_EQUAL = 514;
        GL_ONE_MINUS_SRC_COLOR = 769;
        GL_LINE_STRIP = 3;
        GL_LINES = 1;
        GL_QUADS = 7;
        GL_DEPTH_BUFFER_BIT = 256;
        GL_RGB = 6407;
        GL_TEXTURE_WRAP_S = 10242;
        GL_SRC_ALPHA = 770;
        GL_BGRA = 32993;
        GL_MODELVIEW_MATRIX = 2982;
        GL_LINEAR = 9729;
        GL_TEXTURE_WRAP_T = 10243;
        GL_MODULATE = 8448;
        GL_TEXTURE_ENV_MODE = 8704;
        GL_MAX_TEXTURE_SIZE = 3379;
        GL_NOTEQUAL = 517;
        GL_LINE_SMOOTH = 2848;
        GL_NEAREST = 9728;
        GL_TEXTURE_MAG_FILTER = 10240;
        GL_ONE_MINUS_SRC_ALPHA = 771;
        GL_RGBA = 6408;
        GL_TEXTURE_2D = 3553;
        GL_CLIP_PLANE2 = 12290;
        GL_CLIP_PLANE0 = 12288;
        GL_SRC_COLOR = 768;
        GL_TRIANGLE_FAN = 6;
        GL_MIRROR_CLAMP_TO_EDGE_EXT = 34627;
        GL_POLYGON_SMOOTH = 2881;
        GL_COMPILE_AND_EXECUTE = 4865;
        GL_ONE_MINUS_DST_ALPHA = 773;
        GL_CLAMP = 10496;
        GL_COLOR_SUM_EXT = 33880;
        GL_COLOR_CLEAR_VALUE = 3106;
        GL_ALWAYS = 519;
        GL_SCISSOR_TEST = 3089;
        GL_RGBA8 = 6408;
        GL_TEXTURE_ENV = 8960;
        GL_DEPTH_TEST = 2929;
        GL_COMPILE = 4864;
        GL_POINT_SMOOTH = 2832;
        GL_TEXTURE_MIN_FILTER = 10241;
        GL_CLIP_PLANE3 = 12291;
        GL_UNSIGNED_BYTE = 5121;
        GL_POINTS = 0;
        GL_DST_ALPHA = 772;
        GL_BLEND = 3042;
    }

    public void glLoadIdentity();

    public void glPointSize(float var1);

    public void glCallList(int var1);

    public void glGetError();

    public void glPushMatrix();

    public void setGlobalAlphaScale(float var1);

    public void glDeleteTextures(IntBuffer var1);

    public void enterOrtho(int var1, int var2);

    public void initDisplay(int var1, int var2);

    public void glTexEnvi(int var1, int var2, int var3);

    public boolean canTextureMirrorClamp();

    public void glGetFloat(int var1, FloatBuffer var2);

    public void glDisable(int var1);

    public void glDepthFunc(int var1);

    public void glClipPlane(int var1, DoubleBuffer var2);

    public void glVertex3f(float var1, float var2, float var3);

    public void glBlendFunc(int var1, int var2);

    public int glGenLists(int var1);

    public void glReadPixels(int var1, int var2, int var3, int var4, int var5, int var6, ByteBuffer var7);

    public void glLineWidth(float var1);

    public void glRotatef(float var1, float var2, float var3, float var4);

    public void glColor4f(float var1, float var2, float var3, float var4);

    public void glLoadMatrix(FloatBuffer var1);

    public void glTexSubImage2D(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, ByteBuffer var9);

    public void glEnable(int var1);

    public void glScalef(float var1, float var2, float var3);

    public void glTexParameteri(int var1, int var2, int var3);

    public void glColorMask(boolean var1, boolean var2, boolean var3, boolean var4);

    public void glBindTexture(int var1, int var2);

    public void glDepthMask(boolean var1);

    public void glClearColor(float var1, float var2, float var3, float var4);

    public void glCopyTexImage2D(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    public void glNewList(int var1, int var2);

    public void glBegin(int var1);
}

