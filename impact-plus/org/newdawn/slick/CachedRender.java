/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import org.newdawn.slick.opengl.SlickCallable;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class CachedRender {
    private /* synthetic */ Runnable runnable;
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ int list;

    public CachedRender(Runnable llllllllllllllllIIIlIllIIlIllIIl) {
        CachedRender llllllllllllllllIIIlIllIIlIllIlI;
        llllllllllllllllIIIlIllIIlIllIlI.list = -1;
        llllllllllllllllIIIlIllIIlIllIlI.runnable = llllllllllllllllIIIlIllIIlIllIIl;
        llllllllllllllllIIIlIllIIlIllIlI.build();
    }

    public void destroy() {
        CachedRender llllllllllllllllIIIlIllIIlIlIIII;
        GL.glDeleteLists(llllllllllllllllIIIlIllIIlIlIIII.list, 1);
        llllllllllllllllIIIlIllIIlIlIIII.list = -1;
    }

    public void render() {
        CachedRender llllllllllllllllIIIlIllIIlIlIIll;
        if (llllllllllllllllIIIlIllIIlIlIIll.list == -1) {
            throw new RuntimeException("Attempt to render cached operations that have been destroyed");
        }
        SlickCallable.enterSafeBlock();
        GL.glCallList(llllllllllllllllIIIlIllIIlIlIIll.list);
        SlickCallable.leaveSafeBlock();
    }

    static {
        GL = Renderer.get();
    }

    private void build() {
        CachedRender llllllllllllllllIIIlIllIIlIlIllI;
        if (llllllllllllllllIIIlIllIIlIlIllI.list != -1) {
            throw new RuntimeException("Attempt to build the display list more than once in CachedRender");
        }
        llllllllllllllllIIIlIllIIlIlIllI.list = GL.glGenLists(1);
        SlickCallable.enterSafeBlock();
        GL.glNewList(llllllllllllllllIIIlIllIIlIlIllI.list, 4864);
        llllllllllllllllIIIlIllIIlIlIllI.runnable.run();
        GL.glEndList();
        SlickCallable.leaveSafeBlock();
    }
}

