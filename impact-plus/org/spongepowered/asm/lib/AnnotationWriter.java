/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

final class AnnotationWriter
extends AnnotationVisitor {
    private final /* synthetic */ int offset;
    /* synthetic */ AnnotationWriter prev;
    /* synthetic */ AnnotationWriter next;
    private /* synthetic */ int size;
    private final /* synthetic */ ByteVector parent;
    private final /* synthetic */ boolean named;
    private final /* synthetic */ ClassWriter cw;
    private final /* synthetic */ ByteVector bv;

    void put(ByteVector llIlllIlllIlIII) {
        AnnotationWriter llIlllIlllIlIIl;
        int llIlllIlllIIllI = 0;
        int llIlllIlllIIlII = 2;
        AnnotationWriter llIlllIlllIIIll = llIlllIlllIlIIl;
        AnnotationWriter llIlllIlllIIIlI = null;
        while (llIlllIlllIIIll != null) {
            ++llIlllIlllIIllI;
            llIlllIlllIIlII += llIlllIlllIIIll.bv.length;
            llIlllIlllIIIll.visitEnd();
            llIlllIlllIIIll.prev = llIlllIlllIIIlI;
            llIlllIlllIIIlI = llIlllIlllIIIll;
            llIlllIlllIIIll = llIlllIlllIIIll.next;
        }
        llIlllIlllIlIII.putInt(llIlllIlllIIlII);
        llIlllIlllIlIII.putShort(llIlllIlllIIllI);
        llIlllIlllIIIll = llIlllIlllIIIlI;
        while (llIlllIlllIIIll != null) {
            llIlllIlllIlIII.putByteArray(llIlllIlllIIIll.bv.data, 0, llIlllIlllIIIll.bv.length);
            llIlllIlllIIIll = llIlllIlllIIIll.prev;
        }
    }

    public void visitEnd() {
        AnnotationWriter llIllllIIIIllll;
        if (llIllllIIIIllll.parent != null) {
            byte[] llIllllIIIlIIII = llIllllIIIIllll.parent.data;
            llIllllIIIlIIII[llIllllIIIIllll.offset] = (byte)(llIllllIIIIllll.size >>> 8);
            llIllllIIIlIIII[llIllllIIIIllll.offset + 1] = (byte)llIllllIIIIllll.size;
        }
    }

    static void putTarget(int llIlllIlIIIllIl, TypePath llIlllIlIIIlIll, ByteVector llIlllIlIIIIIll) {
        switch (llIlllIlIIIllIl >>> 24) {
            case 0: 
            case 1: 
            case 22: {
                llIlllIlIIIIIll.putShort(llIlllIlIIIllIl >>> 16);
                break;
            }
            case 19: 
            case 20: 
            case 21: {
                llIlllIlIIIIIll.putByte(llIlllIlIIIllIl >>> 24);
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                llIlllIlIIIIIll.putInt(llIlllIlIIIllIl);
                break;
            }
            default: {
                llIlllIlIIIIIll.put12(llIlllIlIIIllIl >>> 24, (llIlllIlIIIllIl & 0xFFFF00) >> 8);
            }
        }
        if (llIlllIlIIIlIll == null) {
            llIlllIlIIIIIll.putByte(0);
        } else {
            int llIlllIlIIIllll = llIlllIlIIIlIll.b[llIlllIlIIIlIll.offset] * 2 + 1;
            llIlllIlIIIIIll.putByteArray(llIlllIlIIIlIll.b, llIlllIlIIIlIll.offset, llIlllIlIIIllll);
        }
    }

    AnnotationWriter(ClassWriter llIllllIlIlIlll, boolean llIllllIlIlIIII, ByteVector llIllllIlIIllll, ByteVector llIllllIlIlIlII, int llIllllIlIlIIll) {
        super(327680);
        AnnotationWriter llIllllIlIllIII;
        llIllllIlIllIII.cw = llIllllIlIlIlll;
        llIllllIlIllIII.named = llIllllIlIlIIII;
        llIllllIlIllIII.bv = llIllllIlIIllll;
        llIllllIlIllIII.parent = llIllllIlIlIlII;
        llIllllIlIllIII.offset = llIllllIlIlIIll;
    }

    public void visit(String llIllllIIllIIIl, Object llIllllIIllIIII) {
        AnnotationWriter llIllllIIllIlIl;
        ++llIllllIIllIlIl.size;
        if (llIllllIIllIlIl.named) {
            llIllllIIllIlIl.bv.putShort(llIllllIIllIlIl.cw.newUTF8(llIllllIIllIIIl));
        }
        if (llIllllIIllIIII instanceof String) {
            llIllllIIllIlIl.bv.put12(115, llIllllIIllIlIl.cw.newUTF8((String)llIllllIIllIIII));
        } else if (llIllllIIllIIII instanceof Byte) {
            llIllllIIllIlIl.bv.put12(66, llIllllIIllIlIl.cw.newInteger((int)((Byte)llIllllIIllIIII).byteValue()).index);
        } else if (llIllllIIllIIII instanceof Boolean) {
            int llIllllIlIIIlll = (Boolean)llIllllIIllIIII != false ? 1 : 0;
            llIllllIIllIlIl.bv.put12(90, llIllllIIllIlIl.cw.newInteger((int)llIllllIlIIIlll).index);
        } else if (llIllllIIllIIII instanceof Character) {
            llIllllIIllIlIl.bv.put12(67, llIllllIIllIlIl.cw.newInteger((int)((Character)llIllllIIllIIII).charValue()).index);
        } else if (llIllllIIllIIII instanceof Short) {
            llIllllIIllIlIl.bv.put12(83, llIllllIIllIlIl.cw.newInteger((int)((Short)llIllllIIllIIII).shortValue()).index);
        } else if (llIllllIIllIIII instanceof Type) {
            llIllllIIllIlIl.bv.put12(99, llIllllIIllIlIl.cw.newUTF8(((Type)llIllllIIllIIII).getDescriptor()));
        } else if (llIllllIIllIIII instanceof byte[]) {
            byte[] llIllllIlIIIlIl = (byte[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIlIIIlIl.length);
            for (int llIllllIlIIIllI = 0; llIllllIlIIIllI < llIllllIlIIIlIl.length; ++llIllllIlIIIllI) {
                llIllllIIllIlIl.bv.put12(66, llIllllIIllIlIl.cw.newInteger((int)llIllllIlIIIlIl[llIllllIlIIIllI]).index);
            }
        } else if (llIllllIIllIIII instanceof boolean[]) {
            boolean[] llIllllIlIIIIll = (boolean[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIlIIIIll.length);
            for (int llIllllIlIIIlII = 0; llIllllIlIIIlII < llIllllIlIIIIll.length; ++llIllllIlIIIlII) {
                llIllllIIllIlIl.bv.put12(90, llIllllIIllIlIl.cw.newInteger((int)(llIllllIlIIIIll[llIllllIlIIIlII] ? 1 : 0)).index);
            }
        } else if (llIllllIIllIIII instanceof short[]) {
            short[] llIllllIlIIIIIl = (short[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIlIIIIIl.length);
            for (int llIllllIlIIIIlI = 0; llIllllIlIIIIlI < llIllllIlIIIIIl.length; ++llIllllIlIIIIlI) {
                llIllllIIllIlIl.bv.put12(83, llIllllIIllIlIl.cw.newInteger((int)llIllllIlIIIIIl[llIllllIlIIIIlI]).index);
            }
        } else if (llIllllIIllIIII instanceof char[]) {
            char[] llIllllIIllllll = (char[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIIllllll.length);
            for (int llIllllIlIIIIII = 0; llIllllIlIIIIII < llIllllIIllllll.length; ++llIllllIlIIIIII) {
                llIllllIIllIlIl.bv.put12(67, llIllllIIllIlIl.cw.newInteger((int)llIllllIIllllll[llIllllIlIIIIII]).index);
            }
        } else if (llIllllIIllIIII instanceof int[]) {
            int[] llIllllIIllllIl = (int[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIIllllIl.length);
            for (int llIllllIIlllllI = 0; llIllllIIlllllI < llIllllIIllllIl.length; ++llIllllIIlllllI) {
                llIllllIIllIlIl.bv.put12(73, llIllllIIllIlIl.cw.newInteger((int)llIllllIIllllIl[llIllllIIlllllI]).index);
            }
        } else if (llIllllIIllIIII instanceof long[]) {
            long[] llIllllIIlllIll = (long[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIIlllIll.length);
            for (int llIllllIIllllII = 0; llIllllIIllllII < llIllllIIlllIll.length; ++llIllllIIllllII) {
                llIllllIIllIlIl.bv.put12(74, llIllllIIllIlIl.cw.newLong((long)llIllllIIlllIll[llIllllIIllllII]).index);
            }
        } else if (llIllllIIllIIII instanceof float[]) {
            float[] llIllllIIlllIIl = (float[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIIlllIIl.length);
            for (int llIllllIIlllIlI = 0; llIllllIIlllIlI < llIllllIIlllIIl.length; ++llIllllIIlllIlI) {
                llIllllIIllIlIl.bv.put12(70, llIllllIIllIlIl.cw.newFloat((float)llIllllIIlllIIl[llIllllIIlllIlI]).index);
            }
        } else if (llIllllIIllIIII instanceof double[]) {
            double[] llIllllIIllIlll = (double[])llIllllIIllIIII;
            llIllllIIllIlIl.bv.put12(91, llIllllIIllIlll.length);
            for (int llIllllIIlllIII = 0; llIllllIIlllIII < llIllllIIllIlll.length; ++llIllllIIlllIII) {
                llIllllIIllIlIl.bv.put12(68, llIllllIIllIlIl.cw.newDouble((double)llIllllIIllIlll[llIllllIIlllIII]).index);
            }
        } else {
            Item llIllllIIllIllI = llIllllIIllIlIl.cw.newConstItem(llIllllIIllIIII);
            llIllllIIllIlIl.bv.put12(".s.IFJDCS".charAt(llIllllIIllIllI.type), llIllllIIllIllI.index);
        }
    }

    static void put(AnnotationWriter[] llIlllIlIllllII, int llIlllIlIllIlll, ByteVector llIlllIlIlllIlI) {
        int llIlllIlIlllIIl = 1 + 2 * (llIlllIlIllllII.length - llIlllIlIllIlll);
        for (int llIlllIllIIIIIl = llIlllIlIllIlll; llIlllIllIIIIIl < llIlllIlIllllII.length; ++llIlllIllIIIIIl) {
            llIlllIlIlllIIl += llIlllIlIllllII[llIlllIllIIIIIl] == null ? 0 : llIlllIlIllllII[llIlllIllIIIIIl].getSize();
        }
        llIlllIlIlllIlI.putInt(llIlllIlIlllIIl).putByte(llIlllIlIllllII.length - llIlllIlIllIlll);
        for (int llIlllIlIllllIl = llIlllIlIllIlll; llIlllIlIllllIl < llIlllIlIllllII.length; ++llIlllIlIllllIl) {
            AnnotationWriter llIlllIllIIIIII = llIlllIlIllllII[llIlllIlIllllIl];
            AnnotationWriter llIlllIlIllllll = null;
            int llIlllIlIlllllI = 0;
            while (llIlllIllIIIIII != null) {
                ++llIlllIlIlllllI;
                llIlllIllIIIIII.visitEnd();
                llIlllIllIIIIII.prev = llIlllIlIllllll;
                llIlllIlIllllll = llIlllIllIIIIII;
                llIlllIllIIIIII = llIlllIllIIIIII.next;
            }
            llIlllIlIlllIlI.putShort(llIlllIlIlllllI);
            llIlllIllIIIIII = llIlllIlIllllll;
            while (llIlllIllIIIIII != null) {
                llIlllIlIlllIlI.putByteArray(llIlllIllIIIIII.bv.data, 0, llIlllIllIIIIII.bv.length);
                llIlllIllIIIIII = llIlllIllIIIIII.prev;
            }
        }
    }

    int getSize() {
        AnnotationWriter llIllllIIIIlIIl;
        int llIllllIIIIlIII = 0;
        AnnotationWriter llIllllIIIIIllI = llIllllIIIIlIIl;
        while (llIllllIIIIIllI != null) {
            llIllllIIIIlIII += llIllllIIIIIllI.bv.length;
            llIllllIIIIIllI = llIllllIIIIIllI.next;
        }
        return llIllllIIIIlIII;
    }

    public AnnotationVisitor visitAnnotation(String llIllllIIIlllIl, String llIllllIIIllIIl) {
        AnnotationWriter llIllllIIIllIll;
        ++llIllllIIIllIll.size;
        if (llIllllIIIllIll.named) {
            llIllllIIIllIll.bv.putShort(llIllllIIIllIll.cw.newUTF8(llIllllIIIlllIl));
        }
        llIllllIIIllIll.bv.put12(64, llIllllIIIllIll.cw.newUTF8(llIllllIIIllIIl)).putShort(0);
        return new AnnotationWriter(llIllllIIIllIll.cw, true, llIllllIIIllIll.bv, llIllllIIIllIll.bv, llIllllIIIllIll.bv.length - 2);
    }

    public void visitEnum(String llIllllIIlIIlII, String llIllllIIlIIIll, String llIllllIIlIIllI) {
        AnnotationWriter llIllllIIlIlIIl;
        ++llIllllIIlIlIIl.size;
        if (llIllllIIlIlIIl.named) {
            llIllllIIlIlIIl.bv.putShort(llIllllIIlIlIIl.cw.newUTF8(llIllllIIlIIlII));
        }
        llIllllIIlIlIIl.bv.put12(101, llIllllIIlIlIIl.cw.newUTF8(llIllllIIlIIIll)).putShort(llIllllIIlIlIIl.cw.newUTF8(llIllllIIlIIllI));
    }

    public AnnotationVisitor visitArray(String llIllllIIIlIlIl) {
        AnnotationWriter llIllllIIIlIllI;
        ++llIllllIIIlIllI.size;
        if (llIllllIIIlIllI.named) {
            llIllllIIIlIllI.bv.putShort(llIllllIIIlIllI.cw.newUTF8(llIllllIIIlIlIl));
        }
        llIllllIIIlIllI.bv.put12(91, 0);
        return new AnnotationWriter(llIllllIIIlIllI.cw, false, llIllllIIIlIllI.bv, llIllllIIIlIllI.bv, llIllllIIIlIllI.bv.length - 2);
    }
}

