/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick.opengl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.LoadableImageData;
import org.newdawn.slick.opengl.PNGDecoder;

public class PNGImageData
implements LoadableImageData {
    private /* synthetic */ int bitDepth;
    private /* synthetic */ int height;
    private /* synthetic */ PNGDecoder decoder;
    private /* synthetic */ ByteBuffer scratch;
    private /* synthetic */ int texWidth;
    private /* synthetic */ int texHeight;
    private /* synthetic */ int width;

    @Override
    public int getTexHeight() {
        PNGImageData lllllllllllllllIlllIIIlIIlIIIIIl;
        return lllllllllllllllIlllIIIlIIlIIIIIl.texHeight;
    }

    @Override
    public void configureEdging(boolean lllllllllllllllIlllIIIIlllIlIIlI) {
    }

    private int get2Fold(int lllllllllllllllIlllIIIIlllIlIlIl) {
        int lllllllllllllllIlllIIIIlllIlIllI;
        for (lllllllllllllllIlllIIIIlllIlIllI = 2; lllllllllllllllIlllIIIIlllIlIllI < lllllllllllllllIlllIIIIlllIlIlIl; lllllllllllllllIlllIIIIlllIlIllI *= 2) {
        }
        return lllllllllllllllIlllIIIIlllIlIllI;
    }

    @Override
    public ByteBuffer loadImage(InputStream lllllllllllllllIlllIIIlIIIllIlll) throws IOException {
        PNGImageData lllllllllllllllIlllIIIlIIIlllIlI;
        return lllllllllllllllIlllIIIlIIIlllIlI.loadImage(lllllllllllllllIlllIIIlIIIllIlll, false, null);
    }

    @Override
    public int getHeight() {
        PNGImageData lllllllllllllllIlllIIIIlllIIllIl;
        return lllllllllllllllIlllIIIIlllIIllIl.height;
    }

    private int toInt(byte lllllllllllllllIlllIIIIlllIlllII) {
        if (lllllllllllllllIlllIIIIlllIlllII < 0) {
            return 256 + lllllllllllllllIlllIIIIlllIlllII;
        }
        return lllllllllllllllIlllIIIIlllIlllII;
    }

    @Override
    public ByteBuffer getImageBufferData() {
        PNGImageData lllllllllllllllIlllIIIlIIlIIIlII;
        return lllllllllllllllIlllIIIlIIlIIIlII.scratch;
    }

    @Override
    public ByteBuffer loadImage(InputStream lllllllllllllllIlllIIIIllllIlIII, boolean lllllllllllllllIlllIIIIllllIlllI, boolean lllllllllllllllIlllIIIIllllIllIl, int[] lllllllllllllllIlllIIIIllllIllII) throws IOException {
        PNGImageData lllllllllllllllIlllIIIIlllllIIII;
        if (lllllllllllllllIlllIIIIllllIllII != null) {
            lllllllllllllllIlllIIIIllllIllIl = true;
            throw new IOException("Transparent color not support in custom PNG Decoder");
        }
        PNGDecoder lllllllllllllllIlllIIIIllllIlIll = new PNGDecoder(lllllllllllllllIlllIIIIllllIlIII);
        if (!lllllllllllllllIlllIIIIllllIlIll.isRGB()) {
            throw new IOException("Only RGB formatted images are supported by the PNGLoader");
        }
        lllllllllllllllIlllIIIIlllllIIII.width = lllllllllllllllIlllIIIIllllIlIll.getWidth();
        lllllllllllllllIlllIIIIlllllIIII.height = lllllllllllllllIlllIIIIllllIlIll.getHeight();
        lllllllllllllllIlllIIIIlllllIIII.texWidth = lllllllllllllllIlllIIIIlllllIIII.get2Fold(lllllllllllllllIlllIIIIlllllIIII.width);
        lllllllllllllllIlllIIIIlllllIIII.texHeight = lllllllllllllllIlllIIIIlllllIIII.get2Fold(lllllllllllllllIlllIIIIlllllIIII.height);
        int lllllllllllllllIlllIIIIllllIlIlI = lllllllllllllllIlllIIIIllllIlIll.hasAlpha() ? 4 : 3;
        lllllllllllllllIlllIIIIlllllIIII.bitDepth = lllllllllllllllIlllIIIIllllIlIll.hasAlpha() ? 32 : 24;
        lllllllllllllllIlllIIIIlllllIIII.scratch = BufferUtils.createByteBuffer((int)(lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIlllllIIII.texHeight * lllllllllllllllIlllIIIIllllIlIlI));
        lllllllllllllllIlllIIIIllllIlIll.decode(lllllllllllllllIlllIIIIlllllIIII.scratch, lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI, lllllllllllllllIlllIIIIllllIlIlI == 4 ? PNGDecoder.RGBA : PNGDecoder.RGB);
        if (lllllllllllllllIlllIIIIlllllIIII.height < lllllllllllllllIlllIIIIlllllIIII.texHeight - 1) {
            int lllllllllllllllIlllIIIIlllllllII = (lllllllllllllllIlllIIIIlllllIIII.texHeight - 1) * (lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI);
            int lllllllllllllllIlllIIIIllllllIll = (lllllllllllllllIlllIIIIlllllIIII.height - 1) * (lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI);
            for (int lllllllllllllllIlllIIIIlllllllIl = 0; lllllllllllllllIlllIIIIlllllllIl < lllllllllllllllIlllIIIIlllllIIII.texWidth; ++lllllllllllllllIlllIIIIlllllllIl) {
                for (int lllllllllllllllIlllIIIIllllllllI = 0; lllllllllllllllIlllIIIIllllllllI < lllllllllllllllIlllIIIIllllIlIlI; ++lllllllllllllllIlllIIIIllllllllI) {
                    lllllllllllllllIlllIIIIlllllIIII.scratch.put(lllllllllllllllIlllIIIIlllllllII + lllllllllllllllIlllIIIIlllllllIl + lllllllllllllllIlllIIIIllllllllI, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIlllllllIl + lllllllllllllllIlllIIIIllllllllI));
                    lllllllllllllllIlllIIIIlllllIIII.scratch.put(lllllllllllllllIlllIIIIllllllIll + lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI + lllllllllllllllIlllIIIIlllllllIl + lllllllllllllllIlllIIIIllllllllI, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIllllllIll + lllllllllllllllIlllIIIIlllllllIl + lllllllllllllllIlllIIIIllllllllI));
                }
            }
        }
        if (lllllllllllllllIlllIIIIlllllIIII.width < lllllllllllllllIlllIIIIlllllIIII.texWidth - 1) {
            for (int lllllllllllllllIlllIIIIllllllIIl = 0; lllllllllllllllIlllIIIIllllllIIl < lllllllllllllllIlllIIIIlllllIIII.texHeight; ++lllllllllllllllIlllIIIIllllllIIl) {
                for (int lllllllllllllllIlllIIIIllllllIlI = 0; lllllllllllllllIlllIIIIllllllIlI < lllllllllllllllIlllIIIIllllIlIlI; ++lllllllllllllllIlllIIIIllllllIlI) {
                    lllllllllllllllIlllIIIIlllllIIII.scratch.put((lllllllllllllllIlllIIIIllllllIIl + 1) * (lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI) - lllllllllllllllIlllIIIIllllIlIlI + lllllllllllllllIlllIIIIllllllIlI, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIllllllIIl * (lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI) + lllllllllllllllIlllIIIIllllllIlI));
                    lllllllllllllllIlllIIIIlllllIIII.scratch.put(lllllllllllllllIlllIIIIllllllIIl * (lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI) + lllllllllllllllIlllIIIIlllllIIII.width * lllllllllllllllIlllIIIIllllIlIlI + lllllllllllllllIlllIIIIllllllIlI, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIllllllIIl * (lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIllllIlIlI) + (lllllllllllllllIlllIIIIlllllIIII.width - 1) * lllllllllllllllIlllIIIIllllIlIlI + lllllllllllllllIlllIIIIllllllIlI));
                }
            }
        }
        if (!lllllllllllllllIlllIIIIllllIlIll.hasAlpha() && lllllllllllllllIlllIIIIllllIllIl) {
            ByteBuffer lllllllllllllllIlllIIIIlllllIlII = BufferUtils.createByteBuffer((int)(lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIlllllIIII.texHeight * 4));
            for (int lllllllllllllllIlllIIIIlllllIlIl = 0; lllllllllllllllIlllIIIIlllllIlIl < lllllllllllllllIlllIIIIlllllIIII.texWidth; ++lllllllllllllllIlllIIIIlllllIlIl) {
                for (int lllllllllllllllIlllIIIIlllllIllI = 0; lllllllllllllllIlllIIIIlllllIllI < lllllllllllllllIlllIIIIlllllIIII.texHeight; ++lllllllllllllllIlllIIIIlllllIllI) {
                    int lllllllllllllllIlllIIIIllllllIII = lllllllllllllllIlllIIIIlllllIllI * 3 + lllllllllllllllIlllIIIIlllllIlIl * lllllllllllllllIlllIIIIlllllIIII.texHeight * 3;
                    int lllllllllllllllIlllIIIIlllllIlll = lllllllllllllllIlllIIIIlllllIllI * 4 + lllllllllllllllIlllIIIIlllllIlIl * lllllllllllllllIlllIIIIlllllIIII.texHeight * 4;
                    lllllllllllllllIlllIIIIlllllIlII.put(lllllllllllllllIlllIIIIlllllIlll, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIllllllIII));
                    lllllllllllllllIlllIIIIlllllIlII.put(lllllllllllllllIlllIIIIlllllIlll + 1, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIllllllIII + 1));
                    lllllllllllllllIlllIIIIlllllIlII.put(lllllllllllllllIlllIIIIlllllIlll + 2, lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIllllllIII + 2));
                    if (lllllllllllllllIlllIIIIlllllIlIl < lllllllllllllllIlllIIIIlllllIIII.getHeight() && lllllllllllllllIlllIIIIlllllIllI < lllllllllllllllIlllIIIIlllllIIII.getWidth()) {
                        lllllllllllllllIlllIIIIlllllIlII.put(lllllllllllllllIlllIIIIlllllIlll + 3, (byte)-1);
                        continue;
                    }
                    lllllllllllllllIlllIIIIlllllIlII.put(lllllllllllllllIlllIIIIlllllIlll + 3, (byte)0);
                }
            }
            lllllllllllllllIlllIIIIlllllIIII.bitDepth = 32;
            lllllllllllllllIlllIIIIlllllIIII.scratch = lllllllllllllllIlllIIIIlllllIlII;
        }
        if (lllllllllllllllIlllIIIIllllIllII != null) {
            for (int lllllllllllllllIlllIIIIlllllIIIl = 0; lllllllllllllllIlllIIIIlllllIIIl < lllllllllllllllIlllIIIIlllllIIII.texWidth * lllllllllllllllIlllIIIIlllllIIII.texHeight * 4; lllllllllllllllIlllIIIIlllllIIIl += 4) {
                boolean lllllllllllllllIlllIIIIlllllIIlI = true;
                for (int lllllllllllllllIlllIIIIlllllIIll = 0; lllllllllllllllIlllIIIIlllllIIll < 3; ++lllllllllllllllIlllIIIIlllllIIll) {
                    if (lllllllllllllllIlllIIIIlllllIIII.toInt(lllllllllllllllIlllIIIIlllllIIII.scratch.get(lllllllllllllllIlllIIIIlllllIIIl + lllllllllllllllIlllIIIIlllllIIll)) == lllllllllllllllIlllIIIIllllIllII[lllllllllllllllIlllIIIIlllllIIll]) continue;
                    lllllllllllllllIlllIIIIlllllIIlI = false;
                }
                if (!lllllllllllllllIlllIIIIlllllIIlI) continue;
                lllllllllllllllIlllIIIIlllllIIII.scratch.put(lllllllllllllllIlllIIIIlllllIIIl + 3, (byte)0);
            }
        }
        lllllllllllllllIlllIIIIlllllIIII.scratch.position(0);
        return lllllllllllllllIlllIIIIlllllIIII.scratch;
    }

    @Override
    public int getDepth() {
        PNGImageData lllllllllllllllIlllIIIlIIlIIIllI;
        return lllllllllllllllIlllIIIlIIlIIIllI.bitDepth;
    }

    @Override
    public int getWidth() {
        PNGImageData lllllllllllllllIlllIIIIlllIIllll;
        return lllllllllllllllIlllIIIIlllIIllll.width;
    }

    @Override
    public int getTexWidth() {
        PNGImageData lllllllllllllllIlllIIIlIIIllllIl;
        return lllllllllllllllIlllIIIlIIIllllIl.texWidth;
    }

    public PNGImageData() {
        PNGImageData lllllllllllllllIlllIIIlIIlIIlIlI;
    }

    @Override
    public ByteBuffer loadImage(InputStream lllllllllllllllIlllIIIlIIIlIIlIl, boolean lllllllllllllllIlllIIIlIIIlIlIlI, int[] lllllllllllllllIlllIIIlIIIlIIIIl) throws IOException {
        PNGImageData lllllllllllllllIlllIIIlIIIlIllIl;
        return lllllllllllllllIlllIIIlIIIlIllIl.loadImage(lllllllllllllllIlllIIIlIIIlIIlIl, lllllllllllllllIlllIIIlIIIlIlIlI, false, lllllllllllllllIlllIIIlIIIlIIIIl);
    }
}

