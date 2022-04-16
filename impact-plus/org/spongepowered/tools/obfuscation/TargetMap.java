/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.io.Files
 */
package org.spongepowered.tools.obfuscation;

import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.TypeElement;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeReference;

public final class TargetMap
extends HashMap<TypeReference, Set<TypeReference>> {
    private static final /* synthetic */ long serialVersionUID = 1L;
    private final /* synthetic */ String sessionId;

    public Collection<TypeReference> getMixinsTargeting(TypeReference lllllllllllllllIllllIlIIlllllIII) {
        TargetMap lllllllllllllllIllllIlIIlllllIlI;
        return Collections.unmodifiableCollection(lllllllllllllllIllllIlIIlllllIlI.getMixinsFor(lllllllllllllllIllllIlIIlllllIII));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static TargetMap read(File lllllllllllllllIllllIlIIlIlIllII) {
        ObjectInputStream lllllllllllllllIllllIlIIlIlIlIll = null;
        FileInputStream lllllllllllllllIllllIlIIlIlIlIlI = null;
        try {
            lllllllllllllllIllllIlIIlIlIlIlI = new FileInputStream(lllllllllllllllIllllIlIIlIlIllII);
            lllllllllllllllIllllIlIIlIlIlIll = new ObjectInputStream(lllllllllllllllIllllIlIIlIlIlIlI);
            TargetMap lllllllllllllllIllllIlIIlIlIIllI = (TargetMap)lllllllllllllllIllllIlIIlIlIlIll.readObject();
            return lllllllllllllllIllllIlIIlIlIIllI;
        }
        catch (Exception lllllllllllllllIllllIlIIlIlIllll) {
            lllllllllllllllIllllIlIIlIlIllll.printStackTrace();
        }
        finally {
            if (lllllllllllllllIllllIlIIlIlIlIll != null) {
                try {
                    lllllllllllllllIllllIlIIlIlIlIll.close();
                }
                catch (IOException lllllllllllllllIllllIlIIlIlIlllI) {
                    lllllllllllllllIllllIlIIlIlIlllI.printStackTrace();
                }
            }
        }
        return null;
    }

    private TargetMap() {
        lllllllllllllllIllllIlIlIlIlIIlI(String.valueOf(System.currentTimeMillis()));
        TargetMap lllllllllllllllIllllIlIlIlIlIIlI;
    }

    public void addMixin(TypeReference lllllllllllllllIllllIlIlIIIlllIl, TypeReference lllllllllllllllIllllIlIlIIIlllII) {
        TargetMap lllllllllllllllIllllIlIlIIIllIlI;
        Set<TypeReference> lllllllllllllllIllllIlIlIIIllIll = lllllllllllllllIllllIlIlIIIllIlI.getMixinsFor(lllllllllllllllIllllIlIlIIIlllIl);
        lllllllllllllllIllllIlIlIIIllIll.add(lllllllllllllllIllllIlIlIIIlllII);
    }

    public void readImports(File lllllllllllllllIllllIlIIllIllllI) throws IOException {
        if (!lllllllllllllllIllllIlIIllIllllI.isFile()) {
            return;
        }
        for (String lllllllllllllllIllllIlIIlllIIIII : Files.readLines((File)lllllllllllllllIllllIlIIllIllllI, (Charset)Charset.defaultCharset())) {
            TargetMap lllllllllllllllIllllIlIIllIlllll;
            String[] lllllllllllllllIllllIlIIlllIIIIl = lllllllllllllllIllllIlIIlllIIIII.split("\t");
            if (lllllllllllllllIllllIlIIlllIIIIl.length != 2) continue;
            lllllllllllllllIllllIlIIllIlllll.addMixin(lllllllllllllllIllllIlIIlllIIIIl[1], lllllllllllllllIllllIlIIlllIIIIl[0]);
        }
    }

    public void registerTargets(List<TypeHandle> lllllllllllllllIllllIlIlIIlllIII, TypeHandle lllllllllllllllIllllIlIlIIllIlll) {
        for (TypeHandle lllllllllllllllIllllIlIlIIllllIl : lllllllllllllllIllllIlIlIIlllIII) {
            TargetMap lllllllllllllllIllllIlIlIIlllIIl;
            lllllllllllllllIllllIlIlIIlllIIl.addMixin(lllllllllllllllIllllIlIlIIllllIl, lllllllllllllllIllllIlIlIIllIlll);
        }
    }

    private TargetMap(String lllllllllllllllIllllIlIlIlIIllII) {
        TargetMap lllllllllllllllIllllIlIlIlIIllIl;
        lllllllllllllllIllllIlIlIlIIllIl.sessionId = lllllllllllllllIllllIlIlIlIIllII;
    }

    public String getSessionId() {
        TargetMap lllllllllllllllIllllIlIlIlIIlIIl;
        return lllllllllllllllIllllIlIlIlIIlIIl.sessionId;
    }

    public static TargetMap create(String lllllllllllllllIllllIlIIlIIlllIl) {
        TargetMap lllllllllllllllIllllIlIIlIIlllll;
        File lllllllllllllllIllllIlIIlIIllllI;
        if (lllllllllllllllIllllIlIIlIIlllIl != null && (lllllllllllllllIllllIlIIlIIllllI = TargetMap.getSessionFile(lllllllllllllllIllllIlIIlIIlllIl)).exists() && (lllllllllllllllIllllIlIIlIIlllll = TargetMap.read(lllllllllllllllIllllIlIIlIIllllI)) != null) {
            return lllllllllllllllIllllIlIIlIIlllll;
        }
        return new TargetMap();
    }

    private static File getSessionFile(String lllllllllllllllIllllIlIIlIIlIlIl) {
        File lllllllllllllllIllllIlIIlIIlIllI = new File(System.getProperty("java.io.tmpdir"));
        return new File(lllllllllllllllIllllIlIIlIIlIllI, String.format("mixin-targetdb-%s.tmp", lllllllllllllllIllllIlIIlIIlIlIl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(boolean lllllllllllllllIllllIlIIlIllllIl) {
        ObjectOutputStream lllllllllllllllIllllIlIIllIIIIII = null;
        FileOutputStream lllllllllllllllIllllIlIIlIllllll = null;
        try {
            TargetMap lllllllllllllllIllllIlIIllIIIIlI;
            File lllllllllllllllIllllIlIIllIIlIII = TargetMap.getSessionFile(lllllllllllllllIllllIlIIllIIIIlI.sessionId);
            if (lllllllllllllllIllllIlIIlIllllIl) {
                lllllllllllllllIllllIlIIllIIlIII.deleteOnExit();
            }
            lllllllllllllllIllllIlIIlIllllll = new FileOutputStream(lllllllllllllllIllllIlIIllIIlIII, true);
            lllllllllllllllIllllIlIIllIIIIII = new ObjectOutputStream(lllllllllllllllIllllIlIIlIllllll);
            lllllllllllllllIllllIlIIllIIIIII.writeObject(lllllllllllllllIllllIlIIllIIIIlI);
        }
        catch (Exception lllllllllllllllIllllIlIIllIIIlIl) {
            lllllllllllllllIllllIlIIllIIIlIl.printStackTrace();
        }
        finally {
            if (lllllllllllllllIllllIlIIllIIIIII != null) {
                try {
                    lllllllllllllllIllllIlIIllIIIIII.close();
                }
                catch (IOException lllllllllllllllIllllIlIIllIIIlII) {
                    lllllllllllllllIllllIlIIllIIIlII.printStackTrace();
                }
            }
        }
    }

    public Collection<TypeReference> getMixinsTargeting(TypeHandle lllllllllllllllIllllIlIlIIIIIIII) {
        TargetMap lllllllllllllllIllllIlIlIIIIIIlI;
        return lllllllllllllllIllllIlIlIIIIIIlI.getMixinsTargeting(lllllllllllllllIllllIlIlIIIIIIII.getReference());
    }

    public void addMixin(TypeHandle lllllllllllllllIllllIlIlIIlIllIl, TypeHandle lllllllllllllllIllllIlIlIIlIllII) {
        TargetMap lllllllllllllllIllllIlIlIIlIlllI;
        lllllllllllllllIllllIlIlIIlIlllI.addMixin(lllllllllllllllIllllIlIlIIlIllIl.getReference(), lllllllllllllllIllllIlIlIIlIllII.getReference());
    }

    private Set<TypeReference> getMixinsFor(TypeReference lllllllllllllllIllllIlIIlllIllIl) {
        TargetMap lllllllllllllllIllllIlIIlllIlIll;
        HashSet lllllllllllllllIllllIlIIlllIllII = (HashSet)lllllllllllllllIllllIlIIlllIlIll.get(lllllllllllllllIllllIlIIlllIllIl);
        if (lllllllllllllllIllllIlIIlllIllII == null) {
            lllllllllllllllIllllIlIIlllIllII = new HashSet();
            lllllllllllllllIllllIlIIlllIlIll.put(lllllllllllllllIllllIlIIlllIllIl, lllllllllllllllIllllIlIIlllIllII);
        }
        return lllllllllllllllIllllIlIIlllIllII;
    }

    public Collection<TypeReference> getMixinsTargeting(TypeElement lllllllllllllllIllllIlIlIIIIlIll) {
        TargetMap lllllllllllllllIllllIlIlIIIIlllI;
        return lllllllllllllllIllllIlIlIIIIlllI.getMixinsTargeting(new TypeHandle(lllllllllllllllIllllIlIlIIIIlIll));
    }

    public void registerTargets(AnnotatedMixin lllllllllllllllIllllIlIlIlIIIIll) {
        TargetMap lllllllllllllllIllllIlIlIlIIIlII;
        lllllllllllllllIllllIlIlIlIIIlII.registerTargets(lllllllllllllllIllllIlIlIlIIIIll.getTargets(), lllllllllllllllIllllIlIlIlIIIIll.getHandle());
    }

    public void addMixin(String lllllllllllllllIllllIlIlIIlIIlII, String lllllllllllllllIllllIlIlIIlIIIll) {
        TargetMap lllllllllllllllIllllIlIlIIlIlIII;
        lllllllllllllllIllllIlIlIIlIlIII.addMixin(new TypeReference(lllllllllllllllIllllIlIlIIlIIlII), new TypeReference(lllllllllllllllIllllIlIlIIlIIIll));
    }
}

