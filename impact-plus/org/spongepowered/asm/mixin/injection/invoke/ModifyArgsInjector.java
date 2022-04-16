/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.invoke.InvokeInjector;
import org.spongepowered.asm.mixin.injection.invoke.arg.ArgsClassGenerator;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Bytecode;

public class ModifyArgsInjector
extends InvokeInjector {
    private final /* synthetic */ ArgsClassGenerator argsClassGenerator;

    private void packArgs(InsnList lllllllllllllllIllIlllIIlIIIIIIl, String lllllllllllllllIllIlllIIIllllIll, MethodInsnNode lllllllllllllllIllIlllIIIlllllll) {
        ModifyArgsInjector lllllllllllllllIllIlllIIIlllllIl;
        String lllllllllllllllIllIlllIIIllllllI = Bytecode.changeDescriptorReturnType(lllllllllllllllIllIlllIIIlllllll.desc, String.valueOf(new StringBuilder().append("L").append(lllllllllllllllIllIlllIIIllllIll).append(";")));
        lllllllllllllllIllIlllIIlIIIIIIl.add(new MethodInsnNode(184, lllllllllllllllIllIlllIIIllllIll, "of", lllllllllllllllIllIlllIIIllllllI, false));
        lllllllllllllllIllIlllIIlIIIIIIl.add(new InsnNode(89));
        if (!lllllllllllllllIllIlllIIIlllllIl.isStatic) {
            lllllllllllllllIllIlllIIlIIIIIIl.add(new VarInsnNode(25, 0));
            lllllllllllllllIllIlllIIlIIIIIIl.add(new InsnNode(95));
        }
    }

    @Override
    protected void checkTarget(Target lllllllllllllllIllIlllIIlIlllIlI) {
        ModifyArgsInjector lllllllllllllllIllIlllIIlIlllIIl;
        lllllllllllllllIllIlllIIlIlllIIl.checkTargetModifiers(lllllllllllllllIllIlllIIlIlllIlI, false);
    }

    public ModifyArgsInjector(InjectionInfo lllllllllllllllIllIlllIIlIlllllI) {
        super(lllllllllllllllIllIlllIIlIlllllI, "@ModifyArgs");
        ModifyArgsInjector lllllllllllllllIllIlllIIlIllllll;
        lllllllllllllllIllIlllIIlIllllll.argsClassGenerator = (ArgsClassGenerator)lllllllllllllllIllIlllIIlIlllllI.getContext().getExtensions().getGenerator(ArgsClassGenerator.class);
    }

    @Override
    protected void inject(Target lllllllllllllllIllIlllIIlIllIIll, InjectionNodes.InjectionNode lllllllllllllllIllIlllIIlIlIllll) {
        ModifyArgsInjector lllllllllllllllIllIlllIIlIllIlII;
        lllllllllllllllIllIlllIIlIllIlII.checkTargetForNode(lllllllllllllllIllIlllIIlIllIIll, lllllllllllllllIllIlllIIlIlIllll);
        super.inject(lllllllllllllllIllIlllIIlIllIIll, lllllllllllllllIllIlllIIlIlIllll);
    }

    private void unpackArgs(InsnList lllllllllllllllIllIlllIIIllIllll, String lllllllllllllllIllIlllIIIllIlllI, Type[] lllllllllllllllIllIlllIIIllIllIl) {
        for (int lllllllllllllllIllIlllIIIlllIlII = 0; lllllllllllllllIllIlllIIIlllIlII < lllllllllllllllIllIlllIIIllIllIl.length; ++lllllllllllllllIllIlllIIIlllIlII) {
            if (lllllllllllllllIllIlllIIIlllIlII < lllllllllllllllIllIlllIIIllIllIl.length - 1) {
                lllllllllllllllIllIlllIIIllIllll.add(new InsnNode(89));
            }
            lllllllllllllllIllIlllIIIllIllll.add(new MethodInsnNode(182, lllllllllllllllIllIlllIIIllIlllI, String.valueOf(new StringBuilder().append("$").append(lllllllllllllllIllIlllIIIlllIlII)), String.valueOf(new StringBuilder().append("()").append(lllllllllllllllIllIlllIIIllIllIl[lllllllllllllllIllIlllIIIlllIlII].getDescriptor())), false));
            if (lllllllllllllllIllIlllIIIlllIlII >= lllllllllllllllIllIlllIIIllIllIl.length - 1) continue;
            if (lllllllllllllllIllIlllIIIllIllIl[lllllllllllllllIllIlllIIIlllIlII].getSize() == 1) {
                lllllllllllllllIllIlllIIIllIllll.add(new InsnNode(95));
                continue;
            }
            lllllllllllllllIllIlllIIIllIllll.add(new InsnNode(93));
            lllllllllllllllIllIlllIIIllIllll.add(new InsnNode(88));
        }
    }

    @Override
    protected void injectAtInvoke(Target lllllllllllllllIllIlllIIlIlIIlIl, InjectionNodes.InjectionNode lllllllllllllllIllIlllIIlIlIIlII) {
        ModifyArgsInjector lllllllllllllllIllIlllIIlIIllllI;
        MethodInsnNode lllllllllllllllIllIlllIIlIlIIIll = (MethodInsnNode)lllllllllllllllIllIlllIIlIlIIlII.getCurrentTarget();
        Type[] lllllllllllllllIllIlllIIlIlIIIlI = Type.getArgumentTypes(lllllllllllllllIllIlllIIlIlIIIll.desc);
        if (lllllllllllllllIllIlllIIlIlIIIlI.length == 0) {
            throw new InvalidInjectionException(lllllllllllllllIllIlllIIlIIllllI.info, String.valueOf(new StringBuilder().append("@ModifyArgs injector ").append(lllllllllllllllIllIlllIIlIIllllI).append(" targets a method invocation ").append(lllllllllllllllIllIlllIIlIlIIIll.name).append(lllllllllllllllIllIlllIIlIlIIIll.desc).append(" with no arguments!")));
        }
        String lllllllllllllllIllIlllIIlIlIIIIl = lllllllllllllllIllIlllIIlIIllllI.argsClassGenerator.getClassRef(lllllllllllllllIllIlllIIlIlIIIll.desc);
        boolean lllllllllllllllIllIlllIIlIlIIIII = lllllllllllllllIllIlllIIlIIllllI.verifyTarget(lllllllllllllllIllIlllIIlIlIIlIl);
        InsnList lllllllllllllllIllIlllIIlIIlllll = new InsnList();
        lllllllllllllllIllIlllIIlIlIIlIl.addToStack(1);
        lllllllllllllllIllIlllIIlIIllllI.packArgs(lllllllllllllllIllIlllIIlIIlllll, lllllllllllllllIllIlllIIlIlIIIIl, lllllllllllllllIllIlllIIlIlIIIll);
        if (lllllllllllllllIllIlllIIlIlIIIII) {
            lllllllllllllllIllIlllIIlIlIIlIl.addToStack(Bytecode.getArgsSize(lllllllllllllllIllIlllIIlIlIIlIl.arguments));
            Bytecode.loadArgs(lllllllllllllllIllIlllIIlIlIIlIl.arguments, lllllllllllllllIllIlllIIlIIlllll, lllllllllllllllIllIlllIIlIlIIlIl.isStatic ? 0 : 1);
        }
        lllllllllllllllIllIlllIIlIIllllI.invokeHandler(lllllllllllllllIllIlllIIlIIlllll);
        lllllllllllllllIllIlllIIlIIllllI.unpackArgs(lllllllllllllllIllIlllIIlIIlllll, lllllllllllllllIllIlllIIlIlIIIIl, lllllllllllllllIllIlllIIlIlIIIlI);
        lllllllllllllllIllIlllIIlIlIIlIl.insns.insertBefore((AbstractInsnNode)lllllllllllllllIllIlllIIlIlIIIll, lllllllllllllllIllIlllIIlIIlllll);
    }

    private boolean verifyTarget(Target lllllllllllllllIllIlllIIlIIIlIll) {
        ModifyArgsInjector lllllllllllllllIllIlllIIlIIIllll;
        String lllllllllllllllIllIlllIIlIIIllIl = String.format("(L%s;)V", ArgsClassGenerator.ARGS_REF);
        if (!lllllllllllllllIllIlllIIlIIIllll.methodNode.desc.equals(lllllllllllllllIllIlllIIlIIIllIl)) {
            String lllllllllllllllIllIlllIIlIIlIIIl = Bytecode.changeDescriptorReturnType(lllllllllllllllIllIlllIIlIIIlIll.method.desc, "V");
            String lllllllllllllllIllIlllIIlIIlIIII = String.format("(L%s;%s", ArgsClassGenerator.ARGS_REF, lllllllllllllllIllIlllIIlIIlIIIl.substring(1));
            if (lllllllllllllllIllIlllIIlIIIllll.methodNode.desc.equals(lllllllllllllllIllIlllIIlIIlIIII)) {
                return true;
            }
            throw new InvalidInjectionException(lllllllllllllllIllIlllIIlIIIllll.info, String.valueOf(new StringBuilder().append("@ModifyArgs injector ").append(lllllllllllllllIllIlllIIlIIIllll).append(" has an invalid signature ").append(lllllllllllllllIllIlllIIlIIIllll.methodNode.desc).append(", expected ").append(lllllllllllllllIllIlllIIlIIIllIl).append(" or ").append(lllllllllllllllIllIlllIIlIIlIIII)));
        }
        return false;
    }
}

