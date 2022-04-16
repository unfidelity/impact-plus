/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.TypePath;

public abstract class FieldVisitor {
    protected /* synthetic */ FieldVisitor fv;
    protected final /* synthetic */ int api;

    public void visitEnd() {
        FieldVisitor llllllllllllllllIllIIIlIIllllIll;
        if (llllllllllllllllIllIIIlIIllllIll.fv != null) {
            llllllllllllllllIllIIIlIIllllIll.fv.visitEnd();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllIllIIIlIlIIIlIll, TypePath llllllllllllllllIllIIIlIlIIIlIlI, String llllllllllllllllIllIIIlIlIIIIlII, boolean llllllllllllllllIllIIIlIlIIIlIII) {
        FieldVisitor llllllllllllllllIllIIIlIlIIIIlll;
        if (llllllllllllllllIllIIIlIlIIIIlll.api < 327680) {
            throw new RuntimeException();
        }
        if (llllllllllllllllIllIIIlIlIIIIlll.fv != null) {
            return llllllllllllllllIllIIIlIlIIIIlll.fv.visitTypeAnnotation(llllllllllllllllIllIIIlIlIIIlIll, llllllllllllllllIllIIIlIlIIIlIlI, llllllllllllllllIllIIIlIlIIIIlII, llllllllllllllllIllIIIlIlIIIlIII);
        }
        return null;
    }

    public void visitAttribute(Attribute llllllllllllllllIllIIIlIIlllllll) {
        FieldVisitor llllllllllllllllIllIIIlIIllllllI;
        if (llllllllllllllllIllIIIlIIllllllI.fv != null) {
            llllllllllllllllIllIIIlIIllllllI.fv.visitAttribute(llllllllllllllllIllIIIlIIlllllll);
        }
    }

    public FieldVisitor(int llllllllllllllllIllIIIlIlIlllIII, FieldVisitor llllllllllllllllIllIIIlIlIllIllI) {
        FieldVisitor llllllllllllllllIllIIIlIlIlllIIl;
        if (llllllllllllllllIllIIIlIlIlllIII != 262144 && llllllllllllllllIllIIIlIlIlllIII != 327680) {
            throw new IllegalArgumentException();
        }
        llllllllllllllllIllIIIlIlIlllIIl.api = llllllllllllllllIllIIIlIlIlllIII;
        llllllllllllllllIllIIIlIlIlllIIl.fv = llllllllllllllllIllIIIlIlIllIllI;
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIllIIIlIlIlIIIII, boolean llllllllllllllllIllIIIlIlIlIIIlI) {
        FieldVisitor llllllllllllllllIllIIIlIlIlIIIIl;
        if (llllllllllllllllIllIIIlIlIlIIIIl.fv != null) {
            return llllllllllllllllIllIIIlIlIlIIIIl.fv.visitAnnotation(llllllllllllllllIllIIIlIlIlIIIII, llllllllllllllllIllIIIlIlIlIIIlI);
        }
        return null;
    }

    public FieldVisitor(int llllllllllllllllIllIIIlIlIllllll) {
        llllllllllllllllIllIIIlIllIIIIII(llllllllllllllllIllIIIlIlIllllll, null);
        FieldVisitor llllllllllllllllIllIIIlIllIIIIII;
    }
}

