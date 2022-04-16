/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.util.Printer;

public final class TraceAnnotationVisitor
extends AnnotationVisitor {
    private final /* synthetic */ Printer p;

    public AnnotationVisitor visitArray(String llllllllllllllllIlIlIIlIlIlllIll) {
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIllIIIIII;
        Printer llllllllllllllllIlIlIIlIlIlllllI = llllllllllllllllIlIlIIlIllIIIIII.p.visitArray(llllllllllllllllIlIlIIlIlIlllIll);
        AnnotationVisitor llllllllllllllllIlIlIIlIlIllllIl = llllllllllllllllIlIlIIlIllIIIIII.av == null ? null : llllllllllllllllIlIlIIlIllIIIIII.av.visitArray(llllllllllllllllIlIlIIlIlIlllIll);
        return new TraceAnnotationVisitor(llllllllllllllllIlIlIIlIlIllllIl, llllllllllllllllIlIlIIlIlIlllllI);
    }

    public void visit(String llllllllllllllllIlIlIIlIlllIIlII, Object llllllllllllllllIlIlIIlIlllIIIII) {
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIlllIIIlI;
        llllllllllllllllIlIlIIlIlllIIIlI.p.visit(llllllllllllllllIlIlIIlIlllIIlII, llllllllllllllllIlIlIIlIlllIIIII);
        super.visit(llllllllllllllllIlIlIIlIlllIIlII, llllllllllllllllIlIlIIlIlllIIIII);
    }

    public TraceAnnotationVisitor(Printer llllllllllllllllIlIlIIlIllllIIlI) {
        llllllllllllllllIlIlIIlIllllIlIl(null, llllllllllllllllIlIlIIlIllllIIlI);
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIllllIlIl;
    }

    public void visitEnd() {
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIlIllIlll;
        llllllllllllllllIlIlIIlIlIllIlll.p.visitAnnotationEnd();
        super.visitEnd();
    }

    public void visitEnum(String llllllllllllllllIlIlIIlIllIlIllI, String llllllllllllllllIlIlIIlIllIllIIl, String llllllllllllllllIlIlIIlIllIlIlII) {
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIllIllIll;
        llllllllllllllllIlIlIIlIllIllIll.p.visitEnum(llllllllllllllllIlIlIIlIllIlIllI, llllllllllllllllIlIlIIlIllIllIIl, llllllllllllllllIlIlIIlIllIlIlII);
        super.visitEnum(llllllllllllllllIlIlIIlIllIlIllI, llllllllllllllllIlIlIIlIllIllIIl, llllllllllllllllIlIlIIlIllIlIlII);
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIlIlIIlIllIIllIl, String llllllllllllllllIlIlIIlIllIIllII) {
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIllIIlIIl;
        Printer llllllllllllllllIlIlIIlIllIIlIll = llllllllllllllllIlIlIIlIllIIlIIl.p.visitAnnotation(llllllllllllllllIlIlIIlIllIIllIl, llllllllllllllllIlIlIIlIllIIllII);
        AnnotationVisitor llllllllllllllllIlIlIIlIllIIlIlI = llllllllllllllllIlIlIIlIllIIlIIl.av == null ? null : llllllllllllllllIlIlIIlIllIIlIIl.av.visitAnnotation(llllllllllllllllIlIlIIlIllIIllIl, llllllllllllllllIlIlIIlIllIIllII);
        return new TraceAnnotationVisitor(llllllllllllllllIlIlIIlIllIIlIlI, llllllllllllllllIlIlIIlIllIIlIll);
    }

    public TraceAnnotationVisitor(AnnotationVisitor llllllllllllllllIlIlIIlIlllIllIl, Printer llllllllllllllllIlIlIIlIlllIllII) {
        super(327680, llllllllllllllllIlIlIIlIlllIllIl);
        TraceAnnotationVisitor llllllllllllllllIlIlIIlIlllIlllI;
        llllllllllllllllIlIlIIlIlllIlllI.p = llllllllllllllllIlIlIIlIlllIllII;
    }
}

