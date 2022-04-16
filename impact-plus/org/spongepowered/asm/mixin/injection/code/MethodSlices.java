/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.code;

import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.mixin.injection.code.ISliceContext;
import org.spongepowered.asm.mixin.injection.code.MethodSlice;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.throwables.InvalidSliceException;
import org.spongepowered.asm.util.Annotations;

public final class MethodSlices {
    private final /* synthetic */ InjectionInfo info;
    private final /* synthetic */ Map<String, MethodSlice> slices;

    private void add(MethodSlice lllllllllllllllllIIIIIlllIlIIlIl) {
        MethodSlices lllllllllllllllllIIIIIlllIlIIlll;
        String lllllllllllllllllIIIIIlllIlIIIll = lllllllllllllllllIIIIIlllIlIIlll.info.getSliceId(lllllllllllllllllIIIIIlllIlIIlIl.getId());
        if (lllllllllllllllllIIIIIlllIlIIlll.slices.containsKey(lllllllllllllllllIIIIIlllIlIIIll)) {
            throw new InvalidSliceException((ISliceContext)lllllllllllllllllIIIIIlllIlIIlll.info, String.valueOf(new StringBuilder().append(lllllllllllllllllIIIIIlllIlIIlIl).append(" has a duplicate id, '").append(lllllllllllllllllIIIIIlllIlIIIll).append("' was already defined")));
        }
        lllllllllllllllllIIIIIlllIlIIlll.slices.put(lllllllllllllllllIIIIIlllIlIIIll, lllllllllllllllllIIIIIlllIlIIlIl);
    }

    public static MethodSlices parse(InjectionInfo lllllllllllllllllIIIIIllIllIlIII) {
        MethodSlices lllllllllllllllllIIIIIllIllIIlll = new MethodSlices(lllllllllllllllllIIIIIllIllIlIII);
        AnnotationNode lllllllllllllllllIIIIIllIllIIllI = lllllllllllllllllIIIIIllIllIlIII.getAnnotation();
        if (lllllllllllllllllIIIIIllIllIIllI != null) {
            for (AnnotationNode lllllllllllllllllIIIIIllIllIlIIl : Annotations.getValue(lllllllllllllllllIIIIIllIllIIllI, "slice", true)) {
                MethodSlice lllllllllllllllllIIIIIllIllIlIlI = MethodSlice.parse((ISliceContext)lllllllllllllllllIIIIIllIllIlIII, lllllllllllllllllIIIIIllIllIlIIl);
                lllllllllllllllllIIIIIllIllIIlll.add(lllllllllllllllllIIIIIllIllIlIlI);
            }
        }
        return lllllllllllllllllIIIIIllIllIIlll;
    }

    public String toString() {
        MethodSlices lllllllllllllllllIIIIIlllIIIIIll;
        return String.format("MethodSlices%s", lllllllllllllllllIIIIIlllIIIIIll.slices.keySet());
    }

    public MethodSlice get(String lllllllllllllllllIIIIIlllIIIlllI) {
        MethodSlices lllllllllllllllllIIIIIlllIIIlIll;
        return lllllllllllllllllIIIIIlllIIIlIll.slices.get(lllllllllllllllllIIIIIlllIIIlllI);
    }

    private MethodSlices(InjectionInfo lllllllllllllllllIIIIIlllIllIlII) {
        MethodSlices lllllllllllllllllIIIIIlllIllIlll;
        lllllllllllllllllIIIIIlllIllIlll.slices = new HashMap<String, MethodSlice>(4);
        lllllllllllllllllIIIIIlllIllIlll.info = lllllllllllllllllIIIIIlllIllIlII;
    }
}

