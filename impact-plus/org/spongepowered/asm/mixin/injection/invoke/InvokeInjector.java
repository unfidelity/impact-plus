/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke;

import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;

public abstract class InvokeInjector
extends Injector {
    protected final /* synthetic */ String annotationType;

    protected final void checkTargetModifiers(Target llllllllllllllllIIllIlIIlIIIllll, boolean llllllllllllllllIIllIlIIlIIIlllI) {
        InvokeInjector llllllllllllllllIIllIlIIlIIlIIII;
        if (llllllllllllllllIIllIlIIlIIIlllI && llllllllllllllllIIllIlIIlIIIllll.isStatic != llllllllllllllllIIllIlIIlIIlIIII.isStatic) {
            throw new InvalidInjectionException(llllllllllllllllIIllIlIIlIIlIIII.info, String.valueOf(new StringBuilder().append("'static' modifier of handler method does not match target in ").append(llllllllllllllllIIllIlIIlIIlIIII)));
        }
        if (!llllllllllllllllIIllIlIIlIIIlllI && !llllllllllllllllIIllIlIIlIIlIIII.isStatic && llllllllllllllllIIllIlIIlIIIllll.isStatic) {
            throw new InvalidInjectionException(llllllllllllllllIIllIlIIlIIlIIII.info, String.valueOf(new StringBuilder().append("non-static callback method ").append(llllllllllllllllIIllIlIIlIIlIIII).append(" targets a static method which is not supported")));
        }
    }

    protected int[] storeArgs(Target llllllllllllllllIIllIlIIIlIIllIl, Type[] llllllllllllllllIIllIlIIIlIIIllI, InsnList llllllllllllllllIIllIlIIIlIIIlIl, int llllllllllllllllIIllIlIIIlIIlIlI) {
        InvokeInjector llllllllllllllllIIllIlIIIlIIlIII;
        int[] llllllllllllllllIIllIlIIIlIIlIIl = llllllllllllllllIIllIlIIIlIIllIl.generateArgMap(llllllllllllllllIIllIlIIIlIIIllI, llllllllllllllllIIllIlIIIlIIlIlI);
        llllllllllllllllIIllIlIIIlIIlIII.storeArgs(llllllllllllllllIIllIlIIIlIIIllI, llllllllllllllllIIllIlIIIlIIIlIl, llllllllllllllllIIllIlIIIlIIlIIl, llllllllllllllllIIllIlIIIlIIlIlI, llllllllllllllllIIllIlIIIlIIIllI.length);
        return llllllllllllllllIIllIlIIIlIIlIIl;
    }

    protected abstract void injectAtInvoke(Target var1, InjectionNodes.InjectionNode var2);

    protected void checkTarget(Target llllllllllllllllIIllIlIIlIIlIlll) {
        InvokeInjector llllllllllllllllIIllIlIIlIIllIII;
        llllllllllllllllIIllIlIIlIIllIII.checkTargetModifiers(llllllllllllllllIIllIlIIlIIlIlll, true);
    }

    public InvokeInjector(InjectionInfo llllllllllllllllIIllIlIIlIlIlIlI, String llllllllllllllllIIllIlIIlIlIlIIl) {
        super(llllllllllllllllIIllIlIIlIlIlIlI);
        InvokeInjector llllllllllllllllIIllIlIIlIlIlIll;
        llllllllllllllllIIllIlIIlIlIlIll.annotationType = llllllllllllllllIIllIlIIlIlIlIIl;
    }

    protected AbstractInsnNode invokeHandlerWithArgs(Type[] llllllllllllllllIIllIlIIIllIllIl, InsnList llllllllllllllllIIllIlIIIllIlIII, int[] llllllllllllllllIIllIlIIIllIIlll) {
        InvokeInjector llllllllllllllllIIllIlIIIllIlllI;
        return llllllllllllllllIIllIlIIIllIlllI.invokeHandlerWithArgs(llllllllllllllllIIllIlIIIllIllIl, llllllllllllllllIIllIlIIIllIlIII, llllllllllllllllIIllIlIIIllIIlll, 0, llllllllllllllllIIllIlIIIllIllIl.length);
    }

    protected void storeArgs(Type[] llllllllllllllllIIllIlIIIIlllIlI, InsnList llllllllllllllllIIllIlIIIIlllIIl, int[] llllllllllllllllIIllIlIIIIlllIII, int llllllllllllllllIIllIlIIIIllIlll, int llllllllllllllllIIllIlIIIIllIIIl) {
        for (int llllllllllllllllIIllIlIIIIllllII = llllllllllllllllIIllIlIIIIllIIIl - 1; llllllllllllllllIIllIlIIIIllllII >= llllllllllllllllIIllIlIIIIllIlll; --llllllllllllllllIIllIlIIIIllllII) {
            llllllllllllllllIIllIlIIIIlllIIl.add(new VarInsnNode(llllllllllllllllIIllIlIIIIlllIlI[llllllllllllllllIIllIlIIIIllllII].getOpcode(54), llllllllllllllllIIllIlIIIIlllIII[llllllllllllllllIIllIlIIIIllllII]));
        }
    }

    protected void pushArgs(Type[] llllllllllllllllIIllIlIIIIlIIIlI, InsnList llllllllllllllllIIllIlIIIIlIIllI, int[] llllllllllllllllIIllIlIIIIlIIlIl, int llllllllllllllllIIllIlIIIIlIIlII, int llllllllllllllllIIllIlIIIIIllllI) {
        for (int llllllllllllllllIIllIlIIIIlIlIIl = llllllllllllllllIIllIlIIIIlIIlII; llllllllllllllllIIllIlIIIIlIlIIl < llllllllllllllllIIllIlIIIIIllllI; ++llllllllllllllllIIllIlIIIIlIlIIl) {
            llllllllllllllllIIllIlIIIIlIIllI.add(new VarInsnNode(llllllllllllllllIIllIlIIIIlIIIlI[llllllllllllllllIIllIlIIIIlIlIIl].getOpcode(21), llllllllllllllllIIllIlIIIIlIIlIl[llllllllllllllllIIllIlIIIIlIlIIl]));
        }
    }

    protected AbstractInsnNode invokeHandlerWithArgs(Type[] llllllllllllllllIIllIlIIIlIllIIl, InsnList llllllllllllllllIIllIlIIIlIllllI, int[] llllllllllllllllIIllIlIIIlIlIlll, int llllllllllllllllIIllIlIIIlIlIllI, int llllllllllllllllIIllIlIIIlIlIlIl) {
        InvokeInjector llllllllllllllllIIllIlIIIlIllIlI;
        if (!llllllllllllllllIIllIlIIIlIllIlI.isStatic) {
            llllllllllllllllIIllIlIIIlIllllI.add(new VarInsnNode(25, 0));
        }
        llllllllllllllllIIllIlIIIlIllIlI.pushArgs(llllllllllllllllIIllIlIIIlIllIIl, llllllllllllllllIIllIlIIIlIllllI, llllllllllllllllIIllIlIIIlIlIlll, llllllllllllllllIIllIlIIIlIlIllI, llllllllllllllllIIllIlIIIlIlIlIl);
        return llllllllllllllllIIllIlIIIlIllIlI.invokeHandler(llllllllllllllllIIllIlIIIlIllllI);
    }

    @Override
    protected void inject(Target llllllllllllllllIIllIlIIIlllIlII, InjectionNodes.InjectionNode llllllllllllllllIIllIlIIIlllIllI) {
        InvokeInjector llllllllllllllllIIllIlIIIlllIlIl;
        if (!(llllllllllllllllIIllIlIIIlllIllI.getCurrentTarget() instanceof MethodInsnNode)) {
            throw new InvalidInjectionException(llllllllllllllllIIllIlIIIlllIlIl.info, String.valueOf(new StringBuilder().append(llllllllllllllllIIllIlIIIlllIlIl.annotationType).append(" annotation on is targetting a non-method insn in ").append(llllllllllllllllIIllIlIIIlllIlII).append(" in ").append(llllllllllllllllIIllIlIIIlllIlIl)));
        }
        llllllllllllllllIIllIlIIIlllIlIl.injectAtInvoke(llllllllllllllllIIllIlIIIlllIlII, llllllllllllllllIIllIlIIIlllIllI);
    }

    @Override
    protected void sanityCheck(Target llllllllllllllllIIllIlIIlIlIIIIl, List<InjectionPoint> llllllllllllllllIIllIlIIlIlIIIII) {
        InvokeInjector llllllllllllllllIIllIlIIlIlIIIlI;
        super.sanityCheck(llllllllllllllllIIllIlIIlIlIIIIl, llllllllllllllllIIllIlIIlIlIIIII);
        llllllllllllllllIIllIlIIlIlIIIlI.checkTarget(llllllllllllllllIIllIlIIlIlIIIIl);
    }

    protected void checkTargetForNode(Target llllllllllllllllIIllIlIIlIIIIIll, InjectionNodes.InjectionNode llllllllllllllllIIllIlIIIlllllll) {
        InvokeInjector llllllllllllllllIIllIlIIlIIIIIIl;
        if (llllllllllllllllIIllIlIIlIIIIIll.isCtor) {
            MethodInsnNode llllllllllllllllIIllIlIIlIIIIlll = llllllllllllllllIIllIlIIlIIIIIll.findSuperInitNode();
            int llllllllllllllllIIllIlIIlIIIIllI = llllllllllllllllIIllIlIIlIIIIIll.indexOf(llllllllllllllllIIllIlIIlIIIIlll);
            int llllllllllllllllIIllIlIIlIIIIlIl = llllllllllllllllIIllIlIIlIIIIIll.indexOf(llllllllllllllllIIllIlIIIlllllll.getCurrentTarget());
            if (llllllllllllllllIIllIlIIlIIIIlIl <= llllllllllllllllIIllIlIIlIIIIllI) {
                if (!llllllllllllllllIIllIlIIlIIIIIIl.isStatic) {
                    throw new InvalidInjectionException(llllllllllllllllIIllIlIIlIIIIIIl.info, String.valueOf(new StringBuilder().append("Pre-super ").append(llllllllllllllllIIllIlIIlIIIIIIl.annotationType).append(" invocation must be static in ").append(llllllllllllllllIIllIlIIlIIIIIIl)));
                }
                return;
            }
        }
        llllllllllllllllIIllIlIIlIIIIIIl.checkTargetModifiers(llllllllllllllllIIllIlIIlIIIIIll, true);
    }
}

