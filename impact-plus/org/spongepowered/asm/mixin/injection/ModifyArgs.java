/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface ModifyArgs {
    public int allow() default -1;

    public int expect() default 1;

    public At at();

    public int require() default -1;

    public boolean remap() default true;

    public Slice slice() default @Slice;

    public String constraints() default "";

    public String[] method();
}

