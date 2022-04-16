/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.throwables;

import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.throwables.MixinException;

public class InvalidMixinException
extends MixinException {
    private final /* synthetic */ IMixinInfo mixin;
    private static final /* synthetic */ long serialVersionUID = 2L;

    public InvalidMixinException(IMixinContext lIllIllIIlIlll, Throwable lIllIllIIlIIll) {
        lIllIllIIllIII(lIllIllIIlIlll.getMixin(), lIllIllIIlIIll);
        InvalidMixinException lIllIllIIllIII;
    }

    public InvalidMixinException(IMixinContext lIllIllIlIllll, String lIllIllIlIlllI) {
        lIllIllIllIIII(lIllIllIlIllll.getMixin(), lIllIllIlIlllI);
        InvalidMixinException lIllIllIllIIII;
    }

    public InvalidMixinException(IMixinInfo lIllIllIIIllIl, String lIllIllIIIlIII, Throwable lIllIllIIIlIll) {
        super(lIllIllIIIlIII, lIllIllIIIlIll);
        InvalidMixinException lIllIllIIIlllI;
        lIllIllIIIlllI.mixin = lIllIllIIIllIl;
    }

    public InvalidMixinException(IMixinContext lIllIlIlllllIl, String lIllIlIlllllII, Throwable lIllIlIlllllll) {
        super(lIllIlIlllllII, lIllIlIlllllll);
        InvalidMixinException lIllIllIIIIIlI;
        lIllIllIIIIIlI.mixin = lIllIlIlllllIl.getMixin();
    }

    public InvalidMixinException(IMixinInfo lIllIllIllllII, String lIllIllIllIlll) {
        super(lIllIllIllIlll);
        InvalidMixinException lIllIllIlllIIl;
        lIllIllIlllIIl.mixin = lIllIllIllllII;
    }

    public IMixinInfo getMixin() {
        InvalidMixinException lIllIlIllllIIl;
        return lIllIlIllllIIl.mixin;
    }

    public InvalidMixinException(IMixinInfo lIllIllIIlllIl, Throwable lIllIllIIlllll) {
        super(lIllIllIIlllll);
        InvalidMixinException lIllIllIlIIIIl;
        lIllIllIlIIIIl.mixin = lIllIllIIlllIl;
    }
}

