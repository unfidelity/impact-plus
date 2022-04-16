/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.ASMifiable;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.TraceClassVisitor;

public class ASMifier
extends Printer {
    protected final /* synthetic */ String name;
    private static final /* synthetic */ int ACCESS_INNER;
    protected final /* synthetic */ int id;
    protected /* synthetic */ Map<Label, String> labelNames;
    private static final /* synthetic */ int ACCESS_CLASS;
    private static final /* synthetic */ int ACCESS_FIELD;

    public void visit(String lIlIlllIIIIII, Object lIlIllIllllll) {
        ASMifier lIlIlllIIIIIl;
        lIlIlllIIIIIl.buf.setLength(0);
        lIlIlllIIIIIl.buf.append("av").append(lIlIlllIIIIIl.id).append(".visit(");
        ASMifier.appendConstant(lIlIlllIIIIIl.buf, lIlIlllIIIIII);
        lIlIlllIIIIIl.buf.append(", ");
        ASMifier.appendConstant(lIlIlllIIIIIl.buf, lIlIllIllllll);
        lIlIlllIIIIIl.buf.append(");\n");
        lIlIlllIIIIIl.text.add(lIlIlllIIIIIl.buf.toString());
    }

    public void visitFrame(int lIlIIlIlIlIII, int lIlIIlIlIIIII, Object[] lIlIIlIlIIlIl, int lIlIIlIlIIlII, Object[] lIlIIlIlIIIll) {
        ASMifier lIlIIlIlIlIIl;
        lIlIIlIlIlIIl.buf.setLength(0);
        switch (lIlIIlIlIlIII) {
            case -1: 
            case 0: {
                lIlIIlIlIlIIl.declareFrameTypes(lIlIIlIlIIIII, lIlIIlIlIIlIl);
                lIlIIlIlIlIIl.declareFrameTypes(lIlIIlIlIIlII, lIlIIlIlIIIll);
                if (lIlIIlIlIlIII == -1) {
                    lIlIIlIlIlIIl.buf.append(lIlIIlIlIlIIl.name).append(".visitFrame(Opcodes.F_NEW, ");
                } else {
                    lIlIIlIlIlIIl.buf.append(lIlIIlIlIlIIl.name).append(".visitFrame(Opcodes.F_FULL, ");
                }
                lIlIIlIlIlIIl.buf.append(lIlIIlIlIIIII).append(", new Object[] {");
                lIlIIlIlIlIIl.appendFrameTypes(lIlIIlIlIIIII, lIlIIlIlIIlIl);
                lIlIIlIlIlIIl.buf.append("}, ").append(lIlIIlIlIIlII).append(", new Object[] {");
                lIlIIlIlIlIIl.appendFrameTypes(lIlIIlIlIIlII, lIlIIlIlIIIll);
                lIlIIlIlIlIIl.buf.append('}');
                break;
            }
            case 1: {
                lIlIIlIlIlIIl.declareFrameTypes(lIlIIlIlIIIII, lIlIIlIlIIlIl);
                lIlIIlIlIlIIl.buf.append(lIlIIlIlIlIIl.name).append(".visitFrame(Opcodes.F_APPEND,").append(lIlIIlIlIIIII).append(", new Object[] {");
                lIlIIlIlIlIIl.appendFrameTypes(lIlIIlIlIIIII, lIlIIlIlIIlIl);
                lIlIIlIlIlIIl.buf.append("}, 0, null");
                break;
            }
            case 2: {
                lIlIIlIlIlIIl.buf.append(lIlIIlIlIlIIl.name).append(".visitFrame(Opcodes.F_CHOP,").append(lIlIIlIlIIIII).append(", null, 0, null");
                break;
            }
            case 3: {
                lIlIIlIlIlIIl.buf.append(lIlIIlIlIlIIl.name).append(".visitFrame(Opcodes.F_SAME, 0, null, 0, null");
                break;
            }
            case 4: {
                lIlIIlIlIlIIl.declareFrameTypes(1, lIlIIlIlIIIll);
                lIlIIlIlIlIIl.buf.append(lIlIIlIlIlIIl.name).append(".visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {");
                lIlIIlIlIlIIl.appendFrameTypes(1, lIlIIlIlIIIll);
                lIlIIlIlIlIIl.buf.append('}');
            }
        }
        lIlIIlIlIlIIl.buf.append(");\n");
        lIlIIlIlIlIIl.text.add(lIlIIlIlIlIIl.buf.toString());
    }

    public void visitTableSwitchInsn(int lIIllIllllllI, int lIIlllIIIIIlI, Label lIIlllIIIIIIl, Label ... lIIllIllllIll) {
        ASMifier lIIlllIIIIlII;
        lIIlllIIIIlII.buf.setLength(0);
        for (int lIIlllIIIIllI = 0; lIIlllIIIIllI < lIIllIllllIll.length; ++lIIlllIIIIllI) {
            lIIlllIIIIlII.declareLabel(lIIllIllllIll[lIIlllIIIIllI]);
        }
        lIIlllIIIIlII.declareLabel(lIIlllIIIIIIl);
        lIIlllIIIIlII.buf.append(lIIlllIIIIlII.name).append(".visitTableSwitchInsn(").append(lIIllIllllllI).append(", ").append(lIIlllIIIIIlI).append(", ");
        lIIlllIIIIlII.appendLabel(lIIlllIIIIIIl);
        lIIlllIIIIlII.buf.append(", new Label[] {");
        for (int lIIlllIIIIlIl = 0; lIIlllIIIIlIl < lIIllIllllIll.length; ++lIIlllIIIIlIl) {
            lIIlllIIIIlII.buf.append(lIIlllIIIIlIl == 0 ? " " : ", ");
            lIIlllIIIIlII.appendLabel(lIIllIllllIll[lIIlllIIIIlIl]);
        }
        lIIlllIIIIlII.buf.append(" });\n");
        lIIlllIIIIlII.text.add(lIIlllIIIIlII.buf.toString());
    }

    public void visitParameter(String lIlIlIIlIIlIl, int lIlIlIIlIIlII) {
        ASMifier lIlIlIIlIIllI;
        lIlIlIIlIIllI.buf.setLength(0);
        lIlIlIIlIIllI.buf.append(lIlIlIIlIIllI.name).append(".visitParameter(");
        ASMifier.appendString(lIlIlIIlIIllI.buf, lIlIlIIlIIlIl);
        lIlIlIIlIIllI.buf.append(", ");
        lIlIlIIlIIllI.appendAccess(lIlIlIIlIIlII);
        lIlIlIIlIIllI.text.add(lIlIlIIlIIllI.buf.append(");\n").toString());
    }

    public void visitFieldEnd() {
        ASMifier lIlIlIIlIlIlI;
        lIlIlIIlIlIlI.buf.setLength(0);
        lIlIlIIlIlIlI.buf.append(lIlIlIIlIlIlI.name).append(".visitEnd();\n");
        lIlIlIIlIlIlI.text.add(lIlIlIIlIlIlI.buf.toString());
    }

    public ASMifier visitAnnotationDefault() {
        ASMifier lIlIlIIIlllII;
        lIlIlIIIlllII.buf.setLength(0);
        lIlIlIIIlllII.buf.append("{\n").append("av0 = ").append(lIlIlIIIlllII.name).append(".visitAnnotationDefault();\n");
        lIlIlIIIlllII.text.add(lIlIlIIIlllII.buf.toString());
        ASMifier lIlIlIIIlllIl = lIlIlIIIlllII.createASMifier("av", 0);
        lIlIlIIIlllII.text.add(lIlIlIIIlllIl.getText());
        lIlIlIIIlllII.text.add("}\n");
        return lIlIlIIIlllIl;
    }

    public ASMifier visitMethodTypeAnnotation(int lIlIIlllllIll, TypePath lIlIIlllllIlI, String lIlIIlllllIII, boolean lIlIIllllllll) {
        ASMifier lIlIlIIIIIlII;
        return lIlIlIIIIIlII.visitTypeAnnotation(lIlIIlllllIll, lIlIIlllllIlI, lIlIIlllllIII, lIlIIllllllll);
    }

    public void visitLocalVariable(String lIIllIIlIIIll, String lIIllIIlIIIlI, String lIIllIIlIlIII, Label lIIllIIlIIlll, Label lIIllIIIlllll, int lIIllIIlIIlIl) {
        ASMifier lIIllIIlIlIll;
        lIIllIIlIlIll.buf.setLength(0);
        lIIllIIlIlIll.buf.append(lIIllIIlIlIll.name).append(".visitLocalVariable(");
        lIIllIIlIlIll.appendConstant(lIIllIIlIIIll);
        lIIllIIlIlIll.buf.append(", ");
        lIIllIIlIlIll.appendConstant(lIIllIIlIIIlI);
        lIIllIIlIlIll.buf.append(", ");
        lIIllIIlIlIll.appendConstant(lIIllIIlIlIII);
        lIIllIIlIlIll.buf.append(", ");
        lIIllIIlIlIll.appendLabel(lIIllIIlIIlll);
        lIIllIIlIlIll.buf.append(", ");
        lIIllIIlIlIll.appendLabel(lIIllIIIlllll);
        lIIllIIlIlIll.buf.append(", ").append(lIIllIIlIIlIl).append(");\n");
        lIIllIIlIlIll.text.add(lIIllIIlIlIll.buf.toString());
    }

    public static void main(String[] lIlllIIIIIIll) throws Exception {
        ClassReader lIllIllllllll;
        int lIlllIIIIIIlI = 0;
        int lIlllIIIIIIIl = 2;
        boolean lIlllIIIIIIII = true;
        if (lIlllIIIIIIll.length < 1 || lIlllIIIIIIll.length > 2) {
            lIlllIIIIIIII = false;
        }
        if (lIlllIIIIIIII && "-debug".equals(lIlllIIIIIIll[0])) {
            lIlllIIIIIIlI = 1;
            lIlllIIIIIIIl = 0;
            if (lIlllIIIIIIll.length != 2) {
                lIlllIIIIIIII = false;
            }
        }
        if (!lIlllIIIIIIII) {
            System.err.println("Prints the ASM code to generate the given class.");
            System.err.println("Usage: ASMifier [-debug] <fully qualified class name or class file name>");
            return;
        }
        if (lIlllIIIIIIll[lIlllIIIIIIlI].endsWith(".class") || lIlllIIIIIIll[lIlllIIIIIIlI].indexOf(92) > -1 || lIlllIIIIIIll[lIlllIIIIIIlI].indexOf(47) > -1) {
            ClassReader lIlllIIIIIlII = new ClassReader(new FileInputStream(lIlllIIIIIIll[lIlllIIIIIIlI]));
        } else {
            lIllIllllllll = new ClassReader(lIlllIIIIIIll[lIlllIIIIIIlI]);
        }
        lIllIllllllll.accept(new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out)), lIlllIIIIIIIl);
    }

    private void doVisitMethodInsn(int lIlIIIIIlIlII, String lIlIIIIIlIIll, String lIlIIIIIllIll, String lIlIIIIIllIIl, boolean lIlIIIIIllIII) {
        ASMifier lIlIIIIIllllI;
        lIlIIIIIllllI.buf.setLength(0);
        lIlIIIIIllllI.buf.append(lIlIIIIIllllI.name).append(".visitMethodInsn(").append(OPCODES[lIlIIIIIlIlII]).append(", ");
        lIlIIIIIllllI.appendConstant(lIlIIIIIlIIll);
        lIlIIIIIllllI.buf.append(", ");
        lIlIIIIIllllI.appendConstant(lIlIIIIIllIll);
        lIlIIIIIllllI.buf.append(", ");
        lIlIIIIIllllI.appendConstant(lIlIIIIIllIIl);
        lIlIIIIIllllI.buf.append(", ");
        lIlIIIIIllllI.buf.append(lIlIIIIIllIII ? "true" : "false");
        lIlIIIIIllllI.buf.append(");\n");
        lIlIIIIIllllI.text.add(lIlIIIIIllllI.buf.toString());
    }

    public void visitInvokeDynamicInsn(String lIIlllllIlIlI, String lIIlllllIlllI, Handle lIIlllllIllIl, Object ... lIIlllllIllII) {
        ASMifier lIIlllllIlIll;
        lIIlllllIlIll.buf.setLength(0);
        lIIlllllIlIll.buf.append(lIIlllllIlIll.name).append(".visitInvokeDynamicInsn(");
        lIIlllllIlIll.appendConstant(lIIlllllIlIlI);
        lIIlllllIlIll.buf.append(", ");
        lIIlllllIlIll.appendConstant(lIIlllllIlllI);
        lIIlllllIlIll.buf.append(", ");
        lIIlllllIlIll.appendConstant(lIIlllllIllIl);
        lIIlllllIlIll.buf.append(", new Object[]{");
        for (int lIIllllllIIIl = 0; lIIllllllIIIl < lIIlllllIllII.length; ++lIIllllllIIIl) {
            lIIlllllIlIll.appendConstant(lIIlllllIllII[lIIllllllIIIl]);
            if (lIIllllllIIIl == lIIlllllIllII.length - 1) continue;
            lIIlllllIlIll.buf.append(", ");
        }
        lIIlllllIlIll.buf.append("});\n");
        lIIlllllIlIll.text.add(lIIlllllIlIll.buf.toString());
    }

    public void visitClassAttribute(Attribute lIllIIlIIlIIl) {
        ASMifier lIllIIlIIlllI;
        lIllIIlIIlllI.visitAttribute(lIllIIlIIlIIl);
    }

    public ASMifier visitMethodAnnotation(String lIlIlIIIlIllI, boolean lIlIlIIIlIlIl) {
        ASMifier lIlIlIIIlIlll;
        return lIlIlIIIlIlll.visitAnnotation(lIlIlIIIlIllI, lIlIlIIIlIlIl);
    }

    public void visitMethodAttribute(Attribute lIlIIllIIlIll) {
        ASMifier lIlIIllIIllII;
        lIlIIllIIllII.visitAttribute(lIlIIllIIlIll);
    }

    public void visitMaxs(int lIIlIlllIllll, int lIIlIlllIlllI) {
        ASMifier lIIlIllllIIll;
        lIIlIllllIIll.buf.setLength(0);
        lIIlIllllIIll.buf.append(lIIlIllllIIll.name).append(".visitMaxs(").append(lIIlIlllIllll).append(", ").append(lIIlIlllIlllI).append(");\n");
        lIIlIllllIIll.text.add(lIIlIllllIIll.buf.toString());
    }

    protected ASMifier(int lIlllIIlIlIIl, String lIlllIIlIIlII, int lIlllIIlIIIlI) {
        super(lIlllIIlIlIIl);
        ASMifier lIlllIIlIlIlI;
        lIlllIIlIlIlI.name = lIlllIIlIIlII;
        lIlllIIlIlIlI.id = lIlllIIlIIIlI;
    }

    public void visitInnerClass(String lIllIIIIlllIl, String lIllIIIIlIlll, String lIllIIIIllIll, int lIllIIIIllIlI) {
        ASMifier lIllIIIIllllI;
        lIllIIIIllllI.buf.setLength(0);
        lIllIIIIllllI.buf.append("cw.visitInnerClass(");
        lIllIIIIllllI.appendConstant(lIllIIIIlllIl);
        lIllIIIIllllI.buf.append(", ");
        lIllIIIIllllI.appendConstant(lIllIIIIlIlll);
        lIllIIIIllllI.buf.append(", ");
        lIllIIIIllllI.appendConstant(lIllIIIIllIll);
        lIllIIIIllllI.buf.append(", ");
        lIllIIIIllllI.appendAccess(lIllIIIIllIlI | 0x100000);
        lIllIIIIllllI.buf.append(");\n\n");
        lIllIIIIllllI.text.add(lIllIIIIllllI.buf.toString());
    }

    public Printer visitLocalVariableAnnotation(int lIIllIIIIIlll, TypePath lIIllIIIIllll, Label[] lIIllIIIIIlIl, Label[] lIIllIIIIllIl, int[] lIIllIIIIIIll, String lIIllIIIIlIll, boolean lIIllIIIIIIIl) {
        ASMifier lIIllIIIlIIIl;
        lIIllIIIlIIIl.buf.setLength(0);
        lIIllIIIlIIIl.buf.append("{\n").append("av0 = ").append(lIIllIIIlIIIl.name).append(".visitLocalVariableAnnotation(");
        lIIllIIIlIIIl.buf.append(lIIllIIIIIlll);
        if (lIIllIIIIllll == null) {
            lIIllIIIlIIIl.buf.append(", null, ");
        } else {
            lIIllIIIlIIIl.buf.append(", TypePath.fromString(\"").append(lIIllIIIIllll).append("\"), ");
        }
        lIIllIIIlIIIl.buf.append("new Label[] {");
        for (int lIIllIIIlIlII = 0; lIIllIIIlIlII < lIIllIIIIIlIl.length; ++lIIllIIIlIlII) {
            lIIllIIIlIIIl.buf.append(lIIllIIIlIlII == 0 ? " " : ", ");
            lIIllIIIlIIIl.appendLabel(lIIllIIIIIlIl[lIIllIIIlIlII]);
        }
        lIIllIIIlIIIl.buf.append(" }, new Label[] {");
        for (int lIIllIIIlIIll = 0; lIIllIIIlIIll < lIIllIIIIllIl.length; ++lIIllIIIlIIll) {
            lIIllIIIlIIIl.buf.append(lIIllIIIlIIll == 0 ? " " : ", ");
            lIIllIIIlIIIl.appendLabel(lIIllIIIIllIl[lIIllIIIlIIll]);
        }
        lIIllIIIlIIIl.buf.append(" }, new int[] {");
        for (int lIIllIIIlIIlI = 0; lIIllIIIlIIlI < lIIllIIIIIIll.length; ++lIIllIIIlIIlI) {
            lIIllIIIlIIIl.buf.append(lIIllIIIlIIlI == 0 ? " " : ", ").append(lIIllIIIIIIll[lIIllIIIlIIlI]);
        }
        lIIllIIIlIIIl.buf.append(" }, ");
        lIIllIIIlIIIl.appendConstant(lIIllIIIIlIll);
        lIIllIIIlIIIl.buf.append(", ").append(lIIllIIIIIIIl).append(");\n");
        lIIllIIIlIIIl.text.add(lIIllIIIlIIIl.buf.toString());
        ASMifier lIIllIIIIlIIl = lIIllIIIlIIIl.createASMifier("av", 0);
        lIIllIIIlIIIl.text.add(lIIllIIIIlIIl.getText());
        lIIllIIIlIIIl.text.add("}\n");
        return lIIllIIIIlIIl;
    }

    public void visitTryCatchBlock(Label lIIllIlIIIlIl, Label lIIllIlIIIlII, Label lIIllIlIIIIll, String lIIllIlIIIIlI) {
        ASMifier lIIllIlIIIllI;
        lIIllIlIIIllI.buf.setLength(0);
        lIIllIlIIIllI.declareLabel(lIIllIlIIIlIl);
        lIIllIlIIIllI.declareLabel(lIIllIlIIIlII);
        lIIllIlIIIllI.declareLabel(lIIllIlIIIIll);
        lIIllIlIIIllI.buf.append(lIIllIlIIIllI.name).append(".visitTryCatchBlock(");
        lIIllIlIIIllI.appendLabel(lIIllIlIIIlIl);
        lIIllIlIIIllI.buf.append(", ");
        lIIllIlIIIllI.appendLabel(lIIllIlIIIlII);
        lIIllIlIIIllI.buf.append(", ");
        lIIllIlIIIllI.appendLabel(lIIllIlIIIIll);
        lIIllIlIIIllI.buf.append(", ");
        lIIllIlIIIllI.appendConstant(lIIllIlIIIIlI);
        lIIllIlIIIllI.buf.append(");\n");
        lIIllIlIIIllI.text.add(lIIllIlIIIllI.buf.toString());
    }

    public void visitInsn(int lIlIIlIIllIIl) {
        ASMifier lIlIIlIIllIlI;
        lIlIIlIIllIlI.buf.setLength(0);
        lIlIIlIIllIlI.buf.append(lIlIIlIIllIlI.name).append(".visitInsn(").append(OPCODES[lIlIIlIIllIIl]).append(");\n");
        lIlIIlIIllIlI.text.add(lIlIIlIIllIlI.buf.toString());
    }

    @Deprecated
    public void visitMethodInsn(int lIlIIIllIIIIl, String lIlIIIllIIIII, String lIlIIIllIIlII, String lIlIIIllIIIll) {
        ASMifier lIlIIIllIIIlI;
        if (lIlIIIllIIIlI.api >= 327680) {
            super.visitMethodInsn(lIlIIIllIIIIl, lIlIIIllIIIII, lIlIIIllIIlII, lIlIIIllIIIll);
            return;
        }
        lIlIIIllIIIlI.doVisitMethodInsn(lIlIIIllIIIIl, lIlIIIllIIIII, lIlIIIllIIlII, lIlIIIllIIIll, lIlIIIllIIIIl == 185);
    }

    public void visitMethodEnd() {
        ASMifier lIIlIlllIllII;
        lIIlIlllIllII.buf.setLength(0);
        lIIlIlllIllII.buf.append(lIIlIlllIllII.name).append(".visitEnd();\n");
        lIIlIlllIllII.text.add(lIIlIlllIllII.buf.toString());
    }

    public ASMifier visitTypeAnnotation(int lIIlIllIlIIll, TypePath lIIlIllIlIIlI, String lIIlIllIlIllI, boolean lIIlIllIlIIII) {
        ASMifier lIIlIllIlIlII;
        return lIIlIllIlIlII.visitTypeAnnotation("visitTypeAnnotation", lIIlIllIlIIll, lIIlIllIlIIlI, lIIlIllIlIllI, lIIlIllIlIIII);
    }

    public ASMifier visitAnnotation(String lIlIllIIIlIII, String lIlIllIIIIllI) {
        ASMifier lIlIllIIIlIIl;
        lIlIllIIIlIIl.buf.setLength(0);
        lIlIllIIIlIIl.buf.append("{\n");
        lIlIllIIIlIIl.buf.append("AnnotationVisitor av").append(lIlIllIIIlIIl.id + 1).append(" = av");
        lIlIllIIIlIIl.buf.append(lIlIllIIIlIIl.id).append(".visitAnnotation(");
        ASMifier.appendConstant(lIlIllIIIlIIl.buf, lIlIllIIIlIII);
        lIlIllIIIlIIl.buf.append(", ");
        ASMifier.appendConstant(lIlIllIIIlIIl.buf, lIlIllIIIIllI);
        lIlIllIIIlIIl.buf.append(");\n");
        lIlIllIIIlIIl.text.add(lIlIllIIIlIIl.buf.toString());
        ASMifier lIlIllIIIlIll = lIlIllIIIlIIl.createASMifier("av", lIlIllIIIlIIl.id + 1);
        lIlIllIIIlIIl.text.add(lIlIllIIIlIll.getText());
        lIlIllIIIlIIl.text.add("}\n");
        return lIlIllIIIlIll;
    }

    public void visitSource(String lIllIlIIllIII, String lIllIlIIlIlll) {
        ASMifier lIllIlIIlllII;
        lIllIlIIlllII.buf.setLength(0);
        lIllIlIIlllII.buf.append("cw.visitSource(");
        lIllIlIIlllII.appendConstant(lIllIlIIllIII);
        lIllIlIIlllII.buf.append(", ");
        lIllIlIIlllII.appendConstant(lIllIlIIlIlll);
        lIllIlIIlllII.buf.append(");\n\n");
        lIllIlIIlllII.text.add(lIllIlIIlllII.buf.toString());
    }

    public ASMifier visitArray(String lIlIlIllIllll) {
        ASMifier lIlIlIlllIlIl;
        lIlIlIlllIlIl.buf.setLength(0);
        lIlIlIlllIlIl.buf.append("{\n");
        lIlIlIlllIlIl.buf.append("AnnotationVisitor av").append(lIlIlIlllIlIl.id + 1).append(" = av");
        lIlIlIlllIlIl.buf.append(lIlIlIlllIlIl.id).append(".visitArray(");
        ASMifier.appendConstant(lIlIlIlllIlIl.buf, lIlIlIllIllll);
        lIlIlIlllIlIl.buf.append(");\n");
        lIlIlIlllIlIl.text.add(lIlIlIlllIlIl.buf.toString());
        ASMifier lIlIlIlllIIIl = lIlIlIlllIlIl.createASMifier("av", lIlIlIlllIlIl.id + 1);
        lIlIlIlllIlIl.text.add(lIlIlIlllIIIl.getText());
        lIlIlIlllIlIl.text.add("}\n");
        return lIlIlIlllIIIl;
    }

    public void visitFieldInsn(int lIlIIIlllIIII, String lIlIIIllIllll, String lIlIIIllIlllI, String lIlIIIlllIIlI) {
        ASMifier lIlIIIlllIllI;
        lIlIIIlllIllI.buf.setLength(0);
        lIlIIIlllIllI.buf.append(lIlIIIlllIllI.name).append(".visitFieldInsn(").append(OPCODES[lIlIIIlllIIII]).append(", ");
        lIlIIIlllIllI.appendConstant(lIlIIIllIllll);
        lIlIIIlllIllI.buf.append(", ");
        lIlIIIlllIllI.appendConstant(lIlIIIllIlllI);
        lIlIIIlllIllI.buf.append(", ");
        lIlIIIlllIllI.appendConstant(lIlIIIlllIIlI);
        lIlIIIlllIllI.buf.append(");\n");
        lIlIIIlllIllI.text.add(lIlIIIlllIllI.buf.toString());
    }

    public ASMifier visitAnnotation(String lIIlIlllIIlIl, boolean lIIlIlllIIlII) {
        ASMifier lIIlIlllIIllI;
        lIIlIlllIIllI.buf.setLength(0);
        lIIlIlllIIllI.buf.append("{\n").append("av0 = ").append(lIIlIlllIIllI.name).append(".visitAnnotation(");
        lIIlIlllIIllI.appendConstant(lIIlIlllIIlIl);
        lIIlIlllIIllI.buf.append(", ").append(lIIlIlllIIlII).append(");\n");
        lIIlIlllIIllI.text.add(lIIlIlllIIllI.buf.toString());
        ASMifier lIIlIlllIIIll = lIIlIlllIIllI.createASMifier("av", 0);
        lIIlIlllIIllI.text.add(lIIlIlllIIIll.getText());
        lIIlIlllIIllI.text.add("}\n");
        return lIIlIlllIIIll;
    }

    public void visitMultiANewArrayInsn(String lIIllIllIIIIl, int lIIllIllIIIll) {
        ASMifier lIIllIllIIIlI;
        lIIllIllIIIlI.buf.setLength(0);
        lIIllIllIIIlI.buf.append(lIIllIllIIIlI.name).append(".visitMultiANewArrayInsn(");
        lIIllIllIIIlI.appendConstant(lIIllIllIIIIl);
        lIIllIllIIIlI.buf.append(", ").append(lIIllIllIIIll).append(");\n");
        lIIllIllIIIlI.text.add(lIIllIllIIIlI.buf.toString());
    }

    public ASMifier visitMethod(int lIlIlllIlIllI, String lIlIlllIlIlII, String lIlIlllIIlIll, String lIlIlllIIlIlI, String[] lIlIlllIlIIII) {
        ASMifier lIlIlllIIlllI;
        lIlIlllIIlllI.buf.setLength(0);
        lIlIlllIIlllI.buf.append("{\n");
        lIlIlllIIlllI.buf.append("mv = cw.visitMethod(");
        lIlIlllIIlllI.appendAccess(lIlIlllIlIllI);
        lIlIlllIIlllI.buf.append(", ");
        lIlIlllIIlllI.appendConstant(lIlIlllIlIlII);
        lIlIlllIIlllI.buf.append(", ");
        lIlIlllIIlllI.appendConstant(lIlIlllIIlIll);
        lIlIlllIIlllI.buf.append(", ");
        lIlIlllIIlllI.appendConstant(lIlIlllIIlIlI);
        lIlIlllIIlllI.buf.append(", ");
        if (lIlIlllIlIIII != null && lIlIlllIlIIII.length > 0) {
            lIlIlllIIlllI.buf.append("new String[] {");
            for (int lIlIlllIllIlI = 0; lIlIlllIllIlI < lIlIlllIlIIII.length; ++lIlIlllIllIlI) {
                lIlIlllIIlllI.buf.append(lIlIlllIllIlI == 0 ? " " : ", ");
                lIlIlllIIlllI.appendConstant(lIlIlllIlIIII[lIlIlllIllIlI]);
            }
            lIlIlllIIlllI.buf.append(" }");
        } else {
            lIlIlllIIlllI.buf.append("null");
        }
        lIlIlllIIlllI.buf.append(");\n");
        lIlIlllIIlllI.text.add(lIlIlllIIlllI.buf.toString());
        ASMifier lIlIlllIIllll = lIlIlllIIlllI.createASMifier("mv", 0);
        lIlIlllIIlllI.text.add(lIlIlllIIllll.getText());
        lIlIlllIIlllI.text.add("}\n");
        return lIlIlllIIllll;
    }

    public void visitIincInsn(int lIIlllIlIIIII, int lIIlllIIlllII) {
        ASMifier lIIlllIIllllI;
        lIIlllIIllllI.buf.setLength(0);
        lIIlllIIllllI.buf.append(lIIlllIIllllI.name).append(".visitIincInsn(").append(lIIlllIlIIIII).append(", ").append(lIIlllIIlllII).append(");\n");
        lIIlllIIllllI.text.add(lIIlllIIllllI.buf.toString());
    }

    public ASMifier visitFieldTypeAnnotation(int lIlIlIlIIIIll, TypePath lIlIlIlIIIIIl, String lIlIlIIllIlIl, boolean lIlIlIIllIIll) {
        ASMifier lIlIlIIlllIll;
        return lIlIlIIlllIll.visitTypeAnnotation(lIlIlIlIIIIll, lIlIlIlIIIIIl, lIlIlIIllIlIl, lIlIlIIllIIll);
    }

    protected void appendLabel(Label lIIlIIlIlllII) {
        ASMifier lIIlIIlIlllIl;
        lIIlIIlIlllIl.buf.append(lIIlIIlIlllIl.labelNames.get(lIIlIIlIlllII));
    }

    public ASMifier visitFieldAnnotation(String lIlIlIlIlIIIl, boolean lIlIlIlIlIIII) {
        ASMifier lIlIlIlIlIlIl;
        return lIlIlIlIlIlIl.visitAnnotation(lIlIlIlIlIIIl, lIlIlIlIlIIII);
    }

    public void visitAnnotationEnd() {
        ASMifier lIlIlIllIIIlI;
        lIlIlIllIIIlI.buf.setLength(0);
        lIlIlIllIIIlI.buf.append("av").append(lIlIlIllIIIlI.id).append(".visitEnd();\n");
        lIlIlIllIIIlI.text.add(lIlIlIllIIIlI.buf.toString());
    }

    protected void declareLabel(Label lIIlIIllIIllI) {
        String lIIlIIllIIlIl;
        ASMifier lIIlIIllIIlll;
        if (lIIlIIllIIlll.labelNames == null) {
            lIIlIIllIIlll.labelNames = new HashMap<Label, String>();
        }
        if ((lIIlIIllIIlIl = lIIlIIllIIlll.labelNames.get(lIIlIIllIIllI)) == null) {
            lIIlIIllIIlIl = String.valueOf(new StringBuilder().append("l").append(lIIlIIllIIlll.labelNames.size()));
            lIIlIIllIIlll.labelNames.put(lIIlIIllIIllI, lIIlIIllIIlIl);
            lIIlIIllIIlll.buf.append("Label ").append(lIIlIIllIIlIl).append(" = new Label();\n");
        }
    }

    void appendAccess(int lIIlIlIlIlIIl) {
        ASMifier lIIlIlIlIlIlI;
        boolean lIIlIlIlIlIII = true;
        if ((lIIlIlIlIlIIl & 1) != 0) {
            lIIlIlIlIlIlI.buf.append("ACC_PUBLIC");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 2) != 0) {
            lIIlIlIlIlIlI.buf.append("ACC_PRIVATE");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 4) != 0) {
            lIIlIlIlIlIlI.buf.append("ACC_PROTECTED");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x10) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_FINAL");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 8) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_STATIC");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x20) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            if ((lIIlIlIlIlIIl & 0x40000) == 0) {
                lIIlIlIlIlIlI.buf.append("ACC_SYNCHRONIZED");
            } else {
                lIIlIlIlIlIlI.buf.append("ACC_SUPER");
            }
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x40) != 0 && (lIIlIlIlIlIIl & 0x80000) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_VOLATILE");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x40) != 0 && (lIIlIlIlIlIIl & 0x40000) == 0 && (lIIlIlIlIlIIl & 0x80000) == 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_BRIDGE");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x80) != 0 && (lIIlIlIlIlIIl & 0x40000) == 0 && (lIIlIlIlIlIIl & 0x80000) == 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_VARARGS");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x80) != 0 && (lIIlIlIlIlIIl & 0x80000) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_TRANSIENT");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x100) != 0 && (lIIlIlIlIlIIl & 0x40000) == 0 && (lIIlIlIlIlIIl & 0x80000) == 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_NATIVE");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x4000) != 0 && ((lIIlIlIlIlIIl & 0x40000) != 0 || (lIIlIlIlIlIIl & 0x80000) != 0 || (lIIlIlIlIlIIl & 0x100000) != 0)) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_ENUM");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x2000) != 0 && ((lIIlIlIlIlIIl & 0x40000) != 0 || (lIIlIlIlIlIIl & 0x100000) != 0)) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_ANNOTATION");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x400) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_ABSTRACT");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x200) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_INTERFACE");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x800) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_STRICT");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x1000) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_SYNTHETIC");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x20000) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_DEPRECATED");
            lIIlIlIlIlIII = false;
        }
        if ((lIIlIlIlIlIIl & 0x8000) != 0) {
            if (!lIIlIlIlIlIII) {
                lIIlIlIlIlIlI.buf.append(" + ");
            }
            lIIlIlIlIlIlI.buf.append("ACC_MANDATED");
            lIIlIlIlIlIII = false;
        }
        if (lIIlIlIlIlIII) {
            lIIlIlIlIlIlI.buf.append('0');
        }
    }

    public void visitOuterClass(String lIllIlIIIlllI, String lIllIlIIIllIl, String lIllIlIIIlIll) {
        ASMifier lIllIlIIIllll;
        lIllIlIIIllll.buf.setLength(0);
        lIllIlIIIllll.buf.append("cw.visitOuterClass(");
        lIllIlIIIllll.appendConstant(lIllIlIIIlllI);
        lIllIlIIIllll.buf.append(", ");
        lIllIlIIIllll.appendConstant(lIllIlIIIllIl);
        lIllIlIIIllll.buf.append(", ");
        lIllIlIIIllll.appendConstant(lIllIlIIIlIll);
        lIllIlIIIllll.buf.append(");\n\n");
        lIllIlIIIllll.text.add(lIllIlIIIllll.buf.toString());
    }

    public void visitIntInsn(int lIlIIlIIIllll, int lIlIIlIIlIIIl) {
        ASMifier lIlIIlIIlIIII;
        lIlIIlIIlIIII.buf.setLength(0);
        lIlIIlIIlIIII.buf.append(lIlIIlIIlIIII.name).append(".visitIntInsn(").append(OPCODES[lIlIIlIIIllll]).append(", ").append(lIlIIlIIIllll == 188 ? TYPES[lIlIIlIIlIIIl] : Integer.toString(lIlIIlIIlIIIl)).append(");\n");
        lIlIIlIIlIIII.text.add(lIlIIlIIlIIII.buf.toString());
    }

    public ASMifier visitTryCatchAnnotation(int lIIllIIllIllI, TypePath lIIllIIlllIlI, String lIIllIIlllIIl, boolean lIIllIIllIIll) {
        ASMifier lIIllIIllllII;
        return lIIllIIllllII.visitTypeAnnotation("visitTryCatchAnnotation", lIIllIIllIllI, lIIllIIlllIlI, lIIllIIlllIIl, lIIllIIllIIll);
    }

    public void visitAttribute(Attribute lIIlIlIllIlIl) {
        ASMifier lIIlIlIlllIII;
        lIIlIlIlllIII.buf.setLength(0);
        lIIlIlIlllIII.buf.append("// ATTRIBUTE ").append(lIIlIlIllIlIl.type).append('\n');
        if (lIIlIlIllIlIl instanceof ASMifiable) {
            if (lIIlIlIlllIII.labelNames == null) {
                lIIlIlIlllIII.labelNames = new HashMap<Label, String>();
            }
            lIIlIlIlllIII.buf.append("{\n");
            ((ASMifiable)((Object)lIIlIlIllIlIl)).asmify(lIIlIlIlllIII.buf, "attr", lIIlIlIlllIII.labelNames);
            lIIlIlIlllIII.buf.append(lIIlIlIlllIII.name).append(".visitAttribute(attr);\n");
            lIIlIlIlllIII.buf.append("}\n");
        }
        lIIlIlIlllIII.text.add(lIIlIlIlllIII.buf.toString());
    }

    public void visitClassEnd() {
        ASMifier lIlIlllIIIlIl;
        lIlIlllIIIlIl.text.add("cw.visitEnd();\n\n");
        lIlIlllIIIlIl.text.add("return cw.toByteArray();\n");
        lIlIlllIIIlIl.text.add("}\n");
        lIlIlllIIIlIl.text.add("}\n");
    }

    public void visitLdcInsn(Object lIIlllIlIllIl) {
        ASMifier lIIlllIlIllII;
        lIIlllIlIllII.buf.setLength(0);
        lIIlllIlIllII.buf.append(lIIlllIlIllII.name).append(".visitLdcInsn(");
        lIIlllIlIllII.appendConstant(lIIlllIlIllIl);
        lIIlllIlIllII.buf.append(");\n");
        lIIlllIlIllII.text.add(lIIlllIlIllII.buf.toString());
    }

    public void visitTypeInsn(int lIlIIlIIIIIII, String lIlIIIlllllll) {
        ASMifier lIlIIlIIIIIIl;
        lIlIIlIIIIIIl.buf.setLength(0);
        lIlIIlIIIIIIl.buf.append(lIlIIlIIIIIIl.name).append(".visitTypeInsn(").append(OPCODES[lIlIIlIIIIIII]).append(", ");
        lIlIIlIIIIIIl.appendConstant(lIlIIIlllllll);
        lIlIIlIIIIIIl.buf.append(");\n");
        lIlIIlIIIIIIl.text.add(lIlIIlIIIIIIl.buf.toString());
    }

    public ASMifier visitParameterAnnotation(int lIlIIllIlIlll, String lIlIIllIlIIIl, boolean lIlIIllIlIIII) {
        ASMifier lIlIIllIlIIll;
        lIlIIllIlIIll.buf.setLength(0);
        lIlIIllIlIIll.buf.append("{\n").append("av0 = ").append(lIlIIllIlIIll.name).append(".visitParameterAnnotation(").append(lIlIIllIlIlll).append(", ");
        lIlIIllIlIIll.appendConstant(lIlIIllIlIIIl);
        lIlIIllIlIIll.buf.append(", ").append(lIlIIllIlIIII).append(");\n");
        lIlIIllIlIIll.text.add(lIlIIllIlIIll.buf.toString());
        ASMifier lIlIIllIlIlII = lIlIIllIlIIll.createASMifier("av", 0);
        lIlIIllIlIIll.text.add(lIlIIllIlIlII.getText());
        lIlIIllIlIIll.text.add("}\n");
        return lIlIIllIlIlII;
    }

    static {
        ACCESS_INNER = 0x100000;
        ACCESS_CLASS = 262144;
        ACCESS_FIELD = 524288;
    }

    public void visitVarInsn(int lIlIIlIIIIllI, int lIlIIlIIIlIII) {
        ASMifier lIlIIlIIIIlll;
        lIlIIlIIIIlll.buf.setLength(0);
        lIlIIlIIIIlll.buf.append(lIlIIlIIIIlll.name).append(".visitVarInsn(").append(OPCODES[lIlIIlIIIIllI]).append(", ").append(lIlIIlIIIlIII).append(");\n");
        lIlIIlIIIIlll.text.add(lIlIIlIIIIlll.buf.toString());
    }

    public void visit(int lIllIlIllIlII, int lIllIlIllIIll, String lIllIlIllIIlI, String lIllIlIlllIlI, String lIllIlIlllIIl, String[] lIllIlIlllIII) {
        String lIllIlIllIlll;
        ASMifier lIllIlIlllllI;
        int lIllIlIllIllI = lIllIlIllIIlI.lastIndexOf(47);
        if (lIllIlIllIllI == -1) {
            String lIllIllIIIIII = lIllIlIllIIlI;
        } else {
            lIllIlIlllllI.text.add(String.valueOf(new StringBuilder().append("package asm.").append(lIllIlIllIIlI.substring(0, lIllIlIllIllI).replace('/', '.')).append(";\n")));
            lIllIlIllIlll = lIllIlIllIIlI.substring(lIllIlIllIllI + 1);
        }
        lIllIlIlllllI.text.add("import java.util.*;\n");
        lIllIlIlllllI.text.add("import org.objectweb.asm.*;\n");
        lIllIlIlllllI.text.add(String.valueOf(new StringBuilder().append("public class ").append(lIllIlIllIlll).append("Dump implements Opcodes {\n\n")));
        lIllIlIlllllI.text.add("public static byte[] dump () throws Exception {\n\n");
        lIllIlIlllllI.text.add("ClassWriter cw = new ClassWriter(0);\n");
        lIllIlIlllllI.text.add("FieldVisitor fv;\n");
        lIllIlIlllllI.text.add("MethodVisitor mv;\n");
        lIllIlIlllllI.text.add("AnnotationVisitor av0;\n\n");
        lIllIlIlllllI.buf.setLength(0);
        lIllIlIlllllI.buf.append("cw.visit(");
        switch (lIllIlIllIlII) {
            case 196653: {
                lIllIlIlllllI.buf.append("V1_1");
                break;
            }
            case 46: {
                lIllIlIlllllI.buf.append("V1_2");
                break;
            }
            case 47: {
                lIllIlIlllllI.buf.append("V1_3");
                break;
            }
            case 48: {
                lIllIlIlllllI.buf.append("V1_4");
                break;
            }
            case 49: {
                lIllIlIlllllI.buf.append("V1_5");
                break;
            }
            case 50: {
                lIllIlIlllllI.buf.append("V1_6");
                break;
            }
            case 51: {
                lIllIlIlllllI.buf.append("V1_7");
                break;
            }
            default: {
                lIllIlIlllllI.buf.append(lIllIlIllIlII);
            }
        }
        lIllIlIlllllI.buf.append(", ");
        lIllIlIlllllI.appendAccess(lIllIlIllIIll | 0x40000);
        lIllIlIlllllI.buf.append(", ");
        lIllIlIlllllI.appendConstant(lIllIlIllIIlI);
        lIllIlIlllllI.buf.append(", ");
        lIllIlIlllllI.appendConstant(lIllIlIlllIlI);
        lIllIlIlllllI.buf.append(", ");
        lIllIlIlllllI.appendConstant(lIllIlIlllIIl);
        lIllIlIlllllI.buf.append(", ");
        if (lIllIlIlllIII != null && lIllIlIlllIII.length > 0) {
            lIllIlIlllllI.buf.append("new String[] {");
            for (int lIllIlIllllll = 0; lIllIlIllllll < lIllIlIlllIII.length; ++lIllIlIllllll) {
                lIllIlIlllllI.buf.append(lIllIlIllllll == 0 ? " " : ", ");
                lIllIlIlllllI.appendConstant(lIllIlIlllIII[lIllIlIllllll]);
            }
            lIllIlIlllllI.buf.append(" }");
        } else {
            lIllIlIlllllI.buf.append("null");
        }
        lIllIlIlllllI.buf.append(");\n\n");
        lIllIlIlllllI.text.add(lIllIlIlllllI.buf.toString());
    }

    public void visitCode() {
        ASMifier lIlIIlIlllIlI;
        lIlIIlIlllIlI.text.add(String.valueOf(new StringBuilder().append(lIlIIlIlllIlI.name).append(".visitCode();\n")));
    }

    public void visitLookupSwitchInsn(Label lIIllIlllIIII, int[] lIIllIllIllll, Label[] lIIllIllIlIlI) {
        ASMifier lIIllIlllIIIl;
        lIIllIlllIIIl.buf.setLength(0);
        for (int lIIllIlllIlII = 0; lIIllIlllIlII < lIIllIllIlIlI.length; ++lIIllIlllIlII) {
            lIIllIlllIIIl.declareLabel(lIIllIllIlIlI[lIIllIlllIlII]);
        }
        lIIllIlllIIIl.declareLabel(lIIllIlllIIII);
        lIIllIlllIIIl.buf.append(lIIllIlllIIIl.name).append(".visitLookupSwitchInsn(");
        lIIllIlllIIIl.appendLabel(lIIllIlllIIII);
        lIIllIlllIIIl.buf.append(", new int[] {");
        for (int lIIllIlllIIll = 0; lIIllIlllIIll < lIIllIllIllll.length; ++lIIllIlllIIll) {
            lIIllIlllIIIl.buf.append(lIIllIlllIIll == 0 ? " " : ", ").append(lIIllIllIllll[lIIllIlllIIll]);
        }
        lIIllIlllIIIl.buf.append(" }, new Label[] {");
        for (int lIIllIlllIIlI = 0; lIIllIlllIIlI < lIIllIllIlIlI.length; ++lIIllIlllIIlI) {
            lIIllIlllIIIl.buf.append(lIIllIlllIIlI == 0 ? " " : ", ");
            lIIllIlllIIIl.appendLabel(lIIllIllIlIlI[lIIllIlllIIlI]);
        }
        lIIllIlllIIIl.buf.append(" });\n");
        lIIllIlllIIIl.text.add(lIIllIlllIIIl.buf.toString());
    }

    public ASMifier visitInsnAnnotation(int lIIllIlIllIIl, TypePath lIIllIlIlIIll, String lIIllIlIlIIlI, boolean lIIllIlIlIllI) {
        ASMifier lIIllIlIllIlI;
        return lIIllIlIllIlI.visitTypeAnnotation("visitInsnAnnotation", lIIllIlIllIIl, lIIllIlIlIIll, lIIllIlIlIIlI, lIIllIlIlIllI);
    }

    public void visitLabel(Label lIIlllIlllIIl) {
        ASMifier lIIlllIllllIl;
        lIIlllIllllIl.buf.setLength(0);
        lIIlllIllllIl.declareLabel(lIIlllIlllIIl);
        lIIlllIllllIl.buf.append(lIIlllIllllIl.name).append(".visitLabel(");
        lIIlllIllllIl.appendLabel(lIIlllIlllIIl);
        lIIlllIllllIl.buf.append(");\n");
        lIIlllIllllIl.text.add(lIIlllIllllIl.buf.toString());
    }

    public void visitJumpInsn(int lIIllllIIllIl, Label lIIllllIIllII) {
        ASMifier lIIllllIlIIIl;
        lIIllllIlIIIl.buf.setLength(0);
        lIIllllIlIIIl.declareLabel(lIIllllIIllII);
        lIIllllIlIIIl.buf.append(lIIllllIlIIIl.name).append(".visitJumpInsn(").append(OPCODES[lIIllllIIllIl]).append(", ");
        lIIllllIlIIIl.appendLabel(lIIllllIIllII);
        lIIllllIlIIIl.buf.append(");\n");
        lIIllllIlIIIl.text.add(lIIllllIlIIIl.buf.toString());
    }

    public ASMifier visitField(int lIlIlllllIlII, String lIlIlllllIIll, String lIlIllllllIlI, String lIlIllllllIIl, Object lIlIlllllIIII) {
        ASMifier lIlIlllllIlIl;
        lIlIlllllIlIl.buf.setLength(0);
        lIlIlllllIlIl.buf.append("{\n");
        lIlIlllllIlIl.buf.append("fv = cw.visitField(");
        lIlIlllllIlIl.appendAccess(lIlIlllllIlII | 0x80000);
        lIlIlllllIlIl.buf.append(", ");
        lIlIlllllIlIl.appendConstant(lIlIlllllIIll);
        lIlIlllllIlIl.buf.append(", ");
        lIlIlllllIlIl.appendConstant(lIlIllllllIlI);
        lIlIlllllIlIl.buf.append(", ");
        lIlIlllllIlIl.appendConstant(lIlIllllllIIl);
        lIlIlllllIlIl.buf.append(", ");
        lIlIlllllIlIl.appendConstant(lIlIlllllIIII);
        lIlIlllllIlIl.buf.append(");\n");
        lIlIlllllIlIl.text.add(lIlIlllllIlIl.buf.toString());
        ASMifier lIlIlllllIllI = lIlIlllllIlIl.createASMifier("fv", 0);
        lIlIlllllIlIl.text.add(lIlIlllllIllI.getText());
        lIlIlllllIlIl.text.add("}\n");
        return lIlIlllllIllI;
    }

    public ASMifier visitClassTypeAnnotation(int lIllIIlIlllll, TypePath lIllIIllIIIll, String lIllIIllIIIlI, boolean lIllIIllIIIIl) {
        ASMifier lIllIIllIIlIl;
        return lIllIIllIIlIl.visitTypeAnnotation(lIllIIlIlllll, lIllIIllIIIll, lIllIIllIIIlI, lIllIIllIIIIl);
    }

    protected ASMifier createASMifier(String lIIlIlIlIllll, int lIIlIlIlIlllI) {
        return new ASMifier(327680, lIIlIlIlIllll, lIIlIlIlIlllI);
    }

    public void visitEnum(String lIlIllIlIlIll, String lIlIllIlIlIlI, String lIlIllIlIlIII) {
        ASMifier lIlIllIlIllIl;
        lIlIllIlIllIl.buf.setLength(0);
        lIlIllIlIllIl.buf.append("av").append(lIlIllIlIllIl.id).append(".visitEnum(");
        ASMifier.appendConstant(lIlIllIlIllIl.buf, lIlIllIlIlIll);
        lIlIllIlIllIl.buf.append(", ");
        ASMifier.appendConstant(lIlIllIlIllIl.buf, lIlIllIlIlIlI);
        lIlIllIlIllIl.buf.append(", ");
        ASMifier.appendConstant(lIlIllIlIllIl.buf, lIlIllIlIlIII);
        lIlIllIlIllIl.buf.append(");\n");
        lIlIllIlIllIl.text.add(lIlIllIlIllIl.buf.toString());
    }

    public ASMifier() {
        lIlllIIllIlIl(327680, "cw", 0);
        ASMifier lIlllIIllIlIl;
        if (lIlllIIllIlIl.getClass() != ASMifier.class) {
            throw new IllegalStateException();
        }
    }

    private void declareFrameTypes(int lIIlIIlllllII, Object[] lIIlIIllllIII) {
        for (int lIIlIIllllllI = 0; lIIlIIllllllI < lIIlIIlllllII; ++lIIlIIllllllI) {
            ASMifier lIIlIIlllllIl;
            if (!(lIIlIIllllIII[lIIlIIllllllI] instanceof Label)) continue;
            lIIlIIlllllIl.declareLabel((Label)lIIlIIllllIII[lIIlIIllllllI]);
        }
    }

    static void appendConstant(StringBuffer lIIlIlIIIIllI, Object lIIlIlIIIIlIl) {
        if (lIIlIlIIIIlIl == null) {
            lIIlIlIIIIllI.append("null");
        } else if (lIIlIlIIIIlIl instanceof String) {
            ASMifier.appendString(lIIlIlIIIIllI, (String)lIIlIlIIIIlIl);
        } else if (lIIlIlIIIIlIl instanceof Type) {
            lIIlIlIIIIllI.append("Type.getType(\"");
            lIIlIlIIIIllI.append(((Type)lIIlIlIIIIlIl).getDescriptor());
            lIIlIlIIIIllI.append("\")");
        } else if (lIIlIlIIIIlIl instanceof Handle) {
            lIIlIlIIIIllI.append("new Handle(");
            Handle lIIlIlIIllIlI = (Handle)lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("Opcodes.").append(HANDLE_TAG[lIIlIlIIllIlI.getTag()]).append(", \"");
            lIIlIlIIIIllI.append(lIIlIlIIllIlI.getOwner()).append("\", \"");
            lIIlIlIIIIllI.append(lIIlIlIIllIlI.getName()).append("\", \"");
            lIIlIlIIIIllI.append(lIIlIlIIllIlI.getDesc()).append("\")");
        } else if (lIIlIlIIIIlIl instanceof Byte) {
            lIIlIlIIIIllI.append("new Byte((byte)").append(lIIlIlIIIIlIl).append(')');
        } else if (lIIlIlIIIIlIl instanceof Boolean) {
            lIIlIlIIIIllI.append((Boolean)lIIlIlIIIIlIl != false ? "Boolean.TRUE" : "Boolean.FALSE");
        } else if (lIIlIlIIIIlIl instanceof Short) {
            lIIlIlIIIIllI.append("new Short((short)").append(lIIlIlIIIIlIl).append(')');
        } else if (lIIlIlIIIIlIl instanceof Character) {
            char lIIlIlIIllIIl = ((Character)lIIlIlIIIIlIl).charValue();
            lIIlIlIIIIllI.append("new Character((char)").append((int)lIIlIlIIllIIl).append(')');
        } else if (lIIlIlIIIIlIl instanceof Integer) {
            lIIlIlIIIIllI.append("new Integer(").append(lIIlIlIIIIlIl).append(')');
        } else if (lIIlIlIIIIlIl instanceof Float) {
            lIIlIlIIIIllI.append("new Float(\"").append(lIIlIlIIIIlIl).append("\")");
        } else if (lIIlIlIIIIlIl instanceof Long) {
            lIIlIlIIIIllI.append("new Long(").append(lIIlIlIIIIlIl).append("L)");
        } else if (lIIlIlIIIIlIl instanceof Double) {
            lIIlIlIIIIllI.append("new Double(\"").append(lIIlIlIIIIlIl).append("\")");
        } else if (lIIlIlIIIIlIl instanceof byte[]) {
            byte[] lIIlIlIIlIlll = (byte[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new byte[] {");
            for (int lIIlIlIIllIII = 0; lIIlIlIIllIII < lIIlIlIIlIlll.length; ++lIIlIlIIllIII) {
                lIIlIlIIIIllI.append(lIIlIlIIllIII == 0 ? "" : ",").append(lIIlIlIIlIlll[lIIlIlIIllIII]);
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof boolean[]) {
            boolean[] lIIlIlIIlIlIl = (boolean[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new boolean[] {");
            for (int lIIlIlIIlIllI = 0; lIIlIlIIlIllI < lIIlIlIIlIlIl.length; ++lIIlIlIIlIllI) {
                lIIlIlIIIIllI.append(lIIlIlIIlIllI == 0 ? "" : ",").append(lIIlIlIIlIlIl[lIIlIlIIlIllI]);
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof short[]) {
            short[] lIIlIlIIlIIll = (short[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new short[] {");
            for (int lIIlIlIIlIlII = 0; lIIlIlIIlIlII < lIIlIlIIlIIll.length; ++lIIlIlIIlIlII) {
                lIIlIlIIIIllI.append(lIIlIlIIlIlII == 0 ? "" : ",").append("(short)").append(lIIlIlIIlIIll[lIIlIlIIlIlII]);
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof char[]) {
            char[] lIIlIlIIlIIIl = (char[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new char[] {");
            for (int lIIlIlIIlIIlI = 0; lIIlIlIIlIIlI < lIIlIlIIlIIIl.length; ++lIIlIlIIlIIlI) {
                lIIlIlIIIIllI.append(lIIlIlIIlIIlI == 0 ? "" : ",").append("(char)").append((int)lIIlIlIIlIIIl[lIIlIlIIlIIlI]);
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof int[]) {
            int[] lIIlIlIIIllll = (int[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new int[] {");
            for (int lIIlIlIIlIIII = 0; lIIlIlIIlIIII < lIIlIlIIIllll.length; ++lIIlIlIIlIIII) {
                lIIlIlIIIIllI.append(lIIlIlIIlIIII == 0 ? "" : ",").append(lIIlIlIIIllll[lIIlIlIIlIIII]);
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof long[]) {
            long[] lIIlIlIIIllIl = (long[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new long[] {");
            for (int lIIlIlIIIlllI = 0; lIIlIlIIIlllI < lIIlIlIIIllIl.length; ++lIIlIlIIIlllI) {
                lIIlIlIIIIllI.append(lIIlIlIIIlllI == 0 ? "" : ",").append(lIIlIlIIIllIl[lIIlIlIIIlllI]).append('L');
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof float[]) {
            float[] lIIlIlIIIlIll = (float[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new float[] {");
            for (int lIIlIlIIIllII = 0; lIIlIlIIIllII < lIIlIlIIIlIll.length; ++lIIlIlIIIllII) {
                lIIlIlIIIIllI.append(lIIlIlIIIllII == 0 ? "" : ",").append(lIIlIlIIIlIll[lIIlIlIIIllII]).append('f');
            }
            lIIlIlIIIIllI.append('}');
        } else if (lIIlIlIIIIlIl instanceof double[]) {
            double[] lIIlIlIIIlIIl = (double[])lIIlIlIIIIlIl;
            lIIlIlIIIIllI.append("new double[] {");
            for (int lIIlIlIIIlIlI = 0; lIIlIlIIIlIlI < lIIlIlIIIlIIl.length; ++lIIlIlIIIlIlI) {
                lIIlIlIIIIllI.append(lIIlIlIIIlIlI == 0 ? "" : ",").append(lIIlIlIIIlIIl[lIIlIlIIIlIlI]).append('d');
            }
            lIIlIlIIIIllI.append('}');
        }
    }

    public void visitLineNumber(int lIIlIlllllIll, Label lIIlIlllllIlI) {
        ASMifier lIIlIllllllII;
        lIIlIllllllII.buf.setLength(0);
        lIIlIllllllII.buf.append(lIIlIllllllII.name).append(".visitLineNumber(").append(lIIlIlllllIll).append(", ");
        lIIlIllllllII.appendLabel(lIIlIlllllIlI);
        lIIlIllllllII.buf.append(");\n");
        lIIlIllllllII.text.add(lIIlIllllllII.buf.toString());
    }

    public ASMifier visitTypeAnnotation(String lIIlIllIIIlll, int lIIlIlIllllll, TypePath lIIlIllIIIlIl, String lIIlIllIIIlII, boolean lIIlIllIIIIll) {
        ASMifier lIIlIllIIlIII;
        lIIlIllIIlIII.buf.setLength(0);
        lIIlIllIIlIII.buf.append("{\n").append("av0 = ").append(lIIlIllIIlIII.name).append(".").append(lIIlIllIIIlll).append("(");
        lIIlIllIIlIII.buf.append(lIIlIlIllllll);
        if (lIIlIllIIIlIl == null) {
            lIIlIllIIlIII.buf.append(", null, ");
        } else {
            lIIlIllIIlIII.buf.append(", TypePath.fromString(\"").append(lIIlIllIIIlIl).append("\"), ");
        }
        lIIlIllIIlIII.appendConstant(lIIlIllIIIlII);
        lIIlIllIIlIII.buf.append(", ").append(lIIlIllIIIIll).append(");\n");
        lIIlIllIIlIII.text.add(lIIlIllIIlIII.buf.toString());
        ASMifier lIIlIllIIIIlI = lIIlIllIIlIII.createASMifier("av", 0);
        lIIlIllIIlIII.text.add(lIIlIllIIIIlI.getText());
        lIIlIllIIlIII.text.add("}\n");
        return lIIlIllIIIIlI;
    }

    private void appendFrameTypes(int lIIlIIllIllIl, Object[] lIIlIIllIllII) {
        for (int lIIlIIlllIIlI = 0; lIIlIIlllIIlI < lIIlIIllIllIl; ++lIIlIIlllIIlI) {
            ASMifier lIIlIIllIlllI;
            if (lIIlIIlllIIlI > 0) {
                lIIlIIllIlllI.buf.append(", ");
            }
            if (lIIlIIllIllII[lIIlIIlllIIlI] instanceof String) {
                lIIlIIllIlllI.appendConstant(lIIlIIllIllII[lIIlIIlllIIlI]);
                continue;
            }
            if (lIIlIIllIllII[lIIlIIlllIIlI] instanceof Integer) {
                switch ((Integer)lIIlIIllIllII[lIIlIIlllIIlI]) {
                    case 0: {
                        lIIlIIllIlllI.buf.append("Opcodes.TOP");
                        break;
                    }
                    case 1: {
                        lIIlIIllIlllI.buf.append("Opcodes.INTEGER");
                        break;
                    }
                    case 2: {
                        lIIlIIllIlllI.buf.append("Opcodes.FLOAT");
                        break;
                    }
                    case 3: {
                        lIIlIIllIlllI.buf.append("Opcodes.DOUBLE");
                        break;
                    }
                    case 4: {
                        lIIlIIllIlllI.buf.append("Opcodes.LONG");
                        break;
                    }
                    case 5: {
                        lIIlIIllIlllI.buf.append("Opcodes.NULL");
                        break;
                    }
                    case 6: {
                        lIIlIIllIlllI.buf.append("Opcodes.UNINITIALIZED_THIS");
                    }
                }
                continue;
            }
            lIIlIIllIlllI.appendLabel((Label)lIIlIIllIllII[lIIlIIlllIIlI]);
        }
    }

    protected void appendConstant(Object lIIlIlIIlllll) {
        ASMifier lIIlIlIlIIIII;
        ASMifier.appendConstant(lIIlIlIlIIIII.buf, lIIlIlIIlllll);
    }

    public void visitFieldAttribute(Attribute lIlIlIIlIllll) {
        ASMifier lIlIlIIllIIII;
        lIlIlIIllIIII.visitAttribute(lIlIlIIlIllll);
    }

    public ASMifier visitClassAnnotation(String lIllIIllllIIl, boolean lIllIIllllIII) {
        ASMifier lIllIIlllllIl;
        return lIllIIlllllIl.visitAnnotation(lIllIIllllIIl, lIllIIllllIII);
    }

    public void visitMethodInsn(int lIlIIIIlllllI, String lIlIIIlIIIIll, String lIlIIIIllllII, String lIlIIIlIIIIIl, boolean lIlIIIlIIIIII) {
        ASMifier lIlIIIIllllll;
        if (lIlIIIIllllll.api < 327680) {
            super.visitMethodInsn(lIlIIIIlllllI, lIlIIIlIIIIll, lIlIIIIllllII, lIlIIIlIIIIIl, lIlIIIlIIIIII);
            return;
        }
        lIlIIIIllllll.doVisitMethodInsn(lIlIIIIlllllI, lIlIIIlIIIIll, lIlIIIIllllII, lIlIIIlIIIIIl, lIlIIIlIIIIII);
    }
}

