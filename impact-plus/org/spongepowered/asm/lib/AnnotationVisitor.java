/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

public abstract class AnnotationVisitor {
    protected final /* synthetic */ int api;
    protected /* synthetic */ AnnotationVisitor av;

    public AnnotationVisitor(int lllllllllllllllllIIllIlIIlllIIll) {
        lllllllllllllllllIIllIlIIlllIllI(lllllllllllllllllIIllIlIIlllIIll, null);
        AnnotationVisitor lllllllllllllllllIIllIlIIlllIllI;
    }

    public AnnotationVisitor visitArray(String lllllllllllllllllIIllIlIIlIIIllI) {
        AnnotationVisitor lllllllllllllllllIIllIlIIlIIlIIl;
        if (lllllllllllllllllIIllIlIIlIIlIIl.av != null) {
            return lllllllllllllllllIIllIlIIlIIlIIl.av.visitArray(lllllllllllllllllIIllIlIIlIIIllI);
        }
        return null;
    }

    public void visitEnd() {
        AnnotationVisitor lllllllllllllllllIIllIlIIlIIIlII;
        if (lllllllllllllllllIIllIlIIlIIIlII.av != null) {
            lllllllllllllllllIIllIlIIlIIIlII.av.visitEnd();
        }
    }

    public void visit(String lllllllllllllllllIIllIlIIllIIlIl, Object lllllllllllllllllIIllIlIIllIIIIl) {
        AnnotationVisitor lllllllllllllllllIIllIlIIllIIllI;
        if (lllllllllllllllllIIllIlIIllIIllI.av != null) {
            lllllllllllllllllIIllIlIIllIIllI.av.visit(lllllllllllllllllIIllIlIIllIIlIl, lllllllllllllllllIIllIlIIllIIIIl);
        }
    }

    public AnnotationVisitor(int lllllllllllllllllIIllIlIIllIlIll, AnnotationVisitor lllllllllllllllllIIllIlIIllIllIl) {
        AnnotationVisitor lllllllllllllllllIIllIlIIllIllII;
        if (lllllllllllllllllIIllIlIIllIlIll != 262144 && lllllllllllllllllIIllIlIIllIlIll != 327680) {
            throw new IllegalArgumentException();
        }
        lllllllllllllllllIIllIlIIllIllII.api = lllllllllllllllllIIllIlIIllIlIll;
        lllllllllllllllllIIllIlIIllIllII.av = lllllllllllllllllIIllIlIIllIllIl;
    }

    public void visitEnum(String lllllllllllllllllIIllIlIIlIllIll, String lllllllllllllllllIIllIlIIlIllIlI, String lllllllllllllllllIIllIlIIlIllIIl) {
        AnnotationVisitor lllllllllllllllllIIllIlIIlIllIII;
        if (lllllllllllllllllIIllIlIIlIllIII.av != null) {
            lllllllllllllllllIIllIlIIlIllIII.av.visitEnum(lllllllllllllllllIIllIlIIlIllIll, lllllllllllllllllIIllIlIIlIllIlI, lllllllllllllllllIIllIlIIlIllIIl);
        }
    }

    public AnnotationVisitor visitAnnotation(String lllllllllllllllllIIllIlIIlIlIIII, String lllllllllllllllllIIllIlIIlIIllII) {
        AnnotationVisitor lllllllllllllllllIIllIlIIlIIlllI;
        if (lllllllllllllllllIIllIlIIlIIlllI.av != null) {
            return lllllllllllllllllIIllIlIIlIIlllI.av.visitAnnotation(lllllllllllllllllIIllIlIIlIlIIII, lllllllllllllllllIIllIlIIlIIllII);
        }
        return null;
    }
}

