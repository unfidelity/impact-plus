/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.xml;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.util.xml.SlickXMLException;
import org.newdawn.slick.util.xml.XMLElement;
import org.w3c.dom.Document;

public class XMLParser {
    private static /* synthetic */ DocumentBuilderFactory factory;

    public XMLElement parse(String lIIllIllllIIlIl) throws SlickException {
        XMLParser lIIllIllllIIllI;
        return lIIllIllllIIllI.parse(lIIllIllllIIlIl, ResourceLoader.getResourceAsStream(lIIllIllllIIlIl));
    }

    public XMLElement parse(String lIIllIllIllIIIl, InputStream lIIllIllIlIllll) throws SlickXMLException {
        try {
            if (factory == null) {
                factory = DocumentBuilderFactory.newInstance();
            }
            DocumentBuilder lIIllIlllIIIIll = factory.newDocumentBuilder();
            Document lIIllIlllIIIIII = lIIllIlllIIIIll.parse(lIIllIllIlIllll);
            return new XMLElement(lIIllIlllIIIIII.getDocumentElement());
        }
        catch (Exception lIIllIllIllllIl) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to parse document: ").append(lIIllIllIllIIIl)), lIIllIllIllllIl);
        }
    }

    public XMLParser() {
        XMLParser lIIllIllllIlIll;
    }
}

