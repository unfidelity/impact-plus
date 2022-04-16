/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.points.BeforeInvoke;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.util.Bytecode;

@InjectionPoint.AtCode(value="FIELD")
public class BeforeFieldAccess
extends BeforeInvoke {
    private final /* synthetic */ int arrOpcode;
    private final /* synthetic */ int fuzzFactor;
    public static final /* synthetic */ int ARRAY_SEARCH_FUZZ_DEFAULT;
    private static final /* synthetic */ String ARRAY_GET;
    private static final /* synthetic */ String ARRAY_LENGTH;
    private final /* synthetic */ int opcode;
    private static final /* synthetic */ String ARRAY_SET;

    public BeforeFieldAccess(InjectionPointData llllllllllllllllIllllllIlIllIIIl) {
        super(llllllllllllllllIllllllIlIllIIIl);
        BeforeFieldAccess llllllllllllllllIllllllIlIlllIII;
        llllllllllllllllIllllllIlIlllIII.opcode = llllllllllllllllIllllllIlIllIIIl.getOpcode(-1, 180, 181, 178, 179, -1);
        String llllllllllllllllIllllllIlIlllIll = llllllllllllllllIllllllIlIllIIIl.get("array", "");
        llllllllllllllllIllllllIlIlllIII.arrOpcode = "get".equalsIgnoreCase(llllllllllllllllIllllllIlIlllIll) ? 46 : ("set".equalsIgnoreCase(llllllllllllllllIllllllIlIlllIll) ? 79 : ("length".equalsIgnoreCase(llllllllllllllllIllllllIlIlllIll) ? 190 : 0));
        llllllllllllllllIllllllIlIlllIII.fuzzFactor = Math.min(Math.max(llllllllllllllllIllllllIlIllIIIl.get("fuzz", 8), 1), 32);
    }

    private int getArrayOpcode(String llllllllllllllllIllllllIIllIllII) {
        BeforeFieldAccess llllllllllllllllIllllllIIllIlllI;
        if (llllllllllllllllIllllllIIllIlllI.arrOpcode != 190) {
            return Type.getType(llllllllllllllllIllllllIIllIllII).getElementType().getOpcode(llllllllllllllllIllllllIIllIlllI.arrOpcode);
        }
        return llllllllllllllllIllllllIIllIlllI.arrOpcode;
    }

    public static AbstractInsnNode findArrayNode(InsnList llllllllllllllllIlllllIllIIIlllI, FieldInsnNode llllllllllllllllIlllllIlIlllllII, int llllllllllllllllIlllllIlIllllIlI, int llllllllllllllllIlllllIllIIIIIll) {
        int llllllllllllllllIlllllIllIIIIIlI = 0;
        ListIterator<AbstractInsnNode> llllllllllllllllIlllllIllIIlIIIl = llllllllllllllllIlllllIllIIIlllI.iterator(llllllllllllllllIlllllIllIIIlllI.indexOf(llllllllllllllllIlllllIlIlllllII) + 1);
        while (llllllllllllllllIlllllIllIIlIIIl.hasNext()) {
            AbstractInsnNode llllllllllllllllIlllllIllIIlIIlI = (AbstractInsnNode)llllllllllllllllIlllllIllIIlIIIl.next();
            if (llllllllllllllllIlllllIllIIlIIlI.getOpcode() == llllllllllllllllIlllllIlIllllIlI) {
                return llllllllllllllllIlllllIllIIlIIlI;
            }
            if (llllllllllllllllIlllllIllIIlIIlI.getOpcode() == 190 && llllllllllllllllIlllllIllIIIIIlI == 0) {
                return null;
            }
            if (llllllllllllllllIlllllIllIIlIIlI instanceof FieldInsnNode) {
                FieldInsnNode llllllllllllllllIlllllIllIIlIlII = (FieldInsnNode)llllllllllllllllIlllllIllIIlIIlI;
                if (llllllllllllllllIlllllIllIIlIlII.desc.equals(llllllllllllllllIlllllIlIlllllII.desc) && llllllllllllllllIlllllIllIIlIlII.name.equals(llllllllllllllllIlllllIlIlllllII.name) && llllllllllllllllIlllllIllIIlIlII.owner.equals(llllllllllllllllIlllllIlIlllllII.owner)) {
                    return null;
                }
            }
            if (llllllllllllllllIlllllIllIIIIIlI++ <= llllllllllllllllIlllllIllIIIIIll) continue;
            return null;
        }
        return null;
    }

    public int getArrayOpcode() {
        BeforeFieldAccess llllllllllllllllIllllllIlIIlIlIl;
        return llllllllllllllllIllllllIlIIlIlIl.arrOpcode;
    }

    public int getFuzzFactor() {
        BeforeFieldAccess llllllllllllllllIllllllIlIlIIIlI;
        return llllllllllllllllIllllllIlIlIIIlI.fuzzFactor;
    }

    @Override
    protected boolean matchesInsn(AbstractInsnNode llllllllllllllllIllllllIIIlllllI) {
        BeforeFieldAccess llllllllllllllllIllllllIIIlllIlI;
        if (llllllllllllllllIllllllIIIlllllI instanceof FieldInsnNode && (((FieldInsnNode)llllllllllllllllIllllllIIIlllllI).getOpcode() == llllllllllllllllIllllllIIIlllIlI.opcode || llllllllllllllllIllllllIIIlllIlI.opcode == -1)) {
            if (llllllllllllllllIllllllIIIlllIlI.arrOpcode == 0) {
                return true;
            }
            if (llllllllllllllllIllllllIIIlllllI.getOpcode() != 178 && llllllllllllllllIllllllIIIlllllI.getOpcode() != 180) {
                return false;
            }
            return Type.getType(((FieldInsnNode)llllllllllllllllIllllllIIIlllllI).desc).getSort() == 9;
        }
        return false;
    }

    @Override
    protected boolean addInsn(InsnList llllllllllllllllIlllllIllllIlIll, Collection<AbstractInsnNode> llllllllllllllllIlllllIllllIlIII, AbstractInsnNode llllllllllllllllIlllllIllllIIllI) {
        BeforeFieldAccess llllllllllllllllIlllllIllllIIlIl;
        if (llllllllllllllllIlllllIllllIIlIl.arrOpcode > 0) {
            FieldInsnNode llllllllllllllllIlllllIlllllIIlI = (FieldInsnNode)llllllllllllllllIlllllIllllIIllI;
            int llllllllllllllllIlllllIlllllIIII = llllllllllllllllIlllllIllllIIlIl.getArrayOpcode(llllllllllllllllIlllllIlllllIIlI.desc);
            llllllllllllllllIlllllIllllIIlIl.log("{} > > > > searching for array access opcode {} fuzz={}", llllllllllllllllIlllllIllllIIlIl.className, Bytecode.getOpcodeName(llllllllllllllllIlllllIlllllIIII), llllllllllllllllIlllllIllllIIlIl.fuzzFactor);
            if (BeforeFieldAccess.findArrayNode(llllllllllllllllIlllllIllllIlIll, llllllllllllllllIlllllIlllllIIlI, llllllllllllllllIlllllIlllllIIII, llllllllllllllllIlllllIllllIIlIl.fuzzFactor) == null) {
                llllllllllllllllIlllllIllllIIlIl.log("{} > > > > > failed to locate matching insn", llllllllllllllllIlllllIllllIIlIl.className);
                return false;
            }
        }
        llllllllllllllllIlllllIllllIIlIl.log("{} > > > > > adding matching insn", llllllllllllllllIlllllIllllIIlIl.className);
        return super.addInsn(llllllllllllllllIlllllIllllIlIll, llllllllllllllllIlllllIllllIlIII, llllllllllllllllIlllllIllllIIllI);
    }

    static {
        ARRAY_SET = "set";
        ARRAY_GET = "get";
        ARRAY_SEARCH_FUZZ_DEFAULT = 8;
        ARRAY_LENGTH = "length";
    }
}

