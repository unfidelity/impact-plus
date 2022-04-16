/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.service;

import org.spongepowered.asm.service.ITransformer;

public interface ILegacyClassTransformer
extends ITransformer {
    public boolean isDelegationExcluded();

    public byte[] transformClassBytes(String var1, String var2, byte[] var3);

    public String getName();
}

