/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick.opengl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.DeferredTexture;
import org.newdawn.slick.opengl.EmptyImageData;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.ImageDataFactory;
import org.newdawn.slick.opengl.LoadableImageData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.ResourceLoader;

public class InternalTextureLoader {
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ HashMap texturesLinear;
    private /* synthetic */ boolean holdTextureData;
    private /* synthetic */ boolean deferred;
    private static final /* synthetic */ InternalTextureLoader loader;
    private /* synthetic */ int dstPixelFormat;
    private /* synthetic */ HashMap texturesNearest;

    public void reload() {
        InternalTextureLoader lllllllllllllllllIlllIlIIlIlllII;
        Iterator lllllllllllllllllIlllIlIIlIlllIl = lllllllllllllllllIlllIlIIlIlllII.texturesLinear.values().iterator();
        while (lllllllllllllllllIlllIlIIlIlllIl.hasNext()) {
            ((TextureImpl)lllllllllllllllllIlllIlIIlIlllIl.next()).reload();
        }
        lllllllllllllllllIlllIlIIlIlllIl = lllllllllllllllllIlllIlIIlIlllII.texturesNearest.values().iterator();
        while (lllllllllllllllllIlllIlIIlIlllIl.hasNext()) {
            ((TextureImpl)lllllllllllllllllIlllIlIIlIlllIl.next()).reload();
        }
    }

    public void set16BitMode() {
        lllllllllllllllllIllllIlIllIIllI.dstPixelFormat = 32859;
    }

    public Texture createTexture(int lllllllllllllllllIlllIlllIIlllII, int lllllllllllllllllIlllIlllIIlIllI) throws IOException {
        InternalTextureLoader lllllllllllllllllIlllIlllIIllIII;
        return lllllllllllllllllIlllIlllIIllIII.createTexture(lllllllllllllllllIlllIlllIIlllII, lllllllllllllllllIlllIlllIIlIllI, 9728);
    }

    public Texture getTexture(File lllllllllllllllllIllllIlIIIlllll, boolean lllllllllllllllllIllllIlIIIlllII, int lllllllllllllllllIllllIlIIIIllII, int[] lllllllllllllllllIllllIlIIIIlIlI) throws IOException {
        InternalTextureLoader lllllllllllllllllIllllIlIIlIIIII;
        String lllllllllllllllllIllllIlIIIlIllI = lllllllllllllllllIllllIlIIIlllll.getAbsolutePath();
        FileInputStream lllllllllllllllllIllllIlIIIlIlII = new FileInputStream(lllllllllllllllllIllllIlIIIlllll);
        return lllllllllllllllllIllllIlIIlIIIII.getTexture(lllllllllllllllllIllllIlIIIlIlII, lllllllllllllllllIllllIlIIIlIllI, lllllllllllllllllIllllIlIIIlllII, lllllllllllllllllIllllIlIIIIllII, lllllllllllllllllIllllIlIIIIlIlI);
    }

    static {
        GL = Renderer.get();
        loader = new InternalTextureLoader();
    }

    public void clear(String lllllllllllllllllIllllIlIllIllIl) {
        InternalTextureLoader lllllllllllllllllIllllIlIllIllII;
        lllllllllllllllllIllllIlIllIllII.texturesLinear.remove(lllllllllllllllllIllllIlIllIllIl);
        lllllllllllllllllIllllIlIllIllII.texturesNearest.remove(lllllllllllllllllIllllIlIllIllIl);
    }

    public void setHoldTextureData(boolean lllllllllllllllllIllllIllIIIIIlI) {
        lllllllllllllllllIllllIllIIIlIII.holdTextureData = lllllllllllllllllIllllIllIIIIIlI;
    }

    public static int createTextureID() {
        IntBuffer lllllllllllllllllIllllIlIllIIIII = InternalTextureLoader.createIntBuffer(1);
        GL.glGenTextures(lllllllllllllllllIllllIlIllIIIII);
        return lllllllllllllllllIllllIlIllIIIII.get(0);
    }

    public TextureImpl getTexture(InputStream lllllllllllllllllIllllIIIlIIlIll, String lllllllllllllllllIllllIIIlIIIIIl, boolean lllllllllllllllllIllllIIIlIIlIIl, int lllllllllllllllllIllllIIIlIIlIII, int[] lllllllllllllllllIllllIIIIlllllI) throws IOException {
        InternalTextureLoader lllllllllllllllllIllllIIIlIIIIll;
        if (lllllllllllllllllIllllIIIlIIIIll.deferred) {
            return new DeferredTexture(lllllllllllllllllIllllIIIlIIlIll, lllllllllllllllllIllllIIIlIIIIIl, lllllllllllllllllIllllIIIlIIlIIl, lllllllllllllllllIllllIIIlIIlIII, lllllllllllllllllIllllIIIIlllllI);
        }
        HashMap lllllllllllllllllIllllIIIlIIIllI = lllllllllllllllllIllllIIIlIIIIll.texturesLinear;
        if (lllllllllllllllllIllllIIIlIIlIII == 9728) {
            lllllllllllllllllIllllIIIlIIIllI = lllllllllllllllllIllllIIIlIIIIll.texturesNearest;
        }
        String lllllllllllllllllIllllIIIlIIIlIl = lllllllllllllllllIllllIIIlIIIIIl;
        if (lllllllllllllllllIllllIIIIlllllI != null) {
            lllllllllllllllllIllllIIIlIIIlIl = String.valueOf(new StringBuilder().append(lllllllllllllllllIllllIIIlIIIlIl).append(":").append(lllllllllllllllllIllllIIIIlllllI[0]).append(":").append(lllllllllllllllllIllllIIIIlllllI[1]).append(":").append(lllllllllllllllllIllllIIIIlllllI[2]));
        }
        lllllllllllllllllIllllIIIlIIIlIl = String.valueOf(new StringBuilder().append(lllllllllllllllllIllllIIIlIIIlIl).append(":").append(lllllllllllllllllIllllIIIlIIlIIl));
        if (lllllllllllllllllIllllIIIlIIIIll.holdTextureData) {
            TextureImpl lllllllllllllllllIllllIIIlIlIIII = (TextureImpl)lllllllllllllllllIllllIIIlIIIllI.get(lllllllllllllllllIllllIIIlIIIlIl);
            if (lllllllllllllllllIllllIIIlIlIIII != null) {
                return lllllllllllllllllIllllIIIlIlIIII;
            }
        } else {
            SoftReference lllllllllllllllllIllllIIIlIIlllI = (SoftReference)lllllllllllllllllIllllIIIlIIIllI.get(lllllllllllllllllIllllIIIlIIIlIl);
            if (lllllllllllllllllIllllIIIlIIlllI != null) {
                TextureImpl lllllllllllllllllIllllIIIlIIllll = (TextureImpl)lllllllllllllllllIllllIIIlIIlllI.get();
                if (lllllllllllllllllIllllIIIlIIllll != null) {
                    return lllllllllllllllllIllllIIIlIIllll;
                }
                lllllllllllllllllIllllIIIlIIIllI.remove(lllllllllllllllllIllllIIIlIIIlIl);
            }
        }
        try {
            GL.glGetError();
        }
        catch (NullPointerException lllllllllllllllllIllllIIIlIIllIl) {
            throw new RuntimeException("Image based resources must be loaded as part of init() or the game loop. They cannot be loaded before initialisation.");
        }
        TextureImpl lllllllllllllllllIllllIIIlIIIlII = lllllllllllllllllIllllIIIlIIIIll.getTexture(lllllllllllllllllIllllIIIlIIlIll, lllllllllllllllllIllllIIIlIIIIIl, 3553, lllllllllllllllllIllllIIIlIIlIII, lllllllllllllllllIllllIIIlIIlIII, lllllllllllllllllIllllIIIlIIlIIl, lllllllllllllllllIllllIIIIlllllI);
        lllllllllllllllllIllllIIIlIIIlII.setCacheName(lllllllllllllllllIllllIIIlIIIlIl);
        if (lllllllllllllllllIllllIIIlIIIIll.holdTextureData) {
            lllllllllllllllllIllllIIIlIIIllI.put(lllllllllllllllllIllllIIIlIIIlIl, lllllllllllllllllIllllIIIlIIIlII);
        } else {
            lllllllllllllllllIllllIIIlIIIllI.put(lllllllllllllllllIllllIIIlIIIlIl, new SoftReference<TextureImpl>(lllllllllllllllllIllllIIIlIIIlII));
        }
        return lllllllllllllllllIllllIIIlIIIlII;
    }

    public Texture createTexture(int lllllllllllllllllIlllIlllIIIlIlI, int lllllllllllllllllIlllIlllIIIlIIl, int lllllllllllllllllIlllIlllIIIllIl) throws IOException {
        InternalTextureLoader lllllllllllllllllIlllIlllIIIlIll;
        EmptyImageData lllllllllllllllllIlllIlllIIIllII = new EmptyImageData(lllllllllllllllllIlllIlllIIIlIlI, lllllllllllllllllIlllIlllIIIlIIl);
        return lllllllllllllllllIlllIlllIIIlIll.getTexture(lllllllllllllllllIlllIlllIIIllII, lllllllllllllllllIlllIlllIIIllIl);
    }

    private TextureImpl getTexture(InputStream lllllllllllllllllIlllIlllllIIIIl, String lllllllllllllllllIlllIllllIlllll, int lllllllllllllllllIlllIlllIllllII, int lllllllllllllllllIlllIllllIllIll, int lllllllllllllllllIlllIlllIlllIlI, boolean lllllllllllllllllIlllIlllIllIllI, int[] lllllllllllllllllIlllIllllIlIlII) throws IOException {
        InternalTextureLoader lllllllllllllllllIlllIllllIIIIIl;
        LoadableImageData lllllllllllllllllIlllIllllIlIIII = ImageDataFactory.getImageDataFor(lllllllllllllllllIlllIllllIlllll);
        ByteBuffer lllllllllllllllllIlllIllllIlIIlI = lllllllllllllllllIlllIllllIlIIII.loadImage(new BufferedInputStream(lllllllllllllllllIlllIlllllIIIIl), lllllllllllllllllIlllIlllIllIllI, lllllllllllllllllIlllIllllIlIlII);
        int lllllllllllllllllIlllIllllIIllll = InternalTextureLoader.createTextureID();
        TextureImpl lllllllllllllllllIlllIllllIIlllI = new TextureImpl(lllllllllllllllllIlllIllllIlllll, lllllllllllllllllIlllIlllIllllII, lllllllllllllllllIlllIllllIIllll);
        GL.glBindTexture(lllllllllllllllllIlllIlllIllllII, lllllllllllllllllIlllIllllIIllll);
        int lllllllllllllllllIlllIllllIIllIl = lllllllllllllllllIlllIllllIlIIII.getWidth();
        int lllllllllllllllllIlllIllllIIllII = lllllllllllllllllIlllIllllIlIIII.getHeight();
        boolean lllllllllllllllllIlllIllllIIlIIl = lllllllllllllllllIlllIllllIlIIII.getDepth() == 32;
        lllllllllllllllllIlllIllllIIlllI.setTextureWidth(lllllllllllllllllIlllIllllIlIIII.getTexWidth());
        lllllllllllllllllIlllIllllIIlllI.setTextureHeight(lllllllllllllllllIlllIllllIlIIII.getTexHeight());
        int lllllllllllllllllIlllIllllIIlIll = lllllllllllllllllIlllIllllIIlllI.getTextureWidth();
        int lllllllllllllllllIlllIllllIIlIlI = lllllllllllllllllIlllIllllIIlllI.getTextureHeight();
        IntBuffer lllllllllllllllllIlllIllllIIlIII = BufferUtils.createIntBuffer((int)16);
        GL.glGetInteger(3379, lllllllllllllllllIlllIllllIIlIII);
        int lllllllllllllllllIlllIllllIIIlll = lllllllllllllllllIlllIllllIIlIII.get(0);
        if (lllllllllllllllllIlllIllllIIlIll > lllllllllllllllllIlllIllllIIIlll || lllllllllllllllllIlllIllllIIlIlI > lllllllllllllllllIlllIllllIIIlll) {
            throw new IOException("Attempt to allocate a texture to big for the current hardware");
        }
        int lllllllllllllllllIlllIllllIIIlIl = lllllllllllllllllIlllIllllIIlIIl ? 6408 : 6407;
        int lllllllllllllllllIlllIllllIIIIll = lllllllllllllllllIlllIllllIIlIIl ? 4 : 3;
        lllllllllllllllllIlllIllllIIlllI.setWidth(lllllllllllllllllIlllIllllIIllIl);
        lllllllllllllllllIlllIllllIIlllI.setHeight(lllllllllllllllllIlllIllllIIllII);
        lllllllllllllllllIlllIllllIIlllI.setAlpha(lllllllllllllllllIlllIllllIIlIIl);
        if (lllllllllllllllllIlllIllllIIIIIl.holdTextureData) {
            lllllllllllllllllIlllIllllIIlllI.setTextureData(lllllllllllllllllIlllIllllIIIlIl, lllllllllllllllllIlllIllllIIIIll, lllllllllllllllllIlllIlllIlllIlI, lllllllllllllllllIlllIllllIllIll, lllllllllllllllllIlllIllllIlIIlI);
        }
        GL.glTexParameteri(lllllllllllllllllIlllIlllIllllII, 10241, lllllllllllllllllIlllIlllIlllIlI);
        GL.glTexParameteri(lllllllllllllllllIlllIlllIllllII, 10240, lllllllllllllllllIlllIllllIllIll);
        GL.glTexImage2D(lllllllllllllllllIlllIlllIllllII, 0, lllllllllllllllllIlllIllllIIIIIl.dstPixelFormat, InternalTextureLoader.get2Fold(lllllllllllllllllIlllIllllIIllIl), InternalTextureLoader.get2Fold(lllllllllllllllllIlllIllllIIllII), 0, lllllllllllllllllIlllIllllIIIlIl, 5121, lllllllllllllllllIlllIllllIlIIlI);
        return lllllllllllllllllIlllIllllIIlllI;
    }

    public Texture getTexture(ImageData lllllllllllllllllIlllIlIlIlllIll, int lllllllllllllllllIlllIlIlIlllIIl) throws IOException {
        InternalTextureLoader lllllllllllllllllIlllIlIlIllllIl;
        int lllllllllllllllllIlllIlIlllIlIII = 3553;
        ByteBuffer lllllllllllllllllIlllIlIlllIIlIl = lllllllllllllllllIlllIlIlIlllIll.getImageBufferData();
        int lllllllllllllllllIlllIlIlllIIIll = InternalTextureLoader.createTextureID();
        TextureImpl lllllllllllllllllIlllIlIlllIIIIl = new TextureImpl(String.valueOf(new StringBuilder().append("generated:").append(lllllllllllllllllIlllIlIlIlllIll)), lllllllllllllllllIlllIlIlllIlIII, lllllllllllllllllIlllIlIlllIIIll);
        int lllllllllllllllllIlllIlIllIlllll = lllllllllllllllllIlllIlIlIlllIIl;
        int lllllllllllllllllIlllIlIllIllIll = lllllllllllllllllIlllIlIlIlllIIl;
        boolean lllllllllllllllllIlllIlIllIllIII = false;
        GL.glBindTexture(lllllllllllllllllIlllIlIlllIlIII, lllllllllllllllllIlllIlIlllIIIll);
        int lllllllllllllllllIlllIlIllIlIllI = lllllllllllllllllIlllIlIlIlllIll.getWidth();
        int lllllllllllllllllIlllIlIllIlIlII = lllllllllllllllllIlllIlIlIlllIll.getHeight();
        boolean lllllllllllllllllIlllIlIllIIllIl = lllllllllllllllllIlllIlIlIlllIll.getDepth() == 32;
        lllllllllllllllllIlllIlIlllIIIIl.setTextureWidth(lllllllllllllllllIlllIlIlIlllIll.getTexWidth());
        lllllllllllllllllIlllIlIlllIIIIl.setTextureHeight(lllllllllllllllllIlllIlIlIlllIll.getTexHeight());
        int lllllllllllllllllIlllIlIllIlIIlI = lllllllllllllllllIlllIlIlllIIIIl.getTextureWidth();
        int lllllllllllllllllIlllIlIllIlIIII = lllllllllllllllllIlllIlIlllIIIIl.getTextureHeight();
        int lllllllllllllllllIlllIlIllIIlIIl = lllllllllllllllllIlllIlIllIIllIl ? 6408 : 6407;
        int lllllllllllllllllIlllIlIllIIIllI = lllllllllllllllllIlllIlIllIIllIl ? 4 : 3;
        lllllllllllllllllIlllIlIlllIIIIl.setWidth(lllllllllllllllllIlllIlIllIlIllI);
        lllllllllllllllllIlllIlIlllIIIIl.setHeight(lllllllllllllllllIlllIlIllIlIlII);
        lllllllllllllllllIlllIlIlllIIIIl.setAlpha(lllllllllllllllllIlllIlIllIIllIl);
        IntBuffer lllllllllllllllllIlllIlIllIIIIll = BufferUtils.createIntBuffer((int)16);
        GL.glGetInteger(3379, lllllllllllllllllIlllIlIllIIIIll);
        int lllllllllllllllllIlllIlIllIIIIII = lllllllllllllllllIlllIlIllIIIIll.get(0);
        if (lllllllllllllllllIlllIlIllIlIIlI > lllllllllllllllllIlllIlIllIIIIII || lllllllllllllllllIlllIlIllIlIIII > lllllllllllllllllIlllIlIllIIIIII) {
            throw new IOException("Attempt to allocate a texture to big for the current hardware");
        }
        if (lllllllllllllllllIlllIlIlIllllIl.holdTextureData) {
            lllllllllllllllllIlllIlIlllIIIIl.setTextureData(lllllllllllllllllIlllIlIllIIlIIl, lllllllllllllllllIlllIlIllIIIllI, lllllllllllllllllIlllIlIllIlllll, lllllllllllllllllIlllIlIllIllIll, lllllllllllllllllIlllIlIlllIIlIl);
        }
        GL.glTexParameteri(lllllllllllllllllIlllIlIlllIlIII, 10241, lllllllllllllllllIlllIlIllIlllll);
        GL.glTexParameteri(lllllllllllllllllIlllIlIlllIlIII, 10240, lllllllllllllllllIlllIlIllIllIll);
        GL.glTexImage2D(lllllllllllllllllIlllIlIlllIlIII, 0, lllllllllllllllllIlllIlIlIllllIl.dstPixelFormat, InternalTextureLoader.get2Fold(lllllllllllllllllIlllIlIllIlIllI), InternalTextureLoader.get2Fold(lllllllllllllllllIlllIlIllIlIlII), 0, lllllllllllllllllIlllIlIllIIlIIl, 5121, lllllllllllllllllIlllIlIlllIIlIl);
        return lllllllllllllllllIlllIlIlllIIIIl;
    }

    public static InternalTextureLoader get() {
        return loader;
    }

    public void setDeferredLoading(boolean lllllllllllllllllIllllIlIlllIlII) {
        lllllllllllllllllIllllIlIlllIlIl.deferred = lllllllllllllllllIllllIlIlllIlII;
    }

    public static int get2Fold(int lllllllllllllllllIlllIlIIllllIlI) {
        int lllllllllllllllllIlllIlIIllllIll;
        for (lllllllllllllllllIlllIlIIllllIll = 2; lllllllllllllllllIlllIlIIllllIll < lllllllllllllllllIlllIlIIllllIlI; lllllllllllllllllIlllIlIIllllIll *= 2) {
        }
        return lllllllllllllllllIlllIlIIllllIll;
    }

    public void clear() {
        InternalTextureLoader lllllllllllllllllIllllIlIllIlIIl;
        lllllllllllllllllIllllIlIllIlIIl.texturesLinear.clear();
        lllllllllllllllllIllllIlIllIlIIl.texturesNearest.clear();
    }

    public boolean isDeferredLoading() {
        InternalTextureLoader lllllllllllllllllIllllIlIlllIIIl;
        return lllllllllllllllllIllllIlIlllIIIl.deferred;
    }

    public Texture getTexture(InputStream lllllllllllllllllIllllIIlIlIllIl, String lllllllllllllllllIllllIIlIlIlIll, boolean lllllllllllllllllIllllIIlIlIIIIl, int lllllllllllllllllIllllIIlIlIlIII) throws IOException {
        InternalTextureLoader lllllllllllllllllIllllIIlIlIIllI;
        return lllllllllllllllllIllllIIlIlIIllI.getTexture(lllllllllllllllllIllllIIlIlIllIl, lllllllllllllllllIllllIIlIlIlIll, lllllllllllllllllIllllIIlIlIIIIl, lllllllllllllllllIllllIIlIlIlIII, null);
    }

    private InternalTextureLoader() {
        InternalTextureLoader lllllllllllllllllIllllIllIlIIllI;
        lllllllllllllllllIllllIllIlIIllI.texturesLinear = new HashMap();
        lllllllllllllllllIllllIllIlIIllI.texturesNearest = new HashMap();
        lllllllllllllllllIllllIllIlIIllI.dstPixelFormat = 6408;
    }

    public Texture getTexture(String lllllllllllllllllIllllIIllIIIlII, boolean lllllllllllllllllIllllIIllIIIIll, int lllllllllllllllllIllllIIllIIlIII, int[] lllllllllllllllllIllllIIllIIIlll) throws IOException {
        InternalTextureLoader lllllllllllllllllIllllIIllIIIlIl;
        InputStream lllllllllllllllllIllllIIllIIIllI = ResourceLoader.getResourceAsStream(lllllllllllllllllIllllIIllIIIlII);
        return lllllllllllllllllIllllIIllIIIlIl.getTexture(lllllllllllllllllIllllIIllIIIllI, lllllllllllllllllIllllIIllIIIlII, lllllllllllllllllIllllIIllIIIIll, lllllllllllllllllIllllIIllIIlIII, lllllllllllllllllIllllIIllIIIlll);
    }

    public Texture getTexture(File lllllllllllllllllIllllIlIlIIIIIl, boolean lllllllllllllllllIllllIlIIllIIll, int lllllllllllllllllIllllIlIIllIIlI) throws IOException {
        InternalTextureLoader lllllllllllllllllIllllIlIIllIlll;
        String lllllllllllllllllIllllIlIIlllIll = lllllllllllllllllIllllIlIlIIIIIl.getAbsolutePath();
        FileInputStream lllllllllllllllllIllllIlIIlllIIl = new FileInputStream(lllllllllllllllllIllllIlIlIIIIIl);
        return lllllllllllllllllIllllIlIIllIlll.getTexture(lllllllllllllllllIllllIlIIlllIIl, lllllllllllllllllIllllIlIIlllIll, lllllllllllllllllIllllIlIIllIIll, lllllllllllllllllIllllIlIIllIIlI, null);
    }

    public static IntBuffer createIntBuffer(int lllllllllllllllllIlllIlIIllIIlIl) {
        ByteBuffer lllllllllllllllllIlllIlIIllIIllI = ByteBuffer.allocateDirect(4 * lllllllllllllllllIlllIlIIllIIlIl);
        lllllllllllllllllIlllIlIIllIIllI.order(ByteOrder.nativeOrder());
        return lllllllllllllllllIlllIlIIllIIllI.asIntBuffer();
    }

    public int reload(TextureImpl lllllllllllllllllIlllIlIIlIIlIII, int lllllllllllllllllIlllIlIIIllIllI, int lllllllllllllllllIlllIlIIlIIIlIl, int lllllllllllllllllIlllIlIIlIIIIll, int lllllllllllllllllIlllIlIIIllIIlI, ByteBuffer lllllllllllllllllIlllIlIIIllIIIl) {
        InternalTextureLoader lllllllllllllllllIlllIlIIlIIlIIl;
        int lllllllllllllllllIlllIlIIIlllllI = 3553;
        int lllllllllllllllllIlllIlIIIllllII = InternalTextureLoader.createTextureID();
        GL.glBindTexture(lllllllllllllllllIlllIlIIIlllllI, lllllllllllllllllIlllIlIIIllllII);
        GL.glTexParameteri(lllllllllllllllllIlllIlIIIlllllI, 10241, lllllllllllllllllIlllIlIIlIIIIll);
        GL.glTexParameteri(lllllllllllllllllIlllIlIIIlllllI, 10240, lllllllllllllllllIlllIlIIIllIIlI);
        GL.glTexImage2D(lllllllllllllllllIlllIlIIIlllllI, 0, lllllllllllllllllIlllIlIIlIIlIIl.dstPixelFormat, lllllllllllllllllIlllIlIIlIIlIII.getTextureWidth(), lllllllllllllllllIlllIlIIlIIlIII.getTextureHeight(), 0, lllllllllllllllllIlllIlIIIllIllI, 5121, lllllllllllllllllIlllIlIIIllIIIl);
        return lllllllllllllllllIlllIlIIIllllII;
    }

    public Texture getTexture(String lllllllllllllllllIllllIIllllIllI, boolean lllllllllllllllllIllllIIllllIlIl, int lllllllllllllllllIllllIIlllIllII) throws IOException {
        InternalTextureLoader lllllllllllllllllIllllIIllllIlll;
        InputStream lllllllllllllllllIllllIIllllIIlI = ResourceLoader.getResourceAsStream(lllllllllllllllllIllllIIllllIllI);
        return lllllllllllllllllIllllIIllllIlll.getTexture(lllllllllllllllllIllllIIllllIIlI, lllllllllllllllllIllllIIllllIllI, lllllllllllllllllIllllIIllllIlIl, lllllllllllllllllIllllIIlllIllII, null);
    }
}

