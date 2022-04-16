/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

@InjectionPoint.AtCode(value="JUMP")
public class JumpInsnPoint
extends InjectionPoint {
    private final /* synthetic */ int ordinal;
    private final /* synthetic */ int opCode;

    public JumpInsnPoint(InjectionPointData lllIIIIllIllII) {
        JumpInsnPoint lllIIIIllIllIl;
        lllIIIIllIllIl.opCode = lllIIIIllIllII.getOpcode(-1, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 198, 199, -1);
        lllIIIIllIllIl.ordinal = lllIIIIllIllII.getOrdinal();
    }

    @Override
    public boolean find(String lllIIIIllIIIII, InsnList lllIIIIlIlllll, Collection<AbstractInsnNode> lllIIIIlIllllI) {
        boolean lllIIIIlIlllIl = false;
        int lllIIIIlIlllII = 0;
        ListIterator<AbstractInsnNode> lllIIIIlIllIll = lllIIIIlIlllll.iterator();
        while (lllIIIIlIllIll.hasNext()) {
            JumpInsnPoint lllIIIIlIllIlI;
            AbstractInsnNode lllIIIIllIIIlI = lllIIIIlIllIll.next();
            if (!(lllIIIIllIIIlI instanceof JumpInsnNode) || lllIIIIlIllIlI.opCode != -1 && lllIIIIllIIIlI.getOpcode() != lllIIIIlIllIlI.opCode) continue;
            if (lllIIIIlIllIlI.ordinal == -1 || lllIIIIlIllIlI.ordinal == lllIIIIlIlllII) {
                lllIIIIlIllllI.add(lllIIIIllIIIlI);
                lllIIIIlIlllIl = true;
            }
            ++lllIIIIlIlllII;
        }
        return lllIIIIlIlllIl;
    }
}

