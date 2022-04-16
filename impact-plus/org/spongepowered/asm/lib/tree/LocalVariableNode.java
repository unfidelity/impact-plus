/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.LabelNode;

public class LocalVariableNode {
    public /* synthetic */ String desc;
    public /* synthetic */ LabelNode start;
    public /* synthetic */ String name;
    public /* synthetic */ String signature;
    public /* synthetic */ int index;
    public /* synthetic */ LabelNode end;

    public LocalVariableNode(String lllllllllllllllllIlIIIIlIllllIlI, String lllllllllllllllllIlIIIIlIlllIIlI, String lllllllllllllllllIlIIIIlIllllIII, LabelNode lllllllllllllllllIlIIIIlIlllIIII, LabelNode lllllllllllllllllIlIIIIlIlllIllI, int lllllllllllllllllIlIIIIlIlllIlIl) {
        LocalVariableNode lllllllllllllllllIlIIIIlIlllIlII;
        lllllllllllllllllIlIIIIlIlllIlII.name = lllllllllllllllllIlIIIIlIllllIlI;
        lllllllllllllllllIlIIIIlIlllIlII.desc = lllllllllllllllllIlIIIIlIlllIIlI;
        lllllllllllllllllIlIIIIlIlllIlII.signature = lllllllllllllllllIlIIIIlIllllIII;
        lllllllllllllllllIlIIIIlIlllIlII.start = lllllllllllllllllIlIIIIlIlllIIII;
        lllllllllllllllllIlIIIIlIlllIlII.end = lllllllllllllllllIlIIIIlIlllIllI;
        lllllllllllllllllIlIIIIlIlllIlII.index = lllllllllllllllllIlIIIIlIlllIlIl;
    }

    public void accept(MethodVisitor lllllllllllllllllIlIIIIlIllIlIlI) {
        LocalVariableNode lllllllllllllllllIlIIIIlIllIlIIl;
        lllllllllllllllllIlIIIIlIllIlIlI.visitLocalVariable(lllllllllllllllllIlIIIIlIllIlIIl.name, lllllllllllllllllIlIIIIlIllIlIIl.desc, lllllllllllllllllIlIIIIlIllIlIIl.signature, lllllllllllllllllIlIIIIlIllIlIIl.start.getLabel(), lllllllllllllllllIlIIIIlIllIlIIl.end.getLabel(), lllllllllllllllllIlIIIIlIllIlIIl.index);
    }
}

