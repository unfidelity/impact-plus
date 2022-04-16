/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.gen.throwables;

import org.spongepowered.asm.mixin.gen.AccessorInfo;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

public class InvalidAccessorException
extends InvalidMixinException {
    private final /* synthetic */ AccessorInfo info;
    private static final /* synthetic */ long serialVersionUID = 2L;

    public InvalidAccessorException(AccessorInfo llllllllllllllllIIIIlllIIIlIIlll, String llllllllllllllllIIIIlllIIIlIlIIl) {
        super(llllllllllllllllIIIIlllIIIlIIlll.getContext(), llllllllllllllllIIIIlllIIIlIlIIl);
        InvalidAccessorException llllllllllllllllIIIIlllIIIlIlIII;
        llllllllllllllllIIIIlllIIIlIlIII.info = llllllllllllllllIIIIlllIIIlIIlll;
    }

    public InvalidAccessorException(AccessorInfo llllllllllllllllIIIIlllIIIIllIII, Throwable llllllllllllllllIIIIlllIIIIlIlll) {
        super(llllllllllllllllIIIIlllIIIIllIII.getContext(), llllllllllllllllIIIIlllIIIIlIlll);
        InvalidAccessorException llllllllllllllllIIIIlllIIIIlIllI;
        llllllllllllllllIIIIlllIIIIlIllI.info = llllllllllllllllIIIIlllIIIIllIII;
    }

    public InvalidAccessorException(IMixinContext llllllllllllllllIIIIlllIIIIIlIlI, String llllllllllllllllIIIIlllIIIIIllIl, Throwable llllllllllllllllIIIIlllIIIIIlIII) {
        super(llllllllllllllllIIIIlllIIIIIlIlI, llllllllllllllllIIIIlllIIIIIllIl, llllllllllllllllIIIIlllIIIIIlIII);
        InvalidAccessorException llllllllllllllllIIIIlllIIIIIllll;
        llllllllllllllllIIIIlllIIIIIllll.info = null;
    }

    public AccessorInfo getAccessorInfo() {
        InvalidAccessorException llllllllllllllllIIIIllIllllllIIl;
        return llllllllllllllllIIIIllIllllllIIl.info;
    }

    public InvalidAccessorException(IMixinContext llllllllllllllllIIIIlllIIIllIIII, String llllllllllllllllIIIIlllIIIllIIlI) {
        super(llllllllllllllllIIIIlllIIIllIIII, llllllllllllllllIIIIlllIIIllIIlI);
        InvalidAccessorException llllllllllllllllIIIIlllIIIllIIIl;
        llllllllllllllllIIIIlllIIIllIIIl.info = null;
    }

    public InvalidAccessorException(IMixinContext llllllllllllllllIIIIlllIIIIllllI, Throwable llllllllllllllllIIIIlllIIIIlllIl) {
        super(llllllllllllllllIIIIlllIIIIllllI, llllllllllllllllIIIIlllIIIIlllIl);
        InvalidAccessorException llllllllllllllllIIIIlllIIIlIIIlI;
        llllllllllllllllIIIIlllIIIlIIIlI.info = null;
    }

    public InvalidAccessorException(AccessorInfo llllllllllllllllIIIIllIllllllllI, String llllllllllllllllIIIIllIlllllllIl, Throwable llllllllllllllllIIIIlllIIIIIIIII) {
        super(llllllllllllllllIIIIllIllllllllI.getContext(), llllllllllllllllIIIIllIlllllllIl, llllllllllllllllIIIIlllIIIIIIIII);
        InvalidAccessorException llllllllllllllllIIIIllIlllllllll;
        llllllllllllllllIIIIllIlllllllll.info = llllllllllllllllIIIIllIllllllllI;
    }
}

