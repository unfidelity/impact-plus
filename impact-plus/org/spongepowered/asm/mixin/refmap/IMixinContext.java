/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.refmap;

import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;

public interface IMixinContext {
    public IReferenceMapper getReferenceMapper();

    public Extensions getExtensions();

    public Target getTargetMethod(MethodNode var1);

    public IMixinInfo getMixin();

    public int getPriority();

    public boolean getOption(MixinEnvironment.Option var1);

    public String getClassRef();

    public String getTargetClassRef();
}

