/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Type {
    public static final /* synthetic */ int BYTE;
    public static final /* synthetic */ int BOOLEAN;
    private final /* synthetic */ char[] buf;
    public static final /* synthetic */ Type CHAR_TYPE;
    public static final /* synthetic */ int VOID;
    public static final /* synthetic */ int FLOAT;
    public static final /* synthetic */ int DOUBLE;
    public static final /* synthetic */ Type BYTE_TYPE;
    public static final /* synthetic */ Type FLOAT_TYPE;
    public static final /* synthetic */ Type INT_TYPE;
    public static final /* synthetic */ int ARRAY;
    public static final /* synthetic */ int CHAR;
    public static final /* synthetic */ Type LONG_TYPE;
    public static final /* synthetic */ Type SHORT_TYPE;
    public static final /* synthetic */ int LONG;
    public static final /* synthetic */ int INT;
    private final /* synthetic */ int off;
    public static final /* synthetic */ Type BOOLEAN_TYPE;
    public static final /* synthetic */ int OBJECT;
    private final /* synthetic */ int sort;
    public static final /* synthetic */ Type VOID_TYPE;
    private final /* synthetic */ int len;
    public static final /* synthetic */ int SHORT;
    public static final /* synthetic */ int METHOD;
    public static final /* synthetic */ Type DOUBLE_TYPE;

    public boolean equals(Object lllllllllllllllllllllIlllllIlIlI) {
        Type lllllllllllllllllllllIlllllIlIll;
        if (lllllllllllllllllllllIlllllIlIll == lllllllllllllllllllllIlllllIlIlI) {
            return true;
        }
        if (!(lllllllllllllllllllllIlllllIlIlI instanceof Type)) {
            return false;
        }
        Type lllllllllllllllllllllIlllllIlIIl = (Type)lllllllllllllllllllllIlllllIlIlI;
        if (lllllllllllllllllllllIlllllIlIll.sort != lllllllllllllllllllllIlllllIlIIl.sort) {
            return false;
        }
        if (lllllllllllllllllllllIlllllIlIll.sort >= 9) {
            if (lllllllllllllllllllllIlllllIlIll.len != lllllllllllllllllllllIlllllIlIIl.len) {
                return false;
            }
            int lllllllllllllllllllllIlllllIlllI = lllllllllllllllllllllIlllllIlIll.off;
            int lllllllllllllllllllllIlllllIllIl = lllllllllllllllllllllIlllllIlIIl.off;
            int lllllllllllllllllllllIlllllIllII = lllllllllllllllllllllIlllllIlllI + lllllllllllllllllllllIlllllIlIll.len;
            while (lllllllllllllllllllllIlllllIlllI < lllllllllllllllllllllIlllllIllII) {
                if (lllllllllllllllllllllIlllllIlIll.buf[lllllllllllllllllllllIlllllIlllI] != lllllllllllllllllllllIlllllIlIIl.buf[lllllllllllllllllllllIlllllIllIl]) {
                    return false;
                }
                ++lllllllllllllllllllllIlllllIlllI;
                ++lllllllllllllllllllllIlllllIllIl;
            }
        }
        return true;
    }

    public String getDescriptor() {
        Type llllllllllllllllllllllIIllIIIIll;
        StringBuilder llllllllllllllllllllllIIllIIIlII = new StringBuilder();
        llllllllllllllllllllllIIllIIIIll.getDescriptor(llllllllllllllllllllllIIllIIIlII);
        return String.valueOf(llllllllllllllllllllllIIllIIIlII);
    }

    public int getSort() {
        Type llllllllllllllllllllllIlIIIlIlll;
        return llllllllllllllllllllllIlIIIlIlll.sort;
    }

    public static String getMethodDescriptor(Method llllllllllllllllllllllIIlIIIIIll) {
        Class<?>[] llllllllllllllllllllllIIlIIIIlIl = llllllllllllllllllllllIIlIIIIIll.getParameterTypes();
        StringBuilder llllllllllllllllllllllIIlIIIIlII = new StringBuilder();
        llllllllllllllllllllllIIlIIIIlII.append('(');
        for (int llllllllllllllllllllllIIlIIIIlll = 0; llllllllllllllllllllllIIlIIIIlll < llllllllllllllllllllllIIlIIIIlIl.length; ++llllllllllllllllllllllIIlIIIIlll) {
            Type.getDescriptor(llllllllllllllllllllllIIlIIIIlII, llllllllllllllllllllllIIlIIIIlIl[llllllllllllllllllllllIIlIIIIlll]);
        }
        llllllllllllllllllllllIIlIIIIlII.append(')');
        Type.getDescriptor(llllllllllllllllllllllIIlIIIIlII, llllllllllllllllllllllIIlIIIIIll.getReturnType());
        return String.valueOf(llllllllllllllllllllllIIlIIIIlII);
    }

    public static Type getObjectType(String llllllllllllllllllllllIllIlIIIIl) {
        char[] llllllllllllllllllllllIllIlIIIlI = llllllllllllllllllllllIllIlIIIIl.toCharArray();
        return new Type(llllllllllllllllllllllIllIlIIIlI[0] == '[' ? 9 : 10, llllllllllllllllllllllIllIlIIIlI, 0, llllllllllllllllllllllIllIlIIIlI.length);
    }

    public int getSize() {
        Type llllllllllllllllllllllIIIIlIIIll;
        return llllllllllllllllllllllIIIIlIIIll.buf == null ? llllllllllllllllllllllIIIIlIIIll.off & 0xFF : 1;
    }

    public static Type getMethodType(String llllllllllllllllllllllIllIIlllIl) {
        return Type.getType(llllllllllllllllllllllIllIIlllIl.toCharArray(), 0);
    }

    public static Type getType(Constructor<?> llllllllllllllllllllllIllIIlIIlI) {
        return Type.getType(Type.getConstructorDescriptor(llllllllllllllllllllllIllIIlIIlI));
    }

    private static void getDescriptor(StringBuilder llllllllllllllllllllllIIIIlIlllI, Class<?> llllllllllllllllllllllIIIIlIlIlI) {
        Class<?> llllllllllllllllllllllIIIIlIllII = llllllllllllllllllllllIIIIlIlIlI;
        while (true) {
            if (llllllllllllllllllllllIIIIlIllII.isPrimitive()) {
                int llllllllllllllllllllllIIIIllIIll;
                if (llllllllllllllllllllllIIIIlIllII == Integer.TYPE) {
                    int llllllllllllllllllllllIIIIlllIll = 73;
                } else if (llllllllllllllllllllllIIIIlIllII == Void.TYPE) {
                    int llllllllllllllllllllllIIIIlllIlI = 86;
                } else if (llllllllllllllllllllllIIIIlIllII == Boolean.TYPE) {
                    int llllllllllllllllllllllIIIIlllIIl = 90;
                } else if (llllllllllllllllllllllIIIIlIllII == Byte.TYPE) {
                    int llllllllllllllllllllllIIIIlllIII = 66;
                } else if (llllllllllllllllllllllIIIIlIllII == Character.TYPE) {
                    int llllllllllllllllllllllIIIIllIlll = 67;
                } else if (llllllllllllllllllllllIIIIlIllII == Short.TYPE) {
                    int llllllllllllllllllllllIIIIllIllI = 83;
                } else if (llllllllllllllllllllllIIIIlIllII == Double.TYPE) {
                    int llllllllllllllllllllllIIIIllIlIl = 68;
                } else if (llllllllllllllllllllllIIIIlIllII == Float.TYPE) {
                    int llllllllllllllllllllllIIIIllIlII = 70;
                } else {
                    llllllllllllllllllllllIIIIllIIll = 74;
                }
                llllllllllllllllllllllIIIIlIlllI.append((char)llllllllllllllllllllllIIIIllIIll);
                return;
            }
            if (!llllllllllllllllllllllIIIIlIllII.isArray()) break;
            llllllllllllllllllllllIIIIlIlllI.append('[');
            llllllllllllllllllllllIIIIlIllII = llllllllllllllllllllllIIIIlIllII.getComponentType();
        }
        llllllllllllllllllllllIIIIlIlllI.append('L');
        String llllllllllllllllllllllIIIIllIIII = llllllllllllllllllllllIIIIlIllII.getName();
        int llllllllllllllllllllllIIIIlIllll = llllllllllllllllllllllIIIIllIIII.length();
        for (int llllllllllllllllllllllIIIIllIIIl = 0; llllllllllllllllllllllIIIIllIIIl < llllllllllllllllllllllIIIIlIllll; ++llllllllllllllllllllllIIIIllIIIl) {
            char llllllllllllllllllllllIIIIllIIlI = llllllllllllllllllllllIIIIllIIII.charAt(llllllllllllllllllllllIIIIllIIIl);
            llllllllllllllllllllllIIIIlIlllI.append(llllllllllllllllllllllIIIIllIIlI == '.' ? (char)'/' : (char)llllllllllllllllllllllIIIIllIIlI);
        }
        llllllllllllllllllllllIIIIlIlllI.append(';');
    }

    private void getDescriptor(StringBuilder llllllllllllllllllllllIIlIlIIIIl) {
        Type llllllllllllllllllllllIIlIlIIlII;
        if (llllllllllllllllllllllIIlIlIIlII.buf == null) {
            llllllllllllllllllllllIIlIlIIIIl.append((char)((llllllllllllllllllllllIIlIlIIlII.off & 0xFF000000) >>> 24));
        } else if (llllllllllllllllllllllIIlIlIIlII.sort == 10) {
            llllllllllllllllllllllIIlIlIIIIl.append('L');
            llllllllllllllllllllllIIlIlIIIIl.append(llllllllllllllllllllllIIlIlIIlII.buf, llllllllllllllllllllllIIlIlIIlII.off, llllllllllllllllllllllIIlIlIIlII.len);
            llllllllllllllllllllllIIlIlIIIIl.append(';');
        } else {
            llllllllllllllllllllllIIlIlIIIIl.append(llllllllllllllllllllllIIlIlIIlII.buf, llllllllllllllllllllllIIlIlIIlII.off, llllllllllllllllllllllIIlIlIIlII.len);
        }
    }

    public int hashCode() {
        Type lllllllllllllllllllllIllllIlIIlI;
        int lllllllllllllllllllllIllllIlIIll = 13 * lllllllllllllllllllllIllllIlIIlI.sort;
        if (lllllllllllllllllllllIllllIlIIlI.sort >= 9) {
            int lllllllllllllllllllllIllllIllIII;
            int lllllllllllllllllllllIllllIlIlll = lllllllllllllllllllllIllllIllIII + lllllllllllllllllllllIllllIlIIlI.len;
            for (lllllllllllllllllllllIllllIllIII = lllllllllllllllllllllIllllIlIIlI.off; lllllllllllllllllllllIllllIllIII < lllllllllllllllllllllIllllIlIlll; ++lllllllllllllllllllllIllllIllIII) {
                lllllllllllllllllllllIllllIlIIll = 17 * (lllllllllllllllllllllIllllIlIIll + lllllllllllllllllllllIllllIlIIlI.buf[lllllllllllllllllllllIllllIllIII]);
            }
        }
        return lllllllllllllllllllllIllllIlIIll;
    }

    public Type getReturnType() {
        Type llllllllllllllllllllllIIllIlIlll;
        return Type.getReturnType(llllllllllllllllllllllIIllIlIlll.getDescriptor());
    }

    public static Type getMethodType(Type llllllllllllllllllllllIllIIllIII, Type ... llllllllllllllllllllllIllIIllIIl) {
        return Type.getType(Type.getMethodDescriptor(llllllllllllllllllllllIllIIllIII, llllllllllllllllllllllIllIIllIIl));
    }

    public int getDimensions() {
        Type llllllllllllllllllllllIlIIIIlIII;
        int llllllllllllllllllllllIlIIIIlIIl = 1;
        while (llllllllllllllllllllllIlIIIIlIII.buf[llllllllllllllllllllllIlIIIIlIII.off + llllllllllllllllllllllIlIIIIlIIl] == '[') {
            ++llllllllllllllllllllllIlIIIIlIIl;
        }
        return llllllllllllllllllllllIlIIIIlIIl;
    }

    public int getOpcode(int llllllllllllllllllllllIIIIIlIIII) {
        Type llllllllllllllllllllllIIIIIlIlIl;
        if (llllllllllllllllllllllIIIIIlIIII == 46 || llllllllllllllllllllllIIIIIlIIII == 79) {
            return llllllllllllllllllllllIIIIIlIIII + (llllllllllllllllllllllIIIIIlIlIl.buf == null ? (llllllllllllllllllllllIIIIIlIlIl.off & 0xFF00) >> 8 : 4);
        }
        return llllllllllllllllllllllIIIIIlIIII + (llllllllllllllllllllllIIIIIlIlIl.buf == null ? (llllllllllllllllllllllIIIIIlIlIl.off & 0xFF0000) >> 16 : 4);
    }

    public Type[] getArgumentTypes() {
        Type llllllllllllllllllllllIIllIllIll;
        return Type.getArgumentTypes(llllllllllllllllllllllIIllIllIll.getDescriptor());
    }

    public String getInternalName() {
        Type llllllllllllllllllllllIIllIllllI;
        return new String(llllllllllllllllllllllIIllIllllI.buf, llllllllllllllllllllllIIllIllllI.off, llllllllllllllllllllllIIllIllllI.len);
    }

    public static String getDescriptor(Class<?> llllllllllllllllllllllIIlIIllIIl) {
        StringBuilder llllllllllllllllllllllIIlIIllIlI = new StringBuilder();
        Type.getDescriptor(llllllllllllllllllllllIIlIIllIlI, llllllllllllllllllllllIIlIIllIIl);
        return String.valueOf(llllllllllllllllllllllIIlIIllIlI);
    }

    static {
        CHAR = 2;
        OBJECT = 10;
        SHORT = 4;
        ARRAY = 9;
        FLOAT = 6;
        DOUBLE = 8;
        BOOLEAN = 1;
        BYTE = 3;
        METHOD = 11;
        VOID = 0;
        INT = 5;
        LONG = 7;
        VOID_TYPE = new Type(0, null, 0x56050000, 1);
        BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
        CHAR_TYPE = new Type(2, null, 1124075009, 1);
        BYTE_TYPE = new Type(3, null, 1107297537, 1);
        SHORT_TYPE = new Type(4, null, 1392510721, 1);
        INT_TYPE = new Type(5, null, 1224736769, 1);
        FLOAT_TYPE = new Type(6, null, 1174536705, 1);
        LONG_TYPE = new Type(7, null, 1241579778, 1);
        DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    }

    public static Type getType(Method llllllllllllllllllllllIllIIIllll) {
        return Type.getType(Type.getMethodDescriptor(llllllllllllllllllllllIllIIIllll));
    }

    public static String getConstructorDescriptor(Constructor<?> llllllllllllllllllllllIIlIIIllll) {
        Class<?>[] llllllllllllllllllllllIIlIIlIIIl = llllllllllllllllllllllIIlIIIllll.getParameterTypes();
        StringBuilder llllllllllllllllllllllIIlIIlIIII = new StringBuilder();
        llllllllllllllllllllllIIlIIlIIII.append('(');
        for (int llllllllllllllllllllllIIlIIlIIll = 0; llllllllllllllllllllllIIlIIlIIll < llllllllllllllllllllllIIlIIlIIIl.length; ++llllllllllllllllllllllIIlIIlIIll) {
            Type.getDescriptor(llllllllllllllllllllllIIlIIlIIII, llllllllllllllllllllllIIlIIlIIIl[llllllllllllllllllllllIIlIIlIIll]);
        }
        return String.valueOf(llllllllllllllllllllllIIlIIlIIII.append(")V"));
    }

    public static String getInternalName(Class<?> llllllllllllllllllllllIIlIIllllI) {
        return llllllllllllllllllllllIIlIIllllI.getName().replace('.', '/');
    }

    public static Type getType(String llllllllllllllllllllllIllIlIIlll) {
        return Type.getType(llllllllllllllllllllllIllIlIIlll.toCharArray(), 0);
    }

    public String toString() {
        Type lllllllllllllllllllllIllllIIIIII;
        return lllllllllllllllllllllIllllIIIIII.getDescriptor();
    }

    public static int getArgumentsAndReturnSizes(String llllllllllllllllllllllIlIIllIIlI) {
        int llllllllllllllllllllllIlIIllIIIl = 1;
        int llllllllllllllllllllllIlIIllIIII = 1;
        while (true) {
            char llllllllllllllllllllllIlIIllIIll;
            if ((llllllllllllllllllllllIlIIllIIll = llllllllllllllllllllllIlIIllIIlI.charAt(llllllllllllllllllllllIlIIllIIII++)) == ')') {
                llllllllllllllllllllllIlIIllIIll = llllllllllllllllllllllIlIIllIIlI.charAt(llllllllllllllllllllllIlIIllIIII);
                return llllllllllllllllllllllIlIIllIIIl << 2 | (llllllllllllllllllllllIlIIllIIll == 'V' ? 0 : (llllllllllllllllllllllIlIIllIIll == 'D' || llllllllllllllllllllllIlIIllIIll == 'J' ? 2 : 1));
            }
            if (llllllllllllllllllllllIlIIllIIll == 'L') {
                while (llllllllllllllllllllllIlIIllIIlI.charAt(llllllllllllllllllllllIlIIllIIII++) != ';') {
                }
                ++llllllllllllllllllllllIlIIllIIIl;
                continue;
            }
            if (llllllllllllllllllllllIlIIllIIll == '[') {
                while ((llllllllllllllllllllllIlIIllIIll = llllllllllllllllllllllIlIIllIIlI.charAt(llllllllllllllllllllllIlIIllIIII)) == '[') {
                    ++llllllllllllllllllllllIlIIllIIII;
                }
                if (llllllllllllllllllllllIlIIllIIll != 'D' && llllllllllllllllllllllIlIIllIIll != 'J') continue;
                --llllllllllllllllllllllIlIIllIIIl;
                continue;
            }
            if (llllllllllllllllllllllIlIIllIIll == 'D' || llllllllllllllllllllllIlIIllIIll == 'J') {
                llllllllllllllllllllllIlIIllIIIl += 2;
                continue;
            }
            ++llllllllllllllllllllllIlIIllIIIl;
        }
    }

    private static Type getType(char[] llllllllllllllllllllllIlIIIlllIl, int llllllllllllllllllllllIlIIIlllII) {
        switch (llllllllllllllllllllllIlIIIlllIl[llllllllllllllllllllllIlIIIlllII]) {
            case 'V': {
                return VOID_TYPE;
            }
            case 'Z': {
                return BOOLEAN_TYPE;
            }
            case 'C': {
                return CHAR_TYPE;
            }
            case 'B': {
                return BYTE_TYPE;
            }
            case 'S': {
                return SHORT_TYPE;
            }
            case 'I': {
                return INT_TYPE;
            }
            case 'F': {
                return FLOAT_TYPE;
            }
            case 'J': {
                return LONG_TYPE;
            }
            case 'D': {
                return DOUBLE_TYPE;
            }
            case '[': {
                int llllllllllllllllllllllIlIIIlllll = 1;
                while (llllllllllllllllllllllIlIIIlllIl[llllllllllllllllllllllIlIIIlllII + llllllllllllllllllllllIlIIIlllll] == '[') {
                    ++llllllllllllllllllllllIlIIIlllll;
                }
                if (llllllllllllllllllllllIlIIIlllIl[llllllllllllllllllllllIlIIIlllII + llllllllllllllllllllllIlIIIlllll] == 'L') {
                    ++llllllllllllllllllllllIlIIIlllll;
                    while (llllllllllllllllllllllIlIIIlllIl[llllllllllllllllllllllIlIIIlllII + llllllllllllllllllllllIlIIIlllll] != ';') {
                        ++llllllllllllllllllllllIlIIIlllll;
                    }
                }
                return new Type(9, llllllllllllllllllllllIlIIIlllIl, llllllllllllllllllllllIlIIIlllII, llllllllllllllllllllllIlIIIlllll + 1);
            }
            case 'L': {
                int llllllllllllllllllllllIlIIIllllI = 1;
                while (llllllllllllllllllllllIlIIIlllIl[llllllllllllllllllllllIlIIIlllII + llllllllllllllllllllllIlIIIllllI] != ';') {
                    ++llllllllllllllllllllllIlIIIllllI;
                }
                return new Type(10, llllllllllllllllllllllIlIIIlllIl, llllllllllllllllllllllIlIIIlllII + 1, llllllllllllllllllllllIlIIIllllI - 1);
            }
        }
        return new Type(11, llllllllllllllllllllllIlIIIlllIl, llllllllllllllllllllllIlIIIlllII, llllllllllllllllllllllIlIIIlllIl.length - llllllllllllllllllllllIlIIIlllII);
    }

    public int getArgumentsAndReturnSizes() {
        Type llllllllllllllllllllllIIllIIllll;
        return Type.getArgumentsAndReturnSizes(llllllllllllllllllllllIIllIIllll.getDescriptor());
    }

    public static Type getType(Class<?> llllllllllllllllllllllIllIIlIlII) {
        if (llllllllllllllllllllllIllIIlIlII.isPrimitive()) {
            if (llllllllllllllllllllllIllIIlIlII == Integer.TYPE) {
                return INT_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Void.TYPE) {
                return VOID_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Boolean.TYPE) {
                return BOOLEAN_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Byte.TYPE) {
                return BYTE_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Character.TYPE) {
                return CHAR_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Short.TYPE) {
                return SHORT_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Double.TYPE) {
                return DOUBLE_TYPE;
            }
            if (llllllllllllllllllllllIllIIlIlII == Float.TYPE) {
                return FLOAT_TYPE;
            }
            return LONG_TYPE;
        }
        return Type.getType(Type.getDescriptor(llllllllllllllllllllllIllIIlIlII));
    }

    public static Type[] getArgumentTypes(String llllllllllllllllllllllIllIIIIIlI) {
        char llllllllllllllllllllllIllIIIlIII;
        char[] llllllllllllllllllllllIllIIIIllI = llllllllllllllllllllllIllIIIIIlI.toCharArray();
        int llllllllllllllllllllllIllIIIIlIl = 1;
        int llllllllllllllllllllllIllIIIIlII = 0;
        while ((llllllllllllllllllllllIllIIIlIII = llllllllllllllllllllllIllIIIIllI[llllllllllllllllllllllIllIIIIlIl++]) != ')') {
            if (llllllllllllllllllllllIllIIIlIII == 'L') {
                while (llllllllllllllllllllllIllIIIIllI[llllllllllllllllllllllIllIIIIlIl++] != ';') {
                }
                ++llllllllllllllllllllllIllIIIIlII;
                continue;
            }
            if (llllllllllllllllllllllIllIIIlIII == '[') continue;
            ++llllllllllllllllllllllIllIIIIlII;
        }
        Type[] llllllllllllllllllllllIllIIIIIll = new Type[llllllllllllllllllllllIllIIIIlII];
        llllllllllllllllllllllIllIIIIlIl = 1;
        llllllllllllllllllllllIllIIIIlII = 0;
        while (llllllllllllllllllllllIllIIIIllI[llllllllllllllllllllllIllIIIIlIl] != ')') {
            llllllllllllllllllllllIllIIIIIll[llllllllllllllllllllllIllIIIIlII] = Type.getType(llllllllllllllllllllllIllIIIIllI, llllllllllllllllllllllIllIIIIlIl);
            llllllllllllllllllllllIllIIIIlIl += llllllllllllllllllllllIllIIIIIll[llllllllllllllllllllllIllIIIIlII].len + (llllllllllllllllllllllIllIIIIIll[llllllllllllllllllllllIllIIIIlII].sort == 10 ? 2 : 0);
            ++llllllllllllllllllllllIllIIIIlII;
        }
        return llllllllllllllllllllllIllIIIIIll;
    }

    public static Type getReturnType(Method llllllllllllllllllllllIlIlIlIlll) {
        return Type.getType(llllllllllllllllllllllIlIlIlIlll.getReturnType());
    }

    private Type(int llllllllllllllllllllllIllIlIllII, char[] llllllllllllllllllllllIllIlIlIll, int llllllllllllllllllllllIllIlIlIlI, int llllllllllllllllllllllIllIlIlIIl) {
        Type llllllllllllllllllllllIllIllIIlI;
        llllllllllllllllllllllIllIllIIlI.sort = llllllllllllllllllllllIllIlIllII;
        llllllllllllllllllllllIllIllIIlI.buf = llllllllllllllllllllllIllIlIlIll;
        llllllllllllllllllllllIllIllIIlI.off = llllllllllllllllllllllIllIlIlIlI;
        llllllllllllllllllllllIllIllIIlI.len = llllllllllllllllllllllIllIlIlIIl;
    }

    public String getClassName() {
        Type llllllllllllllllllllllIIlllIlIlI;
        switch (llllllllllllllllllllllIIlllIlIlI.sort) {
            case 0: {
                return "void";
            }
            case 1: {
                return "boolean";
            }
            case 2: {
                return "char";
            }
            case 3: {
                return "byte";
            }
            case 4: {
                return "short";
            }
            case 5: {
                return "int";
            }
            case 6: {
                return "float";
            }
            case 7: {
                return "long";
            }
            case 8: {
                return "double";
            }
            case 9: {
                StringBuilder llllllllllllllllllllllIIlllIlllI = new StringBuilder(llllllllllllllllllllllIIlllIlIlI.getElementType().getClassName());
                for (int llllllllllllllllllllllIIllllIIII = llllllllllllllllllllllIIlllIlIlI.getDimensions(); llllllllllllllllllllllIIllllIIII > 0; --llllllllllllllllllllllIIllllIIII) {
                    llllllllllllllllllllllIIlllIlllI.append("[]");
                }
                return String.valueOf(llllllllllllllllllllllIIlllIlllI);
            }
            case 10: {
                return new String(llllllllllllllllllllllIIlllIlIlI.buf, llllllllllllllllllllllIIlllIlIlI.off, llllllllllllllllllllllIIlllIlIlI.len).replace('/', '.');
            }
        }
        return null;
    }

    public static Type[] getArgumentTypes(Method llllllllllllllllllllllIlIlllIIII) {
        Class<?>[] llllllllllllllllllllllIlIlllIIll = llllllllllllllllllllllIlIlllIIII.getParameterTypes();
        Type[] llllllllllllllllllllllIlIlllIIIl = new Type[llllllllllllllllllllllIlIlllIIll.length];
        for (int llllllllllllllllllllllIlIlllIlIl = llllllllllllllllllllllIlIlllIIll.length - 1; llllllllllllllllllllllIlIlllIlIl >= 0; --llllllllllllllllllllllIlIlllIlIl) {
            llllllllllllllllllllllIlIlllIIIl[llllllllllllllllllllllIlIlllIlIl] = Type.getType(llllllllllllllllllllllIlIlllIIll[llllllllllllllllllllllIlIlllIlIl]);
        }
        return llllllllllllllllllllllIlIlllIIIl;
    }

    public Type getElementType() {
        Type llllllllllllllllllllllIlIIIIIlII;
        return Type.getType(llllllllllllllllllllllIlIIIIIlII.buf, llllllllllllllllllllllIlIIIIIlII.off + llllllllllllllllllllllIlIIIIIlII.getDimensions());
    }

    public static String getMethodDescriptor(Type llllllllllllllllllllllIIlIlIllll, Type ... llllllllllllllllllllllIIlIlIlIIl) {
        StringBuilder llllllllllllllllllllllIIlIlIlIll = new StringBuilder();
        llllllllllllllllllllllIIlIlIlIll.append('(');
        for (int llllllllllllllllllllllIIlIllIIIl = 0; llllllllllllllllllllllIIlIllIIIl < llllllllllllllllllllllIIlIlIlIIl.length; ++llllllllllllllllllllllIIlIllIIIl) {
            llllllllllllllllllllllIIlIlIlIIl[llllllllllllllllllllllIIlIllIIIl].getDescriptor(llllllllllllllllllllllIIlIlIlIll);
        }
        llllllllllllllllllllllIIlIlIlIll.append(')');
        llllllllllllllllllllllIIlIlIllll.getDescriptor(llllllllllllllllllllllIIlIlIlIll);
        return String.valueOf(llllllllllllllllllllllIIlIlIlIll);
    }

    /*
     * Unable to fully structure code
     */
    public static Type getReturnType(String llllllllllllllllllllllIlIlIlllII) {
        llllllllllllllllllllllIlIlIllllI = llllllllllllllllllllllIlIlIlllII.toCharArray();
        llllllllllllllllllllllIlIlIlllIl = 1;
        block0: while (true) {
            if ((llllllllllllllllllllllIlIllIIIII = llllllllllllllllllllllIlIlIllllI[llllllllllllllllllllllIlIlIlllIl++]) == ')') {
                return Type.getType(llllllllllllllllllllllIlIlIllllI, llllllllllllllllllllllIlIlIlllIl);
            }
            if (llllllllllllllllllllllIlIllIIIII != 'L') continue;
            while (true) {
                if (llllllllllllllllllllllIlIlIllllI[llllllllllllllllllllllIlIlIlllIl++] != ';') ** break;
                continue block0;
            }
            break;
        }
    }
}

