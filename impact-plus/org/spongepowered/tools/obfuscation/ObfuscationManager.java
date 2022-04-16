/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.tools.obfuscation.Mappings;
import org.spongepowered.tools.obfuscation.ObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.ReferenceManager;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationManager;
import org.spongepowered.tools.obfuscation.interfaces.IReferenceManager;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.service.ObfuscationServices;

public class ObfuscationManager
implements IObfuscationManager {
    private final /* synthetic */ IReferenceManager refs;
    private final /* synthetic */ IObfuscationDataProvider obfs;
    private /* synthetic */ boolean initDone;
    private final /* synthetic */ List<IMappingConsumer> consumers;
    private final /* synthetic */ List<ObfuscationEnvironment> environments;
    private final /* synthetic */ IMixinAnnotationProcessor ap;

    @Override
    public IMappingConsumer createMappingConsumer() {
        ObfuscationManager lIIIIlIlIlIlIll;
        Mappings lIIIIlIlIlIlIlI = new Mappings();
        lIIIIlIlIlIlIll.consumers.add(lIIIIlIlIlIlIlI);
        return lIIIIlIlIlIlIlI;
    }

    @Override
    public void writeReferences() {
        ObfuscationManager lIIIIlIIlllllIl;
        lIIIIlIIlllllIl.refs.write();
    }

    @Override
    public List<ObfuscationEnvironment> getEnvironments() {
        ObfuscationManager lIIIIlIlIIlllIl;
        return lIIIIlIlIIlllIl.environments;
    }

    @Override
    public void init() {
        ObfuscationManager lIIIIlIllIlIIll;
        if (lIIIIlIllIlIIll.initDone) {
            return;
        }
        lIIIIlIllIlIIll.initDone = true;
        ObfuscationServices.getInstance().initProviders(lIIIIlIllIlIIll.ap);
        for (ObfuscationType lIIIIlIllIllIlI : ObfuscationType.types()) {
            if (!lIIIIlIllIllIlI.isSupported()) continue;
            lIIIIlIllIlIIll.environments.add(lIIIIlIllIllIlI.createEnvironment());
        }
    }

    @Override
    public IReferenceManager getReferenceManager() {
        ObfuscationManager lIIIIlIlIlllllI;
        return lIIIIlIlIlllllI.refs;
    }

    public ObfuscationManager(IMixinAnnotationProcessor lIIIIlIllllllll) {
        ObfuscationManager lIIIIllIIIIIIII;
        lIIIIllIIIIIIII.environments = new ArrayList<ObfuscationEnvironment>();
        lIIIIllIIIIIIII.consumers = new ArrayList<IMappingConsumer>();
        lIIIIllIIIIIIII.ap = lIIIIlIllllllll;
        lIIIIllIIIIIIII.obfs = new ObfuscationDataProvider(lIIIIlIllllllll, lIIIIllIIIIIIII.environments);
        lIIIIllIIIIIIII.refs = new ReferenceManager(lIIIIlIllllllll, lIIIIllIIIIIIII.environments);
    }

    @Override
    public void writeMappings() {
        ObfuscationManager lIIIIlIlIIIIllI;
        for (ObfuscationEnvironment lIIIIlIlIIIlIII : lIIIIlIlIIIIllI.environments) {
            lIIIIlIlIIIlIII.writeMappings(lIIIIlIlIIIIllI.consumers);
        }
    }

    @Override
    public IObfuscationDataProvider getDataProvider() {
        ObfuscationManager lIIIIlIllIIlIlI;
        return lIIIIlIllIIlIlI.obfs;
    }
}

