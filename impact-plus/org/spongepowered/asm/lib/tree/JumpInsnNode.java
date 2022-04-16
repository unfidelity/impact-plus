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
public class JumpInsnNode
extends AbstractInsnNode {
    public /* synthetic */ LabelNode label;

    @Override
    public int getType() {
        return 7;
    }

    public JumpInsnNode(int llllllllllllllllllIIIllllIlIllIl, LabelNode llllllllllllllllllIIIllllIllIIIl) {
        super(llllllllllllllllllIIIllllIlIllIl);
        JumpInsnNode llllllllllllllllllIIIllllIlIllll;
        llllllllllllllllllIIIllllIlIllll.label = llllllllllllllllllIIIllllIllIIIl;
    }

    public void setOpcode(int llllllllllllllllllIIIllllIIlllIl) {
        llllllllllllllllllIIIllllIIllIll.opcode = llllllllllllllllllIIIllllIIlllIl;
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllllIIIllllIIIIlII) {
        JumpInsnNode llllllllllllllllllIIIllllIIIlIll;
        llllllllllllllllllIIIllllIIIIlII.visitJumpInsn(llllllllllllllllllIIIllllIIIlIll.opcode, llllllllllllllllllIIIllllIIIlIll.label.getLabel());
        llllllllllllllllllIIIllllIIIlIll.acceptAnnotations(llllllllllllllllllIIIllllIIIIlII);
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllllIIIlllIllIlIIl) {
        JumpInsnNode llllllllllllllllllIIIlllIllIllll;
        return new JumpInsnNode(llllllllllllllllllIIIlllIllIllll.opcode, JumpInsnNode.clone(llllllllllllllllllIIIlllIllIllll.label, llllllllllllllllllIIIlllIllIlIIl)).cloneAnnotations(llllllllllllllllllIIIlllIllIllll);
    }
}

