/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.launch;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.launch.MixinInitialisationError;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.service.MixinService;

public abstract class MixinBootstrap {
    private static /* synthetic */ boolean initState;
    private static final /* synthetic */ Logger logger;
    public static final /* synthetic */ String VERSION;
    private static /* synthetic */ boolean initialised;
    private static /* synthetic */ MixinPlatformManager platform;

    private static void registerSubsystem(String lllllllllllllllllIlIIllIIIllIlII) {
        GlobalProperties.put("mixin.initialised", lllllllllllllllllIlIIllIIIllIlII);
    }

    private static boolean checkSubsystemVersion() {
        return "0.7.4".equals(MixinBootstrap.getActiveSubsystemVersion());
    }

    private MixinBootstrap() {
        MixinBootstrap lllllllllllllllllIlIIllIlIIIlIII;
    }

    static void doInit(List<String> lllllllllllllllllIlIIllIIlIllIII) {
        if (!initialised) {
            if (MixinBootstrap.isSubsystemRegistered()) {
                logger.warn("Multiple Mixin containers present, init suppressed for 0.7.4");
                return;
            }
            throw new IllegalStateException("MixinBootstrap.doInit() called before MixinBootstrap.start()");
        }
        MixinBootstrap.getPlatform().getPhaseProviderClasses();
        if (initState) {
            MixinBootstrap.getPlatform().prepare(lllllllllllllllllIlIIllIIlIllIII);
            MixinService.getService().init();
        }
    }

    static void inject() {
        MixinBootstrap.getPlatform().inject();
    }

    @Deprecated
    public static void addProxy() {
        MixinService.getService().beginPhase();
    }

    private static boolean isSubsystemRegistered() {
        return GlobalProperties.get("mixin.initialised") != null;
    }

    public static void init() {
        if (!MixinBootstrap.start()) {
            return;
        }
        MixinBootstrap.doInit(null);
    }

    static {
        VERSION = "0.7.4";
        logger = LogManager.getLogger((String)"mixin");
        initialised = false;
        initState = true;
        MixinService.boot();
        MixinService.getService().prepare();
    }

    static boolean start() {
        if (MixinBootstrap.isSubsystemRegistered()) {
            if (!MixinBootstrap.checkSubsystemVersion()) {
                throw new MixinInitialisationError(String.valueOf(new StringBuilder().append("Mixin subsystem version ").append(MixinBootstrap.getActiveSubsystemVersion()).append(" was already initialised. Cannot bootstrap version ").append("0.7.4")));
            }
            return false;
        }
        MixinBootstrap.registerSubsystem("0.7.4");
        if (!initialised) {
            MixinEnvironment.Phase lllllllllllllllllIlIIllIIllIlIlI;
            initialised = true;
            String lllllllllllllllllIlIIllIIllIllII = System.getProperty("sun.java.command");
            if (lllllllllllllllllIlIIllIIllIllII != null && lllllllllllllllllIlIIllIIllIllII.contains("GradleStart")) {
                System.setProperty("mixin.env.remapRefMap", "true");
            }
            if ((lllllllllllllllllIlIIllIIllIlIlI = MixinService.getService().getInitialPhase()) == MixinEnvironment.Phase.DEFAULT) {
                logger.error("Initialising mixin subsystem after game pre-init phase! Some mixins may be skipped.");
                MixinEnvironment.init(lllllllllllllllllIlIIllIIllIlIlI);
                MixinBootstrap.getPlatform().prepare(null);
                initState = false;
            } else {
                MixinEnvironment.init(lllllllllllllllllIlIIllIIllIlIlI);
            }
            MixinService.getService().beginPhase();
        }
        MixinBootstrap.getPlatform();
        return true;
    }

    public static MixinPlatformManager getPlatform() {
        if (platform == null) {
            Object lllllllllllllllllIlIIllIlIIIIIll = GlobalProperties.get("mixin.platform");
            if (lllllllllllllllllIlIIllIlIIIIIll instanceof MixinPlatformManager) {
                platform = (MixinPlatformManager)lllllllllllllllllIlIIllIlIIIIIll;
            } else {
                platform = new MixinPlatformManager();
                GlobalProperties.put("mixin.platform", platform);
                platform.init();
            }
        }
        return platform;
    }

    private static Object getActiveSubsystemVersion() {
        Object lllllllllllllllllIlIIllIIIllllll = GlobalProperties.get("mixin.initialised");
        return lllllllllllllllllIlIIllIIIllllll != null ? lllllllllllllllllIlIIllIIIllllll : "";
    }
}

