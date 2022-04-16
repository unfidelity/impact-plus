/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.launch;

import java.util.ServiceLoader;
import org.spongepowered.asm.service.IGlobalPropertyService;

public final class GlobalProperties {
    private static /* synthetic */ IGlobalPropertyService service;

    public static <T> T get(String lllllllllllllllllIllIlIIIIIIIlIl, T lllllllllllllllllIllIlIIIIIIIIlI) {
        return GlobalProperties.getService().getProperty(lllllllllllllllllIllIlIIIIIIIlIl, lllllllllllllllllIllIlIIIIIIIIlI);
    }

    private static IGlobalPropertyService getService() {
        if (service == null) {
            ServiceLoader<IGlobalPropertyService> lllllllllllllllllIllIlIIIIIllllI = ServiceLoader.load(IGlobalPropertyService.class, GlobalProperties.class.getClassLoader());
            service = lllllllllllllllllIllIlIIIIIllllI.iterator().next();
        }
        return service;
    }

    public static <T> T get(String lllllllllllllllllIllIlIIIIIIlllI) {
        return GlobalProperties.getService().getProperty(lllllllllllllllllIllIlIIIIIIlllI);
    }

    private GlobalProperties() {
        GlobalProperties lllllllllllllllllIllIlIIIIlIllll;
    }

    public static void put(String lllllllllllllllllIllIlIIIIIIlIll, Object lllllllllllllllllIllIlIIIIIIlIlI) {
        GlobalProperties.getService().setProperty(lllllllllllllllllIllIlIIIIIIlIll, lllllllllllllllllIllIlIIIIIIlIlI);
    }

    public static String getString(String lllllllllllllllllIllIIllllllllIl, String lllllllllllllllllIllIIllllllllII) {
        return GlobalProperties.getService().getPropertyString(lllllllllllllllllIllIIllllllllIl, lllllllllllllllllIllIIllllllllII);
    }

    public static final class Keys {
        public static final /* synthetic */ String TRANSFORMER;
        public static final /* synthetic */ String FML_GET_REPARSEABLE_COREMODS;
        public static final /* synthetic */ String PLATFORM_MANAGER;
        public static final /* synthetic */ String AGENTS;
        public static final /* synthetic */ String FML_LOAD_CORE_MOD;
        public static final /* synthetic */ String FML_CORE_MOD_MANAGER;
        public static final /* synthetic */ String FML_GET_IGNORED_MODS;
        public static final /* synthetic */ String CONFIGS;
        public static final /* synthetic */ String INIT;

        private Keys() {
            Keys llllllllllllllllIlIIIllIlIIllIIl;
        }

        static {
            INIT = "mixin.initialised";
            PLATFORM_MANAGER = "mixin.platform";
            FML_GET_REPARSEABLE_COREMODS = "mixin.launch.fml.reparseablecoremodsmethod";
            FML_LOAD_CORE_MOD = "mixin.launch.fml.loadcoremodmethod";
            TRANSFORMER = "mixin.transformer";
            FML_CORE_MOD_MANAGER = "mixin.launch.fml.coremodmanagerclass";
            FML_GET_IGNORED_MODS = "mixin.launch.fml.ignoredmodsmethod";
            CONFIGS = "mixin.configs";
            AGENTS = "mixin.agents";
        }
    }
}

