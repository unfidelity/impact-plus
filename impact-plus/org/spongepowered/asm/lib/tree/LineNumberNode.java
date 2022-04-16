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
public class LineNumberNode
extends AbstractInsnNode {
    public /* synthetic */ LabelNode start;
    public /* synthetic */ int line;

    public LineNumberNode(int llllllllllllllllllIIIIIllIIllIll, LabelNode llllllllllllllllllIIIIIllIIlIlll) {
        super(-1);
        LineNumberNode llllllllllllllllllIIIIIllIIllIIl;
        llllllllllllllllllIIIIIllIIllIIl.line = llllllllllllllllllIIIIIllIIllIll;
        llllllllllllllllllIIIIIllIIllIIl.start = llllllllllllllllllIIIIIllIIlIlll;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllllIIIIIllIIIlIlI) {
        LineNumberNode llllllllllllllllllIIIIIllIIIlIll;
        return new LineNumberNode(llllllllllllllllllIIIIIllIIIlIll.line, LineNumberNode.clone(llllllllllllllllllIIIIIllIIIlIll.start, llllllllllllllllllIIIIIllIIIlIlI));
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllllIIIIIllIIlIIII) {
        LineNumberNode llllllllllllllllllIIIIIllIIlIIIl;
        llllllllllllllllllIIIIIllIIlIIII.visitLineNumber(llllllllllllllllllIIIIIllIIlIIIl.line, llllllllllllllllllIIIIIllIIlIIIl.start.getLabel());
    }

    @Override
    public int getType() {
        return 15;
    }
}

