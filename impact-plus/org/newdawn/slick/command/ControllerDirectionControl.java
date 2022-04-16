/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.command;

import org.newdawn.slick.command.ControllerControl;

public class ControllerDirectionControl
extends ControllerControl {
    public static final /* synthetic */ Direction LEFT;
    public static final /* synthetic */ Direction RIGHT;
    public static final /* synthetic */ Direction UP;
    public static final /* synthetic */ Direction DOWN;

    static {
        LEFT = new Direction(1);
        UP = new Direction(3);
        DOWN = new Direction(4);
        RIGHT = new Direction(2);
    }

    public ControllerDirectionControl(int llllllllllllllllIlllIIIlIIIllllI, Direction llllllllllllllllIlllIIIlIIIlllIl) {
        super(llllllllllllllllIlllIIIlIIIllllI, llllllllllllllllIlllIIIlIIIlllIl.event, 0);
        ControllerDirectionControl llllllllllllllllIlllIIIlIIlIIIlI;
    }

    private static class Direction {
        private /* synthetic */ int event;

        public Direction(int lIlllllIIlllIll) {
            Direction lIlllllIIllllII;
            lIlllllIIllllII.event = lIlllllIIlllIll;
        }
    }
}

