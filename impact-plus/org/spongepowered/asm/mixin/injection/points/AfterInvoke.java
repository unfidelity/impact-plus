/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.points.BeforeInvoke;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

@InjectionPoint.AtCode(value="INVOKE_ASSIGN")
public class AfterInvoke
extends BeforeInvoke {
    @Override
    protected boolean addInsn(InsnList llllllllllllllllIlllllIlIllIIlll, Collection<AbstractInsnNode> llllllllllllllllIlllllIlIlIlIlll, AbstractInsnNode llllllllllllllllIlllllIlIlIlIIll) {
        MethodInsnNode llllllllllllllllIlllllIlIlIllllI = (MethodInsnNode)llllllllllllllllIlllllIlIlIlIIll;
        if (Type.getReturnType(llllllllllllllllIlllllIlIlIllllI.desc) == Type.VOID_TYPE) {
            return false;
        }
        if ((llllllllllllllllIlllllIlIlIlIIll = InjectionPoint.nextNode(llllllllllllllllIlllllIlIllIIlll, llllllllllllllllIlllllIlIlIlIIll)) instanceof VarInsnNode && llllllllllllllllIlllllIlIlIlIIll.getOpcode() >= 54) {
            llllllllllllllllIlllllIlIlIlIIll = InjectionPoint.nextNode(llllllllllllllllIlllllIlIllIIlll, llllllllllllllllIlllllIlIlIlIIll);
        }
        llllllllllllllllIlllllIlIlIlIlll.add(llllllllllllllllIlllllIlIlIlIIll);
        return true;
    }

    public AfterInvoke(InjectionPointData llllllllllllllllIlllllIllIllIllI) {
        super(llllllllllllllllIlllllIllIllIllI);
        AfterInvoke llllllllllllllllIlllllIllIllllIl;
    }
}

