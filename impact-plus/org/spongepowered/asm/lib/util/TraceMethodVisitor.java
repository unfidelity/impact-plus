/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.TraceAnnotationVisitor;

public final class TraceMethodVisitor
extends MethodVisitor {
    public final /* synthetic */ Printer p;

    public void visitFrame(int llllllllllllllllIlllIlllIIllIIll, int llllllllllllllllIlllIlllIIlllIII, Object[] llllllllllllllllIlllIlllIIllIIIl, int llllllllllllllllIlllIlllIIllIIII, Object[] llllllllllllllllIlllIlllIIllIlIl) {
        TraceMethodVisitor llllllllllllllllIlllIlllIIllIlII;
        llllllllllllllllIlllIlllIIllIlII.p.visitFrame(llllllllllllllllIlllIlllIIllIIll, llllllllllllllllIlllIlllIIlllIII, llllllllllllllllIlllIlllIIllIIIl, llllllllllllllllIlllIlllIIllIIII, llllllllllllllllIlllIlllIIllIlIl);
        super.visitFrame(llllllllllllllllIlllIlllIIllIIll, llllllllllllllllIlllIlllIIlllIII, llllllllllllllllIlllIlllIIllIIIl, llllllllllllllllIlllIlllIIllIIII, llllllllllllllllIlllIlllIIllIlIl);
    }

    public void visitVarInsn(int llllllllllllllllIlllIlllIIIllIII, int llllllllllllllllIlllIlllIIIlIlll) {
        TraceMethodVisitor llllllllllllllllIlllIlllIIIllIIl;
        llllllllllllllllIlllIlllIIIllIIl.p.visitVarInsn(llllllllllllllllIlllIlllIIIllIII, llllllllllllllllIlllIlllIIIlIlll);
        super.visitVarInsn(llllllllllllllllIlllIlllIIIllIII, llllllllllllllllIlllIlllIIIlIlll);
    }

    public void visitFieldInsn(int llllllllllllllllIlllIlllIIIIIIlI, String llllllllllllllllIlllIlllIIIIIIIl, String llllllllllllllllIlllIlllIIIIIlIl, String llllllllllllllllIlllIllIllllllll) {
        TraceMethodVisitor llllllllllllllllIlllIlllIIIIIIll;
        llllllllllllllllIlllIlllIIIIIIll.p.visitFieldInsn(llllllllllllllllIlllIlllIIIIIIlI, llllllllllllllllIlllIlllIIIIIIIl, llllllllllllllllIlllIlllIIIIIlIl, llllllllllllllllIlllIllIllllllll);
        super.visitFieldInsn(llllllllllllllllIlllIlllIIIIIIlI, llllllllllllllllIlllIlllIIIIIIIl, llllllllllllllllIlllIlllIIIIIlIl, llllllllllllllllIlllIllIllllllll);
    }

    public void visitLdcInsn(Object llllllllllllllllIlllIllIlIllllII) {
        TraceMethodVisitor llllllllllllllllIlllIllIlIlllIll;
        llllllllllllllllIlllIllIlIlllIll.p.visitLdcInsn(llllllllllllllllIlllIllIlIllllII);
        super.visitLdcInsn(llllllllllllllllIlllIllIlIllllII);
    }

    public void visitTableSwitchInsn(int llllllllllllllllIlllIllIlIlIlIlI, int llllllllllllllllIlllIllIlIlIIlII, Label llllllllllllllllIlllIllIlIlIlIII, Label ... llllllllllllllllIlllIllIlIlIIIlI) {
        TraceMethodVisitor llllllllllllllllIlllIllIlIlIlIll;
        llllllllllllllllIlllIllIlIlIlIll.p.visitTableSwitchInsn(llllllllllllllllIlllIllIlIlIlIlI, llllllllllllllllIlllIllIlIlIIlII, llllllllllllllllIlllIllIlIlIlIII, llllllllllllllllIlllIllIlIlIIIlI);
        super.visitTableSwitchInsn(llllllllllllllllIlllIllIlIlIlIlI, llllllllllllllllIlllIllIlIlIIlII, llllllllllllllllIlllIllIlIlIlIII, llllllllllllllllIlllIllIlIlIIIlI);
    }

    @Deprecated
    public void visitMethodInsn(int llllllllllllllllIlllIllIllllIIll, String llllllllllllllllIlllIllIllllIIlI, String llllllllllllllllIlllIllIllllIIIl, String llllllllllllllllIlllIllIllllIlIl) {
        TraceMethodVisitor llllllllllllllllIlllIllIlllllIIl;
        if (llllllllllllllllIlllIllIlllllIIl.api >= 327680) {
            super.visitMethodInsn(llllllllllllllllIlllIllIllllIIll, llllllllllllllllIlllIllIllllIIlI, llllllllllllllllIlllIllIllllIIIl, llllllllllllllllIlllIllIllllIlIl);
            return;
        }
        llllllllllllllllIlllIllIlllllIIl.p.visitMethodInsn(llllllllllllllllIlllIllIllllIIll, llllllllllllllllIlllIllIllllIIlI, llllllllllllllllIlllIllIllllIIIl, llllllllllllllllIlllIllIllllIlIl);
        if (llllllllllllllllIlllIllIlllllIIl.mv != null) {
            llllllllllllllllIlllIllIlllllIIl.mv.visitMethodInsn(llllllllllllllllIlllIllIllllIIll, llllllllllllllllIlllIllIllllIIlI, llllllllllllllllIlllIllIllllIIIl, llllllllllllllllIlllIllIllllIlIl);
        }
    }

    public void visitLookupSwitchInsn(Label llllllllllllllllIlllIllIlIIlllII, int[] llllllllllllllllIlllIllIlIIlIlll, Label[] llllllllllllllllIlllIllIlIIlIllI) {
        TraceMethodVisitor llllllllllllllllIlllIllIlIIllIIl;
        llllllllllllllllIlllIllIlIIllIIl.p.visitLookupSwitchInsn(llllllllllllllllIlllIllIlIIlllII, llllllllllllllllIlllIllIlIIlIlll, llllllllllllllllIlllIllIlIIlIllI);
        super.visitLookupSwitchInsn(llllllllllllllllIlllIllIlIIlllII, llllllllllllllllIlllIllIlIIlIlll, llllllllllllllllIlllIllIlIIlIllI);
    }

    public TraceMethodVisitor(MethodVisitor llllllllllllllllIlllIlllllIIlIII, Printer llllllllllllllllIlllIlllllIIlIlI) {
        super(327680, llllllllllllllllIlllIlllllIIlIII);
        TraceMethodVisitor llllllllllllllllIlllIlllllIIlIIl;
        llllllllllllllllIlllIlllllIIlIIl.p = llllllllllllllllIlllIlllllIIlIlI;
    }

    public void visitIincInsn(int llllllllllllllllIlllIllIlIllIlIl, int llllllllllllllllIlllIllIlIllIlII) {
        TraceMethodVisitor llllllllllllllllIlllIllIlIllIllI;
        llllllllllllllllIlllIllIlIllIllI.p.visitIincInsn(llllllllllllllllIlllIllIlIllIlIl, llllllllllllllllIlllIllIlIllIlII);
        super.visitIincInsn(llllllllllllllllIlllIllIlIllIlIl, llllllllllllllllIlllIllIlIllIlII);
    }

    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllIlllIllllIIIllII, TypePath llllllllllllllllIlllIllllIIIIIlI, String llllllllllllllllIlllIllllIIIIIII, boolean llllllllllllllllIlllIllllIIIlIIl) {
        TraceMethodVisitor llllllllllllllllIlllIllllIIIIllI;
        Printer llllllllllllllllIlllIllllIIIlIII = llllllllllllllllIlllIllllIIIIllI.p.visitMethodTypeAnnotation(llllllllllllllllIlllIllllIIIllII, llllllllllllllllIlllIllllIIIIIlI, llllllllllllllllIlllIllllIIIIIII, llllllllllllllllIlllIllllIIIlIIl);
        AnnotationVisitor llllllllllllllllIlllIllllIIIIlll = llllllllllllllllIlllIllllIIIIllI.mv == null ? null : llllllllllllllllIlllIllllIIIIllI.mv.visitTypeAnnotation(llllllllllllllllIlllIllllIIIllII, llllllllllllllllIlllIllllIIIIIlI, llllllllllllllllIlllIllllIIIIIII, llllllllllllllllIlllIllllIIIlIIl);
        return new TraceAnnotationVisitor(llllllllllllllllIlllIllllIIIIlll, llllllllllllllllIlllIllllIIIlIII);
    }

    public void visitLineNumber(int llllllllllllllllIlllIllIIIIlllII, Label llllllllllllllllIlllIllIIIIllIII) {
        TraceMethodVisitor llllllllllllllllIlllIllIIIIlllIl;
        llllllllllllllllIlllIllIIIIlllIl.p.visitLineNumber(llllllllllllllllIlllIllIIIIlllII, llllllllllllllllIlllIllIIIIllIII);
        super.visitLineNumber(llllllllllllllllIlllIllIIIIlllII, llllllllllllllllIlllIllIIIIllIII);
    }

    public void visitMaxs(int llllllllllllllllIlllIllIIIIlIIll, int llllllllllllllllIlllIllIIIIIllll) {
        TraceMethodVisitor llllllllllllllllIlllIllIIIIlIlII;
        llllllllllllllllIlllIllIIIIlIlII.p.visitMaxs(llllllllllllllllIlllIllIIIIlIIll, llllllllllllllllIlllIllIIIIIllll);
        super.visitMaxs(llllllllllllllllIlllIllIIIIlIIll, llllllllllllllllIlllIllIIIIIllll);
    }

    public void visitMethodInsn(int llllllllllllllllIlllIllIlllIlIII, String llllllllllllllllIlllIllIlllIIIIl, String llllllllllllllllIlllIllIlllIIllI, String llllllllllllllllIlllIllIlllIIlIl, boolean llllllllllllllllIlllIllIlllIIlII) {
        TraceMethodVisitor llllllllllllllllIlllIllIlllIIIll;
        if (llllllllllllllllIlllIllIlllIIIll.api < 327680) {
            super.visitMethodInsn(llllllllllllllllIlllIllIlllIlIII, llllllllllllllllIlllIllIlllIIIIl, llllllllllllllllIlllIllIlllIIllI, llllllllllllllllIlllIllIlllIIlIl, llllllllllllllllIlllIllIlllIIlII);
            return;
        }
        llllllllllllllllIlllIllIlllIIIll.p.visitMethodInsn(llllllllllllllllIlllIllIlllIlIII, llllllllllllllllIlllIllIlllIIIIl, llllllllllllllllIlllIllIlllIIllI, llllllllllllllllIlllIllIlllIIlIl, llllllllllllllllIlllIllIlllIIlII);
        if (llllllllllllllllIlllIllIlllIIIll.mv != null) {
            llllllllllllllllIlllIllIlllIIIll.mv.visitMethodInsn(llllllllllllllllIlllIllIlllIlIII, llllllllllllllllIlllIllIlllIIIIl, llllllllllllllllIlllIllIlllIIllI, llllllllllllllllIlllIllIlllIIlIl, llllllllllllllllIlllIllIlllIIlII);
        }
    }

    public void visitLabel(Label llllllllllllllllIlllIllIllIIIIII) {
        TraceMethodVisitor llllllllllllllllIlllIllIllIIIIll;
        llllllllllllllllIlllIllIllIIIIll.p.visitLabel(llllllllllllllllIlllIllIllIIIIII);
        super.visitLabel(llllllllllllllllIlllIllIllIIIIII);
    }

    public void visitInsn(int llllllllllllllllIlllIlllIIlIlIIl) {
        TraceMethodVisitor llllllllllllllllIlllIlllIIlIlIlI;
        llllllllllllllllIlllIlllIIlIlIlI.p.visitInsn(llllllllllllllllIlllIlllIIlIlIIl);
        super.visitInsn(llllllllllllllllIlllIlllIIlIlIIl);
    }

    public void visitLocalVariable(String llllllllllllllllIlllIllIIlIIlIll, String llllllllllllllllIlllIllIIlIIIIll, String llllllllllllllllIlllIllIIlIIIIlI, Label llllllllllllllllIlllIllIIlIIlIII, Label llllllllllllllllIlllIllIIlIIIlll, int llllllllllllllllIlllIllIIlIIIllI) {
        TraceMethodVisitor llllllllllllllllIlllIllIIlIIllII;
        llllllllllllllllIlllIllIIlIIllII.p.visitLocalVariable(llllllllllllllllIlllIllIIlIIlIll, llllllllllllllllIlllIllIIlIIIIll, llllllllllllllllIlllIllIIlIIIIlI, llllllllllllllllIlllIllIIlIIlIII, llllllllllllllllIlllIllIIlIIIlll, llllllllllllllllIlllIllIIlIIIllI);
        super.visitLocalVariable(llllllllllllllllIlllIllIIlIIlIll, llllllllllllllllIlllIllIIlIIIIll, llllllllllllllllIlllIllIIlIIIIlI, llllllllllllllllIlllIllIIlIIlIII, llllllllllllllllIlllIllIIlIIIlll, llllllllllllllllIlllIllIIlIIIllI);
    }

    public AnnotationVisitor visitAnnotationDefault() {
        TraceMethodVisitor llllllllllllllllIlllIlllIlIlllII;
        Printer llllllllllllllllIlllIlllIlIllllI = llllllllllllllllIlllIlllIlIlllII.p.visitAnnotationDefault();
        AnnotationVisitor llllllllllllllllIlllIlllIlIlllIl = llllllllllllllllIlllIlllIlIlllII.mv == null ? null : llllllllllllllllIlllIlllIlIlllII.mv.visitAnnotationDefault();
        return new TraceAnnotationVisitor(llllllllllllllllIlllIlllIlIlllIl, llllllllllllllllIlllIlllIlIllllI);
    }

    public void visitParameter(String llllllllllllllllIlllIllllIllllll, int llllllllllllllllIlllIlllllIIIIIl) {
        TraceMethodVisitor llllllllllllllllIlllIlllllIIIIll;
        llllllllllllllllIlllIlllllIIIIll.p.visitParameter(llllllllllllllllIlllIllllIllllll, llllllllllllllllIlllIlllllIIIIIl);
        super.visitParameter(llllllllllllllllIlllIllllIllllll, llllllllllllllllIlllIlllllIIIIIl);
    }

    public AnnotationVisitor visitTryCatchAnnotation(int llllllllllllllllIlllIllIIlIllIIl, TypePath llllllllllllllllIlllIllIIlIllIII, String llllllllllllllllIlllIllIIlIllllI, boolean llllllllllllllllIlllIllIIlIlIllI) {
        TraceMethodVisitor llllllllllllllllIlllIllIIllIIIIl;
        Printer llllllllllllllllIlllIllIIlIlllII = llllllllllllllllIlllIllIIllIIIIl.p.visitTryCatchAnnotation(llllllllllllllllIlllIllIIlIllIIl, llllllllllllllllIlllIllIIlIllIII, llllllllllllllllIlllIllIIlIllllI, llllllllllllllllIlllIllIIlIlIllI);
        AnnotationVisitor llllllllllllllllIlllIllIIlIllIll = llllllllllllllllIlllIllIIllIIIIl.mv == null ? null : llllllllllllllllIlllIllIIllIIIIl.mv.visitTryCatchAnnotation(llllllllllllllllIlllIllIIlIllIIl, llllllllllllllllIlllIllIIlIllIII, llllllllllllllllIlllIllIIlIllllI, llllllllllllllllIlllIllIIlIlIllI);
        return new TraceAnnotationVisitor(llllllllllllllllIlllIllIIlIllIll, llllllllllllllllIlllIllIIlIlllII);
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIlllIllllIlIIlIl, boolean llllllllllllllllIlllIllllIlIIlII) {
        TraceMethodVisitor llllllllllllllllIlllIllllIlIIllI;
        Printer llllllllllllllllIlllIllllIlIlIII = llllllllllllllllIlllIllllIlIIllI.p.visitMethodAnnotation(llllllllllllllllIlllIllllIlIIlIl, llllllllllllllllIlllIllllIlIIlII);
        AnnotationVisitor llllllllllllllllIlllIllllIlIIlll = llllllllllllllllIlllIllllIlIIllI.mv == null ? null : llllllllllllllllIlllIllllIlIIllI.mv.visitAnnotation(llllllllllllllllIlllIllllIlIIlIl, llllllllllllllllIlllIllllIlIIlII);
        return new TraceAnnotationVisitor(llllllllllllllllIlllIllllIlIIlll, llllllllllllllllIlllIllllIlIlIII);
    }

    public void visitInvokeDynamicInsn(String llllllllllllllllIlllIllIllIlIlll, String llllllllllllllllIlllIllIllIlIIIl, Handle llllllllllllllllIlllIllIllIlIlIl, Object ... llllllllllllllllIlllIllIllIlIlII) {
        TraceMethodVisitor llllllllllllllllIlllIllIllIllIII;
        llllllllllllllllIlllIllIllIllIII.p.visitInvokeDynamicInsn(llllllllllllllllIlllIllIllIlIlll, llllllllllllllllIlllIllIllIlIIIl, llllllllllllllllIlllIllIllIlIlIl, llllllllllllllllIlllIllIllIlIlII);
        super.visitInvokeDynamicInsn(llllllllllllllllIlllIllIllIlIlll, llllllllllllllllIlllIllIllIlIIIl, llllllllllllllllIlllIllIllIlIlIl, llllllllllllllllIlllIllIllIlIlII);
    }

    public void visitTypeInsn(int llllllllllllllllIlllIlllIIIIllll, String llllllllllllllllIlllIlllIIIIlllI) {
        TraceMethodVisitor llllllllllllllllIlllIlllIIIlIIII;
        llllllllllllllllIlllIlllIIIlIIII.p.visitTypeInsn(llllllllllllllllIlllIlllIIIIllll, llllllllllllllllIlllIlllIIIIlllI);
        super.visitTypeInsn(llllllllllllllllIlllIlllIIIIllll, llllllllllllllllIlllIlllIIIIlllI);
    }

    public TraceMethodVisitor(Printer llllllllllllllllIlllIlllllIlIIIl) {
        llllllllllllllllIlllIlllllIlIlII(null, llllllllllllllllIlllIlllllIlIIIl);
        TraceMethodVisitor llllllllllllllllIlllIlllllIlIlII;
    }

    public void visitAttribute(Attribute llllllllllllllllIlllIlllIllIlIIl) {
        TraceMethodVisitor llllllllllllllllIlllIlllIllIllII;
        llllllllllllllllIlllIlllIllIllII.p.visitMethodAttribute(llllllllllllllllIlllIlllIllIlIIl);
        super.visitAttribute(llllllllllllllllIlllIlllIllIlIIl);
    }

    public void visitCode() {
        TraceMethodVisitor llllllllllllllllIlllIlllIlIIIIIl;
        llllllllllllllllIlllIlllIlIIIIIl.p.visitCode();
        super.visitCode();
    }

    public void visitIntInsn(int llllllllllllllllIlllIlllIIlIIlII, int llllllllllllllllIlllIlllIIlIIIll) {
        TraceMethodVisitor llllllllllllllllIlllIlllIIlIIIlI;
        llllllllllllllllIlllIlllIIlIIIlI.p.visitIntInsn(llllllllllllllllIlllIlllIIlIIlII, llllllllllllllllIlllIlllIIlIIIll);
        super.visitIntInsn(llllllllllllllllIlllIlllIIlIIlII, llllllllllllllllIlllIlllIIlIIIll);
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int llllllllllllllllIlllIllIIIllIIll, TypePath llllllllllllllllIlllIllIIIllIIlI, Label[] llllllllllllllllIlllIllIIIlIIlll, Label[] llllllllllllllllIlllIllIIIllIIII, int[] llllllllllllllllIlllIllIIIlIllll, String llllllllllllllllIlllIllIIIlIlllI, boolean llllllllllllllllIlllIllIIIlIllIl) {
        TraceMethodVisitor llllllllllllllllIlllIllIIIllIlII;
        Printer llllllllllllllllIlllIllIIIlIllII = llllllllllllllllIlllIllIIIllIlII.p.visitLocalVariableAnnotation(llllllllllllllllIlllIllIIIllIIll, llllllllllllllllIlllIllIIIllIIlI, llllllllllllllllIlllIllIIIlIIlll, llllllllllllllllIlllIllIIIllIIII, llllllllllllllllIlllIllIIIlIllll, llllllllllllllllIlllIllIIIlIlllI, llllllllllllllllIlllIllIIIlIllIl);
        AnnotationVisitor llllllllllllllllIlllIllIIIlIlIll = llllllllllllllllIlllIllIIIllIlII.mv == null ? null : llllllllllllllllIlllIllIIIllIlII.mv.visitLocalVariableAnnotation(llllllllllllllllIlllIllIIIllIIll, llllllllllllllllIlllIllIIIllIIlI, llllllllllllllllIlllIllIIIlIIlll, llllllllllllllllIlllIllIIIllIIII, llllllllllllllllIlllIllIIIlIllll, llllllllllllllllIlllIllIIIlIlllI, llllllllllllllllIlllIllIIIlIllIl);
        return new TraceAnnotationVisitor(llllllllllllllllIlllIllIIIlIlIll, llllllllllllllllIlllIllIIIlIllII);
    }

    public AnnotationVisitor visitParameterAnnotation(int llllllllllllllllIlllIlllIlIIlllI, String llllllllllllllllIlllIlllIlIIllIl, boolean llllllllllllllllIlllIlllIlIIIllI) {
        TraceMethodVisitor llllllllllllllllIlllIlllIlIIlIIl;
        Printer llllllllllllllllIlllIlllIlIIlIll = llllllllllllllllIlllIlllIlIIlIIl.p.visitParameterAnnotation(llllllllllllllllIlllIlllIlIIlllI, llllllllllllllllIlllIlllIlIIllIl, llllllllllllllllIlllIlllIlIIIllI);
        AnnotationVisitor llllllllllllllllIlllIlllIlIIlIlI = llllllllllllllllIlllIlllIlIIlIIl.mv == null ? null : llllllllllllllllIlllIlllIlIIlIIl.mv.visitParameterAnnotation(llllllllllllllllIlllIlllIlIIlllI, llllllllllllllllIlllIlllIlIIllIl, llllllllllllllllIlllIlllIlIIIllI);
        return new TraceAnnotationVisitor(llllllllllllllllIlllIlllIlIIlIlI, llllllllllllllllIlllIlllIlIIlIll);
    }

    public AnnotationVisitor visitInsnAnnotation(int llllllllllllllllIlllIllIlIIIIlII, TypePath llllllllllllllllIlllIllIlIIIIIll, String llllllllllllllllIlllIllIlIIIIIlI, boolean llllllllllllllllIlllIllIIllllIlI) {
        TraceMethodVisitor llllllllllllllllIlllIllIlIIIIlIl;
        Printer llllllllllllllllIlllIllIlIIIIIII = llllllllllllllllIlllIllIlIIIIlIl.p.visitInsnAnnotation(llllllllllllllllIlllIllIlIIIIlII, llllllllllllllllIlllIllIlIIIIIll, llllllllllllllllIlllIllIlIIIIIlI, llllllllllllllllIlllIllIIllllIlI);
        AnnotationVisitor llllllllllllllllIlllIllIIlllllll = llllllllllllllllIlllIllIlIIIIlIl.mv == null ? null : llllllllllllllllIlllIllIlIIIIlIl.mv.visitInsnAnnotation(llllllllllllllllIlllIllIlIIIIlII, llllllllllllllllIlllIllIlIIIIIll, llllllllllllllllIlllIllIlIIIIIlI, llllllllllllllllIlllIllIIllllIlI);
        return new TraceAnnotationVisitor(llllllllllllllllIlllIllIIlllllll, llllllllllllllllIlllIllIlIIIIIII);
    }

    public void visitMultiANewArrayInsn(String llllllllllllllllIlllIllIlIIlIIIl, int llllllllllllllllIlllIllIlIIlIIII) {
        TraceMethodVisitor llllllllllllllllIlllIllIlIIlIIlI;
        llllllllllllllllIlllIllIlIIlIIlI.p.visitMultiANewArrayInsn(llllllllllllllllIlllIllIlIIlIIIl, llllllllllllllllIlllIllIlIIlIIII);
        super.visitMultiANewArrayInsn(llllllllllllllllIlllIllIlIIlIIIl, llllllllllllllllIlllIllIlIIlIIII);
    }

    public void visitJumpInsn(int llllllllllllllllIlllIllIllIIlIlI, Label llllllllllllllllIlllIllIllIIIllI) {
        TraceMethodVisitor llllllllllllllllIlllIllIllIIlIll;
        llllllllllllllllIlllIllIllIIlIll.p.visitJumpInsn(llllllllllllllllIlllIllIllIIlIlI, llllllllllllllllIlllIllIllIIIllI);
        super.visitJumpInsn(llllllllllllllllIlllIllIllIIlIlI, llllllllllllllllIlllIllIllIIIllI);
    }

    public void visitTryCatchBlock(Label llllllllllllllllIlllIllIIllIllII, Label llllllllllllllllIlllIllIIlllIIII, Label llllllllllllllllIlllIllIIllIlIlI, String llllllllllllllllIlllIllIIllIlIIl) {
        TraceMethodVisitor llllllllllllllllIlllIllIIlllIIlI;
        llllllllllllllllIlllIllIIlllIIlI.p.visitTryCatchBlock(llllllllllllllllIlllIllIIllIllII, llllllllllllllllIlllIllIIlllIIII, llllllllllllllllIlllIllIIllIlIlI, llllllllllllllllIlllIllIIllIlIIl);
        super.visitTryCatchBlock(llllllllllllllllIlllIllIIllIllII, llllllllllllllllIlllIllIIlllIIII, llllllllllllllllIlllIllIIllIlIlI, llllllllllllllllIlllIllIIllIlIIl);
    }

    public void visitEnd() {
        TraceMethodVisitor llllllllllllllllIlllIllIIIIIllIl;
        llllllllllllllllIlllIllIIIIIllIl.p.visitMethodEnd();
        super.visitEnd();
    }
}

