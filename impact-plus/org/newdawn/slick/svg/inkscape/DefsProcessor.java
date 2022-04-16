/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Gradient;
import org.newdawn.slick.svg.Loader;
import org.newdawn.slick.svg.ParsingException;
import org.newdawn.slick.svg.inkscape.ElementProcessor;
import org.newdawn.slick.svg.inkscape.Util;
import org.newdawn.slick.util.Log;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DefsProcessor
implements ElementProcessor {
    private int stringLength(String llllllllllllllllIlIlllIIIIllIllI) {
        if (llllllllllllllllIlIlllIIIIllIllI == null) {
            return 0;
        }
        return llllllllllllllllIlIlllIIIIllIllI.length();
    }

    public DefsProcessor() {
        DefsProcessor llllllllllllllllIlIlllIIlIIlIIII;
    }

    @Override
    public boolean handles(Element llllllllllllllllIlIlllIIlIIIllIl) {
        return llllllllllllllllIlIlllIIlIIIllIl.getNodeName().equals("defs");
    }

    @Override
    public void process(Loader llllllllllllllllIlIlllIIIlIlIlIl, Element llllllllllllllllIlIlllIIIlIlIlII, Diagram llllllllllllllllIlIlllIIIlIlIIll, Transform llllllllllllllllIlIlllIIIlIlIIlI) throws ParsingException {
        DefsProcessor llllllllllllllllIlIlllIIIlIIllIl;
        NodeList llllllllllllllllIlIlllIIIlIlIIIl = llllllllllllllllIlIlllIIIlIlIlII.getElementsByTagName("pattern");
        for (int llllllllllllllllIlIlllIIIlllIIlI = 0; llllllllllllllllIlIlllIIIlllIIlI < llllllllllllllllIlIlllIIIlIlIIIl.getLength(); ++llllllllllllllllIlIlllIIIlllIIlI) {
            Element llllllllllllllllIlIlllIIIlllIlll = (Element)llllllllllllllllIlIlllIIIlIlIIIl.item(llllllllllllllllIlIlllIIIlllIIlI);
            NodeList llllllllllllllllIlIlllIIIlllIllI = llllllllllllllllIlIlllIIIlllIlll.getElementsByTagName("image");
            if (llllllllllllllllIlIlllIIIlllIllI.getLength() == 0) {
                Log.warn("Pattern 1981 does not specify an image. Only image patterns are supported.");
                continue;
            }
            Element llllllllllllllllIlIlllIIIlllIlIl = (Element)llllllllllllllllIlIlllIIIlllIllI.item(0);
            String llllllllllllllllIlIlllIIIlllIlII = llllllllllllllllIlIlllIIIlllIlll.getAttribute("id");
            String llllllllllllllllIlIlllIIIlllIIll = llllllllllllllllIlIlllIIIlllIlIl.getAttributeNS("http://www.w3.org/1999/xlink", "href");
            llllllllllllllllIlIlllIIIlIlIIll.addPatternDef(llllllllllllllllIlIlllIIIlllIlII, llllllllllllllllIlIlllIIIlllIIll);
        }
        NodeList llllllllllllllllIlIlllIIIlIlIIII = llllllllllllllllIlIlllIIIlIlIlII.getElementsByTagName("linearGradient");
        ArrayList<Gradient> llllllllllllllllIlIlllIIIlIIllll = new ArrayList<Gradient>();
        for (int llllllllllllllllIlIlllIIIllIIlIl = 0; llllllllllllllllIlIlllIIIllIIlIl < llllllllllllllllIlIlllIIIlIlIIII.getLength(); ++llllllllllllllllIlIlllIIIllIIlIl) {
            String llllllllllllllllIlIlllIIIllIIllI;
            Element llllllllllllllllIlIlllIIIllIlIIl = (Element)llllllllllllllllIlIlllIIIlIlIIII.item(llllllllllllllllIlIlllIIIllIIlIl);
            String llllllllllllllllIlIlllIIIllIlIII = llllllllllllllllIlIlllIIIllIlIIl.getAttribute("id");
            Gradient llllllllllllllllIlIlllIIIllIIlll = new Gradient(llllllllllllllllIlIlllIIIllIlIII, false);
            llllllllllllllllIlIlllIIIllIIlll.setTransform(Util.getTransform(llllllllllllllllIlIlllIIIllIlIIl, "gradientTransform"));
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("x1")) > 0) {
                llllllllllllllllIlIlllIIIllIIlll.setX1(Float.parseFloat(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("x1")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("x2")) > 0) {
                llllllllllllllllIlIlllIIIllIIlll.setX2(Float.parseFloat(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("x2")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("y1")) > 0) {
                llllllllllllllllIlIlllIIIllIIlll.setY1(Float.parseFloat(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("y1")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("y2")) > 0) {
                llllllllllllllllIlIlllIIIllIIlll.setY2(Float.parseFloat(llllllllllllllllIlIlllIIIllIlIIl.getAttribute("y2")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIllIIllI = llllllllllllllllIlIlllIIIllIlIIl.getAttributeNS("http://www.w3.org/1999/xlink", "href")) > 0) {
                llllllllllllllllIlIlllIIIllIIlll.reference(llllllllllllllllIlIlllIIIllIIllI.substring(1));
                llllllllllllllllIlIlllIIIlIIllll.add(llllllllllllllllIlIlllIIIllIIlll);
            } else {
                NodeList llllllllllllllllIlIlllIIIllIlIlI = llllllllllllllllIlIlllIIIllIlIIl.getElementsByTagName("stop");
                for (int llllllllllllllllIlIlllIIIllIlIll = 0; llllllllllllllllIlIlllIIIllIlIll < llllllllllllllllIlIlllIIIllIlIlI.getLength(); ++llllllllllllllllIlIlllIIIllIlIll) {
                    Element llllllllllllllllIlIlllIIIlllIIIl = (Element)llllllllllllllllIlIlllIIIllIlIlI.item(llllllllllllllllIlIlllIIIllIlIll);
                    float llllllllllllllllIlIlllIIIlllIIII = Float.parseFloat(llllllllllllllllIlIlllIIIlllIIIl.getAttribute("offset"));
                    String llllllllllllllllIlIlllIIIllIllll = Util.extractStyle(llllllllllllllllIlIlllIIIlllIIIl.getAttribute("style"), "stop-color");
                    String llllllllllllllllIlIlllIIIllIlllI = Util.extractStyle(llllllllllllllllIlIlllIIIlllIIIl.getAttribute("style"), "stop-opacity");
                    int llllllllllllllllIlIlllIIIllIllIl = Integer.parseInt(llllllllllllllllIlIlllIIIllIllll.substring(1), 16);
                    Color llllllllllllllllIlIlllIIIllIllII = new Color(llllllllllllllllIlIlllIIIllIllIl);
                    llllllllllllllllIlIlllIIIllIllII.a = Float.parseFloat(llllllllllllllllIlIlllIIIllIlllI);
                    llllllllllllllllIlIlllIIIllIIlll.addStep(llllllllllllllllIlIlllIIIlllIIII, llllllllllllllllIlIlllIIIllIllII);
                }
                llllllllllllllllIlIlllIIIllIIlll.getImage();
            }
            llllllllllllllllIlIlllIIIlIlIIll.addGradient(llllllllllllllllIlIlllIIIllIlIII, llllllllllllllllIlIlllIIIllIIlll);
        }
        NodeList llllllllllllllllIlIlllIIIlIIlllI = llllllllllllllllIlIlllIIIlIlIlII.getElementsByTagName("radialGradient");
        for (int llllllllllllllllIlIlllIIIlIllIII = 0; llllllllllllllllIlIlllIIIlIllIII < llllllllllllllllIlIlllIIIlIIlllI.getLength(); ++llllllllllllllllIlIlllIIIlIllIII) {
            String llllllllllllllllIlIlllIIIlIllIIl;
            Element llllllllllllllllIlIlllIIIlIlllII = (Element)llllllllllllllllIlIlllIIIlIIlllI.item(llllllllllllllllIlIlllIIIlIllIII);
            String llllllllllllllllIlIlllIIIlIllIll = llllllllllllllllIlIlllIIIlIlllII.getAttribute("id");
            Gradient llllllllllllllllIlIlllIIIlIllIlI = new Gradient(llllllllllllllllIlIlllIIIlIllIll, true);
            llllllllllllllllIlIlllIIIlIllIlI.setTransform(Util.getTransform(llllllllllllllllIlIlllIIIlIlllII, "gradientTransform"));
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIlIlllII.getAttribute("cx")) > 0) {
                llllllllllllllllIlIlllIIIlIllIlI.setX1(Float.parseFloat(llllllllllllllllIlIlllIIIlIlllII.getAttribute("cx")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIlIlllII.getAttribute("cy")) > 0) {
                llllllllllllllllIlIlllIIIlIllIlI.setY1(Float.parseFloat(llllllllllllllllIlIlllIIIlIlllII.getAttribute("cy")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIlIlllII.getAttribute("fx")) > 0) {
                llllllllllllllllIlIlllIIIlIllIlI.setX2(Float.parseFloat(llllllllllllllllIlIlllIIIlIlllII.getAttribute("fx")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIlIlllII.getAttribute("fy")) > 0) {
                llllllllllllllllIlIlllIIIlIllIlI.setY2(Float.parseFloat(llllllllllllllllIlIlllIIIlIlllII.getAttribute("fy")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIlIlllII.getAttribute("r")) > 0) {
                llllllllllllllllIlIlllIIIlIllIlI.setR(Float.parseFloat(llllllllllllllllIlIlllIIIlIlllII.getAttribute("r")));
            }
            if (llllllllllllllllIlIlllIIIlIIllIl.stringLength(llllllllllllllllIlIlllIIIlIllIIl = llllllllllllllllIlIlllIIIlIlllII.getAttributeNS("http://www.w3.org/1999/xlink", "href")) > 0) {
                llllllllllllllllIlIlllIIIlIllIlI.reference(llllllllllllllllIlIlllIIIlIllIIl.substring(1));
                llllllllllllllllIlIlllIIIlIIllll.add(llllllllllllllllIlIlllIIIlIllIlI);
            } else {
                NodeList llllllllllllllllIlIlllIIIlIlllIl = llllllllllllllllIlIlllIIIlIlllII.getElementsByTagName("stop");
                for (int llllllllllllllllIlIlllIIIlIllllI = 0; llllllllllllllllIlIlllIIIlIllllI < llllllllllllllllIlIlllIIIlIlllIl.getLength(); ++llllllllllllllllIlIlllIIIlIllllI) {
                    Element llllllllllllllllIlIlllIIIllIIlII = (Element)llllllllllllllllIlIlllIIIlIlllIl.item(llllllllllllllllIlIlllIIIlIllllI);
                    float llllllllllllllllIlIlllIIIllIIIll = Float.parseFloat(llllllllllllllllIlIlllIIIllIIlII.getAttribute("offset"));
                    String llllllllllllllllIlIlllIIIllIIIlI = Util.extractStyle(llllllllllllllllIlIlllIIIllIIlII.getAttribute("style"), "stop-color");
                    String llllllllllllllllIlIlllIIIllIIIIl = Util.extractStyle(llllllllllllllllIlIlllIIIllIIlII.getAttribute("style"), "stop-opacity");
                    int llllllllllllllllIlIlllIIIllIIIII = Integer.parseInt(llllllllllllllllIlIlllIIIllIIIlI.substring(1), 16);
                    Color llllllllllllllllIlIlllIIIlIlllll = new Color(llllllllllllllllIlIlllIIIllIIIII);
                    llllllllllllllllIlIlllIIIlIlllll.a = Float.parseFloat(llllllllllllllllIlIlllIIIllIIIIl);
                    llllllllllllllllIlIlllIIIlIllIlI.addStep(llllllllllllllllIlIlllIIIllIIIll, llllllllllllllllIlIlllIIIlIlllll);
                }
                llllllllllllllllIlIlllIIIlIllIlI.getImage();
            }
            llllllllllllllllIlIlllIIIlIlIIll.addGradient(llllllllllllllllIlIlllIIIlIllIll, llllllllllllllllIlIlllIIIlIllIlI);
        }
        for (int llllllllllllllllIlIlllIIIlIlIlll = 0; llllllllllllllllIlIlllIIIlIlIlll < llllllllllllllllIlIlllIIIlIIllll.size(); ++llllllllllllllllIlIlllIIIlIlIlll) {
            ((Gradient)llllllllllllllllIlIlllIIIlIIllll.get(llllllllllllllllIlIlllIIIlIlIlll)).resolve(llllllllllllllllIlIlllIIIlIlIIll);
            ((Gradient)llllllllllllllllIlIlllIIIlIIllll.get(llllllllllllllllIlIlllIIIlIlIlll)).getImage();
        }
    }
}

