/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.util;

import com.google.common.base.Strings;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;

public class SignaturePrinter {
    private /* synthetic */ boolean fullyQualified;
    private final /* synthetic */ String name;
    private /* synthetic */ String modifiers;
    private final /* synthetic */ String[] argNames;
    private final /* synthetic */ Type returnType;
    private final /* synthetic */ Type[] argTypes;

    public static String getTypeName(Type lllIIlllIlIllI, boolean lllIIlllIlIIlI, boolean lllIIlllIlIlII) {
        switch (lllIIlllIlIllI.getSort()) {
            case 0: {
                return lllIIlllIlIIlI ? "Void" : "void";
            }
            case 1: {
                return lllIIlllIlIIlI ? "Boolean" : "boolean";
            }
            case 2: {
                return lllIIlllIlIIlI ? "Character" : "char";
            }
            case 3: {
                return lllIIlllIlIIlI ? "Byte" : "byte";
            }
            case 4: {
                return lllIIlllIlIIlI ? "Short" : "short";
            }
            case 5: {
                return lllIIlllIlIIlI ? "Integer" : "int";
            }
            case 6: {
                return lllIIlllIlIIlI ? "Float" : "float";
            }
            case 7: {
                return lllIIlllIlIIlI ? "Long" : "long";
            }
            case 8: {
                return lllIIlllIlIIlI ? "Double" : "double";
            }
            case 9: {
                return String.valueOf(new StringBuilder().append(SignaturePrinter.getTypeName(lllIIlllIlIllI.getElementType(), lllIIlllIlIIlI, lllIIlllIlIlII)).append(SignaturePrinter.arraySuffix(lllIIlllIlIllI)));
            }
            case 10: {
                String lllIIlllIlIlll = lllIIlllIlIllI.getClassName();
                if (!lllIIlllIlIlII) {
                    lllIIlllIlIlll = lllIIlllIlIlll.substring(lllIIlllIlIlll.lastIndexOf(46) + 1);
                }
                return lllIIlllIlIlll;
            }
        }
        return "Object";
    }

    private StringBuilder appendType(StringBuilder lllIlIIIIIllll, String lllIlIIIIIlIlI, String lllIlIIIIIlIIl) {
        SignaturePrinter lllIlIIIIlIIII;
        if (!lllIlIIIIlIIII.fullyQualified) {
            lllIlIIIIIlIlI = lllIlIIIIIlIlI.substring(lllIlIIIIIlIlI.lastIndexOf(46) + 1);
        }
        lllIlIIIIIllll.append(lllIlIIIIIlIlI);
        if (lllIlIIIIIlIlI.endsWith("CallbackInfoReturnable")) {
            lllIlIIIIIllll.append('<').append(SignaturePrinter.getTypeName(lllIlIIIIlIIII.returnType, true, lllIlIIIIlIIII.fullyQualified)).append('>');
        }
        if (lllIlIIIIIlIIl != null) {
            lllIlIIIIIllll.append(' ').append(lllIlIIIIIlIIl);
        }
        return lllIlIIIIIllll;
    }

    private static String arraySuffix(Type lllIIlllIIllIl) {
        return Strings.repeat((String)"[]", (int)lllIIlllIIllIl.getDimensions());
    }

    public void setModifiers(MethodNode lllIlIIlIlIllI) {
        SignaturePrinter lllIlIIlIlIlII;
        String lllIlIIlIlIlIl = SignaturePrinter.getTypeName(Type.getReturnType(lllIlIIlIlIllI.desc), false, lllIlIIlIlIlII.fullyQualified);
        if ((lllIlIIlIlIllI.access & 1) != 0) {
            lllIlIIlIlIlII.setModifiers(String.valueOf(new StringBuilder().append("public ").append(lllIlIIlIlIlIl)));
        } else if ((lllIlIIlIlIllI.access & 4) != 0) {
            lllIlIIlIlIlII.setModifiers(String.valueOf(new StringBuilder().append("protected ").append(lllIlIIlIlIlIl)));
        } else if ((lllIlIIlIlIllI.access & 2) != 0) {
            lllIlIIlIlIlII.setModifiers(String.valueOf(new StringBuilder().append("private ").append(lllIlIIlIlIlIl)));
        } else {
            lllIlIIlIlIlII.setModifiers(lllIlIIlIlIlIl);
        }
    }

    public SignaturePrinter(MemberInfo lllIlIlIllIIIl) {
        lllIlIlIllIlIl(lllIlIlIllIIIl.name, lllIlIlIllIIIl.desc);
        SignaturePrinter lllIlIlIllIlIl;
    }

    public String getFormattedArgs() {
        SignaturePrinter lllIlIIlIllllI;
        return String.valueOf(lllIlIIlIllllI.appendArgs(new StringBuilder(), true, true));
    }

    public boolean isFullyQualified() {
        SignaturePrinter lllIlIIlIIIIll;
        return lllIlIIlIIIIll.fullyQualified;
    }

    public SignaturePrinter(MethodNode lllIlIllIlIIII) {
        lllIlIllIIlllI(lllIlIllIlIIII.name, Type.VOID_TYPE, Type.getArgumentTypes(lllIlIllIlIIII.desc));
        SignaturePrinter lllIlIllIIlllI;
        lllIlIllIIlllI.setModifiers(lllIlIllIlIIII);
    }

    public String getReturnType() {
        SignaturePrinter lllIlIIlIllIll;
        return SignaturePrinter.getTypeName(lllIlIIlIllIll.returnType, false, lllIlIIlIllIll.fullyQualified);
    }

    public SignaturePrinter(MethodNode lllIlIlIlllIIl, String[] lllIlIlIlllIll) {
        lllIlIlIlllIlI(lllIlIlIlllIIl.name, Type.VOID_TYPE, Type.getArgumentTypes(lllIlIlIlllIIl.desc), lllIlIlIlllIll);
        SignaturePrinter lllIlIlIlllIlI;
        lllIlIlIlllIlI.setModifiers(lllIlIlIlllIIl);
    }

    public String toDescriptor() {
        SignaturePrinter lllIlIIIllllIl;
        StringBuilder lllIlIIIllllII = lllIlIIIllllIl.appendArgs(new StringBuilder(), true, false);
        return String.valueOf(lllIlIIIllllII.append(SignaturePrinter.getTypeName(lllIlIIIllllIl.returnType, false, lllIlIIIllllIl.fullyQualified)));
    }

    public SignaturePrinter setModifiers(String lllIlIIlIIllII) {
        SignaturePrinter lllIlIIlIIllIl;
        lllIlIIlIIllIl.modifiers = lllIlIIlIIllII.replace("${returnType}", lllIlIIlIIllIl.getReturnType());
        return lllIlIIlIIllIl;
    }

    public static String getTypeName(Type lllIlIIIIIIllI, boolean lllIlIIIIIIIll) {
        return SignaturePrinter.getTypeName(lllIlIIIIIIllI, lllIlIIIIIIIll, false);
    }

    public SignaturePrinter setFullyQualified(boolean lllIlIIlIIlIII) {
        SignaturePrinter lllIlIIlIIlIIl;
        lllIlIIlIIlIIl.fullyQualified = lllIlIIlIIlIII;
        return lllIlIIlIIlIIl;
    }

    private StringBuilder appendArgs(StringBuilder lllIlIIIlIlIll, boolean lllIlIIIlIlIlI, boolean lllIlIIIlIlIIl) {
        SignaturePrinter lllIlIIIllIIII;
        lllIlIIIlIlIll.append('(');
        for (int lllIlIIIllIIIl = 0; lllIlIIIllIIIl < lllIlIIIllIIII.argTypes.length; ++lllIlIIIllIIIl) {
            if (lllIlIIIllIIII.argTypes[lllIlIIIllIIIl] == null) continue;
            if (lllIlIIIllIIIl > 0) {
                lllIlIIIlIlIll.append(',');
                if (lllIlIIIlIlIIl) {
                    lllIlIIIlIlIll.append(' ');
                }
            }
            try {
                String lllIlIIIllIIll = lllIlIIIlIlIlI ? null : (Strings.isNullOrEmpty((String)lllIlIIIllIIII.argNames[lllIlIIIllIIIl]) ? String.valueOf(new StringBuilder().append("unnamed").append(lllIlIIIllIIIl)) : lllIlIIIllIIII.argNames[lllIlIIIllIIIl]);
                lllIlIIIllIIII.appendType(lllIlIIIlIlIll, lllIlIIIllIIII.argTypes[lllIlIIIllIIIl], lllIlIIIllIIll);
                continue;
            }
            catch (Exception lllIlIIIllIIlI) {
                throw new RuntimeException(lllIlIIIllIIlI);
            }
        }
        return lllIlIIIlIlIll.append(")");
    }

    public SignaturePrinter(String lllIlIlIlIIllI, String lllIlIlIlIIlIl) {
        lllIlIlIlIlIlI(lllIlIlIlIIllI, Type.getReturnType(lllIlIlIlIIlIl), Type.getArgumentTypes(lllIlIlIlIIlIl));
        SignaturePrinter lllIlIlIlIlIlI;
    }

    public String toString() {
        SignaturePrinter lllIlIIlIIIIIl;
        return String.valueOf(lllIlIIlIIIIIl.appendArgs(new StringBuilder().append(lllIlIIlIIIIIl.modifiers).append(" ").append(lllIlIIlIIIIIl.name), false, true));
    }

    public SignaturePrinter(String lllIlIIlllIIll, Type lllIlIIlllIllI, LocalVariableNode[] lllIlIIlllIlIl) {
        SignaturePrinter lllIlIIllllIII;
        lllIlIIllllIII.modifiers = "private void";
        lllIlIIllllIII.name = lllIlIIlllIIll;
        lllIlIIllllIII.returnType = lllIlIIlllIllI;
        lllIlIIllllIII.argTypes = new Type[lllIlIIlllIlIl.length];
        lllIlIIllllIII.argNames = new String[lllIlIIlllIlIl.length];
        for (int lllIlIIllllIIl = 0; lllIlIIllllIIl < lllIlIIlllIlIl.length; ++lllIlIIllllIIl) {
            if (lllIlIIlllIlIl[lllIlIIllllIIl] == null) continue;
            lllIlIIllllIII.argTypes[lllIlIIllllIIl] = Type.getType(lllIlIIlllIlIl[lllIlIIllllIIl].desc);
            lllIlIIllllIII.argNames[lllIlIIllllIIl] = lllIlIIlllIlIl[lllIlIIllllIIl].name;
        }
    }

    public SignaturePrinter(String lllIlIIllIIlII, Type lllIlIIllIIIll, Type[] lllIlIIllIIIlI, String[] lllIlIIllIIIIl) {
        SignaturePrinter lllIlIIllIIlIl;
        lllIlIIllIIlIl.modifiers = "private void";
        lllIlIIllIIlIl.name = lllIlIIllIIlII;
        lllIlIIllIIlIl.returnType = lllIlIIllIIIll;
        lllIlIIllIIlIl.argTypes = lllIlIIllIIIlI;
        lllIlIIllIIlIl.argNames = lllIlIIllIIIIl;
        if (lllIlIIllIIlIl.argTypes.length > lllIlIIllIIlIl.argNames.length) {
            throw new IllegalArgumentException(String.format("Types array length must not exceed names array length! (names=%d, types=%d)", lllIlIIllIIlIl.argNames.length, lllIlIIllIIlIl.argTypes.length));
        }
    }

    private StringBuilder appendType(StringBuilder lllIlIIIIllllI, Type lllIlIIIIllIIl, String lllIlIIIIllIII) {
        SignaturePrinter lllIlIIIIlllll;
        switch (lllIlIIIIllIIl.getSort()) {
            case 9: {
                return SignaturePrinter.appendArraySuffix(lllIlIIIIlllll.appendType(lllIlIIIIllllI, lllIlIIIIllIIl.getElementType(), lllIlIIIIllIII), lllIlIIIIllIIl);
            }
            case 10: {
                return lllIlIIIIlllll.appendType(lllIlIIIIllllI, lllIlIIIIllIIl.getClassName(), lllIlIIIIllIII);
            }
        }
        lllIlIIIIllllI.append(SignaturePrinter.getTypeName(lllIlIIIIllIIl, false, lllIlIIIIlllll.fullyQualified));
        if (lllIlIIIIllIII != null) {
            lllIlIIIIllllI.append(' ').append(lllIlIIIIllIII);
        }
        return lllIlIIIIllllI;
    }

    public SignaturePrinter(String lllIlIlIIIllIl, Type lllIlIlIIIllII, Type[] lllIlIlIIIlIll) {
        SignaturePrinter lllIlIlIIIlIlI;
        lllIlIlIIIlIlI.modifiers = "private void";
        lllIlIlIIIlIlI.name = lllIlIlIIIllIl;
        lllIlIlIIIlIlI.returnType = lllIlIlIIIllII;
        lllIlIlIIIlIlI.argTypes = new Type[lllIlIlIIIlIll.length];
        lllIlIlIIIlIlI.argNames = new String[lllIlIlIIIlIll.length];
        int lllIlIlIIlIIII = 0;
        for (int lllIlIlIIlIIIl = 0; lllIlIlIIlIIIl < lllIlIlIIIlIll.length; ++lllIlIlIIlIIIl) {
            if (lllIlIlIIIlIll[lllIlIlIIlIIIl] == null) continue;
            lllIlIlIIIlIlI.argTypes[lllIlIlIIlIIIl] = lllIlIlIIIlIll[lllIlIlIIlIIIl];
            lllIlIlIIIlIlI.argNames[lllIlIlIIlIIIl] = String.valueOf(new StringBuilder().append("var").append(lllIlIlIIlIIII++));
        }
    }

    private static StringBuilder appendArraySuffix(StringBuilder lllIIlllIIIIIl, Type lllIIlllIIIIll) {
        for (int lllIIlllIIIllI = 0; lllIIlllIIIllI < lllIIlllIIIIll.getDimensions(); ++lllIIlllIIIllI) {
            lllIIlllIIIIIl.append("[]");
        }
        return lllIIlllIIIIIl;
    }
}

