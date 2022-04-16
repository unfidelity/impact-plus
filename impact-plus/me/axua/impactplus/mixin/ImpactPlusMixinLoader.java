/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
 */
package me.axua.impactplus.mixin;

import java.util.Map;
import javax.annotation.Nullable;
import me.axua.impactplus.ImpactPlus;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

public class ImpactPlusMixinLoader
implements IFMLLoadingPlugin {
    private static /* synthetic */ boolean isObfuscatedEnvironment;

    public String getAccessTransformerClass() {
        return null;
    }

    public ImpactPlusMixinLoader() {
        ImpactPlusMixinLoader lllllllllllllllllIIlIIIllIIlIIII;
        ImpactPlus.log.info("ImpactPlus mixins initialized");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.impactplus.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
        ImpactPlus.log.info(MixinEnvironment.getDefaultEnvironment().getObfuscationContext());
    }

    static {
        isObfuscatedEnvironment = false;
    }

    public void injectData(Map<String, Object> lllllllllllllllllIIlIIIllIIIlIIl) {
        isObfuscatedEnvironment = (Boolean)lllllllllllllllllIIlIIIllIIIlIIl.get("runtimeDeobfuscationEnabled");
    }

    @Nullable
    public String getSetupClass() {
        return null;
    }

    public String[] getASMTransformerClass() {
        return new String[0];
    }

    public String getModContainerClass() {
        return null;
    }
}

