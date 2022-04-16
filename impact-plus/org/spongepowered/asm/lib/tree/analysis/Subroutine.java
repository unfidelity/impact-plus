/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;

class Subroutine {
    /* synthetic */ LabelNode start;
    /* synthetic */ boolean[] access;
    /* synthetic */ List<JumpInsnNode> callers;

    Subroutine(LabelNode llIllIIIIIIIlIl, int llIllIIIIIIIlII, JumpInsnNode llIlIllllllllll) {
        Subroutine llIllIIIIIIIllI;
        llIllIIIIIIIllI.start = llIllIIIIIIIlIl;
        llIllIIIIIIIllI.access = new boolean[llIllIIIIIIIlII];
        llIllIIIIIIIllI.callers = new ArrayList<JumpInsnNode>();
        llIllIIIIIIIllI.callers.add(llIlIllllllllll);
    }

    public boolean merge(Subroutine llIlIllllIlIIll) throws AnalyzerException {
        Subroutine llIlIllllIIllll;
        boolean llIlIllllIlIIIl = false;
        for (int llIlIllllIllIll = 0; llIlIllllIllIll < llIlIllllIIllll.access.length; ++llIlIllllIllIll) {
            if (!llIlIllllIlIIll.access[llIlIllllIllIll] || llIlIllllIIllll.access[llIlIllllIllIll]) continue;
            llIlIllllIIllll.access[llIlIllllIllIll] = true;
            llIlIllllIlIIIl = true;
        }
        if (llIlIllllIlIIll.start == llIlIllllIIllll.start) {
            for (int llIlIllllIlIlll = 0; llIlIllllIlIlll < llIlIllllIlIIll.callers.size(); ++llIlIllllIlIlll) {
                JumpInsnNode llIlIllllIllIIl = llIlIllllIlIIll.callers.get(llIlIllllIlIlll);
                if (llIlIllllIIllll.callers.contains(llIlIllllIllIIl)) continue;
                llIlIllllIIllll.callers.add(llIlIllllIllIIl);
                llIlIllllIlIIIl = true;
            }
        }
        return llIlIllllIlIIIl;
    }

    private Subroutine() {
        Subroutine llIllIIIIIIllll;
    }

    public Subroutine copy() {
        Subroutine llIlIllllllIlII;
        Subroutine llIlIllllllIlIl = new Subroutine();
        llIlIllllllIlIl.start = llIlIllllllIlII.start;
        llIlIllllllIlIl.access = new boolean[llIlIllllllIlII.access.length];
        System.arraycopy(llIlIllllllIlII.access, 0, llIlIllllllIlIl.access, 0, llIlIllllllIlII.access.length);
        llIlIllllllIlIl.callers = new ArrayList<JumpInsnNode>(llIlIllllllIlII.callers);
        return llIlIllllllIlIl;
    }
}

