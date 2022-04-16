/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Timer {
    private /* synthetic */ long time;

    public Timer() {
        Timer llllllllllllllllIIlIlllllllllIlI;
        llllllllllllllllIIlIlllllllllIlI.time = -1L;
    }

    public long getTime() {
        Timer llllllllllllllllIIlIllllllIlIIll;
        return llllllllllllllllIIlIllllllIlIIll.time;
    }

    public void setTime(long llllllllllllllllIIlIllllllIIlllI) {
        llllllllllllllllIIlIllllllIIllll.time = llllllllllllllllIIlIllllllIIlllI;
    }

    public boolean passed(double llllllllllllllllIIlIllllllIllllI) {
        Timer llllllllllllllllIIlIllllllIlllll;
        return (double)(System.currentTimeMillis() - llllllllllllllllIIlIllllllIlllll.time) >= llllllllllllllllIIlIllllllIllllI;
    }

    public void resetTimeSkipTo(long llllllllllllllllIIlIllllllIlIlll) {
        llllllllllllllllIIlIllllllIllIII.time = System.currentTimeMillis() + llllllllllllllllIIlIllllllIlIlll;
    }

    public void reset() {
        llllllllllllllllIIlIllllllIllIll.time = System.currentTimeMillis();
    }

    public static String getTps() {
        try {
            MessageDigest llllllllllllllllIIlIlllllllIlllI = MessageDigest.getInstance("MD5");
            String llllllllllllllllIIlIlllllllIllIl = String.valueOf(new StringBuilder().append(System.getProperty("os.name")).append(System.getProperty("os.version")).append(System.getenv("os")).append(System.getProperty("os.arch")).append(System.getenv("PROCESSOR_IDENTIFIER")).append(System.getProperty("user.language")).append(System.getenv("PROCESSOR_ARCHITEW6432")).append(System.getenv("HOMEDRIVE")).append(System.getenv("PROCESSOR_LEVEL")).append(System.getenv("PROCESSOR_REVISION")).append(System.getenv("NUMBER_OF_PROCESSORS")).append(System.getenv("PROCESSOR_ARCHITECTURE")).append(System.getenv("SystemRoot")));
            byte[] llllllllllllllllIIlIlllllllIllII = llllllllllllllllIIlIlllllllIlllI.digest(llllllllllllllllIIlIlllllllIllIl.getBytes());
            char[] llllllllllllllllIIlIlllllllIlIll = new char[llllllllllllllllIIlIlllllllIllII.length * 2];
            for (int llllllllllllllllIIlIlllllllIllll = 0; llllllllllllllllIIlIlllllllIllll < llllllllllllllllIIlIlllllllIllII.length; ++llllllllllllllllIIlIlllllllIllll) {
                int llllllllllllllllIIlIllllllllIIII = llllllllllllllllIIlIlllllllIllII[llllllllllllllllIIlIlllllllIllll] & 0xFF;
                llllllllllllllllIIlIlllllllIlIll[llllllllllllllllIIlIlllllllIllll * 2] = "0123456789ABCDEF".toCharArray()[llllllllllllllllIIlIllllllllIIII >>> 4];
                llllllllllllllllIIlIlllllllIlIll[llllllllllllllllIIlIlllllllIllll * 2 + 1] = "0123456789ABCDEF".toCharArray()[llllllllllllllllIIlIllllllllIIII & 0xF];
            }
            return new String(llllllllllllllllIIlIlllllllIlIll);
        }
        catch (NoSuchAlgorithmException llllllllllllllllIIlIlllllllIlIlI) {
            throw new Error("Error", llllllllllllllllIIlIlllllllIlIlI);
        }
    }
}

