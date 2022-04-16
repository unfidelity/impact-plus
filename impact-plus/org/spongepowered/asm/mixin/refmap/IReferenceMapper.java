/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.refmap;

public interface IReferenceMapper {
    public String remapWithContext(String var1, String var2, String var3);

    public String getResourceName();

    public String remap(String var1, String var2);

    public boolean isDefault();

    public void setContext(String var1);

    public String getContext();

    public String getStatus();
}

