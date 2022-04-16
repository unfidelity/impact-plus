/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.Pbuffer
 *  org.lwjgl.opengl.PixelFormat
 */
package org.newdawn.slick.opengl.pbuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.util.Log;

public class PBufferUniqueGraphics
extends Graphics {
    private /* synthetic */ Image image;
    private /* synthetic */ Pbuffer pbuffer;

    private void init() throws SlickException {
        try {
            PBufferUniqueGraphics llIlllIIlIIIIII;
            Texture llIlllIIlIIIIll = InternalTextureLoader.get().createTexture(llIlllIIlIIIIII.image.getWidth(), llIlllIIlIIIIII.image.getHeight(), llIlllIIlIIIIII.image.getFilter());
            llIlllIIlIIIIII.pbuffer = new Pbuffer(llIlllIIlIIIIII.screenWidth, llIlllIIlIIIIII.screenHeight, new PixelFormat(8, 0, 0), null, null);
            llIlllIIlIIIIII.pbuffer.makeCurrent();
            llIlllIIlIIIIII.initGL();
            llIlllIIlIIIIII.image.draw(0.0f, 0.0f);
            GL11.glBindTexture((int)3553, (int)llIlllIIlIIIIll.getTextureID());
            GL11.glCopyTexImage2D((int)3553, (int)0, (int)6408, (int)0, (int)0, (int)llIlllIIlIIIIll.getTextureWidth(), (int)llIlllIIlIIIIll.getTextureHeight(), (int)0);
            llIlllIIlIIIIII.image.setTexture(llIlllIIlIIIIll);
            Display.makeCurrent();
        }
        catch (Exception llIlllIIlIIIIlI) {
            Log.error(llIlllIIlIIIIlI);
            throw new SlickException("Failed to create PBuffer for dynamic image. OpenGL driver failure?");
        }
    }

    protected void enterOrtho() {
        PBufferUniqueGraphics llIlllIIIIIllIl;
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)llIlllIIIIIllIl.screenWidth, (double)0.0, (double)llIlllIIIIIllIl.screenHeight, (double)1.0, (double)-1.0);
        GL11.glMatrixMode((int)5888);
    }

    @Override
    public void destroy() {
        PBufferUniqueGraphics llIlllIIIIIIlll;
        super.destroy();
        llIlllIIIIIIlll.pbuffer.destroy();
    }

    @Override
    protected void disable() {
        PBufferUniqueGraphics llIlllIIIlllIIl;
        GL11.glBindTexture((int)3553, (int)llIlllIIIlllIIl.image.getTexture().getTextureID());
        GL11.glCopyTexImage2D((int)3553, (int)0, (int)6408, (int)0, (int)0, (int)llIlllIIIlllIIl.image.getTexture().getTextureWidth(), (int)llIlllIIIlllIIl.image.getTexture().getTextureHeight(), (int)0);
        try {
            Display.makeCurrent();
        }
        catch (LWJGLException llIlllIIIlllIlI) {
            Log.error(llIlllIIIlllIlI);
        }
        SlickCallable.leaveSafeBlock();
    }

    protected void initGL() {
        PBufferUniqueGraphics llIlllIIIIlIIlI;
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7425);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glClearDepth((double)1.0);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glViewport((int)0, (int)0, (int)llIlllIIIIlIIlI.screenWidth, (int)llIlllIIIIlIIlI.screenHeight);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        llIlllIIIIlIIlI.enterOrtho();
    }

    public PBufferUniqueGraphics(Image llIlllIIllIIlII) throws SlickException {
        super(llIlllIIllIIlII.getTexture().getTextureWidth(), llIlllIIllIIlII.getTexture().getTextureHeight());
        PBufferUniqueGraphics llIlllIIllIlIIl;
        llIlllIIllIlIIl.image = llIlllIIllIIlII;
        Log.debug(String.valueOf(new StringBuilder().append("Creating pbuffer(unique) ").append(llIlllIIllIIlII.getWidth()).append("x").append(llIlllIIllIIlII.getHeight())));
        if ((Pbuffer.getCapabilities() & 1) == 0) {
            throw new SlickException("Your OpenGL card does not support PBuffers and hence can't handle the dynamic images required for this application.");
        }
        llIlllIIllIlIIl.init();
    }

    @Override
    protected void enable() {
        PBufferUniqueGraphics llIlllIIIIllIll;
        SlickCallable.enterSafeBlock();
        try {
            if (llIlllIIIIllIll.pbuffer.isBufferLost()) {
                llIlllIIIIllIll.pbuffer.destroy();
                llIlllIIIIllIll.init();
            }
            llIlllIIIIllIll.pbuffer.makeCurrent();
        }
        catch (Exception llIlllIIIIlllII) {
            Log.error("Failed to recreate the PBuffer");
            Log.error(llIlllIIIIlllII);
            throw new RuntimeException(llIlllIIIIlllII);
        }
        TextureImpl.unbind();
        llIlllIIIIllIll.initGL();
    }

    @Override
    public void flush() {
        PBufferUniqueGraphics llIlllIIIIIIIlI;
        super.flush();
        llIlllIIIIIIIlI.image.flushPixelData();
    }
}

