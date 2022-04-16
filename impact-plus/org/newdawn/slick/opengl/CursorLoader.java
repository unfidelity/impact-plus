/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.input.Cursor
 */
package org.newdawn.slick.opengl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.ImageDataFactory;
import org.newdawn.slick.opengl.LoadableImageData;
import org.newdawn.slick.opengl.TGAImageData;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public class CursorLoader {
    private static /* synthetic */ CursorLoader single;

    public Cursor getCursor(ImageData llIlIlIIlIIlllI, int llIlIlIIlIIllIl, int llIlIlIIlIIllII) throws LWJGLException, IOException {
        ByteBuffer llIlIlIIlIIllll = llIlIlIIlIIlllI.getImageBufferData();
        for (int llIlIlIIlIlIllI = 0; llIlIlIIlIlIllI < llIlIlIIlIIllll.limit(); llIlIlIIlIlIllI += 4) {
            byte llIlIlIIlIllIlI = llIlIlIIlIIllll.get(llIlIlIIlIlIllI);
            byte llIlIlIIlIllIIl = llIlIlIIlIIllll.get(llIlIlIIlIlIllI + 1);
            byte llIlIlIIlIllIII = llIlIlIIlIIllll.get(llIlIlIIlIlIllI + 2);
            byte llIlIlIIlIlIlll = llIlIlIIlIIllll.get(llIlIlIIlIlIllI + 3);
            llIlIlIIlIIllll.put(llIlIlIIlIlIllI + 2, llIlIlIIlIllIlI);
            llIlIlIIlIIllll.put(llIlIlIIlIlIllI + 1, llIlIlIIlIllIIl);
            llIlIlIIlIIllll.put(llIlIlIIlIlIllI, llIlIlIIlIllIII);
            llIlIlIIlIIllll.put(llIlIlIIlIlIllI + 3, llIlIlIIlIlIlll);
        }
        try {
            int llIlIlIIlIlIlIl = llIlIlIIlIIlllI.getHeight() - llIlIlIIlIIllII - 1;
            if (llIlIlIIlIlIlIl < 0) {
                llIlIlIIlIlIlIl = 0;
            }
            return new Cursor(llIlIlIIlIIlllI.getTexWidth(), llIlIlIIlIIlllI.getTexHeight(), llIlIlIIlIIllIl, llIlIlIIlIlIlIl, 1, llIlIlIIlIIllll.asIntBuffer(), null);
        }
        catch (Throwable llIlIlIIlIlIlII) {
            Log.info("Chances are you cursor is too small for this platform");
            throw new LWJGLException(llIlIlIIlIlIlII);
        }
    }

    static {
        single = new CursorLoader();
    }

    public Cursor getCursor(ByteBuffer llIlIlIIlllIIlI, int llIlIlIIllIllII, int llIlIlIIllIlIll, int llIlIlIIllIllll, int llIlIlIIllIlIIl) throws IOException, LWJGLException {
        for (int llIlIlIIlllIllI = 0; llIlIlIIlllIllI < llIlIlIIlllIIlI.limit(); llIlIlIIlllIllI += 4) {
            byte llIlIlIIllllIlI = llIlIlIIlllIIlI.get(llIlIlIIlllIllI);
            byte llIlIlIIllllIIl = llIlIlIIlllIIlI.get(llIlIlIIlllIllI + 1);
            byte llIlIlIIllllIII = llIlIlIIlllIIlI.get(llIlIlIIlllIllI + 2);
            byte llIlIlIIlllIlll = llIlIlIIlllIIlI.get(llIlIlIIlllIllI + 3);
            llIlIlIIlllIIlI.put(llIlIlIIlllIllI + 2, llIlIlIIllllIlI);
            llIlIlIIlllIIlI.put(llIlIlIIlllIllI + 1, llIlIlIIllllIIl);
            llIlIlIIlllIIlI.put(llIlIlIIlllIllI, llIlIlIIllllIII);
            llIlIlIIlllIIlI.put(llIlIlIIlllIllI + 3, llIlIlIIlllIlll);
        }
        try {
            int llIlIlIIlllIlIl = llIlIlIIllIlIIl - llIlIlIIllIlIll - 1;
            if (llIlIlIIlllIlIl < 0) {
                llIlIlIIlllIlIl = 0;
            }
            return new Cursor(llIlIlIIllIllll, llIlIlIIllIlIIl, llIlIlIIllIllII, llIlIlIIlllIlIl, 1, llIlIlIIlllIIlI.asIntBuffer(), null);
        }
        catch (Throwable llIlIlIIlllIlII) {
            Log.info("Chances are you cursor is too small for this platform");
            throw new LWJGLException(llIlIlIIlllIlII);
        }
    }

    public static CursorLoader get() {
        return single;
    }

    private CursorLoader() {
        CursorLoader llIlIlIlIlIllIl;
    }

    public Cursor getCursor(String llIlIlIlIIlIIll, int llIlIlIlIIlIIlI, int llIlIlIlIIIllII) throws IOException, LWJGLException {
        LoadableImageData llIlIlIlIIlIIII = null;
        llIlIlIlIIlIIII = ImageDataFactory.getImageDataFor(llIlIlIlIIlIIll);
        llIlIlIlIIlIIII.configureEdging(false);
        ByteBuffer llIlIlIlIIIllll = llIlIlIlIIlIIII.loadImage(ResourceLoader.getResourceAsStream(llIlIlIlIIlIIll), true, true, null);
        for (int llIlIlIlIIlIlll = 0; llIlIlIlIIlIlll < llIlIlIlIIIllll.limit(); llIlIlIlIIlIlll += 4) {
            byte llIlIlIlIIllIll = llIlIlIlIIIllll.get(llIlIlIlIIlIlll);
            byte llIlIlIlIIllIlI = llIlIlIlIIIllll.get(llIlIlIlIIlIlll + 1);
            byte llIlIlIlIIllIIl = llIlIlIlIIIllll.get(llIlIlIlIIlIlll + 2);
            byte llIlIlIlIIllIII = llIlIlIlIIIllll.get(llIlIlIlIIlIlll + 3);
            llIlIlIlIIIllll.put(llIlIlIlIIlIlll + 2, llIlIlIlIIllIll);
            llIlIlIlIIIllll.put(llIlIlIlIIlIlll + 1, llIlIlIlIIllIlI);
            llIlIlIlIIIllll.put(llIlIlIlIIlIlll, llIlIlIlIIllIIl);
            llIlIlIlIIIllll.put(llIlIlIlIIlIlll + 3, llIlIlIlIIllIII);
        }
        try {
            int llIlIlIlIIlIllI = llIlIlIlIIlIIII.getHeight() - llIlIlIlIIIllII - 1;
            if (llIlIlIlIIlIllI < 0) {
                llIlIlIlIIlIllI = 0;
            }
            return new Cursor(llIlIlIlIIlIIII.getTexWidth(), llIlIlIlIIlIIII.getTexHeight(), llIlIlIlIIlIIlI, llIlIlIlIIlIllI, 1, llIlIlIlIIIllll.asIntBuffer(), null);
        }
        catch (Throwable llIlIlIlIIlIlIl) {
            Log.info("Chances are you cursor is too small for this platform");
            throw new LWJGLException(llIlIlIlIIlIlIl);
        }
    }

    public Cursor getAnimatedCursor(String llIlIlIIIllIIIl, int llIlIlIIIlllIIl, int llIlIlIIIlIllll, int llIlIlIIIlIlllI, int llIlIlIIIlIllIl, int[] llIlIlIIIllIlIl) throws IOException, LWJGLException {
        IntBuffer llIlIlIIIllIlII = ByteBuffer.allocateDirect(llIlIlIIIllIlIl.length * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        for (int llIlIlIIIllllII = 0; llIlIlIIIllllII < llIlIlIIIllIlIl.length; ++llIlIlIIIllllII) {
            llIlIlIIIllIlII.put(llIlIlIIIllIlIl[llIlIlIIIllllII]);
        }
        llIlIlIIIllIlII.flip();
        TGAImageData llIlIlIIIllIIll = new TGAImageData();
        ByteBuffer llIlIlIIIllIIlI = llIlIlIIIllIIll.loadImage(ResourceLoader.getResourceAsStream(llIlIlIIIllIIIl), false, null);
        return new Cursor(llIlIlIIIlIlllI, llIlIlIIIlIllIl, llIlIlIIIlllIIl, llIlIlIIIlIllll, llIlIlIIIllIlIl.length, llIlIlIIIllIIlI.asIntBuffer(), llIlIlIIIllIlII);
    }
}

