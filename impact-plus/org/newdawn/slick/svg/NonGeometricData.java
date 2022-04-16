/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import java.util.Properties;
import org.newdawn.slick.Color;

public class NonGeometricData {
    public static final /* synthetic */ String STROKE_OPACITY;
    public static final /* synthetic */ String ID;
    public static final /* synthetic */ String STROKE_WIDTH;
    public static final /* synthetic */ String OPACITY;
    public static final /* synthetic */ String FILL;
    private /* synthetic */ String metaData;
    public static final /* synthetic */ String STROKE;
    public static final /* synthetic */ String STROKE_MITERLIMIT;
    public static final /* synthetic */ String STROKE_DASHARRAY;
    private /* synthetic */ Properties props;
    public static final /* synthetic */ String STROKE_DASHOFFSET;
    public static final /* synthetic */ String NONE;

    public boolean isStroked() {
        NonGeometricData lllllllllllllllllIIIlIllIIlIIIII;
        return lllllllllllllllllIIIlIllIIlIIIII.isColor("stroke") && lllllllllllllllllIIIlIllIIlIIIII.getAsFloat("stroke-width") > 0.0f;
    }

    public NonGeometricData(String lllllllllllllllllIIIlIlllIIlIIIl) {
        NonGeometricData lllllllllllllllllIIIlIlllIIlIIII;
        lllllllllllllllllIIIlIlllIIlIIII.metaData = "";
        lllllllllllllllllIIIlIlllIIlIIII.props = new Properties();
        lllllllllllllllllIIIlIlllIIlIIII.metaData = lllllllllllllllllIIIlIlllIIlIIIl;
        lllllllllllllllllIIIlIlllIIlIIII.addAttribute("stroke-width", "1");
    }

    public String getAttribute(String lllllllllllllllllIIIlIllIllIlIIl) {
        NonGeometricData lllllllllllllllllIIIlIllIllIlIlI;
        return lllllllllllllllllIIIlIllIllIlIlI.props.getProperty(lllllllllllllllllIIIlIllIllIlIIl);
    }

    public void addAttribute(String lllllllllllllllllIIIlIlllIIIIllI, String lllllllllllllllllIIIlIlllIIIIlIl) {
        NonGeometricData lllllllllllllllllIIIlIlllIIIIlll;
        if (lllllllllllllllllIIIlIlllIIIIlIl == null) {
            lllllllllllllllllIIIlIlllIIIIlIl = "";
        }
        if (lllllllllllllllllIIIlIlllIIIIllI.equals("fill")) {
            lllllllllllllllllIIIlIlllIIIIlIl = lllllllllllllllllIIIlIlllIIIIlll.morphColor(lllllllllllllllllIIIlIlllIIIIlIl);
        }
        if (lllllllllllllllllIIIlIlllIIIIllI.equals("stroke-opacity") && lllllllllllllllllIIIlIlllIIIIlIl.equals("0")) {
            lllllllllllllllllIIIlIlllIIIIlll.props.setProperty("stroke", "none");
        }
        if (lllllllllllllllllIIIlIlllIIIIllI.equals("stroke-width")) {
            if (lllllllllllllllllIIIlIlllIIIIlIl.equals("")) {
                lllllllllllllllllIIIlIlllIIIIlIl = "1";
            }
            if (lllllllllllllllllIIIlIlllIIIIlIl.endsWith("px")) {
                lllllllllllllllllIIIlIlllIIIIlIl = lllllllllllllllllIIIlIlllIIIIlIl.substring(0, lllllllllllllllllIIIlIlllIIIIlIl.length() - 2);
            }
        }
        if (lllllllllllllllllIIIlIlllIIIIllI.equals("stroke")) {
            if ("none".equals(lllllllllllllllllIIIlIlllIIIIlll.props.getProperty("stroke"))) {
                return;
            }
            if ("".equals(lllllllllllllllllIIIlIlllIIIIlll.props.getProperty("stroke"))) {
                return;
            }
            lllllllllllllllllIIIlIlllIIIIlIl = lllllllllllllllllIIIlIlllIIIIlll.morphColor(lllllllllllllllllIIIlIlllIIIIlIl);
        }
        lllllllllllllllllIIIlIlllIIIIlll.props.setProperty(lllllllllllllllllIIIlIlllIIIIllI, lllllllllllllllllIIIlIlllIIIIlIl);
    }

    public String getMetaData() {
        NonGeometricData lllllllllllllllllIIIlIllIlllIIII;
        return lllllllllllllllllIIIlIllIlllIIII.metaData;
    }

    private String morphColor(String lllllllllllllllllIIIlIlllIIIllII) {
        if (lllllllllllllllllIIIlIlllIIIllII.equals("")) {
            return "#000000";
        }
        if (lllllllllllllllllIIIlIlllIIIllII.equals("white")) {
            return "#ffffff";
        }
        if (lllllllllllllllllIIIlIlllIIIllII.equals("black")) {
            return "#000000";
        }
        return lllllllllllllllllIIIlIlllIIIllII;
    }

    public boolean isColor(String lllllllllllllllllIIIlIllIllllIll) {
        NonGeometricData lllllllllllllllllIIIlIllIlllllIl;
        return lllllllllllllllllIIIlIllIlllllIl.getAttribute(lllllllllllllllllIIIlIllIllllIll).startsWith("#");
    }

    public float getAsFloat(String lllllllllllllllllIIIlIllIlIIIIII) {
        NonGeometricData lllllllllllllllllIIIlIllIlIIIllI;
        String lllllllllllllllllIIIlIllIlIIIIlI = lllllllllllllllllIIIlIllIlIIIllI.getAttribute(lllllllllllllllllIIIlIllIlIIIIII);
        if (lllllllllllllllllIIIlIllIlIIIIlI == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(lllllllllllllllllIIIlIllIlIIIIlI);
        }
        catch (NumberFormatException lllllllllllllllllIIIlIllIlIIlIII) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Attribute ").append(lllllllllllllllllIIIlIllIlIIIIII).append(" is not specified as a float:").append(lllllllllllllllllIIIlIllIlIIIllI.getAttribute(lllllllllllllllllIIIlIllIlIIIIII))));
        }
    }

    public Color getAsColor(String lllllllllllllllllIIIlIllIlIlllll) {
        NonGeometricData lllllllllllllllllIIIlIllIlIlllIl;
        if (!lllllllllllllllllIIIlIllIlIlllIl.isColor(lllllllllllllllllIIIlIllIlIlllll)) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Attribute ").append(lllllllllllllllllIIIlIllIlIlllll).append(" is not specified as a color:").append(lllllllllllllllllIIIlIllIlIlllIl.getAttribute(lllllllllllllllllIIIlIllIlIlllll))));
        }
        int lllllllllllllllllIIIlIllIlIllllI = Integer.parseInt(lllllllllllllllllIIIlIllIlIlllIl.getAttribute(lllllllllllllllllIIIlIllIlIlllll).substring(1), 16);
        return new Color(lllllllllllllllllIIIlIllIlIllllI);
    }

    static {
        STROKE_MITERLIMIT = "stroke-miterlimit";
        STROKE_OPACITY = "stroke-opacity";
        STROKE_WIDTH = "stroke-width";
        OPACITY = "opacity";
        FILL = "fill";
        NONE = "none";
        STROKE = "stroke";
        STROKE_DASHARRAY = "stroke-dasharray";
        ID = "id";
        STROKE_DASHOFFSET = "stroke-dashoffset";
    }

    public String getAsReference(String lllllllllllllllllIIIlIllIlIlIIll) {
        NonGeometricData lllllllllllllllllIIIlIllIlIlIlII;
        String lllllllllllllllllIIIlIllIlIlIlIl = lllllllllllllllllIIIlIllIlIlIlII.getAttribute(lllllllllllllllllIIIlIllIlIlIIll);
        if (lllllllllllllllllIIIlIllIlIlIlIl.length() < 7) {
            return "";
        }
        lllllllllllllllllIIIlIllIlIlIlIl = lllllllllllllllllIIIlIllIlIlIlIl.substring(5, lllllllllllllllllIIIlIllIlIlIlIl.length() - 1);
        return lllllllllllllllllIIIlIllIlIlIlIl;
    }

    public boolean isFilled() {
        NonGeometricData lllllllllllllllllIIIlIllIIllIlll;
        return lllllllllllllllllIIIlIllIIllIlll.isColor("fill");
    }
}

