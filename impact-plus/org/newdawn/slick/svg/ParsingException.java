/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import org.newdawn.slick.SlickException;
import org.w3c.dom.Element;

public class ParsingException
extends SlickException {
    public ParsingException(String llllllllllllllllIlIllIllIIIIIllI, String llllllllllllllllIlIllIllIIIIIlIl) {
        super(String.valueOf(new StringBuilder().append("(").append(llllllllllllllllIlIllIllIIIIIllI).append(") ").append(llllllllllllllllIlIllIllIIIIIlIl)));
        ParsingException llllllllllllllllIlIllIllIIIIllII;
    }

    public ParsingException(Element llllllllllllllllIlIllIllIIIlIlIl, String llllllllllllllllIlIllIllIIIllIII, Throwable llllllllllllllllIlIllIllIIIlIIll) {
        super(String.valueOf(new StringBuilder().append("(").append(llllllllllllllllIlIllIllIIIlIlIl.getAttribute("id")).append(") ").append(llllllllllllllllIlIllIllIIIllIII)), llllllllllllllllIlIllIllIIIlIIll);
        ParsingException llllllllllllllllIlIllIllIIIllIlI;
    }

    public ParsingException(String llllllllllllllllIlIllIllIIlIIIIl, String llllllllllllllllIlIllIllIIlIIIII, Throwable llllllllllllllllIlIllIllIIIlllll) {
        super(String.valueOf(new StringBuilder().append("(").append(llllllllllllllllIlIllIllIIlIIIIl).append(") ").append(llllllllllllllllIlIllIllIIlIIIII)), llllllllllllllllIlIllIllIIIlllll);
        ParsingException llllllllllllllllIlIllIllIIlIIIlI;
    }

    public ParsingException(Element llllllllllllllllIlIllIlIllllIIll, String llllllllllllllllIlIllIlIllllIllI) {
        super(String.valueOf(new StringBuilder().append("(").append(llllllllllllllllIlIllIlIllllIIll.getAttribute("id")).append(") ").append(llllllllllllllllIlIllIlIllllIllI)));
        ParsingException llllllllllllllllIlIllIlIlllllIlI;
    }
}

