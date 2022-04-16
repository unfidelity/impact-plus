/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.xml;

import java.util.ArrayList;
import java.util.Collection;
import org.newdawn.slick.util.xml.XMLElement;

public class XMLElementList {
    private /* synthetic */ ArrayList list;

    public int size() {
        XMLElementList lllllllllllllllllIIlIIlIllIlIlIl;
        return lllllllllllllllllIIlIIlIllIlIlIl.list.size();
    }

    public boolean contains(XMLElement lllllllllllllllllIIlIIlIllIIlIll) {
        XMLElementList lllllllllllllllllIIlIIlIllIIllII;
        return lllllllllllllllllIIlIIlIllIIllII.list.contains(lllllllllllllllllIIlIIlIllIIlIll);
    }

    public XMLElementList() {
        XMLElementList lllllllllllllllllIIlIIlIllIllllI;
        lllllllllllllllllIIlIIlIllIllllI.list = new ArrayList();
    }

    public XMLElement get(int lllllllllllllllllIIlIIlIllIlIIIl) {
        XMLElementList lllllllllllllllllIIlIIlIllIlIIII;
        return (XMLElement)lllllllllllllllllIIlIIlIllIlIIII.list.get(lllllllllllllllllIIlIIlIllIlIIIl);
    }

    public void addAllTo(Collection lllllllllllllllllIIlIIlIllIIIlIl) {
        XMLElementList lllllllllllllllllIIlIIlIllIIIllI;
        lllllllllllllllllIIlIIlIllIIIlIl.addAll(lllllllllllllllllIIlIIlIllIIIllI.list);
    }

    public void add(XMLElement lllllllllllllllllIIlIIlIllIllIII) {
        XMLElementList lllllllllllllllllIIlIIlIllIllIIl;
        lllllllllllllllllIIlIIlIllIllIIl.list.add(lllllllllllllllllIIlIIlIllIllIII);
    }
}

