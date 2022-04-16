/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

@InjectionPoint.AtCode(value="HEAD")
public class MethodHead
extends InjectionPoint {
    @Override
    public boolean find(String llllllllllllllllIIlIIlIlIllllIlI, InsnList llllllllllllllllIIlIIlIlIlllIlll, Collection<AbstractInsnNode> llllllllllllllllIIlIIlIlIlllIllI) {
        llllllllllllllllIIlIIlIlIlllIllI.add(llllllllllllllllIIlIIlIlIlllIlll.getFirst());
        return true;
    }

    public MethodHead(InjectionPointData llllllllllllllllIIlIIlIlIllllllI) {
        super(llllllllllllllllIIlIIlIlIllllllI);
        MethodHead llllllllllllllllIIlIIlIlIlllllll;
    }
}

