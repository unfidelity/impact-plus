/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 */
package org.spongepowered.tools.obfuscation;

import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IOptionProvider;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

public final class ObfuscationType {
    private static final /* synthetic */ Map<String, ObfuscationType> types;
    private final /* synthetic */ ObfuscationTypeDescriptor descriptor;
    private final /* synthetic */ IMixinAnnotationProcessor ap;
    private final /* synthetic */ String key;
    private final /* synthetic */ IOptionProvider options;

    public List<String> getInputFileNames() {
        String llIlllIlIlIIlII;
        ObfuscationType llIlllIlIlIIlll;
        ImmutableList.Builder llIlllIlIlIIllI = ImmutableList.builder();
        String llIlllIlIlIIlIl = llIlllIlIlIIlll.options.getOption(llIlllIlIlIIlll.descriptor.getInputFileOption());
        if (llIlllIlIlIIlIl != null) {
            llIlllIlIlIIllI.add((Object)llIlllIlIlIIlIl);
        }
        if ((llIlllIlIlIIlII = llIlllIlIlIIlll.options.getOption(llIlllIlIlIIlll.descriptor.getExtraInputFilesOption())) != null) {
            for (String llIlllIlIlIlIII : llIlllIlIlIIlII.split(";")) {
                llIlllIlIlIIllI.add((Object)llIlllIlIlIlIII.trim());
            }
        }
        return llIlllIlIlIIllI.build();
    }

    public final ObfuscationEnvironment createEnvironment() {
        try {
            ObfuscationType llIlllIllllIlII;
            Class<? extends ObfuscationEnvironment> llIlllIllllIlll = llIlllIllllIlII.descriptor.getEnvironmentType();
            Constructor<? extends ObfuscationEnvironment> llIlllIllllIllI = llIlllIllllIlll.getDeclaredConstructor(ObfuscationType.class);
            llIlllIllllIllI.setAccessible(true);
            return llIlllIllllIllI.newInstance(llIlllIllllIlII);
        }
        catch (Exception llIlllIllllIlIl) {
            throw new RuntimeException(llIlllIllllIlIl);
        }
    }

    public static ObfuscationType create(ObfuscationTypeDescriptor llIlllIlIIIlIII, IMixinAnnotationProcessor llIlllIlIIIlllI) {
        String llIlllIlIIIllII = llIlllIlIIIlIII.getKey();
        if (types.containsKey(llIlllIlIIIllII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Obfuscation type with key ").append(llIlllIlIIIllII).append(" was already registered")));
        }
        ObfuscationType llIlllIlIIIlIlI = new ObfuscationType(llIlllIlIIIlIII, llIlllIlIIIlllI);
        types.put(llIlllIlIIIllII, llIlllIlIIIlIlI);
        return llIlllIlIIIlIlI;
    }

    private ObfuscationType(ObfuscationTypeDescriptor llIlllIllllllll, IMixinAnnotationProcessor llIlllIlllllIll) {
        ObfuscationType llIllllIIIIIIII;
        llIllllIIIIIIII.key = llIlllIllllllll.getKey();
        llIllllIIIIIIII.descriptor = llIlllIllllllll;
        llIllllIIIIIIII.ap = llIlllIlllllIll;
        llIllllIIIIIIII.options = llIlllIlllllIll;
    }

    public boolean isDefault() {
        ObfuscationType llIlllIllIlIIII;
        String llIlllIllIIllll = llIlllIllIlIIII.options.getOption("defaultObfuscationEnv");
        return llIlllIllIIllll == null && llIlllIllIlIIII.key.equals("searge") || llIlllIllIIllll != null && llIlllIllIlIIII.key.equals(llIlllIllIIllll.toLowerCase());
    }

    public static Iterable<ObfuscationType> types() {
        return types.values();
    }

    public IMixinAnnotationProcessor getAnnotationProcessor() {
        ObfuscationType llIlllIllIlIIll;
        return llIlllIllIlIIll.ap;
    }

    public static ObfuscationType get(String llIlllIIlllllII) {
        ObfuscationType llIlllIIlllllIl = types.get(llIlllIIlllllII);
        if (llIlllIIlllllIl == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Obfuscation type with key ").append(llIlllIIlllllII).append(" was not registered")));
        }
        return llIlllIIlllllIl;
    }

    static {
        types = new LinkedHashMap<String, ObfuscationType>();
    }

    public String getOutputFileName() {
        ObfuscationType llIlllIlIIllIlI;
        return llIlllIlIIllIlI.options.getOption(llIlllIlIIllIlI.descriptor.getOutputFileOption());
    }

    public String getKey() {
        ObfuscationType llIlllIllIllIIl;
        return llIlllIllIllIIl.key;
    }

    public String toString() {
        ObfuscationType llIlllIlllIIlll;
        return llIlllIlllIIlll.key;
    }

    public ObfuscationTypeDescriptor getConfig() {
        ObfuscationType llIlllIllIlIllI;
        return llIlllIllIlIllI.descriptor;
    }

    public boolean isSupported() {
        ObfuscationType llIlllIllIIlIlI;
        return llIlllIllIIlIlI.getInputFileNames().size() > 0;
    }
}

