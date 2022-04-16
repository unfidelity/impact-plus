/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import org.newdawn.slick.geom.Rectangle;
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

public class RectProcessor
implements ElementProcessor {
    @Override
    public boolean handles(Element llllllllllllllllIlIlIlIIIIIIllIl) {
        return llllllllllllllllIlIlIlIIIIIIllIl.getNodeName().equals("rect");
    }

    public RectProcessor() {
        RectProcessor llllllllllllllllIlIlIlIIIlIlIIII;
    }

    @Override
    public void process(Loader llllllllllllllllIlIlIlIIIIlIlIlI, Element llllllllllllllllIlIlIlIIIIIllIlI, Diagram llllllllllllllllIlIlIlIIIIlIIllI, Transform llllllllllllllllIlIlIlIIIIIllIII) throws ParsingException {
        Transform llllllllllllllllIlIlIlIIIIlIIIll = Util.getTransform(llllllllllllllllIlIlIlIIIIIllIlI);
        llllllllllllllllIlIlIlIIIIlIIIll = new Transform(llllllllllllllllIlIlIlIIIIIllIII, llllllllllllllllIlIlIlIIIIlIIIll);
        float llllllllllllllllIlIlIlIIIIlIIIIl = Float.parseFloat(llllllllllllllllIlIlIlIIIIIllIlI.getAttribute("width"));
        float llllllllllllllllIlIlIlIIIIlIIIII = Float.parseFloat(llllllllllllllllIlIlIlIIIIIllIlI.getAttribute("height"));
        float llllllllllllllllIlIlIlIIIIIlllll = Float.parseFloat(llllllllllllllllIlIlIlIIIIIllIlI.getAttribute("x"));
        float llllllllllllllllIlIlIlIIIIIllllI = Float.parseFloat(llllllllllllllllIlIlIlIIIIIllIlI.getAttribute("y"));
        Rectangle llllllllllllllllIlIlIlIIIIIlllIl = new Rectangle(llllllllllllllllIlIlIlIIIIIlllll, llllllllllllllllIlIlIlIIIIIllllI, llllllllllllllllIlIlIlIIIIlIIIIl + 1.0f, llllllllllllllllIlIlIlIIIIlIIIII + 1.0f);
        Shape llllllllllllllllIlIlIlIIIIIlllII = llllllllllllllllIlIlIlIIIIIlllIl.transform(llllllllllllllllIlIlIlIIIIlIIIll);
        NonGeometricData llllllllllllllllIlIlIlIIIIIllIll = Util.getNonGeometricData(llllllllllllllllIlIlIlIIIIIllIlI);
        llllllllllllllllIlIlIlIIIIIllIll.addAttribute("width", String.valueOf(new StringBuilder().append("").append(llllllllllllllllIlIlIlIIIIlIIIIl)));
        llllllllllllllllIlIlIlIIIIIllIll.addAttribute("height", String.valueOf(new StringBuilder().append("").append(llllllllllllllllIlIlIlIIIIlIIIII)));
        llllllllllllllllIlIlIlIIIIIllIll.addAttribute("x", String.valueOf(new StringBuilder().append("").append(llllllllllllllllIlIlIlIIIIIlllll)));
        llllllllllllllllIlIlIlIIIIIllIll.addAttribute("y", String.valueOf(new StringBuilder().append("").append(llllllllllllllllIlIlIlIIIIIllllI)));
        llllllllllllllllIlIlIlIIIIlIIllI.addFigure(new Figure(3, llllllllllllllllIlIlIlIIIIIlllII, llllllllllllllllIlIlIlIIIIIllIll, llllllllllllllllIlIlIlIIIIlIIIll));
    }
}

