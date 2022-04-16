/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

public final class TraceSignatureVisitor
extends SignatureVisitor {
    private /* synthetic */ boolean seenParameter;
    private /* synthetic */ boolean seenInterfaceBound;
    private /* synthetic */ boolean seenFormalParameter;
    private final /* synthetic */ StringBuilder declaration;
    private /* synthetic */ StringBuilder exceptions;
    private /* synthetic */ int argumentStack;
    private /* synthetic */ boolean isInterface;
    private /* synthetic */ StringBuilder returnType;
    private /* synthetic */ boolean seenInterface;
    private /* synthetic */ int arrayStack;
    private /* synthetic */ String separator;

    public void visitInnerClassType(String lllllllllllllllllIlIIlIlIIlIIIlI) {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIlIIlIl;
        if (lllllllllllllllllIlIIlIlIIlIIlIl.argumentStack % 2 != 0) {
            lllllllllllllllllIlIIlIlIIlIIlIl.declaration.append('>');
        }
        lllllllllllllllllIlIIlIlIIlIIlIl.argumentStack /= 2;
        lllllllllllllllllIlIIlIlIIlIIlIl.declaration.append('.');
        lllllllllllllllllIlIIlIlIIlIIlIl.declaration.append(lllllllllllllllllIlIIlIlIIlIIlIl.separator).append(lllllllllllllllllIlIIlIlIIlIIIlI.replace('/', '.'));
        lllllllllllllllllIlIIlIlIIlIIlIl.separator = "";
        lllllllllllllllllIlIIlIlIIlIIlIl.argumentStack *= 2;
    }

    public String getExceptions() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIIlllI;
        return lllllllllllllllllIlIIlIlIIIIlllI.exceptions == null ? null : String.valueOf(lllllllllllllllllIlIIlIlIIIIlllI.exceptions);
    }

    public SignatureVisitor visitExceptionType() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIlllIlll;
        if (lllllllllllllllllIlIIlIlIlllIlll.exceptions == null) {
            lllllllllllllllllIlIIlIlIlllIlll.exceptions = new StringBuilder();
        } else {
            lllllllllllllllllIlIIlIlIlllIlll.exceptions.append(", ");
        }
        return new TraceSignatureVisitor(lllllllllllllllllIlIIlIlIlllIlll.exceptions);
    }

    public void visitClassType(String lllllllllllllllllIlIIlIlIIllIIIl) {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIllIIII;
        if ("java/lang/Object".equals(lllllllllllllllllIlIIlIlIIllIIIl)) {
            boolean lllllllllllllllllIlIIlIlIIllIlIl;
            boolean bl = lllllllllllllllllIlIIlIlIIllIlIl = lllllllllllllllllIlIIlIlIIllIIII.argumentStack % 2 != 0 || lllllllllllllllllIlIIlIlIIllIIII.seenParameter;
            if (lllllllllllllllllIlIIlIlIIllIlIl) {
                lllllllllllllllllIlIIlIlIIllIIII.declaration.append(lllllllllllllllllIlIIlIlIIllIIII.separator).append(lllllllllllllllllIlIIlIlIIllIIIl.replace('/', '.'));
            }
        } else {
            lllllllllllllllllIlIIlIlIIllIIII.declaration.append(lllllllllllllllllIlIIlIlIIllIIII.separator).append(lllllllllllllllllIlIIlIlIIllIIIl.replace('/', '.'));
        }
        lllllllllllllllllIlIIlIlIIllIIII.separator = "";
        lllllllllllllllllIlIIlIlIIllIIII.argumentStack *= 2;
    }

    public void visitBaseType(char lllllllllllllllllIlIIlIlIllIIIII) {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIllIIlIl;
        switch (lllllllllllllllllIlIIlIlIllIIIII) {
            case 'V': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("void");
                break;
            }
            case 'B': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("byte");
                break;
            }
            case 'J': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("long");
                break;
            }
            case 'Z': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("boolean");
                break;
            }
            case 'I': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("int");
                break;
            }
            case 'S': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("short");
                break;
            }
            case 'C': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("char");
                break;
            }
            case 'F': {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("float");
                break;
            }
            default: {
                lllllllllllllllllIlIIlIlIllIIlIl.declaration.append("double");
            }
        }
        lllllllllllllllllIlIIlIlIllIIlIl.endType();
    }

    public SignatureVisitor visitInterfaceBound() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIIllIlI;
        lllllllllllllllllIlIIlIllIIllIlI.separator = lllllllllllllllllIlIIlIllIIllIlI.seenInterfaceBound ? ", " : " extends ";
        lllllllllllllllllIlIIlIllIIllIlI.seenInterfaceBound = true;
        lllllllllllllllllIlIIlIllIIllIlI.startType();
        return lllllllllllllllllIlIIlIllIIllIlI;
    }

    public SignatureVisitor visitParameterType() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIIIIIII;
        lllllllllllllllllIlIIlIllIIIIIII.endFormals();
        if (lllllllllllllllllIlIIlIllIIIIIII.seenParameter) {
            lllllllllllllllllIlIIlIllIIIIIII.declaration.append(", ");
        } else {
            lllllllllllllllllIlIIlIllIIIIIII.seenParameter = true;
            lllllllllllllllllIlIIlIllIIIIIII.declaration.append('(');
        }
        lllllllllllllllllIlIIlIllIIIIIII.startType();
        return lllllllllllllllllIlIIlIllIIIIIII;
    }

    private void startType() {
        lllllllllllllllllIlIIlIlIIIIlIII.arrayStack *= 2;
    }

    public SignatureVisitor visitArrayType() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIlIIIIll;
        lllllllllllllllllIlIIlIlIlIIIIll.startType();
        lllllllllllllllllIlIIlIlIlIIIIll.arrayStack |= 1;
        return lllllllllllllllllIlIIlIlIlIIIIll;
    }

    public TraceSignatureVisitor(int lllllllllllllllllIlIIlIllIlllIIl) {
        super(327680);
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIllllII;
        lllllllllllllllllIlIIlIllIllllII.separator = "";
        lllllllllllllllllIlIIlIllIllllII.isInterface = (lllllllllllllllllIlIIlIllIlllIIl & 0x200) != 0;
        lllllllllllllllllIlIIlIllIllllII.declaration = new StringBuilder();
    }

    public void visitEnd() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIlIlll;
        if (lllllllllllllllllIlIIlIlIIIlIlll.argumentStack % 2 != 0) {
            lllllllllllllllllIlIIlIlIIIlIlll.declaration.append('>');
        }
        lllllllllllllllllIlIIlIlIIIlIlll.argumentStack /= 2;
        lllllllllllllllllIlIIlIlIIIlIlll.endType();
    }

    public String getDeclaration() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIlIlII;
        return String.valueOf(lllllllllllllllllIlIIlIlIIIlIlII.declaration);
    }

    public SignatureVisitor visitSuperclass() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIIlIlIl;
        lllllllllllllllllIlIIlIllIIlIlIl.endFormals();
        lllllllllllllllllIlIIlIllIIlIlIl.separator = " extends ";
        lllllllllllllllllIlIIlIllIIlIlIl.startType();
        return lllllllllllllllllIlIIlIllIIlIlIl;
    }

    public SignatureVisitor visitTypeArgument(char lllllllllllllllllIlIIlIlIIIllIll) {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIlllII;
        if (lllllllllllllllllIlIIlIlIIIlllII.argumentStack % 2 == 0) {
            ++lllllllllllllllllIlIIlIlIIIlllII.argumentStack;
            lllllllllllllllllIlIIlIlIIIlllII.declaration.append('<');
        } else {
            lllllllllllllllllIlIIlIlIIIlllII.declaration.append(", ");
        }
        if (lllllllllllllllllIlIIlIlIIIllIll == '+') {
            lllllllllllllllllIlIIlIlIIIlllII.declaration.append("? extends ");
        } else if (lllllllllllllllllIlIIlIlIIIllIll == '-') {
            lllllllllllllllllIlIIlIlIIIlllII.declaration.append("? super ");
        }
        lllllllllllllllllIlIIlIlIIIlllII.startType();
        return lllllllllllllllllIlIIlIlIIIlllII;
    }

    public void visitTypeVariable(String lllllllllllllllllIlIIlIlIlIlIIll) {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIlIlIlIl;
        lllllllllllllllllIlIIlIlIlIlIlIl.declaration.append(lllllllllllllllllIlIIlIlIlIlIIll);
        lllllllllllllllllIlIIlIlIlIlIlIl.endType();
    }

    private void endFormals() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIIlIll;
        if (lllllllllllllllllIlIIlIlIIIIlIll.seenFormalParameter) {
            lllllllllllllllllIlIIlIlIIIIlIll.declaration.append('>');
            lllllllllllllllllIlIIlIlIIIIlIll.seenFormalParameter = false;
        }
    }

    private TraceSignatureVisitor(StringBuilder lllllllllllllllllIlIIlIllIllIlIl) {
        super(327680);
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIllIllI;
        lllllllllllllllllIlIIlIllIllIllI.separator = "";
        lllllllllllllllllIlIIlIllIllIllI.declaration = lllllllllllllllllIlIIlIllIllIlIl;
    }

    public void visitFormalTypeParameter(String lllllllllllllllllIlIIlIllIlIlIIl) {
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIlIlIlI;
        lllllllllllllllllIlIIlIllIlIlIlI.declaration.append(lllllllllllllllllIlIIlIllIlIlIlI.seenFormalParameter ? ", " : "<").append(lllllllllllllllllIlIIlIllIlIlIIl);
        lllllllllllllllllIlIIlIllIlIlIlI.seenFormalParameter = true;
        lllllllllllllllllIlIIlIllIlIlIlI.seenInterfaceBound = false;
    }

    public SignatureVisitor visitInterface() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIIlIIIl;
        lllllllllllllllllIlIIlIllIIlIIIl.separator = lllllllllllllllllIlIIlIllIIlIIIl.seenInterface ? ", " : (lllllllllllllllllIlIIlIllIIlIIIl.isInterface ? " extends " : " implements ");
        lllllllllllllllllIlIIlIllIIlIIIl.seenInterface = true;
        lllllllllllllllllIlIIlIllIIlIIIl.startType();
        return lllllllllllllllllIlIIlIllIIlIIIl;
    }

    public SignatureVisitor visitClassBound() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIllIlIIIll;
        lllllllllllllllllIlIIlIllIlIIIll.separator = " extends ";
        lllllllllllllllllIlIIlIllIlIIIll.startType();
        return lllllllllllllllllIlIIlIllIlIIIll;
    }

    public void visitTypeArgument() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIlllll;
        if (lllllllllllllllllIlIIlIlIIIlllll.argumentStack % 2 == 0) {
            ++lllllllllllllllllIlIIlIlIIIlllll.argumentStack;
            lllllllllllllllllIlIIlIlIIIlllll.declaration.append('<');
        } else {
            lllllllllllllllllIlIIlIlIIIlllll.declaration.append(", ");
        }
        lllllllllllllllllIlIIlIlIIIlllll.declaration.append('?');
    }

    public SignatureVisitor visitReturnType() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIllllIll;
        lllllllllllllllllIlIIlIlIllllIll.endFormals();
        if (lllllllllllllllllIlIIlIlIllllIll.seenParameter) {
            lllllllllllllllllIlIIlIlIllllIll.seenParameter = false;
        } else {
            lllllllllllllllllIlIIlIlIllllIll.declaration.append('(');
        }
        lllllllllllllllllIlIIlIlIllllIll.declaration.append(')');
        lllllllllllllllllIlIIlIlIllllIll.returnType = new StringBuilder();
        return new TraceSignatureVisitor(lllllllllllllllllIlIIlIlIllllIll.returnType);
    }

    public String getReturnType() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIlIIII;
        return lllllllllllllllllIlIIlIlIIIlIIII.returnType == null ? null : String.valueOf(lllllllllllllllllIlIIlIlIIIlIIII.returnType);
    }

    private void endType() {
        TraceSignatureVisitor lllllllllllllllllIlIIlIlIIIIIlIl;
        if (lllllllllllllllllIlIIlIlIIIIIlIl.arrayStack % 2 == 0) {
            lllllllllllllllllIlIIlIlIIIIIlIl.arrayStack /= 2;
        } else {
            while (lllllllllllllllllIlIIlIlIIIIIlIl.arrayStack % 2 != 0) {
                lllllllllllllllllIlIIlIlIIIIIlIl.arrayStack /= 2;
                lllllllllllllllllIlIIlIlIIIIIlIl.declaration.append("[]");
            }
        }
    }
}

