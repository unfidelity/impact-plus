/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.xml;

import java.util.ArrayList;
import org.newdawn.slick.tests.xml.Item;

public class ItemContainer
extends Item {
    private /* synthetic */ ArrayList items;

    private void setCondition(int lIllIlIllIIlIl) {
        lIllIlIllIIllI.condition = lIllIlIllIIlIl;
    }

    public ItemContainer() {
        ItemContainer lIllIlIlllIlIl;
        lIllIlIlllIlIl.items = new ArrayList();
    }

    @Override
    public void dump(String lIllIlIlIlllIl) {
        ItemContainer lIllIlIlIllllI;
        System.out.println(String.valueOf(new StringBuilder().append(lIllIlIlIlllIl).append("Item Container ").append(lIllIlIlIllllI.name).append(",").append(lIllIlIlIllllI.condition)));
        for (int lIllIlIlIlllll = 0; lIllIlIlIlllll < lIllIlIlIllllI.items.size(); ++lIllIlIlIlllll) {
            ((Item)lIllIlIlIllllI.items.get(lIllIlIlIlllll)).dump(String.valueOf(new StringBuilder().append(lIllIlIlIlllIl).append("\t")));
        }
    }

    private void add(Item lIllIlIllIllll) {
        ItemContainer lIllIlIlllIIlI;
        lIllIlIlllIIlI.items.add(lIllIlIllIllll);
    }

    private void setName(String lIllIlIllIlIll) {
        lIllIlIllIllII.name = lIllIlIllIlIll;
    }
}

