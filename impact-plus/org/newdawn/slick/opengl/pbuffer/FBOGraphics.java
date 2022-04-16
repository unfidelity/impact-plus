/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.EXTFramebufferObject
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 */
package org.newdawn.slick.opengl.pbuffer;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.Log;

public class FBOGraphics
extends Graphics {
    private /* synthetic */ Image image;
    private /* synthetic */ boolean valid;
    private /* synthetic */ int FBO;

    @Override
    public void destroy() {
        FBOGraphics lllllllllllllllIlllIIllIllIIIIII;
        super.destroy();
        IntBuffer lllllllllllllllIlllIIllIlIllllll = BufferUtils.createIntBuffer((int)1);
        lllllllllllllllIlllIIllIlIllllll.put(lllllllllllllllIlllIIllIllIIIIII.FBO);
        lllllllllllllllIlllIIllIlIllllll.flip();
        EXTFramebufferObject.glDeleteFramebuffersEXT((IntBuffer)lllllllllllllllIlllIIllIlIllllll);
        lllllllllllllllIlllIIllIllIIIIII.valid = false;
    }

    @Override
    protected void enable() {
        FBOGraphics lllllllllllllllIlllIIllIllIIlIlI;
        if (!lllllllllllllllIlllIIllIllIIlIlI.valid) {
            throw new RuntimeException("Attempt to use a destroy()ed offscreen graphics context.");
        }
        SlickCallable.enterSafeBlock();
        GL11.glPushAttrib((int)1048575);
        GL11.glPushClientAttrib((int)-1);
        GL11.glMatrixMode((int)5889);
        GL11.glPushMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPushMatrix();
        lllllllllllllllIlllIIllIllIIlIlI.bind();
        lllllllllllllllIlllIIllIllIIlIlI.initGL();
    }

    private void completeCheck() throws SlickException {
        int lllllllllllllllIlllIIllIllIlllll = EXTFramebufferObject.glCheckFramebufferStatusEXT((int)36160);
        switch (lllllllllllllllIlllIIllIllIlllll) {
            case 36053: {
                break;
            }
            case 36054: {
                FBOGraphics lllllllllllllllIlllIIllIlllIIIII;
                throw new SlickException(String.valueOf(new StringBuilder().append("FrameBuffer: ").append(lllllllllllllllIlllIIllIlllIIIII.FBO).append(", has caused a GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT exception")));
            }
            case 36055: {
                FBOGraphics lllllllllllllllIlllIIllIlllIIIII;
                throw new SlickException(String.valueOf(new StringBuilder().append("FrameBuffer: ").append(lllllllllllllllIlllIIllIlllIIIII.FBO).append(", has caused a GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT exception")));
            }
            case 36057: {
                FBOGraphics lllllllllllllllIlllIIllIlllIIIII;
                throw new SlickException(String.valueOf(new StringBuilder().append("FrameBuffer: ").append(lllllllllllllllIlllIIllIlllIIIII.FBO).append(", has caused a GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT exception")));
            }
            case 36059: {
                FBOGraphics lllllllllllllllIlllIIllIlllIIIII;
                throw new SlickException(String.valueOf(new StringBuilder().append("FrameBuffer: ").append(lllllllllllllllIlllIIllIlllIIIII.FBO).append(", has caused a GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT exception")));
            }
            case 36058: {
                FBOGraphics lllllllllllllllIlllIIllIlllIIIII;
                throw new SlickException(String.valueOf(new StringBuilder().append("FrameBuffer: ").append(lllllllllllllllIlllIIllIlllIIIII.FBO).append(", has caused a GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT exception")));
            }
            case 36060: {
                FBOGraphics lllllllllllllllIlllIIllIlllIIIII;
                throw new SlickException(String.valueOf(new StringBuilder().append("FrameBuffer: ").append(lllllllllllllllIlllIIllIlllIIIII.FBO).append(", has caused a GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT exception")));
            }
            default: {
                throw new SlickException(String.valueOf(new StringBuilder().append("Unexpected reply from glCheckFramebufferStatusEXT: ").append(lllllllllllllllIlllIIllIllIlllll)));
            }
        }
    }

    protected void initGL() {
        FBOGraphics lllllllllllllllIlllIIllIllIIIllI;
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7425);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glClearDepth((double)1.0);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glViewport((int)0, (int)0, (int)lllllllllllllllIlllIIllIllIIIllI.screenWidth, (int)lllllllllllllllIlllIIllIllIIIllI.screenHeight);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        lllllllllllllllIlllIIllIllIIIllI.enterOrtho();
    }

    protected void enterOrtho() {
        FBOGraphics lllllllllllllllIlllIIllIllIIIIll;
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)lllllllllllllllIlllIIllIllIIIIll.screenWidth, (double)0.0, (double)lllllllllllllllIlllIIllIllIIIIll.screenHeight, (double)1.0, (double)-1.0);
        GL11.glMatrixMode((int)5888);
    }

    private void init() throws SlickException {
        IntBuffer lllllllllllllllIlllIIllIllIlIllI = BufferUtils.createIntBuffer((int)1);
        EXTFramebufferObject.glGenFramebuffersEXT((IntBuffer)lllllllllllllllIlllIIllIllIlIllI);
        lllllllllllllllIlllIIllIllIlIlIl.FBO = lllllllllllllllIlllIIllIllIlIllI.get();
        try {
            FBOGraphics lllllllllllllllIlllIIllIllIlIlIl;
            Texture lllllllllllllllIlllIIllIllIllIIl = InternalTextureLoader.get().createTexture(lllllllllllllllIlllIIllIllIlIlIl.image.getWidth(), lllllllllllllllIlllIIllIllIlIlIl.image.getHeight(), lllllllllllllllIlllIIllIllIlIlIl.image.getFilter());
            EXTFramebufferObject.glBindFramebufferEXT((int)36160, (int)lllllllllllllllIlllIIllIllIlIlIl.FBO);
            EXTFramebufferObject.glFramebufferTexture2DEXT((int)36160, (int)36064, (int)3553, (int)lllllllllllllllIlllIIllIllIllIIl.getTextureID(), (int)0);
            lllllllllllllllIlllIIllIllIlIlIl.completeCheck();
            lllllllllllllllIlllIIllIllIlIlIl.unbind();
            lllllllllllllllIlllIIllIllIlIlIl.clear();
            lllllllllllllllIlllIIllIllIlIlIl.flush();
            lllllllllllllllIlllIIllIllIlIlIl.drawImage(lllllllllllllllIlllIIllIllIlIlIl.image, 0.0f, 0.0f);
            lllllllllllllllIlllIIllIllIlIlIl.image.setTexture(lllllllllllllllIlllIIllIllIllIIl);
        }
        catch (Exception lllllllllllllllIlllIIllIllIllIII) {
            throw new SlickException("Failed to create new texture for FBO");
        }
    }

    private void bind() {
        FBOGraphics lllllllllllllllIlllIIllIllIlIIII;
        EXTFramebufferObject.glBindFramebufferEXT((int)36160, (int)lllllllllllllllIlllIIllIllIlIIII.FBO);
        GL11.glReadBuffer((int)36064);
    }

    @Override
    protected void disable() {
        FBOGraphics lllllllllllllllIlllIIllIllIIllII;
        GL.flush();
        lllllllllllllllIlllIIllIllIIllII.unbind();
        GL11.glPopClientAttrib();
        GL11.glPopAttrib();
        GL11.glMatrixMode((int)5888);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        SlickCallable.leaveSafeBlock();
    }

    @Override
    public void flush() {
        FBOGraphics lllllllllllllllIlllIIllIlIlllIlI;
        super.flush();
        lllllllllllllllIlllIIllIlIlllIlI.image.flushPixelData();
    }

    private void unbind() {
        EXTFramebufferObject.glBindFramebufferEXT((int)36160, (int)0);
        GL11.glReadBuffer((int)1029);
    }

    public FBOGraphics(Image lllllllllllllllIlllIIllIlllIIlll) throws SlickException {
        super(lllllllllllllllIlllIIllIlllIIlll.getTexture().getTextureWidth(), lllllllllllllllIlllIIllIlllIIlll.getTexture().getTextureHeight());
        FBOGraphics lllllllllllllllIlllIIllIlllIIlIl;
        lllllllllllllllIlllIIllIlllIIlIl.valid = true;
        lllllllllllllllIlllIIllIlllIIlIl.image = lllllllllllllllIlllIIllIlllIIlll;
        Log.debug(String.valueOf(new StringBuilder().append("Creating FBO ").append(lllllllllllllllIlllIIllIlllIIlll.getWidth()).append("x").append(lllllllllllllllIlllIIllIlllIIlll.getHeight())));
        boolean lllllllllllllllIlllIIllIlllIIllI = GLContext.getCapabilities().GL_EXT_framebuffer_object;
        if (!lllllllllllllllIlllIIllIlllIIllI) {
            throw new SlickException("Your OpenGL card does not support FBO and hence can't handle the dynamic images required for this application.");
        }
        lllllllllllllllIlllIIllIlllIIlIl.init();
    }
}

