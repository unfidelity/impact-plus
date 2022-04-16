/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class PNGDecoder {
    private /* synthetic */ int bytesPerPixel;
    private static final /* synthetic */ int IEND;
    public static /* synthetic */ Format RGB;
    private final /* synthetic */ InputStream input;
    private /* synthetic */ int chunkLength;
    public static /* synthetic */ Format ABGR;
    private /* synthetic */ int width;
    private static final /* synthetic */ int IDAT;
    private static final /* synthetic */ byte COLOR_INDEXED;
    private /* synthetic */ int chunkRemaining;
    private final /* synthetic */ CRC32 crc;
    private /* synthetic */ int bitdepth;
    private static final /* synthetic */ int PLTE;
    private static final /* synthetic */ byte COLOR_GREYALPHA;
    private /* synthetic */ int height;
    private static final /* synthetic */ int IHDR;
    private static final /* synthetic */ byte COLOR_TRUEALPHA;
    private static final /* synthetic */ int tRNS;
    public static /* synthetic */ Format LUMINANCE_ALPHA;
    private /* synthetic */ byte[] paletteA;
    public static /* synthetic */ Format BGRA;
    private static final /* synthetic */ byte COLOR_GREYSCALE;
    public static /* synthetic */ Format ALPHA;
    public static /* synthetic */ Format RGBA;
    private final /* synthetic */ byte[] buffer;
    private /* synthetic */ int colorType;
    private /* synthetic */ byte[] palette;
    private /* synthetic */ byte[] transPixel;
    public static /* synthetic */ Format LUMINANCE;
    private static final /* synthetic */ byte COLOR_TRUECOLOR;
    private static final /* synthetic */ byte[] SIGNATURE;
    private /* synthetic */ int chunkType;

    private void copyRGBAtoBGRA(ByteBuffer lllllllllllllllllIllIlIIllllllII, byte[] lllllllllllllllllIllIlIIlllllIIl) {
        int lllllllllllllllllIllIlIIlllllllI = lllllllllllllllllIllIlIIlllllIIl.length;
        for (int lllllllllllllllllIllIlIIllllllll = 1; lllllllllllllllllIllIlIIllllllll < lllllllllllllllllIllIlIIlllllllI; lllllllllllllllllIllIlIIllllllll += 4) {
            lllllllllllllllllIllIlIIllllllII.put(lllllllllllllllllIllIlIIlllllIIl[lllllllllllllllllIllIlIIllllllll + 2]).put(lllllllllllllllllIllIlIIlllllIIl[lllllllllllllllllIllIlIIllllllll + 1]).put(lllllllllllllllllIllIlIIlllllIIl[lllllllllllllllllIllIlIIllllllll + 0]).put(lllllllllllllllllIllIlIIlllllIIl[lllllllllllllllllIllIlIIllllllll + 3]);
        }
    }

    private void closeChunk() throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIIIlIIII;
        if (lllllllllllllllllIllIIllIIIlIIII.chunkRemaining > 0) {
            lllllllllllllllllIllIIllIIIlIIII.skip(lllllllllllllllllIllIIllIIIlIIII.chunkRemaining + 4);
        } else {
            lllllllllllllllllIllIIllIIIlIIII.readFully(lllllllllllllllllIllIIllIIIlIIII.buffer, 0, 4);
            int lllllllllllllllllIllIIllIIIlIIll = lllllllllllllllllIllIIllIIIlIIII.readInt(lllllllllllllllllIllIIllIIIlIIII.buffer, 0);
            int lllllllllllllllllIllIIllIIIlIIlI = (int)lllllllllllllllllIllIIllIIIlIIII.crc.getValue();
            if (lllllllllllllllllIllIIllIIIlIIlI != lllllllllllllllllIllIIllIIIlIIll) {
                throw new IOException("Invalid CRC");
            }
        }
        lllllllllllllllllIllIIllIIIlIIII.chunkRemaining = 0;
        lllllllllllllllllIllIIllIIIlIIII.chunkLength = 0;
        lllllllllllllllllIllIIllIIIlIIII.chunkType = 0;
    }

    private void checkChunkLength(int lllllllllllllllllIllIIlIllllllll) throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIIIIIIII;
        if (lllllllllllllllllIllIIllIIIIIIII.chunkLength != lllllllllllllllllIllIIlIllllllll) {
            throw new IOException("Chunk has wrong size");
        }
    }

    public Format decideTextureFormat(Format lllllllllllllllllIllIlIllIllIIlI) {
        PNGDecoder lllllllllllllllllIllIlIllIllIIIl;
        switch (lllllllllllllllllIllIlIllIllIIIl.colorType) {
            case 2: {
                if (lllllllllllllllllIllIlIllIllIIlI == ABGR || lllllllllllllllllIllIlIllIllIIlI == RGBA || lllllllllllllllllIllIlIllIllIIlI == BGRA || lllllllllllllllllIllIlIllIllIIlI == RGB) {
                    return lllllllllllllllllIllIlIllIllIIlI;
                }
                return RGB;
            }
            case 6: {
                if (lllllllllllllllllIllIlIllIllIIlI == ABGR || lllllllllllllllllIllIlIllIllIIlI == RGBA || lllllllllllllllllIllIlIllIllIIlI == BGRA || lllllllllllllllllIllIlIllIllIIlI == RGB) {
                    return lllllllllllllllllIllIlIllIllIIlI;
                }
                return RGBA;
            }
            case 0: {
                if (lllllllllllllllllIllIlIllIllIIlI == LUMINANCE || lllllllllllllllllIllIlIllIllIIlI == ALPHA) {
                    return lllllllllllllllllIllIlIllIllIIlI;
                }
                return LUMINANCE;
            }
            case 4: {
                return LUMINANCE_ALPHA;
            }
            case 3: {
                if (lllllllllllllllllIllIlIllIllIIlI == ABGR || lllllllllllllllllIllIlIllIllIIlI == RGBA || lllllllllllllllllIllIlIllIllIIlI == BGRA) {
                    return lllllllllllllllllIllIlIllIllIIlI;
                }
                return RGBA;
            }
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean hasAlpha() {
        PNGDecoder lllllllllllllllllIllIlIllIlllIlI;
        return lllllllllllllllllIllIlIllIlllIlI.colorType == 6 || lllllllllllllllllIllIlIllIlllIlI.paletteA != null || lllllllllllllllllIllIlIllIlllIlI.transPixel != null;
    }

    private void unfilterAverage(byte[] lllllllllllllllllIllIIlllIIIlIIl, byte[] lllllllllllllllllIllIIlllIIIlIII) {
        int lllllllllllllllllIllIIlllIIIlIll;
        PNGDecoder lllllllllllllllllIllIIlllIIIlIlI;
        int lllllllllllllllllIllIIlllIIIllII = lllllllllllllllllIllIIlllIIIlIlI.bytesPerPixel;
        for (lllllllllllllllllIllIIlllIIIlIll = 1; lllllllllllllllllIllIIlllIIIlIll <= lllllllllllllllllIllIIlllIIIllII; ++lllllllllllllllllIllIIlllIIIlIll) {
            int n = lllllllllllllllllIllIIlllIIIlIll;
            lllllllllllllllllIllIIlllIIIlIIl[n] = (byte)(lllllllllllllllllIllIIlllIIIlIIl[n] + (byte)((lllllllllllllllllIllIIlllIIIlIII[lllllllllllllllllIllIIlllIIIlIll] & 0xFF) >>> 1));
        }
        int lllllllllllllllllIllIIlllIIlIIlI = lllllllllllllllllIllIIlllIIIlIIl.length;
        while (lllllllllllllllllIllIIlllIIIlIll < lllllllllllllllllIllIIlllIIlIIlI) {
            int n = lllllllllllllllllIllIIlllIIIlIll;
            lllllllllllllllllIllIIlllIIIlIIl[n] = (byte)(lllllllllllllllllIllIIlllIIIlIIl[n] + (byte)((lllllllllllllllllIllIIlllIIIlIII[lllllllllllllllllIllIIlllIIIlIll] & 0xFF) + (lllllllllllllllllIllIIlllIIIlIIl[lllllllllllllllllIllIIlllIIIlIll - lllllllllllllllllIllIIlllIIIllII] & 0xFF) >>> 1));
            ++lllllllllllllllllIllIIlllIIIlIll;
        }
    }

    private void refillInflater(Inflater lllllllllllllllllIllIIlIllIlIlII) throws IOException {
        PNGDecoder lllllllllllllllllIllIIlIllIlIlIl;
        while (lllllllllllllllllIllIIlIllIlIlIl.chunkRemaining == 0) {
            lllllllllllllllllIllIIlIllIlIlIl.closeChunk();
            lllllllllllllllllIllIIlIllIlIlIl.openChunk(1229209940);
        }
        int lllllllllllllllllIllIIlIllIlIIlI = lllllllllllllllllIllIIlIllIlIlIl.readChunk(lllllllllllllllllIllIIlIllIlIlIl.buffer, 0, lllllllllllllllllIllIIlIllIlIlIl.buffer.length);
        lllllllllllllllllIllIIlIllIlIlII.setInput(lllllllllllllllllIllIIlIllIlIlIl.buffer, 0, lllllllllllllllllIllIIlIllIlIIlI);
    }

    private void copyRGBtoRGBA(ByteBuffer lllllllllllllllllIllIlIlIlIIIlII, byte[] lllllllllllllllllIllIlIlIlIIIIII) {
        PNGDecoder lllllllllllllllllIllIlIlIlIIIlIl;
        if (lllllllllllllllllIllIlIlIlIIIlIl.transPixel != null) {
            byte lllllllllllllllllIllIlIlIlIIlIlI = lllllllllllllllllIllIlIlIlIIIlIl.transPixel[1];
            byte lllllllllllllllllIllIlIlIlIIlIIl = lllllllllllllllllIllIlIlIlIIIlIl.transPixel[3];
            byte lllllllllllllllllIllIlIlIlIIlIII = lllllllllllllllllIllIlIlIlIIIlIl.transPixel[5];
            int lllllllllllllllllIllIlIlIlIIlIll = lllllllllllllllllIllIlIlIlIIIIII.length;
            for (int lllllllllllllllllIllIlIlIlIIllII = 1; lllllllllllllllllIllIlIlIlIIllII < lllllllllllllllllIllIlIlIlIIlIll; lllllllllllllllllIllIlIlIlIIllII += 3) {
                byte lllllllllllllllllIllIlIlIlIlIIII = lllllllllllllllllIllIlIlIlIIIIII[lllllllllllllllllIllIlIlIlIIllII];
                byte lllllllllllllllllIllIlIlIlIIllll = lllllllllllllllllIllIlIlIlIIIIII[lllllllllllllllllIllIlIlIlIIllII + 1];
                byte lllllllllllllllllIllIlIlIlIIlllI = lllllllllllllllllIllIlIlIlIIIIII[lllllllllllllllllIllIlIlIlIIllII + 2];
                byte lllllllllllllllllIllIlIlIlIIllIl = -1;
                if (lllllllllllllllllIllIlIlIlIlIIII == lllllllllllllllllIllIlIlIlIIlIlI && lllllllllllllllllIllIlIlIlIIllll == lllllllllllllllllIllIlIlIlIIlIIl && lllllllllllllllllIllIlIlIlIIlllI == lllllllllllllllllIllIlIlIlIIlIII) {
                    lllllllllllllllllIllIlIlIlIIllIl = 0;
                }
                lllllllllllllllllIllIlIlIlIIIlII.put(lllllllllllllllllIllIlIlIlIlIIII).put(lllllllllllllllllIllIlIlIlIIllll).put(lllllllllllllllllIllIlIlIlIIlllI).put(lllllllllllllllllIllIlIlIlIIllIl);
            }
        } else {
            int lllllllllllllllllIllIlIlIlIIIllI = lllllllllllllllllIllIlIlIlIIIIII.length;
            for (int lllllllllllllllllIllIlIlIlIIIlll = 1; lllllllllllllllllIllIlIlIlIIIlll < lllllllllllllllllIllIlIlIlIIIllI; lllllllllllllllllIllIlIlIlIIIlll += 3) {
                lllllllllllllllllIllIlIlIlIIIlII.put(lllllllllllllllllIllIlIlIlIIIIII[lllllllllllllllllIllIlIlIlIIIlll]).put(lllllllllllllllllIllIlIlIlIIIIII[lllllllllllllllllIllIlIlIlIIIlll + 1]).put(lllllllllllllllllIllIlIlIlIIIIII[lllllllllllllllllIllIlIlIlIIIlll + 2]).put((byte)-1);
            }
        }
    }

    private void expand4(byte[] lllllllllllllllllIllIlIIIIlllIII, byte[] lllllllllllllllllIllIlIIIIllIlIl) {
        int lllllllllllllllllIllIlIIIIlllIlI = lllllllllllllllllIllIlIIIIllIlIl.length;
        for (int lllllllllllllllllIllIlIIIIlllIll = 1; lllllllllllllllllIllIlIIIIlllIll < lllllllllllllllllIllIlIIIIlllIlI; lllllllllllllllllIllIlIIIIlllIll += 2) {
            int lllllllllllllllllIllIlIIIIllllII = lllllllllllllllllIllIlIIIIlllIII[1 + (lllllllllllllllllIllIlIIIIlllIll >> 1)] & 0xFF;
            switch (lllllllllllllllllIllIlIIIIlllIlI - lllllllllllllllllIllIlIIIIlllIll) {
                default: {
                    lllllllllllllllllIllIlIIIIllIlIl[lllllllllllllllllIllIlIIIIlllIll + 1] = (byte)(lllllllllllllllllIllIlIIIIllllII & 0xF);
                }
                case 1: 
            }
            lllllllllllllllllIllIlIIIIllIlIl[lllllllllllllllllIllIlIIIIlllIll] = (byte)(lllllllllllllllllIllIlIIIIllllII >> 4);
        }
    }

    private void unfilterUp(byte[] lllllllllllllllllIllIIlllIIlllll, byte[] lllllllllllllllllIllIIlllIIllllI) {
        PNGDecoder lllllllllllllllllIllIIlllIlIIIII;
        int lllllllllllllllllIllIIlllIlIIIIl = lllllllllllllllllIllIIlllIlIIIII.bytesPerPixel;
        int lllllllllllllllllIllIIlllIlIIllI = lllllllllllllllllIllIIlllIIlllll.length;
        for (int lllllllllllllllllIllIIlllIlIlIII = 1; lllllllllllllllllIllIIlllIlIlIII < lllllllllllllllllIllIIlllIlIIllI; ++lllllllllllllllllIllIIlllIlIlIII) {
            int n = lllllllllllllllllIllIIlllIlIlIII;
            lllllllllllllllllIllIIlllIIlllll[n] = (byte)(lllllllllllllllllIllIIlllIIlllll[n] + lllllllllllllllllIllIIlllIIllllI[lllllllllllllllllIllIIlllIlIlIII]);
        }
    }

    private int readInt(byte[] lllllllllllllllllIllIIlIlIIIIIll, int lllllllllllllllllIllIIlIlIIIIlII) {
        return lllllllllllllllllIllIIlIlIIIIIll[lllllllllllllllllIllIIlIlIIIIlII] << 24 | (lllllllllllllllllIllIIlIlIIIIIll[lllllllllllllllllIllIIlIlIIIIlII + 1] & 0xFF) << 16 | (lllllllllllllllllIllIIlIlIIIIIll[lllllllllllllllllIllIIlIlIIIIlII + 2] & 0xFF) << 8 | lllllllllllllllllIllIIlIlIIIIIll[lllllllllllllllllIllIIlIlIIIIlII + 3] & 0xFF;
    }

    private void copyPALtoRGBA(ByteBuffer lllllllllllllllllIllIlIIlIIIlIII, byte[] lllllllllllllllllIllIlIIlIIIIlII) {
        PNGDecoder lllllllllllllllllIllIlIIlIIIlIIl;
        if (lllllllllllllllllIllIlIIlIIIlIIl.paletteA != null) {
            int lllllllllllllllllIllIlIIlIIlIIIl = lllllllllllllllllIllIlIIlIIIIlII.length;
            for (int lllllllllllllllllIllIlIIlIIlIIlI = 1; lllllllllllllllllIllIlIIlIIlIIlI < lllllllllllllllllIllIlIIlIIlIIIl; ++lllllllllllllllllIllIlIIlIIlIIlI) {
                int lllllllllllllllllIllIlIIlIIllIIl = lllllllllllllllllIllIlIIlIIIIlII[lllllllllllllllllIllIlIIlIIlIIlI] & 0xFF;
                byte lllllllllllllllllIllIlIIlIIlIlll = lllllllllllllllllIllIlIIlIIIlIIl.palette[lllllllllllllllllIllIlIIlIIllIIl * 3 + 0];
                byte lllllllllllllllllIllIlIIlIIlIlIl = lllllllllllllllllIllIlIIlIIIlIIl.palette[lllllllllllllllllIllIlIIlIIllIIl * 3 + 1];
                byte lllllllllllllllllIllIlIIlIIlIlII = lllllllllllllllllIllIlIIlIIIlIIl.palette[lllllllllllllllllIllIlIIlIIllIIl * 3 + 2];
                byte lllllllllllllllllIllIlIIlIIlIIll = lllllllllllllllllIllIlIIlIIIlIIl.paletteA[lllllllllllllllllIllIlIIlIIllIIl];
                lllllllllllllllllIllIlIIlIIIlIII.put(lllllllllllllllllIllIlIIlIIlIlll).put(lllllllllllllllllIllIlIIlIIlIlIl).put(lllllllllllllllllIllIlIIlIIlIlII).put(lllllllllllllllllIllIlIIlIIlIIll);
            }
        } else {
            int lllllllllllllllllIllIlIIlIIIlIlI = lllllllllllllllllIllIlIIlIIIIlII.length;
            for (int lllllllllllllllllIllIlIIlIIIlIll = 1; lllllllllllllllllIllIlIIlIIIlIll < lllllllllllllllllIllIlIIlIIIlIlI; ++lllllllllllllllllIllIlIIlIIIlIll) {
                int lllllllllllllllllIllIlIIlIIlIIII = lllllllllllllllllIllIlIIlIIIIlII[lllllllllllllllllIllIlIIlIIIlIll] & 0xFF;
                byte lllllllllllllllllIllIlIIlIIIllll = lllllllllllllllllIllIlIIlIIIlIIl.palette[lllllllllllllllllIllIlIIlIIlIIII * 3 + 0];
                byte lllllllllllllllllIllIlIIlIIIlllI = lllllllllllllllllIllIlIIlIIIlIIl.palette[lllllllllllllllllIllIlIIlIIlIIII * 3 + 1];
                byte lllllllllllllllllIllIlIIlIIIllIl = lllllllllllllllllIllIlIIlIIIlIIl.palette[lllllllllllllllllIllIlIIlIIlIIII * 3 + 2];
                byte lllllllllllllllllIllIlIIlIIIllII = -1;
                lllllllllllllllllIllIlIIlIIIlIII.put(lllllllllllllllllIllIlIIlIIIllll).put(lllllllllllllllllIllIlIIlIIIlllI).put(lllllllllllllllllIllIlIIlIIIllIl).put(lllllllllllllllllIllIlIIlIIIllII);
            }
        }
    }

    private void copyPALtoBGRA(ByteBuffer lllllllllllllllllIllIlIIIlIlIIlI, byte[] lllllllllllllllllIllIlIIIlIIlIll) {
        PNGDecoder lllllllllllllllllIllIlIIIlIIllll;
        if (lllllllllllllllllIllIlIIIlIIllll.paletteA != null) {
            int lllllllllllllllllIllIlIIIllIIIlI = lllllllllllllllllIllIlIIIlIIlIll.length;
            for (int lllllllllllllllllIllIlIIIllIIIll = 1; lllllllllllllllllIllIlIIIllIIIll < lllllllllllllllllIllIlIIIllIIIlI; ++lllllllllllllllllIllIlIIIllIIIll) {
                int lllllllllllllllllIllIlIIIllIlIlI = lllllllllllllllllIllIlIIIlIIlIll[lllllllllllllllllIllIlIIIllIIIll] & 0xFF;
                byte lllllllllllllllllIllIlIIIllIlIIl = lllllllllllllllllIllIlIIIlIIllll.palette[lllllllllllllllllIllIlIIIllIlIlI * 3 + 0];
                byte lllllllllllllllllIllIlIIIllIlIII = lllllllllllllllllIllIlIIIlIIllll.palette[lllllllllllllllllIllIlIIIllIlIlI * 3 + 1];
                byte lllllllllllllllllIllIlIIIllIIlll = lllllllllllllllllIllIlIIIlIIllll.palette[lllllllllllllllllIllIlIIIllIlIlI * 3 + 2];
                byte lllllllllllllllllIllIlIIIllIIlIl = lllllllllllllllllIllIlIIIlIIllll.paletteA[lllllllllllllllllIllIlIIIllIlIlI];
                lllllllllllllllllIllIlIIIlIlIIlI.put(lllllllllllllllllIllIlIIIllIIlll).put(lllllllllllllllllIllIlIIIllIlIII).put(lllllllllllllllllIllIlIIIllIlIIl).put(lllllllllllllllllIllIlIIIllIIlIl);
            }
        } else {
            int lllllllllllllllllIllIlIIIlIlIlIl = lllllllllllllllllIllIlIIIlIIlIll.length;
            for (int lllllllllllllllllIllIlIIIlIlIlll = 1; lllllllllllllllllIllIlIIIlIlIlll < lllllllllllllllllIllIlIIIlIlIlIl; ++lllllllllllllllllIllIlIIIlIlIlll) {
                int lllllllllllllllllIllIlIIIllIIIII = lllllllllllllllllIllIlIIIlIIlIll[lllllllllllllllllIllIlIIIlIlIlll] & 0xFF;
                byte lllllllllllllllllIllIlIIIlIlllll = lllllllllllllllllIllIlIIIlIIllll.palette[lllllllllllllllllIllIlIIIllIIIII * 3 + 0];
                byte lllllllllllllllllIllIlIIIlIlllIl = lllllllllllllllllIllIlIIIlIIllll.palette[lllllllllllllllllIllIlIIIllIIIII * 3 + 1];
                byte lllllllllllllllllIllIlIIIlIllIll = lllllllllllllllllIllIlIIIlIIllll.palette[lllllllllllllllllIllIlIIIllIIIII * 3 + 2];
                byte lllllllllllllllllIllIlIIIlIllIIl = -1;
                lllllllllllllllllIllIlIIIlIlIIlI.put(lllllllllllllllllIllIlIIIlIllIll).put(lllllllllllllllllIllIlIIIlIlllIl).put(lllllllllllllllllIllIlIIIlIlllll).put(lllllllllllllllllIllIlIIIlIllIIl);
            }
        }
    }

    public int getWidth() {
        PNGDecoder lllllllllllllllllIllIlIllIllllIl;
        return lllllllllllllllllIllIlIllIllllIl.width;
    }

    public int getHeight() {
        PNGDecoder lllllllllllllllllIllIlIllIllllll;
        return lllllllllllllllllIllIlIllIllllll.height;
    }

    private void readIHDR() throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIlIIIllI;
        lllllllllllllllllIllIIllIlIIIllI.checkChunkLength(13);
        lllllllllllllllllIllIIllIlIIIllI.readChunk(lllllllllllllllllIllIIllIlIIIllI.buffer, 0, 13);
        lllllllllllllllllIllIIllIlIIIllI.width = lllllllllllllllllIllIIllIlIIIllI.readInt(lllllllllllllllllIllIIllIlIIIllI.buffer, 0);
        lllllllllllllllllIllIIllIlIIIllI.height = lllllllllllllllllIllIIllIlIIIllI.readInt(lllllllllllllllllIllIIllIlIIIllI.buffer, 4);
        lllllllllllllllllIllIIllIlIIIllI.bitdepth = lllllllllllllllllIllIIllIlIIIllI.buffer[8] & 0xFF;
        lllllllllllllllllIllIIllIlIIIllI.colorType = lllllllllllllllllIllIIllIlIIIllI.buffer[9] & 0xFF;
        block0 : switch (lllllllllllllllllIllIIllIlIIIllI.colorType) {
            case 0: {
                if (lllllllllllllllllIllIIllIlIIIllI.bitdepth != 8) {
                    throw new IOException(String.valueOf(new StringBuilder().append("Unsupported bit depth: ").append(lllllllllllllllllIllIIllIlIIIllI.bitdepth)));
                }
                lllllllllllllllllIllIIllIlIIIllI.bytesPerPixel = 1;
                break;
            }
            case 4: {
                if (lllllllllllllllllIllIIllIlIIIllI.bitdepth != 8) {
                    throw new IOException(String.valueOf(new StringBuilder().append("Unsupported bit depth: ").append(lllllllllllllllllIllIIllIlIIIllI.bitdepth)));
                }
                lllllllllllllllllIllIIllIlIIIllI.bytesPerPixel = 2;
                break;
            }
            case 2: {
                if (lllllllllllllllllIllIIllIlIIIllI.bitdepth != 8) {
                    throw new IOException(String.valueOf(new StringBuilder().append("Unsupported bit depth: ").append(lllllllllllllllllIllIIllIlIIIllI.bitdepth)));
                }
                lllllllllllllllllIllIIllIlIIIllI.bytesPerPixel = 3;
                break;
            }
            case 6: {
                if (lllllllllllllllllIllIIllIlIIIllI.bitdepth != 8) {
                    throw new IOException(String.valueOf(new StringBuilder().append("Unsupported bit depth: ").append(lllllllllllllllllIllIIllIlIIIllI.bitdepth)));
                }
                lllllllllllllllllIllIIllIlIIIllI.bytesPerPixel = 4;
                break;
            }
            case 3: {
                switch (lllllllllllllllllIllIIllIlIIIllI.bitdepth) {
                    case 1: 
                    case 2: 
                    case 4: 
                    case 8: {
                        lllllllllllllllllIllIIllIlIIIllI.bytesPerPixel = 1;
                        break block0;
                    }
                }
                throw new IOException(String.valueOf(new StringBuilder().append("Unsupported bit depth: ").append(lllllllllllllllllIllIIllIlIIIllI.bitdepth)));
            }
            default: {
                throw new IOException(String.valueOf(new StringBuilder().append("unsupported color format: ").append(lllllllllllllllllIllIIllIlIIIllI.colorType)));
            }
        }
        if (lllllllllllllllllIllIIllIlIIIllI.buffer[10] != 0) {
            throw new IOException("unsupported compression method");
        }
        if (lllllllllllllllllIllIIllIlIIIllI.buffer[11] != 0) {
            throw new IOException("unsupported filtering method");
        }
        if (lllllllllllllllllIllIIllIlIIIllI.buffer[12] != 0) {
            throw new IOException("unsupported interlace method");
        }
    }

    private static boolean checkSignature(byte[] lllllllllllllllllIllIIlIIlllIIII) {
        for (int lllllllllllllllllIllIIlIIlllIlII = 0; lllllllllllllllllIllIIlIIlllIlII < SIGNATURE.length; ++lllllllllllllllllIllIIlIIlllIlII) {
            if (lllllllllllllllllIllIIlIIlllIIII[lllllllllllllllllIllIIlIIlllIlII] == SIGNATURE[lllllllllllllllllIllIIlIIlllIlII]) continue;
            return false;
        }
        return true;
    }

    private void expand2(byte[] lllllllllllllllllIllIlIIIIIllIII, byte[] lllllllllllllllllIllIlIIIIIlIllI) {
        int lllllllllllllllllIllIlIIIIlIIIIl = lllllllllllllllllIllIlIIIIIlIllI.length;
        for (int lllllllllllllllllIllIlIIIIlIIIll = 1; lllllllllllllllllIllIlIIIIlIIIll < lllllllllllllllllIllIlIIIIlIIIIl; lllllllllllllllllIllIlIIIIlIIIll += 4) {
            int lllllllllllllllllIllIlIIIIlIIlIl = lllllllllllllllllIllIlIIIIIllIII[1 + (lllllllllllllllllIllIlIIIIlIIIll >> 2)] & 0xFF;
            switch (lllllllllllllllllIllIlIIIIlIIIIl - lllllllllllllllllIllIlIIIIlIIIll) {
                default: {
                    lllllllllllllllllIllIlIIIIIlIllI[lllllllllllllllllIllIlIIIIlIIIll + 3] = (byte)(lllllllllllllllllIllIlIIIIlIIlIl & 3);
                }
                case 3: {
                    lllllllllllllllllIllIlIIIIIlIllI[lllllllllllllllllIllIlIIIIlIIIll + 2] = (byte)(lllllllllllllllllIllIlIIIIlIIlIl >> 2 & 3);
                }
                case 2: {
                    lllllllllllllllllIllIlIIIIIlIllI[lllllllllllllllllIllIlIIIIlIIIll + 1] = (byte)(lllllllllllllllllIllIlIIIIlIIlIl >> 4 & 3);
                }
                case 1: 
            }
            lllllllllllllllllIllIlIIIIIlIllI[lllllllllllllllllIllIlIIIIlIIIll] = (byte)(lllllllllllllllllIllIlIIIIlIIlIl >> 6);
        }
    }

    private void copyPALtoABGR(ByteBuffer lllllllllllllllllIllIlIIlIlllIII, byte[] lllllllllllllllllIllIlIIlIllIlll) {
        PNGDecoder lllllllllllllllllIllIlIIlIllllIl;
        if (lllllllllllllllllIllIlIIlIllllIl.paletteA != null) {
            int lllllllllllllllllIllIlIIllIIlIlI = lllllllllllllllllIllIlIIlIllIlll.length;
            for (int lllllllllllllllllIllIlIIllIIllII = 1; lllllllllllllllllIllIlIIllIIllII < lllllllllllllllllIllIlIIllIIlIlI; ++lllllllllllllllllIllIlIIllIIllII) {
                int lllllllllllllllllIllIlIIllIlIIll = lllllllllllllllllIllIlIIlIllIlll[lllllllllllllllllIllIlIIllIIllII] & 0xFF;
                byte lllllllllllllllllIllIlIIllIlIIIl = lllllllllllllllllIllIlIIlIllllIl.palette[lllllllllllllllllIllIlIIllIlIIll * 3 + 0];
                byte lllllllllllllllllIllIlIIllIlIIII = lllllllllllllllllIllIlIIlIllllIl.palette[lllllllllllllllllIllIlIIllIlIIll * 3 + 1];
                byte lllllllllllllllllIllIlIIllIIllll = lllllllllllllllllIllIlIIlIllllIl.palette[lllllllllllllllllIllIlIIllIlIIll * 3 + 2];
                byte lllllllllllllllllIllIlIIllIIlllI = lllllllllllllllllIllIlIIlIllllIl.paletteA[lllllllllllllllllIllIlIIllIlIIll];
                lllllllllllllllllIllIlIIlIlllIII.put(lllllllllllllllllIllIlIIllIIlllI).put(lllllllllllllllllIllIlIIllIIllll).put(lllllllllllllllllIllIlIIllIlIIII).put(lllllllllllllllllIllIlIIllIlIIIl);
            }
        } else {
            int lllllllllllllllllIllIlIIlIllllll = lllllllllllllllllIllIlIIlIllIlll.length;
            for (int lllllllllllllllllIllIlIIllIIIIIl = 1; lllllllllllllllllIllIlIIllIIIIIl < lllllllllllllllllIllIlIIlIllllll; ++lllllllllllllllllIllIlIIllIIIIIl) {
                int lllllllllllllllllIllIlIIllIIlIIl = lllllllllllllllllIllIlIIlIllIlll[lllllllllllllllllIllIlIIllIIIIIl] & 0xFF;
                byte lllllllllllllllllIllIlIIllIIlIII = lllllllllllllllllIllIlIIlIllllIl.palette[lllllllllllllllllIllIlIIllIIlIIl * 3 + 0];
                byte lllllllllllllllllIllIlIIllIIIllI = lllllllllllllllllIllIlIIlIllllIl.palette[lllllllllllllllllIllIlIIllIIlIIl * 3 + 1];
                byte lllllllllllllllllIllIlIIllIIIlII = lllllllllllllllllIllIlIIlIllllIl.palette[lllllllllllllllllIllIlIIllIIlIIl * 3 + 2];
                byte lllllllllllllllllIllIlIIllIIIIll = -1;
                lllllllllllllllllIllIlIIlIlllIII.put(lllllllllllllllllIllIlIIllIIIIll).put(lllllllllllllllllIllIlIIllIIIlII).put(lllllllllllllllllIllIlIIllIIIllI).put(lllllllllllllllllIllIlIIllIIlIII);
            }
        }
    }

    static {
        COLOR_INDEXED = (byte)3;
        COLOR_TRUEALPHA = (byte)6;
        tRNS = 1951551059;
        IEND = 1229278788;
        PLTE = 1347179589;
        IHDR = 1229472850;
        COLOR_GREYSCALE = 0;
        COLOR_TRUECOLOR = (byte)2;
        IDAT = 1229209940;
        COLOR_GREYALPHA = (byte)4;
        ALPHA = new Format(1, true);
        LUMINANCE = new Format(1, false);
        LUMINANCE_ALPHA = new Format(2, true);
        RGB = new Format(3, false);
        RGBA = new Format(4, true);
        BGRA = new Format(4, true);
        ABGR = new Format(4, true);
        SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void decode(ByteBuffer lllllllllllllllllIllIlIllIIlllll, int lllllllllllllllllIllIlIllIIllllI, Format lllllllllllllllllIllIlIllIIlIIll) throws IOException {
        PNGDecoder lllllllllllllllllIllIlIllIlIIIII;
        int lllllllllllllllllIllIlIllIIlllII = lllllllllllllllllIllIlIllIIlllll.position();
        int lllllllllllllllllIllIlIllIIllIll = (lllllllllllllllllIllIlIllIlIIIII.width * lllllllllllllllllIllIlIllIlIIIII.bitdepth + 7) / 8 * lllllllllllllllllIllIlIllIlIIIII.bytesPerPixel;
        byte[] lllllllllllllllllIllIlIllIIllIlI = new byte[lllllllllllllllllIllIlIllIIllIll + 1];
        byte[] lllllllllllllllllIllIlIllIIllIIl = new byte[lllllllllllllllllIllIlIllIIllIll + 1];
        byte[] lllllllllllllllllIllIlIllIIllIII = lllllllllllllllllIllIlIllIlIIIII.bitdepth < 8 ? new byte[lllllllllllllllllIllIlIllIlIIIII.width + 1] : null;
        Inflater lllllllllllllllllIllIlIllIIlIlll = new Inflater();
        try {
            for (int lllllllllllllllllIllIlIllIlIIIIl = 0; lllllllllllllllllIllIlIllIlIIIIl < lllllllllllllllllIllIlIllIlIIIII.height; ++lllllllllllllllllIllIlIllIlIIIIl) {
                lllllllllllllllllIllIlIllIlIIIII.readChunkUnzip(lllllllllllllllllIllIlIllIIlIlll, lllllllllllllllllIllIlIllIIllIlI, 0, lllllllllllllllllIllIlIllIIllIlI.length);
                lllllllllllllllllIllIlIllIlIIIII.unfilter(lllllllllllllllllIllIlIllIIllIlI, lllllllllllllllllIllIlIllIIllIIl);
                lllllllllllllllllIllIlIllIIlllll.position(lllllllllllllllllIllIlIllIIlllII + lllllllllllllllllIllIlIllIlIIIIl * lllllllllllllllllIllIlIllIIllllI);
                switch (lllllllllllllllllIllIlIllIlIIIII.colorType) {
                    case 2: {
                        if (lllllllllllllllllIllIlIllIIlIIll == ABGR) {
                            lllllllllllllllllIllIlIllIlIIIII.copyRGBtoABGR(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == RGBA) {
                            lllllllllllllllllIllIlIllIlIIIII.copyRGBtoRGBA(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == BGRA) {
                            lllllllllllllllllIllIlIllIlIIIII.copyRGBtoBGRA(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == RGB) {
                            lllllllllllllllllIllIlIllIlIIIII.copy(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 6: {
                        if (lllllllllllllllllIllIlIllIIlIIll == ABGR) {
                            lllllllllllllllllIllIlIllIlIIIII.copyRGBAtoABGR(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == RGBA) {
                            lllllllllllllllllIllIlIllIlIIIII.copy(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == BGRA) {
                            lllllllllllllllllIllIlIllIlIIIII.copyRGBAtoBGRA(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == RGB) {
                            lllllllllllllllllIllIlIllIlIIIII.copyRGBAtoRGB(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 0: {
                        if (lllllllllllllllllIllIlIllIIlIIll == LUMINANCE || lllllllllllllllllIllIlIllIIlIIll == ALPHA) {
                            lllllllllllllllllIllIlIllIlIIIII.copy(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 4: {
                        if (lllllllllllllllllIllIlIllIIlIIll == LUMINANCE_ALPHA) {
                            lllllllllllllllllIllIlIllIlIIIII.copy(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIlI);
                            break;
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    case 3: {
                        switch (lllllllllllllllllIllIlIllIlIIIII.bitdepth) {
                            case 8: {
                                lllllllllllllllllIllIlIllIIllIII = lllllllllllllllllIllIlIllIIllIlI;
                                break;
                            }
                            case 4: {
                                lllllllllllllllllIllIlIllIlIIIII.expand4(lllllllllllllllllIllIlIllIIllIlI, lllllllllllllllllIllIlIllIIllIII);
                                break;
                            }
                            case 2: {
                                lllllllllllllllllIllIlIllIlIIIII.expand2(lllllllllllllllllIllIlIllIIllIlI, lllllllllllllllllIllIlIllIIllIII);
                                break;
                            }
                            case 1: {
                                lllllllllllllllllIllIlIllIlIIIII.expand1(lllllllllllllllllIllIlIllIIllIlI, lllllllllllllllllIllIlIllIIllIII);
                                break;
                            }
                            default: {
                                throw new UnsupportedOperationException("Unsupported bitdepth for this image");
                            }
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == ABGR) {
                            lllllllllllllllllIllIlIllIlIIIII.copyPALtoABGR(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIII);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == RGBA) {
                            lllllllllllllllllIllIlIllIlIIIII.copyPALtoRGBA(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIII);
                            break;
                        }
                        if (lllllllllllllllllIllIlIllIIlIIll == BGRA) {
                            lllllllllllllllllIllIlIllIlIIIII.copyPALtoBGRA(lllllllllllllllllIllIlIllIIlllll, lllllllllllllllllIllIlIllIIllIII);
                            break;
                        }
                        throw new UnsupportedOperationException("Unsupported format for this image");
                    }
                    default: {
                        throw new UnsupportedOperationException("Not yet implemented");
                    }
                }
                byte[] lllllllllllllllllIllIlIllIlIIIlI = lllllllllllllllllIllIlIllIIllIlI;
                lllllllllllllllllIllIlIllIIllIlI = lllllllllllllllllIllIlIllIIllIIl;
                lllllllllllllllllIllIlIllIIllIIl = lllllllllllllllllIllIlIllIlIIIlI;
            }
        }
        finally {
            lllllllllllllllllIllIlIllIIlIlll.end();
        }
    }

    private void unfilterPaeth(byte[] lllllllllllllllllIllIIllIlIllllI, byte[] lllllllllllllllllIllIIllIllIIIlI) {
        int lllllllllllllllllIllIIllIllIIIII;
        PNGDecoder lllllllllllllllllIllIIllIlIlllll;
        int lllllllllllllllllIllIIllIllIIIIl = lllllllllllllllllIllIIllIlIlllll.bytesPerPixel;
        for (lllllllllllllllllIllIIllIllIIIII = 1; lllllllllllllllllIllIIllIllIIIII <= lllllllllllllllllIllIIllIllIIIIl; ++lllllllllllllllllIllIIllIllIIIII) {
            int n = lllllllllllllllllIllIIllIllIIIII;
            lllllllllllllllllIllIIllIlIllllI[n] = (byte)(lllllllllllllllllIllIIllIlIllllI[n] + lllllllllllllllllIllIIllIllIIIlI[lllllllllllllllllIllIIllIllIIIII]);
        }
        int lllllllllllllllllIllIIllIllIIlIl = lllllllllllllllllIllIIllIlIllllI.length;
        while (lllllllllllllllllIllIIllIllIIIII < lllllllllllllllllIllIIllIllIIlIl) {
            int lllllllllllllllllIllIIllIllIIllI;
            int lllllllllllllllllIllIIllIllIIlll;
            int lllllllllllllllllIllIIllIllIllII = lllllllllllllllllIllIIllIlIllllI[lllllllllllllllllIllIIllIllIIIII - lllllllllllllllllIllIIllIllIIIIl] & 0xFF;
            int lllllllllllllllllIllIIllIllIlIll = lllllllllllllllllIllIIllIllIIIlI[lllllllllllllllllIllIIllIllIIIII] & 0xFF;
            int lllllllllllllllllIllIIllIllIlIlI = lllllllllllllllllIllIIllIllIIIlI[lllllllllllllllllIllIIllIllIIIII - lllllllllllllllllIllIIllIllIIIIl] & 0xFF;
            int lllllllllllllllllIllIIllIllIlIIl = lllllllllllllllllIllIIllIllIllII + lllllllllllllllllIllIIllIllIlIll - lllllllllllllllllIllIIllIllIlIlI;
            int lllllllllllllllllIllIIllIllIlIII = lllllllllllllllllIllIIllIllIlIIl - lllllllllllllllllIllIIllIllIllII;
            if (lllllllllllllllllIllIIllIllIlIII < 0) {
                lllllllllllllllllIllIIllIllIlIII = -lllllllllllllllllIllIIllIllIlIII;
            }
            if ((lllllllllllllllllIllIIllIllIIlll = lllllllllllllllllIllIIllIllIlIIl - lllllllllllllllllIllIIllIllIlIll) < 0) {
                lllllllllllllllllIllIIllIllIIlll = -lllllllllllllllllIllIIllIllIIlll;
            }
            if ((lllllllllllllllllIllIIllIllIIllI = lllllllllllllllllIllIIllIllIlIIl - lllllllllllllllllIllIIllIllIlIlI) < 0) {
                lllllllllllllllllIllIIllIllIIllI = -lllllllllllllllllIllIIllIllIIllI;
            }
            if (lllllllllllllllllIllIIllIllIlIII <= lllllllllllllllllIllIIllIllIIlll && lllllllllllllllllIllIIllIllIlIII <= lllllllllllllllllIllIIllIllIIllI) {
                lllllllllllllllllIllIIllIllIlIlI = lllllllllllllllllIllIIllIllIllII;
            } else if (lllllllllllllllllIllIIllIllIIlll <= lllllllllllllllllIllIIllIllIIllI) {
                lllllllllllllllllIllIIllIllIlIlI = lllllllllllllllllIllIIllIllIlIll;
            }
            int n = lllllllllllllllllIllIIllIllIIIII++;
            lllllllllllllllllIllIIllIlIllllI[n] = (byte)(lllllllllllllllllIllIIllIlIllllI[n] + (byte)lllllllllllllllllIllIIllIllIlIlI);
        }
    }

    private void skip(long lllllllllllllllllIllIIlIIlllllII) throws IOException {
        while (lllllllllllllllllIllIIlIIlllllII > 0L) {
            PNGDecoder lllllllllllllllllIllIIlIIllllIll;
            long lllllllllllllllllIllIIlIIllllllI = lllllllllllllllllIllIIlIIllllIll.input.skip(lllllllllllllllllIllIIlIIlllllII);
            if (lllllllllllllllllIllIIlIIllllllI < 0L) {
                throw new EOFException();
            }
            lllllllllllllllllIllIIlIIlllllII -= lllllllllllllllllIllIIlIIllllllI;
        }
    }

    private void readFully(byte[] lllllllllllllllllIllIIlIlIIlllII, int lllllllllllllllllIllIIlIlIIllIlI, int lllllllllllllllllIllIIlIlIIllIII) throws IOException {
        int lllllllllllllllllIllIIlIlIlIIIII;
        do {
            PNGDecoder lllllllllllllllllIllIIlIlIIllllI;
            if ((lllllllllllllllllIllIIlIlIlIIIII = lllllllllllllllllIllIIlIlIIllllI.input.read(lllllllllllllllllIllIIlIlIIlllII, lllllllllllllllllIllIIlIlIIllIlI, lllllllllllllllllIllIIlIlIIllIII)) < 0) {
                throw new EOFException();
            }
            lllllllllllllllllIllIIlIlIIllIlI += lllllllllllllllllIllIIlIlIlIIIII;
        } while ((lllllllllllllllllIllIIlIlIIllIII -= lllllllllllllllllIllIIlIlIlIIIII) > 0);
    }

    private void copyRGBAtoRGB(ByteBuffer lllllllllllllllllIllIlIIlllIlIIl, byte[] lllllllllllllllllIllIlIIlllIlIII) {
        int lllllllllllllllllIllIlIIlllIllIl = lllllllllllllllllIllIlIIlllIlIII.length;
        for (int lllllllllllllllllIllIlIIlllIllll = 1; lllllllllllllllllIllIlIIlllIllll < lllllllllllllllllIllIlIIlllIllIl; lllllllllllllllllIllIlIIlllIllll += 4) {
            lllllllllllllllllIllIlIIlllIlIIl.put(lllllllllllllllllIllIlIIlllIlIII[lllllllllllllllllIllIlIIlllIllll]).put(lllllllllllllllllIllIlIIlllIlIII[lllllllllllllllllIllIlIIlllIllll + 1]).put(lllllllllllllllllIllIlIIlllIlIII[lllllllllllllllllIllIlIIlllIllll + 2]);
        }
    }

    private void openChunk() throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIIIIlIll;
        lllllllllllllllllIllIIllIIIIlIll.readFully(lllllllllllllllllIllIIllIIIIlIll.buffer, 0, 8);
        lllllllllllllllllIllIIllIIIIlIll.chunkLength = lllllllllllllllllIllIIllIIIIlIll.readInt(lllllllllllllllllIllIIllIIIIlIll.buffer, 0);
        lllllllllllllllllIllIIllIIIIlIll.chunkType = lllllllllllllllllIllIIllIIIIlIll.readInt(lllllllllllllllllIllIIllIIIIlIll.buffer, 4);
        lllllllllllllllllIllIIllIIIIlIll.chunkRemaining = lllllllllllllllllIllIIllIIIIlIll.chunkLength;
        lllllllllllllllllIllIIllIIIIlIll.crc.reset();
        lllllllllllllllllIllIIllIIIIlIll.crc.update(lllllllllllllllllIllIIllIIIIlIll.buffer, 4, 4);
    }

    private int readChunk(byte[] lllllllllllllllllIllIIlIlllIlIII, int lllllllllllllllllIllIIlIlllIIllI, int lllllllllllllllllIllIIlIlllIllII) throws IOException {
        PNGDecoder lllllllllllllllllIllIIlIlllIlIlI;
        if (lllllllllllllllllIllIIlIlllIllII > lllllllllllllllllIllIIlIlllIlIlI.chunkRemaining) {
            lllllllllllllllllIllIIlIlllIllII = lllllllllllllllllIllIIlIlllIlIlI.chunkRemaining;
        }
        lllllllllllllllllIllIIlIlllIlIlI.readFully(lllllllllllllllllIllIIlIlllIlIII, lllllllllllllllllIllIIlIlllIIllI, lllllllllllllllllIllIIlIlllIllII);
        lllllllllllllllllIllIIlIlllIlIlI.crc.update(lllllllllllllllllIllIIlIlllIlIII, lllllllllllllllllIllIIlIlllIIllI, lllllllllllllllllIllIIlIlllIllII);
        lllllllllllllllllIllIIlIlllIlIlI.chunkRemaining -= lllllllllllllllllIllIIlIlllIllII;
        return lllllllllllllllllIllIIlIlllIllII;
    }

    private void unfilterSub(byte[] lllllllllllllllllIllIIllllIIIIII) {
        PNGDecoder lllllllllllllllllIllIIllllIIIIIl;
        int lllllllllllllllllIllIIlllIllllll = lllllllllllllllllIllIIllllIIIIIl.bytesPerPixel;
        int lllllllllllllllllIllIIllllIIIIlI = lllllllllllllllllIllIIllllIIIIII.length;
        for (int lllllllllllllllllIllIIllllIIIIll = lllllllllllllllllIllIIlllIllllll + 1; lllllllllllllllllIllIIllllIIIIll < lllllllllllllllllIllIIllllIIIIlI; ++lllllllllllllllllIllIIllllIIIIll) {
            int n = lllllllllllllllllIllIIllllIIIIll;
            lllllllllllllllllIllIIllllIIIIII[n] = (byte)(lllllllllllllllllIllIIllllIIIIII[n] + lllllllllllllllllIllIIllllIIIIII[lllllllllllllllllIllIIllllIIIIll - lllllllllllllllllIllIIlllIllllll]);
        }
    }

    private void expand1(byte[] lllllllllllllllllIllIIlllllIlllI, byte[] lllllllllllllllllIllIIlllllIllIl) {
        int lllllllllllllllllIllIIllllllIIlI = lllllllllllllllllIllIIlllllIllIl.length;
        for (int lllllllllllllllllIllIIllllllIlII = 1; lllllllllllllllllIllIIllllllIlII < lllllllllllllllllIllIIllllllIIlI; lllllllllllllllllIllIIllllllIlII += 8) {
            int lllllllllllllllllIllIIllllllIlIl = lllllllllllllllllIllIIlllllIlllI[1 + (lllllllllllllllllIllIIllllllIlII >> 3)] & 0xFF;
            switch (lllllllllllllllllIllIIllllllIIlI - lllllllllllllllllIllIIllllllIlII) {
                default: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 7] = (byte)(lllllllllllllllllIllIIllllllIlIl & 1);
                }
                case 7: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 6] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 1 & 1);
                }
                case 6: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 5] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 2 & 1);
                }
                case 5: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 4] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 3 & 1);
                }
                case 4: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 3] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 4 & 1);
                }
                case 3: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 2] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 5 & 1);
                }
                case 2: {
                    lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII + 1] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 6 & 1);
                }
                case 1: 
            }
            lllllllllllllllllIllIIlllllIllIl[lllllllllllllllllIllIIllllllIlII] = (byte)(lllllllllllllllllIllIIllllllIlIl >> 7);
        }
    }

    private void readChunkUnzip(Inflater lllllllllllllllllIllIIlIlIllllII, byte[] lllllllllllllllllIllIIlIllIIIIII, int lllllllllllllllllIllIIlIlIllllll, int lllllllllllllllllIllIIlIlIlllllI) throws IOException {
        try {
            do {
                int lllllllllllllllllIllIIlIllIIIlII;
                if ((lllllllllllllllllIllIIlIllIIIlII = lllllllllllllllllIllIIlIlIllllII.inflate(lllllllllllllllllIllIIlIllIIIIII, lllllllllllllllllIllIIlIlIllllll, lllllllllllllllllIllIIlIlIlllllI)) <= 0) {
                    if (lllllllllllllllllIllIIlIlIllllII.finished()) {
                        throw new EOFException();
                    }
                    if (lllllllllllllllllIllIIlIlIllllII.needsInput()) {
                        PNGDecoder lllllllllllllllllIllIIlIlIllllIl;
                        lllllllllllllllllIllIIlIlIllllIl.refillInflater(lllllllllllllllllIllIIlIlIllllII);
                        continue;
                    }
                    throw new IOException(String.valueOf(new StringBuilder().append("Can't inflate ").append(lllllllllllllllllIllIIlIlIlllllI).append(" bytes")));
                }
                lllllllllllllllllIllIIlIlIllllll += lllllllllllllllllIllIIlIllIIIlII;
                lllllllllllllllllIllIIlIlIlllllI -= lllllllllllllllllIllIIlIllIIIlII;
            } while (lllllllllllllllllIllIIlIlIlllllI > 0);
        }
        catch (DataFormatException lllllllllllllllllIllIIlIllIIIIll) {
            throw (IOException)new IOException("inflate error").initCause(lllllllllllllllllIllIIlIllIIIIll);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public PNGDecoder(InputStream lllllllllllllllllIllIlIlllIIIlII) throws IOException {
        PNGDecoder lllllllllllllllllIllIlIlllIIIIll;
        lllllllllllllllllIllIlIlllIIIIll.input = lllllllllllllllllIllIlIlllIIIlII;
        lllllllllllllllllIllIlIlllIIIIll.crc = new CRC32();
        lllllllllllllllllIllIlIlllIIIIll.buffer = new byte[4096];
        lllllllllllllllllIllIlIlllIIIIll.readFully(lllllllllllllllllIllIlIlllIIIIll.buffer, 0, SIGNATURE.length);
        if (!PNGDecoder.checkSignature(lllllllllllllllllIllIlIlllIIIIll.buffer)) {
            throw new IOException("Not a valid PNG file");
        }
        lllllllllllllllllIllIlIlllIIIIll.openChunk(1229472850);
        lllllllllllllllllIllIlIlllIIIIll.readIHDR();
        lllllllllllllllllIllIlIlllIIIIll.closeChunk();
        block5: while (true) {
            lllllllllllllllllIllIlIlllIIIIll.openChunk();
            switch (lllllllllllllllllIllIlIlllIIIIll.chunkType) {
                case 1229209940: {
                    break block5;
                }
                case 1347179589: {
                    lllllllllllllllllIllIlIlllIIIIll.readPLTE();
                    break;
                }
                case 1951551059: {
                    lllllllllllllllllIllIlIlllIIIIll.readtRNS();
                }
            }
            lllllllllllllllllIllIlIlllIIIIll.closeChunk();
        }
        if (lllllllllllllllllIllIlIlllIIIIll.colorType == 3 && lllllllllllllllllIllIlIlllIIIIll.palette == null) {
            throw new IOException("Missing PLTE chunk");
        }
    }

    private void copyRGBAtoABGR(ByteBuffer lllllllllllllllllIllIlIlIIIIIlll, byte[] lllllllllllllllllIllIlIlIIIIIllI) {
        int lllllllllllllllllIllIlIlIIIIlIll = lllllllllllllllllIllIlIlIIIIIllI.length;
        for (int lllllllllllllllllIllIlIlIIIIllII = 1; lllllllllllllllllIllIlIlIIIIllII < lllllllllllllllllIllIlIlIIIIlIll; lllllllllllllllllIllIlIlIIIIllII += 4) {
            lllllllllllllllllIllIlIlIIIIIlll.put(lllllllllllllllllIllIlIlIIIIIllI[lllllllllllllllllIllIlIlIIIIllII + 3]).put(lllllllllllllllllIllIlIlIIIIIllI[lllllllllllllllllIllIlIlIIIIllII + 2]).put(lllllllllllllllllIllIlIlIIIIIllI[lllllllllllllllllIllIlIlIIIIllII + 1]).put(lllllllllllllllllIllIlIlIIIIIllI[lllllllllllllllllIllIlIlIIIIllII]);
        }
    }

    private void readtRNS() throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIIlIIIll;
        switch (lllllllllllllllllIllIIllIIlIIIll.colorType) {
            case 0: {
                lllllllllllllllllIllIIllIIlIIIll.checkChunkLength(2);
                lllllllllllllllllIllIIllIIlIIIll.transPixel = new byte[2];
                lllllllllllllllllIllIIllIIlIIIll.readChunk(lllllllllllllllllIllIIllIIlIIIll.transPixel, 0, 2);
                break;
            }
            case 2: {
                lllllllllllllllllIllIIllIIlIIIll.checkChunkLength(6);
                lllllllllllllllllIllIIllIIlIIIll.transPixel = new byte[6];
                lllllllllllllllllIllIIllIIlIIIll.readChunk(lllllllllllllllllIllIIllIIlIIIll.transPixel, 0, 6);
                break;
            }
            case 3: {
                if (lllllllllllllllllIllIIllIIlIIIll.palette == null) {
                    throw new IOException("tRNS chunk without PLTE chunk");
                }
                lllllllllllllllllIllIIllIIlIIIll.paletteA = new byte[lllllllllllllllllIllIIllIIlIIIll.palette.length / 3];
                Arrays.fill(lllllllllllllllllIllIIllIIlIIIll.paletteA, (byte)-1);
                lllllllllllllllllIllIIllIIlIIIll.readChunk(lllllllllllllllllIllIIllIIlIIIll.paletteA, 0, lllllllllllllllllIllIIllIIlIIIll.paletteA.length);
                break;
            }
        }
    }

    private void readPLTE() throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIIlllIII;
        int lllllllllllllllllIllIIllIIlllIlI = lllllllllllllllllIllIIllIIlllIII.chunkLength / 3;
        if (lllllllllllllllllIllIIllIIlllIlI < 1 || lllllllllllllllllIllIIllIIlllIlI > 256 || lllllllllllllllllIllIIllIIlllIII.chunkLength % 3 != 0) {
            throw new IOException("PLTE chunk has wrong length");
        }
        lllllllllllllllllIllIIllIIlllIII.palette = new byte[lllllllllllllllllIllIIllIIlllIlI * 3];
        lllllllllllllllllIllIIllIIlllIII.readChunk(lllllllllllllllllIllIIllIIlllIII.palette, 0, lllllllllllllllllIllIIllIIlllIII.palette.length);
    }

    private void unfilter(byte[] lllllllllllllllllIllIIllllIlIllI, byte[] lllllllllllllllllIllIIllllIIllll) throws IOException {
        switch (lllllllllllllllllIllIIllllIlIllI[0]) {
            case 0: {
                break;
            }
            case 1: {
                PNGDecoder lllllllllllllllllIllIIllllIlIIll;
                lllllllllllllllllIllIIllllIlIIll.unfilterSub(lllllllllllllllllIllIIllllIlIllI);
                break;
            }
            case 2: {
                PNGDecoder lllllllllllllllllIllIIllllIlIIll;
                lllllllllllllllllIllIIllllIlIIll.unfilterUp(lllllllllllllllllIllIIllllIlIllI, lllllllllllllllllIllIIllllIIllll);
                break;
            }
            case 3: {
                PNGDecoder lllllllllllllllllIllIIllllIlIIll;
                lllllllllllllllllIllIIllllIlIIll.unfilterAverage(lllllllllllllllllIllIIllllIlIllI, lllllllllllllllllIllIIllllIIllll);
                break;
            }
            case 4: {
                PNGDecoder lllllllllllllllllIllIIllllIlIIll;
                lllllllllllllllllIllIIllllIlIIll.unfilterPaeth(lllllllllllllllllIllIIllllIlIllI, lllllllllllllllllIllIIllllIIllll);
                break;
            }
            default: {
                throw new IOException(String.valueOf(new StringBuilder().append("invalide filter type in scanline: ").append(lllllllllllllllllIllIIllllIlIllI[0])));
            }
        }
    }

    private void copyRGBtoABGR(ByteBuffer lllllllllllllllllIllIlIlIllIIlll, byte[] lllllllllllllllllIllIlIlIllIlIIl) {
        PNGDecoder lllllllllllllllllIllIlIlIllIlIll;
        if (lllllllllllllllllIllIlIlIllIlIll.transPixel != null) {
            byte lllllllllllllllllIllIlIlIlllIIII = lllllllllllllllllIllIlIlIllIlIll.transPixel[1];
            byte lllllllllllllllllIllIlIlIllIllll = lllllllllllllllllIllIlIlIllIlIll.transPixel[3];
            byte lllllllllllllllllIllIlIlIllIlllI = lllllllllllllllllIllIlIlIllIlIll.transPixel[5];
            int lllllllllllllllllIllIlIlIlllIIIl = lllllllllllllllllIllIlIlIllIlIIl.length;
            for (int lllllllllllllllllIllIlIlIlllIIlI = 1; lllllllllllllllllIllIlIlIlllIIlI < lllllllllllllllllIllIlIlIlllIIIl; lllllllllllllllllIllIlIlIlllIIlI += 3) {
                byte lllllllllllllllllIllIlIlIlllIllI = lllllllllllllllllIllIlIlIllIlIIl[lllllllllllllllllIllIlIlIlllIIlI];
                byte lllllllllllllllllIllIlIlIlllIlIl = lllllllllllllllllIllIlIlIllIlIIl[lllllllllllllllllIllIlIlIlllIIlI + 1];
                byte lllllllllllllllllIllIlIlIlllIlII = lllllllllllllllllIllIlIlIllIlIIl[lllllllllllllllllIllIlIlIlllIIlI + 2];
                byte lllllllllllllllllIllIlIlIlllIIll = -1;
                if (lllllllllllllllllIllIlIlIlllIllI == lllllllllllllllllIllIlIlIlllIIII && lllllllllllllllllIllIlIlIlllIlIl == lllllllllllllllllIllIlIlIllIllll && lllllllllllllllllIllIlIlIlllIlII == lllllllllllllllllIllIlIlIllIlllI) {
                    lllllllllllllllllIllIlIlIlllIIll = 0;
                }
                lllllllllllllllllIllIlIlIllIIlll.put(lllllllllllllllllIllIlIlIlllIIll).put(lllllllllllllllllIllIlIlIlllIlII).put(lllllllllllllllllIllIlIlIlllIlIl).put(lllllllllllllllllIllIlIlIlllIllI);
            }
        } else {
            int lllllllllllllllllIllIlIlIllIllII = lllllllllllllllllIllIlIlIllIlIIl.length;
            for (int lllllllllllllllllIllIlIlIllIllIl = 1; lllllllllllllllllIllIlIlIllIllIl < lllllllllllllllllIllIlIlIllIllII; lllllllllllllllllIllIlIlIllIllIl += 3) {
                lllllllllllllllllIllIlIlIllIIlll.put((byte)-1).put(lllllllllllllllllIllIlIlIllIlIIl[lllllllllllllllllIllIlIlIllIllIl + 2]).put(lllllllllllllllllIllIlIlIllIlIIl[lllllllllllllllllIllIlIlIllIllIl + 1]).put(lllllllllllllllllIllIlIlIllIlIIl[lllllllllllllllllIllIlIlIllIllIl]);
            }
        }
    }

    public boolean isRGB() {
        PNGDecoder lllllllllllllllllIllIlIllIllIlll;
        return lllllllllllllllllIllIlIllIllIlll.colorType == 6 || lllllllllllllllllIllIlIllIllIlll.colorType == 2 || lllllllllllllllllIllIlIllIllIlll.colorType == 3;
    }

    private void openChunk(int lllllllllllllllllIllIIllIIIIIlIl) throws IOException {
        PNGDecoder lllllllllllllllllIllIIllIIIIlIII;
        lllllllllllllllllIllIIllIIIIlIII.openChunk();
        if (lllllllllllllllllIllIIllIIIIlIII.chunkType != lllllllllllllllllIllIIllIIIIIlIl) {
            throw new IOException(String.valueOf(new StringBuilder().append("Expected chunk: ").append(Integer.toHexString(lllllllllllllllllIllIIllIIIIIlIl))));
        }
    }

    private void copyRGBtoBGRA(ByteBuffer lllllllllllllllllIllIlIlIIIllIll, byte[] lllllllllllllllllIllIlIlIIIllIlI) {
        PNGDecoder lllllllllllllllllIllIlIlIIIlllll;
        if (lllllllllllllllllIllIlIlIIIlllll.transPixel != null) {
            byte lllllllllllllllllIllIlIlIIlIIlII = lllllllllllllllllIllIlIlIIIlllll.transPixel[1];
            byte lllllllllllllllllIllIlIlIIlIIIll = lllllllllllllllllIllIlIlIIIlllll.transPixel[3];
            byte lllllllllllllllllIllIlIlIIlIIIlI = lllllllllllllllllIllIlIlIIIlllll.transPixel[5];
            int lllllllllllllllllIllIlIlIIlIIlIl = lllllllllllllllllIllIlIlIIIllIlI.length;
            for (int lllllllllllllllllIllIlIlIIlIIllI = 1; lllllllllllllllllIllIlIlIIlIIllI < lllllllllllllllllIllIlIlIIlIIlIl; lllllllllllllllllIllIlIlIIlIIllI += 3) {
                byte lllllllllllllllllIllIlIlIIlIlIlI = lllllllllllllllllIllIlIlIIIllIlI[lllllllllllllllllIllIlIlIIlIIllI];
                byte lllllllllllllllllIllIlIlIIlIlIIl = lllllllllllllllllIllIlIlIIIllIlI[lllllllllllllllllIllIlIlIIlIIllI + 1];
                byte lllllllllllllllllIllIlIlIIlIlIII = lllllllllllllllllIllIlIlIIIllIlI[lllllllllllllllllIllIlIlIIlIIllI + 2];
                byte lllllllllllllllllIllIlIlIIlIIlll = -1;
                if (lllllllllllllllllIllIlIlIIlIlIlI == lllllllllllllllllIllIlIlIIlIIlII && lllllllllllllllllIllIlIlIIlIlIIl == lllllllllllllllllIllIlIlIIlIIIll && lllllllllllllllllIllIlIlIIlIlIII == lllllllllllllllllIllIlIlIIlIIIlI) {
                    lllllllllllllllllIllIlIlIIlIIlll = 0;
                }
                lllllllllllllllllIllIlIlIIIllIll.put(lllllllllllllllllIllIlIlIIlIlIII).put(lllllllllllllllllIllIlIlIIlIlIIl).put(lllllllllllllllllIllIlIlIIlIlIlI).put(lllllllllllllllllIllIlIlIIlIIlll);
            }
        } else {
            int lllllllllllllllllIllIlIlIIlIIIII = lllllllllllllllllIllIlIlIIIllIlI.length;
            for (int lllllllllllllllllIllIlIlIIlIIIIl = 1; lllllllllllllllllIllIlIlIIlIIIIl < lllllllllllllllllIllIlIlIIlIIIII; lllllllllllllllllIllIlIlIIlIIIIl += 3) {
                lllllllllllllllllIllIlIlIIIllIll.put(lllllllllllllllllIllIlIlIIIllIlI[lllllllllllllllllIllIlIlIIlIIIIl + 2]).put(lllllllllllllllllIllIlIlIIIllIlI[lllllllllllllllllIllIlIlIIlIIIIl + 1]).put(lllllllllllllllllIllIlIlIIIllIlI[lllllllllllllllllIllIlIlIIlIIIIl]).put((byte)-1);
            }
        }
    }

    private void copy(ByteBuffer lllllllllllllllllIllIlIllIIIIlII, byte[] lllllllllllllllllIllIlIllIIIIIll) {
        lllllllllllllllllIllIlIllIIIIlII.put(lllllllllllllllllIllIlIllIIIIIll, 1, lllllllllllllllllIllIlIllIIIIIll.length - 1);
    }

    public static class Format {
        final /* synthetic */ int numComponents;
        final /* synthetic */ boolean hasAlpha;

        private Format(int llllllllllllllllIllllIlIIlllIlll, boolean llllllllllllllllIllllIlIIlllIlIl) {
            Format llllllllllllllllIllllIlIIllllIlI;
            llllllllllllllllIllllIlIIllllIlI.numComponents = llllllllllllllllIllllIlIIlllIlll;
            llllllllllllllllIllllIlIIllllIlI.hasAlpha = llllllllllllllllIllllIlIIlllIlIl;
        }

        public boolean isHasAlpha() {
            Format llllllllllllllllIllllIlIIlIllIll;
            return llllllllllllllllIllllIlIIlIllIll.hasAlpha;
        }

        public int getNumComponents() {
            Format llllllllllllllllIllllIlIIllIIlIl;
            return llllllllllllllllIllllIlIIllIIlIl.numComponents;
        }
    }
}

