/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.tools.obfuscation;

import com.google.common.base.Strings;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.gen.AccessorInfo;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandler;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ReferenceManager;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.FieldHandle;
import org.spongepowered.tools.obfuscation.mirror.MethodHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

public class AnnotatedMixinElementHandlerAccessor
extends AnnotatedMixinElementHandler
implements IMixinContext {
    @Override
    public String getTargetClassRef() {
        throw new UnsupportedOperationException("Target class not available at compile time");
    }

    @Override
    public Extensions getExtensions() {
        throw new UnsupportedOperationException("Mixin Extensions not available at compile time");
    }

    @Override
    public boolean getOption(MixinEnvironment.Option lIllIIllIlIllI) {
        throw new UnsupportedOperationException("Options not available at compile time");
    }

    public AnnotatedMixinElementHandlerAccessor(IMixinAnnotationProcessor lIllIIlllIIIll, AnnotatedMixin lIllIIlllIIIlI) {
        super(lIllIIlllIIIll, lIllIIlllIIIlI);
        AnnotatedMixinElementHandlerAccessor lIllIIlllIIlII;
    }

    @Override
    public Target getTargetMethod(MethodNode lIllIIllIlIIll) {
        throw new UnsupportedOperationException("Target not available at compile time");
    }

    public void registerAccessor(AnnotatedElementAccessor lIllIIllIIlIll) {
        AnnotatedMixinElementHandlerAccessor lIllIIllIIllII;
        if (lIllIIllIIlIll.getAccessorType() == null) {
            lIllIIllIIlIll.printMessage(lIllIIllIIllII.ap, Diagnostic.Kind.WARNING, "Unsupported accessor type");
            return;
        }
        String lIllIIllIIlIlI = lIllIIllIIllII.getAccessorTargetName(lIllIIllIIlIll);
        if (lIllIIllIIlIlI == null) {
            lIllIIllIIlIll.printMessage(lIllIIllIIllII.ap, Diagnostic.Kind.WARNING, "Cannot inflect accessor target name");
            return;
        }
        lIllIIllIIlIll.setTargetName(lIllIIllIIlIlI);
        for (TypeHandle lIllIIllIIllIl : lIllIIllIIllII.mixin.getTargets()) {
            if (lIllIIllIIlIll.getAccessorType() == AccessorInfo.AccessorType.METHOD_PROXY) {
                lIllIIllIIllII.registerInvokerForTarget((AnnotatedElementInvoker)lIllIIllIIlIll, lIllIIllIIllIl);
                continue;
            }
            lIllIIllIIllII.registerAccessorForTarget(lIllIIllIIlIll, lIllIIllIIllIl);
        }
    }

    private String inflectAccessorTarget(AnnotatedElementAccessor lIlIllIIllIIII) {
        AnnotatedMixinElementHandlerAccessor lIlIllIIllIIIl;
        return AccessorInfo.inflectTarget(lIlIllIIllIIII.getSimpleName(), lIlIllIIllIIII.getAccessorType(), "", lIlIllIIllIIIl, false);
    }

    private String getAccessorTargetName(AnnotatedElementAccessor lIlIllIIllIlll) {
        String lIlIllIIlllIIl = lIlIllIIllIlll.getAnnotationValue();
        if (Strings.isNullOrEmpty((String)lIlIllIIlllIIl)) {
            AnnotatedMixinElementHandlerAccessor lIlIllIIlllIII;
            return lIlIllIIlllIII.inflectAccessorTarget(lIlIllIIllIlll);
        }
        return lIlIllIIlllIIl;
    }

    @Override
    public String getClassRef() {
        AnnotatedMixinElementHandlerAccessor lIllIIllIllIll;
        return lIllIIllIllIll.mixin.getClassRef();
    }

    @Override
    public ReferenceMapper getReferenceMapper() {
        return null;
    }

    private void registerInvokerForTarget(AnnotatedElementInvoker lIlIllIlIIIIll, TypeHandle lIlIllIlIIIIlI) {
        AnnotatedMixinElementHandlerAccessor lIlIllIlIIIlII;
        MethodHandle lIlIllIlIIIllI = lIlIllIlIIIIlI.findMethod(lIlIllIlIIIIll.getTargetName(), lIlIllIlIIIIll.getTargetTypeName(), false);
        if (lIlIllIlIIIllI == null) {
            if (!lIlIllIlIIIIlI.isImaginary()) {
                lIlIllIlIIIIll.printMessage(lIlIllIlIIIlII.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Could not locate @Invoker target ").append(lIlIllIlIIIIll).append(" in target ").append(lIlIllIlIIIIlI)));
                return;
            }
            lIlIllIlIIIllI = new MethodHandle(lIlIllIlIIIIlI, lIlIllIlIIIIll.getTargetName(), lIlIllIlIIIIll.getDesc());
        }
        if (!lIlIllIlIIIIll.shouldRemap()) {
            return;
        }
        ObfuscationData<MappingMethod> lIlIllIlIIIlIl = lIlIllIlIIIlII.obf.getDataProvider().getObfMethod(lIlIllIlIIIllI.asMapping(false).move(lIlIllIlIIIIlI.getName()));
        if (lIlIllIlIIIlIl.isEmpty()) {
            String lIlIllIlIIlIll = lIlIllIlIIIlII.mixin.isMultiTarget() ? String.valueOf(new StringBuilder().append(" in target ").append(lIlIllIlIIIIlI)) : "";
            lIlIllIlIIIIll.printMessage(lIlIllIlIIIlII.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Unable to locate obfuscation mapping").append(lIlIllIlIIlIll).append(" for @Accessor target ").append(lIlIllIlIIIIll)));
            return;
        }
        lIlIllIlIIIlIl = AnnotatedMixinElementHandler.stripOwnerData(lIlIllIlIIIlIl);
        try {
            lIlIllIlIIIlII.obf.getReferenceManager().addMethodMapping(lIlIllIlIIIlII.mixin.getClassRef(), lIlIllIlIIIIll.getTargetName(), lIlIllIlIIIIll.getContext(), lIlIllIlIIIlIl);
        }
        catch (ReferenceManager.ReferenceConflictException lIlIllIlIIlIlI) {
            lIlIllIlIIIIll.printMessage(lIlIllIlIIIlII.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Mapping conflict for @Invoker target ").append(lIlIllIlIIIIll).append(": ").append(lIlIllIlIIlIlI.getNew()).append(" for target ").append(lIlIllIlIIIIlI).append(" conflicts with existing mapping ").append(lIlIllIlIIlIlI.getOld())));
        }
    }

    @Override
    public IMixinInfo getMixin() {
        throw new UnsupportedOperationException("MixinInfo not available at compile time");
    }

    @Override
    public int getPriority() {
        throw new UnsupportedOperationException("Priority not available at compile time");
    }

    private void registerAccessorForTarget(AnnotatedElementAccessor lIllIIlIlllIll, TypeHandle lIllIIlIlllIlI) {
        AnnotatedMixinElementHandlerAccessor lIllIIlIllllII;
        FieldHandle lIllIIlIlllIIl = lIllIIlIlllIlI.findField(lIllIIlIlllIll.getTargetName(), lIllIIlIlllIll.getTargetTypeName(), false);
        if (lIllIIlIlllIIl == null) {
            if (!lIllIIlIlllIlI.isImaginary()) {
                lIllIIlIlllIll.printMessage(lIllIIlIllllII.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Could not locate @Accessor target ").append(lIllIIlIlllIll).append(" in target ").append(lIllIIlIlllIlI)));
                return;
            }
            lIllIIlIlllIIl = new FieldHandle(lIllIIlIlllIlI.getName(), lIllIIlIlllIll.getTargetName(), lIllIIlIlllIll.getDesc());
        }
        if (!lIllIIlIlllIll.shouldRemap()) {
            return;
        }
        ObfuscationData<MappingField> lIllIIlIlllIII = lIllIIlIllllII.obf.getDataProvider().getObfField(((MappingField)lIllIIlIlllIIl.asMapping(false)).move(lIllIIlIlllIlI.getName()));
        if (lIllIIlIlllIII.isEmpty()) {
            String lIllIIlIlllllI = lIllIIlIllllII.mixin.isMultiTarget() ? String.valueOf(new StringBuilder().append(" in target ").append(lIllIIlIlllIlI)) : "";
            lIllIIlIlllIll.printMessage(lIllIIlIllllII.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Unable to locate obfuscation mapping").append(lIllIIlIlllllI).append(" for @Accessor target ").append(lIllIIlIlllIll)));
            return;
        }
        lIllIIlIlllIII = AnnotatedMixinElementHandler.stripOwnerData(lIllIIlIlllIII);
        try {
            lIllIIlIllllII.obf.getReferenceManager().addFieldMapping(lIllIIlIllllII.mixin.getClassRef(), lIllIIlIlllIll.getTargetName(), lIllIIlIlllIll.getContext(), lIllIIlIlllIII);
        }
        catch (ReferenceManager.ReferenceConflictException lIllIIlIllllIl) {
            lIllIIlIlllIll.printMessage(lIllIIlIllllII.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Mapping conflict for @Accessor target ").append(lIllIIlIlllIll).append(": ").append(lIllIIlIllllIl.getNew()).append(" for target ").append(lIllIIlIlllIlI).append(" conflicts with existing mapping ").append(lIllIIlIllllIl.getOld())));
        }
    }

    static class AnnotatedElementAccessor
    extends AnnotatedMixinElementHandler.AnnotatedElement<ExecutableElement> {
        private final /* synthetic */ TypeMirror returnType;
        private /* synthetic */ String targetName;
        private final /* synthetic */ boolean shouldRemap;

        public MemberInfo getContext() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIIlIII;
            return new MemberInfo(llllllllllllllllIIIIIIIlIIIIlIII.getTargetName(), null, llllllllllllllllIIIIIIIlIIIIlIII.getAccessorDesc());
        }

        public void setTargetName(String llllllllllllllllIIIIIIIlIIIIIIII) {
            llllllllllllllllIIIIIIIlIIIIIIIl.targetName = llllllllllllllllIIIIIIIlIIIIIIII;
        }

        public String getAccessorDesc() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIIlIlI;
            return TypeUtils.getInternalName(llllllllllllllllIIIIIIIlIIIIlIlI.getTargetType());
        }

        public String getTargetTypeName() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIIlllI;
            return TypeUtils.getTypeName(llllllllllllllllIIIIIIIlIIIIlllI.getTargetType());
        }

        public AnnotatedElementAccessor(ExecutableElement llllllllllllllllIIIIIIIlIIIlllll, AnnotationHandle llllllllllllllllIIIIIIIlIIIllllI, boolean llllllllllllllllIIIIIIIlIIIlllIl) {
            super(llllllllllllllllIIIIIIIlIIIlllll, llllllllllllllllIIIIIIIlIIIllllI);
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIlllII;
            llllllllllllllllIIIIIIIlIIIlllII.shouldRemap = llllllllllllllllIIIIIIIlIIIlllIl;
            llllllllllllllllIIIIIIIlIIIlllII.returnType = ((ExecutableElement)llllllllllllllllIIIIIIIlIIIlllII.getElement()).getReturnType();
        }

        public boolean shouldRemap() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIlIlll;
            return llllllllllllllllIIIIIIIlIIIlIlll.shouldRemap;
        }

        public String toString() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIIlllllIIl;
            return llllllllllllllllIIIIIIIIlllllIIl.targetName != null ? llllllllllllllllIIIIIIIIlllllIIl.targetName : "<invalid>";
        }

        public AccessorInfo.AccessorType getAccessorType() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIIIlIl;
            return llllllllllllllllIIIIIIIlIIIIIlIl.returnType.getKind() == TypeKind.VOID ? AccessorInfo.AccessorType.FIELD_SETTER : AccessorInfo.AccessorType.FIELD_GETTER;
        }

        public TypeMirror getTargetType() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIlIIIl;
            switch (llllllllllllllllIIIIIIIlIIIlIIIl.getAccessorType()) {
                case FIELD_GETTER: {
                    return llllllllllllllllIIIIIIIlIIIlIIIl.returnType;
                }
                case FIELD_SETTER: {
                    return ((ExecutableElement)llllllllllllllllIIIIIIIlIIIlIIIl.getElement()).getParameters().get(0).asType();
                }
            }
            return null;
        }

        public String getAnnotationValue() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIlIIIlIIll;
            return (String)llllllllllllllllIIIIIIIlIIIlIIll.getAnnotation().getValue();
        }

        public String getTargetName() {
            AnnotatedElementAccessor llllllllllllllllIIIIIIIIllllllII;
            return llllllllllllllllIIIIIIIIllllllII.targetName;
        }
    }

    static class AnnotatedElementInvoker
    extends AnnotatedElementAccessor {
        @Override
        public String getTargetTypeName() {
            AnnotatedElementInvoker llllllllllllllllIllIIlIlIIIlIIII;
            return TypeUtils.getJavaSignature(llllllllllllllllIllIIlIlIIIlIIII.getElement());
        }

        @Override
        public String getAccessorDesc() {
            AnnotatedElementInvoker llllllllllllllllIllIIlIlIIIlIIll;
            return TypeUtils.getDescriptor((ExecutableElement)llllllllllllllllIllIIlIlIIIlIIll.getElement());
        }

        @Override
        public AccessorInfo.AccessorType getAccessorType() {
            return AccessorInfo.AccessorType.METHOD_PROXY;
        }

        public AnnotatedElementInvoker(ExecutableElement llllllllllllllllIllIIlIlIIIlllII, AnnotationHandle llllllllllllllllIllIIlIlIIIlIlll, boolean llllllllllllllllIllIIlIlIIIlIllI) {
            super(llllllllllllllllIllIIlIlIIIlllII, llllllllllllllllIllIIlIlIIIlIlll, llllllllllllllllIllIIlIlIIIlIllI);
            AnnotatedElementInvoker llllllllllllllllIllIIlIlIIIlllIl;
        }
    }
}

