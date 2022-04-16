/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.newdawn.slick.opengl.CompositeImageData;
import org.newdawn.slick.opengl.ImageIOImageData;
import org.newdawn.slick.opengl.LoadableImageData;
import org.newdawn.slick.opengl.PNGImageData;
import org.newdawn.slick.opengl.TGAImageData;
import org.newdawn.slick.util.Log;

public class ImageDataFactory {
    private static /* synthetic */ boolean pngLoaderPropertyChecked;
    private static final /* synthetic */ String PNG_LOADER;
    private static /* synthetic */ boolean usePngLoader;

    private static void checkProperty() {
        if (!pngLoaderPropertyChecked) {
            pngLoaderPropertyChecked = true;
            try {
                AccessController.doPrivileged(new PrivilegedAction(){
                    {
                        1 llllllllllllllllIlIIIIlllIIIlIIl;
                    }

                    public Object run() {
                        String llllllllllllllllIlIIIIlllIIIIlIl = System.getProperty("org.newdawn.slick.pngloader");
                        if ("false".equalsIgnoreCase(llllllllllllllllIlIIIIlllIIIIlIl)) {
                            usePngLoader = false;
                        }
                        Log.info(String.valueOf(new StringBuilder().append("Use Java PNG Loader = ").append(usePngLoader)));
                        return null;
                    }
                });
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static {
        PNG_LOADER = "org.newdawn.slick.pngloader";
        usePngLoader = true;
        pngLoaderPropertyChecked = false;
    }

    public ImageDataFactory() {
        ImageDataFactory lllllllllllllllllIllllIlIIIllllI;
    }

    public static LoadableImageData getImageDataFor(String lllllllllllllllllIllllIIlIllllII) {
        ImageDataFactory.checkProperty();
        lllllllllllllllllIllllIIlIllllII = lllllllllllllllllIllllIIlIllllII.toLowerCase();
        if (lllllllllllllllllIllllIIlIllllII.endsWith(".tga")) {
            return new TGAImageData();
        }
        if (lllllllllllllllllIllllIIlIllllII.endsWith(".png")) {
            CompositeImageData lllllllllllllllllIllllIIlIllllIl = new CompositeImageData();
            if (usePngLoader) {
                lllllllllllllllllIllllIIlIllllIl.add(new PNGImageData());
            }
            lllllllllllllllllIllllIIlIllllIl.add(new ImageIOImageData());
            return lllllllllllllllllIllllIIlIllllIl;
        }
        return new ImageIOImageData();
    }
}

