/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.ITweaker
 *  net.minecraft.launchwrapper.LaunchClassLoader
 */
package org.spongepowered.asm.launch;

import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;

public class MixinTweaker
implements ITweaker {
    public String[] getLaunchArguments() {
        return new String[0];
    }

    public final void injectIntoClassLoader(LaunchClassLoader llllllllllllllllIIllIlIllIIllIII) {
        MixinBootstrap.inject();
    }

    public final void acceptOptions(List<String> llllllllllllllllIIllIlIllIIllllI, File llllllllllllllllIIllIlIllIIlllIl, File llllllllllllllllIIllIlIllIIlllII, String llllllllllllllllIIllIlIllIIllIll) {
        MixinBootstrap.doInit(llllllllllllllllIIllIlIllIIllllI);
    }

    public String getLaunchTarget() {
        return MixinBootstrap.getPlatform().getLaunchTarget();
    }

    public MixinTweaker() {
        MixinTweaker llllllllllllllllIIllIlIllIlIIIIl;
        MixinBootstrap.start();
    }
}

