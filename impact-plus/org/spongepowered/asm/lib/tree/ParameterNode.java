/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.MethodVisitor;

public class ParameterNode {
    public /* synthetic */ int access;
    public /* synthetic */ String name;

    public ParameterNode(String lllllllllllllllIllIlllllIIIIllIl, int lllllllllllllllIllIlllllIIIIlIIl) {
        ParameterNode lllllllllllllllIllIlllllIIIIlllI;
        lllllllllllllllIllIlllllIIIIlllI.name = lllllllllllllllIllIlllllIIIIllIl;
        lllllllllllllllIllIlllllIIIIlllI.access = lllllllllllllllIllIlllllIIIIlIIl;
    }

    public void accept(MethodVisitor lllllllllllllllIllIlllllIIIIIIll) {
        ParameterNode lllllllllllllllIllIlllllIIIIIllI;
        lllllllllllllllIllIlllllIIIIIIll.visitParameter(lllllllllllllllIllIlllllIIIIIllI.name, lllllllllllllllIllIlllllIIIIIllI.access);
    }
}

