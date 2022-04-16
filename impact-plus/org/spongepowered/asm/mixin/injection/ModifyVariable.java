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

@Target(value={ElementType.METHOD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModifyVariable {
    public String constraints() default "";

    public boolean print() default false;

    public String[] method();

    public int expect() default 1;

    public int allow() default -1;

    public String[] name() default {};

    public int require() default -1;

    public int index() default -1;

    public Slice slice() default @Slice;

    public At at();

    public boolean remap() default true;

    public int ordinal() default -1;

    public boolean argsOnly() default false;
}
