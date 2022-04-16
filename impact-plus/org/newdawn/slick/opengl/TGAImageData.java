/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick.opengl;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.LoadableImageData;

public class TGAImageData
implements LoadableImageData {
    private /* synthetic */ short pixelDepth;
    private /* synthetic */ int texWidth;
    private /* synthetic */ int texHeight;
    private /* synthetic */ int width;
    private /* synthetic */ int height;

    @Override
    public ByteBuffer loadImage(InputStream lllllllllllllllIlllllIlIIIIlllll, boolean lllllllllllllllIlllllIlIIlIlIIIl, boolean lllllllllllllllIlllllIlIIIIllIlI, int[] lllllllllllllllIlllllIlIIIIlIllI) throws IOException {
        TGAImageData lllllllllllllllIlllllIlIIIlIIIII;
        if (lllllllllllllllIlllllIlIIIIlIllI != null) {
            lllllllllllllllIlllllIlIIIIllIlI = true;
        }
        byte lllllllllllllllIlllllIlIIlIIlIll = 0;
        byte lllllllllllllllIlllllIlIIlIIlIIl = 0;
        byte lllllllllllllllIlllllIlIIlIIIlll = 0;
        int lllllllllllllllIlllllIlIIlIIIllI = 0;
        BufferedInputStream lllllllllllllllIlllllIlIIlIIIlIl = new BufferedInputStream(lllllllllllllllIlllllIlIIIIlllll, 100000);
        DataInputStream lllllllllllllllIlllllIlIIlIIIlII = new DataInputStream(lllllllllllllllIlllllIlIIlIIIlIl);
        short lllllllllllllllIlllllIlIIlIIIIlI = (short)lllllllllllllllIlllllIlIIlIIIlII.read();
        short lllllllllllllllIlllllIlIIlIIIIII = (short)lllllllllllllllIlllllIlIIlIIIlII.read();
        short lllllllllllllllIlllllIlIIIllllII = (short)lllllllllllllllIlllllIlIIlIIIlII.read();
        short lllllllllllllllIlllllIlIIIlllIIl = lllllllllllllllIlllllIlIIIlIIIII.flipEndian(lllllllllllllllIlllllIlIIlIIIlII.readShort());
        short lllllllllllllllIlllllIlIIIllIlIl = lllllllllllllllIlllllIlIIIlIIIII.flipEndian(lllllllllllllllIlllllIlIIlIIIlII.readShort());
        short lllllllllllllllIlllllIlIIIllIIlI = (short)lllllllllllllllIlllllIlIIlIIIlII.read();
        short lllllllllllllllIlllllIlIIIlIllll = lllllllllllllllIlllllIlIIIlIIIII.flipEndian(lllllllllllllllIlllllIlIIlIIIlII.readShort());
        short lllllllllllllllIlllllIlIIIlIllII = lllllllllllllllIlllllIlIIIlIIIII.flipEndian(lllllllllllllllIlllllIlIIlIIIlII.readShort());
        if (lllllllllllllllIlllllIlIIIllllII != 2) {
            throw new IOException("Slick only supports uncompressed RGB(A) TGA images");
        }
        lllllllllllllllIlllllIlIIIlIIIII.width = lllllllllllllllIlllllIlIIIlIIIII.flipEndian(lllllllllllllllIlllllIlIIlIIIlII.readShort());
        lllllllllllllllIlllllIlIIIlIIIII.height = lllllllllllllllIlllllIlIIIlIIIII.flipEndian(lllllllllllllllIlllllIlIIlIIIlII.readShort());
        lllllllllllllllIlllllIlIIIlIIIII.pixelDepth = (short)lllllllllllllllIlllllIlIIlIIIlII.read();
        if (lllllllllllllllIlllllIlIIIlIIIII.pixelDepth == 32) {
            lllllllllllllllIlllllIlIIIIllIlI = false;
        }
        lllllllllllllllIlllllIlIIIlIIIII.texWidth = lllllllllllllllIlllllIlIIIlIIIII.get2Fold(lllllllllllllllIlllllIlIIIlIIIII.width);
        lllllllllllllllIlllllIlIIIlIIIII.texHeight = lllllllllllllllIlllllIlIIIlIIIII.get2Fold(lllllllllllllllIlllllIlIIIlIIIII.height);
        short lllllllllllllllIlllllIlIIIlIlIIl = (short)lllllllllllllllIlllllIlIIlIIIlII.read();
        if ((lllllllllllllllIlllllIlIIIlIlIIl & 0x20) == 0) {
            boolean bl = lllllllllllllllIlllllIlIIlIlIIIl = !lllllllllllllllIlllllIlIIlIlIIIl;
        }
        if (lllllllllllllllIlllllIlIIlIIIIlI > 0) {
            lllllllllllllllIlllllIlIIlIIIlIl.skip(lllllllllllllllIlllllIlIIlIIIIlI);
        }
        byte[] lllllllllllllllIlllllIlIIIlIIlll = null;
        if (lllllllllllllllIlllllIlIIIlIIIII.pixelDepth == 32 || lllllllllllllllIlllllIlIIIIllIlI) {
            lllllllllllllllIlllllIlIIIlIIIII.pixelDepth = (short)32;
            lllllllllllllllIlllllIlIIIlIIlll = new byte[lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIII.texHeight * 4];
        } else if (lllllllllllllllIlllllIlIIIlIIIII.pixelDepth == 24) {
            lllllllllllllllIlllllIlIIIlIIlll = new byte[lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIII.texHeight * 3];
        } else {
            throw new RuntimeException("Only 24 and 32 bit TGAs are supported");
        }
        if (lllllllllllllllIlllllIlIIIlIIIII.pixelDepth == 24) {
            if (lllllllllllllllIlllllIlIIlIlIIIl) {
                for (int lllllllllllllllIlllllIlIlIIIIIIl = lllllllllllllllIlllllIlIIIlIIIII.height - 1; lllllllllllllllIlllllIlIlIIIIIIl >= 0; --lllllllllllllllIlllllIlIlIIIIIIl) {
                    for (int lllllllllllllllIlllllIlIlIIIIlII = 0; lllllllllllllllIlllllIlIlIIIIlII < lllllllllllllllIlllllIlIIIlIIIII.width; ++lllllllllllllllIlllllIlIlIIIIlII) {
                        lllllllllllllllIlllllIlIIlIIIlll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIIl = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        int lllllllllllllllIlllllIlIlIIIIllI = (lllllllllllllllIlllllIlIlIIIIlII + lllllllllllllllIlllllIlIlIIIIIIl * lllllllllllllllIlllllIlIIIlIIIII.texWidth) * 3;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIlIIIIllI] = lllllllllllllllIlllllIlIIlIIlIll;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIlIIIIllI + 1] = lllllllllllllllIlllllIlIIlIIlIIl;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIlIIIIllI + 2] = lllllllllllllllIlllllIlIIlIIIlll;
                    }
                }
            } else {
                for (int lllllllllllllllIlllllIlIIllllIll = 0; lllllllllllllllIlllllIlIIllllIll < lllllllllllllllIlllllIlIIIlIIIII.height; ++lllllllllllllllIlllllIlIIllllIll) {
                    for (int lllllllllllllllIlllllIlIIlllllII = 0; lllllllllllllllIlllllIlIIlllllII < lllllllllllllllIlllllIlIIIlIIIII.width; ++lllllllllllllllIlllllIlIIlllllII) {
                        lllllllllllllllIlllllIlIIlIIIlll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIIl = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        int lllllllllllllllIlllllIlIIlllllIl = (lllllllllllllllIlllllIlIIlllllII + lllllllllllllllIlllllIlIIllllIll * lllllllllllllllIlllllIlIIIlIIIII.texWidth) * 3;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllllIl] = lllllllllllllllIlllllIlIIlIIlIll;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllllIl + 1] = lllllllllllllllIlllllIlIIlIIlIIl;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllllIl + 2] = lllllllllllllllIlllllIlIIlIIIlll;
                    }
                }
            }
        } else if (lllllllllllllllIlllllIlIIIlIIIII.pixelDepth == 32) {
            if (lllllllllllllllIlllllIlIIlIlIIIl) {
                for (int lllllllllllllllIlllllIlIIlllIlll = lllllllllllllllIlllllIlIIIlIIIII.height - 1; lllllllllllllllIlllllIlIIlllIlll >= 0; --lllllllllllllllIlllllIlIIlllIlll) {
                    for (int lllllllllllllllIlllllIlIIllllIIl = 0; lllllllllllllllIlllllIlIIllllIIl < lllllllllllllllIlllllIlIIIlIIIII.width; ++lllllllllllllllIlllllIlIIllllIIl) {
                        lllllllllllllllIlllllIlIIlIIIlll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIIl = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIIllI = lllllllllllllllIlllllIlIIIIllIlI ? -1 : (int)lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        int lllllllllllllllIlllllIlIIllllIlI = (lllllllllllllllIlllllIlIIllllIIl + lllllllllllllllIlllllIlIIlllIlll * lllllllllllllllIlllllIlIIIlIIIII.texWidth) * 4;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI] = lllllllllllllllIlllllIlIIlIIlIll;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI + 1] = lllllllllllllllIlllllIlIIlIIlIIl;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI + 2] = lllllllllllllllIlllllIlIIlIIIlll;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI + 3] = lllllllllllllllIlllllIlIIlIIIllI;
                        if (lllllllllllllllIlllllIlIIlIIIllI != 0) continue;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI + 2] = 0;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI + 1] = 0;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllllIlI] = 0;
                    }
                }
            } else {
                for (int lllllllllllllllIlllllIlIIllIlllI = 0; lllllllllllllllIlllllIlIIllIlllI < lllllllllllllllIlllllIlIIIlIIIII.height; ++lllllllllllllllIlllllIlIIllIlllI) {
                    for (int lllllllllllllllIlllllIlIIlllIIIl = 0; lllllllllllllllIlllllIlIIlllIIIl < lllllllllllllllIlllllIlIIIlIIIII.width; ++lllllllllllllllIlllllIlIIlllIIIl) {
                        lllllllllllllllIlllllIlIIlIIIlll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIIl = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIlIll = lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        lllllllllllllllIlllllIlIIlIIIllI = lllllllllllllllIlllllIlIIIIllIlI ? -1 : (int)lllllllllllllllIlllllIlIIlIIIlII.readByte();
                        int lllllllllllllllIlllllIlIIlllIlII = (lllllllllllllllIlllllIlIIlllIIIl + lllllllllllllllIlllllIlIIllIlllI * lllllllllllllllIlllllIlIIIlIIIII.texWidth) * 4;
                        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII] = lllllllllllllllIlllllIlIIlIIlIll;
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 1] = lllllllllllllllIlllllIlIIlIIlIIl;
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 2] = lllllllllllllllIlllllIlIIlIIIlll;
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 3] = lllllllllllllllIlllllIlIIlIIIllI;
                        } else {
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII] = lllllllllllllllIlllllIlIIlIIlIll;
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 1] = lllllllllllllllIlllllIlIIlIIlIIl;
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 2] = lllllllllllllllIlllllIlIIlIIIlll;
                            lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 3] = lllllllllllllllIlllllIlIIlIIIllI;
                        }
                        if (lllllllllllllllIlllllIlIIlIIIllI != 0) continue;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 2] = 0;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII + 1] = 0;
                        lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIlllIlII] = 0;
                    }
                }
            }
        }
        lllllllllllllllIlllllIlIIIIlllll.close();
        if (lllllllllllllllIlllllIlIIIIlIllI != null) {
            for (int lllllllllllllllIlllllIlIIllIlIIl = 0; lllllllllllllllIlllllIlIIllIlIIl < lllllllllllllllIlllllIlIIIlIIlll.length; lllllllllllllllIlllllIlIIllIlIIl += 4) {
                boolean lllllllllllllllIlllllIlIIllIlIlI = true;
                for (int lllllllllllllllIlllllIlIIllIllII = 0; lllllllllllllllIlllllIlIIllIllII < 3; ++lllllllllllllllIlllllIlIIllIllII) {
                    if (lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllIlIIl + lllllllllllllllIlllllIlIIllIllII] == lllllllllllllllIlllllIlIIIIlIllI[lllllllllllllllIlllllIlIIllIllII]) continue;
                    lllllllllllllllIlllllIlIIllIlIlI = false;
                }
                if (!lllllllllllllllIlllllIlIIllIlIlI) continue;
                lllllllllllllllIlllllIlIIIlIIlll[lllllllllllllllIlllllIlIIllIlIIl + 3] = 0;
            }
        }
        ByteBuffer lllllllllllllllIlllllIlIIIlIIlII = BufferUtils.createByteBuffer((int)lllllllllllllllIlllllIlIIIlIIlll.length);
        lllllllllllllllIlllllIlIIIlIIlII.put(lllllllllllllllIlllllIlIIIlIIlll);
        int lllllllllllllllIlllllIlIIIlIIIIl = lllllllllllllllIlllllIlIIIlIIIII.pixelDepth / 8;
        if (lllllllllllllllIlllllIlIIIlIIIII.height < lllllllllllllllIlllllIlIIIlIIIII.texHeight - 1) {
            int lllllllllllllllIlllllIlIIllIIlll = (lllllllllllllllIlllllIlIIIlIIIII.texHeight - 1) * (lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl);
            int lllllllllllllllIlllllIlIIlIlIllI = (lllllllllllllllIlllllIlIIIlIIIII.height - 1) * (lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl);
            for (int lllllllllllllllIlllllIlIIllIlIII = 0; lllllllllllllllIlllllIlIIllIlIII < lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl; ++lllllllllllllllIlllllIlIIllIlIII) {
                lllllllllllllllIlllllIlIIIlIIlII.put(lllllllllllllllIlllllIlIIllIIlll + lllllllllllllllIlllllIlIIllIlIII, lllllllllllllllIlllllIlIIIlIIlII.get(lllllllllllllllIlllllIlIIllIlIII));
                lllllllllllllllIlllllIlIIIlIIlII.put(lllllllllllllllIlllllIlIIlIlIllI + lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl + lllllllllllllllIlllllIlIIllIlIII, lllllllllllllllIlllllIlIIIlIIlII.get(lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl + lllllllllllllllIlllllIlIIllIlIII));
            }
        }
        if (lllllllllllllllIlllllIlIIIlIIIII.width < lllllllllllllllIlllllIlIIIlIIIII.texWidth - 1) {
            for (int lllllllllllllllIlllllIlIIlIlIlII = 0; lllllllllllllllIlllllIlIIlIlIlII < lllllllllllllllIlllllIlIIIlIIIII.texHeight; ++lllllllllllllllIlllllIlIIlIlIlII) {
                for (int lllllllllllllllIlllllIlIIlIlIlIl = 0; lllllllllllllllIlllllIlIIlIlIlIl < lllllllllllllllIlllllIlIIIlIIIIl; ++lllllllllllllllIlllllIlIIlIlIlIl) {
                    lllllllllllllllIlllllIlIIIlIIlII.put((lllllllllllllllIlllllIlIIlIlIlII + 1) * (lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl) - lllllllllllllllIlllllIlIIIlIIIIl + lllllllllllllllIlllllIlIIlIlIlIl, lllllllllllllllIlllllIlIIIlIIlII.get(lllllllllllllllIlllllIlIIlIlIlII * (lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl) + lllllllllllllllIlllllIlIIlIlIlIl));
                    lllllllllllllllIlllllIlIIIlIIlII.put(lllllllllllllllIlllllIlIIlIlIlII * (lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl) + lllllllllllllllIlllllIlIIIlIIIII.width * lllllllllllllllIlllllIlIIIlIIIIl + lllllllllllllllIlllllIlIIlIlIlIl, lllllllllllllllIlllllIlIIIlIIlII.get(lllllllllllllllIlllllIlIIlIlIlII * (lllllllllllllllIlllllIlIIIlIIIII.texWidth * lllllllllllllllIlllllIlIIIlIIIIl) + (lllllllllllllllIlllllIlIIIlIIIII.width - 1) * lllllllllllllllIlllllIlIIIlIIIIl + lllllllllllllllIlllllIlIIlIlIlIl));
                }
            }
        }
        lllllllllllllllIlllllIlIIIlIIlII.flip();
        return lllllllllllllllIlllllIlIIIlIIlII;
    }

    @Override
    public int getWidth() {
        TGAImageData lllllllllllllllIlllllIlIllIIlIII;
        return lllllllllllllllIlllllIlIllIIlIII.width;
    }

    @Override
    public int getTexHeight() {
        TGAImageData lllllllllllllllIlllllIlIlIllllll;
        return lllllllllllllllIlllllIlIlIllllll.texHeight;
    }

    public TGAImageData() {
        TGAImageData lllllllllllllllIlllllIlIllIlIlIl;
    }

    @Override
    public void configureEdging(boolean lllllllllllllllIlllllIIlllIlIlIl) {
    }

    @Override
    public int getTexWidth() {
        TGAImageData lllllllllllllllIlllllIlIllIIIIlI;
        return lllllllllllllllIlllllIlIllIIIIlI.texWidth;
    }

    private short flipEndian(short lllllllllllllllIlllllIlIllIIllll) {
        int lllllllllllllllIlllllIlIllIlIIII = lllllllllllllllIlllllIlIllIIllll & 0xFFFF;
        return (short)(lllllllllllllllIlllllIlIllIlIIII << 8 | (lllllllllllllllIlllllIlIllIlIIII & 0xFF00) >>> 8);
    }

    @Override
    public int getHeight() {
        TGAImageData lllllllllllllllIlllllIlIllIIIllI;
        return lllllllllllllllIlllllIlIllIIIllI.height;
    }

    @Override
    public ByteBuffer getImageBufferData() {
        throw new RuntimeException("TGAImageData doesn't store it's image.");
    }

    private int get2Fold(int lllllllllllllllIlllllIIlllIlllII) {
        int lllllllllllllllIlllllIIlllIlllIl;
        for (lllllllllllllllIlllllIIlllIlllIl = 2; lllllllllllllllIlllllIIlllIlllIl < lllllllllllllllIlllllIIlllIlllII; lllllllllllllllIlllllIIlllIlllIl *= 2) {
        }
        return lllllllllllllllIlllllIIlllIlllIl;
    }

    @Override
    public int getDepth() {
        TGAImageData lllllllllllllllIlllllIlIllIIllII;
        return lllllllllllllllIlllllIlIllIIllII.pixelDepth;
    }

    @Override
    public ByteBuffer loadImage(InputStream lllllllllllllllIlllllIlIlIlllIll) throws IOException {
        TGAImageData lllllllllllllllIlllllIlIlIlllIlI;
        return lllllllllllllllIlllllIlIlIlllIlI.loadImage(lllllllllllllllIlllllIlIlIlllIll, true, null);
    }

    @Override
    public ByteBuffer loadImage(InputStream lllllllllllllllIlllllIlIlIllIIll, boolean lllllllllllllllIlllllIlIlIllIIlI, int[] lllllllllllllllIlllllIlIlIllIIIl) throws IOException {
        TGAImageData lllllllllllllllIlllllIlIlIllIIII;
        return lllllllllllllllIlllllIlIlIllIIII.loadImage(lllllllllllllllIlllllIlIlIllIIll, lllllllllllllllIlllllIlIlIllIIlI, false, lllllllllllllllIlllllIlIlIllIIIl);
    }
}

