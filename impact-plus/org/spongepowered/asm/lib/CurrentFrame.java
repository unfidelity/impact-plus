/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Frame;
import org.spongepowered.asm.lib.Item;

class CurrentFrame
extends Frame {
    void execute(int lllIIlIlllllI, int lllIIlIllllIl, ClassWriter lllIIllIIIIll, Item lllIIllIIIIIl) {
        CurrentFrame lllIIllIIlIIl;
        super.execute(lllIIlIlllllI, lllIIlIllllIl, lllIIllIIIIll, lllIIllIIIIIl);
        Frame lllIIllIIIIII = new Frame();
        lllIIllIIlIIl.merge(lllIIllIIIIll, lllIIllIIIIII, 0);
        lllIIllIIlIIl.set(lllIIllIIIIII);
        lllIIllIIlIIl.owner.inputStackTop = 0;
    }

    CurrentFrame() {
        CurrentFrame lllIIllIllIll;
    }
}

