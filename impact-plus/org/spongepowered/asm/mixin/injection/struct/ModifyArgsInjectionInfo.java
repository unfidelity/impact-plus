/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.invoke.ModifyArgsInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

public class ModifyArgsInjectionInfo
extends InjectionInfo {
    @Override
    protected String getDescription() {
        return "Multi-argument modifier method";
    }

    @Override
    protected Injector parseInjector(AnnotationNode lllllllllllllllllllIllIIlIIllIlI) {
        ModifyArgsInjectionInfo lllllllllllllllllllIllIIlIIllIIl;
        return new ModifyArgsInjector(lllllllllllllllllllIllIIlIIllIIl);
    }

    public ModifyArgsInjectionInfo(MixinTargetContext lllllllllllllllllllIllIIlIlIIIll, MethodNode lllllllllllllllllllIllIIlIIllllI, AnnotationNode lllllllllllllllllllIllIIlIlIIIIl) {
        super(lllllllllllllllllllIllIIlIlIIIll, lllllllllllllllllllIllIIlIIllllI, lllllllllllllllllllIllIIlIlIIIIl);
        ModifyArgsInjectionInfo lllllllllllllllllllIllIIlIlIIlII;
    }
}

