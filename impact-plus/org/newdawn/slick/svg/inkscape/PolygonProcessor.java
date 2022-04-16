/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Figure;
import org.newdawn.slick.svg.Loader;
import org.newdawn.slick.svg.NonGeometricData;
import org.newdawn.slick.svg.ParsingException;
import org.newdawn.slick.svg.inkscape.ElementProcessor;
import org.newdawn.slick.svg.inkscape.Util;
import org.w3c.dom.Element;

public class PolygonProcessor
implements ElementProcessor {
    @Override
    public void process(Loader lllllllllllllllIllIllllIllIIlllI, Element lllllllllllllllIllIllllIllIIIlII, Diagram lllllllllllllllIllIllllIllIIIIll, Transform lllllllllllllllIllIllllIllIIlIll) throws ParsingException {
        Transform lllllllllllllllIllIllllIllIIlIlI = Util.getTransform(lllllllllllllllIllIllllIllIIIlII);
        lllllllllllllllIllIllllIllIIlIlI = new Transform(lllllllllllllllIllIllllIllIIlIll, lllllllllllllllIllIllllIllIIlIlI);
        String lllllllllllllllIllIllllIllIIlIIl = lllllllllllllllIllIllllIllIIIlII.getAttribute("points");
        if (lllllllllllllllIllIllllIllIIIlII.getNodeName().equals("path")) {
            lllllllllllllllIllIllllIllIIlIIl = lllllllllllllllIllIllllIllIIIlII.getAttribute("d");
        }
        StringTokenizer lllllllllllllllIllIllllIllIIlIII = new StringTokenizer(lllllllllllllllIllIllllIllIIlIIl, ", ");
        Polygon lllllllllllllllIllIllllIllIIIlll = new Polygon();
        int lllllllllllllllIllIllllIllIIIllI = PolygonProcessor.processPoly(lllllllllllllllIllIllllIllIIIlll, lllllllllllllllIllIllllIllIIIlII, lllllllllllllllIllIllllIllIIlIII);
        NonGeometricData lllllllllllllllIllIllllIllIIIlIl = Util.getNonGeometricData(lllllllllllllllIllIllllIllIIIlII);
        if (lllllllllllllllIllIllllIllIIIllI > 3) {
            Shape lllllllllllllllIllIllllIllIlIIII = lllllllllllllllIllIllllIllIIIlll.transform(lllllllllllllllIllIllllIllIIlIlI);
            lllllllllllllllIllIllllIllIIIIll.addFigure(new Figure(5, lllllllllllllllIllIllllIllIlIIII, lllllllllllllllIllIllllIllIIIlIl, lllllllllllllllIllIllllIllIIlIlI));
        }
    }

    @Override
    public boolean handles(Element lllllllllllllllIllIllllIlIlllIII) {
        if (lllllllllllllllIllIllllIlIlllIII.getNodeName().equals("polygon")) {
            return true;
        }
        return lllllllllllllllIllIllllIlIlllIII.getNodeName().equals("path") && !"arc".equals(lllllllllllllllIllIllllIlIlllIII.getAttributeNS("http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd", "type"));
    }

    private static int processPoly(Polygon lllllllllllllllIllIllllIlllIllIl, Element lllllllllllllllIllIllllIlllIllII, StringTokenizer lllllllllllllllIllIllllIlllIIlII) throws ParsingException {
        int lllllllllllllllIllIllllIlllIlIlI = 0;
        ArrayList lllllllllllllllIllIllllIlllIlIIl = new ArrayList();
        boolean lllllllllllllllIllIllllIlllIlIII = false;
        boolean lllllllllllllllIllIllllIlllIIlll = false;
        while (lllllllllllllllIllIllllIlllIIlII.hasMoreTokens()) {
            String lllllllllllllllIllIllllIllllIIII = lllllllllllllllIllIllllIlllIIlII.nextToken();
            if (lllllllllllllllIllIllllIllllIIII.equals("L")) continue;
            if (lllllllllllllllIllIllllIllllIIII.equals("z")) {
                lllllllllllllllIllIllllIlllIIlll = true;
                break;
            }
            if (lllllllllllllllIllIllllIllllIIII.equals("M")) {
                if (!lllllllllllllllIllIllllIlllIlIII) {
                    lllllllllllllllIllIllllIlllIlIII = true;
                    continue;
                }
                return 0;
            }
            if (lllllllllllllllIllIllllIllllIIII.equals("C")) {
                return 0;
            }
            String lllllllllllllllIllIllllIlllIllll = lllllllllllllllIllIllllIllllIIII;
            String lllllllllllllllIllIllllIlllIlllI = lllllllllllllllIllIllllIlllIIlII.nextToken();
            try {
                float lllllllllllllllIllIllllIllllIIll = Float.parseFloat(lllllllllllllllIllIllllIlllIllll);
                float lllllllllllllllIllIllllIllllIIlI = Float.parseFloat(lllllllllllllllIllIllllIlllIlllI);
                lllllllllllllllIllIllllIlllIllIl.addPoint(lllllllllllllllIllIllllIllllIIll, lllllllllllllllIllIllllIllllIIlI);
                ++lllllllllllllllIllIllllIlllIlIlI;
            }
            catch (NumberFormatException lllllllllllllllIllIllllIllllIIIl) {
                throw new ParsingException(lllllllllllllllIllIllllIlllIllII.getAttribute("id"), "Invalid token in points list", (Throwable)lllllllllllllllIllIllllIllllIIIl);
            }
        }
        lllllllllllllllIllIllllIlllIllIl.setClosed(lllllllllllllllIllIllllIlllIIlll);
        return lllllllllllllllIllIllllIlllIlIlI;
    }

    public PolygonProcessor() {
        PolygonProcessor lllllllllllllllIllIlllllIIIIIIIl;
    }
}

