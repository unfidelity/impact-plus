/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.AnnotationWriter;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.CurrentFrame;
import org.spongepowered.asm.lib.Edge;
import org.spongepowered.asm.lib.Frame;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Handler;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

class MethodWriter
extends MethodVisitor {
    /* synthetic */ String signature;
    private /* synthetic */ Handler lastHandler;
    private /* synthetic */ int[] frame;
    static final /* synthetic */ int FRAMES;
    private /* synthetic */ int currentLocals;
    private /* synthetic */ Handler firstHandler;
    private /* synthetic */ ByteVector lineNumber;
    private /* synthetic */ AnnotationWriter ianns;
    private /* synthetic */ AnnotationWriter anns;
    private /* synthetic */ int maxStack;
    private /* synthetic */ int lastCodeOffset;
    private /* synthetic */ Label currentBlock;
    private /* synthetic */ AnnotationWriter[] ipanns;
    static final /* synthetic */ int FULL_FRAME;
    private /* synthetic */ AnnotationWriter ictanns;
    private /* synthetic */ int subroutines;
    private /* synthetic */ int previousFrameOffset;
    private final /* synthetic */ int desc;
    private /* synthetic */ int stackSize;
    static final /* synthetic */ int INSERTED_FRAMES;
    static final /* synthetic */ int ACC_CONSTRUCTOR;
    private /* synthetic */ ByteVector annd;
    private /* synthetic */ int frameCount;
    static final /* synthetic */ int SAME_FRAME_EXTENDED;
    private /* synthetic */ ByteVector localVar;
    private /* synthetic */ int maxLocals;
    private /* synthetic */ AnnotationWriter itanns;
    private /* synthetic */ Attribute cattrs;
    private /* synthetic */ Label previousBlock;
    private /* synthetic */ AnnotationWriter[] panns;
    private /* synthetic */ ByteVector stackMap;
    static final /* synthetic */ int CHOP_FRAME;
    private /* synthetic */ ByteVector code;
    private /* synthetic */ ByteVector methodParameters;
    /* synthetic */ int exceptionCount;
    private /* synthetic */ int maxStackSize;
    static final /* synthetic */ int SAME_FRAME;
    private /* synthetic */ int handlerCount;
    /* synthetic */ int classReaderLength;
    static final /* synthetic */ int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED;
    private /* synthetic */ Attribute attrs;
    private final /* synthetic */ String descriptor;
    private /* synthetic */ int localVarCount;
    /* synthetic */ int classReaderOffset;
    private /* synthetic */ Label labels;
    static final /* synthetic */ int RESERVED;
    static final /* synthetic */ int MAXS;
    private final /* synthetic */ int compute;
    /* synthetic */ int[] exceptions;
    private /* synthetic */ int access;
    private final /* synthetic */ int name;
    private /* synthetic */ int lineNumberCount;
    private /* synthetic */ AnnotationWriter tanns;
    static final /* synthetic */ int APPEND_FRAME;
    private /* synthetic */ int methodParametersCount;
    final /* synthetic */ ClassWriter cw;
    private /* synthetic */ int synthetics;
    private /* synthetic */ int[] previousFrame;
    static final /* synthetic */ int SAME_LOCALS_1_STACK_ITEM_FRAME;
    private /* synthetic */ ByteVector localVarType;
    private /* synthetic */ AnnotationWriter ctanns;
    private /* synthetic */ int localVarTypeCount;
    static final /* synthetic */ int NOTHING;

    final void put(ByteVector lllllllllllllllIllIlIIlllllIIIIl) {
        MethodWriter lllllllllllllllIllIlIIlllllIIIll;
        int lllllllllllllllIllIlIIlllllIIlll = 64;
        int lllllllllllllllIllIlIIlllllIIllI = 0xE0000 | (lllllllllllllllIllIlIIlllllIIIll.access & 0x40000) / 64;
        lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.access & ~lllllllllllllllIllIlIIlllllIIllI).putShort(lllllllllllllllIllIlIIlllllIIIll.name).putShort(lllllllllllllllIllIlIIlllllIIIll.desc);
        if (lllllllllllllllIllIlIIlllllIIIll.classReaderOffset != 0) {
            lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.cw.cr.b, lllllllllllllllIllIlIIlllllIIIll.classReaderOffset, lllllllllllllllIllIlIIlllllIIIll.classReaderLength);
            return;
        }
        int lllllllllllllllIllIlIIlllllIIlII = 0;
        if (lllllllllllllllIllIlIIlllllIIIll.code.length > 0) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.exceptionCount > 0) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if ((lllllllllllllllIllIlIIlllllIIIll.access & 0x1000) != 0 && ((lllllllllllllllIllIlIIlllllIIIll.cw.version & 0xFFFF) < 49 || (lllllllllllllllIllIlIIlllllIIIll.access & 0x40000) != 0)) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if ((lllllllllllllllIllIlIIlllllIIIll.access & 0x20000) != 0) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.signature != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.methodParameters != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.annd != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.anns != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.ianns != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.tanns != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.itanns != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.panns != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.ipanns != null) {
            ++lllllllllllllllIllIlIIlllllIIlII;
        }
        if (lllllllllllllllIllIlIIlllllIIIll.attrs != null) {
            lllllllllllllllIllIlIIlllllIIlII += lllllllllllllllIllIlIIlllllIIIll.attrs.getCount();
        }
        lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIlII);
        if (lllllllllllllllIllIlIIlllllIIIll.code.length > 0) {
            int lllllllllllllllIllIlIIlllllIlIll = 12 + lllllllllllllllIllIlIIlllllIIIll.code.length + 8 * lllllllllllllllIllIlIIlllllIIIll.handlerCount;
            if (lllllllllllllllIllIlIIlllllIIIll.localVar != null) {
                lllllllllllllllIllIlIIlllllIlIll += 8 + lllllllllllllllIllIlIIlllllIIIll.localVar.length;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.localVarType != null) {
                lllllllllllllllIllIlIIlllllIlIll += 8 + lllllllllllllllIllIlIIlllllIIIll.localVarType.length;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.lineNumber != null) {
                lllllllllllllllIllIlIIlllllIlIll += 8 + lllllllllllllllIllIlIIlllllIIIll.lineNumber.length;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.stackMap != null) {
                lllllllllllllllIllIlIIlllllIlIll += 8 + lllllllllllllllIllIlIIlllllIIIll.stackMap.length;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.ctanns != null) {
                lllllllllllllllIllIlIIlllllIlIll += 8 + lllllllllllllllIllIlIIlllllIIIll.ctanns.getSize();
            }
            if (lllllllllllllllIllIlIIlllllIIIll.ictanns != null) {
                lllllllllllllllIllIlIIlllllIlIll += 8 + lllllllllllllllIllIlIIlllllIIIll.ictanns.getSize();
            }
            if (lllllllllllllllIllIlIIlllllIIIll.cattrs != null) {
                lllllllllllllllIllIlIIlllllIlIll += lllllllllllllllIllIlIIlllllIIIll.cattrs.getSize(lllllllllllllllIllIlIIlllllIIIll.cw, lllllllllllllllIllIlIIlllllIIIll.code.data, lllllllllllllllIllIlIIlllllIIIll.code.length, lllllllllllllllIllIlIIlllllIIIll.maxStack, lllllllllllllllIllIlIIlllllIIIll.maxLocals);
            }
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("Code")).putInt(lllllllllllllllIllIlIIlllllIlIll);
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.maxStack).putShort(lllllllllllllllIllIlIIlllllIIIll.maxLocals);
            lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.code.length).putByteArray(lllllllllllllllIllIlIIlllllIIIll.code.data, 0, lllllllllllllllIllIlIIlllllIIIll.code.length);
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.handlerCount);
            if (lllllllllllllllIllIlIIlllllIIIll.handlerCount > 0) {
                Handler lllllllllllllllIllIlIIlllllIllIl = lllllllllllllllIllIlIIlllllIIIll.firstHandler;
                while (lllllllllllllllIllIlIIlllllIllIl != null) {
                    lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIllIl.start.position).putShort(lllllllllllllllIllIlIIlllllIllIl.end.position).putShort(lllllllllllllllIllIlIIlllllIllIl.handler.position).putShort(lllllllllllllllIllIlIIlllllIllIl.type);
                    lllllllllllllllIllIlIIlllllIllIl = lllllllllllllllIllIlIIlllllIllIl.next;
                }
            }
            lllllllllllllllIllIlIIlllllIIlII = 0;
            if (lllllllllllllllIllIlIIlllllIIIll.localVar != null) {
                ++lllllllllllllllIllIlIIlllllIIlII;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.localVarType != null) {
                ++lllllllllllllllIllIlIIlllllIIlII;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.lineNumber != null) {
                ++lllllllllllllllIllIlIIlllllIIlII;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.stackMap != null) {
                ++lllllllllllllllIllIlIIlllllIIlII;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.ctanns != null) {
                ++lllllllllllllllIllIlIIlllllIIlII;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.ictanns != null) {
                ++lllllllllllllllIllIlIIlllllIIlII;
            }
            if (lllllllllllllllIllIlIIlllllIIIll.cattrs != null) {
                lllllllllllllllIllIlIIlllllIIlII += lllllllllllllllIllIlIIlllllIIIll.cattrs.getCount();
            }
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIlII);
            if (lllllllllllllllIllIlIIlllllIIIll.localVar != null) {
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("LocalVariableTable"));
                lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.localVar.length + 2).putShort(lllllllllllllllIllIlIIlllllIIIll.localVarCount);
                lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.localVar.data, 0, lllllllllllllllIllIlIIlllllIIIll.localVar.length);
            }
            if (lllllllllllllllIllIlIIlllllIIIll.localVarType != null) {
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("LocalVariableTypeTable"));
                lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.localVarType.length + 2).putShort(lllllllllllllllIllIlIIlllllIIIll.localVarTypeCount);
                lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.localVarType.data, 0, lllllllllllllllIllIlIIlllllIIIll.localVarType.length);
            }
            if (lllllllllllllllIllIlIIlllllIIIll.lineNumber != null) {
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("LineNumberTable"));
                lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.lineNumber.length + 2).putShort(lllllllllllllllIllIlIIlllllIIIll.lineNumberCount);
                lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.lineNumber.data, 0, lllllllllllllllIllIlIIlllllIIIll.lineNumber.length);
            }
            if (lllllllllllllllIllIlIIlllllIIIll.stackMap != null) {
                boolean lllllllllllllllIllIlIIlllllIllII = (lllllllllllllllIllIlIIlllllIIIll.cw.version & 0xFFFF) >= 50;
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8(lllllllllllllllIllIlIIlllllIllII ? "StackMapTable" : "StackMap"));
                lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.stackMap.length + 2).putShort(lllllllllllllllIllIlIIlllllIIIll.frameCount);
                lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.stackMap.data, 0, lllllllllllllllIllIlIIlllllIIIll.stackMap.length);
            }
            if (lllllllllllllllIllIlIIlllllIIIll.ctanns != null) {
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeVisibleTypeAnnotations"));
                lllllllllllllllIllIlIIlllllIIIll.ctanns.put(lllllllllllllllIllIlIIlllllIIIIl);
            }
            if (lllllllllllllllIllIlIIlllllIIIll.ictanns != null) {
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeInvisibleTypeAnnotations"));
                lllllllllllllllIllIlIIlllllIIIll.ictanns.put(lllllllllllllllIllIlIIlllllIIIIl);
            }
            if (lllllllllllllllIllIlIIlllllIIIll.cattrs != null) {
                lllllllllllllllIllIlIIlllllIIIll.cattrs.put(lllllllllllllllIllIlIIlllllIIIll.cw, lllllllllllllllIllIlIIlllllIIIll.code.data, lllllllllllllllIllIlIIlllllIIIll.code.length, lllllllllllllllIllIlIIlllllIIIll.maxLocals, lllllllllllllllIllIlIIlllllIIIll.maxStack, lllllllllllllllIllIlIIlllllIIIIl);
            }
        }
        if (lllllllllllllllIllIlIIlllllIIIll.exceptionCount > 0) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("Exceptions")).putInt(2 * lllllllllllllllIllIlIIlllllIIIll.exceptionCount + 2);
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.exceptionCount);
            for (int lllllllllllllllIllIlIIlllllIlIlI = 0; lllllllllllllllIllIlIIlllllIlIlI < lllllllllllllllIllIlIIlllllIIIll.exceptionCount; ++lllllllllllllllIllIlIIlllllIlIlI) {
                lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.exceptions[lllllllllllllllIllIlIIlllllIlIlI]);
            }
        }
        if ((lllllllllllllllIllIlIIlllllIIIll.access & 0x1000) != 0 && ((lllllllllllllllIllIlIIlllllIIIll.cw.version & 0xFFFF) < 49 || (lllllllllllllllIllIlIIlllllIIIll.access & 0x40000) != 0)) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("Synthetic")).putInt(0);
        }
        if ((lllllllllllllllIllIlIIlllllIIIll.access & 0x20000) != 0) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("Deprecated")).putInt(0);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.signature != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("Signature")).putInt(2).putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8(lllllllllllllllIllIlIIlllllIIIll.signature));
        }
        if (lllllllllllllllIllIlIIlllllIIIll.methodParameters != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("MethodParameters"));
            lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.methodParameters.length + 1).putByte(lllllllllllllllIllIlIIlllllIIIll.methodParametersCount);
            lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.methodParameters.data, 0, lllllllllllllllIllIlIIlllllIIIll.methodParameters.length);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.annd != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("AnnotationDefault"));
            lllllllllllllllIllIlIIlllllIIIIl.putInt(lllllllllllllllIllIlIIlllllIIIll.annd.length);
            lllllllllllllllIllIlIIlllllIIIIl.putByteArray(lllllllllllllllIllIlIIlllllIIIll.annd.data, 0, lllllllllllllllIllIlIIlllllIIIll.annd.length);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.anns != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeVisibleAnnotations"));
            lllllllllllllllIllIlIIlllllIIIll.anns.put(lllllllllllllllIllIlIIlllllIIIIl);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.ianns != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeInvisibleAnnotations"));
            lllllllllllllllIllIlIIlllllIIIll.ianns.put(lllllllllllllllIllIlIIlllllIIIIl);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.tanns != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeVisibleTypeAnnotations"));
            lllllllllllllllIllIlIIlllllIIIll.tanns.put(lllllllllllllllIllIlIIlllllIIIIl);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.itanns != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeInvisibleTypeAnnotations"));
            lllllllllllllllIllIlIIlllllIIIll.itanns.put(lllllllllllllllIllIlIIlllllIIIIl);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.panns != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeVisibleParameterAnnotations"));
            AnnotationWriter.put(lllllllllllllllIllIlIIlllllIIIll.panns, lllllllllllllllIllIlIIlllllIIIll.synthetics, lllllllllllllllIllIlIIlllllIIIIl);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.ipanns != null) {
            lllllllllllllllIllIlIIlllllIIIIl.putShort(lllllllllllllllIllIlIIlllllIIIll.cw.newUTF8("RuntimeInvisibleParameterAnnotations"));
            AnnotationWriter.put(lllllllllllllllIllIlIIlllllIIIll.ipanns, lllllllllllllllIllIlIIlllllIIIll.synthetics, lllllllllllllllIllIlIIlllllIIIIl);
        }
        if (lllllllllllllllIllIlIIlllllIIIll.attrs != null) {
            lllllllllllllllIllIlIIlllllIIIll.attrs.put(lllllllllllllllIllIlIIlllllIIIll.cw, null, 0, -1, -1, lllllllllllllllIllIlIIlllllIIIIl);
        }
    }

    public void visitTryCatchBlock(Label lllllllllllllllIllIlIlIlIllIIllI, Label lllllllllllllllIllIlIlIlIllIlIll, Label lllllllllllllllIllIlIlIlIllIIlII, String lllllllllllllllIllIlIlIlIllIlIIl) {
        MethodWriter lllllllllllllllIllIlIlIlIllIllIl;
        ++lllllllllllllllIllIlIlIlIllIllIl.handlerCount;
        Handler lllllllllllllllIllIlIlIlIllIlIII = new Handler();
        lllllllllllllllIllIlIlIlIllIlIII.start = lllllllllllllllIllIlIlIlIllIIllI;
        lllllllllllllllIllIlIlIlIllIlIII.end = lllllllllllllllIllIlIlIlIllIlIll;
        lllllllllllllllIllIlIlIlIllIlIII.handler = lllllllllllllllIllIlIlIlIllIIlII;
        lllllllllllllllIllIlIlIlIllIlIII.desc = lllllllllllllllIllIlIlIlIllIlIIl;
        int n = lllllllllllllllIllIlIlIlIllIlIII.type = lllllllllllllllIllIlIlIlIllIlIIl != null ? lllllllllllllllIllIlIlIlIllIllIl.cw.newClass(lllllllllllllllIllIlIlIlIllIlIIl) : 0;
        if (lllllllllllllllIllIlIlIlIllIllIl.lastHandler == null) {
            lllllllllllllllIllIlIlIlIllIllIl.firstHandler = lllllllllllllllIllIlIlIlIllIlIII;
        } else {
            lllllllllllllllIllIlIlIlIllIllIl.lastHandler.next = lllllllllllllllIllIlIlIlIllIlIII;
        }
        lllllllllllllllIllIlIlIlIllIllIl.lastHandler = lllllllllllllllIllIlIlIlIllIlIII;
    }

    public AnnotationVisitor visitAnnotation(String lllllllllllllllIllIlIllIllIIlIlI, boolean lllllllllllllllIllIlIllIllIIlllI) {
        MethodWriter lllllllllllllllIllIlIllIllIIlIll;
        ByteVector lllllllllllllllIllIlIllIllIIllIl = new ByteVector();
        lllllllllllllllIllIlIllIllIIllIl.putShort(lllllllllllllllIllIlIllIllIIlIll.cw.newUTF8(lllllllllllllllIllIlIllIllIIlIlI)).putShort(0);
        AnnotationWriter lllllllllllllllIllIlIllIllIIllII = new AnnotationWriter(lllllllllllllllIllIlIllIllIIlIll.cw, true, lllllllllllllllIllIlIllIllIIllIl, lllllllllllllllIllIlIllIllIIllIl, 2);
        if (lllllllllllllllIllIlIllIllIIlllI) {
            lllllllllllllllIllIlIllIllIIllII.next = lllllllllllllllIllIlIllIllIIlIll.anns;
            lllllllllllllllIllIlIllIllIIlIll.anns = lllllllllllllllIllIlIllIllIIllII;
        } else {
            lllllllllllllllIllIlIllIllIIllII.next = lllllllllllllllIllIlIllIllIIlIll.ianns;
            lllllllllllllllIllIlIllIllIIlIll.ianns = lllllllllllllllIllIlIllIllIIllII;
        }
        return lllllllllllllllIllIlIllIllIIllII;
    }

    private void writeFrameTypes(int lllllllllllllllIllIlIlIIIlIIlIlI, int lllllllllllllllIllIlIlIIIlIIllII) {
        for (int lllllllllllllllIllIlIlIIIlIIllll = lllllllllllllllIllIlIlIIIlIIlIlI; lllllllllllllllIllIlIlIIIlIIllll < lllllllllllllllIllIlIlIIIlIIllII; ++lllllllllllllllIllIlIlIIIlIIllll) {
            MethodWriter lllllllllllllllIllIlIlIIIlIIlIll;
            int lllllllllllllllIllIlIlIIIlIlIIIl = lllllllllllllllIllIlIlIIIlIIlIll.frame[lllllllllllllllIllIlIlIIIlIIllll];
            int lllllllllllllllIllIlIlIIIlIlIIII = lllllllllllllllIllIlIlIIIlIlIIIl & 0xF0000000;
            if (lllllllllllllllIllIlIlIIIlIlIIII == 0) {
                int lllllllllllllllIllIlIlIIIlIlIIll = lllllllllllllllIllIlIlIIIlIlIIIl & 0xFFFFF;
                switch (lllllllllllllllIllIlIlIIIlIlIIIl & 0xFF00000) {
                    case 0x1700000: {
                        lllllllllllllllIllIlIlIIIlIIlIll.stackMap.putByte(7).putShort(lllllllllllllllIllIlIlIIIlIIlIll.cw.newClass(lllllllllllllllIllIlIlIIIlIIlIll.cw.typeTable[lllllllllllllllIllIlIlIIIlIlIIll].strVal1));
                        break;
                    }
                    case 0x1800000: {
                        lllllllllllllllIllIlIlIIIlIIlIll.stackMap.putByte(8).putShort(lllllllllllllllIllIlIlIIIlIIlIll.cw.typeTable[lllllllllllllllIllIlIlIIIlIlIIll].intVal);
                        break;
                    }
                    default: {
                        lllllllllllllllIllIlIlIIIlIIlIll.stackMap.putByte(lllllllllllllllIllIlIlIIIlIlIIll);
                        break;
                    }
                }
                continue;
            }
            StringBuilder lllllllllllllllIllIlIlIIIlIlIIlI = new StringBuilder();
            lllllllllllllllIllIlIlIIIlIlIIII >>= 28;
            while (lllllllllllllllIllIlIlIIIlIlIIII-- > 0) {
                lllllllllllllllIllIlIlIIIlIlIIlI.append('[');
            }
            if ((lllllllllllllllIllIlIlIIIlIlIIIl & 0xFF00000) == 0x1700000) {
                lllllllllllllllIllIlIlIIIlIlIIlI.append('L');
                lllllllllllllllIllIlIlIIIlIlIIlI.append(lllllllllllllllIllIlIlIIIlIIlIll.cw.typeTable[lllllllllllllllIllIlIlIIIlIlIIIl & 0xFFFFF].strVal1);
                lllllllllllllllIllIlIlIIIlIlIIlI.append(';');
            } else {
                switch (lllllllllllllllIllIlIlIIIlIlIIIl & 0xF) {
                    case 1: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('I');
                        break;
                    }
                    case 2: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('F');
                        break;
                    }
                    case 3: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('D');
                        break;
                    }
                    case 9: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('Z');
                        break;
                    }
                    case 10: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('B');
                        break;
                    }
                    case 11: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('C');
                        break;
                    }
                    case 12: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('S');
                        break;
                    }
                    default: {
                        lllllllllllllllIllIlIlIIIlIlIIlI.append('J');
                    }
                }
            }
            lllllllllllllllIllIlIlIIIlIIlIll.stackMap.putByte(7).putShort(lllllllllllllllIllIlIlIIIlIIlIll.cw.newClass(String.valueOf(lllllllllllllllIllIlIlIIIlIlIIlI)));
        }
    }

    public void visitInsn(int lllllllllllllllIllIlIllIIlllIIll) {
        MethodWriter lllllllllllllllIllIlIllIIlllIllI;
        lllllllllllllllIllIlIllIIlllIllI.lastCodeOffset = lllllllllllllllIllIlIllIIlllIllI.code.length;
        lllllllllllllllIllIlIllIIlllIllI.code.putByte(lllllllllllllllIllIlIllIIlllIIll);
        if (lllllllllllllllIllIlIllIIlllIllI.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIlllIllI.compute == 0 || lllllllllllllllIllIlIllIIlllIllI.compute == 1) {
                lllllllllllllllIllIlIllIIlllIllI.currentBlock.frame.execute(lllllllllllllllIllIlIllIIlllIIll, 0, null, null);
            } else {
                int lllllllllllllllIllIlIllIIlllIlll = lllllllllllllllIllIlIllIIlllIllI.stackSize + Frame.SIZE[lllllllllllllllIllIlIllIIlllIIll];
                if (lllllllllllllllIllIlIllIIlllIlll > lllllllllllllllIllIlIllIIlllIllI.maxStackSize) {
                    lllllllllllllllIllIlIllIIlllIllI.maxStackSize = lllllllllllllllIllIlIllIIlllIlll;
                }
                lllllllllllllllIllIlIllIIlllIllI.stackSize = lllllllllllllllIllIlIllIIlllIlll;
            }
            if (lllllllllllllllIllIlIllIIlllIIll >= 172 && lllllllllllllllIllIlIllIIlllIIll <= 177 || lllllllllllllllIllIlIllIIlllIIll == 191) {
                lllllllllllllllIllIlIllIIlllIllI.noSuccessor();
            }
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int lllllllllllllllIllIlIlIlIllllIIl, TypePath lllllllllllllllIllIlIlIlIllllIII, String lllllllllllllllIllIlIlIlIlllIlll, boolean lllllllllllllllIllIlIlIlIlllllIl) {
        MethodWriter lllllllllllllllIllIlIlIlIllllIlI;
        ByteVector lllllllllllllllIllIlIlIlIlllllII = new ByteVector();
        lllllllllllllllIllIlIlIlIllllIIl = lllllllllllllllIllIlIlIlIllllIIl & 0xFF0000FF | lllllllllllllllIllIlIlIlIllllIlI.lastCodeOffset << 8;
        AnnotationWriter.putTarget(lllllllllllllllIllIlIlIlIllllIIl, lllllllllllllllIllIlIlIlIllllIII, lllllllllllllllIllIlIlIlIlllllII);
        lllllllllllllllIllIlIlIlIlllllII.putShort(lllllllllllllllIllIlIlIlIllllIlI.cw.newUTF8(lllllllllllllllIllIlIlIlIlllIlll)).putShort(0);
        AnnotationWriter lllllllllllllllIllIlIlIlIllllIll = new AnnotationWriter(lllllllllllllllIllIlIlIlIllllIlI.cw, true, lllllllllllllllIllIlIlIlIlllllII, lllllllllllllllIllIlIlIlIlllllII, lllllllllllllllIllIlIlIlIlllllII.length - 2);
        if (lllllllllllllllIllIlIlIlIlllllIl) {
            lllllllllllllllIllIlIlIlIllllIll.next = lllllllllllllllIllIlIlIlIllllIlI.ctanns;
            lllllllllllllllIllIlIlIlIllllIlI.ctanns = lllllllllllllllIllIlIlIlIllllIll;
        } else {
            lllllllllllllllIllIlIlIlIllllIll.next = lllllllllllllllIllIlIlIlIllllIlI.ictanns;
            lllllllllllllllIllIlIlIlIllllIlI.ictanns = lllllllllllllllIllIlIlIlIllllIll;
        }
        return lllllllllllllllIllIlIlIlIllllIll;
    }

    public void visitInvokeDynamicInsn(String lllllllllllllllIllIlIllIIIIIIlIl, String lllllllllllllllIllIlIllIIIIIIlII, Handle lllllllllllllllIllIlIllIIIIIIIll, Object ... lllllllllllllllIllIlIlIllllllIll) {
        MethodWriter lllllllllllllllIllIlIllIIIIIIllI;
        lllllllllllllllIllIlIllIIIIIIllI.lastCodeOffset = lllllllllllllllIllIlIllIIIIIIllI.code.length;
        Item lllllllllllllllIllIlIllIIIIIIIIl = lllllllllllllllIllIlIllIIIIIIllI.cw.newInvokeDynamicItem(lllllllllllllllIllIlIllIIIIIIlIl, lllllllllllllllIllIlIllIIIIIIlII, lllllllllllllllIllIlIllIIIIIIIll, lllllllllllllllIllIlIlIllllllIll);
        int lllllllllllllllIllIlIllIIIIIIIII = lllllllllllllllIllIlIllIIIIIIIIl.intVal;
        if (lllllllllllllllIllIlIllIIIIIIllI.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIIIIIllI.compute == 0 || lllllllllllllllIllIlIllIIIIIIllI.compute == 1) {
                lllllllllllllllIllIlIllIIIIIIllI.currentBlock.frame.execute(186, 0, lllllllllllllllIllIlIllIIIIIIllI.cw, lllllllllllllllIllIlIllIIIIIIIIl);
            } else {
                int lllllllllllllllIllIlIllIIIIIIlll;
                if (lllllllllllllllIllIlIllIIIIIIIII == 0) {
                    lllllllllllllllIllIlIllIIIIIIIIl.intVal = lllllllllllllllIllIlIllIIIIIIIII = Type.getArgumentsAndReturnSizes(lllllllllllllllIllIlIllIIIIIIlII);
                }
                if ((lllllllllllllllIllIlIllIIIIIIlll = lllllllllllllllIllIlIllIIIIIIllI.stackSize - (lllllllllllllllIllIlIllIIIIIIIII >> 2) + (lllllllllllllllIllIlIllIIIIIIIII & 3) + 1) > lllllllllllllllIllIlIllIIIIIIllI.maxStackSize) {
                    lllllllllllllllIllIlIllIIIIIIllI.maxStackSize = lllllllllllllllIllIlIllIIIIIIlll;
                }
                lllllllllllllllIllIlIllIIIIIIllI.stackSize = lllllllllllllllIllIlIllIIIIIIlll;
            }
        }
        lllllllllllllllIllIlIllIIIIIIllI.code.put12(186, lllllllllllllllIllIlIllIIIIIIIIl.index);
        lllllllllllllllIllIlIllIIIIIIllI.code.putShort(0);
    }

    final int getSize() {
        MethodWriter lllllllllllllllIllIlIlIIIIllIllI;
        if (lllllllllllllllIllIlIlIIIIllIllI.classReaderOffset != 0) {
            return 6 + lllllllllllllllIllIlIlIIIIllIllI.classReaderLength;
        }
        int lllllllllllllllIllIlIlIIIIllIlll = 8;
        if (lllllllllllllllIllIlIlIIIIllIllI.code.length > 0) {
            if (lllllllllllllllIllIlIlIIIIllIllI.code.length > 65535) {
                throw new RuntimeException("Method code too large!");
            }
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("Code");
            lllllllllllllllIllIlIlIIIIllIlll += 18 + lllllllllllllllIllIlIlIIIIllIllI.code.length + 8 * lllllllllllllllIllIlIlIIIIllIllI.handlerCount;
            if (lllllllllllllllIllIlIlIIIIllIllI.localVar != null) {
                lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("LocalVariableTable");
                lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.localVar.length;
            }
            if (lllllllllllllllIllIlIlIIIIllIllI.localVarType != null) {
                lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("LocalVariableTypeTable");
                lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.localVarType.length;
            }
            if (lllllllllllllllIllIlIlIIIIllIllI.lineNumber != null) {
                lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("LineNumberTable");
                lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.lineNumber.length;
            }
            if (lllllllllllllllIllIlIlIIIIllIllI.stackMap != null) {
                boolean lllllllllllllllIllIlIlIIIIlllIll = (lllllllllllllllIllIlIlIIIIllIllI.cw.version & 0xFFFF) >= 50;
                lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8(lllllllllllllllIllIlIlIIIIlllIll ? "StackMapTable" : "StackMap");
                lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.stackMap.length;
            }
            if (lllllllllllllllIllIlIlIIIIllIllI.ctanns != null) {
                lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeVisibleTypeAnnotations");
                lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.ctanns.getSize();
            }
            if (lllllllllllllllIllIlIlIIIIllIllI.ictanns != null) {
                lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeInvisibleTypeAnnotations");
                lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.ictanns.getSize();
            }
            if (lllllllllllllllIllIlIlIIIIllIllI.cattrs != null) {
                lllllllllllllllIllIlIlIIIIllIlll += lllllllllllllllIllIlIlIIIIllIllI.cattrs.getSize(lllllllllllllllIllIlIlIIIIllIllI.cw, lllllllllllllllIllIlIlIIIIllIllI.code.data, lllllllllllllllIllIlIlIIIIllIllI.code.length, lllllllllllllllIllIlIlIIIIllIllI.maxStack, lllllllllllllllIllIlIlIIIIllIllI.maxLocals);
            }
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.exceptionCount > 0) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("Exceptions");
            lllllllllllllllIllIlIlIIIIllIlll += 8 + 2 * lllllllllllllllIllIlIlIIIIllIllI.exceptionCount;
        }
        if ((lllllllllllllllIllIlIlIIIIllIllI.access & 0x1000) != 0 && ((lllllllllllllllIllIlIlIIIIllIllI.cw.version & 0xFFFF) < 49 || (lllllllllllllllIllIlIlIIIIllIllI.access & 0x40000) != 0)) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("Synthetic");
            lllllllllllllllIllIlIlIIIIllIlll += 6;
        }
        if ((lllllllllllllllIllIlIlIIIIllIllI.access & 0x20000) != 0) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("Deprecated");
            lllllllllllllllIllIlIlIIIIllIlll += 6;
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.signature != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("Signature");
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8(lllllllllllllllIllIlIlIIIIllIllI.signature);
            lllllllllllllllIllIlIlIIIIllIlll += 8;
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.methodParameters != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("MethodParameters");
            lllllllllllllllIllIlIlIIIIllIlll += 7 + lllllllllllllllIllIlIlIIIIllIllI.methodParameters.length;
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.annd != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("AnnotationDefault");
            lllllllllllllllIllIlIlIIIIllIlll += 6 + lllllllllllllllIllIlIlIIIIllIllI.annd.length;
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.anns != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeVisibleAnnotations");
            lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.anns.getSize();
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.ianns != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeInvisibleAnnotations");
            lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.ianns.getSize();
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.tanns != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeVisibleTypeAnnotations");
            lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.tanns.getSize();
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.itanns != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeInvisibleTypeAnnotations");
            lllllllllllllllIllIlIlIIIIllIlll += 8 + lllllllllllllllIllIlIlIIIIllIllI.itanns.getSize();
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.panns != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeVisibleParameterAnnotations");
            lllllllllllllllIllIlIlIIIIllIlll += 7 + 2 * (lllllllllllllllIllIlIlIIIIllIllI.panns.length - lllllllllllllllIllIlIlIIIIllIllI.synthetics);
            for (int lllllllllllllllIllIlIlIIIIlllIlI = lllllllllllllllIllIlIlIIIIllIllI.panns.length - 1; lllllllllllllllIllIlIlIIIIlllIlI >= lllllllllllllllIllIlIlIIIIllIllI.synthetics; --lllllllllllllllIllIlIlIIIIlllIlI) {
                lllllllllllllllIllIlIlIIIIllIlll += lllllllllllllllIllIlIlIIIIllIllI.panns[lllllllllllllllIllIlIlIIIIlllIlI] == null ? 0 : lllllllllllllllIllIlIlIIIIllIllI.panns[lllllllllllllllIllIlIlIIIIlllIlI].getSize();
            }
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.ipanns != null) {
            lllllllllllllllIllIlIlIIIIllIllI.cw.newUTF8("RuntimeInvisibleParameterAnnotations");
            lllllllllllllllIllIlIlIIIIllIlll += 7 + 2 * (lllllllllllllllIllIlIlIIIIllIllI.ipanns.length - lllllllllllllllIllIlIlIIIIllIllI.synthetics);
            for (int lllllllllllllllIllIlIlIIIIlllIIl = lllllllllllllllIllIlIlIIIIllIllI.ipanns.length - 1; lllllllllllllllIllIlIlIIIIlllIIl >= lllllllllllllllIllIlIlIIIIllIllI.synthetics; --lllllllllllllllIllIlIlIIIIlllIIl) {
                lllllllllllllllIllIlIlIIIIllIlll += lllllllllllllllIllIlIlIIIIllIllI.ipanns[lllllllllllllllIllIlIlIIIIlllIIl] == null ? 0 : lllllllllllllllIllIlIlIIIIllIllI.ipanns[lllllllllllllllIllIlIlIIIIlllIIl].getSize();
            }
        }
        if (lllllllllllllllIllIlIlIIIIllIllI.attrs != null) {
            lllllllllllllllIllIlIlIIIIllIlll += lllllllllllllllIllIlIlIIIIllIllI.attrs.getSize(lllllllllllllllIllIlIlIIIIllIllI.cw, null, 0, -1, -1);
        }
        return lllllllllllllllIllIlIlIIIIllIlll;
    }

    public void visitTableSwitchInsn(int lllllllllllllllIllIlIlIllIlllIIl, int lllllllllllllllIllIlIlIllIlllllI, Label lllllllllllllllIllIlIlIllIllIlll, Label ... lllllllllllllllIllIlIlIllIllIllI) {
        MethodWriter lllllllllllllllIllIlIlIlllIIIIII;
        lllllllllllllllIllIlIlIlllIIIIII.lastCodeOffset = lllllllllllllllIllIlIlIlllIIIIII.code.length;
        int lllllllllllllllIllIlIlIllIlllIll = lllllllllllllllIllIlIlIlllIIIIII.code.length;
        lllllllllllllllIllIlIlIlllIIIIII.code.putByte(170);
        lllllllllllllllIllIlIlIlllIIIIII.code.putByteArray(null, 0, (4 - lllllllllllllllIllIlIlIlllIIIIII.code.length % 4) % 4);
        lllllllllllllllIllIlIlIllIllIlll.put(lllllllllllllllIllIlIlIlllIIIIII, lllllllllllllllIllIlIlIlllIIIIII.code, lllllllllllllllIllIlIlIllIlllIll, true);
        lllllllllllllllIllIlIlIlllIIIIII.code.putInt(lllllllllllllllIllIlIlIllIlllIIl).putInt(lllllllllllllllIllIlIlIllIlllllI);
        for (int lllllllllllllllIllIlIlIlllIIIIIl = 0; lllllllllllllllIllIlIlIlllIIIIIl < lllllllllllllllIllIlIlIllIllIllI.length; ++lllllllllllllllIllIlIlIlllIIIIIl) {
            lllllllllllllllIllIlIlIllIllIllI[lllllllllllllllIllIlIlIlllIIIIIl].put(lllllllllllllllIllIlIlIlllIIIIII, lllllllllllllllIllIlIlIlllIIIIII.code, lllllllllllllllIllIlIlIllIlllIll, true);
        }
        lllllllllllllllIllIlIlIlllIIIIII.visitSwitchInsn(lllllllllllllllIllIlIlIllIllIlll, lllllllllllllllIllIlIlIllIllIllI);
    }

    private void visitFrame(Frame lllllllllllllllIllIlIlIIlIIlllIl) {
        MethodWriter lllllllllllllllIllIlIlIIlIIllllI;
        int lllllllllllllllIllIlIlIIlIlIIlIl;
        int lllllllllllllllIllIlIlIIlIlIIlII = 0;
        int lllllllllllllllIllIlIlIIlIlIIIll = 0;
        int lllllllllllllllIllIlIlIIlIlIIIlI = 0;
        int[] lllllllllllllllIllIlIlIIlIlIIIIl = lllllllllllllllIllIlIlIIlIIlllIl.inputLocals;
        int[] lllllllllllllllIllIlIlIIlIlIIIII = lllllllllllllllIllIlIlIIlIIlllIl.inputStack;
        for (lllllllllllllllIllIlIlIIlIlIIlIl = 0; lllllllllllllllIllIlIlIIlIlIIlIl < lllllllllllllllIllIlIlIIlIlIIIIl.length; ++lllllllllllllllIllIlIlIIlIlIIlIl) {
            int lllllllllllllllIllIlIlIIlIlIlIll = lllllllllllllllIllIlIlIIlIlIIIIl[lllllllllllllllIllIlIlIIlIlIIlIl];
            if (lllllllllllllllIllIlIlIIlIlIlIll == 0x1000000) {
                ++lllllllllllllllIllIlIlIIlIlIIlII;
            } else {
                lllllllllllllllIllIlIlIIlIlIIIll += lllllllllllllllIllIlIlIIlIlIIlII + 1;
                lllllllllllllllIllIlIlIIlIlIIlII = 0;
            }
            if (lllllllllllllllIllIlIlIIlIlIlIll != 0x1000004 && lllllllllllllllIllIlIlIIlIlIlIll != 0x1000003) continue;
            ++lllllllllllllllIllIlIlIIlIlIIlIl;
        }
        for (lllllllllllllllIllIlIlIIlIlIIlIl = 0; lllllllllllllllIllIlIlIIlIlIIlIl < lllllllllllllllIllIlIlIIlIlIIIII.length; ++lllllllllllllllIllIlIlIIlIlIIlIl) {
            int lllllllllllllllIllIlIlIIlIlIlIlI = lllllllllllllllIllIlIlIIlIlIIIII[lllllllllllllllIllIlIlIIlIlIIlIl];
            ++lllllllllllllllIllIlIlIIlIlIIIlI;
            if (lllllllllllllllIllIlIlIIlIlIlIlI != 0x1000004 && lllllllllllllllIllIlIlIIlIlIlIlI != 0x1000003) continue;
            ++lllllllllllllllIllIlIlIIlIlIIlIl;
        }
        int lllllllllllllllIllIlIlIIlIIlllll = lllllllllllllllIllIlIlIIlIIllllI.startFrame(lllllllllllllllIllIlIlIIlIIlllIl.owner.position, lllllllllllllllIllIlIlIIlIlIIIll, lllllllllllllllIllIlIlIIlIlIIIlI);
        lllllllllllllllIllIlIlIIlIlIIlIl = 0;
        while (lllllllllllllllIllIlIlIIlIlIIIll > 0) {
            int lllllllllllllllIllIlIlIIlIlIlIIl = lllllllllllllllIllIlIlIIlIlIIIIl[lllllllllllllllIllIlIlIIlIlIIlIl];
            lllllllllllllllIllIlIlIIlIIllllI.frame[lllllllllllllllIllIlIlIIlIIlllll++] = lllllllllllllllIllIlIlIIlIlIlIIl;
            if (lllllllllllllllIllIlIlIIlIlIlIIl == 0x1000004 || lllllllllllllllIllIlIlIIlIlIlIIl == 0x1000003) {
                ++lllllllllllllllIllIlIlIIlIlIIlIl;
            }
            ++lllllllllllllllIllIlIlIIlIlIIlIl;
            --lllllllllllllllIllIlIlIIlIlIIIll;
        }
        for (lllllllllllllllIllIlIlIIlIlIIlIl = 0; lllllllllllllllIllIlIlIIlIlIIlIl < lllllllllllllllIllIlIlIIlIlIIIII.length; ++lllllllllllllllIllIlIlIIlIlIIlIl) {
            int lllllllllllllllIllIlIlIIlIlIlIII = lllllllllllllllIllIlIlIIlIlIIIII[lllllllllllllllIllIlIlIIlIlIIlIl];
            lllllllllllllllIllIlIlIIlIIllllI.frame[lllllllllllllllIllIlIlIIlIIlllll++] = lllllllllllllllIllIlIlIIlIlIlIII;
            if (lllllllllllllllIllIlIlIIlIlIlIII != 0x1000004 && lllllllllllllllIllIlIlIIlIlIlIII != 0x1000003) continue;
            ++lllllllllllllllIllIlIlIIlIlIIlIl;
        }
        lllllllllllllllIllIlIlIIlIIllllI.endFrame();
    }

    public void visitLdcInsn(Object lllllllllllllllIllIlIlIlllIlIlll) {
        MethodWriter lllllllllllllllIllIlIlIlllIllIII;
        lllllllllllllllIllIlIlIlllIllIII.lastCodeOffset = lllllllllllllllIllIlIlIlllIllIII.code.length;
        Item lllllllllllllllIllIlIlIlllIllIlI = lllllllllllllllIllIlIlIlllIllIII.cw.newConstItem(lllllllllllllllIllIlIlIlllIlIlll);
        if (lllllllllllllllIllIlIlIlllIllIII.currentBlock != null) {
            if (lllllllllllllllIllIlIlIlllIllIII.compute == 0 || lllllllllllllllIllIlIlIlllIllIII.compute == 1) {
                lllllllllllllllIllIlIlIlllIllIII.currentBlock.frame.execute(18, 0, lllllllllllllllIllIlIlIlllIllIII.cw, lllllllllllllllIllIlIlIlllIllIlI);
            } else {
                int lllllllllllllllIllIlIlIlllIlllIl;
                if (lllllllllllllllIllIlIlIlllIllIlI.type == 5 || lllllllllllllllIllIlIlIlllIllIlI.type == 6) {
                    int lllllllllllllllIllIlIlIlllIllllI = lllllllllllllllIllIlIlIlllIllIII.stackSize + 2;
                } else {
                    lllllllllllllllIllIlIlIlllIlllIl = lllllllllllllllIllIlIlIlllIllIII.stackSize + 1;
                }
                if (lllllllllllllllIllIlIlIlllIlllIl > lllllllllllllllIllIlIlIlllIllIII.maxStackSize) {
                    lllllllllllllllIllIlIlIlllIllIII.maxStackSize = lllllllllllllllIllIlIlIlllIlllIl;
                }
                lllllllllllllllIllIlIlIlllIllIII.stackSize = lllllllllllllllIllIlIlIlllIlllIl;
            }
        }
        int lllllllllllllllIllIlIlIlllIllIIl = lllllllllllllllIllIlIlIlllIllIlI.index;
        if (lllllllllllllllIllIlIlIlllIllIlI.type == 5 || lllllllllllllllIllIlIlIlllIllIlI.type == 6) {
            lllllllllllllllIllIlIlIlllIllIII.code.put12(20, lllllllllllllllIllIlIlIlllIllIIl);
        } else if (lllllllllllllllIllIlIlIlllIllIIl >= 256) {
            lllllllllllllllIllIlIlIlllIllIII.code.put12(19, lllllllllllllllIllIlIlIlllIllIIl);
        } else {
            lllllllllllllllIllIlIlIlllIllIII.code.put11(18, lllllllllllllllIllIlIlIlllIllIIl);
        }
    }

    public void visitIntInsn(int lllllllllllllllIllIlIllIIllIlIII, int lllllllllllllllIllIlIllIIllIlIlI) {
        MethodWriter lllllllllllllllIllIlIllIIllIllII;
        lllllllllllllllIllIlIllIIllIllII.lastCodeOffset = lllllllllllllllIllIlIllIIllIllII.code.length;
        if (lllllllllllllllIllIlIllIIllIllII.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIllIllII.compute == 0 || lllllllllllllllIllIlIllIIllIllII.compute == 1) {
                lllllllllllllllIllIlIllIIllIllII.currentBlock.frame.execute(lllllllllllllllIllIlIllIIllIlIII, lllllllllllllllIllIlIllIIllIlIlI, null, null);
            } else if (lllllllllllllllIllIlIllIIllIlIII != 188) {
                int lllllllllllllllIllIlIllIIllIllIl = lllllllllllllllIllIlIllIIllIllII.stackSize + 1;
                if (lllllllllllllllIllIlIllIIllIllIl > lllllllllllllllIllIlIllIIllIllII.maxStackSize) {
                    lllllllllllllllIllIlIllIIllIllII.maxStackSize = lllllllllllllllIllIlIllIIllIllIl;
                }
                lllllllllllllllIllIlIllIIllIllII.stackSize = lllllllllllllllIllIlIllIIllIllIl;
            }
        }
        if (lllllllllllllllIllIlIllIIllIlIII == 17) {
            lllllllllllllllIllIlIllIIllIllII.code.put12(lllllllllllllllIllIlIllIIllIlIII, lllllllllllllllIllIlIllIIllIlIlI);
        } else {
            lllllllllllllllIllIlIllIIllIllII.code.put11(lllllllllllllllIllIlIllIIllIlIII, lllllllllllllllIllIlIllIIllIlIlI);
        }
    }

    public void visitAttribute(Attribute lllllllllllllllIllIlIllIlIIllIlI) {
        MethodWriter lllllllllllllllIllIlIllIlIIlllIl;
        if (lllllllllllllllIllIlIllIlIIllIlI.isCodeAttribute()) {
            lllllllllllllllIllIlIllIlIIllIlI.next = lllllllllllllllIllIlIllIlIIlllIl.cattrs;
            lllllllllllllllIllIlIllIlIIlllIl.cattrs = lllllllllllllllIllIlIllIlIIllIlI;
        } else {
            lllllllllllllllIllIlIllIlIIllIlI.next = lllllllllllllllIllIlIllIlIIlllIl.attrs;
            lllllllllllllllIllIlIllIlIIlllIl.attrs = lllllllllllllllIllIlIllIlIIllIlI;
        }
    }

    public void visitIincInsn(int lllllllllllllllIllIlIlIlllIIlllI, int lllllllllllllllIllIlIlIlllIIllIl) {
        int lllllllllllllllIllIlIlIlllIlIIII;
        MethodWriter lllllllllllllllIllIlIlIlllIIllll;
        lllllllllllllllIllIlIlIlllIIllll.lastCodeOffset = lllllllllllllllIllIlIlIlllIIllll.code.length;
        if (lllllllllllllllIllIlIlIlllIIllll.currentBlock != null && (lllllllllllllllIllIlIlIlllIIllll.compute == 0 || lllllllllllllllIllIlIlIlllIIllll.compute == 1)) {
            lllllllllllllllIllIlIlIlllIIllll.currentBlock.frame.execute(132, lllllllllllllllIllIlIlIlllIIlllI, null, null);
        }
        if (lllllllllllllllIllIlIlIlllIIllll.compute != 3 && (lllllllllllllllIllIlIlIlllIlIIII = lllllllllllllllIllIlIlIlllIIlllI + 1) > lllllllllllllllIllIlIlIlllIIllll.maxLocals) {
            lllllllllllllllIllIlIlIlllIIllll.maxLocals = lllllllllllllllIllIlIlIlllIlIIII;
        }
        if (lllllllllllllllIllIlIlIlllIIlllI > 255 || lllllllllllllllIllIlIlIlllIIllIl > 127 || lllllllllllllllIllIlIlIlllIIllIl < -128) {
            lllllllllllllllIllIlIlIlllIIllll.code.putByte(196).put12(132, lllllllllllllllIllIlIlIlllIIlllI).putShort(lllllllllllllllIllIlIlIlllIIllIl);
        } else {
            lllllllllllllllIllIlIlIlllIIllll.code.putByte(132).put11(lllllllllllllllIllIlIlIlllIIlllI, lllllllllllllllIllIlIlIlllIIllIl);
        }
    }

    public void visitFrame(int lllllllllllllllIllIlIllIlIIIIIIl, int lllllllllllllllIllIlIllIlIIIIIII, Object[] lllllllllllllllIllIlIllIlIIIIlIl, int lllllllllllllllIllIlIllIIllllllI, Object[] lllllllllllllllIllIlIllIIlllllIl) {
        MethodWriter lllllllllllllllIllIlIllIlIIIIIlI;
        if (lllllllllllllllIllIlIllIlIIIIIlI.compute == 0) {
            return;
        }
        if (lllllllllllllllIllIlIllIlIIIIIlI.compute == 1) {
            if (lllllllllllllllIllIlIllIlIIIIIlI.currentBlock.frame == null) {
                lllllllllllllllIllIlIllIlIIIIIlI.currentBlock.frame = new CurrentFrame();
                lllllllllllllllIllIlIllIlIIIIIlI.currentBlock.frame.owner = lllllllllllllllIllIlIllIlIIIIIlI.currentBlock;
                lllllllllllllllIllIlIllIlIIIIIlI.currentBlock.frame.initInputFrame(lllllllllllllllIllIlIllIlIIIIIlI.cw, lllllllllllllllIllIlIllIlIIIIIlI.access, Type.getArgumentTypes(lllllllllllllllIllIlIllIlIIIIIlI.descriptor), lllllllllllllllIllIlIllIlIIIIIII);
                lllllllllllllllIllIlIllIlIIIIIlI.visitImplicitFirstFrame();
            } else {
                if (lllllllllllllllIllIlIllIlIIIIIIl == -1) {
                    lllllllllllllllIllIlIllIlIIIIIlI.currentBlock.frame.set(lllllllllllllllIllIlIllIlIIIIIlI.cw, lllllllllllllllIllIlIllIlIIIIIII, lllllllllllllllIllIlIllIlIIIIlIl, lllllllllllllllIllIlIllIIllllllI, lllllllllllllllIllIlIllIIlllllIl);
                }
                lllllllllllllllIllIlIllIlIIIIIlI.visitFrame(lllllllllllllllIllIlIllIlIIIIIlI.currentBlock.frame);
            }
        } else if (lllllllllllllllIllIlIllIlIIIIIIl == -1) {
            if (lllllllllllllllIllIlIllIlIIIIIlI.previousFrame == null) {
                lllllllllllllllIllIlIllIlIIIIIlI.visitImplicitFirstFrame();
            }
            lllllllllllllllIllIlIllIlIIIIIlI.currentLocals = lllllllllllllllIllIlIllIlIIIIIII;
            int lllllllllllllllIllIlIllIlIIIlllI = lllllllllllllllIllIlIllIlIIIIIlI.startFrame(lllllllllllllllIllIlIllIlIIIIIlI.code.length, lllllllllllllllIllIlIllIlIIIIIII, lllllllllllllllIllIlIllIIllllllI);
            for (int lllllllllllllllIllIlIllIlIIlIIII = 0; lllllllllllllllIllIlIllIlIIlIIII < lllllllllllllllIllIlIllIlIIIIIII; ++lllllllllllllllIllIlIllIlIIlIIII) {
                lllllllllllllllIllIlIllIlIIIIIlI.frame[lllllllllllllllIllIlIllIlIIIlllI++] = lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIlIIII] instanceof String ? 0x1700000 | lllllllllllllllIllIlIllIlIIIIIlI.cw.addType((String)lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIlIIII]) : (lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIlIIII] instanceof Integer ? (Integer)lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIlIIII] : 0x1800000 | lllllllllllllllIllIlIllIlIIIIIlI.cw.addUninitializedType("", ((Label)lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIlIIII]).position));
            }
            for (int lllllllllllllllIllIlIllIlIIIllll = 0; lllllllllllllllIllIlIllIlIIIllll < lllllllllllllllIllIlIllIIllllllI; ++lllllllllllllllIllIlIllIlIIIllll) {
                lllllllllllllllIllIlIllIlIIIIIlI.frame[lllllllllllllllIllIlIllIlIIIlllI++] = lllllllllllllllIllIlIllIIlllllIl[lllllllllllllllIllIlIllIlIIIllll] instanceof String ? 0x1700000 | lllllllllllllllIllIlIllIlIIIIIlI.cw.addType((String)lllllllllllllllIllIlIllIIlllllIl[lllllllllllllllIllIlIllIlIIIllll]) : (lllllllllllllllIllIlIllIIlllllIl[lllllllllllllllIllIlIllIlIIIllll] instanceof Integer ? (Integer)lllllllllllllllIllIlIllIIlllllIl[lllllllllllllllIllIlIllIlIIIllll] : 0x1800000 | lllllllllllllllIllIlIllIlIIIIIlI.cw.addUninitializedType("", ((Label)lllllllllllllllIllIlIllIIlllllIl[lllllllllllllllIllIlIllIlIIIllll]).position));
            }
            lllllllllllllllIllIlIllIlIIIIIlI.endFrame();
        } else {
            int lllllllllllllllIllIlIllIlIIIlIIl;
            if (lllllllllllllllIllIlIllIlIIIIIlI.stackMap == null) {
                lllllllllllllllIllIlIllIlIIIIIlI.stackMap = new ByteVector();
                int lllllllllllllllIllIlIllIlIIIllIl = lllllllllllllllIllIlIllIlIIIIIlI.code.length;
            } else {
                lllllllllllllllIllIlIllIlIIIlIIl = lllllllllllllllIllIlIllIlIIIIIlI.code.length - lllllllllllllllIllIlIllIlIIIIIlI.previousFrameOffset - 1;
                if (lllllllllllllllIllIlIllIlIIIlIIl < 0) {
                    if (lllllllllllllllIllIlIllIlIIIIIIl == 3) {
                        return;
                    }
                    throw new IllegalStateException();
                }
            }
            switch (lllllllllllllllIllIlIllIlIIIIIIl) {
                case 0: {
                    lllllllllllllllIllIlIllIlIIIIIlI.currentLocals = lllllllllllllllIllIlIllIlIIIIIII;
                    lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(255).putShort(lllllllllllllllIllIlIllIlIIIlIIl).putShort(lllllllllllllllIllIlIllIlIIIIIII);
                    for (int lllllllllllllllIllIlIllIlIIIllII = 0; lllllllllllllllIllIlIllIlIIIllII < lllllllllllllllIllIlIllIlIIIIIII; ++lllllllllllllllIllIlIllIlIIIllII) {
                        lllllllllllllllIllIlIllIlIIIIIlI.writeFrameType(lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIIllII]);
                    }
                    lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putShort(lllllllllllllllIllIlIllIIllllllI);
                    for (int lllllllllllllllIllIlIllIlIIIlIll = 0; lllllllllllllllIllIlIllIlIIIlIll < lllllllllllllllIllIlIllIIllllllI; ++lllllllllllllllIllIlIllIlIIIlIll) {
                        lllllllllllllllIllIlIllIlIIIIIlI.writeFrameType(lllllllllllllllIllIlIllIIlllllIl[lllllllllllllllIllIlIllIlIIIlIll]);
                    }
                    break;
                }
                case 1: {
                    lllllllllllllllIllIlIllIlIIIIIlI.currentLocals += lllllllllllllllIllIlIllIlIIIIIII;
                    lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(251 + lllllllllllllllIllIlIllIlIIIIIII).putShort(lllllllllllllllIllIlIllIlIIIlIIl);
                    for (int lllllllllllllllIllIlIllIlIIIlIlI = 0; lllllllllllllllIllIlIllIlIIIlIlI < lllllllllllllllIllIlIllIlIIIIIII; ++lllllllllllllllIllIlIllIlIIIlIlI) {
                        lllllllllllllllIllIlIllIlIIIIIlI.writeFrameType(lllllllllllllllIllIlIllIlIIIIlIl[lllllllllllllllIllIlIllIlIIIlIlI]);
                    }
                    break;
                }
                case 2: {
                    lllllllllllllllIllIlIllIlIIIIIlI.currentLocals -= lllllllllllllllIllIlIllIlIIIIIII;
                    lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(251 - lllllllllllllllIllIlIllIlIIIIIII).putShort(lllllllllllllllIllIlIllIlIIIlIIl);
                    break;
                }
                case 3: {
                    if (lllllllllllllllIllIlIllIlIIIlIIl < 64) {
                        lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(lllllllllllllllIllIlIllIlIIIlIIl);
                        break;
                    }
                    lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(251).putShort(lllllllllllllllIllIlIllIlIIIlIIl);
                    break;
                }
                case 4: {
                    if (lllllllllllllllIllIlIllIlIIIlIIl < 64) {
                        lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(64 + lllllllllllllllIllIlIllIlIIIlIIl);
                    } else {
                        lllllllllllllllIllIlIllIlIIIIIlI.stackMap.putByte(247).putShort(lllllllllllllllIllIlIllIlIIIlIIl);
                    }
                    lllllllllllllllIllIlIllIlIIIIIlI.writeFrameType(lllllllllllllllIllIlIllIIlllllIl[0]);
                }
            }
            lllllllllllllllIllIlIllIlIIIIIlI.previousFrameOffset = lllllllllllllllIllIlIllIlIIIIIlI.code.length;
            ++lllllllllllllllIllIlIllIlIIIIIlI.frameCount;
        }
        lllllllllllllllIllIlIllIlIIIIIlI.maxStack = Math.max(lllllllllllllllIllIlIllIlIIIIIlI.maxStack, lllllllllllllllIllIlIllIIllllllI);
        lllllllllllllllIllIlIllIlIIIIIlI.maxLocals = Math.max(lllllllllllllllIllIlIllIlIIIIIlI.maxLocals, lllllllllllllllIllIlIllIlIIIIIlI.currentLocals);
    }

    private int startFrame(int lllllllllllllllIllIlIlIIlIIIIIlI, int lllllllllllllllIllIlIlIIIlllllII, int lllllllllllllllIllIlIlIIIllllIll) {
        MethodWriter lllllllllllllllIllIlIlIIlIIIIIll;
        int lllllllllllllllIllIlIlIIIlllllll = 3 + lllllllllllllllIllIlIlIIIlllllII + lllllllllllllllIllIlIlIIIllllIll;
        if (lllllllllllllllIllIlIlIIlIIIIIll.frame == null || lllllllllllllllIllIlIlIIlIIIIIll.frame.length < lllllllllllllllIllIlIlIIIlllllll) {
            lllllllllllllllIllIlIlIIlIIIIIll.frame = new int[lllllllllllllllIllIlIlIIIlllllll];
        }
        lllllllllllllllIllIlIlIIlIIIIIll.frame[0] = lllllllllllllllIllIlIlIIlIIIIIlI;
        lllllllllllllllIllIlIlIIlIIIIIll.frame[1] = lllllllllllllllIllIlIlIIIlllllII;
        lllllllllllllllIllIlIlIIlIIIIIll.frame[2] = lllllllllllllllIllIlIlIIIllllIll;
        return 3;
    }

    public void visitTypeInsn(int lllllllllllllllIllIlIllIIlIIlIlI, String lllllllllllllllIllIlIllIIlIIlIIl) {
        MethodWriter lllllllllllllllIllIlIllIIlIIlIll;
        lllllllllllllllIllIlIllIIlIIlIll.lastCodeOffset = lllllllllllllllIllIlIllIIlIIlIll.code.length;
        Item lllllllllllllllIllIlIllIIlIIllII = lllllllllllllllIllIlIllIIlIIlIll.cw.newClassItem(lllllllllllllllIllIlIllIIlIIlIIl);
        if (lllllllllllllllIllIlIllIIlIIlIll.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIlIIlIll.compute == 0 || lllllllllllllllIllIlIllIIlIIlIll.compute == 1) {
                lllllllllllllllIllIlIllIIlIIlIll.currentBlock.frame.execute(lllllllllllllllIllIlIllIIlIIlIlI, lllllllllllllllIllIlIllIIlIIlIll.code.length, lllllllllllllllIllIlIllIIlIIlIll.cw, lllllllllllllllIllIlIllIIlIIllII);
            } else if (lllllllllllllllIllIlIllIIlIIlIlI == 187) {
                int lllllllllllllllIllIlIllIIlIlIIII = lllllllllllllllIllIlIllIIlIIlIll.stackSize + 1;
                if (lllllllllllllllIllIlIllIIlIlIIII > lllllllllllllllIllIlIllIIlIIlIll.maxStackSize) {
                    lllllllllllllllIllIlIllIIlIIlIll.maxStackSize = lllllllllllllllIllIlIllIIlIlIIII;
                }
                lllllllllllllllIllIlIllIIlIIlIll.stackSize = lllllllllllllllIllIlIllIIlIlIIII;
            }
        }
        lllllllllllllllIllIlIllIIlIIlIll.code.put12(lllllllllllllllIllIlIllIIlIIlIlI, lllllllllllllllIllIlIllIIlIIllII.index);
    }

    private void endFrame() {
        MethodWriter lllllllllllllllIllIlIlIIIlllIlll;
        if (lllllllllllllllIllIlIlIIIlllIlll.previousFrame != null) {
            if (lllllllllllllllIllIlIlIIIlllIlll.stackMap == null) {
                lllllllllllllllIllIlIlIIIlllIlll.stackMap = new ByteVector();
            }
            lllllllllllllllIllIlIlIIIlllIlll.writeFrame();
            ++lllllllllllllllIllIlIlIIIlllIlll.frameCount;
        }
        lllllllllllllllIllIlIlIIIlllIlll.previousFrame = lllllllllllllllIllIlIlIIIlllIlll.frame;
        lllllllllllllllIllIlIlIIIlllIlll.frame = null;
    }

    static {
        MAXS = 2;
        SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
        SAME_FRAME_EXTENDED = 251;
        SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
        FRAMES = 0;
        INSERTED_FRAMES = 1;
        CHOP_FRAME = 248;
        ACC_CONSTRUCTOR = 524288;
        SAME_FRAME = 0;
        FULL_FRAME = 255;
        APPEND_FRAME = 252;
        NOTHING = 3;
        RESERVED = 128;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        MethodWriter lllllllllllllllIllIlIllIllIlIlll;
        lllllllllllllllIllIlIllIllIlIlll.annd = new ByteVector();
        return new AnnotationWriter(lllllllllllllllIllIlIllIllIlIlll.cw, false, lllllllllllllllIllIlIllIllIlIlll.annd, null, 0);
    }

    public void visitJumpInsn(int lllllllllllllllIllIlIlIllllIllII, Label lllllllllllllllIllIlIlIlllllIIII) {
        MethodWriter lllllllllllllllIllIlIlIlllllIIlI;
        boolean lllllllllllllllIllIlIlIllllIllll = lllllllllllllllIllIlIlIllllIllII >= 200;
        lllllllllllllllIllIlIlIllllIllII = lllllllllllllllIllIlIlIllllIllll ? lllllllllllllllIllIlIlIllllIllII - 33 : lllllllllllllllIllIlIlIllllIllII;
        lllllllllllllllIllIlIlIlllllIIlI.lastCodeOffset = lllllllllllllllIllIlIlIlllllIIlI.code.length;
        Label lllllllllllllllIllIlIlIllllIlllI = null;
        if (lllllllllllllllIllIlIlIlllllIIlI.currentBlock != null) {
            if (lllllllllllllllIllIlIlIlllllIIlI.compute == 0) {
                lllllllllllllllIllIlIlIlllllIIlI.currentBlock.frame.execute(lllllllllllllllIllIlIlIllllIllII, 0, null, null);
                lllllllllllllllIllIlIlIlllllIIII.getFirst().status |= 0x10;
                lllllllllllllllIllIlIlIlllllIIlI.addSuccessor(0, lllllllllllllllIllIlIlIlllllIIII);
                if (lllllllllllllllIllIlIlIllllIllII != 167) {
                    lllllllllllllllIllIlIlIllllIlllI = new Label();
                }
            } else if (lllllllllllllllIllIlIlIlllllIIlI.compute == 1) {
                lllllllllllllllIllIlIlIlllllIIlI.currentBlock.frame.execute(lllllllllllllllIllIlIlIllllIllII, 0, null, null);
            } else if (lllllllllllllllIllIlIlIllllIllII == 168) {
                if ((lllllllllllllllIllIlIlIlllllIIII.status & 0x200) == 0) {
                    lllllllllllllllIllIlIlIlllllIIII.status |= 0x200;
                    ++lllllllllllllllIllIlIlIlllllIIlI.subroutines;
                }
                lllllllllllllllIllIlIlIlllllIIlI.currentBlock.status |= 0x80;
                lllllllllllllllIllIlIlIlllllIIlI.addSuccessor(lllllllllllllllIllIlIlIlllllIIlI.stackSize + 1, lllllllllllllllIllIlIlIlllllIIII);
                lllllllllllllllIllIlIlIllllIlllI = new Label();
            } else {
                lllllllllllllllIllIlIlIlllllIIlI.stackSize += Frame.SIZE[lllllllllllllllIllIlIlIllllIllII];
                lllllllllllllllIllIlIlIlllllIIlI.addSuccessor(lllllllllllllllIllIlIlIlllllIIlI.stackSize, lllllllllllllllIllIlIlIlllllIIII);
            }
        }
        if ((lllllllllllllllIllIlIlIlllllIIII.status & 2) != 0 && lllllllllllllllIllIlIlIlllllIIII.position - lllllllllllllllIllIlIlIlllllIIlI.code.length < Short.MIN_VALUE) {
            if (lllllllllllllllIllIlIlIllllIllII == 167) {
                lllllllllllllllIllIlIlIlllllIIlI.code.putByte(200);
            } else if (lllllllllllllllIllIlIlIllllIllII == 168) {
                lllllllllllllllIllIlIlIlllllIIlI.code.putByte(201);
            } else {
                if (lllllllllllllllIllIlIlIllllIlllI != null) {
                    lllllllllllllllIllIlIlIllllIlllI.status |= 0x10;
                }
                lllllllllllllllIllIlIlIlllllIIlI.code.putByte(lllllllllllllllIllIlIlIllllIllII <= 166 ? (lllllllllllllllIllIlIlIllllIllII + 1 ^ 1) - 1 : lllllllllllllllIllIlIlIllllIllII ^ 1);
                lllllllllllllllIllIlIlIlllllIIlI.code.putShort(8);
                lllllllllllllllIllIlIlIlllllIIlI.code.putByte(200);
            }
            lllllllllllllllIllIlIlIlllllIIII.put(lllllllllllllllIllIlIlIlllllIIlI, lllllllllllllllIllIlIlIlllllIIlI.code, lllllllllllllllIllIlIlIlllllIIlI.code.length - 1, true);
        } else if (lllllllllllllllIllIlIlIllllIllll) {
            lllllllllllllllIllIlIlIlllllIIlI.code.putByte(lllllllllllllllIllIlIlIllllIllII + 33);
            lllllllllllllllIllIlIlIlllllIIII.put(lllllllllllllllIllIlIlIlllllIIlI, lllllllllllllllIllIlIlIlllllIIlI.code, lllllllllllllllIllIlIlIlllllIIlI.code.length - 1, true);
        } else {
            lllllllllllllllIllIlIlIlllllIIlI.code.putByte(lllllllllllllllIllIlIlIllllIllII);
            lllllllllllllllIllIlIlIlllllIIII.put(lllllllllllllllIllIlIlIlllllIIlI, lllllllllllllllIllIlIlIlllllIIlI.code, lllllllllllllllIllIlIlIlllllIIlI.code.length - 1, false);
        }
        if (lllllllllllllllIllIlIlIlllllIIlI.currentBlock != null) {
            if (lllllllllllllllIllIlIlIllllIlllI != null) {
                lllllllllllllllIllIlIlIlllllIIlI.visitLabel(lllllllllllllllIllIlIlIllllIlllI);
            }
            if (lllllllllllllllIllIlIlIllllIllII == 167) {
                lllllllllllllllIllIlIlIlllllIIlI.noSuccessor();
            }
        }
    }

    private void visitSwitchInsn(Label lllllllllllllllIllIlIlIllIIllIlI, Label[] lllllllllllllllIllIlIlIllIIlIllI) {
        MethodWriter lllllllllllllllIllIlIlIllIIllIII;
        if (lllllllllllllllIllIlIlIllIIllIII.currentBlock != null) {
            if (lllllllllllllllIllIlIlIllIIllIII.compute == 0) {
                lllllllllllllllIllIlIlIllIIllIII.currentBlock.frame.execute(171, 0, null, null);
                lllllllllllllllIllIlIlIllIIllIII.addSuccessor(0, lllllllllllllllIllIlIlIllIIllIlI);
                lllllllllllllllIllIlIlIllIIllIlI.getFirst().status |= 0x10;
                for (int lllllllllllllllIllIlIlIllIIlllIl = 0; lllllllllllllllIllIlIlIllIIlllIl < lllllllllllllllIllIlIlIllIIlIllI.length; ++lllllllllllllllIllIlIlIllIIlllIl) {
                    lllllllllllllllIllIlIlIllIIllIII.addSuccessor(0, lllllllllllllllIllIlIlIllIIlIllI[lllllllllllllllIllIlIlIllIIlllIl]);
                    lllllllllllllllIllIlIlIllIIlIllI[lllllllllllllllIllIlIlIllIIlllIl].getFirst().status |= 0x10;
                }
            } else {
                --lllllllllllllllIllIlIlIllIIllIII.stackSize;
                lllllllllllllllIllIlIlIllIIllIII.addSuccessor(lllllllllllllllIllIlIlIllIIllIII.stackSize, lllllllllllllllIllIlIlIllIIllIlI);
                for (int lllllllllllllllIllIlIlIllIIlllII = 0; lllllllllllllllIllIlIlIllIIlllII < lllllllllllllllIllIlIlIllIIlIllI.length; ++lllllllllllllllIllIlIlIllIIlllII) {
                    lllllllllllllllIllIlIlIllIIllIII.addSuccessor(lllllllllllllllIllIlIlIllIIllIII.stackSize, lllllllllllllllIllIlIlIllIIlIllI[lllllllllllllllIllIlIlIllIIlllII]);
                }
            }
            lllllllllllllllIllIlIlIllIIllIII.noSuccessor();
        }
    }

    public void visitMaxs(int lllllllllllllllIllIlIlIIllIlIllI, int lllllllllllllllIllIlIlIIllIlIlIl) {
        MethodWriter lllllllllllllllIllIlIlIIllIlIlII;
        if (lllllllllllllllIllIlIlIIllIlIlII.compute == 0) {
            Handler lllllllllllllllIllIlIlIIlllIllII = lllllllllllllllIllIlIlIIllIlIlII.firstHandler;
            while (lllllllllllllllIllIlIlIIlllIllII != null) {
                Label lllllllllllllllIllIlIlIIlllllIll = lllllllllllllllIllIlIlIIlllIllII.start.getFirst();
                Label lllllllllllllllIllIlIlIIlllllIlI = lllllllllllllllIllIlIlIIlllIllII.handler.getFirst();
                Label lllllllllllllllIllIlIlIIlllllIIl = lllllllllllllllIllIlIlIIlllIllII.end.getFirst();
                String lllllllllllllllIllIlIlIIlllllIII = lllllllllllllllIllIlIlIIlllIllII.desc == null ? "java/lang/Throwable" : lllllllllllllllIllIlIlIIlllIllII.desc;
                int lllllllllllllllIllIlIlIIllllIlll = 0x1700000 | lllllllllllllllIllIlIlIIllIlIlII.cw.addType(lllllllllllllllIllIlIlIIlllllIII);
                lllllllllllllllIllIlIlIIlllllIlI.status |= 0x10;
                while (lllllllllllllllIllIlIlIIlllllIll != lllllllllllllllIllIlIlIIlllllIIl) {
                    Edge lllllllllllllllIllIlIlIIllllllII = new Edge();
                    lllllllllllllllIllIlIlIIllllllII.info = lllllllllllllllIllIlIlIIllllIlll;
                    lllllllllllllllIllIlIlIIllllllII.successor = lllllllllllllllIllIlIlIIlllllIlI;
                    lllllllllllllllIllIlIlIIllllllII.next = lllllllllllllllIllIlIlIIlllllIll.successors;
                    lllllllllllllllIllIlIlIIlllllIll.successors = lllllllllllllllIllIlIlIIllllllII;
                    lllllllllllllllIllIlIlIIlllllIll = lllllllllllllllIllIlIlIIlllllIll.successor;
                }
                lllllllllllllllIllIlIlIIlllIllII = lllllllllllllllIllIlIlIIlllIllII.next;
            }
            Frame lllllllllllllllIllIlIlIIlllIlIll = lllllllllllllllIllIlIlIIllIlIlII.labels.frame;
            lllllllllllllllIllIlIlIIlllIlIll.initInputFrame(lllllllllllllllIllIlIlIIllIlIlII.cw, lllllllllllllllIllIlIlIIllIlIlII.access, Type.getArgumentTypes(lllllllllllllllIllIlIlIIllIlIlII.descriptor), lllllllllllllllIllIlIlIIllIlIlII.maxLocals);
            lllllllllllllllIllIlIlIIllIlIlII.visitFrame(lllllllllllllllIllIlIlIIlllIlIll);
            int lllllllllllllllIllIlIlIIlllIlIlI = 0;
            Label lllllllllllllllIllIlIlIIlllIlIIl = lllllllllllllllIllIlIlIIllIlIlII.labels;
            while (lllllllllllllllIllIlIlIIlllIlIIl != null) {
                Label lllllllllllllllIllIlIlIIllllIlII = lllllllllllllllIllIlIlIIlllIlIIl;
                lllllllllllllllIllIlIlIIlllIlIIl = lllllllllllllllIllIlIlIIlllIlIIl.next;
                lllllllllllllllIllIlIlIIllllIlII.next = null;
                lllllllllllllllIllIlIlIIlllIlIll = lllllllllllllllIllIlIlIIllllIlII.frame;
                if ((lllllllllllllllIllIlIlIIllllIlII.status & 0x10) != 0) {
                    lllllllllllllllIllIlIlIIllllIlII.status |= 0x20;
                }
                lllllllllllllllIllIlIlIIllllIlII.status |= 0x40;
                int lllllllllllllllIllIlIlIIllllIIll = lllllllllllllllIllIlIlIIlllIlIll.inputStack.length + lllllllllllllllIllIlIlIIllllIlII.outputStackMax;
                if (lllllllllllllllIllIlIlIIllllIIll > lllllllllllllllIllIlIlIIlllIlIlI) {
                    lllllllllllllllIllIlIlIIlllIlIlI = lllllllllllllllIllIlIlIIllllIIll;
                }
                Edge lllllllllllllllIllIlIlIIllllIIlI = lllllllllllllllIllIlIlIIllllIlII.successors;
                while (lllllllllllllllIllIlIlIIllllIIlI != null) {
                    Label lllllllllllllllIllIlIlIIllllIllI = lllllllllllllllIllIlIlIIllllIIlI.successor.getFirst();
                    boolean lllllllllllllllIllIlIlIIllllIlIl = lllllllllllllllIllIlIlIIlllIlIll.merge(lllllllllllllllIllIlIlIIllIlIlII.cw, lllllllllllllllIllIlIlIIllllIllI.frame, lllllllllllllllIllIlIlIIllllIIlI.info);
                    if (lllllllllllllllIllIlIlIIllllIlIl && lllllllllllllllIllIlIlIIllllIllI.next == null) {
                        lllllllllllllllIllIlIlIIllllIllI.next = lllllllllllllllIllIlIlIIlllIlIIl;
                        lllllllllllllllIllIlIlIIlllIlIIl = lllllllllllllllIllIlIlIIllllIllI;
                    }
                    lllllllllllllllIllIlIlIIllllIIlI = lllllllllllllllIllIlIlIIllllIIlI.next;
                }
            }
            Label lllllllllllllllIllIlIlIIlllIlIII = lllllllllllllllIllIlIlIIllIlIlII.labels;
            while (lllllllllllllllIllIlIlIIlllIlIII != null) {
                int lllllllllllllllIllIlIlIIlllIlllI;
                Label lllllllllllllllIllIlIlIIlllIllll;
                int lllllllllllllllIllIlIlIIlllIllIl;
                lllllllllllllllIllIlIlIIlllIlIll = lllllllllllllllIllIlIlIIlllIlIII.frame;
                if ((lllllllllllllllIllIlIlIIlllIlIII.status & 0x20) != 0) {
                    lllllllllllllllIllIlIlIIllIlIlII.visitFrame(lllllllllllllllIllIlIlIIlllIlIll);
                }
                if ((lllllllllllllllIllIlIlIIlllIlIII.status & 0x40) == 0 && (lllllllllllllllIllIlIlIIlllIllIl = ((lllllllllllllllIllIlIlIIlllIllll = lllllllllllllllIllIlIlIIlllIlIII.successor) == null ? lllllllllllllllIllIlIlIIllIlIlII.code.length : lllllllllllllllIllIlIlIIlllIllll.position) - 1) >= (lllllllllllllllIllIlIlIIlllIlllI = lllllllllllllllIllIlIlIIlllIlIII.position)) {
                    lllllllllllllllIllIlIlIIlllIlIlI = Math.max(lllllllllllllllIllIlIlIIlllIlIlI, 1);
                    for (int lllllllllllllllIllIlIlIIllllIIIl = lllllllllllllllIllIlIlIIlllIlllI; lllllllllllllllIllIlIlIIllllIIIl < lllllllllllllllIllIlIlIIlllIllIl; ++lllllllllllllllIllIlIlIIllllIIIl) {
                        lllllllllllllllIllIlIlIIllIlIlII.code.data[lllllllllllllllIllIlIlIIllllIIIl] = 0;
                    }
                    lllllllllllllllIllIlIlIIllIlIlII.code.data[lllllllllllllllIllIlIlIIlllIllIl] = -65;
                    int lllllllllllllllIllIlIlIIllllIIII = lllllllllllllllIllIlIlIIllIlIlII.startFrame(lllllllllllllllIllIlIlIIlllIlllI, 0, 1);
                    lllllllllllllllIllIlIlIIllIlIlII.frame[lllllllllllllllIllIlIlIIllllIIII] = 0x1700000 | lllllllllllllllIllIlIlIIllIlIlII.cw.addType("java/lang/Throwable");
                    lllllllllllllllIllIlIlIIllIlIlII.endFrame();
                    lllllllllllllllIllIlIlIIllIlIlII.firstHandler = Handler.remove(lllllllllllllllIllIlIlIIllIlIlII.firstHandler, lllllllllllllllIllIlIlIIlllIlIII, lllllllllllllllIllIlIlIIlllIllll);
                }
                lllllllllllllllIllIlIlIIlllIlIII = lllllllllllllllIllIlIlIIlllIlIII.successor;
            }
            lllllllllllllllIllIlIlIIlllIllII = lllllllllllllllIllIlIlIIllIlIlII.firstHandler;
            lllllllllllllllIllIlIlIIllIlIlII.handlerCount = 0;
            while (lllllllllllllllIllIlIlIIlllIllII != null) {
                ++lllllllllllllllIllIlIlIIllIlIlII.handlerCount;
                lllllllllllllllIllIlIlIIlllIllII = lllllllllllllllIllIlIlIIlllIllII.next;
            }
            lllllllllllllllIllIlIlIIllIlIlII.maxStack = lllllllllllllllIllIlIlIIlllIlIlI;
        } else if (lllllllllllllllIllIlIlIIllIlIlII.compute == 2) {
            Handler lllllllllllllllIllIlIlIIllIllIlI = lllllllllllllllIllIlIlIIllIlIlII.firstHandler;
            while (lllllllllllllllIllIlIlIIllIllIlI != null) {
                Label lllllllllllllllIllIlIlIIlllIIllI = lllllllllllllllIllIlIlIIllIllIlI.start;
                Label lllllllllllllllIllIlIlIIlllIIlIl = lllllllllllllllIllIlIlIIllIllIlI.handler;
                Label lllllllllllllllIllIlIlIIlllIIlII = lllllllllllllllIllIlIlIIllIllIlI.end;
                while (lllllllllllllllIllIlIlIIlllIIllI != lllllllllllllllIllIlIlIIlllIIlII) {
                    Edge lllllllllllllllIllIlIlIIlllIIlll = new Edge();
                    lllllllllllllllIllIlIlIIlllIIlll.info = Integer.MAX_VALUE;
                    lllllllllllllllIllIlIlIIlllIIlll.successor = lllllllllllllllIllIlIlIIlllIIlIl;
                    if ((lllllllllllllllIllIlIlIIlllIIllI.status & 0x80) == 0) {
                        lllllllllllllllIllIlIlIIlllIIlll.next = lllllllllllllllIllIlIlIIlllIIllI.successors;
                        lllllllllllllllIllIlIlIIlllIIllI.successors = lllllllllllllllIllIlIlIIlllIIlll;
                    } else {
                        lllllllllllllllIllIlIlIIlllIIlll.next = lllllllllllllllIllIlIlIIlllIIllI.successors.next.next;
                        lllllllllllllllIllIlIlIIlllIIllI.successors.next.next = lllllllllllllllIllIlIlIIlllIIlll;
                    }
                    lllllllllllllllIllIlIlIIlllIIllI = lllllllllllllllIllIlIlIIlllIIllI.successor;
                }
                lllllllllllllllIllIlIlIIllIllIlI = lllllllllllllllIllIlIlIIllIllIlI.next;
            }
            if (lllllllllllllllIllIlIlIIllIlIlII.subroutines > 0) {
                int lllllllllllllllIllIlIlIIlllIIIII = 0;
                lllllllllllllllIllIlIlIIllIlIlII.labels.visitSubroutine(null, 1L, lllllllllllllllIllIlIlIIllIlIlII.subroutines);
                Label lllllllllllllllIllIlIlIIllIlllll = lllllllllllllllIllIlIlIIllIlIlII.labels;
                while (lllllllllllllllIllIlIlIIllIlllll != null) {
                    if ((lllllllllllllllIllIlIlIIllIlllll.status & 0x80) != 0) {
                        Label lllllllllllllllIllIlIlIIlllIIIll = lllllllllllllllIllIlIlIIllIlllll.successors.next.successor;
                        if ((lllllllllllllllIllIlIlIIlllIIIll.status & 0x400) == 0) {
                            lllllllllllllllIllIlIlIIlllIIIll.visitSubroutine(null, (long)(++lllllllllllllllIllIlIlIIlllIIIII) / 32L << 32 | 1L << lllllllllllllllIllIlIlIIlllIIIII % 32, lllllllllllllllIllIlIlIIllIlIlII.subroutines);
                        }
                    }
                    lllllllllllllllIllIlIlIIllIlllll = lllllllllllllllIllIlIlIIllIlllll.successor;
                }
                lllllllllllllllIllIlIlIIllIlllll = lllllllllllllllIllIlIlIIllIlIlII.labels;
                while (lllllllllllllllIllIlIlIIllIlllll != null) {
                    if ((lllllllllllllllIllIlIlIIllIlllll.status & 0x80) != 0) {
                        Label lllllllllllllllIllIlIlIIlllIIIlI = lllllllllllllllIllIlIlIIllIlIlII.labels;
                        while (lllllllllllllllIllIlIlIIlllIIIlI != null) {
                            lllllllllllllllIllIlIlIIlllIIIlI.status &= 0xFFFFF7FF;
                            lllllllllllllllIllIlIlIIlllIIIlI = lllllllllllllllIllIlIlIIlllIIIlI.successor;
                        }
                        Label lllllllllllllllIllIlIlIIlllIIIIl = lllllllllllllllIllIlIlIIllIlllll.successors.next.successor;
                        lllllllllllllllIllIlIlIIlllIIIIl.visitSubroutine(lllllllllllllllIllIlIlIIllIlllll, 0L, lllllllllllllllIllIlIlIIllIlIlII.subroutines);
                    }
                    lllllllllllllllIllIlIlIIllIlllll = lllllllllllllllIllIlIlIIllIlllll.successor;
                }
            }
            int lllllllllllllllIllIlIlIIllIllIIl = 0;
            Label lllllllllllllllIllIlIlIIllIllIII = lllllllllllllllIllIlIlIIllIlIlII.labels;
            while (lllllllllllllllIllIlIlIIllIllIII != null) {
                Label lllllllllllllllIllIlIlIIllIllllI = lllllllllllllllIllIlIlIIllIllIII;
                lllllllllllllllIllIlIlIIllIllIII = lllllllllllllllIllIlIlIIllIllIII.next;
                int lllllllllllllllIllIlIlIIllIlllIl = lllllllllllllllIllIlIlIIllIllllI.inputStackTop;
                int lllllllllllllllIllIlIlIIllIlllII = lllllllllllllllIllIlIlIIllIlllIl + lllllllllllllllIllIlIlIIllIllllI.outputStackMax;
                if (lllllllllllllllIllIlIlIIllIlllII > lllllllllllllllIllIlIlIIllIllIIl) {
                    lllllllllllllllIllIlIlIIllIllIIl = lllllllllllllllIllIlIlIIllIlllII;
                }
                Edge lllllllllllllllIllIlIlIIllIllIll = lllllllllllllllIllIlIlIIllIllllI.successors;
                if ((lllllllllllllllIllIlIlIIllIllllI.status & 0x80) != 0) {
                    lllllllllllllllIllIlIlIIllIllIll = lllllllllllllllIllIlIlIIllIllIll.next;
                }
                while (lllllllllllllllIllIlIlIIllIllIll != null) {
                    lllllllllllllllIllIlIlIIllIllllI = lllllllllllllllIllIlIlIIllIllIll.successor;
                    if ((lllllllllllllllIllIlIlIIllIllllI.status & 8) == 0) {
                        lllllllllllllllIllIlIlIIllIllllI.inputStackTop = lllllllllllllllIllIlIlIIllIllIll.info == Integer.MAX_VALUE ? 1 : lllllllllllllllIllIlIlIIllIlllIl + lllllllllllllllIllIlIlIIllIllIll.info;
                        lllllllllllllllIllIlIlIIllIllllI.status |= 8;
                        lllllllllllllllIllIlIlIIllIllllI.next = lllllllllllllllIllIlIlIIllIllIII;
                        lllllllllllllllIllIlIlIIllIllIII = lllllllllllllllIllIlIlIIllIllllI;
                    }
                    lllllllllllllllIllIlIlIIllIllIll = lllllllllllllllIllIlIlIIllIllIll.next;
                }
            }
            lllllllllllllllIllIlIlIIllIlIlII.maxStack = Math.max(lllllllllllllllIllIlIlIIllIlIllI, lllllllllllllllIllIlIlIIllIllIIl);
        } else {
            lllllllllllllllIllIlIlIIllIlIlII.maxStack = lllllllllllllllIllIlIlIIllIlIllI;
            lllllllllllllllIllIlIlIIllIlIlII.maxLocals = lllllllllllllllIllIlIlIIllIlIlIl;
        }
    }

    private void writeFrameType(Object lllllllllllllllIllIlIlIIIIllllll) {
        MethodWriter lllllllllllllllIllIlIlIIIlIIIIII;
        if (lllllllllllllllIllIlIlIIIIllllll instanceof String) {
            lllllllllllllllIllIlIlIIIlIIIIII.stackMap.putByte(7).putShort(lllllllllllllllIllIlIlIIIlIIIIII.cw.newClass((String)lllllllllllllllIllIlIlIIIIllllll));
        } else if (lllllllllllllllIllIlIlIIIIllllll instanceof Integer) {
            lllllllllllllllIllIlIlIIIlIIIIII.stackMap.putByte((Integer)lllllllllllllllIllIlIlIIIIllllll);
        } else {
            lllllllllllllllIllIlIlIIIlIIIIII.stackMap.putByte(8).putShort(((Label)lllllllllllllllIllIlIlIIIIllllll).position);
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int lllllllllllllllIllIlIllIlIllIlll, TypePath lllllllllllllllIllIlIllIlIllllIl, String lllllllllllllllIllIlIllIlIllllII, boolean lllllllllllllllIllIlIllIlIllIlII) {
        MethodWriter lllllllllllllllIllIlIllIlIllllll;
        ByteVector lllllllllllllllIllIlIllIlIlllIlI = new ByteVector();
        AnnotationWriter.putTarget(lllllllllllllllIllIlIllIlIllIlll, lllllllllllllllIllIlIllIlIllllIl, lllllllllllllllIllIlIllIlIlllIlI);
        lllllllllllllllIllIlIllIlIlllIlI.putShort(lllllllllllllllIllIlIllIlIllllll.cw.newUTF8(lllllllllllllllIllIlIllIlIllllII)).putShort(0);
        AnnotationWriter lllllllllllllllIllIlIllIlIlllIIl = new AnnotationWriter(lllllllllllllllIllIlIllIlIllllll.cw, true, lllllllllllllllIllIlIllIlIlllIlI, lllllllllllllllIllIlIllIlIlllIlI, lllllllllllllllIllIlIllIlIlllIlI.length - 2);
        if (lllllllllllllllIllIlIllIlIllIlII) {
            lllllllllllllllIllIlIllIlIlllIIl.next = lllllllllllllllIllIlIllIlIllllll.tanns;
            lllllllllllllllIllIlIllIlIllllll.tanns = lllllllllllllllIllIlIllIlIlllIIl;
        } else {
            lllllllllllllllIllIlIllIlIlllIIl.next = lllllllllllllllIllIlIllIlIllllll.itanns;
            lllllllllllllllIllIlIllIlIllllll.itanns = lllllllllllllllIllIlIllIlIlllIIl;
        }
        return lllllllllllllllIllIlIllIlIlllIIl;
    }

    public void visitMethodInsn(int lllllllllllllllIllIlIllIIIIlIlll, String lllllllllllllllIllIlIllIIIIllllI, String lllllllllllllllIllIlIllIIIIlllIl, String lllllllllllllllIllIlIllIIIIlllII, boolean lllllllllllllllIllIlIllIIIIllIll) {
        MethodWriter lllllllllllllllIllIlIllIIIlIIIII;
        lllllllllllllllIllIlIllIIIlIIIII.lastCodeOffset = lllllllllllllllIllIlIllIIIlIIIII.code.length;
        Item lllllllllllllllIllIlIllIIIIllIlI = lllllllllllllllIllIlIllIIIlIIIII.cw.newMethodItem(lllllllllllllllIllIlIllIIIIllllI, lllllllllllllllIllIlIllIIIIlllIl, lllllllllllllllIllIlIllIIIIlllII, lllllllllllllllIllIlIllIIIIllIll);
        int lllllllllllllllIllIlIllIIIIllIIl = lllllllllllllllIllIlIllIIIIllIlI.intVal;
        if (lllllllllllllllIllIlIllIIIlIIIII.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIIlIIIII.compute == 0 || lllllllllllllllIllIlIllIIIlIIIII.compute == 1) {
                lllllllllllllllIllIlIllIIIlIIIII.currentBlock.frame.execute(lllllllllllllllIllIlIllIIIIlIlll, 0, lllllllllllllllIllIlIllIIIlIIIII.cw, lllllllllllllllIllIlIllIIIIllIlI);
            } else {
                int lllllllllllllllIllIlIllIIIlIIIIl;
                if (lllllllllllllllIllIlIllIIIIllIIl == 0) {
                    lllllllllllllllIllIlIllIIIIllIlI.intVal = lllllllllllllllIllIlIllIIIIllIIl = Type.getArgumentsAndReturnSizes(lllllllllllllllIllIlIllIIIIlllII);
                }
                if (lllllllllllllllIllIlIllIIIIlIlll == 184) {
                    int lllllllllllllllIllIlIllIIIlIIIlI = lllllllllllllllIllIlIllIIIlIIIII.stackSize - (lllllllllllllllIllIlIllIIIIllIIl >> 2) + (lllllllllllllllIllIlIllIIIIllIIl & 3) + 1;
                } else {
                    lllllllllllllllIllIlIllIIIlIIIIl = lllllllllllllllIllIlIllIIIlIIIII.stackSize - (lllllllllllllllIllIlIllIIIIllIIl >> 2) + (lllllllllllllllIllIlIllIIIIllIIl & 3);
                }
                if (lllllllllllllllIllIlIllIIIlIIIIl > lllllllllllllllIllIlIllIIIlIIIII.maxStackSize) {
                    lllllllllllllllIllIlIllIIIlIIIII.maxStackSize = lllllllllllllllIllIlIllIIIlIIIIl;
                }
                lllllllllllllllIllIlIllIIIlIIIII.stackSize = lllllllllllllllIllIlIllIIIlIIIIl;
            }
        }
        if (lllllllllllllllIllIlIllIIIIlIlll == 185) {
            if (lllllllllllllllIllIlIllIIIIllIIl == 0) {
                lllllllllllllllIllIlIllIIIIllIlI.intVal = lllllllllllllllIllIlIllIIIIllIIl = Type.getArgumentsAndReturnSizes(lllllllllllllllIllIlIllIIIIlllII);
            }
            lllllllllllllllIllIlIllIIIlIIIII.code.put12(185, lllllllllllllllIllIlIllIIIIllIlI.index).put11(lllllllllllllllIllIlIllIIIIllIIl >> 2, 0);
        } else {
            lllllllllllllllIllIlIllIIIlIIIII.code.put12(lllllllllllllllIllIlIllIIIIlIlll, lllllllllllllllIllIlIllIIIIllIlI.index);
        }
    }

    public void visitLocalVariable(String lllllllllllllllIllIlIlIlIIlllIIl, String lllllllllllllllIllIlIlIlIIllllll, String lllllllllllllllIllIlIlIlIIllIlll, Label lllllllllllllllIllIlIlIlIIllIllI, Label lllllllllllllllIllIlIlIlIIllllII, int lllllllllllllllIllIlIlIlIIlllIll) {
        char lllllllllllllllIllIlIlIlIlIIIIll;
        int lllllllllllllllIllIlIlIlIlIIIIlI;
        MethodWriter lllllllllllllllIllIlIlIlIlIIIIIl;
        if (lllllllllllllllIllIlIlIlIIllIlll != null) {
            if (lllllllllllllllIllIlIlIlIlIIIIIl.localVarType == null) {
                lllllllllllllllIllIlIlIlIlIIIIIl.localVarType = new ByteVector();
            }
            ++lllllllllllllllIllIlIlIlIlIIIIIl.localVarTypeCount;
            lllllllllllllllIllIlIlIlIlIIIIIl.localVarType.putShort(lllllllllllllllIllIlIlIlIIllIllI.position).putShort(lllllllllllllllIllIlIlIlIIllllII.position - lllllllllllllllIllIlIlIlIIllIllI.position).putShort(lllllllllllllllIllIlIlIlIlIIIIIl.cw.newUTF8(lllllllllllllllIllIlIlIlIIlllIIl)).putShort(lllllllllllllllIllIlIlIlIlIIIIIl.cw.newUTF8(lllllllllllllllIllIlIlIlIIllIlll)).putShort(lllllllllllllllIllIlIlIlIIlllIll);
        }
        if (lllllllllllllllIllIlIlIlIlIIIIIl.localVar == null) {
            lllllllllllllllIllIlIlIlIlIIIIIl.localVar = new ByteVector();
        }
        ++lllllllllllllllIllIlIlIlIlIIIIIl.localVarCount;
        lllllllllllllllIllIlIlIlIlIIIIIl.localVar.putShort(lllllllllllllllIllIlIlIlIIllIllI.position).putShort(lllllllllllllllIllIlIlIlIIllllII.position - lllllllllllllllIllIlIlIlIIllIllI.position).putShort(lllllllllllllllIllIlIlIlIlIIIIIl.cw.newUTF8(lllllllllllllllIllIlIlIlIIlllIIl)).putShort(lllllllllllllllIllIlIlIlIlIIIIIl.cw.newUTF8(lllllllllllllllIllIlIlIlIIllllll)).putShort(lllllllllllllllIllIlIlIlIIlllIll);
        if (lllllllllllllllIllIlIlIlIlIIIIIl.compute != 3 && (lllllllllllllllIllIlIlIlIlIIIIlI = lllllllllllllllIllIlIlIlIIlllIll + ((lllllllllllllllIllIlIlIlIlIIIIll = lllllllllllllllIllIlIlIlIIllllll.charAt(0)) == 'J' || lllllllllllllllIllIlIlIlIlIIIIll == 'D' ? 2 : 1)) > lllllllllllllllIllIlIlIlIlIIIIIl.maxLocals) {
            lllllllllllllllIllIlIlIlIlIIIIIl.maxLocals = lllllllllllllllIllIlIlIlIlIIIIlI;
        }
    }

    public AnnotationVisitor visitParameterAnnotation(int lllllllllllllllIllIlIllIlIlIIlII, String lllllllllllllllIllIlIllIlIlIIIll, boolean lllllllllllllllIllIlIllIlIlIIIlI) {
        MethodWriter lllllllllllllllIllIlIllIlIlIlIll;
        ByteVector lllllllllllllllIllIlIllIlIlIIlll = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(lllllllllllllllIllIlIllIlIlIIIll)) {
            lllllllllllllllIllIlIllIlIlIlIll.synthetics = Math.max(lllllllllllllllIllIlIllIlIlIlIll.synthetics, lllllllllllllllIllIlIllIlIlIIlII + 1);
            return new AnnotationWriter(lllllllllllllllIllIlIllIlIlIlIll.cw, false, lllllllllllllllIllIlIllIlIlIIlll, null, 0);
        }
        lllllllllllllllIllIlIllIlIlIIlll.putShort(lllllllllllllllIllIlIllIlIlIlIll.cw.newUTF8(lllllllllllllllIllIlIllIlIlIIIll)).putShort(0);
        AnnotationWriter lllllllllllllllIllIlIllIlIlIIllI = new AnnotationWriter(lllllllllllllllIllIlIllIlIlIlIll.cw, true, lllllllllllllllIllIlIllIlIlIIlll, lllllllllllllllIllIlIllIlIlIIlll, 2);
        if (lllllllllllllllIllIlIllIlIlIIIlI) {
            if (lllllllllllllllIllIlIllIlIlIlIll.panns == null) {
                lllllllllllllllIllIlIllIlIlIlIll.panns = new AnnotationWriter[Type.getArgumentTypes(lllllllllllllllIllIlIllIlIlIlIll.descriptor).length];
            }
            lllllllllllllllIllIlIllIlIlIIllI.next = lllllllllllllllIllIlIllIlIlIlIll.panns[lllllllllllllllIllIlIllIlIlIIlII];
            lllllllllllllllIllIlIllIlIlIlIll.panns[lllllllllllllllIllIlIllIlIlIIlII] = lllllllllllllllIllIlIllIlIlIIllI;
        } else {
            if (lllllllllllllllIllIlIllIlIlIlIll.ipanns == null) {
                lllllllllllllllIllIlIllIlIlIlIll.ipanns = new AnnotationWriter[Type.getArgumentTypes(lllllllllllllllIllIlIllIlIlIlIll.descriptor).length];
            }
            lllllllllllllllIllIlIllIlIlIIllI.next = lllllllllllllllIllIlIllIlIlIlIll.ipanns[lllllllllllllllIllIlIllIlIlIIlII];
            lllllllllllllllIllIlIllIlIlIlIll.ipanns[lllllllllllllllIllIlIllIlIlIIlII] = lllllllllllllllIllIlIllIlIlIIllI;
        }
        return lllllllllllllllIllIlIllIlIlIIllI;
    }

    public void visitCode() {
    }

    public AnnotationVisitor visitTryCatchAnnotation(int lllllllllllllllIllIlIlIlIlIlIIlI, TypePath lllllllllllllllIllIlIlIlIlIllIII, String lllllllllllllllIllIlIlIlIlIlIlll, boolean lllllllllllllllIllIlIlIlIlIlIllI) {
        MethodWriter lllllllllllllllIllIlIlIlIlIllIlI;
        ByteVector lllllllllllllllIllIlIlIlIlIlIlIl = new ByteVector();
        AnnotationWriter.putTarget(lllllllllllllllIllIlIlIlIlIlIIlI, lllllllllllllllIllIlIlIlIlIllIII, lllllllllllllllIllIlIlIlIlIlIlIl);
        lllllllllllllllIllIlIlIlIlIlIlIl.putShort(lllllllllllllllIllIlIlIlIlIllIlI.cw.newUTF8(lllllllllllllllIllIlIlIlIlIlIlll)).putShort(0);
        AnnotationWriter lllllllllllllllIllIlIlIlIlIlIlII = new AnnotationWriter(lllllllllllllllIllIlIlIlIlIllIlI.cw, true, lllllllllllllllIllIlIlIlIlIlIlIl, lllllllllllllllIllIlIlIlIlIlIlIl, lllllllllllllllIllIlIlIlIlIlIlIl.length - 2);
        if (lllllllllllllllIllIlIlIlIlIlIllI) {
            lllllllllllllllIllIlIlIlIlIlIlII.next = lllllllllllllllIllIlIlIlIlIllIlI.ctanns;
            lllllllllllllllIllIlIlIlIlIllIlI.ctanns = lllllllllllllllIllIlIlIlIlIlIlII;
        } else {
            lllllllllllllllIllIlIlIlIlIlIlII.next = lllllllllllllllIllIlIlIlIlIllIlI.ictanns;
            lllllllllllllllIllIlIlIlIlIllIlI.ictanns = lllllllllllllllIllIlIlIlIlIlIlII;
        }
        return lllllllllllllllIllIlIlIlIlIlIlII;
    }

    public void visitLabel(Label lllllllllllllllIllIlIlIllllIIIll) {
        MethodWriter lllllllllllllllIllIlIlIllllIIllI;
        lllllllllllllllIllIlIlIllllIIllI.cw.hasAsmInsns |= lllllllllllllllIllIlIlIllllIIIll.resolve(lllllllllllllllIllIlIlIllllIIllI, lllllllllllllllIllIlIlIllllIIllI.code.length, lllllllllllllllIllIlIlIllllIIllI.code.data);
        if ((lllllllllllllllIllIlIlIllllIIIll.status & 1) != 0) {
            return;
        }
        if (lllllllllllllllIllIlIlIllllIIllI.compute == 0) {
            if (lllllllllllllllIllIlIlIllllIIllI.currentBlock != null) {
                if (lllllllllllllllIllIlIlIllllIIIll.position == lllllllllllllllIllIlIlIllllIIllI.currentBlock.position) {
                    lllllllllllllllIllIlIlIllllIIllI.currentBlock.status |= lllllllllllllllIllIlIlIllllIIIll.status & 0x10;
                    lllllllllllllllIllIlIlIllllIIIll.frame = lllllllllllllllIllIlIlIllllIIllI.currentBlock.frame;
                    return;
                }
                lllllllllllllllIllIlIlIllllIIllI.addSuccessor(0, lllllllllllllllIllIlIlIllllIIIll);
            }
            lllllllllllllllIllIlIlIllllIIllI.currentBlock = lllllllllllllllIllIlIlIllllIIIll;
            if (lllllllllllllllIllIlIlIllllIIIll.frame == null) {
                lllllllllllllllIllIlIlIllllIIIll.frame = new Frame();
                lllllllllllllllIllIlIlIllllIIIll.frame.owner = lllllllllllllllIllIlIlIllllIIIll;
            }
            if (lllllllllllllllIllIlIlIllllIIllI.previousBlock != null) {
                if (lllllllllllllllIllIlIlIllllIIIll.position == lllllllllllllllIllIlIlIllllIIllI.previousBlock.position) {
                    lllllllllllllllIllIlIlIllllIIllI.previousBlock.status |= lllllllllllllllIllIlIlIllllIIIll.status & 0x10;
                    lllllllllllllllIllIlIlIllllIIIll.frame = lllllllllllllllIllIlIlIllllIIllI.previousBlock.frame;
                    lllllllllllllllIllIlIlIllllIIllI.currentBlock = lllllllllllllllIllIlIlIllllIIllI.previousBlock;
                    return;
                }
                lllllllllllllllIllIlIlIllllIIllI.previousBlock.successor = lllllllllllllllIllIlIlIllllIIIll;
            }
            lllllllllllllllIllIlIlIllllIIllI.previousBlock = lllllllllllllllIllIlIlIllllIIIll;
        } else if (lllllllllllllllIllIlIlIllllIIllI.compute == 1) {
            if (lllllllllllllllIllIlIlIllllIIllI.currentBlock == null) {
                lllllllllllllllIllIlIlIllllIIllI.currentBlock = lllllllllllllllIllIlIlIllllIIIll;
            } else {
                lllllllllllllllIllIlIlIllllIIllI.currentBlock.frame.owner = lllllllllllllllIllIlIlIllllIIIll;
            }
        } else if (lllllllllllllllIllIlIlIllllIIllI.compute == 2) {
            if (lllllllllllllllIllIlIlIllllIIllI.currentBlock != null) {
                lllllllllllllllIllIlIlIllllIIllI.currentBlock.outputStackMax = lllllllllllllllIllIlIlIllllIIllI.maxStackSize;
                lllllllllllllllIllIlIlIllllIIllI.addSuccessor(lllllllllllllllIllIlIlIllllIIllI.stackSize, lllllllllllllllIllIlIlIllllIIIll);
            }
            lllllllllllllllIllIlIlIllllIIllI.currentBlock = lllllllllllllllIllIlIlIllllIIIll;
            lllllllllllllllIllIlIlIllllIIllI.stackSize = 0;
            lllllllllllllllIllIlIlIllllIIllI.maxStackSize = 0;
            if (lllllllllllllllIllIlIlIllllIIllI.previousBlock != null) {
                lllllllllllllllIllIlIlIllllIIllI.previousBlock.successor = lllllllllllllllIllIlIlIllllIIIll;
            }
            lllllllllllllllIllIlIlIllllIIllI.previousBlock = lllllllllllllllIllIlIlIllllIIIll;
        }
    }

    private void writeFrame() {
        int lllllllllllllllIllIlIlIIIllIIlII;
        MethodWriter lllllllllllllllIllIlIlIIIllIIIll;
        int lllllllllllllllIllIlIlIIIllIlIIl = lllllllllllllllIllIlIlIIIllIIIll.frame[1];
        int lllllllllllllllIllIlIlIIIllIlIII = lllllllllllllllIllIlIlIIIllIIIll.frame[2];
        if ((lllllllllllllllIllIlIlIIIllIIIll.cw.version & 0xFFFF) < 50) {
            lllllllllllllllIllIlIlIIIllIIIll.stackMap.putShort(lllllllllllllllIllIlIlIIIllIIIll.frame[0]).putShort(lllllllllllllllIllIlIlIIIllIlIIl);
            lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3, 3 + lllllllllllllllIllIlIlIIIllIlIIl);
            lllllllllllllllIllIlIlIIIllIIIll.stackMap.putShort(lllllllllllllllIllIlIlIIIllIlIII);
            lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3 + lllllllllllllllIllIlIlIIIllIlIIl, 3 + lllllllllllllllIllIlIlIIIllIlIIl + lllllllllllllllIllIlIlIIIllIlIII);
            return;
        }
        int lllllllllllllllIllIlIlIIIllIIlll = lllllllllllllllIllIlIlIIIllIIIll.previousFrame[1];
        int lllllllllllllllIllIlIlIIIllIIllI = 255;
        int lllllllllllllllIllIlIlIIIllIIlIl = 0;
        if (lllllllllllllllIllIlIlIIIllIIIll.frameCount == 0) {
            int lllllllllllllllIllIlIlIIIllIllIl = lllllllllllllllIllIlIlIIIllIIIll.frame[0];
        } else {
            lllllllllllllllIllIlIlIIIllIIlII = lllllllllllllllIllIlIlIIIllIIIll.frame[0] - lllllllllllllllIllIlIlIIIllIIIll.previousFrame[0] - 1;
        }
        if (lllllllllllllllIllIlIlIIIllIlIII == 0) {
            lllllllllllllllIllIlIlIIIllIIlIl = lllllllllllllllIllIlIlIIIllIlIIl - lllllllllllllllIllIlIlIIIllIIlll;
            switch (lllllllllllllllIllIlIlIIIllIIlIl) {
                case -3: 
                case -2: 
                case -1: {
                    lllllllllllllllIllIlIlIIIllIIllI = 248;
                    lllllllllllllllIllIlIlIIIllIIlll = lllllllllllllllIllIlIlIIIllIlIIl;
                    break;
                }
                case 0: {
                    lllllllllllllllIllIlIlIIIllIIllI = lllllllllllllllIllIlIlIIIllIIlII < 64 ? 0 : 251;
                    break;
                }
                case 1: 
                case 2: 
                case 3: {
                    lllllllllllllllIllIlIlIIIllIIllI = 252;
                }
            }
        } else if (lllllllllllllllIllIlIlIIIllIlIIl == lllllllllllllllIllIlIlIIIllIIlll && lllllllllllllllIllIlIlIIIllIlIII == 1) {
            int n = lllllllllllllllIllIlIlIIIllIIllI = lllllllllllllllIllIlIlIIIllIIlII < 63 ? 64 : 247;
        }
        if (lllllllllllllllIllIlIlIIIllIIllI != 255) {
            int lllllllllllllllIllIlIlIIIllIlIll = 3;
            for (int lllllllllllllllIllIlIlIIIllIllII = 0; lllllllllllllllIllIlIlIIIllIllII < lllllllllllllllIllIlIlIIIllIIlll; ++lllllllllllllllIllIlIlIIIllIllII) {
                if (lllllllllllllllIllIlIlIIIllIIIll.frame[lllllllllllllllIllIlIlIIIllIlIll] != lllllllllllllllIllIlIlIIIllIIIll.previousFrame[lllllllllllllllIllIlIlIIIllIlIll]) {
                    lllllllllllllllIllIlIlIIIllIIllI = 255;
                    break;
                }
                ++lllllllllllllllIllIlIlIIIllIlIll;
            }
        }
        switch (lllllllllllllllIllIlIlIIIllIIllI) {
            case 0: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(lllllllllllllllIllIlIlIIIllIIlII);
                break;
            }
            case 64: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(64 + lllllllllllllllIllIlIlIIIllIIlII);
                lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3 + lllllllllllllllIllIlIlIIIllIlIIl, 4 + lllllllllllllllIllIlIlIIIllIlIIl);
                break;
            }
            case 247: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(247).putShort(lllllllllllllllIllIlIlIIIllIIlII);
                lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3 + lllllllllllllllIllIlIlIIIllIlIIl, 4 + lllllllllllllllIllIlIlIIIllIlIIl);
                break;
            }
            case 251: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(251).putShort(lllllllllllllllIllIlIlIIIllIIlII);
                break;
            }
            case 248: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(251 + lllllllllllllllIllIlIlIIIllIIlIl).putShort(lllllllllllllllIllIlIlIIIllIIlII);
                break;
            }
            case 252: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(251 + lllllllllllllllIllIlIlIIIllIIlIl).putShort(lllllllllllllllIllIlIlIIIllIIlII);
                lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3 + lllllllllllllllIllIlIlIIIllIIlll, 3 + lllllllllllllllIllIlIlIIIllIlIIl);
                break;
            }
            default: {
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putByte(255).putShort(lllllllllllllllIllIlIlIIIllIIlII).putShort(lllllllllllllllIllIlIlIIIllIlIIl);
                lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3, 3 + lllllllllllllllIllIlIlIIIllIlIIl);
                lllllllllllllllIllIlIlIIIllIIIll.stackMap.putShort(lllllllllllllllIllIlIlIIIllIlIII);
                lllllllllllllllIllIlIlIIIllIIIll.writeFrameTypes(3 + lllllllllllllllIllIlIlIIIllIlIIl, 3 + lllllllllllllllIllIlIlIIIllIlIIl + lllllllllllllllIllIlIlIIIllIlIII);
            }
        }
    }

    public void visitVarInsn(int lllllllllllllllIllIlIllIIlIllIII, int lllllllllllllllIllIlIllIIlIlIlll) {
        MethodWriter lllllllllllllllIllIlIllIIlIlllII;
        lllllllllllllllIllIlIllIIlIlllII.lastCodeOffset = lllllllllllllllIllIlIllIIlIlllII.code.length;
        if (lllllllllllllllIllIlIllIIlIlllII.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIlIlllII.compute == 0 || lllllllllllllllIllIlIllIIlIlllII.compute == 1) {
                lllllllllllllllIllIlIllIIlIlllII.currentBlock.frame.execute(lllllllllllllllIllIlIllIIlIllIII, lllllllllllllllIllIlIllIIlIlIlll, null, null);
            } else if (lllllllllllllllIllIlIllIIlIllIII == 169) {
                lllllllllllllllIllIlIllIIlIlllII.currentBlock.status |= 0x100;
                lllllllllllllllIllIlIllIIlIlllII.currentBlock.inputStackTop = lllllllllllllllIllIlIllIIlIlllII.stackSize;
                lllllllllllllllIllIlIllIIlIlllII.noSuccessor();
            } else {
                int lllllllllllllllIllIlIllIIllIIIIl = lllllllllllllllIllIlIllIIlIlllII.stackSize + Frame.SIZE[lllllllllllllllIllIlIllIIlIllIII];
                if (lllllllllllllllIllIlIllIIllIIIIl > lllllllllllllllIllIlIllIIlIlllII.maxStackSize) {
                    lllllllllllllllIllIlIllIIlIlllII.maxStackSize = lllllllllllllllIllIlIllIIllIIIIl;
                }
                lllllllllllllllIllIlIllIIlIlllII.stackSize = lllllllllllllllIllIlIllIIllIIIIl;
            }
        }
        if (lllllllllllllllIllIlIllIIlIlllII.compute != 3) {
            int lllllllllllllllIllIlIllIIlIlllll;
            if (lllllllllllllllIllIlIllIIlIllIII == 22 || lllllllllllllllIllIlIllIIlIllIII == 24 || lllllllllllllllIllIlIllIIlIllIII == 55 || lllllllllllllllIllIlIllIIlIllIII == 57) {
                int lllllllllllllllIllIlIllIIllIIIII = lllllllllllllllIllIlIllIIlIlIlll + 2;
            } else {
                lllllllllllllllIllIlIllIIlIlllll = lllllllllllllllIllIlIllIIlIlIlll + 1;
            }
            if (lllllllllllllllIllIlIllIIlIlllll > lllllllllllllllIllIlIllIIlIlllII.maxLocals) {
                lllllllllllllllIllIlIllIIlIlllII.maxLocals = lllllllllllllllIllIlIllIIlIlllll;
            }
        }
        if (lllllllllllllllIllIlIllIIlIlIlll < 4 && lllllllllllllllIllIlIllIIlIllIII != 169) {
            int lllllllllllllllIllIlIllIIlIlllIl;
            if (lllllllllllllllIllIlIllIIlIllIII < 54) {
                int lllllllllllllllIllIlIllIIlIllllI = 26 + (lllllllllllllllIllIlIllIIlIllIII - 21 << 2) + lllllllllllllllIllIlIllIIlIlIlll;
            } else {
                lllllllllllllllIllIlIllIIlIlllIl = 59 + (lllllllllllllllIllIlIllIIlIllIII - 54 << 2) + lllllllllllllllIllIlIllIIlIlIlll;
            }
            lllllllllllllllIllIlIllIIlIlllII.code.putByte(lllllllllllllllIllIlIllIIlIlllIl);
        } else if (lllllllllllllllIllIlIllIIlIlIlll >= 256) {
            lllllllllllllllIllIlIllIIlIlllII.code.putByte(196).put12(lllllllllllllllIllIlIllIIlIllIII, lllllllllllllllIllIlIllIIlIlIlll);
        } else {
            lllllllllllllllIllIlIllIIlIlllII.code.put11(lllllllllllllllIllIlIllIIlIllIII, lllllllllllllllIllIlIllIIlIlIlll);
        }
        if (lllllllllllllllIllIlIllIIlIllIII >= 54 && lllllllllllllllIllIlIllIIlIlllII.compute == 0 && lllllllllllllllIllIlIllIIlIlllII.handlerCount > 0) {
            lllllllllllllllIllIlIllIIlIlllII.visitLabel(new Label());
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int lllllllllllllllIllIlIlIlIIIllIlI, TypePath lllllllllllllllIllIlIlIlIIlIIIll, Label[] lllllllllllllllIllIlIlIlIIlIIIlI, Label[] lllllllllllllllIllIlIlIlIIlIIIIl, int[] lllllllllllllllIllIlIlIlIIIlIllI, String lllllllllllllllIllIlIlIlIIIlllll, boolean lllllllllllllllIllIlIlIlIIIllllI) {
        MethodWriter lllllllllllllllIllIlIlIlIIlIIlIl;
        ByteVector lllllllllllllllIllIlIlIlIIIlllIl = new ByteVector();
        lllllllllllllllIllIlIlIlIIIlllIl.putByte(lllllllllllllllIllIlIlIlIIIllIlI >>> 24).putShort(lllllllllllllllIllIlIlIlIIlIIIlI.length);
        for (int lllllllllllllllIllIlIlIlIIlIIlll = 0; lllllllllllllllIllIlIlIlIIlIIlll < lllllllllllllllIllIlIlIlIIlIIIlI.length; ++lllllllllllllllIllIlIlIlIIlIIlll) {
            lllllllllllllllIllIlIlIlIIIlllIl.putShort(lllllllllllllllIllIlIlIlIIlIIIlI[lllllllllllllllIllIlIlIlIIlIIlll].position).putShort(lllllllllllllllIllIlIlIlIIlIIIIl[lllllllllllllllIllIlIlIlIIlIIlll].position - lllllllllllllllIllIlIlIlIIlIIIlI[lllllllllllllllIllIlIlIlIIlIIlll].position).putShort(lllllllllllllllIllIlIlIlIIIlIllI[lllllllllllllllIllIlIlIlIIlIIlll]);
        }
        if (lllllllllllllllIllIlIlIlIIlIIIll == null) {
            lllllllllllllllIllIlIlIlIIIlllIl.putByte(0);
        } else {
            int lllllllllllllllIllIlIlIlIIlIIllI = lllllllllllllllIllIlIlIlIIlIIIll.b[lllllllllllllllIllIlIlIlIIlIIIll.offset] * 2 + 1;
            lllllllllllllllIllIlIlIlIIIlllIl.putByteArray(lllllllllllllllIllIlIlIlIIlIIIll.b, lllllllllllllllIllIlIlIlIIlIIIll.offset, lllllllllllllllIllIlIlIlIIlIIllI);
        }
        lllllllllllllllIllIlIlIlIIIlllIl.putShort(lllllllllllllllIllIlIlIlIIlIIlIl.cw.newUTF8(lllllllllllllllIllIlIlIlIIIlllll)).putShort(0);
        AnnotationWriter lllllllllllllllIllIlIlIlIIIlllII = new AnnotationWriter(lllllllllllllllIllIlIlIlIIlIIlIl.cw, true, lllllllllllllllIllIlIlIlIIIlllIl, lllllllllllllllIllIlIlIlIIIlllIl, lllllllllllllllIllIlIlIlIIIlllIl.length - 2);
        if (lllllllllllllllIllIlIlIlIIIllllI) {
            lllllllllllllllIllIlIlIlIIIlllII.next = lllllllllllllllIllIlIlIlIIlIIlIl.ctanns;
            lllllllllllllllIllIlIlIlIIlIIlIl.ctanns = lllllllllllllllIllIlIlIlIIIlllII;
        } else {
            lllllllllllllllIllIlIlIlIIIlllII.next = lllllllllllllllIllIlIlIlIIlIIlIl.ictanns;
            lllllllllllllllIllIlIlIlIIlIIlIl.ictanns = lllllllllllllllIllIlIlIlIIIlllII;
        }
        return lllllllllllllllIllIlIlIlIIIlllII;
    }

    public void visitMultiANewArrayInsn(String lllllllllllllllIllIlIlIllIIIlIll, int lllllllllllllllIllIlIlIllIIIlIlI) {
        MethodWriter lllllllllllllllIllIlIlIllIIlIIII;
        lllllllllllllllIllIlIlIllIIlIIII.lastCodeOffset = lllllllllllllllIllIlIlIllIIlIIII.code.length;
        Item lllllllllllllllIllIlIlIllIIIllIl = lllllllllllllllIllIlIlIllIIlIIII.cw.newClassItem(lllllllllllllllIllIlIlIllIIIlIll);
        if (lllllllllllllllIllIlIlIllIIlIIII.currentBlock != null) {
            if (lllllllllllllllIllIlIlIllIIlIIII.compute == 0 || lllllllllllllllIllIlIlIllIIlIIII.compute == 1) {
                lllllllllllllllIllIlIlIllIIlIIII.currentBlock.frame.execute(197, lllllllllllllllIllIlIlIllIIIlIlI, lllllllllllllllIllIlIlIllIIlIIII.cw, lllllllllllllllIllIlIlIllIIIllIl);
            } else {
                lllllllllllllllIllIlIlIllIIlIIII.stackSize += 1 - lllllllllllllllIllIlIlIllIIIlIlI;
            }
        }
        lllllllllllllllIllIlIlIllIIlIIII.code.put12(197, lllllllllllllllIllIlIlIllIIIllIl.index).putByte(lllllllllllllllIllIlIlIllIIIlIlI);
    }

    MethodWriter(ClassWriter lllllllllllllllIllIlIllIlllIlIIl, int lllllllllllllllIllIlIllIlllIlIII, String lllllllllllllllIllIlIllIlllIllll, String lllllllllllllllIllIlIllIlllIIllI, String lllllllllllllllIllIlIllIlllIllIl, String[] lllllllllllllllIllIlIllIlllIIlII, int lllllllllllllllIllIlIllIlllIIIll) {
        super(327680);
        MethodWriter lllllllllllllllIllIlIllIllllIIlI;
        lllllllllllllllIllIlIllIllllIIlI.code = new ByteVector();
        if (lllllllllllllllIllIlIllIlllIlIIl.firstMethod == null) {
            lllllllllllllllIllIlIllIlllIlIIl.firstMethod = lllllllllllllllIllIlIllIllllIIlI;
        } else {
            lllllllllllllllIllIlIllIlllIlIIl.lastMethod.mv = lllllllllllllllIllIlIllIllllIIlI;
        }
        lllllllllllllllIllIlIllIlllIlIIl.lastMethod = lllllllllllllllIllIlIllIllllIIlI;
        lllllllllllllllIllIlIllIllllIIlI.cw = lllllllllllllllIllIlIllIlllIlIIl;
        lllllllllllllllIllIlIllIllllIIlI.access = lllllllllllllllIllIlIllIlllIlIII;
        if ("<init>".equals(lllllllllllllllIllIlIllIlllIllll)) {
            lllllllllllllllIllIlIllIllllIIlI.access |= 0x80000;
        }
        lllllllllllllllIllIlIllIllllIIlI.name = lllllllllllllllIllIlIllIlllIlIIl.newUTF8(lllllllllllllllIllIlIllIlllIllll);
        lllllllllllllllIllIlIllIllllIIlI.desc = lllllllllllllllIllIlIllIlllIlIIl.newUTF8(lllllllllllllllIllIlIllIlllIIllI);
        lllllllllllllllIllIlIllIllllIIlI.descriptor = lllllllllllllllIllIlIllIlllIIllI;
        lllllllllllllllIllIlIllIllllIIlI.signature = lllllllllllllllIllIlIllIlllIllIl;
        if (lllllllllllllllIllIlIllIlllIIlII != null && lllllllllllllllIllIlIllIlllIIlII.length > 0) {
            lllllllllllllllIllIlIllIllllIIlI.exceptionCount = lllllllllllllllIllIlIllIlllIIlII.length;
            lllllllllllllllIllIlIllIllllIIlI.exceptions = new int[lllllllllllllllIllIlIllIllllIIlI.exceptionCount];
            for (int lllllllllllllllIllIlIllIllllIlII = 0; lllllllllllllllIllIlIllIllllIlII < lllllllllllllllIllIlIllIllllIIlI.exceptionCount; ++lllllllllllllllIllIlIllIllllIlII) {
                lllllllllllllllIllIlIllIllllIIlI.exceptions[lllllllllllllllIllIlIllIllllIlII] = lllllllllllllllIllIlIllIlllIlIIl.newClass(lllllllllllllllIllIlIllIlllIIlII[lllllllllllllllIllIlIllIllllIlII]);
            }
        }
        lllllllllllllllIllIlIllIllllIIlI.compute = lllllllllllllllIllIlIllIlllIIIll;
        if (lllllllllllllllIllIlIllIlllIIIll != 3) {
            int lllllllllllllllIllIlIllIllllIIll = Type.getArgumentsAndReturnSizes(lllllllllllllllIllIlIllIllllIIlI.descriptor) >> 2;
            if ((lllllllllllllllIllIlIllIlllIlIII & 8) != 0) {
                --lllllllllllllllIllIlIllIllllIIll;
            }
            lllllllllllllllIllIlIllIllllIIlI.maxLocals = lllllllllllllllIllIlIllIllllIIll;
            lllllllllllllllIllIlIllIllllIIlI.currentLocals = lllllllllllllllIllIlIllIllllIIll;
            lllllllllllllllIllIlIllIllllIIlI.labels = new Label();
            lllllllllllllllIllIlIllIllllIIlI.labels.status |= 8;
            lllllllllllllllIllIlIllIllllIIlI.visitLabel(lllllllllllllllIllIlIllIllllIIlI.labels);
        }
    }

    private void addSuccessor(int lllllllllllllllIllIlIlIIlIlllllI, Label lllllllllllllllIllIlIlIIllIIIIIl) {
        MethodWriter lllllllllllllllIllIlIlIIllIIIIll;
        Edge lllllllllllllllIllIlIlIIllIIIIII = new Edge();
        lllllllllllllllIllIlIlIIllIIIIII.info = lllllllllllllllIllIlIlIIlIlllllI;
        lllllllllllllllIllIlIlIIllIIIIII.successor = lllllllllllllllIllIlIlIIllIIIIIl;
        lllllllllllllllIllIlIlIIllIIIIII.next = lllllllllllllllIllIlIlIIllIIIIll.currentBlock.successors;
        lllllllllllllllIllIlIlIIllIIIIll.currentBlock.successors = lllllllllllllllIllIlIlIIllIIIIII;
    }

    public void visitLookupSwitchInsn(Label lllllllllllllllIllIlIlIllIlIIllI, int[] lllllllllllllllIllIlIlIllIlIlIlI, Label[] lllllllllllllllIllIlIlIllIlIlIIl) {
        MethodWriter lllllllllllllllIllIlIlIllIlIIlll;
        lllllllllllllllIllIlIlIllIlIIlll.lastCodeOffset = lllllllllllllllIllIlIlIllIlIIlll.code.length;
        int lllllllllllllllIllIlIlIllIlIlIII = lllllllllllllllIllIlIlIllIlIIlll.code.length;
        lllllllllllllllIllIlIlIllIlIIlll.code.putByte(171);
        lllllllllllllllIllIlIlIllIlIIlll.code.putByteArray(null, 0, (4 - lllllllllllllllIllIlIlIllIlIIlll.code.length % 4) % 4);
        lllllllllllllllIllIlIlIllIlIIllI.put(lllllllllllllllIllIlIlIllIlIIlll, lllllllllllllllIllIlIlIllIlIIlll.code, lllllllllllllllIllIlIlIllIlIlIII, true);
        lllllllllllllllIllIlIlIllIlIIlll.code.putInt(lllllllllllllllIllIlIlIllIlIlIIl.length);
        for (int lllllllllllllllIllIlIlIllIlIllIl = 0; lllllllllllllllIllIlIlIllIlIllIl < lllllllllllllllIllIlIlIllIlIlIIl.length; ++lllllllllllllllIllIlIlIllIlIllIl) {
            lllllllllllllllIllIlIlIllIlIIlll.code.putInt(lllllllllllllllIllIlIlIllIlIlIlI[lllllllllllllllIllIlIlIllIlIllIl]);
            lllllllllllllllIllIlIlIllIlIlIIl[lllllllllllllllIllIlIlIllIlIllIl].put(lllllllllllllllIllIlIlIllIlIIlll, lllllllllllllllIllIlIlIllIlIIlll.code, lllllllllllllllIllIlIlIllIlIlIII, true);
        }
        lllllllllllllllIllIlIlIllIlIIlll.visitSwitchInsn(lllllllllllllllIllIlIlIllIlIIllI, lllllllllllllllIllIlIlIllIlIlIIl);
    }

    public void visitFieldInsn(int lllllllllllllllIllIlIllIIIlllIII, String lllllllllllllllIllIlIllIIIllIIIl, String lllllllllllllllIllIlIllIIIllIIII, String lllllllllllllllIllIlIllIIIlIllll) {
        MethodWriter lllllllllllllllIllIlIllIIIllIIll;
        lllllllllllllllIllIlIllIIIllIIll.lastCodeOffset = lllllllllllllllIllIlIllIIIllIIll.code.length;
        Item lllllllllllllllIllIlIllIIIllIlII = lllllllllllllllIllIlIllIIIllIIll.cw.newFieldItem(lllllllllllllllIllIlIllIIIllIIIl, lllllllllllllllIllIlIllIIIllIIII, lllllllllllllllIllIlIllIIIlIllll);
        if (lllllllllllllllIllIlIllIIIllIIll.currentBlock != null) {
            if (lllllllllllllllIllIlIllIIIllIIll.compute == 0 || lllllllllllllllIllIlIllIIIllIIll.compute == 1) {
                lllllllllllllllIllIlIllIIIllIIll.currentBlock.frame.execute(lllllllllllllllIllIlIllIIIlllIII, 0, lllllllllllllllIllIlIllIIIllIIll.cw, lllllllllllllllIllIlIllIIIllIlII);
            } else {
                int lllllllllllllllIllIlIllIIIlllIll;
                char lllllllllllllllIllIlIllIIIlllIlI = lllllllllllllllIllIlIllIIIlIllll.charAt(0);
                switch (lllllllllllllllIllIlIllIIIlllIII) {
                    case 178: {
                        int lllllllllllllllIllIlIllIIIlllllI = lllllllllllllllIllIlIllIIIllIIll.stackSize + (lllllllllllllllIllIlIllIIIlllIlI == 'D' || lllllllllllllllIllIlIllIIIlllIlI == 'J' ? 2 : 1);
                        break;
                    }
                    case 179: {
                        int lllllllllllllllIllIlIllIIIllllIl = lllllllllllllllIllIlIllIIIllIIll.stackSize + (lllllllllllllllIllIlIllIIIlllIlI == 'D' || lllllllllllllllIllIlIllIIIlllIlI == 'J' ? -2 : -1);
                        break;
                    }
                    case 180: {
                        int lllllllllllllllIllIlIllIIIllllII = lllllllllllllllIllIlIllIIIllIIll.stackSize + (lllllllllllllllIllIlIllIIIlllIlI == 'D' || lllllllllllllllIllIlIllIIIlllIlI == 'J' ? 1 : 0);
                        break;
                    }
                    default: {
                        lllllllllllllllIllIlIllIIIlllIll = lllllllllllllllIllIlIllIIIllIIll.stackSize + (lllllllllllllllIllIlIllIIIlllIlI == 'D' || lllllllllllllllIllIlIllIIIlllIlI == 'J' ? -3 : -2);
                    }
                }
                if (lllllllllllllllIllIlIllIIIlllIll > lllllllllllllllIllIlIllIIIllIIll.maxStackSize) {
                    lllllllllllllllIllIlIllIIIllIIll.maxStackSize = lllllllllllllllIllIlIllIIIlllIll;
                }
                lllllllllllllllIllIlIllIIIllIIll.stackSize = lllllllllllllllIllIlIllIIIlllIll;
            }
        }
        lllllllllllllllIllIlIllIIIllIIll.code.put12(lllllllllllllllIllIlIllIIIlllIII, lllllllllllllllIllIlIllIIIllIlII.index);
    }

    public void visitParameter(String lllllllllllllllIllIlIllIllIlllIl, int lllllllllllllllIllIlIllIllIllIIl) {
        MethodWriter lllllllllllllllIllIlIllIllIllIll;
        if (lllllllllllllllIllIlIllIllIllIll.methodParameters == null) {
            lllllllllllllllIllIlIllIllIllIll.methodParameters = new ByteVector();
        }
        ++lllllllllllllllIllIlIllIllIllIll.methodParametersCount;
        lllllllllllllllIllIlIllIllIllIll.methodParameters.putShort(lllllllllllllllIllIlIllIllIlllIl == null ? 0 : lllllllllllllllIllIlIllIllIllIll.cw.newUTF8(lllllllllllllllIllIlIllIllIlllIl)).putShort(lllllllllllllllIllIlIllIllIllIIl);
    }

    private void visitImplicitFirstFrame() {
        MethodWriter lllllllllllllllIllIlIlIIlIIIllII;
        int lllllllllllllllIllIlIlIIlIIIlllI = lllllllllllllllIllIlIlIIlIIIllII.startFrame(0, lllllllllllllllIllIlIlIIlIIIllII.descriptor.length() + 1, 0);
        if ((lllllllllllllllIllIlIlIIlIIIllII.access & 8) == 0) {
            lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = (lllllllllllllllIllIlIlIIlIIIllII.access & 0x80000) == 0 ? 0x1700000 | lllllllllllllllIllIlIlIIlIIIllII.cw.addType(lllllllllllllllIllIlIlIIlIIIllII.cw.thisName) : 6;
        }
        int lllllllllllllllIllIlIlIIlIIIllIl = 1;
        block8: while (true) {
            int lllllllllllllllIllIlIlIIlIIlIIII = lllllllllllllllIllIlIlIIlIIIllIl;
            switch (lllllllllllllllIllIlIlIIlIIIllII.descriptor.charAt(lllllllllllllllIllIlIlIIlIIIllIl++)) {
                case 'B': 
                case 'C': 
                case 'I': 
                case 'S': 
                case 'Z': {
                    lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = 1;
                    continue block8;
                }
                case 'F': {
                    lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = 2;
                    continue block8;
                }
                case 'J': {
                    lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = 4;
                    continue block8;
                }
                case 'D': {
                    lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = 3;
                    continue block8;
                }
                case '[': {
                    while (lllllllllllllllIllIlIlIIlIIIllII.descriptor.charAt(lllllllllllllllIllIlIlIIlIIIllIl) == '[') {
                        ++lllllllllllllllIllIlIlIIlIIIllIl;
                    }
                    if (lllllllllllllllIllIlIlIIlIIIllII.descriptor.charAt(lllllllllllllllIllIlIlIIlIIIllIl) == 'L') {
                        ++lllllllllllllllIllIlIlIIlIIIllIl;
                        while (lllllllllllllllIllIlIlIIlIIIllII.descriptor.charAt(lllllllllllllllIllIlIlIIlIIIllIl) != ';') {
                            ++lllllllllllllllIllIlIlIIlIIIllIl;
                        }
                    }
                    lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = 0x1700000 | lllllllllllllllIllIlIlIIlIIIllII.cw.addType(lllllllllllllllIllIlIlIIlIIIllII.descriptor.substring(lllllllllllllllIllIlIlIIlIIlIIII, ++lllllllllllllllIllIlIlIIlIIIllIl));
                    continue block8;
                }
                case 'L': {
                    while (lllllllllllllllIllIlIlIIlIIIllII.descriptor.charAt(lllllllllllllllIllIlIlIIlIIIllIl) != ';') {
                        ++lllllllllllllllIllIlIlIIlIIIllIl;
                    }
                    lllllllllllllllIllIlIlIIlIIIllII.frame[lllllllllllllllIllIlIlIIlIIIlllI++] = 0x1700000 | lllllllllllllllIllIlIlIIlIIIllII.cw.addType(lllllllllllllllIllIlIlIIlIIIllII.descriptor.substring(lllllllllllllllIllIlIlIIlIIlIIII + 1, lllllllllllllllIllIlIlIIlIIIllIl++));
                    continue block8;
                }
            }
            break;
        }
        lllllllllllllllIllIlIlIIlIIIllII.frame[1] = lllllllllllllllIllIlIlIIlIIIlllI - 3;
        lllllllllllllllIllIlIlIIlIIIllII.endFrame();
    }

    public void visitLineNumber(int lllllllllllllllIllIlIlIlIIIIllIl, Label lllllllllllllllIllIlIlIlIIIIlIIl) {
        MethodWriter lllllllllllllllIllIlIlIlIIIIlllI;
        if (lllllllllllllllIllIlIlIlIIIIlllI.lineNumber == null) {
            lllllllllllllllIllIlIlIlIIIIlllI.lineNumber = new ByteVector();
        }
        ++lllllllllllllllIllIlIlIlIIIIlllI.lineNumberCount;
        lllllllllllllllIllIlIlIlIIIIlllI.lineNumber.putShort(lllllllllllllllIllIlIlIlIIIIlIIl.position);
        lllllllllllllllIllIlIlIlIIIIlllI.lineNumber.putShort(lllllllllllllllIllIlIlIlIIIIllIl);
    }

    private void noSuccessor() {
        MethodWriter lllllllllllllllIllIlIlIIlIlllIII;
        if (lllllllllllllllIllIlIlIIlIlllIII.compute == 0) {
            Label lllllllllllllllIllIlIlIIlIlllIIl = new Label();
            lllllllllllllllIllIlIlIIlIlllIIl.frame = new Frame();
            lllllllllllllllIllIlIlIIlIlllIIl.frame.owner = lllllllllllllllIllIlIlIIlIlllIIl;
            lllllllllllllllIllIlIlIIlIlllIIl.resolve(lllllllllllllllIllIlIlIIlIlllIII, lllllllllllllllIllIlIlIIlIlllIII.code.length, lllllllllllllllIllIlIlIIlIlllIII.code.data);
            lllllllllllllllIllIlIlIIlIlllIII.previousBlock.successor = lllllllllllllllIllIlIlIIlIlllIIl;
            lllllllllllllllIllIlIlIIlIlllIII.previousBlock = lllllllllllllllIllIlIlIIlIlllIIl;
        } else {
            lllllllllllllllIllIlIlIIlIlllIII.currentBlock.outputStackMax = lllllllllllllllIllIlIlIIlIlllIII.maxStackSize;
        }
        if (lllllllllllllllIllIlIlIIlIlllIII.compute != 1) {
            lllllllllllllllIllIlIlIIlIlllIII.currentBlock = null;
        }
    }

    public void visitEnd() {
    }
}

