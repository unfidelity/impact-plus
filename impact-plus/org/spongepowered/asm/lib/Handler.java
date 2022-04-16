/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.Label;

class Handler {
    /* synthetic */ Handler next;
    /* synthetic */ String desc;
    /* synthetic */ Label handler;
    /* synthetic */ int type;
    /* synthetic */ Label end;
    /* synthetic */ Label start;

    Handler() {
        Handler lllllllllllllllllIlIIIIlIlIlIIll;
    }

    static Handler remove(Handler lllllllllllllllllIlIIIIlIlIIlIII, Label lllllllllllllllllIlIIIIlIlIIIIII, Label lllllllllllllllllIlIIIIlIlIIIllI) {
        int lllllllllllllllllIlIIIIlIlIIIIlI;
        if (lllllllllllllllllIlIIIIlIlIIlIII == null) {
            return null;
        }
        lllllllllllllllllIlIIIIlIlIIlIII.next = Handler.remove(lllllllllllllllllIlIIIIlIlIIlIII.next, lllllllllllllllllIlIIIIlIlIIIIII, lllllllllllllllllIlIIIIlIlIIIllI);
        int lllllllllllllllllIlIIIIlIlIIIlIl = lllllllllllllllllIlIIIIlIlIIlIII.start.position;
        int lllllllllllllllllIlIIIIlIlIIIlII = lllllllllllllllllIlIIIIlIlIIlIII.end.position;
        int lllllllllllllllllIlIIIIlIlIIIIll = lllllllllllllllllIlIIIIlIlIIIIII.position;
        int n = lllllllllllllllllIlIIIIlIlIIIIlI = lllllllllllllllllIlIIIIlIlIIIllI == null ? Integer.MAX_VALUE : lllllllllllllllllIlIIIIlIlIIIllI.position;
        if (lllllllllllllllllIlIIIIlIlIIIIll < lllllllllllllllllIlIIIIlIlIIIlII && lllllllllllllllllIlIIIIlIlIIIIlI > lllllllllllllllllIlIIIIlIlIIIlIl) {
            if (lllllllllllllllllIlIIIIlIlIIIIll <= lllllllllllllllllIlIIIIlIlIIIlIl) {
                if (lllllllllllllllllIlIIIIlIlIIIIlI >= lllllllllllllllllIlIIIIlIlIIIlII) {
                    lllllllllllllllllIlIIIIlIlIIlIII = lllllllllllllllllIlIIIIlIlIIlIII.next;
                } else {
                    lllllllllllllllllIlIIIIlIlIIlIII.start = lllllllllllllllllIlIIIIlIlIIIllI;
                }
            } else if (lllllllllllllllllIlIIIIlIlIIIIlI >= lllllllllllllllllIlIIIIlIlIIIlII) {
                lllllllllllllllllIlIIIIlIlIIlIII.end = lllllllllllllllllIlIIIIlIlIIIIII;
            } else {
                Handler lllllllllllllllllIlIIIIlIlIIlIIl = new Handler();
                lllllllllllllllllIlIIIIlIlIIlIIl.start = lllllllllllllllllIlIIIIlIlIIIllI;
                lllllllllllllllllIlIIIIlIlIIlIIl.end = lllllllllllllllllIlIIIIlIlIIlIII.end;
                lllllllllllllllllIlIIIIlIlIIlIIl.handler = lllllllllllllllllIlIIIIlIlIIlIII.handler;
                lllllllllllllllllIlIIIIlIlIIlIIl.desc = lllllllllllllllllIlIIIIlIlIIlIII.desc;
                lllllllllllllllllIlIIIIlIlIIlIIl.type = lllllllllllllllllIlIIIIlIlIIlIII.type;
                lllllllllllllllllIlIIIIlIlIIlIIl.next = lllllllllllllllllIlIIIIlIlIIlIII.next;
                lllllllllllllllllIlIIIIlIlIIlIII.end = lllllllllllllllllIlIIIIlIlIIIIII;
                lllllllllllllllllIlIIIIlIlIIlIII.next = lllllllllllllllllIlIIIIlIlIIlIIl;
            }
        }
        return lllllllllllllllllIlIIIIlIlIIlIII;
    }
}

