/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.AnnotatedMixinElementHandler;
import org.spongepowered.tools.obfuscation.Mappings;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

class AnnotatedMixinElementHandlerShadow
extends AnnotatedMixinElementHandler {
    private void registerShadowForTarget(AnnotatedElementShadow<?, ?> llllllllllllllllIlIIIIllllIIlIlI, TypeHandle llllllllllllllllIlIIIIllllIIlIIl) {
        AnnotatedMixinElementHandlerShadow llllllllllllllllIlIIIIllllIIlIll;
        ObfuscationData<?> llllllllllllllllIlIIIIllllIIllII = llllllllllllllllIlIIIIllllIIlIlI.getObfuscationData(llllllllllllllllIlIIIIllllIIlIll.obf.getDataProvider(), llllllllllllllllIlIIIIllllIIlIIl);
        if (llllllllllllllllIlIIIIllllIIllII.isEmpty()) {
            String llllllllllllllllIlIIIIllllIlIIlI;
            String string = llllllllllllllllIlIIIIllllIlIIlI = llllllllllllllllIlIIIIllllIIlIll.mixin.isMultiTarget() ? String.valueOf(new StringBuilder().append(" in target ").append(llllllllllllllllIlIIIIllllIIlIIl)) : "";
            if (llllllllllllllllIlIIIIllllIIlIIl.isSimulated()) {
                llllllllllllllllIlIIIIllllIIlIlI.printMessage(llllllllllllllllIlIIIIllllIIlIll.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Unable to locate obfuscation mapping").append(llllllllllllllllIlIIIIllllIlIIlI).append(" for @Shadow ").append(llllllllllllllllIlIIIIllllIIlIlI)));
            } else {
                llllllllllllllllIlIIIIllllIIlIlI.printMessage(llllllllllllllllIlIIIIllllIIlIll.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Unable to locate obfuscation mapping").append(llllllllllllllllIlIIIIllllIlIIlI).append(" for @Shadow ").append(llllllllllllllllIlIIIIllllIIlIlI)));
            }
            return;
        }
        for (ObfuscationType llllllllllllllllIlIIIIllllIlIIII : llllllllllllllllIlIIIIllllIIllII) {
            try {
                llllllllllllllllIlIIIIllllIIlIlI.addMapping(llllllllllllllllIlIIIIllllIlIIII, (IMapping)llllllllllllllllIlIIIIllllIIllII.get(llllllllllllllllIlIIIIllllIlIIII));
            }
            catch (Mappings.MappingConflictException llllllllllllllllIlIIIIllllIlIIIl) {
                llllllllllllllllIlIIIIllllIIlIlI.printMessage(llllllllllllllllIlIIIIllllIIlIll.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Mapping conflict for @Shadow ").append(llllllllllllllllIlIIIIllllIIlIlI).append(": ").append(llllllllllllllllIlIIIIllllIlIIIl.getNew().getSimpleName()).append(" for target ").append(llllllllllllllllIlIIIIllllIIlIIl).append(" conflicts with existing mapping ").append(llllllllllllllllIlIIIIllllIlIIIl.getOld().getSimpleName())));
            }
        }
    }

    public void registerShadow(AnnotatedElementShadow<?, ?> llllllllllllllllIlIIIIllllIlllII) {
        AnnotatedMixinElementHandlerShadow llllllllllllllllIlIIIIllllIlllIl;
        llllllllllllllllIlIIIIllllIlllIl.validateTarget((Element)llllllllllllllllIlIIIIllllIlllII.getElement(), llllllllllllllllIlIIIIllllIlllII.getAnnotation(), llllllllllllllllIlIIIIllllIlllII.getName(), "@Shadow");
        if (!llllllllllllllllIlIIIIllllIlllII.shouldRemap()) {
            return;
        }
        for (TypeHandle llllllllllllllllIlIIIIlllllIIIII : llllllllllllllllIlIIIIllllIlllIl.mixin.getTargets()) {
            llllllllllllllllIlIIIIllllIlllIl.registerShadowForTarget(llllllllllllllllIlIIIIllllIlllII, llllllllllllllllIlIIIIlllllIIIII);
        }
    }

    AnnotatedMixinElementHandlerShadow(IMixinAnnotationProcessor llllllllllllllllIlIIIIlllllIlIIl, AnnotatedMixin llllllllllllllllIlIIIIlllllIlIII) {
        super(llllllllllllllllIlIIIIlllllIlIIl, llllllllllllllllIlIIIIlllllIlIII);
        AnnotatedMixinElementHandlerShadow llllllllllllllllIlIIIIlllllIlIlI;
    }

    class AnnotatedElementShadowField
    extends AnnotatedElementShadow<VariableElement, MappingField> {
        public AnnotatedElementShadowField(VariableElement lllllllllllllllllllIlllIlIlllllI, AnnotationHandle lllllllllllllllllllIlllIlIlllIII, boolean lllllllllllllllllllIlllIlIllIlll) {
            AnnotatedElementShadowField lllllllllllllllllllIlllIlIlllIll;
            super(lllllllllllllllllllIlllIlIlllllI, lllllllllllllllllllIlllIlIlllIII, lllllllllllllllllllIlllIlIllIlll, IMapping.Type.FIELD);
        }

        @Override
        public void addMapping(ObfuscationType lllllllllllllllllllIlllIlIlIlIII, IMapping<?> lllllllllllllllllllIlllIlIlIIlII) {
            AnnotatedElementShadowField lllllllllllllllllllIlllIlIlIIllI;
            lllllllllllllllllllIlllIlIlIIllI.AnnotatedMixinElementHandlerShadow.this.addFieldMapping(lllllllllllllllllllIlllIlIlIlIII, lllllllllllllllllllIlllIlIlIIllI.setObfuscatedName(lllllllllllllllllllIlllIlIlIIlII), lllllllllllllllllllIlllIlIlIIllI.getDesc(), lllllllllllllllllllIlllIlIlIIlII.getDesc());
        }

        @Override
        public MappingField getMapping(TypeHandle lllllllllllllllllllIlllIlIlIllll, String lllllllllllllllllllIlllIlIlIlllI, String lllllllllllllllllllIlllIlIllIIII) {
            return new MappingField(lllllllllllllllllllIlllIlIlIllll.getName(), lllllllllllllllllllIlllIlIlIlllI, lllllllllllllllllllIlllIlIllIIII);
        }
    }

    static abstract class AnnotatedElementShadow<E extends Element, M extends IMapping<M>>
    extends AnnotatedMixinElementHandler.AnnotatedElement<E> {
        private final /* synthetic */ boolean shouldRemap;
        private final /* synthetic */ AnnotatedMixinElementHandler.ShadowElementName name;
        private final /* synthetic */ IMapping.Type type;

        public AnnotatedMixinElementHandler.ShadowElementName setObfuscatedName(String lIIllIIIlll) {
            AnnotatedElementShadow lIIllIIlIlI;
            return lIIllIIlIlI.getName().setObfuscatedName(lIIllIIIlll);
        }

        public boolean shouldRemap() {
            AnnotatedElementShadow lIIlllIIlIl;
            return lIIlllIIlIl.shouldRemap;
        }

        public String toString() {
            AnnotatedElementShadow lIIllIlIIll;
            return lIIllIlIIll.getElementType().name().toLowerCase();
        }

        public IMapping.Type getElementType() {
            AnnotatedElementShadow lIIllIlIllI;
            return lIIllIlIllI.type;
        }

        public ObfuscationData<M> getObfuscationData(IObfuscationDataProvider lIIlIllllll, TypeHandle lIIlIlllIlI) {
            AnnotatedElementShadow lIIllIIIIII;
            return lIIlIllllll.getObfEntry(lIIllIIIIII.getMapping(lIIlIlllIlI, lIIllIIIIII.getName().toString(), lIIllIIIIII.getDesc()));
        }

        public AnnotatedMixinElementHandler.ShadowElementName getName() {
            AnnotatedElementShadow lIIllIlllII;
            return lIIllIlllII.name;
        }

        protected AnnotatedElementShadow(E lIIlllIlIll, AnnotationHandle lIIlllIllll, boolean lIIlllIlllI, IMapping.Type lIIlllIllIl) {
            super(lIIlllIlIll, lIIlllIllll);
            AnnotatedElementShadow lIIlllIllII;
            lIIlllIllII.shouldRemap = lIIlllIlllI;
            lIIlllIllII.name = new AnnotatedMixinElementHandler.ShadowElementName((Element)lIIlllIlIll, lIIlllIllll);
            lIIlllIllII.type = lIIlllIllIl;
        }

        public AnnotatedMixinElementHandler.ShadowElementName setObfuscatedName(IMapping<?> lIIllIIllIl) {
            AnnotatedElementShadow lIIllIIlllI;
            return lIIllIIlllI.setObfuscatedName(lIIllIIllIl.getSimpleName());
        }

        public abstract M getMapping(TypeHandle var1, String var2, String var3);

        public abstract void addMapping(ObfuscationType var1, IMapping<?> var2);
    }

    class AnnotatedElementShadowMethod
    extends AnnotatedElementShadow<ExecutableElement, MappingMethod> {
        @Override
        public MappingMethod getMapping(TypeHandle lllllllllllllllIllIllllIIIIllIlI, String lllllllllllllllIllIllllIIIIllIIl, String lllllllllllllllIllIllllIIIIllIII) {
            return lllllllllllllllIllIllllIIIIllIlI.getMappingMethod(lllllllllllllllIllIllllIIIIllIIl, lllllllllllllllIllIllllIIIIllIII);
        }

        @Override
        public void addMapping(ObfuscationType lllllllllllllllIllIllllIIIIIllIl, IMapping<?> lllllllllllllllIllIllllIIIIIllll) {
            AnnotatedElementShadowMethod lllllllllllllllIllIllllIIIIIlllI;
            lllllllllllllllIllIllllIIIIIlllI.AnnotatedMixinElementHandlerShadow.this.addMethodMapping(lllllllllllllllIllIllllIIIIIllIl, lllllllllllllllIllIllllIIIIIlllI.setObfuscatedName(lllllllllllllllIllIllllIIIIIllll), lllllllllllllllIllIllllIIIIIlllI.getDesc(), lllllllllllllllIllIllllIIIIIllll.getDesc());
        }

        public AnnotatedElementShadowMethod(ExecutableElement lllllllllllllllIllIllllIIIlIIIIl, AnnotationHandle lllllllllllllllIllIllllIIIlIIlIl, boolean lllllllllllllllIllIllllIIIIlllll) {
            AnnotatedElementShadowMethod lllllllllllllllIllIllllIIIlIlIII;
            super(lllllllllllllllIllIllllIIIlIIIIl, lllllllllllllllIllIllllIIIlIIlIl, lllllllllllllllIllIllllIIIIlllll, IMapping.Type.METHOD);
        }
    }
}

