/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.launch.platform;

import java.lang.reflect.Constructor;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.launch.platform.IMixinPlatformAgent;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;
import org.spongepowered.asm.service.MixinService;

public class MixinContainer {
    private final /* synthetic */ List<IMixinPlatformAgent> agents;
    private final /* synthetic */ Logger logger;
    private final /* synthetic */ URI uri;
    private static final /* synthetic */ List<String> agentClasses;

    static {
        agentClasses = new ArrayList<String>();
        GlobalProperties.put("mixin.agents", agentClasses);
        for (String lllllllllllllllllIlIlIIIlIllIIII : MixinService.getService().getPlatformAgents()) {
            agentClasses.add(lllllllllllllllllIlIlIIIlIllIIII);
        }
        agentClasses.add("org.spongepowered.asm.launch.platform.MixinPlatformAgentDefault");
    }

    public MixinContainer(MixinPlatformManager lllllllllllllllllIlIlIIlIIlIIllI, URI lllllllllllllllllIlIlIIlIIlIIIlI) {
        MixinContainer lllllllllllllllllIlIlIIlIIlIIlII;
        lllllllllllllllllIlIlIIlIIlIIlII.logger = LogManager.getLogger((String)"mixin");
        lllllllllllllllllIlIlIIlIIlIIlII.agents = new ArrayList<IMixinPlatformAgent>();
        lllllllllllllllllIlIlIIlIIlIIlII.uri = lllllllllllllllllIlIlIIlIIlIIIlI;
        for (String lllllllllllllllllIlIlIIlIIlIlIII : agentClasses) {
            try {
                Class<?> lllllllllllllllllIlIlIIlIIlIllIl = Class.forName(lllllllllllllllllIlIlIIlIIlIlIII);
                Constructor<?> lllllllllllllllllIlIlIIlIIlIlIll = lllllllllllllllllIlIlIIlIIlIllIl.getDeclaredConstructor(MixinPlatformManager.class, URI.class);
                lllllllllllllllllIlIlIIlIIlIIlII.logger.debug("Instancing new {} for {}", new Object[]{lllllllllllllllllIlIlIIlIIlIllIl.getSimpleName(), lllllllllllllllllIlIlIIlIIlIIlII.uri});
                IMixinPlatformAgent lllllllllllllllllIlIlIIlIIlIlIlI = (IMixinPlatformAgent)lllllllllllllllllIlIlIIlIIlIlIll.newInstance(lllllllllllllllllIlIlIIlIIlIIllI, lllllllllllllllllIlIlIIlIIlIIIlI);
                lllllllllllllllllIlIlIIlIIlIIlII.agents.add(lllllllllllllllllIlIlIIlIIlIlIlI);
            }
            catch (Exception lllllllllllllllllIlIlIIlIIlIlIIl) {
                lllllllllllllllllIlIlIIlIIlIIlII.logger.catching((Throwable)lllllllllllllllllIlIlIIlIIlIlIIl);
            }
        }
    }

    public void inject() {
        MixinContainer lllllllllllllllllIlIlIIIllIllIIl;
        for (IMixinPlatformAgent lllllllllllllllllIlIlIIIllIllIlI : lllllllllllllllllIlIlIIIllIllIIl.agents) {
            lllllllllllllllllIlIlIIIllIllIIl.logger.debug("Processing inject() for {}", new Object[]{lllllllllllllllllIlIlIIIllIllIlI});
            lllllllllllllllllIlIlIIIllIllIlI.inject();
        }
    }

    public void initPrimaryContainer() {
        MixinContainer lllllllllllllllllIlIlIIIlllIlIIl;
        for (IMixinPlatformAgent lllllllllllllllllIlIlIIIlllIlIlI : lllllllllllllllllIlIlIIIlllIlIIl.agents) {
            lllllllllllllllllIlIlIIIlllIlIIl.logger.debug("Processing launch tasks for {}", new Object[]{lllllllllllllllllIlIlIIIlllIlIlI});
            lllllllllllllllllIlIlIIIlllIlIlI.initPrimaryContainer();
        }
    }

    public String getLaunchTarget() {
        MixinContainer lllllllllllllllllIlIlIIIlIlllllI;
        for (IMixinPlatformAgent lllllllllllllllllIlIlIIIllIIIIII : lllllllllllllllllIlIlIIIlIlllllI.agents) {
            String lllllllllllllllllIlIlIIIllIIIIlI = lllllllllllllllllIlIlIIIllIIIIII.getLaunchTarget();
            if (lllllllllllllllllIlIlIIIllIIIIlI == null) continue;
            return lllllllllllllllllIlIlIIIllIIIIlI;
        }
        return null;
    }

    public void prepare() {
        MixinContainer lllllllllllllllllIlIlIIIllllIllI;
        for (IMixinPlatformAgent lllllllllllllllllIlIlIIIlllllIlI : lllllllllllllllllIlIlIIIllllIllI.agents) {
            lllllllllllllllllIlIlIIIllllIllI.logger.debug("Processing prepare() for {}", new Object[]{lllllllllllllllllIlIlIIIlllllIlI});
            lllllllllllllllllIlIlIIIlllllIlI.prepare();
        }
    }

    public Collection<String> getPhaseProviders() {
        MixinContainer lllllllllllllllllIlIlIIlIIIIlIIl;
        ArrayList<String> lllllllllllllllllIlIlIIlIIIIlIII = new ArrayList<String>();
        for (IMixinPlatformAgent lllllllllllllllllIlIlIIlIIIIlIlI : lllllllllllllllllIlIlIIlIIIIlIIl.agents) {
            String lllllllllllllllllIlIlIIlIIIIlIll = lllllllllllllllllIlIlIIlIIIIlIlI.getPhaseProvider();
            if (lllllllllllllllllIlIlIIlIIIIlIll == null) continue;
            lllllllllllllllllIlIlIIlIIIIlIII.add(lllllllllllllllllIlIlIIlIIIIlIll);
        }
        return lllllllllllllllllIlIlIIlIIIIlIII;
    }

    public URI getURI() {
        MixinContainer lllllllllllllllllIlIlIIlIIIlIlll;
        return lllllllllllllllllIlIlIIlIIIlIlll.uri;
    }
}

