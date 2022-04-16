/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.mixin.gen.AccessorGenerator;
import org.spongepowered.asm.mixin.gen.AccessorInfo;

public abstract class AccessorGeneratorField
extends AccessorGenerator {
    protected final /* synthetic */ Type targetType;
    protected final /* synthetic */ FieldNode targetField;
    protected final /* synthetic */ boolean isInstanceField;

    public AccessorGeneratorField(AccessorInfo llIIllIIlIIII) {
        super(llIIllIIlIIII);
        AccessorGeneratorField llIIllIIlIIll;
        llIIllIIlIIll.targetField = llIIllIIlIIII.getTargetField();
        llIIllIIlIIll.targetType = llIIllIIlIIII.getTargetFieldType();
        llIIllIIlIIll.isInstanceField = (llIIllIIlIIll.targetField.access & 8) == 0;
    }
}

