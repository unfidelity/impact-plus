/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke.arg;

public class ArgumentCountException
extends IllegalArgumentException {
    private static final /* synthetic */ long serialVersionUID = 1L;

    public ArgumentCountException(int lIIIllIIlIIIlII, int lIIIllIIIllllll, String lIIIllIIIlllllI) {
        super(String.valueOf(new StringBuilder().append("Invalid number of arguments for setAll, received ").append(lIIIllIIlIIIlII).append(" but expected ").append(lIIIllIIIllllll).append(": ").append(lIIIllIIIlllllI)));
        ArgumentCountException lIIIllIIlIIIIIl;
    }
}

