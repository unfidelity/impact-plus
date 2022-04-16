/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.launch.platform;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

final class MainAttributes {
    protected final /* synthetic */ Attributes attributes;
    private static final /* synthetic */ Map<URI, MainAttributes> instances;

    static {
        instances = new HashMap<URI, MainAttributes>();
    }

    private MainAttributes(File llllllllllllllllIllIIllIlIIllllI) {
        MainAttributes llllllllllllllllIllIIllIlIIlllll;
        llllllllllllllllIllIIllIlIIlllll.attributes = MainAttributes.getAttributes(llllllllllllllllIllIIllIlIIllllI);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Attributes getAttributes(File llllllllllllllllIllIIllIlIIIllIl) {
        if (llllllllllllllllIllIIllIlIIIllIl == null) {
            return null;
        }
        JarFile llllllllllllllllIllIIllIlIIIllII = null;
        try {
            llllllllllllllllIllIIllIlIIIllII = new JarFile(llllllllllllllllIllIIllIlIIIllIl);
            Manifest llllllllllllllllIllIIllIlIIIlllI = llllllllllllllllIllIIllIlIIIllII.getManifest();
            if (llllllllllllllllIllIIllIlIIIlllI != null) {
                Attributes llllllllllllllllIllIIllIlIIIlIII = llllllllllllllllIllIIllIlIIIlllI.getMainAttributes();
                return llllllllllllllllIllIIllIlIIIlIII;
            }
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                if (llllllllllllllllIllIIllIlIIIllII != null) {
                    llllllllllllllllIllIIllIlIIIllII.close();
                }
            }
            catch (IOException llllllllllllllllIllIIllIlIIIIlll) {}
        }
        return new Attributes();
    }

    public static MainAttributes of(URI llllllllllllllllIllIIllIIlllllll) {
        MainAttributes llllllllllllllllIllIIllIIllllllI = instances.get(llllllllllllllllIllIIllIIlllllll);
        if (llllllllllllllllIllIIllIIllllllI == null) {
            llllllllllllllllIllIIllIIllllllI = new MainAttributes(new File(llllllllllllllllIllIIllIIlllllll));
            instances.put(llllllllllllllllIllIIllIIlllllll, llllllllllllllllIllIIllIIllllllI);
        }
        return llllllllllllllllIllIIllIIllllllI;
    }

    private MainAttributes() {
        MainAttributes llllllllllllllllIllIIllIlIlIIIlI;
        llllllllllllllllIllIIllIlIlIIIlI.attributes = new Attributes();
    }

    public static MainAttributes of(File llllllllllllllllIllIIllIlIIIIIll) {
        return MainAttributes.of(llllllllllllllllIllIIllIlIIIIIll.toURI());
    }

    public final String get(String llllllllllllllllIllIIllIlIIlIllI) {
        MainAttributes llllllllllllllllIllIIllIlIIllIIl;
        if (llllllllllllllllIllIIllIlIIllIIl.attributes != null) {
            return llllllllllllllllIllIIllIlIIllIIl.attributes.getValue(llllllllllllllllIllIIllIlIIlIllI);
        }
        return null;
    }
}

