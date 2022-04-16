/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;

@InjectionPoint.AtCode(value="TAIL")
public class BeforeFinalReturn
extends InjectionPoint {
    private final /* synthetic */ IMixinContext context;

    public BeforeFinalReturn(InjectionPointData lIIlIlllIIIIllI) {
        super(lIIlIlllIIIIllI);
        BeforeFinalReturn lIIlIlllIIIlIIl;
        lIIlIlllIIIlIIl.context = lIIlIlllIIIIllI.getContext();
    }

    @Override
    public boolean find(String lIIlIllIllllIll, InsnList lIIlIllIlllIIll, Collection<AbstractInsnNode> lIIlIllIlllIIlI) {
        AbstractInsnNode lIIlIllIllllIII = null;
        int lIIlIllIlllIlll = Type.getReturnType(lIIlIllIllllIll).getOpcode(172);
        ListIterator<AbstractInsnNode> lIIlIllIlllIllI = lIIlIllIlllIIll.iterator();
        while (lIIlIllIlllIllI.hasNext()) {
            AbstractInsnNode lIIlIllIlllllIl = lIIlIllIlllIllI.next();
            if (!(lIIlIllIlllllIl instanceof InsnNode) || lIIlIllIlllllIl.getOpcode() != lIIlIllIlllIlll) continue;
            lIIlIllIllllIII = lIIlIllIlllllIl;
        }
        if (lIIlIllIllllIII == null) {
            BeforeFinalReturn lIIlIllIlllIlIl;
            throw new InvalidInjectionException(lIIlIllIlllIlIl.context, "TAIL could not locate a valid RETURN in the target method!");
        }
        lIIlIllIlllIIlI.add(lIIlIllIllllIII);
        return true;
    }
}

