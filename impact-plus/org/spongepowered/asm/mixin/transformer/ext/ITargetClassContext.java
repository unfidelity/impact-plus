/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.ext;

import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.transformer.ClassInfo;

public interface ITargetClassContext {
    public ClassNode getClassNode();

    public ClassInfo getClassInfo();
}

