/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;

public class InvalidInjectionPointException
extends InvalidInjectionException {
    private static final /* synthetic */ long serialVersionUID = 2L;

    public InvalidInjectionPointException(InjectionInfo llllllllllllllllIIllIIIlIIIIIlll, String llllllllllllllllIIllIIIlIIIIIIlI, Object ... llllllllllllllllIIllIIIlIIIIIIIl) {
        super(llllllllllllllllIIllIIIlIIIIIlll, String.format(llllllllllllllllIIllIIIlIIIIIIlI, llllllllllllllllIIllIIIlIIIIIIIl));
        InvalidInjectionPointException llllllllllllllllIIllIIIlIIIIlIII;
    }

    public InvalidInjectionPointException(InjectionInfo llllllllllllllllIIllIIIIlllIlIll, Throwable llllllllllllllllIIllIIIIlllIlIlI, String llllllllllllllllIIllIIIIlllIlIIl, Object ... llllllllllllllllIIllIIIIlllIIIll) {
        super(llllllllllllllllIIllIIIIlllIlIll, String.format(llllllllllllllllIIllIIIIlllIlIIl, llllllllllllllllIIllIIIIlllIIIll), llllllllllllllllIIllIIIIlllIlIlI);
        InvalidInjectionPointException llllllllllllllllIIllIIIIlllIllII;
    }

    public InvalidInjectionPointException(IMixinContext llllllllllllllllIIllIIIlIIIIllll, String llllllllllllllllIIllIIIlIIIIlllI, Object ... llllllllllllllllIIllIIIlIIIIllIl) {
        super(llllllllllllllllIIllIIIlIIIIllll, String.format(llllllllllllllllIIllIIIlIIIIlllI, llllllllllllllllIIllIIIlIIIIllIl));
        InvalidInjectionPointException llllllllllllllllIIllIIIlIIIlIIII;
    }

    public InvalidInjectionPointException(IMixinContext llllllllllllllllIIllIIIIlllllIlI, Throwable llllllllllllllllIIllIIIIlllllIIl, String llllllllllllllllIIllIIIIllllIIll, Object ... llllllllllllllllIIllIIIIllllIIlI) {
        super(llllllllllllllllIIllIIIIlllllIlI, String.format(llllllllllllllllIIllIIIIllllIIll, llllllllllllllllIIllIIIIllllIIlI), llllllllllllllllIIllIIIIlllllIIl);
        InvalidInjectionPointException llllllllllllllllIIllIIIIlllllIll;
    }
}

