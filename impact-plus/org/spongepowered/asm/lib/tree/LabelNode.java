/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.Map;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class LabelNode
extends AbstractInsnNode {
    private /* synthetic */ Label label;

    @Override
    public void accept(MethodVisitor llllllllllllllllllllIIlIIIlIIlIl) {
        LabelNode llllllllllllllllllllIIlIIIlIIlll;
        llllllllllllllllllllIIlIIIlIIlIl.visitLabel(llllllllllllllllllllIIlIIIlIIlll.getLabel());
    }

    public LabelNode() {
        super(-1);
        LabelNode llllllllllllllllllllIIlIIlIIIIlI;
    }

    public Label getLabel() {
        LabelNode llllllllllllllllllllIIlIIIllIllI;
        if (llllllllllllllllllllIIlIIIllIllI.label == null) {
            llllllllllllllllllllIIlIIIllIllI.label = new Label();
        }
        return llllllllllllllllllllIIlIIIllIllI.label;
    }

    public void resetLabel() {
        llllllllllllllllllllIIlIIIIIlIll.label = null;
    }

    @Override
    public int getType() {
        return 8;
    }

    public LabelNode(Label llllllllllllllllllllIIlIIIlllIll) {
        super(-1);
        LabelNode llllllllllllllllllllIIlIIIllllII;
        llllllllllllllllllllIIlIIIllllII.label = llllllllllllllllllllIIlIIIlllIll;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllllllIIlIIIIlIIll) {
        LabelNode llllllllllllllllllllIIlIIIIlIlIl;
        return llllllllllllllllllllIIlIIIIlIIll.get(llllllllllllllllllllIIlIIIIlIlIl);
    }
}

