/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.ClassVisitor;

public class InnerClassNode {
    public /* synthetic */ String innerName;
    public /* synthetic */ String outerName;
    public /* synthetic */ String name;
    public /* synthetic */ int access;

    public void accept(ClassVisitor lllllllllllllllllIlllIIIlIIIIllI) {
        InnerClassNode lllllllllllllllllIlllIIIlIIIIlll;
        lllllllllllllllllIlllIIIlIIIIllI.visitInnerClass(lllllllllllllllllIlllIIIlIIIIlll.name, lllllllllllllllllIlllIIIlIIIIlll.outerName, lllllllllllllllllIlllIIIlIIIIlll.innerName, lllllllllllllllllIlllIIIlIIIIlll.access);
    }

    public InnerClassNode(String lllllllllllllllllIlllIIIlIIIllIl, String lllllllllllllllllIlllIIIlIIlIIIl, String lllllllllllllllllIlllIIIlIIlIIII, int lllllllllllllllllIlllIIIlIIIllll) {
        InnerClassNode lllllllllllllllllIlllIIIlIIIlllI;
        lllllllllllllllllIlllIIIlIIIlllI.name = lllllllllllllllllIlllIIIlIIIllIl;
        lllllllllllllllllIlllIIIlIIIlllI.outerName = lllllllllllllllllIlllIIIlIIlIIIl;
        lllllllllllllllllIlllIIIlIIIlllI.innerName = lllllllllllllllllIlllIIIlIIlIIII;
        lllllllllllllllllIlllIIIlIIIlllI.access = lllllllllllllllllIlllIIIlIIIllll;
    }
}

