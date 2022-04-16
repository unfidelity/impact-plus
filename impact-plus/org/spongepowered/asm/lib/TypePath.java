/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.ByteVector;

public class TypePath {
    public static final /* synthetic */ int WILDCARD_BOUND;
    public static final /* synthetic */ int TYPE_ARGUMENT;
    /* synthetic */ int offset;
    /* synthetic */ byte[] b;
    public static final /* synthetic */ int ARRAY_ELEMENT;
    public static final /* synthetic */ int INNER_TYPE;

    TypePath(byte[] llllllllllllllllIlIllllIllIllIll, int llllllllllllllllIlIllllIllIlIlIl) {
        TypePath llllllllllllllllIlIllllIllIlllIl;
        llllllllllllllllIlIllllIllIlllIl.b = llllllllllllllllIlIllllIllIllIll;
        llllllllllllllllIlIllllIllIlllIl.offset = llllllllllllllllIlIllllIllIlIlIl;
    }

    static {
        INNER_TYPE = 1;
        WILDCARD_BOUND = 2;
        TYPE_ARGUMENT = 3;
        ARRAY_ELEMENT = 0;
    }

    public static TypePath fromString(String llllllllllllllllIlIllllIIlllllIl) {
        if (llllllllllllllllIlIllllIIlllllIl == null || llllllllllllllllIlIllllIIlllllIl.length() == 0) {
            return null;
        }
        int llllllllllllllllIlIllllIIlllllll = llllllllllllllllIlIllllIIlllllIl.length();
        ByteVector llllllllllllllllIlIllllIIllllllI = new ByteVector(llllllllllllllllIlIllllIIlllllll);
        llllllllllllllllIlIllllIIllllllI.putByte(0);
        int llllllllllllllllIlIllllIlIIIIIIl = 0;
        while (llllllllllllllllIlIllllIlIIIIIIl < llllllllllllllllIlIllllIIlllllll) {
            char llllllllllllllllIlIllllIlIIIIIlI;
            if ((llllllllllllllllIlIllllIlIIIIIlI = llllllllllllllllIlIllllIIlllllIl.charAt(llllllllllllllllIlIllllIlIIIIIIl++)) == '[') {
                llllllllllllllllIlIllllIIllllllI.put11(0, 0);
                continue;
            }
            if (llllllllllllllllIlIllllIlIIIIIlI == '.') {
                llllllllllllllllIlIllllIIllllllI.put11(1, 0);
                continue;
            }
            if (llllllllllllllllIlIllllIlIIIIIlI == '*') {
                llllllllllllllllIlIllllIIllllllI.put11(2, 0);
                continue;
            }
            if (llllllllllllllllIlIllllIlIIIIIlI < '0' || llllllllllllllllIlIllllIlIIIIIlI > '9') continue;
            int llllllllllllllllIlIllllIlIIIIIll = llllllllllllllllIlIllllIlIIIIIlI - 48;
            while (llllllllllllllllIlIllllIlIIIIIIl < llllllllllllllllIlIllllIIlllllll && (llllllllllllllllIlIllllIlIIIIIlI = llllllllllllllllIlIllllIIlllllIl.charAt(llllllllllllllllIlIllllIlIIIIIIl)) >= '0' && llllllllllllllllIlIllllIlIIIIIlI <= '9') {
                llllllllllllllllIlIllllIlIIIIIll = llllllllllllllllIlIllllIlIIIIIll * 10 + llllllllllllllllIlIllllIlIIIIIlI - 48;
                ++llllllllllllllllIlIllllIlIIIIIIl;
            }
            if (llllllllllllllllIlIllllIlIIIIIIl < llllllllllllllllIlIllllIIlllllll && llllllllllllllllIlIllllIIlllllIl.charAt(llllllllllllllllIlIllllIlIIIIIIl) == ';') {
                ++llllllllllllllllIlIllllIlIIIIIIl;
            }
            llllllllllllllllIlIllllIIllllllI.put11(3, llllllllllllllllIlIllllIlIIIIIll);
        }
        llllllllllllllllIlIllllIIllllllI.data[0] = (byte)(llllllllllllllllIlIllllIIllllllI.length / 2);
        return new TypePath(llllllllllllllllIlIllllIIllllllI.data, 0);
    }

    public int getStep(int llllllllllllllllIlIllllIlIllIllI) {
        TypePath llllllllllllllllIlIllllIlIlllIII;
        return llllllllllllllllIlIllllIlIlllIII.b[llllllllllllllllIlIllllIlIlllIII.offset + 2 * llllllllllllllllIlIllllIlIllIllI + 1];
    }

    public int getLength() {
        TypePath llllllllllllllllIlIllllIllIIlIII;
        return llllllllllllllllIlIllllIllIIlIII.b[llllllllllllllllIlIllllIllIIlIII.offset];
    }

    public int getStepArgument(int llllllllllllllllIlIllllIlIlIlIlI) {
        TypePath llllllllllllllllIlIllllIlIlIlIll;
        return llllllllllllllllIlIllllIlIlIlIll.b[llllllllllllllllIlIllllIlIlIlIll.offset + 2 * llllllllllllllllIlIllllIlIlIlIlI + 2];
    }

    public String toString() {
        TypePath llllllllllllllllIlIllllIIllIllII;
        int llllllllllllllllIlIllllIIlllIIII = llllllllllllllllIlIllllIIllIllII.getLength();
        StringBuilder llllllllllllllllIlIllllIIllIlllI = new StringBuilder(llllllllllllllllIlIllllIIlllIIII * 2);
        block6: for (int llllllllllllllllIlIllllIIlllIIll = 0; llllllllllllllllIlIllllIIlllIIll < llllllllllllllllIlIllllIIlllIIII; ++llllllllllllllllIlIllllIIlllIIll) {
            switch (llllllllllllllllIlIllllIIllIllII.getStep(llllllllllllllllIlIllllIIlllIIll)) {
                case 0: {
                    llllllllllllllllIlIllllIIllIlllI.append('[');
                    continue block6;
                }
                case 1: {
                    llllllllllllllllIlIllllIIllIlllI.append('.');
                    continue block6;
                }
                case 2: {
                    llllllllllllllllIlIllllIIllIlllI.append('*');
                    continue block6;
                }
                case 3: {
                    llllllllllllllllIlIllllIIllIlllI.append(llllllllllllllllIlIllllIIllIllII.getStepArgument(llllllllllllllllIlIllllIIlllIIll)).append(';');
                    continue block6;
                }
                default: {
                    llllllllllllllllIlIllllIIllIlllI.append('_');
                }
            }
        }
        return String.valueOf(llllllllllllllllIlIllllIIllIlllI);
    }
}

