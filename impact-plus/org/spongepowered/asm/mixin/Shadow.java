/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD, ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Shadow {
    public String[] aliases() default {};

    public boolean remap() default true;

    public String prefix() default "shadow$";
}

