/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

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

public class UseProcessor
implements ElementProcessor {
    @Override
    public boolean handles(Element lllllllllllllllllllIllIlIIIIIIlI) {
        return lllllllllllllllllllIllIlIIIIIIlI.getNodeName().equals("use");
    }

    public UseProcessor() {
        UseProcessor lllllllllllllllllllIllIlIIIIIllI;
    }

    @Override
    public void process(Loader lllllllllllllllllllIllIIllllIllI, Element lllllllllllllllllllIllIIllllIlIl, Diagram lllllllllllllllllllIllIIllllIlII, Transform lllllllllllllllllllIllIIllllIIll) throws ParsingException {
        String lllllllllllllllllllIllIIllllIIlI = lllllllllllllllllllIllIIllllIlIl.getAttributeNS("http://www.w3.org/1999/xlink", "href");
        String lllllllllllllllllllIllIIllllIIIl = Util.getAsReference(lllllllllllllllllllIllIIllllIIlI);
        Figure lllllllllllllllllllIllIIllllIIII = lllllllllllllllllllIllIIllllIlII.getFigureByID(lllllllllllllllllllIllIIllllIIIl);
        if (lllllllllllllllllllIllIIllllIIII == null) {
            throw new ParsingException(lllllllllllllllllllIllIIllllIlIl, String.valueOf(new StringBuilder().append("Unable to locate referenced element: ").append(lllllllllllllllllllIllIIllllIIIl)));
        }
        Transform lllllllllllllllllllIllIIlllIllll = Util.getTransform(lllllllllllllllllllIllIIllllIlIl);
        Transform lllllllllllllllllllIllIIlllIlllI = lllllllllllllllllllIllIIlllIllll.concatenate(lllllllllllllllllllIllIIllllIIII.getTransform());
        NonGeometricData lllllllllllllllllllIllIIlllIllIl = Util.getNonGeometricData(lllllllllllllllllllIllIIllllIlIl);
        Shape lllllllllllllllllllIllIIlllIllII = lllllllllllllllllllIllIIllllIIII.getShape().transform(lllllllllllllllllllIllIIlllIlllI);
        lllllllllllllllllllIllIIlllIllIl.addAttribute("fill", lllllllllllllllllllIllIIllllIIII.getData().getAttribute("fill"));
        lllllllllllllllllllIllIIlllIllIl.addAttribute("stroke", lllllllllllllllllllIllIIllllIIII.getData().getAttribute("stroke"));
        lllllllllllllllllllIllIIlllIllIl.addAttribute("opacity", lllllllllllllllllllIllIIllllIIII.getData().getAttribute("opacity"));
        lllllllllllllllllllIllIIlllIllIl.addAttribute("stroke-width", lllllllllllllllllllIllIIllllIIII.getData().getAttribute("stroke-width"));
        Figure lllllllllllllllllllIllIIlllIlIll = new Figure(lllllllllllllllllllIllIIllllIIII.getType(), lllllllllllllllllllIllIIlllIllII, lllllllllllllllllllIllIIlllIllIl, lllllllllllllllllllIllIIlllIlllI);
        lllllllllllllllllllIllIIllllIlII.addFigure(lllllllllllllllllllIllIIlllIlIll);
    }
}

