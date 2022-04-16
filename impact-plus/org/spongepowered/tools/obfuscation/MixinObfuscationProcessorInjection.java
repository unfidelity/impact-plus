/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.lang.annotation.Annotation;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.tools.obfuscation.MixinObfuscationProcessor;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

@SupportedAnnotationTypes(value={"org.spongepowered.asm.mixin.injection.Inject", "org.spongepowered.asm.mixin.injection.ModifyArg", "org.spongepowered.asm.mixin.injection.ModifyArgs", "org.spongepowered.asm.mixin.injection.Redirect", "org.spongepowered.asm.mixin.injection.At"})
public class MixinObfuscationProcessorInjection
extends MixinObfuscationProcessor {
    public MixinObfuscationProcessorInjection() {
        MixinObfuscationProcessorInjection llIllIlIlllll;
    }

    @Override
    public boolean process(Set<? extends TypeElement> llIllIlIIIIll, RoundEnvironment llIllIlIIIIlI) {
        MixinObfuscationProcessorInjection llIllIlIIIlIl;
        if (llIllIlIIIIlI.processingOver()) {
            llIllIlIIIlIl.postProcess(llIllIlIIIIlI);
            return true;
        }
        llIllIlIIIlIl.processMixins(llIllIlIIIIlI);
        llIllIlIIIlIl.processInjectors(llIllIlIIIIlI, Inject.class);
        llIllIlIIIlIl.processInjectors(llIllIlIIIIlI, ModifyArg.class);
        llIllIlIIIlIl.processInjectors(llIllIlIIIIlI, ModifyArgs.class);
        llIllIlIIIlIl.processInjectors(llIllIlIIIIlI, Redirect.class);
        llIllIlIIIlIl.processInjectors(llIllIlIIIIlI, ModifyVariable.class);
        llIllIlIIIlIl.processInjectors(llIllIlIIIIlI, ModifyConstant.class);
        llIllIlIIIlIl.postProcess(llIllIlIIIIlI);
        return true;
    }

    private void processInjectors(RoundEnvironment llIllIIIllIlI, Class<? extends Annotation> llIllIIIlIllI) {
        for (Element element : llIllIIIllIlI.getElementsAnnotatedWith(llIllIIIlIllI)) {
            MixinObfuscationProcessorInjection llIllIIIllIII;
            Element llIllIIIllllI = element.getEnclosingElement();
            if (!(llIllIIIllllI instanceof TypeElement)) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("@").append(llIllIIIlIllI.getSimpleName()).append(" element has unexpected parent with type ").append(TypeUtils.getElementType(llIllIIIllllI))));
            }
            AnnotationHandle llIllIIIlllIl = AnnotationHandle.of(element, llIllIIIlIllI);
            if (element.getKind() == ElementKind.METHOD) {
                llIllIIIllIII.mixins.registerInjector((TypeElement)llIllIIIllllI, (ExecutableElement)element, llIllIIIlllIl);
                continue;
            }
            llIllIIIllIII.mixins.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Found an @").append(llIllIIIlIllI.getSimpleName()).append(" annotation on an element which is not a method: ").append(element.toString())));
        }
    }

    @Override
    protected void postProcess(RoundEnvironment llIllIIllIIlI) {
        MixinObfuscationProcessorInjection llIllIIllIlIl;
        super.postProcess(llIllIIllIIlI);
        try {
            llIllIIllIlIl.mixins.writeReferences();
        }
        catch (Exception llIllIIlllIIl) {
            llIllIIlllIIl.printStackTrace();
        }
    }
}

