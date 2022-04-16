/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.TYPE})
public @interface MixinInner {
    public String name();

    public String mixin();
}

