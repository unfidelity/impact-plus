/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.Set;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.SmallSet;
import org.spongepowered.asm.lib.tree.analysis.Value;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SourceValue
implements Value {
    public final /* synthetic */ int size;
    public final /* synthetic */ Set<AbstractInsnNode> insns;

    @Override
    public int getSize() {
        SourceValue lllllllllllllllIlllIIlllIIllllIl;
        return lllllllllllllllIlllIIlllIIllllIl.size;
    }

    public boolean equals(Object lllllllllllllllIlllIIlllIIlllIII) {
        SourceValue lllllllllllllllIlllIIlllIIllIllI;
        if (!(lllllllllllllllIlllIIlllIIlllIII instanceof SourceValue)) {
            return false;
        }
        SourceValue lllllllllllllllIlllIIlllIIllIlll = (SourceValue)lllllllllllllllIlllIIlllIIlllIII;
        return lllllllllllllllIlllIIlllIIllIllI.size == lllllllllllllllIlllIIlllIIllIlll.size && lllllllllllllllIlllIIlllIIllIllI.insns.equals(lllllllllllllllIlllIIlllIIllIlll.insns);
    }

    public SourceValue(int lllllllllllllllIlllIIlllIlIlIlII) {
        lllllllllllllllIlllIIlllIlIlIIll(lllllllllllllllIlllIIlllIlIlIlII, SmallSet.emptySet());
        SourceValue lllllllllllllllIlllIIlllIlIlIIll;
    }

    public SourceValue(int lllllllllllllllIlllIIlllIlIIlIlI, AbstractInsnNode lllllllllllllllIlllIIlllIlIIlIIl) {
        SourceValue lllllllllllllllIlllIIlllIlIIlllI;
        lllllllllllllllIlllIIlllIlIIlllI.size = lllllllllllllllIlllIIlllIlIIlIlI;
        lllllllllllllllIlllIIlllIlIIlllI.insns = new SmallSet<Object>(lllllllllllllllIlllIIlllIlIIlIIl, null);
    }

    public int hashCode() {
        SourceValue lllllllllllllllIlllIIlllIIllIIIl;
        return lllllllllllllllIlllIIlllIIllIIIl.insns.hashCode();
    }

    public SourceValue(int lllllllllllllllIlllIIlllIlIIIlII, Set<AbstractInsnNode> lllllllllllllllIlllIIlllIlIIIIII) {
        SourceValue lllllllllllllllIlllIIlllIlIIIlIl;
        lllllllllllllllIlllIIlllIlIIIlIl.size = lllllllllllllllIlllIIlllIlIIIlII;
        lllllllllllllllIlllIIlllIlIIIlIl.insns = lllllllllllllllIlllIIlllIlIIIIII;
    }
}

