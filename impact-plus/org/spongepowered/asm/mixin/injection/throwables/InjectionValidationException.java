/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo;

public class InjectionValidationException
extends Exception {
    private final /* synthetic */ InjectorGroupInfo group;
    private static final /* synthetic */ long serialVersionUID = 1L;

    public InjectionValidationException(InjectorGroupInfo llllllllllllllllIIllIlllllIIIIII, String llllllllllllllllIIllIllllIllllll) {
        super(llllllllllllllllIIllIllllIllllll);
        InjectionValidationException llllllllllllllllIIllIlllllIIIIIl;
        llllllllllllllllIIllIlllllIIIIIl.group = llllllllllllllllIIllIlllllIIIIII;
    }

    public InjectorGroupInfo getGroup() {
        InjectionValidationException llllllllllllllllIIllIllllIllllII;
        return llllllllllllllllIIllIllllIllllII.group;
    }
}

