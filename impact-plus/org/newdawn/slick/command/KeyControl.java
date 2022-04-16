/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.command;

import org.newdawn.slick.command.Control;

public class KeyControl
implements Control {
    private /* synthetic */ int keycode;

    public KeyControl(int lllllllllllllllIllllIlIlIIIlIIII) {
        KeyControl lllllllllllllllIllllIlIlIIIlIlII;
        lllllllllllllllIllllIlIlIIIlIlII.keycode = lllllllllllllllIllllIlIlIIIlIIII;
    }

    public boolean equals(Object lllllllllllllllIllllIlIIllllllll) {
        if (lllllllllllllllIllllIlIIllllllll instanceof KeyControl) {
            KeyControl lllllllllllllllIllllIlIlIIIIIlIl;
            return ((KeyControl)lllllllllllllllIllllIlIIllllllll).keycode == lllllllllllllllIllllIlIlIIIIIlIl.keycode;
        }
        return false;
    }

    public int hashCode() {
        KeyControl lllllllllllllllIllllIlIIlllllIll;
        return lllllllllllllllIllllIlIIlllllIll.keycode;
    }
}

