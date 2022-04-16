/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.LaunchClassLoader
 */
package org.spongepowered.asm.service.mojang;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import net.minecraft.launchwrapper.LaunchClassLoader;

final class LaunchClassLoaderUtil {
    private static final /* synthetic */ String TRANSFORMER_EXCEPTIONS_FIELD;
    private final /* synthetic */ Set<String> transformerExceptions;
    private static final /* synthetic */ String INVALID_CLASSES_FIELD;
    private final /* synthetic */ Set<String> classLoaderExceptions;
    private final /* synthetic */ Map<String, Class<?>> cachedClasses;
    private static final /* synthetic */ String CLASS_LOADER_EXCEPTIONS_FIELD;
    private final /* synthetic */ LaunchClassLoader classLoader;
    private final /* synthetic */ Set<String> invalidClasses;
    private static final /* synthetic */ String CACHED_CLASSES_FIELD;

    void registerInvalidClass(String lIlIllIIIllI) {
        LaunchClassLoaderUtil lIlIllIIlIIl;
        if (lIlIllIIlIIl.invalidClasses != null) {
            lIlIllIIlIIl.invalidClasses.add(lIlIllIIIllI);
        }
    }

    boolean isClassExcluded(String lIlIllIlIIlI, String lIlIllIlIIIl) {
        LaunchClassLoaderUtil lIlIllIlIIll;
        for (String lIlIllIlIlIl : lIlIllIlIIll.getClassLoaderExceptions()) {
            if (!lIlIllIlIIIl.startsWith(lIlIllIlIlIl) && !lIlIllIlIIlI.startsWith(lIlIllIlIlIl)) continue;
            return true;
        }
        for (String lIlIllIlIlII : lIlIllIlIIll.getTransformerExceptions()) {
            if (!lIlIllIlIIIl.startsWith(lIlIllIlIlII) && !lIlIllIlIIlI.startsWith(lIlIllIlIlII)) continue;
            return true;
        }
        return false;
    }

    static {
        INVALID_CLASSES_FIELD = "invalidClasses";
        TRANSFORMER_EXCEPTIONS_FIELD = "transformerExceptions";
        CACHED_CLASSES_FIELD = "cachedClasses";
        CLASS_LOADER_EXCEPTIONS_FIELD = "classLoaderExceptions";
    }

    private static <T> T getField(LaunchClassLoader lIlIlIlllIlI, String lIlIlIllIlll) {
        try {
            Field lIlIlIllllII = LaunchClassLoader.class.getDeclaredField(lIlIlIllIlll);
            lIlIlIllllII.setAccessible(true);
            return (T)lIlIlIllllII.get(lIlIlIlllIlI);
        }
        catch (Exception lIlIlIlllIll) {
            lIlIlIlllIll.printStackTrace();
            return null;
        }
    }

    Set<String> getTransformerExceptions() {
        LaunchClassLoaderUtil lIlIllIIIIII;
        if (lIlIllIIIIII.transformerExceptions != null) {
            return lIlIllIIIIII.transformerExceptions;
        }
        return Collections.emptySet();
    }

    boolean isClassLoaded(String lIlIlllIlIIl) {
        LaunchClassLoaderUtil lIlIlllIlIlI;
        return lIlIlllIlIlI.cachedClasses.containsKey(lIlIlllIlIIl);
    }

    LaunchClassLoaderUtil(LaunchClassLoader lIlIllllIIlI) {
        LaunchClassLoaderUtil lIlIllllIIll;
        lIlIllllIIll.classLoader = lIlIllllIIlI;
        lIlIllllIIll.cachedClasses = (Map)LaunchClassLoaderUtil.getField(lIlIllllIIlI, "cachedClasses");
        lIlIllllIIll.invalidClasses = (Set)LaunchClassLoaderUtil.getField(lIlIllllIIlI, "invalidClasses");
        lIlIllllIIll.classLoaderExceptions = (Set)LaunchClassLoaderUtil.getField(lIlIllllIIlI, "classLoaderExceptions");
        lIlIllllIIll.transformerExceptions = (Set)LaunchClassLoaderUtil.getField(lIlIllllIIlI, "transformerExceptions");
    }

    LaunchClassLoader getClassLoader() {
        LaunchClassLoaderUtil lIlIllllIIII;
        return lIlIllllIIII.classLoader;
    }

    Set<String> getClassLoaderExceptions() {
        LaunchClassLoaderUtil lIlIllIIIIll;
        if (lIlIllIIIIll.classLoaderExceptions != null) {
            return lIlIllIIIIll.classLoaderExceptions;
        }
        return Collections.emptySet();
    }
}

