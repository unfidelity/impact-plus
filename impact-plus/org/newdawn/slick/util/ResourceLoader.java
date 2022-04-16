/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.newdawn.slick.util.ClasspathLocation;
import org.newdawn.slick.util.FileSystemLocation;
import org.newdawn.slick.util.ResourceLocation;

public class ResourceLoader {
    private static /* synthetic */ ArrayList locations;

    public static void removeResourceLocation(ResourceLocation llIIIIIIIllllll) {
        locations.remove(llIIIIIIIllllll);
    }

    public static void removeAllResourceLocations() {
        locations.clear();
    }

    public static void addResourceLocation(ResourceLocation llIIIIIIlIIIIlI) {
        locations.add(llIIIIIIlIIIIlI);
    }

    static {
        locations = new ArrayList();
        locations.add(new ClasspathLocation());
        locations.add(new FileSystemLocation(new File(".")));
    }

    public static InputStream getResourceAsStream(String llIIIIIIIllIlIl) {
        ResourceLocation llIIIIIIIlllIIl;
        InputStream llIIIIIIIllIllI = null;
        for (int llIIIIIIIlllIII = 0; llIIIIIIIlllIII < locations.size() && (llIIIIIIIllIllI = (llIIIIIIIlllIIl = (ResourceLocation)locations.get(llIIIIIIIlllIII)).getResourceAsStream(llIIIIIIIllIlIl)) == null; ++llIIIIIIIlllIII) {
        }
        if (llIIIIIIIllIllI == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Resource not found: ").append(llIIIIIIIllIlIl)));
        }
        return new BufferedInputStream(llIIIIIIIllIllI);
    }

    public static URL getResource(String llIIIIIIIIlllll) {
        ResourceLocation llIIIIIIIlIIIIl;
        URL llIIIIIIIIllllI = null;
        for (int llIIIIIIIlIIIII = 0; llIIIIIIIlIIIII < locations.size() && (llIIIIIIIIllllI = (llIIIIIIIlIIIIl = (ResourceLocation)locations.get(llIIIIIIIlIIIII)).getResource(llIIIIIIIIlllll)) == null; ++llIIIIIIIlIIIII) {
        }
        if (llIIIIIIIIllllI == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Resource not found: ").append(llIIIIIIIIlllll)));
        }
        return llIIIIIIIIllllI;
    }

    public static boolean resourceExists(String llIIIIIIIlIlIIl) {
        URL llIIIIIIIlIlIlI = null;
        for (int llIIIIIIIlIllII = 0; llIIIIIIIlIllII < locations.size(); ++llIIIIIIIlIllII) {
            ResourceLocation llIIIIIIIlIllIl = (ResourceLocation)locations.get(llIIIIIIIlIllII);
            llIIIIIIIlIlIlI = llIIIIIIIlIllIl.getResource(llIIIIIIIlIlIIl);
            if (llIIIIIIIlIlIlI == null) continue;
            return true;
        }
        return false;
    }

    public ResourceLoader() {
        ResourceLoader llIIIIIIlIIIlIl;
    }
}

