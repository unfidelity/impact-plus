/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.launch.platform;

import java.net.URI;
import org.spongepowered.asm.launch.platform.MixinPlatformAgentAbstract;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;

public class MixinPlatformAgentDefault
extends MixinPlatformAgentAbstract {
    @Override
    public void initPrimaryContainer() {
    }

    public MixinPlatformAgentDefault(MixinPlatformManager llllllllllllllllIllIIIlIIllIlIll, URI llllllllllllllllIllIIIlIIllIlIlI) {
        super(llllllllllllllllIllIIIlIIllIlIll, llllllllllllllllIllIIIlIIllIlIlI);
        MixinPlatformAgentDefault llllllllllllllllIllIIIlIIllIlIIl;
    }

    @Override
    public String getLaunchTarget() {
        MixinPlatformAgentDefault llllllllllllllllIllIIIlIIIllllll;
        return llllllllllllllllIllIIIlIIIllllll.attributes.get("Main-Class");
    }

    @Override
    public void inject() {
    }

    @Override
    public void prepare() {
        String llllllllllllllllIllIIIlIIlIlIIII;
        String llllllllllllllllIllIIIlIIlIlIIIl;
        MixinPlatformAgentDefault llllllllllllllllIllIIIlIIlIIlllI;
        String llllllllllllllllIllIIIlIIlIlIIlI = llllllllllllllllIllIIIlIIlIIlllI.attributes.get("MixinCompatibilityLevel");
        if (llllllllllllllllIllIIIlIIlIlIIlI != null) {
            llllllllllllllllIllIIIlIIlIIlllI.manager.setCompatibilityLevel(llllllllllllllllIllIIIlIIlIlIIlI);
        }
        if ((llllllllllllllllIllIIIlIIlIlIIIl = llllllllllllllllIllIIIlIIlIIlllI.attributes.get("MixinConfigs")) != null) {
            for (String llllllllllllllllIllIIIlIIlIlIllI : llllllllllllllllIllIIIlIIlIlIIIl.split(",")) {
                llllllllllllllllIllIIIlIIlIIlllI.manager.addConfig(llllllllllllllllIllIIIlIIlIlIllI.trim());
            }
        }
        if ((llllllllllllllllIllIIIlIIlIlIIII = llllllllllllllllIllIIIlIIlIIlllI.attributes.get("MixinTokenProviders")) != null) {
            for (String llllllllllllllllIllIIIlIIlIlIlIl : llllllllllllllllIllIIIlIIlIlIIII.split(",")) {
                llllllllllllllllIllIIIlIIlIIlllI.manager.addTokenProvider(llllllllllllllllIllIIIlIIlIlIlIl.trim());
            }
        }
    }
}

