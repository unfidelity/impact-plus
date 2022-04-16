/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.lang.reflect.Method;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandler;
import org.spongepowered.tools.obfuscation.Mappings;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

class AnnotatedMixinElementHandlerOverwrite
extends AnnotatedMixinElementHandler {
    AnnotatedMixinElementHandlerOverwrite(IMixinAnnotationProcessor lllllllllllllllIllIllIlIIlllIlII, AnnotatedMixin lllllllllllllllIllIllIlIIlllIIll) {
        super(lllllllllllllllIllIllIlIIlllIlII, lllllllllllllllIllIllIlIIlllIIll);
        AnnotatedMixinElementHandlerOverwrite lllllllllllllllIllIllIlIIlllIlIl;
    }

    public void registerMerge(ExecutableElement lllllllllllllllIllIllIlIIllIllII) {
        AnnotatedMixinElementHandlerOverwrite lllllllllllllllIllIllIlIIllIllIl;
        lllllllllllllllIllIllIlIIllIllIl.validateTargetMethod(lllllllllllllllIllIllIlIIllIllII, null, new AnnotatedMixinElementHandler.AliasedElementName(lllllllllllllllIllIllIlIIllIllII, AnnotationHandle.MISSING), "overwrite", true, true);
    }

    private boolean registerOverwriteForTarget(AnnotatedElementOverwrite lllllllllllllllIllIllIlIIlIIlIIl, TypeHandle lllllllllllllllIllIllIlIIlIIlIII) {
        AnnotatedMixinElementHandlerOverwrite lllllllllllllllIllIllIlIIlIIlIlI;
        MappingMethod lllllllllllllllIllIllIlIIlIIllII = lllllllllllllllIllIllIlIIlIIlIII.getMappingMethod(lllllllllllllllIllIllIlIIlIIlIIl.getSimpleName(), lllllllllllllllIllIllIlIIlIIlIIl.getDesc());
        ObfuscationData<MappingMethod> lllllllllllllllIllIllIlIIlIIlIll = lllllllllllllllIllIllIlIIlIIlIlI.obf.getDataProvider().getObfMethod(lllllllllllllllIllIllIlIIlIIllII);
        if (lllllllllllllllIllIllIlIIlIIlIll.isEmpty()) {
            Diagnostic.Kind lllllllllllllllIllIllIlIIlIlIIIl = Diagnostic.Kind.ERROR;
            try {
                Method lllllllllllllllIllIllIlIIlIlIIlI = ((ExecutableElement)lllllllllllllllIllIllIlIIlIIlIIl.getElement()).getClass().getMethod("isStatic", new Class[0]);
                if (((Boolean)lllllllllllllllIllIllIlIIlIlIIlI.invoke(lllllllllllllllIllIllIlIIlIIlIIl.getElement(), new Object[0])).booleanValue()) {
                    lllllllllllllllIllIllIlIIlIlIIIl = Diagnostic.Kind.WARNING;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            lllllllllllllllIllIllIlIIlIIlIlI.ap.printMessage(lllllllllllllllIllIllIlIIlIlIIIl, "No obfuscation mapping for @Overwrite method", (Element)lllllllllllllllIllIllIlIIlIIlIIl.getElement());
            return false;
        }
        try {
            lllllllllllllllIllIllIlIIlIIlIlI.addMethodMappings(lllllllllllllllIllIllIlIIlIIlIIl.getSimpleName(), lllllllllllllllIllIllIlIIlIIlIIl.getDesc(), lllllllllllllllIllIllIlIIlIIlIll);
        }
        catch (Mappings.MappingConflictException lllllllllllllllIllIllIlIIlIlIIII) {
            lllllllllllllllIllIllIlIIlIIlIIl.printMessage(lllllllllllllllIllIllIlIIlIIlIlI.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Mapping conflict for @Overwrite method: ").append(lllllllllllllllIllIllIlIIlIlIIII.getNew().getSimpleName()).append(" for target ").append(lllllllllllllllIllIllIlIIlIIlIII).append(" conflicts with existing mapping ").append(lllllllllllllllIllIllIlIIlIlIIII.getOld().getSimpleName())));
            return false;
        }
        return true;
    }

    public void registerOverwrite(AnnotatedElementOverwrite lllllllllllllllIllIllIlIIlIlllIl) {
        AnnotatedMixinElementHandlerOverwrite lllllllllllllllIllIllIlIIllIIIIl;
        AnnotatedMixinElementHandler.AliasedElementName lllllllllllllllIllIllIlIIlIlllll = new AnnotatedMixinElementHandler.AliasedElementName((Element)lllllllllllllllIllIllIlIIlIlllIl.getElement(), lllllllllllllllIllIllIlIIlIlllIl.getAnnotation());
        lllllllllllllllIllIllIlIIllIIIIl.validateTargetMethod((ExecutableElement)lllllllllllllllIllIllIlIIlIlllIl.getElement(), lllllllllllllllIllIllIlIIlIlllIl.getAnnotation(), lllllllllllllllIllIllIlIIlIlllll, "@Overwrite", true, false);
        lllllllllllllllIllIllIlIIllIIIIl.checkConstraints((ExecutableElement)lllllllllllllllIllIllIlIIlIlllIl.getElement(), lllllllllllllllIllIllIlIIlIlllIl.getAnnotation());
        if (lllllllllllllllIllIllIlIIlIlllIl.shouldRemap()) {
            for (TypeHandle lllllllllllllllIllIllIlIIllIIlII : lllllllllllllllIllIllIlIIllIIIIl.mixin.getTargets()) {
                if (lllllllllllllllIllIllIlIIllIIIIl.registerOverwriteForTarget(lllllllllllllllIllIllIlIIlIlllIl, lllllllllllllllIllIllIlIIllIIlII)) continue;
                return;
            }
        }
        if (!"true".equalsIgnoreCase(lllllllllllllllIllIllIlIIllIIIIl.ap.getOption("disableOverwriteChecker"))) {
            Diagnostic.Kind lllllllllllllllIllIllIlIIllIIIll = "error".equalsIgnoreCase(lllllllllllllllIllIllIlIIllIIIIl.ap.getOption("overwriteErrorLevel")) ? Diagnostic.Kind.ERROR : Diagnostic.Kind.WARNING;
            String lllllllllllllllIllIllIlIIllIIIlI = lllllllllllllllIllIllIlIIllIIIIl.ap.getJavadocProvider().getJavadoc((Element)lllllllllllllllIllIllIlIIlIlllIl.getElement());
            if (lllllllllllllllIllIllIlIIllIIIlI == null) {
                lllllllllllllllIllIllIlIIllIIIIl.ap.printMessage(lllllllllllllllIllIllIlIIllIIIll, "@Overwrite is missing javadoc comment", (Element)lllllllllllllllIllIllIlIIlIlllIl.getElement());
                return;
            }
            if (!lllllllllllllllIllIllIlIIllIIIlI.toLowerCase().contains("@author")) {
                lllllllllllllllIllIllIlIIllIIIIl.ap.printMessage(lllllllllllllllIllIllIlIIllIIIll, "@Overwrite is missing an @author tag", (Element)lllllllllllllllIllIllIlIIlIlllIl.getElement());
            }
            if (!lllllllllllllllIllIllIlIIllIIIlI.toLowerCase().contains("@reason")) {
                lllllllllllllllIllIllIlIIllIIIIl.ap.printMessage(lllllllllllllllIllIllIlIIllIIIll, "@Overwrite is missing an @reason tag", (Element)lllllllllllllllIllIllIlIIlIlllIl.getElement());
            }
        }
    }

    static class AnnotatedElementOverwrite
    extends AnnotatedMixinElementHandler.AnnotatedElement<ExecutableElement> {
        private final /* synthetic */ boolean shouldRemap;

        public boolean shouldRemap() {
            AnnotatedElementOverwrite lllllllllllllllIlllIIlIIlllIIIlI;
            return lllllllllllllllIlllIIlIIlllIIIlI.shouldRemap;
        }

        public AnnotatedElementOverwrite(ExecutableElement lllllllllllllllIlllIIlIIlllIIlll, AnnotationHandle lllllllllllllllIlllIIlIIlllIlIlI, boolean lllllllllllllllIlllIIlIIlllIlIIl) {
            super(lllllllllllllllIlllIIlIIlllIIlll, lllllllllllllllIlllIIlIIlllIlIlI);
            AnnotatedElementOverwrite lllllllllllllllIlllIIlIIlllIlIII;
            lllllllllllllllIlllIIlIIlllIlIII.shouldRemap = lllllllllllllllIlllIIlIIlllIlIIl;
        }
    }
}

