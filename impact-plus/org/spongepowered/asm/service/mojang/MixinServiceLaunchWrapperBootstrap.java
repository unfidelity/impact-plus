/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.Launch
 */
package org.spongepowered.asm.service.mojang;

import net.minecraft.launchwrapper.Launch;
import org.spongepowered.asm.service.IMixinServiceBootstrap;

public class MixinServiceLaunchWrapperBootstrap
implements IMixinServiceBootstrap {
    private static final /* synthetic */ String MIXIN_UTIL_PACKAGE;
    private static final /* synthetic */ String MIXIN_PACKAGE;
    private static final /* synthetic */ String SERVICE_PACKAGE;
    private static final /* synthetic */ String ASM_PACKAGE;

    @Override
    public String getName() {
        return "LaunchWrapper";
    }

    @Override
    public void bootstrap() {
        Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.service.");
        Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.lib.");
        Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.mixin.");
        Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.util.");
    }

    static {
        MIXIN_UTIL_PACKAGE = "org.spongepowered.asm.util.";
        SERVICE_PACKAGE = "org.spongepowered.asm.service.";
        MIXIN_PACKAGE = "org.spongepowered.asm.mixin.";
        ASM_PACKAGE = "org.spongepowered.asm.lib.";
    }

    @Override
    public String getServiceClassName() {
        return "org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapper";
    }

    public MixinServiceLaunchWrapperBootstrap() {
        MixinServiceLaunchWrapperBootstrap llllllllllllllllIlIlIlllIlIIIlIl;
    }
}

