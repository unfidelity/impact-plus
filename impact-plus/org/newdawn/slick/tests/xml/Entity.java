/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.xml;

import org.newdawn.slick.tests.xml.Inventory;
import org.newdawn.slick.tests.xml.Stats;

public class Entity {
    private /* synthetic */ float x;
    private /* synthetic */ float y;
    private /* synthetic */ Inventory invent;
    private /* synthetic */ Stats stats;

    private void add(Inventory llllllllllllllllIIlIIIllIIlIIIlI) {
        llllllllllllllllIIlIIIllIIlIIlIl.invent = llllllllllllllllIIlIIIllIIlIIIlI;
    }

    public Entity() {
        Entity llllllllllllllllIIlIIIllIIlIlIIl;
    }

    private void add(Stats llllllllllllllllIIlIIIllIIIllllI) {
        llllllllllllllllIIlIIIllIIIlllll.stats = llllllllllllllllIIlIIIllIIIllllI;
    }

    public void dump(String llllllllllllllllIIlIIIllIIIlIllI) {
        Entity llllllllllllllllIIlIIIllIIIlIlll;
        System.out.println(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIIllIIIlIllI).append("Entity ").append(llllllllllllllllIIlIIIllIIIlIlll.x).append(",").append(llllllllllllllllIIlIIIllIIIlIlll.y)));
        llllllllllllllllIIlIIIllIIIlIlll.invent.dump(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIIllIIIlIllI).append("\t")));
        llllllllllllllllIIlIIIllIIIlIlll.stats.dump(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIIllIIIlIllI).append("\t")));
    }
}

