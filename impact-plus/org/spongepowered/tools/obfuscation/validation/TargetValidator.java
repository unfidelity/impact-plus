/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.validation;

import java.util.Collection;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.tools.obfuscation.MixinValidator;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IMixinValidator;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

public class TargetValidator
extends MixinValidator {
    private boolean checkMixinsFor(TypeMirror lllllllllllllllIllIlIlllIIlIllII, TypeMirror lllllllllllllllIllIlIlllIIlIlIII) {
        TargetValidator lllllllllllllllIllIlIlllIIlIllIl;
        for (TypeMirror lllllllllllllllIllIlIlllIIlIlllI : lllllllllllllllIllIlIlllIIlIllIl.getMixinsTargeting(lllllllllllllllIllIlIlllIIlIllII)) {
            if (!TypeUtils.isAssignable(lllllllllllllllIllIlIlllIIlIllIl.processingEnv, lllllllllllllllIllIlIlllIIlIlllI, lllllllllllllllIllIlIlllIIlIlIII)) continue;
            return true;
        }
        return false;
    }

    private void validateInterfaceMixin(TypeElement lllllllllllllllIllIlIlllIllIlIlI, Collection<TypeHandle> lllllllllllllllIllIlIlllIllIIlIl) {
        boolean lllllllllllllllIllIlIlllIllIlIII = false;
        for (Element element : lllllllllllllllIllIlIlllIllIlIlI.getEnclosedElements()) {
            if (element.getKind() != ElementKind.METHOD) continue;
            boolean lllllllllllllllIllIlIlllIlllIIII = AnnotationHandle.of(element, Accessor.class).exists();
            boolean lllllllllllllllIllIlIlllIllIllll = AnnotationHandle.of(element, Invoker.class).exists();
            lllllllllllllllIllIlIlllIllIlIII |= !lllllllllllllllIllIlIlllIlllIIII && !lllllllllllllllIllIlIlllIllIllll;
        }
        if (!lllllllllllllllIllIlIlllIllIlIII) {
            return;
        }
        for (TypeHandle typeHandle : lllllllllllllllIllIlIlllIllIIlIl) {
            TargetValidator lllllllllllllllIllIlIlllIllIlIll;
            TypeElement lllllllllllllllIllIlIlllIllIllIl = typeHandle.getElement();
            if (lllllllllllllllIllIlIlllIllIllIl == null || lllllllllllllllIllIlIlllIllIllIl.getKind() == ElementKind.INTERFACE) continue;
            lllllllllllllllIllIlIlllIllIlIll.error(String.valueOf(new StringBuilder().append("Targetted type '").append(typeHandle).append(" of ").append(lllllllllllllllIllIlIlllIllIlIlI).append(" is not an interface")), lllllllllllllllIllIlIlllIllIlIlI);
        }
    }

    public TargetValidator(IMixinAnnotationProcessor lllllllllllllllIllIlIllllIlIlllI) {
        super(lllllllllllllllIllIlIllllIlIlllI, IMixinValidator.ValidationPass.LATE);
        TargetValidator lllllllllllllllIllIlIllllIlIllll;
    }

    @Override
    public boolean validate(TypeElement lllllllllllllllIllIlIllllIIlIlII, AnnotationHandle lllllllllllllllIllIlIllllIIlIIIl, Collection<TypeHandle> lllllllllllllllIllIlIllllIIIllll) {
        TargetValidator lllllllllllllllIllIlIllllIIIlllI;
        if ("true".equalsIgnoreCase(lllllllllllllllIllIlIllllIIIlllI.options.getOption("disableTargetValidator"))) {
            return true;
        }
        if (lllllllllllllllIllIlIllllIIlIlII.getKind() == ElementKind.INTERFACE) {
            lllllllllllllllIllIlIllllIIIlllI.validateInterfaceMixin(lllllllllllllllIllIlIllllIIlIlII, lllllllllllllllIllIlIllllIIIllll);
        } else {
            lllllllllllllllIllIlIllllIIIlllI.validateClassMixin(lllllllllllllllIllIlIllllIIlIlII, lllllllllllllllIllIlIllllIIIllll);
        }
        return true;
    }

    private boolean validateSuperClass(TypeMirror lllllllllllllllIllIlIlllIlIIIlII, TypeMirror lllllllllllllllIllIlIlllIlIIIllI) {
        TargetValidator lllllllllllllllIllIlIlllIlIIlIII;
        if (TypeUtils.isAssignable(lllllllllllllllIllIlIlllIlIIlIII.processingEnv, lllllllllllllllIllIlIlllIlIIIlII, lllllllllllllllIllIlIlllIlIIIllI)) {
            return true;
        }
        return lllllllllllllllIllIlIlllIlIIlIII.validateSuperClassRecursive(lllllllllllllllIllIlIlllIlIIIlII, lllllllllllllllIllIlIlllIlIIIllI);
    }

    private void validateClassMixin(TypeElement lllllllllllllllIllIlIlllIlIlIlIl, Collection<TypeHandle> lllllllllllllllIllIlIlllIlIlIIII) {
        TypeMirror lllllllllllllllIllIlIlllIlIlIIll = lllllllllllllllIllIlIlllIlIlIlIl.getSuperclass();
        for (TypeHandle lllllllllllllllIllIlIlllIlIlIlll : lllllllllllllllIllIlIlllIlIlIIII) {
            TargetValidator lllllllllllllllIllIlIlllIlIlIIlI;
            TypeMirror lllllllllllllllIllIlIlllIlIllIII = lllllllllllllllIllIlIlllIlIlIlll.getType();
            if (lllllllllllllllIllIlIlllIlIllIII == null || lllllllllllllllIllIlIlllIlIlIIlI.validateSuperClass(lllllllllllllllIllIlIlllIlIllIII, lllllllllllllllIllIlIlllIlIlIIll)) continue;
            lllllllllllllllIllIlIlllIlIlIIlI.error(String.valueOf(new StringBuilder().append("Superclass ").append(lllllllllllllllIllIlIlllIlIlIIll).append(" of ").append(lllllllllllllllIllIlIlllIlIlIlIl).append(" was not found in the hierarchy of target class ").append(lllllllllllllllIllIlIlllIlIllIII)), lllllllllllllllIllIlIlllIlIlIlIl);
        }
    }

    private boolean validateSuperClassRecursive(TypeMirror lllllllllllllllIllIlIlllIIllIlll, TypeMirror lllllllllllllllIllIlIlllIIlllIll) {
        TargetValidator lllllllllllllllIllIlIlllIIlllIII;
        if (!(lllllllllllllllIllIlIlllIIllIlll instanceof DeclaredType)) {
            return false;
        }
        if (TypeUtils.isAssignable(lllllllllllllllIllIlIlllIIlllIII.processingEnv, lllllllllllllllIllIlIlllIIllIlll, lllllllllllllllIllIlIlllIIlllIll)) {
            return true;
        }
        TypeElement lllllllllllllllIllIlIlllIIlllIlI = (TypeElement)((DeclaredType)lllllllllllllllIllIlIlllIIllIlll).asElement();
        TypeMirror lllllllllllllllIllIlIlllIIlllIIl = lllllllllllllllIllIlIlllIIlllIlI.getSuperclass();
        if (lllllllllllllllIllIlIlllIIlllIIl.getKind() == TypeKind.NONE) {
            return false;
        }
        if (lllllllllllllllIllIlIlllIIlllIII.checkMixinsFor(lllllllllllllllIllIlIlllIIlllIIl, lllllllllllllllIllIlIlllIIlllIll)) {
            return true;
        }
        return lllllllllllllllIllIlIlllIIlllIII.validateSuperClassRecursive(lllllllllllllllIllIlIlllIIlllIIl, lllllllllllllllIllIlIlllIIlllIll);
    }
}

