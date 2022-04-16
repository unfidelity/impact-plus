/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.xml;

import java.util.ArrayList;
import org.newdawn.slick.tests.xml.Item;

public class Inventory {
    private /* synthetic */ ArrayList items;

    private void add(Item llllllllllllllllIIlllIIIIIIIllIl) {
        Inventory llllllllllllllllIIlllIIIIIIlIIll;
        llllllllllllllllIIlllIIIIIIlIIll.items.add(llllllllllllllllIIlllIIIIIIIllIl);
    }

    public void dump(String llllllllllllllllIIllIlllllIlllII) {
        Inventory llllllllllllllllIIllIlllllIlllIl;
        System.out.println(String.valueOf(new StringBuilder().append(llllllllllllllllIIllIlllllIlllII).append("Inventory")));
        for (int llllllllllllllllIIllIlllllIllllI = 0; llllllllllllllllIIllIlllllIllllI < llllllllllllllllIIllIlllllIlllIl.items.size(); ++llllllllllllllllIIllIlllllIllllI) {
            ((Item)llllllllllllllllIIllIlllllIlllIl.items.get(llllllllllllllllIIllIlllllIllllI)).dump(String.valueOf(new StringBuilder().append(llllllllllllllllIIllIlllllIlllII).append("\t")));
        }
    }

    public Inventory() {
        Inventory llllllllllllllllIIlllIIIIIIllllI;
        llllllllllllllllIIlllIIIIIIllllI.items = new ArrayList();
    }
}

