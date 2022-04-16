/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.throwables;

import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

public class MixinTargetAlreadyLoadedException
extends InvalidMixinException {
    private static final /* synthetic */ long serialVersionUID = 1L;
    private final /* synthetic */ String target;

    public MixinTargetAlreadyLoadedException(IMixinInfo llllIllIIllllII, String llllIllIlIIIIII, String llllIllIIlllIlI, Throwable llllIllIIlllIIl) {
        super(llllIllIIllllII, llllIllIlIIIIII, llllIllIIlllIIl);
        MixinTargetAlreadyLoadedException llllIllIlIIIIlI;
        llllIllIlIIIIlI.target = llllIllIIlllIlI;
    }

    public MixinTargetAlreadyLoadedException(IMixinInfo llllIllIlIIlIlI, String llllIllIlIIllIl, String llllIllIlIIllII) {
        super(llllIllIlIIlIlI, llllIllIlIIllIl);
        MixinTargetAlreadyLoadedException llllIllIlIIlIll;
        llllIllIlIIlIll.target = llllIllIlIIllII;
    }

    public String getTarget() {
        MixinTargetAlreadyLoadedException llllIllIIllIllI;
        return llllIllIIllIllI.target;
    }
}

