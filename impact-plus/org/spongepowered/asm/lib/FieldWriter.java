/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.AnnotationWriter;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;

final class FieldWriter
extends FieldVisitor {
    private /* synthetic */ AnnotationWriter anns;
    private /* synthetic */ Attribute attrs;
    private /* synthetic */ AnnotationWriter tanns;
    private /* synthetic */ AnnotationWriter ianns;
    private /* synthetic */ int signature;
    private final /* synthetic */ int name;
    private /* synthetic */ int value;
    private final /* synthetic */ int desc;
    private final /* synthetic */ ClassWriter cw;
    private /* synthetic */ AnnotationWriter itanns;
    private final /* synthetic */ int access;

    int getSize() {
        FieldWriter llllllllllllllllIIIIllIIllllIIll;
        int llllllllllllllllIIIIllIIllllIlIl = 8;
        if (llllllllllllllllIIIIllIIllllIIll.value != 0) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("ConstantValue");
            llllllllllllllllIIIIllIIllllIlIl += 8;
        }
        if ((llllllllllllllllIIIIllIIllllIIll.access & 0x1000) != 0 && ((llllllllllllllllIIIIllIIllllIIll.cw.version & 0xFFFF) < 49 || (llllllllllllllllIIIIllIIllllIIll.access & 0x40000) != 0)) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("Synthetic");
            llllllllllllllllIIIIllIIllllIlIl += 6;
        }
        if ((llllllllllllllllIIIIllIIllllIIll.access & 0x20000) != 0) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("Deprecated");
            llllllllllllllllIIIIllIIllllIlIl += 6;
        }
        if (llllllllllllllllIIIIllIIllllIIll.signature != 0) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("Signature");
            llllllllllllllllIIIIllIIllllIlIl += 8;
        }
        if (llllllllllllllllIIIIllIIllllIIll.anns != null) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("RuntimeVisibleAnnotations");
            llllllllllllllllIIIIllIIllllIlIl += 8 + llllllllllllllllIIIIllIIllllIIll.anns.getSize();
        }
        if (llllllllllllllllIIIIllIIllllIIll.ianns != null) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("RuntimeInvisibleAnnotations");
            llllllllllllllllIIIIllIIllllIlIl += 8 + llllllllllllllllIIIIllIIllllIIll.ianns.getSize();
        }
        if (llllllllllllllllIIIIllIIllllIIll.tanns != null) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("RuntimeVisibleTypeAnnotations");
            llllllllllllllllIIIIllIIllllIlIl += 8 + llllllllllllllllIIIIllIIllllIIll.tanns.getSize();
        }
        if (llllllllllllllllIIIIllIIllllIIll.itanns != null) {
            llllllllllllllllIIIIllIIllllIIll.cw.newUTF8("RuntimeInvisibleTypeAnnotations");
            llllllllllllllllIIIIllIIllllIlIl += 8 + llllllllllllllllIIIIllIIllllIIll.itanns.getSize();
        }
        if (llllllllllllllllIIIIllIIllllIIll.attrs != null) {
            llllllllllllllllIIIIllIIllllIlIl += llllllllllllllllIIIIllIIllllIIll.attrs.getSize(llllllllllllllllIIIIllIIllllIIll.cw, null, 0, -1, -1);
        }
        return llllllllllllllllIIIIllIIllllIlIl;
    }

    FieldWriter(ClassWriter llllllllllllllllIIIIllIlIllIllll, int llllllllllllllllIIIIllIlIlllIlll, String llllllllllllllllIIIIllIlIlllIllI, String llllllllllllllllIIIIllIlIlllIlIl, String llllllllllllllllIIIIllIlIlllIIll, Object llllllllllllllllIIIIllIlIllIIlll) {
        super(327680);
        FieldWriter llllllllllllllllIIIIllIlIlllIIII;
        if (llllllllllllllllIIIIllIlIllIllll.firstField == null) {
            llllllllllllllllIIIIllIlIllIllll.firstField = llllllllllllllllIIIIllIlIlllIIII;
        } else {
            llllllllllllllllIIIIllIlIllIllll.lastField.fv = llllllllllllllllIIIIllIlIlllIIII;
        }
        llllllllllllllllIIIIllIlIllIllll.lastField = llllllllllllllllIIIIllIlIlllIIII;
        llllllllllllllllIIIIllIlIlllIIII.cw = llllllllllllllllIIIIllIlIllIllll;
        llllllllllllllllIIIIllIlIlllIIII.access = llllllllllllllllIIIIllIlIlllIlll;
        llllllllllllllllIIIIllIlIlllIIII.name = llllllllllllllllIIIIllIlIllIllll.newUTF8(llllllllllllllllIIIIllIlIlllIllI);
        llllllllllllllllIIIIllIlIlllIIII.desc = llllllllllllllllIIIIllIlIllIllll.newUTF8(llllllllllllllllIIIIllIlIlllIlIl);
        if (llllllllllllllllIIIIllIlIlllIIll != null) {
            llllllllllllllllIIIIllIlIlllIIII.signature = llllllllllllllllIIIIllIlIllIllll.newUTF8(llllllllllllllllIIIIllIlIlllIIll);
        }
        if (llllllllllllllllIIIIllIlIllIIlll != null) {
            llllllllllllllllIIIIllIlIlllIIII.value = llllllllllllllllIIIIllIlIllIllll.newConstItem((Object)llllllllllllllllIIIIllIlIllIIlll).index;
        }
    }

    void put(ByteVector llllllllllllllllIIIIllIIllIIIlIl) {
        FieldWriter llllllllllllllllIIIIllIIllIlIIIl;
        int llllllllllllllllIIIIllIIllIIllIl = 64;
        int llllllllllllllllIIIIllIIllIIlIll = 0x60000 | (llllllllllllllllIIIIllIIllIlIIIl.access & 0x40000) / 64;
        llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.access & ~llllllllllllllllIIIIllIIllIIlIll).putShort(llllllllllllllllIIIIllIIllIlIIIl.name).putShort(llllllllllllllllIIIIllIIllIlIIIl.desc);
        int llllllllllllllllIIIIllIIllIIlIIl = 0;
        if (llllllllllllllllIIIIllIIllIlIIIl.value != 0) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if ((llllllllllllllllIIIIllIIllIlIIIl.access & 0x1000) != 0 && ((llllllllllllllllIIIIllIIllIlIIIl.cw.version & 0xFFFF) < 49 || (llllllllllllllllIIIIllIIllIlIIIl.access & 0x40000) != 0)) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if ((llllllllllllllllIIIIllIIllIlIIIl.access & 0x20000) != 0) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.signature != 0) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.anns != null) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.ianns != null) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.tanns != null) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.itanns != null) {
            ++llllllllllllllllIIIIllIIllIIlIIl;
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.attrs != null) {
            llllllllllllllllIIIIllIIllIIlIIl += llllllllllllllllIIIIllIIllIlIIIl.attrs.getCount();
        }
        llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIIlIIl);
        if (llllllllllllllllIIIIllIIllIlIIIl.value != 0) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("ConstantValue"));
            llllllllllllllllIIIIllIIllIIIlIl.putInt(2).putShort(llllllllllllllllIIIIllIIllIlIIIl.value);
        }
        if ((llllllllllllllllIIIIllIIllIlIIIl.access & 0x1000) != 0 && ((llllllllllllllllIIIIllIIllIlIIIl.cw.version & 0xFFFF) < 49 || (llllllllllllllllIIIIllIIllIlIIIl.access & 0x40000) != 0)) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("Synthetic")).putInt(0);
        }
        if ((llllllllllllllllIIIIllIIllIlIIIl.access & 0x20000) != 0) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("Deprecated")).putInt(0);
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.signature != 0) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("Signature"));
            llllllllllllllllIIIIllIIllIIIlIl.putInt(2).putShort(llllllllllllllllIIIIllIIllIlIIIl.signature);
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.anns != null) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("RuntimeVisibleAnnotations"));
            llllllllllllllllIIIIllIIllIlIIIl.anns.put(llllllllllllllllIIIIllIIllIIIlIl);
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.ianns != null) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("RuntimeInvisibleAnnotations"));
            llllllllllllllllIIIIllIIllIlIIIl.ianns.put(llllllllllllllllIIIIllIIllIIIlIl);
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.tanns != null) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("RuntimeVisibleTypeAnnotations"));
            llllllllllllllllIIIIllIIllIlIIIl.tanns.put(llllllllllllllllIIIIllIIllIIIlIl);
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.itanns != null) {
            llllllllllllllllIIIIllIIllIIIlIl.putShort(llllllllllllllllIIIIllIIllIlIIIl.cw.newUTF8("RuntimeInvisibleTypeAnnotations"));
            llllllllllllllllIIIIllIIllIlIIIl.itanns.put(llllllllllllllllIIIIllIIllIIIlIl);
        }
        if (llllllllllllllllIIIIllIIllIlIIIl.attrs != null) {
            llllllllllllllllIIIIllIIllIlIIIl.attrs.put(llllllllllllllllIIIIllIIllIlIIIl.cw, null, 0, -1, -1, llllllllllllllllIIIIllIIllIIIlIl);
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllIIIIllIlIIlIlIIl, TypePath llllllllllllllllIIIIllIlIIlIIlll, String llllllllllllllllIIIIllIlIIllIIll, boolean llllllllllllllllIIIIllIlIIllIIIl) {
        FieldWriter llllllllllllllllIIIIllIlIIlIlIll;
        ByteVector llllllllllllllllIIIIllIlIIlIllll = new ByteVector();
        AnnotationWriter.putTarget(llllllllllllllllIIIIllIlIIlIlIIl, llllllllllllllllIIIIllIlIIlIIlll, llllllllllllllllIIIIllIlIIlIllll);
        llllllllllllllllIIIIllIlIIlIllll.putShort(llllllllllllllllIIIIllIlIIlIlIll.cw.newUTF8(llllllllllllllllIIIIllIlIIllIIll)).putShort(0);
        AnnotationWriter llllllllllllllllIIIIllIlIIlIllIl = new AnnotationWriter(llllllllllllllllIIIIllIlIIlIlIll.cw, true, llllllllllllllllIIIIllIlIIlIllll, llllllllllllllllIIIIllIlIIlIllll, llllllllllllllllIIIIllIlIIlIllll.length - 2);
        if (llllllllllllllllIIIIllIlIIllIIIl) {
            llllllllllllllllIIIIllIlIIlIllIl.next = llllllllllllllllIIIIllIlIIlIlIll.tanns;
            llllllllllllllllIIIIllIlIIlIlIll.tanns = llllllllllllllllIIIIllIlIIlIllIl;
        } else {
            llllllllllllllllIIIIllIlIIlIllIl.next = llllllllllllllllIIIIllIlIIlIlIll.itanns;
            llllllllllllllllIIIIllIlIIlIlIll.itanns = llllllllllllllllIIIIllIlIIlIllIl;
        }
        return llllllllllllllllIIIIllIlIIlIllIl;
    }

    public void visitAttribute(Attribute llllllllllllllllIIIIllIlIIIlIIII) {
        FieldWriter llllllllllllllllIIIIllIlIIIlIIIl;
        llllllllllllllllIIIIllIlIIIlIIII.next = llllllllllllllllIIIIllIlIIIlIIIl.attrs;
        llllllllllllllllIIIIllIlIIIlIIIl.attrs = llllllllllllllllIIIIllIlIIIlIIII;
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIIIIllIlIlIlIIIl, boolean llllllllllllllllIIIIllIlIlIIllll) {
        FieldWriter llllllllllllllllIIIIllIlIlIlIIlI;
        ByteVector llllllllllllllllIIIIllIlIlIlIlIl = new ByteVector();
        llllllllllllllllIIIIllIlIlIlIlIl.putShort(llllllllllllllllIIIIllIlIlIlIIlI.cw.newUTF8(llllllllllllllllIIIIllIlIlIlIIIl)).putShort(0);
        AnnotationWriter llllllllllllllllIIIIllIlIlIlIlII = new AnnotationWriter(llllllllllllllllIIIIllIlIlIlIIlI.cw, true, llllllllllllllllIIIIllIlIlIlIlIl, llllllllllllllllIIIIllIlIlIlIlIl, 2);
        if (llllllllllllllllIIIIllIlIlIIllll) {
            llllllllllllllllIIIIllIlIlIlIlII.next = llllllllllllllllIIIIllIlIlIlIIlI.anns;
            llllllllllllllllIIIIllIlIlIlIIlI.anns = llllllllllllllllIIIIllIlIlIlIlII;
        } else {
            llllllllllllllllIIIIllIlIlIlIlII.next = llllllllllllllllIIIIllIlIlIlIIlI.ianns;
            llllllllllllllllIIIIllIlIlIlIIlI.ianns = llllllllllllllllIIIIllIlIlIlIlII;
        }
        return llllllllllllllllIIIIllIlIlIlIlII;
    }

    public void visitEnd() {
    }
}

