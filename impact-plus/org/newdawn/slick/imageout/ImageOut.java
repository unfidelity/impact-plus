/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.imageout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageWriter;
import org.newdawn.slick.imageout.ImageWriterFactory;

public class ImageOut {
    public static /* synthetic */ String PNG;
    public static /* synthetic */ String TGA;
    private static final /* synthetic */ boolean DEFAULT_ALPHA_WRITE;
    public static /* synthetic */ String JPG;

    public static void write(Image lIIlllIlIIlIllI, String lIIlllIlIIlIlIl) throws SlickException {
        ImageOut.write(lIIlllIlIIlIllI, lIIlllIlIIlIlIl, false);
    }

    public static void write(Image lIIlllIlIIIllII, String lIIlllIlIIIlIII, boolean lIIlllIlIIIlIlI) throws SlickException {
        try {
            int lIIlllIlIIIllll = lIIlllIlIIIlIII.lastIndexOf(46);
            if (lIIlllIlIIIllll < 0) {
                throw new SlickException(String.valueOf(new StringBuilder().append("Unable to determine format from: ").append(lIIlllIlIIIlIII)));
            }
            String lIIlllIlIIIlllI = lIIlllIlIIIlIII.substring(lIIlllIlIIIllll + 1);
            ImageOut.write(lIIlllIlIIIllII, lIIlllIlIIIlllI, new FileOutputStream(lIIlllIlIIIlIII), lIIlllIlIIIlIlI);
        }
        catch (IOException lIIlllIlIIIllIl) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Unable to write to the destination: ").append(lIIlllIlIIIlIII)), lIIlllIlIIIllIl);
        }
    }

    public static String[] getSupportedFormats() {
        return ImageWriterFactory.getSupportedFormats();
    }

    static {
        DEFAULT_ALPHA_WRITE = false;
        TGA = "tga";
        PNG = "png";
        JPG = "jpg";
    }

    public static void write(Image lIIlllIlIIlllll, String lIIlllIlIIllllI, OutputStream lIIlllIlIIlllIl, boolean lIIlllIlIIlllII) throws SlickException {
        try {
            ImageWriter lIIlllIlIlIIlIl = ImageWriterFactory.getWriterForFormat(lIIlllIlIIllllI);
            lIIlllIlIlIIlIl.saveImage(lIIlllIlIIlllll, lIIlllIlIIllllI, lIIlllIlIIlllIl, lIIlllIlIIlllII);
        }
        catch (IOException lIIlllIlIlIIlII) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Unable to write out the image in format: ").append(lIIlllIlIIllllI)), lIIlllIlIlIIlII);
        }
    }

    public static void write(Image lIIlllIlIIIIIIl, String lIIlllIlIIIIIII, String lIIlllIIlllllll) throws SlickException {
        ImageOut.write(lIIlllIlIIIIIIl, lIIlllIlIIIIIII, lIIlllIIlllllll, false);
    }

    public static void write(Image lIIlllIlIllIIII, String lIIlllIlIlIllll, OutputStream lIIlllIlIlIlIll) throws SlickException {
        ImageOut.write(lIIlllIlIllIIII, lIIlllIlIlIllll, lIIlllIlIlIlIll, false);
    }

    public ImageOut() {
        ImageOut lIIlllIlIllIlII;
    }

    public static void write(Image lIIlllIIlllIlIl, String lIIlllIIlllIlII, String lIIlllIIllIllll, boolean lIIlllIIlllIIlI) throws SlickException {
        try {
            ImageOut.write(lIIlllIIlllIlIl, lIIlllIIlllIlII, new FileOutputStream(lIIlllIIllIllll), lIIlllIIlllIIlI);
        }
        catch (IOException lIIlllIIlllIllI) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Unable to write to the destination: ").append(lIIlllIIllIllll)), lIIlllIIlllIllI);
        }
    }
}

