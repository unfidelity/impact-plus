/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.xml;

import org.newdawn.slick.util.xml.SlickXMLException;
import org.newdawn.slick.util.xml.XMLElementList;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XMLElement {
    private /* synthetic */ XMLElementList children;
    private /* synthetic */ String name;
    private /* synthetic */ Element dom;

    public String getAttribute(String lIlllIlIIlIIlll, String lIlllIlIIlIIllI) {
        XMLElement lIlllIlIIlIlIII;
        String lIlllIlIIlIIlIl = lIlllIlIIlIlIII.dom.getAttribute(lIlllIlIIlIIlll);
        if (lIlllIlIIlIIlIl == null || lIlllIlIIlIIlIl.length() == 0) {
            return lIlllIlIIlIIllI;
        }
        return lIlllIlIIlIIlIl;
    }

    public boolean getBooleanAttribute(String lIlllIIlllIIIll) throws SlickXMLException {
        XMLElement lIlllIIlllIIlII;
        String lIlllIIlllIIlIl = lIlllIIlllIIlII.getAttribute(lIlllIIlllIIIll);
        if (lIlllIIlllIIlIl.equalsIgnoreCase("true")) {
            return true;
        }
        if (lIlllIIlllIIlIl.equalsIgnoreCase("false")) {
            return false;
        }
        throw new SlickXMLException(String.valueOf(new StringBuilder().append("Value read: '").append(lIlllIIlllIIlII.getAttribute(lIlllIIlllIIIll)).append("' is not a boolean")));
    }

    XMLElement(Element lIlllIlIlIIIIlI) {
        XMLElement lIlllIlIlIIIlIl;
        lIlllIlIlIIIlIl.dom = lIlllIlIlIIIIlI;
        lIlllIlIlIIIlIl.name = lIlllIlIlIIIlIl.dom.getTagName();
    }

    public XMLElementList getChildrenByName(String lIlllIIlIllIlIl) {
        XMLElement lIlllIIlIlllIlI;
        XMLElementList lIlllIIlIlllIII = new XMLElementList();
        XMLElementList lIlllIIlIllIlll = lIlllIIlIlllIlI.getChildren();
        for (int lIlllIIlIlllIll = 0; lIlllIIlIlllIll < lIlllIIlIllIlll.size(); ++lIlllIIlIlllIll) {
            if (!lIlllIIlIllIlll.get(lIlllIIlIlllIll).getName().equals(lIlllIIlIllIlIl)) continue;
            lIlllIIlIlllIII.add(lIlllIIlIllIlll.get(lIlllIIlIlllIll));
        }
        return lIlllIIlIlllIII;
    }

    public String getName() {
        XMLElement lIlllIlIIllIlII;
        return lIlllIlIIllIlII.name;
    }

    public String toString() {
        XMLElement lIlllIIlIlIlIIl;
        String lIlllIIlIlIlIll = String.valueOf(new StringBuilder().append("[XML ").append(lIlllIIlIlIlIIl.getName()));
        String[] lIlllIIlIlIlIlI = lIlllIIlIlIlIIl.getAttributeNames();
        for (int lIlllIIlIlIllIl = 0; lIlllIIlIlIllIl < lIlllIIlIlIlIlI.length; ++lIlllIIlIlIllIl) {
            lIlllIIlIlIlIll = String.valueOf(new StringBuilder().append(lIlllIIlIlIlIll).append(" ").append(lIlllIIlIlIlIlI[lIlllIIlIlIllIl]).append("=").append(lIlllIIlIlIlIIl.getAttribute(lIlllIIlIlIlIlI[lIlllIIlIlIllIl])));
        }
        lIlllIIlIlIlIll = String.valueOf(new StringBuilder().append(lIlllIIlIlIlIll).append("]"));
        return lIlllIIlIlIlIll;
    }

    public String[] getAttributeNames() {
        XMLElement lIlllIlIIlllIIl;
        NamedNodeMap lIlllIlIIlllIll = lIlllIlIIlllIIl.dom.getAttributes();
        String[] lIlllIlIIlllIlI = new String[lIlllIlIIlllIll.getLength()];
        for (int lIlllIlIIllllIl = 0; lIlllIlIIllllIl < lIlllIlIIlllIlI.length; ++lIlllIlIIllllIl) {
            lIlllIlIIlllIlI[lIlllIlIIllllIl] = lIlllIlIIlllIll.item(lIlllIlIIllllIl).getNodeName();
        }
        return lIlllIlIIlllIlI;
    }

    public double getDoubleAttribute(String lIlllIIlllIllIl, double lIlllIIlllIllII) throws SlickXMLException {
        XMLElement lIlllIIlllIlllI;
        try {
            return Double.parseDouble(lIlllIIlllIlllI.getAttribute(lIlllIIlllIllIl, String.valueOf(new StringBuilder().append("").append(lIlllIIlllIllII))));
        }
        catch (NumberFormatException lIlllIIllllIIlI) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Value read: '").append(lIlllIIlllIlllI.getAttribute(lIlllIIlllIllIl, String.valueOf(new StringBuilder().append("").append(lIlllIIlllIllII)))).append("' is not a double")), lIlllIIllllIIlI);
        }
    }

    public String getAttribute(String lIlllIlIIlIllll) {
        XMLElement lIlllIlIIllIIII;
        return lIlllIlIIllIIII.dom.getAttribute(lIlllIlIIlIllll);
    }

    public int getIntAttribute(String lIlllIlIIIlIIIl, int lIlllIlIIIlIIII) throws SlickXMLException {
        XMLElement lIlllIlIIIlIIlI;
        try {
            return Integer.parseInt(lIlllIlIIIlIIlI.getAttribute(lIlllIlIIIlIIIl, String.valueOf(new StringBuilder().append("").append(lIlllIlIIIlIIII))));
        }
        catch (NumberFormatException lIlllIlIIIlIIll) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Value read: '").append(lIlllIlIIIlIIlI.getAttribute(lIlllIlIIIlIIIl, String.valueOf(new StringBuilder().append("").append(lIlllIlIIIlIIII)))).append("' is not an integer")), lIlllIlIIIlIIll);
        }
    }

    public int getIntAttribute(String lIlllIlIIIllIll) throws SlickXMLException {
        XMLElement lIlllIlIIIlllII;
        try {
            return Integer.parseInt(lIlllIlIIIlllII.getAttribute(lIlllIlIIIllIll));
        }
        catch (NumberFormatException lIlllIlIIIlllIl) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Value read: '").append(lIlllIlIIIlllII.getAttribute(lIlllIlIIIllIll)).append("' is not an integer")), lIlllIlIIIlllIl);
        }
    }

    public boolean getBooleanAttribute(String lIlllIIllIlllII, boolean lIlllIIllIllIll) throws SlickXMLException {
        XMLElement lIlllIIllIlllIl;
        String lIlllIIllIllIlI = lIlllIIllIlllIl.getAttribute(lIlllIIllIlllII, String.valueOf(new StringBuilder().append("").append(lIlllIIllIllIll)));
        if (lIlllIIllIllIlI.equalsIgnoreCase("true")) {
            return true;
        }
        if (lIlllIIllIllIlI.equalsIgnoreCase("false")) {
            return false;
        }
        throw new SlickXMLException(String.valueOf(new StringBuilder().append("Value read: '").append(lIlllIIllIlllIl.getAttribute(lIlllIIllIlllII, String.valueOf(new StringBuilder().append("").append(lIlllIIllIllIll)))).append("' is not a boolean")));
    }

    public String getContent() {
        XMLElement lIlllIIllIIllIl;
        String lIlllIIllIIllll = "";
        NodeList lIlllIIllIIlllI = lIlllIIllIIllIl.dom.getChildNodes();
        for (int lIlllIIllIlIIIl = 0; lIlllIIllIlIIIl < lIlllIIllIIlllI.getLength(); ++lIlllIIllIlIIIl) {
            if (!(lIlllIIllIIlllI.item(lIlllIIllIlIIIl) instanceof Text)) continue;
            lIlllIIllIIllll = String.valueOf(new StringBuilder().append(lIlllIIllIIllll).append(lIlllIIllIIlllI.item(lIlllIIllIlIIIl).getNodeValue()));
        }
        return lIlllIIllIIllll;
    }

    public double getDoubleAttribute(String lIlllIIlllllIlI) throws SlickXMLException {
        XMLElement lIlllIIlllllIll;
        try {
            return Double.parseDouble(lIlllIIlllllIll.getAttribute(lIlllIIlllllIlI));
        }
        catch (NumberFormatException lIlllIIllllllIl) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Value read: '").append(lIlllIIlllllIll.getAttribute(lIlllIIlllllIlI)).append("' is not a double")), lIlllIIllllllIl);
        }
    }

    public XMLElementList getChildren() {
        XMLElement lIlllIIllIIIIll;
        if (lIlllIIllIIIIll.children != null) {
            return lIlllIIllIIIIll.children;
        }
        NodeList lIlllIIllIIIlII = lIlllIIllIIIIll.dom.getChildNodes();
        lIlllIIllIIIIll.children = new XMLElementList();
        for (int lIlllIIllIIIllI = 0; lIlllIIllIIIllI < lIlllIIllIIIlII.getLength(); ++lIlllIIllIIIllI) {
            if (!(lIlllIIllIIIlII.item(lIlllIIllIIIllI) instanceof Element)) continue;
            lIlllIIllIIIIll.children.add(new XMLElement((Element)lIlllIIllIIIlII.item(lIlllIIllIIIllI)));
        }
        return lIlllIIllIIIIll.children;
    }
}

