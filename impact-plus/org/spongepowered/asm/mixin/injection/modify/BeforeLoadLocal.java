/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collection;
import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.modify.LocalVariableDiscriminator;
import org.spongepowered.asm.mixin.injection.modify.ModifyVariableInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.Target;

@InjectionPoint.AtCode(value="LOAD")
public class BeforeLoadLocal
extends ModifyVariableInjector.ContextualInjectionPoint {
    private final /* synthetic */ int ordinal;
    private final /* synthetic */ int opcode;
    private /* synthetic */ boolean opcodeAfter;
    private final /* synthetic */ Type returnType;
    private final /* synthetic */ LocalVariableDiscriminator discriminator;

    protected BeforeLoadLocal(InjectionPointData llllIIlllllIllI) {
        llllIIlllllIlll(llllIIlllllIllI, 21, false);
        BeforeLoadLocal llllIIlllllIlll;
    }

    @Override
    boolean find(Target llllIIlllIlllII, Collection<AbstractInsnNode> llllIIlllIlIllI) {
        BeforeLoadLocal llllIIlllIllIII;
        SearchState llllIIlllIllIlI = new SearchState(llllIIlllIllIII.ordinal, llllIIlllIllIII.discriminator.printLVT());
        ListIterator<AbstractInsnNode> llllIIlllIllIIl = llllIIlllIlllII.method.instructions.iterator();
        while (llllIIlllIllIIl.hasNext()) {
            AbstractInsnNode llllIIlllIllllI = llllIIlllIllIIl.next();
            if (llllIIlllIllIlI.isPendingCheck()) {
                int llllIIllllIIIII = llllIIlllIllIII.discriminator.findLocal(llllIIlllIllIII.returnType, llllIIlllIllIII.discriminator.isArgsOnly(), llllIIlllIlllII, llllIIlllIllllI);
                llllIIlllIllIlI.check(llllIIlllIlIllI, llllIIlllIllllI, llllIIllllIIIII);
                continue;
            }
            if (!(llllIIlllIllllI instanceof VarInsnNode) || llllIIlllIllllI.getOpcode() != llllIIlllIllIII.opcode || llllIIlllIllIII.ordinal != -1 && llllIIlllIllIlI.success()) continue;
            llllIIlllIllIlI.register((VarInsnNode)llllIIlllIllllI);
            if (llllIIlllIllIII.opcodeAfter) {
                llllIIlllIllIlI.setPendingCheck();
                continue;
            }
            int llllIIlllIlllll = llllIIlllIllIII.discriminator.findLocal(llllIIlllIllIII.returnType, llllIIlllIllIII.discriminator.isArgsOnly(), llllIIlllIlllII, llllIIlllIllllI);
            llllIIlllIllIlI.check(llllIIlllIlIllI, llllIIlllIllllI, llllIIlllIlllll);
        }
        return llllIIlllIllIlI.success();
    }

    protected BeforeLoadLocal(InjectionPointData llllIIllllIlllI, int llllIIllllIllIl, boolean llllIIllllIlIII) {
        super(llllIIllllIlllI.getContext());
        BeforeLoadLocal llllIIllllIlIll;
        llllIIllllIlIll.returnType = llllIIllllIlllI.getMethodReturnType();
        llllIIllllIlIll.discriminator = llllIIllllIlllI.getLocalVariableDiscriminator();
        llllIIllllIlIll.opcode = llllIIllllIlllI.getOpcode(llllIIllllIlIll.returnType.getOpcode(llllIIllllIllIl));
        llllIIllllIlIll.ordinal = llllIIllllIlllI.getOrdinal();
        llllIIllllIlIll.opcodeAfter = llllIIllllIlIII;
    }

    static class SearchState {
        private /* synthetic */ VarInsnNode varNode;
        private /* synthetic */ boolean found;
        private final /* synthetic */ int targetOrdinal;
        private final /* synthetic */ boolean print;
        private /* synthetic */ int ordinal;
        private /* synthetic */ boolean pendingCheck;

        boolean success() {
            SearchState lllllllllllllllIlllllIlIlIIIlIIl;
            return lllllllllllllllIlllllIlIlIIIlIIl.found;
        }

        void check(Collection<AbstractInsnNode> lllllllllllllllIlllllIlIIIllIIIl, AbstractInsnNode lllllllllllllllIlllllIlIIIlIlllI, int lllllllllllllllIlllllIlIIIllIlll) {
            SearchState lllllllllllllllIlllllIlIIlIIlIII;
            lllllllllllllllIlllllIlIIlIIlIII.pendingCheck = false;
            if (!(lllllllllllllllIlllllIlIIIllIlll == lllllllllllllllIlllllIlIIlIIlIII.varNode.var || lllllllllllllllIlllllIlIIIllIlll <= -2 && lllllllllllllllIlllllIlIIlIIlIII.print)) {
                return;
            }
            if (lllllllllllllllIlllllIlIIlIIlIII.targetOrdinal == -1 || lllllllllllllllIlllllIlIIlIIlIII.targetOrdinal == lllllllllllllllIlllllIlIIlIIlIII.ordinal) {
                lllllllllllllllIlllllIlIIIllIIIl.add(lllllllllllllllIlllllIlIIIlIlllI);
                lllllllllllllllIlllllIlIIlIIlIII.found = true;
            }
            ++lllllllllllllllIlllllIlIIlIIlIII.ordinal;
            lllllllllllllllIlllllIlIIlIIlIII.varNode = null;
        }

        boolean isPendingCheck() {
            SearchState lllllllllllllllIlllllIlIIlllllll;
            return lllllllllllllllIlllllIlIIlllllll.pendingCheck;
        }

        SearchState(int lllllllllllllllIlllllIlIlIIIllll, boolean lllllllllllllllIlllllIlIlIIIllIl) {
            SearchState lllllllllllllllIlllllIlIlIIlIlIl;
            lllllllllllllllIlllllIlIlIIlIlIl.ordinal = 0;
            lllllllllllllllIlllllIlIlIIlIlIl.pendingCheck = false;
            lllllllllllllllIlllllIlIlIIlIlIl.found = false;
            lllllllllllllllIlllllIlIlIIlIlIl.targetOrdinal = lllllllllllllllIlllllIlIlIIIllll;
            lllllllllllllllIlllllIlIlIIlIlIl.print = lllllllllllllllIlllllIlIlIIIllIl;
        }

        void register(VarInsnNode lllllllllllllllIlllllIlIIlIllIll) {
            lllllllllllllllIlllllIlIIlIlllIl.varNode = lllllllllllllllIlllllIlIIlIllIll;
        }

        void setPendingCheck() {
            lllllllllllllllIlllllIlIIlllIIII.pendingCheck = true;
        }
    }
}

