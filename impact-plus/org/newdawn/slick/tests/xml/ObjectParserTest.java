/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.xml;

import org.newdawn.slick.tests.xml.GameData;
import org.newdawn.slick.tests.xml.ItemContainer;
import org.newdawn.slick.util.xml.ObjectTreeParser;
import org.newdawn.slick.util.xml.SlickXMLException;

public class ObjectParserTest {
    public static void main(String[] llllllllllllllllIlIlIIIIlllIlIlI) throws SlickXMLException {
        ObjectTreeParser llllllllllllllllIlIlIIIIlllIlIIl = new ObjectTreeParser("org.newdawn.slick.tests.xml");
        llllllllllllllllIlIlIIIIlllIlIIl.addElementMapping("Bag", ItemContainer.class);
        GameData llllllllllllllllIlIlIIIIlllIlIII = (GameData)llllllllllllllllIlIlIIIIlllIlIIl.parse("testdata/objxmltest.xml");
        llllllllllllllllIlIlIIIIlllIlIII.dump("");
    }

    public ObjectParserTest() {
        ObjectParserTest llllllllllllllllIlIlIIIIlllIlllI;
    }
}

