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
public class IincInsnNode
extends AbstractInsnNode {
    public /* synthetic */ int incr;
    public /* synthetic */ int var;

    public IincInsnNode(int llllllllllllllllIIIlIllllIlIIlII, int llllllllllllllllIIIlIllllIlIIIlI) {
        super(132);
        IincInsnNode llllllllllllllllIIIlIllllIlIIllI;
        llllllllllllllllIIIlIllllIlIIllI.var = llllllllllllllllIIIlIllllIlIIlII;
        llllllllllllllllIIIlIllllIlIIllI.incr = llllllllllllllllIIIlIllllIlIIIlI;
    }

    @Override
    public int getType() {
        return 10;
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllIIIlIllllIIlIIlI) {
        IincInsnNode llllllllllllllllIIIlIllllIIlIIll;
        llllllllllllllllIIIlIllllIIlIIlI.visitIincInsn(llllllllllllllllIIIlIllllIIlIIll.var, llllllllllllllllIIIlIllllIIlIIll.incr);
        llllllllllllllllIIIlIllllIIlIIll.acceptAnnotations(llllllllllllllllIIIlIllllIIlIIlI);
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllIIIlIllllIIIlIIl) {
        IincInsnNode llllllllllllllllIIIlIllllIIIlIII;
        return new IincInsnNode(llllllllllllllllIIIlIllllIIIlIII.var, llllllllllllllllIIIlIllllIIIlIII.incr).cloneAnnotations(llllllllllllllllIIIlIllllIIIlIII);
    }
}

