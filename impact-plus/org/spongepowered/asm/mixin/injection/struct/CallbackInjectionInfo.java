/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.struct;

import com.google.common.base.Strings;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.callback.CallbackInjector;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.util.Annotations;

public class CallbackInjectionInfo
extends InjectionInfo {
    protected CallbackInjectionInfo(MixinTargetContext llllllllllllllllIllIlIIIIIIIIIll, MethodNode llllllllllllllllIllIIllllllllIll, AnnotationNode llllllllllllllllIllIIllllllllIIl) {
        super(llllllllllllllllIllIlIIIIIIIIIll, llllllllllllllllIllIIllllllllIll, llllllllllllllllIllIIllllllllIIl);
        CallbackInjectionInfo llllllllllllllllIllIlIIIIIIIIlIl;
    }

    @Override
    public String getSliceId(String llllllllllllllllIllIIlllllIlIlll) {
        return Strings.nullToEmpty((String)llllllllllllllllIllIIlllllIlIlll);
    }

    @Override
    protected Injector parseInjector(AnnotationNode llllllllllllllllIllIIllllllIIIlI) {
        CallbackInjectionInfo llllllllllllllllIllIIllllllIIIll;
        boolean llllllllllllllllIllIIllllllIllIl = Annotations.getValue(llllllllllllllllIllIIllllllIIIlI, "cancellable", Boolean.FALSE);
        LocalCapture llllllllllllllllIllIIllllllIIllI = Annotations.getValue(llllllllllllllllIllIIllllllIIIlI, "locals", LocalCapture.class, LocalCapture.NO_CAPTURE);
        String llllllllllllllllIllIIllllllIIlII = Annotations.getValue(llllllllllllllllIllIIllllllIIIlI, "id", "");
        return new CallbackInjector(llllllllllllllllIllIIllllllIIIll, llllllllllllllllIllIIllllllIllIl, llllllllllllllllIllIIllllllIIllI, llllllllllllllllIllIIllllllIIlII);
    }
}

