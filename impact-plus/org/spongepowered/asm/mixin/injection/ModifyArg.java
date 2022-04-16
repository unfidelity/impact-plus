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
public @interface ModifyArg {
    public int index() default -1;

    public Slice slice() default @Slice;

    public At at();

    public boolean remap() default true;

    public int expect() default 1;

    public int allow() default -1;

    public String[] method();

    public int require() default -1;

    public String constraints() default "";
}

