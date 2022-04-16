/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collection;
import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.modify.InvalidImplicitDiscriminatorException;
import org.spongepowered.asm.mixin.injection.modify.LocalVariableDiscriminator;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class ModifyVariableInjector
extends Injector {
    private final /* synthetic */ LocalVariableDiscriminator discriminator;

    private void inject(Context lllllllllllllllllIIlllIIlIIlllII, int lllllllllllllllllIIlllIIlIIllIII) {
        ModifyVariableInjector lllllllllllllllllIIlllIIlIIllIlI;
        if (!lllllllllllllllllIIlllIIlIIllIlI.isStatic) {
            lllllllllllllllllIIlllIIlIIlllII.insns.add(new VarInsnNode(25, 0));
        }
        lllllllllllllllllIIlllIIlIIlllII.insns.add(new VarInsnNode(lllllllllllllllllIIlllIIlIIllIlI.returnType.getOpcode(21), lllllllllllllllllIIlllIIlIIllIII));
        lllllllllllllllllIIlllIIlIIllIlI.invokeHandler(lllllllllllllllllIIlllIIlIIlllII.insns);
        lllllllllllllllllIIlllIIlIIlllII.insns.add(new VarInsnNode(lllllllllllllllllIIlllIIlIIllIlI.returnType.getOpcode(54), lllllllllllllllllIIlllIIlIIllIII));
    }

    private void printLocals(Context lllllllllllllllllIIlllIIlIlIIlIl) {
        ModifyVariableInjector lllllllllllllllllIIlllIIlIlIIIll;
        SignaturePrinter lllllllllllllllllIIlllIIlIlIIlII = new SignaturePrinter(lllllllllllllllllIIlllIIlIlIIIll.methodNode.name, lllllllllllllllllIIlllIIlIlIIIll.returnType, lllllllllllllllllIIlllIIlIlIIIll.methodArgs, new String[]{"var"});
        lllllllllllllllllIIlllIIlIlIIlII.setModifiers(lllllllllllllllllIIlllIIlIlIIIll.methodNode);
        new PrettyPrinter().kvWidth(20).kv("Target Class", lllllllllllllllllIIlllIIlIlIIIll.classNode.name.replace('/', '.')).kv("Target Method", lllllllllllllllllIIlllIIlIlIIlIl.target.method.name).kv("Callback Name", lllllllllllllllllIIlllIIlIlIIIll.methodNode.name).kv("Capture Type", SignaturePrinter.getTypeName(lllllllllllllllllIIlllIIlIlIIIll.returnType, false)).kv("Instruction", "%s %s", lllllllllllllllllIIlllIIlIlIIlIl.node.getClass().getSimpleName(), Bytecode.getOpcodeName(lllllllllllllllllIIlllIIlIlIIlIl.node.getOpcode())).hr().kv("Match mode", lllllllllllllllllIIlllIIlIlIIIll.discriminator.isImplicit(lllllllllllllllllIIlllIIlIlIIlIl) ? "IMPLICIT (match single)" : "EXPLICIT (match by criteria)").kv("Match ordinal", lllllllllllllllllIIlllIIlIlIIIll.discriminator.getOrdinal() < 0 ? "any" : Integer.valueOf(lllllllllllllllllIIlllIIlIlIIIll.discriminator.getOrdinal())).kv("Match index", lllllllllllllllllIIlllIIlIlIIIll.discriminator.getIndex() < lllllllllllllllllIIlllIIlIlIIlIl.baseArgIndex ? "any" : Integer.valueOf(lllllllllllllllllIIlllIIlIlIIIll.discriminator.getIndex())).kv("Match name(s)", lllllllllllllllllIIlllIIlIlIIIll.discriminator.hasNames() ? lllllllllllllllllIIlllIIlIlIIIll.discriminator.getNames() : "any").kv("Args only", lllllllllllllllllIIlllIIlIlIIIll.discriminator.isArgsOnly()).hr().add(lllllllllllllllllIIlllIIlIlIIlIl).print(System.err);
    }

    @Override
    protected void sanityCheck(Target lllllllllllllllllIIlllIIllIIIIII, List<InjectionPoint> lllllllllllllllllIIlllIIlIlllIll) {
        ModifyVariableInjector lllllllllllllllllIIlllIIlIllllIl;
        super.sanityCheck(lllllllllllllllllIIlllIIllIIIIII, lllllllllllllllllIIlllIIlIlllIll);
        if (lllllllllllllllllIIlllIIllIIIIII.isStatic != lllllllllllllllllIIlllIIlIllllIl.isStatic) {
            throw new InvalidInjectionException(lllllllllllllllllIIlllIIlIllllIl.info, String.valueOf(new StringBuilder().append("'static' of variable modifier method does not match target in ").append(lllllllllllllllllIIlllIIlIllllIl)));
        }
        int lllllllllllllllllIIlllIIlIlllllI = lllllllllllllllllIIlllIIlIllllIl.discriminator.getOrdinal();
        if (lllllllllllllllllIIlllIIlIlllllI < -1) {
            throw new InvalidInjectionException(lllllllllllllllllIIlllIIlIllllIl.info, String.valueOf(new StringBuilder().append("Invalid ordinal ").append(lllllllllllllllllIIlllIIlIlllllI).append(" specified in ").append(lllllllllllllllllIIlllIIlIllllIl)));
        }
        if (lllllllllllllllllIIlllIIlIllllIl.discriminator.getIndex() == 0 && !lllllllllllllllllIIlllIIlIllllIl.isStatic) {
            throw new InvalidInjectionException(lllllllllllllllllIIlllIIlIllllIl.info, String.valueOf(new StringBuilder().append("Invalid index 0 specified in non-static variable modifier ").append(lllllllllllllllllIIlllIIlIllllIl)));
        }
    }

    @Override
    protected boolean findTargetNodes(MethodNode lllllllllllllllllIIlllIIllIIlIlI, InjectionPoint lllllllllllllllllIIlllIIllIIlIIl, InsnList lllllllllllllllllIIlllIIllIIllIl, Collection<AbstractInsnNode> lllllllllllllllllIIlllIIllIIllII) {
        if (lllllllllllllllllIIlllIIllIIlIIl instanceof ContextualInjectionPoint) {
            ModifyVariableInjector lllllllllllllllllIIlllIIllIlIIII;
            Target lllllllllllllllllIIlllIIllIlIIIl = lllllllllllllllllIIlllIIllIlIIII.info.getContext().getTargetMethod(lllllllllllllllllIIlllIIllIIlIlI);
            return ((ContextualInjectionPoint)lllllllllllllllllIIlllIIllIIlIIl).find(lllllllllllllllllIIlllIIllIlIIIl, lllllllllllllllllIIlllIIllIIllII);
        }
        return lllllllllllllllllIIlllIIllIIlIIl.find(lllllllllllllllllIIlllIIllIIlIlI.desc, lllllllllllllllllIIlllIIllIIllIl, lllllllllllllllllIIlllIIllIIllII);
    }

    @Override
    protected void inject(Target lllllllllllllllllIIlllIIlIlIllIl, InjectionNodes.InjectionNode lllllllllllllllllIIlllIIlIllIIII) {
        ModifyVariableInjector lllllllllllllllllIIlllIIlIlIlllI;
        if (lllllllllllllllllIIlllIIlIllIIII.isReplaced()) {
            throw new InvalidInjectionException(lllllllllllllllllIIlllIIlIlIlllI.info, String.valueOf(new StringBuilder().append("Variable modifier target for ").append(lllllllllllllllllIIlllIIlIlIlllI).append(" was removed by another injector")));
        }
        Context lllllllllllllllllIIlllIIlIlIllll = new Context(lllllllllllllllllIIlllIIlIlIlllI.returnType, lllllllllllllllllIIlllIIlIlIlllI.discriminator.isArgsOnly(), lllllllllllllllllIIlllIIlIlIllIl, lllllllllllllllllIIlllIIlIllIIII.getCurrentTarget());
        if (lllllllllllllllllIIlllIIlIlIlllI.discriminator.printLVT()) {
            lllllllllllllllllIIlllIIlIlIlllI.printLocals(lllllllllllllllllIIlllIIlIlIllll);
        }
        try {
            int lllllllllllllllllIIlllIIlIllIlII = lllllllllllllllllIIlllIIlIlIlllI.discriminator.findLocal(lllllllllllllllllIIlllIIlIlIllll);
            if (lllllllllllllllllIIlllIIlIllIlII > -1) {
                lllllllllllllllllIIlllIIlIlIlllI.inject(lllllllllllllllllIIlllIIlIlIllll, lllllllllllllllllIIlllIIlIllIlII);
            }
        }
        catch (InvalidImplicitDiscriminatorException lllllllllllllllllIIlllIIlIllIIll) {
            if (lllllllllllllllllIIlllIIlIlIlllI.discriminator.printLVT()) {
                lllllllllllllllllIIlllIIlIlIlllI.info.addCallbackInvocation(lllllllllllllllllIIlllIIlIlIlllI.methodNode);
                return;
            }
            throw new InvalidInjectionException(lllllllllllllllllIIlllIIlIlIlllI.info, String.valueOf(new StringBuilder().append("Implicit variable modifier injection failed in ").append(lllllllllllllllllIIlllIIlIlIlllI)), (Throwable)lllllllllllllllllIIlllIIlIllIIll);
        }
        lllllllllllllllllIIlllIIlIlIllIl.insns.insertBefore(lllllllllllllllllIIlllIIlIlIllll.node, lllllllllllllllllIIlllIIlIlIllll.insns);
        lllllllllllllllllIIlllIIlIlIllIl.addToStack(lllllllllllllllllIIlllIIlIlIlllI.isStatic ? 1 : 2);
    }

    public ModifyVariableInjector(InjectionInfo lllllllllllllllllIIlllIIllIllIIl, LocalVariableDiscriminator lllllllllllllllllIIlllIIllIllIll) {
        super(lllllllllllllllllIIlllIIllIllIIl);
        ModifyVariableInjector lllllllllllllllllIIlllIIllIlllIl;
        lllllllllllllllllIIlllIIllIlllIl.discriminator = lllllllllllllllllIIlllIIllIllIll;
    }

    static abstract class ContextualInjectionPoint
    extends InjectionPoint {
        protected final /* synthetic */ IMixinContext context;

        abstract boolean find(Target var1, Collection<AbstractInsnNode> var2);

        @Override
        public boolean find(String llllllllllllllllIllIllIIIllIlIIl, InsnList llllllllllllllllIllIllIIIllIlIII, Collection<AbstractInsnNode> llllllllllllllllIllIllIIIllIIlll) {
            ContextualInjectionPoint llllllllllllllllIllIllIIIllIlIlI;
            throw new InvalidInjectionException(llllllllllllllllIllIllIIIllIlIlI.context, String.valueOf(new StringBuilder().append(llllllllllllllllIllIllIIIllIlIlI.getAtCode()).append(" injection point must be used in conjunction with @ModifyVariable")));
        }

        ContextualInjectionPoint(IMixinContext llllllllllllllllIllIllIIIllIlllI) {
            ContextualInjectionPoint llllllllllllllllIllIllIIIlllIlII;
            llllllllllllllllIllIllIIIlllIlII.context = llllllllllllllllIllIllIIIllIlllI;
        }
    }

    static class Context
    extends LocalVariableDiscriminator.Context {
        final /* synthetic */ InsnList insns;

        public Context(Type llllllllllllllllIlIllIIllIIIIlII, boolean llllllllllllllllIlIllIIlIllllllI, Target llllllllllllllllIlIllIIllIIIIIlI, AbstractInsnNode llllllllllllllllIlIllIIlIlllllII) {
            super(llllllllllllllllIlIllIIllIIIIlII, llllllllllllllllIlIllIIlIllllllI, llllllllllllllllIlIllIIllIIIIIlI, llllllllllllllllIlIllIIlIlllllII);
            Context llllllllllllllllIlIllIIllIIIIlIl;
            llllllllllllllllIlIllIIllIIIIlIl.insns = new InsnList();
        }
    }
}

