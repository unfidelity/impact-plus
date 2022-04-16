/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.List;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.IntInsnNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MultiANewArrayInsnNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.Interpreter;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BasicInterpreter
extends Interpreter<BasicValue>
implements Opcodes {
    @Override
    public BasicValue newOperation(AbstractInsnNode lllllllllllllllIlllIIlIlllIlIllI) throws AnalyzerException {
        switch (lllllllllllllllIlllIIlIlllIlIllI.getOpcode()) {
            case 1: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIllIIl;
                return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getObjectType("null"));
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return BasicValue.INT_VALUE;
            }
            case 9: 
            case 10: {
                return BasicValue.LONG_VALUE;
            }
            case 11: 
            case 12: 
            case 13: {
                return BasicValue.FLOAT_VALUE;
            }
            case 14: 
            case 15: {
                return BasicValue.DOUBLE_VALUE;
            }
            case 16: 
            case 17: {
                return BasicValue.INT_VALUE;
            }
            case 18: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIllIIl;
                Object lllllllllllllllIlllIIlIlllIllIlI = ((LdcInsnNode)lllllllllllllllIlllIIlIlllIlIllI).cst;
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof Integer) {
                    return BasicValue.INT_VALUE;
                }
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof Float) {
                    return BasicValue.FLOAT_VALUE;
                }
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof Long) {
                    return BasicValue.LONG_VALUE;
                }
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof Double) {
                    return BasicValue.DOUBLE_VALUE;
                }
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof String) {
                    return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getObjectType("java/lang/String"));
                }
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof Type) {
                    int lllllllllllllllIlllIIlIlllIllIll = ((Type)lllllllllllllllIlllIIlIlllIllIlI).getSort();
                    if (lllllllllllllllIlllIIlIlllIllIll == 10 || lllllllllllllllIlllIIlIlllIllIll == 9) {
                        return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getObjectType("java/lang/Class"));
                    }
                    if (lllllllllllllllIlllIIlIlllIllIll == 11) {
                        return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getObjectType("java/lang/invoke/MethodType"));
                    }
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Illegal LDC constant ").append(lllllllllllllllIlllIIlIlllIllIlI)));
                }
                if (lllllllllllllllIlllIIlIlllIllIlI instanceof Handle) {
                    return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getObjectType("java/lang/invoke/MethodHandle"));
                }
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Illegal LDC constant ").append(lllllllllllllllIlllIIlIlllIllIlI)));
            }
            case 168: {
                return BasicValue.RETURNADDRESS_VALUE;
            }
            case 178: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIllIIl;
                return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getType(((FieldInsnNode)lllllllllllllllIlllIIlIlllIlIllI).desc));
            }
            case 187: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIllIIl;
                return lllllllllllllllIlllIIlIlllIllIIl.newValue(Type.getObjectType(((TypeInsnNode)lllllllllllllllIlllIIlIlllIlIllI).desc));
            }
        }
        throw new Error("Internal error.");
    }

    @Override
    public BasicValue unaryOperation(AbstractInsnNode lllllllllllllllIlllIIlIlllIIlIII, BasicValue lllllllllllllllIlllIIlIlllIIIlll) throws AnalyzerException {
        switch (lllllllllllllllIlllIIlIlllIIlIII.getOpcode()) {
            case 116: 
            case 132: 
            case 136: 
            case 139: 
            case 142: 
            case 145: 
            case 146: 
            case 147: {
                return BasicValue.INT_VALUE;
            }
            case 118: 
            case 134: 
            case 137: 
            case 144: {
                return BasicValue.FLOAT_VALUE;
            }
            case 117: 
            case 133: 
            case 140: 
            case 143: {
                return BasicValue.LONG_VALUE;
            }
            case 119: 
            case 135: 
            case 138: 
            case 141: {
                return BasicValue.DOUBLE_VALUE;
            }
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: 
            case 170: 
            case 171: 
            case 172: 
            case 173: 
            case 174: 
            case 175: 
            case 176: 
            case 179: {
                return null;
            }
            case 180: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIIIllI;
                return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType(((FieldInsnNode)lllllllllllllllIlllIIlIlllIIlIII).desc));
            }
            case 188: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIIIllI;
                switch (((IntInsnNode)lllllllllllllllIlllIIlIlllIIlIII).operand) {
                    case 4: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[Z"));
                    }
                    case 5: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[C"));
                    }
                    case 8: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[B"));
                    }
                    case 9: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[S"));
                    }
                    case 10: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[I"));
                    }
                    case 6: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[F"));
                    }
                    case 7: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[D"));
                    }
                    case 11: {
                        return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType("[J"));
                    }
                }
                throw new AnalyzerException(lllllllllllllllIlllIIlIlllIIlIII, "Invalid array type");
            }
            case 189: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIIIllI;
                String lllllllllllllllIlllIIlIlllIIlIll = ((TypeInsnNode)lllllllllllllllIlllIIlIlllIIlIII).desc;
                return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getType(String.valueOf(new StringBuilder().append("[").append(Type.getObjectType(lllllllllllllllIlllIIlIlllIIlIll)))));
            }
            case 190: {
                return BasicValue.INT_VALUE;
            }
            case 191: {
                return null;
            }
            case 192: {
                BasicInterpreter lllllllllllllllIlllIIlIlllIIIllI;
                String lllllllllllllllIlllIIlIlllIIlIlI = ((TypeInsnNode)lllllllllllllllIlllIIlIlllIIlIII).desc;
                return lllllllllllllllIlllIIlIlllIIIllI.newValue(Type.getObjectType(lllllllllllllllIlllIIlIlllIIlIlI));
            }
            case 193: {
                return BasicValue.INT_VALUE;
            }
            case 194: 
            case 195: 
            case 198: 
            case 199: {
                return null;
            }
        }
        throw new Error("Internal error.");
    }

    @Override
    public BasicValue binaryOperation(AbstractInsnNode lllllllllllllllIlllIIlIllIlllllI, BasicValue lllllllllllllllIlllIIlIlllIIIIII, BasicValue lllllllllllllllIlllIIlIllIllllll) throws AnalyzerException {
        switch (lllllllllllllllIlllIIlIllIlllllI.getOpcode()) {
            case 46: 
            case 51: 
            case 52: 
            case 53: 
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
            case 130: {
                return BasicValue.INT_VALUE;
            }
            case 48: 
            case 98: 
            case 102: 
            case 106: 
            case 110: 
            case 114: {
                return BasicValue.FLOAT_VALUE;
            }
            case 47: 
            case 97: 
            case 101: 
            case 105: 
            case 109: 
            case 113: 
            case 121: 
            case 123: 
            case 125: 
            case 127: 
            case 129: 
            case 131: {
                return BasicValue.LONG_VALUE;
            }
            case 49: 
            case 99: 
            case 103: 
            case 107: 
            case 111: 
            case 115: {
                return BasicValue.DOUBLE_VALUE;
            }
            case 50: {
                return BasicValue.REFERENCE_VALUE;
            }
            case 148: 
            case 149: 
            case 150: 
            case 151: 
            case 152: {
                return BasicValue.INT_VALUE;
            }
            case 159: 
            case 160: 
            case 161: 
            case 162: 
            case 163: 
            case 164: 
            case 165: 
            case 166: 
            case 181: {
                return null;
            }
        }
        throw new Error("Internal error.");
    }

    protected BasicInterpreter(int lllllllllllllllIlllIIlIllllIIllI) {
        super(lllllllllllllllIlllIIlIllllIIllI);
        BasicInterpreter lllllllllllllllIlllIIlIllllIIlll;
    }

    @Override
    public void returnOperation(AbstractInsnNode lllllllllllllllIlllIIlIllIlIllIl, BasicValue lllllllllllllllIlllIIlIllIlIllII, BasicValue lllllllllllllllIlllIIlIllIlIlIll) throws AnalyzerException {
    }

    @Override
    public BasicValue newValue(Type lllllllllllllllIlllIIlIllllIIIII) {
        if (lllllllllllllllIlllIIlIllllIIIII == null) {
            return BasicValue.UNINITIALIZED_VALUE;
        }
        switch (lllllllllllllllIlllIIlIllllIIIII.getSort()) {
            case 0: {
                return null;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return BasicValue.INT_VALUE;
            }
            case 6: {
                return BasicValue.FLOAT_VALUE;
            }
            case 7: {
                return BasicValue.LONG_VALUE;
            }
            case 8: {
                return BasicValue.DOUBLE_VALUE;
            }
            case 9: 
            case 10: {
                return BasicValue.REFERENCE_VALUE;
            }
        }
        throw new Error("Internal error");
    }

    @Override
    public BasicValue merge(BasicValue lllllllllllllllIlllIIlIllIlIIlIl, BasicValue lllllllllllllllIlllIIlIllIlIIlII) {
        if (!lllllllllllllllIlllIIlIllIlIIlIl.equals(lllllllllllllllIlllIIlIllIlIIlII)) {
            return BasicValue.UNINITIALIZED_VALUE;
        }
        return lllllllllllllllIlllIIlIllIlIIlIl;
    }

    @Override
    public BasicValue ternaryOperation(AbstractInsnNode lllllllllllllllIlllIIlIllIllllII, BasicValue lllllllllllllllIlllIIlIllIlllIll, BasicValue lllllllllllllllIlllIIlIllIlllIlI, BasicValue lllllllllllllllIlllIIlIllIlllIIl) throws AnalyzerException {
        return null;
    }

    @Override
    public BasicValue naryOperation(AbstractInsnNode lllllllllllllllIlllIIlIllIllIIII, List<? extends BasicValue> lllllllllllllllIlllIIlIllIllIIll) throws AnalyzerException {
        BasicInterpreter lllllllllllllllIlllIIlIllIllIlIl;
        int lllllllllllllllIlllIIlIllIllIIlI = lllllllllllllllIlllIIlIllIllIIII.getOpcode();
        if (lllllllllllllllIlllIIlIllIllIIlI == 197) {
            return lllllllllllllllIlllIIlIllIllIlIl.newValue(Type.getType(((MultiANewArrayInsnNode)lllllllllllllllIlllIIlIllIllIIII).desc));
        }
        if (lllllllllllllllIlllIIlIllIllIIlI == 186) {
            return lllllllllllllllIlllIIlIllIllIlIl.newValue(Type.getReturnType(((InvokeDynamicInsnNode)lllllllllllllllIlllIIlIllIllIIII).desc));
        }
        return lllllllllllllllIlllIIlIllIllIlIl.newValue(Type.getReturnType(((MethodInsnNode)lllllllllllllllIlllIIlIllIllIIII).desc));
    }

    public BasicInterpreter() {
        super(327680);
        BasicInterpreter lllllllllllllllIlllIIlIllllIlIll;
    }

    @Override
    public BasicValue copyOperation(AbstractInsnNode lllllllllllllllIlllIIlIlllIlIIIl, BasicValue lllllllllllllllIlllIIlIlllIIllll) throws AnalyzerException {
        return lllllllllllllllIlllIIlIlllIIllll;
    }
}

