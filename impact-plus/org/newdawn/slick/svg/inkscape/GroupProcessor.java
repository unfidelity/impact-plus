/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg.inkscape;

import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Loader;
import org.newdawn.slick.svg.ParsingException;
import org.newdawn.slick.svg.inkscape.ElementProcessor;
import org.newdawn.slick.svg.inkscape.Util;
import org.w3c.dom.Element;

public class GroupProcessor
implements ElementProcessor {
    @Override
    public boolean handles(Element lllIIIlIlIIIIIl) {
        return lllIIIlIlIIIIIl.getNodeName().equals("g");
    }

    @Override
    public void process(Loader lllIIIlIIllIlIl, Element lllIIIlIIlllIIl, Diagram lllIIIlIIlllIII, Transform lllIIIlIIllIlll) throws ParsingException {
        Transform lllIIIlIIllIllI = Util.getTransform(lllIIIlIIlllIIl);
        lllIIIlIIllIllI = new Transform(lllIIIlIIllIlll, lllIIIlIIllIllI);
        lllIIIlIIllIlIl.loadChildren(lllIIIlIIlllIIl, lllIIIlIIllIllI);
    }

    public GroupProcessor() {
        GroupProcessor lllIIIlIlIIIlIl;
    }
}

