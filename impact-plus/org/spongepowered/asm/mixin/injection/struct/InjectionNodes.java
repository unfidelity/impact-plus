/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.util.Bytecode;

public class InjectionNodes
extends ArrayList<InjectionNode> {
    private static final /* synthetic */ long serialVersionUID = 1L;

    public InjectionNodes() {
        InjectionNodes lIllIIIlllllIlI;
    }

    public InjectionNode get(AbstractInsnNode lIllIIIlllIIlll) {
        InjectionNodes lIllIIIlllIlIII;
        for (InjectionNode lIllIIIlllIlIll : lIllIIIlllIlIII) {
            if (!lIllIIIlllIlIll.matches(lIllIIIlllIIlll)) continue;
            return lIllIIIlllIlIll;
        }
        return null;
    }

    public boolean contains(AbstractInsnNode lIllIIIlllIIIIl) {
        InjectionNodes lIllIIIlllIIIlI;
        return lIllIIIlllIIIlI.get(lIllIIIlllIIIIl) != null;
    }

    public void remove(AbstractInsnNode lIllIIIllIIlllI) {
        InjectionNodes lIllIIIllIIllII;
        InjectionNode lIllIIIllIIllIl = lIllIIIllIIllII.get(lIllIIIllIIlllI);
        if (lIllIIIllIIllIl != null) {
            lIllIIIllIIllIl.remove();
        }
    }

    public InjectionNode add(AbstractInsnNode lIllIIIllllIlII) {
        InjectionNodes lIllIIIllllIIlI;
        InjectionNode lIllIIIllllIIll = lIllIIIllllIIlI.get(lIllIIIllllIlII);
        if (lIllIIIllllIIll == null) {
            lIllIIIllllIIll = new InjectionNode(lIllIIIllllIlII);
            lIllIIIllllIIlI.add(lIllIIIllllIIll);
        }
        return lIllIIIllllIIll;
    }

    public void replace(AbstractInsnNode lIllIIIllIllIIl, AbstractInsnNode lIllIIIllIllIII) {
        InjectionNodes lIllIIIllIlIllI;
        InjectionNode lIllIIIllIlIlll = lIllIIIllIlIllI.get(lIllIIIllIllIIl);
        if (lIllIIIllIlIlll != null) {
            lIllIIIllIlIlll.replace(lIllIIIllIllIII);
        }
    }

    public static class InjectionNode
    implements Comparable<InjectionNode> {
        private final /* synthetic */ AbstractInsnNode originalTarget;
        private static /* synthetic */ int nextId;
        private final /* synthetic */ int id;
        private /* synthetic */ AbstractInsnNode currentTarget;
        private /* synthetic */ Map<String, Object> decorations;

        public boolean isReplaced() {
            InjectionNode lIIlIIllllllIII;
            return lIIlIIllllllIII.originalTarget != lIIlIIllllllIII.currentTarget;
        }

        public boolean matches(AbstractInsnNode lIIlIIllllllIll) {
            InjectionNode lIIlIIllllllllI;
            return lIIlIIllllllllI.originalTarget == lIIlIIllllllIll || lIIlIIllllllllI.currentTarget == lIIlIIllllllIll;
        }

        static {
            nextId = 0;
        }

        public InjectionNode remove() {
            InjectionNode lIIlIlIIIIIlIII;
            lIIlIlIIIIIlIII.currentTarget = null;
            return lIIlIlIIIIIlIII;
        }

        public InjectionNode replace(AbstractInsnNode lIIlIlIIIIllIlI) {
            InjectionNode lIIlIlIIIIlllII;
            lIIlIlIIIIlllII.currentTarget = lIIlIlIIIIllIlI;
            return lIIlIlIIIIlllII;
        }

        public boolean isRemoved() {
            InjectionNode lIIlIIlllllIllI;
            return lIIlIIlllllIllI.currentTarget == null;
        }

        public int getId() {
            InjectionNode lIIlIlIIIllIIlI;
            return lIIlIlIIIllIIlI.id;
        }

        public InjectionNode(AbstractInsnNode lIIlIlIIIllIlIl) {
            InjectionNode lIIlIlIIIllIllI;
            lIIlIlIIIllIllI.currentTarget = lIIlIlIIIllIllI.originalTarget = lIIlIlIIIllIlIl;
            lIIlIlIIIllIllI.id = nextId++;
        }

        @Override
        public int compareTo(InjectionNode lIIlIIlllIlllII) {
            InjectionNode lIIlIIlllIlllIl;
            return lIIlIIlllIlllII == null ? Integer.MAX_VALUE : lIIlIIlllIlllIl.hashCode() - lIIlIIlllIlllII.hashCode();
        }

        public boolean hasDecoration(String lIIlIIllllIIllI) {
            InjectionNode lIIlIIllllIIlll;
            return lIIlIIllllIIlll.decorations != null && lIIlIIllllIIlll.decorations.get(lIIlIIllllIIllI) != null;
        }

        public AbstractInsnNode getOriginalTarget() {
            InjectionNode lIIlIlIIIllIIII;
            return lIIlIlIIIllIIII.originalTarget;
        }

        public String toString() {
            InjectionNode lIIlIIlllIlIlll;
            return String.format("InjectionNode[%s]", Bytecode.describeNode(lIIlIIlllIlIlll.currentTarget).replaceAll("\\s+", " "));
        }

        public <V> V getDecoration(String lIIlIIllllIIIII) {
            InjectionNode lIIlIIllllIIIll;
            return (V)(lIIlIIllllIIIll.decorations == null ? null : lIIlIIllllIIIll.decorations.get(lIIlIIllllIIIII));
        }

        public AbstractInsnNode getCurrentTarget() {
            InjectionNode lIIlIlIIIlIlIll;
            return lIIlIlIIIlIlIll.currentTarget;
        }

        public <V> InjectionNode decorate(String lIIlIIllllIllIl, V lIIlIIllllIllII) {
            InjectionNode lIIlIIllllIlllI;
            if (lIIlIIllllIlllI.decorations == null) {
                lIIlIIllllIlllI.decorations = new HashMap<String, Object>();
            }
            lIIlIIllllIlllI.decorations.put(lIIlIIllllIllIl, lIIlIIllllIllII);
            return lIIlIIllllIlllI;
        }
    }
}

