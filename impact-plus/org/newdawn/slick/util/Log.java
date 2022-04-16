/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.newdawn.slick.util.DefaultLogSystem;
import org.newdawn.slick.util.LogSystem;

public final class Log {
    private static final /* synthetic */ String forceVerboseProperty;
    private static final /* synthetic */ String forceVerbosePropertyOnValue;
    private static /* synthetic */ LogSystem logSystem;
    private static /* synthetic */ boolean forcedVerbose;
    private static /* synthetic */ boolean verbose;

    public static void warn(String lllIlIIlIIIlIII) {
        logSystem.warn(lllIlIIlIIIlIII);
    }

    private Log() {
        Log lllIlIIlIlIIIII;
    }

    public static void info(String lllIlIIIlllllll) {
        if (verbose || forcedVerbose) {
            logSystem.info(lllIlIIIlllllll);
        }
    }

    public static void setVerbose(boolean lllIlIIlIIllIlI) {
        if (forcedVerbose) {
            return;
        }
        verbose = lllIlIIlIIllIlI;
    }

    public static void debug(String lllIlIIIllllIll) {
        if (verbose || forcedVerbose) {
            logSystem.debug(lllIlIIIllllIll);
        }
    }

    public static void setForcedVerboseOn() {
        forcedVerbose = true;
        verbose = true;
    }

    public static void error(String lllIlIIlIIlIIIl, Throwable lllIlIIlIIlIIII) {
        logSystem.error(lllIlIIlIIlIIIl, lllIlIIlIIlIIII);
    }

    public static void checkVerboseLogSetting() {
        try {
            AccessController.doPrivileged(new PrivilegedAction(){
                {
                    1 llllllllllllllllIIlIIIIIIIIIlIIl;
                }

                public Object run() {
                    String llllllllllllllllIIIlllllllllllIl = System.getProperty("org.newdawn.slick.forceVerboseLog");
                    if (llllllllllllllllIIIlllllllllllIl != null && llllllllllllllllIIIlllllllllllIl.equalsIgnoreCase("true")) {
                        Log.setForcedVerboseOn();
                    }
                    return null;
                }
            });
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static void error(String lllIlIIlIIIlIlI) {
        logSystem.error(lllIlIIlIIIlIlI);
    }

    public static void warn(String lllIlIIlIIIIIlI, Throwable lllIlIIlIIIIIIl) {
        logSystem.warn(lllIlIIlIIIIIlI, lllIlIIlIIIIIIl);
    }

    static {
        forceVerboseProperty = "org.newdawn.slick.forceVerboseLog";
        forceVerbosePropertyOnValue = "true";
        verbose = true;
        forcedVerbose = false;
        logSystem = new DefaultLogSystem();
    }

    public static void setLogSystem(LogSystem lllIlIIlIIlllII) {
        logSystem = lllIlIIlIIlllII;
    }

    public static void error(Throwable lllIlIIlIIIllIl) {
        logSystem.error(lllIlIIlIIIllIl);
    }
}

