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
public class LdcInsnNode
extends AbstractInsnNode {
    public /* synthetic */ Object cst;

    @Override
    public void accept(MethodVisitor llIlIIIIIlIlll) {
        LdcInsnNode llIlIIIIIllIII;
        llIlIIIIIlIlll.visitLdcInsn(llIlIIIIIllIII.cst);
        llIlIIIIIllIII.acceptAnnotations(llIlIIIIIlIlll);
    }

    @Override
    public int getType() {
        return 9;
    }

    public LdcInsnNode(Object llIlIIIIlIIIII) {
        super(18);
        LdcInsnNode llIlIIIIlIIIIl;
        llIlIIIIlIIIIl.cst = llIlIIIIlIIIII;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llIlIIIIIlIlII) {
        LdcInsnNode llIlIIIIIlIIll;
        return new LdcInsnNode(llIlIIIIIlIIll.cst).cloneAnnotations(llIlIIIIIlIIll);
    }
}

