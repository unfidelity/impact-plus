/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.InvalidMemberDescriptorException;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandler;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.ReferenceManager;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IReferenceManager;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.struct.InjectorRemap;

class AnnotatedMixinElementHandlerInjector
extends AnnotatedMixinElementHandler {
    private boolean registerInjector(AnnotatedElementInjector llllllllllllllllllllIlllllIllIIl, String llllllllllllllllllllIlllllIllIII, MemberInfo llllllllllllllllllllIlllllIlIlll, TypeHandle llllllllllllllllllllIllllllIIIII) {
        AnnotatedMixinElementHandlerInjector llllllllllllllllllllIlllllIllIlI;
        String llllllllllllllllllllIlllllIlllll = llllllllllllllllllllIllllllIIIII.findDescriptor(llllllllllllllllllllIlllllIlIlll);
        if (llllllllllllllllllllIlllllIlllll == null) {
            Diagnostic.Kind llllllllllllllllllllIllllllIlIlI;
            Diagnostic.Kind kind = llllllllllllllllllllIllllllIlIlI = llllllllllllllllllllIlllllIllIlI.mixin.isMultiTarget() ? Diagnostic.Kind.ERROR : Diagnostic.Kind.WARNING;
            if (llllllllllllllllllllIllllllIIIII.isSimulated()) {
                llllllllllllllllllllIlllllIllIIl.printMessage(llllllllllllllllllllIlllllIllIlI.ap, Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllllIllIIl).append(" target '").append(llllllllllllllllllllIlllllIllIII).append("' in @Pseudo mixin will not be obfuscated")));
            } else if (llllllllllllllllllllIllllllIIIII.isImaginary()) {
                llllllllllllllllllllIlllllIllIIl.printMessage(llllllllllllllllllllIlllllIllIlI.ap, llllllllllllllllllllIllllllIlIlI, String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllllIllIIl).append(" target requires method signature because enclosing type information for ").append(llllllllllllllllllllIllllllIIIII).append(" is unavailable")));
            } else if (!llllllllllllllllllllIlllllIlIlll.isInitialiser()) {
                llllllllllllllllllllIlllllIllIIl.printMessage(llllllllllllllllllllIlllllIllIlI.ap, llllllllllllllllllllIllllllIlIlI, String.valueOf(new StringBuilder().append("Unable to determine signature for ").append(llllllllllllllllllllIlllllIllIIl).append(" target method")));
            }
            return true;
        }
        String llllllllllllllllllllIlllllIllllI = String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllllIllIIl).append(" target ").append(llllllllllllllllllllIlllllIlIlll.name));
        MappingMethod llllllllllllllllllllIlllllIlllIl = llllllllllllllllllllIllllllIIIII.getMappingMethod(llllllllllllllllllllIlllllIlIlll.name, llllllllllllllllllllIlllllIlllll);
        ObfuscationData<MappingMethod> llllllllllllllllllllIlllllIlllII = llllllllllllllllllllIlllllIllIlI.obf.getDataProvider().getObfMethod(llllllllllllllllllllIlllllIlllIl);
        if (llllllllllllllllllllIlllllIlllII.isEmpty()) {
            if (llllllllllllllllllllIllllllIIIII.isSimulated()) {
                llllllllllllllllllllIlllllIlllII = llllllllllllllllllllIlllllIllIlI.obf.getDataProvider().getRemappedMethod(llllllllllllllllllllIlllllIlllIl);
            } else {
                if (llllllllllllllllllllIlllllIlIlll.isClassInitialiser()) {
                    return true;
                }
                Diagnostic.Kind llllllllllllllllllllIllllllIlIIl = llllllllllllllllllllIlllllIlIlll.isConstructor() ? Diagnostic.Kind.WARNING : Diagnostic.Kind.ERROR;
                llllllllllllllllllllIlllllIllIIl.addMessage(llllllllllllllllllllIllllllIlIIl, String.valueOf(new StringBuilder().append("No obfuscation mapping for ").append(llllllllllllllllllllIlllllIllllI)), (Element)llllllllllllllllllllIlllllIllIIl.getElement(), llllllllllllllllllllIlllllIllIIl.getAnnotation());
                return false;
            }
        }
        IReferenceManager llllllllllllllllllllIlllllIllIll = llllllllllllllllllllIlllllIllIlI.obf.getReferenceManager();
        try {
            if (llllllllllllllllllllIlllllIlIlll.owner == null && llllllllllllllllllllIlllllIllIlI.mixin.isMultiTarget() || llllllllllllllllllllIllllllIIIII.isSimulated()) {
                llllllllllllllllllllIlllllIlllII = AnnotatedMixinElementHandler.stripOwnerData(llllllllllllllllllllIlllllIlllII);
            }
            llllllllllllllllllllIlllllIllIll.addMethodMapping(llllllllllllllllllllIlllllIllIlI.classRef, llllllllllllllllllllIlllllIllIII, llllllllllllllllllllIlllllIlllII);
        }
        catch (ReferenceManager.ReferenceConflictException llllllllllllllllllllIllllllIIlIl) {
            String llllllllllllllllllllIllllllIIllI;
            String string = llllllllllllllllllllIllllllIIllI = llllllllllllllllllllIlllllIllIlI.mixin.isMultiTarget() ? "Multi-target" : "Target";
            if (llllllllllllllllllllIlllllIllIIl.hasCoerceArgument() && llllllllllllllllllllIlllllIlIlll.owner == null && llllllllllllllllllllIlllllIlIlll.desc == null) {
                MemberInfo llllllllllllllllllllIllllllIlIII = MemberInfo.parse(llllllllllllllllllllIllllllIIlIl.getOld());
                MemberInfo llllllllllllllllllllIllllllIIlll = MemberInfo.parse(llllllllllllllllllllIllllllIIlIl.getNew());
                if (llllllllllllllllllllIllllllIlIII.name.equals(llllllllllllllllllllIllllllIIlll.name)) {
                    llllllllllllllllllllIlllllIlllII = AnnotatedMixinElementHandler.stripDescriptors(llllllllllllllllllllIlllllIlllII);
                    llllllllllllllllllllIlllllIllIll.setAllowConflicts(true);
                    llllllllllllllllllllIlllllIllIll.addMethodMapping(llllllllllllllllllllIlllllIllIlI.classRef, llllllllllllllllllllIlllllIllIII, llllllllllllllllllllIlllllIlllII);
                    llllllllllllllllllllIlllllIllIll.setAllowConflicts(false);
                    llllllllllllllllllllIlllllIllIIl.printMessage(llllllllllllllllllllIlllllIllIlI.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Coerced ").append(llllllllllllllllllllIllllllIIllI).append(" reference has conflicting descriptors for ").append(llllllllllllllllllllIlllllIllllI).append(": Storing bare references ").append(llllllllllllllllllllIlllllIlllII.values()).append(" in refMap")));
                    return true;
                }
            }
            llllllllllllllllllllIlllllIllIIl.printMessage(llllllllllllllllllllIlllllIllIlI.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(llllllllllllllllllllIllllllIIllI).append(" reference conflict for ").append(llllllllllllllllllllIlllllIllllI).append(": ").append(llllllllllllllllllllIlllllIllIII).append(" -> ").append(llllllllllllllllllllIllllllIIlIl.getNew()).append(" previously defined as ").append(llllllllllllllllllllIllllllIIlIl.getOld())));
        }
        return true;
    }

    public void registerInjectionPoint(AnnotatedElementInjectionPoint llllllllllllllllllllIlllllIIIIIl, String llllllllllllllllllllIlllllIIIIII) {
        AnnotatedMixinElementHandlerInjector llllllllllllllllllllIlllllIIIIlI;
        if (llllllllllllllllllllIlllllIIIIlI.mixin.isInterface()) {
            llllllllllllllllllllIlllllIIIIlI.ap.printMessage(Diagnostic.Kind.ERROR, "Injector in interface is unsupported", (Element)llllllllllllllllllllIlllllIIIIIl.getElement());
        }
        if (!llllllllllllllllllllIlllllIIIIIl.shouldRemap()) {
            return;
        }
        String llllllllllllllllllllIlllllIIIlII = InjectionPointData.parseType((String)llllllllllllllllllllIlllllIIIIIl.getAt().getValue("value"));
        String llllllllllllllllllllIlllllIIIIll = (String)llllllllllllllllllllIlllllIIIIIl.getAt().getValue("target");
        if ("NEW".equals(llllllllllllllllllllIlllllIIIlII)) {
            llllllllllllllllllllIlllllIIIIlI.remapNewTarget(String.format(llllllllllllllllllllIlllllIIIIII, String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllllIIIlII).append(".<target>"))), llllllllllllllllllllIlllllIIIIll, llllllllllllllllllllIlllllIIIIIl);
            llllllllllllllllllllIlllllIIIIlI.remapNewTarget(String.format(llllllllllllllllllllIlllllIIIIII, String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllllIIIlII).append(".args[class]"))), llllllllllllllllllllIlllllIIIIIl.getAtArg("class"), llllllllllllllllllllIlllllIIIIIl);
        } else {
            llllllllllllllllllllIlllllIIIIlI.remapReference(String.format(llllllllllllllllllllIlllllIIIIII, String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllllIIIlII).append(".<target>"))), llllllllllllllllllllIlllllIIIIll, llllllllllllllllllllIlllllIIIIIl);
        }
    }

    protected final void remapNewTarget(String llllllllllllllllllllIllllIIlIlII, String llllllllllllllllllllIllllIIIllIl, AnnotatedElementInjectionPoint llllllllllllllllllllIllllIIIllII) {
        if (llllllllllllllllllllIllllIIIllIl == null) {
            return;
        }
        MemberInfo llllllllllllllllllllIllllIIlIIIl = MemberInfo.parse(llllllllllllllllllllIllllIIIllIl);
        String llllllllllllllllllllIllllIIlIIII = llllllllllllllllllllIllllIIlIIIl.toCtorType();
        if (llllllllllllllllllllIllllIIlIIII != null) {
            AnnotatedMixinElementHandlerInjector llllllllllllllllllllIllllIIlIlIl;
            String llllllllllllllllllllIllllIIllIIl = llllllllllllllllllllIllllIIlIIIl.toCtorDesc();
            MappingMethod llllllllllllllllllllIllllIIllIII = new MappingMethod(llllllllllllllllllllIllllIIlIIII, ".", llllllllllllllllllllIllllIIllIIl != null ? llllllllllllllllllllIllllIIllIIl : "()V");
            ObfuscationData<MappingMethod> llllllllllllllllllllIllllIIlIlll = llllllllllllllllllllIllllIIlIlIl.obf.getDataProvider().getRemappedMethod(llllllllllllllllllllIllllIIllIII);
            if (llllllllllllllllllllIllllIIlIlll.isEmpty()) {
                llllllllllllllllllllIllllIIlIlIl.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Cannot find class mapping for ").append(llllllllllllllllllllIllllIIlIlII).append(" '").append(llllllllllllllllllllIllllIIlIIII).append("'")), (Element)llllllllllllllllllllIllllIIIllII.getElement(), llllllllllllllllllllIllllIIIllII.getAnnotation().asMirror());
                return;
            }
            ObfuscationData<String> llllllllllllllllllllIllllIIlIllI = new ObfuscationData<String>();
            for (ObfuscationType llllllllllllllllllllIllllIIllIlI : llllllllllllllllllllIllllIIlIlll) {
                MappingMethod llllllllllllllllllllIllllIIllIll = llllllllllllllllllllIllllIIlIlll.get(llllllllllllllllllllIllllIIllIlI);
                if (llllllllllllllllllllIllllIIllIIl == null) {
                    llllllllllllllllllllIllllIIlIllI.put(llllllllllllllllllllIllllIIllIlI, llllllllllllllllllllIllllIIllIll.getOwner());
                    continue;
                }
                llllllllllllllllllllIllllIIlIllI.put(llllllllllllllllllllIllllIIllIlI, llllllllllllllllllllIllllIIllIll.getDesc().replace(")V", String.valueOf(new StringBuilder().append(")L").append(llllllllllllllllllllIllllIIllIll.getOwner()).append(";"))));
            }
            llllllllllllllllllllIllllIIlIlIl.obf.getReferenceManager().addClassMapping(llllllllllllllllllllIllllIIlIlIl.classRef, llllllllllllllllllllIllllIIIllIl, llllllllllllllllllllIllllIIlIllI);
        }
        llllllllllllllllllllIllllIIIllII.notifyRemapped();
    }

    protected final void remapReference(String llllllllllllllllllllIlllIlllIlIl, String llllllllllllllllllllIlllIlllIlII, AnnotatedElementInjectionPoint llllllllllllllllllllIlllIlllIIll) {
        AnnotatedMixinElementHandlerInjector llllllllllllllllllllIlllIlllIIII;
        if (llllllllllllllllllllIlllIlllIlII == null) {
            return;
        }
        AnnotationMirror llllllllllllllllllllIlllIlllIIlI = (llllllllllllllllllllIlllIlllIIII.ap.getCompilerEnvironment() == IMixinAnnotationProcessor.CompilerEnvironment.JDT ? llllllllllllllllllllIlllIlllIIll.getAt() : llllllllllllllllllllIlllIlllIIll.getAnnotation()).asMirror();
        MemberInfo llllllllllllllllllllIlllIlllIIIl = MemberInfo.parse(llllllllllllllllllllIlllIlllIlII);
        if (!llllllllllllllllllllIlllIlllIIIl.isFullyQualified()) {
            String llllllllllllllllllllIlllIllllIll = llllllllllllllllllllIlllIlllIIIl.owner == null ? (llllllllllllllllllllIlllIlllIIIl.desc == null ? "owner and signature" : "owner") : "signature";
            llllllllllllllllllllIlllIlllIIII.ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(llllllllllllllllllllIlllIlllIlIl).append(" is not fully qualified, missing ").append(llllllllllllllllllllIlllIllllIll)), (Element)llllllllllllllllllllIlllIlllIIll.getElement(), llllllllllllllllllllIlllIlllIIlI);
            return;
        }
        try {
            llllllllllllllllllllIlllIlllIIIl.validate();
        }
        catch (InvalidMemberDescriptorException llllllllllllllllllllIlllIllllIlI) {
            llllllllllllllllllllIlllIlllIIII.ap.printMessage(Diagnostic.Kind.ERROR, llllllllllllllllllllIlllIllllIlI.getMessage(), (Element)llllllllllllllllllllIlllIlllIIll.getElement(), llllllllllllllllllllIlllIlllIIlI);
        }
        try {
            if (llllllllllllllllllllIlllIlllIIIl.isField()) {
                ObfuscationData<MappingField> llllllllllllllllllllIlllIllllIIl = llllllllllllllllllllIlllIlllIIII.obf.getDataProvider().getObfFieldRecursive(llllllllllllllllllllIlllIlllIIIl);
                if (llllllllllllllllllllIlllIllllIIl.isEmpty()) {
                    llllllllllllllllllllIlllIlllIIII.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Cannot find field mapping for ").append(llllllllllllllllllllIlllIlllIlIl).append(" '").append(llllllllllllllllllllIlllIlllIlII).append("'")), (Element)llllllllllllllllllllIlllIlllIIll.getElement(), llllllllllllllllllllIlllIlllIIlI);
                    return;
                }
                llllllllllllllllllllIlllIlllIIII.obf.getReferenceManager().addFieldMapping(llllllllllllllllllllIlllIlllIIII.classRef, llllllllllllllllllllIlllIlllIlII, llllllllllllllllllllIlllIlllIIIl, llllllllllllllllllllIlllIllllIIl);
            } else {
                ObfuscationData<MappingMethod> llllllllllllllllllllIlllIllllIII = llllllllllllllllllllIlllIlllIIII.obf.getDataProvider().getObfMethodRecursive(llllllllllllllllllllIlllIlllIIIl);
                if (llllllllllllllllllllIlllIllllIII.isEmpty() && (llllllllllllllllllllIlllIlllIIIl.owner == null || !llllllllllllllllllllIlllIlllIIIl.owner.startsWith("java/lang/"))) {
                    llllllllllllllllllllIlllIlllIIII.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Cannot find method mapping for ").append(llllllllllllllllllllIlllIlllIlIl).append(" '").append(llllllllllllllllllllIlllIlllIlII).append("'")), (Element)llllllllllllllllllllIlllIlllIIll.getElement(), llllllllllllllllllllIlllIlllIIlI);
                    return;
                }
                llllllllllllllllllllIlllIlllIIII.obf.getReferenceManager().addMethodMapping(llllllllllllllllllllIlllIlllIIII.classRef, llllllllllllllllllllIlllIlllIlII, llllllllllllllllllllIlllIlllIIIl, llllllllllllllllllllIlllIllllIII);
            }
        }
        catch (ReferenceManager.ReferenceConflictException llllllllllllllllllllIlllIlllIlll) {
            llllllllllllllllllllIlllIlllIIII.ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Unexpected reference conflict for ").append(llllllllllllllllllllIlllIlllIlIl).append(": ").append(llllllllllllllllllllIlllIlllIlII).append(" -> ").append(llllllllllllllllllllIlllIlllIlll.getNew()).append(" previously defined as ").append(llllllllllllllllllllIlllIlllIlll.getOld())), (Element)llllllllllllllllllllIlllIlllIIll.getElement(), llllllllllllllllllllIlllIlllIIlI);
            return;
        }
        llllllllllllllllllllIlllIlllIIll.notifyRemapped();
    }

    AnnotatedMixinElementHandlerInjector(IMixinAnnotationProcessor lllllllllllllllllllllIIIIIIlIIIl, AnnotatedMixin lllllllllllllllllllllIIIIIIlIIII) {
        super(lllllllllllllllllllllIIIIIIlIIIl, lllllllllllllllllllllIIIIIIlIIII);
        AnnotatedMixinElementHandlerInjector lllllllllllllllllllllIIIIIIIllll;
    }

    public void registerInjector(AnnotatedElementInjector llllllllllllllllllllIllllllllllI) {
        AnnotatedMixinElementHandlerInjector lllllllllllllllllllllIIIIIIIIIIl;
        if (lllllllllllllllllllllIIIIIIIIIIl.mixin.isInterface()) {
            lllllllllllllllllllllIIIIIIIIIIl.ap.printMessage(Diagnostic.Kind.ERROR, "Injector in interface is unsupported", (Element)llllllllllllllllllllIllllllllllI.getElement());
        }
        for (String lllllllllllllllllllllIIIIIIIIIlI : llllllllllllllllllllIllllllllllI.getAnnotation().getList("method")) {
            MemberInfo lllllllllllllllllllllIIIIIIIIIll = MemberInfo.parse(lllllllllllllllllllllIIIIIIIIIlI);
            if (lllllllllllllllllllllIIIIIIIIIll.name == null) continue;
            try {
                lllllllllllllllllllllIIIIIIIIIll.validate();
            }
            catch (InvalidMemberDescriptorException lllllllllllllllllllllIIIIIIIIlIl) {
                llllllllllllllllllllIllllllllllI.printMessage(lllllllllllllllllllllIIIIIIIIIIl.ap, Diagnostic.Kind.ERROR, lllllllllllllllllllllIIIIIIIIlIl.getMessage());
            }
            if (lllllllllllllllllllllIIIIIIIIIll.desc != null) {
                lllllllllllllllllllllIIIIIIIIIIl.validateReferencedTarget((ExecutableElement)llllllllllllllllllllIllllllllllI.getElement(), llllllllllllllllllllIllllllllllI.getAnnotation(), lllllllllllllllllllllIIIIIIIIIll, llllllllllllllllllllIllllllllllI.toString());
            }
            if (!llllllllllllllllllllIllllllllllI.shouldRemap()) continue;
            for (TypeHandle lllllllllllllllllllllIIIIIIIIlII : lllllllllllllllllllllIIIIIIIIIIl.mixin.getTargets()) {
                if (!lllllllllllllllllllllIIIIIIIIIIl.registerInjector(llllllllllllllllllllIllllllllllI, lllllllllllllllllllllIIIIIIIIIlI, lllllllllllllllllllllIIIIIIIIIll, lllllllllllllllllllllIIIIIIIIlII)) break;
            }
        }
    }

    static class AnnotatedElementInjectionPoint
    extends AnnotatedMixinElementHandler.AnnotatedElement<ExecutableElement> {
        private final /* synthetic */ AnnotationHandle at;
        private final /* synthetic */ InjectorRemap state;
        private /* synthetic */ Map<String, String> args;

        public AnnotatedElementInjectionPoint(ExecutableElement llllllllllllllllIllIlllIIlIlIlII, AnnotationHandle llllllllllllllllIllIlllIIlIlIIll, AnnotationHandle llllllllllllllllIllIlllIIlIIllIl, InjectorRemap llllllllllllllllIllIlllIIlIIllII) {
            super(llllllllllllllllIllIlllIIlIlIlII, llllllllllllllllIllIlllIIlIlIIll);
            AnnotatedElementInjectionPoint llllllllllllllllIllIlllIIlIlIIII;
            llllllllllllllllIllIlllIIlIlIIII.at = llllllllllllllllIllIlllIIlIIllIl;
            llllllllllllllllIllIlllIIlIlIIII.state = llllllllllllllllIllIlllIIlIIllII;
        }

        public void notifyRemapped() {
            AnnotatedElementInjectionPoint llllllllllllllllIllIlllIIIllIlIl;
            llllllllllllllllIllIlllIIIllIlIl.state.notifyRemapped();
        }

        public String getAtArg(String llllllllllllllllIllIlllIIIllllIl) {
            AnnotatedElementInjectionPoint llllllllllllllllIllIlllIIIlllllI;
            if (llllllllllllllllIllIlllIIIlllllI.args == null) {
                llllllllllllllllIllIlllIIIlllllI.args = new HashMap<String, String>();
                for (String llllllllllllllllIllIlllIIIllllll : llllllllllllllllIllIlllIIIlllllI.at.getList("args")) {
                    if (llllllllllllllllIllIlllIIIllllll == null) continue;
                    int llllllllllllllllIllIlllIIlIIIIII = llllllllllllllllIllIlllIIIllllll.indexOf(61);
                    if (llllllllllllllllIllIlllIIlIIIIII > -1) {
                        llllllllllllllllIllIlllIIIlllllI.args.put(llllllllllllllllIllIlllIIIllllll.substring(0, llllllllllllllllIllIlllIIlIIIIII), llllllllllllllllIllIlllIIIllllll.substring(llllllllllllllllIllIlllIIlIIIIII + 1));
                        continue;
                    }
                    llllllllllllllllIllIlllIIIlllllI.args.put(llllllllllllllllIllIlllIIIllllll, "");
                }
            }
            return llllllllllllllllIllIlllIIIlllllI.args.get(llllllllllllllllIllIlllIIIllllIl);
        }

        public boolean shouldRemap() {
            AnnotatedElementInjectionPoint llllllllllllllllIllIlllIIlIIlIIl;
            return llllllllllllllllIllIlllIIlIIlIIl.at.getBoolean("remap", llllllllllllllllIllIlllIIlIIlIIl.state.shouldRemap());
        }

        public AnnotationHandle getAt() {
            AnnotatedElementInjectionPoint llllllllllllllllIllIlllIIlIIIlll;
            return llllllllllllllllIllIlllIIlIIIlll.at;
        }
    }

    static class AnnotatedElementInjector
    extends AnnotatedMixinElementHandler.AnnotatedElement<ExecutableElement> {
        private final /* synthetic */ InjectorRemap state;

        public boolean hasCoerceArgument() {
            AnnotatedElementInjector llllllllllllllllIlIIIlIIIlIIlIll;
            if (!llllllllllllllllIlIIIlIIIlIIlIll.annotation.toString().equals("@Inject")) {
                return false;
            }
            Iterator<? extends VariableElement> llllllllllllllllIlIIIlIIIlIIlIlI = ((ExecutableElement)llllllllllllllllIlIIIlIIIlIIlIll.element).getParameters().iterator();
            if (llllllllllllllllIlIIIlIIIlIIlIlI.hasNext()) {
                VariableElement llllllllllllllllIlIIIlIIIlIIlllI = llllllllllllllllIlIIIlIIIlIIlIlI.next();
                return AnnotationHandle.of(llllllllllllllllIlIIIlIIIlIIlllI, Coerce.class).exists();
            }
            return false;
        }

        public AnnotatedElementInjector(ExecutableElement llllllllllllllllIlIIIlIIIllIlIlI, AnnotationHandle llllllllllllllllIlIIIlIIIllIIIlI, InjectorRemap llllllllllllllllIlIIIlIIIllIIlll) {
            super(llllllllllllllllIlIIIlIIIllIlIlI, llllllllllllllllIlIIIlIIIllIIIlI);
            AnnotatedElementInjector llllllllllllllllIlIIIlIIIllIIllI;
            llllllllllllllllIlIIIlIIIllIIllI.state = llllllllllllllllIlIIIlIIIllIIlll;
        }

        public void addMessage(Diagnostic.Kind llllllllllllllllIlIIIlIIIIllIlll, CharSequence llllllllllllllllIlIIIlIIIIllllIl, Element llllllllllllllllIlIIIlIIIIlllIll, AnnotationHandle llllllllllllllllIlIIIlIIIIlllIIl) {
            AnnotatedElementInjector llllllllllllllllIlIIIlIIIIlllIII;
            llllllllllllllllIlIIIlIIIIlllIII.state.addMessage(llllllllllllllllIlIIIlIIIIllIlll, llllllllllllllllIlIIIlIIIIllllIl, llllllllllllllllIlIIIlIIIIlllIll, llllllllllllllllIlIIIlIIIIlllIIl);
        }

        public String toString() {
            AnnotatedElementInjector llllllllllllllllIlIIIlIIIIllIIII;
            return llllllllllllllllIlIIIlIIIIllIIII.getAnnotation().toString();
        }

        public boolean shouldRemap() {
            AnnotatedElementInjector llllllllllllllllIlIIIlIIIlIllIII;
            return llllllllllllllllIlIIIlIIIlIllIII.state.shouldRemap();
        }
    }
}

