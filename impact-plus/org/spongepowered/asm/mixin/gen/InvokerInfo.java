/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.gen.AccessorInfo;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

public class InvokerInfo
extends AccessorInfo {
    @Override
    protected Type initTargetFieldType() {
        return null;
    }

    public InvokerInfo(MixinTargetContext llllllllllllllllllllIIIlIlIIIlIl, MethodNode llllllllllllllllllllIIIlIIllllIl) {
        super(llllllllllllllllllllIIIlIlIIIlIl, llllllllllllllllllllIIIlIIllllIl, Invoker.class);
        InvokerInfo llllllllllllllllllllIIIlIlIIIIIl;
    }

    @Override
    protected AccessorInfo.AccessorType initType() {
        return AccessorInfo.AccessorType.METHOD_PROXY;
    }

    @Override
    protected MemberInfo initTarget() {
        InvokerInfo llllllllllllllllllllIIIlIIlIllII;
        return new MemberInfo(llllllllllllllllllllIIIlIIlIllII.getTargetName(), null, llllllllllllllllllllIIIlIIlIllII.method.desc);
    }

    @Override
    public void locate() {
        InvokerInfo llllllllllllllllllllIIIlIIlIlIlI;
        llllllllllllllllllllIIIlIIlIlIlI.targetMethod = llllllllllllllllllllIIIlIIlIlIlI.findTargetMethod();
    }

    private MethodNode findTargetMethod() {
        InvokerInfo llllllllllllllllllllIIIlIIlIIllI;
        return llllllllllllllllllllIIIlIIlIIllI.findTarget(llllllllllllllllllllIIIlIIlIIllI.classNode.methods);
    }
}

