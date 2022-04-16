/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.openal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.newdawn.slick.openal.OggData;
import org.newdawn.slick.openal.OggInputStream;

public class OggDecoder {
    private /* synthetic */ int convsize;
    private /* synthetic */ byte[] convbuffer;

    public OggDecoder() {
        OggDecoder lllllllIlIlIIlI;
        lllllllIlIlIIlI.convsize = 16384;
        lllllllIlIlIIlI.convbuffer = new byte[lllllllIlIlIIlI.convsize];
    }

    public OggData getData(InputStream lllllllIlIIIlII) throws IOException {
        if (lllllllIlIIIlII == null) {
            throw new IOException("Failed to read OGG, source does not exist?");
        }
        ByteArrayOutputStream lllllllIlIIlIIl = new ByteArrayOutputStream();
        OggInputStream lllllllIlIIlIII = new OggInputStream(lllllllIlIIIlII);
        boolean lllllllIlIIIlll = false;
        while (!lllllllIlIIlIII.atEnd()) {
            lllllllIlIIlIIl.write(lllllllIlIIlIII.read());
        }
        OggData lllllllIlIIIllI = new OggData();
        lllllllIlIIIllI.channels = lllllllIlIIlIII.getChannels();
        lllllllIlIIIllI.rate = lllllllIlIIlIII.getRate();
        byte[] lllllllIlIIIlIl = lllllllIlIIlIIl.toByteArray();
        lllllllIlIIIllI.data = ByteBuffer.allocateDirect(lllllllIlIIIlIl.length);
        lllllllIlIIIllI.data.put(lllllllIlIIIlIl);
        lllllllIlIIIllI.data.rewind();
        return lllllllIlIIIllI;
    }
}

