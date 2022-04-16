/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLPackedSheet {
    private /* synthetic */ Image image;
    private /* synthetic */ HashMap sprites;

    public XMLPackedSheet(String lllllllllllllllIlllIIIlIlIIlllll, String lllllllllllllllIlllIIIlIlIlIIIIl) throws SlickException {
        XMLPackedSheet lllllllllllllllIlllIIIlIlIlIIIII;
        lllllllllllllllIlllIIIlIlIlIIIII.sprites = new HashMap();
        lllllllllllllllIlllIIIlIlIlIIIII.image = new Image(lllllllllllllllIlllIIIlIlIIlllll, false, 2);
        try {
            DocumentBuilder lllllllllllllllIlllIIIlIlIlIIlll = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document lllllllllllllllIlllIIIlIlIlIIllI = lllllllllllllllIlllIIIlIlIlIIlll.parse(ResourceLoader.getResourceAsStream(lllllllllllllllIlllIIIlIlIlIIIIl));
            NodeList lllllllllllllllIlllIIIlIlIlIIlIl = lllllllllllllllIlllIIIlIlIlIIllI.getElementsByTagName("sprite");
            for (int lllllllllllllllIlllIIIlIlIlIlIII = 0; lllllllllllllllIlllIIIlIlIlIlIII < lllllllllllllllIlllIIIlIlIlIIlIl.getLength(); ++lllllllllllllllIlllIIIlIlIlIlIII) {
                Element lllllllllllllllIlllIIIlIlIlIlllI = (Element)lllllllllllllllIlllIIIlIlIlIIlIl.item(lllllllllllllllIlllIIIlIlIlIlIII);
                String lllllllllllllllIlllIIIlIlIlIllIl = lllllllllllllllIlllIIIlIlIlIlllI.getAttribute("name");
                int lllllllllllllllIlllIIIlIlIlIllII = Integer.parseInt(lllllllllllllllIlllIIIlIlIlIlllI.getAttribute("x"));
                int lllllllllllllllIlllIIIlIlIlIlIll = Integer.parseInt(lllllllllllllllIlllIIIlIlIlIlllI.getAttribute("y"));
                int lllllllllllllllIlllIIIlIlIlIlIlI = Integer.parseInt(lllllllllllllllIlllIIIlIlIlIlllI.getAttribute("width"));
                int lllllllllllllllIlllIIIlIlIlIlIIl = Integer.parseInt(lllllllllllllllIlllIIIlIlIlIlllI.getAttribute("height"));
                lllllllllllllllIlllIIIlIlIlIIIII.sprites.put(lllllllllllllllIlllIIIlIlIlIllIl, lllllllllllllllIlllIIIlIlIlIIIII.image.getSubImage(lllllllllllllllIlllIIIlIlIlIllII, lllllllllllllllIlllIIIlIlIlIlIll, lllllllllllllllIlllIIIlIlIlIlIlI, lllllllllllllllIlllIIIlIlIlIlIIl));
            }
        }
        catch (Exception lllllllllllllllIlllIIIlIlIlIIlII) {
            throw new SlickException("Failed to parse sprite sheet XML", lllllllllllllllIlllIIIlIlIlIIlII);
        }
    }

    public Image getSprite(String lllllllllllllllIlllIIIlIlIIlIIII) {
        XMLPackedSheet lllllllllllllllIlllIIIlIlIIlIIIl;
        return (Image)lllllllllllllllIlllIIIlIlIIlIIIl.sprites.get(lllllllllllllllIlllIIIlIlIIlIIII);
    }
}

