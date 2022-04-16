/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.IClassTransformer
 *  org.apache.logging.log4j.LogManager
 */
package org.spongepowered.asm.mixin.transformer;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;
import org.spongepowered.asm.service.ILegacyClassTransformer;

public final class Proxy
implements IClassTransformer,
ILegacyClassTransformer {
    private static /* synthetic */ MixinTransformer transformer;
    private /* synthetic */ boolean isActive;
    private static /* synthetic */ List<Proxy> proxies;

    @Override
    public byte[] transformClassBytes(String llllllllllllllllIlIlIllIlIlIlIIl, String llllllllllllllllIlIlIllIlIlIIlIl, byte[] llllllllllllllllIlIlIllIlIlIIIll) {
        Proxy llllllllllllllllIlIlIllIlIlIlIll;
        if (llllllllllllllllIlIlIllIlIlIlIll.isActive) {
            return transformer.transformClassBytes(llllllllllllllllIlIlIllIlIlIlIIl, llllllllllllllllIlIlIllIlIlIIlIl, llllllllllllllllIlIlIllIlIlIIIll);
        }
        return llllllllllllllllIlIlIllIlIlIIIll;
    }

    static {
        proxies = new ArrayList<Proxy>();
        transformer = new MixinTransformer();
    }

    @Override
    public String getName() {
        Proxy llllllllllllllllIlIlIllIllIIIIIl;
        return llllllllllllllllIlIlIllIllIIIIIl.getClass().getName();
    }

    @Override
    public boolean isDelegationExcluded() {
        return true;
    }

    public byte[] transform(String llllllllllllllllIlIlIllIllIIIlll, String llllllllllllllllIlIlIllIllIIlIlI, byte[] llllllllllllllllIlIlIllIllIIlIIl) {
        Proxy llllllllllllllllIlIlIllIllIIllII;
        if (llllllllllllllllIlIlIllIllIIllII.isActive) {
            return transformer.transformClassBytes(llllllllllllllllIlIlIllIllIIIlll, llllllllllllllllIlIlIllIllIIlIlI, llllllllllllllllIlIlIllIllIIlIIl);
        }
        return llllllllllllllllIlIlIllIllIIlIIl;
    }

    public Proxy() {
        Proxy llllllllllllllllIlIlIllIllIlIlII;
        llllllllllllllllIlIlIllIllIlIlII.isActive = true;
        for (Proxy llllllllllllllllIlIlIllIllIlIlIl : proxies) {
            llllllllllllllllIlIlIllIllIlIlIl.isActive = false;
        }
        proxies.add(llllllllllllllllIlIlIllIllIlIlII);
        LogManager.getLogger((String)"mixin").debug("Adding new mixin transformer proxy #{}", new Object[]{proxies.size()});
    }
}

