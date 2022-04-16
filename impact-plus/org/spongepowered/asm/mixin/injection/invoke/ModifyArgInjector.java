/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke;

import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.invoke.InvokeInjector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Bytecode;

public class ModifyArgInjector
extends InvokeInjector {
    private final /* synthetic */ boolean singleArgMode;
    private final /* synthetic */ int index;

    public ModifyArgInjector(InjectionInfo llllllllllllllllIllIllllllIlIIll, int llllllllllllllllIllIllllllIlIIlI) {
        super(llllllllllllllllIllIllllllIlIIll, "@ModifyArg");
        ModifyArgInjector llllllllllllllllIllIllllllIlIlII;
        llllllllllllllllIllIllllllIlIlII.index = llllllllllllllllIllIllllllIlIIlI;
        llllllllllllllllIllIllllllIlIlII.singleArgMode = llllllllllllllllIllIllllllIlIlII.methodArgs.length == 1;
    }

    private int injectSingleArgHandler(Target llllllllllllllllIllIlllllIIlIlll, Type[] llllllllllllllllIllIlllllIIlIllI, int llllllllllllllllIllIlllllIIlIlIl, InsnList llllllllllllllllIllIlllllIIIlllI) {
        ModifyArgInjector llllllllllllllllIllIlllllIIlIIlI;
        int[] llllllllllllllllIllIlllllIIlIIll = llllllllllllllllIllIlllllIIlIIlI.storeArgs(llllllllllllllllIllIlllllIIlIlll, llllllllllllllllIllIlllllIIlIllI, llllllllllllllllIllIlllllIIIlllI, llllllllllllllllIllIlllllIIlIlIl);
        llllllllllllllllIllIlllllIIlIIlI.invokeHandlerWithArgs(llllllllllllllllIllIlllllIIlIllI, llllllllllllllllIllIlllllIIIlllI, llllllllllllllllIllIlllllIIlIIll, llllllllllllllllIllIlllllIIlIlIl, llllllllllllllllIllIlllllIIlIlIl + 1);
        llllllllllllllllIllIlllllIIlIIlI.pushArgs(llllllllllllllllIllIlllllIIlIllI, llllllllllllllllIllIlllllIIIlllI, llllllllllllllllIllIlllllIIlIIll, llllllllllllllllIllIlllllIIlIlIl + 1, llllllllllllllllIllIlllllIIlIllI.length);
        return llllllllllllllllIllIlllllIIlIIll[llllllllllllllllIllIlllllIIlIIll.length - 1] - llllllllllllllllIllIlllllIIlIlll.getMaxLocals() + llllllllllllllllIllIlllllIIlIllI[llllllllllllllllIllIlllllIIlIllI.length - 1].getSize();
    }

    protected int findArgIndex(Target llllllllllllllllIllIllllIllIIIll, Type[] llllllllllllllllIllIllllIllIIllI) {
        ModifyArgInjector llllllllllllllllIllIllllIllIlIII;
        if (llllllllllllllllIllIllllIllIlIII.index > -1) {
            if (llllllllllllllllIllIllllIllIlIII.index >= llllllllllllllllIllIllllIllIIllI.length || !llllllllllllllllIllIllllIllIIllI[llllllllllllllllIllIllllIllIlIII.index].equals(llllllllllllllllIllIllllIllIlIII.returnType)) {
                throw new InvalidInjectionException(llllllllllllllllIllIllllIllIlIII.info, String.valueOf(new StringBuilder().append("Specified index ").append(llllllllllllllllIllIllllIllIlIII.index).append(" for @ModifyArg is invalid for args ").append(Bytecode.getDescriptor(llllllllllllllllIllIllllIllIIllI)).append(", expected ").append(llllllllllllllllIllIllllIllIlIII.returnType).append(" on ").append(llllllllllllllllIllIllllIllIlIII)));
            }
            return llllllllllllllllIllIllllIllIlIII.index;
        }
        int llllllllllllllllIllIllllIllIIlIl = -1;
        for (int llllllllllllllllIllIllllIllIlIIl = 0; llllllllllllllllIllIllllIllIlIIl < llllllllllllllllIllIllllIllIIllI.length; ++llllllllllllllllIllIllllIllIlIIl) {
            if (!llllllllllllllllIllIllllIllIIllI[llllllllllllllllIllIllllIllIlIIl].equals(llllllllllllllllIllIllllIllIlIII.returnType)) continue;
            if (llllllllllllllllIllIllllIllIIlIl != -1) {
                throw new InvalidInjectionException(llllllllllllllllIllIllllIllIlIII.info, String.valueOf(new StringBuilder().append("Found duplicate args with index [").append(llllllllllllllllIllIllllIllIIlIl).append(", ").append(llllllllllllllllIllIllllIllIlIIl).append("] matching type ").append(llllllllllllllllIllIllllIllIlIII.returnType).append(" for @ModifyArg target ").append(llllllllllllllllIllIllllIllIIIll).append(" in ").append(llllllllllllllllIllIllllIllIlIII).append(". Please specify index of desired arg.")));
            }
            llllllllllllllllIllIllllIllIIlIl = llllllllllllllllIllIllllIllIlIIl;
        }
        if (llllllllllllllllIllIllllIllIIlIl == -1) {
            throw new InvalidInjectionException(llllllllllllllllIllIllllIllIlIII.info, String.valueOf(new StringBuilder().append("Could not find arg matching type ").append(llllllllllllllllIllIllllIllIlIII.returnType).append(" for @ModifyArg target ").append(llllllllllllllllIllIllllIllIIIll).append(" in ").append(llllllllllllllllIllIllllIllIlIII)));
        }
        return llllllllllllllllIllIllllIllIIlIl;
    }

    private int injectMultiArgHandler(Target llllllllllllllllIllIlllllIIIIlIl, Type[] llllllllllllllllIllIlllllIIIIlII, int llllllllllllllllIllIlllllIIIIIll, InsnList llllllllllllllllIllIlllllIIIIIlI) {
        ModifyArgInjector llllllllllllllllIllIlllllIIIIIII;
        if (!Arrays.equals(llllllllllllllllIllIlllllIIIIlII, llllllllllllllllIllIlllllIIIIIII.methodArgs)) {
            throw new InvalidInjectionException(llllllllllllllllIllIlllllIIIIIII.info, String.valueOf(new StringBuilder().append("@ModifyArg method ").append(llllllllllllllllIllIlllllIIIIIII).append(" targets a method with an invalid signature ").append(Bytecode.getDescriptor(llllllllllllllllIllIlllllIIIIlII)).append(", expected ").append(Bytecode.getDescriptor(llllllllllllllllIllIlllllIIIIIII.methodArgs))));
        }
        int[] llllllllllllllllIllIlllllIIIIIIl = llllllllllllllllIllIlllllIIIIIII.storeArgs(llllllllllllllllIllIlllllIIIIlIl, llllllllllllllllIllIlllllIIIIlII, llllllllllllllllIllIlllllIIIIIlI, 0);
        llllllllllllllllIllIlllllIIIIIII.pushArgs(llllllllllllllllIllIlllllIIIIlII, llllllllllllllllIllIlllllIIIIIlI, llllllllllllllllIllIlllllIIIIIIl, 0, llllllllllllllllIllIlllllIIIIIll);
        llllllllllllllllIllIlllllIIIIIII.invokeHandlerWithArgs(llllllllllllllllIllIlllllIIIIlII, llllllllllllllllIllIlllllIIIIIlI, llllllllllllllllIllIlllllIIIIIIl, 0, llllllllllllllllIllIlllllIIIIlII.length);
        llllllllllllllllIllIlllllIIIIIII.pushArgs(llllllllllllllllIllIlllllIIIIlII, llllllllllllllllIllIlllllIIIIIlI, llllllllllllllllIllIlllllIIIIIIl, llllllllllllllllIllIlllllIIIIIll + 1, llllllllllllllllIllIlllllIIIIlII.length);
        return llllllllllllllllIllIlllllIIIIIIl[llllllllllllllllIllIlllllIIIIIIl.length - 1] - llllllllllllllllIllIlllllIIIIlIl.getMaxLocals() + llllllllllllllllIllIlllllIIIIlII[llllllllllllllllIllIlllllIIIIlII.length - 1].getSize();
    }

    @Override
    protected void inject(Target llllllllllllllllIllIlllllIlllIll, InjectionNodes.InjectionNode llllllllllllllllIllIlllllIllIlll) {
        ModifyArgInjector llllllllllllllllIllIlllllIllllII;
        llllllllllllllllIllIlllllIllllII.checkTargetForNode(llllllllllllllllIllIlllllIlllIll, llllllllllllllllIllIlllllIllIlll);
        super.inject(llllllllllllllllIllIlllllIlllIll, llllllllllllllllIllIlllllIllIlll);
    }

    @Override
    protected void sanityCheck(Target llllllllllllllllIllIllllllIIIlll, List<InjectionPoint> llllllllllllllllIllIllllllIIIllI) {
        ModifyArgInjector llllllllllllllllIllIllllllIIlIll;
        super.sanityCheck(llllllllllllllllIllIllllllIIIlll, llllllllllllllllIllIllllllIIIllI);
        if (llllllllllllllllIllIllllllIIlIll.singleArgMode && !llllllllllllllllIllIllllllIIlIll.methodArgs[0].equals(llllllllllllllllIllIllllllIIlIll.returnType)) {
            throw new InvalidInjectionException(llllllllllllllllIllIllllllIIlIll.info, String.valueOf(new StringBuilder().append("@ModifyArg return type on ").append(llllllllllllllllIllIllllllIIlIll).append(" must match the parameter type. ARG=").append(llllllllllllllllIllIllllllIIlIll.methodArgs[0]).append(" RETURN=").append(llllllllllllllllIllIllllllIIlIll.returnType)));
        }
    }

    @Override
    protected void checkTarget(Target llllllllllllllllIllIllllllIIIIlI) {
        ModifyArgInjector llllllllllllllllIllIllllllIIIIll;
        if (!llllllllllllllllIllIllllllIIIIll.isStatic && llllllllllllllllIllIllllllIIIIlI.isStatic) {
            throw new InvalidInjectionException(llllllllllllllllIllIllllllIIIIll.info, String.valueOf(new StringBuilder().append("non-static callback method ").append(llllllllllllllllIllIllllllIIIIll).append(" targets a static method which is not supported")));
        }
    }

    @Override
    protected void injectAtInvoke(Target llllllllllllllllIllIlllllIlIllIl, InjectionNodes.InjectionNode llllllllllllllllIllIlllllIlIIlII) {
        ModifyArgInjector llllllllllllllllIllIlllllIlIIllI;
        MethodInsnNode llllllllllllllllIllIlllllIlIlIll = (MethodInsnNode)llllllllllllllllIllIlllllIlIIlII.getCurrentTarget();
        Type[] llllllllllllllllIllIlllllIlIlIlI = Type.getArgumentTypes(llllllllllllllllIllIlllllIlIlIll.desc);
        int llllllllllllllllIllIlllllIlIlIIl = llllllllllllllllIllIlllllIlIIllI.findArgIndex(llllllllllllllllIllIlllllIlIllIl, llllllllllllllllIllIlllllIlIlIlI);
        InsnList llllllllllllllllIllIlllllIlIlIII = new InsnList();
        int llllllllllllllllIllIlllllIlIIlll = 0;
        llllllllllllllllIllIlllllIlIIlll = llllllllllllllllIllIlllllIlIIllI.singleArgMode ? llllllllllllllllIllIlllllIlIIllI.injectSingleArgHandler(llllllllllllllllIllIlllllIlIllIl, llllllllllllllllIllIlllllIlIlIlI, llllllllllllllllIllIlllllIlIlIIl, llllllllllllllllIllIlllllIlIlIII) : llllllllllllllllIllIlllllIlIIllI.injectMultiArgHandler(llllllllllllllllIllIlllllIlIllIl, llllllllllllllllIllIlllllIlIlIlI, llllllllllllllllIllIlllllIlIlIIl, llllllllllllllllIllIlllllIlIlIII);
        llllllllllllllllIllIlllllIlIllIl.insns.insertBefore((AbstractInsnNode)llllllllllllllllIllIlllllIlIlIll, llllllllllllllllIllIlllllIlIlIII);
        llllllllllllllllIllIlllllIlIllIl.addToLocals(llllllllllllllllIllIlllllIlIIlll);
        llllllllllllllllIllIlllllIlIllIl.addToStack(2 - (llllllllllllllllIllIlllllIlIIlll - 1));
    }
}

