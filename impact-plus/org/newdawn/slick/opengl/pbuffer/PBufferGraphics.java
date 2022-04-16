/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.Pbuffer
 *  org.lwjgl.opengl.PixelFormat
 *  org.lwjgl.opengl.RenderTexture
 */
package org.newdawn.slick.opengl.pbuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.RenderTexture;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.util.Log;

public class PBufferGraphics
extends Graphics {
    private /* synthetic */ Image image;
    private /* synthetic */ Pbuffer pbuffer;

    public PBufferGraphics(Image llllllllllllllllIIlIllIIIIllIIll) throws SlickException {
        super(llllllllllllllllIIlIllIIIIllIIll.getTexture().getTextureWidth(), llllllllllllllllIIlIllIIIIllIIll.getTexture().getTextureHeight());
        PBufferGraphics llllllllllllllllIIlIllIIIIllIlII;
        llllllllllllllllIIlIllIIIIllIlII.image = llllllllllllllllIIlIllIIIIllIIll;
        Log.debug(String.valueOf(new StringBuilder().append("Creating pbuffer(rtt) ").append(llllllllllllllllIIlIllIIIIllIIll.getWidth()).append("x").append(llllllllllllllllIIlIllIIIIllIIll.getHeight())));
        if ((Pbuffer.getCapabilities() & 1) == 0) {
            throw new SlickException("Your OpenGL card does not support PBuffers and hence can't handle the dynamic images required for this application.");
        }
        if ((Pbuffer.getCapabilities() & 2) == 0) {
            throw new SlickException("Your OpenGL card does not support Render-To-Texture and hence can't handle the dynamic images required for this application.");
        }
        llllllllllllllllIIlIllIIIIllIlII.init();
    }

    protected void initGL() {
        PBufferGraphics llllllllllllllllIIlIllIIIIIllIlI;
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7425);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glClearDepth((double)1.0);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glViewport((int)0, (int)0, (int)llllllllllllllllIIlIllIIIIIllIlI.screenWidth, (int)llllllllllllllllIIlIllIIIIIllIlI.screenHeight);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        llllllllllllllllIIlIllIIIIIllIlI.enterOrtho();
    }

    @Override
    protected void enable() {
        PBufferGraphics llllllllllllllllIIlIllIIIIIlllll;
        SlickCallable.enterSafeBlock();
        try {
            if (llllllllllllllllIIlIllIIIIIlllll.pbuffer.isBufferLost()) {
                llllllllllllllllIIlIllIIIIIlllll.pbuffer.destroy();
                llllllllllllllllIIlIllIIIIIlllll.init();
            }
            llllllllllllllllIIlIllIIIIIlllll.pbuffer.makeCurrent();
        }
        catch (Exception llllllllllllllllIIlIllIIIIlIIIII) {
            Log.error("Failed to recreate the PBuffer");
            throw new RuntimeException(llllllllllllllllIIlIllIIIIlIIIII);
        }
        GL.glBindTexture(3553, llllllllllllllllIIlIllIIIIIlllll.image.getTexture().getTextureID());
        llllllllllllllllIIlIllIIIIIlllll.pbuffer.releaseTexImage(8323);
        TextureImpl.unbind();
        llllllllllllllllIIlIllIIIIIlllll.initGL();
    }

    protected void enterOrtho() {
        PBufferGraphics llllllllllllllllIIlIllIIIIIllIII;
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)llllllllllllllllIIlIllIIIIIllIII.screenWidth, (double)0.0, (double)llllllllllllllllIIlIllIIIIIllIII.screenHeight, (double)1.0, (double)-1.0);
        GL11.glMatrixMode((int)5888);
    }

    @Override
    public void destroy() {
        PBufferGraphics llllllllllllllllIIlIllIIIIIlIlII;
        super.destroy();
        llllllllllllllllIIlIllIIIIIlIlII.pbuffer.destroy();
    }

    @Override
    public void flush() {
        PBufferGraphics llllllllllllllllIIlIllIIIIIlIIIl;
        super.flush();
        llllllllllllllllIIlIllIIIIIlIIIl.image.flushPixelData();
    }

    @Override
    protected void disable() {
        PBufferGraphics llllllllllllllllIIlIllIIIIlIIlIl;
        GL.flush();
        GL.glBindTexture(3553, llllllllllllllllIIlIllIIIIlIIlIl.image.getTexture().getTextureID());
        llllllllllllllllIIlIllIIIIlIIlIl.pbuffer.bindTexImage(8323);
        try {
            Display.makeCurrent();
        }
        catch (LWJGLException llllllllllllllllIIlIllIIIIlIIllI) {
            Log.error(llllllllllllllllIIlIllIIIIlIIllI);
        }
        SlickCallable.leaveSafeBlock();
    }

    private void init() throws SlickException {
        try {
            PBufferGraphics llllllllllllllllIIlIllIIIIlIllII;
            Texture llllllllllllllllIIlIllIIIIlIllll = InternalTextureLoader.get().createTexture(llllllllllllllllIIlIllIIIIlIllII.image.getWidth(), llllllllllllllllIIlIllIIIIlIllII.image.getHeight(), llllllllllllllllIIlIllIIIIlIllII.image.getFilter());
            RenderTexture llllllllllllllllIIlIllIIIIlIlllI = new RenderTexture(false, true, false, false, 8314, 0);
            llllllllllllllllIIlIllIIIIlIllII.pbuffer = new Pbuffer(llllllllllllllllIIlIllIIIIlIllII.screenWidth, llllllllllllllllIIlIllIIIIlIllII.screenHeight, new PixelFormat(8, 0, 0), llllllllllllllllIIlIllIIIIlIlllI, null);
            llllllllllllllllIIlIllIIIIlIllII.pbuffer.makeCurrent();
            llllllllllllllllIIlIllIIIIlIllII.initGL();
            GL.glBindTexture(3553, llllllllllllllllIIlIllIIIIlIllll.getTextureID());
            llllllllllllllllIIlIllIIIIlIllII.pbuffer.releaseTexImage(8323);
            llllllllllllllllIIlIllIIIIlIllII.image.draw(0.0f, 0.0f);
            llllllllllllllllIIlIllIIIIlIllII.image.setTexture(llllllllllllllllIIlIllIIIIlIllll);
            Display.makeCurrent();
        }
        catch (Exception llllllllllllllllIIlIllIIIIlIllIl) {
            Log.error(llllllllllllllllIIlIllIIIIlIllIl);
            throw new SlickException("Failed to create PBuffer for dynamic image. OpenGL driver failure?");
        }
    }
}

