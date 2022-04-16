/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.tools.obfuscation.MixinObfuscationProcessor;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

@SupportedAnnotationTypes(value={"org.spongepowered.asm.mixin.Mixin", "org.spongepowered.asm.mixin.Shadow", "org.spongepowered.asm.mixin.Overwrite", "org.spongepowered.asm.mixin.gen.Accessor", "org.spongepowered.asm.mixin.Implements"})
public class MixinObfuscationProcessorTargets
extends MixinObfuscationProcessor {
    private void processInvokers(RoundEnvironment lllllllllllllllllIllIllIIIIllIll) {
        for (Element element : lllllllllllllllllIllIllIIIIllIll.getElementsAnnotatedWith(Invoker.class)) {
            MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIIIllllI;
            Element lllllllllllllllllIllIllIIIlIIIII = element.getEnclosingElement();
            if (!(lllllllllllllllllIllIllIIIlIIIII instanceof TypeElement)) {
                lllllllllllllllllIllIllIIIIllllI.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Unexpected parent with type ").append(TypeUtils.getElementType(lllllllllllllllllIllIllIIIlIIIII))), element);
                continue;
            }
            if (element.getKind() == ElementKind.METHOD) {
                lllllllllllllllllIllIllIIIIllllI.mixins.registerInvoker((TypeElement)lllllllllllllllllIllIllIIIlIIIII, (ExecutableElement)element);
                continue;
            }
            lllllllllllllllllIllIllIIIIllllI.mixins.printMessage(Diagnostic.Kind.ERROR, "Element is not a method", element);
        }
    }

    public MixinObfuscationProcessorTargets() {
        MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIllIIlII;
    }

    @Override
    public boolean process(Set<? extends TypeElement> lllllllllllllllllIllIllIIlIlllll, RoundEnvironment lllllllllllllllllIllIllIIlIllllI) {
        MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIllIIIII;
        if (lllllllllllllllllIllIllIIlIllllI.processingOver()) {
            lllllllllllllllllIllIllIIllIIIII.postProcess(lllllllllllllllllIllIllIIlIllllI);
            return true;
        }
        lllllllllllllllllIllIllIIllIIIII.processMixins(lllllllllllllllllIllIllIIlIllllI);
        lllllllllllllllllIllIllIIllIIIII.processShadows(lllllllllllllllllIllIllIIlIllllI);
        lllllllllllllllllIllIllIIllIIIII.processOverwrites(lllllllllllllllllIllIllIIlIllllI);
        lllllllllllllllllIllIllIIllIIIII.processAccessors(lllllllllllllllllIllIllIIlIllllI);
        lllllllllllllllllIllIllIIllIIIII.processInvokers(lllllllllllllllllIllIllIIlIllllI);
        lllllllllllllllllIllIllIIllIIIII.processImplements(lllllllllllllllllIllIllIIlIllllI);
        lllllllllllllllllIllIllIIllIIIII.postProcess(lllllllllllllllllIllIllIIlIllllI);
        return true;
    }

    private void processAccessors(RoundEnvironment lllllllllllllllllIllIllIIIlIlIll) {
        for (Element element : lllllllllllllllllIllIllIIIlIlIll.getElementsAnnotatedWith(Accessor.class)) {
            MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIIlIllII;
            Element lllllllllllllllllIllIllIIIlIlllI = element.getEnclosingElement();
            if (!(lllllllllllllllllIllIllIIIlIlllI instanceof TypeElement)) {
                lllllllllllllllllIllIllIIIlIllII.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Unexpected parent with type ").append(TypeUtils.getElementType(lllllllllllllllllIllIllIIIlIlllI))), element);
                continue;
            }
            if (element.getKind() == ElementKind.METHOD) {
                lllllllllllllllllIllIllIIIlIllII.mixins.registerAccessor((TypeElement)lllllllllllllllllIllIllIIIlIlllI, (ExecutableElement)element);
                continue;
            }
            lllllllllllllllllIllIllIIIlIllII.mixins.printMessage(Diagnostic.Kind.ERROR, "Element is not a method", element);
        }
    }

    private void processOverwrites(RoundEnvironment lllllllllllllllllIllIllIIIllIlll) {
        for (Element element : lllllllllllllllllIllIllIIIllIlll.getElementsAnnotatedWith(Overwrite.class)) {
            MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIIlllIII;
            Element lllllllllllllllllIllIllIIIllllII = element.getEnclosingElement();
            if (!(lllllllllllllllllIllIllIIIllllII instanceof TypeElement)) {
                lllllllllllllllllIllIllIIIlllIII.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Unexpected parent with type ").append(TypeUtils.getElementType(lllllllllllllllllIllIllIIIllllII))), element);
                continue;
            }
            if (element.getKind() == ElementKind.METHOD) {
                lllllllllllllllllIllIllIIIlllIII.mixins.registerOverwrite((TypeElement)lllllllllllllllllIllIllIIIllllII, (ExecutableElement)element);
                continue;
            }
            lllllllllllllllllIllIllIIIlllIII.mixins.printMessage(Diagnostic.Kind.ERROR, "Element is not a method", element);
        }
    }

    @Override
    protected void postProcess(RoundEnvironment lllllllllllllllllIllIllIIlIlIllI) {
        MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIlIlIlll;
        super.postProcess(lllllllllllllllllIllIllIIlIlIllI);
        try {
            lllllllllllllllllIllIllIIlIlIlll.mixins.writeReferences();
            lllllllllllllllllIllIllIIlIlIlll.mixins.writeMappings();
        }
        catch (Exception lllllllllllllllllIllIllIIlIllIII) {
            lllllllllllllllllIllIllIIlIllIII.printStackTrace();
        }
    }

    private void processImplements(RoundEnvironment lllllllllllllllllIllIllIIIIIllIl) {
        for (Element element : lllllllllllllllllIllIllIIIIIllIl.getElementsAnnotatedWith(Implements.class)) {
            MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIIIlIIII;
            if (element.getKind() == ElementKind.CLASS || element.getKind() == ElementKind.INTERFACE) {
                AnnotationHandle lllllllllllllllllIllIllIIIIlIIlI = AnnotationHandle.of(element, Implements.class);
                lllllllllllllllllIllIllIIIIlIIII.mixins.registerSoftImplements((TypeElement)element, lllllllllllllllllIllIllIIIIlIIlI);
                continue;
            }
            lllllllllllllllllIllIllIIIIlIIII.mixins.printMessage(Diagnostic.Kind.ERROR, "Found an @Implements annotation on an element which is not a class or interface", element);
        }
    }

    private void processShadows(RoundEnvironment lllllllllllllllllIllIllIIlIIlIII) {
        for (Element element : lllllllllllllllllIllIllIIlIIlIII.getElementsAnnotatedWith(Shadow.class)) {
            MixinObfuscationProcessorTargets lllllllllllllllllIllIllIIlIIIlll;
            Element lllllllllllllllllIllIllIIlIIllII = element.getEnclosingElement();
            if (!(lllllllllllllllllIllIllIIlIIllII instanceof TypeElement)) {
                lllllllllllllllllIllIllIIlIIIlll.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Unexpected parent with type ").append(TypeUtils.getElementType(lllllllllllllllllIllIllIIlIIllII))), element);
                continue;
            }
            AnnotationHandle lllllllllllllllllIllIllIIlIIlIll = AnnotationHandle.of(element, Shadow.class);
            if (element.getKind() == ElementKind.FIELD) {
                lllllllllllllllllIllIllIIlIIIlll.mixins.registerShadow((TypeElement)lllllllllllllllllIllIllIIlIIllII, (VariableElement)element, lllllllllllllllllIllIllIIlIIlIll);
                continue;
            }
            if (element.getKind() == ElementKind.METHOD) {
                lllllllllllllllllIllIllIIlIIIlll.mixins.registerShadow((TypeElement)lllllllllllllllllIllIllIIlIIllII, (ExecutableElement)element, lllllllllllllllllIllIllIIlIIlIll);
                continue;
            }
            lllllllllllllllllIllIllIIlIIIlll.mixins.printMessage(Diagnostic.Kind.ERROR, "Element is not a method or field", element);
        }
    }
}

