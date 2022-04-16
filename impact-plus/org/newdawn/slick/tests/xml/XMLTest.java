/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tests.xml;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLParser;

public class XMLTest {
    private static void assertEquals(Object lllllllllllllllIllllIIlllIlIIIIl, Object lllllllllllllllIllllIIlllIlIIIII) {
        if (!lllllllllllllllIllllIIlllIlIIIIl.equals(lllllllllllllllIllllIIlllIlIIIII)) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("TEST FAILS: ").append(lllllllllllllllIllllIIlllIlIIIIl).append(" should be ").append(lllllllllllllllIllllIIlllIlIIIII)));
        }
    }

    private static void assertEquals(int lllllllllllllllIllllIIlllIlIIlll, int lllllllllllllllIllllIIlllIlIIllI) {
        if (lllllllllllllllIllllIIlllIlIIlll != lllllllllllllllIllllIIlllIlIIllI) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("TEST FAILS: ").append(lllllllllllllllIllllIIlllIlIIlll).append(" should be ").append(lllllllllllllllIllllIIlllIlIIllI)));
        }
    }

    public XMLTest() {
        XMLTest lllllllllllllllIllllIIlllIlllIII;
    }

    public static void main(String[] lllllllllllllllIllllIIlllIIlIIlI) throws SlickException {
        XMLParser lllllllllllllllIllllIIlllIIlIIIl = new XMLParser();
        XMLElement lllllllllllllllIllllIIlllIIlIIII = lllllllllllllllIllllIIlllIIlIIIl.parse("testdata/test.xml");
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIlIIII.getName(), "testRoot");
        System.out.println(lllllllllllllllIllllIIlllIIlIIII);
        XMLTest.assertNotNull(lllllllllllllllIllllIIlllIIlIIII.getChildrenByName("simple").get(0).getContent());
        System.out.println(lllllllllllllllIllllIIlllIIlIIII.getChildrenByName("simple").get(0).getContent());
        XMLElement lllllllllllllllIllllIIlllIIIllll = lllllllllllllllIllllIIlllIIlIIII.getChildrenByName("parent").get(0);
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIllll.getChildrenByName("grandchild").size(), 0);
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIllll.getChildrenByName("child").size(), 2);
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIllll.getChildrenByName("child").get(0).getChildren().size(), 2);
        XMLElement lllllllllllllllIllllIIlllIIIlllI = lllllllllllllllIllllIIlllIIIllll.getChildrenByName("child").get(0).getChildren().get(0);
        String lllllllllllllllIllllIIlllIIIllIl = lllllllllllllllIllllIIlllIIIlllI.getAttribute("name");
        String lllllllllllllllIllllIIlllIIIllII = lllllllllllllllIllllIIlllIIIlllI.getAttribute("nothere", "defaultValue");
        int lllllllllllllllIllllIIlllIIIlIll = lllllllllllllllIllllIIlllIIIlllI.getIntAttribute("age");
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIllIl, "bob");
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIllII, "defaultValue");
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIlIll, 1);
        XMLElement lllllllllllllllIllllIIlllIIIlIlI = lllllllllllllllIllllIIlllIIlIIII.getChildrenByName("other").get(0);
        float lllllllllllllllIllllIIlllIIIlIIl = (float)lllllllllllllllIllllIIlllIIIlIlI.getDoubleAttribute("x");
        float lllllllllllllllIllllIIlllIIIlIII = (float)lllllllllllllllIllllIIlllIIIlIlI.getDoubleAttribute("y", 1.0);
        float lllllllllllllllIllllIIlllIIIIlll = (float)lllllllllllllllIllllIIlllIIIlIlI.getDoubleAttribute("z", 83.0);
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIlIIl, 5.3f);
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIlIII, 5.4f);
        XMLTest.assertEquals(lllllllllllllllIllllIIlllIIIIlll, 83.0f);
        try {
            lllllllllllllllIllllIIlllIIIIlll = (float)lllllllllllllllIllllIIlllIIIlIlI.getDoubleAttribute("z");
            XMLTest.fail("Attribute z as a double should fail");
        }
        catch (SlickException lllllllllllllllIllllIIlllIIlIIll) {
            // empty catch block
        }
    }

    private static void fail(String lllllllllllllllIllllIIlllIllIllI) {
        throw new RuntimeException(lllllllllllllllIllllIIlllIllIllI);
    }

    private static void assertEquals(float lllllllllllllllIllllIIlllIlIllIl, float lllllllllllllllIllllIIlllIlIlllI) {
        if (lllllllllllllllIllllIIlllIlIllIl != lllllllllllllllIllllIIlllIlIlllI) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("TEST FAILS: ").append(lllllllllllllllIllllIIlllIlIllIl).append(" should be ").append(lllllllllllllllIllllIIlllIlIlllI)));
        }
    }

    private static void assertNotNull(Object lllllllllllllllIllllIIlllIllIIll) {
        if (lllllllllllllllIllllIIlllIllIIll == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("TEST FAILS: ").append(lllllllllllllllIllllIIlllIllIIll).append(" must not be null")));
        }
    }
}

