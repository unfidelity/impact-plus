/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.transformer.MixinConfig;

public class Config {
    private final /* synthetic */ String name;
    private final /* synthetic */ MixinConfig config;

    public Config(MixinConfig lllIllIlllIIIll) {
        Config lllIllIlllIIlII;
        lllIllIlllIIlII.name = lllIllIlllIIIll.getName();
        lllIllIlllIIlII.config = lllIllIlllIIIll;
    }

    public String toString() {
        Config lllIllIllIlIIIl;
        return lllIllIllIlIIIl.config.toString();
    }

    public static Config create(String lllIllIlIllllll) {
        return MixinConfig.create(lllIllIlIllllll, MixinEnvironment.getDefaultEnvironment());
    }

    @Deprecated
    public static Config create(String lllIllIllIIIlIl, MixinEnvironment lllIllIllIIIIlI) {
        return MixinConfig.create(lllIllIllIIIlIl, lllIllIllIIIIlI);
    }

    public String getName() {
        Config lllIllIlllIIIIl;
        return lllIllIlllIIIIl.name;
    }

    public int hashCode() {
        Config lllIllIllIIlIIl;
        return lllIllIllIIlIIl.name.hashCode();
    }

    public MixinEnvironment getEnvironment() {
        Config lllIllIllIlIlIl;
        return lllIllIllIlIlIl.config.getEnvironment();
    }

    MixinConfig get() {
        Config lllIllIllIlllIl;
        return lllIllIllIlllIl.config;
    }

    public IMixinConfig getConfig() {
        Config lllIllIllIlIlll;
        return lllIllIllIlIlll.config;
    }

    public boolean equals(Object lllIllIllIIllIl) {
        Config lllIllIllIIllII;
        return lllIllIllIIllIl instanceof Config && lllIllIllIIllII.name.equals(((Config)lllIllIllIIllIl).name);
    }

    public boolean isVisited() {
        Config lllIllIllIllIlI;
        return lllIllIllIllIlI.config.isVisited();
    }
}

