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
public class FieldInsnNode
extends AbstractInsnNode {
    public /* synthetic */ String desc;
    public /* synthetic */ String name;
    public /* synthetic */ String owner;

    public void setOpcode(int llllllllllllllllIllIllIlllIllIII) {
        llllllllllllllllIllIllIlllIllIIl.opcode = llllllllllllllllIllIllIlllIllIII;
    }

    public FieldInsnNode(int llllllllllllllllIllIllIllllIllll, String llllllllllllllllIllIllIllllIlllI, String llllllllllllllllIllIllIllllIIIIl, String llllllllllllllllIllIllIllllIIIII) {
        super(llllllllllllllllIllIllIllllIllll);
        FieldInsnNode llllllllllllllllIllIllIllllIlIIl;
        llllllllllllllllIllIllIllllIlIIl.owner = llllllllllllllllIllIllIllllIlllI;
        llllllllllllllllIllIllIllllIlIIl.name = llllllllllllllllIllIllIllllIIIIl;
        llllllllllllllllIllIllIllllIlIIl.desc = llllllllllllllllIllIllIllllIIIII;
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllIllIllIlllIIlIlI) {
        FieldInsnNode llllllllllllllllIllIllIlllIIlIII;
        llllllllllllllllIllIllIlllIIlIlI.visitFieldInsn(llllllllllllllllIllIllIlllIIlIII.opcode, llllllllllllllllIllIllIlllIIlIII.owner, llllllllllllllllIllIllIlllIIlIII.name, llllllllllllllllIllIllIlllIIlIII.desc);
        llllllllllllllllIllIllIlllIIlIII.acceptAnnotations(llllllllllllllllIllIllIlllIIlIlI);
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllIllIllIllIllllIl) {
        FieldInsnNode llllllllllllllllIllIllIllIlllIll;
        return new FieldInsnNode(llllllllllllllllIllIllIllIlllIll.opcode, llllllllllllllllIllIllIllIlllIll.owner, llllllllllllllllIllIllIllIlllIll.name, llllllllllllllllIllIllIllIlllIll.desc).cloneAnnotations(llllllllllllllllIllIllIllIlllIll);
    }

    @Override
    public int getType() {
        return 4;
    }
}

