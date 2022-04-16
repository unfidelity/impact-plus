/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.TextureImpl;

public class DeferredTexture
extends TextureImpl
implements DeferredResource {
    private /* synthetic */ String resourceName;
    private /* synthetic */ int[] trans;
    private /* synthetic */ boolean flipped;
    private /* synthetic */ InputStream in;
    private /* synthetic */ int filter;
    private /* synthetic */ TextureImpl target;

    @Override
    public int getImageHeight() {
        DeferredTexture lIlIIIIlIIIlI;
        lIlIIIIlIIIlI.checkTarget();
        return lIlIIIIlIIIlI.target.getImageHeight();
    }

    @Override
    public void setTextureFilter(int lIIlllIlIIlIl) {
        DeferredTexture lIIlllIlIIllI;
        lIIlllIlIIllI.checkTarget();
        lIIlllIlIIllI.target.setTextureFilter(lIIlllIlIIlIl);
    }

    @Override
    public void setTextureHeight(int lIIllllIlllIl) {
        DeferredTexture lIIllllIllllI;
        lIIllllIllllI.checkTarget();
        lIIllllIllllI.target.setTextureHeight(lIIllllIlllIl);
    }

    @Override
    public String getDescription() {
        DeferredTexture lIIlllIllIlIl;
        return lIIlllIllIlIl.resourceName;
    }

    @Override
    public void release() {
        DeferredTexture lIIlllllllllI;
        lIIlllllllllI.checkTarget();
        lIIlllllllllI.target.release();
    }

    @Override
    public void setTextureID(int lIIllllIlIIll) {
        DeferredTexture lIIllllIlIlII;
        lIIllllIlIlII.checkTarget();
        lIIllllIlIlII.target.setTextureID(lIIllllIlIIll);
    }

    @Override
    public float getWidth() {
        DeferredTexture lIlIIIIIIIIIl;
        lIlIIIIIIIIIl.checkTarget();
        return lIlIIIIIIIIIl.target.getWidth();
    }

    @Override
    public String getTextureRef() {
        DeferredTexture lIlIIIIIIIlll;
        lIlIIIIIIIlll.checkTarget();
        return lIlIIIIIIIlll.target.getTextureRef();
    }

    @Override
    public void bind() {
        DeferredTexture lIlIIIIlIllII;
        lIlIIIIlIllII.checkTarget();
        lIlIIIIlIllII.target.bind();
    }

    @Override
    public void setTextureWidth(int lIIllllIIlIII) {
        DeferredTexture lIIllllIIIlll;
        lIIllllIIIlll.checkTarget();
        lIIllllIIIlll.target.setTextureWidth(lIIllllIIlIII);
    }

    @Override
    public int getTextureWidth() {
        DeferredTexture lIlIIIIIIIlII;
        lIlIIIIIIIlII.checkTarget();
        return lIlIIIIIIIlII.target.getTextureWidth();
    }

    @Override
    public int getTextureHeight() {
        DeferredTexture lIlIIIIIIllIl;
        lIlIIIIIIllIl.checkTarget();
        return lIlIIIIIIllIl.target.getTextureHeight();
    }

    @Override
    public byte[] getTextureData() {
        DeferredTexture lIIlllIllIlll;
        lIIlllIllIlll.checkTarget();
        return lIIlllIllIlll.target.getTextureData();
    }

    @Override
    public void setWidth(int lIIllllIIIIII) {
        DeferredTexture lIIllllIIIIll;
        lIIllllIIIIll.checkTarget();
        lIIllllIIIIll.target.setWidth(lIIllllIIIIII);
    }

    @Override
    public float getHeight() {
        DeferredTexture lIlIIIIlIlIII;
        lIlIIIIlIlIII.checkTarget();
        return lIlIIIIlIlIII.target.getHeight();
    }

    @Override
    public void load() throws IOException {
        DeferredTexture lIlIIIIllIlIl;
        boolean lIlIIIIllIllI = InternalTextureLoader.get().isDeferredLoading();
        InternalTextureLoader.get().setDeferredLoading(false);
        lIlIIIIllIlIl.target = InternalTextureLoader.get().getTexture(lIlIIIIllIlIl.in, lIlIIIIllIlIl.resourceName, lIlIIIIllIlIl.flipped, lIlIIIIllIlIl.filter, lIlIIIIllIlIl.trans);
        InternalTextureLoader.get().setDeferredLoading(lIlIIIIllIllI);
    }

    public DeferredTexture(InputStream lIlIIIlIIlIll, String lIlIIIlIIlIlI, boolean lIlIIIlIlIIlI, int lIlIIIlIIIlll, int[] lIlIIIlIIIlIl) {
        DeferredTexture lIlIIIlIIllIl;
        lIlIIIlIIllIl.in = lIlIIIlIIlIll;
        lIlIIIlIIllIl.resourceName = lIlIIIlIIlIlI;
        lIlIIIlIIllIl.flipped = lIlIIIlIlIIlI;
        lIlIIIlIIllIl.filter = lIlIIIlIIIlll;
        lIlIIIlIIllIl.trans = lIlIIIlIIIlIl;
        LoadingList.get().add(lIlIIIlIIllIl);
    }

    @Override
    public int getImageWidth() {
        DeferredTexture lIlIIIIIlIlIl;
        lIlIIIIIlIlIl.checkTarget();
        return lIlIIIIIlIlIl.target.getImageWidth();
    }

    @Override
    public int getTextureID() {
        DeferredTexture lIlIIIIIIlIlI;
        lIlIIIIIIlIlI.checkTarget();
        return lIlIIIIIIlIlI.target.getTextureID();
    }

    @Override
    public boolean hasAlpha() {
        DeferredTexture lIIlllIllIIlI;
        lIIlllIllIIlI.checkTarget();
        return lIIlllIllIIlI.target.hasAlpha();
    }

    @Override
    public void setAlpha(boolean lIIllllllIIll) {
        DeferredTexture lIIlllllllIII;
        lIIlllllllIII.checkTarget();
        lIIlllllllIII.target.setAlpha(lIIllllllIIll);
    }

    private void checkTarget() {
        DeferredTexture lIlIIIIllIIII;
        if (lIlIIIIllIIII.target == null) {
            try {
                lIlIIIIllIIII.load();
                LoadingList.get().remove(lIlIIIIllIIII);
                return;
            }
            catch (IOException lIlIIIIllIIIl) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("Attempt to use deferred texture before loading and resource not found: ").append(lIlIIIIllIIII.resourceName)));
            }
        }
    }

    @Override
    public void setHeight(int lIIlllllIIIll) {
        DeferredTexture lIIlllllIIIlI;
        lIIlllllIIIlI.checkTarget();
        lIIlllllIIIlI.target.setHeight(lIIlllllIIIll);
    }
}

