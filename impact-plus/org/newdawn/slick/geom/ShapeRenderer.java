/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.TexCoordGenerator;
import org.newdawn.slick.geom.Triangulator;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public final class ShapeRenderer {
    private static /* synthetic */ SGL GL;
    private static /* synthetic */ LineStripRenderer LSR;

    public static final void fill(Shape lIIllIlIIIlI, final ShapeFill lIIllIlIIIII) {
        if (!ShapeRenderer.validFill(lIIllIlIIIlI)) {
            return;
        }
        Texture lIIllIlIIllI = TextureImpl.getLastBind();
        TextureImpl.bindNone();
        float[] lIIllIlIIlII = lIIllIlIIIlI.getCenter();
        ShapeRenderer.fill(lIIllIlIIIlI, new PointCallback(){
            {
                4 lllllllllllllllllIIlllIllIlllllI;
            }

            @Override
            public float[] preRenderPoint(Shape lllllllllllllllllIIlllIllIllIlIl, float lllllllllllllllllIIlllIllIllIlII, float lllllllllllllllllIIlllIllIllIIll) {
                4 lllllllllllllllllIIlllIllIllIllI;
                lllllllllllllllllIIlllIllIllIllI.lIIllIlIIIII.colorAt(lllllllllllllllllIIlllIllIllIlIl, lllllllllllllllllIIlllIllIllIlII, lllllllllllllllllIIlllIllIllIIll).bind();
                Vector2f lllllllllllllllllIIlllIllIllIIlI = lllllllllllllllllIIlllIllIllIllI.lIIllIlIIIII.getOffsetAt(lllllllllllllllllIIlllIllIllIlIl, lllllllllllllllllIIlllIllIllIlII, lllllllllllllllllIIlllIllIllIIll);
                return new float[]{lllllllllllllllllIIlllIllIllIIlI.x + lllllllllllllllllIIlllIllIllIlII, lllllllllllllllllIIlllIllIllIIlI.y + lllllllllllllllllIIlllIllIllIIll};
            }
        });
        if (lIIllIlIIllI == null) {
            TextureImpl.bindNone();
        } else {
            lIIllIlIIllI.bind();
        }
    }

    static {
        GL = Renderer.get();
        LSR = Renderer.getLineStripRenderer();
    }

    public ShapeRenderer() {
        ShapeRenderer lIlIIllllIII;
    }

    public static boolean validFill(Shape lIlIIlIlIIII) {
        if (lIlIIlIlIIII.getTriangles() == null) {
            return false;
        }
        return lIlIIlIlIIII.getTriangles().getTriangleCount() != 0;
    }

    public static final void draw(Shape lIlIIllIIIII, ShapeFill lIlIIlIllIlI) {
        float[] lIlIIlIllllI = lIlIIllIIIII.getPoints();
        Texture lIlIIlIlllIl = TextureImpl.getLastBind();
        TextureImpl.bindNone();
        float[] lIlIIlIlllII = lIlIIllIIIII.getCenter();
        GL.glBegin(3);
        for (int lIlIIllIIIlI = 0; lIlIIllIIIlI < lIlIIlIllllI.length; lIlIIllIIIlI += 2) {
            lIlIIlIllIlI.colorAt(lIlIIllIIIII, lIlIIlIllllI[lIlIIllIIIlI], lIlIIlIllllI[lIlIIllIIIlI + 1]).bind();
            Vector2f lIlIIllIIIll = lIlIIlIllIlI.getOffsetAt(lIlIIllIIIII, lIlIIlIllllI[lIlIIllIIIlI], lIlIIlIllllI[lIlIIllIIIlI + 1]);
            GL.glVertex2f(lIlIIlIllllI[lIlIIllIIIlI] + lIlIIllIIIll.x, lIlIIlIllllI[lIlIIllIIIlI + 1] + lIlIIllIIIll.y);
        }
        if (lIlIIllIIIII.closed()) {
            lIlIIlIllIlI.colorAt(lIlIIllIIIII, lIlIIlIllllI[0], lIlIIlIllllI[1]).bind();
            Vector2f lIlIIllIIIIl = lIlIIlIllIlI.getOffsetAt(lIlIIllIIIII, lIlIIlIllllI[0], lIlIIlIllllI[1]);
            GL.glVertex2f(lIlIIlIllllI[0] + lIlIIllIIIIl.x, lIlIIlIllllI[1] + lIlIIllIIIIl.y);
        }
        GL.glEnd();
        if (lIlIIlIlllIl == null) {
            TextureImpl.bindNone();
        } else {
            lIlIIlIlllIl.bind();
        }
    }

    public static final void draw(Shape lIlIIlllIIIl) {
        Texture lIlIIlllIIII = TextureImpl.getLastBind();
        TextureImpl.bindNone();
        float[] lIlIIllIllll = lIlIIlllIIIl.getPoints();
        LSR.start();
        for (int lIlIIlllIIlI = 0; lIlIIlllIIlI < lIlIIllIllll.length; lIlIIlllIIlI += 2) {
            LSR.vertex(lIlIIllIllll[lIlIIlllIIlI], lIlIIllIllll[lIlIIlllIIlI + 1]);
        }
        if (lIlIIlllIIIl.closed()) {
            LSR.vertex(lIlIIllIllll[0], lIlIIllIllll[1]);
        }
        LSR.end();
        if (lIlIIlllIIII == null) {
            TextureImpl.bindNone();
        } else {
            lIlIIlllIIII.bind();
        }
    }

    public static final void textureFit(Shape lIlIIIIlIlII, Image lIlIIIIlIIll) {
        ShapeRenderer.textureFit(lIlIIIIlIlII, lIlIIIIlIIll, 1.0f, 1.0f);
    }

    private static final void fill(Shape lIlIIIlIllII, PointCallback lIlIIIlIllll) {
        Triangulator lIlIIIlIlllI = lIlIIIlIllII.getTriangles();
        GL.glBegin(4);
        for (int lIlIIIllIIlI = 0; lIlIIIllIIlI < lIlIIIlIlllI.getTriangleCount(); ++lIlIIIllIIlI) {
            for (int lIlIIIllIlII = 0; lIlIIIllIlII < 3; ++lIlIIIllIlII) {
                float[] lIlIIIllIlll = lIlIIIlIlllI.getTrianglePoint(lIlIIIllIIlI, lIlIIIllIlII);
                float[] lIlIIIllIlIl = lIlIIIlIllll.preRenderPoint(lIlIIIlIllII, lIlIIIllIlll[0], lIlIIIllIlll[1]);
                if (lIlIIIllIlIl == null) {
                    GL.glVertex2f(lIlIIIllIlll[0], lIlIIIllIlll[1]);
                    continue;
                }
                GL.glVertex2f(lIlIIIllIlIl[0], lIlIIIllIlIl[1]);
            }
        }
        GL.glEnd();
    }

    public static final void texture(Shape lIlIIIIllIlI, Image lIlIIIIlIlll) {
        ShapeRenderer.texture(lIlIIIIllIlI, lIlIIIIlIlll, 0.01f, 0.01f);
    }

    public static final void texture(Shape lIIllIIIIIII, final Image lIIllIIIlIll, final float lIIllIIIlIlI, final float lIIlIllllIlI, final ShapeFill lIIllIIIIllI) {
        if (!ShapeRenderer.validFill(lIIllIIIIIII)) {
            return;
        }
        Texture lIIllIIIIlII = TextureImpl.getLastBind();
        lIIllIIIlIll.getTexture().bind();
        final float[] lIIllIIIIIlI = lIIllIIIIIII.getCenter();
        ShapeRenderer.fill(lIIllIIIIIII, new PointCallback(){

            @Override
            public float[] preRenderPoint(Shape lllllllllllllllIlllIIllIIIIIlIIl, float lllllllllllllllIlllIIllIIIIIIllI, float lllllllllllllllIlllIIllIIIIIIlIl) {
                5 lllllllllllllllIlllIIllIIIIllIlI;
                lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIIllI.colorAt(lllllllllllllllIlllIIllIIIIIlIIl, lllllllllllllllIlllIIllIIIIIIllI - lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIIIlI[0], lllllllllllllllIlllIIllIIIIIIlIl - lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIIIlI[1]).bind();
                Vector2f lllllllllllllllIlllIIllIIIIlIIIl = lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIIllI.getOffsetAt(lllllllllllllllIlllIIllIIIIIlIIl, lllllllllllllllIlllIIllIIIIIIllI, lllllllllllllllIlllIIllIIIIIIlIl);
                float lllllllllllllllIlllIIllIIIIIllll = (lllllllllllllllIlllIIllIIIIIIllI += lllllllllllllllIlllIIllIIIIlIIIl.x) * lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIlIlI;
                float lllllllllllllllIlllIIllIIIIIllIl = (lllllllllllllllIlllIIllIIIIIIlIl += lllllllllllllllIlllIIllIIIIlIIIl.y) * lllllllllllllllIlllIIllIIIIllIlI.lIIlIllllIlI;
                lllllllllllllllIlllIIllIIIIIllll = lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIlIll.getTextureOffsetX() + lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIlIll.getTextureWidth() * lllllllllllllllIlllIIllIIIIIllll;
                lllllllllllllllIlllIIllIIIIIllIl = lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIlIll.getTextureOffsetY() + lllllllllllllllIlllIIllIIIIllIlI.lIIllIIIlIll.getTextureHeight() * lllllllllllllllIlllIIllIIIIIllIl;
                GL.glTexCoord2f(lllllllllllllllIlllIIllIIIIIllll, lllllllllllllllIlllIIllIIIIIllIl);
                return new float[]{lllllllllllllllIlllIIllIIIIlIIIl.x + lllllllllllllllIlllIIllIIIIIIllI, lllllllllllllllIlllIIllIIIIlIIIl.y + lllllllllllllllIlllIIllIIIIIIlIl};
            }
            {
                5 lllllllllllllllIlllIIllIIIllIlIl;
            }
        });
        if (lIIllIIIIlII == null) {
            TextureImpl.bindNone();
        } else {
            lIIllIIIIlII.bind();
        }
    }

    public static final void texture(Shape lIIlIllIIIlI, Image lIIlIllIIIIl, final TexCoordGenerator lIIlIllIIIII) {
        Texture lIIlIllIIlII = TextureImpl.getLastBind();
        lIIlIllIIIIl.getTexture().bind();
        float[] lIIlIllIIIll = lIIlIllIIIlI.getCenter();
        ShapeRenderer.fill(lIIlIllIIIlI, new PointCallback(){
            {
                6 lllllllllllllllIllllIlllIlIIIlll;
            }

            @Override
            public float[] preRenderPoint(Shape lllllllllllllllIllllIlllIlIIIIII, float lllllllllllllllIllllIlllIIllllll, float lllllllllllllllIllllIlllIIlllllI) {
                6 lllllllllllllllIllllIlllIlIIIIIl;
                Vector2f lllllllllllllllIllllIlllIIllllIl = lllllllllllllllIllllIlllIlIIIIIl.lIIlIllIIIII.getCoordFor(lllllllllllllllIllllIlllIIllllll, lllllllllllllllIllllIlllIIlllllI);
                GL.glTexCoord2f(lllllllllllllllIllllIlllIIllllIl.x, lllllllllllllllIllllIlllIIllllIl.y);
                return new float[]{lllllllllllllllIllllIlllIIllllll, lllllllllllllllIllllIlllIIlllllI};
            }
        });
        if (lIIlIllIIlII == null) {
            TextureImpl.bindNone();
        } else {
            lIIlIllIIlII.bind();
        }
    }

    public static final void textureFit(Shape lIIllIlllIll, final Image lIIllIlllIlI, final float lIIllIlllIIl, final float lIIllIlllIII) {
        if (!ShapeRenderer.validFill(lIIllIlllIll)) {
            return;
        }
        float[] lIIlllIIIIIl = lIIllIlllIll.getPoints();
        Texture lIIlllIIIIII = TextureImpl.getLastBind();
        lIIllIlllIlI.getTexture().bind();
        float lIIllIllllll = lIIllIlllIll.getX();
        float lIIllIlllllI = lIIllIlllIll.getY();
        float lIIllIllllIl = lIIllIlllIll.getMaxX() - lIIllIllllll;
        float lIIllIllllII = lIIllIlllIll.getMaxY() - lIIllIlllllI;
        ShapeRenderer.fill(lIIllIlllIll, new PointCallback(){

            @Override
            public float[] preRenderPoint(Shape lllllllllllllllIllIllIllIlIIlllI, float lllllllllllllllIllIllIllIlIIllIl, float lllllllllllllllIllIllIllIlIIllII) {
                3 lllllllllllllllIllIllIllIlIIllll;
                lllllllllllllllIllIllIllIlIIllIl -= lllllllllllllllIllIllIllIlIIlllI.getMinX();
                lllllllllllllllIllIllIllIlIIllII -= lllllllllllllllIllIllIllIlIIlllI.getMinY();
                float lllllllllllllllIllIllIllIlIIlIll = (lllllllllllllllIllIllIllIlIIllIl /= lllllllllllllllIllIllIllIlIIlllI.getMaxX() - lllllllllllllllIllIllIllIlIIlllI.getMinX()) * lllllllllllllllIllIllIllIlIIllll.lIIllIlllIIl;
                float lllllllllllllllIllIllIllIlIIlIlI = (lllllllllllllllIllIllIllIlIIllII /= lllllllllllllllIllIllIllIlIIlllI.getMaxY() - lllllllllllllllIllIllIllIlIIlllI.getMinY()) * lllllllllllllllIllIllIllIlIIllll.lIIllIlllIII;
                lllllllllllllllIllIllIllIlIIlIll = lllllllllllllllIllIllIllIlIIllll.lIIllIlllIlI.getTextureOffsetX() + lllllllllllllllIllIllIllIlIIllll.lIIllIlllIlI.getTextureWidth() * lllllllllllllllIllIllIllIlIIlIll;
                lllllllllllllllIllIllIllIlIIlIlI = lllllllllllllllIllIllIllIlIIllll.lIIllIlllIlI.getTextureOffsetY() + lllllllllllllllIllIllIllIlIIllll.lIIllIlllIlI.getTextureHeight() * lllllllllllllllIllIllIllIlIIlIlI;
                GL.glTexCoord2f(lllllllllllllllIllIllIllIlIIlIll, lllllllllllllllIllIllIllIlIIlIlI);
                return null;
            }
            {
                3 lllllllllllllllIllIllIllIlIllIlI;
            }
        });
        if (lIIlllIIIIII == null) {
            TextureImpl.bindNone();
        } else {
            lIIlllIIIIII.bind();
        }
    }

    public static final void texture(Shape lIIlllllllII, final Image lIIllllllIlI, final float lIIllllllIII, final float lIIlllllIllI) {
        if (!ShapeRenderer.validFill(lIIlllllllII)) {
            return;
        }
        Texture lIIlllllIlII = TextureImpl.getLastBind();
        lIIllllllIlI.getTexture().bind();
        ShapeRenderer.fill(lIIlllllllII, new PointCallback(){
            {
                2 lllllllllllllllIlllIIIllIlllIllI;
            }

            @Override
            public float[] preRenderPoint(Shape lllllllllllllllIlllIIIllIllIlIll, float lllllllllllllllIlllIIIllIllIlIlI, float lllllllllllllllIlllIIIllIllIlIIl) {
                2 lllllllllllllllIlllIIIllIllIllII;
                float lllllllllllllllIlllIIIllIllIlIII = lllllllllllllllIlllIIIllIllIlIlI * lllllllllllllllIlllIIIllIllIllII.lIIllllllIII;
                float lllllllllllllllIlllIIIllIllIIlll = lllllllllllllllIlllIIIllIllIlIIl * lllllllllllllllIlllIIIllIllIllII.lIIlllllIllI;
                lllllllllllllllIlllIIIllIllIlIII = lllllllllllllllIlllIIIllIllIllII.lIIllllllIlI.getTextureOffsetX() + lllllllllllllllIlllIIIllIllIllII.lIIllllllIlI.getTextureWidth() * lllllllllllllllIlllIIIllIllIlIII;
                lllllllllllllllIlllIIIllIllIIlll = lllllllllllllllIlllIIIllIllIllII.lIIllllllIlI.getTextureOffsetY() + lllllllllllllllIlllIIIllIllIllII.lIIllllllIlI.getTextureHeight() * lllllllllllllllIlllIIIllIllIIlll;
                GL.glTexCoord2f(lllllllllllllllIlllIIIllIllIlIII, lllllllllllllllIlllIIIllIllIIlll);
                return null;
            }
        });
        float[] lIIlllllIIlI = lIIlllllllII.getPoints();
        if (lIIlllllIlII == null) {
            TextureImpl.bindNone();
        } else {
            lIIlllllIlII.bind();
        }
    }

    public static final void fill(Shape lIlIIlIIIllI) {
        if (!ShapeRenderer.validFill(lIlIIlIIIllI)) {
            return;
        }
        Texture lIlIIlIIIlIl = TextureImpl.getLastBind();
        TextureImpl.bindNone();
        ShapeRenderer.fill(lIlIIlIIIllI, new PointCallback(){
            {
                1 llllllllllllllllIIIIIllllIIIIIIl;
            }

            @Override
            public float[] preRenderPoint(Shape llllllllllllllllIIIIIlllIllllllI, float llllllllllllllllIIIIIlllIlllllIl, float llllllllllllllllIIIIIlllIlllllII) {
                return null;
            }
        });
        if (lIlIIlIIIlIl == null) {
            TextureImpl.bindNone();
        } else {
            lIlIIlIIIlIl.bind();
        }
    }

    private static interface PointCallback {
        public float[] preRenderPoint(Shape var1, float var2, float var3);
    }
}

