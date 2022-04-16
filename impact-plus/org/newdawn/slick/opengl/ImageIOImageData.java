/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import org.newdawn.slick.opengl.LoadableImageData;

public class ImageIOImageData
implements LoadableImageData {
    private /* synthetic */ boolean edging;
    private /* synthetic */ int height;
    private static final /* synthetic */ ColorModel glColorModel;
    private /* synthetic */ int texHeight;
    private /* synthetic */ int width;
    private /* synthetic */ int texWidth;
    private static final /* synthetic */ ColorModel glAlphaColorModel;
    private /* synthetic */ int depth;

    private void copyArea(BufferedImage lIIIIllIlllllII, int lIIIIlllIIIIIll, int lIIIIlllIIIIIlI, int lIIIIllIllllIIl, int lIIIIllIllllIII, int lIIIIllIlllllll, int lIIIIllIlllIllI) {
        Graphics2D lIIIIllIlllllIl = (Graphics2D)lIIIIllIlllllII.getGraphics();
        lIIIIllIlllllIl.drawImage((Image)lIIIIllIlllllII.getSubimage(lIIIIlllIIIIIll, lIIIIlllIIIIIlI, lIIIIllIllllIIl, lIIIIllIllllIII), lIIIIlllIIIIIll + lIIIIllIlllllll, lIIIIlllIIIIIlI + lIIIIllIlllIllI, null);
    }

    @Override
    public int getWidth() {
        ImageIOImageData lIIIlIIIIlIlIlI;
        return lIIIlIIIIlIlIlI.width;
    }

    @Override
    public ByteBuffer getImageBufferData() {
        throw new RuntimeException("ImageIOImageData doesn't store it's image.");
    }

    static {
        glAlphaColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 8}, true, false, 3, 0);
        glColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 0}, false, false, 1, 0);
    }

    @Override
    public int getTexHeight() {
        ImageIOImageData lIIIlIIIIllIIIl;
        return lIIIlIIIIllIIIl.texHeight;
    }

    @Override
    public ByteBuffer loadImage(InputStream lIIIlIIIIIIlIlI, boolean lIIIlIIIIIIllll, boolean lIIIlIIIIIIlIII, int[] lIIIlIIIIIIllIl) throws IOException {
        ImageIOImageData lIIIlIIIIIlIIIl;
        if (lIIIlIIIIIIllIl != null) {
            lIIIlIIIIIIlIII = true;
        }
        BufferedImage lIIIlIIIIIIllII = ImageIO.read(lIIIlIIIIIIlIlI);
        return lIIIlIIIIIlIIIl.imageToByteBuffer(lIIIlIIIIIIllII, lIIIlIIIIIIllll, lIIIlIIIIIIlIII, lIIIlIIIIIIllIl);
    }

    public ImageIOImageData() {
        ImageIOImageData lIIIlIIIIlllIlI;
        lIIIlIIIIlllIlI.edging = true;
    }

    @Override
    public int getHeight() {
        ImageIOImageData lIIIlIIIIllIIll;
        return lIIIlIIIIllIIll.height;
    }

    @Override
    public ByteBuffer loadImage(InputStream lIIIlIIIIlIIlII) throws IOException {
        ImageIOImageData lIIIlIIIIlIIlll;
        return lIIIlIIIIlIIlll.loadImage(lIIIlIIIIlIIlII, true, null);
    }

    @Override
    public int getDepth() {
        ImageIOImageData lIIIlIIIIllIlll;
        return lIIIlIIIIllIlll.depth;
    }

    @Override
    public void configureEdging(boolean lIIIIllIllIIlIl) {
        lIIIIllIllIlIll.edging = lIIIIllIllIIlIl;
    }

    @Override
    public int getTexWidth() {
        ImageIOImageData lIIIlIIIIlIllIl;
        return lIIIlIIIIlIllIl.texWidth;
    }

    @Override
    public ByteBuffer loadImage(InputStream lIIIlIIIIIllllI, boolean lIIIlIIIIIlllIl, int[] lIIIlIIIIIllIII) throws IOException {
        ImageIOImageData lIIIlIIIIIllIll;
        return lIIIlIIIIIllIll.loadImage(lIIIlIIIIIllllI, lIIIlIIIIIlllIl, false, lIIIlIIIIIllIII);
    }

    public ByteBuffer imageToByteBuffer(BufferedImage lIIIIllllIlIlII, boolean lIIIIllllIlIIll, boolean lIIIIllllIIIIII, int[] lIIIIlllIlllllI) {
        ImageIOImageData lIIIIllllIlIlIl;
        BufferedImage lIIIIllllIIlllI;
        boolean lIIIIllllIIlIlI;
        int lIIIIllllIIllIl;
        ByteBuffer lIIIIllllIlIIII = null;
        int lIIIIllllIIlIll = 2;
        for (lIIIIllllIIllIl = 2; lIIIIllllIIllIl < lIIIIllllIlIlII.getWidth(); lIIIIllllIIllIl *= 2) {
        }
        while (lIIIIllllIIlIll < lIIIIllllIlIlII.getHeight()) {
            lIIIIllllIIlIll *= 2;
        }
        lIIIIllllIlIlIl.width = lIIIIllllIlIlII.getWidth();
        lIIIIllllIlIlIl.height = lIIIIllllIlIlII.getHeight();
        lIIIIllllIlIlIl.texHeight = lIIIIllllIIlIll;
        lIIIIllllIlIlIl.texWidth = lIIIIllllIIllIl;
        boolean bl = lIIIIllllIIlIlI = lIIIIllllIlIlII.getColorModel().hasAlpha() || lIIIIllllIIIIII;
        if (lIIIIllllIIlIlI) {
            lIIIIllllIlIlIl.depth = 32;
            WritableRaster lIIIIllllIllIll = Raster.createInterleavedRaster(0, lIIIIllllIIllIl, lIIIIllllIIlIll, 4, null);
            BufferedImage lIIIIllllIllIlI = new BufferedImage(glAlphaColorModel, lIIIIllllIllIll, false, new Hashtable());
        } else {
            lIIIIllllIlIlIl.depth = 24;
            WritableRaster lIIIIllllIIllll = Raster.createInterleavedRaster(0, lIIIIllllIIllIl, lIIIIllllIIlIll, 3, null);
            lIIIIllllIIlllI = new BufferedImage(glColorModel, lIIIIllllIIllll, false, new Hashtable());
        }
        Graphics2D lIIIIllllIIlIIl = (Graphics2D)lIIIIllllIIlllI.getGraphics();
        if (lIIIIllllIIlIlI) {
            lIIIIllllIIlIIl.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
            lIIIIllllIIlIIl.fillRect(0, 0, lIIIIllllIIllIl, lIIIIllllIIlIll);
        }
        if (lIIIIllllIlIIll) {
            lIIIIllllIIlIIl.scale(1.0, -1.0);
            lIIIIllllIIlIIl.drawImage((Image)lIIIIllllIlIlII, 0, -lIIIIllllIlIlIl.height, null);
        } else {
            lIIIIllllIIlIIl.drawImage((Image)lIIIIllllIlIlII, 0, 0, null);
        }
        if (lIIIIllllIlIlIl.edging) {
            if (lIIIIllllIlIlIl.height < lIIIIllllIIlIll - 1) {
                lIIIIllllIlIlIl.copyArea(lIIIIllllIIlllI, 0, 0, lIIIIllllIlIlIl.width, 1, 0, lIIIIllllIIlIll - 1);
                lIIIIllllIlIlIl.copyArea(lIIIIllllIIlllI, 0, lIIIIllllIlIlIl.height - 1, lIIIIllllIlIlIl.width, 1, 0, 1);
            }
            if (lIIIIllllIlIlIl.width < lIIIIllllIIllIl - 1) {
                lIIIIllllIlIlIl.copyArea(lIIIIllllIIlllI, 0, 0, 1, lIIIIllllIlIlIl.height, lIIIIllllIIllIl - 1, 0);
                lIIIIllllIlIlIl.copyArea(lIIIIllllIIlllI, lIIIIllllIlIlIl.width - 1, 0, 1, lIIIIllllIlIlIl.height, 1, 0);
            }
        }
        byte[] lIIIIllllIIIlll = ((DataBufferByte)lIIIIllllIIlllI.getRaster().getDataBuffer()).getData();
        if (lIIIIlllIlllllI != null) {
            for (int lIIIIllllIlIllI = 0; lIIIIllllIlIllI < lIIIIllllIIIlll.length; lIIIIllllIlIllI += 4) {
                boolean lIIIIllllIlIlll = true;
                for (int lIIIIllllIllIII = 0; lIIIIllllIllIII < 3; ++lIIIIllllIllIII) {
                    int lIIIIllllIllIIl;
                    int n = lIIIIllllIllIIl = lIIIIllllIIIlll[lIIIIllllIlIllI + lIIIIllllIllIII] < 0 ? 256 + lIIIIllllIIIlll[lIIIIllllIlIllI + lIIIIllllIllIII] : lIIIIllllIIIlll[lIIIIllllIlIllI + lIIIIllllIllIII];
                    if (lIIIIllllIllIIl == lIIIIlllIlllllI[lIIIIllllIllIII]) continue;
                    lIIIIllllIlIlll = false;
                }
                if (!lIIIIllllIlIlll) continue;
                lIIIIllllIIIlll[lIIIIllllIlIllI + 3] = 0;
            }
        }
        lIIIIllllIlIIII = ByteBuffer.allocateDirect(lIIIIllllIIIlll.length);
        lIIIIllllIlIIII.order(ByteOrder.nativeOrder());
        lIIIIllllIlIIII.put(lIIIIllllIIIlll, 0, lIIIIllllIIIlll.length);
        lIIIIllllIlIIII.flip();
        lIIIIllllIIlIIl.dispose();
        return lIIIIllllIlIIII;
    }
}

