/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.util.CheckMethodAdapter;

public class CheckAnnotationAdapter
extends AnnotationVisitor {
    private final /* synthetic */ boolean named;
    private /* synthetic */ boolean end;

    public void visit(String llllllllllllllllIlllllIlllIIlllI, Object llllllllllllllllIlllllIlllIIllII) {
        int llllllllllllllllIlllllIllllIIIlI;
        CheckAnnotationAdapter llllllllllllllllIlllllIlllIlIlll;
        llllllllllllllllIlllllIlllIlIlll.checkEnd();
        llllllllllllllllIlllllIlllIlIlll.checkName(llllllllllllllllIlllllIlllIIlllI);
        if (!(llllllllllllllllIlllllIlllIIllII instanceof Byte || llllllllllllllllIlllllIlllIIllII instanceof Boolean || llllllllllllllllIlllllIlllIIllII instanceof Character || llllllllllllllllIlllllIlllIIllII instanceof Short || llllllllllllllllIlllllIlllIIllII instanceof Integer || llllllllllllllllIlllllIlllIIllII instanceof Long || llllllllllllllllIlllllIlllIIllII instanceof Float || llllllllllllllllIlllllIlllIIllII instanceof Double || llllllllllllllllIlllllIlllIIllII instanceof String || llllllllllllllllIlllllIlllIIllII instanceof Type || llllllllllllllllIlllllIlllIIllII instanceof byte[] || llllllllllllllllIlllllIlllIIllII instanceof boolean[] || llllllllllllllllIlllllIlllIIllII instanceof char[] || llllllllllllllllIlllllIlllIIllII instanceof short[] || llllllllllllllllIlllllIlllIIllII instanceof int[] || llllllllllllllllIlllllIlllIIllII instanceof long[] || llllllllllllllllIlllllIlllIIllII instanceof float[] || llllllllllllllllIlllllIlllIIllII instanceof double[])) {
            throw new IllegalArgumentException("Invalid annotation value");
        }
        if (llllllllllllllllIlllllIlllIIllII instanceof Type && (llllllllllllllllIlllllIllllIIIlI = ((Type)llllllllllllllllIlllllIlllIIllII).getSort()) == 11) {
            throw new IllegalArgumentException("Invalid annotation value");
        }
        if (llllllllllllllllIlllllIlllIlIlll.av != null) {
            llllllllllllllllIlllllIlllIlIlll.av.visit(llllllllllllllllIlllllIlllIIlllI, llllllllllllllllIlllllIlllIIllII);
        }
    }

    public CheckAnnotationAdapter(AnnotationVisitor llllllllllllllllIllllllIIlIlIIll) {
        llllllllllllllllIllllllIIlIlIIlI(llllllllllllllllIllllllIIlIlIIll, true);
        CheckAnnotationAdapter llllllllllllllllIllllllIIlIlIIlI;
    }

    private void checkEnd() {
        CheckAnnotationAdapter llllllllllllllllIlllllIIllIIIllI;
        if (llllllllllllllllIlllllIIllIIIllI.end) {
            throw new IllegalStateException("Cannot call a visit method after visitEnd has been called");
        }
    }

    public void visitEnum(String llllllllllllllllIlllllIllIIllIIl, String llllllllllllllllIlllllIllIIlIllI, String llllllllllllllllIlllllIllIIIIlIl) {
        CheckAnnotationAdapter llllllllllllllllIlllllIllIIllIlI;
        llllllllllllllllIlllllIllIIllIlI.checkEnd();
        llllllllllllllllIlllllIllIIllIlI.checkName(llllllllllllllllIlllllIllIIllIIl);
        CheckMethodAdapter.checkDesc(llllllllllllllllIlllllIllIIlIllI, false);
        if (llllllllllllllllIlllllIllIIIIlIl == null) {
            throw new IllegalArgumentException("Invalid enum value");
        }
        if (llllllllllllllllIlllllIllIIllIlI.av != null) {
            llllllllllllllllIlllllIllIIllIlI.av.visitEnum(llllllllllllllllIlllllIllIIllIIl, llllllllllllllllIlllllIllIIlIllI, llllllllllllllllIlllllIllIIIIlIl);
        }
    }

    CheckAnnotationAdapter(AnnotationVisitor llllllllllllllllIllllllIIIllIIlI, boolean llllllllllllllllIllllllIIIlIllll) {
        super(327680, llllllllllllllllIllllllIIIllIIlI);
        CheckAnnotationAdapter llllllllllllllllIllllllIIIllIlII;
        llllllllllllllllIllllllIIIllIlII.named = llllllllllllllllIllllllIIIlIllll;
    }

    private void checkName(String llllllllllllllllIlllllIIlIllIIII) {
        CheckAnnotationAdapter llllllllllllllllIlllllIIlIlIIlIl;
        if (llllllllllllllllIlllllIIlIlIIlIl.named && llllllllllllllllIlllllIIlIllIIII == null) {
            throw new IllegalArgumentException("Annotation value name must not be null");
        }
    }

    public void visitEnd() {
        CheckAnnotationAdapter llllllllllllllllIlllllIIllIllIlI;
        llllllllllllllllIlllllIIllIllIlI.checkEnd();
        llllllllllllllllIlllllIIllIllIlI.end = true;
        if (llllllllllllllllIlllllIIllIllIlI.av != null) {
            llllllllllllllllIlllllIIllIllIlI.av.visitEnd();
        }
    }

    public AnnotationVisitor visitArray(String llllllllllllllllIlllllIIlllllllI) {
        CheckAnnotationAdapter llllllllllllllllIlllllIlIIIIIIIl;
        llllllllllllllllIlllllIlIIIIIIIl.checkEnd();
        llllllllllllllllIlllllIlIIIIIIIl.checkName(llllllllllllllllIlllllIIlllllllI);
        return new CheckAnnotationAdapter(llllllllllllllllIlllllIlIIIIIIIl.av == null ? null : llllllllllllllllIlllllIlIIIIIIIl.av.visitArray(llllllllllllllllIlllllIIlllllllI), false);
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIlllllIlIlIIllII, String llllllllllllllllIlllllIlIlIIlIII) {
        CheckAnnotationAdapter llllllllllllllllIlllllIlIlIlIIll;
        llllllllllllllllIlllllIlIlIlIIll.checkEnd();
        llllllllllllllllIlllllIlIlIlIIll.checkName(llllllllllllllllIlllllIlIlIIllII);
        CheckMethodAdapter.checkDesc(llllllllllllllllIlllllIlIlIIlIII, false);
        return new CheckAnnotationAdapter(llllllllllllllllIlllllIlIlIlIIll.av == null ? null : llllllllllllllllIlllllIlIlIlIIll.av.visitAnnotation(llllllllllllllllIlllllIlIlIIllII, llllllllllllllllIlllllIlIlIIlIII));
    }
}

