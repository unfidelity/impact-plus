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
public class MultiANewArrayInsnNode
extends AbstractInsnNode {
    public /* synthetic */ String desc;
    public /* synthetic */ int dims;

    @Override
    public void accept(MethodVisitor llllIlIIIIIIlll) {
        MultiANewArrayInsnNode llllIlIIIIIlIII;
        llllIlIIIIIIlll.visitMultiANewArrayInsn(llllIlIIIIIlIII.desc, llllIlIIIIIlIII.dims);
        llllIlIIIIIlIII.acceptAnnotations(llllIlIIIIIIlll);
    }

    public MultiANewArrayInsnNode(String llllIlIIIIIllll, int llllIlIIIIIlllI) {
        super(197);
        MultiANewArrayInsnNode llllIlIIIIlIIll;
        llllIlIIIIlIIll.desc = llllIlIIIIIllll;
        llllIlIIIIlIIll.dims = llllIlIIIIIlllI;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllIlIIIIIIlII) {
        MultiANewArrayInsnNode llllIlIIIIIIIll;
        return new MultiANewArrayInsnNode(llllIlIIIIIIIll.desc, llllIlIIIIIIIll.dims).cloneAnnotations(llllIlIIIIIIIll);
    }

    @Override
    public int getType() {
        return 13;
    }
}

