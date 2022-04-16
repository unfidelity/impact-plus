/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.navmesh;

import java.util.ArrayList;
import org.newdawn.slick.util.pathfinding.navmesh.Link;

public class NavPath {
    private /* synthetic */ ArrayList links;

    public void remove(int llllllllllllllllIlIIlIIIIlIllIll) {
        NavPath llllllllllllllllIlIIlIIIIllIIIII;
        llllllllllllllllIlIIlIIIIllIIIII.links.remove(llllllllllllllllIlIIlIIIIlIllIll);
    }

    public NavPath() {
        NavPath llllllllllllllllIlIIlIIIlIIIllII;
        llllllllllllllllIlIIlIIIlIIIllII.links = new ArrayList();
    }

    public void push(Link llllllllllllllllIlIIlIIIlIIIIIlI) {
        NavPath llllllllllllllllIlIIlIIIlIIIIIIl;
        llllllllllllllllIlIIlIIIlIIIIIIl.links.add(llllllllllllllllIlIIlIIIlIIIIIlI);
    }

    public float getX(int llllllllllllllllIlIIlIIIIlllIlll) {
        NavPath llllllllllllllllIlIIlIIIIllllIII;
        return ((Link)llllllllllllllllIlIIlIIIIllllIII.links.get(llllllllllllllllIlIIlIIIIlllIlll)).getX();
    }

    public String toString() {
        NavPath llllllllllllllllIlIIlIIIIllIlIll;
        return String.valueOf(new StringBuilder().append("[Path length=").append(llllllllllllllllIlIIlIIIIllIlIll.length()).append("]"));
    }

    public int length() {
        NavPath llllllllllllllllIlIIlIIIIlllllIl;
        return llllllllllllllllIlIIlIIIIlllllIl.links.size();
    }

    public float getY(int llllllllllllllllIlIIlIIIIlllIIll) {
        NavPath llllllllllllllllIlIIlIIIIlllIlII;
        return ((Link)llllllllllllllllIlIIlIIIIlllIlII.links.get(llllllllllllllllIlIIlIIIIlllIIll)).getY();
    }
}

