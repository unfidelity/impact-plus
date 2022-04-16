/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.analysis.Value;

public class BasicValue
implements Value {
    public static final /* synthetic */ BasicValue DOUBLE_VALUE;
    public static final /* synthetic */ BasicValue FLOAT_VALUE;
    public static final /* synthetic */ BasicValue RETURNADDRESS_VALUE;
    public static final /* synthetic */ BasicValue REFERENCE_VALUE;
    private final /* synthetic */ Type type;
    public static final /* synthetic */ BasicValue LONG_VALUE;
    public static final /* synthetic */ BasicValue UNINITIALIZED_VALUE;
    public static final /* synthetic */ BasicValue INT_VALUE;

    static {
        UNINITIALIZED_VALUE = new BasicValue(null);
        INT_VALUE = new BasicValue(Type.INT_TYPE);
        FLOAT_VALUE = new BasicValue(Type.FLOAT_TYPE);
        LONG_VALUE = new BasicValue(Type.LONG_TYPE);
        DOUBLE_VALUE = new BasicValue(Type.DOUBLE_TYPE);
        REFERENCE_VALUE = new BasicValue(Type.getObjectType("java/lang/Object"));
        RETURNADDRESS_VALUE = new BasicValue(Type.VOID_TYPE);
    }

    public Type getType() {
        BasicValue lIllIIlllIllIIl;
        return lIllIIlllIllIIl.type;
    }

    public int hashCode() {
        BasicValue lIllIIlllIIlIlI;
        return lIllIIlllIIlIlI.type == null ? 0 : lIllIIlllIIlIlI.type.hashCode();
    }

    public String toString() {
        BasicValue lIllIIlllIIlIII;
        if (lIllIIlllIIlIII == UNINITIALIZED_VALUE) {
            return ".";
        }
        if (lIllIIlllIIlIII == RETURNADDRESS_VALUE) {
            return "A";
        }
        if (lIllIIlllIIlIII == REFERENCE_VALUE) {
            return "R";
        }
        return lIllIIlllIIlIII.type.getDescriptor();
    }

    public boolean isReference() {
        BasicValue lIllIIlllIlIIll;
        return lIllIIlllIlIIll.type != null && (lIllIIlllIlIIll.type.getSort() == 10 || lIllIIlllIlIIll.type.getSort() == 9);
    }

    public boolean equals(Object lIllIIlllIIllll) {
        BasicValue lIllIIlllIIlllI;
        if (lIllIIlllIIllll == lIllIIlllIIlllI) {
            return true;
        }
        if (lIllIIlllIIllll instanceof BasicValue) {
            if (lIllIIlllIIlllI.type == null) {
                return ((BasicValue)lIllIIlllIIllll).type == null;
            }
            return lIllIIlllIIlllI.type.equals(((BasicValue)lIllIIlllIIllll).type);
        }
        return false;
    }

    public int getSize() {
        BasicValue lIllIIlllIlIllI;
        return lIllIIlllIlIllI.type == Type.LONG_TYPE || lIllIIlllIlIllI.type == Type.DOUBLE_TYPE ? 2 : 1;
    }

    public BasicValue(Type lIllIIlllIllllI) {
        BasicValue lIllIIlllIlllIl;
        lIllIIlllIlllIl.type = lIllIIlllIllllI;
    }
}

