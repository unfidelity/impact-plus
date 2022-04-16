/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.BasicInterpreter;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BasicVerifier
extends BasicInterpreter {
    @Override
    public void returnOperation(AbstractInsnNode llIlIlllIllllI, BasicValue llIlIllllIIIIl, BasicValue llIlIllllIIIII) throws AnalyzerException {
        BasicVerifier llIlIlllIlllll;
        if (!llIlIlllIlllll.isSubTypeOf(llIlIllllIIIIl, llIlIllllIIIII)) {
            throw new AnalyzerException(llIlIlllIllllI, "Incompatible return type", llIlIllllIIIII, llIlIllllIIIIl);
        }
    }

    protected boolean isSubTypeOf(BasicValue llIlIlllIIIIII, BasicValue llIlIlllIIIIIl) {
        return llIlIlllIIIIII.equals(llIlIlllIIIIIl);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public BasicValue binaryOperation(AbstractInsnNode llIllIlIIlIIII, BasicValue llIllIlIIIlIIl, BasicValue llIllIlIIIlllI) throws AnalyzerException {
        void llIllIlIIIllII;
        void llIllIlIIIllIl;
        BasicVerifier llIllIlIIIlIll;
        switch (llIllIlIIlIIII.getOpcode()) {
            case 46: {
                BasicValue llIllIlIllIIIl = llIllIlIIIlIll.newValue(Type.getType("[I"));
                BasicValue llIllIlIllIIII = BasicValue.INT_VALUE;
                break;
            }
            case 51: {
                if (llIllIlIIIlIll.isSubTypeOf(llIllIlIIIlIIl, llIllIlIIIlIll.newValue(Type.getType("[Z")))) {
                    BasicValue llIllIlIlIllll = llIllIlIIIlIll.newValue(Type.getType("[Z"));
                } else {
                    BasicValue llIllIlIlIlllI = llIllIlIIIlIll.newValue(Type.getType("[B"));
                }
                BasicValue llIllIlIlIllIl = BasicValue.INT_VALUE;
                break;
            }
            case 52: {
                BasicValue llIllIlIlIllII = llIllIlIIIlIll.newValue(Type.getType("[C"));
                BasicValue llIllIlIlIlIll = BasicValue.INT_VALUE;
                break;
            }
            case 53: {
                BasicValue llIllIlIlIlIlI = llIllIlIIIlIll.newValue(Type.getType("[S"));
                BasicValue llIllIlIlIlIIl = BasicValue.INT_VALUE;
                break;
            }
            case 47: {
                BasicValue llIllIlIlIlIII = llIllIlIIIlIll.newValue(Type.getType("[J"));
                BasicValue llIllIlIlIIlll = BasicValue.INT_VALUE;
                break;
            }
            case 48: {
                BasicValue llIllIlIlIIllI = llIllIlIIIlIll.newValue(Type.getType("[F"));
                BasicValue llIllIlIlIIlIl = BasicValue.INT_VALUE;
                break;
            }
            case 49: {
                BasicValue llIllIlIlIIlII = llIllIlIIIlIll.newValue(Type.getType("[D"));
                BasicValue llIllIlIlIIIll = BasicValue.INT_VALUE;
                break;
            }
            case 50: {
                BasicValue llIllIlIlIIIlI = llIllIlIIIlIll.newValue(Type.getType("[Ljava/lang/Object;"));
                BasicValue llIllIlIlIIIIl = BasicValue.INT_VALUE;
                break;
            }
            case 96: 
            case 100: 
            case 104: 
            case 108: 
            case 112: 
            case 120: 
            case 122: 
            case 124: 
            case 126: 
            case 128: 
            case 130: 
            case 159: 
            case 160: 
            case 161: 
            case 162: 
            case 163: 
            case 164: {
                BasicValue llIllIlIlIIIII = BasicValue.INT_VALUE;
                BasicValue llIllIlIIlllll = BasicValue.INT_VALUE;
                break;
            }
            case 98: 
            case 102: 
            case 106: 
            case 110: 
            case 114: 
            case 149: 
            case 150: {
                BasicValue llIllIlIIllllI = BasicValue.FLOAT_VALUE;
                BasicValue llIllIlIIlllIl = BasicValue.FLOAT_VALUE;
                break;
            }
            case 97: 
            case 101: 
            case 105: 
            case 109: 
            case 113: 
            case 127: 
            case 129: 
            case 131: 
            case 148: {
                BasicValue llIllIlIIlllII = BasicValue.LONG_VALUE;
                BasicValue llIllIlIIllIll = BasicValue.LONG_VALUE;
                break;
            }
            case 121: 
            case 123: 
            case 125: {
                BasicValue llIllIlIIllIlI = BasicValue.LONG_VALUE;
                BasicValue llIllIlIIllIIl = BasicValue.INT_VALUE;
                break;
            }
            case 99: 
            case 103: 
            case 107: 
            case 111: 
            case 115: 
            case 151: 
            case 152: {
                BasicValue llIllIlIIllIII = BasicValue.DOUBLE_VALUE;
                BasicValue llIllIlIIlIlll = BasicValue.DOUBLE_VALUE;
                break;
            }
            case 165: 
            case 166: {
                BasicValue llIllIlIIlIllI = BasicValue.REFERENCE_VALUE;
                BasicValue llIllIlIIlIlIl = BasicValue.REFERENCE_VALUE;
                break;
            }
            case 181: {
                FieldInsnNode llIllIlIIlIIlI = (FieldInsnNode)llIllIlIIlIIII;
                BasicValue llIllIlIIlIlII = llIllIlIIIlIll.newValue(Type.getObjectType(llIllIlIIlIIlI.owner));
                BasicValue llIllIlIIlIIll = llIllIlIIIlIll.newValue(Type.getType(llIllIlIIlIIlI.desc));
                break;
            }
            default: {
                throw new Error("Internal error.");
            }
        }
        if (!llIllIlIIIlIll.isSubTypeOf(llIllIlIIIlIIl, (BasicValue)llIllIlIIIllIl)) {
            throw new AnalyzerException(llIllIlIIlIIII, "First argument", llIllIlIIIllIl, llIllIlIIIlIIl);
        }
        if (!llIllIlIIIlIll.isSubTypeOf(llIllIlIIIlllI, (BasicValue)llIllIlIIIllII)) {
            throw new AnalyzerException(llIllIlIIlIIII, "Second argument", llIllIlIIIllII, llIllIlIIIlllI);
        }
        if (llIllIlIIlIIII.getOpcode() == 50) {
            return llIllIlIIIlIll.getElementValue(llIllIlIIIlIIl);
        }
        return super.binaryOperation(llIllIlIIlIIII, llIllIlIIIlIIl, llIllIlIIIlllI);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public BasicValue unaryOperation(AbstractInsnNode llIllIlIllllll, BasicValue llIllIlIlllIlI) throws AnalyzerException {
        void llIllIlIllllIl;
        BasicVerifier llIllIlIllllII;
        switch (llIllIlIllllll.getOpcode()) {
            case 116: 
            case 132: 
            case 133: 
            case 134: 
            case 135: 
            case 145: 
            case 146: 
            case 147: 
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: 
            case 170: 
            case 171: 
            case 172: 
            case 188: 
            case 189: {
                BasicValue llIllIllIIIllI = BasicValue.INT_VALUE;
                break;
            }
            case 118: 
            case 139: 
            case 140: 
            case 141: 
            case 174: {
                BasicValue llIllIllIIIlIl = BasicValue.FLOAT_VALUE;
                break;
            }
            case 117: 
            case 136: 
            case 137: 
            case 138: 
            case 173: {
                BasicValue llIllIllIIIlII = BasicValue.LONG_VALUE;
                break;
            }
            case 119: 
            case 142: 
            case 143: 
            case 144: 
            case 175: {
                BasicValue llIllIllIIIIll = BasicValue.DOUBLE_VALUE;
                break;
            }
            case 180: {
                BasicValue llIllIllIIIIlI = llIllIlIllllII.newValue(Type.getObjectType(((FieldInsnNode)llIllIlIllllll).owner));
                break;
            }
            case 192: {
                if (!llIllIlIlllIlI.isReference()) {
                    throw new AnalyzerException(llIllIlIllllll, null, "an object reference", llIllIlIlllIlI);
                }
                return super.unaryOperation(llIllIlIllllll, llIllIlIlllIlI);
            }
            case 190: {
                if (!llIllIlIllllII.isArrayValue(llIllIlIlllIlI)) {
                    throw new AnalyzerException(llIllIlIllllll, null, "an array reference", llIllIlIlllIlI);
                }
                return super.unaryOperation(llIllIlIllllll, llIllIlIlllIlI);
            }
            case 176: 
            case 191: 
            case 193: 
            case 194: 
            case 195: 
            case 198: 
            case 199: {
                if (!llIllIlIlllIlI.isReference()) {
                    throw new AnalyzerException(llIllIlIllllll, null, "an object reference", llIllIlIlllIlI);
                }
                return super.unaryOperation(llIllIlIllllll, llIllIlIlllIlI);
            }
            case 179: {
                BasicValue llIllIllIIIIIl = llIllIlIllllII.newValue(Type.getType(((FieldInsnNode)llIllIlIllllll).desc));
                break;
            }
            default: {
                throw new Error("Internal error.");
            }
        }
        if (!llIllIlIllllII.isSubTypeOf(llIllIlIlllIlI, (BasicValue)llIllIlIllllIl)) {
            throw new AnalyzerException(llIllIlIllllll, null, llIllIlIllllIl, llIllIlIlllIlI);
        }
        return super.unaryOperation(llIllIlIllllll, llIllIlIlllIlI);
    }

    protected BasicValue getElementValue(BasicValue llIlIlllIIIlll) throws AnalyzerException {
        return BasicValue.REFERENCE_VALUE;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public BasicValue ternaryOperation(AbstractInsnNode llIllIIllIIIll, BasicValue llIllIIlIlIlII, BasicValue llIllIIllIIIII, BasicValue llIllIIlIlllll) throws AnalyzerException {
        void llIllIIlIllIlI;
        void llIllIIlIlllIl;
        BasicVerifier llIllIIlIllIII;
        switch (llIllIIllIIIll.getOpcode()) {
            case 79: {
                BasicValue llIllIIlllIlll = llIllIIlIllIII.newValue(Type.getType("[I"));
                BasicValue llIllIIlllIllI = BasicValue.INT_VALUE;
                break;
            }
            case 84: {
                if (llIllIIlIllIII.isSubTypeOf(llIllIIlIlIlII, llIllIIlIllIII.newValue(Type.getType("[Z")))) {
                    BasicValue llIllIIlllIlIl = llIllIIlIllIII.newValue(Type.getType("[Z"));
                } else {
                    BasicValue llIllIIlllIlII = llIllIIlIllIII.newValue(Type.getType("[B"));
                }
                BasicValue llIllIIlllIIll = BasicValue.INT_VALUE;
                break;
            }
            case 85: {
                BasicValue llIllIIlllIIlI = llIllIIlIllIII.newValue(Type.getType("[C"));
                BasicValue llIllIIlllIIIl = BasicValue.INT_VALUE;
                break;
            }
            case 86: {
                BasicValue llIllIIlllIIII = llIllIIlIllIII.newValue(Type.getType("[S"));
                BasicValue llIllIIllIllll = BasicValue.INT_VALUE;
                break;
            }
            case 80: {
                BasicValue llIllIIllIlllI = llIllIIlIllIII.newValue(Type.getType("[J"));
                BasicValue llIllIIllIllIl = BasicValue.LONG_VALUE;
                break;
            }
            case 81: {
                BasicValue llIllIIllIllII = llIllIIlIllIII.newValue(Type.getType("[F"));
                BasicValue llIllIIllIlIll = BasicValue.FLOAT_VALUE;
                break;
            }
            case 82: {
                BasicValue llIllIIllIlIlI = llIllIIlIllIII.newValue(Type.getType("[D"));
                BasicValue llIllIIllIlIIl = BasicValue.DOUBLE_VALUE;
                break;
            }
            case 83: {
                BasicValue llIllIIllIlIII = llIllIIlIlIlII;
                BasicValue llIllIIllIIllI = BasicValue.REFERENCE_VALUE;
                break;
            }
            default: {
                throw new Error("Internal error.");
            }
        }
        if (!llIllIIlIllIII.isSubTypeOf(llIllIIlIlIlII, (BasicValue)llIllIIlIlllIl)) {
            throw new AnalyzerException(llIllIIllIIIll, "First argument", String.valueOf(new StringBuilder().append("a ").append(llIllIIlIlllIl).append(" array reference")), llIllIIlIlIlII);
        }
        if (!BasicValue.INT_VALUE.equals(llIllIIllIIIII)) {
            throw new AnalyzerException(llIllIIllIIIll, "Second argument", BasicValue.INT_VALUE, llIllIIllIIIII);
        }
        if (!llIllIIlIllIII.isSubTypeOf(llIllIIlIlllll, (BasicValue)llIllIIlIllIlI)) {
            throw new AnalyzerException(llIllIIllIIIll, "Third argument", llIllIIlIllIlI, llIllIIlIlllll);
        }
        return null;
    }

    protected boolean isArrayValue(BasicValue llIlIlllIlIIlI) {
        return llIlIlllIlIIlI.isReference();
    }

    public BasicVerifier() {
        super(327680);
        BasicVerifier llIllIlllIIIII;
    }

    @Override
    public BasicValue naryOperation(AbstractInsnNode llIllIIIIIIIIl, List<? extends BasicValue> llIlIlllllllII) throws AnalyzerException {
        BasicVerifier llIllIIIIIIIlI;
        int llIllIIIIIIlII = llIllIIIIIIIIl.getOpcode();
        if (llIllIIIIIIlII == 197) {
            for (int llIllIIIIlIIlI = 0; llIllIIIIlIIlI < llIlIlllllllII.size(); ++llIllIIIIlIIlI) {
                if (BasicValue.INT_VALUE.equals(llIlIlllllllII.get(llIllIIIIlIIlI))) continue;
                throw new AnalyzerException(llIllIIIIIIIIl, null, BasicValue.INT_VALUE, llIlIlllllllII.get(llIllIIIIlIIlI));
            }
        } else {
            int llIllIIIIIlllI = 0;
            int llIllIIIIIllIl = 0;
            if (llIllIIIIIIlII != 184 && llIllIIIIIIlII != 186) {
                Type llIllIIIIlIIIl = Type.getObjectType(((MethodInsnNode)llIllIIIIIIIIl).owner);
                if (!llIllIIIIIIIlI.isSubTypeOf(llIlIlllllllII.get(llIllIIIIIlllI++), llIllIIIIIIIlI.newValue(llIllIIIIlIIIl))) {
                    throw new AnalyzerException(llIllIIIIIIIIl, "Method owner", llIllIIIIIIIlI.newValue(llIllIIIIlIIIl), llIlIlllllllII.get(0));
                }
            }
            String llIllIIIIIllII = llIllIIIIIIlII == 186 ? ((InvokeDynamicInsnNode)llIllIIIIIIIIl).desc : ((MethodInsnNode)llIllIIIIIIIIl).desc;
            Type[] llIllIIIIIlIll = Type.getArgumentTypes(llIllIIIIIllII);
            while (llIllIIIIIlllI < llIlIlllllllII.size()) {
                BasicValue llIllIIIIIllll;
                BasicValue llIllIIIIlIIII = llIllIIIIIIIlI.newValue(llIllIIIIIlIll[llIllIIIIIllIl++]);
                if (llIllIIIIIIIlI.isSubTypeOf(llIllIIIIIllll = llIlIlllllllII.get(llIllIIIIIlllI++), llIllIIIIlIIII)) continue;
                throw new AnalyzerException(llIllIIIIIIIIl, String.valueOf(new StringBuilder().append("Argument ").append(llIllIIIIIllIl)), llIllIIIIlIIII, llIllIIIIIllll);
            }
        }
        return super.naryOperation(llIllIIIIIIIIl, (List)llIlIlllllllII);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public BasicValue copyOperation(AbstractInsnNode llIllIllIIllIl, BasicValue llIllIllIIllII) throws AnalyzerException {
        void llIllIllIIlllI;
        switch (llIllIllIIllIl.getOpcode()) {
            case 21: 
            case 54: {
                BasicValue llIllIllIlIlIl = BasicValue.INT_VALUE;
                break;
            }
            case 23: 
            case 56: {
                BasicValue llIllIllIlIlII = BasicValue.FLOAT_VALUE;
                break;
            }
            case 22: 
            case 55: {
                BasicValue llIllIllIlIIll = BasicValue.LONG_VALUE;
                break;
            }
            case 24: 
            case 57: {
                BasicValue llIllIllIlIIlI = BasicValue.DOUBLE_VALUE;
                break;
            }
            case 25: {
                if (!llIllIllIIllII.isReference()) {
                    throw new AnalyzerException(llIllIllIIllIl, null, "an object reference", llIllIllIIllII);
                }
                return llIllIllIIllII;
            }
            case 58: {
                if (!llIllIllIIllII.isReference() && !BasicValue.RETURNADDRESS_VALUE.equals(llIllIllIIllII)) {
                    throw new AnalyzerException(llIllIllIIllIl, null, "an object reference or a return address", llIllIllIIllII);
                }
                return llIllIllIIllII;
            }
            default: {
                return llIllIllIIllII;
            }
        }
        if (!llIllIllIIlllI.equals(llIllIllIIllII)) {
            throw new AnalyzerException(llIllIllIIllIl, null, llIllIllIIlllI, llIllIllIIllII);
        }
        return llIllIllIIllII;
    }

    protected BasicVerifier(int llIllIllIllIll) {
        super(llIllIllIllIll);
        BasicVerifier llIllIllIlllII;
    }
}

