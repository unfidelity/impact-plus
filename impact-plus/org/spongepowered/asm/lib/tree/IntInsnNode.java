/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.Map;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IntInsnNode
extends AbstractInsnNode {
    public /* synthetic */ int operand;

    public void setOpcode(int llllllllllllllllIllIIIllllIIllIl) {
        llllllllllllllllIllIIIllllIIlllI.opcode = llllllllllllllllIllIIIllllIIllIl;
    }

    public IntInsnNode(int llllllllllllllllIllIIIllllIlIlll, int llllllllllllllllIllIIIllllIlIllI) {
        super(llllllllllllllllIllIIIllllIlIlll);
        IntInsnNode llllllllllllllllIllIIIllllIlIlIl;
        llllllllllllllllIllIIIllllIlIlIl.operand = llllllllllllllllIllIIIllllIlIllI;
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllIllIIIllllIIlIII) {
        IntInsnNode llllllllllllllllIllIIIllllIIIlll;
        llllllllllllllllIllIIIllllIIlIII.visitIntInsn(llllllllllllllllIllIIIllllIIIlll.opcode, llllllllllllllllIllIIIllllIIIlll.operand);
        llllllllllllllllIllIIIllllIIIlll.acceptAnnotations(llllllllllllllllIllIIIllllIIlIII);
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllIllIIIllllIIIIlI) {
        IntInsnNode llllllllllllllllIllIIIllllIIIlII;
        return new IntInsnNode(llllllllllllllllIllIIIllllIIIlII.opcode, llllllllllllllllIllIIIllllIIIlII.operand).cloneAnnotations(llllllllllllllllIllIIIllllIIIlII);
    }
}

