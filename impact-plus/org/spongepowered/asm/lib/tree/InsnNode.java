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
public class InsnNode
extends AbstractInsnNode {
    public InsnNode(int llllllllllllllllIlIlIlIllIlIIlll) {
        super(llllllllllllllllIlIlIlIllIlIIlll);
        InsnNode llllllllllllllllIlIlIlIllIlIlIlI;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllIlIlIlIllIIlllIl) {
        InsnNode llllllllllllllllIlIlIlIllIIllllI;
        return new InsnNode(llllllllllllllllIlIlIlIllIIllllI.opcode).cloneAnnotations(llllllllllllllllIlIlIlIllIIllllI);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllIlIlIlIllIlIIIlI) {
        InsnNode llllllllllllllllIlIlIlIllIlIIIll;
        llllllllllllllllIlIlIlIllIlIIIlI.visitInsn(llllllllllllllllIlIlIlIllIlIIIll.opcode);
        llllllllllllllllIlIlIlIllIlIIIll.acceptAnnotations(llllllllllllllllIlIlIlIllIlIIIlI);
    }
}

