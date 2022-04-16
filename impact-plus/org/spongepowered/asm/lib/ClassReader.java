/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import java.io.IOException;
import java.io.InputStream;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Context;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.MethodWriter;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

public class ClassReader {
    static final /* synthetic */ boolean FRAMES;
    static final /* synthetic */ boolean ANNOTATIONS;
    private final /* synthetic */ int maxStringLength;
    public static final /* synthetic */ int SKIP_FRAMES;
    static final /* synthetic */ int EXPAND_ASM_INSNS;
    private final /* synthetic */ String[] strings;
    public static final /* synthetic */ int EXPAND_FRAMES;
    static final /* synthetic */ boolean WRITER;
    public final /* synthetic */ byte[] b;
    private final /* synthetic */ int[] items;
    public final /* synthetic */ int header;
    public static final /* synthetic */ int SKIP_CODE;
    static final /* synthetic */ boolean RESIZE;
    public static final /* synthetic */ int SKIP_DEBUG;
    static final /* synthetic */ boolean SIGNATURES;

    private void readCode(MethodVisitor llllllllllllllllIIIllllIIIlIIlII, Context llllllllllllllllIIIllllIIIIIIlll, int llllllllllllllllIIIllllIIIIIIllI) {
        ClassReader llllllllllllllllIIIllllIIIIIlIIl;
        byte[] llllllllllllllllIIIllllIIIlIIIIl = llllllllllllllllIIIllllIIIIIlIIl.b;
        char[] llllllllllllllllIIIllllIIIlIIIII = llllllllllllllllIIIllllIIIIIIlll.buffer;
        int llllllllllllllllIIIllllIIIIlllll = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI);
        int llllllllllllllllIIIllllIIIIllllI = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 2);
        int llllllllllllllllIIIllllIIIIlllIl = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4);
        int llllllllllllllllIIIllllIIIIlllII = llllllllllllllllIIIllllIIIIIIllI += 8;
        int llllllllllllllllIIIllllIIIIllIll = llllllllllllllllIIIllllIIIIIIllI + llllllllllllllllIIIllllIIIIlllIl;
        llllllllllllllllIIIllllIIIIIIlll.labels = new Label[llllllllllllllllIIIllllIIIIlllIl + 2];
        Label[] llllllllllllllllIIIllllIIIIllIlI = llllllllllllllllIIIllllIIIIIIlll.labels;
        llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIIIlllIl + 1, llllllllllllllllIIIllllIIIIllIlI);
        block31: while (llllllllllllllllIIIllllIIIIIIllI < llllllllllllllllIIIllllIIIIllIll) {
            int llllllllllllllllIIIllllIIllIIlIl = llllllllllllllllIIIllllIIIIIIllI - llllllllllllllllIIIllllIIIIlllII;
            int llllllllllllllllIIIllllIIllIIlII = llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI] & 0xFF;
            switch (ClassWriter.TYPE[llllllllllllllllIIIllllIIllIIlII]) {
                case 0: 
                case 4: {
                    ++llllllllllllllllIIIllllIIIIIIllI;
                    continue block31;
                }
                case 9: {
                    llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readShort(llllllllllllllllIIIllllIIIIIIllI + 1), llllllllllllllllIIIllllIIIIllIlI);
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    continue block31;
                }
                case 18: {
                    llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 1), llllllllllllllllIIIllllIIIIllIlI);
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    continue block31;
                }
                case 10: {
                    llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 1), llllllllllllllllIIIllllIIIIllIlI);
                    llllllllllllllllIIIllllIIIIIIllI += 5;
                    continue block31;
                }
                case 17: {
                    llllllllllllllllIIIllllIIllIIlII = llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 1] & 0xFF;
                    if (llllllllllllllllIIIllllIIllIIlII == 132) {
                        llllllllllllllllIIIllllIIIIIIllI += 6;
                        continue block31;
                    }
                    llllllllllllllllIIIllllIIIIIIllI += 4;
                    continue block31;
                }
                case 14: {
                    llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIIIllI + 4 - (llllllllllllllllIIIllllIIllIIlIl & 3);
                    llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI), llllllllllllllllIIIllllIIIIllIlI);
                    for (int llllllllllllllllIIIllllIIllIIlll = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 8) - llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4) + 1; llllllllllllllllIIIllllIIllIIlll > 0; --llllllllllllllllIIIllllIIllIIlll) {
                        llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 12), llllllllllllllllIIIllllIIIIllIlI);
                        llllllllllllllllIIIllllIIIIIIllI += 4;
                    }
                    llllllllllllllllIIIllllIIIIIIllI += 12;
                    continue block31;
                }
                case 15: {
                    llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIIIllI + 4 - (llllllllllllllllIIIllllIIllIIlIl & 3);
                    llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI), llllllllllllllllIIIllllIIIIllIlI);
                    for (int llllllllllllllllIIIllllIIllIIllI = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4); llllllllllllllllIIIllllIIllIIllI > 0; --llllllllllllllllIIIllllIIllIIllI) {
                        llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIllIIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 12), llllllllllllllllIIIllllIIIIllIlI);
                        llllllllllllllllIIIllllIIIIIIllI += 8;
                    }
                    llllllllllllllllIIIllllIIIIIIllI += 8;
                    continue block31;
                }
                case 1: 
                case 3: 
                case 11: {
                    llllllllllllllllIIIllllIIIIIIllI += 2;
                    continue block31;
                }
                case 2: 
                case 5: 
                case 6: 
                case 12: 
                case 13: {
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    continue block31;
                }
                case 7: 
                case 8: {
                    llllllllllllllllIIIllllIIIIIIllI += 5;
                    continue block31;
                }
            }
            llllllllllllllllIIIllllIIIIIIllI += 4;
        }
        for (int llllllllllllllllIIIllllIIlIlllll = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI); llllllllllllllllIIIllllIIlIlllll > 0; --llllllllllllllllIIIllllIIlIlllll) {
            Label llllllllllllllllIIIllllIIllIIIll = llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 2), llllllllllllllllIIIllllIIIIllIlI);
            Label llllllllllllllllIIIllllIIllIIIlI = llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 4), llllllllllllllllIIIllllIIIIllIlI);
            Label llllllllllllllllIIIllllIIllIIIIl = llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 6), llllllllllllllllIIIllllIIIIllIlI);
            String llllllllllllllllIIIllllIIllIIIII = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIIIlIIl.items[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8)], llllllllllllllllIIIllllIIIlIIIII);
            llllllllllllllllIIIllllIIIlIIlII.visitTryCatchBlock(llllllllllllllllIIIllllIIllIIIll, llllllllllllllllIIIllllIIllIIIlI, llllllllllllllllIIIllllIIllIIIIl, llllllllllllllllIIIllllIIllIIIII);
            llllllllllllllllIIIllllIIIIIIllI += 8;
        }
        llllllllllllllllIIIllllIIIIIIllI += 2;
        int[] llllllllllllllllIIIllllIIIIllIIl = null;
        int[] llllllllllllllllIIIllllIIIIllIII = null;
        int llllllllllllllllIIIllllIIIIlIlll = 0;
        int llllllllllllllllIIIllllIIIIlIllI = 0;
        int llllllllllllllllIIIllllIIIIlIlIl = -1;
        int llllllllllllllllIIIllllIIIIlIlII = -1;
        int llllllllllllllllIIIllllIIIIlIIll = 0;
        int llllllllllllllllIIIllllIIIIlIIlI = 0;
        boolean llllllllllllllllIIIllllIIIIlIIIl = true;
        boolean llllllllllllllllIIIllllIIIIlIIII = (llllllllllllllllIIIllllIIIIIIlll.flags & 8) != 0;
        int llllllllllllllllIIIllllIIIIIllll = 0;
        int llllllllllllllllIIIllllIIIIIlllI = 0;
        int llllllllllllllllIIIllllIIIIIllIl = 0;
        Context llllllllllllllllIIIllllIIIIIllII = null;
        Attribute llllllllllllllllIIIllllIIIIIlIll = null;
        for (int llllllllllllllllIIIllllIIlIlIlII = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI); llllllllllllllllIIIllllIIlIlIlII > 0; --llllllllllllllllIIIllllIIlIlIlII) {
            String llllllllllllllllIIIllllIIlIlIlIl = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIIIIllI + 2, llllllllllllllllIIIllllIIIlIIIII);
            if ("LocalVariableTable".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                if ((llllllllllllllllIIIllllIIIIIIlll.flags & 2) == 0) {
                    llllllllllllllllIIIllllIIIIlIIll = llllllllllllllllIIIllllIIIIIIllI + 8;
                    int llllllllllllllllIIIllllIIlIlllII = llllllllllllllllIIIllllIIIIIIllI;
                    for (int llllllllllllllllIIIllllIIlIlllIl = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8); llllllllllllllllIIIllllIIlIlllIl > 0; --llllllllllllllllIIIllllIIlIlllIl) {
                        int llllllllllllllllIIIllllIIlIllllI = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIlIlllII + 10);
                        if (llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIlIllllI] == null) {
                            llllllllllllllllIIIllllIIIIIlIIl.readLabel((int)llllllllllllllllIIIllllIIlIllllI, (Label[])llllllllllllllllIIIllllIIIIllIlI).status |= 1;
                        }
                        if (llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIlIllllI += llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIlIlllII + 12)] == null) {
                            llllllllllllllllIIIllllIIIIIlIIl.readLabel((int)llllllllllllllllIIIllllIIlIllllI, (Label[])llllllllllllllllIIIllllIIIIllIlI).status |= 1;
                        }
                        llllllllllllllllIIIllllIIlIlllII += 10;
                    }
                }
            } else if ("LocalVariableTypeTable".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                llllllllllllllllIIIllllIIIIlIIlI = llllllllllllllllIIIllllIIIIIIllI + 8;
            } else if ("LineNumberTable".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                if ((llllllllllllllllIIIllllIIIIIIlll.flags & 2) == 0) {
                    int llllllllllllllllIIIllllIIlIllIII = llllllllllllllllIIIllllIIIIIIllI;
                    for (int llllllllllllllllIIIllllIIlIllIIl = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8); llllllllllllllllIIIllllIIlIllIIl > 0; --llllllllllllllllIIIllllIIlIllIIl) {
                        int llllllllllllllllIIIllllIIlIllIll = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIlIllIII + 10);
                        if (llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIlIllIll] == null) {
                            llllllllllllllllIIIllllIIIIIlIIl.readLabel((int)llllllllllllllllIIIllllIIlIllIll, (Label[])llllllllllllllllIIIllllIIIIllIlI).status |= 1;
                        }
                        Label llllllllllllllllIIIllllIIlIllIlI = llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIlIllIll];
                        while (llllllllllllllllIIIllllIIlIllIlI.line > 0) {
                            if (llllllllllllllllIIIllllIIlIllIlI.next == null) {
                                llllllllllllllllIIIllllIIlIllIlI.next = new Label();
                            }
                            llllllllllllllllIIIllllIIlIllIlI = llllllllllllllllIIIllllIIlIllIlI.next;
                        }
                        llllllllllllllllIIIllllIIlIllIlI.line = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIlIllIII + 12);
                        llllllllllllllllIIIllllIIlIllIII += 4;
                    }
                }
            } else if ("RuntimeVisibleTypeAnnotations".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                llllllllllllllllIIIllllIIIIllIIl = llllllllllllllllIIIllllIIIIIlIIl.readTypeAnnotations(llllllllllllllllIIIllllIIIlIIlII, llllllllllllllllIIIllllIIIIIIlll, llllllllllllllllIIIllllIIIIIIllI + 8, true);
                llllllllllllllllIIIllllIIIIlIlIl = llllllllllllllllIIIllllIIIIllIIl.length == 0 || llllllllllllllllIIIllllIIIIIlIIl.readByte(llllllllllllllllIIIllllIIIIllIIl[0]) < 67 ? -1 : llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIllIIl[0] + 1);
            } else if ("RuntimeInvisibleTypeAnnotations".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                llllllllllllllllIIIllllIIIIllIII = llllllllllllllllIIIllllIIIIIlIIl.readTypeAnnotations(llllllllllllllllIIIllllIIIlIIlII, llllllllllllllllIIIllllIIIIIIlll, llllllllllllllllIIIllllIIIIIIllI + 8, false);
                llllllllllllllllIIIllllIIIIlIlII = llllllllllllllllIIIllllIIIIllIII.length == 0 || llllllllllllllllIIIllllIIIIIlIIl.readByte(llllllllllllllllIIIllllIIIIllIII[0]) < 67 ? -1 : llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIllIII[0] + 1);
            } else if ("StackMapTable".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                if ((llllllllllllllllIIIllllIIIIIIlll.flags & 4) == 0) {
                    llllllllllllllllIIIllllIIIIIllll = llllllllllllllllIIIllllIIIIIIllI + 10;
                    llllllllllllllllIIIllllIIIIIlllI = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4);
                    llllllllllllllllIIIllllIIIIIllIl = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8);
                }
            } else if ("StackMap".equals(llllllllllllllllIIIllllIIlIlIlIl)) {
                if ((llllllllllllllllIIIllllIIIIIIlll.flags & 4) == 0) {
                    llllllllllllllllIIIllllIIIIlIIIl = false;
                    llllllllllllllllIIIllllIIIIIllll = llllllllllllllllIIIllllIIIIIIllI + 10;
                    llllllllllllllllIIIllllIIIIIlllI = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4);
                    llllllllllllllllIIIllllIIIIIllIl = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8);
                }
            } else {
                for (int llllllllllllllllIIIllllIIlIlIllI = 0; llllllllllllllllIIIllllIIlIlIllI < llllllllllllllllIIIllllIIIIIIlll.attrs.length; ++llllllllllllllllIIIllllIIlIlIllI) {
                    Attribute llllllllllllllllIIIllllIIlIlIlll;
                    if (!llllllllllllllllIIIllllIIIIIIlll.attrs[llllllllllllllllIIIllllIIlIlIllI].type.equals(llllllllllllllllIIIllllIIlIlIlIl) || (llllllllllllllllIIIllllIIlIlIlll = llllllllllllllllIIIllllIIIIIIlll.attrs[llllllllllllllllIIIllllIIlIlIllI].read(llllllllllllllllIIIllllIIIIIlIIl, llllllllllllllllIIIllllIIIIIIllI + 8, llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4), llllllllllllllllIIIllllIIIlIIIII, llllllllllllllllIIIllllIIIIlllII - 8, llllllllllllllllIIIllllIIIIllIlI)) == null) continue;
                    llllllllllllllllIIIllllIIlIlIlll.next = llllllllllllllllIIIllllIIIIIlIll;
                    llllllllllllllllIIIllllIIIIIlIll = llllllllllllllllIIIllllIIlIlIlll;
                }
            }
            llllllllllllllllIIIllllIIIIIIllI += 6 + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4);
        }
        llllllllllllllllIIIllllIIIIIIllI += 2;
        if (llllllllllllllllIIIllllIIIIIllll != 0) {
            llllllllllllllllIIIllllIIIIIllII = llllllllllllllllIIIllllIIIIIIlll;
            llllllllllllllllIIIllllIIIIIllII.offset = -1;
            llllllllllllllllIIIllllIIIIIllII.mode = 0;
            llllllllllllllllIIIllllIIIIIllII.localCount = 0;
            llllllllllllllllIIIllllIIIIIllII.localDiff = 0;
            llllllllllllllllIIIllllIIIIIllII.stackCount = 0;
            llllllllllllllllIIIllllIIIIIllII.local = new Object[llllllllllllllllIIIllllIIIIllllI];
            llllllllllllllllIIIllllIIIIIllII.stack = new Object[llllllllllllllllIIIllllIIIIlllll];
            if (llllllllllllllllIIIllllIIIIlIIII) {
                llllllllllllllllIIIllllIIIIIlIIl.getImplicitFrame(llllllllllllllllIIIllllIIIIIIlll);
            }
            for (int llllllllllllllllIIIllllIIlIlIIlI = llllllllllllllllIIIllllIIIIIllll; llllllllllllllllIIIllllIIlIlIIlI < llllllllllllllllIIIllllIIIIIllll + llllllllllllllllIIIllllIIIIIlllI - 2; ++llllllllllllllllIIIllllIIlIlIIlI) {
                int llllllllllllllllIIIllllIIlIlIIll;
                if (llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIlIlIIlI] != 8 || (llllllllllllllllIIIllllIIlIlIIll = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIlIlIIlI + 1)) < 0 || llllllllllllllllIIIllllIIlIlIIll >= llllllllllllllllIIIllllIIIIlllIl || (llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIlllII + llllllllllllllllIIIllllIIlIlIIll] & 0xFF) != 187) continue;
                llllllllllllllllIIIllllIIIIIlIIl.readLabel(llllllllllllllllIIIllllIIlIlIIll, llllllllllllllllIIIllllIIIIllIlI);
            }
        }
        if ((llllllllllllllllIIIllllIIIIIIlll.flags & 0x100) != 0) {
            llllllllllllllllIIIllllIIIlIIlII.visitFrame(-1, llllllllllllllllIIIllllIIIIllllI, null, 0, null);
        }
        int llllllllllllllllIIIllllIIIIIlIlI = (llllllllllllllllIIIllllIIIIIIlll.flags & 0x100) == 0 ? -33 : 0;
        llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIlllII;
        while (llllllllllllllllIIIllllIIIIIIllI < llllllllllllllllIIIllllIIIIllIll) {
            int llllllllllllllllIIIllllIIIllIlIl = llllllllllllllllIIIllllIIIIIIllI - llllllllllllllllIIIllllIIIIlllII;
            Label llllllllllllllllIIIllllIIIllIlII = llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIlIl];
            if (llllllllllllllllIIIllllIIIllIlII != null) {
                Label llllllllllllllllIIIllllIIlIlIIIl = llllllllllllllllIIIllllIIIllIlII.next;
                llllllllllllllllIIIllllIIIllIlII.next = null;
                llllllllllllllllIIIllllIIIlIIlII.visitLabel(llllllllllllllllIIIllllIIIllIlII);
                if ((llllllllllllllllIIIllllIIIIIIlll.flags & 2) == 0 && llllllllllllllllIIIllllIIIllIlII.line > 0) {
                    llllllllllllllllIIIllllIIIlIIlII.visitLineNumber(llllllllllllllllIIIllllIIIllIlII.line, llllllllllllllllIIIllllIIIllIlII);
                    while (llllllllllllllllIIIllllIIlIlIIIl != null) {
                        llllllllllllllllIIIllllIIIlIIlII.visitLineNumber(llllllllllllllllIIIllllIIlIlIIIl.line, llllllllllllllllIIIllllIIIllIlII);
                        llllllllllllllllIIIllllIIlIlIIIl = llllllllllllllllIIIllllIIlIlIIIl.next;
                    }
                }
            }
            while (llllllllllllllllIIIllllIIIIIllII != null && (llllllllllllllllIIIllllIIIIIllII.offset == llllllllllllllllIIIllllIIIllIlIl || llllllllllllllllIIIllllIIIIIllII.offset == -1)) {
                if (llllllllllllllllIIIllllIIIIIllII.offset != -1) {
                    if (!llllllllllllllllIIIllllIIIIlIIIl || llllllllllllllllIIIllllIIIIlIIII) {
                        llllllllllllllllIIIllllIIIlIIlII.visitFrame(-1, llllllllllllllllIIIllllIIIIIllII.localCount, llllllllllllllllIIIllllIIIIIllII.local, llllllllllllllllIIIllllIIIIIllII.stackCount, llllllllllllllllIIIllllIIIIIllII.stack);
                    } else {
                        llllllllllllllllIIIllllIIIlIIlII.visitFrame(llllllllllllllllIIIllllIIIIIllII.mode, llllllllllllllllIIIllllIIIIIllII.localDiff, llllllllllllllllIIIllllIIIIIllII.local, llllllllllllllllIIIllllIIIIIllII.stackCount, llllllllllllllllIIIllllIIIIIllII.stack);
                    }
                }
                if (llllllllllllllllIIIllllIIIIIllIl > 0) {
                    llllllllllllllllIIIllllIIIIIllll = llllllllllllllllIIIllllIIIIIlIIl.readFrame(llllllllllllllllIIIllllIIIIIllll, llllllllllllllllIIIllllIIIIlIIIl, llllllllllllllllIIIllllIIIIlIIII, llllllllllllllllIIIllllIIIIIllII);
                    --llllllllllllllllIIIllllIIIIIllIl;
                    continue;
                }
                llllllllllllllllIIIllllIIIIIllII = null;
            }
            int llllllllllllllllIIIllllIIIllIIll = llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI] & 0xFF;
            switch (ClassWriter.TYPE[llllllllllllllllIIIllllIIIllIIll]) {
                case 0: {
                    llllllllllllllllIIIllllIIIlIIlII.visitInsn(llllllllllllllllIIIllllIIIllIIll);
                    ++llllllllllllllllIIIllllIIIIIIllI;
                    break;
                }
                case 4: {
                    if (llllllllllllllllIIIllllIIIllIIll > 54) {
                        llllllllllllllllIIIllllIIIlIIlII.visitVarInsn(54 + ((llllllllllllllllIIIllllIIIllIIll -= 59) >> 2), llllllllllllllllIIIllllIIIllIIll & 3);
                    } else {
                        llllllllllllllllIIIllllIIIlIIlII.visitVarInsn(21 + ((llllllllllllllllIIIllllIIIllIIll -= 26) >> 2), llllllllllllllllIIIllllIIIllIIll & 3);
                    }
                    ++llllllllllllllllIIIllllIIIIIIllI;
                    break;
                }
                case 9: {
                    llllllllllllllllIIIllllIIIlIIlII.visitJumpInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readShort(llllllllllllllllIIIllllIIIIIIllI + 1)]);
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                case 10: {
                    llllllllllllllllIIIllllIIIlIIlII.visitJumpInsn(llllllllllllllllIIIllllIIIllIIll + llllllllllllllllIIIllllIIIIIlIlI, llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 1)]);
                    llllllllllllllllIIIllllIIIIIIllI += 5;
                    break;
                }
                case 18: {
                    llllllllllllllllIIIllllIIIllIIll = llllllllllllllllIIIllllIIIllIIll < 218 ? llllllllllllllllIIIllllIIIllIIll - 49 : llllllllllllllllIIIllllIIIllIIll - 20;
                    Label llllllllllllllllIIIllllIIlIIllll = llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 1)];
                    if (llllllllllllllllIIIllllIIIllIIll == 167 || llllllllllllllllIIIllllIIIllIIll == 168) {
                        llllllllllllllllIIIllllIIIlIIlII.visitJumpInsn(llllllllllllllllIIIllllIIIllIIll + 33, llllllllllllllllIIIllllIIlIIllll);
                    } else {
                        llllllllllllllllIIIllllIIIllIIll = llllllllllllllllIIIllllIIIllIIll <= 166 ? (llllllllllllllllIIIllllIIIllIIll + 1 ^ 1) - 1 : llllllllllllllllIIIllllIIIllIIll ^ 1;
                        Label llllllllllllllllIIIllllIIlIlIIII = new Label();
                        llllllllllllllllIIIllllIIIlIIlII.visitJumpInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIlIlIIII);
                        llllllllllllllllIIIllllIIIlIIlII.visitJumpInsn(200, llllllllllllllllIIIllllIIlIIllll);
                        llllllllllllllllIIIllllIIIlIIlII.visitLabel(llllllllllllllllIIIllllIIlIlIIII);
                        if (llllllllllllllllIIIllllIIIIIllll != 0 && (llllllllllllllllIIIllllIIIIIllII == null || llllllllllllllllIIIllllIIIIIllII.offset != llllllllllllllllIIIllllIIIllIlIl + 3)) {
                            llllllllllllllllIIIllllIIIlIIlII.visitFrame(256, 0, null, 0, null);
                        }
                    }
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                case 17: {
                    llllllllllllllllIIIllllIIIllIIll = llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 1] & 0xFF;
                    if (llllllllllllllllIIIllllIIIllIIll == 132) {
                        llllllllllllllllIIIllllIIIlIIlII.visitIincInsn(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 2), llllllllllllllllIIIllllIIIIIlIIl.readShort(llllllllllllllllIIIllllIIIIIIllI + 4));
                        llllllllllllllllIIIllllIIIIIIllI += 6;
                        break;
                    }
                    llllllllllllllllIIIllllIIIlIIlII.visitVarInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 2));
                    llllllllllllllllIIIllllIIIIIIllI += 4;
                    break;
                }
                case 14: {
                    llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIIIllI + 4 - (llllllllllllllllIIIllllIIIllIlIl & 3);
                    int llllllllllllllllIIIllllIIlIIllIl = llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI);
                    int llllllllllllllllIIIllllIIlIIllII = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4);
                    int llllllllllllllllIIIllllIIlIIlIll = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 8);
                    Label[] llllllllllllllllIIIllllIIlIIlIlI = new Label[llllllllllllllllIIIllllIIlIIlIll - llllllllllllllllIIIllllIIlIIllII + 1];
                    llllllllllllllllIIIllllIIIIIIllI += 12;
                    for (int llllllllllllllllIIIllllIIlIIlllI = 0; llllllllllllllllIIIllllIIlIIlllI < llllllllllllllllIIIllllIIlIIlIlI.length; ++llllllllllllllllIIIllllIIlIIlllI) {
                        llllllllllllllllIIIllllIIlIIlIlI[llllllllllllllllIIIllllIIlIIlllI] = llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI)];
                        llllllllllllllllIIIllllIIIIIIllI += 4;
                    }
                    llllllllllllllllIIIllllIIIlIIlII.visitTableSwitchInsn(llllllllllllllllIIIllllIIlIIllII, llllllllllllllllIIIllllIIlIIlIll, llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIlIIllIl], llllllllllllllllIIIllllIIlIIlIlI);
                    break;
                }
                case 15: {
                    llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIIIllI + 4 - (llllllllllllllllIIIllllIIIllIlIl & 3);
                    int llllllllllllllllIIIllllIIlIIlIII = llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI);
                    int llllllllllllllllIIIllllIIlIIIlll = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4);
                    int[] llllllllllllllllIIIllllIIlIIIllI = new int[llllllllllllllllIIIllllIIlIIIlll];
                    Label[] llllllllllllllllIIIllllIIlIIIlIl = new Label[llllllllllllllllIIIllllIIlIIIlll];
                    llllllllllllllllIIIllllIIIIIIllI += 8;
                    for (int llllllllllllllllIIIllllIIlIIlIIl = 0; llllllllllllllllIIIllllIIlIIlIIl < llllllllllllllllIIIllllIIlIIIlll; ++llllllllllllllllIIIllllIIlIIlIIl) {
                        llllllllllllllllIIIllllIIlIIIllI[llllllllllllllllIIIllllIIlIIlIIl] = llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI);
                        llllllllllllllllIIIllllIIlIIIlIl[llllllllllllllllIIIllllIIlIIlIIl] = llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIlIl + llllllllllllllllIIIllllIIIIIlIIl.readInt(llllllllllllllllIIIllllIIIIIIllI + 4)];
                        llllllllllllllllIIIllllIIIIIIllI += 8;
                    }
                    llllllllllllllllIIIllllIIIlIIlII.visitLookupSwitchInsn(llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIlIIlIII], llllllllllllllllIIIllllIIlIIIllI, llllllllllllllllIIIllllIIlIIIlIl);
                    break;
                }
                case 3: {
                    llllllllllllllllIIIllllIIIlIIlII.visitVarInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 1] & 0xFF);
                    llllllllllllllllIIIllllIIIIIIllI += 2;
                    break;
                }
                case 1: {
                    llllllllllllllllIIIllllIIIlIIlII.visitIntInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 1]);
                    llllllllllllllllIIIllllIIIIIIllI += 2;
                    break;
                }
                case 2: {
                    llllllllllllllllIIIllllIIIlIIlII.visitIntInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIIIIlIIl.readShort(llllllllllllllllIIIllllIIIIIIllI + 1));
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                case 11: {
                    llllllllllllllllIIIllllIIIlIIlII.visitLdcInsn(llllllllllllllllIIIllllIIIIIlIIl.readConst(llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 1] & 0xFF, llllllllllllllllIIIllllIIIlIIIII));
                    llllllllllllllllIIIllllIIIIIIllI += 2;
                    break;
                }
                case 12: {
                    llllllllllllllllIIIllllIIIlIIlII.visitLdcInsn(llllllllllllllllIIIllllIIIIIlIIl.readConst(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 1), llllllllllllllllIIIllllIIIlIIIII));
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                case 6: 
                case 7: {
                    int llllllllllllllllIIIllllIIlIIIlII = llllllllllllllllIIIllllIIIIIlIIl.items[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 1)];
                    boolean llllllllllllllllIIIllllIIlIIIIll = llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIlIIIlII - 1] == 11;
                    String llllllllllllllllIIIllllIIlIIIIlI = llllllllllllllllIIIllllIIIIIlIIl.readClass(llllllllllllllllIIIllllIIlIIIlII, llllllllllllllllIIIllllIIIlIIIII);
                    llllllllllllllllIIIllllIIlIIIlII = llllllllllllllllIIIllllIIIIIlIIl.items[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIlIIIlII + 2)];
                    String llllllllllllllllIIIllllIIlIIIIIl = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIlIIIlII, llllllllllllllllIIIllllIIIlIIIII);
                    String llllllllllllllllIIIllllIIlIIIIII = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIlIIIlII + 2, llllllllllllllllIIIllllIIIlIIIII);
                    if (llllllllllllllllIIIllllIIIllIIll < 182) {
                        llllllllllllllllIIIllllIIIlIIlII.visitFieldInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIlIIIIlI, llllllllllllllllIIIllllIIlIIIIIl, llllllllllllllllIIIllllIIlIIIIII);
                    } else {
                        llllllllllllllllIIIllllIIIlIIlII.visitMethodInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIlIIIIlI, llllllllllllllllIIIllllIIlIIIIIl, llllllllllllllllIIIllllIIlIIIIII, llllllllllllllllIIIllllIIlIIIIll);
                    }
                    if (llllllllllllllllIIIllllIIIllIIll == 185) {
                        llllllllllllllllIIIllllIIIIIIllI += 5;
                        break;
                    }
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                case 8: {
                    int llllllllllllllllIIIllllIIIlllllI = llllllllllllllllIIIllllIIIIIlIIl.items[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 1)];
                    int llllllllllllllllIIIllllIIIllllIl = llllllllllllllllIIIllllIIIIIIlll.bootstrapMethods[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIlllllI)];
                    Handle llllllllllllllllIIIllllIIIllllII = (Handle)llllllllllllllllIIIllllIIIIIlIIl.readConst(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIllllIl), llllllllllllllllIIIllllIIIlIIIII);
                    int llllllllllllllllIIIllllIIIlllIll = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIllllIl + 2);
                    Object[] llllllllllllllllIIIllllIIIlllIlI = new Object[llllllllllllllllIIIllllIIIlllIll];
                    llllllllllllllllIIIllllIIIllllIl += 4;
                    for (int llllllllllllllllIIIllllIIIllllll = 0; llllllllllllllllIIIllllIIIllllll < llllllllllllllllIIIllllIIIlllIll; ++llllllllllllllllIIIllllIIIllllll) {
                        llllllllllllllllIIIllllIIIlllIlI[llllllllllllllllIIIllllIIIllllll] = llllllllllllllllIIIllllIIIIIlIIl.readConst(llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIllllIl), llllllllllllllllIIIllllIIIlIIIII);
                        llllllllllllllllIIIllllIIIllllIl += 2;
                    }
                    llllllllllllllllIIIllllIIIlllllI = llllllllllllllllIIIllllIIIIIlIIl.items[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIlllllI + 2)];
                    String llllllllllllllllIIIllllIIIlllIIl = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIlllllI, llllllllllllllllIIIllllIIIlIIIII);
                    String llllllllllllllllIIIllllIIIlllIII = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIlllllI + 2, llllllllllllllllIIIllllIIIlIIIII);
                    llllllllllllllllIIIllllIIIlIIlII.visitInvokeDynamicInsn(llllllllllllllllIIIllllIIIlllIIl, llllllllllllllllIIIllllIIIlllIII, llllllllllllllllIIIllllIIIllllII, llllllllllllllllIIIllllIIIlllIlI);
                    llllllllllllllllIIIllllIIIIIIllI += 5;
                    break;
                }
                case 5: {
                    llllllllllllllllIIIllllIIIlIIlII.visitTypeInsn(llllllllllllllllIIIllllIIIllIIll, llllllllllllllllIIIllllIIIIIlIIl.readClass(llllllllllllllllIIIllllIIIIIIllI + 1, llllllllllllllllIIIllllIIIlIIIII));
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                case 13: {
                    llllllllllllllllIIIllllIIIlIIlII.visitIincInsn(llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 1] & 0xFF, llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 2]);
                    llllllllllllllllIIIllllIIIIIIllI += 3;
                    break;
                }
                default: {
                    llllllllllllllllIIIllllIIIlIIlII.visitMultiANewArrayInsn(llllllllllllllllIIIllllIIIIIlIIl.readClass(llllllllllllllllIIIllllIIIIIIllI + 1, llllllllllllllllIIIllllIIIlIIIII), llllllllllllllllIIIllllIIIlIIIIl[llllllllllllllllIIIllllIIIIIIllI + 3] & 0xFF);
                    llllllllllllllllIIIllllIIIIIIllI += 4;
                }
            }
            while (llllllllllllllllIIIllllIIIIllIIl != null && llllllllllllllllIIIllllIIIIlIlll < llllllllllllllllIIIllllIIIIllIIl.length && llllllllllllllllIIIllllIIIIlIlIl <= llllllllllllllllIIIllllIIIllIlIl) {
                if (llllllllllllllllIIIllllIIIIlIlIl == llllllllllllllllIIIllllIIIllIlIl) {
                    int llllllllllllllllIIIllllIIIllIlll = llllllllllllllllIIIllllIIIIIlIIl.readAnnotationTarget(llllllllllllllllIIIllllIIIIIIlll, llllllllllllllllIIIllllIIIIllIIl[llllllllllllllllIIIllllIIIIlIlll]);
                    llllllllllllllllIIIllllIIIIIlIIl.readAnnotationValues(llllllllllllllllIIIllllIIIllIlll + 2, llllllllllllllllIIIllllIIIlIIIII, true, llllllllllllllllIIIllllIIIlIIlII.visitInsnAnnotation(llllllllllllllllIIIllllIIIIIIlll.typeRef, llllllllllllllllIIIllllIIIIIIlll.typePath, llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIllIlll, llllllllllllllllIIIllllIIIlIIIII), true));
                }
                llllllllllllllllIIIllllIIIIlIlIl = ++llllllllllllllllIIIllllIIIIlIlll >= llllllllllllllllIIIllllIIIIllIIl.length || llllllllllllllllIIIllllIIIIIlIIl.readByte(llllllllllllllllIIIllllIIIIllIIl[llllllllllllllllIIIllllIIIIlIlll]) < 67 ? -1 : llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIllIIl[llllllllllllllllIIIllllIIIIlIlll] + 1);
            }
            while (llllllllllllllllIIIllllIIIIllIII != null && llllllllllllllllIIIllllIIIIlIllI < llllllllllllllllIIIllllIIIIllIII.length && llllllllllllllllIIIllllIIIIlIlII <= llllllllllllllllIIIllllIIIllIlIl) {
                if (llllllllllllllllIIIllllIIIIlIlII == llllllllllllllllIIIllllIIIllIlIl) {
                    int llllllllllllllllIIIllllIIIllIllI = llllllllllllllllIIIllllIIIIIlIIl.readAnnotationTarget(llllllllllllllllIIIllllIIIIIIlll, llllllllllllllllIIIllllIIIIllIII[llllllllllllllllIIIllllIIIIlIllI]);
                    llllllllllllllllIIIllllIIIIIlIIl.readAnnotationValues(llllllllllllllllIIIllllIIIllIllI + 2, llllllllllllllllIIIllllIIIlIIIII, true, llllllllllllllllIIIllllIIIlIIlII.visitInsnAnnotation(llllllllllllllllIIIllllIIIIIIlll.typeRef, llllllllllllllllIIIllllIIIIIIlll.typePath, llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIllIllI, llllllllllllllllIIIllllIIIlIIIII), false));
                }
                llllllllllllllllIIIllllIIIIlIlII = ++llllllllllllllllIIIllllIIIIlIllI >= llllllllllllllllIIIllllIIIIllIII.length || llllllllllllllllIIIllllIIIIIlIIl.readByte(llllllllllllllllIIIllllIIIIllIII[llllllllllllllllIIIllllIIIIlIllI]) < 67 ? -1 : llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIllIII[llllllllllllllllIIIllllIIIIlIllI] + 1);
            }
        }
        if (llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIIlllIl] != null) {
            llllllllllllllllIIIllllIIIlIIlII.visitLabel(llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIIlllIl]);
        }
        if ((llllllllllllllllIIIllllIIIIIIlll.flags & 2) == 0 && llllllllllllllllIIIllllIIIIlIIll != 0) {
            int[] llllllllllllllllIIIllllIIIlIlIll = null;
            if (llllllllllllllllIIIllllIIIIlIIlI != 0) {
                llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIlIIlI + 2;
                llllllllllllllllIIIllllIIIlIlIll = new int[llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIlIIlI) * 3];
                int llllllllllllllllIIIllllIIIllIIlI = llllllllllllllllIIIllllIIIlIlIll.length;
                while (llllllllllllllllIIIllllIIIllIIlI > 0) {
                    llllllllllllllllIIIllllIIIlIlIll[--llllllllllllllllIIIllllIIIllIIlI] = llllllllllllllllIIIllllIIIIIIllI + 6;
                    llllllllllllllllIIIllllIIIlIlIll[--llllllllllllllllIIIllllIIIllIIlI] = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8);
                    llllllllllllllllIIIllllIIIlIlIll[--llllllllllllllllIIIllllIIIllIIlI] = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI);
                    llllllllllllllllIIIllllIIIIIIllI += 10;
                }
            }
            llllllllllllllllIIIllllIIIIIIllI = llllllllllllllllIIIllllIIIIlIIll + 2;
            for (int llllllllllllllllIIIllllIIIlIllII = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIlIIll); llllllllllllllllIIIllllIIIlIllII > 0; --llllllllllllllllIIIllllIIIlIllII) {
                int llllllllllllllllIIIllllIIIllIIII = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI);
                int llllllllllllllllIIIllllIIIlIllll = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 2);
                int llllllllllllllllIIIllllIIIlIlllI = llllllllllllllllIIIllllIIIIIlIIl.readUnsignedShort(llllllllllllllllIIIllllIIIIIIllI + 8);
                String llllllllllllllllIIIllllIIIlIllIl = null;
                if (llllllllllllllllIIIllllIIIlIlIll != null) {
                    for (int llllllllllllllllIIIllllIIIllIIIl = 0; llllllllllllllllIIIllllIIIllIIIl < llllllllllllllllIIIllllIIIlIlIll.length; llllllllllllllllIIIllllIIIllIIIl += 3) {
                        if (llllllllllllllllIIIllllIIIlIlIll[llllllllllllllllIIIllllIIIllIIIl] != llllllllllllllllIIIllllIIIllIIII || llllllllllllllllIIIllllIIIlIlIll[llllllllllllllllIIIllllIIIllIIIl + 1] != llllllllllllllllIIIllllIIIlIlllI) continue;
                        llllllllllllllllIIIllllIIIlIllIl = llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIlIlIll[llllllllllllllllIIIllllIIIllIIIl + 2], llllllllllllllllIIIllllIIIlIIIII);
                        break;
                    }
                }
                llllllllllllllllIIIllllIIIlIIlII.visitLocalVariable(llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIIIIllI + 4, llllllllllllllllIIIllllIIIlIIIII), llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIIIIllI + 6, llllllllllllllllIIIllllIIIlIIIII), llllllllllllllllIIIllllIIIlIllIl, llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIIII], llllllllllllllllIIIllllIIIIllIlI[llllllllllllllllIIIllllIIIllIIII + llllllllllllllllIIIllllIIIlIllll], llllllllllllllllIIIllllIIIlIlllI);
                llllllllllllllllIIIllllIIIIIIllI += 10;
            }
        }
        if (llllllllllllllllIIIllllIIIIllIIl != null) {
            for (int llllllllllllllllIIIllllIIIlIlIIl = 0; llllllllllllllllIIIllllIIIlIlIIl < llllllllllllllllIIIllllIIIIllIIl.length; ++llllllllllllllllIIIllllIIIlIlIIl) {
                if (llllllllllllllllIIIllllIIIIIlIIl.readByte(llllllllllllllllIIIllllIIIIllIIl[llllllllllllllllIIIllllIIIlIlIIl]) >> 1 != 32) continue;
                int llllllllllllllllIIIllllIIIlIlIlI = llllllllllllllllIIIllllIIIIIlIIl.readAnnotationTarget(llllllllllllllllIIIllllIIIIIIlll, llllllllllllllllIIIllllIIIIllIIl[llllllllllllllllIIIllllIIIlIlIIl]);
                llllllllllllllllIIIllllIIIlIlIlI = llllllllllllllllIIIllllIIIIIlIIl.readAnnotationValues(llllllllllllllllIIIllllIIIlIlIlI + 2, llllllllllllllllIIIllllIIIlIIIII, true, llllllllllllllllIIIllllIIIlIIlII.visitLocalVariableAnnotation(llllllllllllllllIIIllllIIIIIIlll.typeRef, llllllllllllllllIIIllllIIIIIIlll.typePath, llllllllllllllllIIIllllIIIIIIlll.start, llllllllllllllllIIIllllIIIIIIlll.end, llllllllllllllllIIIllllIIIIIIlll.index, llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIlIlIlI, llllllllllllllllIIIllllIIIlIIIII), true));
            }
        }
        if (llllllllllllllllIIIllllIIIIllIII != null) {
            for (int llllllllllllllllIIIllllIIIlIIlll = 0; llllllllllllllllIIIllllIIIlIIlll < llllllllllllllllIIIllllIIIIllIII.length; ++llllllllllllllllIIIllllIIIlIIlll) {
                if (llllllllllllllllIIIllllIIIIIlIIl.readByte(llllllllllllllllIIIllllIIIIllIII[llllllllllllllllIIIllllIIIlIIlll]) >> 1 != 32) continue;
                int llllllllllllllllIIIllllIIIlIlIII = llllllllllllllllIIIllllIIIIIlIIl.readAnnotationTarget(llllllllllllllllIIIllllIIIIIIlll, llllllllllllllllIIIllllIIIIllIII[llllllllllllllllIIIllllIIIlIIlll]);
                llllllllllllllllIIIllllIIIlIlIII = llllllllllllllllIIIllllIIIIIlIIl.readAnnotationValues(llllllllllllllllIIIllllIIIlIlIII + 2, llllllllllllllllIIIllllIIIlIIIII, true, llllllllllllllllIIIllllIIIlIIlII.visitLocalVariableAnnotation(llllllllllllllllIIIllllIIIIIIlll.typeRef, llllllllllllllllIIIllllIIIIIIlll.typePath, llllllllllllllllIIIllllIIIIIIlll.start, llllllllllllllllIIIllllIIIIIIlll.end, llllllllllllllllIIIllllIIIIIIlll.index, llllllllllllllllIIIllllIIIIIlIIl.readUTF8(llllllllllllllllIIIllllIIIlIlIII, llllllllllllllllIIIllllIIIlIIIII), false));
            }
        }
        while (llllllllllllllllIIIllllIIIIIlIll != null) {
            Attribute llllllllllllllllIIIllllIIIlIIllI = llllllllllllllllIIIllllIIIIIlIll.next;
            llllllllllllllllIIIllllIIIIIlIll.next = null;
            llllllllllllllllIIIllllIIIlIIlII.visitAttribute(llllllllllllllllIIIllllIIIIIlIll);
            llllllllllllllllIIIllllIIIIIlIll = llllllllllllllllIIIllllIIIlIIllI;
        }
        llllllllllllllllIIIllllIIIlIIlII.visitMaxs(llllllllllllllllIIIllllIIIIlllll, llllllllllllllllIIIllllIIIIllllI);
    }

    public long readLong(int llllllllllllllllIIIllIlIlllIIlII) {
        ClassReader llllllllllllllllIIIllIlIlllIlIIl;
        long llllllllllllllllIIIllIlIlllIIlll = llllllllllllllllIIIllIlIlllIlIIl.readInt(llllllllllllllllIIIllIlIlllIIlII);
        long llllllllllllllllIIIllIlIlllIIllI = (long)llllllllllllllllIIIllIlIlllIlIIl.readInt(llllllllllllllllIIIllIlIlllIIlII + 4) & 0xFFFFFFFFL;
        return llllllllllllllllIIIllIlIlllIIlll << 32 | llllllllllllllllIIIllIlIlllIIllI;
    }

    public ClassReader(InputStream llllllllllllllllIIIlllllllIIllIl) throws IOException {
        llllllllllllllllIIIlllllllIlIIll(ClassReader.readClass(llllllllllllllllIIIlllllllIIllIl, false));
        ClassReader llllllllllllllllIIIlllllllIlIIll;
    }

    private int readAnnotationValues(int llllllllllllllllIIIlllIIllIIlIII, char[] llllllllllllllllIIIlllIIllIIIllI, boolean llllllllllllllllIIIlllIIllIIIlII, AnnotationVisitor llllllllllllllllIIIlllIIlIlllIll) {
        ClassReader llllllllllllllllIIIlllIIlIllllll;
        int llllllllllllllllIIIlllIIllIIIIII = llllllllllllllllIIIlllIIlIllllll.readUnsignedShort(llllllllllllllllIIIlllIIllIIlIII);
        llllllllllllllllIIIlllIIllIIlIII += 2;
        if (llllllllllllllllIIIlllIIllIIIlII) {
            while (llllllllllllllllIIIlllIIllIIIIII > 0) {
                llllllllllllllllIIIlllIIllIIlIII = llllllllllllllllIIIlllIIlIllllll.readAnnotationValue(llllllllllllllllIIIlllIIllIIlIII + 2, llllllllllllllllIIIlllIIllIIIllI, llllllllllllllllIIIlllIIlIllllll.readUTF8(llllllllllllllllIIIlllIIllIIlIII, llllllllllllllllIIIlllIIllIIIllI), llllllllllllllllIIIlllIIlIlllIll);
                --llllllllllllllllIIIlllIIllIIIIII;
            }
        } else {
            while (llllllllllllllllIIIlllIIllIIIIII > 0) {
                llllllllllllllllIIIlllIIllIIlIII = llllllllllllllllIIIlllIIlIllllll.readAnnotationValue(llllllllllllllllIIIlllIIllIIlIII, llllllllllllllllIIIlllIIllIIIllI, null, llllllllllllllllIIIlllIIlIlllIll);
                --llllllllllllllllIIIlllIIllIIIIII;
            }
        }
        if (llllllllllllllllIIIlllIIlIlllIll != null) {
            llllllllllllllllIIIlllIIlIlllIll.visitEnd();
        }
        return llllllllllllllllIIIlllIIllIIlIII;
    }

    private int getAttributes() {
        ClassReader llllllllllllllllIIIllIllIlIllIIl;
        int llllllllllllllllIIIllIllIlIllIlI = llllllllllllllllIIIllIllIlIllIIl.header + 8 + llllllllllllllllIIIllIllIlIllIIl.readUnsignedShort(llllllllllllllllIIIllIllIlIllIIl.header + 6) * 2;
        for (int llllllllllllllllIIIllIllIlIllllI = llllllllllllllllIIIllIllIlIllIIl.readUnsignedShort(llllllllllllllllIIIllIllIlIllIlI); llllllllllllllllIIIllIllIlIllllI > 0; --llllllllllllllllIIIllIllIlIllllI) {
            for (int llllllllllllllllIIIllIllIlIlllll = llllllllllllllllIIIllIllIlIllIIl.readUnsignedShort(llllllllllllllllIIIllIllIlIllIlI + 8); llllllllllllllllIIIllIllIlIlllll > 0; --llllllllllllllllIIIllIllIlIlllll) {
                llllllllllllllllIIIllIllIlIllIlI += 6 + llllllllllllllllIIIllIllIlIllIIl.readInt(llllllllllllllllIIIllIllIlIllIlI + 12);
            }
            llllllllllllllllIIIllIllIlIllIlI += 8;
        }
        for (int llllllllllllllllIIIllIllIlIlllII = llllllllllllllllIIIllIllIlIllIIl.readUnsignedShort(llllllllllllllllIIIllIllIlIllIlI += 2); llllllllllllllllIIIllIllIlIlllII > 0; --llllllllllllllllIIIllIllIlIlllII) {
            for (int llllllllllllllllIIIllIllIlIlllIl = llllllllllllllllIIIllIllIlIllIIl.readUnsignedShort(llllllllllllllllIIIllIllIlIllIlI + 8); llllllllllllllllIIIllIllIlIlllIl > 0; --llllllllllllllllIIIllIllIlIlllIl) {
                llllllllllllllllIIIllIllIlIllIlI += 6 + llllllllllllllllIIIllIllIlIllIIl.readInt(llllllllllllllllIIIllIllIlIllIlI + 12);
            }
            llllllllllllllllIIIllIllIlIllIlI += 8;
        }
        return llllllllllllllllIIIllIllIlIllIlI + 2;
    }

    public int readInt(int llllllllllllllllIIIllIlIllllIIlI) {
        ClassReader llllllllllllllllIIIllIlIllllIIll;
        byte[] llllllllllllllllIIIllIlIllllIIIl = llllllllllllllllIIIllIlIllllIIll.b;
        return (llllllllllllllllIIIllIlIllllIIIl[llllllllllllllllIIIllIlIllllIIlI] & 0xFF) << 24 | (llllllllllllllllIIIllIlIllllIIIl[llllllllllllllllIIIllIlIllllIIlI + 1] & 0xFF) << 16 | (llllllllllllllllIIIllIlIllllIIIl[llllllllllllllllIIIllIlIllllIIlI + 2] & 0xFF) << 8 | llllllllllllllllIIIllIlIllllIIIl[llllllllllllllllIIIllIlIllllIIlI + 3] & 0xFF;
    }

    private Attribute readAttribute(Attribute[] llllllllllllllllIIIllIllIlIIIIlI, String llllllllllllllllIIIllIllIlIIIIIl, int llllllllllllllllIIIllIllIlIIIIII, int llllllllllllllllIIIllIllIlIIIlll, char[] llllllllllllllllIIIllIllIIlllllI, int llllllllllllllllIIIllIllIIllllII, Label[] llllllllllllllllIIIllIllIlIIIlII) {
        ClassReader llllllllllllllllIIIllIllIlIIIIll;
        for (int llllllllllllllllIIIllIllIlIIllII = 0; llllllllllllllllIIIllIllIlIIllII < llllllllllllllllIIIllIllIlIIIIlI.length; ++llllllllllllllllIIIllIllIlIIllII) {
            if (!llllllllllllllllIIIllIllIlIIIIlI[llllllllllllllllIIIllIllIlIIllII].type.equals(llllllllllllllllIIIllIllIlIIIIIl)) continue;
            return llllllllllllllllIIIllIllIlIIIIlI[llllllllllllllllIIIllIllIlIIllII].read(llllllllllllllllIIIllIllIlIIIIll, llllllllllllllllIIIllIllIlIIIIII, llllllllllllllllIIIllIllIlIIIlll, llllllllllllllllIIIllIllIIlllllI, llllllllllllllllIIIllIllIIllllII, llllllllllllllllIIIllIllIlIIIlII);
        }
        return new Attribute(llllllllllllllllIIIllIllIlIIIIIl).read(llllllllllllllllIIIllIllIlIIIIll, llllllllllllllllIIIllIllIlIIIIII, llllllllllllllllIIIllIllIlIIIlll, null, -1, null);
    }

    private void readParameterAnnotations(MethodVisitor llllllllllllllllIIIlllIIllllllII, Context llllllllllllllllIIIlllIIlllllIlI, int llllllllllllllllIIIlllIIlllIlIlI, boolean llllllllllllllllIIIlllIIllllIlll) {
        int llllllllllllllllIIIlllIIllllIlIl;
        ClassReader llllllllllllllllIIIlllIIllllllIl;
        int llllllllllllllllIIIlllIIllllIIll = llllllllllllllllIIIlllIIllllllIl.b[llllllllllllllllIIIlllIIlllIlIlI++] & 0xFF;
        int llllllllllllllllIIIlllIIllllIIIl = Type.getArgumentTypes(llllllllllllllllIIIlllIIlllllIlI.desc).length - llllllllllllllllIIIlllIIllllIIll;
        for (llllllllllllllllIIIlllIIllllIlIl = 0; llllllllllllllllIIIlllIIllllIlIl < llllllllllllllllIIIlllIIllllIIIl; ++llllllllllllllllIIIlllIIllllIlIl) {
            AnnotationVisitor llllllllllllllllIIIlllIlIIIIIIIl = llllllllllllllllIIIlllIIllllllII.visitParameterAnnotation(llllllllllllllllIIIlllIIllllIlIl, "Ljava/lang/Synthetic;", false);
            if (llllllllllllllllIIIlllIlIIIIIIIl == null) continue;
            llllllllllllllllIIIlllIlIIIIIIIl.visitEnd();
        }
        char[] llllllllllllllllIIIlllIIlllIllll = llllllllllllllllIIIlllIIlllllIlI.buffer;
        while (llllllllllllllllIIIlllIIllllIlIl < llllllllllllllllIIIlllIIllllIIll + llllllllllllllllIIIlllIIllllIIIl) {
            int llllllllllllllllIIIlllIIlllllllI = llllllllllllllllIIIlllIIllllllIl.readUnsignedShort(llllllllllllllllIIIlllIIlllIlIlI);
            llllllllllllllllIIIlllIIlllIlIlI += 2;
            while (llllllllllllllllIIIlllIIlllllllI > 0) {
                AnnotationVisitor llllllllllllllllIIIlllIIllllllll = llllllllllllllllIIIlllIIllllllII.visitParameterAnnotation(llllllllllllllllIIIlllIIllllIlIl, llllllllllllllllIIIlllIIllllllIl.readUTF8(llllllllllllllllIIIlllIIlllIlIlI, llllllllllllllllIIIlllIIlllIllll), llllllllllllllllIIIlllIIllllIlll);
                llllllllllllllllIIIlllIIlllIlIlI = llllllllllllllllIIIlllIIllllllIl.readAnnotationValues(llllllllllllllllIIIlllIIlllIlIlI + 2, llllllllllllllllIIIlllIIlllIllll, true, llllllllllllllllIIIlllIIllllllll);
                --llllllllllllllllIIIlllIIlllllllI;
            }
            ++llllllllllllllllIIIlllIIllllIlIl;
        }
    }

    public int getMaxStringLength() {
        ClassReader llllllllllllllllIIIllIllIIlIIIlI;
        return llllllllllllllllIIIllIllIIlIIIlI.maxStringLength;
    }

    protected Label readLabel(int llllllllllllllllIIIllIllIllIIlIl, Label[] llllllllllllllllIIIllIllIllIIlII) {
        if (llllllllllllllllIIIllIllIllIIlII[llllllllllllllllIIIllIllIllIIlIl] == null) {
            llllllllllllllllIIIllIllIllIIlII[llllllllllllllllIIIllIllIllIIlIl] = new Label();
        }
        return llllllllllllllllIIIllIllIllIIlII[llllllllllllllllIIIllIllIllIIlIl];
    }

    public int getItemCount() {
        ClassReader llllllllllllllllIIIllIllIIllIIlI;
        return llllllllllllllllIIIllIllIIllIIlI.items.length;
    }

    public Object readConst(int llllllllllllllllIIIllIlIlIIlIlII, char[] llllllllllllllllIIIllIlIlIIlIlll) {
        ClassReader llllllllllllllllIIIllIlIlIIlIlIl;
        int llllllllllllllllIIIllIlIlIIlIllI = llllllllllllllllIIIllIlIlIIlIlIl.items[llllllllllllllllIIIllIlIlIIlIlII];
        switch (llllllllllllllllIIIllIlIlIIlIlIl.b[llllllllllllllllIIIllIlIlIIlIllI - 1]) {
            case 3: {
                return llllllllllllllllIIIllIlIlIIlIlIl.readInt(llllllllllllllllIIIllIlIlIIlIllI);
            }
            case 4: {
                return Float.valueOf(Float.intBitsToFloat(llllllllllllllllIIIllIlIlIIlIlIl.readInt(llllllllllllllllIIIllIlIlIIlIllI)));
            }
            case 5: {
                return llllllllllllllllIIIllIlIlIIlIlIl.readLong(llllllllllllllllIIIllIlIlIIlIllI);
            }
            case 6: {
                return Double.longBitsToDouble(llllllllllllllllIIIllIlIlIIlIlIl.readLong(llllllllllllllllIIIllIlIlIIlIllI));
            }
            case 7: {
                return Type.getObjectType(llllllllllllllllIIIllIlIlIIlIlIl.readUTF8(llllllllllllllllIIIllIlIlIIlIllI, llllllllllllllllIIIllIlIlIIlIlll));
            }
            case 8: {
                return llllllllllllllllIIIllIlIlIIlIlIl.readUTF8(llllllllllllllllIIIllIlIlIIlIllI, llllllllllllllllIIIllIlIlIIlIlll);
            }
            case 16: {
                return Type.getMethodType(llllllllllllllllIIIllIlIlIIlIlIl.readUTF8(llllllllllllllllIIIllIlIlIIlIllI, llllllllllllllllIIIllIlIlIIlIlll));
            }
        }
        int llllllllllllllllIIIllIlIlIlIIIII = llllllllllllllllIIIllIlIlIIlIlIl.readByte(llllllllllllllllIIIllIlIlIIlIllI);
        int[] llllllllllllllllIIIllIlIlIIlllll = llllllllllllllllIIIllIlIlIIlIlIl.items;
        int llllllllllllllllIIIllIlIlIIllllI = llllllllllllllllIIIllIlIlIIlllll[llllllllllllllllIIIllIlIlIIlIlIl.readUnsignedShort(llllllllllllllllIIIllIlIlIIlIllI + 1)];
        boolean llllllllllllllllIIIllIlIlIIlllIl = llllllllllllllllIIIllIlIlIIlIlIl.b[llllllllllllllllIIIllIlIlIIllllI - 1] == 11;
        String llllllllllllllllIIIllIlIlIIlllII = llllllllllllllllIIIllIlIlIIlIlIl.readClass(llllllllllllllllIIIllIlIlIIllllI, llllllllllllllllIIIllIlIlIIlIlll);
        llllllllllllllllIIIllIlIlIIllllI = llllllllllllllllIIIllIlIlIIlllll[llllllllllllllllIIIllIlIlIIlIlIl.readUnsignedShort(llllllllllllllllIIIllIlIlIIllllI + 2)];
        String llllllllllllllllIIIllIlIlIIllIll = llllllllllllllllIIIllIlIlIIlIlIl.readUTF8(llllllllllllllllIIIllIlIlIIllllI, llllllllllllllllIIIllIlIlIIlIlll);
        String llllllllllllllllIIIllIlIlIIllIlI = llllllllllllllllIIIllIlIlIIlIlIl.readUTF8(llllllllllllllllIIIllIlIlIIllllI + 2, llllllllllllllllIIIllIlIlIIlIlll);
        return new Handle(llllllllllllllllIIIllIlIlIlIIIII, llllllllllllllllIIIllIlIlIIlllII, llllllllllllllllIIIllIlIlIIllIll, llllllllllllllllIIIllIlIlIIllIlI, llllllllllllllllIIIllIlIlIIlllIl);
    }

    private int readMethod(ClassVisitor llllllllllllllllIIIllllIlIllIlll, Context llllllllllllllllIIIllllIlIllIllI, int llllllllllllllllIIIllllIlIlIIIIl) {
        ClassReader llllllllllllllllIIIllllIlIlIIlII;
        char[] llllllllllllllllIIIllllIlIllIlII = llllllllllllllllIIIllllIlIllIllI.buffer;
        llllllllllllllllIIIllllIlIllIllI.access = llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIIIIl);
        llllllllllllllllIIIllllIlIllIllI.name = llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIlIIIIl + 2, llllllllllllllllIIIllllIlIllIlII);
        llllllllllllllllIIIllllIlIllIllI.desc = llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIlIIIIl + 4, llllllllllllllllIIIllllIlIllIlII);
        llllllllllllllllIIIllllIlIlIIIIl += 6;
        int llllllllllllllllIIIllllIlIllIIll = 0;
        int llllllllllllllllIIIllllIlIllIIlI = 0;
        String[] llllllllllllllllIIIllllIlIllIIIl = null;
        String llllllllllllllllIIIllllIlIllIIII = null;
        int llllllllllllllllIIIllllIlIlIllll = 0;
        int llllllllllllllllIIIllllIlIlIlllI = 0;
        int llllllllllllllllIIIllllIlIlIllIl = 0;
        int llllllllllllllllIIIllllIlIlIllII = 0;
        int llllllllllllllllIIIllllIlIlIlIll = 0;
        int llllllllllllllllIIIllllIlIlIlIlI = 0;
        int llllllllllllllllIIIllllIlIlIlIIl = 0;
        int llllllllllllllllIIIllllIlIlIlIII = 0;
        int llllllllllllllllIIIllllIlIlIIlll = llllllllllllllllIIIllllIlIlIIIIl;
        Attribute llllllllllllllllIIIllllIlIlIIllI = null;
        for (int llllllllllllllllIIIllllIllIIlIII = llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIIIIl); llllllllllllllllIIIllllIllIIlIII > 0; --llllllllllllllllIIIllllIllIIlIII) {
            String llllllllllllllllIIIllllIllIIlIIl = llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIlIIIIl + 2, llllllllllllllllIIIllllIlIllIlII);
            if ("Code".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                if ((llllllllllllllllIIIllllIlIllIllI.flags & 1) == 0) {
                    llllllllllllllllIIIllllIlIllIIll = llllllllllllllllIIIllllIlIlIIIIl + 8;
                }
            } else if ("Exceptions".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIllIIIl = new String[llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIIIIl + 8)];
                llllllllllllllllIIIllllIlIllIIlI = llllllllllllllllIIIllllIlIlIIIIl + 10;
                for (int llllllllllllllllIIIllllIllIIlIll = 0; llllllllllllllllIIIllllIllIIlIll < llllllllllllllllIIIllllIlIllIIIl.length; ++llllllllllllllllIIIllllIllIIlIll) {
                    llllllllllllllllIIIllllIlIllIIIl[llllllllllllllllIIIllllIllIIlIll] = llllllllllllllllIIIllllIlIlIIlII.readClass(llllllllllllllllIIIllllIlIllIIlI, llllllllllllllllIIIllllIlIllIlII);
                    llllllllllllllllIIIllllIlIllIIlI += 2;
                }
            } else if ("Signature".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIllIIII = llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIlIIIIl + 8, llllllllllllllllIIIllllIlIllIlII);
            } else if ("Deprecated".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIllIllI.access |= 0x20000;
            } else if ("RuntimeVisibleAnnotations".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIlllI = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIllII = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("AnnotationDefault".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIlIlI = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("Synthetic".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIllIllI.access |= 0x41000;
            } else if ("RuntimeInvisibleAnnotations".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIllIl = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIlIll = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("RuntimeVisibleParameterAnnotations".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIlIIl = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("RuntimeInvisibleParameterAnnotations".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIlIII = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else if ("MethodParameters".equals(llllllllllllllllIIIllllIllIIlIIl)) {
                llllllllllllllllIIIllllIlIlIllll = llllllllllllllllIIIllllIlIlIIIIl + 8;
            } else {
                Attribute llllllllllllllllIIIllllIllIIlIlI = llllllllllllllllIIIllllIlIlIIlII.readAttribute(llllllllllllllllIIIllllIlIllIllI.attrs, llllllllllllllllIIIllllIllIIlIIl, llllllllllllllllIIIllllIlIlIIIIl + 8, llllllllllllllllIIIllllIlIlIIlII.readInt(llllllllllllllllIIIllllIlIlIIIIl + 4), llllllllllllllllIIIllllIlIllIlII, -1, null);
                if (llllllllllllllllIIIllllIllIIlIlI != null) {
                    llllllllllllllllIIIllllIllIIlIlI.next = llllllllllllllllIIIllllIlIlIIllI;
                    llllllllllllllllIIIllllIlIlIIllI = llllllllllllllllIIIllllIllIIlIlI;
                }
            }
            llllllllllllllllIIIllllIlIlIIIIl += 6 + llllllllllllllllIIIllllIlIlIIlII.readInt(llllllllllllllllIIIllllIlIlIIIIl + 4);
        }
        llllllllllllllllIIIllllIlIlIIIIl += 2;
        MethodVisitor llllllllllllllllIIIllllIlIlIIlIl = llllllllllllllllIIIllllIlIllIlll.visitMethod(llllllllllllllllIIIllllIlIllIllI.access, llllllllllllllllIIIllllIlIllIllI.name, llllllllllllllllIIIllllIlIllIllI.desc, llllllllllllllllIIIllllIlIllIIII, llllllllllllllllIIIllllIlIllIIIl);
        if (llllllllllllllllIIIllllIlIlIIlIl == null) {
            return llllllllllllllllIIIllllIlIlIIIIl;
        }
        if (llllllllllllllllIIIllllIlIlIIlIl instanceof MethodWriter) {
            MethodWriter llllllllllllllllIIIllllIllIIIlIl = (MethodWriter)llllllllllllllllIIIllllIlIlIIlIl;
            if (llllllllllllllllIIIllllIllIIIlIl.cw.cr == llllllllllllllllIIIllllIlIlIIlII && llllllllllllllllIIIllllIlIllIIII == llllllllllllllllIIIllllIllIIIlIl.signature) {
                boolean llllllllllllllllIIIllllIllIIIllI = false;
                if (llllllllllllllllIIIllllIlIllIIIl == null) {
                    llllllllllllllllIIIllllIllIIIllI = llllllllllllllllIIIllllIllIIIlIl.exceptionCount == 0;
                } else if (llllllllllllllllIIIllllIlIllIIIl.length == llllllllllllllllIIIllllIllIIIlIl.exceptionCount) {
                    llllllllllllllllIIIllllIllIIIllI = true;
                    for (int llllllllllllllllIIIllllIllIIIlll = llllllllllllllllIIIllllIlIllIIIl.length - 1; llllllllllllllllIIIllllIllIIIlll >= 0; --llllllllllllllllIIIllllIllIIIlll) {
                        if (llllllllllllllllIIIllllIllIIIlIl.exceptions[llllllllllllllllIIIllllIllIIIlll] == llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIllIIlI -= 2)) continue;
                        llllllllllllllllIIIllllIllIIIllI = false;
                        break;
                    }
                }
                if (llllllllllllllllIIIllllIllIIIllI) {
                    llllllllllllllllIIIllllIllIIIlIl.classReaderOffset = llllllllllllllllIIIllllIlIlIIlll;
                    llllllllllllllllIIIllllIllIIIlIl.classReaderLength = llllllllllllllllIIIllllIlIlIIIIl - llllllllllllllllIIIllllIlIlIIlll;
                    return llllllllllllllllIIIllllIlIlIIIIl;
                }
            }
        }
        if (llllllllllllllllIIIllllIlIlIllll != 0) {
            int llllllllllllllllIIIllllIllIIIlII = llllllllllllllllIIIllllIlIlIIlII.b[llllllllllllllllIIIllllIlIlIllll] & 0xFF;
            int llllllllllllllllIIIllllIllIIIIll = llllllllllllllllIIIllllIlIlIllll + 1;
            while (llllllllllllllllIIIllllIllIIIlII > 0) {
                llllllllllllllllIIIllllIlIlIIlIl.visitParameter(llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIllIIIIll, llllllllllllllllIIIllllIlIllIlII), llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIllIIIIll + 2));
                --llllllllllllllllIIIllllIllIIIlII;
                llllllllllllllllIIIllllIllIIIIll += 4;
            }
        }
        if (llllllllllllllllIIIllllIlIlIlIlI != 0) {
            AnnotationVisitor llllllllllllllllIIIllllIllIIIIlI = llllllllllllllllIIIllllIlIlIIlIl.visitAnnotationDefault();
            llllllllllllllllIIIllllIlIlIIlII.readAnnotationValue(llllllllllllllllIIIllllIlIlIlIlI, llllllllllllllllIIIllllIlIllIlII, null, llllllllllllllllIIIllllIllIIIIlI);
            if (llllllllllllllllIIIllllIllIIIIlI != null) {
                llllllllllllllllIIIllllIllIIIIlI.visitEnd();
            }
        }
        if (llllllllllllllllIIIllllIlIlIlllI != 0) {
            int llllllllllllllllIIIllllIllIIIIII = llllllllllllllllIIIllllIlIlIlllI + 2;
            for (int llllllllllllllllIIIllllIllIIIIIl = llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIlllI); llllllllllllllllIIIllllIllIIIIIl > 0; --llllllllllllllllIIIllllIllIIIIIl) {
                llllllllllllllllIIIllllIllIIIIII = llllllllllllllllIIIllllIlIlIIlII.readAnnotationValues(llllllllllllllllIIIllllIllIIIIII + 2, llllllllllllllllIIIllllIlIllIlII, true, llllllllllllllllIIIllllIlIlIIlIl.visitAnnotation(llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIllIIIIII, llllllllllllllllIIIllllIlIllIlII), true));
            }
        }
        if (llllllllllllllllIIIllllIlIlIllIl != 0) {
            int llllllllllllllllIIIllllIlIlllllI = llllllllllllllllIIIllllIlIlIllIl + 2;
            for (int llllllllllllllllIIIllllIlIllllll = llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIllIl); llllllllllllllllIIIllllIlIllllll > 0; --llllllllllllllllIIIllllIlIllllll) {
                llllllllllllllllIIIllllIlIlllllI = llllllllllllllllIIIllllIlIlIIlII.readAnnotationValues(llllllllllllllllIIIllllIlIlllllI + 2, llllllllllllllllIIIllllIlIllIlII, true, llllllllllllllllIIIllllIlIlIIlIl.visitAnnotation(llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIlllllI, llllllllllllllllIIIllllIlIllIlII), false));
            }
        }
        if (llllllllllllllllIIIllllIlIlIllII != 0) {
            int llllllllllllllllIIIllllIlIllllII = llllllllllllllllIIIllllIlIlIllII + 2;
            for (int llllllllllllllllIIIllllIlIllllIl = llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIllII); llllllllllllllllIIIllllIlIllllIl > 0; --llllllllllllllllIIIllllIlIllllIl) {
                llllllllllllllllIIIllllIlIllllII = llllllllllllllllIIIllllIlIlIIlII.readAnnotationTarget(llllllllllllllllIIIllllIlIllIllI, llllllllllllllllIIIllllIlIllllII);
                llllllllllllllllIIIllllIlIllllII = llllllllllllllllIIIllllIlIlIIlII.readAnnotationValues(llllllllllllllllIIIllllIlIllllII + 2, llllllllllllllllIIIllllIlIllIlII, true, llllllllllllllllIIIllllIlIlIIlIl.visitTypeAnnotation(llllllllllllllllIIIllllIlIllIllI.typeRef, llllllllllllllllIIIllllIlIllIllI.typePath, llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIllllII, llllllllllllllllIIIllllIlIllIlII), true));
            }
        }
        if (llllllllllllllllIIIllllIlIlIlIll != 0) {
            int llllllllllllllllIIIllllIlIlllIlI = llllllllllllllllIIIllllIlIlIlIll + 2;
            for (int llllllllllllllllIIIllllIlIlllIll = llllllllllllllllIIIllllIlIlIIlII.readUnsignedShort(llllllllllllllllIIIllllIlIlIlIll); llllllllllllllllIIIllllIlIlllIll > 0; --llllllllllllllllIIIllllIlIlllIll) {
                llllllllllllllllIIIllllIlIlllIlI = llllllllllllllllIIIllllIlIlIIlII.readAnnotationTarget(llllllllllllllllIIIllllIlIllIllI, llllllllllllllllIIIllllIlIlllIlI);
                llllllllllllllllIIIllllIlIlllIlI = llllllllllllllllIIIllllIlIlIIlII.readAnnotationValues(llllllllllllllllIIIllllIlIlllIlI + 2, llllllllllllllllIIIllllIlIllIlII, true, llllllllllllllllIIIllllIlIlIIlIl.visitTypeAnnotation(llllllllllllllllIIIllllIlIllIllI.typeRef, llllllllllllllllIIIllllIlIllIllI.typePath, llllllllllllllllIIIllllIlIlIIlII.readUTF8(llllllllllllllllIIIllllIlIlllIlI, llllllllllllllllIIIllllIlIllIlII), false));
            }
        }
        if (llllllllllllllllIIIllllIlIlIlIIl != 0) {
            llllllllllllllllIIIllllIlIlIIlII.readParameterAnnotations(llllllllllllllllIIIllllIlIlIIlIl, llllllllllllllllIIIllllIlIllIllI, llllllllllllllllIIIllllIlIlIlIIl, true);
        }
        if (llllllllllllllllIIIllllIlIlIlIII != 0) {
            llllllllllllllllIIIllllIlIlIIlII.readParameterAnnotations(llllllllllllllllIIIllllIlIlIIlIl, llllllllllllllllIIIllllIlIllIllI, llllllllllllllllIIIllllIlIlIlIII, false);
        }
        while (llllllllllllllllIIIllllIlIlIIllI != null) {
            Attribute llllllllllllllllIIIllllIlIlllIIl = llllllllllllllllIIIllllIlIlIIllI.next;
            llllllllllllllllIIIllllIlIlIIllI.next = null;
            llllllllllllllllIIIllllIlIlIIlIl.visitAttribute(llllllllllllllllIIIllllIlIlIIllI);
            llllllllllllllllIIIllllIlIlIIllI = llllllllllllllllIIIllllIlIlllIIl;
        }
        if (llllllllllllllllIIIllllIlIllIIll != 0) {
            llllllllllllllllIIIllllIlIlIIlIl.visitCode();
            llllllllllllllllIIIllllIlIlIIlII.readCode(llllllllllllllllIIIllllIlIlIIlIl, llllllllllllllllIIIllllIlIllIllI, llllllllllllllllIIIllllIlIllIIll);
        }
        llllllllllllllllIIIllllIlIlIIlIl.visitEnd();
        return llllllllllllllllIIIllllIlIlIIIIl;
    }

    public void accept(ClassVisitor llllllllllllllllIIIllllllIIIlIlI, int llllllllllllllllIIIllllllIIIllII) {
        ClassReader llllllllllllllllIIIllllllIIIlIll;
        llllllllllllllllIIIllllllIIIlIll.accept(llllllllllllllllIIIllllllIIIlIlI, new Attribute[0], llllllllllllllllIIIllllllIIIllII);
    }

    private String readUTF(int llllllllllllllllIIIllIlIlIllllIl, int llllllllllllllllIIIllIlIllIIIlIl, char[] llllllllllllllllIIIllIlIllIIIlII) {
        ClassReader llllllllllllllllIIIllIlIllIIIlll;
        int llllllllllllllllIIIllIlIllIIIIll = llllllllllllllllIIIllIlIlIllllIl + llllllllllllllllIIIllIlIllIIIlIl;
        byte[] llllllllllllllllIIIllIlIllIIIIlI = llllllllllllllllIIIllIlIllIIIlll.b;
        int llllllllllllllllIIIllIlIllIIIIIl = 0;
        int llllllllllllllllIIIllIlIllIIIIII = 0;
        int llllllllllllllllIIIllIlIlIllllll = 0;
        while (llllllllllllllllIIIllIlIlIllllIl < llllllllllllllllIIIllIlIllIIIIll) {
            int llllllllllllllllIIIllIlIllIIlIII = llllllllllllllllIIIllIlIllIIIIlI[llllllllllllllllIIIllIlIlIllllIl++];
            switch (llllllllllllllllIIIllIlIllIIIIII) {
                case 0: {
                    if ((llllllllllllllllIIIllIlIllIIlIII &= 0xFF) < 128) {
                        llllllllllllllllIIIllIlIllIIIlII[llllllllllllllllIIIllIlIllIIIIIl++] = (char)llllllllllllllllIIIllIlIllIIlIII;
                        break;
                    }
                    if (llllllllllllllllIIIllIlIllIIlIII < 224 && llllllllllllllllIIIllIlIllIIlIII > 191) {
                        llllllllllllllllIIIllIlIlIllllll = (char)(llllllllllllllllIIIllIlIllIIlIII & 0x1F);
                        llllllllllllllllIIIllIlIllIIIIII = 1;
                        break;
                    }
                    llllllllllllllllIIIllIlIlIllllll = (char)(llllllllllllllllIIIllIlIllIIlIII & 0xF);
                    llllllllllllllllIIIllIlIllIIIIII = 2;
                    break;
                }
                case 1: {
                    llllllllllllllllIIIllIlIllIIIlII[llllllllllllllllIIIllIlIllIIIIIl++] = (char)(llllllllllllllllIIIllIlIlIllllll << 6 | llllllllllllllllIIIllIlIllIIlIII & 0x3F);
                    llllllllllllllllIIIllIlIllIIIIII = 0;
                    break;
                }
                case 2: {
                    llllllllllllllllIIIllIlIlIllllll = (char)(llllllllllllllllIIIllIlIlIllllll << 6 | llllllllllllllllIIIllIlIllIIlIII & 0x3F);
                    llllllllllllllllIIIllIlIllIIIIII = 1;
                }
            }
        }
        return new String(llllllllllllllllIIIllIlIllIIIlII, 0, llllllllllllllllIIIllIlIllIIIIIl);
    }

    public String getSuperName() {
        ClassReader llllllllllllllllIIlIIIIIIlIIlllI;
        return llllllllllllllllIIlIIIIIIlIIlllI.readClass(llllllllllllllllIIlIIIIIIlIIlllI.header + 4, new char[llllllllllllllllIIlIIIIIIlIIlllI.maxStringLength]);
    }

    public String readClass(int llllllllllllllllIIIllIlIlIllIIII, char[] llllllllllllllllIIIllIlIlIlIllll) {
        ClassReader llllllllllllllllIIIllIlIlIllIIIl;
        return llllllllllllllllIIIllIlIlIllIIIl.readUTF8(llllllllllllllllIIIllIlIlIllIIIl.items[llllllllllllllllIIIllIlIlIllIIIl.readUnsignedShort(llllllllllllllllIIIllIlIlIllIIII)], llllllllllllllllIIIllIlIlIlIllll);
    }

    public short readShort(int llllllllllllllllIIIllIlIlllllIll) {
        ClassReader llllllllllllllllIIIllIlIlllllIIl;
        byte[] llllllllllllllllIIIllIlIlllllIlI = llllllllllllllllIIIllIlIlllllIIl.b;
        return (short)((llllllllllllllllIIIllIlIlllllIlI[llllllllllllllllIIIllIlIlllllIll] & 0xFF) << 8 | llllllllllllllllIIIllIlIlllllIlI[llllllllllllllllIIIllIlIlllllIll + 1] & 0xFF);
    }

    public ClassReader(byte[] llllllllllllllllIIlIIIIIIlllIlII) {
        llllllllllllllllIIlIIIIIIlllIlIl(llllllllllllllllIIlIIIIIIlllIlII, 0, llllllllllllllllIIlIIIIIIlllIlII.length);
        ClassReader llllllllllllllllIIlIIIIIIlllIlIl;
    }

    private int readAnnotationTarget(Context llllllllllllllllIIIlllIlIIllIlII, int llllllllllllllllIIIlllIlIIlIlllI) {
        ClassReader llllllllllllllllIIIlllIlIIllIIII;
        int llllllllllllllllIIIlllIlIIllIIlI = llllllllllllllllIIIlllIlIIllIIII.readInt(llllllllllllllllIIIlllIlIIlIlllI);
        switch (llllllllllllllllIIIlllIlIIllIIlI >>> 24) {
            case 0: 
            case 1: 
            case 22: {
                llllllllllllllllIIIlllIlIIllIIlI &= 0xFFFF0000;
                llllllllllllllllIIIlllIlIIlIlllI += 2;
                break;
            }
            case 19: 
            case 20: 
            case 21: {
                llllllllllllllllIIIlllIlIIllIIlI &= 0xFF000000;
                ++llllllllllllllllIIIlllIlIIlIlllI;
                break;
            }
            case 64: 
            case 65: {
                llllllllllllllllIIIlllIlIIllIIlI &= 0xFF000000;
                int llllllllllllllllIIIlllIlIIllIllI = llllllllllllllllIIIlllIlIIllIIII.readUnsignedShort(llllllllllllllllIIIlllIlIIlIlllI + 1);
                llllllllllllllllIIIlllIlIIllIlII.start = new Label[llllllllllllllllIIIlllIlIIllIllI];
                llllllllllllllllIIIlllIlIIllIlII.end = new Label[llllllllllllllllIIIlllIlIIllIllI];
                llllllllllllllllIIIlllIlIIllIlII.index = new int[llllllllllllllllIIIlllIlIIllIllI];
                llllllllllllllllIIIlllIlIIlIlllI += 3;
                for (int llllllllllllllllIIIlllIlIIllIlll = 0; llllllllllllllllIIIlllIlIIllIlll < llllllllllllllllIIIlllIlIIllIllI; ++llllllllllllllllIIIlllIlIIllIlll) {
                    int llllllllllllllllIIIlllIlIIlllIIl = llllllllllllllllIIIlllIlIIllIIII.readUnsignedShort(llllllllllllllllIIIlllIlIIlIlllI);
                    int llllllllllllllllIIIlllIlIIlllIII = llllllllllllllllIIIlllIlIIllIIII.readUnsignedShort(llllllllllllllllIIIlllIlIIlIlllI + 2);
                    llllllllllllllllIIIlllIlIIllIlII.start[llllllllllllllllIIIlllIlIIllIlll] = llllllllllllllllIIIlllIlIIllIIII.readLabel(llllllllllllllllIIIlllIlIIlllIIl, llllllllllllllllIIIlllIlIIllIlII.labels);
                    llllllllllllllllIIIlllIlIIllIlII.end[llllllllllllllllIIIlllIlIIllIlll] = llllllllllllllllIIIlllIlIIllIIII.readLabel(llllllllllllllllIIIlllIlIIlllIIl + llllllllllllllllIIIlllIlIIlllIII, llllllllllllllllIIIlllIlIIllIlII.labels);
                    llllllllllllllllIIIlllIlIIllIlII.index[llllllllllllllllIIIlllIlIIllIlll] = llllllllllllllllIIIlllIlIIllIIII.readUnsignedShort(llllllllllllllllIIIlllIlIIlIlllI + 4);
                    llllllllllllllllIIIlllIlIIlIlllI += 6;
                }
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                llllllllllllllllIIIlllIlIIllIIlI &= 0xFF0000FF;
                llllllllllllllllIIIlllIlIIlIlllI += 4;
                break;
            }
            default: {
                llllllllllllllllIIIlllIlIIllIIlI &= llllllllllllllllIIIlllIlIIllIIlI >>> 24 < 67 ? -256 : -16777216;
                llllllllllllllllIIIlllIlIIlIlllI += 3;
            }
        }
        int llllllllllllllllIIIlllIlIIllIIIl = llllllllllllllllIIIlllIlIIllIIII.readByte(llllllllllllllllIIIlllIlIIlIlllI);
        llllllllllllllllIIIlllIlIIllIlII.typeRef = llllllllllllllllIIIlllIlIIllIIlI;
        llllllllllllllllIIIlllIlIIllIlII.typePath = llllllllllllllllIIIlllIlIIllIIIl == 0 ? null : new TypePath(llllllllllllllllIIIlllIlIIllIIII.b, llllllllllllllllIIIlllIlIIlIlllI);
        return llllllllllllllllIIIlllIlIIlIlllI + 1 + 2 * llllllllllllllllIIIlllIlIIllIIIl;
    }

    public ClassReader(String llllllllllllllllIIIlllllllIIIIIl) throws IOException {
        llllllllllllllllIIIlllllllIIIIlI(ClassReader.readClass(ClassLoader.getSystemResourceAsStream(String.valueOf(new StringBuilder().append(llllllllllllllllIIIlllllllIIIIIl.replace('.', '/')).append(".class"))), true));
        ClassReader llllllllllllllllIIIlllllllIIIIlI;
    }

    public String readUTF8(int llllllllllllllllIIIllIlIllIllIll, char[] llllllllllllllllIIIllIlIllIlIlIl) {
        ClassReader llllllllllllllllIIIllIlIllIlllII;
        int llllllllllllllllIIIllIlIllIllIIl = llllllllllllllllIIIllIlIllIlllII.readUnsignedShort(llllllllllllllllIIIllIlIllIllIll);
        if (llllllllllllllllIIIllIlIllIllIll == 0 || llllllllllllllllIIIllIlIllIllIIl == 0) {
            return null;
        }
        String llllllllllllllllIIIllIlIllIllIII = llllllllllllllllIIIllIlIllIlllII.strings[llllllllllllllllIIIllIlIllIllIIl];
        if (llllllllllllllllIIIllIlIllIllIII != null) {
            return llllllllllllllllIIIllIlIllIllIII;
        }
        llllllllllllllllIIIllIlIllIllIll = llllllllllllllllIIIllIlIllIlllII.items[llllllllllllllllIIIllIlIllIllIIl];
        llllllllllllllllIIIllIlIllIlllII.strings[llllllllllllllllIIIllIlIllIllIIl] = llllllllllllllllIIIllIlIllIlllII.readUTF(llllllllllllllllIIIllIlIllIllIll + 2, llllllllllllllllIIIllIlIllIlllII.readUnsignedShort(llllllllllllllllIIIllIlIllIllIll), llllllllllllllllIIIllIlIllIlIlIl);
        return llllllllllllllllIIIllIlIllIlllII.strings[llllllllllllllllIIIllIlIllIllIIl];
    }

    public int readUnsignedShort(int llllllllllllllllIIIllIllIIIIIlll) {
        ClassReader llllllllllllllllIIIllIllIIIIlllI;
        byte[] llllllllllllllllIIIllIllIIIIlIll = llllllllllllllllIIIllIllIIIIlllI.b;
        return (llllllllllllllllIIIllIllIIIIlIll[llllllllllllllllIIIllIllIIIIIlll] & 0xFF) << 8 | llllllllllllllllIIIllIllIIIIlIll[llllllllllllllllIIIllIllIIIIIlll + 1] & 0xFF;
    }

    public int readByte(int llllllllllllllllIIIllIllIIIllIIl) {
        ClassReader llllllllllllllllIIIllIllIIIllIlI;
        return llllllllllllllllIIIllIllIIIllIlI.b[llllllllllllllllIIIllIllIIIllIIl] & 0xFF;
    }

    public String getClassName() {
        ClassReader llllllllllllllllIIlIIIIIIlIlIIlI;
        return llllllllllllllllIIlIIIIIIlIlIIlI.readClass(llllllllllllllllIIlIIIIIIlIlIIlI.header + 2, new char[llllllllllllllllIIlIIIIIIlIlIIlI.maxStringLength]);
    }

    public ClassReader(byte[] llllllllllllllllIIlIIIIIIlIlllIl, int llllllllllllllllIIlIIIIIIlIlllII, int llllllllllllllllIIlIIIIIIllIIIlI) {
        ClassReader llllllllllllllllIIlIIIIIIlIllllI;
        llllllllllllllllIIlIIIIIIlIllllI.b = llllllllllllllllIIlIIIIIIlIlllIl;
        if (llllllllllllllllIIlIIIIIIlIllllI.readShort(llllllllllllllllIIlIIIIIIlIlllII + 6) > 52) {
            throw new IllegalArgumentException();
        }
        llllllllllllllllIIlIIIIIIlIllllI.items = new int[llllllllllllllllIIlIIIIIIlIllllI.readUnsignedShort(llllllllllllllllIIlIIIIIIlIlllII + 8)];
        int llllllllllllllllIIlIIIIIIllIIIIl = llllllllllllllllIIlIIIIIIlIllllI.items.length;
        llllllllllllllllIIlIIIIIIlIllllI.strings = new String[llllllllllllllllIIlIIIIIIllIIIIl];
        int llllllllllllllllIIlIIIIIIllIIIII = 0;
        int llllllllllllllllIIlIIIIIIlIlllll = llllllllllllllllIIlIIIIIIlIlllII + 10;
        for (int llllllllllllllllIIlIIIIIIllIIllI = 1; llllllllllllllllIIlIIIIIIllIIllI < llllllllllllllllIIlIIIIIIllIIIIl; ++llllllllllllllllIIlIIIIIIllIIllI) {
            int llllllllllllllllIIlIIIIIIllIIlll;
            llllllllllllllllIIlIIIIIIlIllllI.items[llllllllllllllllIIlIIIIIIllIIllI] = llllllllllllllllIIlIIIIIIlIlllll + 1;
            switch (llllllllllllllllIIlIIIIIIlIlllIl[llllllllllllllllIIlIIIIIIlIlllll]) {
                case 3: 
                case 4: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 18: {
                    int llllllllllllllllIIlIIIIIIllIlIll = 5;
                    break;
                }
                case 5: 
                case 6: {
                    int llllllllllllllllIIlIIIIIIllIlIlI = 9;
                    ++llllllllllllllllIIlIIIIIIllIIllI;
                    break;
                }
                case 1: {
                    int llllllllllllllllIIlIIIIIIllIlIIl = 3 + llllllllllllllllIIlIIIIIIlIllllI.readUnsignedShort(llllllllllllllllIIlIIIIIIlIlllll + 1);
                    if (llllllllllllllllIIlIIIIIIllIlIIl <= llllllllllllllllIIlIIIIIIllIIIII) break;
                    llllllllllllllllIIlIIIIIIllIIIII = llllllllllllllllIIlIIIIIIllIlIIl;
                    break;
                }
                case 15: {
                    int llllllllllllllllIIlIIIIIIllIlIII = 4;
                    break;
                }
                default: {
                    llllllllllllllllIIlIIIIIIllIIlll = 3;
                }
            }
            llllllllllllllllIIlIIIIIIlIlllll += llllllllllllllllIIlIIIIIIllIIlll;
        }
        llllllllllllllllIIlIIIIIIlIllllI.maxStringLength = llllllllllllllllIIlIIIIIIllIIIII;
        llllllllllllllllIIlIIIIIIlIllllI.header = llllllllllllllllIIlIIIIIIlIlllll;
    }

    private int readField(ClassVisitor llllllllllllllllIIIlllllIIIIIIll, Context llllllllllllllllIIIlllllIIIIIIlI, int llllllllllllllllIIIlllllIIIIIIIl) {
        ClassReader llllllllllllllllIIIllllIllllIlII;
        char[] llllllllllllllllIIIlllllIIIIIIII = llllllllllllllllIIIlllllIIIIIIlI.buffer;
        int llllllllllllllllIIIllllIllllllll = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIlllllIIIIIIIl);
        String llllllllllllllllIIIllllIlllllllI = llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIIIIl + 2, llllllllllllllllIIIlllllIIIIIIII);
        String llllllllllllllllIIIllllIllllllIl = llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIIIIl + 4, llllllllllllllllIIIlllllIIIIIIII);
        llllllllllllllllIIIlllllIIIIIIIl += 6;
        String llllllllllllllllIIIllllIllllllII = null;
        int llllllllllllllllIIIllllIlllllIll = 0;
        int llllllllllllllllIIIllllIlllllIlI = 0;
        int llllllllllllllllIIIllllIlllllIIl = 0;
        int llllllllllllllllIIIllllIlllllIII = 0;
        Object llllllllllllllllIIIllllIllllIlll = null;
        Attribute llllllllllllllllIIIllllIllllIllI = null;
        for (int llllllllllllllllIIIlllllIIIIlllI = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIlllllIIIIIIIl); llllllllllllllllIIIlllllIIIIlllI > 0; --llllllllllllllllIIIlllllIIIIlllI) {
            String llllllllllllllllIIIlllllIIIIllll = llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIIIIl + 2, llllllllllllllllIIIlllllIIIIIIII);
            if ("ConstantValue".equals(llllllllllllllllIIIlllllIIIIllll)) {
                int llllllllllllllllIIIlllllIIIlIIIl = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIlllllIIIIIIIl + 8);
                llllllllllllllllIIIllllIllllIlll = llllllllllllllllIIIlllllIIIlIIIl == 0 ? null : llllllllllllllllIIIllllIllllIlII.readConst(llllllllllllllllIIIlllllIIIlIIIl, llllllllllllllllIIIlllllIIIIIIII);
            } else if ("Signature".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIllllllII = llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIIIIl + 8, llllllllllllllllIIIlllllIIIIIIII);
            } else if ("Deprecated".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIllllllll |= 0x20000;
            } else if ("Synthetic".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIllllllll |= 0x41000;
            } else if ("RuntimeVisibleAnnotations".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIlllllIll = llllllllllllllllIIIlllllIIIIIIIl + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIlllllIIl = llllllllllllllllIIIlllllIIIIIIIl + 8;
            } else if ("RuntimeInvisibleAnnotations".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIlllllIlI = llllllllllllllllIIIlllllIIIIIIIl + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(llllllllllllllllIIIlllllIIIIllll)) {
                llllllllllllllllIIIllllIlllllIII = llllllllllllllllIIIlllllIIIIIIIl + 8;
            } else {
                Attribute llllllllllllllllIIIlllllIIIlIIII = llllllllllllllllIIIllllIllllIlII.readAttribute(llllllllllllllllIIIlllllIIIIIIlI.attrs, llllllllllllllllIIIlllllIIIIllll, llllllllllllllllIIIlllllIIIIIIIl + 8, llllllllllllllllIIIllllIllllIlII.readInt(llllllllllllllllIIIlllllIIIIIIIl + 4), llllllllllllllllIIIlllllIIIIIIII, -1, null);
                if (llllllllllllllllIIIlllllIIIlIIII != null) {
                    llllllllllllllllIIIlllllIIIlIIII.next = llllllllllllllllIIIllllIllllIllI;
                    llllllllllllllllIIIllllIllllIllI = llllllllllllllllIIIlllllIIIlIIII;
                }
            }
            llllllllllllllllIIIlllllIIIIIIIl += 6 + llllllllllllllllIIIllllIllllIlII.readInt(llllllllllllllllIIIlllllIIIIIIIl + 4);
        }
        llllllllllllllllIIIlllllIIIIIIIl += 2;
        FieldVisitor llllllllllllllllIIIllllIllllIlIl = llllllllllllllllIIIlllllIIIIIIll.visitField(llllllllllllllllIIIllllIllllllll, llllllllllllllllIIIllllIlllllllI, llllllllllllllllIIIllllIllllllIl, llllllllllllllllIIIllllIllllllII, llllllllllllllllIIIllllIllllIlll);
        if (llllllllllllllllIIIllllIllllIlIl == null) {
            return llllllllllllllllIIIlllllIIIIIIIl;
        }
        if (llllllllllllllllIIIllllIlllllIll != 0) {
            int llllllllllllllllIIIlllllIIIIllII = llllllllllllllllIIIllllIlllllIll + 2;
            for (int llllllllllllllllIIIlllllIIIIllIl = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIllllIlllllIll); llllllllllllllllIIIlllllIIIIllIl > 0; --llllllllllllllllIIIlllllIIIIllIl) {
                llllllllllllllllIIIlllllIIIIllII = llllllllllllllllIIIllllIllllIlII.readAnnotationValues(llllllllllllllllIIIlllllIIIIllII + 2, llllllllllllllllIIIlllllIIIIIIII, true, llllllllllllllllIIIllllIllllIlIl.visitAnnotation(llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIllII, llllllllllllllllIIIlllllIIIIIIII), true));
            }
        }
        if (llllllllllllllllIIIllllIlllllIlI != 0) {
            int llllllllllllllllIIIlllllIIIIlIlI = llllllllllllllllIIIllllIlllllIlI + 2;
            for (int llllllllllllllllIIIlllllIIIIlIll = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIllllIlllllIlI); llllllllllllllllIIIlllllIIIIlIll > 0; --llllllllllllllllIIIlllllIIIIlIll) {
                llllllllllllllllIIIlllllIIIIlIlI = llllllllllllllllIIIllllIllllIlII.readAnnotationValues(llllllllllllllllIIIlllllIIIIlIlI + 2, llllllllllllllllIIIlllllIIIIIIII, true, llllllllllllllllIIIllllIllllIlIl.visitAnnotation(llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIlIlI, llllllllllllllllIIIlllllIIIIIIII), false));
            }
        }
        if (llllllllllllllllIIIllllIlllllIIl != 0) {
            int llllllllllllllllIIIlllllIIIIlIII = llllllllllllllllIIIllllIlllllIIl + 2;
            for (int llllllllllllllllIIIlllllIIIIlIIl = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIllllIlllllIIl); llllllllllllllllIIIlllllIIIIlIIl > 0; --llllllllllllllllIIIlllllIIIIlIIl) {
                llllllllllllllllIIIlllllIIIIlIII = llllllllllllllllIIIllllIllllIlII.readAnnotationTarget(llllllllllllllllIIIlllllIIIIIIlI, llllllllllllllllIIIlllllIIIIlIII);
                llllllllllllllllIIIlllllIIIIlIII = llllllllllllllllIIIllllIllllIlII.readAnnotationValues(llllllllllllllllIIIlllllIIIIlIII + 2, llllllllllllllllIIIlllllIIIIIIII, true, llllllllllllllllIIIllllIllllIlIl.visitTypeAnnotation(llllllllllllllllIIIlllllIIIIIIlI.typeRef, llllllllllllllllIIIlllllIIIIIIlI.typePath, llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIlIII, llllllllllllllllIIIlllllIIIIIIII), true));
            }
        }
        if (llllllllllllllllIIIllllIlllllIII != 0) {
            int llllllllllllllllIIIlllllIIIIIllI = llllllllllllllllIIIllllIlllllIII + 2;
            for (int llllllllllllllllIIIlllllIIIIIlll = llllllllllllllllIIIllllIllllIlII.readUnsignedShort(llllllllllllllllIIIllllIlllllIII); llllllllllllllllIIIlllllIIIIIlll > 0; --llllllllllllllllIIIlllllIIIIIlll) {
                llllllllllllllllIIIlllllIIIIIllI = llllllllllllllllIIIllllIllllIlII.readAnnotationTarget(llllllllllllllllIIIlllllIIIIIIlI, llllllllllllllllIIIlllllIIIIIllI);
                llllllllllllllllIIIlllllIIIIIllI = llllllllllllllllIIIllllIllllIlII.readAnnotationValues(llllllllllllllllIIIlllllIIIIIllI + 2, llllllllllllllllIIIlllllIIIIIIII, true, llllllllllllllllIIIllllIllllIlIl.visitTypeAnnotation(llllllllllllllllIIIlllllIIIIIIlI.typeRef, llllllllllllllllIIIlllllIIIIIIlI.typePath, llllllllllllllllIIIllllIllllIlII.readUTF8(llllllllllllllllIIIlllllIIIIIllI, llllllllllllllllIIIlllllIIIIIIII), false));
            }
        }
        while (llllllllllllllllIIIllllIllllIllI != null) {
            Attribute llllllllllllllllIIIlllllIIIIIlIl = llllllllllllllllIIIllllIllllIllI.next;
            llllllllllllllllIIIllllIllllIllI.next = null;
            llllllllllllllllIIIllllIllllIlIl.visitAttribute(llllllllllllllllIIIllllIllllIllI);
            llllllllllllllllIIIllllIllllIllI = llllllllllllllllIIIlllllIIIIIlIl;
        }
        llllllllllllllllIIIllllIllllIlIl.visitEnd();
        return llllllllllllllllIIIlllllIIIIIIIl;
    }

    public void accept(ClassVisitor llllllllllllllllIIIlllllIlIlIlIl, Attribute[] llllllllllllllllIIIlllllIIllllIl, int llllllllllllllllIIIlllllIIllllII) {
        ClassReader llllllllllllllllIIIlllllIlIlIllI;
        int llllllllllllllllIIIlllllIlIlIIlI = llllllllllllllllIIIlllllIlIlIllI.header;
        char[] llllllllllllllllIIIlllllIlIlIIIl = new char[llllllllllllllllIIIlllllIlIlIllI.maxStringLength];
        Context llllllllllllllllIIIlllllIlIlIIII = new Context();
        llllllllllllllllIIIlllllIlIlIIII.attrs = llllllllllllllllIIIlllllIIllllIl;
        llllllllllllllllIIIlllllIlIlIIII.flags = llllllllllllllllIIIlllllIIllllII;
        llllllllllllllllIIIlllllIlIlIIII.buffer = llllllllllllllllIIIlllllIlIlIIIl;
        int llllllllllllllllIIIlllllIlIIllll = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIlIIlI);
        String llllllllllllllllIIIlllllIlIIlllI = llllllllllllllllIIIlllllIlIlIllI.readClass(llllllllllllllllIIIlllllIlIlIIlI + 2, llllllllllllllllIIIlllllIlIlIIIl);
        String llllllllllllllllIIIlllllIlIIllIl = llllllllllllllllIIIlllllIlIlIllI.readClass(llllllllllllllllIIIlllllIlIlIIlI + 4, llllllllllllllllIIIlllllIlIlIIIl);
        String[] llllllllllllllllIIIlllllIlIIllII = new String[llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIlIIlI + 6)];
        llllllllllllllllIIIlllllIlIlIIlI += 8;
        for (int llllllllllllllllIIIlllllIllIllII = 0; llllllllllllllllIIIlllllIllIllII < llllllllllllllllIIIlllllIlIIllII.length; ++llllllllllllllllIIIlllllIllIllII) {
            llllllllllllllllIIIlllllIlIIllII[llllllllllllllllIIIlllllIllIllII] = llllllllllllllllIIIlllllIlIlIllI.readClass(llllllllllllllllIIIlllllIlIlIIlI, llllllllllllllllIIIlllllIlIlIIIl);
            llllllllllllllllIIIlllllIlIlIIlI += 2;
        }
        String llllllllllllllllIIIlllllIlIIlIll = null;
        String llllllllllllllllIIIlllllIlIIlIlI = null;
        String llllllllllllllllIIIlllllIlIIlIIl = null;
        String llllllllllllllllIIIlllllIlIIlIII = null;
        String llllllllllllllllIIIlllllIlIIIlll = null;
        String llllllllllllllllIIIlllllIlIIIllI = null;
        int llllllllllllllllIIIlllllIlIIIlIl = 0;
        int llllllllllllllllIIIlllllIlIIIlII = 0;
        int llllllllllllllllIIIlllllIlIIIIll = 0;
        int llllllllllllllllIIIlllllIlIIIIlI = 0;
        int llllllllllllllllIIIlllllIlIIIIIl = 0;
        Attribute llllllllllllllllIIIlllllIlIIIIII = null;
        llllllllllllllllIIIlllllIlIlIIlI = llllllllllllllllIIIlllllIlIlIllI.getAttributes();
        for (int llllllllllllllllIIIlllllIllIIlII = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIlIIlI); llllllllllllllllIIIlllllIllIIlII > 0; --llllllllllllllllIIIlllllIllIIlII) {
            String llllllllllllllllIIIlllllIllIIlIl = llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIlIIlI + 2, llllllllllllllllIIIlllllIlIlIIIl);
            if ("SourceFile".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIlIlI = llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIlIIlI + 8, llllllllllllllllIIIlllllIlIlIIIl);
            } else if ("InnerClasses".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIIIIl = llllllllllllllllIIIlllllIlIlIIlI + 8;
            } else if ("EnclosingMethod".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIlIII = llllllllllllllllIIIlllllIlIlIllI.readClass(llllllllllllllllIIIlllllIlIlIIlI + 8, llllllllllllllllIIIlllllIlIlIIIl);
                int llllllllllllllllIIIlllllIllIlIll = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIlIIlI + 10);
                if (llllllllllllllllIIIlllllIllIlIll != 0) {
                    llllllllllllllllIIIlllllIlIIIlll = llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIlIllI.items[llllllllllllllllIIIlllllIllIlIll], llllllllllllllllIIIlllllIlIlIIIl);
                    llllllllllllllllIIIlllllIlIIIllI = llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIlIllI.items[llllllllllllllllIIIlllllIllIlIll] + 2, llllllllllllllllIIIlllllIlIlIIIl);
                }
            } else if ("Signature".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIlIll = llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIlIIlI + 8, llllllllllllllllIIIlllllIlIlIIIl);
            } else if ("RuntimeVisibleAnnotations".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIIlIl = llllllllllllllllIIIlllllIlIlIIlI + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIIIll = llllllllllllllllIIIlllllIlIlIIlI + 8;
            } else if ("Deprecated".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIllll |= 0x20000;
            } else if ("Synthetic".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIllll |= 0x41000;
            } else if ("SourceDebugExtension".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                int llllllllllllllllIIIlllllIllIlIlI = llllllllllllllllIIIlllllIlIlIllI.readInt(llllllllllllllllIIIlllllIlIlIIlI + 4);
                llllllllllllllllIIIlllllIlIIlIIl = llllllllllllllllIIIlllllIlIlIllI.readUTF(llllllllllllllllIIIlllllIlIlIIlI + 8, llllllllllllllllIIIlllllIllIlIlI, new char[llllllllllllllllIIIlllllIllIlIlI]);
            } else if ("RuntimeInvisibleAnnotations".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIIlII = llllllllllllllllIIIlllllIlIlIIlI + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                llllllllllllllllIIIlllllIlIIIIlI = llllllllllllllllIIIlllllIlIlIIlI + 8;
            } else if ("BootstrapMethods".equals(llllllllllllllllIIIlllllIllIIlIl)) {
                int[] llllllllllllllllIIIlllllIllIIlll = new int[llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIlIIlI + 8)];
                int llllllllllllllllIIIlllllIllIlIII = llllllllllllllllIIIlllllIlIlIIlI + 10;
                for (int llllllllllllllllIIIlllllIllIlIIl = 0; llllllllllllllllIIIlllllIllIlIIl < llllllllllllllllIIIlllllIllIIlll.length; ++llllllllllllllllIIIlllllIllIlIIl) {
                    llllllllllllllllIIIlllllIllIIlll[llllllllllllllllIIIlllllIllIlIIl] = llllllllllllllllIIIlllllIllIlIII;
                    llllllllllllllllIIIlllllIllIlIII += 2 + llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIllIlIII + 2) << 1;
                }
                llllllllllllllllIIIlllllIlIlIIII.bootstrapMethods = llllllllllllllllIIIlllllIllIIlll;
            } else {
                Attribute llllllllllllllllIIIlllllIllIIllI = llllllllllllllllIIIlllllIlIlIllI.readAttribute(llllllllllllllllIIIlllllIIllllIl, llllllllllllllllIIIlllllIllIIlIl, llllllllllllllllIIIlllllIlIlIIlI + 8, llllllllllllllllIIIlllllIlIlIllI.readInt(llllllllllllllllIIIlllllIlIlIIlI + 4), llllllllllllllllIIIlllllIlIlIIIl, -1, null);
                if (llllllllllllllllIIIlllllIllIIllI != null) {
                    llllllllllllllllIIIlllllIllIIllI.next = llllllllllllllllIIIlllllIlIIIIII;
                    llllllllllllllllIIIlllllIlIIIIII = llllllllllllllllIIIlllllIllIIllI;
                }
            }
            llllllllllllllllIIIlllllIlIlIIlI += 6 + llllllllllllllllIIIlllllIlIlIllI.readInt(llllllllllllllllIIIlllllIlIlIIlI + 4);
        }
        llllllllllllllllIIIlllllIlIlIlIl.visit(llllllllllllllllIIIlllllIlIlIllI.readInt(llllllllllllllllIIIlllllIlIlIllI.items[1] - 7), llllllllllllllllIIIlllllIlIIllll, llllllllllllllllIIIlllllIlIIlllI, llllllllllllllllIIIlllllIlIIlIll, llllllllllllllllIIIlllllIlIIllIl, llllllllllllllllIIIlllllIlIIllII);
        if ((llllllllllllllllIIIlllllIIllllII & 2) == 0 && (llllllllllllllllIIIlllllIlIIlIlI != null || llllllllllllllllIIIlllllIlIIlIIl != null)) {
            llllllllllllllllIIIlllllIlIlIlIl.visitSource(llllllllllllllllIIIlllllIlIIlIlI, llllllllllllllllIIIlllllIlIIlIIl);
        }
        if (llllllllllllllllIIIlllllIlIIlIII != null) {
            llllllllllllllllIIIlllllIlIlIlIl.visitOuterClass(llllllllllllllllIIIlllllIlIIlIII, llllllllllllllllIIIlllllIlIIIlll, llllllllllllllllIIIlllllIlIIIllI);
        }
        if (llllllllllllllllIIIlllllIlIIIlIl != 0) {
            int llllllllllllllllIIIlllllIllIIIlI = llllllllllllllllIIIlllllIlIIIlIl + 2;
            for (int llllllllllllllllIIIlllllIllIIIll = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIIIlIl); llllllllllllllllIIIlllllIllIIIll > 0; --llllllllllllllllIIIlllllIllIIIll) {
                llllllllllllllllIIIlllllIllIIIlI = llllllllllllllllIIIlllllIlIlIllI.readAnnotationValues(llllllllllllllllIIIlllllIllIIIlI + 2, llllllllllllllllIIIlllllIlIlIIIl, true, llllllllllllllllIIIlllllIlIlIlIl.visitAnnotation(llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIllIIIlI, llllllllllllllllIIIlllllIlIlIIIl), true));
            }
        }
        if (llllllllllllllllIIIlllllIlIIIlII != 0) {
            int llllllllllllllllIIIlllllIllIIIII = llllllllllllllllIIIlllllIlIIIlII + 2;
            for (int llllllllllllllllIIIlllllIllIIIIl = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIIIlII); llllllllllllllllIIIlllllIllIIIIl > 0; --llllllllllllllllIIIlllllIllIIIIl) {
                llllllllllllllllIIIlllllIllIIIII = llllllllllllllllIIIlllllIlIlIllI.readAnnotationValues(llllllllllllllllIIIlllllIllIIIII + 2, llllllllllllllllIIIlllllIlIlIIIl, true, llllllllllllllllIIIlllllIlIlIlIl.visitAnnotation(llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIllIIIII, llllllllllllllllIIIlllllIlIlIIIl), false));
            }
        }
        if (llllllllllllllllIIIlllllIlIIIIll != 0) {
            int llllllllllllllllIIIlllllIlIllllI = llllllllllllllllIIIlllllIlIIIIll + 2;
            for (int llllllllllllllllIIIlllllIlIlllll = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIIIIll); llllllllllllllllIIIlllllIlIlllll > 0; --llllllllllllllllIIIlllllIlIlllll) {
                llllllllllllllllIIIlllllIlIllllI = llllllllllllllllIIIlllllIlIlIllI.readAnnotationTarget(llllllllllllllllIIIlllllIlIlIIII, llllllllllllllllIIIlllllIlIllllI);
                llllllllllllllllIIIlllllIlIllllI = llllllllllllllllIIIlllllIlIlIllI.readAnnotationValues(llllllllllllllllIIIlllllIlIllllI + 2, llllllllllllllllIIIlllllIlIlIIIl, true, llllllllllllllllIIIlllllIlIlIlIl.visitTypeAnnotation(llllllllllllllllIIIlllllIlIlIIII.typeRef, llllllllllllllllIIIlllllIlIlIIII.typePath, llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIllllI, llllllllllllllllIIIlllllIlIlIIIl), true));
            }
        }
        if (llllllllllllllllIIIlllllIlIIIIlI != 0) {
            int llllllllllllllllIIIlllllIlIlllII = llllllllllllllllIIIlllllIlIIIIlI + 2;
            for (int llllllllllllllllIIIlllllIlIlllIl = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIIIIlI); llllllllllllllllIIIlllllIlIlllIl > 0; --llllllllllllllllIIIlllllIlIlllIl) {
                llllllllllllllllIIIlllllIlIlllII = llllllllllllllllIIIlllllIlIlIllI.readAnnotationTarget(llllllllllllllllIIIlllllIlIlIIII, llllllllllllllllIIIlllllIlIlllII);
                llllllllllllllllIIIlllllIlIlllII = llllllllllllllllIIIlllllIlIlIllI.readAnnotationValues(llllllllllllllllIIIlllllIlIlllII + 2, llllllllllllllllIIIlllllIlIlIIIl, true, llllllllllllllllIIIlllllIlIlIlIl.visitTypeAnnotation(llllllllllllllllIIIlllllIlIlIIII.typeRef, llllllllllllllllIIIlllllIlIlIIII.typePath, llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIlllII, llllllllllllllllIIIlllllIlIlIIIl), false));
            }
        }
        while (llllllllllllllllIIIlllllIlIIIIII != null) {
            Attribute llllllllllllllllIIIlllllIlIllIll = llllllllllllllllIIIlllllIlIIIIII.next;
            llllllllllllllllIIIlllllIlIIIIII.next = null;
            llllllllllllllllIIIlllllIlIlIlIl.visitAttribute(llllllllllllllllIIIlllllIlIIIIII);
            llllllllllllllllIIIlllllIlIIIIII = llllllllllllllllIIIlllllIlIllIll;
        }
        if (llllllllllllllllIIIlllllIlIIIIIl != 0) {
            int llllllllllllllllIIIlllllIlIllIIl = llllllllllllllllIIIlllllIlIIIIIl + 2;
            for (int llllllllllllllllIIIlllllIlIllIlI = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIIIIIl); llllllllllllllllIIIlllllIlIllIlI > 0; --llllllllllllllllIIIlllllIlIllIlI) {
                llllllllllllllllIIIlllllIlIlIlIl.visitInnerClass(llllllllllllllllIIIlllllIlIlIllI.readClass(llllllllllllllllIIIlllllIlIllIIl, llllllllllllllllIIIlllllIlIlIIIl), llllllllllllllllIIIlllllIlIlIllI.readClass(llllllllllllllllIIIlllllIlIllIIl + 2, llllllllllllllllIIIlllllIlIlIIIl), llllllllllllllllIIIlllllIlIlIllI.readUTF8(llllllllllllllllIIIlllllIlIllIIl + 4, llllllllllllllllIIIlllllIlIlIIIl), llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIllIIl + 6));
                llllllllllllllllIIIlllllIlIllIIl += 8;
            }
        }
        llllllllllllllllIIIlllllIlIlIIlI = llllllllllllllllIIIlllllIlIlIllI.header + 10 + 2 * llllllllllllllllIIIlllllIlIIllII.length;
        for (int llllllllllllllllIIIlllllIlIllIII = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort(llllllllllllllllIIIlllllIlIlIIlI - 2); llllllllllllllllIIIlllllIlIllIII > 0; --llllllllllllllllIIIlllllIlIllIII) {
            llllllllllllllllIIIlllllIlIlIIlI = llllllllllllllllIIIlllllIlIlIllI.readField(llllllllllllllllIIIlllllIlIlIlIl, llllllllllllllllIIIlllllIlIlIIII, llllllllllllllllIIIlllllIlIlIIlI);
        }
        for (int llllllllllllllllIIIlllllIlIlIlll = llllllllllllllllIIIlllllIlIlIllI.readUnsignedShort((llllllllllllllllIIIlllllIlIlIIlI += 2) - 2); llllllllllllllllIIIlllllIlIlIlll > 0; --llllllllllllllllIIIlllllIlIlIlll) {
            llllllllllllllllIIIlllllIlIlIIlI = llllllllllllllllIIIlllllIlIlIllI.readMethod(llllllllllllllllIIIlllllIlIlIlIl, llllllllllllllllIIIlllllIlIlIIII, llllllllllllllllIIIlllllIlIlIIlI);
        }
        llllllllllllllllIIIlllllIlIlIlIl.visitEnd();
    }

    private int readFrame(int llllllllllllllllIIIllIlllIlIllII, boolean llllllllllllllllIIIllIlllIllIlII, boolean llllllllllllllllIIIllIlllIllIIll, Context llllllllllllllllIIIllIlllIlIlIIl) {
        int llllllllllllllllIIIllIlllIlIlllI;
        int llllllllllllllllIIIllIlllIlIllll;
        ClassReader llllllllllllllllIIIllIlllIllIllI;
        char[] llllllllllllllllIIIllIlllIllIIIl = llllllllllllllllIIIllIlllIlIlIIl.buffer;
        Label[] llllllllllllllllIIIllIlllIllIIII = llllllllllllllllIIIllIlllIlIlIIl.labels;
        if (llllllllllllllllIIIllIlllIllIlII) {
            int llllllllllllllllIIIllIlllIlllllI = llllllllllllllllIIIllIlllIllIllI.b[llllllllllllllllIIIllIlllIlIllII++] & 0xFF;
        } else {
            llllllllllllllllIIIllIlllIlIllll = 255;
            llllllllllllllllIIIllIlllIlIlIIl.offset = -1;
        }
        llllllllllllllllIIIllIlllIlIlIIl.localDiff = 0;
        if (llllllllllllllllIIIllIlllIlIllll < 64) {
            int llllllllllllllllIIIllIlllIllllIl = llllllllllllllllIIIllIlllIlIllll;
            llllllllllllllllIIIllIlllIlIlIIl.mode = 3;
            llllllllllllllllIIIllIlllIlIlIIl.stackCount = 0;
        } else if (llllllllllllllllIIIllIlllIlIllll < 128) {
            int llllllllllllllllIIIllIlllIllllII = llllllllllllllllIIIllIlllIlIllll - 64;
            llllllllllllllllIIIllIlllIlIllII = llllllllllllllllIIIllIlllIllIllI.readFrameType(llllllllllllllllIIIllIlllIlIlIIl.stack, 0, llllllllllllllllIIIllIlllIlIllII, llllllllllllllllIIIllIlllIllIIIl, llllllllllllllllIIIllIlllIllIIII);
            llllllllllllllllIIIllIlllIlIlIIl.mode = 4;
            llllllllllllllllIIIllIlllIlIlIIl.stackCount = 1;
        } else {
            llllllllllllllllIIIllIlllIlIlllI = llllllllllllllllIIIllIlllIllIllI.readUnsignedShort(llllllllllllllllIIIllIlllIlIllII);
            llllllllllllllllIIIllIlllIlIllII += 2;
            if (llllllllllllllllIIIllIlllIlIllll == 247) {
                llllllllllllllllIIIllIlllIlIllII = llllllllllllllllIIIllIlllIllIllI.readFrameType(llllllllllllllllIIIllIlllIlIlIIl.stack, 0, llllllllllllllllIIIllIlllIlIllII, llllllllllllllllIIIllIlllIllIIIl, llllllllllllllllIIIllIlllIllIIII);
                llllllllllllllllIIIllIlllIlIlIIl.mode = 4;
                llllllllllllllllIIIllIlllIlIlIIl.stackCount = 1;
            } else if (llllllllllllllllIIIllIlllIlIllll >= 248 && llllllllllllllllIIIllIlllIlIllll < 251) {
                llllllllllllllllIIIllIlllIlIlIIl.mode = 2;
                llllllllllllllllIIIllIlllIlIlIIl.localDiff = 251 - llllllllllllllllIIIllIlllIlIllll;
                llllllllllllllllIIIllIlllIlIlIIl.localCount -= llllllllllllllllIIIllIlllIlIlIIl.localDiff;
                llllllllllllllllIIIllIlllIlIlIIl.stackCount = 0;
            } else if (llllllllllllllllIIIllIlllIlIllll == 251) {
                llllllllllllllllIIIllIlllIlIlIIl.mode = 3;
                llllllllllllllllIIIllIlllIlIlIIl.stackCount = 0;
            } else if (llllllllllllllllIIIllIlllIlIllll < 255) {
                int llllllllllllllllIIIllIlllIlllIlI = llllllllllllllllIIIllIlllIllIIll ? llllllllllllllllIIIllIlllIlIlIIl.localCount : 0;
                for (int llllllllllllllllIIIllIlllIlllIll = llllllllllllllllIIIllIlllIlIllll - 251; llllllllllllllllIIIllIlllIlllIll > 0; --llllllllllllllllIIIllIlllIlllIll) {
                    llllllllllllllllIIIllIlllIlIllII = llllllllllllllllIIIllIlllIllIllI.readFrameType(llllllllllllllllIIIllIlllIlIlIIl.local, llllllllllllllllIIIllIlllIlllIlI++, llllllllllllllllIIIllIlllIlIllII, llllllllllllllllIIIllIlllIllIIIl, llllllllllllllllIIIllIlllIllIIII);
                }
                llllllllllllllllIIIllIlllIlIlIIl.mode = 1;
                llllllllllllllllIIIllIlllIlIlIIl.localDiff = llllllllllllllllIIIllIlllIlIllll - 251;
                llllllllllllllllIIIllIlllIlIlIIl.localCount += llllllllllllllllIIIllIlllIlIlIIl.localDiff;
                llllllllllllllllIIIllIlllIlIlIIl.stackCount = 0;
            } else {
                llllllllllllllllIIIllIlllIlIlIIl.mode = 0;
                int llllllllllllllllIIIllIlllIllIlll = llllllllllllllllIIIllIlllIllIllI.readUnsignedShort(llllllllllllllllIIIllIlllIlIllII);
                llllllllllllllllIIIllIlllIlIllII += 2;
                llllllllllllllllIIIllIlllIlIlIIl.localDiff = llllllllllllllllIIIllIlllIllIlll;
                llllllllllllllllIIIllIlllIlIlIIl.localCount = llllllllllllllllIIIllIlllIllIlll;
                int llllllllllllllllIIIllIlllIlllIIl = 0;
                while (llllllllllllllllIIIllIlllIllIlll > 0) {
                    llllllllllllllllIIIllIlllIlIllII = llllllllllllllllIIIllIlllIllIllI.readFrameType(llllllllllllllllIIIllIlllIlIlIIl.local, llllllllllllllllIIIllIlllIlllIIl++, llllllllllllllllIIIllIlllIlIllII, llllllllllllllllIIIllIlllIllIIIl, llllllllllllllllIIIllIlllIllIIII);
                    --llllllllllllllllIIIllIlllIllIlll;
                }
                llllllllllllllllIIIllIlllIllIlll = llllllllllllllllIIIllIlllIllIllI.readUnsignedShort(llllllllllllllllIIIllIlllIlIllII);
                llllllllllllllllIIIllIlllIlIllII += 2;
                llllllllllllllllIIIllIlllIlIlIIl.stackCount = llllllllllllllllIIIllIlllIllIlll;
                int llllllllllllllllIIIllIlllIlllIII = 0;
                while (llllllllllllllllIIIllIlllIllIlll > 0) {
                    llllllllllllllllIIIllIlllIlIllII = llllllllllllllllIIIllIlllIllIllI.readFrameType(llllllllllllllllIIIllIlllIlIlIIl.stack, llllllllllllllllIIIllIlllIlllIII++, llllllllllllllllIIIllIlllIlIllII, llllllllllllllllIIIllIlllIllIIIl, llllllllllllllllIIIllIlllIllIIII);
                    --llllllllllllllllIIIllIlllIllIlll;
                }
            }
        }
        llllllllllllllllIIIllIlllIlIlIIl.offset += llllllllllllllllIIIllIlllIlIlllI + 1;
        llllllllllllllllIIIllIlllIllIllI.readLabel(llllllllllllllllIIIllIlllIlIlIIl.offset, llllllllllllllllIIIllIlllIllIIII);
        return llllllllllllllllIIIllIlllIlIllII;
    }

    public int getAccess() {
        ClassReader llllllllllllllllIIlIIIIIIlIlIlII;
        return llllllllllllllllIIlIIIIIIlIlIlII.readUnsignedShort(llllllllllllllllIIlIIIIIIlIlIlII.header);
    }

    private int readAnnotationValue(int llllllllllllllllIIIlllIIIIllllII, char[] llllllllllllllllIIIlllIIIIlllIll, String llllllllllllllllIIIlllIIIIllllll, AnnotationVisitor llllllllllllllllIIIlllIIIIlllllI) {
        ClassReader llllllllllllllllIIIlllIIIlIIIIlI;
        if (llllllllllllllllIIIlllIIIIlllllI == null) {
            switch (llllllllllllllllIIIlllIIIlIIIIlI.b[llllllllllllllllIIIlllIIIIllllII] & 0xFF) {
                case 101: {
                    return llllllllllllllllIIIlllIIIIllllII + 5;
                }
                case 64: {
                    return llllllllllllllllIIIlllIIIlIIIIlI.readAnnotationValues(llllllllllllllllIIIlllIIIIllllII + 3, llllllllllllllllIIIlllIIIIlllIll, true, null);
                }
                case 91: {
                    return llllllllllllllllIIIlllIIIlIIIIlI.readAnnotationValues(llllllllllllllllIIIlllIIIIllllII + 1, llllllllllllllllIIIlllIIIIlllIll, false, null);
                }
            }
            return llllllllllllllllIIIlllIIIIllllII + 3;
        }
        block5 : switch (llllllllllllllllIIIlllIIIlIIIIlI.b[llllllllllllllllIIIlllIIIIllllII++] & 0xFF) {
            case 68: 
            case 70: 
            case 73: 
            case 74: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIIlI.readConst(llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII), llllllllllllllllIIIlllIIIIlllIll));
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 66: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, (byte)llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]));
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 90: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 83: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, (short)llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]));
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 67: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, Character.valueOf((char)llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)])));
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 115: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIIlI.readUTF8(llllllllllllllllIIIlllIIIIllllII, llllllllllllllllIIIlllIIIIlllIll));
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 101: {
                llllllllllllllllIIIlllIIIIlllllI.visitEnum(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIIlI.readUTF8(llllllllllllllllIIIlllIIIIllllII, llllllllllllllllIIIlllIIIIlllIll), llllllllllllllllIIIlllIIIlIIIIlI.readUTF8(llllllllllllllllIIIlllIIIIllllII + 2, llllllllllllllllIIIlllIIIIlllIll));
                llllllllllllllllIIIlllIIIIllllII += 4;
                break;
            }
            case 99: {
                llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, Type.getType(llllllllllllllllIIIlllIIIlIIIIlI.readUTF8(llllllllllllllllIIIlllIIIIllllII, llllllllllllllllIIIlllIIIIlllIll)));
                llllllllllllllllIIIlllIIIIllllII += 2;
                break;
            }
            case 64: {
                llllllllllllllllIIIlllIIIIllllII = llllllllllllllllIIIlllIIIlIIIIlI.readAnnotationValues(llllllllllllllllIIIlllIIIIllllII + 2, llllllllllllllllIIIlllIIIIlllIll, true, llllllllllllllllIIIlllIIIIlllllI.visitAnnotation(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIIlI.readUTF8(llllllllllllllllIIIlllIIIIllllII, llllllllllllllllIIIlllIIIIlllIll)));
                break;
            }
            case 91: {
                int llllllllllllllllIIIlllIIIlIIIIll = llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII);
                llllllllllllllllIIIlllIIIIllllII += 2;
                if (llllllllllllllllIIIlllIIIlIIIIll == 0) {
                    return llllllllllllllllIIIlllIIIlIIIIlI.readAnnotationValues(llllllllllllllllIIIlllIIIIllllII - 2, llllllllllllllllIIIlllIIIIlllIll, false, llllllllllllllllIIIlllIIIIlllllI.visitArray(llllllllllllllllIIIlllIIIIllllll));
                }
                switch (llllllllllllllllIIIlllIIIlIIIIlI.b[llllllllllllllllIIIlllIIIIllllII++] & 0xFF) {
                    case 66: {
                        byte[] llllllllllllllllIIIlllIIIlIlIIlI = new byte[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIlIIll = 0; llllllllllllllllIIIlllIIIlIlIIll < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIlIIll) {
                            llllllllllllllllIIIlllIIIlIlIIlI[llllllllllllllllIIIlllIIIlIlIIll] = (byte)llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]);
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIlIIlI);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 90: {
                        boolean[] llllllllllllllllIIIlllIIIlIlIIII = new boolean[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIlIIIl = 0; llllllllllllllllIIIlllIIIlIlIIIl < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIlIIIl) {
                            llllllllllllllllIIIlllIIIlIlIIII[llllllllllllllllIIIlllIIIlIlIIIl] = llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]) != 0;
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIlIIII);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 83: {
                        short[] llllllllllllllllIIIlllIIIlIIlllI = new short[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIIllll = 0; llllllllllllllllIIIlllIIIlIIllll < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIIllll) {
                            llllllllllllllllIIIlllIIIlIIlllI[llllllllllllllllIIIlllIIIlIIllll] = (short)llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]);
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIlllI);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 67: {
                        char[] llllllllllllllllIIIlllIIIlIIllII = new char[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIIllIl = 0; llllllllllllllllIIIlllIIIlIIllIl < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIIllIl) {
                            llllllllllllllllIIIlllIIIlIIllII[llllllllllllllllIIIlllIIIlIIllIl] = (char)llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]);
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIllII);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 73: {
                        int[] llllllllllllllllIIIlllIIIlIIlIlI = new int[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIIlIll = 0; llllllllllllllllIIIlllIIIlIIlIll < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIIlIll) {
                            llllllllllllllllIIIlllIIIlIIlIlI[llllllllllllllllIIIlllIIIlIIlIll] = llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]);
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIlIlI);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 74: {
                        long[] llllllllllllllllIIIlllIIIlIIlIII = new long[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIIlIIl = 0; llllllllllllllllIIIlllIIIlIIlIIl < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIIlIIl) {
                            llllllllllllllllIIIlllIIIlIIlIII[llllllllllllllllIIIlllIIIlIIlIIl] = llllllllllllllllIIIlllIIIlIIIIlI.readLong(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]);
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIlIII);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 70: {
                        float[] llllllllllllllllIIIlllIIIlIIIllI = new float[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIIIlll = 0; llllllllllllllllIIIlllIIIlIIIlll < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIIIlll) {
                            llllllllllllllllIIIlllIIIlIIIllI[llllllllllllllllIIIlllIIIlIIIlll] = Float.intBitsToFloat(llllllllllllllllIIIlllIIIlIIIIlI.readInt(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]));
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIllI);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                    case 68: {
                        double[] llllllllllllllllIIIlllIIIlIIIlII = new double[llllllllllllllllIIIlllIIIlIIIIll];
                        for (int llllllllllllllllIIIlllIIIlIIIlIl = 0; llllllllllllllllIIIlllIIIlIIIlIl < llllllllllllllllIIIlllIIIlIIIIll; ++llllllllllllllllIIIlllIIIlIIIlIl) {
                            llllllllllllllllIIIlllIIIlIIIlII[llllllllllllllllIIIlllIIIlIIIlIl] = Double.longBitsToDouble(llllllllllllllllIIIlllIIIlIIIIlI.readLong(llllllllllllllllIIIlllIIIlIIIIlI.items[llllllllllllllllIIIlllIIIlIIIIlI.readUnsignedShort(llllllllllllllllIIIlllIIIIllllII)]));
                            llllllllllllllllIIIlllIIIIllllII += 3;
                        }
                        llllllllllllllllIIIlllIIIIlllllI.visit(llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIlIIIlII);
                        --llllllllllllllllIIIlllIIIIllllII;
                        break block5;
                    }
                }
                llllllllllllllllIIIlllIIIIllllII = llllllllllllllllIIIlllIIIlIIIIlI.readAnnotationValues(llllllllllllllllIIIlllIIIIllllII - 3, llllllllllllllllIIIlllIIIIlllIll, false, llllllllllllllllIIIlllIIIIlllllI.visitArray(llllllllllllllllIIIlllIIIIllllll));
            }
        }
        return llllllllllllllllIIIlllIIIIllllII;
    }

    void copyPool(ClassWriter llllllllllllllllIIlIIIIIIIIlllll) {
        ClassReader llllllllllllllllIIlIIIIIIIlIIIII;
        char[] llllllllllllllllIIlIIIIIIIlIIlII = new char[llllllllllllllllIIlIIIIIIIlIIIII.maxStringLength];
        int llllllllllllllllIIlIIIIIIIlIIIll = llllllllllllllllIIlIIIIIIIlIIIII.items.length;
        Item[] llllllllllllllllIIlIIIIIIIlIIIlI = new Item[llllllllllllllllIIlIIIIIIIlIIIll];
        for (int llllllllllllllllIIlIIIIIIIlIIlll = 1; llllllllllllllllIIlIIIIIIIlIIlll < llllllllllllllllIIlIIIIIIIlIIIll; ++llllllllllllllllIIlIIIIIIIlIIlll) {
            int llllllllllllllllIIlIIIIIIIlIlIll = llllllllllllllllIIlIIIIIIIlIIIII.items[llllllllllllllllIIlIIIIIIIlIIlll];
            byte llllllllllllllllIIlIIIIIIIlIlIlI = llllllllllllllllIIlIIIIIIIlIIIII.b[llllllllllllllllIIlIIIIIIIlIlIll - 1];
            Item llllllllllllllllIIlIIIIIIIlIlIIl = new Item(llllllllllllllllIIlIIIIIIIlIIlll);
            switch (llllllllllllllllIIlIIIIIIIlIlIlI) {
                case 9: 
                case 10: 
                case 11: {
                    int llllllllllllllllIIlIIIIIIIllIIII = llllllllllllllllIIlIIIIIIIlIIIII.items[llllllllllllllllIIlIIIIIIIlIIIII.readUnsignedShort(llllllllllllllllIIlIIIIIIIlIlIll + 2)];
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIlIlI, llllllllllllllllIIlIIIIIIIlIIIII.readClass(llllllllllllllllIIlIIIIIIIlIlIll, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIllIIII, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIllIIII + 2, llllllllllllllllIIlIIIIIIIlIIlII));
                    break;
                }
                case 3: {
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIIIII.readInt(llllllllllllllllIIlIIIIIIIlIlIll));
                    break;
                }
                case 4: {
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(Float.intBitsToFloat(llllllllllllllllIIlIIIIIIIlIIIII.readInt(llllllllllllllllIIlIIIIIIIlIlIll)));
                    break;
                }
                case 12: {
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIlIlI, llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIlIll, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIlIll + 2, llllllllllllllllIIlIIIIIIIlIIlII), null);
                    break;
                }
                case 5: {
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIIIII.readLong(llllllllllllllllIIlIIIIIIIlIlIll));
                    ++llllllllllllllllIIlIIIIIIIlIIlll;
                    break;
                }
                case 6: {
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(Double.longBitsToDouble(llllllllllllllllIIlIIIIIIIlIIIII.readLong(llllllllllllllllIIlIIIIIIIlIlIll)));
                    ++llllllllllllllllIIlIIIIIIIlIIlll;
                    break;
                }
                case 1: {
                    String llllllllllllllllIIlIIIIIIIlIllll = llllllllllllllllIIlIIIIIIIlIIIII.strings[llllllllllllllllIIlIIIIIIIlIIlll];
                    if (llllllllllllllllIIlIIIIIIIlIllll == null) {
                        llllllllllllllllIIlIIIIIIIlIlIll = llllllllllllllllIIlIIIIIIIlIIIII.items[llllllllllllllllIIlIIIIIIIlIIlll];
                        llllllllllllllllIIlIIIIIIIlIllll = llllllllllllllllIIlIIIIIIIlIIIII.strings[llllllllllllllllIIlIIIIIIIlIIlll] = llllllllllllllllIIlIIIIIIIlIIIII.readUTF(llllllllllllllllIIlIIIIIIIlIlIll + 2, llllllllllllllllIIlIIIIIIIlIIIII.readUnsignedShort(llllllllllllllllIIlIIIIIIIlIlIll), llllllllllllllllIIlIIIIIIIlIIlII);
                    }
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIlIlI, llllllllllllllllIIlIIIIIIIlIllll, null, null);
                    break;
                }
                case 15: {
                    int llllllllllllllllIIlIIIIIIIlIlllI = llllllllllllllllIIlIIIIIIIlIIIII.items[llllllllllllllllIIlIIIIIIIlIIIII.readUnsignedShort(llllllllllllllllIIlIIIIIIIlIlIll + 1)];
                    int llllllllllllllllIIlIIIIIIIlIllIl = llllllllllllllllIIlIIIIIIIlIIIII.items[llllllllllllllllIIlIIIIIIIlIIIII.readUnsignedShort(llllllllllllllllIIlIIIIIIIlIlllI + 2)];
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(20 + llllllllllllllllIIlIIIIIIIlIIIII.readByte(llllllllllllllllIIlIIIIIIIlIlIll), llllllllllllllllIIlIIIIIIIlIIIII.readClass(llllllllllllllllIIlIIIIIIIlIlllI, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIllIl, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIllIl + 2, llllllllllllllllIIlIIIIIIIlIIlII));
                    break;
                }
                case 18: {
                    if (llllllllllllllllIIlIIIIIIIIlllll.bootstrapMethods == null) {
                        llllllllllllllllIIlIIIIIIIlIIIII.copyBootstrapMethods(llllllllllllllllIIlIIIIIIIIlllll, llllllllllllllllIIlIIIIIIIlIIIlI, llllllllllllllllIIlIIIIIIIlIIlII);
                    }
                    int llllllllllllllllIIlIIIIIIIlIllII = llllllllllllllllIIlIIIIIIIlIIIII.items[llllllllllllllllIIlIIIIIIIlIIIII.readUnsignedShort(llllllllllllllllIIlIIIIIIIlIlIll + 2)];
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIllII, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIllII + 2, llllllllllllllllIIlIIIIIIIlIIlII), llllllllllllllllIIlIIIIIIIlIIIII.readUnsignedShort(llllllllllllllllIIlIIIIIIIlIlIll));
                    break;
                }
                default: {
                    llllllllllllllllIIlIIIIIIIlIlIIl.set(llllllllllllllllIIlIIIIIIIlIlIlI, llllllllllllllllIIlIIIIIIIlIIIII.readUTF8(llllllllllllllllIIlIIIIIIIlIlIll, llllllllllllllllIIlIIIIIIIlIIlII), null, null);
                }
            }
            int llllllllllllllllIIlIIIIIIIlIlIII = llllllllllllllllIIlIIIIIIIlIlIIl.hashCode % llllllllllllllllIIlIIIIIIIlIIIlI.length;
            llllllllllllllllIIlIIIIIIIlIlIIl.next = llllllllllllllllIIlIIIIIIIlIIIlI[llllllllllllllllIIlIIIIIIIlIlIII];
            llllllllllllllllIIlIIIIIIIlIIIlI[llllllllllllllllIIlIIIIIIIlIlIII] = llllllllllllllllIIlIIIIIIIlIlIIl;
        }
        int llllllllllllllllIIlIIIIIIIlIIIIl = llllllllllllllllIIlIIIIIIIlIIIII.items[1] - 1;
        llllllllllllllllIIlIIIIIIIIlllll.pool.putByteArray(llllllllllllllllIIlIIIIIIIlIIIII.b, llllllllllllllllIIlIIIIIIIlIIIIl, llllllllllllllllIIlIIIIIIIlIIIII.header - llllllllllllllllIIlIIIIIIIlIIIIl);
        llllllllllllllllIIlIIIIIIIIlllll.items = llllllllllllllllIIlIIIIIIIlIIIlI;
        llllllllllllllllIIlIIIIIIIIlllll.threshold = (int)(0.75 * (double)llllllllllllllllIIlIIIIIIIlIIIll);
        llllllllllllllllIIlIIIIIIIIlllll.index = llllllllllllllllIIlIIIIIIIlIIIll;
    }

    private int readFrameType(Object[] llllllllllllllllIIIllIllIlllIIlI, int llllllllllllllllIIIllIllIlllIIII, int llllllllllllllllIIIllIllIlllllII, char[] llllllllllllllllIIIllIllIllIllIl, Label[] llllllllllllllllIIIllIllIllllIII) {
        ClassReader llllllllllllllllIIIllIlllIIIIIlI;
        int llllllllllllllllIIIllIllIlllIllI = llllllllllllllllIIIllIlllIIIIIlI.b[llllllllllllllllIIIllIllIlllllII++] & 0xFF;
        switch (llllllllllllllllIIIllIllIlllIllI) {
            case 0: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.TOP;
                break;
            }
            case 1: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.INTEGER;
                break;
            }
            case 2: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.FLOAT;
                break;
            }
            case 3: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.DOUBLE;
                break;
            }
            case 4: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.LONG;
                break;
            }
            case 5: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.NULL;
                break;
            }
            case 6: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = Opcodes.UNINITIALIZED_THIS;
                break;
            }
            case 7: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = llllllllllllllllIIIllIlllIIIIIlI.readClass(llllllllllllllllIIIllIllIlllllII, llllllllllllllllIIIllIllIllIllIl);
                llllllllllllllllIIIllIllIlllllII += 2;
                break;
            }
            default: {
                llllllllllllllllIIIllIllIlllIIlI[llllllllllllllllIIIllIllIlllIIII] = llllllllllllllllIIIllIlllIIIIIlI.readLabel(llllllllllllllllIIIllIlllIIIIIlI.readUnsignedShort(llllllllllllllllIIIllIllIlllllII), llllllllllllllllIIIllIllIllllIII);
                llllllllllllllllIIIllIllIlllllII += 2;
            }
        }
        return llllllllllllllllIIIllIllIlllllII;
    }

    private void copyBootstrapMethods(ClassWriter llllllllllllllllIIIllllllllIlllI, Item[] llllllllllllllllIIIlllllllllIllI, char[] llllllllllllllllIIIllllllllIllII) {
        ClassReader llllllllllllllllIIIllllllllIllll;
        int llllllllllllllllIIIlllllllllIlII = llllllllllllllllIIIllllllllIllll.getAttributes();
        boolean llllllllllllllllIIIlllllllllIIll = false;
        for (int llllllllllllllllIIlIIIIIIIIIIlII = llllllllllllllllIIIllllllllIllll.readUnsignedShort(llllllllllllllllIIIlllllllllIlII); llllllllllllllllIIlIIIIIIIIIIlII > 0; --llllllllllllllllIIlIIIIIIIIIIlII) {
            String llllllllllllllllIIlIIIIIIIIIIlIl = llllllllllllllllIIIllllllllIllll.readUTF8(llllllllllllllllIIIlllllllllIlII + 2, llllllllllllllllIIIllllllllIllII);
            if ("BootstrapMethods".equals(llllllllllllllllIIlIIIIIIIIIIlIl)) {
                llllllllllllllllIIIlllllllllIIll = true;
                break;
            }
            llllllllllllllllIIIlllllllllIlII += 6 + llllllllllllllllIIIllllllllIllll.readInt(llllllllllllllllIIIlllllllllIlII + 4);
        }
        if (!llllllllllllllllIIIlllllllllIIll) {
            return;
        }
        int llllllllllllllllIIIlllllllllIIlI = llllllllllllllllIIIllllllllIllll.readUnsignedShort(llllllllllllllllIIIlllllllllIlII + 8);
        int llllllllllllllllIIIllllllllllIIl = llllllllllllllllIIIlllllllllIlII + 10;
        for (int llllllllllllllllIIIllllllllllIlI = 0; llllllllllllllllIIIllllllllllIlI < llllllllllllllllIIIlllllllllIIlI; ++llllllllllllllllIIIllllllllllIlI) {
            int llllllllllllllllIIlIIIIIIIIIIIIl = llllllllllllllllIIIllllllllllIIl - llllllllllllllllIIIlllllllllIlII - 10;
            int llllllllllllllllIIlIIIIIIIIIIIII = llllllllllllllllIIIllllllllIllll.readConst(llllllllllllllllIIIllllllllIllll.readUnsignedShort(llllllllllllllllIIIllllllllllIIl), llllllllllllllllIIIllllllllIllII).hashCode();
            for (int llllllllllllllllIIlIIIIIIIIIIIll = llllllllllllllllIIIllllllllIllll.readUnsignedShort(llllllllllllllllIIIllllllllllIIl + 2); llllllllllllllllIIlIIIIIIIIIIIll > 0; --llllllllllllllllIIlIIIIIIIIIIIll) {
                llllllllllllllllIIlIIIIIIIIIIIII ^= llllllllllllllllIIIllllllllIllll.readConst(llllllllllllllllIIIllllllllIllll.readUnsignedShort(llllllllllllllllIIIllllllllllIIl + 4), llllllllllllllllIIIllllllllIllII).hashCode();
                llllllllllllllllIIIllllllllllIIl += 2;
            }
            llllllllllllllllIIIllllllllllIIl += 4;
            Item llllllllllllllllIIIllllllllllllI = new Item(llllllllllllllllIIIllllllllllIlI);
            llllllllllllllllIIIllllllllllllI.set(llllllllllllllllIIlIIIIIIIIIIIIl, llllllllllllllllIIlIIIIIIIIIIIII & Integer.MAX_VALUE);
            int llllllllllllllllIIIlllllllllllII = llllllllllllllllIIIllllllllllllI.hashCode % llllllllllllllllIIIlllllllllIllI.length;
            llllllllllllllllIIIllllllllllllI.next = llllllllllllllllIIIlllllllllIllI[llllllllllllllllIIIlllllllllllII];
            llllllllllllllllIIIlllllllllIllI[llllllllllllllllIIIlllllllllllII] = llllllllllllllllIIIllllllllllllI;
        }
        int llllllllllllllllIIIlllllllllIIIl = llllllllllllllllIIIllllllllIllll.readInt(llllllllllllllllIIIlllllllllIlII + 4);
        ByteVector llllllllllllllllIIIlllllllllIIII = new ByteVector(llllllllllllllllIIIlllllllllIIIl + 62);
        llllllllllllllllIIIlllllllllIIII.putByteArray(llllllllllllllllIIIllllllllIllll.b, llllllllllllllllIIIlllllllllIlII + 10, llllllllllllllllIIIlllllllllIIIl - 2);
        llllllllllllllllIIIllllllllIlllI.bootstrapMethodsCount = llllllllllllllllIIIlllllllllIIlI;
        llllllllllllllllIIIllllllllIlllI.bootstrapMethods = llllllllllllllllIIIlllllllllIIII;
    }

    public int getItem(int llllllllllllllllIIIllIllIIlIIllI) {
        ClassReader llllllllllllllllIIIllIllIIlIllII;
        return llllllllllllllllIIIllIllIIlIllII.items[llllllllllllllllIIIllIllIIlIIllI];
    }

    static {
        EXPAND_FRAMES = 8;
        SKIP_FRAMES = 4;
        SKIP_DEBUG = 2;
        SKIP_CODE = 1;
        ANNOTATIONS = true;
        EXPAND_ASM_INSNS = 256;
        FRAMES = true;
        WRITER = true;
        RESIZE = true;
        SIGNATURES = true;
    }

    private static byte[] readClass(InputStream llllllllllllllllIIIllllllIIllIll, boolean llllllllllllllllIIIllllllIIllIlI) throws IOException {
        if (llllllllllllllllIIIllllllIIllIll == null) {
            throw new IOException("Class not found");
        }
        try {
            byte[] llllllllllllllllIIIllllllIIlllIl = new byte[llllllllllllllllIIIllllllIIllIll.available()];
            int llllllllllllllllIIIllllllIIlllII = 0;
            while (true) {
                int llllllllllllllllIIIllllllIIllllI;
                if ((llllllllllllllllIIIllllllIIllllI = llllllllllllllllIIIllllllIIllIll.read(llllllllllllllllIIIllllllIIlllIl, llllllllllllllllIIIllllllIIlllII, llllllllllllllllIIIllllllIIlllIl.length - llllllllllllllllIIIllllllIIlllII)) == -1) {
                    byte[] llllllllllllllllIIIllllllIlIIIIl;
                    if (llllllllllllllllIIIllllllIIlllII < llllllllllllllllIIIllllllIIlllIl.length) {
                        llllllllllllllllIIIllllllIlIIIIl = new byte[llllllllllllllllIIIllllllIIlllII];
                        System.arraycopy(llllllllllllllllIIIllllllIIlllIl, 0, llllllllllllllllIIIllllllIlIIIIl, 0, llllllllllllllllIIIllllllIIlllII);
                        llllllllllllllllIIIllllllIIlllIl = llllllllllllllllIIIllllllIlIIIIl;
                    }
                    llllllllllllllllIIIllllllIlIIIIl = llllllllllllllllIIIllllllIIlllIl;
                    return llllllllllllllllIIIllllllIlIIIIl;
                }
                if ((llllllllllllllllIIIllllllIIlllII += llllllllllllllllIIIllllllIIllllI) != llllllllllllllllIIIllllllIIlllIl.length) continue;
                int llllllllllllllllIIIllllllIlIIIII = llllllllllllllllIIIllllllIIllIll.read();
                if (llllllllllllllllIIIllllllIlIIIII < 0) {
                    byte[] llllllllllllllllIIIllllllIIlIIll = llllllllllllllllIIIllllllIIlllIl;
                    return llllllllllllllllIIIllllllIIlIIll;
                }
                byte[] llllllllllllllllIIIllllllIIlllll = new byte[llllllllllllllllIIIllllllIIlllIl.length + 1000];
                System.arraycopy(llllllllllllllllIIIllllllIIlllIl, 0, llllllllllllllllIIIllllllIIlllll, 0, llllllllllllllllIIIllllllIIlllII);
                llllllllllllllllIIIllllllIIlllll[llllllllllllllllIIIllllllIIlllII++] = (byte)llllllllllllllllIIIllllllIlIIIII;
                llllllllllllllllIIIllllllIIlllIl = llllllllllllllllIIIllllllIIlllll;
            }
        }
        finally {
            if (llllllllllllllllIIIllllllIIllIlI) {
                llllllllllllllllIIIllllllIIllIll.close();
            }
        }
    }

    private int[] readTypeAnnotations(MethodVisitor llllllllllllllllIIIlllIlIlIllIlI, Context llllllllllllllllIIIlllIlIlIIlIll, int llllllllllllllllIIIlllIlIlIIlIlI, boolean llllllllllllllllIIIlllIlIlIlIlII) {
        ClassReader llllllllllllllllIIIlllIlIlIlllII;
        char[] llllllllllllllllIIIlllIlIlIlIIlI = llllllllllllllllIIIlllIlIlIIlIll.buffer;
        int[] llllllllllllllllIIIlllIlIlIlIIII = new int[llllllllllllllllIIIlllIlIlIlllII.readUnsignedShort(llllllllllllllllIIIlllIlIlIIlIlI)];
        llllllllllllllllIIIlllIlIlIIlIlI += 2;
        for (int llllllllllllllllIIIlllIlIlIllllI = 0; llllllllllllllllIIIlllIlIlIllllI < llllllllllllllllIIIlllIlIlIlIIII.length; ++llllllllllllllllIIIlllIlIlIllllI) {
            llllllllllllllllIIIlllIlIlIlIIII[llllllllllllllllIIIlllIlIlIllllI] = llllllllllllllllIIIlllIlIlIIlIlI;
            int llllllllllllllllIIIlllIlIllIIIlI = llllllllllllllllIIIlllIlIlIlllII.readInt(llllllllllllllllIIIlllIlIlIIlIlI);
            switch (llllllllllllllllIIIlllIlIllIIIlI >>> 24) {
                case 0: 
                case 1: 
                case 22: {
                    llllllllllllllllIIIlllIlIlIIlIlI += 2;
                    break;
                }
                case 19: 
                case 20: 
                case 21: {
                    ++llllllllllllllllIIIlllIlIlIIlIlI;
                    break;
                }
                case 64: 
                case 65: {
                    for (int llllllllllllllllIIIlllIlIllIIllI = llllllllllllllllIIIlllIlIlIlllII.readUnsignedShort(llllllllllllllllIIIlllIlIlIIlIlI + 1); llllllllllllllllIIIlllIlIllIIllI > 0; --llllllllllllllllIIIlllIlIllIIllI) {
                        int llllllllllllllllIIIlllIlIllIlIII = llllllllllllllllIIIlllIlIlIlllII.readUnsignedShort(llllllllllllllllIIIlllIlIlIIlIlI + 3);
                        int llllllllllllllllIIIlllIlIllIIlll = llllllllllllllllIIIlllIlIlIlllII.readUnsignedShort(llllllllllllllllIIIlllIlIlIIlIlI + 5);
                        llllllllllllllllIIIlllIlIlIlllII.readLabel(llllllllllllllllIIIlllIlIllIlIII, llllllllllllllllIIIlllIlIlIIlIll.labels);
                        llllllllllllllllIIIlllIlIlIlllII.readLabel(llllllllllllllllIIIlllIlIllIlIII + llllllllllllllllIIIlllIlIllIIlll, llllllllllllllllIIIlllIlIlIIlIll.labels);
                        llllllllllllllllIIIlllIlIlIIlIlI += 6;
                    }
                    llllllllllllllllIIIlllIlIlIIlIlI += 3;
                    break;
                }
                case 71: 
                case 72: 
                case 73: 
                case 74: 
                case 75: {
                    llllllllllllllllIIIlllIlIlIIlIlI += 4;
                    break;
                }
                default: {
                    llllllllllllllllIIIlllIlIlIIlIlI += 3;
                }
            }
            int llllllllllllllllIIIlllIlIllIIIII = llllllllllllllllIIIlllIlIlIlllII.readByte(llllllllllllllllIIIlllIlIlIIlIlI);
            if (llllllllllllllllIIIlllIlIllIIIlI >>> 24 == 66) {
                TypePath llllllllllllllllIIIlllIlIllIIlII = llllllllllllllllIIIlllIlIllIIIII == 0 ? null : new TypePath(llllllllllllllllIIIlllIlIlIlllII.b, llllllllllllllllIIIlllIlIlIIlIlI);
                llllllllllllllllIIIlllIlIlIIlIlI += 1 + 2 * llllllllllllllllIIIlllIlIllIIIII;
                llllllllllllllllIIIlllIlIlIIlIlI = llllllllllllllllIIIlllIlIlIlllII.readAnnotationValues(llllllllllllllllIIIlllIlIlIIlIlI + 2, llllllllllllllllIIIlllIlIlIlIIlI, true, llllllllllllllllIIIlllIlIlIllIlI.visitTryCatchAnnotation(llllllllllllllllIIIlllIlIllIIIlI, llllllllllllllllIIIlllIlIllIIlII, llllllllllllllllIIIlllIlIlIlllII.readUTF8(llllllllllllllllIIIlllIlIlIIlIlI, llllllllllllllllIIIlllIlIlIlIIlI), llllllllllllllllIIIlllIlIlIlIlII));
                continue;
            }
            llllllllllllllllIIIlllIlIlIIlIlI = llllllllllllllllIIIlllIlIlIlllII.readAnnotationValues(llllllllllllllllIIIlllIlIlIIlIlI + 3 + 2 * llllllllllllllllIIIlllIlIllIIIII, llllllllllllllllIIIlllIlIlIlIIlI, true, null);
        }
        return llllllllllllllllIIIlllIlIlIlIIII;
    }

    public String[] getInterfaces() {
        ClassReader llllllllllllllllIIlIIIIIIlIIIIIl;
        int llllllllllllllllIIlIIIIIIlIIIlII = llllllllllllllllIIlIIIIIIlIIIIIl.header + 6;
        int llllllllllllllllIIlIIIIIIlIIIIll = llllllllllllllllIIlIIIIIIlIIIIIl.readUnsignedShort(llllllllllllllllIIlIIIIIIlIIIlII);
        String[] llllllllllllllllIIlIIIIIIlIIIIlI = new String[llllllllllllllllIIlIIIIIIlIIIIll];
        if (llllllllllllllllIIlIIIIIIlIIIIll > 0) {
            char[] llllllllllllllllIIlIIIIIIlIIIllI = new char[llllllllllllllllIIlIIIIIIlIIIIIl.maxStringLength];
            for (int llllllllllllllllIIlIIIIIIlIIIlll = 0; llllllllllllllllIIlIIIIIIlIIIlll < llllllllllllllllIIlIIIIIIlIIIIll; ++llllllllllllllllIIlIIIIIIlIIIlll) {
                llllllllllllllllIIlIIIIIIlIIIIlI[llllllllllllllllIIlIIIIIIlIIIlll] = llllllllllllllllIIlIIIIIIlIIIIIl.readClass(llllllllllllllllIIlIIIIIIlIIIlII += 2, llllllllllllllllIIlIIIIIIlIIIllI);
            }
        }
        return llllllllllllllllIIlIIIIIIlIIIIlI;
    }

    private void getImplicitFrame(Context llllllllllllllllIIIlllIIIIIIlIlI) {
        String llllllllllllllllIIIlllIIIIIIllll = llllllllllllllllIIIlllIIIIIIlIlI.desc;
        Object[] llllllllllllllllIIIlllIIIIIIlllI = llllllllllllllllIIIlllIIIIIIlIlI.local;
        int llllllllllllllllIIIlllIIIIIIllIl = 0;
        if ((llllllllllllllllIIIlllIIIIIIlIlI.access & 8) == 0) {
            ClassReader llllllllllllllllIIIlllIIIIIlIIIl;
            llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = "<init>".equals(llllllllllllllllIIIlllIIIIIIlIlI.name) ? Opcodes.UNINITIALIZED_THIS : llllllllllllllllIIIlllIIIIIlIIIl.readClass(llllllllllllllllIIIlllIIIIIlIIIl.header + 2, llllllllllllllllIIIlllIIIIIIlIlI.buffer);
        }
        int llllllllllllllllIIIlllIIIIIIllII = 1;
        block8: while (true) {
            int llllllllllllllllIIIlllIIIIIlIIlI = llllllllllllllllIIIlllIIIIIIllII;
            switch (llllllllllllllllIIIlllIIIIIIllll.charAt(llllllllllllllllIIIlllIIIIIIllII++)) {
                case 'B': 
                case 'C': 
                case 'I': 
                case 'S': 
                case 'Z': {
                    llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = Opcodes.INTEGER;
                    continue block8;
                }
                case 'F': {
                    llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = Opcodes.FLOAT;
                    continue block8;
                }
                case 'J': {
                    llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = Opcodes.LONG;
                    continue block8;
                }
                case 'D': {
                    llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = Opcodes.DOUBLE;
                    continue block8;
                }
                case '[': {
                    while (llllllllllllllllIIIlllIIIIIIllll.charAt(llllllllllllllllIIIlllIIIIIIllII) == '[') {
                        ++llllllllllllllllIIIlllIIIIIIllII;
                    }
                    if (llllllllllllllllIIIlllIIIIIIllll.charAt(llllllllllllllllIIIlllIIIIIIllII) == 'L') {
                        ++llllllllllllllllIIIlllIIIIIIllII;
                        while (llllllllllllllllIIIlllIIIIIIllll.charAt(llllllllllllllllIIIlllIIIIIIllII) != ';') {
                            ++llllllllllllllllIIIlllIIIIIIllII;
                        }
                    }
                    llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = llllllllllllllllIIIlllIIIIIIllll.substring(llllllllllllllllIIIlllIIIIIlIIlI, ++llllllllllllllllIIIlllIIIIIIllII);
                    continue block8;
                }
                case 'L': {
                    while (llllllllllllllllIIIlllIIIIIIllll.charAt(llllllllllllllllIIIlllIIIIIIllII) != ';') {
                        ++llllllllllllllllIIIlllIIIIIIllII;
                    }
                    llllllllllllllllIIIlllIIIIIIlllI[llllllllllllllllIIIlllIIIIIIllIl++] = llllllllllllllllIIIlllIIIIIIllll.substring(llllllllllllllllIIIlllIIIIIlIIlI + 1, llllllllllllllllIIIlllIIIIIIllII++);
                    continue block8;
                }
            }
            break;
        }
        llllllllllllllllIIIlllIIIIIIlIlI.localCount = llllllllllllllllIIIlllIIIIIIllIl;
    }
}

