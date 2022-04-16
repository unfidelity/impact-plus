/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.signature;

public abstract class SignatureVisitor {
    protected final /* synthetic */ int api;
    public static final /* synthetic */ char EXTENDS;
    public static final /* synthetic */ char INSTANCEOF;
    public static final /* synthetic */ char SUPER;

    public SignatureVisitor visitReturnType() {
        SignatureVisitor lllllllllllllllllIIIIllIIIlIIllI;
        return lllllllllllllllllIIIIllIIIlIIllI;
    }

    public void visitEnd() {
    }

    static {
        SUPER = (char)45;
        INSTANCEOF = (char)61;
        EXTENDS = (char)43;
    }

    public SignatureVisitor visitParameterType() {
        SignatureVisitor lllllllllllllllllIIIIllIIIlIlIIl;
        return lllllllllllllllllIIIIllIIIlIlIIl;
    }

    public void visitTypeVariable(String lllllllllllllllllIIIIllIIIIllllI) {
    }

    public void visitInnerClassType(String lllllllllllllllllIIIIllIIIIlIlll) {
    }

    public void visitTypeArgument() {
    }

    public SignatureVisitor visitArrayType() {
        SignatureVisitor lllllllllllllllllIIIIllIIIIlllII;
        return lllllllllllllllllIIIIllIIIIlllII;
    }

    public SignatureVisitor(int lllllllllllllllllIIIIllIIIlllIll) {
        SignatureVisitor lllllllllllllllllIIIIllIIIllllII;
        if (lllllllllllllllllIIIIllIIIlllIll != 262144 && lllllllllllllllllIIIIllIIIlllIll != 327680) {
            throw new IllegalArgumentException();
        }
        lllllllllllllllllIIIIllIIIllllII.api = lllllllllllllllllIIIIllIIIlllIll;
    }

    public void visitFormalTypeParameter(String lllllllllllllllllIIIIllIIIllIlll) {
    }

    public void visitBaseType(char lllllllllllllllllIIIIllIIIlIIIII) {
    }

    public SignatureVisitor visitInterface() {
        SignatureVisitor lllllllllllllllllIIIIllIIIlIllII;
        return lllllllllllllllllIIIIllIIIlIllII;
    }

    public SignatureVisitor visitInterfaceBound() {
        SignatureVisitor lllllllllllllllllIIIIllIIIllIIIl;
        return lllllllllllllllllIIIIllIIIllIIIl;
    }

    public SignatureVisitor visitExceptionType() {
        SignatureVisitor lllllllllllllllllIIIIllIIIlIIIlI;
        return lllllllllllllllllIIIIllIIIlIIIlI;
    }

    public void visitClassType(String lllllllllllllllllIIIIllIIIIllIIl) {
    }

    public SignatureVisitor visitTypeArgument(char lllllllllllllllllIIIIllIIIIlIIll) {
        SignatureVisitor lllllllllllllllllIIIIllIIIIlIlII;
        return lllllllllllllllllIIIIllIIIIlIlII;
    }

    public SignatureVisitor visitSuperclass() {
        SignatureVisitor lllllllllllllllllIIIIllIIIlIlllI;
        return lllllllllllllllllIIIIllIIIlIlllI;
    }

    public SignatureVisitor visitClassBound() {
        SignatureVisitor lllllllllllllllllIIIIllIIIllIlIl;
        return lllllllllllllllllIIIIllIIIllIlIl;
    }
}

