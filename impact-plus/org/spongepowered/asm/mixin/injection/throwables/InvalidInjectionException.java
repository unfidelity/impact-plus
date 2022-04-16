/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

public class InvalidInjectionException
extends InvalidMixinException {
    private static final /* synthetic */ long serialVersionUID = 2L;
    private final /* synthetic */ InjectionInfo info;

    public InvalidInjectionException(InjectionInfo llllllllllllllllIIIllIIlIlllllIl, String llllllllllllllllIIIllIIlIllllIll) {
        super(llllllllllllllllIIIllIIlIlllllIl.getContext(), llllllllllllllllIIIllIIlIllllIll);
        InvalidInjectionException llllllllllllllllIIIllIIlIlllllll;
        llllllllllllllllIIIllIIlIlllllll.info = llllllllllllllllIIIllIIlIlllllIl;
    }

    public InvalidInjectionException(IMixinContext llllllllllllllllIIIllIIllIIlIIlI, String llllllllllllllllIIIllIIllIIlIllI) {
        super(llllllllllllllllIIIllIIllIIlIIlI, llllllllllllllllIIIllIIllIIlIllI);
        InvalidInjectionException llllllllllllllllIIIllIIllIIllIlI;
        llllllllllllllllIIIllIIllIIllIlI.info = null;
    }

    public InvalidInjectionException(InjectionInfo llllllllllllllllIIIllIIlIlIlIIII, Throwable llllllllllllllllIIIllIIlIlIIllll) {
        super(llllllllllllllllIIIllIIlIlIlIIII.getContext(), llllllllllllllllIIIllIIlIlIIllll);
        InvalidInjectionException llllllllllllllllIIIllIIlIlIlIlII;
        llllllllllllllllIIIllIIlIlIlIlII.info = llllllllllllllllIIIllIIlIlIlIIII;
    }

    public InvalidInjectionException(InjectionInfo llllllllllllllllIIIllIIlIIllIIII, String llllllllllllllllIIIllIIlIIlIlIlI, Throwable llllllllllllllllIIIllIIlIIlIlllI) {
        super(llllllllllllllllIIIllIIlIIllIIII.getContext(), llllllllllllllllIIIllIIlIIlIlIlI, llllllllllllllllIIIllIIlIIlIlllI);
        InvalidInjectionException llllllllllllllllIIIllIIlIIllIIIl;
        llllllllllllllllIIIllIIlIIllIIIl.info = llllllllllllllllIIIllIIlIIllIIII;
    }

    public InvalidInjectionException(IMixinContext llllllllllllllllIIIllIIlIIllllll, String llllllllllllllllIIIllIIlIIllIlll, Throwable llllllllllllllllIIIllIIlIIllIllI) {
        super(llllllllllllllllIIIllIIlIIllllll, llllllllllllllllIIIllIIlIIllIlll, llllllllllllllllIIIllIIlIIllIllI);
        InvalidInjectionException llllllllllllllllIIIllIIlIIlllIIl;
        llllllllllllllllIIIllIIlIIlllIIl.info = null;
    }

    public InjectionInfo getInjectionInfo() {
        InvalidInjectionException llllllllllllllllIIIllIIlIIlIIIll;
        return llllllllllllllllIIIllIIlIIlIIIll.info;
    }

    public InvalidInjectionException(IMixinContext llllllllllllllllIIIllIIlIllIlIlI, Throwable llllllllllllllllIIIllIIlIllIIIII) {
        super(llllllllllllllllIIIllIIlIllIlIlI, llllllllllllllllIIIllIIlIllIIIII);
        InvalidInjectionException llllllllllllllllIIIllIIlIllIIlIl;
        llllllllllllllllIIIllIIlIllIIlIl.info = null;
    }
}

