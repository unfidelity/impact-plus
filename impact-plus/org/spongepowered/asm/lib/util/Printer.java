/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.TypePath;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class Printer {
    public static final /* synthetic */ String[] OPCODES;
    public final /* synthetic */ List<Object> text;
    protected final /* synthetic */ StringBuffer buf;
    protected final /* synthetic */ int api;
    public static final /* synthetic */ String[] TYPES;
    public static final /* synthetic */ String[] HANDLE_TAG;

    public abstract void visitVarInsn(int var1, int var2);

    public abstract Printer visitMethodAnnotation(String var1, boolean var2);

    public void print(PrintWriter lIIIllllllllIl) {
        Printer lIIIlllllllllI;
        Printer.printList(lIIIllllllllIl, lIIIlllllllllI.text);
    }

    public abstract void visitClassEnd();

    public abstract Printer visitField(int var1, String var2, String var3, String var4, Object var5);

    public abstract void visitLookupSwitchInsn(Label var1, int[] var2, Label[] var3);

    public abstract void visitOuterClass(String var1, String var2, String var3);

    public abstract void visitLineNumber(int var1, Label var2);

    @Deprecated
    public void visitMethodInsn(int lIIlIIIIllIIll, String lIIlIIIIlIllIl, String lIIlIIIIllIIIl, String lIIlIIIIllIIII) {
        Printer lIIlIIIIlIllll;
        if (lIIlIIIIlIllll.api >= 327680) {
            boolean lIIlIIIIllIlIl = lIIlIIIIllIIll == 185;
            lIIlIIIIlIllll.visitMethodInsn(lIIlIIIIllIIll, lIIlIIIIlIllIl, lIIlIIIIllIIIl, lIIlIIIIllIIII, lIIlIIIIllIlIl);
            return;
        }
        throw new RuntimeException("Must be overriden");
    }

    public static void appendString(StringBuffer lIIIllllllIllI, String lIIIllllllIIll) {
        lIIIllllllIllI.append('\"');
        for (int lIIIllllllIlll = 0; lIIIllllllIlll < lIIIllllllIIll.length(); ++lIIIllllllIlll) {
            char lIIIlllllllIII = lIIIllllllIIll.charAt(lIIIllllllIlll);
            if (lIIIlllllllIII == '\n') {
                lIIIllllllIllI.append("\\n");
                continue;
            }
            if (lIIIlllllllIII == '\r') {
                lIIIllllllIllI.append("\\r");
                continue;
            }
            if (lIIIlllllllIII == '\\') {
                lIIIllllllIllI.append("\\\\");
                continue;
            }
            if (lIIIlllllllIII == '\"') {
                lIIIllllllIllI.append("\\\"");
                continue;
            }
            if (lIIIlllllllIII < ' ' || lIIIlllllllIII > '\u007f') {
                lIIIllllllIllI.append("\\u");
                if (lIIIlllllllIII < '\u0010') {
                    lIIIllllllIllI.append("000");
                } else if (lIIIlllllllIII < '\u0100') {
                    lIIIllllllIllI.append("00");
                } else if (lIIIlllllllIII < '\u1000') {
                    lIIIllllllIllI.append('0');
                }
                lIIIllllllIllI.append(Integer.toString(lIIIlllllllIII, 16));
                continue;
            }
            lIIIllllllIllI.append(lIIIlllllllIII);
        }
        lIIIllllllIllI.append('\"');
    }

    public abstract void visitMethodAttribute(Attribute var1);

    public abstract Printer visitParameterAnnotation(int var1, String var2, boolean var3);

    public Printer visitInsnAnnotation(int lIIlIIIIIlIllI, TypePath lIIlIIIIIlIlIl, String lIIlIIIIIlIlII, boolean lIIlIIIIIlIIll) {
        throw new RuntimeException("Must be overriden");
    }

    public void visitMethodInsn(int lIIlIIIIIlllII, String lIIlIIIIlIIIIl, String lIIlIIIIIllIlI, String lIIlIIIIIlllll, boolean lIIlIIIIIllllI) {
        Printer lIIlIIIIIlllIl;
        if (lIIlIIIIIlllIl.api < 327680) {
            if (lIIlIIIIIllllI != (lIIlIIIIIlllII == 185)) {
                throw new IllegalArgumentException("INVOKESPECIAL/STATIC on interfaces require ASM 5");
            }
            lIIlIIIIIlllIl.visitMethodInsn(lIIlIIIIIlllII, lIIlIIIIlIIIIl, lIIlIIIIIllIlI, lIIlIIIIIlllll);
            return;
        }
        throw new RuntimeException("Must be overriden");
    }

    public abstract void visitSource(String var1, String var2);

    public abstract void visitLocalVariable(String var1, String var2, String var3, Label var4, Label var5, int var6);

    public abstract void visitTryCatchBlock(Label var1, Label var2, Label var3, String var4);

    public abstract Printer visitAnnotationDefault();

    public Printer visitMethodTypeAnnotation(int lIIlIIIIllllll, TypePath lIIlIIIIlllllI, String lIIlIIIIllllIl, boolean lIIlIIIIllllII) {
        throw new RuntimeException("Must be overriden");
    }

    public abstract void visitFieldAttribute(Attribute var1);

    public abstract Printer visitMethod(int var1, String var2, String var3, String var4, String[] var5);

    static void printList(PrintWriter lIIIlllllIlIlI, List<?> lIIIlllllIIlll) {
        for (int lIIIlllllIlIll = 0; lIIIlllllIlIll < lIIIlllllIIlll.size(); ++lIIIlllllIlIll) {
            Object lIIIlllllIllII = lIIIlllllIIlll.get(lIIIlllllIlIll);
            if (lIIIlllllIllII instanceof List) {
                Printer.printList(lIIIlllllIlIlI, (List)lIIIlllllIllII);
                continue;
            }
            lIIIlllllIlIlI.print(lIIIlllllIllII.toString());
        }
    }

    public abstract Printer visitClassAnnotation(String var1, boolean var2);

    public Printer visitLocalVariableAnnotation(int lIIlIIIIIIllII, TypePath lIIlIIIIIIlIll, Label[] lIIlIIIIIIlIlI, Label[] lIIlIIIIIIlIIl, int[] lIIlIIIIIIlIII, String lIIlIIIIIIIlll, boolean lIIlIIIIIIIllI) {
        throw new RuntimeException("Must be overriden");
    }

    public abstract Printer visitAnnotation(String var1, String var2);

    public abstract Printer visitFieldAnnotation(String var1, boolean var2);

    public abstract void visit(int var1, int var2, String var3, String var4, String var5, String[] var6);

    public Printer visitFieldTypeAnnotation(int lIIlIIIlIIIlll, TypePath lIIlIIIlIIIllI, String lIIlIIIlIIIlIl, boolean lIIlIIIlIIIlII) {
        throw new RuntimeException("Must be overriden");
    }

    public abstract void visitCode();

    public abstract void visitTypeInsn(int var1, String var2);

    protected Printer(int lIIlIIIlIlIIII) {
        Printer lIIlIIIlIlIIIl;
        lIIlIIIlIlIIIl.api = lIIlIIIlIlIIII;
        lIIlIIIlIlIIIl.buf = new StringBuffer();
        lIIlIIIlIlIIIl.text = new ArrayList<Object>();
    }

    public List<Object> getText() {
        Printer lIIlIIIIIIIIll;
        return lIIlIIIIIIIIll.text;
    }

    public Printer visitTryCatchAnnotation(int lIIlIIIIIlIIIl, TypePath lIIlIIIIIlIIII, String lIIlIIIIIIllll, boolean lIIlIIIIIIlllI) {
        throw new RuntimeException("Must be overriden");
    }

    public abstract void visitLabel(Label var1);

    public void visitParameter(String lIIlIIIlIIIIlI, int lIIlIIIlIIIIIl) {
        throw new RuntimeException("Must be overriden");
    }

    public abstract void visitIntInsn(int var1, int var2);

    public abstract void visitLdcInsn(Object var1);

    public abstract void visitIincInsn(int var1, int var2);

    public abstract void visitFieldInsn(int var1, String var2, String var3, String var4);

    public abstract void visitJumpInsn(int var1, Label var2);

    public abstract void visitMaxs(int var1, int var2);

    public abstract void visitInnerClass(String var1, String var2, String var3, int var4);

    public Printer visitClassTypeAnnotation(int lIIlIIIlIIllII, TypePath lIIlIIIlIIlIll, String lIIlIIIlIIlIlI, boolean lIIlIIIlIIlIIl) {
        throw new RuntimeException("Must be overriden");
    }

    public abstract void visitFrame(int var1, int var2, Object[] var3, int var4, Object[] var5);

    public abstract void visitAnnotationEnd();

    public abstract void visitEnum(String var1, String var2, String var3);

    public abstract Printer visitArray(String var1);

    public abstract void visitFieldEnd();

    public abstract void visitClassAttribute(Attribute var1);

    public abstract void visitInsn(int var1);

    public abstract void visit(String var1, Object var2);

    static {
        int lIIIllllIlllIl;
        String lIIIlllllIIIII = "NOP,ACONST_NULL,ICONST_M1,ICONST_0,ICONST_1,ICONST_2,ICONST_3,ICONST_4,ICONST_5,LCONST_0,LCONST_1,FCONST_0,FCONST_1,FCONST_2,DCONST_0,DCONST_1,BIPUSH,SIPUSH,LDC,,,ILOAD,LLOAD,FLOAD,DLOAD,ALOAD,,,,,,,,,,,,,,,,,,,,,IALOAD,LALOAD,FALOAD,DALOAD,AALOAD,BALOAD,CALOAD,SALOAD,ISTORE,LSTORE,FSTORE,DSTORE,ASTORE,,,,,,,,,,,,,,,,,,,,,IASTORE,LASTORE,FASTORE,DASTORE,AASTORE,BASTORE,CASTORE,SASTORE,POP,POP2,DUP,DUP_X1,DUP_X2,DUP2,DUP2_X1,DUP2_X2,SWAP,IADD,LADD,FADD,DADD,ISUB,LSUB,FSUB,DSUB,IMUL,LMUL,FMUL,DMUL,IDIV,LDIV,FDIV,DDIV,IREM,LREM,FREM,DREM,INEG,LNEG,FNEG,DNEG,ISHL,LSHL,ISHR,LSHR,IUSHR,LUSHR,IAND,LAND,IOR,LOR,IXOR,LXOR,IINC,I2L,I2F,I2D,L2I,L2F,L2D,F2I,F2L,F2D,D2I,D2L,D2F,I2B,I2C,I2S,LCMP,FCMPL,FCMPG,DCMPL,DCMPG,IFEQ,IFNE,IFLT,IFGE,IFGT,IFLE,IF_ICMPEQ,IF_ICMPNE,IF_ICMPLT,IF_ICMPGE,IF_ICMPGT,IF_ICMPLE,IF_ACMPEQ,IF_ACMPNE,GOTO,JSR,RET,TABLESWITCH,LOOKUPSWITCH,IRETURN,LRETURN,FRETURN,DRETURN,ARETURN,RETURN,GETSTATIC,PUTSTATIC,GETFIELD,PUTFIELD,INVOKEVIRTUAL,INVOKESPECIAL,INVOKESTATIC,INVOKEINTERFACE,INVOKEDYNAMIC,NEW,NEWARRAY,ANEWARRAY,ARRAYLENGTH,ATHROW,CHECKCAST,INSTANCEOF,MONITORENTER,MONITOREXIT,,MULTIANEWARRAY,IFNULL,IFNONNULL,";
        OPCODES = new String[200];
        int lIIIllllIlllll = 0;
        int lIIIllllIllllI = 0;
        while ((lIIIllllIlllIl = lIIIlllllIIIII.indexOf(44, lIIIllllIllllI)) > 0) {
            Printer.OPCODES[lIIIllllIlllll++] = lIIIllllIllllI + 1 == lIIIllllIlllIl ? null : lIIIlllllIIIII.substring(lIIIllllIllllI, lIIIllllIlllIl);
            lIIIllllIllllI = lIIIllllIlllIl + 1;
        }
        lIIIlllllIIIII = "T_BOOLEAN,T_CHAR,T_FLOAT,T_DOUBLE,T_BYTE,T_SHORT,T_INT,T_LONG,";
        TYPES = new String[12];
        lIIIllllIllllI = 0;
        lIIIllllIlllll = 4;
        while ((lIIIllllIlllIl = lIIIlllllIIIII.indexOf(44, lIIIllllIllllI)) > 0) {
            Printer.TYPES[lIIIllllIlllll++] = lIIIlllllIIIII.substring(lIIIllllIllllI, lIIIllllIlllIl);
            lIIIllllIllllI = lIIIllllIlllIl + 1;
        }
        lIIIlllllIIIII = "H_GETFIELD,H_GETSTATIC,H_PUTFIELD,H_PUTSTATIC,H_INVOKEVIRTUAL,H_INVOKESTATIC,H_INVOKESPECIAL,H_NEWINVOKESPECIAL,H_INVOKEINTERFACE,";
        HANDLE_TAG = new String[10];
        lIIIllllIllllI = 0;
        lIIIllllIlllll = 1;
        while ((lIIIllllIlllIl = lIIIlllllIIIII.indexOf(44, lIIIllllIllllI)) > 0) {
            Printer.HANDLE_TAG[lIIIllllIlllll++] = lIIIlllllIIIII.substring(lIIIllllIllllI, lIIIllllIlllIl);
            lIIIllllIllllI = lIIIllllIlllIl + 1;
        }
    }

    public abstract void visitMultiANewArrayInsn(String var1, int var2);

    public abstract void visitTableSwitchInsn(int var1, int var2, Label var3, Label ... var4);

    public abstract void visitInvokeDynamicInsn(String var1, String var2, Handle var3, Object ... var4);

    public abstract void visitMethodEnd();
}

