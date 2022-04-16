/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.spongepowered.asm.lib.commons.AnnotationRemapper
 *  org.spongepowered.asm.lib.commons.FieldRemapper
 *  org.spongepowered.asm.lib.commons.MethodRemapper
 *  org.spongepowered.asm.lib.commons.Remapper
 */
package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.commons.AnnotationRemapper;
import org.spongepowered.asm.lib.commons.FieldRemapper;
import org.spongepowered.asm.lib.commons.MethodRemapper;
import org.spongepowered.asm.lib.commons.Remapper;

public class ClassRemapper
extends ClassVisitor {
    protected /* synthetic */ String className;
    protected final /* synthetic */ Remapper remapper;

    public FieldVisitor visitField(int llllllllllllllllllIIIIlllllIlIII, String llllllllllllllllllIIIIllllIllIIl, String llllllllllllllllllIIIIlllllIIlII, String llllllllllllllllllIIIIllllIlIlIl, Object llllllllllllllllllIIIIllllIlIIll) {
        ClassRemapper llllllllllllllllllIIIIlllllIlIlI;
        FieldVisitor llllllllllllllllllIIIIllllIlllll = super.visitField(llllllllllllllllllIIIIlllllIlIII, llllllllllllllllllIIIIlllllIlIlI.remapper.mapFieldName(llllllllllllllllllIIIIlllllIlIlI.className, llllllllllllllllllIIIIllllIllIIl, llllllllllllllllllIIIIlllllIIlII), llllllllllllllllllIIIIlllllIlIlI.remapper.mapDesc(llllllllllllllllllIIIIlllllIIlII), llllllllllllllllllIIIIlllllIlIlI.remapper.mapSignature(llllllllllllllllllIIIIllllIlIlIl, true), llllllllllllllllllIIIIlllllIlIlI.remapper.mapValue(llllllllllllllllllIIIIllllIlIIll));
        return llllllllllllllllllIIIIllllIlllll == null ? null : llllllllllllllllllIIIIlllllIlIlI.createFieldRemapper(llllllllllllllllllIIIIllllIlllll);
    }

    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor llllllllllllllllllIIIIllIIIlllll) {
        ClassRemapper llllllllllllllllllIIIIllIIIlllII;
        return new AnnotationRemapper(llllllllllllllllllIIIIllIIIlllll, llllllllllllllllllIIIIllIIIlllII.remapper);
    }

    public MethodVisitor visitMethod(int llllllllllllllllllIIIIlllIlIIIll, String llllllllllllllllllIIIIlllIlIIIII, String llllllllllllllllllIIIIlllIIlIlII, String llllllllllllllllllIIIIlllIIllllI, String[] llllllllllllllllllIIIIlllIIlIIII) {
        ClassRemapper llllllllllllllllllIIIIlllIIllIlI;
        String llllllllllllllllllIIIIlllIIlllII = llllllllllllllllllIIIIlllIIllIlI.remapper.mapMethodDesc(llllllllllllllllllIIIIlllIIlIlII);
        MethodVisitor llllllllllllllllllIIIIlllIIllIll = super.visitMethod(llllllllllllllllllIIIIlllIlIIIll, llllllllllllllllllIIIIlllIIllIlI.remapper.mapMethodName(llllllllllllllllllIIIIlllIIllIlI.className, llllllllllllllllllIIIIlllIlIIIII, llllllllllllllllllIIIIlllIIlIlII), llllllllllllllllllIIIIlllIIlllII, llllllllllllllllllIIIIlllIIllIlI.remapper.mapSignature(llllllllllllllllllIIIIlllIIllllI, false), llllllllllllllllllIIIIlllIIlIIII == null ? null : llllllllllllllllllIIIIlllIIllIlI.remapper.mapTypes(llllllllllllllllllIIIIlllIIlIIII));
        return llllllllllllllllllIIIIlllIIllIll == null ? null : llllllllllllllllllIIIIlllIIllIlI.createMethodRemapper(llllllllllllllllllIIIIlllIIllIll);
    }

    protected ClassRemapper(int llllllllllllllllllIIIlIIIllllllI, ClassVisitor llllllllllllllllllIIIlIIlIIIIIIl, Remapper llllllllllllllllllIIIlIIlIIIIIII) {
        super(llllllllllllllllllIIIlIIIllllllI, llllllllllllllllllIIIlIIlIIIIIIl);
        ClassRemapper llllllllllllllllllIIIlIIIlllllll;
        llllllllllllllllllIIIlIIIlllllll.remapper = llllllllllllllllllIIIlIIlIIIIIII;
    }

    protected FieldVisitor createFieldRemapper(FieldVisitor llllllllllllllllllIIIIllIlIIIIlI) {
        ClassRemapper llllllllllllllllllIIIIllIlIIIlIl;
        return new FieldRemapper(llllllllllllllllllIIIIllIlIIIIlI, llllllllllllllllllIIIIllIlIIIlIl.remapper);
    }

    public void visit(int llllllllllllllllllIIIlIIIllIIlII, int llllllllllllllllllIIIlIIIllIIIll, String llllllllllllllllllIIIlIIIllIIIlI, String llllllllllllllllllIIIlIIIlIlIlII, String llllllllllllllllllIIIlIIIllIIIII, String[] llllllllllllllllllIIIlIIIlIlllll) {
        ClassRemapper llllllllllllllllllIIIlIIIllIIlIl;
        llllllllllllllllllIIIlIIIllIIlIl.className = llllllllllllllllllIIIlIIIllIIIlI;
        super.visit(llllllllllllllllllIIIlIIIllIIlII, llllllllllllllllllIIIlIIIllIIIll, llllllllllllllllllIIIlIIIllIIlIl.remapper.mapType(llllllllllllllllllIIIlIIIllIIIlI), llllllllllllllllllIIIlIIIllIIlIl.remapper.mapSignature(llllllllllllllllllIIIlIIIlIlIlII, false), llllllllllllllllllIIIlIIIllIIlIl.remapper.mapType(llllllllllllllllllIIIlIIIllIIIII), llllllllllllllllllIIIlIIIlIlllll == null ? null : llllllllllllllllllIIIlIIIllIIlIl.remapper.mapTypes(llllllllllllllllllIIIlIIIlIlllll));
    }

    public void visitOuterClass(String llllllllllllllllllIIIIllIlIIllll, String llllllllllllllllllIIIIllIlIlIIlI, String llllllllllllllllllIIIIllIlIIllIl) {
        ClassRemapper llllllllllllllllllIIIIllIlIlIlII;
        super.visitOuterClass(llllllllllllllllllIIIIllIlIlIlII.remapper.mapType(llllllllllllllllllIIIIllIlIIllll), llllllllllllllllllIIIIllIlIlIIlI == null ? null : llllllllllllllllllIIIIllIlIlIlII.remapper.mapMethodName(llllllllllllllllllIIIIllIlIIllll, llllllllllllllllllIIIIllIlIlIIlI, llllllllllllllllllIIIIllIlIIllIl), llllllllllllllllllIIIIllIlIIllIl == null ? null : llllllllllllllllllIIIIllIlIlIlII.remapper.mapMethodDesc(llllllllllllllllllIIIIllIlIIllIl));
    }

    protected MethodVisitor createMethodRemapper(MethodVisitor llllllllllllllllllIIIIllIIlIlIll) {
        ClassRemapper llllllllllllllllllIIIIllIIlIllIl;
        return new MethodRemapper(llllllllllllllllllIIIIllIIlIlIll, llllllllllllllllllIIIIllIIlIllIl.remapper);
    }

    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllllIIIlIIIIIIlIII, TypePath llllllllllllllllllIIIlIIIIIlIIll, String llllllllllllllllllIIIlIIIIIlIIIl, boolean llllllllllllllllllIIIlIIIIIIlllI) {
        ClassRemapper llllllllllllllllllIIIlIIIIIIlIlI;
        AnnotationVisitor llllllllllllllllllIIIlIIIIIIllII = super.visitTypeAnnotation(llllllllllllllllllIIIlIIIIIIlIII, llllllllllllllllllIIIlIIIIIlIIll, llllllllllllllllllIIIlIIIIIIlIlI.remapper.mapDesc(llllllllllllllllllIIIlIIIIIlIIIl), llllllllllllllllllIIIlIIIIIIlllI);
        return llllllllllllllllllIIIlIIIIIIllII == null ? null : llllllllllllllllllIIIlIIIIIIlIlI.createAnnotationRemapper(llllllllllllllllllIIIlIIIIIIllII);
    }

    public void visitInnerClass(String llllllllllllllllllIIIIllIllIllll, String llllllllllllllllllIIIIllIllIlIIl, String llllllllllllllllllIIIIllIllIlIII, int llllllllllllllllllIIIIllIllIIlll) {
        ClassRemapper llllllllllllllllllIIIIllIlllIIlI;
        super.visitInnerClass(llllllllllllllllllIIIIllIlllIIlI.remapper.mapType(llllllllllllllllllIIIIllIllIllll), llllllllllllllllllIIIIllIllIlIIl == null ? null : llllllllllllllllllIIIIllIlllIIlI.remapper.mapType(llllllllllllllllllIIIIllIllIlIIl), llllllllllllllllllIIIIllIllIlIII, llllllllllllllllllIIIIllIllIIlll);
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllllIIIlIIIIlIlIlI, boolean llllllllllllllllllIIIlIIIIllIIIl) {
        ClassRemapper llllllllllllllllllIIIlIIIIllIlIl;
        AnnotationVisitor llllllllllllllllllIIIlIIIIlIllll = super.visitAnnotation(llllllllllllllllllIIIlIIIIllIlIl.remapper.mapDesc(llllllllllllllllllIIIlIIIIlIlIlI), llllllllllllllllllIIIlIIIIllIIIl);
        return llllllllllllllllllIIIlIIIIlIllll == null ? null : llllllllllllllllllIIIlIIIIllIlIl.createAnnotationRemapper(llllllllllllllllllIIIlIIIIlIllll);
    }

    public ClassRemapper(ClassVisitor llllllllllllllllllIIIlIIlIIlllII, Remapper llllllllllllllllllIIIlIIlIIllIII) {
        llllllllllllllllllIIIlIIlIIllIlI(327680, llllllllllllllllllIIIlIIlIIlllII, llllllllllllllllllIIIlIIlIIllIII);
        ClassRemapper llllllllllllllllllIIIlIIlIIllIlI;
    }
}

