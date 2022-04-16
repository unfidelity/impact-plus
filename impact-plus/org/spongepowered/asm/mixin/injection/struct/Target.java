/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.struct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.util.Bytecode;

public class Target
implements Comparable<Target>,
Iterable<AbstractInsnNode> {
    private /* synthetic */ LabelNode end;
    private final /* synthetic */ InjectionNodes injectionNodes;
    public final /* synthetic */ InsnList insns;
    public final /* synthetic */ Type returnType;
    private /* synthetic */ LabelNode start;
    public final /* synthetic */ Type[] arguments;
    public final /* synthetic */ ClassNode classNode;
    public final /* synthetic */ boolean isCtor;
    private /* synthetic */ List<Integer> argMapVars;
    private /* synthetic */ String callbackInfoClass;
    public final /* synthetic */ MethodNode method;
    private /* synthetic */ int[] argIndices;
    private final /* synthetic */ int maxStack;
    private final /* synthetic */ int maxLocals;
    private /* synthetic */ String callbackDescriptor;
    public final /* synthetic */ boolean isStatic;

    public InjectionNodes.InjectionNode addInjectionNode(AbstractInsnNode llllllllllllllllIIlIlIlIIlIIIIll) {
        Target llllllllllllllllIIlIlIlIIlIIIllI;
        return llllllllllllllllIIlIlIlIIlIIIllI.injectionNodes.add(llllllllllllllllIIlIlIlIIlIIIIll);
    }

    public int indexOf(AbstractInsnNode llllllllllllllllIIlIlIIllIIllllI) {
        Target llllllllllllllllIIlIlIIllIlIIIIl;
        return llllllllllllllllIIlIlIIllIlIIIIl.insns.indexOf(llllllllllllllllIIlIlIIllIIllllI);
    }

    public void replaceNode(AbstractInsnNode llllllllllllllllIIlIlIIlIlIIIIlI, InsnList llllllllllllllllIIlIlIIlIlIIIIIl) {
        Target llllllllllllllllIIlIlIIlIlIIIIll;
        llllllllllllllllIIlIlIIlIlIIIIll.insns.insertBefore(llllllllllllllllIIlIlIIlIlIIIIlI, llllllllllllllllIIlIlIIlIlIIIIIl);
        llllllllllllllllIIlIlIIlIlIIIIll.removeNode(llllllllllllllllIIlIlIIlIlIIIIlI);
    }

    public int getMaxStack() {
        Target llllllllllllllllIIlIlIlIIIlllIII;
        return llllllllllllllllIIlIlIlIIIlllIII.maxStack;
    }

    public void addToStack(int llllllllllllllllIIlIlIlIIIIlIIll) {
        Target llllllllllllllllIIlIlIlIIIIlIlII;
        llllllllllllllllIIlIlIlIIIIlIlII.setMaxStack(llllllllllllllllIIlIlIlIIIIlIlII.maxStack + llllllllllllllllIIlIlIlIIIIlIIll);
    }

    public void setMaxStack(int llllllllllllllllIIlIlIlIIIIIllll) {
        Target llllllllllllllllIIlIlIlIIIIlIIII;
        if (llllllllllllllllIIlIlIlIIIIIllll > llllllllllllllllIIlIlIlIIIIlIIII.method.maxStack) {
            llllllllllllllllIIlIlIlIIIIlIIII.method.maxStack = llllllllllllllllIIlIlIlIIIIIllll;
        }
    }

    private int allocateArgMapLocal(int llllllllllllllllIIlIlIIllllIlllI, int llllllllllllllllIIlIlIIllllIlIIl) {
        Target llllllllllllllllIIlIlIIllllIlIll;
        if (llllllllllllllllIIlIlIIllllIlllI >= llllllllllllllllIIlIlIIllllIlIll.argMapVars.size()) {
            int llllllllllllllllIIlIlIIlllllIIIl = llllllllllllllllIIlIlIIllllIlIll.allocateLocals(llllllllllllllllIIlIlIIllllIlIIl);
            for (int llllllllllllllllIIlIlIIlllllIIlI = 0; llllllllllllllllIIlIlIIlllllIIlI < llllllllllllllllIIlIlIIllllIlIIl; ++llllllllllllllllIIlIlIIlllllIIlI) {
                llllllllllllllllIIlIlIIllllIlIll.argMapVars.add(llllllllllllllllIIlIlIIlllllIIIl + llllllllllllllllIIlIlIIlllllIIlI);
            }
            return llllllllllllllllIIlIlIIlllllIIIl;
        }
        int llllllllllllllllIIlIlIIllllIllII = llllllllllllllllIIlIlIIllllIlIll.argMapVars.get(llllllllllllllllIIlIlIIllllIlllI);
        if (llllllllllllllllIIlIlIIllllIlIIl > 1 && llllllllllllllllIIlIlIIllllIlllI + llllllllllllllllIIlIlIIllllIlIIl > llllllllllllllllIIlIlIIllllIlIll.argMapVars.size()) {
            int llllllllllllllllIIlIlIIlllllIIII = llllllllllllllllIIlIlIIllllIlIll.allocateLocals(1);
            if (llllllllllllllllIIlIlIIlllllIIII == llllllllllllllllIIlIlIIllllIllII + 1) {
                llllllllllllllllIIlIlIIllllIlIll.argMapVars.add(llllllllllllllllIIlIlIIlllllIIII);
                return llllllllllllllllIIlIlIIllllIllII;
            }
            llllllllllllllllIIlIlIIllllIlIll.argMapVars.set(llllllllllllllllIIlIlIIllllIlllI, llllllllllllllllIIlIlIIlllllIIII);
            llllllllllllllllIIlIlIIllllIlIll.argMapVars.add(llllllllllllllllIIlIlIIllllIlIll.allocateLocals(1));
            return llllllllllllllllIIlIlIIlllllIIII;
        }
        return llllllllllllllllIIlIlIIllllIllII;
    }

    @Override
    public int compareTo(Target llllllllllllllllIIlIlIIllIlIllII) {
        Target llllllllllllllllIIlIlIIllIlIlIll;
        if (llllllllllllllllIIlIlIIllIlIllII == null) {
            return Integer.MAX_VALUE;
        }
        return llllllllllllllllIIlIlIIllIlIlIll.toString().compareTo(llllllllllllllllIIlIlIIllIlIllII.toString());
    }

    public void replaceNode(AbstractInsnNode llllllllllllllllIIlIlIIlIllIIllI, AbstractInsnNode llllllllllllllllIIlIlIIlIllIlIII) {
        Target llllllllllllllllIIlIlIIlIllIIlll;
        llllllllllllllllIIlIlIIlIllIIlll.insns.insertBefore(llllllllllllllllIIlIlIIlIllIIllI, llllllllllllllllIIlIlIIlIllIlIII);
        llllllllllllllllIIlIlIIlIllIIlll.insns.remove(llllllllllllllllIIlIlIIlIllIIllI);
        llllllllllllllllIIlIlIIlIllIIlll.injectionNodes.replace(llllllllllllllllIIlIlIIlIllIIllI, llllllllllllllllIIlIlIIlIllIlIII);
    }

    public InjectionNodes.InjectionNode getInjectionNode(AbstractInsnNode llllllllllllllllIIlIlIlIIIllllll) {
        Target llllllllllllllllIIlIlIlIIlIIIIII;
        return llllllllllllllllIIlIlIlIIlIIIIII.injectionNodes.get(llllllllllllllllIIlIlIlIIIllllll);
    }

    public int getCurrentMaxStack() {
        Target llllllllllllllllIIlIlIlIIIllIIIl;
        return llllllllllllllllIIlIlIlIIIllIIIl.method.maxStack;
    }

    public void replaceNode(AbstractInsnNode llllllllllllllllIIlIlIIlIlIllIll, AbstractInsnNode llllllllllllllllIIlIlIIlIlIllIlI, InsnList llllllllllllllllIIlIlIIlIlIlllIl) {
        Target llllllllllllllllIIlIlIIlIlIlllII;
        llllllllllllllllIIlIlIIlIlIlllII.insns.insertBefore(llllllllllllllllIIlIlIIlIlIllIll, llllllllllllllllIIlIlIIlIlIlllIl);
        llllllllllllllllIIlIlIIlIlIlllII.insns.remove(llllllllllllllllIIlIlIIlIlIllIll);
        llllllllllllllllIIlIlIIlIlIlllII.injectionNodes.replace(llllllllllllllllIIlIlIIlIlIllIll, llllllllllllllllIIlIlIIlIlIllIlI);
    }

    public MethodInsnNode findInitNodeFor(TypeInsnNode llllllllllllllllIIlIlIIllIIIlIlI) {
        Target llllllllllllllllIIlIlIIllIIIlIll;
        int llllllllllllllllIIlIlIIllIIIlIIl = llllllllllllllllIIlIlIIllIIIlIll.indexOf(llllllllllllllllIIlIlIIllIIIlIlI);
        ListIterator<AbstractInsnNode> llllllllllllllllIIlIlIIllIIIllII = llllllllllllllllIIlIlIIllIIIlIll.insns.iterator(llllllllllllllllIIlIlIIllIIIlIIl);
        while (llllllllllllllllIIlIlIIllIIIllII.hasNext()) {
            AbstractInsnNode llllllllllllllllIIlIlIIllIIIllIl = (AbstractInsnNode)llllllllllllllllIIlIlIIllIIIllII.next();
            if (!(llllllllllllllllIIlIlIIllIIIllIl instanceof MethodInsnNode) || llllllllllllllllIIlIlIIllIIIllIl.getOpcode() != 183) continue;
            MethodInsnNode llllllllllllllllIIlIlIIllIIIlllI = (MethodInsnNode)llllllllllllllllIIlIlIIllIIIllIl;
            if (!"<init>".equals(llllllllllllllllIIlIlIIllIIIlllI.name) || !llllllllllllllllIIlIlIIllIIIlllI.owner.equals(llllllllllllllllIIlIlIIllIIIlIlI.desc)) continue;
            return llllllllllllllllIIlIlIIllIIIlllI;
        }
        return null;
    }

    public void addToLocals(int llllllllllllllllIIlIlIlIIIIlllll) {
        Target llllllllllllllllIIlIlIlIIIlIIIlI;
        llllllllllllllllIIlIlIlIIIlIIIlI.setMaxLocals(llllllllllllllllIIlIlIlIIIlIIIlI.maxLocals + llllllllllllllllIIlIlIlIIIIlllll);
    }

    public AbstractInsnNode get(int llllllllllllllllIIlIlIIllIIllIlI) {
        Target llllllllllllllllIIlIlIIllIIllIIl;
        return llllllllllllllllIIlIlIIllIIllIIl.insns.get(llllllllllllllllIIlIlIIllIIllIlI);
    }

    public String getSimpleCallbackDescriptor() {
        Target llllllllllllllllIIlIlIIlllIlIIll;
        return String.format("(L%s;)V", llllllllllllllllIIlIlIIlllIlIIll.getCallbackInfoClass());
    }

    public int getCurrentMaxLocals() {
        Target llllllllllllllllIIlIlIlIIIllIlIl;
        return llllllllllllllllIIlIlIlIIIllIlIl.method.maxLocals;
    }

    public void wrapNode(AbstractInsnNode llllllllllllllllIIlIlIIlIlIIllIl, AbstractInsnNode llllllllllllllllIIlIlIIlIlIIllII, InsnList llllllllllllllllIIlIlIIlIlIIlIll, InsnList llllllllllllllllIIlIlIIlIlIIllll) {
        Target llllllllllllllllIIlIlIIlIlIIlllI;
        llllllllllllllllIIlIlIIlIlIIlllI.insns.insertBefore(llllllllllllllllIIlIlIIlIlIIllIl, llllllllllllllllIIlIlIIlIlIIlIll);
        llllllllllllllllIIlIlIIlIlIIlllI.insns.insert(llllllllllllllllIIlIlIIlIlIIllIl, llllllllllllllllIIlIlIIlIlIIllll);
        llllllllllllllllIIlIlIIlIlIIlllI.injectionNodes.replace(llllllllllllllllIIlIlIIlIlIIllIl, llllllllllllllllIIlIlIIlIlIIllII);
    }

    public int allocateLocal() {
        Target llllllllllllllllIIlIlIlIIIlIllll;
        return llllllllllllllllIIlIlIlIIIlIllll.allocateLocals(1);
    }

    private void addLocalVariable(int llllllllllllllllIIlIlIIlIIlIIIIl, String llllllllllllllllIIlIlIIlIIlIIIII, String llllllllllllllllIIlIlIIlIIIlllll, LabelNode llllllllllllllllIIlIlIIlIIlIIlII, LabelNode llllllllllllllllIIlIlIIlIIlIIIll) {
        Target llllllllllllllllIIlIlIIlIIlIIIlI;
        if (llllllllllllllllIIlIlIIlIIlIIIlI.method.localVariables == null) {
            llllllllllllllllIIlIlIIlIIlIIIlI.method.localVariables = new ArrayList<LocalVariableNode>();
        }
        llllllllllllllllIIlIlIIlIIlIIIlI.method.localVariables.add(new LocalVariableNode(llllllllllllllllIIlIlIIlIIlIIIII, llllllllllllllllIIlIlIIlIIIlllll, null, llllllllllllllllIIlIlIIlIIlIIlII, llllllllllllllllIIlIlIIlIIlIIIll, llllllllllllllllIIlIlIIlIIlIIIIl));
    }

    public int indexOf(InjectionNodes.InjectionNode llllllllllllllllIIlIlIIllIlIIlII) {
        Target llllllllllllllllIIlIlIIllIlIIlIl;
        return llllllllllllllllIIlIlIIllIlIIlIl.insns.indexOf(llllllllllllllllIIlIlIIllIlIIlII.getCurrentTarget());
    }

    public void insertBefore(InjectionNodes.InjectionNode llllllllllllllllIIlIlIIlIllllIII, InsnList llllllllllllllllIIlIlIIlIllllIlI) {
        Target llllllllllllllllIIlIlIIlIlllllII;
        llllllllllllllllIIlIlIIlIlllllII.insns.insertBefore(llllllllllllllllIIlIlIIlIllllIII.getCurrentTarget(), llllllllllllllllIIlIlIIlIllllIlI);
    }

    public int getMaxLocals() {
        Target llllllllllllllllIIlIlIlIIIlllIll;
        return llllllllllllllllIIlIlIlIIIlllIll.maxLocals;
    }

    public String getCallbackDescriptor(Type[] llllllllllllllllIIlIlIIlllIIlIlI, Type[] llllllllllllllllIIlIlIIlllIIllII) {
        Target llllllllllllllllIIlIlIIlllIIlIll;
        return llllllllllllllllIIlIlIIlllIIlIll.getCallbackDescriptor(false, llllllllllllllllIIlIlIIlllIIlIlI, llllllllllllllllIIlIlIIlllIIllII, 0, Short.MAX_VALUE);
    }

    public int[] getArgIndices() {
        Target llllllllllllllllIIlIlIIllllIIlII;
        if (llllllllllllllllIIlIlIIllllIIlII.argIndices == null) {
            llllllllllllllllIIlIlIIllllIIlII.argIndices = llllllllllllllllIIlIlIIllllIIlII.calcArgIndices(llllllllllllllllIIlIlIIllllIIlII.isStatic ? 0 : 1);
        }
        return llllllllllllllllIIlIlIIllllIIlII.argIndices;
    }

    public Target(ClassNode llllllllllllllllIIlIlIlIIlIIlIlI, MethodNode llllllllllllllllIIlIlIlIIlIIlIIl) {
        Target llllllllllllllllIIlIlIlIIlIIlllI;
        llllllllllllllllIIlIlIlIIlIIlllI.injectionNodes = new InjectionNodes();
        llllllllllllllllIIlIlIlIIlIIlllI.classNode = llllllllllllllllIIlIlIlIIlIIlIlI;
        llllllllllllllllIIlIlIlIIlIIlllI.method = llllllllllllllllIIlIlIlIIlIIlIIl;
        llllllllllllllllIIlIlIlIIlIIlllI.insns = llllllllllllllllIIlIlIlIIlIIlIIl.instructions;
        llllllllllllllllIIlIlIlIIlIIlllI.isStatic = Bytecode.methodIsStatic(llllllllllllllllIIlIlIlIIlIIlIIl);
        llllllllllllllllIIlIlIlIIlIIlllI.isCtor = llllllllllllllllIIlIlIlIIlIIlIIl.name.equals("<init>");
        llllllllllllllllIIlIlIlIIlIIlllI.arguments = Type.getArgumentTypes(llllllllllllllllIIlIlIlIIlIIlIIl.desc);
        llllllllllllllllIIlIlIlIIlIIlllI.returnType = Type.getReturnType(llllllllllllllllIIlIlIlIIlIIlIIl.desc);
        llllllllllllllllIIlIlIlIIlIIlllI.maxStack = llllllllllllllllIIlIlIlIIlIIlIIl.maxStack;
        llllllllllllllllIIlIlIlIIlIIlllI.maxLocals = llllllllllllllllIIlIlIlIIlIIlIIl.maxLocals;
    }

    public MethodInsnNode findSuperInitNode() {
        Target llllllllllllllllIIlIlIIllIIIIIIl;
        if (!llllllllllllllllIIlIlIIllIIIIIIl.isCtor) {
            return null;
        }
        return Bytecode.findSuperInit(llllllllllllllllIIlIlIIllIIIIIIl.method, ClassInfo.forName(llllllllllllllllIIlIlIIllIIIIIIl.classNode.name).getSuperName());
    }

    public void insertBefore(AbstractInsnNode llllllllllllllllIIlIlIIlIllIllll, InsnList llllllllllllllllIIlIlIIlIllIlllI) {
        Target llllllllllllllllIIlIlIIlIlllIIll;
        llllllllllllllllIIlIlIIlIlllIIll.insns.insertBefore(llllllllllllllllIIlIlIIlIllIllll, llllllllllllllllIIlIlIIlIllIlllI);
    }

    private int[] calcArgIndices(int llllllllllllllllIIlIlIIlllIlllIl) {
        Target llllllllllllllllIIlIlIIlllIllIll;
        int[] llllllllllllllllIIlIlIIlllIlllII = new int[llllllllllllllllIIlIlIIlllIllIll.arguments.length];
        for (int llllllllllllllllIIlIlIIlllIlllll = 0; llllllllllllllllIIlIlIIlllIlllll < llllllllllllllllIIlIlIIlllIllIll.arguments.length; ++llllllllllllllllIIlIlIIlllIlllll) {
            llllllllllllllllIIlIlIIlllIlllII[llllllllllllllllIIlIlIIlllIlllll] = llllllllllllllllIIlIlIIlllIlllIl;
            llllllllllllllllIIlIlIIlllIlllIl += llllllllllllllllIIlIlIIlllIllIll.arguments[llllllllllllllllIIlIlIIlllIlllll].getSize();
        }
        return llllllllllllllllIIlIlIIlllIlllII;
    }

    public void removeNode(AbstractInsnNode llllllllllllllllIIlIlIIlIIlllIll) {
        Target llllllllllllllllIIlIlIIlIIlllllI;
        llllllllllllllllIIlIlIIlIIlllllI.insns.remove(llllllllllllllllIIlIlIIlIIlllIll);
        llllllllllllllllIIlIlIIlIIlllllI.injectionNodes.remove(llllllllllllllllIIlIlIIlIIlllIll);
    }

    public void addLocalVariable(int llllllllllllllllIIlIlIIlIIllIIIl, String llllllllllllllllIIlIlIIlIIllIIII, String llllllllllllllllIIlIlIIlIIlIllll) {
        Target llllllllllllllllIIlIlIIlIIllIIlI;
        if (llllllllllllllllIIlIlIIlIIllIIlI.start == null) {
            llllllllllllllllIIlIlIIlIIllIIlI.start = new LabelNode(new Label());
            llllllllllllllllIIlIlIIlIIllIIlI.end = new LabelNode(new Label());
            llllllllllllllllIIlIlIIlIIllIIlI.insns.insert(llllllllllllllllIIlIlIIlIIllIIlI.start);
            llllllllllllllllIIlIlIIlIIllIIlI.insns.add(llllllllllllllllIIlIlIIlIIllIIlI.end);
        }
        llllllllllllllllIIlIlIIlIIllIIlI.addLocalVariable(llllllllllllllllIIlIlIIlIIllIIIl, llllllllllllllllIIlIlIIlIIllIIII, llllllllllllllllIIlIlIIlIIlIllll, llllllllllllllllIIlIlIIlIIllIIlI.start, llllllllllllllllIIlIlIIlIIllIIlI.end);
    }

    public String toString() {
        Target llllllllllllllllIIlIlIIllIllIIIl;
        return String.format("%s::%s%s", llllllllllllllllIIlIlIIllIllIIIl.classNode.name, llllllllllllllllIIlIlIIllIllIIIl.method.name, llllllllllllllllIIlIlIIllIllIIIl.method.desc);
    }

    public String getCallbackInfoClass() {
        Target llllllllllllllllIIlIlIIlllIlIlIl;
        if (llllllllllllllllIIlIlIIlllIlIlIl.callbackInfoClass == null) {
            llllllllllllllllIIlIlIIlllIlIlIl.callbackInfoClass = CallbackInfo.getCallInfoClassName(llllllllllllllllIIlIlIIlllIlIlIl.returnType);
        }
        return llllllllllllllllIIlIlIIlllIlIlIl.callbackInfoClass;
    }

    public void setMaxLocals(int llllllllllllllllIIlIlIlIIIIllIIl) {
        Target llllllllllllllllIIlIlIlIIIIllIlI;
        if (llllllllllllllllIIlIlIlIIIIllIIl > llllllllllllllllIIlIlIlIIIIllIlI.method.maxLocals) {
            llllllllllllllllIIlIlIlIIIIllIlI.method.maxLocals = llllllllllllllllIIlIlIlIIIIllIIl;
        }
    }

    public int[] generateArgMap(Type[] llllllllllllllllIIlIlIIlllllllIl, int llllllllllllllllIIlIlIlIIIIIIIII) {
        Target llllllllllllllllIIlIlIlIIIIIIIlI;
        if (llllllllllllllllIIlIlIlIIIIIIIlI.argMapVars == null) {
            llllllllllllllllIIlIlIlIIIIIIIlI.argMapVars = new ArrayList<Integer>();
        }
        int[] llllllllllllllllIIlIlIIlllllllll = new int[llllllllllllllllIIlIlIIlllllllIl.length];
        int llllllllllllllllIIlIlIlIIIIIIIll = 0;
        for (int llllllllllllllllIIlIlIlIIIIIIlII = llllllllllllllllIIlIlIlIIIIIIIII; llllllllllllllllIIlIlIlIIIIIIlII < llllllllllllllllIIlIlIIlllllllIl.length; ++llllllllllllllllIIlIlIlIIIIIIlII) {
            int llllllllllllllllIIlIlIlIIIIIIlIl = llllllllllllllllIIlIlIIlllllllIl[llllllllllllllllIIlIlIlIIIIIIlII].getSize();
            llllllllllllllllIIlIlIIlllllllll[llllllllllllllllIIlIlIlIIIIIIlII] = llllllllllllllllIIlIlIlIIIIIIIlI.allocateArgMapLocal(llllllllllllllllIIlIlIlIIIIIIIll, llllllllllllllllIIlIlIlIIIIIIlIl);
            llllllllllllllllIIlIlIlIIIIIIIll += llllllllllllllllIIlIlIlIIIIIIlIl;
        }
        return llllllllllllllllIIlIlIIlllllllll;
    }

    @Override
    public Iterator<AbstractInsnNode> iterator() {
        Target llllllllllllllllIIlIlIIllIIlIllI;
        return llllllllllllllllIIlIlIIllIIlIllI.insns.iterator();
    }

    public String getCallbackDescriptor(boolean llllllllllllllllIIlIlIIllIllllll, Type[] llllllllllllllllIIlIlIIllIlllllI, Type[] llllllllllllllllIIlIlIIllIllllIl, int llllllllllllllllIIlIlIIllIllIllI, int llllllllllllllllIIlIlIIllIllIlIl) {
        Target llllllllllllllllIIlIlIIlllIIIIII;
        if (llllllllllllllllIIlIlIIlllIIIIII.callbackDescriptor == null) {
            llllllllllllllllIIlIlIIlllIIIIII.callbackDescriptor = String.format("(%sL%s;)V", llllllllllllllllIIlIlIIlllIIIIII.method.desc.substring(1, llllllllllllllllIIlIlIIlllIIIIII.method.desc.indexOf(41)), llllllllllllllllIIlIlIIlllIIIIII.getCallbackInfoClass());
        }
        if (!llllllllllllllllIIlIlIIllIllllll || llllllllllllllllIIlIlIIllIlllllI == null) {
            return llllllllllllllllIIlIlIIlllIIIIII.callbackDescriptor;
        }
        StringBuilder llllllllllllllllIIlIlIIllIlllIlI = new StringBuilder(llllllllllllllllIIlIlIIlllIIIIII.callbackDescriptor.substring(0, llllllllllllllllIIlIlIIlllIIIIII.callbackDescriptor.indexOf(41)));
        for (int llllllllllllllllIIlIlIIlllIIIIIl = llllllllllllllllIIlIlIIllIllIllI; llllllllllllllllIIlIlIIlllIIIIIl < llllllllllllllllIIlIlIIllIlllllI.length && llllllllllllllllIIlIlIIllIllIlIl > 0; ++llllllllllllllllIIlIlIIlllIIIIIl) {
            if (llllllllllllllllIIlIlIIllIlllllI[llllllllllllllllIIlIlIIlllIIIIIl] == null) continue;
            llllllllllllllllIIlIlIIllIlllIlI.append(llllllllllllllllIIlIlIIllIlllllI[llllllllllllllllIIlIlIIlllIIIIIl].getDescriptor());
            --llllllllllllllllIIlIlIIllIllIlIl;
        }
        return String.valueOf(llllllllllllllllIIlIlIIllIlllIlI.append(")V"));
    }

    public int allocateLocals(int llllllllllllllllIIlIlIlIIIlIIllI) {
        Target llllllllllllllllIIlIlIlIIIlIlIlI;
        int llllllllllllllllIIlIlIlIIIlIlIII = llllllllllllllllIIlIlIlIIIlIlIlI.method.maxLocals;
        llllllllllllllllIIlIlIlIIIlIlIlI.method.maxLocals += llllllllllllllllIIlIlIlIIIlIIllI;
        return llllllllllllllllIIlIlIlIIIlIlIII;
    }
}

