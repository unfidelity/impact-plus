/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Label;

public class Attribute {
    /* synthetic */ Attribute next;
    public final /* synthetic */ String type;
    /* synthetic */ byte[] value;

    final int getCount() {
        Attribute lllllllllllllllllIlIIIIIlllllllI;
        int lllllllllllllllllIlIIIIIllllllIl = 0;
        Attribute lllllllllllllllllIlIIIIIllllllII = lllllllllllllllllIlIIIIIlllllllI;
        while (lllllllllllllllllIlIIIIIllllllII != null) {
            ++lllllllllllllllllIlIIIIIllllllIl;
            lllllllllllllllllIlIIIIIllllllII = lllllllllllllllllIlIIIIIllllllII.next;
        }
        return lllllllllllllllllIlIIIIIllllllIl;
    }

    protected ByteVector write(ClassWriter lllllllllllllllllIlIIIIlIIIIlIIl, byte[] lllllllllllllllllIlIIIIlIIIIlIII, int lllllllllllllllllIlIIIIlIIIIIlll, int lllllllllllllllllIlIIIIlIIIIIllI, int lllllllllllllllllIlIIIIlIIIIIlIl) {
        Attribute lllllllllllllllllIlIIIIlIIIIlIlI;
        ByteVector lllllllllllllllllIlIIIIlIIIIIlII = new ByteVector();
        lllllllllllllllllIlIIIIlIIIIIlII.data = lllllllllllllllllIlIIIIlIIIIlIlI.value;
        lllllllllllllllllIlIIIIlIIIIIlII.length = lllllllllllllllllIlIIIIlIIIIlIlI.value.length;
        return lllllllllllllllllIlIIIIlIIIIIlII;
    }

    public boolean isUnknown() {
        return true;
    }

    protected Label[] getLabels() {
        return null;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    protected Attribute(String lllllllllllllllllIlIIIIlIIlIIIlI) {
        Attribute lllllllllllllllllIlIIIIlIIlIIIll;
        lllllllllllllllllIlIIIIlIIlIIIll.type = lllllllllllllllllIlIIIIlIIlIIIlI;
    }

    protected Attribute read(ClassReader lllllllllllllllllIlIIIIlIIIllIII, int lllllllllllllllllIlIIIIlIIIIllll, int lllllllllllllllllIlIIIIlIIIlIllI, char[] lllllllllllllllllIlIIIIlIIIlIlIl, int lllllllllllllllllIlIIIIlIIIlIlII, Label[] lllllllllllllllllIlIIIIlIIIlIIll) {
        Attribute lllllllllllllllllIlIIIIlIIIllIIl;
        Attribute lllllllllllllllllIlIIIIlIIIlIIlI = new Attribute(lllllllllllllllllIlIIIIlIIIllIIl.type);
        lllllllllllllllllIlIIIIlIIIlIIlI.value = new byte[lllllllllllllllllIlIIIIlIIIlIllI];
        System.arraycopy(lllllllllllllllllIlIIIIlIIIllIII.b, lllllllllllllllllIlIIIIlIIIIllll, lllllllllllllllllIlIIIIlIIIlIIlI.value, 0, lllllllllllllllllIlIIIIlIIIlIllI);
        return lllllllllllllllllIlIIIIlIIIlIIlI;
    }

    final void put(ClassWriter lllllllllllllllllIlIIIIIllIlIlIl, byte[] lllllllllllllllllIlIIIIIllIlIlII, int lllllllllllllllllIlIIIIIllIIlIll, int lllllllllllllllllIlIIIIIllIIlIlI, int lllllllllllllllllIlIIIIIllIlIIIl, ByteVector lllllllllllllllllIlIIIIIllIIlIII) {
        Attribute lllllllllllllllllIlIIIIIllIlIllI;
        Attribute lllllllllllllllllIlIIIIIllIIllll = lllllllllllllllllIlIIIIIllIlIllI;
        while (lllllllllllllllllIlIIIIIllIIllll != null) {
            ByteVector lllllllllllllllllIlIIIIIllIlIlll = lllllllllllllllllIlIIIIIllIIllll.write(lllllllllllllllllIlIIIIIllIlIlIl, lllllllllllllllllIlIIIIIllIlIlII, lllllllllllllllllIlIIIIIllIIlIll, lllllllllllllllllIlIIIIIllIIlIlI, lllllllllllllllllIlIIIIIllIlIIIl);
            lllllllllllllllllIlIIIIIllIIlIII.putShort(lllllllllllllllllIlIIIIIllIlIlIl.newUTF8(lllllllllllllllllIlIIIIIllIIllll.type)).putInt(lllllllllllllllllIlIIIIIllIlIlll.length);
            lllllllllllllllllIlIIIIIllIIlIII.putByteArray(lllllllllllllllllIlIIIIIllIlIlll.data, 0, lllllllllllllllllIlIIIIIllIlIlll.length);
            lllllllllllllllllIlIIIIIllIIllll = lllllllllllllllllIlIIIIIllIIllll.next;
        }
    }

    final int getSize(ClassWriter lllllllllllllllllIlIIIIIlllIllll, byte[] lllllllllllllllllIlIIIIIlllIIllI, int lllllllllllllllllIlIIIIIlllIllIl, int lllllllllllllllllIlIIIIIlllIllII, int lllllllllllllllllIlIIIIIlllIIIll) {
        Attribute lllllllllllllllllIlIIIIIlllIlIII;
        Attribute lllllllllllllllllIlIIIIIlllIlIlI = lllllllllllllllllIlIIIIIlllIlIII;
        int lllllllllllllllllIlIIIIIlllIlIIl = 0;
        while (lllllllllllllllllIlIIIIIlllIlIlI != null) {
            lllllllllllllllllIlIIIIIlllIllll.newUTF8(lllllllllllllllllIlIIIIIlllIlIlI.type);
            lllllllllllllllllIlIIIIIlllIlIIl += lllllllllllllllllIlIIIIIlllIlIlI.write((ClassWriter)lllllllllllllllllIlIIIIIlllIllll, (byte[])lllllllllllllllllIlIIIIIlllIIllI, (int)lllllllllllllllllIlIIIIIlllIllIl, (int)lllllllllllllllllIlIIIIIlllIllII, (int)lllllllllllllllllIlIIIIIlllIIIll).length + 6;
            lllllllllllllllllIlIIIIIlllIlIlI = lllllllllllllllllIlIIIIIlllIlIlI.next;
        }
        return lllllllllllllllllIlIIIIIlllIlIIl;
    }
}

