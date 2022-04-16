/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

public class ByteVector {
    /* synthetic */ byte[] data;
    /* synthetic */ int length;

    public ByteVector putByteArray(byte[] llllllllllllllllllIlIllIIlIIIlII, int llllllllllllllllllIlIllIIlIIIIll, int llllllllllllllllllIlIllIIlIIIllI) {
        ByteVector llllllllllllllllllIlIllIIlIIIlIl;
        if (llllllllllllllllllIlIllIIlIIIlIl.length + llllllllllllllllllIlIllIIlIIIllI > llllllllllllllllllIlIllIIlIIIlIl.data.length) {
            llllllllllllllllllIlIllIIlIIIlIl.enlarge(llllllllllllllllllIlIllIIlIIIllI);
        }
        if (llllllllllllllllllIlIllIIlIIIlII != null) {
            System.arraycopy(llllllllllllllllllIlIllIIlIIIlII, llllllllllllllllllIlIllIIlIIIIll, llllllllllllllllllIlIllIIlIIIlIl.data, llllllllllllllllllIlIllIIlIIIlIl.length, llllllllllllllllllIlIllIIlIIIllI);
        }
        llllllllllllllllllIlIllIIlIIIlIl.length += llllllllllllllllllIlIllIIlIIIllI;
        return llllllllllllllllllIlIllIIlIIIlIl;
    }

    public ByteVector putByte(int llllllllllllllllllIlIllllIllIlIl) {
        ByteVector llllllllllllllllllIlIllllIllIIll;
        int llllllllllllllllllIlIllllIllIlII = llllllllllllllllllIlIllllIllIIll.length;
        if (llllllllllllllllllIlIllllIllIlII + 1 > llllllllllllllllllIlIllllIllIIll.data.length) {
            llllllllllllllllllIlIllllIllIIll.enlarge(1);
        }
        llllllllllllllllllIlIllllIllIIll.data[llllllllllllllllllIlIllllIllIlII++] = (byte)llllllllllllllllllIlIllllIllIlIl;
        llllllllllllllllllIlIllllIllIIll.length = llllllllllllllllllIlIllllIllIlII;
        return llllllllllllllllllIlIllllIllIIll;
    }

    public ByteVector putShort(int llllllllllllllllllIlIllllIIlIllI) {
        ByteVector llllllllllllllllllIlIllllIIlIlll;
        int llllllllllllllllllIlIllllIIlIlIl = llllllllllllllllllIlIllllIIlIlll.length;
        if (llllllllllllllllllIlIllllIIlIlIl + 2 > llllllllllllllllllIlIllllIIlIlll.data.length) {
            llllllllllllllllllIlIllllIIlIlll.enlarge(2);
        }
        byte[] llllllllllllllllllIlIllllIIlIIll = llllllllllllllllllIlIllllIIlIlll.data;
        llllllllllllllllllIlIllllIIlIIll[llllllllllllllllllIlIllllIIlIlIl++] = (byte)(llllllllllllllllllIlIllllIIlIllI >>> 8);
        llllllllllllllllllIlIllllIIlIIll[llllllllllllllllllIlIllllIIlIlIl++] = (byte)llllllllllllllllllIlIllllIIlIllI;
        llllllllllllllllllIlIllllIIlIlll.length = llllllllllllllllllIlIllllIIlIlIl;
        return llllllllllllllllllIlIllllIIlIlll;
    }

    public ByteVector putUTF8(String llllllllllllllllllIlIllIllIIllII) {
        ByteVector llllllllllllllllllIlIllIllIIllIl;
        int llllllllllllllllllIlIllIllIIlIlI = llllllllllllllllllIlIllIllIIllII.length();
        if (llllllllllllllllllIlIllIllIIlIlI > 65535) {
            throw new IllegalArgumentException();
        }
        int llllllllllllllllllIlIllIllIIlIII = llllllllllllllllllIlIllIllIIllIl.length;
        if (llllllllllllllllllIlIllIllIIlIII + 2 + llllllllllllllllllIlIllIllIIlIlI > llllllllllllllllllIlIllIllIIllIl.data.length) {
            llllllllllllllllllIlIllIllIIllIl.enlarge(2 + llllllllllllllllllIlIllIllIIlIlI);
        }
        byte[] llllllllllllllllllIlIllIllIIIllI = llllllllllllllllllIlIllIllIIllIl.data;
        llllllllllllllllllIlIllIllIIIllI[llllllllllllllllllIlIllIllIIlIII++] = (byte)(llllllllllllllllllIlIllIllIIlIlI >>> 8);
        llllllllllllllllllIlIllIllIIIllI[llllllllllllllllllIlIllIllIIlIII++] = (byte)llllllllllllllllllIlIllIllIIlIlI;
        for (int llllllllllllllllllIlIllIllIIllll = 0; llllllllllllllllllIlIllIllIIllll < llllllllllllllllllIlIllIllIIlIlI; ++llllllllllllllllllIlIllIllIIllll) {
            char llllllllllllllllllIlIllIllIlIIIl = llllllllllllllllllIlIllIllIIllII.charAt(llllllllllllllllllIlIllIllIIllll);
            if (llllllllllllllllllIlIllIllIlIIIl < '\u0001' || llllllllllllllllllIlIllIllIlIIIl > '\u007f') {
                llllllllllllllllllIlIllIllIIllIl.length = llllllllllllllllllIlIllIllIIlIII;
                return llllllllllllllllllIlIllIllIIllIl.encodeUTF8(llllllllllllllllllIlIllIllIIllII, llllllllllllllllllIlIllIllIIllll, 65535);
            }
            llllllllllllllllllIlIllIllIIIllI[llllllllllllllllllIlIllIllIIlIII++] = (byte)llllllllllllllllllIlIllIllIlIIIl;
        }
        llllllllllllllllllIlIllIllIIllIl.length = llllllllllllllllllIlIllIllIIlIII;
        return llllllllllllllllllIlIllIllIIllIl;
    }

    public ByteVector putLong(long llllllllllllllllllIlIlllIIlIlIlI) {
        ByteVector llllllllllllllllllIlIlllIIlIIIII;
        int llllllllllllllllllIlIlllIIlIIlll = llllllllllllllllllIlIlllIIlIIIII.length;
        if (llllllllllllllllllIlIlllIIlIIlll + 8 > llllllllllllllllllIlIlllIIlIIIII.data.length) {
            llllllllllllllllllIlIlllIIlIIIII.enlarge(8);
        }
        byte[] llllllllllllllllllIlIlllIIlIIlIl = llllllllllllllllllIlIlllIIlIIIII.data;
        int llllllllllllllllllIlIlllIIlIIIlI = (int)(llllllllllllllllllIlIlllIIlIlIlI >>> 32);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)(llllllllllllllllllIlIlllIIlIIIlI >>> 24);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)(llllllllllllllllllIlIlllIIlIIIlI >>> 16);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)(llllllllllllllllllIlIlllIIlIIIlI >>> 8);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)llllllllllllllllllIlIlllIIlIIIlI;
        llllllllllllllllllIlIlllIIlIIIlI = (int)llllllllllllllllllIlIlllIIlIlIlI;
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)(llllllllllllllllllIlIlllIIlIIIlI >>> 24);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)(llllllllllllllllllIlIlllIIlIIIlI >>> 16);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)(llllllllllllllllllIlIlllIIlIIIlI >>> 8);
        llllllllllllllllllIlIlllIIlIIlIl[llllllllllllllllllIlIlllIIlIIlll++] = (byte)llllllllllllllllllIlIlllIIlIIIlI;
        llllllllllllllllllIlIlllIIlIIIII.length = llllllllllllllllllIlIlllIIlIIlll;
        return llllllllllllllllllIlIlllIIlIIIII;
    }

    public ByteVector() {
        ByteVector llllllllllllllllllIlIlllllIIIIIl;
        llllllllllllllllllIlIlllllIIIIIl.data = new byte[64];
    }

    ByteVector put12(int llllllllllllllllllIlIlllIllllIIl, int llllllllllllllllllIlIlllIllllIII) {
        ByteVector llllllllllllllllllIlIlllIllllIlI;
        int llllllllllllllllllIlIlllIlllllII = llllllllllllllllllIlIlllIllllIlI.length;
        if (llllllllllllllllllIlIlllIlllllII + 3 > llllllllllllllllllIlIlllIllllIlI.data.length) {
            llllllllllllllllllIlIlllIllllIlI.enlarge(3);
        }
        byte[] llllllllllllllllllIlIlllIllllIll = llllllllllllllllllIlIlllIllllIlI.data;
        llllllllllllllllllIlIlllIllllIll[llllllllllllllllllIlIlllIlllllII++] = (byte)llllllllllllllllllIlIlllIllllIIl;
        llllllllllllllllllIlIlllIllllIll[llllllllllllllllllIlIlllIlllllII++] = (byte)(llllllllllllllllllIlIlllIllllIII >>> 8);
        llllllllllllllllllIlIlllIllllIll[llllllllllllllllllIlIlllIlllllII++] = (byte)llllllllllllllllllIlIlllIllllIII;
        llllllllllllllllllIlIlllIllllIlI.length = llllllllllllllllllIlIlllIlllllII;
        return llllllllllllllllllIlIlllIllllIlI;
    }

    private void enlarge(int llllllllllllllllllIlIllIIIlllIlI) {
        ByteVector llllllllllllllllllIlIllIIIllIllI;
        int llllllllllllllllllIlIllIIIlllIIl = 2 * llllllllllllllllllIlIllIIIllIllI.data.length;
        int llllllllllllllllllIlIllIIIlllIII = llllllllllllllllllIlIllIIIllIllI.length + llllllllllllllllllIlIllIIIlllIlI;
        byte[] llllllllllllllllllIlIllIIIllIlll = new byte[llllllllllllllllllIlIllIIIlllIIl > llllllllllllllllllIlIllIIIlllIII ? llllllllllllllllllIlIllIIIlllIIl : llllllllllllllllllIlIllIIIlllIII];
        System.arraycopy(llllllllllllllllllIlIllIIIllIllI.data, 0, llllllllllllllllllIlIllIIIllIlll, 0, llllllllllllllllllIlIllIIIllIllI.length);
        llllllllllllllllllIlIllIIIllIllI.data = llllllllllllllllllIlIllIIIllIlll;
    }

    public ByteVector putInt(int llllllllllllllllllIlIlllIllIIlIl) {
        ByteVector llllllllllllllllllIlIlllIllIIllI;
        int llllllllllllllllllIlIlllIllIIlII = llllllllllllllllllIlIlllIllIIllI.length;
        if (llllllllllllllllllIlIlllIllIIlII + 4 > llllllllllllllllllIlIlllIllIIllI.data.length) {
            llllllllllllllllllIlIlllIllIIllI.enlarge(4);
        }
        byte[] llllllllllllllllllIlIlllIllIIIll = llllllllllllllllllIlIlllIllIIllI.data;
        llllllllllllllllllIlIlllIllIIIll[llllllllllllllllllIlIlllIllIIlII++] = (byte)(llllllllllllllllllIlIlllIllIIlIl >>> 24);
        llllllllllllllllllIlIlllIllIIIll[llllllllllllllllllIlIlllIllIIlII++] = (byte)(llllllllllllllllllIlIlllIllIIlIl >>> 16);
        llllllllllllllllllIlIlllIllIIIll[llllllllllllllllllIlIlllIllIIlII++] = (byte)(llllllllllllllllllIlIlllIllIIlIl >>> 8);
        llllllllllllllllllIlIlllIllIIIll[llllllllllllllllllIlIlllIllIIlII++] = (byte)llllllllllllllllllIlIlllIllIIlIl;
        llllllllllllllllllIlIlllIllIIllI.length = llllllllllllllllllIlIlllIllIIlII;
        return llllllllllllllllllIlIlllIllIIllI;
    }

    ByteVector put11(int llllllllllllllllllIlIllllIlIlIlI, int llllllllllllllllllIlIllllIlIlIIl) {
        ByteVector llllllllllllllllllIlIllllIlIIllI;
        int llllllllllllllllllIlIllllIlIlIII = llllllllllllllllllIlIllllIlIIllI.length;
        if (llllllllllllllllllIlIllllIlIlIII + 2 > llllllllllllllllllIlIllllIlIIllI.data.length) {
            llllllllllllllllllIlIllllIlIIllI.enlarge(2);
        }
        byte[] llllllllllllllllllIlIllllIlIIlll = llllllllllllllllllIlIllllIlIIllI.data;
        llllllllllllllllllIlIllllIlIIlll[llllllllllllllllllIlIllllIlIlIII++] = (byte)llllllllllllllllllIlIllllIlIlIlI;
        llllllllllllllllllIlIllllIlIIlll[llllllllllllllllllIlIllllIlIlIII++] = (byte)llllllllllllllllllIlIllllIlIlIIl;
        llllllllllllllllllIlIllllIlIIllI.length = llllllllllllllllllIlIllllIlIlIII;
        return llllllllllllllllllIlIllllIlIIllI;
    }

    public ByteVector(int llllllllllllllllllIlIllllIlllIlI) {
        ByteVector llllllllllllllllllIlIllllIllllIl;
        llllllllllllllllllIlIllllIllllIl.data = new byte[llllllllllllllllllIlIllllIlllIlI];
    }

    ByteVector encodeUTF8(String llllllllllllllllllIlIllIIllIIIlI, int llllllllllllllllllIlIllIIllIIIIl, int llllllllllllllllllIlIllIIlIllIII) {
        ByteVector llllllllllllllllllIlIllIIllIIIll;
        int llllllllllllllllllIlIllIIlIlllll = llllllllllllllllllIlIllIIllIIIlI.length();
        int llllllllllllllllllIlIllIIlIllllI = llllllllllllllllllIlIllIIllIIIIl;
        for (int llllllllllllllllllIlIllIIllIIllI = llllllllllllllllllIlIllIIllIIIIl; llllllllllllllllllIlIllIIllIIllI < llllllllllllllllllIlIllIIlIlllll; ++llllllllllllllllllIlIllIIllIIllI) {
            char llllllllllllllllllIlIllIIllIIlll = llllllllllllllllllIlIllIIllIIIlI.charAt(llllllllllllllllllIlIllIIllIIllI);
            if (llllllllllllllllllIlIllIIllIIlll >= '\u0001' && llllllllllllllllllIlIllIIllIIlll <= '\u007f') {
                ++llllllllllllllllllIlIllIIlIllllI;
                continue;
            }
            if (llllllllllllllllllIlIllIIllIIlll > '\u07ff') {
                llllllllllllllllllIlIllIIlIllllI += 3;
                continue;
            }
            llllllllllllllllllIlIllIIlIllllI += 2;
        }
        if (llllllllllllllllllIlIllIIlIllllI > llllllllllllllllllIlIllIIlIllIII) {
            throw new IllegalArgumentException();
        }
        int llllllllllllllllllIlIllIIlIlllIl = llllllllllllllllllIlIllIIllIIIll.length - llllllllllllllllllIlIllIIllIIIIl - 2;
        if (llllllllllllllllllIlIllIIlIlllIl >= 0) {
            llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllIl] = (byte)(llllllllllllllllllIlIllIIlIllllI >>> 8);
            llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllIl + 1] = (byte)llllllllllllllllllIlIllIIlIllllI;
        }
        if (llllllllllllllllllIlIllIIllIIIll.length + llllllllllllllllllIlIllIIlIllllI - llllllllllllllllllIlIllIIllIIIIl > llllllllllllllllllIlIllIIllIIIll.data.length) {
            llllllllllllllllllIlIllIIllIIIll.enlarge(llllllllllllllllllIlIllIIlIllllI - llllllllllllllllllIlIllIIllIIIIl);
        }
        int llllllllllllllllllIlIllIIlIlllII = llllllllllllllllllIlIllIIllIIIll.length;
        for (int llllllllllllllllllIlIllIIllIIlII = llllllllllllllllllIlIllIIllIIIIl; llllllllllllllllllIlIllIIllIIlII < llllllllllllllllllIlIllIIlIlllll; ++llllllllllllllllllIlIllIIllIIlII) {
            char llllllllllllllllllIlIllIIllIIlIl = llllllllllllllllllIlIllIIllIIIlI.charAt(llllllllllllllllllIlIllIIllIIlII);
            if (llllllllllllllllllIlIllIIllIIlIl >= '\u0001' && llllllllllllllllllIlIllIIllIIlIl <= '\u007f') {
                llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllII++] = (byte)llllllllllllllllllIlIllIIllIIlIl;
                continue;
            }
            if (llllllllllllllllllIlIllIIllIIlIl > '\u07ff') {
                llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllII++] = (byte)(0xE0 | llllllllllllllllllIlIllIIllIIlIl >> 12 & 0xF);
                llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllII++] = (byte)(0x80 | llllllllllllllllllIlIllIIllIIlIl >> 6 & 0x3F);
                llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllII++] = (byte)(0x80 | llllllllllllllllllIlIllIIllIIlIl & 0x3F);
                continue;
            }
            llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllII++] = (byte)(0xC0 | llllllllllllllllllIlIllIIllIIlIl >> 6 & 0x1F);
            llllllllllllllllllIlIllIIllIIIll.data[llllllllllllllllllIlIllIIlIlllII++] = (byte)(0x80 | llllllllllllllllllIlIllIIllIIlIl & 0x3F);
        }
        llllllllllllllllllIlIllIIllIIIll.length = llllllllllllllllllIlIllIIlIlllII;
        return llllllllllllllllllIlIllIIllIIIll;
    }
}

