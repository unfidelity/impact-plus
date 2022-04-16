/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.launch.platform;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.platform.MainAttributes;
import org.spongepowered.asm.launch.platform.MixinContainer;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.service.MixinService;

public class MixinPlatformManager {
    private final /* synthetic */ Map<URI, MixinContainer> containers;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ boolean prepared;
    private /* synthetic */ MixinContainer primaryContainer;
    private static final /* synthetic */ String MIXIN_TWEAKER_CLASS;
    private /* synthetic */ boolean injected;
    private static final /* synthetic */ String DEFAULT_MAIN_CLASS;

    final void addConfig(String llIllllllIllIlI) {
        if (llIllllllIllIlI.endsWith(".json")) {
            logger.debug("Registering mixin config: {}", new Object[]{llIllllllIllIlI});
            Mixins.addConfiguration(llIllllllIllIlI);
        } else if (llIllllllIllIlI.contains(".json@")) {
            int llIllllllIllllI = llIllllllIllIlI.indexOf(".json@");
            String llIllllllIlllIl = llIllllllIllIlI.substring(llIllllllIllllI + 6);
            llIllllllIllIlI = llIllllllIllIlI.substring(0, llIllllllIllllI + 5);
            MixinEnvironment.Phase llIllllllIlllII = MixinEnvironment.Phase.forName(llIllllllIlllIl);
            if (llIllllllIlllII != null) {
                logger.warn("Setting config phase via manifest is deprecated: {}. Specify target in config instead", new Object[]{llIllllllIllIlI});
                logger.debug("Registering mixin config: {}", new Object[]{llIllllllIllIlI});
                MixinEnvironment.getEnvironment(llIllllllIlllII).addConfiguration(llIllllllIllIlI);
            }
        }
    }

    public final void inject() {
        MixinPlatformManager lllIIIIIllIIlIl;
        if (lllIIIIIllIIlIl.injected) {
            return;
        }
        lllIIIIIllIIlIl.injected = true;
        if (lllIIIIIllIIlIl.primaryContainer != null) {
            lllIIIIIllIIlIl.primaryContainer.initPrimaryContainer();
        }
        lllIIIIIllIIlIl.scanClasspath();
        logger.debug("inject() running with {} agents", new Object[]{lllIIIIIllIIlIl.containers.size()});
        for (MixinContainer lllIIIIIllIIllI : lllIIIIIllIIlIl.containers.values()) {
            try {
                lllIIIIIllIIllI.inject();
            }
            catch (Exception lllIIIIIllIIlll) {
                lllIIIIIllIIlll.printStackTrace();
            }
        }
    }

    final void setCompatibilityLevel(String lllIIIIIIIIIIII) {
        try {
            MixinEnvironment.CompatibilityLevel lllIIIIIIIIIIll = MixinEnvironment.CompatibilityLevel.valueOf(lllIIIIIIIIIIII.toUpperCase());
            logger.debug("Setting mixin compatibility level: {}", new Object[]{lllIIIIIIIIIIll});
            MixinEnvironment.setCompatibilityLevel(lllIIIIIIIIIIll);
        }
        catch (IllegalArgumentException lllIIIIIIIIIIlI) {
            logger.warn("Invalid compatibility level specified: {}", new Object[]{lllIIIIIIIIIIII});
        }
    }

    private void scanClasspath() {
        URL[] lllIIIIIIllIIIl;
        for (URL lllIIIIIIllIIll : lllIIIIIIllIIIl = MixinService.getService().getClassProvider().getClassPath()) {
            try {
                MainAttributes lllIIIIIIllIllI;
                String lllIIIIIIllIlIl;
                MixinPlatformManager lllIIIIIIllIIlI;
                URI lllIIIIIIllIlll = lllIIIIIIllIIll.toURI();
                if (lllIIIIIIllIIlI.containers.containsKey(lllIIIIIIllIlll)) continue;
                logger.debug("Scanning {} for mixin tweaker", new Object[]{lllIIIIIIllIlll});
                if (!"file".equals(lllIIIIIIllIlll.getScheme()) || !new File(lllIIIIIIllIlll).exists() || !"org.spongepowered.asm.launch.MixinTweaker".equals(lllIIIIIIllIlIl = (lllIIIIIIllIllI = MainAttributes.of(lllIIIIIIllIlll)).get("TweakClass"))) continue;
                logger.debug("{} contains a mixin tweaker, adding agents", new Object[]{lllIIIIIIllIlll});
                lllIIIIIIllIIlI.addContainer(lllIIIIIIllIlll);
            }
            catch (Exception lllIIIIIIllIlII) {
                lllIIIIIIllIlII.printStackTrace();
            }
        }
    }

    public Collection<String> getPhaseProviderClasses() {
        MixinPlatformManager lllIIIIlIIlIllI;
        Collection<String> lllIIIIlIIlIlll = lllIIIIlIIlIllI.primaryContainer.getPhaseProviders();
        if (lllIIIIlIIlIlll != null) {
            return Collections.unmodifiableCollection(lllIIIIlIIlIlll);
        }
        return Collections.emptyList();
    }

    public final void prepare(List<String> lllIIIIIlllllll) {
        MixinPlatformManager lllIIIIlIIIIIII;
        lllIIIIlIIIIIII.prepared = true;
        for (MixinContainer lllIIIIlIIIIlII : lllIIIIlIIIIIII.containers.values()) {
            lllIIIIlIIIIlII.prepare();
        }
        if (lllIIIIIlllllll != null) {
            lllIIIIlIIIIIII.parseArgs(lllIIIIIlllllll);
        } else {
            String lllIIIIlIIIIIll = System.getProperty("sun.java.command");
            if (lllIIIIlIIIIIll != null) {
                lllIIIIlIIIIIII.parseArgs(Arrays.asList(lllIIIIlIIIIIll.split(" ")));
            }
        }
    }

    public String getLaunchTarget() {
        MixinPlatformManager lllIIIIIIIlIIll;
        for (MixinContainer lllIIIIIIIlIlII : lllIIIIIIIlIIll.containers.values()) {
            String lllIIIIIIIlIlIl = lllIIIIIIIlIlII.getLaunchTarget();
            if (lllIIIIIIIlIlIl == null) continue;
            return lllIIIIIIIlIlIl;
        }
        return "net.minecraft.client.main.Main";
    }

    public final MixinContainer addContainer(URI lllIIIIlIIIllll) {
        MixinPlatformManager lllIIIIlIIlIIII;
        MixinContainer lllIIIIlIIIlllI = lllIIIIlIIlIIII.containers.get(lllIIIIlIIIllll);
        if (lllIIIIlIIIlllI != null) {
            return lllIIIIlIIIlllI;
        }
        logger.debug("Adding mixin platform agents for container {}", new Object[]{lllIIIIlIIIllll});
        MixinContainer lllIIIIlIIIllIl = new MixinContainer(lllIIIIlIIlIIII, lllIIIIlIIIllll);
        lllIIIIlIIlIIII.containers.put(lllIIIIlIIIllll, lllIIIIlIIIllIl);
        if (lllIIIIlIIlIIII.prepared) {
            lllIIIIlIIIllIl.prepare();
        }
        return lllIIIIlIIIllIl;
    }

    private void parseArgs(List<String> lllIIIIIlllIIlI) {
        boolean lllIIIIIlllIlII = false;
        for (String lllIIIIIlllIlll : lllIIIIIlllIIlI) {
            if (lllIIIIIlllIlII) {
                MixinPlatformManager lllIIIIIlllIllI;
                lllIIIIIlllIllI.addConfig(lllIIIIIlllIlll);
            }
            lllIIIIIlllIlII = "--mixin".equals(lllIIIIIlllIlll);
        }
    }

    public void init() {
        MixinPlatformManager lllIIIIlIIlllIl;
        logger.debug("Initialising Mixin Platform Manager");
        URI lllIIIIlIIllllI = null;
        try {
            lllIIIIlIIllllI = lllIIIIlIIlllIl.getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
            if (lllIIIIlIIllllI != null) {
                logger.debug("Mixin platform: primary container is {}", new Object[]{lllIIIIlIIllllI});
                lllIIIIlIIlllIl.primaryContainer = lllIIIIlIIlllIl.addContainer(lllIIIIlIIllllI);
            }
        }
        catch (URISyntaxException lllIIIIlIlIIIII) {
            lllIIIIlIlIIIII.printStackTrace();
        }
        lllIIIIlIIlllIl.scanClasspath();
    }

    public MixinPlatformManager() {
        MixinPlatformManager lllIIIIlIlIIlIl;
        lllIIIIlIlIIlIl.containers = new LinkedHashMap<URI, MixinContainer>();
        lllIIIIlIlIIlIl.prepared = false;
    }

    final void addTokenProvider(String llIllllllIIllll) {
        if (llIllllllIIllll.contains("@")) {
            String[] llIllllllIlIIlI = llIllllllIIllll.split("@", 2);
            MixinEnvironment.Phase llIllllllIlIIIl = MixinEnvironment.Phase.forName(llIllllllIlIIlI[1]);
            if (llIllllllIlIIIl != null) {
                logger.debug("Registering token provider class: {}", new Object[]{llIllllllIlIIlI[0]});
                MixinEnvironment.getEnvironment(llIllllllIlIIIl).registerTokenProviderClass(llIllllllIlIIlI[0]);
            }
            return;
        }
        MixinEnvironment.getDefaultEnvironment().registerTokenProviderClass(llIllllllIIllll);
    }

    static {
        MIXIN_TWEAKER_CLASS = "org.spongepowered.asm.launch.MixinTweaker";
        DEFAULT_MAIN_CLASS = "net.minecraft.client.main.Main";
        logger = LogManager.getLogger((String)"mixin");
    }
}

