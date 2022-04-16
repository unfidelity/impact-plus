/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VersionNumber
implements Comparable<VersionNumber>,
Serializable {
    private static final /* synthetic */ Pattern PATTERN;
    private final /* synthetic */ long value;
    private static final /* synthetic */ long serialVersionUID = 1L;
    private final /* synthetic */ String suffix;
    public static final /* synthetic */ VersionNumber NONE;

    public boolean equals(Object lIIlIlIlIIIIlI) {
        VersionNumber lIIlIlIlIIIIll;
        if (!(lIIlIlIlIIIIlI instanceof VersionNumber)) {
            return false;
        }
        return ((VersionNumber)lIIlIlIlIIIIlI).value == lIIlIlIlIIIIll.value;
    }

    private static short[] unpack(long lIIlIlIIllIlII) {
        return new short[]{(short)(lIIlIlIIllIlII >> 48), (short)(lIIlIlIIllIlII >> 32 & 0x7FFFL), (short)(lIIlIlIIllIlII >> 16 & 0x7FFFL), (short)(lIIlIlIIllIlII & 0x7FFFL)};
    }

    @Override
    public int compareTo(VersionNumber lIIlIlIlIlIIII) {
        VersionNumber lIIlIlIlIIlllI;
        if (lIIlIlIlIlIIII == null) {
            return 1;
        }
        long lIIlIlIlIIllll = lIIlIlIlIIlllI.value - lIIlIlIlIlIIII.value;
        return lIIlIlIlIIllll > 0L ? 1 : (lIIlIlIlIIllll < 0L ? -1 : 0);
    }

    public static VersionNumber parse(String lIIlIlIIlIIIII, String lIIlIlIIIlllll) {
        return VersionNumber.parse(lIIlIlIIlIIIII, VersionNumber.parse(lIIlIlIIIlllll));
    }

    static {
        NONE = new VersionNumber();
        PATTERN = Pattern.compile("^(\\d{1,5})(?:\\.(\\d{1,5})(?:\\.(\\d{1,5})(?:\\.(\\d{1,5}))?)?)?(-[a-zA-Z0-9_\\-]+)?$");
    }

    public static VersionNumber parse(String lIIlIlIIlIIlII) {
        return VersionNumber.parse(lIIlIlIIlIIlII, NONE);
    }

    public int hashCode() {
        VersionNumber lIIlIlIIlllIlI;
        return (int)(lIIlIlIIlllIlI.value >> 32) ^ (int)(lIIlIlIIlllIlI.value & 0xFFFFFFFFL);
    }

    private VersionNumber(short[] lIIlIllIllIIlI, String lIIlIllIllIIIl) {
        VersionNumber lIIlIllIllIIll;
        lIIlIllIllIIll.value = VersionNumber.pack(lIIlIllIllIIlI);
        lIIlIllIllIIll.suffix = lIIlIllIllIIIl != null ? lIIlIllIllIIIl : "";
    }

    private static VersionNumber parse(String lIIlIIllllIlll, VersionNumber lIIlIIllllIlIl) {
        if (lIIlIIllllIlll == null) {
            return lIIlIIllllIlIl;
        }
        Matcher lIIlIIllllIIll = PATTERN.matcher(lIIlIIllllIlll);
        if (!lIIlIIllllIIll.matches()) {
            return lIIlIIllllIlIl;
        }
        short[] lIIlIIllllIIlI = new short[4];
        for (int lIIlIIlllllIII = 0; lIIlIIlllllIII < 4; ++lIIlIIlllllIII) {
            String lIIlIIlllllIlI = lIIlIIllllIIll.group(lIIlIIlllllIII + 1);
            if (lIIlIIlllllIlI == null) continue;
            int lIIlIIllllllII = Integer.parseInt(lIIlIIlllllIlI);
            if (lIIlIIllllllII > Short.MAX_VALUE) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Version parts cannot exceed 32767, found ").append(lIIlIIllllllII)));
            }
            lIIlIIllllIIlI[lIIlIIlllllIII] = (short)lIIlIIllllllII;
        }
        return new VersionNumber(lIIlIIllllIIlI, lIIlIIllllIIll.group(5));
    }

    private static long pack(short ... lIIlIlIIllIllI) {
        return (long)lIIlIlIIllIllI[0] << 48 | (long)lIIlIlIIllIllI[1] << 32 | (long)(lIIlIlIIllIllI[2] << 16) | (long)lIIlIlIIllIllI[3];
    }

    private VersionNumber(short lIIlIlIllllIIl, short lIIlIllIIIIIIl, short lIIlIlIlllIlll, short lIIlIlIlllllIl, String lIIlIlIlllIlIl) {
        VersionNumber lIIlIllIIIIllI;
        lIIlIllIIIIllI.value = VersionNumber.pack(lIIlIlIllllIIl, lIIlIllIIIIIIl, lIIlIlIlllIlll, lIIlIlIlllllIl);
        lIIlIllIIIIllI.suffix = lIIlIlIlllIlIl != null ? lIIlIlIlllIlIl : "";
    }

    public String toString() {
        VersionNumber lIIlIlIllIIIll;
        short[] lIIlIlIllIIlII = VersionNumber.unpack(lIIlIlIllIIIll.value);
        return String.format("%d.%d%3$s%4$s%5$s", lIIlIlIllIIlII[0], lIIlIlIllIIlII[1], (lIIlIlIllIIIll.value & Integer.MAX_VALUE) > 0L ? String.format(".%d", lIIlIlIllIIlII[2]) : "", (lIIlIlIllIIIll.value & 0x7FFFL) > 0L ? String.format(".%d", lIIlIlIllIIlII[3]) : "", lIIlIlIllIIIll.suffix);
    }

    private VersionNumber() {
        VersionNumber lIIlIlllIIIIlI;
        lIIlIlllIIIIlI.value = 0L;
        lIIlIlllIIIIlI.suffix = "";
    }

    private VersionNumber(short lIIlIllIlIIlll, short lIIlIllIlIIllI, short lIIlIllIlIIIII, short lIIlIllIlIIlII) {
        lIIlIllIlIlIII(lIIlIllIlIIlll, lIIlIllIlIIllI, lIIlIllIlIIIII, lIIlIllIlIIlII, null);
        VersionNumber lIIlIllIlIlIII;
    }

    private VersionNumber(short[] lIIlIllIllIlll) {
        lIIlIllIlllIII(lIIlIllIllIlll, null);
        VersionNumber lIIlIllIlllIII;
    }
}

