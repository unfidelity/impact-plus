/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

public abstract class ObfuscationUtil {
    private ObfuscationUtil() {
        ObfuscationUtil lllllllllllllllIllIllIIllIIIIlIl;
    }

    public static String unmapDescriptor(String lllllllllllllllIllIllIIlIllllIll, IClassRemapper lllllllllllllllIllIllIIlIllllIlI) {
        return ObfuscationUtil.remapDescriptor(lllllllllllllllIllIllIIlIllllIll, lllllllllllllllIllIllIIlIllllIlI, true);
    }

    public static String mapDescriptor(String lllllllllllllllIllIllIIlIlllllll, IClassRemapper lllllllllllllllIllIllIIlIllllllI) {
        return ObfuscationUtil.remapDescriptor(lllllllllllllllIllIllIIlIlllllll, lllllllllllllllIllIllIIlIllllllI, false);
    }

    private static String remapDescriptor(String lllllllllllllllIllIllIIlIllIlllI, IClassRemapper lllllllllllllllIllIllIIlIllIllIl, boolean lllllllllllllllIllIllIIlIllIIlll) {
        StringBuilder lllllllllllllllIllIllIIlIllIlIll = new StringBuilder();
        StringBuilder lllllllllllllllIllIllIIlIllIlIlI = null;
        for (int lllllllllllllllIllIllIIlIllIllll = 0; lllllllllllllllIllIllIIlIllIllll < lllllllllllllllIllIllIIlIllIlllI.length(); ++lllllllllllllllIllIllIIlIllIllll) {
            char lllllllllllllllIllIllIIlIlllIIII = lllllllllllllllIllIllIIlIllIlllI.charAt(lllllllllllllllIllIllIIlIllIllll);
            if (lllllllllllllllIllIllIIlIllIlIlI != null) {
                if (lllllllllllllllIllIllIIlIlllIIII == ';') {
                    lllllllllllllllIllIllIIlIllIlIll.append('L').append(ObfuscationUtil.remap(String.valueOf(lllllllllllllllIllIllIIlIllIlIlI), lllllllllllllllIllIllIIlIllIllIl, lllllllllllllllIllIllIIlIllIIlll)).append(';');
                    lllllllllllllllIllIllIIlIllIlIlI = null;
                    continue;
                }
                lllllllllllllllIllIllIIlIllIlIlI.append(lllllllllllllllIllIllIIlIlllIIII);
                continue;
            }
            if (lllllllllllllllIllIllIIlIlllIIII == 'L') {
                lllllllllllllllIllIllIIlIllIlIlI = new StringBuilder();
                continue;
            }
            lllllllllllllllIllIllIIlIllIlIll.append(lllllllllllllllIllIllIIlIlllIIII);
        }
        if (lllllllllllllllIllIllIIlIllIlIlI != null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor '").append(lllllllllllllllIllIllIIlIllIlllI).append("', missing ';'")));
        }
        return String.valueOf(lllllllllllllllIllIllIIlIllIlIll);
    }

    private static Object remap(String lllllllllllllllIllIllIIlIlIllIlI, IClassRemapper lllllllllllllllIllIllIIlIlIlllIl, boolean lllllllllllllllIllIllIIlIlIlllII) {
        String lllllllllllllllIllIllIIlIlIllIll = lllllllllllllllIllIllIIlIlIlllII ? lllllllllllllllIllIllIIlIlIlllIl.unmap(lllllllllllllllIllIllIIlIlIllIlI) : lllllllllllllllIllIllIIlIlIlllIl.map(lllllllllllllllIllIllIIlIlIllIlI);
        return lllllllllllllllIllIllIIlIlIllIll != null ? lllllllllllllllIllIllIIlIlIllIll : lllllllllllllllIllIllIIlIlIllIlI;
    }

    public static interface IClassRemapper {
        public String map(String var1);

        public String unmap(String var1);
    }
}

