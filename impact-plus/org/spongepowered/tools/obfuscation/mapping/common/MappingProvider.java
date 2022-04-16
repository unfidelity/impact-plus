/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  com.google.common.collect.HashBiMap
 */
package org.spongepowered.tools.obfuscation.mapping.common;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mapping.IMappingProvider;

public abstract class MappingProvider
implements IMappingProvider {
    protected final /* synthetic */ BiMap<MappingField, MappingField> fieldMap;
    protected final /* synthetic */ Filer filer;
    protected final /* synthetic */ Messager messager;
    protected final /* synthetic */ BiMap<MappingMethod, MappingMethod> methodMap;
    protected final /* synthetic */ BiMap<String, String> packageMap;
    protected final /* synthetic */ BiMap<String, String> classMap;

    @Override
    public MappingField getFieldMapping(MappingField llllllllllllllllIllIIIllIIlIllll) {
        MappingProvider llllllllllllllllIllIIIllIIllIIII;
        return (MappingField)llllllllllllllllIllIIIllIIllIIII.fieldMap.get((Object)llllllllllllllllIllIIIllIIlIllll);
    }

    @Override
    public boolean isEmpty() {
        MappingProvider llllllllllllllllIllIIIllIIllllII;
        return llllllllllllllllIllIIIllIIllllII.packageMap.isEmpty() && llllllllllllllllIllIIIllIIllllII.classMap.isEmpty() && llllllllllllllllIllIIIllIIllllII.fieldMap.isEmpty() && llllllllllllllllIllIIIllIIllllII.methodMap.isEmpty();
    }

    public MappingProvider(Messager llllllllllllllllIllIIIllIlIIlllI, Filer llllllllllllllllIllIIIllIlIIllIl) {
        MappingProvider llllllllllllllllIllIIIllIlIlIIlI;
        llllllllllllllllIllIIIllIlIlIIlI.packageMap = HashBiMap.create();
        llllllllllllllllIllIIIllIlIlIIlI.classMap = HashBiMap.create();
        llllllllllllllllIllIIIllIlIlIIlI.fieldMap = HashBiMap.create();
        llllllllllllllllIllIIIllIlIlIIlI.methodMap = HashBiMap.create();
        llllllllllllllllIllIIIllIlIlIIlI.messager = llllllllllllllllIllIIIllIlIIlllI;
        llllllllllllllllIllIIIllIlIlIIlI.filer = llllllllllllllllIllIIIllIlIIllIl;
    }

    @Override
    public String getPackageMapping(String llllllllllllllllIllIIIllIIIllIlI) {
        MappingProvider llllllllllllllllIllIIIllIIlIIIII;
        return (String)llllllllllllllllIllIIIllIIlIIIII.packageMap.get((Object)llllllllllllllllIllIIIllIIIllIlI);
    }

    @Override
    public MappingMethod getMethodMapping(MappingMethod llllllllllllllllIllIIIllIIllIIll) {
        MappingProvider llllllllllllllllIllIIIllIIllIllI;
        return (MappingMethod)llllllllllllllllIllIIIllIIllIllI.methodMap.get((Object)llllllllllllllllIllIIIllIIllIIll);
    }

    @Override
    public void clear() {
        MappingProvider llllllllllllllllIllIIIllIlIIlIII;
        llllllllllllllllIllIIIllIlIIlIII.packageMap.clear();
        llllllllllllllllIllIIIllIlIIlIII.classMap.clear();
        llllllllllllllllIllIIIllIlIIlIII.fieldMap.clear();
        llllllllllllllllIllIIIllIlIIlIII.methodMap.clear();
    }

    @Override
    public String getClassMapping(String llllllllllllllllIllIIIllIIlIlIIl) {
        MappingProvider llllllllllllllllIllIIIllIIlIlIlI;
        return (String)llllllllllllllllIllIIIllIIlIlIlI.classMap.get((Object)llllllllllllllllIllIIIllIIlIlIIl);
    }
}

