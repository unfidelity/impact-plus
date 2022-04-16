/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.newdawn.slick.util.ResourceLocation;

public class FileSystemLocation
implements ResourceLocation {
    private /* synthetic */ File root;

    @Override
    public URL getResource(String llllllllllllllllIIllIIlllIlllIll) {
        try {
            FileSystemLocation llllllllllllllllIIllIIlllIlllIlI;
            File llllllllllllllllIIllIIlllIlllllI = new File(llllllllllllllllIIllIIlllIlllIlI.root, llllllllllllllllIIllIIlllIlllIll);
            if (!llllllllllllllllIIllIIlllIlllllI.exists()) {
                llllllllllllllllIIllIIlllIlllllI = new File(llllllllllllllllIIllIIlllIlllIll);
            }
            if (!llllllllllllllllIIllIIlllIlllllI.exists()) {
                return null;
            }
            return llllllllllllllllIIllIIlllIlllllI.toURI().toURL();
        }
        catch (IOException llllllllllllllllIIllIIlllIllllIl) {
            return null;
        }
    }

    @Override
    public InputStream getResourceAsStream(String llllllllllllllllIIllIIlllIllIIIl) {
        try {
            FileSystemLocation llllllllllllllllIIllIIlllIllIIlI;
            File llllllllllllllllIIllIIlllIllIlII = new File(llllllllllllllllIIllIIlllIllIIlI.root, llllllllllllllllIIllIIlllIllIIIl);
            if (!llllllllllllllllIIllIIlllIllIlII.exists()) {
                llllllllllllllllIIllIIlllIllIlII = new File(llllllllllllllllIIllIIlllIllIIIl);
            }
            return new FileInputStream(llllllllllllllllIIllIIlllIllIlII);
        }
        catch (IOException llllllllllllllllIIllIIlllIllIIll) {
            return null;
        }
    }

    public FileSystemLocation(File llllllllllllllllIIllIIllllIIIIlI) {
        FileSystemLocation llllllllllllllllIIllIIllllIIIlIl;
        llllllllllllllllIIllIIllllIIIlIl.root = llllllllllllllllIIllIIllllIIIIlI;
    }
}

