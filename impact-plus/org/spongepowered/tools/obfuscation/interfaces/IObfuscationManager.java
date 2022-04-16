/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.interfaces;

import java.util.List;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.interfaces.IReferenceManager;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;

public interface IObfuscationManager {
    public IMappingConsumer createMappingConsumer();

    public IReferenceManager getReferenceManager();

    public void init();

    public void writeReferences();

    public IObfuscationDataProvider getDataProvider();

    public void writeMappings();

    public List<ObfuscationEnvironment> getEnvironments();
}

