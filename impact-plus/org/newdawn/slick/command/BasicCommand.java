/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.command;

import org.newdawn.slick.command.Command;

public class BasicCommand
implements Command {
    private /* synthetic */ String name;

    public String getName() {
        BasicCommand lllllllllllllllllIIlllllllIllIlI;
        return lllllllllllllllllIIlllllllIllIlI.name;
    }

    public boolean equals(Object lllllllllllllllllIIlllllllIlIIII) {
        if (lllllllllllllllllIIlllllllIlIIII instanceof BasicCommand) {
            BasicCommand lllllllllllllllllIIlllllllIlIIIl;
            return ((BasicCommand)lllllllllllllllllIIlllllllIlIIII).name.equals(lllllllllllllllllIIlllllllIlIIIl.name);
        }
        return false;
    }

    public BasicCommand(String lllllllllllllllllIIlllllllIlllII) {
        BasicCommand lllllllllllllllllIIlllllllIlllll;
        lllllllllllllllllIIlllllllIlllll.name = lllllllllllllllllIIlllllllIlllII;
    }

    public String toString() {
        BasicCommand lllllllllllllllllIIlllllllIIllIl;
        return String.valueOf(new StringBuilder().append("[Command=").append(lllllllllllllllllIIlllllllIIllIl.name).append("]"));
    }

    public int hashCode() {
        BasicCommand lllllllllllllllllIIlllllllIlIlll;
        return lllllllllllllllllIIlllllllIlIlll.name.hashCode();
    }
}

