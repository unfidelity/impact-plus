/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.newdawn.slick.opengl.CompositeIOException;
import org.newdawn.slick.opengl.LoadableImageData;
import org.newdawn.slick.util.Log;

public class CompositeImageData
implements LoadableImageData {
    private /* synthetic */ LoadableImageData picked;
    private /* synthetic */ ArrayList sources;

    @Override
    public ByteBuffer loadImage(InputStream lIllllIlIIIlIlI, boolean lIllllIlIIIlIIl, boolean lIllllIlIIIIIII, int[] lIllllIlIIIIlll) throws IOException {
        CompositeImageData lIllllIlIIIlIll;
        CompositeIOException lIllllIlIIIIllI = new CompositeIOException();
        ByteBuffer lIllllIlIIIIlIl = null;
        BufferedInputStream lIllllIlIIIIlII = new BufferedInputStream(lIllllIlIIIlIlI, lIllllIlIIIlIlI.available());
        lIllllIlIIIIlII.mark(lIllllIlIIIlIlI.available());
        for (int lIllllIlIIIllII = 0; lIllllIlIIIllII < lIllllIlIIIlIll.sources.size(); ++lIllllIlIIIllII) {
            lIllllIlIIIIlII.reset();
            try {
                LoadableImageData lIllllIlIIIlllI = (LoadableImageData)lIllllIlIIIlIll.sources.get(lIllllIlIIIllII);
                lIllllIlIIIIlIl = lIllllIlIIIlllI.loadImage(lIllllIlIIIIlII, lIllllIlIIIlIIl, lIllllIlIIIIIII, lIllllIlIIIIlll);
                lIllllIlIIIlIll.picked = lIllllIlIIIlllI;
                break;
            }
            catch (Exception lIllllIlIIIllIl) {
                Log.warn(String.valueOf(new StringBuilder().append(lIllllIlIIIlIll.sources.get(lIllllIlIIIllII).getClass()).append(" failed to read the data")), lIllllIlIIIllIl);
                lIllllIlIIIIllI.addException(lIllllIlIIIllIl);
                continue;
            }
        }
        if (lIllllIlIIIlIll.picked == null) {
            throw lIllllIlIIIIllI;
        }
        return lIllllIlIIIIlIl;
    }

    @Override
    public int getTexWidth() {
        CompositeImageData lIllllIIllIlIII;
        lIllllIIllIlIII.checkPicked();
        return lIllllIIllIlIII.picked.getTexWidth();
    }

    @Override
    public ByteBuffer loadImage(InputStream lIllllIlIlIIlIl) throws IOException {
        CompositeImageData lIllllIlIlIIllI;
        return lIllllIlIlIIllI.loadImage(lIllllIlIlIIlIl, false, null);
    }

    public CompositeImageData() {
        CompositeImageData lIllllIlIllIIlI;
        lIllllIlIllIIlI.sources = new ArrayList();
    }

    @Override
    public ByteBuffer loadImage(InputStream lIllllIlIIllIll, boolean lIllllIlIIllllI, int[] lIllllIlIIllIIl) throws IOException {
        CompositeImageData lIllllIlIlIIIII;
        return lIllllIlIlIIIII.loadImage(lIllllIlIIllIll, lIllllIlIIllllI, false, lIllllIlIIllIIl);
    }

    @Override
    public int getDepth() {
        CompositeImageData lIllllIIlllIlIl;
        lIllllIIlllIlIl.checkPicked();
        return lIllllIIlllIlIl.picked.getDepth();
    }

    @Override
    public int getTexHeight() {
        CompositeImageData lIllllIIllIllII;
        lIllllIIllIllII.checkPicked();
        return lIllllIIllIllII.picked.getTexHeight();
    }

    @Override
    public void configureEdging(boolean lIllllIIlIlllll) {
        CompositeImageData lIllllIIllIIIII;
        for (int lIllllIIllIIIIl = 0; lIllllIIllIIIIl < lIllllIIllIIIII.sources.size(); ++lIllllIIllIIIIl) {
            ((LoadableImageData)lIllllIIllIIIII.sources.get(lIllllIIllIIIIl)).configureEdging(lIllllIIlIlllll);
        }
    }

    @Override
    public int getHeight() {
        CompositeImageData lIllllIIlllIIIl;
        lIllllIIlllIIIl.checkPicked();
        return lIllllIIlllIIIl.picked.getHeight();
    }

    private void checkPicked() {
        CompositeImageData lIllllIIllllIII;
        if (lIllllIIllllIII.picked == null) {
            throw new RuntimeException("Attempt to make use of uninitialised or invalid composite image data");
        }
    }

    @Override
    public ByteBuffer getImageBufferData() {
        CompositeImageData lIllllIIllIlllI;
        lIllllIIllIlllI.checkPicked();
        return lIllllIIllIlllI.picked.getImageBufferData();
    }

    public void add(LoadableImageData lIllllIlIlIllIl) {
        CompositeImageData lIllllIlIlIllII;
        lIllllIlIlIllII.sources.add(lIllllIlIlIllIl);
    }

    @Override
    public int getWidth() {
        CompositeImageData lIllllIIllIIllI;
        lIllllIIllIIllI.checkPicked();
        return lIllllIIllIIllI.picked.getWidth();
    }
}

