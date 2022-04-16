/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.TraceAnnotationVisitor;

public final class TraceFieldVisitor
extends FieldVisitor {
    public final /* synthetic */ Printer p;

    public void visitEnd() {
        TraceFieldVisitor lllllllllllllllIlllIIIllIlllllIl;
        lllllllllllllllIlllIIIllIlllllIl.p.visitFieldEnd();
        super.visitEnd();
    }

    public void visitAttribute(Attribute lllllllllllllllIlllIIIlllIIIIIII) {
        TraceFieldVisitor lllllllllllllllIlllIIIlllIIIIIll;
        lllllllllllllllIlllIIIlllIIIIIll.p.visitFieldAttribute(lllllllllllllllIlllIIIlllIIIIIII);
        super.visitAttribute(lllllllllllllllIlllIIIlllIIIIIII);
    }

    public AnnotationVisitor visitAnnotation(String lllllllllllllllIlllIIIlllIlIIIll, boolean lllllllllllllllIlllIIIlllIlIIIlI) {
        TraceFieldVisitor lllllllllllllllIlllIIIlllIlIIlII;
        Printer lllllllllllllllIlllIIIlllIlIIIIl = lllllllllllllllIlllIIIlllIlIIlII.p.visitFieldAnnotation(lllllllllllllllIlllIIIlllIlIIIll, lllllllllllllllIlllIIIlllIlIIIlI);
        AnnotationVisitor lllllllllllllllIlllIIIlllIlIIIII = lllllllllllllllIlllIIIlllIlIIlII.fv == null ? null : lllllllllllllllIlllIIIlllIlIIlII.fv.visitAnnotation(lllllllllllllllIlllIIIlllIlIIIll, lllllllllllllllIlllIIIlllIlIIIlI);
        return new TraceAnnotationVisitor(lllllllllllllllIlllIIIlllIlIIIII, lllllllllllllllIlllIIIlllIlIIIIl);
    }

    public TraceFieldVisitor(FieldVisitor lllllllllllllllIlllIIIlllIlIlIll, Printer lllllllllllllllIlllIIIlllIlIllIl) {
        super(327680, lllllllllllllllIlllIIIlllIlIlIll);
        TraceFieldVisitor lllllllllllllllIlllIIIlllIlIllII;
        lllllllllllllllIlllIIIlllIlIllII.p = lllllllllllllllIlllIIIlllIlIllIl;
    }

    public AnnotationVisitor visitTypeAnnotation(int lllllllllllllllIlllIIIlllIIlIIlI, TypePath lllllllllllllllIlllIIIlllIIlIIIl, String lllllllllllllllIlllIIIlllIIIlIIl, boolean lllllllllllllllIlllIIIlllIIIllll) {
        TraceFieldVisitor lllllllllllllllIlllIIIlllIIlIIll;
        Printer lllllllllllllllIlllIIIlllIIIlllI = lllllllllllllllIlllIIIlllIIlIIll.p.visitFieldTypeAnnotation(lllllllllllllllIlllIIIlllIIlIIlI, lllllllllllllllIlllIIIlllIIlIIIl, lllllllllllllllIlllIIIlllIIIlIIl, lllllllllllllllIlllIIIlllIIIllll);
        AnnotationVisitor lllllllllllllllIlllIIIlllIIIllIl = lllllllllllllllIlllIIIlllIIlIIll.fv == null ? null : lllllllllllllllIlllIIIlllIIlIIll.fv.visitTypeAnnotation(lllllllllllllllIlllIIIlllIIlIIlI, lllllllllllllllIlllIIIlllIIlIIIl, lllllllllllllllIlllIIIlllIIIlIIl, lllllllllllllllIlllIIIlllIIIllll);
        return new TraceAnnotationVisitor(lllllllllllllllIlllIIIlllIIIllIl, lllllllllllllllIlllIIIlllIIIlllI);
    }

    public TraceFieldVisitor(Printer lllllllllllllllIlllIIIlllIllIIll) {
        lllllllllllllllIlllIIIlllIllIllI(null, lllllllllllllllIlllIIIlllIllIIll);
        TraceFieldVisitor lllllllllllllllIlllIIIlllIllIllI;
    }
}

