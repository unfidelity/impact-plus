/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.PrintWriter;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.Textifier;
import org.spongepowered.asm.lib.util.TraceAnnotationVisitor;
import org.spongepowered.asm.lib.util.TraceFieldVisitor;
import org.spongepowered.asm.lib.util.TraceMethodVisitor;

public final class TraceClassVisitor
extends ClassVisitor {
    private final /* synthetic */ PrintWriter pw;
    public final /* synthetic */ Printer p;

    public TraceClassVisitor(ClassVisitor lllllllllllllllllllllllIlIlIllll, PrintWriter lllllllllllllllllllllllIlIlIllIl) {
        lllllllllllllllllllllllIlIlIllII(lllllllllllllllllllllllIlIlIllll, new Textifier(), lllllllllllllllllllllllIlIlIllIl);
        TraceClassVisitor lllllllllllllllllllllllIlIlIllII;
    }

    public void visit(int lllllllllllllllllllllllIIllllllI, int lllllllllllllllllllllllIlIIIlIIl, String lllllllllllllllllllllllIlIIIIlll, String lllllllllllllllllllllllIlIIIIlIl, String lllllllllllllllllllllllIIlllIlll, String[] lllllllllllllllllllllllIlIIIIIlI) {
        TraceClassVisitor lllllllllllllllllllllllIlIIIIIII;
        lllllllllllllllllllllllIlIIIIIII.p.visit(lllllllllllllllllllllllIIllllllI, lllllllllllllllllllllllIlIIIlIIl, lllllllllllllllllllllllIlIIIIlll, lllllllllllllllllllllllIlIIIIlIl, lllllllllllllllllllllllIIlllIlll, lllllllllllllllllllllllIlIIIIIlI);
        super.visit(lllllllllllllllllllllllIIllllllI, lllllllllllllllllllllllIlIIIlIIl, lllllllllllllllllllllllIlIIIIlll, lllllllllllllllllllllllIlIIIIlIl, lllllllllllllllllllllllIIlllIlll, lllllllllllllllllllllllIlIIIIIlI);
    }

    public void visitOuterClass(String lllllllllllllllllllllllIIlIlIIll, String lllllllllllllllllllllllIIlIlIIlI, String lllllllllllllllllllllllIIlIlIIII) {
        TraceClassVisitor lllllllllllllllllllllllIIlIlIlII;
        lllllllllllllllllllllllIIlIlIlII.p.visitOuterClass(lllllllllllllllllllllllIIlIlIIll, lllllllllllllllllllllllIIlIlIIlI, lllllllllllllllllllllllIIlIlIIII);
        super.visitOuterClass(lllllllllllllllllllllllIIlIlIIll, lllllllllllllllllllllllIIlIlIIlI, lllllllllllllllllllllllIIlIlIIII);
    }

    public AnnotationVisitor visitTypeAnnotation(int lllllllllllllllllllllllIIIIlllll, TypePath lllllllllllllllllllllllIIIIlIIII, String lllllllllllllllllllllllIIIIllIll, boolean lllllllllllllllllllllllIIIIllIIl) {
        TraceClassVisitor lllllllllllllllllllllllIIIlIIIIl;
        Printer lllllllllllllllllllllllIIIIlIlll = lllllllllllllllllllllllIIIlIIIIl.p.visitClassTypeAnnotation(lllllllllllllllllllllllIIIIlllll, lllllllllllllllllllllllIIIIlIIII, lllllllllllllllllllllllIIIIllIll, lllllllllllllllllllllllIIIIllIIl);
        AnnotationVisitor lllllllllllllllllllllllIIIIlIlIl = lllllllllllllllllllllllIIIlIIIIl.cv == null ? null : lllllllllllllllllllllllIIIlIIIIl.cv.visitTypeAnnotation(lllllllllllllllllllllllIIIIlllll, lllllllllllllllllllllllIIIIlIIII, lllllllllllllllllllllllIIIIllIll, lllllllllllllllllllllllIIIIllIIl);
        return new TraceAnnotationVisitor(lllllllllllllllllllllllIIIIlIlIl, lllllllllllllllllllllllIIIIlIlll);
    }

    public void visitAttribute(Attribute lllllllllllllllllllllllIIIIIIIlI) {
        TraceClassVisitor lllllllllllllllllllllllIIIIIIlIl;
        lllllllllllllllllllllllIIIIIIlIl.p.visitClassAttribute(lllllllllllllllllllllllIIIIIIIlI);
        super.visitAttribute(lllllllllllllllllllllllIIIIIIIlI);
    }

    public MethodVisitor visitMethod(int llllllllllllllllllllllIlllIIIlIl, String llllllllllllllllllllllIlllIIIlII, String llllllllllllllllllllllIlllIIIIll, String llllllllllllllllllllllIlllIIlIlI, String[] llllllllllllllllllllllIlllIIIIIl) {
        TraceClassVisitor llllllllllllllllllllllIlllIIIllI;
        Printer llllllllllllllllllllllIlllIIlIII = llllllllllllllllllllllIlllIIIllI.p.visitMethod(llllllllllllllllllllllIlllIIIlIl, llllllllllllllllllllllIlllIIIlII, llllllllllllllllllllllIlllIIIIll, llllllllllllllllllllllIlllIIlIlI, llllllllllllllllllllllIlllIIIIIl);
        MethodVisitor llllllllllllllllllllllIlllIIIlll = llllllllllllllllllllllIlllIIIllI.cv == null ? null : llllllllllllllllllllllIlllIIIllI.cv.visitMethod(llllllllllllllllllllllIlllIIIlIl, llllllllllllllllllllllIlllIIIlII, llllllllllllllllllllllIlllIIIIll, llllllllllllllllllllllIlllIIlIlI, llllllllllllllllllllllIlllIIIIIl);
        return new TraceMethodVisitor(llllllllllllllllllllllIlllIIIlll, llllllllllllllllllllllIlllIIlIII);
    }

    public void visitInnerClass(String llllllllllllllllllllllIlllllIIlI, String llllllllllllllllllllllIlllllIllI, String llllllllllllllllllllllIlllllIIII, int llllllllllllllllllllllIllllIllll) {
        TraceClassVisitor llllllllllllllllllllllIlllllIIll;
        llllllllllllllllllllllIlllllIIll.p.visitInnerClass(llllllllllllllllllllllIlllllIIlI, llllllllllllllllllllllIlllllIllI, llllllllllllllllllllllIlllllIIII, llllllllllllllllllllllIllllIllll);
        super.visitInnerClass(llllllllllllllllllllllIlllllIIlI, llllllllllllllllllllllIlllllIllI, llllllllllllllllllllllIlllllIIII, llllllllllllllllllllllIllllIllll);
    }

    public AnnotationVisitor visitAnnotation(String lllllllllllllllllllllllIIIlllIII, boolean lllllllllllllllllllllllIIIllIlll) {
        TraceClassVisitor lllllllllllllllllllllllIIIlllllI;
        Printer lllllllllllllllllllllllIIIlllIll = lllllllllllllllllllllllIIIlllllI.p.visitClassAnnotation(lllllllllllllllllllllllIIIlllIII, lllllllllllllllllllllllIIIllIlll);
        AnnotationVisitor lllllllllllllllllllllllIIIlllIlI = lllllllllllllllllllllllIIIlllllI.cv == null ? null : lllllllllllllllllllllllIIIlllllI.cv.visitAnnotation(lllllllllllllllllllllllIIIlllIII, lllllllllllllllllllllllIIIllIlll);
        return new TraceAnnotationVisitor(lllllllllllllllllllllllIIIlllIlI, lllllllllllllllllllllllIIIlllIll);
    }

    public void visitEnd() {
        TraceClassVisitor llllllllllllllllllllllIllIllllIl;
        llllllllllllllllllllllIllIllllIl.p.visitClassEnd();
        if (llllllllllllllllllllllIllIllllIl.pw != null) {
            llllllllllllllllllllllIllIllllIl.p.print(llllllllllllllllllllllIllIllllIl.pw);
            llllllllllllllllllllllIllIllllIl.pw.flush();
        }
        super.visitEnd();
    }

    public FieldVisitor visitField(int llllllllllllllllllllllIlllIlllIl, String llllllllllllllllllllllIllllIIlII, String llllllllllllllllllllllIllllIIIll, String llllllllllllllllllllllIlllIllIlI, Object llllllllllllllllllllllIllllIIIIl) {
        TraceClassVisitor llllllllllllllllllllllIlllIllllI;
        Printer llllllllllllllllllllllIllllIIIII = llllllllllllllllllllllIlllIllllI.p.visitField(llllllllllllllllllllllIlllIlllIl, llllllllllllllllllllllIllllIIlII, llllllllllllllllllllllIllllIIIll, llllllllllllllllllllllIlllIllIlI, llllllllllllllllllllllIllllIIIIl);
        FieldVisitor llllllllllllllllllllllIlllIlllll = llllllllllllllllllllllIlllIllllI.cv == null ? null : llllllllllllllllllllllIlllIllllI.cv.visitField(llllllllllllllllllllllIlllIlllIl, llllllllllllllllllllllIllllIIlII, llllllllllllllllllllllIllllIIIll, llllllllllllllllllllllIlllIllIlI, llllllllllllllllllllllIllllIIIIl);
        return new TraceFieldVisitor(llllllllllllllllllllllIlllIlllll, llllllllllllllllllllllIllllIIIII);
    }

    public TraceClassVisitor(PrintWriter lllllllllllllllllllllllIlIllIllI) {
        lllllllllllllllllllllllIlIllIlll(null, lllllllllllllllllllllllIlIllIllI);
        TraceClassVisitor lllllllllllllllllllllllIlIllIlll;
    }

    public void visitSource(String lllllllllllllllllllllllIIlIllllI, String lllllllllllllllllllllllIIllIIIII) {
        TraceClassVisitor lllllllllllllllllllllllIIllIIIlI;
        lllllllllllllllllllllllIIllIIIlI.p.visitSource(lllllllllllllllllllllllIIlIllllI, lllllllllllllllllllllllIIllIIIII);
        super.visitSource(lllllllllllllllllllllllIIlIllllI, lllllllllllllllllllllllIIllIIIII);
    }

    public TraceClassVisitor(ClassVisitor lllllllllllllllllllllllIlIlIIIII, Printer lllllllllllllllllllllllIlIIlllll, PrintWriter lllllllllllllllllllllllIlIIllllI) {
        super(327680, lllllllllllllllllllllllIlIlIIIII);
        TraceClassVisitor lllllllllllllllllllllllIlIlIIIIl;
        lllllllllllllllllllllllIlIlIIIIl.pw = lllllllllllllllllllllllIlIIllllI;
        lllllllllllllllllllllllIlIlIIIIl.p = lllllllllllllllllllllllIlIIlllll;
    }
}

