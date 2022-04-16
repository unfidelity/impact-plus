/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 */
package org.spongepowered.asm.mixin.transformer.ext;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;
import org.spongepowered.asm.mixin.transformer.ext.IClassGenerator;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;

public final class Extensions {
    private /* synthetic */ List<IExtension> activeExtensions;
    private final /* synthetic */ MixinTransformer transformer;
    private final /* synthetic */ List<IExtension> extensions;
    private final /* synthetic */ List<IClassGenerator> generatorsView;
    private final /* synthetic */ Map<Class<? extends IExtension>, IExtension> extensionMap;
    private final /* synthetic */ List<IClassGenerator> generators;
    private final /* synthetic */ Map<Class<? extends IClassGenerator>, IClassGenerator> generatorMap;

    public List<IClassGenerator> getGenerators() {
        Extensions llllllllllllllllIIlIIllIlIlIIlII;
        return llllllllllllllllIIlIIllIlIlIIlII.generatorsView;
    }

    public Extensions(MixinTransformer llllllllllllllllIIlIIllIllllllII) {
        Extensions llllllllllllllllIIlIIllIllllllIl;
        llllllllllllllllIIlIIllIllllllIl.extensions = new ArrayList<IExtension>();
        llllllllllllllllIIlIIllIllllllIl.extensionMap = new HashMap<Class<? extends IExtension>, IExtension>();
        llllllllllllllllIIlIIllIllllllIl.generators = new ArrayList<IClassGenerator>();
        llllllllllllllllIIlIIllIllllllIl.generatorsView = Collections.unmodifiableList(llllllllllllllllIIlIIllIllllllIl.generators);
        llllllllllllllllIIlIIllIllllllIl.generatorMap = new HashMap<Class<? extends IClassGenerator>, IClassGenerator>();
        llllllllllllllllIIlIIllIllllllIl.activeExtensions = Collections.emptyList();
        llllllllllllllllIIlIIllIllllllIl.transformer = llllllllllllllllIIlIIllIllllllII;
    }

    public void add(IClassGenerator llllllllllllllllIIlIIllIlIlIlIIl) {
        Extensions llllllllllllllllIIlIIllIlIlIlIII;
        llllllllllllllllIIlIIllIlIlIlIII.generators.add(llllllllllllllllIIlIIllIlIlIlIIl);
        llllllllllllllllIIlIIllIlIlIlIII.generatorMap.put(llllllllllllllllIIlIIllIlIlIlIIl.getClass(), llllllllllllllllIIlIIllIlIlIlIIl);
    }

    public <T extends IClassGenerator> T getGenerator(Class<? extends IClassGenerator> llllllllllllllllIIlIIllIlIIllllI) {
        Extensions llllllllllllllllIIlIIllIlIlIIIIl;
        return (T)Extensions.lookup(llllllllllllllllIIlIIllIlIIllllI, llllllllllllllllIIlIIllIlIlIIIIl.generatorMap, llllllllllllllllIIlIIllIlIlIIIIl.generators);
    }

    public void select(MixinEnvironment llllllllllllllllIIlIIllIllIllIlI) {
        Extensions llllllllllllllllIIlIIllIllIllIll;
        ImmutableList.Builder llllllllllllllllIIlIIllIllIlllII = ImmutableList.builder();
        for (IExtension llllllllllllllllIIlIIllIllIlllll : llllllllllllllllIIlIIllIllIllIll.extensions) {
            if (!llllllllllllllllIIlIIllIllIlllll.checkActive(llllllllllllllllIIlIIllIllIllIlI)) continue;
            llllllllllllllllIIlIIllIllIlllII.add((Object)llllllllllllllllIIlIIllIllIlllll);
        }
        llllllllllllllllIIlIIllIllIllIll.activeExtensions = llllllllllllllllIIlIIllIllIlllII.build();
    }

    public MixinTransformer getTransformer() {
        Extensions llllllllllllllllIIlIIllIlllllIII;
        return llllllllllllllllIIlIIllIlllllIII.transformer;
    }

    public void add(IExtension llllllllllllllllIIlIIllIllllIIIl) {
        Extensions llllllllllllllllIIlIIllIllllIlII;
        llllllllllllllllIIlIIllIllllIlII.extensions.add(llllllllllllllllIIlIIllIllllIIIl);
        llllllllllllllllIIlIIllIllllIlII.extensionMap.put(llllllllllllllllIIlIIllIllllIIIl.getClass(), llllllllllllllllIIlIIllIllllIIIl);
    }

    public void postApply(ITargetClassContext llllllllllllllllIIlIIllIllIIIlIl) {
        Extensions llllllllllllllllIIlIIllIllIIIlII;
        for (IExtension llllllllllllllllIIlIIllIllIIIlll : llllllllllllllllIIlIIllIllIIIlII.activeExtensions) {
            llllllllllllllllIIlIIllIllIIIlll.postApply(llllllllllllllllIIlIIllIllIIIlIl);
        }
    }

    public List<IExtension> getExtensions() {
        Extensions llllllllllllllllIIlIIllIlllIllll;
        return Collections.unmodifiableList(llllllllllllllllIIlIIllIlllIllll.extensions);
    }

    public <T extends IExtension> T getExtension(Class<? extends IExtension> llllllllllllllllIIlIIllIlllIIlIl) {
        Extensions llllllllllllllllIIlIIllIlllIIllI;
        return (T)Extensions.lookup(llllllllllllllllIIlIIllIlllIIlIl, llllllllllllllllIIlIIllIlllIIllI.extensionMap, llllllllllllllllIIlIIllIlllIIllI.extensions);
    }

    public void preApply(ITargetClassContext llllllllllllllllIIlIIllIllIIlllI) {
        Extensions llllllllllllllllIIlIIllIllIIllll;
        for (IExtension llllllllllllllllIIlIIllIllIlIIlI : llllllllllllllllIIlIIllIllIIllll.activeExtensions) {
            llllllllllllllllIIlIIllIllIlIIlI.preApply(llllllllllllllllIIlIIllIllIIlllI);
        }
    }

    public List<IExtension> getActiveExtensions() {
        Extensions llllllllllllllllIIlIIllIlllIllII;
        return llllllllllllllllIIlIIllIlllIllII.activeExtensions;
    }

    private static <T> T lookup(Class<? extends T> llllllllllllllllIIlIIllIlIIlIIlI, Map<Class<? extends T>, T> llllllllllllllllIIlIIllIlIIlIlIl, List<T> llllllllllllllllIIlIIllIlIIlIlII) {
        T llllllllllllllllIIlIIllIlIIlIIll = llllllllllllllllIIlIIllIlIIlIlIl.get(llllllllllllllllIIlIIllIlIIlIIlI);
        if (llllllllllllllllIIlIIllIlIIlIIll == null) {
            for (T llllllllllllllllIIlIIllIlIIlIlll : llllllllllllllllIIlIIllIlIIlIlII) {
                if (!llllllllllllllllIIlIIllIlIIlIIlI.isAssignableFrom(llllllllllllllllIIlIIllIlIIlIlll.getClass())) continue;
                llllllllllllllllIIlIIllIlIIlIIll = llllllllllllllllIIlIIllIlIIlIlll;
                break;
            }
            if (llllllllllllllllIIlIIllIlIIlIIll == null) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Extension for <").append(llllllllllllllllIIlIIllIlIIlIIlI.getName()).append("> could not be found")));
            }
            llllllllllllllllIIlIIllIlIIlIlIl.put(llllllllllllllllIIlIIllIlIIlIIlI, llllllllllllllllIIlIIllIlIIlIIll);
        }
        return llllllllllllllllIIlIIllIlIIlIIll;
    }

    public void export(MixinEnvironment llllllllllllllllIIlIIllIlIllIlll, String llllllllllllllllIIlIIllIlIllIIIl, boolean llllllllllllllllIIlIIllIlIllIlIl, byte[] llllllllllllllllIIlIIllIlIllIlII) {
        Extensions llllllllllllllllIIlIIllIlIllIIll;
        for (IExtension llllllllllllllllIIlIIllIlIlllIIl : llllllllllllllllIIlIIllIlIllIIll.activeExtensions) {
            llllllllllllllllIIlIIllIlIlllIIl.export(llllllllllllllllIIlIIllIlIllIlll, llllllllllllllllIIlIIllIlIllIIIl, llllllllllllllllIIlIIllIlIllIlIl, llllllllllllllllIIlIIllIlIllIlII);
        }
    }
}

