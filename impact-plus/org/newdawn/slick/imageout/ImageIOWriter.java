/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.imageout;

import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.imageout.ImageWriter;

public class ImageIOWriter
implements ImageWriter {
    public ImageIOWriter() {
        ImageIOWriter lIIllIllllIllll;
    }

    @Override
    public void saveImage(Image lIIllIllIllllll, String lIIllIllIlllllI, OutputStream lIIllIllIllllII, boolean lIIllIllIlllIll) throws IOException {
        ComponentColorModel lIIllIlllIIIlII;
        PixelInterleavedSampleModel lIIllIlllIIIlIl;
        int lIIllIlllIIlIII = 4 * lIIllIllIllllll.getWidth() * lIIllIllIllllll.getHeight();
        if (!lIIllIllIlllIll) {
            lIIllIlllIIlIII = 3 * lIIllIllIllllll.getWidth() * lIIllIllIllllll.getHeight();
        }
        ByteBuffer lIIllIlllIIIlll = ByteBuffer.allocate(lIIllIlllIIlIII);
        for (int lIIllIlllIlIllI = 0; lIIllIlllIlIllI < lIIllIllIllllll.getHeight(); ++lIIllIlllIlIllI) {
            for (int lIIllIlllIlIlll = 0; lIIllIlllIlIlll < lIIllIllIllllll.getWidth(); ++lIIllIlllIlIlll) {
                Color lIIllIlllIllIII = lIIllIllIllllll.getColor(lIIllIlllIlIlll, lIIllIlllIlIllI);
                lIIllIlllIIIlll.put((byte)(lIIllIlllIllIII.r * 255.0f));
                lIIllIlllIIIlll.put((byte)(lIIllIlllIllIII.g * 255.0f));
                lIIllIlllIIIlll.put((byte)(lIIllIlllIllIII.b * 255.0f));
                if (!lIIllIllIlllIll) continue;
                lIIllIlllIIIlll.put((byte)(lIIllIlllIllIII.a * 255.0f));
            }
        }
        DataBufferByte lIIllIlllIIIllI = new DataBufferByte(lIIllIlllIIIlll.array(), lIIllIlllIIlIII);
        if (lIIllIllIlllIll) {
            int[] lIIllIlllIlIlIl = new int[]{0, 1, 2, 3};
            PixelInterleavedSampleModel lIIllIlllIlIlII = new PixelInterleavedSampleModel(0, lIIllIllIllllll.getWidth(), lIIllIllIllllll.getHeight(), 4, 4 * lIIllIllIllllll.getWidth(), lIIllIlllIlIlIl);
            ComponentColorModel lIIllIlllIlIIlI = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 8}, true, false, 3, 0);
        } else {
            int[] lIIllIlllIlIIIl = new int[]{0, 1, 2};
            lIIllIlllIIIlIl = new PixelInterleavedSampleModel(0, lIIllIllIllllll.getWidth(), lIIllIllIllllll.getHeight(), 3, 3 * lIIllIllIllllll.getWidth(), lIIllIlllIlIIIl);
            lIIllIlllIIIlII = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 0}, false, false, 1, 0);
        }
        WritableRaster lIIllIlllIIIIlI = Raster.createWritableRaster(lIIllIlllIIIlIl, lIIllIlllIIIllI, new Point(0, 0));
        BufferedImage lIIllIlllIIIIIl = new BufferedImage(lIIllIlllIIIlII, lIIllIlllIIIIlI, false, null);
        ImageIO.write((RenderedImage)lIIllIlllIIIIIl, lIIllIllIlllllI, lIIllIllIllllII);
    }
}

