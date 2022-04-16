/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

public class FastTrig {
    private static double reduceSinAngle(double lllllllllllllllllllIIIIIlIlllIll) {
        double lllllllllllllllllllIIIIIlIllllII = lllllllllllllllllllIIIIIlIlllIll;
        if (Math.abs(lllllllllllllllllllIIIIIlIlllIll %= Math.PI * 2) > Math.PI) {
            lllllllllllllllllllIIIIIlIlllIll -= Math.PI * 2;
        }
        if (Math.abs(lllllllllllllllllllIIIIIlIlllIll) > 1.5707963267948966) {
            lllllllllllllllllllIIIIIlIlllIll = Math.PI - lllllllllllllllllllIIIIIlIlllIll;
        }
        return lllllllllllllllllllIIIIIlIlllIll;
    }

    public static double cos(double lllllllllllllllllllIIIIIlIllIlII) {
        return FastTrig.sin(lllllllllllllllllllIIIIIlIllIlII + 1.5707963267948966);
    }

    public FastTrig() {
        FastTrig lllllllllllllllllllIIIIIllIIIIII;
    }

    public static double sin(double lllllllllllllllllllIIIIIlIlllIII) {
        if (Math.abs(lllllllllllllllllllIIIIIlIlllIII = FastTrig.reduceSinAngle(lllllllllllllllllllIIIIIlIlllIII)) <= 0.7853981633974483) {
            return Math.sin(lllllllllllllllllllIIIIIlIlllIII);
        }
        return Math.cos(1.5707963267948966 - lllllllllllllllllllIIIIIlIlllIII);
    }
}

