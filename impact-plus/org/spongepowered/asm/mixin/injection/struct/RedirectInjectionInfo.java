/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.invoke.RedirectInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

public class RedirectInjectionInfo
extends InjectionInfo {
    public RedirectInjectionInfo(MixinTargetContext lllllllllllllllllIlIIIIlllIIlllI, MethodNode lllllllllllllllllIlIIIIlllIIIlIl, AnnotationNode lllllllllllllllllIlIIIIlllIIIIll) {
        super(lllllllllllllllllIlIIIIlllIIlllI, lllllllllllllllllIlIIIIlllIIIlIl, lllllllllllllllllIlIIIIlllIIIIll);
        RedirectInjectionInfo lllllllllllllllllIlIIIIlllIIllll;
    }

    @Override
    protected Injector parseInjector(AnnotationNode lllllllllllllllllIlIIIIlllIIIIII) {
        RedirectInjectionInfo lllllllllllllllllIlIIIIllIllllll;
        return new RedirectInjector(lllllllllllllllllIlIIIIllIllllll);
    }

    @Override
    protected String getDescription() {
        return "Redirector";
    }
}

