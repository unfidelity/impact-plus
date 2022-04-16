/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.util.ConstraintParser;
import org.spongepowered.asm.util.throwables.ConstraintViolationException;
import org.spongepowered.asm.util.throwables.InvalidConstraintException;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.Mappings;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationManager;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.FieldHandle;
import org.spongepowered.tools.obfuscation.mirror.MethodHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;
import org.spongepowered.tools.obfuscation.mirror.Visibility;

abstract class AnnotatedMixinElementHandler {
    protected final /* synthetic */ AnnotatedMixin mixin;
    protected final /* synthetic */ String classRef;
    protected final /* synthetic */ IMixinAnnotationProcessor ap;
    protected final /* synthetic */ IObfuscationManager obf;
    private /* synthetic */ IMappingConsumer mappings;

    protected static <T extends IMapping<T>> ObfuscationData<T> stripOwnerData(ObfuscationData<T> llllllllllllllllllIIIIllIlllIlIl) {
        ObfuscationData llllllllllllllllllIIIIllIlllIlll = new ObfuscationData();
        for (ObfuscationType llllllllllllllllllIIIIllIllllIIl : llllllllllllllllllIIIIllIlllIlIl) {
            IMapping llllllllllllllllllIIIIllIllllIll = (IMapping)llllllllllllllllllIIIIllIlllIlIl.get(llllllllllllllllllIIIIllIllllIIl);
            llllllllllllllllllIIIIllIlllIlll.put(llllllllllllllllllIIIIllIllllIIl, llllllllllllllllllIIIIllIllllIll.move(null));
        }
        return llllllllllllllllllIIIIllIlllIlll;
    }

    protected final void validateTargetField(VariableElement llllllllllllllllllIIIIllllIIllll, AnnotationHandle llllllllllllllllllIIIIllllIllIII, AliasedElementName llllllllllllllllllIIIIllllIIllIl, String llllllllllllllllllIIIIllllIIllII) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIIllllIlIIIl;
        String llllllllllllllllllIIIIllllIlIIlI = llllllllllllllllllIIIIllllIIllll.asType().toString();
        for (TypeHandle llllllllllllllllllIIIIllllIllllI : llllllllllllllllllIIIIllllIlIIIl.mixin.getTargets()) {
            String llllllllllllllllllIIIIlllllIIIll;
            FieldHandle llllllllllllllllllIIIIlllllIIIIl;
            if (llllllllllllllllllIIIIllllIllllI.isImaginary() || (llllllllllllllllllIIIIlllllIIIIl = llllllllllllllllllIIIIllllIllllI.findField(llllllllllllllllllIIIIllllIIllll)) != null) continue;
            List<String> llllllllllllllllllIIIIlllllIIIII = llllllllllllllllllIIIIllllIIllIl.getAliases();
            Iterator<String> llllllllllllllllllIIIIllllIIIllI = llllllllllllllllllIIIIlllllIIIII.iterator();
            while (llllllllllllllllllIIIIllllIIIllI.hasNext() && (llllllllllllllllllIIIIlllllIIIIl = llllllllllllllllllIIIIllllIllllI.findField(llllllllllllllllllIIIIlllllIIIll = llllllllllllllllllIIIIllllIIIllI.next(), llllllllllllllllllIIIIllllIlIIlI)) == null) {
            }
            if (llllllllllllllllllIIIIlllllIIIIl != null) continue;
            llllllllllllllllllIIIIllllIlIIIl.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Cannot find target for ").append(llllllllllllllllllIIIIllllIIllII).append(" field in ").append(llllllllllllllllllIIIIllllIllllI)), llllllllllllllllllIIIIllllIIllll, llllllllllllllllllIIIIllllIllIII.asMirror());
        }
    }

    protected final void addMethodMapping(ObfuscationType llllllllllllllllllIIIlIIlIlIIlll, String llllllllllllllllllIIIlIIlIlIlllI, String llllllllllllllllllIIIlIIlIlIllIl, String llllllllllllllllllIIIlIIlIlIIlII, String llllllllllllllllllIIIlIIlIlIIIll) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIlIllIIII;
        MappingMethod llllllllllllllllllIIIlIIlIlIlIlI = new MappingMethod(llllllllllllllllllIIIlIIlIllIIII.classRef, llllllllllllllllllIIIlIIlIlIlllI, llllllllllllllllllIIIlIIlIlIIlII);
        MappingMethod llllllllllllllllllIIIlIIlIlIlIIl = new MappingMethod(llllllllllllllllllIIIlIIlIllIIII.classRef, llllllllllllllllllIIIlIIlIlIllIl, llllllllllllllllllIIIlIIlIlIIIll);
        llllllllllllllllllIIIlIIlIllIIII.getMappings().addMethodMapping(llllllllllllllllllIIIlIIlIlIIlll, llllllllllllllllllIIIlIIlIlIlIlI, llllllllllllllllllIIIlIIlIlIlIIl);
    }

    protected final void addMethodMappings(String llllllllllllllllllIIIlIIllIlIlII, String llllllllllllllllllIIIlIIllIllIII, ObfuscationData<MappingMethod> llllllllllllllllllIIIlIIllIlIIIl) {
        for (ObfuscationType llllllllllllllllllIIIlIIllIllIll : llllllllllllllllllIIIlIIllIlIIIl) {
            AnnotatedMixinElementHandler llllllllllllllllllIIIlIIllIllIlI;
            MappingMethod llllllllllllllllllIIIlIIllIlllII = llllllllllllllllllIIIlIIllIlIIIl.get(llllllllllllllllllIIIlIIllIllIll);
            llllllllllllllllllIIIlIIllIllIlI.addMethodMapping(llllllllllllllllllIIIlIIllIllIll, llllllllllllllllllIIIlIIllIlIlII, llllllllllllllllllIIIlIIllIlllII.getSimpleName(), llllllllllllllllllIIIlIIllIllIII, llllllllllllllllllIIIlIIllIlllII.getDesc());
        }
    }

    private void validateMethodVisibility(ExecutableElement llllllllllllllllllIIIlIIIIIlIllI, AnnotationHandle llllllllllllllllllIIIlIIIIIlIlII, String llllllllllllllllllIIIlIIIIIIIIlI, TypeHandle llllllllllllllllllIIIlIIIIIIIIII, MethodHandle llllllllllllllllllIIIIllllllllll) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIIIIIIlll;
        Visibility llllllllllllllllllIIIlIIIIIIllIl = llllllllllllllllllIIIIllllllllll.getVisibility();
        if (llllllllllllllllllIIIlIIIIIIllIl == null) {
            return;
        }
        Visibility llllllllllllllllllIIIlIIIIIIlIll = TypeUtils.getVisibility(llllllllllllllllllIIIlIIIIIlIllI);
        String llllllllllllllllllIIIlIIIIIIlIIl = String.valueOf(new StringBuilder().append("visibility of ").append((Object)llllllllllllllllllIIIlIIIIIIllIl).append(" method in ").append(llllllllllllllllllIIIlIIIIIIIIII));
        if (llllllllllllllllllIIIlIIIIIIllIl.ordinal() > llllllllllllllllllIIIlIIIIIIlIll.ordinal()) {
            llllllllllllllllllIIIlIIIIIIIlll.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append((Object)llllllllllllllllllIIIlIIIIIIlIll).append(" ").append(llllllllllllllllllIIIlIIIIIIIIlI).append(" method cannot reduce ").append(llllllllllllllllllIIIlIIIIIIlIIl)), llllllllllllllllllIIIlIIIIIlIllI, llllllllllllllllllIIIlIIIIIlIlII);
        } else if (llllllllllllllllllIIIlIIIIIIllIl == Visibility.PRIVATE && llllllllllllllllllIIIlIIIIIIlIll.ordinal() > llllllllllllllllllIIIlIIIIIIllIl.ordinal()) {
            llllllllllllllllllIIIlIIIIIIIlll.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append((Object)llllllllllllllllllIIIlIIIIIIlIll).append(" ").append(llllllllllllllllllIIIlIIIIIIIIlI).append(" method will upgrade ").append(llllllllllllllllllIIIlIIIIIIlIIl)), llllllllllllllllllIIIlIIIIIlIllI, llllllllllllllllllIIIlIIIIIlIlII);
        }
    }

    protected final void addFieldMappings(String llllllllllllllllllIIIlIlIIIlIlll, String llllllllllllllllllIIIlIlIIIlIIlI, ObfuscationData<MappingField> llllllllllllllllllIIIlIlIIIlIlIl) {
        for (ObfuscationType llllllllllllllllllIIIlIlIIIllIIl : llllllllllllllllllIIIlIlIIIlIlIl) {
            AnnotatedMixinElementHandler llllllllllllllllllIIIlIlIIIllIII;
            MappingField llllllllllllllllllIIIlIlIIIllIlI = llllllllllllllllllIIIlIlIIIlIlIl.get(llllllllllllllllllIIIlIlIIIllIIl);
            llllllllllllllllllIIIlIlIIIllIII.addFieldMapping(llllllllllllllllllIIIlIlIIIllIIl, llllllllllllllllllIIIlIlIIIlIlll, llllllllllllllllllIIIlIlIIIllIlI.getSimpleName(), llllllllllllllllllIIIlIlIIIlIIlI, llllllllllllllllllIIIlIlIIIllIlI.getDesc());
        }
    }

    private IMappingConsumer getMappings() {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIlIIlIIIll;
        if (llllllllllllllllllIIIlIlIIlIIIll.mappings == null) {
            IMappingConsumer llllllllllllllllllIIIlIlIIlIIlIl = llllllllllllllllllIIIlIlIIlIIIll.mixin.getMappings();
            llllllllllllllllllIIIlIlIIlIIIll.mappings = llllllllllllllllllIIIlIlIIlIIlIl instanceof Mappings ? ((Mappings)llllllllllllllllllIIIlIlIIlIIlIl).asUnique() : llllllllllllllllllIIIlIlIIlIIlIl;
        }
        return llllllllllllllllllIIIlIlIIlIIIll.mappings;
    }

    protected final void validateReferencedTarget(ExecutableElement llllllllllllllllllIIIIlllIlIlIll, AnnotationHandle llllllllllllllllllIIIIlllIllIIll, MemberInfo llllllllllllllllllIIIIlllIllIIIl, String llllllllllllllllllIIIIlllIlIllll) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIIlllIllIllI;
        String llllllllllllllllllIIIIlllIlIlllI = llllllllllllllllllIIIIlllIllIIIl.toDescriptor();
        for (TypeHandle llllllllllllllllllIIIIlllIllIlll : llllllllllllllllllIIIIlllIllIllI.mixin.getTargets()) {
            MethodHandle llllllllllllllllllIIIIlllIlllIIl;
            if (llllllllllllllllllIIIIlllIllIlll.isImaginary() || (llllllllllllllllllIIIIlllIlllIIl = llllllllllllllllllIIIIlllIllIlll.findMethod(llllllllllllllllllIIIIlllIllIIIl.name, llllllllllllllllllIIIIlllIlIlllI)) != null) continue;
            llllllllllllllllllIIIIlllIllIllI.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Cannot find target method for ").append(llllllllllllllllllIIIIlllIlIllll).append(" in ").append(llllllllllllllllllIIIIlllIllIlll)), llllllllllllllllllIIIIlllIlIlIll, llllllllllllllllllIIIIlllIllIIll.asMirror());
        }
    }

    protected final void checkConstraints(ExecutableElement llllllllllllllllllIIIlIIlIIIlIlI, AnnotationHandle llllllllllllllllllIIIlIIlIIIlIII) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIlIIIllll;
        try {
            ConstraintParser.Constraint llllllllllllllllllIIIlIIlIIlIIIl = ConstraintParser.parse((String)llllllllllllllllllIIIlIIlIIIlIII.getValue("constraints"));
            try {
                llllllllllllllllllIIIlIIlIIlIIIl.check(llllllllllllllllllIIIlIIlIIIllll.ap.getTokenProvider());
            }
            catch (ConstraintViolationException llllllllllllllllllIIIlIIlIIlIIlI) {
                llllllllllllllllllIIIlIIlIIIllll.ap.printMessage(Diagnostic.Kind.ERROR, llllllllllllllllllIIIlIIlIIlIIlI.getMessage(), llllllllllllllllllIIIlIIlIIIlIlI, llllllllllllllllllIIIlIIlIIIlIII.asMirror());
            }
        }
        catch (InvalidConstraintException llllllllllllllllllIIIlIIlIIlIIII) {
            llllllllllllllllllIIIlIIlIIIllll.ap.printMessage(Diagnostic.Kind.WARNING, llllllllllllllllllIIIlIIlIIlIIII.getMessage(), llllllllllllllllllIIIlIIlIIIlIlI, llllllllllllllllllIIIlIIlIIIlIII.asMirror());
        }
    }

    AnnotatedMixinElementHandler(IMixinAnnotationProcessor llllllllllllllllllIIIlIlIIlIlIIl, AnnotatedMixin llllllllllllllllllIIIlIlIIlIlIll) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIlIIlIlIlI;
        llllllllllllllllllIIIlIlIIlIlIlI.ap = llllllllllllllllllIIIlIlIIlIlIIl;
        llllllllllllllllllIIIlIlIIlIlIlI.mixin = llllllllllllllllllIIIlIlIIlIlIll;
        llllllllllllllllllIIIlIlIIlIlIlI.classRef = llllllllllllllllllIIIlIlIIlIlIll.getClassRef();
        llllllllllllllllllIIIlIlIIlIlIlI.obf = llllllllllllllllllIIIlIlIIlIlIIl.getObfuscationManager();
    }

    protected final void addMethodMapping(ObfuscationType llllllllllllllllllIIIlIIlIllllII, ShadowElementName llllllllllllllllllIIIlIIllIIIIII, String llllllllllllllllllIIIlIIlIllllll, String llllllllllllllllllIIIlIIlIlllllI) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIllIIIIlI;
        llllllllllllllllllIIIlIIllIIIIlI.addMethodMapping(llllllllllllllllllIIIlIIlIllllII, llllllllllllllllllIIIlIIllIIIIII.name(), llllllllllllllllllIIIlIIllIIIIII.obfuscated(), llllllllllllllllllIIIlIIlIllllll, llllllllllllllllllIIIlIIlIlllllI);
    }

    protected final void addFieldMapping(ObfuscationType llllllllllllllllllIIIlIIllllIlIl, String llllllllllllllllllIIIlIIllllIlII, String llllllllllllllllllIIIlIIlllIlIll, String llllllllllllllllllIIIlIIlllIlIlI, String llllllllllllllllllIIIlIIlllIlIIl) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIlllIlllI;
        MappingField llllllllllllllllllIIIlIIllllIIII = new MappingField(llllllllllllllllllIIIlIIlllIlllI.classRef, llllllllllllllllllIIIlIIllllIlII, llllllllllllllllllIIIlIIlllIlIlI);
        MappingField llllllllllllllllllIIIlIIlllIllll = new MappingField(llllllllllllllllllIIIlIIlllIlllI.classRef, llllllllllllllllllIIIlIIlllIlIll, llllllllllllllllllIIIlIIlllIlIIl);
        llllllllllllllllllIIIlIIlllIlllI.getMappings().addFieldMapping(llllllllllllllllllIIIlIIllllIlIl, llllllllllllllllllIIIlIIllllIIII, llllllllllllllllllIIIlIIlllIllll);
    }

    private void printMessage(Diagnostic.Kind llllllllllllllllllIIIIlllIIIIlll, String llllllllllllllllllIIIIlllIIIIllI, Element llllllllllllllllllIIIIlllIIIlIlI, AnnotationHandle llllllllllllllllllIIIIlllIIIlIIl) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIIlllIIIllll;
        if (llllllllllllllllllIIIIlllIIIlIIl == null) {
            llllllllllllllllllIIIIlllIIIllll.ap.printMessage(llllllllllllllllllIIIIlllIIIIlll, llllllllllllllllllIIIIlllIIIIllI, llllllllllllllllllIIIIlllIIIlIlI);
        } else {
            llllllllllllllllllIIIIlllIIIllll.ap.printMessage(llllllllllllllllllIIIIlllIIIIlll, llllllllllllllllllIIIIlllIIIIllI, llllllllllllllllllIIIIlllIIIlIlI, llllllllllllllllllIIIIlllIIIlIIl.asMirror());
        }
    }

    protected final void addFieldMapping(ObfuscationType llllllllllllllllllIIIlIlIIIIIIlI, ShadowElementName llllllllllllllllllIIIlIlIIIIIllI, String llllllllllllllllllIIIlIlIIIIIIII, String llllllllllllllllllIIIlIIllllllll) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIlIIIIlIII;
        llllllllllllllllllIIIlIlIIIIlIII.addFieldMapping(llllllllllllllllllIIIlIlIIIIIIlI, llllllllllllllllllIIIlIlIIIIIllI.name(), llllllllllllllllllIIIlIlIIIIIllI.obfuscated(), llllllllllllllllllIIIlIlIIIIIIII, llllllllllllllllllIIIlIIllllllll);
    }

    protected static <T extends IMapping<T>> ObfuscationData<T> stripDescriptors(ObfuscationData<T> llllllllllllllllllIIIIllIlIlllll) {
        ObfuscationData llllllllllllllllllIIIIllIlIllllI = new ObfuscationData();
        for (ObfuscationType llllllllllllllllllIIIIllIllIIIII : llllllllllllllllllIIIIllIlIlllll) {
            IMapping llllllllllllllllllIIIIllIllIIIIl = (IMapping)llllllllllllllllllIIIIllIlIlllll.get(llllllllllllllllllIIIIllIllIIIII);
            llllllllllllllllllIIIIllIlIllllI.put(llllllllllllllllllIIIIllIllIIIII, llllllllllllllllllIIIIllIllIIIIl.transform(null));
        }
        return llllllllllllllllllIIIIllIlIllllI;
    }

    protected final void validateTargetMethod(ExecutableElement llllllllllllllllllIIIlIIIlIIIllI, AnnotationHandle llllllllllllllllllIIIlIIIlIIIlIl, AliasedElementName llllllllllllllllllIIIlIIIIlllIII, String llllllllllllllllllIIIlIIIlIIIIll, boolean llllllllllllllllllIIIlIIIIllIllI, boolean llllllllllllllllllIIIlIIIlIIIIIl) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIIlIIIlll;
        String llllllllllllllllllIIIlIIIIlllllI = TypeUtils.getJavaSignature(llllllllllllllllllIIIlIIIlIIIllI);
        for (TypeHandle llllllllllllllllllIIIlIIIlIIlIII : llllllllllllllllllIIIlIIIlIIIlll.mixin.getTargets()) {
            if (llllllllllllllllllIIIlIIIlIIlIII.isImaginary()) continue;
            MethodHandle llllllllllllllllllIIIlIIIlIIlIIl = llllllllllllllllllIIIlIIIlIIlIII.findMethod(llllllllllllllllllIIIlIIIlIIIllI);
            if (llllllllllllllllllIIIlIIIlIIlIIl == null && llllllllllllllllllIIIlIIIIlllIII.hasPrefix()) {
                llllllllllllllllllIIIlIIIlIIlIIl = llllllllllllllllllIIIlIIIlIIlIII.findMethod(llllllllllllllllllIIIlIIIIlllIII.baseName(), llllllllllllllllllIIIlIIIIlllllI);
            }
            if (llllllllllllllllllIIIlIIIlIIlIIl == null && llllllllllllllllllIIIlIIIIlllIII.hasAliases()) {
                String llllllllllllllllllIIIlIIIlIIlIlI;
                Iterator<String> llllllllllllllllllIIIlIIIIlIlIll = llllllllllllllllllIIIlIIIIlllIII.getAliases().iterator();
                while (llllllllllllllllllIIIlIIIIlIlIll.hasNext() && (llllllllllllllllllIIIlIIIlIIlIIl = llllllllllllllllllIIIlIIIlIIlIII.findMethod(llllllllllllllllllIIIlIIIlIIlIlI = llllllllllllllllllIIIlIIIIlIlIll.next(), llllllllllllllllllIIIlIIIIlllllI)) == null) {
                }
            }
            if (llllllllllllllllllIIIlIIIlIIlIIl != null) {
                if (!llllllllllllllllllIIIlIIIIllIllI) continue;
                llllllllllllllllllIIIlIIIlIIIlll.validateMethodVisibility(llllllllllllllllllIIIlIIIlIIIllI, llllllllllllllllllIIIlIIIlIIIlIl, llllllllllllllllllIIIlIIIlIIIIll, llllllllllllllllllIIIlIIIlIIlIII, llllllllllllllllllIIIlIIIlIIlIIl);
                continue;
            }
            if (llllllllllllllllllIIIlIIIlIIIIIl) continue;
            llllllllllllllllllIIIlIIIlIIIlll.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Cannot find target for ").append(llllllllllllllllllIIIlIIIlIIIIll).append(" method in ").append(llllllllllllllllllIIIlIIIlIIlIII)), llllllllllllllllllIIIlIIIlIIIllI, llllllllllllllllllIIIlIIIlIIIlIl);
        }
    }

    protected final void validateTarget(Element llllllllllllllllllIIIlIIIlllIlIl, AnnotationHandle llllllllllllllllllIIIlIIIllIllll, AliasedElementName llllllllllllllllllIIIlIIIllIlllI, String llllllllllllllllllIIIlIIIllIllIl) {
        AnnotatedMixinElementHandler llllllllllllllllllIIIlIIIlllIllI;
        if (llllllllllllllllllIIIlIIIlllIlIl instanceof ExecutableElement) {
            llllllllllllllllllIIIlIIIlllIllI.validateTargetMethod((ExecutableElement)llllllllllllllllllIIIlIIIlllIlIl, llllllllllllllllllIIIlIIIllIllll, llllllllllllllllllIIIlIIIllIlllI, llllllllllllllllllIIIlIIIllIllIl, false, false);
        } else if (llllllllllllllllllIIIlIIIlllIlIl instanceof VariableElement) {
            llllllllllllllllllIIIlIIIlllIllI.validateTargetField((VariableElement)llllllllllllllllllIIIlIIIlllIlIl, llllllllllllllllllIIIlIIIllIllll, llllllllllllllllllIIIlIIIllIlllI, llllllllllllllllllIIIlIIIllIllIl);
        }
    }

    static abstract class AnnotatedElement<E extends Element> {
        protected final /* synthetic */ E element;
        protected final /* synthetic */ AnnotationHandle annotation;
        private final /* synthetic */ String desc;

        public AnnotationHandle getAnnotation() {
            AnnotatedElement llIlllllIIlIll;
            return llIlllllIIlIll.annotation;
        }

        public String getDesc() {
            AnnotatedElement llIlllllIIIlII;
            return llIlllllIIIlII.desc;
        }

        public E getElement() {
            AnnotatedElement llIlllllIlIIll;
            return llIlllllIlIIll.element;
        }

        public final void printMessage(Messager llIllllIlIllIl, Diagnostic.Kind llIllllIlIllII, CharSequence llIllllIlIllll) {
            AnnotatedElement llIllllIllIIlI;
            llIllllIlIllIl.printMessage(llIllllIlIllII, llIllllIlIllll, (Element)llIllllIllIIlI.element, llIllllIllIIlI.annotation.asMirror());
        }

        public String getSimpleName() {
            AnnotatedElement llIlllllIIIlll;
            return llIlllllIIIlll.getElement().getSimpleName().toString();
        }

        public AnnotatedElement(E llIllllllIIlIl, AnnotationHandle llIllllllIIIll) {
            AnnotatedElement llIllllllIIlll;
            llIllllllIIlll.element = llIllllllIIlIl;
            llIllllllIIlll.annotation = llIllllllIIIll;
            llIllllllIIlll.desc = TypeUtils.getDescriptor(llIllllllIIlIl);
        }
    }

    static class AliasedElementName {
        protected final /* synthetic */ String originalName;
        private final /* synthetic */ List<String> aliases;
        private /* synthetic */ boolean caseSensitive;

        public AliasedElementName(Element lIlllllIIIlIlII, AnnotationHandle lIlllllIIIlIIll) {
            AliasedElementName lIlllllIIIlIIlI;
            lIlllllIIIlIIlI.originalName = lIlllllIIIlIlII.getSimpleName().toString();
            lIlllllIIIlIIlI.aliases = lIlllllIIIlIIll.getList("aliases");
        }

        public String elementName() {
            AliasedElementName lIllllIllllllll;
            return lIllllIllllllll.originalName;
        }

        public List<String> getAliases() {
            AliasedElementName lIlllllIIIIIIIl;
            return lIlllllIIIIIIIl.aliases;
        }

        public AliasedElementName setCaseSensitive(boolean lIlllllIIIIlIlI) {
            AliasedElementName lIlllllIIIIlIll;
            lIlllllIIIIlIll.caseSensitive = lIlllllIIIIlIlI;
            return lIlllllIIIIlIll;
        }

        public boolean hasAliases() {
            AliasedElementName lIlllllIIIIIlIl;
            return lIlllllIIIIIlIl.aliases.size() > 0;
        }

        public boolean hasPrefix() {
            return false;
        }

        public String baseName() {
            AliasedElementName lIllllIlllllIll;
            return lIllllIlllllIll.originalName;
        }

        public boolean isCaseSensitive() {
            AliasedElementName lIlllllIIIIlIII;
            return lIlllllIIIIlIII.caseSensitive;
        }
    }

    static class ShadowElementName
    extends AliasedElementName {
        private final /* synthetic */ String prefix;
        private final /* synthetic */ boolean hasPrefix;
        private /* synthetic */ String obfuscated;
        private final /* synthetic */ String baseName;

        public String prefix(String lllllllllllllllIlllIlIIIIllIIIII) {
            ShadowElementName lllllllllllllllIlllIlIIIIllIIIll;
            return lllllllllllllllIlllIlIIIIllIIIll.hasPrefix ? String.valueOf(new StringBuilder().append(lllllllllllllllIlllIlIIIIllIIIll.prefix).append(lllllllllllllllIlllIlIIIIllIIIII)) : lllllllllllllllIlllIlIIIIllIIIII;
        }

        public ShadowElementName setObfuscatedName(IMapping<?> lllllllllllllllIlllIlIIIlIIIIIII) {
            ShadowElementName lllllllllllllllIlllIlIIIlIIIIIIl;
            lllllllllllllllIlllIlIIIlIIIIIIl.obfuscated = lllllllllllllllIlllIlIIIlIIIIIII.getName();
            return lllllllllllllllIlllIlIIIlIIIIIIl;
        }

        @Override
        public boolean hasPrefix() {
            ShadowElementName lllllllllllllllIlllIlIIIIlllIlIl;
            return lllllllllllllllIlllIlIIIIlllIlIl.hasPrefix;
        }

        ShadowElementName(Element lllllllllllllllIlllIlIIIlIIllIll, AnnotationHandle lllllllllllllllIlllIlIIIlIIllIIl) {
            super(lllllllllllllllIlllIlIIIlIIllIll, lllllllllllllllIlllIlIIIlIIllIIl);
            ShadowElementName lllllllllllllllIlllIlIIIlIIlIlIl;
            lllllllllllllllIlllIlIIIlIIlIlIl.prefix = lllllllllllllllIlllIlIIIlIIllIIl.getValue("prefix", "shadow$");
            boolean lllllllllllllllIlllIlIIIlIIllIII = false;
            String lllllllllllllllIlllIlIIIlIIlIllI = lllllllllllllllIlllIlIIIlIIlIlIl.originalName;
            if (lllllllllllllllIlllIlIIIlIIlIllI.startsWith(lllllllllllllllIlllIlIIIlIIlIlIl.prefix)) {
                lllllllllllllllIlllIlIIIlIIllIII = true;
                lllllllllllllllIlllIlIIIlIIlIllI = lllllllllllllllIlllIlIIIlIIlIllI.substring(lllllllllllllllIlllIlIIIlIIlIlIl.prefix.length());
            }
            lllllllllllllllIlllIlIIIlIIlIlIl.hasPrefix = lllllllllllllllIlllIlIIIlIIllIII;
            lllllllllllllllIlllIlIIIlIIlIlIl.obfuscated = lllllllllllllllIlllIlIIIlIIlIlIl.baseName = lllllllllllllllIlllIlIIIlIIlIllI;
        }

        public String prefix() {
            ShadowElementName lllllllllllllllIlllIlIIIIlllIIll;
            return lllllllllllllllIlllIlIIIIlllIIll.hasPrefix ? lllllllllllllllIlllIlIIIIlllIIll.prefix : "";
        }

        public ShadowElementName setObfuscatedName(String lllllllllllllllIlllIlIIIIllllIII) {
            ShadowElementName lllllllllllllllIlllIlIIIIllllIIl;
            lllllllllllllllIlllIlIIIIllllIIl.obfuscated = lllllllllllllllIlllIlIIIIllllIII;
            return lllllllllllllllIlllIlIIIIllllIIl;
        }

        @Override
        public String baseName() {
            ShadowElementName lllllllllllllllIlllIlIIIlIIIlIIl;
            return lllllllllllllllIlllIlIIIlIIIlIIl.baseName;
        }

        public String name() {
            ShadowElementName lllllllllllllllIlllIlIIIIlllIIII;
            return lllllllllllllllIlllIlIIIIlllIIII.prefix(lllllllllllllllIlllIlIIIIlllIIII.baseName);
        }

        public String obfuscated() {
            ShadowElementName lllllllllllllllIlllIlIIIIllIlIIl;
            return lllllllllllllllIlllIlIIIIllIlIIl.prefix(lllllllllllllllIlllIlIIIIllIlIIl.obfuscated);
        }

        public String toString() {
            ShadowElementName lllllllllllllllIlllIlIIIlIIIllII;
            return lllllllllllllllIlllIlIIIlIIIllII.baseName;
        }
    }
}

