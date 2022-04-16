/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.ShapeRenderer;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.FastTrig;
import org.newdawn.slick.util.Log;

public class Graphics {
    protected static /* synthetic */ Graphics currentGraphics;
    public static /* synthetic */ int MODE_SCREEN;
    private static /* synthetic */ LineStripRenderer LSR;
    private static final /* synthetic */ int DEFAULT_SEGMENTS;
    public static /* synthetic */ int MODE_ALPHA_BLEND;
    public static /* synthetic */ int MODE_COLOR_MULTIPLY;
    protected /* synthetic */ int screenHeight;
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ Rectangle clip;
    private /* synthetic */ boolean pushed;
    private /* synthetic */ ArrayList stack;
    private /* synthetic */ boolean antialias;
    private /* synthetic */ Color currentColor;
    private /* synthetic */ float sy;
    public static /* synthetic */ int MODE_ADD;
    private /* synthetic */ int currentDrawingMode;
    private /* synthetic */ Rectangle worldClipRecord;
    protected static /* synthetic */ Font DEFAULT_FONT;
    public static /* synthetic */ int MODE_ALPHA_MAP;
    public static /* synthetic */ int MODE_NORMAL;
    private /* synthetic */ ByteBuffer readBuffer;
    private /* synthetic */ Font font;
    protected /* synthetic */ int screenWidth;
    private /* synthetic */ int stackIndex;
    private /* synthetic */ float sx;
    private /* synthetic */ float lineWidth;
    private /* synthetic */ DoubleBuffer worldClip;

    private int translate(byte lllllllllllllllllIllIllllIIlllII) {
        if (lllllllllllllllllIllIllllIIlllII < 0) {
            return 256 + lllllllllllllllllIllIllllIIlllII;
        }
        return lllllllllllllllllIllIllllIIlllII;
    }

    public void texture(Shape lllllllllllllllllIlllIllIIllIIlI, Image lllllllllllllllllIlllIllIIllIlIl, boolean lllllllllllllllllIlllIllIIllIlII) {
        Graphics lllllllllllllllllIlllIllIIllIIll;
        if (lllllllllllllllllIlllIllIIllIlII) {
            lllllllllllllllllIlllIllIIllIIll.texture(lllllllllllllllllIlllIllIIllIIlI, lllllllllllllllllIlllIllIIllIlIl, 1.0f, 1.0f, true);
        } else {
            lllllllllllllllllIlllIllIIllIIll.texture(lllllllllllllllllIlllIllIIllIIlI, lllllllllllllllllIlllIllIIllIlIl, 0.01f, 0.01f, false);
        }
    }

    public void fill(Shape lllllllllllllllllIlllIllIlIlIIll) {
        Graphics lllllllllllllllllIlllIllIlIlIlII;
        lllllllllllllllllIlllIllIlIlIlII.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIllIlIlIlII.currentColor.bind();
        ShapeRenderer.fill(lllllllllllllllllIlllIllIlIlIIll);
        lllllllllllllllllIlllIllIlIlIlII.postdraw();
    }

    protected void disable() {
    }

    public void drawImage(Image lllllllllllllllllIllIllllllIlIll, float lllllllllllllllllIllIllllllIIllI, float lllllllllllllllllIllIllllllIlIIl) {
        Graphics lllllllllllllllllIllIllllllIlIII;
        lllllllllllllllllIllIllllllIlIII.drawImage(lllllllllllllllllIllIllllllIlIll, lllllllllllllllllIllIllllllIIllI, lllllllllllllllllIllIllllllIlIIl, Color.white);
    }

    public void texture(Shape lllllllllllllllllIlllIllIIlllllI, Image lllllllllllllllllIlllIllIlIIIIIl, ShapeFill lllllllllllllllllIlllIllIIllllII) {
        Graphics lllllllllllllllllIlllIllIlIIIIll;
        lllllllllllllllllIlllIllIlIIIIll.texture(lllllllllllllllllIlllIllIIlllllI, lllllllllllllllllIlllIllIlIIIIIl, 0.01f, 0.01f, lllllllllllllllllIlllIllIIllllII);
    }

    public void resetLineWidth() {
        Graphics lllllllllllllllllIlllIIIIIllIIIl;
        lllllllllllllllllIlllIIIIIllIIIl.predraw();
        Renderer.getLineStripRenderer().setWidth(1.0f);
        GL.glLineWidth(1.0f);
        GL.glPointSize(1.0f);
        lllllllllllllllllIlllIIIIIllIIIl.postdraw();
    }

    public void texture(Shape lllllllllllllllllIlllIllIIIllllI, Image lllllllllllllllllIlllIllIIIlIIIl, float lllllllllllllllllIlllIllIIIllIIl, float lllllllllllllllllIlllIllIIIllIII) {
        Graphics lllllllllllllllllIlllIllIIIlIlIl;
        lllllllllllllllllIlllIllIIIlIlIl.texture(lllllllllllllllllIlllIllIIIllllI, lllllllllllllllllIlllIllIIIlIIIl, lllllllllllllllllIlllIllIIIllIIl, lllllllllllllllllIlllIllIIIllIII, false);
    }

    public void setBackground(Color lllllllllllllllllIllllIIIIIllllI) {
        Graphics lllllllllllllllllIllllIIIIIlllIl;
        lllllllllllllllllIllllIIIIIlllIl.predraw();
        GL.glClearColor(lllllllllllllllllIllllIIIIIllllI.r, lllllllllllllllllIllllIIIIIllllI.g, lllllllllllllllllIllllIIIIIllllI.b, lllllllllllllllllIllllIIIIIllllI.a);
        lllllllllllllllllIllllIIIIIlllIl.postdraw();
    }

    public void setDrawMode(int lllllllllllllllllIllllIIIIllIllI) {
        Graphics lllllllllllllllllIllllIIIIllIlIl;
        lllllllllllllllllIllllIIIIllIlIl.predraw();
        lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode = lllllllllllllllllIllllIIIIllIllI;
        if (lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode == MODE_NORMAL) {
            GL.glEnable(3042);
            GL.glColorMask(true, true, true, true);
            GL.glBlendFunc(770, 771);
        }
        if (lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode == MODE_ALPHA_MAP) {
            GL.glDisable(3042);
            GL.glColorMask(false, false, false, true);
        }
        if (lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode == MODE_ALPHA_BLEND) {
            GL.glEnable(3042);
            GL.glColorMask(true, true, true, false);
            GL.glBlendFunc(772, 773);
        }
        if (lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode == MODE_COLOR_MULTIPLY) {
            GL.glEnable(3042);
            GL.glColorMask(true, true, true, true);
            GL.glBlendFunc(769, 768);
        }
        if (lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode == MODE_ADD) {
            GL.glEnable(3042);
            GL.glColorMask(true, true, true, true);
            GL.glBlendFunc(1, 1);
        }
        if (lllllllllllllllllIllllIIIIllIlIl.currentDrawingMode == MODE_SCREEN) {
            GL.glEnable(3042);
            GL.glColorMask(true, true, true, true);
            GL.glBlendFunc(1, 769);
        }
        lllllllllllllllllIllllIIIIllIlIl.postdraw();
    }

    public void destroy() {
    }

    public void clearClip() {
        Graphics lllllllllllllllllIlllIlIIllllllI;
        lllllllllllllllllIlllIlIIllllllI.clip = null;
        lllllllllllllllllIlllIlIIllllllI.predraw();
        GL.glDisable(3089);
        lllllllllllllllllIlllIlIIllllllI.postdraw();
    }

    public void copyArea(Image lllllllllllllllllIllIllllIlIlIII, int lllllllllllllllllIllIllllIlIIlll, int lllllllllllllllllIllIllllIlIIllI) {
        Graphics lllllllllllllllllIllIllllIlIlIIl;
        int lllllllllllllllllIllIllllIlIIlIl = lllllllllllllllllIllIllllIlIlIII.getTexture().hasAlpha() ? 6408 : 6407;
        lllllllllllllllllIllIllllIlIlIII.bind();
        GL.glCopyTexImage2D(3553, 0, lllllllllllllllllIllIllllIlIIlIl, lllllllllllllllllIllIllllIlIIlll, lllllllllllllllllIllIllllIlIlIIl.screenHeight - (lllllllllllllllllIllIllllIlIIllI + lllllllllllllllllIllIllllIlIlIII.getHeight()), lllllllllllllllllIllIllllIlIlIII.getTexture().getTextureWidth(), lllllllllllllllllIllIllllIlIlIII.getTexture().getTextureHeight(), 0);
        lllllllllllllllllIllIllllIlIlIII.ensureInverted();
    }

    public void getArea(int lllllllllllllllllIllIllllIIIIlIl, int lllllllllllllllllIllIllllIIIlIlI, int lllllllllllllllllIllIllllIIIIIll, int lllllllllllllllllIllIllllIIIlIII, ByteBuffer lllllllllllllllllIllIllllIIIIIIl) {
        Graphics lllllllllllllllllIllIllllIIIllII;
        if (lllllllllllllllllIllIllllIIIIIIl.capacity() < lllllllllllllllllIllIllllIIIIIll * lllllllllllllllllIllIllllIIIlIII * 4) {
            throw new IllegalArgumentException("Byte buffer provided to get area is not big enough");
        }
        lllllllllllllllllIllIllllIIIllII.predraw();
        GL.glReadPixels(lllllllllllllllllIllIllllIIIIlIl, lllllllllllllllllIllIllllIIIllII.screenHeight - lllllllllllllllllIllIllllIIIlIlI - lllllllllllllllllIllIllllIIIlIII, lllllllllllllllllIllIllllIIIIIll, lllllllllllllllllIllIllllIIIlIII, 6408, 5121, lllllllllllllllllIllIllllIIIIIIl);
        lllllllllllllllllIllIllllIIIllII.postdraw();
    }

    public void fillRect(float lllllllllllllllllIlllIIllllIIlII, float lllllllllllllllllIlllIIllllIIIlI, float lllllllllllllllllIlllIIllllIIIII, float lllllllllllllllllIlllIIlllllIIll, Image lllllllllllllllllIlllIIlllIlllII, float lllllllllllllllllIlllIIllllIllll, float lllllllllllllllllIlllIIllllIllIl) {
        Graphics lllllllllllllllllIlllIIllllIIllI;
        int lllllllllllllllllIlllIIllllIlIll = (int)Math.ceil(lllllllllllllllllIlllIIllllIIIII / (float)lllllllllllllllllIlllIIlllIlllII.getWidth()) + 2;
        int lllllllllllllllllIlllIIllllIlIlI = (int)Math.ceil(lllllllllllllllllIlllIIlllllIIll / (float)lllllllllllllllllIlllIIlllIlllII.getHeight()) + 2;
        Rectangle lllllllllllllllllIlllIIllllIlIII = lllllllllllllllllIlllIIllllIIllI.getWorldClip();
        lllllllllllllllllIlllIIllllIIllI.setWorldClip(lllllllllllllllllIlllIIllllIIlII, lllllllllllllllllIlllIIllllIIIlI, lllllllllllllllllIlllIIllllIIIII, lllllllllllllllllIlllIIlllllIIll);
        lllllllllllllllllIlllIIllllIIllI.predraw();
        for (int lllllllllllllllllIlllIIllllllIlI = 0; lllllllllllllllllIlllIIllllllIlI < lllllllllllllllllIlllIIllllIlIll; ++lllllllllllllllllIlllIIllllllIlI) {
            for (int lllllllllllllllllIlllIIllllllIll = 0; lllllllllllllllllIlllIIllllllIll < lllllllllllllllllIlllIIllllIlIlI; ++lllllllllllllllllIlllIIllllllIll) {
                lllllllllllllllllIlllIIlllIlllII.draw((float)(lllllllllllllllllIlllIIllllllIlI * lllllllllllllllllIlllIIlllIlllII.getWidth()) + lllllllllllllllllIlllIIllllIIlII - lllllllllllllllllIlllIIllllIllll, (float)(lllllllllllllllllIlllIIllllllIll * lllllllllllllllllIlllIIlllIlllII.getHeight()) + lllllllllllllllllIlllIIllllIIIlI - lllllllllllllllllIlllIIllllIllIl);
            }
        }
        lllllllllllllllllIlllIIllllIIllI.postdraw();
        lllllllllllllllllIlllIIllllIIllI.setWorldClip(lllllllllllllllllIlllIIllllIlIII);
    }

    public Font getFont() {
        Graphics lllllllllllllllllIllllIIIIlIIIlI;
        return lllllllllllllllllIllllIIIIlIIIlI.font;
    }

    public void setClip(Rectangle lllllllllllllllllIlllIlIIIlIIllI) {
        Graphics lllllllllllllllllIlllIlIIIlIIlIl;
        if (lllllllllllllllllIlllIlIIIlIIllI == null) {
            lllllllllllllllllIlllIlIIIlIIlIl.clearClip();
            return;
        }
        lllllllllllllllllIlllIlIIIlIIlIl.setClip((int)lllllllllllllllllIlllIlIIIlIIllI.getX(), (int)lllllllllllllllllIlllIlIIIlIIllI.getY(), (int)lllllllllllllllllIlllIlIIIlIIllI.getWidth(), (int)lllllllllllllllllIlllIlIIIlIIllI.getHeight());
    }

    public void setLineWidth(float lllllllllllllllllIlllIIIIIllIllI) {
        Graphics lllllllllllllllllIlllIIIIIllIlll;
        lllllllllllllllllIlllIIIIIllIlll.predraw();
        lllllllllllllllllIlllIIIIIllIlll.lineWidth = lllllllllllllllllIlllIIIIIllIllI;
        LSR.setWidth(lllllllllllllllllIlllIIIIIllIllI);
        GL.glPointSize(lllllllllllllllllIlllIIIIIllIllI);
        lllllllllllllllllIlllIIIIIllIlll.postdraw();
    }

    public void fillRoundRect(float lllllllllllllllllIlllIIIIlIIllII, float lllllllllllllllllIlllIIIIlIIIIlI, float lllllllllllllllllIlllIIIIlIIIIIl, float lllllllllllllllllIlllIIIIlIIlIIl, int lllllllllllllllllIlllIIIIIllllll, int lllllllllllllllllIlllIIIIlIIIlll) {
        Graphics lllllllllllllllllIlllIIIIlIIllIl;
        if (lllllllllllllllllIlllIIIIIllllll < 0) {
            throw new IllegalArgumentException("corner radius must be > 0");
        }
        if (lllllllllllllllllIlllIIIIIllllll == 0) {
            lllllllllllllllllIlllIIIIlIIllIl.fillRect(lllllllllllllllllIlllIIIIlIIllII, lllllllllllllllllIlllIIIIlIIIIlI, lllllllllllllllllIlllIIIIlIIIIIl, lllllllllllllllllIlllIIIIlIIlIIl);
            return;
        }
        int lllllllllllllllllIlllIIIIlIIIllI = (int)Math.min(lllllllllllllllllIlllIIIIlIIIIIl, lllllllllllllllllIlllIIIIlIIlIIl) / 2;
        if (lllllllllllllllllIlllIIIIIllllll > lllllllllllllllllIlllIIIIlIIIllI) {
            lllllllllllllllllIlllIIIIIllllll = lllllllllllllllllIlllIIIIlIIIllI;
        }
        float lllllllllllllllllIlllIIIIlIIIlIl = lllllllllllllllllIlllIIIIIllllll * 2;
        lllllllllllllllllIlllIIIIlIIllIl.fillRect(lllllllllllllllllIlllIIIIlIIllII + (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIIIlI, lllllllllllllllllIlllIIIIlIIIIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIIllllll);
        lllllllllllllllllIlllIIIIlIIllIl.fillRect(lllllllllllllllllIlllIIIIlIIllII, lllllllllllllllllIlllIIIIlIIIIlI + (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIlIIl - lllllllllllllllllIlllIIIIlIIIlIl);
        lllllllllllllllllIlllIIIIlIIllIl.fillRect(lllllllllllllllllIlllIIIIlIIllII + lllllllllllllllllIlllIIIIlIIIIIl - (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIIIlI + (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIlIIl - lllllllllllllllllIlllIIIIlIIIlIl);
        lllllllllllllllllIlllIIIIlIIllIl.fillRect(lllllllllllllllllIlllIIIIlIIllII + (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIIIlI + lllllllllllllllllIlllIIIIlIIlIIl - (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIIIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIIllllll);
        lllllllllllllllllIlllIIIIlIIllIl.fillRect(lllllllllllllllllIlllIIIIlIIllII + (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIIIlI + (float)lllllllllllllllllIlllIIIIIllllll, lllllllllllllllllIlllIIIIlIIIIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIlIIl - lllllllllllllllllIlllIIIIlIIIlIl);
        lllllllllllllllllIlllIIIIlIIllIl.fillArc(lllllllllllllllllIlllIIIIlIIllII + lllllllllllllllllIlllIIIIlIIIIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIIlI + lllllllllllllllllIlllIIIIlIIlIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlll, 0.0f, 90.0f);
        lllllllllllllllllIlllIIIIlIIllIl.fillArc(lllllllllllllllllIlllIIIIlIIllII, lllllllllllllllllIlllIIIIlIIIIlI + lllllllllllllllllIlllIIIIlIIlIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlll, 90.0f, 180.0f);
        lllllllllllllllllIlllIIIIlIIllIl.fillArc(lllllllllllllllllIlllIIIIlIIllII + lllllllllllllllllIlllIIIIlIIIIIl - lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIIlI, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlll, 270.0f, 360.0f);
        lllllllllllllllllIlllIIIIlIIllIl.fillArc(lllllllllllllllllIlllIIIIlIIllII, lllllllllllllllllIlllIIIIlIIIIlI, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlIl, lllllllllllllllllIlllIIIIlIIIlll, 180.0f, 270.0f);
    }

    public void drawOval(float lllllllllllllllllIlllIIllIlIllIl, float lllllllllllllllllIlllIIllIllIIIl, float lllllllllllllllllIlllIIllIlIlIll, float lllllllllllllllllIlllIIllIlIllll) {
        Graphics lllllllllllllllllIlllIIllIllIIll;
        lllllllllllllllllIlllIIllIllIIll.drawOval(lllllllllllllllllIlllIIllIlIllIl, lllllllllllllllllIlllIIllIllIIIl, lllllllllllllllllIlllIIllIlIlIll, lllllllllllllllllIlllIIllIlIllll, 50);
    }

    public void texture(Shape lllllllllllllllllIlllIlIlllIllII, Image lllllllllllllllllIlllIlIlllIlIll, float lllllllllllllllllIlllIlIllIllllI, float lllllllllllllllllIlllIlIlllIIlll, boolean lllllllllllllllllIlllIlIlllIIllI) {
        Graphics lllllllllllllllllIlllIlIlllIlllI;
        lllllllllllllllllIlllIlIlllIlllI.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIlIlllIlllI.currentColor.bind();
        if (lllllllllllllllllIlllIlIlllIIllI) {
            ShapeRenderer.textureFit(lllllllllllllllllIlllIlIlllIllII, lllllllllllllllllIlllIlIlllIlIll, lllllllllllllllllIlllIlIllIllllI, lllllllllllllllllIlllIlIlllIIlll);
        } else {
            ShapeRenderer.texture(lllllllllllllllllIlllIlIlllIllII, lllllllllllllllllIlllIlIlllIlIll, lllllllllllllllllIlllIlIllIllllI, lllllllllllllllllIlllIlIlllIIlll);
        }
        lllllllllllllllllIlllIlIlllIlllI.postdraw();
    }

    private void checkPush() {
        Graphics lllllllllllllllllIllllIIIIIIllIl;
        if (!lllllllllllllllllIllllIIIIIIllIl.pushed) {
            lllllllllllllllllIllllIIIIIIllIl.predraw();
            GL.glPushMatrix();
            lllllllllllllllllIllllIIIIIIllIl.pushed = true;
            lllllllllllllllllIllllIIIIIIllIl.postdraw();
        }
    }

    public void drawArc(float lllllllllllllllllIlllIIllIIIlIII, float lllllllllllllllllIlllIIllIIIlllI, float lllllllllllllllllIlllIIllIIIIllI, float lllllllllllllllllIlllIIllIIIllII, float lllllllllllllllllIlllIIllIIIlIll, float lllllllllllllllllIlllIIllIIIlIlI) {
        Graphics lllllllllllllllllIlllIIllIIIlIIl;
        lllllllllllllllllIlllIIllIIIlIIl.drawArc(lllllllllllllllllIlllIIllIIIlIII, lllllllllllllllllIlllIIllIIIlllI, lllllllllllllllllIlllIIllIIIIllI, lllllllllllllllllIlllIIllIIIllII, 50, lllllllllllllllllIlllIIllIIIlIll, lllllllllllllllllIlllIIllIIIlIlI);
    }

    public void drawAnimation(Animation lllllllllllllllllIllIlllllllIlII, float lllllllllllllllllIllIlllllllIIll, float lllllllllllllllllIllIlllllllIlll, Color lllllllllllllllllIllIlllllllIllI) {
        Graphics lllllllllllllllllIllIlllllllIlIl;
        lllllllllllllllllIllIlllllllIlIl.predraw();
        lllllllllllllllllIllIlllllllIlII.draw(lllllllllllllllllIllIlllllllIIll, lllllllllllllllllIllIlllllllIlll, lllllllllllllllllIllIlllllllIllI);
        lllllllllllllllllIllIlllllllIlIl.currentColor.bind();
        lllllllllllllllllIllIlllllllIlIl.postdraw();
    }

    public void flush() {
        Graphics lllllllllllllllllIllllIIIIlIIlll;
        if (currentGraphics == lllllllllllllllllIllllIIIIlIIlll) {
            currentGraphics.disable();
            currentGraphics = null;
        }
    }

    static {
        DEFAULT_SEGMENTS = 50;
        GL = Renderer.get();
        LSR = Renderer.getLineStripRenderer();
        MODE_NORMAL = 1;
        MODE_ALPHA_MAP = 2;
        MODE_ALPHA_BLEND = 3;
        MODE_COLOR_MULTIPLY = 4;
        MODE_ADD = 5;
        MODE_SCREEN = 6;
        currentGraphics = null;
    }

    public void scale(float lllllllllllllllllIllllIIIIIIIlIl, float lllllllllllllllllIllllIIIIIIIlII) {
        Graphics lllllllllllllllllIllllIIIIIIIllI;
        lllllllllllllllllIllllIIIIIIIllI.sx *= lllllllllllllllllIllllIIIIIIIlIl;
        lllllllllllllllllIllllIIIIIIIllI.sy *= lllllllllllllllllIllllIIIIIIIlII;
        lllllllllllllllllIllllIIIIIIIllI.checkPush();
        lllllllllllllllllIllllIIIIIIIllI.predraw();
        GL.glScalef(lllllllllllllllllIllllIIIIIIIlIl, lllllllllllllllllIllllIIIIIIIlII, 1.0f);
        lllllllllllllllllIllllIIIIIIIllI.postdraw();
    }

    public void setClip(int lllllllllllllllllIlllIlIIIlllIIl, int lllllllllllllllllIlllIlIIIllIlll, int lllllllllllllllllIlllIlIIIllIlIl, int lllllllllllllllllIlllIlIIIlIlIlI) {
        Graphics lllllllllllllllllIlllIlIIIllIIII;
        lllllllllllllllllIlllIlIIIllIIII.predraw();
        if (lllllllllllllllllIlllIlIIIllIIII.clip == null) {
            GL.glEnable(3089);
            lllllllllllllllllIlllIlIIIllIIII.clip = new Rectangle(lllllllllllllllllIlllIlIIIlllIIl, lllllllllllllllllIlllIlIIIllIlll, lllllllllllllllllIlllIlIIIllIlIl, lllllllllllllllllIlllIlIIIlIlIlI);
        } else {
            lllllllllllllllllIlllIlIIIllIIII.clip.setBounds(lllllllllllllllllIlllIlIIIlllIIl, lllllllllllllllllIlllIlIIIllIlll, lllllllllllllllllIlllIlIIIllIlIl, lllllllllllllllllIlllIlIIIlIlIlI);
        }
        GL.glScissor(lllllllllllllllllIlllIlIIIlllIIl, lllllllllllllllllIlllIlIIIllIIII.screenHeight - lllllllllllllllllIlllIlIIIllIlll - lllllllllllllllllIlllIlIIIlIlIlI, lllllllllllllllllIlllIlIIIllIlIl, lllllllllllllllllIlllIlIIIlIlIlI);
        lllllllllllllllllIlllIlIIIllIIII.postdraw();
    }

    public void fillRoundRect(float lllllllllllllllllIlllIIIIllIIIIl, float lllllllllllllllllIlllIIIIlIllIlI, float lllllllllllllllllIlllIIIIlIlllll, float lllllllllllllllllIlllIIIIlIllIII, int lllllllllllllllllIlllIIIIlIlllIl) {
        Graphics lllllllllllllllllIlllIIIIllIIIlI;
        lllllllllllllllllIlllIIIIllIIIlI.fillRoundRect(lllllllllllllllllIlllIIIIllIIIIl, lllllllllllllllllIlllIIIIlIllIlI, lllllllllllllllllIlllIIIIlIlllll, lllllllllllllllllIlllIIIIlIllIII, lllllllllllllllllIlllIIIIlIlllIl, 50);
    }

    public void clearAlphaMap() {
        Graphics lllllllllllllllllIllllIIIIlIllll;
        lllllllllllllllllIllllIIIIlIllll.pushTransform();
        GL.glLoadIdentity();
        int lllllllllllllllllIllllIIIIllIIII = lllllllllllllllllIllllIIIIlIllll.currentDrawingMode;
        lllllllllllllllllIllllIIIIlIllll.setDrawMode(MODE_ALPHA_MAP);
        lllllllllllllllllIllllIIIIlIllll.setColor(new Color(0, 0, 0, 0));
        lllllllllllllllllIllllIIIIlIllll.fillRect(0.0f, 0.0f, lllllllllllllllllIllllIIIIlIllll.screenWidth, lllllllllllllllllIllllIIIIlIllll.screenHeight);
        lllllllllllllllllIllllIIIIlIllll.setColor(lllllllllllllllllIllllIIIIlIllll.currentColor);
        lllllllllllllllllIllllIIIIlIllll.setDrawMode(lllllllllllllllllIllllIIIIllIIII);
        lllllllllllllllllIllllIIIIlIllll.popTransform();
    }

    public Rectangle getClip() {
        Graphics lllllllllllllllllIlllIlIIIlIIIlI;
        return lllllllllllllllllIlllIlIIIlIIIlI.clip;
    }

    public void resetTransform() {
        Graphics lllllllllllllllllIllllIIIIIlIIII;
        lllllllllllllllllIllllIIIIIlIIII.sx = 1.0f;
        lllllllllllllllllIllllIIIIIlIIII.sy = 1.0f;
        if (lllllllllllllllllIllllIIIIIlIIII.pushed) {
            lllllllllllllllllIllllIIIIIlIIII.predraw();
            GL.glPopMatrix();
            lllllllllllllllllIllllIIIIIlIIII.pushed = false;
            lllllllllllllllllIllllIIIIIlIIII.postdraw();
        }
    }

    public void draw(Shape lllllllllllllllllIlllIllIlIllIIl) {
        Graphics lllllllllllllllllIlllIllIlIllIlI;
        lllllllllllllllllIlllIllIlIllIlI.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIllIlIllIlI.currentColor.bind();
        ShapeRenderer.draw(lllllllllllllllllIlllIllIlIllIIl);
        lllllllllllllllllIlllIllIlIllIlI.postdraw();
    }

    public void drawImage(Image lllllllllllllllllIllIllllIllIlIl, float lllllllllllllllllIllIllllIllIlII, float lllllllllllllllllIllIllllIlllIll, float lllllllllllllllllIllIllllIllIIlI, float lllllllllllllllllIllIllllIllIIIl, float lllllllllllllllllIllIllllIllIIII, float lllllllllllllllllIllIllllIlIllll) {
        Graphics lllllllllllllllllIllIllllIlllllI;
        lllllllllllllllllIllIllllIlllllI.drawImage(lllllllllllllllllIllIllllIllIlIl, lllllllllllllllllIllIllllIllIlII, lllllllllllllllllIllIllllIlllIll, lllllllllllllllllIllIllllIllIlII + (float)lllllllllllllllllIllIllllIllIlIl.getWidth(), lllllllllllllllllIllIllllIlllIll + (float)lllllllllllllllllIllIllllIllIlIl.getHeight(), lllllllllllllllllIllIllllIllIIlI, lllllllllllllllllIllIllllIllIIIl, lllllllllllllllllIllIllllIllIIII, lllllllllllllllllIllIllllIlIllll);
    }

    public void drawImage(Image lllllllllllllllllIllIlllllIIllll, float lllllllllllllllllIllIlllllIIlllI, float lllllllllllllllllIllIlllllIIllIl, float lllllllllllllllllIllIlllllIIllII, float lllllllllllllllllIllIlllllIIlIll, float lllllllllllllllllIllIlllllIIlIlI, float lllllllllllllllllIllIlllllIIlIIl, float lllllllllllllllllIllIlllllIlIIlI, float lllllllllllllllllIllIlllllIIIlll) {
        Graphics lllllllllllllllllIllIlllllIlIIII;
        lllllllllllllllllIllIlllllIlIIII.predraw();
        lllllllllllllllllIllIlllllIIllll.draw(lllllllllllllllllIllIlllllIIlllI, lllllllllllllllllIllIlllllIIllIl, lllllllllllllllllIllIlllllIIllII, lllllllllllllllllIllIlllllIIlIll, lllllllllllllllllIllIlllllIIlIlI, lllllllllllllllllIllIlllllIIlIIl, lllllllllllllllllIllIlllllIlIIlI, lllllllllllllllllIllIlllllIIIlll);
        lllllllllllllllllIllIlllllIlIIII.currentColor.bind();
        lllllllllllllllllIllIlllllIlIIII.postdraw();
    }

    public void drawImage(Image lllllllllllllllllIllIlllIlIIllII, float lllllllllllllllllIllIlllIlIIlIll, float lllllllllllllllllIllIlllIlIlIIll, float lllllllllllllllllIllIlllIlIlIIlI, float lllllllllllllllllIllIlllIlIIlIII, float lllllllllllllllllIllIlllIlIIIlll, float lllllllllllllllllIllIlllIlIIIllI, Color lllllllllllllllllIllIlllIlIIlllI) {
        Graphics lllllllllllllllllIllIlllIlIlIllI;
        lllllllllllllllllIllIlllIlIlIllI.drawImage(lllllllllllllllllIllIlllIlIIllII, lllllllllllllllllIllIlllIlIIlIll, lllllllllllllllllIllIlllIlIlIIll, lllllllllllllllllIllIlllIlIIlIll + (float)lllllllllllllllllIllIlllIlIIllII.getWidth(), lllllllllllllllllIllIlllIlIlIIll + (float)lllllllllllllllllIllIlllIlIIllII.getHeight(), lllllllllllllllllIllIlllIlIlIIlI, lllllllllllllllllIllIlllIlIIlIII, lllllllllllllllllIllIlllIlIIIlll, lllllllllllllllllIllIlllIlIIIllI, lllllllllllllllllIllIlllIlIIlllI);
    }

    public void fillRect(float lllllllllllllllllIlllIIllIllllII, float lllllllllllllllllIlllIIllIlllIll, float lllllllllllllllllIlllIIllIllllll, float lllllllllllllllllIlllIIllIlllllI) {
        Graphics lllllllllllllllllIlllIIlllIIIIlI;
        lllllllllllllllllIlllIIlllIIIIlI.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIIlllIIIIlI.currentColor.bind();
        GL.glBegin(7);
        GL.glVertex2f(lllllllllllllllllIlllIIllIllllII, lllllllllllllllllIlllIIllIlllIll);
        GL.glVertex2f(lllllllllllllllllIlllIIllIllllII + lllllllllllllllllIlllIIllIllllll, lllllllllllllllllIlllIIllIlllIll);
        GL.glVertex2f(lllllllllllllllllIlllIIllIllllII + lllllllllllllllllIlllIIllIllllll, lllllllllllllllllIlllIIllIlllIll + lllllllllllllllllIlllIIllIlllllI);
        GL.glVertex2f(lllllllllllllllllIlllIIllIllllII, lllllllllllllllllIlllIIllIlllIll + lllllllllllllllllIlllIIllIlllllI);
        GL.glEnd();
        lllllllllllllllllIlllIIlllIIIIlI.postdraw();
    }

    public void setWorldClip(float lllllllllllllllllIlllIlIIlllIIlI, float lllllllllllllllllIlllIlIIlllIIIl, float lllllllllllllllllIlllIlIIlllIIII, float lllllllllllllllllIlllIlIIllIllll) {
        Graphics lllllllllllllllllIlllIlIIllIlllI;
        lllllllllllllllllIlllIlIIllIlllI.predraw();
        lllllllllllllllllIlllIlIIllIlllI.worldClipRecord = new Rectangle(lllllllllllllllllIlllIlIIlllIIlI, lllllllllllllllllIlllIlIIlllIIIl, lllllllllllllllllIlllIlIIlllIIII, lllllllllllllllllIlllIlIIllIllll);
        GL.glEnable(12288);
        lllllllllllllllllIlllIlIIllIlllI.worldClip.put(1.0).put(0.0).put(0.0).put(-lllllllllllllllllIlllIlIIlllIIlI).flip();
        GL.glClipPlane(12288, lllllllllllllllllIlllIlIIllIlllI.worldClip);
        GL.glEnable(12289);
        lllllllllllllllllIlllIlIIllIlllI.worldClip.put(-1.0).put(0.0).put(0.0).put(lllllllllllllllllIlllIlIIlllIIlI + lllllllllllllllllIlllIlIIlllIIII).flip();
        GL.glClipPlane(12289, lllllllllllllllllIlllIlIIllIlllI.worldClip);
        GL.glEnable(12290);
        lllllllllllllllllIlllIlIIllIlllI.worldClip.put(0.0).put(1.0).put(0.0).put(-lllllllllllllllllIlllIlIIlllIIIl).flip();
        GL.glClipPlane(12290, lllllllllllllllllIlllIlIIllIlllI.worldClip);
        GL.glEnable(12291);
        lllllllllllllllllIlllIlIIllIlllI.worldClip.put(0.0).put(-1.0).put(0.0).put(lllllllllllllllllIlllIlIIlllIIIl + lllllllllllllllllIlllIlIIllIllll).flip();
        GL.glClipPlane(12291, lllllllllllllllllIlllIlIIllIlllI.worldClip);
        lllllllllllllllllIlllIlIIllIlllI.postdraw();
    }

    public void drawRect(float lllllllllllllllllIlllIlIlIIIIllI, float lllllllllllllllllIlllIlIlIIIlIll, float lllllllllllllllllIlllIlIlIIIlIlI, float lllllllllllllllllIlllIlIlIIIIIll) {
        Graphics lllllllllllllllllIlllIlIlIIIllIl;
        float lllllllllllllllllIlllIlIlIIIlIII = lllllllllllllllllIlllIlIlIIIllIl.getLineWidth();
        lllllllllllllllllIlllIlIlIIIllIl.drawLine(lllllllllllllllllIlllIlIlIIIIllI, lllllllllllllllllIlllIlIlIIIlIll, lllllllllllllllllIlllIlIlIIIIllI + lllllllllllllllllIlllIlIlIIIlIlI, lllllllllllllllllIlllIlIlIIIlIll);
        lllllllllllllllllIlllIlIlIIIllIl.drawLine(lllllllllllllllllIlllIlIlIIIIllI + lllllllllllllllllIlllIlIlIIIlIlI, lllllllllllllllllIlllIlIlIIIlIll, lllllllllllllllllIlllIlIlIIIIllI + lllllllllllllllllIlllIlIlIIIlIlI, lllllllllllllllllIlllIlIlIIIlIll + lllllllllllllllllIlllIlIlIIIIIll);
        lllllllllllllllllIlllIlIlIIIllIl.drawLine(lllllllllllllllllIlllIlIlIIIIllI + lllllllllllllllllIlllIlIlIIIlIlI, lllllllllllllllllIlllIlIlIIIlIll + lllllllllllllllllIlllIlIlIIIIIll, lllllllllllllllllIlllIlIlIIIIllI, lllllllllllllllllIlllIlIlIIIlIll + lllllllllllllllllIlllIlIlIIIIIll);
        lllllllllllllllllIlllIlIlIIIllIl.drawLine(lllllllllllllllllIlllIlIlIIIIllI, lllllllllllllllllIlllIlIlIIIlIll + lllllllllllllllllIlllIlIlIIIIIll, lllllllllllllllllIlllIlIlIIIIllI, lllllllllllllllllIlllIlIlIIIlIll);
    }

    public Color getColor() {
        Graphics lllllllllllllllllIlllIlllIIllIll;
        return new Color(lllllllllllllllllIlllIlllIIllIll.currentColor);
    }

    public void popTransform() {
        Graphics lllllllllllllllllIllIllIllllllll;
        if (lllllllllllllllllIllIllIllllllll.stackIndex == 0) {
            throw new RuntimeException("Attempt to pop a transform that hasn't be pushed");
        }
        lllllllllllllllllIllIllIllllllll.predraw();
        --lllllllllllllllllIllIllIllllllll.stackIndex;
        FloatBuffer lllllllllllllllllIllIllIlllllllI = (FloatBuffer)lllllllllllllllllIllIllIllllllll.stack.get(lllllllllllllllllIllIllIllllllll.stackIndex);
        GL.glLoadMatrix(lllllllllllllllllIllIllIlllllllI);
        lllllllllllllllllIllIllIllllllll.sx = lllllllllllllllllIllIllIlllllllI.get(16);
        lllllllllllllllllIllIllIllllllll.sy = lllllllllllllllllIllIllIlllllllI.get(17);
        lllllllllllllllllIllIllIllllllll.postdraw();
    }

    private void predraw() {
        Graphics lllllllllllllllllIllllIIIIlIllII;
        Graphics.setCurrent(lllllllllllllllllIllllIIIIlIllII);
    }

    public void setAntiAlias(boolean lllllllllllllllllIlllIIIIIlIlIlI) {
        Graphics lllllllllllllllllIlllIIIIIlIlIll;
        lllllllllllllllllIlllIIIIIlIlIll.predraw();
        lllllllllllllllllIlllIIIIIlIlIll.antialias = lllllllllllllllllIlllIIIIIlIlIlI;
        LSR.setAntiAlias(lllllllllllllllllIlllIIIIIlIlIlI);
        if (lllllllllllllllllIlllIIIIIlIlIlI) {
            GL.glEnable(2881);
        } else {
            GL.glDisable(2881);
        }
        lllllllllllllllllIlllIIIIIlIlIll.postdraw();
    }

    public Color getBackground() {
        Graphics lllllllllllllllllIllllIIIIIllIIl;
        lllllllllllllllllIllllIIIIIllIIl.predraw();
        FloatBuffer lllllllllllllllllIllllIIIIIllIII = BufferUtils.createFloatBuffer((int)16);
        GL.glGetFloat(3106, lllllllllllllllllIllllIIIIIllIII);
        lllllllllllllllllIllllIIIIIllIIl.postdraw();
        return new Color(lllllllllllllllllIllllIIIIIllIII);
    }

    public void clearWorldClip() {
        Graphics lllllllllllllllllIlllIlIIllIIIlI;
        lllllllllllllllllIlllIlIIllIIIlI.predraw();
        lllllllllllllllllIlllIlIIllIIIlI.worldClipRecord = null;
        GL.glDisable(12288);
        GL.glDisable(12289);
        GL.glDisable(12290);
        GL.glDisable(12291);
        lllllllllllllllllIlllIlIIllIIIlI.postdraw();
    }

    public void drawLine(float lllllllllllllllllIlllIllIlllIlII, float lllllllllllllllllIlllIllIllllIIl, float lllllllllllllllllIlllIllIlllIIlI, float lllllllllllllllllIlllIllIlllIlll) {
        Graphics lllllllllllllllllIlllIllIllllIll;
        float lllllllllllllllllIlllIllIlllIllI = lllllllllllllllllIlllIllIllllIll.lineWidth - 1.0f;
        if (LSR.applyGLLineFixes()) {
            if (lllllllllllllllllIlllIllIlllIlII == lllllllllllllllllIlllIllIlllIIlI) {
                if (lllllllllllllllllIlllIllIllllIIl > lllllllllllllllllIlllIllIlllIlll) {
                    float lllllllllllllllllIlllIllIlllllll = lllllllllllllllllIlllIllIlllIlll;
                    lllllllllllllllllIlllIllIlllIlll = lllllllllllllllllIlllIllIllllIIl;
                    lllllllllllllllllIlllIllIllllIIl = lllllllllllllllllIlllIllIlllllll;
                }
                float lllllllllllllllllIlllIllIllllllI = 1.0f / lllllllllllllllllIlllIllIllllIll.sy;
                lllllllllllllllllIlllIllIllllIll.fillRect(lllllllllllllllllIlllIllIlllIlII - (lllllllllllllllllIlllIllIlllIllI /= lllllllllllllllllIlllIllIllllIll.sy) / 2.0f, lllllllllllllllllIlllIllIllllIIl - lllllllllllllllllIlllIllIlllIllI / 2.0f, lllllllllllllllllIlllIllIlllIllI + lllllllllllllllllIlllIllIllllllI, lllllllllllllllllIlllIllIlllIlll - lllllllllllllllllIlllIllIllllIIl + lllllllllllllllllIlllIllIlllIllI + lllllllllllllllllIlllIllIllllllI);
                return;
            }
            if (lllllllllllllllllIlllIllIllllIIl == lllllllllllllllllIlllIllIlllIlll) {
                if (lllllllllllllllllIlllIllIlllIlII > lllllllllllllllllIlllIllIlllIIlI) {
                    float lllllllllllllllllIlllIllIlllllIl = lllllllllllllllllIlllIllIlllIIlI;
                    lllllllllllllllllIlllIllIlllIIlI = lllllllllllllllllIlllIllIlllIlII;
                    lllllllllllllllllIlllIllIlllIlII = lllllllllllllllllIlllIllIlllllIl;
                }
                float lllllllllllllllllIlllIllIlllllII = 1.0f / lllllllllllllllllIlllIllIllllIll.sx;
                lllllllllllllllllIlllIllIllllIll.fillRect(lllllllllllllllllIlllIllIlllIlII - (lllllllllllllllllIlllIllIlllIllI /= lllllllllllllllllIlllIllIllllIll.sx) / 2.0f, lllllllllllllllllIlllIllIllllIIl - lllllllllllllllllIlllIllIlllIllI / 2.0f, lllllllllllllllllIlllIllIlllIIlI - lllllllllllllllllIlllIllIlllIlII + lllllllllllllllllIlllIllIlllIllI + lllllllllllllllllIlllIllIlllllII, lllllllllllllllllIlllIllIlllIllI + lllllllllllllllllIlllIllIlllllII);
                return;
            }
        }
        lllllllllllllllllIlllIllIllllIll.predraw();
        lllllllllllllllllIlllIllIllllIll.currentColor.bind();
        TextureImpl.bindNone();
        LSR.start();
        LSR.vertex(lllllllllllllllllIlllIllIlllIlII, lllllllllllllllllIlllIllIllllIIl);
        LSR.vertex(lllllllllllllllllIlllIllIlllIIlI, lllllllllllllllllIlllIllIlllIlll);
        LSR.end();
        lllllllllllllllllIlllIllIllllIll.postdraw();
    }

    void setDimensions(int lllllllllllllllllIllllIIIlllIIII, int lllllllllllllllllIllllIIIllIllll) {
        lllllllllllllllllIllllIIIlllIIIl.screenWidth = lllllllllllllllllIllllIIIlllIIII;
        lllllllllllllllllIllllIIIlllIIIl.screenHeight = lllllllllllllllllIllllIIIllIllll;
    }

    public void rotate(float lllllllllllllllllIlllIllllllIlII, float lllllllllllllllllIlllIllllllIIll, float lllllllllllllllllIlllIllllllIIIl) {
        Graphics lllllllllllllllllIlllIllllllIllI;
        lllllllllllllllllIlllIllllllIllI.checkPush();
        lllllllllllllllllIlllIllllllIllI.predraw();
        lllllllllllllllllIlllIllllllIllI.translate(lllllllllllllllllIlllIllllllIlII, lllllllllllllllllIlllIllllllIIll);
        GL.glRotatef(lllllllllllllllllIlllIllllllIIIl, 0.0f, 0.0f, 1.0f);
        lllllllllllllllllIlllIllllllIllI.translate(-lllllllllllllllllIlllIllllllIlII, -lllllllllllllllllIlllIllllllIIll);
        lllllllllllllllllIlllIllllllIllI.postdraw();
    }

    public void fill(Shape lllllllllllllllllIlllIllIllIIIIl, ShapeFill lllllllllllllllllIlllIllIlIlllIl) {
        Graphics lllllllllllllllllIlllIllIllIIIlI;
        lllllllllllllllllIlllIllIllIIIlI.predraw();
        TextureImpl.bindNone();
        ShapeRenderer.fill(lllllllllllllllllIlllIllIllIIIIl, lllllllllllllllllIlllIllIlIlllIl);
        lllllllllllllllllIlllIllIllIIIlI.currentColor.bind();
        lllllllllllllllllIlllIllIllIIIlI.postdraw();
    }

    public void fillArc(float lllllllllllllllllIlllIIlIIIIllll, float lllllllllllllllllIlllIIlIIIIlllI, float lllllllllllllllllIlllIIlIIIIllIl, float lllllllllllllllllIlllIIlIIIIIlIl, float lllllllllllllllllIlllIIlIIIIIlII, float lllllllllllllllllIlllIIlIIIIIIll) {
        Graphics lllllllllllllllllIlllIIlIIIlIIII;
        lllllllllllllllllIlllIIlIIIlIIII.fillArc(lllllllllllllllllIlllIIlIIIIllll, lllllllllllllllllIlllIIlIIIIlllI, lllllllllllllllllIlllIIlIIIIllIl, lllllllllllllllllIlllIIlIIIIIlIl, 50, lllllllllllllllllIlllIIlIIIIIlII, lllllllllllllllllIlllIIlIIIIIIll);
    }

    public void setColor(Color lllllllllllllllllIlllIlllIlIIlII) {
        Graphics lllllllllllllllllIlllIlllIlIIlIl;
        if (lllllllllllllllllIlllIlllIlIIlII == null) {
            return;
        }
        lllllllllllllllllIlllIlllIlIIlIl.currentColor = new Color(lllllllllllllllllIlllIlllIlIIlII);
        lllllllllllllllllIlllIlllIlIIlIl.predraw();
        lllllllllllllllllIlllIlllIlIIlIl.currentColor.bind();
        lllllllllllllllllIlllIlllIlIIlIl.postdraw();
    }

    public void drawRoundRect(float lllllllllllllllllIlllIIIlIlIIIll, float lllllllllllllllllIlllIIIlIIlllII, float lllllllllllllllllIlllIIIlIIllIll, float lllllllllllllllllIlllIIIlIIllIlI, int lllllllllllllllllIlllIIIlIIlllll) {
        Graphics lllllllllllllllllIlllIIIlIlIIlII;
        lllllllllllllllllIlllIIIlIlIIlII.drawRoundRect(lllllllllllllllllIlllIIIlIlIIIll, lllllllllllllllllIlllIIIlIIlllII, lllllllllllllllllIlllIIIlIIllIll, lllllllllllllllllIlllIIIlIIllIlI, lllllllllllllllllIlllIIIlIIlllll, 50);
    }

    public void clear() {
        Graphics lllllllllllllllllIllllIIIIIlIlII;
        lllllllllllllllllIllllIIIIIlIlII.predraw();
        GL.glClear(16384);
        lllllllllllllllllIllllIIIIIlIlII.postdraw();
    }

    public void resetFont() {
        lllllllllllllllllIlllIlllIlllIII.font = DEFAULT_FONT;
    }

    public void drawArc(float lllllllllllllllllIlllIIlIlIIllll, float lllllllllllllllllIlllIIlIlIIlllI, float lllllllllllllllllIlllIIlIlIllIII, float lllllllllllllllllIlllIIlIlIIllII, int lllllllllllllllllIlllIIlIlIIlIll, float lllllllllllllllllIlllIIlIlIIlIlI, float lllllllllllllllllIlllIIlIlIIlIIl) {
        Graphics lllllllllllllllllIlllIIlIlIlIIII;
        lllllllllllllllllIlllIIlIlIlIIII.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIIlIlIlIIII.currentColor.bind();
        while (lllllllllllllllllIlllIIlIlIIlIIl < lllllllllllllllllIlllIIlIlIIlIlI) {
            lllllllllllllllllIlllIIlIlIIlIIl += 360.0f;
        }
        float lllllllllllllllllIlllIIlIlIlIIll = lllllllllllllllllIlllIIlIlIIllll + lllllllllllllllllIlllIIlIlIllIII / 2.0f;
        float lllllllllllllllllIlllIIlIlIlIIlI = lllllllllllllllllIlllIIlIlIIlllI + lllllllllllllllllIlllIIlIlIIllII / 2.0f;
        LSR.start();
        int lllllllllllllllllIlllIIlIlIlIIIl = 360 / lllllllllllllllllIlllIIlIlIIlIll;
        for (int lllllllllllllllllIlllIIlIlIlllII = (int)lllllllllllllllllIlllIIlIlIIlIlI; lllllllllllllllllIlllIIlIlIlllII < (int)(lllllllllllllllllIlllIIlIlIIlIIl + (float)lllllllllllllllllIlllIIlIlIlIIIl); lllllllllllllllllIlllIIlIlIlllII += lllllllllllllllllIlllIIlIlIlIIIl) {
            float lllllllllllllllllIlllIIlIlIlllll = lllllllllllllllllIlllIIlIlIlllII;
            if (lllllllllllllllllIlllIIlIlIlllll > lllllllllllllllllIlllIIlIlIIlIIl) {
                lllllllllllllllllIlllIIlIlIlllll = lllllllllllllllllIlllIIlIlIIlIIl;
            }
            float lllllllllllllllllIlllIIlIlIllllI = (float)((double)lllllllllllllllllIlllIIlIlIlIIll + FastTrig.cos(Math.toRadians(lllllllllllllllllIlllIIlIlIlllll)) * (double)lllllllllllllllllIlllIIlIlIllIII / 2.0);
            float lllllllllllllllllIlllIIlIlIlllIl = (float)((double)lllllllllllllllllIlllIIlIlIlIIlI + FastTrig.sin(Math.toRadians(lllllllllllllllllIlllIIlIlIlllll)) * (double)lllllllllllllllllIlllIIlIlIIllII / 2.0);
            LSR.vertex(lllllllllllllllllIlllIIlIlIllllI, lllllllllllllllllIlllIIlIlIlllIl);
        }
        LSR.end();
        lllllllllllllllllIlllIIlIlIlIIII.postdraw();
    }

    public void setFont(Font lllllllllllllllllIlllIllllIIIIlI) {
        lllllllllllllllllIlllIllllIIIlII.font = lllllllllllllllllIlllIllllIIIIlI;
    }

    public void drawOval(float lllllllllllllllllIlllIIllIIlllII, float lllllllllllllllllIlllIIllIlIIIIl, float lllllllllllllllllIlllIIllIIllIlI, float lllllllllllllllllIlllIIllIIllIIl, int lllllllllllllllllIlllIIllIIllllI) {
        Graphics lllllllllllllllllIlllIIllIlIIIll;
        lllllllllllllllllIlllIIllIlIIIll.drawArc(lllllllllllllllllIlllIIllIIlllII, lllllllllllllllllIlllIIllIlIIIIl, lllllllllllllllllIlllIIllIIllIlI, lllllllllllllllllIlllIIllIIllIIl, lllllllllllllllllIlllIIllIIllllI, 0.0f, 360.0f);
    }

    public void drawString(String lllllllllllllllllIlllIIIIIlIIIIl, float lllllllllllllllllIlllIIIIIlIIIII, float lllllllllllllllllIlllIIIIIIllIll) {
        Graphics lllllllllllllllllIlllIIIIIlIIIlI;
        lllllllllllllllllIlllIIIIIlIIIlI.predraw();
        lllllllllllllllllIlllIIIIIlIIIlI.font.drawString(lllllllllllllllllIlllIIIIIlIIIII, lllllllllllllllllIlllIIIIIIllIll, lllllllllllllllllIlllIIIIIlIIIIl, lllllllllllllllllIlllIIIIIlIIIlI.currentColor);
        lllllllllllllllllIlllIIIIIlIIIlI.postdraw();
    }

    public void drawImage(Image lllllllllllllllllIlllIIIIIIlIlII, float lllllllllllllllllIlllIIIIIIIlllI, float lllllllllllllllllIlllIIIIIIIllIl, Color lllllllllllllllllIlllIIIIIIlIIIl) {
        Graphics lllllllllllllllllIlllIIIIIIlIlIl;
        lllllllllllllllllIlllIIIIIIlIlIl.predraw();
        lllllllllllllllllIlllIIIIIIlIlII.draw(lllllllllllllllllIlllIIIIIIIlllI, lllllllllllllllllIlllIIIIIIIllIl, lllllllllllllllllIlllIIIIIIlIIIl);
        lllllllllllllllllIlllIIIIIIlIlIl.currentColor.bind();
        lllllllllllllllllIlllIIIIIIlIlIl.postdraw();
    }

    public void texture(Shape lllllllllllllllllIlllIlIlIlllIlI, Image lllllllllllllllllIlllIlIlIlIlIII, float lllllllllllllllllIlllIlIlIlIIllI, float lllllllllllllllllIlllIlIlIllIIIl, ShapeFill lllllllllllllllllIlllIlIlIlIIIIl) {
        Graphics lllllllllllllllllIlllIlIlIllllII;
        lllllllllllllllllIlllIlIlIllllII.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIlIlIllllII.currentColor.bind();
        ShapeRenderer.texture(lllllllllllllllllIlllIlIlIlllIlI, lllllllllllllllllIlllIlIlIlIlIII, lllllllllllllllllIlllIlIlIlIIllI, lllllllllllllllllIlllIlIlIllIIIl, lllllllllllllllllIlllIlIlIlIIIIl);
        lllllllllllllllllIlllIlIlIllllII.postdraw();
    }

    public void drawAnimation(Animation lllllllllllllllllIlllIIIIIIIIllI, float lllllllllllllllllIlllIIIIIIIIIIl, float lllllllllllllllllIlllIIIIIIIIIII) {
        Graphics lllllllllllllllllIlllIIIIIIIIIll;
        lllllllllllllllllIlllIIIIIIIIIll.drawAnimation(lllllllllllllllllIlllIIIIIIIIllI, lllllllllllllllllIlllIIIIIIIIIIl, lllllllllllllllllIlllIIIIIIIIIII, Color.white);
    }

    public void texture(Shape lllllllllllllllllIlllIllIlIIllII, Image lllllllllllllllllIlllIllIlIIlIll) {
        Graphics lllllllllllllllllIlllIllIlIIllIl;
        lllllllllllllllllIlllIllIlIIllIl.texture(lllllllllllllllllIlllIllIlIIllII, lllllllllllllllllIlllIllIlIIlIll, 0.01f, 0.01f, false);
    }

    protected void enable() {
    }

    public void fillOval(float lllllllllllllllllIlllIIlIIllIllI, float lllllllllllllllllIlllIIlIIllIlII, float lllllllllllllllllIlllIIlIIllIIll, float lllllllllllllllllIlllIIlIIlllIII) {
        Graphics lllllllllllllllllIlllIIlIIllllII;
        lllllllllllllllllIlllIIlIIllllII.fillOval(lllllllllllllllllIlllIIlIIllIllI, lllllllllllllllllIlllIIlIIllIlII, lllllllllllllllllIlllIIlIIllIIll, lllllllllllllllllIlllIIlIIlllIII, 50);
    }

    public void drawImage(Image lllllllllllllllllIllIlllIllIlIIl, float lllllllllllllllllIllIlllIlllIIll, float lllllllllllllllllIllIlllIllIIlll, float lllllllllllllllllIllIlllIllIIllI, float lllllllllllllllllIllIlllIllIIlIl, float lllllllllllllllllIllIlllIllIllll, float lllllllllllllllllIllIlllIllIlllI, float lllllllllllllllllIllIlllIllIllIl, float lllllllllllllllllIllIlllIllIIIIl, Color lllllllllllllllllIllIlllIllIIIII) {
        Graphics lllllllllllllllllIllIlllIlllIlIl;
        lllllllllllllllllIllIlllIlllIlIl.predraw();
        lllllllllllllllllIllIlllIllIlIIl.draw(lllllllllllllllllIllIlllIlllIIll, lllllllllllllllllIllIlllIllIIlll, lllllllllllllllllIllIlllIllIIllI, lllllllllllllllllIllIlllIllIIlIl, lllllllllllllllllIllIlllIllIllll, lllllllllllllllllIllIlllIllIlllI, lllllllllllllllllIllIlllIllIllIl, lllllllllllllllllIllIlllIllIIIIl, lllllllllllllllllIllIlllIllIIIII);
        lllllllllllllllllIllIlllIlllIlIl.currentColor.bind();
        lllllllllllllllllIllIlllIlllIlIl.postdraw();
    }

    public void drawRoundRect(float lllllllllllllllllIlllIIIIlllIIII, float lllllllllllllllllIlllIIIIllllIII, float lllllllllllllllllIlllIIIIlllIlll, float lllllllllllllllllIlllIIIIlllIllI, int lllllllllllllllllIlllIIIIllIllII, int lllllllllllllllllIlllIIIIllIlIll) {
        Graphics lllllllllllllllllIlllIIIIllllIlI;
        if (lllllllllllllllllIlllIIIIllIllII < 0) {
            throw new IllegalArgumentException("corner radius must be > 0");
        }
        if (lllllllllllllllllIlllIIIIllIllII == 0) {
            lllllllllllllllllIlllIIIIllllIlI.drawRect(lllllllllllllllllIlllIIIIlllIIII, lllllllllllllllllIlllIIIIllllIII, lllllllllllllllllIlllIIIIlllIlll, lllllllllllllllllIlllIIIIlllIllI);
            return;
        }
        int lllllllllllllllllIlllIIIIlllIIll = (int)Math.min(lllllllllllllllllIlllIIIIlllIlll, lllllllllllllllllIlllIIIIlllIllI) / 2;
        if (lllllllllllllllllIlllIIIIllIllII > lllllllllllllllllIlllIIIIlllIIll) {
            lllllllllllllllllIlllIIIIllIllII = lllllllllllllllllIlllIIIIlllIIll;
        }
        lllllllllllllllllIlllIIIIllllIlI.drawLine(lllllllllllllllllIlllIIIIlllIIII + (float)lllllllllllllllllIlllIIIIllIllII, lllllllllllllllllIlllIIIIllllIII, lllllllllllllllllIlllIIIIlllIIII + lllllllllllllllllIlllIIIIlllIlll - (float)lllllllllllllllllIlllIIIIllIllII, lllllllllllllllllIlllIIIIllllIII);
        lllllllllllllllllIlllIIIIllllIlI.drawLine(lllllllllllllllllIlllIIIIlllIIII, lllllllllllllllllIlllIIIIllllIII + (float)lllllllllllllllllIlllIIIIllIllII, lllllllllllllllllIlllIIIIlllIIII, lllllllllllllllllIlllIIIIllllIII + lllllllllllllllllIlllIIIIlllIllI - (float)lllllllllllllllllIlllIIIIllIllII);
        lllllllllllllllllIlllIIIIllllIlI.drawLine(lllllllllllllllllIlllIIIIlllIIII + lllllllllllllllllIlllIIIIlllIlll, lllllllllllllllllIlllIIIIllllIII + (float)lllllllllllllllllIlllIIIIllIllII, lllllllllllllllllIlllIIIIlllIIII + lllllllllllllllllIlllIIIIlllIlll, lllllllllllllllllIlllIIIIllllIII + lllllllllllllllllIlllIIIIlllIllI - (float)lllllllllllllllllIlllIIIIllIllII);
        lllllllllllllllllIlllIIIIllllIlI.drawLine(lllllllllllllllllIlllIIIIlllIIII + (float)lllllllllllllllllIlllIIIIllIllII, lllllllllllllllllIlllIIIIllllIII + lllllllllllllllllIlllIIIIlllIllI, lllllllllllllllllIlllIIIIlllIIII + lllllllllllllllllIlllIIIIlllIlll - (float)lllllllllllllllllIlllIIIIllIllII, lllllllllllllllllIlllIIIIllllIII + lllllllllllllllllIlllIIIIlllIllI);
        float lllllllllllllllllIlllIIIIlllIIlI = lllllllllllllllllIlllIIIIllIllII * 2;
        lllllllllllllllllIlllIIIIllllIlI.drawArc(lllllllllllllllllIlllIIIIlllIIII + lllllllllllllllllIlllIIIIlllIlll - lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIllllIII + lllllllllllllllllIlllIIIIlllIllI - lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIllIlIll, 0.0f, 90.0f);
        lllllllllllllllllIlllIIIIllllIlI.drawArc(lllllllllllllllllIlllIIIIlllIIII, lllllllllllllllllIlllIIIIllllIII + lllllllllllllllllIlllIIIIlllIllI - lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIllIlIll, 90.0f, 180.0f);
        lllllllllllllllllIlllIIIIllllIlI.drawArc(lllllllllllllllllIlllIIIIlllIIII + lllllllllllllllllIlllIIIIlllIlll - lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIllllIII, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIllIlIll, 270.0f, 360.0f);
        lllllllllllllllllIlllIIIIllllIlI.drawArc(lllllllllllllllllIlllIIIIlllIIII, lllllllllllllllllIlllIIIIllllIII, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIlllIIlI, lllllllllllllllllIlllIIIIllIlIll, 180.0f, 270.0f);
    }

    public float getLineWidth() {
        Graphics lllllllllllllllllIlllIIIIIllIlII;
        return lllllllllllllllllIlllIIIIIllIlII.lineWidth;
    }

    public boolean isAntiAlias() {
        Graphics lllllllllllllllllIlllIIIIIlIIlll;
        return lllllllllllllllllIlllIIIIIlIIlll.antialias;
    }

    public void pushTransform() {
        FloatBuffer lllllllllllllllllIllIlllIIIIIlII;
        Graphics lllllllllllllllllIllIlllIIIIIIll;
        lllllllllllllllllIllIlllIIIIIIll.predraw();
        if (lllllllllllllllllIllIlllIIIIIIll.stackIndex >= lllllllllllllllllIllIlllIIIIIIll.stack.size()) {
            FloatBuffer lllllllllllllllllIllIlllIIIIIllI = BufferUtils.createFloatBuffer((int)18);
            lllllllllllllllllIllIlllIIIIIIll.stack.add(lllllllllllllllllIllIlllIIIIIllI);
        } else {
            lllllllllllllllllIllIlllIIIIIlII = (FloatBuffer)lllllllllllllllllIllIlllIIIIIIll.stack.get(lllllllllllllllllIllIlllIIIIIIll.stackIndex);
        }
        GL.glGetFloat(2982, lllllllllllllllllIllIlllIIIIIlII);
        lllllllllllllllllIllIlllIIIIIlII.put(16, lllllllllllllllllIllIlllIIIIIIll.sx);
        lllllllllllllllllIllIlllIIIIIlII.put(17, lllllllllllllllllIllIlllIIIIIIll.sy);
        ++lllllllllllllllllIllIlllIIIIIIll.stackIndex;
        lllllllllllllllllIllIlllIIIIIIll.postdraw();
    }

    public void translate(float lllllllllllllllllIlllIllllIlIIll, float lllllllllllllllllIlllIllllIlIlll) {
        Graphics lllllllllllllllllIlllIllllIlIlIl;
        lllllllllllllllllIlllIllllIlIlIl.checkPush();
        lllllllllllllllllIlllIllllIlIlIl.predraw();
        GL.glTranslatef(lllllllllllllllllIlllIllllIlIIll, lllllllllllllllllIlllIllllIlIlll, 0.0f);
        lllllllllllllllllIlllIllllIlIlIl.postdraw();
    }

    public void draw(Shape lllllllllllllllllIlllIllIllIIlll, ShapeFill lllllllllllllllllIlllIllIllIlIIl) {
        Graphics lllllllllllllllllIlllIllIllIlIll;
        lllllllllllllllllIlllIllIllIlIll.predraw();
        TextureImpl.bindNone();
        ShapeRenderer.draw(lllllllllllllllllIlllIllIllIIlll, lllllllllllllllllIlllIllIllIlIIl);
        lllllllllllllllllIlllIllIllIlIll.currentColor.bind();
        lllllllllllllllllIlllIllIllIlIll.postdraw();
    }

    public Graphics(int lllllllllllllllllIllllIIIlllllll, int lllllllllllllllllIllllIIIlllIlll) {
        Graphics lllllllllllllllllIllllIIlIIIIIII;
        lllllllllllllllllIllllIIlIIIIIII.sx = 1.0f;
        lllllllllllllllllIllllIIlIIIIIII.sy = 1.0f;
        lllllllllllllllllIllllIIlIIIIIII.currentColor = Color.white;
        lllllllllllllllllIllllIIlIIIIIII.worldClip = BufferUtils.createDoubleBuffer((int)4);
        lllllllllllllllllIllllIIlIIIIIII.readBuffer = BufferUtils.createByteBuffer((int)4);
        lllllllllllllllllIllllIIlIIIIIII.currentDrawingMode = MODE_NORMAL;
        lllllllllllllllllIllllIIlIIIIIII.lineWidth = 1.0f;
        lllllllllllllllllIllllIIlIIIIIII.stack = new ArrayList();
        if (DEFAULT_FONT == null) {
            AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    try {
                        DEFAULT_FONT = new AngelCodeFont("org/newdawn/slick/data/defaultfont.fnt", "org/newdawn/slick/data/defaultfont.png");
                    }
                    catch (SlickException llllllllllllllllllIlllIlIlIIlIIl) {
                        Log.error(llllllllllllllllllIlllIlIlIIlIIl);
                    }
                    return null;
                }
                {
                    1 llllllllllllllllllIlllIlIlIIllII;
                }
            });
        }
        lllllllllllllllllIllllIIlIIIIIII.font = DEFAULT_FONT;
        lllllllllllllllllIllllIIlIIIIIII.screenWidth = lllllllllllllllllIllllIIIlllllll;
        lllllllllllllllllIllllIIlIIIIIII.screenHeight = lllllllllllllllllIllllIIIlllIlll;
    }

    public Rectangle getWorldClip() {
        Graphics lllllllllllllllllIlllIlIIlIlIIll;
        return lllllllllllllllllIlllIlIIlIlIIll.worldClipRecord;
    }

    public void fillOval(float lllllllllllllllllIlllIIlIIIlllII, float lllllllllllllllllIlllIIlIIlIIlII, float lllllllllllllllllIlllIIlIIIllIlI, float lllllllllllllllllIlllIIlIIIllIIl, int lllllllllllllllllIlllIIlIIlIIIII) {
        Graphics lllllllllllllllllIlllIIlIIIllllI;
        lllllllllllllllllIlllIIlIIIllllI.fillArc(lllllllllllllllllIlllIIlIIIlllII, lllllllllllllllllIlllIIlIIlIIlII, lllllllllllllllllIlllIIlIIIllIlI, lllllllllllllllllIlllIIlIIIllIIl, lllllllllllllllllIlllIIlIIlIIIII, 0.0f, 360.0f);
    }

    public Graphics() {
        Graphics lllllllllllllllllIllllIIlIIlIlIl;
        lllllllllllllllllIllllIIlIIlIlIl.sx = 1.0f;
        lllllllllllllllllIllllIIlIIlIlIl.sy = 1.0f;
        lllllllllllllllllIllllIIlIIlIlIl.currentColor = Color.white;
        lllllllllllllllllIllllIIlIIlIlIl.worldClip = BufferUtils.createDoubleBuffer((int)4);
        lllllllllllllllllIllllIIlIIlIlIl.readBuffer = BufferUtils.createByteBuffer((int)4);
        lllllllllllllllllIllllIIlIIlIlIl.currentDrawingMode = MODE_NORMAL;
        lllllllllllllllllIllllIIlIIlIlIl.lineWidth = 1.0f;
        lllllllllllllllllIllllIIlIIlIlIl.stack = new ArrayList();
    }

    public void setWorldClip(Rectangle lllllllllllllllllIlllIlIIlIlIlll) {
        Graphics lllllllllllllllllIlllIlIIlIlIllI;
        if (lllllllllllllllllIlllIlIIlIlIlll == null) {
            lllllllllllllllllIlllIlIIlIlIllI.clearWorldClip();
        } else {
            lllllllllllllllllIlllIlIIlIlIllI.setWorldClip(lllllllllllllllllIlllIlIIlIlIlll.getX(), lllllllllllllllllIlllIlIIlIlIlll.getY(), lllllllllllllllllIlllIlIIlIlIlll.getWidth(), lllllllllllllllllIlllIlIIlIlIlll.getHeight());
        }
    }

    public void drawGradientLine(float lllllllllllllllllIllIlllIIIlIlIl, float lllllllllllllllllIllIlllIIIIllIl, Color lllllllllllllllllIllIlllIIIIllII, float lllllllllllllllllIllIlllIIIlIIlI, float lllllllllllllllllIllIlllIIIlIIIl, Color lllllllllllllllllIllIlllIIIlIIII) {
        Graphics lllllllllllllllllIllIlllIIIlIllI;
        lllllllllllllllllIllIlllIIIlIllI.predraw();
        TextureImpl.bindNone();
        GL.glBegin(1);
        lllllllllllllllllIllIlllIIIIllII.bind();
        GL.glVertex2f(lllllllllllllllllIllIlllIIIlIlIl, lllllllllllllllllIllIlllIIIIllIl);
        lllllllllllllllllIllIlllIIIlIIII.bind();
        GL.glVertex2f(lllllllllllllllllIllIlllIIIlIIlI, lllllllllllllllllIllIlllIIIlIIIl);
        GL.glEnd();
        lllllllllllllllllIllIlllIIIlIllI.postdraw();
    }

    private void postdraw() {
    }

    public void fillArc(float lllllllllllllllllIlllIIIllIIIlll, float lllllllllllllllllIlllIIIlIlllIll, float lllllllllllllllllIlllIIIlIlllIIl, float lllllllllllllllllIlllIIIlIllIlll, int lllllllllllllllllIlllIIIlIllIlIl, float lllllllllllllllllIlllIIIlIllIIll, float lllllllllllllllllIlllIIIlIllIIlI) {
        Graphics lllllllllllllllllIlllIIIllIIlIII;
        lllllllllllllllllIlllIIIllIIlIII.predraw();
        TextureImpl.bindNone();
        lllllllllllllllllIlllIIIllIIlIII.currentColor.bind();
        while (lllllllllllllllllIlllIIIlIllIIlI < lllllllllllllllllIlllIIIlIllIIll) {
            lllllllllllllllllIlllIIIlIllIIlI += 360.0f;
        }
        float lllllllllllllllllIlllIIIllIIIIII = lllllllllllllllllIlllIIIllIIIlll + lllllllllllllllllIlllIIIlIlllIIl / 2.0f;
        float lllllllllllllllllIlllIIIlIllllll = lllllllllllllllllIlllIIIlIlllIll + lllllllllllllllllIlllIIIlIllIlll / 2.0f;
        GL.glBegin(6);
        int lllllllllllllllllIlllIIIlIlllllI = 360 / lllllllllllllllllIlllIIIlIllIlIl;
        GL.glVertex2f(lllllllllllllllllIlllIIIllIIIIII, lllllllllllllllllIlllIIIlIllllll);
        for (int lllllllllllllllllIlllIIIllIIllIl = (int)lllllllllllllllllIlllIIIlIllIIll; lllllllllllllllllIlllIIIllIIllIl < (int)(lllllllllllllllllIlllIIIlIllIIlI + (float)lllllllllllllllllIlllIIIlIlllllI); lllllllllllllllllIlllIIIllIIllIl += lllllllllllllllllIlllIIIlIlllllI) {
            float lllllllllllllllllIlllIIIllIlIIIl = lllllllllllllllllIlllIIIllIIllIl;
            if (lllllllllllllllllIlllIIIllIlIIIl > lllllllllllllllllIlllIIIlIllIIlI) {
                lllllllllllllllllIlllIIIllIlIIIl = lllllllllllllllllIlllIIIlIllIIlI;
            }
            float lllllllllllllllllIlllIIIllIlIIII = (float)((double)lllllllllllllllllIlllIIIllIIIIII + FastTrig.cos(Math.toRadians(lllllllllllllllllIlllIIIllIlIIIl)) * (double)lllllllllllllllllIlllIIIlIlllIIl / 2.0);
            float lllllllllllllllllIlllIIIllIIlllI = (float)((double)lllllllllllllllllIlllIIIlIllllll + FastTrig.sin(Math.toRadians(lllllllllllllllllIlllIIIllIlIIIl)) * (double)lllllllllllllllllIlllIIIlIllIlll / 2.0);
            GL.glVertex2f(lllllllllllllllllIlllIIIllIlIIII, lllllllllllllllllIlllIIIllIIlllI);
        }
        GL.glEnd();
        if (lllllllllllllllllIlllIIIllIIlIII.antialias) {
            GL.glBegin(6);
            GL.glVertex2f(lllllllllllllllllIlllIIIllIIIIII, lllllllllllllllllIlllIIIlIllllll);
            if (lllllllllllllllllIlllIIIlIllIIlI != 360.0f) {
                lllllllllllllllllIlllIIIlIllIIlI -= 10.0f;
            }
            for (int lllllllllllllllllIlllIIIllIIlIIl = (int)lllllllllllllllllIlllIIIlIllIIll; lllllllllllllllllIlllIIIllIIlIIl < (int)(lllllllllllllllllIlllIIIlIllIIlI + (float)lllllllllllllllllIlllIIIlIlllllI); lllllllllllllllllIlllIIIllIIlIIl += lllllllllllllllllIlllIIIlIlllllI) {
                float lllllllllllllllllIlllIIIllIIllII = lllllllllllllllllIlllIIIllIIlIIl;
                if (lllllllllllllllllIlllIIIllIIllII > lllllllllllllllllIlllIIIlIllIIlI) {
                    lllllllllllllllllIlllIIIllIIllII = lllllllllllllllllIlllIIIlIllIIlI;
                }
                float lllllllllllllllllIlllIIIllIIlIll = (float)((double)lllllllllllllllllIlllIIIllIIIIII + FastTrig.cos(Math.toRadians(lllllllllllllllllIlllIIIllIIllII + 10.0f)) * (double)lllllllllllllllllIlllIIIlIlllIIl / 2.0);
                float lllllllllllllllllIlllIIIllIIlIlI = (float)((double)lllllllllllllllllIlllIIIlIllllll + FastTrig.sin(Math.toRadians(lllllllllllllllllIlllIIIllIIllII + 10.0f)) * (double)lllllllllllllllllIlllIIIlIllIlll / 2.0);
                GL.glVertex2f(lllllllllllllllllIlllIIIllIIlIll, lllllllllllllllllIlllIIIllIIlIlI);
            }
            GL.glEnd();
        }
        lllllllllllllllllIlllIIIllIIlIII.postdraw();
    }

    public Color getPixel(int lllllllllllllllllIllIllllIIlIlll, int lllllllllllllllllIllIllllIIlIIll) {
        Graphics lllllllllllllllllIllIllllIIllIII;
        lllllllllllllllllIllIllllIIllIII.predraw();
        GL.glReadPixels(lllllllllllllllllIllIllllIIlIlll, lllllllllllllllllIllIllllIIllIII.screenHeight - lllllllllllllllllIllIllllIIlIIll, 1, 1, 6408, 5121, lllllllllllllllllIllIllllIIllIII.readBuffer);
        lllllllllllllllllIllIllllIIllIII.postdraw();
        return new Color(lllllllllllllllllIllIllllIIllIII.translate(lllllllllllllllllIllIllllIIllIII.readBuffer.get(0)), lllllllllllllllllIllIllllIIllIII.translate(lllllllllllllllllIllIllllIIllIII.readBuffer.get(1)), lllllllllllllllllIllIllllIIllIII.translate(lllllllllllllllllIllIllllIIllIII.readBuffer.get(2)), lllllllllllllllllIllIllllIIllIII.translate(lllllllllllllllllIllIllllIIllIII.readBuffer.get(3)));
    }

    public void drawGradientLine(float lllllllllllllllllIllIlllIIllIllI, float lllllllllllllllllIllIlllIIlIlIII, float lllllllllllllllllIllIlllIIlIIlll, float lllllllllllllllllIllIlllIIllIIll, float lllllllllllllllllIllIlllIIlIIlIl, float lllllllllllllllllIllIlllIIllIIIl, float lllllllllllllllllIllIlllIIlIIIll, float lllllllllllllllllIllIlllIIlIllll, float lllllllllllllllllIllIlllIIlIIIIl, float lllllllllllllllllIllIlllIIlIIIII, float lllllllllllllllllIllIlllIIlIllII, float lllllllllllllllllIllIlllIIIllllI) {
        Graphics lllllllllllllllllIllIlllIIlIlIlI;
        lllllllllllllllllIllIlllIIlIlIlI.predraw();
        TextureImpl.bindNone();
        GL.glBegin(1);
        GL.glColor4f(lllllllllllllllllIllIlllIIlIIlll, lllllllllllllllllIllIlllIIllIIll, lllllllllllllllllIllIlllIIlIIlIl, lllllllllllllllllIllIlllIIllIIIl);
        GL.glVertex2f(lllllllllllllllllIllIlllIIllIllI, lllllllllllllllllIllIlllIIlIlIII);
        GL.glColor4f(lllllllllllllllllIllIlllIIlIIIIl, lllllllllllllllllIllIlllIIlIIIII, lllllllllllllllllIllIlllIIlIllII, lllllllllllllllllIllIlllIIIllllI);
        GL.glVertex2f(lllllllllllllllllIllIlllIIlIIIll, lllllllllllllllllIllIlllIIlIllll);
        GL.glEnd();
        lllllllllllllllllIllIlllIIlIlIlI.postdraw();
    }

    public static void setCurrent(Graphics lllllllllllllllllIllllIIlIlIllII) {
        if (currentGraphics != lllllllllllllllllIllllIIlIlIllII) {
            if (currentGraphics != null) {
                currentGraphics.disable();
            }
            currentGraphics = lllllllllllllllllIllllIIlIlIllII;
            currentGraphics.enable();
        }
    }
}

