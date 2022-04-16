/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.Value;

public class AnalyzerException
extends Exception {
    public final /* synthetic */ AbstractInsnNode node;

    public AnalyzerException(AbstractInsnNode lIIIlllIllllIl, String lIIIlllIllIlll, Object lIIIlllIlllIll, Value lIIIlllIlllIlI) {
        super(String.valueOf(new StringBuilder().append(lIIIlllIllIlll == null ? "Expected " : String.valueOf(new StringBuilder().append(lIIIlllIllIlll).append(": expected "))).append(lIIIlllIlllIll).append(", but found ").append(lIIIlllIlllIlI)));
        AnalyzerException lIIIlllIlllllI;
        lIIIlllIlllllI.node = lIIIlllIllllIl;
    }

    public AnalyzerException(AbstractInsnNode lIIIllllIIIllI, String lIIIllllIIIlIl, Throwable lIIIllllIIlIII) {
        super(lIIIllllIIIlIl, lIIIllllIIlIII);
        AnalyzerException lIIIllllIIIlll;
        lIIIllllIIIlll.node = lIIIllllIIIllI;
    }

    public AnalyzerException(AbstractInsnNode lIIIllllIlIIIl, String lIIIllllIlIIll) {
        super(lIIIllllIlIIll);
        AnalyzerException lIIIllllIlIlIl;
        lIIIllllIlIlIl.node = lIIIllllIlIIIl;
    }
}

