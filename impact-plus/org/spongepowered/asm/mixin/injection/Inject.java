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
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface Inject {
    public String constraints() default "";

    public Slice[] slice() default {};

    public String[] method();

    public LocalCapture locals() default LocalCapture.NO_CAPTURE;

    public boolean remap() default true;

    public boolean cancellable() default false;

    public At[] at();

    public int allow() default -1;

    public String id() default "";

    public int require() default -1;

    public int expect() default 1;
}

