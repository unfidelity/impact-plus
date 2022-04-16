/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.modify.LocalVariableDiscriminator;
import org.spongepowered.asm.mixin.injection.modify.ModifyVariableInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

public class ModifyVariableInjectionInfo
extends InjectionInfo {
    public ModifyVariableInjectionInfo(MixinTargetContext llIllIIIIllIIII, MethodNode llIllIIIIllIIll, AnnotationNode llIllIIIIllIIlI) {
        super(llIllIIIIllIIII, llIllIIIIllIIll, llIllIIIIllIIlI);
        ModifyVariableInjectionInfo llIllIIIIllIIIl;
    }

    @Override
    protected String getDescription() {
        return "Variable modifier method";
    }

    @Override
    protected Injector parseInjector(AnnotationNode llIllIIIIlIlIII) {
        ModifyVariableInjectionInfo llIllIIIIlIlIll;
        return new ModifyVariableInjector(llIllIIIIlIlIll, LocalVariableDiscriminator.parse(llIllIIIIlIlIII));
    }
}

