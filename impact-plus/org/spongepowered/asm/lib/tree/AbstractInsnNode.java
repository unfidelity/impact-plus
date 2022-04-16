/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractInsnNode {
    public static final /* synthetic */ int LINE;
    public static final /* synthetic */ int FRAME;
    public static final /* synthetic */ int LABEL;
    public static final /* synthetic */ int INVOKE_DYNAMIC_INSN;
    public static final /* synthetic */ int INT_INSN;
    /* synthetic */ int index;
    public static final /* synthetic */ int IINC_INSN;
    /* synthetic */ AbstractInsnNode prev;
    public static final /* synthetic */ int METHOD_INSN;
    public static final /* synthetic */ int FIELD_INSN;
    public static final /* synthetic */ int MULTIANEWARRAY_INSN;
    public static final /* synthetic */ int TABLESWITCH_INSN;
    public /* synthetic */ List<TypeAnnotationNode> invisibleTypeAnnotations;
    public static final /* synthetic */ int INSN;
    public static final /* synthetic */ int LOOKUPSWITCH_INSN;
    public static final /* synthetic */ int JUMP_INSN;
    public static final /* synthetic */ int VAR_INSN;
    /* synthetic */ AbstractInsnNode next;
    public /* synthetic */ List<TypeAnnotationNode> visibleTypeAnnotations;
    public static final /* synthetic */ int LDC_INSN;
    protected /* synthetic */ int opcode;
    public static final /* synthetic */ int TYPE_INSN;

    static LabelNode[] clone(List<LabelNode> lllllllllllllllIlllIIIIIlllIIlIl, Map<LabelNode, LabelNode> lllllllllllllllIlllIIIIIlllIIIll) {
        LabelNode[] lllllllllllllllIlllIIIIIlllIIIlI = new LabelNode[lllllllllllllllIlllIIIIIlllIIlIl.size()];
        for (int lllllllllllllllIlllIIIIIlllIIlll = 0; lllllllllllllllIlllIIIIIlllIIlll < lllllllllllllllIlllIIIIIlllIIIlI.length; ++lllllllllllllllIlllIIIIIlllIIlll) {
            lllllllllllllllIlllIIIIIlllIIIlI[lllllllllllllllIlllIIIIIlllIIlll] = lllllllllllllllIlllIIIIIlllIIIll.get(lllllllllllllllIlllIIIIIlllIIlIl.get(lllllllllllllllIlllIIIIIlllIIlll));
        }
        return lllllllllllllllIlllIIIIIlllIIIlI;
    }

    static LabelNode clone(LabelNode lllllllllllllllIlllIIIIIllllIlII, Map<LabelNode, LabelNode> lllllllllllllllIlllIIIIIllllIIIl) {
        return lllllllllllllllIlllIIIIIllllIIIl.get(lllllllllllllllIlllIIIIIllllIlII);
    }

    static {
        FIELD_INSN = 4;
        METHOD_INSN = 5;
        INSN = 0;
        LDC_INSN = 9;
        INT_INSN = 1;
        LABEL = 8;
        MULTIANEWARRAY_INSN = 13;
        VAR_INSN = 2;
        LINE = 15;
        INVOKE_DYNAMIC_INSN = 6;
        FRAME = 14;
        TYPE_INSN = 3;
        JUMP_INSN = 7;
        TABLESWITCH_INSN = 11;
        IINC_INSN = 10;
        LOOKUPSWITCH_INSN = 12;
    }

    public abstract int getType();

    public AbstractInsnNode getNext() {
        AbstractInsnNode lllllllllllllllIlllIIIIlIIIlIlll;
        return lllllllllllllllIlllIIIIlIIIlIlll.next;
    }

    public abstract AbstractInsnNode clone(Map<LabelNode, LabelNode> var1);

    public abstract void accept(MethodVisitor var1);

    protected final void acceptAnnotations(MethodVisitor lllllllllllllllIlllIIIIIllllllll) {
        AbstractInsnNode lllllllllllllllIlllIIIIIllllllII;
        int lllllllllllllllIlllIIIIIlllllllI = lllllllllllllllIlllIIIIIllllllII.visibleTypeAnnotations == null ? 0 : lllllllllllllllIlllIIIIIllllllII.visibleTypeAnnotations.size();
        for (int lllllllllllllllIlllIIIIlIIIIIllI = 0; lllllllllllllllIlllIIIIlIIIIIllI < lllllllllllllllIlllIIIIIlllllllI; ++lllllllllllllllIlllIIIIlIIIIIllI) {
            TypeAnnotationNode lllllllllllllllIlllIIIIlIIIIIlll = lllllllllllllllIlllIIIIIllllllII.visibleTypeAnnotations.get(lllllllllllllllIlllIIIIlIIIIIllI);
            lllllllllllllllIlllIIIIlIIIIIlll.accept(lllllllllllllllIlllIIIIIllllllll.visitInsnAnnotation(lllllllllllllllIlllIIIIlIIIIIlll.typeRef, lllllllllllllllIlllIIIIlIIIIIlll.typePath, lllllllllllllllIlllIIIIlIIIIIlll.desc, true));
        }
        lllllllllllllllIlllIIIIIlllllllI = lllllllllllllllIlllIIIIIllllllII.invisibleTypeAnnotations == null ? 0 : lllllllllllllllIlllIIIIIllllllII.invisibleTypeAnnotations.size();
        for (int lllllllllllllllIlllIIIIlIIIIIIll = 0; lllllllllllllllIlllIIIIlIIIIIIll < lllllllllllllllIlllIIIIIlllllllI; ++lllllllllllllllIlllIIIIlIIIIIIll) {
            TypeAnnotationNode lllllllllllllllIlllIIIIlIIIIIlII = lllllllllllllllIlllIIIIIllllllII.invisibleTypeAnnotations.get(lllllllllllllllIlllIIIIlIIIIIIll);
            lllllllllllllllIlllIIIIlIIIIIlII.accept(lllllllllllllllIlllIIIIIllllllll.visitInsnAnnotation(lllllllllllllllIlllIIIIlIIIIIlII.typeRef, lllllllllllllllIlllIIIIlIIIIIlII.typePath, lllllllllllllllIlllIIIIlIIIIIlII.desc, false));
        }
    }

    protected final AbstractInsnNode cloneAnnotations(AbstractInsnNode lllllllllllllllIlllIIIIIllIIIIlI) {
        AbstractInsnNode lllllllllllllllIlllIIIIIllIIIlll;
        if (lllllllllllllllIlllIIIIIllIIIIlI.visibleTypeAnnotations != null) {
            lllllllllllllllIlllIIIIIllIIIlll.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>();
            for (int lllllllllllllllIlllIIIIIllIIllII = 0; lllllllllllllllIlllIIIIIllIIllII < lllllllllllllllIlllIIIIIllIIIIlI.visibleTypeAnnotations.size(); ++lllllllllllllllIlllIIIIIllIIllII) {
                TypeAnnotationNode lllllllllllllllIlllIIIIIllIIlllI = lllllllllllllllIlllIIIIIllIIIIlI.visibleTypeAnnotations.get(lllllllllllllllIlllIIIIIllIIllII);
                TypeAnnotationNode lllllllllllllllIlllIIIIIllIIllIl = new TypeAnnotationNode(lllllllllllllllIlllIIIIIllIIlllI.typeRef, lllllllllllllllIlllIIIIIllIIlllI.typePath, lllllllllllllllIlllIIIIIllIIlllI.desc);
                lllllllllllllllIlllIIIIIllIIlllI.accept(lllllllllllllllIlllIIIIIllIIllIl);
                lllllllllllllllIlllIIIIIllIIIlll.visibleTypeAnnotations.add(lllllllllllllllIlllIIIIIllIIllIl);
            }
        }
        if (lllllllllllllllIlllIIIIIllIIIIlI.invisibleTypeAnnotations != null) {
            lllllllllllllllIlllIIIIIllIIIlll.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>();
            for (int lllllllllllllllIlllIIIIIllIIlIIl = 0; lllllllllllllllIlllIIIIIllIIlIIl < lllllllllllllllIlllIIIIIllIIIIlI.invisibleTypeAnnotations.size(); ++lllllllllllllllIlllIIIIIllIIlIIl) {
                TypeAnnotationNode lllllllllllllllIlllIIIIIllIIlIll = lllllllllllllllIlllIIIIIllIIIIlI.invisibleTypeAnnotations.get(lllllllllllllllIlllIIIIIllIIlIIl);
                TypeAnnotationNode lllllllllllllllIlllIIIIIllIIlIlI = new TypeAnnotationNode(lllllllllllllllIlllIIIIIllIIlIll.typeRef, lllllllllllllllIlllIIIIIllIIlIll.typePath, lllllllllllllllIlllIIIIIllIIlIll.desc);
                lllllllllllllllIlllIIIIIllIIlIll.accept(lllllllllllllllIlllIIIIIllIIlIlI);
                lllllllllllllllIlllIIIIIllIIIlll.invisibleTypeAnnotations.add(lllllllllllllllIlllIIIIIllIIlIlI);
            }
        }
        return lllllllllllllllIlllIIIIIllIIIlll;
    }

    public int getOpcode() {
        AbstractInsnNode lllllllllllllllIlllIIIIlIIlIIIIl;
        return lllllllllllllllIlllIIIIlIIlIIIIl.opcode;
    }

    public AbstractInsnNode getPrevious() {
        AbstractInsnNode lllllllllllllllIlllIIIIlIIIllIlI;
        return lllllllllllllllIlllIIIIlIIIllIlI.prev;
    }

    protected AbstractInsnNode(int lllllllllllllllIlllIIIIlIIlIIlIl) {
        AbstractInsnNode lllllllllllllllIlllIIIIlIIlIIllI;
        lllllllllllllllIlllIIIIlIIlIIllI.opcode = lllllllllllllllIlllIIIIlIIlIIlIl;
        lllllllllllllllIlllIIIIlIIlIIllI.index = -1;
    }
}

