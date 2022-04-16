/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.signature;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

public class SignatureWriter
extends SignatureVisitor {
    private /* synthetic */ boolean hasFormals;
    private /* synthetic */ int argumentStack;
    private final /* synthetic */ StringBuilder buf;
    private /* synthetic */ boolean hasParameters;

    public String toString() {
        SignatureWriter lllllllllllllllllIIIlIIlIlIIlIll;
        return String.valueOf(lllllllllllllllllIIIlIIlIlIIlIll.buf);
    }

    public void visitFormalTypeParameter(String lllllllllllllllllIIIlIIllIIIllII) {
        SignatureWriter lllllllllllllllllIIIlIIllIIIlIll;
        if (!lllllllllllllllllIIIlIIllIIIlIll.hasFormals) {
            lllllllllllllllllIIIlIIllIIIlIll.hasFormals = true;
            lllllllllllllllllIIIlIIllIIIlIll.buf.append('<');
        }
        lllllllllllllllllIIIlIIllIIIlIll.buf.append(lllllllllllllllllIIIlIIllIIIllII);
        lllllllllllllllllIIIlIIllIIIlIll.buf.append(':');
    }

    public void visitBaseType(char lllllllllllllllllIIIlIIlIlllIIIl) {
        SignatureWriter lllllllllllllllllIIIlIIlIlllIIlI;
        lllllllllllllllllIIIlIIlIlllIIlI.buf.append(lllllllllllllllllIIIlIIlIlllIIIl);
    }

    public void visitClassType(String lllllllllllllllllIIIlIIlIllIIIlI) {
        SignatureWriter lllllllllllllllllIIIlIIlIllIIIIl;
        lllllllllllllllllIIIlIIlIllIIIIl.buf.append('L');
        lllllllllllllllllIIIlIIlIllIIIIl.buf.append(lllllllllllllllllIIIlIIlIllIIIlI);
        lllllllllllllllllIIIlIIlIllIIIIl.argumentStack *= 2;
    }

    public void visitTypeArgument() {
        SignatureWriter lllllllllllllllllIIIlIIlIlIlIlll;
        if (lllllllllllllllllIIIlIIlIlIlIlll.argumentStack % 2 == 0) {
            ++lllllllllllllllllIIIlIIlIlIlIlll.argumentStack;
            lllllllllllllllllIIIlIIlIlIlIlll.buf.append('<');
        }
        lllllllllllllllllIIIlIIlIlIlIlll.buf.append('*');
    }

    public SignatureVisitor visitSuperclass() {
        SignatureWriter lllllllllllllllllIIIlIIllIIIIIIl;
        lllllllllllllllllIIIlIIllIIIIIIl.endFormals();
        return lllllllllllllllllIIIlIIllIIIIIIl;
    }

    public void visitInnerClassType(String lllllllllllllllllIIIlIIlIlIllIlI) {
        SignatureWriter lllllllllllllllllIIIlIIlIlIllIll;
        lllllllllllllllllIIIlIIlIlIllIll.endArguments();
        lllllllllllllllllIIIlIIlIlIllIll.buf.append('.');
        lllllllllllllllllIIIlIIlIlIllIll.buf.append(lllllllllllllllllIIIlIIlIlIllIlI);
        lllllllllllllllllIIIlIIlIlIllIll.argumentStack *= 2;
    }

    public void visitTypeVariable(String lllllllllllllllllIIIlIIlIllIlIll) {
        SignatureWriter lllllllllllllllllIIIlIIlIllIlIlI;
        lllllllllllllllllIIIlIIlIllIlIlI.buf.append('T');
        lllllllllllllllllIIIlIIlIllIlIlI.buf.append(lllllllllllllllllIIIlIIlIllIlIll);
        lllllllllllllllllIIIlIIlIllIlIlI.buf.append(';');
    }

    private void endFormals() {
        SignatureWriter lllllllllllllllllIIIlIIlIlIIlIIl;
        if (lllllllllllllllllIIIlIIlIlIIlIIl.hasFormals) {
            lllllllllllllllllIIIlIIlIlIIlIIl.hasFormals = false;
            lllllllllllllllllIIIlIIlIlIIlIIl.buf.append('>');
        }
    }

    private void endArguments() {
        SignatureWriter lllllllllllllllllIIIlIIlIlIIIllI;
        if (lllllllllllllllllIIIlIIlIlIIIllI.argumentStack % 2 != 0) {
            lllllllllllllllllIIIlIIlIlIIIllI.buf.append('>');
        }
        lllllllllllllllllIIIlIIlIlIIIllI.argumentStack /= 2;
    }

    public SignatureVisitor visitExceptionType() {
        SignatureWriter lllllllllllllllllIIIlIIlIlllIlIl;
        lllllllllllllllllIIIlIIlIlllIlIl.buf.append('^');
        return lllllllllllllllllIIIlIIlIlllIlIl;
    }

    public SignatureWriter() {
        super(327680);
        SignatureWriter lllllllllllllllllIIIlIIllIIlIIIl;
        lllllllllllllllllIIIlIIllIIlIIIl.buf = new StringBuilder();
    }

    public SignatureVisitor visitParameterType() {
        SignatureWriter lllllllllllllllllIIIlIIlIlllllII;
        lllllllllllllllllIIIlIIlIlllllII.endFormals();
        if (!lllllllllllllllllIIIlIIlIlllllII.hasParameters) {
            lllllllllllllllllIIIlIIlIlllllII.hasParameters = true;
            lllllllllllllllllIIIlIIlIlllllII.buf.append('(');
        }
        return lllllllllllllllllIIIlIIlIlllllII;
    }

    public SignatureVisitor visitInterfaceBound() {
        SignatureWriter lllllllllllllllllIIIlIIllIIIIlII;
        lllllllllllllllllIIIlIIllIIIIlII.buf.append(':');
        return lllllllllllllllllIIIlIIllIIIIlII;
    }

    public SignatureVisitor visitArrayType() {
        SignatureWriter lllllllllllllllllIIIlIIlIllIIlll;
        lllllllllllllllllIIIlIIlIllIIlll.buf.append('[');
        return lllllllllllllllllIIIlIIlIllIIlll;
    }

    public void visitEnd() {
        SignatureWriter lllllllllllllllllIIIlIIlIlIIlllI;
        lllllllllllllllllIIIlIIlIlIIlllI.endArguments();
        lllllllllllllllllIIIlIIlIlIIlllI.buf.append(';');
    }

    public SignatureVisitor visitInterface() {
        SignatureWriter lllllllllllllllllIIIlIIlIllllllI;
        return lllllllllllllllllIIIlIIlIllllllI;
    }

    public SignatureVisitor visitTypeArgument(char lllllllllllllllllIIIlIIlIlIlIIIl) {
        SignatureWriter lllllllllllllllllIIIlIIlIlIlIIlI;
        if (lllllllllllllllllIIIlIIlIlIlIIlI.argumentStack % 2 == 0) {
            ++lllllllllllllllllIIIlIIlIlIlIIlI.argumentStack;
            lllllllllllllllllIIIlIIlIlIlIIlI.buf.append('<');
        }
        if (lllllllllllllllllIIIlIIlIlIlIIIl != '=') {
            lllllllllllllllllIIIlIIlIlIlIIlI.buf.append(lllllllllllllllllIIIlIIlIlIlIIIl);
        }
        return lllllllllllllllllIIIlIIlIlIlIIlI;
    }

    public SignatureVisitor visitReturnType() {
        SignatureWriter lllllllllllllllllIIIlIIlIllllIIl;
        lllllllllllllllllIIIlIIlIllllIIl.endFormals();
        if (!lllllllllllllllllIIIlIIlIllllIIl.hasParameters) {
            lllllllllllllllllIIIlIIlIllllIIl.buf.append('(');
        }
        lllllllllllllllllIIIlIIlIllllIIl.buf.append(')');
        return lllllllllllllllllIIIlIIlIllllIIl;
    }

    public SignatureVisitor visitClassBound() {
        SignatureWriter lllllllllllllllllIIIlIIllIIIlIII;
        return lllllllllllllllllIIIlIIllIIIlIII;
    }
}

