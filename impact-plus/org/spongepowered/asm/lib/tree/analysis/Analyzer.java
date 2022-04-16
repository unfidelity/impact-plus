/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.IincInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LookupSwitchInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TableSwitchInsnNode;
import org.spongepowered.asm.lib.tree.TryCatchBlockNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.Frame;
import org.spongepowered.asm.lib.tree.analysis.Interpreter;
import org.spongepowered.asm.lib.tree.analysis.Subroutine;
import org.spongepowered.asm.lib.tree.analysis.Value;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Analyzer<V extends Value>
implements Opcodes {
    private /* synthetic */ boolean[] queued;
    private /* synthetic */ Frame<V>[] frames;
    private /* synthetic */ List<TryCatchBlockNode>[] handlers;
    private /* synthetic */ InsnList insns;
    private /* synthetic */ int[] queue;
    private final /* synthetic */ Interpreter<V> interpreter;
    private /* synthetic */ Subroutine[] subroutines;
    private /* synthetic */ int top;
    private /* synthetic */ int n;

    protected Frame<V> newFrame(Frame<? extends V> lllllllllllllllIlllIllIIIIlIIlll) {
        return new Frame<V>(lllllllllllllllIlllIllIIIIlIIlll);
    }

    protected boolean newControlFlowExceptionEdge(int lllllllllllllllIlllIllIIIIIllIll, TryCatchBlockNode lllllllllllllllIlllIllIIIIIllIlI) {
        Analyzer lllllllllllllllIlllIllIIIIIllIIl;
        return lllllllllllllllIlllIllIIIIIllIIl.newControlFlowExceptionEdge(lllllllllllllllIlllIllIIIIIllIll, lllllllllllllllIlllIllIIIIIllIIl.insns.indexOf(lllllllllllllllIlllIllIIIIIllIlI.handler));
    }

    public Frame<V>[] analyze(String lllllllllllllllIlllIllIIIllIllll, MethodNode lllllllllllllllIlllIllIIIllllIII) throws AnalyzerException {
        Analyzer lllllllllllllllIlllIllIIIllllIlI;
        if ((lllllllllllllllIlllIllIIIllllIII.access & 0x500) != 0) {
            lllllllllllllllIlllIllIIIllllIlI.frames = new Frame[0];
            return lllllllllllllllIlllIllIIIllllIlI.frames;
        }
        lllllllllllllllIlllIllIIIllllIlI.n = lllllllllllllllIlllIllIIIllllIII.instructions.size();
        lllllllllllllllIlllIllIIIllllIlI.insns = lllllllllllllllIlllIllIIIllllIII.instructions;
        lllllllllllllllIlllIllIIIllllIlI.handlers = new List[lllllllllllllllIlllIllIIIllllIlI.n];
        lllllllllllllllIlllIllIIIllllIlI.frames = new Frame[lllllllllllllllIlllIllIIIllllIlI.n];
        lllllllllllllllIlllIllIIIllllIlI.subroutines = new Subroutine[lllllllllllllllIlllIllIIIllllIlI.n];
        lllllllllllllllIlllIllIIIllllIlI.queued = new boolean[lllllllllllllllIlllIllIIIllllIlI.n];
        lllllllllllllllIlllIllIIIllllIlI.queue = new int[lllllllllllllllIlllIllIIIllllIlI.n];
        lllllllllllllllIlllIllIIIllllIlI.top = 0;
        for (int lllllllllllllllIlllIllIIlIIlllIl = 0; lllllllllllllllIlllIllIIlIIlllIl < lllllllllllllllIlllIllIIIllllIII.tryCatchBlocks.size(); ++lllllllllllllllIlllIllIIlIIlllIl) {
            TryCatchBlockNode lllllllllllllllIlllIllIIlIlIIIII = lllllllllllllllIlllIllIIIllllIII.tryCatchBlocks.get(lllllllllllllllIlllIllIIlIIlllIl);
            int lllllllllllllllIlllIllIIlIIlllll = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIlIIIII.start);
            int lllllllllllllllIlllIllIIlIIllllI = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIlIIIII.end);
            for (int lllllllllllllllIlllIllIIlIlIIIIl = lllllllllllllllIlllIllIIlIIlllll; lllllllllllllllIlllIllIIlIlIIIIl < lllllllllllllllIlllIllIIlIIllllI; ++lllllllllllllllIlllIllIIlIlIIIIl) {
                List<TryCatchBlockNode> lllllllllllllllIlllIllIIlIlIIIlI = lllllllllllllllIlllIllIIIllllIlI.handlers[lllllllllllllllIlllIllIIlIlIIIIl];
                if (lllllllllllllllIlllIllIIlIlIIIlI == null) {
                    lllllllllllllllIlllIllIIIllllIlI.handlers[lllllllllllllllIlllIllIIlIlIIIIl] = lllllllllllllllIlllIllIIlIlIIIlI = new ArrayList<TryCatchBlockNode>();
                }
                lllllllllllllllIlllIllIIlIlIIIlI.add(lllllllllllllllIlllIllIIlIlIIIII);
            }
        }
        Subroutine lllllllllllllllIlllIllIIIlllIlll = new Subroutine(null, lllllllllllllllIlllIllIIIllllIII.maxLocals, null);
        ArrayList<AbstractInsnNode> lllllllllllllllIlllIllIIIlllIllI = new ArrayList<AbstractInsnNode>();
        HashMap<LabelNode, Subroutine> lllllllllllllllIlllIllIIIlllIlIl = new HashMap<LabelNode, Subroutine>();
        lllllllllllllllIlllIllIIIllllIlI.findSubroutine(0, lllllllllllllllIlllIllIIIlllIlll, lllllllllllllllIlllIllIIIlllIllI);
        while (!lllllllllllllllIlllIllIIIlllIllI.isEmpty()) {
            JumpInsnNode lllllllllllllllIlllIllIIlIIlllII = (JumpInsnNode)lllllllllllllllIlllIllIIIlllIllI.remove(0);
            Subroutine lllllllllllllllIlllIllIIlIIllIll = (Subroutine)lllllllllllllllIlllIllIIIlllIlIl.get(lllllllllllllllIlllIllIIlIIlllII.label);
            if (lllllllllllllllIlllIllIIlIIllIll == null) {
                lllllllllllllllIlllIllIIlIIllIll = new Subroutine(lllllllllllllllIlllIllIIlIIlllII.label, lllllllllllllllIlllIllIIIllllIII.maxLocals, lllllllllllllllIlllIllIIlIIlllII);
                lllllllllllllllIlllIllIIIlllIlIl.put(lllllllllllllllIlllIllIIlIIlllII.label, lllllllllllllllIlllIllIIlIIllIll);
                lllllllllllllllIlllIllIIIllllIlI.findSubroutine(lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIlllII.label), lllllllllllllllIlllIllIIlIIllIll, lllllllllllllllIlllIllIIIlllIllI);
                continue;
            }
            lllllllllllllllIlllIllIIlIIllIll.callers.add(lllllllllllllllIlllIllIIlIIlllII);
        }
        for (int lllllllllllllllIlllIllIIlIIllIlI = 0; lllllllllllllllIlllIllIIlIIllIlI < lllllllllllllllIlllIllIIIllllIlI.n; ++lllllllllllllllIlllIllIIlIIllIlI) {
            if (lllllllllllllllIlllIllIIIllllIlI.subroutines[lllllllllllllllIlllIllIIlIIllIlI] == null || lllllllllllllllIlllIllIIIllllIlI.subroutines[lllllllllllllllIlllIllIIlIIllIlI].start != null) continue;
            lllllllllllllllIlllIllIIIllllIlI.subroutines[lllllllllllllllIlllIllIIlIIllIlI] = null;
        }
        Frame<V> lllllllllllllllIlllIllIIIlllIlII = lllllllllllllllIlllIllIIIllllIlI.newFrame(lllllllllllllllIlllIllIIIllllIII.maxLocals, lllllllllllllllIlllIllIIIllllIII.maxStack);
        Frame<V> lllllllllllllllIlllIllIIIlllIIll = lllllllllllllllIlllIllIIIllllIlI.newFrame(lllllllllllllllIlllIllIIIllllIII.maxLocals, lllllllllllllllIlllIllIIIllllIII.maxStack);
        lllllllllllllllIlllIllIIIlllIlII.setReturn(lllllllllllllllIlllIllIIIllllIlI.interpreter.newValue(Type.getReturnType(lllllllllllllllIlllIllIIIllllIII.desc)));
        Type[] lllllllllllllllIlllIllIIIlllIIlI = Type.getArgumentTypes(lllllllllllllllIlllIllIIIllllIII.desc);
        int lllllllllllllllIlllIllIIIlllIIIl = 0;
        if ((lllllllllllllllIlllIllIIIllllIII.access & 8) == 0) {
            Type lllllllllllllllIlllIllIIlIIllIIl = Type.getObjectType(lllllllllllllllIlllIllIIIllIllll);
            lllllllllllllllIlllIllIIIlllIlII.setLocal(lllllllllllllllIlllIllIIIlllIIIl++, lllllllllllllllIlllIllIIIllllIlI.interpreter.newValue(lllllllllllllllIlllIllIIlIIllIIl));
        }
        for (int lllllllllllllllIlllIllIIlIIllIII = 0; lllllllllllllllIlllIllIIlIIllIII < lllllllllllllllIlllIllIIIlllIIlI.length; ++lllllllllllllllIlllIllIIlIIllIII) {
            lllllllllllllllIlllIllIIIlllIlII.setLocal(lllllllllllllllIlllIllIIIlllIIIl++, lllllllllllllllIlllIllIIIllllIlI.interpreter.newValue(lllllllllllllllIlllIllIIIlllIIlI[lllllllllllllllIlllIllIIlIIllIII]));
            if (lllllllllllllllIlllIllIIIlllIIlI[lllllllllllllllIlllIllIIlIIllIII].getSize() != 2) continue;
            lllllllllllllllIlllIllIIIlllIlII.setLocal(lllllllllllllllIlllIllIIIlllIIIl++, lllllllllllllllIlllIllIIIllllIlI.interpreter.newValue(null));
        }
        while (lllllllllllllllIlllIllIIIlllIIIl < lllllllllllllllIlllIllIIIllllIII.maxLocals) {
            lllllllllllllllIlllIllIIIlllIlII.setLocal(lllllllllllllllIlllIllIIIlllIIIl++, lllllllllllllllIlllIllIIIllllIlI.interpreter.newValue(null));
        }
        lllllllllllllllIlllIllIIIllllIlI.merge(0, lllllllllllllllIlllIllIIIlllIlII, null);
        lllllllllllllllIlllIllIIIllllIlI.init(lllllllllllllllIlllIllIIIllIllll, lllllllllllllllIlllIllIIIllllIII);
        while (lllllllllllllllIlllIllIIIllllIlI.top > 0) {
            int lllllllllllllllIlllIllIIIllllllI = lllllllllllllllIlllIllIIIllllIlI.queue[--lllllllllllllllIlllIllIIIllllIlI.top];
            Frame<V> lllllllllllllllIlllIllIIIlllllIl = lllllllllllllllIlllIllIIIllllIlI.frames[lllllllllllllllIlllIllIIIllllllI];
            Subroutine lllllllllllllllIlllIllIIIlllllII = lllllllllllllllIlllIllIIIllllIlI.subroutines[lllllllllllllllIlllIllIIIllllllI];
            lllllllllllllllIlllIllIIIllllIlI.queued[lllllllllllllllIlllIllIIIllllllI] = false;
            AbstractInsnNode lllllllllllllllIlllIllIIIllllIll = null;
            try {
                List<TryCatchBlockNode> lllllllllllllllIlllIllIIlIIIIIIl;
                lllllllllllllllIlllIllIIIllllIll = lllllllllllllllIlllIllIIIllllIII.instructions.get(lllllllllllllllIlllIllIIIllllllI);
                int lllllllllllllllIlllIllIIlIIIIIll = lllllllllllllllIlllIllIIIllllIll.getOpcode();
                int lllllllllllllllIlllIllIIlIIIIIlI = lllllllllllllllIlllIllIIIllllIll.getType();
                if (lllllllllllllllIlllIllIIlIIIIIlI == 8 || lllllllllllllllIlllIllIIlIIIIIlI == 15 || lllllllllllllllIlllIllIIlIIIIIlI == 14) {
                    lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIIllllllI + 1, lllllllllllllllIlllIllIIIlllllIl, lllllllllllllllIlllIllIIIlllllII);
                    lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIIllllllI + 1);
                } else {
                    lllllllllllllllIlllIllIIIlllIlII.init(lllllllllllllllIlllIllIIIlllllIl).execute(lllllllllllllllIlllIllIIIllllIll, lllllllllllllllIlllIllIIIllllIlI.interpreter);
                    Subroutine subroutine = lllllllllllllllIlllIllIIIlllllII = lllllllllllllllIlllIllIIIlllllII == null ? null : lllllllllllllllIlllIllIIIlllllII.copy();
                    if (lllllllllllllllIlllIllIIIllllIll instanceof JumpInsnNode) {
                        JumpInsnNode lllllllllllllllIlllIllIIlIIlIlll = (JumpInsnNode)lllllllllllllllIlllIllIIIllllIll;
                        if (lllllllllllllllIlllIllIIlIIIIIll != 167 && lllllllllllllllIlllIllIIlIIIIIll != 168) {
                            lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIIllllllI + 1, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                            lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIIllllllI + 1);
                        }
                        int lllllllllllllllIlllIllIIlIIlIllI = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIlIlll.label);
                        if (lllllllllllllllIlllIllIIlIIIIIll == 168) {
                            lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIlIllI, lllllllllllllllIlllIllIIIlllIlII, new Subroutine(lllllllllllllllIlllIllIIlIIlIlll.label, lllllllllllllllIlllIllIIIllllIII.maxLocals, lllllllllllllllIlllIllIIlIIlIlll));
                        } else {
                            lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIlIllI, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                        }
                        lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIlIllI);
                    } else if (lllllllllllllllIlllIllIIIllllIll instanceof LookupSwitchInsnNode) {
                        LookupSwitchInsnNode lllllllllllllllIlllIllIIlIIlIIll = (LookupSwitchInsnNode)lllllllllllllllIlllIllIIIllllIll;
                        int lllllllllllllllIlllIllIIlIIlIIlI = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIlIIll.dflt);
                        lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIlIIlI, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                        lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIlIIlI);
                        for (int lllllllllllllllIlllIllIIlIIlIlII = 0; lllllllllllllllIlllIllIIlIIlIlII < lllllllllllllllIlllIllIIlIIlIIll.labels.size(); ++lllllllllllllllIlllIllIIlIIlIlII) {
                            LabelNode lllllllllllllllIlllIllIIlIIlIlIl = lllllllllllllllIlllIllIIlIIlIIll.labels.get(lllllllllllllllIlllIllIIlIIlIlII);
                            lllllllllllllllIlllIllIIlIIlIIlI = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIlIlIl);
                            lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIlIIlI, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                            lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIlIIlI);
                        }
                    } else if (lllllllllllllllIlllIllIIIllllIll instanceof TableSwitchInsnNode) {
                        TableSwitchInsnNode lllllllllllllllIlllIllIIlIIIllll = (TableSwitchInsnNode)lllllllllllllllIlllIllIIIllllIll;
                        int lllllllllllllllIlllIllIIlIIIlllI = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIIllll.dflt);
                        lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIIlllI, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                        lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIIlllI);
                        for (int lllllllllllllllIlllIllIIlIIlIIII = 0; lllllllllllllllIlllIllIIlIIlIIII < lllllllllllllllIlllIllIIlIIIllll.labels.size(); ++lllllllllllllllIlllIllIIlIIlIIII) {
                            LabelNode lllllllllllllllIlllIllIIlIIlIIIl = lllllllllllllllIlllIllIIlIIIllll.labels.get(lllllllllllllllIlllIllIIlIIlIIII);
                            lllllllllllllllIlllIllIIlIIIlllI = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIlIIIl);
                            lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIIlllI, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                            lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIIlllI);
                        }
                    } else if (lllllllllllllllIlllIllIIlIIIIIll == 169) {
                        if (lllllllllllllllIlllIllIIIlllllII == null) {
                            throw new AnalyzerException(lllllllllllllllIlllIllIIIllllIll, "RET instruction outside of a sub routine");
                        }
                        for (int lllllllllllllllIlllIllIIlIIIlIll = 0; lllllllllllllllIlllIllIIlIIIlIll < lllllllllllllllIlllIllIIIlllllII.callers.size(); ++lllllllllllllllIlllIllIIlIIIlIll) {
                            JumpInsnNode lllllllllllllllIlllIllIIlIIIllIl = lllllllllllllllIlllIllIIIlllllII.callers.get(lllllllllllllllIlllIllIIlIIIlIll);
                            int lllllllllllllllIlllIllIIlIIIllII = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIIllIl);
                            if (lllllllllllllllIlllIllIIIllllIlI.frames[lllllllllllllllIlllIllIIlIIIllII] == null) continue;
                            lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIIllII + 1, lllllllllllllllIlllIllIIIllllIlI.frames[lllllllllllllllIlllIllIIlIIIllII], lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIllllIlI.subroutines[lllllllllllllllIlllIllIIlIIIllII], lllllllllllllllIlllIllIIIlllllII.access);
                            lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIIllII + 1);
                        }
                    } else if (lllllllllllllllIlllIllIIlIIIIIll != 191 && (lllllllllllllllIlllIllIIlIIIIIll < 172 || lllllllllllllllIlllIllIIlIIIIIll > 177)) {
                        if (lllllllllllllllIlllIllIIIlllllII != null) {
                            if (lllllllllllllllIlllIllIIIllllIll instanceof VarInsnNode) {
                                int lllllllllllllllIlllIllIIlIIIlIlI = ((VarInsnNode)lllllllllllllllIlllIllIIIllllIll).var;
                                lllllllllllllllIlllIllIIIlllllII.access[lllllllllllllllIlllIllIIlIIIlIlI] = true;
                                if (lllllllllllllllIlllIllIIlIIIIIll == 22 || lllllllllllllllIlllIllIIlIIIIIll == 24 || lllllllllllllllIlllIllIIlIIIIIll == 55 || lllllllllllllllIlllIllIIlIIIIIll == 57) {
                                    lllllllllllllllIlllIllIIIlllllII.access[lllllllllllllllIlllIllIIlIIIlIlI + 1] = true;
                                }
                            } else if (lllllllllllllllIlllIllIIIllllIll instanceof IincInsnNode) {
                                int lllllllllllllllIlllIllIIlIIIlIIl = ((IincInsnNode)lllllllllllllllIlllIllIIIllllIll).var;
                                lllllllllllllllIlllIllIIIlllllII.access[lllllllllllllllIlllIllIIlIIIlIIl] = true;
                            }
                        }
                        lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIIllllllI + 1, lllllllllllllllIlllIllIIIlllIlII, lllllllllllllllIlllIllIIIlllllII);
                        lllllllllllllllIlllIllIIIllllIlI.newControlFlowEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIIllllllI + 1);
                    }
                }
                if ((lllllllllllllllIlllIllIIlIIIIIIl = lllllllllllllllIlllIllIIIllllIlI.handlers[lllllllllllllllIlllIllIIIllllllI]) == null) continue;
                for (int lllllllllllllllIlllIllIIlIIIIlII = 0; lllllllllllllllIlllIllIIlIIIIlII < lllllllllllllllIlllIllIIlIIIIIIl.size(); ++lllllllllllllllIlllIllIIlIIIIlII) {
                    Type lllllllllllllllIlllIllIIlIIIIllI;
                    TryCatchBlockNode lllllllllllllllIlllIllIIlIIIIlll = lllllllllllllllIlllIllIIlIIIIIIl.get(lllllllllllllllIlllIllIIlIIIIlII);
                    if (lllllllllllllllIlllIllIIlIIIIlll.type == null) {
                        Type lllllllllllllllIlllIllIIlIIIlIII = Type.getObjectType("java/lang/Throwable");
                    } else {
                        lllllllllllllllIlllIllIIlIIIIllI = Type.getObjectType(lllllllllllllllIlllIllIIlIIIIlll.type);
                    }
                    int lllllllllllllllIlllIllIIlIIIIlIl = lllllllllllllllIlllIllIIIllllIlI.insns.indexOf(lllllllllllllllIlllIllIIlIIIIlll.handler);
                    if (!lllllllllllllllIlllIllIIIllllIlI.newControlFlowExceptionEdge(lllllllllllllllIlllIllIIIllllllI, lllllllllllllllIlllIllIIlIIIIlll)) continue;
                    lllllllllllllllIlllIllIIIlllIIll.init(lllllllllllllllIlllIllIIIlllllIl);
                    lllllllllllllllIlllIllIIIlllIIll.clearStack();
                    lllllllllllllllIlllIllIIIlllIIll.push(lllllllllllllllIlllIllIIIllllIlI.interpreter.newValue(lllllllllllllllIlllIllIIlIIIIllI));
                    lllllllllllllllIlllIllIIIllllIlI.merge(lllllllllllllllIlllIllIIlIIIIlIl, lllllllllllllllIlllIllIIIlllIIll, lllllllllllllllIlllIllIIIlllllII);
                }
            }
            catch (AnalyzerException lllllllllllllllIlllIllIIlIIIIIII) {
                throw new AnalyzerException(lllllllllllllllIlllIllIIlIIIIIII.node, String.valueOf(new StringBuilder().append("Error at instruction ").append(lllllllllllllllIlllIllIIIllllllI).append(": ").append(lllllllllllllllIlllIllIIlIIIIIII.getMessage())), lllllllllllllllIlllIllIIlIIIIIII);
            }
            catch (Exception lllllllllllllllIlllIllIIIlllllll) {
                throw new AnalyzerException(lllllllllllllllIlllIllIIIllllIll, String.valueOf(new StringBuilder().append("Error at instruction ").append(lllllllllllllllIlllIllIIIllllllI).append(": ").append(lllllllllllllllIlllIllIIIlllllll.getMessage())), lllllllllllllllIlllIllIIIlllllll);
            }
        }
        return lllllllllllllllIlllIllIIIllllIlI.frames;
    }

    private void findSubroutine(int lllllllllllllllIlllIllIIIlIIIlll, Subroutine lllllllllllllllIlllIllIIIlIIIIlI, List<AbstractInsnNode> lllllllllllllllIlllIllIIIlIIIIIl) throws AnalyzerException {
        while (true) {
            Analyzer lllllllllllllllIlllIllIIIlIIlIII;
            if (lllllllllllllllIlllIllIIIlIIIlll < 0 || lllllllllllllllIlllIllIIIlIIIlll >= lllllllllllllllIlllIllIIIlIIlIII.n) {
                throw new AnalyzerException(null, "Execution can fall off end of the code");
            }
            if (lllllllllllllllIlllIllIIIlIIlIII.subroutines[lllllllllllllllIlllIllIIIlIIIlll] != null) {
                return;
            }
            lllllllllllllllIlllIllIIIlIIlIII.subroutines[lllllllllllllllIlllIllIIIlIIIlll] = lllllllllllllllIlllIllIIIlIIIIlI.copy();
            AbstractInsnNode lllllllllllllllIlllIllIIIlIIlIlI = lllllllllllllllIlllIllIIIlIIlIII.insns.get(lllllllllllllllIlllIllIIIlIIIlll);
            if (lllllllllllllllIlllIllIIIlIIlIlI instanceof JumpInsnNode) {
                if (lllllllllllllllIlllIllIIIlIIlIlI.getOpcode() == 168) {
                    lllllllllllllllIlllIllIIIlIIIIIl.add(lllllllllllllllIlllIllIIIlIIlIlI);
                } else {
                    JumpInsnNode lllllllllllllllIlllIllIIIlIlIIll = (JumpInsnNode)lllllllllllllllIlllIllIIIlIIlIlI;
                    lllllllllllllllIlllIllIIIlIIlIII.findSubroutine(lllllllllllllllIlllIllIIIlIIlIII.insns.indexOf(lllllllllllllllIlllIllIIIlIlIIll.label), lllllllllllllllIlllIllIIIlIIIIlI, lllllllllllllllIlllIllIIIlIIIIIl);
                }
            } else if (lllllllllllllllIlllIllIIIlIIlIlI instanceof TableSwitchInsnNode) {
                TableSwitchInsnNode lllllllllllllllIlllIllIIIlIlIIII = (TableSwitchInsnNode)lllllllllllllllIlllIllIIIlIIlIlI;
                lllllllllllllllIlllIllIIIlIIlIII.findSubroutine(lllllllllllllllIlllIllIIIlIIlIII.insns.indexOf(lllllllllllllllIlllIllIIIlIlIIII.dflt), lllllllllllllllIlllIllIIIlIIIIlI, lllllllllllllllIlllIllIIIlIIIIIl);
                for (int lllllllllllllllIlllIllIIIlIlIIIl = lllllllllllllllIlllIllIIIlIlIIII.labels.size() - 1; lllllllllllllllIlllIllIIIlIlIIIl >= 0; --lllllllllllllllIlllIllIIIlIlIIIl) {
                    LabelNode lllllllllllllllIlllIllIIIlIlIIlI = lllllllllllllllIlllIllIIIlIlIIII.labels.get(lllllllllllllllIlllIllIIIlIlIIIl);
                    lllllllllllllllIlllIllIIIlIIlIII.findSubroutine(lllllllllllllllIlllIllIIIlIIlIII.insns.indexOf(lllllllllllllllIlllIllIIIlIlIIlI), lllllllllllllllIlllIllIIIlIIIIlI, lllllllllllllllIlllIllIIIlIIIIIl);
                }
            } else if (lllllllllllllllIlllIllIIIlIIlIlI instanceof LookupSwitchInsnNode) {
                LookupSwitchInsnNode lllllllllllllllIlllIllIIIlIIllIl = (LookupSwitchInsnNode)lllllllllllllllIlllIllIIIlIIlIlI;
                lllllllllllllllIlllIllIIIlIIlIII.findSubroutine(lllllllllllllllIlllIllIIIlIIlIII.insns.indexOf(lllllllllllllllIlllIllIIIlIIllIl.dflt), lllllllllllllllIlllIllIIIlIIIIlI, lllllllllllllllIlllIllIIIlIIIIIl);
                for (int lllllllllllllllIlllIllIIIlIIlllI = lllllllllllllllIlllIllIIIlIIllIl.labels.size() - 1; lllllllllllllllIlllIllIIIlIIlllI >= 0; --lllllllllllllllIlllIllIIIlIIlllI) {
                    LabelNode lllllllllllllllIlllIllIIIlIIllll = lllllllllllllllIlllIllIIIlIIllIl.labels.get(lllllllllllllllIlllIllIIIlIIlllI);
                    lllllllllllllllIlllIllIIIlIIlIII.findSubroutine(lllllllllllllllIlllIllIIIlIIlIII.insns.indexOf(lllllllllllllllIlllIllIIIlIIllll), lllllllllllllllIlllIllIIIlIIIIlI, lllllllllllllllIlllIllIIIlIIIIIl);
                }
            }
            List<TryCatchBlockNode> lllllllllllllllIlllIllIIIlIIlIIl = lllllllllllllllIlllIllIIIlIIlIII.handlers[lllllllllllllllIlllIllIIIlIIIlll];
            if (lllllllllllllllIlllIllIIIlIIlIIl != null) {
                for (int lllllllllllllllIlllIllIIIlIIlIll = 0; lllllllllllllllIlllIllIIIlIIlIll < lllllllllllllllIlllIllIIIlIIlIIl.size(); ++lllllllllllllllIlllIllIIIlIIlIll) {
                    TryCatchBlockNode lllllllllllllllIlllIllIIIlIIllII = lllllllllllllllIlllIllIIIlIIlIIl.get(lllllllllllllllIlllIllIIIlIIlIll);
                    lllllllllllllllIlllIllIIIlIIlIII.findSubroutine(lllllllllllllllIlllIllIIIlIIlIII.insns.indexOf(lllllllllllllllIlllIllIIIlIIllII.handler), lllllllllllllllIlllIllIIIlIIIIlI, lllllllllllllllIlllIllIIIlIIIIIl);
                }
            }
            switch (lllllllllllllllIlllIllIIIlIIlIlI.getOpcode()) {
                case 167: 
                case 169: 
                case 170: 
                case 171: 
                case 172: 
                case 173: 
                case 174: 
                case 175: 
                case 176: 
                case 177: 
                case 191: {
                    return;
                }
            }
            ++lllllllllllllllIlllIllIIIlIIIlll;
        }
    }

    private void merge(int lllllllllllllllIlllIlIllllllIlIl, Frame<V> lllllllllllllllIlllIlIllllllIlII, Frame<V> lllllllllllllllIlllIlIlllllIlIlI, Subroutine lllllllllllllllIlllIlIlllllIlIIl, boolean[] lllllllllllllllIlllIlIlllllIlIII) throws AnalyzerException {
        boolean lllllllllllllllIlllIlIlllllIlllI;
        Analyzer lllllllllllllllIlllIlIlllllIllIl;
        Frame<V> lllllllllllllllIlllIlIllllllIIII = lllllllllllllllIlllIlIlllllIllIl.frames[lllllllllllllllIlllIlIllllllIlIl];
        Subroutine lllllllllllllllIlllIlIlllllIllll = lllllllllllllllIlllIlIlllllIllIl.subroutines[lllllllllllllllIlllIlIllllllIlIl];
        lllllllllllllllIlllIlIlllllIlIlI.merge(lllllllllllllllIlllIlIllllllIlII, lllllllllllllllIlllIlIlllllIlIII);
        if (lllllllllllllllIlllIlIllllllIIII == null) {
            lllllllllllllllIlllIlIlllllIllIl.frames[lllllllllllllllIlllIlIllllllIlIl] = lllllllllllllllIlllIlIlllllIllIl.newFrame(lllllllllllllllIlllIlIlllllIlIlI);
            boolean lllllllllllllllIlllIlIllllllIlll = true;
        } else {
            lllllllllllllllIlllIlIlllllIlllI = lllllllllllllllIlllIlIllllllIIII.merge(lllllllllllllllIlllIlIlllllIlIlI, lllllllllllllllIlllIlIlllllIllIl.interpreter);
        }
        if (lllllllllllllllIlllIlIlllllIllll != null && lllllllllllllllIlllIlIlllllIlIIl != null) {
            lllllllllllllllIlllIlIlllllIlllI |= lllllllllllllllIlllIlIlllllIllll.merge(lllllllllllllllIlllIlIlllllIlIIl);
        }
        if (lllllllllllllllIlllIlIlllllIlllI && !lllllllllllllllIlllIlIlllllIllIl.queued[lllllllllllllllIlllIlIllllllIlIl]) {
            lllllllllllllllIlllIlIlllllIllIl.queued[lllllllllllllllIlllIlIllllllIlIl] = true;
            lllllllllllllllIlllIlIlllllIllIl.queue[lllllllllllllllIlllIlIlllllIllIl.top++] = lllllllllllllllIlllIlIllllllIlIl;
        }
    }

    public Analyzer(Interpreter<V> lllllllllllllllIlllIllIIlIlllIlI) {
        Analyzer lllllllllllllllIlllIllIIlIlllIll;
        lllllllllllllllIlllIllIIlIlllIll.interpreter = lllllllllllllllIlllIllIIlIlllIlI;
    }

    public List<TryCatchBlockNode> getHandlers(int lllllllllllllllIlllIllIIIIllIllI) {
        Analyzer lllllllllllllllIlllIllIIIIllIlll;
        return lllllllllllllllIlllIllIIIIllIlll.handlers[lllllllllllllllIlllIllIIIIllIllI];
    }

    protected boolean newControlFlowExceptionEdge(int lllllllllllllllIlllIllIIIIlIIIIl, int lllllllllllllllIlllIllIIIIlIIIII) {
        return true;
    }

    protected void newControlFlowEdge(int lllllllllllllllIlllIllIIIIlIIlII, int lllllllllllllllIlllIllIIIIlIIIll) {
    }

    protected void init(String lllllllllllllllIlllIllIIIIllIIlI, MethodNode lllllllllllllllIlllIllIIIIllIIIl) throws AnalyzerException {
    }

    protected Frame<V> newFrame(int lllllllllllllllIlllIllIIIIlIlIll, int lllllllllllllllIlllIllIIIIlIllII) {
        return new Frame(lllllllllllllllIlllIllIIIIlIlIll, lllllllllllllllIlllIllIIIIlIllII);
    }

    public Frame<V>[] getFrames() {
        Analyzer lllllllllllllllIlllIllIIIIlllIlI;
        return lllllllllllllllIlllIllIIIIlllIlI.frames;
    }

    private void merge(int lllllllllllllllIlllIllIIIIIIllIl, Frame<V> lllllllllllllllIlllIllIIIIIIIlIl, Subroutine lllllllllllllllIlllIllIIIIIIIlII) throws AnalyzerException {
        boolean lllllllllllllllIlllIllIIIIIIlIII;
        Analyzer lllllllllllllllIlllIllIIIIIIIlll;
        Frame<V> lllllllllllllllIlllIllIIIIIIlIlI = lllllllllllllllIlllIllIIIIIIIlll.frames[lllllllllllllllIlllIllIIIIIIllIl];
        Subroutine lllllllllllllllIlllIllIIIIIIlIIl = lllllllllllllllIlllIllIIIIIIIlll.subroutines[lllllllllllllllIlllIllIIIIIIllIl];
        if (lllllllllllllllIlllIllIIIIIIlIlI == null) {
            lllllllllllllllIlllIllIIIIIIIlll.frames[lllllllllllllllIlllIllIIIIIIllIl] = lllllllllllllllIlllIllIIIIIIIlll.newFrame(lllllllllllllllIlllIllIIIIIIIlIl);
            boolean lllllllllllllllIlllIllIIIIIIllll = true;
        } else {
            lllllllllllllllIlllIllIIIIIIlIII = lllllllllllllllIlllIllIIIIIIlIlI.merge(lllllllllllllllIlllIllIIIIIIIlIl, lllllllllllllllIlllIllIIIIIIIlll.interpreter);
        }
        if (lllllllllllllllIlllIllIIIIIIlIIl == null) {
            if (lllllllllllllllIlllIllIIIIIIIlII != null) {
                lllllllllllllllIlllIllIIIIIIIlll.subroutines[lllllllllllllllIlllIllIIIIIIllIl] = lllllllllllllllIlllIllIIIIIIIlII.copy();
                lllllllllllllllIlllIllIIIIIIlIII = true;
            }
        } else if (lllllllllllllllIlllIllIIIIIIIlII != null) {
            lllllllllllllllIlllIllIIIIIIlIII |= lllllllllllllllIlllIllIIIIIIlIIl.merge(lllllllllllllllIlllIllIIIIIIIlII);
        }
        if (lllllllllllllllIlllIllIIIIIIlIII && !lllllllllllllllIlllIllIIIIIIIlll.queued[lllllllllllllllIlllIllIIIIIIllIl]) {
            lllllllllllllllIlllIllIIIIIIIlll.queued[lllllllllllllllIlllIllIIIIIIllIl] = true;
            lllllllllllllllIlllIllIIIIIIIlll.queue[lllllllllllllllIlllIllIIIIIIIlll.top++] = lllllllllllllllIlllIllIIIIIIllIl;
        }
    }
}

