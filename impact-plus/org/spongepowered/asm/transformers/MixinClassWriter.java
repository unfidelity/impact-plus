/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.transformers;

import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.mixin.transformer.ClassInfo;

public class MixinClassWriter
extends ClassWriter {
    public MixinClassWriter(int llllllllllllllllIllIllIIIIlIIIll) {
        super(llllllllllllllllIllIllIIIIlIIIll);
        MixinClassWriter llllllllllllllllIllIllIIIIlIIllI;
    }

    public MixinClassWriter(ClassReader llllllllllllllllIllIllIIIIIllllI, int llllllllllllllllIllIllIIIIIlllIl) {
        super(llllllllllllllllIllIllIIIIIllllI, llllllllllllllllIllIllIIIIIlllIl);
        MixinClassWriter llllllllllllllllIllIllIIIIIlllll;
    }

    @Override
    protected String getCommonSuperClass(String llllllllllllllllIllIllIIIIIlIlII, String llllllllllllllllIllIllIIIIIlIlIl) {
        return ClassInfo.getCommonSuperClass(llllllllllllllllIllIllIIIIIlIlII, llllllllllllllllIllIllIIIIIlIlIl).getName();
    }
}

