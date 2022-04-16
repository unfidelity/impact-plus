/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import java.util.StringTokenizer;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.NonGeometricData;
import org.newdawn.slick.svg.ParsingException;
import org.newdawn.slick.svg.inkscape.InkscapeNonGeometricData;
import org.w3c.dom.Element;

public class Util {
    public static final /* synthetic */ String INKSCAPE;
    public static final /* synthetic */ String XLINK;
    public static final /* synthetic */ String SODIPODI;

    static {
        SODIPODI = "http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd";
        XLINK = "http://www.w3.org/1999/xlink";
        INKSCAPE = "http://www.inkscape.org/namespaces/inkscape";
    }

    static Transform getTransform(Element lllllIlIIlIlllI, String lllllIlIIllIIII) {
        String lllllIlIIlIllll = lllllIlIIlIlllI.getAttribute(lllllIlIIllIIII);
        if (lllllIlIIlIllll == null) {
            return new Transform();
        }
        if (lllllIlIIlIllll.equals("")) {
            return new Transform();
        }
        if (lllllIlIIlIllll.startsWith("translate")) {
            lllllIlIIlIllll = lllllIlIIlIllll.substring(0, lllllIlIIlIllll.length() - 1);
            lllllIlIIlIllll = lllllIlIIlIllll.substring("translate(".length());
            StringTokenizer lllllIlIIlllIII = new StringTokenizer(lllllIlIIlIllll, ", ");
            float lllllIlIIllIlll = Float.parseFloat(lllllIlIIlllIII.nextToken());
            float lllllIlIIllIllI = Float.parseFloat(lllllIlIIlllIII.nextToken());
            return Transform.createTranslateTransform(lllllIlIIllIlll, lllllIlIIllIllI);
        }
        if (lllllIlIIlIllll.startsWith("matrix")) {
            float[] lllllIlIIllIlII = new float[6];
            lllllIlIIlIllll = lllllIlIIlIllll.substring(0, lllllIlIIlIllll.length() - 1);
            lllllIlIIlIllll = lllllIlIIlIllll.substring("matrix(".length());
            StringTokenizer lllllIlIIllIIll = new StringTokenizer(lllllIlIIlIllll, ", ");
            float[] lllllIlIIllIIlI = new float[6];
            for (int lllllIlIIllIlIl = 0; lllllIlIIllIlIl < lllllIlIIllIIlI.length; ++lllllIlIIllIlIl) {
                lllllIlIIllIIlI[lllllIlIIllIlIl] = Float.parseFloat(lllllIlIIllIIll.nextToken());
            }
            lllllIlIIllIlII[0] = lllllIlIIllIIlI[0];
            lllllIlIIllIlII[1] = lllllIlIIllIIlI[2];
            lllllIlIIllIlII[2] = lllllIlIIllIIlI[4];
            lllllIlIIllIlII[3] = lllllIlIIllIIlI[1];
            lllllIlIIllIlII[4] = lllllIlIIllIIlI[3];
            lllllIlIIllIlII[5] = lllllIlIIllIIlI[5];
            return new Transform(lllllIlIIllIlII);
        }
        return new Transform();
    }

    static String extractStyle(String lllllIlIlIIlIlI, String lllllIlIlIIIllI) {
        if (lllllIlIlIIlIlI == null) {
            return "";
        }
        StringTokenizer lllllIlIlIIlIII = new StringTokenizer(lllllIlIlIIlIlI, ";");
        while (lllllIlIlIIlIII.hasMoreTokens()) {
            String lllllIlIlIIllII = lllllIlIlIIlIII.nextToken();
            String lllllIlIlIIlIll = lllllIlIlIIllII.substring(0, lllllIlIlIIllII.indexOf(58));
            if (!lllllIlIlIIlIll.equals(lllllIlIlIIIllI)) continue;
            return lllllIlIlIIllII.substring(lllllIlIlIIllII.indexOf(58) + 1);
        }
        return "";
    }

    static Transform getTransform(Element lllllIlIlIIIIII) {
        return Util.getTransform(lllllIlIlIIIIII, "transform");
    }

    public Util() {
        Util lllllIlIllIlllI;
    }

    public static String getAsReference(String lllllIlIIIllIlI) {
        if (lllllIlIIIllIlI.length() < 2) {
            return "";
        }
        lllllIlIIIllIlI = lllllIlIIIllIlI.substring(1, lllllIlIIIllIlI.length());
        return lllllIlIIIllIlI;
    }

    static NonGeometricData getNonGeometricData(Element lllllIlIllIIllI) {
        String lllllIlIllIlIII = Util.getMetaData(lllllIlIllIIllI);
        InkscapeNonGeometricData lllllIlIllIIlll = new InkscapeNonGeometricData(lllllIlIllIlIII, lllllIlIllIIllI);
        lllllIlIllIIlll.addAttribute("id", lllllIlIllIIllI.getAttribute("id"));
        lllllIlIllIIlll.addAttribute("fill", Util.getStyle(lllllIlIllIIllI, "fill"));
        lllllIlIllIIlll.addAttribute("stroke", Util.getStyle(lllllIlIllIIllI, "stroke"));
        lllllIlIllIIlll.addAttribute("opacity", Util.getStyle(lllllIlIllIIllI, "opacity"));
        lllllIlIllIIlll.addAttribute("stroke-dasharray", Util.getStyle(lllllIlIllIIllI, "stroke-dasharray"));
        lllllIlIllIIlll.addAttribute("stroke-dashoffset", Util.getStyle(lllllIlIllIIllI, "stroke-dashoffset"));
        lllllIlIllIIlll.addAttribute("stroke-miterlimit", Util.getStyle(lllllIlIllIIllI, "stroke-miterlimit"));
        lllllIlIllIIlll.addAttribute("stroke-opacity", Util.getStyle(lllllIlIllIIllI, "stroke-opacity"));
        lllllIlIllIIlll.addAttribute("stroke-width", Util.getStyle(lllllIlIllIIllI, "stroke-width"));
        return lllllIlIllIIlll;
    }

    static String getMetaData(Element lllllIlIllIIIIl) {
        String lllllIlIllIIIII = lllllIlIllIIIIl.getAttributeNS("http://www.inkscape.org/namespaces/inkscape", "label");
        if (lllllIlIllIIIII != null && !lllllIlIllIIIII.equals("")) {
            return lllllIlIllIIIII;
        }
        return lllllIlIllIIIIl.getAttribute("id");
    }

    static float getFloatAttribute(Element lllllIlIIIlllll, String lllllIlIIIllllI) throws ParsingException {
        String lllllIlIIlIIIII = lllllIlIIIlllll.getAttribute(lllllIlIIIllllI);
        if (lllllIlIIlIIIII == null || lllllIlIIlIIIII.equals("")) {
            lllllIlIIlIIIII = lllllIlIIIlllll.getAttributeNS("http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd", lllllIlIIIllllI);
        }
        try {
            return Float.parseFloat(lllllIlIIlIIIII);
        }
        catch (NumberFormatException lllllIlIIlIIIll) {
            throw new ParsingException(lllllIlIIIlllll, String.valueOf(new StringBuilder().append("Invalid value for: ").append(lllllIlIIIllllI)), (Throwable)lllllIlIIlIIIll);
        }
    }

    static String getStyle(Element lllllIlIlIllIIl, String lllllIlIlIlIlII) {
        String lllllIlIlIlIlll = lllllIlIlIllIIl.getAttribute(lllllIlIlIlIlII);
        if (lllllIlIlIlIlll != null && lllllIlIlIlIlll.length() > 0) {
            return lllllIlIlIlIlll;
        }
        String lllllIlIlIlIllI = lllllIlIlIllIIl.getAttribute("style");
        return Util.extractStyle(lllllIlIlIlIllI, lllllIlIlIlIlII);
    }
}

