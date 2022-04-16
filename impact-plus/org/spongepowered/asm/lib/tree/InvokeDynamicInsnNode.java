/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.Map;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class InvokeDynamicInsnNode
extends AbstractInsnNode {
    public /* synthetic */ String name;
    public /* synthetic */ String desc;
    public /* synthetic */ Object[] bsmArgs;
    public /* synthetic */ Handle bsm;

    public InvokeDynamicInsnNode(String llllllllllllllllllllIlIlIlIIIllI, String llllllllllllllllllllIlIlIlIIIlIl, Handle llllllllllllllllllllIlIlIlIIIlII, Object ... llllllllllllllllllllIlIlIIlllllI) {
        super(186);
        InvokeDynamicInsnNode llllllllllllllllllllIlIlIlIIIlll;
        llllllllllllllllllllIlIlIlIIIlll.name = llllllllllllllllllllIlIlIlIIIllI;
        llllllllllllllllllllIlIlIlIIIlll.desc = llllllllllllllllllllIlIlIlIIIlIl;
        llllllllllllllllllllIlIlIlIIIlll.bsm = llllllllllllllllllllIlIlIlIIIlII;
        llllllllllllllllllllIlIlIlIIIlll.bsmArgs = llllllllllllllllllllIlIlIIlllllI;
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllllllIlIlIIlllIIl) {
        InvokeDynamicInsnNode llllllllllllllllllllIlIlIIlllIlI;
        llllllllllllllllllllIlIlIIlllIIl.visitInvokeDynamicInsn(llllllllllllllllllllIlIlIIlllIlI.name, llllllllllllllllllllIlIlIIlllIlI.desc, llllllllllllllllllllIlIlIIlllIlI.bsm, llllllllllllllllllllIlIlIIlllIlI.bsmArgs);
        llllllllllllllllllllIlIlIIlllIlI.acceptAnnotations(llllllllllllllllllllIlIlIIlllIIl);
    }

    @Override
    public int getType() {
        return 6;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllllllIlIlIIllIlII) {
        InvokeDynamicInsnNode llllllllllllllllllllIlIlIIllIIll;
        return new InvokeDynamicInsnNode(llllllllllllllllllllIlIlIIllIIll.name, llllllllllllllllllllIlIlIIllIIll.desc, llllllllllllllllllllIlIlIIllIIll.bsm, llllllllllllllllllllIlIlIIllIIll.bsmArgs).cloneAnnotations(llllllllllllllllllllIlIlIIllIIll);
    }
}

