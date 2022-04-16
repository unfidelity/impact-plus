/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.validation;

import java.util.Collection;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import org.spongepowered.tools.obfuscation.MixinValidator;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IMixinValidator;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public class ParentValidator
extends MixinValidator {
    @Override
    public boolean validate(TypeElement llllllllllllllllIlIIIIIIIlIllIII, AnnotationHandle llllllllllllllllIlIIIIIIIlIlIlll, Collection<TypeHandle> llllllllllllllllIlIIIIIIIlIlIllI) {
        if (llllllllllllllllIlIIIIIIIlIllIII.getEnclosingElement().getKind() != ElementKind.PACKAGE && !llllllllllllllllIlIIIIIIIlIllIII.getModifiers().contains((Object)Modifier.STATIC)) {
            ParentValidator llllllllllllllllIlIIIIIIIlIllIIl;
            llllllllllllllllIlIIIIIIIlIllIIl.error("Inner class mixin must be declared static", llllllllllllllllIlIIIIIIIlIllIII);
        }
        return true;
    }

    public ParentValidator(IMixinAnnotationProcessor llllllllllllllllIlIIIIIIIllIIlII) {
        super(llllllllllllllllIlIIIIIIIllIIlII, IMixinValidator.ValidationPass.EARLY);
        ParentValidator llllllllllllllllIlIIIIIIIllIIllI;
    }
}

