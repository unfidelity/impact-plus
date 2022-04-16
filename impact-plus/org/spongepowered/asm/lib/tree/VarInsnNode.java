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
public class VarInsnNode
extends AbstractInsnNode {
    public /* synthetic */ int var;

    @Override
    public int getType() {
        return 2;
    }

    public void setOpcode(int lllllIIIllIllII) {
        lllllIIIllIllll.opcode = lllllIIIllIllII;
    }

    public VarInsnNode(int lllllIIIlllIllI, int lllllIIIlllIlIl) {
        super(lllllIIIlllIllI);
        VarInsnNode lllllIIIlllIlll;
        lllllIIIlllIlll.var = lllllIIIlllIlIl;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> lllllIIIllIIIlI) {
        VarInsnNode lllllIIIllIIIll;
        return new VarInsnNode(lllllIIIllIIIll.opcode, lllllIIIllIIIll.var).cloneAnnotations(lllllIIIllIIIll);
    }

    @Override
    public void accept(MethodVisitor lllllIIIllIIlll) {
        VarInsnNode lllllIIIllIlIII;
        lllllIIIllIIlll.visitVarInsn(lllllIIIllIlIII.opcode, lllllIIIllIlIII.var);
        lllllIIIllIlIII.acceptAnnotations(lllllIIIllIIlll);
    }
}

