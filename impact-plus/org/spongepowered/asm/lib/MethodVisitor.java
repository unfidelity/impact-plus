/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.TypePath;

public abstract class MethodVisitor {
    protected /* synthetic */ MethodVisitor mv;
    protected final /* synthetic */ int api;

    public AnnotationVisitor visitLocalVariableAnnotation(int lllllllllllllllllIIlIlllIIIIlIlI, TypePath lllllllllllllllllIIlIlllIIIIlIIl, Label[] lllllllllllllllllIIlIlllIIIlIIII, Label[] lllllllllllllllllIIlIlllIIIIllll, int[] lllllllllllllllllIIlIlllIIIIIllI, String lllllllllllllllllIIlIlllIIIIllIl, boolean lllllllllllllllllIIlIlllIIIIllII) {
        MethodVisitor lllllllllllllllllIIlIlllIIIlIlII;
        if (lllllllllllllllllIIlIlllIIIlIlII.api < 327680) {
            throw new RuntimeException();
        }
        if (lllllllllllllllllIIlIlllIIIlIlII.mv != null) {
            return lllllllllllllllllIIlIlllIIIlIlII.mv.visitLocalVariableAnnotation(lllllllllllllllllIIlIlllIIIIlIlI, lllllllllllllllllIIlIlllIIIIlIIl, lllllllllllllllllIIlIlllIIIlIIII, lllllllllllllllllIIlIlllIIIIllll, lllllllllllllllllIIlIlllIIIIIllI, lllllllllllllllllIIlIlllIIIIllIl, lllllllllllllllllIIlIlllIIIIllII);
        }
        return null;
    }

    public void visitTypeInsn(int lllllllllllllllllIIllIIIIllIlIlI, String lllllllllllllllllIIllIIIIllIllII) {
        MethodVisitor lllllllllllllllllIIllIIIIllIlllI;
        if (lllllllllllllllllIIllIIIIllIlllI.mv != null) {
            lllllllllllllllllIIllIIIIllIlllI.mv.visitTypeInsn(lllllllllllllllllIIllIIIIllIlIlI, lllllllllllllllllIIllIIIIllIllII);
        }
    }

    public void visitInsn(int lllllllllllllllllIIllIIIlIIIIllI) {
        MethodVisitor lllllllllllllllllIIllIIIlIIIIlll;
        if (lllllllllllllllllIIllIIIlIIIIlll.mv != null) {
            lllllllllllllllllIIllIIIlIIIIlll.mv.visitInsn(lllllllllllllllllIIllIIIlIIIIllI);
        }
    }

    public MethodVisitor(int lllllllllllllllllIIllIIIllIllIll, MethodVisitor lllllllllllllllllIIllIIIllIllIIl) {
        MethodVisitor lllllllllllllllllIIllIIIlllIIIII;
        if (lllllllllllllllllIIllIIIllIllIll != 262144 && lllllllllllllllllIIllIIIllIllIll != 327680) {
            throw new IllegalArgumentException();
        }
        lllllllllllllllllIIllIIIlllIIIII.api = lllllllllllllllllIIllIIIllIllIll;
        lllllllllllllllllIIllIIIlllIIIII.mv = lllllllllllllllllIIllIIIllIllIIl;
    }

    public void visitLabel(Label lllllllllllllllllIIllIIIIIIIllll) {
        MethodVisitor lllllllllllllllllIIllIIIIIIlIIII;
        if (lllllllllllllllllIIllIIIIIIlIIII.mv != null) {
            lllllllllllllllllIIllIIIIIIlIIII.mv.visitLabel(lllllllllllllllllIIllIIIIIIIllll);
        }
    }

    public void visitIincInsn(int lllllllllllllllllIIlIlllllllIlll, int lllllllllllllllllIIlIlllllllIIll) {
        MethodVisitor lllllllllllllllllIIlIllllllllIII;
        if (lllllllllllllllllIIlIllllllllIII.mv != null) {
            lllllllllllllllllIIlIllllllllIII.mv.visitIincInsn(lllllllllllllllllIIlIlllllllIlll, lllllllllllllllllIIlIlllllllIIll);
        }
    }

    public AnnotationVisitor visitParameterAnnotation(int lllllllllllllllllIIllIIIlIlIlIll, String lllllllllllllllllIIllIIIlIlIIllI, boolean lllllllllllllllllIIllIIIlIlIIlIl) {
        MethodVisitor lllllllllllllllllIIllIIIlIlIlIII;
        if (lllllllllllllllllIIllIIIlIlIlIII.mv != null) {
            return lllllllllllllllllIIllIIIlIlIlIII.mv.visitParameterAnnotation(lllllllllllllllllIIllIIIlIlIlIll, lllllllllllllllllIIllIIIlIlIIllI, lllllllllllllllllIIllIIIlIlIIlIl);
        }
        return null;
    }

    public void visitLdcInsn(Object lllllllllllllllllIIllIIIIIIIIllI) {
        MethodVisitor lllllllllllllllllIIllIIIIIIIlIII;
        if (lllllllllllllllllIIllIIIIIIIlIII.mv != null) {
            lllllllllllllllllIIllIIIIIIIlIII.mv.visitLdcInsn(lllllllllllllllllIIllIIIIIIIIllI);
        }
    }

    public void visitMethodInsn(int lllllllllllllllllIIllIIIIIlllIlI, String lllllllllllllllllIIllIIIIIlllIIl, String lllllllllllllllllIIllIIIIIlllIII, String lllllllllllllllllIIllIIIIIllllIl, boolean lllllllllllllllllIIllIIIIIllllII) {
        MethodVisitor lllllllllllllllllIIllIIIIlIIIIIl;
        if (lllllllllllllllllIIllIIIIlIIIIIl.api < 327680) {
            if (lllllllllllllllllIIllIIIIIllllII != (lllllllllllllllllIIllIIIIIlllIlI == 185)) {
                throw new IllegalArgumentException("INVOKESPECIAL/STATIC on interfaces require ASM 5");
            }
            lllllllllllllllllIIllIIIIlIIIIIl.visitMethodInsn(lllllllllllllllllIIllIIIIIlllIlI, lllllllllllllllllIIllIIIIIlllIIl, lllllllllllllllllIIllIIIIIlllIII, lllllllllllllllllIIllIIIIIllllIl);
            return;
        }
        if (lllllllllllllllllIIllIIIIlIIIIIl.mv != null) {
            lllllllllllllllllIIllIIIIlIIIIIl.mv.visitMethodInsn(lllllllllllllllllIIllIIIIIlllIlI, lllllllllllllllllIIllIIIIIlllIIl, lllllllllllllllllIIllIIIIIlllIII, lllllllllllllllllIIllIIIIIllllIl, lllllllllllllllllIIllIIIIIllllII);
        }
    }

    public void visitFieldInsn(int lllllllllllllllllIIllIIIIllIIIlI, String lllllllllllllllllIIllIIIIllIIIIl, String lllllllllllllllllIIllIIIIllIIIII, String lllllllllllllllllIIllIIIIlIlllll) {
        MethodVisitor lllllllllllllllllIIllIIIIlIllllI;
        if (lllllllllllllllllIIllIIIIlIllllI.mv != null) {
            lllllllllllllllllIIllIIIIlIllllI.mv.visitFieldInsn(lllllllllllllllllIIllIIIIllIIIlI, lllllllllllllllllIIllIIIIllIIIIl, lllllllllllllllllIIllIIIIllIIIII, lllllllllllllllllIIllIIIIlIlllll);
        }
    }

    public void visitMultiANewArrayInsn(String lllllllllllllllllIIlIllllIlIlIlI, int lllllllllllllllllIIlIllllIlIIlII) {
        MethodVisitor lllllllllllllllllIIlIllllIllIIIl;
        if (lllllllllllllllllIIlIllllIllIIIl.mv != null) {
            lllllllllllllllllIIlIllllIllIIIl.mv.visitMultiANewArrayInsn(lllllllllllllllllIIlIllllIlIlIlI, lllllllllllllllllIIlIllllIlIIlII);
        }
    }

    public void visitParameter(String lllllllllllllllllIIllIIIllIlIIII, int lllllllllllllllllIIllIIIllIIllll) {
        MethodVisitor lllllllllllllllllIIllIIIllIIlllI;
        if (lllllllllllllllllIIllIIIllIIlllI.api < 327680) {
            throw new RuntimeException();
        }
        if (lllllllllllllllllIIllIIIllIIlllI.mv != null) {
            lllllllllllllllllIIllIIIllIIlllI.mv.visitParameter(lllllllllllllllllIIllIIIllIlIIII, lllllllllllllllllIIllIIIllIIllll);
        }
    }

    public void visitFrame(int lllllllllllllllllIIllIIIlIIlIlII, int lllllllllllllllllIIllIIIlIIlIIll, Object[] lllllllllllllllllIIllIIIlIIlIIlI, int lllllllllllllllllIIllIIIlIIlIIIl, Object[] lllllllllllllllllIIllIIIlIIIlIlI) {
        MethodVisitor lllllllllllllllllIIllIIIlIIlIlIl;
        if (lllllllllllllllllIIllIIIlIIlIlIl.mv != null) {
            lllllllllllllllllIIllIIIlIIlIlIl.mv.visitFrame(lllllllllllllllllIIllIIIlIIlIlII, lllllllllllllllllIIllIIIlIIlIIll, lllllllllllllllllIIllIIIlIIlIIlI, lllllllllllllllllIIllIIIlIIlIIIl, lllllllllllllllllIIllIIIlIIIlIlI);
        }
    }

    public void visitCode() {
        MethodVisitor lllllllllllllllllIIllIIIlIIlllII;
        if (lllllllllllllllllIIllIIIlIIlllII.mv != null) {
            lllllllllllllllllIIllIIIlIIlllII.mv.visitCode();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int lllllllllllllllllIIllIIIlIlllIIl, TypePath lllllllllllllllllIIllIIIlIlllIII, String lllllllllllllllllIIllIIIlIllIIlI, boolean lllllllllllllllllIIllIIIlIllIllI) {
        MethodVisitor lllllllllllllllllIIllIIIlIllIlIl;
        if (lllllllllllllllllIIllIIIlIllIlIl.api < 327680) {
            throw new RuntimeException();
        }
        if (lllllllllllllllllIIllIIIlIllIlIl.mv != null) {
            return lllllllllllllllllIIllIIIlIllIlIl.mv.visitTypeAnnotation(lllllllllllllllllIIllIIIlIlllIIl, lllllllllllllllllIIllIIIlIlllIII, lllllllllllllllllIIllIIIlIllIIlI, lllllllllllllllllIIllIIIlIllIllI);
        }
        return null;
    }

    public void visitEnd() {
        MethodVisitor lllllllllllllllllIIlIllIllllIIII;
        if (lllllllllllllllllIIlIllIllllIIII.mv != null) {
            lllllllllllllllllIIlIllIllllIIII.mv.visitEnd();
        }
    }

    public void visitJumpInsn(int lllllllllllllllllIIllIIIIIIlIllI, Label lllllllllllllllllIIllIIIIIIllIIl) {
        MethodVisitor lllllllllllllllllIIllIIIIIIlllIl;
        if (lllllllllllllllllIIllIIIIIIlllIl.mv != null) {
            lllllllllllllllllIIllIIIIIIlllIl.mv.visitJumpInsn(lllllllllllllllllIIllIIIIIIlIllI, lllllllllllllllllIIllIIIIIIllIIl);
        }
    }

    @Deprecated
    public void visitMethodInsn(int lllllllllllllllllIIllIIIIlIlIIIl, String lllllllllllllllllIIllIIIIlIIlIll, String lllllllllllllllllIIllIIIIlIIlIlI, String lllllllllllllllllIIllIIIIlIIlIIl) {
        MethodVisitor lllllllllllllllllIIllIIIIlIIllIl;
        if (lllllllllllllllllIIllIIIIlIIllIl.api >= 327680) {
            boolean lllllllllllllllllIIllIIIIlIlIIll = lllllllllllllllllIIllIIIIlIlIIIl == 185;
            lllllllllllllllllIIllIIIIlIIllIl.visitMethodInsn(lllllllllllllllllIIllIIIIlIlIIIl, lllllllllllllllllIIllIIIIlIIlIll, lllllllllllllllllIIllIIIIlIIlIlI, lllllllllllllllllIIllIIIIlIIlIIl, lllllllllllllllllIIllIIIIlIlIIll);
            return;
        }
        if (lllllllllllllllllIIllIIIIlIIllIl.mv != null) {
            lllllllllllllllllIIllIIIIlIIllIl.mv.visitMethodInsn(lllllllllllllllllIIllIIIIlIlIIIl, lllllllllllllllllIIllIIIIlIIlIll, lllllllllllllllllIIllIIIIlIIlIlI, lllllllllllllllllIIllIIIIlIIlIIl);
        }
    }

    public void visitIntInsn(int lllllllllllllllllIIllIIIIlllllll, int lllllllllllllllllIIllIIIIllllIll) {
        MethodVisitor lllllllllllllllllIIllIIIlIIIIIII;
        if (lllllllllllllllllIIllIIIlIIIIIII.mv != null) {
            lllllllllllllllllIIllIIIlIIIIIII.mv.visitIntInsn(lllllllllllllllllIIllIIIIlllllll, lllllllllllllllllIIllIIIIllllIll);
        }
    }

    public AnnotationVisitor visitAnnotation(String lllllllllllllllllIIllIIIllIIIlII, boolean lllllllllllllllllIIllIIIllIIIIII) {
        MethodVisitor lllllllllllllllllIIllIIIllIIIIlI;
        if (lllllllllllllllllIIllIIIllIIIIlI.mv != null) {
            return lllllllllllllllllIIllIIIllIIIIlI.mv.visitAnnotation(lllllllllllllllllIIllIIIllIIIlII, lllllllllllllllllIIllIIIllIIIIII);
        }
        return null;
    }

    public void visitLocalVariable(String lllllllllllllllllIIlIlllIIlIlIIl, String lllllllllllllllllIIlIlllIIllIlII, String lllllllllllllllllIIlIlllIIllIIlI, Label lllllllllllllllllIIlIlllIIllIIII, Label lllllllllllllllllIIlIlllIIlIIlIl, int lllllllllllllllllIIlIlllIIlIIlII) {
        MethodVisitor lllllllllllllllllIIlIlllIIlllIIl;
        if (lllllllllllllllllIIlIlllIIlllIIl.mv != null) {
            lllllllllllllllllIIlIlllIIlllIIl.mv.visitLocalVariable(lllllllllllllllllIIlIlllIIlIlIIl, lllllllllllllllllIIlIlllIIllIlII, lllllllllllllllllIIlIlllIIllIIlI, lllllllllllllllllIIlIlllIIllIIII, lllllllllllllllllIIlIlllIIlIIlIl, lllllllllllllllllIIlIlllIIlIIlII);
        }
    }

    public void visitInvokeDynamicInsn(String lllllllllllllllllIIllIIIIIlIlIlI, String lllllllllllllllllIIllIIIIIlIIlII, Handle lllllllllllllllllIIllIIIIIlIlIII, Object ... lllllllllllllllllIIllIIIIIlIIIlI) {
        MethodVisitor lllllllllllllllllIIllIIIIIlIlIll;
        if (lllllllllllllllllIIllIIIIIlIlIll.mv != null) {
            lllllllllllllllllIIllIIIIIlIlIll.mv.visitInvokeDynamicInsn(lllllllllllllllllIIllIIIIIlIlIlI, lllllllllllllllllIIllIIIIIlIIlII, lllllllllllllllllIIllIIIIIlIlIII, lllllllllllllllllIIllIIIIIlIIIlI);
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int lllllllllllllllllIIlIllllIIIllII, TypePath lllllllllllllllllIIlIllllIIIIIlI, String lllllllllllllllllIIlIllllIIIlIIl, boolean lllllllllllllllllIIlIllllIIIIlll) {
        MethodVisitor lllllllllllllllllIIlIllllIIIIlIl;
        if (lllllllllllllllllIIlIllllIIIIlIl.api < 327680) {
            throw new RuntimeException();
        }
        if (lllllllllllllllllIIlIllllIIIIlIl.mv != null) {
            return lllllllllllllllllIIlIllllIIIIlIl.mv.visitInsnAnnotation(lllllllllllllllllIIlIllllIIIllII, lllllllllllllllllIIlIllllIIIIIlI, lllllllllllllllllIIlIllllIIIlIIl, lllllllllllllllllIIlIllllIIIIlll);
        }
        return null;
    }

    public void visitAttribute(Attribute lllllllllllllllllIIllIIIlIIlllll) {
        MethodVisitor lllllllllllllllllIIllIIIlIlIIIII;
        if (lllllllllllllllllIIllIIIlIlIIIII.mv != null) {
            lllllllllllllllllIIllIIIlIlIIIII.mv.visitAttribute(lllllllllllllllllIIllIIIlIIlllll);
        }
    }

    public void visitMaxs(int lllllllllllllllllIIlIllIllllIIll, int lllllllllllllllllIIlIllIllllIlIl) {
        MethodVisitor lllllllllllllllllIIlIllIllllIlII;
        if (lllllllllllllllllIIlIllIllllIlII.mv != null) {
            lllllllllllllllllIIlIllIllllIlII.mv.visitMaxs(lllllllllllllllllIIlIllIllllIIll, lllllllllllllllllIIlIllIllllIlIl);
        }
    }

    public void visitLineNumber(int lllllllllllllllllIIlIllIllllllII, Label lllllllllllllllllIIlIllIlllllIll) {
        MethodVisitor lllllllllllllllllIIlIllIllllllIl;
        if (lllllllllllllllllIIlIllIllllllIl.mv != null) {
            lllllllllllllllllIIlIllIllllllIl.mv.visitLineNumber(lllllllllllllllllIIlIllIllllllII, lllllllllllllllllIIlIllIlllllIll);
        }
    }

    public void visitTableSwitchInsn(int lllllllllllllllllIIlIllllllIIIll, int lllllllllllllllllIIlIlllllIllIII, Label lllllllllllllllllIIlIlllllIlIllI, Label ... lllllllllllllllllIIlIlllllIlIlII) {
        MethodVisitor lllllllllllllllllIIlIllllllIIlII;
        if (lllllllllllllllllIIlIllllllIIlII.mv != null) {
            lllllllllllllllllIIlIllllllIIlII.mv.visitTableSwitchInsn(lllllllllllllllllIIlIllllllIIIll, lllllllllllllllllIIlIlllllIllIII, lllllllllllllllllIIlIlllllIlIllI, lllllllllllllllllIIlIlllllIlIlII);
        }
    }

    public AnnotationVisitor visitTryCatchAnnotation(int lllllllllllllllllIIlIlllIlIIllII, TypePath lllllllllllllllllIIlIlllIlIIlIll, String lllllllllllllllllIIlIlllIlIlIIII, boolean lllllllllllllllllIIlIlllIlIIlllI) {
        MethodVisitor lllllllllllllllllIIlIlllIlIIllIl;
        if (lllllllllllllllllIIlIlllIlIIllIl.api < 327680) {
            throw new RuntimeException();
        }
        if (lllllllllllllllllIIlIlllIlIIllIl.mv != null) {
            return lllllllllllllllllIIlIlllIlIIllIl.mv.visitTryCatchAnnotation(lllllllllllllllllIIlIlllIlIIllII, lllllllllllllllllIIlIlllIlIIlIll, lllllllllllllllllIIlIlllIlIlIIII, lllllllllllllllllIIlIlllIlIIlllI);
        }
        return null;
    }

    public void visitLookupSwitchInsn(Label lllllllllllllllllIIlIlllllIIIIIl, int[] lllllllllllllllllIIlIllllIllllll, Label[] lllllllllllllllllIIlIlllllIIIlII) {
        MethodVisitor lllllllllllllllllIIlIlllllIIIlll;
        if (lllllllllllllllllIIlIlllllIIIlll.mv != null) {
            lllllllllllllllllIIlIlllllIIIlll.mv.visitLookupSwitchInsn(lllllllllllllllllIIlIlllllIIIIIl, lllllllllllllllllIIlIllllIllllll, lllllllllllllllllIIlIlllllIIIlII);
        }
    }

    public AnnotationVisitor visitAnnotationDefault() {
        MethodVisitor lllllllllllllllllIIllIIIllIIlIIl;
        if (lllllllllllllllllIIllIIIllIIlIIl.mv != null) {
            return lllllllllllllllllIIllIIIllIIlIIl.mv.visitAnnotationDefault();
        }
        return null;
    }

    public void visitVarInsn(int lllllllllllllllllIIllIIIIlllIllI, int lllllllllllllllllIIllIIIIlllIIlI) {
        MethodVisitor lllllllllllllllllIIllIIIIlllIlII;
        if (lllllllllllllllllIIllIIIIlllIlII.mv != null) {
            lllllllllllllllllIIllIIIIlllIlII.mv.visitVarInsn(lllllllllllllllllIIllIIIIlllIllI, lllllllllllllllllIIllIIIIlllIIlI);
        }
    }

    public MethodVisitor(int lllllllllllllllllIIllIIIlllIlIlI) {
        lllllllllllllllllIIllIIIlllIllIl(lllllllllllllllllIIllIIIlllIlIlI, null);
        MethodVisitor lllllllllllllllllIIllIIIlllIllIl;
    }

    public void visitTryCatchBlock(Label lllllllllllllllllIIlIlllIllIllll, Label lllllllllllllllllIIlIlllIllIlIIl, Label lllllllllllllllllIIlIlllIllIllIl, String lllllllllllllllllIIlIlllIllIIllI) {
        MethodVisitor lllllllllllllllllIIlIlllIllIlIll;
        if (lllllllllllllllllIIlIlllIllIlIll.mv != null) {
            lllllllllllllllllIIlIlllIllIlIll.mv.visitTryCatchBlock(lllllllllllllllllIIlIlllIllIllll, lllllllllllllllllIIlIlllIllIlIIl, lllllllllllllllllIIlIlllIllIllIl, lllllllllllllllllIIlIlllIllIIllI);
        }
    }
}

