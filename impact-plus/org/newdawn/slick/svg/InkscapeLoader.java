/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Loader;
import org.newdawn.slick.svg.ParsingException;
import org.newdawn.slick.svg.inkscape.DefsProcessor;
import org.newdawn.slick.svg.inkscape.ElementProcessor;
import org.newdawn.slick.svg.inkscape.EllipseProcessor;
import org.newdawn.slick.svg.inkscape.GroupProcessor;
import org.newdawn.slick.svg.inkscape.LineProcessor;
import org.newdawn.slick.svg.inkscape.PathProcessor;
import org.newdawn.slick.svg.inkscape.PolygonProcessor;
import org.newdawn.slick.svg.inkscape.RectProcessor;
import org.newdawn.slick.svg.inkscape.UseProcessor;
import org.newdawn.slick.util.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class InkscapeLoader
implements Loader {
    private static /* synthetic */ ArrayList processors;
    public static /* synthetic */ int RADIAL_TRIANGULATION_LEVEL;
    private /* synthetic */ Diagram diagram;

    private Diagram loadDiagram(InputStream llllllllllllllllIllIlIIllIlIllII) throws SlickException {
        InkscapeLoader llllllllllllllllIllIlIIllIlIllll;
        return llllllllllllllllIllIlIIllIlIllll.loadDiagram(llllllllllllllllIllIlIIllIlIllII, false);
    }

    public static void addElementProcessor(ElementProcessor llllllllllllllllIllIlIIlllIIlIIl) {
        processors.add(llllllllllllllllIllIlIIlllIIlIIl);
    }

    @Override
    public void loadChildren(Element llllllllllllllllIllIlIIlIllIIlIl, Transform llllllllllllllllIllIlIIlIlIllllI) throws ParsingException {
        NodeList llllllllllllllllIllIlIIlIllIIIlI = llllllllllllllllIllIlIIlIllIIlIl.getChildNodes();
        for (int llllllllllllllllIllIlIIlIllIlIll = 0; llllllllllllllllIllIlIIlIllIlIll < llllllllllllllllIllIlIIlIllIIIlI.getLength(); ++llllllllllllllllIllIlIIlIllIlIll) {
            InkscapeLoader llllllllllllllllIllIlIIlIllIIIII;
            if (!(llllllllllllllllIllIlIIlIllIIIlI.item(llllllllllllllllIllIlIIlIllIlIll) instanceof Element)) continue;
            llllllllllllllllIllIlIIlIllIIIII.loadElement((Element)llllllllllllllllIllIlIIlIllIIIlI.item(llllllllllllllllIllIlIIlIllIlIll), llllllllllllllllIllIlIIlIlIllllI);
        }
    }

    private void loadElement(Element llllllllllllllllIllIlIIlIlIIIlIl, Transform llllllllllllllllIllIlIIlIlIIIlII) throws ParsingException {
        for (int llllllllllllllllIllIlIIlIlIIIlll = 0; llllllllllllllllIllIlIIlIlIIIlll < processors.size(); ++llllllllllllllllIllIlIIlIlIIIlll) {
            InkscapeLoader llllllllllllllllIllIlIIlIlIIIIll;
            ElementProcessor llllllllllllllllIllIlIIlIlIIlIII = (ElementProcessor)processors.get(llllllllllllllllIllIlIIlIlIIIlll);
            if (!llllllllllllllllIllIlIIlIlIIlIII.handles(llllllllllllllllIllIlIIlIlIIIlIl)) continue;
            llllllllllllllllIllIlIIlIlIIlIII.process(llllllllllllllllIllIlIIlIlIIIIll, llllllllllllllllIllIlIIlIlIIIlIl, llllllllllllllllIllIlIIlIlIIIIll.diagram, llllllllllllllllIllIlIIlIlIIIlII);
        }
    }

    private Diagram loadDiagram(InputStream llllllllllllllllIllIlIIllIIIIlII, boolean llllllllllllllllIllIlIIllIIIIllI) throws SlickException {
        try {
            InkscapeLoader llllllllllllllllIllIlIIllIIIlIII;
            DocumentBuilderFactory llllllllllllllllIllIlIIllIIlIIIl = DocumentBuilderFactory.newInstance();
            llllllllllllllllIllIlIIllIIlIIIl.setValidating(false);
            llllllllllllllllIllIlIIllIIlIIIl.setNamespaceAware(true);
            DocumentBuilder llllllllllllllllIllIlIIllIIlIIII = llllllllllllllllIllIlIIllIIlIIIl.newDocumentBuilder();
            llllllllllllllllIllIlIIllIIlIIII.setEntityResolver(new EntityResolver(){

                @Override
                public InputSource resolveEntity(String lllllllllllllllIlllllllIllIIlIll, String lllllllllllllllIlllllllIllIIlIIl) throws SAXException, IOException {
                    return new InputSource(new ByteArrayInputStream(new byte[0]));
                }
                {
                    1 lllllllllllllllIlllllllIllIlIIlI;
                }
            });
            Document llllllllllllllllIllIlIIllIIIllll = llllllllllllllllIllIlIIllIIlIIII.parse(llllllllllllllllIllIlIIllIIIIlII);
            Element llllllllllllllllIllIlIIllIIIlllI = llllllllllllllllIllIlIIllIIIllll.getDocumentElement();
            String llllllllllllllllIllIlIIllIIIllIl = llllllllllllllllIllIlIIllIIIlllI.getAttribute("width");
            while (Character.isLetter(llllllllllllllllIllIlIIllIIIllIl.charAt(llllllllllllllllIllIlIIllIIIllIl.length() - 1))) {
                llllllllllllllllIllIlIIllIIIllIl = llllllllllllllllIllIlIIllIIIllIl.substring(0, llllllllllllllllIllIlIIllIIIllIl.length() - 1);
            }
            String llllllllllllllllIllIlIIllIIIllII = llllllllllllllllIllIlIIllIIIlllI.getAttribute("height");
            while (Character.isLetter(llllllllllllllllIllIlIIllIIIllII.charAt(llllllllllllllllIllIlIIllIIIllII.length() - 1))) {
                llllllllllllllllIllIlIIllIIIllII = llllllllllllllllIllIlIIllIIIllII.substring(0, llllllllllllllllIllIlIIllIIIllII.length() - 1);
            }
            float llllllllllllllllIllIlIIllIIIlIll = Float.parseFloat(llllllllllllllllIllIlIIllIIIllIl);
            float llllllllllllllllIllIlIIllIIIlIlI = Float.parseFloat(llllllllllllllllIllIlIIllIIIllII);
            llllllllllllllllIllIlIIllIIIlIII.diagram = new Diagram(llllllllllllllllIllIlIIllIIIlIll, llllllllllllllllIllIlIIllIIIlIlI);
            if (!llllllllllllllllIllIlIIllIIIIllI) {
                llllllllllllllllIllIlIIllIIIlIlI = 0.0f;
            }
            llllllllllllllllIllIlIIllIIIlIII.loadChildren(llllllllllllllllIllIlIIllIIIlllI, Transform.createTranslateTransform(0.0f, -llllllllllllllllIllIlIIllIIIlIlI));
            return llllllllllllllllIllIlIIllIIIlIII.diagram;
        }
        catch (Exception llllllllllllllllIllIlIIllIIIlIIl) {
            throw new SlickException("Failed to load inkscape document", llllllllllllllllIllIlIIllIIIlIIl);
        }
    }

    public static Diagram load(String llllllllllllllllIllIlIIlllIIIlII, boolean llllllllllllllllIllIlIIlllIIIIll) throws SlickException {
        return InkscapeLoader.load(ResourceLoader.getResourceAsStream(llllllllllllllllIllIlIIlllIIIlII), llllllllllllllllIllIlIIlllIIIIll);
    }

    public static Diagram load(String llllllllllllllllIllIlIIllIlllIll) throws SlickException {
        return InkscapeLoader.load(ResourceLoader.getResourceAsStream(llllllllllllllllIllIlIIllIlllIll), false);
    }

    static {
        RADIAL_TRIANGULATION_LEVEL = 1;
        processors = new ArrayList();
        InkscapeLoader.addElementProcessor(new RectProcessor());
        InkscapeLoader.addElementProcessor(new EllipseProcessor());
        InkscapeLoader.addElementProcessor(new PolygonProcessor());
        InkscapeLoader.addElementProcessor(new PathProcessor());
        InkscapeLoader.addElementProcessor(new LineProcessor());
        InkscapeLoader.addElementProcessor(new GroupProcessor());
        InkscapeLoader.addElementProcessor(new DefsProcessor());
        InkscapeLoader.addElementProcessor(new UseProcessor());
    }

    private InkscapeLoader() {
        InkscapeLoader llllllllllllllllIllIlIIllIllIIlI;
    }

    public static Diagram load(InputStream llllllllllllllllIllIlIIllIllIllI, boolean llllllllllllllllIllIlIIllIllIlll) throws SlickException {
        return new InkscapeLoader().loadDiagram(llllllllllllllllIllIlIIllIllIllI, llllllllllllllllIllIlIIllIllIlll);
    }
}

