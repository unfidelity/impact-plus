/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.throwables;

import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.throwables.MixinException;

public class MixinReloadException
extends MixinException {
    private static final /* synthetic */ long serialVersionUID = 2L;
    private final /* synthetic */ IMixinInfo mixinInfo;

    public IMixinInfo getMixinInfo() {
        MixinReloadException llllIIIllIlIll;
        return llllIIIllIlIll.mixinInfo;
    }

    public MixinReloadException(IMixinInfo llllIIIllIlllI, String llllIIIllIllIl) {
        super(llllIIIllIllIl);
        MixinReloadException llllIIIlllIIlI;
        llllIIIlllIIlI.mixinInfo = llllIIIllIlllI;
    }
}

