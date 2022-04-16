/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.invoke.ModifyArgInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.util.Annotations;

public class ModifyArgInjectionInfo
extends InjectionInfo {
    public ModifyArgInjectionInfo(MixinTargetContext llllllllllllllllllIlllIlIlllIllI, MethodNode llllllllllllllllllIlllIlIlllIlIl, AnnotationNode llllllllllllllllllIlllIlIllllIII) {
        super(llllllllllllllllllIlllIlIlllIllI, llllllllllllllllllIlllIlIlllIlIl, llllllllllllllllllIlllIlIllllIII);
        ModifyArgInjectionInfo llllllllllllllllllIlllIlIllllIll;
    }

    @Override
    protected Injector parseInjector(AnnotationNode llllllllllllllllllIlllIlIllIllll) {
        ModifyArgInjectionInfo llllllllllllllllllIlllIlIlllIIII;
        int llllllllllllllllllIlllIlIllIlllI = Annotations.getValue(llllllllllllllllllIlllIlIllIllll, "index", -1);
        return new ModifyArgInjector((InjectionInfo)llllllllllllllllllIlllIlIlllIIII, llllllllllllllllllIlllIlIllIlllI);
    }

    @Override
    protected String getDescription() {
        return "Argument modifier method";
    }
}

