/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.navmesh;

import org.newdawn.slick.util.pathfinding.navmesh.Space;

public class Link {
    private /* synthetic */ Space target;
    private /* synthetic */ float px;
    private /* synthetic */ float py;

    public float getY() {
        Link llIlIIIlIIIlll;
        return llIlIIIlIIIlll.py;
    }

    public float getX() {
        Link llIlIIIlIIlIll;
        return llIlIIIlIIlIll.px;
    }

    public Space getTarget() {
        Link llIlIIIlIIIlIl;
        return llIlIIIlIIIlIl.target;
    }

    public float distance2(float llIlIIIlIllllI, float llIlIIIlIlIIll) {
        Link llIlIIIllIIIII;
        float llIlIIIlIllIll = llIlIIIlIllllI - llIlIIIllIIIII.px;
        float llIlIIIlIllIIl = llIlIIIlIlIIll - llIlIIIllIIIII.py;
        return llIlIIIlIllIll * llIlIIIlIllIll + llIlIIIlIllIIl * llIlIIIlIllIIl;
    }

    public Link(float llIlIIIllIlIll, float llIlIIIllIlIlI, Space llIlIIIllIlIIl) {
        Link llIlIIIllIllII;
        llIlIIIllIllII.px = llIlIIIllIlIll;
        llIlIIIllIllII.py = llIlIIIllIlIlI;
        llIlIIIllIllII.target = llIlIIIllIlIIl;
    }
}

