/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Messager;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandlerAccessor;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandlerInjector;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandlerOverwrite;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandlerShadow;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandlerSoftImplements;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IMixinValidator;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationManager;
import org.spongepowered.tools.obfuscation.interfaces.ITypeHandleProvider;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;
import org.spongepowered.tools.obfuscation.struct.InjectorRemap;

class AnnotatedMixin {
    private final /* synthetic */ boolean virtual;
    private final /* synthetic */ Messager messager;
    private final /* synthetic */ ITypeHandleProvider typeProvider;
    private final /* synthetic */ boolean remap;
    private final /* synthetic */ IObfuscationManager obf;
    private final /* synthetic */ AnnotatedMixinElementHandlerOverwrite overwrites;
    private final /* synthetic */ AnnotatedMixinElementHandlerInjector injectors;
    private final /* synthetic */ String classRef;
    private /* synthetic */ boolean validated;
    private final /* synthetic */ AnnotationHandle annotation;
    private final /* synthetic */ IMappingConsumer mappings;
    private final /* synthetic */ AnnotatedMixinElementHandlerAccessor accessors;
    private final /* synthetic */ TypeHandle handle;
    private final /* synthetic */ TypeHandle primaryTarget;
    private final /* synthetic */ TypeElement mixin;
    private final /* synthetic */ AnnotatedMixinElementHandlerSoftImplements softImplements;
    private final /* synthetic */ List<TypeHandle> targets;
    private final /* synthetic */ AnnotatedMixinElementHandlerShadow shadows;
    private final /* synthetic */ List<ExecutableElement> methods;

    private void runFinalValidation() {
        AnnotatedMixin llIIlIIIIIll;
        for (ExecutableElement llIIlIIIIlIl : llIIlIIIIIll.methods) {
            llIIlIIIIIll.overwrites.registerMerge(llIIlIIIIlIl);
        }
    }

    public TypeHandle getHandle() {
        AnnotatedMixin llIIlIllllIl;
        return llIIlIllllIl.handle;
    }

    public boolean isMultiTarget() {
        AnnotatedMixin llIIlIlIIIIl;
        return llIIlIlIIIIl.targets.size() > 1;
    }

    public void registerOverwrite(ExecutableElement llIIIllllIll, AnnotationHandle llIIIlllIllI, boolean llIIIlllIlIl) {
        AnnotatedMixin llIIIlllllII;
        llIIIlllllII.methods.remove(llIIIllllIll);
        llIIIlllllII.overwrites.registerOverwrite(new AnnotatedMixinElementHandlerOverwrite.AnnotatedElementOverwrite(llIIIllllIll, llIIIlllIllI, llIIIlllIlIl));
    }

    private void printMessage(Diagnostic.Kind llIIllllIIIl, CharSequence llIIllllIIII, AnnotatedMixin llIIlllIllll) {
        AnnotatedMixin llIIllllIIlI;
        llIIllllIIlI.messager.printMessage(llIIllllIIIl, llIIllllIIII, llIIllllIIlI.mixin, llIIllllIIlI.annotation.asMirror());
    }

    private void addSoftTarget(TypeHandle llIIlllIIlII, String llIIllIlllll) {
        AnnotatedMixin llIIlllIIlIl;
        ObfuscationData<String> llIIlllIIIlI = llIIlllIIlIl.obf.getDataProvider().getObfClass(llIIlllIIlII);
        if (!llIIlllIIIlI.isEmpty()) {
            llIIlllIIlIl.obf.getReferenceManager().addClassMapping(llIIlllIIlIl.classRef, llIIllIlllll, llIIlllIIIlI);
        }
        llIIlllIIlIl.addTarget(llIIlllIIlII);
    }

    public List<TypeHandle> getTargets() {
        AnnotatedMixin llIIlIlIlllI;
        return llIIlIlIlllI.targets;
    }

    public void registerAccessor(ExecutableElement lIlllllIlllI, AnnotationHandle lIlllllIllIl, boolean lIllllllIIII) {
        AnnotatedMixin lIlllllIllll;
        lIlllllIllll.methods.remove(lIlllllIlllI);
        lIlllllIllll.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor.AnnotatedElementAccessor(lIlllllIlllI, lIlllllIllIl, lIllllllIIII));
    }

    public void registerInjector(ExecutableElement llIIIIlIIIII, AnnotationHandle llIIIIlIIlIl, InjectorRemap llIIIIlIIlII) {
        AnnotatedMixin llIIIIlIlIIl;
        llIIIIlIlIIl.methods.remove(llIIIIlIIIII);
        llIIIIlIlIIl.injectors.registerInjector(new AnnotatedMixinElementHandlerInjector.AnnotatedElementInjector(llIIIIlIIIII, llIIIIlIIlIl, llIIIIlIIlII));
        List<AnnotationHandle> llIIIIlIIIll = llIIIIlIIlIl.getAnnotationList("at");
        for (AnnotationHandle llIIIIllIIll : llIIIIlIIIll) {
            llIIIIlIlIIl.registerInjectionPoint(llIIIIlIIIII, llIIIIlIIlIl, llIIIIllIIll, llIIIIlIIlII, "@At(%s)");
        }
        List<AnnotationHandle> llIIIIlIIIlI = llIIIIlIIlIl.getAnnotationList("slice");
        for (AnnotationHandle llIIIIlIlIll : llIIIIlIIIlI) {
            AnnotationHandle llIIIIlIllIl;
            String llIIIIllIIIl = llIIIIlIlIll.getValue("id", "");
            AnnotationHandle llIIIIlIllll = llIIIIlIlIll.getAnnotation("from");
            if (llIIIIlIllll != null) {
                llIIIIlIlIIl.registerInjectionPoint(llIIIIlIIIII, llIIIIlIIlIl, llIIIIlIllll, llIIIIlIIlII, String.valueOf(new StringBuilder().append("@Slice[").append(llIIIIllIIIl).append("](from=@At(%s))")));
            }
            if ((llIIIIlIllIl = llIIIIlIlIll.getAnnotation("to")) == null) continue;
            llIIIIlIlIIl.registerInjectionPoint(llIIIIlIIIII, llIIIIlIIlIl, llIIIIlIllIl, llIIIIlIIlII, String.valueOf(new StringBuilder().append("@Slice[").append(llIIIIllIIIl).append("](to=@At(%s))")));
        }
    }

    public TypeElement getMixin() {
        AnnotatedMixin llIIllIIIIll;
        return llIIllIIIIll.mixin;
    }

    public void registerShadow(VariableElement llIIIllIllll, AnnotationHandle llIIIllIlllI, boolean llIIIllIllIl) {
        AnnotatedMixin llIIIllIllII;
        AnnotatedMixinElementHandlerShadow annotatedMixinElementHandlerShadow = llIIIllIllII.shadows;
        AnnotatedMixinElementHandlerShadow annotatedMixinElementHandlerShadow2 = llIIIllIllII.shadows;
        annotatedMixinElementHandlerShadow2.getClass();
        annotatedMixinElementHandlerShadow.registerShadow(annotatedMixinElementHandlerShadow2.new AnnotatedMixinElementHandlerShadow.AnnotatedElementShadowField(llIIIllIllll, llIIIllIlllI, llIIIllIllIl));
    }

    AnnotatedMixin runValidators(IMixinValidator.ValidationPass llIlIIIIlllI, Collection<IMixinValidator> llIlIIIIlIlI) {
        AnnotatedMixin llIlIIIIllII;
        for (IMixinValidator llIlIIIlIIII : llIlIIIIlIlI) {
            if (!llIlIIIlIIII.validate(llIlIIIIlllI, llIlIIIIllII.mixin, llIlIIIIllII.annotation, llIlIIIIllII.targets)) break;
        }
        if (llIlIIIIlllI == IMixinValidator.ValidationPass.FINAL && !llIlIIIIllII.validated) {
            llIlIIIIllII.validated = true;
            llIlIIIIllII.runFinalValidation();
        }
        return llIlIIIIllII;
    }

    public void registerSoftImplements(AnnotationHandle lIllllIlIlII) {
        AnnotatedMixin lIllllIlIIll;
        lIllllIlIIll.softImplements.process(lIllllIlIlII);
    }

    public void registerShadow(ExecutableElement llIIIllIIIll, AnnotationHandle llIIIllIIIlI, boolean llIIIllIIIIl) {
        AnnotatedMixin llIIIllIIIII;
        llIIIllIIIII.methods.remove(llIIIllIIIll);
        AnnotatedMixinElementHandlerShadow annotatedMixinElementHandlerShadow = llIIIllIIIII.shadows;
        AnnotatedMixinElementHandlerShadow annotatedMixinElementHandlerShadow2 = llIIIllIIIII.shadows;
        annotatedMixinElementHandlerShadow2.getClass();
        annotatedMixinElementHandlerShadow.registerShadow(annotatedMixinElementHandlerShadow2.new AnnotatedMixinElementHandlerShadow.AnnotatedElementShadowMethod(llIIIllIIIll, llIIIllIIIlI, llIIIllIIIIl));
    }

    private TypeHandle initTargets() {
        AnnotatedMixin llIIlllllIlI;
        TypeHandle llIIlllllIll = null;
        try {
            for (TypeMirror llIlIIIIIIIl : llIIlllllIlI.annotation.getList()) {
                TypeHandle llIlIIIIIIlI = new TypeHandle((DeclaredType)llIlIIIIIIIl);
                if (llIIlllllIlI.targets.contains(llIlIIIIIIlI)) continue;
                llIIlllllIlI.addTarget(llIlIIIIIIlI);
                if (llIIlllllIll != null) continue;
                llIIlllllIll = llIlIIIIIIlI;
            }
        }
        catch (Exception llIlIIIIIIII) {
            llIIlllllIlI.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Error processing public targets: ").append(llIlIIIIIIII.getClass().getName()).append(": ").append(llIlIIIIIIII.getMessage())), llIIlllllIlI);
        }
        try {
            for (String llIIlllllllI : llIIlllllIlI.annotation.getList("targets")) {
                TypeHandle llIIllllllll = llIIlllllIlI.typeProvider.getTypeHandle(llIIlllllllI);
                if (llIIlllllIlI.targets.contains(llIIllllllll)) continue;
                if (llIIlllllIlI.virtual) {
                    llIIllllllll = llIIlllllIlI.typeProvider.getSimulatedHandle(llIIlllllllI, llIIlllllIlI.mixin.asType());
                } else {
                    if (llIIllllllll == null) {
                        llIIlllllIlI.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Mixin target ").append(llIIlllllllI).append(" could not be found")), llIIlllllIlI);
                        return null;
                    }
                    if (llIIllllllll.isPublic()) {
                        llIIlllllIlI.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Mixin target ").append(llIIlllllllI).append(" is public and must be specified in value")), llIIlllllIlI);
                        return null;
                    }
                }
                llIIlllllIlI.addSoftTarget(llIIllllllll, llIIlllllllI);
                if (llIIlllllIll != null) continue;
                llIIlllllIll = llIIllllllll;
            }
        }
        catch (Exception llIIllllllIl) {
            llIIlllllIlI.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Error processing private targets: ").append(llIIllllllIl.getClass().getName()).append(": ").append(llIIllllllIl.getMessage())), llIIlllllIlI);
        }
        if (llIIlllllIll == null) {
            llIIlllllIlI.printMessage(Diagnostic.Kind.ERROR, "Mixin has no targets", llIIlllllIlI);
        }
        return llIIlllllIll;
    }

    public AnnotationHandle getAnnotation() {
        AnnotatedMixin llIIllIIllII;
        return llIIllIIllII.annotation;
    }

    public void registerInjectionPoint(ExecutableElement lIllllllllII, AnnotationHandle llIIIIIIIIlI, AnnotationHandle llIIIIIIIIII, InjectorRemap lIlllllllIIl, String lIlllllllIII) {
        AnnotatedMixin llIIIIIIIllI;
        llIIIIIIIllI.injectors.registerInjectionPoint(new AnnotatedMixinElementHandlerInjector.AnnotatedElementInjectionPoint(lIllllllllII, llIIIIIIIIlI, llIIIIIIIIII, lIlllllllIIl), lIlllllllIII);
    }

    public void registerInvoker(ExecutableElement lIllllIlllll, AnnotationHandle lIlllllIIIll, boolean lIllllIlllII) {
        AnnotatedMixin lIlllllIIllI;
        lIlllllIIllI.methods.remove(lIllllIlllll);
        lIlllllIIllI.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor.AnnotatedElementInvoker(lIllllIlllll, lIlllllIIIll, lIllllIlllII));
    }

    public boolean isInterface() {
        AnnotatedMixin llIIlIllIlll;
        return llIIlIllIlll.mixin.getKind() == ElementKind.INTERFACE;
    }

    private void addTarget(TypeHandle llIIllIllIlI) {
        AnnotatedMixin llIIllIllIll;
        llIIllIllIll.targets.add(llIIllIllIlI);
    }

    public boolean remap() {
        AnnotatedMixin llIIlIIllIll;
        return llIIlIIllIll.remap;
    }

    public String getClassRef() {
        AnnotatedMixin llIIlIlllIlI;
        return llIIlIlllIlI.classRef;
    }

    @Deprecated
    public TypeHandle getPrimaryTarget() {
        AnnotatedMixin llIIlIllIIll;
        return llIIlIllIIll.primaryTarget;
    }

    public AnnotatedMixin(IMixinAnnotationProcessor llIlIIIllIlI, TypeElement llIlIIIllIIl) {
        AnnotatedMixin llIlIIIllIll;
        llIlIIIllIll.targets = new ArrayList<TypeHandle>();
        llIlIIIllIll.validated = false;
        llIlIIIllIll.typeProvider = llIlIIIllIlI.getTypeProvider();
        llIlIIIllIll.obf = llIlIIIllIlI.getObfuscationManager();
        llIlIIIllIll.mappings = llIlIIIllIll.obf.createMappingConsumer();
        llIlIIIllIll.messager = llIlIIIllIlI;
        llIlIIIllIll.mixin = llIlIIIllIIl;
        llIlIIIllIll.handle = new TypeHandle(llIlIIIllIIl);
        llIlIIIllIll.methods = new ArrayList(llIlIIIllIll.handle.getEnclosedElements(ElementKind.METHOD));
        llIlIIIllIll.virtual = llIlIIIllIll.handle.getAnnotation(Pseudo.class).exists();
        llIlIIIllIll.annotation = llIlIIIllIll.handle.getAnnotation(Mixin.class);
        llIlIIIllIll.classRef = TypeUtils.getInternalName(llIlIIIllIIl);
        llIlIIIllIll.primaryTarget = llIlIIIllIll.initTargets();
        llIlIIIllIll.remap = llIlIIIllIll.annotation.getBoolean("remap", true) && llIlIIIllIll.targets.size() > 0;
        llIlIIIllIll.overwrites = new AnnotatedMixinElementHandlerOverwrite(llIlIIIllIlI, llIlIIIllIll);
        llIlIIIllIll.shadows = new AnnotatedMixinElementHandlerShadow(llIlIIIllIlI, llIlIIIllIll);
        llIlIIIllIll.injectors = new AnnotatedMixinElementHandlerInjector(llIlIIIllIlI, llIlIIIllIll);
        llIlIIIllIll.accessors = new AnnotatedMixinElementHandlerAccessor(llIlIIIllIlI, llIlIIIllIll);
        llIlIIIllIll.softImplements = new AnnotatedMixinElementHandlerSoftImplements(llIlIIIllIlI, llIlIIIllIll);
    }

    public String toString() {
        AnnotatedMixin llIIllIlIIll;
        return llIIllIlIIll.mixin.getSimpleName().toString();
    }

    public IMappingConsumer getMappings() {
        AnnotatedMixin llIIlIIllIII;
        return llIIlIIllIII.mappings;
    }
}

