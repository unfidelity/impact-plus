/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Slice;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface ModifyConstant {
    public Constant[] constant() default {};

    public String constraints() default "";

    public int expect() default 1;

    public Slice[] slice() default {};

    public int require() default -1;

    public boolean remap() default true;

    public String[] method();

    public int allow() default -1;
}

