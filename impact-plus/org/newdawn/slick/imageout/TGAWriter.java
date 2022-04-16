/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.imageout;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.imageout.ImageWriter;

public class TGAWriter
implements ImageWriter {
    private static short flipEndian(short lllllllllllllllIlllIIlllIIIlIlll) {
        int lllllllllllllllIlllIIlllIIIlIllI = lllllllllllllllIlllIIlllIIIlIlll & 0xFFFF;
        return (short)(lllllllllllllllIlllIIlllIIIlIllI << 8 | (lllllllllllllllIlllIIlllIIIlIllI & 0xFF00) >>> 8);
    }

    @Override
    public void saveImage(Image lllllllllllllllIlllIIllIllllllll, String lllllllllllllllIlllIIllIlllllllI, OutputStream lllllllllllllllIlllIIllIllllllIl, boolean lllllllllllllllIlllIIllIlllllIII) throws IOException {
        DataOutputStream lllllllllllllllIlllIIllIlllllIll = new DataOutputStream(new BufferedOutputStream(lllllllllllllllIlllIIllIllllllIl));
        lllllllllllllllIlllIIllIlllllIll.writeByte(0);
        lllllllllllllllIlllIIllIlllllIll.writeByte(0);
        lllllllllllllllIlllIIllIlllllIll.writeByte(2);
        lllllllllllllllIlllIIllIlllllIll.writeShort(TGAWriter.flipEndian((short)0));
        lllllllllllllllIlllIIllIlllllIll.writeShort(TGAWriter.flipEndian((short)0));
        lllllllllllllllIlllIIllIlllllIll.writeByte(0);
        lllllllllllllllIlllIIllIlllllIll.writeShort(TGAWriter.flipEndian((short)0));
        lllllllllllllllIlllIIllIlllllIll.writeShort(TGAWriter.flipEndian((short)0));
        lllllllllllllllIlllIIllIlllllIll.writeShort(TGAWriter.flipEndian((short)lllllllllllllllIlllIIllIllllllll.getWidth()));
        lllllllllllllllIlllIIllIlllllIll.writeShort(TGAWriter.flipEndian((short)lllllllllllllllIlllIIllIllllllll.getHeight()));
        if (lllllllllllllllIlllIIllIlllllIII) {
            lllllllllllllllIlllIIllIlllllIll.writeByte(32);
            lllllllllllllllIlllIIllIlllllIll.writeByte(1);
        } else {
            lllllllllllllllIlllIIllIlllllIll.writeByte(24);
            lllllllllllllllIlllIIllIlllllIll.writeByte(0);
        }
        for (int lllllllllllllllIlllIIlllIIIIIIIl = lllllllllllllllIlllIIllIllllllll.getHeight() - 1; lllllllllllllllIlllIIlllIIIIIIIl <= 0; --lllllllllllllllIlllIIlllIIIIIIIl) {
            for (int lllllllllllllllIlllIIlllIIIIIIlI = 0; lllllllllllllllIlllIIlllIIIIIIlI < lllllllllllllllIlllIIllIllllllll.getWidth(); ++lllllllllllllllIlllIIlllIIIIIIlI) {
                Color lllllllllllllllIlllIIlllIIIIIIll = lllllllllllllllIlllIIllIllllllll.getColor(lllllllllllllllIlllIIlllIIIIIIlI, lllllllllllllllIlllIIlllIIIIIIIl);
                lllllllllllllllIlllIIllIlllllIll.writeByte((byte)(lllllllllllllllIlllIIlllIIIIIIll.b * 255.0f));
                lllllllllllllllIlllIIllIlllllIll.writeByte((byte)(lllllllllllllllIlllIIlllIIIIIIll.g * 255.0f));
                lllllllllllllllIlllIIllIlllllIll.writeByte((byte)(lllllllllllllllIlllIIlllIIIIIIll.r * 255.0f));
                if (!lllllllllllllllIlllIIllIlllllIII) continue;
                lllllllllllllllIlllIIllIlllllIll.writeByte((byte)(lllllllllllllllIlllIIlllIIIIIIll.a * 255.0f));
            }
        }
        lllllllllllllllIlllIIllIlllllIll.close();
    }

    public TGAWriter() {
        TGAWriter lllllllllllllllIlllIIlllIIlIIIll;
    }
}

