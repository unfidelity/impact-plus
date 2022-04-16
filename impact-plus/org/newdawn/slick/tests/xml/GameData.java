/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.xml;

import java.util.ArrayList;
import org.newdawn.slick.tests.xml.Entity;

public class GameData {
    private /* synthetic */ ArrayList entities;

    public void dump(String llllllllllllllllllIIIIIlllllIIII) {
        GameData llllllllllllllllllIIIIIllllIllll;
        System.out.println(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIIIlllllIIII).append("GameData")));
        for (int llllllllllllllllllIIIIIlllllIIlI = 0; llllllllllllllllllIIIIIlllllIIlI < llllllllllllllllllIIIIIllllIllll.entities.size(); ++llllllllllllllllllIIIIIlllllIIlI) {
            ((Entity)llllllllllllllllllIIIIIllllIllll.entities.get(llllllllllllllllllIIIIIlllllIIlI)).dump(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIIIlllllIIII).append("\t")));
        }
    }

    public GameData() {
        GameData llllllllllllllllllIIIIIlllllllIl;
        llllllllllllllllllIIIIIlllllllIl.entities = new ArrayList();
    }

    private void add(Entity llllllllllllllllllIIIIIlllllIllI) {
        GameData llllllllllllllllllIIIIIllllllIIl;
        llllllllllllllllllIIIIIllllllIIl.entities.add(llllllllllllllllllIIIIIlllllIllI);
    }
}

