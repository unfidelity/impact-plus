/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.List;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.DeclaredType;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandler;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.MethodHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

public class AnnotatedMixinElementHandlerSoftImplements
extends AnnotatedMixinElementHandler {
    public void process(AnnotationHandle llllllllllllllllIlIIlllllllllIII) {
        AnnotatedMixinElementHandlerSoftImplements llllllllllllllllIlIIlllllllllIIl;
        if (!llllllllllllllllIlIIlllllllllIIl.mixin.remap()) {
            return;
        }
        List<AnnotationHandle> llllllllllllllllIlIIllllllllIlll = llllllllllllllllIlIIlllllllllIII.getAnnotationList("value");
        if (llllllllllllllllIlIIllllllllIlll.size() < 1) {
            llllllllllllllllIlIIlllllllllIIl.ap.printMessage(Diagnostic.Kind.WARNING, "Empty @Implements annotation", llllllllllllllllIlIIlllllllllIIl.mixin.getMixin(), llllllllllllllllIlIIlllllllllIII.asMirror());
            return;
        }
        for (AnnotationHandle llllllllllllllllIlIIlllllllllIlI : llllllllllllllllIlIIllllllllIlll) {
            Interface.Remap llllllllllllllllIlIIlllllllllIll = llllllllllllllllIlIIlllllllllIlI.getValue("remap", Interface.Remap.ALL);
            if (llllllllllllllllIlIIlllllllllIll == Interface.Remap.NONE) continue;
            try {
                TypeHandle llllllllllllllllIlIIlllllllllllI = new TypeHandle((DeclaredType)llllllllllllllllIlIIlllllllllIlI.getValue("iface"));
                String llllllllllllllllIlIIllllllllllIl = (String)llllllllllllllllIlIIlllllllllIlI.getValue("prefix");
                llllllllllllllllIlIIlllllllllIIl.processSoftImplements(llllllllllllllllIlIIlllllllllIll, llllllllllllllllIlIIlllllllllllI, llllllllllllllllIlIIllllllllllIl);
            }
            catch (Exception llllllllllllllllIlIIllllllllllII) {
                llllllllllllllllIlIIlllllllllIIl.ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Unexpected error: ").append(llllllllllllllllIlIIllllllllllII.getClass().getName()).append(": ").append(llllllllllllllllIlIIllllllllllII.getMessage())), llllllllllllllllIlIIlllllllllIIl.mixin.getMixin(), llllllllllllllllIlIIlllllllllIlI.asMirror());
            }
        }
    }

    AnnotatedMixinElementHandlerSoftImplements(IMixinAnnotationProcessor llllllllllllllllIlIlIIIIIIIIlIII, AnnotatedMixin llllllllllllllllIlIlIIIIIIIIlIlI) {
        super(llllllllllllllllIlIlIIIIIIIIlIII, llllllllllllllllIlIlIIIIIIIIlIlI);
        AnnotatedMixinElementHandlerSoftImplements llllllllllllllllIlIlIIIIIIIIllII;
    }

    private void addInterfaceMethodMapping(Interface.Remap llllllllllllllllIlIIlllllIllIllI, TypeHandle llllllllllllllllIlIIlllllIllIlIl, String llllllllllllllllIlIIlllllIlIlIll, MethodHandle llllllllllllllllIlIIlllllIllIIll, String llllllllllllllllIlIIlllllIllIIlI, String llllllllllllllllIlIIlllllIlIlIII) {
        AnnotatedMixinElementHandlerSoftImplements llllllllllllllllIlIIlllllIllIlll;
        MappingMethod llllllllllllllllIlIIlllllIllIIII = new MappingMethod(llllllllllllllllIlIIlllllIllIlIl.getName(), llllllllllllllllIlIIlllllIllIIlI, llllllllllllllllIlIIlllllIlIlIII);
        ObfuscationData<MappingMethod> llllllllllllllllIlIIlllllIlIllll = llllllllllllllllIlIIlllllIllIlll.obf.getDataProvider().getObfMethod(llllllllllllllllIlIIlllllIllIIII);
        if (llllllllllllllllIlIIlllllIlIllll.isEmpty()) {
            if (llllllllllllllllIlIIlllllIllIllI.forceRemap()) {
                llllllllllllllllIlIIlllllIllIlll.ap.printMessage(Diagnostic.Kind.ERROR, "No obfuscation mapping for soft-implementing method", llllllllllllllllIlIIlllllIllIIll.getElement());
            }
            return;
        }
        llllllllllllllllIlIIlllllIllIlll.addMethodMappings(llllllllllllllllIlIIlllllIllIIll.getName(), llllllllllllllllIlIIlllllIlIlIII, llllllllllllllllIlIIlllllIllIlll.applyPrefix(llllllllllllllllIlIIlllllIlIllll, llllllllllllllllIlIIlllllIlIlIll));
    }

    private void processMethod(Interface.Remap llllllllllllllllIlIIllllllIlIIII, TypeHandle llllllllllllllllIlIIllllllIIIlll, String llllllllllllllllIlIIllllllIIlllI, ExecutableElement llllllllllllllllIlIIllllllIIllIl) {
        MethodHandle llllllllllllllllIlIIllllllIlIIlI;
        AnnotatedMixinElementHandlerSoftImplements llllllllllllllllIlIIllllllIIlIIl;
        MethodHandle llllllllllllllllIlIIllllllIlIIll;
        String llllllllllllllllIlIIllllllIIllII = llllllllllllllllIlIIllllllIIllIl.getSimpleName().toString();
        String llllllllllllllllIlIIllllllIIlIll = TypeUtils.getJavaSignature(llllllllllllllllIlIIllllllIIllIl);
        String llllllllllllllllIlIIllllllIIlIlI = TypeUtils.getDescriptor(llllllllllllllllIlIIllllllIIllIl);
        if (llllllllllllllllIlIIllllllIlIIII != Interface.Remap.ONLY_PREFIXED && (llllllllllllllllIlIIllllllIlIIll = llllllllllllllllIlIIllllllIIlIIl.mixin.getHandle().findMethod(llllllllllllllllIlIIllllllIIllII, llllllllllllllllIlIIllllllIIlIll)) != null) {
            llllllllllllllllIlIIllllllIIlIIl.addInterfaceMethodMapping(llllllllllllllllIlIIllllllIlIIII, llllllllllllllllIlIIllllllIIIlll, null, llllllllllllllllIlIIllllllIlIIll, llllllllllllllllIlIIllllllIIllII, llllllllllllllllIlIIllllllIIlIlI);
        }
        if (llllllllllllllllIlIIllllllIIlllI != null && (llllllllllllllllIlIIllllllIlIIlI = llllllllllllllllIlIIllllllIIlIIl.mixin.getHandle().findMethod(String.valueOf(new StringBuilder().append(llllllllllllllllIlIIllllllIIlllI).append(llllllllllllllllIlIIllllllIIllII)), llllllllllllllllIlIIllllllIIlIll)) != null) {
            llllllllllllllllIlIIllllllIIlIIl.addInterfaceMethodMapping(llllllllllllllllIlIIllllllIlIIII, llllllllllllllllIlIIllllllIIIlll, llllllllllllllllIlIIllllllIIlllI, llllllllllllllllIlIIllllllIlIIlI, llllllllllllllllIlIIllllllIIllII, llllllllllllllllIlIIllllllIIlIlI);
        }
    }

    private ObfuscationData<MappingMethod> applyPrefix(ObfuscationData<MappingMethod> llllllllllllllllIlIIlllllIIIllll, String llllllllllllllllIlIIlllllIIlIlII) {
        if (llllllllllllllllIlIIlllllIIlIlII == null) {
            return llllllllllllllllIlIIlllllIIIllll;
        }
        ObfuscationData<MappingMethod> llllllllllllllllIlIIlllllIIlIIIl = new ObfuscationData<MappingMethod>();
        for (ObfuscationType llllllllllllllllIlIIlllllIIlIlll : llllllllllllllllIlIIlllllIIIllll) {
            MappingMethod llllllllllllllllIlIIlllllIIllIII = llllllllllllllllIlIIlllllIIIllll.get(llllllllllllllllIlIIlllllIIlIlll);
            llllllllllllllllIlIIlllllIIlIIIl.put(llllllllllllllllIlIIlllllIIlIlll, llllllllllllllllIlIIlllllIIllIII.addPrefix(llllllllllllllllIlIIlllllIIlIlII));
        }
        return llllllllllllllllIlIIlllllIIlIIIl;
    }

    private void processSoftImplements(Interface.Remap llllllllllllllllIlIIlllllllIIlIl, TypeHandle llllllllllllllllIlIIlllllllIIlII, String llllllllllllllllIlIIlllllllIIIll) {
        AnnotatedMixinElementHandlerSoftImplements llllllllllllllllIlIIlllllllIIIlI;
        for (ExecutableElement llllllllllllllllIlIIlllllllIlIII : llllllllllllllllIlIIlllllllIIlII.getEnclosedElements(ElementKind.METHOD)) {
            llllllllllllllllIlIIlllllllIIIlI.processMethod(llllllllllllllllIlIIlllllllIIlIl, llllllllllllllllIlIIlllllllIIlII, llllllllllllllllIlIIlllllllIIIll, llllllllllllllllIlIIlllllllIlIII);
        }
        for (TypeHandle llllllllllllllllIlIIlllllllIIlll : llllllllllllllllIlIIlllllllIIlII.getInterfaces()) {
            llllllllllllllllIlIIlllllllIIIlI.processSoftImplements(llllllllllllllllIlIIlllllllIIlIl, llllllllllllllllIlIIlllllllIIlll, llllllllllllllllIlIIlllllllIIIll);
        }
    }
}

