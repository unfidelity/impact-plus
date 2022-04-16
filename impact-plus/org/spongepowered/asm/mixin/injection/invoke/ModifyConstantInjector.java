/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.invoke.RedirectInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Bytecode;

public class ModifyConstantInjector
extends RedirectInjector {
    private static final /* synthetic */ int OPCODE_OFFSET;

    static {
        OPCODE_OFFSET = 6;
    }

    private AbstractInsnNode invokeConstantHandler(Type llllllllllllllllllllIlIllllIlIll, Target llllllllllllllllllllIlIllllIIIll, InsnList llllllllllllllllllllIlIllllIIIlI, InsnList llllllllllllllllllllIlIllllIIIIl) {
        ModifyConstantInjector llllllllllllllllllllIlIllllIIlIl;
        String llllllllllllllllllllIlIllllIIlll = Bytecode.generateDescriptor(llllllllllllllllllllIlIllllIlIll, llllllllllllllllllllIlIllllIlIll);
        boolean llllllllllllllllllllIlIllllIIllI = llllllllllllllllllllIlIllllIIlIl.checkDescriptor(llllllllllllllllllllIlIllllIIlll, llllllllllllllllllllIlIllllIIIll, "getter");
        if (!llllllllllllllllllllIlIllllIIlIl.isStatic) {
            llllllllllllllllllllIlIllllIIIlI.insert(new VarInsnNode(25, 0));
            llllllllllllllllllllIlIllllIIIll.addToStack(1);
        }
        if (llllllllllllllllllllIlIllllIIllI) {
            llllllllllllllllllllIlIllllIIlIl.pushArgs(llllllllllllllllllllIlIllllIIIll.arguments, llllllllllllllllllllIlIllllIIIIl, llllllllllllllllllllIlIllllIIIll.getArgIndices(), 0, llllllllllllllllllllIlIllllIIIll.arguments.length);
            llllllllllllllllllllIlIllllIIIll.addToStack(Bytecode.getArgsSize(llllllllllllllllllllIlIllllIIIll.arguments));
        }
        return llllllllllllllllllllIlIllllIIlIl.invokeHandler(llllllllllllllllllllIlIllllIIIIl);
    }

    private void injectExpandedConstantModifier(Target llllllllllllllllllllIllIIIIlIIll, JumpInsnNode llllllllllllllllllllIllIIIIlIIlI) {
        ModifyConstantInjector llllllllllllllllllllIllIIIIlIlII;
        int llllllllllllllllllllIllIIIIlIIIl = llllllllllllllllllllIllIIIIlIIlI.getOpcode();
        if (llllllllllllllllllllIllIIIIlIIIl < 155 || llllllllllllllllllllIllIIIIlIIIl > 158) {
            throw new InvalidInjectionException(llllllllllllllllllllIllIIIIlIlII.info, String.valueOf(new StringBuilder().append(llllllllllllllllllllIllIIIIlIlII.annotationType).append(" annotation selected an invalid opcode ").append(Bytecode.getOpcodeName(llllllllllllllllllllIllIIIIlIIIl)).append(" in ").append(llllllllllllllllllllIllIIIIlIIll).append(" in ").append(llllllllllllllllllllIllIIIIlIlII)));
        }
        InsnList llllllllllllllllllllIllIIIIlIIII = new InsnList();
        llllllllllllllllllllIllIIIIlIIII.add(new InsnNode(3));
        AbstractInsnNode llllllllllllllllllllIllIIIIIllll = llllllllllllllllllllIllIIIIlIlII.invokeConstantHandler(Type.getType("I"), llllllllllllllllllllIllIIIIlIIll, llllllllllllllllllllIllIIIIlIIII, llllllllllllllllllllIllIIIIlIIII);
        llllllllllllllllllllIllIIIIlIIII.add(new JumpInsnNode(llllllllllllllllllllIllIIIIlIIIl + 6, llllllllllllllllllllIllIIIIlIIlI.label));
        llllllllllllllllllllIllIIIIlIIll.replaceNode(llllllllllllllllllllIllIIIIlIIlI, llllllllllllllllllllIllIIIIIllll, llllllllllllllllllllIllIIIIlIIII);
        llllllllllllllllllllIllIIIIlIIll.addToStack(1);
    }

    @Override
    protected void inject(Target llllllllllllllllllllIllIIIIlllIl, InjectionNodes.InjectionNode llllllllllllllllllllIllIIIlIIIII) {
        ModifyConstantInjector llllllllllllllllllllIllIIIIllllI;
        if (!llllllllllllllllllllIllIIIIllllI.preInject(llllllllllllllllllllIllIIIlIIIII)) {
            return;
        }
        if (llllllllllllllllllllIllIIIlIIIII.isReplaced()) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Target failure for ").append(llllllllllllllllllllIllIIIIllllI.info)));
        }
        AbstractInsnNode llllllllllllllllllllIllIIIIlllll = llllllllllllllllllllIllIIIlIIIII.getCurrentTarget();
        if (llllllllllllllllllllIllIIIIlllll instanceof JumpInsnNode) {
            llllllllllllllllllllIllIIIIllllI.checkTargetModifiers(llllllllllllllllllllIllIIIIlllIl, false);
            llllllllllllllllllllIllIIIIllllI.injectExpandedConstantModifier(llllllllllllllllllllIllIIIIlllIl, (JumpInsnNode)llllllllllllllllllllIllIIIIlllll);
            return;
        }
        if (Bytecode.isConstant(llllllllllllllllllllIllIIIIlllll)) {
            llllllllllllllllllllIllIIIIllllI.checkTargetModifiers(llllllllllllllllllllIllIIIIlllIl, false);
            llllllllllllllllllllIllIIIIllllI.injectConstantModifier(llllllllllllllllllllIllIIIIlllIl, llllllllllllllllllllIllIIIIlllll);
            return;
        }
        throw new InvalidInjectionException(llllllllllllllllllllIllIIIIllllI.info, String.valueOf(new StringBuilder().append(llllllllllllllllllllIllIIIIllllI.annotationType).append(" annotation is targetting an invalid insn in ").append(llllllllllllllllllllIllIIIIlllIl).append(" in ").append(llllllllllllllllllllIllIIIIllllI)));
    }

    private void injectConstantModifier(Target llllllllllllllllllllIllIIIIIIIII, AbstractInsnNode llllllllllllllllllllIlIlllllllll) {
        ModifyConstantInjector llllllllllllllllllllIllIIIIIIIIl;
        Type llllllllllllllllllllIlIllllllllI = Bytecode.getConstantType(llllllllllllllllllllIlIlllllllll);
        InsnList llllllllllllllllllllIlIlllllllIl = new InsnList();
        InsnList llllllllllllllllllllIlIlllllllII = new InsnList();
        AbstractInsnNode llllllllllllllllllllIlIllllllIll = llllllllllllllllllllIllIIIIIIIIl.invokeConstantHandler(llllllllllllllllllllIlIllllllllI, llllllllllllllllllllIllIIIIIIIII, llllllllllllllllllllIlIlllllllIl, llllllllllllllllllllIlIlllllllII);
        llllllllllllllllllllIllIIIIIIIII.wrapNode(llllllllllllllllllllIlIlllllllll, llllllllllllllllllllIlIllllllIll, llllllllllllllllllllIlIlllllllIl, llllllllllllllllllllIlIlllllllII);
    }

    public ModifyConstantInjector(InjectionInfo llllllllllllllllllllIllIIIlIlIIl) {
        super(llllllllllllllllllllIllIIIlIlIIl, "@ModifyConstant");
        ModifyConstantInjector llllllllllllllllllllIllIIIlIlIII;
    }
}

