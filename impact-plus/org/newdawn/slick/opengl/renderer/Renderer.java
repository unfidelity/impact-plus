/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl.renderer;

import org.newdawn.slick.opengl.renderer.DefaultLineStripRenderer;
import org.newdawn.slick.opengl.renderer.ImmediateModeOGLRenderer;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.QuadBasedLineStripRenderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.opengl.renderer.VAOGLRenderer;

public class Renderer {
    private static /* synthetic */ SGL renderer;
    public static final /* synthetic */ int IMMEDIATE_RENDERER;
    public static final /* synthetic */ int VERTEX_ARRAY_RENDERER;
    public static final /* synthetic */ int DEFAULT_LINE_STRIP_RENDERER;
    private static /* synthetic */ LineStripRenderer lineStripRenderer;
    public static final /* synthetic */ int QUAD_BASED_LINE_STRIP_RENDERER;

    public static void setRenderer(int llIlIIllIllI) {
        switch (llIlIIllIllI) {
            case 1: {
                Renderer.setRenderer(new ImmediateModeOGLRenderer());
                return;
            }
            case 2: {
                Renderer.setRenderer(new VAOGLRenderer());
                return;
            }
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("Unknown renderer type: ").append(llIlIIllIllI)));
    }

    public static void setLineStripRenderer(int llIlIIllIIll) {
        switch (llIlIIllIIll) {
            case 3: {
                Renderer.setLineStripRenderer(new DefaultLineStripRenderer());
                return;
            }
            case 4: {
                Renderer.setLineStripRenderer(new QuadBasedLineStripRenderer());
                return;
            }
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("Unknown line strip renderer type: ").append(llIlIIllIIll)));
    }

    static {
        QUAD_BASED_LINE_STRIP_RENDERER = 4;
        VERTEX_ARRAY_RENDERER = 2;
        IMMEDIATE_RENDERER = 1;
        DEFAULT_LINE_STRIP_RENDERER = 3;
        renderer = new ImmediateModeOGLRenderer();
        lineStripRenderer = new DefaultLineStripRenderer();
    }

    public static LineStripRenderer getLineStripRenderer() {
        return lineStripRenderer;
    }

    public Renderer() {
        Renderer llIlIIlllIII;
    }

    public static void setRenderer(SGL llIlIIlIllIl) {
        renderer = llIlIIlIllIl;
    }

    public static SGL get() {
        return renderer;
    }

    public static void setLineStripRenderer(LineStripRenderer llIlIIlIllll) {
        lineStripRenderer = llIlIIlIllll;
    }
}

