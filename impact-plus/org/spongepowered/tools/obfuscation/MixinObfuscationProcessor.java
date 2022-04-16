/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.tools.obfuscation.AnnotatedMixins;
import org.spongepowered.tools.obfuscation.SupportedOptions;

public abstract class MixinObfuscationProcessor
extends AbstractProcessor {
    protected /* synthetic */ AnnotatedMixins mixins;

    @Override
    public synchronized void init(ProcessingEnvironment lllllllllllllllllllIIIIIIIIllllI) {
        MixinObfuscationProcessor lllllllllllllllllllIIIIIIIIlllll;
        super.init(lllllllllllllllllllIIIIIIIIllllI);
        lllllllllllllllllllIIIIIIIIlllll.mixins = AnnotatedMixins.getMixinsForEnvironment(lllllllllllllllllllIIIIIIIIllllI);
    }

    public MixinObfuscationProcessor() {
        MixinObfuscationProcessor lllllllllllllllllllIIIIIIIlIIlIl;
    }

    protected void processMixins(RoundEnvironment lllllllllllllllllllIIIIIIIIlIlIl) {
        MixinObfuscationProcessor lllllllllllllllllllIIIIIIIIllIII;
        lllllllllllllllllllIIIIIIIIllIII.mixins.onPassStarted();
        for (Element element : lllllllllllllllllllIIIIIIIIlIlIl.getElementsAnnotatedWith(Mixin.class)) {
            if (element.getKind() == ElementKind.CLASS || element.getKind() == ElementKind.INTERFACE) {
                lllllllllllllllllllIIIIIIIIllIII.mixins.registerMixin((TypeElement)element);
                continue;
            }
            lllllllllllllllllllIIIIIIIIllIII.mixins.printMessage(Diagnostic.Kind.ERROR, "Found an @Mixin annotation on an element which is not a class or interface", element);
        }
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        try {
            return SourceVersion.valueOf("RELEASE_8");
        }
        catch (IllegalArgumentException lllllllllllllllllllIIIIIIIIIlIII) {
            MixinObfuscationProcessor lllllllllllllllllllIIIIIIIIIlIIl;
            return super.getSupportedSourceVersion();
        }
    }

    protected void postProcess(RoundEnvironment lllllllllllllllllllIIIIIIIIIllIl) {
        MixinObfuscationProcessor lllllllllllllllllllIIIIIIIIlIIII;
        lllllllllllllllllllIIIIIIIIlIIII.mixins.onPassCompleted(lllllllllllllllllllIIIIIIIIIllIl);
    }

    @Override
    public Set<String> getSupportedOptions() {
        return SupportedOptions.getAllOptions();
    }
}

