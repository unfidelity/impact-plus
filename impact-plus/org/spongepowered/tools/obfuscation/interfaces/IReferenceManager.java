/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.interfaces;

import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationData;

public interface IReferenceManager {
    public ReferenceMapper getMapper();

    public boolean getAllowConflicts();

    public void addMethodMapping(String var1, String var2, MemberInfo var3, ObfuscationData<MappingMethod> var4);

    public void addMethodMapping(String var1, String var2, ObfuscationData<MappingMethod> var3);

    public void addClassMapping(String var1, String var2, ObfuscationData<String> var3);

    public void write();

    public void setAllowConflicts(boolean var1);

    public void addFieldMapping(String var1, String var2, MemberInfo var3, ObfuscationData<MappingField> var4);
}

