/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.Config;

public final class Mixins {
    private static final /* synthetic */ String CONFIGS_KEY;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ Set<String> errorHandlers;

    private static void registerConfiguration(Config llllllllllllllllllIlIlllIIlIIlII) {
        if (llllllllllllllllllIlIlllIIlIIlII == null) {
            return;
        }
        MixinEnvironment llllllllllllllllllIlIlllIIlIIIIl = llllllllllllllllllIlIlllIIlIIlII.getEnvironment();
        if (llllllllllllllllllIlIlllIIlIIIIl != null) {
            llllllllllllllllllIlIlllIIlIIIIl.registerConfig(llllllllllllllllllIlIlllIIlIIlII.getName());
        }
        Mixins.getConfigs().add(llllllllllllllllllIlIlllIIlIIlII);
    }

    public static void registerErrorHandlerClass(String llllllllllllllllllIlIllIlllllIII) {
        if (llllllllllllllllllIlIllIlllllIII != null) {
            errorHandlers.add(llllllllllllllllllIlIllIlllllIII);
        }
    }

    public static void addConfiguration(String llllllllllllllllllIlIlllIlIIlIlI) {
        Mixins.createConfiguration(llllllllllllllllllIlIlllIlIIlIlI, MixinEnvironment.getDefaultEnvironment());
    }

    static {
        CONFIGS_KEY = "mixin.configs.queue";
        logger = LogManager.getLogger((String)"mixin");
        errorHandlers = new LinkedHashSet<String>();
    }

    public static Set<String> getErrorHandlerClasses() {
        return Collections.unmodifiableSet(errorHandlers);
    }

    private static void createConfiguration(String llllllllllllllllllIlIlllIIllllII, MixinEnvironment llllllllllllllllllIlIlllIIllIIll) {
        Config llllllllllllllllllIlIlllIIlllIII = null;
        try {
            llllllllllllllllllIlIlllIIlllIII = Config.create(llllllllllllllllllIlIlllIIllllII, llllllllllllllllllIlIlllIIllIIll);
        }
        catch (Exception llllllllllllllllllIlIlllIIlllllI) {
            logger.error(String.valueOf(new StringBuilder().append("Error encountered reading mixin config ").append(llllllllllllllllllIlIlllIIllllII).append(": ").append(llllllllllllllllllIlIlllIIlllllI.getClass().getName()).append(" ").append(llllllllllllllllllIlIlllIIlllllI.getMessage())), (Throwable)llllllllllllllllllIlIlllIIlllllI);
        }
        Mixins.registerConfiguration(llllllllllllllllllIlIlllIIlllIII);
    }

    @Deprecated
    static void addConfiguration(String llllllllllllllllllIlIlllIlIIIlll, MixinEnvironment llllllllllllllllllIlIlllIlIIIlII) {
        Mixins.createConfiguration(llllllllllllllllllIlIlllIlIIIlll, llllllllllllllllllIlIlllIlIIIlII);
    }

    public static void addConfigurations(String ... llllllllllllllllllIlIlllIlIlIlII) {
        MixinEnvironment llllllllllllllllllIlIlllIlIlIIll = MixinEnvironment.getDefaultEnvironment();
        for (String llllllllllllllllllIlIlllIlIlIlIl : llllllllllllllllllIlIlllIlIlIlII) {
            Mixins.createConfiguration(llllllllllllllllllIlIlllIlIlIlIl, llllllllllllllllllIlIlllIlIlIIll);
        }
    }

    public static int getUnvisitedCount() {
        int llllllllllllllllllIlIlllIIIIlIII = 0;
        for (Config llllllllllllllllllIlIlllIIIIlIIl : Mixins.getConfigs()) {
            if (llllllllllllllllllIlIlllIIIIlIIl.isVisited()) continue;
            ++llllllllllllllllllIlIlllIIIIlIII;
        }
        return llllllllllllllllllIlIlllIIIIlIII;
    }

    private Mixins() {
        Mixins llllllllllllllllllIlIlllIllIlIll;
    }

    public static Set<Config> getConfigs() {
        LinkedHashSet llllllllllllllllllIlIllIlllllIll = (LinkedHashSet)GlobalProperties.get("mixin.configs.queue");
        if (llllllllllllllllllIlIllIlllllIll == null) {
            llllllllllllllllllIlIllIlllllIll = new LinkedHashSet();
            GlobalProperties.put("mixin.configs.queue", llllllllllllllllllIlIllIlllllIll);
        }
        return llllllllllllllllllIlIllIlllllIll;
    }
}

