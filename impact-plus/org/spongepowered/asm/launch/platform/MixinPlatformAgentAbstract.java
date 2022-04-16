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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.platform.IMixinPlatformAgent;
import org.spongepowered.asm.launch.platform.MainAttributes;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;

public abstract class MixinPlatformAgentAbstract
implements IMixinPlatformAgent {
    protected static final /* synthetic */ Logger logger;
    protected final /* synthetic */ URI uri;
    protected final /* synthetic */ MainAttributes attributes;
    protected final /* synthetic */ File container;
    protected final /* synthetic */ MixinPlatformManager manager;

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    public String toString() {
        MixinPlatformAgentAbstract lllllllllllllllllIlIIllllllIllII;
        return String.format("PlatformAgent[%s:%s]", lllllllllllllllllIlIIllllllIllII.getClass().getSimpleName(), lllllllllllllllllIlIIllllllIllII.uri);
    }

    public MixinPlatformAgentAbstract(MixinPlatformManager lllllllllllllllllIlIIlllllllIIII, URI lllllllllllllllllIlIIllllllIllll) {
        MixinPlatformAgentAbstract lllllllllllllllllIlIIlllllllIlII;
        lllllllllllllllllIlIIlllllllIlII.manager = lllllllllllllllllIlIIlllllllIIII;
        lllllllllllllllllIlIIlllllllIlII.uri = lllllllllllllllllIlIIllllllIllll;
        lllllllllllllllllIlIIlllllllIlII.container = lllllllllllllllllIlIIlllllllIlII.uri != null ? new File(lllllllllllllllllIlIIlllllllIlII.uri) : null;
        lllllllllllllllllIlIIlllllllIlII.attributes = MainAttributes.of(lllllllllllllllllIlIIllllllIllll);
    }

    @Override
    public String getPhaseProvider() {
        return null;
    }
}

