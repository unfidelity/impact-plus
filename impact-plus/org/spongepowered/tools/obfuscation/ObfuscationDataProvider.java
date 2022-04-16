/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.List;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public class ObfuscationDataProvider
implements IObfuscationDataProvider {
    private final /* synthetic */ IMixinAnnotationProcessor ap;
    private final /* synthetic */ List<ObfuscationEnvironment> environments;

    @Override
    public ObfuscationData<MappingField> getObfFieldRecursive(MemberInfo llllllllllllllllIllllIlIIlIlIlII) {
        ObfuscationDataProvider llllllllllllllllIllllIlIIlIlIIIl;
        return llllllllllllllllIllllIlIIlIlIIIl.getObfEntryRecursive(llllllllllllllllIllllIlIIlIlIlII);
    }

    @Override
    public <T> ObfuscationData<T> getObfEntry(IMapping<T> llllllllllllllllIllllIlIlllllIII) {
        if (llllllllllllllllIllllIlIlllllIII != null) {
            ObfuscationDataProvider llllllllllllllllIllllIlIlllllIIl;
            if (llllllllllllllllIllllIlIlllllIII.getType() == IMapping.Type.FIELD) {
                return llllllllllllllllIllllIlIlllllIIl.getObfField((MappingField)llllllllllllllllIllllIlIlllllIII);
            }
            if (llllllllllllllllIllllIlIlllllIII.getType() == IMapping.Type.METHOD) {
                return llllllllllllllllIllllIlIlllllIIl.getObfMethod((MappingMethod)llllllllllllllllIllllIlIlllllIII);
            }
        }
        return new ObfuscationData();
    }

    private static <T> ObfuscationData<T> applyParents(ObfuscationData<String> llllllllllllllllIllllIIlllIlIIII, ObfuscationData<T> llllllllllllllllIllllIIlllIIlllI) {
        for (ObfuscationType llllllllllllllllIllllIIlllIlIIlI : llllllllllllllllIllllIIlllIIlllI) {
            String llllllllllllllllIllllIIlllIlIlIl = llllllllllllllllIllllIIlllIlIIII.get(llllllllllllllllIllllIIlllIlIIlI);
            T llllllllllllllllIllllIIlllIlIlII = llllllllllllllllIllllIIlllIIlllI.get(llllllllllllllllIllllIIlllIlIIlI);
            llllllllllllllllIllllIIlllIIlllI.put(llllllllllllllllIllllIIlllIlIIlI, MemberInfo.fromMapping((IMapping)llllllllllllllllIllllIIlllIlIlII).move(llllllllllllllllIllllIIlllIlIlIl).asMapping());
        }
        return llllllllllllllllIllllIIlllIIlllI;
    }

    private ObfuscationData<MappingMethod> getRemappedMethod(MemberInfo llllllllllllllllIllllIlIllIllIll, boolean llllllllllllllllIllllIlIllIlIllI) {
        ObfuscationDataProvider llllllllllllllllIllllIlIllIlllII;
        ObfuscationData<MappingMethod> llllllllllllllllIllllIlIllIllIIl = new ObfuscationData<MappingMethod>();
        for (ObfuscationEnvironment llllllllllllllllIllllIlIllIlllIl : llllllllllllllllIllllIlIllIlllII.environments) {
            MappingMethod llllllllllllllllIllllIlIllIllllI = llllllllllllllllIllllIlIllIlllIl.getObfMethod(llllllllllllllllIllllIlIllIllIll);
            if (llllllllllllllllIllllIlIllIllllI == null) continue;
            llllllllllllllllIllllIlIllIllIIl.put(llllllllllllllllIllllIlIllIlllIl.getType(), llllllllllllllllIllllIlIllIllllI);
        }
        if (!llllllllllllllllIllllIlIllIllIIl.isEmpty() || !llllllllllllllllIllllIlIllIlIllI) {
            return llllllllllllllllIllllIlIllIllIIl;
        }
        return llllllllllllllllIllllIlIllIlllII.remapDescriptor(llllllllllllllllIllllIlIllIllIIl, llllllllllllllllIllllIlIllIllIll);
    }

    @Override
    public <T> ObfuscationData<T> getObfEntryRecursive(MemberInfo llllllllllllllllIllllIllIIIlIlII) {
        ObfuscationDataProvider llllllllllllllllIllllIllIIIllIlI;
        MemberInfo llllllllllllllllIllllIllIIIllIII = llllllllllllllllIllllIllIIIlIlII;
        ObfuscationData<String> llllllllllllllllIllllIllIIIlIlll = llllllllllllllllIllllIllIIIllIlI.getObfClass(llllllllllllllllIllllIllIIIllIII.owner);
        ObfuscationData<T> llllllllllllllllIllllIllIIIlIllI = llllllllllllllllIllllIllIIIllIlI.getObfEntry(llllllllllllllllIllllIllIIIllIII);
        try {
            while (llllllllllllllllIllllIllIIIlIllI.isEmpty()) {
                TypeHandle llllllllllllllllIllllIllIIIlllIl = llllllllllllllllIllllIllIIIllIlI.ap.getTypeProvider().getTypeHandle(llllllllllllllllIllllIllIIIllIII.owner);
                if (llllllllllllllllIllllIllIIIlllIl == null) {
                    return llllllllllllllllIllllIllIIIlIllI;
                }
                TypeHandle llllllllllllllllIllllIllIIIlllII = llllllllllllllllIllllIllIIIlllIl.getSuperclass();
                llllllllllllllllIllllIllIIIlIllI = llllllllllllllllIllllIllIIIllIlI.getObfEntryUsing(llllllllllllllllIllllIllIIIllIII, llllllllllllllllIllllIllIIIlllII);
                if (!llllllllllllllllIllllIllIIIlIllI.isEmpty()) {
                    return ObfuscationDataProvider.applyParents(llllllllllllllllIllllIllIIIlIlll, llllllllllllllllIllllIllIIIlIllI);
                }
                for (TypeHandle llllllllllllllllIllllIllIIIllllI : llllllllllllllllIllllIllIIIlllIl.getInterfaces()) {
                    llllllllllllllllIllllIllIIIlIllI = llllllllllllllllIllllIllIIIllIlI.getObfEntryUsing(llllllllllllllllIllllIllIIIllIII, llllllllllllllllIllllIllIIIllllI);
                    if (llllllllllllllllIllllIllIIIlIllI.isEmpty()) continue;
                    return ObfuscationDataProvider.applyParents(llllllllllllllllIllllIllIIIlIlll, llllllllllllllllIllllIllIIIlIllI);
                }
                if (llllllllllllllllIllllIllIIIlllII != null) {
                    llllllllllllllllIllllIllIIIllIII = llllllllllllllllIllllIllIIIllIII.move(llllllllllllllllIllllIllIIIlllII.getName());
                    continue;
                }
                break;
            }
        }
        catch (Exception llllllllllllllllIllllIllIIIllIll) {
            llllllllllllllllIllllIllIIIllIll.printStackTrace();
            return llllllllllllllllIllllIllIIIllIlI.getObfEntry(llllllllllllllllIllllIllIIIlIlII);
        }
        return llllllllllllllllIllllIllIIIlIllI;
    }

    @Override
    public ObfuscationData<String> getObfClass(String llllllllllllllllIllllIIlllllIIII) {
        ObfuscationDataProvider llllllllllllllllIllllIIlllllIIIl;
        ObfuscationData<String> llllllllllllllllIllllIIllllIlllI = new ObfuscationData<String>(llllllllllllllllIllllIIlllllIIII);
        for (ObfuscationEnvironment llllllllllllllllIllllIIlllllIIlI : llllllllllllllllIllllIIlllllIIIl.environments) {
            String llllllllllllllllIllllIIlllllIIll = llllllllllllllllIllllIIlllllIIlI.getObfClass(llllllllllllllllIllllIIlllllIIII);
            if (llllllllllllllllIllllIIlllllIIll == null) continue;
            llllllllllllllllIllllIIllllIlllI.put(llllllllllllllllIllllIIlllllIIlI.getType(), llllllllllllllllIllllIIlllllIIll);
        }
        return llllllllllllllllIllllIIllllIlllI;
    }

    @Override
    public ObfuscationData<MappingField> getObfField(MappingField llllllllllllllllIllllIlIIIIlllII) {
        ObfuscationDataProvider llllllllllllllllIllllIlIIIIllIlI;
        ObfuscationData<MappingField> llllllllllllllllIllllIlIIIIllIll = new ObfuscationData<MappingField>();
        for (ObfuscationEnvironment llllllllllllllllIllllIlIIIIllllI : llllllllllllllllIllllIlIIIIllIlI.environments) {
            Object llllllllllllllllIllllIlIIIlIIIIl = llllllllllllllllIllllIlIIIIllllI.getObfField(llllllllllllllllIllllIlIIIIlllII);
            if (llllllllllllllllIllllIlIIIlIIIIl == null) continue;
            if (((MappingField)llllllllllllllllIllllIlIIIlIIIIl).getDesc() == null && llllllllllllllllIllllIlIIIIlllII.getDesc() != null) {
                llllllllllllllllIllllIlIIIlIIIIl = ((MappingField)llllllllllllllllIllllIlIIIlIIIIl).transform(llllllllllllllllIllllIlIIIIllllI.remapDescriptor(llllllllllllllllIllllIlIIIIlllII.getDesc()));
            }
            llllllllllllllllIllllIlIIIIllIll.put(llllllllllllllllIllllIlIIIIllllI.getType(), (MappingField)llllllllllllllllIllllIlIIIlIIIIl);
        }
        return llllllllllllllllIllllIlIIIIllIll;
    }

    @Override
    public ObfuscationData<MappingMethod> getObfMethod(MemberInfo llllllllllllllllIllllIlIlllIllII) {
        ObfuscationDataProvider llllllllllllllllIllllIlIlllIllIl;
        return llllllllllllllllIllllIlIlllIllIl.getRemappedMethod(llllllllllllllllIllllIlIlllIllII, llllllllllllllllIllllIlIlllIllII.isConstructor());
    }

    @Override
    public ObfuscationData<MappingMethod> getRemappedMethod(MemberInfo llllllllllllllllIllllIlIlllIIllI) {
        ObfuscationDataProvider llllllllllllllllIllllIlIlllIlIIl;
        return llllllllllllllllIllllIlIlllIlIIl.getRemappedMethod(llllllllllllllllIllllIlIlllIIllI, true);
    }

    @Override
    public ObfuscationData<MappingMethod> getRemappedMethod(MappingMethod llllllllllllllllIllllIlIlIllIlll) {
        ObfuscationDataProvider llllllllllllllllIllllIlIlIllllII;
        return llllllllllllllllIllllIlIlIllllII.getRemappedMethod(llllllllllllllllIllllIlIlIllIlll, true);
    }

    @Override
    public ObfuscationData<MappingMethod> getObfMethod(MappingMethod llllllllllllllllIllllIlIllIIlIlI) {
        ObfuscationDataProvider llllllllllllllllIllllIlIllIIIIll;
        return llllllllllllllllIllllIlIllIIIIll.getRemappedMethod(llllllllllllllllIllllIlIllIIlIlI, llllllllllllllllIllllIlIllIIlIlI.isConstructor());
    }

    @Override
    public ObfuscationData<String> getObfClass(TypeHandle llllllllllllllllIllllIlIIIIIIlII) {
        ObfuscationDataProvider llllllllllllllllIllllIlIIIIIIlIl;
        return llllllllllllllllIllllIlIIIIIIlIl.getObfClass(llllllllllllllllIllllIlIIIIIIlII.getName());
    }

    public ObfuscationData<MappingMethod> remapDescriptor(ObfuscationData<MappingMethod> llllllllllllllllIllllIlIIllIlIlI, MemberInfo llllllllllllllllIllllIlIIllIlIIl) {
        ObfuscationDataProvider llllllllllllllllIllllIlIIllIlllI;
        for (ObfuscationEnvironment llllllllllllllllIllllIlIIlllIIII : llllllllllllllllIllllIlIIllIlllI.environments) {
            MemberInfo llllllllllllllllIllllIlIIlllIIIl = llllllllllllllllIllllIlIIlllIIII.remapDescriptor(llllllllllllllllIllllIlIIllIlIIl);
            if (llllllllllllllllIllllIlIIlllIIIl == null) continue;
            llllllllllllllllIllllIlIIllIlIlI.put(llllllllllllllllIllllIlIIlllIIII.getType(), llllllllllllllllIllllIlIIlllIIIl.asMethodMapping());
        }
        return llllllllllllllllIllllIlIIllIlIlI;
    }

    @Override
    public ObfuscationData<MappingMethod> getObfMethodRecursive(MemberInfo llllllllllllllllIllllIlIllllIIlI) {
        ObfuscationDataProvider llllllllllllllllIllllIlIllllIIll;
        return llllllllllllllllIllllIlIllllIIll.getObfEntryRecursive(llllllllllllllllIllllIlIllllIIlI);
    }

    private ObfuscationData<MappingMethod> getRemappedMethod(MappingMethod llllllllllllllllIllllIlIlIIlIlIl, boolean llllllllllllllllIllllIlIlIIlllII) {
        ObfuscationDataProvider llllllllllllllllIllllIlIlIIllIII;
        ObfuscationData<MappingMethod> llllllllllllllllIllllIlIlIIllIlI = new ObfuscationData<MappingMethod>();
        for (ObfuscationEnvironment llllllllllllllllIllllIlIlIlIIIlI : llllllllllllllllIllllIlIlIIllIII.environments) {
            MappingMethod llllllllllllllllIllllIlIlIlIIlII = llllllllllllllllIllllIlIlIlIIIlI.getObfMethod(llllllllllllllllIllllIlIlIIlIlIl);
            if (llllllllllllllllIllllIlIlIlIIlII == null) continue;
            llllllllllllllllIllllIlIlIIllIlI.put(llllllllllllllllIllllIlIlIlIIIlI.getType(), llllllllllllllllIllllIlIlIlIIlII);
        }
        if (!llllllllllllllllIllllIlIlIIllIlI.isEmpty() || !llllllllllllllllIllllIlIlIIlllII) {
            return llllllllllllllllIllllIlIlIIllIlI;
        }
        return llllllllllllllllIllllIlIlIIllIII.remapDescriptor(llllllllllllllllIllllIlIlIIllIlI, new MemberInfo(llllllllllllllllIllllIlIlIIlIlIl));
    }

    private <T> ObfuscationData<T> getObfEntryUsing(MemberInfo llllllllllllllllIllllIllIIIIIlIl, TypeHandle llllllllllllllllIllllIllIIIIIlII) {
        ObfuscationDataProvider llllllllllllllllIllllIllIIIIIllI;
        return llllllllllllllllIllllIllIIIIIlII == null ? new ObfuscationData() : llllllllllllllllIllllIllIIIIIllI.getObfEntry(llllllllllllllllIllllIllIIIIIlIl.move(llllllllllllllllIllllIllIIIIIlII.getName()));
    }

    @Override
    public ObfuscationData<MappingField> getObfField(MemberInfo llllllllllllllllIllllIlIIIllllll) {
        ObfuscationDataProvider llllllllllllllllIllllIlIIlIIIIII;
        return llllllllllllllllIllllIlIIlIIIIII.getObfField(llllllllllllllllIllllIlIIIllllll.asFieldMapping());
    }

    @Override
    public <T> ObfuscationData<T> getObfEntry(MemberInfo llllllllllllllllIllllIlIlllllllI) {
        ObfuscationDataProvider llllllllllllllllIllllIllIIIIIIIl;
        if (llllllllllllllllIllllIlIlllllllI.isField()) {
            return llllllllllllllllIllllIllIIIIIIIl.getObfField(llllllllllllllllIllllIlIlllllllI);
        }
        return llllllllllllllllIllllIllIIIIIIIl.getObfMethod(llllllllllllllllIllllIlIlllllllI.asMethodMapping());
    }

    public ObfuscationDataProvider(IMixinAnnotationProcessor llllllllllllllllIllllIllIIlIllII, List<ObfuscationEnvironment> llllllllllllllllIllllIllIIlIlIll) {
        ObfuscationDataProvider llllllllllllllllIllllIllIIlIlIlI;
        llllllllllllllllIllllIllIIlIlIlI.ap = llllllllllllllllIllllIllIIlIllII;
        llllllllllllllllIllllIllIIlIlIlI.environments = llllllllllllllllIllllIllIIlIlIll;
    }
}

