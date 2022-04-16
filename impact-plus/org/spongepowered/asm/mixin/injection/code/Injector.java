/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.injection.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.InjectorTarget;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.util.Bytecode;

public abstract class Injector {
    protected final /* synthetic */ Type[] methodArgs;
    protected final /* synthetic */ boolean isStatic;
    protected final /* synthetic */ MethodNode methodNode;
    protected final /* synthetic */ Type returnType;
    protected final /* synthetic */ ClassNode classNode;
    protected static final /* synthetic */ Logger logger;
    protected /* synthetic */ InjectionInfo info;

    protected AbstractInsnNode invokeHandler(InsnList llllllllllllllllllIIlIIlIIllIllI) {
        Injector llllllllllllllllllIIlIIlIIlllIII;
        return llllllllllllllllllIIlIIlIIlllIII.invokeHandler(llllllllllllllllllIIlIIlIIllIllI, llllllllllllllllllIIlIIlIIlllIII.methodNode);
    }

    private Collection<TargetNode> findTargetNodes(InjectorTarget llllllllllllllllllIIlIIllIIIllIl, List<InjectionPoint> llllllllllllllllllIIlIIllIIlIlll) {
        MethodNode llllllllllllllllllIIlIIllIIlIlIl = llllllllllllllllllIIlIIllIIIllIl.getMethod();
        TreeMap<Integer, TargetNode> llllllllllllllllllIIlIIllIIlIIll = new TreeMap<Integer, TargetNode>();
        ArrayList<AbstractInsnNode> llllllllllllllllllIIlIIllIIlIIIl = new ArrayList<AbstractInsnNode>(32);
        for (InjectionPoint llllllllllllllllllIIlIIllIIlllII : llllllllllllllllllIIlIIllIIlIlll) {
            Injector llllllllllllllllllIIlIIllIIllIlI;
            llllllllllllllllllIIlIIllIIlIIIl.clear();
            if (!llllllllllllllllllIIlIIllIIllIlI.findTargetNodes(llllllllllllllllllIIlIIllIIlIlIl, llllllllllllllllllIIlIIllIIlllII, llllllllllllllllllIIlIIllIIIllIl.getSlice(llllllllllllllllllIIlIIllIIlllII), llllllllllllllllllIIlIIllIIlIIIl)) continue;
            for (AbstractInsnNode llllllllllllllllllIIlIIllIIllllI : llllllllllllllllllIIlIIllIIlIIIl) {
                Integer llllllllllllllllllIIlIIllIlIIIlI = llllllllllllllllllIIlIIllIIlIlIl.instructions.indexOf(llllllllllllllllllIIlIIllIIllllI);
                TargetNode llllllllllllllllllIIlIIllIlIIIIl = (TargetNode)llllllllllllllllllIIlIIllIIlIIll.get(llllllllllllllllllIIlIIllIlIIIlI);
                if (llllllllllllllllllIIlIIllIlIIIIl == null) {
                    llllllllllllllllllIIlIIllIlIIIIl = new TargetNode(llllllllllllllllllIIlIIllIIllllI);
                    llllllllllllllllllIIlIIllIIlIIll.put(llllllllllllllllllIIlIIllIlIIIlI, llllllllllllllllllIIlIIllIlIIIIl);
                }
                llllllllllllllllllIIlIIllIlIIIIl.nominators.add(llllllllllllllllllIIlIIllIIlllII);
            }
        }
        return llllllllllllllllllIIlIIllIIlIIll.values();
    }

    protected void postInject(Target llllllllllllllllllIIlIIlIlIIIlIl, InjectionNodes.InjectionNode llllllllllllllllllIIlIIlIlIIIIll) {
    }

    private static boolean canCoerce(ClassInfo llllllllllllllllllIIlIIIllIIllII, ClassInfo llllllllllllllllllIIlIIIllIIlIll) {
        return llllllllllllllllllIIlIIIllIIllII != null && llllllllllllllllllIIlIIIllIIlIll != null && (llllllllllllllllllIIlIIIllIIlIll == llllllllllllllllllIIlIIIllIIllII || llllllllllllllllllIIlIIIllIIlIll.hasSuperClass(llllllllllllllllllIIlIIIllIIllII));
    }

    public static boolean canCoerce(char llllllllllllllllllIIlIIIllIllllI, char llllllllllllllllllIIlIIIllIlllll) {
        return llllllllllllllllllIIlIIIllIlllll == 'I' && "IBSCZ".indexOf(llllllllllllllllllIIlIIIllIllllI) > -1;
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    public final List<InjectionNodes.InjectionNode> find(InjectorTarget llllllllllllllllllIIlIlIIlIIIIIl, List<InjectionPoint> llllllllllllllllllIIlIlIIIllllll) {
        Injector llllllllllllllllllIIlIlIIlIIIIll;
        llllllllllllllllllIIlIlIIlIIIIll.sanityCheck(llllllllllllllllllIIlIlIIlIIIIIl.getTarget(), llllllllllllllllllIIlIlIIIllllll);
        ArrayList<InjectionNodes.InjectionNode> llllllllllllllllllIIlIlIIIllllIl = new ArrayList<InjectionNodes.InjectionNode>();
        for (TargetNode llllllllllllllllllIIlIlIIlIIIlIl : llllllllllllllllllIIlIlIIlIIIIll.findTargetNodes(llllllllllllllllllIIlIlIIlIIIIIl, llllllllllllllllllIIlIlIIIllllll)) {
            llllllllllllllllllIIlIlIIlIIIIll.addTargetNode(llllllllllllllllllIIlIlIIlIIIIIl.getTarget(), llllllllllllllllllIIlIlIIIllllIl, llllllllllllllllllIIlIlIIlIIIlIl.insn, llllllllllllllllllIIlIlIIlIIIlIl.nominators);
        }
        return llllllllllllllllllIIlIlIIIllllIl;
    }

    protected void throwException(InsnList llllllllllllllllllIIlIIlIIIIlIIl, String llllllllllllllllllIIlIIlIIIIlIll, String llllllllllllllllllIIlIIlIIIIIlll) {
        llllllllllllllllllIIlIIlIIIIlIIl.add(new TypeInsnNode(187, llllllllllllllllllIIlIIlIIIIlIll));
        llllllllllllllllllIIlIIlIIIIlIIl.add(new InsnNode(89));
        llllllllllllllllllIIlIIlIIIIlIIl.add(new LdcInsnNode(llllllllllllllllllIIlIIlIIIIIlll));
        llllllllllllllllllIIlIIlIIIIlIIl.add(new MethodInsnNode(183, llllllllllllllllllIIlIIlIIIIlIll, "<init>", "(Ljava/lang/String;)V", false));
        llllllllllllllllllIIlIIlIIIIlIIl.add(new InsnNode(191));
    }

    protected void addTargetNode(Target llllllllllllllllllIIlIlIIIIllIlI, List<InjectionNodes.InjectionNode> llllllllllllllllllIIlIlIIIIlIlll, AbstractInsnNode llllllllllllllllllIIlIlIIIIlIlIl, Set<InjectionPoint> llllllllllllllllllIIlIlIIIIlIIll) {
        llllllllllllllllllIIlIlIIIIlIlll.add(llllllllllllllllllIIlIlIIIIllIlI.addInjectionNode(llllllllllllllllllIIlIlIIIIlIlIl));
    }

    protected AbstractInsnNode invokeHandler(InsnList llllllllllllllllllIIlIIlIIlIIIIl, MethodNode llllllllllllllllllIIlIIlIIlIIlll) {
        Injector llllllllllllllllllIIlIIlIIlIlIIl;
        boolean llllllllllllllllllIIlIIlIIlIIllI;
        boolean bl = llllllllllllllllllIIlIIlIIlIIllI = (llllllllllllllllllIIlIIlIIlIIlll.access & 2) != 0;
        int llllllllllllllllllIIlIIlIIlIIlIl = llllllllllllllllllIIlIIlIIlIlIIl.isStatic ? 184 : (llllllllllllllllllIIlIIlIIlIIllI ? 183 : 182);
        MethodInsnNode llllllllllllllllllIIlIIlIIlIIlII = new MethodInsnNode(llllllllllllllllllIIlIIlIIlIIlIl, llllllllllllllllllIIlIIlIIlIlIIl.classNode.name, llllllllllllllllllIIlIIlIIlIIlll.name, llllllllllllllllllIIlIIlIIlIIlll.desc, false);
        llllllllllllllllllIIlIIlIIlIIIIl.add(llllllllllllllllllIIlIIlIIlIIlII);
        llllllllllllllllllIIlIIlIIlIlIIl.info.addCallbackInvocation(llllllllllllllllllIIlIIlIIlIIlll);
        return llllllllllllllllllIIlIIlIIlIIlII;
    }

    protected abstract void inject(Target var1, InjectionNodes.InjectionNode var2);

    public static boolean canCoerce(Type llllllllllllllllllIIlIIIllllllIl, Type llllllllllllllllllIIlIIIlllllllI) {
        if (llllllllllllllllllIIlIIIllllllIl.getSort() == 10 && llllllllllllllllllIIlIIIlllllllI.getSort() == 10) {
            return Injector.canCoerce(ClassInfo.forType(llllllllllllllllllIIlIIIllllllIl), ClassInfo.forType(llllllllllllllllllIIlIIIlllllllI));
        }
        return Injector.canCoerce(llllllllllllllllllIIlIIIllllllIl.getDescriptor(), llllllllllllllllllIIlIIIlllllllI.getDescriptor());
    }

    public Injector(InjectionInfo llllllllllllllllllIIlIlIIllllllI) {
        llllllllllllllllllIIlIlIIlllllII(llllllllllllllllllIIlIlIIllllllI.getClassNode(), llllllllllllllllllIIlIlIIllllllI.getMethod());
        Injector llllllllllllllllllIIlIlIIlllllII;
        llllllllllllllllllIIlIlIIlllllII.info = llllllllllllllllllIIlIlIIllllllI;
    }

    private Injector(ClassNode llllllllllllllllllIIlIlIIlIlllll, MethodNode llllllllllllllllllIIlIlIIllIIIll) {
        Injector llllllllllllllllllIIlIlIIllIIlIl;
        llllllllllllllllllIIlIlIIllIIlIl.classNode = llllllllllllllllllIIlIlIIlIlllll;
        llllllllllllllllllIIlIlIIllIIlIl.methodNode = llllllllllllllllllIIlIlIIllIIIll;
        llllllllllllllllllIIlIlIIllIIlIl.methodArgs = Type.getArgumentTypes(llllllllllllllllllIIlIlIIllIIlIl.methodNode.desc);
        llllllllllllllllllIIlIlIIllIIlIl.returnType = Type.getReturnType(llllllllllllllllllIIlIlIIllIIlIl.methodNode.desc);
        llllllllllllllllllIIlIlIIllIIlIl.isStatic = Bytecode.methodIsStatic(llllllllllllllllllIIlIlIIllIIlIl.methodNode);
    }

    public static boolean canCoerce(String llllllllllllllllllIIlIIIlllIlIll, String llllllllllllllllllIIlIIIlllIlIIl) {
        if (llllllllllllllllllIIlIIIlllIlIll.length() > 1 || llllllllllllllllllIIlIIIlllIlIIl.length() > 1) {
            return false;
        }
        return Injector.canCoerce(llllllllllllllllllIIlIIIlllIlIll.charAt(0), llllllllllllllllllIIlIIIlllIlIIl.charAt(0));
    }

    protected void sanityCheck(Target llllllllllllllllllIIlIIlIlIIlIll, List<InjectionPoint> llllllllllllllllllIIlIIlIlIIllll) {
        Injector llllllllllllllllllIIlIIlIlIIllIl;
        if (llllllllllllllllllIIlIIlIlIIlIll.classNode != llllllllllllllllllIIlIIlIlIIllIl.classNode) {
            throw new InvalidInjectionException(llllllllllllllllllIIlIIlIlIIllIl.info, String.valueOf(new StringBuilder().append("Target class does not match injector class in ").append(llllllllllllllllllIIlIIlIlIIllIl)));
        }
    }

    public final void inject(Target llllllllllllllllllIIlIIlllIIllIl, List<InjectionNodes.InjectionNode> llllllllllllllllllIIlIIlllIIlIIl) {
        Injector llllllllllllllllllIIlIIlllIIlllI;
        for (InjectionNodes.InjectionNode llllllllllllllllllIIlIIlllIlIIIl : llllllllllllllllllIIlIIlllIIlIIl) {
            if (llllllllllllllllllIIlIIlllIlIIIl.isRemoved()) {
                if (!llllllllllllllllllIIlIIlllIIlllI.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) continue;
                logger.warn("Target node for {} was removed by a previous injector in {}", new Object[]{llllllllllllllllllIIlIIlllIIlllI.info, llllllllllllllllllIIlIIlllIIllIl});
                continue;
            }
            llllllllllllllllllIIlIIlllIIlllI.inject(llllllllllllllllllIIlIIlllIIllIl, llllllllllllllllllIIlIIlllIlIIIl);
        }
        for (InjectionNodes.InjectionNode llllllllllllllllllIIlIIlllIlIIII : llllllllllllllllllIIlIIlllIIlIIl) {
            llllllllllllllllllIIlIIlllIIlllI.postInject(llllllllllllllllllIIlIIlllIIllIl, llllllllllllllllllIIlIIlllIlIIII);
        }
    }

    public String toString() {
        Injector llllllllllllllllllIIlIlIIlIlIIlI;
        return String.format("%s::%s", llllllllllllllllllIIlIlIIlIlIIlI.classNode.name, llllllllllllllllllIIlIlIIlIlIIlI.methodNode.name);
    }

    protected boolean findTargetNodes(MethodNode llllllllllllllllllIIlIIlIllIlIlI, InjectionPoint llllllllllllllllllIIlIIlIllIIIIl, InsnList llllllllllllllllllIIlIIlIlIlllll, Collection<AbstractInsnNode> llllllllllllllllllIIlIIlIlIllllI) {
        return llllllllllllllllllIIlIIlIllIIIIl.find(llllllllllllllllllIIlIIlIllIlIlI.desc, llllllllllllllllllIIlIIlIlIlllll, llllllllllllllllllIIlIIlIlIllllI);
    }

    public static final class TargetNode {
        final /* synthetic */ Set<InjectionPoint> nominators;
        final /* synthetic */ AbstractInsnNode insn;

        public Set<InjectionPoint> getNominators() {
            TargetNode lIlllllIIlIllIl;
            return Collections.unmodifiableSet(lIlllllIIlIllIl.nominators);
        }

        public boolean equals(Object lIlllllIIlIIllI) {
            TargetNode lIlllllIIlIIlll;
            if (lIlllllIIlIIllI == null || lIlllllIIlIIllI.getClass() != TargetNode.class) {
                return false;
            }
            return ((TargetNode)lIlllllIIlIIllI).insn == lIlllllIIlIIlll.insn;
        }

        public AbstractInsnNode getNode() {
            TargetNode lIlllllIIllIIII;
            return lIlllllIIllIIII.insn;
        }

        public int hashCode() {
            TargetNode lIlllllIIlIIlII;
            return lIlllllIIlIIlII.insn.hashCode();
        }

        TargetNode(AbstractInsnNode lIlllllIIllIIlI) {
            TargetNode lIlllllIIllIlIl;
            lIlllllIIllIlIl.nominators = new HashSet<InjectionPoint>();
            lIlllllIIllIlIl.insn = lIlllllIIllIIlI;
        }
    }
}

