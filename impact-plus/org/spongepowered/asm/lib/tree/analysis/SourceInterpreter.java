/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.analysis.Interpreter;
import org.spongepowered.asm.lib.tree.analysis.SmallSet;
import org.spongepowered.asm.lib.tree.analysis.SourceValue;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SourceInterpreter
extends Interpreter<SourceValue>
implements Opcodes {
    @Override
    public SourceValue newValue(Type lllllllllllllllIllllIIIlllllIIIl) {
        if (lllllllllllllllIllllIIIlllllIIIl == Type.VOID_TYPE) {
            return null;
        }
        return new SourceValue(lllllllllllllllIllllIIIlllllIIIl == null ? 1 : lllllllllllllllIllllIIIlllllIIIl.getSize());
    }

    protected SourceInterpreter(int lllllllllllllllIllllIIlIIIIlIIIl) {
        super(lllllllllllllllIllllIIlIIIIlIIIl);
        SourceInterpreter lllllllllllllllIllllIIlIIIIlIIlI;
    }

    @Override
    public SourceValue ternaryOperation(AbstractInsnNode lllllllllllllllIllllIIIlIIlIlllI, SourceValue lllllllllllllllIllllIIIlIIllIIIl, SourceValue lllllllllllllllIllllIIIlIIllIIII, SourceValue lllllllllllllllIllllIIIlIIlIllll) {
        return new SourceValue(1, lllllllllllllllIllllIIIlIIlIlllI);
    }

    @Override
    public SourceValue naryOperation(AbstractInsnNode lllllllllllllllIllllIIIlIIIIllll, List<? extends SourceValue> lllllllllllllllIllllIIIlIIIlIlIl) {
        int lllllllllllllllIllllIIIlIIIlIlII;
        int lllllllllllllllIllllIIIlIIIlIIlI = lllllllllllllllIllllIIIlIIIIllll.getOpcode();
        if (lllllllllllllllIllllIIIlIIIlIIlI == 197) {
            boolean lllllllllllllllIllllIIIlIIIllIlI = true;
        } else {
            String lllllllllllllllIllllIIIlIIIllIIl = lllllllllllllllIllllIIIlIIIlIIlI == 186 ? ((InvokeDynamicInsnNode)lllllllllllllllIllllIIIlIIIIllll).desc : ((MethodInsnNode)lllllllllllllllIllllIIIlIIIIllll).desc;
            lllllllllllllllIllllIIIlIIIlIlII = Type.getReturnType(lllllllllllllllIllllIIIlIIIllIIl).getSize();
        }
        return new SourceValue(lllllllllllllllIllllIIIlIIIlIlII, lllllllllllllllIllllIIIlIIIIllll);
    }

    @Override
    public void returnOperation(AbstractInsnNode lllllllllllllllIllllIIIlIIIIIlIl, SourceValue lllllllllllllllIllllIIIlIIIIIIIl, SourceValue lllllllllllllllIllllIIIlIIIIIIII) {
    }

    @Override
    public SourceValue copyOperation(AbstractInsnNode lllllllllllllllIllllIIIllIlIIlIl, SourceValue lllllllllllllllIllllIIIllIlIIIll) {
        return new SourceValue(lllllllllllllllIllllIIIllIlIIIll.getSize(), lllllllllllllllIllllIIIllIlIIlIl);
    }

    @Override
    public SourceValue unaryOperation(AbstractInsnNode lllllllllllllllIllllIIIlIlIlIlll, SourceValue lllllllllllllllIllllIIIlIlIllIll) {
        int lllllllllllllllIllllIIIlIlIllIIl;
        switch (lllllllllllllllIllllIIIlIlIlIlll.getOpcode()) {
            case 117: 
            case 119: 
            case 133: 
            case 135: 
            case 138: 
            case 140: 
            case 141: 
            case 143: {
                int lllllllllllllllIllllIIIlIllIIIll = 2;
                break;
            }
            case 180: {
                int lllllllllllllllIllllIIIlIllIIIIl = Type.getType(((FieldInsnNode)lllllllllllllllIllllIIIlIlIlIlll).desc).getSize();
                break;
            }
            default: {
                lllllllllllllllIllllIIIlIlIllIIl = 1;
            }
        }
        return new SourceValue(lllllllllllllllIllllIIIlIlIllIIl, lllllllllllllllIllllIIIlIlIlIlll);
    }

    @Override
    public SourceValue merge(SourceValue lllllllllllllllIllllIIIIlllIIlIl, SourceValue lllllllllllllllIllllIIIIlllIIlII) {
        if (lllllllllllllllIllllIIIIlllIIlIl.insns instanceof SmallSet && lllllllllllllllIllllIIIIlllIIlII.insns instanceof SmallSet) {
            Set<AbstractInsnNode> lllllllllllllllIllllIIIIlllIlllI = ((SmallSet)lllllllllllllllIllllIIIIlllIIlIl.insns).union((SmallSet)lllllllllllllllIllllIIIIlllIIlII.insns);
            if (lllllllllllllllIllllIIIIlllIlllI == lllllllllllllllIllllIIIIlllIIlIl.insns && lllllllllllllllIllllIIIIlllIIlIl.size == lllllllllllllllIllllIIIIlllIIlII.size) {
                return lllllllllllllllIllllIIIIlllIIlIl;
            }
            return new SourceValue(Math.min(lllllllllllllllIllllIIIIlllIIlIl.size, lllllllllllllllIllllIIIIlllIIlII.size), lllllllllllllllIllllIIIIlllIlllI);
        }
        if (lllllllllllllllIllllIIIIlllIIlIl.size != lllllllllllllllIllllIIIIlllIIlII.size || !lllllllllllllllIllllIIIIlllIIlIl.insns.containsAll(lllllllllllllllIllllIIIIlllIIlII.insns)) {
            HashSet<AbstractInsnNode> lllllllllllllllIllllIIIIlllIllII = new HashSet<AbstractInsnNode>();
            lllllllllllllllIllllIIIIlllIllII.addAll(lllllllllllllllIllllIIIIlllIIlIl.insns);
            lllllllllllllllIllllIIIIlllIllII.addAll(lllllllllllllllIllllIIIIlllIIlII.insns);
            return new SourceValue(Math.min(lllllllllllllllIllllIIIIlllIIlIl.size, lllllllllllllllIllllIIIIlllIIlII.size), lllllllllllllllIllllIIIIlllIllII);
        }
        return lllllllllllllllIllllIIIIlllIIlIl;
    }

    @Override
    public SourceValue newOperation(AbstractInsnNode lllllllllllllllIllllIIIlllIllllI) {
        int lllllllllllllllIllllIIIlllIlllII;
        switch (lllllllllllllllIllllIIIlllIllllI.getOpcode()) {
            case 9: 
            case 10: 
            case 14: 
            case 15: {
                int lllllllllllllllIllllIIIllllIIIll = 2;
                break;
            }
            case 18: {
                Object lllllllllllllllIllllIIIllllIIIIl = ((LdcInsnNode)lllllllllllllllIllllIIIlllIllllI).cst;
                int lllllllllllllllIllllIIIllllIIIlI = lllllllllllllllIllllIIIllllIIIIl instanceof Long || lllllllllllllllIllllIIIllllIIIIl instanceof Double ? 2 : 1;
                break;
            }
            case 178: {
                int lllllllllllllllIllllIIIllllIIIII = Type.getType(((FieldInsnNode)lllllllllllllllIllllIIIlllIllllI).desc).getSize();
                break;
            }
            default: {
                lllllllllllllllIllllIIIlllIlllII = 1;
            }
        }
        return new SourceValue(lllllllllllllllIllllIIIlllIlllII, lllllllllllllllIllllIIIlllIllllI);
    }

    public SourceInterpreter() {
        super(327680);
        SourceInterpreter lllllllllllllllIllllIIlIIIIlIlIl;
    }

    @Override
    public SourceValue binaryOperation(AbstractInsnNode lllllllllllllllIllllIIIlIIllllll, SourceValue lllllllllllllllIllllIIIlIlIIIllI, SourceValue lllllllllllllllIllllIIIlIlIIIlII) {
        int lllllllllllllllIllllIIIlIlIIIIlI;
        switch (lllllllllllllllIllllIIIlIIllllll.getOpcode()) {
            case 47: 
            case 49: 
            case 97: 
            case 99: 
            case 101: 
            case 103: 
            case 105: 
            case 107: 
            case 109: 
            case 111: 
            case 113: 
            case 115: 
            case 121: 
            case 123: 
            case 125: 
            case 127: 
            case 129: 
            case 131: {
                int lllllllllllllllIllllIIIlIlIIlIll = 2;
                break;
            }
            default: {
                lllllllllllllllIllllIIIlIlIIIIlI = 1;
            }
        }
        return new SourceValue(lllllllllllllllIllllIIIlIlIIIIlI, lllllllllllllllIllllIIIlIIllllll);
    }
}

