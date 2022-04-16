/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke.arg;

public class ArgumentIndexOutOfBoundsException
extends IndexOutOfBoundsException {
    private static final /* synthetic */ long serialVersionUID = 1L;

    public ArgumentIndexOutOfBoundsException(int llllllllllllllllIlIlIIIIIlIlIllI) {
        super(String.valueOf(new StringBuilder().append("Argument index is out of bounds: ").append(llllllllllllllllIlIlIIIIIlIlIllI)));
        ArgumentIndexOutOfBoundsException llllllllllllllllIlIlIIIIIlIllIIl;
    }
}

