/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.extensibility;

import org.spongepowered.asm.mixin.MixinEnvironment;

public interface IEnvironmentTokenProvider {
    public static final /* synthetic */ int DEFAULT_PRIORITY;

    static {
        DEFAULT_PRIORITY = 1000;
    }

    public Integer getToken(String var1, MixinEnvironment var2);

    public int getPriority();
}

