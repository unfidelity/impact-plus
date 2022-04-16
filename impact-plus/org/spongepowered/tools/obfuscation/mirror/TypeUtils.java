/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mirror;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import org.spongepowered.asm.util.SignaturePrinter;
import org.spongepowered.tools.obfuscation.mirror.Visibility;

public abstract class TypeUtils {
    private static final /* synthetic */ String OBJECT_SIG;
    private static final /* synthetic */ String OBJECT_REF;
    private static final /* synthetic */ int MAX_GENERIC_RECURSION_DEPTH;

    public static String stripGenerics(String llIIIlIIIlllI) {
        StringBuilder llIIIlIIIllll = new StringBuilder();
        int llIIIlIIlIIIl = 0;
        for (int llIIIlIIlIIlI = 0; llIIIlIIlIIlI < llIIIlIIIlllI.length(); ++llIIIlIIlIIlI) {
            char llIIIlIIlIIll = llIIIlIIIlllI.charAt(llIIIlIIlIIlI);
            if (llIIIlIIlIIll == '<') {
                ++llIIIlIIlIIIl;
            }
            if (llIIIlIIlIIIl == 0) {
                llIIIlIIIllll.append(llIIIlIIlIIll);
                continue;
            }
            if (llIIIlIIlIIll != '>') continue;
            --llIIIlIIlIIIl;
        }
        return String.valueOf(llIIIlIIIllll);
    }

    public static String getDescriptor(Element llIIIIllIIlll) {
        if (llIIIIllIIlll instanceof ExecutableElement) {
            return TypeUtils.getDescriptor((ExecutableElement)llIIIIllIIlll);
        }
        if (llIIIIllIIlll instanceof VariableElement) {
            return TypeUtils.getInternalName((VariableElement)llIIIIllIIlll);
        }
        return TypeUtils.getInternalName(llIIIIllIIlll.asType());
    }

    private static TypeMirror toRawType(ProcessingEnvironment llIIIIIIlllll, DeclaredType llIIIIIlIIIII) {
        return llIIIIIIlllll.getElementUtils().getTypeElement(((TypeElement)llIIIIIlIIIII.asElement()).getQualifiedName()).asType();
    }

    public static String getInternalName(TypeElement llIIIIlIIlllI) {
        if (llIIIIlIIlllI == null) {
            return null;
        }
        StringBuilder llIIIIlIIllIl = new StringBuilder();
        llIIIIlIIllIl.append(llIIIIlIIlllI.getSimpleName());
        for (Element llIIIIlIIllII = llIIIIlIIlllI.getEnclosingElement(); llIIIIlIIllII != null; llIIIIlIIllII = llIIIIlIIllII.getEnclosingElement()) {
            if (llIIIIlIIllII instanceof TypeElement) {
                llIIIIlIIllIl.insert(0, "$").insert(0, llIIIIlIIllII.getSimpleName());
                continue;
            }
            if (!(llIIIIlIIllII instanceof PackageElement)) continue;
            llIIIIlIIllIl.insert(0, "/").insert(0, ((PackageElement)llIIIIlIIllII).getQualifiedName().toString().replace('.', '/'));
        }
        return String.valueOf(llIIIIlIIllIl);
    }

    private TypeUtils() {
        TypeUtils llIIIlIlIIllI;
    }

    public static Visibility getVisibility(Element llIIIIIIlIlll) {
        if (llIIIIIIlIlll == null) {
            return null;
        }
        for (Modifier llIIIIIIllIlI : llIIIIIIlIlll.getModifiers()) {
            switch (llIIIIIIllIlI) {
                case PUBLIC: {
                    return Visibility.PUBLIC;
                }
                case PROTECTED: {
                    return Visibility.PROTECTED;
                }
                case PRIVATE: {
                    return Visibility.PRIVATE;
                }
            }
        }
        return Visibility.PACKAGE;
    }

    public static String getName(VariableElement llIIIlIIIlIII) {
        return llIIIlIIIlIII != null ? llIIIlIIIlIII.getSimpleName().toString() : null;
    }

    private static DeclaredType getUpperBound(TypeMirror llIIIIlIIIIll) {
        try {
            return TypeUtils.getUpperBound0(llIIIIlIIIIll, 5);
        }
        catch (IllegalStateException llIIIIlIIIllI) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Type symbol \"").append(llIIIIlIIIIll).append("\" is too complex")), llIIIIlIIIllI);
        }
        catch (IllegalArgumentException llIIIIlIIIlIl) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unable to compute upper bound of type symbol ").append(llIIIIlIIIIll)), llIIIIlIIIlIl);
        }
    }

    public static PackageElement getPackage(TypeMirror llIIIlIlIIIlI) {
        if (!(llIIIlIlIIIlI instanceof DeclaredType)) {
            return null;
        }
        return TypeUtils.getPackage((TypeElement)((DeclaredType)llIIIlIlIIIlI).asElement());
    }

    static {
        OBJECT_REF = "java/lang/Object";
        MAX_GENERIC_RECURSION_DEPTH = 5;
        OBJECT_SIG = "java.lang.Object";
    }

    public static boolean isAssignable(ProcessingEnvironment llIIIIIlIlIIl, TypeMirror llIIIIIlIllII, TypeMirror llIIIIIlIlIll) {
        boolean llIIIIIlIlIlI = llIIIIIlIlIIl.getTypeUtils().isAssignable(llIIIIIlIllII, llIIIIIlIlIll);
        if (!llIIIIIlIlIlI && llIIIIIlIllII instanceof DeclaredType && llIIIIIlIlIll instanceof DeclaredType) {
            TypeMirror llIIIIIlIllll = TypeUtils.toRawType(llIIIIIlIlIIl, (DeclaredType)llIIIIIlIllII);
            TypeMirror llIIIIIlIlllI = TypeUtils.toRawType(llIIIIIlIlIIl, (DeclaredType)llIIIIIlIlIll);
            return llIIIIIlIlIIl.getTypeUtils().isAssignable(llIIIIIlIllll, llIIIIIlIlllI);
        }
        return llIIIIIlIlIlI;
    }

    public static String getInternalName(VariableElement llIIIIlIllIII) {
        if (llIIIIlIllIII == null) {
            return null;
        }
        return TypeUtils.getInternalName(llIIIIlIllIII.asType());
    }

    public static String getJavaSignature(Element llIIIIllllIII) {
        if (llIIIIllllIII instanceof ExecutableElement) {
            ExecutableElement llIIIIlllllII = (ExecutableElement)llIIIIllllIII;
            StringBuilder llIIIIllllIll = new StringBuilder().append("(");
            boolean llIIIIllllIlI = false;
            for (VariableElement variableElement : llIIIIlllllII.getParameters()) {
                if (llIIIIllllIlI) {
                    llIIIIllllIll.append(',');
                }
                llIIIIllllIll.append(TypeUtils.getTypeName(variableElement.asType()));
                llIIIIllllIlI = true;
            }
            llIIIIllllIll.append(')').append(TypeUtils.getTypeName(llIIIIlllllII.getReturnType()));
            return String.valueOf(llIIIIllllIll);
        }
        return TypeUtils.getTypeName(llIIIIllllIII.asType());
    }

    private static DeclaredType getUpperBound0(TypeMirror llIIIIIlllIII, int llIIIIIlllIIl) {
        if (llIIIIIlllIIl == 0) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Generic symbol \"").append(llIIIIIlllIII).append("\" is too complex, exceeded ").append(5).append(" iterations attempting to determine upper bound")));
        }
        if (llIIIIIlllIII instanceof DeclaredType) {
            return (DeclaredType)llIIIIIlllIII;
        }
        if (llIIIIIlllIII instanceof TypeVariable) {
            try {
                TypeMirror llIIIIIlllllI = ((TypeVariable)llIIIIIlllIII).getUpperBound();
                return TypeUtils.getUpperBound0(llIIIIIlllllI, --llIIIIIlllIIl);
            }
            catch (IllegalStateException llIIIIIllllIl) {
                throw llIIIIIllllIl;
            }
            catch (IllegalArgumentException llIIIIIllllII) {
                throw llIIIIIllllII;
            }
            catch (Exception llIIIIIlllIll) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unable to compute upper bound of type symbol ").append(llIIIIIlllIII)));
            }
        }
        return null;
    }

    public static String getInternalName(DeclaredType llIIIIlIlIIlI) {
        if (llIIIIlIlIIlI == null) {
            return "java/lang/Object";
        }
        return TypeUtils.getInternalName((TypeElement)llIIIIlIlIIlI.asElement());
    }

    public static String getTypeName(TypeMirror llIIIIllIlllI) {
        switch (llIIIIllIlllI.getKind()) {
            case ARRAY: {
                return String.valueOf(new StringBuilder().append(TypeUtils.getTypeName(((ArrayType)llIIIIllIlllI).getComponentType())).append("[]"));
            }
            case DECLARED: {
                return TypeUtils.getTypeName((DeclaredType)llIIIIllIlllI);
            }
            case TYPEVAR: {
                return TypeUtils.getTypeName(TypeUtils.getUpperBound(llIIIIllIlllI));
            }
            case ERROR: {
                return "java.lang.Object";
            }
        }
        return llIIIIllIlllI.toString();
    }

    public static PackageElement getPackage(TypeElement llIIIlIIlllIl) {
        Element llIIIlIIllllI;
        for (llIIIlIIllllI = llIIIlIIlllIl.getEnclosingElement(); llIIIlIIllllI != null && !(llIIIlIIllllI instanceof PackageElement); llIIIlIIllllI = llIIIlIIllllI.getEnclosingElement()) {
        }
        return (PackageElement)llIIIlIIllllI;
    }

    public static String getDescriptor(ExecutableElement llIIIIlIllllI) {
        if (llIIIIlIllllI == null) {
            return null;
        }
        StringBuilder llIIIIllIIIII = new StringBuilder();
        for (VariableElement variableElement : llIIIIlIllllI.getParameters()) {
            llIIIIllIIIII.append(TypeUtils.getInternalName(variableElement));
        }
        String llIIIIlIlllll = TypeUtils.getInternalName(llIIIIlIllllI.getReturnType());
        return String.format("(%s)%s", llIIIIllIIIII, llIIIIlIlllll);
    }

    public static String getElementType(Element llIIIlIIllIlI) {
        if (llIIIlIIllIlI instanceof TypeElement) {
            return "TypeElement";
        }
        if (llIIIlIIllIlI instanceof ExecutableElement) {
            return "ExecutableElement";
        }
        if (llIIIlIIllIlI instanceof VariableElement) {
            return "VariableElement";
        }
        if (llIIIlIIllIlI instanceof PackageElement) {
            return "PackageElement";
        }
        if (llIIIlIIllIlI instanceof TypeParameterElement) {
            return "TypeParameterElement";
        }
        return llIIIlIIllIlI.getClass().getSimpleName();
    }

    public static String getName(ExecutableElement llIIIlIIIIlII) {
        return llIIIlIIIIlII != null ? llIIIlIIIIlII.getSimpleName().toString() : null;
    }

    public static String getTypeName(DeclaredType llIIIIllIlIlI) {
        if (llIIIIllIlIlI == null) {
            return "java.lang.Object";
        }
        return TypeUtils.getInternalName((TypeElement)llIIIIllIlIlI.asElement()).replace('/', '.');
    }

    public static String getInternalName(TypeMirror llIIIIlIlIlIl) {
        switch (llIIIIlIlIlIl.getKind()) {
            case ARRAY: {
                return String.valueOf(new StringBuilder().append("[").append(TypeUtils.getInternalName(((ArrayType)llIIIIlIlIlIl).getComponentType())));
            }
            case DECLARED: {
                return String.valueOf(new StringBuilder().append("L").append(TypeUtils.getInternalName((DeclaredType)llIIIIlIlIlIl)).append(";"));
            }
            case TYPEVAR: {
                return String.valueOf(new StringBuilder().append("L").append(TypeUtils.getInternalName(TypeUtils.getUpperBound(llIIIIlIlIlIl))).append(";"));
            }
            case BOOLEAN: {
                return "Z";
            }
            case BYTE: {
                return "B";
            }
            case CHAR: {
                return "C";
            }
            case DOUBLE: {
                return "D";
            }
            case FLOAT: {
                return "F";
            }
            case INT: {
                return "I";
            }
            case LONG: {
                return "J";
            }
            case SHORT: {
                return "S";
            }
            case VOID: {
                return "V";
            }
            case ERROR: {
                return "Ljava/lang/Object;";
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unable to parse type symbol ").append(llIIIIlIlIlIl).append(" with ").append((Object)llIIIIlIlIlIl.getKind()).append(" to equivalent bytecode type")));
    }

    public static String getJavaSignature(String llIIIIlllIIIl) {
        return new SignaturePrinter("", llIIIIlllIIIl).setFullyQualified(true).toDescriptor();
    }
}

