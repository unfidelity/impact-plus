/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.io.PrintStream;
import java.util.Date;
import org.newdawn.slick.util.LogSystem;

public class DefaultLogSystem
implements LogSystem {
    public static /* synthetic */ PrintStream out;

    @Override
    public void debug(String llllllllllllllllllIllIIIIlIlllll) {
        out.println(String.valueOf(new StringBuilder().append(new Date()).append(" DEBUG:").append(llllllllllllllllllIllIIIIlIlllll)));
    }

    @Override
    public void warn(String llllllllllllllllllIllIIIIllIIlll) {
        out.println(String.valueOf(new StringBuilder().append(new Date()).append(" WARN:").append(llllllllllllllllllIllIIIIllIIlll)));
    }

    public DefaultLogSystem() {
        DefaultLogSystem llllllllllllllllllIllIIIIlllllII;
    }

    @Override
    public void error(Throwable llllllllllllllllllIllIIIIllIllll) {
        out.println(String.valueOf(new StringBuilder().append(new Date()).append(" ERROR:").append(llllllllllllllllllIllIIIIllIllll.getMessage())));
        llllllllllllllllllIllIIIIllIllll.printStackTrace(out);
    }

    @Override
    public void error(String llllllllllllllllllIllIIIIllIlIlI) {
        out.println(String.valueOf(new StringBuilder().append(new Date()).append(" ERROR:").append(llllllllllllllllllIllIIIIllIlIlI)));
    }

    @Override
    public void info(String llllllllllllllllllIllIIIIllIIIlI) {
        out.println(String.valueOf(new StringBuilder().append(new Date()).append(" INFO:").append(llllllllllllllllllIllIIIIllIIIlI)));
    }

    @Override
    public void warn(String llllllllllllllllllIllIIIIlIlIllI, Throwable llllllllllllllllllIllIIIIlIlIlIl) {
        DefaultLogSystem llllllllllllllllllIllIIIIlIllIlI;
        llllllllllllllllllIllIIIIlIllIlI.warn(llllllllllllllllllIllIIIIlIlIllI);
        llllllllllllllllllIllIIIIlIlIlIl.printStackTrace(out);
    }

    @Override
    public void error(String llllllllllllllllllIllIIIIlllIIll, Throwable llllllllllllllllllIllIIIIlllIIlI) {
        DefaultLogSystem llllllllllllllllllIllIIIIlllIlll;
        llllllllllllllllllIllIIIIlllIlll.error(llllllllllllllllllIllIIIIlllIIll);
        llllllllllllllllllIllIIIIlllIlll.error(llllllllllllllllllIllIIIIlllIIlI);
    }

    static {
        out = System.out;
    }
}

