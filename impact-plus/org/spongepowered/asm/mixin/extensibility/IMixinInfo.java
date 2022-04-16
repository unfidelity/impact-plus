/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.extensibility;

import java.util.List;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;

public interface IMixinInfo {
    public int getPriority();

    public byte[] getClassBytes();

    public String getClassName();

    public IMixinConfig getConfig();

    public MixinEnvironment.Phase getPhase();

    public String getClassRef();

    public ClassNode getClassNode(int var1);

    public String getName();

    public boolean isDetachedSuper();

    public List<String> getTargetClasses();
}

