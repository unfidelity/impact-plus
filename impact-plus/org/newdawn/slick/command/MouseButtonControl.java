/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.command;

import org.newdawn.slick.command.Control;

public class MouseButtonControl
implements Control {
    private /* synthetic */ int button;

    public int hashCode() {
        MouseButtonControl llIlIIIIIIIIIII;
        return llIlIIIIIIIIIII.button;
    }

    public boolean equals(Object llIlIIIIIIIIIlI) {
        if (llIlIIIIIIIIIlI instanceof MouseButtonControl) {
            MouseButtonControl llIlIIIIIIIIlIl;
            return ((MouseButtonControl)llIlIIIIIIIIIlI).button == llIlIIIIIIIIlIl.button;
        }
        return false;
    }

    public MouseButtonControl(int llIlIIIIIIIlIII) {
        MouseButtonControl llIlIIIIIIIlIIl;
        llIlIIIIIIIlIIl.button = llIlIIIIIIIlIII;
    }
}

