/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import java.util.StringTokenizer;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Figure;
import org.newdawn.slick.svg.Loader;
import org.newdawn.slick.svg.NonGeometricData;
import org.newdawn.slick.svg.ParsingException;
import org.newdawn.slick.svg.inkscape.ElementProcessor;
import org.newdawn.slick.svg.inkscape.Util;
import org.w3c.dom.Element;

public class LineProcessor
implements ElementProcessor {
    public LineProcessor() {
        LineProcessor llllllllllllllllIlIllIIIIlllIllI;
    }

    private static int processPoly(Polygon llllllllllllllllIlIllIIIIllIIIlI, Element llllllllllllllllIlIllIIIIllIIlIl, StringTokenizer llllllllllllllllIlIllIIIIllIIIII) throws ParsingException {
        int llllllllllllllllIlIllIIIIllIIIll = 0;
        while (llllllllllllllllIlIllIIIIllIIIII.hasMoreTokens()) {
            String llllllllllllllllIlIllIIIIllIlIIl = llllllllllllllllIlIllIIIIllIIIII.nextToken();
            if (llllllllllllllllIlIllIIIIllIlIIl.equals("L")) continue;
            if (llllllllllllllllIlIllIIIIllIlIIl.equals("z")) break;
            if (llllllllllllllllIlIllIIIIllIlIIl.equals("M")) continue;
            if (llllllllllllllllIlIllIIIIllIlIIl.equals("C")) {
                return 0;
            }
            String llllllllllllllllIlIllIIIIllIlIII = llllllllllllllllIlIllIIIIllIlIIl;
            String llllllllllllllllIlIllIIIIllIIlll = llllllllllllllllIlIllIIIIllIIIII.nextToken();
            try {
                float llllllllllllllllIlIllIIIIllIllII = Float.parseFloat(llllllllllllllllIlIllIIIIllIlIII);
                float llllllllllllllllIlIllIIIIllIlIll = Float.parseFloat(llllllllllllllllIlIllIIIIllIIlll);
                llllllllllllllllIlIllIIIIllIIIlI.addPoint(llllllllllllllllIlIllIIIIllIllII, llllllllllllllllIlIllIIIIllIlIll);
                ++llllllllllllllllIlIllIIIIllIIIll;
            }
            catch (NumberFormatException llllllllllllllllIlIllIIIIllIlIlI) {
                throw new ParsingException(llllllllllllllllIlIllIIIIllIIlIl.getAttribute("id"), "Invalid token in points list", (Throwable)llllllllllllllllIlIllIIIIllIlIlI);
            }
        }
        return llllllllllllllllIlIllIIIIllIIIll;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void process(Loader llllllllllllllllIlIllIIIIlIIIIIl, Element llllllllllllllllIlIllIIIIIllIlII, Diagram llllllllllllllllIlIllIIIIIllllll, Transform llllllllllllllllIlIllIIIIIlllllI) throws ParsingException {
        void llllllllllllllllIlIllIIIIIlllIIl;
        void llllllllllllllllIlIllIIIIIlllIlI;
        void llllllllllllllllIlIllIIIIIlllIll;
        void llllllllllllllllIlIllIIIIIllllII;
        Transform llllllllllllllllIlIllIIIIIllllIl = Util.getTransform(llllllllllllllllIlIllIIIIIllIlII);
        llllllllllllllllIlIllIIIIIllllIl = new Transform(llllllllllllllllIlIllIIIIIlllllI, llllllllllllllllIlIllIIIIIllllIl);
        if (llllllllllllllllIlIllIIIIIllIlII.getNodeName().equals("line")) {
            float llllllllllllllllIlIllIIIIlIIllIl = Float.parseFloat(llllllllllllllllIlIllIIIIIllIlII.getAttribute("x1"));
            float llllllllllllllllIlIllIIIIlIIlIll = Float.parseFloat(llllllllllllllllIlIllIIIIIllIlII.getAttribute("x2"));
            float llllllllllllllllIlIllIIIIlIIllII = Float.parseFloat(llllllllllllllllIlIllIIIIIllIlII.getAttribute("y1"));
            float llllllllllllllllIlIllIIIIlIIlIlI = Float.parseFloat(llllllllllllllllIlIllIIIIIllIlII.getAttribute("y2"));
        } else {
            Polygon llllllllllllllllIlIllIIIIlIIIIll = new Polygon();
            String llllllllllllllllIlIllIIIIlIIIlIl = llllllllllllllllIlIllIIIIIllIlII.getAttribute("d");
            StringTokenizer llllllllllllllllIlIllIIIIlIIIlII = new StringTokenizer(llllllllllllllllIlIllIIIIlIIIlIl, ", ");
            if (LineProcessor.processPoly(llllllllllllllllIlIllIIIIlIIIIll, llllllllllllllllIlIllIIIIIllIlII, llllllllllllllllIlIllIIIIlIIIlII) == 2) {
                float llllllllllllllllIlIllIIIIlIIlIIl = llllllllllllllllIlIllIIIIlIIIIll.getPoint(0)[0];
                float llllllllllllllllIlIllIIIIlIIlIII = llllllllllllllllIlIllIIIIlIIIIll.getPoint(0)[1];
                float llllllllllllllllIlIllIIIIlIIIlll = llllllllllllllllIlIllIIIIlIIIIll.getPoint(1)[0];
                float llllllllllllllllIlIllIIIIlIIIllI = llllllllllllllllIlIllIIIIlIIIIll.getPoint(1)[1];
            } else {
                return;
            }
        }
        float[] llllllllllllllllIlIllIIIIIlllIII = new float[]{llllllllllllllllIlIllIIIIIllllII, llllllllllllllllIlIllIIIIIlllIll, llllllllllllllllIlIllIIIIIlllIlI, llllllllllllllllIlIllIIIIIlllIIl};
        float[] llllllllllllllllIlIllIIIIIllIlll = new float[4];
        llllllllllllllllIlIllIIIIIllllIl.transform(llllllllllllllllIlIllIIIIIlllIII, 0, llllllllllllllllIlIllIIIIIllIlll, 0, 2);
        Line llllllllllllllllIlIllIIIIIllIllI = new Line(llllllllllllllllIlIllIIIIIllIlll[0], llllllllllllllllIlIllIIIIIllIlll[1], llllllllllllllllIlIllIIIIIllIlll[2], llllllllllllllllIlIllIIIIIllIlll[3]);
        NonGeometricData llllllllllllllllIlIllIIIIIllIlIl = Util.getNonGeometricData(llllllllllllllllIlIllIIIIIllIlII);
        llllllllllllllllIlIllIIIIIllIlIl.addAttribute("x1", String.valueOf(new StringBuilder().append("").append((float)llllllllllllllllIlIllIIIIIllllII)));
        llllllllllllllllIlIllIIIIIllIlIl.addAttribute("x2", String.valueOf(new StringBuilder().append("").append((float)llllllllllllllllIlIllIIIIIlllIlI)));
        llllllllllllllllIlIllIIIIIllIlIl.addAttribute("y1", String.valueOf(new StringBuilder().append("").append((float)llllllllllllllllIlIllIIIIIlllIll)));
        llllllllllllllllIlIllIIIIIllIlIl.addAttribute("y2", String.valueOf(new StringBuilder().append("").append((float)llllllllllllllllIlIllIIIIIlllIIl)));
        llllllllllllllllIlIllIIIIIllllll.addFigure(new Figure(2, llllllllllllllllIlIllIIIIIllIllI, llllllllllllllllIlIllIIIIIllIlIl, llllllllllllllllIlIllIIIIIllllIl));
    }

    @Override
    public boolean handles(Element llllllllllllllllIlIllIIIIIlIIllI) {
        if (llllllllllllllllIlIllIIIIIlIIllI.getNodeName().equals("line")) {
            return true;
        }
        return llllllllllllllllIlIllIIIIIlIIllI.getNodeName().equals("path") && !"arc".equals(llllllllllllllllIlIllIIIIIlIIllI.getAttributeNS("http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd", "type"));
    }
}

