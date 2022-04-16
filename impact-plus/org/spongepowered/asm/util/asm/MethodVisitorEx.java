/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util.asm;

import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.util.Bytecode;

public class MethodVisitorEx
extends MethodVisitor {
    public void visitConstant(byte llllllllllllllllIlIIlIIlIIIIIIII) {
        MethodVisitorEx llllllllllllllllIlIIlIIlIIIIIIIl;
        if (llllllllllllllllIlIIlIIlIIIIIIII > -2 && llllllllllllllllIlIIlIIlIIIIIIII < 6) {
            llllllllllllllllIlIIlIIlIIIIIIIl.visitInsn(Bytecode.CONSTANTS_INT[llllllllllllllllIlIIlIIlIIIIIIII + 1]);
            return;
        }
        llllllllllllllllIlIIlIIlIIIIIIIl.visitIntInsn(16, llllllllllllllllIlIIlIIlIIIIIIII);
    }

    public MethodVisitorEx(MethodVisitor llllllllllllllllIlIIlIIlIIIIIllI) {
        super(327680, llllllllllllllllIlIIlIIlIIIIIllI);
        MethodVisitorEx llllllllllllllllIlIIlIIlIIIIIlIl;
    }
}

