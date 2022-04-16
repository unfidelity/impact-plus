/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

public class TypeReference {
    public static final /* synthetic */ int CLASS_TYPE_PARAMETER_BOUND;
    public static final /* synthetic */ int CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT;
    public static final /* synthetic */ int METHOD_REFERENCE_TYPE_ARGUMENT;
    public static final /* synthetic */ int METHOD_TYPE_PARAMETER;
    public static final /* synthetic */ int CLASS_TYPE_PARAMETER;
    public static final /* synthetic */ int FIELD;
    public static final /* synthetic */ int LOCAL_VARIABLE;
    public static final /* synthetic */ int METHOD_REFERENCE;
    public static final /* synthetic */ int METHOD_FORMAL_PARAMETER;
    public static final /* synthetic */ int INSTANCEOF;
    public static final /* synthetic */ int METHOD_INVOCATION_TYPE_ARGUMENT;
    public static final /* synthetic */ int CONSTRUCTOR_REFERENCE;
    public static final /* synthetic */ int METHOD_RETURN;
    public static final /* synthetic */ int RESOURCE_VARIABLE;
    public static final /* synthetic */ int METHOD_TYPE_PARAMETER_BOUND;
    public static final /* synthetic */ int CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT;
    public static final /* synthetic */ int CAST;
    private /* synthetic */ int value;
    public static final /* synthetic */ int EXCEPTION_PARAMETER;
    public static final /* synthetic */ int NEW;
    public static final /* synthetic */ int CLASS_EXTENDS;
    public static final /* synthetic */ int METHOD_RECEIVER;
    public static final /* synthetic */ int THROWS;

    public int getSort() {
        TypeReference llllllllllllllllIllIIlIIlIlIlIIl;
        return llllllllllllllllIllIIlIIlIlIlIIl.value >>> 24;
    }

    public static TypeReference newTryCatchReference(int llllllllllllllllIllIIlIIlIllIIIl) {
        return new TypeReference(0x42000000 | llllllllllllllllIllIIlIIlIllIIIl << 8);
    }

    public int getFormalParameterIndex() {
        TypeReference llllllllllllllllIllIIlIIlIIlllII;
        return (llllllllllllllllIllIIlIIlIIlllII.value & 0xFF0000) >> 16;
    }

    public int getExceptionIndex() {
        TypeReference llllllllllllllllIllIIlIIlIIllIlI;
        return (llllllllllllllllIllIIlIIlIIllIlI.value & 0xFFFF00) >> 8;
    }

    public int getSuperTypeIndex() {
        TypeReference llllllllllllllllIllIIlIIlIIlllll;
        return (short)((llllllllllllllllIllIIlIIlIIlllll.value & 0xFFFF00) >> 8);
    }

    public static TypeReference newTypeArgumentReference(int llllllllllllllllIllIIlIIlIlIlllI, int llllllllllllllllIllIIlIIlIlIllIl) {
        return new TypeReference(llllllllllllllllIllIIlIIlIlIlllI << 24 | llllllllllllllllIllIIlIIlIlIllIl);
    }

    static {
        CLASS_EXTENDS = 16;
        NEW = 68;
        THROWS = 23;
        METHOD_TYPE_PARAMETER = 1;
        CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT = 72;
        METHOD_INVOCATION_TYPE_ARGUMENT = 73;
        FIELD = 19;
        METHOD_REFERENCE_TYPE_ARGUMENT = 75;
        METHOD_TYPE_PARAMETER_BOUND = 18;
        METHOD_RETURN = 20;
        CAST = 71;
        LOCAL_VARIABLE = 64;
        CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT = 74;
        INSTANCEOF = 67;
        METHOD_REFERENCE = 70;
        RESOURCE_VARIABLE = 65;
        METHOD_RECEIVER = 21;
        EXCEPTION_PARAMETER = 66;
        CLASS_TYPE_PARAMETER_BOUND = 17;
        CONSTRUCTOR_REFERENCE = 69;
        CLASS_TYPE_PARAMETER = 0;
        METHOD_FORMAL_PARAMETER = 22;
    }

    public static TypeReference newTypeParameterBoundReference(int llllllllllllllllIllIIlIIllIIIIlI, int llllllllllllllllIllIIlIIllIIIIIl, int llllllllllllllllIllIIlIIlIllllIl) {
        return new TypeReference(llllllllllllllllIllIIlIIllIIIIlI << 24 | llllllllllllllllIllIIlIIllIIIIIl << 16 | llllllllllllllllIllIIlIIlIllllIl << 8);
    }

    public static TypeReference newExceptionReference(int llllllllllllllllIllIIlIIlIllIlII) {
        return new TypeReference(0x17000000 | llllllllllllllllIllIIlIIlIllIlII << 8);
    }

    public static TypeReference newSuperTypeReference(int llllllllllllllllIllIIlIIlIlllIlI) {
        return new TypeReference(0x10000000 | (llllllllllllllllIllIIlIIlIlllIlI &= 0xFFFF) << 8);
    }

    public int getTypeParameterIndex() {
        TypeReference llllllllllllllllIllIIlIIlIlIIllI;
        return (llllllllllllllllIllIIlIIlIlIIllI.value & 0xFF0000) >> 16;
    }

    public int getTypeArgumentIndex() {
        TypeReference llllllllllllllllIllIIlIIlIIlIlII;
        return llllllllllllllllIllIIlIIlIIlIlII.value & 0xFF;
    }

    public int getTryCatchBlockIndex() {
        TypeReference llllllllllllllllIllIIlIIlIIlIlll;
        return (llllllllllllllllIllIIlIIlIIlIlll.value & 0xFFFF00) >> 8;
    }

    public int getValue() {
        TypeReference llllllllllllllllIllIIlIIlIIlIIII;
        return llllllllllllllllIllIIlIIlIIlIIII.value;
    }

    public int getTypeParameterBoundIndex() {
        TypeReference llllllllllllllllIllIIlIIlIlIIIll;
        return (llllllllllllllllIllIIlIIlIlIIIll.value & 0xFF00) >> 8;
    }

    public static TypeReference newFormalParameterReference(int llllllllllllllllIllIIlIIlIlllIII) {
        return new TypeReference(0x16000000 | llllllllllllllllIllIIlIIlIlllIII << 16);
    }

    public static TypeReference newTypeReference(int llllllllllllllllIllIIlIIllIIllIl) {
        return new TypeReference(llllllllllllllllIllIIlIIllIIllIl << 24);
    }

    public static TypeReference newTypeParameterReference(int llllllllllllllllIllIIlIIllIIlIIl, int llllllllllllllllIllIIlIIllIIlIII) {
        return new TypeReference(llllllllllllllllIllIIlIIllIIlIIl << 24 | llllllllllllllllIllIIlIIllIIlIII << 16);
    }

    public TypeReference(int llllllllllllllllIllIIlIIllIlIIIl) {
        TypeReference llllllllllllllllIllIIlIIllIlIIlI;
        llllllllllllllllIllIIlIIllIlIIlI.value = llllllllllllllllIllIIlIIllIlIIIl;
    }
}

