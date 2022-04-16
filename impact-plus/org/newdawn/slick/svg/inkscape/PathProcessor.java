/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.newdawn.slick.geom.Path;
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

public class PathProcessor
implements ElementProcessor {
    @Override
    public boolean handles(Element lllllllllllllllllIllIIlIllIIlIll) {
        return lllllllllllllllllIllIIlIllIIlIll.getNodeName().equals("path") && !"arc".equals(lllllllllllllllllIllIIlIllIIlIll.getAttributeNS("http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd", "type"));
    }

    @Override
    public void process(Loader lllllllllllllllllIllIIlIlllIllIl, Element lllllllllllllllllIllIIlIlllIllII, Diagram lllllllllllllllllIllIIlIlllIlIll, Transform lllllllllllllllllIllIIlIllIllllI) throws ParsingException {
        Transform lllllllllllllllllIllIIlIlllIIlll = Util.getTransform(lllllllllllllllllIllIIlIlllIllII);
        lllllllllllllllllIllIIlIlllIIlll = new Transform(lllllllllllllllllIllIIlIllIllllI, lllllllllllllllllIllIIlIlllIIlll);
        String lllllllllllllllllIllIIlIlllIIlII = lllllllllllllllllIllIIlIlllIllII.getAttribute("points");
        if (lllllllllllllllllIllIIlIlllIllII.getNodeName().equals("path")) {
            lllllllllllllllllIllIIlIlllIIlII = lllllllllllllllllIllIIlIlllIllII.getAttribute("d");
        }
        StringTokenizer lllllllllllllllllIllIIlIlllIIIll = new StringTokenizer(lllllllllllllllllIllIIlIlllIIlII, ", ");
        Path lllllllllllllllllIllIIlIlllIIIlI = PathProcessor.processPoly(lllllllllllllllllIllIIlIlllIllII, lllllllllllllllllIllIIlIlllIIIll);
        NonGeometricData lllllllllllllllllIllIIlIlllIIIIl = Util.getNonGeometricData(lllllllllllllllllIllIIlIlllIllII);
        if (lllllllllllllllllIllIIlIlllIIIlI != null) {
            Shape lllllllllllllllllIllIIlIllllIIIl = lllllllllllllllllIllIIlIlllIIIlI.transform(lllllllllllllllllIllIIlIlllIIlll);
            lllllllllllllllllIllIIlIlllIlIll.addFigure(new Figure(4, lllllllllllllllllIllIIlIllllIIIl, lllllllllllllllllIllIIlIlllIIIIl, lllllllllllllllllIllIIlIlllIIlll));
        }
    }

    public PathProcessor() {
        PathProcessor lllllllllllllllllIllIIllIllllllI;
    }

    private static Path processPoly(Element lllllllllllllllllIllIIllIIlIIllI, StringTokenizer lllllllllllllllllIllIIllIIlIIlII) throws ParsingException {
        boolean lllllllllllllllllIllIIllIIlIllII = false;
        ArrayList lllllllllllllllllIllIIllIIlIlIll = new ArrayList();
        boolean lllllllllllllllllIllIIllIIlIlIlI = false;
        boolean lllllllllllllllllIllIIllIIlIlIIl = false;
        Path lllllllllllllllllIllIIllIIlIIlll = null;
        while (lllllllllllllllllIllIIllIIlIIlII.hasMoreTokens()) {
            try {
                String lllllllllllllllllIllIIllIIllIIII = lllllllllllllllllIllIIllIIlIIlII.nextToken();
                if (lllllllllllllllllIllIIllIIllIIII.equals("L")) {
                    float lllllllllllllllllIllIIllIlIIIIIl = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                    float lllllllllllllllllIllIIllIIllllll = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                    lllllllllllllllllIllIIllIIlIIlll.lineTo(lllllllllllllllllIllIIllIlIIIIIl, lllllllllllllllllIllIIllIIllllll);
                    continue;
                }
                if (lllllllllllllllllIllIIllIIllIIII.equals("z")) {
                    lllllllllllllllllIllIIllIIlIIlll.close();
                    continue;
                }
                if (lllllllllllllllllIllIIllIIllIIII.equals("M")) {
                    if (!lllllllllllllllllIllIIllIIlIlIlI) {
                        lllllllllllllllllIllIIllIIlIlIlI = true;
                        float lllllllllllllllllIllIIllIIllllIl = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                        float lllllllllllllllllIllIIllIIlllIll = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                        lllllllllllllllllIllIIllIIlIIlll = new Path(lllllllllllllllllIllIIllIIllllIl, lllllllllllllllllIllIIllIIlllIll);
                        continue;
                    }
                    lllllllllllllllllIllIIllIIlIlIIl = true;
                    float lllllllllllllllllIllIIllIIlllIIl = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                    float lllllllllllllllllIllIIllIIllIlll = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                    lllllllllllllllllIllIIllIIlIIlll.startHole(lllllllllllllllllIllIIllIIlllIIl, lllllllllllllllllIllIIllIIllIlll);
                    continue;
                }
                if (!lllllllllllllllllIllIIllIIllIIII.equals("C")) continue;
                lllllllllllllllllIllIIllIIlIlIIl = true;
                float lllllllllllllllllIllIIllIIllIllI = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                float lllllllllllllllllIllIIllIIllIlIl = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                float lllllllllllllllllIllIIllIIllIlII = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                float lllllllllllllllllIllIIllIIllIIll = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                float lllllllllllllllllIllIIllIIllIIlI = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                float lllllllllllllllllIllIIllIIllIIIl = Float.parseFloat(lllllllllllllllllIllIIllIIlIIlII.nextToken());
                lllllllllllllllllIllIIllIIlIIlll.curveTo(lllllllllllllllllIllIIllIIllIIlI, lllllllllllllllllIllIIllIIllIIIl, lllllllllllllllllIllIIllIIllIllI, lllllllllllllllllIllIIllIIllIlIl, lllllllllllllllllIllIIllIIllIlII, lllllllllllllllllIllIIllIIllIIll);
            }
            catch (NumberFormatException lllllllllllllllllIllIIllIIlIllll) {
                throw new ParsingException(lllllllllllllllllIllIIllIIlIIllI.getAttribute("id"), "Invalid token in points list", (Throwable)lllllllllllllllllIllIIllIIlIllll);
            }
        }
        if (!lllllllllllllllllIllIIllIIlIlIIl) {
            return null;
        }
        return lllllllllllllllllIllIIllIIlIIlll;
    }
}

