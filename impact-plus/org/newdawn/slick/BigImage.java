/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.ImageDataFactory;
import org.newdawn.slick.opengl.LoadableImageData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.OperationNotSupportedException;
import org.newdawn.slick.util.ResourceLoader;

public class BigImage
extends Image {
    private /* synthetic */ int realHeight;
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ Image[][] images;
    private /* synthetic */ int ycount;
    private static /* synthetic */ Image lastBind;
    private /* synthetic */ int xcount;
    private /* synthetic */ int realWidth;

    @Override
    public void bind() {
        throw new OperationNotSupportedException("Can't bind big images yet");
    }

    @Override
    public void drawSheared(float llllllllllllllllllIIlIIlIIllIIll, float llllllllllllllllllIIlIIlIIllIIlI, float llllllllllllllllllIIlIIlIIllIIIl, float llllllllllllllllllIIlIIlIIllIIII) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color getColor(int llllllllllllllllllIIlIlIlIIlIllI, int llllllllllllllllllIIlIlIlIIlIlII) {
        throw new OperationNotSupportedException("Can't use big images as buffers");
    }

    private void build(final LoadableImageData llllllllllllllllllIIlIlllllIlIll, final ByteBuffer llllllllllllllllllIIlIlllllIlIlI, int llllllllllllllllllIIlIlllllIlIIl, int llllllllllllllllllIIlIlllllIIIII) {
        BigImage llllllllllllllllllIIlIlllllIIlII;
        final int llllllllllllllllllIIlIlllllIIlll = llllllllllllllllllIIlIlllllIlIll.getTexWidth();
        final int llllllllllllllllllIIlIlllllIIllI = llllllllllllllllllIIlIlllllIlIll.getTexHeight();
        llllllllllllllllllIIlIlllllIIlII.realWidth = llllllllllllllllllIIlIlllllIIlII.width = llllllllllllllllllIIlIlllllIlIll.getWidth();
        llllllllllllllllllIIlIlllllIIlII.realHeight = llllllllllllllllllIIlIlllllIIlII.height = llllllllllllllllllIIlIlllllIlIll.getHeight();
        if (llllllllllllllllllIIlIlllllIIlll <= llllllllllllllllllIIlIlllllIIIII && llllllllllllllllllIIlIlllllIIllI <= llllllllllllllllllIIlIlllllIIIII) {
            llllllllllllllllllIIlIlllllIIlII.images = new Image[1][1];
            ImageData llllllllllllllllllIIlIlllllllIll = new ImageData(){

                @Override
                public int getTexHeight() {
                    1 llllllllllllllllIlIIlIllIlIlIIIl;
                    return llllllllllllllllIlIIlIllIlIlIIIl.llllllllllllllllllIIlIlllllIIllI;
                }

                @Override
                public int getTexWidth() {
                    1 llllllllllllllllIlIIlIllIlIIlIlI;
                    return llllllllllllllllIlIIlIllIlIIlIlI.llllllllllllllllllIIlIlllllIIlll;
                }

                @Override
                public ByteBuffer getImageBufferData() {
                    1 llllllllllllllllIlIIlIllIlIllIlI;
                    return llllllllllllllllIlIIlIllIlIllIlI.llllllllllllllllllIIlIlllllIlIlI;
                }

                @Override
                public int getHeight() {
                    1 llllllllllllllllIlIIlIllIllIIIII;
                    return llllllllllllllllIlIIlIllIllIIIII.llllllllllllllllllIIlIlllllIIllI;
                }
                {
                    1 llllllllllllllllIlIIlIllIllIlIll;
                }

                @Override
                public int getDepth() {
                    1 llllllllllllllllIlIIlIllIllIIIlI;
                    return llllllllllllllllIlIIlIllIllIIIlI.llllllllllllllllllIIlIlllllIlIll.getDepth();
                }

                @Override
                public int getWidth() {
                    1 llllllllllllllllIlIIlIllIlIIIllI;
                    return llllllllllllllllIlIIlIllIlIIIllI.llllllllllllllllllIIlIlllllIIlll;
                }
            };
            llllllllllllllllllIIlIlllllIIlII.images[0][0] = new Image(llllllllllllllllllIIlIlllllllIll, llllllllllllllllllIIlIlllllIlIIl);
            llllllllllllllllllIIlIlllllIIlII.xcount = 1;
            llllllllllllllllllIIlIlllllIIlII.ycount = 1;
            llllllllllllllllllIIlIlllllIIlII.inited = true;
            return;
        }
        llllllllllllllllllIIlIlllllIIlII.xcount = (llllllllllllllllllIIlIlllllIIlII.realWidth - 1) / llllllllllllllllllIIlIlllllIIIII + 1;
        llllllllllllllllllIIlIlllllIIlII.ycount = (llllllllllllllllllIIlIlllllIIlII.realHeight - 1) / llllllllllllllllllIIlIlllllIIIII + 1;
        llllllllllllllllllIIlIlllllIIlII.images = new Image[llllllllllllllllllIIlIlllllIIlII.xcount][llllllllllllllllllIIlIlllllIIlII.ycount];
        int llllllllllllllllllIIlIlllllIIlIl = llllllllllllllllllIIlIlllllIlIll.getDepth() / 8;
        for (int llllllllllllllllllIIlIlllllIllIl = 0; llllllllllllllllllIIlIlllllIllIl < llllllllllllllllllIIlIlllllIIlII.xcount; ++llllllllllllllllllIIlIlllllIllIl) {
            for (int llllllllllllllllllIIlIlllllIlllI = 0; llllllllllllllllllIIlIlllllIlllI < llllllllllllllllllIIlIlllllIIlII.ycount; ++llllllllllllllllllIIlIlllllIlllI) {
                int llllllllllllllllllIIlIlllllllIII = (llllllllllllllllllIIlIlllllIllIl + 1) * llllllllllllllllllIIlIlllllIIIII;
                int llllllllllllllllllIIlIllllllIlll = (llllllllllllllllllIIlIlllllIlllI + 1) * llllllllllllllllllIIlIlllllIIIII;
                final int llllllllllllllllllIIlIllllllIllI = Math.min(llllllllllllllllllIIlIlllllIIlII.realWidth - llllllllllllllllllIIlIlllllIllIl * llllllllllllllllllIIlIlllllIIIII, llllllllllllllllllIIlIlllllIIIII);
                final int llllllllllllllllllIIlIllllllIlIl = Math.min(llllllllllllllllllIIlIlllllIIlII.realHeight - llllllllllllllllllIIlIlllllIlllI * llllllllllllllllllIIlIlllllIIIII, llllllllllllllllllIIlIlllllIIIII);
                final int llllllllllllllllllIIlIllllllIlII = llllllllllllllllllIIlIlllllIIIII;
                final int llllllllllllllllllIIlIllllllIIll = llllllllllllllllllIIlIlllllIIIII;
                final ByteBuffer llllllllllllllllllIIlIllllllIIlI = BufferUtils.createByteBuffer((int)(llllllllllllllllllIIlIlllllIIIII * llllllllllllllllllIIlIlllllIIIII * llllllllllllllllllIIlIlllllIIlIl));
                int llllllllllllllllllIIlIllllllIIIl = llllllllllllllllllIIlIlllllIllIl * llllllllllllllllllIIlIlllllIIIII * llllllllllllllllllIIlIlllllIIlIl;
                byte[] llllllllllllllllllIIlIllllllIIII = new byte[llllllllllllllllllIIlIllllllIlII * llllllllllllllllllIIlIlllllIIlIl];
                for (int llllllllllllllllllIIlIlllllllIIl = 0; llllllllllllllllllIIlIlllllllIIl < llllllllllllllllllIIlIllllllIIll; ++llllllllllllllllllIIlIlllllllIIl) {
                    int llllllllllllllllllIIlIlllllllIlI = (llllllllllllllllllIIlIlllllIlllI * llllllllllllllllllIIlIlllllIIIII + llllllllllllllllllIIlIlllllllIIl) * llllllllllllllllllIIlIlllllIIlll * llllllllllllllllllIIlIlllllIIlIl;
                    llllllllllllllllllIIlIlllllIlIlI.position(llllllllllllllllllIIlIlllllllIlI + llllllllllllllllllIIlIllllllIIIl);
                    llllllllllllllllllIIlIlllllIlIlI.get(llllllllllllllllllIIlIllllllIIII, 0, llllllllllllllllllIIlIllllllIlII * llllllllllllllllllIIlIlllllIIlIl);
                    llllllllllllllllllIIlIllllllIIlI.put(llllllllllllllllllIIlIllllllIIII);
                }
                llllllllllllllllllIIlIllllllIIlI.flip();
                ImageData llllllllllllllllllIIlIlllllIllll = new ImageData(){

                    @Override
                    public int getWidth() {
                        2 lllllllllllllllIlllIIlllIlllllll;
                        return lllllllllllllllIlllIIlllIlllllll.llllllllllllllllllIIlIllllllIllI;
                    }
                    {
                        2 lllllllllllllllIlllIIllllIIIlllI;
                    }

                    @Override
                    public ByteBuffer getImageBufferData() {
                        2 lllllllllllllllIlllIIlllIllllIll;
                        return lllllllllllllllIlllIIlllIllllIll.llllllllllllllllllIIlIllllllIIlI;
                    }

                    @Override
                    public int getTexWidth() {
                        2 lllllllllllllllIlllIIlllIlllIlIl;
                        return lllllllllllllllIlllIIlllIlllIlIl.llllllllllllllllllIIlIllllllIlII;
                    }

                    @Override
                    public int getHeight() {
                        2 lllllllllllllllIlllIIllllIIIIIlI;
                        return lllllllllllllllIlllIIllllIIIIIlI.llllllllllllllllllIIlIllllllIlIl;
                    }

                    @Override
                    public int getTexHeight() {
                        2 lllllllllllllllIlllIIlllIllllIIl;
                        return lllllllllllllllIlllIIlllIllllIIl.llllllllllllllllllIIlIllllllIIll;
                    }

                    @Override
                    public int getDepth() {
                        2 lllllllllllllllIlllIIllllIIIIlIl;
                        return lllllllllllllllIlllIIllllIIIIlIl.llllllllllllllllllIIlIlllllIlIll.getDepth();
                    }
                };
                llllllllllllllllllIIlIlllllIIlII.images[llllllllllllllllllIIlIlllllIllIl][llllllllllllllllllIIlIlllllIlllI] = new Image(llllllllllllllllllIIlIlllllIllll, llllllllllllllllllIIlIlllllIlIIl);
            }
        }
        llllllllllllllllllIIlIlllllIIlII.inited = true;
    }

    @Override
    protected void reinit() {
        throw new OperationNotSupportedException("Can't use big images as offscreen buffers");
    }

    @Override
    public void drawFlash(float llllllllllllllllllIIlIlIllIlIllI, float llllllllllllllllllIIlIlIllIIIlIl, float llllllllllllllllllIIlIlIllIIIIll, float llllllllllllllllllIIlIlIllIlIIIl) {
        BigImage llllllllllllllllllIIlIlIllIIlIIl;
        float llllllllllllllllllIIlIlIllIIllll = llllllllllllllllllIIlIlIllIIIIll / (float)llllllllllllllllllIIlIlIllIIlIIl.realWidth;
        float llllllllllllllllllIIlIlIllIIlllI = llllllllllllllllllIIlIlIllIlIIIl / (float)llllllllllllllllllIIlIlIllIIlIIl.realHeight;
        GL.glTranslatef(llllllllllllllllllIIlIlIllIlIllI, llllllllllllllllllIIlIlIllIIIlIl, 0.0f);
        GL.glScalef(llllllllllllllllllIIlIlIllIIllll, llllllllllllllllllIIlIlIllIIlllI, 1.0f);
        float llllllllllllllllllIIlIlIllIIllII = 0.0f;
        float llllllllllllllllllIIlIlIllIIlIll = 0.0f;
        for (int llllllllllllllllllIIlIlIllIllIII = 0; llllllllllllllllllIIlIlIllIllIII < llllllllllllllllllIIlIlIllIIlIIl.xcount; ++llllllllllllllllllIIlIlIllIllIII) {
            llllllllllllllllllIIlIlIllIIlIll = 0.0f;
            for (int llllllllllllllllllIIlIlIllIllIIl = 0; llllllllllllllllllIIlIlIllIllIIl < llllllllllllllllllIIlIlIllIIlIIl.ycount; ++llllllllllllllllllIIlIlIllIllIIl) {
                Image llllllllllllllllllIIlIlIllIllIlI = llllllllllllllllllIIlIlIllIIlIIl.images[llllllllllllllllllIIlIlIllIllIII][llllllllllllllllllIIlIlIllIllIIl];
                llllllllllllllllllIIlIlIllIllIlI.drawFlash(llllllllllllllllllIIlIlIllIIllII, llllllllllllllllllIIlIlIllIIlIll, llllllllllllllllllIIlIlIllIllIlI.getWidth(), llllllllllllllllllIIlIlIllIllIlI.getHeight());
                llllllllllllllllllIIlIlIllIIlIll += (float)llllllllllllllllllIIlIlIllIllIlI.getHeight();
                if (llllllllllllllllllIIlIlIllIllIIl != llllllllllllllllllIIlIlIllIIlIIl.ycount - 1) continue;
                llllllllllllllllllIIlIlIllIIllII += (float)llllllllllllllllllIIlIlIllIllIlI.getWidth();
            }
        }
        GL.glScalef(1.0f / llllllllllllllllllIIlIlIllIIllll, 1.0f / llllllllllllllllllIIlIlIllIIlllI, 1.0f);
        GL.glTranslatef(-llllllllllllllllllIIlIlIllIlIllI, -llllllllllllllllllIIlIlIllIIIlIl, 0.0f);
    }

    @Override
    public Texture getTexture() {
        throw new OperationNotSupportedException("Can't use big images as offscreen buffers");
    }

    @Override
    public void drawEmbedded(float llllllllllllllllllIIlIIlIlIlllII, float llllllllllllllllllIIlIIlIlIllIll, float llllllllllllllllllIIlIIlIlIllIlI, float llllllllllllllllllIIlIIlIlIllIIl, float llllllllllllllllllIIlIIlIlIllIII, float llllllllllllllllllIIlIIlIlIlIllI, float llllllllllllllllllIIlIIlIlIlIlIl, float llllllllllllllllllIIlIIlIlIlIIll, Color llllllllllllllllllIIlIIlIlIlIIIl) {
        throw new UnsupportedOperationException();
    }

    private BigImage() {
        BigImage llllllllllllllllllIIllIIIllIIIll;
        llllllllllllllllllIIllIIIllIIIll.inited = true;
    }

    public BigImage(String llllllllllllllllllIIllIIIlIlllIl) throws SlickException {
        llllllllllllllllllIIllIIIlIllllI(llllllllllllllllllIIllIIIlIlllIl, 2);
        BigImage llllllllllllllllllIIllIIIlIllllI;
    }

    @Override
    public void ensureInverted() {
        throw new OperationNotSupportedException("Doesn't make sense for tiled operations");
    }

    @Override
    public void draw(float llllllllllllllllllIIlIlllIlIlIIl, float llllllllllllllllllIIlIlllIlIIIll, float llllllllllllllllllIIlIlllIlIIIlI, Color llllllllllllllllllIIlIlllIlIIIIl) {
        BigImage llllllllllllllllllIIlIlllIlIIlIl;
        llllllllllllllllllIIlIlllIlIIlIl.draw(llllllllllllllllllIIlIlllIlIlIIl, llllllllllllllllllIIlIlllIlIIIll, (float)llllllllllllllllllIIlIlllIlIIlIl.width * llllllllllllllllllIIlIlllIlIIIlI, (float)llllllllllllllllllIIlIlllIlIIlIl.height * llllllllllllllllllIIlIlllIlIIIlI, llllllllllllllllllIIlIlllIlIIIIl);
    }

    @Override
    public void draw(float llllllllllllllllllIIlIllIllIlIlI, float llllllllllllllllllIIlIllIllIlIIl, float llllllllllllllllllIIlIllIllIlIII, float llllllllllllllllllIIlIllIllIIlll, float llllllllllllllllllIIlIllIllIIllI, float llllllllllllllllllIIlIllIlIlIlll, float llllllllllllllllllIIlIllIlIlIllI, float llllllllllllllllllIIlIllIllIIIll) {
        BigImage llllllllllllllllllIIlIllIlIlllIl;
        int llllllllllllllllllIIlIllIllIIIlI = (int)(llllllllllllllllllIIlIllIlIlIllI - llllllllllllllllllIIlIllIllIIllI);
        int llllllllllllllllllIIlIllIllIIIIl = (int)(llllllllllllllllllIIlIllIllIIIll - llllllllllllllllllIIlIllIlIlIlll);
        Image llllllllllllllllllIIlIllIllIIIII = llllllllllllllllllIIlIllIlIlllIl.getSubImage((int)llllllllllllllllllIIlIllIllIIllI, (int)llllllllllllllllllIIlIllIlIlIlll, llllllllllllllllllIIlIllIllIIIlI, llllllllllllllllllIIlIllIllIIIIl);
        int llllllllllllllllllIIlIllIlIlllll = (int)(llllllllllllllllllIIlIllIllIlIII - llllllllllllllllllIIlIllIllIlIlI);
        int llllllllllllllllllIIlIllIlIllllI = (int)(llllllllllllllllllIIlIllIllIIlll - llllllllllllllllllIIlIllIllIlIIl);
        llllllllllllllllllIIlIllIllIIIII.draw(llllllllllllllllllIIlIllIllIlIlI, llllllllllllllllllIIlIllIllIlIIl, (float)llllllllllllllllllIIlIllIlIlllll, llllllllllllllllllIIlIllIlIllllI);
    }

    public Image getTile(int llllllllllllllllllIIllIIIIlIlIII, int llllllllllllllllllIIllIIIIlIIlII) {
        BigImage llllllllllllllllllIIllIIIIlIIllI;
        return llllllllllllllllllIIllIIIIlIIllI.images[llllllllllllllllllIIllIIIIlIlIII][llllllllllllllllllIIllIIIIlIIlII];
    }

    @Override
    public void drawCentered(float llllllllllllllllllIIlIIlIllIIIlI, float llllllllllllllllllIIlIIlIllIIIII) {
        throw new UnsupportedOperationException();
    }

    public BigImage(LoadableImageData llllllllllllllllllIIllIIIIllIlIl, ByteBuffer llllllllllllllllllIIllIIIIlIllll, int llllllllllllllllllIIllIIIIlIlllI, int llllllllllllllllllIIllIIIIllIIlI) {
        BigImage llllllllllllllllllIIllIIIIllIllI;
        llllllllllllllllllIIllIIIIllIllI.build(llllllllllllllllllIIllIIIIllIlIl, llllllllllllllllllIIllIIIIlIllll, llllllllllllllllllIIllIIIIlIlllI, llllllllllllllllllIIllIIIIllIIlI);
    }

    @Override
    protected void initImpl() {
        throw new OperationNotSupportedException("Can't use big images as offscreen buffers");
    }

    @Override
    public void draw(float llllllllllllllllllIIlIIlIllllIll, float llllllllllllllllllIIlIIlIllllIIl, float llllllllllllllllllIIlIIllIIlIlII, float llllllllllllllllllIIlIIlIlllIlll, float llllllllllllllllllIIlIIllIIlIIII, float llllllllllllllllllIIlIIlIlllIlIl, float llllllllllllllllllIIlIIlIlllIIll, float llllllllllllllllllIIlIIllIIIlIlI, Color llllllllllllllllllIIlIIllIIIlIII) {
        BigImage llllllllllllllllllIIlIIllIIllIll;
        int llllllllllllllllllIIlIIllIIIIllI = (int)(llllllllllllllllllIIlIIlIlllIIll - llllllllllllllllllIIlIIllIIlIIII);
        int llllllllllllllllllIIlIIllIIIIlII = (int)(llllllllllllllllllIIlIIllIIIlIlI - llllllllllllllllllIIlIIlIlllIlIl);
        Image llllllllllllllllllIIlIIllIIIIIll = llllllllllllllllllIIlIIllIIllIll.getSubImage((int)llllllllllllllllllIIlIIllIIlIIII, (int)llllllllllllllllllIIlIIlIlllIlIl, llllllllllllllllllIIlIIllIIIIllI, llllllllllllllllllIIlIIllIIIIlII);
        int llllllllllllllllllIIlIIllIIIIIIl = (int)(llllllllllllllllllIIlIIllIIlIlII - llllllllllllllllllIIlIIlIllllIll);
        int llllllllllllllllllIIlIIlIlllllll = (int)(llllllllllllllllllIIlIIlIlllIlll - llllllllllllllllllIIlIIlIllllIIl);
        llllllllllllllllllIIlIIllIIIIIll.draw(llllllllllllllllllIIlIIlIllllIll, llllllllllllllllllIIlIIlIllllIIl, llllllllllllllllllIIlIIllIIIIIIl, llllllllllllllllllIIlIIlIlllllll, llllllllllllllllllIIlIIllIIIlIII);
    }

    @Override
    public void draw() {
        BigImage llllllllllllllllllIIlIllllIIIllI;
        llllllllllllllllllIIlIllllIIIllI.draw(0.0f, 0.0f);
    }

    static {
        GL = Renderer.get();
    }

    public BigImage(LoadableImageData llllllllllllllllllIIllIIIlIIIIlI, ByteBuffer llllllllllllllllllIIllIIIlIIIIIl, int llllllllllllllllllIIllIIIlIIIIII) {
        BigImage llllllllllllllllllIIllIIIIllllll;
        llllllllllllllllllIIllIIIIllllll.build(llllllllllllllllllIIllIIIlIIIIlI, llllllllllllllllllIIllIIIlIIIIIl, llllllllllllllllllIIllIIIlIIIIII, BigImage.getMaxSingleImageSize());
    }

    @Override
    public Image getScaledCopy(float llllllllllllllllllIIlIlIIllIlIII) {
        BigImage llllllllllllllllllIIlIlIIllIllII;
        return llllllllllllllllllIIlIlIIllIllII.getScaledCopy((int)(llllllllllllllllllIIlIlIIllIlIII * (float)llllllllllllllllllIIlIlIIllIllII.width), (int)(llllllllllllllllllIIlIlIIllIlIII * (float)llllllllllllllllllIIlIlIIllIllII.height));
    }

    @Override
    public void drawFlash(float llllllllllllllllllIIlIIlIIllllIl, float llllllllllllllllllIIlIIlIIlllIll, float llllllllllllllllllIIlIIlIIlllIIl, float llllllllllllllllllIIlIIlIIllIlll, Color llllllllllllllllllIIlIIlIIllIlIl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "[BIG IMAGE]";
    }

    @Override
    public void draw(float llllllllllllllllllIIlIllIIIlIIlI, float llllllllllllllllllIIlIllIIIlIlII) {
        BigImage llllllllllllllllllIIlIllIIIlIIll;
        llllllllllllllllllIIlIllIIIlIIll.draw(llllllllllllllllllIIlIllIIIlIIlI, llllllllllllllllllIIlIllIIIlIlII, Color.white);
    }

    @Override
    public Graphics getGraphics() throws SlickException {
        throw new OperationNotSupportedException("Can't use big images as offscreen buffers");
    }

    @Override
    public void draw(float llllllllllllllllllIIlIllIlIIIlIl, float llllllllllllllllllIIlIllIIlllIll, float llllllllllllllllllIIlIllIlIIIIll, float llllllllllllllllllIIlIllIIlllIIl, float llllllllllllllllllIIlIllIIlllIII, float llllllllllllllllllIIlIllIlIIIIII) {
        BigImage llllllllllllllllllIIlIllIIllllIl;
        int llllllllllllllllllIIlIllIIllllll = (int)(llllllllllllllllllIIlIllIIlllIII - llllllllllllllllllIIlIllIlIIIIll);
        int llllllllllllllllllIIlIllIIlllllI = (int)(llllllllllllllllllIIlIllIlIIIIII - llllllllllllllllllIIlIllIIlllIIl);
        llllllllllllllllllIIlIllIIllllIl.draw(llllllllllllllllllIIlIllIlIIIlIl, llllllllllllllllllIIlIllIIlllIll, llllllllllllllllllIIlIllIIllllll, llllllllllllllllllIIlIllIIlllllI, llllllllllllllllllIIlIllIlIIIIll, llllllllllllllllllIIlIllIIlllIIl, llllllllllllllllllIIlIllIIlllIII, llllllllllllllllllIIlIllIlIIIIII);
    }

    public BigImage(String llllllllllllllllllIIllIIIlIlIlIl, int llllllllllllllllllIIllIIIlIlIlll) throws SlickException {
        BigImage llllllllllllllllllIIllIIIlIlIllI;
        llllllllllllllllllIIllIIIlIlIllI.build(llllllllllllllllllIIllIIIlIlIlIl, llllllllllllllllllIIllIIIlIlIlll, BigImage.getMaxSingleImageSize());
    }

    public int getVerticalImageCount() {
        BigImage llllllllllllllllllIIlIIlllIlIlII;
        return llllllllllllllllllIIlIIlllIlIlII.ycount;
    }

    @Override
    public void setTexture(Texture llllllllllllllllllIIlIIllllIIllI) {
        throw new OperationNotSupportedException("Can't use big images as offscreen buffers");
    }

    @Override
    public Image getScaledCopy(int llllllllllllllllllIIlIlIIlIlIllI, int llllllllllllllllllIIlIlIIlIlIlIl) {
        BigImage llllllllllllllllllIIlIlIIlIlIlll;
        BigImage llllllllllllllllllIIlIlIIlIllIII = new BigImage();
        llllllllllllllllllIIlIlIIlIllIII.images = llllllllllllllllllIIlIlIIlIlIlll.images;
        llllllllllllllllllIIlIlIIlIllIII.xcount = llllllllllllllllllIIlIlIIlIlIlll.xcount;
        llllllllllllllllllIIlIlIIlIllIII.ycount = llllllllllllllllllIIlIlIIlIlIlll.ycount;
        llllllllllllllllllIIlIlIIlIllIII.width = llllllllllllllllllIIlIlIIlIlIllI;
        llllllllllllllllllIIlIlIIlIllIII.height = llllllllllllllllllIIlIlIIlIlIlIl;
        llllllllllllllllllIIlIlIIlIllIII.realWidth = llllllllllllllllllIIlIlIIlIlIlll.realWidth;
        llllllllllllllllllIIlIlIIlIllIII.realHeight = llllllllllllllllllIIlIlIIlIlIlll.realHeight;
        return llllllllllllllllllIIlIlIIlIllIII;
    }

    @Override
    public void drawEmbedded(float llllllllllllllllllIIlIllIIIIIIII, float llllllllllllllllllIIlIlIllllllll, float llllllllllllllllllIIlIlIllllIlIl, float llllllllllllllllllIIlIlIllllllIl) {
        BigImage llllllllllllllllllIIlIllIIIIIIIl;
        float llllllllllllllllllIIlIlIllllllII = llllllllllllllllllIIlIlIllllIlIl / (float)llllllllllllllllllIIlIllIIIIIIIl.realWidth;
        float llllllllllllllllllIIlIlIlllllIll = llllllllllllllllllIIlIlIllllllIl / (float)llllllllllllllllllIIlIllIIIIIIIl.realHeight;
        float llllllllllllllllllIIlIlIlllllIlI = 0.0f;
        float llllllllllllllllllIIlIlIlllllIIl = 0.0f;
        for (int llllllllllllllllllIIlIllIIIIIIlI = 0; llllllllllllllllllIIlIllIIIIIIlI < llllllllllllllllllIIlIllIIIIIIIl.xcount; ++llllllllllllllllllIIlIllIIIIIIlI) {
            llllllllllllllllllIIlIlIlllllIIl = 0.0f;
            for (int llllllllllllllllllIIlIllIIIIIIll = 0; llllllllllllllllllIIlIllIIIIIIll < llllllllllllllllllIIlIllIIIIIIIl.ycount; ++llllllllllllllllllIIlIllIIIIIIll) {
                Image llllllllllllllllllIIlIllIIIIIlII = llllllllllllllllllIIlIllIIIIIIIl.images[llllllllllllllllllIIlIllIIIIIIlI][llllllllllllllllllIIlIllIIIIIIll];
                if (lastBind == null || llllllllllllllllllIIlIllIIIIIlII.getTexture() != lastBind.getTexture()) {
                    if (lastBind != null) {
                        lastBind.endUse();
                    }
                    lastBind = llllllllllllllllllIIlIllIIIIIlII;
                    lastBind.startUse();
                }
                llllllllllllllllllIIlIllIIIIIlII.drawEmbedded(llllllllllllllllllIIlIlIlllllIlI + llllllllllllllllllIIlIllIIIIIIII, llllllllllllllllllIIlIlIlllllIIl + llllllllllllllllllIIlIlIllllllll, llllllllllllllllllIIlIllIIIIIlII.getWidth(), llllllllllllllllllIIlIllIIIIIlII.getHeight());
                llllllllllllllllllIIlIlIlllllIIl += (float)llllllllllllllllllIIlIllIIIIIlII.getHeight();
                if (llllllllllllllllllIIlIllIIIIIIll != llllllllllllllllllIIlIllIIIIIIIl.ycount - 1) continue;
                llllllllllllllllllIIlIlIlllllIlI += (float)llllllllllllllllllIIlIllIIIIIlII.getWidth();
            }
        }
    }

    @Override
    public void drawFlash(float llllllllllllllllllIIlIlIlIlIlIII, float llllllllllllllllllIIlIlIlIlIllII) {
        BigImage llllllllllllllllllIIlIlIlIlIllll;
        llllllllllllllllllIIlIlIlIlIllll.drawFlash(llllllllllllllllllIIlIlIlIlIlIII, llllllllllllllllllIIlIlIlIlIllII, llllllllllllllllllIIlIlIlIlIllll.width, llllllllllllllllllIIlIlIlIlIllll.height);
    }

    public int getHorizontalImageCount() {
        BigImage llllllllllllllllllIIlIIlllIllIll;
        return llllllllllllllllllIIlIIlllIllIll.xcount;
    }

    private void build(String llllllllllllllllllIIllIIIIIlIlIl, int llllllllllllllllllIIllIIIIIlIlII, int llllllllllllllllllIIllIIIIIlIlll) throws SlickException {
        try {
            BigImage llllllllllllllllllIIllIIIIIllIlI;
            LoadableImageData llllllllllllllllllIIllIIIIIlllIl = ImageDataFactory.getImageDataFor(llllllllllllllllllIIllIIIIIlIlIl);
            ByteBuffer llllllllllllllllllIIllIIIIIlllII = llllllllllllllllllIIllIIIIIlllIl.loadImage(ResourceLoader.getResourceAsStream(llllllllllllllllllIIllIIIIIlIlIl), false, null);
            llllllllllllllllllIIllIIIIIllIlI.build(llllllllllllllllllIIllIIIIIlllIl, llllllllllllllllllIIllIIIIIlllII, llllllllllllllllllIIllIIIIIlIlII, llllllllllllllllllIIllIIIIIlIlll);
        }
        catch (IOException llllllllllllllllllIIllIIIIIllIll) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load: ").append(llllllllllllllllllIIllIIIIIlIlIl)), llllllllllllllllllIIllIIIIIllIll);
        }
    }

    public BigImage(String llllllllllllllllllIIllIIIlIIlIlI, int llllllllllllllllllIIllIIIlIIlIIl, int llllllllllllllllllIIllIIIlIIllII) throws SlickException {
        BigImage llllllllllllllllllIIllIIIlIIllll;
        llllllllllllllllllIIllIIIlIIllll.build(llllllllllllllllllIIllIIIlIIlIlI, llllllllllllllllllIIllIIIlIIlIIl, llllllllllllllllllIIllIIIlIIllII);
    }

    @Override
    public Image copy() {
        throw new OperationNotSupportedException("Can't copy big images yet");
    }

    @Override
    public void drawEmbedded(float llllllllllllllllllIIlIIlIlIIllII, float llllllllllllllllllIIlIIlIlIIlIlI, float llllllllllllllllllIIlIIlIlIIlIIl, float llllllllllllllllllIIlIIlIlIIlIII, float llllllllllllllllllIIlIIlIlIIIllI, float llllllllllllllllllIIlIIlIlIIIlII, float llllllllllllllllllIIlIIlIlIIIIlI, float llllllllllllllllllIIlIIlIlIIIIIl) {
        throw new UnsupportedOperationException();
    }

    public Image getSubImage(int llllllllllllllllllIIlIIlllIllllI, int llllllllllllllllllIIlIIllllIIIII) {
        BigImage llllllllllllllllllIIlIIllllIIIlI;
        return llllllllllllllllllIIlIIllllIIIlI.images[llllllllllllllllllIIlIIlllIllllI][llllllllllllllllllIIlIIllllIIIII];
    }

    public static final int getMaxSingleImageSize() {
        IntBuffer llllllllllllllllllIIllIIIllIIlll = BufferUtils.createIntBuffer((int)16);
        GL.glGetInteger(3379, llllllllllllllllllIIllIIIllIIlll);
        return llllllllllllllllllIIllIIIllIIlll.get(0);
    }

    @Override
    public void draw(float llllllllllllllllllIIlIlllIllIllI, float llllllllllllllllllIIlIlllIllIlIl, Color llllllllllllllllllIIlIlllIllIIII) {
        BigImage llllllllllllllllllIIlIlllIllIIll;
        llllllllllllllllllIIlIlllIllIIll.draw(llllllllllllllllllIIlIlllIllIllI, llllllllllllllllllIIlIlllIllIlIl, llllllllllllllllllIIlIlllIllIIll.width, llllllllllllllllllIIlIlllIllIIll.height, llllllllllllllllllIIlIlllIllIIII);
    }

    @Override
    public Image getSubImage(int llllllllllllllllllIIlIlIIIIlIIlI, int llllllllllllllllllIIlIlIIIIIIIIl, int llllllllllllllllllIIlIlIIIIIIIII, int llllllllllllllllllIIlIlIIIIIllIl) {
        BigImage llllllllllllllllllIIlIlIIIIIIIll;
        BigImage llllllllllllllllllIIlIlIIIIIlIll = new BigImage();
        llllllllllllllllllIIlIlIIIIIlIll.width = llllllllllllllllllIIlIlIIIIIIIII;
        llllllllllllllllllIIlIlIIIIIlIll.height = llllllllllllllllllIIlIlIIIIIllIl;
        llllllllllllllllllIIlIlIIIIIlIll.realWidth = llllllllllllllllllIIlIlIIIIIIIII;
        llllllllllllllllllIIlIlIIIIIlIll.realHeight = llllllllllllllllllIIlIlIIIIIllIl;
        llllllllllllllllllIIlIlIIIIIlIll.images = new Image[llllllllllllllllllIIlIlIIIIIIIll.xcount][llllllllllllllllllIIlIlIIIIIIIll.ycount];
        float llllllllllllllllllIIlIlIIIIIlIlI = 0.0f;
        float llllllllllllllllllIIlIlIIIIIlIIl = 0.0f;
        int llllllllllllllllllIIlIlIIIIIlIII = llllllllllllllllllIIlIlIIIIlIIlI + llllllllllllllllllIIlIlIIIIIIIII;
        int llllllllllllllllllIIlIlIIIIIIlll = llllllllllllllllllIIlIlIIIIIIIIl + llllllllllllllllllIIlIlIIIIIllIl;
        int llllllllllllllllllIIlIlIIIIIIllI = 0;
        int llllllllllllllllllIIlIlIIIIIIlIl = 0;
        boolean llllllllllllllllllIIlIlIIIIIIlII = false;
        for (int llllllllllllllllllIIlIlIIIIlIllI = 0; llllllllllllllllllIIlIlIIIIlIllI < llllllllllllllllllIIlIlIIIIIIIll.xcount; ++llllllllllllllllllIIlIlIIIIlIllI) {
            llllllllllllllllllIIlIlIIIIIlIIl = 0.0f;
            llllllllllllllllllIIlIlIIIIIIlIl = 0;
            llllllllllllllllllIIlIlIIIIIIlII = false;
            for (int llllllllllllllllllIIlIlIIIIllIII = 0; llllllllllllllllllIIlIlIIIIllIII < llllllllllllllllllIIlIlIIIIIIIll.ycount; ++llllllllllllllllllIIlIlIIIIllIII) {
                Image llllllllllllllllllIIlIlIIIlIIllI = llllllllllllllllllIIlIlIIIIIIIll.images[llllllllllllllllllIIlIlIIIIlIllI][llllllllllllllllllIIlIlIIIIllIII];
                int llllllllllllllllllIIlIlIIIlIIlII = (int)(llllllllllllllllllIIlIlIIIIIlIlI + (float)llllllllllllllllllIIlIlIIIlIIllI.getWidth());
                int llllllllllllllllllIIlIlIIIlIIIll = (int)(llllllllllllllllllIIlIlIIIIIlIIl + (float)llllllllllllllllllIIlIlIIIlIIllI.getHeight());
                int llllllllllllllllllIIlIlIIIlIIIIl = (int)Math.max((float)llllllllllllllllllIIlIlIIIIlIIlI, llllllllllllllllllIIlIlIIIIIlIlI);
                int llllllllllllllllllIIlIlIIIlIIIII = (int)Math.max((float)llllllllllllllllllIIlIlIIIIIIIIl, llllllllllllllllllIIlIlIIIIIlIIl);
                int llllllllllllllllllIIlIlIIIIllllI = Math.min(llllllllllllllllllIIlIlIIIIIlIII, llllllllllllllllllIIlIlIIIlIIlII);
                int llllllllllllllllllIIlIlIIIIlllIl = Math.min(llllllllllllllllllIIlIlIIIIIIlll, llllllllllllllllllIIlIlIIIlIIIll);
                int llllllllllllllllllIIlIlIIIIllIll = llllllllllllllllllIIlIlIIIIllllI - llllllllllllllllllIIlIlIIIlIIIIl;
                int llllllllllllllllllIIlIlIIIIllIIl = llllllllllllllllllIIlIlIIIIlllIl - llllllllllllllllllIIlIlIIIlIIIII;
                if (llllllllllllllllllIIlIlIIIIllIll > 0 && llllllllllllllllllIIlIlIIIIllIIl > 0) {
                    Image llllllllllllllllllIIlIlIIIlIIlll = llllllllllllllllllIIlIlIIIlIIllI.getSubImage((int)((float)llllllllllllllllllIIlIlIIIlIIIIl - llllllllllllllllllIIlIlIIIIIlIlI), (int)((float)llllllllllllllllllIIlIlIIIlIIIII - llllllllllllllllllIIlIlIIIIIlIIl), llllllllllllllllllIIlIlIIIIllllI - llllllllllllllllllIIlIlIIIlIIIIl, llllllllllllllllllIIlIlIIIIlllIl - llllllllllllllllllIIlIlIIIlIIIII);
                    llllllllllllllllllIIlIlIIIIIIlII = true;
                    llllllllllllllllllIIlIlIIIIIlIll.images[llllllllllllllllllIIlIlIIIIIIllI][llllllllllllllllllIIlIlIIIIIIlIl] = llllllllllllllllllIIlIlIIIlIIlll;
                    llllllllllllllllllIIlIlIIIIIlIll.ycount = Math.max(llllllllllllllllllIIlIlIIIIIlIll.ycount, ++llllllllllllllllllIIlIlIIIIIIlIl);
                }
                llllllllllllllllllIIlIlIIIIIlIIl += (float)llllllllllllllllllIIlIlIIIlIIllI.getHeight();
                if (llllllllllllllllllIIlIlIIIIllIII != llllllllllllllllllIIlIlIIIIIIIll.ycount - 1) continue;
                llllllllllllllllllIIlIlIIIIIlIlI += (float)llllllllllllllllllIIlIlIIIlIIllI.getWidth();
            }
            if (!llllllllllllllllllIIlIlIIIIIIlII) continue;
            ++llllllllllllllllllIIlIlIIIIIIllI;
            ++llllllllllllllllllIIlIlIIIIIlIll.xcount;
        }
        return llllllllllllllllllIIlIlIIIIIlIll;
    }

    @Override
    public void draw(float llllllllllllllllllIIlIllIIlIlIIl, float llllllllllllllllllIIlIllIIlIlIII, float llllllllllllllllllIIlIllIIlIIlll, float llllllllllllllllllIIlIllIIlIlIll) {
        BigImage llllllllllllllllllIIlIllIIlIlIlI;
        llllllllllllllllllIIlIllIIlIlIlI.draw(llllllllllllllllllIIlIllIIlIlIIl, llllllllllllllllllIIlIllIIlIlIII, llllllllllllllllllIIlIllIIlIIlll, llllllllllllllllllIIlIllIIlIlIll, Color.white);
    }

    @Override
    public void draw(float llllllllllllllllllIIlIlllIIIIlIl, float llllllllllllllllllIIlIlllIIIlllI, float llllllllllllllllllIIlIlllIIIIIll, float llllllllllllllllllIIlIlllIIIllII, Color llllllllllllllllllIIlIlllIIIlIll) {
        BigImage llllllllllllllllllIIlIlllIIIIllI;
        float llllllllllllllllllIIlIlllIIIlIlI = llllllllllllllllllIIlIlllIIIIIll / (float)llllllllllllllllllIIlIlllIIIIllI.realWidth;
        float llllllllllllllllllIIlIlllIIIlIIl = llllllllllllllllllIIlIlllIIIllII / (float)llllllllllllllllllIIlIlllIIIIllI.realHeight;
        GL.glTranslatef(llllllllllllllllllIIlIlllIIIIlIl, llllllllllllllllllIIlIlllIIIlllI, 0.0f);
        GL.glScalef(llllllllllllllllllIIlIlllIIIlIlI, llllllllllllllllllIIlIlllIIIlIIl, 1.0f);
        float llllllllllllllllllIIlIlllIIIlIII = 0.0f;
        float llllllllllllllllllIIlIlllIIIIlll = 0.0f;
        for (int llllllllllllllllllIIlIlllIIlIIIl = 0; llllllllllllllllllIIlIlllIIlIIIl < llllllllllllllllllIIlIlllIIIIllI.xcount; ++llllllllllllllllllIIlIlllIIlIIIl) {
            llllllllllllllllllIIlIlllIIIIlll = 0.0f;
            for (int llllllllllllllllllIIlIlllIIlIIlI = 0; llllllllllllllllllIIlIlllIIlIIlI < llllllllllllllllllIIlIlllIIIIllI.ycount; ++llllllllllllllllllIIlIlllIIlIIlI) {
                Image llllllllllllllllllIIlIlllIIlIIll = llllllllllllllllllIIlIlllIIIIllI.images[llllllllllllllllllIIlIlllIIlIIIl][llllllllllllllllllIIlIlllIIlIIlI];
                llllllllllllllllllIIlIlllIIlIIll.draw(llllllllllllllllllIIlIlllIIIlIII, llllllllllllllllllIIlIlllIIIIlll, llllllllllllllllllIIlIlllIIlIIll.getWidth(), llllllllllllllllllIIlIlllIIlIIll.getHeight(), llllllllllllllllllIIlIlllIIIlIll);
                llllllllllllllllllIIlIlllIIIIlll += (float)llllllllllllllllllIIlIlllIIlIIll.getHeight();
                if (llllllllllllllllllIIlIlllIIlIIlI != llllllllllllllllllIIlIlllIIIIllI.ycount - 1) continue;
                llllllllllllllllllIIlIlllIIIlIII += (float)llllllllllllllllllIIlIlllIIlIIll.getWidth();
            }
        }
        GL.glScalef(1.0f / llllllllllllllllllIIlIlllIIIlIlI, 1.0f / llllllllllllllllllIIlIlllIIIlIIl, 1.0f);
        GL.glTranslatef(-llllllllllllllllllIIlIlllIIIIlIl, -llllllllllllllllllIIlIlllIIIlllI, 0.0f);
    }

    @Override
    public Image getFlippedCopy(boolean llllllllllllllllllIIlIlIIlllIlIl, boolean llllllllllllllllllIIlIlIIlllIlII) {
        BigImage llllllllllllllllllIIlIlIIlllIllI;
        BigImage llllllllllllllllllIIlIlIIlllIlll = new BigImage();
        llllllllllllllllllIIlIlIIlllIlll.images = llllllllllllllllllIIlIlIIlllIllI.images;
        llllllllllllllllllIIlIlIIlllIlll.xcount = llllllllllllllllllIIlIlIIlllIllI.xcount;
        llllllllllllllllllIIlIlIIlllIlll.ycount = llllllllllllllllllIIlIlIIlllIllI.ycount;
        llllllllllllllllllIIlIlIIlllIlll.width = llllllllllllllllllIIlIlIIlllIllI.width;
        llllllllllllllllllIIlIlIIlllIlll.height = llllllllllllllllllIIlIlIIlllIllI.height;
        llllllllllllllllllIIlIlIIlllIlll.realWidth = llllllllllllllllllIIlIlIIlllIllI.realWidth;
        llllllllllllllllllIIlIlIIlllIlll.realHeight = llllllllllllllllllIIlIlIIlllIllI.realHeight;
        if (llllllllllllllllllIIlIlIIlllIlIl) {
            Image[][] llllllllllllllllllIIlIlIlIIIIIlI = llllllllllllllllllIIlIlIIlllIlll.images;
            llllllllllllllllllIIlIlIIlllIlll.images = new Image[llllllllllllllllllIIlIlIIlllIllI.xcount][llllllllllllllllllIIlIlIIlllIllI.ycount];
            for (int llllllllllllllllllIIlIlIlIIIIIll = 0; llllllllllllllllllIIlIlIlIIIIIll < llllllllllllllllllIIlIlIIlllIllI.xcount; ++llllllllllllllllllIIlIlIlIIIIIll) {
                for (int llllllllllllllllllIIlIlIlIIIIlIl = 0; llllllllllllllllllIIlIlIlIIIIlIl < llllllllllllllllllIIlIlIIlllIllI.ycount; ++llllllllllllllllllIIlIlIlIIIIlIl) {
                    llllllllllllllllllIIlIlIIlllIlll.images[llllllllllllllllllIIlIlIlIIIIIll][llllllllllllllllllIIlIlIlIIIIlIl] = llllllllllllllllllIIlIlIlIIIIIlI[llllllllllllllllllIIlIlIIlllIllI.xcount - 1 - llllllllllllllllllIIlIlIlIIIIIll][llllllllllllllllllIIlIlIlIIIIlIl].getFlippedCopy(true, false);
                }
            }
        }
        if (llllllllllllllllllIIlIlIIlllIlII) {
            Image[][] llllllllllllllllllIIlIlIIlllllIl = llllllllllllllllllIIlIlIIlllIlll.images;
            llllllllllllllllllIIlIlIIlllIlll.images = new Image[llllllllllllllllllIIlIlIIlllIllI.xcount][llllllllllllllllllIIlIlIIlllIllI.ycount];
            for (int llllllllllllllllllIIlIlIIlllllll = 0; llllllllllllllllllIIlIlIIlllllll < llllllllllllllllllIIlIlIIlllIllI.xcount; ++llllllllllllllllllIIlIlIIlllllll) {
                for (int llllllllllllllllllIIlIlIlIIIIIII = 0; llllllllllllllllllIIlIlIlIIIIIII < llllllllllllllllllIIlIlIIlllIllI.ycount; ++llllllllllllllllllIIlIlIlIIIIIII) {
                    llllllllllllllllllIIlIlIIlllIlll.images[llllllllllllllllllIIlIlIIlllllll][llllllllllllllllllIIlIlIlIIIIIII] = llllllllllllllllllIIlIlIIlllllIl[llllllllllllllllllIIlIlIIlllllll][llllllllllllllllllIIlIlIIlllIllI.ycount - 1 - llllllllllllllllllIIlIlIlIIIIIII].getFlippedCopy(false, true);
                }
            }
        }
        return llllllllllllllllllIIlIlIIlllIlll;
    }

    @Override
    public void draw(float llllllllllllllllllIIlIllIIIlllII, float llllllllllllllllllIIlIllIIIlllll, float llllllllllllllllllIIlIllIIIllIlI) {
        BigImage llllllllllllllllllIIlIllIIlIIIIl;
        llllllllllllllllllIIlIllIIlIIIIl.draw(llllllllllllllllllIIlIllIIIlllII, llllllllllllllllllIIlIllIIIlllll, llllllllllllllllllIIlIllIIIllIlI, Color.white);
    }

    @Override
    public void endUse() {
        if (lastBind != null) {
            lastBind.endUse();
        }
        lastBind = null;
    }

    @Override
    public void startUse() {
    }

    @Override
    public void destroy() throws SlickException {
        BigImage llllllllllllllllllIIlIIllIllllll;
        for (int llllllllllllllllllIIlIIlllIIIIII = 0; llllllllllllllllllIIlIIlllIIIIII < llllllllllllllllllIIlIIllIllllll.xcount; ++llllllllllllllllllIIlIIlllIIIIII) {
            for (int llllllllllllllllllIIlIIlllIIIIIl = 0; llllllllllllllllllIIlIIlllIIIIIl < llllllllllllllllllIIlIIllIllllll.ycount; ++llllllllllllllllllIIlIIlllIIIIIl) {
                Image llllllllllllllllllIIlIIlllIIIIlI = llllllllllllllllllIIlIIllIllllll.images[llllllllllllllllllIIlIIlllIIIIII][llllllllllllllllllIIlIIlllIIIIIl];
                llllllllllllllllllIIlIIlllIIIIlI.destroy();
            }
        }
    }
}

