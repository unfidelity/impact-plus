/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.opengl.Pbuffer
 */
package org.newdawn.slick.opengl.pbuffer;

import java.util.HashMap;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.Pbuffer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.pbuffer.FBOGraphics;
import org.newdawn.slick.opengl.pbuffer.PBufferGraphics;
import org.newdawn.slick.opengl.pbuffer.PBufferUniqueGraphics;
import org.newdawn.slick.util.Log;

public class GraphicsFactory {
    private static /* synthetic */ boolean pbuffer;
    private static /* synthetic */ HashMap graphics;
    private static /* synthetic */ boolean init;
    private static /* synthetic */ boolean fbo;
    private static /* synthetic */ boolean pbufferRT;

    public GraphicsFactory() {
        GraphicsFactory lIlIIllIIIlllI;
    }

    static {
        graphics = new HashMap();
        pbuffer = true;
        pbufferRT = true;
        fbo = true;
        init = false;
    }

    public static boolean usingPBuffer() {
        return !fbo && pbuffer;
    }

    public static Graphics getGraphicsForImage(Image lIlIIlIlIIllIl) throws SlickException {
        Graphics lIlIIlIlIIlllI = (Graphics)graphics.get(lIlIIlIlIIllIl.getTexture());
        if (lIlIIlIlIIlllI == null) {
            lIlIIlIlIIlllI = GraphicsFactory.createGraphics(lIlIIlIlIIllIl);
            graphics.put(lIlIIlIlIIllIl.getTexture(), lIlIIlIlIIlllI);
        }
        return lIlIIlIlIIlllI;
    }

    public static void releaseGraphicsForImage(Image lIlIIlIlIIIlll) throws SlickException {
        Graphics lIlIIlIlIIlIII = (Graphics)graphics.remove(lIlIIlIlIIIlll.getTexture());
        if (lIlIIlIlIIlIII != null) {
            lIlIIlIlIIlIII.destroy();
        }
    }

    private static Graphics createGraphics(Image lIlIIlIlIIIIIl) throws SlickException {
        GraphicsFactory.init();
        if (fbo) {
            try {
                return new FBOGraphics(lIlIIlIlIIIIIl);
            }
            catch (Exception lIlIIlIlIIIIll) {
                fbo = false;
                Log.warn("FBO failed in use, falling back to PBuffer");
            }
        }
        if (pbuffer) {
            if (pbufferRT) {
                return new PBufferGraphics(lIlIIlIlIIIIIl);
            }
            return new PBufferUniqueGraphics(lIlIIlIlIIIIIl);
        }
        throw new SlickException("Failed to create offscreen buffer even though the card reports it's possible");
    }

    public static boolean usingFBO() {
        return fbo;
    }

    private static void init() throws SlickException {
        init = true;
        if (fbo) {
            fbo = GLContext.getCapabilities().GL_EXT_framebuffer_object;
        }
        pbuffer = (Pbuffer.getCapabilities() & 1) != 0;
        boolean bl = pbufferRT = (Pbuffer.getCapabilities() & 2) != 0;
        if (!(fbo || pbuffer || pbufferRT)) {
            throw new SlickException("Your OpenGL card does not support offscreen buffers and hence can't handle the dynamic images required for this application.");
        }
        Log.info(String.valueOf(new StringBuilder().append("Offscreen Buffers FBO=").append(fbo).append(" PBUFFER=").append(pbuffer).append(" PBUFFERRT=").append(pbufferRT)));
    }

    public static void setUseFBO(boolean lIlIIlIlIlIIll) {
        fbo = lIlIIlIlIlIIll;
    }
}

