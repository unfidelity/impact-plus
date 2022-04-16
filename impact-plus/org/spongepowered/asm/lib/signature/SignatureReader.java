/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.signature;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

public class SignatureReader {
    private final /* synthetic */ String signature;

    public void acceptType(SignatureVisitor lllllllllllllllIllllIlIIIIlIlllI) {
        SignatureReader lllllllllllllllIllllIlIIIIllIIIl;
        SignatureReader.parseType(lllllllllllllllIllllIlIIIIllIIIl.signature, 0, lllllllllllllllIllllIlIIIIlIlllI);
    }

    private static int parseType(String lllllllllllllllIllllIlIIIIlIIIIl, int lllllllllllllllIllllIlIIIIIllIIl, SignatureVisitor lllllllllllllllIllllIlIIIIIllIII) {
        char lllllllllllllllIllllIlIIIIIllllI = lllllllllllllllIllllIlIIIIlIIIIl.charAt(lllllllllllllllIllllIlIIIIIllIIl++);
        switch (lllllllllllllllIllllIlIIIIIllllI) {
            case 'B': 
            case 'C': 
            case 'D': 
            case 'F': 
            case 'I': 
            case 'J': 
            case 'S': 
            case 'V': 
            case 'Z': {
                lllllllllllllllIllllIlIIIIIllIII.visitBaseType(lllllllllllllllIllllIlIIIIIllllI);
                return lllllllllllllllIllllIlIIIIIllIIl;
            }
            case '[': {
                return SignatureReader.parseType(lllllllllllllllIllllIlIIIIlIIIIl, lllllllllllllllIllllIlIIIIIllIIl, lllllllllllllllIllllIlIIIIIllIII.visitArrayType());
            }
            case 'T': {
                int lllllllllllllllIllllIlIIIIlIIlII = lllllllllllllllIllllIlIIIIlIIIIl.indexOf(59, lllllllllllllllIllllIlIIIIIllIIl);
                lllllllllllllllIllllIlIIIIIllIII.visitTypeVariable(lllllllllllllllIllllIlIIIIlIIIIl.substring(lllllllllllllllIllllIlIIIIIllIIl, lllllllllllllllIllllIlIIIIlIIlII));
                return lllllllllllllllIllllIlIIIIlIIlII + 1;
            }
        }
        int lllllllllllllllIllllIlIIIIIlllIl = lllllllllllllllIllllIlIIIIIllIIl;
        boolean lllllllllllllllIllllIlIIIIIlllII = false;
        boolean lllllllllllllllIllllIlIIIIIllIll = false;
        while (true) {
            lllllllllllllllIllllIlIIIIIllllI = lllllllllllllllIllllIlIIIIlIIIIl.charAt(lllllllllllllllIllllIlIIIIIllIIl++);
            block5 : switch (lllllllllllllllIllllIlIIIIIllllI) {
                case '.': 
                case ';': {
                    if (!lllllllllllllllIllllIlIIIIIlllII) {
                        String lllllllllllllllIllllIlIIIIlIIIll = lllllllllllllllIllllIlIIIIlIIIIl.substring(lllllllllllllllIllllIlIIIIIlllIl, lllllllllllllllIllllIlIIIIIllIIl - 1);
                        if (lllllllllllllllIllllIlIIIIIllIll) {
                            lllllllllllllllIllllIlIIIIIllIII.visitInnerClassType(lllllllllllllllIllllIlIIIIlIIIll);
                        } else {
                            lllllllllllllllIllllIlIIIIIllIII.visitClassType(lllllllllllllllIllllIlIIIIlIIIll);
                        }
                    }
                    if (lllllllllllllllIllllIlIIIIIllllI == ';') {
                        lllllllllllllllIllllIlIIIIIllIII.visitEnd();
                        return lllllllllllllllIllllIlIIIIIllIIl;
                    }
                    lllllllllllllllIllllIlIIIIIlllIl = lllllllllllllllIllllIlIIIIIllIIl;
                    lllllllllllllllIllllIlIIIIIlllII = false;
                    lllllllllllllllIllllIlIIIIIllIll = true;
                    break;
                }
                case '<': {
                    String lllllllllllllllIllllIlIIIIlIIIlI = lllllllllllllllIllllIlIIIIlIIIIl.substring(lllllllllllllllIllllIlIIIIIlllIl, lllllllllllllllIllllIlIIIIIllIIl - 1);
                    if (lllllllllllllllIllllIlIIIIIllIll) {
                        lllllllllllllllIllllIlIIIIIllIII.visitInnerClassType(lllllllllllllllIllllIlIIIIlIIIlI);
                    } else {
                        lllllllllllllllIllllIlIIIIIllIII.visitClassType(lllllllllllllllIllllIlIIIIlIIIlI);
                    }
                    lllllllllllllllIllllIlIIIIIlllII = true;
                    block15: while (true) {
                        lllllllllllllllIllllIlIIIIIllllI = lllllllllllllllIllllIlIIIIlIIIIl.charAt(lllllllllllllllIllllIlIIIIIllIIl);
                        switch (lllllllllllllllIllllIlIIIIIllllI) {
                            case '>': {
                                break block5;
                            }
                            case '*': {
                                ++lllllllllllllllIllllIlIIIIIllIIl;
                                lllllllllllllllIllllIlIIIIIllIII.visitTypeArgument();
                                continue block15;
                            }
                            case '+': 
                            case '-': {
                                lllllllllllllllIllllIlIIIIIllIIl = SignatureReader.parseType(lllllllllllllllIllllIlIIIIlIIIIl, lllllllllllllllIllllIlIIIIIllIIl + 1, lllllllllllllllIllllIlIIIIIllIII.visitTypeArgument(lllllllllllllllIllllIlIIIIIllllI));
                                continue block15;
                            }
                        }
                        lllllllllllllllIllllIlIIIIIllIIl = SignatureReader.parseType(lllllllllllllllIllllIlIIIIlIIIIl, lllllllllllllllIllllIlIIIIIllIIl, lllllllllllllllIllllIlIIIIIllIII.visitTypeArgument('='));
                    }
                }
            }
        }
    }

    public SignatureReader(String lllllllllllllllIllllIlIIIlIIllII) {
        SignatureReader lllllllllllllllIllllIlIIIlIIllIl;
        lllllllllllllllIllllIlIIIlIIllIl.signature = lllllllllllllllIllllIlIIIlIIllII;
    }

    public void accept(SignatureVisitor lllllllllllllllIllllIlIIIIlllIIl) {
        int lllllllllllllllIllllIlIIIIlllIll;
        SignatureReader lllllllllllllllIllllIlIIIIlllIlI;
        String lllllllllllllllIllllIlIIIIllllIl = lllllllllllllllIllllIlIIIIlllIlI.signature;
        int lllllllllllllllIllllIlIIIIllllII = lllllllllllllllIllllIlIIIIllllIl.length();
        if (lllllllllllllllIllllIlIIIIllllIl.charAt(0) == '<') {
            char lllllllllllllllIllllIlIIIlIIIIII;
            int lllllllllllllllIllllIlIIIlIIIIIl = 2;
            do {
                int lllllllllllllllIllllIlIIIlIIIIlI = lllllllllllllllIllllIlIIIIllllIl.indexOf(58, lllllllllllllllIllllIlIIIlIIIIIl);
                lllllllllllllllIllllIlIIIIlllIIl.visitFormalTypeParameter(lllllllllllllllIllllIlIIIIllllIl.substring(lllllllllllllllIllllIlIIIlIIIIIl - 1, lllllllllllllllIllllIlIIIlIIIIlI));
                lllllllllllllllIllllIlIIIlIIIIIl = lllllllllllllllIllllIlIIIlIIIIlI + 1;
                lllllllllllllllIllllIlIIIlIIIIII = lllllllllllllllIllllIlIIIIllllIl.charAt(lllllllllllllllIllllIlIIIlIIIIIl);
                if (lllllllllllllllIllllIlIIIlIIIIII == 'L' || lllllllllllllllIllllIlIIIlIIIIII == '[' || lllllllllllllllIllllIlIIIlIIIIII == 'T') {
                    lllllllllllllllIllllIlIIIlIIIIIl = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIlIIIIIl, lllllllllllllllIllllIlIIIIlllIIl.visitClassBound());
                }
                while ((lllllllllllllllIllllIlIIIlIIIIII = lllllllllllllllIllllIlIIIIllllIl.charAt(lllllllllllllllIllllIlIIIlIIIIIl++)) == ':') {
                    lllllllllllllllIllllIlIIIlIIIIIl = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIlIIIIIl, lllllllllllllllIllllIlIIIIlllIIl.visitInterfaceBound());
                }
            } while (lllllllllllllllIllllIlIIIlIIIIII != '>');
        } else {
            lllllllllllllllIllllIlIIIIlllIll = 0;
        }
        if (lllllllllllllllIllllIlIIIIllllIl.charAt(lllllllllllllllIllllIlIIIIlllIll) == '(') {
            ++lllllllllllllllIllllIlIIIIlllIll;
            while (lllllllllllllllIllllIlIIIIllllIl.charAt(lllllllllllllllIllllIlIIIIlllIll) != ')') {
                lllllllllllllllIllllIlIIIIlllIll = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIIlllIll, lllllllllllllllIllllIlIIIIlllIIl.visitParameterType());
            }
            lllllllllllllllIllllIlIIIIlllIll = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIIlllIll + 1, lllllllllllllllIllllIlIIIIlllIIl.visitReturnType());
            while (lllllllllllllllIllllIlIIIIlllIll < lllllllllllllllIllllIlIIIIllllII) {
                lllllllllllllllIllllIlIIIIlllIll = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIIlllIll + 1, lllllllllllllllIllllIlIIIIlllIIl.visitExceptionType());
            }
        } else {
            lllllllllllllllIllllIlIIIIlllIll = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIIlllIll, lllllllllllllllIllllIlIIIIlllIIl.visitSuperclass());
            while (lllllllllllllllIllllIlIIIIlllIll < lllllllllllllllIllllIlIIIIllllII) {
                lllllllllllllllIllllIlIIIIlllIll = SignatureReader.parseType(lllllllllllllllIllllIlIIIIllllIl, lllllllllllllllIllllIlIIIIlllIll, lllllllllllllllIllllIlIIIIlllIIl.visitInterface());
            }
        }
    }
}

