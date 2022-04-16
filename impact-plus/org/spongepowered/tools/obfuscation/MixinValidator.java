/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.Collection;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.spongepowered.tools.obfuscation.AnnotatedMixins;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IMixinValidator;
import org.spongepowered.tools.obfuscation.interfaces.IOptionProvider;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public abstract class MixinValidator
implements IMixinValidator {
    protected final /* synthetic */ IOptionProvider options;
    protected final /* synthetic */ IMixinValidator.ValidationPass pass;
    protected final /* synthetic */ ProcessingEnvironment processingEnv;
    protected final /* synthetic */ Messager messager;

    protected final Collection<TypeMirror> getMixinsTargeting(TypeMirror lllllllllllllllIllIlllllllIlIlII) {
        MixinValidator lllllllllllllllIllIlllllllIlIlIl;
        return AnnotatedMixins.getMixinsForEnvironment(lllllllllllllllIllIlllllllIlIlIl.processingEnv).getMixinsTargeting(lllllllllllllllIllIlllllllIlIlII);
    }

    protected final void warning(String lllllllllllllllIllIllllllllIIlIl, Element lllllllllllllllIllIllllllllIIIIl) {
        MixinValidator lllllllllllllllIllIllllllllIIllI;
        lllllllllllllllIllIllllllllIIllI.messager.printMessage(Diagnostic.Kind.WARNING, lllllllllllllllIllIllllllllIIlIl, lllllllllllllllIllIllllllllIIIIl);
    }

    public MixinValidator(IMixinAnnotationProcessor lllllllllllllllIlllIIIIIIIIIIllI, IMixinValidator.ValidationPass lllllllllllllllIlllIIIIIIIIIlIII) {
        MixinValidator lllllllllllllllIlllIIIIIIIIIlIlI;
        lllllllllllllllIlllIIIIIIIIIlIlI.processingEnv = lllllllllllllllIlllIIIIIIIIIIllI.getProcessingEnvironment();
        lllllllllllllllIlllIIIIIIIIIlIlI.messager = lllllllllllllllIlllIIIIIIIIIIllI;
        lllllllllllllllIlllIIIIIIIIIlIlI.options = lllllllllllllllIlllIIIIIIIIIIllI;
        lllllllllllllllIlllIIIIIIIIIlIlI.pass = lllllllllllllllIlllIIIIIIIIIlIII;
    }

    @Override
    public final boolean validate(IMixinValidator.ValidationPass lllllllllllllllIllIllllllllllIIl, TypeElement lllllllllllllllIllIllllllllllIII, AnnotationHandle lllllllllllllllIllIlllllllllllII, Collection<TypeHandle> lllllllllllllllIllIllllllllllIll) {
        MixinValidator lllllllllllllllIllIlllllllllllll;
        if (lllllllllllllllIllIllllllllllIIl != lllllllllllllllIllIlllllllllllll.pass) {
            return true;
        }
        return lllllllllllllllIllIlllllllllllll.validate(lllllllllllllllIllIllllllllllIII, lllllllllllllllIllIlllllllllllII, lllllllllllllllIllIllllllllllIll);
    }

    protected final void error(String lllllllllllllllIllIlllllllIlllII, Element lllllllllllllllIllIlllllllIllIII) {
        MixinValidator lllllllllllllllIllIlllllllIllIlI;
        lllllllllllllllIllIlllllllIllIlI.messager.printMessage(Diagnostic.Kind.ERROR, lllllllllllllllIllIlllllllIlllII, lllllllllllllllIllIlllllllIllIII);
    }

    protected abstract boolean validate(TypeElement var1, AnnotationHandle var2, Collection<TypeHandle> var3);

    protected final void note(String lllllllllllllllIllIllllllllIlIll, Element lllllllllllllllIllIllllllllIlIlI) {
        MixinValidator lllllllllllllllIllIllllllllIllll;
        lllllllllllllllIllIllllllllIllll.messager.printMessage(Diagnostic.Kind.NOTE, lllllllllllllllIllIllllllllIlIll, lllllllllllllllIllIllllllllIlIlI);
    }
}

