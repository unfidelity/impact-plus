/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.extensibility;

import java.util.Set;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;

public interface IMixinConfig {
    public static final /* synthetic */ int DEFAULT_PRIORITY;

    static {
        DEFAULT_PRIORITY = 1000;
    }

    public String getName();

    public Set<String> getTargets();

    public String getMixinPackage();

    public int getPriority();

    public boolean isRequired();

    public IMixinConfigPlugin getPlugin();

    public MixinEnvironment getEnvironment();
}

