/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.IMixinServiceBootstrap;
import org.spongepowered.asm.service.ServiceNotAvailableError;

public final class MixinService {
    private /* synthetic */ ServiceLoader<IMixinServiceBootstrap> bootstrapServiceLoader;
    private final /* synthetic */ Set<String> bootedServices;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ ServiceLoader<IMixinService> serviceLoader;
    private /* synthetic */ IMixinService service;
    private static /* synthetic */ MixinService instance;

    private synchronized IMixinService getServiceInstance() {
        MixinService llIIIIIIlllIIIl;
        if (llIIIIIIlllIIIl.service == null) {
            llIIIIIIlllIIIl.service = llIIIIIIlllIIIl.initService();
            if (llIIIIIIlllIIIl.service == null) {
                throw new ServiceNotAvailableError("No mixin host service is available");
            }
        }
        return llIIIIIIlllIIIl.service;
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    public static IMixinService getService() {
        return MixinService.getInstance().getServiceInstance();
    }

    public static void boot() {
        MixinService.getInstance();
    }

    private MixinService() {
        MixinService llIIIIIlIlllllI;
        llIIIIIlIlllllI.bootedServices = new HashSet<String>();
        llIIIIIlIlllllI.service = null;
        llIIIIIlIlllllI.runBootServices();
    }

    private static MixinService getInstance() {
        if (instance == null) {
            instance = new MixinService();
        }
        return instance;
    }

    private IMixinService initService() {
        MixinService llIIIIIIllIIlll;
        llIIIIIIllIIlll.serviceLoader = ServiceLoader.load(IMixinService.class, llIIIIIIllIIlll.getClass().getClassLoader());
        Iterator<IMixinService> llIIIIIIllIlIII = llIIIIIIllIIlll.serviceLoader.iterator();
        while (llIIIIIIllIlIII.hasNext()) {
            try {
                IMixinService llIIIIIIllIllII = llIIIIIIllIlIII.next();
                if (llIIIIIIllIIlll.bootedServices.contains(llIIIIIIllIllII.getClass().getName())) {
                    logger.debug("MixinService [{}] was successfully booted in {}", new Object[]{llIIIIIIllIllII.getName(), llIIIIIIllIIlll.getClass().getClassLoader()});
                }
                if (!llIIIIIIllIllII.isValid()) continue;
                return llIIIIIIllIllII;
            }
            catch (ServiceConfigurationError llIIIIIIllIlIll) {
                llIIIIIIllIlIll.printStackTrace();
            }
            catch (Throwable llIIIIIIllIlIlI) {
                llIIIIIIllIlIlI.printStackTrace();
            }
        }
        return null;
    }

    private void runBootServices() {
        MixinService llIIIIIIlllllIl;
        llIIIIIIlllllIl.bootstrapServiceLoader = ServiceLoader.load(IMixinServiceBootstrap.class, llIIIIIIlllllIl.getClass().getClassLoader());
        for (IMixinServiceBootstrap llIIIIIIllllllI : llIIIIIIlllllIl.bootstrapServiceLoader) {
            try {
                llIIIIIIllllllI.bootstrap();
                llIIIIIIlllllIl.bootedServices.add(llIIIIIIllllllI.getServiceClassName());
            }
            catch (Throwable llIIIIIIlllllll) {
                logger.catching(llIIIIIIlllllll);
            }
        }
    }
}

