/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.imageout;

import java.util.HashMap;
import javax.imageio.ImageIO;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageIOWriter;
import org.newdawn.slick.imageout.ImageWriter;
import org.newdawn.slick.imageout.TGAWriter;

public class ImageWriterFactory {
    private static /* synthetic */ HashMap writers;

    public ImageWriterFactory() {
        ImageWriterFactory llIlIlIlIIIlI;
    }

    public static String[] getSupportedFormats() {
        return writers.keySet().toArray(new String[0]);
    }

    public static ImageWriter getWriterForFormat(String llIlIlIIIIIlI) throws SlickException {
        ImageWriter llIlIlIIIIIll = (ImageWriter)writers.get(llIlIlIIIIIlI);
        if (llIlIlIIIIIll != null) {
            return llIlIlIIIIIll;
        }
        llIlIlIIIIIll = (ImageWriter)writers.get(llIlIlIIIIIlI.toLowerCase());
        if (llIlIlIIIIIll != null) {
            return llIlIlIIIIIll;
        }
        llIlIlIIIIIll = (ImageWriter)writers.get(llIlIlIIIIIlI.toUpperCase());
        if (llIlIlIIIIIll != null) {
            return llIlIlIIIIIll;
        }
        throw new SlickException(String.valueOf(new StringBuilder().append("No image writer available for: ").append(llIlIlIIIIIlI)));
    }

    public static void registerWriter(String llIlIlIIlllll, ImageWriter llIlIlIIllllI) {
        writers.put(llIlIlIIlllll, llIlIlIIllllI);
    }

    static {
        writers = new HashMap();
        String[] llIlIIllllIll = ImageIO.getWriterFormatNames();
        ImageIOWriter llIlIIllllIlI = new ImageIOWriter();
        for (int llIlIIlllllIl = 0; llIlIIlllllIl < llIlIIllllIll.length; ++llIlIIlllllIl) {
            ImageWriterFactory.registerWriter(llIlIIllllIll[llIlIIlllllIl], llIlIIllllIlI);
        }
        TGAWriter llIlIIllllIIl = new TGAWriter();
        ImageWriterFactory.registerWriter("tga", llIlIIllllIIl);
    }
}

