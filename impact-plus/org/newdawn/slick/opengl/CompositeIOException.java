/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.io.IOException;
import java.util.ArrayList;

public class CompositeIOException
extends IOException {
    private /* synthetic */ ArrayList exceptions;

    @Override
    public String getMessage() {
        CompositeIOException llllllllllllllllIIIIllIlllIIllIl;
        String llllllllllllllllIIIIllIlllIIllII = "Composite Exception: \n";
        for (int llllllllllllllllIIIIllIlllIIlllI = 0; llllllllllllllllIIIIllIlllIIlllI < llllllllllllllllIIIIllIlllIIllIl.exceptions.size(); ++llllllllllllllllIIIIllIlllIIlllI) {
            llllllllllllllllIIIIllIlllIIllII = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIllIlllIIllII).append("\t").append(((IOException)llllllllllllllllIIIIllIlllIIllIl.exceptions.get(llllllllllllllllIIIIllIlllIIlllI)).getMessage()).append("\n"));
        }
        return llllllllllllllllIIIIllIlllIIllII;
    }

    public void addException(Exception llllllllllllllllIIIIllIlllIlIIlI) {
        CompositeIOException llllllllllllllllIIIIllIlllIlIlIl;
        llllllllllllllllIIIIllIlllIlIlIl.exceptions.add(llllllllllllllllIIIIllIlllIlIIlI);
    }

    public CompositeIOException() {
        CompositeIOException llllllllllllllllIIIIllIlllIllIIl;
        llllllllllllllllIIIIllIlllIllIIl.exceptions = new ArrayList();
    }
}

