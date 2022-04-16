/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AnnotationNode;

public class TypeAnnotationNode
extends AnnotationNode {
    public /* synthetic */ int typeRef;
    public /* synthetic */ TypePath typePath;

    public TypeAnnotationNode(int lllIIlIIlllII, TypePath lllIIlIIllIll, String lllIIlIIllllI) {
        lllIIlIIlllIl(327680, lllIIlIIlllII, lllIIlIIllIll, lllIIlIIllllI);
        TypeAnnotationNode lllIIlIIlllIl;
        if (lllIIlIIlllIl.getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public TypeAnnotationNode(int lllIIlIIIlllI, int lllIIlIIlIIlI, TypePath lllIIlIIlIIIl, String lllIIlIIlIIII) {
        super(lllIIlIIIlllI, lllIIlIIlIIII);
        TypeAnnotationNode lllIIlIIIllll;
        lllIIlIIIllll.typeRef = lllIIlIIlIIlI;
        lllIIlIIIllll.typePath = lllIIlIIlIIIl;
    }
}

