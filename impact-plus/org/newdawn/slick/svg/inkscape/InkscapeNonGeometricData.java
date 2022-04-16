/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import org.newdawn.slick.svg.NonGeometricData;
import org.w3c.dom.Element;

public class InkscapeNonGeometricData
extends NonGeometricData {
    private /* synthetic */ Element element;

    @Override
    public String getAttribute(String llllllllllllllllIIIIIIIlIlIlIIIl) {
        InkscapeNonGeometricData llllllllllllllllIIIIIIIlIlIlIIlI;
        String llllllllllllllllIIIIIIIlIlIlIIII = super.getAttribute(llllllllllllllllIIIIIIIlIlIlIIIl);
        if (llllllllllllllllIIIIIIIlIlIlIIII == null) {
            llllllllllllllllIIIIIIIlIlIlIIII = llllllllllllllllIIIIIIIlIlIlIIlI.element.getAttribute(llllllllllllllllIIIIIIIlIlIlIIIl);
        }
        return llllllllllllllllIIIIIIIlIlIlIIII;
    }

    public Element getElement() {
        InkscapeNonGeometricData llllllllllllllllIIIIIIIlIlIIlIlI;
        return llllllllllllllllIIIIIIIlIlIIlIlI.element;
    }

    public InkscapeNonGeometricData(String llllllllllllllllIIIIIIIlIlIllIlI, Element llllllllllllllllIIIIIIIlIlIllIIl) {
        super(llllllllllllllllIIIIIIIlIlIllIlI);
        InkscapeNonGeometricData llllllllllllllllIIIIIIIlIlIllIII;
        llllllllllllllllIIIIIIIlIlIllIII.element = llllllllllllllllIIIIIIIlIlIllIIl;
    }
}

