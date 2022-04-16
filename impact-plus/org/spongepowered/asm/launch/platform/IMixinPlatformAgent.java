/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.launch.platform;

public interface IMixinPlatformAgent {
    public String getPhaseProvider();

    public void initPrimaryContainer();

    public void inject();

    public void prepare();

    public String getLaunchTarget();
}

