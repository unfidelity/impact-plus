/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mirror.mapping;

import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

public final class ResolvableMappingMethod
extends MappingMethod {
    private final /* synthetic */ TypeHandle ownerHandle;

    public ResolvableMappingMethod(TypeHandle llllllllllllllllIllIllllIlllIlIl, String llllllllllllllllIllIllllIlllIlII, String llllllllllllllllIllIllllIllIllll) {
        super(llllllllllllllllIllIllllIlllIlIl.getName(), llllllllllllllllIllIllllIlllIlII, llllllllllllllllIllIllllIllIllll);
        ResolvableMappingMethod llllllllllllllllIllIllllIlllIllI;
        llllllllllllllllIllIllllIlllIllI.ownerHandle = llllllllllllllllIllIllllIlllIlIl;
    }

    @Override
    public MappingMethod copy() {
        ResolvableMappingMethod llllllllllllllllIllIllllIIIlllll;
        return new ResolvableMappingMethod(llllllllllllllllIllIllllIIIlllll.ownerHandle, llllllllllllllllIllIllllIIIlllll.getSimpleName(), llllllllllllllllIllIllllIIIlllll.getDesc());
    }

    @Override
    public MappingMethod remap(String llllllllllllllllIllIllllIIllIlII) {
        ResolvableMappingMethod llllllllllllllllIllIllllIIllIlll;
        return new ResolvableMappingMethod(llllllllllllllllIllIllllIIllIlll.ownerHandle, llllllllllllllllIllIllllIIllIlII, llllllllllllllllIllIllllIIllIlll.getDesc());
    }

    public MappingMethod move(TypeHandle llllllllllllllllIllIllllIIllllll) {
        ResolvableMappingMethod llllllllllllllllIllIllllIlIIIIIl;
        return new ResolvableMappingMethod(llllllllllllllllIllIllllIIllllll, llllllllllllllllIllIllllIlIIIIIl.getSimpleName(), llllllllllllllllIllIllllIlIIIIIl.getDesc());
    }

    @Override
    public MappingMethod transform(String llllllllllllllllIllIllllIIlIIlII) {
        ResolvableMappingMethod llllllllllllllllIllIllllIIlIIIll;
        return new ResolvableMappingMethod(llllllllllllllllIllIllllIIlIIIll.ownerHandle, llllllllllllllllIllIllllIIlIIIll.getSimpleName(), llllllllllllllllIllIllllIIlIIlII);
    }

    @Override
    public MappingMethod getSuper() {
        ResolvableMappingMethod llllllllllllllllIllIllllIlIlIlll;
        if (llllllllllllllllIllIllllIlIlIlll.ownerHandle == null) {
            return super.getSuper();
        }
        String llllllllllllllllIllIllllIlIlIllI = llllllllllllllllIllIllllIlIlIlll.getSimpleName();
        String llllllllllllllllIllIllllIlIlIlIl = llllllllllllllllIllIllllIlIlIlll.getDesc();
        String llllllllllllllllIllIllllIlIlIlII = TypeUtils.getJavaSignature(llllllllllllllllIllIllllIlIlIlIl);
        TypeHandle llllllllllllllllIllIllllIlIlIIll = llllllllllllllllIllIllllIlIlIlll.ownerHandle.getSuperclass();
        if (llllllllllllllllIllIllllIlIlIIll != null && llllllllllllllllIllIllllIlIlIIll.findMethod(llllllllllllllllIllIllllIlIlIllI, llllllllllllllllIllIllllIlIlIlII) != null) {
            return llllllllllllllllIllIllllIlIlIIll.getMappingMethod(llllllllllllllllIllIllllIlIlIllI, llllllllllllllllIllIllllIlIlIlIl);
        }
        for (TypeHandle llllllllllllllllIllIllllIlIllIII : llllllllllllllllIllIllllIlIlIlll.ownerHandle.getInterfaces()) {
            if (llllllllllllllllIllIllllIlIllIII.findMethod(llllllllllllllllIllIllllIlIlIllI, llllllllllllllllIllIllllIlIlIlII) == null) continue;
            return llllllllllllllllIllIllllIlIllIII.getMappingMethod(llllllllllllllllIllIllllIlIlIllI, llllllllllllllllIllIllllIlIlIlIl);
        }
        if (llllllllllllllllIllIllllIlIlIIll != null) {
            return llllllllllllllllIllIllllIlIlIIll.getMappingMethod(llllllllllllllllIllIllllIlIlIllI, llllllllllllllllIllIllllIlIlIlIl).getSuper();
        }
        return super.getSuper();
    }
}

