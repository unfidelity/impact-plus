/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.IInjectionPointContext;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

public abstract class SpecialMethodInfo
implements IInjectionPointContext {
    protected final /* synthetic */ MethodNode method;
    protected final /* synthetic */ ClassNode classNode;
    protected final /* synthetic */ MixinTargetContext mixin;
    protected final /* synthetic */ AnnotationNode annotation;

    @Override
    public final IMixinContext getContext() {
        SpecialMethodInfo lllllllllllllllllllIIllIIIIllIll;
        return lllllllllllllllllllIIllIIIIllIll.mixin;
    }

    public SpecialMethodInfo(MixinTargetContext lllllllllllllllllllIIllIIIlIIIll, MethodNode lllllllllllllllllllIIllIIIlIIIlI, AnnotationNode lllllllllllllllllllIIllIIIIlllIl) {
        SpecialMethodInfo lllllllllllllllllllIIllIIIlIIlII;
        lllllllllllllllllllIIllIIIlIIlII.mixin = lllllllllllllllllllIIllIIIlIIIll;
        lllllllllllllllllllIIllIIIlIIlII.method = lllllllllllllllllllIIllIIIlIIIlI;
        lllllllllllllllllllIIllIIIlIIlII.annotation = lllllllllllllllllllIIllIIIIlllIl;
        lllllllllllllllllllIIllIIIlIIlII.classNode = lllllllllllllllllllIIllIIIlIIIll.getTargetClassNode();
    }

    @Override
    public final AnnotationNode getAnnotation() {
        SpecialMethodInfo lllllllllllllllllllIIllIIIIllIII;
        return lllllllllllllllllllIIllIIIIllIII.annotation;
    }

    public final ClassNode getClassNode() {
        SpecialMethodInfo lllllllllllllllllllIIllIIIIlIlIl;
        return lllllllllllllllllllIIllIIIIlIlIl.classNode;
    }

    @Override
    public final MethodNode getMethod() {
        SpecialMethodInfo lllllllllllllllllllIIllIIIIlIIIl;
        return lllllllllllllllllllIIllIIIIlIIIl.method;
    }
}

