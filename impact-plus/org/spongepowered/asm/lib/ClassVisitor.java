/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;

public abstract class ClassVisitor {
    protected final /* synthetic */ int api;
    protected /* synthetic */ ClassVisitor cv;

    public MethodVisitor visitMethod(int llIlIllIIlIllI, String llIlIllIIIllll, String llIlIllIIIlllI, String llIlIllIIIllIl, String[] llIlIllIIIllII) {
        ClassVisitor llIlIllIIlIlll;
        if (llIlIllIIlIlll.cv != null) {
            return llIlIllIIlIlll.cv.visitMethod(llIlIllIIlIllI, llIlIllIIIllll, llIlIllIIIlllI, llIlIllIIIllIl, llIlIllIIIllII);
        }
        return null;
    }

    public ClassVisitor(int llIllIIllllIII) {
        llIllIIlllllIl(llIllIIllllIII, null);
        ClassVisitor llIllIIlllllIl;
    }

    public void visitAttribute(Attribute llIlIllllIlIII) {
        ClassVisitor llIlIllllIlIll;
        if (llIlIllllIlIll.cv != null) {
            llIlIllllIlIll.cv.visitAttribute(llIlIllllIlIII);
        }
    }

    public ClassVisitor(int llIllIIlIlIlll, ClassVisitor llIllIIlIlIlIl) {
        ClassVisitor llIllIIlIllllI;
        if (llIllIIlIlIlll != 262144 && llIllIIlIlIlll != 327680) {
            throw new IllegalArgumentException();
        }
        llIllIIlIllllI.api = llIllIIlIlIlll;
        llIllIIlIllllI.cv = llIllIIlIlIlIl;
    }

    public void visitOuterClass(String llIllIIIlIlIII, String llIllIIIlIlIll, String llIllIIIlIIllI) {
        ClassVisitor llIllIIIlIlIIl;
        if (llIllIIIlIlIIl.cv != null) {
            llIllIIIlIlIIl.cv.visitOuterClass(llIllIIIlIlIII, llIllIIIlIlIll, llIllIIIlIIllI);
        }
    }

    public void visitInnerClass(String llIlIlllIlIIll, String llIlIlllIIlIll, String llIlIlllIIllll, int llIlIlllIIlllI) {
        ClassVisitor llIlIlllIlIlIl;
        if (llIlIlllIlIlIl.cv != null) {
            llIlIlllIlIlIl.cv.visitInnerClass(llIlIlllIlIIll, llIlIlllIIlIll, llIlIlllIIllll, llIlIlllIIlllI);
        }
    }

    public FieldVisitor visitField(int llIlIllIlllIII, String llIlIllIlIllll, String llIlIllIllIllI, String llIlIllIlIlIll, Object llIlIllIllIIll) {
        ClassVisitor llIlIllIlllIIl;
        if (llIlIllIlllIIl.cv != null) {
            return llIlIllIlllIIl.cv.visitField(llIlIllIlllIII, llIlIllIlIllll, llIlIllIllIllI, llIlIllIlIlIll, llIlIllIllIIll);
        }
        return null;
    }

    public void visit(int llIllIIlIIIIII, int llIllIIIllllll, String llIllIIlIIIlIl, String llIllIIIllllIl, String llIllIIlIIIIll, String[] llIllIIIlllIll) {
        ClassVisitor llIllIIlIIlIII;
        if (llIllIIlIIlIII.cv != null) {
            llIllIIlIIlIII.cv.visit(llIllIIlIIIIII, llIllIIIllllll, llIllIIlIIIlIl, llIllIIIllllIl, llIllIIlIIIIll, llIllIIIlllIll);
        }
    }

    public void visitSource(String llIllIIIllIllI, String llIllIIIllIlIl) {
        ClassVisitor llIllIIIllIlII;
        if (llIllIIIllIlII.cv != null) {
            llIllIIIllIlII.cv.visitSource(llIllIIIllIllI, llIllIIIllIlIl);
        }
    }

    public AnnotationVisitor visitAnnotation(String llIllIIIIllIlI, boolean llIllIIIIllIIl) {
        ClassVisitor llIllIIIIlIlll;
        if (llIllIIIIlIlll.cv != null) {
            return llIllIIIIlIlll.cv.visitAnnotation(llIllIIIIllIlI, llIllIIIIllIIl);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int llIlIllllllllI, TypePath llIlIlllllllIl, String llIlIlllllIIlI, boolean llIlIllllllIIl) {
        ClassVisitor llIlIlllllIlll;
        if (llIlIlllllIlll.api < 327680) {
            throw new RuntimeException();
        }
        if (llIlIlllllIlll.cv != null) {
            return llIlIlllllIlll.cv.visitTypeAnnotation(llIlIllllllllI, llIlIlllllllIl, llIlIlllllIIlI, llIlIllllllIIl);
        }
        return null;
    }

    public void visitEnd() {
        ClassVisitor llIlIllIIIIIlI;
        if (llIlIllIIIIIlI.cv != null) {
            llIlIllIIIIIlI.cv.visitEnd();
        }
    }
}

