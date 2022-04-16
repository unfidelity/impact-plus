/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import org.newdawn.slick.geom.Ellipse;
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

public class EllipseProcessor
implements ElementProcessor {
    @Override
    public boolean handles(Element lllIIlIIllIlIlI) {
        if (lllIIlIIllIlIlI.getNodeName().equals("ellipse")) {
            return true;
        }
        return lllIIlIIllIlIlI.getNodeName().equals("path") && "arc".equals(lllIIlIIllIlIlI.getAttributeNS("http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd", "type"));
    }

    @Override
    public void process(Loader lllIIlIlIIlllII, Element lllIIlIlIIlIIII, Diagram lllIIlIlIIIllll, Transform lllIIlIlIIllIIl) throws ParsingException {
        Transform lllIIlIlIIllIII = Util.getTransform(lllIIlIlIIlIIII);
        lllIIlIlIIllIII = new Transform(lllIIlIlIIllIIl, lllIIlIlIIllIII);
        float lllIIlIlIIlIlll = Util.getFloatAttribute(lllIIlIlIIlIIII, "cx");
        float lllIIlIlIIlIllI = Util.getFloatAttribute(lllIIlIlIIlIIII, "cy");
        float lllIIlIlIIlIlIl = Util.getFloatAttribute(lllIIlIlIIlIIII, "rx");
        float lllIIlIlIIlIlII = Util.getFloatAttribute(lllIIlIlIIlIIII, "ry");
        Ellipse lllIIlIlIIlIIll = new Ellipse(lllIIlIlIIlIlll, lllIIlIlIIlIllI, lllIIlIlIIlIlIl, lllIIlIlIIlIlII);
        Shape lllIIlIlIIlIIlI = lllIIlIlIIlIIll.transform(lllIIlIlIIllIII);
        NonGeometricData lllIIlIlIIlIIIl = Util.getNonGeometricData(lllIIlIlIIlIIII);
        lllIIlIlIIlIIIl.addAttribute("cx", String.valueOf(new StringBuilder().append("").append(lllIIlIlIIlIlll)));
        lllIIlIlIIlIIIl.addAttribute("cy", String.valueOf(new StringBuilder().append("").append(lllIIlIlIIlIllI)));
        lllIIlIlIIlIIIl.addAttribute("rx", String.valueOf(new StringBuilder().append("").append(lllIIlIlIIlIlIl)));
        lllIIlIlIIlIIIl.addAttribute("ry", String.valueOf(new StringBuilder().append("").append(lllIIlIlIIlIlII)));
        lllIIlIlIIIllll.addFigure(new Figure(1, lllIIlIlIIlIIlI, lllIIlIlIIlIIIl, lllIIlIlIIllIII));
    }

    public EllipseProcessor() {
        EllipseProcessor lllIIlIllIIIIll;
    }
}

