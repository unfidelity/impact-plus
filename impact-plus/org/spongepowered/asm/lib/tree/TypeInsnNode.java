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
public class TypeInsnNode
extends AbstractInsnNode {
    public /* synthetic */ String desc;

    public TypeInsnNode(int lIIIlllllIlII, String lIIIlllllIlll) {
        super(lIIIlllllIlII);
        TypeInsnNode lIIIllllllIIl;
        lIIIllllllIIl.desc = lIIIlllllIlll;
    }

    public void setOpcode(int lIIIllllIIlII) {
        lIIIllllIIllI.opcode = lIIIllllIIlII;
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> lIIIlllIIIllI) {
        TypeInsnNode lIIIlllIIIlll;
        return new TypeInsnNode(lIIIlllIIIlll.opcode, lIIIlllIIIlll.desc).cloneAnnotations(lIIIlllIIIlll);
    }

    @Override
    public void accept(MethodVisitor lIIIlllIlIIIl) {
        TypeInsnNode lIIIlllIlIlII;
        lIIIlllIlIIIl.visitTypeInsn(lIIIlllIlIlII.opcode, lIIIlllIlIlII.desc);
        lIIIlllIlIlII.acceptAnnotations(lIIIlllIlIIIl);
    }
}

