/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;

class Mappings
implements IMappingConsumer {
    private /* synthetic */ UniqueMappings unique;
    private final /* synthetic */ Map<ObfuscationType, IMappingConsumer.MappingSet<MappingField>> fieldMappings;
    private final /* synthetic */ Map<ObfuscationType, IMappingConsumer.MappingSet<MappingMethod>> methodMappings;

    @Override
    public void addMethodMapping(ObfuscationType llllllllllllllllllIIllIlIlIllIlI, MappingMethod llllllllllllllllllIIllIlIlIllllI, MappingMethod llllllllllllllllllIIllIlIlIllIII) {
        Mappings llllllllllllllllllIIllIlIlIllIll;
        IMappingConsumer.MappingSet<MappingMethod> llllllllllllllllllIIllIlIlIlllII = llllllllllllllllllIIllIlIlIllIll.methodMappings.get(llllllllllllllllllIIllIlIlIllIlI);
        if (llllllllllllllllllIIllIlIlIlllII == null) {
            llllllllllllllllllIIllIlIlIlllII = new IMappingConsumer.MappingSet();
            llllllllllllllllllIIllIlIlIllIll.methodMappings.put(llllllllllllllllllIIllIlIlIllIlI, llllllllllllllllllIIllIlIlIlllII);
        }
        llllllllllllllllllIIllIlIlIlllII.add(new IMappingConsumer.MappingSet.Pair<MappingMethod>(llllllllllllllllllIIllIlIlIllllI, llllllllllllllllllIIllIlIlIllIII));
    }

    @Override
    public IMappingConsumer.MappingSet<MappingField> getFieldMappings(ObfuscationType llllllllllllllllllIIllIllIIIIIlI) {
        Mappings llllllllllllllllllIIllIllIIIIllI;
        IMappingConsumer.MappingSet llllllllllllllllllIIllIllIIIIlII = llllllllllllllllllIIllIllIIIIllI.fieldMappings.get(llllllllllllllllllIIllIllIIIIIlI);
        return llllllllllllllllllIIllIllIIIIlII != null ? llllllllllllllllllIIllIllIIIIlII : new IMappingConsumer.MappingSet();
    }

    public IMappingConsumer asUnique() {
        Mappings llllllllllllllllllIIllIllIIIlIll;
        if (llllllllllllllllllIIllIllIIIlIll.unique == null) {
            llllllllllllllllllIIllIllIIIlIll.unique = new UniqueMappings(llllllllllllllllllIIllIllIIIlIll);
        }
        return llllllllllllllllllIIllIllIIIlIll.unique;
    }

    private void init() {
        for (ObfuscationType llllllllllllllllllIIllIllIIlIIIl : ObfuscationType.types()) {
            Mappings llllllllllllllllllIIllIllIIlIIII;
            llllllllllllllllllIIllIllIIlIIII.fieldMappings.put(llllllllllllllllllIIllIllIIlIIIl, new IMappingConsumer.MappingSet());
            llllllllllllllllllIIllIllIIlIIII.methodMappings.put(llllllllllllllllllIIllIllIIlIIIl, new IMappingConsumer.MappingSet());
        }
    }

    public Mappings() {
        Mappings llllllllllllllllllIIllIllIIlIllI;
        llllllllllllllllllIIllIllIIlIllI.fieldMappings = new HashMap<ObfuscationType, IMappingConsumer.MappingSet<MappingField>>();
        llllllllllllllllllIIllIllIIlIllI.methodMappings = new HashMap<ObfuscationType, IMappingConsumer.MappingSet<MappingMethod>>();
        llllllllllllllllllIIllIllIIlIllI.init();
    }

    @Override
    public void addFieldMapping(ObfuscationType llllllllllllllllllIIllIlIllIlIIl, MappingField llllllllllllllllllIIllIlIllIlIII, MappingField llllllllllllllllllIIllIlIllIIlll) {
        Mappings llllllllllllllllllIIllIlIllIllll;
        IMappingConsumer.MappingSet<MappingField> llllllllllllllllllIIllIlIllIlIll = llllllllllllllllllIIllIlIllIllll.fieldMappings.get(llllllllllllllllllIIllIlIllIlIIl);
        if (llllllllllllllllllIIllIlIllIlIll == null) {
            llllllllllllllllllIIllIlIllIlIll = new IMappingConsumer.MappingSet();
            llllllllllllllllllIIllIlIllIllll.fieldMappings.put(llllllllllllllllllIIllIlIllIlIIl, llllllllllllllllllIIllIlIllIlIll);
        }
        llllllllllllllllllIIllIlIllIlIll.add(new IMappingConsumer.MappingSet.Pair<MappingField>(llllllllllllllllllIIllIlIllIlIII, llllllllllllllllllIIllIlIllIIlll));
    }

    @Override
    public void clear() {
        Mappings llllllllllllllllllIIllIlIlllIllI;
        llllllllllllllllllIIllIlIlllIllI.fieldMappings.clear();
        llllllllllllllllllIIllIlIlllIllI.methodMappings.clear();
        if (llllllllllllllllllIIllIlIlllIllI.unique != null) {
            llllllllllllllllllIIllIlIlllIllI.unique.clearMaps();
        }
        llllllllllllllllllIIllIlIlllIllI.init();
    }

    @Override
    public IMappingConsumer.MappingSet<MappingMethod> getMethodMappings(ObfuscationType llllllllllllllllllIIllIlIlllllII) {
        Mappings llllllllllllllllllIIllIlIlllllIl;
        IMappingConsumer.MappingSet llllllllllllllllllIIllIlIllllIll = llllllllllllllllllIIllIlIlllllIl.methodMappings.get(llllllllllllllllllIIllIlIlllllII);
        return llllllllllllllllllIIllIlIllllIll != null ? llllllllllllllllllIIllIlIllllIll : new IMappingConsumer.MappingSet();
    }

    static class UniqueMappings
    implements IMappingConsumer {
        private final /* synthetic */ IMappingConsumer mappings;
        private final /* synthetic */ Map<ObfuscationType, Map<MappingField, MappingField>> fields;
        private final /* synthetic */ Map<ObfuscationType, Map<MappingMethod, MappingMethod>> methods;

        @Override
        public void addFieldMapping(ObfuscationType lllllllllllllllllIIIlIIIIlllllll, MappingField lllllllllllllllllIIIlIIIIllllllI, MappingField lllllllllllllllllIIIlIIIIlllllIl) {
            UniqueMappings lllllllllllllllllIIIlIIIIlllllII;
            if (!lllllllllllllllllIIIlIIIIlllllII.checkForExistingMapping(lllllllllllllllllIIIlIIIIlllllll, lllllllllllllllllIIIlIIIIllllllI, lllllllllllllllllIIIlIIIIlllllIl, lllllllllllllllllIIIlIIIIlllllII.fields)) {
                lllllllllllllllllIIIlIIIIlllllII.mappings.addFieldMapping(lllllllllllllllllIIIlIIIIlllllll, lllllllllllllllllIIIlIIIIllllllI, lllllllllllllllllIIIlIIIIlllllIl);
            }
        }

        @Override
        public IMappingConsumer.MappingSet<MappingField> getFieldMappings(ObfuscationType lllllllllllllllllIIIlIIIIlIlIllI) {
            UniqueMappings lllllllllllllllllIIIlIIIIlIlIlll;
            return lllllllllllllllllIIIlIIIIlIlIlll.mappings.getFieldMappings(lllllllllllllllllIIIlIIIIlIlIllI);
        }

        private <TMapping extends IMapping<TMapping>> boolean checkForExistingMapping(ObfuscationType lllllllllllllllllIIIlIIIIllIIlIl, TMapping lllllllllllllllllIIIlIIIIlIllllI, TMapping lllllllllllllllllIIIlIIIIllIIIll, Map<ObfuscationType, Map<TMapping, TMapping>> lllllllllllllllllIIIlIIIIllIIIlI) throws MappingConflictException {
            IMapping lllllllllllllllllIIIlIIIIllIIIII;
            Map<TMapping, TMapping> lllllllllllllllllIIIlIIIIllIIIIl = lllllllllllllllllIIIlIIIIllIIIlI.get(lllllllllllllllllIIIlIIIIllIIlIl);
            if (lllllllllllllllllIIIlIIIIllIIIIl == null) {
                lllllllllllllllllIIIlIIIIllIIIIl = new HashMap<TMapping, TMapping>();
                lllllllllllllllllIIIlIIIIllIIIlI.put(lllllllllllllllllIIIlIIIIllIIlIl, lllllllllllllllllIIIlIIIIllIIIIl);
            }
            if ((lllllllllllllllllIIIlIIIIllIIIII = (IMapping)lllllllllllllllllIIIlIIIIllIIIIl.get(lllllllllllllllllIIIlIIIIlIllllI)) != null) {
                if (lllllllllllllllllIIIlIIIIllIIIII.equals(lllllllllllllllllIIIlIIIIllIIIll)) {
                    return true;
                }
                throw new MappingConflictException(lllllllllllllllllIIIlIIIIllIIIII, lllllllllllllllllIIIlIIIIllIIIll);
            }
            lllllllllllllllllIIIlIIIIllIIIIl.put(lllllllllllllllllIIIlIIIIlIllllI, lllllllllllllllllIIIlIIIIllIIIll);
            return false;
        }

        @Override
        public IMappingConsumer.MappingSet<MappingMethod> getMethodMappings(ObfuscationType lllllllllllllllllIIIlIIIIlIlIIII) {
            UniqueMappings lllllllllllllllllIIIlIIIIlIIllll;
            return lllllllllllllllllIIIlIIIIlIIllll.mappings.getMethodMappings(lllllllllllllllllIIIlIIIIlIlIIII);
        }

        @Override
        public void clear() {
            UniqueMappings lllllllllllllllllIIIlIIIlIIIlIII;
            lllllllllllllllllIIIlIIIlIIIlIII.clearMaps();
            lllllllllllllllllIIIlIIIlIIIlIII.mappings.clear();
        }

        @Override
        public void addMethodMapping(ObfuscationType lllllllllllllllllIIIlIIIIllIllll, MappingMethod lllllllllllllllllIIIlIIIIllIlllI, MappingMethod lllllllllllllllllIIIlIIIIlllIIIl) {
            UniqueMappings lllllllllllllllllIIIlIIIIlllIIII;
            if (!lllllllllllllllllIIIlIIIIlllIIII.checkForExistingMapping(lllllllllllllllllIIIlIIIIllIllll, lllllllllllllllllIIIlIIIIllIlllI, lllllllllllllllllIIIlIIIIlllIIIl, lllllllllllllllllIIIlIIIIlllIIII.methods)) {
                lllllllllllllllllIIIlIIIIlllIIII.mappings.addMethodMapping(lllllllllllllllllIIIlIIIIllIllll, lllllllllllllllllIIIlIIIIllIlllI, lllllllllllllllllIIIlIIIIlllIIIl);
            }
        }

        public UniqueMappings(IMappingConsumer lllllllllllllllllIIIlIIIlIIIlIll) {
            UniqueMappings lllllllllllllllllIIIlIIIlIIIllII;
            lllllllllllllllllIIIlIIIlIIIllII.fields = new HashMap<ObfuscationType, Map<MappingField, MappingField>>();
            lllllllllllllllllIIIlIIIlIIIllII.methods = new HashMap<ObfuscationType, Map<MappingMethod, MappingMethod>>();
            lllllllllllllllllIIIlIIIlIIIllII.mappings = lllllllllllllllllIIIlIIIlIIIlIll;
        }

        protected void clearMaps() {
            UniqueMappings lllllllllllllllllIIIlIIIlIIIIllI;
            lllllllllllllllllIIIlIIIlIIIIllI.fields.clear();
            lllllllllllllllllIIIlIIIlIIIIllI.methods.clear();
        }
    }

    public static class MappingConflictException
    extends RuntimeException {
        private final /* synthetic */ IMapping<?> oldMapping;
        private final /* synthetic */ IMapping<?> newMapping;
        private static final /* synthetic */ long serialVersionUID = 1L;

        public IMapping<?> getOld() {
            MappingConflictException llllllllllllllllIlIllIllIIlIlllI;
            return llllllllllllllllIlIllIllIIlIlllI.oldMapping;
        }

        public MappingConflictException(IMapping<?> llllllllllllllllIlIllIllIIllIIlI, IMapping<?> llllllllllllllllIlIllIllIIllIlII) {
            MappingConflictException llllllllllllllllIlIllIllIIllIIll;
            llllllllllllllllIlIllIllIIllIIll.oldMapping = llllllllllllllllIlIllIllIIllIIlI;
            llllllllllllllllIlIllIllIIllIIll.newMapping = llllllllllllllllIlIllIllIIllIlII;
        }

        public IMapping<?> getNew() {
            MappingConflictException llllllllllllllllIlIllIllIIlIllII;
            return llllllllllllllllIlIllIllIIlIllII.newMapping;
        }
    }
}

