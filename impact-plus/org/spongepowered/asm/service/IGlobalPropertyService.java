/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.service;

public interface IGlobalPropertyService {
    public String getPropertyString(String var1, String var2);

    public <T> T getProperty(String var1, T var2);

    public void setProperty(String var1, Object var2);

    public <T> T getProperty(String var1);
}

