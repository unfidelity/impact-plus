/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.command;

import org.newdawn.slick.command.Control;

abstract class ControllerControl
implements Control {
    protected static final /* synthetic */ int UP_EVENT;
    protected static final /* synthetic */ int DOWN_EVENT;
    private /* synthetic */ int button;
    protected static final /* synthetic */ int LEFT_EVENT;
    protected static final /* synthetic */ int RIGHT_EVENT;
    private /* synthetic */ int controllerNumber;
    private /* synthetic */ int event;
    protected static final /* synthetic */ int BUTTON_EVENT;

    static {
        BUTTON_EVENT = 0;
        DOWN_EVENT = 4;
        LEFT_EVENT = 1;
        RIGHT_EVENT = 2;
        UP_EVENT = 3;
    }

    public int hashCode() {
        ControllerControl llllllllllllllllIIIlIllIIllllIII;
        return llllllllllllllllIIIlIllIIllllIII.event + llllllllllllllllIIIlIllIIllllIII.button + llllllllllllllllIIIlIllIIllllIII.controllerNumber;
    }

    public boolean equals(Object llllllllllllllllIIIlIllIIllllllI) {
        ControllerControl llllllllllllllllIIIlIllIIlllllII;
        if (llllllllllllllllIIIlIllIIllllllI == null) {
            return false;
        }
        if (!(llllllllllllllllIIIlIllIIllllllI instanceof ControllerControl)) {
            return false;
        }
        ControllerControl llllllllllllllllIIIlIllIIlllllIl = (ControllerControl)llllllllllllllllIIIlIllIIllllllI;
        return llllllllllllllllIIIlIllIIlllllIl.controllerNumber == llllllllllllllllIIIlIllIIlllllII.controllerNumber && llllllllllllllllIIIlIllIIlllllIl.event == llllllllllllllllIIIlIllIIlllllII.event && llllllllllllllllIIIlIllIIlllllIl.button == llllllllllllllllIIIlIllIIlllllII.button;
    }

    protected ControllerControl(int llllllllllllllllIIIlIllIlIIIlIIl, int llllllllllllllllIIIlIllIlIIIIlII, int llllllllllllllllIIIlIllIlIIIIIll) {
        ControllerControl llllllllllllllllIIIlIllIlIIIlIlI;
        llllllllllllllllIIIlIllIlIIIlIlI.event = llllllllllllllllIIIlIllIlIIIIlII;
        llllllllllllllllIIIlIllIlIIIlIlI.button = llllllllllllllllIIIlIllIlIIIIIll;
        llllllllllllllllIIIlIllIlIIIlIlI.controllerNumber = llllllllllllllllIIIlIllIlIIIlIIl;
    }
}

