/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import javax.tools.Diagnostic;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.service.IObfuscationService;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

public final class ObfuscationServices {
    private final /* synthetic */ Set<IObfuscationService> services;
    private final /* synthetic */ ServiceLoader<IObfuscationService> serviceLoader;
    private static /* synthetic */ ObfuscationServices instance;

    public Set<String> getSupportedOptions() {
        ObfuscationServices llllllllllllllllIIllIlIlIllIlllI;
        HashSet<String> llllllllllllllllIIllIlIlIllIllll = new HashSet<String>();
        for (IObfuscationService llllllllllllllllIIllIlIlIlllIIIl : llllllllllllllllIIllIlIlIllIlllI.serviceLoader) {
            Set<String> llllllllllllllllIIllIlIlIlllIIlI = llllllllllllllllIIllIlIlIlllIIIl.getSupportedOptions();
            if (llllllllllllllllIIllIlIlIlllIIlI == null) continue;
            llllllllllllllllIIllIlIlIllIllll.addAll(llllllllllllllllIIllIlIlIlllIIlI);
        }
        return llllllllllllllllIIllIlIlIllIllll;
    }

    public void initProviders(IMixinAnnotationProcessor llllllllllllllllIIllIlIlIlllllll) {
        try {
            ObfuscationServices llllllllllllllllIIllIlIllIIIIIII;
            for (IObfuscationService llllllllllllllllIIllIlIllIIIIlII : llllllllllllllllIIllIlIllIIIIIII.serviceLoader) {
                if (llllllllllllllllIIllIlIllIIIIIII.services.contains(llllllllllllllllIIllIlIllIIIIlII)) continue;
                llllllllllllllllIIllIlIllIIIIIII.services.add(llllllllllllllllIIllIlIllIIIIlII);
                String llllllllllllllllIIllIlIllIIIIllI = llllllllllllllllIIllIlIllIIIIlII.getClass().getSimpleName();
                Collection<ObfuscationTypeDescriptor> llllllllllllllllIIllIlIllIIIIlIl = llllllllllllllllIIllIlIllIIIIlII.getObfuscationTypes();
                if (llllllllllllllllIIllIlIllIIIIlIl == null) continue;
                for (ObfuscationTypeDescriptor llllllllllllllllIIllIlIllIIIIlll : llllllllllllllllIIllIlIllIIIIlIl) {
                    try {
                        ObfuscationType llllllllllllllllIIllIlIllIIIlIIl = ObfuscationType.create(llllllllllllllllIIllIlIllIIIIlll, llllllllllllllllIIllIlIlIlllllll);
                        llllllllllllllllIIllIlIlIlllllll.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(llllllllllllllllIIllIlIllIIIIllI).append(" supports type: \"").append(llllllllllllllllIIllIlIllIIIlIIl).append("\"")));
                    }
                    catch (Exception llllllllllllllllIIllIlIllIIIlIII) {
                        llllllllllllllllIIllIlIllIIIlIII.printStackTrace();
                    }
                }
            }
        }
        catch (ServiceConfigurationError llllllllllllllllIIllIlIllIIIIIll) {
            llllllllllllllllIIllIlIlIlllllll.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(llllllllllllllllIIllIlIllIIIIIll.getClass().getSimpleName()).append(": ").append(llllllllllllllllIIllIlIllIIIIIll.getMessage())));
            llllllllllllllllIIllIlIllIIIIIll.printStackTrace();
        }
    }

    public IObfuscationService getService(Class<? extends IObfuscationService> llllllllllllllllIIllIlIlIllIIIIl) {
        ObfuscationServices llllllllllllllllIIllIlIlIllIIlII;
        for (IObfuscationService llllllllllllllllIIllIlIlIllIIlIl : llllllllllllllllIIllIlIlIllIIlII.serviceLoader) {
            if (!llllllllllllllllIIllIlIlIllIIIIl.getName().equals(llllllllllllllllIIllIlIlIllIIlIl.getClass().getName())) continue;
            return llllllllllllllllIIllIlIlIllIIlIl;
        }
        return null;
    }

    private ObfuscationServices() {
        ObfuscationServices llllllllllllllllIIllIlIllIIlIIll;
        llllllllllllllllIIllIlIllIIlIIll.services = new HashSet<IObfuscationService>();
        llllllllllllllllIIllIlIllIIlIIll.serviceLoader = ServiceLoader.load(IObfuscationService.class, llllllllllllllllIIllIlIllIIlIIll.getClass().getClassLoader());
    }

    public static ObfuscationServices getInstance() {
        if (instance == null) {
            instance = new ObfuscationServices();
        }
        return instance;
    }
}

