/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class JavaVersion {
    private static /* synthetic */ double current;

    public static double current() {
        if (current == 0.0) {
            current = JavaVersion.resolveCurrentVersion();
        }
        return current;
    }

    private JavaVersion() {
        JavaVersion llllllllllllllllIIIIllIllIlIlIII;
    }

    static {
        current = 0.0;
    }

    private static double resolveCurrentVersion() {
        String llllllllllllllllIIIIllIllIlIIlIl = System.getProperty("java.version");
        Matcher llllllllllllllllIIIIllIllIlIIlII = Pattern.compile("[0-9]+\\.[0-9]+").matcher(llllllllllllllllIIIIllIllIlIIlIl);
        if (llllllllllllllllIIIIllIllIlIIlII.find()) {
            return Double.parseDouble(llllllllllllllllIIIIllIllIlIIlII.group());
        }
        return 1.6;
    }
}

