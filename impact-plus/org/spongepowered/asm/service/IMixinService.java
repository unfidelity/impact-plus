/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.service;

import java.io.InputStream;
import java.util.Collection;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.service.IClassBytecodeProvider;
import org.spongepowered.asm.service.IClassProvider;
import org.spongepowered.asm.service.ITransformer;
import org.spongepowered.asm.util.ReEntranceLock;

public interface IMixinService {
    public boolean isValid();

    public Collection<ITransformer> getTransformers();

    public IClassProvider getClassProvider();

    public void registerInvalidClass(String var1);

    public String getSideName();

    public boolean isClassLoaded(String var1);

    public void beginPhase();

    public InputStream getResourceAsStream(String var1);

    public Collection<String> getPlatformAgents();

    public IClassBytecodeProvider getBytecodeProvider();

    public String getName();

    public MixinEnvironment.Phase getInitialPhase();

    public void checkEnv(Object var1);

    public void prepare();

    public void init();

    public ReEntranceLock getReEntranceLock();
}

