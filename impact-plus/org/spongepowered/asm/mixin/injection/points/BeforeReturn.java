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

@InjectionPoint.AtCode(value="RETURN")
public class BeforeReturn
extends InjectionPoint {
    private final /* synthetic */ int ordinal;

    @Override
    public boolean find(String lllllllllllllllIlllIllIlllIlIIlI, InsnList lllllllllllllllIlllIllIlllIllIIl, Collection<AbstractInsnNode> lllllllllllllllIlllIllIlllIlIIII) {
        boolean lllllllllllllllIlllIllIlllIlIlll = false;
        int lllllllllllllllIlllIllIlllIlIllI = Type.getReturnType(lllllllllllllllIlllIllIlllIlIIlI).getOpcode(172);
        int lllllllllllllllIlllIllIlllIlIlIl = 0;
        ListIterator<AbstractInsnNode> lllllllllllllllIlllIllIlllIlIlII = lllllllllllllllIlllIllIlllIllIIl.iterator();
        while (lllllllllllllllIlllIllIlllIlIlII.hasNext()) {
            BeforeReturn lllllllllllllllIlllIllIlllIlIIll;
            AbstractInsnNode lllllllllllllllIlllIllIlllIlllII = lllllllllllllllIlllIllIlllIlIlII.next();
            if (!(lllllllllllllllIlllIllIlllIlllII instanceof InsnNode) || lllllllllllllllIlllIllIlllIlllII.getOpcode() != lllllllllllllllIlllIllIlllIlIllI) continue;
            if (lllllllllllllllIlllIllIlllIlIIll.ordinal == -1 || lllllllllllllllIlllIllIlllIlIIll.ordinal == lllllllllllllllIlllIllIlllIlIlIl) {
                lllllllllllllllIlllIllIlllIlIIII.add(lllllllllllllllIlllIllIlllIlllII);
                lllllllllllllllIlllIllIlllIlIlll = true;
            }
            ++lllllllllllllllIlllIllIlllIlIlIl;
        }
        return lllllllllllllllIlllIllIlllIlIlll;
    }

    public BeforeReturn(InjectionPointData lllllllllllllllIlllIllIllllIlIII) {
        super(lllllllllllllllIlllIllIllllIlIII);
        BeforeReturn lllllllllllllllIlllIllIllllIlIIl;
        lllllllllllllllIlllIllIllllIlIIl.ordinal = lllllllllllllllIlllIllIllllIlIII.getOrdinal();
    }
}

