/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.Log;

public class TextureImpl
implements Texture {
    protected static /* synthetic */ SGL GL;
    private /* synthetic */ int texHeight;
    private /* synthetic */ String cacheName;
    private /* synthetic */ int height;
    private /* synthetic */ boolean alpha;
    private /* synthetic */ float heightRatio;
    private /* synthetic */ int texWidth;
    private /* synthetic */ ReloadData reloadData;
    private /* synthetic */ int target;
    static /* synthetic */ Texture lastBind;
    private /* synthetic */ String ref;
    private /* synthetic */ int width;
    private /* synthetic */ float widthRatio;
    private /* synthetic */ int textureID;

    @Override
    public void release() {
        TextureImpl lllllllllllllllIlllllIIIIIIIlIll;
        IntBuffer lllllllllllllllIlllllIIIIIIIllII = lllllllllllllllIlllllIIIIIIIlIll.createIntBuffer(1);
        lllllllllllllllIlllllIIIIIIIllII.put(lllllllllllllllIlllllIIIIIIIlIll.textureID);
        lllllllllllllllIlllllIIIIIIIllII.flip();
        GL.glDeleteTextures(lllllllllllllllIlllllIIIIIIIllII);
        if (lastBind == lllllllllllllllIlllllIIIIIIIlIll) {
            TextureImpl.bindNone();
        }
        if (lllllllllllllllIlllllIIIIIIIlIll.cacheName != null) {
            InternalTextureLoader.get().clear(lllllllllllllllIlllllIIIIIIIlIll.cacheName);
        } else {
            InternalTextureLoader.get().clear(lllllllllllllllIlllllIIIIIIIlIll.ref);
        }
    }

    private void setHeight() {
        TextureImpl lllllllllllllllIlllllIIIIIlIIlll;
        if (lllllllllllllllIlllllIIIIIlIIlll.texHeight != 0) {
            lllllllllllllllIlllllIIIIIlIIlll.heightRatio = (float)lllllllllllllllIlllllIIIIIlIIlll.height / (float)lllllllllllllllIlllllIIIIIlIIlll.texHeight;
        }
    }

    @Override
    public void setTextureFilter(int lllllllllllllllIllllIlllllIIllll) {
        TextureImpl lllllllllllllllIllllIlllllIlIlIl;
        lllllllllllllllIllllIlllllIlIlIl.bind();
        GL.glTexParameteri(lllllllllllllllIllllIlllllIlIlIl.target, 10241, lllllllllllllllIllllIlllllIIllll);
        GL.glTexParameteri(lllllllllllllllIllllIlllllIlIlIl.target, 10240, lllllllllllllllIllllIlllllIIllll);
    }

    public void setWidth(int lllllllllllllllIlllllIIIIlIllIll) {
        TextureImpl lllllllllllllllIlllllIIIIlIllIIl;
        lllllllllllllllIlllllIIIIlIllIIl.width = lllllllllllllllIlllllIIIIlIllIll;
        lllllllllllllllIlllllIIIIlIllIIl.setWidth();
    }

    public void setTextureWidth(int lllllllllllllllIlllllIIIIIllIIII) {
        TextureImpl lllllllllllllllIlllllIIIIIllIIIl;
        lllllllllllllllIlllllIIIIIllIIIl.texWidth = lllllllllllllllIlllllIIIIIllIIII;
        lllllllllllllllIlllllIIIIIllIIIl.setWidth();
    }

    @Override
    public int getTextureHeight() {
        TextureImpl lllllllllllllllIlllllIIIIIlllllI;
        return lllllllllllllllIlllllIIIIIlllllI.texHeight;
    }

    public void setHeight(int lllllllllllllllIlllllIIIIllIIIll) {
        TextureImpl lllllllllllllllIlllllIIIIllIlIII;
        lllllllllllllllIlllllIIIIllIlIII.height = lllllllllllllllIlllllIIIIllIIIll;
        lllllllllllllllIlllllIIIIllIlIII.setHeight();
    }

    @Override
    public int getImageHeight() {
        TextureImpl lllllllllllllllIlllllIIIIlIlIIll;
        return lllllllllllllllIlllllIIIIlIlIIll.height;
    }

    public void setCacheName(String lllllllllllllllIlllllIIIlIIlIIll) {
        lllllllllllllllIlllllIIIlIIlIlII.cacheName = lllllllllllllllIlllllIIIlIIlIIll;
    }

    @Override
    public void bind() {
        TextureImpl lllllllllllllllIlllllIIIIllIllll;
        if (lastBind != lllllllllllllllIlllllIIIIllIllll) {
            lastBind = lllllllllllllllIlllllIIIIllIllll;
            GL.glEnable(3553);
            GL.glBindTexture(lllllllllllllllIlllllIIIIllIllll.target, lllllllllllllllIlllllIIIIllIllll.textureID);
        }
    }

    @Override
    public int getTextureID() {
        TextureImpl lllllllllllllllIlllllIIIIIIIIlIl;
        return lllllllllllllllIlllllIIIIIIIIlIl.textureID;
    }

    @Override
    public String getTextureRef() {
        TextureImpl lllllllllllllllIlllllIIIlIIIIlII;
        return lllllllllllllllIlllllIIIlIIIIlII.ref;
    }

    protected TextureImpl() {
        TextureImpl lllllllllllllllIlllllIIIlIlIllll;
    }

    public static void bindNone() {
        lastBind = null;
        GL.glDisable(3553);
    }

    protected IntBuffer createIntBuffer(int lllllllllllllllIllllIllllllIllll) {
        ByteBuffer lllllllllllllllIllllIlllllllIIII = ByteBuffer.allocateDirect(4 * lllllllllllllllIllllIllllllIllll);
        lllllllllllllllIllllIlllllllIIII.order(ByteOrder.nativeOrder());
        return lllllllllllllllIllllIlllllllIIII.asIntBuffer();
    }

    @Override
    public boolean hasAlpha() {
        TextureImpl lllllllllllllllIlllllIIIlIIIlIll;
        return lllllllllllllllIlllllIIIlIIIlIll.alpha;
    }

    @Override
    public float getWidth() {
        TextureImpl lllllllllllllllIlllllIIIIlIIIIIl;
        return lllllllllllllllIlllllIIIIlIIIIIl.widthRatio;
    }

    public static void unbind() {
        lastBind = null;
    }

    public void reload() {
        TextureImpl lllllllllllllllIllllIllllIlIlIII;
        if (lllllllllllllllIllllIllllIlIlIII.reloadData != null) {
            lllllllllllllllIllllIllllIlIlIII.textureID = lllllllllllllllIllllIllllIlIlIII.reloadData.reload();
        }
    }

    static {
        GL = Renderer.get();
    }

    public TextureImpl(String lllllllllllllllIlllllIIIlIlIIIII, int lllllllllllllllIlllllIIIlIIlllll, int lllllllllllllllIlllllIIIlIIlllIl) {
        TextureImpl lllllllllllllllIlllllIIIlIlIIllI;
        lllllllllllllllIlllllIIIlIlIIllI.target = lllllllllllllllIlllllIIIlIIlllll;
        lllllllllllllllIlllllIIIlIlIIllI.ref = lllllllllllllllIlllllIIIlIlIIIII;
        lllllllllllllllIlllllIIIlIlIIllI.textureID = lllllllllllllllIlllllIIIlIIlllIl;
        lastBind = lllllllllllllllIlllllIIIlIlIIllI;
    }

    public static Texture getLastBind() {
        return lastBind;
    }

    @Override
    public int getTextureWidth() {
        TextureImpl lllllllllllllllIlllllIIIIIlllIlI;
        return lllllllllllllllIlllllIIIIIlllIlI.texWidth;
    }

    public void setTextureID(int lllllllllllllllIllllIllllllllIll) {
        lllllllllllllllIllllIllllllllIIl.textureID = lllllllllllllllIllllIllllllllIll;
    }

    @Override
    public byte[] getTextureData() {
        TextureImpl lllllllllllllllIllllIlllllIllIlI;
        ByteBuffer lllllllllllllllIllllIlllllIlllII = BufferUtils.createByteBuffer((int)((lllllllllllllllIllllIlllllIllIlI.hasAlpha() ? 4 : 3) * lllllllllllllllIllllIlllllIllIlI.texWidth * lllllllllllllllIllllIlllllIllIlI.texHeight));
        lllllllllllllllIllllIlllllIllIlI.bind();
        GL.glGetTexImage(3553, 0, lllllllllllllllIllllIlllllIllIlI.hasAlpha() ? 6408 : 6407, 5121, lllllllllllllllIllllIlllllIlllII);
        byte[] lllllllllllllllIllllIlllllIllIll = new byte[lllllllllllllllIllllIlllllIlllII.limit()];
        lllllllllllllllIllllIlllllIlllII.get(lllllllllllllllIllllIlllllIllIll);
        lllllllllllllllIllllIlllllIlllII.clear();
        return lllllllllllllllIllllIlllllIllIll;
    }

    private void setWidth() {
        TextureImpl lllllllllllllllIlllllIIIIIIlllIl;
        if (lllllllllllllllIlllllIIIIIIlllIl.texWidth != 0) {
            lllllllllllllllIlllllIIIIIIlllIl.widthRatio = (float)lllllllllllllllIlllllIIIIIIlllIl.width / (float)lllllllllllllllIlllllIIIIIIlllIl.texWidth;
        }
    }

    public void setTextureHeight(int lllllllllllllllIlllllIIIIIllIlII) {
        TextureImpl lllllllllllllllIlllllIIIIIllIlll;
        lllllllllllllllIlllllIIIIIllIlll.texHeight = lllllllllllllllIlllllIIIIIllIlII;
        lllllllllllllllIlllllIIIIIllIlll.setHeight();
    }

    public void setTextureData(int lllllllllllllllIllllIllllIllIlll, int lllllllllllllllIllllIllllIllIlIl, int lllllllllllllllIllllIllllIllIIll, int lllllllllllllllIllllIllllIllIIIl, ByteBuffer lllllllllllllllIllllIllllIlIllll) {
        TextureImpl lllllllllllllllIllllIlllllIIIIIl;
        lllllllllllllllIllllIlllllIIIIIl.reloadData = lllllllllllllllIllllIlllllIIIIIl.new ReloadData();
        lllllllllllllllIllllIlllllIIIIIl.reloadData.srcPixelFormat = lllllllllllllllIllllIllllIllIlll;
        lllllllllllllllIllllIlllllIIIIIl.reloadData.componentCount = lllllllllllllllIllllIllllIllIlIl;
        lllllllllllllllIllllIlllllIIIIIl.reloadData.minFilter = lllllllllllllllIllllIllllIllIIll;
        lllllllllllllllIllllIlllllIIIIIl.reloadData.magFilter = lllllllllllllllIllllIllllIllIIIl;
        lllllllllllllllIllllIlllllIIIIIl.reloadData.textureBuffer = lllllllllllllllIllllIllllIlIllll;
    }

    @Override
    public int getImageWidth() {
        TextureImpl lllllllllllllllIlllllIIIIlIIlIll;
        return lllllllllllllllIlllllIIIIlIIlIll.width;
    }

    public void setAlpha(boolean lllllllllllllllIlllllIIIIlllllII) {
        lllllllllllllllIlllllIIIIllllIll.alpha = lllllllllllllllIlllllIIIIlllllII;
    }

    @Override
    public float getHeight() {
        TextureImpl lllllllllllllllIlllllIIIIlIIIlII;
        return lllllllllllllllIlllllIIIIlIIIlII.heightRatio;
    }

    private class ReloadData {
        private /* synthetic */ ByteBuffer textureBuffer;
        private /* synthetic */ int minFilter;
        private /* synthetic */ int srcPixelFormat;
        private /* synthetic */ int componentCount;
        private /* synthetic */ int magFilter;

        private ReloadData() {
            ReloadData lllllllllllllllllllIIllIIllIlllI;
        }

        public int reload() {
            ReloadData lllllllllllllllllllIIllIIllIlIlI;
            Log.error(String.valueOf(new StringBuilder().append("Reloading texture: ").append(lllllllllllllllllllIIllIIllIlIlI.TextureImpl.this.ref)));
            return InternalTextureLoader.get().reload(lllllllllllllllllllIIllIIllIlIlI.TextureImpl.this, lllllllllllllllllllIIllIIllIlIlI.srcPixelFormat, lllllllllllllllllllIIllIIllIlIlI.componentCount, lllllllllllllllllllIIllIIllIlIlI.minFilter, lllllllllllllllllllIIllIIllIlIlI.magFilter, lllllllllllllllllllIIllIIllIlIlI.textureBuffer);
        }
    }
}

