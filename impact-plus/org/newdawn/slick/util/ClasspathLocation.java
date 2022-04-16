/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.io.InputStream;
import java.net.URL;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.util.ResourceLocation;

public class ClasspathLocation
implements ResourceLocation {
    @Override
    public URL getResource(String llllllllllllllllIIlIIIlIlIllIlll) {
        String llllllllllllllllIIlIIIlIlIlllIIl = llllllllllllllllIIlIIIlIlIllIlll.replace('\\', '/');
        return ResourceLoader.class.getClassLoader().getResource(llllllllllllllllIIlIIIlIlIlllIIl);
    }

    public ClasspathLocation() {
        ClasspathLocation llllllllllllllllIIlIIIlIllIIIlII;
    }

    @Override
    public InputStream getResourceAsStream(String llllllllllllllllIIlIIIlIlIlIllIl) {
        String llllllllllllllllIIlIIIlIlIlIllII = llllllllllllllllIIlIIIlIlIlIllIl.replace('\\', '/');
        return ResourceLoader.class.getClassLoader().getResourceAsStream(llllllllllllllllIIlIIIlIlIlIllII);
    }
}

