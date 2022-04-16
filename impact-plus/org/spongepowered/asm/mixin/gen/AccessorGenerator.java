/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.gen;

import java.util.ArrayList;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.gen.AccessorInfo;

public abstract class AccessorGenerator {
    protected final /* synthetic */ AccessorInfo info;

    public abstract MethodNode generate();

    protected final MethodNode createMethod(int lllllllllllllllllIlIIIIllIllIIIl, int lllllllllllllllllIlIIIIllIlIllll) {
        AccessorGenerator lllllllllllllllllIlIIIIllIlllIII;
        MethodNode lllllllllllllllllIlIIIIllIllIlIl = lllllllllllllllllIlIIIIllIlllIII.info.getMethod();
        MethodNode lllllllllllllllllIlIIIIllIllIlII = new MethodNode(327680, lllllllllllllllllIlIIIIllIllIlIl.access & 0xFFFFFBFF | 0x1000, lllllllllllllllllIlIIIIllIllIlIl.name, lllllllllllllllllIlIIIIllIllIlIl.desc, null, null);
        lllllllllllllllllIlIIIIllIllIlII.visibleAnnotations = new ArrayList<AnnotationNode>();
        lllllllllllllllllIlIIIIllIllIlII.visibleAnnotations.add(lllllllllllllllllIlIIIIllIlllIII.info.getAnnotation());
        lllllllllllllllllIlIIIIllIllIlII.maxLocals = lllllllllllllllllIlIIIIllIllIIIl;
        lllllllllllllllllIlIIIIllIllIlII.maxStack = lllllllllllllllllIlIIIIllIlIllll;
        return lllllllllllllllllIlIIIIllIllIlII;
    }

    public AccessorGenerator(AccessorInfo lllllllllllllllllIlIIIIlllIIIlII) {
        AccessorGenerator lllllllllllllllllIlIIIIlllIIlIlI;
        lllllllllllllllllIlIIIIlllIIlIlI.info = lllllllllllllllllIlIIIIlllIIIlII;
    }
}

