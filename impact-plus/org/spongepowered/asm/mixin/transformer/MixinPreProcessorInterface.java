/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.MixinPreProcessorStandard;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidInterfaceMixinException;
import org.spongepowered.asm.util.Bytecode;

class MixinPreProcessorInterface
extends MixinPreProcessorStandard {
    @Override
    protected boolean validateField(MixinTargetContext lllllllllllllllllIIlIIlIIIllIlIl, FieldNode lllllllllllllllllIIlIIlIIIlllIll, AnnotationNode lllllllllllllllllIIlIIlIIIlllIIl) {
        MixinPreProcessorInterface lllllllllllllllllIIlIIlIIIllIlll;
        if (!Bytecode.hasFlag(lllllllllllllllllIIlIIlIIIlllIll, 8)) {
            throw new InvalidInterfaceMixinException((IMixinInfo)lllllllllllllllllIIlIIlIIIllIlll.mixin, String.valueOf(new StringBuilder().append("Interface mixin contains an instance field! Found ").append(lllllllllllllllllIIlIIlIIIlllIll.name).append(" in ").append(lllllllllllllllllIIlIIlIIIllIlll.mixin)));
        }
        return super.validateField(lllllllllllllllllIIlIIlIIIllIlIl, lllllllllllllllllIIlIIlIIIlllIll, lllllllllllllllllIIlIIlIIIlllIIl);
    }

    @Override
    protected void prepareMethod(MixinInfo.MixinMethodNode lllllllllllllllllIIlIIlIIlIIlllI, ClassInfo.Method lllllllllllllllllIIlIIlIIlIIllII) {
        MixinPreProcessorInterface lllllllllllllllllIIlIIlIIlIlIIII;
        if (!Bytecode.hasFlag(lllllllllllllllllIIlIIlIIlIIlllI, 1) && !Bytecode.hasFlag(lllllllllllllllllIIlIIlIIlIIlllI, 4096)) {
            throw new InvalidInterfaceMixinException((IMixinInfo)lllllllllllllllllIIlIIlIIlIlIIII.mixin, String.valueOf(new StringBuilder().append("Interface mixin contains a non-public method! Found ").append(lllllllllllllllllIIlIIlIIlIIllII).append(" in ").append(lllllllllllllllllIIlIIlIIlIlIIII.mixin)));
        }
        super.prepareMethod(lllllllllllllllllIIlIIlIIlIIlllI, lllllllllllllllllIIlIIlIIlIIllII);
    }

    MixinPreProcessorInterface(MixinInfo lllllllllllllllllIIlIIlIIlIllIII, MixinInfo.MixinClassNode lllllllllllllllllIIlIIlIIlIlIlll) {
        super(lllllllllllllllllIIlIIlIIlIllIII, lllllllllllllllllIIlIIlIIlIlIlll);
        MixinPreProcessorInterface lllllllllllllllllIIlIIlIIlIlllII;
    }
}

