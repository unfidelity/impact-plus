/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.injection.code.ISliceContext;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;

public class InvalidSliceException
extends InvalidInjectionException {
    private static final /* synthetic */ long serialVersionUID = 1L;

    public InvalidSliceException(ISliceContext llIllIIIIllllII, String llIllIIIIlllIll, Throwable llIllIIIIlllIlI) {
        super(llIllIIIIllllII.getContext(), llIllIIIIlllIll, llIllIIIIlllIlI);
        InvalidSliceException llIllIIIlIIIIIl;
    }

    public InvalidSliceException(IMixinContext llIllIIIllIlllI, String llIllIIIlllIIII) {
        super(llIllIIIllIlllI, llIllIIIlllIIII);
        InvalidSliceException llIllIIIlllIIlI;
    }

    public InvalidSliceException(ISliceContext llIllIIIllIlIII, String llIllIIIllIIlll) {
        super(llIllIIIllIlIII.getContext(), llIllIIIllIIlll);
        InvalidSliceException llIllIIIllIlIIl;
    }

    public InvalidSliceException(IMixinContext llIllIIIlIIlIII, String llIllIIIlIIIlll, Throwable llIllIIIlIIIllI) {
        super(llIllIIIlIIlIII, llIllIIIlIIIlll, llIllIIIlIIIllI);
        InvalidSliceException llIllIIIlIIlIIl;
    }

    public InvalidSliceException(ISliceContext llIllIIIlIlIIll, Throwable llIllIIIlIlIlIl) {
        super(llIllIIIlIlIIll.getContext(), llIllIIIlIlIlIl);
        InvalidSliceException llIllIIIlIlIlII;
    }

    public InvalidSliceException(IMixinContext llIllIIIlIlllll, Throwable llIllIIIlIllllI) {
        super(llIllIIIlIlllll, llIllIIIlIllllI);
        InvalidSliceException llIllIIIlIlllIl;
    }
}

