/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.code;

import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.ISliceContext;
import org.spongepowered.asm.mixin.injection.code.MethodSlice;
import org.spongepowered.asm.mixin.injection.code.ReadOnlyInsnList;
import org.spongepowered.asm.mixin.injection.struct.Target;

public class InjectorTarget {
    private final /* synthetic */ ISliceContext context;
    private final /* synthetic */ Target target;
    private final /* synthetic */ Map<String, ReadOnlyInsnList> cache;

    public void dispose() {
        InjectorTarget lIIlIlIllllIIlI;
        for (ReadOnlyInsnList lIIlIlIllllIlII : lIIlIlIllllIIlI.cache.values()) {
            lIIlIlIllllIlII.dispose();
        }
        lIIlIlIllllIIlI.cache.clear();
    }

    public InjectorTarget(ISliceContext lIIlIllIIlIlllI, Target lIIlIllIIlIlIlI) {
        InjectorTarget lIIlIllIIlIllll;
        lIIlIllIIlIllll.cache = new HashMap<String, ReadOnlyInsnList>();
        lIIlIllIIlIllll.context = lIIlIllIIlIlllI;
        lIIlIllIIlIllll.target = lIIlIllIIlIlIlI;
    }

    public InsnList getSlice(InjectionPoint lIIlIlIlllllIlI) {
        InjectorTarget lIIlIlIlllllIll;
        return lIIlIlIlllllIll.getSlice(lIIlIlIlllllIlI.getSlice());
    }

    public Target getTarget() {
        InjectorTarget lIIlIllIIlIIlll;
        return lIIlIllIIlIIlll.target;
    }

    public MethodNode getMethod() {
        InjectorTarget lIIlIllIIlIIlII;
        return lIIlIllIIlIIlII.target.method;
    }

    public InsnList getSlice(String lIIlIllIIIIIlll) {
        InjectorTarget lIIlIllIIIIlIIl;
        ReadOnlyInsnList lIIlIllIIIIlIll = lIIlIllIIIIlIIl.cache.get(lIIlIllIIIIIlll);
        if (lIIlIllIIIIlIll == null) {
            MethodSlice lIIlIllIIIlIIIl = lIIlIllIIIIlIIl.context.getSlice(lIIlIllIIIIIlll);
            lIIlIllIIIIlIll = lIIlIllIIIlIIIl != null ? lIIlIllIIIlIIIl.getSlice(lIIlIllIIIIlIIl.target.method) : new ReadOnlyInsnList(lIIlIllIIIIlIIl.target.method.instructions);
            lIIlIllIIIIlIIl.cache.put(lIIlIllIIIIIlll, lIIlIllIIIIlIll);
        }
        return lIIlIllIIIIlIll;
    }
}

