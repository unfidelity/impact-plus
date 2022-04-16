/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;

public class Bootstrap {
    public static void runAsApplication(Game llllllllllllllllIlIIlIIlIIIIlllI, int llllllllllllllllIlIIlIIlIIIlIIIl, int llllllllllllllllIlIIlIIlIIIlIIII, boolean llllllllllllllllIlIIlIIlIIIIllll) {
        try {
            AppGameContainer llllllllllllllllIlIIlIIlIIIlIlII = new AppGameContainer(llllllllllllllllIlIIlIIlIIIIlllI, llllllllllllllllIlIIlIIlIIIlIIIl, llllllllllllllllIlIIlIIlIIIlIIII, llllllllllllllllIlIIlIIlIIIIllll);
            llllllllllllllllIlIIlIIlIIIlIlII.start();
        }
        catch (Exception llllllllllllllllIlIIlIIlIIIlIIll) {
            llllllllllllllllIlIIlIIlIIIlIIll.printStackTrace();
        }
    }

    public Bootstrap() {
        Bootstrap llllllllllllllllIlIIlIIlIIIllIlI;
    }
}

